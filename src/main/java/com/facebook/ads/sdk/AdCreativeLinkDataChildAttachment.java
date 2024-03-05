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
public class AdCreativeLinkDataChildAttachment extends APINode {
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("place_data")
  private AdCreativePlaceData mPlaceData = null;
  @SerializedName("static_card")
  private Boolean mStaticCard = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataChildAttachment() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataChildAttachment loadJSON(String json, APIContext context, String header) {
    AdCreativeLinkDataChildAttachment adCreativeLinkDataChildAttachment = getGson().fromJson(json, AdCreativeLinkDataChildAttachment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataChildAttachment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeLinkDataChildAttachment.context = context;
    adCreativeLinkDataChildAttachment.rawValue = json;
    adCreativeLinkDataChildAttachment.header = header;
    return adCreativeLinkDataChildAttachment;
  }

  public static APINodeList<AdCreativeLinkDataChildAttachment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataChildAttachment> adCreativeLinkDataChildAttachments = new APINodeList<AdCreativeLinkDataChildAttachment>(request, json, header);
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
          adCreativeLinkDataChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeLinkDataChildAttachments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataChildAttachments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataChildAttachments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataChildAttachments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeLinkDataChildAttachments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataChildAttachments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeLinkDataChildAttachments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataChildAttachments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeLinkDataChildAttachments;
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
              adCreativeLinkDataChildAttachments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataChildAttachments;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataChildAttachments.clear();
          adCreativeLinkDataChildAttachments.add(loadJSON(json, context, header));
          return adCreativeLinkDataChildAttachments;
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


  public AdCreativeLinkDataCallToAction getFieldCallToAction() {
    return mCallToAction;
  }

  public AdCreativeLinkDataChildAttachment setFieldCallToAction(AdCreativeLinkDataCallToAction value) {
    this.mCallToAction = value;
    return this;
  }

  public AdCreativeLinkDataChildAttachment setFieldCallToAction(String value) {
    Type type = new TypeToken<AdCreativeLinkDataCallToAction>(){}.getType();
    this.mCallToAction = AdCreativeLinkDataCallToAction.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCaption() {
    return mCaption;
  }

  public AdCreativeLinkDataChildAttachment setFieldCaption(String value) {
    this.mCaption = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdCreativeLinkDataChildAttachment setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public AdsImageCrops getFieldImageCrops() {
    return mImageCrops;
  }

  public AdCreativeLinkDataChildAttachment setFieldImageCrops(AdsImageCrops value) {
    this.mImageCrops = value;
    return this;
  }

  public AdCreativeLinkDataChildAttachment setFieldImageCrops(String value) {
    Type type = new TypeToken<AdsImageCrops>(){}.getType();
    this.mImageCrops = AdsImageCrops.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreativeLinkDataChildAttachment setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldLink() {
    return mLink;
  }

  public AdCreativeLinkDataChildAttachment setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdCreativeLinkDataChildAttachment setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public AdCreativeLinkDataChildAttachment setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public AdCreativePlaceData getFieldPlaceData() {
    return mPlaceData;
  }

  public AdCreativeLinkDataChildAttachment setFieldPlaceData(AdCreativePlaceData value) {
    this.mPlaceData = value;
    return this;
  }

  public AdCreativeLinkDataChildAttachment setFieldPlaceData(String value) {
    Type type = new TypeToken<AdCreativePlaceData>(){}.getType();
    this.mPlaceData = AdCreativePlaceData.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldStaticCard() {
    return mStaticCard;
  }

  public AdCreativeLinkDataChildAttachment setFieldStaticCard(Boolean value) {
    this.mStaticCard = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdCreativeLinkDataChildAttachment setFieldVideoId(String value) {
    this.mVideoId = value;
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

  public AdCreativeLinkDataChildAttachment copyFrom(AdCreativeLinkDataChildAttachment instance) {
    this.mCallToAction = instance.mCallToAction;
    this.mCaption = instance.mCaption;
    this.mDescription = instance.mDescription;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPicture = instance.mPicture;
    this.mPlaceData = instance.mPlaceData;
    this.mStaticCard = instance.mStaticCard;
    this.mVideoId = instance.mVideoId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataChildAttachment> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataChildAttachment>() {
      public APINodeList<AdCreativeLinkDataChildAttachment> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataChildAttachment> request, String header) throws MalformedResponseException {
        return AdCreativeLinkDataChildAttachment.parseResponse(response, context, request, header);
      }
    };
  }
}
