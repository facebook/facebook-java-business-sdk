/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class AdsPixelStatsResult extends APINode {
  @SerializedName("aggregation")
  private String mAggregation = null;
  @SerializedName("data")
  private List<AdsPixelStats> mData = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  protected static Gson gson = null;

  public AdsPixelStatsResult() {
  }

  public String getId() {
    return null;
  }
  public static AdsPixelStatsResult loadJSON(String json, APIContext context, String header) {
    AdsPixelStatsResult adsPixelStatsResult = getGson().fromJson(json, AdsPixelStatsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPixelStatsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsPixelStatsResult.context = context;
    adsPixelStatsResult.rawValue = json;
    adsPixelStatsResult.header = header;
    return adsPixelStatsResult;
  }

  public static APINodeList<AdsPixelStatsResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsPixelStatsResult> adsPixelStatsResults = new APINodeList<AdsPixelStatsResult>(request, json, header);
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
          adsPixelStatsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsPixelStatsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPixelStatsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPixelStatsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPixelStatsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixelStatsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsPixelStatsResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPixelStatsResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsPixelStatsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixelStatsResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsPixelStatsResults;
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
              adsPixelStatsResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPixelStatsResults;
          }

          // Sixth, check if it's pure JsonObject
          adsPixelStatsResults.clear();
          adsPixelStatsResults.add(loadJSON(json, context, header));
          return adsPixelStatsResults;
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


  public String getFieldAggregation() {
    return mAggregation;
  }

  public AdsPixelStatsResult setFieldAggregation(String value) {
    this.mAggregation = value;
    return this;
  }

  public List<AdsPixelStats> getFieldData() {
    return mData;
  }

  public AdsPixelStatsResult setFieldData(List<AdsPixelStats> value) {
    this.mData = value;
    return this;
  }

  public AdsPixelStatsResult setFieldData(String value) {
    Type type = new TypeToken<List<AdsPixelStats>>(){}.getType();
    this.mData = AdsPixelStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdsPixelStatsResult setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }



  public static enum EnumAggregation {
      @SerializedName("browser_type")
      VALUE_BROWSER_TYPE("browser_type"),
      @SerializedName("custom_data_field")
      VALUE_CUSTOM_DATA_FIELD("custom_data_field"),
      @SerializedName("device_os")
      VALUE_DEVICE_OS("device_os"),
      @SerializedName("device_type")
      VALUE_DEVICE_TYPE("device_type"),
      @SerializedName("event")
      VALUE_EVENT("event"),
      @SerializedName("event_detection_method")
      VALUE_EVENT_DETECTION_METHOD("event_detection_method"),
      @SerializedName("event_processing_results")
      VALUE_EVENT_PROCESSING_RESULTS("event_processing_results"),
      @SerializedName("event_source")
      VALUE_EVENT_SOURCE("event_source"),
      @SerializedName("event_total_counts")
      VALUE_EVENT_TOTAL_COUNTS("event_total_counts"),
      @SerializedName("event_value_count")
      VALUE_EVENT_VALUE_COUNT("event_value_count"),
      @SerializedName("had_pii")
      VALUE_HAD_PII("had_pii"),
      @SerializedName("host")
      VALUE_HOST("host"),
      @SerializedName("match_keys")
      VALUE_MATCH_KEYS("match_keys"),
      @SerializedName("pixel_fire")
      VALUE_PIXEL_FIRE("pixel_fire"),
      @SerializedName("url")
      VALUE_URL("url"),
      @SerializedName("url_by_rule")
      VALUE_URL_BY_RULE("url_by_rule"),
      ;

      private String value;

      private EnumAggregation(String value) {
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

  public AdsPixelStatsResult copyFrom(AdsPixelStatsResult instance) {
    this.mAggregation = instance.mAggregation;
    this.mData = instance.mData;
    this.mStartTime = instance.mStartTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPixelStatsResult> getParser() {
    return new APIRequest.ResponseParser<AdsPixelStatsResult>() {
      public APINodeList<AdsPixelStatsResult> parseResponse(String response, APIContext context, APIRequest<AdsPixelStatsResult> request, String header) throws MalformedResponseException {
        return AdsPixelStatsResult.parseResponse(response, context, request, header);
      }
    };
  }
}
