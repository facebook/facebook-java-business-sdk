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
public class TargetingGeoLocation extends APINode {
  @SerializedName("cities")
  private List<TargetingGeoLocationCity> mCities = null;
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("country_groups")
  private List<String> mCountryGroups = null;
  @SerializedName("custom_locations")
  private List<TargetingGeoLocationCustomLocation> mCustomLocations = null;
  @SerializedName("electoral_districts")
  private List<TargetingGeoLocationElectoralDistrict> mElectoralDistricts = null;
  @SerializedName("geo_markets")
  private List<TargetingGeoLocationMarket> mGeoMarkets = null;
  @SerializedName("large_geo_areas")
  private List<TargetingGeoLocationGeoEntities> mLargeGeoAreas = null;
  @SerializedName("location_cluster_ids")
  private List<TargetingGeoLocationLocationCluster> mLocationClusterIds = null;
  @SerializedName("location_types")
  private List<String> mLocationTypes = null;
  @SerializedName("medium_geo_areas")
  private List<TargetingGeoLocationGeoEntities> mMediumGeoAreas = null;
  @SerializedName("metro_areas")
  private List<TargetingGeoLocationGeoEntities> mMetroAreas = null;
  @SerializedName("neighborhoods")
  private List<TargetingGeoLocationGeoEntities> mNeighborhoods = null;
  @SerializedName("places")
  private List<TargetingGeoLocationPlace> mPlaces = null;
  @SerializedName("political_districts")
  private List<TargetingGeoLocationPoliticalDistrict> mPoliticalDistricts = null;
  @SerializedName("regions")
  private List<TargetingGeoLocationRegion> mRegions = null;
  @SerializedName("small_geo_areas")
  private List<TargetingGeoLocationGeoEntities> mSmallGeoAreas = null;
  @SerializedName("subcities")
  private List<TargetingGeoLocationGeoEntities> mSubcities = null;
  @SerializedName("subneighborhoods")
  private List<TargetingGeoLocationGeoEntities> mSubneighborhoods = null;
  @SerializedName("zips")
  private List<TargetingGeoLocationZip> mZips = null;
  protected static Gson gson = null;

  public TargetingGeoLocation() {
  }

  public String getId() {
    return null;
  }
  public static TargetingGeoLocation loadJSON(String json, APIContext context, String header) {
    TargetingGeoLocation targetingGeoLocation = getGson().fromJson(json, TargetingGeoLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingGeoLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    targetingGeoLocation.context = context;
    targetingGeoLocation.rawValue = json;
    targetingGeoLocation.header = header;
    return targetingGeoLocation;
  }

  public static APINodeList<TargetingGeoLocation> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<TargetingGeoLocation> targetingGeoLocations = new APINodeList<TargetingGeoLocation>(request, json, header);
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
          targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return targetingGeoLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                targetingGeoLocations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            targetingGeoLocations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              targetingGeoLocations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  targetingGeoLocations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              targetingGeoLocations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return targetingGeoLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingGeoLocations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return targetingGeoLocations;
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
              targetingGeoLocations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return targetingGeoLocations;
          }

          // Sixth, check if it's pure JsonObject
          targetingGeoLocations.clear();
          targetingGeoLocations.add(loadJSON(json, context, header));
          return targetingGeoLocations;
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
  public List<String> getFieldCountries() {
    return mCountries;
  }

  public TargetingGeoLocation setFieldCountries(List<String> value) {
    this.mCountries = value;
    return this;
  }

  public List<String> getFieldCountryGroups() {
    return mCountryGroups;
  }

