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
public class ReachFrequencyPrediction extends APINode {
  @SerializedName("account_id")
  private Long mAccountId = null;
  @SerializedName("activity_status")
  private ReachFrequencyActivity mActivityStatus = null;
  @SerializedName("ad_formats")
  private List<ReachFrequencyAdFormat> mAdFormats = null;
  @SerializedName("auction_entry_option_index")
  private Long mAuctionEntryOptionIndex = null;
  @SerializedName("audience_size_lower_bound")
  private Long mAudienceSizeLowerBound = null;
  @SerializedName("audience_size_upper_bound")
  private Long mAudienceSizeUpperBound = null;
  @SerializedName("business_id")
  private Long mBusinessId = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("campaign_group_id")
  private Long mCampaignGroupId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_time_start")
  private String mCampaignTimeStart = null;
  @SerializedName("campaign_time_stop")
  private String mCampaignTimeStop = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("curve_budget_reach")
  private ReachFrequencyEstimatesCurve mCurveBudgetReach = null;
  @SerializedName("curve_reach")
  private List<Long> mCurveReach = null;
  @SerializedName("daily_grp_curve")
  private List<Double> mDailyGrpCurve = null;
  @SerializedName("daily_impression_curve")
  private List<Double> mDailyImpressionCurve = null;
  @SerializedName("daily_impression_curve_map")
  private List<Map<Long, List<Double>>> mDailyImpressionCurveMap = null;
  @SerializedName("day_parting_schedule")
  private List<ReachFrequencyDayPart> mDayPartingSchedule = null;
  @SerializedName("destination_id")
  private String mDestinationId = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("external_budget")
  private Long mExternalBudget = null;
  @SerializedName("external_impression")
  private Long mExternalImpression = null;
  @SerializedName("external_maximum_budget")
  private Long mExternalMaximumBudget = null;
  @SerializedName("external_maximum_impression")
  private String mExternalMaximumImpression = null;
  @SerializedName("external_maximum_reach")
  private Long mExternalMaximumReach = null;
  @SerializedName("external_minimum_budget")
  private Long mExternalMinimumBudget = null;
  @SerializedName("external_minimum_impression")
  private Long mExternalMinimumImpression = null;
  @SerializedName("external_minimum_reach")
  private Long mExternalMinimumReach = null;
  @SerializedName("external_reach")
  private Long mExternalReach = null;
  @SerializedName("feed_ratio_0000")
  private Long mFeedRatio0000 = null;
  @SerializedName("frequency_cap")
  private Long mFrequencyCap = null;
  @SerializedName("frequency_distribution_map")
  private List<Map<Long, List<Double>>> mFrequencyDistributionMap = null;
  @SerializedName("frequency_distribution_map_agg")
  private List<Map<Long, List<Long>>> mFrequencyDistributionMapAgg = null;
  @SerializedName("grp_audience_size")
  private Double mGrpAudienceSize = null;
  @SerializedName("grp_avg_probability_map")
  private String mGrpAvgProbabilityMap = null;
  @SerializedName("grp_country_audience_size")
  private Double mGrpCountryAudienceSize = null;
  @SerializedName("grp_curve")
  private List<Double> mGrpCurve = null;
  @SerializedName("grp_dmas_audience_size")
  private Double mGrpDmasAudienceSize = null;
  @SerializedName("grp_filtering_threshold_00")
  private Long mGrpFilteringThreshold00 = null;
  @SerializedName("grp_points")
  private Double mGrpPoints = null;
  @SerializedName("grp_ratio")
  private Double mGrpRatio = null;
  @SerializedName("grp_reach_ratio")
  private Double mGrpReachRatio = null;
  @SerializedName("grp_status")
  private String mGrpStatus = null;
  @SerializedName("holdout_percentage")
  private Long mHoldoutPercentage = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impression_curve")
  private List<Long> mImpressionCurve = null;
  @SerializedName("instagram_destination_id")
  private String mInstagramDestinationId = null;
  @SerializedName("instream_packages")
  private List<String> mInstreamPackages = null;
  @SerializedName("interval_frequency_cap")
  private Long mIntervalFrequencyCap = null;
  @SerializedName("interval_frequency_cap_reset_period")
  private Long mIntervalFrequencyCapResetPeriod = null;
  @SerializedName("is_bonus_media")
  private Long mIsBonusMedia = null;
  @SerializedName("is_conversion_goal")
  private Long mIsConversionGoal = null;
  @SerializedName("is_higher_average_frequency")
  private Boolean mIsHigherAverageFrequency = null;
  @SerializedName("is_io")
  private Boolean mIsIo = null;
  @SerializedName("is_reserved_buying")
  private Long mIsReservedBuying = null;
  @SerializedName("is_trp")
  private Boolean mIsTrp = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("objective")
  private Long mObjective = null;
  @SerializedName("objective_name")
  private String mObjectiveName = null;
  @SerializedName("odax_objective")
  private Long mOdaxObjective = null;
  @SerializedName("odax_objective_name")
  private String mOdaxObjectiveName = null;
  @SerializedName("optimization_goal")
  private Long mOptimizationGoal = null;
  @SerializedName("optimization_goal_name")
  private String mOptimizationGoalName = null;
  @SerializedName("pause_periods")
  private List<Object> mPausePeriods = null;
  @SerializedName("placement_breakdown")
  private ReachFrequencyEstimatesPlacementBreakdown mPlacementBreakdown = null;
  @SerializedName("placement_breakdown_map")
  private List<Map<Long, ReachFrequencyEstimatesPlacementBreakdown>> mPlacementBreakdownMap = null;
  @SerializedName("plan_name")
  private String mPlanName = null;
  @SerializedName("plan_type")
  private String mPlanType = null;
  @SerializedName("prediction_mode")
  private Long mPredictionMode = null;
  @SerializedName("prediction_progress")
  private Long mPredictionProgress = null;
  @SerializedName("reference_id")
  private String mReferenceId = null;
  @SerializedName("reservation_status")
  private Long mReservationStatus = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private Long mStatus = null;
  @SerializedName("story_event_type")
  private Long mStoryEventType = null;
  @SerializedName("target_cpm")
  private Long mTargetCpm = null;
  @SerializedName("target_spec")
  private Targeting mTargetSpec = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  @SerializedName("timezone_id")
  private Long mTimezoneId = null;
  @SerializedName("timezone_name")
  private String mTimezoneName = null;
  @SerializedName("topline_id")
  private Long mToplineId = null;
  @SerializedName("video_view_length_constraint")
  private Long mVideoViewLengthConstraint = null;
  @SerializedName("viewtag")
  private String mViewtag = null;
  protected static Gson gson = null;

