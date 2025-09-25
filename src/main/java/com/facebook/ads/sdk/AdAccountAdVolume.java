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
      @SerializedName("ACCOUNT_ERROR")
      VALUE_ACCOUNT_ERROR("ACCOUNT_ERROR"),
      @SerializedName("ACCOUNT_NEEDS_CREDIT")
      VALUE_ACCOUNT_NEEDS_CREDIT("ACCOUNT_NEEDS_CREDIT"),
      @SerializedName("ACCOUNT_SPEND_LIMIT")
      VALUE_ACCOUNT_SPEND_LIMIT("ACCOUNT_SPEND_LIMIT"),
      @SerializedName("ACCOUNT_SPEND_LIMIT_DUPLICATION")
      VALUE_ACCOUNT_SPEND_LIMIT_DUPLICATION("ACCOUNT_SPEND_LIMIT_DUPLICATION"),
      @SerializedName("ACO_TOGGLE")
      VALUE_ACO_TOGGLE("ACO_TOGGLE"),
      @SerializedName("ADSET_BUDGET_SHARING")
      VALUE_ADSET_BUDGET_SHARING("ADSET_BUDGET_SHARING"),
      @SerializedName("ADS_REPORTING")
      VALUE_ADS_REPORTING("ADS_REPORTING"),
      @SerializedName("ADS_STATUS")
      VALUE_ADS_STATUS("ADS_STATUS"),
      @SerializedName("ADVANCED_CAMPAIGN_BUDGET")
      VALUE_ADVANCED_CAMPAIGN_BUDGET("ADVANCED_CAMPAIGN_BUDGET"),
      @SerializedName("ADVANTAGE_APP_CAMPAIGN")
      VALUE_ADVANTAGE_APP_CAMPAIGN("ADVANTAGE_APP_CAMPAIGN"),
      @SerializedName("ADVANTAGE_CAMPAIGN_BUDGET_DUPLICATION")
      VALUE_ADVANTAGE_CAMPAIGN_BUDGET_DUPLICATION("ADVANTAGE_CAMPAIGN_BUDGET_DUPLICATION"),
      @SerializedName("ADVANTAGE_CUSTOM_AUDIENCE")
      VALUE_ADVANTAGE_CUSTOM_AUDIENCE("ADVANTAGE_CUSTOM_AUDIENCE"),
      @SerializedName("ADVANTAGE_CUSTOM_AUDIENCE_DUPLICATION")
      VALUE_ADVANTAGE_CUSTOM_AUDIENCE_DUPLICATION("ADVANTAGE_CUSTOM_AUDIENCE_DUPLICATION"),
      @SerializedName("ADVANTAGE_CUSTOM_AUDIENCE_UPSELL")
      VALUE_ADVANTAGE_CUSTOM_AUDIENCE_UPSELL("ADVANTAGE_CUSTOM_AUDIENCE_UPSELL"),
      @SerializedName("ADVANTAGE_DETAILED_TARGETING")
      VALUE_ADVANTAGE_DETAILED_TARGETING("ADVANTAGE_DETAILED_TARGETING"),
      @SerializedName("ADVANTAGE_LOOKALIKE_AUDIENCE")
      VALUE_ADVANTAGE_LOOKALIKE_AUDIENCE("ADVANTAGE_LOOKALIKE_AUDIENCE"),
      @SerializedName("ADVANTAGE_LOOKALIKE_DUPLICATION")
      VALUE_ADVANTAGE_LOOKALIKE_DUPLICATION("ADVANTAGE_LOOKALIKE_DUPLICATION"),
      @SerializedName("ADVANTAGE_PLUS_APP_CAMPAIGN")
      VALUE_ADVANTAGE_PLUS_APP_CAMPAIGN("ADVANTAGE_PLUS_APP_CAMPAIGN"),
      @SerializedName("ADVANTAGE_PLUS_APP_CAMPAIGN_PRECREATE")
      VALUE_ADVANTAGE_PLUS_APP_CAMPAIGN_PRECREATE("ADVANTAGE_PLUS_APP_CAMPAIGN_PRECREATE"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE")
      VALUE_ADVANTAGE_PLUS_AUDIENCE("ADVANTAGE_PLUS_AUDIENCE"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_DUPLICATION")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_DUPLICATION("ADVANTAGE_PLUS_AUDIENCE_DUPLICATION"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_FRICTION")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_FRICTION("ADVANTAGE_PLUS_AUDIENCE_FRICTION"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_TOGGLE")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_TOGGLE("ADVANTAGE_PLUS_AUDIENCE_TOGGLE"),
      @SerializedName("ADVANTAGE_PLUS_AUDIENCE_V2")
      VALUE_ADVANTAGE_PLUS_AUDIENCE_V2("ADVANTAGE_PLUS_AUDIENCE_V2"),
      @SerializedName("ADVANTAGE_PLUS_CAMPAIGN_BUDGET")
      VALUE_ADVANTAGE_PLUS_CAMPAIGN_BUDGET("ADVANTAGE_PLUS_CAMPAIGN_BUDGET"),
      @SerializedName("ADVANTAGE_PLUS_CATALOG_ADS")
      VALUE_ADVANTAGE_PLUS_CATALOG_ADS("ADVANTAGE_PLUS_CATALOG_ADS"),
      @SerializedName("ADVANTAGE_PLUS_CATALOG_ADS_V2")
      VALUE_ADVANTAGE_PLUS_CATALOG_ADS_V2("ADVANTAGE_PLUS_CATALOG_ADS_V2"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE")
      VALUE_ADVANTAGE_PLUS_CREATIVE("ADVANTAGE_PLUS_CREATIVE"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE_CATALOG")
      VALUE_ADVANTAGE_PLUS_CREATIVE_CATALOG("ADVANTAGE_PLUS_CREATIVE_CATALOG"),
      @SerializedName("ADVANTAGE_PLUS_CREATIVE_SE")
      VALUE_ADVANTAGE_PLUS_CREATIVE_SE("ADVANTAGE_PLUS_CREATIVE_SE"),
      @SerializedName("ADVANTAGE_PLUS_LEAD_CAMPAIGN")
      VALUE_ADVANTAGE_PLUS_LEAD_CAMPAIGN("ADVANTAGE_PLUS_LEAD_CAMPAIGN"),
      @SerializedName("ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION")
      VALUE_ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION("ADVANTAGE_PLUS_PLACEMENTS_DUPLICATION"),
      @SerializedName("ADVANTAGE_PLUS_PLACEMENTS_FRICTION")
      VALUE_ADVANTAGE_PLUS_PLACEMENTS_FRICTION("ADVANTAGE_PLUS_PLACEMENTS_FRICTION"),
      @SerializedName("ADVANTAGE_PLUS_PLACEMENTS_V2_DUPLICATION")
      VALUE_ADVANTAGE_PLUS_PLACEMENTS_V2_DUPLICATION("ADVANTAGE_PLUS_PLACEMENTS_V2_DUPLICATION"),
      @SerializedName("ADVANTAGE_SHOPPING_CAMPAIGN")
      VALUE_ADVANTAGE_SHOPPING_CAMPAIGN("ADVANTAGE_SHOPPING_CAMPAIGN"),
      @SerializedName("ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION")
      VALUE_ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION("ADVANTAGE_SHOPPING_CAMPAIGN_FRAGMENTATION"),
      @SerializedName("AD_ACCOUNT_PLACEMENT_CONTROLS_UPSELL")
      VALUE_AD_ACCOUNT_PLACEMENT_CONTROLS_UPSELL("AD_ACCOUNT_PLACEMENT_CONTROLS_UPSELL"),
      @SerializedName("AD_LIFT_RECALL_GOAL")
      VALUE_AD_LIFT_RECALL_GOAL("AD_LIFT_RECALL_GOAL"),
      @SerializedName("AD_LIFT_RECALL_GOAL_PRECREATE")
      VALUE_AD_LIFT_RECALL_GOAL_PRECREATE("AD_LIFT_RECALL_GOAL_PRECREATE"),
      @SerializedName("AD_LIFT_RECALL_OPTIMIZATION_GOAL")
      VALUE_AD_LIFT_RECALL_OPTIMIZATION_GOAL("AD_LIFT_RECALL_OPTIMIZATION_GOAL"),
      @SerializedName("AD_OBJECTIVE")
      VALUE_AD_OBJECTIVE("AD_OBJECTIVE"),
      @SerializedName("AD_SET_BUDGET_SHARING_GUIDANCE")
      VALUE_AD_SET_BUDGET_SHARING_GUIDANCE("AD_SET_BUDGET_SHARING_GUIDANCE"),
      @SerializedName("AEM_V2_INELIGIBLE")
      VALUE_AEM_V2_INELIGIBLE("AEM_V2_INELIGIBLE"),
      @SerializedName("AGGREGATED_BID_LIMITED")
      VALUE_AGGREGATED_BID_LIMITED("AGGREGATED_BID_LIMITED"),
      @SerializedName("AGGREGATED_BUDGET_LIMITED")
      VALUE_AGGREGATED_BUDGET_LIMITED("AGGREGATED_BUDGET_LIMITED"),
      @SerializedName("AGGREGATED_COST_LIMITED")
      VALUE_AGGREGATED_COST_LIMITED("AGGREGATED_COST_LIMITED"),
      @SerializedName("AI_GENERATED_ICEBREAKERS")
      VALUE_AI_GENERATED_ICEBREAKERS("AI_GENERATED_ICEBREAKERS"),
      @SerializedName("AMA_UPSELL")
      VALUE_AMA_UPSELL("AMA_UPSELL"),
      @SerializedName("APLUSC_ADD_OVERLAYS")
      VALUE_APLUSC_ADD_OVERLAYS("APLUSC_ADD_OVERLAYS"),
      @SerializedName("APLUSC_BIZ_AI_AGENT")
      VALUE_APLUSC_BIZ_AI_AGENT("APLUSC_BIZ_AI_AGENT"),
      @SerializedName("APLUSC_DYNAMIC_DESCRIPTION")
      VALUE_APLUSC_DYNAMIC_DESCRIPTION("APLUSC_DYNAMIC_DESCRIPTION"),
      @SerializedName("APLUSC_FLEXIBLE_MEDIA")
      VALUE_APLUSC_FLEXIBLE_MEDIA("APLUSC_FLEXIBLE_MEDIA"),
      @SerializedName("APLUSC_IMAGE_BACKGROUND_GENERATION")
      VALUE_APLUSC_IMAGE_BACKGROUND_GENERATION("APLUSC_IMAGE_BACKGROUND_GENERATION"),
      @SerializedName("APLUSC_MUSIC")
      VALUE_APLUSC_MUSIC("APLUSC_MUSIC"),
      @SerializedName("APLUSC_RELEVANT_COMMENTS")
      VALUE_APLUSC_RELEVANT_COMMENTS("APLUSC_RELEVANT_COMMENTS"),
      @SerializedName("APLUSC_STANDARD_ENHANCEMENTS_BUNDLE")
      VALUE_APLUSC_STANDARD_ENHANCEMENTS_BUNDLE("APLUSC_STANDARD_ENHANCEMENTS_BUNDLE"),
      @SerializedName("APLUSC_TEXT_IMPROVEMENTS")
      VALUE_APLUSC_TEXT_IMPROVEMENTS("APLUSC_TEXT_IMPROVEMENTS"),
      @SerializedName("APLUSC_VIDEO_EXPANSION")
      VALUE_APLUSC_VIDEO_EXPANSION("APLUSC_VIDEO_EXPANSION"),
      @SerializedName("APLUSC_VISUAL_TOUCHUPS")
      VALUE_APLUSC_VISUAL_TOUCHUPS("APLUSC_VISUAL_TOUCHUPS"),
      @SerializedName("APLUS_C_CATALOG_DUPLICATION")
      VALUE_APLUS_C_CATALOG_DUPLICATION("APLUS_C_CATALOG_DUPLICATION"),
      @SerializedName("APP_AEM_V2_INSTALLATION_PROMOTION")
      VALUE_APP_AEM_V2_INSTALLATION_PROMOTION("APP_AEM_V2_INSTALLATION_PROMOTION"),
      @SerializedName("APP_ENGAGED_VIEW_CONVERSIONS_DUPLICATION")
      VALUE_APP_ENGAGED_VIEW_CONVERSIONS_DUPLICATION("APP_ENGAGED_VIEW_CONVERSIONS_DUPLICATION"),
      @SerializedName("ASC_AUTOMATION")
      VALUE_ASC_AUTOMATION("ASC_AUTOMATION"),
      @SerializedName("ASC_BUDGET_OPTIMIZATION")
      VALUE_ASC_BUDGET_OPTIMIZATION("ASC_BUDGET_OPTIMIZATION"),
      @SerializedName("ASC_CREATION_PACKAGE")
      VALUE_ASC_CREATION_PACKAGE("ASC_CREATION_PACKAGE"),
      @SerializedName("ASC_FRAGMENTATION_V2")
      VALUE_ASC_FRAGMENTATION_V2("ASC_FRAGMENTATION_V2"),
      @SerializedName("ASC_PRECREATE")
      VALUE_ASC_PRECREATE("ASC_PRECREATE"),
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
      @SerializedName("AUDIENCE_EXPANSION_LOOKALIKE")
      VALUE_AUDIENCE_EXPANSION_LOOKALIKE("AUDIENCE_EXPANSION_LOOKALIKE"),
      @SerializedName("AUDIENCE_EXPANSION_RETARGETING")
      VALUE_AUDIENCE_EXPANSION_RETARGETING("AUDIENCE_EXPANSION_RETARGETING"),
      @SerializedName("AUDIENCE_LEARNING_LIMITED")
      VALUE_AUDIENCE_LEARNING_LIMITED("AUDIENCE_LEARNING_LIMITED"),
      @SerializedName("AUTOBID_TO_MANUAL_BID")
      VALUE_AUTOBID_TO_MANUAL_BID("AUTOBID_TO_MANUAL_BID"),
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
      @SerializedName("AUTOMATIC_PLACEMENTS_V3")
      VALUE_AUTOMATIC_PLACEMENTS_V3("AUTOMATIC_PLACEMENTS_V3"),
      @SerializedName("AUTO_BID")
      VALUE_AUTO_BID("AUTO_BID"),
      @SerializedName("AUTO_CAT_SELECTION_ENHANCEMENT")
      VALUE_AUTO_CAT_SELECTION_ENHANCEMENT("AUTO_CAT_SELECTION_ENHANCEMENT"),
      @SerializedName("B2P_MESSAGING_UPSELL")
      VALUE_B2P_MESSAGING_UPSELL("B2P_MESSAGING_UPSELL"),
      @SerializedName("BACKGROUND_GENERATION")
      VALUE_BACKGROUND_GENERATION("BACKGROUND_GENERATION"),
      @SerializedName("BID_LIMITED_SENSITIVE")
      VALUE_BID_LIMITED_SENSITIVE("BID_LIMITED_SENSITIVE"),
      @SerializedName("BID_LIMITED_STARVING")
      VALUE_BID_LIMITED_STARVING("BID_LIMITED_STARVING"),
      @SerializedName("BLENDED_ADS")
      VALUE_BLENDED_ADS("BLENDED_ADS"),
      @SerializedName("BLENDED_ADS_DUPLICATION")
      VALUE_BLENDED_ADS_DUPLICATION("BLENDED_ADS_DUPLICATION"),
      @SerializedName("BLENDED_ADS_FOR_SHOPS_ADS_DUPLICATION")
      VALUE_BLENDED_ADS_FOR_SHOPS_ADS_DUPLICATION("BLENDED_ADS_FOR_SHOPS_ADS_DUPLICATION"),
      @SerializedName("BPBAA_WITH_CAPI_UPSELL")
      VALUE_BPBAA_WITH_CAPI_UPSELL("BPBAA_WITH_CAPI_UPSELL"),
      @SerializedName("BROADGEO_AM_UPSELL_GUIDANCE")
      VALUE_BROADGEO_AM_UPSELL_GUIDANCE("BROADGEO_AM_UPSELL_GUIDANCE"),
      @SerializedName("BROAD_TARGETING")
      VALUE_BROAD_TARGETING("BROAD_TARGETING"),
      @SerializedName("BUDGET_AMORTIZATION")
      VALUE_BUDGET_AMORTIZATION("BUDGET_AMORTIZATION"),
      @SerializedName("BUDGET_LIMITED")
      VALUE_BUDGET_LIMITED("BUDGET_LIMITED"),
      @SerializedName("BUDGET_REALLOCATION")
      VALUE_BUDGET_REALLOCATION("BUDGET_REALLOCATION"),
      @SerializedName("BUDGET_SEASONAL_GUIDANCE")
      VALUE_BUDGET_SEASONAL_GUIDANCE("BUDGET_SEASONAL_GUIDANCE"),
      @SerializedName("BUSINESS_AI_AGENT_UPSELL")
      VALUE_BUSINESS_AI_AGENT_UPSELL("BUSINESS_AI_AGENT_UPSELL"),
      @SerializedName("CALL_ADS_DAYPARTING_L3_RECOMMENDATION")
      VALUE_CALL_ADS_DAYPARTING_L3_RECOMMENDATION("CALL_ADS_DAYPARTING_L3_RECOMMENDATION"),
      @SerializedName("CAMPAIGN_GUIDANCE_NAVIGATOR_REELS_TIPS")
      VALUE_CAMPAIGN_GUIDANCE_NAVIGATOR_REELS_TIPS("CAMPAIGN_GUIDANCE_NAVIGATOR_REELS_TIPS"),
      @SerializedName("CAMPAIGN_SPEND_LIMIT")
      VALUE_CAMPAIGN_SPEND_LIMIT("CAMPAIGN_SPEND_LIMIT"),
      @SerializedName("CAPI")
      VALUE_CAPI("CAPI"),
      @SerializedName("CAPI_CRM_FUNNEL")
      VALUE_CAPI_CRM_FUNNEL("CAPI_CRM_FUNNEL"),
      @SerializedName("CAPI_CRM_GUIDANCE")
      VALUE_CAPI_CRM_GUIDANCE("CAPI_CRM_GUIDANCE"),
      @SerializedName("CAPI_CRM_GUIDANCE_V2")
      VALUE_CAPI_CRM_GUIDANCE_V2("CAPI_CRM_GUIDANCE_V2"),
      @SerializedName("CAPI_CRM_SETUP")
      VALUE_CAPI_CRM_SETUP("CAPI_CRM_SETUP"),
      @SerializedName("CAPI_EVENT_COVERAGE")
      VALUE_CAPI_EVENT_COVERAGE("CAPI_EVENT_COVERAGE"),
      @SerializedName("CAPI_PENETRATION")
      VALUE_CAPI_PENETRATION("CAPI_PENETRATION"),
      @SerializedName("CAPI_PERFORMANCE_MATCH_KEY")
      VALUE_CAPI_PERFORMANCE_MATCH_KEY("CAPI_PERFORMANCE_MATCH_KEY"),
      @SerializedName("CAPI_PERFORMANCE_MATCH_KEY_V2")
      VALUE_CAPI_PERFORMANCE_MATCH_KEY_V2("CAPI_PERFORMANCE_MATCH_KEY_V2"),
      @SerializedName("CASH_REWARDS_OPT_IN")
      VALUE_CASH_REWARDS_OPT_IN("CASH_REWARDS_OPT_IN"),
      @SerializedName("CATALOG_DYNAMIC_MEDIA")
      VALUE_CATALOG_DYNAMIC_MEDIA("CATALOG_DYNAMIC_MEDIA"),
      @SerializedName("CATALOG_MATCH_RATE")
      VALUE_CATALOG_MATCH_RATE("CATALOG_MATCH_RATE"),
      @SerializedName("COMMERCE_SHOPS_ADS_DUPLICATION")
      VALUE_COMMERCE_SHOPS_ADS_DUPLICATION("COMMERCE_SHOPS_ADS_DUPLICATION"),
      @SerializedName("CONNECTED_SOURCES")
      VALUE_CONNECTED_SOURCES("CONNECTED_SOURCES"),
      @SerializedName("CONNECTED_SOURCES_DUPLICATION")
      VALUE_CONNECTED_SOURCES_DUPLICATION("CONNECTED_SOURCES_DUPLICATION"),
      @SerializedName("CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM")
      VALUE_CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM("CONNECT_FACEBOOK_PAGE_TO_INSTAGRAM"),
      @SerializedName("CONNECT_FACEBOOK_PAGE_TO_WHATSAPP")
      VALUE_CONNECT_FACEBOOK_PAGE_TO_WHATSAPP("CONNECT_FACEBOOK_PAGE_TO_WHATSAPP"),
      @SerializedName("CONVERSION_LEADS_OPTIMIZATION")
      VALUE_CONVERSION_LEADS_OPTIMIZATION("CONVERSION_LEADS_OPTIMIZATION"),
      @SerializedName("CONVERSION_LEADS_OPTIMIZATION_DUPLICATION")
      VALUE_CONVERSION_LEADS_OPTIMIZATION_DUPLICATION("CONVERSION_LEADS_OPTIMIZATION_DUPLICATION"),
      @SerializedName("CONVERSION_LEADS_OPTIMIZATION_INTEGRATED")
      VALUE_CONVERSION_LEADS_OPTIMIZATION_INTEGRATED("CONVERSION_LEADS_OPTIMIZATION_INTEGRATED"),
      @SerializedName("CONVERSION_LEADS_OPTIMIZATION_V2")
      VALUE_CONVERSION_LEADS_OPTIMIZATION_V2("CONVERSION_LEADS_OPTIMIZATION_V2"),
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
      @SerializedName("CREATIVE_FATIGUE_DUPLICATION")
      VALUE_CREATIVE_FATIGUE_DUPLICATION("CREATIVE_FATIGUE_DUPLICATION"),
      @SerializedName("CREATIVE_FATIGUE_HOURLY")
      VALUE_CREATIVE_FATIGUE_HOURLY("CREATIVE_FATIGUE_HOURLY"),
      @SerializedName("CREATIVE_LIMITED")
      VALUE_CREATIVE_LIMITED("CREATIVE_LIMITED"),
      @SerializedName("CREATIVE_LIMITED_DUPLICATION")
      VALUE_CREATIVE_LIMITED_DUPLICATION("CREATIVE_LIMITED_DUPLICATION"),
      @SerializedName("CREATIVE_LIMITED_HOURLY")
      VALUE_CREATIVE_LIMITED_HOURLY("CREATIVE_LIMITED_HOURLY"),
      @SerializedName("CREATOR_ADS_PA_CONVERSION")
      VALUE_CREATOR_ADS_PA_CONVERSION("CREATOR_ADS_PA_CONVERSION"),
      @SerializedName("CTA")
      VALUE_CTA("CTA"),
      @SerializedName("CTD_PURCHASE_OPTIMIZATION")
      VALUE_CTD_PURCHASE_OPTIMIZATION("CTD_PURCHASE_OPTIMIZATION"),
      @SerializedName("CTM_AD_OBJECTIVE_GROWTH")
      VALUE_CTM_AD_OBJECTIVE_GROWTH("CTM_AD_OBJECTIVE_GROWTH"),
      @SerializedName("CTM_LEADS_OPTIMIZATION_UPSELL")
      VALUE_CTM_LEADS_OPTIMIZATION_UPSELL("CTM_LEADS_OPTIMIZATION_UPSELL"),
      @SerializedName("CTX_BUDGET_OPTIMIZATION")
      VALUE_CTX_BUDGET_OPTIMIZATION("CTX_BUDGET_OPTIMIZATION"),
      @SerializedName("CTX_CREATION_PACKAGE")
      VALUE_CTX_CREATION_PACKAGE("CTX_CREATION_PACKAGE"),
      @SerializedName("CTX_CREATION_PACKAGE_V2")
      VALUE_CTX_CREATION_PACKAGE_V2("CTX_CREATION_PACKAGE_V2"),
      @SerializedName("CTX_CREATIVE_LOW_OUTCOME_WARNING")
      VALUE_CTX_CREATIVE_LOW_OUTCOME_WARNING("CTX_CREATIVE_LOW_OUTCOME_WARNING"),
      @SerializedName("CTX_CTA_UPGRADE_IN_DUPLICATION")
      VALUE_CTX_CTA_UPGRADE_IN_DUPLICATION("CTX_CTA_UPGRADE_IN_DUPLICATION"),
      @SerializedName("CTX_CTMPO_UPGRADE")
      VALUE_CTX_CTMPO_UPGRADE("CTX_CTMPO_UPGRADE"),
      @SerializedName("CTX_CTWAPO_UPGRADE")
      VALUE_CTX_CTWAPO_UPGRADE("CTX_CTWAPO_UPGRADE"),
      @SerializedName("CTX_GUIDANCE")
      VALUE_CTX_GUIDANCE("CTX_GUIDANCE"),
      @SerializedName("CTX_HVS")
      VALUE_CTX_HVS("CTX_HVS"),
      @SerializedName("CTX_HVS_V2")
      VALUE_CTX_HVS_V2("CTX_HVS_V2"),
      @SerializedName("CTX_MULTI_MESSAGE_DESTINATION")
      VALUE_CTX_MULTI_MESSAGE_DESTINATION("CTX_MULTI_MESSAGE_DESTINATION"),
      @SerializedName("CTX_PRECREATE")
      VALUE_CTX_PRECREATE("CTX_PRECREATE"),
      @SerializedName("CTX_PRODUCT_EXTENSION_DUPLICATION")
      VALUE_CTX_PRODUCT_EXTENSION_DUPLICATION("CTX_PRODUCT_EXTENSION_DUPLICATION"),
      @SerializedName("CTX_SABR_CBO")
      VALUE_CTX_SABR_CBO("CTX_SABR_CBO"),
      @SerializedName("CTX_SABR_NON_CBO")
      VALUE_CTX_SABR_NON_CBO("CTX_SABR_NON_CBO"),
      @SerializedName("CTX_SMART_DEFAULTING")
      VALUE_CTX_SMART_DEFAULTING("CTX_SMART_DEFAULTING"),
      @SerializedName("CTX_VALUE_OPTIMIZATION_CTM_PO_TO_VO")
      VALUE_CTX_VALUE_OPTIMIZATION_CTM_PO_TO_VO("CTX_VALUE_OPTIMIZATION_CTM_PO_TO_VO"),
      @SerializedName("CTX_ZO_CBO")
      VALUE_CTX_ZO_CBO("CTX_ZO_CBO"),
      @SerializedName("CTX_ZO_NON_CBO")
      VALUE_CTX_ZO_NON_CBO("CTX_ZO_NON_CBO"),
      @SerializedName("CUSTOM_AUDIENCE_RELAXATION")
      VALUE_CUSTOM_AUDIENCE_RELAXATION("CUSTOM_AUDIENCE_RELAXATION"),
      @SerializedName("DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS")
      VALUE_DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS("DA_ADVANTAGE_PLUS_CREATIVE_INFO_LABELS"),
      @SerializedName("DA_DUPLICATION_PRODUCT_TAGS")
      VALUE_DA_DUPLICATION_PRODUCT_TAGS("DA_DUPLICATION_PRODUCT_TAGS"),
      @SerializedName("DEAD_LINK")
      VALUE_DEAD_LINK("DEAD_LINK"),
      @SerializedName("DEFRAGMENTATION_ACB")
      VALUE_DEFRAGMENTATION_ACB("DEFRAGMENTATION_ACB"),
      @SerializedName("DEFRAGMENTATION_ACB_DUPLICATION")
      VALUE_DEFRAGMENTATION_ACB_DUPLICATION("DEFRAGMENTATION_ACB_DUPLICATION"),
      @SerializedName("DEFRAGMENTATION_USING_VALUE_RULES_TEST_V2")
      VALUE_DEFRAGMENTATION_USING_VALUE_RULES_TEST_V2("DEFRAGMENTATION_USING_VALUE_RULES_TEST_V2"),
      @SerializedName("DELIVERY_DEPENDENT_CREATIVE_LIMITED")
      VALUE_DELIVERY_DEPENDENT_CREATIVE_LIMITED("DELIVERY_DEPENDENT_CREATIVE_LIMITED"),
      @SerializedName("DELIVERY_ERROR")
      VALUE_DELIVERY_ERROR("DELIVERY_ERROR"),
      @SerializedName("DELIVERY_ERROR_V2")
      VALUE_DELIVERY_ERROR_V2("DELIVERY_ERROR_V2"),
      @SerializedName("DELIVERY_WARNING")
      VALUE_DELIVERY_WARNING("DELIVERY_WARNING"),
      @SerializedName("DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET")
      VALUE_DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET("DYNAMIC_ADVANTAGE_CAMPAIGN_BUDGET"),
      @SerializedName("ECOSYSTEM_BID_REDUCE_L1_CARDINALITY")
      VALUE_ECOSYSTEM_BID_REDUCE_L1_CARDINALITY("ECOSYSTEM_BID_REDUCE_L1_CARDINALITY"),
      @SerializedName("EMAIL_CAPTURE_UPSELL_GUIDANCE")
      VALUE_EMAIL_CAPTURE_UPSELL_GUIDANCE("EMAIL_CAPTURE_UPSELL_GUIDANCE"),
      @SerializedName("ENABLE_WHATS_APP_ADS_DATA_SHARING")
      VALUE_ENABLE_WHATS_APP_ADS_DATA_SHARING("ENABLE_WHATS_APP_ADS_DATA_SHARING"),
      @SerializedName("ENGAGED_VIEW_CONVERSIONS_CREATION")
      VALUE_ENGAGED_VIEW_CONVERSIONS_CREATION("ENGAGED_VIEW_CONVERSIONS_CREATION"),
      @SerializedName("EVC_APP_DUPLICATION_UPGRADE")
      VALUE_EVC_APP_DUPLICATION_UPGRADE("EVC_APP_DUPLICATION_UPGRADE"),
      @SerializedName("EVC_WEB_DUPLICATION_UPGRADE")
      VALUE_EVC_WEB_DUPLICATION_UPGRADE("EVC_WEB_DUPLICATION_UPGRADE"),
      @SerializedName("F2_CONVERSION_LOCATION")
      VALUE_F2_CONVERSION_LOCATION("F2_CONVERSION_LOCATION"),
      @SerializedName("FRAGMENTATION")
      VALUE_FRAGMENTATION("FRAGMENTATION"),
      @SerializedName("FRAGMENTATION_RESOLUTION_UPDATE")
      VALUE_FRAGMENTATION_RESOLUTION_UPDATE("FRAGMENTATION_RESOLUTION_UPDATE"),
      @SerializedName("FRAGMENTATION_V2")
      VALUE_FRAGMENTATION_V2("FRAGMENTATION_V2"),
      @SerializedName("FRAGMENTATION_V3")
      VALUE_FRAGMENTATION_V3("FRAGMENTATION_V3"),
      @SerializedName("GENERATIVE_UNCROP_DUPLICATION")
      VALUE_GENERATIVE_UNCROP_DUPLICATION("GENERATIVE_UNCROP_DUPLICATION"),
      @SerializedName("GEN_AI_MVP")
      VALUE_GEN_AI_MVP("GEN_AI_MVP"),
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
      @SerializedName("IAA_ROAS_OPTIMIZATION")
      VALUE_IAA_ROAS_OPTIMIZATION("IAA_ROAS_OPTIMIZATION"),
      @SerializedName("IG_MULTI_ADS")
      VALUE_IG_MULTI_ADS("IG_MULTI_ADS"),
      @SerializedName("IG_SURFACES_MANUAL_PLACEMENTS")
      VALUE_IG_SURFACES_MANUAL_PLACEMENTS("IG_SURFACES_MANUAL_PLACEMENTS"),
      @SerializedName("INCREMENTAL_ATTRIBUTION")
      VALUE_INCREMENTAL_ATTRIBUTION("INCREMENTAL_ATTRIBUTION"),
      @SerializedName("INSTANT_FORMS_LEADS")
      VALUE_INSTANT_FORMS_LEADS("INSTANT_FORMS_LEADS"),
      @SerializedName("IN_APP_AD_IMPRESSION_ROAS_ANDROID")
      VALUE_IN_APP_AD_IMPRESSION_ROAS_ANDROID("IN_APP_AD_IMPRESSION_ROAS_ANDROID"),
      @SerializedName("LANDING_PAGE_VIEW")
      VALUE_LANDING_PAGE_VIEW("LANDING_PAGE_VIEW"),
      @SerializedName("LANDING_PAGE_VIEW_OPTIMIZATION_GOAL")
      VALUE_LANDING_PAGE_VIEW_OPTIMIZATION_GOAL("LANDING_PAGE_VIEW_OPTIMIZATION_GOAL"),
      @SerializedName("LANDING_PAGE_VIEW_OPTIMIZATION_GOAL_V2")
      VALUE_LANDING_PAGE_VIEW_OPTIMIZATION_GOAL_V2("LANDING_PAGE_VIEW_OPTIMIZATION_GOAL_V2"),
      @SerializedName("LANDING_PAGE_VIEW_PRECREATE")
      VALUE_LANDING_PAGE_VIEW_PRECREATE("LANDING_PAGE_VIEW_PRECREATE"),
      @SerializedName("LEAD_ADS_GUIDANCE")
      VALUE_LEAD_ADS_GUIDANCE("LEAD_ADS_GUIDANCE"),
      @SerializedName("LEARNING_LIMITED")
      VALUE_LEARNING_LIMITED("LEARNING_LIMITED"),
      @SerializedName("LEARNING_PAUSE_FRICTION")
      VALUE_LEARNING_PAUSE_FRICTION("LEARNING_PAUSE_FRICTION"),
      @SerializedName("LEARNING_PHASE_BUDGET_EDITS")
      VALUE_LEARNING_PHASE_BUDGET_EDITS("LEARNING_PHASE_BUDGET_EDITS"),
      @SerializedName("LIVE_VIDEO_ADS")
      VALUE_LIVE_VIDEO_ADS("LIVE_VIDEO_ADS"),
      @SerializedName("LOW_BUDGET_UTILIZATION")
      VALUE_LOW_BUDGET_UTILIZATION("LOW_BUDGET_UTILIZATION"),
      @SerializedName("LOW_OUTCOME")
      VALUE_LOW_OUTCOME("LOW_OUTCOME"),
      @SerializedName("MARKETING_MESSAGES")
      VALUE_MARKETING_MESSAGES("MARKETING_MESSAGES"),
      @SerializedName("MERLIN_GUIDANCE")
      VALUE_MERLIN_GUIDANCE("MERLIN_GUIDANCE"),
      @SerializedName("MESSAGING_EVENTS")
      VALUE_MESSAGING_EVENTS("MESSAGING_EVENTS"),
      @SerializedName("MESSAGING_EVENTS_PRECREATE")
      VALUE_MESSAGING_EVENTS_PRECREATE("MESSAGING_EVENTS_PRECREATE"),
      @SerializedName("MESSAGING_PARTNERS")
      VALUE_MESSAGING_PARTNERS("MESSAGING_PARTNERS"),
      @SerializedName("MESSAGING_PARTNERS_PRECREATE")
      VALUE_MESSAGING_PARTNERS_PRECREATE("MESSAGING_PARTNERS_PRECREATE"),
      @SerializedName("META_VERIFIED_ADS_PERFORMANCE_GUIDANCE")
      VALUE_META_VERIFIED_ADS_PERFORMANCE_GUIDANCE("META_VERIFIED_ADS_PERFORMANCE_GUIDANCE"),
      @SerializedName("MISSING_OR_INVALID_PARAMETERS")
      VALUE_MISSING_OR_INVALID_PARAMETERS("MISSING_OR_INVALID_PARAMETERS"),
      @SerializedName("MIXED_FORMATS")
      VALUE_MIXED_FORMATS("MIXED_FORMATS"),
      @SerializedName("MIXED_FORMATS_V2")
      VALUE_MIXED_FORMATS_V2("MIXED_FORMATS_V2"),
      @SerializedName("MIXED_FORMATS_V3")
      VALUE_MIXED_FORMATS_V3("MIXED_FORMATS_V3"),
      @SerializedName("MIXED_PA_COMBINE_ADSETS")
      VALUE_MIXED_PA_COMBINE_ADSETS("MIXED_PA_COMBINE_ADSETS"),
      @SerializedName("MMT_CAROUSEL_TO_VIDEO")
      VALUE_MMT_CAROUSEL_TO_VIDEO("MMT_CAROUSEL_TO_VIDEO"),
      @SerializedName("MOBILE_FIRST_CREATIVE")
      VALUE_MOBILE_FIRST_CREATIVE("MOBILE_FIRST_CREATIVE"),
      @SerializedName("MOBILE_FIRST_VIDEO")
      VALUE_MOBILE_FIRST_VIDEO("MOBILE_FIRST_VIDEO"),
      @SerializedName("MR_AEMV2SUB_KCONSOLIDATION")
      VALUE_MR_AEMV2SUB_KCONSOLIDATION("MR_AEMV2SUB_KCONSOLIDATION"),
      @SerializedName("MULTI_ADVERTISER_ADS")
      VALUE_MULTI_ADVERTISER_ADS("MULTI_ADVERTISER_ADS"),
      @SerializedName("MULTI_TEXT")
      VALUE_MULTI_TEXT("MULTI_TEXT"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NARROW_WEBSITE_CUSTOM_AUDIENCE")
      VALUE_NARROW_WEBSITE_CUSTOM_AUDIENCE("NARROW_WEBSITE_CUSTOM_AUDIENCE"),
      @SerializedName("NOT_APPLICABLE")
      VALUE_NOT_APPLICABLE("NOT_APPLICABLE"),
      @SerializedName("NO_DELIVERY_STATUS")
      VALUE_NO_DELIVERY_STATUS("NO_DELIVERY_STATUS"),
      @SerializedName("OFFSITE_CONVERSION")
      VALUE_OFFSITE_CONVERSION("OFFSITE_CONVERSION"),
      @SerializedName("OFFSITE_CONVERSION_AR")
      VALUE_OFFSITE_CONVERSION_AR("OFFSITE_CONVERSION_AR"),
      @SerializedName("OFFSITE_CONVERSION_BASED_ON_SIGNALS")
      VALUE_OFFSITE_CONVERSION_BASED_ON_SIGNALS("OFFSITE_CONVERSION_BASED_ON_SIGNALS"),
      @SerializedName("OFFSITE_CONVERSION_V2")
      VALUE_OFFSITE_CONVERSION_V2("OFFSITE_CONVERSION_V2"),
      @SerializedName("OMNI_OPTIMIZATION")
      VALUE_OMNI_OPTIMIZATION("OMNI_OPTIMIZATION"),
      @SerializedName("OPTIMAL_BAU")
      VALUE_OPTIMAL_BAU("OPTIMAL_BAU"),
      @SerializedName("OUTCOME_FORECASTER_BUDGET_RECOMMENDATION")
      VALUE_OUTCOME_FORECASTER_BUDGET_RECOMMENDATION("OUTCOME_FORECASTER_BUDGET_RECOMMENDATION"),
      @SerializedName("OUTCOME_FORECASTER_SHADOW_LOGGING")
      VALUE_OUTCOME_FORECASTER_SHADOW_LOGGING("OUTCOME_FORECASTER_SHADOW_LOGGING"),
      @SerializedName("PARTNERSHIP_ADS")
      VALUE_PARTNERSHIP_ADS("PARTNERSHIP_ADS"),
      @SerializedName("PARTNERSHIP_ADS_DYNAMIC_HEADER")
      VALUE_PARTNERSHIP_ADS_DYNAMIC_HEADER("PARTNERSHIP_ADS_DYNAMIC_HEADER"),
      @SerializedName("PAYMENT_METHOD")
      VALUE_PAYMENT_METHOD("PAYMENT_METHOD"),
      @SerializedName("PERFORMANT_CREATIVE_REELS_OPT_IN")
      VALUE_PERFORMANT_CREATIVE_REELS_OPT_IN("PERFORMANT_CREATIVE_REELS_OPT_IN"),
      @SerializedName("PERFORMANT_CREATIVE_REELS_OPT_IN_V2")
      VALUE_PERFORMANT_CREATIVE_REELS_OPT_IN_V2("PERFORMANT_CREATIVE_REELS_OPT_IN_V2"),
      @SerializedName("PFR_L1_INLINE_MMT")
      VALUE_PFR_L1_INLINE_MMT("PFR_L1_INLINE_MMT"),
      @SerializedName("PIXELLESS_LPV_OPTIMIZATION_GOAL")
      VALUE_PIXELLESS_LPV_OPTIMIZATION_GOAL("PIXELLESS_LPV_OPTIMIZATION_GOAL"),
      @SerializedName("PIXEL_OPTIMIZATION_AAM")
      VALUE_PIXEL_OPTIMIZATION_AAM("PIXEL_OPTIMIZATION_AAM"),
      @SerializedName("PIXEL_OPTIMIZATION_AAM_PRECREATE")
      VALUE_PIXEL_OPTIMIZATION_AAM_PRECREATE("PIXEL_OPTIMIZATION_AAM_PRECREATE"),
      @SerializedName("PIXEL_OPTIMIZATION_HIE")
      VALUE_PIXEL_OPTIMIZATION_HIE("PIXEL_OPTIMIZATION_HIE"),
      @SerializedName("PIXEL_OPTIMIZATION_HIE_PRECREATE")
      VALUE_PIXEL_OPTIMIZATION_HIE_PRECREATE("PIXEL_OPTIMIZATION_HIE_PRECREATE"),
      @SerializedName("PIXEL_SETUP")
      VALUE_PIXEL_SETUP("PIXEL_SETUP"),
      @SerializedName("PIXEL_SETUP_PRECREATE")
      VALUE_PIXEL_SETUP_PRECREATE("PIXEL_SETUP_PRECREATE"),
      @SerializedName("PIXEL_UPSELL")
      VALUE_PIXEL_UPSELL("PIXEL_UPSELL"),
      @SerializedName("PIXEL_UPSELL_V2")
      VALUE_PIXEL_UPSELL_V2("PIXEL_UPSELL_V2"),
      @SerializedName("PLACEMENTS_LIQUIDITY_AUTOMATIC_GUIDANCE")
      VALUE_PLACEMENTS_LIQUIDITY_AUTOMATIC_GUIDANCE("PLACEMENTS_LIQUIDITY_AUTOMATIC_GUIDANCE"),
      @SerializedName("PREDICTIVE_CREATIVE_LIMITED")
      VALUE_PREDICTIVE_CREATIVE_LIMITED("PREDICTIVE_CREATIVE_LIMITED"),
      @SerializedName("PREDICTIVE_CREATIVE_LIMITED_HOURLY")
      VALUE_PREDICTIVE_CREATIVE_LIMITED_HOURLY("PREDICTIVE_CREATIVE_LIMITED_HOURLY"),
      @SerializedName("PREPARING_STATUS")
      VALUE_PREPARING_STATUS("PREPARING_STATUS"),
      @SerializedName("PRODUCT_EXTENSIONS_GUIDANCE")
      VALUE_PRODUCT_EXTENSIONS_GUIDANCE("PRODUCT_EXTENSIONS_GUIDANCE"),
      @SerializedName("PRODUCT_SET_BOOSTING")
      VALUE_PRODUCT_SET_BOOSTING("PRODUCT_SET_BOOSTING"),
      @SerializedName("PROMO_ADS_UPSELL_GUIDANCE")
      VALUE_PROMO_ADS_UPSELL_GUIDANCE("PROMO_ADS_UPSELL_GUIDANCE"),
      @SerializedName("PURCHASE_OPTIMIZATION")
      VALUE_PURCHASE_OPTIMIZATION("PURCHASE_OPTIMIZATION"),
      @SerializedName("RAPID_LEARNING_LIMITED")
      VALUE_RAPID_LEARNING_LIMITED("RAPID_LEARNING_LIMITED"),
      @SerializedName("RAPID_LEARNING_PHASE")
      VALUE_RAPID_LEARNING_PHASE("RAPID_LEARNING_PHASE"),
      @SerializedName("REACH_OPTIMIZATION_GOAL")
      VALUE_REACH_OPTIMIZATION_GOAL("REACH_OPTIMIZATION_GOAL"),
      @SerializedName("REACH_OPTIMIZATION_GOAL_PRECREATE")
      VALUE_REACH_OPTIMIZATION_GOAL_PRECREATE("REACH_OPTIMIZATION_GOAL_PRECREATE"),
      @SerializedName("REELS_DUPLICATION_UPSELL")
      VALUE_REELS_DUPLICATION_UPSELL("REELS_DUPLICATION_UPSELL"),
      @SerializedName("REELS_MUSIC_DUPLICATION")
      VALUE_REELS_MUSIC_DUPLICATION("REELS_MUSIC_DUPLICATION"),
      @SerializedName("REELS_PC_AND_MOBILE_FIRST_CREATIVE")
      VALUE_REELS_PC_AND_MOBILE_FIRST_CREATIVE("REELS_PC_AND_MOBILE_FIRST_CREATIVE"),
      @SerializedName("REELS_PC_RECOMMENDATION")
      VALUE_REELS_PC_RECOMMENDATION("REELS_PC_RECOMMENDATION"),
      @SerializedName("REELS_PC_RECOMMENDATION_V2")
      VALUE_REELS_PC_RECOMMENDATION_V2("REELS_PC_RECOMMENDATION_V2"),
      @SerializedName("REELS_PERFORMANT_CREATIVE")
      VALUE_REELS_PERFORMANT_CREATIVE("REELS_PERFORMANT_CREATIVE"),
      @SerializedName("REELS_PLACEMENT")
      VALUE_REELS_PLACEMENT("REELS_PLACEMENT"),
      @SerializedName("REVERT")
      VALUE_REVERT("REVERT"),
      @SerializedName("REVIEW_CREATIVE_DUPLICATED_REJECTED_ADS")
      VALUE_REVIEW_CREATIVE_DUPLICATED_REJECTED_ADS("REVIEW_CREATIVE_DUPLICATED_REJECTED_ADS"),
      @SerializedName("SABR_DEFAULT_DURATION")
      VALUE_SABR_DEFAULT_DURATION("SABR_DEFAULT_DURATION"),
      @SerializedName("SALES_CONVERSION")
      VALUE_SALES_CONVERSION("SALES_CONVERSION"),
      @SerializedName("SAVED_AUDIENCE")
      VALUE_SAVED_AUDIENCE("SAVED_AUDIENCE"),
      @SerializedName("SCALE_GOOD_CAMPAIGN")
      VALUE_SCALE_GOOD_CAMPAIGN("SCALE_GOOD_CAMPAIGN"),
      @SerializedName("SCALE_GOOD_CAMPAIGN_DUPLICATION")
      VALUE_SCALE_GOOD_CAMPAIGN_DUPLICATION("SCALE_GOOD_CAMPAIGN_DUPLICATION"),
      @SerializedName("SCALE_GOOD_CAMPAIGN_SMB")
      VALUE_SCALE_GOOD_CAMPAIGN_SMB("SCALE_GOOD_CAMPAIGN_SMB"),
      @SerializedName("SCALE_GOOD_CAMPAIGN_V2_DUPLICATION")
      VALUE_SCALE_GOOD_CAMPAIGN_V2_DUPLICATION("SCALE_GOOD_CAMPAIGN_V2_DUPLICATION"),
      @SerializedName("SCALE_GOOD_CTX_CAMPAIGN")
      VALUE_SCALE_GOOD_CTX_CAMPAIGN("SCALE_GOOD_CTX_CAMPAIGN"),
      @SerializedName("SEASONAL_CAMPAIGNS")
      VALUE_SEASONAL_CAMPAIGNS("SEASONAL_CAMPAIGNS"),
      @SerializedName("SEMANTIC_BASED_AUDIENCE_DUPLICATION")
      VALUE_SEMANTIC_BASED_AUDIENCE_DUPLICATION("SEMANTIC_BASED_AUDIENCE_DUPLICATION"),
      @SerializedName("SEMANTIC_BASED_AUDIENCE_EXPANSION")
      VALUE_SEMANTIC_BASED_AUDIENCE_EXPANSION("SEMANTIC_BASED_AUDIENCE_EXPANSION"),
      @SerializedName("SETUP_PIXEL")
      VALUE_SETUP_PIXEL("SETUP_PIXEL"),
      @SerializedName("SHOPS_ADS")
      VALUE_SHOPS_ADS("SHOPS_ADS"),
      @SerializedName("SHOPS_ADS_DUPLICATION")
      VALUE_SHOPS_ADS_DUPLICATION("SHOPS_ADS_DUPLICATION"),
      @SerializedName("SHOPS_ADS_SAOFF")
      VALUE_SHOPS_ADS_SAOFF("SHOPS_ADS_SAOFF"),
      @SerializedName("SHOPS_ADS_TRAFFIC_CAP_SETTINGS")
      VALUE_SHOPS_ADS_TRAFFIC_CAP_SETTINGS("SHOPS_ADS_TRAFFIC_CAP_SETTINGS"),
      @SerializedName("SHOP_ADS_V2")
      VALUE_SHOP_ADS_V2("SHOP_ADS_V2"),
      @SerializedName("SIGNALS_DOWN_FUNNEL_EVENT_OPTIMIZATION")
      VALUE_SIGNALS_DOWN_FUNNEL_EVENT_OPTIMIZATION("SIGNALS_DOWN_FUNNEL_EVENT_OPTIMIZATION"),
      @SerializedName("SIGNALS_GROWTH_CAPI")
      VALUE_SIGNALS_GROWTH_CAPI("SIGNALS_GROWTH_CAPI"),
      @SerializedName("SIGNALS_GROWTH_CAPI_PRECREATE")
      VALUE_SIGNALS_GROWTH_CAPI_PRECREATE("SIGNALS_GROWTH_CAPI_PRECREATE"),
      @SerializedName("SIGNALS_GROWTH_CAPI_TABLE")
      VALUE_SIGNALS_GROWTH_CAPI_TABLE("SIGNALS_GROWTH_CAPI_TABLE"),
      @SerializedName("SIGNALS_GROWTH_CAPI_V2")
      VALUE_SIGNALS_GROWTH_CAPI_V2("SIGNALS_GROWTH_CAPI_V2"),
      @SerializedName("SIGNALS_VO_USING_CO_MODEL")
      VALUE_SIGNALS_VO_USING_CO_MODEL("SIGNALS_VO_USING_CO_MODEL"),
      @SerializedName("SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION")
      VALUE_SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION("SIMILAR_ADVERTISER_BUDGET_RECOMMENDATION"),
      @SerializedName("SITE_EXTENSIONS_DUPLICATION")
      VALUE_SITE_EXTENSIONS_DUPLICATION("SITE_EXTENSIONS_DUPLICATION"),
      @SerializedName("SITE_EXTENSIONS_GUIDANCE")
      VALUE_SITE_EXTENSIONS_GUIDANCE("SITE_EXTENSIONS_GUIDANCE"),
      @SerializedName("SIX_PLUS_MANUAL_PLACEMENTS")
      VALUE_SIX_PLUS_MANUAL_PLACEMENTS("SIX_PLUS_MANUAL_PLACEMENTS"),
      @SerializedName("SIX_PLUS_PLACEMENTS_DUPLICATION")
      VALUE_SIX_PLUS_PLACEMENTS_DUPLICATION("SIX_PLUS_PLACEMENTS_DUPLICATION"),
      @SerializedName("SPEND_LIMIT")
      VALUE_SPEND_LIMIT("SPEND_LIMIT"),
      @SerializedName("SYD_TEST_MODE")
      VALUE_SYD_TEST_MODE("SYD_TEST_MODE"),
      @SerializedName("TAILORED_LEAD_AD_CAMPAIGN")
      VALUE_TAILORED_LEAD_AD_CAMPAIGN("TAILORED_LEAD_AD_CAMPAIGN"),
      @SerializedName("TAILORED_MESSAGES_CAMPAIGN")
      VALUE_TAILORED_MESSAGES_CAMPAIGN("TAILORED_MESSAGES_CAMPAIGN"),
      @SerializedName("TARGETING_CREATIVE_FRAGMENTATION")
      VALUE_TARGETING_CREATIVE_FRAGMENTATION("TARGETING_CREATIVE_FRAGMENTATION"),
      @SerializedName("THREECO_WEB_PLUS_APP_UPSELL")
      VALUE_THREECO_WEB_PLUS_APP_UPSELL("THREECO_WEB_PLUS_APP_UPSELL"),
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
      @SerializedName("UNIFIED_INBOX")
      VALUE_UNIFIED_INBOX("UNIFIED_INBOX"),
      @SerializedName("UNUSED_BUDGET")
      VALUE_UNUSED_BUDGET("UNUSED_BUDGET"),
      @SerializedName("UPPER_FUNNEL_TO_LEAD_INSTANT_FORM")
      VALUE_UPPER_FUNNEL_TO_LEAD_INSTANT_FORM("UPPER_FUNNEL_TO_LEAD_INSTANT_FORM"),
      @SerializedName("VALUE_DIAGNOSTICS_GUIDANCE")
      VALUE_VALUE_DIAGNOSTICS_GUIDANCE("VALUE_DIAGNOSTICS_GUIDANCE"),
      @SerializedName("VALUE_OPTIMIZATION_GOAL")
      VALUE_VALUE_OPTIMIZATION_GOAL("VALUE_OPTIMIZATION_GOAL"),
      @SerializedName("VALUE_RULES_GUIDANCE")
      VALUE_VALUE_RULES_GUIDANCE("VALUE_RULES_GUIDANCE"),
      @SerializedName("VIDEO_LENGTH")
      VALUE_VIDEO_LENGTH("VIDEO_LENGTH"),
      @SerializedName("VIDEO_VIEWS_UPSELL")
      VALUE_VIDEO_VIEWS_UPSELL("VIDEO_VIEWS_UPSELL"),
      @SerializedName("VIDEO_VIEWS_UPSELL_PRECREATE")
      VALUE_VIDEO_VIEWS_UPSELL_PRECREATE("VIDEO_VIEWS_UPSELL_PRECREATE"),
      @SerializedName("VO_IN_APP_PURCHASE")
      VALUE_VO_IN_APP_PURCHASE("VO_IN_APP_PURCHASE"),
      @SerializedName("VO_VT_1D_DEFAULTING")
      VALUE_VO_VT_1D_DEFAULTING("VO_VT_1D_DEFAULTING"),
      @SerializedName("WA_MESSAGING_PARTNERS")
      VALUE_WA_MESSAGING_PARTNERS("WA_MESSAGING_PARTNERS"),
      @SerializedName("WA_MESSAGING_PARTNERS_PRECREATE")
      VALUE_WA_MESSAGING_PARTNERS_PRECREATE("WA_MESSAGING_PARTNERS_PRECREATE"),
      @SerializedName("WEBSITE_AND_CALLS_UPSELL")
      VALUE_WEBSITE_AND_CALLS_UPSELL("WEBSITE_AND_CALLS_UPSELL"),
      @SerializedName("WEBSITE_AND_INSTANT_FORM_L2")
      VALUE_WEBSITE_AND_INSTANT_FORM_L2("WEBSITE_AND_INSTANT_FORM_L2"),
      @SerializedName("WEB_ENGAGED_VIEW_CONVERSIONS")
      VALUE_WEB_ENGAGED_VIEW_CONVERSIONS("WEB_ENGAGED_VIEW_CONVERSIONS"),
      @SerializedName("WTWA_UPSELL_IN_DUPLICATION")
      VALUE_WTWA_UPSELL_IN_DUPLICATION("WTWA_UPSELL_IN_DUPLICATION"),
      @SerializedName("WTWA_UPSELL_IN_SYD_AND_AM_TABLE")
      VALUE_WTWA_UPSELL_IN_SYD_AND_AM_TABLE("WTWA_UPSELL_IN_SYD_AND_AM_TABLE"),
      @SerializedName("YI_TEST")
      VALUE_YI_TEST("YI_TEST"),
      @SerializedName("ZERO_CONVERSION")
      VALUE_ZERO_CONVERSION("ZERO_CONVERSION"),
      @SerializedName("ZERO_IMPRESSION")
      VALUE_ZERO_IMPRESSION("ZERO_IMPRESSION"),
      @SerializedName("ZERO_OUTCOME_BUDGET")
      VALUE_ZERO_OUTCOME_BUDGET("ZERO_OUTCOME_BUDGET"),
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
