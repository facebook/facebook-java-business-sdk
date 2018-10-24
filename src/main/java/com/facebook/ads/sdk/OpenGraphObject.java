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
public class OpenGraphObject extends APINode {
  @SerializedName("admins")
  private List<Object> mAdmins = null;
  @SerializedName("application")
  private Object mApplication = null;
  @SerializedName("audio")
  private List<Object> mAudio = null;
  @SerializedName("context")
  private OpenGraphContext mContext = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("determiner")
  private String mDeterminer = null;
  @SerializedName("engagement")
  private Engagement mEngagement = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image")
  private List<Object> mImage = null;
  @SerializedName("is_scraped")
  private Boolean mIsScraped = null;
  @SerializedName("locale")
  private Object mLocale = null;
  @SerializedName("location")
  private Location mLocation = null;
  @SerializedName("post_action_id")
  private String mPostActionId = null;
  @SerializedName("profile_id")
  private Object mProfileId = null;
  @SerializedName("restrictions")
  private Object mRestrictions = null;
  @SerializedName("see_also")
  private List<String> mSeeAlso = null;
  @SerializedName("site_name")
  private String mSiteName = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("video")
  private List<Object> mVideo = null;
  protected static Gson gson = null;

  OpenGraphObject() {
  }

  public OpenGraphObject(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OpenGraphObject(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OpenGraphObject fetch() throws APIException{
    OpenGraphObject newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OpenGraphObject fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OpenGraphObject> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OpenGraphObject fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OpenGraphObject> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OpenGraphObject> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OpenGraphObject>)(
      new APIRequest<OpenGraphObject>(context, "", "/", "GET", OpenGraphObject.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OpenGraphObject>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OpenGraphObject.getParser())
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
  public static OpenGraphObject loadJSON(String json, APIContext context) {
    OpenGraphObject openGraphObject = getGson().fromJson(json, OpenGraphObject.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(openGraphObject.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    openGraphObject.context = context;
    openGraphObject.rawValue = json;
    return openGraphObject;
  }

  public static APINodeList<OpenGraphObject> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<OpenGraphObject> openGraphObjects = new APINodeList<OpenGraphObject>(request, json);
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
          openGraphObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return openGraphObjects;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                openGraphObjects.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            openGraphObjects.setPaging(previous, next);
            if (context.hasAppSecret()) {
              openGraphObjects.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              openGraphObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  openGraphObjects.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              openGraphObjects.add(loadJSON(obj.toString(), context));
            }
          }
          return openGraphObjects;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              openGraphObjects.add(loadJSON(entry.getValue().toString(), context));
          }
          return openGraphObjects;
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
              openGraphObjects.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return openGraphObjects;
          }

          // Sixth, check if it's pure JsonObject
          openGraphObjects.clear();
          openGraphObjects.add(loadJSON(json, context));
          return openGraphObjects;
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

  public APIRequestGetLikes getLikes() {
    return new APIRequestGetLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLike createLike() {
    return new APIRequestCreateLike(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReactions getReactions() {
    return new APIRequestGetReactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<Object> getFieldAdmins() {
    return mAdmins;
  }

  public Object getFieldApplication() {
    return mApplication;
  }

  public List<Object> getFieldAudio() {
    return mAudio;
  }

  public OpenGraphContext getFieldContext() {
    if (mContext != null) {
      mContext.context = getContext();
    }
    return mContext;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDeterminer() {
    return mDeterminer;
  }

  public Engagement getFieldEngagement() {
    if (mEngagement != null) {
      mEngagement.context = getContext();
    }
    return mEngagement;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldImage() {
    return mImage;
  }

  public Boolean getFieldIsScraped() {
    return mIsScraped;
  }

  public Object getFieldLocale() {
    return mLocale;
  }

  public Location getFieldLocation() {
    if (mLocation != null) {
      mLocation.context = getContext();
    }
    return mLocation;
  }

  public String getFieldPostActionId() {
    return mPostActionId;
  }

  public Object getFieldProfileId() {
    return mProfileId;
  }

  public Object getFieldRestrictions() {
    return mRestrictions;
  }

  public List<String> getFieldSeeAlso() {
    return mSeeAlso;
  }

  public String getFieldSiteName() {
    return mSiteName;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public List<Object> getFieldVideo() {
    return mVideo;
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

  public static class APIRequestCreateLike extends APIRequest<OpenGraphObject> {

    OpenGraphObject lastResponse = null;
    @Override
    public OpenGraphObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
      "url",
      "ref",
      "action",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OpenGraphObject parseResponse(String response) throws APIException {
      return OpenGraphObject.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OpenGraphObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenGraphObject execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OpenGraphObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenGraphObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OpenGraphObject>() {
           public OpenGraphObject apply(String result) {
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


    public APIRequestCreateLike setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateLike setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateLike setRef (String ref) {
      this.setParam("ref", ref);
      return this;
    }

    public APIRequestCreateLike setAction (String action) {
      this.setParam("action", action);
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

  public static class APIRequestCreatePhoto extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aid",
      "caption",
      "url",
      "uid",
      "profile_id",
      "target_id",
      "checkin_id",
      "vault_image_id",
      "tags",
      "place",
      "is_explicit_place",
      "is_explicit_location",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_suggestion_mechanism",
      "og_set_profile_badge",
      "privacy",
      "targeting",
      "feed_targeting",
      "no_story",
      "published",
      "offline_id",
      "attempt",
      "backdated_time",
      "backdated_time_granularity",
      "time_since_original_post",
      "filter_type",
      "scheduled_publish_time",
      "unpublished_content_type",
      "full_res_is_coming_later",
      "composer_session_id",
      "qn",
      "manual_privacy",
      "audience_exp",
      "proxied_app_id",
      "ios_bundle_id",
      "android_key_hash",
      "user_selected_tags",
      "allow_spherical_photo",
      "spherical_metadata",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "sponsor_id",
      "direct_share_status",
      "sponsor_relationship",
      "application_id",
      "name",
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Photo parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Photo>() {
           public Photo apply(String result) {
             try {
               return APIRequestCreatePhoto.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePhoto(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePhoto setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePhoto setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePhoto setAid (String aid) {
      this.setParam("aid", aid);
      return this;
    }

    public APIRequestCreatePhoto setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePhoto setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreatePhoto setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreatePhoto setProfileId (Long profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }
    public APIRequestCreatePhoto setProfileId (String profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }

    public APIRequestCreatePhoto setTargetId (Long targetId) {
      this.setParam("target_id", targetId);
      return this;
    }
    public APIRequestCreatePhoto setTargetId (String targetId) {
      this.setParam("target_id", targetId);
      return this;
    }

    public APIRequestCreatePhoto setCheckinId (Object checkinId) {
      this.setParam("checkin_id", checkinId);
      return this;
    }
    public APIRequestCreatePhoto setCheckinId (String checkinId) {
      this.setParam("checkin_id", checkinId);
      return this;
    }

    public APIRequestCreatePhoto setVaultImageId (String vaultImageId) {
      this.setParam("vault_image_id", vaultImageId);
      return this;
    }

    public APIRequestCreatePhoto setTags (List<Object> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreatePhoto setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreatePhoto setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreatePhoto setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitPlace (Boolean isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitPlace (String isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreatePhoto setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreatePhoto setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreatePhoto setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreatePhoto setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreatePhoto setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreatePhoto setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestCreatePhoto setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestCreatePhoto setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreatePhoto setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreatePhoto setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreatePhoto setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreatePhoto setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreatePhoto setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreatePhoto setNoStory (Boolean noStory) {
      this.setParam("no_story", noStory);
      return this;
    }
    public APIRequestCreatePhoto setNoStory (String noStory) {
      this.setParam("no_story", noStory);
      return this;
    }

    public APIRequestCreatePhoto setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreatePhoto setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreatePhoto setOfflineId (Long offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }
    public APIRequestCreatePhoto setOfflineId (String offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }

    public APIRequestCreatePhoto setAttempt (Long attempt) {
      this.setParam("attempt", attempt);
      return this;
    }
    public APIRequestCreatePhoto setAttempt (String attempt) {
      this.setParam("attempt", attempt);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTimeGranularity (Photo.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestCreatePhoto setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestCreatePhoto setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreatePhoto setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreatePhoto setFilterType (Long filterType) {
      this.setParam("filter_type", filterType);
      return this;
    }
    public APIRequestCreatePhoto setFilterType (String filterType) {
      this.setParam("filter_type", filterType);
      return this;
    }

    public APIRequestCreatePhoto setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreatePhoto setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreatePhoto setUnpublishedContentType (Photo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreatePhoto setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreatePhoto setFullResIsComingLater (Boolean fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }
    public APIRequestCreatePhoto setFullResIsComingLater (String fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }

    public APIRequestCreatePhoto setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreatePhoto setQn (String qn) {
      this.setParam("qn", qn);
      return this;
    }

    public APIRequestCreatePhoto setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreatePhoto setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreatePhoto setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreatePhoto setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreatePhoto setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreatePhoto setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreatePhoto setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreatePhoto setUserSelectedTags (Boolean userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }
    public APIRequestCreatePhoto setUserSelectedTags (String userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }

    public APIRequestCreatePhoto setAllowSphericalPhoto (Boolean allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }
    public APIRequestCreatePhoto setAllowSphericalPhoto (String allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }

    public APIRequestCreatePhoto setSphericalMetadata (Map<String, String> sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }
    public APIRequestCreatePhoto setSphericalMetadata (String sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (Long initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (String initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (Long initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (String initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (Long initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (String initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreatePhoto setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreatePhoto setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreatePhoto setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreatePhoto setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreatePhoto setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreatePhoto setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePhoto setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreatePhoto requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePhoto requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPicture extends APIRequest<ProfilePictureSource> {

    APINodeList<ProfilePictureSource> lastResponse = null;
    @Override
    public APINodeList<ProfilePictureSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
      "redirect",
    };

    public static final String[] FIELDS = {
      "bottom",
      "cache_key",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "uri",
      "url",
      "width",
      "id",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProfilePictureSource>>() {
           public APINodeList<ProfilePictureSource> apply(String result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPicture setType (ProfilePictureSource.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetPicture setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }
    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
      return this;
    }

    public APIRequestGetPicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPicture requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGetPicture requestBottomField (boolean value) {
      this.requestField("bottom", value);
      return this;
    }
    public APIRequestGetPicture requestCacheKeyField () {
      return this.requestCacheKeyField(true);
    }
    public APIRequestGetPicture requestCacheKeyField (boolean value) {
      this.requestField("cache_key", value);
      return this;
    }
    public APIRequestGetPicture requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPicture requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPicture requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGetPicture requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGetPicture requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGetPicture requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGetPicture requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGetPicture requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGetPicture requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGetPicture requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGetPicture requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGetPicture requestUriField (boolean value) {
      this.requestField("uri", value);
      return this;
    }
    public APIRequestGetPicture requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPicture requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetPicture requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPicture requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
    public APIRequestGetPicture requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPicture requestIdField (boolean value) {
      this.requestField("id", value);
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

  public static class APIRequestGet extends APIRequest<OpenGraphObject> {

    OpenGraphObject lastResponse = null;
    @Override
    public OpenGraphObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "admins",
      "application",
      "audio",
      "context",
      "created_time",
      "description",
      "determiner",
      "engagement",
      "id",
      "image",
      "is_scraped",
      "locale",
      "location",
      "post_action_id",
      "profile_id",
      "restrictions",
      "see_also",
      "site_name",
      "title",
      "type",
      "updated_time",
      "url",
      "video",
    };

    @Override
    public OpenGraphObject parseResponse(String response) throws APIException {
      return OpenGraphObject.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OpenGraphObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenGraphObject execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OpenGraphObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenGraphObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OpenGraphObject>() {
           public OpenGraphObject apply(String result) {
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

    public APIRequestGet requestAdminsField () {
      return this.requestAdminsField(true);
    }
    public APIRequestGet requestAdminsField (boolean value) {
      this.requestField("admins", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestAudioField () {
      return this.requestAudioField(true);
    }
    public APIRequestGet requestAudioField (boolean value) {
      this.requestField("audio", value);
      return this;
    }
    public APIRequestGet requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGet requestContextField (boolean value) {
      this.requestField("context", value);
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
    public APIRequestGet requestDeterminerField () {
      return this.requestDeterminerField(true);
    }
    public APIRequestGet requestDeterminerField (boolean value) {
      this.requestField("determiner", value);
      return this;
    }
    public APIRequestGet requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGet requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageField () {
      return this.requestImageField(true);
    }
    public APIRequestGet requestImageField (boolean value) {
      this.requestField("image", value);
      return this;
    }
    public APIRequestGet requestIsScrapedField () {
      return this.requestIsScrapedField(true);
    }
    public APIRequestGet requestIsScrapedField (boolean value) {
      this.requestField("is_scraped", value);
      return this;
    }
    public APIRequestGet requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGet requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestPostActionIdField () {
      return this.requestPostActionIdField(true);
    }
    public APIRequestGet requestPostActionIdField (boolean value) {
      this.requestField("post_action_id", value);
      return this;
    }
    public APIRequestGet requestProfileIdField () {
      return this.requestProfileIdField(true);
    }
    public APIRequestGet requestProfileIdField (boolean value) {
      this.requestField("profile_id", value);
      return this;
    }
    public APIRequestGet requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGet requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGet requestSeeAlsoField () {
      return this.requestSeeAlsoField(true);
    }
    public APIRequestGet requestSeeAlsoField (boolean value) {
      this.requestField("see_also", value);
      return this;
    }
    public APIRequestGet requestSiteNameField () {
      return this.requestSiteNameField(true);
    }
    public APIRequestGet requestSiteNameField (boolean value) {
      this.requestField("site_name", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGet requestVideoField (boolean value) {
      this.requestField("video", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<OpenGraphObject> {

    OpenGraphObject lastResponse = null;
    @Override
    public OpenGraphObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "locale",
      "object",
      "action_properties",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OpenGraphObject parseResponse(String response) throws APIException {
      return OpenGraphObject.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OpenGraphObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenGraphObject execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OpenGraphObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenGraphObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OpenGraphObject>() {
           public OpenGraphObject apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setLocale (Object locale) {
      this.setParam("locale", locale);
      return this;
    }
    public APIRequestUpdate setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestUpdate setObject (Object object) {
      this.setParam("object", object);
      return this;
    }
    public APIRequestUpdate setObject (String object) {
      this.setParam("object", object);
      return this;
    }

    public APIRequestUpdate setActionProperties (Object actionProperties) {
      this.setParam("action_properties", actionProperties);
      return this;
    }
    public APIRequestUpdate setActionProperties (String actionProperties) {
      this.setParam("action_properties", actionProperties);
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

  public OpenGraphObject copyFrom(OpenGraphObject instance) {
    this.mAdmins = instance.mAdmins;
    this.mApplication = instance.mApplication;
    this.mAudio = instance.mAudio;
    this.mContext = instance.mContext;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mDeterminer = instance.mDeterminer;
    this.mEngagement = instance.mEngagement;
    this.mId = instance.mId;
    this.mImage = instance.mImage;
    this.mIsScraped = instance.mIsScraped;
    this.mLocale = instance.mLocale;
    this.mLocation = instance.mLocation;
    this.mPostActionId = instance.mPostActionId;
    this.mProfileId = instance.mProfileId;
    this.mRestrictions = instance.mRestrictions;
    this.mSeeAlso = instance.mSeeAlso;
    this.mSiteName = instance.mSiteName;
    this.mTitle = instance.mTitle;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUrl = instance.mUrl;
    this.mVideo = instance.mVideo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OpenGraphObject> getParser() {
    return new APIRequest.ResponseParser<OpenGraphObject>() {
      public APINodeList<OpenGraphObject> parseResponse(String response, APIContext context, APIRequest<OpenGraphObject> request) throws MalformedResponseException {
        return OpenGraphObject.parseResponse(response, context, request);
      }
    };
  }
}
