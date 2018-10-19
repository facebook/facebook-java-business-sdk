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
  @SerializedName("activity_recency")
  private String mActivityRecency = null;
  @SerializedName("ad_click_actions")
  private List<AdsActionStats> mAdClickActions = null;
  @SerializedName("ad_format_asset")
  private String mAdFormatAsset = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_impression_actions")
  private List<AdsActionStats> mAdImpressionActions = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("age_targeting")
  private String mAgeTargeting = null;
  @SerializedName("bid_type")
  private String mBidType = null;
  @SerializedName("body_asset")
  private Object mBodyAsset = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("call_to_action_asset")
  private Object mCallToActionAsset = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("canvas_avg_view_percent")
  private String mCanvasAvgViewPercent = null;
  @SerializedName("canvas_avg_view_time")
  private String mCanvasAvgViewTime = null;
  @SerializedName("canvas_component_avg_pct_view")
  private List<AdsActionStats> mCanvasComponentAvgPctView = null;
  @SerializedName("clicks")
  private String mClicks = null;
  @SerializedName("cost_per_10_sec_video_view")
  private List<AdsActionStats> mCostPer10SecVideoView = null;
  @SerializedName("cost_per_15_sec_video_view")
  private List<AdsActionStats> mCostPer15SecVideoView = null;
  @SerializedName("cost_per_2_sec_continuous_video_view")
  private List<AdsActionStats> mCostPer2SecContinuousVideoView = null;
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_ad_click")
  private List<AdsActionStats> mCostPerAdClick = null;
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
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("dda_countby_convs")
  private String mDdaCountbyConvs = null;
  @SerializedName("description_asset")
  private Object mDescriptionAsset = null;
  @SerializedName("device_platform")
  private String mDevicePlatform = null;
  @SerializedName("dma")
  private String mDma = null;
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
  @SerializedName("frequency_value")
  private String mFrequencyValue = null;
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
  @SerializedName("impressions_dummy")
  private String mImpressionsDummy = null;
  @SerializedName("inline_link_click_ctr")
  private String mInlineLinkClickCtr = null;
  @SerializedName("inline_link_clicks")
  private String mInlineLinkClicks = null;
  @SerializedName("inline_post_engagement")
  private String mInlinePostEngagement = null;
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
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("outbound_clicks")
  private List<AdsActionStats> mOutboundClicks = null;
  @SerializedName("outbound_clicks_ctr")
  private List<AdsActionStats> mOutboundClicksCtr = null;
  @SerializedName("place_page_id")
  private String mPlacePageId = null;
  @SerializedName("place_page_name")
  private String mPlacePageName = null;
  @SerializedName("placement")
  private String mPlacement = null;
  @SerializedName("platform_position")
  private String mPlatformPosition = null;
  @SerializedName("product_format")
  private String mProductFormat = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("publisher_platform")
  private String mPublisherPlatform = null;
  @SerializedName("purchasing_interface")
  private String mPurchasingInterface = null;
  @SerializedName("reach")
  private String mReach = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("relevance_score")
  private AdgroupRelevanceScore mRelevanceScore = null;
  @SerializedName("social_spend")
  private String mSocialSpend = null;
  @SerializedName("spend")
  private String mSpend = null;
  @SerializedName("title_asset")
  private Object mTitleAsset = null;
  @SerializedName("total_action_value")
  private String mTotalActionValue = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private String mUniqueClicks = null;
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
  @SerializedName("video_avg_percent_watched_actions")
  private List<AdsActionStats> mVideoAvgPercentWatchedActions = null;
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
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  @SerializedName("website_purchase_roas")
  private List<AdsActionStats> mWebsitePurchaseRoas = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdsInsights() {
  }

  public AdsInsights(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsInsights(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsInsights fetch() throws APIException{
    AdsInsights newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsInsights fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsInsights> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsInsights fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsInsights> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsInsights> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsInsights>)(
      new APIRequest<AdsInsights>(context, "", "/", "GET", AdsInsights.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsInsights>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsInsights.getParser())
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
  public static AdsInsights loadJSON(String json, APIContext context) {
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
    return adsInsights;
  }

  public static APINodeList<AdsInsights> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsInsights> adsInsightss = new APINodeList<AdsInsights>(request, json);
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
          adsInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              adsInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adsInsightss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsInsightss.add(loadJSON(obj.toString(), context));
            }
          }
          return adsInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsInsightss.add(loadJSON(entry.getValue().toString(), context));
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
              adsInsightss.add(loadJSON(value.toString(), context));
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
          adsInsightss.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountCurrency() {
    return mAccountCurrency;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public List<AdsActionStats> getFieldActionValues() {
    return mActionValues;
  }

  public List<AdsActionStats> getFieldActions() {
    return mActions;
  }

  public String getFieldActivityRecency() {
    return mActivityRecency;
  }

  public List<AdsActionStats> getFieldAdClickActions() {
    return mAdClickActions;
  }

  public String getFieldAdFormatAsset() {
    return mAdFormatAsset;
  }

  public String getFieldAdId() {
    return mAdId;
  }

  public List<AdsActionStats> getFieldAdImpressionActions() {
    return mAdImpressionActions;
  }

  public String getFieldAdName() {
    return mAdName;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public String getFieldAdsetName() {
    return mAdsetName;
  }

  public String getFieldAge() {
    return mAge;
  }

  public String getFieldAgeTargeting() {
    return mAgeTargeting;
  }

  public String getFieldBidType() {
    return mBidType;
  }

  public Object getFieldBodyAsset() {
    return mBodyAsset;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public Object getFieldCallToActionAsset() {
    return mCallToActionAsset;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public String getFieldCanvasAvgViewPercent() {
    return mCanvasAvgViewPercent;
  }

  public String getFieldCanvasAvgViewTime() {
    return mCanvasAvgViewTime;
  }

  public List<AdsActionStats> getFieldCanvasComponentAvgPctView() {
    return mCanvasComponentAvgPctView;
  }

  public String getFieldClicks() {
    return mClicks;
  }

  public List<AdsActionStats> getFieldCostPer10SecVideoView() {
    return mCostPer10SecVideoView;
  }

  public List<AdsActionStats> getFieldCostPer15SecVideoView() {
    return mCostPer15SecVideoView;
  }

  public List<AdsActionStats> getFieldCostPer2SecContinuousVideoView() {
    return mCostPer2SecContinuousVideoView;
  }

  public List<AdsActionStats> getFieldCostPerActionType() {
    return mCostPerActionType;
  }

  public List<AdsActionStats> getFieldCostPerAdClick() {
    return mCostPerAdClick;
  }

  public String getFieldCostPerDdaCountbyConvs() {
    return mCostPerDdaCountbyConvs;
  }

  public String getFieldCostPerEstimatedAdRecallers() {
    return mCostPerEstimatedAdRecallers;
  }

  public String getFieldCostPerInlineLinkClick() {
    return mCostPerInlineLinkClick;
  }

  public String getFieldCostPerInlinePostEngagement() {
    return mCostPerInlinePostEngagement;
  }

  public List<AdsActionStats> getFieldCostPerOneThousandAdImpression() {
    return mCostPerOneThousandAdImpression;
  }

  public List<AdsActionStats> getFieldCostPerOutboundClick() {
    return mCostPerOutboundClick;
  }

  public List<AdsActionStats> getFieldCostPerThruplay() {
    return mCostPerThruplay;
  }

  public List<AdsActionStats> getFieldCostPerUniqueActionType() {
    return mCostPerUniqueActionType;
  }

  public String getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public String getFieldCostPerUniqueInlineLinkClick() {
    return mCostPerUniqueInlineLinkClick;
  }

  public List<AdsActionStats> getFieldCostPerUniqueOutboundClick() {
    return mCostPerUniqueOutboundClick;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCpc() {
    return mCpc;
  }

  public String getFieldCpm() {
    return mCpm;
  }

  public String getFieldCpp() {
    return mCpp;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldCreativeFingerprint() {
    return mCreativeFingerprint;
  }

  public String getFieldCtr() {
    return mCtr;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public String getFieldDdaCountbyConvs() {
    return mDdaCountbyConvs;
  }

  public Object getFieldDescriptionAsset() {
    return mDescriptionAsset;
  }

  public String getFieldDevicePlatform() {
    return mDevicePlatform;
  }

  public String getFieldDma() {
    return mDma;
  }

  public String getFieldEstimatedAdRecallRate() {
    return mEstimatedAdRecallRate;
  }

  public String getFieldEstimatedAdRecallRateLowerBound() {
    return mEstimatedAdRecallRateLowerBound;
  }

  public String getFieldEstimatedAdRecallRateUpperBound() {
    return mEstimatedAdRecallRateUpperBound;
  }

  public String getFieldEstimatedAdRecallers() {
    return mEstimatedAdRecallers;
  }

  public String getFieldEstimatedAdRecallersLowerBound() {
    return mEstimatedAdRecallersLowerBound;
  }

  public String getFieldEstimatedAdRecallersUpperBound() {
    return mEstimatedAdRecallersUpperBound;
  }

  public String getFieldFrequency() {
    return mFrequency;
  }

  public String getFieldFrequencyValue() {
    return mFrequencyValue;
  }

  public String getFieldGender() {
    return mGender;
  }

  public String getFieldGenderTargeting() {
    return mGenderTargeting;
  }

  public String getFieldHourlyStatsAggregatedByAdvertiserTimeZone() {
    return mHourlyStatsAggregatedByAdvertiserTimeZone;
  }

  public String getFieldHourlyStatsAggregatedByAudienceTimeZone() {
    return mHourlyStatsAggregatedByAudienceTimeZone;
  }

  public Object getFieldImageAsset() {
    return mImageAsset;
  }

  public String getFieldImpressionDevice() {
    return mImpressionDevice;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public String getFieldImpressionsDummy() {
    return mImpressionsDummy;
  }

  public String getFieldInlineLinkClickCtr() {
    return mInlineLinkClickCtr;
  }

  public String getFieldInlineLinkClicks() {
    return mInlineLinkClicks;
  }

  public String getFieldInlinePostEngagement() {
    return mInlinePostEngagement;
  }

  public String getFieldLabels() {
    return mLabels;
  }

  public Object getFieldLinkUrlAsset() {
    return mLinkUrlAsset;
  }

  public String getFieldLocation() {
    return mLocation;
  }

  public Object getFieldMediaAsset() {
    return mMediaAsset;
  }

  public List<AdsActionStats> getFieldMobileAppPurchaseRoas() {
    return mMobileAppPurchaseRoas;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public List<AdsActionStats> getFieldOutboundClicks() {
    return mOutboundClicks;
  }

  public List<AdsActionStats> getFieldOutboundClicksCtr() {
    return mOutboundClicksCtr;
  }

  public String getFieldPlacePageId() {
    return mPlacePageId;
  }

  public String getFieldPlacePageName() {
    return mPlacePageName;
  }

  public String getFieldPlacement() {
    return mPlacement;
  }

  public String getFieldPlatformPosition() {
    return mPlatformPosition;
  }

  public String getFieldProductFormat() {
    return mProductFormat;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public String getFieldPublisherPlatform() {
    return mPublisherPlatform;
  }

  public String getFieldPurchasingInterface() {
    return mPurchasingInterface;
  }

  public String getFieldReach() {
    return mReach;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public AdgroupRelevanceScore getFieldRelevanceScore() {
    if (mRelevanceScore != null) {
      mRelevanceScore.context = getContext();
    }
    return mRelevanceScore;
  }

  public String getFieldSocialSpend() {
    return mSocialSpend;
  }

  public String getFieldSpend() {
    return mSpend;
  }

  public Object getFieldTitleAsset() {
    return mTitleAsset;
  }

  public String getFieldTotalActionValue() {
    return mTotalActionValue;
  }

  public List<AdsActionStats> getFieldUniqueActions() {
    return mUniqueActions;
  }

  public String getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public String getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public String getFieldUniqueInlineLinkClickCtr() {
    return mUniqueInlineLinkClickCtr;
  }

  public String getFieldUniqueInlineLinkClicks() {
    return mUniqueInlineLinkClicks;
  }

  public String getFieldUniqueLinkClicksCtr() {
    return mUniqueLinkClicksCtr;
  }

  public List<AdsActionStats> getFieldUniqueOutboundClicks() {
    return mUniqueOutboundClicks;
  }

  public List<AdsActionStats> getFieldUniqueOutboundClicksCtr() {
    return mUniqueOutboundClicksCtr;
  }

  public List<AdsActionStats> getFieldUniqueVideoContinuous2SecWatchedActions() {
    return mUniqueVideoContinuous2SecWatchedActions;
  }

  public List<AdsActionStats> getFieldUniqueVideoView10Sec() {
    return mUniqueVideoView10Sec;
  }

  public List<AdsActionStats> getFieldUniqueVideoView15Sec() {
    return mUniqueVideoView15Sec;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public List<AdsActionStats> getFieldVideo10SecWatchedActions() {
    return mVideo10SecWatchedActions;
  }

  public List<AdsActionStats> getFieldVideo15SecWatchedActions() {
    return mVideo15SecWatchedActions;
  }

  public List<AdsActionStats> getFieldVideo30SecWatchedActions() {
    return mVideo30SecWatchedActions;
  }

  public Object getFieldVideoAsset() {
    return mVideoAsset;
  }

  public List<AdsActionStats> getFieldVideoAvgPercentWatchedActions() {
    return mVideoAvgPercentWatchedActions;
  }

  public List<AdsActionStats> getFieldVideoAvgTimeWatchedActions() {
    return mVideoAvgTimeWatchedActions;
  }

  public List<AdsActionStats> getFieldVideoContinuous2SecWatchedActions() {
    return mVideoContinuous2SecWatchedActions;
  }

  public List<AdsActionStats> getFieldVideoP100WatchedActions() {
    return mVideoP100WatchedActions;
  }

  public List<AdsActionStats> getFieldVideoP25WatchedActions() {
    return mVideoP25WatchedActions;
  }

  public List<AdsActionStats> getFieldVideoP50WatchedActions() {
    return mVideoP50WatchedActions;
  }

  public List<AdsActionStats> getFieldVideoP75WatchedActions() {
    return mVideoP75WatchedActions;
  }

  public List<AdsActionStats> getFieldVideoP95WatchedActions() {
    return mVideoP95WatchedActions;
  }

  public List<AdsActionStats> getFieldVideoPlayActions() {
    return mVideoPlayActions;
  }

  public List<Object> getFieldVideoPlayRetention0To15sActions() {
    return mVideoPlayRetention0To15sActions;
  }

  public List<Object> getFieldVideoPlayRetention20To60sActions() {
    return mVideoPlayRetention20To60sActions;
  }

  public List<Object> getFieldVideoPlayRetentionGraphActions() {
    return mVideoPlayRetentionGraphActions;
  }

  public List<AdsActionStats> getFieldVideoThruplayWatchedActions() {
    return mVideoThruplayWatchedActions;
  }

  public List<AdsActionStats> getFieldVideoTimeWatchedActions() {
    return mVideoTimeWatchedActions;
  }

  public List<AdsActionStats> getFieldWebsiteCtr() {
    return mWebsiteCtr;
  }

  public List<AdsActionStats> getFieldWebsitePurchaseRoas() {
    return mWebsitePurchaseRoas;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdsInsights> {

    AdsInsights lastResponse = null;
    @Override
    public AdsInsights getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_currency",
      "account_id",
      "account_name",
      "action_values",
      "actions",
      "activity_recency",
      "ad_click_actions",
      "ad_format_asset",
      "ad_id",
      "ad_impression_actions",
      "ad_name",
      "adset_id",
      "adset_name",
      "age",
      "age_targeting",
      "bid_type",
      "body_asset",
      "buying_type",
      "call_to_action_asset",
      "campaign_id",
      "campaign_name",
      "canvas_avg_view_percent",
      "canvas_avg_view_time",
      "canvas_component_avg_pct_view",
      "clicks",
      "cost_per_10_sec_video_view",
      "cost_per_15_sec_video_view",
      "cost_per_2_sec_continuous_video_view",
      "cost_per_action_type",
      "cost_per_ad_click",
      "cost_per_dda_countby_convs",
      "cost_per_estimated_ad_recallers",
      "cost_per_inline_link_click",
      "cost_per_inline_post_engagement",
      "cost_per_one_thousand_ad_impression",
      "cost_per_outbound_click",
      "cost_per_thruplay",
      "cost_per_unique_action_type",
      "cost_per_unique_click",
      "cost_per_unique_inline_link_click",
      "cost_per_unique_outbound_click",
      "country",
      "cpc",
      "cpm",
      "cpp",
      "created_time",
      "creative_fingerprint",
      "ctr",
      "date_start",
      "date_stop",
      "dda_countby_convs",
      "description_asset",
      "device_platform",
      "dma",
      "estimated_ad_recall_rate",
      "estimated_ad_recall_rate_lower_bound",
      "estimated_ad_recall_rate_upper_bound",
      "estimated_ad_recallers",
      "estimated_ad_recallers_lower_bound",
      "estimated_ad_recallers_upper_bound",
      "frequency",
      "frequency_value",
      "gender",
      "gender_targeting",
      "hourly_stats_aggregated_by_advertiser_time_zone",
      "hourly_stats_aggregated_by_audience_time_zone",
      "image_asset",
      "impression_device",
      "impressions",
      "impressions_dummy",
      "inline_link_click_ctr",
      "inline_link_clicks",
      "inline_post_engagement",
      "labels",
      "link_url_asset",
      "location",
      "media_asset",
      "mobile_app_purchase_roas",
      "objective",
      "outbound_clicks",
      "outbound_clicks_ctr",
      "place_page_id",
      "place_page_name",
      "placement",
      "platform_position",
      "product_format",
      "product_id",
      "publisher_platform",
      "purchasing_interface",
      "reach",
      "region",
      "relevance_score",
      "social_spend",
      "spend",
      "title_asset",
      "total_action_value",
      "unique_actions",
      "unique_clicks",
      "unique_ctr",
      "unique_inline_link_click_ctr",
      "unique_inline_link_clicks",
      "unique_link_clicks_ctr",
      "unique_outbound_clicks",
      "unique_outbound_clicks_ctr",
      "unique_video_continuous_2_sec_watched_actions",
      "unique_video_view_10_sec",
      "unique_video_view_15_sec",
      "updated_time",
      "video_10_sec_watched_actions",
      "video_15_sec_watched_actions",
      "video_30_sec_watched_actions",
      "video_asset",
      "video_avg_percent_watched_actions",
      "video_avg_time_watched_actions",
      "video_continuous_2_sec_watched_actions",
      "video_p100_watched_actions",
      "video_p25_watched_actions",
      "video_p50_watched_actions",
      "video_p75_watched_actions",
      "video_p95_watched_actions",
      "video_play_actions",
      "video_play_retention_0_to_15s_actions",
      "video_play_retention_20_to_60s_actions",
      "video_play_retention_graph_actions",
      "video_thruplay_watched_actions",
      "video_time_watched_actions",
      "website_ctr",
      "website_purchase_roas",
      "id",
    };

    @Override
    public AdsInsights parseResponse(String response) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsInsights execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsInsights execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsInsights> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsInsights> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsInsights>() {
           public AdsInsights apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestAccountCurrencyField () {
      return this.requestAccountCurrencyField(true);
    }
    public APIRequestGet requestAccountCurrencyField (boolean value) {
      this.requestField("account_currency", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAccountNameField () {
      return this.requestAccountNameField(true);
    }
    public APIRequestGet requestAccountNameField (boolean value) {
      this.requestField("account_name", value);
      return this;
    }
    public APIRequestGet requestActionValuesField () {
      return this.requestActionValuesField(true);
    }
    public APIRequestGet requestActionValuesField (boolean value) {
      this.requestField("action_values", value);
      return this;
    }
    public APIRequestGet requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGet requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGet requestActivityRecencyField () {
      return this.requestActivityRecencyField(true);
    }
    public APIRequestGet requestActivityRecencyField (boolean value) {
      this.requestField("activity_recency", value);
      return this;
    }
    public APIRequestGet requestAdClickActionsField () {
      return this.requestAdClickActionsField(true);
    }
    public APIRequestGet requestAdClickActionsField (boolean value) {
      this.requestField("ad_click_actions", value);
      return this;
    }
    public APIRequestGet requestAdFormatAssetField () {
      return this.requestAdFormatAssetField(true);
    }
    public APIRequestGet requestAdFormatAssetField (boolean value) {
      this.requestField("ad_format_asset", value);
      return this;
    }
    public APIRequestGet requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGet requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGet requestAdImpressionActionsField () {
      return this.requestAdImpressionActionsField(true);
    }
    public APIRequestGet requestAdImpressionActionsField (boolean value) {
      this.requestField("ad_impression_actions", value);
      return this;
    }
    public APIRequestGet requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGet requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGet requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGet requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGet requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGet requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGet requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGet requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGet requestAgeTargetingField () {
      return this.requestAgeTargetingField(true);
    }
    public APIRequestGet requestAgeTargetingField (boolean value) {
      this.requestField("age_targeting", value);
      return this;
    }
    public APIRequestGet requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGet requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGet requestBodyAssetField () {
      return this.requestBodyAssetField(true);
    }
    public APIRequestGet requestBodyAssetField (boolean value) {
      this.requestField("body_asset", value);
      return this;
    }
    public APIRequestGet requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGet requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGet requestCallToActionAssetField () {
      return this.requestCallToActionAssetField(true);
    }
    public APIRequestGet requestCallToActionAssetField (boolean value) {
      this.requestField("call_to_action_asset", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGet requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGet requestCanvasAvgViewPercentField () {
      return this.requestCanvasAvgViewPercentField(true);
    }
    public APIRequestGet requestCanvasAvgViewPercentField (boolean value) {
      this.requestField("canvas_avg_view_percent", value);
      return this;
    }
    public APIRequestGet requestCanvasAvgViewTimeField () {
      return this.requestCanvasAvgViewTimeField(true);
    }
    public APIRequestGet requestCanvasAvgViewTimeField (boolean value) {
      this.requestField("canvas_avg_view_time", value);
      return this;
    }
    public APIRequestGet requestCanvasComponentAvgPctViewField () {
      return this.requestCanvasComponentAvgPctViewField(true);
    }
    public APIRequestGet requestCanvasComponentAvgPctViewField (boolean value) {
      this.requestField("canvas_component_avg_pct_view", value);
      return this;
    }
    public APIRequestGet requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGet requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGet requestCostPer10SecVideoViewField () {
      return this.requestCostPer10SecVideoViewField(true);
    }
    public APIRequestGet requestCostPer10SecVideoViewField (boolean value) {
      this.requestField("cost_per_10_sec_video_view", value);
      return this;
    }
    public APIRequestGet requestCostPer15SecVideoViewField () {
      return this.requestCostPer15SecVideoViewField(true);
    }
    public APIRequestGet requestCostPer15SecVideoViewField (boolean value) {
      this.requestField("cost_per_15_sec_video_view", value);
      return this;
    }
    public APIRequestGet requestCostPer2SecContinuousVideoViewField () {
      return this.requestCostPer2SecContinuousVideoViewField(true);
    }
    public APIRequestGet requestCostPer2SecContinuousVideoViewField (boolean value) {
      this.requestField("cost_per_2_sec_continuous_video_view", value);
      return this;
    }
    public APIRequestGet requestCostPerActionTypeField () {
      return this.requestCostPerActionTypeField(true);
    }
    public APIRequestGet requestCostPerActionTypeField (boolean value) {
      this.requestField("cost_per_action_type", value);
      return this;
    }
    public APIRequestGet requestCostPerAdClickField () {
      return this.requestCostPerAdClickField(true);
    }
    public APIRequestGet requestCostPerAdClickField (boolean value) {
      this.requestField("cost_per_ad_click", value);
      return this;
    }
    public APIRequestGet requestCostPerDdaCountbyConvsField () {
      return this.requestCostPerDdaCountbyConvsField(true);
    }
    public APIRequestGet requestCostPerDdaCountbyConvsField (boolean value) {
      this.requestField("cost_per_dda_countby_convs", value);
      return this;
    }
    public APIRequestGet requestCostPerEstimatedAdRecallersField () {
      return this.requestCostPerEstimatedAdRecallersField(true);
    }
    public APIRequestGet requestCostPerEstimatedAdRecallersField (boolean value) {
      this.requestField("cost_per_estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGet requestCostPerInlineLinkClickField () {
      return this.requestCostPerInlineLinkClickField(true);
    }
    public APIRequestGet requestCostPerInlineLinkClickField (boolean value) {
      this.requestField("cost_per_inline_link_click", value);
      return this;
    }
    public APIRequestGet requestCostPerInlinePostEngagementField () {
      return this.requestCostPerInlinePostEngagementField(true);
    }
    public APIRequestGet requestCostPerInlinePostEngagementField (boolean value) {
      this.requestField("cost_per_inline_post_engagement", value);
      return this;
    }
    public APIRequestGet requestCostPerOneThousandAdImpressionField () {
      return this.requestCostPerOneThousandAdImpressionField(true);
    }
    public APIRequestGet requestCostPerOneThousandAdImpressionField (boolean value) {
      this.requestField("cost_per_one_thousand_ad_impression", value);
      return this;
    }
    public APIRequestGet requestCostPerOutboundClickField () {
      return this.requestCostPerOutboundClickField(true);
    }
    public APIRequestGet requestCostPerOutboundClickField (boolean value) {
      this.requestField("cost_per_outbound_click", value);
      return this;
    }
    public APIRequestGet requestCostPerThruplayField () {
      return this.requestCostPerThruplayField(true);
    }
    public APIRequestGet requestCostPerThruplayField (boolean value) {
      this.requestField("cost_per_thruplay", value);
      return this;
    }
    public APIRequestGet requestCostPerUniqueActionTypeField () {
      return this.requestCostPerUniqueActionTypeField(true);
    }
    public APIRequestGet requestCostPerUniqueActionTypeField (boolean value) {
      this.requestField("cost_per_unique_action_type", value);
      return this;
    }
    public APIRequestGet requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGet requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGet requestCostPerUniqueInlineLinkClickField () {
      return this.requestCostPerUniqueInlineLinkClickField(true);
    }
    public APIRequestGet requestCostPerUniqueInlineLinkClickField (boolean value) {
      this.requestField("cost_per_unique_inline_link_click", value);
      return this;
    }
    public APIRequestGet requestCostPerUniqueOutboundClickField () {
      return this.requestCostPerUniqueOutboundClickField(true);
    }
    public APIRequestGet requestCostPerUniqueOutboundClickField (boolean value) {
      this.requestField("cost_per_unique_outbound_click", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGet requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGet requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGet requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGet requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGet requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativeFingerprintField () {
      return this.requestCreativeFingerprintField(true);
    }
    public APIRequestGet requestCreativeFingerprintField (boolean value) {
      this.requestField("creative_fingerprint", value);
      return this;
    }
    public APIRequestGet requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGet requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGet requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGet requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGet requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGet requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGet requestDdaCountbyConvsField () {
      return this.requestDdaCountbyConvsField(true);
    }
    public APIRequestGet requestDdaCountbyConvsField (boolean value) {
      this.requestField("dda_countby_convs", value);
      return this;
    }
    public APIRequestGet requestDescriptionAssetField () {
      return this.requestDescriptionAssetField(true);
    }
    public APIRequestGet requestDescriptionAssetField (boolean value) {
      this.requestField("description_asset", value);
      return this;
    }
    public APIRequestGet requestDevicePlatformField () {
      return this.requestDevicePlatformField(true);
    }
    public APIRequestGet requestDevicePlatformField (boolean value) {
      this.requestField("device_platform", value);
      return this;
    }
    public APIRequestGet requestDmaField () {
      return this.requestDmaField(true);
    }
    public APIRequestGet requestDmaField (boolean value) {
      this.requestField("dma", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallRateField () {
      return this.requestEstimatedAdRecallRateField(true);
    }
    public APIRequestGet requestEstimatedAdRecallRateField (boolean value) {
      this.requestField("estimated_ad_recall_rate", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallRateLowerBoundField () {
      return this.requestEstimatedAdRecallRateLowerBoundField(true);
    }
    public APIRequestGet requestEstimatedAdRecallRateLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_lower_bound", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallRateUpperBoundField () {
      return this.requestEstimatedAdRecallRateUpperBoundField(true);
    }
    public APIRequestGet requestEstimatedAdRecallRateUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_upper_bound", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallersField () {
      return this.requestEstimatedAdRecallersField(true);
    }
    public APIRequestGet requestEstimatedAdRecallersField (boolean value) {
      this.requestField("estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallersLowerBoundField () {
      return this.requestEstimatedAdRecallersLowerBoundField(true);
    }
    public APIRequestGet requestEstimatedAdRecallersLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_lower_bound", value);
      return this;
    }
    public APIRequestGet requestEstimatedAdRecallersUpperBoundField () {
      return this.requestEstimatedAdRecallersUpperBoundField(true);
    }
    public APIRequestGet requestEstimatedAdRecallersUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_upper_bound", value);
      return this;
    }
    public APIRequestGet requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGet requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }
    public APIRequestGet requestFrequencyValueField () {
      return this.requestFrequencyValueField(true);
    }
    public APIRequestGet requestFrequencyValueField (boolean value) {
      this.requestField("frequency_value", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGet requestGenderTargetingField () {
      return this.requestGenderTargetingField(true);
    }
    public APIRequestGet requestGenderTargetingField (boolean value) {
      this.requestField("gender_targeting", value);
      return this;
    }
    public APIRequestGet requestHourlyStatsAggregatedByAdvertiserTimeZoneField () {
      return this.requestHourlyStatsAggregatedByAdvertiserTimeZoneField(true);
    }
    public APIRequestGet requestHourlyStatsAggregatedByAdvertiserTimeZoneField (boolean value) {
      this.requestField("hourly_stats_aggregated_by_advertiser_time_zone", value);
      return this;
    }
    public APIRequestGet requestHourlyStatsAggregatedByAudienceTimeZoneField () {
      return this.requestHourlyStatsAggregatedByAudienceTimeZoneField(true);
    }
    public APIRequestGet requestHourlyStatsAggregatedByAudienceTimeZoneField (boolean value) {
      this.requestField("hourly_stats_aggregated_by_audience_time_zone", value);
      return this;
    }
    public APIRequestGet requestImageAssetField () {
      return this.requestImageAssetField(true);
    }
    public APIRequestGet requestImageAssetField (boolean value) {
      this.requestField("image_asset", value);
      return this;
    }
    public APIRequestGet requestImpressionDeviceField () {
      return this.requestImpressionDeviceField(true);
    }
    public APIRequestGet requestImpressionDeviceField (boolean value) {
      this.requestField("impression_device", value);
      return this;
    }
    public APIRequestGet requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGet requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGet requestImpressionsDummyField () {
      return this.requestImpressionsDummyField(true);
    }
    public APIRequestGet requestImpressionsDummyField (boolean value) {
      this.requestField("impressions_dummy", value);
      return this;
    }
    public APIRequestGet requestInlineLinkClickCtrField () {
      return this.requestInlineLinkClickCtrField(true);
    }
    public APIRequestGet requestInlineLinkClickCtrField (boolean value) {
      this.requestField("inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGet requestInlineLinkClicksField () {
      return this.requestInlineLinkClicksField(true);
    }
    public APIRequestGet requestInlineLinkClicksField (boolean value) {
      this.requestField("inline_link_clicks", value);
      return this;
    }
    public APIRequestGet requestInlinePostEngagementField () {
      return this.requestInlinePostEngagementField(true);
    }
    public APIRequestGet requestInlinePostEngagementField (boolean value) {
      this.requestField("inline_post_engagement", value);
      return this;
    }
    public APIRequestGet requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGet requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGet requestLinkUrlAssetField () {
      return this.requestLinkUrlAssetField(true);
    }
    public APIRequestGet requestLinkUrlAssetField (boolean value) {
      this.requestField("link_url_asset", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMediaAssetField () {
      return this.requestMediaAssetField(true);
    }
    public APIRequestGet requestMediaAssetField (boolean value) {
      this.requestField("media_asset", value);
      return this;
    }
    public APIRequestGet requestMobileAppPurchaseRoasField () {
      return this.requestMobileAppPurchaseRoasField(true);
    }
    public APIRequestGet requestMobileAppPurchaseRoasField (boolean value) {
      this.requestField("mobile_app_purchase_roas", value);
      return this;
    }
    public APIRequestGet requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGet requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGet requestOutboundClicksField () {
      return this.requestOutboundClicksField(true);
    }
    public APIRequestGet requestOutboundClicksField (boolean value) {
      this.requestField("outbound_clicks", value);
      return this;
    }
    public APIRequestGet requestOutboundClicksCtrField () {
      return this.requestOutboundClicksCtrField(true);
    }
    public APIRequestGet requestOutboundClicksCtrField (boolean value) {
      this.requestField("outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGet requestPlacePageIdField () {
      return this.requestPlacePageIdField(true);
    }
    public APIRequestGet requestPlacePageIdField (boolean value) {
      this.requestField("place_page_id", value);
      return this;
    }
    public APIRequestGet requestPlacePageNameField () {
      return this.requestPlacePageNameField(true);
    }
    public APIRequestGet requestPlacePageNameField (boolean value) {
      this.requestField("place_page_name", value);
      return this;
    }
    public APIRequestGet requestPlacementField () {
      return this.requestPlacementField(true);
    }
    public APIRequestGet requestPlacementField (boolean value) {
      this.requestField("placement", value);
      return this;
    }
    public APIRequestGet requestPlatformPositionField () {
      return this.requestPlatformPositionField(true);
    }
    public APIRequestGet requestPlatformPositionField (boolean value) {
      this.requestField("platform_position", value);
      return this;
    }
    public APIRequestGet requestProductFormatField () {
      return this.requestProductFormatField(true);
    }
    public APIRequestGet requestProductFormatField (boolean value) {
      this.requestField("product_format", value);
      return this;
    }
    public APIRequestGet requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGet requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGet requestPublisherPlatformField () {
      return this.requestPublisherPlatformField(true);
    }
    public APIRequestGet requestPublisherPlatformField (boolean value) {
      this.requestField("publisher_platform", value);
      return this;
    }
    public APIRequestGet requestPurchasingInterfaceField () {
      return this.requestPurchasingInterfaceField(true);
    }
    public APIRequestGet requestPurchasingInterfaceField (boolean value) {
      this.requestField("purchasing_interface", value);
      return this;
    }
    public APIRequestGet requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGet requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGet requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGet requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGet requestRelevanceScoreField () {
      return this.requestRelevanceScoreField(true);
    }
    public APIRequestGet requestRelevanceScoreField (boolean value) {
      this.requestField("relevance_score", value);
      return this;
    }
    public APIRequestGet requestSocialSpendField () {
      return this.requestSocialSpendField(true);
    }
    public APIRequestGet requestSocialSpendField (boolean value) {
      this.requestField("social_spend", value);
      return this;
    }
    public APIRequestGet requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGet requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGet requestTitleAssetField () {
      return this.requestTitleAssetField(true);
    }
    public APIRequestGet requestTitleAssetField (boolean value) {
      this.requestField("title_asset", value);
      return this;
    }
    public APIRequestGet requestTotalActionValueField () {
      return this.requestTotalActionValueField(true);
    }
    public APIRequestGet requestTotalActionValueField (boolean value) {
      this.requestField("total_action_value", value);
      return this;
    }
    public APIRequestGet requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGet requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGet requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGet requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGet requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGet requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGet requestUniqueInlineLinkClickCtrField () {
      return this.requestUniqueInlineLinkClickCtrField(true);
    }
    public APIRequestGet requestUniqueInlineLinkClickCtrField (boolean value) {
      this.requestField("unique_inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGet requestUniqueInlineLinkClicksField () {
      return this.requestUniqueInlineLinkClicksField(true);
    }
    public APIRequestGet requestUniqueInlineLinkClicksField (boolean value) {
      this.requestField("unique_inline_link_clicks", value);
      return this;
    }
    public APIRequestGet requestUniqueLinkClicksCtrField () {
      return this.requestUniqueLinkClicksCtrField(true);
    }
    public APIRequestGet requestUniqueLinkClicksCtrField (boolean value) {
      this.requestField("unique_link_clicks_ctr", value);
      return this;
    }
    public APIRequestGet requestUniqueOutboundClicksField () {
      return this.requestUniqueOutboundClicksField(true);
    }
    public APIRequestGet requestUniqueOutboundClicksField (boolean value) {
      this.requestField("unique_outbound_clicks", value);
      return this;
    }
    public APIRequestGet requestUniqueOutboundClicksCtrField () {
      return this.requestUniqueOutboundClicksCtrField(true);
    }
    public APIRequestGet requestUniqueOutboundClicksCtrField (boolean value) {
      this.requestField("unique_outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGet requestUniqueVideoContinuous2SecWatchedActionsField () {
      return this.requestUniqueVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGet requestUniqueVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("unique_video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGet requestUniqueVideoView10SecField () {
      return this.requestUniqueVideoView10SecField(true);
    }
    public APIRequestGet requestUniqueVideoView10SecField (boolean value) {
      this.requestField("unique_video_view_10_sec", value);
      return this;
    }
    public APIRequestGet requestUniqueVideoView15SecField () {
      return this.requestUniqueVideoView15SecField(true);
    }
    public APIRequestGet requestUniqueVideoView15SecField (boolean value) {
      this.requestField("unique_video_view_15_sec", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestVideo10SecWatchedActionsField () {
      return this.requestVideo10SecWatchedActionsField(true);
    }
    public APIRequestGet requestVideo10SecWatchedActionsField (boolean value) {
      this.requestField("video_10_sec_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideo15SecWatchedActionsField () {
      return this.requestVideo15SecWatchedActionsField(true);
    }
    public APIRequestGet requestVideo15SecWatchedActionsField (boolean value) {
      this.requestField("video_15_sec_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideo30SecWatchedActionsField () {
      return this.requestVideo30SecWatchedActionsField(true);
    }
    public APIRequestGet requestVideo30SecWatchedActionsField (boolean value) {
      this.requestField("video_30_sec_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoAssetField () {
      return this.requestVideoAssetField(true);
    }
    public APIRequestGet requestVideoAssetField (boolean value) {
      this.requestField("video_asset", value);
      return this;
    }
    public APIRequestGet requestVideoAvgPercentWatchedActionsField () {
      return this.requestVideoAvgPercentWatchedActionsField(true);
    }
    public APIRequestGet requestVideoAvgPercentWatchedActionsField (boolean value) {
      this.requestField("video_avg_percent_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoAvgTimeWatchedActionsField () {
      return this.requestVideoAvgTimeWatchedActionsField(true);
    }
    public APIRequestGet requestVideoAvgTimeWatchedActionsField (boolean value) {
      this.requestField("video_avg_time_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoContinuous2SecWatchedActionsField () {
      return this.requestVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGet requestVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoP100WatchedActionsField () {
      return this.requestVideoP100WatchedActionsField(true);
    }
    public APIRequestGet requestVideoP100WatchedActionsField (boolean value) {
      this.requestField("video_p100_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoP25WatchedActionsField () {
      return this.requestVideoP25WatchedActionsField(true);
    }
    public APIRequestGet requestVideoP25WatchedActionsField (boolean value) {
      this.requestField("video_p25_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoP50WatchedActionsField () {
      return this.requestVideoP50WatchedActionsField(true);
    }
    public APIRequestGet requestVideoP50WatchedActionsField (boolean value) {
      this.requestField("video_p50_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoP75WatchedActionsField () {
      return this.requestVideoP75WatchedActionsField(true);
    }
    public APIRequestGet requestVideoP75WatchedActionsField (boolean value) {
      this.requestField("video_p75_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoP95WatchedActionsField () {
      return this.requestVideoP95WatchedActionsField(true);
    }
    public APIRequestGet requestVideoP95WatchedActionsField (boolean value) {
      this.requestField("video_p95_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoPlayActionsField () {
      return this.requestVideoPlayActionsField(true);
    }
    public APIRequestGet requestVideoPlayActionsField (boolean value) {
      this.requestField("video_play_actions", value);
      return this;
    }
    public APIRequestGet requestVideoPlayRetention0To15sActionsField () {
      return this.requestVideoPlayRetention0To15sActionsField(true);
    }
    public APIRequestGet requestVideoPlayRetention0To15sActionsField (boolean value) {
      this.requestField("video_play_retention_0_to_15s_actions", value);
      return this;
    }
    public APIRequestGet requestVideoPlayRetention20To60sActionsField () {
      return this.requestVideoPlayRetention20To60sActionsField(true);
    }
    public APIRequestGet requestVideoPlayRetention20To60sActionsField (boolean value) {
      this.requestField("video_play_retention_20_to_60s_actions", value);
      return this;
    }
    public APIRequestGet requestVideoPlayRetentionGraphActionsField () {
      return this.requestVideoPlayRetentionGraphActionsField(true);
    }
    public APIRequestGet requestVideoPlayRetentionGraphActionsField (boolean value) {
      this.requestField("video_play_retention_graph_actions", value);
      return this;
    }
    public APIRequestGet requestVideoThruplayWatchedActionsField () {
      return this.requestVideoThruplayWatchedActionsField(true);
    }
    public APIRequestGet requestVideoThruplayWatchedActionsField (boolean value) {
      this.requestField("video_thruplay_watched_actions", value);
      return this;
    }
    public APIRequestGet requestVideoTimeWatchedActionsField () {
      return this.requestVideoTimeWatchedActionsField(true);
    }
    public APIRequestGet requestVideoTimeWatchedActionsField (boolean value) {
      this.requestField("video_time_watched_actions", value);
      return this;
    }
    public APIRequestGet requestWebsiteCtrField () {
      return this.requestWebsiteCtrField(true);
    }
    public APIRequestGet requestWebsiteCtrField (boolean value) {
      this.requestField("website_ctr", value);
      return this;
    }
    public APIRequestGet requestWebsitePurchaseRoasField () {
      return this.requestWebsitePurchaseRoasField(true);
    }
    public APIRequestGet requestWebsitePurchaseRoasField (boolean value) {
      this.requestField("website_purchase_roas", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static enum EnumActionAttributionWindows {
      @SerializedName("1d_view")
      VALUE_1D_VIEW("1d_view"),
      @SerializedName("7d_view")
      VALUE_7D_VIEW("7d_view"),
      @SerializedName("28d_view")
      VALUE_28D_VIEW("28d_view"),
      @SerializedName("1d_click")
      VALUE_1D_CLICK("1d_click"),
      @SerializedName("7d_click")
      VALUE_7D_CLICK("7d_click"),
      @SerializedName("28d_click")
      VALUE_28D_CLICK("28d_click"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      NULL(null);

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
      @SerializedName("action_link_click_destination")
      VALUE_ACTION_LINK_CLICK_DESTINATION("action_link_click_destination"),
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
      NULL(null);

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
      @SerializedName("impression")
      VALUE_IMPRESSION("impression"),
      @SerializedName("conversion")
      VALUE_CONVERSION("conversion"),
      NULL(null);

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
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("dma")
      VALUE_DMA("dma"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
      @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
      @SerializedName("impression_device")
      VALUE_IMPRESSION_DEVICE("impression_device"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("publisher_platform")
      VALUE_PUBLISHER_PLATFORM("publisher_platform"),
      @SerializedName("platform_position")
      VALUE_PLATFORM_POSITION("platform_position"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("ad_format_asset")
      VALUE_AD_FORMAT_ASSET("ad_format_asset"),
      @SerializedName("body_asset")
      VALUE_BODY_ASSET("body_asset"),
      @SerializedName("call_to_action_asset")
      VALUE_CALL_TO_ACTION_ASSET("call_to_action_asset"),
      @SerializedName("description_asset")
      VALUE_DESCRIPTION_ASSET("description_asset"),
      @SerializedName("image_asset")
      VALUE_IMAGE_ASSET("image_asset"),
      @SerializedName("link_url_asset")
      VALUE_LINK_URL_ASSET("link_url_asset"),
      @SerializedName("title_asset")
      VALUE_TITLE_ASSET("title_asset"),
      @SerializedName("video_asset")
      VALUE_VIDEO_ASSET("video_asset"),
      NULL(null);

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
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      NULL(null);

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
      @SerializedName("ad")
      VALUE_AD("ad"),
      @SerializedName("adset")
      VALUE_ADSET("adset"),
      @SerializedName("campaign")
      VALUE_CAMPAIGN("campaign"),
      @SerializedName("account")
      VALUE_ACCOUNT("account"),
      NULL(null);

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
      @SerializedName("action_link_click_destination")
      VALUE_ACTION_LINK_CLICK_DESTINATION("action_link_click_destination"),
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
      NULL(null);

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
    this.mActivityRecency = instance.mActivityRecency;
    this.mAdClickActions = instance.mAdClickActions;
    this.mAdFormatAsset = instance.mAdFormatAsset;
    this.mAdId = instance.mAdId;
    this.mAdImpressionActions = instance.mAdImpressionActions;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mAge = instance.mAge;
    this.mAgeTargeting = instance.mAgeTargeting;
    this.mBidType = instance.mBidType;
    this.mBodyAsset = instance.mBodyAsset;
    this.mBuyingType = instance.mBuyingType;
    this.mCallToActionAsset = instance.mCallToActionAsset;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCanvasAvgViewPercent = instance.mCanvasAvgViewPercent;
    this.mCanvasAvgViewTime = instance.mCanvasAvgViewTime;
    this.mCanvasComponentAvgPctView = instance.mCanvasComponentAvgPctView;
    this.mClicks = instance.mClicks;
    this.mCostPer10SecVideoView = instance.mCostPer10SecVideoView;
    this.mCostPer15SecVideoView = instance.mCostPer15SecVideoView;
    this.mCostPer2SecContinuousVideoView = instance.mCostPer2SecContinuousVideoView;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerAdClick = instance.mCostPerAdClick;
    this.mCostPerDdaCountbyConvs = instance.mCostPerDdaCountbyConvs;
    this.mCostPerEstimatedAdRecallers = instance.mCostPerEstimatedAdRecallers;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerOneThousandAdImpression = instance.mCostPerOneThousandAdImpression;
    this.mCostPerOutboundClick = instance.mCostPerOutboundClick;
    this.mCostPerThruplay = instance.mCostPerThruplay;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCostPerUniqueInlineLinkClick = instance.mCostPerUniqueInlineLinkClick;
    this.mCostPerUniqueOutboundClick = instance.mCostPerUniqueOutboundClick;
    this.mCountry = instance.mCountry;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeFingerprint = instance.mCreativeFingerprint;
    this.mCtr = instance.mCtr;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDdaCountbyConvs = instance.mDdaCountbyConvs;
    this.mDescriptionAsset = instance.mDescriptionAsset;
    this.mDevicePlatform = instance.mDevicePlatform;
    this.mDma = instance.mDma;
    this.mEstimatedAdRecallRate = instance.mEstimatedAdRecallRate;
    this.mEstimatedAdRecallRateLowerBound = instance.mEstimatedAdRecallRateLowerBound;
    this.mEstimatedAdRecallRateUpperBound = instance.mEstimatedAdRecallRateUpperBound;
    this.mEstimatedAdRecallers = instance.mEstimatedAdRecallers;
    this.mEstimatedAdRecallersLowerBound = instance.mEstimatedAdRecallersLowerBound;
    this.mEstimatedAdRecallersUpperBound = instance.mEstimatedAdRecallersUpperBound;
    this.mFrequency = instance.mFrequency;
    this.mFrequencyValue = instance.mFrequencyValue;
    this.mGender = instance.mGender;
    this.mGenderTargeting = instance.mGenderTargeting;
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = instance.mHourlyStatsAggregatedByAdvertiserTimeZone;
    this.mHourlyStatsAggregatedByAudienceTimeZone = instance.mHourlyStatsAggregatedByAudienceTimeZone;
    this.mImageAsset = instance.mImageAsset;
    this.mImpressionDevice = instance.mImpressionDevice;
    this.mImpressions = instance.mImpressions;
    this.mImpressionsDummy = instance.mImpressionsDummy;
    this.mInlineLinkClickCtr = instance.mInlineLinkClickCtr;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mLabels = instance.mLabels;
    this.mLinkUrlAsset = instance.mLinkUrlAsset;
    this.mLocation = instance.mLocation;
    this.mMediaAsset = instance.mMediaAsset;
    this.mMobileAppPurchaseRoas = instance.mMobileAppPurchaseRoas;
    this.mObjective = instance.mObjective;
    this.mOutboundClicks = instance.mOutboundClicks;
    this.mOutboundClicksCtr = instance.mOutboundClicksCtr;
    this.mPlacePageId = instance.mPlacePageId;
    this.mPlacePageName = instance.mPlacePageName;
    this.mPlacement = instance.mPlacement;
    this.mPlatformPosition = instance.mPlatformPosition;
    this.mProductFormat = instance.mProductFormat;
    this.mProductId = instance.mProductId;
    this.mPublisherPlatform = instance.mPublisherPlatform;
    this.mPurchasingInterface = instance.mPurchasingInterface;
    this.mReach = instance.mReach;
    this.mRegion = instance.mRegion;
    this.mRelevanceScore = instance.mRelevanceScore;
    this.mSocialSpend = instance.mSocialSpend;
    this.mSpend = instance.mSpend;
    this.mTitleAsset = instance.mTitleAsset;
    this.mTotalActionValue = instance.mTotalActionValue;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueCtr = instance.mUniqueCtr;
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
    this.mVideoAvgPercentWatchedActions = instance.mVideoAvgPercentWatchedActions;
    this.mVideoAvgTimeWatchedActions = instance.mVideoAvgTimeWatchedActions;
    this.mVideoContinuous2SecWatchedActions = instance.mVideoContinuous2SecWatchedActions;
    this.mVideoP100WatchedActions = instance.mVideoP100WatchedActions;
    this.mVideoP25WatchedActions = instance.mVideoP25WatchedActions;
    this.mVideoP50WatchedActions = instance.mVideoP50WatchedActions;
    this.mVideoP75WatchedActions = instance.mVideoP75WatchedActions;
    this.mVideoP95WatchedActions = instance.mVideoP95WatchedActions;
    this.mVideoPlayActions = instance.mVideoPlayActions;
    this.mVideoPlayRetention0To15sActions = instance.mVideoPlayRetention0To15sActions;
    this.mVideoPlayRetention20To60sActions = instance.mVideoPlayRetention20To60sActions;
    this.mVideoPlayRetentionGraphActions = instance.mVideoPlayRetentionGraphActions;
    this.mVideoThruplayWatchedActions = instance.mVideoThruplayWatchedActions;
    this.mVideoTimeWatchedActions = instance.mVideoTimeWatchedActions;
    this.mWebsiteCtr = instance.mWebsiteCtr;
    this.mWebsitePurchaseRoas = instance.mWebsitePurchaseRoas;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsInsights> getParser() {
    return new APIRequest.ResponseParser<AdsInsights>() {
      public APINodeList<AdsInsights> parseResponse(String response, APIContext context, APIRequest<AdsInsights> request) throws MalformedResponseException {
        return AdsInsights.parseResponse(response, context, request);
      }
    };
  }
}
