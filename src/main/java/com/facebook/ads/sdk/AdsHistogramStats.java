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
public class AdsHistogramStats extends APINode {
  @SerializedName("1d_click")
  private List<Long> m1dClick = null;
  @SerializedName("1d_click_all_conversions")
  private List<Long> m1dClickAllConversions = null;
  @SerializedName("1d_click_first_conversion")
  private List<Long> m1dClickFirstConversion = null;
  @SerializedName("1d_ev")
  private List<Long> m1dEv = null;
  @SerializedName("1d_ev_all_conversions")
  private List<Long> m1dEvAllConversions = null;
  @SerializedName("1d_ev_first_conversion")
  private List<Long> m1dEvFirstConversion = null;
  @SerializedName("1d_view")
  private List<Long> m1dView = null;
  @SerializedName("1d_view_all_conversions")
  private List<Long> m1dViewAllConversions = null;
  @SerializedName("1d_view_first_conversion")
  private List<Long> m1dViewFirstConversion = null;
  @SerializedName("28d_click")
  private List<Long> m28dClick = null;
  @SerializedName("28d_click_all_conversions")
  private List<Long> m28dClickAllConversions = null;
  @SerializedName("28d_click_first_conversion")
  private List<Long> m28dClickFirstConversion = null;
  @SerializedName("28d_view")
  private List<Long> m28dView = null;
  @SerializedName("28d_view_all_conversions")
  private List<Long> m28dViewAllConversions = null;
  @SerializedName("28d_view_first_conversion")
  private List<Long> m28dViewFirstConversion = null;
  @SerializedName("7d_click")
  private List<Long> m7dClick = null;
  @SerializedName("7d_click_all_conversions")
  private List<Long> m7dClickAllConversions = null;
  @SerializedName("7d_click_first_conversion")
  private List<Long> m7dClickFirstConversion = null;
  @SerializedName("7d_view")
  private List<Long> m7dView = null;
  @SerializedName("7d_view_all_conversions")
  private List<Long> m7dViewAllConversions = null;
  @SerializedName("7d_view_first_conversion")
  private List<Long> m7dViewFirstConversion = null;
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
  private List<Long> mDda = null;
  @SerializedName("inline")
  private List<Long> mInline = null;
  @SerializedName("interactive_component_sticker_id")
  private String mInteractiveComponentStickerId = null;
  @SerializedName("interactive_component_sticker_response")
  private String mInteractiveComponentStickerResponse = null;
  @SerializedName("skan_click")
  private List<Long> mSkanClick = null;
  @SerializedName("skan_click_second_postback")
  private List<Long> mSkanClickSecondPostback = null;
  @SerializedName("skan_click_third_postback")
  private List<Long> mSkanClickThirdPostback = null;
  @SerializedName("skan_view")
  private List<Long> mSkanView = null;
  @SerializedName("skan_view_second_postback")
  private List<Long> mSkanViewSecondPostback = null;
  @SerializedName("skan_view_third_postback")
  private List<Long> mSkanViewThirdPostback = null;
  @SerializedName("value")
  private List<Long> mValue = null;
  protected static Gson gson = null;

  public AdsHistogramStats() {
  }

  public String getId() {
    return null;
  }
  public static AdsHistogramStats loadJSON(String json, APIContext context, String header) {
    AdsHistogramStats adsHistogramStats = getGson().fromJson(json, AdsHistogramStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsHistogramStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsHistogramStats.context = context;
    adsHistogramStats.rawValue = json;
    adsHistogramStats.header = header;
    return adsHistogramStats;
  }

  public static APINodeList<AdsHistogramStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsHistogramStats> adsHistogramStatss = new APINodeList<AdsHistogramStats>(request, json, header);
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
          adsHistogramStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsHistogramStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsHistogramStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsHistogramStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsHistogramStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsHistogramStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsHistogramStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsHistogramStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsHistogramStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsHistogramStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsHistogramStatss;
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
              adsHistogramStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsHistogramStatss;
          }

