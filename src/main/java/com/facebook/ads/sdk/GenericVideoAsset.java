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
public class GenericVideoAsset extends APINode {
  @SerializedName("broadcast_id")
  private String mBroadcastId = null;
  @SerializedName("broadcast_planned_start_time")
  private String mBroadcastPlannedStartTime = null;
  @SerializedName("can_viewer_edit")
  private Boolean mCanViewerEdit = null;
  @SerializedName("copyright_monitoring_status")
  private String mCopyrightMonitoringStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("download_hd_url")
  private String mDownloadHdUrl = null;
  @SerializedName("download_sd_url")
  private String mDownloadSdUrl = null;
  @SerializedName("embeddable")
  private Boolean mEmbeddable = null;
  @SerializedName("expiration")
  private Object mExpiration = null;
  @SerializedName("feed_type")
  private String mFeedType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_crossposting_eligible")
  private Boolean mIsCrosspostingEligible = null;
  @SerializedName("is_crossposting_within_bm_eligible")
  private Boolean mIsCrosspostingWithinBmEligible = null;
  @SerializedName("is_crossposting_within_bm_enabled")
  private Boolean mIsCrosspostingWithinBmEnabled = null;
  @SerializedName("is_episode")
  private Boolean mIsEpisode = null;
  @SerializedName("is_featured")
  private Boolean mIsFeatured = null;
  @SerializedName("is_live_premiere")
  private Boolean mIsLivePremiere = null;
  @SerializedName("is_video_asset")
  private Boolean mIsVideoAsset = null;
  @SerializedName("last_added_time")
  private String mLastAddedTime = null;
  @SerializedName("latest_creator")
  private User mLatestCreator = null;
  @SerializedName("latest_owned_description")
  private String mLatestOwnedDescription = null;
  @SerializedName("latest_owned_title")
  private String mLatestOwnedTitle = null;
  @SerializedName("length")
  private Double mLength = null;
  @SerializedName("live_status")
  private String mLiveStatus = null;
  @SerializedName("no_story")
  private Boolean mNoStory = null;
  @SerializedName("owner_name")
  private String mOwnerName = null;
  @SerializedName("owner_picture")
  private String mOwnerPicture = null;
  @SerializedName("owner_post_state")
  private String mOwnerPostState = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("posts_count")
  private Long mPostsCount = null;
  @SerializedName("posts_ids")
  private List<String> mPostsIds = null;
  @SerializedName("posts_status")
  private Object mPostsStatus = null;
  @SerializedName("premiere_living_room_status")
  private String mPremiereLivingRoomStatus = null;
  @SerializedName("published")
  private Boolean mPublished = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("secret")
  private Boolean mSecret = null;
  @SerializedName("secure_stream_url")
  private String mSecureStreamUrl = null;
  @SerializedName("social_actions")
  private Boolean mSocialActions = null;
  @SerializedName("status")
  private VideoStatus mStatus = null;
  @SerializedName("stream_url")
  private String mStreamUrl = null;
  @SerializedName("thumbnail_while_encoding")
  private String mThumbnailWhileEncoding = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("views")
  private Long mViews = null;
  protected static Gson gson = null;

