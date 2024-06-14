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
public class Event extends APINode {
  @SerializedName("attending_count")
  private Long mAttendingCount = null;
  @SerializedName("can_guests_invite")
  private Boolean mCanGuestsInvite = null;
  @SerializedName("category")
  private EnumCategory mCategory = null;
  @SerializedName("cover")
  private CoverPhoto mCover = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("declined_count")
  private Long mDeclinedCount = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("discount_code_enabled")
  private Boolean mDiscountCodeEnabled = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("event_times")
  private List<ChildEvent> mEventTimes = null;
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
  @SerializedName("is_online")
  private Boolean mIsOnline = null;
  @SerializedName("is_page_owned")
  private Boolean mIsPageOwned = null;
  @SerializedName("maybe_count")
  private Long mMaybeCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("noreply_count")
  private Long mNoreplyCount = null;
  @SerializedName("online_event_format")
  private EnumOnlineEventFormat mOnlineEventFormat = null;
  @SerializedName("online_event_third_party_url")
  private String mOnlineEventThirdPartyUrl = null;
  @SerializedName("owner")
  private Object mOwner = null;
  @SerializedName("parent_group")
  private Group mParentGroup = null;
  @SerializedName("place")
  private Place mPlace = null;
  @SerializedName("registration_setting")
  private EventRegistrationSetting mRegistrationSetting = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("ticket_setting")
  private EventTicketSetting mTicketSetting = null;
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
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Event> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
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
    return
      new APIRequest(context, "", "/", "GET", Event.getParser())
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
  public static Event loadJSON(String json, APIContext context, String header) {
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
      }
    }
    event.context = context;
    event.rawValue = json;
    event.header = header;
    return event;
  }

  public static APINodeList<Event> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Event> events = new APINodeList<Event>(request, json, header);
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
          events.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              events.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  events.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              events.add(loadJSON(obj.toString(), context, header));
            }
          }
          return events;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              events.add(loadJSON(entry.getValue().toString(), context, header));
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
              events.add(loadJSON(value.toString(), context, header));
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
          events.add(loadJSON(json, context, header));
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

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFeed getFeed() {
    return new APIRequestGetFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveVideos getLiveVideos() {
    return new APIRequestGetLiveVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLiveVideo createLiveVideo() {
    return new APIRequestCreateLiveVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPhotos getPhotos() {
    return new APIRequestGetPhotos(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPosts getPosts() {
    return new APIRequestGetPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRoles getRoles() {
    return new APIRequestGetRoles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTicketTiers getTicketTiers() {
    return new APIRequestGetTicketTiers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideos getVideos() {
    return new APIRequestGetVideos(this.getPrefixedId().toString(), context);
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

  public EnumCategory getFieldCategory() {
    return mCategory;
  }

  public CoverPhoto getFieldCover() {
    return mCover;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
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

  public List<ChildEvent> getFieldEventTimes() {
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

  public Boolean getFieldIsOnline() {
    return mIsOnline;
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

  public EnumOnlineEventFormat getFieldOnlineEventFormat() {
    return mOnlineEventFormat;
  }

  public String getFieldOnlineEventThirdPartyUrl() {
    return mOnlineEventThirdPartyUrl;
  }

  public Object getFieldOwner() {
    return mOwner;
  }

  public Group getFieldParentGroup() {
    if (mParentGroup != null) {
      mParentGroup.context = getContext();
    }
    return mParentGroup;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public EventRegistrationSetting getFieldRegistrationSetting() {
    if (mRegistrationSetting != null) {
      mRegistrationSetting.context = getContext();
    }
    return mRegistrationSetting;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public EventTicketSetting getFieldTicketSetting() {
    if (mTicketSetting != null) {
      mTicketSetting.context = getContext();
    }
    return mTicketSetting;
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



  public static class APIRequestGetComments extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetComments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

  }

  public static class APIRequestGetFeed extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetFeed.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/feed", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLiveVideos extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLiveVideos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLiveVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/live_videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLiveVideo extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "content_tags",
      "description",
      "enable_backup_ingest",
      "encoding_settings",
      "event_params",
      "fisheye_video_cropped",
      "front_z_rotation",
      "is_audio_only",
      "is_spherical",
      "original_fov",
      "privacy",
      "projection",
      "published",
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
    public LiveVideo parseResponse(String response, String header) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveVideo>() {
           public LiveVideo apply(ResponseWrapper result) {
             try {
               return APIRequestCreateLiveVideo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestCreateLiveVideo setEnableBackupIngest (Boolean enableBackupIngest) {
      this.setParam("enable_backup_ingest", enableBackupIngest);
      return this;
    }
    public APIRequestCreateLiveVideo setEnableBackupIngest (String enableBackupIngest) {
      this.setParam("enable_backup_ingest", enableBackupIngest);
      return this;
    }

    public APIRequestCreateLiveVideo setEncodingSettings (String encodingSettings) {
      this.setParam("encoding_settings", encodingSettings);
      return this;
    }

    public APIRequestCreateLiveVideo setEventParams (Object eventParams) {
      this.setParam("event_params", eventParams);
      return this;
    }
    public APIRequestCreateLiveVideo setEventParams (String eventParams) {
      this.setParam("event_params", eventParams);
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

    public APIRequestCreateLiveVideo setIsAudioOnly (Boolean isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
      return this;
    }
    public APIRequestCreateLiveVideo setIsAudioOnly (String isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
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

    public APIRequestCreateLiveVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateLiveVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateLiveVideo setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateLiveVideo setProjection (LiveVideo.EnumProjection projection) {
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

    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }

    public APIRequestCreateLiveVideo setSpatialAudioFormat (LiveVideo.EnumSpatialAudioFormat spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }
    public APIRequestCreateLiveVideo setSpatialAudioFormat (String spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }

    public APIRequestCreateLiveVideo setStatus (LiveVideo.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateLiveVideo setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateLiveVideo setStereoscopicMode (LiveVideo.EnumStereoscopicMode stereoscopicMode) {
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

    public APIRequestCreateLiveVideo setStreamType (LiveVideo.EnumStreamType streamType) {
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

  public static class APIRequestGetPhotos extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPhotos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPhotos(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPhotos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPhotos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPhotos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPhotos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhotos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPhotos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhotos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPhotos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPicture extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPosts extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPosts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRoles extends APIRequest<Profile> {

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
               return APIRequestGetRoles.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRoles(String nodeId, APIContext context) {
      super(context, nodeId, "/roles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRoles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRoles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRoles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRoles requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetRoles requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetRoles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRoles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRoles requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetRoles requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetRoles requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetRoles requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetRoles requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetRoles requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetRoles requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetRoles requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetRoles requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetRoles requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetRoles requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetRoles requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetRoles requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetRoles requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetRoles requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetRoles requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetRoles requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetRoles requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTicketTiers extends APIRequest<EventTicketTier> {

    APINodeList<EventTicketTier> lastResponse = null;
    @Override
    public APINodeList<EventTicketTier> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "currency",
      "description",
      "end_sales_time",
      "end_show_time",
      "fee_settings",
      "id",
      "maximum_quantity",
      "metadata",
      "minimum_quantity",
      "name",
      "price",
      "priority",
      "retailer_id",
      "seating_map_image_url",
      "start_sales_time",
      "start_show_time",
      "status",
      "total_quantity",
    };

    @Override
    public APINodeList<EventTicketTier> parseResponse(String response, String header) throws APIException {
      return EventTicketTier.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<EventTicketTier> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<EventTicketTier> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<EventTicketTier>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<EventTicketTier>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<EventTicketTier>>() {
           public APINodeList<EventTicketTier> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTicketTiers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTicketTiers(String nodeId, APIContext context) {
      super(context, nodeId, "/ticket_tiers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTicketTiers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTicketTiers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTicketTiers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTicketTiers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTicketTiers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTicketTiers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTicketTiers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTicketTiers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTicketTiers requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetTicketTiers requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetTicketTiers requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTicketTiers requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTicketTiers requestEndSalesTimeField () {
      return this.requestEndSalesTimeField(true);
    }
    public APIRequestGetTicketTiers requestEndSalesTimeField (boolean value) {
      this.requestField("end_sales_time", value);
      return this;
    }
    public APIRequestGetTicketTiers requestEndShowTimeField () {
      return this.requestEndShowTimeField(true);
    }
    public APIRequestGetTicketTiers requestEndShowTimeField (boolean value) {
      this.requestField("end_show_time", value);
      return this;
    }
    public APIRequestGetTicketTiers requestFeeSettingsField () {
      return this.requestFeeSettingsField(true);
    }
    public APIRequestGetTicketTiers requestFeeSettingsField (boolean value) {
      this.requestField("fee_settings", value);
      return this;
    }
    public APIRequestGetTicketTiers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTicketTiers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTicketTiers requestMaximumQuantityField () {
      return this.requestMaximumQuantityField(true);
    }
    public APIRequestGetTicketTiers requestMaximumQuantityField (boolean value) {
      this.requestField("maximum_quantity", value);
      return this;
    }
    public APIRequestGetTicketTiers requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGetTicketTiers requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGetTicketTiers requestMinimumQuantityField () {
      return this.requestMinimumQuantityField(true);
    }
    public APIRequestGetTicketTiers requestMinimumQuantityField (boolean value) {
      this.requestField("minimum_quantity", value);
      return this;
    }
    public APIRequestGetTicketTiers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTicketTiers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTicketTiers requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetTicketTiers requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetTicketTiers requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGetTicketTiers requestPriorityField (boolean value) {
      this.requestField("priority", value);
      return this;
    }
    public APIRequestGetTicketTiers requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetTicketTiers requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetTicketTiers requestSeatingMapImageUrlField () {
      return this.requestSeatingMapImageUrlField(true);
    }
    public APIRequestGetTicketTiers requestSeatingMapImageUrlField (boolean value) {
      this.requestField("seating_map_image_url", value);
      return this;
    }
    public APIRequestGetTicketTiers requestStartSalesTimeField () {
      return this.requestStartSalesTimeField(true);
    }
    public APIRequestGetTicketTiers requestStartSalesTimeField (boolean value) {
      this.requestField("start_sales_time", value);
      return this;
    }
    public APIRequestGetTicketTiers requestStartShowTimeField () {
      return this.requestStartShowTimeField(true);
    }
    public APIRequestGetTicketTiers requestStartShowTimeField (boolean value) {
      this.requestField("start_show_time", value);
      return this;
    }
    public APIRequestGetTicketTiers requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetTicketTiers requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetTicketTiers requestTotalQuantityField () {
      return this.requestTotalQuantityField(true);
    }
    public APIRequestGetTicketTiers requestTotalQuantityField (boolean value) {
      this.requestField("total_quantity", value);
      return this;
    }
  }

  public static class APIRequestGetVideos extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
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
      "created_time",
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
      "is_online",
      "is_page_owned",
      "maybe_count",
      "name",
      "noreply_count",
      "online_event_format",
      "online_event_third_party_url",
      "owner",
      "parent_group",
      "place",
      "registration_setting",
      "scheduled_publish_time",
      "start_time",
      "ticket_setting",
      "ticket_uri",
      "ticket_uri_start_sales_time",
      "ticketing_privacy_uri",
      "ticketing_terms_uri",
      "timezone",
      "type",
      "updated_time",
    };

    @Override
    public Event parseResponse(String response, String header) throws APIException {
      return Event.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Event execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Event execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Event> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Event> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Event>() {
           public Event apply(ResponseWrapper result) {
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
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
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
    public APIRequestGet requestIsOnlineField () {
      return this.requestIsOnlineField(true);
    }
    public APIRequestGet requestIsOnlineField (boolean value) {
      this.requestField("is_online", value);
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
    public APIRequestGet requestOnlineEventFormatField () {
      return this.requestOnlineEventFormatField(true);
    }
    public APIRequestGet requestOnlineEventFormatField (boolean value) {
      this.requestField("online_event_format", value);
      return this;
    }
    public APIRequestGet requestOnlineEventThirdPartyUrlField () {
      return this.requestOnlineEventThirdPartyUrlField(true);
    }
    public APIRequestGet requestOnlineEventThirdPartyUrlField (boolean value) {
      this.requestField("online_event_third_party_url", value);
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
    public APIRequestGet requestRegistrationSettingField () {
      return this.requestRegistrationSettingField(true);
    }
    public APIRequestGet requestRegistrationSettingField (boolean value) {
      this.requestField("registration_setting", value);
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
    public APIRequestGet requestTicketSettingField () {
      return this.requestTicketSettingField(true);
    }
    public APIRequestGet requestTicketSettingField (boolean value) {
      this.requestField("ticket_setting", value);
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

  public static enum EnumCategory {
      @SerializedName("CLASSIC_LITERATURE")
      VALUE_CLASSIC_LITERATURE("CLASSIC_LITERATURE"),
      @SerializedName("COMEDY")
      VALUE_COMEDY("COMEDY"),
      @SerializedName("CRAFTS")
      VALUE_CRAFTS("CRAFTS"),
      @SerializedName("DANCE")
      VALUE_DANCE("DANCE"),
      @SerializedName("DRINKS")
      VALUE_DRINKS("DRINKS"),
      @SerializedName("FITNESS_AND_WORKOUTS")
      VALUE_FITNESS_AND_WORKOUTS("FITNESS_AND_WORKOUTS"),
      @SerializedName("FOODS")
      VALUE_FOODS("FOODS"),
      @SerializedName("GAMES")
      VALUE_GAMES("GAMES"),
      @SerializedName("GARDENING")
      VALUE_GARDENING("GARDENING"),
      @SerializedName("HEALTHY_LIVING_AND_SELF_CARE")
      VALUE_HEALTHY_LIVING_AND_SELF_CARE("HEALTHY_LIVING_AND_SELF_CARE"),
      @SerializedName("HEALTH_AND_MEDICAL")
      VALUE_HEALTH_AND_MEDICAL("HEALTH_AND_MEDICAL"),
      @SerializedName("HOME_AND_GARDEN")
      VALUE_HOME_AND_GARDEN("HOME_AND_GARDEN"),
      @SerializedName("MUSIC_AND_AUDIO")
      VALUE_MUSIC_AND_AUDIO("MUSIC_AND_AUDIO"),
      @SerializedName("PARTIES")
      VALUE_PARTIES("PARTIES"),
      @SerializedName("PROFESSIONAL_NETWORKING")
      VALUE_PROFESSIONAL_NETWORKING("PROFESSIONAL_NETWORKING"),
      @SerializedName("RELIGIONS")
      VALUE_RELIGIONS("RELIGIONS"),
      @SerializedName("SHOPPING_EVENT")
      VALUE_SHOPPING_EVENT("SHOPPING_EVENT"),
      @SerializedName("SOCIAL_ISSUES")
      VALUE_SOCIAL_ISSUES("SOCIAL_ISSUES"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("THEATER")
      VALUE_THEATER("THEATER"),
      @SerializedName("TV_AND_MOVIES")
      VALUE_TV_AND_MOVIES("TV_AND_MOVIES"),
      @SerializedName("VISUAL_ARTS")
      VALUE_VISUAL_ARTS("VISUAL_ARTS"),
      ;

      private String value;

      private EnumCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOnlineEventFormat {
      @SerializedName("fb_live")
      VALUE_FB_LIVE("fb_live"),
      @SerializedName("messenger_room")
      VALUE_MESSENGER_ROOM("messenger_room"),
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("other")
      VALUE_OTHER("other"),
      @SerializedName("third_party")
      VALUE_THIRD_PARTY("third_party"),
      ;

      private String value;

      private EnumOnlineEventFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("community")
      VALUE_COMMUNITY("community"),
      @SerializedName("friends")
      VALUE_FRIENDS("friends"),
      @SerializedName("group")
      VALUE_GROUP("group"),
      @SerializedName("private")
      VALUE_PRIVATE("private"),
      @SerializedName("public")
      VALUE_PUBLIC("public"),
      @SerializedName("work_company")
      VALUE_WORK_COMPANY("work_company"),
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

  public static enum EnumEventStateFilter {
      @SerializedName("canceled")
      VALUE_CANCELED("canceled"),
      @SerializedName("draft")
      VALUE_DRAFT("draft"),
      @SerializedName("published")
      VALUE_PUBLISHED("published"),
      @SerializedName("scheduled_draft_for_publication")
      VALUE_SCHEDULED_DRAFT_FOR_PUBLICATION("scheduled_draft_for_publication"),
      ;

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
      @SerializedName("past")
      VALUE_PAST("past"),
      @SerializedName("upcoming")
      VALUE_UPCOMING("upcoming"),
      ;

      private String value;

      private EnumTimeFilter(String value) {
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
    this.mCreatedTime = instance.mCreatedTime;
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
    this.mIsOnline = instance.mIsOnline;
    this.mIsPageOwned = instance.mIsPageOwned;
    this.mMaybeCount = instance.mMaybeCount;
    this.mName = instance.mName;
    this.mNoreplyCount = instance.mNoreplyCount;
    this.mOnlineEventFormat = instance.mOnlineEventFormat;
    this.mOnlineEventThirdPartyUrl = instance.mOnlineEventThirdPartyUrl;
    this.mOwner = instance.mOwner;
    this.mParentGroup = instance.mParentGroup;
    this.mPlace = instance.mPlace;
    this.mRegistrationSetting = instance.mRegistrationSetting;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mStartTime = instance.mStartTime;
    this.mTicketSetting = instance.mTicketSetting;
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
      public APINodeList<Event> parseResponse(String response, APIContext context, APIRequest<Event> request, String header) throws MalformedResponseException {
        return Event.parseResponse(response, context, request, header);
      }
    };
  }
}
