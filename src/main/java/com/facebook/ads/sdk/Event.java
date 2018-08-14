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
public class Event extends APINode {
  @SerializedName("attending_count")
  private Long mAttendingCount = null;
  @SerializedName("can_guests_invite")
  private Boolean mCanGuestsInvite = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("cover")
  private CoverPhoto mCover = null;
  @SerializedName("declined_count")
  private Long mDeclinedCount = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("discount_code_enabled")
  private Boolean mDiscountCodeEnabled = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("event_times")
  private List<Object> mEventTimes = null;
  @SerializedName("guest_list_enabled")
  private Boolean mGuestListEnabled = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("interested_count")
  private Long mInterestedCount = null;
  @SerializedName("is_canceled")
  private Boolean mIsCanceled = null;
  @SerializedName("is_draft")
  private Boolean mIsDraft = null;
  @SerializedName("is_page_owned")
  private Boolean mIsPageOwned = null;
  @SerializedName("maybe_count")
  private Long mMaybeCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("noreply_count")
  private Long mNoreplyCount = null;
  @SerializedName("owner")
  private Object mOwner = null;
  @SerializedName("parent_group")
  private Object mParentGroup = null;
  @SerializedName("place")
  private Object mPlace = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("ticket_uri")
  private String mTicketUri = null;
  @SerializedName("ticket_uri_start_sales_time")
  private String mTicketUriStartSalesTime = null;
  @SerializedName("ticketing_privacy_uri")
  private String mTicketingPrivacyUri = null;
  @SerializedName("ticketing_terms_uri")
  private String mTicketingTermsUri = null;
  @SerializedName("timezone")
  private String mTimezone = null;
  @SerializedName("type")
  private EnumType mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  Event() {
  }

