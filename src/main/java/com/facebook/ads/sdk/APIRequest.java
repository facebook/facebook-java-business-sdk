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

abstract public class APIRequest<T> {
  protected APIContext context;
  protected String nodeId;
  protected String endpoint;
  protected String method;
  protected List<String> paramNames;
  protected Map<String, Object> params;
  protected List<String> returnFields;
  public static final String USER_AGENT = APIConfig.USER_AGENT;
  public static Map<String, String> fileToContentTypeMap = new HashMap<String, String>();
  static {
    fileToContentTypeMap.put(".atom", "application/atom+xml");
    fileToContentTypeMap.put(".rss", "application/rss+xml");
    fileToContentTypeMap.put(".xml", "application/xml");
    fileToContentTypeMap.put(".csv", "text/csv");
    fileToContentTypeMap.put(".txt", "text/plain");
  }

  public APIRequest (APIContext context, String nodeId, String endpoint, String method, List<String> paramNames) {
    this.context = context;
    this.nodeId = nodeId;
    this.endpoint = endpoint;
    this.method = method;
    this.paramNames = paramNames;
  }

  abstract protected IAPINodeOrNodeList call() throws APIException;
  abstract protected IAPINodeOrNodeList call(Map<String, Object> extraParams) throws APIException;

  protected String callInternal() throws APIException {
    return callInternal(null);
  }

  protected String callInternal(Map<String, Object> extraParams) throws APIException {
    // extraParams are one-time params for this call,
    // so that the APIRequest can be reused later on.
    String response = null;
    try {
      context.log("========Start of API Call========");
      if("GET" == method) response = sendGet(getAllParams(extraParams));
      else if("POST" == method) response = sendPost(getAllParams(extraParams));
      else if("DELETE" == method) response = sendDelete(getAllParams(extraParams));
      else throw new APIException();
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
    if (params == null) params = new HashMap<String, Object>();
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
  protected String sendGet(Map<String, Object> allParams) throws APIException, IOException {

    StringBuilder urlString = new StringBuilder(getApiUrl());
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
  protected String sendPost(Map<String, Object> allParams) throws APIException, IOException {
    String boundary = "--------------------------" + new Random().nextLong();
    List<File> files = new ArrayList<File>();
    URL url = new URL(getApiUrl());
    context.log("Post: " + url.toString());
    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
    con.setDoOutput(true);

    int contentLength = getContentLength(allParams, boundary);

    con.setRequestProperty("Content-Length", "" + contentLength);

    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    byte[] buffer = new byte[1024];
    int count = 0;
    for(Map.Entry entry : allParams.entrySet()) {
      wr.writeBytes("--" + boundary + "\r\n");
      if(entry.getValue() instanceof File) {
        File file = (File) entry.getValue();
        String contentType = getContentTypeForFile(file);
        wr.writeBytes("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
        if (contentType != null) {
          wr.writeBytes("Content-Type: " + contentType + "\r\n");
        }
        wr.writeBytes("\r\n");
        FileInputStream fileInputStream = new FileInputStream(file);
        while ((count = fileInputStream.read(buffer)) >= 0) {
          wr.write(buffer, 0, count);
        }
        wr.writeBytes("\r\n");
        fileInputStream.close();
      } else {
        wr.writeBytes("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
        wr.writeBytes(toString(entry.getValue()));
        wr.writeBytes("\r\n");
      }
    }
    wr.writeBytes("--" + boundary + "--\r\n");

    wr.flush();
    wr.close();

    return readResponse(con);
  }

  protected String sendDelete(Map<String, Object> allParams) throws APIException, IOException {

    StringBuilder urlString = new StringBuilder(getApiUrl());
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
    Map<String, Object> allParams;
    if (params != null) allParams = new HashMap<String, Object>(params);
    else allParams = new HashMap<String, Object>();
    if (extraParams != null) allParams.putAll(extraParams);
    allParams.put("access_token", context.getAuthToken());
    if (returnFields != null) allParams.put("fields", joinStringList(returnFields));
    return allParams;
  }

  private String readResponse(HttpsURLConnection con) throws APIException, IOException {
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

  private int getContentLength(Map<String, Object> allParams, String boundary) {
    int contentLength = 0;
    for(Map.Entry entry : allParams.entrySet()) {
      contentLength += ("--" + boundary + "\r\n").length();
      if(entry.getValue() instanceof File) {
        File file = (File) entry.getValue();
        String contentType = getContentTypeForFile(file);
        contentLength += getLength("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
        if (contentType != null) {
          contentLength += getLength("Content-Type: " + contentType + "\r\n");
        }
        contentLength += getLength("\r\n");
        contentLength += file.length();
        contentLength += getLength("\r\n");
      } else {
        contentLength += getLength("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"");
        contentLength += getLength(toString(entry.getValue()));
        contentLength += getLength("\r\n");
      }
    }
    contentLength += getLength("--" + boundary + "--\r\n");
    return contentLength;
  }

  private int getLength(String input) {
    context.log(input);
    return input.length();
  }

  private static String toString(Object input) {
    if (input == null) {
      return "null";
    } else if (input instanceof Map) {
      Gson gson = new Gson();
      return gson.toJson((Map)input);
    } else {
      return input.toString();
    }
  }
}
