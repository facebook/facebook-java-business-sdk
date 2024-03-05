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
public class AdAssetTargetRuleTargeting extends APINode {
  @SerializedName("age_max")
  private Long mAgeMax = null;
  @SerializedName("age_min")
  private Long mAgeMin = null;
  @SerializedName("audience_network_positions")
  private List<String> mAudienceNetworkPositions = null;
  @SerializedName("device_platforms")
  private List<EnumDevicePlatforms> mDevicePlatforms = null;
  @SerializedName("facebook_positions")
  private List<String> mFacebookPositions = null;
  @SerializedName("geo_locations")
  private TargetingGeoLocation mGeoLocations = null;
  @SerializedName("instagram_positions")
  private List<String> mInstagramPositions = null;
  @SerializedName("publisher_platforms")
  private List<String> mPublisherPlatforms = null;
  protected static Gson gson = null;

  public AdAssetTargetRuleTargeting() {
  }

  public String getId() {
    return null;
  }
  public static AdAssetTargetRuleTargeting loadJSON(String json, APIContext context, String header) {
    AdAssetTargetRuleTargeting adAssetTargetRuleTargeting = getGson().fromJson(json, AdAssetTargetRuleTargeting.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetTargetRuleTargeting.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAssetTargetRuleTargeting.context = context;
    adAssetTargetRuleTargeting.rawValue = json;
    adAssetTargetRuleTargeting.header = header;
    return adAssetTargetRuleTargeting;
  }

  public static APINodeList<AdAssetTargetRuleTargeting> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAssetTargetRuleTargeting> adAssetTargetRuleTargetings = new APINodeList<AdAssetTargetRuleTargeting>(request, json, header);
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
          adAssetTargetRuleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAssetTargetRuleTargetings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetTargetRuleTargetings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetTargetRuleTargetings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetTargetRuleTargetings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetTargetRuleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAssetTargetRuleTargetings.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetTargetRuleTargetings.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAssetTargetRuleTargetings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetTargetRuleTargetings.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAssetTargetRuleTargetings;
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
              adAssetTargetRuleTargetings.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetTargetRuleTargetings;
          }

          // Sixth, check if it's pure JsonObject
          adAssetTargetRuleTargetings.clear();
          adAssetTargetRuleTargetings.add(loadJSON(json, context, header));
          return adAssetTargetRuleTargetings;
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


  public Long getFieldAgeMax() {
    return mAgeMax;
  }

  public AdAssetTargetRuleTargeting setFieldAgeMax(Long value) {
    this.mAgeMax = value;
    return this;
  }

  public Long getFieldAgeMin() {
    return mAgeMin;
  }

  public AdAssetTargetRuleTargeting setFieldAgeMin(Long value) {
    this.mAgeMin = value;
    return this;
  }

  public List<String> getFieldAudienceNetworkPositions() {
    return mAudienceNetworkPositions;
  }

  public AdAssetTargetRuleTargeting setFieldAudienceNetworkPositions(List<String> value) {
    this.mAudienceNetworkPositions = value;
    return this;
  }

  public List<EnumDevicePlatforms> getFieldDevicePlatforms() {
    return mDevicePlatforms;
  }

  public AdAssetTargetRuleTargeting setFieldDevicePlatforms(List<EnumDevicePlatforms> value) {
    this.mDevicePlatforms = value;
    return this;
  }

  public List<String> getFieldFacebookPositions() {
    return mFacebookPositions;
  }

  public AdAssetTargetRuleTargeting setFieldFacebookPositions(List<String> value) {
    this.mFacebookPositions = value;
    return this;
  }

  public TargetingGeoLocation getFieldGeoLocations() {
    return mGeoLocations;
  }

  public AdAssetTargetRuleTargeting setFieldGeoLocations(TargetingGeoLocation value) {
    this.mGeoLocations = value;
    return this;
  }

  public AdAssetTargetRuleTargeting setFieldGeoLocations(String value) {
    Type type = new TypeToken<TargetingGeoLocation>(){}.getType();
    this.mGeoLocations = TargetingGeoLocation.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldInstagramPositions() {
    return mInstagramPositions;
  }

  public AdAssetTargetRuleTargeting setFieldInstagramPositions(List<String> value) {
    this.mInstagramPositions = value;
    return this;
  }

  public List<String> getFieldPublisherPlatforms() {
    return mPublisherPlatforms;
  }

  public AdAssetTargetRuleTargeting setFieldPublisherPlatforms(List<String> value) {
    this.mPublisherPlatforms = value;
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

  public AdAssetTargetRuleTargeting copyFrom(AdAssetTargetRuleTargeting instance) {
    this.mAgeMax = instance.mAgeMax;
    this.mAgeMin = instance.mAgeMin;
    this.mAudienceNetworkPositions = instance.mAudienceNetworkPositions;
    this.mDevicePlatforms = instance.mDevicePlatforms;
    this.mFacebookPositions = instance.mFacebookPositions;
    this.mGeoLocations = instance.mGeoLocations;
    this.mInstagramPositions = instance.mInstagramPositions;
    this.mPublisherPlatforms = instance.mPublisherPlatforms;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetTargetRuleTargeting> getParser() {
    return new APIRequest.ResponseParser<AdAssetTargetRuleTargeting>() {
      public APINodeList<AdAssetTargetRuleTargeting> parseResponse(String response, APIContext context, APIRequest<AdAssetTargetRuleTargeting> request, String header) throws MalformedResponseException {
        return AdAssetTargetRuleTargeting.parseResponse(response, context, request, header);
      }
    };
  }
}
