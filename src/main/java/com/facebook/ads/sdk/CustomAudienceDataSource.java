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
public class CustomAudienceDataSource extends APINode {
  @SerializedName("creation_params")
  private String mCreationParams = null;
  @SerializedName("sub_type")
  private EnumSubType mSubType = null;
  @SerializedName("type")
  private EnumType mType = null;
  protected static Gson gson = null;

  public CustomAudienceDataSource() {
  }

  public String getId() {
    return null;
  }
  public static CustomAudienceDataSource loadJSON(String json, APIContext context, String header) {
    CustomAudienceDataSource customAudienceDataSource = getGson().fromJson(json, CustomAudienceDataSource.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudienceDataSource.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    customAudienceDataSource.context = context;
    customAudienceDataSource.rawValue = json;
    customAudienceDataSource.header = header;
    return customAudienceDataSource;
  }

  public static APINodeList<CustomAudienceDataSource> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CustomAudienceDataSource> customAudienceDataSources = new APINodeList<CustomAudienceDataSource>(request, json, header);
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
          customAudienceDataSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return customAudienceDataSources;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customAudienceDataSources.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customAudienceDataSources.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customAudienceDataSources.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudienceDataSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  customAudienceDataSources.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudienceDataSources.add(loadJSON(obj.toString(), context, header));
            }
          }
          return customAudienceDataSources;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudienceDataSources.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return customAudienceDataSources;
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
              customAudienceDataSources.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudienceDataSources;
          }

          // Sixth, check if it's pure JsonObject
          customAudienceDataSources.clear();
          customAudienceDataSources.add(loadJSON(json, context, header));
          return customAudienceDataSources;
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


  public String getFieldCreationParams() {
    return mCreationParams;
  }

  public CustomAudienceDataSource setFieldCreationParams(String value) {
    this.mCreationParams = value;
    return this;
  }

  public EnumSubType getFieldSubType() {
    return mSubType;
  }

  public CustomAudienceDataSource setFieldSubType(EnumSubType value) {
    this.mSubType = value;
    return this;
  }

  public EnumType getFieldType() {
    return mType;
  }

  public CustomAudienceDataSource setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }



  public static enum EnumSubType {
      @SerializedName("AD_CAMPAIGN")
      VALUE_AD_CAMPAIGN("AD_CAMPAIGN"),
      @SerializedName("ANYTHING")
      VALUE_ANYTHING("ANYTHING"),
      @SerializedName("APP_USERS")
      VALUE_APP_USERS("APP_USERS"),
      @SerializedName("AR_EFFECTS_EVENTS")
      VALUE_AR_EFFECTS_EVENTS("AR_EFFECTS_EVENTS"),
      @SerializedName("AR_EXPERIENCE_EVENTS")
      VALUE_AR_EXPERIENCE_EVENTS("AR_EXPERIENCE_EVENTS"),
      @SerializedName("CAMPAIGN_CONVERSIONS")
      VALUE_CAMPAIGN_CONVERSIONS("CAMPAIGN_CONVERSIONS"),
      @SerializedName("COMBINATION_CUSTOM_AUDIENCE_USERS")
      VALUE_COMBINATION_CUSTOM_AUDIENCE_USERS("COMBINATION_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("CONSTANT_CONTACTS_EMAIL_HASHES")
      VALUE_CONSTANT_CONTACTS_EMAIL_HASHES("CONSTANT_CONTACTS_EMAIL_HASHES"),
      @SerializedName("CONTACT_IMPORTER")
      VALUE_CONTACT_IMPORTER("CONTACT_IMPORTER"),
      @SerializedName("CONVERSION_PIXEL_HITS")
      VALUE_CONVERSION_PIXEL_HITS("CONVERSION_PIXEL_HITS"),
      @SerializedName("COPY_PASTE_EMAIL_HASHES")
      VALUE_COPY_PASTE_EMAIL_HASHES("COPY_PASTE_EMAIL_HASHES"),
      @SerializedName("CUSTOM_AUDIENCE_USERS")
      VALUE_CUSTOM_AUDIENCE_USERS("CUSTOM_AUDIENCE_USERS"),
      @SerializedName("CUSTOM_DATA_TARGETING")
      VALUE_CUSTOM_DATA_TARGETING("CUSTOM_DATA_TARGETING"),
      @SerializedName("DATA_FILE")
      VALUE_DATA_FILE("DATA_FILE"),
      @SerializedName("DYNAMIC_RULE")
      VALUE_DYNAMIC_RULE("DYNAMIC_RULE"),
      @SerializedName("ENGAGEMENT_EVENT_USERS")
      VALUE_ENGAGEMENT_EVENT_USERS("ENGAGEMENT_EVENT_USERS"),
      @SerializedName("EXPANDED_AUDIENCE")
      VALUE_EXPANDED_AUDIENCE("EXPANDED_AUDIENCE"),
      @SerializedName("EXTERNAL_IDS")
      VALUE_EXTERNAL_IDS("EXTERNAL_IDS"),
      @SerializedName("EXTERNAL_IDS_MIX")
      VALUE_EXTERNAL_IDS_MIX("EXTERNAL_IDS_MIX"),
      @SerializedName("FACEBOOK_WIFI_EVENTS")
      VALUE_FACEBOOK_WIFI_EVENTS("FACEBOOK_WIFI_EVENTS"),
      @SerializedName("FB_EVENT_SIGNALS")
      VALUE_FB_EVENT_SIGNALS("FB_EVENT_SIGNALS"),
      @SerializedName("FB_PIXEL_HITS")
      VALUE_FB_PIXEL_HITS("FB_PIXEL_HITS"),
      @SerializedName("GROUP_EVENTS")
      VALUE_GROUP_EVENTS("GROUP_EVENTS"),
      @SerializedName("HASHES")
      VALUE_HASHES("HASHES"),
      @SerializedName("HASHES_OR_USER_IDS")
      VALUE_HASHES_OR_USER_IDS("HASHES_OR_USER_IDS"),
      @SerializedName("HOUSEHOLD_EXPANSION")
      VALUE_HOUSEHOLD_EXPANSION("HOUSEHOLD_EXPANSION"),
      @SerializedName("IG_BUSINESS_EVENTS")
      VALUE_IG_BUSINESS_EVENTS("IG_BUSINESS_EVENTS"),
      @SerializedName("IG_PROMOTED_POST")
      VALUE_IG_PROMOTED_POST("IG_PROMOTED_POST"),
      @SerializedName("INSTANT_ARTICLE_EVENTS")
      VALUE_INSTANT_ARTICLE_EVENTS("INSTANT_ARTICLE_EVENTS"),
      @SerializedName("LOOKALIKE_PLATFORM")
      VALUE_LOOKALIKE_PLATFORM("LOOKALIKE_PLATFORM"),
      @SerializedName("MAIL_CHIMP_EMAIL_HASHES")
      VALUE_MAIL_CHIMP_EMAIL_HASHES("MAIL_CHIMP_EMAIL_HASHES"),
      @SerializedName("MARKETPLACE_LISTINGS")
      VALUE_MARKETPLACE_LISTINGS("MARKETPLACE_LISTINGS"),
      @SerializedName("MESSENGER_ONSITE_SUBSCRIPTION")
      VALUE_MESSENGER_ONSITE_SUBSCRIPTION("MESSENGER_ONSITE_SUBSCRIPTION"),
      @SerializedName("MOBILE_ADVERTISER_IDS")
      VALUE_MOBILE_ADVERTISER_IDS("MOBILE_ADVERTISER_IDS"),
      @SerializedName("MOBILE_APP_COMBINATION_EVENTS")
      VALUE_MOBILE_APP_COMBINATION_EVENTS("MOBILE_APP_COMBINATION_EVENTS"),
      @SerializedName("MOBILE_APP_CUSTOM_AUDIENCE_USERS")
      VALUE_MOBILE_APP_CUSTOM_AUDIENCE_USERS("MOBILE_APP_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("MOBILE_APP_EVENTS")
      VALUE_MOBILE_APP_EVENTS("MOBILE_APP_EVENTS"),
      @SerializedName("MULTICOUNTRY_COMBINATION")
      VALUE_MULTICOUNTRY_COMBINATION("MULTICOUNTRY_COMBINATION"),
      @SerializedName("MULTI_DATA_EVENTS")
      VALUE_MULTI_DATA_EVENTS("MULTI_DATA_EVENTS"),
      @SerializedName("MULTI_EVENT_SOURCE")
      VALUE_MULTI_EVENT_SOURCE("MULTI_EVENT_SOURCE"),
      @SerializedName("MULTI_HASHES")
      VALUE_MULTI_HASHES("MULTI_HASHES"),
      @SerializedName("NOTHING")
      VALUE_NOTHING("NOTHING"),
      @SerializedName("OFFLINE_EVENT_USERS")
      VALUE_OFFLINE_EVENT_USERS("OFFLINE_EVENT_USERS"),
      @SerializedName("PAGE_FANS")
      VALUE_PAGE_FANS("PAGE_FANS"),
      @SerializedName("PAGE_SMART_AUDIENCE")
      VALUE_PAGE_SMART_AUDIENCE("PAGE_SMART_AUDIENCE"),
      @SerializedName("PARTNER_CATEGORY_USERS")
      VALUE_PARTNER_CATEGORY_USERS("PARTNER_CATEGORY_USERS"),
      @SerializedName("PLACE_VISITS")
      VALUE_PLACE_VISITS("PLACE_VISITS"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("PLATFORM_USERS")
      VALUE_PLATFORM_USERS("PLATFORM_USERS"),
      @SerializedName("SEED_LIST")
      VALUE_SEED_LIST("SEED_LIST"),
      @SerializedName("SIGNAL_SOURCE")
      VALUE_SIGNAL_SOURCE("SIGNAL_SOURCE"),
      @SerializedName("SMART_AUDIENCE")
      VALUE_SMART_AUDIENCE("SMART_AUDIENCE"),
      @SerializedName("STORE_VISIT_EVENTS")
      VALUE_STORE_VISIT_EVENTS("STORE_VISIT_EVENTS"),
      @SerializedName("SUBSCRIBER_LIST")
      VALUE_SUBSCRIBER_LIST("SUBSCRIBER_LIST"),
      @SerializedName("S_EXPR")
      VALUE_S_EXPR("S_EXPR"),
      @SerializedName("TOKENS")
      VALUE_TOKENS("TOKENS"),
      @SerializedName("USER_IDS")
      VALUE_USER_IDS("USER_IDS"),
      @SerializedName("VIDEO_EVENTS")
      VALUE_VIDEO_EVENTS("VIDEO_EVENTS"),
      @SerializedName("VIDEO_EVENT_USERS")
      VALUE_VIDEO_EVENT_USERS("VIDEO_EVENT_USERS"),
      @SerializedName("WEB_PIXEL_COMBINATION_EVENTS")
      VALUE_WEB_PIXEL_COMBINATION_EVENTS("WEB_PIXEL_COMBINATION_EVENTS"),
      @SerializedName("WEB_PIXEL_HITS")
      VALUE_WEB_PIXEL_HITS("WEB_PIXEL_HITS"),
      @SerializedName("WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS")
      VALUE_WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS("WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("WHATSAPP_SUBSCRIBER_POOL")
      VALUE_WHATSAPP_SUBSCRIBER_POOL("WHATSAPP_SUBSCRIBER_POOL"),
      ;

      private String value;

      private EnumSubType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("CONTACT_IMPORTER")
      VALUE_CONTACT_IMPORTER("CONTACT_IMPORTER"),
      @SerializedName("COPY_PASTE")
      VALUE_COPY_PASTE("COPY_PASTE"),
      @SerializedName("EVENT_BASED")
      VALUE_EVENT_BASED("EVENT_BASED"),
      @SerializedName("FILE_IMPORTED")
      VALUE_FILE_IMPORTED("FILE_IMPORTED"),
      @SerializedName("HOUSEHOLD_AUDIENCE")
      VALUE_HOUSEHOLD_AUDIENCE("HOUSEHOLD_AUDIENCE"),
      @SerializedName("SEED_BASED")
      VALUE_SEED_BASED("SEED_BASED"),
      @SerializedName("THIRD_PARTY_IMPORTED")
      VALUE_THIRD_PARTY_IMPORTED("THIRD_PARTY_IMPORTED"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumType(String value) {
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

  public CustomAudienceDataSource copyFrom(CustomAudienceDataSource instance) {
    this.mCreationParams = instance.mCreationParams;
    this.mSubType = instance.mSubType;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudienceDataSource> getParser() {
    return new APIRequest.ResponseParser<CustomAudienceDataSource>() {
      public APINodeList<CustomAudienceDataSource> parseResponse(String response, APIContext context, APIRequest<CustomAudienceDataSource> request, String header) throws MalformedResponseException {
        return CustomAudienceDataSource.parseResponse(response, context, request, header);
      }
    };
  }
}
