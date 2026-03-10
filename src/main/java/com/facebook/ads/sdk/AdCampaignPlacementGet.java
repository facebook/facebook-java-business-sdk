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
public class AdCampaignPlacementGet extends APINode {
  @SerializedName("effective_audience_network_positions")
  private List<EnumEffectiveAudienceNetworkPositions> mEffectiveAudienceNetworkPositions = null;
  @SerializedName("effective_device_platforms")
  private List<EnumEffectiveDevicePlatforms> mEffectiveDevicePlatforms = null;
  @SerializedName("effective_facebook_positions")
  private List<EnumEffectiveFacebookPositions> mEffectiveFacebookPositions = null;
  @SerializedName("effective_instagram_positions")
  private List<EnumEffectiveInstagramPositions> mEffectiveInstagramPositions = null;
  @SerializedName("effective_messenger_positions")
  private List<EnumEffectiveMessengerPositions> mEffectiveMessengerPositions = null;
  @SerializedName("effective_oculus_positions")
  private List<EnumEffectiveOculusPositions> mEffectiveOculusPositions = null;
  @SerializedName("effective_publisher_platforms")
  private List<EnumEffectivePublisherPlatforms> mEffectivePublisherPlatforms = null;
  @SerializedName("metadata")
  private Object mMetadata = null;
  @SerializedName("recommendations")
  private List<Object> mRecommendations = null;
  protected static Gson gson = null;

  public AdCampaignPlacementGet() {
  }

