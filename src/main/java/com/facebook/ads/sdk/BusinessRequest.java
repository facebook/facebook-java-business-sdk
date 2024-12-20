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
public class BusinessRequest extends APINode {
  @SerializedName("accessor")
  private Business mAccessor = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("object_type")
  private String mObjectType = null;
  @SerializedName("permitted_tasks")
  private List<String> mPermittedTasks = null;
  @SerializedName("request_status")
  private String mRequestStatus = null;
  @SerializedName("request_type")
  private String mRequestType = null;
  @SerializedName("requestor")
  private String mRequestor = null;
  protected static Gson gson = null;

  BusinessRequest() {
  }

  public BusinessRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessRequest fetch() throws APIException{
    BusinessRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessRequest>)(
      new APIRequest<BusinessRequest>(context, "", "/", "GET", BusinessRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessRequest.getParser())
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
  public static BusinessRequest loadJSON(String json, APIContext context, String header) {
    BusinessRequest businessRequest = getGson().fromJson(json, BusinessRequest.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(businessRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessRequest.context = context;
    businessRequest.rawValue = json;
    businessRequest.header = header;
    return businessRequest;
  }

  public static APINodeList<BusinessRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessRequest> businessRequests = new APINodeList<BusinessRequest>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          businessRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessRequests;
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
              businessRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessRequests;
          }

          // Sixth, check if it's pure JsonObject
          businessRequests.clear();
          businessRequests.add(loadJSON(json, context, header));
          return businessRequests;
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


  public Business getFieldAccessor() {
    if (mAccessor != null) {
      mAccessor.context = getContext();
    }
    return mAccessor;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public String getFieldObjectType() {
    return mObjectType;
  }

  public List<String> getFieldPermittedTasks() {
    return mPermittedTasks;
  }

  public String getFieldRequestStatus() {
    return mRequestStatus;
  }

  public String getFieldRequestType() {
    return mRequestType;
  }

  public String getFieldRequestor() {
    return mRequestor;
  }



  public static class APIRequestGet extends APIRequest<BusinessRequest> {

    BusinessRequest lastResponse = null;
    @Override
    public BusinessRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "accessor",
      "creation_time",
      "id",
      "object_id",
      "object_type",
      "permitted_tasks",
      "request_status",
      "request_type",
      "requestor",
    };

    @Override
    public BusinessRequest parseResponse(String response, String header) throws APIException {
      return BusinessRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessRequest>() {
           public BusinessRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAccessorField () {
      return this.requestAccessorField(true);
    }
    public APIRequestGet requestAccessorField (boolean value) {
      this.requestField("accessor", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGet requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGet requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGet requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGet requestPermittedTasksField () {
      return this.requestPermittedTasksField(true);
    }
    public APIRequestGet requestPermittedTasksField (boolean value) {
      this.requestField("permitted_tasks", value);
      return this;
    }
    public APIRequestGet requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGet requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGet requestRequestTypeField () {
      return this.requestRequestTypeField(true);
    }
    public APIRequestGet requestRequestTypeField (boolean value) {
      this.requestField("request_type", value);
      return this;
    }
    public APIRequestGet requestRequestorField () {
      return this.requestRequestorField(true);
    }
    public APIRequestGet requestRequestorField (boolean value) {
      this.requestField("requestor", value);
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

  public BusinessRequest copyFrom(BusinessRequest instance) {
    this.mAccessor = instance.mAccessor;
    this.mCreationTime = instance.mCreationTime;
    this.mId = instance.mId;
    this.mObjectId = instance.mObjectId;
    this.mObjectType = instance.mObjectType;
    this.mPermittedTasks = instance.mPermittedTasks;
    this.mRequestStatus = instance.mRequestStatus;
    this.mRequestType = instance.mRequestType;
    this.mRequestor = instance.mRequestor;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessRequest> getParser() {
    return new APIRequest.ResponseParser<BusinessRequest>() {
      public APINodeList<BusinessRequest> parseResponse(String response, APIContext context, APIRequest<BusinessRequest> request, String header) throws MalformedResponseException {
        return BusinessRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
