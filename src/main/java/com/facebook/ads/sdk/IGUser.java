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
public class IGUser extends APINode {
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("business_discovery")
  private IGUser mBusinessDiscovery = null;
  @SerializedName("followers_count")
  private Long mFollowersCount = null;
  @SerializedName("follows_count")
  private Long mFollowsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private Long mIgId = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mentioned_comment")
  private IGComment mMentionedComment = null;
  @SerializedName("mentioned_media")
  private IGMedia mMentionedMedia = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("profile_picture_url")
  private String mProfilePictureUrl = null;
  @SerializedName("shopping_product_tag_eligibility")
  private Boolean mShoppingProductTagEligibility = null;
  @SerializedName("shopping_review_status")
  private String mShoppingReviewStatus = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  IGUser() {
  }

  public IGUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUser fetch() throws APIException{
    IGUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUser>)(
      new APIRequest<IGUser>(context, "", "/", "GET", IGUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUser.getParser())
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
  public static IGUser loadJSON(String json, APIContext context, String header) {
    IGUser igUser = getGson().fromJson(json, IGUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUser.context = context;
    igUser.rawValue = json;
    igUser.header = header;
    return igUser;
  }

  public static APINodeList<IGUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUser> igUsers = new APINodeList<IGUser>(request, json, header);
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
          igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUsers;
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
              igUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUsers;
          }

          // Sixth, check if it's pure JsonObject
          igUsers.clear();
          igUsers.add(loadJSON(json, context, header));
          return igUsers;
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

  public APIRequestGetAvailableCatalogs getAvailableCatalogs() {
    return new APIRequestGetAvailableCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentAdPermissions getBrandedContentAdPermissions() {
    return new APIRequestGetBrandedContentAdPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBrandedContentAdPermission createBrandedContentAdPermission() {
    return new APIRequestCreateBrandedContentAdPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentAdvertisableMedias getBrandedContentAdvertisableMedias() {
    return new APIRequestGetBrandedContentAdvertisableMedias(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteBrandedContentTagApproval deleteBrandedContentTagApproval() {
    return new APIRequestDeleteBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentTagApproval getBrandedContentTagApproval() {
    return new APIRequestGetBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBrandedContentTagApproval createBrandedContentTagApproval() {
    return new APIRequestCreateBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCatalogProductSearch getCatalogProductSearch() {
    return new APIRequestGetCatalogProductSearch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetContentPublishingLimit getContentPublishingLimit() {
    return new APIRequestGetContentPublishingLimit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDataSet getDataSet() {
    return new APIRequestGetDataSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateDataSet createDataSet() {
    return new APIRequestCreateDataSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveMedia getLiveMedia() {
    return new APIRequestGetLiveMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMedia getMedia() {
    return new APIRequestGetMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMedia createMedia() {
    return new APIRequestCreateMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMediaPublish createMediaPublish() {
    return new APIRequestCreateMediaPublish(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMention createMention() {
    return new APIRequestCreateMention(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNotificationMessageTokens getNotificationMessageTokens() {
    return new APIRequestGetNotificationMessageTokens(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductAppeal getProductAppeal() {
    return new APIRequestGetProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductAppeal createProductAppeal() {
    return new APIRequestCreateProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRecentlySearchedHashtags getRecentlySearchedHashtags() {
    return new APIRequestGetRecentlySearchedHashtags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStories getStories() {
    return new APIRequestGetStories(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBiography() {
    return mBiography;
  }

  public IGUser getFieldBusinessDiscovery() {
    if (mBusinessDiscovery != null) {
      mBusinessDiscovery.context = getContext();
    }
    return mBusinessDiscovery;
  }

  public Long getFieldFollowersCount() {
    return mFollowersCount;
  }

  public Long getFieldFollowsCount() {
    return mFollowsCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIgId() {
    return mIgId;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public IGComment getFieldMentionedComment() {
    if (mMentionedComment != null) {
      mMentionedComment.context = getContext();
    }
    return mMentionedComment;
  }

  public IGMedia getFieldMentionedMedia() {
    if (mMentionedMedia != null) {
      mMentionedMedia.context = getContext();
    }
    return mMentionedMedia;
  }

  public String getFieldName() {
    return mName;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public Boolean getFieldShoppingProductTagEligibility() {
    return mShoppingProductTagEligibility;
  }

  public String getFieldShoppingReviewStatus() {
    return mShoppingReviewStatus;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }



  public static class APIRequestGetAvailableCatalogs extends APIRequest<UserAvailableCatalogs> {

    APINodeList<UserAvailableCatalogs> lastResponse = null;
    @Override
    public APINodeList<UserAvailableCatalogs> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "catalog_id",
      "catalog_name",
      "product_count",
      "shop_name",
    };

    @Override
    public APINodeList<UserAvailableCatalogs> parseResponse(String response, String header) throws APIException {
      return UserAvailableCatalogs.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UserAvailableCatalogs> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UserAvailableCatalogs> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UserAvailableCatalogs>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UserAvailableCatalogs>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UserAvailableCatalogs>>() {
           public APINodeList<UserAvailableCatalogs> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAvailableCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAvailableCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/available_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAvailableCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAvailableCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAvailableCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAvailableCatalogs requestCatalogIdField () {
      return this.requestCatalogIdField(true);
    }
    public APIRequestGetAvailableCatalogs requestCatalogIdField (boolean value) {
      this.requestField("catalog_id", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestCatalogNameField () {
      return this.requestCatalogNameField(true);
    }
    public APIRequestGetAvailableCatalogs requestCatalogNameField (boolean value) {
      this.requestField("catalog_name", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetAvailableCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestShopNameField () {
      return this.requestShopNameField(true);
    }
    public APIRequestGetAvailableCatalogs requestShopNameField (boolean value) {
      this.requestField("shop_name", value);
      return this;
    }
  }

  public static class APIRequestGetBrandedContentAdPermissions extends APIRequest<IGBCAdsPermission> {

    APINodeList<IGBCAdsPermission> lastResponse = null;
    @Override
    public APINodeList<IGBCAdsPermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "permission_type",
      "status",
    };

    @Override
    public APINodeList<IGBCAdsPermission> parseResponse(String response, String header) throws APIException {
      return IGBCAdsPermission.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGBCAdsPermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGBCAdsPermission> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGBCAdsPermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGBCAdsPermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGBCAdsPermission>>() {
           public APINodeList<IGBCAdsPermission> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentAdPermissions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentAdPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_ad_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentAdPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentAdPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentAdPermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdPermissions requestPermissionTypeField () {
      return this.requestPermissionTypeField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestPermissionTypeField (boolean value) {
      this.requestField("permission_type", value);
      return this;
    }
    public APIRequestGetBrandedContentAdPermissions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreateBrandedContentAdPermission extends APIRequest<IGBCAdsPermission> {

    IGBCAdsPermission lastResponse = null;
    @Override
    public IGBCAdsPermission getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creator_instagram_account",
      "creator_instagram_username",
      "revoke",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGBCAdsPermission parseResponse(String response, String header) throws APIException {
      return IGBCAdsPermission.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGBCAdsPermission execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGBCAdsPermission execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGBCAdsPermission> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGBCAdsPermission> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGBCAdsPermission>() {
           public IGBCAdsPermission apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBrandedContentAdPermission.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBrandedContentAdPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_ad_permissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBrandedContentAdPermission setCreatorInstagramAccount (String creatorInstagramAccount) {
      this.setParam("creator_instagram_account", creatorInstagramAccount);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission setCreatorInstagramUsername (String creatorInstagramUsername) {
      this.setParam("creator_instagram_username", creatorInstagramUsername);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission setRevoke (Boolean revoke) {
      this.setParam("revoke", revoke);
      return this;
    }
    public APIRequestCreateBrandedContentAdPermission setRevoke (String revoke) {
      this.setParam("revoke", revoke);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBrandedContentAdPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBrandedContentAdvertisableMedias extends APIRequest<BrandedContentShadowIGMediaID> {

    APINodeList<BrandedContentShadowIGMediaID> lastResponse = null;
    @Override
    public APINodeList<BrandedContentShadowIGMediaID> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creator_username",
      "only_fetch_allowlisted",
      "permalinks",
    };

    public static final String[] FIELDS = {
      "eligibility_errors",
      "has_permission_for_partnership_ad",
      "id",
      "owner_id",
      "permalink",
    };

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGMediaID.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BrandedContentShadowIGMediaID>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BrandedContentShadowIGMediaID>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BrandedContentShadowIGMediaID>>() {
           public APINodeList<BrandedContentShadowIGMediaID> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentAdvertisableMedias.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentAdvertisableMedias(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_advertisable_medias", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentAdvertisableMedias setCreatorUsername (String creatorUsername) {
      this.setParam("creator_username", creatorUsername);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchAllowlisted (Boolean onlyFetchAllowlisted) {
      this.setParam("only_fetch_allowlisted", onlyFetchAllowlisted);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchAllowlisted (String onlyFetchAllowlisted) {
      this.setParam("only_fetch_allowlisted", onlyFetchAllowlisted);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setPermalinks (List<String> permalinks) {
      this.setParam("permalinks", permalinks);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias setPermalinks (String permalinks) {
      this.setParam("permalinks", permalinks);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestEligibilityErrorsField () {
      return this.requestEligibilityErrorsField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestEligibilityErrorsField (boolean value) {
      this.requestField("eligibility_errors", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestHasPermissionForPartnershipAdField () {
      return this.requestHasPermissionForPartnershipAdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestHasPermissionForPartnershipAdField (boolean value) {
      this.requestField("has_permission_for_partnership_ad", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
  }

  public static class APIRequestDeleteBrandedContentTagApproval extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
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
               return APIRequestDeleteBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestDeleteBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestDeleteBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBrandedContentTagApproval extends APIRequest<BrandedContentShadowIGUserID> {

    APINodeList<BrandedContentShadowIGUserID> lastResponse = null;
    @Override
    public APINodeList<BrandedContentShadowIGUserID> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public APINodeList<BrandedContentShadowIGUserID> parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGUserID.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BrandedContentShadowIGUserID> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BrandedContentShadowIGUserID> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BrandedContentShadowIGUserID>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BrandedContentShadowIGUserID>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BrandedContentShadowIGUserID>>() {
           public APINodeList<BrandedContentShadowIGUserID> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestGetBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestGetBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentTagApproval requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentTagApproval requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateBrandedContentTagApproval extends APIRequest<BrandedContentShadowIGUserID> {

    BrandedContentShadowIGUserID lastResponse = null;
    @Override
    public BrandedContentShadowIGUserID getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BrandedContentShadowIGUserID parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGUserID.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BrandedContentShadowIGUserID execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BrandedContentShadowIGUserID execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BrandedContentShadowIGUserID> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BrandedContentShadowIGUserID> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BrandedContentShadowIGUserID>() {
           public BrandedContentShadowIGUserID apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestCreateBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestCreateBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCatalogProductSearch extends APIRequest<ShadowIGUserCatalogProductSearch> {

    APINodeList<ShadowIGUserCatalogProductSearch> lastResponse = null;
    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
      "q",
    };

    public static final String[] FIELDS = {
      "image_url",
      "is_checkout_flow",
      "merchant_id",
      "product_id",
      "product_name",
      "product_variants",
      "retailer_id",
      "review_status",
    };

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> parseResponse(String response, String header) throws APIException {
      return ShadowIGUserCatalogProductSearch.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGUserCatalogProductSearch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGUserCatalogProductSearch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGUserCatalogProductSearch>>() {
           public APINodeList<ShadowIGUserCatalogProductSearch> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCatalogProductSearch.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCatalogProductSearch(String nodeId, APIContext context) {
      super(context, nodeId, "/catalog_product_search", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCatalogProductSearch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCatalogProductSearch setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestGetCatalogProductSearch setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetCatalogProductSearch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCatalogProductSearch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCatalogProductSearch requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetCatalogProductSearch requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestIsCheckoutFlowField () {
      return this.requestIsCheckoutFlowField(true);
    }
    public APIRequestGetCatalogProductSearch requestIsCheckoutFlowField (boolean value) {
      this.requestField("is_checkout_flow", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductNameField () {
      return this.requestProductNameField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductNameField (boolean value) {
      this.requestField("product_name", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductVariantsField () {
      return this.requestProductVariantsField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductVariantsField (boolean value) {
      this.requestField("product_variants", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetCatalogProductSearch requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
  }

  public static class APIRequestGetContentPublishingLimit extends APIRequest<ContentPublishingLimitResponse> {

    APINodeList<ContentPublishingLimitResponse> lastResponse = null;
    @Override
    public APINodeList<ContentPublishingLimitResponse> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
    };

    public static final String[] FIELDS = {
      "config",
      "quota_usage",
    };

    @Override
    public APINodeList<ContentPublishingLimitResponse> parseResponse(String response, String header) throws APIException {
      return ContentPublishingLimitResponse.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ContentPublishingLimitResponse>>() {
           public APINodeList<ContentPublishingLimitResponse> apply(ResponseWrapper result) {
             try {
               return APIRequestGetContentPublishingLimit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetContentPublishingLimit(String nodeId, APIContext context) {
      super(context, nodeId, "/content_publishing_limit", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetContentPublishingLimit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetContentPublishingLimit setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetContentPublishingLimit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetContentPublishingLimit requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField () {
      return this.requestQuotaUsageField(true);
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField (boolean value) {
      this.requestField("quota_usage", value);
      return this;
    }
  }

  public static class APIRequestGetDataSet extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "automatic_matching_fields",
      "can_proxy",
      "code",
      "config",
      "creation_time",
      "creator",
      "data_use_setting",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "enable_automatic_matching",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_party_cookie_status",
      "has_1p_pixel_event",
      "id",
      "is_consolidated_container",
      "is_created_by_business",
      "is_crm",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_fired_time",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "name",
      "owner_ad_account",
      "owner_business",
      "usage",
      "user_access_expire_time",
      "valid_entries",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response, String header) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDataSet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDataSet(String nodeId, APIContext context) {
      super(context, nodeId, "/dataset", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDataSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDataSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDataSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDataSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDataSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDataSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDataSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDataSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDataSet requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGetDataSet requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGetDataSet requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetDataSet requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetDataSet requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetDataSet requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetDataSet requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetDataSet requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetDataSet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetDataSet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetDataSet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetDataSet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetDataSet requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetDataSet requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetDataSet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDataSet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDataSet requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetDataSet requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetDataSet requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetDataSet requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetDataSet requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetDataSet requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetDataSet requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetDataSet requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetDataSet requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetDataSet requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetDataSet requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetDataSet requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetDataSet requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetDataSet requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetDataSet requestHas1pPixelEventField () {
      return this.requestHas1pPixelEventField(true);
    }
    public APIRequestGetDataSet requestHas1pPixelEventField (boolean value) {
      this.requestField("has_1p_pixel_event", value);
      return this;
    }
    public APIRequestGetDataSet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDataSet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDataSet requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetDataSet requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetDataSet requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetDataSet requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetDataSet requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetDataSet requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetDataSet requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetDataSet requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetDataSet requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetDataSet requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetDataSet requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetDataSet requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetDataSet requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetDataSet requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetDataSet requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetDataSet requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetDataSet requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetDataSet requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetDataSet requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetDataSet requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetDataSet requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetDataSet requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetDataSet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDataSet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDataSet requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetDataSet requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetDataSet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetDataSet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetDataSet requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetDataSet requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetDataSet requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetDataSet requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetDataSet requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetDataSet requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestCreateDataSet extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response, String header) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsPixel>() {
           public AdsPixel apply(ResponseWrapper result) {
             try {
               return APIRequestCreateDataSet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDataSet(String nodeId, APIContext context) {
      super(context, nodeId, "/dataset", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDataSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDataSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDataSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDataSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDataSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDataSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDataSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDataSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<InstagramInsightsResult> {

    APINodeList<InstagramInsightsResult> lastResponse = null;
    @Override
    public APINodeList<InstagramInsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "metric_type",
      "period",
      "since",
      "timeframe",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "name",
      "period",
      "title",
      "total_value",
      "values",
    };

    @Override
    public APINodeList<InstagramInsightsResult> parseResponse(String response, String header) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramInsightsResult>>() {
           public APINodeList<InstagramInsightsResult> apply(ResponseWrapper result) {
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


    public APIRequestGetInsights setBreakdown (List<InstagramInsightsResult.EnumBreakdown> breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInsights setMetric (List<InstagramInsightsResult.EnumMetric> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setMetricType (InstagramInsightsResult.EnumMetricType metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }
    public APIRequestGetInsights setMetricType (String metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }

    public APIRequestGetInsights setPeriod (List<InstagramInsightsResult.EnumPeriod> period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setTimeframe (InstagramInsightsResult.EnumTimeframe timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }
    public APIRequestGetInsights setTimeframe (String timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
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
    public APIRequestGetInsights requestTotalValueField () {
      return this.requestTotalValueField(true);
    }
    public APIRequestGetInsights requestTotalValueField (boolean value) {
      this.requestField("total_value", value);
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

  public static class APIRequestGetLiveMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLiveMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLiveMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/live_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetLiveMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetLiveMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLiveMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetLiveMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetLiveMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetLiveMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetLiveMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetLiveMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetLiveMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetLiveMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetLiveMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetLiveMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetLiveMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetLiveMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetLiveMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetLiveMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetLiveMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetLiveMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLiveMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateMedia extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "audio_name",
      "caption",
      "children",
      "collaborators",
      "cover_url",
      "image_url",
      "is_carousel_item",
      "location_id",
      "media_type",
      "product_tags",
      "share_to_feed",
      "thumb_offset",
      "upload_type",
      "user_tags",
      "video_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMedia setAudioName (String audioName) {
      this.setParam("audio_name", audioName);
      return this;
    }

    public APIRequestCreateMedia setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateMedia setChildren (List<String> children) {
      this.setParam("children", children);
      return this;
    }
    public APIRequestCreateMedia setChildren (String children) {
      this.setParam("children", children);
      return this;
    }

    public APIRequestCreateMedia setCollaborators (List<String> collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }
    public APIRequestCreateMedia setCollaborators (String collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }

    public APIRequestCreateMedia setCoverUrl (String coverUrl) {
      this.setParam("cover_url", coverUrl);
      return this;
    }

    public APIRequestCreateMedia setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateMedia setIsCarouselItem (Boolean isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }
    public APIRequestCreateMedia setIsCarouselItem (String isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }

    public APIRequestCreateMedia setLocationId (String locationId) {
      this.setParam("location_id", locationId);
      return this;
    }

    public APIRequestCreateMedia setMediaType (String mediaType) {
      this.setParam("media_type", mediaType);
      return this;
    }

    public APIRequestCreateMedia setProductTags (List<Map<String, String>> productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }
    public APIRequestCreateMedia setProductTags (String productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }

    public APIRequestCreateMedia setShareToFeed (Boolean shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }
    public APIRequestCreateMedia setShareToFeed (String shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }

    public APIRequestCreateMedia setThumbOffset (String thumbOffset) {
      this.setParam("thumb_offset", thumbOffset);
      return this;
    }

    public APIRequestCreateMedia setUploadType (String uploadType) {
      this.setParam("upload_type", uploadType);
      return this;
    }

    public APIRequestCreateMedia setUserTags (List<Map<String, String>> userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }
    public APIRequestCreateMedia setUserTags (String userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }

    public APIRequestCreateMedia setVideoUrl (String videoUrl) {
      this.setParam("video_url", videoUrl);
      return this;
    }

    public APIRequestCreateMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMediaPublish extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMediaPublish.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMediaPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/media_publish", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMediaPublish setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMediaPublish setCreationId (Long creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }
    public APIRequestCreateMediaPublish setCreationId (String creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }

    public APIRequestCreateMediaPublish requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMediaPublish requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMention extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_id",
      "media_id",
      "message",
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
               return APIRequestCreateMention.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMention(String nodeId, APIContext context) {
      super(context, nodeId, "/mentions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMention setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMention setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMention setCommentId (String commentId) {
      this.setParam("comment_id", commentId);
      return this;
    }

    public APIRequestCreateMention setMediaId (String mediaId) {
      this.setParam("media_id", mediaId);
      return this;
    }

    public APIRequestCreateMention setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMention requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMention requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetNotificationMessageTokens extends APIRequest<UserPageOneTimeOptInTokenSettings> {

    APINodeList<UserPageOneTimeOptInTokenSettings> lastResponse = null;
    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_timestamp",
      "next_eligible_time",
      "notification_messages_frequency",
      "notification_messages_reoptin",
      "notification_messages_timezone",
      "notification_messages_token",
      "recipient_id",
      "token_expiry_timestamp",
      "topic_title",
      "user_token_status",
      "id",
    };

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> parseResponse(String response, String header) throws APIException {
      return UserPageOneTimeOptInTokenSettings.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UserPageOneTimeOptInTokenSettings>>() {
           public APINodeList<UserPageOneTimeOptInTokenSettings> apply(ResponseWrapper result) {
             try {
               return APIRequestGetNotificationMessageTokens.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetNotificationMessageTokens(String nodeId, APIContext context) {
      super(context, nodeId, "/notification_message_tokens", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNotificationMessageTokens requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNotificationMessageTokens requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNotificationMessageTokens requestCreationTimestampField () {
      return this.requestCreationTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestCreationTimestampField (boolean value) {
      this.requestField("creation_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField () {
      return this.requestNextEligibleTimeField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField (boolean value) {
      this.requestField("next_eligible_time", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField () {
      return this.requestNotificationMessagesFrequencyField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField (boolean value) {
      this.requestField("notification_messages_frequency", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField () {
      return this.requestNotificationMessagesReoptinField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField (boolean value) {
      this.requestField("notification_messages_reoptin", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField () {
      return this.requestNotificationMessagesTimezoneField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField (boolean value) {
      this.requestField("notification_messages_timezone", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField () {
      return this.requestNotificationMessagesTokenField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField (boolean value) {
      this.requestField("notification_messages_token", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField () {
      return this.requestRecipientIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField (boolean value) {
      this.requestField("recipient_id", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField () {
      return this.requestTokenExpiryTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField (boolean value) {
      this.requestField("token_expiry_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField () {
      return this.requestTopicTitleField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField (boolean value) {
      this.requestField("topic_title", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField () {
      return this.requestUserTokenStatusField(true);
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField (boolean value) {
      this.requestField("user_token_status", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetProductAppeal extends APIRequest<IGShoppingProductAppeal> {

    APINodeList<IGShoppingProductAppeal> lastResponse = null;
    @Override
    public APINodeList<IGShoppingProductAppeal> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "product_id",
    };

    public static final String[] FIELDS = {
      "eligible_for_appeal",
      "product_appeal_status",
      "product_id",
      "rejection_reasons",
      "review_status",
    };

    @Override
    public APINodeList<IGShoppingProductAppeal> parseResponse(String response, String header) throws APIException {
      return IGShoppingProductAppeal.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGShoppingProductAppeal> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGShoppingProductAppeal> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGShoppingProductAppeal>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGShoppingProductAppeal>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGShoppingProductAppeal>>() {
           public APINodeList<IGShoppingProductAppeal> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestGetProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductAppeal requestEligibleForAppealField () {
      return this.requestEligibleForAppealField(true);
    }
    public APIRequestGetProductAppeal requestEligibleForAppealField (boolean value) {
      this.requestField("eligible_for_appeal", value);
      return this;
    }
    public APIRequestGetProductAppeal requestProductAppealStatusField () {
      return this.requestProductAppealStatusField(true);
    }
    public APIRequestGetProductAppeal requestProductAppealStatusField (boolean value) {
      this.requestField("product_appeal_status", value);
      return this;
    }
    public APIRequestGetProductAppeal requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetProductAppeal requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetProductAppeal requestRejectionReasonsField () {
      return this.requestRejectionReasonsField(true);
    }
    public APIRequestGetProductAppeal requestRejectionReasonsField (boolean value) {
      this.requestField("rejection_reasons", value);
      return this;
    }
    public APIRequestGetProductAppeal requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetProductAppeal requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
  }

  public static class APIRequestCreateProductAppeal extends APIRequest<IGShoppingProductAppeal> {

    IGShoppingProductAppeal lastResponse = null;
    @Override
    public IGShoppingProductAppeal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "appeal_reason",
      "product_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGShoppingProductAppeal parseResponse(String response, String header) throws APIException {
      return IGShoppingProductAppeal.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGShoppingProductAppeal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGShoppingProductAppeal execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGShoppingProductAppeal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGShoppingProductAppeal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGShoppingProductAppeal>() {
           public IGShoppingProductAppeal apply(ResponseWrapper result) {
             try {
               return APIRequestCreateProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductAppeal setAppealReason (String appealReason) {
      this.setParam("appeal_reason", appealReason);
      return this;
    }

    public APIRequestCreateProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestCreateProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRecentlySearchedHashtags extends APIRequest<ShadowIGHashtag> {

    APINodeList<ShadowIGHashtag> lastResponse = null;
    @Override
    public APINodeList<ShadowIGHashtag> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
    };

    @Override
    public APINodeList<ShadowIGHashtag> parseResponse(String response, String header) throws APIException {
      return ShadowIGHashtag.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGHashtag> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGHashtag> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGHashtag>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGHashtag>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGHashtag>>() {
           public APINodeList<ShadowIGHashtag> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRecentlySearchedHashtags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRecentlySearchedHashtags(String nodeId, APIContext context) {
      super(context, nodeId, "/recently_searched_hashtags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentlySearchedHashtags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentlySearchedHashtags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRecentlySearchedHashtags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRecentlySearchedHashtags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRecentlySearchedHashtags requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetRecentlySearchedHashtags requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestGetStories extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetStories.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetStories(String nodeId, APIContext context) {
      super(context, nodeId, "/stories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetStories requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetStories requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetStories requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetStories requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetStories requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetStories requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetStories requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetStories requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetStories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetStories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetStories requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetStories requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetStories requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetStories requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetStories requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetStories requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetStories requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetStories requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetStories requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetStories requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetStories requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetStories requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetStories requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetStories requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetStories requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetStories requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetStories requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetStories requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetStories requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetStories requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetStories requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStories requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetStories requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetStories requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTags extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGetTags requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetTags requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetTags requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTags requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTags requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetTags requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetTags requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetTags requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTags requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetTags requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetTags requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetTags requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetTags requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetTags requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetTags requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetTags requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetTags requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetTags requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetTags requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetTags requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetTags requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetTags requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetTags requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetTags requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetTags requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetTags requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetTags requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetTags requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetTags requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetTags requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTags requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<IGUser> {

    IGUser lastResponse = null;
    @Override
    public IGUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
    };

    public static final String[] FIELDS = {
      "biography",
      "business_discovery",
      "followers_count",
      "follows_count",
      "id",
      "ig_id",
      "media_count",
      "mentioned_comment",
      "mentioned_media",
      "name",
      "owner_business",
      "profile_picture_url",
      "shopping_product_tag_eligibility",
      "shopping_review_status",
      "username",
      "website",
    };

    @Override
    public IGUser parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUser>() {
           public IGUser apply(ResponseWrapper result) {
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

    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGet requestBusinessDiscoveryField () {
      return this.requestBusinessDiscoveryField(true);
    }
    public APIRequestGet requestBusinessDiscoveryField (boolean value) {
      this.requestField("business_discovery", value);
      return this;
    }
    public APIRequestGet requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGet requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGet requestFollowsCountField () {
      return this.requestFollowsCountField(true);
    }
    public APIRequestGet requestFollowsCountField (boolean value) {
      this.requestField("follows_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGet requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMentionedCommentField () {
      return this.requestMentionedCommentField(true);
    }
    public APIRequestGet requestMentionedCommentField (boolean value) {
      this.requestField("mentioned_comment", value);
      return this;
    }
    public APIRequestGet requestMentionedMediaField () {
      return this.requestMentionedMediaField(true);
    }
    public APIRequestGet requestMentionedMediaField (boolean value) {
      this.requestField("mentioned_media", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUrlField () {
      return this.requestProfilePictureUrlField(true);
    }
    public APIRequestGet requestProfilePictureUrlField (boolean value) {
      this.requestField("profile_picture_url", value);
      return this;
    }
    public APIRequestGet requestShoppingProductTagEligibilityField () {
      return this.requestShoppingProductTagEligibilityField(true);
    }
    public APIRequestGet requestShoppingProductTagEligibilityField (boolean value) {
      this.requestField("shopping_product_tag_eligibility", value);
      return this;
    }
    public APIRequestGet requestShoppingReviewStatusField () {
      return this.requestShoppingReviewStatusField(true);
    }
    public APIRequestGet requestShoppingReviewStatusField (boolean value) {
      this.requestField("shopping_review_status", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
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

  public IGUser copyFrom(IGUser instance) {
    this.mBiography = instance.mBiography;
    this.mBusinessDiscovery = instance.mBusinessDiscovery;
    this.mFollowersCount = instance.mFollowersCount;
    this.mFollowsCount = instance.mFollowsCount;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mMediaCount = instance.mMediaCount;
    this.mMentionedComment = instance.mMentionedComment;
    this.mMentionedMedia = instance.mMentionedMedia;
    this.mName = instance.mName;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mProfilePictureUrl = instance.mProfilePictureUrl;
    this.mShoppingProductTagEligibility = instance.mShoppingProductTagEligibility;
    this.mShoppingReviewStatus = instance.mShoppingReviewStatus;
    this.mUsername = instance.mUsername;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUser> getParser() {
    return new APIRequest.ResponseParser<IGUser>() {
      public APINodeList<IGUser> parseResponse(String response, APIContext context, APIRequest<IGUser> request, String header) throws MalformedResponseException {
        return IGUser.parseResponse(response, context, request, header);
      }
    };
  }
}
