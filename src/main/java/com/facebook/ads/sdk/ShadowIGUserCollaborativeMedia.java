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
public class ShadowIGUserCollaborativeMedia extends APINode {
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("comments_count")
  private Long mCommentsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("media_product_type")
  private String mMediaProductType = null;
  @SerializedName("media_type")
  private String mMediaType = null;
  @SerializedName("media_url")
  private String mMediaUrl = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  @SerializedName("reposts_count")
  private Long mRepostsCount = null;
  @SerializedName("saved_count")
  private Long mSavedCount = null;
  @SerializedName("shares_count")
  private Long mSharesCount = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("total_comments_count")
  private Long mTotalCommentsCount = null;
  @SerializedName("total_like_count")
  private Long mTotalLikeCount = null;
  @SerializedName("total_views_count")
  private Long mTotalViewsCount = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  public ShadowIGUserCollaborativeMedia() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ShadowIGUserCollaborativeMedia loadJSON(String json, APIContext context, String header) {
    ShadowIGUserCollaborativeMedia shadowIGUserCollaborativeMedia = getGson().fromJson(json, ShadowIGUserCollaborativeMedia.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGUserCollaborativeMedia.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shadowIGUserCollaborativeMedia.context = context;
    shadowIGUserCollaborativeMedia.rawValue = json;
    shadowIGUserCollaborativeMedia.header = header;
    return shadowIGUserCollaborativeMedia;
  }

  public static APINodeList<ShadowIGUserCollaborativeMedia> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ShadowIGUserCollaborativeMedia> shadowIGUserCollaborativeMedias = new APINodeList<ShadowIGUserCollaborativeMedia>(request, json, header);
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
          shadowIGUserCollaborativeMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shadowIGUserCollaborativeMedias;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGUserCollaborativeMedias.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGUserCollaborativeMedias.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGUserCollaborativeMedias.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGUserCollaborativeMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shadowIGUserCollaborativeMedias.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGUserCollaborativeMedias.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shadowIGUserCollaborativeMedias;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGUserCollaborativeMedias.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shadowIGUserCollaborativeMedias;
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
              shadowIGUserCollaborativeMedias.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGUserCollaborativeMedias;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGUserCollaborativeMedias.clear();
          shadowIGUserCollaborativeMedias.add(loadJSON(json, context, header));
          return shadowIGUserCollaborativeMedias;
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


  public String getFieldCaption() {
    return mCaption;
  }

  public ShadowIGUserCollaborativeMedia setFieldCaption(String value) {
    this.mCaption = value;
    return this;
  }

  public Long getFieldCommentsCount() {
    return mCommentsCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldCommentsCount(Long value) {
    this.mCommentsCount = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public ShadowIGUserCollaborativeMedia setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldLikeCount(Long value) {
    this.mLikeCount = value;
    return this;
  }

  public String getFieldMediaProductType() {
    return mMediaProductType;
  }

  public ShadowIGUserCollaborativeMedia setFieldMediaProductType(String value) {
    this.mMediaProductType = value;
    return this;
  }

  public String getFieldMediaType() {
    return mMediaType;
  }

  public ShadowIGUserCollaborativeMedia setFieldMediaType(String value) {
    this.mMediaType = value;
    return this;
  }

  public String getFieldMediaUrl() {
    return mMediaUrl;
  }

  public ShadowIGUserCollaborativeMedia setFieldMediaUrl(String value) {
    this.mMediaUrl = value;
    return this;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public ShadowIGUserCollaborativeMedia setFieldPermalink(String value) {
    this.mPermalink = value;
    return this;
  }

  public Long getFieldRepostsCount() {
    return mRepostsCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldRepostsCount(Long value) {
    this.mRepostsCount = value;
    return this;
  }

  public Long getFieldSavedCount() {
    return mSavedCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldSavedCount(Long value) {
    this.mSavedCount = value;
    return this;
  }

  public Long getFieldSharesCount() {
    return mSharesCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldSharesCount(Long value) {
    this.mSharesCount = value;
    return this;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public ShadowIGUserCollaborativeMedia setFieldThumbnailUrl(String value) {
    this.mThumbnailUrl = value;
    return this;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public ShadowIGUserCollaborativeMedia setFieldTimestamp(String value) {
    this.mTimestamp = value;
    return this;
  }

  public Long getFieldTotalCommentsCount() {
    return mTotalCommentsCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldTotalCommentsCount(Long value) {
    this.mTotalCommentsCount = value;
    return this;
  }

  public Long getFieldTotalLikeCount() {
    return mTotalLikeCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldTotalLikeCount(Long value) {
    this.mTotalLikeCount = value;
    return this;
  }

  public Long getFieldTotalViewsCount() {
    return mTotalViewsCount;
  }

  public ShadowIGUserCollaborativeMedia setFieldTotalViewsCount(Long value) {
    this.mTotalViewsCount = value;
    return this;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public ShadowIGUserCollaborativeMedia setFieldUsername(String value) {
    this.mUsername = value;
    return this;
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

  public ShadowIGUserCollaborativeMedia copyFrom(ShadowIGUserCollaborativeMedia instance) {
    this.mCaption = instance.mCaption;
    this.mCommentsCount = instance.mCommentsCount;
    this.mId = instance.mId;
    this.mLikeCount = instance.mLikeCount;
    this.mMediaProductType = instance.mMediaProductType;
    this.mMediaType = instance.mMediaType;
    this.mMediaUrl = instance.mMediaUrl;
    this.mPermalink = instance.mPermalink;
    this.mRepostsCount = instance.mRepostsCount;
    this.mSavedCount = instance.mSavedCount;
    this.mSharesCount = instance.mSharesCount;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTimestamp = instance.mTimestamp;
    this.mTotalCommentsCount = instance.mTotalCommentsCount;
    this.mTotalLikeCount = instance.mTotalLikeCount;
    this.mTotalViewsCount = instance.mTotalViewsCount;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGUserCollaborativeMedia> getParser() {
    return new APIRequest.ResponseParser<ShadowIGUserCollaborativeMedia>() {
      public APINodeList<ShadowIGUserCollaborativeMedia> parseResponse(String response, APIContext context, APIRequest<ShadowIGUserCollaborativeMedia> request, String header) throws MalformedResponseException {
        return ShadowIGUserCollaborativeMedia.parseResponse(response, context, request, header);
      }
    };
  }
}
