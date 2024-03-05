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
public class AdCreativeLinkDataImageOverlaySpec extends APINode {
  @SerializedName("custom_text_type")
  private EnumCustomTextType mCustomTextType = null;
  @SerializedName("float_with_margin")
  private Boolean mFloatWithMargin = null;
  @SerializedName("overlay_template")
  private EnumOverlayTemplate mOverlayTemplate = null;
  @SerializedName("position")
  private EnumPosition mPosition = null;
  @SerializedName("text_font")
  private EnumTextFont mTextFont = null;
  @SerializedName("text_template_tags")
  private List<String> mTextTemplateTags = null;
  @SerializedName("text_type")
  private EnumTextType mTextType = null;
  @SerializedName("theme_color")
  private EnumThemeColor mThemeColor = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataImageOverlaySpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataImageOverlaySpec loadJSON(String json, APIContext context, String header) {
    AdCreativeLinkDataImageOverlaySpec adCreativeLinkDataImageOverlaySpec = getGson().fromJson(json, AdCreativeLinkDataImageOverlaySpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataImageOverlaySpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeLinkDataImageOverlaySpec.context = context;
    adCreativeLinkDataImageOverlaySpec.rawValue = json;
    adCreativeLinkDataImageOverlaySpec.header = header;
    return adCreativeLinkDataImageOverlaySpec;
  }

  public static APINodeList<AdCreativeLinkDataImageOverlaySpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataImageOverlaySpec> adCreativeLinkDataImageOverlaySpecs = new APINodeList<AdCreativeLinkDataImageOverlaySpec>(request, json, header);
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
          adCreativeLinkDataImageOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeLinkDataImageOverlaySpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataImageOverlaySpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataImageOverlaySpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataImageOverlaySpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataImageOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeLinkDataImageOverlaySpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataImageOverlaySpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeLinkDataImageOverlaySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataImageOverlaySpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeLinkDataImageOverlaySpecs;
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
              adCreativeLinkDataImageOverlaySpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataImageOverlaySpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataImageOverlaySpecs.clear();
          adCreativeLinkDataImageOverlaySpecs.add(loadJSON(json, context, header));
          return adCreativeLinkDataImageOverlaySpecs;
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


  public EnumCustomTextType getFieldCustomTextType() {
    return mCustomTextType;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldCustomTextType(EnumCustomTextType value) {
    this.mCustomTextType = value;
    return this;
  }

  public Boolean getFieldFloatWithMargin() {
    return mFloatWithMargin;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldFloatWithMargin(Boolean value) {
    this.mFloatWithMargin = value;
    return this;
  }

  public EnumOverlayTemplate getFieldOverlayTemplate() {
    return mOverlayTemplate;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldOverlayTemplate(EnumOverlayTemplate value) {
    this.mOverlayTemplate = value;
    return this;
  }

  public EnumPosition getFieldPosition() {
    return mPosition;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldPosition(EnumPosition value) {
    this.mPosition = value;
    return this;
  }

  public EnumTextFont getFieldTextFont() {
    return mTextFont;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldTextFont(EnumTextFont value) {
    this.mTextFont = value;
    return this;
  }

  public List<String> getFieldTextTemplateTags() {
    return mTextTemplateTags;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldTextTemplateTags(List<String> value) {
    this.mTextTemplateTags = value;
    return this;
  }

  public EnumTextType getFieldTextType() {
    return mTextType;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldTextType(EnumTextType value) {
    this.mTextType = value;
    return this;
  }

  public EnumThemeColor getFieldThemeColor() {
    return mThemeColor;
  }

  public AdCreativeLinkDataImageOverlaySpec setFieldThemeColor(EnumThemeColor value) {
    this.mThemeColor = value;
    return this;
  }



  public static enum EnumCustomTextType {
      @SerializedName("free_shipping")
      VALUE_FREE_SHIPPING("free_shipping"),
      @SerializedName("popular")
      VALUE_POPULAR("popular"),
      ;

      private String value;

      private EnumCustomTextType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOverlayTemplate {
      @SerializedName("circle_with_text")
      VALUE_CIRCLE_WITH_TEXT("circle_with_text"),
      @SerializedName("pill_with_text")
      VALUE_PILL_WITH_TEXT("pill_with_text"),
      @SerializedName("triangle_with_text")
      VALUE_TRIANGLE_WITH_TEXT("triangle_with_text"),
      ;

      private String value;

      private EnumOverlayTemplate(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPosition {
      @SerializedName("bottom_left")
      VALUE_BOTTOM_LEFT("bottom_left"),
      @SerializedName("bottom_right")
      VALUE_BOTTOM_RIGHT("bottom_right"),
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

  public static enum EnumTextFont {
      @SerializedName("droid_serif_regular")
      VALUE_DROID_SERIF_REGULAR("droid_serif_regular"),
      @SerializedName("dynads_hybrid_bold")
      VALUE_DYNADS_HYBRID_BOLD("dynads_hybrid_bold"),
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

  public static enum EnumTextType {
      @SerializedName("automated_personalize")
      VALUE_AUTOMATED_PERSONALIZE("automated_personalize"),
      @SerializedName("custom")
      VALUE_CUSTOM("custom"),
      @SerializedName("disclaimer")
      VALUE_DISCLAIMER("disclaimer"),
      @SerializedName("from_price")
      VALUE_FROM_PRICE("from_price"),
      @SerializedName("guest_rating")
      VALUE_GUEST_RATING("guest_rating"),
      @SerializedName("percentage_off")
      VALUE_PERCENTAGE_OFF("percentage_off"),
      @SerializedName("price")
      VALUE_PRICE("price"),
      @SerializedName("star_rating")
      VALUE_STAR_RATING("star_rating"),
      @SerializedName("strikethrough_price")
      VALUE_STRIKETHROUGH_PRICE("strikethrough_price"),
      @SerializedName("sustainable")
      VALUE_SUSTAINABLE("sustainable"),
      ;

      private String value;

      private EnumTextType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumThemeColor {
      @SerializedName("background_000000_text_ffffff")
      VALUE_BACKGROUND_000000_TEXT_FFFFFF("background_000000_text_ffffff"),
      @SerializedName("background_0090ff_text_ffffff")
      VALUE_BACKGROUND_0090FF_TEXT_FFFFFF("background_0090ff_text_ffffff"),
      @SerializedName("background_00af4c_text_ffffff")
      VALUE_BACKGROUND_00AF4C_TEXT_FFFFFF("background_00af4c_text_ffffff"),
      @SerializedName("background_595959_text_ffffff")
      VALUE_BACKGROUND_595959_TEXT_FFFFFF("background_595959_text_ffffff"),
      @SerializedName("background_755dde_text_ffffff")
      VALUE_BACKGROUND_755DDE_TEXT_FFFFFF("background_755dde_text_ffffff"),
      @SerializedName("background_e50900_text_ffffff")
      VALUE_BACKGROUND_E50900_TEXT_FFFFFF("background_e50900_text_ffffff"),
      @SerializedName("background_f23474_text_ffffff")
      VALUE_BACKGROUND_F23474_TEXT_FFFFFF("background_f23474_text_ffffff"),
      @SerializedName("background_f78400_text_ffffff")
      VALUE_BACKGROUND_F78400_TEXT_FFFFFF("background_f78400_text_ffffff"),
      @SerializedName("background_ffffff_text_000000")
      VALUE_BACKGROUND_FFFFFF_TEXT_000000("background_ffffff_text_000000"),
      @SerializedName("background_ffffff_text_007ad0")
      VALUE_BACKGROUND_FFFFFF_TEXT_007AD0("background_ffffff_text_007ad0"),
      @SerializedName("background_ffffff_text_009c2a")
      VALUE_BACKGROUND_FFFFFF_TEXT_009C2A("background_ffffff_text_009c2a"),
      @SerializedName("background_ffffff_text_646464")
      VALUE_BACKGROUND_FFFFFF_TEXT_646464("background_ffffff_text_646464"),
      @SerializedName("background_ffffff_text_755dde")
      VALUE_BACKGROUND_FFFFFF_TEXT_755DDE("background_ffffff_text_755dde"),
      @SerializedName("background_ffffff_text_c91b00")
      VALUE_BACKGROUND_FFFFFF_TEXT_C91B00("background_ffffff_text_c91b00"),
      @SerializedName("background_ffffff_text_f23474")
      VALUE_BACKGROUND_FFFFFF_TEXT_F23474("background_ffffff_text_f23474"),
      @SerializedName("background_ffffff_text_f78400")
      VALUE_BACKGROUND_FFFFFF_TEXT_F78400("background_ffffff_text_f78400"),
      ;

      private String value;

      private EnumThemeColor(String value) {
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

  public AdCreativeLinkDataImageOverlaySpec copyFrom(AdCreativeLinkDataImageOverlaySpec instance) {
    this.mCustomTextType = instance.mCustomTextType;
    this.mFloatWithMargin = instance.mFloatWithMargin;
    this.mOverlayTemplate = instance.mOverlayTemplate;
    this.mPosition = instance.mPosition;
    this.mTextFont = instance.mTextFont;
    this.mTextTemplateTags = instance.mTextTemplateTags;
    this.mTextType = instance.mTextType;
    this.mThemeColor = instance.mThemeColor;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataImageOverlaySpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataImageOverlaySpec>() {
      public APINodeList<AdCreativeLinkDataImageOverlaySpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataImageOverlaySpec> request, String header) throws MalformedResponseException {
        return AdCreativeLinkDataImageOverlaySpec.parseResponse(response, context, request, header);
      }
    };
  }
}