          // Sixth, check if it's pure JsonObject
          adsHistogramStatss.clear();
          adsHistogramStatss.add(loadJSON(json, context, header));
          return adsHistogramStatss;
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


  public List<Long> getField1dClick() {
    return m1dClick;
  }

  public AdsHistogramStats setField1dClick(List<Long> value) {
    this.m1dClick = value;
    return this;
  }

  public List<Long> getField1dClickAllConversions() {
    return m1dClickAllConversions;
  }

  public AdsHistogramStats setField1dClickAllConversions(List<Long> value) {
    this.m1dClickAllConversions = value;
    return this;
  }

  public List<Long> getField1dClickFirstConversion() {
    return m1dClickFirstConversion;
  }

  public AdsHistogramStats setField1dClickFirstConversion(List<Long> value) {
    this.m1dClickFirstConversion = value;
    return this;
  }

  public List<Long> getField1dEv() {
    return m1dEv;
  }

  public AdsHistogramStats setField1dEv(List<Long> value) {
    this.m1dEv = value;
    return this;
  }

  public List<Long> getField1dEvAllConversions() {
    return m1dEvAllConversions;
  }

  public AdsHistogramStats setField1dEvAllConversions(List<Long> value) {
    this.m1dEvAllConversions = value;
    return this;
  }

  public List<Long> getField1dEvFirstConversion() {
    return m1dEvFirstConversion;
  }

  public AdsHistogramStats setField1dEvFirstConversion(List<Long> value) {
    this.m1dEvFirstConversion = value;
    return this;
  }

  public List<Long> getField1dView() {
    return m1dView;
  }

  public AdsHistogramStats setField1dView(List<Long> value) {
    this.m1dView = value;
    return this;
  }

  public List<Long> getField1dViewAllConversions() {
    return m1dViewAllConversions;
  }

  public AdsHistogramStats setField1dViewAllConversions(List<Long> value) {
    this.m1dViewAllConversions = value;
    return this;
  }

  public List<Long> getField1dViewFirstConversion() {
    return m1dViewFirstConversion;
  }

  public AdsHistogramStats setField1dViewFirstConversion(List<Long> value) {
    this.m1dViewFirstConversion = value;
    return this;
  }

  public List<Long> getField28dClick() {
    return m28dClick;
  }

  public AdsHistogramStats setField28dClick(List<Long> value) {
    this.m28dClick = value;
    return this;
  }

  public List<Long> getField28dClickAllConversions() {
    return m28dClickAllConversions;
  }

  public AdsHistogramStats setField28dClickAllConversions(List<Long> value) {
    this.m28dClickAllConversions = value;
    return this;
  }

  public List<Long> getField28dClickFirstConversion() {
    return m28dClickFirstConversion;
  }

  public AdsHistogramStats setField28dClickFirstConversion(List<Long> value) {
    this.m28dClickFirstConversion = value;
    return this;
  }

  public List<Long> getField28dView() {
    return m28dView;
  }

  public AdsHistogramStats setField28dView(List<Long> value) {
    this.m28dView = value;
    return this;
  }

  public List<Long> getField28dViewAllConversions() {
    return m28dViewAllConversions;
  }

  public AdsHistogramStats setField28dViewAllConversions(List<Long> value) {
    this.m28dViewAllConversions = value;
    return this;
  }

  public List<Long> getField28dViewFirstConversion() {
    return m28dViewFirstConversion;
  }

  public AdsHistogramStats setField28dViewFirstConversion(List<Long> value) {
    this.m28dViewFirstConversion = value;
    return this;
  }

  public List<Long> getField7dClick() {
    return m7dClick;
  }

  public AdsHistogramStats setField7dClick(List<Long> value) {
    this.m7dClick = value;
    return this;
  }

  public List<Long> getField7dClickAllConversions() {
    return m7dClickAllConversions;
  }

