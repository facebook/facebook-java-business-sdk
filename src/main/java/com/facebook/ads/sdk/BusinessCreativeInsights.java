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
public class BusinessCreativeInsights extends APINode {
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("date_end")
  private String mDateEnd = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("device_platform")
  private String mDevicePlatform = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("inline_link_clicks")
  private Long mInlineLinkClicks = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("optimization_goal")
  private String mOptimizationGoal = null;
  @SerializedName("platform_position")
  private String mPlatformPosition = null;
  @SerializedName("publisher_platform")
  private String mPublisherPlatform = null;
  @SerializedName("quality_ranking")
  private String mQualityRanking = null;
  @SerializedName("video_play_actions")
  private List<AdsActionStats> mVideoPlayActions = null;
  @SerializedName("video_thruplay_watched_actions")
  private List<AdsActionStats> mVideoThruplayWatchedActions = null;
  protected static Gson gson = null;

  public BusinessCreativeInsights() {
  }

  public String getId() {
    return null;
  }
  public static BusinessCreativeInsights loadJSON(String json, APIContext context, String header) {
    BusinessCreativeInsights businessCreativeInsights = getGson().fromJson(json, BusinessCreativeInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessCreativeInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessCreativeInsights.context = context;
    businessCreativeInsights.rawValue = json;
    businessCreativeInsights.header = header;
    return businessCreativeInsights;
  }

  public static APINodeList<BusinessCreativeInsights> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessCreativeInsights> businessCreativeInsightss = new APINodeList<BusinessCreativeInsights>(request, json, header);
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
          businessCreativeInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessCreativeInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessCreativeInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessCreativeInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessCreativeInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessCreativeInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessCreativeInsightss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessCreativeInsightss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessCreativeInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessCreativeInsightss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessCreativeInsightss;
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
              businessCreativeInsightss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessCreativeInsightss;
          }

          // Sixth, check if it's pure JsonObject
          businessCreativeInsightss.clear();
          businessCreativeInsightss.add(loadJSON(json, context, header));
          return businessCreativeInsightss;
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


  public List<AdsActionStats> getFieldActions() {
    return mActions;
  }

  public BusinessCreativeInsights setFieldActions(List<AdsActionStats> value) {
    this.mActions = value;
    return this;
  }

  public BusinessCreativeInsights setFieldActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAge() {
    return mAge;
  }

  public BusinessCreativeInsights setFieldAge(String value) {
    this.mAge = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public BusinessCreativeInsights setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldDateEnd() {
    return mDateEnd;
  }

  public BusinessCreativeInsights setFieldDateEnd(String value) {
    this.mDateEnd = value;
    return this;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public BusinessCreativeInsights setFieldDateStart(String value) {
    this.mDateStart = value;
    return this;
  }

  public String getFieldDevicePlatform() {
    return mDevicePlatform;
  }

  public BusinessCreativeInsights setFieldDevicePlatform(String value) {
    this.mDevicePlatform = value;
    return this;
  }

  public String getFieldGender() {
    return mGender;
  }

  public BusinessCreativeInsights setFieldGender(String value) {
    this.mGender = value;
    return this;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public BusinessCreativeInsights setFieldImpressions(Long value) {
    this.mImpressions = value;
    return this;
  }

  public Long getFieldInlineLinkClicks() {
    return mInlineLinkClicks;
  }

  public BusinessCreativeInsights setFieldInlineLinkClicks(Long value) {
    this.mInlineLinkClicks = value;
    return this;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public BusinessCreativeInsights setFieldObjective(String value) {
    this.mObjective = value;
    return this;
  }

  public String getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public BusinessCreativeInsights setFieldOptimizationGoal(String value) {
    this.mOptimizationGoal = value;
    return this;
  }

  public String getFieldPlatformPosition() {
    return mPlatformPosition;
  }

  public BusinessCreativeInsights setFieldPlatformPosition(String value) {
    this.mPlatformPosition = value;
    return this;
  }

  public String getFieldPublisherPlatform() {
    return mPublisherPlatform;
  }

  public BusinessCreativeInsights setFieldPublisherPlatform(String value) {
    this.mPublisherPlatform = value;
    return this;
  }

  public String getFieldQualityRanking() {
    return mQualityRanking;
  }

  public BusinessCreativeInsights setFieldQualityRanking(String value) {
    this.mQualityRanking = value;
    return this;
  }

  public List<AdsActionStats> getFieldVideoPlayActions() {
    return mVideoPlayActions;
  }

  public BusinessCreativeInsights setFieldVideoPlayActions(List<AdsActionStats> value) {
    this.mVideoPlayActions = value;
    return this;
  }

  public BusinessCreativeInsights setFieldVideoPlayActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoPlayActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoThruplayWatchedActions() {
    return mVideoThruplayWatchedActions;
  }

  public BusinessCreativeInsights setFieldVideoThruplayWatchedActions(List<AdsActionStats> value) {
    this.mVideoThruplayWatchedActions = value;
    return this;
  }

  public BusinessCreativeInsights setFieldVideoThruplayWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoThruplayWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
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

  public BusinessCreativeInsights copyFrom(BusinessCreativeInsights instance) {
    this.mActions = instance.mActions;
    this.mAge = instance.mAge;
    this.mCountry = instance.mCountry;
    this.mDateEnd = instance.mDateEnd;
    this.mDateStart = instance.mDateStart;
    this.mDevicePlatform = instance.mDevicePlatform;
    this.mGender = instance.mGender;
    this.mImpressions = instance.mImpressions;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mObjective = instance.mObjective;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mPlatformPosition = instance.mPlatformPosition;
    this.mPublisherPlatform = instance.mPublisherPlatform;
    this.mQualityRanking = instance.mQualityRanking;
    this.mVideoPlayActions = instance.mVideoPlayActions;
    this.mVideoThruplayWatchedActions = instance.mVideoThruplayWatchedActions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessCreativeInsights> getParser() {
    return new APIRequest.ResponseParser<BusinessCreativeInsights>() {
      public APINodeList<BusinessCreativeInsights> parseResponse(String response, APIContext context, APIRequest<BusinessCreativeInsights> request, String header) throws MalformedResponseException {
        return BusinessCreativeInsights.parseResponse(response, context, request, header);
      }
    };
  }
}
