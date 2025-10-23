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
public class AdsUserSettings extends APINode {
  @SerializedName("a_plus_c_survey_seen")
  private Boolean mAPlusCSurveySeen = null;
  @SerializedName("add_overlays_opt_in_status")
  private String mAddOverlaysOptInStatus = null;
  @SerializedName("adgroup_name_template")
  private Object mAdgroupNameTemplate = null;
  @SerializedName("ads_cs_catalog_opt_out_timestamp")
  private List<Map<String, Long>> mAdsCsCatalogOptOutTimestamp = null;
  @SerializedName("ads_cs_dynamic_se_opt_in_status")
  private String mAdsCsDynamicSeOptInStatus = null;
  @SerializedName("ads_cs_dynamic_se_opt_out_timestamp")
  private List<Map<String, Long>> mAdsCsDynamicSeOptOutTimestamp = null;
  @SerializedName("ads_cs_sitelinks_opt_in_status")
  private String mAdsCsSitelinksOptInStatus = null;
  @SerializedName("ads_cs_sitelinks_opt_out_timestamp")
  private List<Map<String, Long>> mAdsCsSitelinksOptOutTimestamp = null;
  @SerializedName("ads_destination_optimization_opt_out_timestamp")
  private List<Map<String, Long>> mAdsDestinationOptimizationOptOutTimestamp = null;
  @SerializedName("ads_tool_visits")
  private List<Object> mAdsToolVisits = null;
  @SerializedName("aplusc_ai_agent_opt_in_status")
  private String mApluscAiAgentOptInStatus = null;
  @SerializedName("aplusc_carousel_cda_opt_in_status")
  private String mApluscCarouselCdaOptInStatus = null;
  @SerializedName("aplusc_carousel_inline_comment_opt_in_status")
  private String mApluscCarouselInlineCommentOptInStatus = null;
  @SerializedName("aplusc_da_opt_in_status")
  private String mApluscDaOptInStatus = null;
  @SerializedName("aplusc_enhance_cta_opt_in_status")
  private String mApluscEnhanceCtaOptInStatus = null;
  @SerializedName("aplusc_epa_opt_in_status")
  private String mApluscEpaOptInStatus = null;
  @SerializedName("aplusc_local_store_extension_opt_in_status")
  private String mApluscLocalStoreExtensionOptInStatus = null;
  @SerializedName("aplusc_opt_out_friction")
  private List<String> mApluscOptOutFriction = null;
  @SerializedName("aplusc_videofilter_opt_in_status")
  private String mApluscVideofilterOptInStatus = null;
  @SerializedName("aplusc_videouncrop_opt_in_status")
  private String mApluscVideouncropOptInStatus = null;
  @SerializedName("autoflow_lite_opt_in_status")
  private String mAutoflowLiteOptInStatus = null;
  @SerializedName("autoflow_lite_should_opt_in")
  private Boolean mAutoflowLiteShouldOptIn = null;
  @SerializedName("blended_ads_creation_defaulting_opt_in_status")
  private String mBlendedAdsCreationDefaultingOptInStatus = null;
  @SerializedName("blended_ads_creation_defaulting_opt_out_campaign_group_ids")
  private List<Long> mBlendedAdsCreationDefaultingOptOutCampaignGroupIds = null;
  @SerializedName("bookmarked_pages")
  private List<Page> mBookmarkedPages = null;
  @SerializedName("campaign_group_name_template")
  private Object mCampaignGroupNameTemplate = null;
  @SerializedName("campaign_name_template")
  private Object mCampaignNameTemplate = null;
  @SerializedName("carousel_to_video_opt_in_status")
  private String mCarouselToVideoOptInStatus = null;
  @SerializedName("connected_sources_catalog_opt_in_status")
  private String mConnectedSourcesCatalogOptInStatus = null;
  @SerializedName("create_cta_sticker_opt_in_status")
  private String mCreateCtaStickerOptInStatus = null;
  @SerializedName("creative_flex_opt_in_status")
  private String mCreativeFlexOptInStatus = null;
  @SerializedName("da_add_overlays_opt_in_status")
  private String mDaAddOverlaysOptInStatus = null;
  @SerializedName("da_creative_flex_opt_in_status")
  private String mDaCreativeFlexOptInStatus = null;
  @SerializedName("da_hide_price_opt_in_status")
  private String mDaHidePriceOptInStatus = null;
  @SerializedName("da_manual_media_nux_impressions")
  private Long mDaManualMediaNuxImpressions = null;
  @SerializedName("default_creation_mode")
  private String mDefaultCreationMode = null;
  @SerializedName("dynamic_partnership_ads_opt_in_status")
  private String mDynamicPartnershipAdsOptInStatus = null;
  @SerializedName("enhance_cta_text_extraction_opt_in_status")
  private String mEnhanceCtaTextExtractionOptInStatus = null;
  @SerializedName("export_format_default")
  private String mExportFormatDefault = null;
  @SerializedName("focus_mode_default")
  private String mFocusModeDefault = null;
  @SerializedName("gen_ai_alpha_test_status")
  private Long mGenAiAlphaTestStatus = null;
  @SerializedName("gen_ai_auto_select_opt_in_status")
  private String mGenAiAutoSelectOptInStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_background_generation_opt_in_status")
  private String mImageBackgroundGenerationOptInStatus = null;
  @SerializedName("image_brightness_and_contrast_opt_in_status")
  private String mImageBrightnessAndContrastOptInStatus = null;
  @SerializedName("image_expansion_opt_in_status")
  private String mImageExpansionOptInStatus = null;
  @SerializedName("image_templates_text_extraction_opt_in_status")
  private String mImageTemplatesTextExtractionOptInStatus = null;
  @SerializedName("is_ads_ai_consented")
  private Boolean mIsAdsAiConsented = null;
  @SerializedName("is_cbo_default_on")
  private Boolean mIsCboDefaultOn = null;
  @SerializedName("is_se_removal_guidance_dismissed")
  private Boolean mIsSeRemovalGuidanceDismissed = null;
  @SerializedName("last_used_post_format")
  private String mLastUsedPostFormat = null;
  @SerializedName("last_visited_time")
  private String mLastVisitedTime = null;
  @SerializedName("metadata_brand_kit_last_opt_out_timestamp")
  private Long mMetadataBrandKitLastOptOutTimestamp = null;
  @SerializedName("metadata_brand_kit_opt_in_status")
  private String mMetadataBrandKitOptInStatus = null;
  @SerializedName("music_on_reels_opt_in")
  private List<Map<String, String>> mMusicOnReelsOptIn = null;
  @SerializedName("muted_cbo_midflight_education_messages")
  private List<String> mMutedCboMidflightEducationMessages = null;
  @SerializedName("onsite_destination_optimization_opt_in")
  private String mOnsiteDestinationOptimizationOptIn = null;
  @SerializedName("open_tabs")
  private List<String> mOpenTabs = null;
  @SerializedName("pac_relaxation_opt_in_status")
  private String mPacRelaxationOptInStatus = null;
  @SerializedName("placement_group_square_opt_in_status")
  private String mPlacementGroupSquareOptInStatus = null;
  @SerializedName("placement_group_vertical_opt_in_status")
  private String mPlacementGroupVerticalOptInStatus = null;
  @SerializedName("previously_seen_recommendations")
  private List<String> mPreviouslySeenRecommendations = null;
  @SerializedName("product_extensions_opt_in")
  private String mProductExtensionsOptIn = null;
  @SerializedName("reactive_control_settings")
  private List<Object> mReactiveControlSettings = null;
  @SerializedName("replace_media_text_opt_in_status")
  private String mReplaceMediaTextOptInStatus = null;
  @SerializedName("sa_off_conv_loc_seen")
  private String mSaOffConvLocSeen = null;
  @SerializedName("saoff_published_l2_conv_loc_seen")
  private String mSaoffPublishedL2ConvLocSeen = null;
  @SerializedName("saon_migr_l1_seen_status")
  private String mSaonMigrL1SeenStatus = null;
  @SerializedName("selected_ad_account")
  private AdAccount mSelectedAdAccount = null;
  @SerializedName("selected_comparison_timerange")
  private Object mSelectedComparisonTimerange = null;
  @SerializedName("selected_metric_cic")
  private String mSelectedMetricCic = null;
  @SerializedName("selected_metrics_cic")
  private List<String> mSelectedMetricsCic = null;
  @SerializedName("selected_page")
  private Page mSelectedPage = null;
  @SerializedName("selected_page_section")
  private String mSelectedPageSection = null;
  @SerializedName("selected_power_editor_pane")
  private String mSelectedPowerEditorPane = null;
  @SerializedName("selected_stat_range")
  private Object mSelectedStatRange = null;
  @SerializedName("should_export_filter_empty_cols")
  private String mShouldExportFilterEmptyCols = null;
  @SerializedName("should_export_rows_without_unsupported_feature")
  private String mShouldExportRowsWithoutUnsupportedFeature = null;
  @SerializedName("should_not_auto_expand_tree_table")
  private Boolean mShouldNotAutoExpandTreeTable = null;
  @SerializedName("should_not_show_cbo_campaign_toggle_off_confirmation_message")
  private Boolean mShouldNotShowCboCampaignToggleOffConfirmationMessage = null;
  @SerializedName("should_not_show_publish_message_on_editor_close")
  private Boolean mShouldNotShowPublishMessageOnEditorClose = null;
  @SerializedName("show_original_videos_opt_in")
  private String mShowOriginalVideosOptIn = null;
  @SerializedName("show_summary_opt_in_status")
  private String mShowSummaryOptInStatus = null;
  @SerializedName("static_ad_product_extensions_opt_in")
  private String mStaticAdProductExtensionsOptIn = null;
  @SerializedName("sticky_setting_after_default_on")
  private String mStickySettingAfterDefaultOn = null;
  @SerializedName("syd_campaign_trends_metric")
  private String mSydCampaignTrendsMetric = null;
  @SerializedName("text_optimizations_text_extraction_opt_in_status")
  private String mTextOptimizationsTextExtractionOptInStatus = null;
  @SerializedName("text_translation_opt_in_status")
  private String mTextTranslationOptInStatus = null;
  @SerializedName("text_variations_sticky_opt_in_status")
  private String mTextVariationsStickyOptInStatus = null;
  @SerializedName("total_coupon_syd_dismissals")
  private Long mTotalCouponSydDismissals = null;
  @SerializedName("total_coupon_upsell_dismissals")
  private Long mTotalCouponUpsellDismissals = null;
  @SerializedName("url_prefill_removal_timestamp")
  private Long mUrlPrefillRemovalTimestamp = null;
  @SerializedName("use_pe_create_flow")
  private Boolean mUsePeCreateFlow = null;
  @SerializedName("use_stepper_primary_entry")
  private Boolean mUseStepperPrimaryEntry = null;
  @SerializedName("user")
  private User mUser = null;
  @SerializedName("website_media_opt_in_status")
  private String mWebsiteMediaOptInStatus = null;
  @SerializedName("website_reviews_data_opt_in_status")
  private String mWebsiteReviewsDataOptInStatus = null;
  @SerializedName("website_selling_points_data_opt_in_status")
  private String mWebsiteSellingPointsDataOptInStatus = null;
  protected static Gson gson = null;

