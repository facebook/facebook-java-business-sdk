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
public class Link extends APINode {
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("icon")
  private String mIcon = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("multi_share_optimized")
  private Boolean mMultiShareOptimized = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("privacy")
  private Privacy mPrivacy = null;
  @SerializedName("via")
  private Object mVia = null;
  protected static Gson gson = null;

  Link() {
  }

  public Link(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Link(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Link fetch() throws APIException{
    Link newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Link fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Link> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Link fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Link> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Link> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Link>)(
      new APIRequest<Link>(context, "", "/", "GET", Link.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Link>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Link.getParser())
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
  public static Link loadJSON(String json, APIContext context) {
    Link link = getGson().fromJson(json, Link.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(link.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    link.context = context;
    link.rawValue = json;
    return link;
  }

  public static APINodeList<Link> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Link> links = new APINodeList<Link>(request, json);
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
          links.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return links;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                links.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            links.setPaging(previous, next);
            if (context.hasAppSecret()) {
              links.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              links.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  links.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              links.add(loadJSON(obj.toString(), context));
            }
          }
          return links;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              links.add(loadJSON(entry.getValue().toString(), context));
          }
          return links;
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
              links.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return links;
          }

          // Sixth, check if it's pure JsonObject
          links.clear();
          links.add(loadJSON(json, context));
          return links;
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

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLeads getLeads() {
    return new APIRequestGetLeads(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteLikes deleteLikes() {
    return new APIRequestDeleteLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLikes getLikes() {
    return new APIRequestGetLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLike createLike() {
    return new APIRequestCreateLike(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReactions getReactions() {
    return new APIRequestGetReactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShareDPosts getShareDPosts() {
    return new APIRequestGetShareDPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCaption() {
    return mCaption;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public String getFieldIcon() {
    return mIcon;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public Boolean getFieldMultiShareOptimized() {
    return mMultiShareOptimized;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public Privacy getFieldPrivacy() {
    if (mPrivacy != null) {
      mPrivacy.context = getContext();
    }
    return mPrivacy;
  }

  public Object getFieldVia() {
    return mVia;
  }



  public static class APIRequestGetComments extends APIRequest<Comment> {

    APINodeList<Comment> lastResponse = null;
    @Override
    public APINodeList<Comment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter",
      "order",
      "live_filter",
      "since",
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
    public APINodeList<Comment> parseResponse(String response) throws APIException {
      return Comment.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Comment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Comment> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Comment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Comment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Comment>>() {
           public APINodeList<Comment> apply(String result) {
             try {
               return APIRequestGetComments.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetComments setFilter (Comment.EnumFilter filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetComments setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetComments setOrder (Comment.EnumOrder order) {
      this.setParam("order", order);
      return this;
    }
    public APIRequestGetComments setOrder (String order) {
      this.setParam("order", order);
      return this;
    }

    public APIRequestGetComments setLiveFilter (Comment.EnumLiveFilter liveFilter) {
      this.setParam("live_filter", liveFilter);
      return this;
    }
    public APIRequestGetComments setLiveFilter (String liveFilter) {
      this.setParam("live_filter", liveFilter);
      return this;
    }

    public APIRequestGetComments setSince (String since) {
      this.setParam("since", since);
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

  public static class APIRequestCreateComment extends APIRequest<Comment> {

    Comment lastResponse = null;
    @Override
    public Comment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "object_id",
      "parent_comment_id",
      "nectar_module",
      "attachment_id",
      "attachment_url",
      "attachment_share_url",
      "feedback_source",
      "facepile_mentioned_ids",
      "is_offline",
      "comment_privacy_value",
      "message",
      "text",
      "tracking",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Comment parseResponse(String response) throws APIException {
      return Comment.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Comment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Comment execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Comment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Comment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Comment>() {
           public Comment apply(String result) {
             try {
               return APIRequestCreateComment.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateComment setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestCreateComment setParentCommentId (Object parentCommentId) {
      this.setParam("parent_comment_id", parentCommentId);
      return this;
    }
    public APIRequestCreateComment setParentCommentId (String parentCommentId) {
      this.setParam("parent_comment_id", parentCommentId);
      return this;
    }

    public APIRequestCreateComment setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestCreateComment setAttachmentId (String attachmentId) {
      this.setParam("attachment_id", attachmentId);
      return this;
    }

    public APIRequestCreateComment setAttachmentUrl (String attachmentUrl) {
      this.setParam("attachment_url", attachmentUrl);
      return this;
    }

    public APIRequestCreateComment setAttachmentShareUrl (String attachmentShareUrl) {
      this.setParam("attachment_share_url", attachmentShareUrl);
      return this;
    }

    public APIRequestCreateComment setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
      return this;
    }

    public APIRequestCreateComment setFacepileMentionedIds (List<String> facepileMentionedIds) {
      this.setParam("facepile_mentioned_ids", facepileMentionedIds);
      return this;
    }
    public APIRequestCreateComment setFacepileMentionedIds (String facepileMentionedIds) {
      this.setParam("facepile_mentioned_ids", facepileMentionedIds);
      return this;
    }

    public APIRequestCreateComment setIsOffline (Boolean isOffline) {
      this.setParam("is_offline", isOffline);
      return this;
    }
    public APIRequestCreateComment setIsOffline (String isOffline) {
      this.setParam("is_offline", isOffline);
      return this;
    }

    public APIRequestCreateComment setCommentPrivacyValue (Comment.EnumCommentPrivacyValue commentPrivacyValue) {
      this.setParam("comment_privacy_value", commentPrivacyValue);
      return this;
    }
    public APIRequestCreateComment setCommentPrivacyValue (String commentPrivacyValue) {
      this.setParam("comment_privacy_value", commentPrivacyValue);
      return this;
    }

    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment setText (String text) {
      this.setParam("text", text);
      return this;
    }

    public APIRequestCreateComment setTracking (String tracking) {
      this.setParam("tracking", tracking);
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

  public static class APIRequestGetLeads extends APIRequest<Lead> {

    APINodeList<Lead> lastResponse = null;
    @Override
    public APINodeList<Lead> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "id",
      "is_organic",
      "partner_name",
      "platform",
      "post",
      "retailer_item_id",
    };

    @Override
    public APINodeList<Lead> parseResponse(String response) throws APIException {
      return Lead.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Lead> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Lead> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Lead>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Lead>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Lead>>() {
           public APINodeList<Lead> apply(String result) {
             try {
               return APIRequestGetLeads.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLeads(String nodeId, APIContext context) {
      super(context, nodeId, "/leads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLeads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLeads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLeads requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetLeads requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetLeads requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetLeads requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetLeads requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetLeads requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetLeads requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetLeads requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetLeads requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGetLeads requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGetLeads requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGetLeads requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGetLeads requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGetLeads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLeads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLeads requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGetLeads requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGetLeads requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGetLeads requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGetLeads requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetLeads requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetLeads requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGetLeads requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGetLeads requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGetLeads requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
  }

  public static class APIRequestDeleteLikes extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking",
      "nectar_module",
      "notify",
      "feedback_source",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteLikes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteLikes(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteLikes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteLikes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteLikes setTracking (String tracking) {
      this.setParam("tracking", tracking);
      return this;
    }

    public APIRequestDeleteLikes setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestDeleteLikes setNotify (Boolean notify) {
      this.setParam("notify", notify);
      return this;
    }
    public APIRequestDeleteLikes setNotify (String notify) {
      this.setParam("notify", notify);
      return this;
    }

    public APIRequestDeleteLikes setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
      return this;
    }

    public APIRequestDeleteLikes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteLikes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteLikes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLikes extends APIRequest<Profile> {

    APINodeList<Profile> lastResponse = null;
    @Override
    public APINodeList<Profile> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_post",
      "id",
      "link",
      "name",
      "pic",
      "pic_crop",
      "pic_large",
      "pic_small",
      "pic_square",
      "profile_type",
      "username",
    };

    @Override
    public APINodeList<Profile> parseResponse(String response) throws APIException {
      return Profile.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(String result) {
             try {
               return APIRequestGetLikes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLikes(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLikes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLikes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLikes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLikes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLikes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLikes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLikes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLikes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLikes requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetLikes requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetLikes requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLikes requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLikes requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetLikes requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetLikes requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLikes requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLikes requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetLikes requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetLikes requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetLikes requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetLikes requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetLikes requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetLikes requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetLikes requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetLikes requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetLikes requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetLikes requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetLikes requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetLikes requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLikes requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateLike extends APIRequest<Link> {

    Link lastResponse = null;
    @Override
    public Link getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking",
      "nectar_module",
      "notify",
      "feedback_source",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Link parseResponse(String response) throws APIException {
      return Link.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Link execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Link execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Link> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Link> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Link>() {
           public Link apply(String result) {
             try {
               return APIRequestCreateLike.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLike(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLike setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLike setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLike setTracking (String tracking) {
      this.setParam("tracking", tracking);
      return this;
    }

    public APIRequestCreateLike setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestCreateLike setNotify (Boolean notify) {
      this.setParam("notify", notify);
      return this;
    }
    public APIRequestCreateLike setNotify (String notify) {
      this.setParam("notify", notify);
      return this;
    }

    public APIRequestCreateLike setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
      return this;
    }

    public APIRequestCreateLike requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLike requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLike requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLike requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLike requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLike requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetReactions extends APIRequest<Profile> {

    APINodeList<Profile> lastResponse = null;
    @Override
    public APINodeList<Profile> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
    };

    public static final String[] FIELDS = {
      "can_post",
      "id",
      "link",
      "name",
      "pic",
      "pic_crop",
      "pic_large",
      "pic_small",
      "pic_square",
      "profile_type",
      "username",
    };

    @Override
    public APINodeList<Profile> parseResponse(String response) throws APIException {
      return Profile.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(String result) {
             try {
               return APIRequestGetReactions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReactions(String nodeId, APIContext context) {
      super(context, nodeId, "/reactions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReactions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReactions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReactions setType (Profile.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetReactions setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetReactions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReactions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReactions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReactions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReactions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReactions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReactions requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetReactions requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetReactions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReactions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReactions requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetReactions requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetReactions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetReactions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetReactions requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetReactions requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetReactions requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetReactions requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetReactions requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetReactions requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetReactions requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetReactions requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetReactions requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetReactions requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetReactions requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetReactions requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetReactions requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetReactions requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetShareDPosts extends APIRequest<Post> {

    APINodeList<Post> lastResponse = null;
    @Override
    public APINodeList<Post> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<Post> parseResponse(String response) throws APIException {
      return Post.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Post> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Post> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Post>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Post>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Post>>() {
           public APINodeList<Post> apply(String result) {
             try {
               return APIRequestGetShareDPosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetShareDPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/sharedposts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShareDPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShareDPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShareDPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShareDPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShareDPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShareDPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetShareDPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetShareDPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetShareDPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetShareDPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetShareDPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetShareDPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetShareDPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetShareDPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetShareDPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetShareDPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetShareDPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetShareDPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetShareDPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetShareDPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetShareDPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetShareDPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetShareDPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetShareDPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetShareDPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetShareDPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetShareDPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetShareDPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetShareDPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetShareDPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetShareDPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetShareDPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetShareDPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetShareDPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetShareDPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetShareDPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetShareDPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetShareDPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetShareDPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetShareDPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetShareDPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetShareDPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetShareDPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetShareDPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetShareDPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetShareDPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetShareDPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetShareDPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetShareDPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetShareDPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetShareDPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetShareDPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetShareDPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetShareDPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetShareDPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetShareDPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetShareDPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetShareDPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetShareDPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetShareDPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetShareDPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetShareDPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetShareDPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetShareDPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetShareDPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetShareDPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetShareDPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetShareDPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetShareDPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetShareDPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetShareDPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetShareDPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetShareDPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetShareDPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetShareDPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetShareDPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetShareDPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetShareDPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetShareDPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetShareDPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetShareDPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetShareDPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetShareDPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetShareDPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetShareDPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetShareDPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetShareDPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetShareDPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetShareDPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetShareDPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetShareDPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetShareDPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetShareDPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetShareDPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetShareDPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetShareDPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetShareDPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetShareDPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetShareDPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetShareDPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetShareDPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetShareDPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetShareDPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetShareDPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetShareDPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetShareDPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetShareDPosts requestWidthField (boolean value) {
      this.requestField("width", value);
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

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGet extends APIRequest<Link> {

    Link lastResponse = null;
    @Override
    public Link getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "created_time",
      "description",
      "from",
      "icon",
      "id",
      "link",
      "message",
      "multi_share_optimized",
      "name",
      "picture",
      "privacy",
      "via",
    };

    @Override
    public Link parseResponse(String response) throws APIException {
      return Link.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Link execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Link execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Link> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Link> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Link>() {
           public Link apply(String result) {
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
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGet requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGet requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGet requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGet requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGet requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGet requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGet requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
  }

  public static enum EnumUnpublishedContentType {
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      NULL(null);

      private String value;

      private EnumUnpublishedContentType(String value) {
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

  public Link copyFrom(Link instance) {
    this.mCaption = instance.mCaption;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mFrom = instance.mFrom;
    this.mIcon = instance.mIcon;
    this.mId = instance.mId;
    this.mLink = instance.mLink;
    this.mMessage = instance.mMessage;
    this.mMultiShareOptimized = instance.mMultiShareOptimized;
    this.mName = instance.mName;
    this.mPicture = instance.mPicture;
    this.mPrivacy = instance.mPrivacy;
    this.mVia = instance.mVia;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Link> getParser() {
    return new APIRequest.ResponseParser<Link>() {
      public APINodeList<Link> parseResponse(String response, APIContext context, APIRequest<Link> request) throws MalformedResponseException {
        return Link.parseResponse(response, context, request);
      }
    };
  }
}
