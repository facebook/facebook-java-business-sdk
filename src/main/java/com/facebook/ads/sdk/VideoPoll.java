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
public class VideoPoll extends APINode {
  @SerializedName("close_after_voting")
  private Boolean mCloseAfterVoting = null;
  @SerializedName("default_open")
  private Boolean mDefaultOpen = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("question")
  private String mQuestion = null;
  @SerializedName("show_gradient")
  private Boolean mShowGradient = null;
  @SerializedName("show_results")
  private Boolean mShowResults = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  protected static Gson gson = null;

  VideoPoll() {
  }

  public VideoPoll(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoPoll(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoPoll fetch() throws APIException{
    VideoPoll newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoPoll fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoPoll> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoPoll fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoPoll> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoPoll> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoPoll>)(
      new APIRequest<VideoPoll>(context, "", "/", "GET", VideoPoll.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoPoll>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoPoll.getParser())
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
  public static VideoPoll loadJSON(String json, APIContext context, String header) {
    VideoPoll videoPoll = getGson().fromJson(json, VideoPoll.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoPoll.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoPoll.context = context;
    videoPoll.rawValue = json;
    videoPoll.header = header;
    return videoPoll;
  }

  public static APINodeList<VideoPoll> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoPoll> videoPolls = new APINodeList<VideoPoll>(request, json, header);
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
          videoPolls.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoPolls;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoPolls.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoPolls.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoPolls.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoPolls.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoPolls.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoPolls.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoPolls;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoPolls.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoPolls;
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
              videoPolls.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoPolls;
          }

          // Sixth, check if it's pure JsonObject
          videoPolls.clear();
          videoPolls.add(loadJSON(json, context, header));
          return videoPolls;
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

  public APIRequestGetPollOptions getPollOptions() {
    return new APIRequestGetPollOptions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldCloseAfterVoting() {
    return mCloseAfterVoting;
  }

  public Boolean getFieldDefaultOpen() {
    return mDefaultOpen;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldQuestion() {
    return mQuestion;
  }

  public Boolean getFieldShowGradient() {
    return mShowGradient;
  }

  public Boolean getFieldShowResults() {
    return mShowResults;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGetPollOptions extends APIRequest<APINode> {

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
               return APIRequestGetPollOptions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPollOptions(String nodeId, APIContext context) {
      super(context, nodeId, "/poll_options", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPollOptions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPollOptions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPollOptions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPollOptions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPollOptions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPollOptions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPollOptions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPollOptions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<VideoPoll> {

    VideoPoll lastResponse = null;
    @Override
    public VideoPoll getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "close_after_voting",
      "default_open",
      "id",
      "question",
      "show_gradient",
      "show_results",
      "status",
    };

    @Override
    public VideoPoll parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoPoll execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoPoll execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoPoll> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoPoll> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoPoll>() {
           public VideoPoll apply(ResponseWrapper result) {
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

    public APIRequestGet requestCloseAfterVotingField () {
      return this.requestCloseAfterVotingField(true);
    }
    public APIRequestGet requestCloseAfterVotingField (boolean value) {
      this.requestField("close_after_voting", value);
      return this;
    }
    public APIRequestGet requestDefaultOpenField () {
      return this.requestDefaultOpenField(true);
    }
    public APIRequestGet requestDefaultOpenField (boolean value) {
      this.requestField("default_open", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestQuestionField () {
      return this.requestQuestionField(true);
    }
    public APIRequestGet requestQuestionField (boolean value) {
      this.requestField("question", value);
      return this;
    }
    public APIRequestGet requestShowGradientField () {
      return this.requestShowGradientField(true);
    }
    public APIRequestGet requestShowGradientField (boolean value) {
      this.requestField("show_gradient", value);
      return this;
    }
    public APIRequestGet requestShowResultsField () {
      return this.requestShowResultsField(true);
    }
    public APIRequestGet requestShowResultsField (boolean value) {
      this.requestField("show_results", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<VideoPoll> {

    VideoPoll lastResponse = null;
    @Override
    public VideoPoll getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action",
      "close_after_voting",
      "default_open",
      "show_gradient",
      "show_results",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoPoll parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoPoll execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoPoll execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoPoll> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoPoll> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoPoll>() {
           public VideoPoll apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAction (VideoPoll.EnumAction action) {
      this.setParam("action", action);
      return this;
    }
    public APIRequestUpdate setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestUpdate setCloseAfterVoting (Boolean closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }
    public APIRequestUpdate setCloseAfterVoting (String closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }

    public APIRequestUpdate setDefaultOpen (Boolean defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }
    public APIRequestUpdate setDefaultOpen (String defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }

    public APIRequestUpdate setShowGradient (Boolean showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }
    public APIRequestUpdate setShowGradient (String showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }

    public APIRequestUpdate setShowResults (Boolean showResults) {
      this.setParam("show_results", showResults);
      return this;
    }
    public APIRequestUpdate setShowResults (String showResults) {
      this.setParam("show_results", showResults);
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
      @SerializedName("closed")
      VALUE_CLOSED("closed"),
      @SerializedName("results_open")
      VALUE_RESULTS_OPEN("results_open"),
      @SerializedName("voting_open")
      VALUE_VOTING_OPEN("voting_open"),
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

  public static enum EnumAction {
      @SerializedName("ATTACH_TO_VIDEO")
      VALUE_ATTACH_TO_VIDEO("ATTACH_TO_VIDEO"),
      @SerializedName("CLOSE")
      VALUE_CLOSE("CLOSE"),
      @SerializedName("DELETE_POLL")
      VALUE_DELETE_POLL("DELETE_POLL"),
      @SerializedName("SHOW_RESULTS")
      VALUE_SHOW_RESULTS("SHOW_RESULTS"),
      @SerializedName("SHOW_VOTING")
      VALUE_SHOW_VOTING("SHOW_VOTING"),
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

  public VideoPoll copyFrom(VideoPoll instance) {
    this.mCloseAfterVoting = instance.mCloseAfterVoting;
    this.mDefaultOpen = instance.mDefaultOpen;
    this.mId = instance.mId;
    this.mQuestion = instance.mQuestion;
    this.mShowGradient = instance.mShowGradient;
    this.mShowResults = instance.mShowResults;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoPoll> getParser() {
    return new APIRequest.ResponseParser<VideoPoll>() {
      public APINodeList<VideoPoll> parseResponse(String response, APIContext context, APIRequest<VideoPoll> request, String header) throws MalformedResponseException {
        return VideoPoll.parseResponse(response, context, request, header);
      }
    };
  }
}
