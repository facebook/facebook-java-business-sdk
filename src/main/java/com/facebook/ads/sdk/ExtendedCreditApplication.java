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
public class ExtendedCreditApplication extends APINode {
  @SerializedName("billing_country")
  private String mBillingCountry = null;
  @SerializedName("city")
  private String mCity = null;
  @SerializedName("cnpj")
  private String mCnpj = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("display_currency")
  private String mDisplayCurrency = null;
  @SerializedName("duns_number")
  private String mDunsNumber = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("invoice_email_address")
  private String mInvoiceEmailAddress = null;
  @SerializedName("is_umi")
  private Boolean mIsUmi = null;
  @SerializedName("legal_entity_name")
  private String mLegalEntityName = null;
  @SerializedName("original_online_limit")
  private CurrencyAmount mOriginalOnlineLimit = null;
  @SerializedName("phone_number")
  private String mPhoneNumber = null;
  @SerializedName("postal_code")
  private String mPostalCode = null;
  @SerializedName("product_types")
  private List<String> mProductTypes = null;
  @SerializedName("proposed_credit_limit")
  private CurrencyAmount mProposedCreditLimit = null;
  @SerializedName("registration_number")
  private String mRegistrationNumber = null;
  @SerializedName("run_id")
  private String mRunId = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("street1")
  private String mStreet1 = null;
  @SerializedName("street2")
  private String mStreet2 = null;
  @SerializedName("submitter")
  private User mSubmitter = null;
  @SerializedName("tax_exempt_status")
  private String mTaxExemptStatus = null;
  @SerializedName("tax_id")
  private String mTaxId = null;
  @SerializedName("terms")
  private String mTerms = null;
  protected static Gson gson = null;

  ExtendedCreditApplication() {
  }

