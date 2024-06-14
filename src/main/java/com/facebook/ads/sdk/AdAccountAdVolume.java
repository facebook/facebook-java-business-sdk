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
public class AdAccountAdVolume extends APINode {
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("actor_name")
  private String mActorName = null;
  @SerializedName("ad_limit_scope_business")
  private Business mAdLimitScopeBusiness = null;
  @SerializedName("ad_limit_scope_business_manager_id")
  private String mAdLimitScopeBusinessManagerId = null;
  @SerializedName("ad_limit_set_by_page_admin")
  private Long mAdLimitSetByPageAdmin = null;
  @SerializedName("ads_running_or_in_review_count")
  private Long mAdsRunningOrInReviewCount = null;
  @SerializedName("ads_running_or_in_review_count_subject_to_limit_set_by_page")
  private Long mAdsRunningOrInReviewCountSubjectToLimitSetByPage = null;
  @SerializedName("current_account_ads_running_or_in_review_count")
  private Long mCurrentAccountAdsRunningOrInReviewCount = null;
  @SerializedName("future_limit_activation_date")
  private String mFutureLimitActivationDate = null;
  @SerializedName("future_limit_on_ads_running_or_in_review")
  private Long mFutureLimitOnAdsRunningOrInReview = null;
  @SerializedName("limit_on_ads_running_or_in_review")
  private Long mLimitOnAdsRunningOrInReview = null;
  @SerializedName("recommendations")
  private List<Object> mRecommendations = null;
  protected static Gson gson = null;

  public AdAccountAdVolume() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountAdVolume loadJSON(String json, APIContext context, String header) {
    AdAccountAdVolume adAccountAdVolume = getGson().fromJson(json, AdAccountAdVolume.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountAdVolume.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountAdVolume.context = context;
    adAccountAdVolume.rawValue = json;
    adAccountAdVolume.header = header;
    return adAccountAdVolume;
  }

  public static APINodeList<AdAccountAdVolume> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountAdVolume> adAccountAdVolumes = new APINodeList<AdAccountAdVolume>(request, json, header);
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
          adAccountAdVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountAdVolumes;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountAdVolumes.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountAdVolumes.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountAdVolumes.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountAdVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountAdVolumes.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountAdVolumes.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountAdVolumes;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountAdVolumes.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountAdVolumes;
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
              adAccountAdVolumes.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountAdVolumes;
          }

          // Sixth, check if it's pure JsonObject
          adAccountAdVolumes.clear();
          adAccountAdVolumes.add(loadJSON(json, context, header));
          return adAccountAdVolumes;
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


  public String getFieldActorId() {
    return mActorId;
  }

  public AdAccountAdVolume setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public String getFieldActorName() {
    return mActorName;
  }

  public AdAccountAdVolume setFieldActorName(String value) {
    this.mActorName = value;
    return this;
  }

  public Business getFieldAdLimitScopeBusiness() {
    if (mAdLimitScopeBusiness != null) {
      mAdLimitScopeBusiness.context = getContext();
    }
    return mAdLimitScopeBusiness;
  }

  public AdAccountAdVolume setFieldAdLimitScopeBusiness(Business value) {
    this.mAdLimitScopeBusiness = value;
    return this;
  }

