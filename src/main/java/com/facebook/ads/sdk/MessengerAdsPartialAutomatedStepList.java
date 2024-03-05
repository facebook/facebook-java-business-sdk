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
public class MessengerAdsPartialAutomatedStepList extends APINode {
  @SerializedName("fblead_form")
  private LeadgenForm mFbleadForm = null;
  @SerializedName("first_step_id")
  private String mFirstStepId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("privacy_url")
  private String mPrivacyUrl = null;
  @SerializedName("reminder_text")
  private String mReminderText = null;
  @SerializedName("stop_question_message")
  private String mStopQuestionMessage = null;
  protected static Gson gson = null;

  MessengerAdsPartialAutomatedStepList() {
  }

  public MessengerAdsPartialAutomatedStepList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MessengerAdsPartialAutomatedStepList(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MessengerAdsPartialAutomatedStepList fetch() throws APIException{
    MessengerAdsPartialAutomatedStepList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MessengerAdsPartialAutomatedStepList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MessengerAdsPartialAutomatedStepList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MessengerAdsPartialAutomatedStepList fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MessengerAdsPartialAutomatedStepList> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MessengerAdsPartialAutomatedStepList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MessengerAdsPartialAutomatedStepList>)(
      new APIRequest<MessengerAdsPartialAutomatedStepList>(context, "", "/", "GET", MessengerAdsPartialAutomatedStepList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MessengerAdsPartialAutomatedStepList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MessengerAdsPartialAutomatedStepList.getParser())
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
  public static MessengerAdsPartialAutomatedStepList loadJSON(String json, APIContext context, String header) {
    MessengerAdsPartialAutomatedStepList messengerAdsPartialAutomatedStepList = getGson().fromJson(json, MessengerAdsPartialAutomatedStepList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(messengerAdsPartialAutomatedStepList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    messengerAdsPartialAutomatedStepList.context = context;
    messengerAdsPartialAutomatedStepList.rawValue = json;
    messengerAdsPartialAutomatedStepList.header = header;
    return messengerAdsPartialAutomatedStepList;
  }

  public static APINodeList<MessengerAdsPartialAutomatedStepList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MessengerAdsPartialAutomatedStepList> messengerAdsPartialAutomatedStepLists = new APINodeList<MessengerAdsPartialAutomatedStepList>(request, json, header);
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
          messengerAdsPartialAutomatedStepLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return messengerAdsPartialAutomatedStepLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messengerAdsPartialAutomatedStepLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messengerAdsPartialAutomatedStepLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messengerAdsPartialAutomatedStepLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messengerAdsPartialAutomatedStepLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  messengerAdsPartialAutomatedStepLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              messengerAdsPartialAutomatedStepLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return messengerAdsPartialAutomatedStepLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messengerAdsPartialAutomatedStepLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return messengerAdsPartialAutomatedStepLists;
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
              messengerAdsPartialAutomatedStepLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messengerAdsPartialAutomatedStepLists;
          }

          // Sixth, check if it's pure JsonObject
          messengerAdsPartialAutomatedStepLists.clear();
          messengerAdsPartialAutomatedStepLists.add(loadJSON(json, context, header));
          return messengerAdsPartialAutomatedStepLists;
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

  public APIRequestGetSteps getSteps() {
    return new APIRequestGetSteps(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public LeadgenForm getFieldFbleadForm() {
    if (mFbleadForm != null) {
      mFbleadForm.context = getContext();
    }
    return mFbleadForm;
  }

  public String getFieldFirstStepId() {
    return mFirstStepId;
  }

  public String getFieldId() {
    return mId;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public String getFieldPrivacyUrl() {
    return mPrivacyUrl;
  }

  public String getFieldReminderText() {
    return mReminderText;
  }

  public String getFieldStopQuestionMessage() {
    return mStopQuestionMessage;
  }



  public static class APIRequestGetSteps extends APIRequest<APINode> {

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
               return APIRequestGetSteps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSteps(String nodeId, APIContext context) {
      super(context, nodeId, "/steps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSteps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSteps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSteps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSteps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSteps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSteps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSteps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSteps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<MessengerAdsPartialAutomatedStepList> {

    MessengerAdsPartialAutomatedStepList lastResponse = null;
    @Override
    public MessengerAdsPartialAutomatedStepList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "fblead_form",
      "first_step_id",
      "id",
      "page",
      "privacy_url",
      "reminder_text",
      "stop_question_message",
    };

    @Override
    public MessengerAdsPartialAutomatedStepList parseResponse(String response, String header) throws APIException {
      return MessengerAdsPartialAutomatedStepList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MessengerAdsPartialAutomatedStepList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerAdsPartialAutomatedStepList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MessengerAdsPartialAutomatedStepList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerAdsPartialAutomatedStepList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MessengerAdsPartialAutomatedStepList>() {
           public MessengerAdsPartialAutomatedStepList apply(ResponseWrapper result) {
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

    public APIRequestGet requestFbleadFormField () {
      return this.requestFbleadFormField(true);
    }
    public APIRequestGet requestFbleadFormField (boolean value) {
      this.requestField("fblead_form", value);
      return this;
    }
    public APIRequestGet requestFirstStepIdField () {
      return this.requestFirstStepIdField(true);
    }
    public APIRequestGet requestFirstStepIdField (boolean value) {
      this.requestField("first_step_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPrivacyUrlField () {
      return this.requestPrivacyUrlField(true);
    }
    public APIRequestGet requestPrivacyUrlField (boolean value) {
      this.requestField("privacy_url", value);
      return this;
    }
    public APIRequestGet requestReminderTextField () {
      return this.requestReminderTextField(true);
    }
    public APIRequestGet requestReminderTextField (boolean value) {
      this.requestField("reminder_text", value);
      return this;
    }
    public APIRequestGet requestStopQuestionMessageField () {
      return this.requestStopQuestionMessageField(true);
    }
    public APIRequestGet requestStopQuestionMessageField (boolean value) {
      this.requestField("stop_question_message", value);
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

  public MessengerAdsPartialAutomatedStepList copyFrom(MessengerAdsPartialAutomatedStepList instance) {
    this.mFbleadForm = instance.mFbleadForm;
    this.mFirstStepId = instance.mFirstStepId;
    this.mId = instance.mId;
    this.mPage = instance.mPage;
    this.mPrivacyUrl = instance.mPrivacyUrl;
    this.mReminderText = instance.mReminderText;
    this.mStopQuestionMessage = instance.mStopQuestionMessage;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessengerAdsPartialAutomatedStepList> getParser() {
    return new APIRequest.ResponseParser<MessengerAdsPartialAutomatedStepList>() {
      public APINodeList<MessengerAdsPartialAutomatedStepList> parseResponse(String response, APIContext context, APIRequest<MessengerAdsPartialAutomatedStepList> request, String header) throws MalformedResponseException {
        return MessengerAdsPartialAutomatedStepList.parseResponse(response, context, request, header);
      }
    };
  }
}
