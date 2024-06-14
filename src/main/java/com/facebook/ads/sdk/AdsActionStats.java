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
public class AdsActionStats extends APINode {
  @SerializedName("1d_click")
  private String m1dClick = null;
  @SerializedName("1d_click_all_conversions")
  private String m1dClickAllConversions = null;
  @SerializedName("1d_click_first_conversion")
  private String m1dClickFirstConversion = null;
  @SerializedName("1d_ev")
  private String m1dEv = null;
  @SerializedName("1d_ev_all_conversions")
  private String m1dEvAllConversions = null;
  @SerializedName("1d_ev_first_conversion")
  private String m1dEvFirstConversion = null;
  @SerializedName("1d_view")
  private String m1dView = null;
  @SerializedName("1d_view_all_conversions")
  private String m1dViewAllConversions = null;
  @SerializedName("1d_view_first_conversion")
  private String m1dViewFirstConversion = null;
  @SerializedName("28d_click")
  private String m28dClick = null;
  @SerializedName("28d_click_all_conversions")
  private String m28dClickAllConversions = null;
  @SerializedName("28d_click_first_conversion")
  private String m28dClickFirstConversion = null;
  @SerializedName("28d_view")
  private String m28dView = null;
  @SerializedName("28d_view_all_conversions")
  private String m28dViewAllConversions = null;
  @SerializedName("28d_view_first_conversion")
  private String m28dViewFirstConversion = null;
  @SerializedName("7d_click")
  private String m7dClick = null;
  @SerializedName("7d_click_all_conversions")
  private String m7dClickAllConversions = null;
  @SerializedName("7d_click_first_conversion")
  private String m7dClickFirstConversion = null;
  @SerializedName("7d_view")
  private String m7dView = null;
  @SerializedName("7d_view_all_conversions")
  private String m7dViewAllConversions = null;
  @SerializedName("7d_view_first_conversion")
  private String m7dViewFirstConversion = null;
  @SerializedName("action_brand")
  private String mActionBrand = null;
  @SerializedName("action_canvas_component_id")
  private String mActionCanvasComponentId = null;
  @SerializedName("action_canvas_component_name")
  private String mActionCanvasComponentName = null;
  @SerializedName("action_carousel_card_id")
  private String mActionCarouselCardId = null;
  @SerializedName("action_carousel_card_name")
  private String mActionCarouselCardName = null;
  @SerializedName("action_category")
  private String mActionCategory = null;
  @SerializedName("action_converted_product_id")
  private String mActionConvertedProductId = null;
  @SerializedName("action_destination")
  private String mActionDestination = null;
  @SerializedName("action_device")
  private String mActionDevice = null;
  @SerializedName("action_event_channel")
  private String mActionEventChannel = null;
  @SerializedName("action_link_click_destination")
  private String mActionLinkClickDestination = null;
  @SerializedName("action_location_code")
  private String mActionLocationCode = null;
  @SerializedName("action_reaction")
  private String mActionReaction = null;
  @SerializedName("action_target_id")
  private String mActionTargetId = null;
  @SerializedName("action_type")
  private String mActionType = null;
  @SerializedName("action_video_asset_id")
  private String mActionVideoAssetId = null;
  @SerializedName("action_video_sound")
  private String mActionVideoSound = null;
  @SerializedName("action_video_type")
  private String mActionVideoType = null;
  @SerializedName("dda")
  private String mDda = null;
  @SerializedName("inline")
  private String mInline = null;
  @SerializedName("interactive_component_sticker_id")
  private String mInteractiveComponentStickerId = null;
  @SerializedName("interactive_component_sticker_response")
  private String mInteractiveComponentStickerResponse = null;
  @SerializedName("skan_click")
  private String mSkanClick = null;
  @SerializedName("skan_click_second_postback")
  private String mSkanClickSecondPostback = null;
  @SerializedName("skan_click_third_postback")
  private String mSkanClickThirdPostback = null;
  @SerializedName("skan_view")
  private String mSkanView = null;
  @SerializedName("skan_view_second_postback")
  private String mSkanViewSecondPostback = null;
  @SerializedName("skan_view_third_postback")
  private String mSkanViewThirdPostback = null;
  @SerializedName("value")
  private String mValue = null;
  protected static Gson gson = null;

  public AdsActionStats() {
  }

  public String getId() {
    return null;
  }
  public static AdsActionStats loadJSON(String json, APIContext context, String header) {
    AdsActionStats adsActionStats = getGson().fromJson(json, AdsActionStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsActionStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsActionStats.context = context;
    adsActionStats.rawValue = json;
    adsActionStats.header = header;
    return adsActionStats;
  }

  public static APINodeList<AdsActionStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsActionStats> adsActionStatss = new APINodeList<AdsActionStats>(request, json, header);
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
          adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsActionStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsActionStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsActionStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsActionStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsActionStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsActionStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsActionStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsActionStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsActionStatss;
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
              adsActionStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsActionStatss;
          }

