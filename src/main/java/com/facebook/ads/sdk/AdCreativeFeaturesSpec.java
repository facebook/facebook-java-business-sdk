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
public class AdCreativeFeaturesSpec extends APINode {
  @SerializedName("adapt_to_placement")
  private AdCreativeFeatureDetails mAdaptToPlacement = null;
  @SerializedName("ads_with_benefits")
  private AdCreativeFeatureDetails mAdsWithBenefits = null;
  @SerializedName("advantage_plus_creative")
  private AdCreativeFeatureDetails mAdvantagePlusCreative = null;
  @SerializedName("app_highlights")
  private AdCreativeFeatureDetails mAppHighlights = null;
  @SerializedName("audio")
  private AdCreativeFeatureDetails mAudio = null;
  @SerializedName("carousel_to_video")
  private AdCreativeFeatureDetails mCarouselToVideo = null;
  @SerializedName("catalog_feed_tag")
  private AdCreativeFeatureDetails mCatalogFeedTag = null;
  @SerializedName("customize_product_recommendation")
  private AdCreativeFeatureDetails mCustomizeProductRecommendation = null;
  @SerializedName("cv_transformation")
  private AdCreativeFeatureDetails mCvTransformation = null;
  @SerializedName("description_automation")
  private AdCreativeFeatureDetails mDescriptionAutomation = null;
  @SerializedName("dha_optimization")
  private AdCreativeFeatureDetails mDhaOptimization = null;
  @SerializedName("feed_caption_optimization")
  private AdCreativeFeatureDetails mFeedCaptionOptimization = null;
  @SerializedName("ig_glados_feed")
  private AdCreativeFeatureDetails mIgGladosFeed = null;
  @SerializedName("image_auto_crop")
  private AdCreativeFeatureDetails mImageAutoCrop = null;
  @SerializedName("image_background_gen")
  private AdCreativeFeatureDetails mImageBackgroundGen = null;
  @SerializedName("image_brightness_and_contrast")
  private AdCreativeFeatureDetails mImageBrightnessAndContrast = null;
  @SerializedName("image_enhancement")
  private AdCreativeFeatureDetails mImageEnhancement = null;
  @SerializedName("image_templates")
  private AdCreativeFeatureDetails mImageTemplates = null;
  @SerializedName("image_touchups")
  private AdCreativeFeatureDetails mImageTouchups = null;
  @SerializedName("image_uncrop")
  private AdCreativeFeatureDetails mImageUncrop = null;
  @SerializedName("inline_comment")
  private AdCreativeFeatureDetails mInlineComment = null;
  @SerializedName("media_liquidity_animated_image")
  private AdCreativeFeatureDetails mMediaLiquidityAnimatedImage = null;
  @SerializedName("media_order")
  private AdCreativeFeatureDetails mMediaOrder = null;
  @SerializedName("media_type_automation")
  private AdCreativeFeatureDetails mMediaTypeAutomation = null;
  @SerializedName("product_extensions")
  private AdCreativeFeatureDetails mProductExtensions = null;
  @SerializedName("product_metadata_automation")
  private AdCreativeFeatureDetails mProductMetadataAutomation = null;
  @SerializedName("product_tags")
  private AdCreativeFeatureDetails mProductTags = null;
  @SerializedName("profile_card")
  private AdCreativeFeatureDetails mProfileCard = null;
  @SerializedName("site_extensions")
  private AdCreativeFeatureDetails mSiteExtensions = null;
  @SerializedName("standard_enhancements")
  private AdCreativeFeatureDetails mStandardEnhancements = null;
  @SerializedName("standard_enhancements_catalog")
  private AdCreativeFeatureDetails mStandardEnhancementsCatalog = null;
  @SerializedName("text_generation")
  private AdCreativeFeatureDetails mTextGeneration = null;
  @SerializedName("text_optimizations")
  private AdCreativeFeatureDetails mTextOptimizations = null;
  @SerializedName("video_auto_crop")
  private AdCreativeFeatureDetails mVideoAutoCrop = null;
  @SerializedName("video_filtering")
  private AdCreativeFeatureDetails mVideoFiltering = null;
  @SerializedName("video_highlight")
  private AdCreativeFeatureDetails mVideoHighlight = null;
  protected static Gson gson = null;