  public String getId() {
    return null;
  }
  public static AdCampaignPlacementGet loadJSON(String json, APIContext context, String header) {
    AdCampaignPlacementGet adCampaignPlacementGet = getGson().fromJson(json, AdCampaignPlacementGet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignPlacementGet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignPlacementGet.context = context;
    adCampaignPlacementGet.rawValue = json;
    adCampaignPlacementGet.header = header;
    return adCampaignPlacementGet;
  }

  public static APINodeList<AdCampaignPlacementGet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignPlacementGet> adCampaignPlacementGets = new APINodeList<AdCampaignPlacementGet>(request, json, header);
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
          adCampaignPlacementGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignPlacementGets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignPlacementGets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignPlacementGets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignPlacementGets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignPlacementGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignPlacementGets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignPlacementGets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignPlacementGets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignPlacementGets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignPlacementGets;
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
              adCampaignPlacementGets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignPlacementGets;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignPlacementGets.clear();
          adCampaignPlacementGets.add(loadJSON(json, context, header));
          return adCampaignPlacementGets;
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


  public List<EnumEffectiveAudienceNetworkPositions> getFieldEffectiveAudienceNetworkPositions() {
    return mEffectiveAudienceNetworkPositions;
  }

  public AdCampaignPlacementGet setFieldEffectiveAudienceNetworkPositions(List<EnumEffectiveAudienceNetworkPositions> value) {
    this.mEffectiveAudienceNetworkPositions = value;
    return this;
  }

  public List<EnumEffectiveDevicePlatforms> getFieldEffectiveDevicePlatforms() {
    return mEffectiveDevicePlatforms;
  }

  public AdCampaignPlacementGet setFieldEffectiveDevicePlatforms(List<EnumEffectiveDevicePlatforms> value) {
    this.mEffectiveDevicePlatforms = value;
    return this;
  }

  public List<EnumEffectiveFacebookPositions> getFieldEffectiveFacebookPositions() {
    return mEffectiveFacebookPositions;
  }

  public AdCampaignPlacementGet setFieldEffectiveFacebookPositions(List<EnumEffectiveFacebookPositions> value) {
    this.mEffectiveFacebookPositions = value;
    return this;
  }

  public List<EnumEffectiveInstagramPositions> getFieldEffectiveInstagramPositions() {
    return mEffectiveInstagramPositions;
  }

  public AdCampaignPlacementGet setFieldEffectiveInstagramPositions(List<EnumEffectiveInstagramPositions> value) {
    this.mEffectiveInstagramPositions = value;
    return this;
  }

  public List<EnumEffectiveMessengerPositions> getFieldEffectiveMessengerPositions() {
    return mEffectiveMessengerPositions;
  }

  public AdCampaignPlacementGet setFieldEffectiveMessengerPositions(List<EnumEffectiveMessengerPositions> value) {
    this.mEffectiveMessengerPositions = value;
    return this;
  }

  public List<EnumEffectiveOculusPositions> getFieldEffectiveOculusPositions() {
    return mEffectiveOculusPositions;
  }

  public AdCampaignPlacementGet setFieldEffectiveOculusPositions(List<EnumEffectiveOculusPositions> value) {
    this.mEffectiveOculusPositions = value;
    return this;
  }

  public List<EnumEffectivePublisherPlatforms> getFieldEffectivePublisherPlatforms() {
    return mEffectivePublisherPlatforms;
  }

  public AdCampaignPlacementGet setFieldEffectivePublisherPlatforms(List<EnumEffectivePublisherPlatforms> value) {
    this.mEffectivePublisherPlatforms = value;
    return this;
  }

  public Object getFieldMetadata() {
    return mMetadata;
  }

  public AdCampaignPlacementGet setFieldMetadata(Object value) {
    this.mMetadata = value;
    return this;
  }

  public List<Object> getFieldRecommendations() {
    return mRecommendations;
  }

  public AdCampaignPlacementGet setFieldRecommendations(List<Object> value) {
    this.mRecommendations = value;
    return this;
  }



  public static enum EnumEffectiveAudienceNetworkPositions {
      @SerializedName("CLASSIC")
      VALUE_CLASSIC("CLASSIC"),
      @SerializedName("INSTREAM_VIDEO")
      VALUE_INSTREAM_VIDEO("INSTREAM_VIDEO"),
      @SerializedName("REWARDED_VIDEO")
      VALUE_REWARDED_VIDEO("REWARDED_VIDEO"),
      ;

      private String value;

      private EnumEffectiveAudienceNetworkPositions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveDevicePlatforms {
      @SerializedName("DESKTOP")
      VALUE_DESKTOP("DESKTOP"),
      @SerializedName("MOBILE")
      VALUE_MOBILE("MOBILE"),
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

  public static enum EnumEffectiveFacebookPositions {
      @SerializedName("BIZ_DISCO_FEED")
      VALUE_BIZ_DISCO_FEED("BIZ_DISCO_FEED"),
      @SerializedName("FACEBOOK_CONTEXTUAL_BUNDLE")
      VALUE_FACEBOOK_CONTEXTUAL_BUNDLE("FACEBOOK_CONTEXTUAL_BUNDLE"),
      @SerializedName("FB_REELS")
      VALUE_FB_REELS("FB_REELS"),
      @SerializedName("FB_REELS_OVERLAY")
      VALUE_FB_REELS_OVERLAY("FB_REELS_OVERLAY"),
      @SerializedName("FEED")
      VALUE_FEED("FEED"),
      @SerializedName("GROUPS")
      VALUE_GROUPS("GROUPS"),
      @SerializedName("GROUP_MALL")
      VALUE_GROUP_MALL("GROUP_MALL"),
      @SerializedName("GROUP_TAB")
      VALUE_GROUP_TAB("GROUP_TAB"),
      @SerializedName("INSTANT_ARTICLE")
      VALUE_INSTANT_ARTICLE("INSTANT_ARTICLE"),
      @SerializedName("INSTREAM_REEL")
      VALUE_INSTREAM_REEL("INSTREAM_REEL"),
      @SerializedName("INSTREAM_VIDEO")
      VALUE_INSTREAM_VIDEO("INSTREAM_VIDEO"),
      @SerializedName("JOBS_BROWSER")
      VALUE_JOBS_BROWSER("JOBS_BROWSER"),
      @SerializedName("MARKETPLACE")
      VALUE_MARKETPLACE("MARKETPLACE"),
      @SerializedName("NOTIFICATION")
      VALUE_NOTIFICATION("NOTIFICATION"),
      @SerializedName("PROFILE_FEED")
      VALUE_PROFILE_FEED("PROFILE_FEED"),
      @SerializedName("PROFILE_REELS")
      VALUE_PROFILE_REELS("PROFILE_REELS"),
      @SerializedName("RHC")
      VALUE_RHC("RHC"),
      @SerializedName("SEARCH")
      VALUE_SEARCH("SEARCH"),
      @SerializedName("STORY")
      VALUE_STORY("STORY"),
      @SerializedName("STORY_STICKER")
      VALUE_STORY_STICKER("STORY_STICKER"),
      @SerializedName("SUGGESTED_VIDEO")
      VALUE_SUGGESTED_VIDEO("SUGGESTED_VIDEO"),
      @SerializedName("VIDEO_FEEDS")
      VALUE_VIDEO_FEEDS("VIDEO_FEEDS"),
      ;

      private String value;

      private EnumEffectiveFacebookPositions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveInstagramPositions {
      @SerializedName("EFFECT_TRAY")
      VALUE_EFFECT_TRAY("EFFECT_TRAY"),
      @SerializedName("EXPLORE")
      VALUE_EXPLORE("EXPLORE"),
      @SerializedName("EXPLORE_HOME")
      VALUE_EXPLORE_HOME("EXPLORE_HOME"),
      @SerializedName("IGTV")
      VALUE_IGTV("IGTV"),
      @SerializedName("IG_SEARCH")
      VALUE_IG_SEARCH("IG_SEARCH"),
      @SerializedName("LEAD_GEN_MULTI_SUBMIT")
      VALUE_LEAD_GEN_MULTI_SUBMIT("LEAD_GEN_MULTI_SUBMIT"),
      @SerializedName("PROFILE_FEED")
      VALUE_PROFILE_FEED("PROFILE_FEED"),
      @SerializedName("PROFILE_REELS")
      VALUE_PROFILE_REELS("PROFILE_REELS"),
      @SerializedName("REELS")
      VALUE_REELS("REELS"),
      @SerializedName("REELS_INSTREAM")
      VALUE_REELS_INSTREAM("REELS_INSTREAM"),
      @SerializedName("REELS_OVERLAY")
      VALUE_REELS_OVERLAY("REELS_OVERLAY"),
      @SerializedName("SHOP")
      VALUE_SHOP("SHOP"),
      @SerializedName("STORY")
      VALUE_STORY("STORY"),
      @SerializedName("STREAM")
      VALUE_STREAM("STREAM"),
      ;

      private String value;

      private EnumEffectiveInstagramPositions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveMessengerPositions {
      @SerializedName("MESSENGER_INBOX")
      VALUE_MESSENGER_INBOX("MESSENGER_INBOX"),
      @SerializedName("MESSENGER_MARKETING_MESSAGES")
      VALUE_MESSENGER_MARKETING_MESSAGES("MESSENGER_MARKETING_MESSAGES"),
      @SerializedName("MESSENGER_STORY")
      VALUE_MESSENGER_STORY("MESSENGER_STORY"),
      @SerializedName("MESSENGER_THREAD")
      VALUE_MESSENGER_THREAD("MESSENGER_THREAD"),
      ;

      private String value;

      private EnumEffectiveMessengerPositions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveOculusPositions {
      @SerializedName("TWILIGHT_DEVELOPER_UPDATE")
      VALUE_TWILIGHT_DEVELOPER_UPDATE("TWILIGHT_DEVELOPER_UPDATE"),
      @SerializedName("TWILIGHT_FEED")
      VALUE_TWILIGHT_FEED("TWILIGHT_FEED"),
      @SerializedName("TWILIGHT_FEED_SPOTLIGHT")
      VALUE_TWILIGHT_FEED_SPOTLIGHT("TWILIGHT_FEED_SPOTLIGHT"),
      @SerializedName("TWILIGHT_SEARCH")
      VALUE_TWILIGHT_SEARCH("TWILIGHT_SEARCH"),
      @SerializedName("TWILIGHT_SEARCH_NULL_STATE")
      VALUE_TWILIGHT_SEARCH_NULL_STATE("TWILIGHT_SEARCH_NULL_STATE"),
      @SerializedName("VR_APPS")
      VALUE_VR_APPS("VR_APPS"),
      @SerializedName("VR_REWARDED_VIDEO")
      VALUE_VR_REWARDED_VIDEO("VR_REWARDED_VIDEO"),
      ;

      private String value;

      private EnumEffectiveOculusPositions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectivePublisherPlatforms {
      @SerializedName("AUDIENCE_NETWORK")
      VALUE_AUDIENCE_NETWORK("AUDIENCE_NETWORK"),
      @SerializedName("FACEBOOK")
      VALUE_FACEBOOK("FACEBOOK"),
      @SerializedName("INSTAGRAM")
      VALUE_INSTAGRAM("INSTAGRAM"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("OCULUS")
      VALUE_OCULUS("OCULUS"),
      @SerializedName("THREADS")
      VALUE_THREADS("THREADS"),
      @SerializedName("WHATSAPP")
      VALUE_WHATSAPP("WHATSAPP"),
      ;

      private String value;

      private EnumEffectivePublisherPlatforms(String value) {
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

  public AdCampaignPlacementGet copyFrom(AdCampaignPlacementGet instance) {
    this.mEffectiveAudienceNetworkPositions = instance.mEffectiveAudienceNetworkPositions;
    this.mEffectiveDevicePlatforms = instance.mEffectiveDevicePlatforms;
    this.mEffectiveFacebookPositions = instance.mEffectiveFacebookPositions;
    this.mEffectiveInstagramPositions = instance.mEffectiveInstagramPositions;
    this.mEffectiveMessengerPositions = instance.mEffectiveMessengerPositions;
    this.mEffectiveOculusPositions = instance.mEffectiveOculusPositions;
    this.mEffectivePublisherPlatforms = instance.mEffectivePublisherPlatforms;
    this.mMetadata = instance.mMetadata;
    this.mRecommendations = instance.mRecommendations;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignPlacementGet> getParser() {
    return new APIRequest.ResponseParser<AdCampaignPlacementGet>() {
      public APINodeList<AdCampaignPlacementGet> parseResponse(String response, APIContext context, APIRequest<AdCampaignPlacementGet> request, String header) throws MalformedResponseException {
        return AdCampaignPlacementGet.parseResponse(response, context, request, header);
      }
    };
  }
}
