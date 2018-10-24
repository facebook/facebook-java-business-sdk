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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeVideoDataCustomOverlaySpec() {
  }

  public AdCreativeVideoDataCustomOverlaySpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeVideoDataCustomOverlaySpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeVideoDataCustomOverlaySpec fetch() throws APIException{
    AdCreativeVideoDataCustomOverlaySpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeVideoDataCustomOverlaySpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeVideoDataCustomOverlaySpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeVideoDataCustomOverlaySpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeVideoDataCustomOverlaySpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeVideoDataCustomOverlaySpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeVideoDataCustomOverlaySpec>)(
      new APIRequest<AdCreativeVideoDataCustomOverlaySpec>(context, "", "/", "GET", AdCreativeVideoDataCustomOverlaySpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeVideoDataCustomOverlaySpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeVideoDataCustomOverlaySpec.getParser())
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
  public static AdCreativeVideoDataCustomOverlaySpec loadJSON(String json, APIContext context) {
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
      };
    }
    adCreativeVideoDataCustomOverlaySpec.context = context;
    adCreativeVideoDataCustomOverlaySpec.rawValue = json;
    return adCreativeVideoDataCustomOverlaySpec;
  }

  public static APINodeList<AdCreativeVideoDataCustomOverlaySpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeVideoDataCustomOverlaySpec> adCreativeVideoDataCustomOverlaySpecs = new APINodeList<AdCreativeVideoDataCustomOverlaySpec>(request, json);
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
          adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeVideoDataCustomOverlaySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context));
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
              adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(value.toString(), context));
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
          adCreativeVideoDataCustomOverlaySpecs.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBackgroundColor() {
    return mBackgroundColor;
  }

  public EnumBackgroundOpacity getFieldBackgroundOpacity() {
    return mBackgroundOpacity;
  }

  public Long getFieldDuration() {
    return mDuration;
  }

  public Boolean getFieldFloatWithMargin() {
    return mFloatWithMargin;
  }

  public Boolean getFieldFullWidth() {
    return mFullWidth;
  }

  public EnumOption getFieldOption() {
    return mOption;
  }

  public EnumPosition getFieldPosition() {
    return mPosition;
  }

  public Long getFieldStart() {
    return mStart;
  }

  public EnumTemplate getFieldTemplate() {
    return mTemplate;
  }

  public String getFieldTextColor() {
    return mTextColor;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeVideoDataCustomOverlaySpec> {

    AdCreativeVideoDataCustomOverlaySpec lastResponse = null;
    @Override
    public AdCreativeVideoDataCustomOverlaySpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "background_color",
      "background_opacity",
      "duration",
      "float_with_margin",
      "full_width",
      "option",
      "position",
      "start",
      "template",
      "text_color",
      "id",
    };

    @Override
    public AdCreativeVideoDataCustomOverlaySpec parseResponse(String response) throws APIException {
      return AdCreativeVideoDataCustomOverlaySpec.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeVideoDataCustomOverlaySpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeVideoDataCustomOverlaySpec execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeVideoDataCustomOverlaySpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeVideoDataCustomOverlaySpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeVideoDataCustomOverlaySpec>() {
           public AdCreativeVideoDataCustomOverlaySpec apply(String result) {
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

    public APIRequestGet requestBackgroundColorField () {
      return this.requestBackgroundColorField(true);
    }
    public APIRequestGet requestBackgroundColorField (boolean value) {
      this.requestField("background_color", value);
      return this;
    }
    public APIRequestGet requestBackgroundOpacityField () {
      return this.requestBackgroundOpacityField(true);
    }
    public APIRequestGet requestBackgroundOpacityField (boolean value) {
      this.requestField("background_opacity", value);
      return this;
    }
    public APIRequestGet requestDurationField () {
      return this.requestDurationField(true);
    }
    public APIRequestGet requestDurationField (boolean value) {
      this.requestField("duration", value);
      return this;
    }
    public APIRequestGet requestFloatWithMarginField () {
      return this.requestFloatWithMarginField(true);
    }
    public APIRequestGet requestFloatWithMarginField (boolean value) {
      this.requestField("float_with_margin", value);
      return this;
    }
    public APIRequestGet requestFullWidthField () {
      return this.requestFullWidthField(true);
    }
    public APIRequestGet requestFullWidthField (boolean value) {
      this.requestField("full_width", value);
      return this;
    }
    public APIRequestGet requestOptionField () {
      return this.requestOptionField(true);
    }
    public APIRequestGet requestOptionField (boolean value) {
      this.requestField("option", value);
      return this;
    }
    public APIRequestGet requestPositionField () {
      return this.requestPositionField(true);
    }
    public APIRequestGet requestPositionField (boolean value) {
      this.requestField("position", value);
      return this;
    }
    public APIRequestGet requestStartField () {
      return this.requestStartField(true);
    }
    public APIRequestGet requestStartField (boolean value) {
      this.requestField("start", value);
      return this;
    }
    public APIRequestGet requestTemplateField () {
      return this.requestTemplateField(true);
    }
    public APIRequestGet requestTemplateField (boolean value) {
      this.requestField("template", value);
      return this;
    }
    public APIRequestGet requestTextColorField () {
      return this.requestTextColorField(true);
    }
    public APIRequestGet requestTextColorField (boolean value) {
      this.requestField("text_color", value);
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

  public static enum EnumBackgroundOpacity {
      @SerializedName("solid")
      VALUE_SOLID("solid"),
      @SerializedName("half")
      VALUE_HALF("half"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      @SerializedName("discount_with_boleto")
      VALUE_DISCOUNT_WITH_BOLETO("discount_with_boleto"),
      @SerializedName("cash_on_delivery")
      VALUE_CASH_ON_DELIVERY("cash_on_delivery"),
      @SerializedName("home_delivery")
      VALUE_HOME_DELIVERY("home_delivery"),
      @SerializedName("free_shipping")
      VALUE_FREE_SHIPPING("free_shipping"),
      @SerializedName("inventory")
      VALUE_INVENTORY("inventory"),
      @SerializedName("pay_on_arrival")
      VALUE_PAY_ON_ARRIVAL("pay_on_arrival"),
      @SerializedName("pay_at_hotel")
      VALUE_PAY_AT_HOTEL("pay_at_hotel"),
      @SerializedName("fast_delivery")
      VALUE_FAST_DELIVERY("fast_delivery"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      @SerializedName("top_left")
      VALUE_TOP_LEFT("top_left"),
      @SerializedName("top_center")
      VALUE_TOP_CENTER("top_center"),
      @SerializedName("top_right")
      VALUE_TOP_RIGHT("top_right"),
      @SerializedName("middle_left")
      VALUE_MIDDLE_LEFT("middle_left"),
      @SerializedName("middle_center")
      VALUE_MIDDLE_CENTER("middle_center"),
      @SerializedName("middle_right")
      VALUE_MIDDLE_RIGHT("middle_right"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeVideoDataCustomOverlaySpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeVideoDataCustomOverlaySpec>() {
      public APINodeList<AdCreativeVideoDataCustomOverlaySpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeVideoDataCustomOverlaySpec> request) throws MalformedResponseException {
        return AdCreativeVideoDataCustomOverlaySpec.parseResponse(response, context, request);
      }
    };
  }
}
