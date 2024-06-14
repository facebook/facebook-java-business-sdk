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
public class AdAccountUserSettings extends APINode {
  @SerializedName("acf_should_opt_out_video_adjustments")
  private Boolean mAcfShouldOptOutVideoAdjustments = null;
  @SerializedName("aco_sticky_settings")
  private List<Map<String, String>> mAcoStickySettings = null;
  @SerializedName("ad_account")
  private AdAccount mAdAccount = null;
  @SerializedName("ad_object_export_format")
  private String mAdObjectExportFormat = null;
  @SerializedName("auto_review_video_caption")
  private Boolean mAutoReviewVideoCaption = null;
  @SerializedName("campaign_overview_columns")
  private List<String> mCampaignOverviewColumns = null;
  @SerializedName("column_suggestion_status")
  private String mColumnSuggestionStatus = null;
  @SerializedName("default_account_overview_agegender_metrics")
  private List<String> mDefaultAccountOverviewAgegenderMetrics = null;
  @SerializedName("default_account_overview_location_metrics")
  private List<String> mDefaultAccountOverviewLocationMetrics = null;
  @SerializedName("default_account_overview_metrics")
  private List<String> mDefaultAccountOverviewMetrics = null;
  @SerializedName("default_account_overview_time_metrics")
  private List<String> mDefaultAccountOverviewTimeMetrics = null;
  @SerializedName("default_builtin_column_preset")
  private String mDefaultBuiltinColumnPreset = null;
  @SerializedName("default_nam_time_range")
  private String mDefaultNamTimeRange = null;
  @SerializedName("draft_mode_enabled")
  private Boolean mDraftModeEnabled = null;
  @SerializedName("export_deleted_items_with_delivery")
  private Boolean mExportDeletedItemsWithDelivery = null;
  @SerializedName("export_summary_row")
  private Boolean mExportSummaryRow = null;
  @SerializedName("has_seen_groups_column_flexing_experience")
  private Boolean mHasSeenGroupsColumnFlexingExperience = null;
  @SerializedName("has_seen_leads_column_flexing_experience")
  private Boolean mHasSeenLeadsColumnFlexingExperience = null;
  @SerializedName("has_seen_shops_ads_metrics_onboarding_tour")
  private Boolean mHasSeenShopsAdsMetricsOnboardingTour = null;
  @SerializedName("has_seen_shops_column_flexing_experience")
  private Boolean mHasSeenShopsColumnFlexingExperience = null;
  @SerializedName("hidden_optimization_tips")
  private List<Map<String, Boolean>> mHiddenOptimizationTips = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_3p_auth_setting_set")
  private Boolean mIs3pAuthSettingSet = null;
  @SerializedName("is_text_variation_nux_close")
  private Boolean mIsTextVariationNuxClose = null;
  @SerializedName("last_used_columns")
  private Object mLastUsedColumns = null;
  @SerializedName("last_used_pe_filters")
  private List<Object> mLastUsedPeFilters = null;
  @SerializedName("last_used_website_urls")
  private List<String> mLastUsedWebsiteUrls = null;
  @SerializedName("outlier_preferences")
  private Object mOutlierPreferences = null;
  @SerializedName("pinned_ad_object_ids")
  private List<String> mPinnedAdObjectIds = null;
  @SerializedName("rb_export_format")
  private String mRbExportFormat = null;
  @SerializedName("rb_export_raw_data")
  private Boolean mRbExportRawData = null;
  @SerializedName("rb_export_summary_row")
  private Boolean mRbExportSummaryRow = null;
  @SerializedName("saip_advertiser_setup_optimisation_guidance_overall_state")
  private String mSaipAdvertiserSetupOptimisationGuidanceOverallState = null;
  @SerializedName("saip_advertiser_setup_optimisation_guidance_state")
  private List<Map<String, String>> mSaipAdvertiserSetupOptimisationGuidanceState = null;
  @SerializedName("shops_ads_metrics_onboarding_tour_close_count")
  private Long mShopsAdsMetricsOnboardingTourCloseCount = null;
  @SerializedName("shops_ads_metrics_onboarding_tour_last_action_time")
  private String mShopsAdsMetricsOnboardingTourLastActionTime = null;
  @SerializedName("should_default_image_auto_crop")
  private Boolean mShouldDefaultImageAutoCrop = null;
  @SerializedName("should_default_image_auto_crop_for_tail")
  private Boolean mShouldDefaultImageAutoCropForTail = null;
  @SerializedName("should_default_image_auto_crop_optimization")
  private Boolean mShouldDefaultImageAutoCropOptimization = null;
  @SerializedName("should_default_image_dof_toggle")
  private Boolean mShouldDefaultImageDofToggle = null;
  @SerializedName("should_default_image_lpp_ads_to_square")
  private Boolean mShouldDefaultImageLppAdsToSquare = null;
  @SerializedName("should_default_instagram_profile_card_optimization")
  private Boolean mShouldDefaultInstagramProfileCardOptimization = null;
  @SerializedName("should_default_text_swapping_optimization")
  private Boolean mShouldDefaultTextSwappingOptimization = null;
  @SerializedName("should_logout_of_3p_sourcing")
  private Boolean mShouldLogoutOf3pSourcing = null;
  @SerializedName("show_archived_data")
  private Boolean mShowArchivedData = null;
  @SerializedName("show_text_variation_nux_tooltip")
  private Boolean mShowTextVariationNuxTooltip = null;
  @SerializedName("syd_campaign_trends_activemetric")
  private String mSydCampaignTrendsActivemetric = null;
  @SerializedName("syd_campaign_trends_attribution")
  private String mSydCampaignTrendsAttribution = null;
  @SerializedName("syd_campaign_trends_metrics")
  private List<String> mSydCampaignTrendsMetrics = null;
  @SerializedName("syd_campaign_trends_objective")
  private EnumSydCampaignTrendsObjective mSydCampaignTrendsObjective = null;
  @SerializedName("syd_campaign_trends_time_range")
  private String mSydCampaignTrendsTimeRange = null;
  @SerializedName("syd_landing_page_opt_in_status")
  private String mSydLandingPageOptInStatus = null;
  @SerializedName("text_variations_opt_in_type")
  private String mTextVariationsOptInType = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  AdAccountUserSettings() {
  }