          // Sixth, check if it's pure JsonObject
          adsActionStatss.clear();
          adsActionStatss.add(loadJSON(json, context, header));
          return adsActionStatss;
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


  public String getField1dClick() {
    return m1dClick;
  }

  public AdsActionStats setField1dClick(String value) {
    this.m1dClick = value;
    return this;
  }

  public String getField1dClickAllConversions() {
    return m1dClickAllConversions;
  }

  public AdsActionStats setField1dClickAllConversions(String value) {
    this.m1dClickAllConversions = value;
    return this;
  }

  public String getField1dClickFirstConversion() {
    return m1dClickFirstConversion;
  }

  public AdsActionStats setField1dClickFirstConversion(String value) {
    this.m1dClickFirstConversion = value;
    return this;
  }

  public String getField1dEv() {
    return m1dEv;
  }

  public AdsActionStats setField1dEv(String value) {
    this.m1dEv = value;
    return this;
  }

  public String getField1dEvAllConversions() {
    return m1dEvAllConversions;
  }

  public AdsActionStats setField1dEvAllConversions(String value) {
    this.m1dEvAllConversions = value;
    return this;
  }

  public String getField1dEvFirstConversion() {
    return m1dEvFirstConversion;
  }

  public AdsActionStats setField1dEvFirstConversion(String value) {
    this.m1dEvFirstConversion = value;
    return this;
  }

  public String getField1dView() {
    return m1dView;
  }

  public AdsActionStats setField1dView(String value) {
    this.m1dView = value;
    return this;
  }

  public String getField1dViewAllConversions() {
    return m1dViewAllConversions;
  }

  public AdsActionStats setField1dViewAllConversions(String value) {
    this.m1dViewAllConversions = value;
    return this;
  }

  public String getField1dViewFirstConversion() {
    return m1dViewFirstConversion;
  }

  public AdsActionStats setField1dViewFirstConversion(String value) {
    this.m1dViewFirstConversion = value;
    return this;
  }

  public String getField28dClick() {
    return m28dClick;
  }

  public AdsActionStats setField28dClick(String value) {
    this.m28dClick = value;
    return this;
  }

  public String getField28dClickAllConversions() {
    return m28dClickAllConversions;
  }

  public AdsActionStats setField28dClickAllConversions(String value) {
    this.m28dClickAllConversions = value;
    return this;
  }

  public String getField28dClickFirstConversion() {
    return m28dClickFirstConversion;
  }

  public AdsActionStats setField28dClickFirstConversion(String value) {
    this.m28dClickFirstConversion = value;
    return this;
  }

  public String getField28dView() {
    return m28dView;
  }

  public AdsActionStats setField28dView(String value) {
    this.m28dView = value;
    return this;
  }

  public String getField28dViewAllConversions() {
    return m28dViewAllConversions;
  }

  public AdsActionStats setField28dViewAllConversions(String value) {
    this.m28dViewAllConversions = value;
    return this;
  }

  public String getField28dViewFirstConversion() {
    return m28dViewFirstConversion;
  }

  public AdsActionStats setField28dViewFirstConversion(String value) {
    this.m28dViewFirstConversion = value;
    return this;
  }

  public String getField7dClick() {
    return m7dClick;
  }

  public AdsActionStats setField7dClick(String value) {
    this.m7dClick = value;
    return this;
  }

  public String getField7dClickAllConversions() {
    return m7dClickAllConversions;
  }

  public AdsActionStats setField7dClickAllConversions(String value) {
    this.m7dClickAllConversions = value;
    return this;
  }

  public String getField7dClickFirstConversion() {
    return m7dClickFirstConversion;
  }

  public AdsActionStats setField7dClickFirstConversion(String value) {
    this.m7dClickFirstConversion = value;
    return this;
  }

  public String getField7dView() {
    return m7dView;
  }

  public AdsActionStats setField7dView(String value) {
    this.m7dView = value;
    return this;
  }

  public String getField7dViewAllConversions() {
    return m7dViewAllConversions;
  }

  public AdsActionStats setField7dViewAllConversions(String value) {
    this.m7dViewAllConversions = value;
    return this;
  }

  public String getField7dViewFirstConversion() {
    return m7dViewFirstConversion;
  }

  public AdsActionStats setField7dViewFirstConversion(String value) {
    this.m7dViewFirstConversion = value;
    return this;
  }

  public String getFieldActionBrand() {
    return mActionBrand;
  }

  public AdsActionStats setFieldActionBrand(String value) {
    this.mActionBrand = value;
    return this;
  }

