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
public class ProductItemARData extends APINode {
  @SerializedName("container_effect")
  private String mContainerEffect = null;
  @SerializedName("effect_icon")
  private String mEffectIcon = null;
  @SerializedName("effect_parameters")
  private Object mEffectParameters = null;
  @SerializedName("picker_icon")
  private String mPickerIcon = null;
  @SerializedName("product_ar_link")
  private Object mProductArLink = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("surfaces")
  private List<EnumSurfaces> mSurfaces = null;
  protected static Gson gson = null;

  public ProductItemARData() {
  }

  public String getId() {
    return null;
  }
  public static ProductItemARData loadJSON(String json, APIContext context, String header) {
    ProductItemARData productItemARData = getGson().fromJson(json, ProductItemARData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productItemARData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productItemARData.context = context;
    productItemARData.rawValue = json;
    productItemARData.header = header;
    return productItemARData;
  }

  public static APINodeList<ProductItemARData> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductItemARData> productItemARDatas = new APINodeList<ProductItemARData>(request, json, header);
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
          productItemARDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productItemARDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productItemARDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productItemARDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productItemARDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItemARDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productItemARDatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItemARDatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productItemARDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItemARDatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productItemARDatas;
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
              productItemARDatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productItemARDatas;
          }

          // Sixth, check if it's pure JsonObject
          productItemARDatas.clear();
          productItemARDatas.add(loadJSON(json, context, header));
          return productItemARDatas;
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


  public String getFieldContainerEffect() {
    return mContainerEffect;
  }

  public ProductItemARData setFieldContainerEffect(String value) {
    this.mContainerEffect = value;
    return this;
  }

  public String getFieldEffectIcon() {
    return mEffectIcon;
  }

  public ProductItemARData setFieldEffectIcon(String value) {
    this.mEffectIcon = value;
    return this;
  }

  public Object getFieldEffectParameters() {
    return mEffectParameters;
  }

  public ProductItemARData setFieldEffectParameters(Object value) {
    this.mEffectParameters = value;
    return this;
  }

  public String getFieldPickerIcon() {
    return mPickerIcon;
  }

  public ProductItemARData setFieldPickerIcon(String value) {
    this.mPickerIcon = value;
    return this;
  }

  public Object getFieldProductArLink() {
    return mProductArLink;
  }

  public ProductItemARData setFieldProductArLink(Object value) {
    this.mProductArLink = value;
    return this;
  }

  public String getFieldState() {
    return mState;
  }

  public ProductItemARData setFieldState(String value) {
    this.mState = value;
    return this;
  }

  public List<EnumSurfaces> getFieldSurfaces() {
    return mSurfaces;
  }

  public ProductItemARData setFieldSurfaces(List<EnumSurfaces> value) {
    this.mSurfaces = value;
    return this;
  }



  public static enum EnumSurfaces {
      @SerializedName("B2C_MARKETPLACE")
      VALUE_B2C_MARKETPLACE("B2C_MARKETPLACE"),
      @SerializedName("C2C_MARKETPLACE")
      VALUE_C2C_MARKETPLACE("C2C_MARKETPLACE"),
      @SerializedName("DA")
      VALUE_DA("DA"),
      @SerializedName("DAILY_DEALS")
      VALUE_DAILY_DEALS("DAILY_DEALS"),
      @SerializedName("DAILY_DEALS_LEGACY")
      VALUE_DAILY_DEALS_LEGACY("DAILY_DEALS_LEGACY"),
      @SerializedName("IG_PRODUCT_TAGGING")
      VALUE_IG_PRODUCT_TAGGING("IG_PRODUCT_TAGGING"),
      @SerializedName("MARKETPLACE")
      VALUE_MARKETPLACE("MARKETPLACE"),
      @SerializedName("MARKETPLACE_ADS_DEPRECATED")
      VALUE_MARKETPLACE_ADS_DEPRECATED("MARKETPLACE_ADS_DEPRECATED"),
      @SerializedName("MARKETPLACE_SHOPS")
      VALUE_MARKETPLACE_SHOPS("MARKETPLACE_SHOPS"),
      @SerializedName("OFFLINE_CONVERSIONS")
      VALUE_OFFLINE_CONVERSIONS("OFFLINE_CONVERSIONS"),
      @SerializedName("SHOPS")
      VALUE_SHOPS("SHOPS"),
      @SerializedName("UNIVERSAL_CHECKOUT")
      VALUE_UNIVERSAL_CHECKOUT("UNIVERSAL_CHECKOUT"),
      ;

      private String value;

      private EnumSurfaces(String value) {
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

  public ProductItemARData copyFrom(ProductItemARData instance) {
    this.mContainerEffect = instance.mContainerEffect;
    this.mEffectIcon = instance.mEffectIcon;
    this.mEffectParameters = instance.mEffectParameters;
    this.mPickerIcon = instance.mPickerIcon;
    this.mProductArLink = instance.mProductArLink;
    this.mState = instance.mState;
    this.mSurfaces = instance.mSurfaces;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItemARData> getParser() {
    return new APIRequest.ResponseParser<ProductItemARData>() {
      public APINodeList<ProductItemARData> parseResponse(String response, APIContext context, APIRequest<ProductItemARData> request, String header) throws MalformedResponseException {
        return ProductItemARData.parseResponse(response, context, request, header);
      }
    };
  }
}