  public AdAccountUserSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountUserSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountUserSettings fetch() throws APIException{
    AdAccountUserSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountUserSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountUserSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountUserSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountUserSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountUserSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountUserSettings>)(
      new APIRequest<AdAccountUserSettings>(context, "", "/", "GET", AdAccountUserSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountUserSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountUserSettings.getParser())
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
  public static AdAccountUserSettings loadJSON(String json, APIContext context, String header) {
    AdAccountUserSettings adAccountUserSettings = getGson().fromJson(json, AdAccountUserSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountUserSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountUserSettings.context = context;
    adAccountUserSettings.rawValue = json;
    adAccountUserSettings.header = header;
    return adAccountUserSettings;
  }

  public static APINodeList<AdAccountUserSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountUserSettings> adAccountUserSettingss = new APINodeList<AdAccountUserSettings>(request, json, header);
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
          adAccountUserSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountUserSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountUserSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountUserSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountUserSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountUserSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountUserSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountUserSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountUserSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountUserSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountUserSettingss;
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
              adAccountUserSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountUserSettingss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountUserSettingss.clear();
          adAccountUserSettingss.add(loadJSON(json, context, header));
          return adAccountUserSettingss;
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


  public Boolean getFieldAcfShouldOptOutVideoAdjustments() {
    return mAcfShouldOptOutVideoAdjustments;
  }

  public List<Map<String, String>> getFieldAcoStickySettings() {
    return mAcoStickySettings;
  }

  public AdAccount getFieldAdAccount() {
    if (mAdAccount != null) {
      mAdAccount.context = getContext();
    }
    return mAdAccount;
  }

  public String getFieldAdObjectExportFormat() {
    return mAdObjectExportFormat;
  }

  public Boolean getFieldAutoReviewVideoCaption() {
    return mAutoReviewVideoCaption;
  }

  public List<String> getFieldCampaignOverviewColumns() {
    return mCampaignOverviewColumns;
  }

  public String getFieldColumnSuggestionStatus() {
    return mColumnSuggestionStatus;
  }

  public List<String> getFieldDefaultAccountOverviewAgegenderMetrics() {
    return mDefaultAccountOverviewAgegenderMetrics;
  }

  public List<String> getFieldDefaultAccountOverviewLocationMetrics() {
    return mDefaultAccountOverviewLocationMetrics;
  }

  public List<String> getFieldDefaultAccountOverviewMetrics() {
    return mDefaultAccountOverviewMetrics;
  }

  public List<String> getFieldDefaultAccountOverviewTimeMetrics() {
    return mDefaultAccountOverviewTimeMetrics;
  }

  public String getFieldDefaultBuiltinColumnPreset() {
    return mDefaultBuiltinColumnPreset;
  }

  public String getFieldDefaultNamTimeRange() {
    return mDefaultNamTimeRange;
  }

  public Boolean getFieldDraftModeEnabled() {
    return mDraftModeEnabled;
  }

  public Boolean getFieldExportDeletedItemsWithDelivery() {
    return mExportDeletedItemsWithDelivery;
  }

  public Boolean getFieldExportSummaryRow() {
    return mExportSummaryRow;
  }

  public Boolean getFieldHasSeenGroupsColumnFlexingExperience() {
    return mHasSeenGroupsColumnFlexingExperience;
  }

  public Boolean getFieldHasSeenLeadsColumnFlexingExperience() {
    return mHasSeenLeadsColumnFlexingExperience;
  }

  public Boolean getFieldHasSeenShopsAdsMetricsOnboardingTour() {
    return mHasSeenShopsAdsMetricsOnboardingTour;
  }

  public Boolean getFieldHasSeenShopsColumnFlexingExperience() {
    return mHasSeenShopsColumnFlexingExperience;
  }

  public List<Map<String, Boolean>> getFieldHiddenOptimizationTips() {
    return mHiddenOptimizationTips;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIs3pAuthSettingSet() {
    return mIs3pAuthSettingSet;
  }

  public Boolean getFieldIsTextVariationNuxClose() {
    return mIsTextVariationNuxClose;
  }

  public Object getFieldLastUsedColumns() {
    return mLastUsedColumns;
  }

  public List<Object> getFieldLastUsedPeFilters() {
    return mLastUsedPeFilters;
  }

  public List<String> getFieldLastUsedWebsiteUrls() {
    return mLastUsedWebsiteUrls;
  }

  public Object getFieldOutlierPreferences() {
    return mOutlierPreferences;
  }

  public List<String> getFieldPinnedAdObjectIds() {
    return mPinnedAdObjectIds;
  }

  public String getFieldRbExportFormat() {
    return mRbExportFormat;
  }

  public Boolean getFieldRbExportRawData() {
    return mRbExportRawData;
  }

  public Boolean getFieldRbExportSummaryRow() {
    return mRbExportSummaryRow;
  }

  public String getFieldSaipAdvertiserSetupOptimisationGuidanceOverallState() {
    return mSaipAdvertiserSetupOptimisationGuidanceOverallState;
  }

  public List<Map<String, String>> getFieldSaipAdvertiserSetupOptimisationGuidanceState() {
    return mSaipAdvertiserSetupOptimisationGuidanceState;
  }

  public Long getFieldShopsAdsMetricsOnboardingTourCloseCount() {
    return mShopsAdsMetricsOnboardingTourCloseCount;
  }

  public String getFieldShopsAdsMetricsOnboardingTourLastActionTime() {
    return mShopsAdsMetricsOnboardingTourLastActionTime;
  }

  public Boolean getFieldShouldDefaultImageAutoCrop() {
    return mShouldDefaultImageAutoCrop;
  }

  public Boolean getFieldShouldDefaultImageAutoCropForTail() {
    return mShouldDefaultImageAutoCropForTail;
  }

  public Boolean getFieldShouldDefaultImageAutoCropOptimization() {
    return mShouldDefaultImageAutoCropOptimization;
  }

  public Boolean getFieldShouldDefaultImageDofToggle() {
    return mShouldDefaultImageDofToggle;
  }

  public Boolean getFieldShouldDefaultImageLppAdsToSquare() {
    return mShouldDefaultImageLppAdsToSquare;
  }

  public Boolean getFieldShouldDefaultInstagramProfileCardOptimization() {
    return mShouldDefaultInstagramProfileCardOptimization;
  }

  public Boolean getFieldShouldDefaultTextSwappingOptimization() {
    return mShouldDefaultTextSwappingOptimization;
  }

  public Boolean getFieldShouldLogoutOf3pSourcing() {
    return mShouldLogoutOf3pSourcing;
  }

  public Boolean getFieldShowArchivedData() {
    return mShowArchivedData;
  }

  public Boolean getFieldShowTextVariationNuxTooltip() {
    return mShowTextVariationNuxTooltip;
  }

  public String getFieldSydCampaignTrendsActivemetric() {
    return mSydCampaignTrendsActivemetric;
  }

  public String getFieldSydCampaignTrendsAttribution() {
    return mSydCampaignTrendsAttribution;
  }

  public List<String> getFieldSydCampaignTrendsMetrics() {
    return mSydCampaignTrendsMetrics;
  }

  public EnumSydCampaignTrendsObjective getFieldSydCampaignTrendsObjective() {
    return mSydCampaignTrendsObjective;
  }

  public String getFieldSydCampaignTrendsTimeRange() {
    return mSydCampaignTrendsTimeRange;
  }

  public String getFieldSydLandingPageOptInStatus() {
    return mSydLandingPageOptInStatus;
  }

  public String getFieldTextVariationsOptInType() {
    return mTextVariationsOptInType;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }



  public static class APIRequestGet extends APIRequest<AdAccountUserSettings> {

    AdAccountUserSettings lastResponse = null;
    @Override
    public AdAccountUserSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "acf_should_opt_out_video_adjustments",
      "aco_sticky_settings",
      "ad_account",
      "ad_object_export_format",
      "auto_review_video_caption",
      "campaign_overview_columns",
      "column_suggestion_status",
      "default_account_overview_agegender_metrics",
      "default_account_overview_location_metrics",
      "default_account_overview_metrics",
      "default_account_overview_time_metrics",
      "default_builtin_column_preset",
      "default_nam_time_range",
      "draft_mode_enabled",
      "export_deleted_items_with_delivery",
      "export_summary_row",
      "has_seen_groups_column_flexing_experience",
      "has_seen_leads_column_flexing_experience",
      "has_seen_shops_ads_metrics_onboarding_tour",
      "has_seen_shops_column_flexing_experience",
      "hidden_optimization_tips",
      "id",
      "is_3p_auth_setting_set",
      "is_text_variation_nux_close",
      "last_used_columns",
      "last_used_pe_filters",
      "last_used_website_urls",
      "outlier_preferences",
      "pinned_ad_object_ids",
      "rb_export_format",
      "rb_export_raw_data",
      "rb_export_summary_row",
      "saip_advertiser_setup_optimisation_guidance_overall_state",
      "saip_advertiser_setup_optimisation_guidance_state",
      "shops_ads_metrics_onboarding_tour_close_count",
      "shops_ads_metrics_onboarding_tour_last_action_time",
      "should_default_image_auto_crop",
      "should_default_image_auto_crop_for_tail",
      "should_default_image_auto_crop_optimization",
      "should_default_image_dof_toggle",
      "should_default_image_lpp_ads_to_square",
      "should_default_instagram_profile_card_optimization",
      "should_default_text_swapping_optimization",
      "should_logout_of_3p_sourcing",
      "show_archived_data",
      "show_text_variation_nux_tooltip",
      "syd_campaign_trends_activemetric",
      "syd_campaign_trends_attribution",
      "syd_campaign_trends_metrics",
      "syd_campaign_trends_objective",
      "syd_campaign_trends_time_range",
      "syd_landing_page_opt_in_status",
      "text_variations_opt_in_type",
      "user",
    };

    @Override
    public AdAccountUserSettings parseResponse(String response, String header) throws APIException {
      return AdAccountUserSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAccountUserSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountUserSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAccountUserSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountUserSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAccountUserSettings>() {
           public AdAccountUserSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestAcfShouldOptOutVideoAdjustmentsField () {
      return this.requestAcfShouldOptOutVideoAdjustmentsField(true);
    }
    public APIRequestGet requestAcfShouldOptOutVideoAdjustmentsField (boolean value) {
      this.requestField("acf_should_opt_out_video_adjustments", value);
      return this;
    }
    public APIRequestGet requestAcoStickySettingsField () {
      return this.requestAcoStickySettingsField(true);
    }
    public APIRequestGet requestAcoStickySettingsField (boolean value) {
      this.requestField("aco_sticky_settings", value);
      return this;
    }
    public APIRequestGet requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGet requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGet requestAdObjectExportFormatField () {
      return this.requestAdObjectExportFormatField(true);
    }
    public APIRequestGet requestAdObjectExportFormatField (boolean value) {
      this.requestField("ad_object_export_format", value);
      return this;
    }
    public APIRequestGet requestAutoReviewVideoCaptionField () {
      return this.requestAutoReviewVideoCaptionField(true);
    }
    public APIRequestGet requestAutoReviewVideoCaptionField (boolean value) {
      this.requestField("auto_review_video_caption", value);
      return this;
    }
    public APIRequestGet requestCampaignOverviewColumnsField () {
      return this.requestCampaignOverviewColumnsField(true);
    }
    public APIRequestGet requestCampaignOverviewColumnsField (boolean value) {
      this.requestField("campaign_overview_columns", value);
      return this;
    }
    public APIRequestGet requestColumnSuggestionStatusField () {
      return this.requestColumnSuggestionStatusField(true);
    }
    public APIRequestGet requestColumnSuggestionStatusField (boolean value) {
      this.requestField("column_suggestion_status", value);
      return this;
    }
    public APIRequestGet requestDefaultAccountOverviewAgegenderMetricsField () {
      return this.requestDefaultAccountOverviewAgegenderMetricsField(true);
    }
    public APIRequestGet requestDefaultAccountOverviewAgegenderMetricsField (boolean value) {
      this.requestField("default_account_overview_agegender_metrics", value);
      return this;
    }
    public APIRequestGet requestDefaultAccountOverviewLocationMetricsField () {
      return this.requestDefaultAccountOverviewLocationMetricsField(true);
    }
    public APIRequestGet requestDefaultAccountOverviewLocationMetricsField (boolean value) {
      this.requestField("default_account_overview_location_metrics", value);
      return this;
    }
    public APIRequestGet requestDefaultAccountOverviewMetricsField () {
      return this.requestDefaultAccountOverviewMetricsField(true);
    }
    public APIRequestGet requestDefaultAccountOverviewMetricsField (boolean value) {
      this.requestField("default_account_overview_metrics", value);
      return this;
    }
    public APIRequestGet requestDefaultAccountOverviewTimeMetricsField () {
      return this.requestDefaultAccountOverviewTimeMetricsField(true);
    }
    public APIRequestGet requestDefaultAccountOverviewTimeMetricsField (boolean value) {
      this.requestField("default_account_overview_time_metrics", value);
      return this;
    }
    public APIRequestGet requestDefaultBuiltinColumnPresetField () {
      return this.requestDefaultBuiltinColumnPresetField(true);
    }
    public APIRequestGet requestDefaultBuiltinColumnPresetField (boolean value) {
      this.requestField("default_builtin_column_preset", value);
      return this;
    }
    public APIRequestGet requestDefaultNamTimeRangeField () {
      return this.requestDefaultNamTimeRangeField(true);
    }
    public APIRequestGet requestDefaultNamTimeRangeField (boolean value) {
      this.requestField("default_nam_time_range", value);
      return this;
    }
    public APIRequestGet requestDraftModeEnabledField () {
      return this.requestDraftModeEnabledField(true);
    }
    public APIRequestGet requestDraftModeEnabledField (boolean value) {
      this.requestField("draft_mode_enabled", value);
      return this;
    }
    public APIRequestGet requestExportDeletedItemsWithDeliveryField () {
      return this.requestExportDeletedItemsWithDeliveryField(true);
    }
    public APIRequestGet requestExportDeletedItemsWithDeliveryField (boolean value) {
      this.requestField("export_deleted_items_with_delivery", value);
      return this;
    }
    public APIRequestGet requestExportSummaryRowField () {
      return this.requestExportSummaryRowField(true);
    }
    public APIRequestGet requestExportSummaryRowField (boolean value) {
      this.requestField("export_summary_row", value);
      return this;
    }
    public APIRequestGet requestHasSeenGroupsColumnFlexingExperienceField () {
      return this.requestHasSeenGroupsColumnFlexingExperienceField(true);
    }
    public APIRequestGet requestHasSeenGroupsColumnFlexingExperienceField (boolean value) {
      this.requestField("has_seen_groups_column_flexing_experience", value);
      return this;
    }
    public APIRequestGet requestHasSeenLeadsColumnFlexingExperienceField () {
      return this.requestHasSeenLeadsColumnFlexingExperienceField(true);
    }
    public APIRequestGet requestHasSeenLeadsColumnFlexingExperienceField (boolean value) {
      this.requestField("has_seen_leads_column_flexing_experience", value);
      return this;
    }
    public APIRequestGet requestHasSeenShopsAdsMetricsOnboardingTourField () {
      return this.requestHasSeenShopsAdsMetricsOnboardingTourField(true);
    }
    public APIRequestGet requestHasSeenShopsAdsMetricsOnboardingTourField (boolean value) {
      this.requestField("has_seen_shops_ads_metrics_onboarding_tour", value);
      return this;
    }
    public APIRequestGet requestHasSeenShopsColumnFlexingExperienceField () {
      return this.requestHasSeenShopsColumnFlexingExperienceField(true);
    }
    public APIRequestGet requestHasSeenShopsColumnFlexingExperienceField (boolean value) {
      this.requestField("has_seen_shops_column_flexing_experience", value);
      return this;
    }
    public APIRequestGet requestHiddenOptimizationTipsField () {
      return this.requestHiddenOptimizationTipsField(true);
    }
    public APIRequestGet requestHiddenOptimizationTipsField (boolean value) {
      this.requestField("hidden_optimization_tips", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIs3pAuthSettingSetField () {
      return this.requestIs3pAuthSettingSetField(true);
    }
    public APIRequestGet requestIs3pAuthSettingSetField (boolean value) {
      this.requestField("is_3p_auth_setting_set", value);
      return this;
    }
    public APIRequestGet requestIsTextVariationNuxCloseField () {
      return this.requestIsTextVariationNuxCloseField(true);
    }
    public APIRequestGet requestIsTextVariationNuxCloseField (boolean value) {
      this.requestField("is_text_variation_nux_close", value);
      return this;
    }
    public APIRequestGet requestLastUsedColumnsField () {
      return this.requestLastUsedColumnsField(true);
    }
    public APIRequestGet requestLastUsedColumnsField (boolean value) {
      this.requestField("last_used_columns", value);
      return this;
    }
    public APIRequestGet requestLastUsedPeFiltersField () {
      return this.requestLastUsedPeFiltersField(true);
    }
    public APIRequestGet requestLastUsedPeFiltersField (boolean value) {
      this.requestField("last_used_pe_filters", value);
      return this;
    }
    public APIRequestGet requestLastUsedWebsiteUrlsField () {
      return this.requestLastUsedWebsiteUrlsField(true);
    }
    public APIRequestGet requestLastUsedWebsiteUrlsField (boolean value) {
      this.requestField("last_used_website_urls", value);
      return this;
    }
    public APIRequestGet requestOutlierPreferencesField () {
      return this.requestOutlierPreferencesField(true);
    }
    public APIRequestGet requestOutlierPreferencesField (boolean value) {
      this.requestField("outlier_preferences", value);
      return this;
    }
    public APIRequestGet requestPinnedAdObjectIdsField () {
      return this.requestPinnedAdObjectIdsField(true);
    }
    public APIRequestGet requestPinnedAdObjectIdsField (boolean value) {
      this.requestField("pinned_ad_object_ids", value);
      return this;
    }
    public APIRequestGet requestRbExportFormatField () {
      return this.requestRbExportFormatField(true);
    }
    public APIRequestGet requestRbExportFormatField (boolean value) {
      this.requestField("rb_export_format", value);
      return this;
    }
    public APIRequestGet requestRbExportRawDataField () {
      return this.requestRbExportRawDataField(true);
    }
    public APIRequestGet requestRbExportRawDataField (boolean value) {
      this.requestField("rb_export_raw_data", value);
      return this;
    }
    public APIRequestGet requestRbExportSummaryRowField () {
      return this.requestRbExportSummaryRowField(true);
    }
    public APIRequestGet requestRbExportSummaryRowField (boolean value) {
      this.requestField("rb_export_summary_row", value);
      return this;
    }
    public APIRequestGet requestSaipAdvertiserSetupOptimisationGuidanceOverallStateField () {
      return this.requestSaipAdvertiserSetupOptimisationGuidanceOverallStateField(true);
    }
    public APIRequestGet requestSaipAdvertiserSetupOptimisationGuidanceOverallStateField (boolean value) {
      this.requestField("saip_advertiser_setup_optimisation_guidance_overall_state", value);
      return this;
    }
    public APIRequestGet requestSaipAdvertiserSetupOptimisationGuidanceStateField () {
      return this.requestSaipAdvertiserSetupOptimisationGuidanceStateField(true);
    }
    public APIRequestGet requestSaipAdvertiserSetupOptimisationGuidanceStateField (boolean value) {
      this.requestField("saip_advertiser_setup_optimisation_guidance_state", value);
      return this;
    }
    public APIRequestGet requestShopsAdsMetricsOnboardingTourCloseCountField () {
      return this.requestShopsAdsMetricsOnboardingTourCloseCountField(true);
    }
    public APIRequestGet requestShopsAdsMetricsOnboardingTourCloseCountField (boolean value) {
      this.requestField("shops_ads_metrics_onboarding_tour_close_count", value);
      return this;
    }
    public APIRequestGet requestShopsAdsMetricsOnboardingTourLastActionTimeField () {
      return this.requestShopsAdsMetricsOnboardingTourLastActionTimeField(true);
    }
    public APIRequestGet requestShopsAdsMetricsOnboardingTourLastActionTimeField (boolean value) {
      this.requestField("shops_ads_metrics_onboarding_tour_last_action_time", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultImageAutoCropField () {
      return this.requestShouldDefaultImageAutoCropField(true);
    }
    public APIRequestGet requestShouldDefaultImageAutoCropField (boolean value) {
      this.requestField("should_default_image_auto_crop", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultImageAutoCropForTailField () {
      return this.requestShouldDefaultImageAutoCropForTailField(true);
    }
    public APIRequestGet requestShouldDefaultImageAutoCropForTailField (boolean value) {
      this.requestField("should_default_image_auto_crop_for_tail", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultImageAutoCropOptimizationField () {
      return this.requestShouldDefaultImageAutoCropOptimizationField(true);
    }
    public APIRequestGet requestShouldDefaultImageAutoCropOptimizationField (boolean value) {
      this.requestField("should_default_image_auto_crop_optimization", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultImageDofToggleField () {
      return this.requestShouldDefaultImageDofToggleField(true);
    }
    public APIRequestGet requestShouldDefaultImageDofToggleField (boolean value) {
      this.requestField("should_default_image_dof_toggle", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultImageLppAdsToSquareField () {
      return this.requestShouldDefaultImageLppAdsToSquareField(true);
    }
    public APIRequestGet requestShouldDefaultImageLppAdsToSquareField (boolean value) {
      this.requestField("should_default_image_lpp_ads_to_square", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultInstagramProfileCardOptimizationField () {
      return this.requestShouldDefaultInstagramProfileCardOptimizationField(true);
    }
    public APIRequestGet requestShouldDefaultInstagramProfileCardOptimizationField (boolean value) {
      this.requestField("should_default_instagram_profile_card_optimization", value);
      return this;
    }
    public APIRequestGet requestShouldDefaultTextSwappingOptimizationField () {
      return this.requestShouldDefaultTextSwappingOptimizationField(true);
    }
    public APIRequestGet requestShouldDefaultTextSwappingOptimizationField (boolean value) {
      this.requestField("should_default_text_swapping_optimization", value);
      return this;
    }
    public APIRequestGet requestShouldLogoutOf3pSourcingField () {
      return this.requestShouldLogoutOf3pSourcingField(true);
    }
    public APIRequestGet requestShouldLogoutOf3pSourcingField (boolean value) {
      this.requestField("should_logout_of_3p_sourcing", value);
      return this;
    }
    public APIRequestGet requestShowArchivedDataField () {
      return this.requestShowArchivedDataField(true);
    }
    public APIRequestGet requestShowArchivedDataField (boolean value) {
      this.requestField("show_archived_data", value);
      return this;
    }
    public APIRequestGet requestShowTextVariationNuxTooltipField () {
      return this.requestShowTextVariationNuxTooltipField(true);
    }
    public APIRequestGet requestShowTextVariationNuxTooltipField (boolean value) {
      this.requestField("show_text_variation_nux_tooltip", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsActivemetricField () {
      return this.requestSydCampaignTrendsActivemetricField(true);
    }
    public APIRequestGet requestSydCampaignTrendsActivemetricField (boolean value) {
      this.requestField("syd_campaign_trends_activemetric", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsAttributionField () {
      return this.requestSydCampaignTrendsAttributionField(true);
    }
    public APIRequestGet requestSydCampaignTrendsAttributionField (boolean value) {
      this.requestField("syd_campaign_trends_attribution", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsMetricsField () {
      return this.requestSydCampaignTrendsMetricsField(true);
    }
    public APIRequestGet requestSydCampaignTrendsMetricsField (boolean value) {
      this.requestField("syd_campaign_trends_metrics", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsObjectiveField () {
      return this.requestSydCampaignTrendsObjectiveField(true);
    }
    public APIRequestGet requestSydCampaignTrendsObjectiveField (boolean value) {
      this.requestField("syd_campaign_trends_objective", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsTimeRangeField () {
      return this.requestSydCampaignTrendsTimeRangeField(true);
    }
    public APIRequestGet requestSydCampaignTrendsTimeRangeField (boolean value) {
      this.requestField("syd_campaign_trends_time_range", value);
      return this;
    }
    public APIRequestGet requestSydLandingPageOptInStatusField () {
      return this.requestSydLandingPageOptInStatusField(true);
    }
    public APIRequestGet requestSydLandingPageOptInStatusField (boolean value) {
      this.requestField("syd_landing_page_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestTextVariationsOptInTypeField () {
      return this.requestTextVariationsOptInTypeField(true);
    }
    public APIRequestGet requestTextVariationsOptInTypeField (boolean value) {
      this.requestField("text_variations_opt_in_type", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
  }

  public static enum EnumSydCampaignTrendsObjective {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OUTCOME_APP_PROMOTION")
      VALUE_OUTCOME_APP_PROMOTION("OUTCOME_APP_PROMOTION"),
      @SerializedName("OUTCOME_AWARENESS")
      VALUE_OUTCOME_AWARENESS("OUTCOME_AWARENESS"),
      @SerializedName("OUTCOME_ENGAGEMENT")
      VALUE_OUTCOME_ENGAGEMENT("OUTCOME_ENGAGEMENT"),
      @SerializedName("OUTCOME_LEADS")
      VALUE_OUTCOME_LEADS("OUTCOME_LEADS"),
      @SerializedName("OUTCOME_SALES")
      VALUE_OUTCOME_SALES("OUTCOME_SALES"),
      @SerializedName("OUTCOME_TRAFFIC")
      VALUE_OUTCOME_TRAFFIC("OUTCOME_TRAFFIC"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("STORE_VISITS")
      VALUE_STORE_VISITS("STORE_VISITS"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      ;

      private String value;

      private EnumSydCampaignTrendsObjective(String value) {
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

  public AdAccountUserSettings copyFrom(AdAccountUserSettings instance) {
    this.mAcfShouldOptOutVideoAdjustments = instance.mAcfShouldOptOutVideoAdjustments;
    this.mAcoStickySettings = instance.mAcoStickySettings;
    this.mAdAccount = instance.mAdAccount;
    this.mAdObjectExportFormat = instance.mAdObjectExportFormat;
    this.mAutoReviewVideoCaption = instance.mAutoReviewVideoCaption;
    this.mCampaignOverviewColumns = instance.mCampaignOverviewColumns;
    this.mColumnSuggestionStatus = instance.mColumnSuggestionStatus;
    this.mDefaultAccountOverviewAgegenderMetrics = instance.mDefaultAccountOverviewAgegenderMetrics;
    this.mDefaultAccountOverviewLocationMetrics = instance.mDefaultAccountOverviewLocationMetrics;
    this.mDefaultAccountOverviewMetrics = instance.mDefaultAccountOverviewMetrics;
    this.mDefaultAccountOverviewTimeMetrics = instance.mDefaultAccountOverviewTimeMetrics;
    this.mDefaultBuiltinColumnPreset = instance.mDefaultBuiltinColumnPreset;
    this.mDefaultNamTimeRange = instance.mDefaultNamTimeRange;
    this.mDraftModeEnabled = instance.mDraftModeEnabled;
    this.mExportDeletedItemsWithDelivery = instance.mExportDeletedItemsWithDelivery;
    this.mExportSummaryRow = instance.mExportSummaryRow;
    this.mHasSeenGroupsColumnFlexingExperience = instance.mHasSeenGroupsColumnFlexingExperience;
    this.mHasSeenLeadsColumnFlexingExperience = instance.mHasSeenLeadsColumnFlexingExperience;
    this.mHasSeenShopsAdsMetricsOnboardingTour = instance.mHasSeenShopsAdsMetricsOnboardingTour;
    this.mHasSeenShopsColumnFlexingExperience = instance.mHasSeenShopsColumnFlexingExperience;
    this.mHiddenOptimizationTips = instance.mHiddenOptimizationTips;
    this.mId = instance.mId;
    this.mIs3pAuthSettingSet = instance.mIs3pAuthSettingSet;
    this.mIsTextVariationNuxClose = instance.mIsTextVariationNuxClose;
    this.mLastUsedColumns = instance.mLastUsedColumns;
    this.mLastUsedPeFilters = instance.mLastUsedPeFilters;
    this.mLastUsedWebsiteUrls = instance.mLastUsedWebsiteUrls;
    this.mOutlierPreferences = instance.mOutlierPreferences;
    this.mPinnedAdObjectIds = instance.mPinnedAdObjectIds;
    this.mRbExportFormat = instance.mRbExportFormat;
    this.mRbExportRawData = instance.mRbExportRawData;
    this.mRbExportSummaryRow = instance.mRbExportSummaryRow;
    this.mSaipAdvertiserSetupOptimisationGuidanceOverallState = instance.mSaipAdvertiserSetupOptimisationGuidanceOverallState;
    this.mSaipAdvertiserSetupOptimisationGuidanceState = instance.mSaipAdvertiserSetupOptimisationGuidanceState;
    this.mShopsAdsMetricsOnboardingTourCloseCount = instance.mShopsAdsMetricsOnboardingTourCloseCount;
    this.mShopsAdsMetricsOnboardingTourLastActionTime = instance.mShopsAdsMetricsOnboardingTourLastActionTime;
    this.mShouldDefaultImageAutoCrop = instance.mShouldDefaultImageAutoCrop;
    this.mShouldDefaultImageAutoCropForTail = instance.mShouldDefaultImageAutoCropForTail;
    this.mShouldDefaultImageAutoCropOptimization = instance.mShouldDefaultImageAutoCropOptimization;
    this.mShouldDefaultImageDofToggle = instance.mShouldDefaultImageDofToggle;
    this.mShouldDefaultImageLppAdsToSquare = instance.mShouldDefaultImageLppAdsToSquare;
    this.mShouldDefaultInstagramProfileCardOptimization = instance.mShouldDefaultInstagramProfileCardOptimization;
    this.mShouldDefaultTextSwappingOptimization = instance.mShouldDefaultTextSwappingOptimization;
    this.mShouldLogoutOf3pSourcing = instance.mShouldLogoutOf3pSourcing;
    this.mShowArchivedData = instance.mShowArchivedData;
    this.mShowTextVariationNuxTooltip = instance.mShowTextVariationNuxTooltip;
    this.mSydCampaignTrendsActivemetric = instance.mSydCampaignTrendsActivemetric;
    this.mSydCampaignTrendsAttribution = instance.mSydCampaignTrendsAttribution;
    this.mSydCampaignTrendsMetrics = instance.mSydCampaignTrendsMetrics;
    this.mSydCampaignTrendsObjective = instance.mSydCampaignTrendsObjective;
    this.mSydCampaignTrendsTimeRange = instance.mSydCampaignTrendsTimeRange;
    this.mSydLandingPageOptInStatus = instance.mSydLandingPageOptInStatus;
    this.mTextVariationsOptInType = instance.mTextVariationsOptInType;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountUserSettings> getParser() {
    return new APIRequest.ResponseParser<AdAccountUserSettings>() {
      public APINodeList<AdAccountUserSettings> parseResponse(String response, APIContext context, APIRequest<AdAccountUserSettings> request, String header) throws MalformedResponseException {
        return AdAccountUserSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
