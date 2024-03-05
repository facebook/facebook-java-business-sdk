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
public class PaymentSubscription extends APINode {
  @SerializedName("amount")
  private String mAmount = null;
  @SerializedName("app_param_data")
  private String mAppParamData = null;
  @SerializedName("application")
  private Application mApplication = null;
  @SerializedName("billing_period")
  private String mBillingPeriod = null;
  @SerializedName("canceled_reason")
  private String mCanceledReason = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_payment")
  private PaymentEnginePayment mLastPayment = null;
  @SerializedName("next_bill_time")
  private String mNextBillTime = null;
  @SerializedName("next_period_amount")
  private String mNextPeriodAmount = null;
  @SerializedName("next_period_currency")
  private String mNextPeriodCurrency = null;
  @SerializedName("next_period_product")
  private String mNextPeriodProduct = null;
  @SerializedName("payment_status")
  private String mPaymentStatus = null;
  @SerializedName("pending_cancel")
  private Boolean mPendingCancel = null;
  @SerializedName("period_start_time")
  private String mPeriodStartTime = null;
  @SerializedName("product")
  private String mProduct = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("test")
  private Long mTest = null;
  @SerializedName("trial_amount")
  private String mTrialAmount = null;
  @SerializedName("trial_currency")
  private String mTrialCurrency = null;
  @SerializedName("trial_expiry_time")
  private String mTrialExpiryTime = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  PaymentSubscription() {
  }

