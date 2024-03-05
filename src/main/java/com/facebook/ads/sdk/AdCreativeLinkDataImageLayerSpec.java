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
public class AdCreativeLinkDataImageLayerSpec extends APINode {
  @SerializedName("blending_mode")
  private EnumBlendingMode mBlendingMode = null;
  @SerializedName("content")
  private Object mContent = null;
  @SerializedName("frame_image_hash")
  private String mFrameImageHash = null;
  @SerializedName("frame_source")
  private EnumFrameSource mFrameSource = null;
  @SerializedName("image_source")
  private EnumImageSource mImageSource = null;
  @SerializedName("layer_type")
  private EnumLayerType mLayerType = null;
  @SerializedName("opacity")
  private Long mOpacity = null;
  @SerializedName("overlay_position")
  private EnumOverlayPosition mOverlayPosition = null;
  @SerializedName("overlay_shape")
  private EnumOverlayShape mOverlayShape = null;
  @SerializedName("scale")
  private Long mScale = null;
  @SerializedName("shape_color")
  private String mShapeColor = null;
  @SerializedName("text_color")
  private String mTextColor = null;
  @SerializedName("text_font")
  private EnumTextFont mTextFont = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataImageLayerSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataImageLayerSpec loadJSON(String json, APIContext context, String header) {
    AdCreativeLinkDataImageLayerSpec adCreativeLinkDataImageLayerSpec = getGson().fromJson(json, AdCreativeLinkDataImageLayerSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataImageLayerSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeLinkDataImageLayerSpec.context = context;
    adCreativeLinkDataImageLayerSpec.rawValue = json;
    adCreativeLinkDataImageLayerSpec.header = header;
    return adCreativeLinkDataImageLayerSpec;
  }

  public static APINodeList<AdCreativeLinkDataImageLayerSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataImageLayerSpec> adCreativeLinkDataImageLayerSpecs = new APINodeList<AdCreativeLinkDataImageLayerSpec>(request, json, header);
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
          adCreativeLinkDataImageLayerSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeLinkDataImageLayerSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataImageLayerSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataImageLayerSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataImageLayerSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeLinkDataImageLayerSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeLinkDataImageLayerSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeLinkDataImageLayerSpecs;
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
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataImageLayerSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataImageLayerSpecs.clear();
          adCreativeLinkDataImageLayerSpecs.add(loadJSON(json, context, header));
          return adCreativeLinkDataImageLayerSpecs;
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


  public EnumBlendingMode getFieldBlendingMode() {
    return mBlendingMode;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldBlendingMode(EnumBlendingMode value) {
    this.mBlendingMode = value;
    return this;
  }

  public Object getFieldContent() {
    return mContent;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldContent(Object value) {
    this.mContent = value;
    return this;
  }

  public String getFieldFrameImageHash() {
    return mFrameImageHash;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldFrameImageHash(String value) {
    this.mFrameImageHash = value;
    return this;
  }

  public EnumFrameSource getFieldFrameSource() {
    return mFrameSource;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldFrameSource(EnumFrameSource value) {
    this.mFrameSource = value;
    return this;
  }

  public EnumImageSource getFieldImageSource() {
    return mImageSource;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldImageSource(EnumImageSource value) {
    this.mImageSource = value;
    return this;
  }

  public EnumLayerType getFieldLayerType() {
    return mLayerType;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldLayerType(EnumLayerType value) {
    this.mLayerType = value;
    return this;
  }

  public Long getFieldOpacity() {
    return mOpacity;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldOpacity(Long value) {
    this.mOpacity = value;
    return this;
  }

  public EnumOverlayPosition getFieldOverlayPosition() {
    return mOverlayPosition;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldOverlayPosition(EnumOverlayPosition value) {
    this.mOverlayPosition = value;
    return this;
  }

  public EnumOverlayShape getFieldOverlayShape() {
    return mOverlayShape;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldOverlayShape(EnumOverlayShape value) {
    this.mOverlayShape = value;
    return this;
  }

  public Long getFieldScale() {
    return mScale;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldScale(Long value) {
    this.mScale = value;
    return this;
  }

  public String getFieldShapeColor() {
    return mShapeColor;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldShapeColor(String value) {
    this.mShapeColor = value;
    return this;
  }

  public String getFieldTextColor() {
    return mTextColor;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldTextColor(String value) {
    this.mTextColor = value;
    return this;
  }

  public EnumTextFont getFieldTextFont() {
    return mTextFont;
  }

  public AdCreativeLinkDataImageLayerSpec setFieldTextFont(EnumTextFont value) {
    this.mTextFont = value;
    return this;
  }



  public static enum EnumBlendingMode {
      @SerializedName("lighten")
      VALUE_LIGHTEN("lighten"),
      @SerializedName("multiply")
      VALUE_MULTIPLY("multiply"),
      @SerializedName("normal")
      VALUE_NORMAL("normal"),
      ;

      private String value;

      private EnumBlendingMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFrameSource {
      @SerializedName("custom")
      VALUE_CUSTOM("custom"),
      ;

      private String value;

      private EnumFrameSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumImageSource {
      @SerializedName("catalog")
      VALUE_CATALOG("catalog"),
      ;

      private String value;

      private EnumImageSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLayerType {
      @SerializedName("frame_overlay")
      VALUE_FRAME_OVERLAY("frame_overlay"),
      @SerializedName("image")
      VALUE_IMAGE("image"),
      @SerializedName("text_overlay")
      VALUE_TEXT_OVERLAY("text_overlay"),
      ;

      private String value;

      private EnumLayerType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOverlayPosition {
      @SerializedName("bottom")
      VALUE_BOTTOM("bottom"),
      @SerializedName("bottom_left")
      VALUE_BOTTOM_LEFT("bottom_left"),
      @SerializedName("bottom_right")
      VALUE_BOTTOM_RIGHT("bottom_right"),
      @SerializedName("center")
      VALUE_CENTER("center"),
      @SerializedName("left")
      VALUE_LEFT("left"),
      @SerializedName("right")
      VALUE_RIGHT("right"),
      @SerializedName("top")
      VALUE_TOP("top"),
      @SerializedName("top_left")
      VALUE_TOP_LEFT("top_left"),
      @SerializedName("top_right")
      VALUE_TOP_RIGHT("top_right"),
      ;

      private String value;

      private EnumOverlayPosition(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOverlayShape {
      @SerializedName("circle")
      VALUE_CIRCLE("circle"),
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("pill")
      VALUE_PILL("pill"),
      @SerializedName("rectangle")
      VALUE_RECTANGLE("rectangle"),
      @SerializedName("triangle")
      VALUE_TRIANGLE("triangle"),
      ;

      private String value;

      private EnumOverlayShape(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTextFont {
      @SerializedName("droid_serif_regular")
      VALUE_DROID_SERIF_REGULAR("droid_serif_regular"),
      @SerializedName("lato_regular")
      VALUE_LATO_REGULAR("lato_regular"),
      @SerializedName("noto_sans_regular")
      VALUE_NOTO_SANS_REGULAR("noto_sans_regular"),
      @SerializedName("nunito_sans_bold")
      VALUE_NUNITO_SANS_BOLD("nunito_sans_bold"),
      @SerializedName("open_sans_bold")
      VALUE_OPEN_SANS_BOLD("open_sans_bold"),
      @SerializedName("open_sans_condensed_bold")
      VALUE_OPEN_SANS_CONDENSED_BOLD("open_sans_condensed_bold"),
      @SerializedName("pt_serif_bold")
      VALUE_PT_SERIF_BOLD("pt_serif_bold"),
      @SerializedName("roboto_condensed_regular")
      VALUE_ROBOTO_CONDENSED_REGULAR("roboto_condensed_regular"),
      @SerializedName("roboto_medium")
      VALUE_ROBOTO_MEDIUM("roboto_medium"),
      ;

      private String value;

      private EnumTextFont(String value) {
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

  public AdCreativeLinkDataImageLayerSpec copyFrom(AdCreativeLinkDataImageLayerSpec instance) {
    this.mBlendingMode = instance.mBlendingMode;
    this.mContent = instance.mContent;
    this.mFrameImageHash = instance.mFrameImageHash;
    this.mFrameSource = instance.mFrameSource;
    this.mImageSource = instance.mImageSource;
    this.mLayerType = instance.mLayerType;
    this.mOpacity = instance.mOpacity;
    this.mOverlayPosition = instance.mOverlayPosition;
    this.mOverlayShape = instance.mOverlayShape;
    this.mScale = instance.mScale;
    this.mShapeColor = instance.mShapeColor;
    this.mTextColor = instance.mTextColor;
    this.mTextFont = instance.mTextFont;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataImageLayerSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataImageLayerSpec>() {
      public APINodeList<AdCreativeLinkDataImageLayerSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataImageLayerSpec> request, String header) throws MalformedResponseException {
        return AdCreativeLinkDataImageLayerSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
