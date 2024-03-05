/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */
package com.facebook.ads.sdk;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.lang.reflect.Modifier;
import java.lang.StringBuilder;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.StandardCharsets;

public class APIRequest<T extends APINode> {

  public static final String USER_AGENT = APIConfig.USER_AGENT;

  private static IRequestExecutor executor = new DefaultRequestExecutor();
  private static IAsyncRequestExecutor asyncExecutor = new DefaultAsyncRequestExecutor();

  protected APIContext context;
  protected boolean useVideoEndpoint = false;
  protected String nodeId;
  protected String endpoint;
  protected String method;
  protected List<String> paramNames;
  protected ResponseParser<T> parser;
  protected Map<String, Object> params = new HashMap<String, Object>();
  protected List<String> returnFields;
  private String overrideUrl;
  private APIResponse lastResponse = null;

  public static void changeRequestExecutor(IRequestExecutor newExecutor) {
    executor = newExecutor;
  }

  public static void changeAsyncRequestExecutor(
    IAsyncRequestExecutor newExecutor
  ) {
    asyncExecutor = newExecutor;
  }

  public static IRequestExecutor getExecutor() {
    return executor;
  }

  public static IAsyncRequestExecutor getAsyncExecutor() {
    return asyncExecutor;
  }

  public APIRequest(APIContext context, String nodeId, String endpoint, String method) {
    this(context, nodeId, endpoint, method, null, null);
  }

  public APIRequest(APIContext context, String nodeId, String endpoint, String method, ResponseParser<T> parser) {
    this(context, nodeId, endpoint, method, null, parser);
  }

  public APIRequest(APIContext context, String nodeId, String endpoint, String method, List<String> paramNames) {
    this(context, nodeId, endpoint, method, paramNames, null);
  }

  public APIRequest(APIContext context, String nodeId, String endpoint, String method, List<String> paramNames, ResponseParser<T> parser) {
    this.context = context;
    this.nodeId = nodeId;
    this.endpoint = endpoint;
    this.method = method;
    this.paramNames = paramNames;
    this.parser = parser;
  }

  public APIResponse getLastResponse() {
    return lastResponse;
  };

  public APIResponse parseResponse(String response, String header) throws APIException {
    if (parser != null) {
      return parser.parseResponse(response, context, this, header);
    } else {
      return APINode.parseResponse(response, context, new APIRequest<APINode>(context, nodeId, endpoint, method, paramNames), header);
    }
  };

  public APIResponse execute() throws APIException {
    return execute(new HashMap<String, Object>());
  };

  public APIResponse execute(Map<String, Object> extraParams) throws APIException {
    ResponseWrapper rw = executeInternal(extraParams);
    lastResponse = parseResponse(rw.getBody(), rw.getHeader());
    return lastResponse;
  };

  public ListenableFuture<APIResponse> executeAsyncBase() throws APIException {
    return executeAsyncBase(new HashMap<String, Object>());
  };

  public ListenableFuture<APIResponse> executeAsyncBase(Map<String, Object> extraParams) throws APIException {
    return Futures.transform(
      executeAsyncInternal(extraParams),
      new Function<ResponseWrapper, APIResponse>() {
         public APIResponse apply(ResponseWrapper result) {
           try {
             return APIRequest.this.parseResponse(result.getBody(), result.getHeader());
           } catch (Exception e) {
             throw new RuntimeException(e);
           }
         }
       },
       MoreExecutors.directExecutor()
    );
  };

  public APIRequest<T> setParam(String param, Object value) {
    setParamInternal(param, value);
    return this;
  }

  public APIRequest setParams(Map<String, Object> params) {
    setParamsInternal(params);
    return this;
  }

  public APIRequest requestFields(List<String> fields) {
    return this.requestFields(fields, true);
  }

  public APIRequest requestFields(List<String> fields, boolean value) {
    for (String field : fields) {
      this.requestField(field, value);
    }
    return this;
  }

  public APIRequest requestField(String field) {
    this.requestField(field, true);
    return this;
  }

  public APIRequest requestField(String field, boolean value) {
    this.requestFieldInternal(field, value);
    return this;
  }

  public APIRequest setUseVideoEndpoint(boolean useVideoEndpoint) {
    this.useVideoEndpoint = useVideoEndpoint;
    return this;
  }

