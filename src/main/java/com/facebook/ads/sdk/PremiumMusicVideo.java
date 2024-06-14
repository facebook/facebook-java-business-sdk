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
public class PremiumMusicVideo extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("cross_post_videos")
  private List<Object> mCrossPostVideos = null;
  @SerializedName("eligible_cross_post_pages")
  private List<Object> mEligibleCrossPostPages = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("preferred_video_thumbnail_image_uri")
  private String mPreferredVideoThumbnailImageUri = null;
  @SerializedName("premium_music_video_metadata")
  private Object mPremiumMusicVideoMetadata = null;
  @SerializedName("scheduled_publish_time")
  private Long mScheduledPublishTime = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  public PremiumMusicVideo() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PremiumMusicVideo loadJSON(String json, APIContext context, String header) {
    PremiumMusicVideo premiumMusicVideo = getGson().fromJson(json, PremiumMusicVideo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(premiumMusicVideo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    premiumMusicVideo.context = context;
    premiumMusicVideo.rawValue = json;
    premiumMusicVideo.header = header;
    return premiumMusicVideo;
  }

  public static APINodeList<PremiumMusicVideo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PremiumMusicVideo> premiumMusicVideos = new APINodeList<PremiumMusicVideo>(request, json, header);
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
          premiumMusicVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return premiumMusicVideos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                premiumMusicVideos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            premiumMusicVideos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              premiumMusicVideos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              premiumMusicVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  premiumMusicVideos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              premiumMusicVideos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return premiumMusicVideos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              premiumMusicVideos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return premiumMusicVideos;
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
              premiumMusicVideos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return premiumMusicVideos;
          }

          // Sixth, check if it's pure JsonObject
          premiumMusicVideos.clear();
          premiumMusicVideos.add(loadJSON(json, context, header));
          return premiumMusicVideos;
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


  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public PremiumMusicVideo setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public List<Object> getFieldCrossPostVideos() {
    return mCrossPostVideos;
  }

  public PremiumMusicVideo setFieldCrossPostVideos(List<Object> value) {
    this.mCrossPostVideos = value;
    return this;
  }

  public List<Object> getFieldEligibleCrossPostPages() {
    return mEligibleCrossPostPages;
  }

  public PremiumMusicVideo setFieldEligibleCrossPostPages(List<Object> value) {
    this.mEligibleCrossPostPages = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public PremiumMusicVideo setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldPreferredVideoThumbnailImageUri() {
    return mPreferredVideoThumbnailImageUri;
  }

  public PremiumMusicVideo setFieldPreferredVideoThumbnailImageUri(String value) {
    this.mPreferredVideoThumbnailImageUri = value;
    return this;
  }

  public Object getFieldPremiumMusicVideoMetadata() {
    return mPremiumMusicVideoMetadata;
  }

  public PremiumMusicVideo setFieldPremiumMusicVideoMetadata(Object value) {
    this.mPremiumMusicVideoMetadata = value;
    return this;
  }

  public Long getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public PremiumMusicVideo setFieldScheduledPublishTime(Long value) {
    this.mScheduledPublishTime = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public PremiumMusicVideo setFieldTitle(String value) {
    this.mTitle = value;
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

  public PremiumMusicVideo copyFrom(PremiumMusicVideo instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mCrossPostVideos = instance.mCrossPostVideos;
    this.mEligibleCrossPostPages = instance.mEligibleCrossPostPages;
    this.mId = instance.mId;
    this.mPreferredVideoThumbnailImageUri = instance.mPreferredVideoThumbnailImageUri;
    this.mPremiumMusicVideoMetadata = instance.mPremiumMusicVideoMetadata;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PremiumMusicVideo> getParser() {
    return new APIRequest.ResponseParser<PremiumMusicVideo>() {
      public APINodeList<PremiumMusicVideo> parseResponse(String response, APIContext context, APIRequest<PremiumMusicVideo> request, String header) throws MalformedResponseException {
        return PremiumMusicVideo.parseResponse(response, context, request, header);
      }
    };
  }
}
