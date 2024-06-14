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
public class MerchantReport extends APINode {
  @SerializedName("add_to_cart")
  private Long mAddToCart = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("catalog_segment_id")
  private String mCatalogSegmentId = null;
  @SerializedName("catalog_segment_purchase_value")
  private Double mCatalogSegmentPurchaseValue = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("date")
  private String mDate = null;
  @SerializedName("latest_date")
  private String mLatestDate = null;
  @SerializedName("link_clicks")
  private Long mLinkClicks = null;
  @SerializedName("merchant_currency")
  private String mMerchantCurrency = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("product_quantity")
  private Long mProductQuantity = null;
  @SerializedName("product_total_value")
  private Double mProductTotalValue = null;
  @SerializedName("purchase")
  private Long mPurchase = null;
  @SerializedName("purchase_value")
  private Double mPurchaseValue = null;
  protected static Gson gson = null;

  public MerchantReport() {
  }

  public String getId() {
    return null;
  }
  public static MerchantReport loadJSON(String json, APIContext context, String header) {
    MerchantReport merchantReport = getGson().fromJson(json, MerchantReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(merchantReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    merchantReport.context = context;
    merchantReport.rawValue = json;
    merchantReport.header = header;
    return merchantReport;
  }

  public static APINodeList<MerchantReport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MerchantReport> merchantReports = new APINodeList<MerchantReport>(request, json, header);
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
          merchantReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return merchantReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                merchantReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            merchantReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              merchantReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              merchantReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  merchantReports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              merchantReports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return merchantReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              merchantReports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return merchantReports;
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
              merchantReports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return merchantReports;
          }

          // Sixth, check if it's pure JsonObject
          merchantReports.clear();
          merchantReports.add(loadJSON(json, context, header));
          return merchantReports;
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


  public Long getFieldAddToCart() {
    return mAddToCart;
  }

  public MerchantReport setFieldAddToCart(Long value) {
    this.mAddToCart = value;
    return this;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public MerchantReport setFieldBrand(String value) {
    this.mBrand = value;
    return this;
  }

  public String getFieldCatalogSegmentId() {
    return mCatalogSegmentId;
  }

  public MerchantReport setFieldCatalogSegmentId(String value) {
    this.mCatalogSegmentId = value;
    return this;
  }

  public Double getFieldCatalogSegmentPurchaseValue() {
    return mCatalogSegmentPurchaseValue;
  }

  public MerchantReport setFieldCatalogSegmentPurchaseValue(Double value) {
    this.mCatalogSegmentPurchaseValue = value;
    return this;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public MerchantReport setFieldCategory(String value) {
    this.mCategory = value;
    return this;
  }

  public String getFieldDate() {
    return mDate;
  }

  public MerchantReport setFieldDate(String value) {
    this.mDate = value;
    return this;
  }

  public String getFieldLatestDate() {
    return mLatestDate;
  }

  public MerchantReport setFieldLatestDate(String value) {
    this.mLatestDate = value;
    return this;
  }

  public Long getFieldLinkClicks() {
    return mLinkClicks;
  }

  public MerchantReport setFieldLinkClicks(Long value) {
    this.mLinkClicks = value;
    return this;
  }

  public String getFieldMerchantCurrency() {
    return mMerchantCurrency;
  }

  public MerchantReport setFieldMerchantCurrency(String value) {
    this.mMerchantCurrency = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public MerchantReport setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public MerchantReport setFieldProductId(String value) {
    this.mProductId = value;
    return this;
  }

  public Long getFieldProductQuantity() {
    return mProductQuantity;
  }

  public MerchantReport setFieldProductQuantity(Long value) {
    this.mProductQuantity = value;
    return this;
  }

  public Double getFieldProductTotalValue() {
    return mProductTotalValue;
  }

  public MerchantReport setFieldProductTotalValue(Double value) {
    this.mProductTotalValue = value;
    return this;
  }

  public Long getFieldPurchase() {
    return mPurchase;
  }

  public MerchantReport setFieldPurchase(Long value) {
    this.mPurchase = value;
    return this;
  }

  public Double getFieldPurchaseValue() {
    return mPurchaseValue;
  }

  public MerchantReport setFieldPurchaseValue(Double value) {
    this.mPurchaseValue = value;
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

  public MerchantReport copyFrom(MerchantReport instance) {
    this.mAddToCart = instance.mAddToCart;
    this.mBrand = instance.mBrand;
    this.mCatalogSegmentId = instance.mCatalogSegmentId;
    this.mCatalogSegmentPurchaseValue = instance.mCatalogSegmentPurchaseValue;
    this.mCategory = instance.mCategory;
    this.mDate = instance.mDate;
    this.mLatestDate = instance.mLatestDate;
    this.mLinkClicks = instance.mLinkClicks;
    this.mMerchantCurrency = instance.mMerchantCurrency;
    this.mPageId = instance.mPageId;
    this.mProductId = instance.mProductId;
    this.mProductQuantity = instance.mProductQuantity;
    this.mProductTotalValue = instance.mProductTotalValue;
    this.mPurchase = instance.mPurchase;
    this.mPurchaseValue = instance.mPurchaseValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MerchantReport> getParser() {
    return new APIRequest.ResponseParser<MerchantReport>() {
      public APINodeList<MerchantReport> parseResponse(String response, APIContext context, APIRequest<MerchantReport> request, String header) throws MalformedResponseException {
        return MerchantReport.parseResponse(response, context, request, header);
      }
    };
  }
}
