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
public class AdVideo extends APINode {
  @SerializedName("ad_breaks")
  private List<Long> mAdBreaks = null;
  @SerializedName("backdated_time")
  private String mBackdatedTime = null;
  @SerializedName("backdated_time_granularity")
  private String mBackdatedTimeGranularity = null;
  @SerializedName("content_category")
  private String mContentCategory = null;
  @SerializedName("content_tags")
  private List<String> mContentTags = null;
  @SerializedName("copyright")
  private VideoCopyright mCopyright = null;
  @SerializedName("copyright_monitoring_status")
  private String mCopyrightMonitoringStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("custom_labels")
  private List<String> mCustomLabels = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("embed_html")
  private String mEmbedHtml = null;
  @SerializedName("embeddable")
  private Boolean mEmbeddable = null;
  @SerializedName("event")
  private Event mEvent = null;
  @SerializedName("expiration")
  private Object mExpiration = null;
  @SerializedName("format")
  private List<Object> mFormat = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("icon")
  private String mIcon = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_crosspost_video")
  private Boolean mIsCrosspostVideo = null;
  @SerializedName("is_crossposting_eligible")
  private Boolean mIsCrosspostingEligible = null;
  @SerializedName("is_episode")
  private Boolean mIsEpisode = null;
  @SerializedName("is_instagram_eligible")
  private Boolean mIsInstagramEligible = null;
  @SerializedName("is_reference_only")
  private Boolean mIsReferenceOnly = null;
  @SerializedName("length")
  private Double mLength = null;
  @SerializedName("live_audience_count")
  private Long mLiveAudienceCount = null;
  @SerializedName("live_status")
  private String mLiveStatus = null;
  @SerializedName("music_video_copyright")
  private MusicVideoCopyright mMusicVideoCopyright = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("place")
  private Place mPlace = null;
  @SerializedName("premiere_living_room_status")
  private String mPremiereLivingRoomStatus = null;
  @SerializedName("privacy")
  private Privacy mPrivacy = null;
  @SerializedName("published")
  private Boolean mPublished = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("spherical")
  private Boolean mSpherical = null;
  @SerializedName("status")
  private Object mStatus = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("universal_video_id")
  private String mUniversalVideoId = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdVideo() {
  }

