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
public class McomInvoiceStatus extends APINode {
  @SerializedName("bank_account_number")
  private String mBankAccountNumber = null;
  @SerializedName("bank_code")
  private String mBankCode = null;
  @SerializedName("invoice_id")
  private String mInvoiceId = null;
  @SerializedName("invoice_status")
  private String mInvoiceStatus = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("payment_method")
  private String mPaymentMethod = null;
  @SerializedName("payment_type")
  private String mPaymentType = null;
  @SerializedName("payout_amount")
  private Object mPayoutAmount = null;
  @SerializedName("slip_verification_error")
  private String mSlipVerificationError = null;
  @SerializedName("slip_verification_status")
  private String mSlipVerificationStatus = null;
  @SerializedName("transaction_fee")
  private Object mTransactionFee = null;
  @SerializedName("transfer_slip")
  private String mTransferSlip = null;
  protected static Gson gson = null;

  public McomInvoiceStatus() {
  }

  public String getId() {
    return null;
  }
  public static McomInvoiceStatus loadJSON(String json, APIContext context, String header) {
    McomInvoiceStatus mcomInvoiceStatus = getGson().fromJson(json, McomInvoiceStatus.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mcomInvoiceStatus.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mcomInvoiceStatus.context = context;
    mcomInvoiceStatus.rawValue = json;
    mcomInvoiceStatus.header = header;
    return mcomInvoiceStatus;
  }

  public static APINodeList<McomInvoiceStatus> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<McomInvoiceStatus> mcomInvoiceStatuss = new APINodeList<McomInvoiceStatus>(request, json, header);
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
          mcomInvoiceStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mcomInvoiceStatuss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mcomInvoiceStatuss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mcomInvoiceStatuss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mcomInvoiceStatuss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mcomInvoiceStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mcomInvoiceStatuss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mcomInvoiceStatuss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mcomInvoiceStatuss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mcomInvoiceStatuss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mcomInvoiceStatuss;
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
              mcomInvoiceStatuss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mcomInvoiceStatuss;
          }

          // Sixth, check if it's pure JsonObject
          mcomInvoiceStatuss.clear();
          mcomInvoiceStatuss.add(loadJSON(json, context, header));
          return mcomInvoiceStatuss;
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


  public String getFieldBankAccountNumber() {
    return mBankAccountNumber;
  }

  public McomInvoiceStatus setFieldBankAccountNumber(String value) {
    this.mBankAccountNumber = value;
    return this;
  }

  public String getFieldBankCode() {
    return mBankCode;
  }

  public McomInvoiceStatus setFieldBankCode(String value) {
    this.mBankCode = value;
    return this;
  }

  public String getFieldInvoiceId() {
    return mInvoiceId;
  }

  public McomInvoiceStatus setFieldInvoiceId(String value) {
    this.mInvoiceId = value;
    return this;
  }

  public String getFieldInvoiceStatus() {
    return mInvoiceStatus;
  }

  public McomInvoiceStatus setFieldInvoiceStatus(String value) {
    this.mInvoiceStatus = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public McomInvoiceStatus setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public String getFieldPaymentMethod() {
    return mPaymentMethod;
  }

  public McomInvoiceStatus setFieldPaymentMethod(String value) {
    this.mPaymentMethod = value;
    return this;
  }

  public String getFieldPaymentType() {
    return mPaymentType;
  }

  public McomInvoiceStatus setFieldPaymentType(String value) {
    this.mPaymentType = value;
    return this;
  }

  public Object getFieldPayoutAmount() {
    return mPayoutAmount;
  }

  public McomInvoiceStatus setFieldPayoutAmount(Object value) {
    this.mPayoutAmount = value;
    return this;
  }

  public String getFieldSlipVerificationError() {
    return mSlipVerificationError;
  }

  public McomInvoiceStatus setFieldSlipVerificationError(String value) {
    this.mSlipVerificationError = value;
    return this;
  }

  public String getFieldSlipVerificationStatus() {
    return mSlipVerificationStatus;
  }

  public McomInvoiceStatus setFieldSlipVerificationStatus(String value) {
    this.mSlipVerificationStatus = value;
    return this;
  }

  public Object getFieldTransactionFee() {
    return mTransactionFee;
  }

  public McomInvoiceStatus setFieldTransactionFee(Object value) {
    this.mTransactionFee = value;
    return this;
  }

  public String getFieldTransferSlip() {
    return mTransferSlip;
  }

  public McomInvoiceStatus setFieldTransferSlip(String value) {
    this.mTransferSlip = value;
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

  public McomInvoiceStatus copyFrom(McomInvoiceStatus instance) {
    this.mBankAccountNumber = instance.mBankAccountNumber;
    this.mBankCode = instance.mBankCode;
    this.mInvoiceId = instance.mInvoiceId;
    this.mInvoiceStatus = instance.mInvoiceStatus;
    this.mPageId = instance.mPageId;
    this.mPaymentMethod = instance.mPaymentMethod;
    this.mPaymentType = instance.mPaymentType;
    this.mPayoutAmount = instance.mPayoutAmount;
    this.mSlipVerificationError = instance.mSlipVerificationError;
    this.mSlipVerificationStatus = instance.mSlipVerificationStatus;
    this.mTransactionFee = instance.mTransactionFee;
    this.mTransferSlip = instance.mTransferSlip;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<McomInvoiceStatus> getParser() {
    return new APIRequest.ResponseParser<McomInvoiceStatus>() {
      public APINodeList<McomInvoiceStatus> parseResponse(String response, APIContext context, APIRequest<McomInvoiceStatus> request, String header) throws MalformedResponseException {
        return McomInvoiceStatus.parseResponse(response, context, request, header);
      }
    };
  }
}
