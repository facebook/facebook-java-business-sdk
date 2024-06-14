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
public class EventTour extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("dominant_color")
  private String mDominantColor = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_past")
  private Boolean mIsPast = null;
  @SerializedName("last_event_timestamp")
  private Long mLastEventTimestamp = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("num_events")
  private Long mNumEvents = null;
  @SerializedName("photo")
  private Photo mPhoto = null;
  @SerializedName("scheduled_publish_timestamp")
  private Long mScheduledPublishTimestamp = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("ticketing_uri")
  private String mTicketingUri = null;
  @SerializedName("video")
  private AdVideo mVideo = null;
  protected static Gson gson = null;

  EventTour() {
  }

  public EventTour(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public EventTour(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public EventTour fetch() throws APIException{
    EventTour newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static EventTour fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<EventTour> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static EventTour fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<EventTour> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<EventTour> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<EventTour>)(
      new APIRequest<EventTour>(context, "", "/", "GET", EventTour.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<EventTour>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", EventTour.getParser())
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
  public static EventTour loadJSON(String json, APIContext context, String header) {
    EventTour eventTour = getGson().fromJson(json, EventTour.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(eventTour.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    eventTour.context = context;
    eventTour.rawValue = json;
    eventTour.header = header;
    return eventTour;
  }

  public static APINodeList<EventTour> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<EventTour> eventTours = new APINodeList<EventTour>(request, json, header);
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
          eventTours.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return eventTours;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                eventTours.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            eventTours.setPaging(previous, next);
            if (context.hasAppSecret()) {
              eventTours.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              eventTours.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  eventTours.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              eventTours.add(loadJSON(obj.toString(), context, header));
            }
          }
          return eventTours;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              eventTours.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return eventTours;
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
              eventTours.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return eventTours;
          }

          // Sixth, check if it's pure JsonObject
          eventTours.clear();
          eventTours.add(loadJSON(json, context, header));
          return eventTours;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDominantColor() {
    return mDominantColor;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPast() {
    return mIsPast;
  }

  public Long getFieldLastEventTimestamp() {
    return mLastEventTimestamp;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldNumEvents() {
    return mNumEvents;
  }

  public Photo getFieldPhoto() {
    if (mPhoto != null) {
      mPhoto.context = getContext();
    }
    return mPhoto;
  }

  public Long getFieldScheduledPublishTimestamp() {
    return mScheduledPublishTimestamp;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldTicketingUri() {
    return mTicketingUri;
  }

  public AdVideo getFieldVideo() {
    if (mVideo != null) {
      mVideo.context = getContext();
    }
    return mVideo;
  }



  public static class APIRequestGet extends APIRequest<EventTour> {

    EventTour lastResponse = null;
    @Override
    public EventTour getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "dominant_color",
      "end_time",
      "id",
      "is_past",
      "last_event_timestamp",
      "name",
      "num_events",
      "photo",
      "scheduled_publish_timestamp",
      "start_time",
      "ticketing_uri",
      "video",
    };

    @Override
    public EventTour parseResponse(String response, String header) throws APIException {
      return EventTour.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public EventTour execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventTour execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<EventTour> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventTour> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, EventTour>() {
           public EventTour apply(ResponseWrapper result) {
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

    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDominantColorField () {
      return this.requestDominantColorField(true);
    }
    public APIRequestGet requestDominantColorField (boolean value) {
      this.requestField("dominant_color", value);
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
    public APIRequestGet requestIsPastField () {
      return this.requestIsPastField(true);
    }
    public APIRequestGet requestIsPastField (boolean value) {
      this.requestField("is_past", value);
      return this;
    }
    public APIRequestGet requestLastEventTimestampField () {
      return this.requestLastEventTimestampField(true);
    }
    public APIRequestGet requestLastEventTimestampField (boolean value) {
      this.requestField("last_event_timestamp", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNumEventsField () {
      return this.requestNumEventsField(true);
    }
    public APIRequestGet requestNumEventsField (boolean value) {
      this.requestField("num_events", value);
      return this;
    }
    public APIRequestGet requestPhotoField () {
      return this.requestPhotoField(true);
    }
    public APIRequestGet requestPhotoField (boolean value) {
      this.requestField("photo", value);
      return this;
    }
    public APIRequestGet requestScheduledPublishTimestampField () {
      return this.requestScheduledPublishTimestampField(true);
    }
    public APIRequestGet requestScheduledPublishTimestampField (boolean value) {
      this.requestField("scheduled_publish_timestamp", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTicketingUriField () {
      return this.requestTicketingUriField(true);
    }
    public APIRequestGet requestTicketingUriField (boolean value) {
      this.requestField("ticketing_uri", value);
      return this;
    }
    public APIRequestGet requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGet requestVideoField (boolean value) {
      this.requestField("video", value);
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

  public EventTour copyFrom(EventTour instance) {
    this.mDescription = instance.mDescription;
    this.mDominantColor = instance.mDominantColor;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mIsPast = instance.mIsPast;
    this.mLastEventTimestamp = instance.mLastEventTimestamp;
    this.mName = instance.mName;
    this.mNumEvents = instance.mNumEvents;
    this.mPhoto = instance.mPhoto;
    this.mScheduledPublishTimestamp = instance.mScheduledPublishTimestamp;
    this.mStartTime = instance.mStartTime;
    this.mTicketingUri = instance.mTicketingUri;
    this.mVideo = instance.mVideo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<EventTour> getParser() {
    return new APIRequest.ResponseParser<EventTour>() {
      public APINodeList<EventTour> parseResponse(String response, APIContext context, APIRequest<EventTour> request, String header) throws MalformedResponseException {
        return EventTour.parseResponse(response, context, request, header);
      }
    };
  }
}
