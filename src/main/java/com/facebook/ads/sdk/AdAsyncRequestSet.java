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
public class AdAsyncRequestSet extends APINode {
  @SerializedName("canceled_count")
  private Long mCanceledCount = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("error_count")
  private Long mErrorCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("in_progress_count")
  private Long mInProgressCount = null;
  @SerializedName("initial_count")
  private Long mInitialCount = null;
  @SerializedName("is_completed")
  private Boolean mIsCompleted = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("notification_mode")
  private EnumNotificationMode mNotificationMode = null;
  @SerializedName("notification_result")
  private AdAsyncRequestSetNotificationResult mNotificationResult = null;
  @SerializedName("notification_status")
  private String mNotificationStatus = null;
  @SerializedName("notification_uri")
  private String mNotificationUri = null;
  @SerializedName("owner_id")
  private String mOwnerId = null;
  @SerializedName("success_count")
  private Long mSuccessCount = null;
  @SerializedName("total_count")
  private Long mTotalCount = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdAsyncRequestSet() {
  }

  public AdAsyncRequestSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAsyncRequestSet(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAsyncRequestSet fetch() throws APIException{
    AdAsyncRequestSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAsyncRequestSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAsyncRequestSet> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAsyncRequestSet fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAsyncRequestSet> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAsyncRequestSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAsyncRequestSet>)(
      new APIRequest<AdAsyncRequestSet>(context, "", "/", "GET", AdAsyncRequestSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAsyncRequestSet>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAsyncRequestSet.getParser())
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
  public static AdAsyncRequestSet loadJSON(String json, APIContext context, String header) {
    AdAsyncRequestSet adAsyncRequestSet = getGson().fromJson(json, AdAsyncRequestSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAsyncRequestSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAsyncRequestSet.context = context;
    adAsyncRequestSet.rawValue = json;
    adAsyncRequestSet.header = header;
    return adAsyncRequestSet;
  }

  public static APINodeList<AdAsyncRequestSet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAsyncRequestSet> adAsyncRequestSets = new APINodeList<AdAsyncRequestSet>(request, json, header);
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
          adAsyncRequestSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAsyncRequestSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAsyncRequestSets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAsyncRequestSets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAsyncRequestSets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAsyncRequestSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAsyncRequestSets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAsyncRequestSets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAsyncRequestSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAsyncRequestSets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAsyncRequestSets;
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
              adAsyncRequestSets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAsyncRequestSets;
          }

          // Sixth, check if it's pure JsonObject
          adAsyncRequestSets.clear();
          adAsyncRequestSets.add(loadJSON(json, context, header));
          return adAsyncRequestSets;
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

  public APIRequestGetRequests getRequests() {
    return new APIRequestGetRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Long getFieldCanceledCount() {
    return mCanceledCount;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Long getFieldErrorCount() {
    return mErrorCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldInProgressCount() {
    return mInProgressCount;
  }

  public Long getFieldInitialCount() {
    return mInitialCount;
  }

  public Boolean getFieldIsCompleted() {
    return mIsCompleted;
  }

  public String getFieldName() {
    return mName;
  }

  public EnumNotificationMode getFieldNotificationMode() {
    return mNotificationMode;
  }

  public AdAsyncRequestSetNotificationResult getFieldNotificationResult() {
    return mNotificationResult;
  }

  public String getFieldNotificationStatus() {
    return mNotificationStatus;
  }

  public String getFieldNotificationUri() {
    return mNotificationUri;
  }

  public String getFieldOwnerId() {
    return mOwnerId;
  }

  public Long getFieldSuccessCount() {
    return mSuccessCount;
  }

  public Long getFieldTotalCount() {
    return mTotalCount;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
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
      "async_request_set",
      "created_time",
      "id",
      "input",
      "result",
      "scope_object_id",
      "status",
      "type",
      "updated_time",
    };

    @Override
    public APINodeList<AdAsyncRequest> parseResponse(String response, String header) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdAsyncRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAsyncRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAsyncRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAsyncRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdAsyncRequest>>() {
           public APINodeList<AdAsyncRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/requests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRequests setStatuses (List<AdAsyncRequest.EnumStatuses> statuses) {
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

    @Override
    public APIRequestGetRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRequests requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGetRequests requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGetRequests requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetRequests requestResultField (boolean value) {
      this.requestField("result", value);
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
    public APIRequestGetRequests requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetRequests requestTypeField (boolean value) {
      this.requestField("type", value);
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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

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
      "canceled_count",
      "created_time",
      "error_count",
      "id",
      "in_progress_count",
      "initial_count",
      "is_completed",
      "name",
      "notification_mode",
      "notification_result",
      "notification_status",
      "notification_uri",
      "owner_id",
      "success_count",
      "total_count",
      "updated_time",
    };

    @Override
    public AdAsyncRequestSet parseResponse(String response, String header) throws APIException {
      return AdAsyncRequestSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAsyncRequestSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequestSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAsyncRequestSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAsyncRequestSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAsyncRequestSet>() {
           public AdAsyncRequestSet apply(ResponseWrapper result) {
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

    public APIRequestGet requestCanceledCountField () {
      return this.requestCanceledCountField(true);
    }
    public APIRequestGet requestCanceledCountField (boolean value) {
      this.requestField("canceled_count", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestErrorCountField () {
      return this.requestErrorCountField(true);
    }
    public APIRequestGet requestErrorCountField (boolean value) {
      this.requestField("error_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInProgressCountField () {
      return this.requestInProgressCountField(true);
    }
    public APIRequestGet requestInProgressCountField (boolean value) {
      this.requestField("in_progress_count", value);
      return this;
    }
    public APIRequestGet requestInitialCountField () {
      return this.requestInitialCountField(true);
    }
    public APIRequestGet requestInitialCountField (boolean value) {
      this.requestField("initial_count", value);
      return this;
    }
    public APIRequestGet requestIsCompletedField () {
      return this.requestIsCompletedField(true);
    }
    public APIRequestGet requestIsCompletedField (boolean value) {
      this.requestField("is_completed", value);
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
    public APIRequestGet requestNotificationResultField () {
      return this.requestNotificationResultField(true);
    }
    public APIRequestGet requestNotificationResultField (boolean value) {
      this.requestField("notification_result", value);
      return this;
    }
    public APIRequestGet requestNotificationStatusField () {
      return this.requestNotificationStatusField(true);
    }
    public APIRequestGet requestNotificationStatusField (boolean value) {
      this.requestField("notification_status", value);
      return this;
    }
    public APIRequestGet requestNotificationUriField () {
      return this.requestNotificationUriField(true);
    }
    public APIRequestGet requestNotificationUriField (boolean value) {
      this.requestField("notification_uri", value);
      return this;
    }
    public APIRequestGet requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGet requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGet requestSuccessCountField () {
      return this.requestSuccessCountField(true);
    }
    public APIRequestGet requestSuccessCountField (boolean value) {
      this.requestField("success_count", value);
      return this;
    }
    public APIRequestGet requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGet requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdAsyncRequestSet> {

    AdAsyncRequestSet lastResponse = null;
    @Override
    public AdAsyncRequestSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "notification_mode",
      "notification_uri",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAsyncRequestSet parseResponse(String response, String header) throws APIException {
      return AdAsyncRequestSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAsyncRequestSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequestSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAsyncRequestSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAsyncRequestSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAsyncRequestSet>() {
           public AdAsyncRequestSet apply(ResponseWrapper result) {
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setNotificationMode (AdAsyncRequestSet.EnumNotificationMode notificationMode) {
      this.setParam("notification_mode", notificationMode);
      return this;
    }
    public APIRequestUpdate setNotificationMode (String notificationMode) {
      this.setParam("notification_mode", notificationMode);
      return this;
    }

    public APIRequestUpdate setNotificationUri (String notificationUri) {
      this.setParam("notification_uri", notificationUri);
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

  public static enum EnumNotificationMode {
      @SerializedName("OFF")
      VALUE_OFF("OFF"),
      @SerializedName("ON_COMPLETE")
      VALUE_ON_COMPLETE("ON_COMPLETE"),
      ;

      private String value;

      private EnumNotificationMode(String value) {
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
    this.mCanceledCount = instance.mCanceledCount;
    this.mCreatedTime = instance.mCreatedTime;
    this.mErrorCount = instance.mErrorCount;
    this.mId = instance.mId;
    this.mInProgressCount = instance.mInProgressCount;
    this.mInitialCount = instance.mInitialCount;
    this.mIsCompleted = instance.mIsCompleted;
    this.mName = instance.mName;
    this.mNotificationMode = instance.mNotificationMode;
    this.mNotificationResult = instance.mNotificationResult;
    this.mNotificationStatus = instance.mNotificationStatus;
    this.mNotificationUri = instance.mNotificationUri;
    this.mOwnerId = instance.mOwnerId;
    this.mSuccessCount = instance.mSuccessCount;
    this.mTotalCount = instance.mTotalCount;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAsyncRequestSet> getParser() {
    return new APIRequest.ResponseParser<AdAsyncRequestSet>() {
      public APINodeList<AdAsyncRequestSet> parseResponse(String response, APIContext context, APIRequest<AdAsyncRequestSet> request, String header) throws MalformedResponseException {
        return AdAsyncRequestSet.parseResponse(response, context, request, header);
      }
    };
  }
}