  AdsUserSettings() {
  }

  public AdsUserSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsUserSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsUserSettings fetch() throws APIException{
    AdsUserSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsUserSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsUserSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsUserSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsUserSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsUserSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsUserSettings>)(
      new APIRequest<AdsUserSettings>(context, "", "/", "GET", AdsUserSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsUserSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsUserSettings.getParser())
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
  public static AdsUserSettings loadJSON(String json, APIContext context, String header) {
    AdsUserSettings adsUserSettings = getGson().fromJson(json, AdsUserSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsUserSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsUserSettings.context = context;
    adsUserSettings.rawValue = json;
    adsUserSettings.header = header;
    return adsUserSettings;
  }

  public static APINodeList<AdsUserSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsUserSettings> adsUserSettingss = new APINodeList<AdsUserSettings>(request, json, header);
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
          adsUserSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsUserSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsUserSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsUserSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsUserSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsUserSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsUserSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsUserSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsUserSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsUserSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsUserSettingss;
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
              adsUserSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsUserSettingss;
          }

          // Sixth, check if it's pure JsonObject
          adsUserSettingss.clear();
          adsUserSettingss.add(loadJSON(json, context, header));
          return adsUserSettingss;
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


  public Boolean getFieldAPlusCSurveySeen() {
    return mAPlusCSurveySeen;
  }

  public String getFieldAddOverlaysOptInStatus() {
    return mAddOverlaysOptInStatus;
  }

  public Object getFieldAdgroupNameTemplate() {
    return mAdgroupNameTemplate;
  }

  public List<Map<String, Long>> getFieldAdsCsCatalogOptOutTimestamp() {
    return mAdsCsCatalogOptOutTimestamp;
  }

  public String getFieldAdsCsDynamicSeOptInStatus() {
    return mAdsCsDynamicSeOptInStatus;
  }

  public List<Map<String, Long>> getFieldAdsCsDynamicSeOptOutTimestamp() {
    return mAdsCsDynamicSeOptOutTimestamp;
  }

  public String getFieldAdsCsSitelinksOptInStatus() {
    return mAdsCsSitelinksOptInStatus;
  }

  public List<Map<String, Long>> getFieldAdsCsSitelinksOptOutTimestamp() {
    return mAdsCsSitelinksOptOutTimestamp;
  }

  public List<Map<String, Long>> getFieldAdsDestinationOptimizationOptOutTimestamp() {
    return mAdsDestinationOptimizationOptOutTimestamp;
  }

  public List<Object> getFieldAdsToolVisits() {
    return mAdsToolVisits;
  }

  public String getFieldApluscAiAgentOptInStatus() {
    return mApluscAiAgentOptInStatus;
  }

  public String getFieldApluscCarouselCdaOptInStatus() {
    return mApluscCarouselCdaOptInStatus;
  }

  public String getFieldApluscCarouselInlineCommentOptInStatus() {
    return mApluscCarouselInlineCommentOptInStatus;
  }

  public String getFieldApluscDaOptInStatus() {
    return mApluscDaOptInStatus;
  }

  public String getFieldApluscEnhanceCtaOptInStatus() {
    return mApluscEnhanceCtaOptInStatus;
  }

  public String getFieldApluscEpaOptInStatus() {
    return mApluscEpaOptInStatus;
  }

  public String getFieldApluscLocalStoreExtensionOptInStatus() {
    return mApluscLocalStoreExtensionOptInStatus;
  }

  public List<String> getFieldApluscOptOutFriction() {
    return mApluscOptOutFriction;
  }

  public String getFieldApluscVideofilterOptInStatus() {
    return mApluscVideofilterOptInStatus;
  }

  public String getFieldApluscVideouncropOptInStatus() {
    return mApluscVideouncropOptInStatus;
  }

  public String getFieldAutoflowLiteOptInStatus() {
    return mAutoflowLiteOptInStatus;
  }

  public Boolean getFieldAutoflowLiteShouldOptIn() {
    return mAutoflowLiteShouldOptIn;
  }

  public String getFieldBlendedAdsCreationDefaultingOptInStatus() {
    return mBlendedAdsCreationDefaultingOptInStatus;
  }

  public List<Long> getFieldBlendedAdsCreationDefaultingOptOutCampaignGroupIds() {
    return mBlendedAdsCreationDefaultingOptOutCampaignGroupIds;
  }

  public List<Page> getFieldBookmarkedPages() {
    return mBookmarkedPages;
  }

  public Object getFieldCampaignGroupNameTemplate() {
    return mCampaignGroupNameTemplate;
  }

  public Object getFieldCampaignNameTemplate() {
    return mCampaignNameTemplate;
  }

  public String getFieldCarouselToVideoOptInStatus() {
    return mCarouselToVideoOptInStatus;
  }

  public String getFieldConnectedSourcesCatalogOptInStatus() {
    return mConnectedSourcesCatalogOptInStatus;
  }

  public String getFieldCreateCtaStickerOptInStatus() {
    return mCreateCtaStickerOptInStatus;
  }

  public String getFieldCreativeFlexOptInStatus() {
    return mCreativeFlexOptInStatus;
  }

  public String getFieldDaAddOverlaysOptInStatus() {
    return mDaAddOverlaysOptInStatus;
  }

  public String getFieldDaCreativeFlexOptInStatus() {
    return mDaCreativeFlexOptInStatus;
  }

  public String getFieldDaHidePriceOptInStatus() {
    return mDaHidePriceOptInStatus;
  }

  public Long getFieldDaManualMediaNuxImpressions() {
    return mDaManualMediaNuxImpressions;
  }

  public String getFieldDefaultCreationMode() {
    return mDefaultCreationMode;
  }

  public String getFieldDynamicPartnershipAdsOptInStatus() {
    return mDynamicPartnershipAdsOptInStatus;
  }

  public String getFieldEnhanceCtaTextExtractionOptInStatus() {
    return mEnhanceCtaTextExtractionOptInStatus;
  }

  public String getFieldExportFormatDefault() {
    return mExportFormatDefault;
  }

  public String getFieldFocusModeDefault() {
    return mFocusModeDefault;
  }

  public Long getFieldGenAiAlphaTestStatus() {
    return mGenAiAlphaTestStatus;
  }

  public String getFieldGenAiAutoSelectOptInStatus() {
    return mGenAiAutoSelectOptInStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImageBackgroundGenerationOptInStatus() {
    return mImageBackgroundGenerationOptInStatus;
  }

  public String getFieldImageBrightnessAndContrastOptInStatus() {
    return mImageBrightnessAndContrastOptInStatus;
  }

  public String getFieldImageExpansionOptInStatus() {
    return mImageExpansionOptInStatus;
  }

  public String getFieldImageTemplatesTextExtractionOptInStatus() {
    return mImageTemplatesTextExtractionOptInStatus;
  }

  public Boolean getFieldIsAdsAiConsented() {
    return mIsAdsAiConsented;
  }

  public Boolean getFieldIsCboDefaultOn() {
    return mIsCboDefaultOn;
  }

  public Boolean getFieldIsSeRemovalGuidanceDismissed() {
    return mIsSeRemovalGuidanceDismissed;
  }

  public String getFieldLastUsedPostFormat() {
    return mLastUsedPostFormat;
  }

  public String getFieldLastVisitedTime() {
    return mLastVisitedTime;
  }

  public Long getFieldMetadataBrandKitLastOptOutTimestamp() {
    return mMetadataBrandKitLastOptOutTimestamp;
  }

  public String getFieldMetadataBrandKitOptInStatus() {
    return mMetadataBrandKitOptInStatus;
  }

  public List<Map<String, String>> getFieldMusicOnReelsOptIn() {
    return mMusicOnReelsOptIn;
  }

  public List<String> getFieldMutedCboMidflightEducationMessages() {
    return mMutedCboMidflightEducationMessages;
  }

  public String getFieldOnsiteDestinationOptimizationOptIn() {
    return mOnsiteDestinationOptimizationOptIn;
  }

  public List<String> getFieldOpenTabs() {
    return mOpenTabs;
  }

  public String getFieldPacRelaxationOptInStatus() {
    return mPacRelaxationOptInStatus;
  }

  public String getFieldPlacementGroupSquareOptInStatus() {
    return mPlacementGroupSquareOptInStatus;
  }

  public String getFieldPlacementGroupVerticalOptInStatus() {
    return mPlacementGroupVerticalOptInStatus;
  }

  public List<String> getFieldPreviouslySeenRecommendations() {
    return mPreviouslySeenRecommendations;
  }

  public String getFieldProductExtensionsOptIn() {
    return mProductExtensionsOptIn;
  }

  public List<Object> getFieldReactiveControlSettings() {
    return mReactiveControlSettings;
  }

  public String getFieldReplaceMediaTextOptInStatus() {
    return mReplaceMediaTextOptInStatus;
  }

  public String getFieldSaOffConvLocSeen() {
    return mSaOffConvLocSeen;
  }

  public String getFieldSaoffPublishedL2ConvLocSeen() {
    return mSaoffPublishedL2ConvLocSeen;
  }

  public String getFieldSaonMigrL1SeenStatus() {
    return mSaonMigrL1SeenStatus;
  }

  public AdAccount getFieldSelectedAdAccount() {
    if (mSelectedAdAccount != null) {
      mSelectedAdAccount.context = getContext();
    }
    return mSelectedAdAccount;
  }

  public Object getFieldSelectedComparisonTimerange() {
    return mSelectedComparisonTimerange;
  }

  public String getFieldSelectedMetricCic() {
    return mSelectedMetricCic;
  }

  public List<String> getFieldSelectedMetricsCic() {
    return mSelectedMetricsCic;
  }

  public Page getFieldSelectedPage() {
    if (mSelectedPage != null) {
      mSelectedPage.context = getContext();
    }
    return mSelectedPage;
  }

  public String getFieldSelectedPageSection() {
    return mSelectedPageSection;
  }

  public String getFieldSelectedPowerEditorPane() {
    return mSelectedPowerEditorPane;
  }

  public Object getFieldSelectedStatRange() {
    return mSelectedStatRange;
  }

  public String getFieldShouldExportFilterEmptyCols() {
    return mShouldExportFilterEmptyCols;
  }

  public String getFieldShouldExportRowsWithoutUnsupportedFeature() {
    return mShouldExportRowsWithoutUnsupportedFeature;
  }

  public Boolean getFieldShouldNotAutoExpandTreeTable() {
    return mShouldNotAutoExpandTreeTable;
  }

  public Boolean getFieldShouldNotShowCboCampaignToggleOffConfirmationMessage() {
    return mShouldNotShowCboCampaignToggleOffConfirmationMessage;
  }

  public Boolean getFieldShouldNotShowPublishMessageOnEditorClose() {
    return mShouldNotShowPublishMessageOnEditorClose;
  }

  public String getFieldShowOriginalVideosOptIn() {
    return mShowOriginalVideosOptIn;
  }

  public String getFieldShowSummaryOptInStatus() {
    return mShowSummaryOptInStatus;
  }

  public String getFieldStaticAdProductExtensionsOptIn() {
    return mStaticAdProductExtensionsOptIn;
  }

  public String getFieldStickySettingAfterDefaultOn() {
    return mStickySettingAfterDefaultOn;
  }

  public String getFieldSydCampaignTrendsMetric() {
    return mSydCampaignTrendsMetric;
  }

  public String getFieldTextOptimizationsTextExtractionOptInStatus() {
    return mTextOptimizationsTextExtractionOptInStatus;
  }

  public String getFieldTextTranslationOptInStatus() {
    return mTextTranslationOptInStatus;
  }

  public String getFieldTextVariationsStickyOptInStatus() {
    return mTextVariationsStickyOptInStatus;
  }

  public Long getFieldTotalCouponSydDismissals() {
    return mTotalCouponSydDismissals;
  }

  public Long getFieldTotalCouponUpsellDismissals() {
    return mTotalCouponUpsellDismissals;
  }

  public Long getFieldUrlPrefillRemovalTimestamp() {
    return mUrlPrefillRemovalTimestamp;
  }

  public Boolean getFieldUsePeCreateFlow() {
    return mUsePeCreateFlow;
  }

  public Boolean getFieldUseStepperPrimaryEntry() {
    return mUseStepperPrimaryEntry;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public String getFieldWebsiteMediaOptInStatus() {
    return mWebsiteMediaOptInStatus;
  }

  public String getFieldWebsiteReviewsDataOptInStatus() {
    return mWebsiteReviewsDataOptInStatus;
  }

  public String getFieldWebsiteSellingPointsDataOptInStatus() {
    return mWebsiteSellingPointsDataOptInStatus;
  }



  public static class APIRequestGet extends APIRequest<AdsUserSettings> {

    AdsUserSettings lastResponse = null;
    @Override
    public AdsUserSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "a_plus_c_survey_seen",
      "add_overlays_opt_in_status",
      "adgroup_name_template",
      "ads_cs_catalog_opt_out_timestamp",
      "ads_cs_dynamic_se_opt_in_status",
      "ads_cs_dynamic_se_opt_out_timestamp",
      "ads_cs_sitelinks_opt_in_status",
      "ads_cs_sitelinks_opt_out_timestamp",
      "ads_destination_optimization_opt_out_timestamp",
      "ads_tool_visits",
      "aplusc_ai_agent_opt_in_status",
      "aplusc_carousel_cda_opt_in_status",
      "aplusc_carousel_inline_comment_opt_in_status",
      "aplusc_da_opt_in_status",
      "aplusc_enhance_cta_opt_in_status",
      "aplusc_epa_opt_in_status",
      "aplusc_local_store_extension_opt_in_status",
      "aplusc_opt_out_friction",
      "aplusc_videofilter_opt_in_status",
      "aplusc_videouncrop_opt_in_status",
      "autoflow_lite_opt_in_status",
      "autoflow_lite_should_opt_in",
      "blended_ads_creation_defaulting_opt_in_status",
      "blended_ads_creation_defaulting_opt_out_campaign_group_ids",
      "bookmarked_pages",
      "campaign_group_name_template",
      "campaign_name_template",
      "carousel_to_video_opt_in_status",
      "connected_sources_catalog_opt_in_status",
      "create_cta_sticker_opt_in_status",
      "creative_flex_opt_in_status",
      "da_add_overlays_opt_in_status",
      "da_creative_flex_opt_in_status",
      "da_hide_price_opt_in_status",
      "da_manual_media_nux_impressions",
      "default_creation_mode",
      "dynamic_partnership_ads_opt_in_status",
      "enhance_cta_text_extraction_opt_in_status",
      "export_format_default",
      "focus_mode_default",
      "gen_ai_alpha_test_status",
      "gen_ai_auto_select_opt_in_status",
      "id",
      "image_background_generation_opt_in_status",
      "image_brightness_and_contrast_opt_in_status",
      "image_expansion_opt_in_status",
      "image_templates_text_extraction_opt_in_status",
      "is_ads_ai_consented",
      "is_cbo_default_on",
      "is_se_removal_guidance_dismissed",
      "last_used_post_format",
      "last_visited_time",
      "metadata_brand_kit_last_opt_out_timestamp",
      "metadata_brand_kit_opt_in_status",
      "music_on_reels_opt_in",
      "muted_cbo_midflight_education_messages",
      "onsite_destination_optimization_opt_in",
      "open_tabs",
      "pac_relaxation_opt_in_status",
      "placement_group_square_opt_in_status",
      "placement_group_vertical_opt_in_status",
      "previously_seen_recommendations",
      "product_extensions_opt_in",
      "reactive_control_settings",
      "replace_media_text_opt_in_status",
      "sa_off_conv_loc_seen",
      "saoff_published_l2_conv_loc_seen",
      "saon_migr_l1_seen_status",
      "selected_ad_account",
      "selected_comparison_timerange",
      "selected_metric_cic",
      "selected_metrics_cic",
      "selected_page",
      "selected_page_section",
      "selected_power_editor_pane",
      "selected_stat_range",
      "should_export_filter_empty_cols",
      "should_export_rows_without_unsupported_feature",
      "should_not_auto_expand_tree_table",
      "should_not_show_cbo_campaign_toggle_off_confirmation_message",
      "should_not_show_publish_message_on_editor_close",
      "show_original_videos_opt_in",
      "show_summary_opt_in_status",
      "static_ad_product_extensions_opt_in",
      "sticky_setting_after_default_on",
      "syd_campaign_trends_metric",
      "text_optimizations_text_extraction_opt_in_status",
      "text_translation_opt_in_status",
      "text_variations_sticky_opt_in_status",
      "total_coupon_syd_dismissals",
      "total_coupon_upsell_dismissals",
      "url_prefill_removal_timestamp",
      "use_pe_create_flow",
      "use_stepper_primary_entry",
      "user",
      "website_media_opt_in_status",
      "website_reviews_data_opt_in_status",
      "website_selling_points_data_opt_in_status",
    };

    @Override
    public AdsUserSettings parseResponse(String response, String header) throws APIException {
      return AdsUserSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsUserSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsUserSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsUserSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsUserSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsUserSettings>() {
           public AdsUserSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestAPlusCSurveySeenField () {
      return this.requestAPlusCSurveySeenField(true);
    }
    public APIRequestGet requestAPlusCSurveySeenField (boolean value) {
      this.requestField("a_plus_c_survey_seen", value);
      return this;
    }
    public APIRequestGet requestAddOverlaysOptInStatusField () {
      return this.requestAddOverlaysOptInStatusField(true);
    }
    public APIRequestGet requestAddOverlaysOptInStatusField (boolean value) {
      this.requestField("add_overlays_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestAdgroupNameTemplateField () {
      return this.requestAdgroupNameTemplateField(true);
    }
    public APIRequestGet requestAdgroupNameTemplateField (boolean value) {
      this.requestField("adgroup_name_template", value);
      return this;
    }
    public APIRequestGet requestAdsCsCatalogOptOutTimestampField () {
      return this.requestAdsCsCatalogOptOutTimestampField(true);
    }
    public APIRequestGet requestAdsCsCatalogOptOutTimestampField (boolean value) {
      this.requestField("ads_cs_catalog_opt_out_timestamp", value);
      return this;
    }
    public APIRequestGet requestAdsCsDynamicSeOptInStatusField () {
      return this.requestAdsCsDynamicSeOptInStatusField(true);
    }
    public APIRequestGet requestAdsCsDynamicSeOptInStatusField (boolean value) {
      this.requestField("ads_cs_dynamic_se_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestAdsCsDynamicSeOptOutTimestampField () {
      return this.requestAdsCsDynamicSeOptOutTimestampField(true);
    }
    public APIRequestGet requestAdsCsDynamicSeOptOutTimestampField (boolean value) {
      this.requestField("ads_cs_dynamic_se_opt_out_timestamp", value);
      return this;
    }
    public APIRequestGet requestAdsCsSitelinksOptInStatusField () {
      return this.requestAdsCsSitelinksOptInStatusField(true);
    }
    public APIRequestGet requestAdsCsSitelinksOptInStatusField (boolean value) {
      this.requestField("ads_cs_sitelinks_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestAdsCsSitelinksOptOutTimestampField () {
      return this.requestAdsCsSitelinksOptOutTimestampField(true);
    }
    public APIRequestGet requestAdsCsSitelinksOptOutTimestampField (boolean value) {
      this.requestField("ads_cs_sitelinks_opt_out_timestamp", value);
      return this;
    }
    public APIRequestGet requestAdsDestinationOptimizationOptOutTimestampField () {
      return this.requestAdsDestinationOptimizationOptOutTimestampField(true);
    }
    public APIRequestGet requestAdsDestinationOptimizationOptOutTimestampField (boolean value) {
      this.requestField("ads_destination_optimization_opt_out_timestamp", value);
      return this;
    }
    public APIRequestGet requestAdsToolVisitsField () {
      return this.requestAdsToolVisitsField(true);
    }
    public APIRequestGet requestAdsToolVisitsField (boolean value) {
      this.requestField("ads_tool_visits", value);
      return this;
    }
    public APIRequestGet requestApluscAiAgentOptInStatusField () {
      return this.requestApluscAiAgentOptInStatusField(true);
    }
    public APIRequestGet requestApluscAiAgentOptInStatusField (boolean value) {
      this.requestField("aplusc_ai_agent_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscCarouselCdaOptInStatusField () {
      return this.requestApluscCarouselCdaOptInStatusField(true);
    }
    public APIRequestGet requestApluscCarouselCdaOptInStatusField (boolean value) {
      this.requestField("aplusc_carousel_cda_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscCarouselInlineCommentOptInStatusField () {
      return this.requestApluscCarouselInlineCommentOptInStatusField(true);
    }
    public APIRequestGet requestApluscCarouselInlineCommentOptInStatusField (boolean value) {
      this.requestField("aplusc_carousel_inline_comment_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscDaOptInStatusField () {
      return this.requestApluscDaOptInStatusField(true);
    }
    public APIRequestGet requestApluscDaOptInStatusField (boolean value) {
      this.requestField("aplusc_da_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscEnhanceCtaOptInStatusField () {
      return this.requestApluscEnhanceCtaOptInStatusField(true);
    }
    public APIRequestGet requestApluscEnhanceCtaOptInStatusField (boolean value) {
      this.requestField("aplusc_enhance_cta_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscEpaOptInStatusField () {
      return this.requestApluscEpaOptInStatusField(true);
    }
    public APIRequestGet requestApluscEpaOptInStatusField (boolean value) {
      this.requestField("aplusc_epa_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscLocalStoreExtensionOptInStatusField () {
      return this.requestApluscLocalStoreExtensionOptInStatusField(true);
    }
    public APIRequestGet requestApluscLocalStoreExtensionOptInStatusField (boolean value) {
      this.requestField("aplusc_local_store_extension_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscOptOutFrictionField () {
      return this.requestApluscOptOutFrictionField(true);
    }
    public APIRequestGet requestApluscOptOutFrictionField (boolean value) {
      this.requestField("aplusc_opt_out_friction", value);
      return this;
    }
    public APIRequestGet requestApluscVideofilterOptInStatusField () {
      return this.requestApluscVideofilterOptInStatusField(true);
    }
    public APIRequestGet requestApluscVideofilterOptInStatusField (boolean value) {
      this.requestField("aplusc_videofilter_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestApluscVideouncropOptInStatusField () {
      return this.requestApluscVideouncropOptInStatusField(true);
    }
    public APIRequestGet requestApluscVideouncropOptInStatusField (boolean value) {
      this.requestField("aplusc_videouncrop_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestAutoflowLiteOptInStatusField () {
      return this.requestAutoflowLiteOptInStatusField(true);
    }
    public APIRequestGet requestAutoflowLiteOptInStatusField (boolean value) {
      this.requestField("autoflow_lite_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestAutoflowLiteShouldOptInField () {
      return this.requestAutoflowLiteShouldOptInField(true);
    }
    public APIRequestGet requestAutoflowLiteShouldOptInField (boolean value) {
      this.requestField("autoflow_lite_should_opt_in", value);
      return this;
    }
    public APIRequestGet requestBlendedAdsCreationDefaultingOptInStatusField () {
      return this.requestBlendedAdsCreationDefaultingOptInStatusField(true);
    }
    public APIRequestGet requestBlendedAdsCreationDefaultingOptInStatusField (boolean value) {
      this.requestField("blended_ads_creation_defaulting_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestBlendedAdsCreationDefaultingOptOutCampaignGroupIdsField () {
      return this.requestBlendedAdsCreationDefaultingOptOutCampaignGroupIdsField(true);
    }
    public APIRequestGet requestBlendedAdsCreationDefaultingOptOutCampaignGroupIdsField (boolean value) {
      this.requestField("blended_ads_creation_defaulting_opt_out_campaign_group_ids", value);
      return this;
    }
    public APIRequestGet requestBookmarkedPagesField () {
      return this.requestBookmarkedPagesField(true);
    }
    public APIRequestGet requestBookmarkedPagesField (boolean value) {
      this.requestField("bookmarked_pages", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupNameTemplateField () {
      return this.requestCampaignGroupNameTemplateField(true);
    }
    public APIRequestGet requestCampaignGroupNameTemplateField (boolean value) {
      this.requestField("campaign_group_name_template", value);
      return this;
    }
    public APIRequestGet requestCampaignNameTemplateField () {
      return this.requestCampaignNameTemplateField(true);
    }
    public APIRequestGet requestCampaignNameTemplateField (boolean value) {
      this.requestField("campaign_name_template", value);
      return this;
    }
    public APIRequestGet requestCarouselToVideoOptInStatusField () {
      return this.requestCarouselToVideoOptInStatusField(true);
    }
    public APIRequestGet requestCarouselToVideoOptInStatusField (boolean value) {
      this.requestField("carousel_to_video_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestConnectedSourcesCatalogOptInStatusField () {
      return this.requestConnectedSourcesCatalogOptInStatusField(true);
    }
    public APIRequestGet requestConnectedSourcesCatalogOptInStatusField (boolean value) {
      this.requestField("connected_sources_catalog_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestCreateCtaStickerOptInStatusField () {
      return this.requestCreateCtaStickerOptInStatusField(true);
    }
    public APIRequestGet requestCreateCtaStickerOptInStatusField (boolean value) {
      this.requestField("create_cta_sticker_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestCreativeFlexOptInStatusField () {
      return this.requestCreativeFlexOptInStatusField(true);
    }
    public APIRequestGet requestCreativeFlexOptInStatusField (boolean value) {
      this.requestField("creative_flex_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestDaAddOverlaysOptInStatusField () {
      return this.requestDaAddOverlaysOptInStatusField(true);
    }
    public APIRequestGet requestDaAddOverlaysOptInStatusField (boolean value) {
      this.requestField("da_add_overlays_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestDaCreativeFlexOptInStatusField () {
      return this.requestDaCreativeFlexOptInStatusField(true);
    }
    public APIRequestGet requestDaCreativeFlexOptInStatusField (boolean value) {
      this.requestField("da_creative_flex_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestDaHidePriceOptInStatusField () {
      return this.requestDaHidePriceOptInStatusField(true);
    }
    public APIRequestGet requestDaHidePriceOptInStatusField (boolean value) {
      this.requestField("da_hide_price_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestDaManualMediaNuxImpressionsField () {
      return this.requestDaManualMediaNuxImpressionsField(true);
    }
    public APIRequestGet requestDaManualMediaNuxImpressionsField (boolean value) {
      this.requestField("da_manual_media_nux_impressions", value);
      return this;
    }
    public APIRequestGet requestDefaultCreationModeField () {
      return this.requestDefaultCreationModeField(true);
    }
    public APIRequestGet requestDefaultCreationModeField (boolean value) {
      this.requestField("default_creation_mode", value);
      return this;
    }
    public APIRequestGet requestDynamicPartnershipAdsOptInStatusField () {
      return this.requestDynamicPartnershipAdsOptInStatusField(true);
    }
    public APIRequestGet requestDynamicPartnershipAdsOptInStatusField (boolean value) {
      this.requestField("dynamic_partnership_ads_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestEnhanceCtaTextExtractionOptInStatusField () {
      return this.requestEnhanceCtaTextExtractionOptInStatusField(true);
    }
    public APIRequestGet requestEnhanceCtaTextExtractionOptInStatusField (boolean value) {
      this.requestField("enhance_cta_text_extraction_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestExportFormatDefaultField () {
      return this.requestExportFormatDefaultField(true);
    }
    public APIRequestGet requestExportFormatDefaultField (boolean value) {
      this.requestField("export_format_default", value);
      return this;
    }
    public APIRequestGet requestFocusModeDefaultField () {
      return this.requestFocusModeDefaultField(true);
    }
    public APIRequestGet requestFocusModeDefaultField (boolean value) {
      this.requestField("focus_mode_default", value);
      return this;
    }
    public APIRequestGet requestGenAiAlphaTestStatusField () {
      return this.requestGenAiAlphaTestStatusField(true);
    }
    public APIRequestGet requestGenAiAlphaTestStatusField (boolean value) {
      this.requestField("gen_ai_alpha_test_status", value);
      return this;
    }
    public APIRequestGet requestGenAiAutoSelectOptInStatusField () {
      return this.requestGenAiAutoSelectOptInStatusField(true);
    }
    public APIRequestGet requestGenAiAutoSelectOptInStatusField (boolean value) {
      this.requestField("gen_ai_auto_select_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageBackgroundGenerationOptInStatusField () {
      return this.requestImageBackgroundGenerationOptInStatusField(true);
    }
    public APIRequestGet requestImageBackgroundGenerationOptInStatusField (boolean value) {
      this.requestField("image_background_generation_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestImageBrightnessAndContrastOptInStatusField () {
      return this.requestImageBrightnessAndContrastOptInStatusField(true);
    }
    public APIRequestGet requestImageBrightnessAndContrastOptInStatusField (boolean value) {
      this.requestField("image_brightness_and_contrast_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestImageExpansionOptInStatusField () {
      return this.requestImageExpansionOptInStatusField(true);
    }
    public APIRequestGet requestImageExpansionOptInStatusField (boolean value) {
      this.requestField("image_expansion_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestImageTemplatesTextExtractionOptInStatusField () {
      return this.requestImageTemplatesTextExtractionOptInStatusField(true);
    }
    public APIRequestGet requestImageTemplatesTextExtractionOptInStatusField (boolean value) {
      this.requestField("image_templates_text_extraction_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestIsAdsAiConsentedField () {
      return this.requestIsAdsAiConsentedField(true);
    }
    public APIRequestGet requestIsAdsAiConsentedField (boolean value) {
      this.requestField("is_ads_ai_consented", value);
      return this;
    }
    public APIRequestGet requestIsCboDefaultOnField () {
      return this.requestIsCboDefaultOnField(true);
    }
    public APIRequestGet requestIsCboDefaultOnField (boolean value) {
      this.requestField("is_cbo_default_on", value);
      return this;
    }
    public APIRequestGet requestIsSeRemovalGuidanceDismissedField () {
      return this.requestIsSeRemovalGuidanceDismissedField(true);
    }
    public APIRequestGet requestIsSeRemovalGuidanceDismissedField (boolean value) {
      this.requestField("is_se_removal_guidance_dismissed", value);
      return this;
    }
    public APIRequestGet requestLastUsedPostFormatField () {
      return this.requestLastUsedPostFormatField(true);
    }
    public APIRequestGet requestLastUsedPostFormatField (boolean value) {
      this.requestField("last_used_post_format", value);
      return this;
    }
    public APIRequestGet requestLastVisitedTimeField () {
      return this.requestLastVisitedTimeField(true);
    }
    public APIRequestGet requestLastVisitedTimeField (boolean value) {
      this.requestField("last_visited_time", value);
      return this;
    }
    public APIRequestGet requestMetadataBrandKitLastOptOutTimestampField () {
      return this.requestMetadataBrandKitLastOptOutTimestampField(true);
    }
    public APIRequestGet requestMetadataBrandKitLastOptOutTimestampField (boolean value) {
      this.requestField("metadata_brand_kit_last_opt_out_timestamp", value);
      return this;
    }
    public APIRequestGet requestMetadataBrandKitOptInStatusField () {
      return this.requestMetadataBrandKitOptInStatusField(true);
    }
    public APIRequestGet requestMetadataBrandKitOptInStatusField (boolean value) {
      this.requestField("metadata_brand_kit_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestMusicOnReelsOptInField () {
      return this.requestMusicOnReelsOptInField(true);
    }
    public APIRequestGet requestMusicOnReelsOptInField (boolean value) {
      this.requestField("music_on_reels_opt_in", value);
      return this;
    }
    public APIRequestGet requestMutedCboMidflightEducationMessagesField () {
      return this.requestMutedCboMidflightEducationMessagesField(true);
    }
    public APIRequestGet requestMutedCboMidflightEducationMessagesField (boolean value) {
      this.requestField("muted_cbo_midflight_education_messages", value);
      return this;
    }
    public APIRequestGet requestOnsiteDestinationOptimizationOptInField () {
      return this.requestOnsiteDestinationOptimizationOptInField(true);
    }
    public APIRequestGet requestOnsiteDestinationOptimizationOptInField (boolean value) {
      this.requestField("onsite_destination_optimization_opt_in", value);
      return this;
    }
    public APIRequestGet requestOpenTabsField () {
      return this.requestOpenTabsField(true);
    }
    public APIRequestGet requestOpenTabsField (boolean value) {
      this.requestField("open_tabs", value);
      return this;
    }
    public APIRequestGet requestPacRelaxationOptInStatusField () {
      return this.requestPacRelaxationOptInStatusField(true);
    }
    public APIRequestGet requestPacRelaxationOptInStatusField (boolean value) {
      this.requestField("pac_relaxation_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestPlacementGroupSquareOptInStatusField () {
      return this.requestPlacementGroupSquareOptInStatusField(true);
    }
    public APIRequestGet requestPlacementGroupSquareOptInStatusField (boolean value) {
      this.requestField("placement_group_square_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestPlacementGroupVerticalOptInStatusField () {
      return this.requestPlacementGroupVerticalOptInStatusField(true);
    }
    public APIRequestGet requestPlacementGroupVerticalOptInStatusField (boolean value) {
      this.requestField("placement_group_vertical_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestPreviouslySeenRecommendationsField () {
      return this.requestPreviouslySeenRecommendationsField(true);
    }
    public APIRequestGet requestPreviouslySeenRecommendationsField (boolean value) {
      this.requestField("previously_seen_recommendations", value);
      return this;
    }
    public APIRequestGet requestProductExtensionsOptInField () {
      return this.requestProductExtensionsOptInField(true);
    }
    public APIRequestGet requestProductExtensionsOptInField (boolean value) {
      this.requestField("product_extensions_opt_in", value);
      return this;
    }
    public APIRequestGet requestReactiveControlSettingsField () {
      return this.requestReactiveControlSettingsField(true);
    }
    public APIRequestGet requestReactiveControlSettingsField (boolean value) {
      this.requestField("reactive_control_settings", value);
      return this;
    }
    public APIRequestGet requestReplaceMediaTextOptInStatusField () {
      return this.requestReplaceMediaTextOptInStatusField(true);
    }
    public APIRequestGet requestReplaceMediaTextOptInStatusField (boolean value) {
      this.requestField("replace_media_text_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestSaOffConvLocSeenField () {
      return this.requestSaOffConvLocSeenField(true);
    }
    public APIRequestGet requestSaOffConvLocSeenField (boolean value) {
      this.requestField("sa_off_conv_loc_seen", value);
      return this;
    }
    public APIRequestGet requestSaoffPublishedL2ConvLocSeenField () {
      return this.requestSaoffPublishedL2ConvLocSeenField(true);
    }
    public APIRequestGet requestSaoffPublishedL2ConvLocSeenField (boolean value) {
      this.requestField("saoff_published_l2_conv_loc_seen", value);
      return this;
    }
    public APIRequestGet requestSaonMigrL1SeenStatusField () {
      return this.requestSaonMigrL1SeenStatusField(true);
    }
    public APIRequestGet requestSaonMigrL1SeenStatusField (boolean value) {
      this.requestField("saon_migr_l1_seen_status", value);
      return this;
    }
    public APIRequestGet requestSelectedAdAccountField () {
      return this.requestSelectedAdAccountField(true);
    }
    public APIRequestGet requestSelectedAdAccountField (boolean value) {
      this.requestField("selected_ad_account", value);
      return this;
    }
    public APIRequestGet requestSelectedComparisonTimerangeField () {
      return this.requestSelectedComparisonTimerangeField(true);
    }
    public APIRequestGet requestSelectedComparisonTimerangeField (boolean value) {
      this.requestField("selected_comparison_timerange", value);
      return this;
    }
    public APIRequestGet requestSelectedMetricCicField () {
      return this.requestSelectedMetricCicField(true);
    }
    public APIRequestGet requestSelectedMetricCicField (boolean value) {
      this.requestField("selected_metric_cic", value);
      return this;
    }
    public APIRequestGet requestSelectedMetricsCicField () {
      return this.requestSelectedMetricsCicField(true);
    }
    public APIRequestGet requestSelectedMetricsCicField (boolean value) {
      this.requestField("selected_metrics_cic", value);
      return this;
    }
    public APIRequestGet requestSelectedPageField () {
      return this.requestSelectedPageField(true);
    }
    public APIRequestGet requestSelectedPageField (boolean value) {
      this.requestField("selected_page", value);
      return this;
    }
    public APIRequestGet requestSelectedPageSectionField () {
      return this.requestSelectedPageSectionField(true);
    }
    public APIRequestGet requestSelectedPageSectionField (boolean value) {
      this.requestField("selected_page_section", value);
      return this;
    }
    public APIRequestGet requestSelectedPowerEditorPaneField () {
      return this.requestSelectedPowerEditorPaneField(true);
    }
    public APIRequestGet requestSelectedPowerEditorPaneField (boolean value) {
      this.requestField("selected_power_editor_pane", value);
      return this;
    }
    public APIRequestGet requestSelectedStatRangeField () {
      return this.requestSelectedStatRangeField(true);
    }
    public APIRequestGet requestSelectedStatRangeField (boolean value) {
      this.requestField("selected_stat_range", value);
      return this;
    }
    public APIRequestGet requestShouldExportFilterEmptyColsField () {
      return this.requestShouldExportFilterEmptyColsField(true);
    }
    public APIRequestGet requestShouldExportFilterEmptyColsField (boolean value) {
      this.requestField("should_export_filter_empty_cols", value);
      return this;
    }
    public APIRequestGet requestShouldExportRowsWithoutUnsupportedFeatureField () {
      return this.requestShouldExportRowsWithoutUnsupportedFeatureField(true);
    }
    public APIRequestGet requestShouldExportRowsWithoutUnsupportedFeatureField (boolean value) {
      this.requestField("should_export_rows_without_unsupported_feature", value);
      return this;
    }
    public APIRequestGet requestShouldNotAutoExpandTreeTableField () {
      return this.requestShouldNotAutoExpandTreeTableField(true);
    }
    public APIRequestGet requestShouldNotAutoExpandTreeTableField (boolean value) {
      this.requestField("should_not_auto_expand_tree_table", value);
      return this;
    }
    public APIRequestGet requestShouldNotShowCboCampaignToggleOffConfirmationMessageField () {
      return this.requestShouldNotShowCboCampaignToggleOffConfirmationMessageField(true);
    }
    public APIRequestGet requestShouldNotShowCboCampaignToggleOffConfirmationMessageField (boolean value) {
      this.requestField("should_not_show_cbo_campaign_toggle_off_confirmation_message", value);
      return this;
    }
    public APIRequestGet requestShouldNotShowPublishMessageOnEditorCloseField () {
      return this.requestShouldNotShowPublishMessageOnEditorCloseField(true);
    }
    public APIRequestGet requestShouldNotShowPublishMessageOnEditorCloseField (boolean value) {
      this.requestField("should_not_show_publish_message_on_editor_close", value);
      return this;
    }
    public APIRequestGet requestShowOriginalVideosOptInField () {
      return this.requestShowOriginalVideosOptInField(true);
    }
    public APIRequestGet requestShowOriginalVideosOptInField (boolean value) {
      this.requestField("show_original_videos_opt_in", value);
      return this;
    }
    public APIRequestGet requestShowSummaryOptInStatusField () {
      return this.requestShowSummaryOptInStatusField(true);
    }
    public APIRequestGet requestShowSummaryOptInStatusField (boolean value) {
      this.requestField("show_summary_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestStaticAdProductExtensionsOptInField () {
      return this.requestStaticAdProductExtensionsOptInField(true);
    }
    public APIRequestGet requestStaticAdProductExtensionsOptInField (boolean value) {
      this.requestField("static_ad_product_extensions_opt_in", value);
      return this;
    }
    public APIRequestGet requestStickySettingAfterDefaultOnField () {
      return this.requestStickySettingAfterDefaultOnField(true);
    }
    public APIRequestGet requestStickySettingAfterDefaultOnField (boolean value) {
      this.requestField("sticky_setting_after_default_on", value);
      return this;
    }
    public APIRequestGet requestSydCampaignTrendsMetricField () {
      return this.requestSydCampaignTrendsMetricField(true);
    }
    public APIRequestGet requestSydCampaignTrendsMetricField (boolean value) {
      this.requestField("syd_campaign_trends_metric", value);
      return this;
    }
    public APIRequestGet requestTextOptimizationsTextExtractionOptInStatusField () {
      return this.requestTextOptimizationsTextExtractionOptInStatusField(true);
    }
    public APIRequestGet requestTextOptimizationsTextExtractionOptInStatusField (boolean value) {
      this.requestField("text_optimizations_text_extraction_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestTextTranslationOptInStatusField () {
      return this.requestTextTranslationOptInStatusField(true);
    }
    public APIRequestGet requestTextTranslationOptInStatusField (boolean value) {
      this.requestField("text_translation_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestTextVariationsStickyOptInStatusField () {
      return this.requestTextVariationsStickyOptInStatusField(true);
    }
    public APIRequestGet requestTextVariationsStickyOptInStatusField (boolean value) {
      this.requestField("text_variations_sticky_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestTotalCouponSydDismissalsField () {
      return this.requestTotalCouponSydDismissalsField(true);
    }
    public APIRequestGet requestTotalCouponSydDismissalsField (boolean value) {
      this.requestField("total_coupon_syd_dismissals", value);
      return this;
    }
    public APIRequestGet requestTotalCouponUpsellDismissalsField () {
      return this.requestTotalCouponUpsellDismissalsField(true);
    }
    public APIRequestGet requestTotalCouponUpsellDismissalsField (boolean value) {
      this.requestField("total_coupon_upsell_dismissals", value);
      return this;
    }
    public APIRequestGet requestUrlPrefillRemovalTimestampField () {
      return this.requestUrlPrefillRemovalTimestampField(true);
    }
    public APIRequestGet requestUrlPrefillRemovalTimestampField (boolean value) {
      this.requestField("url_prefill_removal_timestamp", value);
      return this;
    }
    public APIRequestGet requestUsePeCreateFlowField () {
      return this.requestUsePeCreateFlowField(true);
    }
    public APIRequestGet requestUsePeCreateFlowField (boolean value) {
      this.requestField("use_pe_create_flow", value);
      return this;
    }
    public APIRequestGet requestUseStepperPrimaryEntryField () {
      return this.requestUseStepperPrimaryEntryField(true);
    }
    public APIRequestGet requestUseStepperPrimaryEntryField (boolean value) {
      this.requestField("use_stepper_primary_entry", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGet requestWebsiteMediaOptInStatusField () {
      return this.requestWebsiteMediaOptInStatusField(true);
    }
    public APIRequestGet requestWebsiteMediaOptInStatusField (boolean value) {
      this.requestField("website_media_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestWebsiteReviewsDataOptInStatusField () {
      return this.requestWebsiteReviewsDataOptInStatusField(true);
    }
    public APIRequestGet requestWebsiteReviewsDataOptInStatusField (boolean value) {
      this.requestField("website_reviews_data_opt_in_status", value);
      return this;
    }
    public APIRequestGet requestWebsiteSellingPointsDataOptInStatusField () {
      return this.requestWebsiteSellingPointsDataOptInStatusField(true);
    }
    public APIRequestGet requestWebsiteSellingPointsDataOptInStatusField (boolean value) {
      this.requestField("website_selling_points_data_opt_in_status", value);
      return this;
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

  public AdsUserSettings copyFrom(AdsUserSettings instance) {
    this.mAPlusCSurveySeen = instance.mAPlusCSurveySeen;
    this.mAddOverlaysOptInStatus = instance.mAddOverlaysOptInStatus;
    this.mAdgroupNameTemplate = instance.mAdgroupNameTemplate;
    this.mAdsCsCatalogOptOutTimestamp = instance.mAdsCsCatalogOptOutTimestamp;
    this.mAdsCsDynamicSeOptInStatus = instance.mAdsCsDynamicSeOptInStatus;
    this.mAdsCsDynamicSeOptOutTimestamp = instance.mAdsCsDynamicSeOptOutTimestamp;
    this.mAdsCsSitelinksOptInStatus = instance.mAdsCsSitelinksOptInStatus;
    this.mAdsCsSitelinksOptOutTimestamp = instance.mAdsCsSitelinksOptOutTimestamp;
    this.mAdsDestinationOptimizationOptOutTimestamp = instance.mAdsDestinationOptimizationOptOutTimestamp;
    this.mAdsToolVisits = instance.mAdsToolVisits;
    this.mApluscAiAgentOptInStatus = instance.mApluscAiAgentOptInStatus;
    this.mApluscCarouselCdaOptInStatus = instance.mApluscCarouselCdaOptInStatus;
    this.mApluscCarouselInlineCommentOptInStatus = instance.mApluscCarouselInlineCommentOptInStatus;
    this.mApluscDaOptInStatus = instance.mApluscDaOptInStatus;
    this.mApluscEnhanceCtaOptInStatus = instance.mApluscEnhanceCtaOptInStatus;
    this.mApluscEpaOptInStatus = instance.mApluscEpaOptInStatus;
    this.mApluscLocalStoreExtensionOptInStatus = instance.mApluscLocalStoreExtensionOptInStatus;
    this.mApluscOptOutFriction = instance.mApluscOptOutFriction;
    this.mApluscVideofilterOptInStatus = instance.mApluscVideofilterOptInStatus;
    this.mApluscVideouncropOptInStatus = instance.mApluscVideouncropOptInStatus;
    this.mAutoflowLiteOptInStatus = instance.mAutoflowLiteOptInStatus;
    this.mAutoflowLiteShouldOptIn = instance.mAutoflowLiteShouldOptIn;
    this.mBlendedAdsCreationDefaultingOptInStatus = instance.mBlendedAdsCreationDefaultingOptInStatus;
    this.mBlendedAdsCreationDefaultingOptOutCampaignGroupIds = instance.mBlendedAdsCreationDefaultingOptOutCampaignGroupIds;
    this.mBookmarkedPages = instance.mBookmarkedPages;
    this.mCampaignGroupNameTemplate = instance.mCampaignGroupNameTemplate;
    this.mCampaignNameTemplate = instance.mCampaignNameTemplate;
    this.mCarouselToVideoOptInStatus = instance.mCarouselToVideoOptInStatus;
    this.mConnectedSourcesCatalogOptInStatus = instance.mConnectedSourcesCatalogOptInStatus;
    this.mCreateCtaStickerOptInStatus = instance.mCreateCtaStickerOptInStatus;
    this.mCreativeFlexOptInStatus = instance.mCreativeFlexOptInStatus;
    this.mDaAddOverlaysOptInStatus = instance.mDaAddOverlaysOptInStatus;
    this.mDaCreativeFlexOptInStatus = instance.mDaCreativeFlexOptInStatus;
    this.mDaHidePriceOptInStatus = instance.mDaHidePriceOptInStatus;
    this.mDaManualMediaNuxImpressions = instance.mDaManualMediaNuxImpressions;
    this.mDefaultCreationMode = instance.mDefaultCreationMode;
    this.mDynamicPartnershipAdsOptInStatus = instance.mDynamicPartnershipAdsOptInStatus;
    this.mEnhanceCtaTextExtractionOptInStatus = instance.mEnhanceCtaTextExtractionOptInStatus;
    this.mExportFormatDefault = instance.mExportFormatDefault;
    this.mFocusModeDefault = instance.mFocusModeDefault;
    this.mGenAiAlphaTestStatus = instance.mGenAiAlphaTestStatus;
    this.mGenAiAutoSelectOptInStatus = instance.mGenAiAutoSelectOptInStatus;
    this.mId = instance.mId;
    this.mImageBackgroundGenerationOptInStatus = instance.mImageBackgroundGenerationOptInStatus;
    this.mImageBrightnessAndContrastOptInStatus = instance.mImageBrightnessAndContrastOptInStatus;
    this.mImageExpansionOptInStatus = instance.mImageExpansionOptInStatus;
    this.mImageTemplatesTextExtractionOptInStatus = instance.mImageTemplatesTextExtractionOptInStatus;
    this.mIsAdsAiConsented = instance.mIsAdsAiConsented;
    this.mIsCboDefaultOn = instance.mIsCboDefaultOn;
    this.mIsSeRemovalGuidanceDismissed = instance.mIsSeRemovalGuidanceDismissed;
    this.mLastUsedPostFormat = instance.mLastUsedPostFormat;
    this.mLastVisitedTime = instance.mLastVisitedTime;
    this.mMetadataBrandKitLastOptOutTimestamp = instance.mMetadataBrandKitLastOptOutTimestamp;
    this.mMetadataBrandKitOptInStatus = instance.mMetadataBrandKitOptInStatus;
    this.mMusicOnReelsOptIn = instance.mMusicOnReelsOptIn;
    this.mMutedCboMidflightEducationMessages = instance.mMutedCboMidflightEducationMessages;
    this.mOnsiteDestinationOptimizationOptIn = instance.mOnsiteDestinationOptimizationOptIn;
    this.mOpenTabs = instance.mOpenTabs;
    this.mPacRelaxationOptInStatus = instance.mPacRelaxationOptInStatus;
    this.mPlacementGroupSquareOptInStatus = instance.mPlacementGroupSquareOptInStatus;
    this.mPlacementGroupVerticalOptInStatus = instance.mPlacementGroupVerticalOptInStatus;
    this.mPreviouslySeenRecommendations = instance.mPreviouslySeenRecommendations;
    this.mProductExtensionsOptIn = instance.mProductExtensionsOptIn;
    this.mReactiveControlSettings = instance.mReactiveControlSettings;
    this.mReplaceMediaTextOptInStatus = instance.mReplaceMediaTextOptInStatus;
    this.mSaOffConvLocSeen = instance.mSaOffConvLocSeen;
    this.mSaoffPublishedL2ConvLocSeen = instance.mSaoffPublishedL2ConvLocSeen;
    this.mSaonMigrL1SeenStatus = instance.mSaonMigrL1SeenStatus;
    this.mSelectedAdAccount = instance.mSelectedAdAccount;
    this.mSelectedComparisonTimerange = instance.mSelectedComparisonTimerange;
    this.mSelectedMetricCic = instance.mSelectedMetricCic;
    this.mSelectedMetricsCic = instance.mSelectedMetricsCic;
    this.mSelectedPage = instance.mSelectedPage;
    this.mSelectedPageSection = instance.mSelectedPageSection;
    this.mSelectedPowerEditorPane = instance.mSelectedPowerEditorPane;
    this.mSelectedStatRange = instance.mSelectedStatRange;
    this.mShouldExportFilterEmptyCols = instance.mShouldExportFilterEmptyCols;
    this.mShouldExportRowsWithoutUnsupportedFeature = instance.mShouldExportRowsWithoutUnsupportedFeature;
    this.mShouldNotAutoExpandTreeTable = instance.mShouldNotAutoExpandTreeTable;
    this.mShouldNotShowCboCampaignToggleOffConfirmationMessage = instance.mShouldNotShowCboCampaignToggleOffConfirmationMessage;
    this.mShouldNotShowPublishMessageOnEditorClose = instance.mShouldNotShowPublishMessageOnEditorClose;
    this.mShowOriginalVideosOptIn = instance.mShowOriginalVideosOptIn;
    this.mShowSummaryOptInStatus = instance.mShowSummaryOptInStatus;
    this.mStaticAdProductExtensionsOptIn = instance.mStaticAdProductExtensionsOptIn;
    this.mStickySettingAfterDefaultOn = instance.mStickySettingAfterDefaultOn;
    this.mSydCampaignTrendsMetric = instance.mSydCampaignTrendsMetric;
    this.mTextOptimizationsTextExtractionOptInStatus = instance.mTextOptimizationsTextExtractionOptInStatus;
    this.mTextTranslationOptInStatus = instance.mTextTranslationOptInStatus;
    this.mTextVariationsStickyOptInStatus = instance.mTextVariationsStickyOptInStatus;
    this.mTotalCouponSydDismissals = instance.mTotalCouponSydDismissals;
    this.mTotalCouponUpsellDismissals = instance.mTotalCouponUpsellDismissals;
    this.mUrlPrefillRemovalTimestamp = instance.mUrlPrefillRemovalTimestamp;
    this.mUsePeCreateFlow = instance.mUsePeCreateFlow;
    this.mUseStepperPrimaryEntry = instance.mUseStepperPrimaryEntry;
    this.mUser = instance.mUser;
    this.mWebsiteMediaOptInStatus = instance.mWebsiteMediaOptInStatus;
    this.mWebsiteReviewsDataOptInStatus = instance.mWebsiteReviewsDataOptInStatus;
    this.mWebsiteSellingPointsDataOptInStatus = instance.mWebsiteSellingPointsDataOptInStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsUserSettings> getParser() {
    return new APIRequest.ResponseParser<AdsUserSettings>() {
      public APINodeList<AdsUserSettings> parseResponse(String response, APIContext context, APIRequest<AdsUserSettings> request, String header) throws MalformedResponseException {
        return AdsUserSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
