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
  private EnumCategory mCategory = null;
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
  private Group mParentGroup = null;
  @SerializedName("place")
  private Place mPlace = null;
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
      };
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

  public APIRequestGetAdmins getAdmins() {
    return new APIRequestGetAdmins(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAttending getAttending() {
    return new APIRequestGetAttending(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDeclined getDeclined() {
    return new APIRequestGetDeclined(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFeed getFeed() {
    return new APIRequestGetFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFeed createFeed() {
    return new APIRequestCreateFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInterested getInterested() {
    return new APIRequestGetInterested(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveVideos getLiveVideos() {
    return new APIRequestGetLiveVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLiveVideo createLiveVideo() {
    return new APIRequestCreateLiveVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMaybe getMaybe() {
    return new APIRequestGetMaybe(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNoreply getNoreply() {
    return new APIRequestGetNoreply(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPhotos getPhotos() {
    return new APIRequestGetPhotos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
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

  public APIRequestGetVideos getVideos() {
    return new APIRequestGetVideos(this.getPrefixedId().toString(), context);
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

  public EnumCategory getFieldCategory() {
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



  public static class APIRequestGetAdmins extends APIRequest<Profile> {

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
               return APIRequestGetAdmins.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdmins(String nodeId, APIContext context) {
      super(context, nodeId, "/admins", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdmins setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdmins setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdmins requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdmins requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdmins requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdmins requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdmins requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdmins requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdmins requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetAdmins requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetAdmins requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdmins requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdmins requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAdmins requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAdmins requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdmins requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdmins requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetAdmins requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetAdmins requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetAdmins requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetAdmins requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetAdmins requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetAdmins requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetAdmins requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetAdmins requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetAdmins requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetAdmins requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetAdmins requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetAdmins requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetAdmins requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetAttending extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAttending.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAttending(String nodeId, APIContext context) {
      super(context, nodeId, "/attending", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAttending setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAttending setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAttending setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetAttending setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetAttending requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAttending requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAttending requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAttending requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAttending requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAttending requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAttending requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetAttending requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetAttending requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetAttending requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetAttending requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetAttending requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetAttending requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetAttending requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetAttending requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetAttending requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetAttending requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetAttending requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetAttending requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetAttending requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetAttending requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetAttending requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetAttending requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAttending requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAttending requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAttending requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAttending requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetAttending requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetAttending requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetAttending requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetAttending requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetAttending requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetAttending requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetAttending requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetAttending requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetAttending requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetAttending requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetAttending requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetAttending requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetAttending requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetAttending requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetAttending requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetAttending requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAttending requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAttending requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetAttending requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetAttending requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetAttending requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetAttending requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetAttending requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetAttending requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetAttending requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetAttending requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetAttending requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetAttending requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetAttending requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetAttending requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetAttending requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetAttending requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetAttending requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetAttending requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetAttending requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetAttending requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetAttending requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetAttending requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAttending requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAttending requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetAttending requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetAttending requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetAttending requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetAttending requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetAttending requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetAttending requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAttending requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAttending requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetAttending requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetAttending requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetAttending requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetAttending requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAttending requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAttending requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetAttending requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetAttending requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetAttending requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetAttending requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetAttending requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetAttending requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetAttending requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetAttending requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetAttending requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetAttending requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetAttending requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetAttending requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetAttending requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetAttending requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetAttending requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetAttending requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetAttending requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetAttending requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetAttending requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetAttending requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetAttending requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetAttending requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetAttending requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetAttending requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetAttending requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetAttending requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetAttending requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetAttending requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetAttending requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetAttending requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetAttending requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetAttending requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetAttending requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetAttending requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAttending requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAttending requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetAttending requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetAttending requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetAttending requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetAttending requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetAttending requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetAttending requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetAttending requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetAttending requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetAttending requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
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

  public static class APIRequestGetDeclined extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDeclined.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDeclined(String nodeId, APIContext context) {
      super(context, nodeId, "/declined", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDeclined setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDeclined setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDeclined setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetDeclined setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetDeclined requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDeclined requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeclined requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDeclined requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeclined requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDeclined requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDeclined requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetDeclined requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetDeclined requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetDeclined requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetDeclined requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetDeclined requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetDeclined requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetDeclined requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetDeclined requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetDeclined requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetDeclined requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetDeclined requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetDeclined requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetDeclined requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetDeclined requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetDeclined requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetDeclined requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetDeclined requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetDeclined requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetDeclined requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetDeclined requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetDeclined requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetDeclined requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetDeclined requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetDeclined requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetDeclined requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetDeclined requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetDeclined requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetDeclined requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetDeclined requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetDeclined requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetDeclined requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetDeclined requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetDeclined requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetDeclined requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetDeclined requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetDeclined requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDeclined requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDeclined requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetDeclined requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetDeclined requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetDeclined requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetDeclined requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetDeclined requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetDeclined requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetDeclined requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetDeclined requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetDeclined requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetDeclined requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetDeclined requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetDeclined requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetDeclined requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetDeclined requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetDeclined requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetDeclined requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetDeclined requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetDeclined requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetDeclined requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetDeclined requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetDeclined requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetDeclined requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetDeclined requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetDeclined requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetDeclined requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetDeclined requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetDeclined requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetDeclined requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetDeclined requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetDeclined requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetDeclined requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetDeclined requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetDeclined requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetDeclined requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDeclined requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDeclined requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetDeclined requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetDeclined requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetDeclined requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetDeclined requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetDeclined requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetDeclined requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetDeclined requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetDeclined requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetDeclined requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetDeclined requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetDeclined requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetDeclined requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetDeclined requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetDeclined requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetDeclined requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetDeclined requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetDeclined requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetDeclined requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetDeclined requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetDeclined requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetDeclined requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetDeclined requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetDeclined requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetDeclined requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetDeclined requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetDeclined requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetDeclined requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetDeclined requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetDeclined requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetDeclined requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetDeclined requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetDeclined requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetDeclined requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetDeclined requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetDeclined requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetDeclined requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetDeclined requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetDeclined requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetDeclined requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetDeclined requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetDeclined requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetDeclined requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetDeclined requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetDeclined requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetDeclined requestWorkField (boolean value) {
      this.requestField("work", value);
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
         }
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

  public static class APIRequestCreateFeed extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "actions",
      "adaptive_type",
      "album_id",
      "android_key_hash",
      "animated_effect_id",
      "application_id",
      "asked_fun_fact_prompt_id",
      "asset3d_id",
      "associated_id",
      "attach_place_suggestion",
      "attached_media",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "call_to_action",
      "caption",
      "checkin_entry_point",
      "child_attachments",
      "client_mutation_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_session_id",
      "composer_source_surface",
      "composer_type",
      "connection_class",
      "content_attachment",
      "coordinates",
      "cta_link",
      "cta_type",
      "description",
      "direct_share_status",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "formatting",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "has_nickname",
      "height",
      "holiday_card",
      "home_checkin_city_id",
      "image_crops",
      "implicit_with_tags",
      "instant_game_entry_point_data",
      "ios_bundle_id",
      "is_backout_draft",
      "is_boost_intended",
      "is_explicit_location",
      "is_explicit_share",
      "is_group_linking_post",
      "is_photo_container",
      "link",
      "location_source_id",
      "manual_privacy",
      "message",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "nectar_module",
      "object_attachment",
      "offer_like_post_id",
      "og_action_type_id",
      "og_hide_object_attachment",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "page_recommendation",
      "picture",
      "place",
      "place_attachment_setting",
      "place_list",
      "place_list_data",
      "post_surfaces_blacklist",
      "posting_to_redspace",
      "privacy",
      "prompt_id",
      "prompt_tracking_string",
      "properties",
      "proxied_app_id",
      "publish_event_id",
      "published",
      "quote",
      "react_mode_metadata",
      "ref",
      "referenceable_image_ids",
      "referral_id",
      "sales_promo_id",
      "scheduled_publish_time",
      "source",
      "sponsor_id",
      "sponsor_relationship",
      "suggested_place_id",
      "tags",
      "target_surface",
      "targeting",
      "text_format_metadata",
      "text_format_preset_id",
      "text_only_place",
      "throwback_camera_roll_media",
      "thumbnail",
      "time_since_original_post",
      "title",
      "tracking_info",
      "unpublished_content_type",
      "user_selected_tags",
      "video_start_time_ms",
      "viewer_coordinates",
      "width",
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
               return APIRequestCreateFeed.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/feed", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateFeed setActions (Object actions) {
      this.setParam("actions", actions);
      return this;
    }
    public APIRequestCreateFeed setActions (String actions) {
      this.setParam("actions", actions);
      return this;
    }

    public APIRequestCreateFeed setAdaptiveType (String adaptiveType) {
      this.setParam("adaptive_type", adaptiveType);
      return this;
    }

    public APIRequestCreateFeed setAlbumId (String albumId) {
      this.setParam("album_id", albumId);
      return this;
    }

    public APIRequestCreateFeed setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreateFeed setAnimatedEffectId (Long animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }
    public APIRequestCreateFeed setAnimatedEffectId (String animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }

    public APIRequestCreateFeed setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateFeed setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateFeed setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }

    public APIRequestCreateFeed setAsset3dId (Long asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }
    public APIRequestCreateFeed setAsset3dId (String asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }

    public APIRequestCreateFeed setAssociatedId (String associatedId) {
      this.setParam("associated_id", associatedId);
      return this;
    }

    public APIRequestCreateFeed setAttachPlaceSuggestion (Boolean attachPlaceSuggestion) {
      this.setParam("attach_place_suggestion", attachPlaceSuggestion);
      return this;
    }
    public APIRequestCreateFeed setAttachPlaceSuggestion (String attachPlaceSuggestion) {
      this.setParam("attach_place_suggestion", attachPlaceSuggestion);
      return this;
    }

    public APIRequestCreateFeed setAttachedMedia (List<Object> attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }
    public APIRequestCreateFeed setAttachedMedia (String attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }

    public APIRequestCreateFeed setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreateFeed setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreateFeed setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestCreateFeed setBackdatedTimeGranularity (EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestCreateFeed setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestCreateFeed setCallToAction (Object callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }
    public APIRequestCreateFeed setCallToAction (String callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }

    public APIRequestCreateFeed setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateFeed setCheckinEntryPoint (EnumCheckinEntryPoint checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }
    public APIRequestCreateFeed setCheckinEntryPoint (String checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }

    public APIRequestCreateFeed setChildAttachments (List<Object> childAttachments) {
      this.setParam("child_attachments", childAttachments);
      return this;
    }
    public APIRequestCreateFeed setChildAttachments (String childAttachments) {
      this.setParam("child_attachments", childAttachments);
      return this;
    }

    public APIRequestCreateFeed setClientMutationId (String clientMutationId) {
      this.setParam("client_mutation_id", clientMutationId);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryPicker (String composerEntryPicker) {
      this.setParam("composer_entry_picker", composerEntryPicker);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryPoint (String composerEntryPoint) {
      this.setParam("composer_entry_point", composerEntryPoint);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryTime (Long composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }
    public APIRequestCreateFeed setComposerEntryTime (String composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }

    public APIRequestCreateFeed setComposerSessionEventsLog (String composerSessionEventsLog) {
      this.setParam("composer_session_events_log", composerSessionEventsLog);
      return this;
    }

    public APIRequestCreateFeed setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateFeed setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateFeed setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
      return this;
    }

    public APIRequestCreateFeed setConnectionClass (String connectionClass) {
      this.setParam("connection_class", connectionClass);
      return this;
    }

    public APIRequestCreateFeed setContentAttachment (String contentAttachment) {
      this.setParam("content_attachment", contentAttachment);
      return this;
    }

    public APIRequestCreateFeed setCoordinates (Object coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }
    public APIRequestCreateFeed setCoordinates (String coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }

    public APIRequestCreateFeed setCtaLink (String ctaLink) {
      this.setParam("cta_link", ctaLink);
      return this;
    }

    public APIRequestCreateFeed setCtaType (String ctaType) {
      this.setParam("cta_type", ctaType);
      return this;
    }

    public APIRequestCreateFeed setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateFeed setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreateFeed setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreateFeed setExpandedHeight (Long expandedHeight) {
      this.setParam("expanded_height", expandedHeight);
      return this;
    }
    public APIRequestCreateFeed setExpandedHeight (String expandedHeight) {
      this.setParam("expanded_height", expandedHeight);
      return this;
    }

    public APIRequestCreateFeed setExpandedWidth (Long expandedWidth) {
      this.setParam("expanded_width", expandedWidth);
      return this;
    }
    public APIRequestCreateFeed setExpandedWidth (String expandedWidth) {
      this.setParam("expanded_width", expandedWidth);
      return this;
    }

    public APIRequestCreateFeed setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreateFeed setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreateFeed setFormatting (EnumFormatting formatting) {
      this.setParam("formatting", formatting);
      return this;
    }
    public APIRequestCreateFeed setFormatting (String formatting) {
      this.setParam("formatting", formatting);
      return this;
    }

    public APIRequestCreateFeed setFunFactPromptId (Long funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }
    public APIRequestCreateFeed setFunFactPromptId (String funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }

    public APIRequestCreateFeed setFunFactToasteeId (Long funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }
    public APIRequestCreateFeed setFunFactToasteeId (String funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }

    public APIRequestCreateFeed setHasNickname (Boolean hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }
    public APIRequestCreateFeed setHasNickname (String hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }

    public APIRequestCreateFeed setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestCreateFeed setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestCreateFeed setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
      return this;
    }

    public APIRequestCreateFeed setHomeCheckinCityId (Object homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }
    public APIRequestCreateFeed setHomeCheckinCityId (String homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }

    public APIRequestCreateFeed setImageCrops (Map<String, String> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreateFeed setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }

    public APIRequestCreateFeed setImplicitWithTags (List<Long> implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
      return this;
    }
    public APIRequestCreateFeed setImplicitWithTags (String implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
      return this;
    }

    public APIRequestCreateFeed setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
      return this;
    }

    public APIRequestCreateFeed setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreateFeed setIsBackoutDraft (Boolean isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }
    public APIRequestCreateFeed setIsBackoutDraft (String isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }

    public APIRequestCreateFeed setIsBoostIntended (Boolean isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }
    public APIRequestCreateFeed setIsBoostIntended (String isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }

    public APIRequestCreateFeed setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreateFeed setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreateFeed setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateFeed setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }

    public APIRequestCreateFeed setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateFeed setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }

    public APIRequestCreateFeed setIsPhotoContainer (Boolean isPhotoContainer) {
      this.setParam("is_photo_container", isPhotoContainer);
      return this;
    }
    public APIRequestCreateFeed setIsPhotoContainer (String isPhotoContainer) {
      this.setParam("is_photo_container", isPhotoContainer);
      return this;
    }

    public APIRequestCreateFeed setLink (String link) {
      this.setParam("link", link);
      return this;
    }

    public APIRequestCreateFeed setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateFeed setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreateFeed setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreateFeed setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateFeed setMultiShareEndCard (Boolean multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }
    public APIRequestCreateFeed setMultiShareEndCard (String multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }

    public APIRequestCreateFeed setMultiShareOptimized (Boolean multiShareOptimized) {
      this.setParam("multi_share_optimized", multiShareOptimized);
      return this;
    }
    public APIRequestCreateFeed setMultiShareOptimized (String multiShareOptimized) {
      this.setParam("multi_share_optimized", multiShareOptimized);
      return this;
    }

    public APIRequestCreateFeed setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateFeed setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestCreateFeed setObjectAttachment (String objectAttachment) {
      this.setParam("object_attachment", objectAttachment);
      return this;
    }

    public APIRequestCreateFeed setOfferLikePostId (Long offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }
    public APIRequestCreateFeed setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateFeed setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateFeed setOgHideObjectAttachment (Boolean ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }
    public APIRequestCreateFeed setOgHideObjectAttachment (String ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }

    public APIRequestCreateFeed setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateFeed setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateFeed setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateFeed setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestCreateFeed setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestCreateFeed setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreateFeed setPageRecommendation (String pageRecommendation) {
      this.setParam("page_recommendation", pageRecommendation);
      return this;
    }

    public APIRequestCreateFeed setPicture (String picture) {
      this.setParam("picture", picture);
      return this;
    }

    public APIRequestCreateFeed setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreateFeed setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreateFeed setPlaceAttachmentSetting (EnumPlaceAttachmentSetting placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
      return this;
    }
    public APIRequestCreateFeed setPlaceAttachmentSetting (String placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
      return this;
    }

    public APIRequestCreateFeed setPlaceList (String placeList) {
      this.setParam("place_list", placeList);
      return this;
    }

    public APIRequestCreateFeed setPlaceListData (JsonArray placeListData) {
      this.setParam("place_list_data", placeListData);
      return this;
    }
    public APIRequestCreateFeed setPlaceListData (String placeListData) {
      this.setParam("place_list_data", placeListData);
      return this;
    }

    public APIRequestCreateFeed setPostSurfacesBlacklist (List<EnumPostSurfacesBlacklist> postSurfacesBlacklist) {
      this.setParam("post_surfaces_blacklist", postSurfacesBlacklist);
      return this;
    }
    public APIRequestCreateFeed setPostSurfacesBlacklist (String postSurfacesBlacklist) {
      this.setParam("post_surfaces_blacklist", postSurfacesBlacklist);
      return this;
    }

    public APIRequestCreateFeed setPostingToRedspace (EnumPostingToRedspace postingToRedspace) {
      this.setParam("posting_to_redspace", postingToRedspace);
      return this;
    }
    public APIRequestCreateFeed setPostingToRedspace (String postingToRedspace) {
      this.setParam("posting_to_redspace", postingToRedspace);
      return this;
    }

    public APIRequestCreateFeed setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateFeed setPromptId (String promptId) {
      this.setParam("prompt_id", promptId);
      return this;
    }

    public APIRequestCreateFeed setPromptTrackingString (String promptTrackingString) {
      this.setParam("prompt_tracking_string", promptTrackingString);
      return this;
    }

    public APIRequestCreateFeed setProperties (Object properties) {
      this.setParam("properties", properties);
      return this;
    }
    public APIRequestCreateFeed setProperties (String properties) {
      this.setParam("properties", properties);
      return this;
    }

    public APIRequestCreateFeed setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreateFeed setPublishEventId (Long publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }
    public APIRequestCreateFeed setPublishEventId (String publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }

    public APIRequestCreateFeed setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateFeed setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateFeed setQuote (String quote) {
      this.setParam("quote", quote);
      return this;
    }

    public APIRequestCreateFeed setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateFeed setRef (List<String> ref) {
      this.setParam("ref", ref);
      return this;
    }
    public APIRequestCreateFeed setRef (String ref) {
      this.setParam("ref", ref);
      return this;
    }

    public APIRequestCreateFeed setReferenceableImageIds (List<String> referenceableImageIds) {
      this.setParam("referenceable_image_ids", referenceableImageIds);
      return this;
    }
    public APIRequestCreateFeed setReferenceableImageIds (String referenceableImageIds) {
      this.setParam("referenceable_image_ids", referenceableImageIds);
      return this;
    }

    public APIRequestCreateFeed setReferralId (String referralId) {
      this.setParam("referral_id", referralId);
      return this;
    }

    public APIRequestCreateFeed setSalesPromoId (Long salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }
    public APIRequestCreateFeed setSalesPromoId (String salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }

    public APIRequestCreateFeed setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreateFeed setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateFeed setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreateFeed setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreateFeed setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreateFeed setSuggestedPlaceId (Object suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
      return this;
    }
    public APIRequestCreateFeed setSuggestedPlaceId (String suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
      return this;
    }

    public APIRequestCreateFeed setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateFeed setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateFeed setTargetSurface (EnumTargetSurface targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }
    public APIRequestCreateFeed setTargetSurface (String targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }

    public APIRequestCreateFeed setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateFeed setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreateFeed setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateFeed setTextFormatPresetId (String textFormatPresetId) {
      this.setParam("text_format_preset_id", textFormatPresetId);
      return this;
    }

    public APIRequestCreateFeed setTextOnlyPlace (String textOnlyPlace) {
      this.setParam("text_only_place", textOnlyPlace);
      return this;
    }

    public APIRequestCreateFeed setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
      return this;
    }

    public APIRequestCreateFeed setThumbnail (File thumbnail) {
      this.setParam("thumbnail", thumbnail);
      return this;
    }
    public APIRequestCreateFeed setThumbnail (String thumbnail) {
      this.setParam("thumbnail", thumbnail);
      return this;
    }

    public APIRequestCreateFeed setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateFeed setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateFeed setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateFeed setTrackingInfo (String trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }

    public APIRequestCreateFeed setUnpublishedContentType (EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateFeed setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateFeed setUserSelectedTags (Boolean userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }
    public APIRequestCreateFeed setUserSelectedTags (String userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }

    public APIRequestCreateFeed setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateFeed setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateFeed setViewerCoordinates (Object viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }
    public APIRequestCreateFeed setViewerCoordinates (String viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }

    public APIRequestCreateFeed setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestCreateFeed setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestCreateFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInterested extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInterested.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInterested(String nodeId, APIContext context) {
      super(context, nodeId, "/interested", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInterested setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInterested setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInterested setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetInterested setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetInterested requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInterested requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInterested requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInterested requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInterested requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInterested requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInterested requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetInterested requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetInterested requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetInterested requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetInterested requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetInterested requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetInterested requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetInterested requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetInterested requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetInterested requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetInterested requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetInterested requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetInterested requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetInterested requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetInterested requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetInterested requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetInterested requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetInterested requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetInterested requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetInterested requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetInterested requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetInterested requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetInterested requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetInterested requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetInterested requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetInterested requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetInterested requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetInterested requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetInterested requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetInterested requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetInterested requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetInterested requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetInterested requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetInterested requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetInterested requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetInterested requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetInterested requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInterested requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInterested requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetInterested requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetInterested requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetInterested requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetInterested requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetInterested requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetInterested requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetInterested requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetInterested requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetInterested requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetInterested requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetInterested requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetInterested requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetInterested requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetInterested requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetInterested requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetInterested requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetInterested requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetInterested requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetInterested requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetInterested requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetInterested requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetInterested requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetInterested requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetInterested requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetInterested requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetInterested requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetInterested requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetInterested requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetInterested requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetInterested requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetInterested requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetInterested requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetInterested requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetInterested requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInterested requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInterested requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetInterested requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetInterested requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetInterested requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetInterested requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetInterested requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetInterested requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetInterested requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetInterested requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetInterested requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetInterested requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetInterested requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetInterested requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetInterested requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetInterested requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetInterested requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetInterested requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetInterested requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetInterested requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetInterested requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetInterested requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetInterested requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetInterested requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetInterested requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetInterested requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetInterested requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetInterested requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetInterested requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetInterested requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetInterested requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetInterested requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetInterested requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetInterested requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetInterested requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetInterested requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetInterested requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetInterested requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetInterested requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetInterested requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetInterested requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetInterested requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetInterested requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetInterested requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetInterested requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetInterested requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetInterested requestWorkField (boolean value) {
      this.requestField("work", value);
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
         }
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
      "encoding_settings",
      "fisheye_video_cropped",
      "front_z_rotation",
      "is_audio_only",
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

  public static class APIRequestGetMaybe extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMaybe.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMaybe(String nodeId, APIContext context) {
      super(context, nodeId, "/maybe", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMaybe setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMaybe setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMaybe setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetMaybe setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetMaybe requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMaybe requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMaybe requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMaybe requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMaybe requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMaybe requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMaybe requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetMaybe requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetMaybe requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetMaybe requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetMaybe requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetMaybe requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetMaybe requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetMaybe requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetMaybe requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetMaybe requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetMaybe requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetMaybe requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetMaybe requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetMaybe requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetMaybe requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetMaybe requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetMaybe requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetMaybe requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetMaybe requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetMaybe requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetMaybe requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetMaybe requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetMaybe requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetMaybe requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetMaybe requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetMaybe requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetMaybe requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetMaybe requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetMaybe requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetMaybe requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetMaybe requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetMaybe requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetMaybe requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetMaybe requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetMaybe requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetMaybe requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetMaybe requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMaybe requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMaybe requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetMaybe requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetMaybe requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetMaybe requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetMaybe requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetMaybe requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetMaybe requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetMaybe requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetMaybe requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetMaybe requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetMaybe requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetMaybe requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetMaybe requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetMaybe requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetMaybe requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetMaybe requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetMaybe requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetMaybe requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetMaybe requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetMaybe requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetMaybe requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetMaybe requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetMaybe requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetMaybe requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetMaybe requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetMaybe requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetMaybe requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetMaybe requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetMaybe requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetMaybe requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetMaybe requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetMaybe requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetMaybe requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetMaybe requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetMaybe requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMaybe requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMaybe requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetMaybe requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetMaybe requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetMaybe requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetMaybe requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetMaybe requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetMaybe requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetMaybe requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetMaybe requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetMaybe requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetMaybe requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetMaybe requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetMaybe requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetMaybe requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetMaybe requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetMaybe requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetMaybe requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetMaybe requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetMaybe requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetMaybe requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetMaybe requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetMaybe requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetMaybe requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetMaybe requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetMaybe requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetMaybe requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetMaybe requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetMaybe requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetMaybe requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetMaybe requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetMaybe requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetMaybe requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetMaybe requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetMaybe requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetMaybe requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetMaybe requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetMaybe requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetMaybe requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetMaybe requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetMaybe requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetMaybe requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetMaybe requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetMaybe requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetMaybe requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetMaybe requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetMaybe requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetNoreply extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetNoreply.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetNoreply(String nodeId, APIContext context) {
      super(context, nodeId, "/noreply", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNoreply setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNoreply setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNoreply setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetNoreply setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetNoreply requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNoreply requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNoreply requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNoreply requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNoreply requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNoreply requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNoreply requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetNoreply requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetNoreply requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetNoreply requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetNoreply requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetNoreply requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetNoreply requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetNoreply requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetNoreply requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetNoreply requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetNoreply requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetNoreply requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetNoreply requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetNoreply requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetNoreply requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetNoreply requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetNoreply requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetNoreply requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetNoreply requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetNoreply requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetNoreply requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetNoreply requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetNoreply requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetNoreply requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetNoreply requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetNoreply requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetNoreply requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetNoreply requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetNoreply requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetNoreply requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetNoreply requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetNoreply requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetNoreply requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetNoreply requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetNoreply requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetNoreply requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetNoreply requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNoreply requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetNoreply requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetNoreply requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetNoreply requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetNoreply requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetNoreply requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetNoreply requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetNoreply requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetNoreply requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetNoreply requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetNoreply requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetNoreply requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetNoreply requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetNoreply requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetNoreply requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetNoreply requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetNoreply requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetNoreply requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetNoreply requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetNoreply requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetNoreply requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetNoreply requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetNoreply requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetNoreply requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetNoreply requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetNoreply requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetNoreply requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetNoreply requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetNoreply requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetNoreply requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetNoreply requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetNoreply requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetNoreply requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetNoreply requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetNoreply requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetNoreply requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetNoreply requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetNoreply requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetNoreply requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetNoreply requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetNoreply requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetNoreply requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetNoreply requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetNoreply requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetNoreply requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetNoreply requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetNoreply requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetNoreply requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetNoreply requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetNoreply requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetNoreply requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetNoreply requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetNoreply requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetNoreply requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetNoreply requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetNoreply requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetNoreply requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetNoreply requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetNoreply requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetNoreply requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetNoreply requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetNoreply requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetNoreply requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetNoreply requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetNoreply requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetNoreply requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetNoreply requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetNoreply requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetNoreply requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetNoreply requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetNoreply requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetNoreply requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetNoreply requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetNoreply requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetNoreply requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetNoreply requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetNoreply requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetNoreply requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetNoreply requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetNoreply requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetNoreply requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetNoreply requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetNoreply requestWorkField (boolean value) {
      this.requestField("work", value);
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
         }
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

  public static class APIRequestCreatePhoto extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aid",
      "allow_spherical_photo",
      "alt_text_custom",
      "android_key_hash",
      "application_id",
      "attempt",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "caption",
      "composer_session_id",
      "direct_share_status",
      "feed_targeting",
      "filter_type",
      "full_res_is_coming_later",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "ios_bundle_id",
      "is_explicit_location",
      "is_explicit_place",
      "is_visual_search",
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
      "proxied_app_id",
      "published",
      "qn",
      "scheduled_publish_time",
      "spherical_metadata",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "target_id",
      "targeting",
      "time_since_original_post",
      "uid",
      "unpublished_content_type",
      "url",
      "user_selected_tags",
      "vault_image_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Photo parseResponse(String response, String header) throws APIException {
      return Photo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Photo>() {
           public Photo apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePhoto.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestCreatePhoto setAltTextCustom (String altTextCustom) {
      this.setParam("alt_text_custom", altTextCustom);
      return this;
    }

    public APIRequestCreatePhoto setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreatePhoto setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreatePhoto setAttempt (Long attempt) {
      this.setParam("attempt", attempt);
      return this;
    }
    public APIRequestCreatePhoto setAttempt (String attempt) {
      this.setParam("attempt", attempt);
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

    public APIRequestCreatePhoto setFilterType (Long filterType) {
      this.setParam("filter_type", filterType);
      return this;
    }
    public APIRequestCreatePhoto setFilterType (String filterType) {
      this.setParam("filter_type", filterType);
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

    public APIRequestCreatePhoto setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
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

    public APIRequestCreatePhoto setIsVisualSearch (Boolean isVisualSearch) {
      this.setParam("is_visual_search", isVisualSearch);
      return this;
    }
    public APIRequestCreatePhoto setIsVisualSearch (String isVisualSearch) {
      this.setParam("is_visual_search", isVisualSearch);
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

    public APIRequestCreatePhoto setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
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

    public APIRequestCreatePhoto setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreatePhoto setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreatePhoto setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreatePhoto setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreatePhoto setUnpublishedContentType (Photo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreatePhoto setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePhoto setUserSelectedTags (Boolean userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }
    public APIRequestCreatePhoto setUserSelectedTags (String userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }

    public APIRequestCreatePhoto setVaultImageId (String vaultImageId) {
      this.setParam("vault_image_id", vaultImageId);
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
         }
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
         }
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
         }
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
         }
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

  public static class APIRequestCreateVideo extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaptive_type",
      "animated_effect_id",
      "application_id",
      "asked_fun_fact_prompt_id",
      "attribution_app_id",
      "audio_story_wave_animation_handle",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_session_id",
      "composer_source_surface",
      "composer_type",
      "container_type",
      "content_category",
      "description",
      "embeddable",
      "end_offset",
      "fbuploader_video_file_chunk",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "formatting",
      "fov",
      "front_z_rotation",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "guide",
      "guide_enabled",
      "has_nickname",
      "holiday_card",
      "initial_heading",
      "initial_pitch",
      "instant_game_entry_point_data",
      "is_boost_intended",
      "is_explicit_share",
      "is_group_linking_post",
      "is_voice_clip",
      "location_source_id",
      "manual_privacy",
      "offer_like_post_id",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_suggestion_mechanism",
      "original_fov",
      "original_projection_type",
      "publish_event_id",
      "react_mode_metadata",
      "referenced_sticker_id",
      "replace_video_id",
      "sales_promo_id",
      "slideshow_spec",
      "source",
      "spherical",
      "start_offset",
      "swap_mode",
      "text_format_metadata",
      "throwback_camera_roll_media",
      "thumb",
      "time_since_original_post",
      "title",
      "transcode_setting_properties",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "upload_setting_properties",
      "video_file_chunk",
      "video_start_time_ms",
      "waterfall_id",
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
               return APIRequestCreateVideo.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestCreateVideo setAdaptiveType (String adaptiveType) {
      this.setParam("adaptive_type", adaptiveType);
      return this;
    }

    public APIRequestCreateVideo setAnimatedEffectId (Long animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }
    public APIRequestCreateVideo setAnimatedEffectId (String animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }

    public APIRequestCreateVideo setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateVideo setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPicker (String composerEntryPicker) {
      this.setParam("composer_entry_picker", composerEntryPicker);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPoint (String composerEntryPoint) {
      this.setParam("composer_entry_point", composerEntryPoint);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryTime (Long composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }
    public APIRequestCreateVideo setComposerEntryTime (String composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionEventsLog (String composerSessionEventsLog) {
      this.setParam("composer_session_events_log", composerSessionEventsLog);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateVideo setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateVideo setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
      return this;
    }

    public APIRequestCreateVideo setContainerType (AdVideo.EnumContainerType containerType) {
      this.setParam("container_type", containerType);
      return this;
    }
    public APIRequestCreateVideo setContainerType (String containerType) {
      this.setParam("container_type", containerType);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (AdVideo.EnumContentCategory contentCategory) {
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

    public APIRequestCreateVideo setFbuploaderVideoFileChunk (String fbuploaderVideoFileChunk) {
      this.setParam("fbuploader_video_file_chunk", fbuploaderVideoFileChunk);
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

    public APIRequestCreateVideo setFormatting (AdVideo.EnumFormatting formatting) {
      this.setParam("formatting", formatting);
      return this;
    }
    public APIRequestCreateVideo setFormatting (String formatting) {
      this.setParam("formatting", formatting);
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

    public APIRequestCreateVideo setFunFactPromptId (Long funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setFunFactPromptId (String funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setFunFactToasteeId (Long funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }
    public APIRequestCreateVideo setFunFactToasteeId (String funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
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

    public APIRequestCreateVideo setHasNickname (Boolean hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }
    public APIRequestCreateVideo setHasNickname (String hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }

    public APIRequestCreateVideo setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
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

    public APIRequestCreateVideo setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
      return this;
    }

    public APIRequestCreateVideo setIsBoostIntended (Boolean isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }
    public APIRequestCreateVideo setIsBoostIntended (String isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }

    public APIRequestCreateVideo setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateVideo setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }

    public APIRequestCreateVideo setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateVideo setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }

    public APIRequestCreateVideo setIsVoiceClip (Boolean isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }
    public APIRequestCreateVideo setIsVoiceClip (String isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }

    public APIRequestCreateVideo setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateVideo setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreateVideo setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreateVideo setOfferLikePostId (Long offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }
    public APIRequestCreateVideo setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateVideo setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateVideo setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateVideo setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateVideo setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateVideo setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
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

    public APIRequestCreateVideo setOriginalProjectionType (AdVideo.EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setPublishEventId (Long publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }
    public APIRequestCreateVideo setPublishEventId (String publishEventId) {
      this.setParam("publish_event_id", publishEventId);
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

    public APIRequestCreateVideo setSalesPromoId (Long salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }
    public APIRequestCreateVideo setSalesPromoId (String salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
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

    public APIRequestCreateVideo setSwapMode (AdVideo.EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }

    public APIRequestCreateVideo setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateVideo setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
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

    public APIRequestCreateVideo setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateVideo setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setTranscodeSettingProperties (String transcodeSettingProperties) {
      this.setParam("transcode_setting_properties", transcodeSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (AdVideo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (AdVideo.EnumUploadPhase uploadPhase) {
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

    public APIRequestCreateVideo setUploadSettingProperties (String uploadSettingProperties) {
      this.setParam("upload_setting_properties", uploadSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateVideo setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateVideo setWaterfallId (String waterfallId) {
      this.setParam("waterfall_id", waterfallId);
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

  public static enum EnumCategory {
      @SerializedName("ART_EVENT")
      VALUE_ART_EVENT("ART_EVENT"),
      @SerializedName("BOOK_EVENT")
      VALUE_BOOK_EVENT("BOOK_EVENT"),
      @SerializedName("CLASS_EVENT")
      VALUE_CLASS_EVENT("CLASS_EVENT"),
      @SerializedName("COMEDY_EVENT")
      VALUE_COMEDY_EVENT("COMEDY_EVENT"),
      @SerializedName("CONFERENCE_EVENT")
      VALUE_CONFERENCE_EVENT("CONFERENCE_EVENT"),
      @SerializedName("DANCE_EVENT")
      VALUE_DANCE_EVENT("DANCE_EVENT"),
      @SerializedName("DINING_EVENT")
      VALUE_DINING_EVENT("DINING_EVENT"),
      @SerializedName("FAMILY_EVENT")
      VALUE_FAMILY_EVENT("FAMILY_EVENT"),
      @SerializedName("FESTIVAL_EVENT")
      VALUE_FESTIVAL_EVENT("FESTIVAL_EVENT"),
      @SerializedName("FITNESS")
      VALUE_FITNESS("FITNESS"),
      @SerializedName("FOOD_TASTING")
      VALUE_FOOD_TASTING("FOOD_TASTING"),
      @SerializedName("FUNDRAISER")
      VALUE_FUNDRAISER("FUNDRAISER"),
      @SerializedName("LECTURE")
      VALUE_LECTURE("LECTURE"),
      @SerializedName("MEETUP")
      VALUE_MEETUP("MEETUP"),
      @SerializedName("MOVIE_EVENT")
      VALUE_MOVIE_EVENT("MOVIE_EVENT"),
      @SerializedName("MUSIC_EVENT")
      VALUE_MUSIC_EVENT("MUSIC_EVENT"),
      @SerializedName("NEIGHBORHOOD")
      VALUE_NEIGHBORHOOD("NEIGHBORHOOD"),
      @SerializedName("NIGHTLIFE")
      VALUE_NIGHTLIFE("NIGHTLIFE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("RELIGIOUS_EVENT")
      VALUE_RELIGIOUS_EVENT("RELIGIOUS_EVENT"),
      @SerializedName("SHOPPING")
      VALUE_SHOPPING("SHOPPING"),
      @SerializedName("SPORTS_EVENT")
      VALUE_SPORTS_EVENT("SPORTS_EVENT"),
      @SerializedName("THEATER_EVENT")
      VALUE_THEATER_EVENT("THEATER_EVENT"),
      @SerializedName("VOLUNTEERING")
      VALUE_VOLUNTEERING("VOLUNTEERING"),
      @SerializedName("WORKSHOP")
      VALUE_WORKSHOP("WORKSHOP"),
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

  public static enum EnumType {
      @SerializedName("community")
      VALUE_COMMUNITY("community"),
      @SerializedName("group")
      VALUE_GROUP("group"),
      @SerializedName("private")
      VALUE_PRIVATE("private"),
      @SerializedName("public")
      VALUE_PUBLIC("public"),
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

  public static enum EnumPromotableEventTypes {
      @SerializedName("OFFSITE_TICKET")
      VALUE_OFFSITE_TICKET("OFFSITE_TICKET"),
      @SerializedName("ONSITE_TICKET")
      VALUE_ONSITE_TICKET("ONSITE_TICKET"),
      @SerializedName("RSVP")
      VALUE_RSVP("RSVP"),
      ;

      private String value;

      private EnumPromotableEventTypes(String value) {
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

  public static enum EnumCheckinEntryPoint {
      @SerializedName("BRANDING_CHECKIN")
      VALUE_BRANDING_CHECKIN("BRANDING_CHECKIN"),
      @SerializedName("BRANDING_OTHER")
      VALUE_BRANDING_OTHER("BRANDING_OTHER"),
      @SerializedName("BRANDING_PHOTO")
      VALUE_BRANDING_PHOTO("BRANDING_PHOTO"),
      @SerializedName("BRANDING_STATUS")
      VALUE_BRANDING_STATUS("BRANDING_STATUS"),
      ;

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

  public static enum EnumPlaceAttachmentSetting {
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      ;

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
      ;

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
      @SerializedName("disabled")
      VALUE_DISABLED("disabled"),
      @SerializedName("enabled")
      VALUE_ENABLED("enabled"),
      ;

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
      ;

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
      public APINodeList<Event> parseResponse(String response, APIContext context, APIRequest<Event> request, String header) throws MalformedResponseException {
        return Event.parseResponse(response, context, request, header);
      }
    };
  }
}
