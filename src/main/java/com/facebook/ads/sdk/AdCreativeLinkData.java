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
public class AdCreativeLinkData extends APINode {
  @SerializedName("ad_context")
  private String mAdContext = null;
  @SerializedName("additional_image_index")
  private Long mAdditionalImageIndex = null;
  @SerializedName("app_link_spec")
  private AdCreativeLinkDataAppLinkSpec mAppLinkSpec = null;
  @SerializedName("attachment_style")
  private String mAttachmentStyle = null;
  @SerializedName("automated_product_tags")
  private Boolean mAutomatedProductTags = null;
  @SerializedName("branded_content_shared_to_sponsor_status")
  private String mBrandedContentSharedToSponsorStatus = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("child_attachments")
  private List<AdCreativeLinkDataChildAttachment> mChildAttachments = null;
  @SerializedName("collection_thumbnails")
  private List<AdCreativeCollectionThumbnailInfo> mCollectionThumbnails = null;
  @SerializedName("customization_rules_spec")
  private List<AdCustomizationRuleSpec> mCustomizationRulesSpec = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("force_single_link")
  private Boolean mForceSingleLink = null;
  @SerializedName("format_option")
  private EnumFormatOption mFormatOption = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_layer_specs")
  private List<AdCreativeLinkDataImageLayerSpec> mImageLayerSpecs = null;
  @SerializedName("image_overlay_spec")
  private AdCreativeLinkDataImageOverlaySpec mImageOverlaySpec = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("multi_share_end_card")
  private Boolean mMultiShareEndCard = null;
  @SerializedName("multi_share_optimized")
  private Boolean mMultiShareOptimized = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("page_welcome_message")
  private String mPageWelcomeMessage = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("post_click_configuration")
  private AdCreativePostClickConfiguration mPostClickConfiguration = null;
  @SerializedName("preferred_image_tags")
  private List<String> mPreferredImageTags = null;
  @SerializedName("retailer_item_ids")
  private List<String> mRetailerItemIds = null;
  @SerializedName("show_multiple_images")
  private Boolean mShowMultipleImages = null;
  @SerializedName("static_fallback_spec")
  private AdCreativeStaticFallbackSpec mStaticFallbackSpec = null;
  @SerializedName("use_flexible_image_aspect_ratio")
  private Boolean mUseFlexibleImageAspectRatio = null;
  protected static Gson gson = null;

