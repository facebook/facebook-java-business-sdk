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
public class CRMAddress extends APINode {
  @SerializedName("city")
  private String mCity = null;
  @SerializedName("cnpj_tax_id")
  private String mCnpjTaxId = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("postal_code")
  private String mPostalCode = null;
  @SerializedName("registration_label")
  private String mRegistrationLabel = null;
  @SerializedName("registration_number")
  private String mRegistrationNumber = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("street1")
  private String mStreet1 = null;
  @SerializedName("street2")
  private String mStreet2 = null;
  @SerializedName("street3")
  private String mStreet3 = null;
  @SerializedName("street4")
  private String mStreet4 = null;
  @SerializedName("validation_status")
  private String mValidationStatus = null;
  @SerializedName("vat_tax_id")
  private String mVatTaxId = null;
  protected static Gson gson = null;

  CRMAddress() {
  }

  public CRMAddress(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CRMAddress(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CRMAddress fetch() throws APIException{
    CRMAddress newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CRMAddress fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CRMAddress> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CRMAddress fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CRMAddress> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CRMAddress> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CRMAddress>)(
      new APIRequest<CRMAddress>(context, "", "/", "GET", CRMAddress.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CRMAddress>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CRMAddress.getParser())
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
  public static CRMAddress loadJSON(String json, APIContext context, String header) {
    CRMAddress crmAddress = getGson().fromJson(json, CRMAddress.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(crmAddress.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    crmAddress.context = context;
    crmAddress.rawValue = json;
    crmAddress.header = header;
    return crmAddress;
  }

  public static APINodeList<CRMAddress> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CRMAddress> crmAddresss = new APINodeList<CRMAddress>(request, json, header);
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
          crmAddresss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return crmAddresss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                crmAddresss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            crmAddresss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              crmAddresss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              crmAddresss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  crmAddresss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              crmAddresss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return crmAddresss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              crmAddresss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return crmAddresss;
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
              crmAddresss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return crmAddresss;
          }

          // Sixth, check if it's pure JsonObject
          crmAddresss.clear();
          crmAddresss.add(loadJSON(json, context, header));
          return crmAddresss;
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


  public String getFieldCity() {
    return mCity;
  }

  public String getFieldCnpjTaxId() {
    return mCnpjTaxId;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPostalCode() {
    return mPostalCode;
  }

  public String getFieldRegistrationLabel() {
    return mRegistrationLabel;
  }

  public String getFieldRegistrationNumber() {
    return mRegistrationNumber;
  }

  public String getFieldState() {
    return mState;
  }

  public String getFieldStreet1() {
    return mStreet1;
  }

  public String getFieldStreet2() {
    return mStreet2;
  }

  public String getFieldStreet3() {
    return mStreet3;
  }

  public String getFieldStreet4() {
    return mStreet4;
  }

  public String getFieldValidationStatus() {
    return mValidationStatus;
  }

  public String getFieldVatTaxId() {
    return mVatTaxId;
  }



  public static class APIRequestGet extends APIRequest<CRMAddress> {

    CRMAddress lastResponse = null;
    @Override
    public CRMAddress getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "city",
      "cnpj_tax_id",
      "country",
      "id",
      "postal_code",
      "registration_label",
      "registration_number",
      "state",
      "street1",
      "street2",
      "street3",
      "street4",
      "validation_status",
      "vat_tax_id",
    };

    @Override
    public CRMAddress parseResponse(String response, String header) throws APIException {
      return CRMAddress.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CRMAddress execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CRMAddress execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CRMAddress> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CRMAddress> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CRMAddress>() {
           public CRMAddress apply(ResponseWrapper result) {
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

    public APIRequestGet requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGet requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGet requestCnpjTaxIdField () {
      return this.requestCnpjTaxIdField(true);
    }
    public APIRequestGet requestCnpjTaxIdField (boolean value) {
      this.requestField("cnpj_tax_id", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPostalCodeField () {
      return this.requestPostalCodeField(true);
    }
    public APIRequestGet requestPostalCodeField (boolean value) {
      this.requestField("postal_code", value);
      return this;
    }
    public APIRequestGet requestRegistrationLabelField () {
      return this.requestRegistrationLabelField(true);
    }
    public APIRequestGet requestRegistrationLabelField (boolean value) {
      this.requestField("registration_label", value);
      return this;
    }
    public APIRequestGet requestRegistrationNumberField () {
      return this.requestRegistrationNumberField(true);
    }
    public APIRequestGet requestRegistrationNumberField (boolean value) {
      this.requestField("registration_number", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
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
    public APIRequestGet requestStreet3Field () {
      return this.requestStreet3Field(true);
    }
    public APIRequestGet requestStreet3Field (boolean value) {
      this.requestField("street3", value);
      return this;
    }
    public APIRequestGet requestStreet4Field () {
      return this.requestStreet4Field(true);
    }
    public APIRequestGet requestStreet4Field (boolean value) {
      this.requestField("street4", value);
      return this;
    }
    public APIRequestGet requestValidationStatusField () {
      return this.requestValidationStatusField(true);
    }
    public APIRequestGet requestValidationStatusField (boolean value) {
      this.requestField("validation_status", value);
      return this;
    }
    public APIRequestGet requestVatTaxIdField () {
      return this.requestVatTaxIdField(true);
    }
    public APIRequestGet requestVatTaxIdField (boolean value) {
      this.requestField("vat_tax_id", value);
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

  public CRMAddress copyFrom(CRMAddress instance) {
    this.mCity = instance.mCity;
    this.mCnpjTaxId = instance.mCnpjTaxId;
    this.mCountry = instance.mCountry;
    this.mId = instance.mId;
    this.mPostalCode = instance.mPostalCode;
    this.mRegistrationLabel = instance.mRegistrationLabel;
    this.mRegistrationNumber = instance.mRegistrationNumber;
    this.mState = instance.mState;
    this.mStreet1 = instance.mStreet1;
    this.mStreet2 = instance.mStreet2;
    this.mStreet3 = instance.mStreet3;
    this.mStreet4 = instance.mStreet4;
    this.mValidationStatus = instance.mValidationStatus;
    this.mVatTaxId = instance.mVatTaxId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CRMAddress> getParser() {
    return new APIRequest.ResponseParser<CRMAddress>() {
      public APINodeList<CRMAddress> parseResponse(String response, APIContext context, APIRequest<CRMAddress> request, String header) throws MalformedResponseException {
        return CRMAddress.parseResponse(response, context, request, header);
      }
    };
  }
}
