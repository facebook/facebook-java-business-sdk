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
public class PagePost extends APINode {
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
  @SerializedName("can_reply_privately")
  private Boolean mCanReplyPrivately = null;
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

  PagePost() {
  }

  public PagePost(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PagePost(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PagePost fetch() throws APIException{
    PagePost newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PagePost fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PagePost> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PagePost fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PagePost> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PagePost> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PagePost>)(
      new APIRequest<PagePost>(context, "", "/", "GET", PagePost.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PagePost>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PagePost.getParser())
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
  public static PagePost loadJSON(String json, APIContext context) {
    PagePost pagePost = getGson().fromJson(json, PagePost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pagePost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    pagePost.context = context;
    pagePost.rawValue = json;
    return pagePost;
  }

  public static APINodeList<PagePost> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PagePost> pagePosts = new APINodeList<PagePost>(request, json);
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
          pagePosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pagePosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pagePosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pagePosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pagePosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pagePosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pagePosts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pagePosts.add(loadJSON(obj.toString(), context));
            }
          }
          return pagePosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pagePosts.add(loadJSON(entry.getValue().toString(), context));
          }
          return pagePosts;
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
              pagePosts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pagePosts;
          }

          // Sixth, check if it's pure JsonObject
          pagePosts.clear();
          pagePosts.add(loadJSON(json, context));
          return pagePosts;
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

