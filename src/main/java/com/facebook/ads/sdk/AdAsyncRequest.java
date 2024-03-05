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
public class AdAsyncRequest extends APINode {
  @SerializedName("async_request_set")
  private AdAsyncRequestSet mAsyncRequestSet = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("input")
  private Map<String, String> mInput = null;
  @SerializedName("result")
  private Map<String, String> mResult = null;
  @SerializedName("scope_object_id")
  private String mScopeObjectId = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdAsyncRequest() {
  }

  public AdAsyncRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAsyncRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAsyncRequest fetch() throws APIException{
    AdAsyncRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAsyncRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAsyncRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAsyncRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAsyncRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAsyncRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAsyncRequest>)(
      new APIRequest<AdAsyncRequest>(context, "", "/", "GET", AdAsyncRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAsyncRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAsyncRequest.getParser())
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
  public static AdAsyncRequest loadJSON(String json, APIContext context, String header) {
    AdAsyncRequest adAsyncRequest = getGson().fromJson(json, AdAsyncRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAsyncRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAsyncRequest.context = context;
    adAsyncRequest.rawValue = json;
    adAsyncRequest.header = header;
    return adAsyncRequest;
  }

  public static APINodeList<AdAsyncRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAsyncRequest> adAsyncRequests = new APINodeList<AdAsyncRequest>(request, json, header);
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
          adAsyncRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAsyncRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAsyncRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAsyncRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAsyncRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAsyncRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAsyncRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAsyncRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAsyncRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAsyncRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAsyncRequests;
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
              adAsyncRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAsyncRequests;
          }

          // Sixth, check if it's pure JsonObject
          adAsyncRequests.clear();
          adAsyncRequests.add(loadJSON(json, context, header));
          return adAsyncRequests;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public AdAsyncRequestSet getFieldAsyncRequestSet() {
    if (mAsyncRequestSet != null) {
      mAsyncRequestSet.context = getContext();
    }
    return mAsyncRequestSet;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Map<String, String> getFieldInput() {
    return mInput;
  }

  public Map<String, String> getFieldResult() {
    return mResult;
  }

  public String getFieldScopeObjectId() {
    return mScopeObjectId;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
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

  public static class APIRequestGet extends APIRequest<AdAsyncRequest> {

    AdAsyncRequest lastResponse = null;
    @Override
    public AdAsyncRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public AdAsyncRequest parseResponse(String response, String header) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAsyncRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAsyncRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAsyncRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAsyncRequest>() {
           public AdAsyncRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGet requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGet requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGet requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGet requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGet requestScopeObjectIdField () {
      return this.requestScopeObjectIdField(true);
    }
    public APIRequestGet requestScopeObjectIdField (boolean value) {
      this.requestField("scope_object_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
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

  public static enum EnumStatuses {
      @SerializedName("CANCELED")
      VALUE_CANCELED("CANCELED"),
      @SerializedName("CANCELED_DEPENDENCY")
      VALUE_CANCELED_DEPENDENCY("CANCELED_DEPENDENCY"),
      @SerializedName("ERROR")
      VALUE_ERROR("ERROR"),
      @SerializedName("ERROR_CONFLICTS")
      VALUE_ERROR_CONFLICTS("ERROR_CONFLICTS"),
      @SerializedName("ERROR_DEPENDENCY")
      VALUE_ERROR_DEPENDENCY("ERROR_DEPENDENCY"),
      @SerializedName("INITIAL")
      VALUE_INITIAL("INITIAL"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("PENDING_DEPENDENCY")
      VALUE_PENDING_DEPENDENCY("PENDING_DEPENDENCY"),
      @SerializedName("PROCESS_BY_AD_ASYNC_ENGINE")
      VALUE_PROCESS_BY_AD_ASYNC_ENGINE("PROCESS_BY_AD_ASYNC_ENGINE"),
      @SerializedName("PROCESS_BY_EVENT_PROCESSOR")
      VALUE_PROCESS_BY_EVENT_PROCESSOR("PROCESS_BY_EVENT_PROCESSOR"),
      @SerializedName("SUCCESS")
      VALUE_SUCCESS("SUCCESS"),
      @SerializedName("USER_CANCELED")
      VALUE_USER_CANCELED("USER_CANCELED"),
      @SerializedName("USER_CANCELED_DEPENDENCY")
      VALUE_USER_CANCELED_DEPENDENCY("USER_CANCELED_DEPENDENCY"),
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

  public AdAsyncRequest copyFrom(AdAsyncRequest instance) {
    this.mAsyncRequestSet = instance.mAsyncRequestSet;
    this.mCreatedTime = instance.mCreatedTime;
    this.mId = instance.mId;
    this.mInput = instance.mInput;
    this.mResult = instance.mResult;
    this.mScopeObjectId = instance.mScopeObjectId;
    this.mStatus = instance.mStatus;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAsyncRequest> getParser() {
    return new APIRequest.ResponseParser<AdAsyncRequest>() {
      public APINodeList<AdAsyncRequest> parseResponse(String response, APIContext context, APIRequest<AdAsyncRequest> request, String header) throws MalformedResponseException {
        return AdAsyncRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
