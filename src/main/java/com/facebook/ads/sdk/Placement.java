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
public class Placement extends APINode {
  @SerializedName("audience_network_positions")
  private List<String> mAudienceNetworkPositions = null;
  @SerializedName("device_platforms")
  private List<EnumDevicePlatforms> mDevicePlatforms = null;
  @SerializedName("effective_audience_network_positions")
  private List<String> mEffectiveAudienceNetworkPositions = null;
  @SerializedName("effective_device_platforms")
  private List<EnumEffectiveDevicePlatforms> mEffectiveDevicePlatforms = null;
  @SerializedName("effective_facebook_positions")
  private List<String> mEffectiveFacebookPositions = null;
  @SerializedName("effective_instagram_positions")
  private List<String> mEffectiveInstagramPositions = null;
  @SerializedName("effective_messenger_positions")
  private List<String> mEffectiveMessengerPositions = null;
  @SerializedName("effective_oculus_positions")
  private List<String> mEffectiveOculusPositions = null;
  @SerializedName("effective_publisher_platforms")
  private List<String> mEffectivePublisherPlatforms = null;
  @SerializedName("effective_threads_positions")
  private List<String> mEffectiveThreadsPositions = null;
  @SerializedName("effective_whatsapp_positions")
  private List<String> mEffectiveWhatsappPositions = null;
  @SerializedName("facebook_positions")
  private List<String> mFacebookPositions = null;
  @SerializedName("instagram_positions")
  private List<String> mInstagramPositions = null;
  @SerializedName("messenger_positions")
  private List<String> mMessengerPositions = null;
  @SerializedName("oculus_positions")
  private List<String> mOculusPositions = null;
  @SerializedName("publisher_platforms")
  private List<String> mPublisherPlatforms = null;
  @SerializedName("threads_positions")
  private List<String> mThreadsPositions = null;
  @SerializedName("whatsapp_positions")
  private List<String> mWhatsappPositions = null;
  protected static Gson gson = null;

  public Placement() {
  }

  public String getId() {
    return null;
  }
  public static Placement loadJSON(String json, APIContext context, String header) {
    Placement placement = getGson().fromJson(json, Placement.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(placement.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    placement.context = context;
    placement.rawValue = json;
    placement.header = header;
    return placement;
  }

  public static APINodeList<Placement> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Placement> placements = new APINodeList<Placement>(request, json, header);
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
          placements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return placements;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                placements.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            placements.setPaging(previous, next);
            if (context.hasAppSecret()) {
              placements.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              placements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  placements.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              placements.add(loadJSON(obj.toString(), context, header));
            }
          }
          return placements;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              placements.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return placements;
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
              placements.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return placements;
          }

          // Sixth, check if it's pure JsonObject
          placements.clear();
          placements.add(loadJSON(json, context, header));
          return placements;
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


  public List<String> getFieldAudienceNetworkPositions() {
    return mAudienceNetworkPositions;
  }

  public Placement setFieldAudienceNetworkPositions(List<String> value) {
    this.mAudienceNetworkPositions = value;
    return this;
  }

  public List<EnumDevicePlatforms> getFieldDevicePlatforms() {
    return mDevicePlatforms;
  }

  public Placement setFieldDevicePlatforms(List<EnumDevicePlatforms> value) {
    this.mDevicePlatforms = value;
    return this;
  }

  public List<String> getFieldEffectiveAudienceNetworkPositions() {
    return mEffectiveAudienceNetworkPositions;
  }

  public Placement setFieldEffectiveAudienceNetworkPositions(List<String> value) {
    this.mEffectiveAudienceNetworkPositions = value;
    return this;
  }

  public List<EnumEffectiveDevicePlatforms> getFieldEffectiveDevicePlatforms() {
    return mEffectiveDevicePlatforms;
  }

  public Placement setFieldEffectiveDevicePlatforms(List<EnumEffectiveDevicePlatforms> value) {
    this.mEffectiveDevicePlatforms = value;
    return this;
  }

  public List<String> getFieldEffectiveFacebookPositions() {
    return mEffectiveFacebookPositions;
  }

