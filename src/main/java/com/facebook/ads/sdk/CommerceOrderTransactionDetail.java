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
public class CommerceOrderTransactionDetail extends APINode {
  @SerializedName("net_payment_amount")
  private Object mNetPaymentAmount = null;
  @SerializedName("order_details")
  private CommerceOrder mOrderDetails = null;
  @SerializedName("payout_reference_id")
  private String mPayoutReferenceId = null;
  @SerializedName("processing_fee")
  private Object mProcessingFee = null;
  @SerializedName("tax_rate")
  private String mTaxRate = null;
  @SerializedName("transaction_date")
  private String mTransactionDate = null;
  @SerializedName("transaction_type")
  private String mTransactionType = null;
  @SerializedName("transfer_id")
  private String mTransferId = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public CommerceOrderTransactionDetail() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CommerceOrderTransactionDetail loadJSON(String json, APIContext context, String header) {
    CommerceOrderTransactionDetail commerceOrderTransactionDetail = getGson().fromJson(json, CommerceOrderTransactionDetail.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(commerceOrderTransactionDetail.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    commerceOrderTransactionDetail.context = context;
    commerceOrderTransactionDetail.rawValue = json;
    commerceOrderTransactionDetail.header = header;
    return commerceOrderTransactionDetail;
  }

  public static APINodeList<CommerceOrderTransactionDetail> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CommerceOrderTransactionDetail> commerceOrderTransactionDetails = new APINodeList<CommerceOrderTransactionDetail>(request, json, header);
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
          commerceOrderTransactionDetails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return commerceOrderTransactionDetails;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                commerceOrderTransactionDetails.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            commerceOrderTransactionDetails.setPaging(previous, next);
            if (context.hasAppSecret()) {
              commerceOrderTransactionDetails.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              commerceOrderTransactionDetails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  commerceOrderTransactionDetails.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              commerceOrderTransactionDetails.add(loadJSON(obj.toString(), context, header));
            }
          }
          return commerceOrderTransactionDetails;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              commerceOrderTransactionDetails.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return commerceOrderTransactionDetails;
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
              commerceOrderTransactionDetails.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return commerceOrderTransactionDetails;
          }

          // Sixth, check if it's pure JsonObject
          commerceOrderTransactionDetails.clear();
          commerceOrderTransactionDetails.add(loadJSON(json, context, header));
          return commerceOrderTransactionDetails;
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

  public APIRequestGetItems getItems() {
    return new APIRequestGetItems(this.getId(), context);
  }

  public APIRequestGetTaxDetails getTaxDetails() {
    return new APIRequestGetTaxDetails(this.getId(), context);
  }


  public Object getFieldNetPaymentAmount() {
    return mNetPaymentAmount;
  }

  public CommerceOrderTransactionDetail setFieldNetPaymentAmount(Object value) {
    this.mNetPaymentAmount = value;
    return this;
  }

  public CommerceOrder getFieldOrderDetails() {
    if (mOrderDetails != null) {
      mOrderDetails.context = getContext();
    }
    return mOrderDetails;
  }

  public CommerceOrderTransactionDetail setFieldOrderDetails(CommerceOrder value) {
    this.mOrderDetails = value;
    return this;
  }

  public CommerceOrderTransactionDetail setFieldOrderDetails(String value) {
    Type type = new TypeToken<CommerceOrder>(){}.getType();
    this.mOrderDetails = CommerceOrder.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPayoutReferenceId() {
    return mPayoutReferenceId;
  }

  public CommerceOrderTransactionDetail setFieldPayoutReferenceId(String value) {
    this.mPayoutReferenceId = value;
    return this;
  }

  public Object getFieldProcessingFee() {
    return mProcessingFee;
  }

  public CommerceOrderTransactionDetail setFieldProcessingFee(Object value) {
    this.mProcessingFee = value;
    return this;
  }

  public String getFieldTaxRate() {
    return mTaxRate;
  }

  public CommerceOrderTransactionDetail setFieldTaxRate(String value) {
    this.mTaxRate = value;
    return this;
  }

  public String getFieldTransactionDate() {
    return mTransactionDate;
  }

  public CommerceOrderTransactionDetail setFieldTransactionDate(String value) {
    this.mTransactionDate = value;
    return this;
  }

  public String getFieldTransactionType() {
    return mTransactionType;
  }

  public CommerceOrderTransactionDetail setFieldTransactionType(String value) {
    this.mTransactionType = value;
    return this;
  }

  public String getFieldTransferId() {
    return mTransferId;
  }

  public CommerceOrderTransactionDetail setFieldTransferId(String value) {
    this.mTransferId = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public CommerceOrderTransactionDetail setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGetItems extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetItems.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetItems(String nodeId, APIContext context) {
      super(context, nodeId, "/items", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetItems setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetItems setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetItems requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetItems requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetItems requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetItems requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetItems requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetItems requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTaxDetails extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTaxDetails.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTaxDetails(String nodeId, APIContext context) {
      super(context, nodeId, "/tax_details", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTaxDetails setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTaxDetails setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTaxDetails requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTaxDetails requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTaxDetails requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTaxDetails requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTaxDetails requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTaxDetails requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public CommerceOrderTransactionDetail copyFrom(CommerceOrderTransactionDetail instance) {
    this.mNetPaymentAmount = instance.mNetPaymentAmount;
    this.mOrderDetails = instance.mOrderDetails;
    this.mPayoutReferenceId = instance.mPayoutReferenceId;
    this.mProcessingFee = instance.mProcessingFee;
    this.mTaxRate = instance.mTaxRate;
    this.mTransactionDate = instance.mTransactionDate;
    this.mTransactionType = instance.mTransactionType;
    this.mTransferId = instance.mTransferId;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CommerceOrderTransactionDetail> getParser() {
    return new APIRequest.ResponseParser<CommerceOrderTransactionDetail>() {
      public APINodeList<CommerceOrderTransactionDetail> parseResponse(String response, APIContext context, APIRequest<CommerceOrderTransactionDetail> request, String header) throws MalformedResponseException {
        return CommerceOrderTransactionDetail.parseResponse(response, context, request, header);
      }
    };
  }
}