  public AdsHistogramStats setField7dClickAllConversions(List<Long> value) {
    this.m7dClickAllConversions = value;
    return this;
  }

  public List<Long> getField7dClickFirstConversion() {
    return m7dClickFirstConversion;
  }

  public AdsHistogramStats setField7dClickFirstConversion(List<Long> value) {
    this.m7dClickFirstConversion = value;
    return this;
  }

  public List<Long> getField7dView() {
    return m7dView;
  }

  public AdsHistogramStats setField7dView(List<Long> value) {
    this.m7dView = value;
    return this;
  }

  public List<Long> getField7dViewAllConversions() {
    return m7dViewAllConversions;
  }

  public AdsHistogramStats setField7dViewAllConversions(List<Long> value) {
    this.m7dViewAllConversions = value;
    return this;
  }

  public List<Long> getField7dViewFirstConversion() {
    return m7dViewFirstConversion;
  }

  public AdsHistogramStats setField7dViewFirstConversion(List<Long> value) {
    this.m7dViewFirstConversion = value;
    return this;
  }

  public String getFieldActionBrand() {
    return mActionBrand;
  }

  public AdsHistogramStats setFieldActionBrand(String value) {
    this.mActionBrand = value;
    return this;
  }

  public String getFieldActionCanvasComponentId() {
    return mActionCanvasComponentId;
  }

  public AdsHistogramStats setFieldActionCanvasComponentId(String value) {
    this.mActionCanvasComponentId = value;
    return this;
  }

  public String getFieldActionCanvasComponentName() {
    return mActionCanvasComponentName;
  }

  public AdsHistogramStats setFieldActionCanvasComponentName(String value) {
    this.mActionCanvasComponentName = value;
    return this;
  }

  public String getFieldActionCarouselCardId() {
    return mActionCarouselCardId;
  }

  public AdsHistogramStats setFieldActionCarouselCardId(String value) {
    this.mActionCarouselCardId = value;
    return this;
  }

  public String getFieldActionCarouselCardName() {
    return mActionCarouselCardName;
  }

  public AdsHistogramStats setFieldActionCarouselCardName(String value) {
    this.mActionCarouselCardName = value;
    return this;
  }

  public String getFieldActionCategory() {
    return mActionCategory;
  }

  public AdsHistogramStats setFieldActionCategory(String value) {
    this.mActionCategory = value;
    return this;
  }

  public String getFieldActionConvertedProductId() {
    return mActionConvertedProductId;
  }

  public AdsHistogramStats setFieldActionConvertedProductId(String value) {
    this.mActionConvertedProductId = value;
    return this;
  }

  public String getFieldActionDestination() {
    return mActionDestination;
  }

  public AdsHistogramStats setFieldActionDestination(String value) {
    this.mActionDestination = value;
    return this;
  }

  public String getFieldActionDevice() {
    return mActionDevice;
  }

  public AdsHistogramStats setFieldActionDevice(String value) {
    this.mActionDevice = value;
    return this;
  }

  public String getFieldActionEventChannel() {
    return mActionEventChannel;
  }

  public AdsHistogramStats setFieldActionEventChannel(String value) {
    this.mActionEventChannel = value;
    return this;
  }

  public String getFieldActionLinkClickDestination() {
    return mActionLinkClickDestination;
  }

  public AdsHistogramStats setFieldActionLinkClickDestination(String value) {
    this.mActionLinkClickDestination = value;
    return this;
  }

  public String getFieldActionLocationCode() {
    return mActionLocationCode;
  }

  public AdsHistogramStats setFieldActionLocationCode(String value) {
    this.mActionLocationCode = value;
    return this;
  }

  public String getFieldActionReaction() {
    return mActionReaction;
  }

  public AdsHistogramStats setFieldActionReaction(String value) {
    this.mActionReaction = value;
    return this;
  }

  public String getFieldActionTargetId() {
    return mActionTargetId;
  }

