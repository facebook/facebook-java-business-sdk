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
public class AdDraft extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("api_version")
  private String mApiVersion = null;
  @SerializedName("async_request_set")
  private AdAsyncRequestSet mAsyncRequestSet = null;
  @SerializedName("author_id")
  private String mAuthorId = null;
  @SerializedName("created_by")
  private String mCreatedBy = null;
  @SerializedName("draft_version")
  private String mDraftVersion = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_active")
  private Boolean mIsActive = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ownership_type")
  private String mOwnershipType = null;
  @SerializedName("publish_status")
  private Object mPublishStatus = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("summary")
  private String mSummary = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  protected static Gson gson = null;

  AdDraft() {
  }

  public AdDraft(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdDraft(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdDraft fetch() throws APIException{
    AdDraft newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdDraft fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdDraft> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdDraft fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdDraft> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdDraft> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdDraft>)(
      new APIRequest<AdDraft>(context, "", "/", "GET", AdDraft.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdDraft>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdDraft.getParser())
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
  public static AdDraft loadJSON(String json, APIContext context, String header) {
    AdDraft adDraft = getGson().fromJson(json, AdDraft.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adDraft.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adDraft.context = context;
    adDraft.rawValue = json;
    adDraft.header = header;
    return adDraft;
  }

  public static APINodeList<AdDraft> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdDraft> adDrafts = new APINodeList<AdDraft>(request, json, header);
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
          adDrafts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adDrafts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adDrafts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adDrafts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adDrafts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adDrafts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adDrafts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adDrafts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adDrafts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adDrafts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adDrafts;
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
              adDrafts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adDrafts;
          }

          // Sixth, check if it's pure JsonObject
          adDrafts.clear();
          adDrafts.add(loadJSON(json, context, header));
          return adDrafts;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldApiVersion() {
    return mApiVersion;
  }

  public AdAsyncRequestSet getFieldAsyncRequestSet() {
    if (mAsyncRequestSet != null) {
      mAsyncRequestSet.context = getContext();
    }
    return mAsyncRequestSet;
  }

  public String getFieldAuthorId() {
    return mAuthorId;
  }

  public String getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldDraftVersion() {
    return mDraftVersion;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsActive() {
    return mIsActive;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldOwnershipType() {
    return mOwnershipType;
  }

  public Object getFieldPublishStatus() {
    return mPublishStatus;
  }

  public String getFieldState() {
    return mState;
  }

  public String getFieldSummary() {
    return mSummary;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestGet extends APIRequest<AdDraft> {

    AdDraft lastResponse = null;
    @Override
    public AdDraft getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "api_version",
      "async_request_set",
      "author_id",
      "created_by",
      "draft_version",
      "id",
      "is_active",
      "name",
      "ownership_type",
      "publish_status",
      "state",
      "summary",
      "time_created",
      "time_updated",
    };

    @Override
    public AdDraft parseResponse(String response, String header) throws APIException {
      return AdDraft.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdDraft execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdDraft execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdDraft> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdDraft> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdDraft>() {
           public AdDraft apply(ResponseWrapper result) {
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestApiVersionField () {
      return this.requestApiVersionField(true);
    }
    public APIRequestGet requestApiVersionField (boolean value) {
      this.requestField("api_version", value);
      return this;
    }
    public APIRequestGet requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGet requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGet requestAuthorIdField () {
      return this.requestAuthorIdField(true);
    }
    public APIRequestGet requestAuthorIdField (boolean value) {
      this.requestField("author_id", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestDraftVersionField () {
      return this.requestDraftVersionField(true);
    }
    public APIRequestGet requestDraftVersionField (boolean value) {
      this.requestField("draft_version", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsActiveField () {
      return this.requestIsActiveField(true);
    }
    public APIRequestGet requestIsActiveField (boolean value) {
      this.requestField("is_active", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnershipTypeField () {
      return this.requestOwnershipTypeField(true);
    }
    public APIRequestGet requestOwnershipTypeField (boolean value) {
      this.requestField("ownership_type", value);
      return this;
    }
    public APIRequestGet requestPublishStatusField () {
      return this.requestPublishStatusField(true);
    }
    public APIRequestGet requestPublishStatusField (boolean value) {
      this.requestField("publish_status", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGet requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGet requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
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

  public AdDraft copyFrom(AdDraft instance) {
    this.mAccountId = instance.mAccountId;
    this.mApiVersion = instance.mApiVersion;
    this.mAsyncRequestSet = instance.mAsyncRequestSet;
    this.mAuthorId = instance.mAuthorId;
    this.mCreatedBy = instance.mCreatedBy;
    this.mDraftVersion = instance.mDraftVersion;
    this.mId = instance.mId;
    this.mIsActive = instance.mIsActive;
    this.mName = instance.mName;
    this.mOwnershipType = instance.mOwnershipType;
    this.mPublishStatus = instance.mPublishStatus;
    this.mState = instance.mState;
    this.mSummary = instance.mSummary;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdDraft> getParser() {
    return new APIRequest.ResponseParser<AdDraft>() {
      public APINodeList<AdDraft> parseResponse(String response, APIContext context, APIRequest<AdDraft> request, String header) throws MalformedResponseException {
        return AdDraft.parseResponse(response, context, request, header);
      }
    };
  }
}
