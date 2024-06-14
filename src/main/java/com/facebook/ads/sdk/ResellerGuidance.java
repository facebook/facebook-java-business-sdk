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
public class ResellerGuidance extends APINode {
  @SerializedName("ad_account_first_spend_date")
  private String mAdAccountFirstSpendDate = null;
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("adopted_guidance_l7d")
  private List<String> mAdoptedGuidanceL7d = null;
  @SerializedName("advertiser_name")
  private String mAdvertiserName = null;
  @SerializedName("attributed_to_reseller_l7d")
  private Boolean mAttributedToResellerL7d = null;
  @SerializedName("available_guidance")
  private List<String> mAvailableGuidance = null;
  @SerializedName("benchmark_report_link")
  private String mBenchmarkReportLink = null;
  @SerializedName("guidance_adoption_rate_l7d")
  private Double mGuidanceAdoptionRateL7d = null;
  @SerializedName("no_adsets_gte_benchmark")
  private Long mNoAdsetsGteBenchmark = null;
  @SerializedName("no_adsets_lt_benchmark")
  private Long mNoAdsetsLtBenchmark = null;
  @SerializedName("nurtured_by_reseller_l7d")
  private Boolean mNurturedByResellerL7d = null;
  @SerializedName("planning_agency_name")
  private String mPlanningAgencyName = null;
  @SerializedName("recommendation_time")
  private String mRecommendationTime = null;
  @SerializedName("reporting_ds")
  private String mReportingDs = null;
  @SerializedName("reseller")
  private Business mReseller = null;
  @SerializedName("revenue_l30d")
  private Double mRevenueL30d = null;
  @SerializedName("ultimate_advertiser_name")
  private String mUltimateAdvertiserName = null;
  protected static Gson gson = null;

  public ResellerGuidance() {
  }

  public String getId() {
    return null;
  }
  public static ResellerGuidance loadJSON(String json, APIContext context, String header) {
    ResellerGuidance resellerGuidance = getGson().fromJson(json, ResellerGuidance.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(resellerGuidance.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    resellerGuidance.context = context;
    resellerGuidance.rawValue = json;
    resellerGuidance.header = header;
    return resellerGuidance;
  }

  public static APINodeList<ResellerGuidance> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ResellerGuidance> resellerGuidances = new APINodeList<ResellerGuidance>(request, json, header);
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
          resellerGuidances.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return resellerGuidances;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                resellerGuidances.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            resellerGuidances.setPaging(previous, next);
            if (context.hasAppSecret()) {
              resellerGuidances.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              resellerGuidances.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  resellerGuidances.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              resellerGuidances.add(loadJSON(obj.toString(), context, header));
            }
          }
          return resellerGuidances;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              resellerGuidances.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return resellerGuidances;
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
              resellerGuidances.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return resellerGuidances;
          }

          // Sixth, check if it's pure JsonObject
          resellerGuidances.clear();
          resellerGuidances.add(loadJSON(json, context, header));
          return resellerGuidances;
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


  public String getFieldAdAccountFirstSpendDate() {
    return mAdAccountFirstSpendDate;
  }

  public ResellerGuidance setFieldAdAccountFirstSpendDate(String value) {
    this.mAdAccountFirstSpendDate = value;
    return this;
  }

  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public ResellerGuidance setFieldAdAccountId(String value) {
    this.mAdAccountId = value;
    return this;
  }

  public List<String> getFieldAdoptedGuidanceL7d() {
    return mAdoptedGuidanceL7d;
  }

  public ResellerGuidance setFieldAdoptedGuidanceL7d(List<String> value) {
    this.mAdoptedGuidanceL7d = value;
    return this;
  }

  public String getFieldAdvertiserName() {
    return mAdvertiserName;
  }

  public ResellerGuidance setFieldAdvertiserName(String value) {
    this.mAdvertiserName = value;
    return this;
  }

  public Boolean getFieldAttributedToResellerL7d() {
    return mAttributedToResellerL7d;
  }

  public ResellerGuidance setFieldAttributedToResellerL7d(Boolean value) {
    this.mAttributedToResellerL7d = value;
    return this;
  }

  public List<String> getFieldAvailableGuidance() {
    return mAvailableGuidance;
  }

  public ResellerGuidance setFieldAvailableGuidance(List<String> value) {
    this.mAvailableGuidance = value;
    return this;
  }

  public String getFieldBenchmarkReportLink() {
    return mBenchmarkReportLink;
  }

