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
public class TrackingAndConversionWithDefaults extends APINode {
  @SerializedName("custom_conversion")
  private List<Object> mCustomConversion = null;
  @SerializedName("custom_tracking")
  private List<Object> mCustomTracking = null;
  @SerializedName("default_conversion")
  private List<Object> mDefaultConversion = null;
  @SerializedName("default_tracking")
  private List<Object> mDefaultTracking = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  TrackingAndConversionWithDefaults() {
  }

  public TrackingAndConversionWithDefaults(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public TrackingAndConversionWithDefaults(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public TrackingAndConversionWithDefaults fetch() throws APIException{
    TrackingAndConversionWithDefaults newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static TrackingAndConversionWithDefaults fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<TrackingAndConversionWithDefaults> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static TrackingAndConversionWithDefaults fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<TrackingAndConversionWithDefaults> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<TrackingAndConversionWithDefaults> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<TrackingAndConversionWithDefaults>)(
      new APIRequest<TrackingAndConversionWithDefaults>(context, "", "/", "GET", TrackingAndConversionWithDefaults.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<TrackingAndConversionWithDefaults>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", TrackingAndConversionWithDefaults.getParser())
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
  public static TrackingAndConversionWithDefaults loadJSON(String json, APIContext context) {
    TrackingAndConversionWithDefaults trackingAndConversionWithDefaults = getGson().fromJson(json, TrackingAndConversionWithDefaults.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(trackingAndConversionWithDefaults.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    trackingAndConversionWithDefaults.context = context;
    trackingAndConversionWithDefaults.rawValue = json;
    return trackingAndConversionWithDefaults;
  }

  public static APINodeList<TrackingAndConversionWithDefaults> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<TrackingAndConversionWithDefaults> trackingAndConversionWithDefaultss = new APINodeList<TrackingAndConversionWithDefaults>(request, json);
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
          trackingAndConversionWithDefaultss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return trackingAndConversionWithDefaultss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                trackingAndConversionWithDefaultss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            trackingAndConversionWithDefaultss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              trackingAndConversionWithDefaultss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              trackingAndConversionWithDefaultss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  trackingAndConversionWithDefaultss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              trackingAndConversionWithDefaultss.add(loadJSON(obj.toString(), context));
            }
          }
          return trackingAndConversionWithDefaultss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              trackingAndConversionWithDefaultss.add(loadJSON(entry.getValue().toString(), context));
          }
          return trackingAndConversionWithDefaultss;
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
              trackingAndConversionWithDefaultss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return trackingAndConversionWithDefaultss;
          }

          // Sixth, check if it's pure JsonObject
          trackingAndConversionWithDefaultss.clear();
          trackingAndConversionWithDefaultss.add(loadJSON(json, context));
          return trackingAndConversionWithDefaultss;
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


  public List<Object> getFieldCustomConversion() {
    return mCustomConversion;
  }

  public List<Object> getFieldCustomTracking() {
    return mCustomTracking;
  }

  public List<Object> getFieldDefaultConversion() {
    return mDefaultConversion;
  }

  public List<Object> getFieldDefaultTracking() {
    return mDefaultTracking;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<TrackingAndConversionWithDefaults> {

    TrackingAndConversionWithDefaults lastResponse = null;
    @Override
    public TrackingAndConversionWithDefaults getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "custom_conversion",
      "custom_tracking",
      "default_conversion",
      "default_tracking",
      "id",
    };

    @Override
    public TrackingAndConversionWithDefaults parseResponse(String response) throws APIException {
      return TrackingAndConversionWithDefaults.parseResponse(response, getContext(), this).head();
    }

    @Override
    public TrackingAndConversionWithDefaults execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public TrackingAndConversionWithDefaults execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<TrackingAndConversionWithDefaults> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<TrackingAndConversionWithDefaults> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, TrackingAndConversionWithDefaults>() {
           public TrackingAndConversionWithDefaults apply(String result) {
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

    public APIRequestGet requestCustomConversionField () {
      return this.requestCustomConversionField(true);
    }
    public APIRequestGet requestCustomConversionField (boolean value) {
      this.requestField("custom_conversion", value);
      return this;
    }
    public APIRequestGet requestCustomTrackingField () {
      return this.requestCustomTrackingField(true);
    }
    public APIRequestGet requestCustomTrackingField (boolean value) {
      this.requestField("custom_tracking", value);
      return this;
    }
    public APIRequestGet requestDefaultConversionField () {
      return this.requestDefaultConversionField(true);
    }
    public APIRequestGet requestDefaultConversionField (boolean value) {
      this.requestField("default_conversion", value);
      return this;
    }
    public APIRequestGet requestDefaultTrackingField () {
      return this.requestDefaultTrackingField(true);
    }
    public APIRequestGet requestDefaultTrackingField (boolean value) {
      this.requestField("default_tracking", value);
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

  public TrackingAndConversionWithDefaults copyFrom(TrackingAndConversionWithDefaults instance) {
    this.mCustomConversion = instance.mCustomConversion;
    this.mCustomTracking = instance.mCustomTracking;
    this.mDefaultConversion = instance.mDefaultConversion;
    this.mDefaultTracking = instance.mDefaultTracking;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TrackingAndConversionWithDefaults> getParser() {
    return new APIRequest.ResponseParser<TrackingAndConversionWithDefaults>() {
      public APINodeList<TrackingAndConversionWithDefaults> parseResponse(String response, APIContext context, APIRequest<TrackingAndConversionWithDefaults> request) throws MalformedResponseException {
        return TrackingAndConversionWithDefaults.parseResponse(response, context, request);
      }
    };
  }
}
