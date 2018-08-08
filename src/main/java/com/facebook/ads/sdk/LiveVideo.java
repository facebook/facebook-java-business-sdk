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
public class LiveVideo extends APINode {
  @SerializedName("ad_break_config")
  private Object mAdBreakConfig = null;
  @SerializedName("ad_break_failure_reason")
  private String mAdBreakFailureReason = null;
  @SerializedName("broadcast_start_time")
  private String mBroadcastStartTime = null;
  @SerializedName("copyright")
  private VideoCopyright mCopyright = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("dash_ingest_url")
  private String mDashIngestUrl = null;
  @SerializedName("dash_preview_url")
  private String mDashPreviewUrl = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("embed_html")
  private String mEmbedHtml = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_manual_mode")
  private Boolean mIsManualMode = null;
  @SerializedName("is_reference_only")
  private Boolean mIsReferenceOnly = null;
  @SerializedName("live_encoders")
  private List<Object> mLiveEncoders = null;
  @SerializedName("live_views")
  private Long mLiveViews = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("planned_start_time")
  private String mPlannedStartTime = null;
  @SerializedName("seconds_left")
  private Long mSecondsLeft = null;
  @SerializedName("secure_stream_url")
  private String mSecureStreamUrl = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("stream_url")
  private String mStreamUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("video")
  private Object mVideo = null;
  protected static Gson gson = null;

  LiveVideo() {
  }

  public LiveVideo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveVideo(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public LiveVideo fetch() throws APIException{
    LiveVideo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveVideo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveVideo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveVideo fetchById(String id, APIContext context) throws APIException {
    LiveVideo liveVideo =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return liveVideo;
  }

  public static ListenableFuture<LiveVideo> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<LiveVideo> liveVideo =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return liveVideo;
  }

  public static APINodeList<LiveVideo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveVideo>)(
      new APIRequest<LiveVideo>(context, "", "/", "GET", LiveVideo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveVideo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<LiveVideo>> liveVideo =
      new APIRequest(context, "", "/", "GET", LiveVideo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return liveVideo;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LiveVideo loadJSON(String json, APIContext context) {
    LiveVideo liveVideo = getGson().fromJson(json, LiveVideo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveVideo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    liveVideo.context = context;
    liveVideo.rawValue = json;
    return liveVideo;
  }

  public static APINodeList<LiveVideo> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LiveVideo> liveVideos = new APINodeList<LiveVideo>(request, json);
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
          liveVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return liveVideos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveVideos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveVideos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveVideos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  liveVideos.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveVideos.add(loadJSON(obj.toString(), context));
            }
          }
          return liveVideos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveVideos.add(loadJSON(entry.getValue().toString(), context));
          }
          return liveVideos;
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
              liveVideos.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveVideos;
          }

          // Sixth, check if it's pure JsonObject
          liveVideos.clear();
          liveVideos.add(loadJSON(json, context));
          return liveVideos;
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


  public Object getFieldAdBreakConfig() {
    return mAdBreakConfig;
  }

  public String getFieldAdBreakFailureReason() {
    return mAdBreakFailureReason;
  }

  public String getFieldBroadcastStartTime() {
    return mBroadcastStartTime;
  }

