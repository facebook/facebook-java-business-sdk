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
public class IGMedia extends APINode {
  @SerializedName("boost_eligibility_info")
  private IGMediaBoostEligibilityInfo mBoostEligibilityInfo = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("comments_count")
  private Long mCommentsCount = null;
  @SerializedName("copyright_check_information")
  private IGVideoCopyrightCheckMatchesInformation mCopyrightCheckInformation = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private String mIgId = null;
  @SerializedName("is_comment_enabled")
  private Boolean mIsCommentEnabled = null;
  @SerializedName("is_shared_to_feed")
  private Boolean mIsSharedToFeed = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("media_product_type")
  private String mMediaProductType = null;
  @SerializedName("media_type")
  private String mMediaType = null;
  @SerializedName("media_url")
  private String mMediaUrl = null;
  @SerializedName("owner")
  private IGUser mOwner = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  @SerializedName("shortcode")
  private String mShortcode = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  IGMedia() {
  }

  public IGMedia(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGMedia(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGMedia fetch() throws APIException{
    IGMedia newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGMedia fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGMedia> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGMedia fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGMedia> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGMedia> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGMedia>)(
      new APIRequest<IGMedia>(context, "", "/", "GET", IGMedia.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGMedia>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGMedia.getParser())
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
  public static IGMedia loadJSON(String json, APIContext context, String header) {
    IGMedia igMedia = getGson().fromJson(json, IGMedia.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igMedia.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igMedia.context = context;
    igMedia.rawValue = json;
    igMedia.header = header;
    return igMedia;
  }

  public static APINodeList<IGMedia> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGMedia> igMedias = new APINodeList<IGMedia>(request, json, header);
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
          igMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igMedias;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igMedias.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igMedias.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igMedias.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igMedias.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igMedias.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igMedias;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igMedias.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igMedias;
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
              igMedias.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igMedias;
          }

          // Sixth, check if it's pure JsonObject
          igMedias.clear();
          igMedias.add(loadJSON(json, context, header));
          return igMedias;
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

  public APIRequestGetBoostAdsList getBoostAdsList() {
    return new APIRequestGetBoostAdsList(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentPartnerPromote getBrandedContentPartnerPromote() {
    return new APIRequestGetBrandedContentPartnerPromote(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBrandedContentPartnerPromote createBrandedContentPartnerPromote() {
    return new APIRequestCreateBrandedContentPartnerPromote(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetChildren getChildren() {
    return new APIRequestGetChildren(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCollaborators getCollaborators() {
    return new APIRequestGetCollaborators(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteProductTags deleteProductTags() {
    return new APIRequestDeleteProductTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductTags getProductTags() {
    return new APIRequestGetProductTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductTag createProductTag() {
    return new APIRequestCreateProductTag(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public IGMediaBoostEligibilityInfo getFieldBoostEligibilityInfo() {
    if (mBoostEligibilityInfo != null) {
      mBoostEligibilityInfo.context = getContext();
    }
    return mBoostEligibilityInfo;
  }

  public String getFieldCaption() {
    return mCaption;
  }

  public Long getFieldCommentsCount() {
    return mCommentsCount;
  }

  public IGVideoCopyrightCheckMatchesInformation getFieldCopyrightCheckInformation() {
    return mCopyrightCheckInformation;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIgId() {
    return mIgId;
  }

  public Boolean getFieldIsCommentEnabled() {
    return mIsCommentEnabled;
  }

  public Boolean getFieldIsSharedToFeed() {
    return mIsSharedToFeed;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public String getFieldMediaProductType() {
    return mMediaProductType;
  }

  public String getFieldMediaType() {
    return mMediaType;
  }

  public String getFieldMediaUrl() {
    return mMediaUrl;
  }

  public IGUser getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public String getFieldShortcode() {
    return mShortcode;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetBoostAdsList extends APIRequest<IGBoostMediaAd> {

    APINodeList<IGBoostMediaAd> lastResponse = null;
    @Override
    public APINodeList<IGBoostMediaAd> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_status",
      "id",
    };

    @Override
    public APINodeList<IGBoostMediaAd> parseResponse(String response, String header) throws APIException {
      return IGBoostMediaAd.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGBoostMediaAd> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGBoostMediaAd> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGBoostMediaAd>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGBoostMediaAd>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGBoostMediaAd>>() {
           public APINodeList<IGBoostMediaAd> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBoostAdsList.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBoostAdsList(String nodeId, APIContext context) {
      super(context, nodeId, "/boost_ads_list", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBoostAdsList setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBoostAdsList setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBoostAdsList requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBoostAdsList requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBoostAdsList requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBoostAdsList requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBoostAdsList requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBoostAdsList requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBoostAdsList requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetBoostAdsList requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetBoostAdsList requestAdStatusField () {
      return this.requestAdStatusField(true);
    }
    public APIRequestGetBoostAdsList requestAdStatusField (boolean value) {
      this.requestField("ad_status", value);
      return this;
    }
    public APIRequestGetBoostAdsList requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBoostAdsList requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetBrandedContentPartnerPromote extends APIRequest<BrandedContentShadowIGUserID> {

    APINodeList<BrandedContentShadowIGUserID> lastResponse = null;
    @Override
    public APINodeList<BrandedContentShadowIGUserID> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetBrandedContentPartnerPromote.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentPartnerPromote(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_partner_promote", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentPartnerPromote requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentPartnerPromote requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentPartnerPromote requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentPartnerPromote requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentPartnerPromote requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateBrandedContentPartnerPromote extends APIRequest<BrandedContentShadowIGUserID> {

    BrandedContentShadowIGUserID lastResponse = null;
    @Override
    public BrandedContentShadowIGUserID getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "permission",
      "sponsor_id",
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
               return APIRequestCreateBrandedContentPartnerPromote.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBrandedContentPartnerPromote(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_partner_promote", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBrandedContentPartnerPromote setPermission (Boolean permission) {
      this.setParam("permission", permission);
      return this;
    }
    public APIRequestCreateBrandedContentPartnerPromote setPermission (String permission) {
      this.setParam("permission", permission);
      return this;
    }

    public APIRequestCreateBrandedContentPartnerPromote setSponsorId (Long sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }
    public APIRequestCreateBrandedContentPartnerPromote setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreateBrandedContentPartnerPromote requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBrandedContentPartnerPromote requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentPartnerPromote requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetChildren extends APIRequest<IGMedia> {

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
               return APIRequestGetChildren.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetChildren(String nodeId, APIContext context) {
      super(context, nodeId, "/children", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChildren setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChildren setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChildren requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChildren requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChildren requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChildren requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChildren requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChildren requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChildren requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetChildren requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetChildren requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetChildren requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetChildren requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetChildren requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetChildren requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetChildren requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetChildren requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetChildren requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetChildren requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetChildren requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetChildren requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetChildren requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetChildren requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetChildren requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetChildren requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetChildren requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetChildren requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetChildren requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetChildren requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetChildren requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetChildren requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetChildren requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetChildren requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetChildren requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetChildren requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetChildren requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetChildren requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetChildren requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetChildren requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetChildren requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetChildren requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetChildren requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetChildren requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetChildren requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetCollaborators extends APIRequest<ShadowIGMediaCollaborators> {

    APINodeList<ShadowIGMediaCollaborators> lastResponse = null;
    @Override
    public APINodeList<ShadowIGMediaCollaborators> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "invite_status",
      "username",
    };

    @Override
    public APINodeList<ShadowIGMediaCollaborators> parseResponse(String response, String header) throws APIException {
      return ShadowIGMediaCollaborators.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGMediaCollaborators> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGMediaCollaborators> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGMediaCollaborators>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGMediaCollaborators>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGMediaCollaborators>>() {
           public APINodeList<ShadowIGMediaCollaborators> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCollaborators.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCollaborators(String nodeId, APIContext context) {
      super(context, nodeId, "/collaborators", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCollaborators setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCollaborators setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCollaborators requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCollaborators requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborators requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCollaborators requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborators requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCollaborators requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCollaborators requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCollaborators requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCollaborators requestInviteStatusField () {
      return this.requestInviteStatusField(true);
    }
    public APIRequestGetCollaborators requestInviteStatusField (boolean value) {
      this.requestField("invite_status", value);
      return this;
    }
    public APIRequestGetCollaborators requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetCollaborators requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetComments extends APIRequest<IGComment> {

    APINodeList<IGComment> lastResponse = null;
    @Override
    public APINodeList<IGComment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "from",
      "hidden",
      "id",
      "like_count",
      "media",
      "parent_id",
      "text",
      "timestamp",
      "user",
      "username",
    };

    @Override
    public APINodeList<IGComment> parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGComment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGComment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGComment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGComment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGComment>>() {
           public APINodeList<IGComment> apply(ResponseWrapper result) {
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

    public APIRequestGetComments requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetComments requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetComments requestHiddenField () {
      return this.requestHiddenField(true);
    }
    public APIRequestGetComments requestHiddenField (boolean value) {
      this.requestField("hidden", value);
      return this;
    }
    public APIRequestGetComments requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetComments requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetComments requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetComments requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetComments requestMediaField () {
      return this.requestMediaField(true);
    }
    public APIRequestGetComments requestMediaField (boolean value) {
      this.requestField("media", value);
      return this;
    }
    public APIRequestGetComments requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetComments requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetComments requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGetComments requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
    public APIRequestGetComments requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetComments requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetComments requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGetComments requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGetComments requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetComments requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateComment extends APIRequest<IGComment> {

    IGComment lastResponse = null;
    @Override
    public IGComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGComment parseResponse(String response, String header) throws APIException {
      return IGComment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGComment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGComment>() {
           public IGComment apply(ResponseWrapper result) {
             try {
               return APIRequestCreateComment.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
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

  public static class APIRequestGetInsights extends APIRequest<InstagramInsightsResult> {

    APINodeList<InstagramInsightsResult> lastResponse = null;
    @Override
    public APINodeList<InstagramInsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "period",
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

    public APIRequestGetInsights setPeriod (List<InstagramInsightsResult.EnumPeriod> period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
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

  public static class APIRequestDeleteProductTags extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_index",
      "deleted_tags",
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
               return APIRequestDeleteProductTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteProductTags(String nodeId, APIContext context) {
      super(context, nodeId, "/product_tags", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteProductTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteProductTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteProductTags setChildIndex (Long childIndex) {
      this.setParam("child_index", childIndex);
      return this;
    }
    public APIRequestDeleteProductTags setChildIndex (String childIndex) {
      this.setParam("child_index", childIndex);
      return this;
    }

    public APIRequestDeleteProductTags setDeletedTags (List<Map<String, String>> deletedTags) {
      this.setParam("deleted_tags", deletedTags);
      return this;
    }
    public APIRequestDeleteProductTags setDeletedTags (String deletedTags) {
      this.setParam("deleted_tags", deletedTags);
      return this;
    }

    public APIRequestDeleteProductTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteProductTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteProductTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteProductTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteProductTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteProductTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductTags extends APIRequest<ShadowIGMediaProductTags> {

    APINodeList<ShadowIGMediaProductTags> lastResponse = null;
    @Override
    public APINodeList<ShadowIGMediaProductTags> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "image_url",
      "is_checkout",
      "merchant_id",
      "name",
      "price_string",
      "product_id",
      "review_status",
      "stripped_price_string",
      "stripped_sale_price_string",
      "x",
      "y",
    };

    @Override
    public APINodeList<ShadowIGMediaProductTags> parseResponse(String response, String header) throws APIException {
      return ShadowIGMediaProductTags.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGMediaProductTags> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGMediaProductTags> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGMediaProductTags>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGMediaProductTags>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGMediaProductTags>>() {
           public APINodeList<ShadowIGMediaProductTags> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProductTags(String nodeId, APIContext context) {
      super(context, nodeId, "/product_tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductTags requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetProductTags requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetProductTags requestIsCheckoutField () {
      return this.requestIsCheckoutField(true);
    }
    public APIRequestGetProductTags requestIsCheckoutField (boolean value) {
      this.requestField("is_checkout", value);
      return this;
    }
    public APIRequestGetProductTags requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetProductTags requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetProductTags requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductTags requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductTags requestPriceStringField () {
      return this.requestPriceStringField(true);
    }
    public APIRequestGetProductTags requestPriceStringField (boolean value) {
      this.requestField("price_string", value);
      return this;
    }
    public APIRequestGetProductTags requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetProductTags requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetProductTags requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetProductTags requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGetProductTags requestStrippedPriceStringField () {
      return this.requestStrippedPriceStringField(true);
    }
    public APIRequestGetProductTags requestStrippedPriceStringField (boolean value) {
      this.requestField("stripped_price_string", value);
      return this;
    }
    public APIRequestGetProductTags requestStrippedSalePriceStringField () {
      return this.requestStrippedSalePriceStringField(true);
    }
    public APIRequestGetProductTags requestStrippedSalePriceStringField (boolean value) {
      this.requestField("stripped_sale_price_string", value);
      return this;
    }
    public APIRequestGetProductTags requestXField () {
      return this.requestXField(true);
    }
    public APIRequestGetProductTags requestXField (boolean value) {
      this.requestField("x", value);
      return this;
    }
    public APIRequestGetProductTags requestYField () {
      return this.requestYField(true);
    }
    public APIRequestGetProductTags requestYField (boolean value) {
      this.requestField("y", value);
      return this;
    }
  }

  public static class APIRequestCreateProductTag extends APIRequest<ShadowIGMediaProductTags> {

    ShadowIGMediaProductTags lastResponse = null;
    @Override
    public ShadowIGMediaProductTags getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_index",
      "updated_tags",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ShadowIGMediaProductTags parseResponse(String response, String header) throws APIException {
      return ShadowIGMediaProductTags.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ShadowIGMediaProductTags execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGMediaProductTags execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ShadowIGMediaProductTags> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGMediaProductTags> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ShadowIGMediaProductTags>() {
           public ShadowIGMediaProductTags apply(ResponseWrapper result) {
             try {
               return APIRequestCreateProductTag.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateProductTag(String nodeId, APIContext context) {
      super(context, nodeId, "/product_tags", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductTag setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductTag setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductTag setChildIndex (Long childIndex) {
      this.setParam("child_index", childIndex);
      return this;
    }
    public APIRequestCreateProductTag setChildIndex (String childIndex) {
      this.setParam("child_index", childIndex);
      return this;
    }

    public APIRequestCreateProductTag setUpdatedTags (List<Map<String, String>> updatedTags) {
      this.setParam("updated_tags", updatedTags);
      return this;
    }
    public APIRequestCreateProductTag setUpdatedTags (String updatedTags) {
      this.setParam("updated_tags", updatedTags);
      return this;
    }

    public APIRequestCreateProductTag requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductTag requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductTag requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductTag requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductTag requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductTag requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "primary_fb_page_id",
      "primary_ig_user_id",
      "secondary_fb_page_id",
      "secondary_ig_user_id",
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


    public APIRequestGet setPrimaryFbPageId (String primaryFbPageId) {
      this.setParam("primary_fb_page_id", primaryFbPageId);
      return this;
    }

    public APIRequestGet setPrimaryIgUserId (String primaryIgUserId) {
      this.setParam("primary_ig_user_id", primaryIgUserId);
      return this;
    }

    public APIRequestGet setSecondaryFbPageId (String secondaryFbPageId) {
      this.setParam("secondary_fb_page_id", secondaryFbPageId);
      return this;
    }

    public APIRequestGet setSecondaryIgUserId (String secondaryIgUserId) {
      this.setParam("secondary_ig_user_id", secondaryIgUserId);
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

    public APIRequestGet requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGet requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGet requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGet requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGet requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
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
    public APIRequestGet requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGet requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGet requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGet requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGet requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGet requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGet requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGet requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGet requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGet requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGet requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGet requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGet requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGet requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGet requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
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

  public static class APIRequestUpdate extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_enabled",
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
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestUpdate setCommentEnabled (Boolean commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
      return this;
    }
    public APIRequestUpdate setCommentEnabled (String commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
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

  public IGMedia copyFrom(IGMedia instance) {
    this.mBoostEligibilityInfo = instance.mBoostEligibilityInfo;
    this.mCaption = instance.mCaption;
    this.mCommentsCount = instance.mCommentsCount;
    this.mCopyrightCheckInformation = instance.mCopyrightCheckInformation;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mIsCommentEnabled = instance.mIsCommentEnabled;
    this.mIsSharedToFeed = instance.mIsSharedToFeed;
    this.mLikeCount = instance.mLikeCount;
    this.mMediaProductType = instance.mMediaProductType;
    this.mMediaType = instance.mMediaType;
    this.mMediaUrl = instance.mMediaUrl;
    this.mOwner = instance.mOwner;
    this.mPermalink = instance.mPermalink;
    this.mShortcode = instance.mShortcode;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTimestamp = instance.mTimestamp;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGMedia> getParser() {
    return new APIRequest.ResponseParser<IGMedia>() {
      public APINodeList<IGMedia> parseResponse(String response, APIContext context, APIRequest<IGMedia> request, String header) throws MalformedResponseException {
        return IGMedia.parseResponse(response, context, request, header);
      }
    };
  }
}
