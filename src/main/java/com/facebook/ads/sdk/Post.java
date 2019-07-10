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
public class Post extends APINode {
  @SerializedName("actions")
  private JsonArray mActions = null;
  @SerializedName("admin_creator")
  private Object mAdminCreator = null;
  @SerializedName("allowed_advertising_objectives")
  private List<String> mAllowedAdvertisingObjectives = null;
  @SerializedName("application")
  private Application mApplication = null;
  @SerializedName("backdated_time")
  private String mBackdatedTime = null;
  @SerializedName("call_to_action")
  private Object mCallToAction = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("child_attachments")
  private JsonArray mChildAttachments = null;
  @SerializedName("comments_mirroring_domain")
  private String mCommentsMirroringDomain = null;
  @SerializedName("coordinates")
  private Object mCoordinates = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("event")
  private Event mEvent = null;
  @SerializedName("expanded_height")
  private Long mExpandedHeight = null;
  @SerializedName("expanded_width")
  private Long mExpandedWidth = null;
  @SerializedName("feed_targeting")
  private Object mFeedTargeting = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("full_picture")
  private String mFullPicture = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("icon")
  private String mIcon = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instagram_eligibility")
  private String mInstagramEligibility = null;
  @SerializedName("is_app_share")
  private Boolean mIsAppShare = null;
  @SerializedName("is_eligible_for_promotion")
  private Boolean mIsEligibleForPromotion = null;
  @SerializedName("is_expired")
  private Boolean mIsExpired = null;
  @SerializedName("is_hidden")
  private Boolean mIsHidden = null;
  @SerializedName("is_instagram_eligible")
  private Boolean mIsInstagramEligible = null;
  @SerializedName("is_popular")
  private Boolean mIsPopular = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("is_spherical")
  private Boolean mIsSpherical = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("message_tags")
  private JsonArray mMessageTags = null;
  @SerializedName("multi_share_end_card")
  private Boolean mMultiShareEndCard = null;
  @SerializedName("multi_share_optimized")
  private Boolean mMultiShareOptimized = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("parent_id")
  private String mParentId = null;
  @SerializedName("permalink_url")
  private Object mPermalinkUrl = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("place")
  private Place mPlace = null;
  @SerializedName("privacy")
  private Privacy mPrivacy = null;
  @SerializedName("promotable_id")
  private String mPromotableId = null;
  @SerializedName("promotion_status")
  private String mPromotionStatus = null;
  @SerializedName("properties")
  private JsonArray mProperties = null;
  @SerializedName("scheduled_publish_time")
  private Double mScheduledPublishTime = null;
  @SerializedName("shares")
  private Object mShares = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("status_type")
  private String mStatusType = null;
  @SerializedName("story")
  private String mStory = null;
  @SerializedName("story_tags")
  private JsonArray mStoryTags = null;
  @SerializedName("subscribed")
  private Boolean mSubscribed = null;
  @SerializedName("target")
  private Profile mTarget = null;
  @SerializedName("targeting")
  private Object mTargeting = null;
  @SerializedName("timeline_visibility")
  private String mTimelineVisibility = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("via")
  private Object mVia = null;
  @SerializedName("video_buying_eligibility")
  private List<String> mVideoBuyingEligibility = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  Post() {
  }