  public AdCreativeLinkData() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkData loadJSON(String json, APIContext context, String header) {
    AdCreativeLinkData adCreativeLinkData = getGson().fromJson(json, AdCreativeLinkData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeLinkData.context = context;
    adCreativeLinkData.rawValue = json;
    adCreativeLinkData.header = header;
    return adCreativeLinkData;
  }

  public static APINodeList<AdCreativeLinkData> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeLinkData> adCreativeLinkDatas = new APINodeList<AdCreativeLinkData>(request, json, header);
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
          adCreativeLinkDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeLinkDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeLinkDatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeLinkDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeLinkDatas;
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
              adCreativeLinkDatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDatas;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDatas.clear();
          adCreativeLinkDatas.add(loadJSON(json, context, header));
          return adCreativeLinkDatas;
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


  public String getFieldAdContext() {
    return mAdContext;
  }

  public AdCreativeLinkData setFieldAdContext(String value) {
    this.mAdContext = value;
    return this;
  }

  public Long getFieldAdditionalImageIndex() {
    return mAdditionalImageIndex;
  }

  public AdCreativeLinkData setFieldAdditionalImageIndex(Long value) {
    this.mAdditionalImageIndex = value;
    return this;
  }

  public AdCreativeLinkDataAppLinkSpec getFieldAppLinkSpec() {
    return mAppLinkSpec;
  }

  public AdCreativeLinkData setFieldAppLinkSpec(AdCreativeLinkDataAppLinkSpec value) {
    this.mAppLinkSpec = value;
    return this;
  }

  public AdCreativeLinkData setFieldAppLinkSpec(String value) {
    Type type = new TypeToken<AdCreativeLinkDataAppLinkSpec>(){}.getType();
    this.mAppLinkSpec = AdCreativeLinkDataAppLinkSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldAttachmentStyle() {
    return mAttachmentStyle;
  }

  public AdCreativeLinkData setFieldAttachmentStyle(String value) {
    this.mAttachmentStyle = value;
    return this;
  }

  public Boolean getFieldAutomatedProductTags() {
    return mAutomatedProductTags;
  }

  public AdCreativeLinkData setFieldAutomatedProductTags(Boolean value) {
    this.mAutomatedProductTags = value;
    return this;
  }

  public String getFieldBrandedContentSharedToSponsorStatus() {
    return mBrandedContentSharedToSponsorStatus;
  }

  public AdCreativeLinkData setFieldBrandedContentSharedToSponsorStatus(String value) {
    this.mBrandedContentSharedToSponsorStatus = value;
    return this;
  }

  public String getFieldBrandedContentSponsorPageId() {
    return mBrandedContentSponsorPageId;
  }

  public AdCreativeLinkData setFieldBrandedContentSponsorPageId(String value) {
    this.mBrandedContentSponsorPageId = value;
    return this;
  }

  public AdCreativeLinkDataCallToAction getFieldCallToAction() {
    return mCallToAction;
  }

  public AdCreativeLinkData setFieldCallToAction(AdCreativeLinkDataCallToAction value) {
    this.mCallToAction = value;
    return this;
  }

  public AdCreativeLinkData setFieldCallToAction(String value) {
    Type type = new TypeToken<AdCreativeLinkDataCallToAction>(){}.getType();
    this.mCallToAction = AdCreativeLinkDataCallToAction.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCaption() {
    return mCaption;
  }

  public AdCreativeLinkData setFieldCaption(String value) {
    this.mCaption = value;
    return this;
  }

  public List<AdCreativeLinkDataChildAttachment> getFieldChildAttachments() {
    return mChildAttachments;
  }

  public AdCreativeLinkData setFieldChildAttachments(List<AdCreativeLinkDataChildAttachment> value) {
    this.mChildAttachments = value;
    return this;
  }

  public AdCreativeLinkData setFieldChildAttachments(String value) {
    Type type = new TypeToken<List<AdCreativeLinkDataChildAttachment>>(){}.getType();
    this.mChildAttachments = AdCreativeLinkDataChildAttachment.getGson().fromJson(value, type);
    return this;
  }
  public List<AdCreativeCollectionThumbnailInfo> getFieldCollectionThumbnails() {
    return mCollectionThumbnails;
  }

  public AdCreativeLinkData setFieldCollectionThumbnails(List<AdCreativeCollectionThumbnailInfo> value) {
    this.mCollectionThumbnails = value;
    return this;
  }

  public AdCreativeLinkData setFieldCollectionThumbnails(String value) {
    Type type = new TypeToken<List<AdCreativeCollectionThumbnailInfo>>(){}.getType();
    this.mCollectionThumbnails = AdCreativeCollectionThumbnailInfo.getGson().fromJson(value, type);
    return this;
  }
  public List<AdCustomizationRuleSpec> getFieldCustomizationRulesSpec() {
    return mCustomizationRulesSpec;
  }

  public AdCreativeLinkData setFieldCustomizationRulesSpec(List<AdCustomizationRuleSpec> value) {
    this.mCustomizationRulesSpec = value;
    return this;
  }

  public AdCreativeLinkData setFieldCustomizationRulesSpec(String value) {
    Type type = new TypeToken<List<AdCustomizationRuleSpec>>(){}.getType();
    this.mCustomizationRulesSpec = AdCustomizationRuleSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDescription() {
    return mDescription;
  }

  public AdCreativeLinkData setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public AdCreativeLinkData setFieldEventId(String value) {
    this.mEventId = value;
    return this;
  }

  public Boolean getFieldForceSingleLink() {
    return mForceSingleLink;
  }

  public AdCreativeLinkData setFieldForceSingleLink(Boolean value) {
    this.mForceSingleLink = value;
    return this;
  }

  public EnumFormatOption getFieldFormatOption() {
    return mFormatOption;
  }

  public AdCreativeLinkData setFieldFormatOption(EnumFormatOption value) {
    this.mFormatOption = value;
    return this;
  }

  public AdsImageCrops getFieldImageCrops() {
    return mImageCrops;
  }

  public AdCreativeLinkData setFieldImageCrops(AdsImageCrops value) {
    this.mImageCrops = value;
    return this;
  }

  public AdCreativeLinkData setFieldImageCrops(String value) {
    Type type = new TypeToken<AdsImageCrops>(){}.getType();
    this.mImageCrops = AdsImageCrops.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreativeLinkData setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public List<AdCreativeLinkDataImageLayerSpec> getFieldImageLayerSpecs() {
    return mImageLayerSpecs;
  }

  public AdCreativeLinkData setFieldImageLayerSpecs(List<AdCreativeLinkDataImageLayerSpec> value) {
    this.mImageLayerSpecs = value;
    return this;
  }

  public AdCreativeLinkData setFieldImageLayerSpecs(String value) {
    Type type = new TypeToken<List<AdCreativeLinkDataImageLayerSpec>>(){}.getType();
    this.mImageLayerSpecs = AdCreativeLinkDataImageLayerSpec.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeLinkDataImageOverlaySpec getFieldImageOverlaySpec() {
    return mImageOverlaySpec;
  }

  public AdCreativeLinkData setFieldImageOverlaySpec(AdCreativeLinkDataImageOverlaySpec value) {
    this.mImageOverlaySpec = value;
    return this;
  }

  public AdCreativeLinkData setFieldImageOverlaySpec(String value) {
    Type type = new TypeToken<AdCreativeLinkDataImageOverlaySpec>(){}.getType();
    this.mImageOverlaySpec = AdCreativeLinkDataImageOverlaySpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLink() {
    return mLink;
  }

  public AdCreativeLinkData setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public AdCreativeLinkData setFieldMessage(String value) {
    this.mMessage = value;
    return this;
  }

  public Boolean getFieldMultiShareEndCard() {
    return mMultiShareEndCard;
  }

  public AdCreativeLinkData setFieldMultiShareEndCard(Boolean value) {
    this.mMultiShareEndCard = value;
    return this;
  }

  public Boolean getFieldMultiShareOptimized() {
    return mMultiShareOptimized;
  }

  public AdCreativeLinkData setFieldMultiShareOptimized(Boolean value) {
    this.mMultiShareOptimized = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdCreativeLinkData setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public AdCreativeLinkData setFieldOfferId(String value) {
    this.mOfferId = value;
    return this;
  }

  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public AdCreativeLinkData setFieldPageWelcomeMessage(String value) {
    this.mPageWelcomeMessage = value;
    return this;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public AdCreativeLinkData setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public AdCreativePostClickConfiguration getFieldPostClickConfiguration() {
    return mPostClickConfiguration;
  }

  public AdCreativeLinkData setFieldPostClickConfiguration(AdCreativePostClickConfiguration value) {
    this.mPostClickConfiguration = value;
    return this;
  }

  public AdCreativeLinkData setFieldPostClickConfiguration(String value) {
    Type type = new TypeToken<AdCreativePostClickConfiguration>(){}.getType();
    this.mPostClickConfiguration = AdCreativePostClickConfiguration.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldPreferredImageTags() {
    return mPreferredImageTags;
  }

  public AdCreativeLinkData setFieldPreferredImageTags(List<String> value) {
    this.mPreferredImageTags = value;
    return this;
  }

  public List<String> getFieldRetailerItemIds() {
    return mRetailerItemIds;
  }

  public AdCreativeLinkData setFieldRetailerItemIds(List<String> value) {
    this.mRetailerItemIds = value;
    return this;
  }

  public Boolean getFieldShowMultipleImages() {
    return mShowMultipleImages;
  }

  public AdCreativeLinkData setFieldShowMultipleImages(Boolean value) {
    this.mShowMultipleImages = value;
    return this;
  }

  public AdCreativeStaticFallbackSpec getFieldStaticFallbackSpec() {
    return mStaticFallbackSpec;
  }

  public AdCreativeLinkData setFieldStaticFallbackSpec(AdCreativeStaticFallbackSpec value) {
    this.mStaticFallbackSpec = value;
    return this;
  }

  public AdCreativeLinkData setFieldStaticFallbackSpec(String value) {
    Type type = new TypeToken<AdCreativeStaticFallbackSpec>(){}.getType();
    this.mStaticFallbackSpec = AdCreativeStaticFallbackSpec.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldUseFlexibleImageAspectRatio() {
    return mUseFlexibleImageAspectRatio;
  }

  public AdCreativeLinkData setFieldUseFlexibleImageAspectRatio(Boolean value) {
    this.mUseFlexibleImageAspectRatio = value;
    return this;
  }



  public static enum EnumFormatOption {
      @SerializedName("carousel_ar_effects")
      VALUE_CAROUSEL_AR_EFFECTS("carousel_ar_effects"),
      @SerializedName("carousel_images_multi_items")
      VALUE_CAROUSEL_IMAGES_MULTI_ITEMS("carousel_images_multi_items"),
      @SerializedName("carousel_images_single_item")
      VALUE_CAROUSEL_IMAGES_SINGLE_ITEM("carousel_images_single_item"),
      @SerializedName("carousel_slideshows")
      VALUE_CAROUSEL_SLIDESHOWS("carousel_slideshows"),
      @SerializedName("collection_video")
      VALUE_COLLECTION_VIDEO("collection_video"),
      @SerializedName("single_image")
      VALUE_SINGLE_IMAGE("single_image"),
      ;

      private String value;

      private EnumFormatOption(String value) {
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

  public AdCreativeLinkData copyFrom(AdCreativeLinkData instance) {
    this.mAdContext = instance.mAdContext;
    this.mAdditionalImageIndex = instance.mAdditionalImageIndex;
    this.mAppLinkSpec = instance.mAppLinkSpec;
    this.mAttachmentStyle = instance.mAttachmentStyle;
    this.mAutomatedProductTags = instance.mAutomatedProductTags;
    this.mBrandedContentSharedToSponsorStatus = instance.mBrandedContentSharedToSponsorStatus;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mCallToAction = instance.mCallToAction;
    this.mCaption = instance.mCaption;
    this.mChildAttachments = instance.mChildAttachments;
    this.mCollectionThumbnails = instance.mCollectionThumbnails;
    this.mCustomizationRulesSpec = instance.mCustomizationRulesSpec;
    this.mDescription = instance.mDescription;
    this.mEventId = instance.mEventId;
    this.mForceSingleLink = instance.mForceSingleLink;
    this.mFormatOption = instance.mFormatOption;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mImageLayerSpecs = instance.mImageLayerSpecs;
    this.mImageOverlaySpec = instance.mImageOverlaySpec;
    this.mLink = instance.mLink;
    this.mMessage = instance.mMessage;
    this.mMultiShareEndCard = instance.mMultiShareEndCard;
    this.mMultiShareOptimized = instance.mMultiShareOptimized;
    this.mName = instance.mName;
    this.mOfferId = instance.mOfferId;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mPicture = instance.mPicture;
    this.mPostClickConfiguration = instance.mPostClickConfiguration;
    this.mPreferredImageTags = instance.mPreferredImageTags;
    this.mRetailerItemIds = instance.mRetailerItemIds;
    this.mShowMultipleImages = instance.mShowMultipleImages;
    this.mStaticFallbackSpec = instance.mStaticFallbackSpec;
    this.mUseFlexibleImageAspectRatio = instance.mUseFlexibleImageAspectRatio;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkData> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkData>() {
      public APINodeList<AdCreativeLinkData> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkData> request, String header) throws MalformedResponseException {
        return AdCreativeLinkData.parseResponse(response, context, request, header);
      }
    };
  }
}