  public PaymentSubscription(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PaymentSubscription(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PaymentSubscription fetch() throws APIException{
    PaymentSubscription newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PaymentSubscription fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PaymentSubscription> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PaymentSubscription fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PaymentSubscription> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PaymentSubscription> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PaymentSubscription>)(
      new APIRequest<PaymentSubscription>(context, "", "/", "GET", PaymentSubscription.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PaymentSubscription>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PaymentSubscription.getParser())
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
  public static PaymentSubscription loadJSON(String json, APIContext context, String header) {
    PaymentSubscription paymentSubscription = getGson().fromJson(json, PaymentSubscription.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(paymentSubscription.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    paymentSubscription.context = context;
    paymentSubscription.rawValue = json;
    paymentSubscription.header = header;
    return paymentSubscription;
  }

  public static APINodeList<PaymentSubscription> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PaymentSubscription> paymentSubscriptions = new APINodeList<PaymentSubscription>(request, json, header);
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
          paymentSubscriptions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return paymentSubscriptions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                paymentSubscriptions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            paymentSubscriptions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              paymentSubscriptions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              paymentSubscriptions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  paymentSubscriptions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              paymentSubscriptions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return paymentSubscriptions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              paymentSubscriptions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return paymentSubscriptions;
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
              paymentSubscriptions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return paymentSubscriptions;
          }

          // Sixth, check if it's pure JsonObject
          paymentSubscriptions.clear();
          paymentSubscriptions.add(loadJSON(json, context, header));
          return paymentSubscriptions;
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


  public String getFieldAmount() {
    return mAmount;
  }

  public String getFieldAppParamData() {
    return mAppParamData;
  }

  public Application getFieldApplication() {
    if (mApplication != null) {
      mApplication.context = getContext();
    }
    return mApplication;
  }

  public String getFieldBillingPeriod() {
    return mBillingPeriod;
  }

  public String getFieldCanceledReason() {
    return mCanceledReason;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldId() {
    return mId;
  }

  public PaymentEnginePayment getFieldLastPayment() {
    if (mLastPayment != null) {
      mLastPayment.context = getContext();
    }
    return mLastPayment;
  }

  public String getFieldNextBillTime() {
    return mNextBillTime;
  }

  public String getFieldNextPeriodAmount() {
    return mNextPeriodAmount;
  }

  public String getFieldNextPeriodCurrency() {
    return mNextPeriodCurrency;
  }

  public String getFieldNextPeriodProduct() {
    return mNextPeriodProduct;
  }

  public String getFieldPaymentStatus() {
    return mPaymentStatus;
  }

  public Boolean getFieldPendingCancel() {
    return mPendingCancel;
  }

  public String getFieldPeriodStartTime() {
    return mPeriodStartTime;
  }

  public String getFieldProduct() {
    return mProduct;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Long getFieldTest() {
    return mTest;
  }

  public String getFieldTrialAmount() {
    return mTrialAmount;
  }

  public String getFieldTrialCurrency() {
    return mTrialCurrency;
  }

  public String getFieldTrialExpiryTime() {
    return mTrialExpiryTime;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }



  public static class APIRequestGet extends APIRequest<PaymentSubscription> {

    PaymentSubscription lastResponse = null;
    @Override
    public PaymentSubscription getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "amount",
      "app_param_data",
      "application",
      "billing_period",
      "canceled_reason",
      "created_time",
      "currency",
      "id",
      "last_payment",
      "next_bill_time",
      "next_period_amount",
      "next_period_currency",
      "next_period_product",
      "payment_status",
      "pending_cancel",
      "period_start_time",
      "product",
      "status",
      "test",
      "trial_amount",
      "trial_currency",
      "trial_expiry_time",
      "updated_time",
      "user",
    };

    @Override
    public PaymentSubscription parseResponse(String response, String header) throws APIException {
      return PaymentSubscription.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PaymentSubscription execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PaymentSubscription execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PaymentSubscription> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PaymentSubscription> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PaymentSubscription>() {
           public PaymentSubscription apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGet requestAmountField () {
      return this.requestAmountField(true);
    }
    public APIRequestGet requestAmountField (boolean value) {
      this.requestField("amount", value);
      return this;
    }
    public APIRequestGet requestAppParamDataField () {
      return this.requestAppParamDataField(true);
    }
    public APIRequestGet requestAppParamDataField (boolean value) {
      this.requestField("app_param_data", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestBillingPeriodField () {
      return this.requestBillingPeriodField(true);
    }
    public APIRequestGet requestBillingPeriodField (boolean value) {
      this.requestField("billing_period", value);
      return this;
    }
    public APIRequestGet requestCanceledReasonField () {
      return this.requestCanceledReasonField(true);
    }
    public APIRequestGet requestCanceledReasonField (boolean value) {
      this.requestField("canceled_reason", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastPaymentField () {
      return this.requestLastPaymentField(true);
    }
    public APIRequestGet requestLastPaymentField (boolean value) {
      this.requestField("last_payment", value);
      return this;
    }
    public APIRequestGet requestNextBillTimeField () {
      return this.requestNextBillTimeField(true);
    }
    public APIRequestGet requestNextBillTimeField (boolean value) {
      this.requestField("next_bill_time", value);
      return this;
    }
    public APIRequestGet requestNextPeriodAmountField () {
      return this.requestNextPeriodAmountField(true);
    }
    public APIRequestGet requestNextPeriodAmountField (boolean value) {
      this.requestField("next_period_amount", value);
      return this;
    }
    public APIRequestGet requestNextPeriodCurrencyField () {
      return this.requestNextPeriodCurrencyField(true);
    }
    public APIRequestGet requestNextPeriodCurrencyField (boolean value) {
      this.requestField("next_period_currency", value);
      return this;
    }
    public APIRequestGet requestNextPeriodProductField () {
      return this.requestNextPeriodProductField(true);
    }
    public APIRequestGet requestNextPeriodProductField (boolean value) {
      this.requestField("next_period_product", value);
      return this;
    }
    public APIRequestGet requestPaymentStatusField () {
      return this.requestPaymentStatusField(true);
    }
    public APIRequestGet requestPaymentStatusField (boolean value) {
      this.requestField("payment_status", value);
      return this;
    }
    public APIRequestGet requestPendingCancelField () {
      return this.requestPendingCancelField(true);
    }
    public APIRequestGet requestPendingCancelField (boolean value) {
      this.requestField("pending_cancel", value);
      return this;
    }
    public APIRequestGet requestPeriodStartTimeField () {
      return this.requestPeriodStartTimeField(true);
    }
    public APIRequestGet requestPeriodStartTimeField (boolean value) {
      this.requestField("period_start_time", value);
      return this;
    }
    public APIRequestGet requestProductField () {
      return this.requestProductField(true);
    }
    public APIRequestGet requestProductField (boolean value) {
      this.requestField("product", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTestField () {
      return this.requestTestField(true);
    }
    public APIRequestGet requestTestField (boolean value) {
      this.requestField("test", value);
      return this;
    }
    public APIRequestGet requestTrialAmountField () {
      return this.requestTrialAmountField(true);
    }
    public APIRequestGet requestTrialAmountField (boolean value) {
      this.requestField("trial_amount", value);
      return this;
    }
    public APIRequestGet requestTrialCurrencyField () {
      return this.requestTrialCurrencyField(true);
    }
    public APIRequestGet requestTrialCurrencyField (boolean value) {
      this.requestField("trial_currency", value);
      return this;
    }
    public APIRequestGet requestTrialExpiryTimeField () {
      return this.requestTrialExpiryTimeField(true);
    }
    public APIRequestGet requestTrialExpiryTimeField (boolean value) {
      this.requestField("trial_expiry_time", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
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

  public PaymentSubscription copyFrom(PaymentSubscription instance) {
    this.mAmount = instance.mAmount;
    this.mAppParamData = instance.mAppParamData;
    this.mApplication = instance.mApplication;
    this.mBillingPeriod = instance.mBillingPeriod;
    this.mCanceledReason = instance.mCanceledReason;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCurrency = instance.mCurrency;
    this.mId = instance.mId;
    this.mLastPayment = instance.mLastPayment;
    this.mNextBillTime = instance.mNextBillTime;
    this.mNextPeriodAmount = instance.mNextPeriodAmount;
    this.mNextPeriodCurrency = instance.mNextPeriodCurrency;
    this.mNextPeriodProduct = instance.mNextPeriodProduct;
    this.mPaymentStatus = instance.mPaymentStatus;
    this.mPendingCancel = instance.mPendingCancel;
    this.mPeriodStartTime = instance.mPeriodStartTime;
    this.mProduct = instance.mProduct;
    this.mStatus = instance.mStatus;
    this.mTest = instance.mTest;
    this.mTrialAmount = instance.mTrialAmount;
    this.mTrialCurrency = instance.mTrialCurrency;
    this.mTrialExpiryTime = instance.mTrialExpiryTime;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PaymentSubscription> getParser() {
    return new APIRequest.ResponseParser<PaymentSubscription>() {
      public APINodeList<PaymentSubscription> parseResponse(String response, APIContext context, APIRequest<PaymentSubscription> request, String header) throws MalformedResponseException {
        return PaymentSubscription.parseResponse(response, context, request, header);
      }
    };
  }
}
