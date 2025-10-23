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
public class AdReportRun extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("async_percent_completion")
  private Long mAsyncPercentCompletion = null;
  @SerializedName("async_report_url")
  private String mAsyncReportUrl = null;
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("emails")
  private List<String> mEmails = null;
  @SerializedName("error_code")
  private Long mErrorCode = null;
  @SerializedName("friendly_name")
  private String mFriendlyName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_async_export")
  private Long mIsAsyncExport = null;
  @SerializedName("is_bookmarked")
  private Boolean mIsBookmarked = null;
  @SerializedName("is_running")
  private Boolean mIsRunning = null;
  @SerializedName("schedule_id")
  private String mScheduleId = null;
  @SerializedName("time_completed")
  private Long mTimeCompleted = null;
  @SerializedName("time_ref")
  private Long mTimeRef = null;
  protected static Gson gson = null;

  AdReportRun() {
  }

  public AdReportRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdReportRun(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdReportRun fetch() throws APIException{
    AdReportRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdReportRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdReportRun> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdReportRun fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdReportRun> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdReportRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdReportRun>)(
      new APIRequest<AdReportRun>(context, "", "/", "GET", AdReportRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdReportRun>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdReportRun.getParser())
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
  public static AdReportRun loadJSON(String json, APIContext context, String header) {
    AdReportRun adReportRun = getGson().fromJson(json, AdReportRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adReportRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adReportRun.context = context;
    adReportRun.rawValue = json;
    adReportRun.header = header;
    JsonParser parser = new JsonParser();
    JsonObject o = parser.parse(json).getAsJsonObject();
    String reportRunId = null;
    if (o.has("report_run_id")) {
      reportRunId = o.get("report_run_id").getAsString();
      if (reportRunId != null) {
        adReportRun.mId = reportRunId;
      }
    }
    return adReportRun;
  }

  public static APINodeList<AdReportRun> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdReportRun> adReportRuns = new APINodeList<AdReportRun>(request, json, header);
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
          adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adReportRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adReportRuns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adReportRuns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adReportRuns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adReportRuns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adReportRuns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adReportRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adReportRuns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adReportRuns;
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
              adReportRuns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adReportRuns;
          }

          // Sixth, check if it's pure JsonObject
          adReportRuns.clear();
          adReportRuns.add(loadJSON(json, context, header));
          return adReportRuns;
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

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldAsyncPercentCompletion() {
    return mAsyncPercentCompletion;
  }

  public String getFieldAsyncReportUrl() {
    return mAsyncReportUrl;
  }

  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public List<String> getFieldEmails() {
    return mEmails;
  }

  public Long getFieldErrorCode() {
    return mErrorCode;
  }

  public String getFieldFriendlyName() {
    return mFriendlyName;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIsAsyncExport() {
    return mIsAsyncExport;
  }

  public Boolean getFieldIsBookmarked() {
    return mIsBookmarked;
  }

  public Boolean getFieldIsRunning() {
    return mIsRunning;
  }

  public String getFieldScheduleId() {
    return mScheduleId;
  }

  public Long getFieldTimeCompleted() {
    return mTimeCompleted;
  }

  public Long getFieldTimeRef() {
    return mTimeRef;
  }



  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
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
      "ad_click_actions",
      "ad_id",
      "ad_impression_actions",
      "ad_name",
      "adset_end",
      "adset_id",
      "adset_name",
      "adset_start",
      "age_targeting",
      "anchor_events_performance_indicator",
      "attribution_setting",
      "auction_bid",
      "auction_competitiveness",
      "auction_max_competitor_bid",
      "average_purchases_conversion_value",
      "buying_type",
      "campaign_id",
      "campaign_name",
      "canvas_avg_view_percent",
      "canvas_avg_view_time",
      "catalog_segment_actions",
      "catalog_segment_value",
      "catalog_segment_value_mobile_purchase_roas",
      "catalog_segment_value_omni_purchase_roas",
      "catalog_segment_value_website_purchase_roas",
      "clicks",
      "conversion_lead_rate",
      "conversion_leads",
      "conversion_rate_ranking",
      "conversion_values",
      "conversions",
      "converted_product_app_custom_event_fb_mobile_purchase",
      "converted_product_app_custom_event_fb_mobile_purchase_value",
      "converted_product_offline_purchase",
      "converted_product_offline_purchase_value",
      "converted_product_omni_purchase",
      "converted_product_omni_purchase_values",
      "converted_product_quantity",
      "converted_product_value",
      "converted_product_website_pixel_purchase",
      "converted_product_website_pixel_purchase_value",
      "converted_promoted_product_app_custom_event_fb_mobile_purchase",
      "converted_promoted_product_app_custom_event_fb_mobile_purchase_value",
      "converted_promoted_product_offline_purchase",
      "converted_promoted_product_offline_purchase_value",
      "converted_promoted_product_omni_purchase",
      "converted_promoted_product_omni_purchase_values",
      "converted_promoted_product_quantity",
      "converted_promoted_product_value",
      "converted_promoted_product_website_pixel_purchase",
      "converted_promoted_product_website_pixel_purchase_value",
      "cost_per_15_sec_video_view",
      "cost_per_2_sec_continuous_video_view",
      "cost_per_action_type",
      "cost_per_ad_click",
      "cost_per_conversion",
      "cost_per_conversion_lead",
      "cost_per_dda_countby_convs",
      "cost_per_estimated_ad_recallers",
      "cost_per_inline_link_click",
      "cost_per_inline_post_engagement",
      "cost_per_objective_result",
      "cost_per_one_thousand_ad_impression",
      "cost_per_outbound_click",
      "cost_per_result",
      "cost_per_thruplay",
      "cost_per_unique_action_type",
      "cost_per_unique_click",
      "cost_per_unique_conversion",
      "cost_per_unique_inline_link_click",
      "cost_per_unique_outbound_click",
      "cpc",
      "cpm",
      "cpp",
      "created_time",
      "creative_media_type",
      "ctr",
      "date_start",
      "date_stop",
      "dda_countby_convs",
      "dda_results",
      "engagement_rate_ranking",
      "estimated_ad_recall_rate",
      "estimated_ad_recall_rate_lower_bound",
      "estimated_ad_recall_rate_upper_bound",
      "estimated_ad_recallers",
      "estimated_ad_recallers_lower_bound",
      "estimated_ad_recallers_upper_bound",
      "frequency",
      "full_view_impressions",
      "full_view_reach",
      "gender_targeting",
      "impressions",
      "inline_link_click_ctr",
      "inline_link_clicks",
      "inline_post_engagement",
      "instagram_upcoming_event_reminders_set",
      "instant_experience_clicks_to_open",
      "instant_experience_clicks_to_start",
      "instant_experience_outbound_clicks",
      "interactive_component_tap",
      "labels",
      "landing_page_view_actions_per_link_click",
      "landing_page_view_per_link_click",
      "landing_page_view_per_purchase_rate",
      "link_clicks_per_results",
      "location",
      "marketing_messages_click_rate_benchmark",
      "marketing_messages_cost_per_delivered",
      "marketing_messages_cost_per_link_btn_click",
      "marketing_messages_delivered",
      "marketing_messages_delivery_rate",
      "marketing_messages_link_btn_click",
      "marketing_messages_link_btn_click_rate",
      "marketing_messages_media_view_rate",
      "marketing_messages_phone_call_btn_click_rate",
      "marketing_messages_quick_reply_btn_click",
      "marketing_messages_quick_reply_btn_click_rate",
      "marketing_messages_read",
      "marketing_messages_read_rate",
      "marketing_messages_read_rate_benchmark",
      "marketing_messages_sent",
      "marketing_messages_spend",
      "marketing_messages_spend_currency",
      "marketing_messages_website_add_to_cart",
      "marketing_messages_website_initiate_checkout",
      "marketing_messages_website_purchase",
      "marketing_messages_website_purchase_values",
      "mobile_app_purchase_roas",
      "objective",
      "objective_result_rate",
      "objective_results",
      "onsite_conversion_messaging_detected_purchase_deduped",
      "optimization_goal",
      "outbound_clicks",
      "outbound_clicks_ctr",
      "place_page_name",
      "product_group_retailer_id",
      "product_retailer_id",
      "product_views",
      "purchase_per_landing_page_view",
      "purchase_roas",
      "purchases_per_link_click",
      "qualifying_question_qualify_answer_rate",
      "quality_ranking",
      "reach",
      "result_rate",
      "result_values_performance_indicator",
      "results",
      "shops_assisted_purchases",
      "social_spend",
      "spend",
      "total_card_view",
      "total_postbacks",
      "total_postbacks_detailed",
      "total_postbacks_detailed_v4",
      "unique_actions",
      "unique_clicks",
      "unique_conversions",
      "unique_ctr",
      "unique_inline_link_click_ctr",
      "unique_inline_link_clicks",
      "unique_link_clicks_ctr",
      "unique_outbound_clicks",
      "unique_outbound_clicks_ctr",
      "unique_video_continuous_2_sec_watched_actions",
      "unique_video_view_15_sec",
      "updated_time",
      "video_15_sec_watched_actions",
      "video_30_sec_watched_actions",
      "video_avg_time_watched_actions",
      "video_continuous_2_sec_watched_actions",
      "video_p100_watched_actions",
      "video_p25_watched_actions",
      "video_p50_watched_actions",
      "video_p75_watched_actions",
      "video_p95_watched_actions",
      "video_play_actions",
      "video_play_curve_actions",
      "video_play_retention_0_to_15s_actions",
      "video_play_retention_20_to_60s_actions",
      "video_play_retention_graph_actions",
      "video_thruplay_watched_actions",
      "video_time_watched_actions",
      "video_view_per_impression",
      "website_ctr",
      "website_purchase_roas",
      "wish_bid",
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

    public APIRequestGetInsights requestAccountCurrencyField () {
      return this.requestAccountCurrencyField(true);
    }
    public APIRequestGetInsights requestAccountCurrencyField (boolean value) {
      this.requestField("account_currency", value);
      return this;
    }
    public APIRequestGetInsights requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetInsights requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetInsights requestAccountNameField () {
      return this.requestAccountNameField(true);
    }
    public APIRequestGetInsights requestAccountNameField (boolean value) {
      this.requestField("account_name", value);
      return this;
    }
    public APIRequestGetInsights requestActionValuesField () {
      return this.requestActionValuesField(true);
    }
    public APIRequestGetInsights requestActionValuesField (boolean value) {
      this.requestField("action_values", value);
      return this;
    }
    public APIRequestGetInsights requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetInsights requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdClickActionsField () {
      return this.requestAdClickActionsField(true);
    }
    public APIRequestGetInsights requestAdClickActionsField (boolean value) {
      this.requestField("ad_click_actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetInsights requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdImpressionActionsField () {
      return this.requestAdImpressionActionsField(true);
    }
    public APIRequestGetInsights requestAdImpressionActionsField (boolean value) {
      this.requestField("ad_impression_actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetInsights requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetEndField () {
      return this.requestAdsetEndField(true);
    }
    public APIRequestGetInsights requestAdsetEndField (boolean value) {
      this.requestField("adset_end", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetInsights requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetInsights requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetStartField () {
      return this.requestAdsetStartField(true);
    }
    public APIRequestGetInsights requestAdsetStartField (boolean value) {
      this.requestField("adset_start", value);
      return this;
    }
    public APIRequestGetInsights requestAgeTargetingField () {
      return this.requestAgeTargetingField(true);
    }
    public APIRequestGetInsights requestAgeTargetingField (boolean value) {
      this.requestField("age_targeting", value);
      return this;
    }
    public APIRequestGetInsights requestAnchorEventsPerformanceIndicatorField () {
      return this.requestAnchorEventsPerformanceIndicatorField(true);
    }
    public APIRequestGetInsights requestAnchorEventsPerformanceIndicatorField (boolean value) {
      this.requestField("anchor_events_performance_indicator", value);
      return this;
    }
    public APIRequestGetInsights requestAttributionSettingField () {
      return this.requestAttributionSettingField(true);
    }
    public APIRequestGetInsights requestAttributionSettingField (boolean value) {
      this.requestField("attribution_setting", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionBidField () {
      return this.requestAuctionBidField(true);
    }
    public APIRequestGetInsights requestAuctionBidField (boolean value) {
      this.requestField("auction_bid", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionCompetitivenessField () {
      return this.requestAuctionCompetitivenessField(true);
    }
    public APIRequestGetInsights requestAuctionCompetitivenessField (boolean value) {
      this.requestField("auction_competitiveness", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionMaxCompetitorBidField () {
      return this.requestAuctionMaxCompetitorBidField(true);
    }
    public APIRequestGetInsights requestAuctionMaxCompetitorBidField (boolean value) {
      this.requestField("auction_max_competitor_bid", value);
      return this;
    }
    public APIRequestGetInsights requestAveragePurchasesConversionValueField () {
      return this.requestAveragePurchasesConversionValueField(true);
    }
    public APIRequestGetInsights requestAveragePurchasesConversionValueField (boolean value) {
      this.requestField("average_purchases_conversion_value", value);
      return this;
    }
    public APIRequestGetInsights requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetInsights requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetInsights requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetInsights requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField () {
      return this.requestCanvasAvgViewPercentField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField (boolean value) {
      this.requestField("canvas_avg_view_percent", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField () {
      return this.requestCanvasAvgViewTimeField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField (boolean value) {
      this.requestField("canvas_avg_view_time", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentActionsField () {
      return this.requestCatalogSegmentActionsField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentActionsField (boolean value) {
      this.requestField("catalog_segment_actions", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueField () {
      return this.requestCatalogSegmentValueField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueField (boolean value) {
      this.requestField("catalog_segment_value", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueMobilePurchaseRoasField () {
      return this.requestCatalogSegmentValueMobilePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueMobilePurchaseRoasField (boolean value) {
      this.requestField("catalog_segment_value_mobile_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueOmniPurchaseRoasField () {
      return this.requestCatalogSegmentValueOmniPurchaseRoasField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueOmniPurchaseRoasField (boolean value) {
      this.requestField("catalog_segment_value_omni_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueWebsitePurchaseRoasField () {
      return this.requestCatalogSegmentValueWebsitePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueWebsitePurchaseRoasField (boolean value) {
      this.requestField("catalog_segment_value_website_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGetInsights requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGetInsights requestConversionLeadRateField () {
      return this.requestConversionLeadRateField(true);
    }
    public APIRequestGetInsights requestConversionLeadRateField (boolean value) {
      this.requestField("conversion_lead_rate", value);
      return this;
    }
    public APIRequestGetInsights requestConversionLeadsField () {
      return this.requestConversionLeadsField(true);
    }
    public APIRequestGetInsights requestConversionLeadsField (boolean value) {
      this.requestField("conversion_leads", value);
      return this;
    }
    public APIRequestGetInsights requestConversionRateRankingField () {
      return this.requestConversionRateRankingField(true);
    }
    public APIRequestGetInsights requestConversionRateRankingField (boolean value) {
      this.requestField("conversion_rate_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestConversionValuesField () {
      return this.requestConversionValuesField(true);
    }
    public APIRequestGetInsights requestConversionValuesField (boolean value) {
      this.requestField("conversion_values", value);
      return this;
    }
    public APIRequestGetInsights requestConversionsField () {
      return this.requestConversionsField(true);
    }
    public APIRequestGetInsights requestConversionsField (boolean value) {
      this.requestField("conversions", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductAppCustomEventFbMobilePurchaseField () {
      return this.requestConvertedProductAppCustomEventFbMobilePurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedProductAppCustomEventFbMobilePurchaseField (boolean value) {
      this.requestField("converted_product_app_custom_event_fb_mobile_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductAppCustomEventFbMobilePurchaseValueField () {
      return this.requestConvertedProductAppCustomEventFbMobilePurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedProductAppCustomEventFbMobilePurchaseValueField (boolean value) {
      this.requestField("converted_product_app_custom_event_fb_mobile_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductOfflinePurchaseField () {
      return this.requestConvertedProductOfflinePurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedProductOfflinePurchaseField (boolean value) {
      this.requestField("converted_product_offline_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductOfflinePurchaseValueField () {
      return this.requestConvertedProductOfflinePurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedProductOfflinePurchaseValueField (boolean value) {
      this.requestField("converted_product_offline_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductOmniPurchaseField () {
      return this.requestConvertedProductOmniPurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedProductOmniPurchaseField (boolean value) {
      this.requestField("converted_product_omni_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductOmniPurchaseValuesField () {
      return this.requestConvertedProductOmniPurchaseValuesField(true);
    }
    public APIRequestGetInsights requestConvertedProductOmniPurchaseValuesField (boolean value) {
      this.requestField("converted_product_omni_purchase_values", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductQuantityField () {
      return this.requestConvertedProductQuantityField(true);
    }
    public APIRequestGetInsights requestConvertedProductQuantityField (boolean value) {
      this.requestField("converted_product_quantity", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductValueField () {
      return this.requestConvertedProductValueField(true);
    }
    public APIRequestGetInsights requestConvertedProductValueField (boolean value) {
      this.requestField("converted_product_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductWebsitePixelPurchaseField () {
      return this.requestConvertedProductWebsitePixelPurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedProductWebsitePixelPurchaseField (boolean value) {
      this.requestField("converted_product_website_pixel_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedProductWebsitePixelPurchaseValueField () {
      return this.requestConvertedProductWebsitePixelPurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedProductWebsitePixelPurchaseValueField (boolean value) {
      this.requestField("converted_product_website_pixel_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductAppCustomEventFbMobilePurchaseField () {
      return this.requestConvertedPromotedProductAppCustomEventFbMobilePurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductAppCustomEventFbMobilePurchaseField (boolean value) {
      this.requestField("converted_promoted_product_app_custom_event_fb_mobile_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductAppCustomEventFbMobilePurchaseValueField () {
      return this.requestConvertedPromotedProductAppCustomEventFbMobilePurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductAppCustomEventFbMobilePurchaseValueField (boolean value) {
      this.requestField("converted_promoted_product_app_custom_event_fb_mobile_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductOfflinePurchaseField () {
      return this.requestConvertedPromotedProductOfflinePurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductOfflinePurchaseField (boolean value) {
      this.requestField("converted_promoted_product_offline_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductOfflinePurchaseValueField () {
      return this.requestConvertedPromotedProductOfflinePurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductOfflinePurchaseValueField (boolean value) {
      this.requestField("converted_promoted_product_offline_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductOmniPurchaseField () {
      return this.requestConvertedPromotedProductOmniPurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductOmniPurchaseField (boolean value) {
      this.requestField("converted_promoted_product_omni_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductOmniPurchaseValuesField () {
      return this.requestConvertedPromotedProductOmniPurchaseValuesField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductOmniPurchaseValuesField (boolean value) {
      this.requestField("converted_promoted_product_omni_purchase_values", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductQuantityField () {
      return this.requestConvertedPromotedProductQuantityField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductQuantityField (boolean value) {
      this.requestField("converted_promoted_product_quantity", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductValueField () {
      return this.requestConvertedPromotedProductValueField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductValueField (boolean value) {
      this.requestField("converted_promoted_product_value", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductWebsitePixelPurchaseField () {
      return this.requestConvertedPromotedProductWebsitePixelPurchaseField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductWebsitePixelPurchaseField (boolean value) {
      this.requestField("converted_promoted_product_website_pixel_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestConvertedPromotedProductWebsitePixelPurchaseValueField () {
      return this.requestConvertedPromotedProductWebsitePixelPurchaseValueField(true);
    }
    public APIRequestGetInsights requestConvertedPromotedProductWebsitePixelPurchaseValueField (boolean value) {
      this.requestField("converted_promoted_product_website_pixel_purchase_value", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer15SecVideoViewField () {
      return this.requestCostPer15SecVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer15SecVideoViewField (boolean value) {
      this.requestField("cost_per_15_sec_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer2SecContinuousVideoViewField () {
      return this.requestCostPer2SecContinuousVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer2SecContinuousVideoViewField (boolean value) {
      this.requestField("cost_per_2_sec_continuous_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerActionTypeField () {
      return this.requestCostPerActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerActionTypeField (boolean value) {
      this.requestField("cost_per_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerAdClickField () {
      return this.requestCostPerAdClickField(true);
    }
    public APIRequestGetInsights requestCostPerAdClickField (boolean value) {
      this.requestField("cost_per_ad_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerConversionField () {
      return this.requestCostPerConversionField(true);
    }
    public APIRequestGetInsights requestCostPerConversionField (boolean value) {
      this.requestField("cost_per_conversion", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerConversionLeadField () {
      return this.requestCostPerConversionLeadField(true);
    }
    public APIRequestGetInsights requestCostPerConversionLeadField (boolean value) {
      this.requestField("cost_per_conversion_lead", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDdaCountbyConvsField () {
      return this.requestCostPerDdaCountbyConvsField(true);
    }
    public APIRequestGetInsights requestCostPerDdaCountbyConvsField (boolean value) {
      this.requestField("cost_per_dda_countby_convs", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField () {
      return this.requestCostPerEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField (boolean value) {
      this.requestField("cost_per_estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField () {
      return this.requestCostPerInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField (boolean value) {
      this.requestField("cost_per_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField () {
      return this.requestCostPerInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField (boolean value) {
      this.requestField("cost_per_inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerObjectiveResultField () {
      return this.requestCostPerObjectiveResultField(true);
    }
    public APIRequestGetInsights requestCostPerObjectiveResultField (boolean value) {
      this.requestField("cost_per_objective_result", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerOneThousandAdImpressionField () {
      return this.requestCostPerOneThousandAdImpressionField(true);
    }
    public APIRequestGetInsights requestCostPerOneThousandAdImpressionField (boolean value) {
      this.requestField("cost_per_one_thousand_ad_impression", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerOutboundClickField () {
      return this.requestCostPerOutboundClickField(true);
    }
    public APIRequestGetInsights requestCostPerOutboundClickField (boolean value) {
      this.requestField("cost_per_outbound_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerResultField () {
      return this.requestCostPerResultField(true);
    }
    public APIRequestGetInsights requestCostPerResultField (boolean value) {
      this.requestField("cost_per_result", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerThruplayField () {
      return this.requestCostPerThruplayField(true);
    }
    public APIRequestGetInsights requestCostPerThruplayField (boolean value) {
      this.requestField("cost_per_thruplay", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField () {
      return this.requestCostPerUniqueActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField (boolean value) {
      this.requestField("cost_per_unique_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueConversionField () {
      return this.requestCostPerUniqueConversionField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueConversionField (boolean value) {
      this.requestField("cost_per_unique_conversion", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField () {
      return this.requestCostPerUniqueInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField (boolean value) {
      this.requestField("cost_per_unique_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueOutboundClickField () {
      return this.requestCostPerUniqueOutboundClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueOutboundClickField (boolean value) {
      this.requestField("cost_per_unique_outbound_click", value);
      return this;
    }
    public APIRequestGetInsights requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGetInsights requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGetInsights requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGetInsights requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGetInsights requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGetInsights requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGetInsights requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetInsights requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetInsights requestCreativeMediaTypeField () {
      return this.requestCreativeMediaTypeField(true);
    }
    public APIRequestGetInsights requestCreativeMediaTypeField (boolean value) {
      this.requestField("creative_media_type", value);
      return this;
    }
    public APIRequestGetInsights requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGetInsights requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGetInsights requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGetInsights requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGetInsights requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGetInsights requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGetInsights requestDdaCountbyConvsField () {
      return this.requestDdaCountbyConvsField(true);
    }
    public APIRequestGetInsights requestDdaCountbyConvsField (boolean value) {
      this.requestField("dda_countby_convs", value);
      return this;
    }
    public APIRequestGetInsights requestDdaResultsField () {
      return this.requestDdaResultsField(true);
    }
    public APIRequestGetInsights requestDdaResultsField (boolean value) {
      this.requestField("dda_results", value);
      return this;
    }
    public APIRequestGetInsights requestEngagementRateRankingField () {
      return this.requestEngagementRateRankingField(true);
    }
    public APIRequestGetInsights requestEngagementRateRankingField (boolean value) {
      this.requestField("engagement_rate_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField () {
      return this.requestEstimatedAdRecallRateField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField (boolean value) {
      this.requestField("estimated_ad_recall_rate", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateLowerBoundField () {
      return this.requestEstimatedAdRecallRateLowerBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_lower_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateUpperBoundField () {
      return this.requestEstimatedAdRecallRateUpperBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_upper_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField () {
      return this.requestEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField (boolean value) {
      this.requestField("estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersLowerBoundField () {
      return this.requestEstimatedAdRecallersLowerBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_lower_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersUpperBoundField () {
      return this.requestEstimatedAdRecallersUpperBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_upper_bound", value);
      return this;
    }
    public APIRequestGetInsights requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGetInsights requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }
    public APIRequestGetInsights requestFullViewImpressionsField () {
      return this.requestFullViewImpressionsField(true);
    }
    public APIRequestGetInsights requestFullViewImpressionsField (boolean value) {
      this.requestField("full_view_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestFullViewReachField () {
      return this.requestFullViewReachField(true);
    }
    public APIRequestGetInsights requestFullViewReachField (boolean value) {
      this.requestField("full_view_reach", value);
      return this;
    }
    public APIRequestGetInsights requestGenderTargetingField () {
      return this.requestGenderTargetingField(true);
    }
    public APIRequestGetInsights requestGenderTargetingField (boolean value) {
      this.requestField("gender_targeting", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGetInsights requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField () {
      return this.requestInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField (boolean value) {
      this.requestField("inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClicksField () {
      return this.requestInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestInlineLinkClicksField (boolean value) {
      this.requestField("inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestInlinePostEngagementField () {
      return this.requestInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestInlinePostEngagementField (boolean value) {
      this.requestField("inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestInstagramUpcomingEventRemindersSetField () {
      return this.requestInstagramUpcomingEventRemindersSetField(true);
    }
    public APIRequestGetInsights requestInstagramUpcomingEventRemindersSetField (boolean value) {
      this.requestField("instagram_upcoming_event_reminders_set", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceClicksToOpenField () {
      return this.requestInstantExperienceClicksToOpenField(true);
    }
    public APIRequestGetInsights requestInstantExperienceClicksToOpenField (boolean value) {
      this.requestField("instant_experience_clicks_to_open", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceClicksToStartField () {
      return this.requestInstantExperienceClicksToStartField(true);
    }
    public APIRequestGetInsights requestInstantExperienceClicksToStartField (boolean value) {
      this.requestField("instant_experience_clicks_to_start", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceOutboundClicksField () {
      return this.requestInstantExperienceOutboundClicksField(true);
    }
    public APIRequestGetInsights requestInstantExperienceOutboundClicksField (boolean value) {
      this.requestField("instant_experience_outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestInteractiveComponentTapField () {
      return this.requestInteractiveComponentTapField(true);
    }
    public APIRequestGetInsights requestInteractiveComponentTapField (boolean value) {
      this.requestField("interactive_component_tap", value);
      return this;
    }
    public APIRequestGetInsights requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetInsights requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetInsights requestLandingPageViewActionsPerLinkClickField () {
      return this.requestLandingPageViewActionsPerLinkClickField(true);
    }
    public APIRequestGetInsights requestLandingPageViewActionsPerLinkClickField (boolean value) {
      this.requestField("landing_page_view_actions_per_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestLandingPageViewPerLinkClickField () {
      return this.requestLandingPageViewPerLinkClickField(true);
    }
    public APIRequestGetInsights requestLandingPageViewPerLinkClickField (boolean value) {
      this.requestField("landing_page_view_per_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestLandingPageViewPerPurchaseRateField () {
      return this.requestLandingPageViewPerPurchaseRateField(true);
    }
    public APIRequestGetInsights requestLandingPageViewPerPurchaseRateField (boolean value) {
      this.requestField("landing_page_view_per_purchase_rate", value);
      return this;
    }
    public APIRequestGetInsights requestLinkClicksPerResultsField () {
      return this.requestLinkClicksPerResultsField(true);
    }
    public APIRequestGetInsights requestLinkClicksPerResultsField (boolean value) {
      this.requestField("link_clicks_per_results", value);
      return this;
    }
    public APIRequestGetInsights requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetInsights requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesClickRateBenchmarkField () {
      return this.requestMarketingMessagesClickRateBenchmarkField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesClickRateBenchmarkField (boolean value) {
      this.requestField("marketing_messages_click_rate_benchmark", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesCostPerDeliveredField () {
      return this.requestMarketingMessagesCostPerDeliveredField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesCostPerDeliveredField (boolean value) {
      this.requestField("marketing_messages_cost_per_delivered", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesCostPerLinkBtnClickField () {
      return this.requestMarketingMessagesCostPerLinkBtnClickField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesCostPerLinkBtnClickField (boolean value) {
      this.requestField("marketing_messages_cost_per_link_btn_click", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesDeliveredField () {
      return this.requestMarketingMessagesDeliveredField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesDeliveredField (boolean value) {
      this.requestField("marketing_messages_delivered", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesDeliveryRateField () {
      return this.requestMarketingMessagesDeliveryRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesDeliveryRateField (boolean value) {
      this.requestField("marketing_messages_delivery_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesLinkBtnClickField () {
      return this.requestMarketingMessagesLinkBtnClickField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesLinkBtnClickField (boolean value) {
      this.requestField("marketing_messages_link_btn_click", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesLinkBtnClickRateField () {
      return this.requestMarketingMessagesLinkBtnClickRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesLinkBtnClickRateField (boolean value) {
      this.requestField("marketing_messages_link_btn_click_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesMediaViewRateField () {
      return this.requestMarketingMessagesMediaViewRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesMediaViewRateField (boolean value) {
      this.requestField("marketing_messages_media_view_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesPhoneCallBtnClickRateField () {
      return this.requestMarketingMessagesPhoneCallBtnClickRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesPhoneCallBtnClickRateField (boolean value) {
      this.requestField("marketing_messages_phone_call_btn_click_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesQuickReplyBtnClickField () {
      return this.requestMarketingMessagesQuickReplyBtnClickField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesQuickReplyBtnClickField (boolean value) {
      this.requestField("marketing_messages_quick_reply_btn_click", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesQuickReplyBtnClickRateField () {
      return this.requestMarketingMessagesQuickReplyBtnClickRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesQuickReplyBtnClickRateField (boolean value) {
      this.requestField("marketing_messages_quick_reply_btn_click_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesReadField () {
      return this.requestMarketingMessagesReadField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesReadField (boolean value) {
      this.requestField("marketing_messages_read", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesReadRateField () {
      return this.requestMarketingMessagesReadRateField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesReadRateField (boolean value) {
      this.requestField("marketing_messages_read_rate", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesReadRateBenchmarkField () {
      return this.requestMarketingMessagesReadRateBenchmarkField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesReadRateBenchmarkField (boolean value) {
      this.requestField("marketing_messages_read_rate_benchmark", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesSentField () {
      return this.requestMarketingMessagesSentField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesSentField (boolean value) {
      this.requestField("marketing_messages_sent", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesSpendField () {
      return this.requestMarketingMessagesSpendField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesSpendField (boolean value) {
      this.requestField("marketing_messages_spend", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesSpendCurrencyField () {
      return this.requestMarketingMessagesSpendCurrencyField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesSpendCurrencyField (boolean value) {
      this.requestField("marketing_messages_spend_currency", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesWebsiteAddToCartField () {
      return this.requestMarketingMessagesWebsiteAddToCartField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesWebsiteAddToCartField (boolean value) {
      this.requestField("marketing_messages_website_add_to_cart", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesWebsiteInitiateCheckoutField () {
      return this.requestMarketingMessagesWebsiteInitiateCheckoutField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesWebsiteInitiateCheckoutField (boolean value) {
      this.requestField("marketing_messages_website_initiate_checkout", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesWebsitePurchaseField () {
      return this.requestMarketingMessagesWebsitePurchaseField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesWebsitePurchaseField (boolean value) {
      this.requestField("marketing_messages_website_purchase", value);
      return this;
    }
    public APIRequestGetInsights requestMarketingMessagesWebsitePurchaseValuesField () {
      return this.requestMarketingMessagesWebsitePurchaseValuesField(true);
    }
    public APIRequestGetInsights requestMarketingMessagesWebsitePurchaseValuesField (boolean value) {
      this.requestField("marketing_messages_website_purchase_values", value);
      return this;
    }
    public APIRequestGetInsights requestMobileAppPurchaseRoasField () {
      return this.requestMobileAppPurchaseRoasField(true);
    }
    public APIRequestGetInsights requestMobileAppPurchaseRoasField (boolean value) {
      this.requestField("mobile_app_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetInsights requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetInsights requestObjectiveResultRateField () {
      return this.requestObjectiveResultRateField(true);
    }
    public APIRequestGetInsights requestObjectiveResultRateField (boolean value) {
      this.requestField("objective_result_rate", value);
      return this;
    }
    public APIRequestGetInsights requestObjectiveResultsField () {
      return this.requestObjectiveResultsField(true);
    }
    public APIRequestGetInsights requestObjectiveResultsField (boolean value) {
      this.requestField("objective_results", value);
      return this;
    }
    public APIRequestGetInsights requestOnsiteConversionMessagingDetectedPurchaseDedupedField () {
      return this.requestOnsiteConversionMessagingDetectedPurchaseDedupedField(true);
    }
    public APIRequestGetInsights requestOnsiteConversionMessagingDetectedPurchaseDedupedField (boolean value) {
      this.requestField("onsite_conversion_messaging_detected_purchase_deduped", value);
      return this;
    }
    public APIRequestGetInsights requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetInsights requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetInsights requestOutboundClicksField () {
      return this.requestOutboundClicksField(true);
    }
    public APIRequestGetInsights requestOutboundClicksField (boolean value) {
      this.requestField("outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestOutboundClicksCtrField () {
      return this.requestOutboundClicksCtrField(true);
    }
    public APIRequestGetInsights requestOutboundClicksCtrField (boolean value) {
      this.requestField("outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestPlacePageNameField () {
      return this.requestPlacePageNameField(true);
    }
    public APIRequestGetInsights requestPlacePageNameField (boolean value) {
      this.requestField("place_page_name", value);
      return this;
    }
    public APIRequestGetInsights requestProductGroupRetailerIdField () {
      return this.requestProductGroupRetailerIdField(true);
    }
    public APIRequestGetInsights requestProductGroupRetailerIdField (boolean value) {
      this.requestField("product_group_retailer_id", value);
      return this;
    }
    public APIRequestGetInsights requestProductRetailerIdField () {
      return this.requestProductRetailerIdField(true);
    }
    public APIRequestGetInsights requestProductRetailerIdField (boolean value) {
      this.requestField("product_retailer_id", value);
      return this;
    }
    public APIRequestGetInsights requestProductViewsField () {
      return this.requestProductViewsField(true);
    }
    public APIRequestGetInsights requestProductViewsField (boolean value) {
      this.requestField("product_views", value);
      return this;
    }
    public APIRequestGetInsights requestPurchasePerLandingPageViewField () {
      return this.requestPurchasePerLandingPageViewField(true);
    }
    public APIRequestGetInsights requestPurchasePerLandingPageViewField (boolean value) {
      this.requestField("purchase_per_landing_page_view", value);
      return this;
    }
    public APIRequestGetInsights requestPurchaseRoasField () {
      return this.requestPurchaseRoasField(true);
    }
    public APIRequestGetInsights requestPurchaseRoasField (boolean value) {
      this.requestField("purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestPurchasesPerLinkClickField () {
      return this.requestPurchasesPerLinkClickField(true);
    }
    public APIRequestGetInsights requestPurchasesPerLinkClickField (boolean value) {
      this.requestField("purchases_per_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestQualifyingQuestionQualifyAnswerRateField () {
      return this.requestQualifyingQuestionQualifyAnswerRateField(true);
    }
    public APIRequestGetInsights requestQualifyingQuestionQualifyAnswerRateField (boolean value) {
      this.requestField("qualifying_question_qualify_answer_rate", value);
      return this;
    }
    public APIRequestGetInsights requestQualityRankingField () {
      return this.requestQualityRankingField(true);
    }
    public APIRequestGetInsights requestQualityRankingField (boolean value) {
      this.requestField("quality_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGetInsights requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGetInsights requestResultRateField () {
      return this.requestResultRateField(true);
    }
    public APIRequestGetInsights requestResultRateField (boolean value) {
      this.requestField("result_rate", value);
      return this;
    }
    public APIRequestGetInsights requestResultValuesPerformanceIndicatorField () {
      return this.requestResultValuesPerformanceIndicatorField(true);
    }
    public APIRequestGetInsights requestResultValuesPerformanceIndicatorField (boolean value) {
      this.requestField("result_values_performance_indicator", value);
      return this;
    }
    public APIRequestGetInsights requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetInsights requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetInsights requestShopsAssistedPurchasesField () {
      return this.requestShopsAssistedPurchasesField(true);
    }
    public APIRequestGetInsights requestShopsAssistedPurchasesField (boolean value) {
      this.requestField("shops_assisted_purchases", value);
      return this;
    }
    public APIRequestGetInsights requestSocialSpendField () {
      return this.requestSocialSpendField(true);
    }
    public APIRequestGetInsights requestSocialSpendField (boolean value) {
      this.requestField("social_spend", value);
      return this;
    }
    public APIRequestGetInsights requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGetInsights requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGetInsights requestTotalCardViewField () {
      return this.requestTotalCardViewField(true);
    }
    public APIRequestGetInsights requestTotalCardViewField (boolean value) {
      this.requestField("total_card_view", value);
      return this;
    }
    public APIRequestGetInsights requestTotalPostbacksField () {
      return this.requestTotalPostbacksField(true);
    }
    public APIRequestGetInsights requestTotalPostbacksField (boolean value) {
      this.requestField("total_postbacks", value);
      return this;
    }
    public APIRequestGetInsights requestTotalPostbacksDetailedField () {
      return this.requestTotalPostbacksDetailedField(true);
    }
    public APIRequestGetInsights requestTotalPostbacksDetailedField (boolean value) {
      this.requestField("total_postbacks_detailed", value);
      return this;
    }
    public APIRequestGetInsights requestTotalPostbacksDetailedV4Field () {
      return this.requestTotalPostbacksDetailedV4Field(true);
    }
    public APIRequestGetInsights requestTotalPostbacksDetailedV4Field (boolean value) {
      this.requestField("total_postbacks_detailed_v4", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGetInsights requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGetInsights requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueConversionsField () {
      return this.requestUniqueConversionsField(true);
    }
    public APIRequestGetInsights requestUniqueConversionsField (boolean value) {
      this.requestField("unique_conversions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGetInsights requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField () {
      return this.requestUniqueInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField (boolean value) {
      this.requestField("unique_inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField () {
      return this.requestUniqueInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField (boolean value) {
      this.requestField("unique_inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField () {
      return this.requestUniqueLinkClicksCtrField(true);
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField (boolean value) {
      this.requestField("unique_link_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueOutboundClicksField () {
      return this.requestUniqueOutboundClicksField(true);
    }
    public APIRequestGetInsights requestUniqueOutboundClicksField (boolean value) {
      this.requestField("unique_outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueOutboundClicksCtrField () {
      return this.requestUniqueOutboundClicksCtrField(true);
    }
    public APIRequestGetInsights requestUniqueOutboundClicksCtrField (boolean value) {
      this.requestField("unique_outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueVideoContinuous2SecWatchedActionsField () {
      return this.requestUniqueVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestUniqueVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("unique_video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueVideoView15SecField () {
      return this.requestUniqueVideoView15SecField(true);
    }
    public APIRequestGetInsights requestUniqueVideoView15SecField (boolean value) {
      this.requestField("unique_video_view_15_sec", value);
      return this;
    }
    public APIRequestGetInsights requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetInsights requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField () {
      return this.requestVideo15SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField (boolean value) {
      this.requestField("video_15_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField () {
      return this.requestVideo30SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField (boolean value) {
      this.requestField("video_30_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField () {
      return this.requestVideoAvgTimeWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField (boolean value) {
      this.requestField("video_avg_time_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoContinuous2SecWatchedActionsField () {
      return this.requestVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField () {
      return this.requestVideoP100WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField (boolean value) {
      this.requestField("video_p100_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField () {
      return this.requestVideoP25WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField (boolean value) {
      this.requestField("video_p25_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField () {
      return this.requestVideoP50WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField (boolean value) {
      this.requestField("video_p50_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField () {
      return this.requestVideoP75WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField (boolean value) {
      this.requestField("video_p75_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField () {
      return this.requestVideoP95WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField (boolean value) {
      this.requestField("video_p95_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayActionsField () {
      return this.requestVideoPlayActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayActionsField (boolean value) {
      this.requestField("video_play_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayCurveActionsField () {
      return this.requestVideoPlayCurveActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayCurveActionsField (boolean value) {
      this.requestField("video_play_curve_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetention0To15sActionsField () {
      return this.requestVideoPlayRetention0To15sActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetention0To15sActionsField (boolean value) {
      this.requestField("video_play_retention_0_to_15s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetention20To60sActionsField () {
      return this.requestVideoPlayRetention20To60sActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetention20To60sActionsField (boolean value) {
      this.requestField("video_play_retention_20_to_60s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetentionGraphActionsField () {
      return this.requestVideoPlayRetentionGraphActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetentionGraphActionsField (boolean value) {
      this.requestField("video_play_retention_graph_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoThruplayWatchedActionsField () {
      return this.requestVideoThruplayWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoThruplayWatchedActionsField (boolean value) {
      this.requestField("video_thruplay_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoTimeWatchedActionsField () {
      return this.requestVideoTimeWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoTimeWatchedActionsField (boolean value) {
      this.requestField("video_time_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoViewPerImpressionField () {
      return this.requestVideoViewPerImpressionField(true);
    }
    public APIRequestGetInsights requestVideoViewPerImpressionField (boolean value) {
      this.requestField("video_view_per_impression", value);
      return this;
    }
    public APIRequestGetInsights requestWebsiteCtrField () {
      return this.requestWebsiteCtrField(true);
    }
    public APIRequestGetInsights requestWebsiteCtrField (boolean value) {
      this.requestField("website_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestWebsitePurchaseRoasField () {
      return this.requestWebsitePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestWebsitePurchaseRoasField (boolean value) {
      this.requestField("website_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestWishBidField () {
      return this.requestWishBidField(true);
    }
    public APIRequestGetInsights requestWishBidField (boolean value) {
      this.requestField("wish_bid", value);
      return this;
    }
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
      "account_id",
      "async_percent_completion",
      "async_report_url",
      "async_status",
      "date_start",
      "date_stop",
      "emails",
      "error_code",
      "friendly_name",
      "id",
      "is_async_export",
      "is_bookmarked",
      "is_running",
      "schedule_id",
      "time_completed",
      "time_ref",
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
    public APIRequestGet requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestAsyncReportUrlField () {
      return this.requestAsyncReportUrlField(true);
    }
    public APIRequestGet requestAsyncReportUrlField (boolean value) {
      this.requestField("async_report_url", value);
      return this;
    }
    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
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
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestErrorCodeField () {
      return this.requestErrorCodeField(true);
    }
    public APIRequestGet requestErrorCodeField (boolean value) {
      this.requestField("error_code", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameField () {
      return this.requestFriendlyNameField(true);
    }
    public APIRequestGet requestFriendlyNameField (boolean value) {
      this.requestField("friendly_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAsyncExportField () {
      return this.requestIsAsyncExportField(true);
    }
    public APIRequestGet requestIsAsyncExportField (boolean value) {
      this.requestField("is_async_export", value);
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
    public APIRequestGet requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGet requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGet requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGet requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGet requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGet requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
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
      @SerializedName("skan_click_second_postback")
      VALUE_SKAN_CLICK_SECOND_POSTBACK("skan_click_second_postback"),
      @SerializedName("skan_click_third_postback")
      VALUE_SKAN_CLICK_THIRD_POSTBACK("skan_click_third_postback"),
      @SerializedName("skan_view")
      VALUE_SKAN_VIEW("skan_view"),
      @SerializedName("skan_view_second_postback")
      VALUE_SKAN_VIEW_SECOND_POSTBACK("skan_view_second_postback"),
      @SerializedName("skan_view_third_postback")
      VALUE_SKAN_VIEW_THIRD_POSTBACK("skan_view_third_postback"),
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
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
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
      @SerializedName("ad_extension_domain")
      VALUE_AD_EXTENSION_DOMAIN("ad_extension_domain"),
      @SerializedName("ad_extension_url")
      VALUE_AD_EXTENSION_URL("ad_extension_url"),
      @SerializedName("ad_format_asset")
      VALUE_AD_FORMAT_ASSET("ad_format_asset"),
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("app_id")
      VALUE_APP_ID("app_id"),
      @SerializedName("body_asset")
      VALUE_BODY_ASSET("body_asset"),
      @SerializedName("breakdown_ad_objective")
      VALUE_BREAKDOWN_AD_OBJECTIVE("breakdown_ad_objective"),
      @SerializedName("breakdown_reporting_ad_id")
      VALUE_BREAKDOWN_REPORTING_AD_ID("breakdown_reporting_ad_id"),
      @SerializedName("call_to_action_asset")
      VALUE_CALL_TO_ACTION_ASSET("call_to_action_asset"),
      @SerializedName("coarse_conversion_value")
      VALUE_COARSE_CONVERSION_VALUE("coarse_conversion_value"),
      @SerializedName("comscore_market")
      VALUE_COMSCORE_MARKET("comscore_market"),
      @SerializedName("conversion_destination")
      VALUE_CONVERSION_DESTINATION("conversion_destination"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("creative_automation_asset_id")
      VALUE_CREATIVE_AUTOMATION_ASSET_ID("creative_automation_asset_id"),
      @SerializedName("creative_relaxation_asset_type")
      VALUE_CREATIVE_RELAXATION_ASSET_TYPE("creative_relaxation_asset_type"),
      @SerializedName("crm_advertiser_l12_territory_ids")
      VALUE_CRM_ADVERTISER_L12_TERRITORY_IDS("crm_advertiser_l12_territory_ids"),
      @SerializedName("crm_advertiser_subvertical_id")
      VALUE_CRM_ADVERTISER_SUBVERTICAL_ID("crm_advertiser_subvertical_id"),
      @SerializedName("crm_advertiser_vertical_id")
      VALUE_CRM_ADVERTISER_VERTICAL_ID("crm_advertiser_vertical_id"),
      @SerializedName("crm_ult_advertiser_id")
      VALUE_CRM_ULT_ADVERTISER_ID("crm_ult_advertiser_id"),
      @SerializedName("description_asset")
      VALUE_DESCRIPTION_ASSET("description_asset"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("dma")
      VALUE_DMA("dma"),
      @SerializedName("fidelity_type")
      VALUE_FIDELITY_TYPE("fidelity_type"),
      @SerializedName("flexible_format_asset_type")
      VALUE_FLEXIBLE_FORMAT_ASSET_TYPE("flexible_format_asset_type"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("gen_ai_asset_type")
      VALUE_GEN_AI_ASSET_TYPE("gen_ai_asset_type"),
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
      @SerializedName("impression_view_time_advertiser_hour_v2")
      VALUE_IMPRESSION_VIEW_TIME_ADVERTISER_HOUR_V2("impression_view_time_advertiser_hour_v2"),
      @SerializedName("is_auto_advance")
      VALUE_IS_AUTO_ADVANCE("is_auto_advance"),
      @SerializedName("is_conversion_id_modeled")
      VALUE_IS_CONVERSION_ID_MODELED("is_conversion_id_modeled"),
      @SerializedName("is_rendered_as_delayed_skip_ad")
      VALUE_IS_RENDERED_AS_DELAYED_SKIP_AD("is_rendered_as_delayed_skip_ad"),
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
      @SerializedName("media_type")
      VALUE_MEDIA_TYPE("media_type"),
      @SerializedName("mmm")
      VALUE_MMM("mmm"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("platform_position")
      VALUE_PLATFORM_POSITION("platform_position"),
      @SerializedName("postback_sequence_index")
      VALUE_POSTBACK_SEQUENCE_INDEX("postback_sequence_index"),
      @SerializedName("product_brand_breakdown")
      VALUE_PRODUCT_BRAND_BREAKDOWN("product_brand_breakdown"),
      @SerializedName("product_category_breakdown")
      VALUE_PRODUCT_CATEGORY_BREAKDOWN("product_category_breakdown"),
      @SerializedName("product_custom_label_0_breakdown")
      VALUE_PRODUCT_CUSTOM_LABEL_0_BREAKDOWN("product_custom_label_0_breakdown"),
      @SerializedName("product_custom_label_1_breakdown")
      VALUE_PRODUCT_CUSTOM_LABEL_1_BREAKDOWN("product_custom_label_1_breakdown"),
      @SerializedName("product_custom_label_2_breakdown")
      VALUE_PRODUCT_CUSTOM_LABEL_2_BREAKDOWN("product_custom_label_2_breakdown"),
      @SerializedName("product_custom_label_3_breakdown")
      VALUE_PRODUCT_CUSTOM_LABEL_3_BREAKDOWN("product_custom_label_3_breakdown"),
      @SerializedName("product_custom_label_4_breakdown")
      VALUE_PRODUCT_CUSTOM_LABEL_4_BREAKDOWN("product_custom_label_4_breakdown"),
      @SerializedName("product_group_content_id_breakdown")
      VALUE_PRODUCT_GROUP_CONTENT_ID_BREAKDOWN("product_group_content_id_breakdown"),
      @SerializedName("product_group_id")
      VALUE_PRODUCT_GROUP_ID("product_group_id"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("product_set_id_breakdown")
      VALUE_PRODUCT_SET_ID_BREAKDOWN("product_set_id_breakdown"),
      @SerializedName("publisher_platform")
      VALUE_PUBLISHER_PLATFORM("publisher_platform"),
      @SerializedName("redownload")
      VALUE_REDOWNLOAD("redownload"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("rta_ugc_topic")
      VALUE_RTA_UGC_TOPIC("rta_ugc_topic"),
      @SerializedName("rule_set_id")
      VALUE_RULE_SET_ID("rule_set_id"),
      @SerializedName("rule_set_name")
      VALUE_RULE_SET_NAME("rule_set_name"),
      @SerializedName("signal_source_bucket")
      VALUE_SIGNAL_SOURCE_BUCKET("signal_source_bucket"),
      @SerializedName("skan_campaign_id")
      VALUE_SKAN_CAMPAIGN_ID("skan_campaign_id"),
      @SerializedName("skan_conversion_id")
      VALUE_SKAN_CONVERSION_ID("skan_conversion_id"),
      @SerializedName("skan_version")
      VALUE_SKAN_VERSION("skan_version"),
      @SerializedName("sot_attribution_model_type")
      VALUE_SOT_ATTRIBUTION_MODEL_TYPE("sot_attribution_model_type"),
      @SerializedName("sot_attribution_window")
      VALUE_SOT_ATTRIBUTION_WINDOW("sot_attribution_window"),
      @SerializedName("sot_channel")
      VALUE_SOT_CHANNEL("sot_channel"),
      @SerializedName("sot_event_type")
      VALUE_SOT_EVENT_TYPE("sot_event_type"),
      @SerializedName("sot_source")
      VALUE_SOT_SOURCE("sot_source"),
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

  public AdReportRun copyFrom(AdReportRun instance) {
    this.mAccountId = instance.mAccountId;
    this.mAsyncPercentCompletion = instance.mAsyncPercentCompletion;
    this.mAsyncReportUrl = instance.mAsyncReportUrl;
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mEmails = instance.mEmails;
    this.mErrorCode = instance.mErrorCode;
    this.mFriendlyName = instance.mFriendlyName;
    this.mId = instance.mId;
    this.mIsAsyncExport = instance.mIsAsyncExport;
    this.mIsBookmarked = instance.mIsBookmarked;
    this.mIsRunning = instance.mIsRunning;
    this.mScheduleId = instance.mScheduleId;
    this.mTimeCompleted = instance.mTimeCompleted;
    this.mTimeRef = instance.mTimeRef;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdReportRun> getParser() {
    return new APIRequest.ResponseParser<AdReportRun>() {
      public APINodeList<AdReportRun> parseResponse(String response, APIContext context, APIRequest<AdReportRun> request, String header) throws MalformedResponseException {
        return AdReportRun.parseResponse(response, context, request, header);
      }
    };
  }
}