  public Post(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Post(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Post fetch() throws APIException{
    Post newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Post fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Post> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Post fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Post> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Post> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Post>)(
      new APIRequest<Post>(context, "", "/", "GET", Post.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Post>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Post.getParser())
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
  public static Post loadJSON(String json, APIContext context, String header) {
    Post post = getGson().fromJson(json, Post.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(post.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    post.context = context;
    post.rawValue = json;
    post.header = header;
    return post;
  }

  public static APINodeList<Post> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Post> posts = new APINodeList<Post>(request, json, header);
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
          posts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return posts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                posts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            posts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              posts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              posts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  posts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              posts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return posts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              posts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return posts;
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
              posts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return posts;
          }

          // Sixth, check if it's pure JsonObject
          posts.clear();
          posts.add(loadJSON(json, context, header));
          return posts;
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

  public APIRequestGetAttachments getAttachments() {
    return new APIRequestGetAttachments(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDynamicPosts getDynamicPosts() {
    return new APIRequestGetDynamicPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
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

  public APIRequestCreatePromotion createPromotion() {
    return new APIRequestCreatePromotion(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReactions getReactions() {
    return new APIRequestGetReactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSeen getSeen() {
    return new APIRequestGetSeen(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSharedPosts getSharedPosts() {
    return new APIRequestGetSharedPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTo getTo() {
    return new APIRequestGetTo(this.getPrefixedId().toString(), context);
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


  public JsonArray getFieldActions() {
    return mActions;
  }

  public Object getFieldAdminCreator() {
    return mAdminCreator;
  }

  public List<String> getFieldAllowedAdvertisingObjectives() {
    return mAllowedAdvertisingObjectives;
  }

  public Application getFieldApplication() {
    if (mApplication != null) {
      mApplication.context = getContext();
    }
    return mApplication;
  }

  public String getFieldBackdatedTime() {
    return mBackdatedTime;
  }

  public Object getFieldCallToAction() {
    return mCallToAction;
  }

  public String getFieldCaption() {
    return mCaption;
  }

  public JsonArray getFieldChildAttachments() {
    return mChildAttachments;
  }

  public String getFieldCommentsMirroringDomain() {
    return mCommentsMirroringDomain;
  }

  public Object getFieldCoordinates() {
    return mCoordinates;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Event getFieldEvent() {
    if (mEvent != null) {
      mEvent.context = getContext();
    }
    return mEvent;
  }

  public Long getFieldExpandedHeight() {
    return mExpandedHeight;
  }

  public Long getFieldExpandedWidth() {
    return mExpandedWidth;
  }

  public Object getFieldFeedTargeting() {
    return mFeedTargeting;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public String getFieldFullPicture() {
    return mFullPicture;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public String getFieldIcon() {
    return mIcon;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstagramEligibility() {
    return mInstagramEligibility;
  }

  public Boolean getFieldIsAppShare() {
    return mIsAppShare;
  }

  public Boolean getFieldIsEligibleForPromotion() {
    return mIsEligibleForPromotion;
  }

  public Boolean getFieldIsExpired() {
    return mIsExpired;
  }

  public Boolean getFieldIsHidden() {
    return mIsHidden;
  }

  public Boolean getFieldIsInstagramEligible() {
    return mIsInstagramEligible;
  }

  public Boolean getFieldIsPopular() {
    return mIsPopular;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public Boolean getFieldIsSpherical() {
    return mIsSpherical;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public JsonArray getFieldMessageTags() {
    return mMessageTags;
  }

  public Boolean getFieldMultiShareEndCard() {
    return mMultiShareEndCard;
  }

  public Boolean getFieldMultiShareOptimized() {
    return mMultiShareOptimized;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public String getFieldParentId() {
    return mParentId;
  }

  public Object getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public Privacy getFieldPrivacy() {
    return mPrivacy;
  }

  public String getFieldPromotableId() {
    return mPromotableId;
  }

  public String getFieldPromotionStatus() {
    return mPromotionStatus;
  }

  public JsonArray getFieldProperties() {
    return mProperties;
  }

  public Double getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public Object getFieldShares() {
    return mShares;
  }

  public String getFieldSource() {
    return mSource;
  }

  public String getFieldStatusType() {
    return mStatusType;
  }

  public String getFieldStory() {
    return mStory;
  }

  public JsonArray getFieldStoryTags() {
    return mStoryTags;
  }

  public Boolean getFieldSubscribed() {
    return mSubscribed;
  }

  public Profile getFieldTarget() {
    if (mTarget != null) {
      mTarget.context = getContext();
    }
    return mTarget;
  }

  public Object getFieldTargeting() {
    return mTargeting;
  }

  public String getFieldTimelineVisibility() {
    return mTimelineVisibility;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public Object getFieldVia() {
    return mVia;
  }

  public List<String> getFieldVideoBuyingEligibility() {
    return mVideoBuyingEligibility;
  }

  public Long getFieldWidth() {
    return mWidth;
  }



  public static class APIRequestGetAttachments extends APIRequest<APINode> {

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
               return APIRequestGetAttachments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAttachments(String nodeId, APIContext context) {
      super(context, nodeId, "/attachments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAttachments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAttachments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAttachments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAttachments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAttachments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAttachments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAttachments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAttachments requestField (String field, boolean value) {
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
      "filter",
      "live_filter",
      "order",
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

    public APIRequestGetComments setLiveFilter (Comment.EnumLiveFilter liveFilter) {
      this.setParam("live_filter", liveFilter);
      return this;
    }
    public APIRequestGetComments setLiveFilter (String liveFilter) {
      this.setParam("live_filter", liveFilter);
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
      "attachment_id",
      "attachment_share_url",
      "attachment_url",
      "comment",
      "comment_privacy_value",
      "feedback_source",
      "message",
      "nectar_module",
      "parent_comment_id",
      "post_id",
      "tracking",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Comment parseResponse(String response, String header) throws APIException {
      return Comment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Comment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Comment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Comment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Comment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Comment>() {
           public Comment apply(ResponseWrapper result) {
             try {
               return APIRequestCreateComment.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestCreateComment setAttachmentId (String attachmentId) {
      this.setParam("attachment_id", attachmentId);
      return this;
    }

    public APIRequestCreateComment setAttachmentShareUrl (String attachmentShareUrl) {
      this.setParam("attachment_share_url", attachmentShareUrl);
      return this;
    }

    public APIRequestCreateComment setAttachmentUrl (String attachmentUrl) {
      this.setParam("attachment_url", attachmentUrl);
      return this;
    }

    public APIRequestCreateComment setComment (String comment) {
      this.setParam("comment", comment);
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

    public APIRequestCreateComment setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
      return this;
    }

    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
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

    public APIRequestCreateComment setPostId (String postId) {
      this.setParam("post_id", postId);
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

  public static class APIRequestGetDynamicPosts extends APIRequest<RTBDynamicPost> {

    APINodeList<RTBDynamicPost> lastResponse = null;
    @Override
    public APINodeList<RTBDynamicPost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "child_attachments",
      "created",
      "description",
      "id",
      "image_url",
      "link",
      "message",
      "owner_id",
      "place_id",
      "product_id",
      "title",
    };

    @Override
    public APINodeList<RTBDynamicPost> parseResponse(String response, String header) throws APIException {
      return RTBDynamicPost.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<RTBDynamicPost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<RTBDynamicPost> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<RTBDynamicPost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<RTBDynamicPost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<RTBDynamicPost>>() {
           public APINodeList<RTBDynamicPost> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDynamicPosts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDynamicPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/dynamic_posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDynamicPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDynamicPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDynamicPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDynamicPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDynamicPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDynamicPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDynamicPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDynamicPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDynamicPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetDynamicPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestCreatedField () {
      return this.requestCreatedField(true);
    }
    public APIRequestGetDynamicPosts requestCreatedField (boolean value) {
      this.requestField("created", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDynamicPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDynamicPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetDynamicPosts requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetDynamicPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetDynamicPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGetDynamicPosts requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestPlaceIdField () {
      return this.requestPlaceIdField(true);
    }
    public APIRequestGetDynamicPosts requestPlaceIdField (boolean value) {
      this.requestField("place_id", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetDynamicPosts requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetDynamicPosts requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetDynamicPosts requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
  }

  public static class APIRequestGetInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "metric",
      "period",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "description_from_api_doc",
      "id",
      "name",
      "period",
      "title",
      "values",
    };

    @Override
    public APINodeList<InsightsResult> parseResponse(String response, String header) throws APIException {
      return InsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InsightsResult>>() {
           public APINodeList<InsightsResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setDatePreset (InsightsResult.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setMetric (List<Object> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setPeriod (InsightsResult.EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetInsights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetInsights requestDescriptionFromApiDocField () {
      return this.requestDescriptionFromApiDocField(true);
    }
    public APIRequestGetInsights requestDescriptionFromApiDocField (boolean value) {
      this.requestField("description_from_api_doc", value);
      return this;
    }
    public APIRequestGetInsights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInsights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInsights requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGetInsights requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGetInsights requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetInsights requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetInsights requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetInsights requestValuesField (boolean value) {
      this.requestField("values", value);
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
      "nectar_module",
      "tracking",
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
               return APIRequestDeleteLikes.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestDeleteLikes setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestDeleteLikes setTracking (String tracking) {
      this.setParam("tracking", tracking);
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
    public APINodeList<Profile> parseResponse(String response, String header) throws APIException {
      return Profile.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLikes.this.parseResponse(result.getBody(), result.getHeader());
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

  public static class APIRequestCreateLike extends APIRequest<Post> {

    Post lastResponse = null;
    @Override
    public Post getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "feedback_source",
      "nectar_module",
      "tracking",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Post parseResponse(String response, String header) throws APIException {
      return Post.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Post execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Post execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Post> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Post> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Post>() {
           public Post apply(ResponseWrapper result) {
             try {
               return APIRequestCreateLike.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestCreateLike setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
      return this;
    }

    public APIRequestCreateLike setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestCreateLike setTracking (String tracking) {
      this.setParam("tracking", tracking);
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

  public static class APIRequestCreatePromotion extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account_id",
      "ad_conversion_pixel_id",
      "audience",
      "audience_id",
      "bid_amount",
      "budget",
      "cta_type",
      "currency",
      "flow_id",
      "placement",
      "start_time",
      "stop_time",
      "targeting",
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
               return APIRequestCreatePromotion.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePromotion(String nodeId, APIContext context) {
      super(context, nodeId, "/promotions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePromotion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePromotion setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePromotion setAdAccountId (String adAccountId) {
      this.setParam("ad_account_id", adAccountId);
      return this;
    }

    public APIRequestCreatePromotion setAdConversionPixelId (Long adConversionPixelId) {
      this.setParam("ad_conversion_pixel_id", adConversionPixelId);
      return this;
    }
    public APIRequestCreatePromotion setAdConversionPixelId (String adConversionPixelId) {
      this.setParam("ad_conversion_pixel_id", adConversionPixelId);
      return this;
    }

    public APIRequestCreatePromotion setAudience (EnumAudience audience) {
      this.setParam("audience", audience);
      return this;
    }
    public APIRequestCreatePromotion setAudience (String audience) {
      this.setParam("audience", audience);
      return this;
    }

    public APIRequestCreatePromotion setAudienceId (String audienceId) {
      this.setParam("audience_id", audienceId);
      return this;
    }

    public APIRequestCreatePromotion setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestCreatePromotion setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreatePromotion setBudget (Long budget) {
      this.setParam("budget", budget);
      return this;
    }
    public APIRequestCreatePromotion setBudget (String budget) {
      this.setParam("budget", budget);
      return this;
    }

    public APIRequestCreatePromotion setCtaType (EnumCtaType ctaType) {
      this.setParam("cta_type", ctaType);
      return this;
    }
    public APIRequestCreatePromotion setCtaType (String ctaType) {
      this.setParam("cta_type", ctaType);
      return this;
    }

    public APIRequestCreatePromotion setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreatePromotion setFlowId (String flowId) {
      this.setParam("flow_id", flowId);
      return this;
    }

    public APIRequestCreatePromotion setPlacement (String placement) {
      this.setParam("placement", placement);
      return this;
    }

    public APIRequestCreatePromotion setStartTime (Long startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestCreatePromotion setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreatePromotion setStopTime (Long stopTime) {
      this.setParam("stop_time", stopTime);
      return this;
    }
    public APIRequestCreatePromotion setStopTime (String stopTime) {
      this.setParam("stop_time", stopTime);
      return this;
    }

    public APIRequestCreatePromotion setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreatePromotion setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreatePromotion requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePromotion requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePromotion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePromotion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePromotion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePromotion requestField (String field, boolean value) {
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
    public APINodeList<Profile> parseResponse(String response, String header) throws APIException {
      return Profile.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReactions.this.parseResponse(result.getBody(), result.getHeader());
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

  public static class APIRequestGetSeen extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_shared_login",
      "is_verified",
      "labels",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSeen.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSeen(String nodeId, APIContext context) {
      super(context, nodeId, "/seen", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSeen setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSeen setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSeen requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSeen requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSeen requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSeen requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSeen requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSeen requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSeen requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetSeen requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetSeen requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetSeen requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetSeen requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetSeen requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetSeen requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetSeen requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetSeen requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetSeen requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetSeen requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetSeen requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetSeen requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetSeen requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetSeen requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetSeen requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetSeen requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetSeen requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetSeen requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetSeen requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetSeen requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetSeen requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetSeen requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetSeen requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetSeen requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetSeen requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetSeen requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetSeen requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetSeen requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetSeen requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetSeen requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetSeen requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetSeen requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetSeen requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetSeen requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSeen requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSeen requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetSeen requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetSeen requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetSeen requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetSeen requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetSeen requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetSeen requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetSeen requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetSeen requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetSeen requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetSeen requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetSeen requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetSeen requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetSeen requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetSeen requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetSeen requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetSeen requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetSeen requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetSeen requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetSeen requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetSeen requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetSeen requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetSeen requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetSeen requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetSeen requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetSeen requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetSeen requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetSeen requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetSeen requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetSeen requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetSeen requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetSeen requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetSeen requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetSeen requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetSeen requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSeen requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSeen requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetSeen requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetSeen requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetSeen requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetSeen requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetSeen requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetSeen requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetSeen requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetSeen requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetSeen requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetSeen requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetSeen requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetSeen requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetSeen requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetSeen requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetSeen requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetSeen requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetSeen requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetSeen requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetSeen requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetSeen requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetSeen requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetSeen requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetSeen requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetSeen requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetSeen requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetSeen requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetSeen requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetSeen requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetSeen requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetSeen requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetSeen requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetSeen requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetSeen requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetSeen requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetSeen requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetSeen requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetSeen requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetSeen requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetSeen requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetSeen requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetSeen requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetSeen requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetSeen requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetSeen requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetSeen requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetSharedPosts extends APIRequest<Post> {

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
      "is_eligible_for_promotion",
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
    public APINodeList<Post> parseResponse(String response, String header) throws APIException {
      return Post.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Post> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Post> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Post>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Post>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Post>>() {
           public APINodeList<Post> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSharedPosts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSharedPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/sharedposts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSharedPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSharedPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSharedPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSharedPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSharedPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSharedPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSharedPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSharedPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSharedPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetSharedPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetSharedPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetSharedPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetSharedPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetSharedPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetSharedPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetSharedPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetSharedPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetSharedPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetSharedPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetSharedPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetSharedPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetSharedPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetSharedPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetSharedPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetSharedPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetSharedPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetSharedPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetSharedPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetSharedPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetSharedPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetSharedPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetSharedPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetSharedPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetSharedPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetSharedPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetSharedPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetSharedPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetSharedPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetSharedPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetSharedPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetSharedPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetSharedPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetSharedPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetSharedPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetSharedPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetSharedPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetSharedPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSharedPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSharedPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetSharedPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetSharedPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsEligibleForPromotionField () {
      return this.requestIsEligibleForPromotionField(true);
    }
    public APIRequestGetSharedPosts requestIsEligibleForPromotionField (boolean value) {
      this.requestField("is_eligible_for_promotion", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetSharedPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetSharedPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetSharedPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetSharedPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetSharedPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetSharedPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetSharedPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetSharedPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetSharedPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetSharedPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetSharedPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetSharedPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetSharedPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetSharedPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetSharedPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetSharedPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetSharedPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetSharedPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSharedPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSharedPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetSharedPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetSharedPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetSharedPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetSharedPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetSharedPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetSharedPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetSharedPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetSharedPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetSharedPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetSharedPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetSharedPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetSharedPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetSharedPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetSharedPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetSharedPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetSharedPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetSharedPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetSharedPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetSharedPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetSharedPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetSharedPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetSharedPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetSharedPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetSharedPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetSharedPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetSharedPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetSharedPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetSharedPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetSharedPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetSharedPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetSharedPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetSharedPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetSharedPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetSharedPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetSharedPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetSharedPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetSharedPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetSharedPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetSharedPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetSharedPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetSharedPosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGetTo extends APIRequest<Profile> {

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
    public APINodeList<Profile> parseResponse(String response, String header) throws APIException {
      return Profile.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTo(String nodeId, APIContext context) {
      super(context, nodeId, "/to", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTo requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetTo requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetTo requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTo requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTo requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetTo requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetTo requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTo requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTo requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetTo requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetTo requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetTo requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetTo requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetTo requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetTo requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetTo requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetTo requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetTo requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetTo requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetTo requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetTo requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTo requestUsernameField (boolean value) {
      this.requestField("username", value);
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

  public static class APIRequestGet extends APIRequest<Post> {

    Post lastResponse = null;
    @Override
    public Post getLastResponse() {
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
      "is_eligible_for_promotion",
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
    public Post parseResponse(String response, String header) throws APIException {
      return Post.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Post execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Post execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Post> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Post> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Post>() {
           public Post apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGet requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGet requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGet requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGet requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGet requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGet requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGet requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGet requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGet requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGet requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGet requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGet requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGet requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
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
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGet requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGet requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGet requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGet requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGet requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGet requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGet requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGet requestHeightField (boolean value) {
      this.requestField("height", value);
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
    public APIRequestGet requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGet requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGet requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGet requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGet requestIsEligibleForPromotionField () {
      return this.requestIsEligibleForPromotionField(true);
    }
    public APIRequestGet requestIsEligibleForPromotionField (boolean value) {
      this.requestField("is_eligible_for_promotion", value);
      return this;
    }
    public APIRequestGet requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGet requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGet requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGet requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGet requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGet requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGet requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGet requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGet requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
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
    public APIRequestGet requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGet requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGet requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGet requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
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
    public APIRequestGet requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGet requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGet requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGet requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGet requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGet requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGet requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGet requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGet requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGet requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGet requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGet requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGet requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGet requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGet requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGet requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGet requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGet requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGet requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGet requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGet requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGet requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGet requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGet requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGet requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGet requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGet requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGet requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGet requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGet requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGet requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGet requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGet requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGet requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGet requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
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
    public APIRequestGet requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGet requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGet requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGet requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGet requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGet requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Post> {

    Post lastResponse = null;
    @Override
    public Post getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "attached_media",
      "backdated_time",
      "backdated_time_granularity",
      "composer_session_id",
      "direct_share_status",
      "feed_story_visibility",
      "is_explicit_location",
      "is_hidden",
      "is_pinned",
      "is_published",
      "message",
      "og_action_type_id",
      "og_hide_object_attachment",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "place",
      "privacy",
      "product_item",
      "scheduled_publish_time",
      "should_sync_product_edit",
      "source_type",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "text_format_preset_id",
      "timeline_visibility",
      "tracking",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Post parseResponse(String response, String header) throws APIException {
      return Post.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Post execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Post execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Post> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Post> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Post>() {
           public Post apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestUpdate setAttachedMedia (List<Object> attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }
    public APIRequestUpdate setAttachedMedia (String attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }

    public APIRequestUpdate setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestUpdate setBackdatedTimeGranularity (Post.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestUpdate setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestUpdate setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestUpdate setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestUpdate setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestUpdate setFeedStoryVisibility (Post.EnumFeedStoryVisibility feedStoryVisibility) {
      this.setParam("feed_story_visibility", feedStoryVisibility);
      return this;
    }
    public APIRequestUpdate setFeedStoryVisibility (String feedStoryVisibility) {
      this.setParam("feed_story_visibility", feedStoryVisibility);
      return this;
    }

    public APIRequestUpdate setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestUpdate setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestUpdate setIsHidden (Boolean isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }
    public APIRequestUpdate setIsHidden (String isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }

    public APIRequestUpdate setIsPinned (Boolean isPinned) {
      this.setParam("is_pinned", isPinned);
      return this;
    }
    public APIRequestUpdate setIsPinned (String isPinned) {
      this.setParam("is_pinned", isPinned);
      return this;
    }

    public APIRequestUpdate setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestUpdate setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestUpdate setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestUpdate setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestUpdate setOgHideObjectAttachment (Boolean ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }
    public APIRequestUpdate setOgHideObjectAttachment (String ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }

    public APIRequestUpdate setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestUpdate setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestUpdate setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestUpdate setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestUpdate setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestUpdate setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestUpdate setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestUpdate setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestUpdate setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestUpdate setProductItem (Object productItem) {
      this.setParam("product_item", productItem);
      return this;
    }
    public APIRequestUpdate setProductItem (String productItem) {
      this.setParam("product_item", productItem);
      return this;
    }

    public APIRequestUpdate setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestUpdate setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestUpdate setShouldSyncProductEdit (Boolean shouldSyncProductEdit) {
      this.setParam("should_sync_product_edit", shouldSyncProductEdit);
      return this;
    }
    public APIRequestUpdate setShouldSyncProductEdit (String shouldSyncProductEdit) {
      this.setParam("should_sync_product_edit", shouldSyncProductEdit);
      return this;
    }

    public APIRequestUpdate setSourceType (String sourceType) {
      this.setParam("source_type", sourceType);
      return this;
    }

    public APIRequestUpdate setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestUpdate setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestUpdate setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestUpdate setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestUpdate setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestUpdate setTextFormatPresetId (String textFormatPresetId) {
      this.setParam("text_format_preset_id", textFormatPresetId);
      return this;
    }

    public APIRequestUpdate setTimelineVisibility (Post.EnumTimelineVisibility timelineVisibility) {
      this.setParam("timeline_visibility", timelineVisibility);
      return this;
    }
    public APIRequestUpdate setTimelineVisibility (String timelineVisibility) {
      this.setParam("timeline_visibility", timelineVisibility);
      return this;
    }

    public APIRequestUpdate setTracking (String tracking) {
      this.setParam("tracking", tracking);
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

  public static enum EnumBackdatedTimeGranularity {
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("hour")
      VALUE_HOUR("hour"),
      @SerializedName("min")
      VALUE_MIN("min"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("year")
      VALUE_YEAR("year"),
      NULL(null);

      private String value;

      private EnumBackdatedTimeGranularity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFeedStoryVisibility {
      @SerializedName("hidden")
      VALUE_HIDDEN("hidden"),
      @SerializedName("visible")
      VALUE_VISIBLE("visible"),
      NULL(null);

      private String value;

      private EnumFeedStoryVisibility(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimelineVisibility {
      @SerializedName("forced_allow")
      VALUE_FORCED_ALLOW("forced_allow"),
      @SerializedName("hidden")
      VALUE_HIDDEN("hidden"),
      @SerializedName("normal")
      VALUE_NORMAL("normal"),
      NULL(null);

      private String value;

      private EnumTimelineVisibility(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumWith {
      @SerializedName("LOCATION")
      VALUE_LOCATION("LOCATION"),
      NULL(null);

      private String value;

      private EnumWith(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAudience {
      @SerializedName("AUTO_LOOKALIKE")
      VALUE_AUTO_LOOKALIKE("AUTO_LOOKALIKE"),
      @SerializedName("AUTO_PAGE_LOOKALIKE")
      VALUE_AUTO_PAGE_LOOKALIKE("AUTO_PAGE_LOOKALIKE"),
      @SerializedName("AUTO_TARGETING")
      VALUE_AUTO_TARGETING("AUTO_TARGETING"),
      @SerializedName("CREATE_NEW")
      VALUE_CREATE_NEW("CREATE_NEW"),
      @SerializedName("CUSTOM_AUDIENCE")
      VALUE_CUSTOM_AUDIENCE("CUSTOM_AUDIENCE"),
      @SerializedName("DISTRICT")
      VALUE_DISTRICT("DISTRICT"),
      @SerializedName("EVENT_CUSTOM_AUDIENCES")
      VALUE_EVENT_CUSTOM_AUDIENCES("EVENT_CUSTOM_AUDIENCES"),
      @SerializedName("EVENT_ENGAGEMENT")
      VALUE_EVENT_ENGAGEMENT("EVENT_ENGAGEMENT"),
      @SerializedName("FANS")
      VALUE_FANS("FANS"),
      @SerializedName("GROUPER")
      VALUE_GROUPER("GROUPER"),
      @SerializedName("HEC_AUDIENCE")
      VALUE_HEC_AUDIENCE("HEC_AUDIENCE"),
      @SerializedName("IG_PROMOTED_POST_AUTO")
      VALUE_IG_PROMOTED_POST_AUTO("IG_PROMOTED_POST_AUTO"),
      @SerializedName("LOCAL")
      VALUE_LOCAL("LOCAL"),
      @SerializedName("LOOKALIKE")
      VALUE_LOOKALIKE("LOOKALIKE"),
      @SerializedName("MULT_CUSTOM_AUDIENCES")
      VALUE_MULT_CUSTOM_AUDIENCES("MULT_CUSTOM_AUDIENCES"),
      @SerializedName("NCPP")
      VALUE_NCPP("NCPP"),
      @SerializedName("SAVED_AUDIENCE")
      VALUE_SAVED_AUDIENCE("SAVED_AUDIENCE"),
      @SerializedName("SMART_AUDIENCE")
      VALUE_SMART_AUDIENCE("SMART_AUDIENCE"),
      NULL(null);

      private String value;

      private EnumAudience(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCtaType {
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("FIND_A_GROUP")
      VALUE_FIND_A_GROUP("FIND_A_GROUP"),
      @SerializedName("FIND_YOUR_GROUPS")
      VALUE_FIND_YOUR_GROUPS("FIND_YOUR_GROUPS"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("MOMENTS")
      VALUE_MOMENTS("MOMENTS"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SEE_MORE")
      VALUE_SEE_MORE("SEE_MORE"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("SOTTO_SUBSCRIBE")
      VALUE_SOTTO_SUBSCRIBE("SOTTO_SUBSCRIBE"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      NULL(null);

      private String value;

      private EnumCtaType(String value) {
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

  public Post copyFrom(Post instance) {
    this.mActions = instance.mActions;
    this.mAdminCreator = instance.mAdminCreator;
    this.mAllowedAdvertisingObjectives = instance.mAllowedAdvertisingObjectives;
    this.mApplication = instance.mApplication;
    this.mBackdatedTime = instance.mBackdatedTime;
    this.mCallToAction = instance.mCallToAction;
    this.mCaption = instance.mCaption;
    this.mChildAttachments = instance.mChildAttachments;
    this.mCommentsMirroringDomain = instance.mCommentsMirroringDomain;
    this.mCoordinates = instance.mCoordinates;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEvent = instance.mEvent;
    this.mExpandedHeight = instance.mExpandedHeight;
    this.mExpandedWidth = instance.mExpandedWidth;
    this.mFeedTargeting = instance.mFeedTargeting;
    this.mFrom = instance.mFrom;
    this.mFullPicture = instance.mFullPicture;
    this.mHeight = instance.mHeight;
    this.mIcon = instance.mIcon;
    this.mId = instance.mId;
    this.mInstagramEligibility = instance.mInstagramEligibility;
    this.mIsAppShare = instance.mIsAppShare;
    this.mIsEligibleForPromotion = instance.mIsEligibleForPromotion;
    this.mIsExpired = instance.mIsExpired;
    this.mIsHidden = instance.mIsHidden;
    this.mIsInstagramEligible = instance.mIsInstagramEligible;
    this.mIsPopular = instance.mIsPopular;
    this.mIsPublished = instance.mIsPublished;
    this.mIsSpherical = instance.mIsSpherical;
    this.mLink = instance.mLink;
    this.mMessage = instance.mMessage;
    this.mMessageTags = instance.mMessageTags;
    this.mMultiShareEndCard = instance.mMultiShareEndCard;
    this.mMultiShareOptimized = instance.mMultiShareOptimized;
    this.mName = instance.mName;
    this.mObjectId = instance.mObjectId;
    this.mParentId = instance.mParentId;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPicture = instance.mPicture;
    this.mPlace = instance.mPlace;
    this.mPrivacy = instance.mPrivacy;
    this.mPromotableId = instance.mPromotableId;
    this.mPromotionStatus = instance.mPromotionStatus;
    this.mProperties = instance.mProperties;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mShares = instance.mShares;
    this.mSource = instance.mSource;
    this.mStatusType = instance.mStatusType;
    this.mStory = instance.mStory;
    this.mStoryTags = instance.mStoryTags;
    this.mSubscribed = instance.mSubscribed;
    this.mTarget = instance.mTarget;
    this.mTargeting = instance.mTargeting;
    this.mTimelineVisibility = instance.mTimelineVisibility;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVia = instance.mVia;
    this.mVideoBuyingEligibility = instance.mVideoBuyingEligibility;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Post> getParser() {
    return new APIRequest.ResponseParser<Post>() {
      public APINodeList<Post> parseResponse(String response, APIContext context, APIRequest<Post> request, String header) throws MalformedResponseException {
        return Post.parseResponse(response, context, request, header);
      }
    };
  }
}
