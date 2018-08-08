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
  private Object mApplication = null;
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
  private Object mPlace = null;
  @SerializedName("privacy")
  private Object mPrivacy = null;
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
    PagePost pagePost =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return pagePost;
  }

  public static ListenableFuture<PagePost> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<PagePost> pagePost =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return pagePost;
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
    ListenableFuture<APINodeList<PagePost>> pagePost =
      new APIRequest(context, "", "/", "GET", PagePost.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return pagePost;
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

  public Object getFieldApplication() {
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

  public Object getFieldPlace() {
    return mPlace;
  }

  public Object getFieldPrivacy() {
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

    public APIRequestUpdate setBackdatedTimeGranularity (PagePost.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
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

    public APIRequestUpdate setFeedStoryVisibility (PagePost.EnumFeedStoryVisibility feedStoryVisibility) {
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

    public APIRequestUpdate setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
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

    public APIRequestUpdate setTimelineVisibility (PagePost.EnumTimelineVisibility timelineVisibility) {
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
