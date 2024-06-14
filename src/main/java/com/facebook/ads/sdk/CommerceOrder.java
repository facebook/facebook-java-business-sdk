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
public class CommerceOrder extends APINode {
  @SerializedName("buyer_details")
  private Object mBuyerDetails = null;
  @SerializedName("channel")
  private String mChannel = null;
  @SerializedName("contains_bopis_items")
  private Boolean mContainsBopisItems = null;
  @SerializedName("created")
  private String mCreated = null;
  @SerializedName("estimated_payment_details")
  private Object mEstimatedPaymentDetails = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_group_buy")
  private Boolean mIsGroupBuy = null;
  @SerializedName("is_test_order")
  private Boolean mIsTestOrder = null;
  @SerializedName("last_updated")
  private String mLastUpdated = null;
  @SerializedName("merchant_order_id")
  private String mMerchantOrderId = null;
  @SerializedName("order_status")
  private Object mOrderStatus = null;
  @SerializedName("selected_shipping_option")
  private Object mSelectedShippingOption = null;
  @SerializedName("ship_by_date")
  private String mShipByDate = null;
  @SerializedName("shipping_address")
  private Object mShippingAddress = null;
  protected static Gson gson = null;

  CommerceOrder() {
  }

  public CommerceOrder(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CommerceOrder(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CommerceOrder fetch() throws APIException{
    CommerceOrder newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CommerceOrder fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CommerceOrder> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CommerceOrder fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CommerceOrder> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CommerceOrder> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CommerceOrder>)(
      new APIRequest<CommerceOrder>(context, "", "/", "GET", CommerceOrder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CommerceOrder>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CommerceOrder.getParser())
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
  public static CommerceOrder loadJSON(String json, APIContext context, String header) {
    CommerceOrder commerceOrder = getGson().fromJson(json, CommerceOrder.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(commerceOrder.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    commerceOrder.context = context;
    commerceOrder.rawValue = json;
    commerceOrder.header = header;
    return commerceOrder;
  }

  public static APINodeList<CommerceOrder> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CommerceOrder> commerceOrders = new APINodeList<CommerceOrder>(request, json, header);
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
          commerceOrders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return commerceOrders;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                commerceOrders.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            commerceOrders.setPaging(previous, next);
            if (context.hasAppSecret()) {
              commerceOrders.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              commerceOrders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  commerceOrders.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              commerceOrders.add(loadJSON(obj.toString(), context, header));
            }
          }
          return commerceOrders;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              commerceOrders.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return commerceOrders;
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
              commerceOrders.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return commerceOrders;
          }

          // Sixth, check if it's pure JsonObject
          commerceOrders.clear();
          commerceOrders.add(loadJSON(json, context, header));
          return commerceOrders;
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

  public APIRequestCreateAcknowledgeOrder createAcknowledgeOrder() {
    return new APIRequestCreateAcknowledgeOrder(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCancellations getCancellations() {
    return new APIRequestGetCancellations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCanCellATIOn createCanCellATIOn() {
    return new APIRequestCreateCanCellATIOn(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateItemUpdate createItemUpdate() {
    return new APIRequestCreateItemUpdate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetItems getItems() {
    return new APIRequestGetItems(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPayments getPayments() {
    return new APIRequestGetPayments(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPromotionDetails getPromotionDetails() {
    return new APIRequestGetPromotionDetails(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPromoTIOns getPromoTIOns() {
    return new APIRequestGetPromoTIOns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRefunds getRefunds() {
    return new APIRequestGetRefunds(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateRefund createRefund() {
    return new APIRequestCreateRefund(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReturns getReturns() {
    return new APIRequestGetReturns(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateReturn createReturn() {
    return new APIRequestCreateReturn(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShipments getShipments() {
    return new APIRequestGetShipments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateShipment createShipment() {
    return new APIRequestCreateShipment(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpdateShipment createUpdateShipment() {
    return new APIRequestCreateUpdateShipment(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpdate createUpdate() {
    return new APIRequestCreateUpdate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldBuyerDetails() {
    return mBuyerDetails;
  }

  public String getFieldChannel() {
    return mChannel;
  }

  public Boolean getFieldContainsBopisItems() {
    return mContainsBopisItems;
  }

  public String getFieldCreated() {
    return mCreated;
  }

  public Object getFieldEstimatedPaymentDetails() {
    return mEstimatedPaymentDetails;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsGroupBuy() {
    return mIsGroupBuy;
  }

  public Boolean getFieldIsTestOrder() {
    return mIsTestOrder;
  }

  public String getFieldLastUpdated() {
    return mLastUpdated;
  }

  public String getFieldMerchantOrderId() {
    return mMerchantOrderId;
  }

  public Object getFieldOrderStatus() {
    return mOrderStatus;
  }

  public Object getFieldSelectedShippingOption() {
    return mSelectedShippingOption;
  }

  public String getFieldShipByDate() {
    return mShipByDate;
  }

  public Object getFieldShippingAddress() {
    return mShippingAddress;
  }



  public static class APIRequestCreateAcknowledgeOrder extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "idempotency_key",
      "merchant_order_reference",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAcknowledgeOrder.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAcknowledgeOrder(String nodeId, APIContext context) {
      super(context, nodeId, "/acknowledge_order", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAcknowledgeOrder setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAcknowledgeOrder setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateAcknowledgeOrder setMerchantOrderReference (String merchantOrderReference) {
      this.setParam("merchant_order_reference", merchantOrderReference);
      return this;
    }

    public APIRequestCreateAcknowledgeOrder requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAcknowledgeOrder requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAcknowledgeOrder requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCancellations extends APIRequest<APINode> {

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
               return APIRequestGetCancellations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCancellations(String nodeId, APIContext context) {
      super(context, nodeId, "/cancellations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCancellations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCancellations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCancellations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCancellations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCancellations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCancellations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCancellations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCancellations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateCanCellATIOn extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cancel_reason",
      "idempotency_key",
      "items",
      "restock_items",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCanCellATIOn.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCanCellATIOn(String nodeId, APIContext context) {
      super(context, nodeId, "/cancellations", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCanCellATIOn setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCanCellATIOn setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCanCellATIOn setCancelReason (Map<String, String> cancelReason) {
      this.setParam("cancel_reason", cancelReason);
      return this;
    }
    public APIRequestCreateCanCellATIOn setCancelReason (String cancelReason) {
      this.setParam("cancel_reason", cancelReason);
      return this;
    }

    public APIRequestCreateCanCellATIOn setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateCanCellATIOn setItems (List<Map<String, String>> items) {
      this.setParam("items", items);
      return this;
    }
    public APIRequestCreateCanCellATIOn setItems (String items) {
      this.setParam("items", items);
      return this;
    }

    public APIRequestCreateCanCellATIOn setRestockItems (Boolean restockItems) {
      this.setParam("restock_items", restockItems);
      return this;
    }
    public APIRequestCreateCanCellATIOn setRestockItems (String restockItems) {
      this.setParam("restock_items", restockItems);
      return this;
    }

    public APIRequestCreateCanCellATIOn requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCanCellATIOn requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanCellATIOn requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCanCellATIOn requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanCellATIOn requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCanCellATIOn requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateItemUpdate extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "items",
      "merchant_order_reference",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateItemUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateItemUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/item_updates", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateItemUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateItemUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateItemUpdate setItems (List<Map<String, String>> items) {
      this.setParam("items", items);
      return this;
    }
    public APIRequestCreateItemUpdate setItems (String items) {
      this.setParam("items", items);
      return this;
    }

    public APIRequestCreateItemUpdate setMerchantOrderReference (String merchantOrderReference) {
      this.setParam("merchant_order_reference", merchantOrderReference);
      return this;
    }

    public APIRequestCreateItemUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateItemUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateItemUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateItemUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateItemUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateItemUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

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

  public static class APIRequestGetPayments extends APIRequest<APINode> {

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
               return APIRequestGetPayments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPayments(String nodeId, APIContext context) {
      super(context, nodeId, "/payments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPayments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPayments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPayments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPayments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPayments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPayments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPayments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPayments requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPromotionDetails extends APIRequest<APINode> {

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
               return APIRequestGetPromotionDetails.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPromotionDetails(String nodeId, APIContext context) {
      super(context, nodeId, "/promotion_details", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPromotionDetails setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPromotionDetails setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPromotionDetails requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPromotionDetails requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotionDetails requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPromotionDetails requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotionDetails requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPromotionDetails requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPromoTIOns extends APIRequest<APINode> {

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
               return APIRequestGetPromoTIOns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPromoTIOns(String nodeId, APIContext context) {
      super(context, nodeId, "/promotions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPromoTIOns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPromoTIOns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPromoTIOns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPromoTIOns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromoTIOns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPromoTIOns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromoTIOns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPromoTIOns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRefunds extends APIRequest<APINode> {

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
               return APIRequestGetRefunds.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRefunds(String nodeId, APIContext context) {
      super(context, nodeId, "/refunds", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRefunds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRefunds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRefunds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRefunds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRefunds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRefunds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRefunds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRefunds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateRefund extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adjustment_amount",
      "deductions",
      "idempotency_key",
      "items",
      "reason_code",
      "reason_text",
      "return_id",
      "shipping",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
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


    public APIRequestCreateRefund setAdjustmentAmount (Map<String, String> adjustmentAmount) {
      this.setParam("adjustment_amount", adjustmentAmount);
      return this;
    }
    public APIRequestCreateRefund setAdjustmentAmount (String adjustmentAmount) {
      this.setParam("adjustment_amount", adjustmentAmount);
      return this;
    }

    public APIRequestCreateRefund setDeductions (List<Map<String, String>> deductions) {
      this.setParam("deductions", deductions);
      return this;
    }
    public APIRequestCreateRefund setDeductions (String deductions) {
      this.setParam("deductions", deductions);
      return this;
    }

    public APIRequestCreateRefund setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateRefund setItems (List<Map<String, String>> items) {
      this.setParam("items", items);
      return this;
    }
    public APIRequestCreateRefund setItems (String items) {
      this.setParam("items", items);
      return this;
    }

    public APIRequestCreateRefund setReasonCode (CommerceOrder.EnumReasonCode reasonCode) {
      this.setParam("reason_code", reasonCode);
      return this;
    }
    public APIRequestCreateRefund setReasonCode (String reasonCode) {
      this.setParam("reason_code", reasonCode);
      return this;
    }

    public APIRequestCreateRefund setReasonText (String reasonText) {
      this.setParam("reason_text", reasonText);
      return this;
    }

    public APIRequestCreateRefund setReturnId (String returnId) {
      this.setParam("return_id", returnId);
      return this;
    }

    public APIRequestCreateRefund setShipping (Map<String, String> shipping) {
      this.setParam("shipping", shipping);
      return this;
    }
    public APIRequestCreateRefund setShipping (String shipping) {
      this.setParam("shipping", shipping);
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

  public static class APIRequestGetReturns extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "merchant_return_id",
      "statuses",
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
               return APIRequestGetReturns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetReturns(String nodeId, APIContext context) {
      super(context, nodeId, "/returns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReturns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReturns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReturns setMerchantReturnId (String merchantReturnId) {
      this.setParam("merchant_return_id", merchantReturnId);
      return this;
    }

    public APIRequestGetReturns setStatuses (List<EnumStatuses> statuses) {
      this.setParam("statuses", statuses);
      return this;
    }
    public APIRequestGetReturns setStatuses (String statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetReturns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReturns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReturns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReturns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReturns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReturns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateReturn extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "items",
      "merchant_return_id",
      "return_message",
      "update",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateReturn.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateReturn(String nodeId, APIContext context) {
      super(context, nodeId, "/returns", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateReturn setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateReturn setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateReturn setItems (List<Map<String, String>> items) {
      this.setParam("items", items);
      return this;
    }
    public APIRequestCreateReturn setItems (String items) {
      this.setParam("items", items);
      return this;
    }

    public APIRequestCreateReturn setMerchantReturnId (String merchantReturnId) {
      this.setParam("merchant_return_id", merchantReturnId);
      return this;
    }

    public APIRequestCreateReturn setReturnMessage (String returnMessage) {
      this.setParam("return_message", returnMessage);
      return this;
    }

    public APIRequestCreateReturn setUpdate (Map<String, String> update) {
      this.setParam("update", update);
      return this;
    }
    public APIRequestCreateReturn setUpdate (String update) {
      this.setParam("update", update);
      return this;
    }

    public APIRequestCreateReturn requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateReturn requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReturn requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateReturn requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReturn requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateReturn requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetShipments extends APIRequest<APINode> {

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
               return APIRequestGetShipments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetShipments(String nodeId, APIContext context) {
      super(context, nodeId, "/shipments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShipments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShipments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShipments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShipments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShipments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShipments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShipments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShipments requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateShipment extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_redemption_link",
      "external_shipment_id",
      "fulfillment",
      "idempotency_key",
      "items",
      "merchant_order_reference",
      "shipment_origin_postal_code",
      "shipping_tax_details",
      "should_use_default_fulfillment_location",
      "tracking_info",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateShipment.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateShipment(String nodeId, APIContext context) {
      super(context, nodeId, "/shipments", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateShipment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateShipment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateShipment setExternalRedemptionLink (String externalRedemptionLink) {
      this.setParam("external_redemption_link", externalRedemptionLink);
      return this;
    }

    public APIRequestCreateShipment setExternalShipmentId (String externalShipmentId) {
      this.setParam("external_shipment_id", externalShipmentId);
      return this;
    }

    public APIRequestCreateShipment setFulfillment (Map<String, String> fulfillment) {
      this.setParam("fulfillment", fulfillment);
      return this;
    }
    public APIRequestCreateShipment setFulfillment (String fulfillment) {
      this.setParam("fulfillment", fulfillment);
      return this;
    }

    public APIRequestCreateShipment setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateShipment setItems (List<Map<String, String>> items) {
      this.setParam("items", items);
      return this;
    }
    public APIRequestCreateShipment setItems (String items) {
      this.setParam("items", items);
      return this;
    }

    public APIRequestCreateShipment setMerchantOrderReference (String merchantOrderReference) {
      this.setParam("merchant_order_reference", merchantOrderReference);
      return this;
    }

    public APIRequestCreateShipment setShipmentOriginPostalCode (String shipmentOriginPostalCode) {
      this.setParam("shipment_origin_postal_code", shipmentOriginPostalCode);
      return this;
    }

    public APIRequestCreateShipment setShippingTaxDetails (Map<String, String> shippingTaxDetails) {
      this.setParam("shipping_tax_details", shippingTaxDetails);
      return this;
    }
    public APIRequestCreateShipment setShippingTaxDetails (String shippingTaxDetails) {
      this.setParam("shipping_tax_details", shippingTaxDetails);
      return this;
    }

    public APIRequestCreateShipment setShouldUseDefaultFulfillmentLocation (Boolean shouldUseDefaultFulfillmentLocation) {
      this.setParam("should_use_default_fulfillment_location", shouldUseDefaultFulfillmentLocation);
      return this;
    }
    public APIRequestCreateShipment setShouldUseDefaultFulfillmentLocation (String shouldUseDefaultFulfillmentLocation) {
      this.setParam("should_use_default_fulfillment_location", shouldUseDefaultFulfillmentLocation);
      return this;
    }

    public APIRequestCreateShipment setTrackingInfo (Map<String, String> trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }
    public APIRequestCreateShipment setTrackingInfo (String trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }

    public APIRequestCreateShipment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateShipment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShipment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateShipment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShipment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateShipment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUpdateShipment extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_shipment_id",
      "fulfillment_id",
      "idempotency_key",
      "shipment_id",
      "tracking_info",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateUpdateShipment.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateUpdateShipment(String nodeId, APIContext context) {
      super(context, nodeId, "/update_shipment", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUpdateShipment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUpdateShipment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUpdateShipment setExternalShipmentId (String externalShipmentId) {
      this.setParam("external_shipment_id", externalShipmentId);
      return this;
    }

    public APIRequestCreateUpdateShipment setFulfillmentId (String fulfillmentId) {
      this.setParam("fulfillment_id", fulfillmentId);
      return this;
    }

    public APIRequestCreateUpdateShipment setIdempotencyKey (String idempotencyKey) {
      this.setParam("idempotency_key", idempotencyKey);
      return this;
    }

    public APIRequestCreateUpdateShipment setShipmentId (String shipmentId) {
      this.setParam("shipment_id", shipmentId);
      return this;
    }

    public APIRequestCreateUpdateShipment setTrackingInfo (Map<String, String> trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }
    public APIRequestCreateUpdateShipment setTrackingInfo (String trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }

    public APIRequestCreateUpdateShipment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpdateShipment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpdateShipment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUpdateShipment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpdateShipment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUpdateShipment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUpdate extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cancel_amount",
      "fulfill_amount",
      "merchant_order_reference",
      "refund_amount",
      "total_amount",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/updates", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUpdate setCancelAmount (Map<String, String> cancelAmount) {
      this.setParam("cancel_amount", cancelAmount);
      return this;
    }
    public APIRequestCreateUpdate setCancelAmount (String cancelAmount) {
      this.setParam("cancel_amount", cancelAmount);
      return this;
    }

    public APIRequestCreateUpdate setFulfillAmount (Map<String, String> fulfillAmount) {
      this.setParam("fulfill_amount", fulfillAmount);
      return this;
    }
    public APIRequestCreateUpdate setFulfillAmount (String fulfillAmount) {
      this.setParam("fulfill_amount", fulfillAmount);
      return this;
    }

    public APIRequestCreateUpdate setMerchantOrderReference (String merchantOrderReference) {
      this.setParam("merchant_order_reference", merchantOrderReference);
      return this;
    }

    public APIRequestCreateUpdate setRefundAmount (Map<String, String> refundAmount) {
      this.setParam("refund_amount", refundAmount);
      return this;
    }
    public APIRequestCreateUpdate setRefundAmount (String refundAmount) {
      this.setParam("refund_amount", refundAmount);
      return this;
    }

    public APIRequestCreateUpdate setTotalAmount (Map<String, String> totalAmount) {
      this.setParam("total_amount", totalAmount);
      return this;
    }
    public APIRequestCreateUpdate setTotalAmount (String totalAmount) {
      this.setParam("total_amount", totalAmount);
      return this;
    }

    public APIRequestCreateUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<CommerceOrder> {

    CommerceOrder lastResponse = null;
    @Override
    public CommerceOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "buyer_details",
      "channel",
      "contains_bopis_items",
      "created",
      "estimated_payment_details",
      "id",
      "is_group_buy",
      "is_test_order",
      "last_updated",
      "merchant_order_id",
      "order_status",
      "selected_shipping_option",
      "ship_by_date",
      "shipping_address",
    };

    @Override
    public CommerceOrder parseResponse(String response, String header) throws APIException {
      return CommerceOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CommerceOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CommerceOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CommerceOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CommerceOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CommerceOrder>() {
           public CommerceOrder apply(ResponseWrapper result) {
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

    public APIRequestGet requestBuyerDetailsField () {
      return this.requestBuyerDetailsField(true);
    }
    public APIRequestGet requestBuyerDetailsField (boolean value) {
      this.requestField("buyer_details", value);
      return this;
    }
    public APIRequestGet requestChannelField () {
      return this.requestChannelField(true);
    }
    public APIRequestGet requestChannelField (boolean value) {
      this.requestField("channel", value);
      return this;
    }
    public APIRequestGet requestContainsBopisItemsField () {
      return this.requestContainsBopisItemsField(true);
    }
    public APIRequestGet requestContainsBopisItemsField (boolean value) {
      this.requestField("contains_bopis_items", value);
      return this;
    }
    public APIRequestGet requestCreatedField () {
      return this.requestCreatedField(true);
    }
    public APIRequestGet requestCreatedField (boolean value) {
      this.requestField("created", value);
      return this;
    }
    public APIRequestGet requestEstimatedPaymentDetailsField () {
      return this.requestEstimatedPaymentDetailsField(true);
    }
    public APIRequestGet requestEstimatedPaymentDetailsField (boolean value) {
      this.requestField("estimated_payment_details", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsGroupBuyField () {
      return this.requestIsGroupBuyField(true);
    }
    public APIRequestGet requestIsGroupBuyField (boolean value) {
      this.requestField("is_group_buy", value);
      return this;
    }
    public APIRequestGet requestIsTestOrderField () {
      return this.requestIsTestOrderField(true);
    }
    public APIRequestGet requestIsTestOrderField (boolean value) {
      this.requestField("is_test_order", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedField () {
      return this.requestLastUpdatedField(true);
    }
    public APIRequestGet requestLastUpdatedField (boolean value) {
      this.requestField("last_updated", value);
      return this;
    }
    public APIRequestGet requestMerchantOrderIdField () {
      return this.requestMerchantOrderIdField(true);
    }
    public APIRequestGet requestMerchantOrderIdField (boolean value) {
      this.requestField("merchant_order_id", value);
      return this;
    }
    public APIRequestGet requestOrderStatusField () {
      return this.requestOrderStatusField(true);
    }
    public APIRequestGet requestOrderStatusField (boolean value) {
      this.requestField("order_status", value);
      return this;
    }
    public APIRequestGet requestSelectedShippingOptionField () {
      return this.requestSelectedShippingOptionField(true);
    }
    public APIRequestGet requestSelectedShippingOptionField (boolean value) {
      this.requestField("selected_shipping_option", value);
      return this;
    }
    public APIRequestGet requestShipByDateField () {
      return this.requestShipByDateField(true);
    }
    public APIRequestGet requestShipByDateField (boolean value) {
      this.requestField("ship_by_date", value);
      return this;
    }
    public APIRequestGet requestShippingAddressField () {
      return this.requestShippingAddressField(true);
    }
    public APIRequestGet requestShippingAddressField (boolean value) {
      this.requestField("shipping_address", value);
      return this;
    }
  }

  public static enum EnumFilters {
      @SerializedName("HAS_CANCELLATIONS")
      VALUE_HAS_CANCELLATIONS("HAS_CANCELLATIONS"),
      @SerializedName("HAS_FULFILLMENTS")
      VALUE_HAS_FULFILLMENTS("HAS_FULFILLMENTS"),
      @SerializedName("HAS_REFUNDS")
      VALUE_HAS_REFUNDS("HAS_REFUNDS"),
      @SerializedName("NO_CANCELLATIONS")
      VALUE_NO_CANCELLATIONS("NO_CANCELLATIONS"),
      @SerializedName("NO_REFUNDS")
      VALUE_NO_REFUNDS("NO_REFUNDS"),
      @SerializedName("NO_SHIPMENTS")
      VALUE_NO_SHIPMENTS("NO_SHIPMENTS"),
      ;

      private String value;

      private EnumFilters(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumState {
      @SerializedName("COMPLETED")
      VALUE_COMPLETED("COMPLETED"),
      @SerializedName("CREATED")
      VALUE_CREATED("CREATED"),
      @SerializedName("FB_PROCESSING")
      VALUE_FB_PROCESSING("FB_PROCESSING"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      ;

      private String value;

      private EnumState(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumReasonCode {
      @SerializedName("BUYERS_REMORSE")
      VALUE_BUYERS_REMORSE("BUYERS_REMORSE"),
      @SerializedName("DAMAGED_GOODS")
      VALUE_DAMAGED_GOODS("DAMAGED_GOODS"),
      @SerializedName("FACEBOOK_INITIATED")
      VALUE_FACEBOOK_INITIATED("FACEBOOK_INITIATED"),
      @SerializedName("NOT_AS_DESCRIBED")
      VALUE_NOT_AS_DESCRIBED("NOT_AS_DESCRIBED"),
      @SerializedName("QUALITY_ISSUE")
      VALUE_QUALITY_ISSUE("QUALITY_ISSUE"),
      @SerializedName("REFUND_COMPROMISED")
      VALUE_REFUND_COMPROMISED("REFUND_COMPROMISED"),
      @SerializedName("REFUND_FOR_RETURN")
      VALUE_REFUND_FOR_RETURN("REFUND_FOR_RETURN"),
      @SerializedName("REFUND_REASON_OTHER")
      VALUE_REFUND_REASON_OTHER("REFUND_REASON_OTHER"),
      @SerializedName("REFUND_SFI_FAKE")
      VALUE_REFUND_SFI_FAKE("REFUND_SFI_FAKE"),
      @SerializedName("REFUND_SFI_REAL")
      VALUE_REFUND_SFI_REAL("REFUND_SFI_REAL"),
      @SerializedName("WRONG_ITEM")
      VALUE_WRONG_ITEM("WRONG_ITEM"),
      ;

      private String value;

      private EnumReasonCode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatuses {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("DISAPPROVED")
      VALUE_DISAPPROVED("DISAPPROVED"),
      @SerializedName("MERCHANT_MARKED_COMPLETED")
      VALUE_MERCHANT_MARKED_COMPLETED("MERCHANT_MARKED_COMPLETED"),
      @SerializedName("REFUNDED")
      VALUE_REFUNDED("REFUNDED"),
      @SerializedName("REQUESTED")
      VALUE_REQUESTED("REQUESTED"),
      ;

      private String value;

      private EnumStatuses(String value) {
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

  public CommerceOrder copyFrom(CommerceOrder instance) {
    this.mBuyerDetails = instance.mBuyerDetails;
    this.mChannel = instance.mChannel;
    this.mContainsBopisItems = instance.mContainsBopisItems;
    this.mCreated = instance.mCreated;
    this.mEstimatedPaymentDetails = instance.mEstimatedPaymentDetails;
    this.mId = instance.mId;
    this.mIsGroupBuy = instance.mIsGroupBuy;
    this.mIsTestOrder = instance.mIsTestOrder;
    this.mLastUpdated = instance.mLastUpdated;
    this.mMerchantOrderId = instance.mMerchantOrderId;
    this.mOrderStatus = instance.mOrderStatus;
    this.mSelectedShippingOption = instance.mSelectedShippingOption;
    this.mShipByDate = instance.mShipByDate;
    this.mShippingAddress = instance.mShippingAddress;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CommerceOrder> getParser() {
    return new APIRequest.ResponseParser<CommerceOrder>() {
      public APINodeList<CommerceOrder> parseResponse(String response, APIContext context, APIRequest<CommerceOrder> request, String header) throws MalformedResponseException {
        return CommerceOrder.parseResponse(response, context, request, header);
      }
    };
  }
}
