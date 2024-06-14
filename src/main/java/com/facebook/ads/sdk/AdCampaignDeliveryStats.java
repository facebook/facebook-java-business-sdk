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
public class AdCampaignDeliveryStats extends APINode {
  @SerializedName("bid_recommendation")
  private Long mBidRecommendation = null;
  @SerializedName("current_average_cost")
  private Double mCurrentAverageCost = null;
  @SerializedName("last_significant_edit_ts")
  private Long mLastSignificantEditTs = null;
  @SerializedName("learning_stage_exit_info")
  private Object mLearningStageExitInfo = null;
  @SerializedName("learning_stage_info")
  private AdCampaignLearningStageInfo mLearningStageInfo = null;
  @SerializedName("unsupported_features")
  private List<Map<String, AdCampaignDeliveryStatsUnsupportedReasons>> mUnsupportedFeatures = null;
  protected static Gson gson = null;

  public AdCampaignDeliveryStats() {
  }

  public String getId() {
    return null;
  }
  public static AdCampaignDeliveryStats loadJSON(String json, APIContext context, String header) {
    AdCampaignDeliveryStats adCampaignDeliveryStats = getGson().fromJson(json, AdCampaignDeliveryStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignDeliveryStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignDeliveryStats.context = context;
    adCampaignDeliveryStats.rawValue = json;
    adCampaignDeliveryStats.header = header;
    return adCampaignDeliveryStats;
  }

  public static APINodeList<AdCampaignDeliveryStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignDeliveryStats> adCampaignDeliveryStatss = new APINodeList<AdCampaignDeliveryStats>(request, json, header);
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
          adCampaignDeliveryStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignDeliveryStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignDeliveryStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignDeliveryStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignDeliveryStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignDeliveryStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignDeliveryStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignDeliveryStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignDeliveryStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignDeliveryStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignDeliveryStatss;
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
              adCampaignDeliveryStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignDeliveryStatss;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignDeliveryStatss.clear();
          adCampaignDeliveryStatss.add(loadJSON(json, context, header));
          return adCampaignDeliveryStatss;
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


  public Long getFieldBidRecommendation() {
    return mBidRecommendation;
  }

  public AdCampaignDeliveryStats setFieldBidRecommendation(Long value) {
    this.mBidRecommendation = value;
    return this;
  }

  public Double getFieldCurrentAverageCost() {
    return mCurrentAverageCost;
  }

  public AdCampaignDeliveryStats setFieldCurrentAverageCost(Double value) {
    this.mCurrentAverageCost = value;
    return this;
  }

  public Long getFieldLastSignificantEditTs() {
    return mLastSignificantEditTs;
  }

  public AdCampaignDeliveryStats setFieldLastSignificantEditTs(Long value) {
    this.mLastSignificantEditTs = value;
    return this;
  }

  public Object getFieldLearningStageExitInfo() {
    return mLearningStageExitInfo;
  }

  public AdCampaignDeliveryStats setFieldLearningStageExitInfo(Object value) {
    this.mLearningStageExitInfo = value;
    return this;
  }

  public AdCampaignLearningStageInfo getFieldLearningStageInfo() {
    return mLearningStageInfo;
  }

  public AdCampaignDeliveryStats setFieldLearningStageInfo(AdCampaignLearningStageInfo value) {
    this.mLearningStageInfo = value;
    return this;
  }

  public AdCampaignDeliveryStats setFieldLearningStageInfo(String value) {
    Type type = new TypeToken<AdCampaignLearningStageInfo>(){}.getType();
    this.mLearningStageInfo = AdCampaignLearningStageInfo.getGson().fromJson(value, type);
    return this;
  }
  public List<Map<String, AdCampaignDeliveryStatsUnsupportedReasons>> getFieldUnsupportedFeatures() {
    return mUnsupportedFeatures;
  }

  public AdCampaignDeliveryStats setFieldUnsupportedFeatures(List<Map<String, AdCampaignDeliveryStatsUnsupportedReasons>> value) {
    this.mUnsupportedFeatures = value;
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

  public AdCampaignDeliveryStats copyFrom(AdCampaignDeliveryStats instance) {
    this.mBidRecommendation = instance.mBidRecommendation;
    this.mCurrentAverageCost = instance.mCurrentAverageCost;
    this.mLastSignificantEditTs = instance.mLastSignificantEditTs;
    this.mLearningStageExitInfo = instance.mLearningStageExitInfo;
    this.mLearningStageInfo = instance.mLearningStageInfo;
    this.mUnsupportedFeatures = instance.mUnsupportedFeatures;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignDeliveryStats> getParser() {
    return new APIRequest.ResponseParser<AdCampaignDeliveryStats>() {
      public APINodeList<AdCampaignDeliveryStats> parseResponse(String response, APIContext context, APIRequest<AdCampaignDeliveryStats> request, String header) throws MalformedResponseException {
        return AdCampaignDeliveryStats.parseResponse(response, context, request, header);
      }
    };
  }
}
