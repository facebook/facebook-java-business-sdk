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
public class IGMediaForIGOnlyAPI extends APINode {
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("comments_count")
  private Long mCommentsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_comment_enabled")
  private Boolean mIsCommentEnabled = null;
  @SerializedName("is_shared_to_feed")
  private Boolean mIsSharedToFeed = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("media_product_type")
  private String mMediaProductType = null;
  @SerializedName("media_type")
  private String mMediaType = null;
  @SerializedName("media_url")
  private String mMediaUrl = null;
  @SerializedName("owner")
  private User mOwner = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  @SerializedName("shortcode")
  private String mShortcode = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  IGMediaForIGOnlyAPI() {
  }

  public IGMediaForIGOnlyAPI(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGMediaForIGOnlyAPI(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGMediaForIGOnlyAPI fetch() throws APIException{
    IGMediaForIGOnlyAPI newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGMediaForIGOnlyAPI fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGMediaForIGOnlyAPI> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGMediaForIGOnlyAPI fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGMediaForIGOnlyAPI> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGMediaForIGOnlyAPI> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGMediaForIGOnlyAPI>)(
      new APIRequest<IGMediaForIGOnlyAPI>(context, "", "/", "GET", IGMediaForIGOnlyAPI.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGMediaForIGOnlyAPI>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGMediaForIGOnlyAPI.getParser())
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
  public static IGMediaForIGOnlyAPI loadJSON(String json, APIContext context, String header) {
    IGMediaForIGOnlyAPI igMediaForIGOnlyAPI = getGson().fromJson(json, IGMediaForIGOnlyAPI.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igMediaForIGOnlyAPI.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igMediaForIGOnlyAPI.context = context;
    igMediaForIGOnlyAPI.rawValue = json;
    igMediaForIGOnlyAPI.header = header;
    return igMediaForIGOnlyAPI;
  }

  public static APINodeList<IGMediaForIGOnlyAPI> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGMediaForIGOnlyAPI> igMediaForIGOnlyAPIs = new APINodeList<IGMediaForIGOnlyAPI>(request, json, header);
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
          igMediaForIGOnlyAPIs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igMediaForIGOnlyAPIs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igMediaForIGOnlyAPIs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igMediaForIGOnlyAPIs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igMediaForIGOnlyAPIs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igMediaForIGOnlyAPIs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igMediaForIGOnlyAPIs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igMediaForIGOnlyAPIs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igMediaForIGOnlyAPIs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igMediaForIGOnlyAPIs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igMediaForIGOnlyAPIs;
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
              igMediaForIGOnlyAPIs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igMediaForIGOnlyAPIs;
          }

          // Sixth, check if it's pure JsonObject
          igMediaForIGOnlyAPIs.clear();
          igMediaForIGOnlyAPIs.add(loadJSON(json, context, header));
          return igMediaForIGOnlyAPIs;
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

  public APIRequestGetChildren getChildren() {
    return new APIRequestGetChildren(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldCaption() {
    return mCaption;
  }

  public Long getFieldCommentsCount() {
    return mCommentsCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsCommentEnabled() {
    return mIsCommentEnabled;
  }

  public Boolean getFieldIsSharedToFeed() {
    return mIsSharedToFeed;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public String getFieldMediaProductType() {
    return mMediaProductType;
  }

  public String getFieldMediaType() {
    return mMediaType;
  }

  public String getFieldMediaUrl() {
    return mMediaUrl;
  }

  public User getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public String getFieldShortcode() {
    return mShortcode;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetChildren extends APIRequest<APINode> {

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
               return APIRequestGetChildren.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetChildren(String nodeId, APIContext context) {
      super(context, nodeId, "/children", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChildren setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChildren setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChildren requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChildren requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChildren requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChildren requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChildren requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChildren requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetComments extends APIRequest<Comment> {

    APINodeList<Comment> lastResponse = null;
    @Override
    public APINodeList<Comment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "admin_creator",
      "application",
      "attachment",
      "can_comment",
      "can_hide",
      "can_like",
      "can_remove",
      "can_reply_privately",
      "comment_count",
      "created_time",
      "from",
      "id",
      "is_hidden",
      "is_private",
      "like_count",
      "live_broadcast_timestamp",
      "message",
      "message_tags",
      "object",
      "parent",
      "permalink_url",
      "private_reply_conversation",
      "user_likes",
    };

    @Override
    public APINodeList<Comment> parseResponse(String response, String header) throws APIException {
      return Comment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Comment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Comment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Comment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Comment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Comment>>() {
           public APINodeList<Comment> apply(ResponseWrapper result) {
             try {
               return APIRequestGetComments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetComments(String nodeId, APIContext context) {
      super(context, nodeId, "/comments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetComments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetComments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetComments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetComments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetComments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetComments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetComments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetComments requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetComments requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetComments requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetComments requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetComments requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetComments requestAttachmentField () {
      return this.requestAttachmentField(true);
    }
    public APIRequestGetComments requestAttachmentField (boolean value) {
      this.requestField("attachment", value);
      return this;
    }
    public APIRequestGetComments requestCanCommentField () {
      return this.requestCanCommentField(true);
    }
    public APIRequestGetComments requestCanCommentField (boolean value) {
      this.requestField("can_comment", value);
      return this;
    }
    public APIRequestGetComments requestCanHideField () {
      return this.requestCanHideField(true);
    }
    public APIRequestGetComments requestCanHideField (boolean value) {
      this.requestField("can_hide", value);
      return this;
    }
    public APIRequestGetComments requestCanLikeField () {
      return this.requestCanLikeField(true);
    }
    public APIRequestGetComments requestCanLikeField (boolean value) {
      this.requestField("can_like", value);
      return this;
    }
    public APIRequestGetComments requestCanRemoveField () {
      return this.requestCanRemoveField(true);
    }
    public APIRequestGetComments requestCanRemoveField (boolean value) {
      this.requestField("can_remove", value);
      return this;
    }
    public APIRequestGetComments requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetComments requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetComments requestCommentCountField () {
      return this.requestCommentCountField(true);
    }
    public APIRequestGetComments requestCommentCountField (boolean value) {
      this.requestField("comment_count", value);
      return this;
    }
    public APIRequestGetComments requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetComments requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetComments requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetComments requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetComments requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetComments requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetComments requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetComments requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetComments requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetComments requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetComments requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetComments requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetComments requestLiveBroadcastTimestampField () {
      return this.requestLiveBroadcastTimestampField(true);
    }
    public APIRequestGetComments requestLiveBroadcastTimestampField (boolean value) {
      this.requestField("live_broadcast_timestamp", value);
      return this;
    }
    public APIRequestGetComments requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetComments requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetComments requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetComments requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetComments requestObjectField () {
      return this.requestObjectField(true);
    }
    public APIRequestGetComments requestObjectField (boolean value) {
      this.requestField("object", value);
      return this;
    }
    public APIRequestGetComments requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGetComments requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGetComments requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetComments requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetComments requestPrivateReplyConversationField () {
      return this.requestPrivateReplyConversationField(true);
    }
    public APIRequestGetComments requestPrivateReplyConversationField (boolean value) {
      this.requestField("private_reply_conversation", value);
      return this;
    }
    public APIRequestGetComments requestUserLikesField () {
      return this.requestUserLikesField(true);
    }
    public APIRequestGetComments requestUserLikesField (boolean value) {
      this.requestField("user_likes", value);
      return this;
    }
  }

  public static class APIRequestCreateComment extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
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
               return APIRequestCreateComment.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateComment(String nodeId, APIContext context) {
      super(context, nodeId, "/comments", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateComment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateComment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateComment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateComment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateComment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateComment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateComment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<IGMediaForIGOnlyAPI> {

    IGMediaForIGOnlyAPI lastResponse = null;
    @Override
    public IGMediaForIGOnlyAPI getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public IGMediaForIGOnlyAPI parseResponse(String response, String header) throws APIException {
      return IGMediaForIGOnlyAPI.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMediaForIGOnlyAPI execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMediaForIGOnlyAPI execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMediaForIGOnlyAPI> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMediaForIGOnlyAPI> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMediaForIGOnlyAPI>() {
           public IGMediaForIGOnlyAPI apply(ResponseWrapper result) {
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

    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGet requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGet requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGet requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGet requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGet requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGet requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGet requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGet requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGet requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGet requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGet requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGet requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGet requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGet requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGet requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
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

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_enabled",
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


    public APIRequestUpdate setCommentEnabled (Boolean commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
      return this;
    }
    public APIRequestUpdate setCommentEnabled (String commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
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

  public IGMediaForIGOnlyAPI copyFrom(IGMediaForIGOnlyAPI instance) {
    this.mCaption = instance.mCaption;
    this.mCommentsCount = instance.mCommentsCount;
    this.mId = instance.mId;
    this.mIsCommentEnabled = instance.mIsCommentEnabled;
    this.mIsSharedToFeed = instance.mIsSharedToFeed;
    this.mLikeCount = instance.mLikeCount;
    this.mMediaProductType = instance.mMediaProductType;
    this.mMediaType = instance.mMediaType;
    this.mMediaUrl = instance.mMediaUrl;
    this.mOwner = instance.mOwner;
    this.mPermalink = instance.mPermalink;
    this.mShortcode = instance.mShortcode;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTimestamp = instance.mTimestamp;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGMediaForIGOnlyAPI> getParser() {
    return new APIRequest.ResponseParser<IGMediaForIGOnlyAPI>() {
      public APINodeList<IGMediaForIGOnlyAPI> parseResponse(String response, APIContext context, APIRequest<IGMediaForIGOnlyAPI> request, String header) throws MalformedResponseException {
        return IGMediaForIGOnlyAPI.parseResponse(response, context, request, header);
      }
    };
  }
}
