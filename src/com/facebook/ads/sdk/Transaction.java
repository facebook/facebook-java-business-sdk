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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Transaction extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("time")
  private Long mTime = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("fatura_id")
  private Long mFaturaId = null;
  @SerializedName("charge_type")
  private String mChargeType = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("billing_start_time")
  private Long mBillingStartTime = null;
  @SerializedName("billing_end_time")
  private Long mBillingEndTime = null;
  @SerializedName("payment_option")
  private String mPaymentOption = null;
  @SerializedName("app_amount")
  private TransactionCurrencyAmount mAppAmount = null;
  @SerializedName("product_type")
  private EnumProductType mProductType = null;
  @SerializedName("provider_amount")
  private TransactionCurrencyAmount mProviderAmount = null;
  protected static Gson gson = null;

  public Transaction() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Transaction loadJSON(String json, APIContext context) {
    Transaction transaction = getGson().fromJson(json, Transaction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(transaction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    transaction.mContext = context;
    transaction.rawValue = json;
    return transaction;
  }

  public static APINodeList<Transaction> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<Transaction> transactions = new APINodeList<Transaction>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          transactions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return transactions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            transactions.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              transactions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            transactions.add(loadJSON(obj.toString(), context));
          }
          return transactions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              transactions.add(loadJSON(entry.getValue().toString(), context));
          }
          return transactions;
        } else {
          // Fifth, check if it's pure JsonObject
          transactions.add(loadJSON(json, context));
          return transactions;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldId() {
    return mId;
  }

  public Transaction setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Long getFieldTime() {
    return mTime;
  }

  public Transaction setFieldTime(Long value) {
    this.mTime = value;
    return this;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public Transaction setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public Long getFieldFaturaId() {
    return mFaturaId;
  }

  public Transaction setFieldFaturaId(Long value) {
    this.mFaturaId = value;
    return this;
  }

  public String getFieldChargeType() {
    return mChargeType;
  }

  public Transaction setFieldChargeType(String value) {
    this.mChargeType = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Transaction setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public Long getFieldBillingStartTime() {
    return mBillingStartTime;
  }

  public Transaction setFieldBillingStartTime(Long value) {
    this.mBillingStartTime = value;
    return this;
  }

  public Long getFieldBillingEndTime() {
    return mBillingEndTime;
  }

  public Transaction setFieldBillingEndTime(Long value) {
    this.mBillingEndTime = value;
    return this;
  }

  public String getFieldPaymentOption() {
    return mPaymentOption;
  }

  public Transaction setFieldPaymentOption(String value) {
    this.mPaymentOption = value;
    return this;
  }

  public TransactionCurrencyAmount getFieldAppAmount() {
    return mAppAmount;
  }

  public Transaction setFieldAppAmount(TransactionCurrencyAmount value) {
    this.mAppAmount = value;
    return this;
  }

  public Transaction setFieldAppAmount(String value) {
    Type type = new TypeToken<TransactionCurrencyAmount>(){}.getType();
    this.mAppAmount = TransactionCurrencyAmount.getGson().fromJson(value, type);
    return this;
  }
  public EnumProductType getFieldProductType() {
    return mProductType;
  }

  public Transaction setFieldProductType(EnumProductType value) {
    this.mProductType = value;
    return this;
  }

  public TransactionCurrencyAmount getFieldProviderAmount() {
    return mProviderAmount;
  }

  public Transaction setFieldProviderAmount(TransactionCurrencyAmount value) {
    this.mProviderAmount = value;
    return this;
  }

  public Transaction setFieldProviderAmount(String value) {
    Type type = new TypeToken<TransactionCurrencyAmount>(){}.getType();
    this.mProviderAmount = TransactionCurrencyAmount.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumProductType {
    @SerializedName("facebook_ad")
    VALUE_FACEBOOK_AD("facebook_ad"),
    @SerializedName("ig_ad")
    VALUE_IG_AD("ig_ad"),
    NULL(null);

    private String value;

    private EnumProductType(String value) {
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

  public Transaction copyFrom(Transaction instance) {
    this.mId = instance.mId;
    this.mTime = instance.mTime;
    this.mAccountId = instance.mAccountId;
    this.mFaturaId = instance.mFaturaId;
    this.mChargeType = instance.mChargeType;
    this.mStatus = instance.mStatus;
    this.mBillingStartTime = instance.mBillingStartTime;
    this.mBillingEndTime = instance.mBillingEndTime;
    this.mPaymentOption = instance.mPaymentOption;
    this.mAppAmount = instance.mAppAmount;
    this.mProductType = instance.mProductType;
    this.mProviderAmount = instance.mProviderAmount;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}