  public ExtendedCreditApplication(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ExtendedCreditApplication(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ExtendedCreditApplication fetch() throws APIException{
    ExtendedCreditApplication newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ExtendedCreditApplication fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ExtendedCreditApplication> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ExtendedCreditApplication fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ExtendedCreditApplication> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ExtendedCreditApplication> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ExtendedCreditApplication>)(
      new APIRequest<ExtendedCreditApplication>(context, "", "/", "GET", ExtendedCreditApplication.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ExtendedCreditApplication>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ExtendedCreditApplication.getParser())
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
  public static ExtendedCreditApplication loadJSON(String json, APIContext context, String header) {
    ExtendedCreditApplication extendedCreditApplication = getGson().fromJson(json, ExtendedCreditApplication.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(extendedCreditApplication.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    extendedCreditApplication.context = context;
    extendedCreditApplication.rawValue = json;
    extendedCreditApplication.header = header;
    return extendedCreditApplication;
  }

  public static APINodeList<ExtendedCreditApplication> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ExtendedCreditApplication> extendedCreditApplications = new APINodeList<ExtendedCreditApplication>(request, json, header);
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
          extendedCreditApplications.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return extendedCreditApplications;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                extendedCreditApplications.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            extendedCreditApplications.setPaging(previous, next);
            if (context.hasAppSecret()) {
              extendedCreditApplications.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              extendedCreditApplications.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  extendedCreditApplications.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              extendedCreditApplications.add(loadJSON(obj.toString(), context, header));
            }
          }
          return extendedCreditApplications;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              extendedCreditApplications.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return extendedCreditApplications;
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
              extendedCreditApplications.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return extendedCreditApplications;
          }

          // Sixth, check if it's pure JsonObject
          extendedCreditApplications.clear();
          extendedCreditApplications.add(loadJSON(json, context, header));
          return extendedCreditApplications;
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


  public String getFieldBillingCountry() {
    return mBillingCountry;
  }

  public String getFieldCity() {
    return mCity;
  }

  public String getFieldCnpj() {
    return mCnpj;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldDisplayCurrency() {
    return mDisplayCurrency;
  }

  public String getFieldDunsNumber() {
    return mDunsNumber;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInvoiceEmailAddress() {
    return mInvoiceEmailAddress;
  }

  public Boolean getFieldIsUmi() {
    return mIsUmi;
  }

  public String getFieldLegalEntityName() {
    return mLegalEntityName;
  }

  public CurrencyAmount getFieldOriginalOnlineLimit() {
    return mOriginalOnlineLimit;
  }

  public String getFieldPhoneNumber() {
    return mPhoneNumber;
  }

  public String getFieldPostalCode() {
    return mPostalCode;
  }

  public List<String> getFieldProductTypes() {
    return mProductTypes;
  }

  public CurrencyAmount getFieldProposedCreditLimit() {
    return mProposedCreditLimit;
  }

  public String getFieldRegistrationNumber() {
    return mRegistrationNumber;
  }

  public String getFieldRunId() {
    return mRunId;
  }

  public String getFieldState() {
    return mState;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStreet1() {
    return mStreet1;
  }

  public String getFieldStreet2() {
    return mStreet2;
  }

  public User getFieldSubmitter() {
    if (mSubmitter != null) {
      mSubmitter.context = getContext();
    }
    return mSubmitter;
  }

  public String getFieldTaxExemptStatus() {
    return mTaxExemptStatus;
  }

  public String getFieldTaxId() {
    return mTaxId;
  }

  public String getFieldTerms() {
    return mTerms;
  }



  public static class APIRequestGet extends APIRequest<ExtendedCreditApplication> {

    ExtendedCreditApplication lastResponse = null;
    @Override
    public ExtendedCreditApplication getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "billing_country",
      "city",
      "cnpj",
      "country",
      "display_currency",
      "duns_number",
      "id",
      "invoice_email_address",
      "is_umi",
      "legal_entity_name",
      "original_online_limit",
      "phone_number",
      "postal_code",
      "product_types",
      "proposed_credit_limit",
      "registration_number",
      "run_id",
      "state",
      "status",
      "street1",
      "street2",
      "submitter",
      "tax_exempt_status",
      "tax_id",
      "terms",
    };

    @Override
    public ExtendedCreditApplication parseResponse(String response, String header) throws APIException {
      return ExtendedCreditApplication.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ExtendedCreditApplication execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExtendedCreditApplication execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ExtendedCreditApplication> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExtendedCreditApplication> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ExtendedCreditApplication>() {
           public ExtendedCreditApplication apply(ResponseWrapper result) {
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

    public APIRequestGet requestBillingCountryField () {
      return this.requestBillingCountryField(true);
    }
    public APIRequestGet requestBillingCountryField (boolean value) {
      this.requestField("billing_country", value);
      return this;
    }
    public APIRequestGet requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGet requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGet requestCnpjField () {
      return this.requestCnpjField(true);
    }
    public APIRequestGet requestCnpjField (boolean value) {
      this.requestField("cnpj", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestDisplayCurrencyField () {
      return this.requestDisplayCurrencyField(true);
    }
    public APIRequestGet requestDisplayCurrencyField (boolean value) {
      this.requestField("display_currency", value);
      return this;
    }
    public APIRequestGet requestDunsNumberField () {
      return this.requestDunsNumberField(true);
    }
    public APIRequestGet requestDunsNumberField (boolean value) {
      this.requestField("duns_number", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInvoiceEmailAddressField () {
      return this.requestInvoiceEmailAddressField(true);
    }
    public APIRequestGet requestInvoiceEmailAddressField (boolean value) {
      this.requestField("invoice_email_address", value);
      return this;
    }
    public APIRequestGet requestIsUmiField () {
      return this.requestIsUmiField(true);
    }
    public APIRequestGet requestIsUmiField (boolean value) {
      this.requestField("is_umi", value);
      return this;
    }
    public APIRequestGet requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGet requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestOriginalOnlineLimitField () {
      return this.requestOriginalOnlineLimitField(true);
    }
    public APIRequestGet requestOriginalOnlineLimitField (boolean value) {
      this.requestField("original_online_limit", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGet requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGet requestPostalCodeField () {
      return this.requestPostalCodeField(true);
    }
    public APIRequestGet requestPostalCodeField (boolean value) {
      this.requestField("postal_code", value);
      return this;
    }
    public APIRequestGet requestProductTypesField () {
      return this.requestProductTypesField(true);
    }
    public APIRequestGet requestProductTypesField (boolean value) {
      this.requestField("product_types", value);
      return this;
    }
    public APIRequestGet requestProposedCreditLimitField () {
      return this.requestProposedCreditLimitField(true);
    }
    public APIRequestGet requestProposedCreditLimitField (boolean value) {
      this.requestField("proposed_credit_limit", value);
      return this;
    }
    public APIRequestGet requestRegistrationNumberField () {
      return this.requestRegistrationNumberField(true);
    }
    public APIRequestGet requestRegistrationNumberField (boolean value) {
      this.requestField("registration_number", value);
      return this;
    }
    public APIRequestGet requestRunIdField () {
      return this.requestRunIdField(true);
    }
    public APIRequestGet requestRunIdField (boolean value) {
      this.requestField("run_id", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStreet1Field () {
      return this.requestStreet1Field(true);
    }
    public APIRequestGet requestStreet1Field (boolean value) {
      this.requestField("street1", value);
      return this;
    }
    public APIRequestGet requestStreet2Field () {
      return this.requestStreet2Field(true);
    }
    public APIRequestGet requestStreet2Field (boolean value) {
      this.requestField("street2", value);
      return this;
    }
    public APIRequestGet requestSubmitterField () {
      return this.requestSubmitterField(true);
    }
    public APIRequestGet requestSubmitterField (boolean value) {
      this.requestField("submitter", value);
      return this;
    }
    public APIRequestGet requestTaxExemptStatusField () {
      return this.requestTaxExemptStatusField(true);
    }
    public APIRequestGet requestTaxExemptStatusField (boolean value) {
      this.requestField("tax_exempt_status", value);
      return this;
    }
    public APIRequestGet requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGet requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGet requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGet requestTermsField (boolean value) {
      this.requestField("terms", value);
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

  public ExtendedCreditApplication copyFrom(ExtendedCreditApplication instance) {
    this.mBillingCountry = instance.mBillingCountry;
    this.mCity = instance.mCity;
    this.mCnpj = instance.mCnpj;
    this.mCountry = instance.mCountry;
    this.mDisplayCurrency = instance.mDisplayCurrency;
    this.mDunsNumber = instance.mDunsNumber;
    this.mId = instance.mId;
    this.mInvoiceEmailAddress = instance.mInvoiceEmailAddress;
    this.mIsUmi = instance.mIsUmi;
    this.mLegalEntityName = instance.mLegalEntityName;
    this.mOriginalOnlineLimit = instance.mOriginalOnlineLimit;
    this.mPhoneNumber = instance.mPhoneNumber;
    this.mPostalCode = instance.mPostalCode;
    this.mProductTypes = instance.mProductTypes;
    this.mProposedCreditLimit = instance.mProposedCreditLimit;
    this.mRegistrationNumber = instance.mRegistrationNumber;
    this.mRunId = instance.mRunId;
    this.mState = instance.mState;
    this.mStatus = instance.mStatus;
    this.mStreet1 = instance.mStreet1;
    this.mStreet2 = instance.mStreet2;
    this.mSubmitter = instance.mSubmitter;
    this.mTaxExemptStatus = instance.mTaxExemptStatus;
    this.mTaxId = instance.mTaxId;
    this.mTerms = instance.mTerms;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ExtendedCreditApplication> getParser() {
    return new APIRequest.ResponseParser<ExtendedCreditApplication>() {
      public APINodeList<ExtendedCreditApplication> parseResponse(String response, APIContext context, APIRequest<ExtendedCreditApplication> request, String header) throws MalformedResponseException {
        return ExtendedCreditApplication.parseResponse(response, context, request, header);
      }
    };
  }
}
