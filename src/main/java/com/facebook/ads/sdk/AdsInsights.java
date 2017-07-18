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
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("call_to_action_clicks")
  private String mCallToActionClicks = null;
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
  @SerializedName("cost_per_action_type")
  private List<AdsActionStats> mCostPerActionType = null;
  @SerializedName("cost_per_estimated_ad_recallers")
  private String mCostPerEstimatedAdRecallers = null;
  @SerializedName("cost_per_inline_link_click")
  private String mCostPerInlineLinkClick = null;
  @SerializedName("cost_per_inline_post_engagement")
  private String mCostPerInlinePostEngagement = null;
  @SerializedName("cost_per_outbound_click")
  private List<AdsActionStats> mCostPerOutboundClick = null;
  @SerializedName("cost_per_total_action")
  private String mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_action_type")
  private List<AdsActionStats> mCostPerUniqueActionType = null;
  @SerializedName("cost_per_unique_click")
  private String mCostPerUniqueClick = null;
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
  @SerializedName("ctr")
  private String mCtr = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("estimated_ad_recall_rate")
  private String mEstimatedAdRecallRate = null;
  @SerializedName("estimated_ad_recallers")
  private String mEstimatedAdRecallers = null;
  @SerializedName("frequency")
  private String mFrequency = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("inline_link_click_ctr")
  private String mInlineLinkClickCtr = null;
  @SerializedName("inline_link_clicks")
  private String mInlineLinkClicks = null;
  @SerializedName("inline_post_engagement")
  private String mInlinePostEngagement = null;
  @SerializedName("mobile_app_purchase_roas")
  private List<AdsActionStats> mMobileAppPurchaseRoas = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("outbound_clicks")
  private List<AdsActionStats> mOutboundClicks = null;
  @SerializedName("outbound_clicks_ctr")
  private List<AdsActionStats> mOutboundClicksCtr = null;
  @SerializedName("place_page_name")
  private String mPlacePageName = null;
  @SerializedName("reach")
  private String mReach = null;
  @SerializedName("relevance_score")
  private AdgroupRelevanceScore mRelevanceScore = null;
  @SerializedName("social_clicks")
  private String mSocialClicks = null;
  @SerializedName("social_impressions")
  private String mSocialImpressions = null;
  @SerializedName("social_reach")
  private String mSocialReach = null;
  @SerializedName("social_spend")
  private String mSocialSpend = null;
  @SerializedName("spend")
  private String mSpend = null;
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
  @SerializedName("unique_social_clicks")
  private String mUniqueSocialClicks = null;
  @SerializedName("video_10_sec_watched_actions")
  private List<AdsActionStats> mVideo10SecWatchedActions = null;
  @SerializedName("video_15_sec_watched_actions")
  private List<AdsActionStats> mVideo15SecWatchedActions = null;
  @SerializedName("video_30_sec_watched_actions")
  private List<AdsActionStats> mVideo30SecWatchedActions = null;
  @SerializedName("video_avg_percent_watched_actions")
  private List<AdsActionStats> mVideoAvgPercentWatchedActions = null;
  @SerializedName("video_avg_time_watched_actions")
  private List<AdsActionStats> mVideoAvgTimeWatchedActions = null;
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
  @SerializedName("website_ctr")
  private List<AdsActionStats> mWebsiteCtr = null;
  @SerializedName("website_purchase_roas")
  private List<AdsActionStats> mWebsitePurchaseRoas = null;
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

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public AdsInsights setFieldBuyingType(String value) {
    this.mBuyingType = value;
    return this;
  }

  public String getFieldCallToActionClicks() {
    return mCallToActionClicks;
  }

  public AdsInsights setFieldCallToActionClicks(String value) {
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

  public List<AdsActionStats> getFieldCanvasComponentAvgPctView() {
    return mCanvasComponentAvgPctView;
  }

  public AdsInsights setFieldCanvasComponentAvgPctView(List<AdsActionStats> value) {
    this.mCanvasComponentAvgPctView = value;
    return this;
  }

  public AdsInsights setFieldCanvasComponentAvgPctView(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mCanvasComponentAvgPctView = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldClicks() {
    return mClicks;
  }

  public AdsInsights setFieldClicks(String value) {
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

  public String getFieldEstimatedAdRecallRate() {
    return mEstimatedAdRecallRate;
  }

  public AdsInsights setFieldEstimatedAdRecallRate(String value) {
    this.mEstimatedAdRecallRate = value;
    return this;
  }

  public String getFieldEstimatedAdRecallers() {
    return mEstimatedAdRecallers;
  }

  public AdsInsights setFieldEstimatedAdRecallers(String value) {
    this.mEstimatedAdRecallers = value;
    return this;
  }

  public String getFieldFrequency() {
    return mFrequency;
  }

  public AdsInsights setFieldFrequency(String value) {
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

  public String getFieldReach() {
    return mReach;
  }

  public AdsInsights setFieldReach(String value) {
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
  public String getFieldSocialClicks() {
    return mSocialClicks;
  }

  public AdsInsights setFieldSocialClicks(String value) {
    this.mSocialClicks = value;
    return this;
  }

  public String getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public AdsInsights setFieldSocialImpressions(String value) {
    this.mSocialImpressions = value;
    return this;
  }

  public String getFieldSocialReach() {
    return mSocialReach;
  }

  public AdsInsights setFieldSocialReach(String value) {
    this.mSocialReach = value;
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
  public String getFieldUniqueSocialClicks() {
    return mUniqueSocialClicks;
  }

  public AdsInsights setFieldUniqueSocialClicks(String value) {
    this.mUniqueSocialClicks = value;
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
  public List<AdsActionStats> getFieldVideoAvgPercentWatchedActions() {
    return mVideoAvgPercentWatchedActions;
  }

  public AdsInsights setFieldVideoAvgPercentWatchedActions(List<AdsActionStats> value) {
    this.mVideoAvgPercentWatchedActions = value;
    return this;
  }

  public AdsInsights setFieldVideoAvgPercentWatchedActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mVideoAvgPercentWatchedActions = AdsActionStats.getGson().fromJson(value, type);
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
    this.mBuyingType = instance.mBuyingType;
    this.mCallToActionClicks = instance.mCallToActionClicks;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCanvasAvgViewPercent = instance.mCanvasAvgViewPercent;
    this.mCanvasAvgViewTime = instance.mCanvasAvgViewTime;
    this.mCanvasComponentAvgPctView = instance.mCanvasComponentAvgPctView;
    this.mClicks = instance.mClicks;
    this.mCostPer10SecVideoView = instance.mCostPer10SecVideoView;
    this.mCostPerActionType = instance.mCostPerActionType;
    this.mCostPerEstimatedAdRecallers = instance.mCostPerEstimatedAdRecallers;
    this.mCostPerInlineLinkClick = instance.mCostPerInlineLinkClick;
    this.mCostPerInlinePostEngagement = instance.mCostPerInlinePostEngagement;
    this.mCostPerOutboundClick = instance.mCostPerOutboundClick;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueActionType = instance.mCostPerUniqueActionType;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCostPerUniqueInlineLinkClick = instance.mCostPerUniqueInlineLinkClick;
    this.mCostPerUniqueOutboundClick = instance.mCostPerUniqueOutboundClick;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCtr = instance.mCtr;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mEstimatedAdRecallRate = instance.mEstimatedAdRecallRate;
    this.mEstimatedAdRecallers = instance.mEstimatedAdRecallers;
    this.mFrequency = instance.mFrequency;
    this.mImpressions = instance.mImpressions;
    this.mInlineLinkClickCtr = instance.mInlineLinkClickCtr;
    this.mInlineLinkClicks = instance.mInlineLinkClicks;
    this.mInlinePostEngagement = instance.mInlinePostEngagement;
    this.mMobileAppPurchaseRoas = instance.mMobileAppPurchaseRoas;
    this.mObjective = instance.mObjective;
    this.mOutboundClicks = instance.mOutboundClicks;
    this.mOutboundClicksCtr = instance.mOutboundClicksCtr;
    this.mPlacePageName = instance.mPlacePageName;
    this.mReach = instance.mReach;
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
    this.mUniqueInlineLinkClickCtr = instance.mUniqueInlineLinkClickCtr;
    this.mUniqueInlineLinkClicks = instance.mUniqueInlineLinkClicks;
    this.mUniqueLinkClicksCtr = instance.mUniqueLinkClicksCtr;
    this.mUniqueOutboundClicks = instance.mUniqueOutboundClicks;
    this.mUniqueOutboundClicksCtr = instance.mUniqueOutboundClicksCtr;
    this.mUniqueSocialClicks = instance.mUniqueSocialClicks;
    this.mVideo10SecWatchedActions = instance.mVideo10SecWatchedActions;
    this.mVideo15SecWatchedActions = instance.mVideo15SecWatchedActions;
    this.mVideo30SecWatchedActions = instance.mVideo30SecWatchedActions;
    this.mVideoAvgPercentWatchedActions = instance.mVideoAvgPercentWatchedActions;
    this.mVideoAvgTimeWatchedActions = instance.mVideoAvgTimeWatchedActions;
    this.mVideoP100WatchedActions = instance.mVideoP100WatchedActions;
    this.mVideoP25WatchedActions = instance.mVideoP25WatchedActions;
    this.mVideoP50WatchedActions = instance.mVideoP50WatchedActions;
    this.mVideoP75WatchedActions = instance.mVideoP75WatchedActions;
    this.mVideoP95WatchedActions = instance.mVideoP95WatchedActions;
    this.mWebsiteCtr = instance.mWebsiteCtr;
    this.mWebsitePurchaseRoas = instance.mWebsitePurchaseRoas;
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
