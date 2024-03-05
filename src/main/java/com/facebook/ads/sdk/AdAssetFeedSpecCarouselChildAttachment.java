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
public class AdAssetFeedSpecCarouselChildAttachment extends APINode {
  @SerializedName("body_label")
  private AdAssetFeedSpecAssetLabel mBodyLabel = null;
  @SerializedName("call_to_action_type_label")
  private AdAssetFeedSpecAssetLabel mCallToActionTypeLabel = null;
  @SerializedName("caption_label")
  private AdAssetFeedSpecAssetLabel mCaptionLabel = null;
  @SerializedName("description_label")
  private AdAssetFeedSpecAssetLabel mDescriptionLabel = null;
  @SerializedName("image_label")
  private AdAssetFeedSpecAssetLabel mImageLabel = null;
  @SerializedName("link_url_label")
  private AdAssetFeedSpecAssetLabel mLinkUrlLabel = null;
  @SerializedName("phone_data_ids_label")
  private AdAssetFeedSpecAssetLabel mPhoneDataIdsLabel = null;
  @SerializedName("static_card")
  private Boolean mStaticCard = null;
  @SerializedName("title_label")
  private AdAssetFeedSpecAssetLabel mTitleLabel = null;
  @SerializedName("video_label")
  private AdAssetFeedSpecAssetLabel mVideoLabel = null;
  protected static Gson gson = null;

  public AdAssetFeedSpecCarouselChildAttachment() {
  }

  public String getId() {
    return null;
  }
  public static AdAssetFeedSpecCarouselChildAttachment loadJSON(String json, APIContext context, String header) {
    AdAssetFeedSpecCarouselChildAttachment adAssetFeedSpecCarouselChildAttachment = getGson().fromJson(json, AdAssetFeedSpecCarouselChildAttachment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeedSpecCarouselChildAttachment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAssetFeedSpecCarouselChildAttachment.context = context;
    adAssetFeedSpecCarouselChildAttachment.rawValue = json;
    adAssetFeedSpecCarouselChildAttachment.header = header;
    return adAssetFeedSpecCarouselChildAttachment;
  }

  public static APINodeList<AdAssetFeedSpecCarouselChildAttachment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAssetFeedSpecCarouselChildAttachment> adAssetFeedSpecCarouselChildAttachments = new APINodeList<AdAssetFeedSpecCarouselChildAttachment>(request, json, header);
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
          adAssetFeedSpecCarouselChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAssetFeedSpecCarouselChildAttachments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetFeedSpecCarouselChildAttachments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetFeedSpecCarouselChildAttachments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetFeedSpecCarouselChildAttachments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeedSpecCarouselChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAssetFeedSpecCarouselChildAttachments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeedSpecCarouselChildAttachments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAssetFeedSpecCarouselChildAttachments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeedSpecCarouselChildAttachments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAssetFeedSpecCarouselChildAttachments;
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
              adAssetFeedSpecCarouselChildAttachments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeedSpecCarouselChildAttachments;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeedSpecCarouselChildAttachments.clear();
          adAssetFeedSpecCarouselChildAttachments.add(loadJSON(json, context, header));
          return adAssetFeedSpecCarouselChildAttachments;
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


  public AdAssetFeedSpecAssetLabel getFieldBodyLabel() {
    return mBodyLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldBodyLabel(AdAssetFeedSpecAssetLabel value) {
    this.mBodyLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldBodyLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mBodyLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldCallToActionTypeLabel() {
    return mCallToActionTypeLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldCallToActionTypeLabel(AdAssetFeedSpecAssetLabel value) {
    this.mCallToActionTypeLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldCallToActionTypeLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mCallToActionTypeLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldCaptionLabel() {
    return mCaptionLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldCaptionLabel(AdAssetFeedSpecAssetLabel value) {
    this.mCaptionLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldCaptionLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mCaptionLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldDescriptionLabel() {
    return mDescriptionLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldDescriptionLabel(AdAssetFeedSpecAssetLabel value) {
    this.mDescriptionLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldDescriptionLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mDescriptionLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldImageLabel() {
    return mImageLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldImageLabel(AdAssetFeedSpecAssetLabel value) {
    this.mImageLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldImageLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mImageLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldLinkUrlLabel() {
    return mLinkUrlLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldLinkUrlLabel(AdAssetFeedSpecAssetLabel value) {
    this.mLinkUrlLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldLinkUrlLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mLinkUrlLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldPhoneDataIdsLabel() {
    return mPhoneDataIdsLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldPhoneDataIdsLabel(AdAssetFeedSpecAssetLabel value) {
    this.mPhoneDataIdsLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldPhoneDataIdsLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mPhoneDataIdsLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldStaticCard() {
    return mStaticCard;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldStaticCard(Boolean value) {
    this.mStaticCard = value;
    return this;
  }

  public AdAssetFeedSpecAssetLabel getFieldTitleLabel() {
    return mTitleLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldTitleLabel(AdAssetFeedSpecAssetLabel value) {
    this.mTitleLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldTitleLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mTitleLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldVideoLabel() {
    return mVideoLabel;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldVideoLabel(AdAssetFeedSpecAssetLabel value) {
    this.mVideoLabel = value;
    return this;
  }

  public AdAssetFeedSpecCarouselChildAttachment setFieldVideoLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mVideoLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
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

  public AdAssetFeedSpecCarouselChildAttachment copyFrom(AdAssetFeedSpecCarouselChildAttachment instance) {
    this.mBodyLabel = instance.mBodyLabel;
    this.mCallToActionTypeLabel = instance.mCallToActionTypeLabel;
    this.mCaptionLabel = instance.mCaptionLabel;
    this.mDescriptionLabel = instance.mDescriptionLabel;
    this.mImageLabel = instance.mImageLabel;
    this.mLinkUrlLabel = instance.mLinkUrlLabel;
    this.mPhoneDataIdsLabel = instance.mPhoneDataIdsLabel;
    this.mStaticCard = instance.mStaticCard;
    this.mTitleLabel = instance.mTitleLabel;
    this.mVideoLabel = instance.mVideoLabel;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeedSpecCarouselChildAttachment> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeedSpecCarouselChildAttachment>() {
      public APINodeList<AdAssetFeedSpecCarouselChildAttachment> parseResponse(String response, APIContext context, APIRequest<AdAssetFeedSpecCarouselChildAttachment> request, String header) throws MalformedResponseException {
        return AdAssetFeedSpecCarouselChildAttachment.parseResponse(response, context, request, header);
      }
    };
  }
}