  public AdsHistogramStats setFieldActionTargetId(String value) {
    this.mActionTargetId = value;
    return this;
  }

  public String getFieldActionType() {
    return mActionType;
  }

  public AdsHistogramStats setFieldActionType(String value) {
    this.mActionType = value;
    return this;
  }

  public String getFieldActionVideoAssetId() {
    return mActionVideoAssetId;
  }

  public AdsHistogramStats setFieldActionVideoAssetId(String value) {
    this.mActionVideoAssetId = value;
    return this;
  }

  public String getFieldActionVideoSound() {
    return mActionVideoSound;
  }

  public AdsHistogramStats setFieldActionVideoSound(String value) {
    this.mActionVideoSound = value;
    return this;
  }

  public String getFieldActionVideoType() {
    return mActionVideoType;
  }

  public AdsHistogramStats setFieldActionVideoType(String value) {
    this.mActionVideoType = value;
    return this;
  }

  public List<Long> getFieldDda() {
    return mDda;
  }

  public AdsHistogramStats setFieldDda(List<Long> value) {
    this.mDda = value;
    return this;
  }

  public List<Long> getFieldInline() {
    return mInline;
  }

  public AdsHistogramStats setFieldInline(List<Long> value) {
    this.mInline = value;
    return this;
  }

  public String getFieldInteractiveComponentStickerId() {
    return mInteractiveComponentStickerId;
  }

  public AdsHistogramStats setFieldInteractiveComponentStickerId(String value) {
    this.mInteractiveComponentStickerId = value;
    return this;
  }

  public String getFieldInteractiveComponentStickerResponse() {
    return mInteractiveComponentStickerResponse;
  }

  public AdsHistogramStats setFieldInteractiveComponentStickerResponse(String value) {
    this.mInteractiveComponentStickerResponse = value;
    return this;
  }

  public List<Long> getFieldSkanClick() {
    return mSkanClick;
  }

  public AdsHistogramStats setFieldSkanClick(List<Long> value) {
    this.mSkanClick = value;
    return this;
  }

  public List<Long> getFieldSkanClickSecondPostback() {
    return mSkanClickSecondPostback;
  }

  public AdsHistogramStats setFieldSkanClickSecondPostback(List<Long> value) {
    this.mSkanClickSecondPostback = value;
    return this;
  }

  public List<Long> getFieldSkanClickThirdPostback() {
    return mSkanClickThirdPostback;
  }

  public AdsHistogramStats setFieldSkanClickThirdPostback(List<Long> value) {
    this.mSkanClickThirdPostback = value;
    return this;
  }

  public List<Long> getFieldSkanView() {
    return mSkanView;
  }

  public AdsHistogramStats setFieldSkanView(List<Long> value) {
    this.mSkanView = value;
    return this;
  }

  public List<Long> getFieldSkanViewSecondPostback() {
    return mSkanViewSecondPostback;
  }

  public AdsHistogramStats setFieldSkanViewSecondPostback(List<Long> value) {
    this.mSkanViewSecondPostback = value;
    return this;
  }

  public List<Long> getFieldSkanViewThirdPostback() {
    return mSkanViewThirdPostback;
  }

  public AdsHistogramStats setFieldSkanViewThirdPostback(List<Long> value) {
    this.mSkanViewThirdPostback = value;
    return this;
  }

  public List<Long> getFieldValue() {
    return mValue;
  }

  public AdsHistogramStats setFieldValue(List<Long> value) {
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

  public AdsHistogramStats copyFrom(AdsHistogramStats instance) {
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

  public static APIRequest.ResponseParser<AdsHistogramStats> getParser() {
    return new APIRequest.ResponseParser<AdsHistogramStats>() {
      public APINodeList<AdsHistogramStats> parseResponse(String response, APIContext context, APIRequest<AdsHistogramStats> request, String header) throws MalformedResponseException {
        return AdsHistogramStats.parseResponse(response, context, request, header);
      }
    };
  }
}
