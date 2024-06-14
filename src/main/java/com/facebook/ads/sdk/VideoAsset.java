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
public class VideoAsset extends APINode {
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

  VideoAsset() {
  }

  public VideoAsset(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoAsset(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoAsset fetch() throws APIException{
    VideoAsset newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoAsset fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoAsset> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoAsset fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoAsset> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoAsset> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoAsset>)(
      new APIRequest<VideoAsset>(context, "", "/", "GET", VideoAsset.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoAsset>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoAsset.getParser())
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
  public static VideoAsset loadJSON(String json, APIContext context, String header) {
    VideoAsset videoAsset = getGson().fromJson(json, VideoAsset.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoAsset.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoAsset.context = context;
    videoAsset.rawValue = json;
    videoAsset.header = header;
    return videoAsset;
  }

  public static APINodeList<VideoAsset> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoAsset> videoAssets = new APINodeList<VideoAsset>(request, json, header);
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
          videoAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoAssets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoAssets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoAssets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoAssets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoAssets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoAssets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoAssets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoAssets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoAssets;
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
              videoAssets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoAssets;
          }

          // Sixth, check if it's pure JsonObject
          videoAssets.clear();
          videoAssets.add(loadJSON(json, context, header));
          return videoAssets;
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

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBroadcastId() {
    return mBroadcastId;
  }

  public String getFieldBroadcastPlannedStartTime() {
    return mBroadcastPlannedStartTime;
  }

  public Boolean getFieldCanViewerEdit() {
    return mCanViewerEdit;
  }

  public String getFieldCopyrightMonitoringStatus() {
    return mCopyrightMonitoringStatus;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDownloadHdUrl() {
    return mDownloadHdUrl;
  }

  public String getFieldDownloadSdUrl() {
    return mDownloadSdUrl;
  }

  public Boolean getFieldEmbeddable() {
    return mEmbeddable;
  }

  public Object getFieldExpiration() {
    return mExpiration;
  }

  public String getFieldFeedType() {
    return mFeedType;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsCrosspostingEligible() {
    return mIsCrosspostingEligible;
  }

  public Boolean getFieldIsCrosspostingWithinBmEligible() {
    return mIsCrosspostingWithinBmEligible;
  }

  public Boolean getFieldIsCrosspostingWithinBmEnabled() {
    return mIsCrosspostingWithinBmEnabled;
  }

  public Boolean getFieldIsEpisode() {
    return mIsEpisode;
  }

  public Boolean getFieldIsFeatured() {
    return mIsFeatured;
  }

  public Boolean getFieldIsLivePremiere() {
    return mIsLivePremiere;
  }

  public Boolean getFieldIsVideoAsset() {
    return mIsVideoAsset;
  }

  public String getFieldLastAddedTime() {
    return mLastAddedTime;
  }

  public User getFieldLatestCreator() {
    if (mLatestCreator != null) {
      mLatestCreator.context = getContext();
    }
    return mLatestCreator;
  }

  public String getFieldLatestOwnedDescription() {
    return mLatestOwnedDescription;
  }

  public String getFieldLatestOwnedTitle() {
    return mLatestOwnedTitle;
  }

  public Double getFieldLength() {
    return mLength;
  }

  public String getFieldLiveStatus() {
    return mLiveStatus;
  }

  public Boolean getFieldNoStory() {
    return mNoStory;
  }

  public String getFieldOwnerName() {
    return mOwnerName;
  }

  public String getFieldOwnerPicture() {
    return mOwnerPicture;
  }

  public String getFieldOwnerPostState() {
    return mOwnerPostState;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public Long getFieldPostsCount() {
    return mPostsCount;
  }

  public List<String> getFieldPostsIds() {
    return mPostsIds;
  }

  public Object getFieldPostsStatus() {
    return mPostsStatus;
  }

  public String getFieldPremiereLivingRoomStatus() {
    return mPremiereLivingRoomStatus;
  }

  public Boolean getFieldPublished() {
    return mPublished;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public Boolean getFieldSecret() {
    return mSecret;
  }

  public String getFieldSecureStreamUrl() {
    return mSecureStreamUrl;
  }

  public Boolean getFieldSocialActions() {
    return mSocialActions;
  }

  public VideoStatus getFieldStatus() {
    return mStatus;
  }

  public String getFieldStreamUrl() {
    return mStreamUrl;
  }

  public String getFieldThumbnailWhileEncoding() {
    return mThumbnailWhileEncoding;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public Long getFieldViews() {
    return mViews;
  }



  public static class APIRequestGetInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metric",
      "period",
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
         },
         MoreExecutors.directExecutor()
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


    public APIRequestGetInsights setMetric (List<InsightsResult.EnumMetric> metric) {
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

  public static class APIRequestGet extends APIRequest<VideoAsset> {

    VideoAsset lastResponse = null;
    @Override
    public VideoAsset getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "broadcast_id",
      "broadcast_planned_start_time",
      "can_viewer_edit",
      "copyright_monitoring_status",
      "created_time",
      "creator",
      "description",
      "download_hd_url",
      "download_sd_url",
      "embeddable",
      "expiration",
      "feed_type",
      "id",
      "is_crossposting_eligible",
      "is_crossposting_within_bm_eligible",
      "is_crossposting_within_bm_enabled",
      "is_episode",
      "is_featured",
      "is_live_premiere",
      "is_video_asset",
      "last_added_time",
      "latest_creator",
      "latest_owned_description",
      "latest_owned_title",
      "length",
      "live_status",
      "no_story",
      "owner_name",
      "owner_picture",
      "owner_post_state",
      "permalink_url",
      "picture",
      "posts_count",
      "posts_ids",
      "posts_status",
      "premiere_living_room_status",
      "published",
      "scheduled_publish_time",
      "secret",
      "secure_stream_url",
      "social_actions",
      "status",
      "stream_url",
      "thumbnail_while_encoding",
      "title",
      "views",
    };

    @Override
    public VideoAsset parseResponse(String response, String header) throws APIException {
      return VideoAsset.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoAsset execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoAsset execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoAsset> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoAsset> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoAsset>() {
           public VideoAsset apply(ResponseWrapper result) {
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

    public APIRequestGet requestBroadcastIdField () {
      return this.requestBroadcastIdField(true);
    }
    public APIRequestGet requestBroadcastIdField (boolean value) {
      this.requestField("broadcast_id", value);
      return this;
    }
    public APIRequestGet requestBroadcastPlannedStartTimeField () {
      return this.requestBroadcastPlannedStartTimeField(true);
    }
    public APIRequestGet requestBroadcastPlannedStartTimeField (boolean value) {
      this.requestField("broadcast_planned_start_time", value);
      return this;
    }
    public APIRequestGet requestCanViewerEditField () {
      return this.requestCanViewerEditField(true);
    }
    public APIRequestGet requestCanViewerEditField (boolean value) {
      this.requestField("can_viewer_edit", value);
      return this;
    }
    public APIRequestGet requestCopyrightMonitoringStatusField () {
      return this.requestCopyrightMonitoringStatusField(true);
    }
    public APIRequestGet requestCopyrightMonitoringStatusField (boolean value) {
      this.requestField("copyright_monitoring_status", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDownloadHdUrlField () {
      return this.requestDownloadHdUrlField(true);
    }
    public APIRequestGet requestDownloadHdUrlField (boolean value) {
      this.requestField("download_hd_url", value);
      return this;
    }
    public APIRequestGet requestDownloadSdUrlField () {
      return this.requestDownloadSdUrlField(true);
    }
    public APIRequestGet requestDownloadSdUrlField (boolean value) {
      this.requestField("download_sd_url", value);
      return this;
    }
    public APIRequestGet requestEmbeddableField () {
      return this.requestEmbeddableField(true);
    }
    public APIRequestGet requestEmbeddableField (boolean value) {
      this.requestField("embeddable", value);
      return this;
    }
    public APIRequestGet requestExpirationField () {
      return this.requestExpirationField(true);
    }
    public APIRequestGet requestExpirationField (boolean value) {
      this.requestField("expiration", value);
      return this;
    }
    public APIRequestGet requestFeedTypeField () {
      return this.requestFeedTypeField(true);
    }
    public APIRequestGet requestFeedTypeField (boolean value) {
      this.requestField("feed_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsCrosspostingEligibleField () {
      return this.requestIsCrosspostingEligibleField(true);
    }
    public APIRequestGet requestIsCrosspostingEligibleField (boolean value) {
      this.requestField("is_crossposting_eligible", value);
      return this;
    }
    public APIRequestGet requestIsCrosspostingWithinBmEligibleField () {
      return this.requestIsCrosspostingWithinBmEligibleField(true);
    }
    public APIRequestGet requestIsCrosspostingWithinBmEligibleField (boolean value) {
      this.requestField("is_crossposting_within_bm_eligible", value);
      return this;
    }
    public APIRequestGet requestIsCrosspostingWithinBmEnabledField () {
      return this.requestIsCrosspostingWithinBmEnabledField(true);
    }
    public APIRequestGet requestIsCrosspostingWithinBmEnabledField (boolean value) {
      this.requestField("is_crossposting_within_bm_enabled", value);
      return this;
    }
    public APIRequestGet requestIsEpisodeField () {
      return this.requestIsEpisodeField(true);
    }
    public APIRequestGet requestIsEpisodeField (boolean value) {
      this.requestField("is_episode", value);
      return this;
    }
    public APIRequestGet requestIsFeaturedField () {
      return this.requestIsFeaturedField(true);
    }
    public APIRequestGet requestIsFeaturedField (boolean value) {
      this.requestField("is_featured", value);
      return this;
    }
    public APIRequestGet requestIsLivePremiereField () {
      return this.requestIsLivePremiereField(true);
    }
    public APIRequestGet requestIsLivePremiereField (boolean value) {
      this.requestField("is_live_premiere", value);
      return this;
    }
    public APIRequestGet requestIsVideoAssetField () {
      return this.requestIsVideoAssetField(true);
    }
    public APIRequestGet requestIsVideoAssetField (boolean value) {
      this.requestField("is_video_asset", value);
      return this;
    }
    public APIRequestGet requestLastAddedTimeField () {
      return this.requestLastAddedTimeField(true);
    }
    public APIRequestGet requestLastAddedTimeField (boolean value) {
      this.requestField("last_added_time", value);
      return this;
    }
    public APIRequestGet requestLatestCreatorField () {
      return this.requestLatestCreatorField(true);
    }
    public APIRequestGet requestLatestCreatorField (boolean value) {
      this.requestField("latest_creator", value);
      return this;
    }
    public APIRequestGet requestLatestOwnedDescriptionField () {
      return this.requestLatestOwnedDescriptionField(true);
    }
    public APIRequestGet requestLatestOwnedDescriptionField (boolean value) {
      this.requestField("latest_owned_description", value);
      return this;
    }
    public APIRequestGet requestLatestOwnedTitleField () {
      return this.requestLatestOwnedTitleField(true);
    }
    public APIRequestGet requestLatestOwnedTitleField (boolean value) {
      this.requestField("latest_owned_title", value);
      return this;
    }
    public APIRequestGet requestLengthField () {
      return this.requestLengthField(true);
    }
    public APIRequestGet requestLengthField (boolean value) {
      this.requestField("length", value);
      return this;
    }
    public APIRequestGet requestLiveStatusField () {
      return this.requestLiveStatusField(true);
    }
    public APIRequestGet requestLiveStatusField (boolean value) {
      this.requestField("live_status", value);
      return this;
    }
    public APIRequestGet requestNoStoryField () {
      return this.requestNoStoryField(true);
    }
    public APIRequestGet requestNoStoryField (boolean value) {
      this.requestField("no_story", value);
      return this;
    }
    public APIRequestGet requestOwnerNameField () {
      return this.requestOwnerNameField(true);
    }
    public APIRequestGet requestOwnerNameField (boolean value) {
      this.requestField("owner_name", value);
      return this;
    }
    public APIRequestGet requestOwnerPictureField () {
      return this.requestOwnerPictureField(true);
    }
    public APIRequestGet requestOwnerPictureField (boolean value) {
      this.requestField("owner_picture", value);
      return this;
    }
    public APIRequestGet requestOwnerPostStateField () {
      return this.requestOwnerPostStateField(true);
    }
    public APIRequestGet requestOwnerPostStateField (boolean value) {
      this.requestField("owner_post_state", value);
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
    public APIRequestGet requestPostsCountField () {
      return this.requestPostsCountField(true);
    }
    public APIRequestGet requestPostsCountField (boolean value) {
      this.requestField("posts_count", value);
      return this;
    }
    public APIRequestGet requestPostsIdsField () {
      return this.requestPostsIdsField(true);
    }
    public APIRequestGet requestPostsIdsField (boolean value) {
      this.requestField("posts_ids", value);
      return this;
    }
    public APIRequestGet requestPostsStatusField () {
      return this.requestPostsStatusField(true);
    }
    public APIRequestGet requestPostsStatusField (boolean value) {
      this.requestField("posts_status", value);
      return this;
    }
    public APIRequestGet requestPremiereLivingRoomStatusField () {
      return this.requestPremiereLivingRoomStatusField(true);
    }
    public APIRequestGet requestPremiereLivingRoomStatusField (boolean value) {
      this.requestField("premiere_living_room_status", value);
      return this;
    }
    public APIRequestGet requestPublishedField () {
      return this.requestPublishedField(true);
    }
    public APIRequestGet requestPublishedField (boolean value) {
      this.requestField("published", value);
      return this;
    }
    public APIRequestGet requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGet requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGet requestSecretField () {
      return this.requestSecretField(true);
    }
    public APIRequestGet requestSecretField (boolean value) {
      this.requestField("secret", value);
      return this;
    }
    public APIRequestGet requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGet requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGet requestSocialActionsField () {
      return this.requestSocialActionsField(true);
    }
    public APIRequestGet requestSocialActionsField (boolean value) {
      this.requestField("social_actions", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGet requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGet requestThumbnailWhileEncodingField () {
      return this.requestThumbnailWhileEncodingField(true);
    }
    public APIRequestGet requestThumbnailWhileEncodingField (boolean value) {
      this.requestField("thumbnail_while_encoding", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestViewsField () {
      return this.requestViewsField(true);
    }
    public APIRequestGet requestViewsField (boolean value) {
      this.requestField("views", value);
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

  public VideoAsset copyFrom(VideoAsset instance) {
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

  public static APIRequest.ResponseParser<VideoAsset> getParser() {
    return new APIRequest.ResponseParser<VideoAsset>() {
      public APINodeList<VideoAsset> parseResponse(String response, APIContext context, APIRequest<VideoAsset> request, String header) throws MalformedResponseException {
        return VideoAsset.parseResponse(response, context, request, header);
      }
    };
  }
}
