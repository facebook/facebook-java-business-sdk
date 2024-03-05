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
public class ShadowIGMediaProductTags extends APINode {
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("is_checkout")
  private Boolean mIsCheckout = null;
  @SerializedName("merchant_id")
  private Long mMerchantId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("price_string")
  private String mPriceString = null;
  @SerializedName("product_id")
  private Long mProductId = null;
  @SerializedName("review_status")
  private String mReviewStatus = null;
  @SerializedName("stripped_price_string")
  private String mStrippedPriceString = null;
  @SerializedName("stripped_sale_price_string")
  private String mStrippedSalePriceString = null;
  @SerializedName("x")
  private Double mX = null;
  @SerializedName("y")
  private Double mY = null;
  protected static Gson gson = null;

  public ShadowIGMediaProductTags() {
  }

  public String getId() {
    return null;
  }
  public static ShadowIGMediaProductTags loadJSON(String json, APIContext context, String header) {
    ShadowIGMediaProductTags shadowIGMediaProductTags = getGson().fromJson(json, ShadowIGMediaProductTags.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGMediaProductTags.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shadowIGMediaProductTags.context = context;
    shadowIGMediaProductTags.rawValue = json;
    shadowIGMediaProductTags.header = header;
    return shadowIGMediaProductTags;
  }

  public static APINodeList<ShadowIGMediaProductTags> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ShadowIGMediaProductTags> shadowIGMediaProductTagss = new APINodeList<ShadowIGMediaProductTags>(request, json, header);
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
          shadowIGMediaProductTagss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shadowIGMediaProductTagss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGMediaProductTagss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGMediaProductTagss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGMediaProductTagss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGMediaProductTagss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shadowIGMediaProductTagss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGMediaProductTagss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shadowIGMediaProductTagss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGMediaProductTagss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shadowIGMediaProductTagss;
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
              shadowIGMediaProductTagss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGMediaProductTagss;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGMediaProductTagss.clear();
          shadowIGMediaProductTagss.add(loadJSON(json, context, header));
          return shadowIGMediaProductTagss;
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


  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public ShadowIGMediaProductTags setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public Boolean getFieldIsCheckout() {
    return mIsCheckout;
  }

  public ShadowIGMediaProductTags setFieldIsCheckout(Boolean value) {
    this.mIsCheckout = value;
    return this;
  }

  public Long getFieldMerchantId() {
    return mMerchantId;
  }

  public ShadowIGMediaProductTags setFieldMerchantId(Long value) {
    this.mMerchantId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public ShadowIGMediaProductTags setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPriceString() {
    return mPriceString;
  }

  public ShadowIGMediaProductTags setFieldPriceString(String value) {
    this.mPriceString = value;
    return this;
  }

  public Long getFieldProductId() {
    return mProductId;
  }

  public ShadowIGMediaProductTags setFieldProductId(Long value) {
    this.mProductId = value;
    return this;
  }

  public String getFieldReviewStatus() {
    return mReviewStatus;
  }

  public ShadowIGMediaProductTags setFieldReviewStatus(String value) {
    this.mReviewStatus = value;
    return this;
  }

  public String getFieldStrippedPriceString() {
    return mStrippedPriceString;
  }

  public ShadowIGMediaProductTags setFieldStrippedPriceString(String value) {
    this.mStrippedPriceString = value;
    return this;
  }

  public String getFieldStrippedSalePriceString() {
    return mStrippedSalePriceString;
  }

  public ShadowIGMediaProductTags setFieldStrippedSalePriceString(String value) {
    this.mStrippedSalePriceString = value;
    return this;
  }

  public Double getFieldX() {
    return mX;
  }

  public ShadowIGMediaProductTags setFieldX(Double value) {
    this.mX = value;
    return this;
  }

  public Double getFieldY() {
    return mY;
  }

  public ShadowIGMediaProductTags setFieldY(Double value) {
    this.mY = value;
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

  public ShadowIGMediaProductTags copyFrom(ShadowIGMediaProductTags instance) {
    this.mImageUrl = instance.mImageUrl;
    this.mIsCheckout = instance.mIsCheckout;
    this.mMerchantId = instance.mMerchantId;
    this.mName = instance.mName;
    this.mPriceString = instance.mPriceString;
    this.mProductId = instance.mProductId;
    this.mReviewStatus = instance.mReviewStatus;
    this.mStrippedPriceString = instance.mStrippedPriceString;
    this.mStrippedSalePriceString = instance.mStrippedSalePriceString;
    this.mX = instance.mX;
    this.mY = instance.mY;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGMediaProductTags> getParser() {
    return new APIRequest.ResponseParser<ShadowIGMediaProductTags>() {
      public APINodeList<ShadowIGMediaProductTags> parseResponse(String response, APIContext context, APIRequest<ShadowIGMediaProductTags> request, String header) throws MalformedResponseException {
        return ShadowIGMediaProductTags.parseResponse(response, context, request, header);
      }
    };
  }
}