  public String getFieldActionCanvasComponentId() {
    return mActionCanvasComponentId;
  }

  public AdsActionStats setFieldActionCanvasComponentId(String value) {
    this.mActionCanvasComponentId = value;
    return this;
  }

  public String getFieldActionCanvasComponentName() {
    return mActionCanvasComponentName;
  }

  public AdsActionStats setFieldActionCanvasComponentName(String value) {
    this.mActionCanvasComponentName = value;
    return this;
  }

  public String getFieldActionCarouselCardId() {
    return mActionCarouselCardId;
  }

  public AdsActionStats setFieldActionCarouselCardId(String value) {
    this.mActionCarouselCardId = value;
    return this;
  }

  public String getFieldActionCarouselCardName() {
    return mActionCarouselCardName;
  }

  public AdsActionStats setFieldActionCarouselCardName(String value) {
    this.mActionCarouselCardName = value;
    return this;
  }

  public String getFieldActionCategory() {
    return mActionCategory;
  }

  public AdsActionStats setFieldActionCategory(String value) {
    this.mActionCategory = value;
    return this;
  }

  public String getFieldActionConvertedProductId() {
    return mActionConvertedProductId;
  }

  public AdsActionStats setFieldActionConvertedProductId(String value) {
    this.mActionConvertedProductId = value;
    return this;
  }

  public String getFieldActionDestination() {
    return mActionDestination;
  }

  public AdsActionStats setFieldActionDestination(String value) {
    this.mActionDestination = value;
    return this;
  }

  public String getFieldActionDevice() {
    return mActionDevice;
  }

  public AdsActionStats setFieldActionDevice(String value) {
    this.mActionDevice = value;
    return this;
  }

  public String getFieldActionEventChannel() {
    return mActionEventChannel;
  }

  public AdsActionStats setFieldActionEventChannel(String value) {
    this.mActionEventChannel = value;
    return this;
  }

  public String getFieldActionLinkClickDestination() {
    return mActionLinkClickDestination;
  }

  public AdsActionStats setFieldActionLinkClickDestination(String value) {
    this.mActionLinkClickDestination = value;
    return this;
  }

  public String getFieldActionLocationCode() {
    return mActionLocationCode;
  }

  public AdsActionStats setFieldActionLocationCode(String value) {
    this.mActionLocationCode = value;
    return this;
  }

  public String getFieldActionReaction() {
    return mActionReaction;
  }

  public AdsActionStats setFieldActionReaction(String value) {
    this.mActionReaction = value;
    return this;
  }

  public String getFieldActionTargetId() {
    return mActionTargetId;
  }

  public AdsActionStats setFieldActionTargetId(String value) {
    this.mActionTargetId = value;
    return this;
  }

  public String getFieldActionType() {
    return mActionType;
  }

  public AdsActionStats setFieldActionType(String value) {
    this.mActionType = value;
    return this;
  }

  public String getFieldActionVideoAssetId() {
    return mActionVideoAssetId;
  }

  public AdsActionStats setFieldActionVideoAssetId(String value) {
    this.mActionVideoAssetId = value;
    return this;
  }

  public String getFieldActionVideoSound() {
    return mActionVideoSound;
  }

  public AdsActionStats setFieldActionVideoSound(String value) {
    this.mActionVideoSound = value;
    return this;
  }

  public String getFieldActionVideoType() {
    return mActionVideoType;
  }

  public AdsActionStats setFieldActionVideoType(String value) {
    this.mActionVideoType = value;
    return this;
  }

  public String getFieldDda() {
    return mDda;
  }

  public AdsActionStats setFieldDda(String value) {
    this.mDda = value;
    return this;
  }

  public String getFieldInline() {
    return mInline;
  }

  public AdsActionStats setFieldInline(String value) {
    this.mInline = value;
    return this;
  }

  public String getFieldInteractiveComponentStickerId() {
    return mInteractiveComponentStickerId;
  }

  public AdsActionStats setFieldInteractiveComponentStickerId(String value) {
    this.mInteractiveComponentStickerId = value;
    return this;
  }

  public String getFieldInteractiveComponentStickerResponse() {
    return mInteractiveComponentStickerResponse;
  }

  public AdsActionStats setFieldInteractiveComponentStickerResponse(String value) {
    this.mInteractiveComponentStickerResponse = value;
    return this;
  }

  public String getFieldSkanClick() {
    return mSkanClick;
  }

  public AdsActionStats setFieldSkanClick(String value) {
    this.mSkanClick = value;
    return this;
  }

  public String getFieldSkanClickSecondPostback() {
    return mSkanClickSecondPostback;
  }

  public AdsActionStats setFieldSkanClickSecondPostback(String value) {
    this.mSkanClickSecondPostback = value;
    return this;
  }

