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

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class RequestHistory extends APINode {
  @SerializedName("api_version")
  private String mApiVersion = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("error_code")
  private Long mErrorCode = null;
  @SerializedName("graph_path")
  private String mGraphPath = null;
  @SerializedName("http_method")
  private EnumHttpMethod mHttpMethod = null;
  @SerializedName("post_params")
  private Map<String, String> mPostParams = null;
  @SerializedName("query_params")
  private Map<String, String> mQueryParams = null;
  protected static Gson gson = null;

  public RequestHistory() {
  }

  public String getId() {
    return null;
  }
  public static RequestHistory loadJSON(String json, APIContext context, String header) {
    RequestHistory requestHistory = getGson().fromJson(json, RequestHistory.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(requestHistory.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    requestHistory.context = context;
    requestHistory.rawValue = json;
    requestHistory.header = header;
    return requestHistory;
  }

  public static APINodeList<RequestHistory> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<RequestHistory> requestHistorys = new APINodeList<RequestHistory>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          requestHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return requestHistorys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                requestHistorys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            requestHistorys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              requestHistorys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              requestHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  requestHistorys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              requestHistorys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return requestHistorys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              requestHistorys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return requestHistorys;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              requestHistorys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return requestHistorys;
          }

          // Sixth, check if it's pure JsonObject
          requestHistorys.clear();
          requestHistorys.add(loadJSON(json, context, header));
          return requestHistorys;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldApiVersion() {
    return mApiVersion;
  }

  public RequestHistory setFieldApiVersion(String value) {
    this.mApiVersion = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public RequestHistory setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public Long getFieldErrorCode() {
    return mErrorCode;
  }

  public RequestHistory setFieldErrorCode(Long value) {
    this.mErrorCode = value;
    return this;
  }

  public String getFieldGraphPath() {
    return mGraphPath;
  }

  public RequestHistory setFieldGraphPath(String value) {
    this.mGraphPath = value;
    return this;
  }

  public EnumHttpMethod getFieldHttpMethod() {
    return mHttpMethod;
  }

  public RequestHistory setFieldHttpMethod(EnumHttpMethod value) {
    this.mHttpMethod = value;
    return this;
  }

  public Map<String, String> getFieldPostParams() {
    return mPostParams;
  }

  public RequestHistory setFieldPostParams(Map<String, String> value) {
    this.mPostParams = value;
    return this;
  }

  public Map<String, String> getFieldQueryParams() {
    return mQueryParams;
  }

  public RequestHistory setFieldQueryParams(Map<String, String> value) {
    this.mQueryParams = value;
    return this;
  }



  public static enum EnumHttpMethod {
      @SerializedName("DELETE")
      VALUE_DELETE("DELETE"),
      @SerializedName("GET")
      VALUE_GET("GET"),
      @SerializedName("POST")
      VALUE_POST("POST"),
      ;

      private String value;

      private EnumHttpMethod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public RequestHistory copyFrom(RequestHistory instance) {
    this.mApiVersion = instance.mApiVersion;
    this.mCreatedTime = instance.mCreatedTime;
    this.mErrorCode = instance.mErrorCode;
    this.mGraphPath = instance.mGraphPath;
    this.mHttpMethod = instance.mHttpMethod;
    this.mPostParams = instance.mPostParams;
    this.mQueryParams = instance.mQueryParams;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<RequestHistory> getParser() {
    return new APIRequest.ResponseParser<RequestHistory>() {
      public APINodeList<RequestHistory> parseResponse(String response, APIContext context, APIRequest<RequestHistory> request, String header) throws MalformedResponseException {
        return RequestHistory.parseResponse(response, context, request, header);
      }
    };
  }
}