  public APIRequestGetEditActions getEditActions() {
    return new APIRequestGetEditActions(this.getPrefixedId().toString(), context);
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

  public APIRequestGetShareDPosts getShareDPosts() {
    return new APIRequestGetShareDPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSponsorTags getSponsorTags() {
    return new APIRequestGetSponsorTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTo getTo() {
    return new APIRequestGetTo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetWithTags getWithTags() {
    return new APIRequestGetWithTags(this.getPrefixedId().toString(), context);
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

  public Boolean getFieldCanReplyPrivately() {
    return mCanReplyPrivately;
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
    if (mPrivacy != null) {
      mPrivacy.context = getContext();
    }
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
               return APIRequestGetAttachments.this.parseResponse(result);
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
      "message",
      "tracking",
      "nectar_module",
      "attachment_id",
      "attachment_url",
      "attachment_share_url",
      "post_id",
      "parent_comment_id",
      "comment",
      "feedback_source",
      "comment_privacy_value",
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


    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment setTracking (String tracking) {
      this.setParam("tracking", tracking);
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

    public APIRequestCreateComment setPostId (String postId) {
      this.setParam("post_id", postId);
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

    public APIRequestCreateComment setComment (String comment) {
      this.setParam("comment", comment);
      return this;
    }

    public APIRequestCreateComment setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
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
    public APINodeList<RTBDynamicPost> parseResponse(String response) throws APIException {
      return RTBDynamicPost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<RTBDynamicPost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<RTBDynamicPost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<RTBDynamicPost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<RTBDynamicPost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<RTBDynamicPost>>() {
           public APINodeList<RTBDynamicPost> apply(String result) {
             try {
               return APIRequestGetDynamicPosts.this.parseResponse(result);
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

  public static class APIRequestGetEditActions extends APIRequest<APINode> {

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
               return APIRequestGetEditActions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEditActions(String nodeId, APIContext context) {
      super(context, nodeId, "/edit_actions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEditActions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEditActions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEditActions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEditActions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEditActions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEditActions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEditActions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEditActions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "since",
      "until",
      "metric",
      "period",
      "show_permission_error",
      "date_preset",
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
    public APINodeList<InsightsResult> parseResponse(String response) throws APIException {
      return InsightsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InsightsResult>>() {
           public APINodeList<InsightsResult> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
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


    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
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

    public APIRequestGetInsights setShowPermissionError (Boolean showPermissionError) {
      this.setParam("show_permission_error", showPermissionError);
      return this;
    }
    public APIRequestGetInsights setShowPermissionError (String showPermissionError) {
      this.setParam("show_permission_error", showPermissionError);
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
      "tracking",
      "nectar_module",
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

  public static class APIRequestCreateLike extends APIRequest<PagePost> {

    PagePost lastResponse = null;
    @Override
    public PagePost getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking",
      "nectar_module",
      "feedback_source",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PagePost parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PagePost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PagePost execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PagePost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PagePost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PagePost>() {
           public PagePost apply(String result) {
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

  public static class APIRequestCreatePromotion extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "budget",
      "currency",
      "ad_account_id",
      "audience",
      "targeting",
      "start_time",
      "stop_time",
      "ad_conversion_pixel_id",
      "placement",
      "flow_id",
      "audience_id",
      "bid_amount",
      "cta_type",
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
               return APIRequestCreatePromotion.this.parseResponse(result);
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


    public APIRequestCreatePromotion setBudget (Long budget) {
      this.setParam("budget", budget);
      return this;
    }
    public APIRequestCreatePromotion setBudget (String budget) {
      this.setParam("budget", budget);
      return this;
    }

    public APIRequestCreatePromotion setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreatePromotion setAdAccountId (String adAccountId) {
      this.setParam("ad_account_id", adAccountId);
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

    public APIRequestCreatePromotion setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreatePromotion setTargeting (String targeting) {
      this.setParam("targeting", targeting);
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

    public APIRequestCreatePromotion setAdConversionPixelId (Long adConversionPixelId) {
      this.setParam("ad_conversion_pixel_id", adConversionPixelId);
      return this;
    }
    public APIRequestCreatePromotion setAdConversionPixelId (String adConversionPixelId) {
      this.setParam("ad_conversion_pixel_id", adConversionPixelId);
      return this;
    }

    public APIRequestCreatePromotion setPlacement (String placement) {
      this.setParam("placement", placement);
      return this;
    }

    public APIRequestCreatePromotion setFlowId (String flowId) {
      this.setParam("flow_id", flowId);
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

    public APIRequestCreatePromotion setCtaType (EnumCtaType ctaType) {
      this.setParam("cta_type", ctaType);
      return this;
    }
    public APIRequestCreatePromotion setCtaType (String ctaType) {
      this.setParam("cta_type", ctaType);
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
      "bio",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "employee_number",
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
      "username",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<User>>() {
           public APINodeList<User> apply(String result) {
             try {
               return APIRequestGetSeen.this.parseResponse(result);
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
    public APIRequestGetSeen requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetSeen requestBioField (boolean value) {
      this.requestField("bio", value);
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
    public APIRequestGetSeen requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetSeen requestContextField (boolean value) {
      this.requestField("context", value);
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
    public APIRequestGetSeen requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGetSeen requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
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
    public APIRequestGetSeen requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetSeen requestUsernameField (boolean value) {
      this.requestField("username", value);
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

  public static class APIRequestGetSponsorTags extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetSponsorTags.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSponsorTags(String nodeId, APIContext context) {
      super(context, nodeId, "/sponsor_tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSponsorTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSponsorTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSponsorTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSponsorTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSponsorTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSponsorTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSponsorTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSponsorTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSponsorTags requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetSponsorTags requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetSponsorTags requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetSponsorTags requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetSponsorTags requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetSponsorTags requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetSponsorTags requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetSponsorTags requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetSponsorTags requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetSponsorTags requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetSponsorTags requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetSponsorTags requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetSponsorTags requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetSponsorTags requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetSponsorTags requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetSponsorTags requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetSponsorTags requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetSponsorTags requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetSponsorTags requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetSponsorTags requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetSponsorTags requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetSponsorTags requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetSponsorTags requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetSponsorTags requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetSponsorTags requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetSponsorTags requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetSponsorTags requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetSponsorTags requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetSponsorTags requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetSponsorTags requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetSponsorTags requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetSponsorTags requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetSponsorTags requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetSponsorTags requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetSponsorTags requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetSponsorTags requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetSponsorTags requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetSponsorTags requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetSponsorTags requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetSponsorTags requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetSponsorTags requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetSponsorTags requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetSponsorTags requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetSponsorTags requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetSponsorTags requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetSponsorTags requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetSponsorTags requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetSponsorTags requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetSponsorTags requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetSponsorTags requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetSponsorTags requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetSponsorTags requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetSponsorTags requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetSponsorTags requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetSponsorTags requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetSponsorTags requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetSponsorTags requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetSponsorTags requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetSponsorTags requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetSponsorTags requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetSponsorTags requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetSponsorTags requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetSponsorTags requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetSponsorTags requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetSponsorTags requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetSponsorTags requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetSponsorTags requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetSponsorTags requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
      return this;
    }
    public APIRequestGetSponsorTags requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetSponsorTags requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetSponsorTags requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetSponsorTags requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetSponsorTags requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetSponsorTags requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetSponsorTags requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetSponsorTags requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetSponsorTags requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetSponsorTags requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetSponsorTags requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetSponsorTags requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSponsorTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSponsorTags requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetSponsorTags requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetSponsorTags requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetSponsorTags requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetSponsorTags requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetSponsorTags requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetSponsorTags requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetSponsorTags requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetSponsorTags requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetSponsorTags requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetSponsorTags requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetSponsorTags requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetSponsorTags requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetSponsorTags requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetSponsorTags requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetSponsorTags requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetSponsorTags requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetSponsorTags requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetSponsorTags requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetSponsorTags requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetSponsorTags requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetSponsorTags requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetSponsorTags requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetSponsorTags requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetSponsorTags requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetSponsorTags requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetSponsorTags requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetSponsorTags requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetSponsorTags requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetSponsorTags requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetSponsorTags requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetSponsorTags requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetSponsorTags requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetSponsorTags requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetSponsorTags requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetSponsorTags requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSponsorTags requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSponsorTags requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetSponsorTags requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetSponsorTags requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetSponsorTags requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetSponsorTags requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetSponsorTags requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetSponsorTags requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetSponsorTags requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetSponsorTags requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetSponsorTags requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetSponsorTags requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetSponsorTags requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetSponsorTags requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetSponsorTags requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetSponsorTags requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetSponsorTags requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetSponsorTags requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetSponsorTags requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetSponsorTags requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetSponsorTags requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetSponsorTags requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetSponsorTags requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetSponsorTags requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetSponsorTags requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetSponsorTags requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetSponsorTags requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetSponsorTags requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetSponsorTags requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetSponsorTags requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetSponsorTags requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetSponsorTags requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetSponsorTags requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetSponsorTags requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetSponsorTags requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetSponsorTags requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetSponsorTags requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetSponsorTags requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetSponsorTags requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetSponsorTags requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetSponsorTags requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetSponsorTags requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetSponsorTags requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetSponsorTags requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetSponsorTags requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetSponsorTags requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetSponsorTags requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetSponsorTags requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetSponsorTags requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetSponsorTags requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetSponsorTags requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetSponsorTags requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetSponsorTags requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetSponsorTags requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetSponsorTags requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetSponsorTags requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetSponsorTags requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetSponsorTags requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetSponsorTags requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetSponsorTags requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetSponsorTags requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetSponsorTags requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetSponsorTags requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetSponsorTags requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetSponsorTags requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetSponsorTags requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetSponsorTags requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetSponsorTags requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetSponsorTags requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetSponsorTags requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetSponsorTags requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetSponsorTags requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetSponsorTags requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetSponsorTags requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetSponsorTags requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetSponsorTags requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetSponsorTags requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetSponsorTags requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetSponsorTags requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetSponsorTags requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
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
               return APIRequestGetTo.this.parseResponse(result);
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

  public static class APIRequestGetWithTags extends APIRequest<Profile> {

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
               return APIRequestGetWithTags.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetWithTags(String nodeId, APIContext context) {
      super(context, nodeId, "/with_tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetWithTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetWithTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetWithTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetWithTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWithTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetWithTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWithTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetWithTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetWithTags requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetWithTags requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetWithTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetWithTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetWithTags requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetWithTags requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetWithTags requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetWithTags requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetWithTags requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetWithTags requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetWithTags requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetWithTags requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetWithTags requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetWithTags requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetWithTags requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetWithTags requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetWithTags requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetWithTags requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetWithTags requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetWithTags requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetWithTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetWithTags requestUsernameField (boolean value) {
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

  public static class APIRequestGet extends APIRequest<PagePost> {

    PagePost lastResponse = null;
    @Override
    public PagePost getLastResponse() {
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
    public PagePost parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PagePost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PagePost execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PagePost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PagePost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PagePost>() {
           public PagePost apply(String result) {
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
    public APIRequestGet requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGet requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
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

  public static class APIRequestUpdate extends APIRequest<PagePost> {

    PagePost lastResponse = null;
    @Override
    public PagePost getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "privacy",
      "composer_session_id",
      "message",
      "is_hidden",
      "is_published",
      "scheduled_publish_time",
      "is_pinned",
      "timeline_visibility",
      "feed_story_visibility",
      "backdated_time",
      "backdated_time_granularity",
      "tracking",
      "source_type",
      "attached_media",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_suggestion_mechanism",
      "og_hide_object_attachment",
      "tags",
      "og_set_profile_badge",
      "place",
      "is_explicit_location",
      "product_item",
      "should_sync_product_edit",
      "sponsor_id",
      "direct_share_status",
      "sponsor_relationship",
      "text_format_preset_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PagePost parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PagePost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PagePost execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PagePost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PagePost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PagePost>() {
           public PagePost apply(String result) {
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


    public APIRequestUpdate setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestUpdate setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestUpdate setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestUpdate setMessage (String message) {
      this.setParam("message", message);
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

    public APIRequestUpdate setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestUpdate setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
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

    public APIRequestUpdate setIsPinned (Boolean isPinned) {
      this.setParam("is_pinned", isPinned);
      return this;
    }
    public APIRequestUpdate setIsPinned (String isPinned) {
      this.setParam("is_pinned", isPinned);
      return this;
    }

    public APIRequestUpdate setTimelineVisibility (PagePost.EnumTimelineVisibility timelineVisibility) {
      this.setParam("timeline_visibility", timelineVisibility);
      return this;
    }
    public APIRequestUpdate setTimelineVisibility (String timelineVisibility) {
      this.setParam("timeline_visibility", timelineVisibility);
      return this;
    }

    public APIRequestUpdate setFeedStoryVisibility (PagePost.EnumFeedStoryVisibility feedStoryVisibility) {
      this.setParam("feed_story_visibility", feedStoryVisibility);
      return this;
    }
    public APIRequestUpdate setFeedStoryVisibility (String feedStoryVisibility) {
      this.setParam("feed_story_visibility", feedStoryVisibility);
      return this;
    }

    public APIRequestUpdate setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestUpdate setBackdatedTimeGranularity (PagePost.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestUpdate setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestUpdate setTracking (String tracking) {
      this.setParam("tracking", tracking);
      return this;
    }

    public APIRequestUpdate setSourceType (String sourceType) {
      this.setParam("source_type", sourceType);
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

    public APIRequestUpdate setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
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

    public APIRequestUpdate setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestUpdate setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
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

    public APIRequestUpdate setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestUpdate setTags (String tags) {
      this.setParam("tags", tags);
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

    public APIRequestUpdate setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestUpdate setPlace (String place) {
      this.setParam("place", place);
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

    public APIRequestUpdate setProductItem (Object productItem) {
      this.setParam("product_item", productItem);
      return this;
    }
    public APIRequestUpdate setProductItem (String productItem) {
      this.setParam("product_item", productItem);
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

    public APIRequestUpdate setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
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

    public APIRequestUpdate setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestUpdate setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestUpdate setTextFormatPresetId (String textFormatPresetId) {
      this.setParam("text_format_preset_id", textFormatPresetId);
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
      @SerializedName("year")
      VALUE_YEAR("year"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("hour")
      VALUE_HOUR("hour"),
      @SerializedName("min")
      VALUE_MIN("min"),
      @SerializedName("none")
      VALUE_NONE("none"),
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

  public static enum EnumCheckinEntryPoint {
      @SerializedName("BRANDING_CHECKIN")
      VALUE_BRANDING_CHECKIN("BRANDING_CHECKIN"),
      @SerializedName("BRANDING_STATUS")
      VALUE_BRANDING_STATUS("BRANDING_STATUS"),
      @SerializedName("BRANDING_PHOTO")
      VALUE_BRANDING_PHOTO("BRANDING_PHOTO"),
      @SerializedName("BRANDING_OTHER")
      VALUE_BRANDING_OTHER("BRANDING_OTHER"),
      NULL(null);

      private String value;

      private EnumCheckinEntryPoint(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFormatting {
      @SerializedName("PLAINTEXT")
      VALUE_PLAINTEXT("PLAINTEXT"),
      @SerializedName("MARKDOWN")
      VALUE_MARKDOWN("MARKDOWN"),
      NULL(null);

      private String value;

      private EnumFormatting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPlaceAttachmentSetting {
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      NULL(null);

      private String value;

      private EnumPlaceAttachmentSetting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPostSurfacesBlacklist {
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      @SerializedName("3")
      VALUE_3("3"),
      @SerializedName("4")
      VALUE_4("4"),
      @SerializedName("5")
      VALUE_5("5"),
      NULL(null);

      private String value;

      private EnumPostSurfacesBlacklist(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPostingToRedspace {
      @SerializedName("enabled")
      VALUE_ENABLED("enabled"),
      @SerializedName("disabled")
      VALUE_DISABLED("disabled"),
      NULL(null);

      private String value;

      private EnumPostingToRedspace(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTargetSurface {
      @SerializedName("STORY")
      VALUE_STORY("STORY"),
      @SerializedName("TIMELINE")
      VALUE_TIMELINE("TIMELINE"),
      NULL(null);

      private String value;

      private EnumTargetSurface(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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
      @SerializedName("hidden")
      VALUE_HIDDEN("hidden"),
      @SerializedName("normal")
      VALUE_NORMAL("normal"),
      @SerializedName("forced_allow")
      VALUE_FORCED_ALLOW("forced_allow"),
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

  public static enum EnumAudience {
      @SerializedName("GROUPER")
      VALUE_GROUPER("GROUPER"),
      @SerializedName("NCPP")
      VALUE_NCPP("NCPP"),
      @SerializedName("CUSTOM_AUDIENCE")
      VALUE_CUSTOM_AUDIENCE("CUSTOM_AUDIENCE"),
      @SerializedName("LOOKALIKE")
      VALUE_LOOKALIKE("LOOKALIKE"),
      @SerializedName("FANS")
      VALUE_FANS("FANS"),
      @SerializedName("LOCAL")
      VALUE_LOCAL("LOCAL"),
      @SerializedName("IG_PROMOTED_POST_AUTO")
      VALUE_IG_PROMOTED_POST_AUTO("IG_PROMOTED_POST_AUTO"),
      @SerializedName("SAVED_AUDIENCE")
      VALUE_SAVED_AUDIENCE("SAVED_AUDIENCE"),
      @SerializedName("EVENT_ENGAGEMENT")
      VALUE_EVENT_ENGAGEMENT("EVENT_ENGAGEMENT"),
      @SerializedName("DISTRICT")
      VALUE_DISTRICT("DISTRICT"),
      @SerializedName("SMART_AUDIENCE")
      VALUE_SMART_AUDIENCE("SMART_AUDIENCE"),
      @SerializedName("CREATE_NEW")
      VALUE_CREATE_NEW("CREATE_NEW"),
      @SerializedName("AUTO_LOOKALIKE")
      VALUE_AUTO_LOOKALIKE("AUTO_LOOKALIKE"),
      @SerializedName("MULT_CUSTOM_AUDIENCES")
      VALUE_MULT_CUSTOM_AUDIENCES("MULT_CUSTOM_AUDIENCES"),
      @SerializedName("EVENT_CUSTOM_AUDIENCES")
      VALUE_EVENT_CUSTOM_AUDIENCES("EVENT_CUSTOM_AUDIENCES"),
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
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("MOMENTS")
      VALUE_MOMENTS("MOMENTS"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
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

  public PagePost copyFrom(PagePost instance) {
    this.mActions = instance.mActions;
    this.mAdminCreator = instance.mAdminCreator;
    this.mAllowedAdvertisingObjectives = instance.mAllowedAdvertisingObjectives;
    this.mApplication = instance.mApplication;
    this.mBackdatedTime = instance.mBackdatedTime;
    this.mCallToAction = instance.mCallToAction;
    this.mCanReplyPrivately = instance.mCanReplyPrivately;
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

  public static APIRequest.ResponseParser<PagePost> getParser() {
    return new APIRequest.ResponseParser<PagePost>() {
      public APINodeList<PagePost> parseResponse(String response, APIContext context, APIRequest<PagePost> request) throws MalformedResponseException {
        return PagePost.parseResponse(response, context, request);
      }
    };
  }
}
