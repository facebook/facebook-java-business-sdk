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
public class IGUpcomingEvent extends APINode {
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("notification_subtypes")
  private List<String> mNotificationSubtypes = null;
  @SerializedName("notification_target_time")
  private String mNotificationTargetTime = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  IGUpcomingEvent() {
  }

  public IGUpcomingEvent(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUpcomingEvent(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUpcomingEvent fetch() throws APIException{
    IGUpcomingEvent newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUpcomingEvent fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUpcomingEvent> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUpcomingEvent fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUpcomingEvent> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUpcomingEvent> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUpcomingEvent>)(
      new APIRequest<IGUpcomingEvent>(context, "", "/", "GET", IGUpcomingEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUpcomingEvent>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUpcomingEvent.getParser())
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
  public static IGUpcomingEvent loadJSON(String json, APIContext context, String header) {
    IGUpcomingEvent igUpcomingEvent = getGson().fromJson(json, IGUpcomingEvent.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUpcomingEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUpcomingEvent.context = context;
    igUpcomingEvent.rawValue = json;
    igUpcomingEvent.header = header;
    return igUpcomingEvent;
  }

  public static APINodeList<IGUpcomingEvent> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUpcomingEvent> igUpcomingEvents = new APINodeList<IGUpcomingEvent>(request, json, header);
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
          igUpcomingEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUpcomingEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUpcomingEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUpcomingEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUpcomingEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUpcomingEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUpcomingEvents.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUpcomingEvents.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUpcomingEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUpcomingEvents.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUpcomingEvents;
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
              igUpcomingEvents.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUpcomingEvents;
          }

          // Sixth, check if it's pure JsonObject
          igUpcomingEvents.clear();
          igUpcomingEvents.add(loadJSON(json, context, header));
          return igUpcomingEvents;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldNotificationSubtypes() {
    return mNotificationSubtypes;
  }

  public String getFieldNotificationTargetTime() {
    return mNotificationTargetTime;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldTitle() {
    return mTitle;
  }



  public static class APIRequestGet extends APIRequest<IGUpcomingEvent> {

    IGUpcomingEvent lastResponse = null;
    @Override
    public IGUpcomingEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "end_time",
      "id",
      "notification_subtypes",
      "notification_target_time",
      "start_time",
      "title",
    };

    @Override
    public IGUpcomingEvent parseResponse(String response, String header) throws APIException {
      return IGUpcomingEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUpcomingEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUpcomingEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUpcomingEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUpcomingEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUpcomingEvent>() {
           public IGUpcomingEvent apply(ResponseWrapper result) {
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

    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNotificationSubtypesField () {
      return this.requestNotificationSubtypesField(true);
    }
    public APIRequestGet requestNotificationSubtypesField (boolean value) {
      this.requestField("notification_subtypes", value);
      return this;
    }
    public APIRequestGet requestNotificationTargetTimeField () {
      return this.requestNotificationTargetTimeField(true);
    }
    public APIRequestGet requestNotificationTargetTimeField (boolean value) {
      this.requestField("notification_target_time", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<IGUpcomingEvent> {

    IGUpcomingEvent lastResponse = null;
    @Override
    public IGUpcomingEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "notification_subtypes",
      "notification_target_time",
      "start_time",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGUpcomingEvent parseResponse(String response, String header) throws APIException {
      return IGUpcomingEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUpcomingEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUpcomingEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUpcomingEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUpcomingEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUpcomingEvent>() {
           public IGUpcomingEvent apply(ResponseWrapper result) {
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


    public APIRequestUpdate setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestUpdate setNotificationSubtypes (List<IGUpcomingEvent.EnumNotificationSubtypes> notificationSubtypes) {
      this.setParam("notification_subtypes", notificationSubtypes);
      return this;
    }
    public APIRequestUpdate setNotificationSubtypes (String notificationSubtypes) {
      this.setParam("notification_subtypes", notificationSubtypes);
      return this;
    }

    public APIRequestUpdate setNotificationTargetTime (IGUpcomingEvent.EnumNotificationTargetTime notificationTargetTime) {
      this.setParam("notification_target_time", notificationTargetTime);
      return this;
    }
    public APIRequestUpdate setNotificationTargetTime (String notificationTargetTime) {
      this.setParam("notification_target_time", notificationTargetTime);
      return this;
    }

    public APIRequestUpdate setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumNotificationSubtypes {
      @SerializedName("AFTER_EVENT_1DAY")
      VALUE_AFTER_EVENT_1DAY("AFTER_EVENT_1DAY"),
      @SerializedName("AFTER_EVENT_2DAY")
      VALUE_AFTER_EVENT_2DAY("AFTER_EVENT_2DAY"),
      @SerializedName("AFTER_EVENT_3DAY")
      VALUE_AFTER_EVENT_3DAY("AFTER_EVENT_3DAY"),
      @SerializedName("AFTER_EVENT_4DAY")
      VALUE_AFTER_EVENT_4DAY("AFTER_EVENT_4DAY"),
      @SerializedName("AFTER_EVENT_5DAY")
      VALUE_AFTER_EVENT_5DAY("AFTER_EVENT_5DAY"),
      @SerializedName("AFTER_EVENT_6DAY")
      VALUE_AFTER_EVENT_6DAY("AFTER_EVENT_6DAY"),
      @SerializedName("AFTER_EVENT_7DAY")
      VALUE_AFTER_EVENT_7DAY("AFTER_EVENT_7DAY"),
      @SerializedName("BEFORE_EVENT_15MIN")
      VALUE_BEFORE_EVENT_15MIN("BEFORE_EVENT_15MIN"),
      @SerializedName("BEFORE_EVENT_1DAY")
      VALUE_BEFORE_EVENT_1DAY("BEFORE_EVENT_1DAY"),
      @SerializedName("BEFORE_EVENT_1HOUR")
      VALUE_BEFORE_EVENT_1HOUR("BEFORE_EVENT_1HOUR"),
      @SerializedName("BEFORE_EVENT_2DAY")
      VALUE_BEFORE_EVENT_2DAY("BEFORE_EVENT_2DAY"),
      @SerializedName("EVENT_START")
      VALUE_EVENT_START("EVENT_START"),
      @SerializedName("RESCHEDULED")
      VALUE_RESCHEDULED("RESCHEDULED"),
      ;

      private String value;

      private EnumNotificationSubtypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumNotificationTargetTime {
      @SerializedName("EVENT_END")
      VALUE_EVENT_END("EVENT_END"),
      @SerializedName("EVENT_START")
      VALUE_EVENT_START("EVENT_START"),
      ;

      private String value;

      private EnumNotificationTargetTime(String value) {
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

  public IGUpcomingEvent copyFrom(IGUpcomingEvent instance) {
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mNotificationSubtypes = instance.mNotificationSubtypes;
    this.mNotificationTargetTime = instance.mNotificationTargetTime;
    this.mStartTime = instance.mStartTime;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUpcomingEvent> getParser() {
    return new APIRequest.ResponseParser<IGUpcomingEvent>() {
      public APINodeList<IGUpcomingEvent> parseResponse(String response, APIContext context, APIRequest<IGUpcomingEvent> request, String header) throws MalformedResponseException {
        return IGUpcomingEvent.parseResponse(response, context, request, header);
      }
    };
  }
}
