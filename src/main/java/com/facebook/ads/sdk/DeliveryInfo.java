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
public class DeliveryInfo extends APINode {
  @SerializedName("active_accelerated_campaign_count")
  private Long mActiveAcceleratedCampaignCount = null;
  @SerializedName("active_day_parted_campaign_count")
  private Long mActiveDayPartedCampaignCount = null;
  @SerializedName("ad_penalty_map")
  private List<Map<String, Boolean>> mAdPenaltyMap = null;
  @SerializedName("are_all_daily_budgets_spent")
  private Boolean mAreAllDailyBudgetsSpent = null;
  @SerializedName("credit_needed_ads_count")
  private Long mCreditNeededAdsCount = null;
  @SerializedName("eligible_for_delivery_insights")
  private Boolean mEligibleForDeliveryInsights = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("has_account_hit_spend_limit")
  private Boolean mHasAccountHitSpendLimit = null;
  @SerializedName("has_campaign_group_hit_spend_limit")
  private Boolean mHasCampaignGroupHitSpendLimit = null;
  @SerializedName("has_no_active_ads")
  private Boolean mHasNoActiveAds = null;
  @SerializedName("has_no_ads")
  private Boolean mHasNoAds = null;
  @SerializedName("inactive_ads_count")
  private Long mInactiveAdsCount = null;
  @SerializedName("inactive_campaign_count")
  private Long mInactiveCampaignCount = null;
  @SerializedName("is_account_closed")
  private Boolean mIsAccountClosed = null;
  @SerializedName("is_account_disabled")
  private Boolean mIsAccountDisabled = null;
  @SerializedName("is_ad_uneconomical")
  private Boolean mIsAdUneconomical = null;
  @SerializedName("is_adfarm_penalized")
  private Boolean mIsAdfarmPenalized = null;
  @SerializedName("is_adgroup_partially_rejected")
  private Boolean mIsAdgroupPartiallyRejected = null;
  @SerializedName("is_campaign_accelerated")
  private Boolean mIsCampaignAccelerated = null;
  @SerializedName("is_campaign_completed")
  private Boolean mIsCampaignCompleted = null;
  @SerializedName("is_campaign_day_parted")
  private Boolean mIsCampaignDayParted = null;
  @SerializedName("is_campaign_disabled")
  private Boolean mIsCampaignDisabled = null;
  @SerializedName("is_campaign_group_disabled")
  private Boolean mIsCampaignGroupDisabled = null;
  @SerializedName("is_clickbait_penalized")
  private Boolean mIsClickbaitPenalized = null;
  @SerializedName("is_daily_budget_spent")
  private Boolean mIsDailyBudgetSpent = null;
  @SerializedName("is_engagement_bait_penalized")
  private Boolean mIsEngagementBaitPenalized = null;
  @SerializedName("is_lqwe_penalized")
  private Boolean mIsLqwePenalized = null;
  @SerializedName("is_reach_and_frequency_misconfigured")
  private Boolean mIsReachAndFrequencyMisconfigured = null;
  @SerializedName("is_sensationalism_penalized")
  private Boolean mIsSensationalismPenalized = null;
  @SerializedName("is_split_test_active")
  private Boolean mIsSplitTestActive = null;
  @SerializedName("is_split_test_valid")
  private Boolean mIsSplitTestValid = null;
  @SerializedName("lift_study_time_period")
  private String mLiftStudyTimePeriod = null;
  @SerializedName("needs_credit")
  private Boolean mNeedsCredit = null;
  @SerializedName("needs_tax_number")
  private Boolean mNeedsTaxNumber = null;
  @SerializedName("non_deleted_ads_count")
  private Long mNonDeletedAdsCount = null;
  @SerializedName("not_delivering_campaign_count")
  private Long mNotDeliveringCampaignCount = null;
  @SerializedName("pending_ads_count")
  private Long mPendingAdsCount = null;
  @SerializedName("reach_frequency_campaign_underdelivery_reason")
  private String mReachFrequencyCampaignUnderdeliveryReason = null;
  @SerializedName("rejected_ads_count")
  private Long mRejectedAdsCount = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("text_penalty_level")
  private String mTextPenaltyLevel = null;
  protected static Gson gson = null;

  public DeliveryInfo() {
  }