  protected ResponseWrapper executeInternal() throws APIException {
    return executeInternal(null);
  }

  protected ResponseWrapper executeInternal(Map<String, Object> extraParams) throws APIException {
    // extraParams are one-time params for this call,
    // so that the APIRequest can be reused later on.
    ResponseWrapper response = null;
    try {
      context.log("========Start of API Call========");
      response = executor.execute(method, getApiUrl(), getAllParams(extraParams), context);
      context.log("Response:");
      context.log(response.getBody());
      context.log("========End of API Call========");
    } catch(IOException e) {
      throw new APIException.FailedRequestException(e);
    }
    return response;
  }

  protected ListenableFuture<ResponseWrapper> executeAsyncInternal() throws APIException {
    return executeAsyncInternal(null);
  }

  protected ListenableFuture<ResponseWrapper> executeAsyncInternal(Map<String, Object> extraParams) throws APIException {
    // extraParams are one-time params for this call,
    // so that the APIRequest can be reused later on.
    ListenableFuture<ResponseWrapper> response = null;
    try {
      context.log("========Start of Async API Call========");
      response = asyncExecutor.execute(method, getApiUrl(), getAllParams(extraParams), context);
      Futures.addCallback(
        response,
        new FutureCallback<ResponseWrapper>() {
          public void onSuccess(ResponseWrapper result) {
            context.log("Response:");
            context.log(result.getBody());
            context.log("========End of API Call========");
          }
          public void onFailure(Throwable t) {
          }
        },
        MoreExecutors.directExecutor()
      );
    } catch(IOException e) {
      throw new APIException.FailedRequestException(e);
    }
    return response;
  }

  public APIContext getContext() {
    return this.context;
  }

  public void setContext(APIContext context) {
    this.context = context;
  }

  protected void setParamInternal(String param, Object value) {
    params.put(param, value);
  }

  protected void setParamsInternal(Map<String, Object> params) {
    this.params = params;
  }

  /* This is a hacky way to implement pagination
   * In current implementaion, request is based on nodeId/endpoint/param
   * However in case we have paging, the previous/next returns the overall
   * url already. In that case, we don't want to parse and reconstruct the
   * url. Thus add this override to use the returned url directly.
   */
  public void setOverrideUrl(String url) {
    this.overrideUrl = url;
  }

  protected void requestFieldInternal(String field, boolean addField) {
    if (returnFields == null) returnFields = new ArrayList<String>();
    if (addField) {
      if(!returnFields.contains(field)) returnFields.add(field);
    } else {
      returnFields.remove(field);
    }
  }

  private Map<String, Object> getAllParams(Map<String, Object> extraParams) {
    if (overrideUrl != null) {
      return new HashMap<String, Object>();
    }
    Map<String, Object> allParams = new HashMap<String, Object>(params);
    if (extraParams != null) allParams.putAll(extraParams);
    allParams.put("access_token", context.getAccessToken());
    if (context.hasAppSecret()) {
      allParams.put("appsecret_proof", context.getAppSecretProof());
    }
    if (returnFields != null) allParams.put("fields", joinStringList(returnFields));
    return allParams;
  }

  private static ResponseWrapper readResponse(HttpsURLConnection con) throws APIException, IOException {
    try {
      int responseCode = con.getResponseCode();

      String header = convertToString(con.getHeaderFields());
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      return new ResponseWrapper(response.toString(), header);
    } catch(Exception e) {
      InputStream errorStream = con.getErrorStream();
      StringBuilder response = new StringBuilder();
      if (errorStream != null) {
        BufferedReader in = new BufferedReader(new InputStreamReader(errorStream));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();
      }
      throw new APIException.FailedRequestException(
        convertToString(con.getHeaderFields()), response.toString(), e
      );
    }
  }

  private String getApiUrl() {
    if (overrideUrl != null) {
      return overrideUrl;
    }
    String endpointBas = useVideoEndpoint ? context.getVideoEndpointBase() : context.getEndpointBase();
    return endpointBas + "/" + context.getVersion() + "/" + nodeId + endpoint;
  }

