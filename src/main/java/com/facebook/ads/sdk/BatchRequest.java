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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.net.HttpURLConnection;
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
import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.google.gson.*;

public class BatchRequest {
  List<Pair> requests = new ArrayList<Pair>();
  APIContext context = null;

  public BatchRequest(APIContext context) {
    this.context = context;
  }

  public BatchRequest addRequest(APIRequest request) {
    String name = "Request" + requests.size();
    addRequest(name, request);
    return this;
  }

  public BatchRequest addRequest(String name, APIRequest request) {
    if (request == null) {
      throw new IllegalArgumentException("Cannot add null into batch request!");
    }
    this.requests.add(new Pair(name, request));
    return this;
  }

  public BatchRequest addRequest(String name, boolean omitResponseOnSuccess, APIRequest request) {
    if (request == null) {
      throw new IllegalArgumentException("Cannot add null into batch request!");
    }
    this.requests.add(new Pair(name, omitResponseOnSuccess, request));
    return this;
  }

  public List<APIResponse> execute() throws APIException {
    return this.execute(false);
  }

  public List<APIResponse> execute(boolean isAsync) throws APIException {
    try {
      List<APIResponse> responses = new ArrayList<APIResponse>();
      String batchResponse = executeInternal(isAsync);
      context.log(batchResponse);
      JsonArray jsonArray;
      JsonElement jsonResp = new JsonParser().parse(batchResponse);

      if (isAsync) {
        jsonArray = jsonResp.getAsJsonObject().get("async_sessions").getAsJsonArray();
      } else {
        jsonArray = jsonResp.getAsJsonArray();
      }

      if (jsonArray.size() != requests.size()) {
        throw new APIException.MalformedResponseException("Batch request size is " + requests.size() + ", but response size is " + jsonArray.size());
      }
      for (int i = 0; i< jsonArray.size(); i++) {
        if (jsonArray.get(i).isJsonNull()) {
          responses.add(null);
          continue;
        }


        if (isAsync) {
          APIRequest request = requests.get(i).request;
          String body = jsonArray.get(i).getAsJsonObject().toString();
          responses.add(request.parseResponse(body, null));
        } else {
          JsonObject response = jsonArray.get(i).getAsJsonObject();
          if (response == null || response.get("body") == null || response.get("body").isJsonNull()) {
            responses.add(null);
            continue;
          }
          if (response.get("code").getAsInt() == HttpURLConnection.HTTP_OK) {
            String body = response.get("body").getAsString();
            APIRequest request = requests.get(i).request;
            responses.add(request.parseResponse(body, null));
          } else {
            responses.add(new APIException.FailedRequestException(response.toString()));
          }
        }
      }
      return responses;
    } catch (IOException e) {
      throw new APIException.FailedRequestException(e);
    }
  }

  public String executeInternal(boolean isAsync) throws APIException, IOException {
    Map<String, Object> params = new LinkedHashMap<String, Object>();
    Map<String, File> files = new HashMap<String, File>();
    JsonArray batch = new JsonArray();
    String batchParamName = "batch";
    params.put("access_token", context.getAccessToken());
    if (context.hasAppSecret()) {
      params.put("appsecret_proof", context.getAppSecretProof());
    }
    params.put("include_headers", "false");
    for (Pair requestEntry : requests) {
      JsonObject batchElement = new JsonObject();
      BatchModeRequestInfo info = requestEntry.request.getBatchModeRequestInfo();

      batchElement.addProperty("method", info.method);
      batchElement.addProperty("relative_url", info.relativeUrl);
      batchElement.addProperty("name", requestEntry.name);
      batchElement.addProperty("omit_response_on_success", requestEntry.omitResponseOnSuccess);

      if (info.body != null) {
        batchElement.addProperty("body", info.body);
      }

      if (info.files != null) {
        JsonObject attachedFiles = new JsonObject();
        for (Map.Entry entry : info.files.entrySet()) {
          File file = (File)entry.getValue();
          attachedFiles.addProperty("File" + files.size(), (String)entry.getKey());
          files.put("File" + files.size(), file);
        }
        batchElement.add("attached_files", attachedFiles);
      }

      batch.add(batchElement);
    }

    if (isAsync) {
      batchParamName = "asyncbatch";
    }
    params.put(batchParamName, batch.toString());
    params.putAll(files);
    return APIRequest.getExecutor().sendPost(context.getEndpointBase() + "/", params, context).getBody();
  }

  public static class BatchModeRequestInfo {
    public String method;
    public String body;
    public String relativeUrl;
    public boolean omit_response_on_success;
    public Map<String, File> files;
  }

  private static class Pair {
    String name;
    boolean omitResponseOnSuccess;
    APIRequest request;
    Pair(String name, APIRequest request) {
      this.name = name;
      this.request = request;
    }

    Pair(String name, boolean omitResponseOnSuccess, APIRequest request) {
      this.name = name;
      this.omitResponseOnSuccess = omitResponseOnSuccess;
      this.request = request;
    }
  }
}
