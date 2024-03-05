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
public class ExtendedCreditAllocationConfig extends APINode {
  @SerializedName("currency_amount")
  private CurrencyAmount mCurrencyAmount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("liability_type")
  private String mLiabilityType = null;
  @SerializedName("owning_business")
  private Business mOwningBusiness = null;
  @SerializedName("owning_credential")
  private ExtendedCredit mOwningCredential = null;
  @SerializedName("partition_type")
  private String mPartitionType = null;
  @SerializedName("receiving_business")
  private Business mReceivingBusiness = null;
  @SerializedName("receiving_credential")
  private ExtendedCredit mReceivingCredential = null;
  @SerializedName("request_status")
  private String mRequestStatus = null;
  @SerializedName("send_bill_to")
  private String mSendBillTo = null;
  protected static Gson gson = null;

  ExtendedCreditAllocationConfig() {
  }

  public ExtendedCreditAllocationConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ExtendedCreditAllocationConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ExtendedCreditAllocationConfig fetch() throws APIException{
    ExtendedCreditAllocationConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ExtendedCreditAllocationConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ExtendedCreditAllocationConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ExtendedCreditAllocationConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ExtendedCreditAllocationConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ExtendedCreditAllocationConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ExtendedCreditAllocationConfig>)(
      new APIRequest<ExtendedCreditAllocationConfig>(context, "", "/", "GET", ExtendedCreditAllocationConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ExtendedCreditAllocationConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ExtendedCreditAllocationConfig.getParser())
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
  public static ExtendedCreditAllocationConfig loadJSON(String json, APIContext context, String header) {
    ExtendedCreditAllocationConfig extendedCreditAllocationConfig = getGson().fromJson(json, ExtendedCreditAllocationConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(extendedCreditAllocationConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    extendedCreditAllocationConfig.context = context;
    extendedCreditAllocationConfig.rawValue = json;
    extendedCreditAllocationConfig.header = header;
    return extendedCreditAllocationConfig;
  }

  public static APINodeList<ExtendedCreditAllocationConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ExtendedCreditAllocationConfig> extendedCreditAllocationConfigs = new APINodeList<ExtendedCreditAllocationConfig>(request, json, header);
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
          extendedCreditAllocationConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return extendedCreditAllocationConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                extendedCreditAllocationConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            extendedCreditAllocationConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              extendedCreditAllocationConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              extendedCreditAllocationConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  extendedCreditAllocationConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              extendedCreditAllocationConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return extendedCreditAllocationConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              extendedCreditAllocationConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return extendedCreditAllocationConfigs;
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
              extendedCreditAllocationConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return extendedCreditAllocationConfigs;
          }

          // Sixth, check if it's pure JsonObject
          extendedCreditAllocationConfigs.clear();
          extendedCreditAllocationConfigs.add(loadJSON(json, context, header));
          return extendedCreditAllocationConfigs;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public CurrencyAmount getFieldCurrencyAmount() {
    return mCurrencyAmount;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLiabilityType() {
    return mLiabilityType;
  }

  public Business getFieldOwningBusiness() {
    if (mOwningBusiness != null) {
      mOwningBusiness.context = getContext();
    }
    return mOwningBusiness;
  }

  public ExtendedCredit getFieldOwningCredential() {
    if (mOwningCredential != null) {
      mOwningCredential.context = getContext();
    }
    return mOwningCredential;
  }

  public String getFieldPartitionType() {
    return mPartitionType;
  }

  public Business getFieldReceivingBusiness() {
    if (mReceivingBusiness != null) {
      mReceivingBusiness.context = getContext();
    }
    return mReceivingBusiness;
  }

  public ExtendedCredit getFieldReceivingCredential() {
    if (mReceivingCredential != null) {
      mReceivingCredential.context = getContext();
    }
    return mReceivingCredential;
  }

  public String getFieldRequestStatus() {
    return mRequestStatus;
  }

  public String getFieldSendBillTo() {
    return mSendBillTo;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<ExtendedCreditAllocationConfig> {

    ExtendedCreditAllocationConfig lastResponse = null;
    @Override
    public ExtendedCreditAllocationConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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

    public APIRequestGet requestCurrencyAmountField () {
      return this.requestCurrencyAmountField(true);
    }
    public APIRequestGet requestCurrencyAmountField (boolean value) {
      this.requestField("currency_amount", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLiabilityTypeField () {
      return this.requestLiabilityTypeField(true);
    }
    public APIRequestGet requestLiabilityTypeField (boolean value) {
      this.requestField("liability_type", value);
      return this;
    }
    public APIRequestGet requestOwningBusinessField () {
      return this.requestOwningBusinessField(true);
    }
    public APIRequestGet requestOwningBusinessField (boolean value) {
      this.requestField("owning_business", value);
      return this;
    }
    public APIRequestGet requestOwningCredentialField () {
      return this.requestOwningCredentialField(true);
    }
    public APIRequestGet requestOwningCredentialField (boolean value) {
      this.requestField("owning_credential", value);
      return this;
    }
    public APIRequestGet requestPartitionTypeField () {
      return this.requestPartitionTypeField(true);
    }
    public APIRequestGet requestPartitionTypeField (boolean value) {
      this.requestField("partition_type", value);
      return this;
    }
    public APIRequestGet requestReceivingBusinessField () {
      return this.requestReceivingBusinessField(true);
    }
    public APIRequestGet requestReceivingBusinessField (boolean value) {
      this.requestField("receiving_business", value);
      return this;
    }
    public APIRequestGet requestReceivingCredentialField () {
      return this.requestReceivingCredentialField(true);
    }
    public APIRequestGet requestReceivingCredentialField (boolean value) {
      this.requestField("receiving_credential", value);
      return this;
    }
    public APIRequestGet requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGet requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGet requestSendBillToField () {
      return this.requestSendBillToField(true);
    }
    public APIRequestGet requestSendBillToField (boolean value) {
      this.requestField("send_bill_to", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ExtendedCreditAllocationConfig> {

    ExtendedCreditAllocationConfig lastResponse = null;
    @Override
    public ExtendedCreditAllocationConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "amount",
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
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAmount (Object amount) {
      this.setParam("amount", amount);
      return this;
    }
    public APIRequestUpdate setAmount (String amount) {
      this.setParam("amount", amount);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumLiabilityType {
      @SerializedName("MSA")
      VALUE_MSA("MSA"),
      @SerializedName("Normal")
      VALUE_NORMAL("Normal"),
      @SerializedName("Sequential")
      VALUE_SEQUENTIAL("Sequential"),
      ;

      private String value;

      private EnumLiabilityType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPartitionType {
      @SerializedName("AUTH")
      VALUE_AUTH("AUTH"),
      @SerializedName("FIXED")
      VALUE_FIXED("FIXED"),
      @SerializedName("FIXED_WITHOUT_PARTITION")
      VALUE_FIXED_WITHOUT_PARTITION("FIXED_WITHOUT_PARTITION"),
      ;

      private String value;

      private EnumPartitionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSendBillTo {
      @SerializedName("Advertiser")
      VALUE_ADVERTISER("Advertiser"),
      @SerializedName("Agency")
      VALUE_AGENCY("Agency"),
      ;

      private String value;

      private EnumSendBillTo(String value) {
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

  public ExtendedCreditAllocationConfig copyFrom(ExtendedCreditAllocationConfig instance) {
    this.mCurrencyAmount = instance.mCurrencyAmount;
    this.mId = instance.mId;
    this.mLiabilityType = instance.mLiabilityType;
    this.mOwningBusiness = instance.mOwningBusiness;
    this.mOwningCredential = instance.mOwningCredential;
    this.mPartitionType = instance.mPartitionType;
    this.mReceivingBusiness = instance.mReceivingBusiness;
    this.mReceivingCredential = instance.mReceivingCredential;
    this.mRequestStatus = instance.mRequestStatus;
    this.mSendBillTo = instance.mSendBillTo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ExtendedCreditAllocationConfig> getParser() {
    return new APIRequest.ResponseParser<ExtendedCreditAllocationConfig>() {
      public APINodeList<ExtendedCreditAllocationConfig> parseResponse(String response, APIContext context, APIRequest<ExtendedCreditAllocationConfig> request, String header) throws MalformedResponseException {
        return ExtendedCreditAllocationConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
