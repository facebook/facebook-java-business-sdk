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
public class BidSchedule extends APINode {
  @SerializedName("ad_object_id")
  private String mAdObjectId = null;
  @SerializedName("bid_recurrence_type")
  private String mBidRecurrenceType = null;
  @SerializedName("bid_timezone")
  private String mBidTimezone = null;
  @SerializedName("bid_value")
  private Long mBidValue = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("time_end")
  private String mTimeEnd = null;
  @SerializedName("time_start")
  private String mTimeStart = null;
  protected static Gson gson = null;

  BidSchedule() {
  }

  public BidSchedule(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BidSchedule(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BidSchedule fetch() throws APIException{
    BidSchedule newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BidSchedule fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BidSchedule> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BidSchedule fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BidSchedule> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BidSchedule> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BidSchedule>)(
      new APIRequest<BidSchedule>(context, "", "/", "GET", BidSchedule.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BidSchedule>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BidSchedule.getParser())
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
  public static BidSchedule loadJSON(String json, APIContext context, String header) {
    BidSchedule bidSchedule = getGson().fromJson(json, BidSchedule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(bidSchedule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    bidSchedule.context = context;
    bidSchedule.rawValue = json;
    bidSchedule.header = header;
    return bidSchedule;
  }

  public static APINodeList<BidSchedule> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BidSchedule> bidSchedules = new APINodeList<BidSchedule>(request, json, header);
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
          bidSchedules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return bidSchedules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                bidSchedules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            bidSchedules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              bidSchedules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              bidSchedules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  bidSchedules.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              bidSchedules.add(loadJSON(obj.toString(), context, header));
            }
          }
          return bidSchedules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              bidSchedules.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return bidSchedules;
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
              bidSchedules.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return bidSchedules;
          }

          // Sixth, check if it's pure JsonObject
          bidSchedules.clear();
          bidSchedules.add(loadJSON(json, context, header));
          return bidSchedules;
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


  public String getFieldAdObjectId() {
    return mAdObjectId;
  }

  public String getFieldBidRecurrenceType() {
    return mBidRecurrenceType;
  }

  public String getFieldBidTimezone() {
    return mBidTimezone;
  }

  public Long getFieldBidValue() {
    return mBidValue;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldTimeEnd() {
    return mTimeEnd;
  }

  public String getFieldTimeStart() {
    return mTimeStart;
  }



  public static class APIRequestGet extends APIRequest<BidSchedule> {

    BidSchedule lastResponse = null;
    @Override
    public BidSchedule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_object_id",
      "bid_recurrence_type",
      "bid_timezone",
      "bid_value",
      "id",
      "status",
      "time_end",
      "time_start",
    };

    @Override
    public BidSchedule parseResponse(String response, String header) throws APIException {
      return BidSchedule.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BidSchedule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BidSchedule execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BidSchedule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BidSchedule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BidSchedule>() {
           public BidSchedule apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdObjectIdField () {
      return this.requestAdObjectIdField(true);
    }
    public APIRequestGet requestAdObjectIdField (boolean value) {
      this.requestField("ad_object_id", value);
      return this;
    }
    public APIRequestGet requestBidRecurrenceTypeField () {
      return this.requestBidRecurrenceTypeField(true);
    }
    public APIRequestGet requestBidRecurrenceTypeField (boolean value) {
      this.requestField("bid_recurrence_type", value);
      return this;
    }
    public APIRequestGet requestBidTimezoneField () {
      return this.requestBidTimezoneField(true);
    }
    public APIRequestGet requestBidTimezoneField (boolean value) {
      this.requestField("bid_timezone", value);
      return this;
    }
    public APIRequestGet requestBidValueField () {
      return this.requestBidValueField(true);
    }
    public APIRequestGet requestBidValueField (boolean value) {
      this.requestField("bid_value", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTimeEndField () {
      return this.requestTimeEndField(true);
    }
    public APIRequestGet requestTimeEndField (boolean value) {
      this.requestField("time_end", value);
      return this;
    }
    public APIRequestGet requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGet requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
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

  public BidSchedule copyFrom(BidSchedule instance) {
    this.mAdObjectId = instance.mAdObjectId;
    this.mBidRecurrenceType = instance.mBidRecurrenceType;
    this.mBidTimezone = instance.mBidTimezone;
    this.mBidValue = instance.mBidValue;
    this.mId = instance.mId;
    this.mStatus = instance.mStatus;
    this.mTimeEnd = instance.mTimeEnd;
    this.mTimeStart = instance.mTimeStart;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BidSchedule> getParser() {
    return new APIRequest.ResponseParser<BidSchedule>() {
      public APINodeList<BidSchedule> parseResponse(String response, APIContext context, APIRequest<BidSchedule> request, String header) throws MalformedResponseException {
        return BidSchedule.parseResponse(response, context, request, header);
      }
    };
  }
}