  public ResellerGuidance setFieldBenchmarkReportLink(String value) {
    this.mBenchmarkReportLink = value;
    return this;
  }

  public Double getFieldGuidanceAdoptionRateL7d() {
    return mGuidanceAdoptionRateL7d;
  }

  public ResellerGuidance setFieldGuidanceAdoptionRateL7d(Double value) {
    this.mGuidanceAdoptionRateL7d = value;
    return this;
  }

  public Long getFieldNoAdsetsGteBenchmark() {
    return mNoAdsetsGteBenchmark;
  }

  public ResellerGuidance setFieldNoAdsetsGteBenchmark(Long value) {
    this.mNoAdsetsGteBenchmark = value;
    return this;
  }

  public Long getFieldNoAdsetsLtBenchmark() {
    return mNoAdsetsLtBenchmark;
  }

  public ResellerGuidance setFieldNoAdsetsLtBenchmark(Long value) {
    this.mNoAdsetsLtBenchmark = value;
    return this;
  }

  public Boolean getFieldNurturedByResellerL7d() {
    return mNurturedByResellerL7d;
  }

  public ResellerGuidance setFieldNurturedByResellerL7d(Boolean value) {
    this.mNurturedByResellerL7d = value;
    return this;
  }

  public String getFieldPlanningAgencyName() {
    return mPlanningAgencyName;
  }

  public ResellerGuidance setFieldPlanningAgencyName(String value) {
    this.mPlanningAgencyName = value;
    return this;
  }

  public String getFieldRecommendationTime() {
    return mRecommendationTime;
  }

  public ResellerGuidance setFieldRecommendationTime(String value) {
    this.mRecommendationTime = value;
    return this;
  }

  public String getFieldReportingDs() {
    return mReportingDs;
  }

  public ResellerGuidance setFieldReportingDs(String value) {
    this.mReportingDs = value;
    return this;
  }

  public Business getFieldReseller() {
    if (mReseller != null) {
      mReseller.context = getContext();
    }
    return mReseller;
  }

  public ResellerGuidance setFieldReseller(Business value) {
    this.mReseller = value;
    return this;
  }

  public ResellerGuidance setFieldReseller(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mReseller = Business.getGson().fromJson(value, type);
    return this;
  }
  public Double getFieldRevenueL30d() {
    return mRevenueL30d;
  }

  public ResellerGuidance setFieldRevenueL30d(Double value) {
    this.mRevenueL30d = value;
    return this;
  }

  public String getFieldUltimateAdvertiserName() {
    return mUltimateAdvertiserName;
  }

  public ResellerGuidance setFieldUltimateAdvertiserName(String value) {
    this.mUltimateAdvertiserName = value;
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

  public ResellerGuidance copyFrom(ResellerGuidance instance) {
    this.mAdAccountFirstSpendDate = instance.mAdAccountFirstSpendDate;
    this.mAdAccountId = instance.mAdAccountId;
    this.mAdoptedGuidanceL7d = instance.mAdoptedGuidanceL7d;
    this.mAdvertiserName = instance.mAdvertiserName;
    this.mAttributedToResellerL7d = instance.mAttributedToResellerL7d;
    this.mAvailableGuidance = instance.mAvailableGuidance;
    this.mBenchmarkReportLink = instance.mBenchmarkReportLink;
    this.mGuidanceAdoptionRateL7d = instance.mGuidanceAdoptionRateL7d;
    this.mNoAdsetsGteBenchmark = instance.mNoAdsetsGteBenchmark;
    this.mNoAdsetsLtBenchmark = instance.mNoAdsetsLtBenchmark;
    this.mNurturedByResellerL7d = instance.mNurturedByResellerL7d;
    this.mPlanningAgencyName = instance.mPlanningAgencyName;
    this.mRecommendationTime = instance.mRecommendationTime;
    this.mReportingDs = instance.mReportingDs;
    this.mReseller = instance.mReseller;
    this.mRevenueL30d = instance.mRevenueL30d;
    this.mUltimateAdvertiserName = instance.mUltimateAdvertiserName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ResellerGuidance> getParser() {
    return new APIRequest.ResponseParser<ResellerGuidance>() {
      public APINodeList<ResellerGuidance> parseResponse(String response, APIContext context, APIRequest<ResellerGuidance> request, String header) throws MalformedResponseException {
        return ResellerGuidance.parseResponse(response, context, request, header);
      }
    };
  }
}
