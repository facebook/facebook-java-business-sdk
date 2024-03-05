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
public class AdRule extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("evaluation_spec")
  private AdRuleEvaluationSpec mEvaluationSpec = null;
  @SerializedName("execution_spec")
  private AdRuleExecutionSpec mExecutionSpec = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("schedule_spec")
  private AdRuleScheduleSpec mScheduleSpec = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdRule() {
  }

  public AdRule(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdRule(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdRule fetch() throws APIException{
    AdRule newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdRule fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdRule> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdRule fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdRule> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdRule> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRule>)(
      new APIRequest<AdRule>(context, "", "/", "GET", AdRule.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdRule>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdRule.getParser())
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
  public static AdRule loadJSON(String json, APIContext context, String header) {
    AdRule adRule = getGson().fromJson(json, AdRule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adRule.context = context;
    adRule.rawValue = json;
    adRule.header = header;
    return adRule;
  }

  public static APINodeList<AdRule> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdRule> adRules = new APINodeList<AdRule>(request, json, header);
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
          adRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adRules.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRules.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRules.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adRules;
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
              adRules.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRules;
          }

          // Sixth, check if it's pure JsonObject
          adRules.clear();
          adRules.add(loadJSON(json, context, header));
          return adRules;
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

  public APIRequestCreateExecute createExecute() {
    return new APIRequestCreateExecute(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHistory getHistory() {
    return new APIRequestGetHistory(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePreview createPreview() {
    return new APIRequestCreatePreview(this.getPrefixedId().toString(), context);
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdRuleEvaluationSpec getFieldEvaluationSpec() {
    if (mEvaluationSpec != null) {
      mEvaluationSpec.context = getContext();
    }
    return mEvaluationSpec;
  }

  public AdRuleExecutionSpec getFieldExecutionSpec() {
    if (mExecutionSpec != null) {
      mExecutionSpec.context = getContext();
    }
    return mExecutionSpec;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public AdRuleScheduleSpec getFieldScheduleSpec() {
    return mScheduleSpec;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestCreateExecute extends APIRequest<APINode> {

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
               return APIRequestCreateExecute.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateExecute(String nodeId, APIContext context) {
      super(context, nodeId, "/execute", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateExecute setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateExecute setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExecute requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExecute requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExecute requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateExecute requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExecute requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateExecute requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetHistory extends APIRequest<AdRuleHistory> {

    APINodeList<AdRuleHistory> lastResponse = null;
    @Override
    public APINodeList<AdRuleHistory> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action",
      "hide_no_changes",
      "object_id",
    };

    public static final String[] FIELDS = {
      "evaluation_spec",
      "exception_code",
      "exception_message",
      "execution_spec",
      "is_manual",
      "results",
      "schedule_spec",
      "timestamp",
    };

    @Override
    public APINodeList<AdRuleHistory> parseResponse(String response, String header) throws APIException {
      return AdRuleHistory.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdRuleHistory> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdRuleHistory> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdRuleHistory>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdRuleHistory>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdRuleHistory>>() {
           public APINodeList<AdRuleHistory> apply(ResponseWrapper result) {
             try {
               return APIRequestGetHistory.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetHistory(String nodeId, APIContext context) {
      super(context, nodeId, "/history", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHistory setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHistory setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHistory setAction (AdRuleHistory.EnumAction action) {
      this.setParam("action", action);
      return this;
    }
    public APIRequestGetHistory setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestGetHistory setHideNoChanges (Boolean hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }
    public APIRequestGetHistory setHideNoChanges (String hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }

    public APIRequestGetHistory setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestGetHistory requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHistory requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHistory requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHistory requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHistory requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHistory requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHistory requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGetHistory requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGetHistory requestExceptionCodeField () {
      return this.requestExceptionCodeField(true);
    }
    public APIRequestGetHistory requestExceptionCodeField (boolean value) {
      this.requestField("exception_code", value);
      return this;
    }
    public APIRequestGetHistory requestExceptionMessageField () {
      return this.requestExceptionMessageField(true);
    }
    public APIRequestGetHistory requestExceptionMessageField (boolean value) {
      this.requestField("exception_message", value);
      return this;
    }
    public APIRequestGetHistory requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGetHistory requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGetHistory requestIsManualField () {
      return this.requestIsManualField(true);
    }
    public APIRequestGetHistory requestIsManualField (boolean value) {
      this.requestField("is_manual", value);
      return this;
    }
    public APIRequestGetHistory requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetHistory requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetHistory requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGetHistory requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGetHistory requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetHistory requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
  }

  public static class APIRequestCreatePreview extends APIRequest<AdRule> {

    AdRule lastResponse = null;
    @Override
    public AdRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdRule parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdRule>() {
           public AdRule apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePreview.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePreview(String nodeId, APIContext context) {
      super(context, nodeId, "/preview", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePreview setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePreview setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePreview requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePreview requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePreview requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePreview requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePreview requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePreview requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public static class APIRequestGet extends APIRequest<AdRule> {

    AdRule lastResponse = null;
    @Override
    public AdRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "created_by",
      "created_time",
      "evaluation_spec",
      "execution_spec",
      "id",
      "name",
      "schedule_spec",
      "status",
      "updated_time",
    };

    @Override
    public AdRule parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdRule>() {
           public AdRule apply(ResponseWrapper result) {
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
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGet requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGet requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGet requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
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
    public APIRequestGet requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGet requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
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

  public static class APIRequestUpdate extends APIRequest<AdRule> {

    AdRule lastResponse = null;
    @Override
    public AdRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "evaluation_spec",
      "execution_spec",
      "name",
      "schedule_spec",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdRule parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdRule>() {
           public AdRule apply(ResponseWrapper result) {
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


    public APIRequestUpdate setEvaluationSpec (Object evaluationSpec) {
      this.setParam("evaluation_spec", evaluationSpec);
      return this;
    }
    public APIRequestUpdate setEvaluationSpec (String evaluationSpec) {
      this.setParam("evaluation_spec", evaluationSpec);
      return this;
    }

    public APIRequestUpdate setExecutionSpec (Object executionSpec) {
      this.setParam("execution_spec", executionSpec);
      return this;
    }
    public APIRequestUpdate setExecutionSpec (String executionSpec) {
      this.setParam("execution_spec", executionSpec);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setScheduleSpec (Object scheduleSpec) {
      this.setParam("schedule_spec", scheduleSpec);
      return this;
    }
    public APIRequestUpdate setScheduleSpec (String scheduleSpec) {
      this.setParam("schedule_spec", scheduleSpec);
      return this;
    }

    public APIRequestUpdate setStatus (AdRule.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
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

  public static enum EnumStatus {
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("ENABLED")
      VALUE_ENABLED("ENABLED"),
      @SerializedName("HAS_ISSUES")
      VALUE_HAS_ISSUES("HAS_ISSUES"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUiCreationSource {
      @SerializedName("AM_ACCOUNT_OVERVIEW_RECOMMENDATIONS")
      VALUE_AM_ACCOUNT_OVERVIEW_RECOMMENDATIONS("AM_ACCOUNT_OVERVIEW_RECOMMENDATIONS"),
      @SerializedName("AM_ACTIVITY_HISTORY_TABLE")
      VALUE_AM_ACTIVITY_HISTORY_TABLE("AM_ACTIVITY_HISTORY_TABLE"),
      @SerializedName("AM_AD_OBJECT_NAME_CARD")
      VALUE_AM_AD_OBJECT_NAME_CARD("AM_AD_OBJECT_NAME_CARD"),
      @SerializedName("AM_AMFE_L3_RECOMMENDATION")
      VALUE_AM_AMFE_L3_RECOMMENDATION("AM_AMFE_L3_RECOMMENDATION"),
      @SerializedName("AM_AUTOFLOW_GUIDANCE_CARD")
      VALUE_AM_AUTOFLOW_GUIDANCE_CARD("AM_AUTOFLOW_GUIDANCE_CARD"),
      @SerializedName("AM_AUTO_APPLY_WIDGET")
      VALUE_AM_AUTO_APPLY_WIDGET("AM_AUTO_APPLY_WIDGET"),
      @SerializedName("AM_EDITOR_CARD")
      VALUE_AM_EDITOR_CARD("AM_EDITOR_CARD"),
      @SerializedName("AM_INFO_CARD")
      VALUE_AM_INFO_CARD("AM_INFO_CARD"),
      @SerializedName("AM_NAME_CELL_DROPDOWN")
      VALUE_AM_NAME_CELL_DROPDOWN("AM_NAME_CELL_DROPDOWN"),
      @SerializedName("AM_OPTIMIZATION_TIP_GUIDANCE_CARD")
      VALUE_AM_OPTIMIZATION_TIP_GUIDANCE_CARD("AM_OPTIMIZATION_TIP_GUIDANCE_CARD"),
      @SerializedName("AM_PERFORMANCE_SUMMARY")
      VALUE_AM_PERFORMANCE_SUMMARY("AM_PERFORMANCE_SUMMARY"),
      @SerializedName("AM_RULE_LANDING_PAGE_BANNER")
      VALUE_AM_RULE_LANDING_PAGE_BANNER("AM_RULE_LANDING_PAGE_BANNER"),
      @SerializedName("AM_SYD_RESOLUTION_FLOW")
      VALUE_AM_SYD_RESOLUTION_FLOW("AM_SYD_RESOLUTION_FLOW"),
      @SerializedName("AM_SYD_RESOLUTION_FLOW_MODAL")
      VALUE_AM_SYD_RESOLUTION_FLOW_MODAL("AM_SYD_RESOLUTION_FLOW_MODAL"),
      @SerializedName("AM_TABLE_DELIVERY_COLUMN_POPOVER")
      VALUE_AM_TABLE_DELIVERY_COLUMN_POPOVER("AM_TABLE_DELIVERY_COLUMN_POPOVER"),
      @SerializedName("AM_TABLE_TOGGLE_POPOVER")
      VALUE_AM_TABLE_TOGGLE_POPOVER("AM_TABLE_TOGGLE_POPOVER"),
      @SerializedName("AM_TOOLBAR_CREATE_RULE_DROPDOWN")
      VALUE_AM_TOOLBAR_CREATE_RULE_DROPDOWN("AM_TOOLBAR_CREATE_RULE_DROPDOWN"),
      @SerializedName("PE_CAMPAIGN_STRUCTURE_MENU")
      VALUE_PE_CAMPAIGN_STRUCTURE_MENU("PE_CAMPAIGN_STRUCTURE_MENU"),
      @SerializedName("PE_EDITOR_CARD")
      VALUE_PE_EDITOR_CARD("PE_EDITOR_CARD"),
      @SerializedName("PE_INFO_CARD")
      VALUE_PE_INFO_CARD("PE_INFO_CARD"),
      @SerializedName("PE_TOOLBAR_CREATE_RULE_DROPDOWN")
      VALUE_PE_TOOLBAR_CREATE_RULE_DROPDOWN("PE_TOOLBAR_CREATE_RULE_DROPDOWN"),
      @SerializedName("RULES_MANAGEMENT_PAGE_ACTION_DROPDOWN")
      VALUE_RULES_MANAGEMENT_PAGE_ACTION_DROPDOWN("RULES_MANAGEMENT_PAGE_ACTION_DROPDOWN"),
      @SerializedName("RULES_MANAGEMENT_PAGE_RULE_GROUP")
      VALUE_RULES_MANAGEMENT_PAGE_RULE_GROUP("RULES_MANAGEMENT_PAGE_RULE_GROUP"),
      @SerializedName("RULES_MANAGEMENT_PAGE_RULE_NAME")
      VALUE_RULES_MANAGEMENT_PAGE_RULE_NAME("RULES_MANAGEMENT_PAGE_RULE_NAME"),
      @SerializedName("RULES_MANAGEMENT_PAGE_TOP_NAV")
      VALUE_RULES_MANAGEMENT_PAGE_TOP_NAV("RULES_MANAGEMENT_PAGE_TOP_NAV"),
      @SerializedName("RULES_VIEW_ACTIVE_RULES_DIALOG")
      VALUE_RULES_VIEW_ACTIVE_RULES_DIALOG("RULES_VIEW_ACTIVE_RULES_DIALOG"),
      @SerializedName("RULE_CREATION_SUCCESS_DIALOG")
      VALUE_RULE_CREATION_SUCCESS_DIALOG("RULE_CREATION_SUCCESS_DIALOG"),
      @SerializedName("RULE_SYD_REDIRECT")
      VALUE_RULE_SYD_REDIRECT("RULE_SYD_REDIRECT"),
      @SerializedName("RULE_TEMPLATES_DIALOG")
      VALUE_RULE_TEMPLATES_DIALOG("RULE_TEMPLATES_DIALOG"),
      ;

      private String value;

      private EnumUiCreationSource(String value) {
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

  public AdRule copyFrom(AdRule instance) {
    this.mAccountId = instance.mAccountId;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEvaluationSpec = instance.mEvaluationSpec;
    this.mExecutionSpec = instance.mExecutionSpec;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mScheduleSpec = instance.mScheduleSpec;
    this.mStatus = instance.mStatus;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRule> getParser() {
    return new APIRequest.ResponseParser<AdRule>() {
      public APINodeList<AdRule> parseResponse(String response, APIContext context, APIRequest<AdRule> request, String header) throws MalformedResponseException {
        return AdRule.parseResponse(response, context, request, header);
      }
    };
  }
}
