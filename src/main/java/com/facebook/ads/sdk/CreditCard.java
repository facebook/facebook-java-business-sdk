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
public class CreditCard extends APINode {
  @SerializedName("billing_address")
  private Object mBillingAddress = null;
  @SerializedName("card_cobadging")
  private String mCardCobadging = null;
  @SerializedName("card_holder_name")
  private String mCardHolderName = null;
  @SerializedName("card_type")
  private String mCardType = null;
  @SerializedName("credential_id")
  private Long mCredentialId = null;
  @SerializedName("default_receiving_method_products")
  private List<String> mDefaultReceivingMethodProducts = null;
  @SerializedName("expiry_month")
  private String mExpiryMonth = null;
  @SerializedName("expiry_year")
  private String mExpiryYear = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_cvv_tricky_bin")
  private Boolean mIsCvvTrickyBin = null;
  @SerializedName("is_enabled")
  private Boolean mIsEnabled = null;
  @SerializedName("is_last_used")
  private Boolean mIsLastUsed = null;
  @SerializedName("is_network_tokenized_in_india")
  private Boolean mIsNetworkTokenizedInIndia = null;
  @SerializedName("is_soft_disabled")
  private Boolean mIsSoftDisabled = null;
  @SerializedName("is_user_verified")
  private Boolean mIsUserVerified = null;
  @SerializedName("is_zip_verified")
  private Boolean mIsZipVerified = null;
  @SerializedName("last4")
  private String mLast4 = null;
  @SerializedName("readable_card_type")
  private String mReadableCardType = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_created_ts")
  private Long mTimeCreatedTs = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  CreditCard() {
  }

