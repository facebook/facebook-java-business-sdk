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

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

import com.google.gson.Gson;

public class APIRequest<T extends APINode> {
  protected APIContext context;
  protected String nodeId;
  protected String endpoint;
  protected String method;
  protected List<String> paramNames;
  protected ResponseParser<T> parser;
  protected Map<String, Object> params = new HashMap<String, Object>();
  protected List<String> returnFields;
  private APIResponse lastResponse = null;
  public static final String USER_AGENT = APIConfig.USER_AGENT;
  public static Map<String, String> fileToContentTypeMap = new HashMap<String, String>();
  static {
    fileToContentTypeMap.put(".atom", "application/atom+xml");
    fileToContentTypeMap.put(".rss", "application/rss+xml");
    fileToContentTypeMap.put(".xml", "application/xml");
    fileToContentTypeMap.put(".csv", "text/csv");
    fileToContentTypeMap.put(".txt", "text/plain");
  }

  public APIRequest (APIContext context, String nodeId, String endpoint, String method) {
    this(context, nodeId, endpoint, method, null, null);
  }

  public APIRequest (APIContext context, String nodeId, String endpoint, String method, ResponseParser<T> parser) {
    this(context, nodeId, endpoint, method, null, parser);
  }

  public APIRequest (APIContext context, String nodeId, String endpoint, String method, List<String> paramNames) {
    this(context, nodeId, endpoint, method, paramNames, null);
  }

  public APIRequest (APIContext context, String nodeId, String endpoint, String method, List<String> paramNames, ResponseParser<T> parser) {
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

  public APIResponse parseResponse(String response) throws APIException {
    if (parser != null) {
      return parser.parseResponse(response, context, this);
    } else {
      return APINode.parseResponse(response, context, new APIRequest<APINode>(context, nodeId, endpoint, method, paramNames));
    }
  };

  public APIResponse execute() throws APIException {
    return execute(new HashMap<String, Object>());
  };

  public APIResponse execute(Map<String, Object> extraParams) throws APIException {
    lastResponse = parseResponse(callInternal(extraParams));
    return lastResponse;
  };

  public APIRequest setParam(String param, Object value) {
    setParamInternal(param, value);
    return this;
  }

  public APIRequest setParams(Map<String, Object> params) {
    setParamsInternal(params);
    return this;
  }

  public APIRequest requestFields (List<String> fields) {
    return this.requestFields(fields, true);
  }

  public APIRequest requestFields (List<String> fields, boolean value) {
    for (String field : fields) {
      this.requestField(field, value);
    }
    return this;
  }

  public APIRequest requestField (String field) {
    this.requestField(field, true);
    return this;
  }

  public APIRequest requestField (String field, boolean value) {
    this.requestFieldInternal(field, value);
    return this;
  }

  protected String callInternal() throws APIException {
    return callInternal(null);
  }

  protected String callInternal(Map<String, Object> extraParams) throws APIException {
    // extraParams are one-time params for this call,
    // so that the APIRequest can be reused later on.
    String response = null;
    try {
      context.log("========Start of API Call========");
      if("GET".equals(method)) response = sendGet(getApiUrl(), getAllParams(extraParams), context);
      else if("POST".equals(method)) response = sendPost(getApiUrl(), getAllParams(extraParams), context);
      else if("DELETE".equals(method)) response = sendDelete(getApiUrl(), getAllParams(extraParams), context);
      else throw new APIException(new IllegalArgumentException("Unsupported http method. Currently only GET, POST, and DELETE are supported"));
      context.log("Response:");
      context.log(response);
      context.log("========End of API Call========");
    } catch (IOException e) {
      throw new APIException(e);
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

  protected void requestFieldInternal(String field, boolean value) {
    if (returnFields == null) returnFields = new ArrayList<String>();
    if (value == true && !returnFields.contains(field)) returnFields.add(field);
    else returnFields.remove(field);
  }

  // HTTP GET request
  public static String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {

    StringBuilder urlString = new StringBuilder(apiUrl);
    boolean firstEntry = true;
    for(Map.Entry entry : allParams.entrySet()) {
      urlString.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(toString(entry.getValue()), "UTF-8"));
      firstEntry = false;
    }
    URL url = new URL(urlString.toString());
    context.log("Request:");
    context.log("GET: " + url.toString());
    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

    return readResponse(con);

  }

  // HTTP POST request
  public static String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
    String boundary = "--------------------------" + new Random().nextLong();
    URL url = new URL(apiUrl);
    context.log("Post: " + url.toString());
    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
    con.setDoOutput(true);

    int contentLength = getContentLength(allParams, boundary, context);

    con.setRequestProperty("Content-Length", "" + contentLength);

    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    byte[] buffer = new byte[1024];
    int count = 0;
    for(Map.Entry entry : allParams.entrySet()) {
      writeStringInUTF8Bytes(wr, "--" + boundary + "\r\n");
      if(entry.getValue() instanceof File) {
        File file = (File) entry.getValue();
        String contentType = getContentTypeForFile(file);
        writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
        if (contentType != null) {
          writeStringInUTF8Bytes(wr, "Content-Type: " + contentType + "\r\n");
        }
        writeStringInUTF8Bytes(wr, "\r\n");
        FileInputStream fileInputStream = new FileInputStream(file);
        while ((count = fileInputStream.read(buffer)) >= 0) {
          wr.write(buffer, 0, count);
        }
        writeStringInUTF8Bytes(wr, "\r\n");
        fileInputStream.close();
      } else {
        writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
        writeStringInUTF8Bytes(wr, toString(entry.getValue()));
        writeStringInUTF8Bytes(wr, "\r\n");
      }
    }
    writeStringInUTF8Bytes(wr, "--" + boundary + "--\r\n");

    wr.flush();
    wr.close();

    return readResponse(con);
  }

  public static String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {

    StringBuilder urlString = new StringBuilder(apiUrl);
    boolean firstEntry = true;
    for(Map.Entry entry : allParams.entrySet()) {
      urlString.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(toString(entry.getValue()), "UTF-8"));
      firstEntry = false;
    }
    URL url = new URL(urlString.toString());
    context.log("Delete: " + url.toString());
    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

    con.setRequestMethod("DELETE");
    con.setRequestProperty("User-Agent", USER_AGENT);

    return readResponse(con);
  }

