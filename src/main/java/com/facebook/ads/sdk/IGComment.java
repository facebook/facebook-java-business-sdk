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
public class IGComment extends APINode {
  @SerializedName("from")
  private IGCommentFromUser mFrom = null;
  @SerializedName("hidden")
  private Boolean mHidden = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("media")
  private IGMedia mMedia = null;
  @SerializedName("parent_id")
  private String mParentId = null;
  @SerializedName("text")
  private String mText = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("user")
  private IGUser mUser = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  IGComment() {
  }

  public IGComment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGComment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGComment fetch() throws APIException{
    IGComment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGComment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGComment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGComment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGComment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGComment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGComment>)(
      new APIRequest<IGComment>(context, "", "/", "GET", IGComment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGComment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGComment.getParser())
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
  public static IGComment loadJSON(String json, APIContext context, String header) {
    IGComment igComment = getGson().fromJson(json, IGComment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igComment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igComment.context = context;
    igComment.rawValue = json;
    igComment.header = header;
    return igComment;
  }

  public static APINodeList<IGComment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGComment> igComments = new APINodeList<IGComment>(request, json, header);
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
          igComments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igComments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igComments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igComments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igComments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igComments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igComments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igComments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igComments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igComments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igComments;
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
              igComments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igComments;
          }

          // Sixth, check if it's pure JsonObject
          igComments.clear();
          igComments.add(loadJSON(json, context, header));
          return igComments;
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

  public APIRequestGetReplies getReplies() {
    return new APIRequestGetReplies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateReply createReply() {
    return new APIRequestCreateReply(this.getPrefixedId().toString(), context);
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


  public IGCommentFromUser getFieldFrom() {
    return mFrom;
  }

  public Boolean getFieldHidden() {
    return mHidden;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public IGMedia getFieldMedia() {
    if (mMedia != null) {
      mMedia.context = getContext();
    }
    return mMedia;
  }

  public String getFieldParentId() {
    return mParentId;
  }

  public String getFieldText() {
    return mText;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public IGUser getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetReplies extends APIRequest<IGComment> {

    APINodeList<IGComment> lastResponse = null;
    @Override
    public APINodeList<IGComment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "from",
      "hidden",
      "id",
      "like_count",
      "media",
      "parent_id",
      "text",
      "timestamp",
      "user",
      "username",
    };

    @Override
    public APINodeList<IGComment> parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGComment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGComment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGComment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGComment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGComment>>() {
           public APINodeList<IGComment> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReplies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetReplies(String nodeId, APIContext context) {
      super(context, nodeId, "/replies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReplies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReplies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReplies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReplies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReplies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReplies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReplies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReplies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReplies requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetReplies requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetReplies requestHiddenField () {
      return this.requestHiddenField(true);
    }
    public APIRequestGetReplies requestHiddenField (boolean value) {
      this.requestField("hidden", value);
      return this;
    }
    public APIRequestGetReplies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReplies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReplies requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetReplies requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetReplies requestMediaField () {
      return this.requestMediaField(true);
    }
    public APIRequestGetReplies requestMediaField (boolean value) {
      this.requestField("media", value);
      return this;
    }
    public APIRequestGetReplies requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetReplies requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetReplies requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGetReplies requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
    public APIRequestGetReplies requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetReplies requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetReplies requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGetReplies requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGetReplies requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetReplies requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateReply extends APIRequest<IGComment> {

    IGComment lastResponse = null;
    @Override
    public IGComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGComment parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGComment>() {
           public IGComment apply(ResponseWrapper result) {
             try {
               return APIRequestCreateReply.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateReply(String nodeId, APIContext context) {
      super(context, nodeId, "/replies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateReply setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateReply setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateReply setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateReply requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateReply requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReply requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateReply requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReply requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateReply requestField (String field, boolean value) {
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

  public static class APIRequestGet extends APIRequest<IGComment> {

    IGComment lastResponse = null;
    @Override
    public IGComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "from",
      "hidden",
      "id",
      "like_count",
      "media",
      "parent_id",
      "text",
      "timestamp",
      "user",
      "username",
    };

    @Override
    public IGComment parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGComment>() {
           public IGComment apply(ResponseWrapper result) {
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

    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestHiddenField () {
      return this.requestHiddenField(true);
    }
    public APIRequestGet requestHiddenField (boolean value) {
      this.requestField("hidden", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGet requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGet requestMediaField () {
      return this.requestMediaField(true);
    }
    public APIRequestGet requestMediaField (boolean value) {
      this.requestField("media", value);
      return this;
    }
    public APIRequestGet requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGet requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGet requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGet requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<IGComment> {

    IGComment lastResponse = null;
    @Override
    public IGComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hide",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGComment parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGComment>() {
           public IGComment apply(ResponseWrapper result) {
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


    public APIRequestUpdate setHide (Boolean hide) {
      this.setParam("hide", hide);
      return this;
    }
    public APIRequestUpdate setHide (String hide) {
      this.setParam("hide", hide);
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

  public IGComment copyFrom(IGComment instance) {
    this.mFrom = instance.mFrom;
    this.mHidden = instance.mHidden;
    this.mId = instance.mId;
    this.mLikeCount = instance.mLikeCount;
    this.mMedia = instance.mMedia;
    this.mParentId = instance.mParentId;
    this.mText = instance.mText;
    this.mTimestamp = instance.mTimestamp;
    this.mUser = instance.mUser;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGComment> getParser() {
    return new APIRequest.ResponseParser<IGComment>() {
      public APINodeList<IGComment> parseResponse(String response, APIContext context, APIRequest<IGComment> request, String header) throws MalformedResponseException {
        return IGComment.parseResponse(response, context, request, header);
      }
    };
  }
}
