/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
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
public class VideoThumbnail extends APINode {
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_preferred")
  private Boolean mIsPreferred = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("scale")
  private Double mScale = null;
  @SerializedName("uri")
  private String mUri = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  public VideoThumbnail() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static VideoThumbnail loadJSON(String json, APIContext context) {
    VideoThumbnail videoThumbnail = getGson().fromJson(json, VideoThumbnail.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoThumbnail.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    videoThumbnail.context = context;
    videoThumbnail.rawValue = json;
    return videoThumbnail;
  }

  public static APINodeList<VideoThumbnail> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<VideoThumbnail> videoThumbnails = new APINodeList<VideoThumbnail>(request, json);
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
          videoThumbnails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return videoThumbnails;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoThumbnails.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoThumbnails.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoThumbnails.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoThumbnails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  videoThumbnails.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoThumbnails.add(loadJSON(obj.toString(), context));
            }
          }
          return videoThumbnails;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoThumbnails.add(loadJSON(entry.getValue().toString(), context));
          }
          return videoThumbnails;
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
              videoThumbnails.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoThumbnails;
          }

          // Sixth, check if it's pure JsonObject
          videoThumbnails.clear();
          videoThumbnails.add(loadJSON(json, context));
          return videoThumbnails;
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


  public Long getFieldHeight() {
    return mHeight;
  }

  public VideoThumbnail setFieldHeight(Long value) {
    this.mHeight = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public VideoThumbnail setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsPreferred() {
    return mIsPreferred;
  }

  public VideoThumbnail setFieldIsPreferred(Boolean value) {
    this.mIsPreferred = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public VideoThumbnail setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Double getFieldScale() {
    return mScale;
  }

  public VideoThumbnail setFieldScale(Double value) {
    this.mScale = value;
    return this;
  }

  public String getFieldUri() {
    return mUri;
  }

  public VideoThumbnail setFieldUri(String value) {
    this.mUri = value;
    return this;
  }

  public Long getFieldWidth() {
    return mWidth;
  }

  public VideoThumbnail setFieldWidth(Long value) {
    this.mWidth = value;
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

  public VideoThumbnail copyFrom(VideoThumbnail instance) {
    this.mHeight = instance.mHeight;
    this.mId = instance.mId;
    this.mIsPreferred = instance.mIsPreferred;
    this.mName = instance.mName;
    this.mScale = instance.mScale;
    this.mUri = instance.mUri;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoThumbnail> getParser() {
    return new APIRequest.ResponseParser<VideoThumbnail>() {
      public APINodeList<VideoThumbnail> parseResponse(String response, APIContext context, APIRequest<VideoThumbnail> request) throws MalformedResponseException {
        return VideoThumbnail.parseResponse(response, context, request);
      }
    };
  }
}