  public Event(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Event(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public Event fetch() throws APIException{
    Event newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Event fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Event> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Event fetchById(String id, APIContext context) throws APIException {
    Event event =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return event;
  }

  public static ListenableFuture<Event> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<Event> event =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return event;
  }

  public static APINodeList<Event> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Event>)(
      new APIRequest<Event>(context, "", "/", "GET", Event.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Event>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<Event>> event =
      new APIRequest(context, "", "/", "GET", Event.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return event;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Event loadJSON(String json, APIContext context) {
    Event event = getGson().fromJson(json, Event.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(event.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    event.context = context;
    event.rawValue = json;
    return event;
  }

  public static APINodeList<Event> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Event> events = new APINodeList<Event>(request, json);
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
          events.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return events;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                events.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            events.setPaging(previous, next);
            if (context.hasAppSecret()) {
              events.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              events.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  events.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              events.add(loadJSON(obj.toString(), context));
            }
          }
          return events;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              events.add(loadJSON(entry.getValue().toString(), context));
          }
          return events;
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
              events.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return events;
          }

          // Sixth, check if it's pure JsonObject
          events.clear();
          events.add(loadJSON(json, context));
          return events;
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

  public APIRequestCreateLiveVideo createLiveVideo() {
    return new APIRequestCreateLiveVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldAttendingCount() {
    return mAttendingCount;
  }

  public Boolean getFieldCanGuestsInvite() {
    return mCanGuestsInvite;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public CoverPhoto getFieldCover() {
    return mCover;
  }

  public Long getFieldDeclinedCount() {
    return mDeclinedCount;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Boolean getFieldDiscountCodeEnabled() {
    return mDiscountCodeEnabled;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public List<Object> getFieldEventTimes() {
    return mEventTimes;
  }

  public Boolean getFieldGuestListEnabled() {
    return mGuestListEnabled;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldInterestedCount() {
    return mInterestedCount;
  }

  public Boolean getFieldIsCanceled() {
    return mIsCanceled;
  }

  public Boolean getFieldIsDraft() {
    return mIsDraft;
  }

  public Boolean getFieldIsPageOwned() {
    return mIsPageOwned;
  }

  public Long getFieldMaybeCount() {
    return mMaybeCount;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldNoreplyCount() {
    return mNoreplyCount;
  }

  public Object getFieldOwner() {
    return mOwner;
  }

  public Object getFieldParentGroup() {
    return mParentGroup;
  }

  public Object getFieldPlace() {
    return mPlace;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldTicketUri() {
    return mTicketUri;
  }

  public String getFieldTicketUriStartSalesTime() {
    return mTicketUriStartSalesTime;
  }

  public String getFieldTicketingPrivacyUri() {
    return mTicketingPrivacyUri;
  }

  public String getFieldTicketingTermsUri() {
    return mTicketingTermsUri;
  }

  public String getFieldTimezone() {
    return mTimezone;
  }

  public EnumType getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestCreateLiveVideo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "attribution_app_id",
      "content_tags",
      "description",
      "encoding_settings",
      "fisheye_video_cropped",
      "front_z_rotation",
      "is_spherical",
      "live_encoders",
      "original_fov",
      "planned_start_time",
      "privacy",
      "projection",
      "published",
      "save_vod",
      "schedule_custom_profile_image",
      "spatial_audio_format",
      "status",
      "stereoscopic_mode",
      "stop_on_delete_stream",
      "stream_type",
      "title",
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
               return APIRequestCreateLiveVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLiveVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/live_videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLiveVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLiveVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestCreateLiveVideo setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestCreateLiveVideo setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }

    public APIRequestCreateLiveVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateLiveVideo setEncodingSettings (String encodingSettings) {
      this.setParam("encoding_settings", encodingSettings);
      return this;
    }

    public APIRequestCreateLiveVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateLiveVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateLiveVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateLiveVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateLiveVideo setIsSpherical (Boolean isSpherical) {
      this.setParam("is_spherical", isSpherical);
      return this;
    }
    public APIRequestCreateLiveVideo setIsSpherical (String isSpherical) {
      this.setParam("is_spherical", isSpherical);
      return this;
    }

    public APIRequestCreateLiveVideo setLiveEncoders (List<String> liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
      return this;
    }
    public APIRequestCreateLiveVideo setLiveEncoders (String liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
      return this;
    }

    public APIRequestCreateLiveVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateLiveVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateLiveVideo setPlannedStartTime (Long plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }
    public APIRequestCreateLiveVideo setPlannedStartTime (String plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }

    public APIRequestCreateLiveVideo setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateLiveVideo setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateLiveVideo setProjection (EnumProjection projection) {
      this.setParam("projection", projection);
      return this;
    }
    public APIRequestCreateLiveVideo setProjection (String projection) {
      this.setParam("projection", projection);
      return this;
    }

    public APIRequestCreateLiveVideo setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateLiveVideo setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateLiveVideo setSaveVod (Boolean saveVod) {
      this.setParam("save_vod", saveVod);
      return this;
    }
    public APIRequestCreateLiveVideo setSaveVod (String saveVod) {
      this.setParam("save_vod", saveVod);
      return this;
    }

    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }

    public APIRequestCreateLiveVideo setSpatialAudioFormat (EnumSpatialAudioFormat spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }
    public APIRequestCreateLiveVideo setSpatialAudioFormat (String spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }

    public APIRequestCreateLiveVideo setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateLiveVideo setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateLiveVideo setStereoscopicMode (EnumStereoscopicMode stereoscopicMode) {
      this.setParam("stereoscopic_mode", stereoscopicMode);
      return this;
    }
    public APIRequestCreateLiveVideo setStereoscopicMode (String stereoscopicMode) {
      this.setParam("stereoscopic_mode", stereoscopicMode);
      return this;
    }

    public APIRequestCreateLiveVideo setStopOnDeleteStream (Boolean stopOnDeleteStream) {
      this.setParam("stop_on_delete_stream", stopOnDeleteStream);
      return this;
    }
    public APIRequestCreateLiveVideo setStopOnDeleteStream (String stopOnDeleteStream) {
      this.setParam("stop_on_delete_stream", stopOnDeleteStream);
      return this;
    }

    public APIRequestCreateLiveVideo setStreamType (EnumStreamType streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }
    public APIRequestCreateLiveVideo setStreamType (String streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }

    public APIRequestCreateLiveVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateLiveVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLiveVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLiveVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePhoto extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aid",
      "allow_spherical_photo",
      "application_id",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "caption",
      "composer_session_id",
      "direct_share_status",
      "feed_targeting",
      "full_res_is_coming_later",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "is_explicit_location",
      "is_explicit_place",
      "manual_privacy",
      "message",
      "name",
      "no_story",
      "offline_id",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "place",
      "privacy",
      "profile_id",
      "published",
      "qn",
      "scheduled_publish_time",
      "spherical_metadata",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "target_id",
      "targeting",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Photo parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Photo>() {
           public Photo apply(String result) {
             try {
               return APIRequestCreatePhoto.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePhoto(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePhoto setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePhoto setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePhoto setAid (String aid) {
      this.setParam("aid", aid);
      return this;
    }

    public APIRequestCreatePhoto setAllowSphericalPhoto (Boolean allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }
    public APIRequestCreatePhoto setAllowSphericalPhoto (String allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }

    public APIRequestCreatePhoto setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreatePhoto setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreatePhoto setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTimeGranularity (Photo.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestCreatePhoto setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestCreatePhoto setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreatePhoto setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreatePhoto setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreatePhoto setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreatePhoto setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreatePhoto setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreatePhoto setFullResIsComingLater (Boolean fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }
    public APIRequestCreatePhoto setFullResIsComingLater (String fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (Long initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (String initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (Long initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (String initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (Long initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (String initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitPlace (Boolean isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitPlace (String isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }

    public APIRequestCreatePhoto setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreatePhoto setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreatePhoto setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreatePhoto setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePhoto setNoStory (Boolean noStory) {
      this.setParam("no_story", noStory);
      return this;
    }
    public APIRequestCreatePhoto setNoStory (String noStory) {
      this.setParam("no_story", noStory);
      return this;
    }

    public APIRequestCreatePhoto setOfflineId (Long offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }
    public APIRequestCreatePhoto setOfflineId (String offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }

    public APIRequestCreatePhoto setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreatePhoto setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreatePhoto setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreatePhoto setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreatePhoto setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestCreatePhoto setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestCreatePhoto setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreatePhoto setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreatePhoto setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreatePhoto setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreatePhoto setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreatePhoto setProfileId (Long profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }
    public APIRequestCreatePhoto setProfileId (String profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }

    public APIRequestCreatePhoto setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreatePhoto setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreatePhoto setQn (String qn) {
      this.setParam("qn", qn);
      return this;
    }

    public APIRequestCreatePhoto setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreatePhoto setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreatePhoto setSphericalMetadata (Map<String, String> sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }
    public APIRequestCreatePhoto setSphericalMetadata (String sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }

    public APIRequestCreatePhoto setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreatePhoto setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreatePhoto setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreatePhoto setTags (List<Object> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreatePhoto setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreatePhoto setTargetId (Long targetId) {
      this.setParam("target_id", targetId);
      return this;
    }
    public APIRequestCreatePhoto setTargetId (String targetId) {
      this.setParam("target_id", targetId);
      return this;
    }

    public APIRequestCreatePhoto setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreatePhoto setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePhoto requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePhoto requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVideo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "audio_story_wave_animation_handle",
      "content_category",
      "description",
      "embeddable",
      "end_offset",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "fov",
      "front_z_rotation",
      "guide",
      "guide_enabled",
      "initial_heading",
      "initial_pitch",
      "original_fov",
      "original_projection_type",
      "react_mode_metadata",
      "referenced_sticker_id",
      "replace_video_id",
      "slideshow_spec",
      "source",
      "spherical",
      "start_offset",
      "swap_mode",
      "thumb",
      "title",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "video_file_chunk",
      "xpost_everstore_handle",
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
               return APIRequestCreateVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestCreateVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
      return this;
    }

    public APIRequestCreateVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateVideo setGuide (List<List<Long>> guide) {
      this.setParam("guide", guide);
      return this;
    }
    public APIRequestCreateVideo setGuide (String guide) {
      this.setParam("guide", guide);
      return this;
    }

    public APIRequestCreateVideo setGuideEnabled (Boolean guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }
    public APIRequestCreateVideo setGuideEnabled (String guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }

    public APIRequestCreateVideo setInitialHeading (Long initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }
    public APIRequestCreateVideo setInitialHeading (String initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }

    public APIRequestCreateVideo setInitialPitch (Long initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }
    public APIRequestCreateVideo setInitialPitch (String initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }

    public APIRequestCreateVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateVideo setOriginalProjectionType (EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateVideo setReplaceVideoId (String replaceVideoId) {
      this.setParam("replace_video_id", replaceVideoId);
      return this;
    }

    public APIRequestCreateVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateVideo setSpherical (Boolean spherical) {
      this.setParam("spherical", spherical);
      return this;
    }
    public APIRequestCreateVideo setSpherical (String spherical) {
      this.setParam("spherical", spherical);
      return this;
    }

    public APIRequestCreateVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateVideo setSwapMode (EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }

    public APIRequestCreateVideo setThumb (File thumb) {
      this.setParam("thumb", thumb);
      return this;
    }
    public APIRequestCreateVideo setThumb (String thumb) {
      this.setParam("thumb", thumb);
      return this;
    }

    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setXpostEverstoreHandle (String xpostEverstoreHandle) {
      this.setParam("xpost_everstore_handle", xpostEverstoreHandle);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Event> {

    Event lastResponse = null;
    @Override
    public Event getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attending_count",
      "can_guests_invite",
      "category",
      "cover",
      "declined_count",
      "description",
      "discount_code_enabled",
      "end_time",
      "event_times",
      "guest_list_enabled",
      "id",
      "interested_count",
      "is_canceled",
      "is_draft",
      "is_page_owned",
      "maybe_count",
      "name",
      "noreply_count",
      "owner",
      "parent_group",
      "place",
      "scheduled_publish_time",
      "start_time",
      "ticket_uri",
      "ticket_uri_start_sales_time",
      "ticketing_privacy_uri",
      "ticketing_terms_uri",
      "timezone",
      "type",
      "updated_time",
    };

    @Override
    public Event parseResponse(String response) throws APIException {
      return Event.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Event execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Event execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Event> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Event> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Event>() {
           public Event apply(String result) {
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

    public APIRequestGet requestAttendingCountField () {
      return this.requestAttendingCountField(true);
    }
    public APIRequestGet requestAttendingCountField (boolean value) {
      this.requestField("attending_count", value);
      return this;
    }
    public APIRequestGet requestCanGuestsInviteField () {
      return this.requestCanGuestsInviteField(true);
    }
    public APIRequestGet requestCanGuestsInviteField (boolean value) {
      this.requestField("can_guests_invite", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGet requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGet requestDeclinedCountField () {
      return this.requestDeclinedCountField(true);
    }
    public APIRequestGet requestDeclinedCountField (boolean value) {
      this.requestField("declined_count", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDiscountCodeEnabledField () {
      return this.requestDiscountCodeEnabledField(true);
    }
    public APIRequestGet requestDiscountCodeEnabledField (boolean value) {
      this.requestField("discount_code_enabled", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestEventTimesField () {
      return this.requestEventTimesField(true);
    }
    public APIRequestGet requestEventTimesField (boolean value) {
      this.requestField("event_times", value);
      return this;
    }
    public APIRequestGet requestGuestListEnabledField () {
      return this.requestGuestListEnabledField(true);
    }
    public APIRequestGet requestGuestListEnabledField (boolean value) {
      this.requestField("guest_list_enabled", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInterestedCountField () {
      return this.requestInterestedCountField(true);
    }
    public APIRequestGet requestInterestedCountField (boolean value) {
      this.requestField("interested_count", value);
      return this;
    }
    public APIRequestGet requestIsCanceledField () {
      return this.requestIsCanceledField(true);
    }
    public APIRequestGet requestIsCanceledField (boolean value) {
      this.requestField("is_canceled", value);
      return this;
    }
    public APIRequestGet requestIsDraftField () {
      return this.requestIsDraftField(true);
    }
    public APIRequestGet requestIsDraftField (boolean value) {
      this.requestField("is_draft", value);
      return this;
    }
    public APIRequestGet requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGet requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGet requestMaybeCountField () {
      return this.requestMaybeCountField(true);
    }
    public APIRequestGet requestMaybeCountField (boolean value) {
      this.requestField("maybe_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNoreplyCountField () {
      return this.requestNoreplyCountField(true);
    }
    public APIRequestGet requestNoreplyCountField (boolean value) {
      this.requestField("noreply_count", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestParentGroupField () {
      return this.requestParentGroupField(true);
    }
    public APIRequestGet requestParentGroupField (boolean value) {
      this.requestField("parent_group", value);
      return this;
    }
    public APIRequestGet requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGet requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGet requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGet requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTicketUriField () {
      return this.requestTicketUriField(true);
    }
    public APIRequestGet requestTicketUriField (boolean value) {
      this.requestField("ticket_uri", value);
      return this;
    }
    public APIRequestGet requestTicketUriStartSalesTimeField () {
      return this.requestTicketUriStartSalesTimeField(true);
    }
    public APIRequestGet requestTicketUriStartSalesTimeField (boolean value) {
      this.requestField("ticket_uri_start_sales_time", value);
      return this;
    }
    public APIRequestGet requestTicketingPrivacyUriField () {
      return this.requestTicketingPrivacyUriField(true);
    }
    public APIRequestGet requestTicketingPrivacyUriField (boolean value) {
      this.requestField("ticketing_privacy_uri", value);
      return this;
    }
    public APIRequestGet requestTicketingTermsUriField () {
      return this.requestTicketingTermsUriField(true);
    }
    public APIRequestGet requestTicketingTermsUriField (boolean value) {
      this.requestField("ticketing_terms_uri", value);
      return this;
    }
    public APIRequestGet requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGet requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
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
  }

  public static enum EnumType {
      @SerializedName("private")
      VALUE_PRIVATE("private"),
      @SerializedName("public")
      VALUE_PUBLIC("public"),
      @SerializedName("group")
      VALUE_GROUP("group"),
      @SerializedName("community")
      VALUE_COMMUNITY("community"),
      NULL(null);

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEventStateFilter {
      @SerializedName("canceled")
      VALUE_CANCELED("canceled"),
      @SerializedName("draft")
      VALUE_DRAFT("draft"),
      @SerializedName("scheduled_draft_for_publication")
      VALUE_SCHEDULED_DRAFT_FOR_PUBLICATION("scheduled_draft_for_publication"),
      @SerializedName("published")
      VALUE_PUBLISHED("published"),
      NULL(null);

      private String value;

      private EnumEventStateFilter(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimeFilter {
      @SerializedName("upcoming")
      VALUE_UPCOMING("upcoming"),
      @SerializedName("past")
      VALUE_PAST("past"),
      NULL(null);

      private String value;

      private EnumTimeFilter(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPromotableEventTypes {
      @SerializedName("OFFSITE_TICKET")
      VALUE_OFFSITE_TICKET("OFFSITE_TICKET"),
      @SerializedName("ONSITE_TICKET")
      VALUE_ONSITE_TICKET("ONSITE_TICKET"),
      @SerializedName("RSVP")
      VALUE_RSVP("RSVP"),
      NULL(null);

      private String value;

      private EnumPromotableEventTypes(String value) {
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
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

      private String value;

      private EnumContentCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginalProjectionType {
      @SerializedName("equirectangular")
      VALUE_EQUIRECTANGULAR("equirectangular"),
      @SerializedName("cubemap")
      VALUE_CUBEMAP("cubemap"),
      @SerializedName("equiangular_cubemap")
      VALUE_EQUIANGULAR_CUBEMAP("equiangular_cubemap"),
      @SerializedName("half_equirectangular")
      VALUE_HALF_EQUIRECTANGULAR("half_equirectangular"),
      NULL(null);

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
      NULL(null);

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

  public static enum EnumUploadPhase {
      @SerializedName("start")
      VALUE_START("start"),
      @SerializedName("transfer")
      VALUE_TRANSFER("transfer"),
      @SerializedName("finish")
      VALUE_FINISH("finish"),
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      NULL(null);

      private String value;

      private EnumUploadPhase(String value) {
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

  public Event copyFrom(Event instance) {
    this.mAttendingCount = instance.mAttendingCount;
    this.mCanGuestsInvite = instance.mCanGuestsInvite;
    this.mCategory = instance.mCategory;
    this.mCover = instance.mCover;
    this.mDeclinedCount = instance.mDeclinedCount;
    this.mDescription = instance.mDescription;
    this.mDiscountCodeEnabled = instance.mDiscountCodeEnabled;
    this.mEndTime = instance.mEndTime;
    this.mEventTimes = instance.mEventTimes;
    this.mGuestListEnabled = instance.mGuestListEnabled;
    this.mId = instance.mId;
    this.mInterestedCount = instance.mInterestedCount;
    this.mIsCanceled = instance.mIsCanceled;
    this.mIsDraft = instance.mIsDraft;
    this.mIsPageOwned = instance.mIsPageOwned;
    this.mMaybeCount = instance.mMaybeCount;
    this.mName = instance.mName;
    this.mNoreplyCount = instance.mNoreplyCount;
    this.mOwner = instance.mOwner;
    this.mParentGroup = instance.mParentGroup;
    this.mPlace = instance.mPlace;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mStartTime = instance.mStartTime;
    this.mTicketUri = instance.mTicketUri;
    this.mTicketUriStartSalesTime = instance.mTicketUriStartSalesTime;
    this.mTicketingPrivacyUri = instance.mTicketingPrivacyUri;
    this.mTicketingTermsUri = instance.mTicketingTermsUri;
    this.mTimezone = instance.mTimezone;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Event> getParser() {
    return new APIRequest.ResponseParser<Event>() {
      public APINodeList<Event> parseResponse(String response, APIContext context, APIRequest<Event> request) throws MalformedResponseException {
        return Event.parseResponse(response, context, request);
      }
    };
  }
}
