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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URLEncoder;
import java.lang.reflect.Modifier;
import java.lang.StringBuilder;
import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class APIRequest<T extends APINode> {

  protected APIContext context;
  protected boolean useVideoEndpoint = false;
  protected String nodeId;
  protected String endpoint;
  protected String method;
  protected List<String> paramNames;
  protected ResponseParser<T> parser;
  protected Map<String, Object> params = new HashMap<String, Object>();
  protected List<String> returnFields;
  private APIResponse lastResponse = null;

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
    lastResponse = parseResponse(executeInternal(extraParams));
    return lastResponse;
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

  protected String executeInternal() throws APIException {
    return executeInternal(null);
  }

  protected String executeInternal(Map<String, Object> extraParams) throws APIException {
    // extraParams are one-time params for this call,
    // so that the APIRequest can be reused later on.
    String response = null;
    try {
      context.log("========Start of API Call========");
      response = context.getRequestExecutor().execute(method, getApiUrl(), getAllParams(extraParams), context);
      context.log("Response:");
      context.log(response);
      context.log("========End of API Call========");
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

  protected void requestFieldInternal(String field, boolean value) {
    if (returnFields == null) returnFields = new ArrayList<String>();
    if (value == true && !returnFields.contains(field)) returnFields.add(field);
    else returnFields.remove(field);
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

  private String getApiUrl() {
    String endpointBas = useVideoEndpoint ? context.getVideoEndpointBase() : context.getEndpointBase();
    return endpointBas + "/" + context.getVersion() + "/" + nodeId + endpoint;
  }

  private String joinStringList(List<String> list) {
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
    public APINodeList<T> parseResponse(String response, APIContext context, APIRequest<T> request)  throws APIException.MalformedResponseException;
  }
}
