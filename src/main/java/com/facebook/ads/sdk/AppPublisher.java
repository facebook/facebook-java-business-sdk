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
public class AppPublisher extends APINode {
  @SerializedName("content_id")
  private String mContentId = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("platform")
  private String mPlatform = null;
  @SerializedName("store_name")
  private String mStoreName = null;
  @SerializedName("store_url")
  private String mStoreUrl = null;
  protected static Gson gson = null;

  public AppPublisher() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AppPublisher loadJSON(String json, APIContext context, String header) {
    AppPublisher appPublisher = getGson().fromJson(json, AppPublisher.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(appPublisher.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    appPublisher.context = context;
    appPublisher.rawValue = json;
    appPublisher.header = header;
    return appPublisher;
  }

  public static APINodeList<AppPublisher> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AppPublisher> appPublishers = new APINodeList<AppPublisher>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          appPublishers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return appPublishers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                appPublishers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            appPublishers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              appPublishers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              appPublishers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  appPublishers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              appPublishers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return appPublishers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              appPublishers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return appPublishers;
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
              appPublishers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return appPublishers;
          }

          // Sixth, check if it's pure JsonObject
          appPublishers.clear();
          appPublishers.add(loadJSON(json, context, header));
          return appPublishers;
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


  public String getFieldContentId() {
    return mContentId;
  }

  public AppPublisher setFieldContentId(String value) {
    this.mContentId = value;
    return this;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public AppPublisher setFieldIconUrl(String value) {
    this.mIconUrl = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AppPublisher setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AppPublisher setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPlatform() {
    return mPlatform;
  }

  public AppPublisher setFieldPlatform(String value) {
    this.mPlatform = value;
    return this;
  }

  public String getFieldStoreName() {
    return mStoreName;
  }

  public AppPublisher setFieldStoreName(String value) {
    this.mStoreName = value;
    return this;
  }

  public String getFieldStoreUrl() {
    return mStoreUrl;
  }

  public AppPublisher setFieldStoreUrl(String value) {
    this.mStoreUrl = value;
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

  public AppPublisher copyFrom(AppPublisher instance) {
    this.mContentId = instance.mContentId;
    this.mIconUrl = instance.mIconUrl;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPlatform = instance.mPlatform;
    this.mStoreName = instance.mStoreName;
    this.mStoreUrl = instance.mStoreUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AppPublisher> getParser() {
    return new APIRequest.ResponseParser<AppPublisher>() {
      public APINodeList<AppPublisher> parseResponse(String response, APIContext context, APIRequest<AppPublisher> request, String header) throws MalformedResponseException {
        return AppPublisher.parseResponse(response, context, request, header);
      }
    };
  }
}
