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
public class AdCreativeLinkDataCustomOverlaySpec extends APINode {
  @SerializedName("background_color")
  private EnumBackgroundColor mBackgroundColor = null;
  @SerializedName("float_with_margin")
  private Boolean mFloatWithMargin = null;
  @SerializedName("font")
  private EnumFont mFont = null;
  @SerializedName("option")
  private EnumOption mOption = null;
  @SerializedName("position")
  private EnumPosition mPosition = null;
  @SerializedName("render_with_icon")
  private Boolean mRenderWithIcon = null;
  @SerializedName("template")
  private EnumTemplate mTemplate = null;
  @SerializedName("text_color")
  private EnumTextColor mTextColor = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeLinkDataCustomOverlaySpec() {
  }

  public AdCreativeLinkDataCustomOverlaySpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkDataCustomOverlaySpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkDataCustomOverlaySpec fetch() throws APIException{
    AdCreativeLinkDataCustomOverlaySpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkDataCustomOverlaySpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkDataCustomOverlaySpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkDataCustomOverlaySpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkDataCustomOverlaySpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkDataCustomOverlaySpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkDataCustomOverlaySpec>)(
      new APIRequest<AdCreativeLinkDataCustomOverlaySpec>(context, "", "/", "GET", AdCreativeLinkDataCustomOverlaySpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkDataCustomOverlaySpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkDataCustomOverlaySpec.getParser())
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
  public static AdCreativeLinkDataCustomOverlaySpec loadJSON(String json, APIContext context) {
    AdCreativeLinkDataCustomOverlaySpec adCreativeLinkDataCustomOverlaySpec = getGson().fromJson(json, AdCreativeLinkDataCustomOverlaySpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCustomOverlaySpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCustomOverlaySpec.context = context;
    adCreativeLinkDataCustomOverlaySpec.rawValue = json;
    return adCreativeLinkDataCustomOverlaySpec;
  }

  public static APINodeList<AdCreativeLinkDataCustomOverlaySpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataCustomOverlaySpec> adCreativeLinkDataCustomOverlaySpecs = new APINodeList<AdCreativeLinkDataCustomOverlaySpec>(request, json);
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
          adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCustomOverlaySpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataCustomOverlaySpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataCustomOverlaySpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataCustomOverlaySpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDataCustomOverlaySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataCustomOverlaySpecs;
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
              adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataCustomOverlaySpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataCustomOverlaySpecs.clear();
          adCreativeLinkDataCustomOverlaySpecs.add(loadJSON(json, context));
          return adCreativeLinkDataCustomOverlaySpecs;
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


  public EnumBackgroundColor getFieldBackgroundColor() {
    return mBackgroundColor;
  }

  public Boolean getFieldFloatWithMargin() {
    return mFloatWithMargin;
  }

  public EnumFont getFieldFont() {
    return mFont;
  }

  public EnumOption getFieldOption() {
    return mOption;
  }

  public EnumPosition getFieldPosition() {
    return mPosition;
  }

  public Boolean getFieldRenderWithIcon() {
    return mRenderWithIcon;
  }

  public EnumTemplate getFieldTemplate() {
    return mTemplate;
  }

  public EnumTextColor getFieldTextColor() {
    return mTextColor;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkDataCustomOverlaySpec> {

    AdCreativeLinkDataCustomOverlaySpec lastResponse = null;
    @Override
    public AdCreativeLinkDataCustomOverlaySpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "background_color",
      "float_with_margin",
      "font",
      "option",
      "position",
      "render_with_icon",
      "template",
      "text_color",
      "id",
    };

    @Override
    public AdCreativeLinkDataCustomOverlaySpec parseResponse(String response) throws APIException {
      return AdCreativeLinkDataCustomOverlaySpec.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkDataCustomOverlaySpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkDataCustomOverlaySpec execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkDataCustomOverlaySpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkDataCustomOverlaySpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkDataCustomOverlaySpec>() {
           public AdCreativeLinkDataCustomOverlaySpec apply(String result) {
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
    public APIRequestGet requestFloatWithMarginField () {
      return this.requestFloatWithMarginField(true);
    }
    public APIRequestGet requestFloatWithMarginField (boolean value) {
      this.requestField("float_with_margin", value);
      return this;
    }
    public APIRequestGet requestFontField () {
      return this.requestFontField(true);
    }
    public APIRequestGet requestFontField (boolean value) {
      this.requestField("font", value);
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
    public APIRequestGet requestRenderWithIconField () {
      return this.requestRenderWithIconField(true);
    }
    public APIRequestGet requestRenderWithIconField (boolean value) {
      this.requestField("render_with_icon", value);
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

  public static enum EnumBackgroundColor {
      @SerializedName("background_ffffff")
      VALUE_BACKGROUND_FFFFFF("background_ffffff"),
      @SerializedName("background_e50900")
      VALUE_BACKGROUND_E50900("background_e50900"),
      @SerializedName("background_f78400")
      VALUE_BACKGROUND_F78400("background_f78400"),
      @SerializedName("background_00af4c")
      VALUE_BACKGROUND_00AF4C("background_00af4c"),
      @SerializedName("background_0090ff")
      VALUE_BACKGROUND_0090FF("background_0090ff"),
      @SerializedName("background_755dde")
      VALUE_BACKGROUND_755DDE("background_755dde"),
      @SerializedName("background_f23474")
      VALUE_BACKGROUND_F23474("background_f23474"),
      @SerializedName("background_595959")
      VALUE_BACKGROUND_595959("background_595959"),
      @SerializedName("background_000000")
      VALUE_BACKGROUND_000000("background_000000"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumBackgroundColor(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFont {
      @SerializedName("droid_serif_regular")
      VALUE_DROID_SERIF_REGULAR("droid_serif_regular"),
      @SerializedName("lato_regular")
      VALUE_LATO_REGULAR("lato_regular"),
      @SerializedName("nunito_sans_bold")
      VALUE_NUNITO_SANS_BOLD("nunito_sans_bold"),
      @SerializedName("open_sans_bold")
      VALUE_OPEN_SANS_BOLD("open_sans_bold"),
      @SerializedName("pt_serif_bold")
      VALUE_PT_SERIF_BOLD("pt_serif_bold"),
      @SerializedName("roboto_medium")
      VALUE_ROBOTO_MEDIUM("roboto_medium"),
      @SerializedName("roboto_condensed_regular")
      VALUE_ROBOTO_CONDENSED_REGULAR("roboto_condensed_regular"),
      @SerializedName("noto_sans_regular")
      VALUE_NOTO_SANS_REGULAR("noto_sans_regular"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumFont(String value) {
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
      @SerializedName("top_right")
      VALUE_TOP_RIGHT("top_right"),
      @SerializedName("bottom_left")
      VALUE_BOTTOM_LEFT("bottom_left"),
      @SerializedName("bottom_right")
      VALUE_BOTTOM_RIGHT("bottom_right"),
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
      @SerializedName("pill_with_text")
      VALUE_PILL_WITH_TEXT("pill_with_text"),
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

  public static enum EnumTextColor {
      @SerializedName("text_ffffff")
      VALUE_TEXT_FFFFFF("text_ffffff"),
      @SerializedName("text_c91b00")
      VALUE_TEXT_C91B00("text_c91b00"),
      @SerializedName("text_f78400")
      VALUE_TEXT_F78400("text_f78400"),
      @SerializedName("text_009c2a")
      VALUE_TEXT_009C2A("text_009c2a"),
      @SerializedName("text_007ad0")
      VALUE_TEXT_007AD0("text_007ad0"),
      @SerializedName("text_755dde")
      VALUE_TEXT_755DDE("text_755dde"),
      @SerializedName("text_f23474")
      VALUE_TEXT_F23474("text_f23474"),
      @SerializedName("text_646464")
      VALUE_TEXT_646464("text_646464"),
      @SerializedName("text_000000")
      VALUE_TEXT_000000("text_000000"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumTextColor(String value) {
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

  public AdCreativeLinkDataCustomOverlaySpec copyFrom(AdCreativeLinkDataCustomOverlaySpec instance) {
    this.mBackgroundColor = instance.mBackgroundColor;
    this.mFloatWithMargin = instance.mFloatWithMargin;
    this.mFont = instance.mFont;
    this.mOption = instance.mOption;
    this.mPosition = instance.mPosition;
    this.mRenderWithIcon = instance.mRenderWithIcon;
    this.mTemplate = instance.mTemplate;
    this.mTextColor = instance.mTextColor;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataCustomOverlaySpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataCustomOverlaySpec>() {
      public APINodeList<AdCreativeLinkDataCustomOverlaySpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataCustomOverlaySpec> request) throws MalformedResponseException {
        return AdCreativeLinkDataCustomOverlaySpec.parseResponse(response, context, request);
      }
    };
  }
}
