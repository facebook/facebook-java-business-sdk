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
public class AdCampaignDeliveryEstimate extends APINode {
  @SerializedName("daily_outcomes_curve")
  private List<OutcomePredictionPoint> mDailyOutcomesCurve = null;
  @SerializedName("estimate_dau")
  private Long mEstimateDau = null;
  @SerializedName("estimate_mau_lower_bound")
  private Long mEstimateMauLowerBound = null;
  @SerializedName("estimate_mau_upper_bound")
  private Long mEstimateMauUpperBound = null;
  @SerializedName("estimate_ready")
  private Boolean mEstimateReady = null;
  @SerializedName("targeting_optimization_types")
  private List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> mTargetingOptimizationTypes = null;
  protected static Gson gson = null;

  public AdCampaignDeliveryEstimate() {
  }

  public String getId() {
    return null;
  }
  public static AdCampaignDeliveryEstimate loadJSON(String json, APIContext context, String header) {
    AdCampaignDeliveryEstimate adCampaignDeliveryEstimate = getGson().fromJson(json, AdCampaignDeliveryEstimate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignDeliveryEstimate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignDeliveryEstimate.context = context;
    adCampaignDeliveryEstimate.rawValue = json;
    adCampaignDeliveryEstimate.header = header;
    return adCampaignDeliveryEstimate;
  }

  public static APINodeList<AdCampaignDeliveryEstimate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignDeliveryEstimate> adCampaignDeliveryEstimates = new APINodeList<AdCampaignDeliveryEstimate>(request, json, header);
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
          adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignDeliveryEstimates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignDeliveryEstimates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignDeliveryEstimates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignDeliveryEstimates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignDeliveryEstimates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignDeliveryEstimates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignDeliveryEstimates;
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
              adCampaignDeliveryEstimates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignDeliveryEstimates;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignDeliveryEstimates.clear();
          adCampaignDeliveryEstimates.add(loadJSON(json, context, header));
          return adCampaignDeliveryEstimates;
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


  public List<OutcomePredictionPoint> getFieldDailyOutcomesCurve() {
    return mDailyOutcomesCurve;
  }

  public AdCampaignDeliveryEstimate setFieldDailyOutcomesCurve(List<OutcomePredictionPoint> value) {
    this.mDailyOutcomesCurve = value;
    return this;
  }

  public AdCampaignDeliveryEstimate setFieldDailyOutcomesCurve(String value) {
    Type type = new TypeToken<List<OutcomePredictionPoint>>(){}.getType();
    this.mDailyOutcomesCurve = OutcomePredictionPoint.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldEstimateDau() {
    return mEstimateDau;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateDau(Long value) {
    this.mEstimateDau = value;
    return this;
  }

  public Long getFieldEstimateMauLowerBound() {
    return mEstimateMauLowerBound;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateMauLowerBound(Long value) {
    this.mEstimateMauLowerBound = value;
    return this;
  }

  public Long getFieldEstimateMauUpperBound() {
    return mEstimateMauUpperBound;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateMauUpperBound(Long value) {
    this.mEstimateMauUpperBound = value;
    return this;
  }

  public Boolean getFieldEstimateReady() {
    return mEstimateReady;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateReady(Boolean value) {
    this.mEstimateReady = value;
    return this;
  }

  public List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> getFieldTargetingOptimizationTypes() {
    return mTargetingOptimizationTypes;
  }

  public AdCampaignDeliveryEstimate setFieldTargetingOptimizationTypes(List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> value) {
    this.mTargetingOptimizationTypes = value;
    return this;
  }



  public static enum EnumOptimizationGoal {
      @SerializedName("AD_RECALL_LIFT")
      VALUE_AD_RECALL_LIFT("AD_RECALL_LIFT"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("APP_INSTALLS_AND_OFFSITE_CONVERSIONS")
      VALUE_APP_INSTALLS_AND_OFFSITE_CONVERSIONS("APP_INSTALLS_AND_OFFSITE_CONVERSIONS"),
      @SerializedName("CONVERSATIONS")
      VALUE_CONVERSATIONS("CONVERSATIONS"),
      @SerializedName("DERIVED_EVENTS")
      VALUE_DERIVED_EVENTS("DERIVED_EVENTS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("IN_APP_VALUE")
      VALUE_IN_APP_VALUE("IN_APP_VALUE"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("MEANINGFUL_CALL_ATTEMPT")
      VALUE_MEANINGFUL_CALL_ATTEMPT("MEANINGFUL_CALL_ATTEMPT"),
      @SerializedName("MESSAGING_APPOINTMENT_CONVERSION")
      VALUE_MESSAGING_APPOINTMENT_CONVERSION("MESSAGING_APPOINTMENT_CONVERSION"),
      @SerializedName("MESSAGING_PURCHASE_CONVERSION")
      VALUE_MESSAGING_PURCHASE_CONVERSION("MESSAGING_PURCHASE_CONVERSION"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PROFILE_VISIT")
      VALUE_PROFILE_VISIT("PROFILE_VISIT"),
      @SerializedName("QUALITY_CALL")
      VALUE_QUALITY_CALL("QUALITY_CALL"),
      @SerializedName("QUALITY_LEAD")
      VALUE_QUALITY_LEAD("QUALITY_LEAD"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("REMINDERS_SET")
      VALUE_REMINDERS_SET("REMINDERS_SET"),
      @SerializedName("SUBSCRIBERS")
      VALUE_SUBSCRIBERS("SUBSCRIBERS"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("VISIT_INSTAGRAM_PROFILE")
      VALUE_VISIT_INSTAGRAM_PROFILE("VISIT_INSTAGRAM_PROFILE"),
      ;

      private String value;

      private EnumOptimizationGoal(String value) {
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

  public AdCampaignDeliveryEstimate copyFrom(AdCampaignDeliveryEstimate instance) {
    this.mDailyOutcomesCurve = instance.mDailyOutcomesCurve;
    this.mEstimateDau = instance.mEstimateDau;
    this.mEstimateMauLowerBound = instance.mEstimateMauLowerBound;
    this.mEstimateMauUpperBound = instance.mEstimateMauUpperBound;
    this.mEstimateReady = instance.mEstimateReady;
    this.mTargetingOptimizationTypes = instance.mTargetingOptimizationTypes;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignDeliveryEstimate> getParser() {
    return new APIRequest.ResponseParser<AdCampaignDeliveryEstimate>() {
      public APINodeList<AdCampaignDeliveryEstimate> parseResponse(String response, APIContext context, APIRequest<AdCampaignDeliveryEstimate> request, String header) throws MalformedResponseException {
        return AdCampaignDeliveryEstimate.parseResponse(response, context, request, header);
      }
    };
  }
}
