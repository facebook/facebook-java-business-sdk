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
public class ExtendedCredit extends APINode {
  @SerializedName("allocated_amount")
  private CurrencyAmount mAllocatedAmount = null;
  @SerializedName("balance")
  private CurrencyAmount mBalance = null;
  @SerializedName("credit_available")
  private CurrencyAmount mCreditAvailable = null;
  @SerializedName("credit_type")
  private String mCreditType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_access_revoked")
  private Boolean mIsAccessRevoked = null;
  @SerializedName("is_automated_experience")
  private Boolean mIsAutomatedExperience = null;
  @SerializedName("legal_entity_name")
  private String mLegalEntityName = null;
  @SerializedName("liable_address")
  private CRMAddress mLiableAddress = null;
  @SerializedName("liable_biz_name")
  private String mLiableBizName = null;
  @SerializedName("max_balance")
  private CurrencyAmount mMaxBalance = null;
  @SerializedName("online_max_balance")
  private CurrencyAmount mOnlineMaxBalance = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("owner_business_name")
  private String mOwnerBusinessName = null;
  @SerializedName("partition_from")
  private String mPartitionFrom = null;
  @SerializedName("receiving_credit_allocation_config")
  private ExtendedCreditAllocationConfig mReceivingCreditAllocationConfig = null;
  @SerializedName("send_bill_to_address")
  private CRMAddress mSendBillToAddress = null;
  @SerializedName("send_bill_to_biz_name")
  private String mSendBillToBizName = null;
  @SerializedName("sold_to_address")
  private CRMAddress mSoldToAddress = null;
  protected static Gson gson = null;

  ExtendedCredit() {
  }

