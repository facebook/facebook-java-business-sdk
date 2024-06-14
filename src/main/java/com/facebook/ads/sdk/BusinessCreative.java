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
public class BusinessCreative extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("duration")
  private Long mDuration = null;
  @SerializedName("hash")
  private String mHash = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("thumbnail")
  private String mThumbnail = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  public BusinessCreative() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BusinessCreative loadJSON(String json, APIContext context, String header) {
    BusinessCreative businessCreative = getGson().fromJson(json, BusinessCreative.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessCreative.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessCreative.context = context;
    businessCreative.rawValue = json;
    businessCreative.header = header;
    return businessCreative;
  }

  public static APINodeList<BusinessCreative> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessCreative> businessCreatives = new APINodeList<BusinessCreative>(request, json, header);
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
          businessCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessCreatives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessCreatives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessCreatives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessCreatives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessCreatives.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessCreatives.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessCreatives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessCreatives.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessCreatives;
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
              businessCreatives.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessCreatives;
          }

          // Sixth, check if it's pure JsonObject
          businessCreatives.clear();
          businessCreatives.add(loadJSON(json, context, header));
          return businessCreatives;
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

  public BusinessCreative setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public Long getFieldDuration() {
    return mDuration;
  }

  public BusinessCreative setFieldDuration(Long value) {
    this.mDuration = value;
    return this;
  }

  public String getFieldHash() {
    return mHash;
  }

  public BusinessCreative setFieldHash(String value) {
    this.mHash = value;
    return this;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public BusinessCreative setFieldHeight(Long value) {
    this.mHeight = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public BusinessCreative setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public BusinessCreative setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public BusinessCreative setFieldThumbnail(String value) {
    this.mThumbnail = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public BusinessCreative setFieldType(String value) {
    this.mType = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public BusinessCreative setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public BusinessCreative setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
  }

  public Long getFieldWidth() {
    return mWidth;
  }

  public BusinessCreative setFieldWidth(Long value) {
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

  public BusinessCreative copyFrom(BusinessCreative instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mDuration = instance.mDuration;
    this.mHash = instance.mHash;
    this.mHeight = instance.mHeight;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mThumbnail = instance.mThumbnail;
    this.mType = instance.mType;
    this.mUrl = instance.mUrl;
    this.mVideoId = instance.mVideoId;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessCreative> getParser() {
    return new APIRequest.ResponseParser<BusinessCreative>() {
      public APINodeList<BusinessCreative> parseResponse(String response, APIContext context, APIRequest<BusinessCreative> request, String header) throws MalformedResponseException {
        return BusinessCreative.parseResponse(response, context, request, header);
      }
    };
  }
}
