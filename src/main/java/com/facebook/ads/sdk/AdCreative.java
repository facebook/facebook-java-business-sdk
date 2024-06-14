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
public class AdCreative extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("applink_treatment")
  private String mApplinkTreatment = null;
  @SerializedName("asset_feed_spec")
  private AdAssetFeedSpec mAssetFeedSpec = null;
  @SerializedName("authorization_category")
  private String mAuthorizationCategory = null;
  @SerializedName("auto_update")
  private Boolean mAutoUpdate = null;
  @SerializedName("body")
  private String mBody = null;
  @SerializedName("branded_content")
  private AdCreativeBrandedContentAds mBrandedContent = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("bundle_folder_id")
  private String mBundleFolderId = null;
  @SerializedName("call_to_action_type")
  private EnumCallToActionType mCallToActionType = null;
  @SerializedName("categorization_criteria")
  private String mCategorizationCriteria = null;
  @SerializedName("category_media_source")
  private String mCategoryMediaSource = null;
  @SerializedName("collaborative_ads_lsb_image_bank_id")
  private String mCollaborativeAdsLsbImageBankId = null;
  @SerializedName("contextual_multi_ads")
  private AdCreativeContextualMultiAds mContextualMultiAds = null;
  @SerializedName("creative_sourcing_spec")
  private AdCreativeSourcingSpec mCreativeSourcingSpec = null;
  @SerializedName("degrees_of_freedom_spec")
  private AdCreativeDegreesOfFreedomSpec mDegreesOfFreedomSpec = null;
  @SerializedName("destination_set_id")
  private String mDestinationSetId = null;
  @SerializedName("dynamic_ad_voice")
  private String mDynamicAdVoice = null;
  @SerializedName("effective_authorization_category")
  private String mEffectiveAuthorizationCategory = null;
  @SerializedName("effective_instagram_media_id")
  private String mEffectiveInstagramMediaId = null;
  @SerializedName("effective_instagram_story_id")
  private String mEffectiveInstagramStoryId = null;
  @SerializedName("effective_object_story_id")
  private String mEffectiveObjectStoryId = null;
  @SerializedName("enable_direct_install")
  private Boolean mEnableDirectInstall = null;
  @SerializedName("enable_launch_instant_app")
  private Boolean mEnableLaunchInstantApp = null;
  @SerializedName("facebook_branded_content")
  private AdCreativeFacebookBrandedContent mFacebookBrandedContent = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("instagram_actor_id")
  private String mInstagramActorId = null;
  @SerializedName("instagram_branded_content")
  private AdCreativeInstagramBrandedContent mInstagramBrandedContent = null;
  @SerializedName("instagram_permalink_url")
  private String mInstagramPermalinkUrl = null;
  @SerializedName("instagram_story_id")
  private String mInstagramStoryId = null;
  @SerializedName("instagram_user_id")
  private String mInstagramUserId = null;
  @SerializedName("interactive_components_spec")
  private AdCreativeInteractiveComponentsSpec mInteractiveComponentsSpec = null;
  @SerializedName("link_deep_link_url")
  private String mLinkDeepLinkUrl = null;
  @SerializedName("link_destination_display_url")
  private String mLinkDestinationDisplayUrl = null;
  @SerializedName("link_og_id")
  private String mLinkOgId = null;
  @SerializedName("link_url")
  private String mLinkUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("object_store_url")
  private String mObjectStoreUrl = null;
  @SerializedName("object_story_id")
  private String mObjectStoryId = null;
  @SerializedName("object_story_spec")
  private AdCreativeObjectStorySpec mObjectStorySpec = null;
  @SerializedName("object_type")
  private EnumObjectType mObjectType = null;
  @SerializedName("object_url")
  private String mObjectUrl = null;
  @SerializedName("omnichannel_link_spec")
  private AdCreativeOmnichannelLinkSpec mOmnichannelLinkSpec = null;
  @SerializedName("page_welcome_message")
  private String mPageWelcomeMessage = null;
  @SerializedName("photo_album_source_object_story_id")
  private String mPhotoAlbumSourceObjectStoryId = null;
  @SerializedName("place_page_set_id")
  private String mPlacePageSetId = null;
  @SerializedName("platform_customizations")
  private AdCreativePlatformCustomization mPlatformCustomizations = null;
  @SerializedName("playable_asset_id")
  private String mPlayableAssetId = null;
  @SerializedName("portrait_customizations")
  private AdCreativePortraitCustomizations mPortraitCustomizations = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("recommender_settings")
  private AdCreativeRecommenderSettings mRecommenderSettings = null;
  @SerializedName("source_instagram_media_id")
  private String mSourceInstagramMediaId = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("template_url")
  private String mTemplateUrl = null;
  @SerializedName("template_url_spec")
  private AdCreativeTemplateURLSpec mTemplateUrlSpec = null;
  @SerializedName("thumbnail_id")
  private String mThumbnailId = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("use_page_actor_override")
  private Boolean mUsePageActorOverride = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("creative_id")
  private String mCreativeId = null;
  protected static Gson gson = null;

  public AdCreative() {
  }

  public AdCreative(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreative(String id, APIContext context) {
    this.mId = id;
    mCreativeId = mId.toString();

    this.context = context;
  }

  public AdCreative fetch() throws APIException{
    AdCreative newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    mCreativeId = mId.toString();
    return this;
  }

  public static AdCreative fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreative> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreative fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreative> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreative> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreative>)(
      new APIRequest<AdCreative>(context, "", "/", "GET", AdCreative.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreative>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreative.getParser())
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
  public static AdCreative loadJSON(String json, APIContext context, String header) {
    AdCreative adCreative = getGson().fromJson(json, AdCreative.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreative.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreative.context = context;
    adCreative.rawValue = json;
    adCreative.header = header;
    adCreative.mCreativeId = adCreative.mId;
    return adCreative;
  }

  public static APINodeList<AdCreative> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreative> adCreatives = new APINodeList<AdCreative>(request, json, header);
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
          adCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreatives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreatives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreatives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreatives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreatives.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreatives.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreatives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreatives.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreatives;
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
              adCreatives.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreatives;
          }

          // Sixth, check if it's pure JsonObject
          adCreatives.clear();
          adCreatives.add(loadJSON(json, context, header));
          return adCreatives;
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

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCreativeInsights getCreativeInsights() {
    return new APIRequestGetCreativeInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), context);
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

  public AdCreative setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldActorId() {
    return mActorId;
  }

  public AdCreative setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdCreative setFieldAdlabels(List<AdLabel> value) {
    this.mAdlabels = value;
    return this;
  }

  public AdCreative setFieldAdlabels(String value) {
    Type type = new TypeToken<List<AdLabel>>(){}.getType();
    this.mAdlabels = AdLabel.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldApplinkTreatment() {
    return mApplinkTreatment;
  }

  public AdCreative setFieldApplinkTreatment(String value) {
    this.mApplinkTreatment = value;
    return this;
  }

  public AdAssetFeedSpec getFieldAssetFeedSpec() {
    return mAssetFeedSpec;
  }

  public AdCreative setFieldAssetFeedSpec(AdAssetFeedSpec value) {
    this.mAssetFeedSpec = value;
    return this;
  }

  public AdCreative setFieldAssetFeedSpec(String value) {
    Type type = new TypeToken<AdAssetFeedSpec>(){}.getType();
    this.mAssetFeedSpec = AdAssetFeedSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAuthorizationCategory() {
    return mAuthorizationCategory;
  }

  public AdCreative setFieldAuthorizationCategory(String value) {
    this.mAuthorizationCategory = value;
    return this;
  }

  public Boolean getFieldAutoUpdate() {
    return mAutoUpdate;
  }

  public AdCreative setFieldAutoUpdate(Boolean value) {
    this.mAutoUpdate = value;
    return this;
  }

  public String getFieldBody() {
    return mBody;
  }

  public AdCreative setFieldBody(String value) {
    this.mBody = value;
    return this;
  }

  public AdCreativeBrandedContentAds getFieldBrandedContent() {
    return mBrandedContent;
  }

  public AdCreative setFieldBrandedContent(AdCreativeBrandedContentAds value) {
    this.mBrandedContent = value;
    return this;
  }

  public AdCreative setFieldBrandedContent(String value) {
    Type type = new TypeToken<AdCreativeBrandedContentAds>(){}.getType();
    this.mBrandedContent = AdCreativeBrandedContentAds.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldBrandedContentSponsorPageId() {
    return mBrandedContentSponsorPageId;
  }

  public AdCreative setFieldBrandedContentSponsorPageId(String value) {
    this.mBrandedContentSponsorPageId = value;
    return this;
  }

  public String getFieldBundleFolderId() {
    return mBundleFolderId;
  }

  public AdCreative setFieldBundleFolderId(String value) {
    this.mBundleFolderId = value;
    return this;
  }

  public EnumCallToActionType getFieldCallToActionType() {
    return mCallToActionType;
  }

  public AdCreative setFieldCallToActionType(EnumCallToActionType value) {
    this.mCallToActionType = value;
    return this;
  }

  public String getFieldCategorizationCriteria() {
    return mCategorizationCriteria;
  }

  public AdCreative setFieldCategorizationCriteria(String value) {
    this.mCategorizationCriteria = value;
    return this;
  }

  public String getFieldCategoryMediaSource() {
    return mCategoryMediaSource;
  }

  public AdCreative setFieldCategoryMediaSource(String value) {
    this.mCategoryMediaSource = value;
    return this;
  }

  public String getFieldCollaborativeAdsLsbImageBankId() {
    return mCollaborativeAdsLsbImageBankId;
  }

  public AdCreative setFieldCollaborativeAdsLsbImageBankId(String value) {
    this.mCollaborativeAdsLsbImageBankId = value;
    return this;
  }

  public AdCreativeContextualMultiAds getFieldContextualMultiAds() {
    return mContextualMultiAds;
  }

  public AdCreative setFieldContextualMultiAds(AdCreativeContextualMultiAds value) {
    this.mContextualMultiAds = value;
    return this;
  }

  public AdCreative setFieldContextualMultiAds(String value) {
    Type type = new TypeToken<AdCreativeContextualMultiAds>(){}.getType();
    this.mContextualMultiAds = AdCreativeContextualMultiAds.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeSourcingSpec getFieldCreativeSourcingSpec() {
    return mCreativeSourcingSpec;
  }

  public AdCreative setFieldCreativeSourcingSpec(AdCreativeSourcingSpec value) {
    this.mCreativeSourcingSpec = value;
    return this;
  }

  public AdCreative setFieldCreativeSourcingSpec(String value) {
    Type type = new TypeToken<AdCreativeSourcingSpec>(){}.getType();
    this.mCreativeSourcingSpec = AdCreativeSourcingSpec.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeDegreesOfFreedomSpec getFieldDegreesOfFreedomSpec() {
    return mDegreesOfFreedomSpec;
  }

  public AdCreative setFieldDegreesOfFreedomSpec(AdCreativeDegreesOfFreedomSpec value) {
    this.mDegreesOfFreedomSpec = value;
    return this;
  }

  public AdCreative setFieldDegreesOfFreedomSpec(String value) {
    Type type = new TypeToken<AdCreativeDegreesOfFreedomSpec>(){}.getType();
    this.mDegreesOfFreedomSpec = AdCreativeDegreesOfFreedomSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDestinationSetId() {
    return mDestinationSetId;
  }

  public AdCreative setFieldDestinationSetId(String value) {
    this.mDestinationSetId = value;
    return this;
  }

  public String getFieldDynamicAdVoice() {
    return mDynamicAdVoice;
  }

  public AdCreative setFieldDynamicAdVoice(String value) {
    this.mDynamicAdVoice = value;
    return this;
  }

  public String getFieldEffectiveAuthorizationCategory() {
    return mEffectiveAuthorizationCategory;
  }

  public AdCreative setFieldEffectiveAuthorizationCategory(String value) {
    this.mEffectiveAuthorizationCategory = value;
    return this;
  }

  public String getFieldEffectiveInstagramMediaId() {
    return mEffectiveInstagramMediaId;
  }

  public AdCreative setFieldEffectiveInstagramMediaId(String value) {
    this.mEffectiveInstagramMediaId = value;
    return this;
  }

  public String getFieldEffectiveInstagramStoryId() {
    return mEffectiveInstagramStoryId;
  }

  public AdCreative setFieldEffectiveInstagramStoryId(String value) {
    this.mEffectiveInstagramStoryId = value;
    return this;
  }

  public String getFieldEffectiveObjectStoryId() {
    return mEffectiveObjectStoryId;
  }

  public AdCreative setFieldEffectiveObjectStoryId(String value) {
    this.mEffectiveObjectStoryId = value;
    return this;
  }

  public Boolean getFieldEnableDirectInstall() {
    return mEnableDirectInstall;
  }

  public AdCreative setFieldEnableDirectInstall(Boolean value) {
    this.mEnableDirectInstall = value;
    return this;
  }

  public Boolean getFieldEnableLaunchInstantApp() {
    return mEnableLaunchInstantApp;
  }

  public AdCreative setFieldEnableLaunchInstantApp(Boolean value) {
    this.mEnableLaunchInstantApp = value;
    return this;
  }

  public AdCreativeFacebookBrandedContent getFieldFacebookBrandedContent() {
    return mFacebookBrandedContent;
  }

  public AdCreative setFieldFacebookBrandedContent(AdCreativeFacebookBrandedContent value) {
    this.mFacebookBrandedContent = value;
    return this;
  }

  public AdCreative setFieldFacebookBrandedContent(String value) {
    Type type = new TypeToken<AdCreativeFacebookBrandedContent>(){}.getType();
    this.mFacebookBrandedContent = AdCreativeFacebookBrandedContent.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public AdCreative setFieldId(String value) {
    this.mId = value;
    this.mCreativeId = this.mId;
    return this;
  }

  public AdsImageCrops getFieldImageCrops() {
    return mImageCrops;
  }

  public AdCreative setFieldImageCrops(AdsImageCrops value) {
    this.mImageCrops = value;
    return this;
  }

  public AdCreative setFieldImageCrops(String value) {
    Type type = new TypeToken<AdsImageCrops>(){}.getType();
    this.mImageCrops = AdsImageCrops.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreative setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public AdCreative setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdCreative setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
    return this;
  }

  public AdCreativeInstagramBrandedContent getFieldInstagramBrandedContent() {
    return mInstagramBrandedContent;
  }

  public AdCreative setFieldInstagramBrandedContent(AdCreativeInstagramBrandedContent value) {
    this.mInstagramBrandedContent = value;
    return this;
  }

  public AdCreative setFieldInstagramBrandedContent(String value) {
    Type type = new TypeToken<AdCreativeInstagramBrandedContent>(){}.getType();
    this.mInstagramBrandedContent = AdCreativeInstagramBrandedContent.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldInstagramPermalinkUrl() {
    return mInstagramPermalinkUrl;
  }

  public AdCreative setFieldInstagramPermalinkUrl(String value) {
    this.mInstagramPermalinkUrl = value;
    return this;
  }

  public String getFieldInstagramStoryId() {
    return mInstagramStoryId;
  }

  public AdCreative setFieldInstagramStoryId(String value) {
    this.mInstagramStoryId = value;
    return this;
  }

  public String getFieldInstagramUserId() {
    return mInstagramUserId;
  }

  public AdCreative setFieldInstagramUserId(String value) {
    this.mInstagramUserId = value;
    return this;
  }

  public AdCreativeInteractiveComponentsSpec getFieldInteractiveComponentsSpec() {
    return mInteractiveComponentsSpec;
  }

  public AdCreative setFieldInteractiveComponentsSpec(AdCreativeInteractiveComponentsSpec value) {
    this.mInteractiveComponentsSpec = value;
    return this;
  }

  public AdCreative setFieldInteractiveComponentsSpec(String value) {
    Type type = new TypeToken<AdCreativeInteractiveComponentsSpec>(){}.getType();
    this.mInteractiveComponentsSpec = AdCreativeInteractiveComponentsSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLinkDeepLinkUrl() {
    return mLinkDeepLinkUrl;
  }

  public AdCreative setFieldLinkDeepLinkUrl(String value) {
    this.mLinkDeepLinkUrl = value;
    return this;
  }

  public String getFieldLinkDestinationDisplayUrl() {
    return mLinkDestinationDisplayUrl;
  }

  public AdCreative setFieldLinkDestinationDisplayUrl(String value) {
    this.mLinkDestinationDisplayUrl = value;
    return this;
  }

  public String getFieldLinkOgId() {
    return mLinkOgId;
  }

  public AdCreative setFieldLinkOgId(String value) {
    this.mLinkOgId = value;
    return this;
  }

  public String getFieldLinkUrl() {
    return mLinkUrl;
  }

  public AdCreative setFieldLinkUrl(String value) {
    this.mLinkUrl = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdCreative setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public AdCreative setFieldObjectId(String value) {
    this.mObjectId = value;
    return this;
  }

  public String getFieldObjectStoreUrl() {
    return mObjectStoreUrl;
  }

  public AdCreative setFieldObjectStoreUrl(String value) {
    this.mObjectStoreUrl = value;
    return this;
  }

  public String getFieldObjectStoryId() {
    return mObjectStoryId;
  }

  public AdCreative setFieldObjectStoryId(String value) {
    this.mObjectStoryId = value;
    return this;
  }

  public AdCreativeObjectStorySpec getFieldObjectStorySpec() {
    return mObjectStorySpec;
  }

  public AdCreative setFieldObjectStorySpec(AdCreativeObjectStorySpec value) {
    this.mObjectStorySpec = value;
    return this;
  }

  public AdCreative setFieldObjectStorySpec(String value) {
    Type type = new TypeToken<AdCreativeObjectStorySpec>(){}.getType();
    this.mObjectStorySpec = AdCreativeObjectStorySpec.getGson().fromJson(value, type);
    return this;
  }
  public EnumObjectType getFieldObjectType() {
    return mObjectType;
  }

  public AdCreative setFieldObjectType(EnumObjectType value) {
    this.mObjectType = value;
    return this;
  }

  public String getFieldObjectUrl() {
    return mObjectUrl;
  }

  public AdCreative setFieldObjectUrl(String value) {
    this.mObjectUrl = value;
    return this;
  }

  public AdCreativeOmnichannelLinkSpec getFieldOmnichannelLinkSpec() {
    return mOmnichannelLinkSpec;
  }

  public AdCreative setFieldOmnichannelLinkSpec(AdCreativeOmnichannelLinkSpec value) {
    this.mOmnichannelLinkSpec = value;
    return this;
  }

  public AdCreative setFieldOmnichannelLinkSpec(String value) {
    Type type = new TypeToken<AdCreativeOmnichannelLinkSpec>(){}.getType();
    this.mOmnichannelLinkSpec = AdCreativeOmnichannelLinkSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public AdCreative setFieldPageWelcomeMessage(String value) {
    this.mPageWelcomeMessage = value;
    return this;
  }

  public String getFieldPhotoAlbumSourceObjectStoryId() {
    return mPhotoAlbumSourceObjectStoryId;
  }

  public AdCreative setFieldPhotoAlbumSourceObjectStoryId(String value) {
    this.mPhotoAlbumSourceObjectStoryId = value;
    return this;
  }

  public String getFieldPlacePageSetId() {
    return mPlacePageSetId;
  }

  public AdCreative setFieldPlacePageSetId(String value) {
    this.mPlacePageSetId = value;
    return this;
  }

  public AdCreativePlatformCustomization getFieldPlatformCustomizations() {
    return mPlatformCustomizations;
  }

  public AdCreative setFieldPlatformCustomizations(AdCreativePlatformCustomization value) {
    this.mPlatformCustomizations = value;
    return this;
  }

  public AdCreative setFieldPlatformCustomizations(String value) {
    Type type = new TypeToken<AdCreativePlatformCustomization>(){}.getType();
    this.mPlatformCustomizations = AdCreativePlatformCustomization.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPlayableAssetId() {
    return mPlayableAssetId;
  }

  public AdCreative setFieldPlayableAssetId(String value) {
    this.mPlayableAssetId = value;
    return this;
  }

  public AdCreativePortraitCustomizations getFieldPortraitCustomizations() {
    return mPortraitCustomizations;
  }

  public AdCreative setFieldPortraitCustomizations(AdCreativePortraitCustomizations value) {
    this.mPortraitCustomizations = value;
    return this;
  }

  public AdCreative setFieldPortraitCustomizations(String value) {
    Type type = new TypeToken<AdCreativePortraitCustomizations>(){}.getType();
    this.mPortraitCustomizations = AdCreativePortraitCustomizations.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public AdCreative setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }

  public AdCreativeRecommenderSettings getFieldRecommenderSettings() {
    return mRecommenderSettings;
  }

  public AdCreative setFieldRecommenderSettings(AdCreativeRecommenderSettings value) {
    this.mRecommenderSettings = value;
    return this;
  }

  public AdCreative setFieldRecommenderSettings(String value) {
    Type type = new TypeToken<AdCreativeRecommenderSettings>(){}.getType();
    this.mRecommenderSettings = AdCreativeRecommenderSettings.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldSourceInstagramMediaId() {
    return mSourceInstagramMediaId;
  }

  public AdCreative setFieldSourceInstagramMediaId(String value) {
    this.mSourceInstagramMediaId = value;
    return this;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public AdCreative setFieldStatus(EnumStatus value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldTemplateUrl() {
    return mTemplateUrl;
  }

  public AdCreative setFieldTemplateUrl(String value) {
    this.mTemplateUrl = value;
    return this;
  }

  public AdCreativeTemplateURLSpec getFieldTemplateUrlSpec() {
    return mTemplateUrlSpec;
  }

  public AdCreative setFieldTemplateUrlSpec(AdCreativeTemplateURLSpec value) {
    this.mTemplateUrlSpec = value;
    return this;
  }

  public AdCreative setFieldTemplateUrlSpec(String value) {
    Type type = new TypeToken<AdCreativeTemplateURLSpec>(){}.getType();
    this.mTemplateUrlSpec = AdCreativeTemplateURLSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldThumbnailId() {
    return mThumbnailId;
  }

  public AdCreative setFieldThumbnailId(String value) {
    this.mThumbnailId = value;
    return this;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public AdCreative setFieldThumbnailUrl(String value) {
    this.mThumbnailUrl = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public AdCreative setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public AdCreative setFieldUrlTags(String value) {
    this.mUrlTags = value;
    return this;
  }

  public Boolean getFieldUsePageActorOverride() {
    return mUsePageActorOverride;
  }

  public AdCreative setFieldUsePageActorOverride(Boolean value) {
    this.mUsePageActorOverride = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdCreative setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
  }



  public static class APIRequestCreateAdLabel extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdCreative parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCreative> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreative> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCreative>() {
           public AdCreative apply(ResponseWrapper result) {
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

  public static class APIRequestGetCreativeInsights extends APIRequest<AdCreativeInsights> {

    APINodeList<AdCreativeInsights> lastResponse = null;
    @Override
    public APINodeList<AdCreativeInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "aesthetics",
    };

    @Override
    public APINodeList<AdCreativeInsights> parseResponse(String response, String header) throws APIException {
      return AdCreativeInsights.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdCreativeInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreativeInsights> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreativeInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreativeInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdCreativeInsights>>() {
           public APINodeList<AdCreativeInsights> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCreativeInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCreativeInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/creative_insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCreativeInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCreativeInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCreativeInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCreativeInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreativeInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCreativeInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreativeInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCreativeInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCreativeInsights requestAestheticsField () {
      return this.requestAestheticsField(true);
    }
    public APIRequestGetCreativeInsights requestAestheticsField (boolean value) {
      this.requestField("aesthetics", value);
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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "name",
      "status",
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


    public APIRequestDelete setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestDelete setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestDelete setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDelete setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestDelete setStatus (AdCreative.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestDelete setStatus (String status) {
      this.setParam("status", status);
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

  public static class APIRequestGet extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "thumbnail_height",
      "thumbnail_width",
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
    public AdCreative parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCreative> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreative> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCreative>() {
           public AdCreative apply(ResponseWrapper result) {
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


    public APIRequestGet setThumbnailHeight (Long thumbnailHeight) {
      this.setParam("thumbnail_height", thumbnailHeight);
      return this;
    }
    public APIRequestGet setThumbnailHeight (String thumbnailHeight) {
      this.setParam("thumbnail_height", thumbnailHeight);
      return this;
    }

    public APIRequestGet setThumbnailWidth (Long thumbnailWidth) {
      this.setParam("thumbnail_width", thumbnailWidth);
      return this;
    }
    public APIRequestGet setThumbnailWidth (String thumbnailWidth) {
      this.setParam("thumbnail_width", thumbnailWidth);
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
    public APIRequestGet requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGet requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGet requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGet requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGet requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGet requestAuthorizationCategoryField () {
      return this.requestAuthorizationCategoryField(true);
    }
    public APIRequestGet requestAuthorizationCategoryField (boolean value) {
      this.requestField("authorization_category", value);
      return this;
    }
    public APIRequestGet requestAutoUpdateField () {
      return this.requestAutoUpdateField(true);
    }
    public APIRequestGet requestAutoUpdateField (boolean value) {
      this.requestField("auto_update", value);
      return this;
    }
    public APIRequestGet requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGet requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGet requestBrandedContentField () {
      return this.requestBrandedContentField(true);
    }
    public APIRequestGet requestBrandedContentField (boolean value) {
      this.requestField("branded_content", value);
      return this;
    }
    public APIRequestGet requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGet requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGet requestBundleFolderIdField () {
      return this.requestBundleFolderIdField(true);
    }
    public APIRequestGet requestBundleFolderIdField (boolean value) {
      this.requestField("bundle_folder_id", value);
      return this;
    }
    public APIRequestGet requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGet requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGet requestCategorizationCriteriaField () {
      return this.requestCategorizationCriteriaField(true);
    }
    public APIRequestGet requestCategorizationCriteriaField (boolean value) {
      this.requestField("categorization_criteria", value);
      return this;
    }
    public APIRequestGet requestCategoryMediaSourceField () {
      return this.requestCategoryMediaSourceField(true);
    }
    public APIRequestGet requestCategoryMediaSourceField (boolean value) {
      this.requestField("category_media_source", value);
      return this;
    }
    public APIRequestGet requestCollaborativeAdsLsbImageBankIdField () {
      return this.requestCollaborativeAdsLsbImageBankIdField(true);
    }
    public APIRequestGet requestCollaborativeAdsLsbImageBankIdField (boolean value) {
      this.requestField("collaborative_ads_lsb_image_bank_id", value);
      return this;
    }
    public APIRequestGet requestContextualMultiAdsField () {
      return this.requestContextualMultiAdsField(true);
    }
    public APIRequestGet requestContextualMultiAdsField (boolean value) {
      this.requestField("contextual_multi_ads", value);
      return this;
    }
    public APIRequestGet requestCreativeSourcingSpecField () {
      return this.requestCreativeSourcingSpecField(true);
    }
    public APIRequestGet requestCreativeSourcingSpecField (boolean value) {
      this.requestField("creative_sourcing_spec", value);
      return this;
    }
    public APIRequestGet requestDegreesOfFreedomSpecField () {
      return this.requestDegreesOfFreedomSpecField(true);
    }
    public APIRequestGet requestDegreesOfFreedomSpecField (boolean value) {
      this.requestField("degrees_of_freedom_spec", value);
      return this;
    }
    public APIRequestGet requestDestinationSetIdField () {
      return this.requestDestinationSetIdField(true);
    }
    public APIRequestGet requestDestinationSetIdField (boolean value) {
      this.requestField("destination_set_id", value);
      return this;
    }
    public APIRequestGet requestDynamicAdVoiceField () {
      return this.requestDynamicAdVoiceField(true);
    }
    public APIRequestGet requestDynamicAdVoiceField (boolean value) {
      this.requestField("dynamic_ad_voice", value);
      return this;
    }
    public APIRequestGet requestEffectiveAuthorizationCategoryField () {
      return this.requestEffectiveAuthorizationCategoryField(true);
    }
    public APIRequestGet requestEffectiveAuthorizationCategoryField (boolean value) {
      this.requestField("effective_authorization_category", value);
      return this;
    }
    public APIRequestGet requestEffectiveInstagramMediaIdField () {
      return this.requestEffectiveInstagramMediaIdField(true);
    }
    public APIRequestGet requestEffectiveInstagramMediaIdField (boolean value) {
      this.requestField("effective_instagram_media_id", value);
      return this;
    }
    public APIRequestGet requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGet requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGet requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGet requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGet requestEnableDirectInstallField () {
      return this.requestEnableDirectInstallField(true);
    }
    public APIRequestGet requestEnableDirectInstallField (boolean value) {
      this.requestField("enable_direct_install", value);
      return this;
    }
    public APIRequestGet requestEnableLaunchInstantAppField () {
      return this.requestEnableLaunchInstantAppField(true);
    }
    public APIRequestGet requestEnableLaunchInstantAppField (boolean value) {
      this.requestField("enable_launch_instant_app", value);
      return this;
    }
    public APIRequestGet requestFacebookBrandedContentField () {
      return this.requestFacebookBrandedContentField(true);
    }
    public APIRequestGet requestFacebookBrandedContentField (boolean value) {
      this.requestField("facebook_branded_content", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGet requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGet requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGet requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGet requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGet requestInstagramBrandedContentField () {
      return this.requestInstagramBrandedContentField(true);
    }
    public APIRequestGet requestInstagramBrandedContentField (boolean value) {
      this.requestField("instagram_branded_content", value);
      return this;
    }
    public APIRequestGet requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGet requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGet requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGet requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGet requestInstagramUserIdField () {
      return this.requestInstagramUserIdField(true);
    }
    public APIRequestGet requestInstagramUserIdField (boolean value) {
      this.requestField("instagram_user_id", value);
      return this;
    }
    public APIRequestGet requestInteractiveComponentsSpecField () {
      return this.requestInteractiveComponentsSpecField(true);
    }
    public APIRequestGet requestInteractiveComponentsSpecField (boolean value) {
      this.requestField("interactive_components_spec", value);
      return this;
    }
    public APIRequestGet requestLinkDeepLinkUrlField () {
      return this.requestLinkDeepLinkUrlField(true);
    }
    public APIRequestGet requestLinkDeepLinkUrlField (boolean value) {
      this.requestField("link_deep_link_url", value);
      return this;
    }
    public APIRequestGet requestLinkDestinationDisplayUrlField () {
      return this.requestLinkDestinationDisplayUrlField(true);
    }
    public APIRequestGet requestLinkDestinationDisplayUrlField (boolean value) {
      this.requestField("link_destination_display_url", value);
      return this;
    }
    public APIRequestGet requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGet requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGet requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGet requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGet requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGet requestObjectStoreUrlField () {
      return this.requestObjectStoreUrlField(true);
    }
    public APIRequestGet requestObjectStoreUrlField (boolean value) {
      this.requestField("object_store_url", value);
      return this;
    }
    public APIRequestGet requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGet requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGet requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGet requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGet requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGet requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGet requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGet requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGet requestOmnichannelLinkSpecField () {
      return this.requestOmnichannelLinkSpecField(true);
    }
    public APIRequestGet requestOmnichannelLinkSpecField (boolean value) {
      this.requestField("omnichannel_link_spec", value);
      return this;
    }
    public APIRequestGet requestPageWelcomeMessageField () {
      return this.requestPageWelcomeMessageField(true);
    }
    public APIRequestGet requestPageWelcomeMessageField (boolean value) {
      this.requestField("page_welcome_message", value);
      return this;
    }
    public APIRequestGet requestPhotoAlbumSourceObjectStoryIdField () {
      return this.requestPhotoAlbumSourceObjectStoryIdField(true);
    }
    public APIRequestGet requestPhotoAlbumSourceObjectStoryIdField (boolean value) {
      this.requestField("photo_album_source_object_story_id", value);
      return this;
    }
    public APIRequestGet requestPlacePageSetIdField () {
      return this.requestPlacePageSetIdField(true);
    }
    public APIRequestGet requestPlacePageSetIdField (boolean value) {
      this.requestField("place_page_set_id", value);
      return this;
    }
    public APIRequestGet requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGet requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGet requestPlayableAssetIdField () {
      return this.requestPlayableAssetIdField(true);
    }
    public APIRequestGet requestPlayableAssetIdField (boolean value) {
      this.requestField("playable_asset_id", value);
      return this;
    }
    public APIRequestGet requestPortraitCustomizationsField () {
      return this.requestPortraitCustomizationsField(true);
    }
    public APIRequestGet requestPortraitCustomizationsField (boolean value) {
      this.requestField("portrait_customizations", value);
      return this;
    }
    public APIRequestGet requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGet requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGet requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGet requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGet requestSourceInstagramMediaIdField () {
      return this.requestSourceInstagramMediaIdField(true);
    }
    public APIRequestGet requestSourceInstagramMediaIdField (boolean value) {
      this.requestField("source_instagram_media_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGet requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGet requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGet requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGet requestThumbnailIdField () {
      return this.requestThumbnailIdField(true);
    }
    public APIRequestGet requestThumbnailIdField (boolean value) {
      this.requestField("thumbnail_id", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGet requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGet requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGet requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGet requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGet requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "name",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdCreative parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCreative> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreative> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCreative>() {
           public AdCreative apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAccountId (String accountId) {
      this.setParam("account_id", accountId);
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

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setStatus (AdCreative.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
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

  public static enum EnumCallToActionType {
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("ASK_ABOUT_SERVICES")
      VALUE_ASK_ABOUT_SERVICES("ASK_ABOUT_SERVICES"),
      @SerializedName("ASK_FOR_MORE_INFO")
      VALUE_ASK_FOR_MORE_INFO("ASK_FOR_MORE_INFO"),
      @SerializedName("AUDIO_CALL")
      VALUE_AUDIO_CALL("AUDIO_CALL"),
      @SerializedName("BOOK_A_CONSULTATION")
      VALUE_BOOK_A_CONSULTATION("BOOK_A_CONSULTATION"),
      @SerializedName("BOOK_NOW")
      VALUE_BOOK_NOW("BOOK_NOW"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("BUY_VIA_MESSAGE")
      VALUE_BUY_VIA_MESSAGE("BUY_VIA_MESSAGE"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("CALL_NOW")
      VALUE_CALL_NOW("CALL_NOW"),
      @SerializedName("CHAT_WITH_US")
      VALUE_CHAT_WITH_US("CHAT_WITH_US"),
      @SerializedName("CONFIRM")
      VALUE_CONFIRM("CONFIRM"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("FIND_A_GROUP")
      VALUE_FIND_A_GROUP("FIND_A_GROUP"),
      @SerializedName("FIND_YOUR_GROUPS")
      VALUE_FIND_YOUR_GROUPS("FIND_YOUR_GROUPS"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      @SerializedName("FOLLOW_PAGE")
      VALUE_FOLLOW_PAGE("FOLLOW_PAGE"),
      @SerializedName("FOLLOW_USER")
      VALUE_FOLLOW_USER("FOLLOW_USER"),
      @SerializedName("GET_A_QUOTE")
      VALUE_GET_A_QUOTE("GET_A_QUOTE"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("GET_PROMOTIONS")
      VALUE_GET_PROMOTIONS("GET_PROMOTIONS"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("GET_STARTED")
      VALUE_GET_STARTED("GET_STARTED"),
      @SerializedName("INQUIRE_NOW")
      VALUE_INQUIRE_NOW("INQUIRE_NOW"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("JOIN_CHANNEL")
      VALUE_JOIN_CHANNEL("JOIN_CHANNEL"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("MAKE_AN_APPOINTMENT")
      VALUE_MAKE_AN_APPOINTMENT("MAKE_AN_APPOINTMENT"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("OPEN_INSTANT_APP")
      VALUE_OPEN_INSTANT_APP("OPEN_INSTANT_APP"),
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("PAY_TO_ACCESS")
      VALUE_PAY_TO_ACCESS("PAY_TO_ACCESS"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("PLAY_GAME_ON_FACEBOOK")
      VALUE_PLAY_GAME_ON_FACEBOOK("PLAY_GAME_ON_FACEBOOK"),
      @SerializedName("PURCHASE_GIFT_CARDS")
      VALUE_PURCHASE_GIFT_CARDS("PURCHASE_GIFT_CARDS"),
      @SerializedName("RAISE_MONEY")
      VALUE_RAISE_MONEY("RAISE_MONEY"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("REFER_FRIENDS")
      VALUE_REFER_FRIENDS("REFER_FRIENDS"),
      @SerializedName("REQUEST_TIME")
      VALUE_REQUEST_TIME("REQUEST_TIME"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SEE_MORE")
      VALUE_SEE_MORE("SEE_MORE"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SEND_A_GIFT")
      VALUE_SEND_A_GIFT("SEND_A_GIFT"),
      @SerializedName("SEND_GIFT_MONEY")
      VALUE_SEND_GIFT_MONEY("SEND_GIFT_MONEY"),
      @SerializedName("SEND_UPDATES")
      VALUE_SEND_UPDATES("SEND_UPDATES"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("SOTTO_SUBSCRIBE")
      VALUE_SOTTO_SUBSCRIBE("SOTTO_SUBSCRIBE"),
      @SerializedName("START_ORDER")
      VALUE_START_ORDER("START_ORDER"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SWIPE_UP_PRODUCT")
      VALUE_SWIPE_UP_PRODUCT("SWIPE_UP_PRODUCT"),
      @SerializedName("SWIPE_UP_SHOP")
      VALUE_SWIPE_UP_SHOP("SWIPE_UP_SHOP"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("VIDEO_CALL")
      VALUE_VIDEO_CALL("VIDEO_CALL"),
      @SerializedName("VIEW_PRODUCT")
      VALUE_VIEW_PRODUCT("VIEW_PRODUCT"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      ;

      private String value;

      private EnumCallToActionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjectType {
      @SerializedName("APPLICATION")
      VALUE_APPLICATION("APPLICATION"),
      @SerializedName("DOMAIN")
      VALUE_DOMAIN("DOMAIN"),
      @SerializedName("EVENT")
      VALUE_EVENT("EVENT"),
      @SerializedName("INVALID")
      VALUE_INVALID("INVALID"),
      @SerializedName("OFFER")
      VALUE_OFFER("OFFER"),
      @SerializedName("PAGE")
      VALUE_PAGE("PAGE"),
      @SerializedName("PHOTO")
      VALUE_PHOTO("PHOTO"),
      @SerializedName("POST_DELETED")
      VALUE_POST_DELETED("POST_DELETED"),
      @SerializedName("PRIVACY_CHECK_FAIL")
      VALUE_PRIVACY_CHECK_FAIL("PRIVACY_CHECK_FAIL"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("STATUS")
      VALUE_STATUS("STATUS"),
      @SerializedName("STORE_ITEM")
      VALUE_STORE_ITEM("STORE_ITEM"),
      @SerializedName("VIDEO")
      VALUE_VIDEO("VIDEO"),
      ;

      private String value;

      private EnumObjectType(String value) {
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
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("IN_PROCESS")
      VALUE_IN_PROCESS("IN_PROCESS"),
      @SerializedName("WITH_ISSUES")
      VALUE_WITH_ISSUES("WITH_ISSUES"),
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

  public static enum EnumApplinkTreatment {
      @SerializedName("automatic")
      VALUE_AUTOMATIC("automatic"),
      @SerializedName("deeplink_with_appstore_fallback")
      VALUE_DEEPLINK_WITH_APPSTORE_FALLBACK("deeplink_with_appstore_fallback"),
      @SerializedName("deeplink_with_web_fallback")
      VALUE_DEEPLINK_WITH_WEB_FALLBACK("deeplink_with_web_fallback"),
      @SerializedName("web_only")
      VALUE_WEB_ONLY("web_only"),
      ;

      private String value;

      private EnumApplinkTreatment(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAuthorizationCategory {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("POLITICAL")
      VALUE_POLITICAL("POLITICAL"),
      @SerializedName("POLITICAL_WITH_DIGITALLY_CREATED_MEDIA")
      VALUE_POLITICAL_WITH_DIGITALLY_CREATED_MEDIA("POLITICAL_WITH_DIGITALLY_CREATED_MEDIA"),
      ;

      private String value;

      private EnumAuthorizationCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCategorizationCriteria {
      @SerializedName("brand")
      VALUE_BRAND("brand"),
      @SerializedName("category")
      VALUE_CATEGORY("category"),
      @SerializedName("product_type")
      VALUE_PRODUCT_TYPE("product_type"),
      ;

      private String value;

      private EnumCategorizationCriteria(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCategoryMediaSource {
      @SerializedName("CATEGORY")
      VALUE_CATEGORY("CATEGORY"),
      @SerializedName("MIXED")
      VALUE_MIXED("MIXED"),
      @SerializedName("PRODUCTS_COLLAGE")
      VALUE_PRODUCTS_COLLAGE("PRODUCTS_COLLAGE"),
      @SerializedName("PRODUCTS_SLIDESHOW")
      VALUE_PRODUCTS_SLIDESHOW("PRODUCTS_SLIDESHOW"),
      ;

      private String value;

      private EnumCategoryMediaSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDynamicAdVoice {
      @SerializedName("DYNAMIC")
      VALUE_DYNAMIC("DYNAMIC"),
      @SerializedName("STORY_OWNER")
      VALUE_STORY_OWNER("STORY_OWNER"),
      ;

      private String value;

      private EnumDynamicAdVoice(String value) {
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

  public AdCreative copyFrom(AdCreative instance) {
    this.mAccountId = instance.mAccountId;
    this.mActorId = instance.mActorId;
    this.mAdlabels = instance.mAdlabels;
    this.mApplinkTreatment = instance.mApplinkTreatment;
    this.mAssetFeedSpec = instance.mAssetFeedSpec;
    this.mAuthorizationCategory = instance.mAuthorizationCategory;
    this.mAutoUpdate = instance.mAutoUpdate;
    this.mBody = instance.mBody;
    this.mBrandedContent = instance.mBrandedContent;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mBundleFolderId = instance.mBundleFolderId;
    this.mCallToActionType = instance.mCallToActionType;
    this.mCategorizationCriteria = instance.mCategorizationCriteria;
    this.mCategoryMediaSource = instance.mCategoryMediaSource;
    this.mCollaborativeAdsLsbImageBankId = instance.mCollaborativeAdsLsbImageBankId;
    this.mContextualMultiAds = instance.mContextualMultiAds;
    this.mCreativeSourcingSpec = instance.mCreativeSourcingSpec;
    this.mDegreesOfFreedomSpec = instance.mDegreesOfFreedomSpec;
    this.mDestinationSetId = instance.mDestinationSetId;
    this.mDynamicAdVoice = instance.mDynamicAdVoice;
    this.mEffectiveAuthorizationCategory = instance.mEffectiveAuthorizationCategory;
    this.mEffectiveInstagramMediaId = instance.mEffectiveInstagramMediaId;
    this.mEffectiveInstagramStoryId = instance.mEffectiveInstagramStoryId;
    this.mEffectiveObjectStoryId = instance.mEffectiveObjectStoryId;
    this.mEnableDirectInstall = instance.mEnableDirectInstall;
    this.mEnableLaunchInstantApp = instance.mEnableLaunchInstantApp;
    this.mFacebookBrandedContent = instance.mFacebookBrandedContent;
    this.mId = instance.mId;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mInstagramBrandedContent = instance.mInstagramBrandedContent;
    this.mInstagramPermalinkUrl = instance.mInstagramPermalinkUrl;
    this.mInstagramStoryId = instance.mInstagramStoryId;
    this.mInstagramUserId = instance.mInstagramUserId;
    this.mInteractiveComponentsSpec = instance.mInteractiveComponentsSpec;
    this.mLinkDeepLinkUrl = instance.mLinkDeepLinkUrl;
    this.mLinkDestinationDisplayUrl = instance.mLinkDestinationDisplayUrl;
    this.mLinkOgId = instance.mLinkOgId;
    this.mLinkUrl = instance.mLinkUrl;
    this.mName = instance.mName;
    this.mObjectId = instance.mObjectId;
    this.mObjectStoreUrl = instance.mObjectStoreUrl;
    this.mObjectStoryId = instance.mObjectStoryId;
    this.mObjectStorySpec = instance.mObjectStorySpec;
    this.mObjectType = instance.mObjectType;
    this.mObjectUrl = instance.mObjectUrl;
    this.mOmnichannelLinkSpec = instance.mOmnichannelLinkSpec;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mPhotoAlbumSourceObjectStoryId = instance.mPhotoAlbumSourceObjectStoryId;
    this.mPlacePageSetId = instance.mPlacePageSetId;
    this.mPlatformCustomizations = instance.mPlatformCustomizations;
    this.mPlayableAssetId = instance.mPlayableAssetId;
    this.mPortraitCustomizations = instance.mPortraitCustomizations;
    this.mProductSetId = instance.mProductSetId;
    this.mRecommenderSettings = instance.mRecommenderSettings;
    this.mSourceInstagramMediaId = instance.mSourceInstagramMediaId;
    this.mStatus = instance.mStatus;
    this.mTemplateUrl = instance.mTemplateUrl;
    this.mTemplateUrlSpec = instance.mTemplateUrlSpec;
    this.mThumbnailId = instance.mThumbnailId;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTitle = instance.mTitle;
    this.mUrlTags = instance.mUrlTags;
    this.mUsePageActorOverride = instance.mUsePageActorOverride;
    this.mVideoId = instance.mVideoId;
    this.mCreativeId = this.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreative> getParser() {
    return new APIRequest.ResponseParser<AdCreative>() {
      public APINodeList<AdCreative> parseResponse(String response, APIContext context, APIRequest<AdCreative> request, String header) throws MalformedResponseException {
        return AdCreative.parseResponse(response, context, request, header);
      }
    };
  }
}
