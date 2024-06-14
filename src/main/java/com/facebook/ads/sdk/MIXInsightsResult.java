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
public class MIXInsightsResult extends APINode {
  @SerializedName("daily_age_gender_breakdown")
  private List<Map<String, List<Map<String, Long>>>> mDailyAgeGenderBreakdown = null;
  @SerializedName("daily_audio_library_values")
  private List<Map<String, Long>> mDailyAudioLibraryValues = null;
  @SerializedName("daily_ugc_values")
  private List<Map<String, Long>> mDailyUgcValues = null;
  @SerializedName("daily_values")
  private List<Map<String, Long>> mDailyValues = null;
  @SerializedName("metric")
  private String mMetric = null;
  @SerializedName("monthly_audio_library_values")
  private List<Map<String, Long>> mMonthlyAudioLibraryValues = null;
  @SerializedName("monthly_ugc_values")
  private List<Map<String, Long>> mMonthlyUgcValues = null;
  @SerializedName("monthly_values")
  private List<Map<String, Long>> mMonthlyValues = null;
  @SerializedName("percent_growth")
  private Double mPercentGrowth = null;
  @SerializedName("shielded_fields")
  private List<Map<String, List<Map<String, Boolean>>>> mShieldedFields = null;
  @SerializedName("total_age_gender_breakdown")
  private List<Map<String, Long>> mTotalAgeGenderBreakdown = null;
  @SerializedName("total_audio_library_value")
  private Long mTotalAudioLibraryValue = null;
  @SerializedName("total_country_breakdown")
  private List<Map<String, Long>> mTotalCountryBreakdown = null;
  @SerializedName("total_locale_breakdown")
  private List<Map<String, Long>> mTotalLocaleBreakdown = null;
  @SerializedName("total_product_breakdown")
  private List<Map<String, Long>> mTotalProductBreakdown = null;
  @SerializedName("total_ugc_value")
  private Long mTotalUgcValue = null;
  @SerializedName("total_value")
  private Long mTotalValue = null;
  @SerializedName("trending_age")
  private List<Map<String, List<Map<String, Double>>>> mTrendingAge = null;
  @SerializedName("trending_gender")
  private List<Map<String, List<Map<String, Double>>>> mTrendingGender = null;
  @SerializedName("trending_interest")
  private List<Map<String, List<Map<String, Double>>>> mTrendingInterest = null;
  @SerializedName("trending_territory")
  private List<Map<String, List<Map<String, Double>>>> mTrendingTerritory = null;
  protected static Gson gson = null;

  public MIXInsightsResult() {
  }

  public String getId() {
    return null;
  }
  public static MIXInsightsResult loadJSON(String json, APIContext context, String header) {
    MIXInsightsResult mixInsightsResult = getGson().fromJson(json, MIXInsightsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mixInsightsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mixInsightsResult.context = context;
    mixInsightsResult.rawValue = json;
    mixInsightsResult.header = header;
    return mixInsightsResult;
  }

  public static APINodeList<MIXInsightsResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MIXInsightsResult> mixInsightsResults = new APINodeList<MIXInsightsResult>(request, json, header);
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
          mixInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mixInsightsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mixInsightsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mixInsightsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mixInsightsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mixInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mixInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mixInsightsResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mixInsightsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mixInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mixInsightsResults;
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
              mixInsightsResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mixInsightsResults;
          }

          // Sixth, check if it's pure JsonObject
          mixInsightsResults.clear();
          mixInsightsResults.add(loadJSON(json, context, header));
          return mixInsightsResults;
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


  public List<Map<String, List<Map<String, Long>>>> getFieldDailyAgeGenderBreakdown() {
    return mDailyAgeGenderBreakdown;
  }

  public MIXInsightsResult setFieldDailyAgeGenderBreakdown(List<Map<String, List<Map<String, Long>>>> value) {
    this.mDailyAgeGenderBreakdown = value;
    return this;
  }

  public List<Map<String, Long>> getFieldDailyAudioLibraryValues() {
    return mDailyAudioLibraryValues;
  }

  public MIXInsightsResult setFieldDailyAudioLibraryValues(List<Map<String, Long>> value) {
    this.mDailyAudioLibraryValues = value;
    return this;
  }

  public List<Map<String, Long>> getFieldDailyUgcValues() {
    return mDailyUgcValues;
  }

  public MIXInsightsResult setFieldDailyUgcValues(List<Map<String, Long>> value) {
    this.mDailyUgcValues = value;
    return this;
  }

  public List<Map<String, Long>> getFieldDailyValues() {
    return mDailyValues;
  }

  public MIXInsightsResult setFieldDailyValues(List<Map<String, Long>> value) {
    this.mDailyValues = value;
    return this;
  }

  public String getFieldMetric() {
    return mMetric;
  }

  public MIXInsightsResult setFieldMetric(String value) {
    this.mMetric = value;
    return this;
  }

  public List<Map<String, Long>> getFieldMonthlyAudioLibraryValues() {
    return mMonthlyAudioLibraryValues;
  }

  public MIXInsightsResult setFieldMonthlyAudioLibraryValues(List<Map<String, Long>> value) {
    this.mMonthlyAudioLibraryValues = value;
    return this;
  }

  public List<Map<String, Long>> getFieldMonthlyUgcValues() {
    return mMonthlyUgcValues;
  }

  public MIXInsightsResult setFieldMonthlyUgcValues(List<Map<String, Long>> value) {
    this.mMonthlyUgcValues = value;
    return this;
  }

  public List<Map<String, Long>> getFieldMonthlyValues() {
    return mMonthlyValues;
  }

