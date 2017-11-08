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

  public static AdRule fetchById(String id, APIContext context) throws APIException {
    AdRule adRule =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adRule;
  }

  public static APINodeList<AdRule> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRule>)(
      new APIRequest<AdRule>(context, "", "/", "GET", AdRule.getParser())
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
  public static AdRule loadJSON(String json, APIContext context) {
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
      };
    }
    adRule.context = context;
    adRule.rawValue = json;
    return adRule;
  }

  public static APINodeList<AdRule> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdRule> adRules = new APINodeList<AdRule>(request, json);
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
          adRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adRules.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adRules.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRules.add(loadJSON(obj.toString(), context));
            }
          }
          return adRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRules.add(loadJSON(entry.getValue().toString(), context));
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
              adRules.add(loadJSON(value.toString(), context));
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
          adRules.add(loadJSON(json, context));
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

  public APIRequestGetHistory getHistory() {
    return new APIRequestGetHistory(this.getPrefixedId().toString(), context);
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
    return mEvaluationSpec;
  }

  public AdRuleExecutionSpec getFieldExecutionSpec() {
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
    public APINodeList<AdRuleHistory> parseResponse(String response) throws APIException {
      return AdRuleHistory.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdRuleHistory> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdRuleHistory> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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
    public AdRule parseResponse(String response) throws APIException {
      return AdRule.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
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
      "reset_period",
      "schedule_spec",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdRule parseResponse(String response) throws APIException {
      return AdRule.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestUpdate setResetPeriod (Long resetPeriod) {
      this.setParam("reset_period", resetPeriod);
      return this;
    }
    public APIRequestUpdate setResetPeriod (String resetPeriod) {
      this.setParam("reset_period", resetPeriod);
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
      @SerializedName("ENABLED")
      VALUE_ENABLED("ENABLED"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
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
      public APINodeList<AdRule> parseResponse(String response, APIContext context, APIRequest<AdRule> request) throws MalformedResponseException {
        return AdRule.parseResponse(response, context, request);
      }
    };
  }
}
