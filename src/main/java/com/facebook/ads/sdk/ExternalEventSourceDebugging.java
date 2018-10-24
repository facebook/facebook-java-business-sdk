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
public class ExternalEventSourceDebugging extends APINode {
  @SerializedName("app_version")
  private String mAppVersion = null;
  @SerializedName("content_url")
  private String mContentUrl = null;
  @SerializedName("device_os")
  private String mDeviceOs = null;
  @SerializedName("diagnostic")
  private String mDiagnostic = null;
  @SerializedName("event_name")
  private String mEventName = null;
  @SerializedName("event_time")
  private Long mEventTime = null;
  @SerializedName("missing_ids")
  private String mMissingIds = null;
  @SerializedName("severity")
  private String mSeverity = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ExternalEventSourceDebugging() {
  }

  public ExternalEventSourceDebugging(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ExternalEventSourceDebugging(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ExternalEventSourceDebugging fetch() throws APIException{
    ExternalEventSourceDebugging newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ExternalEventSourceDebugging fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ExternalEventSourceDebugging> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ExternalEventSourceDebugging fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ExternalEventSourceDebugging> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ExternalEventSourceDebugging> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ExternalEventSourceDebugging>)(
      new APIRequest<ExternalEventSourceDebugging>(context, "", "/", "GET", ExternalEventSourceDebugging.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ExternalEventSourceDebugging>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ExternalEventSourceDebugging.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ExternalEventSourceDebugging loadJSON(String json, APIContext context) {
    ExternalEventSourceDebugging externalEventSourceDebugging = getGson().fromJson(json, ExternalEventSourceDebugging.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(externalEventSourceDebugging.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    externalEventSourceDebugging.context = context;
    externalEventSourceDebugging.rawValue = json;
    return externalEventSourceDebugging;
  }

  public static APINodeList<ExternalEventSourceDebugging> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ExternalEventSourceDebugging> externalEventSourceDebuggings = new APINodeList<ExternalEventSourceDebugging>(request, json);
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
          externalEventSourceDebuggings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return externalEventSourceDebuggings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                externalEventSourceDebuggings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            externalEventSourceDebuggings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              externalEventSourceDebuggings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              externalEventSourceDebuggings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  externalEventSourceDebuggings.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              externalEventSourceDebuggings.add(loadJSON(obj.toString(), context));
            }
          }
          return externalEventSourceDebuggings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              externalEventSourceDebuggings.add(loadJSON(entry.getValue().toString(), context));
          }
          return externalEventSourceDebuggings;
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
              externalEventSourceDebuggings.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return externalEventSourceDebuggings;
          }

          // Sixth, check if it's pure JsonObject
          externalEventSourceDebuggings.clear();
          externalEventSourceDebuggings.add(loadJSON(json, context));
          return externalEventSourceDebuggings;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAppVersion() {
    return mAppVersion;
  }

  public String getFieldContentUrl() {
    return mContentUrl;
  }

  public String getFieldDeviceOs() {
    return mDeviceOs;
  }

  public String getFieldDiagnostic() {
    return mDiagnostic;
  }

  public String getFieldEventName() {
    return mEventName;
  }

  public Long getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldMissingIds() {
    return mMissingIds;
  }

  public String getFieldSeverity() {
    return mSeverity;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ExternalEventSourceDebugging> {

    ExternalEventSourceDebugging lastResponse = null;
    @Override
    public ExternalEventSourceDebugging getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "app_version",
      "content_url",
      "device_os",
      "diagnostic",
      "event_name",
      "event_time",
      "missing_ids",
      "severity",
      "id",
    };

    @Override
    public ExternalEventSourceDebugging parseResponse(String response) throws APIException {
      return ExternalEventSourceDebugging.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ExternalEventSourceDebugging execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExternalEventSourceDebugging execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ExternalEventSourceDebugging> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExternalEventSourceDebugging> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ExternalEventSourceDebugging>() {
           public ExternalEventSourceDebugging apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAppVersionField () {
      return this.requestAppVersionField(true);
    }
    public APIRequestGet requestAppVersionField (boolean value) {
      this.requestField("app_version", value);
      return this;
    }
    public APIRequestGet requestContentUrlField () {
      return this.requestContentUrlField(true);
    }
    public APIRequestGet requestContentUrlField (boolean value) {
      this.requestField("content_url", value);
      return this;
    }
    public APIRequestGet requestDeviceOsField () {
      return this.requestDeviceOsField(true);
    }
    public APIRequestGet requestDeviceOsField (boolean value) {
      this.requestField("device_os", value);
      return this;
    }
    public APIRequestGet requestDiagnosticField () {
      return this.requestDiagnosticField(true);
    }
    public APIRequestGet requestDiagnosticField (boolean value) {
      this.requestField("diagnostic", value);
      return this;
    }
    public APIRequestGet requestEventNameField () {
      return this.requestEventNameField(true);
    }
    public APIRequestGet requestEventNameField (boolean value) {
      this.requestField("event_name", value);
      return this;
    }
    public APIRequestGet requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGet requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGet requestMissingIdsField () {
      return this.requestMissingIdsField(true);
    }
    public APIRequestGet requestMissingIdsField (boolean value) {
      this.requestField("missing_ids", value);
      return this;
    }
    public APIRequestGet requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGet requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
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

  public ExternalEventSourceDebugging copyFrom(ExternalEventSourceDebugging instance) {
    this.mAppVersion = instance.mAppVersion;
    this.mContentUrl = instance.mContentUrl;
    this.mDeviceOs = instance.mDeviceOs;
    this.mDiagnostic = instance.mDiagnostic;
    this.mEventName = instance.mEventName;
    this.mEventTime = instance.mEventTime;
    this.mMissingIds = instance.mMissingIds;
    this.mSeverity = instance.mSeverity;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ExternalEventSourceDebugging> getParser() {
    return new APIRequest.ResponseParser<ExternalEventSourceDebugging>() {
      public APINodeList<ExternalEventSourceDebugging> parseResponse(String response, APIContext context, APIRequest<ExternalEventSourceDebugging> request) throws MalformedResponseException {
        return ExternalEventSourceDebugging.parseResponse(response, context, request);
      }
    };
  }
}
