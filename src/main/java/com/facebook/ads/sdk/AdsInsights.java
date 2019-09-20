/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
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
public class AdsInsights extends APINode {
  @SerializedName("account_currency")
  private String mAccountCurrency = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("action_values")
  private List<AdsActionStats> mActionValues = null;
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("actions_per_impression")
  private String mActionsPerImpression = null;
  @SerializedName("actions_results")
  private AdsActionStats mActionsResults = null;
  @SerializedName("activity_recency")
  private String mActivityRecency = null;
  @SerializedName("ad_bid_type")
  private String mAdBidType = null;
  @SerializedName("ad_bid_value")
  private String mAdBidValue = null;
  @SerializedName("ad_click_actions")
  private List<AdsActionStats> mAdClickActions = null;
  @SerializedName("ad_delivery")
  private String mAdDelivery = null;
  @SerializedName("ad_format_asset")
  private String mAdFormatAsset = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_impression_actions")
  private List<AdsActionStats> mAdImpressionActions = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_bid_type")
  private String mAdsetBidType = null;
  @SerializedName("adset_bid_value")
  private String mAdsetBidValue = null;
  @SerializedName("adset_budget_type")
  private String mAdsetBudgetType = null;
  @SerializedName("adset_budget_value")
  private String mAdsetBudgetValue = null;
  @SerializedName("adset_delivery")
  private String mAdsetDelivery = null;
  @SerializedName("adset_end")
  private String mAdsetEnd = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("adset_start")
  private String mAdsetStart = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("age_targeting")
  private String mAgeTargeting = null;
  @SerializedName("amount_in_catalog_currency")
  private List<AdsActionStats> mAmountInCatalogCurrency = null;
  @SerializedName("app_store_clicks")
  private String mAppStoreClicks = null;
  @SerializedName("attention_events_per_impression")
  private String mAttentionEventsPerImpression = null;
  @SerializedName("attention_events_unq_per_reach")
  private String mAttentionEventsUnqPerReach = null;
  @SerializedName("auction_bid")
  private String mAuctionBid = null;
  @SerializedName("auction_competitiveness")
  private String mAuctionCompetitiveness = null;
  @SerializedName("auction_max_competitor_bid")
  private String mAuctionMaxCompetitorBid = null;
  @SerializedName("body_asset")
  private Object mBodyAsset = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("call_to_action_asset")
  private Object mCallToActionAsset = null;
  @SerializedName("call_to_action_clicks")
  private String mCallToActionClicks = null;
  @SerializedName("campaign_delivery")
  private String mCampaignDelivery = null;
  @SerializedName("campaign_end")
  private String mCampaignEnd = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("campaign_start")
  private String mCampaignStart = null;
  @SerializedName("cancel_subscription_actions")
  private List<AdsActionStats> mCancelSubscriptionActions = null;
  @SerializedName("canvas_avg_view_percent")
  private String mCanvasAvgViewPercent = null;
  @SerializedName("canvas_avg_view_time")
  private String mCanvasAvgViewTime = null;
  @SerializedName("card_views")
  private String mCardViews = null;
  @SerializedName("catalog_segment_actions")
  private List<AdsActionStats> mCatalogSegmentActions = null;
  @SerializedName("catalog_segment_value_in_catalog_currency")
  private List<AdsActionStats> mCatalogSegmentValueInCatalogCurrency = null;
  @SerializedName("catalog_segment_value_mobile_purchase_roas")
  private List<AdsActionStats> mCatalogSegmentValueMobilePurchaseRoas = null;
  @SerializedName("catalog_segment_value_website_purchase_roas")
  private List<AdsActionStats> mCatalogSegmentValueWebsitePurchaseRoas = null;
  @SerializedName("clicks")
  private String mClicks = null;
  @SerializedName("conditional_time_spent_ms_over_10s_actions")
  private List<AdsActionStats> mConditionalTimeSpentMsOver10sActions = null;
  @SerializedName("conditional_time_spent_ms_over_15s_actions")
  private List<AdsActionStats> mConditionalTimeSpentMsOver15sActions = null;
  @SerializedName("conditional_time_spent_ms_over_2s_actions")
  private List<AdsActionStats> mConditionalTimeSpentMsOver2sActions = null;
  @SerializedName("conditional_time_spent_ms_over_3s_actions")
  private List<AdsActionStats> mConditionalTimeSpentMsOver3sActions = null;
  @SerializedName("conditional_time_spent_ms_over_6s_actions")
  private List<AdsActionStats> mConditionalTimeSpentMsOver6sActions = null;
  @SerializedName("contact_actions")
  private List<AdsActionStats> mContactActions = null;
  @SerializedName("contact_value")
  private List<AdsActionStats> mContactValue = null;
  @SerializedName("conversion_rate_ranking")
  private String mConversionRateRanking = null;
  @SerializedName("conversion_values")
  private List<AdsActionStats> mConversionValues = null;
  @SerializedName("conversions")
  private List<AdsActionStats> mConversions = null;
  @SerializedName("cost_per_10_sec_video_view")
  private List<AdsActionStats> mCostPer10SecVideoView = null;
  @SerializedName("cost_per_15_sec_video_view")
  private List<AdsActionStats> mCostPer15SecVideoView = null;
  @SerializedName("cost_per_2_sec_continuous_video_view")
  private List<AdsActionStats> mCostPer2SecContinuousVideoView = null;
  @SerializedName("cost_per_action_result")
  private AdsActionStats mCostPerActionResult = null;
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_ad_click")
  private List<AdsActionStats> mCostPerAdClick = null;
  @SerializedName("cost_per_completed_video_view")
  private List<AdsActionStats> mCostPerCompletedVideoView = null;
  @SerializedName("cost_per_contact")
  private List<AdsActionStats> mCostPerContact = null;
  @SerializedName("cost_per_conversion")
  private List<AdsActionStats> mCostPerConversion = null;
  @SerializedName("cost_per_customize_product")
  private List<AdsActionStats> mCostPerCustomizeProduct = null;
  @SerializedName("cost_per_dda_countby_convs")
  private String mCostPerDdaCountbyConvs = null;
  @SerializedName("cost_per_donate")
  private List<AdsActionStats> mCostPerDonate = null;
  @SerializedName("cost_per_dwell")
  private String mCostPerDwell = null;
  @SerializedName("cost_per_dwell_3_sec")
  private String mCostPerDwell3Sec = null;
  @SerializedName("cost_per_dwell_5_sec")
  private String mCostPerDwell5Sec = null;
  @SerializedName("cost_per_dwell_7_sec")
  private String mCostPerDwell7Sec = null;
  @SerializedName("cost_per_estimated_ad_recallers")
  private String mCostPerEstimatedAdRecallers = null;
  @SerializedName("cost_per_find_location")
  private List<AdsActionStats> mCostPerFindLocation = null;
  @SerializedName("cost_per_inline_link_click")
  private String mCostPerInlineLinkClick = null;
  @SerializedName("cost_per_inline_post_engagement")
  private String mCostPerInlinePostEngagement = null;
  @SerializedName("cost_per_one_thousand_ad_impression")
  private List<AdsActionStats> mCostPerOneThousandAdImpression = null;
  @SerializedName("cost_per_outbound_click")
  private List<AdsActionStats> mCostPerOutboundClick = null;
  @SerializedName("cost_per_schedule")
  private List<AdsActionStats> mCostPerSchedule = null;
  @SerializedName("cost_per_start_trial")
  private List<AdsActionStats> mCostPerStartTrial = null;
  @SerializedName("cost_per_submit_application")
  private List<AdsActionStats> mCostPerSubmitApplication = null;
  @SerializedName("cost_per_subscribe")
  private List<AdsActionStats> mCostPerSubscribe = null;
  @SerializedName("cost_per_thruplay")
  private List<AdsActionStats> mCostPerThruplay = null;
  @SerializedName("cost_per_total_action")
  private String mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_action_type")
  private List<AdsActionStats> mCostPerUniqueActionType = null;
  @SerializedName("cost_per_unique_click")
  private String mCostPerUniqueClick = null;
  @SerializedName("cost_per_unique_conversion")
  private List<AdsActionStats> mCostPerUniqueConversion = null;
  @SerializedName("cost_per_unique_inline_link_click")
  private String mCostPerUniqueInlineLinkClick = null;
  @SerializedName("cost_per_unique_outbound_click")
  private List<AdsActionStats> mCostPerUniqueOutboundClick = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("cpc")
  private String mCpc = null;
  @SerializedName("cpm")
  private String mCpm = null;
  @SerializedName("cpp")
  private String mCpp = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative_fingerprint")
  private String mCreativeFingerprint = null;
  @SerializedName("ctr")
  private String mCtr = null;
  @SerializedName("customize_product_actions")
  private List<AdsActionStats> mCustomizeProductActions = null;
  @SerializedName("customize_product_value")
  private List<AdsActionStats> mCustomizeProductValue = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("dda_countby_convs")
  private String mDdaCountbyConvs = null;
  @SerializedName("deduping_1st_source_ratio")
  private String mDeduping1stSourceRatio = null;
  @SerializedName("deduping_2nd_source_ratio")
  private String mDeduping2ndSourceRatio = null;
  @SerializedName("deduping_3rd_source_ratio")
  private String mDeduping3rdSourceRatio = null;
  @SerializedName("deduping_ratio")
  private String mDedupingRatio = null;
  @SerializedName("deeplink_clicks")
  private String mDeeplinkClicks = null;
  @SerializedName("description_asset")
  private Object mDescriptionAsset = null;
  @SerializedName("device_platform")
  private String mDevicePlatform = null;
  @SerializedName("dma")
  private String mDma = null;
  @SerializedName("donate_actions")
  private List<AdsActionStats> mDonateActions = null;
  @SerializedName("donate_value")
  private List<AdsActionStats> mDonateValue = null;
  @SerializedName("dwell_3_sec")
  private String mDwell3Sec = null;
  @SerializedName("dwell_5_sec")
  private String mDwell5Sec = null;
  @SerializedName("dwell_7_sec")
  private String mDwell7Sec = null;
  @SerializedName("dwell_rate")
  private String mDwellRate = null;
  @SerializedName("earned_impression")
  private String mEarnedImpression = null;
  @SerializedName("engagement_rate_ranking")
  private String mEngagementRateRanking = null;
  @SerializedName("estimated_ad_recall_rate")
  private String mEstimatedAdRecallRate = null;
  @SerializedName("estimated_ad_recall_rate_lower_bound")
  private String mEstimatedAdRecallRateLowerBound = null;
  @SerializedName("estimated_ad_recall_rate_upper_bound")
  private String mEstimatedAdRecallRateUpperBound = null;
  @SerializedName("estimated_ad_recallers")
  private String mEstimatedAdRecallers = null;
  @SerializedName("estimated_ad_recallers_lower_bound")
  private String mEstimatedAdRecallersLowerBound = null;
  @SerializedName("estimated_ad_recallers_upper_bound")
  private String mEstimatedAdRecallersUpperBound = null;
  @SerializedName("find_location_actions")
  private List<AdsActionStats> mFindLocationActions = null;
  @SerializedName("find_location_value")
  private List<AdsActionStats> mFindLocationValue = null;
  @SerializedName("frequency")
  private String mFrequency = null;
  @SerializedName("frequency_value")
  private String mFrequencyValue = null;
  @SerializedName("full_view_impressions")
  private String mFullViewImpressions = null;
  @SerializedName("full_view_reach")
  private String mFullViewReach = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("gender_targeting")
  private String mGenderTargeting = null;
  @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
  private String mHourlyStatsAggregatedByAdvertiserTimeZone = null;
  @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
  private String mHourlyStatsAggregatedByAudienceTimeZone = null;
  @SerializedName("image_asset")
  private Object mImageAsset = null;
  @SerializedName("impression_device")
  private String mImpressionDevice = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("impressions_auto_refresh")
  private String mImpressionsAutoRefresh = null;
  @SerializedName("impressions_gross")
  private String mImpressionsGross = null;
  @SerializedName("inline_link_click_ctr")
  private String mInlineLinkClickCtr = null;
  @SerializedName("inline_link_clicks")
  private String mInlineLinkClicks = null;
  @SerializedName("inline_post_engagement")
  private String mInlinePostEngagement = null;
  @SerializedName("instant_experience_clicks_to_open")
  private String mInstantExperienceClicksToOpen = null;
  @SerializedName("instant_experience_clicks_to_start")
  private String mInstantExperienceClicksToStart = null;
  @SerializedName("instant_experience_outbound_clicks")
  private String mInstantExperienceOutboundClicks = null;
  @SerializedName("interactive_component_tap")
  private List<AdsActionStats> mInteractiveComponentTap = null;
  @SerializedName("labels")
  private String mLabels = null;
  @SerializedName("link_url_asset")
  private Object mLinkUrlAsset = null;
  @SerializedName("location")
  private String mLocation = null;
  @SerializedName("media_asset")
  private Object mMediaAsset = null;
  @SerializedName("mobile_app_purchase_roas")
  private List<AdsActionStats> mMobileAppPurchaseRoas = null;
  @SerializedName("newsfeed_avg_position")
  private String mNewsfeedAvgPosition = null;
  @SerializedName("newsfeed_clicks")
  private String mNewsfeedClicks = null;
  @SerializedName("newsfeed_impressions")
  private String mNewsfeedImpressions = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("optimization_goal")
  private String mOptimizationGoal = null;
  @SerializedName("outbound_clicks")
  private List<AdsActionStats> mOutboundClicks = null;
  @SerializedName("outbound_clicks_ctr")
  private List<AdsActionStats> mOutboundClicksCtr = null;
  @SerializedName("performance_indicator")
  private String mPerformanceIndicator = null;
  @SerializedName("place_page_id")
  private String mPlacePageId = null;
  @SerializedName("place_page_name")
  private String mPlacePageName = null;
  @SerializedName("placement")
  private String mPlacement = null;
  @SerializedName("platform_position")
  private String mPlatformPosition = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("publisher_platform")
  private String mPublisherPlatform = null;
  @SerializedName("purchase_roas")
  private List<AdsActionStats> mPurchaseRoas = null;
  @SerializedName("quality_ranking")
  private String mQualityRanking = null;
  @SerializedName("quality_score_ectr")
  private String mQualityScoreEctr = null;
  @SerializedName("quality_score_ecvr")
  private String mQualityScoreEcvr = null;
  @SerializedName("quality_score_enfbr")
  private String mQualityScoreEnfbr = null;
  @SerializedName("quality_score_organic")
  private String mQualityScoreOrganic = null;
  @SerializedName("reach")
  private String mReach = null;
  @SerializedName("recurring_subscription_payment_actions")
  private List<AdsActionStats> mRecurringSubscriptionPaymentActions = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("relevance_score")
  private AdgroupRelevanceScore mRelevanceScore = null;
  @SerializedName("rule_asset")
  private Object mRuleAsset = null;
  @SerializedName("schedule_actions")
  private List<AdsActionStats> mScheduleActions = null;
  @SerializedName("schedule_value")
  private List<AdsActionStats> mScheduleValue = null;
  @SerializedName("social_spend")
  private String mSocialSpend = null;
  @SerializedName("spend")
  private String mSpend = null;
  @SerializedName("start_trial_actions")
  private List<AdsActionStats> mStartTrialActions = null;
  @SerializedName("start_trial_value")
  private List<AdsActionStats> mStartTrialValue = null;
  @SerializedName("submit_application_actions")
  private List<AdsActionStats> mSubmitApplicationActions = null;
  @SerializedName("submit_application_value")
  private List<AdsActionStats> mSubmitApplicationValue = null;
  @SerializedName("subscribe_actions")
  private List<AdsActionStats> mSubscribeActions = null;
  @SerializedName("subscribe_value")
  private List<AdsActionStats> mSubscribeValue = null;
  @SerializedName("thumb_stops")
  private String mThumbStops = null;
  @SerializedName("title_asset")
  private Object mTitleAsset = null;
  @SerializedName("today_spend")
  private String mTodaySpend = null;
  @SerializedName("total_action_value")
  private String mTotalActionValue = null;
  @SerializedName("total_actions")
  private String mTotalActions = null;
  @SerializedName("total_unique_actions")
  private String mTotalUniqueActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private String mUniqueClicks = null;
  @SerializedName("unique_conversions")
  private List<AdsActionStats> mUniqueConversions = null;
  @SerializedName("unique_ctr")
  private String mUniqueCtr = null;
  @SerializedName("unique_impressions")
  private String mUniqueImpressions = null;
  @SerializedName("unique_inline_link_click_ctr")
  private String mUniqueInlineLinkClickCtr = null;
  @SerializedName("unique_inline_link_clicks")
  private String mUniqueInlineLinkClicks = null;
  @SerializedName("unique_link_clicks_ctr")
  private String mUniqueLinkClicksCtr = null;
  @SerializedName("unique_outbound_clicks")
  private List<AdsActionStats> mUniqueOutboundClicks = null;
  @SerializedName("unique_outbound_clicks_ctr")
  private List<AdsActionStats> mUniqueOutboundClicksCtr = null;
  @SerializedName("unique_video_continuous_2_sec_watched_actions")
  private List<AdsActionStats> mUniqueVideoContinuous2SecWatchedActions = null;
  @SerializedName("unique_video_view_10_sec")
  private List<AdsActionStats> mUniqueVideoView10Sec = null;
  @SerializedName("unique_video_view_15_sec")
  private List<AdsActionStats> mUniqueVideoView15Sec = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("video_10_sec_watched_actions")
  private List<AdsActionStats> mVideo10SecWatchedActions = null;
  @SerializedName("video_15_sec_watched_actions")
  private List<AdsActionStats> mVideo15SecWatchedActions = null;
  @SerializedName("video_30_sec_watched_actions")
  private List<AdsActionStats> mVideo30SecWatchedActions = null;
  @SerializedName("video_asset")
  private Object mVideoAsset = null;
  @SerializedName("video_avg_time_watched_actions")
  private List<AdsActionStats> mVideoAvgTimeWatchedActions = null;
  @SerializedName("video_complete_watched_actions")
  private List<AdsActionStats> mVideoCompleteWatchedActions = null;
  @SerializedName("video_completed_view_or_15s_passed_actions")
  private List<AdsActionStats> mVideoCompletedViewOr15sPassedActions = null;
  @SerializedName("video_continuous_2_sec_watched_actions")
  private List<AdsActionStats> mVideoContinuous2SecWatchedActions = null;
  @SerializedName("video_p100_watched_actions")
  private List<AdsActionStats> mVideoP100WatchedActions = null;
  @SerializedName("video_p25_watched_actions")
  private List<AdsActionStats> mVideoP25WatchedActions = null;
  @SerializedName("video_p50_watched_actions")
  private List<AdsActionStats> mVideoP50WatchedActions = null;
  @SerializedName("video_p75_watched_actions")
  private List<AdsActionStats> mVideoP75WatchedActions = null;
  @SerializedName("video_p95_watched_actions")
  private List<AdsActionStats> mVideoP95WatchedActions = null;
  @SerializedName("video_play_actions")
  private List<AdsActionStats> mVideoPlayActions = null;
  @SerializedName("video_play_curve_actions")
  private List<Object> mVideoPlayCurveActions = null;
  @SerializedName("video_play_retention_0_to_15s_actions")
  private List<Object> mVideoPlayRetention0To15sActions = null;
  @SerializedName("video_play_retention_20_to_60s_actions")
  private List<Object> mVideoPlayRetention20To60sActions = null;
  @SerializedName("video_play_retention_graph_actions")
  private List<Object> mVideoPlayRetentionGraphActions = null;
  @SerializedName("video_thruplay_watched_actions")
  private List<AdsActionStats> mVideoThruplayWatchedActions = null;
  @SerializedName("video_time_watched_actions")
  private List<AdsActionStats> mVideoTimeWatchedActions = null;
  @SerializedName("website_clicks")
  private String mWebsiteClicks = null;
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  @SerializedName("website_purchase_roas")
  private List<AdsActionStats> mWebsitePurchaseRoas = null;
  @SerializedName("wish_bid")
  private String mWishBid = null;
  protected static Gson gson = null;

