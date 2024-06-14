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
public class AdCreativeVideoDataCustomOverlaySpec extends APINode {
  @SerializedName("background_color")
  private String mBackgroundColor = null;
  @SerializedName("background_opacity")
  private EnumBackgroundOpacity mBackgroundOpacity = null;
  @SerializedName("duration")
  private Long mDuration = null;
  @SerializedName("float_with_margin")
  private Boolean mFloatWithMargin = null;
  @SerializedName("full_width")
  private Boolean mFullWidth = null;
  @SerializedName("option")
  private EnumOption mOption = null;
  @SerializedName("position")
  private EnumPosition mPosition = null;
  @SerializedName("start")
  private Long mStart = null;
  @SerializedName("template")
  private EnumTemplate mTemplate = null;
  @SerializedName("text_color")
  private String mTextColor = null;
  protected static Gson gson = null;

  public AdCreativeVideoDataCustomOverlaySpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeVideoDataCustomOverlaySpec loadJSON(String json, APIContext context, String header) {
    AdCreativeVideoDataCustomOverlaySpec adCreativeVideoDataCustomOverlaySpec = getGson().fromJson(json, AdCreativeVideoDataCustomOverlaySpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeVideoDataCustomOverlaySpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeVideoDataCustomOverlaySpec.context = context;
    adCreativeVideoDataCustomOverlaySpec.rawValue = json;
    adCreativeVideoDataCustomOverlaySpec.header = header;
    return adCreativeVideoDataCustomOverlaySpec;
  }

  public static APINodeList<AdCreativeVideoDataCustomOverlaySpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeVideoDataCustomOverlaySpec> adCreativeVideoDataCustomOverlaySpecs = new APINodeList<AdCreativeVideoDataCustomOverlaySpec>(request, json, header);
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
          adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeVideoDataCustomOverlaySpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeVideoDataCustomOverlaySpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeVideoDataCustomOverlaySpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeVideoDataCustomOverlaySpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeVideoDataCustomOverlaySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeVideoDataCustomOverlaySpecs;
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
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeVideoDataCustomOverlaySpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeVideoDataCustomOverlaySpecs.clear();
          adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(json, context, header));
          return adCreativeVideoDataCustomOverlaySpecs;
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


  public String getFieldBackgroundColor() {
    return mBackgroundColor;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldBackgroundColor(String value) {
    this.mBackgroundColor = value;
    return this;
  }

  public EnumBackgroundOpacity getFieldBackgroundOpacity() {
    return mBackgroundOpacity;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldBackgroundOpacity(EnumBackgroundOpacity value) {
    this.mBackgroundOpacity = value;
    return this;
  }

  public Long getFieldDuration() {
    return mDuration;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldDuration(Long value) {
    this.mDuration = value;
    return this;
  }

  public Boolean getFieldFloatWithMargin() {
    return mFloatWithMargin;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldFloatWithMargin(Boolean value) {
    this.mFloatWithMargin = value;
    return this;
  }

  public Boolean getFieldFullWidth() {
    return mFullWidth;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldFullWidth(Boolean value) {
    this.mFullWidth = value;
    return this;
  }

  public EnumOption getFieldOption() {
    return mOption;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldOption(EnumOption value) {
    this.mOption = value;
    return this;
  }

  public EnumPosition getFieldPosition() {
    return mPosition;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldPosition(EnumPosition value) {
    this.mPosition = value;
    return this;
  }

  public Long getFieldStart() {
    return mStart;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldStart(Long value) {
    this.mStart = value;
    return this;
  }

  public EnumTemplate getFieldTemplate() {
    return mTemplate;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldTemplate(EnumTemplate value) {
    this.mTemplate = value;
    return this;
  }

  public String getFieldTextColor() {
    return mTextColor;
  }

  public AdCreativeVideoDataCustomOverlaySpec setFieldTextColor(String value) {
    this.mTextColor = value;
    return this;
  }



  public static enum EnumBackgroundOpacity {
      @SerializedName("half")
      VALUE_HALF("half"),
      @SerializedName("solid")
      VALUE_SOLID("solid"),
      ;

      private String value;

      private EnumBackgroundOpacity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOption {
      @SerializedName("bank_transfer")
      VALUE_BANK_TRANSFER("bank_transfer"),
      @SerializedName("boleto")
      VALUE_BOLETO("boleto"),
      @SerializedName("cash_on_delivery")
      VALUE_CASH_ON_DELIVERY("cash_on_delivery"),
      @SerializedName("discount_with_boleto")
      VALUE_DISCOUNT_WITH_BOLETO("discount_with_boleto"),
      @SerializedName("fast_delivery")
      VALUE_FAST_DELIVERY("fast_delivery"),
      @SerializedName("free_shipping")
      VALUE_FREE_SHIPPING("free_shipping"),
      @SerializedName("home_delivery")
      VALUE_HOME_DELIVERY("home_delivery"),
      @SerializedName("inventory")
      VALUE_INVENTORY("inventory"),
      @SerializedName("pay_at_hotel")
      VALUE_PAY_AT_HOTEL("pay_at_hotel"),
      @SerializedName("pay_on_arrival")
      VALUE_PAY_ON_ARRIVAL("pay_on_arrival"),
      ;

      private String value;

      private EnumOption(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPosition {
      @SerializedName("middle_center")
      VALUE_MIDDLE_CENTER("middle_center"),
      @SerializedName("middle_left")
      VALUE_MIDDLE_LEFT("middle_left"),
      @SerializedName("middle_right")
      VALUE_MIDDLE_RIGHT("middle_right"),
      @SerializedName("top_center")
      VALUE_TOP_CENTER("top_center"),
      @SerializedName("top_left")
      VALUE_TOP_LEFT("top_left"),
      @SerializedName("top_right")
      VALUE_TOP_RIGHT("top_right"),
      ;

      private String value;

      private EnumPosition(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTemplate {
      @SerializedName("rectangle_with_text")
      VALUE_RECTANGLE_WITH_TEXT("rectangle_with_text"),
      ;

      private String value;

      private EnumTemplate(String value) {
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

  public AdCreativeVideoDataCustomOverlaySpec copyFrom(AdCreativeVideoDataCustomOverlaySpec instance) {
    this.mBackgroundColor = instance.mBackgroundColor;
    this.mBackgroundOpacity = instance.mBackgroundOpacity;
    this.mDuration = instance.mDuration;
    this.mFloatWithMargin = instance.mFloatWithMargin;
    this.mFullWidth = instance.mFullWidth;
    this.mOption = instance.mOption;
    this.mPosition = instance.mPosition;
    this.mStart = instance.mStart;
    this.mTemplate = instance.mTemplate;
    this.mTextColor = instance.mTextColor;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeVideoDataCustomOverlaySpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeVideoDataCustomOverlaySpec>() {
      public APINodeList<AdCreativeVideoDataCustomOverlaySpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeVideoDataCustomOverlaySpec> request, String header) throws MalformedResponseException {
        return AdCreativeVideoDataCustomOverlaySpec.parseResponse(response, context, request, header);
      }
    };
  }
}
