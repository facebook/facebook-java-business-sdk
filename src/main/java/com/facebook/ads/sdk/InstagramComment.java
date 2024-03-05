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
public class InstagramComment extends APINode {
  @SerializedName("comment_type")
  private String mCommentType = null;
  @SerializedName("created_at")
  private String mCreatedAt = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instagram_comment_id")
  private String mInstagramCommentId = null;
  @SerializedName("instagram_user")
  private InstagramUser mInstagramUser = null;
  @SerializedName("mentioned_instagram_users")
  private List<InstagramUser> mMentionedInstagramUsers = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  InstagramComment() {
  }

  public InstagramComment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstagramComment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstagramComment fetch() throws APIException{
    InstagramComment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstagramComment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstagramComment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstagramComment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstagramComment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstagramComment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstagramComment>)(
      new APIRequest<InstagramComment>(context, "", "/", "GET", InstagramComment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstagramComment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstagramComment.getParser())
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
  public static InstagramComment loadJSON(String json, APIContext context, String header) {
    InstagramComment instagramComment = getGson().fromJson(json, InstagramComment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramComment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramComment.context = context;
    instagramComment.rawValue = json;
    instagramComment.header = header;
    return instagramComment;
  }

  public static APINodeList<InstagramComment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramComment> instagramComments = new APINodeList<InstagramComment>(request, json, header);
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
          instagramComments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramComments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramComments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramComments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramComments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramComments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramComments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramComments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramComments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramComments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramComments;
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
              instagramComments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramComments;
          }

          // Sixth, check if it's pure JsonObject
          instagramComments.clear();
          instagramComments.add(loadJSON(json, context, header));
          return instagramComments;
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


  public String getFieldCommentType() {
    return mCommentType;
  }

  public String getFieldCreatedAt() {
    return mCreatedAt;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstagramCommentId() {
    return mInstagramCommentId;
  }

  public InstagramUser getFieldInstagramUser() {
    if (mInstagramUser != null) {
      mInstagramUser.context = getContext();
    }
    return mInstagramUser;
  }

  public List<InstagramUser> getFieldMentionedInstagramUsers() {
    return mMentionedInstagramUsers;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetReplies extends APIRequest<InstagramComment> {

    APINodeList<InstagramComment> lastResponse = null;
    @Override
    public APINodeList<InstagramComment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "comment_type",
      "created_at",
      "id",
      "instagram_comment_id",
      "instagram_user",
      "mentioned_instagram_users",
      "message",
      "username",
    };

    @Override
    public APINodeList<InstagramComment> parseResponse(String response, String header) throws APIException {
      return InstagramComment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramComment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramComment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramComment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramComment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramComment>>() {
           public APINodeList<InstagramComment> apply(ResponseWrapper result) {
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

    public APIRequestGetReplies requestCommentTypeField () {
      return this.requestCommentTypeField(true);
    }
    public APIRequestGetReplies requestCommentTypeField (boolean value) {
      this.requestField("comment_type", value);
      return this;
    }
    public APIRequestGetReplies requestCreatedAtField () {
      return this.requestCreatedAtField(true);
    }
    public APIRequestGetReplies requestCreatedAtField (boolean value) {
      this.requestField("created_at", value);
      return this;
    }
    public APIRequestGetReplies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReplies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReplies requestInstagramCommentIdField () {
      return this.requestInstagramCommentIdField(true);
    }
    public APIRequestGetReplies requestInstagramCommentIdField (boolean value) {
      this.requestField("instagram_comment_id", value);
      return this;
    }
    public APIRequestGetReplies requestInstagramUserField () {
      return this.requestInstagramUserField(true);
    }
    public APIRequestGetReplies requestInstagramUserField (boolean value) {
      this.requestField("instagram_user", value);
      return this;
    }
    public APIRequestGetReplies requestMentionedInstagramUsersField () {
      return this.requestMentionedInstagramUsersField(true);
    }
    public APIRequestGetReplies requestMentionedInstagramUsersField (boolean value) {
      this.requestField("mentioned_instagram_users", value);
      return this;
    }
    public APIRequestGetReplies requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetReplies requestMessageField (boolean value) {
      this.requestField("message", value);
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

  public static class APIRequestCreateReply extends APIRequest<InstagramComment> {

    InstagramComment lastResponse = null;
    @Override
    public InstagramComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_id",
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public InstagramComment parseResponse(String response, String header) throws APIException {
      return InstagramComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramComment>() {
           public InstagramComment apply(ResponseWrapper result) {
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


    public APIRequestCreateReply setAdId (String adId) {
      this.setParam("ad_id", adId);
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
      "ad_id",
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


    public APIRequestDelete setAdId (String adId) {
      this.setParam("ad_id", adId);
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

  public static class APIRequestGet extends APIRequest<InstagramComment> {

    InstagramComment lastResponse = null;
    @Override
    public InstagramComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "comment_type",
      "created_at",
      "id",
      "instagram_comment_id",
      "instagram_user",
      "mentioned_instagram_users",
      "message",
      "username",
    };

    @Override
    public InstagramComment parseResponse(String response, String header) throws APIException {
      return InstagramComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramComment>() {
           public InstagramComment apply(ResponseWrapper result) {
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

    public APIRequestGet requestCommentTypeField () {
      return this.requestCommentTypeField(true);
    }
    public APIRequestGet requestCommentTypeField (boolean value) {
      this.requestField("comment_type", value);
      return this;
    }
    public APIRequestGet requestCreatedAtField () {
      return this.requestCreatedAtField(true);
    }
    public APIRequestGet requestCreatedAtField (boolean value) {
      this.requestField("created_at", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInstagramCommentIdField () {
      return this.requestInstagramCommentIdField(true);
    }
    public APIRequestGet requestInstagramCommentIdField (boolean value) {
      this.requestField("instagram_comment_id", value);
      return this;
    }
    public APIRequestGet requestInstagramUserField () {
      return this.requestInstagramUserField(true);
    }
    public APIRequestGet requestInstagramUserField (boolean value) {
      this.requestField("instagram_user", value);
      return this;
    }
    public APIRequestGet requestMentionedInstagramUsersField () {
      return this.requestMentionedInstagramUsersField(true);
    }
    public APIRequestGet requestMentionedInstagramUsersField (boolean value) {
      this.requestField("mentioned_instagram_users", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
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

  public static class APIRequestUpdate extends APIRequest<InstagramComment> {

    InstagramComment lastResponse = null;
    @Override
    public InstagramComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_id",
      "hide",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public InstagramComment parseResponse(String response, String header) throws APIException {
      return InstagramComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramComment>() {
           public InstagramComment apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAdId (String adId) {
      this.setParam("ad_id", adId);
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

  public InstagramComment copyFrom(InstagramComment instance) {
    this.mCommentType = instance.mCommentType;
    this.mCreatedAt = instance.mCreatedAt;
    this.mId = instance.mId;
    this.mInstagramCommentId = instance.mInstagramCommentId;
    this.mInstagramUser = instance.mInstagramUser;
    this.mMentionedInstagramUsers = instance.mMentionedInstagramUsers;
    this.mMessage = instance.mMessage;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramComment> getParser() {
    return new APIRequest.ResponseParser<InstagramComment>() {
      public APINodeList<InstagramComment> parseResponse(String response, APIContext context, APIRequest<InstagramComment> request, String header) throws MalformedResponseException {
        return InstagramComment.parseResponse(response, context, request, header);
      }
    };
  }
}