  public String getId() {
    return null;
  }
  public static DeliveryInfo loadJSON(String json, APIContext context, String header) {
    DeliveryInfo deliveryInfo = getGson().fromJson(json, DeliveryInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(deliveryInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    deliveryInfo.context = context;
    deliveryInfo.rawValue = json;
    deliveryInfo.header = header;
    return deliveryInfo;
  }

  public static APINodeList<DeliveryInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<DeliveryInfo> deliveryInfos = new APINodeList<DeliveryInfo>(request, json, header);
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
          deliveryInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return deliveryInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                deliveryInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            deliveryInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              deliveryInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              deliveryInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  deliveryInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              deliveryInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return deliveryInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              deliveryInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return deliveryInfos;
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
              deliveryInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return deliveryInfos;
          }

          // Sixth, check if it's pure JsonObject
          deliveryInfos.clear();
          deliveryInfos.add(loadJSON(json, context, header));
          return deliveryInfos;
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


  public Long getFieldActiveAcceleratedCampaignCount() {
    return mActiveAcceleratedCampaignCount;
  }

  public DeliveryInfo setFieldActiveAcceleratedCampaignCount(Long value) {
    this.mActiveAcceleratedCampaignCount = value;
    return this;
  }

  public Long getFieldActiveDayPartedCampaignCount() {
    return mActiveDayPartedCampaignCount;
  }

  public DeliveryInfo setFieldActiveDayPartedCampaignCount(Long value) {
    this.mActiveDayPartedCampaignCount = value;
    return this;
  }

  public List<Map<String, Boolean>> getFieldAdPenaltyMap() {
    return mAdPenaltyMap;
  }

  public DeliveryInfo setFieldAdPenaltyMap(List<Map<String, Boolean>> value) {
    this.mAdPenaltyMap = value;
    return this;
  }

  public Boolean getFieldAreAllDailyBudgetsSpent() {
    return mAreAllDailyBudgetsSpent;
  }

  public DeliveryInfo setFieldAreAllDailyBudgetsSpent(Boolean value) {
    this.mAreAllDailyBudgetsSpent = value;
    return this;
  }

  public Long getFieldCreditNeededAdsCount() {
    return mCreditNeededAdsCount;
  }

  public DeliveryInfo setFieldCreditNeededAdsCount(Long value) {
    this.mCreditNeededAdsCount = value;
    return this;
  }

  public Boolean getFieldEligibleForDeliveryInsights() {
    return mEligibleForDeliveryInsights;
  }

  public DeliveryInfo setFieldEligibleForDeliveryInsights(Boolean value) {
    this.mEligibleForDeliveryInsights = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public DeliveryInfo setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public Boolean getFieldHasAccountHitSpendLimit() {
    return mHasAccountHitSpendLimit;
  }

  public DeliveryInfo setFieldHasAccountHitSpendLimit(Boolean value) {
    this.mHasAccountHitSpendLimit = value;
    return this;
  }

  public Boolean getFieldHasCampaignGroupHitSpendLimit() {
    return mHasCampaignGroupHitSpendLimit;
  }

  public DeliveryInfo setFieldHasCampaignGroupHitSpendLimit(Boolean value) {
    this.mHasCampaignGroupHitSpendLimit = value;
    return this;
  }

  public Boolean getFieldHasNoActiveAds() {
    return mHasNoActiveAds;
  }

  public DeliveryInfo setFieldHasNoActiveAds(Boolean value) {
    this.mHasNoActiveAds = value;
    return this;
  }

  public Boolean getFieldHasNoAds() {
    return mHasNoAds;
  }

  public DeliveryInfo setFieldHasNoAds(Boolean value) {
    this.mHasNoAds = value;
    return this;
  }

  public Long getFieldInactiveAdsCount() {
    return mInactiveAdsCount;
  }

  public DeliveryInfo setFieldInactiveAdsCount(Long value) {
    this.mInactiveAdsCount = value;
    return this;
  }

  public Long getFieldInactiveCampaignCount() {
    return mInactiveCampaignCount;
  }

  public DeliveryInfo setFieldInactiveCampaignCount(Long value) {
    this.mInactiveCampaignCount = value;
    return this;
  }

  public Boolean getFieldIsAccountClosed() {
    return mIsAccountClosed;
  }

  public DeliveryInfo setFieldIsAccountClosed(Boolean value) {
    this.mIsAccountClosed = value;
    return this;
  }

  public Boolean getFieldIsAccountDisabled() {
    return mIsAccountDisabled;
  }

  public DeliveryInfo setFieldIsAccountDisabled(Boolean value) {
    this.mIsAccountDisabled = value;
    return this;
  }

  public Boolean getFieldIsAdUneconomical() {
    return mIsAdUneconomical;
  }

  public DeliveryInfo setFieldIsAdUneconomical(Boolean value) {
    this.mIsAdUneconomical = value;
    return this;
  }

  public Boolean getFieldIsAdfarmPenalized() {
    return mIsAdfarmPenalized;
  }

  public DeliveryInfo setFieldIsAdfarmPenalized(Boolean value) {
    this.mIsAdfarmPenalized = value;
    return this;
  }

  public Boolean getFieldIsAdgroupPartiallyRejected() {
    return mIsAdgroupPartiallyRejected;
  }

  public DeliveryInfo setFieldIsAdgroupPartiallyRejected(Boolean value) {
    this.mIsAdgroupPartiallyRejected = value;
    return this;
  }

  public Boolean getFieldIsCampaignAccelerated() {
    return mIsCampaignAccelerated;
  }

  public DeliveryInfo setFieldIsCampaignAccelerated(Boolean value) {
    this.mIsCampaignAccelerated = value;
    return this;
  }

  public Boolean getFieldIsCampaignCompleted() {
    return mIsCampaignCompleted;
  }

  public DeliveryInfo setFieldIsCampaignCompleted(Boolean value) {
    this.mIsCampaignCompleted = value;
    return this;
  }

  public Boolean getFieldIsCampaignDayParted() {
    return mIsCampaignDayParted;
  }

  public DeliveryInfo setFieldIsCampaignDayParted(Boolean value) {
    this.mIsCampaignDayParted = value;
    return this;
  }

  public Boolean getFieldIsCampaignDisabled() {
    return mIsCampaignDisabled;
  }

  public DeliveryInfo setFieldIsCampaignDisabled(Boolean value) {
    this.mIsCampaignDisabled = value;
    return this;
  }

  public Boolean getFieldIsCampaignGroupDisabled() {
    return mIsCampaignGroupDisabled;
  }

  public DeliveryInfo setFieldIsCampaignGroupDisabled(Boolean value) {
    this.mIsCampaignGroupDisabled = value;
    return this;
  }

  public Boolean getFieldIsClickbaitPenalized() {
    return mIsClickbaitPenalized;
  }

  public DeliveryInfo setFieldIsClickbaitPenalized(Boolean value) {
    this.mIsClickbaitPenalized = value;
    return this;
  }

  public Boolean getFieldIsDailyBudgetSpent() {
    return mIsDailyBudgetSpent;
  }

  public DeliveryInfo setFieldIsDailyBudgetSpent(Boolean value) {
    this.mIsDailyBudgetSpent = value;
    return this;
  }

  public Boolean getFieldIsEngagementBaitPenalized() {
    return mIsEngagementBaitPenalized;
  }

  public DeliveryInfo setFieldIsEngagementBaitPenalized(Boolean value) {
    this.mIsEngagementBaitPenalized = value;
    return this;
  }

  public Boolean getFieldIsLqwePenalized() {
    return mIsLqwePenalized;
  }

  public DeliveryInfo setFieldIsLqwePenalized(Boolean value) {
    this.mIsLqwePenalized = value;
    return this;
  }

  public Boolean getFieldIsReachAndFrequencyMisconfigured() {
    return mIsReachAndFrequencyMisconfigured;
  }

  public DeliveryInfo setFieldIsReachAndFrequencyMisconfigured(Boolean value) {
    this.mIsReachAndFrequencyMisconfigured = value;
    return this;
  }

  public Boolean getFieldIsSensationalismPenalized() {
    return mIsSensationalismPenalized;
  }

  public DeliveryInfo setFieldIsSensationalismPenalized(Boolean value) {
    this.mIsSensationalismPenalized = value;
    return this;
  }

  public Boolean getFieldIsSplitTestActive() {
    return mIsSplitTestActive;
  }

  public DeliveryInfo setFieldIsSplitTestActive(Boolean value) {
    this.mIsSplitTestActive = value;
    return this;
  }

  public Boolean getFieldIsSplitTestValid() {
    return mIsSplitTestValid;
  }

  public DeliveryInfo setFieldIsSplitTestValid(Boolean value) {
    this.mIsSplitTestValid = value;
    return this;
  }

  public String getFieldLiftStudyTimePeriod() {
    return mLiftStudyTimePeriod;
  }

  public DeliveryInfo setFieldLiftStudyTimePeriod(String value) {
    this.mLiftStudyTimePeriod = value;
    return this;
  }

  public Boolean getFieldNeedsCredit() {
    return mNeedsCredit;
  }

  public DeliveryInfo setFieldNeedsCredit(Boolean value) {
    this.mNeedsCredit = value;
    return this;
  }

  public Boolean getFieldNeedsTaxNumber() {
    return mNeedsTaxNumber;
  }

  public DeliveryInfo setFieldNeedsTaxNumber(Boolean value) {
    this.mNeedsTaxNumber = value;
    return this;
  }

  public Long getFieldNonDeletedAdsCount() {
    return mNonDeletedAdsCount;
  }

  public DeliveryInfo setFieldNonDeletedAdsCount(Long value) {
    this.mNonDeletedAdsCount = value;
    return this;
  }

  public Long getFieldNotDeliveringCampaignCount() {
    return mNotDeliveringCampaignCount;
  }

  public DeliveryInfo setFieldNotDeliveringCampaignCount(Long value) {
    this.mNotDeliveringCampaignCount = value;
    return this;
  }

  public Long getFieldPendingAdsCount() {
    return mPendingAdsCount;
  }

  public DeliveryInfo setFieldPendingAdsCount(Long value) {
    this.mPendingAdsCount = value;
    return this;
  }

  public String getFieldReachFrequencyCampaignUnderdeliveryReason() {
    return mReachFrequencyCampaignUnderdeliveryReason;
  }

  public DeliveryInfo setFieldReachFrequencyCampaignUnderdeliveryReason(String value) {
    this.mReachFrequencyCampaignUnderdeliveryReason = value;
    return this;
  }

  public Long getFieldRejectedAdsCount() {
    return mRejectedAdsCount;
  }

  public DeliveryInfo setFieldRejectedAdsCount(Long value) {
    this.mRejectedAdsCount = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public DeliveryInfo setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public DeliveryInfo setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldTextPenaltyLevel() {
    return mTextPenaltyLevel;
  }

  public DeliveryInfo setFieldTextPenaltyLevel(String value) {
    this.mTextPenaltyLevel = value;
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

  public DeliveryInfo copyFrom(DeliveryInfo instance) {
    this.mActiveAcceleratedCampaignCount = instance.mActiveAcceleratedCampaignCount;
    this.mActiveDayPartedCampaignCount = instance.mActiveDayPartedCampaignCount;
    this.mAdPenaltyMap = instance.mAdPenaltyMap;
    this.mAreAllDailyBudgetsSpent = instance.mAreAllDailyBudgetsSpent;
    this.mCreditNeededAdsCount = instance.mCreditNeededAdsCount;
    this.mEligibleForDeliveryInsights = instance.mEligibleForDeliveryInsights;
    this.mEndTime = instance.mEndTime;
    this.mHasAccountHitSpendLimit = instance.mHasAccountHitSpendLimit;
    this.mHasCampaignGroupHitSpendLimit = instance.mHasCampaignGroupHitSpendLimit;
    this.mHasNoActiveAds = instance.mHasNoActiveAds;
    this.mHasNoAds = instance.mHasNoAds;
    this.mInactiveAdsCount = instance.mInactiveAdsCount;
    this.mInactiveCampaignCount = instance.mInactiveCampaignCount;
    this.mIsAccountClosed = instance.mIsAccountClosed;
    this.mIsAccountDisabled = instance.mIsAccountDisabled;
    this.mIsAdUneconomical = instance.mIsAdUneconomical;
    this.mIsAdfarmPenalized = instance.mIsAdfarmPenalized;
    this.mIsAdgroupPartiallyRejected = instance.mIsAdgroupPartiallyRejected;
    this.mIsCampaignAccelerated = instance.mIsCampaignAccelerated;
    this.mIsCampaignCompleted = instance.mIsCampaignCompleted;
    this.mIsCampaignDayParted = instance.mIsCampaignDayParted;
    this.mIsCampaignDisabled = instance.mIsCampaignDisabled;
    this.mIsCampaignGroupDisabled = instance.mIsCampaignGroupDisabled;
    this.mIsClickbaitPenalized = instance.mIsClickbaitPenalized;
    this.mIsDailyBudgetSpent = instance.mIsDailyBudgetSpent;
    this.mIsEngagementBaitPenalized = instance.mIsEngagementBaitPenalized;
    this.mIsLqwePenalized = instance.mIsLqwePenalized;
    this.mIsReachAndFrequencyMisconfigured = instance.mIsReachAndFrequencyMisconfigured;
    this.mIsSensationalismPenalized = instance.mIsSensationalismPenalized;
    this.mIsSplitTestActive = instance.mIsSplitTestActive;
    this.mIsSplitTestValid = instance.mIsSplitTestValid;
    this.mLiftStudyTimePeriod = instance.mLiftStudyTimePeriod;
    this.mNeedsCredit = instance.mNeedsCredit;
    this.mNeedsTaxNumber = instance.mNeedsTaxNumber;
    this.mNonDeletedAdsCount = instance.mNonDeletedAdsCount;
    this.mNotDeliveringCampaignCount = instance.mNotDeliveringCampaignCount;
    this.mPendingAdsCount = instance.mPendingAdsCount;
    this.mReachFrequencyCampaignUnderdeliveryReason = instance.mReachFrequencyCampaignUnderdeliveryReason;
    this.mRejectedAdsCount = instance.mRejectedAdsCount;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mTextPenaltyLevel = instance.mTextPenaltyLevel;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<DeliveryInfo> getParser() {
    return new APIRequest.ResponseParser<DeliveryInfo>() {
      public APINodeList<DeliveryInfo> parseResponse(String response, APIContext context, APIRequest<DeliveryInfo> request, String header) throws MalformedResponseException {
        return DeliveryInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
