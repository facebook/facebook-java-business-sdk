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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class ProfilePictureSource extends APINode {
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("is_silhouette")
  private Boolean mIsSilhouette = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("width")
  private Long mWidth = null;
  @SerializedName("left")
  private Long mLeft = null;
  @SerializedName("top")
  private Long mTop = null;
  @SerializedName("right")
  private Long mRight = null;
  @SerializedName("bottom")
  private Long mBottom = null;
  protected static Gson gson = null;

  public ProfilePictureSource() {
  }

  public String getId() {
    return null;
  }
  public static ProfilePictureSource loadJSON(String json, APIContext context) {
    ProfilePictureSource profilePictureSource = getGson().fromJson(json, ProfilePictureSource.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(profilePictureSource.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    profilePictureSource.mContext = context;
    profilePictureSource.rawValue = json;
    return profilePictureSource;
  }

  public static APINodeList<ProfilePictureSource> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProfilePictureSource> profilePictureSources = new APINodeList<ProfilePictureSource>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return profilePictureSources;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            profilePictureSources.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            profilePictureSources.add(loadJSON(obj.toString(), context));
          }
          return profilePictureSources;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              profilePictureSources.add(loadJSON(entry.getValue().toString(), context));
          }
          return profilePictureSources;
        } else {
          // Fifth, check if it's pure JsonObject
          profilePictureSources.add(loadJSON(json, context));
          return profilePictureSources;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
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

  public Long getFieldLeft() {
    return mLeft;
  }

  public ProfilePictureSource setFieldLeft(Long value) {
    this.mLeft = value;
    return this;
  }

  public Long getFieldTop() {
    return mTop;
  }

  public ProfilePictureSource setFieldTop(Long value) {
    this.mTop = value;
    return this;
  }

  public Long getFieldRight() {
    return mRight;
  }

  public ProfilePictureSource setFieldRight(Long value) {
    this.mRight = value;
    return this;
  }

  public Long getFieldBottom() {
    return mBottom;
  }

  public ProfilePictureSource setFieldBottom(Long value) {
    this.mBottom = value;
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

  public ProfilePictureSource copyFrom(ProfilePictureSource instance) {
    this.mHeight = instance.mHeight;
    this.mIsSilhouette = instance.mIsSilhouette;
    this.mUrl = instance.mUrl;
    this.mWidth = instance.mWidth;
    this.mLeft = instance.mLeft;
    this.mTop = instance.mTop;
    this.mRight = instance.mRight;
    this.mBottom = instance.mBottom;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProfilePictureSource> getParser() {
    return new APIRequest.ResponseParser<ProfilePictureSource>() {
      public APINodeList<ProfilePictureSource> parseResponse(String response, APIContext context, APIRequest<ProfilePictureSource> request) {
        return ProfilePictureSource.parseResponse(response, context, request);
      }
    };
  }
}