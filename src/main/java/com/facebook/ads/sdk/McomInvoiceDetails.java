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
public class McomInvoiceDetails extends APINode {
  @SerializedName("additional_amounts")
  private List<Object> mAdditionalAmounts = null;
  @SerializedName("buyer_notes")
  private String mBuyerNotes = null;
  @SerializedName("currency_amount")
  private Object mCurrencyAmount = null;
  @SerializedName("external_invoice_id")
  private String mExternalInvoiceId = null;
  @SerializedName("features")
  private Object mFeatures = null;
  @SerializedName("invoice_created")
  private Long mInvoiceCreated = null;
  @SerializedName("invoice_id")
  private String mInvoiceId = null;
  @SerializedName("invoice_instructions")
  private String mInvoiceInstructions = null;
  @SerializedName("invoice_instructions_image_url")
  private String mInvoiceInstructionsImageUrl = null;
  @SerializedName("invoice_updated")
  private Long mInvoiceUpdated = null;
  @SerializedName("outstanding_amount")
  private Object mOutstandingAmount = null;
  @SerializedName("paid_amount")
  private Object mPaidAmount = null;
  @SerializedName("payments")
  private List<Object> mPayments = null;
  @SerializedName("platform_logo_url")
  private String mPlatformLogoUrl = null;
  @SerializedName("platform_name")
  private String mPlatformName = null;
  @SerializedName("product_items")
  private List<Object> mProductItems = null;
  @SerializedName("shipping_address")
  private Object mShippingAddress = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tracking_info")
  private Object mTrackingInfo = null;
  protected static Gson gson = null;

  public McomInvoiceDetails() {
  }

  public String getId() {
    return null;
  }
  public static McomInvoiceDetails loadJSON(String json, APIContext context, String header) {
    McomInvoiceDetails mcomInvoiceDetails = getGson().fromJson(json, McomInvoiceDetails.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mcomInvoiceDetails.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mcomInvoiceDetails.context = context;
    mcomInvoiceDetails.rawValue = json;
    mcomInvoiceDetails.header = header;
    return mcomInvoiceDetails;
  }

  public static APINodeList<McomInvoiceDetails> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<McomInvoiceDetails> mcomInvoiceDetailss = new APINodeList<McomInvoiceDetails>(request, json, header);
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
          mcomInvoiceDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mcomInvoiceDetailss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mcomInvoiceDetailss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mcomInvoiceDetailss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mcomInvoiceDetailss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mcomInvoiceDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mcomInvoiceDetailss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mcomInvoiceDetailss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mcomInvoiceDetailss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mcomInvoiceDetailss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mcomInvoiceDetailss;
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
              mcomInvoiceDetailss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mcomInvoiceDetailss;
          }

          // Sixth, check if it's pure JsonObject
          mcomInvoiceDetailss.clear();
          mcomInvoiceDetailss.add(loadJSON(json, context, header));
          return mcomInvoiceDetailss;
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


  public List<Object> getFieldAdditionalAmounts() {
    return mAdditionalAmounts;
  }

  public McomInvoiceDetails setFieldAdditionalAmounts(List<Object> value) {
    this.mAdditionalAmounts = value;
    return this;
  }

  public String getFieldBuyerNotes() {
    return mBuyerNotes;
  }

  public McomInvoiceDetails setFieldBuyerNotes(String value) {
    this.mBuyerNotes = value;
    return this;
  }

  public Object getFieldCurrencyAmount() {
    return mCurrencyAmount;
  }

  public McomInvoiceDetails setFieldCurrencyAmount(Object value) {
    this.mCurrencyAmount = value;
    return this;
  }

  public String getFieldExternalInvoiceId() {
    return mExternalInvoiceId;
  }

  public McomInvoiceDetails setFieldExternalInvoiceId(String value) {
    this.mExternalInvoiceId = value;
    return this;
  }

  public Object getFieldFeatures() {
    return mFeatures;
  }

  public McomInvoiceDetails setFieldFeatures(Object value) {
    this.mFeatures = value;
    return this;
  }

  public Long getFieldInvoiceCreated() {
    return mInvoiceCreated;
  }

  public McomInvoiceDetails setFieldInvoiceCreated(Long value) {
    this.mInvoiceCreated = value;
    return this;
  }

