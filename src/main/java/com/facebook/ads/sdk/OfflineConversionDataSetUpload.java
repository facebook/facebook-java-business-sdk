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
public class OfflineConversionDataSetUpload extends APINode {
  @SerializedName("api_calls")
  private Long mApiCalls = null;
  @SerializedName("creation_time")
  private Long mCreationTime = null;
  @SerializedName("duplicate_entries")
  private Long mDuplicateEntries = null;
  @SerializedName("event_stats")
  private String mEventStats = null;
  @SerializedName("event_time_max")
  private Long mEventTimeMax = null;
  @SerializedName("event_time_min")
  private Long mEventTimeMin = null;
  @SerializedName("first_upload_time")
  private Long mFirstUploadTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_excluded_for_lift")
  private Boolean mIsExcludedForLift = null;
  @SerializedName("last_upload_time")
  private Long mLastUploadTime = null;
  @SerializedName("match_rate_approx")
  private Long mMatchRateApprox = null;
  @SerializedName("matched_entries")
  private Long mMatchedEntries = null;
  @SerializedName("upload_tag")
  private String mUploadTag = null;
  @SerializedName("valid_entries")
  private Long mValidEntries = null;
  protected static Gson gson = null;

  OfflineConversionDataSetUpload() {
  }

  public OfflineConversionDataSetUpload(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OfflineConversionDataSetUpload(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OfflineConversionDataSetUpload fetch() throws APIException{
    OfflineConversionDataSetUpload newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OfflineConversionDataSetUpload fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OfflineConversionDataSetUpload> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OfflineConversionDataSetUpload fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OfflineConversionDataSetUpload> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OfflineConversionDataSetUpload> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OfflineConversionDataSetUpload>)(
      new APIRequest<OfflineConversionDataSetUpload>(context, "", "/", "GET", OfflineConversionDataSetUpload.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OfflineConversionDataSetUpload>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OfflineConversionDataSetUpload.getParser())
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
  public static OfflineConversionDataSetUpload loadJSON(String json, APIContext context, String header) {
    OfflineConversionDataSetUpload offlineConversionDataSetUpload = getGson().fromJson(json, OfflineConversionDataSetUpload.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(offlineConversionDataSetUpload.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    offlineConversionDataSetUpload.context = context;
    offlineConversionDataSetUpload.rawValue = json;
    offlineConversionDataSetUpload.header = header;
    return offlineConversionDataSetUpload;
  }

  public static APINodeList<OfflineConversionDataSetUpload> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OfflineConversionDataSetUpload> offlineConversionDataSetUploads = new APINodeList<OfflineConversionDataSetUpload>(request, json, header);
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
          offlineConversionDataSetUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return offlineConversionDataSetUploads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                offlineConversionDataSetUploads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            offlineConversionDataSetUploads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              offlineConversionDataSetUploads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              offlineConversionDataSetUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  offlineConversionDataSetUploads.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              offlineConversionDataSetUploads.add(loadJSON(obj.toString(), context, header));
            }
          }
          return offlineConversionDataSetUploads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              offlineConversionDataSetUploads.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return offlineConversionDataSetUploads;
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
              offlineConversionDataSetUploads.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return offlineConversionDataSetUploads;
          }

          // Sixth, check if it's pure JsonObject
          offlineConversionDataSetUploads.clear();
          offlineConversionDataSetUploads.add(loadJSON(json, context, header));
          return offlineConversionDataSetUploads;
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

  public APIRequestGetProgress getProgress() {
    return new APIRequestGetProgress(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPullSessions getPullSessions() {
    return new APIRequestGetPullSessions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldApiCalls() {
    return mApiCalls;
  }

  public Long getFieldCreationTime() {
    return mCreationTime;
  }

  public Long getFieldDuplicateEntries() {
    return mDuplicateEntries;
  }

  public String getFieldEventStats() {
    return mEventStats;
  }

  public Long getFieldEventTimeMax() {
    return mEventTimeMax;
  }

  public Long getFieldEventTimeMin() {
    return mEventTimeMin;
  }

  public Long getFieldFirstUploadTime() {
    return mFirstUploadTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsExcludedForLift() {
    return mIsExcludedForLift;
  }

  public Long getFieldLastUploadTime() {
    return mLastUploadTime;
  }

  public Long getFieldMatchRateApprox() {
    return mMatchRateApprox;
  }

  public Long getFieldMatchedEntries() {
    return mMatchedEntries;
  }

  public String getFieldUploadTag() {
    return mUploadTag;
  }

  public Long getFieldValidEntries() {
    return mValidEntries;
  }



  public static class APIRequestGetProgress extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProgress.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProgress(String nodeId, APIContext context) {
      super(context, nodeId, "/progress", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProgress setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProgress setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProgress requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProgress requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProgress requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProgress requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProgress requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProgress requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPullSessions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPullSessions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPullSessions(String nodeId, APIContext context) {
      super(context, nodeId, "/pull_sessions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPullSessions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPullSessions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPullSessions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPullSessions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPullSessions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPullSessions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPullSessions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPullSessions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<OfflineConversionDataSetUpload> {

    OfflineConversionDataSetUpload lastResponse = null;
    @Override
    public OfflineConversionDataSetUpload getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "api_calls",
      "creation_time",
      "duplicate_entries",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_upload_time",
      "id",
      "is_excluded_for_lift",
      "last_upload_time",
      "match_rate_approx",
      "matched_entries",
      "upload_tag",
      "valid_entries",
    };

    @Override
    public OfflineConversionDataSetUpload parseResponse(String response, String header) throws APIException {
      return OfflineConversionDataSetUpload.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OfflineConversionDataSetUpload execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OfflineConversionDataSetUpload execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OfflineConversionDataSetUpload> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OfflineConversionDataSetUpload> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OfflineConversionDataSetUpload>() {
           public OfflineConversionDataSetUpload apply(ResponseWrapper result) {
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

    public APIRequestGet requestApiCallsField () {
      return this.requestApiCallsField(true);
    }
    public APIRequestGet requestApiCallsField (boolean value) {
      this.requestField("api_calls", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGet requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGet requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGet requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGet requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGet requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGet requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGet requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGet requestFirstUploadTimeField () {
      return this.requestFirstUploadTimeField(true);
    }
    public APIRequestGet requestFirstUploadTimeField (boolean value) {
      this.requestField("first_upload_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsExcludedForLiftField () {
      return this.requestIsExcludedForLiftField(true);
    }
    public APIRequestGet requestIsExcludedForLiftField (boolean value) {
      this.requestField("is_excluded_for_lift", value);
      return this;
    }
    public APIRequestGet requestLastUploadTimeField () {
      return this.requestLastUploadTimeField(true);
    }
    public APIRequestGet requestLastUploadTimeField (boolean value) {
      this.requestField("last_upload_time", value);
      return this;
    }
    public APIRequestGet requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGet requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGet requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGet requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGet requestUploadTagField () {
      return this.requestUploadTagField(true);
    }
    public APIRequestGet requestUploadTagField (boolean value) {
      this.requestField("upload_tag", value);
      return this;
    }
    public APIRequestGet requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGet requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static enum EnumOrder {
      @SerializedName("ASCENDING")
      VALUE_ASCENDING("ASCENDING"),
      @SerializedName("DESCENDING")
      VALUE_DESCENDING("DESCENDING"),
      ;

      private String value;

      private EnumOrder(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSortBy {
      @SerializedName("API_CALLS")
      VALUE_API_CALLS("API_CALLS"),
      @SerializedName("CREATION_TIME")
      VALUE_CREATION_TIME("CREATION_TIME"),
      @SerializedName("EVENT_TIME_MAX")
      VALUE_EVENT_TIME_MAX("EVENT_TIME_MAX"),
      @SerializedName("EVENT_TIME_MIN")
      VALUE_EVENT_TIME_MIN("EVENT_TIME_MIN"),
      @SerializedName("FIRST_UPLOAD_TIME")
      VALUE_FIRST_UPLOAD_TIME("FIRST_UPLOAD_TIME"),
      @SerializedName("IS_EXCLUDED_FOR_LIFT")
      VALUE_IS_EXCLUDED_FOR_LIFT("IS_EXCLUDED_FOR_LIFT"),
      @SerializedName("LAST_UPLOAD_TIME")
      VALUE_LAST_UPLOAD_TIME("LAST_UPLOAD_TIME"),
      ;

      private String value;

      private EnumSortBy(String value) {
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

  public OfflineConversionDataSetUpload copyFrom(OfflineConversionDataSetUpload instance) {
    this.mApiCalls = instance.mApiCalls;
    this.mCreationTime = instance.mCreationTime;
    this.mDuplicateEntries = instance.mDuplicateEntries;
    this.mEventStats = instance.mEventStats;
    this.mEventTimeMax = instance.mEventTimeMax;
    this.mEventTimeMin = instance.mEventTimeMin;
    this.mFirstUploadTime = instance.mFirstUploadTime;
    this.mId = instance.mId;
    this.mIsExcludedForLift = instance.mIsExcludedForLift;
    this.mLastUploadTime = instance.mLastUploadTime;
    this.mMatchRateApprox = instance.mMatchRateApprox;
    this.mMatchedEntries = instance.mMatchedEntries;
    this.mUploadTag = instance.mUploadTag;
    this.mValidEntries = instance.mValidEntries;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OfflineConversionDataSetUpload> getParser() {
    return new APIRequest.ResponseParser<OfflineConversionDataSetUpload>() {
      public APINodeList<OfflineConversionDataSetUpload> parseResponse(String response, APIContext context, APIRequest<OfflineConversionDataSetUpload> request, String header) throws MalformedResponseException {
        return OfflineConversionDataSetUpload.parseResponse(response, context, request, header);
      }
    };
  }
}
