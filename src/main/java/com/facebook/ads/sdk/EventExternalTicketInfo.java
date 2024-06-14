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
public class EventExternalTicketInfo extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("max_sales_price")
  private CurrencyAmount mMaxSalesPrice = null;
  @SerializedName("min_sales_price")
  private CurrencyAmount mMinSalesPrice = null;
  @SerializedName("sales_status")
  private String mSalesStatus = null;
  protected static Gson gson = null;

  EventExternalTicketInfo() {
  }

  public EventExternalTicketInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public EventExternalTicketInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public EventExternalTicketInfo fetch() throws APIException{
    EventExternalTicketInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static EventExternalTicketInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<EventExternalTicketInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static EventExternalTicketInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<EventExternalTicketInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<EventExternalTicketInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<EventExternalTicketInfo>)(
      new APIRequest<EventExternalTicketInfo>(context, "", "/", "GET", EventExternalTicketInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<EventExternalTicketInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", EventExternalTicketInfo.getParser())
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
  public static EventExternalTicketInfo loadJSON(String json, APIContext context, String header) {
    EventExternalTicketInfo eventExternalTicketInfo = getGson().fromJson(json, EventExternalTicketInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(eventExternalTicketInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    eventExternalTicketInfo.context = context;
    eventExternalTicketInfo.rawValue = json;
    eventExternalTicketInfo.header = header;
    return eventExternalTicketInfo;
  }

  public static APINodeList<EventExternalTicketInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<EventExternalTicketInfo> eventExternalTicketInfos = new APINodeList<EventExternalTicketInfo>(request, json, header);
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
          eventExternalTicketInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return eventExternalTicketInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                eventExternalTicketInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            eventExternalTicketInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              eventExternalTicketInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              eventExternalTicketInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  eventExternalTicketInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              eventExternalTicketInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return eventExternalTicketInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              eventExternalTicketInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return eventExternalTicketInfos;
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
              eventExternalTicketInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return eventExternalTicketInfos;
          }

          // Sixth, check if it's pure JsonObject
          eventExternalTicketInfos.clear();
          eventExternalTicketInfos.add(loadJSON(json, context, header));
          return eventExternalTicketInfos;
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


  public String getFieldId() {
    return mId;
  }

  public CurrencyAmount getFieldMaxSalesPrice() {
    return mMaxSalesPrice;
  }

  public CurrencyAmount getFieldMinSalesPrice() {
    return mMinSalesPrice;
  }

  public String getFieldSalesStatus() {
    return mSalesStatus;
  }



  public static class APIRequestGet extends APIRequest<EventExternalTicketInfo> {

    EventExternalTicketInfo lastResponse = null;
    @Override
    public EventExternalTicketInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "max_sales_price",
      "min_sales_price",
      "sales_status",
    };

    @Override
    public EventExternalTicketInfo parseResponse(String response, String header) throws APIException {
      return EventExternalTicketInfo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public EventExternalTicketInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventExternalTicketInfo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<EventExternalTicketInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventExternalTicketInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, EventExternalTicketInfo>() {
           public EventExternalTicketInfo apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMaxSalesPriceField () {
      return this.requestMaxSalesPriceField(true);
    }
    public APIRequestGet requestMaxSalesPriceField (boolean value) {
      this.requestField("max_sales_price", value);
      return this;
    }
    public APIRequestGet requestMinSalesPriceField () {
      return this.requestMinSalesPriceField(true);
    }
    public APIRequestGet requestMinSalesPriceField (boolean value) {
      this.requestField("min_sales_price", value);
      return this;
    }
    public APIRequestGet requestSalesStatusField () {
      return this.requestSalesStatusField(true);
    }
    public APIRequestGet requestSalesStatusField (boolean value) {
      this.requestField("sales_status", value);
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

  public EventExternalTicketInfo copyFrom(EventExternalTicketInfo instance) {
    this.mId = instance.mId;
    this.mMaxSalesPrice = instance.mMaxSalesPrice;
    this.mMinSalesPrice = instance.mMinSalesPrice;
    this.mSalesStatus = instance.mSalesStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<EventExternalTicketInfo> getParser() {
    return new APIRequest.ResponseParser<EventExternalTicketInfo>() {
      public APINodeList<EventExternalTicketInfo> parseResponse(String response, APIContext context, APIRequest<EventExternalTicketInfo> request, String header) throws MalformedResponseException {
        return EventExternalTicketInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
