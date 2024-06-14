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
  @SerializedName("ad_click_actions")
  private List<AdsActionStats> mAdClickActions = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_impression_actions")
  private List<AdsActionStats> mAdImpressionActions = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adjusted_offline_purchase")
  private List<Object> mAdjustedOfflinePurchase = null;
  @SerializedName("adset_end")
  private String mAdsetEnd = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("adset_start")
  private String mAdsetStart = null;
  @SerializedName("age_targeting")
  private String mAgeTargeting = null;
  @SerializedName("attribution_setting")
  private String mAttributionSetting = null;
  @SerializedName("auction_bid")
  private String mAuctionBid = null;
  @SerializedName("auction_competitiveness")
  private String mAuctionCompetitiveness = null;
  @SerializedName("auction_max_competitor_bid")
  private String mAuctionMaxCompetitorBid = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("canvas_avg_view_percent")
  private String mCanvasAvgViewPercent = null;
  @SerializedName("canvas_avg_view_time")
  private String mCanvasAvgViewTime = null;
  @SerializedName("catalog_segment_actions")
  private List<AdsActionStats> mCatalogSegmentActions = null;
  @SerializedName("catalog_segment_value")
  private List<AdsActionStats> mCatalogSegmentValue = null;
  @SerializedName("catalog_segment_value_mobile_purchase_roas")
  private List<AdsActionStats> mCatalogSegmentValueMobilePurchaseRoas = null;
  @SerializedName("catalog_segment_value_omni_purchase_roas")
  private List<AdsActionStats> mCatalogSegmentValueOmniPurchaseRoas = null;
  @SerializedName("catalog_segment_value_website_purchase_roas")
  private List<AdsActionStats> mCatalogSegmentValueWebsitePurchaseRoas = null;
  @SerializedName("clicks")
  private String mClicks = null;
  @SerializedName("conversion_rate_ranking")
  private String mConversionRateRanking = null;
  @SerializedName("conversion_values")
  private List<AdsActionStats> mConversionValues = null;
  @SerializedName("conversions")
  private List<AdsActionStats> mConversions = null;
  @SerializedName("converted_product_quantity")
  private List<AdsActionStats> mConvertedProductQuantity = null;
  @SerializedName("converted_product_value")
  private List<AdsActionStats> mConvertedProductValue = null;
  @SerializedName("cost_per_15_sec_video_view")
  private List<AdsActionStats> mCostPer15SecVideoView = null;
  @SerializedName("cost_per_2_sec_continuous_video_view")
  private List<AdsActionStats> mCostPer2SecContinuousVideoView = null;
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_ad_click")
  private List<AdsActionStats> mCostPerAdClick = null;
  @SerializedName("cost_per_conversion")
  private List<AdsActionStats> mCostPerConversion = null;
  @SerializedName("cost_per_dda_countby_convs")
  private String mCostPerDdaCountbyConvs = null;
  @SerializedName("cost_per_estimated_ad_recallers")
  private String mCostPerEstimatedAdRecallers = null;
  @SerializedName("cost_per_inline_link_click")
  private String mCostPerInlineLinkClick = null;
  @SerializedName("cost_per_inline_post_engagement")
  private String mCostPerInlinePostEngagement = null;
  @SerializedName("cost_per_one_thousand_ad_impression")
  private List<AdsActionStats> mCostPerOneThousandAdImpression = null;
  @SerializedName("cost_per_outbound_click")
  private List<AdsActionStats> mCostPerOutboundClick = null;
  @SerializedName("cost_per_thruplay")
  private List<AdsActionStats> mCostPerThruplay = null;
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
  @SerializedName("cpc")
  private String mCpc = null;
  @SerializedName("cpm")
  private String mCpm = null;
  @SerializedName("cpp")
  private String mCpp = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative_media_type")
  private String mCreativeMediaType = null;
  @SerializedName("ctr")
  private String mCtr = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("dda_countby_convs")
  private String mDdaCountbyConvs = null;
  @SerializedName("dda_results")
  private List<Object> mDdaResults = null;
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
  @SerializedName("frequency")
  private String mFrequency = null;
  @SerializedName("full_view_impressions")
  private String mFullViewImpressions = null;
  @SerializedName("full_view_reach")
  private String mFullViewReach = null;
  @SerializedName("gender_targeting")
  private String mGenderTargeting = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("inline_link_click_ctr")
  private String mInlineLinkClickCtr = null;
  @SerializedName("inline_link_clicks")
  private String mInlineLinkClicks = null;
  @SerializedName("inline_post_engagement")
  private String mInlinePostEngagement = null;
  @SerializedName("instagram_upcoming_event_reminders_set")
  private String mInstagramUpcomingEventRemindersSet = null;
  @SerializedName("instant_experience_clicks_to_open")
  private String mInstantExperienceClicksToOpen = null;
  @SerializedName("instant_experience_clicks_to_start")
  private String mInstantExperienceClicksToStart = null;
  @SerializedName("instant_experience_outbound_clicks")
  private List<AdsActionStats> mInstantExperienceOutboundClicks = null;
  @SerializedName("interactive_component_tap")
  private List<AdsActionStats> mInteractiveComponentTap = null;
  @SerializedName("labels")
  private String mLabels = null;
  @SerializedName("location")
  private String mLocation = null;
  @SerializedName("marketing_messages_cost_per_delivered")
  private String mMarketingMessagesCostPerDelivered = null;
  @SerializedName("marketing_messages_cost_per_link_btn_click")
  private String mMarketingMessagesCostPerLinkBtnClick = null;
  @SerializedName("marketing_messages_spend")
  private String mMarketingMessagesSpend = null;
  @SerializedName("marketing_messages_website_purchase_values")
  private String mMarketingMessagesWebsitePurchaseValues = null;
  @SerializedName("mobile_app_purchase_roas")
  private List<AdsActionStats> mMobileAppPurchaseRoas = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("onsite_conversion_messaging_detected_purchase_deduped")
  private List<AdsActionStats> mOnsiteConversionMessagingDetectedPurchaseDeduped = null;
  @SerializedName("optimization_goal")
  private String mOptimizationGoal = null;
  @SerializedName("outbound_clicks")
  private List<AdsActionStats> mOutboundClicks = null;
  @SerializedName("outbound_clicks_ctr")
  private List<AdsActionStats> mOutboundClicksCtr = null;
  @SerializedName("place_page_name")
  private String mPlacePageName = null;
  @SerializedName("purchase_roas")
  private List<AdsActionStats> mPurchaseRoas = null;
  @SerializedName("qualifying_question_qualify_answer_rate")
  private String mQualifyingQuestionQualifyAnswerRate = null;
  @SerializedName("quality_ranking")
  private String mQualityRanking = null;
  @SerializedName("reach")
  private String mReach = null;
  @SerializedName("shops_assisted_purchases")
  private String mShopsAssistedPurchases = null;
  @SerializedName("social_spend")
  private String mSocialSpend = null;
  @SerializedName("spend")
  private String mSpend = null;
  @SerializedName("total_postbacks")
  private String mTotalPostbacks = null;
  @SerializedName("total_postbacks_detailed")
  private List<AdsActionStats> mTotalPostbacksDetailed = null;
  @SerializedName("total_postbacks_detailed_v4")
  private List<AdsActionStats> mTotalPostbacksDetailedV4 = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private String mUniqueClicks = null;
  @SerializedName("unique_conversions")
  private List<AdsActionStats> mUniqueConversions = null;
  @SerializedName("unique_ctr")
  private String mUniqueCtr = null;
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
  @SerializedName("unique_video_view_15_sec")
  private List<AdsActionStats> mUniqueVideoView15Sec = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("video_15_sec_watched_actions")
  private List<AdsActionStats> mVideo15SecWatchedActions = null;
  @SerializedName("video_30_sec_watched_actions")
  private List<AdsActionStats> mVideo30SecWatchedActions = null;
  @SerializedName("video_avg_time_watched_actions")
  private List<AdsActionStats> mVideoAvgTimeWatchedActions = null;
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
  private List<AdsHistogramStats> mVideoPlayCurveActions = null;
  @SerializedName("video_play_retention_0_to_15s_actions")
  private List<AdsHistogramStats> mVideoPlayRetention0To15sActions = null;
  @SerializedName("video_play_retention_20_to_60s_actions")
  private List<AdsHistogramStats> mVideoPlayRetention20To60sActions = null;
  @SerializedName("video_play_retention_graph_actions")
  private List<AdsHistogramStats> mVideoPlayRetentionGraphActions = null;
  @SerializedName("video_thruplay_watched_actions")
  private List<AdsActionStats> mVideoThruplayWatchedActions = null;
  @SerializedName("video_time_watched_actions")
  private List<AdsActionStats> mVideoTimeWatchedActions = null;
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  @SerializedName("website_purchase_roas")
  private List<AdsActionStats> mWebsitePurchaseRoas = null;
  @SerializedName("wish_bid")
  private String mWishBid = null;
  // Breakdowns
  @SerializedName("ad_format_asset")
  private String mAdFormatAsset = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("body_asset")
  private AdAssetBody mBodyAsset = null;
  @SerializedName("call_to_action_asset")
  private AdAssetCallToActionType mCallToActionAsset = null;
  @SerializedName("coarse_conversion_value")
  private String mCoarseConversionValue = null;
  @SerializedName("conversion_destination")
  private String mConversionDestination = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("description_asset")
  private AdAssetDescription mDescriptionAsset = null;
  @SerializedName("device_platform")
  private String mDevicePlatform = null;
  @SerializedName("dma")
  private String mDma = null;
  @SerializedName("fidelity_type")
  private String mFidelityType = null;
  @SerializedName("frequency_value")
  private String mFrequencyValue = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
  private String mHourlyStatsAggregatedByAdvertiserTimeZone = null;
  @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
  private String mHourlyStatsAggregatedByAudienceTimeZone = null;
  @SerializedName("hsid")
  private String mHsid = null;
  @SerializedName("image_asset")
  private AdAssetImage mImageAsset = null;
  @SerializedName("impression_device")
  private String mImpressionDevice = null;
  @SerializedName("is_conversion_id_modeled")
  private String mIsConversionIdModeled = null;
  @SerializedName("landing_destination")
  private String mLandingDestination = null;
  @SerializedName("link_url_asset")
  private AdAssetLinkURL mLinkUrlAsset = null;
  @SerializedName("marketing_messages_btn_name")
  private String mMarketingMessagesBtnName = null;
  @SerializedName("mdsa_landing_destination")
  private String mMdsaLandingDestination = null;
  @SerializedName("media_asset_url")
  private String mMediaAssetUrl = null;
  @SerializedName("media_creator")
  private String mMediaCreator = null;
  @SerializedName("media_destination_url")
  private String mMediaDestinationUrl = null;
  @SerializedName("media_format")
  private String mMediaFormat = null;
  @SerializedName("media_origin_url")
  private String mMediaOriginUrl = null;
  @SerializedName("media_text_content")
  private String mMediaTextContent = null;
  @SerializedName("mmm")
  private String mMmm = null;
  @SerializedName("place_page_id")
  private String mPlacePageId = null;
  @SerializedName("platform_position")
  private String mPlatformPosition = null;
  @SerializedName("postback_sequence_index")
  private String mPostbackSequenceIndex = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("publisher_platform")
  private String mPublisherPlatform = null;
  @SerializedName("redownload")
  private String mRedownload = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("signal_source_bucket")
  private String mSignalSourceBucket = null;
  @SerializedName("skan_campaign_id")
  private String mSkanCampaignId = null;
  @SerializedName("skan_conversion_id")
  private String mSkanConversionId = null;
  @SerializedName("skan_version")
  private String mSkanVersion = null;
  @SerializedName("standard_event_content_type")
  private String mStandardEventContentType = null;
  @SerializedName("title_asset")
  private AdAssetTitle mTitleAsset = null;
  @SerializedName("user_persona_id")
  private String mUserPersonaId = null;
  @SerializedName("user_persona_name")
  private String mUserPersonaName = null;
  @SerializedName("video_asset")
  private AdAssetVideo mVideoAsset = null;
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
      }
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

  public List<Object> getFieldAdjustedOfflinePurchase() {
    return mAdjustedOfflinePurchase;
  }

  public AdsInsights setFieldAdjustedOfflinePurchase(List<Object> value) {
    this.mAdjustedOfflinePurchase = value;
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

  public String getFieldAgeTargeting() {
    return mAgeTargeting;
  }

  public AdsInsights setFieldAgeTargeting(String value) {
    this.mAgeTargeting = value;
    return this;
  }

  public String getFieldAttributionSetting() {
    return mAttributionSetting;
  }

  public AdsInsights setFieldAttributionSetting(String value) {
    this.mAttributionSetting = value;
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

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public AdsInsights setFieldBuyingType(String value) {
    this.mBuyingType = value;
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
  public List<AdsActionStats> getFieldCatalogSegmentValue() {
    return mCatalogSegmentValue;
  }

  public AdsInsights setFieldCatalogSegmentValue(List<AdsActionStats> value) {
    this.mCatalogSegmentValue = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentValue = AdsActionStats.getGson().fromJson(value, type);
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
  public List<AdsActionStats> getFieldCatalogSegmentValueOmniPurchaseRoas() {
    return mCatalogSegmentValueOmniPurchaseRoas;
  }

  public AdsInsights setFieldCatalogSegmentValueOmniPurchaseRoas(List<AdsActionStats> value) {
    this.mCatalogSegmentValueOmniPurchaseRoas = value;
    return this;
  }

  public AdsInsights setFieldCatalogSegmentValueOmniPurchaseRoas(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCatalogSegmentValueOmniPurchaseRoas = AdsActionStats.getGson().fromJson(value, type);
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
  public List<AdsActionStats> getFieldConvertedProductQuantity() {
    return mConvertedProductQuantity;
  }

  public AdsInsights setFieldConvertedProductQuantity(List<AdsActionStats> value) {
    this.mConvertedProductQuantity = value;
    return this;
  }

  public AdsInsights setFieldConvertedProductQuantity(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConvertedProductQuantity = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldConvertedProductValue() {
    return mConvertedProductValue;
  }

  public AdsInsights setFieldConvertedProductValue(List<AdsActionStats> value) {
    this.mConvertedProductValue = value;
    return this;
  }

  public AdsInsights setFieldConvertedProductValue(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mConvertedProductValue = AdsActionStats.getGson().fromJson(value, type);
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
  public String getFieldCostPerDdaCountbyConvs() {
    return mCostPerDdaCountbyConvs;
  }

  public AdsInsights setFieldCostPerDdaCountbyConvs(String value) {
    this.mCostPerDdaCountbyConvs = value;
    return this;
  }

  public String getFieldCostPerEstimatedAdRecallers() {
    return mCostPerEstimatedAdRecallers;
  }

  public AdsInsights setFieldCostPerEstimatedAdRecallers(String value) {
    this.mCostPerEstimatedAdRecallers = value;
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

  public String getFieldCreativeMediaType() {
    return mCreativeMediaType;
  }

  public AdsInsights setFieldCreativeMediaType(String value) {
    this.mCreativeMediaType = value;
    return this;
  }

  public String getFieldCtr() {
    return mCtr;
  }

  public AdsInsights setFieldCtr(String value) {
    this.mCtr = value;
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

  public List<Object> getFieldDdaResults() {
    return mDdaResults;
  }

  public AdsInsights setFieldDdaResults(List<Object> value) {
    this.mDdaResults = value;
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

  public String getFieldFrequency() {
    return mFrequency;
  }

  public AdsInsights setFieldFrequency(String value) {
    this.mFrequency = value;
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

  public String getFieldGenderTargeting() {
    return mGenderTargeting;
  }

  public AdsInsights setFieldGenderTargeting(String value) {
    this.mGenderTargeting = value;
    return this;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public AdsInsights setFieldImpressions(String value) {
    this.mImpressions = value;
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

  public String getFieldInstagramUpcomingEventRemindersSet() {
    return mInstagramUpcomingEventRemindersSet;
  }

  public AdsInsights setFieldInstagramUpcomingEventRemindersSet(String value) {
    this.mInstagramUpcomingEventRemindersSet = value;
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

  public List<AdsActionStats> getFieldInstantExperienceOutboundClicks() {
    return mInstantExperienceOutboundClicks;
  }

  public AdsInsights setFieldInstantExperienceOutboundClicks(List<AdsActionStats> value) {
    this.mInstantExperienceOutboundClicks = value;
    return this;
  }

  public AdsInsights setFieldInstantExperienceOutboundClicks(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mInstantExperienceOutboundClicks = AdsActionStats.getGson().fromJson(value, type);
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

  public String getFieldLocation() {
    return mLocation;
  }

  public AdsInsights setFieldLocation(String value) {
    this.mLocation = value;
    return this;
  }

  public String getFieldMarketingMessagesCostPerDelivered() {
    return mMarketingMessagesCostPerDelivered;
  }

  public AdsInsights setFieldMarketingMessagesCostPerDelivered(String value) {
    this.mMarketingMessagesCostPerDelivered = value;
    return this;
  }

  public String getFieldMarketingMessagesCostPerLinkBtnClick() {
    return mMarketingMessagesCostPerLinkBtnClick;
  }

  public AdsInsights setFieldMarketingMessagesCostPerLinkBtnClick(String value) {
    this.mMarketingMessagesCostPerLinkBtnClick = value;
    return this;
  }

  public String getFieldMarketingMessagesSpend() {
    return mMarketingMessagesSpend;
  }

  public AdsInsights setFieldMarketingMessagesSpend(String value) {
    this.mMarketingMessagesSpend = value;
    return this;
  }

  public String getFieldMarketingMessagesWebsitePurchaseValues() {
    return mMarketingMessagesWebsitePurchaseValues;
  }

  public AdsInsights setFieldMarketingMessagesWebsitePurchaseValues(String value) {
    this.mMarketingMessagesWebsitePurchaseValues = value;
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
  public String getFieldObjective() {
    return mObjective;
  }

  public AdsInsights setFieldObjective(String value) {
    this.mObjective = value;
    return this;
  }

  public List<AdsActionStats> getFieldOnsiteConversionMessagingDetectedPurchaseDeduped() {
    return mOnsiteConversionMessagingDetectedPurchaseDeduped;
  }

  public AdsInsights setFieldOnsiteConversionMessagingDetectedPurchaseDeduped(List<AdsActionStats> value) {
    this.mOnsiteConversionMessagingDetectedPurchaseDeduped = value;
    return this;
  }

  public AdsInsights setFieldOnsiteConversionMessagingDetectedPurchaseDeduped(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mOnsiteConversionMessagingDetectedPurchaseDeduped = AdsActionStats.getGson().fromJson(value, type);
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
  public String getFieldPlacePageName() {
    return mPlacePageName;
  }

  public AdsInsights setFieldPlacePageName(String value) {
    this.mPlacePageName = value;
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
  public String getFieldQualifyingQuestionQualifyAnswerRate() {
    return mQualifyingQuestionQualifyAnswerRate;
  }

  public AdsInsights setFieldQualifyingQuestionQualifyAnswerRate(String value) {
    this.mQualifyingQuestionQualifyAnswerRate = value;
    return this;
  }

  public String getFieldQualityRanking() {
    return mQualityRanking;
  }

  public AdsInsights setFieldQualityRanking(String value) {
    this.mQualityRanking = value;
    return this;
  }

  public String getFieldReach() {
    return mReach;
  }

  public AdsInsights setFieldReach(String value) {
    this.mReach = value;
    return this;
  }

  public String getFieldShopsAssistedPurchases() {
    return mShopsAssistedPurchases;
  }

  public AdsInsights setFieldShopsAssistedPurchases(String value) {
    this.mShopsAssistedPurchases = value;
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

  public String getFieldTotalPostbacks() {
    return mTotalPostbacks;
  }

  public AdsInsights setFieldTotalPostbacks(String value) {
    this.mTotalPostbacks = value;
    return this;
  }

  public List<AdsActionStats> getFieldTotalPostbacksDetailed() {
    return mTotalPostbacksDetailed;
  }

  public AdsInsights setFieldTotalPostbacksDetailed(List<AdsActionStats> value) {
    this.mTotalPostbacksDetailed = value;
    return this;
  }

  public AdsInsights setFieldTotalPostbacksDetailed(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mTotalPostbacksDetailed = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldTotalPostbacksDetailedV4() {
    return mTotalPostbacksDetailedV4;
  }

  public AdsInsights setFieldTotalPostbacksDetailedV4(List<AdsActionStats> value) {
    this.mTotalPostbacksDetailedV4 = value;
    return this;
  }

  public AdsInsights setFieldTotalPostbacksDetailedV4(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mTotalPostbacksDetailedV4 = AdsActionStats.getGson().fromJson(value, type);
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
  public List<AdsHistogramStats> getFieldVideoPlayCurveActions() {
    return mVideoPlayCurveActions;
  }

  public AdsInsights setFieldVideoPlayCurveActions(List<AdsHistogramStats> value) {
    this.mVideoPlayCurveActions = value;
    return this;
  }

  public AdsInsights setFieldVideoPlayCurveActions(String value) {
    Type type = new TypeToken<List<AdsHistogramStats>>(){}.getType();
    this.mVideoPlayCurveActions = AdsHistogramStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsHistogramStats> getFieldVideoPlayRetention0To15sActions() {
    return mVideoPlayRetention0To15sActions;
  }

  public AdsInsights setFieldVideoPlayRetention0To15sActions(List<AdsHistogramStats> value) {
    this.mVideoPlayRetention0To15sActions = value;
    return this;
  }

  public AdsInsights setFieldVideoPlayRetention0To15sActions(String value) {
    Type type = new TypeToken<List<AdsHistogramStats>>(){}.getType();
    this.mVideoPlayRetention0To15sActions = AdsHistogramStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsHistogramStats> getFieldVideoPlayRetention20To60sActions() {
    return mVideoPlayRetention20To60sActions;
  }

  public AdsInsights setFieldVideoPlayRetention20To60sActions(List<AdsHistogramStats> value) {
    this.mVideoPlayRetention20To60sActions = value;
    return this;
  }

  public AdsInsights setFieldVideoPlayRetention20To60sActions(String value) {
    Type type = new TypeToken<List<AdsHistogramStats>>(){}.getType();
    this.mVideoPlayRetention20To60sActions = AdsHistogramStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsHistogramStats> getFieldVideoPlayRetentionGraphActions() {
    return mVideoPlayRetentionGraphActions;
  }

  public AdsInsights setFieldVideoPlayRetentionGraphActions(List<AdsHistogramStats> value) {
    this.mVideoPlayRetentionGraphActions = value;
    return this;
  }

  public AdsInsights setFieldVideoPlayRetentionGraphActions(String value) {
    Type type = new TypeToken<List<AdsHistogramStats>>(){}.getType();
    this.mVideoPlayRetentionGraphActions = AdsHistogramStats.getGson().fromJson(value, type);
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

  public String getFieldAdFormatAsset() {
    return mAdFormatAsset;
  }

  public String getFieldAge() {
    return mAge;
  }

  public String getFieldAppId() {
    return mAppId;
  }

  public AdAssetBody getFieldBodyAsset() {
    return mBodyAsset;
  }

  public AdAssetCallToActionType getFieldCallToActionAsset() {
    return mCallToActionAsset;
  }

  public String getFieldCoarseConversionValue() {
    return mCoarseConversionValue;
  }

  public String getFieldConversionDestination() {
    return mConversionDestination;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public AdAssetDescription getFieldDescriptionAsset() {
    return mDescriptionAsset;
  }

  public String getFieldDevicePlatform() {
    return mDevicePlatform;
  }

  public String getFieldDma() {
    return mDma;
  }

  public String getFieldFidelityType() {
    return mFidelityType;
  }

  public String getFieldFrequencyValue() {
    return mFrequencyValue;
  }

  public String getFieldGender() {
    return mGender;
  }

  public String getFieldHourlyStatsAggregatedByAdvertiserTimeZone() {
    return mHourlyStatsAggregatedByAdvertiserTimeZone;
  }

  public String getFieldHourlyStatsAggregatedByAudienceTimeZone() {
    return mHourlyStatsAggregatedByAudienceTimeZone;
  }

  public String getFieldHsid() {
    return mHsid;
  }

  public AdAssetImage getFieldImageAsset() {
    return mImageAsset;
  }

  public String getFieldImpressionDevice() {
    return mImpressionDevice;
  }

  public String getFieldIsConversionIdModeled() {
    return mIsConversionIdModeled;
  }

  public String getFieldLandingDestination() {
    return mLandingDestination;
  }

  public AdAssetLinkURL getFieldLinkUrlAsset() {
    return mLinkUrlAsset;
  }

  public String getFieldMarketingMessagesBtnName() {
    return mMarketingMessagesBtnName;
  }

  public String getFieldMdsaLandingDestination() {
    return mMdsaLandingDestination;
  }

  public String getFieldMediaAssetUrl() {
    return mMediaAssetUrl;
  }

  public String getFieldMediaCreator() {
    return mMediaCreator;
  }

  public String getFieldMediaDestinationUrl() {
    return mMediaDestinationUrl;
  }

  public String getFieldMediaFormat() {
    return mMediaFormat;
  }

  public String getFieldMediaOriginUrl() {
    return mMediaOriginUrl;
  }

  public String getFieldMediaTextContent() {
    return mMediaTextContent;
  }

  public String getFieldMmm() {
    return mMmm;
  }

  public String getFieldPlacePageId() {
    return mPlacePageId;
  }

  public String getFieldPlatformPosition() {
    return mPlatformPosition;
  }

  public String getFieldPostbackSequenceIndex() {
    return mPostbackSequenceIndex;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public String getFieldPublisherPlatform() {
    return mPublisherPlatform;
  }

  public String getFieldRedownload() {
    return mRedownload;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public String getFieldSignalSourceBucket() {
    return mSignalSourceBucket;
  }

  public String getFieldSkanCampaignId() {
    return mSkanCampaignId;
  }

  public String getFieldSkanConversionId() {
    return mSkanConversionId;
  }

  public String getFieldSkanVersion() {
    return mSkanVersion;
  }

  public String getFieldStandardEventContentType() {
    return mStandardEventContentType;
  }

  public AdAssetTitle getFieldTitleAsset() {
    return mTitleAsset;
  }

  public String getFieldUserPersonaId() {
    return mUserPersonaId;
  }

  public String getFieldUserPersonaName() {
    return mUserPersonaName;
  }

  public AdAssetVideo getFieldVideoAsset() {
    return mVideoAsset;
  }



  public static enum EnumActionAttributionWindows {
      @SerializedName("1d_click")
      VALUE_1D_CLICK("1d_click"),
      @SerializedName("1d_ev")
      VALUE_1D_EV("1d_ev"),
      @SerializedName("1d_view")
      VALUE_1D_VIEW("1d_view"),
      @SerializedName("28d_click")
      VALUE_28D_CLICK("28d_click"),
      @SerializedName("28d_view")
      VALUE_28D_VIEW("28d_view"),
      @SerializedName("28d_view_all_conversions")
      VALUE_28D_VIEW_ALL_CONVERSIONS("28d_view_all_conversions"),
      @SerializedName("28d_view_first_conversion")
      VALUE_28D_VIEW_FIRST_CONVERSION("28d_view_first_conversion"),
      @SerializedName("7d_click")
      VALUE_7D_CLICK("7d_click"),
      @SerializedName("7d_view")
      VALUE_7D_VIEW("7d_view"),
      @SerializedName("7d_view_all_conversions")
      VALUE_7D_VIEW_ALL_CONVERSIONS("7d_view_all_conversions"),
      @SerializedName("7d_view_first_conversion")
      VALUE_7D_VIEW_FIRST_CONVERSION("7d_view_first_conversion"),
      @SerializedName("dda")
      VALUE_DDA("dda"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      @SerializedName("skan_click")
      VALUE_SKAN_CLICK("skan_click"),
      @SerializedName("skan_view")
      VALUE_SKAN_VIEW("skan_view"),
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
      @SerializedName("conversion_destination")
      VALUE_CONVERSION_DESTINATION("conversion_destination"),
      @SerializedName("matched_persona_id")
      VALUE_MATCHED_PERSONA_ID("matched_persona_id"),
      @SerializedName("matched_persona_name")
      VALUE_MATCHED_PERSONA_NAME("matched_persona_name"),
      @SerializedName("signal_source_bucket")
      VALUE_SIGNAL_SOURCE_BUCKET("signal_source_bucket"),
      @SerializedName("standard_event_content_type")
      VALUE_STANDARD_EVENT_CONTENT_TYPE("standard_event_content_type"),
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
      @SerializedName("mixed")
      VALUE_MIXED("mixed"),
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
      @SerializedName("app_id")
      VALUE_APP_ID("app_id"),
      @SerializedName("body_asset")
      VALUE_BODY_ASSET("body_asset"),
      @SerializedName("call_to_action_asset")
      VALUE_CALL_TO_ACTION_ASSET("call_to_action_asset"),
      @SerializedName("coarse_conversion_value")
      VALUE_COARSE_CONVERSION_VALUE("coarse_conversion_value"),
      @SerializedName("conversion_destination")
      VALUE_CONVERSION_DESTINATION("conversion_destination"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("description_asset")
      VALUE_DESCRIPTION_ASSET("description_asset"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("dma")
      VALUE_DMA("dma"),
      @SerializedName("fidelity_type")
      VALUE_FIDELITY_TYPE("fidelity_type"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
      @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
      @SerializedName("hsid")
      VALUE_HSID("hsid"),
      @SerializedName("image_asset")
      VALUE_IMAGE_ASSET("image_asset"),
      @SerializedName("impression_device")
      VALUE_IMPRESSION_DEVICE("impression_device"),
      @SerializedName("is_conversion_id_modeled")
      VALUE_IS_CONVERSION_ID_MODELED("is_conversion_id_modeled"),
      @SerializedName("landing_destination")
      VALUE_LANDING_DESTINATION("landing_destination"),
      @SerializedName("link_url_asset")
      VALUE_LINK_URL_ASSET("link_url_asset"),
      @SerializedName("marketing_messages_btn_name")
      VALUE_MARKETING_MESSAGES_BTN_NAME("marketing_messages_btn_name"),
      @SerializedName("mdsa_landing_destination")
      VALUE_MDSA_LANDING_DESTINATION("mdsa_landing_destination"),
      @SerializedName("media_asset_url")
      VALUE_MEDIA_ASSET_URL("media_asset_url"),
      @SerializedName("media_creator")
      VALUE_MEDIA_CREATOR("media_creator"),
      @SerializedName("media_destination_url")
      VALUE_MEDIA_DESTINATION_URL("media_destination_url"),
      @SerializedName("media_format")
      VALUE_MEDIA_FORMAT("media_format"),
      @SerializedName("media_origin_url")
      VALUE_MEDIA_ORIGIN_URL("media_origin_url"),
      @SerializedName("media_text_content")
      VALUE_MEDIA_TEXT_CONTENT("media_text_content"),
      @SerializedName("mmm")
      VALUE_MMM("mmm"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("platform_position")
      VALUE_PLATFORM_POSITION("platform_position"),
      @SerializedName("postback_sequence_index")
      VALUE_POSTBACK_SEQUENCE_INDEX("postback_sequence_index"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("publisher_platform")
      VALUE_PUBLISHER_PLATFORM("publisher_platform"),
      @SerializedName("redownload")
      VALUE_REDOWNLOAD("redownload"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("signal_source_bucket")
      VALUE_SIGNAL_SOURCE_BUCKET("signal_source_bucket"),
      @SerializedName("skan_campaign_id")
      VALUE_SKAN_CAMPAIGN_ID("skan_campaign_id"),
      @SerializedName("skan_conversion_id")
      VALUE_SKAN_CONVERSION_ID("skan_conversion_id"),
      @SerializedName("skan_version")
      VALUE_SKAN_VERSION("skan_version"),
      @SerializedName("standard_event_content_type")
      VALUE_STANDARD_EVENT_CONTENT_TYPE("standard_event_content_type"),
      @SerializedName("title_asset")
      VALUE_TITLE_ASSET("title_asset"),
      @SerializedName("user_persona_id")
      VALUE_USER_PERSONA_ID("user_persona_id"),
      @SerializedName("user_persona_name")
      VALUE_USER_PERSONA_NAME("user_persona_name"),
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
      @SerializedName("data_maximum")
      VALUE_DATA_MAXIMUM("data_maximum"),
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
      @SerializedName("maximum")
      VALUE_MAXIMUM("maximum"),
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
      @SerializedName("conversion_destination")
      VALUE_CONVERSION_DESTINATION("conversion_destination"),
      @SerializedName("matched_persona_id")
      VALUE_MATCHED_PERSONA_ID("matched_persona_id"),
      @SerializedName("matched_persona_name")
      VALUE_MATCHED_PERSONA_NAME("matched_persona_name"),
      @SerializedName("signal_source_bucket")
      VALUE_SIGNAL_SOURCE_BUCKET("signal_source_bucket"),
      @SerializedName("standard_event_content_type")
      VALUE_STANDARD_EVENT_CONTENT_TYPE("standard_event_content_type"),
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
    this.mAdClickActions = instance.mAdClickActions;
    this.mAdId = instance.mAdId;
    this.mAdImpressionActions = instance.mAdImpressionActions;
    this.mAdName = instance.mAdName;
    this.mAdjustedOfflinePurchase = instance.mAdjustedOfflinePurchase;
    this.mAdsetEnd = instance.mAdsetEnd;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mAdsetStart = instance.mAdsetStart;
    this.mAgeTargeting = instance.mAgeTargeting;
    this.mAttributionSetting = instance.mAttributionSetting;
    this.mAuctionBid = instance.mAuctionBid;
    this.mAuctionCompetitiveness = instance.mAuctionCompetitiveness;
    this.mAuctionMaxCompetitorBid = instance.mAuctionMaxCompetitorBid;
    this.mBuyingType = instance.mBuyingType;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCanvasAvgViewPercent = instance.mCanvasAvgViewPercent;
    this.mCanvasAvgViewTime = instance.mCanvasAvgViewTime;
    this.mCatalogSegmentActions = instance.mCatalogSegmentActions;
    this.mCatalogSegmentValue = instance.mCatalogSegmentValue;
    this.mCatalogSegmentValueMobilePurchaseRoas = instance.mCatalogSegmentValueMobilePurchaseRoas;
    this.mCatalogSegmentValueOmniPurchaseRoas = instance.mCatalogSegmentValueOmniPurchaseRoas;
    this.mCatalogSegmentValueWebsitePurchaseRoas = instance.mCatalogSegmentValueWebsitePurchaseRoas;
    this.mClicks = instance.mClicks;
    this.mConversionRateRanking = instance.mConversionRateRanking;
    this.mConversionValues = instance.mConversionValues;
    this.mConversions = instance.mConversions;
    this.mConvertedProductQuantity = instance.mConvertedProductQuantity;
    this.mConvertedProductValue = instance.mConvertedProductValue;
    this.mCostPer15SecVideoView = instance.mCostPer15SecVideoView;
    this.mCostPer2SecContinuousVideoView = instance.mCostPer2SecContinuousVideoView;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerAdClick = instance.mCostPerAdClick;
    this.mCostPerConversion = instance.mCostPerConversion;
    this.mCostPerDdaCountbyConvs = instance.mCostPerDdaCountbyConvs;
    this.mCostPerEstimatedAdRecallers = instance.mCostPerEstimatedAdRecallers;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerOneThousandAdImpression = instance.mCostPerOneThousandAdImpression;
    this.mCostPerOutboundClick = instance.mCostPerOutboundClick;
    this.mCostPerThruplay = instance.mCostPerThruplay;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCostPerUniqueConversion = instance.mCostPerUniqueConversion;
    this.mCostPerUniqueInlineLinkClick = instance.mCostPerUniqueInlineLinkClick;
    this.mCostPerUniqueOutboundClick = instance.mCostPerUniqueOutboundClick;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeMediaType = instance.mCreativeMediaType;
    this.mCtr = instance.mCtr;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDdaCountbyConvs = instance.mDdaCountbyConvs;
    this.mDdaResults = instance.mDdaResults;
    this.mEngagementRateRanking = instance.mEngagementRateRanking;
    this.mEstimatedAdRecallRate = instance.mEstimatedAdRecallRate;
    this.mEstimatedAdRecallRateLowerBound = instance.mEstimatedAdRecallRateLowerBound;
    this.mEstimatedAdRecallRateUpperBound = instance.mEstimatedAdRecallRateUpperBound;
    this.mEstimatedAdRecallers = instance.mEstimatedAdRecallers;
    this.mEstimatedAdRecallersLowerBound = instance.mEstimatedAdRecallersLowerBound;
    this.mEstimatedAdRecallersUpperBound = instance.mEstimatedAdRecallersUpperBound;
    this.mFrequency = instance.mFrequency;
    this.mFullViewImpressions = instance.mFullViewImpressions;
    this.mFullViewReach = instance.mFullViewReach;
    this.mGenderTargeting = instance.mGenderTargeting;
    this.mImpressions = instance.mImpressions;
    this.mInlineLinkClickCtr = instance.mInlineLinkClickCtr;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mInstagramUpcomingEventRemindersSet = instance.mInstagramUpcomingEventRemindersSet;
    this.mInstantExperienceClicksToOpen = instance.mInstantExperienceClicksToOpen;
    this.mInstantExperienceClicksToStart = instance.mInstantExperienceClicksToStart;
    this.mInstantExperienceOutboundClicks = instance.mInstantExperienceOutboundClicks;
    this.mInteractiveComponentTap = instance.mInteractiveComponentTap;
    this.mLabels = instance.mLabels;
    this.mLocation = instance.mLocation;
    this.mMarketingMessagesCostPerDelivered = instance.mMarketingMessagesCostPerDelivered;
    this.mMarketingMessagesCostPerLinkBtnClick = instance.mMarketingMessagesCostPerLinkBtnClick;
    this.mMarketingMessagesSpend = instance.mMarketingMessagesSpend;
    this.mMarketingMessagesWebsitePurchaseValues = instance.mMarketingMessagesWebsitePurchaseValues;
    this.mMobileAppPurchaseRoas = instance.mMobileAppPurchaseRoas;
    this.mObjective = instance.mObjective;
    this.mOnsiteConversionMessagingDetectedPurchaseDeduped = instance.mOnsiteConversionMessagingDetectedPurchaseDeduped;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mOutboundClicks = instance.mOutboundClicks;
    this.mOutboundClicksCtr = instance.mOutboundClicksCtr;
    this.mPlacePageName = instance.mPlacePageName;
    this.mPurchaseRoas = instance.mPurchaseRoas;
    this.mQualifyingQuestionQualifyAnswerRate = instance.mQualifyingQuestionQualifyAnswerRate;
    this.mQualityRanking = instance.mQualityRanking;
    this.mReach = instance.mReach;
    this.mShopsAssistedPurchases = instance.mShopsAssistedPurchases;
    this.mSocialSpend = instance.mSocialSpend;
    this.mSpend = instance.mSpend;
    this.mTotalPostbacks = instance.mTotalPostbacks;
    this.mTotalPostbacksDetailed = instance.mTotalPostbacksDetailed;
    this.mTotalPostbacksDetailedV4 = instance.mTotalPostbacksDetailedV4;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueConversions = instance.mUniqueConversions;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueInlineLinkClickCtr = instance.mUniqueInlineLinkClickCtr;
    this.mUniqueInlineLinkClicks = instance.mUniqueInlineLinkClicks;
    this.mUniqueLinkClicksCtr = instance.mUniqueLinkClicksCtr;
    this.mUniqueOutboundClicks = instance.mUniqueOutboundClicks;
    this.mUniqueOutboundClicksCtr = instance.mUniqueOutboundClicksCtr;
    this.mUniqueVideoContinuous2SecWatchedActions = instance.mUniqueVideoContinuous2SecWatchedActions;
    this.mUniqueVideoView15Sec = instance.mUniqueVideoView15Sec;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVideo15SecWatchedActions = instance.mVideo15SecWatchedActions;
    this.mVideo30SecWatchedActions = instance.mVideo30SecWatchedActions;
    this.mVideoAvgTimeWatchedActions = instance.mVideoAvgTimeWatchedActions;
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
    this.mWebsiteCtr = instance.mWebsiteCtr;
    this.mWebsitePurchaseRoas = instance.mWebsitePurchaseRoas;
    this.mWishBid = instance.mWishBid;
    this.mAdFormatAsset = instance.mAdFormatAsset;
    this.mAge = instance.mAge;
    this.mAppId = instance.mAppId;
    this.mBodyAsset = instance.mBodyAsset;
    this.mCallToActionAsset = instance.mCallToActionAsset;
    this.mCoarseConversionValue = instance.mCoarseConversionValue;
    this.mConversionDestination = instance.mConversionDestination;
    this.mCountry = instance.mCountry;
    this.mDescriptionAsset = instance.mDescriptionAsset;
    this.mDevicePlatform = instance.mDevicePlatform;
    this.mDma = instance.mDma;
    this.mFidelityType = instance.mFidelityType;
    this.mFrequencyValue = instance.mFrequencyValue;
    this.mGender = instance.mGender;
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = instance.mHourlyStatsAggregatedByAdvertiserTimeZone;
    this.mHourlyStatsAggregatedByAudienceTimeZone = instance.mHourlyStatsAggregatedByAudienceTimeZone;
    this.mHsid = instance.mHsid;
    this.mImageAsset = instance.mImageAsset;
    this.mImpressionDevice = instance.mImpressionDevice;
    this.mIsConversionIdModeled = instance.mIsConversionIdModeled;
    this.mLandingDestination = instance.mLandingDestination;
    this.mLinkUrlAsset = instance.mLinkUrlAsset;
    this.mMarketingMessagesBtnName = instance.mMarketingMessagesBtnName;
    this.mMdsaLandingDestination = instance.mMdsaLandingDestination;
    this.mMediaAssetUrl = instance.mMediaAssetUrl;
    this.mMediaCreator = instance.mMediaCreator;
    this.mMediaDestinationUrl = instance.mMediaDestinationUrl;
    this.mMediaFormat = instance.mMediaFormat;
    this.mMediaOriginUrl = instance.mMediaOriginUrl;
    this.mMediaTextContent = instance.mMediaTextContent;
    this.mMmm = instance.mMmm;
    this.mPlacePageId = instance.mPlacePageId;
    this.mPlatformPosition = instance.mPlatformPosition;
    this.mPostbackSequenceIndex = instance.mPostbackSequenceIndex;
    this.mProductId = instance.mProductId;
    this.mPublisherPlatform = instance.mPublisherPlatform;
    this.mRedownload = instance.mRedownload;
    this.mRegion = instance.mRegion;
    this.mSignalSourceBucket = instance.mSignalSourceBucket;
    this.mSkanCampaignId = instance.mSkanCampaignId;
    this.mSkanConversionId = instance.mSkanConversionId;
    this.mSkanVersion = instance.mSkanVersion;
    this.mStandardEventContentType = instance.mStandardEventContentType;
    this.mTitleAsset = instance.mTitleAsset;
    this.mUserPersonaId = instance.mUserPersonaId;
    this.mUserPersonaName = instance.mUserPersonaName;
    this.mVideoAsset = instance.mVideoAsset;
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
