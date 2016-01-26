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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdAsyncRequestSet extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("owner_id")
  private String mOwnerId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("notification_mode")
  private EnumNotificationMode mNotificationMode = null;
  @SerializedName("notification_uri")
  private String mNotificationUri = null;
  @SerializedName("total_count")
  private Long mTotalCount = null;
  @SerializedName("initial_count")
  private Long mInitialCount = null;
  @SerializedName("in_progress_count")
  private Long mInProgressCount = null;
  @SerializedName("success_count")
  private Long mSuccessCount = null;
  @SerializedName("error_count")
  private Long mErrorCount = null;
  @SerializedName("canceled_count")
  private Long mCanceledCount = null;
  @SerializedName("is_completed")
  private Boolean mIsCompleted = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("notification_status")
  private EnumNotificationStatus mNotificationStatus = null;
  @SerializedName("notification_result")
  private AdAsyncRequestSetNotificationResult mNotificationResult = null;
  protected static Gson gson = null;

  AdAsyncRequestSet() {
  }

  public AdAsyncRequestSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAsyncRequestSet(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdAsyncRequestSet fetch() throws APIException{
    AdAsyncRequestSet newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAsyncRequestSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdAsyncRequestSet fetchById(String id, APIContext context) throws APIException {
    AdAsyncRequestSet adAsyncRequestSet =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adAsyncRequestSet;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAsyncRequestSet loadJSON(String json, APIContext context) {
    AdAsyncRequestSet adAsyncRequestSet = getGson().fromJson(json, AdAsyncRequestSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAsyncRequestSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAsyncRequestSet.mContext = context;
    adAsyncRequestSet.rawValue = json;
    return adAsyncRequestSet;
  }

  public static APINodeList<AdAsyncRequestSet> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdAsyncRequestSet> adAsyncRequestSets = new APINodeList<AdAsyncRequestSet>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adAsyncRequestSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAsyncRequestSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adAsyncRequestSets.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAsyncRequestSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adAsyncRequestSets.add(loadJSON(obj.toString(), context));
          }
          return adAsyncRequestSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAsyncRequestSets.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAsyncRequestSets;
        } else {
          // Fifth, check if it's pure JsonObject
          adAsyncRequestSets.add(loadJSON(json, context));
          return adAsyncRequestSets;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetRequests getRequests() {
    return new APIRequestGetRequests(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldOwnerId() {
    return mOwnerId;
  }

  public String getFieldName() {
    return mName;
  }

  public EnumNotificationMode getFieldNotificationMode() {
    return mNotificationMode;
  }

  public String getFieldNotificationUri() {
    return mNotificationUri;
  }

  public Long getFieldTotalCount() {
    return mTotalCount;
  }

  public Long getFieldInitialCount() {
    return mInitialCount;
  }

  public Long getFieldInProgressCount() {
    return mInProgressCount;
  }

  public Long getFieldSuccessCount() {
    return mSuccessCount;
  }

  public Long getFieldErrorCount() {
    return mErrorCount;
  }

  public Long getFieldCanceledCount() {
    return mCanceledCount;
  }

  public Boolean getFieldIsCompleted() {
    return mIsCompleted;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public EnumNotificationStatus getFieldNotificationStatus() {
    return mNotificationStatus;
  }

  public AdAsyncRequestSetNotificationResult getFieldNotificationResult() {
    return mNotificationResult;
  }



  public static class APIRequestGet extends APIRequest<AdAsyncRequestSet> {

    AdAsyncRequestSet lastResponse = null;
    @Override
    public AdAsyncRequestSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "owner_id",
      "name",
      "notification_mode",
      "notification_uri",
      "total_count",
      "initial_count",
      "in_progress_count",
      "success_count",
      "error_count",
      "canceled_count",
      "is_completed",
      "created_time",
      "updated_time",
      "notification_status",
      "notification_result",
    };

    @Override
    public AdAsyncRequestSet parseResponse(String response) throws APIException {
      return AdAsyncRequestSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAsyncRequestSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequestSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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
    public APIRequestGet requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGet requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNotificationModeField () {
      return this.requestNotificationModeField(true);
    }
    public APIRequestGet requestNotificationModeField (boolean value) {
      this.requestField("notification_mode", value);
      return this;
    }
    public APIRequestGet requestNotificationUriField () {
      return this.requestNotificationUriField(true);
    }
    public APIRequestGet requestNotificationUriField (boolean value) {
      this.requestField("notification_uri", value);
      return this;
    }
    public APIRequestGet requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGet requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
    public APIRequestGet requestInitialCountField () {
      return this.requestInitialCountField(true);
    }
    public APIRequestGet requestInitialCountField (boolean value) {
      this.requestField("initial_count", value);
      return this;
    }
    public APIRequestGet requestInProgressCountField () {
      return this.requestInProgressCountField(true);
    }
    public APIRequestGet requestInProgressCountField (boolean value) {
      this.requestField("in_progress_count", value);
      return this;
    }
    public APIRequestGet requestSuccessCountField () {
      return this.requestSuccessCountField(true);
    }
    public APIRequestGet requestSuccessCountField (boolean value) {
      this.requestField("success_count", value);
      return this;
    }
    public APIRequestGet requestErrorCountField () {
      return this.requestErrorCountField(true);
    }
    public APIRequestGet requestErrorCountField (boolean value) {
      this.requestField("error_count", value);
      return this;
    }
    public APIRequestGet requestCanceledCountField () {
      return this.requestCanceledCountField(true);
    }
    public APIRequestGet requestCanceledCountField (boolean value) {
      this.requestField("canceled_count", value);
      return this;
    }
    public APIRequestGet requestIsCompletedField () {
      return this.requestIsCompletedField(true);
    }
    public APIRequestGet requestIsCompletedField (boolean value) {
      this.requestField("is_completed", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestNotificationStatusField () {
      return this.requestNotificationStatusField(true);
    }
    public APIRequestGet requestNotificationStatusField (boolean value) {
      this.requestField("notification_status", value);
      return this;
    }
    public APIRequestGet requestNotificationResultField () {
      return this.requestNotificationResultField(true);
    }
    public APIRequestGet requestNotificationResultField (boolean value) {
      this.requestField("notification_result", value);
      return this;
    }

  }

  public static class APIRequestGetRequests extends APIRequest<AdAsyncRequest> {

    APINodeList<AdAsyncRequest> lastResponse = null;
    @Override
    public APINodeList<AdAsyncRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "statuses",
    };

    public static final String[] FIELDS = {
      "id",
      "scope_object_id",
      "status",
      "result",
      "input",
      "async_request_set",
      "created_time",
      "updated_time",
    };

    @Override
    public APINodeList<AdAsyncRequest> parseResponse(String response) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAsyncRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAsyncRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/requests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRequests setStatuses (List<EnumStatuses> statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetRequests setStatuses (String statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRequests requestScopeObjectIdField () {
      return this.requestScopeObjectIdField(true);
    }
    public APIRequestGetRequests requestScopeObjectIdField (boolean value) {
      this.requestField("scope_object_id", value);
      return this;
    }
    public APIRequestGetRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetRequests requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetRequests requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGetRequests requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGetRequests requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGetRequests requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGetRequests requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGetRequests requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetRequests requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetRequests requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetRequests requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }

  }

  public static enum EnumStatuses {
    @SerializedName("INITIAL")
    VALUE_INITIAL("INITIAL"),
    @SerializedName("IN_PROGRESS")
    VALUE_IN_PROGRESS("IN_PROGRESS"),
    @SerializedName("SUCCESS")
    VALUE_SUCCESS("SUCCESS"),
    @SerializedName("ERROR")
    VALUE_ERROR("ERROR"),
    @SerializedName("CANCELED")
    VALUE_CANCELED("CANCELED"),
    @SerializedName("PENDING_DEPENDENCY")
    VALUE_PENDING_DEPENDENCY("PENDING_DEPENDENCY"),
    @SerializedName("CANCELED_DEPENDENCY")
    VALUE_CANCELED_DEPENDENCY("CANCELED_DEPENDENCY"),
    @SerializedName("ERROR_DEPENDENCY")
    VALUE_ERROR_DEPENDENCY("ERROR_DEPENDENCY"),
    @SerializedName("ERROR_CONFLICTS")
    VALUE_ERROR_CONFLICTS("ERROR_CONFLICTS"),
    NULL(null);

    private String value;

    private EnumStatuses(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumNotificationMode {
    @SerializedName("OFF")
    VALUE_OFF("OFF"),
    @SerializedName("ON_COMPLETE")
    VALUE_ON_COMPLETE("ON_COMPLETE"),
    NULL(null);

    private String value;

    private EnumNotificationMode(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumNotificationStatus {
    @SerializedName("NOT_SENT")
    VALUE_NOT_SENT("NOT_SENT"),
    @SerializedName("SENDING")
    VALUE_SENDING("SENDING"),
    @SerializedName("SENT")
    VALUE_SENT("SENT"),
    NULL(null);

    private String value;

    private EnumNotificationStatus(String value) {
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

  public AdAsyncRequestSet copyFrom(AdAsyncRequestSet instance) {
    this.mId = instance.mId;
    this.mOwnerId = instance.mOwnerId;
    this.mName = instance.mName;
    this.mNotificationMode = instance.mNotificationMode;
    this.mNotificationUri = instance.mNotificationUri;
    this.mTotalCount = instance.mTotalCount;
    this.mInitialCount = instance.mInitialCount;
    this.mInProgressCount = instance.mInProgressCount;
    this.mSuccessCount = instance.mSuccessCount;
    this.mErrorCount = instance.mErrorCount;
    this.mCanceledCount = instance.mCanceledCount;
    this.mIsCompleted = instance.mIsCompleted;
    this.mCreatedTime = instance.mCreatedTime;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mNotificationStatus = instance.mNotificationStatus;
    this.mNotificationResult = instance.mNotificationResult;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAsyncRequestSet> getParser() {
    return new APIRequest.ResponseParser<AdAsyncRequestSet>() {
      public APINodeList<AdAsyncRequestSet> parseResponse(String response, APIContext context, APIRequest<AdAsyncRequestSet> request) {
        return AdAsyncRequestSet.parseResponse(response, context, request);
      }
    };
  }
}