  public Placement setFieldEffectiveFacebookPositions(List<String> value) {
    this.mEffectiveFacebookPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveInstagramPositions() {
    return mEffectiveInstagramPositions;
  }

  public Placement setFieldEffectiveInstagramPositions(List<String> value) {
    this.mEffectiveInstagramPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveMessengerPositions() {
    return mEffectiveMessengerPositions;
  }

  public Placement setFieldEffectiveMessengerPositions(List<String> value) {
    this.mEffectiveMessengerPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveOculusPositions() {
    return mEffectiveOculusPositions;
  }

  public Placement setFieldEffectiveOculusPositions(List<String> value) {
    this.mEffectiveOculusPositions = value;
    return this;
  }

  public List<String> getFieldEffectivePublisherPlatforms() {
    return mEffectivePublisherPlatforms;
  }

  public Placement setFieldEffectivePublisherPlatforms(List<String> value) {
    this.mEffectivePublisherPlatforms = value;
    return this;
  }

  public List<String> getFieldEffectiveThreadsPositions() {
    return mEffectiveThreadsPositions;
  }

  public Placement setFieldEffectiveThreadsPositions(List<String> value) {
    this.mEffectiveThreadsPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveWhatsappPositions() {
    return mEffectiveWhatsappPositions;
  }

  public Placement setFieldEffectiveWhatsappPositions(List<String> value) {
    this.mEffectiveWhatsappPositions = value;
    return this;
  }

  public List<String> getFieldFacebookPositions() {
    return mFacebookPositions;
  }

  public Placement setFieldFacebookPositions(List<String> value) {
    this.mFacebookPositions = value;
    return this;
  }

  public List<String> getFieldInstagramPositions() {
    return mInstagramPositions;
  }

  public Placement setFieldInstagramPositions(List<String> value) {
    this.mInstagramPositions = value;
    return this;
  }

  public List<String> getFieldMessengerPositions() {
    return mMessengerPositions;
  }

  public Placement setFieldMessengerPositions(List<String> value) {
    this.mMessengerPositions = value;
    return this;
  }

  public List<String> getFieldOculusPositions() {
    return mOculusPositions;
  }

  public Placement setFieldOculusPositions(List<String> value) {
    this.mOculusPositions = value;
    return this;
  }

  public List<String> getFieldPublisherPlatforms() {
    return mPublisherPlatforms;
  }

  public Placement setFieldPublisherPlatforms(List<String> value) {
    this.mPublisherPlatforms = value;
    return this;
  }

  public List<String> getFieldThreadsPositions() {
    return mThreadsPositions;
  }

  public Placement setFieldThreadsPositions(List<String> value) {
    this.mThreadsPositions = value;
    return this;
  }

  public List<String> getFieldWhatsappPositions() {
    return mWhatsappPositions;
  }

  public Placement setFieldWhatsappPositions(List<String> value) {
    this.mWhatsappPositions = value;
    return this;
  }



  public static enum EnumDevicePlatforms {
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("mobile")
      VALUE_MOBILE("mobile"),
      ;

      private String value;

      private EnumDevicePlatforms(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveDevicePlatforms {
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("mobile")
      VALUE_MOBILE("mobile"),
      ;

      private String value;

      private EnumEffectiveDevicePlatforms(String value) {
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

  public Placement copyFrom(Placement instance) {
    this.mAudienceNetworkPositions = instance.mAudienceNetworkPositions;
    this.mDevicePlatforms = instance.mDevicePlatforms;
    this.mEffectiveAudienceNetworkPositions = instance.mEffectiveAudienceNetworkPositions;
    this.mEffectiveDevicePlatforms = instance.mEffectiveDevicePlatforms;
    this.mEffectiveFacebookPositions = instance.mEffectiveFacebookPositions;
    this.mEffectiveInstagramPositions = instance.mEffectiveInstagramPositions;
    this.mEffectiveMessengerPositions = instance.mEffectiveMessengerPositions;
    this.mEffectiveOculusPositions = instance.mEffectiveOculusPositions;
    this.mEffectivePublisherPlatforms = instance.mEffectivePublisherPlatforms;
    this.mEffectiveThreadsPositions = instance.mEffectiveThreadsPositions;
    this.mEffectiveWhatsappPositions = instance.mEffectiveWhatsappPositions;
    this.mFacebookPositions = instance.mFacebookPositions;
    this.mInstagramPositions = instance.mInstagramPositions;
    this.mMessengerPositions = instance.mMessengerPositions;
    this.mOculusPositions = instance.mOculusPositions;
    this.mPublisherPlatforms = instance.mPublisherPlatforms;
    this.mThreadsPositions = instance.mThreadsPositions;
    this.mWhatsappPositions = instance.mWhatsappPositions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Placement> getParser() {
    return new APIRequest.ResponseParser<Placement>() {
      public APINodeList<Placement> parseResponse(String response, APIContext context, APIRequest<Placement> request, String header) throws MalformedResponseException {
        return Placement.parseResponse(response, context, request, header);
      }
    };
  }
}
