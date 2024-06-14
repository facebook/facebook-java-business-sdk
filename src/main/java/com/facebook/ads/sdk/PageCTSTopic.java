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
public class PageCTSTopic extends APINode {
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("frequency")
  private String mFrequency = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("subscriber")
  private Long mSubscriber = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  public PageCTSTopic() {
  }

  public String getId() {
    return null;
  }
  public static PageCTSTopic loadJSON(String json, APIContext context, String header) {
    PageCTSTopic pageCTSTopic = getGson().fromJson(json, PageCTSTopic.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageCTSTopic.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageCTSTopic.context = context;
    pageCTSTopic.rawValue = json;
    pageCTSTopic.header = header;
    return pageCTSTopic;
  }

  public static APINodeList<PageCTSTopic> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageCTSTopic> pageCTSTopics = new APINodeList<PageCTSTopic>(request, json, header);
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
          pageCTSTopics.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageCTSTopics;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageCTSTopics.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageCTSTopics.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageCTSTopics.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageCTSTopics.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageCTSTopics.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageCTSTopics.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageCTSTopics;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageCTSTopics.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageCTSTopics;
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
              pageCTSTopics.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageCTSTopics;
          }

          // Sixth, check if it's pure JsonObject
          pageCTSTopics.clear();
          pageCTSTopics.add(loadJSON(json, context, header));
          return pageCTSTopics;
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


  public String getFieldAppId() {
    return mAppId;
  }

  public PageCTSTopic setFieldAppId(String value) {
    this.mAppId = value;
    return this;
  }

  public String getFieldFrequency() {
    return mFrequency;
  }

  public PageCTSTopic setFieldFrequency(String value) {
    this.mFrequency = value;
    return this;
  }

  public String getFieldImageHash() {
    return mImageHash;
  }

  public PageCTSTopic setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public PageCTSTopic setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public Long getFieldSubscriber() {
    return mSubscriber;
  }

  public PageCTSTopic setFieldSubscriber(Long value) {
    this.mSubscriber = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public PageCTSTopic setFieldTitle(String value) {
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

  public PageCTSTopic copyFrom(PageCTSTopic instance) {
    this.mAppId = instance.mAppId;
    this.mFrequency = instance.mFrequency;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mSubscriber = instance.mSubscriber;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageCTSTopic> getParser() {
    return new APIRequest.ResponseParser<PageCTSTopic>() {
      public APINodeList<PageCTSTopic> parseResponse(String response, APIContext context, APIRequest<PageCTSTopic> request, String header) throws MalformedResponseException {
        return PageCTSTopic.parseResponse(response, context, request, header);
      }
    };
  }
}
