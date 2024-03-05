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
public class ProfilePictureSource extends APINode {
  @SerializedName("bottom")
  private Long mBottom = null;
  @SerializedName("cache_key")
  private String mCacheKey = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("is_silhouette")
  private Boolean mIsSilhouette = null;
  @SerializedName("left")
  private Long mLeft = null;
  @SerializedName("right")
  private Long mRight = null;
  @SerializedName("top")
  private Long mTop = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  public ProfilePictureSource() {
  }

  public String getId() {
    return null;
  }
  public static ProfilePictureSource loadJSON(String json, APIContext context, String header) {
    ProfilePictureSource profilePictureSource = getGson().fromJson(json, ProfilePictureSource.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(profilePictureSource.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    profilePictureSource.context = context;
    profilePictureSource.rawValue = json;
    profilePictureSource.header = header;
    return profilePictureSource;
  }

  public static APINodeList<ProfilePictureSource> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProfilePictureSource> profilePictureSources = new APINodeList<ProfilePictureSource>(request, json, header);
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
          profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return profilePictureSources;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                profilePictureSources.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            profilePictureSources.setPaging(previous, next);
            if (context.hasAppSecret()) {
              profilePictureSources.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  profilePictureSources.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              profilePictureSources.add(loadJSON(obj.toString(), context, header));
            }
          }
          return profilePictureSources;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              profilePictureSources.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return profilePictureSources;
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
              profilePictureSources.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return profilePictureSources;
          }

          // Sixth, check if it's pure JsonObject
          profilePictureSources.clear();
          profilePictureSources.add(loadJSON(json, context, header));
          return profilePictureSources;
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


  public Long getFieldBottom() {
    return mBottom;
  }

  public ProfilePictureSource setFieldBottom(Long value) {
    this.mBottom = value;
    return this;
  }

  public String getFieldCacheKey() {
    return mCacheKey;
  }

  public ProfilePictureSource setFieldCacheKey(String value) {
    this.mCacheKey = value;
    return this;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public ProfilePictureSource setFieldHeight(Long value) {
    this.mHeight = value;
    return this;
  }

  public Boolean getFieldIsSilhouette() {
    return mIsSilhouette;
  }

  public ProfilePictureSource setFieldIsSilhouette(Boolean value) {
    this.mIsSilhouette = value;
    return this;
  }

  public Long getFieldLeft() {
    return mLeft;
  }

  public ProfilePictureSource setFieldLeft(Long value) {
    this.mLeft = value;
    return this;
  }

  public Long getFieldRight() {
    return mRight;
  }

  public ProfilePictureSource setFieldRight(Long value) {
    this.mRight = value;
    return this;
  }

  public Long getFieldTop() {
    return mTop;
  }

  public ProfilePictureSource setFieldTop(Long value) {
    this.mTop = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public ProfilePictureSource setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public Long getFieldWidth() {
    return mWidth;
  }

  public ProfilePictureSource setFieldWidth(Long value) {
    this.mWidth = value;
    return this;
  }



  public static enum EnumType {
      @SerializedName("album")
      VALUE_ALBUM("album"),
      @SerializedName("small")
      VALUE_SMALL("small"),
      @SerializedName("thumbnail")
      VALUE_THUMBNAIL("thumbnail"),
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

  public ProfilePictureSource copyFrom(ProfilePictureSource instance) {
    this.mBottom = instance.mBottom;
    this.mCacheKey = instance.mCacheKey;
    this.mHeight = instance.mHeight;
    this.mIsSilhouette = instance.mIsSilhouette;
    this.mLeft = instance.mLeft;
    this.mRight = instance.mRight;
    this.mTop = instance.mTop;
    this.mUrl = instance.mUrl;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProfilePictureSource> getParser() {
    return new APIRequest.ResponseParser<ProfilePictureSource>() {
      public APINodeList<ProfilePictureSource> parseResponse(String response, APIContext context, APIRequest<ProfilePictureSource> request, String header) throws MalformedResponseException {
        return ProfilePictureSource.parseResponse(response, context, request, header);
      }
    };
  }
}
