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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class TargetingGeoLocation extends APINode {
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("cities")
  private List<TargetingGeoLocationCity> mCities = null;
  @SerializedName("regions")
  private List<TargetingGeoLocationRegion> mRegions = null;
  @SerializedName("zips")
  private List<TargetingGeoLocationZip> mZips = null;
  @SerializedName("custom_locations")
  private List<TargetingGeoLocationCustomLocation> mCustomLocations = null;
  @SerializedName("places")
  private List<TargetingGeoLocationPlace> mPlaces = null;
  @SerializedName("geo_markets")
  private List<TargetingGeoLocationMarket> mGeoMarkets = null;
  @SerializedName("location_types")
  private List<String> mLocationTypes = null;
  protected static Gson gson = null;

  public TargetingGeoLocation() {
  }

  public String getId() {
    return null;
  }
  public static TargetingGeoLocation loadJSON(String json, APIContext context) {
    TargetingGeoLocation targetingGeoLocation = getGson().fromJson(json, TargetingGeoLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingGeoLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingGeoLocation.mContext = context;
    targetingGeoLocation.rawValue = json;
    return targetingGeoLocation;
  }

  public static APINodeList<TargetingGeoLocation> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<TargetingGeoLocation> targetingGeoLocations = new APINodeList<TargetingGeoLocation>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetingGeoLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            targetingGeoLocations.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            targetingGeoLocations.add(loadJSON(obj.toString(), context));
          }
          return targetingGeoLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingGeoLocations.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetingGeoLocations;
        } else {
          // Fifth, check if it's pure JsonObject
          targetingGeoLocations.add(loadJSON(json, context));
          return targetingGeoLocations;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public List<String> getFieldCountries() {
    return mCountries;
  }

  public TargetingGeoLocation setFieldCountries(List<String> value) {
    this.mCountries = value;
    return this;
  }

  public List<TargetingGeoLocationCity> getFieldCities() {
    return mCities;
  }

  public TargetingGeoLocation setFieldCities(List<TargetingGeoLocationCity> value) {
    this.mCities = value;
    return this;
  }

  public TargetingGeoLocation setFieldCities(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationCity>>(){}.getType();
    this.mCities = TargetingGeoLocationCity.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationRegion> getFieldRegions() {
    return mRegions;
  }

  public TargetingGeoLocation setFieldRegions(List<TargetingGeoLocationRegion> value) {
    this.mRegions = value;
    return this;
  }

  public TargetingGeoLocation setFieldRegions(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationRegion>>(){}.getType();
    this.mRegions = TargetingGeoLocationRegion.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationZip> getFieldZips() {
    return mZips;
  }

  public TargetingGeoLocation setFieldZips(List<TargetingGeoLocationZip> value) {
    this.mZips = value;
    return this;
  }

  public TargetingGeoLocation setFieldZips(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationZip>>(){}.getType();
    this.mZips = TargetingGeoLocationZip.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationCustomLocation> getFieldCustomLocations() {
    return mCustomLocations;
  }

  public TargetingGeoLocation setFieldCustomLocations(List<TargetingGeoLocationCustomLocation> value) {
    this.mCustomLocations = value;
    return this;
  }

  public TargetingGeoLocation setFieldCustomLocations(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationCustomLocation>>(){}.getType();
    this.mCustomLocations = TargetingGeoLocationCustomLocation.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationPlace> getFieldPlaces() {
    return mPlaces;
  }

  public TargetingGeoLocation setFieldPlaces(List<TargetingGeoLocationPlace> value) {
    this.mPlaces = value;
    return this;
  }

  public TargetingGeoLocation setFieldPlaces(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationPlace>>(){}.getType();
    this.mPlaces = TargetingGeoLocationPlace.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationMarket> getFieldGeoMarkets() {
    return mGeoMarkets;
  }

  public TargetingGeoLocation setFieldGeoMarkets(List<TargetingGeoLocationMarket> value) {
    this.mGeoMarkets = value;
    return this;
  }

  public TargetingGeoLocation setFieldGeoMarkets(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationMarket>>(){}.getType();
    this.mGeoMarkets = TargetingGeoLocationMarket.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldLocationTypes() {
    return mLocationTypes;
  }

  public TargetingGeoLocation setFieldLocationTypes(List<String> value) {
    this.mLocationTypes = value;
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

  public TargetingGeoLocation copyFrom(TargetingGeoLocation instance) {
    this.mCountries = instance.mCountries;
    this.mCities = instance.mCities;
    this.mRegions = instance.mRegions;
    this.mZips = instance.mZips;
    this.mCustomLocations = instance.mCustomLocations;
    this.mPlaces = instance.mPlaces;
    this.mGeoMarkets = instance.mGeoMarkets;
    this.mLocationTypes = instance.mLocationTypes;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}