  private String getApiUrl() {
    return context.getEndpointBase() + "/" + context.getVersion() + "/" + nodeId + endpoint;
  }

  private String joinStringList(List<String> list) {
    if (list == null) return "";
    StringBuilder result = new StringBuilder();
    boolean isFirst = true;
    for(String s : list) {
      if (!isFirst) result.append(",");
      result.append(s);
      isFirst = false;
    }
    return result.toString();
  }

  private Map<String, Object> getAllParams(Map<String, Object> extraParams) {
    Map<String, Object> allParams = new HashMap<String, Object>(params);
    if (extraParams != null) allParams.putAll(extraParams);
    allParams.put("access_token", context.getAccessToken());
    if (context.hasAppSecret()) {
      allParams.put("appsecret_proof", context.getAppSecretProof());
    }
    if (returnFields != null) allParams.put("fields", joinStringList(returnFields));
    return allParams;
  }

  private static String readResponse(HttpsURLConnection con) throws APIException, IOException {
    try {
      int responseCode = con.getResponseCode();

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      return response.toString();
    } catch (Exception e) {

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      throw new APIException(response.toString(), e);
    }
  }

  private static String getContentTypeForFile (File file) {
    for(Map.Entry entry : fileToContentTypeMap.entrySet()) {
      if (file.getName().endsWith((String)entry.getKey())) {
        return (String) entry.getValue();
      }
    }
    return null;
  }

  private static int getContentLength(Map<String, Object> allParams, String boundary, APIContext context) throws IOException {
    int contentLength = 0;
    for(Map.Entry entry : allParams.entrySet()) {
      contentLength += ("--" + boundary + "\r\n").length();
      if(entry.getValue() instanceof File) {
        File file = (File) entry.getValue();
        String contentType = getContentTypeForFile(file);
        contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
        if (contentType != null) {
          contentLength += getLengthAndLog(context, "Content-Type: " + contentType + "\r\n");
        }
        contentLength += getLengthAndLog(context, "\r\n");
        contentLength += file.length();
        contentLength += getLengthAndLog(context, "\r\n");
      } else {
        contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
        contentLength += getLengthAndLog(context, toString(entry.getValue()));
        contentLength += getLengthAndLog(context, "\r\n");
      }
    }
    contentLength += getLengthAndLog(context, "--" + boundary + "--\r\n");
    return contentLength;
  }

  private static int getLengthAndLog(APIContext context, String input) throws IOException {
    context.log(input);
    return input.getBytes("UTF-8").length;
  }

  private static String toString(Object input) {
    if (input == null) {
      return "null";
    } else if (input instanceof Map) {
      Gson gson = new Gson();
      return gson.toJson((Map)input);
    } else if (input instanceof List) {
      Gson gson = new Gson();
      return gson.toJson((List)input);
    } else {
      return input.toString();
    }
  }

  private static void writeStringInUTF8Bytes(DataOutputStream wr, String input) throws IOException {
    wr.write(input.getBytes("UTF-8"));
  }

  public APIRequest addToBatch(BatchRequest batch) {
    batch.addRequest(this);
    return this;
  }

  public APIRequest addToBatch(BatchRequest batch, String name) {
    batch.addRequest(name, this);
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
      for(Map.Entry entry : allParams.entrySet()) {
        if(entry.getValue() instanceof File) {
          info.files.put((String)entry.getKey(), (File) entry.getValue());
        } else {
          body.append((firstEntry ? "" : "&") + entry.getKey() + "=" + toString(entry.getValue()));
          firstEntry = false;
        }
      }
      info.body = body.toString();
    } else {
      boolean firstEntry = true;
      for(Map.Entry entry : allParams.entrySet()) {
        relativeUrl.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(toString(entry.getValue()), "UTF-8"));
        firstEntry = false;
      }
      info.relativeUrl = relativeUrl.toString();
    }
    return info;
  }

  public static interface ResponseParser<T extends APINode> {
    public APINodeList<T> parseResponse(String response, APIContext context, APIRequest<T> request);
  }

}
