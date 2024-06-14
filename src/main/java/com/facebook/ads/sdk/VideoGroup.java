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
public class VideoGroup extends APINode {
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("disable_reason")
  private String mDisableReason = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_profile_ids")
  private List<String> mIgProfileIds = null;
  @SerializedName("is_disabled")
  private Boolean mIsDisabled = null;
  @SerializedName("is_fb_video_group")
  private Boolean mIsFbVideoGroup = null;
  @SerializedName("last_used_time")
  private String mLastUsedTime = null;
  @SerializedName("length")
  private Double mLength = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("page_ids")
  private List<String> mPageIds = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("placements")
  private List<String> mPlacements = null;
  @SerializedName("video_group_types")
  private List<String> mVideoGroupTypes = null;
  @SerializedName("videos")
  private List<String> mVideos = null;
  @SerializedName("views")
  private Long mViews = null;
  protected static Gson gson = null;

  public VideoGroup() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static VideoGroup loadJSON(String json, APIContext context, String header) {
    VideoGroup videoGroup = getGson().fromJson(json, VideoGroup.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoGroup.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoGroup.context = context;
    videoGroup.rawValue = json;
    videoGroup.header = header;
    return videoGroup;
  }

  public static APINodeList<VideoGroup> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoGroup> videoGroups = new APINodeList<VideoGroup>(request, json, header);
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
          videoGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoGroups;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoGroups.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoGroups.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoGroups.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoGroups.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoGroups.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoGroups;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoGroups.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoGroups;
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
              videoGroups.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoGroups;
          }

          // Sixth, check if it's pure JsonObject
          videoGroups.clear();
          videoGroups.add(loadJSON(json, context, header));
          return videoGroups;
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


  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public VideoGroup setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public VideoGroup setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldDisableReason() {
    return mDisableReason;
  }

  public VideoGroup setFieldDisableReason(String value) {
    this.mDisableReason = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public VideoGroup setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public List<String> getFieldIgProfileIds() {
    return mIgProfileIds;
  }

  public VideoGroup setFieldIgProfileIds(List<String> value) {
    this.mIgProfileIds = value;
    return this;
  }

  public Boolean getFieldIsDisabled() {
    return mIsDisabled;
  }

  public VideoGroup setFieldIsDisabled(Boolean value) {
    this.mIsDisabled = value;
    return this;
  }

  public Boolean getFieldIsFbVideoGroup() {
    return mIsFbVideoGroup;
  }

  public VideoGroup setFieldIsFbVideoGroup(Boolean value) {
    this.mIsFbVideoGroup = value;
    return this;
  }

  public String getFieldLastUsedTime() {
    return mLastUsedTime;
  }

  public VideoGroup setFieldLastUsedTime(String value) {
    this.mLastUsedTime = value;
    return this;
  }

  public Double getFieldLength() {
    return mLength;
  }

  public VideoGroup setFieldLength(Double value) {
    this.mLength = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public VideoGroup setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public VideoGroup setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public List<String> getFieldPageIds() {
    return mPageIds;
  }

  public VideoGroup setFieldPageIds(List<String> value) {
    this.mPageIds = value;
    return this;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public VideoGroup setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public List<String> getFieldPlacements() {
    return mPlacements;
  }

  public VideoGroup setFieldPlacements(List<String> value) {
    this.mPlacements = value;
    return this;
  }

  public List<String> getFieldVideoGroupTypes() {
    return mVideoGroupTypes;
  }

  public VideoGroup setFieldVideoGroupTypes(List<String> value) {
    this.mVideoGroupTypes = value;
    return this;
  }

  public List<String> getFieldVideos() {
    return mVideos;
  }

  public VideoGroup setFieldVideos(List<String> value) {
    this.mVideos = value;
    return this;
  }

  public Long getFieldViews() {
    return mViews;
  }

  public VideoGroup setFieldViews(Long value) {
    this.mViews = value;
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

  public VideoGroup copyFrom(VideoGroup instance) {
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mDisableReason = instance.mDisableReason;
    this.mId = instance.mId;
    this.mIgProfileIds = instance.mIgProfileIds;
    this.mIsDisabled = instance.mIsDisabled;
    this.mIsFbVideoGroup = instance.mIsFbVideoGroup;
    this.mLastUsedTime = instance.mLastUsedTime;
    this.mLength = instance.mLength;
    this.mName = instance.mName;
    this.mPageId = instance.mPageId;
    this.mPageIds = instance.mPageIds;
    this.mPicture = instance.mPicture;
    this.mPlacements = instance.mPlacements;
    this.mVideoGroupTypes = instance.mVideoGroupTypes;
    this.mVideos = instance.mVideos;
    this.mViews = instance.mViews;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoGroup> getParser() {
    return new APIRequest.ResponseParser<VideoGroup>() {
      public APINodeList<VideoGroup> parseResponse(String response, APIContext context, APIRequest<VideoGroup> request, String header) throws MalformedResponseException {
        return VideoGroup.parseResponse(response, context, request, header);
      }
    };
  }
}
