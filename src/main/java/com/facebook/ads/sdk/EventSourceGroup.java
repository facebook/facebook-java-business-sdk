/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class EventSourceGroup extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("event_sources")
  private List<ExternalEventSource> mEventSources = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  EventSourceGroup() {
  }

  public EventSourceGroup(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public EventSourceGroup(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public EventSourceGroup fetch() throws APIException{
    EventSourceGroup newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static EventSourceGroup fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static EventSourceGroup fetchById(String id, APIContext context) throws APIException {
    EventSourceGroup eventSourceGroup =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return eventSourceGroup;
  }

  public static APINodeList<EventSourceGroup> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<EventSourceGroup>)(
      new APIRequest<EventSourceGroup>(context, "", "/", "GET", EventSourceGroup.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static EventSourceGroup loadJSON(String json, APIContext context) {
    EventSourceGroup eventSourceGroup = getGson().fromJson(json, EventSourceGroup.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(eventSourceGroup.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    eventSourceGroup.context = context;
    eventSourceGroup.rawValue = json;
    return eventSourceGroup;
  }

  public static APINodeList<EventSourceGroup> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<EventSourceGroup> eventSourceGroups = new APINodeList<EventSourceGroup>(request, json);
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
          eventSourceGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return eventSourceGroups;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            eventSourceGroups.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              eventSourceGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  eventSourceGroups.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              eventSourceGroups.add(loadJSON(obj.toString(), context));
            }
          }
          return eventSourceGroups;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              eventSourceGroups.add(loadJSON(entry.getValue().toString(), context));
          }
          return eventSourceGroups;
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
              eventSourceGroups.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return eventSourceGroups;
          }

          // Sixth, check if it's pure JsonObject
          eventSourceGroups.clear();
          eventSourceGroups.add(loadJSON(json, context));
          return eventSourceGroups;
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

  public APIRequestCreateSharedAccount createSharedAccount() {
    return new APIRequestCreateSharedAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public List<ExternalEventSource> getFieldEventSources() {
    return mEventSources;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestCreateSharedAccount extends APIRequest<EventSourceGroup> {

    EventSourceGroup lastResponse = null;
    @Override
    public EventSourceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "accounts",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public EventSourceGroup parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateSharedAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSharedAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSharedAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSharedAccount setAccounts (List<String> accounts) {
      this.setParam("accounts", accounts);
      return this;
    }
    public APIRequestCreateSharedAccount setAccounts (String accounts) {
      this.setParam("accounts", accounts);
      return this;
    }

    public APIRequestCreateSharedAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSharedAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSharedAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSharedAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSharedAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSharedAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<EventSourceGroup> {

    EventSourceGroup lastResponse = null;
    @Override
    public EventSourceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "event_sources",
      "id",
      "name",
    };

    @Override
    public EventSourceGroup parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestEventSourcesField () {
      return this.requestEventSourcesField(true);
    }
    public APIRequestGet requestEventSourcesField (boolean value) {
      this.requestField("event_sources", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<EventSourceGroup> {

    EventSourceGroup lastResponse = null;
    @Override
    public EventSourceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "event_sources",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public EventSourceGroup parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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


    public APIRequestUpdate setEventSources (List<String> eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }
    public APIRequestUpdate setEventSources (String eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public EventSourceGroup copyFrom(EventSourceGroup instance) {
    this.mBusiness = instance.mBusiness;
    this.mEventSources = instance.mEventSources;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<EventSourceGroup> getParser() {
    return new APIRequest.ResponseParser<EventSourceGroup>() {
      public APINodeList<EventSourceGroup> parseResponse(String response, APIContext context, APIRequest<EventSourceGroup> request) throws MalformedResponseException {
        return EventSourceGroup.parseResponse(response, context, request);
      }
    };
  }
}
