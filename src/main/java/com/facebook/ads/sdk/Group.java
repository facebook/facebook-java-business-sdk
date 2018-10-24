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
public class Group extends APINode {
  @SerializedName("archived")
  private Boolean mArchived = null;
  @SerializedName("cover")
  private CoverPhoto mCover = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("icon")
  private String mIcon = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("member_count")
  private Long mMemberCount = null;
  @SerializedName("member_request_count")
  private Long mMemberRequestCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner")
  private Object mOwner = null;
  @SerializedName("parent")
  private Object mParent = null;
  @SerializedName("permissions")
  private List<String> mPermissions = null;
  @SerializedName("privacy")
  private String mPrivacy = null;
  @SerializedName("purpose")
  private String mPurpose = null;
  @SerializedName("subdomain")
  private String mSubdomain = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("venue")
  private Location mVenue = null;
  protected static Gson gson = null;

  Group() {
  }

  public Group(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Group(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Group fetch() throws APIException{
    Group newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Group fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Group> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Group fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Group> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Group> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Group>)(
      new APIRequest<Group>(context, "", "/", "GET", Group.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Group>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Group.getParser())
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
  public static Group loadJSON(String json, APIContext context) {
    Group group = getGson().fromJson(json, Group.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(group.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    group.context = context;
    group.rawValue = json;
    return group;
  }

  public static APINodeList<Group> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Group> groups = new APINodeList<Group>(request, json);
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
          groups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return groups;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                groups.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            groups.setPaging(previous, next);
            if (context.hasAppSecret()) {
              groups.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              groups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  groups.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              groups.add(loadJSON(obj.toString(), context));
            }
          }
          return groups;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              groups.add(loadJSON(entry.getValue().toString(), context));
          }
          return groups;
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
              groups.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return groups;
          }

          // Sixth, check if it's pure JsonObject
          groups.clear();
          groups.add(loadJSON(json, context));
          return groups;
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

  public APIRequestDeleteAdmins deleteAdmins() {
    return new APIRequestDeleteAdmins(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdmin createAdmin() {
    return new APIRequestCreateAdmin(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAlbums getAlbums() {
    return new APIRequestGetAlbums(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAlbum createAlbum() {
    return new APIRequestCreateAlbum(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDocs getDocs() {
    return new APIRequestGetDocs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateDoc createDoc() {
    return new APIRequestCreateDoc(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEvents getEvents() {
    return new APIRequestGetEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFeed createFeed() {
    return new APIRequestCreateFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateGroupThread createGroupThread() {
    return new APIRequestCreateGroupThread(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetGroups getGroups() {
    return new APIRequestGetGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateGroup createGroup() {
    return new APIRequestCreateGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveVideos getLiveVideos() {
    return new APIRequestGetLiveVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLiveVideo createLiveVideo() {
    return new APIRequestCreateLiveVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMembers deleteMembers() {
    return new APIRequestDeleteMembers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMember createMember() {
    return new APIRequestCreateMember(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteModerators deleteModerators() {
    return new APIRequestDeleteModerators(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateModerator createModerator() {
    return new APIRequestCreateModerator(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOpenGraphActionFeed createOpenGraphActionFeed() {
    return new APIRequestCreateOpenGraphActionFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOptedInMembers getOptedInMembers() {
    return new APIRequestGetOptedInMembers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
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


  public Boolean getFieldArchived() {
    return mArchived;
  }

  public CoverPhoto getFieldCover() {
    if (mCover != null) {
      mCover.context = getContext();
    }
    return mCover;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldIcon() {
    return mIcon;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Long getFieldMemberCount() {
    return mMemberCount;
  }

  public Long getFieldMemberRequestCount() {
    return mMemberRequestCount;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldOwner() {
    return mOwner;
  }

  public Object getFieldParent() {
    return mParent;
  }

  public List<String> getFieldPermissions() {
    return mPermissions;
  }

  public String getFieldPrivacy() {
    return mPrivacy;
  }

  public String getFieldPurpose() {
    return mPurpose;
  }

  public String getFieldSubdomain() {
    return mSubdomain;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public Location getFieldVenue() {
    if (mVenue != null) {
      mVenue.context = getContext();
    }
    return mVenue;
  }



  public static class APIRequestDeleteAdmins extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAdmins.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAdmins(String nodeId, APIContext context) {
      super(context, nodeId, "/admins", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdmins setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdmins setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdmins setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestDeleteAdmins setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestDeleteAdmins requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdmins requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdmins requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdmins requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdmins requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdmins requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdmin extends APIRequest<Group> {

    Group lastResponse = null;
    @Override
    public Group getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Group parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Group execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Group execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Group> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Group> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Group>() {
           public Group apply(String result) {
             try {
               return APIRequestCreateAdmin.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdmin(String nodeId, APIContext context) {
      super(context, nodeId, "/admins", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdmin setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdmin setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdmin setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreateAdmin setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreateAdmin requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdmin requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdmin requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdmin requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdmin requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdmin requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAlbums extends APIRequest<Album> {

    APINodeList<Album> lastResponse = null;
    @Override
    public APINodeList<Album> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "backdated_time",
      "backdated_time_granularity",
      "can_backdate",
      "can_upload",
      "count",
      "cover_photo",
      "created_time",
      "description",
      "edit_link",
      "event",
      "from",
      "id",
      "is_user_facing",
      "link",
      "location",
      "modified_major",
      "name",
      "photo_count",
      "place",
      "privacy",
      "type",
      "updated_time",
      "video_count",
    };

    @Override
    public APINodeList<Album> parseResponse(String response) throws APIException {
      return Album.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Album> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Album> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Album>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Album>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Album>>() {
           public APINodeList<Album> apply(String result) {
             try {
               return APIRequestGetAlbums.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAlbums(String nodeId, APIContext context) {
      super(context, nodeId, "/albums", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAlbums setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAlbums setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAlbums requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAlbums requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAlbums requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAlbums requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAlbums requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAlbums requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAlbums requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetAlbums requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetAlbums requestBackdatedTimeGranularityField () {
      return this.requestBackdatedTimeGranularityField(true);
    }
    public APIRequestGetAlbums requestBackdatedTimeGranularityField (boolean value) {
      this.requestField("backdated_time_granularity", value);
      return this;
    }
    public APIRequestGetAlbums requestCanBackdateField () {
      return this.requestCanBackdateField(true);
    }
    public APIRequestGetAlbums requestCanBackdateField (boolean value) {
      this.requestField("can_backdate", value);
      return this;
    }
    public APIRequestGetAlbums requestCanUploadField () {
      return this.requestCanUploadField(true);
    }
    public APIRequestGetAlbums requestCanUploadField (boolean value) {
      this.requestField("can_upload", value);
      return this;
    }
    public APIRequestGetAlbums requestCountField () {
      return this.requestCountField(true);
    }
    public APIRequestGetAlbums requestCountField (boolean value) {
      this.requestField("count", value);
      return this;
    }
    public APIRequestGetAlbums requestCoverPhotoField () {
      return this.requestCoverPhotoField(true);
    }
    public APIRequestGetAlbums requestCoverPhotoField (boolean value) {
      this.requestField("cover_photo", value);
      return this;
    }
    public APIRequestGetAlbums requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAlbums requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAlbums requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAlbums requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAlbums requestEditLinkField () {
      return this.requestEditLinkField(true);
    }
    public APIRequestGetAlbums requestEditLinkField (boolean value) {
      this.requestField("edit_link", value);
      return this;
    }
    public APIRequestGetAlbums requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetAlbums requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetAlbums requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetAlbums requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetAlbums requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAlbums requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAlbums requestIsUserFacingField () {
      return this.requestIsUserFacingField(true);
    }
    public APIRequestGetAlbums requestIsUserFacingField (boolean value) {
      this.requestField("is_user_facing", value);
      return this;
    }
    public APIRequestGetAlbums requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAlbums requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAlbums requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAlbums requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAlbums requestModifiedMajorField () {
      return this.requestModifiedMajorField(true);
    }
    public APIRequestGetAlbums requestModifiedMajorField (boolean value) {
      this.requestField("modified_major", value);
      return this;
    }
    public APIRequestGetAlbums requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAlbums requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAlbums requestPhotoCountField () {
      return this.requestPhotoCountField(true);
    }
    public APIRequestGetAlbums requestPhotoCountField (boolean value) {
      this.requestField("photo_count", value);
      return this;
    }
    public APIRequestGetAlbums requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetAlbums requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetAlbums requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetAlbums requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetAlbums requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAlbums requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetAlbums requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAlbums requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAlbums requestVideoCountField () {
      return this.requestVideoCountField(true);
    }
    public APIRequestGetAlbums requestVideoCountField (boolean value) {
      this.requestField("video_count", value);
      return this;
    }
  }

  public static class APIRequestCreateAlbum extends APIRequest<Album> {

    Album lastResponse = null;
    @Override
    public Album getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_default",
      "name",
      "description",
      "contributors",
      "make_shared_album",
      "location",
      "visible",
      "privacy",
      "place",
      "tags",
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Album parseResponse(String response) throws APIException {
      return Album.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Album execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Album execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Album> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Album> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Album>() {
           public Album apply(String result) {
             try {
               return APIRequestCreateAlbum.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAlbum(String nodeId, APIContext context) {
      super(context, nodeId, "/albums", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAlbum setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAlbum setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAlbum setIsDefault (Boolean isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }
    public APIRequestCreateAlbum setIsDefault (String isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }

    public APIRequestCreateAlbum setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAlbum setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAlbum setContributors (List<Long> contributors) {
      this.setParam("contributors", contributors);
      return this;
    }
    public APIRequestCreateAlbum setContributors (String contributors) {
      this.setParam("contributors", contributors);
      return this;
    }

    public APIRequestCreateAlbum setMakeSharedAlbum (Boolean makeSharedAlbum) {
      this.setParam("make_shared_album", makeSharedAlbum);
      return this;
    }
    public APIRequestCreateAlbum setMakeSharedAlbum (String makeSharedAlbum) {
      this.setParam("make_shared_album", makeSharedAlbum);
      return this;
    }

    public APIRequestCreateAlbum setLocation (String location) {
      this.setParam("location", location);
      return this;
    }

    public APIRequestCreateAlbum setVisible (String visible) {
      this.setParam("visible", visible);
      return this;
    }

    public APIRequestCreateAlbum setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateAlbum setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateAlbum setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreateAlbum setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreateAlbum setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateAlbum setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateAlbum setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateAlbum requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAlbum requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAlbum requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDocs extends APIRequest<APINode> {

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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetDocs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDocs(String nodeId, APIContext context) {
      super(context, nodeId, "/docs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDocs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDocs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDocs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDocs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDocs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDocs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDocs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDocs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateDoc extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "body",
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
               return APIRequestCreateDoc.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateDoc(String nodeId, APIContext context) {
      super(context, nodeId, "/docs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDoc setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDoc setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDoc setBody (String body) {
      this.setParam("body", body);
      return this;
    }

    public APIRequestCreateDoc setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateDoc requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDoc requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDoc requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDoc requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDoc requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDoc requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetEvents extends APIRequest<Event> {

    APINodeList<Event> lastResponse = null;
    @Override
    public APINodeList<Event> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attending_count",
      "can_guests_invite",
      "can_viewer_post",
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
      "invited_count",
      "is_canceled",
      "is_date_only",
      "is_draft",
      "is_page_owned",
      "location",
      "maybe_count",
      "name",
      "noreply_count",
      "owner",
      "parent_group",
      "place",
      "privacy",
      "scheduled_publish_time",
      "start_time",
      "ticket_uri",
      "ticket_uri_start_sales_time",
      "ticketing_privacy_uri",
      "ticketing_terms_uri",
      "timezone",
      "type",
      "updated_time",
      "venue",
    };

    @Override
    public APINodeList<Event> parseResponse(String response) throws APIException {
      return Event.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Event> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Event> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Event>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Event>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Event>>() {
           public APINodeList<Event> apply(String result) {
             try {
               return APIRequestGetEvents.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEvents requestAttendingCountField () {
      return this.requestAttendingCountField(true);
    }
    public APIRequestGetEvents requestAttendingCountField (boolean value) {
      this.requestField("attending_count", value);
      return this;
    }
    public APIRequestGetEvents requestCanGuestsInviteField () {
      return this.requestCanGuestsInviteField(true);
    }
    public APIRequestGetEvents requestCanGuestsInviteField (boolean value) {
      this.requestField("can_guests_invite", value);
      return this;
    }
    public APIRequestGetEvents requestCanViewerPostField () {
      return this.requestCanViewerPostField(true);
    }
    public APIRequestGetEvents requestCanViewerPostField (boolean value) {
      this.requestField("can_viewer_post", value);
      return this;
    }
    public APIRequestGetEvents requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetEvents requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetEvents requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetEvents requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetEvents requestDeclinedCountField () {
      return this.requestDeclinedCountField(true);
    }
    public APIRequestGetEvents requestDeclinedCountField (boolean value) {
      this.requestField("declined_count", value);
      return this;
    }
    public APIRequestGetEvents requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetEvents requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField () {
      return this.requestDiscountCodeEnabledField(true);
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField (boolean value) {
      this.requestField("discount_code_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetEvents requestEventTimesField () {
      return this.requestEventTimesField(true);
    }
    public APIRequestGetEvents requestEventTimesField (boolean value) {
      this.requestField("event_times", value);
      return this;
    }
    public APIRequestGetEvents requestGuestListEnabledField () {
      return this.requestGuestListEnabledField(true);
    }
    public APIRequestGetEvents requestGuestListEnabledField (boolean value) {
      this.requestField("guest_list_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetEvents requestInterestedCountField () {
      return this.requestInterestedCountField(true);
    }
    public APIRequestGetEvents requestInterestedCountField (boolean value) {
      this.requestField("interested_count", value);
      return this;
    }
    public APIRequestGetEvents requestInvitedCountField () {
      return this.requestInvitedCountField(true);
    }
    public APIRequestGetEvents requestInvitedCountField (boolean value) {
      this.requestField("invited_count", value);
      return this;
    }
    public APIRequestGetEvents requestIsCanceledField () {
      return this.requestIsCanceledField(true);
    }
    public APIRequestGetEvents requestIsCanceledField (boolean value) {
      this.requestField("is_canceled", value);
      return this;
    }
    public APIRequestGetEvents requestIsDateOnlyField () {
      return this.requestIsDateOnlyField(true);
    }
    public APIRequestGetEvents requestIsDateOnlyField (boolean value) {
      this.requestField("is_date_only", value);
      return this;
    }
    public APIRequestGetEvents requestIsDraftField () {
      return this.requestIsDraftField(true);
    }
    public APIRequestGetEvents requestIsDraftField (boolean value) {
      this.requestField("is_draft", value);
      return this;
    }
    public APIRequestGetEvents requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGetEvents requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGetEvents requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetEvents requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetEvents requestMaybeCountField () {
      return this.requestMaybeCountField(true);
    }
    public APIRequestGetEvents requestMaybeCountField (boolean value) {
      this.requestField("maybe_count", value);
      return this;
    }
    public APIRequestGetEvents requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetEvents requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetEvents requestNoreplyCountField () {
      return this.requestNoreplyCountField(true);
    }
    public APIRequestGetEvents requestNoreplyCountField (boolean value) {
      this.requestField("noreply_count", value);
      return this;
    }
    public APIRequestGetEvents requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetEvents requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetEvents requestParentGroupField () {
      return this.requestParentGroupField(true);
    }
    public APIRequestGetEvents requestParentGroupField (boolean value) {
      this.requestField("parent_group", value);
      return this;
    }
    public APIRequestGetEvents requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetEvents requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetEvents requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetEvents requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetEvents requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetEvents requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriField () {
      return this.requestTicketUriField(true);
    }
    public APIRequestGetEvents requestTicketUriField (boolean value) {
      this.requestField("ticket_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField () {
      return this.requestTicketUriStartSalesTimeField(true);
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField (boolean value) {
      this.requestField("ticket_uri_start_sales_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField () {
      return this.requestTicketingPrivacyUriField(true);
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField (boolean value) {
      this.requestField("ticketing_privacy_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingTermsUriField () {
      return this.requestTicketingTermsUriField(true);
    }
    public APIRequestGetEvents requestTicketingTermsUriField (boolean value) {
      this.requestField("ticketing_terms_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetEvents requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetEvents requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetEvents requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetEvents requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetEvents requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetEvents requestVenueField () {
      return this.requestVenueField(true);
    }
    public APIRequestGetEvents requestVenueField (boolean value) {
      this.requestField("venue", value);
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
      "picture",
      "name",
      "link",
      "caption",
      "description",
      "quote",
      "source",
      "properties",
      "object_attachment",
      "height",
      "width",
      "expanded_height",
      "expanded_width",
      "referral_id",
      "thumbnail",
      "image_crops",
      "call_to_action",
      "time_since_original_post",
      "client_mutation_id",
      "privacy",
      "composer_session_id",
      "content_attachment",
      "actions",
      "targeting",
      "feed_targeting",
      "ref",
      "tags",
      "place",
      "is_explicit_location",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "og_hide_object_attachment",
      "backdated_time",
      "backdated_time_granularity",
      "published",
      "scheduled_publish_time",
      "unpublished_content_type",
      "application_id",
      "proxied_app_id",
      "ios_bundle_id",
      "android_key_hash",
      "user_selected_tags",
      "nectar_module",
      "manual_privacy",
      "audience_exp",
      "coordinates",
      "is_explicit_share",
      "is_photo_container",
      "implicit_with_tags",
      "child_attachments",
      "suggested_place_id",
      "attach_place_suggestion",
      "viewer_coordinates",
      "album_id",
      "multi_share_optimized",
      "multi_share_end_card",
      "title",
      "attached_media",
      "home_checkin_city_id",
      "text_only_place",
      "connection_class",
      "associated_id",
      "posting_to_redspace",
      "place_attachment_setting",
      "checkin_entry_point",
      "is_backout_draft",
      "sponsor_id",
      "direct_share_status",
      "sponsor_relationship",
      "referenceable_image_ids",
      "prompt_id",
      "prompt_tracking_string",
      "post_surfaces_blacklist",
      "tracking_info",
      "text_format_preset_id",
      "cta_link",
      "cta_type",
      "place_list_data",
      "formatting",
      "target_surface",
      "adaptive_type",
      "animated_effect_id",
      "asked_fun_fact_prompt_id",
      "asset3d_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_source_surface",
      "composer_type",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "is_group_linking_post",
      "has_nickname",
      "holiday_card",
      "instant_game_entry_point_data",
      "is_boost_intended",
      "location_source_id",
      "message",
      "offer_like_post_id",
      "page_recommendation",
      "place_list",
      "publish_event_id",
      "react_mode_metadata",
      "sales_promo_id",
      "text_format_metadata",
      "throwback_camera_roll_media",
      "video_start_time_ms",
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
               return APIRequestCreateFeed.this.parseResponse(result);
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


    public APIRequestCreateFeed setPicture (String picture) {
      this.setParam("picture", picture);
      return this;
    }

    public APIRequestCreateFeed setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateFeed setLink (String link) {
      this.setParam("link", link);
      return this;
    }

    public APIRequestCreateFeed setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateFeed setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateFeed setQuote (String quote) {
      this.setParam("quote", quote);
      return this;
    }

    public APIRequestCreateFeed setSource (String source) {
      this.setParam("source", source);
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

    public APIRequestCreateFeed setObjectAttachment (String objectAttachment) {
      this.setParam("object_attachment", objectAttachment);
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

    public APIRequestCreateFeed setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestCreateFeed setWidth (String width) {
      this.setParam("width", width);
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

    public APIRequestCreateFeed setReferralId (String referralId) {
      this.setParam("referral_id", referralId);
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

    public APIRequestCreateFeed setImageCrops (Map<String, String> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreateFeed setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
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

    public APIRequestCreateFeed setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateFeed setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateFeed setClientMutationId (String clientMutationId) {
      this.setParam("client_mutation_id", clientMutationId);
      return this;
    }

    public APIRequestCreateFeed setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateFeed setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateFeed setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateFeed setContentAttachment (String contentAttachment) {
      this.setParam("content_attachment", contentAttachment);
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

    public APIRequestCreateFeed setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateFeed setTargeting (String targeting) {
      this.setParam("targeting", targeting);
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

    public APIRequestCreateFeed setRef (List<String> ref) {
      this.setParam("ref", ref);
      return this;
    }
    public APIRequestCreateFeed setRef (String ref) {
      this.setParam("ref", ref);
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

    public APIRequestCreateFeed setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreateFeed setPlace (String place) {
      this.setParam("place", place);
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

    public APIRequestCreateFeed setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
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

    public APIRequestCreateFeed setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
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

    public APIRequestCreateFeed setOgHideObjectAttachment (Boolean ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }
    public APIRequestCreateFeed setOgHideObjectAttachment (String ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
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

    public APIRequestCreateFeed setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateFeed setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateFeed setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
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

    public APIRequestCreateFeed setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateFeed setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreateFeed setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreateFeed setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
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

    public APIRequestCreateFeed setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
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

    public APIRequestCreateFeed setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreateFeed setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
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

    public APIRequestCreateFeed setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateFeed setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
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

    public APIRequestCreateFeed setImplicitWithTags (List<Long> implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
      return this;
    }
    public APIRequestCreateFeed setImplicitWithTags (String implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
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

    public APIRequestCreateFeed setSuggestedPlaceId (Object suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
      return this;
    }
    public APIRequestCreateFeed setSuggestedPlaceId (String suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
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

    public APIRequestCreateFeed setViewerCoordinates (Object viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }
    public APIRequestCreateFeed setViewerCoordinates (String viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }

    public APIRequestCreateFeed setAlbumId (String albumId) {
      this.setParam("album_id", albumId);
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

    public APIRequestCreateFeed setMultiShareEndCard (Boolean multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }
    public APIRequestCreateFeed setMultiShareEndCard (String multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }

    public APIRequestCreateFeed setTitle (String title) {
      this.setParam("title", title);
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

    public APIRequestCreateFeed setHomeCheckinCityId (Object homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }
    public APIRequestCreateFeed setHomeCheckinCityId (String homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }

    public APIRequestCreateFeed setTextOnlyPlace (String textOnlyPlace) {
      this.setParam("text_only_place", textOnlyPlace);
      return this;
    }

    public APIRequestCreateFeed setConnectionClass (String connectionClass) {
      this.setParam("connection_class", connectionClass);
      return this;
    }

    public APIRequestCreateFeed setAssociatedId (String associatedId) {
      this.setParam("associated_id", associatedId);
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

    public APIRequestCreateFeed setPlaceAttachmentSetting (EnumPlaceAttachmentSetting placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
      return this;
    }
    public APIRequestCreateFeed setPlaceAttachmentSetting (String placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
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

    public APIRequestCreateFeed setIsBackoutDraft (Boolean isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }
    public APIRequestCreateFeed setIsBackoutDraft (String isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }

    public APIRequestCreateFeed setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
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

    public APIRequestCreateFeed setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreateFeed setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
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

    public APIRequestCreateFeed setPromptId (String promptId) {
      this.setParam("prompt_id", promptId);
      return this;
    }

    public APIRequestCreateFeed setPromptTrackingString (String promptTrackingString) {
      this.setParam("prompt_tracking_string", promptTrackingString);
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

    public APIRequestCreateFeed setTrackingInfo (String trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }

    public APIRequestCreateFeed setTextFormatPresetId (String textFormatPresetId) {
      this.setParam("text_format_preset_id", textFormatPresetId);
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

    public APIRequestCreateFeed setPlaceListData (Object placeListData) {
      this.setParam("place_list_data", placeListData);
      return this;
    }
    public APIRequestCreateFeed setPlaceListData (String placeListData) {
      this.setParam("place_list_data", placeListData);
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

    public APIRequestCreateFeed setTargetSurface (EnumTargetSurface targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }
    public APIRequestCreateFeed setTargetSurface (String targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }

    public APIRequestCreateFeed setAdaptiveType (String adaptiveType) {
      this.setParam("adaptive_type", adaptiveType);
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

    public APIRequestCreateFeed setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateFeed setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
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

    public APIRequestCreateFeed setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateFeed setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
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

    public APIRequestCreateFeed setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
      return this;
    }

    public APIRequestCreateFeed setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
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

    public APIRequestCreateFeed setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateFeed setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateFeed setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateFeed setPageRecommendation (String pageRecommendation) {
      this.setParam("page_recommendation", pageRecommendation);
      return this;
    }

    public APIRequestCreateFeed setPlaceList (String placeList) {
      this.setParam("place_list", placeList);
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

    public APIRequestCreateFeed setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
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

    public APIRequestCreateFeed setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateFeed setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
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

  public static class APIRequestCreateGroupThread extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "thread_id",
      "joinable",
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
               return APIRequestCreateGroupThread.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateGroupThread(String nodeId, APIContext context) {
      super(context, nodeId, "/group_threads", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateGroupThread setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateGroupThread setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateGroupThread setThreadId (Object threadId) {
      this.setParam("thread_id", threadId);
      return this;
    }
    public APIRequestCreateGroupThread setThreadId (String threadId) {
      this.setParam("thread_id", threadId);
      return this;
    }

    public APIRequestCreateGroupThread setJoinable (Boolean joinable) {
      this.setParam("joinable", joinable);
      return this;
    }
    public APIRequestCreateGroupThread setJoinable (String joinable) {
      this.setParam("joinable", joinable);
      return this;
    }

    public APIRequestCreateGroupThread requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateGroupThread requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateGroupThread requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateGroupThread requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateGroupThread requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateGroupThread requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetGroups extends APIRequest<Group> {

    APINodeList<Group> lastResponse = null;
    @Override
    public APINodeList<Group> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "archived",
      "cover",
      "created_time",
      "description",
      "email",
      "icon",
      "id",
      "link",
      "member_count",
      "member_request_count",
      "name",
      "owner",
      "parent",
      "permissions",
      "privacy",
      "purpose",
      "subdomain",
      "updated_time",
      "venue",
    };

    @Override
    public APINodeList<Group> parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Group> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Group> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Group>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Group>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Group>>() {
           public APINodeList<Group> apply(String result) {
             try {
               return APIRequestGetGroups.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetGroups requestArchivedField () {
      return this.requestArchivedField(true);
    }
    public APIRequestGetGroups requestArchivedField (boolean value) {
      this.requestField("archived", value);
      return this;
    }
    public APIRequestGetGroups requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetGroups requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetGroups requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetGroups requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetGroups requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetGroups requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetGroups requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetGroups requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetGroups requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetGroups requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetGroups requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetGroups requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetGroups requestMemberCountField () {
      return this.requestMemberCountField(true);
    }
    public APIRequestGetGroups requestMemberCountField (boolean value) {
      this.requestField("member_count", value);
      return this;
    }
    public APIRequestGetGroups requestMemberRequestCountField () {
      return this.requestMemberRequestCountField(true);
    }
    public APIRequestGetGroups requestMemberRequestCountField (boolean value) {
      this.requestField("member_request_count", value);
      return this;
    }
    public APIRequestGetGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetGroups requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetGroups requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetGroups requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGetGroups requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGetGroups requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGetGroups requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGetGroups requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetGroups requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetGroups requestPurposeField () {
      return this.requestPurposeField(true);
    }
    public APIRequestGetGroups requestPurposeField (boolean value) {
      this.requestField("purpose", value);
      return this;
    }
    public APIRequestGetGroups requestSubdomainField () {
      return this.requestSubdomainField(true);
    }
    public APIRequestGetGroups requestSubdomainField (boolean value) {
      this.requestField("subdomain", value);
      return this;
    }
    public APIRequestGetGroups requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetGroups requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetGroups requestVenueField () {
      return this.requestVenueField(true);
    }
    public APIRequestGetGroups requestVenueField (boolean value) {
      this.requestField("venue", value);
      return this;
    }
  }

  public static class APIRequestCreateGroup extends APIRequest<Group> {

    Group lastResponse = null;
    @Override
    public Group getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "privacy",
      "group_type",
      "description",
      "parent_id",
      "group_icon_id",
      "suggestion_category",
      "suggestion_identifier",
      "ref",
      "join_setting",
      "post_permissions",
      "post_requires_admin_approval",
      "admin",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Group parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Group execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Group execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Group> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Group> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Group>() {
           public Group apply(String result) {
             try {
               return APIRequestCreateGroup.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/groups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateGroup setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateGroup setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateGroup setGroupType (Group.EnumGroupType groupType) {
      this.setParam("group_type", groupType);
      return this;
    }
    public APIRequestCreateGroup setGroupType (String groupType) {
      this.setParam("group_type", groupType);
      return this;
    }

    public APIRequestCreateGroup setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateGroup setParentId (Object parentId) {
      this.setParam("parent_id", parentId);
      return this;
    }
    public APIRequestCreateGroup setParentId (String parentId) {
      this.setParam("parent_id", parentId);
      return this;
    }

    public APIRequestCreateGroup setGroupIconId (Object groupIconId) {
      this.setParam("group_icon_id", groupIconId);
      return this;
    }
    public APIRequestCreateGroup setGroupIconId (String groupIconId) {
      this.setParam("group_icon_id", groupIconId);
      return this;
    }

    public APIRequestCreateGroup setSuggestionCategory (Group.EnumSuggestionCategory suggestionCategory) {
      this.setParam("suggestion_category", suggestionCategory);
      return this;
    }
    public APIRequestCreateGroup setSuggestionCategory (String suggestionCategory) {
      this.setParam("suggestion_category", suggestionCategory);
      return this;
    }

    public APIRequestCreateGroup setSuggestionIdentifier (String suggestionIdentifier) {
      this.setParam("suggestion_identifier", suggestionIdentifier);
      return this;
    }

    public APIRequestCreateGroup setRef (String ref) {
      this.setParam("ref", ref);
      return this;
    }

    public APIRequestCreateGroup setJoinSetting (Group.EnumJoinSetting joinSetting) {
      this.setParam("join_setting", joinSetting);
      return this;
    }
    public APIRequestCreateGroup setJoinSetting (String joinSetting) {
      this.setParam("join_setting", joinSetting);
      return this;
    }

    public APIRequestCreateGroup setPostPermissions (Group.EnumPostPermissions postPermissions) {
      this.setParam("post_permissions", postPermissions);
      return this;
    }
    public APIRequestCreateGroup setPostPermissions (String postPermissions) {
      this.setParam("post_permissions", postPermissions);
      return this;
    }

    public APIRequestCreateGroup setPostRequiresAdminApproval (Boolean postRequiresAdminApproval) {
      this.setParam("post_requires_admin_approval", postRequiresAdminApproval);
      return this;
    }
    public APIRequestCreateGroup setPostRequiresAdminApproval (String postRequiresAdminApproval) {
      this.setParam("post_requires_admin_approval", postRequiresAdminApproval);
      return this;
    }

    public APIRequestCreateGroup setAdmin (Long admin) {
      this.setParam("admin", admin);
      return this;
    }
    public APIRequestCreateGroup setAdmin (String admin) {
      this.setParam("admin", admin);
      return this;
    }

    public APIRequestCreateGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLiveVideos extends APIRequest<LiveVideo> {

    APINodeList<LiveVideo> lastResponse = null;
    @Override
    public APINodeList<LiveVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
      "source",
      "broadcast_status",
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
      "ingest_streams",
      "is_manual_mode",
      "is_reference_only",
      "live_encoders",
      "live_views",
      "permalink_url",
      "planned_start_time",
      "preview_url",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "targeting",
      "title",
      "total_views",
      "video",
    };

    @Override
    public APINodeList<LiveVideo> parseResponse(String response) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LiveVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LiveVideo> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LiveVideo>>() {
           public APINodeList<LiveVideo> apply(String result) {
             try {
               return APIRequestGetLiveVideos.this.parseResponse(result);
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


    public APIRequestGetLiveVideos setType (LiveVideo.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetLiveVideos setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetLiveVideos setSource (LiveVideo.EnumSource source) {
      this.setParam("source", source);
      return this;
    }
    public APIRequestGetLiveVideos setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestGetLiveVideos setBroadcastStatus (List<LiveVideo.EnumBroadcastStatus> broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
      return this;
    }
    public APIRequestGetLiveVideos setBroadcastStatus (String broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
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

    public APIRequestGetLiveVideos requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGetLiveVideos requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetLiveVideos requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLiveVideos requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGetLiveVideos requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetLiveVideos requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveVideos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIngestStreamsField () {
      return this.requestIngestStreamsField(true);
    }
    public APIRequestGetLiveVideos requestIngestStreamsField (boolean value) {
      this.requestField("ingest_streams", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGetLiveVideos requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveEncodersField () {
      return this.requestLiveEncodersField(true);
    }
    public APIRequestGetLiveVideos requestLiveEncodersField (boolean value) {
      this.requestField("live_encoders", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGetLiveVideos requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPreviewUrlField () {
      return this.requestPreviewUrlField(true);
    }
    public APIRequestGetLiveVideos requestPreviewUrlField (boolean value) {
      this.requestField("preview_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGetLiveVideos requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetLiveVideos requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetLiveVideos requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetLiveVideos requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTotalViewsField () {
      return this.requestTotalViewsField(true);
    }
    public APIRequestGetLiveVideos requestTotalViewsField (boolean value) {
      this.requestField("total_views", value);
      return this;
    }
    public APIRequestGetLiveVideos requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetLiveVideos requestVideoField (boolean value) {
      this.requestField("video", value);
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
      "title",
      "description",
      "save_vod",
      "published",
      "status",
      "privacy",
      "stop_on_delete_stream",
      "stream_type",
      "content_tags",
      "is_spherical",
      "is_audio_only",
      "planned_start_time",
      "schedule_custom_profile_image",
      "projection",
      "spatial_audio_format",
      "encoding_settings",
      "live_encoders",
      "original_fov",
      "fisheye_video_cropped",
      "front_z_rotation",
      "attribution_app_id",
      "stereoscopic_mode",
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


    public APIRequestCreateLiveVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateLiveVideo setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateLiveVideo setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateLiveVideo setPublished (String published) {
      this.setParam("published", published);
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

    public APIRequestCreateLiveVideo setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateLiveVideo setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
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

    public APIRequestCreateLiveVideo setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestCreateLiveVideo setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
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

    public APIRequestCreateLiveVideo setIsAudioOnly (Boolean isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
      return this;
    }
    public APIRequestCreateLiveVideo setIsAudioOnly (String isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
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

    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
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

    public APIRequestCreateLiveVideo setSpatialAudioFormat (LiveVideo.EnumSpatialAudioFormat spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }
    public APIRequestCreateLiveVideo setSpatialAudioFormat (String spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }

    public APIRequestCreateLiveVideo setEncodingSettings (String encodingSettings) {
      this.setParam("encoding_settings", encodingSettings);
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

    public APIRequestCreateLiveVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
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

  public static class APIRequestDeleteMembers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "member",
      "email",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteMembers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteMembers(String nodeId, APIContext context) {
      super(context, nodeId, "/members", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMembers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMembers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMembers setMember (Long member) {
      this.setParam("member", member);
      return this;
    }
    public APIRequestDeleteMembers setMember (String member) {
      this.setParam("member", member);
      return this;
    }

    public APIRequestDeleteMembers setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteMembers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMembers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMembers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMembers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMembers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMembers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMember extends APIRequest<Group> {

    Group lastResponse = null;
    @Override
    public Group getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "member",
      "email",
      "from",
      "rate",
      "source",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Group parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Group execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Group execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Group> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Group> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Group>() {
           public Group apply(String result) {
             try {
               return APIRequestCreateMember.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMember(String nodeId, APIContext context) {
      super(context, nodeId, "/members", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMember setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMember setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMember setMember (Long member) {
      this.setParam("member", member);
      return this;
    }
    public APIRequestCreateMember setMember (String member) {
      this.setParam("member", member);
      return this;
    }

    public APIRequestCreateMember setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateMember setFrom (Long from) {
      this.setParam("from", from);
      return this;
    }
    public APIRequestCreateMember setFrom (String from) {
      this.setParam("from", from);
      return this;
    }

    public APIRequestCreateMember setRate (Long rate) {
      this.setParam("rate", rate);
      return this;
    }
    public APIRequestCreateMember setRate (String rate) {
      this.setParam("rate", rate);
      return this;
    }

    public APIRequestCreateMember setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateMember requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMember requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMember requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMember requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMember requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMember requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteModerators extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteModerators.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteModerators(String nodeId, APIContext context) {
      super(context, nodeId, "/moderators", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteModerators setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteModerators setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteModerators setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestDeleteModerators setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestDeleteModerators requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteModerators requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteModerators requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteModerators requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteModerators requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteModerators requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateModerator extends APIRequest<Group> {

    Group lastResponse = null;
    @Override
    public Group getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Group parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Group execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Group execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Group> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Group> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Group>() {
           public Group apply(String result) {
             try {
               return APIRequestCreateModerator.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateModerator(String nodeId, APIContext context) {
      super(context, nodeId, "/moderators", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateModerator setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateModerator setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateModerator setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreateModerator setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreateModerator requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateModerator requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateModerator requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateModerator requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateModerator requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateModerator requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateOpenGraphActionFeed extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "to",
      "client_secret",
      "preview",
      "ios_bundle_id",
      "android_key_hash",
      "proxied_app_id",
      "user_selected_tags",
      "user_selected_place",
      "added",
      "alias",
      "fb:channel",
      "created_time",
      "end_time",
      "expires_in",
      "fb:explicitly_shared",
      "image:height",
      "image:secure_url",
      "image:type",
      "image:url",
      "image:user_generated",
      "image:width",
      "no_feed_story",
      "no_action_link",
      "notify",
      "message",
      "place",
      "privacy",
      "ref",
      "scrape",
      "start_time",
      "tags",
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
               return APIRequestCreateOpenGraphActionFeed.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOpenGraphActionFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/opengraphactionfeed", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOpenGraphActionFeed setTo (String to) {
      this.setParam("to", to);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setClientSecret (String clientSecret) {
      this.setParam("client_secret", clientSecret);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setPreview (Boolean preview) {
      this.setParam("preview", preview);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setPreview (String preview) {
      this.setParam("preview", preview);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setUserSelectedTags (Boolean userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setUserSelectedTags (String userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setUserSelectedPlace (Boolean userSelectedPlace) {
      this.setParam("user_selected_place", userSelectedPlace);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setUserSelectedPlace (String userSelectedPlace) {
      this.setParam("user_selected_place", userSelectedPlace);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setAdded (String added) {
      this.setParam("added", added);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setAlias (String alias) {
      this.setParam("alias", alias);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setFbChannel (String fbChannel) {
      this.setParam("fb:channel", fbChannel);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setCreatedTime (String createdTime) {
      this.setParam("created_time", createdTime);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setExpiresIn (Long expiresIn) {
      this.setParam("expires_in", expiresIn);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setExpiresIn (String expiresIn) {
      this.setParam("expires_in", expiresIn);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setFbExplicitlyShared (Boolean fbExplicitlyShared) {
      this.setParam("fb:explicitly_shared", fbExplicitlyShared);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setFbExplicitlyShared (String fbExplicitlyShared) {
      this.setParam("fb:explicitly_shared", fbExplicitlyShared);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageHeight (Long imageHeight) {
      this.setParam("image:height", imageHeight);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setImageHeight (String imageHeight) {
      this.setParam("image:height", imageHeight);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageSecureUrl (String imageSecureUrl) {
      this.setParam("image:secure_url", imageSecureUrl);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageType (String imageType) {
      this.setParam("image:type", imageType);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageUrl (String imageUrl) {
      this.setParam("image:url", imageUrl);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageUserGenerated (Boolean imageUserGenerated) {
      this.setParam("image:user_generated", imageUserGenerated);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setImageUserGenerated (String imageUserGenerated) {
      this.setParam("image:user_generated", imageUserGenerated);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setImageWidth (Long imageWidth) {
      this.setParam("image:width", imageWidth);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setImageWidth (String imageWidth) {
      this.setParam("image:width", imageWidth);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setNoFeedStory (Boolean noFeedStory) {
      this.setParam("no_feed_story", noFeedStory);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setNoFeedStory (String noFeedStory) {
      this.setParam("no_feed_story", noFeedStory);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setNoActionLink (Boolean noActionLink) {
      this.setParam("no_action_link", noActionLink);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setNoActionLink (String noActionLink) {
      this.setParam("no_action_link", noActionLink);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setNotify (Boolean notify) {
      this.setParam("notify", notify);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setNotify (String notify) {
      this.setParam("notify", notify);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setRef (String ref) {
      this.setParam("ref", ref);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setScrape (Boolean scrape) {
      this.setParam("scrape", scrape);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setScrape (String scrape) {
      this.setParam("scrape", scrape);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateOpenGraphActionFeed setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateOpenGraphActionFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOpenGraphActionFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOpenGraphActionFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOptedInMembers extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "bio",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "employee_number",
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
      "is_shared_login",
      "is_verified",
      "labels",
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
      "username",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<User>>() {
           public APINodeList<User> apply(String result) {
             try {
               return APIRequestGetOptedInMembers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOptedInMembers(String nodeId, APIContext context) {
      super(context, nodeId, "/opted_in_members", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOptedInMembers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOptedInMembers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOptedInMembers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOptedInMembers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOptedInMembers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOptedInMembers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOptedInMembers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOptedInMembers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOptedInMembers requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetOptedInMembers requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetOptedInMembers requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetOptedInMembers requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetOptedInMembers requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetOptedInMembers requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetOptedInMembers requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetOptedInMembers requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetOptedInMembers requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetOptedInMembers requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetOptedInMembers requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetOptedInMembers requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetOptedInMembers requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetOptedInMembers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGetOptedInMembers requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetOptedInMembers requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetOptedInMembers requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetOptedInMembers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetOptedInMembers requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetOptedInMembers requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOptedInMembers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetOptedInMembers requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetOptedInMembers requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetOptedInMembers requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetOptedInMembers requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetOptedInMembers requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetOptedInMembers requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetOptedInMembers requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetOptedInMembers requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetOptedInMembers requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetOptedInMembers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOptedInMembers requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetOptedInMembers requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetOptedInMembers requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetOptedInMembers requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetOptedInMembers requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetOptedInMembers requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetOptedInMembers requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOptedInMembers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetOptedInMembers requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetOptedInMembers requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetOptedInMembers requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetOptedInMembers requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetOptedInMembers requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetOptedInMembers requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetOptedInMembers requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetOptedInMembers requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetOptedInMembers requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetOptedInMembers requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetOptedInMembers requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetOptedInMembers requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetOptedInMembers requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetOptedInMembers requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetOptedInMembers requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetOptedInMembers requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetOptedInMembers requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetOptedInMembers requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetOptedInMembers requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetOptedInMembers requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetOptedInMembers requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetOptedInMembers requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetOptedInMembers requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetOptedInMembers requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetOptedInMembers requestWorkField (boolean value) {
      this.requestField("work", value);
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
      "caption",
      "url",
      "uid",
      "profile_id",
      "target_id",
      "checkin_id",
      "vault_image_id",
      "tags",
      "place",
      "is_explicit_place",
      "is_explicit_location",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_suggestion_mechanism",
      "og_set_profile_badge",
      "privacy",
      "targeting",
      "feed_targeting",
      "no_story",
      "published",
      "offline_id",
      "attempt",
      "backdated_time",
      "backdated_time_granularity",
      "time_since_original_post",
      "filter_type",
      "scheduled_publish_time",
      "unpublished_content_type",
      "full_res_is_coming_later",
      "composer_session_id",
      "qn",
      "manual_privacy",
      "audience_exp",
      "proxied_app_id",
      "ios_bundle_id",
      "android_key_hash",
      "user_selected_tags",
      "allow_spherical_photo",
      "spherical_metadata",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "sponsor_id",
      "direct_share_status",
      "sponsor_relationship",
      "application_id",
      "name",
      "message",
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

    public APIRequestCreatePhoto setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
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

    public APIRequestCreatePhoto setProfileId (Long profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }
    public APIRequestCreatePhoto setProfileId (String profileId) {
      this.setParam("profile_id", profileId);
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

    public APIRequestCreatePhoto setCheckinId (Object checkinId) {
      this.setParam("checkin_id", checkinId);
      return this;
    }
    public APIRequestCreatePhoto setCheckinId (String checkinId) {
      this.setParam("checkin_id", checkinId);
      return this;
    }

    public APIRequestCreatePhoto setVaultImageId (String vaultImageId) {
      this.setParam("vault_image_id", vaultImageId);
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

    public APIRequestCreatePhoto setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreatePhoto setPlace (String place) {
      this.setParam("place", place);
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

    public APIRequestCreatePhoto setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreatePhoto setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
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

    public APIRequestCreatePhoto setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreatePhoto setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
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

    public APIRequestCreatePhoto setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreatePhoto setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
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

    public APIRequestCreatePhoto setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreatePhoto setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
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

    public APIRequestCreatePhoto setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreatePhoto setPublished (String published) {
      this.setParam("published", published);
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

    public APIRequestCreatePhoto setAttempt (Long attempt) {
      this.setParam("attempt", attempt);
      return this;
    }
    public APIRequestCreatePhoto setAttempt (String attempt) {
      this.setParam("attempt", attempt);
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

    public APIRequestCreatePhoto setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreatePhoto setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
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

    public APIRequestCreatePhoto setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreatePhoto setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
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

    public APIRequestCreatePhoto setFullResIsComingLater (Boolean fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }
    public APIRequestCreatePhoto setFullResIsComingLater (String fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }

    public APIRequestCreatePhoto setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreatePhoto setQn (String qn) {
      this.setParam("qn", qn);
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

    public APIRequestCreatePhoto setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreatePhoto setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreatePhoto setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreatePhoto setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreatePhoto setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
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

    public APIRequestCreatePhoto setAllowSphericalPhoto (Boolean allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }
    public APIRequestCreatePhoto setAllowSphericalPhoto (String allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
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

    public APIRequestCreatePhoto setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
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

    public APIRequestCreatePhoto setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreatePhoto setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreatePhoto setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreatePhoto setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePhoto setMessage (String message) {
      this.setParam("message", message);
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

  public static class APIRequestGetPicture extends APIRequest<ProfilePictureSource> {

    APINodeList<ProfilePictureSource> lastResponse = null;
    @Override
    public APINodeList<ProfilePictureSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "height",
      "width",
      "type",
      "redirect",
    };

    public static final String[] FIELDS = {
      "bottom",
      "cache_key",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "uri",
      "url",
      "width",
      "id",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProfilePictureSource>>() {
           public APINodeList<ProfilePictureSource> apply(String result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result);
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


    public APIRequestGetPicture setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetPicture setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPicture setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPicture setType (ProfilePictureSource.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetPicture setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }
    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
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

    public APIRequestGetPicture requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGetPicture requestBottomField (boolean value) {
      this.requestField("bottom", value);
      return this;
    }
    public APIRequestGetPicture requestCacheKeyField () {
      return this.requestCacheKeyField(true);
    }
    public APIRequestGetPicture requestCacheKeyField (boolean value) {
      this.requestField("cache_key", value);
      return this;
    }
    public APIRequestGetPicture requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPicture requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPicture requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGetPicture requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGetPicture requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGetPicture requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGetPicture requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGetPicture requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGetPicture requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGetPicture requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGetPicture requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGetPicture requestUriField (boolean value) {
      this.requestField("uri", value);
      return this;
    }
    public APIRequestGetPicture requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPicture requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetPicture requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPicture requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
    public APIRequestGetPicture requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPicture requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetVideos extends APIRequest<AdVideo> {

    APINodeList<AdVideo> lastResponse = null;
    @Override
    public APINodeList<AdVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
    };

    public static final String[] FIELDS = {
      "ad_breaks",
      "backdated_time",
      "backdated_time_granularity",
      "content_category",
      "content_tags",
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
      "length",
      "live_audience_count",
      "live_status",
      "name",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "published",
      "scheduled_publish_time",
      "source",
      "spherical",
      "status",
      "title",
      "tv_banner_ad",
      "universal_video_id",
      "updated_time",
    };

    @Override
    public APINodeList<AdVideo> parseResponse(String response) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdVideo> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdVideo>>() {
           public APINodeList<AdVideo> apply(String result) {
             try {
               return APIRequestGetVideos.this.parseResponse(result);
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


    public APIRequestGetVideos setType (AdVideo.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetVideos setType (String type) {
      this.setParam("type", type);
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
    public APIRequestGetVideos requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetVideos requestNameField (boolean value) {
      this.requestField("name", value);
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
    public APIRequestGetVideos requestTvBannerAdField () {
      return this.requestTvBannerAdField(true);
    }
    public APIRequestGetVideos requestTvBannerAdField (boolean value) {
      this.requestField("tv_banner_ad", value);
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
  }

  public static class APIRequestCreateVideo extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "title",
      "source",
      "unpublished_content_type",
      "time_since_original_post",
      "file_url",
      "composer_session_id",
      "waterfall_id",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_suggestion_mechanism",
      "manual_privacy",
      "is_explicit_share",
      "thumb",
      "spherical",
      "original_projection_type",
      "initial_heading",
      "initial_pitch",
      "fov",
      "original_fov",
      "fisheye_video_cropped",
      "front_z_rotation",
      "guide_enabled",
      "guide",
      "audio_story_wave_animation_handle",
      "adaptive_type",
      "animated_effect_id",
      "asked_fun_fact_prompt_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_source_surface",
      "composer_type",
      "formatting",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "is_group_linking_post",
      "has_nickname",
      "holiday_card",
      "instant_game_entry_point_data",
      "is_boost_intended",
      "location_source_id",
      "description",
      "offer_like_post_id",
      "publish_event_id",
      "react_mode_metadata",
      "sales_promo_id",
      "text_format_metadata",
      "throwback_camera_roll_media",
      "video_start_time_ms",
      "application_id",
      "upload_phase",
      "file_size",
      "start_offset",
      "end_offset",
      "video_file_chunk",
      "fbuploader_video_file_chunk",
      "upload_session_id",
      "is_voice_clip",
      "attribution_app_id",
      "content_category",
      "embeddable",
      "slideshow_spec",
      "upload_setting_properties",
      "transcode_setting_properties",
      "container_type",
      "referenced_sticker_id",
      "replace_video_id",
      "swap_mode",
      "scheduled_publish_time",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdVideo>() {
           public AdVideo apply(String result) {
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


    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
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

    public APIRequestCreateVideo setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateVideo setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateVideo setWaterfallId (String waterfallId) {
      this.setParam("waterfall_id", waterfallId);
      return this;
    }

    public APIRequestCreateVideo setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
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

    public APIRequestCreateVideo setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateVideo setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
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

    public APIRequestCreateVideo setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateVideo setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
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

    public APIRequestCreateVideo setSpherical (Boolean spherical) {
      this.setParam("spherical", spherical);
      return this;
    }
    public APIRequestCreateVideo setSpherical (String spherical) {
      this.setParam("spherical", spherical);
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

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
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

    public APIRequestCreateVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
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

    public APIRequestCreateVideo setGuideEnabled (Boolean guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }
    public APIRequestCreateVideo setGuideEnabled (String guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
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

    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
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

    public APIRequestCreateVideo setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
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

    public APIRequestCreateVideo setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateVideo setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
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

    public APIRequestCreateVideo setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateVideo setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
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

    public APIRequestCreateVideo setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideo setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
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

    public APIRequestCreateVideo setSalesPromoId (Long salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }
    public APIRequestCreateVideo setSalesPromoId (String salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
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

    public APIRequestCreateVideo setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateVideo setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateVideo setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
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

    public APIRequestCreateVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
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

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setFbuploaderVideoFileChunk (String fbuploaderVideoFileChunk) {
      this.setParam("fbuploader_video_file_chunk", fbuploaderVideoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
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

    public APIRequestCreateVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
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

    public APIRequestCreateVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestCreateVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
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

    public APIRequestCreateVideo setUploadSettingProperties (String uploadSettingProperties) {
      this.setParam("upload_setting_properties", uploadSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setTranscodeSettingProperties (String transcodeSettingProperties) {
      this.setParam("transcode_setting_properties", transcodeSettingProperties);
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

    public APIRequestCreateVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateVideo setReplaceVideoId (String replaceVideoId) {
      this.setParam("replace_video_id", replaceVideoId);
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

    public APIRequestCreateVideo setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreateVideo setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
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

  public static class APIRequestGet extends APIRequest<Group> {

    Group lastResponse = null;
    @Override
    public Group getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "icon_size",
    };

    public static final String[] FIELDS = {
      "archived",
      "cover",
      "created_time",
      "description",
      "email",
      "icon",
      "id",
      "link",
      "member_count",
      "member_request_count",
      "name",
      "owner",
      "parent",
      "permissions",
      "privacy",
      "purpose",
      "subdomain",
      "updated_time",
      "venue",
    };

    @Override
    public Group parseResponse(String response) throws APIException {
      return Group.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Group execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Group execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Group> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Group> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Group>() {
           public Group apply(String result) {
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


    public APIRequestGet setIconSize (EnumIconSize iconSize) {
      this.setParam("icon_size", iconSize);
      return this;
    }
    public APIRequestGet setIconSize (String iconSize) {
      this.setParam("icon_size", iconSize);
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

    public APIRequestGet requestArchivedField () {
      return this.requestArchivedField(true);
    }
    public APIRequestGet requestArchivedField (boolean value) {
      this.requestField("archived", value);
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
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
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
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMemberCountField () {
      return this.requestMemberCountField(true);
    }
    public APIRequestGet requestMemberCountField (boolean value) {
      this.requestField("member_count", value);
      return this;
    }
    public APIRequestGet requestMemberRequestCountField () {
      return this.requestMemberRequestCountField(true);
    }
    public APIRequestGet requestMemberRequestCountField (boolean value) {
      this.requestField("member_request_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGet requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGet requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGet requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGet requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGet requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGet requestPurposeField () {
      return this.requestPurposeField(true);
    }
    public APIRequestGet requestPurposeField (boolean value) {
      this.requestField("purpose", value);
      return this;
    }
    public APIRequestGet requestSubdomainField () {
      return this.requestSubdomainField(true);
    }
    public APIRequestGet requestSubdomainField (boolean value) {
      this.requestField("subdomain", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestVenueField () {
      return this.requestVenueField(true);
    }
    public APIRequestGet requestVenueField (boolean value) {
      this.requestField("venue", value);
      return this;
    }
  }

  public static enum EnumGroupType {
      @SerializedName("FAMILY")
      VALUE_FAMILY("FAMILY"),
      @SerializedName("CLOSE_FRIENDS")
      VALUE_CLOSE_FRIENDS("CLOSE_FRIENDS"),
      @SerializedName("NEIGHBORS")
      VALUE_NEIGHBORS("NEIGHBORS"),
      @SerializedName("TEAMMATES")
      VALUE_TEAMMATES("TEAMMATES"),
      @SerializedName("FOR_SALE")
      VALUE_FOR_SALE("FOR_SALE"),
      @SerializedName("EVENT_PLANNING")
      VALUE_EVENT_PLANNING("EVENT_PLANNING"),
      @SerializedName("SUPPORT")
      VALUE_SUPPORT("SUPPORT"),
      @SerializedName("CLUB")
      VALUE_CLUB("CLUB"),
      @SerializedName("PROJECT")
      VALUE_PROJECT("PROJECT"),
      @SerializedName("SORORITY")
      VALUE_SORORITY("SORORITY"),
      @SerializedName("FRATERNITY")
      VALUE_FRATERNITY("FRATERNITY"),
      @SerializedName("STUDY_GROUP")
      VALUE_STUDY_GROUP("STUDY_GROUP"),
      @SerializedName("SCHOOL_CLASS")
      VALUE_SCHOOL_CLASS("SCHOOL_CLASS"),
      @SerializedName("LEARNING")
      VALUE_LEARNING("LEARNING"),
      @SerializedName("MEME")
      VALUE_MEME("MEME"),
      @SerializedName("TRAVEL_PLANNING")
      VALUE_TRAVEL_PLANNING("TRAVEL_PLANNING"),
      @SerializedName("COUPLE")
      VALUE_COUPLE("COUPLE"),
      @SerializedName("PARENTS")
      VALUE_PARENTS("PARENTS"),
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("WORK_TEAM")
      VALUE_WORK_TEAM("WORK_TEAM"),
      @SerializedName("WORK_TEAMWORK")
      VALUE_WORK_TEAMWORK("WORK_TEAMWORK"),
      @SerializedName("WORK_FEEDBACK")
      VALUE_WORK_FEEDBACK("WORK_FEEDBACK"),
      @SerializedName("WORK_ANNOUNCEMENT")
      VALUE_WORK_ANNOUNCEMENT("WORK_ANNOUNCEMENT"),
      @SerializedName("WORK_DEMO_GROUP")
      VALUE_WORK_DEMO_GROUP("WORK_DEMO_GROUP"),
      @SerializedName("WORK_SOCIAL")
      VALUE_WORK_SOCIAL("WORK_SOCIAL"),
      @SerializedName("WORK_DISCUSSION")
      VALUE_WORK_DISCUSSION("WORK_DISCUSSION"),
      @SerializedName("WORK_MULTI_COMPANY")
      VALUE_WORK_MULTI_COMPANY("WORK_MULTI_COMPANY"),
      @SerializedName("WORK_FOR_SALE")
      VALUE_WORK_FOR_SALE("WORK_FOR_SALE"),
      @SerializedName("WORK_LEARNING")
      VALUE_WORK_LEARNING("WORK_LEARNING"),
      @SerializedName("FITNESS")
      VALUE_FITNESS("FITNESS"),
      @SerializedName("REAL_WORLD")
      VALUE_REAL_WORLD("REAL_WORLD"),
      @SerializedName("CASUAL")
      VALUE_CASUAL("CASUAL"),
      @SerializedName("GAME")
      VALUE_GAME("GAME"),
      @SerializedName("HIGH_SCHOOL_FORUM")
      VALUE_HIGH_SCHOOL_FORUM("HIGH_SCHOOL_FORUM"),
      @SerializedName("JOBS")
      VALUE_JOBS("JOBS"),
      @SerializedName("REAL_WORLD_AT_WORK")
      VALUE_REAL_WORLD_AT_WORK("REAL_WORLD_AT_WORK"),
      @SerializedName("FOR_WORK")
      VALUE_FOR_WORK("FOR_WORK"),
      @SerializedName("MENTORSHIP")
      VALUE_MENTORSHIP("MENTORSHIP"),
      @SerializedName("WORK_MENTORSHIP")
      VALUE_WORK_MENTORSHIP("WORK_MENTORSHIP"),
      @SerializedName("EPHEMERAL")
      VALUE_EPHEMERAL("EPHEMERAL"),
      @SerializedName("WORK_EPHEMERAL")
      VALUE_WORK_EPHEMERAL("WORK_EPHEMERAL"),
      NULL(null);

      private String value;

      private EnumGroupType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumJoinSetting {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("ANYONE")
      VALUE_ANYONE("ANYONE"),
      @SerializedName("ADMIN_ONLY")
      VALUE_ADMIN_ONLY("ADMIN_ONLY"),
      NULL(null);

      private String value;

      private EnumJoinSetting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPostPermissions {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("ADMIN_ONLY")
      VALUE_ADMIN_ONLY("ADMIN_ONLY"),
      @SerializedName("ANYONE")
      VALUE_ANYONE("ANYONE"),
      NULL(null);

      private String value;

      private EnumPostPermissions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSuggestionCategory {
      @SerializedName("FAMILY")
      VALUE_FAMILY("FAMILY"),
      @SerializedName("LIFE_EVENT")
      VALUE_LIFE_EVENT("LIFE_EVENT"),
      @SerializedName("TOP_PAGE")
      VALUE_TOP_PAGE("TOP_PAGE"),
      @SerializedName("WORK")
      VALUE_WORK("WORK"),
      @SerializedName("WORK_GENERIC")
      VALUE_WORK_GENERIC("WORK_GENERIC"),
      @SerializedName("SCHOOL")
      VALUE_SCHOOL("SCHOOL"),
      @SerializedName("SCHOOL_GENERIC")
      VALUE_SCHOOL_GENERIC("SCHOOL_GENERIC"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("MESSENGER_THREAD")
      VALUE_MESSENGER_THREAD("MESSENGER_THREAD"),
      @SerializedName("PAGE_ADMIN")
      VALUE_PAGE_ADMIN("PAGE_ADMIN"),
      @SerializedName("FRIEND_LIST")
      VALUE_FRIEND_LIST("FRIEND_LIST"),
      @SerializedName("GAMES")
      VALUE_GAMES("GAMES"),
      @SerializedName("EVENT")
      VALUE_EVENT("EVENT"),
      @SerializedName("CLOSE_FRIENDS")
      VALUE_CLOSE_FRIENDS("CLOSE_FRIENDS"),
      @SerializedName("CLOSE_FRIENDS_GENERIC")
      VALUE_CLOSE_FRIENDS_GENERIC("CLOSE_FRIENDS_GENERIC"),
      @SerializedName("NEARBY_FRIENDS")
      VALUE_NEARBY_FRIENDS("NEARBY_FRIENDS"),
      @SerializedName("CURRENT_CITY")
      VALUE_CURRENT_CITY("CURRENT_CITY"),
      @SerializedName("WORKPLACE_1_1")
      VALUE_WORKPLACE_1_1("WORKPLACE_1_1"),
      @SerializedName("WORKPLACE_MANAGER")
      VALUE_WORKPLACE_MANAGER("WORKPLACE_MANAGER"),
      @SerializedName("WORKPLACE")
      VALUE_WORKPLACE("WORKPLACE"),
      NULL(null);

      private String value;

      private EnumSuggestionCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBackdatedTimeGranularity {
      @SerializedName("year")
      VALUE_YEAR("year"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("hour")
      VALUE_HOUR("hour"),
      @SerializedName("min")
      VALUE_MIN("min"),
      @SerializedName("none")
      VALUE_NONE("none"),
      NULL(null);

      private String value;

      private EnumBackdatedTimeGranularity(String value) {
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

  public static enum EnumPostingToRedspace {
      @SerializedName("enabled")
      VALUE_ENABLED("enabled"),
      @SerializedName("disabled")
      VALUE_DISABLED("disabled"),
      NULL(null);

      private String value;

      private EnumPostingToRedspace(String value) {
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
      NULL(null);

      private String value;

      private EnumPlaceAttachmentSetting(String value) {
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
      @SerializedName("BRANDING_STATUS")
      VALUE_BRANDING_STATUS("BRANDING_STATUS"),
      @SerializedName("BRANDING_PHOTO")
      VALUE_BRANDING_PHOTO("BRANDING_PHOTO"),
      @SerializedName("BRANDING_OTHER")
      VALUE_BRANDING_OTHER("BRANDING_OTHER"),
      NULL(null);

      private String value;

      private EnumCheckinEntryPoint(String value) {
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
      NULL(null);

      private String value;

      private EnumPostSurfacesBlacklist(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFormatting {
      @SerializedName("PLAINTEXT")
      VALUE_PLAINTEXT("PLAINTEXT"),
      @SerializedName("MARKDOWN")
      VALUE_MARKDOWN("MARKDOWN"),
      NULL(null);

      private String value;

      private EnumFormatting(String value) {
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
      NULL(null);

      private String value;

      private EnumTargetSurface(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumIconSize {
      @SerializedName("16")
      VALUE_16("16"),
      @SerializedName("34")
      VALUE_34("34"),
      @SerializedName("50")
      VALUE_50("50"),
      @SerializedName("68")
      VALUE_68("68"),
      NULL(null);

      private String value;

      private EnumIconSize(String value) {
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

  public Group copyFrom(Group instance) {
    this.mArchived = instance.mArchived;
    this.mCover = instance.mCover;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEmail = instance.mEmail;
    this.mIcon = instance.mIcon;
    this.mId = instance.mId;
    this.mLink = instance.mLink;
    this.mMemberCount = instance.mMemberCount;
    this.mMemberRequestCount = instance.mMemberRequestCount;
    this.mName = instance.mName;
    this.mOwner = instance.mOwner;
    this.mParent = instance.mParent;
    this.mPermissions = instance.mPermissions;
    this.mPrivacy = instance.mPrivacy;
    this.mPurpose = instance.mPurpose;
    this.mSubdomain = instance.mSubdomain;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVenue = instance.mVenue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Group> getParser() {
    return new APIRequest.ResponseParser<Group>() {
      public APINodeList<Group> parseResponse(String response, APIContext context, APIRequest<Group> request) throws MalformedResponseException {
        return Group.parseResponse(response, context, request);
      }
    };
  }
}