  public String getFieldSkanClickThirdPostback() {
    return mSkanClickThirdPostback;
  }

  public AdsActionStats setFieldSkanClickThirdPostback(String value) {
    this.mSkanClickThirdPostback = value;
    return this;
  }

  public String getFieldSkanView() {
    return mSkanView;
  }

  public AdsActionStats setFieldSkanView(String value) {
    this.mSkanView = value;
    return this;
  }

  public String getFieldSkanViewSecondPostback() {
    return mSkanViewSecondPostback;
  }

  public AdsActionStats setFieldSkanViewSecondPostback(String value) {
    this.mSkanViewSecondPostback = value;
    return this;
  }

  public String getFieldSkanViewThirdPostback() {
    return mSkanViewThirdPostback;
  }

  public AdsActionStats setFieldSkanViewThirdPostback(String value) {
    this.mSkanViewThirdPostback = value;
    return this;
  }

  public String getFieldValue() {
    return mValue;
  }

  public AdsActionStats setFieldValue(String value) {
    this.mValue = value;
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

  public AdsActionStats copyFrom(AdsActionStats instance) {
    this.m1dClick = instance.m1dClick;
    this.m1dClickAllConversions = instance.m1dClickAllConversions;
    this.m1dClickFirstConversion = instance.m1dClickFirstConversion;
    this.m1dEv = instance.m1dEv;
    this.m1dEvAllConversions = instance.m1dEvAllConversions;
    this.m1dEvFirstConversion = instance.m1dEvFirstConversion;
    this.m1dView = instance.m1dView;
    this.m1dViewAllConversions = instance.m1dViewAllConversions;
    this.m1dViewFirstConversion = instance.m1dViewFirstConversion;
    this.m28dClick = instance.m28dClick;
    this.m28dClickAllConversions = instance.m28dClickAllConversions;
    this.m28dClickFirstConversion = instance.m28dClickFirstConversion;
    this.m28dView = instance.m28dView;
    this.m28dViewAllConversions = instance.m28dViewAllConversions;
    this.m28dViewFirstConversion = instance.m28dViewFirstConversion;
    this.m7dClick = instance.m7dClick;
    this.m7dClickAllConversions = instance.m7dClickAllConversions;
    this.m7dClickFirstConversion = instance.m7dClickFirstConversion;
    this.m7dView = instance.m7dView;
    this.m7dViewAllConversions = instance.m7dViewAllConversions;
    this.m7dViewFirstConversion = instance.m7dViewFirstConversion;
    this.mActionBrand = instance.mActionBrand;
    this.mActionCanvasComponentId = instance.mActionCanvasComponentId;
    this.mActionCanvasComponentName = instance.mActionCanvasComponentName;
    this.mActionCarouselCardId = instance.mActionCarouselCardId;
    this.mActionCarouselCardName = instance.mActionCarouselCardName;
    this.mActionCategory = instance.mActionCategory;
    this.mActionConvertedProductId = instance.mActionConvertedProductId;
    this.mActionDestination = instance.mActionDestination;
    this.mActionDevice = instance.mActionDevice;
    this.mActionEventChannel = instance.mActionEventChannel;
    this.mActionLinkClickDestination = instance.mActionLinkClickDestination;
    this.mActionLocationCode = instance.mActionLocationCode;
    this.mActionReaction = instance.mActionReaction;
    this.mActionTargetId = instance.mActionTargetId;
    this.mActionType = instance.mActionType;
    this.mActionVideoAssetId = instance.mActionVideoAssetId;
    this.mActionVideoSound = instance.mActionVideoSound;
    this.mActionVideoType = instance.mActionVideoType;
    this.mDda = instance.mDda;
    this.mInline = instance.mInline;
    this.mInteractiveComponentStickerId = instance.mInteractiveComponentStickerId;
    this.mInteractiveComponentStickerResponse = instance.mInteractiveComponentStickerResponse;
    this.mSkanClick = instance.mSkanClick;
    this.mSkanClickSecondPostback = instance.mSkanClickSecondPostback;
    this.mSkanClickThirdPostback = instance.mSkanClickThirdPostback;
    this.mSkanView = instance.mSkanView;
    this.mSkanViewSecondPostback = instance.mSkanViewSecondPostback;
    this.mSkanViewThirdPostback = instance.mSkanViewThirdPostback;
    this.mValue = instance.mValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsActionStats> getParser() {
    return new APIRequest.ResponseParser<AdsActionStats>() {
      public APINodeList<AdsActionStats> parseResponse(String response, APIContext context, APIRequest<AdsActionStats> request, String header) throws MalformedResponseException {
        return AdsActionStats.parseResponse(response, context, request, header);
      }
    };
  }
}