  public static String joinStringList(List<String> list) {
    if (list == null) return "";
    StringBuilder result = new StringBuilder();
    boolean isFirst = true;
    for (String s : list) {
      if (!isFirst) result.append(",");
      result.append(s);
      isFirst = false;
    }
    return result.toString();
  }

  private static String convertToString(Object input) {
    if (input == null) {
      return "null";
    } else if (input instanceof Map) {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithModifiers(Modifier.STATIC)
          .excludeFieldsWithModifiers(Modifier.PROTECTED)
          .disableHtmlEscaping()
          .create();
      return gson.toJson((Map)input);
    } else if (input instanceof List) {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithModifiers(Modifier.STATIC)
          .excludeFieldsWithModifiers(Modifier.PROTECTED)
          .disableHtmlEscaping()
          .create();
      return gson.toJson((List)input);
    } else {
      return input.toString();
    }
  }

  public APIRequest addToBatch(BatchRequest batch) {
    batch.addRequest(this);
    return this;
  }

  public APIRequest addToBatch(BatchRequest batch, String name) {
    batch.addRequest(name, this);
    return this;
  }

  public APIRequest addToBatch(BatchRequest batch, String name, boolean omitResponseOnSuccess) {
    batch.addRequest(name, omitResponseOnSuccess, this);
    return this;
  }

  BatchRequest.BatchModeRequestInfo getBatchModeRequestInfo() throws IOException {
    BatchRequest.BatchModeRequestInfo info = new BatchRequest.BatchModeRequestInfo();
    Map<String, Object> allParams = new HashMap<String, Object>(params);
    if (returnFields != null) allParams.put("fields", joinStringList(returnFields));
    info.method = this.method;
    StringBuilder relativeUrl = new StringBuilder(context.getVersion() + "/" + nodeId + endpoint);
    if (this.method.equals("POST")) {
      info.files = new HashMap<String, File>();
      info.relativeUrl = relativeUrl.toString();
      StringBuilder body = new StringBuilder();
      boolean firstEntry = true;
      for (Map.Entry entry : allParams.entrySet()) {
        if (entry.getValue() instanceof File) {
          info.files.put((String)entry.getKey(), (File) entry.getValue());
        } else {
          body.append((firstEntry ? "" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(convertToString(entry.getValue()), "UTF-8"));
          firstEntry = false;
        }
      }
      info.body = body.toString();
    } else {
      boolean firstEntry = true;
      for (Map.Entry entry : allParams.entrySet()) {
        relativeUrl.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(convertToString(entry.getValue()), "UTF-8"));
        firstEntry = false;
      }
      info.relativeUrl = relativeUrl.toString();
    }
    return info;
  }

  public static interface ResponseParser<T extends APINode> {
    public APINodeList<T> parseResponse(String response, APIContext context, APIRequest<T> request, String header)  throws APIException.MalformedResponseException;
  }

  public static interface IRequestExecutor {
    public ResponseWrapper execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ResponseWrapper sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ResponseWrapper sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ResponseWrapper sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
  }

  public static interface IAsyncRequestExecutor {
    public ListenableFuture<ResponseWrapper> execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ListenableFuture<ResponseWrapper> sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ListenableFuture<ResponseWrapper> sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    public ListenableFuture<ResponseWrapper> sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
  }

  public static class RequestHelper {
    private static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static Map<String, String> fileToContentTypeMap = new HashMap<String, String>();
    static {
      fileToContentTypeMap.put(".atom", "application/atom+xml");
      fileToContentTypeMap.put(".rss", "application/rss+xml");
      fileToContentTypeMap.put(".xml", "application/xml");
      fileToContentTypeMap.put(".csv", "text/csv");
      fileToContentTypeMap.put(".txt", "text/plain");
    }

    public static String getContentTypeForFile(File file) {
      String contentType = fileToContentTypeMap.get(getFileExtension(file));

      if (contentType != null) return contentType;

      try {
        contentType = Files.probeContentType(file.toPath());
      } catch (IOException ignored) {
      }

      return contentType != null ? contentType : DEFAULT_CONTENT_TYPE;
    }

    private static String getFileExtension(File file) {
      String fileName = file.getName();
      int index = fileName.lastIndexOf('.');
      if (index == -1) return "";
      return fileName.substring(index, fileName.length());
    }