  public GenericVideoAsset() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static GenericVideoAsset loadJSON(String json, APIContext context, String header) {
    GenericVideoAsset genericVideoAsset = getGson().fromJson(json, GenericVideoAsset.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(genericVideoAsset.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    genericVideoAsset.context = context;
    genericVideoAsset.rawValue = json;
    genericVideoAsset.header = header;
    return genericVideoAsset;
  }

  public static APINodeList<GenericVideoAsset> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<GenericVideoAsset> genericVideoAssets = new APINodeList<GenericVideoAsset>(request, json, header);
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
          genericVideoAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return genericVideoAssets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                genericVideoAssets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            genericVideoAssets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              genericVideoAssets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              genericVideoAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  genericVideoAssets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              genericVideoAssets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return genericVideoAssets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              genericVideoAssets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return genericVideoAssets;
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
              genericVideoAssets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return genericVideoAssets;
          }

          // Sixth, check if it's pure JsonObject
          genericVideoAssets.clear();
          genericVideoAssets.add(loadJSON(json, context, header));
          return genericVideoAssets;
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


  public String getFieldBroadcastId() {
    return mBroadcastId;
  }

  public GenericVideoAsset setFieldBroadcastId(String value) {
    this.mBroadcastId = value;
    return this;
  }

  public String getFieldBroadcastPlannedStartTime() {
    return mBroadcastPlannedStartTime;
  }

  public GenericVideoAsset setFieldBroadcastPlannedStartTime(String value) {
    this.mBroadcastPlannedStartTime = value;
    return this;
  }

  public Boolean getFieldCanViewerEdit() {
    return mCanViewerEdit;
  }

  public GenericVideoAsset setFieldCanViewerEdit(Boolean value) {
    this.mCanViewerEdit = value;
    return this;
  }

  public String getFieldCopyrightMonitoringStatus() {
    return mCopyrightMonitoringStatus;
  }

  public GenericVideoAsset setFieldCopyrightMonitoringStatus(String value) {
    this.mCopyrightMonitoringStatus = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public GenericVideoAsset setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public GenericVideoAsset setFieldCreator(User value) {
    this.mCreator = value;
    return this;
  }

  public GenericVideoAsset setFieldCreator(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mCreator = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDescription() {
    return mDescription;
  }

  public GenericVideoAsset setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldDownloadHdUrl() {
    return mDownloadHdUrl;
  }

  public GenericVideoAsset setFieldDownloadHdUrl(String value) {
    this.mDownloadHdUrl = value;
    return this;
  }

  public String getFieldDownloadSdUrl() {
    return mDownloadSdUrl;
  }

  public GenericVideoAsset setFieldDownloadSdUrl(String value) {
    this.mDownloadSdUrl = value;
    return this;
  }

  public Boolean getFieldEmbeddable() {
    return mEmbeddable;
  }

  public GenericVideoAsset setFieldEmbeddable(Boolean value) {
    this.mEmbeddable = value;
    return this;
  }

  public Object getFieldExpiration() {
    return mExpiration;
  }

  public GenericVideoAsset setFieldExpiration(Object value) {
    this.mExpiration = value;
    return this;
  }

  public String getFieldFeedType() {
    return mFeedType;
  }

  public GenericVideoAsset setFieldFeedType(String value) {
    this.mFeedType = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public GenericVideoAsset setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsCrosspostingEligible() {
    return mIsCrosspostingEligible;
  }

  public GenericVideoAsset setFieldIsCrosspostingEligible(Boolean value) {
    this.mIsCrosspostingEligible = value;
    return this;
  }

  public Boolean getFieldIsCrosspostingWithinBmEligible() {
    return mIsCrosspostingWithinBmEligible;
  }

  public GenericVideoAsset setFieldIsCrosspostingWithinBmEligible(Boolean value) {
    this.mIsCrosspostingWithinBmEligible = value;
    return this;
  }

  public Boolean getFieldIsCrosspostingWithinBmEnabled() {
    return mIsCrosspostingWithinBmEnabled;
  }

  public GenericVideoAsset setFieldIsCrosspostingWithinBmEnabled(Boolean value) {
    this.mIsCrosspostingWithinBmEnabled = value;
    return this;
  }

  public Boolean getFieldIsEpisode() {
    return mIsEpisode;
  }

  public GenericVideoAsset setFieldIsEpisode(Boolean value) {
    this.mIsEpisode = value;
    return this;
  }

  public Boolean getFieldIsFeatured() {
    return mIsFeatured;
  }

  public GenericVideoAsset setFieldIsFeatured(Boolean value) {
    this.mIsFeatured = value;
    return this;
  }

  public Boolean getFieldIsLivePremiere() {
    return mIsLivePremiere;
  }

  public GenericVideoAsset setFieldIsLivePremiere(Boolean value) {
    this.mIsLivePremiere = value;
    return this;
  }

  public Boolean getFieldIsVideoAsset() {
    return mIsVideoAsset;
  }

  public GenericVideoAsset setFieldIsVideoAsset(Boolean value) {
    this.mIsVideoAsset = value;
    return this;
  }

  public String getFieldLastAddedTime() {
    return mLastAddedTime;
  }

  public GenericVideoAsset setFieldLastAddedTime(String value) {
    this.mLastAddedTime = value;
    return this;
  }

  public User getFieldLatestCreator() {
    if (mLatestCreator != null) {
      mLatestCreator.context = getContext();
    }
    return mLatestCreator;
  }

  public GenericVideoAsset setFieldLatestCreator(User value) {
    this.mLatestCreator = value;
    return this;
  }

  public GenericVideoAsset setFieldLatestCreator(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mLatestCreator = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLatestOwnedDescription() {
    return mLatestOwnedDescription;
  }

  public GenericVideoAsset setFieldLatestOwnedDescription(String value) {
    this.mLatestOwnedDescription = value;
    return this;
  }

  public String getFieldLatestOwnedTitle() {
    return mLatestOwnedTitle;
  }

  public GenericVideoAsset setFieldLatestOwnedTitle(String value) {
    this.mLatestOwnedTitle = value;
    return this;
  }

  public Double getFieldLength() {
    return mLength;
  }

  public GenericVideoAsset setFieldLength(Double value) {
    this.mLength = value;
    return this;
  }

  public String getFieldLiveStatus() {
    return mLiveStatus;
  }

  public GenericVideoAsset setFieldLiveStatus(String value) {
    this.mLiveStatus = value;
    return this;
  }

  public Boolean getFieldNoStory() {
    return mNoStory;
  }

  public GenericVideoAsset setFieldNoStory(Boolean value) {
    this.mNoStory = value;
    return this;
  }

  public String getFieldOwnerName() {
    return mOwnerName;
  }

  public GenericVideoAsset setFieldOwnerName(String value) {
    this.mOwnerName = value;
    return this;
  }

  public String getFieldOwnerPicture() {
    return mOwnerPicture;
  }

  public GenericVideoAsset setFieldOwnerPicture(String value) {
    this.mOwnerPicture = value;
    return this;
  }

  public String getFieldOwnerPostState() {
    return mOwnerPostState;
  }

  public GenericVideoAsset setFieldOwnerPostState(String value) {
    this.mOwnerPostState = value;
    return this;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public GenericVideoAsset setFieldPermalinkUrl(String value) {
    this.mPermalinkUrl = value;
    return this;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public GenericVideoAsset setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public Long getFieldPostsCount() {
    return mPostsCount;
  }

  public GenericVideoAsset setFieldPostsCount(Long value) {
    this.mPostsCount = value;
    return this;
  }

  public List<String> getFieldPostsIds() {
    return mPostsIds;
  }

  public GenericVideoAsset setFieldPostsIds(List<String> value) {
    this.mPostsIds = value;
    return this;
  }

  public Object getFieldPostsStatus() {
    return mPostsStatus;
  }

  public GenericVideoAsset setFieldPostsStatus(Object value) {
    this.mPostsStatus = value;
    return this;
  }

  public String getFieldPremiereLivingRoomStatus() {
    return mPremiereLivingRoomStatus;
  }

  public GenericVideoAsset setFieldPremiereLivingRoomStatus(String value) {
    this.mPremiereLivingRoomStatus = value;
    return this;
  }

  public Boolean getFieldPublished() {
    return mPublished;
  }

  public GenericVideoAsset setFieldPublished(Boolean value) {
    this.mPublished = value;
    return this;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public GenericVideoAsset setFieldScheduledPublishTime(String value) {
    this.mScheduledPublishTime = value;
    return this;
  }

  public Boolean getFieldSecret() {
    return mSecret;
  }

  public GenericVideoAsset setFieldSecret(Boolean value) {
    this.mSecret = value;
    return this;
  }

  public String getFieldSecureStreamUrl() {
    return mSecureStreamUrl;
  }

  public GenericVideoAsset setFieldSecureStreamUrl(String value) {
    this.mSecureStreamUrl = value;
    return this;
  }

  public Boolean getFieldSocialActions() {
    return mSocialActions;
  }

  public GenericVideoAsset setFieldSocialActions(Boolean value) {
    this.mSocialActions = value;
    return this;
  }

  public VideoStatus getFieldStatus() {
    return mStatus;
  }

  public GenericVideoAsset setFieldStatus(VideoStatus value) {
    this.mStatus = value;
    return this;
  }

  public GenericVideoAsset setFieldStatus(String value) {
    Type type = new TypeToken<VideoStatus>(){}.getType();
    this.mStatus = VideoStatus.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldStreamUrl() {
    return mStreamUrl;
  }

  public GenericVideoAsset setFieldStreamUrl(String value) {
    this.mStreamUrl = value;
    return this;
  }

  public String getFieldThumbnailWhileEncoding() {
    return mThumbnailWhileEncoding;
  }

  public GenericVideoAsset setFieldThumbnailWhileEncoding(String value) {
    this.mThumbnailWhileEncoding = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public GenericVideoAsset setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public Long getFieldViews() {
    return mViews;
  }

  public GenericVideoAsset setFieldViews(Long value) {
    this.mViews = value;
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

  public GenericVideoAsset copyFrom(GenericVideoAsset instance) {
    this.mBroadcastId = instance.mBroadcastId;
    this.mBroadcastPlannedStartTime = instance.mBroadcastPlannedStartTime;
    this.mCanViewerEdit = instance.mCanViewerEdit;
    this.mCopyrightMonitoringStatus = instance.mCopyrightMonitoringStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreator = instance.mCreator;
    this.mDescription = instance.mDescription;
    this.mDownloadHdUrl = instance.mDownloadHdUrl;
    this.mDownloadSdUrl = instance.mDownloadSdUrl;
    this.mEmbeddable = instance.mEmbeddable;
    this.mExpiration = instance.mExpiration;
    this.mFeedType = instance.mFeedType;
    this.mId = instance.mId;
    this.mIsCrosspostingEligible = instance.mIsCrosspostingEligible;
    this.mIsCrosspostingWithinBmEligible = instance.mIsCrosspostingWithinBmEligible;
    this.mIsCrosspostingWithinBmEnabled = instance.mIsCrosspostingWithinBmEnabled;
    this.mIsEpisode = instance.mIsEpisode;
    this.mIsFeatured = instance.mIsFeatured;
    this.mIsLivePremiere = instance.mIsLivePremiere;
    this.mIsVideoAsset = instance.mIsVideoAsset;
    this.mLastAddedTime = instance.mLastAddedTime;
    this.mLatestCreator = instance.mLatestCreator;
    this.mLatestOwnedDescription = instance.mLatestOwnedDescription;
    this.mLatestOwnedTitle = instance.mLatestOwnedTitle;
    this.mLength = instance.mLength;
    this.mLiveStatus = instance.mLiveStatus;
    this.mNoStory = instance.mNoStory;
    this.mOwnerName = instance.mOwnerName;
    this.mOwnerPicture = instance.mOwnerPicture;
    this.mOwnerPostState = instance.mOwnerPostState;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPicture = instance.mPicture;
    this.mPostsCount = instance.mPostsCount;
    this.mPostsIds = instance.mPostsIds;
    this.mPostsStatus = instance.mPostsStatus;
    this.mPremiereLivingRoomStatus = instance.mPremiereLivingRoomStatus;
    this.mPublished = instance.mPublished;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mSecret = instance.mSecret;
    this.mSecureStreamUrl = instance.mSecureStreamUrl;
    this.mSocialActions = instance.mSocialActions;
    this.mStatus = instance.mStatus;
    this.mStreamUrl = instance.mStreamUrl;
    this.mThumbnailWhileEncoding = instance.mThumbnailWhileEncoding;
    this.mTitle = instance.mTitle;
    this.mViews = instance.mViews;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<GenericVideoAsset> getParser() {
    return new APIRequest.ResponseParser<GenericVideoAsset>() {
      public APINodeList<GenericVideoAsset> parseResponse(String response, APIContext context, APIRequest<GenericVideoAsset> request, String header) throws MalformedResponseException {
        return GenericVideoAsset.parseResponse(response, context, request, header);
      }
    };
  }
}
