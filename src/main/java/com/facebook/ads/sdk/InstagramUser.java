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
public class InstagramUser extends APINode {
  @SerializedName("follow_count")
  private Long mFollowCount = null;
  @SerializedName("followed_by_count")
  private Long mFollowedByCount = null;
  @SerializedName("has_profile_picture")
  private Boolean mHasProfilePicture = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_user_id")
  private String mIgUserId = null;
  @SerializedName("is_private")
  private Boolean mIsPrivate = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mini_shop_storefront")
  private Shop mMiniShopStorefront = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("profile_pic")
  private String mProfilePic = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  InstagramUser() {
  }

  public InstagramUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstagramUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstagramUser fetch() throws APIException{
    InstagramUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstagramUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstagramUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstagramUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstagramUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstagramUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstagramUser>)(
      new APIRequest<InstagramUser>(context, "", "/", "GET", InstagramUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstagramUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstagramUser.getParser())
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
  public static InstagramUser loadJSON(String json, APIContext context, String header) {
    InstagramUser instagramUser = getGson().fromJson(json, InstagramUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramUser.context = context;
    instagramUser.rawValue = json;
    instagramUser.header = header;
    return instagramUser;
  }

  public static APINodeList<InstagramUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramUser> instagramUsers = new APINodeList<InstagramUser>(request, json, header);
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
          instagramUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramUsers;
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
              instagramUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramUsers;
          }

          // Sixth, check if it's pure JsonObject
          instagramUsers.clear();
          instagramUsers.add(loadJSON(json, context, header));
          return instagramUsers;
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

  public APIRequestGetUpcomingEvents getUpcomingEvents() {
    return new APIRequestGetUpcomingEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldFollowCount() {
    return mFollowCount;
  }

  public Long getFieldFollowedByCount() {
    return mFollowedByCount;
  }

  public Boolean getFieldHasProfilePicture() {
    return mHasProfilePicture;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIgUserId() {
    return mIgUserId;
  }

  public Boolean getFieldIsPrivate() {
    return mIsPrivate;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public Shop getFieldMiniShopStorefront() {
    if (mMiniShopStorefront != null) {
      mMiniShopStorefront.context = getContext();
    }
    return mMiniShopStorefront;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldProfilePic() {
    return mProfilePic;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetUpcomingEvents extends APIRequest<IGUpcomingEvent> {

    APINodeList<IGUpcomingEvent> lastResponse = null;
    @Override
    public APINodeList<IGUpcomingEvent> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "end_time",
      "id",
      "notification_subtypes",
      "notification_target_time",
      "start_time",
      "title",
    };

    @Override
    public APINodeList<IGUpcomingEvent> parseResponse(String response, String header) throws APIException {
      return IGUpcomingEvent.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGUpcomingEvent> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGUpcomingEvent> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGUpcomingEvent>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGUpcomingEvent>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGUpcomingEvent>>() {
           public APINodeList<IGUpcomingEvent> apply(ResponseWrapper result) {
             try {
               return APIRequestGetUpcomingEvents.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetUpcomingEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/upcoming_events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUpcomingEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUpcomingEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUpcomingEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUpcomingEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUpcomingEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUpcomingEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestNotificationSubtypesField () {
      return this.requestNotificationSubtypesField(true);
    }
    public APIRequestGetUpcomingEvents requestNotificationSubtypesField (boolean value) {
      this.requestField("notification_subtypes", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestNotificationTargetTimeField () {
      return this.requestNotificationTargetTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestNotificationTargetTimeField (boolean value) {
      this.requestField("notification_target_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetUpcomingEvents requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<InstagramUser> {

    InstagramUser lastResponse = null;
    @Override
    public InstagramUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
    };

    public static final String[] FIELDS = {
      "follow_count",
      "followed_by_count",
      "has_profile_picture",
      "id",
      "ig_user_id",
      "is_private",
      "is_published",
      "media_count",
      "mini_shop_storefront",
      "owner_business",
      "profile_pic",
      "username",
    };

    @Override
    public InstagramUser parseResponse(String response, String header) throws APIException {
      return InstagramUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramUser>() {
           public InstagramUser apply(ResponseWrapper result) {
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


    public APIRequestGet setAdgroupId (String adgroupId) {
      this.setParam("adgroup_id", adgroupId);
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

    public APIRequestGet requestFollowCountField () {
      return this.requestFollowCountField(true);
    }
    public APIRequestGet requestFollowCountField (boolean value) {
      this.requestField("follow_count", value);
      return this;
    }
    public APIRequestGet requestFollowedByCountField () {
      return this.requestFollowedByCountField(true);
    }
    public APIRequestGet requestFollowedByCountField (boolean value) {
      this.requestField("followed_by_count", value);
      return this;
    }
    public APIRequestGet requestHasProfilePictureField () {
      return this.requestHasProfilePictureField(true);
    }
    public APIRequestGet requestHasProfilePictureField (boolean value) {
      this.requestField("has_profile_picture", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgUserIdField () {
      return this.requestIgUserIdField(true);
    }
    public APIRequestGet requestIgUserIdField (boolean value) {
      this.requestField("ig_user_id", value);
      return this;
    }
    public APIRequestGet requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGet requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGet requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGet requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
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

  public InstagramUser copyFrom(InstagramUser instance) {
    this.mFollowCount = instance.mFollowCount;
    this.mFollowedByCount = instance.mFollowedByCount;
    this.mHasProfilePicture = instance.mHasProfilePicture;
    this.mId = instance.mId;
    this.mIgUserId = instance.mIgUserId;
    this.mIsPrivate = instance.mIsPrivate;
    this.mIsPublished = instance.mIsPublished;
    this.mMediaCount = instance.mMediaCount;
    this.mMiniShopStorefront = instance.mMiniShopStorefront;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mProfilePic = instance.mProfilePic;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramUser> getParser() {
    return new APIRequest.ResponseParser<InstagramUser>() {
      public APINodeList<InstagramUser> parseResponse(String response, APIContext context, APIRequest<InstagramUser> request, String header) throws MalformedResponseException {
        return InstagramUser.parseResponse(response, context, request, header);
      }
    };
  }
}
