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
public class VideoStatusPublishingPhase extends APINode {
  @SerializedName("errors")
  private List<VideoStatusError> mErrors = null;
  @SerializedName("publish_status")
  private String mPublishStatus = null;
  @SerializedName("publish_time")
  private String mPublishTime = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  public VideoStatusPublishingPhase() {
  }

  public String getId() {
    return null;
  }
  public static VideoStatusPublishingPhase loadJSON(String json, APIContext context, String header) {
    VideoStatusPublishingPhase videoStatusPublishingPhase = getGson().fromJson(json, VideoStatusPublishingPhase.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoStatusPublishingPhase.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoStatusPublishingPhase.context = context;
    videoStatusPublishingPhase.rawValue = json;
    videoStatusPublishingPhase.header = header;
    return videoStatusPublishingPhase;
  }

  public static APINodeList<VideoStatusPublishingPhase> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoStatusPublishingPhase> videoStatusPublishingPhases = new APINodeList<VideoStatusPublishingPhase>(request, json, header);
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
          videoStatusPublishingPhases.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoStatusPublishingPhases;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoStatusPublishingPhases.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoStatusPublishingPhases.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoStatusPublishingPhases.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoStatusPublishingPhases.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoStatusPublishingPhases.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoStatusPublishingPhases.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoStatusPublishingPhases;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoStatusPublishingPhases.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoStatusPublishingPhases;
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
              videoStatusPublishingPhases.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoStatusPublishingPhases;
          }

          // Sixth, check if it's pure JsonObject
          videoStatusPublishingPhases.clear();
          videoStatusPublishingPhases.add(loadJSON(json, context, header));
          return videoStatusPublishingPhases;
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


  public List<VideoStatusError> getFieldErrors() {
    return mErrors;
  }

  public VideoStatusPublishingPhase setFieldErrors(List<VideoStatusError> value) {
    this.mErrors = value;
    return this;
  }

  public VideoStatusPublishingPhase setFieldErrors(String value) {
    Type type = new TypeToken<List<VideoStatusError>>(){}.getType();
    this.mErrors = VideoStatusError.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPublishStatus() {
    return mPublishStatus;
  }

  public VideoStatusPublishingPhase setFieldPublishStatus(String value) {
    this.mPublishStatus = value;
    return this;
  }

  public String getFieldPublishTime() {
    return mPublishTime;
  }

  public VideoStatusPublishingPhase setFieldPublishTime(String value) {
    this.mPublishTime = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public VideoStatusPublishingPhase setFieldStatus(String value) {
    this.mStatus = value;
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

  public VideoStatusPublishingPhase copyFrom(VideoStatusPublishingPhase instance) {
    this.mErrors = instance.mErrors;
    this.mPublishStatus = instance.mPublishStatus;
    this.mPublishTime = instance.mPublishTime;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoStatusPublishingPhase> getParser() {
    return new APIRequest.ResponseParser<VideoStatusPublishingPhase>() {
      public APINodeList<VideoStatusPublishingPhase> parseResponse(String response, APIContext context, APIRequest<VideoStatusPublishingPhase> request, String header) throws MalformedResponseException {
        return VideoStatusPublishingPhase.parseResponse(response, context, request, header);
      }
    };
  }
}