  ReachFrequencyPrediction() {
  }

  public ReachFrequencyPrediction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyPrediction(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReachFrequencyPrediction fetch() throws APIException{
    ReachFrequencyPrediction newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyPrediction fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReachFrequencyPrediction> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReachFrequencyPrediction fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReachFrequencyPrediction> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReachFrequencyPrediction> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyPrediction>)(
      new APIRequest<ReachFrequencyPrediction>(context, "", "/", "GET", ReachFrequencyPrediction.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReachFrequencyPrediction>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReachFrequencyPrediction.getParser())
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
  public static ReachFrequencyPrediction loadJSON(String json, APIContext context, String header) {
    ReachFrequencyPrediction reachFrequencyPrediction = getGson().fromJson(json, ReachFrequencyPrediction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyPrediction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    reachFrequencyPrediction.context = context;
    reachFrequencyPrediction.rawValue = json;
    reachFrequencyPrediction.header = header;
    return reachFrequencyPrediction;
  }

  public static APINodeList<ReachFrequencyPrediction> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ReachFrequencyPrediction> reachFrequencyPredictions = new APINodeList<ReachFrequencyPrediction>(request, json, header);
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
          reachFrequencyPredictions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return reachFrequencyPredictions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyPredictions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyPredictions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyPredictions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyPredictions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  reachFrequencyPredictions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyPredictions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return reachFrequencyPredictions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyPredictions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return reachFrequencyPredictions;
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
              reachFrequencyPredictions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyPredictions;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyPredictions.clear();
          reachFrequencyPredictions.add(loadJSON(json, context, header));
          return reachFrequencyPredictions;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldAccountId() {
    return mAccountId;
  }

  public ReachFrequencyActivity getFieldActivityStatus() {
    return mActivityStatus;
  }

  public List<ReachFrequencyAdFormat> getFieldAdFormats() {
    return mAdFormats;
  }

  public Long getFieldAuctionEntryOptionIndex() {
    return mAuctionEntryOptionIndex;
  }

  public Long getFieldAudienceSizeLowerBound() {
    return mAudienceSizeLowerBound;
  }

  public Long getFieldAudienceSizeUpperBound() {
    return mAudienceSizeUpperBound;
  }

  public Long getFieldBusinessId() {
    return mBusinessId;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public Long getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignTimeStart() {
    return mCampaignTimeStart;
  }

  public String getFieldCampaignTimeStop() {
    return mCampaignTimeStop;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public ReachFrequencyEstimatesCurve getFieldCurveBudgetReach() {
    return mCurveBudgetReach;
  }

  public List<Long> getFieldCurveReach() {
    return mCurveReach;
  }

  public List<Double> getFieldDailyGrpCurve() {
    return mDailyGrpCurve;
  }

  public List<Double> getFieldDailyImpressionCurve() {
    return mDailyImpressionCurve;
  }

  public List<Map<Long, List<Double>>> getFieldDailyImpressionCurveMap() {
    return mDailyImpressionCurveMap;
  }

  public List<ReachFrequencyDayPart> getFieldDayPartingSchedule() {
    return mDayPartingSchedule;
  }

  public String getFieldDestinationId() {
    return mDestinationId;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public Long getFieldExternalBudget() {
    return mExternalBudget;
  }

  public Long getFieldExternalImpression() {
    return mExternalImpression;
  }

  public Long getFieldExternalMaximumBudget() {
    return mExternalMaximumBudget;
  }

  public String getFieldExternalMaximumImpression() {
    return mExternalMaximumImpression;
  }

  public Long getFieldExternalMaximumReach() {
    return mExternalMaximumReach;
  }

  public Long getFieldExternalMinimumBudget() {
    return mExternalMinimumBudget;
  }

  public Long getFieldExternalMinimumImpression() {
    return mExternalMinimumImpression;
  }

  public Long getFieldExternalMinimumReach() {
    return mExternalMinimumReach;
  }

  public Long getFieldExternalReach() {
    return mExternalReach;
  }

  public Long getFieldFeedRatio0000() {
    return mFeedRatio0000;
  }

  public Long getFieldFrequencyCap() {
    return mFrequencyCap;
  }

  public List<Map<Long, List<Double>>> getFieldFrequencyDistributionMap() {
    return mFrequencyDistributionMap;
  }

  public List<Map<Long, List<Long>>> getFieldFrequencyDistributionMapAgg() {
    return mFrequencyDistributionMapAgg;
  }

  public Double getFieldGrpAudienceSize() {
    return mGrpAudienceSize;
  }

  public String getFieldGrpAvgProbabilityMap() {
    return mGrpAvgProbabilityMap;
  }

  public Double getFieldGrpCountryAudienceSize() {
    return mGrpCountryAudienceSize;
  }

  public List<Double> getFieldGrpCurve() {
    return mGrpCurve;
  }

  public Double getFieldGrpDmasAudienceSize() {
    return mGrpDmasAudienceSize;
  }

  public Long getFieldGrpFilteringThreshold00() {
    return mGrpFilteringThreshold00;
  }

  public Double getFieldGrpPoints() {
    return mGrpPoints;
  }

  public Double getFieldGrpRatio() {
    return mGrpRatio;
  }

  public Double getFieldGrpReachRatio() {
    return mGrpReachRatio;
  }

  public String getFieldGrpStatus() {
    return mGrpStatus;
  }

  public Long getFieldHoldoutPercentage() {
    return mHoldoutPercentage;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Long> getFieldImpressionCurve() {
    return mImpressionCurve;
  }

  public String getFieldInstagramDestinationId() {
    return mInstagramDestinationId;
  }

  public List<String> getFieldInstreamPackages() {
    return mInstreamPackages;
  }

  public Long getFieldIntervalFrequencyCap() {
    return mIntervalFrequencyCap;
  }

  public Long getFieldIntervalFrequencyCapResetPeriod() {
    return mIntervalFrequencyCapResetPeriod;
  }

  public Long getFieldIsBonusMedia() {
    return mIsBonusMedia;
  }

  public Long getFieldIsConversionGoal() {
    return mIsConversionGoal;
  }

  public Boolean getFieldIsHigherAverageFrequency() {
    return mIsHigherAverageFrequency;
  }

  public Boolean getFieldIsIo() {
    return mIsIo;
  }

  public Long getFieldIsReservedBuying() {
    return mIsReservedBuying;
  }

  public Boolean getFieldIsTrp() {
    return mIsTrp;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldObjective() {
    return mObjective;
  }

  public String getFieldObjectiveName() {
    return mObjectiveName;
  }

  public Long getFieldOdaxObjective() {
    return mOdaxObjective;
  }

  public String getFieldOdaxObjectiveName() {
    return mOdaxObjectiveName;
  }

  public Long getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public String getFieldOptimizationGoalName() {
    return mOptimizationGoalName;
  }

  public List<Object> getFieldPausePeriods() {
    return mPausePeriods;
  }

  public ReachFrequencyEstimatesPlacementBreakdown getFieldPlacementBreakdown() {
    return mPlacementBreakdown;
  }

  public List<Map<Long, ReachFrequencyEstimatesPlacementBreakdown>> getFieldPlacementBreakdownMap() {
    return mPlacementBreakdownMap;
  }

  public String getFieldPlanName() {
    return mPlanName;
  }

  public String getFieldPlanType() {
    return mPlanType;
  }

  public Long getFieldPredictionMode() {
    return mPredictionMode;
  }

  public Long getFieldPredictionProgress() {
    return mPredictionProgress;
  }

  public String getFieldReferenceId() {
    return mReferenceId;
  }

  public Long getFieldReservationStatus() {
    return mReservationStatus;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public Long getFieldStatus() {
    return mStatus;
  }

  public Long getFieldStoryEventType() {
    return mStoryEventType;
  }

  public Long getFieldTargetCpm() {
    return mTargetCpm;
  }

  public Targeting getFieldTargetSpec() {
    return mTargetSpec;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }

  public Long getFieldTimezoneId() {
    return mTimezoneId;
  }

  public String getFieldTimezoneName() {
    return mTimezoneName;
  }

  public Long getFieldToplineId() {
    return mToplineId;
  }

  public Long getFieldVideoViewLengthConstraint() {
    return mVideoViewLengthConstraint;
  }

  public String getFieldViewtag() {
    return mViewtag;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyPrediction> {

    ReachFrequencyPrediction lastResponse = null;
    @Override
    public ReachFrequencyPrediction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "activity_status",
      "ad_formats",
      "auction_entry_option_index",
      "audience_size_lower_bound",
      "audience_size_upper_bound",
      "business_id",
      "buying_type",
      "campaign_group_id",
      "campaign_id",
      "campaign_time_start",
      "campaign_time_stop",
      "currency",
      "curve_budget_reach",
      "curve_reach",
      "daily_grp_curve",
      "daily_impression_curve",
      "daily_impression_curve_map",
      "day_parting_schedule",
      "destination_id",
      "end_time",
      "expiration_time",
      "external_budget",
      "external_impression",
      "external_maximum_budget",
      "external_maximum_impression",
      "external_maximum_reach",
      "external_minimum_budget",
      "external_minimum_impression",
      "external_minimum_reach",
      "external_reach",
      "feed_ratio_0000",
      "frequency_cap",
      "frequency_distribution_map",
      "frequency_distribution_map_agg",
      "grp_audience_size",
      "grp_avg_probability_map",
      "grp_country_audience_size",
      "grp_curve",
      "grp_dmas_audience_size",
      "grp_filtering_threshold_00",
      "grp_points",
      "grp_ratio",
      "grp_reach_ratio",
      "grp_status",
      "holdout_percentage",
      "id",
      "impression_curve",
      "instagram_destination_id",
      "instream_packages",
      "interval_frequency_cap",
      "interval_frequency_cap_reset_period",
      "is_bonus_media",
      "is_conversion_goal",
      "is_higher_average_frequency",
      "is_io",
      "is_reserved_buying",
      "is_trp",
      "name",
      "objective",
      "objective_name",
      "odax_objective",
      "odax_objective_name",
      "optimization_goal",
      "optimization_goal_name",
      "pause_periods",
      "placement_breakdown",
      "placement_breakdown_map",
      "plan_name",
      "plan_type",
      "prediction_mode",
      "prediction_progress",
      "reference_id",
      "reservation_status",
      "start_time",
      "status",
      "story_event_type",
      "target_cpm",
      "target_spec",
      "time_created",
      "time_updated",
      "timezone_id",
      "timezone_name",
      "topline_id",
      "video_view_length_constraint",
      "viewtag",
    };

    @Override
    public ReachFrequencyPrediction parseResponse(String response, String header) throws APIException {
      return ReachFrequencyPrediction.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ReachFrequencyPrediction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyPrediction execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyPrediction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyPrediction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ReachFrequencyPrediction>() {
           public ReachFrequencyPrediction apply(ResponseWrapper result) {
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
    public APIRequestGet requestActivityStatusField () {
      return this.requestActivityStatusField(true);
    }
    public APIRequestGet requestActivityStatusField (boolean value) {
      this.requestField("activity_status", value);
      return this;
    }
    public APIRequestGet requestAdFormatsField () {
      return this.requestAdFormatsField(true);
    }
    public APIRequestGet requestAdFormatsField (boolean value) {
      this.requestField("ad_formats", value);
      return this;
    }
    public APIRequestGet requestAuctionEntryOptionIndexField () {
      return this.requestAuctionEntryOptionIndexField(true);
    }
    public APIRequestGet requestAuctionEntryOptionIndexField (boolean value) {
      this.requestField("auction_entry_option_index", value);
      return this;
    }
    public APIRequestGet requestAudienceSizeLowerBoundField () {
      return this.requestAudienceSizeLowerBoundField(true);
    }
    public APIRequestGet requestAudienceSizeLowerBoundField (boolean value) {
      this.requestField("audience_size_lower_bound", value);
      return this;
    }
    public APIRequestGet requestAudienceSizeUpperBoundField () {
      return this.requestAudienceSizeUpperBoundField(true);
    }
    public APIRequestGet requestAudienceSizeUpperBoundField (boolean value) {
      this.requestField("audience_size_upper_bound", value);
      return this;
    }
    public APIRequestGet requestBusinessIdField () {
      return this.requestBusinessIdField(true);
    }
    public APIRequestGet requestBusinessIdField (boolean value) {
      this.requestField("business_id", value);
      return this;
    }
    public APIRequestGet requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGet requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGet requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGet requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGet requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGet requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGet requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGet requestCurveReachField () {
      return this.requestCurveReachField(true);
    }
    public APIRequestGet requestCurveReachField (boolean value) {
      this.requestField("curve_reach", value);
      return this;
    }
    public APIRequestGet requestDailyGrpCurveField () {
      return this.requestDailyGrpCurveField(true);
    }
    public APIRequestGet requestDailyGrpCurveField (boolean value) {
      this.requestField("daily_grp_curve", value);
      return this;
    }
    public APIRequestGet requestDailyImpressionCurveField () {
      return this.requestDailyImpressionCurveField(true);
    }
    public APIRequestGet requestDailyImpressionCurveField (boolean value) {
      this.requestField("daily_impression_curve", value);
      return this;
    }
    public APIRequestGet requestDailyImpressionCurveMapField () {
      return this.requestDailyImpressionCurveMapField(true);
    }
    public APIRequestGet requestDailyImpressionCurveMapField (boolean value) {
      this.requestField("daily_impression_curve_map", value);
      return this;
    }
    public APIRequestGet requestDayPartingScheduleField () {
      return this.requestDayPartingScheduleField(true);
    }
    public APIRequestGet requestDayPartingScheduleField (boolean value) {
      this.requestField("day_parting_schedule", value);
      return this;
    }
    public APIRequestGet requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGet requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGet requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGet requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGet requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGet requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGet requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGet requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGet requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGet requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGet requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGet requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGet requestFeedRatio0000Field () {
      return this.requestFeedRatio0000Field(true);
    }
    public APIRequestGet requestFeedRatio0000Field (boolean value) {
      this.requestField("feed_ratio_0000", value);
      return this;
    }
    public APIRequestGet requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGet requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGet requestFrequencyDistributionMapField () {
      return this.requestFrequencyDistributionMapField(true);
    }
    public APIRequestGet requestFrequencyDistributionMapField (boolean value) {
      this.requestField("frequency_distribution_map", value);
      return this;
    }
    public APIRequestGet requestFrequencyDistributionMapAggField () {
      return this.requestFrequencyDistributionMapAggField(true);
    }
    public APIRequestGet requestFrequencyDistributionMapAggField (boolean value) {
      this.requestField("frequency_distribution_map_agg", value);
      return this;
    }
    public APIRequestGet requestGrpAudienceSizeField () {
      return this.requestGrpAudienceSizeField(true);
    }
    public APIRequestGet requestGrpAudienceSizeField (boolean value) {
      this.requestField("grp_audience_size", value);
      return this;
    }
    public APIRequestGet requestGrpAvgProbabilityMapField () {
      return this.requestGrpAvgProbabilityMapField(true);
    }
    public APIRequestGet requestGrpAvgProbabilityMapField (boolean value) {
      this.requestField("grp_avg_probability_map", value);
      return this;
    }
    public APIRequestGet requestGrpCountryAudienceSizeField () {
      return this.requestGrpCountryAudienceSizeField(true);
    }
    public APIRequestGet requestGrpCountryAudienceSizeField (boolean value) {
      this.requestField("grp_country_audience_size", value);
      return this;
    }
    public APIRequestGet requestGrpCurveField () {
      return this.requestGrpCurveField(true);
    }
    public APIRequestGet requestGrpCurveField (boolean value) {
      this.requestField("grp_curve", value);
      return this;
    }
    public APIRequestGet requestGrpDmasAudienceSizeField () {
      return this.requestGrpDmasAudienceSizeField(true);
    }
    public APIRequestGet requestGrpDmasAudienceSizeField (boolean value) {
      this.requestField("grp_dmas_audience_size", value);
      return this;
    }
    public APIRequestGet requestGrpFilteringThreshold00Field () {
      return this.requestGrpFilteringThreshold00Field(true);
    }
    public APIRequestGet requestGrpFilteringThreshold00Field (boolean value) {
      this.requestField("grp_filtering_threshold_00", value);
      return this;
    }
    public APIRequestGet requestGrpPointsField () {
      return this.requestGrpPointsField(true);
    }
    public APIRequestGet requestGrpPointsField (boolean value) {
      this.requestField("grp_points", value);
      return this;
    }
    public APIRequestGet requestGrpRatioField () {
      return this.requestGrpRatioField(true);
    }
    public APIRequestGet requestGrpRatioField (boolean value) {
      this.requestField("grp_ratio", value);
      return this;
    }
    public APIRequestGet requestGrpReachRatioField () {
      return this.requestGrpReachRatioField(true);
    }
    public APIRequestGet requestGrpReachRatioField (boolean value) {
      this.requestField("grp_reach_ratio", value);
      return this;
    }
    public APIRequestGet requestGrpStatusField () {
      return this.requestGrpStatusField(true);
    }
    public APIRequestGet requestGrpStatusField (boolean value) {
      this.requestField("grp_status", value);
      return this;
    }
    public APIRequestGet requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGet requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImpressionCurveField () {
      return this.requestImpressionCurveField(true);
    }
    public APIRequestGet requestImpressionCurveField (boolean value) {
      this.requestField("impression_curve", value);
      return this;
    }
    public APIRequestGet requestInstagramDestinationIdField () {
      return this.requestInstagramDestinationIdField(true);
    }
    public APIRequestGet requestInstagramDestinationIdField (boolean value) {
      this.requestField("instagram_destination_id", value);
      return this;
    }
    public APIRequestGet requestInstreamPackagesField () {
      return this.requestInstreamPackagesField(true);
    }
    public APIRequestGet requestInstreamPackagesField (boolean value) {
      this.requestField("instream_packages", value);
      return this;
    }
    public APIRequestGet requestIntervalFrequencyCapField () {
      return this.requestIntervalFrequencyCapField(true);
    }
    public APIRequestGet requestIntervalFrequencyCapField (boolean value) {
      this.requestField("interval_frequency_cap", value);
      return this;
    }
    public APIRequestGet requestIntervalFrequencyCapResetPeriodField () {
      return this.requestIntervalFrequencyCapResetPeriodField(true);
    }
    public APIRequestGet requestIntervalFrequencyCapResetPeriodField (boolean value) {
      this.requestField("interval_frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGet requestIsBonusMediaField () {
      return this.requestIsBonusMediaField(true);
    }
    public APIRequestGet requestIsBonusMediaField (boolean value) {
      this.requestField("is_bonus_media", value);
      return this;
    }
    public APIRequestGet requestIsConversionGoalField () {
      return this.requestIsConversionGoalField(true);
    }
    public APIRequestGet requestIsConversionGoalField (boolean value) {
      this.requestField("is_conversion_goal", value);
      return this;
    }
    public APIRequestGet requestIsHigherAverageFrequencyField () {
      return this.requestIsHigherAverageFrequencyField(true);
    }
    public APIRequestGet requestIsHigherAverageFrequencyField (boolean value) {
      this.requestField("is_higher_average_frequency", value);
      return this;
    }
    public APIRequestGet requestIsIoField () {
      return this.requestIsIoField(true);
    }
    public APIRequestGet requestIsIoField (boolean value) {
      this.requestField("is_io", value);
      return this;
    }
    public APIRequestGet requestIsReservedBuyingField () {
      return this.requestIsReservedBuyingField(true);
    }
    public APIRequestGet requestIsReservedBuyingField (boolean value) {
      this.requestField("is_reserved_buying", value);
      return this;
    }
    public APIRequestGet requestIsTrpField () {
      return this.requestIsTrpField(true);
    }
    public APIRequestGet requestIsTrpField (boolean value) {
      this.requestField("is_trp", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGet requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGet requestObjectiveNameField () {
      return this.requestObjectiveNameField(true);
    }
    public APIRequestGet requestObjectiveNameField (boolean value) {
      this.requestField("objective_name", value);
      return this;
    }
    public APIRequestGet requestOdaxObjectiveField () {
      return this.requestOdaxObjectiveField(true);
    }
    public APIRequestGet requestOdaxObjectiveField (boolean value) {
      this.requestField("odax_objective", value);
      return this;
    }
    public APIRequestGet requestOdaxObjectiveNameField () {
      return this.requestOdaxObjectiveNameField(true);
    }
    public APIRequestGet requestOdaxObjectiveNameField (boolean value) {
      this.requestField("odax_objective_name", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGet requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalNameField () {
      return this.requestOptimizationGoalNameField(true);
    }
    public APIRequestGet requestOptimizationGoalNameField (boolean value) {
      this.requestField("optimization_goal_name", value);
      return this;
    }
    public APIRequestGet requestPausePeriodsField () {
      return this.requestPausePeriodsField(true);
    }
    public APIRequestGet requestPausePeriodsField (boolean value) {
      this.requestField("pause_periods", value);
      return this;
    }
    public APIRequestGet requestPlacementBreakdownField () {
      return this.requestPlacementBreakdownField(true);
    }
    public APIRequestGet requestPlacementBreakdownField (boolean value) {
      this.requestField("placement_breakdown", value);
      return this;
    }
    public APIRequestGet requestPlacementBreakdownMapField () {
      return this.requestPlacementBreakdownMapField(true);
    }
    public APIRequestGet requestPlacementBreakdownMapField (boolean value) {
      this.requestField("placement_breakdown_map", value);
      return this;
    }
    public APIRequestGet requestPlanNameField () {
      return this.requestPlanNameField(true);
    }
    public APIRequestGet requestPlanNameField (boolean value) {
      this.requestField("plan_name", value);
      return this;
    }
    public APIRequestGet requestPlanTypeField () {
      return this.requestPlanTypeField(true);
    }
    public APIRequestGet requestPlanTypeField (boolean value) {
      this.requestField("plan_type", value);
      return this;
    }
    public APIRequestGet requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGet requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGet requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGet requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGet requestReferenceIdField () {
      return this.requestReferenceIdField(true);
    }
    public APIRequestGet requestReferenceIdField (boolean value) {
      this.requestField("reference_id", value);
      return this;
    }
    public APIRequestGet requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGet requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
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
    public APIRequestGet requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGet requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGet requestTargetCpmField () {
      return this.requestTargetCpmField(true);
    }
    public APIRequestGet requestTargetCpmField (boolean value) {
      this.requestField("target_cpm", value);
      return this;
    }
    public APIRequestGet requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGet requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGet requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGet requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGet requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGet requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGet requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGet requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGet requestVideoViewLengthConstraintField () {
      return this.requestVideoViewLengthConstraintField(true);
    }
    public APIRequestGet requestVideoViewLengthConstraintField (boolean value) {
      this.requestField("video_view_length_constraint", value);
      return this;
    }
    public APIRequestGet requestViewtagField () {
      return this.requestViewtagField(true);
    }
    public APIRequestGet requestViewtagField (boolean value) {
      this.requestField("viewtag", value);
      return this;
    }
  }

  public static enum EnumAction {
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      @SerializedName("quote")
      VALUE_QUOTE("quote"),
      @SerializedName("reserve")
      VALUE_RESERVE("reserve"),
      ;

      private String value;

      private EnumAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBuyingType {
      @SerializedName("AUCTION")
      VALUE_AUCTION("AUCTION"),
      @SerializedName("DEPRECATED_REACH_BLOCK")
      VALUE_DEPRECATED_REACH_BLOCK("DEPRECATED_REACH_BLOCK"),
      @SerializedName("FIXED_CPM")
      VALUE_FIXED_CPM("FIXED_CPM"),
      @SerializedName("MIXED")
      VALUE_MIXED("MIXED"),
      @SerializedName("REACHBLOCK")
      VALUE_REACHBLOCK("REACHBLOCK"),
      @SerializedName("RESEARCH_POLL")
      VALUE_RESEARCH_POLL("RESEARCH_POLL"),
      @SerializedName("RESERVED")
      VALUE_RESERVED("RESERVED"),
      ;

      private String value;

      private EnumBuyingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumInstreamPackages {
      @SerializedName("BEAUTY")
      VALUE_BEAUTY("BEAUTY"),
      @SerializedName("ENTERTAINMENT")
      VALUE_ENTERTAINMENT("ENTERTAINMENT"),
      @SerializedName("FOOD")
      VALUE_FOOD("FOOD"),
      @SerializedName("NORMAL")
      VALUE_NORMAL("NORMAL"),
      @SerializedName("PREMIUM")
      VALUE_PREMIUM("PREMIUM"),
      @SerializedName("REGULAR_ANIMALS_PETS")
      VALUE_REGULAR_ANIMALS_PETS("REGULAR_ANIMALS_PETS"),
      @SerializedName("REGULAR_FOOD")
      VALUE_REGULAR_FOOD("REGULAR_FOOD"),
      @SerializedName("REGULAR_GAMES")
      VALUE_REGULAR_GAMES("REGULAR_GAMES"),
      @SerializedName("REGULAR_POLITICS")
      VALUE_REGULAR_POLITICS("REGULAR_POLITICS"),
      @SerializedName("REGULAR_SPORTS")
      VALUE_REGULAR_SPORTS("REGULAR_SPORTS"),
      @SerializedName("REGULAR_STYLE")
      VALUE_REGULAR_STYLE("REGULAR_STYLE"),
      @SerializedName("REGULAR_TV_MOVIES")
      VALUE_REGULAR_TV_MOVIES("REGULAR_TV_MOVIES"),
      @SerializedName("SPANISH")
      VALUE_SPANISH("SPANISH"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      ;

      private String value;

      private EnumInstreamPackages(String value) {
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

  public ReachFrequencyPrediction copyFrom(ReachFrequencyPrediction instance) {
    this.mAccountId = instance.mAccountId;
    this.mActivityStatus = instance.mActivityStatus;
    this.mAdFormats = instance.mAdFormats;
    this.mAuctionEntryOptionIndex = instance.mAuctionEntryOptionIndex;
    this.mAudienceSizeLowerBound = instance.mAudienceSizeLowerBound;
    this.mAudienceSizeUpperBound = instance.mAudienceSizeUpperBound;
    this.mBusinessId = instance.mBusinessId;
    this.mBuyingType = instance.mBuyingType;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignTimeStart = instance.mCampaignTimeStart;
    this.mCampaignTimeStop = instance.mCampaignTimeStop;
    this.mCurrency = instance.mCurrency;
    this.mCurveBudgetReach = instance.mCurveBudgetReach;
    this.mCurveReach = instance.mCurveReach;
    this.mDailyGrpCurve = instance.mDailyGrpCurve;
    this.mDailyImpressionCurve = instance.mDailyImpressionCurve;
    this.mDailyImpressionCurveMap = instance.mDailyImpressionCurveMap;
    this.mDayPartingSchedule = instance.mDayPartingSchedule;
    this.mDestinationId = instance.mDestinationId;
    this.mEndTime = instance.mEndTime;
    this.mExpirationTime = instance.mExpirationTime;
    this.mExternalBudget = instance.mExternalBudget;
    this.mExternalImpression = instance.mExternalImpression;
    this.mExternalMaximumBudget = instance.mExternalMaximumBudget;
    this.mExternalMaximumImpression = instance.mExternalMaximumImpression;
    this.mExternalMaximumReach = instance.mExternalMaximumReach;
    this.mExternalMinimumBudget = instance.mExternalMinimumBudget;
    this.mExternalMinimumImpression = instance.mExternalMinimumImpression;
    this.mExternalMinimumReach = instance.mExternalMinimumReach;
    this.mExternalReach = instance.mExternalReach;
    this.mFeedRatio0000 = instance.mFeedRatio0000;
    this.mFrequencyCap = instance.mFrequencyCap;
    this.mFrequencyDistributionMap = instance.mFrequencyDistributionMap;
    this.mFrequencyDistributionMapAgg = instance.mFrequencyDistributionMapAgg;
    this.mGrpAudienceSize = instance.mGrpAudienceSize;
    this.mGrpAvgProbabilityMap = instance.mGrpAvgProbabilityMap;
    this.mGrpCountryAudienceSize = instance.mGrpCountryAudienceSize;
    this.mGrpCurve = instance.mGrpCurve;
    this.mGrpDmasAudienceSize = instance.mGrpDmasAudienceSize;
    this.mGrpFilteringThreshold00 = instance.mGrpFilteringThreshold00;
    this.mGrpPoints = instance.mGrpPoints;
    this.mGrpRatio = instance.mGrpRatio;
    this.mGrpReachRatio = instance.mGrpReachRatio;
    this.mGrpStatus = instance.mGrpStatus;
    this.mHoldoutPercentage = instance.mHoldoutPercentage;
    this.mId = instance.mId;
    this.mImpressionCurve = instance.mImpressionCurve;
    this.mInstagramDestinationId = instance.mInstagramDestinationId;
    this.mInstreamPackages = instance.mInstreamPackages;
    this.mIntervalFrequencyCap = instance.mIntervalFrequencyCap;
    this.mIntervalFrequencyCapResetPeriod = instance.mIntervalFrequencyCapResetPeriod;
    this.mIsBonusMedia = instance.mIsBonusMedia;
    this.mIsConversionGoal = instance.mIsConversionGoal;
    this.mIsHigherAverageFrequency = instance.mIsHigherAverageFrequency;
    this.mIsIo = instance.mIsIo;
    this.mIsReservedBuying = instance.mIsReservedBuying;
    this.mIsTrp = instance.mIsTrp;
    this.mName = instance.mName;
    this.mObjective = instance.mObjective;
    this.mObjectiveName = instance.mObjectiveName;
    this.mOdaxObjective = instance.mOdaxObjective;
    this.mOdaxObjectiveName = instance.mOdaxObjectiveName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mOptimizationGoalName = instance.mOptimizationGoalName;
    this.mPausePeriods = instance.mPausePeriods;
    this.mPlacementBreakdown = instance.mPlacementBreakdown;
    this.mPlacementBreakdownMap = instance.mPlacementBreakdownMap;
    this.mPlanName = instance.mPlanName;
    this.mPlanType = instance.mPlanType;
    this.mPredictionMode = instance.mPredictionMode;
    this.mPredictionProgress = instance.mPredictionProgress;
    this.mReferenceId = instance.mReferenceId;
    this.mReservationStatus = instance.mReservationStatus;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mStoryEventType = instance.mStoryEventType;
    this.mTargetCpm = instance.mTargetCpm;
    this.mTargetSpec = instance.mTargetSpec;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTimezoneName = instance.mTimezoneName;
    this.mToplineId = instance.mToplineId;
    this.mVideoViewLengthConstraint = instance.mVideoViewLengthConstraint;
    this.mViewtag = instance.mViewtag;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyPrediction> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyPrediction>() {
      public APINodeList<ReachFrequencyPrediction> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyPrediction> request, String header) throws MalformedResponseException {
        return ReachFrequencyPrediction.parseResponse(response, context, request, header);
      }
    };
  }
}
