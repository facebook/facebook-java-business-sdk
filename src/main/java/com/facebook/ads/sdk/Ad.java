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
public class Ad extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("ad_active_time")
  private String mAdActiveTime = null;
  @SerializedName("ad_review_feedback")
  private AdgroupReviewFeedback mAdReviewFeedback = null;
  @SerializedName("ad_schedule_end_time")
  private String mAdScheduleEndTime = null;
  @SerializedName("ad_schedule_start_time")
  private String mAdScheduleStartTime = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("adset")
  private AdSet mAdset = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("bid_amount")
  private Long mBidAmount = null;
  @SerializedName("bid_info")
  private Map<String, Long> mBidInfo = null;
  @SerializedName("bid_type")
  private EnumBidType mBidType = null;
  @SerializedName("campaign")
  private Campaign mCampaign = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("conversion_domain")
  private String mConversionDomain = null;
  @SerializedName("conversion_specs")
  private List<ConversionActionQuery> mConversionSpecs = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative")
  private AdCreative mCreative = null;
  @SerializedName("creative_asset_groups_spec")
  private AdCreativeAssetGroupsSpec mCreativeAssetGroupsSpec = null;
  @SerializedName("demolink_hash")
  private String mDemolinkHash = null;
  @SerializedName("display_sequence")
  private Long mDisplaySequence = null;
  @SerializedName("effective_status")
  private EnumEffectiveStatus mEffectiveStatus = null;
  @SerializedName("engagement_audience")
  private Boolean mEngagementAudience = null;
  @SerializedName("failed_delivery_checks")
  private List<DeliveryCheck> mFailedDeliveryChecks = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("issues_info")
  private List<AdgroupIssuesInfo> mIssuesInfo = null;
  @SerializedName("last_updated_by_app_id")
  private String mLastUpdatedByAppId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("preview_shareable_link")
  private String mPreviewShareableLink = null;
  @SerializedName("priority")
  private Long mPriority = null;
  @SerializedName("recommendations")
  private List<AdRecommendation> mRecommendations = null;
  @SerializedName("source_ad")
  private Ad mSourceAd = null;
  @SerializedName("source_ad_id")
  private String mSourceAdId = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("tracking_and_conversion_with_defaults")
  private TrackingAndConversionWithDefaults mTrackingAndConversionWithDefaults = null;
  @SerializedName("tracking_specs")
  private List<ConversionActionQuery> mTrackingSpecs = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  Ad() {
  }

  public Ad(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Ad(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Ad fetch() throws APIException{
    Ad newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Ad fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Ad> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Ad fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Ad> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Ad> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Ad>)(
      new APIRequest<Ad>(context, "", "/", "GET", Ad.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Ad>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Ad.getParser())
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
  public static Ad loadJSON(String json, APIContext context, String header) {
    Ad ad = getGson().fromJson(json, Ad.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(ad.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    ad.context = context;
    ad.rawValue = json;
    ad.header = header;
    return ad;
  }

  public static APINodeList<Ad> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Ad> ads = new APINodeList<Ad>(request, json, header);
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
          ads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return ads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                ads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            ads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              ads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              ads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  ads.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              ads.add(loadJSON(obj.toString(), context, header));
            }
          }
          return ads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              ads.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return ads;
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
              ads.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return ads;
          }

          // Sixth, check if it's pure JsonObject
          ads.clear();
          ads.add(loadJSON(json, context, header));
          return ads;
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

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdRulesGoverned getAdRulesGoverned() {
    return new APIRequestGetAdRulesGoverned(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCopies getCopies() {
    return new APIRequestGetCopies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCopy createCopy() {
    return new APIRequestCreateCopy(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLeads getLeads() {
    return new APIRequestGetLeads(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldAdActiveTime() {
    return mAdActiveTime;
  }

  public AdgroupReviewFeedback getFieldAdReviewFeedback() {
    return mAdReviewFeedback;
  }

  public String getFieldAdScheduleEndTime() {
    return mAdScheduleEndTime;
  }

  public String getFieldAdScheduleStartTime() {
    return mAdScheduleStartTime;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdSet getFieldAdset() {
    if (mAdset != null) {
      mAdset.context = getContext();
    }
    return mAdset;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public EnumBidType getFieldBidType() {
    return mBidType;
  }

  public Campaign getFieldCampaign() {
    if (mCampaign != null) {
      mCampaign.context = getContext();
    }
    return mCampaign;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public String getFieldConversionDomain() {
    return mConversionDomain;
  }

  public List<ConversionActionQuery> getFieldConversionSpecs() {
    return mConversionSpecs;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdCreative getFieldCreative() {
    if (mCreative != null) {
      mCreative.context = getContext();
    }
    return mCreative;
  }

  public AdCreativeAssetGroupsSpec getFieldCreativeAssetGroupsSpec() {
    return mCreativeAssetGroupsSpec;
  }

  public String getFieldDemolinkHash() {
    return mDemolinkHash;
  }

  public Long getFieldDisplaySequence() {
    return mDisplaySequence;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public Boolean getFieldEngagementAudience() {
    return mEngagementAudience;
  }

  public List<DeliveryCheck> getFieldFailedDeliveryChecks() {
    return mFailedDeliveryChecks;
  }

  public String getFieldId() {
    return mId;
  }

  public List<AdgroupIssuesInfo> getFieldIssuesInfo() {
    return mIssuesInfo;
  }

  public String getFieldLastUpdatedByAppId() {
    return mLastUpdatedByAppId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPreviewShareableLink() {
    return mPreviewShareableLink;
  }

  public Long getFieldPriority() {
    return mPriority;
  }

  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
  }

  public Ad getFieldSourceAd() {
    if (mSourceAd != null) {
      mSourceAd.context = getContext();
    }
    return mSourceAd;
  }

  public String getFieldSourceAdId() {
    return mSourceAdId;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public TrackingAndConversionWithDefaults getFieldTrackingAndConversionWithDefaults() {
    return mTrackingAndConversionWithDefaults;
  }

  public List<ConversionActionQuery> getFieldTrackingSpecs() {
    return mTrackingSpecs;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "asset_feed_spec",
      "authorization_category",
      "auto_update",
      "body",
      "branded_content",
      "branded_content_sponsor_page_id",
      "bundle_folder_id",
      "call_to_action_type",
      "categorization_criteria",
      "category_media_source",
      "collaborative_ads_lsb_image_bank_id",
      "contextual_multi_ads",
      "creative_sourcing_spec",
      "degrees_of_freedom_spec",
      "destination_set_id",
      "dynamic_ad_voice",
      "effective_authorization_category",
      "effective_instagram_media_id",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "enable_direct_install",
      "enable_launch_instant_app",
      "facebook_branded_content",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_branded_content",
      "instagram_permalink_url",
      "instagram_story_id",
      "instagram_user_id",
      "interactive_components_spec",
      "link_deep_link_url",
      "link_destination_display_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_store_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "omnichannel_link_spec",
      "page_welcome_message",
      "photo_album_source_object_story_id",
      "place_page_set_id",
      "platform_customizations",
      "playable_asset_id",
      "portrait_customizations",
      "product_set_id",
      "recommender_settings",
      "source_instagram_media_id",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_id",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreative>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreative>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdCreative>>() {
           public APINodeList<AdCreative> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdCreatives.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreatives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreatives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreatives requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAuthorizationCategoryField () {
      return this.requestAuthorizationCategoryField(true);
    }
    public APIRequestGetAdCreatives requestAuthorizationCategoryField (boolean value) {
      this.requestField("authorization_category", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAutoUpdateField () {
      return this.requestAutoUpdateField(true);
    }
    public APIRequestGetAdCreatives requestAutoUpdateField (boolean value) {
      this.requestField("auto_update", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBrandedContentField () {
      return this.requestBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestBrandedContentField (boolean value) {
      this.requestField("branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBundleFolderIdField () {
      return this.requestBundleFolderIdField(true);
    }
    public APIRequestGetAdCreatives requestBundleFolderIdField (boolean value) {
      this.requestField("bundle_folder_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCategorizationCriteriaField () {
      return this.requestCategorizationCriteriaField(true);
    }
    public APIRequestGetAdCreatives requestCategorizationCriteriaField (boolean value) {
      this.requestField("categorization_criteria", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCategoryMediaSourceField () {
      return this.requestCategoryMediaSourceField(true);
    }
    public APIRequestGetAdCreatives requestCategoryMediaSourceField (boolean value) {
      this.requestField("category_media_source", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCollaborativeAdsLsbImageBankIdField () {
      return this.requestCollaborativeAdsLsbImageBankIdField(true);
    }
    public APIRequestGetAdCreatives requestCollaborativeAdsLsbImageBankIdField (boolean value) {
      this.requestField("collaborative_ads_lsb_image_bank_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestContextualMultiAdsField () {
      return this.requestContextualMultiAdsField(true);
    }
    public APIRequestGetAdCreatives requestContextualMultiAdsField (boolean value) {
      this.requestField("contextual_multi_ads", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCreativeSourcingSpecField () {
      return this.requestCreativeSourcingSpecField(true);
    }
    public APIRequestGetAdCreatives requestCreativeSourcingSpecField (boolean value) {
      this.requestField("creative_sourcing_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDegreesOfFreedomSpecField () {
      return this.requestDegreesOfFreedomSpecField(true);
    }
    public APIRequestGetAdCreatives requestDegreesOfFreedomSpecField (boolean value) {
      this.requestField("degrees_of_freedom_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDestinationSetIdField () {
      return this.requestDestinationSetIdField(true);
    }
    public APIRequestGetAdCreatives requestDestinationSetIdField (boolean value) {
      this.requestField("destination_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestDynamicAdVoiceField () {
      return this.requestDynamicAdVoiceField(true);
    }
    public APIRequestGetAdCreatives requestDynamicAdVoiceField (boolean value) {
      this.requestField("dynamic_ad_voice", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveAuthorizationCategoryField () {
      return this.requestEffectiveAuthorizationCategoryField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveAuthorizationCategoryField (boolean value) {
      this.requestField("effective_authorization_category", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramMediaIdField () {
      return this.requestEffectiveInstagramMediaIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramMediaIdField (boolean value) {
      this.requestField("effective_instagram_media_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEnableDirectInstallField () {
      return this.requestEnableDirectInstallField(true);
    }
    public APIRequestGetAdCreatives requestEnableDirectInstallField (boolean value) {
      this.requestField("enable_direct_install", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEnableLaunchInstantAppField () {
      return this.requestEnableLaunchInstantAppField(true);
    }
    public APIRequestGetAdCreatives requestEnableLaunchInstantAppField (boolean value) {
      this.requestField("enable_launch_instant_app", value);
      return this;
    }
    public APIRequestGetAdCreatives requestFacebookBrandedContentField () {
      return this.requestFacebookBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestFacebookBrandedContentField (boolean value) {
      this.requestField("facebook_branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreatives requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreatives requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramBrandedContentField () {
      return this.requestInstagramBrandedContentField(true);
    }
    public APIRequestGetAdCreatives requestInstagramBrandedContentField (boolean value) {
      this.requestField("instagram_branded_content", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramUserIdField () {
      return this.requestInstagramUserIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramUserIdField (boolean value) {
      this.requestField("instagram_user_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInteractiveComponentsSpecField () {
      return this.requestInteractiveComponentsSpecField(true);
    }
    public APIRequestGetAdCreatives requestInteractiveComponentsSpecField (boolean value) {
      this.requestField("interactive_components_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkDeepLinkUrlField () {
      return this.requestLinkDeepLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkDeepLinkUrlField (boolean value) {
      this.requestField("link_deep_link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkDestinationDisplayUrlField () {
      return this.requestLinkDestinationDisplayUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkDestinationDisplayUrlField (boolean value) {
      this.requestField("link_destination_display_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreatives requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreatives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoreUrlField () {
      return this.requestObjectStoreUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoreUrlField (boolean value) {
      this.requestField("object_store_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreatives requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestOmnichannelLinkSpecField () {
      return this.requestOmnichannelLinkSpecField(true);
    }
    public APIRequestGetAdCreatives requestOmnichannelLinkSpecField (boolean value) {
      this.requestField("omnichannel_link_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPageWelcomeMessageField () {
      return this.requestPageWelcomeMessageField(true);
    }
    public APIRequestGetAdCreatives requestPageWelcomeMessageField (boolean value) {
      this.requestField("page_welcome_message", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPhotoAlbumSourceObjectStoryIdField () {
      return this.requestPhotoAlbumSourceObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestPhotoAlbumSourceObjectStoryIdField (boolean value) {
      this.requestField("photo_album_source_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlacePageSetIdField () {
      return this.requestPlacePageSetIdField(true);
    }
    public APIRequestGetAdCreatives requestPlacePageSetIdField (boolean value) {
      this.requestField("place_page_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlayableAssetIdField () {
      return this.requestPlayableAssetIdField(true);
    }
    public APIRequestGetAdCreatives requestPlayableAssetIdField (boolean value) {
      this.requestField("playable_asset_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPortraitCustomizationsField () {
      return this.requestPortraitCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPortraitCustomizationsField (boolean value) {
      this.requestField("portrait_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGetAdCreatives requestSourceInstagramMediaIdField () {
      return this.requestSourceInstagramMediaIdField(true);
    }
    public APIRequestGetAdCreatives requestSourceInstagramMediaIdField (boolean value) {
      this.requestField("source_instagram_media_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreatives requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailIdField () {
      return this.requestThumbnailIdField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailIdField (boolean value) {
      this.requestField("thumbnail_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreatives requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreatives requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreatives requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreatives requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestCreateAdLabel extends APIRequest<Ad> {

    Ad lastResponse = null;
    @Override
    public Ad getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Ad parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Ad execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Ad execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Ad> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Ad> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Ad>() {
           public Ad apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdLabel.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAdLabel setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdLabel setExecutionOptions (List<Ad.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestCreateAdLabel setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAdLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdRulesGoverned extends APIRequest<AdRule> {

    APINodeList<AdRule> lastResponse = null;
    @Override
    public APINodeList<AdRule> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "pass_evaluation",
    };

    public static final String[] FIELDS = {
      "account_id",
      "created_by",
      "created_time",
      "evaluation_spec",
      "execution_spec",
      "id",
      "name",
      "schedule_spec",
      "status",
      "updated_time",
    };

    @Override
    public APINodeList<AdRule> parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdRule> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdRule> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdRule>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdRule>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdRule>>() {
           public APINodeList<AdRule> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdRulesGoverned.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdRulesGoverned(String nodeId, APIContext context) {
      super(context, nodeId, "/adrules_governed", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdRulesGoverned setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdRulesGoverned setPassEvaluation (Boolean passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }
    public APIRequestGetAdRulesGoverned setPassEvaluation (String passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdRulesGoverned requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdRulesGoverned requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdRulesGoverned requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetCopies extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "effective_status",
      "time_range",
      "updated_since",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_active_time",
      "ad_review_feedback",
      "ad_schedule_end_time",
      "ad_schedule_start_time",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_domain",
      "conversion_specs",
      "created_time",
      "creative",
      "creative_asset_groups_spec",
      "demolink_hash",
      "display_sequence",
      "effective_status",
      "engagement_audience",
      "failed_delivery_checks",
      "id",
      "issues_info",
      "last_updated_by_app_id",
      "name",
      "preview_shareable_link",
      "priority",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "targeting",
      "tracking_and_conversion_with_defaults",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCopies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCopies(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCopies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCopies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCopies setDatePreset (Ad.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCopies setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCopies setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetCopies setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCopies setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetCopies setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetCopies setUpdatedSince (Long updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }
    public APIRequestGetCopies setUpdatedSince (String updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }

    public APIRequestGetCopies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCopies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCopies requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCopies requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCopies requestAdActiveTimeField () {
      return this.requestAdActiveTimeField(true);
    }
    public APIRequestGetCopies requestAdActiveTimeField (boolean value) {
      this.requestField("ad_active_time", value);
      return this;
    }
    public APIRequestGetCopies requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetCopies requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetCopies requestAdScheduleEndTimeField () {
      return this.requestAdScheduleEndTimeField(true);
    }
    public APIRequestGetCopies requestAdScheduleEndTimeField (boolean value) {
      this.requestField("ad_schedule_end_time", value);
      return this;
    }
    public APIRequestGetCopies requestAdScheduleStartTimeField () {
      return this.requestAdScheduleStartTimeField(true);
    }
    public APIRequestGetCopies requestAdScheduleStartTimeField (boolean value) {
      this.requestField("ad_schedule_start_time", value);
      return this;
    }
    public APIRequestGetCopies requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCopies requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCopies requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetCopies requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetCopies requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetCopies requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetCopies requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetCopies requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetCopies requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetCopies requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetCopies requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetCopies requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetCopies requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetCopies requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetCopies requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCopies requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCopies requestConversionDomainField () {
      return this.requestConversionDomainField(true);
    }
    public APIRequestGetCopies requestConversionDomainField (boolean value) {
      this.requestField("conversion_domain", value);
      return this;
    }
    public APIRequestGetCopies requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetCopies requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetCopies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCopies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCopies requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetCopies requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetCopies requestCreativeAssetGroupsSpecField () {
      return this.requestCreativeAssetGroupsSpecField(true);
    }
    public APIRequestGetCopies requestCreativeAssetGroupsSpecField (boolean value) {
      this.requestField("creative_asset_groups_spec", value);
      return this;
    }
    public APIRequestGetCopies requestDemolinkHashField () {
      return this.requestDemolinkHashField(true);
    }
    public APIRequestGetCopies requestDemolinkHashField (boolean value) {
      this.requestField("demolink_hash", value);
      return this;
    }
    public APIRequestGetCopies requestDisplaySequenceField () {
      return this.requestDisplaySequenceField(true);
    }
    public APIRequestGetCopies requestDisplaySequenceField (boolean value) {
      this.requestField("display_sequence", value);
      return this;
    }
    public APIRequestGetCopies requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCopies requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCopies requestEngagementAudienceField () {
      return this.requestEngagementAudienceField(true);
    }
    public APIRequestGetCopies requestEngagementAudienceField (boolean value) {
      this.requestField("engagement_audience", value);
      return this;
    }
    public APIRequestGetCopies requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetCopies requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetCopies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCopies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCopies requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetCopies requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGetCopies requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetCopies requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetCopies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCopies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCopies requestPreviewShareableLinkField () {
      return this.requestPreviewShareableLinkField(true);
    }
    public APIRequestGetCopies requestPreviewShareableLinkField (boolean value) {
      this.requestField("preview_shareable_link", value);
      return this;
    }
    public APIRequestGetCopies requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGetCopies requestPriorityField (boolean value) {
      this.requestField("priority", value);
      return this;
    }
    public APIRequestGetCopies requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCopies requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetCopies requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetCopies requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetCopies requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCopies requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCopies requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetCopies requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetCopies requestTrackingAndConversionWithDefaultsField () {
      return this.requestTrackingAndConversionWithDefaultsField(true);
    }
    public APIRequestGetCopies requestTrackingAndConversionWithDefaultsField (boolean value) {
      this.requestField("tracking_and_conversion_with_defaults", value);
      return this;
    }
    public APIRequestGetCopies requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetCopies requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetCopies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCopies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateCopy extends APIRequest<Ad> {

    Ad lastResponse = null;
    @Override
    public Ad getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adset_id",
      "rename_options",
      "status_option",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Ad parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Ad execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Ad execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Ad> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Ad> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Ad>() {
           public Ad apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCopy.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCopy(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCopy setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCopy setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCopy setAdsetId (String adsetId) {
      this.setParam("adset_id", adsetId);
      return this;
    }

    public APIRequestCreateCopy setRenameOptions (Object renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }
    public APIRequestCreateCopy setRenameOptions (String renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }

    public APIRequestCreateCopy setStatusOption (Ad.EnumStatusOption statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }
    public APIRequestCreateCopy setStatusOption (String statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }

    public APIRequestCreateCopy requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCopy requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
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


    public APIRequestGetInsights setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsights setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsights setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
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

    public APIRequestGetInsights setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsights setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsights setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsights setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsights setFields (List<String> fields) {
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

    public APIRequestGetInsights setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsights setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsights setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsights setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
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

    public APIRequestGetInsights setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsights setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsights setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsights setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsights setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsights setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsights setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
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

  }

  public static class APIRequestGetInsightsAsync extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
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
               return APIRequestGetInsightsAsync.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsAsync setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsAsync setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsightsAsync setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsAsync setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsightsAsync setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsAsync setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsightsAsync setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsAsync setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsightsAsync setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsAsync setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsightsAsync setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsightsAsync setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsightsAsync setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsightsAsync setFields (List<String> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsightsAsync setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsAsync setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsightsAsync setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsAsync setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsightsAsync setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsAsync setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsightsAsync setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsAsync setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsightsAsync setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsAsync setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsightsAsync setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsAsync requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLeads extends APIRequest<Lead> {

    APINodeList<Lead> lastResponse = null;
    @Override
    public APINodeList<Lead> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "home_listing",
      "id",
      "is_organic",
      "partner_name",
      "platform",
      "post",
      "post_submission_check_result",
      "retailer_item_id",
      "vehicle",
    };

    @Override
    public APINodeList<Lead> parseResponse(String response, String header) throws APIException {
      return Lead.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Lead> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Lead> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Lead>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Lead>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Lead>>() {
           public APINodeList<Lead> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLeads.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLeads(String nodeId, APIContext context) {
      super(context, nodeId, "/leads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLeads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLeads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLeads requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetLeads requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetLeads requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetLeads requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetLeads requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetLeads requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetLeads requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetLeads requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetLeads requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGetLeads requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGetLeads requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGetLeads requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGetLeads requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGetLeads requestHomeListingField () {
      return this.requestHomeListingField(true);
    }
    public APIRequestGetLeads requestHomeListingField (boolean value) {
      this.requestField("home_listing", value);
      return this;
    }
    public APIRequestGetLeads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLeads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLeads requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGetLeads requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGetLeads requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGetLeads requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGetLeads requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetLeads requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetLeads requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGetLeads requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGetLeads requestPostSubmissionCheckResultField () {
      return this.requestPostSubmissionCheckResultField(true);
    }
    public APIRequestGetLeads requestPostSubmissionCheckResultField (boolean value) {
      this.requestField("post_submission_check_result", value);
      return this;
    }
    public APIRequestGetLeads requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGetLeads requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
    public APIRequestGetLeads requestVehicleField () {
      return this.requestVehicleField(true);
    }
    public APIRequestGetLeads requestVehicleField (boolean value) {
      this.requestField("vehicle", value);
      return this;
    }
  }

  public static class APIRequestGetPreviews extends APIRequest<AdPreview> {

    APINodeList<AdPreview> lastResponse = null;
    @Override
    public APINodeList<AdPreview> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_format",
      "creative_feature",
      "dynamic_asset_label",
      "dynamic_creative_spec",
      "dynamic_customization",
      "end_date",
      "height",
      "locale",
      "place_page_id",
      "post",
      "product_item_ids",
      "render_type",
      "start_date",
      "width",
    };

    public static final String[] FIELDS = {
      "body",
      "transformation_spec",
    };

    @Override
    public APINodeList<AdPreview> parseResponse(String response, String header) throws APIException {
      return AdPreview.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdPreview> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPreview> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdPreview>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdPreview>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdPreview>>() {
           public APINodeList<AdPreview> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPreviews.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/previews", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreviews setAdFormat (AdPreview.EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }
    public APIRequestGetPreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetPreviews setCreativeFeature (AdPreview.EnumCreativeFeature creativeFeature) {
      this.setParam("creative_feature", creativeFeature);
      return this;
    }
    public APIRequestGetPreviews setCreativeFeature (String creativeFeature) {
      this.setParam("creative_feature", creativeFeature);
      return this;
    }

    public APIRequestGetPreviews setDynamicAssetLabel (String dynamicAssetLabel) {
      this.setParam("dynamic_asset_label", dynamicAssetLabel);
      return this;
    }

    public APIRequestGetPreviews setDynamicCreativeSpec (Object dynamicCreativeSpec) {
      this.setParam("dynamic_creative_spec", dynamicCreativeSpec);
      return this;
    }
    public APIRequestGetPreviews setDynamicCreativeSpec (String dynamicCreativeSpec) {
      this.setParam("dynamic_creative_spec", dynamicCreativeSpec);
      return this;
    }

    public APIRequestGetPreviews setDynamicCustomization (Object dynamicCustomization) {
      this.setParam("dynamic_customization", dynamicCustomization);
      return this;
    }
    public APIRequestGetPreviews setDynamicCustomization (String dynamicCustomization) {
      this.setParam("dynamic_customization", dynamicCustomization);
      return this;
    }

    public APIRequestGetPreviews setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetPreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetPreviews setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPreviews setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestGetPreviews setPlacePageId (Long placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }
    public APIRequestGetPreviews setPlacePageId (String placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }

    public APIRequestGetPreviews setPost (Object post) {
      this.setParam("post", post);
      return this;
    }
    public APIRequestGetPreviews setPost (String post) {
      this.setParam("post", post);
      return this;
    }

    public APIRequestGetPreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }
    public APIRequestGetPreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setRenderType (AdPreview.EnumRenderType renderType) {
      this.setParam("render_type", renderType);
      return this;
    }
    public APIRequestGetPreviews setRenderType (String renderType) {
      this.setParam("render_type", renderType);
      return this;
    }

    public APIRequestGetPreviews setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetPreviews setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPreviews setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreviews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPreviews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPreviews requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetPreviews requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetPreviews requestTransformationSpecField () {
      return this.requestTransformationSpecField(true);
    }
    public APIRequestGetPreviews requestTransformationSpecField (boolean value) {
      this.requestField("transformation_spec", value);
      return this;
    }
  }

  public static class APIRequestGetTargetingSentenceLines extends APIRequest<TargetingSentenceLine> {

    APINodeList<TargetingSentenceLine> lastResponse = null;
    @Override
    public APINodeList<TargetingSentenceLine> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "params",
      "targetingsentencelines",
    };

    @Override
    public APINodeList<TargetingSentenceLine> parseResponse(String response, String header) throws APIException {
      return TargetingSentenceLine.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<TargetingSentenceLine>>() {
           public APINodeList<TargetingSentenceLine> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTargetingSentenceLines.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSentenceLines requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSentenceLines requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSentenceLines requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestParamsField () {
      return this.requestParamsField(true);
    }
    public APIRequestGetTargetingSentenceLines requestParamsField (boolean value) {
      this.requestField("params", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField () {
      return this.requestTargetingsentencelinesField(true);
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField (boolean value) {
      this.requestField("targetingsentencelines", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Ad> {

    Ad lastResponse = null;
    @Override
    public Ad getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "am_call_tags",
      "date_preset",
      "from_adtable",
      "review_feedback_breakdown",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_active_time",
      "ad_review_feedback",
      "ad_schedule_end_time",
      "ad_schedule_start_time",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_domain",
      "conversion_specs",
      "created_time",
      "creative",
      "creative_asset_groups_spec",
      "demolink_hash",
      "display_sequence",
      "effective_status",
      "engagement_audience",
      "failed_delivery_checks",
      "id",
      "issues_info",
      "last_updated_by_app_id",
      "name",
      "preview_shareable_link",
      "priority",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "targeting",
      "tracking_and_conversion_with_defaults",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public Ad parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Ad execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Ad execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Ad> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Ad> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Ad>() {
           public Ad apply(ResponseWrapper result) {
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


    public APIRequestGet setAmCallTags (Map<String, String> amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }
    public APIRequestGet setAmCallTags (String amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }

    public APIRequestGet setDatePreset (EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGet setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGet setFromAdtable (Boolean fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }
    public APIRequestGet setFromAdtable (String fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }

    public APIRequestGet setReviewFeedbackBreakdown (Boolean reviewFeedbackBreakdown) {
      this.setParam("review_feedback_breakdown", reviewFeedbackBreakdown);
      return this;
    }
    public APIRequestGet setReviewFeedbackBreakdown (String reviewFeedbackBreakdown) {
      this.setParam("review_feedback_breakdown", reviewFeedbackBreakdown);
      return this;
    }

    public APIRequestGet setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGet setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
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
    public APIRequestGet requestAdActiveTimeField () {
      return this.requestAdActiveTimeField(true);
    }
    public APIRequestGet requestAdActiveTimeField (boolean value) {
      this.requestField("ad_active_time", value);
      return this;
    }
    public APIRequestGet requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGet requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGet requestAdScheduleEndTimeField () {
      return this.requestAdScheduleEndTimeField(true);
    }
    public APIRequestGet requestAdScheduleEndTimeField (boolean value) {
      this.requestField("ad_schedule_end_time", value);
      return this;
    }
    public APIRequestGet requestAdScheduleStartTimeField () {
      return this.requestAdScheduleStartTimeField(true);
    }
    public APIRequestGet requestAdScheduleStartTimeField (boolean value) {
      this.requestField("ad_schedule_start_time", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGet requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGet requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGet requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGet requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGet requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGet requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGet requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGet requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGet requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGet requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGet requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGet requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGet requestConversionDomainField () {
      return this.requestConversionDomainField(true);
    }
    public APIRequestGet requestConversionDomainField (boolean value) {
      this.requestField("conversion_domain", value);
      return this;
    }
    public APIRequestGet requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGet requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGet requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGet requestCreativeAssetGroupsSpecField () {
      return this.requestCreativeAssetGroupsSpecField(true);
    }
    public APIRequestGet requestCreativeAssetGroupsSpecField (boolean value) {
      this.requestField("creative_asset_groups_spec", value);
      return this;
    }
    public APIRequestGet requestDemolinkHashField () {
      return this.requestDemolinkHashField(true);
    }
    public APIRequestGet requestDemolinkHashField (boolean value) {
      this.requestField("demolink_hash", value);
      return this;
    }
    public APIRequestGet requestDisplaySequenceField () {
      return this.requestDisplaySequenceField(true);
    }
    public APIRequestGet requestDisplaySequenceField (boolean value) {
      this.requestField("display_sequence", value);
      return this;
    }
    public APIRequestGet requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGet requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGet requestEngagementAudienceField () {
      return this.requestEngagementAudienceField(true);
    }
    public APIRequestGet requestEngagementAudienceField (boolean value) {
      this.requestField("engagement_audience", value);
      return this;
    }
    public APIRequestGet requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGet requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGet requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGet requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPreviewShareableLinkField () {
      return this.requestPreviewShareableLinkField(true);
    }
    public APIRequestGet requestPreviewShareableLinkField (boolean value) {
      this.requestField("preview_shareable_link", value);
      return this;
    }
    public APIRequestGet requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGet requestPriorityField (boolean value) {
      this.requestField("priority", value);
      return this;
    }
    public APIRequestGet requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGet requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGet requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGet requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGet requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGet requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTrackingAndConversionWithDefaultsField () {
      return this.requestTrackingAndConversionWithDefaultsField(true);
    }
    public APIRequestGet requestTrackingAndConversionWithDefaultsField (boolean value) {
      this.requestField("tracking_and_conversion_with_defaults", value);
      return this;
    }
    public APIRequestGet requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGet requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Ad> {

    Ad lastResponse = null;
    @Override
    public Ad getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_schedule_end_time",
      "ad_schedule_start_time",
      "adlabels",
      "adset_spec",
      "audience_id",
      "bid_amount",
      "conversion_domain",
      "creative",
      "creative_asset_groups_spec",
      "display_sequence",
      "draft_adgroup_id",
      "engagement_audience",
      "execution_options",
      "include_demolink_hashes",
      "name",
      "priority",
      "status",
      "tracking_specs",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Ad parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Ad execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Ad execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Ad> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Ad> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Ad>() {
           public Ad apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAdScheduleEndTime (String adScheduleEndTime) {
      this.setParam("ad_schedule_end_time", adScheduleEndTime);
      return this;
    }

    public APIRequestUpdate setAdScheduleStartTime (String adScheduleStartTime) {
      this.setParam("ad_schedule_start_time", adScheduleStartTime);
      return this;
    }

    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setAdsetSpec (AdSet adsetSpec) {
      this.setParam("adset_spec", adsetSpec);
      return this;
    }
    public APIRequestUpdate setAdsetSpec (String adsetSpec) {
      this.setParam("adset_spec", adsetSpec);
      return this;
    }

    public APIRequestUpdate setAudienceId (String audienceId) {
      this.setParam("audience_id", audienceId);
      return this;
    }

    public APIRequestUpdate setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestUpdate setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestUpdate setConversionDomain (String conversionDomain) {
      this.setParam("conversion_domain", conversionDomain);
      return this;
    }

    public APIRequestUpdate setCreative (AdCreative creative) {
      this.setParam("creative", creative);
      return this;
    }
    public APIRequestUpdate setCreative (String creative) {
      this.setParam("creative", creative);
      return this;
    }

    public APIRequestUpdate setCreativeAssetGroupsSpec (Object creativeAssetGroupsSpec) {
      this.setParam("creative_asset_groups_spec", creativeAssetGroupsSpec);
      return this;
    }
    public APIRequestUpdate setCreativeAssetGroupsSpec (String creativeAssetGroupsSpec) {
      this.setParam("creative_asset_groups_spec", creativeAssetGroupsSpec);
      return this;
    }

    public APIRequestUpdate setDisplaySequence (Long displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }
    public APIRequestUpdate setDisplaySequence (String displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }

    public APIRequestUpdate setDraftAdgroupId (String draftAdgroupId) {
      this.setParam("draft_adgroup_id", draftAdgroupId);
      return this;
    }

    public APIRequestUpdate setEngagementAudience (Boolean engagementAudience) {
      this.setParam("engagement_audience", engagementAudience);
      return this;
    }
    public APIRequestUpdate setEngagementAudience (String engagementAudience) {
      this.setParam("engagement_audience", engagementAudience);
      return this;
    }

    public APIRequestUpdate setExecutionOptions (List<Ad.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestUpdate setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestUpdate setIncludeDemolinkHashes (Boolean includeDemolinkHashes) {
      this.setParam("include_demolink_hashes", includeDemolinkHashes);
      return this;
    }
    public APIRequestUpdate setIncludeDemolinkHashes (String includeDemolinkHashes) {
      this.setParam("include_demolink_hashes", includeDemolinkHashes);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPriority (Long priority) {
      this.setParam("priority", priority);
      return this;
    }
    public APIRequestUpdate setPriority (String priority) {
      this.setParam("priority", priority);
      return this;
    }

    public APIRequestUpdate setStatus (Ad.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setTrackingSpecs (Object trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }
    public APIRequestUpdate setTrackingSpecs (String trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumBidType {
      @SerializedName("ABSOLUTE_OCPM")
      VALUE_ABSOLUTE_OCPM("ABSOLUTE_OCPM"),
      @SerializedName("CPA")
      VALUE_CPA("CPA"),
      @SerializedName("CPC")
      VALUE_CPC("CPC"),
      @SerializedName("CPM")
      VALUE_CPM("CPM"),
      @SerializedName("MULTI_PREMIUM")
      VALUE_MULTI_PREMIUM("MULTI_PREMIUM"),
      ;

      private String value;

      private EnumBidType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumConfiguredStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumConfiguredStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ADSET_PAUSED")
      VALUE_ADSET_PAUSED("ADSET_PAUSED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("CAMPAIGN_PAUSED")
      VALUE_CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DISAPPROVED")
      VALUE_DISAPPROVED("DISAPPROVED"),
      @SerializedName("IN_PROCESS")
      VALUE_IN_PROCESS("IN_PROCESS"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("PENDING_BILLING_INFO")
      VALUE_PENDING_BILLING_INFO("PENDING_BILLING_INFO"),
      @SerializedName("PENDING_REVIEW")
      VALUE_PENDING_REVIEW("PENDING_REVIEW"),
      @SerializedName("PREAPPROVED")
      VALUE_PREAPPROVED("PREAPPROVED"),
      @SerializedName("WITH_ISSUES")
      VALUE_WITH_ISSUES("WITH_ISSUES"),
      ;

      private String value;

      private EnumEffectiveStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public static enum EnumExecutionOptions {
      @SerializedName("include_recommendations")
      VALUE_INCLUDE_RECOMMENDATIONS("include_recommendations"),
      @SerializedName("synchronous_ad_review")
      VALUE_SYNCHRONOUS_AD_REVIEW("synchronous_ad_review"),
      @SerializedName("validate_only")
      VALUE_VALIDATE_ONLY("validate_only"),
      ;

      private String value;

      private EnumExecutionOptions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOperator {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("ANY")
      VALUE_ANY("ANY"),
      ;

      private String value;

      private EnumOperator(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatusOption {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("INHERITED_FROM_SOURCE")
      VALUE_INHERITED_FROM_SOURCE("INHERITED_FROM_SOURCE"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumStatusOption(String value) {
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

  public Ad copyFrom(Ad instance) {
    this.mAccountId = instance.mAccountId;
    this.mAdActiveTime = instance.mAdActiveTime;
    this.mAdReviewFeedback = instance.mAdReviewFeedback;
    this.mAdScheduleEndTime = instance.mAdScheduleEndTime;
    this.mAdScheduleStartTime = instance.mAdScheduleStartTime;
    this.mAdlabels = instance.mAdlabels;
    this.mAdset = instance.mAdset;
    this.mAdsetId = instance.mAdsetId;
    this.mBidAmount = instance.mBidAmount;
    this.mBidInfo = instance.mBidInfo;
    this.mBidType = instance.mBidType;
    this.mCampaign = instance.mCampaign;
    this.mCampaignId = instance.mCampaignId;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mConversionDomain = instance.mConversionDomain;
    this.mConversionSpecs = instance.mConversionSpecs;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreative = instance.mCreative;
    this.mCreativeAssetGroupsSpec = instance.mCreativeAssetGroupsSpec;
    this.mDemolinkHash = instance.mDemolinkHash;
    this.mDisplaySequence = instance.mDisplaySequence;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mEngagementAudience = instance.mEngagementAudience;
    this.mFailedDeliveryChecks = instance.mFailedDeliveryChecks;
    this.mId = instance.mId;
    this.mIssuesInfo = instance.mIssuesInfo;
    this.mLastUpdatedByAppId = instance.mLastUpdatedByAppId;
    this.mName = instance.mName;
    this.mPreviewShareableLink = instance.mPreviewShareableLink;
    this.mPriority = instance.mPriority;
    this.mRecommendations = instance.mRecommendations;
    this.mSourceAd = instance.mSourceAd;
    this.mSourceAdId = instance.mSourceAdId;
    this.mStatus = instance.mStatus;
    this.mTargeting = instance.mTargeting;
    this.mTrackingAndConversionWithDefaults = instance.mTrackingAndConversionWithDefaults;
    this.mTrackingSpecs = instance.mTrackingSpecs;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Ad> getParser() {
    return new APIRequest.ResponseParser<Ad>() {
      public APINodeList<Ad> parseResponse(String response, APIContext context, APIRequest<Ad> request, String header) throws MalformedResponseException {
        return Ad.parseResponse(response, context, request, header);
      }
    };
  }
}
