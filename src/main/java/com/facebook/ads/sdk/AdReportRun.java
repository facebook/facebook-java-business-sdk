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


public class AdReportRun extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("async_percent_completion")
  private Long mAsyncPercentCompletion = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("schedule_id")
  private String mScheduleId = null;
  @SerializedName("time_ref")
  private Long mTimeRef = null;
  @SerializedName("time_completed")
  private Long mTimeCompleted = null;
  @SerializedName("emails")
  private List<String> mEmails = null;
  @SerializedName("friendly_name")
  private String mFriendlyName = null;
  @SerializedName("is_bookmarked")
  private Boolean mIsBookmarked = null;
  @SerializedName("is_running")
  private Boolean mIsRunning = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  protected static Gson gson = null;

  AdReportRun() {
  }

  public AdReportRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdReportRun(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdReportRun fetch() throws APIException{
    AdReportRun newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdReportRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdReportRun fetchById(String id, APIContext context) throws APIException {
    AdReportRun adReportRun =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adReportRun;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdReportRun loadJSON(String json, APIContext context) {
    AdReportRun adReportRun = getGson().fromJson(json, AdReportRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adReportRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adReportRun.mContext = context;
    adReportRun.rawValue = json;
    return adReportRun;
  }

  public static APINodeList<AdReportRun> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdReportRun> adReportRuns = new APINodeList<AdReportRun>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adReportRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adReportRuns.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adReportRuns.add(loadJSON(obj.toString(), context));
          }
          return adReportRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adReportRuns.add(loadJSON(entry.getValue().toString(), context));
          }
          return adReportRuns;
        } else {
          // Fifth, check if it's pure JsonObject
          adReportRuns.add(loadJSON(json, context));
          return adReportRuns;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public Long getFieldAsyncPercentCompletion() {
    return mAsyncPercentCompletion;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldScheduleId() {
    return mScheduleId;
  }

  public Long getFieldTimeRef() {
    return mTimeRef;
  }

  public Long getFieldTimeCompleted() {
    return mTimeCompleted;
  }

  public List<String> getFieldEmails() {
    return mEmails;
  }

  public String getFieldFriendlyName() {
    return mFriendlyName;
  }

  public Boolean getFieldIsBookmarked() {
    return mIsBookmarked;
  }

  public Boolean getFieldIsRunning() {
    return mIsRunning;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }



  public static class APIRequestGet extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "async_status",
      "async_percent_completion",
      "account_id",
      "schedule_id",
      "time_ref",
      "time_completed",
      "emails",
      "friendly_name",
      "is_bookmarked",
      "is_running",
      "date_start",
      "date_stop",
    };

    @Override
    public AdReportRun parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGet requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGet requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGet requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGet requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
    public APIRequestGet requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGet requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameField () {
      return this.requestFriendlyNameField(true);
    }
    public APIRequestGet requestFriendlyNameField (boolean value) {
      this.requestField("friendly_name", value);
      return this;
    }
    public APIRequestGet requestIsBookmarkedField () {
      return this.requestIsBookmarkedField(true);
    }
    public APIRequestGet requestIsBookmarkedField (boolean value) {
      this.requestField("is_bookmarked", value);
      return this;
    }
    public APIRequestGet requestIsRunningField () {
      return this.requestIsRunningField(true);
    }
    public APIRequestGet requestIsRunningField (boolean value) {
      this.requestField("is_running", value);
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

  }

  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "default_summary",
      "fields",
      "filtering",
      "summary",
      "sort",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetInsights setFields (List<EnumFields> fields) {
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

    public APIRequestGetInsights setSummary (List<EnumFields> summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
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

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumFields {
    @SerializedName("frequency_value")
    VALUE_FREQUENCY_VALUE("frequency_value"),
    @SerializedName("age")
    VALUE_AGE("age"),
    @SerializedName("country")
    VALUE_COUNTRY("country"),
    @SerializedName("gender")
    VALUE_GENDER("gender"),
    @SerializedName("impression_device")
    VALUE_IMPRESSION_DEVICE("impression_device"),
    @SerializedName("place_page_id")
    VALUE_PLACE_PAGE_ID("place_page_id"),
    @SerializedName("placement")
    VALUE_PLACEMENT("placement"),
    @SerializedName("product_id")
    VALUE_PRODUCT_ID("product_id"),
    @SerializedName("region")
    VALUE_REGION("region"),
    @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
    @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
    @SerializedName("account_id")
    VALUE_ACCOUNT_ID("account_id"),
    @SerializedName("account_name")
    VALUE_ACCOUNT_NAME("account_name"),
    @SerializedName("action_values")
    VALUE_ACTION_VALUES("action_values"),
    @SerializedName("actions")
    VALUE_ACTIONS("actions"),
    @SerializedName("unique_actions")
    VALUE_UNIQUE_ACTIONS("unique_actions"),
    @SerializedName("app_store_clicks")
    VALUE_APP_STORE_CLICKS("app_store_clicks"),
    @SerializedName("buying_type")
    VALUE_BUYING_TYPE("buying_type"),
    @SerializedName("call_to_action_clicks")
    VALUE_CALL_TO_ACTION_CLICKS("call_to_action_clicks"),
    @SerializedName("card_views")
    VALUE_CARD_VIEWS("card_views"),
    @SerializedName("unique_clicks")
    VALUE_UNIQUE_CLICKS("unique_clicks"),
    @SerializedName("cost_per_action_type")
    VALUE_COST_PER_ACTION_TYPE("cost_per_action_type"),
    @SerializedName("cost_per_unique_action_type")
    VALUE_COST_PER_UNIQUE_ACTION_TYPE("cost_per_unique_action_type"),
    @SerializedName("cost_per_inline_post_engagement")
    VALUE_COST_PER_INLINE_POST_ENGAGEMENT("cost_per_inline_post_engagement"),
    @SerializedName("cost_per_inline_link_click")
    VALUE_COST_PER_INLINE_LINK_CLICK("cost_per_inline_link_click"),
    @SerializedName("cost_per_total_action")
    VALUE_COST_PER_TOTAL_ACTION("cost_per_total_action"),
    @SerializedName("cost_per_10_sec_video_view")
    VALUE_COST_PER_10_SEC_VIDEO_VIEW("cost_per_10_sec_video_view"),
    @SerializedName("cost_per_unique_click")
    VALUE_COST_PER_UNIQUE_CLICK("cost_per_unique_click"),
    @SerializedName("cpm")
    VALUE_CPM("cpm"),
    @SerializedName("cpp")
    VALUE_CPP("cpp"),
    @SerializedName("ctr")
    VALUE_CTR("ctr"),
    @SerializedName("unique_ctr")
    VALUE_UNIQUE_CTR("unique_ctr"),
    @SerializedName("unique_link_clicks_ctr")
    VALUE_UNIQUE_LINK_CLICKS_CTR("unique_link_clicks_ctr"),
    @SerializedName("date_start")
    VALUE_DATE_START("date_start"),
    @SerializedName("date_stop")
    VALUE_DATE_STOP("date_stop"),
    @SerializedName("deeplink_clicks")
    VALUE_DEEPLINK_CLICKS("deeplink_clicks"),
    @SerializedName("frequency")
    VALUE_FREQUENCY("frequency"),
    @SerializedName("impressions")
    VALUE_IMPRESSIONS("impressions"),
    @SerializedName("unique_impressions")
    VALUE_UNIQUE_IMPRESSIONS("unique_impressions"),
    @SerializedName("inline_link_clicks")
    VALUE_INLINE_LINK_CLICKS("inline_link_clicks"),
    @SerializedName("inline_post_engagement")
    VALUE_INLINE_POST_ENGAGEMENT("inline_post_engagement"),
    @SerializedName("newsfeed_avg_position")
    VALUE_NEWSFEED_AVG_POSITION("newsfeed_avg_position"),
    @SerializedName("newsfeed_clicks")
    VALUE_NEWSFEED_CLICKS("newsfeed_clicks"),
    @SerializedName("newsfeed_impressions")
    VALUE_NEWSFEED_IMPRESSIONS("newsfeed_impressions"),
    @SerializedName("reach")
    VALUE_REACH("reach"),
    @SerializedName("relevance_score")
    VALUE_RELEVANCE_SCORE("relevance_score"),
    @SerializedName("social_clicks")
    VALUE_SOCIAL_CLICKS("social_clicks"),
    @SerializedName("unique_social_clicks")
    VALUE_UNIQUE_SOCIAL_CLICKS("unique_social_clicks"),
    @SerializedName("social_impressions")
    VALUE_SOCIAL_IMPRESSIONS("social_impressions"),
    @SerializedName("unique_social_impressions")
    VALUE_UNIQUE_SOCIAL_IMPRESSIONS("unique_social_impressions"),
    @SerializedName("social_reach")
    VALUE_SOCIAL_REACH("social_reach"),
    @SerializedName("social_spend")
    VALUE_SOCIAL_SPEND("social_spend"),
    @SerializedName("spend")
    VALUE_SPEND("spend"),
    @SerializedName("total_action_value")
    VALUE_TOTAL_ACTION_VALUE("total_action_value"),
    @SerializedName("total_actions")
    VALUE_TOTAL_ACTIONS("total_actions"),
    @SerializedName("total_unique_actions")
    VALUE_TOTAL_UNIQUE_ACTIONS("total_unique_actions"),
    @SerializedName("video_avg_pct_watched_actions")
    VALUE_VIDEO_AVG_PCT_WATCHED_ACTIONS("video_avg_pct_watched_actions"),
    @SerializedName("video_avg_sec_watched_actions")
    VALUE_VIDEO_AVG_SEC_WATCHED_ACTIONS("video_avg_sec_watched_actions"),
    @SerializedName("video_complete_watched_actions")
    VALUE_VIDEO_COMPLETE_WATCHED_ACTIONS("video_complete_watched_actions"),
    @SerializedName("video_p25_watched_actions")
    VALUE_VIDEO_P25_WATCHED_ACTIONS("video_p25_watched_actions"),
    @SerializedName("video_p50_watched_actions")
    VALUE_VIDEO_P50_WATCHED_ACTIONS("video_p50_watched_actions"),
    @SerializedName("video_p75_watched_actions")
    VALUE_VIDEO_P75_WATCHED_ACTIONS("video_p75_watched_actions"),
    @SerializedName("video_p95_watched_actions")
    VALUE_VIDEO_P95_WATCHED_ACTIONS("video_p95_watched_actions"),
    @SerializedName("video_p100_watched_actions")
    VALUE_VIDEO_P100_WATCHED_ACTIONS("video_p100_watched_actions"),
    @SerializedName("video_10_sec_watched_actions")
    VALUE_VIDEO_10_SEC_WATCHED_ACTIONS("video_10_sec_watched_actions"),
    @SerializedName("video_15_sec_watched_actions")
    VALUE_VIDEO_15_SEC_WATCHED_ACTIONS("video_15_sec_watched_actions"),
    @SerializedName("video_30_sec_watched_actions")
    VALUE_VIDEO_30_SEC_WATCHED_ACTIONS("video_30_sec_watched_actions"),
    @SerializedName("website_clicks")
    VALUE_WEBSITE_CLICKS("website_clicks"),
    @SerializedName("website_ctr")
    VALUE_WEBSITE_CTR("website_ctr"),
    @SerializedName("ad_id")
    VALUE_AD_ID("ad_id"),
    @SerializedName("ad_name")
    VALUE_AD_NAME("ad_name"),
    @SerializedName("adset_id")
    VALUE_ADSET_ID("adset_id"),
    @SerializedName("adset_name")
    VALUE_ADSET_NAME("adset_name"),
    @SerializedName("campaign_id")
    VALUE_CAMPAIGN_ID("campaign_id"),
    @SerializedName("campaign_name")
    VALUE_CAMPAIGN_NAME("campaign_name"),
    NULL(null);

    private String value;

    private EnumFields(String value) {
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

  public AdReportRun copyFrom(AdReportRun instance) {
    this.mId = instance.mId;
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mAsyncPercentCompletion = instance.mAsyncPercentCompletion;
    this.mAccountId = instance.mAccountId;
    this.mScheduleId = instance.mScheduleId;
    this.mTimeRef = instance.mTimeRef;
    this.mTimeCompleted = instance.mTimeCompleted;
    this.mEmails = instance.mEmails;
    this.mFriendlyName = instance.mFriendlyName;
    this.mIsBookmarked = instance.mIsBookmarked;
    this.mIsRunning = instance.mIsRunning;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}