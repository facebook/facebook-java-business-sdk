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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdsInsights extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("action_values")
  private List<AdsActionStats> mActionValues = null;
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("app_store_clicks")
  private Long mAppStoreClicks = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("call_to_action_clicks")
  private Long mCallToActionClicks = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("canvas_avg_view_percent")
  private Double mCanvasAvgViewPercent = null;
  @SerializedName("canvas_avg_view_time")
  private Double mCanvasAvgViewTime = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("cost_per_10_sec_video_view")
  private List<AdsActionStats> mCostPer10SecVideoView = null;
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_estimated_ad_recallers")
  private Double mCostPerEstimatedAdRecallers = null;
  @SerializedName("cost_per_inline_link_click")
  private Double mCostPerInlineLinkClick = null;
  @SerializedName("cost_per_inline_post_engagement")
  private Double mCostPerInlinePostEngagement = null;
  @SerializedName("cost_per_total_action")
  private Double mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_action_type")
  private List<AdsActionStats> mCostPerUniqueActionType = null;
  @SerializedName("cost_per_unique_click")
  private Double mCostPerUniqueClick = null;
  @SerializedName("cost_per_unique_inline_link_click")
  private Double mCostPerUniqueInlineLinkClick = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("cpc")
  private Double mCpc = null;
  @SerializedName("cpm")
  private Double mCpm = null;
  @SerializedName("cpp")
  private Double mCpp = null;
  @SerializedName("ctr")
  private Double mCtr = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("deeplink_clicks")
  private Long mDeeplinkClicks = null;
  @SerializedName("estimated_ad_recall_rate")
  private Double mEstimatedAdRecallRate = null;
  @SerializedName("estimated_ad_recallers")
  private Long mEstimatedAdRecallers = null;
  @SerializedName("frequency")
  private Double mFrequency = null;
  @SerializedName("frequency_value")
  private String mFrequencyValue = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
  private String mHourlyStatsAggregatedByAdvertiserTimeZone = null;
  @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
  private String mHourlyStatsAggregatedByAudienceTimeZone = null;
  @SerializedName("impression_device")
  private String mImpressionDevice = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("inline_link_click_ctr")
  private Double mInlineLinkClickCtr = null;
  @SerializedName("inline_link_clicks")
  private Long mInlineLinkClicks = null;
  @SerializedName("inline_post_engagement")
  private Long mInlinePostEngagement = null;
  @SerializedName("newsfeed_avg_position")
  private Double mNewsfeedAvgPosition = null;
  @SerializedName("newsfeed_clicks")
  private Long mNewsfeedClicks = null;
  @SerializedName("newsfeed_impressions")
  private Long mNewsfeedImpressions = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("place_page_id")
  private String mPlacePageId = null;
  @SerializedName("place_page_name")
  private String mPlacePageName = null;
  @SerializedName("placement")
  private String mPlacement = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("relevance_score")
  private AdgroupRelevanceScore mRelevanceScore = null;
  @SerializedName("social_clicks")
  private Long mSocialClicks = null;
  @SerializedName("social_impressions")
  private Object mSocialImpressions = null;
  @SerializedName("social_reach")
  private Long mSocialReach = null;
  @SerializedName("social_spend")
  private Double mSocialSpend = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("total_action_value")
  private Double mTotalActionValue = null;
  @SerializedName("total_actions")
  private Long mTotalActions = null;
  @SerializedName("total_unique_actions")
  private Long mTotalUniqueActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_ctr")
  private Double mUniqueCtr = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  @SerializedName("unique_inline_link_click_ctr")
  private Double mUniqueInlineLinkClickCtr = null;
  @SerializedName("unique_inline_link_clicks")
  private Long mUniqueInlineLinkClicks = null;
  @SerializedName("unique_link_clicks_ctr")
  private Double mUniqueLinkClicksCtr = null;
  @SerializedName("unique_social_clicks")
  private Long mUniqueSocialClicks = null;
  @SerializedName("unique_social_impressions")
  private Long mUniqueSocialImpressions = null;
  @SerializedName("video_10_sec_watched_actions")
  private List<AdsActionStats> mVideo10SecWatchedActions = null;
  @SerializedName("video_15_sec_watched_actions")
  private List<AdsActionStats> mVideo15SecWatchedActions = null;
  @SerializedName("video_30_sec_watched_actions")
  private List<AdsActionStats> mVideo30SecWatchedActions = null;
  @SerializedName("video_avg_pct_watched_actions")
  private List<AdsActionStats> mVideoAvgPctWatchedActions = null;
  @SerializedName("video_avg_sec_watched_actions")
  private List<AdsActionStats> mVideoAvgSecWatchedActions = null;
  @SerializedName("video_complete_watched_actions")
  private List<AdsActionStats> mVideoCompleteWatchedActions = null;
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
  @SerializedName("website_clicks")
  private Long mWebsiteClicks = null;
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  protected static Gson gson = null;

  public AdsInsights() {
  }

  public String getId() {
    return null;
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
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adsInsightss.setPaging(before, after);
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
  public String getFieldAdId() {
    return mAdId;
  }

  public AdsInsights setFieldAdId(String value) {
    this.mAdId = value;
    return this;
  }

  public String getFieldAdName() {
    return mAdName;
  }

  public AdsInsights setFieldAdName(String value) {
    this.mAdName = value;
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

  public String getFieldAge() {
    return mAge;
  }

  public AdsInsights setFieldAge(String value) {
    this.mAge = value;
    return this;
  }

  public Long getFieldAppStoreClicks() {
    return mAppStoreClicks;
  }

  public AdsInsights setFieldAppStoreClicks(Long value) {
    this.mAppStoreClicks = value;
    return this;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public AdsInsights setFieldBuyingType(String value) {
    this.mBuyingType = value;
    return this;
  }

  public Long getFieldCallToActionClicks() {
    return mCallToActionClicks;
  }

  public AdsInsights setFieldCallToActionClicks(Long value) {
    this.mCallToActionClicks = value;
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

  public Double getFieldCanvasAvgViewPercent() {
    return mCanvasAvgViewPercent;
  }

  public AdsInsights setFieldCanvasAvgViewPercent(Double value) {
    this.mCanvasAvgViewPercent = value;
    return this;
  }

  public Double getFieldCanvasAvgViewTime() {
    return mCanvasAvgViewTime;
  }

  public AdsInsights setFieldCanvasAvgViewTime(Double value) {
    this.mCanvasAvgViewTime = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public AdsInsights setFieldClicks(Long value) {
    this.mClicks = value;
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
  public Double getFieldCostPerEstimatedAdRecallers() {
    return mCostPerEstimatedAdRecallers;
  }

  public AdsInsights setFieldCostPerEstimatedAdRecallers(Double value) {
    this.mCostPerEstimatedAdRecallers = value;
    return this;
  }

  public Double getFieldCostPerInlineLinkClick() {
    return mCostPerInlineLinkClick;
  }

  public AdsInsights setFieldCostPerInlineLinkClick(Double value) {
    this.mCostPerInlineLinkClick = value;
    return this;
  }

  public Double getFieldCostPerInlinePostEngagement() {
    return mCostPerInlinePostEngagement;
  }

  public AdsInsights setFieldCostPerInlinePostEngagement(Double value) {
    this.mCostPerInlinePostEngagement = value;
    return this;
  }

  public Double getFieldCostPerTotalAction() {
    return mCostPerTotalAction;
  }

  public AdsInsights setFieldCostPerTotalAction(Double value) {
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
  public Double getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public AdsInsights setFieldCostPerUniqueClick(Double value) {
    this.mCostPerUniqueClick = value;
    return this;
  }

  public Double getFieldCostPerUniqueInlineLinkClick() {
    return mCostPerUniqueInlineLinkClick;
  }

  public AdsInsights setFieldCostPerUniqueInlineLinkClick(Double value) {
    this.mCostPerUniqueInlineLinkClick = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public AdsInsights setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public Double getFieldCpc() {
    return mCpc;
  }

  public AdsInsights setFieldCpc(Double value) {
    this.mCpc = value;
    return this;
  }

  public Double getFieldCpm() {
    return mCpm;
  }

  public AdsInsights setFieldCpm(Double value) {
    this.mCpm = value;
    return this;
  }

  public Double getFieldCpp() {
    return mCpp;
  }

  public AdsInsights setFieldCpp(Double value) {
    this.mCpp = value;
    return this;
  }

  public Double getFieldCtr() {
    return mCtr;
  }

  public AdsInsights setFieldCtr(Double value) {
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

  public Long getFieldDeeplinkClicks() {
    return mDeeplinkClicks;
  }

  public AdsInsights setFieldDeeplinkClicks(Long value) {
    this.mDeeplinkClicks = value;
    return this;
  }

  public Double getFieldEstimatedAdRecallRate() {
    return mEstimatedAdRecallRate;
  }

  public AdsInsights setFieldEstimatedAdRecallRate(Double value) {
    this.mEstimatedAdRecallRate = value;
    return this;
  }

  public Long getFieldEstimatedAdRecallers() {
    return mEstimatedAdRecallers;
  }

  public AdsInsights setFieldEstimatedAdRecallers(Long value) {
    this.mEstimatedAdRecallers = value;
    return this;
  }

  public Double getFieldFrequency() {
    return mFrequency;
  }

  public AdsInsights setFieldFrequency(Double value) {
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

  public String getFieldGender() {
    return mGender;
  }

  public AdsInsights setFieldGender(String value) {
    this.mGender = value;
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

  public Double getFieldInlineLinkClickCtr() {
    return mInlineLinkClickCtr;
  }

  public AdsInsights setFieldInlineLinkClickCtr(Double value) {
    this.mInlineLinkClickCtr = value;
    return this;
  }

  public Long getFieldInlineLinkClicks() {
    return mInlineLinkClicks;
  }

  public AdsInsights setFieldInlineLinkClicks(Long value) {
    this.mInlineLinkClicks = value;
    return this;
  }

  public Long getFieldInlinePostEngagement() {
    return mInlinePostEngagement;
  }

  public AdsInsights setFieldInlinePostEngagement(Long value) {
    this.mInlinePostEngagement = value;
    return this;
  }

  public Double getFieldNewsfeedAvgPosition() {
    return mNewsfeedAvgPosition;
  }

  public AdsInsights setFieldNewsfeedAvgPosition(Double value) {
    this.mNewsfeedAvgPosition = value;
    return this;
  }

  public Long getFieldNewsfeedClicks() {
    return mNewsfeedClicks;
  }

  public AdsInsights setFieldNewsfeedClicks(Long value) {
    this.mNewsfeedClicks = value;
    return this;
  }

  public Long getFieldNewsfeedImpressions() {
    return mNewsfeedImpressions;
  }

  public AdsInsights setFieldNewsfeedImpressions(Long value) {
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

  public String getFieldProductId() {
    return mProductId;
  }

  public AdsInsights setFieldProductId(String value) {
    this.mProductId = value;
    return this;
  }

  public Long getFieldReach() {
    return mReach;
  }

  public AdsInsights setFieldReach(Long value) {
    this.mReach = value;
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
  public Long getFieldSocialClicks() {
    return mSocialClicks;
  }

  public AdsInsights setFieldSocialClicks(Long value) {
    this.mSocialClicks = value;
    return this;
  }

  public Object getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public AdsInsights setFieldSocialImpressions(Object value) {
    this.mSocialImpressions = value;
    return this;
  }

  public Long getFieldSocialReach() {
    return mSocialReach;
  }

  public AdsInsights setFieldSocialReach(Long value) {
    this.mSocialReach = value;
    return this;
  }

  public Double getFieldSocialSpend() {
    return mSocialSpend;
  }

  public AdsInsights setFieldSocialSpend(Double value) {
    this.mSocialSpend = value;
    return this;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public AdsInsights setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public Double getFieldTotalActionValue() {
    return mTotalActionValue;
  }

  public AdsInsights setFieldTotalActionValue(Double value) {
    this.mTotalActionValue = value;
    return this;
  }

  public Long getFieldTotalActions() {
    return mTotalActions;
  }

  public AdsInsights setFieldTotalActions(Long value) {
    this.mTotalActions = value;
    return this;
  }

  public Long getFieldTotalUniqueActions() {
    return mTotalUniqueActions;
  }

  public AdsInsights setFieldTotalUniqueActions(Long value) {
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
  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdsInsights setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
    return this;
  }

  public Double getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public AdsInsights setFieldUniqueCtr(Double value) {
    this.mUniqueCtr = value;
    return this;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdsInsights setFieldUniqueImpressions(Long value) {
    this.mUniqueImpressions = value;
    return this;
  }

  public Double getFieldUniqueInlineLinkClickCtr() {
    return mUniqueInlineLinkClickCtr;
  }

  public AdsInsights setFieldUniqueInlineLinkClickCtr(Double value) {
    this.mUniqueInlineLinkClickCtr = value;
    return this;
  }

  public Long getFieldUniqueInlineLinkClicks() {
    return mUniqueInlineLinkClicks;
  }

  public AdsInsights setFieldUniqueInlineLinkClicks(Long value) {
    this.mUniqueInlineLinkClicks = value;
    return this;
  }

  public Double getFieldUniqueLinkClicksCtr() {
    return mUniqueLinkClicksCtr;
  }

  public AdsInsights setFieldUniqueLinkClicksCtr(Double value) {
    this.mUniqueLinkClicksCtr = value;
    return this;
  }

  public Long getFieldUniqueSocialClicks() {
    return mUniqueSocialClicks;
  }

  public AdsInsights setFieldUniqueSocialClicks(Long value) {
    this.mUniqueSocialClicks = value;
    return this;
  }

  public Long getFieldUniqueSocialImpressions() {
    return mUniqueSocialImpressions;
  }

  public AdsInsights setFieldUniqueSocialImpressions(Long value) {
    this.mUniqueSocialImpressions = value;
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
  public List<AdsActionStats> getFieldVideoAvgPctWatchedActions() {
    return mVideoAvgPctWatchedActions;
  }

  public AdsInsights setFieldVideoAvgPctWatchedActions(List<AdsActionStats> value) {
    this.mVideoAvgPctWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoAvgPctWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoAvgPctWatchedActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public List<AdsActionStats> getFieldVideoAvgSecWatchedActions() {
    return mVideoAvgSecWatchedActions;
  }

  public AdsInsights setFieldVideoAvgSecWatchedActions(List<AdsActionStats> value) {
    this.mVideoAvgSecWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoAvgSecWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoAvgSecWatchedActions = AdsActionStats.getGson().fromJson(value, type);
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
  public Long getFieldWebsiteClicks() {
    return mWebsiteClicks;
  }

  public AdsInsights setFieldWebsiteClicks(Long value) {
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
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
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
      @SerializedName("placement")
      VALUE_PLACEMENT("placement"),
      @SerializedName("placement_merge_rhc")
      VALUE_PLACEMENT_MERGE_RHC("placement_merge_rhc"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("region")
      VALUE_REGION("region"),
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
      @SerializedName("last_3_days")
      VALUE_LAST_3_DAYS("last_3_days"),
      @SerializedName("this_week")
      VALUE_THIS_WEEK("this_week"),
      @SerializedName("last_week")
      VALUE_LAST_WEEK("last_week"),
      @SerializedName("last_7_days")
      VALUE_LAST_7_DAYS("last_7_days"),
      @SerializedName("last_14_days")
      VALUE_LAST_14_DAYS("last_14_days"),
      @SerializedName("last_28_days")
      VALUE_LAST_28_DAYS("last_28_days"),
      @SerializedName("last_30_days")
      VALUE_LAST_30_DAYS("last_30_days"),
      @SerializedName("last_90_days")
      VALUE_LAST_90_DAYS("last_90_days"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("last_3_months")
      VALUE_LAST_3_MONTHS("last_3_months"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
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
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
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

  public static enum EnumSummary {
      @SerializedName("id")
      VALUE_ID("id"),
      @SerializedName("account_id")
      VALUE_ACCOUNT_ID("account_id"),
      @SerializedName("async_percent_completion")
      VALUE_ASYNC_PERCENT_COMPLETION("async_percent_completion"),
      @SerializedName("async_status")
      VALUE_ASYNC_STATUS("async_status"),
      @SerializedName("date_start")
      VALUE_DATE_START("date_start"),
      @SerializedName("date_stop")
      VALUE_DATE_STOP("date_stop"),
      @SerializedName("emails")
      VALUE_EMAILS("emails"),
      @SerializedName("friendly_name")
      VALUE_FRIENDLY_NAME("friendly_name"),
      @SerializedName("is_bookmarked")
      VALUE_IS_BOOKMARKED("is_bookmarked"),
      @SerializedName("is_running")
      VALUE_IS_RUNNING("is_running"),
      @SerializedName("schedule_id")
      VALUE_SCHEDULE_ID("schedule_id"),
      @SerializedName("time_completed")
      VALUE_TIME_COMPLETED("time_completed"),
      @SerializedName("time_ref")
      VALUE_TIME_REF("time_ref"),
      NULL(null);

      private String value;

      private EnumSummary(String value) {
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
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mActionValues = instance.mActionValues;
    this.mActions = instance.mActions;
    this.mAdId = instance.mAdId;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mAge = instance.mAge;
    this.mAppStoreClicks = instance.mAppStoreClicks;
    this.mBuyingType = instance.mBuyingType;
    this.mCallToActionClicks = instance.mCallToActionClicks;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCanvasAvgViewPercent = instance.mCanvasAvgViewPercent;
    this.mCanvasAvgViewTime = instance.mCanvasAvgViewTime;
    this.mClicks = instance.mClicks;
    this.mCostPer10SecVideoView = instance.mCostPer10SecVideoView;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerEstimatedAdRecallers = instance.mCostPerEstimatedAdRecallers;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCostPerUniqueInlineLinkClick = instance.mCostPerUniqueInlineLinkClick;
    this.mCountry = instance.mCountry;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCtr = instance.mCtr;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDeeplinkClicks = instance.mDeeplinkClicks;
    this.mEstimatedAdRecallRate = instance.mEstimatedAdRecallRate;
    this.mEstimatedAdRecallers = instance.mEstimatedAdRecallers;
    this.mFrequency = instance.mFrequency;
    this.mFrequencyValue = instance.mFrequencyValue;
    this.mGender = instance.mGender;
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = instance.mHourlyStatsAggregatedByAdvertiserTimeZone;
    this.mHourlyStatsAggregatedByAudienceTimeZone = instance.mHourlyStatsAggregatedByAudienceTimeZone;
    this.mImpressionDevice = instance.mImpressionDevice;
    this.mImpressions = instance.mImpressions;
    this.mInlineLinkClickCtr = instance.mInlineLinkClickCtr;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mNewsfeedAvgPosition = instance.mNewsfeedAvgPosition;
    this.mNewsfeedClicks = instance.mNewsfeedClicks;
    this.mNewsfeedImpressions = instance.mNewsfeedImpressions;
    this.mObjective = instance.mObjective;
    this.mPlacePageId = instance.mPlacePageId;
    this.mPlacePageName = instance.mPlacePageName;
    this.mPlacement = instance.mPlacement;
    this.mProductId = instance.mProductId;
    this.mReach = instance.mReach;
    this.mRegion = instance.mRegion;
    this.mRelevanceScore = instance.mRelevanceScore;
    this.mSocialClicks = instance.mSocialClicks;
    this.mSocialImpressions = instance.mSocialImpressions;
    this.mSocialReach = instance.mSocialReach;
    this.mSocialSpend = instance.mSocialSpend;
    this.mSpend = instance.mSpend;
    this.mTotalActionValue = instance.mTotalActionValue;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.mUniqueInlineLinkClickCtr = instance.mUniqueInlineLinkClickCtr;
    this.mUniqueInlineLinkClicks = instance.mUniqueInlineLinkClicks;
    this.mUniqueLinkClicksCtr = instance.mUniqueLinkClicksCtr;
    this.mUniqueSocialClicks = instance.mUniqueSocialClicks;
    this.mUniqueSocialImpressions = instance.mUniqueSocialImpressions;
    this.mVideo10SecWatchedActions = instance.mVideo10SecWatchedActions;
    this.mVideo15SecWatchedActions = instance.mVideo15SecWatchedActions;
    this.mVideo30SecWatchedActions = instance.mVideo30SecWatchedActions;
    this.mVideoAvgPctWatchedActions = instance.mVideoAvgPctWatchedActions;
    this.mVideoAvgSecWatchedActions = instance.mVideoAvgSecWatchedActions;
    this.mVideoCompleteWatchedActions = instance.mVideoCompleteWatchedActions;
    this.mVideoP100WatchedActions = instance.mVideoP100WatchedActions;
    this.mVideoP25WatchedActions = instance.mVideoP25WatchedActions;
    this.mVideoP50WatchedActions = instance.mVideoP50WatchedActions;
    this.mVideoP75WatchedActions = instance.mVideoP75WatchedActions;
    this.mVideoP95WatchedActions = instance.mVideoP95WatchedActions;
    this.mWebsiteClicks = instance.mWebsiteClicks;
    this.mWebsiteCtr = instance.mWebsiteCtr;
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