  public AdsInsights() {
  }

  public String getId() {
    return null;
  }
  public static AdsInsights loadJSON(String json, APIContext context, String header) {
    AdsInsights adsInsights = getGson().fromJson(json, AdsInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsInsights.context = context;
    adsInsights.rawValue = json;
    adsInsights.header = header;
    return adsInsights;
  }

  public static APINodeList<AdsInsights> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsInsights> adsInsightss = new APINodeList<AdsInsights>(request, json, header);
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
          adsInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsInsightss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsInsightss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsInsightss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsInsightss;
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
              adsInsightss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsInsightss;
          }

          // Sixth, check if it's pure JsonObject
          adsInsightss.clear();
          adsInsightss.add(loadJSON(json, context, header));
          return adsInsightss;
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


  public String getFieldAccountCurrency() {
    return mAccountCurrency;
  }

  public AdsInsights setFieldAccountCurrency(String value) {
    this.mAccountCurrency = value;
    return this;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdsInsights setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public AdsInsights setFieldAccountName(String value) {
    this.mAccountName = value;
    return this;
  }

  public List<AdsActionStats> getFieldActionValues() {
    return mActionValues;
  }

  public AdsInsights setFieldActionValues(List<AdsActionStats> value) {
    this.mActionValues = value;
    return this;
  }

  public AdsInsights setFieldActionValues(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mActionValues = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldActions() {
    return mActions;
  }

  public AdsInsights setFieldActions(List<AdsActionStats> value) {
    this.mActions = value;
    return this;
  }

  public AdsInsights setFieldActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldActionsPerImpression() {
    return mActionsPerImpression;
  }

  public AdsInsights setFieldActionsPerImpression(String value) {
    this.mActionsPerImpression = value;
    return this;
  }

  public AdsActionStats getFieldActionsResults() {
    return mActionsResults;
  }

  public AdsInsights setFieldActionsResults(AdsActionStats value) {
    this.mActionsResults = value;
    return this;
  }

  public AdsInsights setFieldActionsResults(String value) {
    Type type = new TypeToken<AdsActionStats>(){}.getType();
    this.mActionsResults = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldActivityRecency() {
    return mActivityRecency;
  }

  public AdsInsights setFieldActivityRecency(String value) {
    this.mActivityRecency = value;
    return this;
  }

  public String getFieldAdBidType() {
    return mAdBidType;
  }

  public AdsInsights setFieldAdBidType(String value) {
    this.mAdBidType = value;
    return this;
  }

  public String getFieldAdBidValue() {
    return mAdBidValue;
  }

  public AdsInsights setFieldAdBidValue(String value) {
    this.mAdBidValue = value;
    return this;
  }

  public List<AdsActionStats> getFieldAdClickActions() {
    return mAdClickActions;
  }

  public AdsInsights setFieldAdClickActions(List<AdsActionStats> value) {
    this.mAdClickActions = value;
    return this;
  }

  public AdsInsights setFieldAdClickActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mAdClickActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAdDelivery() {
    return mAdDelivery;
  }

  public AdsInsights setFieldAdDelivery(String value) {
    this.mAdDelivery = value;
    return this;
  }

  public String getFieldAdFormatAsset() {
    return mAdFormatAsset;
  }

  public AdsInsights setFieldAdFormatAsset(String value) {
    this.mAdFormatAsset = value;
    return this;
  }

  public String getFieldAdId() {
    return mAdId;
  }

  public AdsInsights setFieldAdId(String value) {
    this.mAdId = value;
    return this;
  }

  public List<AdsActionStats> getFieldAdImpressionActions() {
    return mAdImpressionActions;
  }

  public AdsInsights setFieldAdImpressionActions(List<AdsActionStats> value) {
    this.mAdImpressionActions = value;
    return this;
  }

  public AdsInsights setFieldAdImpressionActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mAdImpressionActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAdName() {
    return mAdName;
  }

  public AdsInsights setFieldAdName(String value) {
    this.mAdName = value;
    return this;
  }

  public String getFieldAdsetBidType() {
    return mAdsetBidType;
  }

  public AdsInsights setFieldAdsetBidType(String value) {
    this.mAdsetBidType = value;
    return this;
  }

  public String getFieldAdsetBidValue() {
    return mAdsetBidValue;
  }

  public AdsInsights setFieldAdsetBidValue(String value) {
    this.mAdsetBidValue = value;
    return this;
  }

  public String getFieldAdsetBudgetType() {
    return mAdsetBudgetType;
  }

  public AdsInsights setFieldAdsetBudgetType(String value) {
    this.mAdsetBudgetType = value;
    return this;
  }

  public String getFieldAdsetBudgetValue() {
    return mAdsetBudgetValue;
  }

  public AdsInsights setFieldAdsetBudgetValue(String value) {
    this.mAdsetBudgetValue = value;
    return this;
  }

  public String getFieldAdsetDelivery() {
    return mAdsetDelivery;
  }

  public AdsInsights setFieldAdsetDelivery(String value) {
    this.mAdsetDelivery = value;
    return this;
  }

  public String getFieldAdsetEnd() {
    return mAdsetEnd;
  }

  public AdsInsights setFieldAdsetEnd(String value) {
    this.mAdsetEnd = value;
    return this;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public AdsInsights setFieldAdsetId(String value) {
    this.mAdsetId = value;
    return this;
  }

  public String getFieldAdsetName() {
    return mAdsetName;
  }

  public AdsInsights setFieldAdsetName(String value) {
    this.mAdsetName = value;
    return this;
  }

  public String getFieldAdsetStart() {
    return mAdsetStart;
  }

  public AdsInsights setFieldAdsetStart(String value) {
    this.mAdsetStart = value;
    return this;
  }

  public String getFieldAge() {
    return mAge;
  }

  public AdsInsights setFieldAge(String value) {
    this.mAge = value;
    return this;
  }

  public String getFieldAgeTargeting() {
    return mAgeTargeting;
  }

  public AdsInsights setFieldAgeTargeting(String value) {
    this.mAgeTargeting = value;
    return this;
  }

  public List<AdsActionStats> getFieldAmountInCatalogCurrency() {
    return mAmountInCatalogCurrency;
  }

  public AdsInsights setFieldAmountInCatalogCurrency(List<AdsActionStats> value) {
    this.mAmountInCatalogCurrency = value;
    return this;
  }

  public AdsInsights setFieldAmountInCatalogCurrency(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mAmountInCatalogCurrency = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAppStoreClicks() {
    return mAppStoreClicks;
  }

  public AdsInsights setFieldAppStoreClicks(String value) {
    this.mAppStoreClicks = value;
    return this;
  }

  public String getFieldAttentionEventsPerImpression() {
    return mAttentionEventsPerImpression;
  }

  public AdsInsights setFieldAttentionEventsPerImpression(String value) {
    this.mAttentionEventsPerImpression = value;
    return this;
  }

  public String getFieldAttentionEventsUnqPerReach() {
    return mAttentionEventsUnqPerReach;
  }

  public AdsInsights setFieldAttentionEventsUnqPerReach(String value) {
    this.mAttentionEventsUnqPerReach = value;
    return this;
  }

  public String getFieldAuctionBid() {
    return mAuctionBid;
  }

  public AdsInsights setFieldAuctionBid(String value) {
    this.mAuctionBid = value;
    return this;
  }

  public String getFieldAuctionCompetitiveness() {
    return mAuctionCompetitiveness;
  }

  public AdsInsights setFieldAuctionCompetitiveness(String value) {
    this.mAuctionCompetitiveness = value;
    return this;
  }

  public String getFieldAuctionMaxCompetitorBid() {
    return mAuctionMaxCompetitorBid;
  }

  public AdsInsights setFieldAuctionMaxCompetitorBid(String value) {
    this.mAuctionMaxCompetitorBid = value;
    return this;
  }

  public Object getFieldBodyAsset() {
    return mBodyAsset;
  }

  public AdsInsights setFieldBodyAsset(Object value) {
    this.mBodyAsset = value;
    return this;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public AdsInsights setFieldBuyingType(String value) {
    this.mBuyingType = value;
    return this;
  }

  public Object getFieldCallToActionAsset() {
    return mCallToActionAsset;
  }

  public AdsInsights setFieldCallToActionAsset(Object value) {
    this.mCallToActionAsset = value;
    return this;
  }

  public String getFieldCallToActionClicks() {
    return mCallToActionClicks;
  }

  public AdsInsights setFieldCallToActionClicks(String value) {
    this.mCallToActionClicks = value;
    return this;
  }

  public String getFieldCampaignDelivery() {
    return mCampaignDelivery;
  }

  public AdsInsights setFieldCampaignDelivery(String value) {
    this.mCampaignDelivery = value;
    return this;
  }

  public String getFieldCampaignEnd() {
    return mCampaignEnd;
  }

  public AdsInsights setFieldCampaignEnd(String value) {
    this.mCampaignEnd = value;
    return this;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdsInsights setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public AdsInsights setFieldCampaignName(String value) {
    this.mCampaignName = value;
    return this;
  }

  public String getFieldCampaignStart() {
    return mCampaignStart;
  }

  public AdsInsights setFieldCampaignStart(String value) {
    this.mCampaignStart = value;
    return this;
  }

  public List<AdsActionStats> getFieldCancelSubscriptionActions() {
    return mCancelSubscriptionActions;
  }

  public AdsInsights setFieldCancelSubscriptionActions(List<AdsActionStats> value) {
    this.mCancelSubscriptionActions = value;
    return this;
  }

  public AdsInsights setFieldCancelSubscriptionActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCancelSubscriptionActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCanvasAvgViewPercent() {
    return mCanvasAvgViewPercent;
  }

  public AdsInsights setFieldCanvasAvgViewPercent(String value) {
    this.mCanvasAvgViewPercent = value;
    return this;
  }

  public String getFieldCanvasAvgViewTime() {
    return mCanvasAvgViewTime;
  }

  public AdsInsights setFieldCanvasAvgViewTime(String value) {
    this.mCanvasAvgViewTime = value;
    return this;
  }

  public String getFieldCardViews() {
    return mCardViews;
  }

  public AdsInsights setFieldCardViews(String value) {
    this.mCardViews = value;
    return this;
  }

  public List<AdsActionStats> getFieldCatalogSegmentActions() {
    return mCatalogSegmentActions;
  }

  public AdsInsights setFieldCatalogSegmentActions(List<AdsActionStats> value) {
    this.mCatalogSegmentActions = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCatalogSegmentValueInCatalogCurrency() {
    return mCatalogSegmentValueInCatalogCurrency;
  }

  public AdsInsights setFieldCatalogSegmentValueInCatalogCurrency(List<AdsActionStats> value) {
    this.mCatalogSegmentValueInCatalogCurrency = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentValueInCatalogCurrency(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentValueInCatalogCurrency = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCatalogSegmentValueMobilePurchaseRoas() {
    return mCatalogSegmentValueMobilePurchaseRoas;
  }

  public AdsInsights setFieldCatalogSegmentValueMobilePurchaseRoas(List<AdsActionStats> value) {
    this.mCatalogSegmentValueMobilePurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentValueMobilePurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentValueMobilePurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCatalogSegmentValueWebsitePurchaseRoas() {
    return mCatalogSegmentValueWebsitePurchaseRoas;
  }

  public AdsInsights setFieldCatalogSegmentValueWebsitePurchaseRoas(List<AdsActionStats> value) {
    this.mCatalogSegmentValueWebsitePurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentValueWebsitePurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentValueWebsitePurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldClicks() {
    return mClicks;
  }

  public AdsInsights setFieldClicks(String value) {
    this.mClicks = value;
    return this;
  }

  public List<AdsActionStats> getFieldConditionalTimeSpentMsOver10sActions() {
    return mConditionalTimeSpentMsOver10sActions;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver10sActions(List<AdsActionStats> value) {
    this.mConditionalTimeSpentMsOver10sActions = value;
    return this;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver10sActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConditionalTimeSpentMsOver10sActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConditionalTimeSpentMsOver15sActions() {
    return mConditionalTimeSpentMsOver15sActions;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver15sActions(List<AdsActionStats> value) {
    this.mConditionalTimeSpentMsOver15sActions = value;
    return this;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver15sActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConditionalTimeSpentMsOver15sActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConditionalTimeSpentMsOver2sActions() {
    return mConditionalTimeSpentMsOver2sActions;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver2sActions(List<AdsActionStats> value) {
    this.mConditionalTimeSpentMsOver2sActions = value;
    return this;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver2sActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConditionalTimeSpentMsOver2sActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConditionalTimeSpentMsOver3sActions() {
    return mConditionalTimeSpentMsOver3sActions;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver3sActions(List<AdsActionStats> value) {
    this.mConditionalTimeSpentMsOver3sActions = value;
    return this;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver3sActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConditionalTimeSpentMsOver3sActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConditionalTimeSpentMsOver6sActions() {
    return mConditionalTimeSpentMsOver6sActions;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver6sActions(List<AdsActionStats> value) {
    this.mConditionalTimeSpentMsOver6sActions = value;
    return this;
  }

  public AdsInsights setFieldConditionalTimeSpentMsOver6sActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConditionalTimeSpentMsOver6sActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldContactActions() {
    return mContactActions;
  }

  public AdsInsights setFieldContactActions(List<AdsActionStats> value) {
    this.mContactActions = value;
    return this;
  }

  public AdsInsights setFieldContactActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mContactActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldContactValue() {
    return mContactValue;
  }

  public AdsInsights setFieldContactValue(List<AdsActionStats> value) {
    this.mContactValue = value;
    return this;
  }

  public AdsInsights setFieldContactValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mContactValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldConversionRateRanking() {
    return mConversionRateRanking;
  }

  public AdsInsights setFieldConversionRateRanking(String value) {
    this.mConversionRateRanking = value;
    return this;
  }

  public List<AdsActionStats> getFieldConversionValues() {
    return mConversionValues;
  }

  public AdsInsights setFieldConversionValues(List<AdsActionStats> value) {
    this.mConversionValues = value;
    return this;
  }

  public AdsInsights setFieldConversionValues(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConversionValues = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConversions() {
    return mConversions;
  }

  public AdsInsights setFieldConversions(List<AdsActionStats> value) {
    this.mConversions = value;
    return this;
  }

  public AdsInsights setFieldConversions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConversions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPer10SecVideoView() {
    return mCostPer10SecVideoView;
  }

  public AdsInsights setFieldCostPer10SecVideoView(List<AdsActionStats> value) {
    this.mCostPer10SecVideoView = value;
    return this;
  }

  public AdsInsights setFieldCostPer10SecVideoView(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPer10SecVideoView = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPer15SecVideoView() {
    return mCostPer15SecVideoView;
  }

  public AdsInsights setFieldCostPer15SecVideoView(List<AdsActionStats> value) {
    this.mCostPer15SecVideoView = value;
    return this;
  }

  public AdsInsights setFieldCostPer15SecVideoView(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPer15SecVideoView = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPer2SecContinuousVideoView() {
    return mCostPer2SecContinuousVideoView;
  }

  public AdsInsights setFieldCostPer2SecContinuousVideoView(List<AdsActionStats> value) {
    this.mCostPer2SecContinuousVideoView = value;
    return this;
  }

  public AdsInsights setFieldCostPer2SecContinuousVideoView(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPer2SecContinuousVideoView = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public AdsActionStats getFieldCostPerActionResult() {
    return mCostPerActionResult;
  }

  public AdsInsights setFieldCostPerActionResult(AdsActionStats value) {
    this.mCostPerActionResult = value;
    return this;
  }

  public AdsInsights setFieldCostPerActionResult(String value) {
    Type type = new TypeToken<AdsActionStats>(){}.getType();
    this.mCostPerActionResult = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerActionType() {
    return mCostPerActionType;
  }

  public AdsInsights setFieldCostPerActionType(List<AdsActionStats> value) {
    this.mCostPerActionType = value;
    return this;
  }

  public AdsInsights setFieldCostPerActionType(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerActionType = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerAdClick() {
    return mCostPerAdClick;
  }

  public AdsInsights setFieldCostPerAdClick(List<AdsActionStats> value) {
    this.mCostPerAdClick = value;
    return this;
  }

  public AdsInsights setFieldCostPerAdClick(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerAdClick = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerCompletedVideoView() {
    return mCostPerCompletedVideoView;
  }

  public AdsInsights setFieldCostPerCompletedVideoView(List<AdsActionStats> value) {
    this.mCostPerCompletedVideoView = value;
    return this;
  }

  public AdsInsights setFieldCostPerCompletedVideoView(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerCompletedVideoView = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerContact() {
    return mCostPerContact;
  }

  public AdsInsights setFieldCostPerContact(List<AdsActionStats> value) {
    this.mCostPerContact = value;
    return this;
  }

  public AdsInsights setFieldCostPerContact(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerContact = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerConversion() {
    return mCostPerConversion;
  }

  public AdsInsights setFieldCostPerConversion(List<AdsActionStats> value) {
    this.mCostPerConversion = value;
    return this;
  }

  public AdsInsights setFieldCostPerConversion(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerConversion = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerCustomizeProduct() {
    return mCostPerCustomizeProduct;
  }

  public AdsInsights setFieldCostPerCustomizeProduct(List<AdsActionStats> value) {
    this.mCostPerCustomizeProduct = value;
    return this;
  }

  public AdsInsights setFieldCostPerCustomizeProduct(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerCustomizeProduct = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerDdaCountbyConvs() {
    return mCostPerDdaCountbyConvs;
  }

  public AdsInsights setFieldCostPerDdaCountbyConvs(String value) {
    this.mCostPerDdaCountbyConvs = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerDonate() {
    return mCostPerDonate;
  }

  public AdsInsights setFieldCostPerDonate(List<AdsActionStats> value) {
    this.mCostPerDonate = value;
    return this;
  }

  public AdsInsights setFieldCostPerDonate(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerDonate = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerDwell() {
    return mCostPerDwell;
  }

  public AdsInsights setFieldCostPerDwell(String value) {
    this.mCostPerDwell = value;
    return this;
  }

  public String getFieldCostPerDwell3Sec() {
    return mCostPerDwell3Sec;
  }

  public AdsInsights setFieldCostPerDwell3Sec(String value) {
    this.mCostPerDwell3Sec = value;
    return this;
  }

  public String getFieldCostPerDwell5Sec() {
    return mCostPerDwell5Sec;
  }

  public AdsInsights setFieldCostPerDwell5Sec(String value) {
    this.mCostPerDwell5Sec = value;
    return this;
  }

  public String getFieldCostPerDwell7Sec() {
    return mCostPerDwell7Sec;
  }

  public AdsInsights setFieldCostPerDwell7Sec(String value) {
    this.mCostPerDwell7Sec = value;
    return this;
  }

  public String getFieldCostPerEstimatedAdRecallers() {
    return mCostPerEstimatedAdRecallers;
  }

  public AdsInsights setFieldCostPerEstimatedAdRecallers(String value) {
    this.mCostPerEstimatedAdRecallers = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerFindLocation() {
    return mCostPerFindLocation;
  }

  public AdsInsights setFieldCostPerFindLocation(List<AdsActionStats> value) {
    this.mCostPerFindLocation = value;
    return this;
  }

  public AdsInsights setFieldCostPerFindLocation(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerFindLocation = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerInlineLinkClick() {
    return mCostPerInlineLinkClick;
  }

  public AdsInsights setFieldCostPerInlineLinkClick(String value) {
    this.mCostPerInlineLinkClick = value;
    return this;
  }

  public String getFieldCostPerInlinePostEngagement() {
    return mCostPerInlinePostEngagement;
  }

  public AdsInsights setFieldCostPerInlinePostEngagement(String value) {
    this.mCostPerInlinePostEngagement = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerOneThousandAdImpression() {
    return mCostPerOneThousandAdImpression;
  }

  public AdsInsights setFieldCostPerOneThousandAdImpression(List<AdsActionStats> value) {
    this.mCostPerOneThousandAdImpression = value;
    return this;
  }

  public AdsInsights setFieldCostPerOneThousandAdImpression(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerOneThousandAdImpression = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerOutboundClick() {
    return mCostPerOutboundClick;
  }

  public AdsInsights setFieldCostPerOutboundClick(List<AdsActionStats> value) {
    this.mCostPerOutboundClick = value;
    return this;
  }

  public AdsInsights setFieldCostPerOutboundClick(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerOutboundClick = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerSchedule() {
    return mCostPerSchedule;
  }

  public AdsInsights setFieldCostPerSchedule(List<AdsActionStats> value) {
    this.mCostPerSchedule = value;
    return this;
  }

  public AdsInsights setFieldCostPerSchedule(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerSchedule = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerStartTrial() {
    return mCostPerStartTrial;
  }

  public AdsInsights setFieldCostPerStartTrial(List<AdsActionStats> value) {
    this.mCostPerStartTrial = value;
    return this;
  }

  public AdsInsights setFieldCostPerStartTrial(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerStartTrial = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerSubmitApplication() {
    return mCostPerSubmitApplication;
  }

  public AdsInsights setFieldCostPerSubmitApplication(List<AdsActionStats> value) {
    this.mCostPerSubmitApplication = value;
    return this;
  }

  public AdsInsights setFieldCostPerSubmitApplication(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerSubmitApplication = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerSubscribe() {
    return mCostPerSubscribe;
  }

  public AdsInsights setFieldCostPerSubscribe(List<AdsActionStats> value) {
    this.mCostPerSubscribe = value;
    return this;
  }

  public AdsInsights setFieldCostPerSubscribe(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerSubscribe = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCostPerThruplay() {
    return mCostPerThruplay;
  }

  public AdsInsights setFieldCostPerThruplay(List<AdsActionStats> value) {
    this.mCostPerThruplay = value;
    return this;
  }

  public AdsInsights setFieldCostPerThruplay(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerThruplay = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerTotalAction() {
    return mCostPerTotalAction;
  }

  public AdsInsights setFieldCostPerTotalAction(String value) {
    this.mCostPerTotalAction = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerUniqueActionType() {
    return mCostPerUniqueActionType;
  }

  public AdsInsights setFieldCostPerUniqueActionType(List<AdsActionStats> value) {
    this.mCostPerUniqueActionType = value;
    return this;
  }

  public AdsInsights setFieldCostPerUniqueActionType(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerUniqueActionType = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public AdsInsights setFieldCostPerUniqueClick(String value) {
    this.mCostPerUniqueClick = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerUniqueConversion() {
    return mCostPerUniqueConversion;
  }

  public AdsInsights setFieldCostPerUniqueConversion(List<AdsActionStats> value) {
    this.mCostPerUniqueConversion = value;
    return this;
  }

  public AdsInsights setFieldCostPerUniqueConversion(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerUniqueConversion = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCostPerUniqueInlineLinkClick() {
    return mCostPerUniqueInlineLinkClick;
  }

  public AdsInsights setFieldCostPerUniqueInlineLinkClick(String value) {
    this.mCostPerUniqueInlineLinkClick = value;
    return this;
  }

  public List<AdsActionStats> getFieldCostPerUniqueOutboundClick() {
    return mCostPerUniqueOutboundClick;
  }

  public AdsInsights setFieldCostPerUniqueOutboundClick(List<AdsActionStats> value) {
    this.mCostPerUniqueOutboundClick = value;
    return this;
  }

  public AdsInsights setFieldCostPerUniqueOutboundClick(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCostPerUniqueOutboundClick = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCountry() {
    return mCountry;
  }

  public AdsInsights setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldCpc() {
    return mCpc;
  }

  public AdsInsights setFieldCpc(String value) {
    this.mCpc = value;
    return this;
  }

  public String getFieldCpm() {
    return mCpm;
  }

  public AdsInsights setFieldCpm(String value) {
    this.mCpm = value;
    return this;
  }

  public String getFieldCpp() {
    return mCpp;
  }

  public AdsInsights setFieldCpp(String value) {
    this.mCpp = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdsInsights setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldCreativeFingerprint() {
    return mCreativeFingerprint;
  }

  public AdsInsights setFieldCreativeFingerprint(String value) {
    this.mCreativeFingerprint = value;
    return this;
  }

  public String getFieldCtr() {
    return mCtr;
  }

  public AdsInsights setFieldCtr(String value) {
    this.mCtr = value;
    return this;
  }

  public List<AdsActionStats> getFieldCustomizeProductActions() {
    return mCustomizeProductActions;
  }

  public AdsInsights setFieldCustomizeProductActions(List<AdsActionStats> value) {
    this.mCustomizeProductActions = value;
    return this;
  }

  public AdsInsights setFieldCustomizeProductActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCustomizeProductActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldCustomizeProductValue() {
    return mCustomizeProductValue;
  }

  public AdsInsights setFieldCustomizeProductValue(List<AdsActionStats> value) {
    this.mCustomizeProductValue = value;
    return this;
  }

  public AdsInsights setFieldCustomizeProductValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCustomizeProductValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDateStart() {
    return mDateStart;
  }

  public AdsInsights setFieldDateStart(String value) {
    this.mDateStart = value;
    return this;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public AdsInsights setFieldDateStop(String value) {
    this.mDateStop = value;
    return this;
  }

  public String getFieldDdaCountbyConvs() {
    return mDdaCountbyConvs;
  }

  public AdsInsights setFieldDdaCountbyConvs(String value) {
    this.mDdaCountbyConvs = value;
    return this;
  }

  public String getFieldDeduping1stSourceRatio() {
    return mDeduping1stSourceRatio;
  }

  public AdsInsights setFieldDeduping1stSourceRatio(String value) {
    this.mDeduping1stSourceRatio = value;
    return this;
  }

  public String getFieldDeduping2ndSourceRatio() {
    return mDeduping2ndSourceRatio;
  }

  public AdsInsights setFieldDeduping2ndSourceRatio(String value) {
    this.mDeduping2ndSourceRatio = value;
    return this;
  }

  public String getFieldDeduping3rdSourceRatio() {
    return mDeduping3rdSourceRatio;
  }

  public AdsInsights setFieldDeduping3rdSourceRatio(String value) {
    this.mDeduping3rdSourceRatio = value;
    return this;
  }

  public String getFieldDedupingRatio() {
    return mDedupingRatio;
  }

  public AdsInsights setFieldDedupingRatio(String value) {
    this.mDedupingRatio = value;
    return this;
  }

  public String getFieldDeeplinkClicks() {
    return mDeeplinkClicks;
  }

  public AdsInsights setFieldDeeplinkClicks(String value) {
    this.mDeeplinkClicks = value;
    return this;
  }

  public Object getFieldDescriptionAsset() {
    return mDescriptionAsset;
  }

  public AdsInsights setFieldDescriptionAsset(Object value) {
    this.mDescriptionAsset = value;
    return this;
  }

  public String getFieldDevicePlatform() {
    return mDevicePlatform;
  }

  public AdsInsights setFieldDevicePlatform(String value) {
    this.mDevicePlatform = value;
    return this;
  }

  public String getFieldDma() {
    return mDma;
  }

  public AdsInsights setFieldDma(String value) {
    this.mDma = value;
    return this;
  }

  public List<AdsActionStats> getFieldDonateActions() {
    return mDonateActions;
  }

  public AdsInsights setFieldDonateActions(List<AdsActionStats> value) {
    this.mDonateActions = value;
    return this;
  }

  public AdsInsights setFieldDonateActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mDonateActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldDonateValue() {
    return mDonateValue;
  }

  public AdsInsights setFieldDonateValue(List<AdsActionStats> value) {
    this.mDonateValue = value;
    return this;
  }

  public AdsInsights setFieldDonateValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mDonateValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDwell3Sec() {
    return mDwell3Sec;
  }

  public AdsInsights setFieldDwell3Sec(String value) {
    this.mDwell3Sec = value;
    return this;
  }

  public String getFieldDwell5Sec() {
    return mDwell5Sec;
  }

  public AdsInsights setFieldDwell5Sec(String value) {
    this.mDwell5Sec = value;
    return this;
  }

  public String getFieldDwell7Sec() {
    return mDwell7Sec;
  }

  public AdsInsights setFieldDwell7Sec(String value) {
    this.mDwell7Sec = value;
    return this;
  }

  public String getFieldDwellRate() {
    return mDwellRate;
  }

  public AdsInsights setFieldDwellRate(String value) {
    this.mDwellRate = value;
    return this;
  }

  public String getFieldEarnedImpression() {
    return mEarnedImpression;
  }

  public AdsInsights setFieldEarnedImpression(String value) {
    this.mEarnedImpression = value;
    return this;
  }

  public String getFieldEngagementRateRanking() {
    return mEngagementRateRanking;
  }

  public AdsInsights setFieldEngagementRateRanking(String value) {
    this.mEngagementRateRanking = value;
    return this;
  }

  public String getFieldEstimatedAdRecallRate() {
    return mEstimatedAdRecallRate;
  }

  public AdsInsights setFieldEstimatedAdRecallRate(String value) {
    this.mEstimatedAdRecallRate = value;
    return this;
  }

  public String getFieldEstimatedAdRecallRateLowerBound() {
    return mEstimatedAdRecallRateLowerBound;
  }

  public AdsInsights setFieldEstimatedAdRecallRateLowerBound(String value) {
    this.mEstimatedAdRecallRateLowerBound = value;
    return this;
  }

  public String getFieldEstimatedAdRecallRateUpperBound() {
    return mEstimatedAdRecallRateUpperBound;
  }

  public AdsInsights setFieldEstimatedAdRecallRateUpperBound(String value) {
    this.mEstimatedAdRecallRateUpperBound = value;
    return this;
  }

  public String getFieldEstimatedAdRecallers() {
    return mEstimatedAdRecallers;
  }

  public AdsInsights setFieldEstimatedAdRecallers(String value) {
    this.mEstimatedAdRecallers = value;
    return this;
  }

  public String getFieldEstimatedAdRecallersLowerBound() {
    return mEstimatedAdRecallersLowerBound;
  }

  public AdsInsights setFieldEstimatedAdRecallersLowerBound(String value) {
    this.mEstimatedAdRecallersLowerBound = value;
    return this;
  }

  public String getFieldEstimatedAdRecallersUpperBound() {
    return mEstimatedAdRecallersUpperBound;
  }

  public AdsInsights setFieldEstimatedAdRecallersUpperBound(String value) {
    this.mEstimatedAdRecallersUpperBound = value;
    return this;
  }

  public List<AdsActionStats> getFieldFindLocationActions() {
    return mFindLocationActions;
  }

  public AdsInsights setFieldFindLocationActions(List<AdsActionStats> value) {
    this.mFindLocationActions = value;
    return this;
  }

  public AdsInsights setFieldFindLocationActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mFindLocationActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldFindLocationValue() {
    return mFindLocationValue;
  }

  public AdsInsights setFieldFindLocationValue(List<AdsActionStats> value) {
    this.mFindLocationValue = value;
    return this;
  }

  public AdsInsights setFieldFindLocationValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mFindLocationValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldFrequency() {
    return mFrequency;
  }

  public AdsInsights setFieldFrequency(String value) {
    this.mFrequency = value;
    return this;
  }

  public String getFieldFrequencyValue() {
    return mFrequencyValue;
  }

  public AdsInsights setFieldFrequencyValue(String value) {
    this.mFrequencyValue = value;
    return this;
  }

  public String getFieldFullViewImpressions() {
    return mFullViewImpressions;
  }

  public AdsInsights setFieldFullViewImpressions(String value) {
    this.mFullViewImpressions = value;
    return this;
  }

  public String getFieldFullViewReach() {
    return mFullViewReach;
  }

  public AdsInsights setFieldFullViewReach(String value) {
    this.mFullViewReach = value;
    return this;
  }

  public String getFieldGender() {
    return mGender;
  }

  public AdsInsights setFieldGender(String value) {
    this.mGender = value;
    return this;
  }

  public String getFieldGenderTargeting() {
    return mGenderTargeting;
  }

  public AdsInsights setFieldGenderTargeting(String value) {
    this.mGenderTargeting = value;
    return this;
  }

  public String getFieldHourlyStatsAggregatedByAdvertiserTimeZone() {
    return mHourlyStatsAggregatedByAdvertiserTimeZone;
  }

  public AdsInsights setFieldHourlyStatsAggregatedByAdvertiserTimeZone(String value) {
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = value;
    return this;
  }

  public String getFieldHourlyStatsAggregatedByAudienceTimeZone() {
    return mHourlyStatsAggregatedByAudienceTimeZone;
  }

  public AdsInsights setFieldHourlyStatsAggregatedByAudienceTimeZone(String value) {
    this.mHourlyStatsAggregatedByAudienceTimeZone = value;
    return this;
  }

  public Object getFieldImageAsset() {
    return mImageAsset;
  }

  public AdsInsights setFieldImageAsset(Object value) {
    this.mImageAsset = value;
    return this;
  }

  public String getFieldImpressionDevice() {
    return mImpressionDevice;
  }

  public AdsInsights setFieldImpressionDevice(String value) {
    this.mImpressionDevice = value;
    return this;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public AdsInsights setFieldImpressions(String value) {
    this.mImpressions = value;
    return this;
  }

  public String getFieldImpressionsAutoRefresh() {
    return mImpressionsAutoRefresh;
  }

  public AdsInsights setFieldImpressionsAutoRefresh(String value) {
    this.mImpressionsAutoRefresh = value;
    return this;
  }

  public String getFieldImpressionsGross() {
    return mImpressionsGross;
  }

  public AdsInsights setFieldImpressionsGross(String value) {
    this.mImpressionsGross = value;
    return this;
  }

  public String getFieldInlineLinkClickCtr() {
    return mInlineLinkClickCtr;
  }

  public AdsInsights setFieldInlineLinkClickCtr(String value) {
    this.mInlineLinkClickCtr = value;
    return this;
  }

  public String getFieldInlineLinkClicks() {
    return mInlineLinkClicks;
  }

  public AdsInsights setFieldInlineLinkClicks(String value) {
    this.mInlineLinkClicks = value;
    return this;
  }

  public String getFieldInlinePostEngagement() {
    return mInlinePostEngagement;
  }

  public AdsInsights setFieldInlinePostEngagement(String value) {
    this.mInlinePostEngagement = value;
    return this;
  }

  public String getFieldInstantExperienceClicksToOpen() {
    return mInstantExperienceClicksToOpen;
  }

  public AdsInsights setFieldInstantExperienceClicksToOpen(String value) {
    this.mInstantExperienceClicksToOpen = value;
    return this;
  }

  public String getFieldInstantExperienceClicksToStart() {
    return mInstantExperienceClicksToStart;
  }

  public AdsInsights setFieldInstantExperienceClicksToStart(String value) {
    this.mInstantExperienceClicksToStart = value;
    return this;
  }

  public String getFieldInstantExperienceOutboundClicks() {
    return mInstantExperienceOutboundClicks;
  }

  public AdsInsights setFieldInstantExperienceOutboundClicks(String value) {
    this.mInstantExperienceOutboundClicks = value;
    return this;
  }

  public List<AdsActionStats> getFieldInteractiveComponentTap() {
    return mInteractiveComponentTap;
  }

  public AdsInsights setFieldInteractiveComponentTap(List<AdsActionStats> value) {
    this.mInteractiveComponentTap = value;
    return this;
  }

  public AdsInsights setFieldInteractiveComponentTap(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mInteractiveComponentTap = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLabels() {
    return mLabels;
  }

  public AdsInsights setFieldLabels(String value) {
    this.mLabels = value;
    return this;
  }

  public Object getFieldLinkUrlAsset() {
    return mLinkUrlAsset;
  }

  public AdsInsights setFieldLinkUrlAsset(Object value) {
    this.mLinkUrlAsset = value;
    return this;
  }

  public String getFieldLocation() {
    return mLocation;
  }

  public AdsInsights setFieldLocation(String value) {
    this.mLocation = value;
    return this;
  }

  public Object getFieldMediaAsset() {
    return mMediaAsset;
  }

  public AdsInsights setFieldMediaAsset(Object value) {
    this.mMediaAsset = value;
    return this;
  }

  public List<AdsActionStats> getFieldMobileAppPurchaseRoas() {
    return mMobileAppPurchaseRoas;
  }

  public AdsInsights setFieldMobileAppPurchaseRoas(List<AdsActionStats> value) {
    this.mMobileAppPurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldMobileAppPurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mMobileAppPurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldNewsfeedAvgPosition() {
    return mNewsfeedAvgPosition;
  }

  public AdsInsights setFieldNewsfeedAvgPosition(String value) {
    this.mNewsfeedAvgPosition = value;
    return this;
  }

  public String getFieldNewsfeedClicks() {
    return mNewsfeedClicks;
  }

  public AdsInsights setFieldNewsfeedClicks(String value) {
    this.mNewsfeedClicks = value;
    return this;
  }

  public String getFieldNewsfeedImpressions() {
    return mNewsfeedImpressions;
  }

  public AdsInsights setFieldNewsfeedImpressions(String value) {
    this.mNewsfeedImpressions = value;
    return this;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public AdsInsights setFieldObjective(String value) {
    this.mObjective = value;
    return this;
  }

  public String getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public AdsInsights setFieldOptimizationGoal(String value) {
    this.mOptimizationGoal = value;
    return this;
  }

  public List<AdsActionStats> getFieldOutboundClicks() {
    return mOutboundClicks;
  }

  public AdsInsights setFieldOutboundClicks(List<AdsActionStats> value) {
    this.mOutboundClicks = value;
    return this;
  }

  public AdsInsights setFieldOutboundClicks(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mOutboundClicks = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldOutboundClicksCtr() {
    return mOutboundClicksCtr;
  }

  public AdsInsights setFieldOutboundClicksCtr(List<AdsActionStats> value) {
    this.mOutboundClicksCtr = value;
    return this;
  }

  public AdsInsights setFieldOutboundClicksCtr(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mOutboundClicksCtr = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPerformanceIndicator() {
    return mPerformanceIndicator;
  }

  public AdsInsights setFieldPerformanceIndicator(String value) {
    this.mPerformanceIndicator = value;
    return this;
  }

  public String getFieldPlacePageId() {
    return mPlacePageId;
  }

  public AdsInsights setFieldPlacePageId(String value) {
    this.mPlacePageId = value;
    return this;
  }

  public String getFieldPlacePageName() {
    return mPlacePageName;
  }

  public AdsInsights setFieldPlacePageName(String value) {
    this.mPlacePageName = value;
    return this;
  }

  public String getFieldPlacement() {
    return mPlacement;
  }

  public AdsInsights setFieldPlacement(String value) {
    this.mPlacement = value;
    return this;
  }

  public String getFieldPlatformPosition() {
    return mPlatformPosition;
  }

  public AdsInsights setFieldPlatformPosition(String value) {
    this.mPlatformPosition = value;
    return this;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public AdsInsights setFieldProductId(String value) {
    this.mProductId = value;
    return this;
  }

  public String getFieldPublisherPlatform() {
    return mPublisherPlatform;
  }

  public AdsInsights setFieldPublisherPlatform(String value) {
    this.mPublisherPlatform = value;
    return this;
  }

  public List<AdsActionStats> getFieldPurchaseRoas() {
    return mPurchaseRoas;
  }

  public AdsInsights setFieldPurchaseRoas(List<AdsActionStats> value) {
    this.mPurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldPurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mPurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldQualityRanking() {
    return mQualityRanking;
  }

  public AdsInsights setFieldQualityRanking(String value) {
    this.mQualityRanking = value;
    return this;
  }

  public String getFieldQualityScoreEctr() {
    return mQualityScoreEctr;
  }

  public AdsInsights setFieldQualityScoreEctr(String value) {
    this.mQualityScoreEctr = value;
    return this;
  }

  public String getFieldQualityScoreEcvr() {
    return mQualityScoreEcvr;
  }

  public AdsInsights setFieldQualityScoreEcvr(String value) {
    this.mQualityScoreEcvr = value;
    return this;
  }

  public String getFieldQualityScoreEnfbr() {
    return mQualityScoreEnfbr;
  }

  public AdsInsights setFieldQualityScoreEnfbr(String value) {
    this.mQualityScoreEnfbr = value;
    return this;
  }

  public String getFieldQualityScoreOrganic() {
    return mQualityScoreOrganic;
  }

  public AdsInsights setFieldQualityScoreOrganic(String value) {
    this.mQualityScoreOrganic = value;
    return this;
  }

  public String getFieldReach() {
    return mReach;
  }

  public AdsInsights setFieldReach(String value) {
    this.mReach = value;
    return this;
  }

  public List<AdsActionStats> getFieldRecurringSubscriptionPaymentActions() {
    return mRecurringSubscriptionPaymentActions;
  }

  public AdsInsights setFieldRecurringSubscriptionPaymentActions(List<AdsActionStats> value) {
    this.mRecurringSubscriptionPaymentActions = value;
    return this;
  }

  public AdsInsights setFieldRecurringSubscriptionPaymentActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mRecurringSubscriptionPaymentActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldRegion() {
    return mRegion;
  }

  public AdsInsights setFieldRegion(String value) {
    this.mRegion = value;
    return this;
  }

  public AdgroupRelevanceScore getFieldRelevanceScore() {
    return mRelevanceScore;
  }

  public AdsInsights setFieldRelevanceScore(AdgroupRelevanceScore value) {
    this.mRelevanceScore = value;
    return this;
  }

  public AdsInsights setFieldRelevanceScore(String value) {
    Type type = new TypeToken<AdgroupRelevanceScore>(){}.getType();
    this.mRelevanceScore = AdgroupRelevanceScore.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldRuleAsset() {
    return mRuleAsset;
  }

  public AdsInsights setFieldRuleAsset(Object value) {
    this.mRuleAsset = value;
    return this;
  }

  public List<AdsActionStats> getFieldScheduleActions() {
    return mScheduleActions;
  }

  public AdsInsights setFieldScheduleActions(List<AdsActionStats> value) {
    this.mScheduleActions = value;
    return this;
  }

  public AdsInsights setFieldScheduleActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mScheduleActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldScheduleValue() {
    return mScheduleValue;
  }

  public AdsInsights setFieldScheduleValue(List<AdsActionStats> value) {
    this.mScheduleValue = value;
    return this;
  }

  public AdsInsights setFieldScheduleValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mScheduleValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldSocialSpend() {
    return mSocialSpend;
  }

  public AdsInsights setFieldSocialSpend(String value) {
    this.mSocialSpend = value;
    return this;
  }

  public String getFieldSpend() {
    return mSpend;
  }

  public AdsInsights setFieldSpend(String value) {
    this.mSpend = value;
    return this;
  }

  public List<AdsActionStats> getFieldStartTrialActions() {
    return mStartTrialActions;
  }

  public AdsInsights setFieldStartTrialActions(List<AdsActionStats> value) {
    this.mStartTrialActions = value;
    return this;
  }

  public AdsInsights setFieldStartTrialActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mStartTrialActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldStartTrialValue() {
    return mStartTrialValue;
  }

  public AdsInsights setFieldStartTrialValue(List<AdsActionStats> value) {
    this.mStartTrialValue = value;
    return this;
  }

  public AdsInsights setFieldStartTrialValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mStartTrialValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldSubmitApplicationActions() {
    return mSubmitApplicationActions;
  }

  public AdsInsights setFieldSubmitApplicationActions(List<AdsActionStats> value) {
    this.mSubmitApplicationActions = value;
    return this;
  }

  public AdsInsights setFieldSubmitApplicationActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mSubmitApplicationActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldSubmitApplicationValue() {
    return mSubmitApplicationValue;
  }

  public AdsInsights setFieldSubmitApplicationValue(List<AdsActionStats> value) {
    this.mSubmitApplicationValue = value;
    return this;
  }

  public AdsInsights setFieldSubmitApplicationValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mSubmitApplicationValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldSubscribeActions() {
    return mSubscribeActions;
  }

  public AdsInsights setFieldSubscribeActions(List<AdsActionStats> value) {
    this.mSubscribeActions = value;
    return this;
  }

  public AdsInsights setFieldSubscribeActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mSubscribeActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldSubscribeValue() {
    return mSubscribeValue;
  }

  public AdsInsights setFieldSubscribeValue(List<AdsActionStats> value) {
    this.mSubscribeValue = value;
    return this;
  }

  public AdsInsights setFieldSubscribeValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mSubscribeValue = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldThumbStops() {
    return mThumbStops;
  }

  public AdsInsights setFieldThumbStops(String value) {
    this.mThumbStops = value;
    return this;
  }

  public Object getFieldTitleAsset() {
    return mTitleAsset;
  }

  public AdsInsights setFieldTitleAsset(Object value) {
    this.mTitleAsset = value;
    return this;
  }

  public String getFieldTodaySpend() {
    return mTodaySpend;
  }

  public AdsInsights setFieldTodaySpend(String value) {
    this.mTodaySpend = value;
    return this;
  }

  public String getFieldTotalActionValue() {
    return mTotalActionValue;
  }

  public AdsInsights setFieldTotalActionValue(String value) {
    this.mTotalActionValue = value;
    return this;
  }

  public String getFieldTotalActions() {
    return mTotalActions;
  }

  public AdsInsights setFieldTotalActions(String value) {
    this.mTotalActions = value;
    return this;
  }

  public String getFieldTotalUniqueActions() {
    return mTotalUniqueActions;
  }

  public AdsInsights setFieldTotalUniqueActions(String value) {
    this.mTotalUniqueActions = value;
    return this;
  }

  public List<AdsActionStats> getFieldUniqueActions() {
    return mUniqueActions;
  }

  public AdsInsights setFieldUniqueActions(List<AdsActionStats> value) {
    this.mUniqueActions = value;
    return this;
  }

  public AdsInsights setFieldUniqueActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdsInsights setFieldUniqueClicks(String value) {
    this.mUniqueClicks = value;
    return this;
  }

  public List<AdsActionStats> getFieldUniqueConversions() {
    return mUniqueConversions;
  }

  public AdsInsights setFieldUniqueConversions(List<AdsActionStats> value) {
    this.mUniqueConversions = value;
    return this;
  }

  public AdsInsights setFieldUniqueConversions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueConversions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public AdsInsights setFieldUniqueCtr(String value) {
    this.mUniqueCtr = value;
    return this;
  }

  public String getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdsInsights setFieldUniqueImpressions(String value) {
    this.mUniqueImpressions = value;
    return this;
  }

  public String getFieldUniqueInlineLinkClickCtr() {
    return mUniqueInlineLinkClickCtr;
  }

  public AdsInsights setFieldUniqueInlineLinkClickCtr(String value) {
    this.mUniqueInlineLinkClickCtr = value;
    return this;
  }

  public String getFieldUniqueInlineLinkClicks() {
    return mUniqueInlineLinkClicks;
  }

  public AdsInsights setFieldUniqueInlineLinkClicks(String value) {
    this.mUniqueInlineLinkClicks = value;
    return this;
  }

  public String getFieldUniqueLinkClicksCtr() {
    return mUniqueLinkClicksCtr;
  }

  public AdsInsights setFieldUniqueLinkClicksCtr(String value) {
    this.mUniqueLinkClicksCtr = value;
    return this;
  }

  public List<AdsActionStats> getFieldUniqueOutboundClicks() {
    return mUniqueOutboundClicks;
  }

  public AdsInsights setFieldUniqueOutboundClicks(List<AdsActionStats> value) {
    this.mUniqueOutboundClicks = value;
    return this;
  }

  public AdsInsights setFieldUniqueOutboundClicks(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueOutboundClicks = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldUniqueOutboundClicksCtr() {
    return mUniqueOutboundClicksCtr;
  }

  public AdsInsights setFieldUniqueOutboundClicksCtr(List<AdsActionStats> value) {
    this.mUniqueOutboundClicksCtr = value;
    return this;
  }

  public AdsInsights setFieldUniqueOutboundClicksCtr(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueOutboundClicksCtr = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldUniqueVideoContinuous2SecWatchedActions() {
    return mUniqueVideoContinuous2SecWatchedActions;
  }

  public AdsInsights setFieldUniqueVideoContinuous2SecWatchedActions(List<AdsActionStats> value) {
    this.mUniqueVideoContinuous2SecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldUniqueVideoContinuous2SecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueVideoContinuous2SecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldUniqueVideoView10Sec() {
    return mUniqueVideoView10Sec;
  }

  public AdsInsights setFieldUniqueVideoView10Sec(List<AdsActionStats> value) {
    this.mUniqueVideoView10Sec = value;
    return this;
  }

  public AdsInsights setFieldUniqueVideoView10Sec(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueVideoView10Sec = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldUniqueVideoView15Sec() {
    return mUniqueVideoView15Sec;
  }

  public AdsInsights setFieldUniqueVideoView15Sec(List<AdsActionStats> value) {
    this.mUniqueVideoView15Sec = value;
    return this;
  }

  public AdsInsights setFieldUniqueVideoView15Sec(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueVideoView15Sec = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public AdsInsights setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public List<AdsActionStats> getFieldVideo10SecWatchedActions() {
    return mVideo10SecWatchedActions;
  }

  public AdsInsights setFieldVideo10SecWatchedActions(List<AdsActionStats> value) {
    this.mVideo10SecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideo10SecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideo10SecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideo15SecWatchedActions() {
    return mVideo15SecWatchedActions;
  }

  public AdsInsights setFieldVideo15SecWatchedActions(List<AdsActionStats> value) {
    this.mVideo15SecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideo15SecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideo15SecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideo30SecWatchedActions() {
    return mVideo30SecWatchedActions;
  }

  public AdsInsights setFieldVideo30SecWatchedActions(List<AdsActionStats> value) {
    this.mVideo30SecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideo30SecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideo30SecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldVideoAsset() {
    return mVideoAsset;
  }

  public AdsInsights setFieldVideoAsset(Object value) {
    this.mVideoAsset = value;
    return this;
  }

  public List<AdsActionStats> getFieldVideoAvgTimeWatchedActions() {
    return mVideoAvgTimeWatchedActions;
  }

  public AdsInsights setFieldVideoAvgTimeWatchedActions(List<AdsActionStats> value) {
    this.mVideoAvgTimeWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoAvgTimeWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoAvgTimeWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoCompleteWatchedActions() {
    return mVideoCompleteWatchedActions;
  }

  public AdsInsights setFieldVideoCompleteWatchedActions(List<AdsActionStats> value) {
    this.mVideoCompleteWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoCompleteWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoCompleteWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoCompletedViewOr15sPassedActions() {
    return mVideoCompletedViewOr15sPassedActions;
  }

  public AdsInsights setFieldVideoCompletedViewOr15sPassedActions(List<AdsActionStats> value) {
    this.mVideoCompletedViewOr15sPassedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoCompletedViewOr15sPassedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoCompletedViewOr15sPassedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoContinuous2SecWatchedActions() {
    return mVideoContinuous2SecWatchedActions;
  }

  public AdsInsights setFieldVideoContinuous2SecWatchedActions(List<AdsActionStats> value) {
    this.mVideoContinuous2SecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoContinuous2SecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoContinuous2SecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoP100WatchedActions() {
    return mVideoP100WatchedActions;
  }

  public AdsInsights setFieldVideoP100WatchedActions(List<AdsActionStats> value) {
    this.mVideoP100WatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoP100WatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoP100WatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoP25WatchedActions() {
    return mVideoP25WatchedActions;
  }

  public AdsInsights setFieldVideoP25WatchedActions(List<AdsActionStats> value) {
    this.mVideoP25WatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoP25WatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoP25WatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoP50WatchedActions() {
    return mVideoP50WatchedActions;
  }

  public AdsInsights setFieldVideoP50WatchedActions(List<AdsActionStats> value) {
    this.mVideoP50WatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoP50WatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoP50WatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoP75WatchedActions() {
    return mVideoP75WatchedActions;
  }

  public AdsInsights setFieldVideoP75WatchedActions(List<AdsActionStats> value) {
    this.mVideoP75WatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoP75WatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoP75WatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoP95WatchedActions() {
    return mVideoP95WatchedActions;
  }

  public AdsInsights setFieldVideoP95WatchedActions(List<AdsActionStats> value) {
    this.mVideoP95WatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoP95WatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoP95WatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoPlayActions() {
    return mVideoPlayActions;
  }

  public AdsInsights setFieldVideoPlayActions(List<AdsActionStats> value) {
    this.mVideoPlayActions = value;
    return this;
  }

  public AdsInsights setFieldVideoPlayActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoPlayActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<Object> getFieldVideoPlayCurveActions() {
    return mVideoPlayCurveActions;
  }

  public AdsInsights setFieldVideoPlayCurveActions(List<Object> value) {
    this.mVideoPlayCurveActions = value;
    return this;
  }

  public List<Object> getFieldVideoPlayRetention0To15sActions() {
    return mVideoPlayRetention0To15sActions;
  }

  public AdsInsights setFieldVideoPlayRetention0To15sActions(List<Object> value) {
    this.mVideoPlayRetention0To15sActions = value;
    return this;
  }

  public List<Object> getFieldVideoPlayRetention20To60sActions() {
    return mVideoPlayRetention20To60sActions;
  }

  public AdsInsights setFieldVideoPlayRetention20To60sActions(List<Object> value) {
    this.mVideoPlayRetention20To60sActions = value;
    return this;
  }

  public List<Object> getFieldVideoPlayRetentionGraphActions() {
    return mVideoPlayRetentionGraphActions;
  }

  public AdsInsights setFieldVideoPlayRetentionGraphActions(List<Object> value) {
    this.mVideoPlayRetentionGraphActions = value;
    return this;
  }

  public List<AdsActionStats> getFieldVideoThruplayWatchedActions() {
    return mVideoThruplayWatchedActions;
  }

  public AdsInsights setFieldVideoThruplayWatchedActions(List<AdsActionStats> value) {
    this.mVideoThruplayWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoThruplayWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoThruplayWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoTimeWatchedActions() {
    return mVideoTimeWatchedActions;
  }

  public AdsInsights setFieldVideoTimeWatchedActions(List<AdsActionStats> value) {
    this.mVideoTimeWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoTimeWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoTimeWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldWebsiteClicks() {
    return mWebsiteClicks;
  }

  public AdsInsights setFieldWebsiteClicks(String value) {
    this.mWebsiteClicks = value;
    return this;
  }

  public List<AdsActionStats> getFieldWebsiteCtr() {
    return mWebsiteCtr;
  }

  public AdsInsights setFieldWebsiteCtr(List<AdsActionStats> value) {
    this.mWebsiteCtr = value;
    return this;
  }

  public AdsInsights setFieldWebsiteCtr(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mWebsiteCtr = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldWebsitePurchaseRoas() {
    return mWebsitePurchaseRoas;
  }

  public AdsInsights setFieldWebsitePurchaseRoas(List<AdsActionStats> value) {
    this.mWebsitePurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldWebsitePurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mWebsitePurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldWishBid() {
    return mWishBid;
  }

  public AdsInsights setFieldWishBid(String value) {
    this.mWishBid = value;
    return this;
  }



  public static enum EnumActionAttributionWindows {
      @SerializedName("1d_click")
      VALUE_1D_CLICK("1d_click"),
      @SerializedName("1d_view")
      VALUE_1D_VIEW("1d_view"),
      @SerializedName("28d_click")
      VALUE_28D_CLICK("28d_click"),
      @SerializedName("28d_view")
      VALUE_28D_VIEW("28d_view"),
      @SerializedName("7d_click")
      VALUE_7D_CLICK("7d_click"),
      @SerializedName("7d_view")
      VALUE_7D_VIEW("7d_view"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      ;

      private String value;

      private EnumActionAttributionWindows(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionBreakdowns {
      @SerializedName("action_canvas_component_name")
      VALUE_ACTION_CANVAS_COMPONENT_NAME("action_canvas_component_name"),
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_converted_product_id")
      VALUE_ACTION_CONVERTED_PRODUCT_ID("action_converted_product_id"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      ;

      private String value;

      private EnumActionBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionReportTime {
      @SerializedName("conversion")
      VALUE_CONVERSION("conversion"),
      @SerializedName("impression")
      VALUE_IMPRESSION("impression"),
      ;

      private String value;

      private EnumActionReportTime(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("ad_format_asset")
      VALUE_AD_FORMAT_ASSET("ad_format_asset"),
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("body_asset")
      VALUE_BODY_ASSET("body_asset"),
      @SerializedName("call_to_action_asset")
      VALUE_CALL_TO_ACTION_ASSET("call_to_action_asset"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("description_asset")
      VALUE_DESCRIPTION_ASSET("description_asset"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("dma")
      VALUE_DMA("dma"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
      @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
      @SerializedName("image_asset")
      VALUE_IMAGE_ASSET("image_asset"),
      @SerializedName("impression_device")
      VALUE_IMPRESSION_DEVICE("impression_device"),
      @SerializedName("link_url_asset")
      VALUE_LINK_URL_ASSET("link_url_asset"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("platform_position")
      VALUE_PLATFORM_POSITION("platform_position"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("publisher_platform")
      VALUE_PUBLISHER_PLATFORM("publisher_platform"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("title_asset")
      VALUE_TITLE_ASSET("title_asset"),
      @SerializedName("video_asset")
      VALUE_VIDEO_ASSET("video_asset"),
      ;

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDatePreset {
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
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

  public static enum EnumLevel {
      @SerializedName("account")
      VALUE_ACCOUNT("account"),
      @SerializedName("ad")
      VALUE_AD("ad"),
      @SerializedName("adset")
      VALUE_ADSET("adset"),
      @SerializedName("campaign")
      VALUE_CAMPAIGN("campaign"),
      ;

      private String value;

      private EnumLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSummaryActionBreakdowns {
      @SerializedName("action_canvas_component_name")
      VALUE_ACTION_CANVAS_COMPONENT_NAME("action_canvas_component_name"),
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_converted_product_id")
      VALUE_ACTION_CONVERTED_PRODUCT_ID("action_converted_product_id"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      ;

      private String value;

      private EnumSummaryActionBreakdowns(String value) {
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

  public AdsInsights copyFrom(AdsInsights instance) {
    this.mAccountCurrency = instance.mAccountCurrency;
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mActionValues = instance.mActionValues;
    this.mActions = instance.mActions;
    this.mActionsPerImpression = instance.mActionsPerImpression;
    this.mActionsResults = instance.mActionsResults;
    this.mActivityRecency = instance.mActivityRecency;
    this.mAdBidType = instance.mAdBidType;
    this.mAdBidValue = instance.mAdBidValue;
    this.mAdClickActions = instance.mAdClickActions;
    this.mAdDelivery = instance.mAdDelivery;
    this.mAdFormatAsset = instance.mAdFormatAsset;
    this.mAdId = instance.mAdId;
    this.mAdImpressionActions = instance.mAdImpressionActions;
    this.mAdName = instance.mAdName;
    this.mAdsetBidType = instance.mAdsetBidType;
    this.mAdsetBidValue = instance.mAdsetBidValue;
    this.mAdsetBudgetType = instance.mAdsetBudgetType;
    this.mAdsetBudgetValue = instance.mAdsetBudgetValue;
    this.mAdsetDelivery = instance.mAdsetDelivery;
    this.mAdsetEnd = instance.mAdsetEnd;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mAdsetStart = instance.mAdsetStart;
    this.mAge = instance.mAge;
    this.mAgeTargeting = instance.mAgeTargeting;
    this.mAmountInCatalogCurrency = instance.mAmountInCatalogCurrency;
    this.mAppStoreClicks = instance.mAppStoreClicks;
    this.mAttentionEventsPerImpression = instance.mAttentionEventsPerImpression;
    this.mAttentionEventsUnqPerReach = instance.mAttentionEventsUnqPerReach;
    this.mAuctionBid = instance.mAuctionBid;
    this.mAuctionCompetitiveness = instance.mAuctionCompetitiveness;
    this.mAuctionMaxCompetitorBid = instance.mAuctionMaxCompetitorBid;
    this.mBodyAsset = instance.mBodyAsset;
    this.mBuyingType = instance.mBuyingType;
    this.mCallToActionAsset = instance.mCallToActionAsset;
    this.mCallToActionClicks = instance.mCallToActionClicks;
    this.mCampaignDelivery = instance.mCampaignDelivery;
    this.mCampaignEnd = instance.mCampaignEnd;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCampaignStart = instance.mCampaignStart;
    this.mCancelSubscriptionActions = instance.mCancelSubscriptionActions;
    this.mCanvasAvgViewPercent = instance.mCanvasAvgViewPercent;
    this.mCanvasAvgViewTime = instance.mCanvasAvgViewTime;
    this.mCardViews = instance.mCardViews;
    this.mCatalogSegmentActions = instance.mCatalogSegmentActions;
    this.mCatalogSegmentValueInCatalogCurrency = instance.mCatalogSegmentValueInCatalogCurrency;
    this.mCatalogSegmentValueMobilePurchaseRoas = instance.mCatalogSegmentValueMobilePurchaseRoas;
    this.mCatalogSegmentValueWebsitePurchaseRoas = instance.mCatalogSegmentValueWebsitePurchaseRoas;
    this.mClicks = instance.mClicks;
    this.mConditionalTimeSpentMsOver10sActions = instance.mConditionalTimeSpentMsOver10sActions;
    this.mConditionalTimeSpentMsOver15sActions = instance.mConditionalTimeSpentMsOver15sActions;
    this.mConditionalTimeSpentMsOver2sActions = instance.mConditionalTimeSpentMsOver2sActions;
    this.mConditionalTimeSpentMsOver3sActions = instance.mConditionalTimeSpentMsOver3sActions;
    this.mConditionalTimeSpentMsOver6sActions = instance.mConditionalTimeSpentMsOver6sActions;
    this.mContactActions = instance.mContactActions;
    this.mContactValue = instance.mContactValue;
    this.mConversionRateRanking = instance.mConversionRateRanking;
    this.mConversionValues = instance.mConversionValues;
    this.mConversions = instance.mConversions;
    this.mCostPer10SecVideoView = instance.mCostPer10SecVideoView;
    this.mCostPer15SecVideoView = instance.mCostPer15SecVideoView;
    this.mCostPer2SecContinuousVideoView = instance.mCostPer2SecContinuousVideoView;
    this.mCostPerActionResult = instance.mCostPerActionResult;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerAdClick = instance.mCostPerAdClick;
    this.mCostPerCompletedVideoView = instance.mCostPerCompletedVideoView;
    this.mCostPerContact = instance.mCostPerContact;
    this.mCostPerConversion = instance.mCostPerConversion;
    this.mCostPerCustomizeProduct = instance.mCostPerCustomizeProduct;
    this.mCostPerDdaCountbyConvs = instance.mCostPerDdaCountbyConvs;
    this.mCostPerDonate = instance.mCostPerDonate;
    this.mCostPerDwell = instance.mCostPerDwell;
    this.mCostPerDwell3Sec = instance.mCostPerDwell3Sec;
    this.mCostPerDwell5Sec = instance.mCostPerDwell5Sec;
    this.mCostPerDwell7Sec = instance.mCostPerDwell7Sec;
    this.mCostPerEstimatedAdRecallers = instance.mCostPerEstimatedAdRecallers;
    this.mCostPerFindLocation = instance.mCostPerFindLocation;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerOneThousandAdImpression = instance.mCostPerOneThousandAdImpression;
    this.mCostPerOutboundClick = instance.mCostPerOutboundClick;
    this.mCostPerSchedule = instance.mCostPerSchedule;
    this.mCostPerStartTrial = instance.mCostPerStartTrial;
    this.mCostPerSubmitApplication = instance.mCostPerSubmitApplication;
    this.mCostPerSubscribe = instance.mCostPerSubscribe;
    this.mCostPerThruplay = instance.mCostPerThruplay;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCostPerUniqueConversion = instance.mCostPerUniqueConversion;
    this.mCostPerUniqueInlineLinkClick = instance.mCostPerUniqueInlineLinkClick;
    this.mCostPerUniqueOutboundClick = instance.mCostPerUniqueOutboundClick;
    this.mCountry = instance.mCountry;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeFingerprint = instance.mCreativeFingerprint;
    this.mCtr = instance.mCtr;
    this.mCustomizeProductActions = instance.mCustomizeProductActions;
    this.mCustomizeProductValue = instance.mCustomizeProductValue;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDdaCountbyConvs = instance.mDdaCountbyConvs;
    this.mDeduping1stSourceRatio = instance.mDeduping1stSourceRatio;
    this.mDeduping2ndSourceRatio = instance.mDeduping2ndSourceRatio;
    this.mDeduping3rdSourceRatio = instance.mDeduping3rdSourceRatio;
    this.mDedupingRatio = instance.mDedupingRatio;
    this.mDeeplinkClicks = instance.mDeeplinkClicks;
    this.mDescriptionAsset = instance.mDescriptionAsset;
    this.mDevicePlatform = instance.mDevicePlatform;
    this.mDma = instance.mDma;
    this.mDonateActions = instance.mDonateActions;
    this.mDonateValue = instance.mDonateValue;
    this.mDwell3Sec = instance.mDwell3Sec;
    this.mDwell5Sec = instance.mDwell5Sec;
    this.mDwell7Sec = instance.mDwell7Sec;
    this.mDwellRate = instance.mDwellRate;
    this.mEarnedImpression = instance.mEarnedImpression;
    this.mEngagementRateRanking = instance.mEngagementRateRanking;
    this.mEstimatedAdRecallRate = instance.mEstimatedAdRecallRate;
    this.mEstimatedAdRecallRateLowerBound = instance.mEstimatedAdRecallRateLowerBound;
    this.mEstimatedAdRecallRateUpperBound = instance.mEstimatedAdRecallRateUpperBound;
    this.mEstimatedAdRecallers = instance.mEstimatedAdRecallers;
    this.mEstimatedAdRecallersLowerBound = instance.mEstimatedAdRecallersLowerBound;
    this.mEstimatedAdRecallersUpperBound = instance.mEstimatedAdRecallersUpperBound;
    this.mFindLocationActions = instance.mFindLocationActions;
    this.mFindLocationValue = instance.mFindLocationValue;
    this.mFrequency = instance.mFrequency;
    this.mFrequencyValue = instance.mFrequencyValue;
    this.mFullViewImpressions = instance.mFullViewImpressions;
    this.mFullViewReach = instance.mFullViewReach;
    this.mGender = instance.mGender;
    this.mGenderTargeting = instance.mGenderTargeting;
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = instance.mHourlyStatsAggregatedByAdvertiserTimeZone;
    this.mHourlyStatsAggregatedByAudienceTimeZone = instance.mHourlyStatsAggregatedByAudienceTimeZone;
    this.mImageAsset = instance.mImageAsset;
    this.mImpressionDevice = instance.mImpressionDevice;
    this.mImpressions = instance.mImpressions;
    this.mImpressionsAutoRefresh = instance.mImpressionsAutoRefresh;
    this.mImpressionsGross = instance.mImpressionsGross;
    this.mInlineLinkClickCtr = instance.mInlineLinkClickCtr;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mInstantExperienceClicksToOpen = instance.mInstantExperienceClicksToOpen;
    this.mInstantExperienceClicksToStart = instance.mInstantExperienceClicksToStart;
    this.mInstantExperienceOutboundClicks = instance.mInstantExperienceOutboundClicks;
    this.mInteractiveComponentTap = instance.mInteractiveComponentTap;
    this.mLabels = instance.mLabels;
    this.mLinkUrlAsset = instance.mLinkUrlAsset;
    this.mLocation = instance.mLocation;
    this.mMediaAsset = instance.mMediaAsset;
    this.mMobileAppPurchaseRoas = instance.mMobileAppPurchaseRoas;
    this.mNewsfeedAvgPosition = instance.mNewsfeedAvgPosition;
    this.mNewsfeedClicks = instance.mNewsfeedClicks;
    this.mNewsfeedImpressions = instance.mNewsfeedImpressions;
    this.mObjective = instance.mObjective;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mOutboundClicks = instance.mOutboundClicks;
    this.mOutboundClicksCtr = instance.mOutboundClicksCtr;
    this.mPerformanceIndicator = instance.mPerformanceIndicator;
    this.mPlacePageId = instance.mPlacePageId;
    this.mPlacePageName = instance.mPlacePageName;
    this.mPlacement = instance.mPlacement;
    this.mPlatformPosition = instance.mPlatformPosition;
    this.mProductId = instance.mProductId;
    this.mPublisherPlatform = instance.mPublisherPlatform;
    this.mPurchaseRoas = instance.mPurchaseRoas;
    this.mQualityRanking = instance.mQualityRanking;
    this.mQualityScoreEctr = instance.mQualityScoreEctr;
    this.mQualityScoreEcvr = instance.mQualityScoreEcvr;
    this.mQualityScoreEnfbr = instance.mQualityScoreEnfbr;
    this.mQualityScoreOrganic = instance.mQualityScoreOrganic;
    this.mReach = instance.mReach;
    this.mRecurringSubscriptionPaymentActions = instance.mRecurringSubscriptionPaymentActions;
    this.mRegion = instance.mRegion;
    this.mRelevanceScore = instance.mRelevanceScore;
    this.mRuleAsset = instance.mRuleAsset;
    this.mScheduleActions = instance.mScheduleActions;
    this.mScheduleValue = instance.mScheduleValue;
    this.mSocialSpend = instance.mSocialSpend;
    this.mSpend = instance.mSpend;
    this.mStartTrialActions = instance.mStartTrialActions;
    this.mStartTrialValue = instance.mStartTrialValue;
    this.mSubmitApplicationActions = instance.mSubmitApplicationActions;
    this.mSubmitApplicationValue = instance.mSubmitApplicationValue;
    this.mSubscribeActions = instance.mSubscribeActions;
    this.mSubscribeValue = instance.mSubscribeValue;
    this.mThumbStops = instance.mThumbStops;
    this.mTitleAsset = instance.mTitleAsset;
    this.mTodaySpend = instance.mTodaySpend;
    this.mTotalActionValue = instance.mTotalActionValue;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueConversions = instance.mUniqueConversions;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.mUniqueInlineLinkClickCtr = instance.mUniqueInlineLinkClickCtr;
    this.mUniqueInlineLinkClicks = instance.mUniqueInlineLinkClicks;
    this.mUniqueLinkClicksCtr = instance.mUniqueLinkClicksCtr;
    this.mUniqueOutboundClicks = instance.mUniqueOutboundClicks;
    this.mUniqueOutboundClicksCtr = instance.mUniqueOutboundClicksCtr;
    this.mUniqueVideoContinuous2SecWatchedActions = instance.mUniqueVideoContinuous2SecWatchedActions;
    this.mUniqueVideoView10Sec = instance.mUniqueVideoView10Sec;
    this.mUniqueVideoView15Sec = instance.mUniqueVideoView15Sec;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVideo10SecWatchedActions = instance.mVideo10SecWatchedActions;
    this.mVideo15SecWatchedActions = instance.mVideo15SecWatchedActions;
    this.mVideo30SecWatchedActions = instance.mVideo30SecWatchedActions;
    this.mVideoAsset = instance.mVideoAsset;
    this.mVideoAvgTimeWatchedActions = instance.mVideoAvgTimeWatchedActions;
    this.mVideoCompleteWatchedActions = instance.mVideoCompleteWatchedActions;
    this.mVideoCompletedViewOr15sPassedActions = instance.mVideoCompletedViewOr15sPassedActions;
    this.mVideoContinuous2SecWatchedActions = instance.mVideoContinuous2SecWatchedActions;
    this.mVideoP100WatchedActions = instance.mVideoP100WatchedActions;
    this.mVideoP25WatchedActions = instance.mVideoP25WatchedActions;
    this.mVideoP50WatchedActions = instance.mVideoP50WatchedActions;
    this.mVideoP75WatchedActions = instance.mVideoP75WatchedActions;
    this.mVideoP95WatchedActions = instance.mVideoP95WatchedActions;
    this.mVideoPlayActions = instance.mVideoPlayActions;
    this.mVideoPlayCurveActions = instance.mVideoPlayCurveActions;
    this.mVideoPlayRetention0To15sActions = instance.mVideoPlayRetention0To15sActions;
    this.mVideoPlayRetention20To60sActions = instance.mVideoPlayRetention20To60sActions;
    this.mVideoPlayRetentionGraphActions = instance.mVideoPlayRetentionGraphActions;
    this.mVideoThruplayWatchedActions = instance.mVideoThruplayWatchedActions;
    this.mVideoTimeWatchedActions = instance.mVideoTimeWatchedActions;
    this.mWebsiteClicks = instance.mWebsiteClicks;
    this.mWebsiteCtr = instance.mWebsiteCtr;
    this.mWebsitePurchaseRoas = instance.mWebsitePurchaseRoas;
    this.mWishBid = instance.mWishBid;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsInsights> getParser() {
    return new APIRequest.ResponseParser<AdsInsights>() {
      public APINodeList<AdsInsights> parseResponse(String response, APIContext context, APIRequest<AdsInsights> request, String header) throws MalformedResponseException {
        return AdsInsights.parseResponse(response, context, request, header);
      }
    };
  }
}