    public static int getContentLength(Map<String, Object> allParams, String boundary, APIContext context) throws IOException {
      int contentLength = 0;
      for (Map.Entry entry : allParams.entrySet()) {
        contentLength += ("--" + boundary + "\r\n").length();
        if (entry.getValue() instanceof File) {
          File file = (File) entry.getValue();
          String contentType = getContentTypeForFile(file);
          contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
          if (contentType != null) {
            contentLength += getLengthAndLog(context, "Content-Type: " + contentType + "\r\n");
          }
          contentLength += getLengthAndLog(context, "\r\n");
          contentLength += file.length();
          contentLength += getLengthAndLog(context, "\r\n");
        } else if (entry.getValue() instanceof byte[]) {
          byte[] bytes = (byte[]) entry.getValue();
          contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + "chunkfile" + "\"\r\n");
          contentLength += bytes.length;
          contentLength += getLengthAndLog(context, "\r\n");
        } else {
          contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
          contentLength += getLengthAndLog(context, convertToString(entry.getValue()));
          contentLength += getLengthAndLog(context, "\r\n");
        }
      }
      contentLength += getLengthAndLog(context, "--" + boundary + "--\r\n");
      return contentLength;
    }

    private static int getLengthAndLog(APIContext context, String input) throws IOException {
      context.log(input);
      return input.getBytes(StandardCharsets.UTF_8).length;
    }