  public CreditCard(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CreditCard(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CreditCard fetch() throws APIException{
    CreditCard newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CreditCard fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CreditCard> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CreditCard fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CreditCard> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CreditCard> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CreditCard>)(
      new APIRequest<CreditCard>(context, "", "/", "GET", CreditCard.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CreditCard>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CreditCard.getParser())
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
  public static CreditCard loadJSON(String json, APIContext context, String header) {
    CreditCard creditCard = getGson().fromJson(json, CreditCard.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(creditCard.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    creditCard.context = context;
    creditCard.rawValue = json;
    creditCard.header = header;
    return creditCard;
  }

  public static APINodeList<CreditCard> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CreditCard> creditCards = new APINodeList<CreditCard>(request, json, header);
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
          creditCards.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return creditCards;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                creditCards.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            creditCards.setPaging(previous, next);
            if (context.hasAppSecret()) {
              creditCards.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              creditCards.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  creditCards.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              creditCards.add(loadJSON(obj.toString(), context, header));
            }
          }
          return creditCards;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              creditCards.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return creditCards;
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
              creditCards.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return creditCards;
          }

          // Sixth, check if it's pure JsonObject
          creditCards.clear();
          creditCards.add(loadJSON(json, context, header));
          return creditCards;
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


  public Object getFieldBillingAddress() {
    return mBillingAddress;
  }

  public String getFieldCardCobadging() {
    return mCardCobadging;
  }

  public String getFieldCardHolderName() {
    return mCardHolderName;
  }

  public String getFieldCardType() {
    return mCardType;
  }

  public Long getFieldCredentialId() {
    return mCredentialId;
  }

  public List<String> getFieldDefaultReceivingMethodProducts() {
    return mDefaultReceivingMethodProducts;
  }

  public String getFieldExpiryMonth() {
    return mExpiryMonth;
  }

  public String getFieldExpiryYear() {
    return mExpiryYear;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsCvvTrickyBin() {
    return mIsCvvTrickyBin;
  }

  public Boolean getFieldIsEnabled() {
    return mIsEnabled;
  }

  public Boolean getFieldIsLastUsed() {
    return mIsLastUsed;
  }

  public Boolean getFieldIsNetworkTokenizedInIndia() {
    return mIsNetworkTokenizedInIndia;
  }

  public Boolean getFieldIsSoftDisabled() {
    return mIsSoftDisabled;
  }

  public Boolean getFieldIsUserVerified() {
    return mIsUserVerified;
  }

  public Boolean getFieldIsZipVerified() {
    return mIsZipVerified;
  }

  public String getFieldLast4() {
    return mLast4;
  }

  public String getFieldReadableCardType() {
    return mReadableCardType;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldTimeCreatedTs() {
    return mTimeCreatedTs;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestGet extends APIRequest<CreditCard> {

    CreditCard lastResponse = null;
    @Override
    public CreditCard getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "billing_address",
      "card_cobadging",
      "card_holder_name",
      "card_type",
      "credential_id",
      "default_receiving_method_products",
      "expiry_month",
      "expiry_year",
      "id",
      "is_cvv_tricky_bin",
      "is_enabled",
      "is_last_used",
      "is_network_tokenized_in_india",
      "is_soft_disabled",
      "is_user_verified",
      "is_zip_verified",
      "last4",
      "readable_card_type",
      "time_created",
      "time_created_ts",
      "type",
    };

    @Override
    public CreditCard parseResponse(String response, String header) throws APIException {
      return CreditCard.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CreditCard execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CreditCard execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CreditCard> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CreditCard> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CreditCard>() {
           public CreditCard apply(ResponseWrapper result) {
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

    public APIRequestGet requestBillingAddressField () {
      return this.requestBillingAddressField(true);
    }
    public APIRequestGet requestBillingAddressField (boolean value) {
      this.requestField("billing_address", value);
      return this;
    }
    public APIRequestGet requestCardCobadgingField () {
      return this.requestCardCobadgingField(true);
    }
    public APIRequestGet requestCardCobadgingField (boolean value) {
      this.requestField("card_cobadging", value);
      return this;
    }
    public APIRequestGet requestCardHolderNameField () {
      return this.requestCardHolderNameField(true);
    }
    public APIRequestGet requestCardHolderNameField (boolean value) {
      this.requestField("card_holder_name", value);
      return this;
    }
    public APIRequestGet requestCardTypeField () {
      return this.requestCardTypeField(true);
    }
    public APIRequestGet requestCardTypeField (boolean value) {
      this.requestField("card_type", value);
      return this;
    }
    public APIRequestGet requestCredentialIdField () {
      return this.requestCredentialIdField(true);
    }
    public APIRequestGet requestCredentialIdField (boolean value) {
      this.requestField("credential_id", value);
      return this;
    }
    public APIRequestGet requestDefaultReceivingMethodProductsField () {
      return this.requestDefaultReceivingMethodProductsField(true);
    }
    public APIRequestGet requestDefaultReceivingMethodProductsField (boolean value) {
      this.requestField("default_receiving_method_products", value);
      return this;
    }
    public APIRequestGet requestExpiryMonthField () {
      return this.requestExpiryMonthField(true);
    }
    public APIRequestGet requestExpiryMonthField (boolean value) {
      this.requestField("expiry_month", value);
      return this;
    }
    public APIRequestGet requestExpiryYearField () {
      return this.requestExpiryYearField(true);
    }
    public APIRequestGet requestExpiryYearField (boolean value) {
      this.requestField("expiry_year", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsCvvTrickyBinField () {
      return this.requestIsCvvTrickyBinField(true);
    }
    public APIRequestGet requestIsCvvTrickyBinField (boolean value) {
      this.requestField("is_cvv_tricky_bin", value);
      return this;
    }
    public APIRequestGet requestIsEnabledField () {
      return this.requestIsEnabledField(true);
    }
    public APIRequestGet requestIsEnabledField (boolean value) {
      this.requestField("is_enabled", value);
      return this;
    }
    public APIRequestGet requestIsLastUsedField () {
      return this.requestIsLastUsedField(true);
    }
    public APIRequestGet requestIsLastUsedField (boolean value) {
      this.requestField("is_last_used", value);
      return this;
    }
    public APIRequestGet requestIsNetworkTokenizedInIndiaField () {
      return this.requestIsNetworkTokenizedInIndiaField(true);
    }
    public APIRequestGet requestIsNetworkTokenizedInIndiaField (boolean value) {
      this.requestField("is_network_tokenized_in_india", value);
      return this;
    }
    public APIRequestGet requestIsSoftDisabledField () {
      return this.requestIsSoftDisabledField(true);
    }
    public APIRequestGet requestIsSoftDisabledField (boolean value) {
      this.requestField("is_soft_disabled", value);
      return this;
    }
    public APIRequestGet requestIsUserVerifiedField () {
      return this.requestIsUserVerifiedField(true);
    }
    public APIRequestGet requestIsUserVerifiedField (boolean value) {
      this.requestField("is_user_verified", value);
      return this;
    }
    public APIRequestGet requestIsZipVerifiedField () {
      return this.requestIsZipVerifiedField(true);
    }
    public APIRequestGet requestIsZipVerifiedField (boolean value) {
      this.requestField("is_zip_verified", value);
      return this;
    }
    public APIRequestGet requestLast4Field () {
      return this.requestLast4Field(true);
    }
    public APIRequestGet requestLast4Field (boolean value) {
      this.requestField("last4", value);
      return this;
    }
    public APIRequestGet requestReadableCardTypeField () {
      return this.requestReadableCardTypeField(true);
    }
    public APIRequestGet requestReadableCardTypeField (boolean value) {
      this.requestField("readable_card_type", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedTsField () {
      return this.requestTimeCreatedTsField(true);
    }
    public APIRequestGet requestTimeCreatedTsField (boolean value) {
      this.requestField("time_created_ts", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
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

  public CreditCard copyFrom(CreditCard instance) {
    this.mBillingAddress = instance.mBillingAddress;
    this.mCardCobadging = instance.mCardCobadging;
    this.mCardHolderName = instance.mCardHolderName;
    this.mCardType = instance.mCardType;
    this.mCredentialId = instance.mCredentialId;
    this.mDefaultReceivingMethodProducts = instance.mDefaultReceivingMethodProducts;
    this.mExpiryMonth = instance.mExpiryMonth;
    this.mExpiryYear = instance.mExpiryYear;
    this.mId = instance.mId;
    this.mIsCvvTrickyBin = instance.mIsCvvTrickyBin;
    this.mIsEnabled = instance.mIsEnabled;
    this.mIsLastUsed = instance.mIsLastUsed;
    this.mIsNetworkTokenizedInIndia = instance.mIsNetworkTokenizedInIndia;
    this.mIsSoftDisabled = instance.mIsSoftDisabled;
    this.mIsUserVerified = instance.mIsUserVerified;
    this.mIsZipVerified = instance.mIsZipVerified;
    this.mLast4 = instance.mLast4;
    this.mReadableCardType = instance.mReadableCardType;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeCreatedTs = instance.mTimeCreatedTs;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CreditCard> getParser() {
    return new APIRequest.ResponseParser<CreditCard>() {
      public APINodeList<CreditCard> parseResponse(String response, APIContext context, APIRequest<CreditCard> request, String header) throws MalformedResponseException {
        return CreditCard.parseResponse(response, context, request, header);
      }
    };
  }
}