  public AdCreativeFeaturesSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeFeaturesSpec loadJSON(String json, APIContext context, String header) {
    AdCreativeFeaturesSpec adCreativeFeaturesSpec = getGson().fromJson(json, AdCreativeFeaturesSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeFeaturesSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeFeaturesSpec.context = context;
    adCreativeFeaturesSpec.rawValue = json;
    adCreativeFeaturesSpec.header = header;
    return adCreativeFeaturesSpec;
  }

  public static APINodeList<AdCreativeFeaturesSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeFeaturesSpec> adCreativeFeaturesSpecs = new APINodeList<AdCreativeFeaturesSpec>(request, json, header);
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
          adCreativeFeaturesSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeFeaturesSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeFeaturesSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeFeaturesSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeFeaturesSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeFeaturesSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeFeaturesSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeFeaturesSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeFeaturesSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeFeaturesSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeFeaturesSpecs;
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
              adCreativeFeaturesSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeFeaturesSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeFeaturesSpecs.clear();
          adCreativeFeaturesSpecs.add(loadJSON(json, context, header));
          return adCreativeFeaturesSpecs;
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


  public AdCreativeFeatureDetails getFieldAdaptToPlacement() {
    return mAdaptToPlacement;
  }

  public AdCreativeFeaturesSpec setFieldAdaptToPlacement(AdCreativeFeatureDetails value) {
    this.mAdaptToPlacement = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldAdaptToPlacement(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mAdaptToPlacement = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldAdsWithBenefits() {
    return mAdsWithBenefits;
  }

  public AdCreativeFeaturesSpec setFieldAdsWithBenefits(AdCreativeFeatureDetails value) {
    this.mAdsWithBenefits = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldAdsWithBenefits(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mAdsWithBenefits = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldAdvantagePlusCreative() {
    return mAdvantagePlusCreative;
  }

  public AdCreativeFeaturesSpec setFieldAdvantagePlusCreative(AdCreativeFeatureDetails value) {
    this.mAdvantagePlusCreative = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldAdvantagePlusCreative(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mAdvantagePlusCreative = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldAppHighlights() {
    return mAppHighlights;
  }

  public AdCreativeFeaturesSpec setFieldAppHighlights(AdCreativeFeatureDetails value) {
    this.mAppHighlights = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldAppHighlights(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mAppHighlights = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldAudio() {
    return mAudio;
  }

  public AdCreativeFeaturesSpec setFieldAudio(AdCreativeFeatureDetails value) {
    this.mAudio = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldAudio(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mAudio = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldCarouselToVideo() {
    return mCarouselToVideo;
  }

  public AdCreativeFeaturesSpec setFieldCarouselToVideo(AdCreativeFeatureDetails value) {
    this.mCarouselToVideo = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldCarouselToVideo(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mCarouselToVideo = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldCatalogFeedTag() {
    return mCatalogFeedTag;
  }

  public AdCreativeFeaturesSpec setFieldCatalogFeedTag(AdCreativeFeatureDetails value) {
    this.mCatalogFeedTag = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldCatalogFeedTag(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mCatalogFeedTag = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldCustomizeProductRecommendation() {
    return mCustomizeProductRecommendation;
  }

  public AdCreativeFeaturesSpec setFieldCustomizeProductRecommendation(AdCreativeFeatureDetails value) {
    this.mCustomizeProductRecommendation = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldCustomizeProductRecommendation(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mCustomizeProductRecommendation = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldCvTransformation() {
    return mCvTransformation;
  }

  public AdCreativeFeaturesSpec setFieldCvTransformation(AdCreativeFeatureDetails value) {
    this.mCvTransformation = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldCvTransformation(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mCvTransformation = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldDescriptionAutomation() {
    return mDescriptionAutomation;
  }

  public AdCreativeFeaturesSpec setFieldDescriptionAutomation(AdCreativeFeatureDetails value) {
    this.mDescriptionAutomation = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldDescriptionAutomation(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mDescriptionAutomation = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldDhaOptimization() {
    return mDhaOptimization;
  }

  public AdCreativeFeaturesSpec setFieldDhaOptimization(AdCreativeFeatureDetails value) {
    this.mDhaOptimization = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldDhaOptimization(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mDhaOptimization = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldFeedCaptionOptimization() {
    return mFeedCaptionOptimization;
  }

  public AdCreativeFeaturesSpec setFieldFeedCaptionOptimization(AdCreativeFeatureDetails value) {
    this.mFeedCaptionOptimization = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldFeedCaptionOptimization(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mFeedCaptionOptimization = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldIgGladosFeed() {
    return mIgGladosFeed;
  }

  public AdCreativeFeaturesSpec setFieldIgGladosFeed(AdCreativeFeatureDetails value) {
    this.mIgGladosFeed = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldIgGladosFeed(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mIgGladosFeed = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageAutoCrop() {
    return mImageAutoCrop;
  }

  public AdCreativeFeaturesSpec setFieldImageAutoCrop(AdCreativeFeatureDetails value) {
    this.mImageAutoCrop = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageAutoCrop(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageAutoCrop = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageBackgroundGen() {
    return mImageBackgroundGen;
  }

  public AdCreativeFeaturesSpec setFieldImageBackgroundGen(AdCreativeFeatureDetails value) {
    this.mImageBackgroundGen = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageBackgroundGen(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageBackgroundGen = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageBrightnessAndContrast() {
    return mImageBrightnessAndContrast;
  }

  public AdCreativeFeaturesSpec setFieldImageBrightnessAndContrast(AdCreativeFeatureDetails value) {
    this.mImageBrightnessAndContrast = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageBrightnessAndContrast(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageBrightnessAndContrast = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageEnhancement() {
    return mImageEnhancement;
  }

  public AdCreativeFeaturesSpec setFieldImageEnhancement(AdCreativeFeatureDetails value) {
    this.mImageEnhancement = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageEnhancement(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageEnhancement = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageTemplates() {
    return mImageTemplates;
  }

  public AdCreativeFeaturesSpec setFieldImageTemplates(AdCreativeFeatureDetails value) {
    this.mImageTemplates = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageTemplates(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageTemplates = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageTouchups() {
    return mImageTouchups;
  }

  public AdCreativeFeaturesSpec setFieldImageTouchups(AdCreativeFeatureDetails value) {
    this.mImageTouchups = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageTouchups(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageTouchups = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldImageUncrop() {
    return mImageUncrop;
  }

  public AdCreativeFeaturesSpec setFieldImageUncrop(AdCreativeFeatureDetails value) {
    this.mImageUncrop = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldImageUncrop(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mImageUncrop = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldInlineComment() {
    return mInlineComment;
  }

  public AdCreativeFeaturesSpec setFieldInlineComment(AdCreativeFeatureDetails value) {
    this.mInlineComment = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldInlineComment(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mInlineComment = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldMediaLiquidityAnimatedImage() {
    return mMediaLiquidityAnimatedImage;
  }

  public AdCreativeFeaturesSpec setFieldMediaLiquidityAnimatedImage(AdCreativeFeatureDetails value) {
    this.mMediaLiquidityAnimatedImage = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldMediaLiquidityAnimatedImage(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mMediaLiquidityAnimatedImage = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldMediaOrder() {
    return mMediaOrder;
  }

  public AdCreativeFeaturesSpec setFieldMediaOrder(AdCreativeFeatureDetails value) {
    this.mMediaOrder = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldMediaOrder(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mMediaOrder = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldMediaTypeAutomation() {
    return mMediaTypeAutomation;
  }

  public AdCreativeFeaturesSpec setFieldMediaTypeAutomation(AdCreativeFeatureDetails value) {
    this.mMediaTypeAutomation = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldMediaTypeAutomation(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mMediaTypeAutomation = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldProductExtensions() {
    return mProductExtensions;
  }

  public AdCreativeFeaturesSpec setFieldProductExtensions(AdCreativeFeatureDetails value) {
    this.mProductExtensions = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldProductExtensions(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mProductExtensions = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldProductMetadataAutomation() {
    return mProductMetadataAutomation;
  }

  public AdCreativeFeaturesSpec setFieldProductMetadataAutomation(AdCreativeFeatureDetails value) {
    this.mProductMetadataAutomation = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldProductMetadataAutomation(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mProductMetadataAutomation = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldProductTags() {
    return mProductTags;
  }

  public AdCreativeFeaturesSpec setFieldProductTags(AdCreativeFeatureDetails value) {
    this.mProductTags = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldProductTags(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mProductTags = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldProfileCard() {
    return mProfileCard;
  }

  public AdCreativeFeaturesSpec setFieldProfileCard(AdCreativeFeatureDetails value) {
    this.mProfileCard = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldProfileCard(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mProfileCard = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldSiteExtensions() {
    return mSiteExtensions;
  }

  public AdCreativeFeaturesSpec setFieldSiteExtensions(AdCreativeFeatureDetails value) {
    this.mSiteExtensions = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldSiteExtensions(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mSiteExtensions = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldStandardEnhancements() {
    return mStandardEnhancements;
  }

  public AdCreativeFeaturesSpec setFieldStandardEnhancements(AdCreativeFeatureDetails value) {
    this.mStandardEnhancements = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldStandardEnhancements(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mStandardEnhancements = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldStandardEnhancementsCatalog() {
    return mStandardEnhancementsCatalog;
  }

  public AdCreativeFeaturesSpec setFieldStandardEnhancementsCatalog(AdCreativeFeatureDetails value) {
    this.mStandardEnhancementsCatalog = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldStandardEnhancementsCatalog(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mStandardEnhancementsCatalog = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldTextGeneration() {
    return mTextGeneration;
  }

  public AdCreativeFeaturesSpec setFieldTextGeneration(AdCreativeFeatureDetails value) {
    this.mTextGeneration = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldTextGeneration(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mTextGeneration = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldTextOptimizations() {
    return mTextOptimizations;
  }

  public AdCreativeFeaturesSpec setFieldTextOptimizations(AdCreativeFeatureDetails value) {
    this.mTextOptimizations = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldTextOptimizations(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mTextOptimizations = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldVideoAutoCrop() {
    return mVideoAutoCrop;
  }

  public AdCreativeFeaturesSpec setFieldVideoAutoCrop(AdCreativeFeatureDetails value) {
    this.mVideoAutoCrop = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldVideoAutoCrop(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mVideoAutoCrop = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldVideoFiltering() {
    return mVideoFiltering;
  }

  public AdCreativeFeaturesSpec setFieldVideoFiltering(AdCreativeFeatureDetails value) {
    this.mVideoFiltering = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldVideoFiltering(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mVideoFiltering = AdCreativeFeatureDetails.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeFeatureDetails getFieldVideoHighlight() {
    return mVideoHighlight;
  }

  public AdCreativeFeaturesSpec setFieldVideoHighlight(AdCreativeFeatureDetails value) {
    this.mVideoHighlight = value;
    return this;
  }

  public AdCreativeFeaturesSpec setFieldVideoHighlight(String value) {
    Type type = new TypeToken<AdCreativeFeatureDetails>(){}.getType();
    this.mVideoHighlight = AdCreativeFeatureDetails.getGson().fromJson(value, type);
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

  public AdCreativeFeaturesSpec copyFrom(AdCreativeFeaturesSpec instance) {
    this.mAdaptToPlacement = instance.mAdaptToPlacement;
    this.mAdsWithBenefits = instance.mAdsWithBenefits;
    this.mAdvantagePlusCreative = instance.mAdvantagePlusCreative;
    this.mAppHighlights = instance.mAppHighlights;
    this.mAudio = instance.mAudio;
    this.mCarouselToVideo = instance.mCarouselToVideo;
    this.mCatalogFeedTag = instance.mCatalogFeedTag;
    this.mCustomizeProductRecommendation = instance.mCustomizeProductRecommendation;
    this.mCvTransformation = instance.mCvTransformation;
    this.mDescriptionAutomation = instance.mDescriptionAutomation;
    this.mDhaOptimization = instance.mDhaOptimization;
    this.mFeedCaptionOptimization = instance.mFeedCaptionOptimization;
    this.mIgGladosFeed = instance.mIgGladosFeed;
    this.mImageAutoCrop = instance.mImageAutoCrop;
    this.mImageBackgroundGen = instance.mImageBackgroundGen;
    this.mImageBrightnessAndContrast = instance.mImageBrightnessAndContrast;
    this.mImageEnhancement = instance.mImageEnhancement;
    this.mImageTemplates = instance.mImageTemplates;
    this.mImageTouchups = instance.mImageTouchups;
    this.mImageUncrop = instance.mImageUncrop;
    this.mInlineComment = instance.mInlineComment;
    this.mMediaLiquidityAnimatedImage = instance.mMediaLiquidityAnimatedImage;
    this.mMediaOrder = instance.mMediaOrder;
    this.mMediaTypeAutomation = instance.mMediaTypeAutomation;
    this.mProductExtensions = instance.mProductExtensions;
    this.mProductMetadataAutomation = instance.mProductMetadataAutomation;
    this.mProductTags = instance.mProductTags;
    this.mProfileCard = instance.mProfileCard;
    this.mSiteExtensions = instance.mSiteExtensions;
    this.mStandardEnhancements = instance.mStandardEnhancements;
    this.mStandardEnhancementsCatalog = instance.mStandardEnhancementsCatalog;
    this.mTextGeneration = instance.mTextGeneration;
    this.mTextOptimizations = instance.mTextOptimizations;
    this.mVideoAutoCrop = instance.mVideoAutoCrop;
    this.mVideoFiltering = instance.mVideoFiltering;
    this.mVideoHighlight = instance.mVideoHighlight;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeFeaturesSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeFeaturesSpec>() {
      public APINodeList<AdCreativeFeaturesSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeFeaturesSpec> request, String header) throws MalformedResponseException {
        return AdCreativeFeaturesSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
