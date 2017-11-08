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
public class LeadGenQuestion extends APINode {
  @SerializedName("conditional_questions_choices")
  private List<Object> mConditionalQuestionsChoices = null;
  @SerializedName("conditional_questions_group_id")
  private String mConditionalQuestionsGroupId = null;
  @SerializedName("dependent_conditional_questions")
  private List<Object> mDependentConditionalQuestions = null;
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

  LeadGenQuestion() {
  }

  public LeadGenQuestion(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LeadGenQuestion(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public LeadGenQuestion fetch() throws APIException{
    LeadGenQuestion newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LeadGenQuestion fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static LeadGenQuestion fetchById(String id, APIContext context) throws APIException {
    LeadGenQuestion leadGenQuestion =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return leadGenQuestion;
  }

  public static APINodeList<LeadGenQuestion> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadGenQuestion>)(
      new APIRequest<LeadGenQuestion>(context, "", "/", "GET", LeadGenQuestion.getParser())
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
  public static LeadGenQuestion loadJSON(String json, APIContext context) {
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
      };
    }
    leadGenQuestion.context = context;
    leadGenQuestion.rawValue = json;
    return leadGenQuestion;
  }

  public static APINodeList<LeadGenQuestion> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LeadGenQuestion> leadGenQuestions = new APINodeList<LeadGenQuestion>(request, json);
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
          leadGenQuestions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return leadGenQuestions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            leadGenQuestions.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenQuestions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  leadGenQuestions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenQuestions.add(loadJSON(obj.toString(), context));
            }
          }
          return leadGenQuestions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenQuestions.add(loadJSON(entry.getValue().toString(), context));
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
              leadGenQuestions.add(loadJSON(value.toString(), context));
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
          leadGenQuestions.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<Object> getFieldConditionalQuestionsChoices() {
    return mConditionalQuestionsChoices;
  }

  public String getFieldConditionalQuestionsGroupId() {
    return mConditionalQuestionsGroupId;
  }

  public List<Object> getFieldDependentConditionalQuestions() {
    return mDependentConditionalQuestions;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInlineContext() {
    return mInlineContext;
  }

  public String getFieldKey() {
    return mKey;
  }

  public String getFieldLabel() {
    return mLabel;
  }

  public List<LeadGenQuestionOption> getFieldOptions() {
    return mOptions;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestGet extends APIRequest<LeadGenQuestion> {

    LeadGenQuestion lastResponse = null;
    @Override
    public LeadGenQuestion getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "conditional_questions_choices",
      "conditional_questions_group_id",
      "dependent_conditional_questions",
      "id",
      "inline_context",
      "key",
      "label",
      "options",
      "type",
    };

    @Override
    public LeadGenQuestion parseResponse(String response) throws APIException {
      return LeadGenQuestion.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LeadGenQuestion execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadGenQuestion execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestGet requestConditionalQuestionsChoicesField () {
      return this.requestConditionalQuestionsChoicesField(true);
    }
    public APIRequestGet requestConditionalQuestionsChoicesField (boolean value) {
      this.requestField("conditional_questions_choices", value);
      return this;
    }
    public APIRequestGet requestConditionalQuestionsGroupIdField () {
      return this.requestConditionalQuestionsGroupIdField(true);
    }
    public APIRequestGet requestConditionalQuestionsGroupIdField (boolean value) {
      this.requestField("conditional_questions_group_id", value);
      return this;
    }
    public APIRequestGet requestDependentConditionalQuestionsField () {
      return this.requestDependentConditionalQuestionsField(true);
    }
    public APIRequestGet requestDependentConditionalQuestionsField (boolean value) {
      this.requestField("dependent_conditional_questions", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInlineContextField () {
      return this.requestInlineContextField(true);
    }
    public APIRequestGet requestInlineContextField (boolean value) {
      this.requestField("inline_context", value);
      return this;
    }
    public APIRequestGet requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGet requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGet requestLabelField () {
      return this.requestLabelField(true);
    }
    public APIRequestGet requestLabelField (boolean value) {
      this.requestField("label", value);
      return this;
    }
    public APIRequestGet requestOptionsField () {
      return this.requestOptionsField(true);
    }
    public APIRequestGet requestOptionsField (boolean value) {
      this.requestField("options", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
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
      public APINodeList<LeadGenQuestion> parseResponse(String response, APIContext context, APIRequest<LeadGenQuestion> request) throws MalformedResponseException {
        return LeadGenQuestion.parseResponse(response, context, request);
      }
    };
  }
}
