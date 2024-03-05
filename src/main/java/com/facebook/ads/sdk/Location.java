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
public class Location extends APINode {
  @SerializedName("city")
  private String mCity = null;
  @SerializedName("city_id")
  private Long mCityId = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("country_code")
  private String mCountryCode = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("located_in")
  private String mLocatedIn = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("region_id")
  private Long mRegionId = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("street")
  private String mStreet = null;
  @SerializedName("zip")
  private String mZip = null;
  protected static Gson gson = null;

  public Location() {
  }

  public String getId() {
    return null;
  }
  public static Location loadJSON(String json, APIContext context, String header) {
    Location location = getGson().fromJson(json, Location.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(location.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    location.context = context;
    location.rawValue = json;
    location.header = header;
    return location;
  }

  public static APINodeList<Location> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Location> locations = new APINodeList<Location>(request, json, header);
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
          locations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return locations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                locations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            locations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              locations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              locations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  locations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              locations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return locations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              locations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return locations;
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
              locations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return locations;
          }

          // Sixth, check if it's pure JsonObject
          locations.clear();
          locations.add(loadJSON(json, context, header));
          return locations;
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


  public String getFieldCity() {
    return mCity;
  }

  public Location setFieldCity(String value) {
    this.mCity = value;
    return this;
  }

  public Long getFieldCityId() {
    return mCityId;
  }

  public Location setFieldCityId(Long value) {
    this.mCityId = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public Location setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldCountryCode() {
    return mCountryCode;
  }

  public Location setFieldCountryCode(String value) {
    this.mCountryCode = value;
    return this;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public Location setFieldLatitude(Double value) {
    this.mLatitude = value;
    return this;
  }

  public String getFieldLocatedIn() {
    return mLocatedIn;
  }

  public Location setFieldLocatedIn(String value) {
    this.mLocatedIn = value;
    return this;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public Location setFieldLongitude(Double value) {
    this.mLongitude = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public Location setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public Location setFieldRegion(String value) {
    this.mRegion = value;
    return this;
  }

  public Long getFieldRegionId() {
    return mRegionId;
  }

  public Location setFieldRegionId(Long value) {
    this.mRegionId = value;
    return this;
  }

  public String getFieldState() {
    return mState;
  }

  public Location setFieldState(String value) {
    this.mState = value;
    return this;
  }

  public String getFieldStreet() {
    return mStreet;
  }

  public Location setFieldStreet(String value) {
    this.mStreet = value;
    return this;
  }

  public String getFieldZip() {
    return mZip;
  }

  public Location setFieldZip(String value) {
    this.mZip = value;
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

  public Location copyFrom(Location instance) {
    this.mCity = instance.mCity;
    this.mCityId = instance.mCityId;
    this.mCountry = instance.mCountry;
    this.mCountryCode = instance.mCountryCode;
    this.mLatitude = instance.mLatitude;
    this.mLocatedIn = instance.mLocatedIn;
    this.mLongitude = instance.mLongitude;
    this.mName = instance.mName;
    this.mRegion = instance.mRegion;
    this.mRegionId = instance.mRegionId;
    this.mState = instance.mState;
    this.mStreet = instance.mStreet;
    this.mZip = instance.mZip;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Location> getParser() {
    return new APIRequest.ResponseParser<Location>() {
      public APINodeList<Location> parseResponse(String response, APIContext context, APIRequest<Location> request, String header) throws MalformedResponseException {
        return Location.parseResponse(response, context, request, header);
      }
    };
  }
}