  public AdVideo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdVideo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdVideo fetch() throws APIException{
    AdVideo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdVideo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdVideo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdVideo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdVideo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdVideo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdVideo>)(
      new APIRequest<AdVideo>(context, "", "/", "GET", AdVideo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdVideo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdVideo.getParser())
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
  public static AdVideo loadJSON(String json, APIContext context, String header) {
    AdVideo adVideo = getGson().fromJson(json, AdVideo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adVideo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adVideo.context = context;
    adVideo.rawValue = json;
    adVideo.header = header;
    return adVideo;
  }

  public static APINodeList<AdVideo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdVideo> adVideos = new APINodeList<AdVideo>(request, json, header);
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
          adVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adVideos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adVideos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adVideos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adVideos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adVideos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adVideos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adVideos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adVideos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adVideos;
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
              adVideos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adVideos;
          }

          // Sixth, check if it's pure JsonObject
          adVideos.clear();
          adVideos.add(loadJSON(json, context, header));
          return adVideos;
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

  public APIRequestGetCaptions getCaptions() {
    return new APIRequestGetCaptions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCaption createCaption() {
    return new APIRequestCreateCaption(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCrosspostSharedPages getCrosspostSharedPages() {
    return new APIRequestGetCrosspostSharedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLikes getLikes() {
    return new APIRequestGetLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLike createLike() {
    return new APIRequestCreateLike(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPollSettings getPollSettings() {
    return new APIRequestGetPollSettings(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPolls getPolls() {
    return new APIRequestGetPolls(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePoll createPoll() {
    return new APIRequestCreatePoll(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReactions getReactions() {
    return new APIRequestGetReactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSharedPosts getSharedPosts() {
    return new APIRequestGetSharedPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSponsorTags getSponsorTags() {
    return new APIRequestGetSponsorTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateTag createTag() {
    return new APIRequestCreateTag(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetThumbnails getThumbnails() {
    return new APIRequestGetThumbnails(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateThumbnail createThumbnail() {
    return new APIRequestCreateThumbnail(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideoInsights getVideoInsights() {
    return new APIRequestGetVideoInsights(this.getPrefixedId().toString(), context);
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


  public List<Long> getFieldAdBreaks() {
    return mAdBreaks;
  }

  public String getFieldBackdatedTime() {
    return mBackdatedTime;
  }

  public String getFieldBackdatedTimeGranularity() {
    return mBackdatedTimeGranularity;
  }

  public String getFieldContentCategory() {
    return mContentCategory;
  }

  public List<String> getFieldContentTags() {
    return mContentTags;
  }

  public VideoCopyright getFieldCopyright() {
    if (mCopyright != null) {
      mCopyright.context = getContext();
    }
    return mCopyright;
  }

  public String getFieldCopyrightMonitoringStatus() {
    return mCopyrightMonitoringStatus;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<String> getFieldCustomLabels() {
    return mCustomLabels;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEmbedHtml() {
    return mEmbedHtml;
  }

  public Boolean getFieldEmbeddable() {
    return mEmbeddable;
  }

  public Event getFieldEvent() {
    if (mEvent != null) {
      mEvent.context = getContext();
    }
    return mEvent;
  }

  public Object getFieldExpiration() {
    return mExpiration;
  }

  public List<Object> getFieldFormat() {
    return mFormat;
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

  public Boolean getFieldIsCrosspostVideo() {
    return mIsCrosspostVideo;
  }

  public Boolean getFieldIsCrosspostingEligible() {
    return mIsCrosspostingEligible;
  }

  public Boolean getFieldIsEpisode() {
    return mIsEpisode;
  }

  public Boolean getFieldIsInstagramEligible() {
    return mIsInstagramEligible;
  }

  public Boolean getFieldIsReferenceOnly() {
    return mIsReferenceOnly;
  }

  public Double getFieldLength() {
    return mLength;
  }

  public Long getFieldLiveAudienceCount() {
    return mLiveAudienceCount;
  }

  public String getFieldLiveStatus() {
    return mLiveStatus;
  }

  public MusicVideoCopyright getFieldMusicVideoCopyright() {
    if (mMusicVideoCopyright != null) {
      mMusicVideoCopyright.context = getContext();
    }
    return mMusicVideoCopyright;
  }

  public String getFieldPermalinkUrl() {
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

  public String getFieldPremiereLivingRoomStatus() {
    return mPremiereLivingRoomStatus;
  }

  public Privacy getFieldPrivacy() {
    return mPrivacy;
  }

  public Boolean getFieldPublished() {
    return mPublished;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public String getFieldSource() {
    return mSource;
  }

  public Boolean getFieldSpherical() {
    return mSpherical;
  }

  public Object getFieldStatus() {
    return mStatus;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldUniversalVideoId() {
    return mUniversalVideoId;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetCaptions extends APIRequest<APINode> {

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
               return APIRequestGetCaptions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCaptions(String nodeId, APIContext context) {
      super(context, nodeId, "/captions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCaptions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCaptions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCaptions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCaptions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCaptions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCaptions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCaptions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCaptions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateCaption extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "captions_file",
      "default_locale",
      "locales_to_delete",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCaption.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCaption(String nodeId, APIContext context) {
      super(context, nodeId, "/captions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCaption setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCaption setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCaption setCaptionsFile (File captionsFile) {
      this.setParam("captions_file", captionsFile);
      return this;
    }
    public APIRequestCreateCaption setCaptionsFile (String captionsFile) {
      this.setParam("captions_file", captionsFile);
      return this;
    }

    public APIRequestCreateCaption setDefaultLocale (String defaultLocale) {
      this.setParam("default_locale", defaultLocale);
      return this;
    }

    public APIRequestCreateCaption setLocalesToDelete (List<String> localesToDelete) {
      this.setParam("locales_to_delete", localesToDelete);
      return this;
    }
    public APIRequestCreateCaption setLocalesToDelete (String localesToDelete) {
      this.setParam("locales_to_delete", localesToDelete);
      return this;
    }

    public APIRequestCreateCaption requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCaption requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCaption requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCaption requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCaption requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCaption requestField (String field, boolean value) {
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
      "attachment_id",
      "attachment_share_url",
      "attachment_url",
      "comment_privacy_value",
      "facepile_mentioned_ids",
      "feedback_source",
      "is_offline",
      "message",
      "nectar_module",
      "object_id",
      "parent_comment_id",
      "text",
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

    public APIRequestCreateComment setCommentPrivacyValue (Comment.EnumCommentPrivacyValue commentPrivacyValue) {
      this.setParam("comment_privacy_value", commentPrivacyValue);
      return this;
    }
    public APIRequestCreateComment setCommentPrivacyValue (String commentPrivacyValue) {
      this.setParam("comment_privacy_value", commentPrivacyValue);
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

    public APIRequestCreateComment setFeedbackSource (String feedbackSource) {
      this.setParam("feedback_source", feedbackSource);
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

    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
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

  public static class APIRequestGetCrosspostSharedPages extends APIRequest<Page> {

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
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
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
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
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
      "supports_donate_button_in_live_video",
      "supports_instant_articles",
      "talking_about_count",
      "temporary_status",
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
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCrosspostSharedPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCrosspostSharedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/crosspost_shared_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCrosspostSharedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCrosspostSharedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCrosspostSharedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCrosspostSharedPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetCrosspostSharedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetCrosspostSharedPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetCrosspostSharedPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetCrosspostSharedPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetCrosspostSharedPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetCrosspostSharedPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
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

  public static class APIRequestCreateLike extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "feedback_source",
      "nectar_module",
      "notify",
      "tracking",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
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

    public APIRequestCreateLike setNotify (Boolean notify) {
      this.setParam("notify", notify);
      return this;
    }
    public APIRequestCreateLike setNotify (String notify) {
      this.setParam("notify", notify);
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

  public static class APIRequestGetPollSettings extends APIRequest<APINode> {

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
               return APIRequestGetPollSettings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPollSettings(String nodeId, APIContext context) {
      super(context, nodeId, "/poll_settings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPollSettings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPollSettings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPollSettings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPollSettings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPollSettings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPollSettings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPollSettings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPollSettings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPolls extends APIRequest<VideoPoll> {

    APINodeList<VideoPoll> lastResponse = null;
    @Override
    public APINodeList<VideoPoll> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "close_after_voting",
      "default_open",
      "id",
      "question",
      "show_gradient",
      "show_results",
      "status",
    };

    @Override
    public APINodeList<VideoPoll> parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<VideoPoll> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoPoll> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoPoll>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoPoll>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<VideoPoll>>() {
           public APINodeList<VideoPoll> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPolls.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPolls(String nodeId, APIContext context) {
      super(context, nodeId, "/polls", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPolls setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPolls setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPolls requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPolls requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPolls requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPolls requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPolls requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPolls requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPolls requestCloseAfterVotingField () {
      return this.requestCloseAfterVotingField(true);
    }
    public APIRequestGetPolls requestCloseAfterVotingField (boolean value) {
      this.requestField("close_after_voting", value);
      return this;
    }
    public APIRequestGetPolls requestDefaultOpenField () {
      return this.requestDefaultOpenField(true);
    }
    public APIRequestGetPolls requestDefaultOpenField (boolean value) {
      this.requestField("default_open", value);
      return this;
    }
    public APIRequestGetPolls requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPolls requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPolls requestQuestionField () {
      return this.requestQuestionField(true);
    }
    public APIRequestGetPolls requestQuestionField (boolean value) {
      this.requestField("question", value);
      return this;
    }
    public APIRequestGetPolls requestShowGradientField () {
      return this.requestShowGradientField(true);
    }
    public APIRequestGetPolls requestShowGradientField (boolean value) {
      this.requestField("show_gradient", value);
      return this;
    }
    public APIRequestGetPolls requestShowResultsField () {
      return this.requestShowResultsField(true);
    }
    public APIRequestGetPolls requestShowResultsField (boolean value) {
      this.requestField("show_results", value);
      return this;
    }
    public APIRequestGetPolls requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPolls requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreatePoll extends APIRequest<VideoPoll> {

    VideoPoll lastResponse = null;
    @Override
    public VideoPoll getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "close_after_voting",
      "correct_option",
      "default_open",
      "options",
      "question",
      "show_gradient",
      "show_results",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoPoll parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoPoll execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoPoll execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoPoll> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoPoll> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoPoll>() {
           public VideoPoll apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePoll.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePoll(String nodeId, APIContext context) {
      super(context, nodeId, "/polls", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePoll setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePoll setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePoll setCloseAfterVoting (Boolean closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }
    public APIRequestCreatePoll setCloseAfterVoting (String closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }

    public APIRequestCreatePoll setCorrectOption (Long correctOption) {
      this.setParam("correct_option", correctOption);
      return this;
    }
    public APIRequestCreatePoll setCorrectOption (String correctOption) {
      this.setParam("correct_option", correctOption);
      return this;
    }

    public APIRequestCreatePoll setDefaultOpen (Boolean defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }
    public APIRequestCreatePoll setDefaultOpen (String defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }

    public APIRequestCreatePoll setOptions (List<String> options) {
      this.setParam("options", options);
      return this;
    }
    public APIRequestCreatePoll setOptions (String options) {
      this.setParam("options", options);
      return this;
    }

    public APIRequestCreatePoll setQuestion (String question) {
      this.setParam("question", question);
      return this;
    }

    public APIRequestCreatePoll setShowGradient (Boolean showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }
    public APIRequestCreatePoll setShowGradient (String showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }

    public APIRequestCreatePoll setShowResults (Boolean showResults) {
      this.setParam("show_results", showResults);
      return this;
    }
    public APIRequestCreatePoll setShowResults (String showResults) {
      this.setParam("show_results", showResults);
      return this;
    }

    public APIRequestCreatePoll requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePoll requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePoll requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePoll requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePoll requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePoll requestField (String field, boolean value) {
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
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "delivery_growth_optimizations",
      "description",
      "entities",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "formatting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "implicit_place",
      "instagram_eligibility",
      "instream_eligibility",
      "is_app_share",
      "is_eligible_for_promotion",
      "is_expired",
      "is_hidden",
      "is_inline_created",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "live_video_eligibility",
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
      "poll",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "publishing_stats",
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
      "translations",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
      "will_be_autocropped_when_deliver_to_instagram",
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
    public APIRequestGetSharedPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetSharedPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
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
    public APIRequestGetSharedPosts requestDeliveryGrowthOptimizationsField () {
      return this.requestDeliveryGrowthOptimizationsField(true);
    }
    public APIRequestGetSharedPosts requestDeliveryGrowthOptimizationsField (boolean value) {
      this.requestField("delivery_growth_optimizations", value);
      return this;
    }
    public APIRequestGetSharedPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetSharedPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetSharedPosts requestEntitiesField () {
      return this.requestEntitiesField(true);
    }
    public APIRequestGetSharedPosts requestEntitiesField (boolean value) {
      this.requestField("entities", value);
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
    public APIRequestGetSharedPosts requestFormattingField () {
      return this.requestFormattingField(true);
    }
    public APIRequestGetSharedPosts requestFormattingField (boolean value) {
      this.requestField("formatting", value);
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
    public APIRequestGetSharedPosts requestImplicitPlaceField () {
      return this.requestImplicitPlaceField(true);
    }
    public APIRequestGetSharedPosts requestImplicitPlaceField (boolean value) {
      this.requestField("implicit_place", value);
      return this;
    }
    public APIRequestGetSharedPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetSharedPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetSharedPosts requestInstreamEligibilityField () {
      return this.requestInstreamEligibilityField(true);
    }
    public APIRequestGetSharedPosts requestInstreamEligibilityField (boolean value) {
      this.requestField("instream_eligibility", value);
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
    public APIRequestGetSharedPosts requestIsInlineCreatedField () {
      return this.requestIsInlineCreatedField(true);
    }
    public APIRequestGetSharedPosts requestIsInlineCreatedField (boolean value) {
      this.requestField("is_inline_created", value);
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
    public APIRequestGetSharedPosts requestLiveVideoEligibilityField () {
      return this.requestLiveVideoEligibilityField(true);
    }
    public APIRequestGetSharedPosts requestLiveVideoEligibilityField (boolean value) {
      this.requestField("live_video_eligibility", value);
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
    public APIRequestGetSharedPosts requestPollField () {
      return this.requestPollField(true);
    }
    public APIRequestGetSharedPosts requestPollField (boolean value) {
      this.requestField("poll", value);
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
    public APIRequestGetSharedPosts requestPublishingStatsField () {
      return this.requestPublishingStatsField(true);
    }
    public APIRequestGetSharedPosts requestPublishingStatsField (boolean value) {
      this.requestField("publishing_stats", value);
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
    public APIRequestGetSharedPosts requestTranslationsField () {
      return this.requestTranslationsField(true);
    }
    public APIRequestGetSharedPosts requestTranslationsField (boolean value) {
      this.requestField("translations", value);
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
    public APIRequestGetSharedPosts requestWillBeAutocroppedWhenDeliverToInstagramField () {
      return this.requestWillBeAutocroppedWhenDeliverToInstagramField(true);
    }
    public APIRequestGetSharedPosts requestWillBeAutocroppedWhenDeliverToInstagramField (boolean value) {
      this.requestField("will_be_autocropped_when_deliver_to_instagram", value);
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
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
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
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
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
      "supports_donate_button_in_live_video",
      "supports_instant_articles",
      "talking_about_count",
      "temporary_status",
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
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSponsorTags.this.parseResponse(result.getBody(), result.getHeader());
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
    public APIRequestGetSponsorTags requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetSponsorTags requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
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
    public APIRequestGetSponsorTags requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetSponsorTags requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
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
    public APIRequestGetSponsorTags requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetSponsorTags requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
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
    public APIRequestGetSponsorTags requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetSponsorTags requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
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
    public APIRequestGetSponsorTags requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetSponsorTags requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
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
    public APIRequestGetSponsorTags requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetSponsorTags requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
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

  public static class APIRequestGetTags extends APIRequest<APINode> {

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
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTags(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateTag extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tag_uid",
      "uid",
      "vid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
             try {
               return APIRequestCreateTag.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateTag(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTag setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTag setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTag setTagUid (Long tagUid) {
      this.setParam("tag_uid", tagUid);
      return this;
    }
    public APIRequestCreateTag setTagUid (String tagUid) {
      this.setParam("tag_uid", tagUid);
      return this;
    }

    public APIRequestCreateTag setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreateTag setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreateTag setVid (String vid) {
      this.setParam("vid", vid);
      return this;
    }

    public APIRequestCreateTag requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTag requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTag requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTag requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTag requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTag requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetThumbnails extends APIRequest<VideoThumbnail> {

    APINodeList<VideoThumbnail> lastResponse = null;
    @Override
    public APINodeList<VideoThumbnail> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "height",
      "id",
      "is_preferred",
      "name",
      "scale",
      "uri",
      "width",
    };

    @Override
    public APINodeList<VideoThumbnail> parseResponse(String response, String header) throws APIException {
      return VideoThumbnail.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<VideoThumbnail> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoThumbnail> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoThumbnail>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoThumbnail>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<VideoThumbnail>>() {
           public APINodeList<VideoThumbnail> apply(ResponseWrapper result) {
             try {
               return APIRequestGetThumbnails.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetThumbnails(String nodeId, APIContext context) {
      super(context, nodeId, "/thumbnails", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetThumbnails setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetThumbnails setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetThumbnails requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetThumbnails requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThumbnails requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetThumbnails requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThumbnails requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetThumbnails requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetThumbnails requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetThumbnails requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetThumbnails requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetThumbnails requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetThumbnails requestIsPreferredField () {
      return this.requestIsPreferredField(true);
    }
    public APIRequestGetThumbnails requestIsPreferredField (boolean value) {
      this.requestField("is_preferred", value);
      return this;
    }
    public APIRequestGetThumbnails requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetThumbnails requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetThumbnails requestScaleField () {
      return this.requestScaleField(true);
    }
    public APIRequestGetThumbnails requestScaleField (boolean value) {
      this.requestField("scale", value);
      return this;
    }
    public APIRequestGetThumbnails requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGetThumbnails requestUriField (boolean value) {
      this.requestField("uri", value);
      return this;
    }
    public APIRequestGetThumbnails requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetThumbnails requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateThumbnail extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_preferred",
      "source",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
             try {
               return APIRequestCreateThumbnail.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateThumbnail(String nodeId, APIContext context) {
      super(context, nodeId, "/thumbnails", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateThumbnail setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateThumbnail setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateThumbnail setIsPreferred (Boolean isPreferred) {
      this.setParam("is_preferred", isPreferred);
      return this;
    }
    public APIRequestCreateThumbnail setIsPreferred (String isPreferred) {
      this.setParam("is_preferred", isPreferred);
      return this;
    }

    public APIRequestCreateThumbnail setSource (File source) {
      this.setParam("source", source);
      return this;
    }
    public APIRequestCreateThumbnail setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateThumbnail requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateThumbnail requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateThumbnail requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateThumbnail requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateThumbnail requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateThumbnail requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVideoInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetVideoInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/video_insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoInsights setMetric (List<Object> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetVideoInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetVideoInsights setPeriod (InsightsResult.EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetVideoInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetVideoInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetVideoInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetVideoInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideoInsights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetVideoInsights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetVideoInsights requestDescriptionFromApiDocField () {
      return this.requestDescriptionFromApiDocField(true);
    }
    public APIRequestGetVideoInsights requestDescriptionFromApiDocField (boolean value) {
      this.requestField("description_from_api_doc", value);
      return this;
    }
    public APIRequestGetVideoInsights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideoInsights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideoInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetVideoInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetVideoInsights requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGetVideoInsights requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGetVideoInsights requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetVideoInsights requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetVideoInsights requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetVideoInsights requestValuesField (boolean value) {
      this.requestField("values", value);
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

  public static class APIRequestGet extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_breaks",
      "backdated_time",
      "backdated_time_granularity",
      "content_category",
      "content_tags",
      "copyright",
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
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdBreaksField () {
      return this.requestAdBreaksField(true);
    }
    public APIRequestGet requestAdBreaksField (boolean value) {
      this.requestField("ad_breaks", value);
      return this;
    }
    public APIRequestGet requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGet requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGet requestBackdatedTimeGranularityField () {
      return this.requestBackdatedTimeGranularityField(true);
    }
    public APIRequestGet requestBackdatedTimeGranularityField (boolean value) {
      this.requestField("backdated_time_granularity", value);
      return this;
    }
    public APIRequestGet requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGet requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGet requestContentTagsField () {
      return this.requestContentTagsField(true);
    }
    public APIRequestGet requestContentTagsField (boolean value) {
      this.requestField("content_tags", value);
      return this;
    }
    public APIRequestGet requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGet requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
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
    public APIRequestGet requestCustomLabelsField () {
      return this.requestCustomLabelsField(true);
    }
    public APIRequestGet requestCustomLabelsField (boolean value) {
      this.requestField("custom_labels", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGet requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGet requestEmbeddableField () {
      return this.requestEmbeddableField(true);
    }
    public APIRequestGet requestEmbeddableField (boolean value) {
      this.requestField("embeddable", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestExpirationField () {
      return this.requestExpirationField(true);
    }
    public APIRequestGet requestExpirationField (boolean value) {
      this.requestField("expiration", value);
      return this;
    }
    public APIRequestGet requestFormatField () {
      return this.requestFormatField(true);
    }
    public APIRequestGet requestFormatField (boolean value) {
      this.requestField("format", value);
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
    public APIRequestGet requestIsCrosspostVideoField () {
      return this.requestIsCrosspostVideoField(true);
    }
    public APIRequestGet requestIsCrosspostVideoField (boolean value) {
      this.requestField("is_crosspost_video", value);
      return this;
    }
    public APIRequestGet requestIsCrosspostingEligibleField () {
      return this.requestIsCrosspostingEligibleField(true);
    }
    public APIRequestGet requestIsCrosspostingEligibleField (boolean value) {
      this.requestField("is_crossposting_eligible", value);
      return this;
    }
    public APIRequestGet requestIsEpisodeField () {
      return this.requestIsEpisodeField(true);
    }
    public APIRequestGet requestIsEpisodeField (boolean value) {
      this.requestField("is_episode", value);
      return this;
    }
    public APIRequestGet requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGet requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGet requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGet requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGet requestLengthField () {
      return this.requestLengthField(true);
    }
    public APIRequestGet requestLengthField (boolean value) {
      this.requestField("length", value);
      return this;
    }
    public APIRequestGet requestLiveAudienceCountField () {
      return this.requestLiveAudienceCountField(true);
    }
    public APIRequestGet requestLiveAudienceCountField (boolean value) {
      this.requestField("live_audience_count", value);
      return this;
    }
    public APIRequestGet requestLiveStatusField () {
      return this.requestLiveStatusField(true);
    }
    public APIRequestGet requestLiveStatusField (boolean value) {
      this.requestField("live_status", value);
      return this;
    }
    public APIRequestGet requestMusicVideoCopyrightField () {
      return this.requestMusicVideoCopyrightField(true);
    }
    public APIRequestGet requestMusicVideoCopyrightField (boolean value) {
      this.requestField("music_video_copyright", value);
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
    public APIRequestGet requestPremiereLivingRoomStatusField () {
      return this.requestPremiereLivingRoomStatusField(true);
    }
    public APIRequestGet requestPremiereLivingRoomStatusField (boolean value) {
      this.requestField("premiere_living_room_status", value);
      return this;
    }
    public APIRequestGet requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGet requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
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
    public APIRequestGet requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGet requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGet requestSphericalField () {
      return this.requestSphericalField(true);
    }
    public APIRequestGet requestSphericalField (boolean value) {
      this.requestField("spherical", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUniversalVideoIdField () {
      return this.requestUniversalVideoIdField(true);
    }
    public APIRequestGet requestUniversalVideoIdField (boolean value) {
      this.requestField("universal_video_id", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_breaks",
      "allow_bm_crossposting",
      "allow_crossposting_for_pages",
      "backdated_time",
      "backdated_time_granularity",
      "call_to_action",
      "content_category",
      "content_tags",
      "custom_labels",
      "description",
      "direct_share_status",
      "embeddable",
      "expiration",
      "expire_now",
      "increment_play_count",
      "name",
      "preferred_thumbnail_id",
      "privacy",
      "publish_to_news_feed",
      "publish_to_videos_tab",
      "published",
      "scheduled_publish_time",
      "social_actions",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "target",
      "universal_video_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAdBreaks (JsonArray adBreaks) {
      this.setParam("ad_breaks", adBreaks);
      return this;
    }
    public APIRequestUpdate setAdBreaks (String adBreaks) {
      this.setParam("ad_breaks", adBreaks);
      return this;
    }

    public APIRequestUpdate setAllowBmCrossposting (Boolean allowBmCrossposting) {
      this.setParam("allow_bm_crossposting", allowBmCrossposting);
      return this;
    }
    public APIRequestUpdate setAllowBmCrossposting (String allowBmCrossposting) {
      this.setParam("allow_bm_crossposting", allowBmCrossposting);
      return this;
    }

    public APIRequestUpdate setAllowCrosspostingForPages (List<Object> allowCrosspostingForPages) {
      this.setParam("allow_crossposting_for_pages", allowCrosspostingForPages);
      return this;
    }
    public APIRequestUpdate setAllowCrosspostingForPages (String allowCrosspostingForPages) {
      this.setParam("allow_crossposting_for_pages", allowCrosspostingForPages);
      return this;
    }

    public APIRequestUpdate setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestUpdate setBackdatedTimeGranularity (AdVideo.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestUpdate setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestUpdate setCallToAction (Object callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }
    public APIRequestUpdate setCallToAction (String callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }

    public APIRequestUpdate setContentCategory (AdVideo.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestUpdate setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestUpdate setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestUpdate setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }

    public APIRequestUpdate setCustomLabels (List<String> customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }
    public APIRequestUpdate setCustomLabels (String customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestUpdate setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestUpdate setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestUpdate setExpiration (Object expiration) {
      this.setParam("expiration", expiration);
      return this;
    }
    public APIRequestUpdate setExpiration (String expiration) {
      this.setParam("expiration", expiration);
      return this;
    }

    public APIRequestUpdate setExpireNow (Boolean expireNow) {
      this.setParam("expire_now", expireNow);
      return this;
    }
    public APIRequestUpdate setExpireNow (String expireNow) {
      this.setParam("expire_now", expireNow);
      return this;
    }

    public APIRequestUpdate setIncrementPlayCount (Boolean incrementPlayCount) {
      this.setParam("increment_play_count", incrementPlayCount);
      return this;
    }
    public APIRequestUpdate setIncrementPlayCount (String incrementPlayCount) {
      this.setParam("increment_play_count", incrementPlayCount);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPreferredThumbnailId (String preferredThumbnailId) {
      this.setParam("preferred_thumbnail_id", preferredThumbnailId);
      return this;
    }

    public APIRequestUpdate setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestUpdate setPublishToNewsFeed (Boolean publishToNewsFeed) {
      this.setParam("publish_to_news_feed", publishToNewsFeed);
      return this;
    }
    public APIRequestUpdate setPublishToNewsFeed (String publishToNewsFeed) {
      this.setParam("publish_to_news_feed", publishToNewsFeed);
      return this;
    }

    public APIRequestUpdate setPublishToVideosTab (Boolean publishToVideosTab) {
      this.setParam("publish_to_videos_tab", publishToVideosTab);
      return this;
    }
    public APIRequestUpdate setPublishToVideosTab (String publishToVideosTab) {
      this.setParam("publish_to_videos_tab", publishToVideosTab);
      return this;
    }

    public APIRequestUpdate setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestUpdate setPublished (String published) {
      this.setParam("published", published);
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

    public APIRequestUpdate setSocialActions (Boolean socialActions) {
      this.setParam("social_actions", socialActions);
      return this;
    }
    public APIRequestUpdate setSocialActions (String socialActions) {
      this.setParam("social_actions", socialActions);
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

    public APIRequestUpdate setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestUpdate setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestUpdate setTarget (String target) {
      this.setParam("target", target);
      return this;
    }

    public APIRequestUpdate setUniversalVideoId (String universalVideoId) {
      this.setParam("universal_video_id", universalVideoId);
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

  public static enum EnumContainerType {
      @SerializedName("ACO_VIDEO_VARIATION")
      VALUE_ACO_VIDEO_VARIATION("ACO_VIDEO_VARIATION"),
      @SerializedName("AD_BREAK_PREVIEW")
      VALUE_AD_BREAK_PREVIEW("AD_BREAK_PREVIEW"),
      @SerializedName("AD_DERIVATIVE")
      VALUE_AD_DERIVATIVE("AD_DERIVATIVE"),
      @SerializedName("AGE_UP")
      VALUE_AGE_UP("AGE_UP"),
      @SerializedName("ALBUM_MULTIMEDIA_POST")
      VALUE_ALBUM_MULTIMEDIA_POST("ALBUM_MULTIMEDIA_POST"),
      @SerializedName("ALOHA_CALL_VIDEO")
      VALUE_ALOHA_CALL_VIDEO("ALOHA_CALL_VIDEO"),
      @SerializedName("ALOHA_SUPERFRAME")
      VALUE_ALOHA_SUPERFRAME("ALOHA_SUPERFRAME"),
      @SerializedName("APP_REVIEW_SCREENCAST")
      VALUE_APP_REVIEW_SCREENCAST("APP_REVIEW_SCREENCAST"),
      @SerializedName("ATLAS_VIDEO")
      VALUE_ATLAS_VIDEO("ATLAS_VIDEO"),
      @SerializedName("AUDIO_BROADCAST")
      VALUE_AUDIO_BROADCAST("AUDIO_BROADCAST"),
      @SerializedName("BELL_POLL")
      VALUE_BELL_POLL("BELL_POLL"),
      @SerializedName("BRAND_EQUITY_POLL_VIDEO")
      VALUE_BRAND_EQUITY_POLL_VIDEO("BRAND_EQUITY_POLL_VIDEO"),
      @SerializedName("BROADCAST")
      VALUE_BROADCAST("BROADCAST"),
      @SerializedName("CANDIDATE_VIDEOS")
      VALUE_CANDIDATE_VIDEOS("CANDIDATE_VIDEOS"),
      @SerializedName("CANVAS")
      VALUE_CANVAS("CANVAS"),
      @SerializedName("CFC_VIDEO")
      VALUE_CFC_VIDEO("CFC_VIDEO"),
      @SerializedName("CONTAINED_POST_ATTACHMENT")
      VALUE_CONTAINED_POST_ATTACHMENT("CONTAINED_POST_ATTACHMENT"),
      @SerializedName("CONTAINED_POST_AUDIO_BROADCAST")
      VALUE_CONTAINED_POST_AUDIO_BROADCAST("CONTAINED_POST_AUDIO_BROADCAST"),
      @SerializedName("CONTAINED_POST_BROADCAST")
      VALUE_CONTAINED_POST_BROADCAST("CONTAINED_POST_BROADCAST"),
      @SerializedName("COPYRIGHT_REFERENCE_BROADCAST")
      VALUE_COPYRIGHT_REFERENCE_BROADCAST("COPYRIGHT_REFERENCE_BROADCAST"),
      @SerializedName("COPYRIGHT_REFERENCE_VIDEO")
      VALUE_COPYRIGHT_REFERENCE_VIDEO("COPYRIGHT_REFERENCE_VIDEO"),
      @SerializedName("CULTURAL_MOMENT_DEPRECATED")
      VALUE_CULTURAL_MOMENT_DEPRECATED("CULTURAL_MOMENT_DEPRECATED"),
      @SerializedName("DCO_AD_ASSET_FEED")
      VALUE_DCO_AD_ASSET_FEED("DCO_AD_ASSET_FEED"),
      @SerializedName("DCO_AUTOGEN_VIDEO")
      VALUE_DCO_AUTOGEN_VIDEO("DCO_AUTOGEN_VIDEO"),
      @SerializedName("DCO_TRIMMED_VIDEO")
      VALUE_DCO_TRIMMED_VIDEO("DCO_TRIMMED_VIDEO"),
      @SerializedName("DIM_SUM")
      VALUE_DIM_SUM("DIM_SUM"),
      @SerializedName("DIRECTED_POST_ATTACHMENT")
      VALUE_DIRECTED_POST_ATTACHMENT("DIRECTED_POST_ATTACHMENT"),
      @SerializedName("DIRECT_INBOX")
      VALUE_DIRECT_INBOX("DIRECT_INBOX"),
      @SerializedName("DIRECT_INBOX_REACTION")
      VALUE_DIRECT_INBOX_REACTION("DIRECT_INBOX_REACTION"),
      @SerializedName("DYNAMIC_ITEM_DISPLAY_BUNDLE")
      VALUE_DYNAMIC_ITEM_DISPLAY_BUNDLE("DYNAMIC_ITEM_DISPLAY_BUNDLE"),
      @SerializedName("DYNAMIC_ITEM_VIDEO")
      VALUE_DYNAMIC_ITEM_VIDEO("DYNAMIC_ITEM_VIDEO"),
      @SerializedName("DYNAMIC_TEMPLATE_VIDEO")
      VALUE_DYNAMIC_TEMPLATE_VIDEO("DYNAMIC_TEMPLATE_VIDEO"),
      @SerializedName("EVENT_COVER_VIDEO")
      VALUE_EVENT_COVER_VIDEO("EVENT_COVER_VIDEO"),
      @SerializedName("EVENT_TOUR")
      VALUE_EVENT_TOUR("EVENT_TOUR"),
      @SerializedName("FACECAST_DVR")
      VALUE_FACECAST_DVR("FACECAST_DVR"),
      @SerializedName("FB_SHORTS")
      VALUE_FB_SHORTS("FB_SHORTS"),
      @SerializedName("FUNDRAISER_COVER_VIDEO")
      VALUE_FUNDRAISER_COVER_VIDEO("FUNDRAISER_COVER_VIDEO"),
      @SerializedName("GAME_CLIP")
      VALUE_GAME_CLIP("GAME_CLIP"),
      @SerializedName("GAMING_UPDATE_VIDEO")
      VALUE_GAMING_UPDATE_VIDEO("GAMING_UPDATE_VIDEO"),
      @SerializedName("GEMSTONE")
      VALUE_GEMSTONE("GEMSTONE"),
      @SerializedName("GOODWILL_ANNIVERSARY_DEPRECATED")
      VALUE_GOODWILL_ANNIVERSARY_DEPRECATED("GOODWILL_ANNIVERSARY_DEPRECATED"),
      @SerializedName("GOODWILL_ANNIVERSARY_PROMOTION_DEPRECATED")
      VALUE_GOODWILL_ANNIVERSARY_PROMOTION_DEPRECATED("GOODWILL_ANNIVERSARY_PROMOTION_DEPRECATED"),
      @SerializedName("GOODWILL_VIDEO_CONTAINED_SHARE")
      VALUE_GOODWILL_VIDEO_CONTAINED_SHARE("GOODWILL_VIDEO_CONTAINED_SHARE"),
      @SerializedName("GOODWILL_VIDEO_PROMOTION")
      VALUE_GOODWILL_VIDEO_PROMOTION("GOODWILL_VIDEO_PROMOTION"),
      @SerializedName("GOODWILL_VIDEO_SHARE")
      VALUE_GOODWILL_VIDEO_SHARE("GOODWILL_VIDEO_SHARE"),
      @SerializedName("GOODWILL_VIDEO_TOKEN_REQUIRED")
      VALUE_GOODWILL_VIDEO_TOKEN_REQUIRED("GOODWILL_VIDEO_TOKEN_REQUIRED"),
      @SerializedName("GROUP_POST")
      VALUE_GROUP_POST("GROUP_POST"),
      @SerializedName("HEURISTIC_CLUSTER_VIDEO")
      VALUE_HEURISTIC_CLUSTER_VIDEO("HEURISTIC_CLUSTER_VIDEO"),
      @SerializedName("HEURISTIC_PREVIEW")
      VALUE_HEURISTIC_PREVIEW("HEURISTIC_PREVIEW"),
      @SerializedName("HIGHLIGHT_CLIP_VIDEO")
      VALUE_HIGHLIGHT_CLIP_VIDEO("HIGHLIGHT_CLIP_VIDEO"),
      @SerializedName("IG_STORIES_READER")
      VALUE_IG_STORIES_READER("IG_STORIES_READER"),
      @SerializedName("INSPIRATION_VIDEO")
      VALUE_INSPIRATION_VIDEO("INSPIRATION_VIDEO"),
      @SerializedName("INSTAGRAM_VIDEO_COPY")
      VALUE_INSTAGRAM_VIDEO_COPY("INSTAGRAM_VIDEO_COPY"),
      @SerializedName("INSTANT_APPLICATION_PREVIEW")
      VALUE_INSTANT_APPLICATION_PREVIEW("INSTANT_APPLICATION_PREVIEW"),
      @SerializedName("INSTANT_ARTICLE")
      VALUE_INSTANT_ARTICLE("INSTANT_ARTICLE"),
      @SerializedName("INSTANT_GAME_CLIP")
      VALUE_INSTANT_GAME_CLIP("INSTANT_GAME_CLIP"),
      @SerializedName("ISSUE_MODULE")
      VALUE_ISSUE_MODULE("ISSUE_MODULE"),
      @SerializedName("JOB_APPLICATION_VIDEO")
      VALUE_JOB_APPLICATION_VIDEO("JOB_APPLICATION_VIDEO"),
      @SerializedName("JOB_OPENING_VIDEO")
      VALUE_JOB_OPENING_VIDEO("JOB_OPENING_VIDEO"),
      @SerializedName("KOTOTORO")
      VALUE_KOTOTORO("KOTOTORO"),
      @SerializedName("LEARN")
      VALUE_LEARN("LEARN"),
      @SerializedName("LEGACY")
      VALUE_LEGACY("LEGACY"),
      @SerializedName("LIVE_CREATIVE_KIT_VIDEO")
      VALUE_LIVE_CREATIVE_KIT_VIDEO("LIVE_CREATIVE_KIT_VIDEO"),
      @SerializedName("LIVE_LINEAR_VIDEO_CHANNEL_INTERNAL_BROADCAST")
      VALUE_LIVE_LINEAR_VIDEO_CHANNEL_INTERNAL_BROADCAST("LIVE_LINEAR_VIDEO_CHANNEL_INTERNAL_BROADCAST"),
      @SerializedName("LIVE_PHOTO")
      VALUE_LIVE_PHOTO("LIVE_PHOTO"),
      @SerializedName("LOOK_NOW_DEPRECATED")
      VALUE_LOOK_NOW_DEPRECATED("LOOK_NOW_DEPRECATED"),
      @SerializedName("MARKETPLACE_LISTING_VIDEO")
      VALUE_MARKETPLACE_LISTING_VIDEO("MARKETPLACE_LISTING_VIDEO"),
      @SerializedName("MARKETPLACE_PRE_RECORDED_VIDEO")
      VALUE_MARKETPLACE_PRE_RECORDED_VIDEO("MARKETPLACE_PRE_RECORDED_VIDEO"),
      @SerializedName("MOMENTS_VIDEO")
      VALUE_MOMENTS_VIDEO("MOMENTS_VIDEO"),
      @SerializedName("NEO_ASYNC_GAME_VIDEO")
      VALUE_NEO_ASYNC_GAME_VIDEO("NEO_ASYNC_GAME_VIDEO"),
      @SerializedName("NO_STORY")
      VALUE_NO_STORY("NO_STORY"),
      @SerializedName("NO_STORY_WITH_ENTPOST")
      VALUE_NO_STORY_WITH_ENTPOST("NO_STORY_WITH_ENTPOST"),
      @SerializedName("OCULUS_CREATOR_PORTAL")
      VALUE_OCULUS_CREATOR_PORTAL("OCULUS_CREATOR_PORTAL"),
      @SerializedName("OCULUS_VENUES_BROADCAST")
      VALUE_OCULUS_VENUES_BROADCAST("OCULUS_VENUES_BROADCAST"),
      @SerializedName("OFFERS_VIDEO")
      VALUE_OFFERS_VIDEO("OFFERS_VIDEO"),
      @SerializedName("PAGES_COVER_VIDEO")
      VALUE_PAGES_COVER_VIDEO("PAGES_COVER_VIDEO"),
      @SerializedName("PAGE_REVIEW_SCREENCAST")
      VALUE_PAGE_REVIEW_SCREENCAST("PAGE_REVIEW_SCREENCAST"),
      @SerializedName("PAGE_SLIDESHOW_VIDEO")
      VALUE_PAGE_SLIDESHOW_VIDEO("PAGE_SLIDESHOW_VIDEO"),
      @SerializedName("PIXELCLOUD")
      VALUE_PIXELCLOUD("PIXELCLOUD"),
      @SerializedName("PREMIERE_SOURCE")
      VALUE_PREMIERE_SOURCE("PREMIERE_SOURCE"),
      @SerializedName("PRIVATE_GALLERY_VIDEO")
      VALUE_PRIVATE_GALLERY_VIDEO("PRIVATE_GALLERY_VIDEO"),
      @SerializedName("PRODUCT_VIDEO")
      VALUE_PRODUCT_VIDEO("PRODUCT_VIDEO"),
      @SerializedName("PROFILE_COVER_VIDEO")
      VALUE_PROFILE_COVER_VIDEO("PROFILE_COVER_VIDEO"),
      @SerializedName("PROFILE_INTRO_CARD")
      VALUE_PROFILE_INTRO_CARD("PROFILE_INTRO_CARD"),
      @SerializedName("PROFILE_TO_PAGE_UPLOADED_VIDEO")
      VALUE_PROFILE_TO_PAGE_UPLOADED_VIDEO("PROFILE_TO_PAGE_UPLOADED_VIDEO"),
      @SerializedName("PROFILE_VIDEO")
      VALUE_PROFILE_VIDEO("PROFILE_VIDEO"),
      @SerializedName("PROTON")
      VALUE_PROTON("PROTON"),
      @SerializedName("QUICK_PROMOTION")
      VALUE_QUICK_PROMOTION("QUICK_PROMOTION"),
      @SerializedName("REPLACE_VIDEO")
      VALUE_REPLACE_VIDEO("REPLACE_VIDEO"),
      @SerializedName("SALES_CLIENT_INTERACTION")
      VALUE_SALES_CLIENT_INTERACTION("SALES_CLIENT_INTERACTION"),
      @SerializedName("SAY_THANKS_DEPRECATED")
      VALUE_SAY_THANKS_DEPRECATED("SAY_THANKS_DEPRECATED"),
      @SerializedName("SHOWREEL_NATIVE_DUMMY_VIDEO")
      VALUE_SHOWREEL_NATIVE_DUMMY_VIDEO("SHOWREEL_NATIVE_DUMMY_VIDEO"),
      @SerializedName("SLIDESHOW_ANIMOTO")
      VALUE_SLIDESHOW_ANIMOTO("SLIDESHOW_ANIMOTO"),
      @SerializedName("SLIDESHOW_SHAKR")
      VALUE_SLIDESHOW_SHAKR("SLIDESHOW_SHAKR"),
      @SerializedName("SLIDESHOW_VARIATION_VIDEO")
      VALUE_SLIDESHOW_VARIATION_VIDEO("SLIDESHOW_VARIATION_VIDEO"),
      @SerializedName("SOTTO_CONTENT")
      VALUE_SOTTO_CONTENT("SOTTO_CONTENT"),
      @SerializedName("SOUND_PLATFORM_STREAM")
      VALUE_SOUND_PLATFORM_STREAM("SOUND_PLATFORM_STREAM"),
      @SerializedName("STORIES_VIDEO")
      VALUE_STORIES_VIDEO("STORIES_VIDEO"),
      @SerializedName("STORYLINE")
      VALUE_STORYLINE("STORYLINE"),
      @SerializedName("STORYLINE_WITH_EXTERNAL_MUSIC")
      VALUE_STORYLINE_WITH_EXTERNAL_MUSIC("STORYLINE_WITH_EXTERNAL_MUSIC"),
      @SerializedName("STORY_ARCHIVE_VIDEO")
      VALUE_STORY_ARCHIVE_VIDEO("STORY_ARCHIVE_VIDEO"),
      @SerializedName("STORY_CARD_TEMPLATE")
      VALUE_STORY_CARD_TEMPLATE("STORY_CARD_TEMPLATE"),
      @SerializedName("TAROT_DIGEST")
      VALUE_TAROT_DIGEST("TAROT_DIGEST"),
      @SerializedName("TEMP_MULTIMEDIA_POST")
      VALUE_TEMP_MULTIMEDIA_POST("TEMP_MULTIMEDIA_POST"),
      @SerializedName("UNLISTED")
      VALUE_UNLISTED("UNLISTED"),
      @SerializedName("VIDEO_COMMENT")
      VALUE_VIDEO_COMMENT("VIDEO_COMMENT"),
      @SerializedName("VIDEO_CREATIVE_EDITOR_AUTOGEN_AD_VIDEO")
      VALUE_VIDEO_CREATIVE_EDITOR_AUTOGEN_AD_VIDEO("VIDEO_CREATIVE_EDITOR_AUTOGEN_AD_VIDEO"),
      @SerializedName("VIDEO_SUPERRES")
      VALUE_VIDEO_SUPERRES("VIDEO_SUPERRES"),
      @SerializedName("VU_GENERATED_VIDEO")
      VALUE_VU_GENERATED_VIDEO("VU_GENERATED_VIDEO"),
      @SerializedName("WOODHENGE")
      VALUE_WOODHENGE("WOODHENGE"),
      @SerializedName("WORK_KNOWLEDGE_VIDEO")
      VALUE_WORK_KNOWLEDGE_VIDEO("WORK_KNOWLEDGE_VIDEO"),
      @SerializedName("YOUR_DAY")
      VALUE_YOUR_DAY("YOUR_DAY"),
      ;

      private String value;

      private EnumContainerType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumContentCategory {
      @SerializedName("BEAUTY_FASHION")
      VALUE_BEAUTY_FASHION("BEAUTY_FASHION"),
      @SerializedName("BUSINESS")
      VALUE_BUSINESS("BUSINESS"),
      @SerializedName("CARS_TRUCKS")
      VALUE_CARS_TRUCKS("CARS_TRUCKS"),
      @SerializedName("COMEDY")
      VALUE_COMEDY("COMEDY"),
      @SerializedName("CUTE_ANIMALS")
      VALUE_CUTE_ANIMALS("CUTE_ANIMALS"),
      @SerializedName("ENTERTAINMENT")
      VALUE_ENTERTAINMENT("ENTERTAINMENT"),
      @SerializedName("FAMILY")
      VALUE_FAMILY("FAMILY"),
      @SerializedName("FOOD_HEALTH")
      VALUE_FOOD_HEALTH("FOOD_HEALTH"),
      @SerializedName("HOME")
      VALUE_HOME("HOME"),
      @SerializedName("LIFESTYLE")
      VALUE_LIFESTYLE("LIFESTYLE"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NEWS")
      VALUE_NEWS("NEWS"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("POLITICS")
      VALUE_POLITICS("POLITICS"),
      @SerializedName("SCIENCE")
      VALUE_SCIENCE("SCIENCE"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("VIDEO_GAMING")
      VALUE_VIDEO_GAMING("VIDEO_GAMING"),
      ;

      private String value;

      private EnumContentCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFormatting {
      @SerializedName("MARKDOWN")
      VALUE_MARKDOWN("MARKDOWN"),
      @SerializedName("PLAINTEXT")
      VALUE_PLAINTEXT("PLAINTEXT"),
      ;

      private String value;

      private EnumFormatting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginalProjectionType {
      @SerializedName("cubemap")
      VALUE_CUBEMAP("cubemap"),
      @SerializedName("equirectangular")
      VALUE_EQUIRECTANGULAR("equirectangular"),
      @SerializedName("half_equirectangular")
      VALUE_HALF_EQUIRECTANGULAR("half_equirectangular"),
      ;

      private String value;

      private EnumOriginalProjectionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSwapMode {
      @SerializedName("replace")
      VALUE_REPLACE("replace"),
      ;

      private String value;

      private EnumSwapMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUnpublishedContentType {
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      @SerializedName("REVIEWABLE_BRANDED_CONTENT")
      VALUE_REVIEWABLE_BRANDED_CONTENT("REVIEWABLE_BRANDED_CONTENT"),
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("SCHEDULED_RECURRING")
      VALUE_SCHEDULED_RECURRING("SCHEDULED_RECURRING"),
      ;

      private String value;

      private EnumUnpublishedContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUploadPhase {
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      @SerializedName("finish")
      VALUE_FINISH("finish"),
      @SerializedName("start")
      VALUE_START("start"),
      @SerializedName("transfer")
      VALUE_TRANSFER("transfer"),
      ;

      private String value;

      private EnumUploadPhase(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("tagged")
      VALUE_TAGGED("tagged"),
      @SerializedName("uploaded")
      VALUE_UPLOADED("uploaded"),
      ;

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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
      ;

      private String value;

      private EnumBackdatedTimeGranularity(String value) {
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

  public AdVideo copyFrom(AdVideo instance) {
    this.mAdBreaks = instance.mAdBreaks;
    this.mBackdatedTime = instance.mBackdatedTime;
    this.mBackdatedTimeGranularity = instance.mBackdatedTimeGranularity;
    this.mContentCategory = instance.mContentCategory;
    this.mContentTags = instance.mContentTags;
    this.mCopyright = instance.mCopyright;
    this.mCopyrightMonitoringStatus = instance.mCopyrightMonitoringStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCustomLabels = instance.mCustomLabels;
    this.mDescription = instance.mDescription;
    this.mEmbedHtml = instance.mEmbedHtml;
    this.mEmbeddable = instance.mEmbeddable;
    this.mEvent = instance.mEvent;
    this.mExpiration = instance.mExpiration;
    this.mFormat = instance.mFormat;
    this.mFrom = instance.mFrom;
    this.mIcon = instance.mIcon;
    this.mId = instance.mId;
    this.mIsCrosspostVideo = instance.mIsCrosspostVideo;
    this.mIsCrosspostingEligible = instance.mIsCrosspostingEligible;
    this.mIsEpisode = instance.mIsEpisode;
    this.mIsInstagramEligible = instance.mIsInstagramEligible;
    this.mIsReferenceOnly = instance.mIsReferenceOnly;
    this.mLength = instance.mLength;
    this.mLiveAudienceCount = instance.mLiveAudienceCount;
    this.mLiveStatus = instance.mLiveStatus;
    this.mMusicVideoCopyright = instance.mMusicVideoCopyright;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPicture = instance.mPicture;
    this.mPlace = instance.mPlace;
    this.mPremiereLivingRoomStatus = instance.mPremiereLivingRoomStatus;
    this.mPrivacy = instance.mPrivacy;
    this.mPublished = instance.mPublished;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mSource = instance.mSource;
    this.mSpherical = instance.mSpherical;
    this.mStatus = instance.mStatus;
    this.mTitle = instance.mTitle;
    this.mUniversalVideoId = instance.mUniversalVideoId;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdVideo> getParser() {
    return new APIRequest.ResponseParser<AdVideo>() {
      public APINodeList<AdVideo> parseResponse(String response, APIContext context, APIRequest<AdVideo> request, String header) throws MalformedResponseException {
        return AdVideo.parseResponse(response, context, request, header);
      }
    };
  }
}
