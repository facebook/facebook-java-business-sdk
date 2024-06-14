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
public class ExpirablePost extends APINode {
  @SerializedName("admin_creator")
  private User mAdminCreator = null;
  @SerializedName("can_republish")
  private Boolean mCanRepublish = null;
  @SerializedName("content_type")
  private String mContentType = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("expiration")
  private Object mExpiration = null;
  @SerializedName("feed_audience_description")
  private String mFeedAudienceDescription = null;
  @SerializedName("feed_targeting")
  private Targeting mFeedTargeting = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_post_in_good_state")
  private Boolean mIsPostInGoodState = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("modified_time")
  private String mModifiedTime = null;
  @SerializedName("og_action_summary")
  private String mOgActionSummary = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("place")
  private Place mPlace = null;
  @SerializedName("privacy_description")
  private String mPrivacyDescription = null;
  @SerializedName("scheduled_failure_notice")
  private String mScheduledFailureNotice = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("story_token")
  private String mStoryToken = null;
  @SerializedName("thumbnail")
  private String mThumbnail = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  protected static Gson gson = null;

  public ExpirablePost() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ExpirablePost loadJSON(String json, APIContext context, String header) {
    ExpirablePost expirablePost = getGson().fromJson(json, ExpirablePost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(expirablePost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    expirablePost.context = context;
    expirablePost.rawValue = json;
    expirablePost.header = header;
    return expirablePost;
  }

  public static APINodeList<ExpirablePost> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ExpirablePost> expirablePosts = new APINodeList<ExpirablePost>(request, json, header);
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
          expirablePosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return expirablePosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                expirablePosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            expirablePosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              expirablePosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              expirablePosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  expirablePosts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              expirablePosts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return expirablePosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              expirablePosts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return expirablePosts;
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
              expirablePosts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return expirablePosts;
          }

          // Sixth, check if it's pure JsonObject
          expirablePosts.clear();
          expirablePosts.add(loadJSON(json, context, header));
          return expirablePosts;
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


  public User getFieldAdminCreator() {
    if (mAdminCreator != null) {
      mAdminCreator.context = getContext();
    }
    return mAdminCreator;
  }

  public ExpirablePost setFieldAdminCreator(User value) {
    this.mAdminCreator = value;
    return this;
  }

  public ExpirablePost setFieldAdminCreator(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mAdminCreator = User.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldCanRepublish() {
    return mCanRepublish;
  }

  public ExpirablePost setFieldCanRepublish(Boolean value) {
    this.mCanRepublish = value;
    return this;
  }

  public String getFieldContentType() {
    return mContentType;
  }

  public ExpirablePost setFieldContentType(String value) {
    this.mContentType = value;
    return this;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public ExpirablePost setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public Object getFieldExpiration() {
    return mExpiration;
  }

  public ExpirablePost setFieldExpiration(Object value) {
    this.mExpiration = value;
    return this;
  }

  public String getFieldFeedAudienceDescription() {
    return mFeedAudienceDescription;
  }

  public ExpirablePost setFieldFeedAudienceDescription(String value) {
    this.mFeedAudienceDescription = value;
    return this;
  }

  public Targeting getFieldFeedTargeting() {
    return mFeedTargeting;
  }

  public ExpirablePost setFieldFeedTargeting(Targeting value) {
    this.mFeedTargeting = value;
    return this;
  }

  public ExpirablePost setFieldFeedTargeting(String value) {
    Type type = new TypeToken<Targeting>(){}.getType();
    this.mFeedTargeting = Targeting.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public ExpirablePost setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsPostInGoodState() {
    return mIsPostInGoodState;
  }

  public ExpirablePost setFieldIsPostInGoodState(Boolean value) {
    this.mIsPostInGoodState = value;
    return this;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public ExpirablePost setFieldMessage(String value) {
    this.mMessage = value;
    return this;
  }

  public String getFieldModifiedTime() {
    return mModifiedTime;
  }

  public ExpirablePost setFieldModifiedTime(String value) {
    this.mModifiedTime = value;
    return this;
  }

  public String getFieldOgActionSummary() {
    return mOgActionSummary;
  }

  public ExpirablePost setFieldOgActionSummary(String value) {
    this.mOgActionSummary = value;
    return this;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public ExpirablePost setFieldPermalinkUrl(String value) {
    this.mPermalinkUrl = value;
    return this;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public ExpirablePost setFieldPlace(Place value) {
    this.mPlace = value;
    return this;
  }

  public ExpirablePost setFieldPlace(String value) {
    Type type = new TypeToken<Place>(){}.getType();
    this.mPlace = Place.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPrivacyDescription() {
    return mPrivacyDescription;
  }

  public ExpirablePost setFieldPrivacyDescription(String value) {
    this.mPrivacyDescription = value;
    return this;
  }

  public String getFieldScheduledFailureNotice() {
    return mScheduledFailureNotice;
  }

  public ExpirablePost setFieldScheduledFailureNotice(String value) {
    this.mScheduledFailureNotice = value;
    return this;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public ExpirablePost setFieldScheduledPublishTime(String value) {
    this.mScheduledPublishTime = value;
    return this;
  }

  public String getFieldStoryToken() {
    return mStoryToken;
  }

  public ExpirablePost setFieldStoryToken(String value) {
    this.mStoryToken = value;
    return this;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public ExpirablePost setFieldThumbnail(String value) {
    this.mThumbnail = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public ExpirablePost setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
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

  public ExpirablePost copyFrom(ExpirablePost instance) {
    this.mAdminCreator = instance.mAdminCreator;
    this.mCanRepublish = instance.mCanRepublish;
    this.mContentType = instance.mContentType;
    this.mCreationTime = instance.mCreationTime;
    this.mExpiration = instance.mExpiration;
    this.mFeedAudienceDescription = instance.mFeedAudienceDescription;
    this.mFeedTargeting = instance.mFeedTargeting;
    this.mId = instance.mId;
    this.mIsPostInGoodState = instance.mIsPostInGoodState;
    this.mMessage = instance.mMessage;
    this.mModifiedTime = instance.mModifiedTime;
    this.mOgActionSummary = instance.mOgActionSummary;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPlace = instance.mPlace;
    this.mPrivacyDescription = instance.mPrivacyDescription;
    this.mScheduledFailureNotice = instance.mScheduledFailureNotice;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mStoryToken = instance.mStoryToken;
    this.mThumbnail = instance.mThumbnail;
    this.mVideoId = instance.mVideoId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ExpirablePost> getParser() {
    return new APIRequest.ResponseParser<ExpirablePost>() {
      public APINodeList<ExpirablePost> parseResponse(String response, APIContext context, APIRequest<ExpirablePost> request, String header) throws MalformedResponseException {
        return ExpirablePost.parseResponse(response, context, request, header);
      }
    };
  }
}