  public ExtendedCredit(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ExtendedCredit(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ExtendedCredit fetch() throws APIException{
    ExtendedCredit newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ExtendedCredit fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ExtendedCredit> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ExtendedCredit fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ExtendedCredit> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ExtendedCredit> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ExtendedCredit>)(
      new APIRequest<ExtendedCredit>(context, "", "/", "GET", ExtendedCredit.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ExtendedCredit>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ExtendedCredit.getParser())
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
  public static ExtendedCredit loadJSON(String json, APIContext context, String header) {
    ExtendedCredit extendedCredit = getGson().fromJson(json, ExtendedCredit.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(extendedCredit.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    extendedCredit.context = context;
    extendedCredit.rawValue = json;
    extendedCredit.header = header;
    return extendedCredit;
  }

  public static APINodeList<ExtendedCredit> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ExtendedCredit> extendedCredits = new APINodeList<ExtendedCredit>(request, json, header);
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
          extendedCredits.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return extendedCredits;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                extendedCredits.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            extendedCredits.setPaging(previous, next);
            if (context.hasAppSecret()) {
              extendedCredits.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              extendedCredits.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  extendedCredits.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              extendedCredits.add(loadJSON(obj.toString(), context, header));
            }
          }
          return extendedCredits;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              extendedCredits.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return extendedCredits;
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
              extendedCredits.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return extendedCredits;
          }

          // Sixth, check if it's pure JsonObject
          extendedCredits.clear();
          extendedCredits.add(loadJSON(json, context, header));
          return extendedCredits;
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

  public APIRequestGetExtendedCreditInvoiceGroups getExtendedCreditInvoiceGroups() {
    return new APIRequestGetExtendedCreditInvoiceGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateExtendedCreditInvoiceGroup createExtendedCreditInvoiceGroup() {
    return new APIRequestCreateExtendedCreditInvoiceGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwningCreditAllocationConfigs getOwningCreditAllocationConfigs() {
    return new APIRequestGetOwningCreditAllocationConfigs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwningCreditAllocationConfig createOwningCreditAllocationConfig() {
    return new APIRequestCreateOwningCreditAllocationConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateWhatsAppCreditSharingAnDAttach createWhatsAppCreditSharingAnDAttach() {
    return new APIRequestCreateWhatsAppCreditSharingAnDAttach(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public CurrencyAmount getFieldAllocatedAmount() {
    return mAllocatedAmount;
  }

  public CurrencyAmount getFieldBalance() {
    return mBalance;
  }

  public CurrencyAmount getFieldCreditAvailable() {
    return mCreditAvailable;
  }

  public String getFieldCreditType() {
    return mCreditType;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAccessRevoked() {
    return mIsAccessRevoked;
  }

  public Boolean getFieldIsAutomatedExperience() {
    return mIsAutomatedExperience;
  }

  public String getFieldLegalEntityName() {
    return mLegalEntityName;
  }

  public CRMAddress getFieldLiableAddress() {
    if (mLiableAddress != null) {
      mLiableAddress.context = getContext();
    }
    return mLiableAddress;
  }

  public String getFieldLiableBizName() {
    return mLiableBizName;
  }

  public CurrencyAmount getFieldMaxBalance() {
    return mMaxBalance;
  }

  public CurrencyAmount getFieldOnlineMaxBalance() {
    return mOnlineMaxBalance;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldOwnerBusinessName() {
    return mOwnerBusinessName;
  }

  public String getFieldPartitionFrom() {
    return mPartitionFrom;
  }

  public ExtendedCreditAllocationConfig getFieldReceivingCreditAllocationConfig() {
    if (mReceivingCreditAllocationConfig != null) {
      mReceivingCreditAllocationConfig.context = getContext();
    }
    return mReceivingCreditAllocationConfig;
  }

  public CRMAddress getFieldSendBillToAddress() {
    if (mSendBillToAddress != null) {
      mSendBillToAddress.context = getContext();
    }
    return mSendBillToAddress;
  }

  public String getFieldSendBillToBizName() {
    return mSendBillToBizName;
  }

  public CRMAddress getFieldSoldToAddress() {
    if (mSoldToAddress != null) {
      mSoldToAddress.context = getContext();
    }
    return mSoldToAddress;
  }



  public static class APIRequestGetExtendedCreditInvoiceGroups extends APIRequest<ExtendedCreditInvoiceGroup> {

    APINodeList<ExtendedCreditInvoiceGroup> lastResponse = null;
    @Override
    public APINodeList<ExtendedCreditInvoiceGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "auto_enroll",
      "bill_to_address",
      "customer_po_number",
      "email",
      "emails",
      "id",
      "liable_address",
      "name",
      "sold_to_address",
    };

    @Override
    public APINodeList<ExtendedCreditInvoiceGroup> parseResponse(String response, String header) throws APIException {
      return ExtendedCreditInvoiceGroup.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ExtendedCreditInvoiceGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCreditInvoiceGroup> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCreditInvoiceGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCreditInvoiceGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ExtendedCreditInvoiceGroup>>() {
           public APINodeList<ExtendedCreditInvoiceGroup> apply(ResponseWrapper result) {
             try {
               return APIRequestGetExtendedCreditInvoiceGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetExtendedCreditInvoiceGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/extended_credit_invoice_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExtendedCreditInvoiceGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExtendedCreditInvoiceGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditInvoiceGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExtendedCreditInvoiceGroups requestAutoEnrollField () {
      return this.requestAutoEnrollField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestAutoEnrollField (boolean value) {
      this.requestField("auto_enroll", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestBillToAddressField () {
      return this.requestBillToAddressField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestBillToAddressField (boolean value) {
      this.requestField("bill_to_address", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestCustomerPoNumberField () {
      return this.requestCustomerPoNumberField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestCustomerPoNumberField (boolean value) {
      this.requestField("customer_po_number", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetExtendedCreditInvoiceGroups requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
  }

  public static class APIRequestCreateExtendedCreditInvoiceGroup extends APIRequest<ExtendedCreditInvoiceGroup> {

    ExtendedCreditInvoiceGroup lastResponse = null;
    @Override
    public ExtendedCreditInvoiceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "emails",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ExtendedCreditInvoiceGroup parseResponse(String response, String header) throws APIException {
      return ExtendedCreditInvoiceGroup.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ExtendedCreditInvoiceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExtendedCreditInvoiceGroup execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ExtendedCreditInvoiceGroup> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExtendedCreditInvoiceGroup> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ExtendedCreditInvoiceGroup>() {
           public ExtendedCreditInvoiceGroup apply(ResponseWrapper result) {
             try {
               return APIRequestCreateExtendedCreditInvoiceGroup.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateExtendedCreditInvoiceGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/extended_credit_invoice_groups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExtendedCreditInvoiceGroup setEmails (List<String> emails) {
      this.setParam("emails", emails);
      return this;
    }
    public APIRequestCreateExtendedCreditInvoiceGroup setEmails (String emails) {
      this.setParam("emails", emails);
      return this;
    }

    public APIRequestCreateExtendedCreditInvoiceGroup setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateExtendedCreditInvoiceGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExtendedCreditInvoiceGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateExtendedCreditInvoiceGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwningCreditAllocationConfigs extends APIRequest<ExtendedCreditAllocationConfig> {

    APINodeList<ExtendedCreditAllocationConfig> lastResponse = null;
    @Override
    public APINodeList<ExtendedCreditAllocationConfig> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "receiving_business_id",
    };

    public static final String[] FIELDS = {
      "currency_amount",
      "id",
      "liability_type",
      "owning_business",
      "owning_credential",
      "partition_type",
      "receiving_business",
      "receiving_credential",
      "request_status",
      "send_bill_to",
    };

    @Override
    public APINodeList<ExtendedCreditAllocationConfig> parseResponse(String response, String header) throws APIException {
      return ExtendedCreditAllocationConfig.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ExtendedCreditAllocationConfig> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCreditAllocationConfig> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCreditAllocationConfig>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCreditAllocationConfig>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ExtendedCreditAllocationConfig>>() {
           public APINodeList<ExtendedCreditAllocationConfig> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwningCreditAllocationConfigs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwningCreditAllocationConfigs(String nodeId, APIContext context) {
      super(context, nodeId, "/owning_credit_allocation_configs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwningCreditAllocationConfigs setReceivingBusinessId (String receivingBusinessId) {
      this.setParam("receiving_business_id", receivingBusinessId);
      return this;
    }

    public APIRequestGetOwningCreditAllocationConfigs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwningCreditAllocationConfigs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwningCreditAllocationConfigs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwningCreditAllocationConfigs requestCurrencyAmountField () {
      return this.requestCurrencyAmountField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestCurrencyAmountField (boolean value) {
      this.requestField("currency_amount", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestLiabilityTypeField () {
      return this.requestLiabilityTypeField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestLiabilityTypeField (boolean value) {
      this.requestField("liability_type", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestOwningBusinessField () {
      return this.requestOwningBusinessField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestOwningBusinessField (boolean value) {
      this.requestField("owning_business", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestOwningCredentialField () {
      return this.requestOwningCredentialField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestOwningCredentialField (boolean value) {
      this.requestField("owning_credential", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestPartitionTypeField () {
      return this.requestPartitionTypeField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestPartitionTypeField (boolean value) {
      this.requestField("partition_type", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestReceivingBusinessField () {
      return this.requestReceivingBusinessField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestReceivingBusinessField (boolean value) {
      this.requestField("receiving_business", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestReceivingCredentialField () {
      return this.requestReceivingCredentialField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestReceivingCredentialField (boolean value) {
      this.requestField("receiving_credential", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGetOwningCreditAllocationConfigs requestSendBillToField () {
      return this.requestSendBillToField(true);
    }
    public APIRequestGetOwningCreditAllocationConfigs requestSendBillToField (boolean value) {
      this.requestField("send_bill_to", value);
      return this;
    }
  }

  public static class APIRequestCreateOwningCreditAllocationConfig extends APIRequest<ExtendedCreditAllocationConfig> {

    ExtendedCreditAllocationConfig lastResponse = null;
    @Override
    public ExtendedCreditAllocationConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "amount",
      "liability_type",
      "partition_type",
      "receiving_business_id",
      "send_bill_to",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ExtendedCreditAllocationConfig parseResponse(String response, String header) throws APIException {
      return ExtendedCreditAllocationConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ExtendedCreditAllocationConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExtendedCreditAllocationConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ExtendedCreditAllocationConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExtendedCreditAllocationConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ExtendedCreditAllocationConfig>() {
           public ExtendedCreditAllocationConfig apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwningCreditAllocationConfig.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwningCreditAllocationConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/owning_credit_allocation_configs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwningCreditAllocationConfig setAmount (Object amount) {
      this.setParam("amount", amount);
      return this;
    }
    public APIRequestCreateOwningCreditAllocationConfig setAmount (String amount) {
      this.setParam("amount", amount);
      return this;
    }

    public APIRequestCreateOwningCreditAllocationConfig setLiabilityType (ExtendedCreditAllocationConfig.EnumLiabilityType liabilityType) {
      this.setParam("liability_type", liabilityType);
      return this;
    }
    public APIRequestCreateOwningCreditAllocationConfig setLiabilityType (String liabilityType) {
      this.setParam("liability_type", liabilityType);
      return this;
    }

    public APIRequestCreateOwningCreditAllocationConfig setPartitionType (ExtendedCreditAllocationConfig.EnumPartitionType partitionType) {
      this.setParam("partition_type", partitionType);
      return this;
    }
    public APIRequestCreateOwningCreditAllocationConfig setPartitionType (String partitionType) {
      this.setParam("partition_type", partitionType);
      return this;
    }

    public APIRequestCreateOwningCreditAllocationConfig setReceivingBusinessId (String receivingBusinessId) {
      this.setParam("receiving_business_id", receivingBusinessId);
      return this;
    }

    public APIRequestCreateOwningCreditAllocationConfig setSendBillTo (ExtendedCreditAllocationConfig.EnumSendBillTo sendBillTo) {
      this.setParam("send_bill_to", sendBillTo);
      return this;
    }
    public APIRequestCreateOwningCreditAllocationConfig setSendBillTo (String sendBillTo) {
      this.setParam("send_bill_to", sendBillTo);
      return this;
    }

    public APIRequestCreateOwningCreditAllocationConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwningCreditAllocationConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwningCreditAllocationConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateWhatsAppCreditSharingAnDAttach extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "waba_currency",
      "waba_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateWhatsAppCreditSharingAnDAttach.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateWhatsAppCreditSharingAnDAttach(String nodeId, APIContext context) {
      super(context, nodeId, "/whatsapp_credit_sharing_and_attach", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateWhatsAppCreditSharingAnDAttach setWabaCurrency (String wabaCurrency) {
      this.setParam("waba_currency", wabaCurrency);
      return this;
    }

    public APIRequestCreateWhatsAppCreditSharingAnDAttach setWabaId (String wabaId) {
      this.setParam("waba_id", wabaId);
      return this;
    }

    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppCreditSharingAnDAttach requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<ExtendedCredit> {

    ExtendedCredit lastResponse = null;
    @Override
    public ExtendedCredit getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "allocated_amount",
      "balance",
      "credit_available",
      "credit_type",
      "id",
      "is_access_revoked",
      "is_automated_experience",
      "legal_entity_name",
      "liable_address",
      "liable_biz_name",
      "max_balance",
      "online_max_balance",
      "owner_business",
      "owner_business_name",
      "partition_from",
      "receiving_credit_allocation_config",
      "send_bill_to_address",
      "send_bill_to_biz_name",
      "sold_to_address",
    };

    @Override
    public ExtendedCredit parseResponse(String response, String header) throws APIException {
      return ExtendedCredit.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ExtendedCredit execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExtendedCredit execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ExtendedCredit> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExtendedCredit> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ExtendedCredit>() {
           public ExtendedCredit apply(ResponseWrapper result) {
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

    public APIRequestGet requestAllocatedAmountField () {
      return this.requestAllocatedAmountField(true);
    }
    public APIRequestGet requestAllocatedAmountField (boolean value) {
      this.requestField("allocated_amount", value);
      return this;
    }
    public APIRequestGet requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGet requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGet requestCreditAvailableField () {
      return this.requestCreditAvailableField(true);
    }
    public APIRequestGet requestCreditAvailableField (boolean value) {
      this.requestField("credit_available", value);
      return this;
    }
    public APIRequestGet requestCreditTypeField () {
      return this.requestCreditTypeField(true);
    }
    public APIRequestGet requestCreditTypeField (boolean value) {
      this.requestField("credit_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAccessRevokedField () {
      return this.requestIsAccessRevokedField(true);
    }
    public APIRequestGet requestIsAccessRevokedField (boolean value) {
      this.requestField("is_access_revoked", value);
      return this;
    }
    public APIRequestGet requestIsAutomatedExperienceField () {
      return this.requestIsAutomatedExperienceField(true);
    }
    public APIRequestGet requestIsAutomatedExperienceField (boolean value) {
      this.requestField("is_automated_experience", value);
      return this;
    }
    public APIRequestGet requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGet requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGet requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGet requestLiableBizNameField () {
      return this.requestLiableBizNameField(true);
    }
    public APIRequestGet requestLiableBizNameField (boolean value) {
      this.requestField("liable_biz_name", value);
      return this;
    }
    public APIRequestGet requestMaxBalanceField () {
      return this.requestMaxBalanceField(true);
    }
    public APIRequestGet requestMaxBalanceField (boolean value) {
      this.requestField("max_balance", value);
      return this;
    }
    public APIRequestGet requestOnlineMaxBalanceField () {
      return this.requestOnlineMaxBalanceField(true);
    }
    public APIRequestGet requestOnlineMaxBalanceField (boolean value) {
      this.requestField("online_max_balance", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessNameField () {
      return this.requestOwnerBusinessNameField(true);
    }
    public APIRequestGet requestOwnerBusinessNameField (boolean value) {
      this.requestField("owner_business_name", value);
      return this;
    }
    public APIRequestGet requestPartitionFromField () {
      return this.requestPartitionFromField(true);
    }
    public APIRequestGet requestPartitionFromField (boolean value) {
      this.requestField("partition_from", value);
      return this;
    }
    public APIRequestGet requestReceivingCreditAllocationConfigField () {
      return this.requestReceivingCreditAllocationConfigField(true);
    }
    public APIRequestGet requestReceivingCreditAllocationConfigField (boolean value) {
      this.requestField("receiving_credit_allocation_config", value);
      return this;
    }
    public APIRequestGet requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGet requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGet requestSendBillToBizNameField () {
      return this.requestSendBillToBizNameField(true);
    }
    public APIRequestGet requestSendBillToBizNameField (boolean value) {
      this.requestField("send_bill_to_biz_name", value);
      return this;
    }
    public APIRequestGet requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGet requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
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

  public ExtendedCredit copyFrom(ExtendedCredit instance) {
    this.mAllocatedAmount = instance.mAllocatedAmount;
    this.mBalance = instance.mBalance;
    this.mCreditAvailable = instance.mCreditAvailable;
    this.mCreditType = instance.mCreditType;
    this.mId = instance.mId;
    this.mIsAccessRevoked = instance.mIsAccessRevoked;
    this.mIsAutomatedExperience = instance.mIsAutomatedExperience;
    this.mLegalEntityName = instance.mLegalEntityName;
    this.mLiableAddress = instance.mLiableAddress;
    this.mLiableBizName = instance.mLiableBizName;
    this.mMaxBalance = instance.mMaxBalance;
    this.mOnlineMaxBalance = instance.mOnlineMaxBalance;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mOwnerBusinessName = instance.mOwnerBusinessName;
    this.mPartitionFrom = instance.mPartitionFrom;
    this.mReceivingCreditAllocationConfig = instance.mReceivingCreditAllocationConfig;
    this.mSendBillToAddress = instance.mSendBillToAddress;
    this.mSendBillToBizName = instance.mSendBillToBizName;
    this.mSoldToAddress = instance.mSoldToAddress;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ExtendedCredit> getParser() {
    return new APIRequest.ResponseParser<ExtendedCredit>() {
      public APINodeList<ExtendedCredit> parseResponse(String response, APIContext context, APIRequest<ExtendedCredit> request, String header) throws MalformedResponseException {
        return ExtendedCredit.parseResponse(response, context, request, header);
      }
    };
  }
}