  public TargetingGeoLocation setFieldCountryGroups(List<String> value) {
    this.mCountryGroups = value;
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
  public List<TargetingGeoLocationElectoralDistrict> getFieldElectoralDistricts() {
    return mElectoralDistricts;
  }

  public TargetingGeoLocation setFieldElectoralDistricts(List<TargetingGeoLocationElectoralDistrict> value) {
    this.mElectoralDistricts = value;
    return this;
  }

  public TargetingGeoLocation setFieldElectoralDistricts(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationElectoralDistrict>>(){}.getType();
    this.mElectoralDistricts = TargetingGeoLocationElectoralDistrict.getGson().fromJson(value, type);
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
  public List<TargetingGeoLocationGeoEntities> getFieldLargeGeoAreas() {
    return mLargeGeoAreas;
  }

  public TargetingGeoLocation setFieldLargeGeoAreas(List<TargetingGeoLocationGeoEntities> value) {
    this.mLargeGeoAreas = value;
    return this;
  }

  public TargetingGeoLocation setFieldLargeGeoAreas(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mLargeGeoAreas = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationLocationCluster> getFieldLocationClusterIds() {
    return mLocationClusterIds;
  }

  public TargetingGeoLocation setFieldLocationClusterIds(List<TargetingGeoLocationLocationCluster> value) {
    this.mLocationClusterIds = value;
    return this;
  }

  public TargetingGeoLocation setFieldLocationClusterIds(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationLocationCluster>>(){}.getType();
    this.mLocationClusterIds = TargetingGeoLocationLocationCluster.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldLocationTypes() {
    return mLocationTypes;
  }

  public TargetingGeoLocation setFieldLocationTypes(List<String> value) {
    this.mLocationTypes = value;
    return this;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldMediumGeoAreas() {
    return mMediumGeoAreas;
  }

  public TargetingGeoLocation setFieldMediumGeoAreas(List<TargetingGeoLocationGeoEntities> value) {
    this.mMediumGeoAreas = value;
    return this;
  }

  public TargetingGeoLocation setFieldMediumGeoAreas(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mMediumGeoAreas = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationGeoEntities> getFieldMetroAreas() {
    return mMetroAreas;
  }

  public TargetingGeoLocation setFieldMetroAreas(List<TargetingGeoLocationGeoEntities> value) {
    this.mMetroAreas = value;
    return this;
  }

  public TargetingGeoLocation setFieldMetroAreas(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mMetroAreas = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationGeoEntities> getFieldNeighborhoods() {
    return mNeighborhoods;
  }

  public TargetingGeoLocation setFieldNeighborhoods(List<TargetingGeoLocationGeoEntities> value) {
    this.mNeighborhoods = value;
    return this;
  }

  public TargetingGeoLocation setFieldNeighborhoods(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mNeighborhoods = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
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
  public List<TargetingGeoLocationPoliticalDistrict> getFieldPoliticalDistricts() {
    return mPoliticalDistricts;
  }

  public TargetingGeoLocation setFieldPoliticalDistricts(List<TargetingGeoLocationPoliticalDistrict> value) {
    this.mPoliticalDistricts = value;
    return this;
  }

  public TargetingGeoLocation setFieldPoliticalDistricts(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationPoliticalDistrict>>(){}.getType();
    this.mPoliticalDistricts = TargetingGeoLocationPoliticalDistrict.getGson().fromJson(value, type);
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
  public List<TargetingGeoLocationGeoEntities> getFieldSmallGeoAreas() {
    return mSmallGeoAreas;
  }

  public TargetingGeoLocation setFieldSmallGeoAreas(List<TargetingGeoLocationGeoEntities> value) {
    this.mSmallGeoAreas = value;
    return this;
  }

  public TargetingGeoLocation setFieldSmallGeoAreas(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mSmallGeoAreas = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationGeoEntities> getFieldSubcities() {
    return mSubcities;
  }

  public TargetingGeoLocation setFieldSubcities(List<TargetingGeoLocationGeoEntities> value) {
    this.mSubcities = value;
    return this;
  }

  public TargetingGeoLocation setFieldSubcities(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mSubcities = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingGeoLocationGeoEntities> getFieldSubneighborhoods() {
    return mSubneighborhoods;
  }

  public TargetingGeoLocation setFieldSubneighborhoods(List<TargetingGeoLocationGeoEntities> value) {
    this.mSubneighborhoods = value;
    return this;
  }

  public TargetingGeoLocation setFieldSubneighborhoods(String value) {
    Type type = new TypeToken<List<TargetingGeoLocationGeoEntities>>(){}.getType();
    this.mSubneighborhoods = TargetingGeoLocationGeoEntities.getGson().fromJson(value, type);
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
    this.mCities = instance.mCities;
    this.mCountries = instance.mCountries;
    this.mCountryGroups = instance.mCountryGroups;
    this.mCustomLocations = instance.mCustomLocations;
    this.mElectoralDistricts = instance.mElectoralDistricts;
    this.mGeoMarkets = instance.mGeoMarkets;
    this.mLargeGeoAreas = instance.mLargeGeoAreas;
    this.mLocationClusterIds = instance.mLocationClusterIds;
    this.mLocationTypes = instance.mLocationTypes;
    this.mMediumGeoAreas = instance.mMediumGeoAreas;
    this.mMetroAreas = instance.mMetroAreas;
    this.mNeighborhoods = instance.mNeighborhoods;
    this.mPlaces = instance.mPlaces;
    this.mPoliticalDistricts = instance.mPoliticalDistricts;
    this.mRegions = instance.mRegions;
    this.mSmallGeoAreas = instance.mSmallGeoAreas;
    this.mSubcities = instance.mSubcities;
    this.mSubneighborhoods = instance.mSubneighborhoods;
    this.mZips = instance.mZips;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TargetingGeoLocation> getParser() {
    return new APIRequest.ResponseParser<TargetingGeoLocation>() {
      public APINodeList<TargetingGeoLocation> parseResponse(String response, APIContext context, APIRequest<TargetingGeoLocation> request, String header) throws MalformedResponseException {
        return TargetingGeoLocation.parseResponse(response, context, request, header);
      }
    };
  }
}
