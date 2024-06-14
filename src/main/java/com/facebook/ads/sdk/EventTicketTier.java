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
public class EventTicketTier extends APINode {
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_sales_time")
  private String mEndSalesTime = null;
  @SerializedName("end_show_time")
  private String mEndShowTime = null;
  @SerializedName("fee_settings")
  private String mFeeSettings = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("maximum_quantity")
  private Long mMaximumQuantity = null;
  @SerializedName("metadata")
  private String mMetadata = null;
  @SerializedName("minimum_quantity")
  private Long mMinimumQuantity = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("price")
  private Long mPrice = null;
  @SerializedName("priority")
  private Long mPriority = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("seating_map_image_url")
  private String mSeatingMapImageUrl = null;
  @SerializedName("start_sales_time")
  private String mStartSalesTime = null;
  @SerializedName("start_show_time")
  private String mStartShowTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("total_quantity")
  private Long mTotalQuantity = null;
  protected static Gson gson = null;

  EventTicketTier() {
  }

  public EventTicketTier(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public EventTicketTier(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public EventTicketTier fetch() throws APIException{
    EventTicketTier newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static EventTicketTier fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<EventTicketTier> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static EventTicketTier fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<EventTicketTier> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<EventTicketTier> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<EventTicketTier>)(
      new APIRequest<EventTicketTier>(context, "", "/", "GET", EventTicketTier.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<EventTicketTier>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", EventTicketTier.getParser())
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
  public static EventTicketTier loadJSON(String json, APIContext context, String header) {
    EventTicketTier eventTicketTier = getGson().fromJson(json, EventTicketTier.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(eventTicketTier.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    eventTicketTier.context = context;
    eventTicketTier.rawValue = json;
    eventTicketTier.header = header;
    return eventTicketTier;
  }

  public static APINodeList<EventTicketTier> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<EventTicketTier> eventTicketTiers = new APINodeList<EventTicketTier>(request, json, header);
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
          eventTicketTiers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return eventTicketTiers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                eventTicketTiers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            eventTicketTiers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              eventTicketTiers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              eventTicketTiers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  eventTicketTiers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              eventTicketTiers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return eventTicketTiers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              eventTicketTiers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return eventTicketTiers;
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
              eventTicketTiers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return eventTicketTiers;
          }

          // Sixth, check if it's pure JsonObject
          eventTicketTiers.clear();
          eventTicketTiers.add(loadJSON(json, context, header));
          return eventTicketTiers;
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


  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndSalesTime() {
    return mEndSalesTime;
  }

  public String getFieldEndShowTime() {
    return mEndShowTime;
  }

  public String getFieldFeeSettings() {
    return mFeeSettings;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldMaximumQuantity() {
    return mMaximumQuantity;
  }

  public String getFieldMetadata() {
    return mMetadata;
  }

  public Long getFieldMinimumQuantity() {
    return mMinimumQuantity;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldPrice() {
    return mPrice;
  }

  public Long getFieldPriority() {
    return mPriority;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public String getFieldSeatingMapImageUrl() {
    return mSeatingMapImageUrl;
  }

  public String getFieldStartSalesTime() {
    return mStartSalesTime;
  }

  public String getFieldStartShowTime() {
    return mStartShowTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Long getFieldTotalQuantity() {
    return mTotalQuantity;
  }



  public static class APIRequestGet extends APIRequest<EventTicketTier> {

    EventTicketTier lastResponse = null;
    @Override
    public EventTicketTier getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "currency",
      "description",
      "end_sales_time",
      "end_show_time",
      "fee_settings",
      "id",
      "maximum_quantity",
      "metadata",
      "minimum_quantity",
      "name",
      "price",
      "priority",
      "retailer_id",
      "seating_map_image_url",
      "start_sales_time",
      "start_show_time",
      "status",
      "total_quantity",
    };

    @Override
    public EventTicketTier parseResponse(String response, String header) throws APIException {
      return EventTicketTier.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public EventTicketTier execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventTicketTier execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<EventTicketTier> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventTicketTier> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, EventTicketTier>() {
           public EventTicketTier apply(ResponseWrapper result) {
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

    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEndSalesTimeField () {
      return this.requestEndSalesTimeField(true);
    }
    public APIRequestGet requestEndSalesTimeField (boolean value) {
      this.requestField("end_sales_time", value);
      return this;
    }
    public APIRequestGet requestEndShowTimeField () {
      return this.requestEndShowTimeField(true);
    }
    public APIRequestGet requestEndShowTimeField (boolean value) {
      this.requestField("end_show_time", value);
      return this;
    }
    public APIRequestGet requestFeeSettingsField () {
      return this.requestFeeSettingsField(true);
    }
    public APIRequestGet requestFeeSettingsField (boolean value) {
      this.requestField("fee_settings", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMaximumQuantityField () {
      return this.requestMaximumQuantityField(true);
    }
    public APIRequestGet requestMaximumQuantityField (boolean value) {
      this.requestField("maximum_quantity", value);
      return this;
    }
    public APIRequestGet requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGet requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGet requestMinimumQuantityField () {
      return this.requestMinimumQuantityField(true);
    }
    public APIRequestGet requestMinimumQuantityField (boolean value) {
      this.requestField("minimum_quantity", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGet requestPriorityField (boolean value) {
      this.requestField("priority", value);
      return this;
    }
    public APIRequestGet requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGet requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGet requestSeatingMapImageUrlField () {
      return this.requestSeatingMapImageUrlField(true);
    }
    public APIRequestGet requestSeatingMapImageUrlField (boolean value) {
      this.requestField("seating_map_image_url", value);
      return this;
    }
    public APIRequestGet requestStartSalesTimeField () {
      return this.requestStartSalesTimeField(true);
    }
    public APIRequestGet requestStartSalesTimeField (boolean value) {
      this.requestField("start_sales_time", value);
      return this;
    }
    public APIRequestGet requestStartShowTimeField () {
      return this.requestStartShowTimeField(true);
    }
    public APIRequestGet requestStartShowTimeField (boolean value) {
      this.requestField("start_show_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTotalQuantityField () {
      return this.requestTotalQuantityField(true);
    }
    public APIRequestGet requestTotalQuantityField (boolean value) {
      this.requestField("total_quantity", value);
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

  public EventTicketTier copyFrom(EventTicketTier instance) {
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mEndSalesTime = instance.mEndSalesTime;
    this.mEndShowTime = instance.mEndShowTime;
    this.mFeeSettings = instance.mFeeSettings;
    this.mId = instance.mId;
    this.mMaximumQuantity = instance.mMaximumQuantity;
    this.mMetadata = instance.mMetadata;
    this.mMinimumQuantity = instance.mMinimumQuantity;
    this.mName = instance.mName;
    this.mPrice = instance.mPrice;
    this.mPriority = instance.mPriority;
    this.mRetailerId = instance.mRetailerId;
    this.mSeatingMapImageUrl = instance.mSeatingMapImageUrl;
    this.mStartSalesTime = instance.mStartSalesTime;
    this.mStartShowTime = instance.mStartShowTime;
    this.mStatus = instance.mStatus;
    this.mTotalQuantity = instance.mTotalQuantity;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<EventTicketTier> getParser() {
    return new APIRequest.ResponseParser<EventTicketTier>() {
      public APINodeList<EventTicketTier> parseResponse(String response, APIContext context, APIRequest<EventTicketTier> request, String header) throws MalformedResponseException {
        return EventTicketTier.parseResponse(response, context, request, header);
      }
    };
  }
}
