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
public class VideoList extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_modified")
  private String mLastModified = null;
  @SerializedName("owner")
  private Object mOwner = null;
  @SerializedName("season_number")
  private Long mSeasonNumber = null;
  @SerializedName("thumbnail")
  private String mThumbnail = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("videos_count")
  private Long mVideosCount = null;
  protected static Gson gson = null;

  VideoList() {
  }

  public VideoList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoList(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoList fetch() throws APIException{
    VideoList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoList fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoList> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoList>)(
      new APIRequest<VideoList>(context, "", "/", "GET", VideoList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoList.getParser())
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
  public static VideoList loadJSON(String json, APIContext context, String header) {
    VideoList videoList = getGson().fromJson(json, VideoList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoList.context = context;
    videoList.rawValue = json;
    videoList.header = header;
    return videoList;
  }

  public static APINodeList<VideoList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoList> videoLists = new APINodeList<VideoList>(request, json, header);
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
          videoLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoLists;
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
              videoLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoLists;
          }

          // Sixth, check if it's pure JsonObject
          videoLists.clear();
          videoLists.add(loadJSON(json, context, header));
          return videoLists;
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

  public APIRequestGetVideos getVideos() {
    return new APIRequestGetVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLastModified() {
    return mLastModified;
  }

  public Object getFieldOwner() {
    return mOwner;
  }

  public Long getFieldSeasonNumber() {
    return mSeasonNumber;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public Long getFieldVideosCount() {
    return mVideosCount;
  }



  public static class APIRequestGetVideos extends APIRequest<AdVideo> {

    APINodeList<AdVideo> lastResponse = null;
    @Override
    public APINodeList<AdVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_breaks",
      "admin_creator",
      "audio_isrc",
      "backdated_time",
      "backdated_time_granularity",
      "content_category",
      "content_tags",
      "copyright",
      "copyright_check_information",
      "copyright_monitoring_status",
      "created_time",
      "custom_labels",
      "description",
      "embed_html",
      "embeddable",
      "event",
      "expiration",
      "format",
      "from",
      "icon",
      "id",
      "is_crosspost_video",
      "is_crossposting_eligible",
      "is_episode",
      "is_instagram_eligible",
      "is_reference_only",
      "length",
      "live_audience_count",
      "live_status",
      "music_video_copyright",
      "permalink_url",
      "picture",
      "place",
      "post_id",
      "post_views",
      "premiere_living_room_status",
      "privacy",
      "published",
      "scheduled_publish_time",
      "source",
      "spherical",
      "status",
      "title",
      "universal_video_id",
      "updated_time",
      "views",
    };

    @Override
    public APINodeList<AdVideo> parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdVideo> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdVideo>>() {
           public APINodeList<AdVideo> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideos requestAdBreaksField () {
      return this.requestAdBreaksField(true);
    }
    public APIRequestGetVideos requestAdBreaksField (boolean value) {
      this.requestField("ad_breaks", value);
      return this;
    }
    public APIRequestGetVideos requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetVideos requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetVideos requestAudioIsrcField () {
      return this.requestAudioIsrcField(true);
    }
    public APIRequestGetVideos requestAudioIsrcField (boolean value) {
      this.requestField("audio_isrc", value);
      return this;
    }
    public APIRequestGetVideos requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetVideos requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetVideos requestBackdatedTimeGranularityField () {
      return this.requestBackdatedTimeGranularityField(true);
    }
    public APIRequestGetVideos requestBackdatedTimeGranularityField (boolean value) {
      this.requestField("backdated_time_granularity", value);
      return this;
    }
    public APIRequestGetVideos requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGetVideos requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGetVideos requestContentTagsField () {
      return this.requestContentTagsField(true);
    }
    public APIRequestGetVideos requestContentTagsField (boolean value) {
      this.requestField("content_tags", value);
      return this;
    }
    public APIRequestGetVideos requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGetVideos requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGetVideos requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetVideos requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetVideos requestCopyrightMonitoringStatusField () {
      return this.requestCopyrightMonitoringStatusField(true);
    }
    public APIRequestGetVideos requestCopyrightMonitoringStatusField (boolean value) {
      this.requestField("copyright_monitoring_status", value);
      return this;
    }
    public APIRequestGetVideos requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetVideos requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetVideos requestCustomLabelsField () {
      return this.requestCustomLabelsField(true);
    }
    public APIRequestGetVideos requestCustomLabelsField (boolean value) {
      this.requestField("custom_labels", value);
      return this;
    }
    public APIRequestGetVideos requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetVideos requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetVideos requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGetVideos requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGetVideos requestEmbeddableField () {
      return this.requestEmbeddableField(true);
    }
    public APIRequestGetVideos requestEmbeddableField (boolean value) {
      this.requestField("embeddable", value);
      return this;
    }
    public APIRequestGetVideos requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetVideos requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetVideos requestExpirationField () {
      return this.requestExpirationField(true);
    }
    public APIRequestGetVideos requestExpirationField (boolean value) {
      this.requestField("expiration", value);
      return this;
    }
    public APIRequestGetVideos requestFormatField () {
      return this.requestFormatField(true);
    }
    public APIRequestGetVideos requestFormatField (boolean value) {
      this.requestField("format", value);
      return this;
    }
    public APIRequestGetVideos requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetVideos requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetVideos requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetVideos requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetVideos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideos requestIsCrosspostVideoField () {
      return this.requestIsCrosspostVideoField(true);
    }
    public APIRequestGetVideos requestIsCrosspostVideoField (boolean value) {
      this.requestField("is_crosspost_video", value);
      return this;
    }
    public APIRequestGetVideos requestIsCrosspostingEligibleField () {
      return this.requestIsCrosspostingEligibleField(true);
    }
    public APIRequestGetVideos requestIsCrosspostingEligibleField (boolean value) {
      this.requestField("is_crossposting_eligible", value);
      return this;
    }
    public APIRequestGetVideos requestIsEpisodeField () {
      return this.requestIsEpisodeField(true);
    }
    public APIRequestGetVideos requestIsEpisodeField (boolean value) {
      this.requestField("is_episode", value);
      return this;
    }
    public APIRequestGetVideos requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetVideos requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetVideos requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGetVideos requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGetVideos requestLengthField () {
      return this.requestLengthField(true);
    }
    public APIRequestGetVideos requestLengthField (boolean value) {
      this.requestField("length", value);
      return this;
    }
    public APIRequestGetVideos requestLiveAudienceCountField () {
      return this.requestLiveAudienceCountField(true);
    }
    public APIRequestGetVideos requestLiveAudienceCountField (boolean value) {
      this.requestField("live_audience_count", value);
      return this;
    }
    public APIRequestGetVideos requestLiveStatusField () {
      return this.requestLiveStatusField(true);
    }
    public APIRequestGetVideos requestLiveStatusField (boolean value) {
      this.requestField("live_status", value);
      return this;
    }
    public APIRequestGetVideos requestMusicVideoCopyrightField () {
      return this.requestMusicVideoCopyrightField(true);
    }
    public APIRequestGetVideos requestMusicVideoCopyrightField (boolean value) {
      this.requestField("music_video_copyright", value);
      return this;
    }
    public APIRequestGetVideos requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetVideos requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetVideos requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetVideos requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetVideos requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetVideos requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetVideos requestPostIdField () {
      return this.requestPostIdField(true);
    }
    public APIRequestGetVideos requestPostIdField (boolean value) {
      this.requestField("post_id", value);
      return this;
    }
    public APIRequestGetVideos requestPostViewsField () {
      return this.requestPostViewsField(true);
    }
    public APIRequestGetVideos requestPostViewsField (boolean value) {
      this.requestField("post_views", value);
      return this;
    }
    public APIRequestGetVideos requestPremiereLivingRoomStatusField () {
      return this.requestPremiereLivingRoomStatusField(true);
    }
    public APIRequestGetVideos requestPremiereLivingRoomStatusField (boolean value) {
      this.requestField("premiere_living_room_status", value);
      return this;
    }
    public APIRequestGetVideos requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetVideos requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetVideos requestPublishedField () {
      return this.requestPublishedField(true);
    }
    public APIRequestGetVideos requestPublishedField (boolean value) {
      this.requestField("published", value);
      return this;
    }
    public APIRequestGetVideos requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetVideos requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetVideos requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetVideos requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetVideos requestSphericalField () {
      return this.requestSphericalField(true);
    }
    public APIRequestGetVideos requestSphericalField (boolean value) {
      this.requestField("spherical", value);
      return this;
    }
    public APIRequestGetVideos requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetVideos requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetVideos requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetVideos requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetVideos requestUniversalVideoIdField () {
      return this.requestUniversalVideoIdField(true);
    }
    public APIRequestGetVideos requestUniversalVideoIdField (boolean value) {
      this.requestField("universal_video_id", value);
      return this;
    }
    public APIRequestGetVideos requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetVideos requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetVideos requestViewsField () {
      return this.requestViewsField(true);
    }
    public APIRequestGetVideos requestViewsField (boolean value) {
      this.requestField("views", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<VideoList> {

    VideoList lastResponse = null;
    @Override
    public VideoList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "description",
      "id",
      "last_modified",
      "owner",
      "season_number",
      "thumbnail",
      "title",
      "videos_count",
    };

    @Override
    public VideoList parseResponse(String response, String header) throws APIException {
      return VideoList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoList>() {
           public VideoList apply(ResponseWrapper result) {
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

    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastModifiedField () {
      return this.requestLastModifiedField(true);
    }
    public APIRequestGet requestLastModifiedField (boolean value) {
      this.requestField("last_modified", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestSeasonNumberField () {
      return this.requestSeasonNumberField(true);
    }
    public APIRequestGet requestSeasonNumberField (boolean value) {
      this.requestField("season_number", value);
      return this;
    }
    public APIRequestGet requestThumbnailField () {
      return this.requestThumbnailField(true);
    }
    public APIRequestGet requestThumbnailField (boolean value) {
      this.requestField("thumbnail", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestVideosCountField () {
      return this.requestVideosCountField(true);
    }
    public APIRequestGet requestVideosCountField (boolean value) {
      this.requestField("videos_count", value);
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

  public VideoList copyFrom(VideoList instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mLastModified = instance.mLastModified;
    this.mOwner = instance.mOwner;
    this.mSeasonNumber = instance.mSeasonNumber;
    this.mThumbnail = instance.mThumbnail;
    this.mTitle = instance.mTitle;
    this.mVideosCount = instance.mVideosCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoList> getParser() {
    return new APIRequest.ResponseParser<VideoList>() {
      public APINodeList<VideoList> parseResponse(String response, APIContext context, APIRequest<VideoList> request, String header) throws MalformedResponseException {
        return VideoList.parseResponse(response, context, request, header);
      }
    };
  }
}
