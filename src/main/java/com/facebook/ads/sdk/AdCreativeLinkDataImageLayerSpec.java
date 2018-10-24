/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeLinkDataImageLayerSpec() {
  }

  public AdCreativeLinkDataImageLayerSpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkDataImageLayerSpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkDataImageLayerSpec fetch() throws APIException{
    AdCreativeLinkDataImageLayerSpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkDataImageLayerSpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkDataImageLayerSpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkDataImageLayerSpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkDataImageLayerSpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkDataImageLayerSpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkDataImageLayerSpec>)(
      new APIRequest<AdCreativeLinkDataImageLayerSpec>(context, "", "/", "GET", AdCreativeLinkDataImageLayerSpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkDataImageLayerSpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkDataImageLayerSpec.getParser())
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
  public static AdCreativeLinkDataImageLayerSpec loadJSON(String json, APIContext context) {
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
      };
    }
    adCreativeLinkDataImageLayerSpec.context = context;
    adCreativeLinkDataImageLayerSpec.rawValue = json;
    return adCreativeLinkDataImageLayerSpec;
  }

  public static APINodeList<AdCreativeLinkDataImageLayerSpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataImageLayerSpec> adCreativeLinkDataImageLayerSpecs = new APINodeList<AdCreativeLinkDataImageLayerSpec>(request, json);
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
          adCreativeLinkDataImageLayerSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDataImageLayerSpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDataImageLayerSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(entry.getValue().toString(), context));
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
              adCreativeLinkDataImageLayerSpecs.add(loadJSON(value.toString(), context));
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
          adCreativeLinkDataImageLayerSpecs.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public EnumBlendingMode getFieldBlendingMode() {
    return mBlendingMode;
  }

  public Object getFieldContent() {
    return mContent;
  }

  public String getFieldFrameImageHash() {
    return mFrameImageHash;
  }

  public EnumFrameSource getFieldFrameSource() {
    return mFrameSource;
  }

  public EnumImageSource getFieldImageSource() {
    return mImageSource;
  }

  public EnumLayerType getFieldLayerType() {
    return mLayerType;
  }

  public Long getFieldOpacity() {
    return mOpacity;
  }

  public EnumOverlayPosition getFieldOverlayPosition() {
    return mOverlayPosition;
  }

  public EnumOverlayShape getFieldOverlayShape() {
    return mOverlayShape;
  }

  public Long getFieldScale() {
    return mScale;
  }

  public String getFieldShapeColor() {
    return mShapeColor;
  }

  public String getFieldTextColor() {
    return mTextColor;
  }

  public EnumTextFont getFieldTextFont() {
    return mTextFont;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkDataImageLayerSpec> {

    AdCreativeLinkDataImageLayerSpec lastResponse = null;
    @Override
    public AdCreativeLinkDataImageLayerSpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "blending_mode",
      "content",
      "frame_image_hash",
      "frame_source",
      "image_source",
      "layer_type",
      "opacity",
      "overlay_position",
      "overlay_shape",
      "scale",
      "shape_color",
      "text_color",
      "text_font",
      "id",
    };

    @Override
    public AdCreativeLinkDataImageLayerSpec parseResponse(String response) throws APIException {
      return AdCreativeLinkDataImageLayerSpec.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkDataImageLayerSpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkDataImageLayerSpec execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkDataImageLayerSpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkDataImageLayerSpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkDataImageLayerSpec>() {
           public AdCreativeLinkDataImageLayerSpec apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestBlendingModeField () {
      return this.requestBlendingModeField(true);
    }
    public APIRequestGet requestBlendingModeField (boolean value) {
      this.requestField("blending_mode", value);
      return this;
    }
    public APIRequestGet requestContentField () {
      return this.requestContentField(true);
    }
    public APIRequestGet requestContentField (boolean value) {
      this.requestField("content", value);
      return this;
    }
    public APIRequestGet requestFrameImageHashField () {
      return this.requestFrameImageHashField(true);
    }
    public APIRequestGet requestFrameImageHashField (boolean value) {
      this.requestField("frame_image_hash", value);
      return this;
    }
    public APIRequestGet requestFrameSourceField () {
      return this.requestFrameSourceField(true);
    }
    public APIRequestGet requestFrameSourceField (boolean value) {
      this.requestField("frame_source", value);
      return this;
    }
    public APIRequestGet requestImageSourceField () {
      return this.requestImageSourceField(true);
    }
    public APIRequestGet requestImageSourceField (boolean value) {
      this.requestField("image_source", value);
      return this;
    }
    public APIRequestGet requestLayerTypeField () {
      return this.requestLayerTypeField(true);
    }
    public APIRequestGet requestLayerTypeField (boolean value) {
      this.requestField("layer_type", value);
      return this;
    }
    public APIRequestGet requestOpacityField () {
      return this.requestOpacityField(true);
    }
    public APIRequestGet requestOpacityField (boolean value) {
      this.requestField("opacity", value);
      return this;
    }
    public APIRequestGet requestOverlayPositionField () {
      return this.requestOverlayPositionField(true);
    }
    public APIRequestGet requestOverlayPositionField (boolean value) {
      this.requestField("overlay_position", value);
      return this;
    }
    public APIRequestGet requestOverlayShapeField () {
      return this.requestOverlayShapeField(true);
    }
    public APIRequestGet requestOverlayShapeField (boolean value) {
      this.requestField("overlay_shape", value);
      return this;
    }
    public APIRequestGet requestScaleField () {
      return this.requestScaleField(true);
    }
    public APIRequestGet requestScaleField (boolean value) {
      this.requestField("scale", value);
      return this;
    }
    public APIRequestGet requestShapeColorField () {
      return this.requestShapeColorField(true);
    }
    public APIRequestGet requestShapeColorField (boolean value) {
      this.requestField("shape_color", value);
      return this;
    }
    public APIRequestGet requestTextColorField () {
      return this.requestTextColorField(true);
    }
    public APIRequestGet requestTextColorField (boolean value) {
      this.requestField("text_color", value);
      return this;
    }
    public APIRequestGet requestTextFontField () {
      return this.requestTextFontField(true);
    }
    public APIRequestGet requestTextFontField (boolean value) {
      this.requestField("text_font", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static enum EnumBlendingMode {
      @SerializedName("lighten")
      VALUE_LIGHTEN("lighten"),
      @SerializedName("multiply")
      VALUE_MULTIPLY("multiply"),
      @SerializedName("normal")
      VALUE_NORMAL("normal"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataImageLayerSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataImageLayerSpec>() {
      public APINodeList<AdCreativeLinkDataImageLayerSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataImageLayerSpec> request) throws MalformedResponseException {
        return AdCreativeLinkDataImageLayerSpec.parseResponse(response, context, request);
      }
    };
  }
}
