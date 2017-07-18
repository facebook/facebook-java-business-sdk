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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class Transaction extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("app_amount")
  private TransactionCurrencyAmount mAppAmount = null;
  @SerializedName("billing_end_time")
  private Long mBillingEndTime = null;
  @SerializedName("billing_reason")
  private String mBillingReason = null;
  @SerializedName("billing_start_time")
  private Long mBillingStartTime = null;
  @SerializedName("charge_type")
  private String mChargeType = null;
  @SerializedName("checkout_campaign_group_id")
  private String mCheckoutCampaignGroupId = null;
  @SerializedName("credential_id")
  private String mCredentialId = null;
  @SerializedName("fatura_id")
  private Long mFaturaId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_business_ec_charge")
  private Boolean mIsBusinessEcCharge = null;
  @SerializedName("payment_option")
  private String mPaymentOption = null;
  @SerializedName("product_type")
  private EnumProductType mProductType = null;
  @SerializedName("provider_amount")
  private TransactionCurrencyAmount mProviderAmount = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("time")
  private Long mTime = null;
  @SerializedName("tracking_id")
  private String mTrackingId = null;
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    transaction.context = context;
    transaction.rawValue = json;
    return transaction;
  }

  public static APINodeList<Transaction> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Transaction> transactions = new APINodeList<Transaction>(request, json);
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
          transactions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return transactions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            transactions.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  transactions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              transactions.add(loadJSON(obj.toString(), context));
            }
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
              transactions.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return transactions;
          }

          // Sixth, check if it's pure JsonObject
          transactions.clear();
          transactions.add(loadJSON(json, context));
          return transactions;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Transaction setFieldAccountId(String value) {
    this.mAccountId = value;
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
  public Long getFieldBillingEndTime() {
    return mBillingEndTime;
  }

  public Transaction setFieldBillingEndTime(Long value) {
    this.mBillingEndTime = value;
    return this;
  }

  public String getFieldBillingReason() {
    return mBillingReason;
  }

  public Transaction setFieldBillingReason(String value) {
    this.mBillingReason = value;
    return this;
  }

  public Long getFieldBillingStartTime() {
    return mBillingStartTime;
  }

  public Transaction setFieldBillingStartTime(Long value) {
    this.mBillingStartTime = value;
    return this;
  }

  public String getFieldChargeType() {
    return mChargeType;
  }

  public Transaction setFieldChargeType(String value) {
    this.mChargeType = value;
    return this;
  }

  public String getFieldCheckoutCampaignGroupId() {
    return mCheckoutCampaignGroupId;
  }

  public Transaction setFieldCheckoutCampaignGroupId(String value) {
    this.mCheckoutCampaignGroupId = value;
    return this;
  }

  public String getFieldCredentialId() {
    return mCredentialId;
  }

  public Transaction setFieldCredentialId(String value) {
    this.mCredentialId = value;
    return this;
  }

  public Long getFieldFaturaId() {
    return mFaturaId;
  }

  public Transaction setFieldFaturaId(Long value) {
    this.mFaturaId = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public Transaction setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsBusinessEcCharge() {
    return mIsBusinessEcCharge;
  }

  public Transaction setFieldIsBusinessEcCharge(Boolean value) {
    this.mIsBusinessEcCharge = value;
    return this;
  }

  public String getFieldPaymentOption() {
    return mPaymentOption;
  }

  public Transaction setFieldPaymentOption(String value) {
    this.mPaymentOption = value;
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
  public String getFieldStatus() {
    return mStatus;
  }

  public Transaction setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public Long getFieldTime() {
    return mTime;
  }

  public Transaction setFieldTime(Long value) {
    this.mTime = value;
    return this;
  }

  public String getFieldTrackingId() {
    return mTrackingId;
  }

  public Transaction setFieldTrackingId(String value) {
    this.mTrackingId = value;
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
    this.mAccountId = instance.mAccountId;
    this.mAppAmount = instance.mAppAmount;
    this.mBillingEndTime = instance.mBillingEndTime;
    this.mBillingReason = instance.mBillingReason;
    this.mBillingStartTime = instance.mBillingStartTime;
    this.mChargeType = instance.mChargeType;
    this.mCheckoutCampaignGroupId = instance.mCheckoutCampaignGroupId;
    this.mCredentialId = instance.mCredentialId;
    this.mFaturaId = instance.mFaturaId;
    this.mId = instance.mId;
    this.mIsBusinessEcCharge = instance.mIsBusinessEcCharge;
    this.mPaymentOption = instance.mPaymentOption;
    this.mProductType = instance.mProductType;
    this.mProviderAmount = instance.mProviderAmount;
    this.mStatus = instance.mStatus;
    this.mTime = instance.mTime;
    this.mTrackingId = instance.mTrackingId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Transaction> getParser() {
    return new APIRequest.ResponseParser<Transaction>() {
      public APINodeList<Transaction> parseResponse(String response, APIContext context, APIRequest<Transaction> request) throws MalformedResponseException {
        return Transaction.parseResponse(response, context, request);
      }
    };
  }
}
