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
public class PaymentEnginePayment extends APINode {
  @SerializedName("actions")
  private List<Object> mActions = null;
  @SerializedName("application")
  private Application mApplication = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("disputes")
  private List<Object> mDisputes = null;
  @SerializedName("fraud_status")
  private String mFraudStatus = null;
  @SerializedName("fulfillment_status")
  private String mFulfillmentStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_from_ad")
  private Boolean mIsFromAd = null;
  @SerializedName("is_from_page_post")
  private Boolean mIsFromPagePost = null;
  @SerializedName("items")
  private List<Object> mItems = null;
  @SerializedName("payout_foreign_exchange_rate")
  private Double mPayoutForeignExchangeRate = null;
  @SerializedName("phone_support_eligible")
  private Boolean mPhoneSupportEligible = null;
  @SerializedName("platform")
  private String mPlatform = null;
  @SerializedName("refundable_amount")
  private CurrencyAmount mRefundableAmount = null;
  @SerializedName("request_id")
  private String mRequestId = null;
  @SerializedName("tax")
  private String mTax = null;
  @SerializedName("tax_country")
  private String mTaxCountry = null;
  @SerializedName("test")
  private Long mTest = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  PaymentEnginePayment() {
  }

  public PaymentEnginePayment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PaymentEnginePayment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PaymentEnginePayment fetch() throws APIException{
    PaymentEnginePayment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PaymentEnginePayment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PaymentEnginePayment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PaymentEnginePayment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PaymentEnginePayment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PaymentEnginePayment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PaymentEnginePayment>)(
      new APIRequest<PaymentEnginePayment>(context, "", "/", "GET", PaymentEnginePayment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PaymentEnginePayment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PaymentEnginePayment.getParser())
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
  public static PaymentEnginePayment loadJSON(String json, APIContext context, String header) {
    PaymentEnginePayment paymentEnginePayment = getGson().fromJson(json, PaymentEnginePayment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(paymentEnginePayment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    paymentEnginePayment.context = context;
    paymentEnginePayment.rawValue = json;
    paymentEnginePayment.header = header;
    return paymentEnginePayment;
  }

  public static APINodeList<PaymentEnginePayment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PaymentEnginePayment> paymentEnginePayments = new APINodeList<PaymentEnginePayment>(request, json, header);
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
          paymentEnginePayments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return paymentEnginePayments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                paymentEnginePayments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            paymentEnginePayments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              paymentEnginePayments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              paymentEnginePayments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  paymentEnginePayments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              paymentEnginePayments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return paymentEnginePayments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              paymentEnginePayments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return paymentEnginePayments;
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
              paymentEnginePayments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return paymentEnginePayments;
          }

          // Sixth, check if it's pure JsonObject
          paymentEnginePayments.clear();
          paymentEnginePayments.add(loadJSON(json, context, header));
          return paymentEnginePayments;
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

  public APIRequestCreateDispute createDispute() {
    return new APIRequestCreateDispute(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateRefund createRefund() {
    return new APIRequestCreateRefund(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<Object> getFieldActions() {
    return mActions;
  }

  public Application getFieldApplication() {
    if (mApplication != null) {
      mApplication.context = getContext();
    }
    return mApplication;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<Object> getFieldDisputes() {
    return mDisputes;
  }

  public String getFieldFraudStatus() {
    return mFraudStatus;
  }

  public String getFieldFulfillmentStatus() {
    return mFulfillmentStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsFromAd() {
    return mIsFromAd;
  }

  public Boolean getFieldIsFromPagePost() {
    return mIsFromPagePost;
  }

  public List<Object> getFieldItems() {
    return mItems;
  }

  public Double getFieldPayoutForeignExchangeRate() {
    return mPayoutForeignExchangeRate;
  }

  public Boolean getFieldPhoneSupportEligible() {
    return mPhoneSupportEligible;
  }

  public String getFieldPlatform() {
    return mPlatform;
  }

  public CurrencyAmount getFieldRefundableAmount() {
    return mRefundableAmount;
  }

  public String getFieldRequestId() {
    return mRequestId;
  }

  public String getFieldTax() {
    return mTax;
  }

  public String getFieldTaxCountry() {
    return mTaxCountry;
  }

  public Long getFieldTest() {
    return mTest;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }



  public static class APIRequestCreateDispute extends APIRequest<PaymentEnginePayment> {

    PaymentEnginePayment lastResponse = null;
    @Override
    public PaymentEnginePayment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "reason",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PaymentEnginePayment parseResponse(String response, String header) throws APIException {
      return PaymentEnginePayment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PaymentEnginePayment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PaymentEnginePayment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PaymentEnginePayment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PaymentEnginePayment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PaymentEnginePayment>() {
           public PaymentEnginePayment apply(ResponseWrapper result) {
             try {
               return APIRequestCreateDispute.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDispute(String nodeId, APIContext context) {
      super(context, nodeId, "/dispute", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDispute setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDispute setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDispute setReason (PaymentEnginePayment.EnumReason reason) {
      this.setParam("reason", reason);
      return this;
    }
    public APIRequestCreateDispute setReason (String reason) {
      this.setParam("reason", reason);
      return this;
    }

    public APIRequestCreateDispute requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDispute requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDispute requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDispute requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDispute requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDispute requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateRefund extends APIRequest<PaymentEnginePayment> {

    PaymentEnginePayment lastResponse = null;
    @Override
    public PaymentEnginePayment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "amount",
      "currency",
      "reason",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PaymentEnginePayment parseResponse(String response, String header) throws APIException {
      return PaymentEnginePayment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PaymentEnginePayment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PaymentEnginePayment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PaymentEnginePayment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PaymentEnginePayment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PaymentEnginePayment>() {
           public PaymentEnginePayment apply(ResponseWrapper result) {
             try {
               return APIRequestCreateRefund.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateRefund(String nodeId, APIContext context) {
      super(context, nodeId, "/refunds", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateRefund setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateRefund setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateRefund setAmount (Double amount) {
      this.setParam("amount", amount);
      return this;
    }
    public APIRequestCreateRefund setAmount (String amount) {
      this.setParam("amount", amount);
      return this;
    }

    public APIRequestCreateRefund setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateRefund setReason (PaymentEnginePayment.EnumReason reason) {
      this.setParam("reason", reason);
      return this;
    }
    public APIRequestCreateRefund setReason (String reason) {
      this.setParam("reason", reason);
      return this;
    }

    public APIRequestCreateRefund requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateRefund requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRefund requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateRefund requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRefund requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateRefund requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<PaymentEnginePayment> {

    PaymentEnginePayment lastResponse = null;
    @Override
    public PaymentEnginePayment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "application",
      "country",
      "created_time",
      "disputes",
      "fraud_status",
      "fulfillment_status",
      "id",
      "is_from_ad",
      "is_from_page_post",
      "items",
      "payout_foreign_exchange_rate",
      "phone_support_eligible",
      "platform",
      "refundable_amount",
      "request_id",
      "tax",
      "tax_country",
      "test",
      "user",
    };

    @Override
    public PaymentEnginePayment parseResponse(String response, String header) throws APIException {
      return PaymentEnginePayment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PaymentEnginePayment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PaymentEnginePayment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PaymentEnginePayment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PaymentEnginePayment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PaymentEnginePayment>() {
           public PaymentEnginePayment apply(ResponseWrapper result) {
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

    public APIRequestGet requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGet requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDisputesField () {
      return this.requestDisputesField(true);
    }
    public APIRequestGet requestDisputesField (boolean value) {
      this.requestField("disputes", value);
      return this;
    }
    public APIRequestGet requestFraudStatusField () {
      return this.requestFraudStatusField(true);
    }
    public APIRequestGet requestFraudStatusField (boolean value) {
      this.requestField("fraud_status", value);
      return this;
    }
    public APIRequestGet requestFulfillmentStatusField () {
      return this.requestFulfillmentStatusField(true);
    }
    public APIRequestGet requestFulfillmentStatusField (boolean value) {
      this.requestField("fulfillment_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsFromAdField () {
      return this.requestIsFromAdField(true);
    }
    public APIRequestGet requestIsFromAdField (boolean value) {
      this.requestField("is_from_ad", value);
      return this;
    }
    public APIRequestGet requestIsFromPagePostField () {
      return this.requestIsFromPagePostField(true);
    }
    public APIRequestGet requestIsFromPagePostField (boolean value) {
      this.requestField("is_from_page_post", value);
      return this;
    }
    public APIRequestGet requestItemsField () {
      return this.requestItemsField(true);
    }
    public APIRequestGet requestItemsField (boolean value) {
      this.requestField("items", value);
      return this;
    }
    public APIRequestGet requestPayoutForeignExchangeRateField () {
      return this.requestPayoutForeignExchangeRateField(true);
    }
    public APIRequestGet requestPayoutForeignExchangeRateField (boolean value) {
      this.requestField("payout_foreign_exchange_rate", value);
      return this;
    }
    public APIRequestGet requestPhoneSupportEligibleField () {
      return this.requestPhoneSupportEligibleField(true);
    }
    public APIRequestGet requestPhoneSupportEligibleField (boolean value) {
      this.requestField("phone_support_eligible", value);
      return this;
    }
    public APIRequestGet requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGet requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGet requestRefundableAmountField () {
      return this.requestRefundableAmountField(true);
    }
    public APIRequestGet requestRefundableAmountField (boolean value) {
      this.requestField("refundable_amount", value);
      return this;
    }
    public APIRequestGet requestRequestIdField () {
      return this.requestRequestIdField(true);
    }
    public APIRequestGet requestRequestIdField (boolean value) {
      this.requestField("request_id", value);
      return this;
    }
    public APIRequestGet requestTaxField () {
      return this.requestTaxField(true);
    }
    public APIRequestGet requestTaxField (boolean value) {
      this.requestField("tax", value);
      return this;
    }
    public APIRequestGet requestTaxCountryField () {
      return this.requestTaxCountryField(true);
    }
    public APIRequestGet requestTaxCountryField (boolean value) {
      this.requestField("tax_country", value);
      return this;
    }
    public APIRequestGet requestTestField () {
      return this.requestTestField(true);
    }
    public APIRequestGet requestTestField (boolean value) {
      this.requestField("test", value);
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

  public static enum EnumReason {
      @SerializedName("BANNED_USER")
      VALUE_BANNED_USER("BANNED_USER"),
      @SerializedName("DENIED_REFUND")
      VALUE_DENIED_REFUND("DENIED_REFUND"),
      @SerializedName("GRANTED_REPLACEMENT_ITEM")
      VALUE_GRANTED_REPLACEMENT_ITEM("GRANTED_REPLACEMENT_ITEM"),
      ;

      private String value;

      private EnumReason(String value) {
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

  public PaymentEnginePayment copyFrom(PaymentEnginePayment instance) {
    this.mActions = instance.mActions;
    this.mApplication = instance.mApplication;
    this.mCountry = instance.mCountry;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDisputes = instance.mDisputes;
    this.mFraudStatus = instance.mFraudStatus;
    this.mFulfillmentStatus = instance.mFulfillmentStatus;
    this.mId = instance.mId;
    this.mIsFromAd = instance.mIsFromAd;
    this.mIsFromPagePost = instance.mIsFromPagePost;
    this.mItems = instance.mItems;
    this.mPayoutForeignExchangeRate = instance.mPayoutForeignExchangeRate;
    this.mPhoneSupportEligible = instance.mPhoneSupportEligible;
    this.mPlatform = instance.mPlatform;
    this.mRefundableAmount = instance.mRefundableAmount;
    this.mRequestId = instance.mRequestId;
    this.mTax = instance.mTax;
    this.mTaxCountry = instance.mTaxCountry;
    this.mTest = instance.mTest;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PaymentEnginePayment> getParser() {
    return new APIRequest.ResponseParser<PaymentEnginePayment>() {
      public APINodeList<PaymentEnginePayment> parseResponse(String response, APIContext context, APIRequest<PaymentEnginePayment> request, String header) throws MalformedResponseException {
        return PaymentEnginePayment.parseResponse(response, context, request, header);
      }
    };
  }
}
