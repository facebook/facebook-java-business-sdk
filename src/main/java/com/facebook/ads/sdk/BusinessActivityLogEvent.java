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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
public class BusinessActivityLogEvent extends APINode {
  @SerializedName("acted_upon_business_id")
  private String mActedUponBusinessId = null;
  @SerializedName("acted_upon_business_name")
  private String mActedUponBusinessName = null;
  @SerializedName("acted_upon_business_object_id")
  private String mActedUponBusinessObjectId = null;
  @SerializedName("acted_upon_business_object_name")
  private String mActedUponBusinessObjectName = null;
  @SerializedName("acted_upon_business_object_type")
  private String mActedUponBusinessObjectType = null;
  @SerializedName("acted_upon_user_id")
  private String mActedUponUserId = null;
  @SerializedName("acted_upon_user_name")
  private String mActedUponUserName = null;
  @SerializedName("acting_business_id")
  private String mActingBusinessId = null;
  @SerializedName("acting_business_name")
  private String mActingBusinessName = null;
  @SerializedName("acting_user_id")
  private String mActingUserId = null;
  @SerializedName("acting_user_name")
  private String mActingUserName = null;
  @SerializedName("event_time")
  private Long mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("extra_data")
  private List<Object> mExtraData = null;
  @SerializedName("target_business_id")
  private String mTargetBusinessId = null;
  @SerializedName("target_business_name")
  private String mTargetBusinessName = null;
  @SerializedName("target_business_object_id")
  private String mTargetBusinessObjectId = null;
  @SerializedName("target_business_object_name")
  private String mTargetBusinessObjectName = null;
  @SerializedName("target_business_object_type")
  private String mTargetBusinessObjectType = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  BusinessActivityLogEvent() {
  }

  public BusinessActivityLogEvent(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessActivityLogEvent(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessActivityLogEvent fetch() throws APIException{
    BusinessActivityLogEvent newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessActivityLogEvent fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessActivityLogEvent> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessActivityLogEvent fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessActivityLogEvent> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessActivityLogEvent> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessActivityLogEvent>)(
      new APIRequest<BusinessActivityLogEvent>(context, "", "/", "GET", BusinessActivityLogEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessActivityLogEvent>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessActivityLogEvent.getParser())
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
  public static BusinessActivityLogEvent loadJSON(String json, APIContext context) {
    BusinessActivityLogEvent businessActivityLogEvent = getGson().fromJson(json, BusinessActivityLogEvent.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessActivityLogEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    businessActivityLogEvent.context = context;
    businessActivityLogEvent.rawValue = json;
    return businessActivityLogEvent;
  }

  public static APINodeList<BusinessActivityLogEvent> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<BusinessActivityLogEvent> businessActivityLogEvents = new APINodeList<BusinessActivityLogEvent>(request, json);
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
          businessActivityLogEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businessActivityLogEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessActivityLogEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessActivityLogEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessActivityLogEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessActivityLogEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businessActivityLogEvents.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessActivityLogEvents.add(loadJSON(obj.toString(), context));
            }
          }
          return businessActivityLogEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessActivityLogEvents.add(loadJSON(entry.getValue().toString(), context));
          }
          return businessActivityLogEvents;
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
              businessActivityLogEvents.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessActivityLogEvents;
          }

          // Sixth, check if it's pure JsonObject
          businessActivityLogEvents.clear();
          businessActivityLogEvents.add(loadJSON(json, context));
          return businessActivityLogEvents;
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


  public String getFieldActedUponBusinessId() {
    return mActedUponBusinessId;
  }

  public String getFieldActedUponBusinessName() {
    return mActedUponBusinessName;
  }

  public String getFieldActedUponBusinessObjectId() {
    return mActedUponBusinessObjectId;
  }

  public String getFieldActedUponBusinessObjectName() {
    return mActedUponBusinessObjectName;
  }

  public String getFieldActedUponBusinessObjectType() {
    return mActedUponBusinessObjectType;
  }

