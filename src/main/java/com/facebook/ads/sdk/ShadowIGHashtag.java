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
public class ShadowIGHashtag extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  ShadowIGHashtag() {
  }

  public ShadowIGHashtag(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ShadowIGHashtag(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ShadowIGHashtag fetch() throws APIException{
    ShadowIGHashtag newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ShadowIGHashtag fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ShadowIGHashtag> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ShadowIGHashtag fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ShadowIGHashtag> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ShadowIGHashtag> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ShadowIGHashtag>)(
      new APIRequest<ShadowIGHashtag>(context, "", "/", "GET", ShadowIGHashtag.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ShadowIGHashtag>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ShadowIGHashtag.getParser())
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
  public static ShadowIGHashtag loadJSON(String json, APIContext context, String header) {
    ShadowIGHashtag shadowIGHashtag = getGson().fromJson(json, ShadowIGHashtag.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGHashtag.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shadowIGHashtag.context = context;
    shadowIGHashtag.rawValue = json;
    shadowIGHashtag.header = header;
    return shadowIGHashtag;
  }

  public static APINodeList<ShadowIGHashtag> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ShadowIGHashtag> shadowIGHashtags = new APINodeList<ShadowIGHashtag>(request, json, header);
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
          shadowIGHashtags.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shadowIGHashtags;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGHashtags.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGHashtags.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGHashtags.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGHashtags.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shadowIGHashtags.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGHashtags.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shadowIGHashtags;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGHashtags.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shadowIGHashtags;
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
              shadowIGHashtags.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGHashtags;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGHashtags.clear();
          shadowIGHashtags.add(loadJSON(json, context, header));
          return shadowIGHashtags;
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

  public APIRequestGetRecentMedia getRecentMedia() {
    return new APIRequestGetRecentMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTopMedia getTopMedia() {
    return new APIRequestGetTopMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestGetRecentMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
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
               return APIRequestGetRecentMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRecentMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/recent_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentMedia setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetRecentMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRecentMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetRecentMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetRecentMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetRecentMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetRecentMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetRecentMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetRecentMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetRecentMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetRecentMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRecentMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRecentMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetRecentMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetRecentMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetRecentMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetRecentMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetRecentMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetRecentMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetRecentMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetRecentMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetRecentMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetRecentMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetRecentMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetRecentMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetRecentMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetRecentMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetRecentMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetRecentMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetRecentMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetRecentMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetRecentMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetRecentMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetRecentMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetRecentMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetRecentMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetRecentMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetRecentMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTopMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
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
               return APIRequestGetTopMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTopMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/top_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTopMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTopMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTopMedia setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetTopMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTopMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTopMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTopMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTopMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTopMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTopMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetTopMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetTopMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTopMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTopMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetTopMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetTopMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetTopMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetTopMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTopMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTopMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetTopMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetTopMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetTopMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetTopMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetTopMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetTopMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetTopMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetTopMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetTopMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetTopMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetTopMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetTopMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetTopMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetTopMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetTopMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetTopMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetTopMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetTopMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetTopMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetTopMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetTopMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetTopMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetTopMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetTopMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTopMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<ShadowIGHashtag> {

    ShadowIGHashtag lastResponse = null;
    @Override
    public ShadowIGHashtag getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
    };

    @Override
    public ShadowIGHashtag parseResponse(String response, String header) throws APIException {
      return ShadowIGHashtag.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ShadowIGHashtag execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGHashtag execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ShadowIGHashtag> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGHashtag> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ShadowIGHashtag>() {
           public ShadowIGHashtag apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
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

  public ShadowIGHashtag copyFrom(ShadowIGHashtag instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGHashtag> getParser() {
    return new APIRequest.ResponseParser<ShadowIGHashtag>() {
      public APINodeList<ShadowIGHashtag> parseResponse(String response, APIContext context, APIRequest<ShadowIGHashtag> request, String header) throws MalformedResponseException {
        return ShadowIGHashtag.parseResponse(response, context, request, header);
      }
    };
  }
}