  public MIXInsightsResult setFieldMonthlyValues(List<Map<String, Long>> value) {
    this.mMonthlyValues = value;
    return this;
  }

  public Double getFieldPercentGrowth() {
    return mPercentGrowth;
  }

  public MIXInsightsResult setFieldPercentGrowth(Double value) {
    this.mPercentGrowth = value;
    return this;
  }

  public List<Map<String, List<Map<String, Boolean>>>> getFieldShieldedFields() {
    return mShieldedFields;
  }

  public MIXInsightsResult setFieldShieldedFields(List<Map<String, List<Map<String, Boolean>>>> value) {
    this.mShieldedFields = value;
    return this;
  }

  public List<Map<String, Long>> getFieldTotalAgeGenderBreakdown() {
    return mTotalAgeGenderBreakdown;
  }

  public MIXInsightsResult setFieldTotalAgeGenderBreakdown(List<Map<String, Long>> value) {
    this.mTotalAgeGenderBreakdown = value;
    return this;
  }

  public Long getFieldTotalAudioLibraryValue() {
    return mTotalAudioLibraryValue;
  }

  public MIXInsightsResult setFieldTotalAudioLibraryValue(Long value) {
    this.mTotalAudioLibraryValue = value;
    return this;
  }

  public List<Map<String, Long>> getFieldTotalCountryBreakdown() {
    return mTotalCountryBreakdown;
  }

  public MIXInsightsResult setFieldTotalCountryBreakdown(List<Map<String, Long>> value) {
    this.mTotalCountryBreakdown = value;
    return this;
  }

  public List<Map<String, Long>> getFieldTotalLocaleBreakdown() {
    return mTotalLocaleBreakdown;
  }

  public MIXInsightsResult setFieldTotalLocaleBreakdown(List<Map<String, Long>> value) {
    this.mTotalLocaleBreakdown = value;
    return this;
  }

  public List<Map<String, Long>> getFieldTotalProductBreakdown() {
    return mTotalProductBreakdown;
  }

  public MIXInsightsResult setFieldTotalProductBreakdown(List<Map<String, Long>> value) {
    this.mTotalProductBreakdown = value;
    return this;
  }

  public Long getFieldTotalUgcValue() {
    return mTotalUgcValue;
  }

  public MIXInsightsResult setFieldTotalUgcValue(Long value) {
    this.mTotalUgcValue = value;
    return this;
  }

  public Long getFieldTotalValue() {
    return mTotalValue;
  }

  public MIXInsightsResult setFieldTotalValue(Long value) {
    this.mTotalValue = value;
    return this;
  }

  public List<Map<String, List<Map<String, Double>>>> getFieldTrendingAge() {
    return mTrendingAge;
  }

  public MIXInsightsResult setFieldTrendingAge(List<Map<String, List<Map<String, Double>>>> value) {
    this.mTrendingAge = value;
    return this;
  }

  public List<Map<String, List<Map<String, Double>>>> getFieldTrendingGender() {
    return mTrendingGender;
  }

  public MIXInsightsResult setFieldTrendingGender(List<Map<String, List<Map<String, Double>>>> value) {
    this.mTrendingGender = value;
    return this;
  }

  public List<Map<String, List<Map<String, Double>>>> getFieldTrendingInterest() {
    return mTrendingInterest;
  }

  public MIXInsightsResult setFieldTrendingInterest(List<Map<String, List<Map<String, Double>>>> value) {
    this.mTrendingInterest = value;
    return this;
  }

  public List<Map<String, List<Map<String, Double>>>> getFieldTrendingTerritory() {
    return mTrendingTerritory;
  }

  public MIXInsightsResult setFieldTrendingTerritory(List<Map<String, List<Map<String, Double>>>> value) {
    this.mTrendingTerritory = value;
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

  public MIXInsightsResult copyFrom(MIXInsightsResult instance) {
    this.mDailyAgeGenderBreakdown = instance.mDailyAgeGenderBreakdown;
    this.mDailyAudioLibraryValues = instance.mDailyAudioLibraryValues;
    this.mDailyUgcValues = instance.mDailyUgcValues;
    this.mDailyValues = instance.mDailyValues;
    this.mMetric = instance.mMetric;
    this.mMonthlyAudioLibraryValues = instance.mMonthlyAudioLibraryValues;
    this.mMonthlyUgcValues = instance.mMonthlyUgcValues;
    this.mMonthlyValues = instance.mMonthlyValues;
    this.mPercentGrowth = instance.mPercentGrowth;
    this.mShieldedFields = instance.mShieldedFields;
    this.mTotalAgeGenderBreakdown = instance.mTotalAgeGenderBreakdown;
    this.mTotalAudioLibraryValue = instance.mTotalAudioLibraryValue;
    this.mTotalCountryBreakdown = instance.mTotalCountryBreakdown;
    this.mTotalLocaleBreakdown = instance.mTotalLocaleBreakdown;
    this.mTotalProductBreakdown = instance.mTotalProductBreakdown;
    this.mTotalUgcValue = instance.mTotalUgcValue;
    this.mTotalValue = instance.mTotalValue;
    this.mTrendingAge = instance.mTrendingAge;
    this.mTrendingGender = instance.mTrendingGender;
    this.mTrendingInterest = instance.mTrendingInterest;
    this.mTrendingTerritory = instance.mTrendingTerritory;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MIXInsightsResult> getParser() {
    return new APIRequest.ResponseParser<MIXInsightsResult>() {
      public APINodeList<MIXInsightsResult> parseResponse(String response, APIContext context, APIRequest<MIXInsightsResult> request, String header) throws MalformedResponseException {
        return MIXInsightsResult.parseResponse(response, context, request, header);
      }
    };
  }
}
