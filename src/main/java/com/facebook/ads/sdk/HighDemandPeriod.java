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
public class HighDemandPeriod extends APINode {
  @SerializedName("ad_object_id")
  private String mAdObjectId = null;
  @SerializedName("budget_value")
  private Long mBudgetValue = null;
  @SerializedName("budget_value_type")
  private String mBudgetValueType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("recurrence_type")
  private String mRecurrenceType = null;
  @SerializedName("time_end")
  private String mTimeEnd = null;
  @SerializedName("time_start")
  private String mTimeStart = null;
  @SerializedName("weekly_schedule")
  private List<HighDemandPeriodTimeSuggestionWeeklySegment> mWeeklySchedule = null;
  protected static Gson gson = null;

  HighDemandPeriod() {
  }

  public HighDemandPeriod(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public HighDemandPeriod(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public HighDemandPeriod fetch() throws APIException{
    HighDemandPeriod newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static HighDemandPeriod fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<HighDemandPeriod> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static HighDemandPeriod fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<HighDemandPeriod> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<HighDemandPeriod> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<HighDemandPeriod>)(
      new APIRequest<HighDemandPeriod>(context, "", "/", "GET", HighDemandPeriod.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<HighDemandPeriod>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", HighDemandPeriod.getParser())
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
  public static HighDemandPeriod loadJSON(String json, APIContext context, String header) {
    HighDemandPeriod highDemandPeriod = getGson().fromJson(json, HighDemandPeriod.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(highDemandPeriod.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    highDemandPeriod.context = context;
    highDemandPeriod.rawValue = json;
    highDemandPeriod.header = header;
    return highDemandPeriod;
  }

  public static APINodeList<HighDemandPeriod> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<HighDemandPeriod> highDemandPeriods = new APINodeList<HighDemandPeriod>(request, json, header);
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
          highDemandPeriods.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return highDemandPeriods;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                highDemandPeriods.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            highDemandPeriods.setPaging(previous, next);
            if (context.hasAppSecret()) {
              highDemandPeriods.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              highDemandPeriods.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  highDemandPeriods.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              highDemandPeriods.add(loadJSON(obj.toString(), context, header));
            }
          }
          return highDemandPeriods;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              highDemandPeriods.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return highDemandPeriods;
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
              highDemandPeriods.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return highDemandPeriods;
          }

          // Sixth, check if it's pure JsonObject
          highDemandPeriods.clear();
          highDemandPeriods.add(loadJSON(json, context, header));
          return highDemandPeriods;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdObjectId() {
    return mAdObjectId;
  }

  public Long getFieldBudgetValue() {
    return mBudgetValue;
  }

  public String getFieldBudgetValueType() {
    return mBudgetValueType;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldRecurrenceType() {
    return mRecurrenceType;
  }

  public String getFieldTimeEnd() {
    return mTimeEnd;
  }

  public String getFieldTimeStart() {
    return mTimeStart;
  }

  public List<HighDemandPeriodTimeSuggestionWeeklySegment> getFieldWeeklySchedule() {
    return mWeeklySchedule;
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

  public static class APIRequestGet extends APIRequest<HighDemandPeriod> {

    HighDemandPeriod lastResponse = null;
    @Override
    public HighDemandPeriod getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_object_id",
      "budget_value",
      "budget_value_type",
      "id",
      "recurrence_type",
      "time_end",
      "time_start",
      "weekly_schedule",
    };

    @Override
    public HighDemandPeriod parseResponse(String response, String header) throws APIException {
      return HighDemandPeriod.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HighDemandPeriod execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HighDemandPeriod execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HighDemandPeriod> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HighDemandPeriod> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HighDemandPeriod>() {
           public HighDemandPeriod apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdObjectIdField () {
      return this.requestAdObjectIdField(true);
    }
    public APIRequestGet requestAdObjectIdField (boolean value) {
      this.requestField("ad_object_id", value);
      return this;
    }
    public APIRequestGet requestBudgetValueField () {
      return this.requestBudgetValueField(true);
    }
    public APIRequestGet requestBudgetValueField (boolean value) {
      this.requestField("budget_value", value);
      return this;
    }
    public APIRequestGet requestBudgetValueTypeField () {
      return this.requestBudgetValueTypeField(true);
    }
    public APIRequestGet requestBudgetValueTypeField (boolean value) {
      this.requestField("budget_value_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestRecurrenceTypeField () {
      return this.requestRecurrenceTypeField(true);
    }
    public APIRequestGet requestRecurrenceTypeField (boolean value) {
      this.requestField("recurrence_type", value);
      return this;
    }
    public APIRequestGet requestTimeEndField () {
      return this.requestTimeEndField(true);
    }
    public APIRequestGet requestTimeEndField (boolean value) {
      this.requestField("time_end", value);
      return this;
    }
    public APIRequestGet requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGet requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
      return this;
    }
    public APIRequestGet requestWeeklyScheduleField () {
      return this.requestWeeklyScheduleField(true);
    }
    public APIRequestGet requestWeeklyScheduleField (boolean value) {
      this.requestField("weekly_schedule", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<HighDemandPeriod> {

    HighDemandPeriod lastResponse = null;
    @Override
    public HighDemandPeriod getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "budget_value",
      "budget_value_type",
      "time_end",
      "time_start",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HighDemandPeriod parseResponse(String response, String header) throws APIException {
      return HighDemandPeriod.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HighDemandPeriod execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HighDemandPeriod execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HighDemandPeriod> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HighDemandPeriod> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HighDemandPeriod>() {
           public HighDemandPeriod apply(ResponseWrapper result) {
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


    public APIRequestUpdate setBudgetValue (Long budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }
    public APIRequestUpdate setBudgetValue (String budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }

    public APIRequestUpdate setBudgetValueType (HighDemandPeriod.EnumBudgetValueType budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }
    public APIRequestUpdate setBudgetValueType (String budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }

    public APIRequestUpdate setTimeEnd (Long timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }
    public APIRequestUpdate setTimeEnd (String timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }

    public APIRequestUpdate setTimeStart (Long timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }
    public APIRequestUpdate setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
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

  public static enum EnumBudgetValueType {
      @SerializedName("ABSOLUTE")
      VALUE_ABSOLUTE("ABSOLUTE"),
      @SerializedName("MULTIPLIER")
      VALUE_MULTIPLIER("MULTIPLIER"),
      ;

      private String value;

      private EnumBudgetValueType(String value) {
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

  public HighDemandPeriod copyFrom(HighDemandPeriod instance) {
    this.mAdObjectId = instance.mAdObjectId;
    this.mBudgetValue = instance.mBudgetValue;
    this.mBudgetValueType = instance.mBudgetValueType;
    this.mId = instance.mId;
    this.mRecurrenceType = instance.mRecurrenceType;
    this.mTimeEnd = instance.mTimeEnd;
    this.mTimeStart = instance.mTimeStart;
    this.mWeeklySchedule = instance.mWeeklySchedule;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<HighDemandPeriod> getParser() {
    return new APIRequest.ResponseParser<HighDemandPeriod>() {
      public APINodeList<HighDemandPeriod> parseResponse(String response, APIContext context, APIRequest<HighDemandPeriod> request, String header) throws MalformedResponseException {
        return HighDemandPeriod.parseResponse(response, context, request, header);
      }
    };
  }
}
