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

  public Post() {
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


  public JsonArray getFieldActions() {
    return mActions;
  }

  public Post setFieldActions(JsonArray value) {
    this.mActions = value;
    return this;
  }

  public Object getFieldAdminCreator() {
    return mAdminCreator;
  }

  public Post setFieldAdminCreator(Object value) {
    this.mAdminCreator = value;
    return this;
  }

  public List<String> getFieldAllowedAdvertisingObjectives() {
    return mAllowedAdvertisingObjectives;
  }

  public Post setFieldAllowedAdvertisingObjectives(List<String> value) {
    this.mAllowedAdvertisingObjectives = value;
    return this;
  }

  public Application getFieldApplication() {
    if (mApplication != null) {
      mApplication.context = getContext();
    }
    return mApplication;
  }

  public Post setFieldApplication(Application value) {
    this.mApplication = value;
    return this;
  }

  public Post setFieldApplication(String value) {
    Type type = new TypeToken<Application>(){}.getType();
    this.mApplication = Application.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldBackdatedTime() {
    return mBackdatedTime;
  }

  public Post setFieldBackdatedTime(String value) {
    this.mBackdatedTime = value;
    return this;
  }

  public Object getFieldCallToAction() {
    return mCallToAction;
  }

  public Post setFieldCallToAction(Object value) {
    this.mCallToAction = value;
    return this;
  }

  public Boolean getFieldCanReplyPrivately() {
    return mCanReplyPrivately;
  }

  public Post setFieldCanReplyPrivately(Boolean value) {
    this.mCanReplyPrivately = value;
    return this;
  }

  public String getFieldCaption() {
    return mCaption;
  }

  public Post setFieldCaption(String value) {
    this.mCaption = value;
    return this;
  }

  public JsonArray getFieldChildAttachments() {
    return mChildAttachments;
  }

  public Post setFieldChildAttachments(JsonArray value) {
    this.mChildAttachments = value;
    return this;
  }

  public String getFieldCommentsMirroringDomain() {
    return mCommentsMirroringDomain;
  }

  public Post setFieldCommentsMirroringDomain(String value) {
    this.mCommentsMirroringDomain = value;
    return this;
  }

  public Object getFieldCoordinates() {
    return mCoordinates;
  }

  public Post setFieldCoordinates(Object value) {
    this.mCoordinates = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Post setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Post setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public Event getFieldEvent() {
    if (mEvent != null) {
      mEvent.context = getContext();
    }
    return mEvent;
  }

  public Post setFieldEvent(Event value) {
    this.mEvent = value;
    return this;
  }

  public Post setFieldEvent(String value) {
    Type type = new TypeToken<Event>(){}.getType();
    this.mEvent = Event.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldExpandedHeight() {
    return mExpandedHeight;
  }

  public Post setFieldExpandedHeight(Long value) {
    this.mExpandedHeight = value;
    return this;
  }

  public Long getFieldExpandedWidth() {
    return mExpandedWidth;
  }

  public Post setFieldExpandedWidth(Long value) {
    this.mExpandedWidth = value;
    return this;
  }

  public Object getFieldFeedTargeting() {
    return mFeedTargeting;
  }

  public Post setFieldFeedTargeting(Object value) {
    this.mFeedTargeting = value;
    return this;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public Post setFieldFrom(Object value) {
    this.mFrom = value;
    return this;
  }

  public String getFieldFullPicture() {
    return mFullPicture;
  }

  public Post setFieldFullPicture(String value) {
    this.mFullPicture = value;
    return this;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public Post setFieldHeight(Long value) {
    this.mHeight = value;
    return this;
  }

  public String getFieldIcon() {
    return mIcon;
  }

  public Post setFieldIcon(String value) {
    this.mIcon = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public Post setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldInstagramEligibility() {
    return mInstagramEligibility;
  }

  public Post setFieldInstagramEligibility(String value) {
    this.mInstagramEligibility = value;
    return this;
  }

  public Boolean getFieldIsAppShare() {
    return mIsAppShare;
  }

  public Post setFieldIsAppShare(Boolean value) {
    this.mIsAppShare = value;
    return this;
  }

  public Boolean getFieldIsEligibleForPromotion() {
    return mIsEligibleForPromotion;
  }

  public Post setFieldIsEligibleForPromotion(Boolean value) {
    this.mIsEligibleForPromotion = value;
    return this;
  }

  public Boolean getFieldIsExpired() {
    return mIsExpired;
  }

  public Post setFieldIsExpired(Boolean value) {
    this.mIsExpired = value;
    return this;
  }

  public Boolean getFieldIsHidden() {
    return mIsHidden;
  }

  public Post setFieldIsHidden(Boolean value) {
    this.mIsHidden = value;
    return this;
  }

  public Boolean getFieldIsInstagramEligible() {
    return mIsInstagramEligible;
  }

  public Post setFieldIsInstagramEligible(Boolean value) {
    this.mIsInstagramEligible = value;
    return this;
  }

  public Boolean getFieldIsPopular() {
    return mIsPopular;
  }

  public Post setFieldIsPopular(Boolean value) {
    this.mIsPopular = value;
    return this;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public Post setFieldIsPublished(Boolean value) {
    this.mIsPublished = value;
    return this;
  }

  public Boolean getFieldIsSpherical() {
    return mIsSpherical;
  }

  public Post setFieldIsSpherical(Boolean value) {
    this.mIsSpherical = value;
    return this;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Post setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public Post setFieldMessage(String value) {
    this.mMessage = value;
    return this;
  }

  public JsonArray getFieldMessageTags() {
    return mMessageTags;
  }

  public Post setFieldMessageTags(JsonArray value) {
    this.mMessageTags = value;
    return this;
  }

  public Boolean getFieldMultiShareEndCard() {
    return mMultiShareEndCard;
  }

  public Post setFieldMultiShareEndCard(Boolean value) {
    this.mMultiShareEndCard = value;
    return this;
  }

  public Boolean getFieldMultiShareOptimized() {
    return mMultiShareOptimized;
  }

  public Post setFieldMultiShareOptimized(Boolean value) {
    this.mMultiShareOptimized = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public Post setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public Post setFieldObjectId(String value) {
    this.mObjectId = value;
    return this;
  }

  public String getFieldParentId() {
    return mParentId;
  }

  public Post setFieldParentId(String value) {
    this.mParentId = value;
    return this;
  }

  public Object getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public Post setFieldPermalinkUrl(Object value) {
    this.mPermalinkUrl = value;
    return this;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public Post setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public Post setFieldPlace(Place value) {
    this.mPlace = value;
    return this;
  }

  public Post setFieldPlace(String value) {
    Type type = new TypeToken<Place>(){}.getType();
    this.mPlace = Place.getGson().fromJson(value, type);
    return this;
  }
  public Privacy getFieldPrivacy() {
    return mPrivacy;
  }

  public Post setFieldPrivacy(Privacy value) {
    this.mPrivacy = value;
    return this;
  }

  public Post setFieldPrivacy(String value) {
    Type type = new TypeToken<Privacy>(){}.getType();
    this.mPrivacy = Privacy.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPromotableId() {
    return mPromotableId;
  }

  public Post setFieldPromotableId(String value) {
    this.mPromotableId = value;
    return this;
  }

  public String getFieldPromotionStatus() {
    return mPromotionStatus;
  }

  public Post setFieldPromotionStatus(String value) {
    this.mPromotionStatus = value;
    return this;
  }

  public JsonArray getFieldProperties() {
    return mProperties;
  }

  public Post setFieldProperties(JsonArray value) {
    this.mProperties = value;
    return this;
  }

  public Double getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public Post setFieldScheduledPublishTime(Double value) {
    this.mScheduledPublishTime = value;
    return this;
  }

  public Object getFieldShares() {
    return mShares;
  }

  public Post setFieldShares(Object value) {
    this.mShares = value;
    return this;
  }

  public String getFieldSource() {
    return mSource;
  }

  public Post setFieldSource(String value) {
    this.mSource = value;
    return this;
  }

  public String getFieldStatusType() {
    return mStatusType;
  }

  public Post setFieldStatusType(String value) {
    this.mStatusType = value;
    return this;
  }

  public String getFieldStory() {
    return mStory;
  }

  public Post setFieldStory(String value) {
    this.mStory = value;
    return this;
  }

  public JsonArray getFieldStoryTags() {
    return mStoryTags;
  }

  public Post setFieldStoryTags(JsonArray value) {
    this.mStoryTags = value;
    return this;
  }

  public Boolean getFieldSubscribed() {
    return mSubscribed;
  }

  public Post setFieldSubscribed(Boolean value) {
    this.mSubscribed = value;
    return this;
  }

  public Profile getFieldTarget() {
    if (mTarget != null) {
      mTarget.context = getContext();
    }
    return mTarget;
  }

  public Post setFieldTarget(Profile value) {
    this.mTarget = value;
    return this;
  }

  public Post setFieldTarget(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mTarget = Profile.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldTargeting() {
    return mTargeting;
  }

  public Post setFieldTargeting(Object value) {
    this.mTargeting = value;
    return this;
  }

  public String getFieldTimelineVisibility() {
    return mTimelineVisibility;
  }

  public Post setFieldTimelineVisibility(String value) {
    this.mTimelineVisibility = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public Post setFieldType(String value) {
    this.mType = value;
    return this;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public Post setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public Object getFieldVia() {
    return mVia;
  }

  public Post setFieldVia(Object value) {
    this.mVia = value;
    return this;
  }

  public List<String> getFieldVideoBuyingEligibility() {
    return mVideoBuyingEligibility;
  }

  public Post setFieldVideoBuyingEligibility(List<String> value) {
    this.mVideoBuyingEligibility = value;
    return this;
  }

  public Long getFieldWidth() {
    return mWidth;
  }

  public Post setFieldWidth(Long value) {
    this.mWidth = value;
    return this;
  }



  public static enum EnumWith {
      @SerializedName("LOCATION")
      VALUE_LOCATION("LOCATION"),
      ;

      private String value;

      private EnumWith(String value) {
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