  public VideoCopyright getFieldCopyright() {
    if (mCopyright != null) {
      mCopyright.context = getContext();
    }
    return mCopyright;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldDashIngestUrl() {
    return mDashIngestUrl;
  }

  public String getFieldDashPreviewUrl() {
    return mDashPreviewUrl;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEmbedHtml() {
    return mEmbedHtml;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsManualMode() {
    return mIsManualMode;
  }

  public Boolean getFieldIsReferenceOnly() {
    return mIsReferenceOnly;
  }

  public List<Object> getFieldLiveEncoders() {
    return mLiveEncoders;
  }

  public Long getFieldLiveViews() {
    return mLiveViews;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public String getFieldPlannedStartTime() {
    return mPlannedStartTime;
  }

  public Long getFieldSecondsLeft() {
    return mSecondsLeft;
  }

  public String getFieldSecureStreamUrl() {
    return mSecureStreamUrl;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStreamUrl() {
    return mStreamUrl;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public Object getFieldVideo() {
    return mVideo;
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

  public static class APIRequestGet extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_break_config",
      "ad_break_failure_reason",
      "broadcast_start_time",
      "copyright",
      "creation_time",
      "dash_ingest_url",
      "dash_preview_url",
      "description",
      "embed_html",
      "from",
      "id",
      "is_manual_mode",
      "is_reference_only",
      "live_encoders",
      "live_views",
      "permalink_url",
      "planned_start_time",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "title",
      "video",
    };

    @Override
    public LiveVideo parseResponse(String response) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LiveVideo>() {
           public LiveVideo apply(String result) {
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

    public APIRequestGet requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGet requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGet requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGet requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGet requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGet requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGet requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGet requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGet requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGet requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGet requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
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
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGet requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGet requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGet requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGet requestLiveEncodersField () {
      return this.requestLiveEncodersField(true);
    }
    public APIRequestGet requestLiveEncodersField (boolean value) {
      this.requestField("live_encoders", value);
      return this;
    }
    public APIRequestGet requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGet requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGet requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGet requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGet requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGet requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGet requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGet requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGet requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGet requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
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
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
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

  public static class APIRequestUpdate extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_break_drop_live_stream",
      "ad_break_duration",
      "ad_break_encoder_drops_live_stream",
      "ad_break_intent",
      "ad_break_start_now",
      "ad_break_time_offset",
      "allow_bm_crossposting",
      "attribution_app_id",
      "attribution_app_metadata",
      "commercial_break_durations",
      "content_tags",
      "crossposting_actions",
      "custom_labels",
      "description",
      "direct_share_status",
      "disturbing",
      "embeddable",
      "end_live_video",
      "is_manual_mode",
      "live_comment_moderation_setting",
      "live_encoders",
      "place",
      "planned_start_time",
      "privacy",
      "product_items",
      "published",
      "schedule_custom_profile_image",
      "schedule_feed_background_image",
      "sponsor_id",
      "sponsor_relationship",
      "status",
      "stream_type",
      "tags",
      "targeting",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveVideo parseResponse(String response) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LiveVideo>() {
           public LiveVideo apply(String result) {
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


    public APIRequestUpdate setAdBreakDropLiveStream (Boolean adBreakDropLiveStream) {
      this.setParam("ad_break_drop_live_stream", adBreakDropLiveStream);
      return this;
    }
    public APIRequestUpdate setAdBreakDropLiveStream (String adBreakDropLiveStream) {
      this.setParam("ad_break_drop_live_stream", adBreakDropLiveStream);
      return this;
    }

    public APIRequestUpdate setAdBreakDuration (Long adBreakDuration) {
      this.setParam("ad_break_duration", adBreakDuration);
      return this;
    }
    public APIRequestUpdate setAdBreakDuration (String adBreakDuration) {
      this.setParam("ad_break_duration", adBreakDuration);
      return this;
    }

    public APIRequestUpdate setAdBreakEncoderDropsLiveStream (Boolean adBreakEncoderDropsLiveStream) {
      this.setParam("ad_break_encoder_drops_live_stream", adBreakEncoderDropsLiveStream);
      return this;
    }
    public APIRequestUpdate setAdBreakEncoderDropsLiveStream (String adBreakEncoderDropsLiveStream) {
      this.setParam("ad_break_encoder_drops_live_stream", adBreakEncoderDropsLiveStream);
      return this;
    }

    public APIRequestUpdate setAdBreakIntent (Boolean adBreakIntent) {
      this.setParam("ad_break_intent", adBreakIntent);
      return this;
    }
    public APIRequestUpdate setAdBreakIntent (String adBreakIntent) {
      this.setParam("ad_break_intent", adBreakIntent);
      return this;
    }

    public APIRequestUpdate setAdBreakStartNow (Boolean adBreakStartNow) {
      this.setParam("ad_break_start_now", adBreakStartNow);
      return this;
    }
    public APIRequestUpdate setAdBreakStartNow (String adBreakStartNow) {
      this.setParam("ad_break_start_now", adBreakStartNow);
      return this;
    }

    public APIRequestUpdate setAdBreakTimeOffset (Double adBreakTimeOffset) {
      this.setParam("ad_break_time_offset", adBreakTimeOffset);
      return this;
    }
    public APIRequestUpdate setAdBreakTimeOffset (String adBreakTimeOffset) {
      this.setParam("ad_break_time_offset", adBreakTimeOffset);
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

    public APIRequestUpdate setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestUpdate setAttributionAppMetadata (String attributionAppMetadata) {
      this.setParam("attribution_app_metadata", attributionAppMetadata);
      return this;
    }

    public APIRequestUpdate setCommercialBreakDurations (List<Long> commercialBreakDurations) {
      this.setParam("commercial_break_durations", commercialBreakDurations);
      return this;
    }
    public APIRequestUpdate setCommercialBreakDurations (String commercialBreakDurations) {
      this.setParam("commercial_break_durations", commercialBreakDurations);
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

    public APIRequestUpdate setCrosspostingActions (List<Map<String, String>> crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
      return this;
    }
    public APIRequestUpdate setCrosspostingActions (String crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
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

    public APIRequestUpdate setDisturbing (Boolean disturbing) {
      this.setParam("disturbing", disturbing);
      return this;
    }
    public APIRequestUpdate setDisturbing (String disturbing) {
      this.setParam("disturbing", disturbing);
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

    public APIRequestUpdate setEndLiveVideo (Boolean endLiveVideo) {
      this.setParam("end_live_video", endLiveVideo);
      return this;
    }
    public APIRequestUpdate setEndLiveVideo (String endLiveVideo) {
      this.setParam("end_live_video", endLiveVideo);
      return this;
    }

    public APIRequestUpdate setIsManualMode (Boolean isManualMode) {
      this.setParam("is_manual_mode", isManualMode);
      return this;
    }
    public APIRequestUpdate setIsManualMode (String isManualMode) {
      this.setParam("is_manual_mode", isManualMode);
      return this;
    }

    public APIRequestUpdate setLiveCommentModerationSetting (List<LiveVideo.EnumLiveCommentModerationSetting> liveCommentModerationSetting) {
      this.setParam("live_comment_moderation_setting", liveCommentModerationSetting);
      return this;
    }
    public APIRequestUpdate setLiveCommentModerationSetting (String liveCommentModerationSetting) {
      this.setParam("live_comment_moderation_setting", liveCommentModerationSetting);
      return this;
    }

    public APIRequestUpdate setLiveEncoders (List<String> liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
      return this;
    }
    public APIRequestUpdate setLiveEncoders (String liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
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

    public APIRequestUpdate setPlannedStartTime (Long plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }
    public APIRequestUpdate setPlannedStartTime (String plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
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

    public APIRequestUpdate setProductItems (List<String> productItems) {
      this.setParam("product_items", productItems);
      return this;
    }
    public APIRequestUpdate setProductItems (String productItems) {
      this.setParam("product_items", productItems);
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

    public APIRequestUpdate setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestUpdate setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }

    public APIRequestUpdate setScheduleFeedBackgroundImage (File scheduleFeedBackgroundImage) {
      this.setParam("schedule_feed_background_image", scheduleFeedBackgroundImage);
      return this;
    }
    public APIRequestUpdate setScheduleFeedBackgroundImage (String scheduleFeedBackgroundImage) {
      this.setParam("schedule_feed_background_image", scheduleFeedBackgroundImage);
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

    public APIRequestUpdate setStatus (LiveVideo.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setStreamType (LiveVideo.EnumStreamType streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }
    public APIRequestUpdate setStreamType (String streamType) {
      this.setParam("stream_type", streamType);
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

    public APIRequestUpdate setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestUpdate setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumLiveCommentModerationSetting {
      @SerializedName("FOLLOWER")
      VALUE_FOLLOWER("FOLLOWER"),
      @SerializedName("SLOW")
      VALUE_SLOW("SLOW"),
      @SerializedName("DISCUSSION")
      VALUE_DISCUSSION("DISCUSSION"),
      @SerializedName("RESTRICTED")
      VALUE_RESTRICTED("RESTRICTED"),
      NULL(null);

      private String value;

      private EnumLiveCommentModerationSetting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("UNPUBLISHED")
      VALUE_UNPUBLISHED("UNPUBLISHED"),
      @SerializedName("LIVE_NOW")
      VALUE_LIVE_NOW("LIVE_NOW"),
      @SerializedName("SCHEDULED_UNPUBLISHED")
      VALUE_SCHEDULED_UNPUBLISHED("SCHEDULED_UNPUBLISHED"),
      @SerializedName("SCHEDULED_LIVE")
      VALUE_SCHEDULED_LIVE("SCHEDULED_LIVE"),
      @SerializedName("SCHEDULED_CANCELED")
      VALUE_SCHEDULED_CANCELED("SCHEDULED_CANCELED"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStreamType {
      @SerializedName("REGULAR")
      VALUE_REGULAR("REGULAR"),
      @SerializedName("AMBIENT")
      VALUE_AMBIENT("AMBIENT"),
      NULL(null);

      private String value;

      private EnumStreamType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBroadcastStatus {
      @SerializedName("UNPUBLISHED")
      VALUE_UNPUBLISHED("UNPUBLISHED"),
      @SerializedName("LIVE")
      VALUE_LIVE("LIVE"),
      @SerializedName("LIVE_STOPPED")
      VALUE_LIVE_STOPPED("LIVE_STOPPED"),
      @SerializedName("PROCESSING")
      VALUE_PROCESSING("PROCESSING"),
      @SerializedName("VOD")
      VALUE_VOD("VOD"),
      @SerializedName("SCHEDULED_UNPUBLISHED")
      VALUE_SCHEDULED_UNPUBLISHED("SCHEDULED_UNPUBLISHED"),
      @SerializedName("SCHEDULED_LIVE")
      VALUE_SCHEDULED_LIVE("SCHEDULED_LIVE"),
      @SerializedName("SCHEDULED_EXPIRED")
      VALUE_SCHEDULED_EXPIRED("SCHEDULED_EXPIRED"),
      @SerializedName("SCHEDULED_CANCELED")
      VALUE_SCHEDULED_CANCELED("SCHEDULED_CANCELED"),
      NULL(null);

      private String value;

      private EnumBroadcastStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumProjection {
      @SerializedName("EQUIRECTANGULAR")
      VALUE_EQUIRECTANGULAR("EQUIRECTANGULAR"),
      @SerializedName("CUBEMAP")
      VALUE_CUBEMAP("CUBEMAP"),
      NULL(null);

      private String value;

      private EnumProjection(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSource {
      @SerializedName("target")
      VALUE_TARGET("target"),
      @SerializedName("owner")
      VALUE_OWNER("owner"),
      NULL(null);

      private String value;

      private EnumSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSpatialAudioFormat {
      @SerializedName("ambiX_4")
      VALUE_AMBIX_4("ambiX_4"),
      NULL(null);

      private String value;

      private EnumSpatialAudioFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStereoscopicMode {
      @SerializedName("MONO")
      VALUE_MONO("MONO"),
      @SerializedName("LEFT_RIGHT")
      VALUE_LEFT_RIGHT("LEFT_RIGHT"),
      @SerializedName("TOP_BOTTOM")
      VALUE_TOP_BOTTOM("TOP_BOTTOM"),
      NULL(null);

      private String value;

      private EnumStereoscopicMode(String value) {
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

  public LiveVideo copyFrom(LiveVideo instance) {
    this.mAdBreakConfig = instance.mAdBreakConfig;
    this.mAdBreakFailureReason = instance.mAdBreakFailureReason;
    this.mBroadcastStartTime = instance.mBroadcastStartTime;
    this.mCopyright = instance.mCopyright;
    this.mCreationTime = instance.mCreationTime;
    this.mDashIngestUrl = instance.mDashIngestUrl;
    this.mDashPreviewUrl = instance.mDashPreviewUrl;
    this.mDescription = instance.mDescription;
    this.mEmbedHtml = instance.mEmbedHtml;
    this.mFrom = instance.mFrom;
    this.mId = instance.mId;
    this.mIsManualMode = instance.mIsManualMode;
    this.mIsReferenceOnly = instance.mIsReferenceOnly;
    this.mLiveEncoders = instance.mLiveEncoders;
    this.mLiveViews = instance.mLiveViews;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPlannedStartTime = instance.mPlannedStartTime;
    this.mSecondsLeft = instance.mSecondsLeft;
    this.mSecureStreamUrl = instance.mSecureStreamUrl;
    this.mStatus = instance.mStatus;
    this.mStreamUrl = instance.mStreamUrl;
    this.mTitle = instance.mTitle;
    this.mVideo = instance.mVideo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveVideo> getParser() {
    return new APIRequest.ResponseParser<LiveVideo>() {
      public APINodeList<LiveVideo> parseResponse(String response, APIContext context, APIRequest<LiveVideo> request) throws MalformedResponseException {
        return LiveVideo.parseResponse(response, context, request);
      }
    };
  }
}
