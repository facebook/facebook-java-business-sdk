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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdsInsights extends APINode {
  @SerializedName("frequency_value")
  private String mFrequencyValue = null;
  @SerializedName("age")
  private String mAge = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("impression_device")
  private String mImpressionDevice = null;
  @SerializedName("place_page_id")
  private String mPlacePageId = null;
  @SerializedName("placement")
  private String mPlacement = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
  private String mHourlyStatsAggregatedByAdvertiserTimeZone = null;
  @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
  private String mHourlyStatsAggregatedByAudienceTimeZone = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("action_values")
  private List<AdsActionStats> mActionValues = null;
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("app_store_clicks")
  private Long mAppStoreClicks = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("call_to_action_clicks")
  private Long mCallToActionClicks = null;
  @SerializedName("card_views")
  private String mCardViews = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_unique_action_type")
  private List<AdsActionStats> mCostPerUniqueActionType = null;
  @SerializedName("cost_per_inline_post_engagement")
  private Double mCostPerInlinePostEngagement = null;
  @SerializedName("cost_per_inline_link_click")
  private Double mCostPerInlineLinkClick = null;
  @SerializedName("cost_per_total_action")
  private Double mCostPerTotalAction = null;
  @SerializedName("cost_per_10_sec_video_view")
  private List<AdsActionStats> mCostPer10SecVideoView = null;
  @SerializedName("cost_per_unique_click")
  private Double mCostPerUniqueClick = null;
  @SerializedName("cpm")
  private Double mCpm = null;
  @SerializedName("cpp")
  private Double mCpp = null;
  @SerializedName("ctr")
  private Double mCtr = null;
  @SerializedName("unique_ctr")
  private Double mUniqueCtr = null;
  @SerializedName("unique_link_clicks_ctr")
  private Double mUniqueLinkClicksCtr = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("deeplink_clicks")
  private Long mDeeplinkClicks = null;
  @SerializedName("frequency")
  private Double mFrequency = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
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
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("relevance_score")
  private AdgroupRelevanceScore mRelevanceScore = null;
  @SerializedName("social_clicks")
  private Long mSocialClicks = null;
  @SerializedName("unique_social_clicks")
  private Long mUniqueSocialClicks = null;
  @SerializedName("social_impressions")
  private Long mSocialImpressions = null;
  @SerializedName("unique_social_impressions")
  private Long mUniqueSocialImpressions = null;
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
  @SerializedName("video_avg_pct_watched_actions")
  private List<AdsActionStats> mVideoAvgPctWatchedActions = null;
  @SerializedName("video_avg_sec_watched_actions")
  private List<AdsActionStats> mVideoAvgSecWatchedActions = null;
  @SerializedName("video_complete_watched_actions")
  private List<AdsActionStats> mVideoCompleteWatchedActions = null;
  @SerializedName("video_p25_watched_actions")
  private List<AdsActionStats> mVideoP25WatchedActions = null;
  @SerializedName("video_p50_watched_actions")
  private List<AdsActionStats> mVideoP50WatchedActions = null;
  @SerializedName("video_p75_watched_actions")
  private List<AdsActionStats> mVideoP75WatchedActions = null;
  @SerializedName("video_p95_watched_actions")
  private List<AdsActionStats> mVideoP95WatchedActions = null;
  @SerializedName("video_p100_watched_actions")
  private List<AdsActionStats> mVideoP100WatchedActions = null;
  @SerializedName("video_10_sec_watched_actions")
  private List<AdsActionStats> mVideo10SecWatchedActions = null;
  @SerializedName("video_15_sec_watched_actions")
  private List<AdsActionStats> mVideo15SecWatchedActions = null;
  @SerializedName("video_30_sec_watched_actions")
  private List<AdsActionStats> mVideo30SecWatchedActions = null;
  @SerializedName("website_clicks")
  private Long mWebsiteClicks = null;
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsInsights.mContext = context;
    adsInsights.rawValue = json;
    return adsInsights;
  }

  public static APINodeList<AdsInsights> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdsInsights> adsInsightss = new APINodeList<AdsInsights>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adsInsightss.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            adsInsightss.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          adsInsightss.add(loadJSON(json, context));
          return adsInsightss;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldFrequencyValue() {
    return mFrequencyValue;
  }

  public AdsInsights setFieldFrequencyValue(String value) {
    this.mFrequencyValue = value;
    return this;
  }

  public String getFieldAge() {
    return mAge;
  }

  public AdsInsights setFieldAge(String value) {
    this.mAge = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public AdsInsights setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldGender() {
    return mGender;
  }

  public AdsInsights setFieldGender(String value) {
    this.mGender = value;
    return this;
  }

  public String getFieldImpressionDevice() {
    return mImpressionDevice;
  }

  public AdsInsights setFieldImpressionDevice(String value) {
    this.mImpressionDevice = value;
    return this;
  }

  public String getFieldPlacePageId() {
    return mPlacePageId;
  }

  public AdsInsights setFieldPlacePageId(String value) {
    this.mPlacePageId = value;
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

  public String getFieldRegion() {
    return mRegion;
  }

  public AdsInsights setFieldRegion(String value) {
    this.mRegion = value;
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

  public String getFieldCardViews() {
    return mCardViews;
  }

  public AdsInsights setFieldCardViews(String value) {
    this.mCardViews = value;
    return this;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdsInsights setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
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
  public Double getFieldCostPerInlinePostEngagement() {
    return mCostPerInlinePostEngagement;
  }

  public AdsInsights setFieldCostPerInlinePostEngagement(Double value) {
    this.mCostPerInlinePostEngagement = value;
    return this;
  }

  public Double getFieldCostPerInlineLinkClick() {
    return mCostPerInlineLinkClick;
  }

  public AdsInsights setFieldCostPerInlineLinkClick(Double value) {
    this.mCostPerInlineLinkClick = value;
    return this;
  }

  public Double getFieldCostPerTotalAction() {
    return mCostPerTotalAction;
  }

  public AdsInsights setFieldCostPerTotalAction(Double value) {
    this.mCostPerTotalAction = value;
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
  public Double getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public AdsInsights setFieldCostPerUniqueClick(Double value) {
    this.mCostPerUniqueClick = value;
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

  public Double getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public AdsInsights setFieldUniqueCtr(Double value) {
    this.mUniqueCtr = value;
    return this;
  }

  public Double getFieldUniqueLinkClicksCtr() {
    return mUniqueLinkClicksCtr;
  }

  public AdsInsights setFieldUniqueLinkClicksCtr(Double value) {
    this.mUniqueLinkClicksCtr = value;
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

  public Double getFieldFrequency() {
    return mFrequency;
  }

  public AdsInsights setFieldFrequency(Double value) {
    this.mFrequency = value;
    return this;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public AdsInsights setFieldImpressions(String value) {
    this.mImpressions = value;
    return this;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdsInsights setFieldUniqueImpressions(Long value) {
    this.mUniqueImpressions = value;
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

  public Long getFieldReach() {
    return mReach;
  }

  public AdsInsights setFieldReach(Long value) {
    this.mReach = value;
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

  public Long getFieldUniqueSocialClicks() {
    return mUniqueSocialClicks;
  }

  public AdsInsights setFieldUniqueSocialClicks(Long value) {
    this.mUniqueSocialClicks = value;
    return this;
  }

  public Long getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public AdsInsights setFieldSocialImpressions(Long value) {
    this.mSocialImpressions = value;
    return this;
  }

  public Long getFieldUniqueSocialImpressions() {
    return mUniqueSocialImpressions;
  }

  public AdsInsights setFieldUniqueSocialImpressions(Long value) {
    this.mUniqueSocialImpressions = value;
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
    this.mFrequencyValue = instance.mFrequencyValue;
    this.mAge = instance.mAge;
    this.mCountry = instance.mCountry;
    this.mGender = instance.mGender;
    this.mImpressionDevice = instance.mImpressionDevice;
    this.mPlacePageId = instance.mPlacePageId;
    this.mPlacement = instance.mPlacement;
    this.mProductId = instance.mProductId;
    this.mRegion = instance.mRegion;
    this.mHourlyStatsAggregatedByAdvertiserTimeZone = instance.mHourlyStatsAggregatedByAdvertiserTimeZone;
    this.mHourlyStatsAggregatedByAudienceTimeZone = instance.mHourlyStatsAggregatedByAudienceTimeZone;
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mActionValues = instance.mActionValues;
    this.mActions = instance.mActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mAppStoreClicks = instance.mAppStoreClicks;
    this.mBuyingType = instance.mBuyingType;
    this.mCallToActionClicks = instance.mCallToActionClicks;
    this.mCardViews = instance.mCardViews;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPer10SecVideoView = instance.mCostPer10SecVideoView;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCtr = instance.mCtr;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueLinkClicksCtr = instance.mUniqueLinkClicksCtr;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDeeplinkClicks = instance.mDeeplinkClicks;
    this.mFrequency = instance.mFrequency;
    this.mImpressions = instance.mImpressions;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mNewsfeedAvgPosition = instance.mNewsfeedAvgPosition;
    this.mNewsfeedClicks = instance.mNewsfeedClicks;
    this.mNewsfeedImpressions = instance.mNewsfeedImpressions;
    this.mReach = instance.mReach;
    this.mRelevanceScore = instance.mRelevanceScore;
    this.mSocialClicks = instance.mSocialClicks;
    this.mUniqueSocialClicks = instance.mUniqueSocialClicks;
    this.mSocialImpressions = instance.mSocialImpressions;
    this.mUniqueSocialImpressions = instance.mUniqueSocialImpressions;
    this.mSocialReach = instance.mSocialReach;
    this.mSocialSpend = instance.mSocialSpend;
    this.mSpend = instance.mSpend;
    this.mTotalActionValue = instance.mTotalActionValue;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mVideoAvgPctWatchedActions = instance.mVideoAvgPctWatchedActions;
    this.mVideoAvgSecWatchedActions = instance.mVideoAvgSecWatchedActions;
    this.mVideoCompleteWatchedActions = instance.mVideoCompleteWatchedActions;
    this.mVideoP25WatchedActions = instance.mVideoP25WatchedActions;
    this.mVideoP50WatchedActions = instance.mVideoP50WatchedActions;
    this.mVideoP75WatchedActions = instance.mVideoP75WatchedActions;
    this.mVideoP95WatchedActions = instance.mVideoP95WatchedActions;
    this.mVideoP100WatchedActions = instance.mVideoP100WatchedActions;
    this.mVideo10SecWatchedActions = instance.mVideo10SecWatchedActions;
    this.mVideo15SecWatchedActions = instance.mVideo15SecWatchedActions;
    this.mVideo30SecWatchedActions = instance.mVideo30SecWatchedActions;
    this.mWebsiteClicks = instance.mWebsiteClicks;
    this.mWebsiteCtr = instance.mWebsiteCtr;
    this.mAdId = instance.mAdId;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}