    public static String constructUrlString(String apiUrl, Map<String, Object> allParams) throws IOException {
      StringBuilder urlString = new StringBuilder(apiUrl);
      boolean firstEntry = true;
      for (Map.Entry entry : allParams.entrySet()) {
        urlString.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(convertToString(entry.getValue()), "UTF-8"));
        firstEntry = false;
      }
      return urlString.toString();
    }

    public static ListenableFuture<ResponseWrapper> invoke(okhttp3.OkHttpClient client, okhttp3.Request request) {
      final SettableFuture<ResponseWrapper> future = SettableFuture.create();
      client.newCall(request).enqueue(
        new okhttp3.Callback() {
            @Override
            public void onFailure(final okhttp3.Call call, IOException e) {
                future.setException(
                  new APIException.FailedRequestException(e)
                );
            }

            @Override
            public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {
                future.set(new ResponseWrapper(response.body().string(), convertToString(response.headers())));
            }
      });
      return future;
    }
  }


  public static class DefaultRequestExecutor implements IRequestExecutor {

    public ResponseWrapper execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      if ("GET".equals(method)) return sendGet(apiUrl, allParams, context);
      else if ("POST".equals(method)) return sendPost(apiUrl, allParams, context);
      else if ("DELETE".equals(method)) return sendDelete(apiUrl, allParams, context);
      else throw new IllegalArgumentException("Unsupported http method. Currently only GET, POST, and DELETE are supported");
    }

    public ResponseWrapper sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      URL url = new URL(RequestHelper.constructUrlString(apiUrl, allParams));
      context.log("Request:");
      context.log("GET: " + url.toString());
      HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

      return readResponse(con);
    }

    public ResponseWrapper sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      String boundary = "--------------------------" + new Random().nextLong();
      URL url = new URL(apiUrl);
      context.log("Post: " + url.toString());
      HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
      con.setDoOutput(true);

      int contentLength = RequestHelper.getContentLength(allParams, boundary, context);

      con.setRequestProperty("Content-Length", "" + contentLength);

      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      for (Map.Entry entry : allParams.entrySet()) {
        writeStringInUTF8Bytes(wr, "--" + boundary + "\r\n");
        if (entry.getValue() instanceof File) {
          File file = (File) entry.getValue();
          String contentType = RequestHelper.getContentTypeForFile(file);
          writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
          if (contentType != null) {
            writeStringInUTF8Bytes(wr, "Content-Type: " + contentType + "\r\n");
          }
          writeStringInUTF8Bytes(wr, "\r\n");
          FileInputStream fileInputStream = new FileInputStream(file);
          byte[] buffer = new byte[1024];
          int count = 0;
          while ((count = fileInputStream.read(buffer)) >= 0) {
            wr.write(buffer, 0, count);
          }
          writeStringInUTF8Bytes(wr, "\r\n");
          fileInputStream.close();
        } else if (entry.getValue() instanceof byte[]) {
          byte[] bytes = (byte[]) entry.getValue();
          writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + "chunkfile" + "\"\r\n\r\n");
          wr.write(bytes, 0, bytes.length);
          writeStringInUTF8Bytes(wr, "\r\n");
        } else {
          writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
          writeStringInUTF8Bytes(wr, convertToString(entry.getValue()));
          writeStringInUTF8Bytes(wr, "\r\n");
        }
      }
      writeStringInUTF8Bytes(wr, "--" + boundary + "--\r\n");

      wr.flush();
      wr.close();

      return readResponse(con);
    }

    public ResponseWrapper sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      URL url = new URL(RequestHelper.constructUrlString(apiUrl, allParams));
      context.log("Delete: " + url.toString());
      HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

      con.setRequestMethod("DELETE");
      con.setRequestProperty("User-Agent", USER_AGENT);

      return readResponse(con);
    }

    private static void writeStringInUTF8Bytes(DataOutputStream wr, String input) throws IOException {
      wr.write(input.getBytes(StandardCharsets.UTF_8));
    }
  }

  public static class DefaultAsyncRequestExecutor implements IAsyncRequestExecutor {
    static okhttp3.OkHttpClient client = null;
    static void init() {
      client = new okhttp3.OkHttpClient();
    }
    static {
      init();
    }

    public ListenableFuture<ResponseWrapper> execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      if ("GET".equals(method)) return sendGet(apiUrl, allParams, context);
      else if ("POST".equals(method)) return sendPost(apiUrl, allParams, context);
      else if ("DELETE".equals(method)) return sendDelete(apiUrl, allParams, context);
      else throw new IllegalArgumentException("Unsupported http method. Currently only GET, POST, and DELETE are supported");
    }

    public ListenableFuture<ResponseWrapper> sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      context.log("Request:");
      context.log("GET: " + apiUrl.toString());
      okhttp3.Request request = new okhttp3.Request.Builder()
          .url(RequestHelper.constructUrlString(apiUrl, allParams))
          .get()
          .header("User-Agent", USER_AGENT)
          .header("Content-Type","application/x-www-form-urlencoded")
          .build();

      return RequestHelper.invoke(client, request);
    }

    public ListenableFuture<ResponseWrapper> sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      String boundary = "--------------------------" + new Random().nextLong();
      okhttp3.MultipartBody.Builder builder = new okhttp3.MultipartBody.Builder(boundary)
          .setType(okhttp3.MultipartBody.FORM);
      for (Map.Entry<String, Object> entry : allParams.entrySet()) {
        if (entry.getValue() instanceof File) {
          File file = (File) entry.getValue();
          String contentType = RequestHelper.getContentTypeForFile(file);
          builder.addFormDataPart(
            entry.getKey(),
            file.getName(),
            okhttp3.RequestBody.create(okhttp3.MediaType.parse(contentType), file)
          );
        } else if (entry.getValue() instanceof byte[]) {
          builder.addFormDataPart(
            entry.getKey(),
            "chunkfile",
            okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/octet-stream"), (byte[])entry.getValue())
          );
        } else {
          builder.addFormDataPart(
            entry.getKey(),
            convertToString(entry.getValue())
          );
        }
      }
      okhttp3.Request request = new okhttp3.Request
        .Builder()
        .url(apiUrl)
        .post(builder.build())
        .header("User-Agent", USER_AGENT)
        .build();
      return RequestHelper.invoke(client, request);
    }

    public ListenableFuture<ResponseWrapper> sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
      URL url = new URL(RequestHelper.constructUrlString(apiUrl, allParams));
      context.log("Delete: " + url.toString());
      okhttp3.Request request = new okhttp3.Request.Builder()
          .url(RequestHelper.constructUrlString(apiUrl, allParams))
          .delete()
          .header("User-Agent", USER_AGENT)
          .build();

      return RequestHelper.invoke(client, request);
    }
  }

  public static class ResponseWrapper {
    private String body;
    private String header;

    public ResponseWrapper(String body, String header) {
      this.body = body;
      this.header = header;
    }

    public String getBody() {
      return this.body;
    }

    public String getHeader() {
      return this.header;
    }
  }
}
