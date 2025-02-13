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
public class InstagramMedia extends APINode {
  @SerializedName("caption_text")
  private String mCaptionText = null;
  @SerializedName("comment_count")
  private Long mCommentCount = null;
  @SerializedName("content_type")
  private Long mContentType = null;
  @SerializedName("display_url")
  private String mDisplayUrl = null;
  @SerializedName("filter_name")
  private String mFilterName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_media_id")
  private String mIgMediaId = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("location")
  private Location mLocation = null;
  @SerializedName("location_name")
  private String mLocationName = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("owner_instagram_user")
  private InstagramUser mOwnerInstagramUser = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  @SerializedName("taken_at")
  private String mTakenAt = null;
  @SerializedName("video_url")
  private String mVideoUrl = null;
  protected static Gson gson = null;

  InstagramMedia() {
  }

  public InstagramMedia(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstagramMedia(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstagramMedia fetch() throws APIException{
    InstagramMedia newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstagramMedia fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstagramMedia> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstagramMedia fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstagramMedia> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstagramMedia> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstagramMedia>)(
      new APIRequest<InstagramMedia>(context, "", "/", "GET", InstagramMedia.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstagramMedia>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstagramMedia.getParser())
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
  public static InstagramMedia loadJSON(String json, APIContext context, String header) {
    InstagramMedia instagramMedia = getGson().fromJson(json, InstagramMedia.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramMedia.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramMedia.context = context;
    instagramMedia.rawValue = json;
    instagramMedia.header = header;
    return instagramMedia;
  }

  public static APINodeList<InstagramMedia> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramMedia> instagramMedias = new APINodeList<InstagramMedia>(request, json, header);
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
          instagramMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramMedias;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramMedias.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramMedias.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramMedias.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramMedias.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramMedias.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramMedias;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramMedias.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramMedias;
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
              instagramMedias.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramMedias;
          }

          // Sixth, check if it's pure JsonObject
          instagramMedias.clear();
          instagramMedias.add(loadJSON(json, context, header));
          return instagramMedias;
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


  public String getFieldCaptionText() {
    return mCaptionText;
  }

  public Long getFieldCommentCount() {
    return mCommentCount;
  }

  public Long getFieldContentType() {
    return mContentType;
  }

  public String getFieldDisplayUrl() {
    return mDisplayUrl;
  }

  public String getFieldFilterName() {
    return mFilterName;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIgMediaId() {
    return mIgMediaId;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public Location getFieldLocation() {
    return mLocation;
  }

  public String getFieldLocationName() {
    return mLocationName;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public InstagramUser getFieldOwnerInstagramUser() {
    if (mOwnerInstagramUser != null) {
      mOwnerInstagramUser.context = getContext();
    }
    return mOwnerInstagramUser;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public String getFieldTakenAt() {
    return mTakenAt;
  }

  public String getFieldVideoUrl() {
    return mVideoUrl;
  }



  public static class APIRequestGet extends APIRequest<InstagramMedia> {

    InstagramMedia lastResponse = null;
    @Override
    public InstagramMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption_text",
      "comment_count",
      "content_type",
      "display_url",
      "filter_name",
      "id",
      "ig_media_id",
      "latitude",
      "like_count",
      "location",
      "location_name",
      "longitude",
      "owner_instagram_user",
      "permalink",
      "taken_at",
      "video_url",
    };

    @Override
    public InstagramMedia parseResponse(String response, String header) throws APIException {
      return InstagramMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramMedia>() {
           public InstagramMedia apply(ResponseWrapper result) {
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

    public APIRequestGet requestCaptionTextField () {
      return this.requestCaptionTextField(true);
    }
    public APIRequestGet requestCaptionTextField (boolean value) {
      this.requestField("caption_text", value);
      return this;
    }
    public APIRequestGet requestCommentCountField () {
      return this.requestCommentCountField(true);
    }
    public APIRequestGet requestCommentCountField (boolean value) {
      this.requestField("comment_count", value);
      return this;
    }
    public APIRequestGet requestContentTypeField () {
      return this.requestContentTypeField(true);
    }
    public APIRequestGet requestContentTypeField (boolean value) {
      this.requestField("content_type", value);
      return this;
    }
    public APIRequestGet requestDisplayUrlField () {
      return this.requestDisplayUrlField(true);
    }
    public APIRequestGet requestDisplayUrlField (boolean value) {
      this.requestField("display_url", value);
      return this;
    }
    public APIRequestGet requestFilterNameField () {
      return this.requestFilterNameField(true);
    }
    public APIRequestGet requestFilterNameField (boolean value) {
      this.requestField("filter_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgMediaIdField () {
      return this.requestIgMediaIdField(true);
    }
    public APIRequestGet requestIgMediaIdField (boolean value) {
      this.requestField("ig_media_id", value);
      return this;
    }
    public APIRequestGet requestLatitudeField () {
      return this.requestLatitudeField(true);
    }
    public APIRequestGet requestLatitudeField (boolean value) {
      this.requestField("latitude", value);
      return this;
    }
    public APIRequestGet requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGet requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestLocationNameField () {
      return this.requestLocationNameField(true);
    }
    public APIRequestGet requestLocationNameField (boolean value) {
      this.requestField("location_name", value);
      return this;
    }
    public APIRequestGet requestLongitudeField () {
      return this.requestLongitudeField(true);
    }
    public APIRequestGet requestLongitudeField (boolean value) {
      this.requestField("longitude", value);
      return this;
    }
    public APIRequestGet requestOwnerInstagramUserField () {
      return this.requestOwnerInstagramUserField(true);
    }
    public APIRequestGet requestOwnerInstagramUserField (boolean value) {
      this.requestField("owner_instagram_user", value);
      return this;
    }
    public APIRequestGet requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGet requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGet requestTakenAtField () {
      return this.requestTakenAtField(true);
    }
    public APIRequestGet requestTakenAtField (boolean value) {
      this.requestField("taken_at", value);
      return this;
    }
    public APIRequestGet requestVideoUrlField () {
      return this.requestVideoUrlField(true);
    }
    public APIRequestGet requestVideoUrlField (boolean value) {
      this.requestField("video_url", value);
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

  public InstagramMedia copyFrom(InstagramMedia instance) {
    this.mCaptionText = instance.mCaptionText;
    this.mCommentCount = instance.mCommentCount;
    this.mContentType = instance.mContentType;
    this.mDisplayUrl = instance.mDisplayUrl;
    this.mFilterName = instance.mFilterName;
    this.mId = instance.mId;
    this.mIgMediaId = instance.mIgMediaId;
    this.mLatitude = instance.mLatitude;
    this.mLikeCount = instance.mLikeCount;
    this.mLocation = instance.mLocation;
    this.mLocationName = instance.mLocationName;
    this.mLongitude = instance.mLongitude;
    this.mOwnerInstagramUser = instance.mOwnerInstagramUser;
    this.mPermalink = instance.mPermalink;
    this.mTakenAt = instance.mTakenAt;
    this.mVideoUrl = instance.mVideoUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramMedia> getParser() {
    return new APIRequest.ResponseParser<InstagramMedia>() {
      public APINodeList<InstagramMedia> parseResponse(String response, APIContext context, APIRequest<InstagramMedia> request, String header) throws MalformedResponseException {
        return InstagramMedia.parseResponse(response, context, request, header);
      }
    };
  }
}
