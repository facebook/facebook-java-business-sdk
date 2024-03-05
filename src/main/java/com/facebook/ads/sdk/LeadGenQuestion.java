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
public class LeadGenQuestion extends APINode {
  @SerializedName("conditional_questions_choices")
  private List<LeadGenConditionalQuestionsGroupChoices> mConditionalQuestionsChoices = null;
  @SerializedName("conditional_questions_group_id")
  private String mConditionalQuestionsGroupId = null;
  @SerializedName("dependent_conditional_questions")
  private List<LeadGenConditionalQuestionsGroupQuestions> mDependentConditionalQuestions = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("inline_context")
  private String mInlineContext = null;
  @SerializedName("key")
  private String mKey = null;
  @SerializedName("label")
  private String mLabel = null;
  @SerializedName("options")
  private List<LeadGenQuestionOption> mOptions = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  public LeadGenQuestion() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LeadGenQuestion loadJSON(String json, APIContext context, String header) {
    LeadGenQuestion leadGenQuestion = getGson().fromJson(json, LeadGenQuestion.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadGenQuestion.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    leadGenQuestion.context = context;
    leadGenQuestion.rawValue = json;
    leadGenQuestion.header = header;
    return leadGenQuestion;
  }

  public static APINodeList<LeadGenQuestion> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadGenQuestion> leadGenQuestions = new APINodeList<LeadGenQuestion>(request, json, header);
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
          leadGenQuestions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leadGenQuestions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadGenQuestions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadGenQuestions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadGenQuestions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenQuestions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadGenQuestions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenQuestions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadGenQuestions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenQuestions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leadGenQuestions;
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
              leadGenQuestions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadGenQuestions;
          }

          // Sixth, check if it's pure JsonObject
          leadGenQuestions.clear();
          leadGenQuestions.add(loadJSON(json, context, header));
          return leadGenQuestions;
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


  public List<LeadGenConditionalQuestionsGroupChoices> getFieldConditionalQuestionsChoices() {
    return mConditionalQuestionsChoices;
  }

  public LeadGenQuestion setFieldConditionalQuestionsChoices(List<LeadGenConditionalQuestionsGroupChoices> value) {
    this.mConditionalQuestionsChoices = value;
    return this;
  }

  public LeadGenQuestion setFieldConditionalQuestionsChoices(String value) {
    Type type = new TypeToken<List<LeadGenConditionalQuestionsGroupChoices>>(){}.getType();
    this.mConditionalQuestionsChoices = LeadGenConditionalQuestionsGroupChoices.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldConditionalQuestionsGroupId() {
    return mConditionalQuestionsGroupId;
  }

  public LeadGenQuestion setFieldConditionalQuestionsGroupId(String value) {
    this.mConditionalQuestionsGroupId = value;
    return this;
  }

  public List<LeadGenConditionalQuestionsGroupQuestions> getFieldDependentConditionalQuestions() {
    return mDependentConditionalQuestions;
  }

  public LeadGenQuestion setFieldDependentConditionalQuestions(List<LeadGenConditionalQuestionsGroupQuestions> value) {
    this.mDependentConditionalQuestions = value;
    return this;
  }

  public LeadGenQuestion setFieldDependentConditionalQuestions(String value) {
    Type type = new TypeToken<List<LeadGenConditionalQuestionsGroupQuestions>>(){}.getType();
    this.mDependentConditionalQuestions = LeadGenConditionalQuestionsGroupQuestions.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public LeadGenQuestion setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldInlineContext() {
    return mInlineContext;
  }

  public LeadGenQuestion setFieldInlineContext(String value) {
    this.mInlineContext = value;
    return this;
  }

  public String getFieldKey() {
    return mKey;
  }

  public LeadGenQuestion setFieldKey(String value) {
    this.mKey = value;
    return this;
  }

  public String getFieldLabel() {
    return mLabel;
  }

  public LeadGenQuestion setFieldLabel(String value) {
    this.mLabel = value;
    return this;
  }

  public List<LeadGenQuestionOption> getFieldOptions() {
    return mOptions;
  }

  public LeadGenQuestion setFieldOptions(List<LeadGenQuestionOption> value) {
    this.mOptions = value;
    return this;
  }

  public LeadGenQuestion setFieldOptions(String value) {
    Type type = new TypeToken<List<LeadGenQuestionOption>>(){}.getType();
    this.mOptions = LeadGenQuestionOption.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldType() {
    return mType;
  }

  public LeadGenQuestion setFieldType(String value) {
    this.mType = value;
    return this;
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

  public LeadGenQuestion copyFrom(LeadGenQuestion instance) {
    this.mConditionalQuestionsChoices = instance.mConditionalQuestionsChoices;
    this.mConditionalQuestionsGroupId = instance.mConditionalQuestionsGroupId;
    this.mDependentConditionalQuestions = instance.mDependentConditionalQuestions;
    this.mId = instance.mId;
    this.mInlineContext = instance.mInlineContext;
    this.mKey = instance.mKey;
    this.mLabel = instance.mLabel;
    this.mOptions = instance.mOptions;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenQuestion> getParser() {
    return new APIRequest.ResponseParser<LeadGenQuestion>() {
      public APINodeList<LeadGenQuestion> parseResponse(String response, APIContext context, APIRequest<LeadGenQuestion> request, String header) throws MalformedResponseException {
        return LeadGenQuestion.parseResponse(response, context, request, header);
      }
    };
  }
}
