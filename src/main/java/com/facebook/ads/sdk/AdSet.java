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
public class AdSet extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("adset_schedule")
  private List<DayPart> mAdsetSchedule = null;
  @SerializedName("asset_feed_id")
  private String mAssetFeedId = null;
  @SerializedName("attribution_spec")
  private List<AttributionSpec> mAttributionSpec = null;
  @SerializedName("bid_adjustments")
  private AdBidAdjustments mBidAdjustments = null;
  @SerializedName("bid_amount")
  private Long mBidAmount = null;
  @SerializedName("bid_constraints")
  private AdCampaignBidConstraint mBidConstraints = null;
  @SerializedName("bid_info")
  private Map<String, Long> mBidInfo = null;
  @SerializedName("bid_strategy")
  private EnumBidStrategy mBidStrategy = null;
  @SerializedName("billing_event")
  private EnumBillingEvent mBillingEvent = null;
  @SerializedName("budget_remaining")
  private String mBudgetRemaining = null;
  @SerializedName("campaign")
  private Campaign mCampaign = null;
  @SerializedName("campaign_active_time")
  private String mCampaignActiveTime = null;
  @SerializedName("campaign_attribution")
  private String mCampaignAttribution = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative_sequence")
  private List<String> mCreativeSequence = null;
  @SerializedName("daily_budget")
  private String mDailyBudget = null;
  @SerializedName("daily_min_spend_target")
  private String mDailyMinSpendTarget = null;
  @SerializedName("daily_spend_cap")
  private String mDailySpendCap = null;
  @SerializedName("destination_type")
  private String mDestinationType = null;
  @SerializedName("dsa_beneficiary")
  private String mDsaBeneficiary = null;
  @SerializedName("dsa_payor")
  private String mDsaPayor = null;
  @SerializedName("effective_status")
  private EnumEffectiveStatus mEffectiveStatus = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("existing_customer_budget_percentage")
  private Long mExistingCustomerBudgetPercentage = null;
  @SerializedName("frequency_control_specs")
  private List<AdCampaignFrequencyControlSpecs> mFrequencyControlSpecs = null;
  @SerializedName("full_funnel_exploration_mode")
  private String mFullFunnelExplorationMode = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instagram_actor_id")
  private String mInstagramActorId = null;
  @SerializedName("is_budget_schedule_enabled")
  private Boolean mIsBudgetScheduleEnabled = null;
  @SerializedName("is_dynamic_creative")
  private Boolean mIsDynamicCreative = null;
  @SerializedName("issues_info")
  private List<AdCampaignIssuesInfo> mIssuesInfo = null;
  @SerializedName("learning_stage_info")
  private AdCampaignLearningStageInfo mLearningStageInfo = null;
  @SerializedName("lifetime_budget")
  private String mLifetimeBudget = null;
  @SerializedName("lifetime_imps")
  private Long mLifetimeImps = null;
  @SerializedName("lifetime_min_spend_target")
  private String mLifetimeMinSpendTarget = null;
  @SerializedName("lifetime_spend_cap")
  private String mLifetimeSpendCap = null;
  @SerializedName("multi_optimization_goal_weight")
  private String mMultiOptimizationGoalWeight = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("optimization_goal")
  private EnumOptimizationGoal mOptimizationGoal = null;
  @SerializedName("optimization_sub_event")
  private String mOptimizationSubEvent = null;
  @SerializedName("pacing_type")
  private List<String> mPacingType = null;
  @SerializedName("promoted_object")
  private AdPromotedObject mPromotedObject = null;
  @SerializedName("recommendations")
  private List<AdRecommendation> mRecommendations = null;
  @SerializedName("recurring_budget_semantics")
  private Boolean mRecurringBudgetSemantics = null;
  @SerializedName("regional_regulated_categories")
  private List<String> mRegionalRegulatedCategories = null;
  @SerializedName("regional_regulation_identities")
  private RegionalRegulationIdentities mRegionalRegulationIdentities = null;
  @SerializedName("review_feedback")
  private String mReviewFeedback = null;
  @SerializedName("rf_prediction_id")
  private String mRfPredictionId = null;
  @SerializedName("source_adset")
  private AdSet mSourceAdset = null;
  @SerializedName("source_adset_id")
  private String mSourceAdsetId = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("targeting_optimization_types")
  private List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> mTargetingOptimizationTypes = null;
  @SerializedName("time_based_ad_rotation_id_blocks")
  private List<List<Long>> mTimeBasedAdRotationIdBlocks = null;
  @SerializedName("time_based_ad_rotation_intervals")
  private List<Long> mTimeBasedAdRotationIntervals = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("use_new_app_click")
  private Boolean mUseNewAppClick = null;
  protected static Gson gson = null;

  public AdSet() {
  }

  public AdSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdSet(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdSet fetch() throws APIException{
    AdSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdSet> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdSet fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdSet> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdSet>)(
      new APIRequest<AdSet>(context, "", "/", "GET", AdSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdSet>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdSet loadJSON(String json, APIContext context, String header) {
    AdSet adSet = getGson().fromJson(json, AdSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adSet.context = context;
    adSet.rawValue = json;
    adSet.header = header;
    return adSet;
  }

  public static APINodeList<AdSet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdSet> adSets = new APINodeList<AdSet>(request, json, header);
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
          adSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adSets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adSets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adSets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adSets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adSets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adSets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adSets;
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
              adSets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adSets;
          }

          // Sixth, check if it's pure JsonObject
          adSets.clear();
          adSets.add(loadJSON(json, context, header));
          return adSets;
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

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdStudies getAdStudies() {
    return new APIRequestGetAdStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdRulesGoverned getAdRulesGoverned() {
    return new APIRequestGetAdRulesGoverned(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAsyncAdRequests getAsyncAdRequests() {
    return new APIRequestGetAsyncAdRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBudgetSchedule createBudgetSchedule() {
    return new APIRequestCreateBudgetSchedule(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCopies getCopies() {
    return new APIRequestGetCopies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCopy createCopy() {
    return new APIRequestCreateCopy(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDeliveryEstimate getDeliveryEstimate() {
    return new APIRequestGetDeliveryEstimate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdSet setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdSet setFieldAdlabels(List<AdLabel> value) {
    this.mAdlabels = value;
    return this;
  }

  public AdSet setFieldAdlabels(String value) {
    Type type = new TypeToken<List<AdLabel>>(){}.getType();
    this.mAdlabels = AdLabel.getGson().fromJson(value, type);
    return this;
  }
  public List<DayPart> getFieldAdsetSchedule() {
    return mAdsetSchedule;
  }

  public AdSet setFieldAdsetSchedule(List<DayPart> value) {
    this.mAdsetSchedule = value;
    return this;
  }

  public AdSet setFieldAdsetSchedule(String value) {
    Type type = new TypeToken<List<DayPart>>(){}.getType();
    this.mAdsetSchedule = DayPart.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAssetFeedId() {
    return mAssetFeedId;
  }

  public AdSet setFieldAssetFeedId(String value) {
    this.mAssetFeedId = value;
    return this;
  }

  public List<AttributionSpec> getFieldAttributionSpec() {
    return mAttributionSpec;
  }

  public AdSet setFieldAttributionSpec(List<AttributionSpec> value) {
    this.mAttributionSpec = value;
    return this;
  }

  public AdSet setFieldAttributionSpec(String value) {
    Type type = new TypeToken<List<AttributionSpec>>(){}.getType();
    this.mAttributionSpec = AttributionSpec.getGson().fromJson(value, type);
    return this;
  }
  public AdBidAdjustments getFieldBidAdjustments() {
    return mBidAdjustments;
  }

  public AdSet setFieldBidAdjustments(AdBidAdjustments value) {
    this.mBidAdjustments = value;
    return this;
  }

  public AdSet setFieldBidAdjustments(String value) {
    Type type = new TypeToken<AdBidAdjustments>(){}.getType();
    this.mBidAdjustments = AdBidAdjustments.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public AdSet setFieldBidAmount(Long value) {
    this.mBidAmount = value;
    return this;
  }

  public AdCampaignBidConstraint getFieldBidConstraints() {
    return mBidConstraints;
  }

  public AdSet setFieldBidConstraints(AdCampaignBidConstraint value) {
    this.mBidConstraints = value;
    return this;
  }

  public AdSet setFieldBidConstraints(String value) {
    Type type = new TypeToken<AdCampaignBidConstraint>(){}.getType();
    this.mBidConstraints = AdCampaignBidConstraint.getGson().fromJson(value, type);
    return this;
  }
  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public AdSet setFieldBidInfo(Map<String, Long> value) {
    this.mBidInfo = value;
    return this;
  }

  public EnumBidStrategy getFieldBidStrategy() {
    return mBidStrategy;
  }

  public AdSet setFieldBidStrategy(EnumBidStrategy value) {
    this.mBidStrategy = value;
    return this;
  }

  public EnumBillingEvent getFieldBillingEvent() {
    return mBillingEvent;
  }

  public AdSet setFieldBillingEvent(EnumBillingEvent value) {
    this.mBillingEvent = value;
    return this;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
  }

  public AdSet setFieldBudgetRemaining(String value) {
    this.mBudgetRemaining = value;
    return this;
  }

  public Campaign getFieldCampaign() {
    if (mCampaign != null) {
      mCampaign.context = getContext();
    }
    return mCampaign;
  }

  public AdSet setFieldCampaign(Campaign value) {
    this.mCampaign = value;
    return this;
  }

  public AdSet setFieldCampaign(String value) {
    Type type = new TypeToken<Campaign>(){}.getType();
    this.mCampaign = Campaign.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCampaignActiveTime() {
    return mCampaignActiveTime;
  }

  public AdSet setFieldCampaignActiveTime(String value) {
    this.mCampaignActiveTime = value;
    return this;
  }

  public String getFieldCampaignAttribution() {
    return mCampaignAttribution;
  }

  public AdSet setFieldCampaignAttribution(String value) {
    this.mCampaignAttribution = value;
    return this;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdSet setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public AdSet setFieldConfiguredStatus(EnumConfiguredStatus value) {
    this.mConfiguredStatus = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdSet setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public List<String> getFieldCreativeSequence() {
    return mCreativeSequence;
  }

  public AdSet setFieldCreativeSequence(List<String> value) {
    this.mCreativeSequence = value;
    return this;
  }

  public String getFieldDailyBudget() {
    return mDailyBudget;
  }

  public AdSet setFieldDailyBudget(String value) {
    this.mDailyBudget = value;
    return this;
  }

  public String getFieldDailyMinSpendTarget() {
    return mDailyMinSpendTarget;
  }

  public AdSet setFieldDailyMinSpendTarget(String value) {
    this.mDailyMinSpendTarget = value;
    return this;
  }

  public String getFieldDailySpendCap() {
    return mDailySpendCap;
  }

  public AdSet setFieldDailySpendCap(String value) {
    this.mDailySpendCap = value;
    return this;
  }

  public String getFieldDestinationType() {
    return mDestinationType;
  }

  public AdSet setFieldDestinationType(String value) {
    this.mDestinationType = value;
    return this;
  }

  public String getFieldDsaBeneficiary() {
    return mDsaBeneficiary;
  }

  public AdSet setFieldDsaBeneficiary(String value) {
    this.mDsaBeneficiary = value;
    return this;
  }

  public String getFieldDsaPayor() {
    return mDsaPayor;
  }

  public AdSet setFieldDsaPayor(String value) {
    this.mDsaPayor = value;
    return this;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public AdSet setFieldEffectiveStatus(EnumEffectiveStatus value) {
    this.mEffectiveStatus = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public AdSet setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public Long getFieldExistingCustomerBudgetPercentage() {
    return mExistingCustomerBudgetPercentage;
  }

  public AdSet setFieldExistingCustomerBudgetPercentage(Long value) {
    this.mExistingCustomerBudgetPercentage = value;
    return this;
  }

  public List<AdCampaignFrequencyControlSpecs> getFieldFrequencyControlSpecs() {
    return mFrequencyControlSpecs;
  }

  public AdSet setFieldFrequencyControlSpecs(List<AdCampaignFrequencyControlSpecs> value) {
    this.mFrequencyControlSpecs = value;
    return this;
  }

  public AdSet setFieldFrequencyControlSpecs(String value) {
    Type type = new TypeToken<List<AdCampaignFrequencyControlSpecs>>(){}.getType();
    this.mFrequencyControlSpecs = AdCampaignFrequencyControlSpecs.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldFullFunnelExplorationMode() {
    return mFullFunnelExplorationMode;
  }

  public AdSet setFieldFullFunnelExplorationMode(String value) {
    this.mFullFunnelExplorationMode = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdSet setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdSet setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
    return this;
  }

  public Boolean getFieldIsBudgetScheduleEnabled() {
    return mIsBudgetScheduleEnabled;
  }

  public AdSet setFieldIsBudgetScheduleEnabled(Boolean value) {
    this.mIsBudgetScheduleEnabled = value;
    return this;
  }

  public Boolean getFieldIsDynamicCreative() {
    return mIsDynamicCreative;
  }

  public AdSet setFieldIsDynamicCreative(Boolean value) {
    this.mIsDynamicCreative = value;
    return this;
  }

  public List<AdCampaignIssuesInfo> getFieldIssuesInfo() {
    return mIssuesInfo;
  }

  public AdSet setFieldIssuesInfo(List<AdCampaignIssuesInfo> value) {
    this.mIssuesInfo = value;
    return this;
  }

  public AdSet setFieldIssuesInfo(String value) {
    Type type = new TypeToken<List<AdCampaignIssuesInfo>>(){}.getType();
    this.mIssuesInfo = AdCampaignIssuesInfo.getGson().fromJson(value, type);
    return this;
  }
  public AdCampaignLearningStageInfo getFieldLearningStageInfo() {
    return mLearningStageInfo;
  }

  public AdSet setFieldLearningStageInfo(AdCampaignLearningStageInfo value) {
    this.mLearningStageInfo = value;
    return this;
  }

  public AdSet setFieldLearningStageInfo(String value) {
    Type type = new TypeToken<AdCampaignLearningStageInfo>(){}.getType();
    this.mLearningStageInfo = AdCampaignLearningStageInfo.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
  }

  public AdSet setFieldLifetimeBudget(String value) {
    this.mLifetimeBudget = value;
    return this;
  }

  public Long getFieldLifetimeImps() {
    return mLifetimeImps;
  }

  public AdSet setFieldLifetimeImps(Long value) {
    this.mLifetimeImps = value;
    return this;
  }

  public String getFieldLifetimeMinSpendTarget() {
    return mLifetimeMinSpendTarget;
  }

  public AdSet setFieldLifetimeMinSpendTarget(String value) {
    this.mLifetimeMinSpendTarget = value;
    return this;
  }

  public String getFieldLifetimeSpendCap() {
    return mLifetimeSpendCap;
  }

  public AdSet setFieldLifetimeSpendCap(String value) {
    this.mLifetimeSpendCap = value;
    return this;
  }

  public String getFieldMultiOptimizationGoalWeight() {
    return mMultiOptimizationGoalWeight;
  }

  public AdSet setFieldMultiOptimizationGoalWeight(String value) {
    this.mMultiOptimizationGoalWeight = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdSet setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public EnumOptimizationGoal getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public AdSet setFieldOptimizationGoal(EnumOptimizationGoal value) {
    this.mOptimizationGoal = value;
    return this;
  }

  public String getFieldOptimizationSubEvent() {
    return mOptimizationSubEvent;
  }

  public AdSet setFieldOptimizationSubEvent(String value) {
    this.mOptimizationSubEvent = value;
    return this;
  }

  public List<String> getFieldPacingType() {
    return mPacingType;
  }

  public AdSet setFieldPacingType(List<String> value) {
    this.mPacingType = value;
    return this;
  }

  public AdPromotedObject getFieldPromotedObject() {
    return mPromotedObject;
  }

  public AdSet setFieldPromotedObject(AdPromotedObject value) {
    this.mPromotedObject = value;
    return this;
  }

  public AdSet setFieldPromotedObject(String value) {
    Type type = new TypeToken<AdPromotedObject>(){}.getType();
    this.mPromotedObject = AdPromotedObject.getGson().fromJson(value, type);
    return this;
  }
  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
  }

  public AdSet setFieldRecommendations(List<AdRecommendation> value) {
    this.mRecommendations = value;
    return this;
  }

  public AdSet setFieldRecommendations(String value) {
    Type type = new TypeToken<List<AdRecommendation>>(){}.getType();
    this.mRecommendations = AdRecommendation.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldRecurringBudgetSemantics() {
    return mRecurringBudgetSemantics;
  }

  public AdSet setFieldRecurringBudgetSemantics(Boolean value) {
    this.mRecurringBudgetSemantics = value;
    return this;
  }

  public List<String> getFieldRegionalRegulatedCategories() {
    return mRegionalRegulatedCategories;
  }

  public AdSet setFieldRegionalRegulatedCategories(List<String> value) {
    this.mRegionalRegulatedCategories = value;
    return this;
  }

  public RegionalRegulationIdentities getFieldRegionalRegulationIdentities() {
    return mRegionalRegulationIdentities;
  }

  public AdSet setFieldRegionalRegulationIdentities(RegionalRegulationIdentities value) {
    this.mRegionalRegulationIdentities = value;
    return this;
  }

  public AdSet setFieldRegionalRegulationIdentities(String value) {
    Type type = new TypeToken<RegionalRegulationIdentities>(){}.getType();
    this.mRegionalRegulationIdentities = RegionalRegulationIdentities.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldReviewFeedback() {
    return mReviewFeedback;
  }

  public AdSet setFieldReviewFeedback(String value) {
    this.mReviewFeedback = value;
    return this;
  }

  public String getFieldRfPredictionId() {
    return mRfPredictionId;
  }

  public AdSet setFieldRfPredictionId(String value) {
    this.mRfPredictionId = value;
    return this;
  }

  public AdSet getFieldSourceAdset() {
    if (mSourceAdset != null) {
      mSourceAdset.context = getContext();
    }
    return mSourceAdset;
  }

  public AdSet setFieldSourceAdset(AdSet value) {
    this.mSourceAdset = value;
    return this;
  }

  public AdSet setFieldSourceAdset(String value) {
    Type type = new TypeToken<AdSet>(){}.getType();
    this.mSourceAdset = AdSet.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldSourceAdsetId() {
    return mSourceAdsetId;
  }

  public AdSet setFieldSourceAdsetId(String value) {
    this.mSourceAdsetId = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdSet setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public AdSet setFieldStatus(EnumStatus value) {
    this.mStatus = value;
    return this;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public AdSet setFieldTargeting(Targeting value) {
    this.mTargeting = value;
    return this;
  }

  public AdSet setFieldTargeting(String value) {
    Type type = new TypeToken<Targeting>(){}.getType();
    this.mTargeting = Targeting.getGson().fromJson(value, type);
    return this;
  }
  public List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> getFieldTargetingOptimizationTypes() {
    return mTargetingOptimizationTypes;
  }

  public AdSet setFieldTargetingOptimizationTypes(List<com.facebook.ads.sdk.customtype.TargetingOptimizationTuple> value) {
    this.mTargetingOptimizationTypes = value;
    return this;
  }

  public List<List<Long>> getFieldTimeBasedAdRotationIdBlocks() {
    return mTimeBasedAdRotationIdBlocks;
  }

  public AdSet setFieldTimeBasedAdRotationIdBlocks(List<List<Long>> value) {
    this.mTimeBasedAdRotationIdBlocks = value;
    return this;
  }

  public List<Long> getFieldTimeBasedAdRotationIntervals() {
    return mTimeBasedAdRotationIntervals;
  }

  public AdSet setFieldTimeBasedAdRotationIntervals(List<Long> value) {
    this.mTimeBasedAdRotationIntervals = value;
    return this;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public AdSet setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public Boolean getFieldUseNewAppClick() {
    return mUseNewAppClick;
  }

  public AdSet setFieldUseNewAppClick(Boolean value) {
    this.mUseNewAppClick = value;
    return this;
  }



  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "after",
      "business_id",
      "category",
      "limit",
      "since",
      "uid",
      "until",
    };

    public static final String[] FIELDS = {
      "actor_id",
      "actor_name",
      "application_id",
      "application_name",
      "date_time_in_timezone",
      "event_time",
      "event_type",
      "extra_data",
      "object_id",
      "object_name",
      "object_type",
      "translated_event_type",
    };

    @Override
    public APINodeList<AdActivity> parseResponse(String response, String header) throws APIException {
      return AdActivity.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdActivity> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdActivity> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdActivity>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdActivity>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdActivity>>() {
           public APINodeList<AdActivity> apply(ResponseWrapper result) {
             try {
               return APIRequestGetActivities.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setAfter (String after) {
      this.setParam("after", after);
      return this;
    }

    public APIRequestGetActivities setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetActivities setCategory (AdActivity.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestGetActivities setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestGetActivities setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetActivities setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetActivities setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetActivities setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetActivities setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetActivities requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetActivities requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetActivities requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetActivities requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationIdField () {
      return this.requestApplicationIdField(true);
    }
    public APIRequestGetActivities requestApplicationIdField (boolean value) {
      this.requestField("application_id", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationNameField () {
      return this.requestApplicationNameField(true);
    }
    public APIRequestGetActivities requestApplicationNameField (boolean value) {
      this.requestField("application_name", value);
      return this;
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField () {
      return this.requestDateTimeInTimezoneField(true);
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField (boolean value) {
      this.requestField("date_time_in_timezone", value);
      return this;
    }
    public APIRequestGetActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetActivities requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetActivities requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetActivities requestObjectNameField () {
      return this.requestObjectNameField(true);
    }
    public APIRequestGetActivities requestObjectNameField (boolean value) {
      this.requestField("object_name", value);
      return this;
    }
    public APIRequestGetActivities requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetActivities requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetActivities requestTranslatedEventTypeField () {
      return this.requestTranslatedEventTypeField(true);
    }
    public APIRequestGetActivities requestTranslatedEventTypeField (boolean value) {
      this.requestField("translated_event_type", value);
      return this;
    }
  }

  public static class APIRequestGetAdStudies extends APIRequest<AdStudy> {

    APINodeList<AdStudy> lastResponse = null;
    @Override
    public APINodeList<AdStudy> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "canceled_time",
      "client_business",
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "measurement_contact",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "sales_contact",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<AdStudy> parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudy> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdStudy>>() {
           public APINodeList<AdStudy> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdStudies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdStudies(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_studies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdStudies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdStudies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdStudies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdStudies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdStudies requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdStudies requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCanceledTimeField () {
      return this.requestCanceledTimeField(true);
    }
    public APIRequestGetAdStudies requestCanceledTimeField (boolean value) {
      this.requestField("canceled_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestClientBusinessField () {
      return this.requestClientBusinessField(true);
    }
    public APIRequestGetAdStudies requestClientBusinessField (boolean value) {
      this.requestField("client_business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField () {
      return this.requestCooldownStartTimeField(true);
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField (boolean value) {
      this.requestField("cooldown_start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdStudies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdStudies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAdStudies requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAdStudies requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdStudies requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdStudies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdStudies requestMeasurementContactField () {
      return this.requestMeasurementContactField(true);
    }
    public APIRequestGetAdStudies requestMeasurementContactField (boolean value) {
      this.requestField("measurement_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdStudies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdStudies requestObservationEndTimeField () {
      return this.requestObservationEndTimeField(true);
    }
    public APIRequestGetAdStudies requestObservationEndTimeField (boolean value) {
      this.requestField("observation_end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField () {
      return this.requestResultsFirstAvailableDateField(true);
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField (boolean value) {
      this.requestField("results_first_available_date", value);
      return this;
    }
    public APIRequestGetAdStudies requestSalesContactField () {
      return this.requestSalesContactField(true);
    }
    public APIRequestGetAdStudies requestSalesContactField (boolean value) {
      this.requestField("sales_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdStudies requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAdStudies requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetAdStudies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdStudies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "asset_feed_spec",
      "authorization_category",
      "auto_update",
      "body",
      "branded_content",
      "branded_content_sponsor_page_id",
      "bundle_folder_id",
      "call_to_action_type",
      "categorization_criteria",
      "category_media_source",
      "collaborative_ads_lsb_image_bank_id",
      "contextual_multi_ads",
      "creative_sourcing_spec",
      "degrees_of_freedom_spec",
      "destination_set_id",
      "dynamic_ad_voice",
      "effective_authorization_category",
      "effective_instagram_media_id",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "enable_direct_install",
      "enable_launch_instant_app",
      "facebook_branded_content",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_branded_content",
      "instagram_permalink_url",
      "instagram_story_id",
      "instagram_user_id",
      "interactive_components_spec",
      "link_deep_link_url",
      "link_destination_display_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_store_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "omnichannel_link_spec",
      "page_welcome_message",
      "photo_album_source_object_story_id",
      "place_page_set_id",
      "platform_customizations",
      "playable_asset_id",
      "portrait_customizations",
      "product_set_id",
      "recommender_settings",
      "source_instagram_media_id",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_id",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreative>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreative>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdCreative>>() {
           public APINodeList<AdCreative> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdCreatives.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreatives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreatives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreatives requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAuthorizationCategoryField () {
      return this.requestAuthorizationCategoryField(true);
    }
    public APIRequestGetAdCreatives requestAuthorizationCategoryField (boolean value) {
      this.requestField("authorization_category", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAutoUpdateField () {
      return this.requestAutoUpdateField(true);
    }
    public APIRequestGetAdCreatives requestAutoUpdateField (boolean value) {
      this.requestField("auto_update", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBrandedContentField () {
      return this.requestBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestBrandedContentField (boolean value) {
      this.requestField("branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBundleFolderIdField () {
      return this.requestBundleFolderIdField(true);
    }
    public APIRequestGetAdCreatives requestBundleFolderIdField (boolean value) {
      this.requestField("bundle_folder_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCategorizationCriteriaField () {
      return this.requestCategorizationCriteriaField(true);
    }
    public APIRequestGetAdCreatives requestCategorizationCriteriaField (boolean value) {
      this.requestField("categorization_criteria", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCategoryMediaSourceField () {
      return this.requestCategoryMediaSourceField(true);
    }
    public APIRequestGetAdCreatives requestCategoryMediaSourceField (boolean value) {
      this.requestField("category_media_source", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCollaborativeAdsLsbImageBankIdField () {
      return this.requestCollaborativeAdsLsbImageBankIdField(true);
    }
    public APIRequestGetAdCreatives requestCollaborativeAdsLsbImageBankIdField (boolean value) {
      this.requestField("collaborative_ads_lsb_image_bank_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestContextualMultiAdsField () {
      return this.requestContextualMultiAdsField(true);
    }
    public APIRequestGetAdCreatives requestContextualMultiAdsField (boolean value) {
      this.requestField("contextual_multi_ads", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCreativeSourcingSpecField () {
      return this.requestCreativeSourcingSpecField(true);
    }
    public APIRequestGetAdCreatives requestCreativeSourcingSpecField (boolean value) {
      this.requestField("creative_sourcing_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDegreesOfFreedomSpecField () {
      return this.requestDegreesOfFreedomSpecField(true);
    }
    public APIRequestGetAdCreatives requestDegreesOfFreedomSpecField (boolean value) {
      this.requestField("degrees_of_freedom_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDestinationSetIdField () {
      return this.requestDestinationSetIdField(true);
    }
    public APIRequestGetAdCreatives requestDestinationSetIdField (boolean value) {
      this.requestField("destination_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDynamicAdVoiceField () {
      return this.requestDynamicAdVoiceField(true);
    }
    public APIRequestGetAdCreatives requestDynamicAdVoiceField (boolean value) {
      this.requestField("dynamic_ad_voice", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveAuthorizationCategoryField () {
      return this.requestEffectiveAuthorizationCategoryField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveAuthorizationCategoryField (boolean value) {
      this.requestField("effective_authorization_category", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramMediaIdField () {
      return this.requestEffectiveInstagramMediaIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramMediaIdField (boolean value) {
      this.requestField("effective_instagram_media_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEnableDirectInstallField () {
      return this.requestEnableDirectInstallField(true);
    }
    public APIRequestGetAdCreatives requestEnableDirectInstallField (boolean value) {
      this.requestField("enable_direct_install", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEnableLaunchInstantAppField () {
      return this.requestEnableLaunchInstantAppField(true);
    }
    public APIRequestGetAdCreatives requestEnableLaunchInstantAppField (boolean value) {
      this.requestField("enable_launch_instant_app", value);
      return this;
    }
    public APIRequestGetAdCreatives requestFacebookBrandedContentField () {
      return this.requestFacebookBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestFacebookBrandedContentField (boolean value) {
      this.requestField("facebook_branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreatives requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreatives requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramBrandedContentField () {
      return this.requestInstagramBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestInstagramBrandedContentField (boolean value) {
      this.requestField("instagram_branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramUserIdField () {
      return this.requestInstagramUserIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramUserIdField (boolean value) {
      this.requestField("instagram_user_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInteractiveComponentsSpecField () {
      return this.requestInteractiveComponentsSpecField(true);
    }
    public APIRequestGetAdCreatives requestInteractiveComponentsSpecField (boolean value) {
      this.requestField("interactive_components_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkDeepLinkUrlField () {
      return this.requestLinkDeepLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkDeepLinkUrlField (boolean value) {
      this.requestField("link_deep_link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkDestinationDisplayUrlField () {
      return this.requestLinkDestinationDisplayUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkDestinationDisplayUrlField (boolean value) {
      this.requestField("link_destination_display_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreatives requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreatives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoreUrlField () {
      return this.requestObjectStoreUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoreUrlField (boolean value) {
      this.requestField("object_store_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreatives requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestOmnichannelLinkSpecField () {
      return this.requestOmnichannelLinkSpecField(true);
    }
    public APIRequestGetAdCreatives requestOmnichannelLinkSpecField (boolean value) {
      this.requestField("omnichannel_link_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPageWelcomeMessageField () {
      return this.requestPageWelcomeMessageField(true);
    }
    public APIRequestGetAdCreatives requestPageWelcomeMessageField (boolean value) {
      this.requestField("page_welcome_message", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPhotoAlbumSourceObjectStoryIdField () {
      return this.requestPhotoAlbumSourceObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestPhotoAlbumSourceObjectStoryIdField (boolean value) {
      this.requestField("photo_album_source_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlacePageSetIdField () {
      return this.requestPlacePageSetIdField(true);
    }
    public APIRequestGetAdCreatives requestPlacePageSetIdField (boolean value) {
      this.requestField("place_page_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlayableAssetIdField () {
      return this.requestPlayableAssetIdField(true);
    }
    public APIRequestGetAdCreatives requestPlayableAssetIdField (boolean value) {
      this.requestField("playable_asset_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPortraitCustomizationsField () {
      return this.requestPortraitCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPortraitCustomizationsField (boolean value) {
      this.requestField("portrait_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGetAdCreatives requestSourceInstagramMediaIdField () {
      return this.requestSourceInstagramMediaIdField(true);
    }
    public APIRequestGetAdCreatives requestSourceInstagramMediaIdField (boolean value) {
      this.requestField("source_instagram_media_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreatives requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailIdField () {
      return this.requestThumbnailIdField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailIdField (boolean value) {
      this.requestField("thumbnail_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreatives requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreatives requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreatives requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreatives requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestDeleteAdLabels extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestDeleteAdLabels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdLabels setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestDeleteAdLabels setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDeleteAdLabels setExecutionOptions (List<AdSet.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestDeleteAdLabels setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestDeleteAdLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdLabel extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdSet parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSet>() {
           public AdSet apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdLabel.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAdLabel setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdLabel setExecutionOptions (List<AdSet.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestCreateAdLabel setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAdLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdRulesGoverned extends APIRequest<AdRule> {

    APINodeList<AdRule> lastResponse = null;
    @Override
    public APINodeList<AdRule> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "pass_evaluation",
    };

    public static final String[] FIELDS = {
      "account_id",
      "created_by",
      "created_time",
      "evaluation_spec",
      "execution_spec",
      "id",
      "name",
      "schedule_spec",
      "status",
      "updated_time",
    };

    @Override
    public APINodeList<AdRule> parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdRule> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdRule> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdRule>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdRule>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdRule>>() {
           public APINodeList<AdRule> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdRulesGoverned.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdRulesGoverned(String nodeId, APIContext context) {
      super(context, nodeId, "/adrules_governed", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdRulesGoverned setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdRulesGoverned setPassEvaluation (Boolean passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }
    public APIRequestGetAdRulesGoverned setPassEvaluation (String passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdRulesGoverned requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdRulesGoverned requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdRulesGoverned requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "effective_status",
      "time_range",
      "updated_since",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_active_time",
      "ad_review_feedback",
      "ad_schedule_end_time",
      "ad_schedule_start_time",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_domain",
      "conversion_specs",
      "created_time",
      "creative",
      "creative_asset_groups_spec",
      "demolink_hash",
      "display_sequence",
      "effective_status",
      "engagement_audience",
      "failed_delivery_checks",
      "id",
      "issues_info",
      "last_updated_by_app_id",
      "name",
      "preview_shareable_link",
      "priority",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "targeting",
      "tracking_and_conversion_with_defaults",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAds.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds setDatePreset (Ad.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetAds setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetAds setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetAds setUpdatedSince (Long updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }
    public APIRequestGetAds setUpdatedSince (String updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }

    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdActiveTimeField () {
      return this.requestAdActiveTimeField(true);
    }
    public APIRequestGetAds requestAdActiveTimeField (boolean value) {
      this.requestField("ad_active_time", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdScheduleEndTimeField () {
      return this.requestAdScheduleEndTimeField(true);
    }
    public APIRequestGetAds requestAdScheduleEndTimeField (boolean value) {
      this.requestField("ad_schedule_end_time", value);
      return this;
    }
    public APIRequestGetAds requestAdScheduleStartTimeField () {
      return this.requestAdScheduleStartTimeField(true);
    }
    public APIRequestGetAds requestAdScheduleStartTimeField (boolean value) {
      this.requestField("ad_schedule_start_time", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAds requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAds requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAds requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAds requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAds requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAds requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAds requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAds requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAds requestConversionDomainField () {
      return this.requestConversionDomainField(true);
    }
    public APIRequestGetAds requestConversionDomainField (boolean value) {
      this.requestField("conversion_domain", value);
      return this;
    }
    public APIRequestGetAds requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAds requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAds requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAds requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAds requestCreativeAssetGroupsSpecField () {
      return this.requestCreativeAssetGroupsSpecField(true);
    }
    public APIRequestGetAds requestCreativeAssetGroupsSpecField (boolean value) {
      this.requestField("creative_asset_groups_spec", value);
      return this;
    }
    public APIRequestGetAds requestDemolinkHashField () {
      return this.requestDemolinkHashField(true);
    }
    public APIRequestGetAds requestDemolinkHashField (boolean value) {
      this.requestField("demolink_hash", value);
      return this;
    }
    public APIRequestGetAds requestDisplaySequenceField () {
      return this.requestDisplaySequenceField(true);
    }
    public APIRequestGetAds requestDisplaySequenceField (boolean value) {
      this.requestField("display_sequence", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestEngagementAudienceField () {
      return this.requestEngagementAudienceField(true);
    }
    public APIRequestGetAds requestEngagementAudienceField (boolean value) {
      this.requestField("engagement_audience", value);
      return this;
    }
    public APIRequestGetAds requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAds requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetAds requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAds requestPreviewShareableLinkField () {
      return this.requestPreviewShareableLinkField(true);
    }
    public APIRequestGetAds requestPreviewShareableLinkField (boolean value) {
      this.requestField("preview_shareable_link", value);
      return this;
    }
    public APIRequestGetAds requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGetAds requestPriorityField (boolean value) {
      this.requestField("priority", value);
      return this;
    }
    public APIRequestGetAds requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAds requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetAds requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetAds requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetAds requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAds requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAds requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAds requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAds requestTrackingAndConversionWithDefaultsField () {
      return this.requestTrackingAndConversionWithDefaultsField(true);
    }
    public APIRequestGetAds requestTrackingAndConversionWithDefaultsField (boolean value) {
      this.requestField("tracking_and_conversion_with_defaults", value);
      return this;
    }
    public APIRequestGetAds requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAds requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAds requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAds requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetAsyncAdRequests extends APIRequest<AdAsyncRequest> {

    APINodeList<AdAsyncRequest> lastResponse = null;
    @Override
    public APINodeList<AdAsyncRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "statuses",
    };

    public static final String[] FIELDS = {
      "async_request_set",
      "created_time",
      "id",
      "input",
      "result",
      "scope_object_id",
      "status",
      "type",
      "updated_time",
    };

    @Override
    public APINodeList<AdAsyncRequest> parseResponse(String response, String header) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdAsyncRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAsyncRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAsyncRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAsyncRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdAsyncRequest>>() {
           public APINodeList<AdAsyncRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAsyncAdRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAsyncAdRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAsyncAdRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAsyncAdRequests setStatuses (List<AdAsyncRequest.EnumStatuses> statuses) {
      this.setParam("statuses", statuses);
      return this;
    }
    public APIRequestGetAsyncAdRequests setStatuses (String statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetAsyncAdRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAsyncAdRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAsyncAdRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAsyncAdRequests requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGetAsyncAdRequests requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequests requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAsyncAdRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGetAsyncAdRequests requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetAsyncAdRequests requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestScopeObjectIdField () {
      return this.requestScopeObjectIdField(true);
    }
    public APIRequestGetAsyncAdRequests requestScopeObjectIdField (boolean value) {
      this.requestField("scope_object_id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAsyncAdRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAsyncAdRequests requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateBudgetSchedule extends APIRequest<HighDemandPeriod> {

    HighDemandPeriod lastResponse = null;
    @Override
    public HighDemandPeriod getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "budget_value",
      "budget_value_type",
      "time_end",
      "time_start",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HighDemandPeriod parseResponse(String response, String header) throws APIException {
      return HighDemandPeriod.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HighDemandPeriod execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HighDemandPeriod execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HighDemandPeriod> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HighDemandPeriod> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HighDemandPeriod>() {
           public HighDemandPeriod apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBudgetSchedule.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBudgetSchedule(String nodeId, APIContext context) {
      super(context, nodeId, "/budget_schedules", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBudgetSchedule setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBudgetSchedule setBudgetValue (Long budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }
    public APIRequestCreateBudgetSchedule setBudgetValue (String budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }

    public APIRequestCreateBudgetSchedule setBudgetValueType (HighDemandPeriod.EnumBudgetValueType budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }
    public APIRequestCreateBudgetSchedule setBudgetValueType (String budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }

    public APIRequestCreateBudgetSchedule setTimeEnd (Long timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }
    public APIRequestCreateBudgetSchedule setTimeEnd (String timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }

    public APIRequestCreateBudgetSchedule setTimeStart (Long timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }
    public APIRequestCreateBudgetSchedule setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestCreateBudgetSchedule requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBudgetSchedule requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBudgetSchedule requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCopies extends APIRequest<AdSet> {

    APINodeList<AdSet> lastResponse = null;
    @Override
    public APINodeList<AdSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "effective_status",
      "is_completed",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "asset_feed_id",
      "attribution_spec",
      "bid_adjustments",
      "bid_amount",
      "bid_constraints",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_active_time",
      "campaign_attribution",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "dsa_beneficiary",
      "dsa_payor",
      "effective_status",
      "end_time",
      "existing_customer_budget_percentage",
      "frequency_control_specs",
      "full_funnel_exploration_mode",
      "id",
      "instagram_actor_id",
      "is_budget_schedule_enabled",
      "is_dynamic_creative",
      "issues_info",
      "learning_stage_info",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "multi_optimization_goal_weight",
      "name",
      "optimization_goal",
      "optimization_sub_event",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "regional_regulated_categories",
      "regional_regulation_identities",
      "review_feedback",
      "rf_prediction_id",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "targeting_optimization_types",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdSet>>() {
           public APINodeList<AdSet> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCopies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCopies(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCopies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCopies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCopies setDatePreset (AdSet.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCopies setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCopies setEffectiveStatus (List<AdSet.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetCopies setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCopies setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetCopies setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetCopies setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetCopies setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetCopies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCopies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCopies requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCopies requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCopies requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCopies requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCopies requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetCopies requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetCopies requestAssetFeedIdField () {
      return this.requestAssetFeedIdField(true);
    }
    public APIRequestGetCopies requestAssetFeedIdField (boolean value) {
      this.requestField("asset_feed_id", value);
      return this;
    }
    public APIRequestGetCopies requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetCopies requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetCopies requestBidAdjustmentsField () {
      return this.requestBidAdjustmentsField(true);
    }
    public APIRequestGetCopies requestBidAdjustmentsField (boolean value) {
      this.requestField("bid_adjustments", value);
      return this;
    }
    public APIRequestGetCopies requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetCopies requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetCopies requestBidConstraintsField () {
      return this.requestBidConstraintsField(true);
    }
    public APIRequestGetCopies requestBidConstraintsField (boolean value) {
      this.requestField("bid_constraints", value);
      return this;
    }
    public APIRequestGetCopies requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetCopies requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetCopies requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetCopies requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetCopies requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetCopies requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetCopies requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCopies requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetCopies requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignActiveTimeField () {
      return this.requestCampaignActiveTimeField(true);
    }
    public APIRequestGetCopies requestCampaignActiveTimeField (boolean value) {
      this.requestField("campaign_active_time", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignAttributionField () {
      return this.requestCampaignAttributionField(true);
    }
    public APIRequestGetCopies requestCampaignAttributionField (boolean value) {
      this.requestField("campaign_attribution", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetCopies requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetCopies requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCopies requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCopies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCopies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCopies requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetCopies requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetCopies requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetCopies requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetCopies requestDailyMinSpendTargetField () {
      return this.requestDailyMinSpendTargetField(true);
    }
    public APIRequestGetCopies requestDailyMinSpendTargetField (boolean value) {
      this.requestField("daily_min_spend_target", value);
      return this;
    }
    public APIRequestGetCopies requestDailySpendCapField () {
      return this.requestDailySpendCapField(true);
    }
    public APIRequestGetCopies requestDailySpendCapField (boolean value) {
      this.requestField("daily_spend_cap", value);
      return this;
    }
    public APIRequestGetCopies requestDestinationTypeField () {
      return this.requestDestinationTypeField(true);
    }
    public APIRequestGetCopies requestDestinationTypeField (boolean value) {
      this.requestField("destination_type", value);
      return this;
    }
    public APIRequestGetCopies requestDsaBeneficiaryField () {
      return this.requestDsaBeneficiaryField(true);
    }
    public APIRequestGetCopies requestDsaBeneficiaryField (boolean value) {
      this.requestField("dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetCopies requestDsaPayorField () {
      return this.requestDsaPayorField(true);
    }
    public APIRequestGetCopies requestDsaPayorField (boolean value) {
      this.requestField("dsa_payor", value);
      return this;
    }
    public APIRequestGetCopies requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCopies requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCopies requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetCopies requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetCopies requestExistingCustomerBudgetPercentageField () {
      return this.requestExistingCustomerBudgetPercentageField(true);
    }
    public APIRequestGetCopies requestExistingCustomerBudgetPercentageField (boolean value) {
      this.requestField("existing_customer_budget_percentage", value);
      return this;
    }
    public APIRequestGetCopies requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetCopies requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetCopies requestFullFunnelExplorationModeField () {
      return this.requestFullFunnelExplorationModeField(true);
    }
    public APIRequestGetCopies requestFullFunnelExplorationModeField (boolean value) {
      this.requestField("full_funnel_exploration_mode", value);
      return this;
    }
    public APIRequestGetCopies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCopies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCopies requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetCopies requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetCopies requestIsBudgetScheduleEnabledField () {
      return this.requestIsBudgetScheduleEnabledField(true);
    }
    public APIRequestGetCopies requestIsBudgetScheduleEnabledField (boolean value) {
      this.requestField("is_budget_schedule_enabled", value);
      return this;
    }
    public APIRequestGetCopies requestIsDynamicCreativeField () {
      return this.requestIsDynamicCreativeField(true);
    }
    public APIRequestGetCopies requestIsDynamicCreativeField (boolean value) {
      this.requestField("is_dynamic_creative", value);
      return this;
    }
    public APIRequestGetCopies requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetCopies requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGetCopies requestLearningStageInfoField () {
      return this.requestLearningStageInfoField(true);
    }
    public APIRequestGetCopies requestLearningStageInfoField (boolean value) {
      this.requestField("learning_stage_info", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCopies requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetCopies requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeMinSpendTargetField () {
      return this.requestLifetimeMinSpendTargetField(true);
    }
    public APIRequestGetCopies requestLifetimeMinSpendTargetField (boolean value) {
      this.requestField("lifetime_min_spend_target", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeSpendCapField () {
      return this.requestLifetimeSpendCapField(true);
    }
    public APIRequestGetCopies requestLifetimeSpendCapField (boolean value) {
      this.requestField("lifetime_spend_cap", value);
      return this;
    }
    public APIRequestGetCopies requestMultiOptimizationGoalWeightField () {
      return this.requestMultiOptimizationGoalWeightField(true);
    }
    public APIRequestGetCopies requestMultiOptimizationGoalWeightField (boolean value) {
      this.requestField("multi_optimization_goal_weight", value);
      return this;
    }
    public APIRequestGetCopies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCopies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCopies requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetCopies requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetCopies requestOptimizationSubEventField () {
      return this.requestOptimizationSubEventField(true);
    }
    public APIRequestGetCopies requestOptimizationSubEventField (boolean value) {
      this.requestField("optimization_sub_event", value);
      return this;
    }
    public APIRequestGetCopies requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetCopies requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetCopies requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetCopies requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetCopies requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCopies requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCopies requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetCopies requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetCopies requestRegionalRegulatedCategoriesField () {
      return this.requestRegionalRegulatedCategoriesField(true);
    }
    public APIRequestGetCopies requestRegionalRegulatedCategoriesField (boolean value) {
      this.requestField("regional_regulated_categories", value);
      return this;
    }
    public APIRequestGetCopies requestRegionalRegulationIdentitiesField () {
      return this.requestRegionalRegulationIdentitiesField(true);
    }
    public APIRequestGetCopies requestRegionalRegulationIdentitiesField (boolean value) {
      this.requestField("regional_regulation_identities", value);
      return this;
    }
    public APIRequestGetCopies requestReviewFeedbackField () {
      return this.requestReviewFeedbackField(true);
    }
    public APIRequestGetCopies requestReviewFeedbackField (boolean value) {
      this.requestField("review_feedback", value);
      return this;
    }
    public APIRequestGetCopies requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetCopies requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetCopies requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetCopies requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetCopies requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCopies requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCopies requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCopies requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCopies requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetCopies requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetCopies requestTargetingOptimizationTypesField () {
      return this.requestTargetingOptimizationTypesField(true);
    }
    public APIRequestGetCopies requestTargetingOptimizationTypesField (boolean value) {
      this.requestField("targeting_optimization_types", value);
      return this;
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetCopies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCopies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetCopies requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetCopies requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestCreateCopy extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "campaign_id",
      "create_dco_adset",
      "deep_copy",
      "end_time",
      "rename_options",
      "start_time",
      "status_option",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdSet parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSet>() {
           public AdSet apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCopy.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCopy(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCopy setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCopy setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCopy setCampaignId (String campaignId) {
      this.setParam("campaign_id", campaignId);
      return this;
    }

    public APIRequestCreateCopy setCreateDcoAdset (Boolean createDcoAdset) {
      this.setParam("create_dco_adset", createDcoAdset);
      return this;
    }
    public APIRequestCreateCopy setCreateDcoAdset (String createDcoAdset) {
      this.setParam("create_dco_adset", createDcoAdset);
      return this;
    }

    public APIRequestCreateCopy setDeepCopy (Boolean deepCopy) {
      this.setParam("deep_copy", deepCopy);
      return this;
    }
    public APIRequestCreateCopy setDeepCopy (String deepCopy) {
      this.setParam("deep_copy", deepCopy);
      return this;
    }

    public APIRequestCreateCopy setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateCopy setRenameOptions (Object renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }
    public APIRequestCreateCopy setRenameOptions (String renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }

    public APIRequestCreateCopy setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateCopy setStatusOption (AdSet.EnumStatusOption statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }
    public APIRequestCreateCopy setStatusOption (String statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }

    public APIRequestCreateCopy requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCopy requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDeliveryEstimate extends APIRequest<AdCampaignDeliveryEstimate> {

    APINodeList<AdCampaignDeliveryEstimate> lastResponse = null;
    @Override
    public APINodeList<AdCampaignDeliveryEstimate> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "optimization_goal",
      "promoted_object",
      "targeting_spec",
    };

    public static final String[] FIELDS = {
      "daily_outcomes_curve",
      "estimate_dau",
      "estimate_mau_lower_bound",
      "estimate_mau_upper_bound",
      "estimate_ready",
      "targeting_optimization_types",
    };

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> parseResponse(String response, String header) throws APIException {
      return AdCampaignDeliveryEstimate.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCampaignDeliveryEstimate>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCampaignDeliveryEstimate>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdCampaignDeliveryEstimate>>() {
           public APINodeList<AdCampaignDeliveryEstimate> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDeliveryEstimate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDeliveryEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/delivery_estimate", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDeliveryEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDeliveryEstimate setOptimizationGoal (AdCampaignDeliveryEstimate.EnumOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }
    public APIRequestGetDeliveryEstimate setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestGetDeliveryEstimate setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestGetDeliveryEstimate setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestGetDeliveryEstimate setTargetingSpec (Targeting targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }
    public APIRequestGetDeliveryEstimate setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDeliveryEstimate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField () {
      return this.requestDailyOutcomesCurveField(true);
    }
    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField (boolean value) {
      this.requestField("daily_outcomes_curve", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField () {
      return this.requestEstimateDauField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField (boolean value) {
      this.requestField("estimate_dau", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauLowerBoundField () {
      return this.requestEstimateMauLowerBoundField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauLowerBoundField (boolean value) {
      this.requestField("estimate_mau_lower_bound", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauUpperBoundField () {
      return this.requestEstimateMauUpperBoundField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauUpperBoundField (boolean value) {
      this.requestField("estimate_mau_upper_bound", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestTargetingOptimizationTypesField () {
      return this.requestTargetingOptimizationTypesField(true);
    }
    public APIRequestGetDeliveryEstimate requestTargetingOptimizationTypesField (boolean value) {
      this.requestField("targeting_optimization_types", value);
      return this;
    }
  }

  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response, String header) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsInsights>>() {
           public APINodeList<AdsInsights> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsights setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsights setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsights setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsights setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsights setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsights setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsights setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsights setFields (List<String> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsights setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsights setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsights setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsights setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsights setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsights setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsights setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsights setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsights setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsights setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsights setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsights setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsights setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsights setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsights setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsights setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsightsAsync extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportRun parseResponse(String response, String header) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportRun>() {
           public AdReportRun apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsightsAsync.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsAsync setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsAsync setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsightsAsync setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsAsync setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsightsAsync setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsAsync setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsightsAsync setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsAsync setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsightsAsync setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsAsync setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsightsAsync setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsightsAsync setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsightsAsync setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsightsAsync setFields (List<String> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsightsAsync setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsAsync setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsightsAsync setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsAsync setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsightsAsync setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsAsync setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsightsAsync setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsAsync setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsightsAsync setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsAsync setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsightsAsync setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsAsync requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTargetingSentenceLines extends APIRequest<TargetingSentenceLine> {

    APINodeList<TargetingSentenceLine> lastResponse = null;
    @Override
    public APINodeList<TargetingSentenceLine> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "params",
      "targetingsentencelines",
    };

    @Override
    public APINodeList<TargetingSentenceLine> parseResponse(String response, String header) throws APIException {
      return TargetingSentenceLine.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<TargetingSentenceLine>>() {
           public APINodeList<TargetingSentenceLine> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTargetingSentenceLines.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSentenceLines requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSentenceLines requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSentenceLines requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestParamsField () {
      return this.requestParamsField(true);
    }
    public APIRequestGetTargetingSentenceLines requestParamsField (boolean value) {
      this.requestField("params", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField () {
      return this.requestTargetingsentencelinesField(true);
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField (boolean value) {
      this.requestField("targetingsentencelines", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "am_call_tags",
      "date_preset",
      "from_adtable",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "asset_feed_id",
      "attribution_spec",
      "bid_adjustments",
      "bid_amount",
      "bid_constraints",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_active_time",
      "campaign_attribution",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "dsa_beneficiary",
      "dsa_payor",
      "effective_status",
      "end_time",
      "existing_customer_budget_percentage",
      "frequency_control_specs",
      "full_funnel_exploration_mode",
      "id",
      "instagram_actor_id",
      "is_budget_schedule_enabled",
      "is_dynamic_creative",
      "issues_info",
      "learning_stage_info",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "multi_optimization_goal_weight",
      "name",
      "optimization_goal",
      "optimization_sub_event",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "regional_regulated_categories",
      "regional_regulation_identities",
      "review_feedback",
      "rf_prediction_id",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "targeting_optimization_types",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public AdSet parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSet>() {
           public AdSet apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet setAmCallTags (Map<String, String> amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }
    public APIRequestGet setAmCallTags (String amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }

    public APIRequestGet setDatePreset (EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGet setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGet setFromAdtable (Boolean fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }
    public APIRequestGet setFromAdtable (String fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }

    public APIRequestGet setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGet setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGet requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGet requestAssetFeedIdField () {
      return this.requestAssetFeedIdField(true);
    }
    public APIRequestGet requestAssetFeedIdField (boolean value) {
      this.requestField("asset_feed_id", value);
      return this;
    }
    public APIRequestGet requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGet requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGet requestBidAdjustmentsField () {
      return this.requestBidAdjustmentsField(true);
    }
    public APIRequestGet requestBidAdjustmentsField (boolean value) {
      this.requestField("bid_adjustments", value);
      return this;
    }
    public APIRequestGet requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGet requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGet requestBidConstraintsField () {
      return this.requestBidConstraintsField(true);
    }
    public APIRequestGet requestBidConstraintsField (boolean value) {
      this.requestField("bid_constraints", value);
      return this;
    }
    public APIRequestGet requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGet requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGet requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGet requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGet requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGet requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGet requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGet requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGet requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGet requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGet requestCampaignActiveTimeField () {
      return this.requestCampaignActiveTimeField(true);
    }
    public APIRequestGet requestCampaignActiveTimeField (boolean value) {
      this.requestField("campaign_active_time", value);
      return this;
    }
    public APIRequestGet requestCampaignAttributionField () {
      return this.requestCampaignAttributionField(true);
    }
    public APIRequestGet requestCampaignAttributionField (boolean value) {
      this.requestField("campaign_attribution", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGet requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGet requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGet requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGet requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGet requestDailyMinSpendTargetField () {
      return this.requestDailyMinSpendTargetField(true);
    }
    public APIRequestGet requestDailyMinSpendTargetField (boolean value) {
      this.requestField("daily_min_spend_target", value);
      return this;
    }
    public APIRequestGet requestDailySpendCapField () {
      return this.requestDailySpendCapField(true);
    }
    public APIRequestGet requestDailySpendCapField (boolean value) {
      this.requestField("daily_spend_cap", value);
      return this;
    }
    public APIRequestGet requestDestinationTypeField () {
      return this.requestDestinationTypeField(true);
    }
    public APIRequestGet requestDestinationTypeField (boolean value) {
      this.requestField("destination_type", value);
      return this;
    }
    public APIRequestGet requestDsaBeneficiaryField () {
      return this.requestDsaBeneficiaryField(true);
    }
    public APIRequestGet requestDsaBeneficiaryField (boolean value) {
      this.requestField("dsa_beneficiary", value);
      return this;
    }
    public APIRequestGet requestDsaPayorField () {
      return this.requestDsaPayorField(true);
    }
    public APIRequestGet requestDsaPayorField (boolean value) {
      this.requestField("dsa_payor", value);
      return this;
    }
    public APIRequestGet requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGet requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestExistingCustomerBudgetPercentageField () {
      return this.requestExistingCustomerBudgetPercentageField(true);
    }
    public APIRequestGet requestExistingCustomerBudgetPercentageField (boolean value) {
      this.requestField("existing_customer_budget_percentage", value);
      return this;
    }
    public APIRequestGet requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGet requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGet requestFullFunnelExplorationModeField () {
      return this.requestFullFunnelExplorationModeField(true);
    }
    public APIRequestGet requestFullFunnelExplorationModeField (boolean value) {
      this.requestField("full_funnel_exploration_mode", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGet requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGet requestIsBudgetScheduleEnabledField () {
      return this.requestIsBudgetScheduleEnabledField(true);
    }
    public APIRequestGet requestIsBudgetScheduleEnabledField (boolean value) {
      this.requestField("is_budget_schedule_enabled", value);
      return this;
    }
    public APIRequestGet requestIsDynamicCreativeField () {
      return this.requestIsDynamicCreativeField(true);
    }
    public APIRequestGet requestIsDynamicCreativeField (boolean value) {
      this.requestField("is_dynamic_creative", value);
      return this;
    }
    public APIRequestGet requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGet requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGet requestLearningStageInfoField () {
      return this.requestLearningStageInfoField(true);
    }
    public APIRequestGet requestLearningStageInfoField (boolean value) {
      this.requestField("learning_stage_info", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGet requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGet requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGet requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGet requestLifetimeMinSpendTargetField () {
      return this.requestLifetimeMinSpendTargetField(true);
    }
    public APIRequestGet requestLifetimeMinSpendTargetField (boolean value) {
      this.requestField("lifetime_min_spend_target", value);
      return this;
    }
    public APIRequestGet requestLifetimeSpendCapField () {
      return this.requestLifetimeSpendCapField(true);
    }
    public APIRequestGet requestLifetimeSpendCapField (boolean value) {
      this.requestField("lifetime_spend_cap", value);
      return this;
    }
    public APIRequestGet requestMultiOptimizationGoalWeightField () {
      return this.requestMultiOptimizationGoalWeightField(true);
    }
    public APIRequestGet requestMultiOptimizationGoalWeightField (boolean value) {
      this.requestField("multi_optimization_goal_weight", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGet requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGet requestOptimizationSubEventField () {
      return this.requestOptimizationSubEventField(true);
    }
    public APIRequestGet requestOptimizationSubEventField (boolean value) {
      this.requestField("optimization_sub_event", value);
      return this;
    }
    public APIRequestGet requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGet requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGet requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGet requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGet requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGet requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGet requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGet requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGet requestRegionalRegulatedCategoriesField () {
      return this.requestRegionalRegulatedCategoriesField(true);
    }
    public APIRequestGet requestRegionalRegulatedCategoriesField (boolean value) {
      this.requestField("regional_regulated_categories", value);
      return this;
    }
    public APIRequestGet requestRegionalRegulationIdentitiesField () {
      return this.requestRegionalRegulationIdentitiesField(true);
    }
    public APIRequestGet requestRegionalRegulationIdentitiesField (boolean value) {
      this.requestField("regional_regulation_identities", value);
      return this;
    }
    public APIRequestGet requestReviewFeedbackField () {
      return this.requestReviewFeedbackField(true);
    }
    public APIRequestGet requestReviewFeedbackField (boolean value) {
      this.requestField("review_feedback", value);
      return this;
    }
    public APIRequestGet requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGet requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGet requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGet requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGet requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGet requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTargetingOptimizationTypesField () {
      return this.requestTargetingOptimizationTypesField(true);
    }
    public APIRequestGet requestTargetingOptimizationTypesField (boolean value) {
      this.requestField("targeting_optimization_types", value);
      return this;
    }
    public APIRequestGet requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGet requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGet requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGet requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGet requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_adjustments",
      "bid_amount",
      "bid_constraints",
      "bid_strategy",
      "billing_event",
      "campaign_attribution",
      "campaign_spec",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "daily_min_spend_target",
      "daily_spend_cap",
      "date_format",
      "destination_type",
      "dsa_beneficiary",
      "dsa_payor",
      "end_time",
      "execution_options",
      "existing_customer_budget_percentage",
      "full_funnel_exploration_mode",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "multi_optimization_goal_weight",
      "name",
      "optimization_goal",
      "optimization_sub_event",
      "pacing_type",
      "promoted_object",
      "rb_prediction_id",
      "regional_regulated_categories",
      "regional_regulation_identities",
      "rf_prediction_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "time_start",
      "time_stop",
      "tune_for_category",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdSet parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSet>() {
           public AdSet apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setAdsetSchedule (List<Object> adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }
    public APIRequestUpdate setAdsetSchedule (String adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestUpdate setAttributionSpec (List<Map<String, String>> attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }
    public APIRequestUpdate setAttributionSpec (String attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }

    public APIRequestUpdate setBidAdjustments (Object bidAdjustments) {
      this.setParam("bid_adjustments", bidAdjustments);
      return this;
    }
    public APIRequestUpdate setBidAdjustments (String bidAdjustments) {
      this.setParam("bid_adjustments", bidAdjustments);
      return this;
    }

    public APIRequestUpdate setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestUpdate setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestUpdate setBidConstraints (Map<String, Object> bidConstraints) {
      this.setParam("bid_constraints", bidConstraints);
      return this;
    }
    public APIRequestUpdate setBidConstraints (String bidConstraints) {
      this.setParam("bid_constraints", bidConstraints);
      return this;
    }

    public APIRequestUpdate setBidStrategy (AdSet.EnumBidStrategy bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }
    public APIRequestUpdate setBidStrategy (String bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }

    public APIRequestUpdate setBillingEvent (AdSet.EnumBillingEvent billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }
    public APIRequestUpdate setBillingEvent (String billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }

    public APIRequestUpdate setCampaignAttribution (Object campaignAttribution) {
      this.setParam("campaign_attribution", campaignAttribution);
      return this;
    }
    public APIRequestUpdate setCampaignAttribution (String campaignAttribution) {
      this.setParam("campaign_attribution", campaignAttribution);
      return this;
    }

    public APIRequestUpdate setCampaignSpec (Object campaignSpec) {
      this.setParam("campaign_spec", campaignSpec);
      return this;
    }
    public APIRequestUpdate setCampaignSpec (String campaignSpec) {
      this.setParam("campaign_spec", campaignSpec);
      return this;
    }

    public APIRequestUpdate setCreativeSequence (List<String> creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }
    public APIRequestUpdate setCreativeSequence (String creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }

    public APIRequestUpdate setDailyBudget (Long dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }
    public APIRequestUpdate setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestUpdate setDailyImps (Long dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }
    public APIRequestUpdate setDailyImps (String dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }

    public APIRequestUpdate setDailyMinSpendTarget (Long dailyMinSpendTarget) {
      this.setParam("daily_min_spend_target", dailyMinSpendTarget);
      return this;
    }
    public APIRequestUpdate setDailyMinSpendTarget (String dailyMinSpendTarget) {
      this.setParam("daily_min_spend_target", dailyMinSpendTarget);
      return this;
    }

    public APIRequestUpdate setDailySpendCap (Long dailySpendCap) {
      this.setParam("daily_spend_cap", dailySpendCap);
      return this;
    }
    public APIRequestUpdate setDailySpendCap (String dailySpendCap) {
      this.setParam("daily_spend_cap", dailySpendCap);
      return this;
    }

    public APIRequestUpdate setDateFormat (String dateFormat) {
      this.setParam("date_format", dateFormat);
      return this;
    }

    public APIRequestUpdate setDestinationType (AdSet.EnumDestinationType destinationType) {
      this.setParam("destination_type", destinationType);
      return this;
    }
    public APIRequestUpdate setDestinationType (String destinationType) {
      this.setParam("destination_type", destinationType);
      return this;
    }

    public APIRequestUpdate setDsaBeneficiary (String dsaBeneficiary) {
      this.setParam("dsa_beneficiary", dsaBeneficiary);
      return this;
    }

    public APIRequestUpdate setDsaPayor (String dsaPayor) {
      this.setParam("dsa_payor", dsaPayor);
      return this;
    }

    public APIRequestUpdate setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestUpdate setExecutionOptions (List<AdSet.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestUpdate setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestUpdate setExistingCustomerBudgetPercentage (Long existingCustomerBudgetPercentage) {
      this.setParam("existing_customer_budget_percentage", existingCustomerBudgetPercentage);
      return this;
    }
    public APIRequestUpdate setExistingCustomerBudgetPercentage (String existingCustomerBudgetPercentage) {
      this.setParam("existing_customer_budget_percentage", existingCustomerBudgetPercentage);
      return this;
    }

    public APIRequestUpdate setFullFunnelExplorationMode (AdSet.EnumFullFunnelExplorationMode fullFunnelExplorationMode) {
      this.setParam("full_funnel_exploration_mode", fullFunnelExplorationMode);
      return this;
    }
    public APIRequestUpdate setFullFunnelExplorationMode (String fullFunnelExplorationMode) {
      this.setParam("full_funnel_exploration_mode", fullFunnelExplorationMode);
      return this;
    }

    public APIRequestUpdate setLifetimeBudget (Long lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }
    public APIRequestUpdate setLifetimeBudget (String lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }

    public APIRequestUpdate setLifetimeImps (Long lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }
    public APIRequestUpdate setLifetimeImps (String lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }

    public APIRequestUpdate setLifetimeMinSpendTarget (Long lifetimeMinSpendTarget) {
      this.setParam("lifetime_min_spend_target", lifetimeMinSpendTarget);
      return this;
    }
    public APIRequestUpdate setLifetimeMinSpendTarget (String lifetimeMinSpendTarget) {
      this.setParam("lifetime_min_spend_target", lifetimeMinSpendTarget);
      return this;
    }

    public APIRequestUpdate setLifetimeSpendCap (Long lifetimeSpendCap) {
      this.setParam("lifetime_spend_cap", lifetimeSpendCap);
      return this;
    }
    public APIRequestUpdate setLifetimeSpendCap (String lifetimeSpendCap) {
      this.setParam("lifetime_spend_cap", lifetimeSpendCap);
      return this;
    }

    public APIRequestUpdate setMultiOptimizationGoalWeight (AdSet.EnumMultiOptimizationGoalWeight multiOptimizationGoalWeight) {
      this.setParam("multi_optimization_goal_weight", multiOptimizationGoalWeight);
      return this;
    }
    public APIRequestUpdate setMultiOptimizationGoalWeight (String multiOptimizationGoalWeight) {
      this.setParam("multi_optimization_goal_weight", multiOptimizationGoalWeight);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setOptimizationGoal (AdSet.EnumOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }
    public APIRequestUpdate setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestUpdate setOptimizationSubEvent (AdSet.EnumOptimizationSubEvent optimizationSubEvent) {
      this.setParam("optimization_sub_event", optimizationSubEvent);
      return this;
    }
    public APIRequestUpdate setOptimizationSubEvent (String optimizationSubEvent) {
      this.setParam("optimization_sub_event", optimizationSubEvent);
      return this;
    }

    public APIRequestUpdate setPacingType (List<String> pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }
    public APIRequestUpdate setPacingType (String pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }

    public APIRequestUpdate setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestUpdate setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestUpdate setRbPredictionId (String rbPredictionId) {
      this.setParam("rb_prediction_id", rbPredictionId);
      return this;
    }

    public APIRequestUpdate setRegionalRegulatedCategories (List<AdSet.EnumRegionalRegulatedCategories> regionalRegulatedCategories) {
      this.setParam("regional_regulated_categories", regionalRegulatedCategories);
      return this;
    }
    public APIRequestUpdate setRegionalRegulatedCategories (String regionalRegulatedCategories) {
      this.setParam("regional_regulated_categories", regionalRegulatedCategories);
      return this;
    }

    public APIRequestUpdate setRegionalRegulationIdentities (Map<String, String> regionalRegulationIdentities) {
      this.setParam("regional_regulation_identities", regionalRegulationIdentities);
      return this;
    }
    public APIRequestUpdate setRegionalRegulationIdentities (String regionalRegulationIdentities) {
      this.setParam("regional_regulation_identities", regionalRegulationIdentities);
      return this;
    }

    public APIRequestUpdate setRfPredictionId (String rfPredictionId) {
      this.setParam("rf_prediction_id", rfPredictionId);
      return this;
    }

    public APIRequestUpdate setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestUpdate setStatus (AdSet.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestUpdate setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestUpdate setTimeBasedAdRotationIdBlocks (List<List<Long>> timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }
    public APIRequestUpdate setTimeBasedAdRotationIdBlocks (String timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }

    public APIRequestUpdate setTimeBasedAdRotationIntervals (List<Long> timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
      return this;
    }
    public APIRequestUpdate setTimeBasedAdRotationIntervals (String timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
      return this;
    }

    public APIRequestUpdate setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestUpdate setTimeStop (String timeStop) {
      this.setParam("time_stop", timeStop);
      return this;
    }

    public APIRequestUpdate setTuneForCategory (AdSet.EnumTuneForCategory tuneForCategory) {
      this.setParam("tune_for_category", tuneForCategory);
      return this;
    }
    public APIRequestUpdate setTuneForCategory (String tuneForCategory) {
      this.setParam("tune_for_category", tuneForCategory);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumBidStrategy {
      @SerializedName("COST_CAP")
      VALUE_COST_CAP("COST_CAP"),
      @SerializedName("LOWEST_COST_WITHOUT_CAP")
      VALUE_LOWEST_COST_WITHOUT_CAP("LOWEST_COST_WITHOUT_CAP"),
      @SerializedName("LOWEST_COST_WITH_BID_CAP")
      VALUE_LOWEST_COST_WITH_BID_CAP("LOWEST_COST_WITH_BID_CAP"),
      @SerializedName("LOWEST_COST_WITH_MIN_ROAS")
      VALUE_LOWEST_COST_WITH_MIN_ROAS("LOWEST_COST_WITH_MIN_ROAS"),
      ;

      private String value;

      private EnumBidStrategy(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBillingEvent {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LISTING_INTERACTION")
      VALUE_LISTING_INTERACTION("LISTING_INTERACTION"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PURCHASE")
      VALUE_PURCHASE("PURCHASE"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      ;

      private String value;

      private EnumBillingEvent(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumConfiguredStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumConfiguredStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("CAMPAIGN_PAUSED")
      VALUE_CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("IN_PROCESS")
      VALUE_IN_PROCESS("IN_PROCESS"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("WITH_ISSUES")
      VALUE_WITH_ISSUES("WITH_ISSUES"),
      ;

      private String value;

      private EnumEffectiveStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
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

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDatePreset {
      @SerializedName("DATA_MAXIMUM")
      VALUE_DATA_MAXIMUM("DATA_MAXIMUM"),
      @SerializedName("LAST_14D")
      VALUE_LAST_14D("LAST_14D"),
      @SerializedName("LAST_28D")
      VALUE_LAST_28D("LAST_28D"),
      @SerializedName("LAST_30D")
      VALUE_LAST_30D("LAST_30D"),
      @SerializedName("LAST_3D")
      VALUE_LAST_3D("LAST_3D"),
      @SerializedName("LAST_7D")
      VALUE_LAST_7D("LAST_7D"),
      @SerializedName("LAST_90D")
      VALUE_LAST_90D("LAST_90D"),
      @SerializedName("LAST_MONTH")
      VALUE_LAST_MONTH("LAST_MONTH"),
      @SerializedName("LAST_QUARTER")
      VALUE_LAST_QUARTER("LAST_QUARTER"),
      @SerializedName("LAST_WEEK_MON_SUN")
      VALUE_LAST_WEEK_MON_SUN("LAST_WEEK_MON_SUN"),
      @SerializedName("LAST_WEEK_SUN_SAT")
      VALUE_LAST_WEEK_SUN_SAT("LAST_WEEK_SUN_SAT"),
      @SerializedName("LAST_YEAR")
      VALUE_LAST_YEAR("LAST_YEAR"),
      @SerializedName("MAXIMUM")
      VALUE_MAXIMUM("MAXIMUM"),
      @SerializedName("THIS_MONTH")
      VALUE_THIS_MONTH("THIS_MONTH"),
      @SerializedName("THIS_QUARTER")
      VALUE_THIS_QUARTER("THIS_QUARTER"),
      @SerializedName("THIS_WEEK_MON_TODAY")
      VALUE_THIS_WEEK_MON_TODAY("THIS_WEEK_MON_TODAY"),
      @SerializedName("THIS_WEEK_SUN_TODAY")
      VALUE_THIS_WEEK_SUN_TODAY("THIS_WEEK_SUN_TODAY"),
      @SerializedName("THIS_YEAR")
      VALUE_THIS_YEAR("THIS_YEAR"),
      @SerializedName("TODAY")
      VALUE_TODAY("TODAY"),
      @SerializedName("YESTERDAY")
      VALUE_YESTERDAY("YESTERDAY"),
      ;

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDestinationType {
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("APPLINKS_AUTOMATIC")
      VALUE_APPLINKS_AUTOMATIC("APPLINKS_AUTOMATIC"),
      @SerializedName("FACEBOOK")
      VALUE_FACEBOOK("FACEBOOK"),
      @SerializedName("INSTAGRAM_DIRECT")
      VALUE_INSTAGRAM_DIRECT("INSTAGRAM_DIRECT"),
      @SerializedName("INSTAGRAM_PROFILE")
      VALUE_INSTAGRAM_PROFILE("INSTAGRAM_PROFILE"),
      @SerializedName("MESSAGING_INSTAGRAM_DIRECT_MESSENGER")
      VALUE_MESSAGING_INSTAGRAM_DIRECT_MESSENGER("MESSAGING_INSTAGRAM_DIRECT_MESSENGER"),
      @SerializedName("MESSAGING_INSTAGRAM_DIRECT_MESSENGER_WHATSAPP")
      VALUE_MESSAGING_INSTAGRAM_DIRECT_MESSENGER_WHATSAPP("MESSAGING_INSTAGRAM_DIRECT_MESSENGER_WHATSAPP"),
      @SerializedName("MESSAGING_INSTAGRAM_DIRECT_WHATSAPP")
      VALUE_MESSAGING_INSTAGRAM_DIRECT_WHATSAPP("MESSAGING_INSTAGRAM_DIRECT_WHATSAPP"),
      @SerializedName("MESSAGING_MESSENGER_WHATSAPP")
      VALUE_MESSAGING_MESSENGER_WHATSAPP("MESSAGING_MESSENGER_WHATSAPP"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("ON_AD")
      VALUE_ON_AD("ON_AD"),
      @SerializedName("ON_EVENT")
      VALUE_ON_EVENT("ON_EVENT"),
      @SerializedName("ON_PAGE")
      VALUE_ON_PAGE("ON_PAGE"),
      @SerializedName("ON_POST")
      VALUE_ON_POST("ON_POST"),
      @SerializedName("ON_VIDEO")
      VALUE_ON_VIDEO("ON_VIDEO"),
      @SerializedName("SHOP_AUTOMATIC")
      VALUE_SHOP_AUTOMATIC("SHOP_AUTOMATIC"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      @SerializedName("WHATSAPP")
      VALUE_WHATSAPP("WHATSAPP"),
      ;

      private String value;

      private EnumDestinationType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumExecutionOptions {
      @SerializedName("include_recommendations")
      VALUE_INCLUDE_RECOMMENDATIONS("include_recommendations"),
      @SerializedName("validate_only")
      VALUE_VALIDATE_ONLY("validate_only"),
      ;

      private String value;

      private EnumExecutionOptions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFullFunnelExplorationMode {
      @SerializedName("EXTENDED_EXPLORATION")
      VALUE_EXTENDED_EXPLORATION("EXTENDED_EXPLORATION"),
      @SerializedName("LIMITED_EXPLORATION")
      VALUE_LIMITED_EXPLORATION("LIMITED_EXPLORATION"),
      @SerializedName("NONE_EXPLORATION")
      VALUE_NONE_EXPLORATION("NONE_EXPLORATION"),
      ;

      private String value;

      private EnumFullFunnelExplorationMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMultiOptimizationGoalWeight {
      @SerializedName("BALANCED")
      VALUE_BALANCED("BALANCED"),
      @SerializedName("PREFER_EVENT")
      VALUE_PREFER_EVENT("PREFER_EVENT"),
      @SerializedName("PREFER_INSTALL")
      VALUE_PREFER_INSTALL("PREFER_INSTALL"),
      @SerializedName("UNDEFINED")
      VALUE_UNDEFINED("UNDEFINED"),
      ;

      private String value;

      private EnumMultiOptimizationGoalWeight(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOptimizationSubEvent {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("TRAVEL_INTENT")
      VALUE_TRAVEL_INTENT("TRAVEL_INTENT"),
      @SerializedName("TRAVEL_INTENT_BUCKET_01")
      VALUE_TRAVEL_INTENT_BUCKET_01("TRAVEL_INTENT_BUCKET_01"),
      @SerializedName("TRAVEL_INTENT_BUCKET_02")
      VALUE_TRAVEL_INTENT_BUCKET_02("TRAVEL_INTENT_BUCKET_02"),
      @SerializedName("TRAVEL_INTENT_BUCKET_03")
      VALUE_TRAVEL_INTENT_BUCKET_03("TRAVEL_INTENT_BUCKET_03"),
      @SerializedName("TRAVEL_INTENT_BUCKET_04")
      VALUE_TRAVEL_INTENT_BUCKET_04("TRAVEL_INTENT_BUCKET_04"),
      @SerializedName("TRAVEL_INTENT_BUCKET_05")
      VALUE_TRAVEL_INTENT_BUCKET_05("TRAVEL_INTENT_BUCKET_05"),
      @SerializedName("TRAVEL_INTENT_NO_DESTINATION_INTENT")
      VALUE_TRAVEL_INTENT_NO_DESTINATION_INTENT("TRAVEL_INTENT_NO_DESTINATION_INTENT"),
      @SerializedName("TRIP_CONSIDERATION")
      VALUE_TRIP_CONSIDERATION("TRIP_CONSIDERATION"),
      @SerializedName("VIDEO_SOUND_ON")
      VALUE_VIDEO_SOUND_ON("VIDEO_SOUND_ON"),
      ;

      private String value;

      private EnumOptimizationSubEvent(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRegionalRegulatedCategories {
      @SerializedName("0")
      VALUE_0("0"),
      @SerializedName("1")
      VALUE_1("1"),
      ;

      private String value;

      private EnumRegionalRegulatedCategories(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTuneForCategory {
      @SerializedName("CREDIT")
      VALUE_CREDIT("CREDIT"),
      @SerializedName("EMPLOYMENT")
      VALUE_EMPLOYMENT("EMPLOYMENT"),
      @SerializedName("HOUSING")
      VALUE_HOUSING("HOUSING"),
      @SerializedName("ISSUES_ELECTIONS_POLITICS")
      VALUE_ISSUES_ELECTIONS_POLITICS("ISSUES_ELECTIONS_POLITICS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("ONLINE_GAMBLING_AND_GAMING")
      VALUE_ONLINE_GAMBLING_AND_GAMING("ONLINE_GAMBLING_AND_GAMING"),
      ;

      private String value;

      private EnumTuneForCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOperator {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("ANY")
      VALUE_ANY("ANY"),
      ;

      private String value;

      private EnumOperator(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatusOption {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("INHERITED_FROM_SOURCE")
      VALUE_INHERITED_FROM_SOURCE("INHERITED_FROM_SOURCE"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumStatusOption(String value) {
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

  public AdSet copyFrom(AdSet instance) {
    this.mAccountId = instance.mAccountId;
    this.mAdlabels = instance.mAdlabels;
    this.mAdsetSchedule = instance.mAdsetSchedule;
    this.mAssetFeedId = instance.mAssetFeedId;
    this.mAttributionSpec = instance.mAttributionSpec;
    this.mBidAdjustments = instance.mBidAdjustments;
    this.mBidAmount = instance.mBidAmount;
    this.mBidConstraints = instance.mBidConstraints;
    this.mBidInfo = instance.mBidInfo;
    this.mBidStrategy = instance.mBidStrategy;
    this.mBillingEvent = instance.mBillingEvent;
    this.mBudgetRemaining = instance.mBudgetRemaining;
    this.mCampaign = instance.mCampaign;
    this.mCampaignActiveTime = instance.mCampaignActiveTime;
    this.mCampaignAttribution = instance.mCampaignAttribution;
    this.mCampaignId = instance.mCampaignId;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeSequence = instance.mCreativeSequence;
    this.mDailyBudget = instance.mDailyBudget;
    this.mDailyMinSpendTarget = instance.mDailyMinSpendTarget;
    this.mDailySpendCap = instance.mDailySpendCap;
    this.mDestinationType = instance.mDestinationType;
    this.mDsaBeneficiary = instance.mDsaBeneficiary;
    this.mDsaPayor = instance.mDsaPayor;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mEndTime = instance.mEndTime;
    this.mExistingCustomerBudgetPercentage = instance.mExistingCustomerBudgetPercentage;
    this.mFrequencyControlSpecs = instance.mFrequencyControlSpecs;
    this.mFullFunnelExplorationMode = instance.mFullFunnelExplorationMode;
    this.mId = instance.mId;
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mIsBudgetScheduleEnabled = instance.mIsBudgetScheduleEnabled;
    this.mIsDynamicCreative = instance.mIsDynamicCreative;
    this.mIssuesInfo = instance.mIssuesInfo;
    this.mLearningStageInfo = instance.mLearningStageInfo;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mLifetimeImps = instance.mLifetimeImps;
    this.mLifetimeMinSpendTarget = instance.mLifetimeMinSpendTarget;
    this.mLifetimeSpendCap = instance.mLifetimeSpendCap;
    this.mMultiOptimizationGoalWeight = instance.mMultiOptimizationGoalWeight;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mOptimizationSubEvent = instance.mOptimizationSubEvent;
    this.mPacingType = instance.mPacingType;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRecommendations = instance.mRecommendations;
    this.mRecurringBudgetSemantics = instance.mRecurringBudgetSemantics;
    this.mRegionalRegulatedCategories = instance.mRegionalRegulatedCategories;
    this.mRegionalRegulationIdentities = instance.mRegionalRegulationIdentities;
    this.mReviewFeedback = instance.mReviewFeedback;
    this.mRfPredictionId = instance.mRfPredictionId;
    this.mSourceAdset = instance.mSourceAdset;
    this.mSourceAdsetId = instance.mSourceAdsetId;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mTargeting = instance.mTargeting;
    this.mTargetingOptimizationTypes = instance.mTargetingOptimizationTypes;
    this.mTimeBasedAdRotationIdBlocks = instance.mTimeBasedAdRotationIdBlocks;
    this.mTimeBasedAdRotationIntervals = instance.mTimeBasedAdRotationIntervals;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUseNewAppClick = instance.mUseNewAppClick;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdSet> getParser() {
    return new APIRequest.ResponseParser<AdSet>() {
      public APINodeList<AdSet> parseResponse(String response, APIContext context, APIRequest<AdSet> request, String header) throws MalformedResponseException {
        return AdSet.parseResponse(response, context, request, header);
      }
    };
  }
}
