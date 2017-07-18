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
 * This class is auto-genereated.
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
  public static CustomAudienceDataSource loadJSON(String json, APIContext context) {
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
      };
    }
    customAudienceDataSource.context = context;
    customAudienceDataSource.rawValue = json;
    return customAudienceDataSource;
  }

  public static APINodeList<CustomAudienceDataSource> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CustomAudienceDataSource> customAudienceDataSources = new APINodeList<CustomAudienceDataSource>(request, json);
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
          customAudienceDataSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customAudienceDataSources;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            customAudienceDataSources.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudienceDataSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  customAudienceDataSources.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudienceDataSources.add(loadJSON(obj.toString(), context));
            }
          }
          return customAudienceDataSources;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudienceDataSources.add(loadJSON(entry.getValue().toString(), context));
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
              customAudienceDataSources.add(loadJSON(value.toString(), context));
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
          customAudienceDataSources.add(loadJSON(json, context));
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
      @SerializedName("ANYTHING")
      VALUE_ANYTHING("ANYTHING"),
      @SerializedName("NOTHING")
      VALUE_NOTHING("NOTHING"),
      @SerializedName("HASHES")
      VALUE_HASHES("HASHES"),
      @SerializedName("USER_IDS")
      VALUE_USER_IDS("USER_IDS"),
      @SerializedName("HASHES_OR_USER_IDS")
      VALUE_HASHES_OR_USER_IDS("HASHES_OR_USER_IDS"),
      @SerializedName("MOBILE_ADVERTISER_IDS")
      VALUE_MOBILE_ADVERTISER_IDS("MOBILE_ADVERTISER_IDS"),
      @SerializedName("EXTERNAL_IDS")
      VALUE_EXTERNAL_IDS("EXTERNAL_IDS"),
      @SerializedName("MULTI_HASHES")
      VALUE_MULTI_HASHES("MULTI_HASHES"),
      @SerializedName("TOKENS")
      VALUE_TOKENS("TOKENS"),
      @SerializedName("EXTERNAL_IDS_MIX")
      VALUE_EXTERNAL_IDS_MIX("EXTERNAL_IDS_MIX"),
      @SerializedName("HOUSEHOLD_EXPANSION")
      VALUE_HOUSEHOLD_EXPANSION("HOUSEHOLD_EXPANSION"),
      @SerializedName("WEB_PIXEL_HITS")
      VALUE_WEB_PIXEL_HITS("WEB_PIXEL_HITS"),
      @SerializedName("MOBILE_APP_EVENTS")
      VALUE_MOBILE_APP_EVENTS("MOBILE_APP_EVENTS"),
      @SerializedName("MOBILE_APP_COMBINATION_EVENTS")
      VALUE_MOBILE_APP_COMBINATION_EVENTS("MOBILE_APP_COMBINATION_EVENTS"),
      @SerializedName("VIDEO_EVENTS")
      VALUE_VIDEO_EVENTS("VIDEO_EVENTS"),
      @SerializedName("WEB_PIXEL_COMBINATION_EVENTS")
      VALUE_WEB_PIXEL_COMBINATION_EVENTS("WEB_PIXEL_COMBINATION_EVENTS"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("ENGAGEMENT_EVENT_USERS")
      VALUE_ENGAGEMENT_EVENT_USERS("ENGAGEMENT_EVENT_USERS"),
      @SerializedName("CUSTOM_AUDIENCE_USERS")
      VALUE_CUSTOM_AUDIENCE_USERS("CUSTOM_AUDIENCE_USERS"),
      @SerializedName("PAGE_FANS")
      VALUE_PAGE_FANS("PAGE_FANS"),
      @SerializedName("CONVERSION_PIXEL_HITS")
      VALUE_CONVERSION_PIXEL_HITS("CONVERSION_PIXEL_HITS"),
      @SerializedName("APP_USERS")
      VALUE_APP_USERS("APP_USERS"),
      @SerializedName("S_EXPR")
      VALUE_S_EXPR("S_EXPR"),
      @SerializedName("DYNAMIC_RULE")
      VALUE_DYNAMIC_RULE("DYNAMIC_RULE"),
      @SerializedName("CAMPAIGN_CONVERSIONS")
      VALUE_CAMPAIGN_CONVERSIONS("CAMPAIGN_CONVERSIONS"),
      @SerializedName("WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS")
      VALUE_WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS("WEB_PIXEL_HITS_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("MOBILE_APP_CUSTOM_AUDIENCE_USERS")
      VALUE_MOBILE_APP_CUSTOM_AUDIENCE_USERS("MOBILE_APP_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("COMBINATION_CUSTOM_AUDIENCE_USERS")
      VALUE_COMBINATION_CUSTOM_AUDIENCE_USERS("COMBINATION_CUSTOM_AUDIENCE_USERS"),
      @SerializedName("VIDEO_EVENT_USERS")
      VALUE_VIDEO_EVENT_USERS("VIDEO_EVENT_USERS"),
      @SerializedName("FB_PIXEL_HITS")
      VALUE_FB_PIXEL_HITS("FB_PIXEL_HITS"),
      @SerializedName("IG_PROMOTED_POST")
      VALUE_IG_PROMOTED_POST("IG_PROMOTED_POST"),
      @SerializedName("PLACE_VISITS")
      VALUE_PLACE_VISITS("PLACE_VISITS"),
      @SerializedName("OFFLINE_EVENT_USERS")
      VALUE_OFFLINE_EVENT_USERS("OFFLINE_EVENT_USERS"),
      @SerializedName("EXPANDED_AUDIENCE")
      VALUE_EXPANDED_AUDIENCE("EXPANDED_AUDIENCE"),
      @SerializedName("SEED_LIST")
      VALUE_SEED_LIST("SEED_LIST"),
      @SerializedName("PARTNER_CATEGORY_USERS")
      VALUE_PARTNER_CATEGORY_USERS("PARTNER_CATEGORY_USERS"),
      @SerializedName("PAGE_SMART_AUDIENCE")
      VALUE_PAGE_SMART_AUDIENCE("PAGE_SMART_AUDIENCE"),
      @SerializedName("MULTICOUNTRY_COMBINATION")
      VALUE_MULTICOUNTRY_COMBINATION("MULTICOUNTRY_COMBINATION"),
      @SerializedName("PLATFORM_USERS")
      VALUE_PLATFORM_USERS("PLATFORM_USERS"),
      @SerializedName("MAIL_CHIMP_EMAIL_HASHES")
      VALUE_MAIL_CHIMP_EMAIL_HASHES("MAIL_CHIMP_EMAIL_HASHES"),
      @SerializedName("CONSTANT_CONTACTS_EMAIL_HASHES")
      VALUE_CONSTANT_CONTACTS_EMAIL_HASHES("CONSTANT_CONTACTS_EMAIL_HASHES"),
      @SerializedName("COPY_PASTE_EMAIL_HASHES")
      VALUE_COPY_PASTE_EMAIL_HASHES("COPY_PASTE_EMAIL_HASHES"),
      @SerializedName("CONTACT_IMPORTER")
      VALUE_CONTACT_IMPORTER("CONTACT_IMPORTER"),
      NULL(null);

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
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("FILE_IMPORTED")
      VALUE_FILE_IMPORTED("FILE_IMPORTED"),
      @SerializedName("EVENT_BASED")
      VALUE_EVENT_BASED("EVENT_BASED"),
      @SerializedName("SEED_BASED")
      VALUE_SEED_BASED("SEED_BASED"),
      @SerializedName("THIRD_PARTY_IMPORTED")
      VALUE_THIRD_PARTY_IMPORTED("THIRD_PARTY_IMPORTED"),
      @SerializedName("COPY_PASTE")
      VALUE_COPY_PASTE("COPY_PASTE"),
      @SerializedName("CONTACT_IMPORTER")
      VALUE_CONTACT_IMPORTER("CONTACT_IMPORTER"),
      @SerializedName("HOUSEHOLD_AUDIENCE")
      VALUE_HOUSEHOLD_AUDIENCE("HOUSEHOLD_AUDIENCE"),
      NULL(null);

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
      public APINodeList<CustomAudienceDataSource> parseResponse(String response, APIContext context, APIRequest<CustomAudienceDataSource> request) throws MalformedResponseException {
        return CustomAudienceDataSource.parseResponse(response, context, request);
      }
    };
  }
}
