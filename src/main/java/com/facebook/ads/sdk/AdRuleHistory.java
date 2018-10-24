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
public class AdRuleHistory extends APINode {
  @SerializedName("evaluation_spec")
  private AdRuleEvaluationSpec mEvaluationSpec = null;
  @SerializedName("exception_code")
  private Long mExceptionCode = null;
  @SerializedName("exception_message")
  private String mExceptionMessage = null;
  @SerializedName("execution_spec")
  private AdRuleExecutionSpec mExecutionSpec = null;
  @SerializedName("is_manual")
  private Boolean mIsManual = null;
  @SerializedName("results")
  private List<AdRuleHistoryResult> mResults = null;
  @SerializedName("schedule_spec")
  private AdRuleScheduleSpec mScheduleSpec = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdRuleHistory() {
  }

  public AdRuleHistory(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdRuleHistory(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdRuleHistory fetch() throws APIException{
    AdRuleHistory newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdRuleHistory fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdRuleHistory> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdRuleHistory fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdRuleHistory> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdRuleHistory> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRuleHistory>)(
      new APIRequest<AdRuleHistory>(context, "", "/", "GET", AdRuleHistory.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdRuleHistory>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdRuleHistory.getParser())
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
  public static AdRuleHistory loadJSON(String json, APIContext context) {
    AdRuleHistory adRuleHistory = getGson().fromJson(json, AdRuleHistory.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRuleHistory.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adRuleHistory.context = context;
    adRuleHistory.rawValue = json;
    return adRuleHistory;
  }

  public static APINodeList<AdRuleHistory> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdRuleHistory> adRuleHistorys = new APINodeList<AdRuleHistory>(request, json);
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
          adRuleHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adRuleHistorys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRuleHistorys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRuleHistorys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRuleHistorys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRuleHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adRuleHistorys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRuleHistorys.add(loadJSON(obj.toString(), context));
            }
          }
          return adRuleHistorys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRuleHistorys.add(loadJSON(entry.getValue().toString(), context));
          }
          return adRuleHistorys;
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
              adRuleHistorys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRuleHistorys;
          }

          // Sixth, check if it's pure JsonObject
          adRuleHistorys.clear();
          adRuleHistorys.add(loadJSON(json, context));
          return adRuleHistorys;
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


  public AdRuleEvaluationSpec getFieldEvaluationSpec() {
    if (mEvaluationSpec != null) {
      mEvaluationSpec.context = getContext();
    }
    return mEvaluationSpec;
  }

  public Long getFieldExceptionCode() {
    return mExceptionCode;
  }

  public String getFieldExceptionMessage() {
    return mExceptionMessage;
  }

  public AdRuleExecutionSpec getFieldExecutionSpec() {
    if (mExecutionSpec != null) {
      mExecutionSpec.context = getContext();
    }
    return mExecutionSpec;
  }

  public Boolean getFieldIsManual() {
    return mIsManual;
  }

  public List<AdRuleHistoryResult> getFieldResults() {
    return mResults;
  }

  public AdRuleScheduleSpec getFieldScheduleSpec() {
    if (mScheduleSpec != null) {
      mScheduleSpec.context = getContext();
    }
    return mScheduleSpec;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdRuleHistory> {

    AdRuleHistory lastResponse = null;
    @Override
    public AdRuleHistory getLastResponse() {
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
      "id",
    };

    @Override
    public AdRuleHistory parseResponse(String response) throws APIException {
      return AdRuleHistory.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdRuleHistory execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRuleHistory execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdRuleHistory> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRuleHistory> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdRuleHistory>() {
           public AdRuleHistory apply(String result) {
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


    public APIRequestGet setAction (EnumAction action) {
      this.setParam("action", action);
      return this;
    }
    public APIRequestGet setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestGet setHideNoChanges (Boolean hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }
    public APIRequestGet setHideNoChanges (String hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }

    public APIRequestGet setObjectId (String objectId) {
      this.setParam("object_id", objectId);
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

    public APIRequestGet requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGet requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGet requestExceptionCodeField () {
      return this.requestExceptionCodeField(true);
    }
    public APIRequestGet requestExceptionCodeField (boolean value) {
      this.requestField("exception_code", value);
      return this;
    }
    public APIRequestGet requestExceptionMessageField () {
      return this.requestExceptionMessageField(true);
    }
    public APIRequestGet requestExceptionMessageField (boolean value) {
      this.requestField("exception_message", value);
      return this;
    }
    public APIRequestGet requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGet requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGet requestIsManualField () {
      return this.requestIsManualField(true);
    }
    public APIRequestGet requestIsManualField (boolean value) {
      this.requestField("is_manual", value);
      return this;
    }
    public APIRequestGet requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGet requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGet requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGet requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
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

  public static enum EnumAction {
      @SerializedName("BUDGET_NOT_REDISTRIBUTED")
      VALUE_BUDGET_NOT_REDISTRIBUTED("BUDGET_NOT_REDISTRIBUTED"),
      @SerializedName("CHANGED_BID")
      VALUE_CHANGED_BID("CHANGED_BID"),
      @SerializedName("CHANGED_BUDGET")
      VALUE_CHANGED_BUDGET("CHANGED_BUDGET"),
      @SerializedName("EMAIL")
      VALUE_EMAIL("EMAIL"),
      @SerializedName("ENDPOINT_PINGED")
      VALUE_ENDPOINT_PINGED("ENDPOINT_PINGED"),
      @SerializedName("ERROR")
      VALUE_ERROR("ERROR"),
      @SerializedName("FACEBOOK_NOTIFICATION_SENT")
      VALUE_FACEBOOK_NOTIFICATION_SENT("FACEBOOK_NOTIFICATION_SENT"),
      @SerializedName("MESSAGE_SENT")
      VALUE_MESSAGE_SENT("MESSAGE_SENT"),
      @SerializedName("NOT_CHANGED")
      VALUE_NOT_CHANGED("NOT_CHANGED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("UNPAUSED")
      VALUE_UNPAUSED("UNPAUSED"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumAction(String value) {
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

  public AdRuleHistory copyFrom(AdRuleHistory instance) {
    this.mEvaluationSpec = instance.mEvaluationSpec;
    this.mExceptionCode = instance.mExceptionCode;
    this.mExceptionMessage = instance.mExceptionMessage;
    this.mExecutionSpec = instance.mExecutionSpec;
    this.mIsManual = instance.mIsManual;
    this.mResults = instance.mResults;
    this.mScheduleSpec = instance.mScheduleSpec;
    this.mTimestamp = instance.mTimestamp;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRuleHistory> getParser() {
    return new APIRequest.ResponseParser<AdRuleHistory>() {
      public APINodeList<AdRuleHistory> parseResponse(String response, APIContext context, APIRequest<AdRuleHistory> request) throws MalformedResponseException {
        return AdRuleHistory.parseResponse(response, context, request);
      }
    };
  }
}
