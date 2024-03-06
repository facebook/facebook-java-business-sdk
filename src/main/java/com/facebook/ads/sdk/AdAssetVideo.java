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
public class AdAssetVideo extends APINode {
  @SerializedName("caption_ids")
  private List<String> mCaptionIds = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("source_image_url")
  private String mSourceImageUrl = null;
  @SerializedName("tag")
  private String mTag = null;
  @SerializedName("thumbnail_hash")
  private String mThumbnailHash = null;
  @SerializedName("thumbnail_source")
  private String mThumbnailSource = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("video_name")
  private String mVideoName = null;
  protected static Gson gson = null;

  public AdAssetVideo() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAssetVideo loadJSON(String json, APIContext context, String header) {
    AdAssetVideo adAssetVideo = getGson().fromJson(json, AdAssetVideo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetVideo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAssetVideo.context = context;
    adAssetVideo.rawValue = json;
    adAssetVideo.header = header;
    return adAssetVideo;
  }

  public static APINodeList<AdAssetVideo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAssetVideo> adAssetVideos = new APINodeList<AdAssetVideo>(request, json, header);
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
          adAssetVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAssetVideos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetVideos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetVideos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetVideos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAssetVideos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetVideos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAssetVideos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetVideos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAssetVideos;
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
              adAssetVideos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetVideos;
          }

          // Sixth, check if it's pure JsonObject
          adAssetVideos.clear();
          adAssetVideos.add(loadJSON(json, context, header));
          return adAssetVideos;
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


  public List<String> getFieldCaptionIds() {
    return mCaptionIds;
  }

  public AdAssetVideo setFieldCaptionIds(List<String> value) {
    this.mCaptionIds = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdAssetVideo setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldSourceImageUrl() {
    return mSourceImageUrl;
  }

  public AdAssetVideo setFieldSourceImageUrl(String value) {
    this.mSourceImageUrl = value;
    return this;
  }

  public String getFieldTag() {
    return mTag;
  }

  public AdAssetVideo setFieldTag(String value) {
    this.mTag = value;
    return this;
  }

  public String getFieldThumbnailHash() {
    return mThumbnailHash;
  }

  public AdAssetVideo setFieldThumbnailHash(String value) {
    this.mThumbnailHash = value;
    return this;
  }

  public String getFieldThumbnailSource() {
    return mThumbnailSource;
  }

  public AdAssetVideo setFieldThumbnailSource(String value) {
    this.mThumbnailSource = value;
    return this;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public AdAssetVideo setFieldThumbnailUrl(String value) {
    this.mThumbnailUrl = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public AdAssetVideo setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public AdAssetVideo setFieldUrlTags(String value) {
    this.mUrlTags = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdAssetVideo setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
  }

  public String getFieldVideoName() {
    return mVideoName;
  }

  public AdAssetVideo setFieldVideoName(String value) {
    this.mVideoName = value;
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

  public AdAssetVideo copyFrom(AdAssetVideo instance) {
    this.mCaptionIds = instance.mCaptionIds;
    this.mId = instance.mId;
    this.mSourceImageUrl = instance.mSourceImageUrl;
    this.mTag = instance.mTag;
    this.mThumbnailHash = instance.mThumbnailHash;
    this.mThumbnailSource = instance.mThumbnailSource;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mUrl = instance.mUrl;
    this.mUrlTags = instance.mUrlTags;
    this.mVideoId = instance.mVideoId;
    this.mVideoName = instance.mVideoName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetVideo> getParser() {
    return new APIRequest.ResponseParser<AdAssetVideo>() {
      public APINodeList<AdAssetVideo> parseResponse(String response, APIContext context, APIRequest<AdAssetVideo> request, String header) throws MalformedResponseException {
        return AdAssetVideo.parseResponse(response, context, request, header);
      }
    };
  }
}
