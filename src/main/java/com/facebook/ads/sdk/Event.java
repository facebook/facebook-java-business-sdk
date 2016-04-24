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
 * This class is auto-genereated.
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
  private Object mCover = null;
  @SerializedName("declined_count")
  private Long mDeclinedCount = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("guest_list_enabled")
  private Boolean mGuestListEnabled = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("interested_count")
  private Long mInterestedCount = null;
  @SerializedName("is_page_owned")
  private Boolean mIsPageOwned = null;
  @SerializedName("is_viewer_admin")
  private Boolean mIsViewerAdmin = null;
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
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("ticket_uri")
  private String mTicketUri = null;
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

  public static Event fetchById(String id, APIContext context) throws APIException {
    Event event =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return event;
  }

  public static APINodeList<Event> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Event>)(
      new APIRequest<Event>(context, "", "/", "GET", Event.getParser())
        .setParam("ids", String.join(",", ids))
        .requestFields(fields)
        .execute()
    );
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
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            events.setPaging(before, after);
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

  public Object getFieldCover() {
    return mCover;
  }

  public Long getFieldDeclinedCount() {
    return mDeclinedCount;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndTime() {
    return mEndTime;
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

  public Boolean getFieldIsPageOwned() {
    return mIsPageOwned;
  }

  public Boolean getFieldIsViewerAdmin() {
    return mIsViewerAdmin;
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

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldTicketUri() {
    return mTicketUri;
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
      "end_time",
      "guest_list_enabled",
      "id",
      "interested_count",
      "is_page_owned",
      "is_viewer_admin",
      "maybe_count",
      "name",
      "noreply_count",
      "owner",
      "parent_group",
      "place",
      "start_time",
      "ticket_uri",
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
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
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
    public APIRequestGet requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGet requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGet requestIsViewerAdminField () {
      return this.requestIsViewerAdminField(true);
    }
    public APIRequestGet requestIsViewerAdminField (boolean value) {
      this.requestField("is_viewer_admin", value);
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
      @SerializedName("MOVIE_EVENT")
      VALUE_MOVIE_EVENT("MOVIE_EVENT"),
      @SerializedName("FUNDRAISER")
      VALUE_FUNDRAISER("FUNDRAISER"),
      @SerializedName("VOLUNTEERING")
      VALUE_VOLUNTEERING("VOLUNTEERING"),
      @SerializedName("FAMILY_EVENT")
      VALUE_FAMILY_EVENT("FAMILY_EVENT"),
      @SerializedName("FESTIVAL_EVENT")
      VALUE_FESTIVAL_EVENT("FESTIVAL_EVENT"),
      @SerializedName("NEIGHBORHOOD")
      VALUE_NEIGHBORHOOD("NEIGHBORHOOD"),
      @SerializedName("RELIGIOUS_EVENT")
      VALUE_RELIGIOUS_EVENT("RELIGIOUS_EVENT"),
      @SerializedName("SHOPPING")
      VALUE_SHOPPING("SHOPPING"),
      @SerializedName("COMEDY_EVENT")
      VALUE_COMEDY_EVENT("COMEDY_EVENT"),
      @SerializedName("MUSIC_EVENT")
      VALUE_MUSIC_EVENT("MUSIC_EVENT"),
      @SerializedName("DANCE_EVENT")
      VALUE_DANCE_EVENT("DANCE_EVENT"),
      @SerializedName("NIGHTLIFE")
      VALUE_NIGHTLIFE("NIGHTLIFE"),
      @SerializedName("THEATER_EVENT")
      VALUE_THEATER_EVENT("THEATER_EVENT"),
      @SerializedName("DINING_EVENT")
      VALUE_DINING_EVENT("DINING_EVENT"),
      @SerializedName("FOOD_TASTING")
      VALUE_FOOD_TASTING("FOOD_TASTING"),
      @SerializedName("CONFERENCE_EVENT")
      VALUE_CONFERENCE_EVENT("CONFERENCE_EVENT"),
      @SerializedName("MEETUP")
      VALUE_MEETUP("MEETUP"),
      @SerializedName("CLASS_EVENT")
      VALUE_CLASS_EVENT("CLASS_EVENT"),
      @SerializedName("LECTURE")
      VALUE_LECTURE("LECTURE"),
      @SerializedName("WORKSHOP")
      VALUE_WORKSHOP("WORKSHOP"),
      @SerializedName("FITNESS")
      VALUE_FITNESS("FITNESS"),
      @SerializedName("SPORTS_EVENT")
      VALUE_SPORTS_EVENT("SPORTS_EVENT"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

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
      @SerializedName("private")
      VALUE_PRIVATE("private"),
      @SerializedName("public")
      VALUE_PUBLIC("public"),
      @SerializedName("group")
      VALUE_GROUP("group"),
      @SerializedName("community")
      VALUE_COMMUNITY("community"),
      @SerializedName("legacy")
      VALUE_LEGACY("legacy"),
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
    this.mEndTime = instance.mEndTime;
    this.mGuestListEnabled = instance.mGuestListEnabled;
    this.mId = instance.mId;
    this.mInterestedCount = instance.mInterestedCount;
    this.mIsPageOwned = instance.mIsPageOwned;
    this.mIsViewerAdmin = instance.mIsViewerAdmin;
    this.mMaybeCount = instance.mMaybeCount;
    this.mName = instance.mName;
    this.mNoreplyCount = instance.mNoreplyCount;
    this.mOwner = instance.mOwner;
    this.mParentGroup = instance.mParentGroup;
    this.mPlace = instance.mPlace;
    this.mStartTime = instance.mStartTime;
    this.mTicketUri = instance.mTicketUri;
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