  public String getFieldActedUponUserId() {
    return mActedUponUserId;
  }

  public String getFieldActedUponUserName() {
    return mActedUponUserName;
  }

  public String getFieldActingBusinessId() {
    return mActingBusinessId;
  }

  public String getFieldActingBusinessName() {
    return mActingBusinessName;
  }

  public String getFieldActingUserId() {
    return mActingUserId;
  }

  public String getFieldActingUserName() {
    return mActingUserName;
  }

  public Long getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public List<Object> getFieldExtraData() {
    return mExtraData;
  }

  public String getFieldTargetBusinessId() {
    return mTargetBusinessId;
  }

  public String getFieldTargetBusinessName() {
    return mTargetBusinessName;
  }

  public String getFieldTargetBusinessObjectId() {
    return mTargetBusinessObjectId;
  }

  public String getFieldTargetBusinessObjectName() {
    return mTargetBusinessObjectName;
  }

  public String getFieldTargetBusinessObjectType() {
    return mTargetBusinessObjectType;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<BusinessActivityLogEvent> {

    BusinessActivityLogEvent lastResponse = null;
    @Override
    public BusinessActivityLogEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "acted_upon_business_id",
      "acted_upon_business_name",
      "acted_upon_business_object_id",
      "acted_upon_business_object_name",
      "acted_upon_business_object_type",
      "acted_upon_user_id",
      "acted_upon_user_name",
      "acting_business_id",
      "acting_business_name",
      "acting_user_id",
      "acting_user_name",
      "event_time",
      "event_type",
      "extra_data",
      "target_business_id",
      "target_business_name",
      "target_business_object_id",
      "target_business_object_name",
      "target_business_object_type",
      "id",
    };

    @Override
    public BusinessActivityLogEvent parseResponse(String response) throws APIException {
      return BusinessActivityLogEvent.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessActivityLogEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessActivityLogEvent execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessActivityLogEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessActivityLogEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessActivityLogEvent>() {
           public BusinessActivityLogEvent apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestActedUponBusinessIdField () {
      return this.requestActedUponBusinessIdField(true);
    }
    public APIRequestGet requestActedUponBusinessIdField (boolean value) {
      this.requestField("acted_upon_business_id", value);
      return this;
    }
    public APIRequestGet requestActedUponBusinessNameField () {
      return this.requestActedUponBusinessNameField(true);
    }
    public APIRequestGet requestActedUponBusinessNameField (boolean value) {
      this.requestField("acted_upon_business_name", value);
      return this;
    }
    public APIRequestGet requestActedUponBusinessObjectIdField () {
      return this.requestActedUponBusinessObjectIdField(true);
    }
    public APIRequestGet requestActedUponBusinessObjectIdField (boolean value) {
      this.requestField("acted_upon_business_object_id", value);
      return this;
    }
    public APIRequestGet requestActedUponBusinessObjectNameField () {
      return this.requestActedUponBusinessObjectNameField(true);
    }
    public APIRequestGet requestActedUponBusinessObjectNameField (boolean value) {
      this.requestField("acted_upon_business_object_name", value);
      return this;
    }
    public APIRequestGet requestActedUponBusinessObjectTypeField () {
      return this.requestActedUponBusinessObjectTypeField(true);
    }
    public APIRequestGet requestActedUponBusinessObjectTypeField (boolean value) {
      this.requestField("acted_upon_business_object_type", value);
      return this;
    }
    public APIRequestGet requestActedUponUserIdField () {
      return this.requestActedUponUserIdField(true);
    }
    public APIRequestGet requestActedUponUserIdField (boolean value) {
      this.requestField("acted_upon_user_id", value);
      return this;
    }
    public APIRequestGet requestActedUponUserNameField () {
      return this.requestActedUponUserNameField(true);
    }
    public APIRequestGet requestActedUponUserNameField (boolean value) {
      this.requestField("acted_upon_user_name", value);
      return this;
    }
    public APIRequestGet requestActingBusinessIdField () {
      return this.requestActingBusinessIdField(true);
    }
    public APIRequestGet requestActingBusinessIdField (boolean value) {
      this.requestField("acting_business_id", value);
      return this;
    }
    public APIRequestGet requestActingBusinessNameField () {
      return this.requestActingBusinessNameField(true);
    }
    public APIRequestGet requestActingBusinessNameField (boolean value) {
      this.requestField("acting_business_name", value);
      return this;
    }
    public APIRequestGet requestActingUserIdField () {
      return this.requestActingUserIdField(true);
    }
    public APIRequestGet requestActingUserIdField (boolean value) {
      this.requestField("acting_user_id", value);
      return this;
    }
    public APIRequestGet requestActingUserNameField () {
      return this.requestActingUserNameField(true);
    }
    public APIRequestGet requestActingUserNameField (boolean value) {
      this.requestField("acting_user_name", value);
      return this;
    }
    public APIRequestGet requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGet requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGet requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGet requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGet requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGet requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGet requestTargetBusinessIdField () {
      return this.requestTargetBusinessIdField(true);
    }
    public APIRequestGet requestTargetBusinessIdField (boolean value) {
      this.requestField("target_business_id", value);
      return this;
    }
    public APIRequestGet requestTargetBusinessNameField () {
      return this.requestTargetBusinessNameField(true);
    }
    public APIRequestGet requestTargetBusinessNameField (boolean value) {
      this.requestField("target_business_name", value);
      return this;
    }
    public APIRequestGet requestTargetBusinessObjectIdField () {
      return this.requestTargetBusinessObjectIdField(true);
    }
    public APIRequestGet requestTargetBusinessObjectIdField (boolean value) {
      this.requestField("target_business_object_id", value);
      return this;
    }
    public APIRequestGet requestTargetBusinessObjectNameField () {
      return this.requestTargetBusinessObjectNameField(true);
    }
    public APIRequestGet requestTargetBusinessObjectNameField (boolean value) {
      this.requestField("target_business_object_name", value);
      return this;
    }
    public APIRequestGet requestTargetBusinessObjectTypeField () {
      return this.requestTargetBusinessObjectTypeField(true);
    }
    public APIRequestGet requestTargetBusinessObjectTypeField (boolean value) {
      this.requestField("target_business_object_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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

  public BusinessActivityLogEvent copyFrom(BusinessActivityLogEvent instance) {
    this.mActedUponBusinessId = instance.mActedUponBusinessId;
    this.mActedUponBusinessName = instance.mActedUponBusinessName;
    this.mActedUponBusinessObjectId = instance.mActedUponBusinessObjectId;
    this.mActedUponBusinessObjectName = instance.mActedUponBusinessObjectName;
    this.mActedUponBusinessObjectType = instance.mActedUponBusinessObjectType;
    this.mActedUponUserId = instance.mActedUponUserId;
    this.mActedUponUserName = instance.mActedUponUserName;
    this.mActingBusinessId = instance.mActingBusinessId;
    this.mActingBusinessName = instance.mActingBusinessName;
    this.mActingUserId = instance.mActingUserId;
    this.mActingUserName = instance.mActingUserName;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mExtraData = instance.mExtraData;
    this.mTargetBusinessId = instance.mTargetBusinessId;
    this.mTargetBusinessName = instance.mTargetBusinessName;
    this.mTargetBusinessObjectId = instance.mTargetBusinessObjectId;
    this.mTargetBusinessObjectName = instance.mTargetBusinessObjectName;
    this.mTargetBusinessObjectType = instance.mTargetBusinessObjectType;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessActivityLogEvent> getParser() {
    return new APIRequest.ResponseParser<BusinessActivityLogEvent>() {
      public APINodeList<BusinessActivityLogEvent> parseResponse(String response, APIContext context, APIRequest<BusinessActivityLogEvent> request) throws MalformedResponseException {
        return BusinessActivityLogEvent.parseResponse(response, context, request);
      }
    };
  }
}
