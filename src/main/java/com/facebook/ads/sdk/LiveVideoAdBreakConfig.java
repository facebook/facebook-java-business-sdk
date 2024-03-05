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
public class LiveVideoAdBreakConfig extends APINode {
  @SerializedName("default_ad_break_duration")
  private Long mDefaultAdBreakDuration = null;
  @SerializedName("failure_reason_polling_interval")
  private Long mFailureReasonPollingInterval = null;
  @SerializedName("first_break_eligible_secs")
  private Long mFirstBreakEligibleSecs = null;
  @SerializedName("guide_url")
  private String mGuideUrl = null;
  @SerializedName("is_eligible_to_onboard")
  private Boolean mIsEligibleToOnboard = null;
  @SerializedName("is_enabled")
  private Boolean mIsEnabled = null;
  @SerializedName("onboarding_url")
  private String mOnboardingUrl = null;
  @SerializedName("preparing_duration")
  private Long mPreparingDuration = null;
  @SerializedName("time_between_ad_breaks_secs")
  private Long mTimeBetweenAdBreaksSecs = null;
  @SerializedName("viewer_count_threshold")
  private Long mViewerCountThreshold = null;
  protected static Gson gson = null;

  public LiveVideoAdBreakConfig() {
  }

  public String getId() {
    return null;
  }
  public static LiveVideoAdBreakConfig loadJSON(String json, APIContext context, String header) {
    LiveVideoAdBreakConfig liveVideoAdBreakConfig = getGson().fromJson(json, LiveVideoAdBreakConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveVideoAdBreakConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    liveVideoAdBreakConfig.context = context;
    liveVideoAdBreakConfig.rawValue = json;
    liveVideoAdBreakConfig.header = header;
    return liveVideoAdBreakConfig;
  }

  public static APINodeList<LiveVideoAdBreakConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveVideoAdBreakConfig> liveVideoAdBreakConfigs = new APINodeList<LiveVideoAdBreakConfig>(request, json, header);
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
          liveVideoAdBreakConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveVideoAdBreakConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveVideoAdBreakConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveVideoAdBreakConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveVideoAdBreakConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveVideoAdBreakConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  liveVideoAdBreakConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveVideoAdBreakConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveVideoAdBreakConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveVideoAdBreakConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveVideoAdBreakConfigs;
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
              liveVideoAdBreakConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveVideoAdBreakConfigs;
          }

          // Sixth, check if it's pure JsonObject
          liveVideoAdBreakConfigs.clear();
          liveVideoAdBreakConfigs.add(loadJSON(json, context, header));
          return liveVideoAdBreakConfigs;
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


  public Long getFieldDefaultAdBreakDuration() {
    return mDefaultAdBreakDuration;
  }

  public LiveVideoAdBreakConfig setFieldDefaultAdBreakDuration(Long value) {
    this.mDefaultAdBreakDuration = value;
    return this;
  }

  public Long getFieldFailureReasonPollingInterval() {
    return mFailureReasonPollingInterval;
  }

  public LiveVideoAdBreakConfig setFieldFailureReasonPollingInterval(Long value) {
    this.mFailureReasonPollingInterval = value;
    return this;
  }

  public Long getFieldFirstBreakEligibleSecs() {
    return mFirstBreakEligibleSecs;
  }

  public LiveVideoAdBreakConfig setFieldFirstBreakEligibleSecs(Long value) {
    this.mFirstBreakEligibleSecs = value;
    return this;
  }

  public String getFieldGuideUrl() {
    return mGuideUrl;
  }

  public LiveVideoAdBreakConfig setFieldGuideUrl(String value) {
    this.mGuideUrl = value;
    return this;
  }

  public Boolean getFieldIsEligibleToOnboard() {
    return mIsEligibleToOnboard;
  }

  public LiveVideoAdBreakConfig setFieldIsEligibleToOnboard(Boolean value) {
    this.mIsEligibleToOnboard = value;
    return this;
  }

  public Boolean getFieldIsEnabled() {
    return mIsEnabled;
  }

  public LiveVideoAdBreakConfig setFieldIsEnabled(Boolean value) {
    this.mIsEnabled = value;
    return this;
  }

  public String getFieldOnboardingUrl() {
    return mOnboardingUrl;
  }

  public LiveVideoAdBreakConfig setFieldOnboardingUrl(String value) {
    this.mOnboardingUrl = value;
    return this;
  }

  public Long getFieldPreparingDuration() {
    return mPreparingDuration;
  }

  public LiveVideoAdBreakConfig setFieldPreparingDuration(Long value) {
    this.mPreparingDuration = value;
    return this;
  }

  public Long getFieldTimeBetweenAdBreaksSecs() {
    return mTimeBetweenAdBreaksSecs;
  }

  public LiveVideoAdBreakConfig setFieldTimeBetweenAdBreaksSecs(Long value) {
    this.mTimeBetweenAdBreaksSecs = value;
    return this;
  }

  public Long getFieldViewerCountThreshold() {
    return mViewerCountThreshold;
  }

  public LiveVideoAdBreakConfig setFieldViewerCountThreshold(Long value) {
    this.mViewerCountThreshold = value;
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

  public LiveVideoAdBreakConfig copyFrom(LiveVideoAdBreakConfig instance) {
    this.mDefaultAdBreakDuration = instance.mDefaultAdBreakDuration;
    this.mFailureReasonPollingInterval = instance.mFailureReasonPollingInterval;
    this.mFirstBreakEligibleSecs = instance.mFirstBreakEligibleSecs;
    this.mGuideUrl = instance.mGuideUrl;
    this.mIsEligibleToOnboard = instance.mIsEligibleToOnboard;
    this.mIsEnabled = instance.mIsEnabled;
    this.mOnboardingUrl = instance.mOnboardingUrl;
    this.mPreparingDuration = instance.mPreparingDuration;
    this.mTimeBetweenAdBreaksSecs = instance.mTimeBetweenAdBreaksSecs;
    this.mViewerCountThreshold = instance.mViewerCountThreshold;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveVideoAdBreakConfig> getParser() {
    return new APIRequest.ResponseParser<LiveVideoAdBreakConfig>() {
      public APINodeList<LiveVideoAdBreakConfig> parseResponse(String response, APIContext context, APIRequest<LiveVideoAdBreakConfig> request, String header) throws MalformedResponseException {
        return LiveVideoAdBreakConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
