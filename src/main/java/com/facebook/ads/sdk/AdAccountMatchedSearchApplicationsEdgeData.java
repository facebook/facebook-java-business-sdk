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
public class AdAccountMatchedSearchApplicationsEdgeData extends APINode {
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("are_app_events_unavailable")
  private Boolean mAreAppEventsUnavailable = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("search_source_store")
  private String mSearchSourceStore = null;
  @SerializedName("store")
  private String mStore = null;
  @SerializedName("unique_id")
  private String mUniqueId = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  public AdAccountMatchedSearchApplicationsEdgeData() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountMatchedSearchApplicationsEdgeData loadJSON(String json, APIContext context, String header) {
    AdAccountMatchedSearchApplicationsEdgeData adAccountMatchedSearchApplicationsEdgeData = getGson().fromJson(json, AdAccountMatchedSearchApplicationsEdgeData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountMatchedSearchApplicationsEdgeData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountMatchedSearchApplicationsEdgeData.context = context;
    adAccountMatchedSearchApplicationsEdgeData.rawValue = json;
    adAccountMatchedSearchApplicationsEdgeData.header = header;
    return adAccountMatchedSearchApplicationsEdgeData;
  }

  public static APINodeList<AdAccountMatchedSearchApplicationsEdgeData> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountMatchedSearchApplicationsEdgeData> adAccountMatchedSearchApplicationsEdgeDatas = new APINodeList<AdAccountMatchedSearchApplicationsEdgeData>(request, json, header);
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
          adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountMatchedSearchApplicationsEdgeDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountMatchedSearchApplicationsEdgeDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountMatchedSearchApplicationsEdgeDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountMatchedSearchApplicationsEdgeDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountMatchedSearchApplicationsEdgeDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountMatchedSearchApplicationsEdgeDatas;
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
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountMatchedSearchApplicationsEdgeDatas;
          }

          // Sixth, check if it's pure JsonObject
          adAccountMatchedSearchApplicationsEdgeDatas.clear();
          adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(json, context, header));
          return adAccountMatchedSearchApplicationsEdgeDatas;
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

  public AdAccountMatchedSearchApplicationsEdgeData setFieldAppId(String value) {
    this.mAppId = value;
    return this;
  }

  public Boolean getFieldAreAppEventsUnavailable() {
    return mAreAppEventsUnavailable;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldAreAppEventsUnavailable(Boolean value) {
    this.mAreAppEventsUnavailable = value;
    return this;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldIconUrl(String value) {
    this.mIconUrl = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldSearchSourceStore() {
    return mSearchSourceStore;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldSearchSourceStore(String value) {
    this.mSearchSourceStore = value;
    return this;
  }

  public String getFieldStore() {
    return mStore;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldStore(String value) {
    this.mStore = value;
    return this;
  }

  public String getFieldUniqueId() {
    return mUniqueId;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldUniqueId(String value) {
    this.mUniqueId = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public AdAccountMatchedSearchApplicationsEdgeData setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }



  public static enum EnumAppStore {
      @SerializedName("AMAZON_APP_STORE")
      VALUE_AMAZON_APP_STORE("AMAZON_APP_STORE"),
      @SerializedName("APK_MIRROR")
      VALUE_APK_MIRROR("APK_MIRROR"),
      @SerializedName("APK_MONK")
      VALUE_APK_MONK("APK_MONK"),
      @SerializedName("APK_PURE")
      VALUE_APK_PURE("APK_PURE"),
      @SerializedName("APTOIDE_A1_STORE")
      VALUE_APTOIDE_A1_STORE("APTOIDE_A1_STORE"),
      @SerializedName("BEMOBI_MOBILE_STORE")
      VALUE_BEMOBI_MOBILE_STORE("BEMOBI_MOBILE_STORE"),
      @SerializedName("DIGITAL_TURBINE_STORE")
      VALUE_DIGITAL_TURBINE_STORE("DIGITAL_TURBINE_STORE"),
      @SerializedName("DOES_NOT_EXIST")
      VALUE_DOES_NOT_EXIST("DOES_NOT_EXIST"),
      @SerializedName("FB_ANDROID_STORE")
      VALUE_FB_ANDROID_STORE("FB_ANDROID_STORE"),
      @SerializedName("FB_CANVAS")
      VALUE_FB_CANVAS("FB_CANVAS"),
      @SerializedName("FB_GAMEROOM")
      VALUE_FB_GAMEROOM("FB_GAMEROOM"),
      @SerializedName("GALAXY_STORE")
      VALUE_GALAXY_STORE("GALAXY_STORE"),
      @SerializedName("GOOGLE_PLAY")
      VALUE_GOOGLE_PLAY("GOOGLE_PLAY"),
      @SerializedName("INSTANT_GAME")
      VALUE_INSTANT_GAME("INSTANT_GAME"),
      @SerializedName("ITUNES")
      VALUE_ITUNES("ITUNES"),
      @SerializedName("ITUNES_IPAD")
      VALUE_ITUNES_IPAD("ITUNES_IPAD"),
      @SerializedName("NEON_ANDROID_STORE")
      VALUE_NEON_ANDROID_STORE("NEON_ANDROID_STORE"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OCULUS_APP_STORE")
      VALUE_OCULUS_APP_STORE("OCULUS_APP_STORE"),
      @SerializedName("OPPO")
      VALUE_OPPO("OPPO"),
      @SerializedName("ROKU_STORE")
      VALUE_ROKU_STORE("ROKU_STORE"),
      @SerializedName("UPTODOWN")
      VALUE_UPTODOWN("UPTODOWN"),
      @SerializedName("VIVO")
      VALUE_VIVO("VIVO"),
      @SerializedName("WINDOWS_10_STORE")
      VALUE_WINDOWS_10_STORE("WINDOWS_10_STORE"),
      @SerializedName("WINDOWS_STORE")
      VALUE_WINDOWS_STORE("WINDOWS_STORE"),
      @SerializedName("XIAOMI")
      VALUE_XIAOMI("XIAOMI"),
      ;

      private String value;

      private EnumAppStore(String value) {
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

  public AdAccountMatchedSearchApplicationsEdgeData copyFrom(AdAccountMatchedSearchApplicationsEdgeData instance) {
    this.mAppId = instance.mAppId;
    this.mAreAppEventsUnavailable = instance.mAreAppEventsUnavailable;
    this.mIconUrl = instance.mIconUrl;
    this.mName = instance.mName;
    this.mSearchSourceStore = instance.mSearchSourceStore;
    this.mStore = instance.mStore;
    this.mUniqueId = instance.mUniqueId;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountMatchedSearchApplicationsEdgeData> getParser() {
    return new APIRequest.ResponseParser<AdAccountMatchedSearchApplicationsEdgeData>() {
      public APINodeList<AdAccountMatchedSearchApplicationsEdgeData> parseResponse(String response, APIContext context, APIRequest<AdAccountMatchedSearchApplicationsEdgeData> request, String header) throws MalformedResponseException {
        return AdAccountMatchedSearchApplicationsEdgeData.parseResponse(response, context, request, header);
      }
    };
  }
}
