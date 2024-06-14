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
public class AdAccountAdRulesHistory extends APINode {
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
  @SerializedName("rule_id")
  private Long mRuleId = null;
  @SerializedName("schedule_spec")
  private AdRuleScheduleSpec mScheduleSpec = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  protected static Gson gson = null;

  public AdAccountAdRulesHistory() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountAdRulesHistory loadJSON(String json, APIContext context, String header) {
    AdAccountAdRulesHistory adAccountAdRulesHistory = getGson().fromJson(json, AdAccountAdRulesHistory.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountAdRulesHistory.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountAdRulesHistory.context = context;
    adAccountAdRulesHistory.rawValue = json;
    adAccountAdRulesHistory.header = header;
    return adAccountAdRulesHistory;
  }

  public static APINodeList<AdAccountAdRulesHistory> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountAdRulesHistory> adAccountAdRulesHistorys = new APINodeList<AdAccountAdRulesHistory>(request, json, header);
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
          adAccountAdRulesHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountAdRulesHistorys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountAdRulesHistorys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountAdRulesHistorys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountAdRulesHistorys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountAdRulesHistorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountAdRulesHistorys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountAdRulesHistorys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountAdRulesHistorys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountAdRulesHistorys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountAdRulesHistorys;
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
              adAccountAdRulesHistorys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountAdRulesHistorys;
          }

          // Sixth, check if it's pure JsonObject
          adAccountAdRulesHistorys.clear();
          adAccountAdRulesHistorys.add(loadJSON(json, context, header));
          return adAccountAdRulesHistorys;
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


  public AdRuleEvaluationSpec getFieldEvaluationSpec() {
    if (mEvaluationSpec != null) {
      mEvaluationSpec.context = getContext();
    }
    return mEvaluationSpec;
  }

  public AdAccountAdRulesHistory setFieldEvaluationSpec(AdRuleEvaluationSpec value) {
    this.mEvaluationSpec = value;
    return this;
  }

  public AdAccountAdRulesHistory setFieldEvaluationSpec(String value) {
    Type type = new TypeToken<AdRuleEvaluationSpec>(){}.getType();
    this.mEvaluationSpec = AdRuleEvaluationSpec.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldExceptionCode() {
    return mExceptionCode;
  }

  public AdAccountAdRulesHistory setFieldExceptionCode(Long value) {
    this.mExceptionCode = value;
    return this;
  }

  public String getFieldExceptionMessage() {
    return mExceptionMessage;
  }

  public AdAccountAdRulesHistory setFieldExceptionMessage(String value) {
    this.mExceptionMessage = value;
    return this;
  }

  public AdRuleExecutionSpec getFieldExecutionSpec() {
    if (mExecutionSpec != null) {
      mExecutionSpec.context = getContext();
    }
    return mExecutionSpec;
  }

  public AdAccountAdRulesHistory setFieldExecutionSpec(AdRuleExecutionSpec value) {
    this.mExecutionSpec = value;
    return this;
  }

  public AdAccountAdRulesHistory setFieldExecutionSpec(String value) {
    Type type = new TypeToken<AdRuleExecutionSpec>(){}.getType();
    this.mExecutionSpec = AdRuleExecutionSpec.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldIsManual() {
    return mIsManual;
  }

  public AdAccountAdRulesHistory setFieldIsManual(Boolean value) {
    this.mIsManual = value;
    return this;
  }

  public List<AdRuleHistoryResult> getFieldResults() {
    return mResults;
  }

  public AdAccountAdRulesHistory setFieldResults(List<AdRuleHistoryResult> value) {
    this.mResults = value;
    return this;
  }

  public AdAccountAdRulesHistory setFieldResults(String value) {
    Type type = new TypeToken<List<AdRuleHistoryResult>>(){}.getType();
    this.mResults = AdRuleHistoryResult.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldRuleId() {
    return mRuleId;
  }

  public AdAccountAdRulesHistory setFieldRuleId(Long value) {
    this.mRuleId = value;
    return this;
  }

  public AdRuleScheduleSpec getFieldScheduleSpec() {
    return mScheduleSpec;
  }

  public AdAccountAdRulesHistory setFieldScheduleSpec(AdRuleScheduleSpec value) {
    this.mScheduleSpec = value;
    return this;
  }

  public AdAccountAdRulesHistory setFieldScheduleSpec(String value) {
    Type type = new TypeToken<AdRuleScheduleSpec>(){}.getType();
    this.mScheduleSpec = AdRuleScheduleSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public AdAccountAdRulesHistory setFieldTimestamp(String value) {
    this.mTimestamp = value;
    return this;
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
      @SerializedName("ENABLE_ADVANTAGE_CAMPAIGN_BUDGET")
      VALUE_ENABLE_ADVANTAGE_CAMPAIGN_BUDGET("ENABLE_ADVANTAGE_CAMPAIGN_BUDGET"),
      @SerializedName("ENABLE_ADVANTAGE_PLUS_CREATIVE")
      VALUE_ENABLE_ADVANTAGE_PLUS_CREATIVE("ENABLE_ADVANTAGE_PLUS_CREATIVE"),
      @SerializedName("ENABLE_ADVANTAGE_PLUS_PLACEMENTS")
      VALUE_ENABLE_ADVANTAGE_PLUS_PLACEMENTS("ENABLE_ADVANTAGE_PLUS_PLACEMENTS"),
      @SerializedName("ENABLE_AUTOFLOW")
      VALUE_ENABLE_AUTOFLOW("ENABLE_AUTOFLOW"),
      @SerializedName("ENABLE_GEN_UNCROP")
      VALUE_ENABLE_GEN_UNCROP("ENABLE_GEN_UNCROP"),
      @SerializedName("ENABLE_MUSIC")
      VALUE_ENABLE_MUSIC("ENABLE_MUSIC"),
      @SerializedName("ENABLE_SEMANTIC_BASED_AUDIENCE_EXPANSION")
      VALUE_ENABLE_SEMANTIC_BASED_AUDIENCE_EXPANSION("ENABLE_SEMANTIC_BASED_AUDIENCE_EXPANSION"),
      @SerializedName("ENABLE_SHOPS_ADS")
      VALUE_ENABLE_SHOPS_ADS("ENABLE_SHOPS_ADS"),
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
      ;

      private String value;

      private EnumAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEvaluationType {
      @SerializedName("SCHEDULE")
      VALUE_SCHEDULE("SCHEDULE"),
      @SerializedName("TRIGGER")
      VALUE_TRIGGER("TRIGGER"),
      ;

      private String value;

      private EnumEvaluationType(String value) {
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

  public AdAccountAdRulesHistory copyFrom(AdAccountAdRulesHistory instance) {
    this.mEvaluationSpec = instance.mEvaluationSpec;
    this.mExceptionCode = instance.mExceptionCode;
    this.mExceptionMessage = instance.mExceptionMessage;
    this.mExecutionSpec = instance.mExecutionSpec;
    this.mIsManual = instance.mIsManual;
    this.mResults = instance.mResults;
    this.mRuleId = instance.mRuleId;
    this.mScheduleSpec = instance.mScheduleSpec;
    this.mTimestamp = instance.mTimestamp;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountAdRulesHistory> getParser() {
    return new APIRequest.ResponseParser<AdAccountAdRulesHistory>() {
      public APINodeList<AdAccountAdRulesHistory> parseResponse(String response, APIContext context, APIRequest<AdAccountAdRulesHistory> request, String header) throws MalformedResponseException {
        return AdAccountAdRulesHistory.parseResponse(response, context, request, header);
      }
    };
  }
}