  public String getFieldInvoiceId() {
    return mInvoiceId;
  }

  public McomInvoiceDetails setFieldInvoiceId(String value) {
    this.mInvoiceId = value;
    return this;
  }

  public String getFieldInvoiceInstructions() {
    return mInvoiceInstructions;
  }

  public McomInvoiceDetails setFieldInvoiceInstructions(String value) {
    this.mInvoiceInstructions = value;
    return this;
  }

  public String getFieldInvoiceInstructionsImageUrl() {
    return mInvoiceInstructionsImageUrl;
  }

  public McomInvoiceDetails setFieldInvoiceInstructionsImageUrl(String value) {
    this.mInvoiceInstructionsImageUrl = value;
    return this;
  }

  public Long getFieldInvoiceUpdated() {
    return mInvoiceUpdated;
  }

  public McomInvoiceDetails setFieldInvoiceUpdated(Long value) {
    this.mInvoiceUpdated = value;
    return this;
  }

  public Object getFieldOutstandingAmount() {
    return mOutstandingAmount;
  }

  public McomInvoiceDetails setFieldOutstandingAmount(Object value) {
    this.mOutstandingAmount = value;
    return this;
  }

  public Object getFieldPaidAmount() {
    return mPaidAmount;
  }

  public McomInvoiceDetails setFieldPaidAmount(Object value) {
    this.mPaidAmount = value;
    return this;
  }

  public List<Object> getFieldPayments() {
    return mPayments;
  }

  public McomInvoiceDetails setFieldPayments(List<Object> value) {
    this.mPayments = value;
    return this;
  }

  public String getFieldPlatformLogoUrl() {
    return mPlatformLogoUrl;
  }

  public McomInvoiceDetails setFieldPlatformLogoUrl(String value) {
    this.mPlatformLogoUrl = value;
    return this;
  }

  public String getFieldPlatformName() {
    return mPlatformName;
  }

  public McomInvoiceDetails setFieldPlatformName(String value) {
    this.mPlatformName = value;
    return this;
  }

  public List<Object> getFieldProductItems() {
    return mProductItems;
  }

  public McomInvoiceDetails setFieldProductItems(List<Object> value) {
    this.mProductItems = value;
    return this;
  }

  public Object getFieldShippingAddress() {
    return mShippingAddress;
  }

  public McomInvoiceDetails setFieldShippingAddress(Object value) {
    this.mShippingAddress = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public McomInvoiceDetails setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public Object getFieldTrackingInfo() {
    return mTrackingInfo;
  }

  public McomInvoiceDetails setFieldTrackingInfo(Object value) {
    this.mTrackingInfo = value;
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

  public McomInvoiceDetails copyFrom(McomInvoiceDetails instance) {
    this.mAdditionalAmounts = instance.mAdditionalAmounts;
    this.mBuyerNotes = instance.mBuyerNotes;
    this.mCurrencyAmount = instance.mCurrencyAmount;
    this.mExternalInvoiceId = instance.mExternalInvoiceId;
    this.mFeatures = instance.mFeatures;
    this.mInvoiceCreated = instance.mInvoiceCreated;
    this.mInvoiceId = instance.mInvoiceId;
    this.mInvoiceInstructions = instance.mInvoiceInstructions;
    this.mInvoiceInstructionsImageUrl = instance.mInvoiceInstructionsImageUrl;
    this.mInvoiceUpdated = instance.mInvoiceUpdated;
    this.mOutstandingAmount = instance.mOutstandingAmount;
    this.mPaidAmount = instance.mPaidAmount;
    this.mPayments = instance.mPayments;
    this.mPlatformLogoUrl = instance.mPlatformLogoUrl;
    this.mPlatformName = instance.mPlatformName;
    this.mProductItems = instance.mProductItems;
    this.mShippingAddress = instance.mShippingAddress;
    this.mStatus = instance.mStatus;
    this.mTrackingInfo = instance.mTrackingInfo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<McomInvoiceDetails> getParser() {
    return new APIRequest.ResponseParser<McomInvoiceDetails>() {
      public APINodeList<McomInvoiceDetails> parseResponse(String response, APIContext context, APIRequest<McomInvoiceDetails> request, String header) throws MalformedResponseException {
        return McomInvoiceDetails.parseResponse(response, context, request, header);
      }
    };
  }
}