  public AdAccountAdVolume setFieldAdLimitScopeBusiness(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mAdLimitScopeBusiness = Business.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAdLimitScopeBusinessManagerId() {
    return mAdLimitScopeBusinessManagerId;
  }

  public AdAccountAdVolume setFieldAdLimitScopeBusinessManagerId(String value) {
    this.mAdLimitScopeBusinessManagerId = value;
    return this;
  }

  public Long getFieldAdLimitSetByPageAdmin() {
    return mAdLimitSetByPageAdmin;
  }

  public AdAccountAdVolume setFieldAdLimitSetByPageAdmin(Long value) {
    this.mAdLimitSetByPageAdmin = value;
    return this;
  }

  public Long getFieldAdsRunningOrInReviewCount() {
    return mAdsRunningOrInReviewCount;
  }

  public AdAccountAdVolume setFieldAdsRunningOrInReviewCount(Long value) {
    this.mAdsRunningOrInReviewCount = value;
    return this;
  }

  public Long getFieldAdsRunningOrInReviewCountSubjectToLimitSetByPage() {
    return mAdsRunningOrInReviewCountSubjectToLimitSetByPage;
  }

  public AdAccountAdVolume setFieldAdsRunningOrInReviewCountSubjectToLimitSetByPage(Long value) {
    this.mAdsRunningOrInReviewCountSubjectToLimitSetByPage = value;
    return this;
  }

  public Long getFieldCurrentAccountAdsRunningOrInReviewCount() {
    return mCurrentAccountAdsRunningOrInReviewCount;
  }

  public AdAccountAdVolume setFieldCurrentAccountAdsRunningOrInReviewCount(Long value) {
    this.mCurrentAccountAdsRunningOrInReviewCount = value;
    return this;
  }

  public String getFieldFutureLimitActivationDate() {
    return mFutureLimitActivationDate;
  }

  public AdAccountAdVolume setFieldFutureLimitActivationDate(String value) {
    this.mFutureLimitActivationDate = value;
    return this;
  }

  public Long getFieldFutureLimitOnAdsRunningOrInReview() {
    return mFutureLimitOnAdsRunningOrInReview;
  }

  public AdAccountAdVolume setFieldFutureLimitOnAdsRunningOrInReview(Long value) {
    this.mFutureLimitOnAdsRunningOrInReview = value;
    return this;
  }

  public Long getFieldLimitOnAdsRunningOrInReview() {
    return mLimitOnAdsRunningOrInReview;
  }

  public AdAccountAdVolume setFieldLimitOnAdsRunningOrInReview(Long value) {
    this.mLimitOnAdsRunningOrInReview = value;
    return this;
  }

  public List<Object> getFieldRecommendations() {
    return mRecommendations;
  }

  public AdAccountAdVolume setFieldRecommendations(List<Object> value) {
    this.mRecommendations = value;
    return this;
  }



  public static enum EnumRecommendationType {
      @SerializedName("AAC_CREATION_PACKAGE")
      VALUE_AAC_CREATION_PACKAGE("AAC_CREATION_PACKAGE"),
      @SerializedName("AB_TEST")
      VALUE_AB_TEST("AB_TEST"),
      @SerializedName("ACCOUNT_SPEND_LIMIT")
      VALUE_ACCOUNT_SPEND_LIMIT("ACCOUNT_SPEND_LIMIT"),
      @SerializedName("ACO_TOGGLE")
      VALUE_ACO_TOGGLE("ACO_TOGGLE"),
      @SerializedName("ADS_REPORTING")
      VALUE_ADS_REPORTING("ADS_REPORTING"),
      @SerializedName("ADVANCED_CAMPAIGN_BUDGET")
      VALUE_ADVANCED_CAMPAIGN_BUDGET("ADVANCED_CAMPAIGN_BUDGET"),
      @SerializedName("ADVANTAGE_APP_CAMPAIGN")
      VALUE_ADVANTAGE_APP_CAMPAIGN("ADVANTAGE_APP_CAMPAIGN"),
      @SerializedName("ADVANTAGE_CUSTOM_AUDIENCE")
      VALUE_ADVANTAGE_CUSTOM_AUDIENCE("ADVANTAGE_CUSTOM_AUDIENCE"),
      @SerializedName("ADVANTAGE_CUSTOM_AUDIENCE_UPSELL")
      VALUE_ADVANTAGE_CUSTOM_AUDIENCE_UPSELL("ADVANTAGE_CUSTOM_AUDIENCE_UPSELL"),
      @SerializedName("ADVANTAGE_DETAILED_TARGETING")
      VALUE_ADVANTAGE_DETAILED_TARGETING("ADVANTAGE_DETAILED_TARGETING"),
      @SerializedName("ADVANTAGE_LOOKALIKE_AUDIENCE")
      VALUE_ADVANTAGE_LOOKALIKE_AUDIENCE("ADVANTAGE_LOOKALIKE_AUDIENCE"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE")
      VALUE_ADVANTAGE_PLUS_AUDIENCE("ADVANTAGE_PLUS_AUDIENCE"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_DUPLICATION")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_DUPLICATION("ADVANTAGE_PLUS_AUDIENCE_DUPLICATION"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_FRICTION")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_FRICTION("ADVANTAGE_PLUS_AUDIENCE_FRICTION"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_TOGGLE")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_TOGGLE("ADVANTAGE_PLUS_AUDIENCE_TOGGLE"),
      @SerializedName("ADVANTAGE_PLUS_CAMPAIGN_BUDGET")
      VALUE_ADVANTAGE_PLUS_CAMPAIGN_BUDGET("ADVANTAGE_PLUS_CAMPAIGN_BUDGET"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE")
      VALUE_ADVANTAGE_PLUS_CREATIVE("ADVANTAGE_PLUS_CREATIVE"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE_CATALOG")
      VALUE_ADVANTAGE_PLUS_CREATIVE_CATALOG("ADVANTAGE_PLUS_CREATIVE_CATALOG"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE_SE")
      VALUE_ADVANTAGE_PLUS_CREATIVE_SE("ADVANTAGE_PLUS_CREATIVE_SE"),
      @SerializedName("ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION")
      VALUE_ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION("ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION"),
      @SerializedName("ADVANTAGE_PLUS_PLACEMENTS_FRICTION")
      VALUE_ADVANTAGE_PLUS_PLACEMENTS_FRICTION("ADVANTAGE_PLUS_PLACEMENTS_FRICTION"),
      @SerializedName("ADVANTAGE_SHOPPING_CAMPAIGN")
      VALUE_ADVANTAGE_SHOPPING_CAMPAIGN("ADVANTAGE_SHOPPING_CAMPAIGN"),
      @SerializedName("ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION")
      VALUE_ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION("ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION"),
      @SerializedName("AD_OBJECTIVE")
      VALUE_AD_OBJECTIVE("AD_OBJECTIVE"),
      @SerializedName("AEM_V2_INELIGIBLE")
      VALUE_AEM_V2_INELIGIBLE("AEM_V2_INELIGIBLE"),
      @SerializedName("AGGREGATED_BID_LIMITED")
      VALUE_AGGREGATED_BID_LIMITED("AGGREGATED_BID_LIMITED"),
      @SerializedName("AGGREGATED_BUDGET_LIMITED")
      VALUE_AGGREGATED_BUDGET_LIMITED("AGGREGATED_BUDGET_LIMITED"),
      @SerializedName("AGGREGATED_COST_LIMITED")
      VALUE_AGGREGATED_COST_LIMITED("AGGREGATED_COST_LIMITED"),
      @SerializedName("APP_AEM_V2_INSTALLATION_PROMOTION")
      VALUE_APP_AEM_V2_INSTALLATION_PROMOTION("APP_AEM_V2_INSTALLATION_PROMOTION"),
      @SerializedName("ASC_BUDGET_OPTIMIZATION")
      VALUE_ASC_BUDGET_OPTIMIZATION("ASC_BUDGET_OPTIMIZATION"),
      @SerializedName("ASC_CREATION_PACKAGE")
      VALUE_ASC_CREATION_PACKAGE("ASC_CREATION_PACKAGE"),
      @SerializedName("ASC_FRAGMENTATION_V2")
      VALUE_ASC_FRAGMENTATION_V2("ASC_FRAGMENTATION_V2"),
      @SerializedName("ASPECT_RATIO")
      VALUE_ASPECT_RATIO("ASPECT_RATIO"),
      @SerializedName("ATLEAST_6_PLACEMENTS")
      VALUE_ATLEAST_6_PLACEMENTS("ATLEAST_6_PLACEMENTS"),
      @SerializedName("AUCTION_OVERLAP")
      VALUE_AUCTION_OVERLAP("AUCTION_OVERLAP"),
      @SerializedName("AUCTION_OVERLAP_CONSOLIDATION")
      VALUE_AUCTION_OVERLAP_CONSOLIDATION("AUCTION_OVERLAP_CONSOLIDATION"),
      @SerializedName("AUDIENCE_EXPANSION")
      VALUE_AUDIENCE_EXPANSION("AUDIENCE_EXPANSION"),
      @SerializedName("AUDIENCE_EXPANSION_GEORADIUS")
      VALUE_AUDIENCE_EXPANSION_GEORADIUS("AUDIENCE_EXPANSION_GEORADIUS"),
      @SerializedName("AUDIENCE_EXPANSION_RETARGETING")
      VALUE_AUDIENCE_EXPANSION_RETARGETING("AUDIENCE_EXPANSION_RETARGETING"),
      @SerializedName("AUDIENCE_LEARNING_LIMITED")
      VALUE_AUDIENCE_LEARNING_LIMITED("AUDIENCE_LEARNING_LIMITED"),
      @SerializedName("AUTOFLOW_OPT_IN")
      VALUE_AUTOFLOW_OPT_IN("AUTOFLOW_OPT_IN"),
      @SerializedName("AUTOFLOW_OPT_IN_FALLBACK_DUPLICATION_FLOW")
      VALUE_AUTOFLOW_OPT_IN_FALLBACK_DUPLICATION_FLOW("AUTOFLOW_OPT_IN_FALLBACK_DUPLICATION_FLOW"),
      @SerializedName("AUTOFLOW_OPT_IN_V2")
      VALUE_AUTOFLOW_OPT_IN_V2("AUTOFLOW_OPT_IN_V2"),
      @SerializedName("AUTOMATIC_PLACEMENTS")
      VALUE_AUTOMATIC_PLACEMENTS("AUTOMATIC_PLACEMENTS"),
      @SerializedName("AUTOMATIC_PLACEMENTS_V2")
      VALUE_AUTOMATIC_PLACEMENTS_V2("AUTOMATIC_PLACEMENTS_V2"),
      @SerializedName("AUTO_BID")
      VALUE_AUTO_BID("AUTO_BID"),
      @SerializedName("BLENDED_ADS")
      VALUE_BLENDED_ADS("BLENDED_ADS"),
      @SerializedName("BROAD_TARGETING")
      VALUE_BROAD_TARGETING("BROAD_TARGETING"),
      @SerializedName("BUDGET_LIMITED")
      VALUE_BUDGET_LIMITED("BUDGET_LIMITED"),
      @SerializedName("CAPI")
      VALUE_CAPI("CAPI"),
      @SerializedName("CAPI_PERFORMANCE_MATCH_KEY")
      VALUE_CAPI_PERFORMANCE_MATCH_KEY("CAPI_PERFORMANCE_MATCH_KEY"),
      @SerializedName("CAPI_PERFORMANCE_MATCH_KEY_V2")
      VALUE_CAPI_PERFORMANCE_MATCH_KEY_V2("CAPI_PERFORMANCE_MATCH_KEY_V2"),
      @SerializedName("CASH_REWARDS_OPT_IN")
      VALUE_CASH_REWARDS_OPT_IN("CASH_REWARDS_OPT_IN"),
      @SerializedName("CONNECTED_SOURCES")
      VALUE_CONNECTED_SOURCES("CONNECTED_SOURCES"),
      @SerializedName("CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM")
      VALUE_CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM("CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM"),
      @SerializedName("CONNECT_FACEBOOK_PAGE_TO_WHATSAPP")
      VALUE_CONNECT_FACEBOOK_PAGE_TO_WHATSAPP("CONNECT_FACEBOOK_PAGE_TO_WHATSAPP"),
      @SerializedName("CONVERSION_LEAD_ADS")
      VALUE_CONVERSION_LEAD_ADS("CONVERSION_LEAD_ADS"),
      @SerializedName("COST_GOAL")
      VALUE_COST_GOAL("COST_GOAL"),
      @SerializedName("COST_GOAL_BUDGET_LIMITED")
      VALUE_COST_GOAL_BUDGET_LIMITED("COST_GOAL_BUDGET_LIMITED"),
      @SerializedName("COST_GOAL_CPA_LIMITED")
      VALUE_COST_GOAL_CPA_LIMITED("COST_GOAL_CPA_LIMITED"),
      @SerializedName("COST_PER_RESULT")
      VALUE_COST_PER_RESULT("COST_PER_RESULT"),
      @SerializedName("CREATION_PACKAGE_UPGRADE_TO_ASC")
      VALUE_CREATION_PACKAGE_UPGRADE_TO_ASC("CREATION_PACKAGE_UPGRADE_TO_ASC"),
      @SerializedName("CREATION_PACKAGE_UPGRADE_TO_CTX")
      VALUE_CREATION_PACKAGE_UPGRADE_TO_CTX("CREATION_PACKAGE_UPGRADE_TO_CTX"),
      @SerializedName("CREATION_PACKAGE_UPGRADE_TO_TLA")
      VALUE_CREATION_PACKAGE_UPGRADE_TO_TLA("CREATION_PACKAGE_UPGRADE_TO_TLA"),
      @SerializedName("CREATION_PACKAGE_UPGRADE_TO_TMC")
      VALUE_CREATION_PACKAGE_UPGRADE_TO_TMC("CREATION_PACKAGE_UPGRADE_TO_TMC"),
      @SerializedName("CREATIVE_BADGE")
      VALUE_CREATIVE_BADGE("CREATIVE_BADGE"),
      @SerializedName("CREATIVE_DIVERSITY")
      VALUE_CREATIVE_DIVERSITY("CREATIVE_DIVERSITY"),
      @SerializedName("CREATIVE_FATIGUE")
      VALUE_CREATIVE_FATIGUE("CREATIVE_FATIGUE"),
      @SerializedName("CREATIVE_FATIGUE_HOURLY")
      VALUE_CREATIVE_FATIGUE_HOURLY("CREATIVE_FATIGUE_HOURLY"),
      @SerializedName("CREATIVE_LIMITED")
      VALUE_CREATIVE_LIMITED("CREATIVE_LIMITED"),
      @SerializedName("CREATIVE_LIMITED_HOURLY")
      VALUE_CREATIVE_LIMITED_HOURLY("CREATIVE_LIMITED_HOURLY"),
      @SerializedName("CREATOR_ADS_PA_CONVERSION")
      VALUE_CREATOR_ADS_PA_CONVERSION("CREATOR_ADS_PA_CONVERSION"),
      @SerializedName("CTA")
      VALUE_CTA("CTA"),
      @SerializedName("CTX_BUDGET_OPTIMIZATION")
      VALUE_CTX_BUDGET_OPTIMIZATION("CTX_BUDGET_OPTIMIZATION"),
      @SerializedName("CTX_CREATION_PACKAGE")
      VALUE_CTX_CREATION_PACKAGE("CTX_CREATION_PACKAGE"),
      @SerializedName("CTX_GUIDANCE")
      VALUE_CTX_GUIDANCE("CTX_GUIDANCE"),
      @SerializedName("DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS")
      VALUE_DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS("DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS"),
      @SerializedName("DA_DUPLICATION_PRODUCT_TAGS")
      VALUE_DA_DUPLICATION_PRODUCT_TAGS("DA_DUPLICATION_PRODUCT_TAGS"),
      @SerializedName("DEAD_LINK")
      VALUE_DEAD_LINK("DEAD_LINK"),
      @SerializedName("DEFRAGMENTATION_ACB")
      VALUE_DEFRAGMENTATION_ACB("DEFRAGMENTATION_ACB"),
      @SerializedName("DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET")
      VALUE_DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET("DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET"),
      @SerializedName("ECOSYSTEM_BID_REDUCE_L1_CARDINALITY")
      VALUE_ECOSYSTEM_BID_REDUCE_L1_CARDINALITY("ECOSYSTEM_BID_REDUCE_L1_CARDINALITY"),
      @SerializedName("EVC_APP_DUPLICATION_UPGRADE")
      VALUE_EVC_APP_DUPLICATION_UPGRADE("EVC_APP_DUPLICATION_UPGRADE"),
      @SerializedName("EVC_WEB_DUPLICATION_UPGRADE")
      VALUE_EVC_WEB_DUPLICATION_UPGRADE("EVC_WEB_DUPLICATION_UPGRADE"),
      @SerializedName("FRAGMENTATION")
      VALUE_FRAGMENTATION("FRAGMENTATION"),
      @SerializedName("FRAGMENTATION_V2")
      VALUE_FRAGMENTATION_V2("FRAGMENTATION_V2"),
      @SerializedName("GES_TEST")
      VALUE_GES_TEST("GES_TEST"),
      @SerializedName("GUIDANCE_CENTER_CODE_GEN")
      VALUE_GUIDANCE_CENTER_CODE_GEN("GUIDANCE_CENTER_CODE_GEN"),
      @SerializedName("HEURISTIC_DEFAULT_DURATION")
      VALUE_HEURISTIC_DEFAULT_DURATION("HEURISTIC_DEFAULT_DURATION"),
      @SerializedName("HIGH_COST")
      VALUE_HIGH_COST("HIGH_COST"),
      @SerializedName("HISTORICAL_BENCHMARK")
      VALUE_HISTORICAL_BENCHMARK("HISTORICAL_BENCHMARK"),
      @SerializedName("IG_MULTI_ADS")
      VALUE_IG_MULTI_ADS("IG_MULTI_ADS"),
      @SerializedName("LEAD_ADS_GUIDANCE")
      VALUE_LEAD_ADS_GUIDANCE("LEAD_ADS_GUIDANCE"),
      @SerializedName("LEARNING_LIMITED")
      VALUE_LEARNING_LIMITED("LEARNING_LIMITED"),
      @SerializedName("LEARNING_PAUSE_FRICTION")
      VALUE_LEARNING_PAUSE_FRICTION("LEARNING_PAUSE_FRICTION"),
      @SerializedName("LEARNING_PHASE_BUDGET_EDITS")
      VALUE_LEARNING_PHASE_BUDGET_EDITS("LEARNING_PHASE_BUDGET_EDITS"),
      @SerializedName("LOW_OUTCOME")
      VALUE_LOW_OUTCOME("LOW_OUTCOME"),
      @SerializedName("MERLIN_GUIDANCE")
      VALUE_MERLIN_GUIDANCE("MERLIN_GUIDANCE"),
      @SerializedName("MIXED_PA_COMBINE_ADSETS")
      VALUE_MIXED_PA_COMBINE_ADSETS("MIXED_PA_COMBINE_ADSETS"),
      @SerializedName("MMT_CAROUSEL_TO_VIDEO")
      VALUE_MMT_CAROUSEL_TO_VIDEO("MMT_CAROUSEL_TO_VIDEO"),
      @SerializedName("MOBILE_FIRST_VIDEO")
      VALUE_MOBILE_FIRST_VIDEO("MOBILE_FIRST_VIDEO"),
      @SerializedName("MR_AEMV2SUB_KCONSOLIDATION")
      VALUE_MR_AEMV2SUB_KCONSOLIDATION("MR_AEMV2SUB_KCONSOLIDATION"),
      @SerializedName("MULTI_TEXT")
      VALUE_MULTI_TEXT("MULTI_TEXT"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NOT_APPLICABLE")
      VALUE_NOT_APPLICABLE("NOT_APPLICABLE"),
      @SerializedName("NO_DELIVERY_STATUS")
      VALUE_NO_DELIVERY_STATUS("NO_DELIVERY_STATUS"),
      @SerializedName("OPTIMAL_BAU")
      VALUE_OPTIMAL_BAU("OPTIMAL_BAU"),
      @SerializedName("PAYMENT_METHOD")
      VALUE_PAYMENT_METHOD("PAYMENT_METHOD"),
      @SerializedName("PERFORMANT_CREATIVE_REELS_OPT_IN")
      VALUE_PERFORMANT_CREATIVE_REELS_OPT_IN("PERFORMANT_CREATIVE_REELS_OPT_IN"),
      @SerializedName("PFR_L1_INLINE_MMT")
      VALUE_PFR_L1_INLINE_MMT("PFR_L1_INLINE_MMT"),
      @SerializedName("PIXEL_UPSELL")
      VALUE_PIXEL_UPSELL("PIXEL_UPSELL"),
      @SerializedName("PREDICTIVE_CREATIVE_LIMITED")
      VALUE_PREDICTIVE_CREATIVE_LIMITED("PREDICTIVE_CREATIVE_LIMITED"),
      @SerializedName("PREDICTIVE_CREATIVE_LIMITED_HOURLY")
      VALUE_PREDICTIVE_CREATIVE_LIMITED_HOURLY("PREDICTIVE_CREATIVE_LIMITED_HOURLY"),
      @SerializedName("PREPARING_STATUS")
      VALUE_PREPARING_STATUS("PREPARING_STATUS"),
      @SerializedName("PURCHASE_OPTIMIZATION")
      VALUE_PURCHASE_OPTIMIZATION("PURCHASE_OPTIMIZATION"),
      @SerializedName("RAPID_LEARNING_LIMITED")
      VALUE_RAPID_LEARNING_LIMITED("RAPID_LEARNING_LIMITED"),
      @SerializedName("RAPID_LEARNING_PHASE")
      VALUE_RAPID_LEARNING_PHASE("RAPID_LEARNING_PHASE"),
      @SerializedName("REELS_DUPLICATION_UPSELL")
      VALUE_REELS_DUPLICATION_UPSELL("REELS_DUPLICATION_UPSELL"),
      @SerializedName("REELS_PLACEMENT")
      VALUE_REELS_PLACEMENT("REELS_PLACEMENT"),
      @SerializedName("REVERT")
      VALUE_REVERT("REVERT"),
      @SerializedName("SCALE_GOOD_CAMPAIGN")
      VALUE_SCALE_GOOD_CAMPAIGN("SCALE_GOOD_CAMPAIGN"),
      @SerializedName("SEMANTIC_BASED_AUDIENCE_EXPANSION")
      VALUE_SEMANTIC_BASED_AUDIENCE_EXPANSION("SEMANTIC_BASED_AUDIENCE_EXPANSION"),
      @SerializedName("SETUP_PIXEL")
      VALUE_SETUP_PIXEL("SETUP_PIXEL"),
      @SerializedName("SHOPS_ADS")
      VALUE_SHOPS_ADS("SHOPS_ADS"),
      @SerializedName("SHOPS_ADS_DUPLICATION")
      VALUE_SHOPS_ADS_DUPLICATION("SHOPS_ADS_DUPLICATION"),
      @SerializedName("SIGNALS_GROWTH_CAPI")
      VALUE_SIGNALS_GROWTH_CAPI("SIGNALS_GROWTH_CAPI"),
      @SerializedName("SIGNALS_GROWTH_CAPI_TABLE")
      VALUE_SIGNALS_GROWTH_CAPI_TABLE("SIGNALS_GROWTH_CAPI_TABLE"),
      @SerializedName("SIGNALS_GROWTH_CAPI_V2")
      VALUE_SIGNALS_GROWTH_CAPI_V2("SIGNALS_GROWTH_CAPI_V2"),
      @SerializedName("SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION")
      VALUE_SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION("SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION"),
      @SerializedName("SIX_PLUS_MANUAL_PLACEMENTS")
      VALUE_SIX_PLUS_MANUAL_PLACEMENTS("SIX_PLUS_MANUAL_PLACEMENTS"),
      @SerializedName("SPEND_LIMIT")
      VALUE_SPEND_LIMIT("SPEND_LIMIT"),
      @SerializedName("SYD_TEST_MODE")
      VALUE_SYD_TEST_MODE("SYD_TEST_MODE"),
      @SerializedName("TAILORED_LEAD_AD_CAMPAIGN")
      VALUE_TAILORED_LEAD_AD_CAMPAIGN("TAILORED_LEAD_AD_CAMPAIGN"),
      @SerializedName("TAILORED_MESSAGES_CAMPAIGN")
      VALUE_TAILORED_MESSAGES_CAMPAIGN("TAILORED_MESSAGES_CAMPAIGN"),
      @SerializedName("TLA_CREATION_PACKAGE")
      VALUE_TLA_CREATION_PACKAGE("TLA_CREATION_PACKAGE"),
      @SerializedName("TOP_ADSETS_WITH_ADS_UNDER_CAP")
      VALUE_TOP_ADSETS_WITH_ADS_UNDER_CAP("TOP_ADSETS_WITH_ADS_UNDER_CAP"),
      @SerializedName("TOP_CAMPAIGNS_WITH_ADS_UNDER_CAP")
      VALUE_TOP_CAMPAIGNS_WITH_ADS_UNDER_CAP("TOP_CAMPAIGNS_WITH_ADS_UNDER_CAP"),
      @SerializedName("TWO_P_GUIDANCE_CARD_AAA")
      VALUE_TWO_P_GUIDANCE_CARD_AAA("TWO_P_GUIDANCE_CARD_AAA"),
      @SerializedName("TWO_P_GUIDANCE_CARD_AUTO_PLACEMENT")
      VALUE_TWO_P_GUIDANCE_CARD_AUTO_PLACEMENT("TWO_P_GUIDANCE_CARD_AUTO_PLACEMENT"),
      @SerializedName("TWO_P_GUIDANCE_CARD_CBO_OFF")
      VALUE_TWO_P_GUIDANCE_CARD_CBO_OFF("TWO_P_GUIDANCE_CARD_CBO_OFF"),
      @SerializedName("TWO_P_GUIDANCE_CARD_CTM_PREFLIGHT")
      VALUE_TWO_P_GUIDANCE_CARD_CTM_PREFLIGHT("TWO_P_GUIDANCE_CARD_CTM_PREFLIGHT"),
      @SerializedName("UNCROP_IMAGE")
      VALUE_UNCROP_IMAGE("UNCROP_IMAGE"),
      @SerializedName("UNECONOMICAL_ADS_THROTTLING")
      VALUE_UNECONOMICAL_ADS_THROTTLING("UNECONOMICAL_ADS_THROTTLING"),
      @SerializedName("UNUSED_BUDGET")
      VALUE_UNUSED_BUDGET("UNUSED_BUDGET"),
      @SerializedName("VIDEO_LENGTH")
      VALUE_VIDEO_LENGTH("VIDEO_LENGTH"),
      @SerializedName("ZERO_CONVERSION")
      VALUE_ZERO_CONVERSION("ZERO_CONVERSION"),
      @SerializedName("ZERO_IMPRESSION")
      VALUE_ZERO_IMPRESSION("ZERO_IMPRESSION"),
      ;

      private String value;

      private EnumRecommendationType(String value) {
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

  public AdAccountAdVolume copyFrom(AdAccountAdVolume instance) {
    this.mActorId = instance.mActorId;
    this.mActorName = instance.mActorName;
    this.mAdLimitScopeBusiness = instance.mAdLimitScopeBusiness;
    this.mAdLimitScopeBusinessManagerId = instance.mAdLimitScopeBusinessManagerId;
    this.mAdLimitSetByPageAdmin = instance.mAdLimitSetByPageAdmin;
    this.mAdsRunningOrInReviewCount = instance.mAdsRunningOrInReviewCount;
    this.mAdsRunningOrInReviewCountSubjectToLimitSetByPage = instance.mAdsRunningOrInReviewCountSubjectToLimitSetByPage;
    this.mCurrentAccountAdsRunningOrInReviewCount = instance.mCurrentAccountAdsRunningOrInReviewCount;
    this.mFutureLimitActivationDate = instance.mFutureLimitActivationDate;
    this.mFutureLimitOnAdsRunningOrInReview = instance.mFutureLimitOnAdsRunningOrInReview;
    this.mLimitOnAdsRunningOrInReview = instance.mLimitOnAdsRunningOrInReview;
    this.mRecommendations = instance.mRecommendations;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountAdVolume> getParser() {
    return new APIRequest.ResponseParser<AdAccountAdVolume>() {
      public APINodeList<AdAccountAdVolume> parseResponse(String response, APIContext context, APIRequest<AdAccountAdVolume> request, String header) throws MalformedResponseException {
        return AdAccountAdVolume.parseResponse(response, context, request, header);
      }
    };
  }
}
