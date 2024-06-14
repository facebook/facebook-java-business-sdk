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
public class InstagramInsightsResult extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("period")
  private String mPeriod = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("total_value")
  private Object mTotalValue = null;
  @SerializedName("values")
  private List<InstagramInsightsValue> mValues = null;
  protected static Gson gson = null;

  public InstagramInsightsResult() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static InstagramInsightsResult loadJSON(String json, APIContext context, String header) {
    InstagramInsightsResult instagramInsightsResult = getGson().fromJson(json, InstagramInsightsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramInsightsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramInsightsResult.context = context;
    instagramInsightsResult.rawValue = json;
    instagramInsightsResult.header = header;
    return instagramInsightsResult;
  }

  public static APINodeList<InstagramInsightsResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramInsightsResult> instagramInsightsResults = new APINodeList<InstagramInsightsResult>(request, json, header);
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
          instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramInsightsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramInsightsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramInsightsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramInsightsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramInsightsResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramInsightsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramInsightsResults;
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
              instagramInsightsResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramInsightsResults;
          }

          // Sixth, check if it's pure JsonObject
          instagramInsightsResults.clear();
          instagramInsightsResults.add(loadJSON(json, context, header));
          return instagramInsightsResults;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public InstagramInsightsResult setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public InstagramInsightsResult setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public InstagramInsightsResult setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPeriod() {
    return mPeriod;
  }

  public InstagramInsightsResult setFieldPeriod(String value) {
    this.mPeriod = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public InstagramInsightsResult setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public Object getFieldTotalValue() {
    return mTotalValue;
  }

  public InstagramInsightsResult setFieldTotalValue(Object value) {
    this.mTotalValue = value;
    return this;
  }

  public List<InstagramInsightsValue> getFieldValues() {
    return mValues;
  }

  public InstagramInsightsResult setFieldValues(List<InstagramInsightsValue> value) {
    this.mValues = value;
    return this;
  }

  public InstagramInsightsResult setFieldValues(String value) {
    Type type = new TypeToken<List<InstagramInsightsValue>>(){}.getType();
    this.mValues = InstagramInsightsValue.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumBreakdown {
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("follow_type")
      VALUE_FOLLOW_TYPE("follow_type"),
      @SerializedName("story_navigation_action_type")
      VALUE_STORY_NAVIGATION_ACTION_TYPE("story_navigation_action_type"),
      @SerializedName("surface_type")
      VALUE_SURFACE_TYPE("surface_type"),
      ;

      private String value;

      private EnumBreakdown(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetric {
      @SerializedName("clips_replays_count")
      VALUE_CLIPS_REPLAYS_COUNT("clips_replays_count"),
      @SerializedName("comments")
      VALUE_COMMENTS("comments"),
      @SerializedName("follows")
      VALUE_FOLLOWS("follows"),
      @SerializedName("ig_reels_aggregated_all_plays_count")
      VALUE_IG_REELS_AGGREGATED_ALL_PLAYS_COUNT("ig_reels_aggregated_all_plays_count"),
      @SerializedName("ig_reels_avg_watch_time")
      VALUE_IG_REELS_AVG_WATCH_TIME("ig_reels_avg_watch_time"),
      @SerializedName("ig_reels_video_view_total_time")
      VALUE_IG_REELS_VIDEO_VIEW_TOTAL_TIME("ig_reels_video_view_total_time"),
      @SerializedName("impressions")
      VALUE_IMPRESSIONS("impressions"),
      @SerializedName("likes")
      VALUE_LIKES("likes"),
      @SerializedName("navigation")
      VALUE_NAVIGATION("navigation"),
      @SerializedName("plays")
      VALUE_PLAYS("plays"),
      @SerializedName("profile_activity")
      VALUE_PROFILE_ACTIVITY("profile_activity"),
      @SerializedName("profile_visits")
      VALUE_PROFILE_VISITS("profile_visits"),
      @SerializedName("reach")
      VALUE_REACH("reach"),
      @SerializedName("replies")
      VALUE_REPLIES("replies"),
      @SerializedName("saved")
      VALUE_SAVED("saved"),
      @SerializedName("shares")
      VALUE_SHARES("shares"),
      @SerializedName("total_interactions")
      VALUE_TOTAL_INTERACTIONS("total_interactions"),
      @SerializedName("video_views")
      VALUE_VIDEO_VIEWS("video_views"),
      ;

      private String value;

      private EnumMetric(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("days_28")
      VALUE_DAYS_28("days_28"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("total_over_range")
      VALUE_TOTAL_OVER_RANGE("total_over_range"),
      @SerializedName("week")
      VALUE_WEEK("week"),
      ;

      private String value;

      private EnumPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetricType {
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      @SerializedName("time_series")
      VALUE_TIME_SERIES("time_series"),
      @SerializedName("total_value")
      VALUE_TOTAL_VALUE("total_value"),
      ;

      private String value;

      private EnumMetricType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimeframe {
      @SerializedName("last_14_days")
      VALUE_LAST_14_DAYS("last_14_days"),
      @SerializedName("last_30_days")
      VALUE_LAST_30_DAYS("last_30_days"),
      @SerializedName("last_90_days")
      VALUE_LAST_90_DAYS("last_90_days"),
      @SerializedName("prev_month")
      VALUE_PREV_MONTH("prev_month"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_week")
      VALUE_THIS_WEEK("this_week"),
      ;

      private String value;

      private EnumTimeframe(String value) {
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

  public InstagramInsightsResult copyFrom(InstagramInsightsResult instance) {
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPeriod = instance.mPeriod;
    this.mTitle = instance.mTitle;
    this.mTotalValue = instance.mTotalValue;
    this.mValues = instance.mValues;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramInsightsResult> getParser() {
    return new APIRequest.ResponseParser<InstagramInsightsResult>() {
      public APINodeList<InstagramInsightsResult> parseResponse(String response, APIContext context, APIRequest<InstagramInsightsResult> request, String header) throws MalformedResponseException {
        return InstagramInsightsResult.parseResponse(response, context, request, header);
      }
    };
  }
}
