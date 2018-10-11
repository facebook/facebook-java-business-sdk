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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
  @SerializedName("location_set_ids")
  private List<String> mLocationSetIds = null;
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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  TargetingGeoLocation() {
  }

  public TargetingGeoLocation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public TargetingGeoLocation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public TargetingGeoLocation fetch() throws APIException{
    TargetingGeoLocation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static TargetingGeoLocation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<TargetingGeoLocation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static TargetingGeoLocation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<TargetingGeoLocation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<TargetingGeoLocation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<TargetingGeoLocation>)(
      new APIRequest<TargetingGeoLocation>(context, "", "/", "GET", TargetingGeoLocation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<TargetingGeoLocation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", TargetingGeoLocation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingGeoLocation.context = context;
    targetingGeoLocation.rawValue = json;
    return targetingGeoLocation;
  }

  public static APINodeList<TargetingGeoLocation> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<TargetingGeoLocation> targetingGeoLocations = new APINodeList<TargetingGeoLocation>(request, json);
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
          targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              targetingGeoLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  targetingGeoLocations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              targetingGeoLocations.add(loadJSON(obj.toString(), context));
            }
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
              targetingGeoLocations.add(loadJSON(value.toString(), context));
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
          targetingGeoLocations.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<TargetingGeoLocationCity> getFieldCities() {
    return mCities;
  }

  public List<String> getFieldCountries() {
    return mCountries;
  }

  public List<String> getFieldCountryGroups() {
    return mCountryGroups;
  }

  public List<TargetingGeoLocationCustomLocation> getFieldCustomLocations() {
    return mCustomLocations;
  }

  public List<TargetingGeoLocationElectoralDistrict> getFieldElectoralDistricts() {
    return mElectoralDistricts;
  }

  public List<TargetingGeoLocationMarket> getFieldGeoMarkets() {
    return mGeoMarkets;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldLargeGeoAreas() {
    return mLargeGeoAreas;
  }

  public List<TargetingGeoLocationLocationCluster> getFieldLocationClusterIds() {
    return mLocationClusterIds;
  }

  public List<String> getFieldLocationSetIds() {
    return mLocationSetIds;
  }

  public List<String> getFieldLocationTypes() {
    return mLocationTypes;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldMediumGeoAreas() {
    return mMediumGeoAreas;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldMetroAreas() {
    return mMetroAreas;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldNeighborhoods() {
    return mNeighborhoods;
  }

  public List<TargetingGeoLocationPlace> getFieldPlaces() {
    return mPlaces;
  }

  public List<TargetingGeoLocationPoliticalDistrict> getFieldPoliticalDistricts() {
    return mPoliticalDistricts;
  }

  public List<TargetingGeoLocationRegion> getFieldRegions() {
    return mRegions;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldSmallGeoAreas() {
    return mSmallGeoAreas;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldSubcities() {
    return mSubcities;
  }

  public List<TargetingGeoLocationGeoEntities> getFieldSubneighborhoods() {
    return mSubneighborhoods;
  }

  public List<TargetingGeoLocationZip> getFieldZips() {
    return mZips;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<TargetingGeoLocation> {

    TargetingGeoLocation lastResponse = null;
    @Override
    public TargetingGeoLocation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "cities",
      "countries",
      "country_groups",
      "custom_locations",
      "electoral_districts",
      "geo_markets",
      "large_geo_areas",
      "location_cluster_ids",
      "location_set_ids",
      "location_types",
      "medium_geo_areas",
      "metro_areas",
      "neighborhoods",
      "places",
      "political_districts",
      "regions",
      "small_geo_areas",
      "subcities",
      "subneighborhoods",
      "zips",
      "id",
    };

    @Override
    public TargetingGeoLocation parseResponse(String response) throws APIException {
      return TargetingGeoLocation.parseResponse(response, getContext(), this).head();
    }

    @Override
    public TargetingGeoLocation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public TargetingGeoLocation execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<TargetingGeoLocation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<TargetingGeoLocation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, TargetingGeoLocation>() {
           public TargetingGeoLocation apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestCitiesField () {
      return this.requestCitiesField(true);
    }
    public APIRequestGet requestCitiesField (boolean value) {
      this.requestField("cities", value);
      return this;
    }
    public APIRequestGet requestCountriesField () {
      return this.requestCountriesField(true);
    }
    public APIRequestGet requestCountriesField (boolean value) {
      this.requestField("countries", value);
      return this;
    }
    public APIRequestGet requestCountryGroupsField () {
      return this.requestCountryGroupsField(true);
    }
    public APIRequestGet requestCountryGroupsField (boolean value) {
      this.requestField("country_groups", value);
      return this;
    }
    public APIRequestGet requestCustomLocationsField () {
      return this.requestCustomLocationsField(true);
    }
    public APIRequestGet requestCustomLocationsField (boolean value) {
      this.requestField("custom_locations", value);
      return this;
    }
    public APIRequestGet requestElectoralDistrictsField () {
      return this.requestElectoralDistrictsField(true);
    }
    public APIRequestGet requestElectoralDistrictsField (boolean value) {
      this.requestField("electoral_districts", value);
      return this;
    }
    public APIRequestGet requestGeoMarketsField () {
      return this.requestGeoMarketsField(true);
    }
    public APIRequestGet requestGeoMarketsField (boolean value) {
      this.requestField("geo_markets", value);
      return this;
    }
    public APIRequestGet requestLargeGeoAreasField () {
      return this.requestLargeGeoAreasField(true);
    }
    public APIRequestGet requestLargeGeoAreasField (boolean value) {
      this.requestField("large_geo_areas", value);
      return this;
    }
    public APIRequestGet requestLocationClusterIdsField () {
      return this.requestLocationClusterIdsField(true);
    }
    public APIRequestGet requestLocationClusterIdsField (boolean value) {
      this.requestField("location_cluster_ids", value);
      return this;
    }
    public APIRequestGet requestLocationSetIdsField () {
      return this.requestLocationSetIdsField(true);
    }
    public APIRequestGet requestLocationSetIdsField (boolean value) {
      this.requestField("location_set_ids", value);
      return this;
    }
    public APIRequestGet requestLocationTypesField () {
      return this.requestLocationTypesField(true);
    }
    public APIRequestGet requestLocationTypesField (boolean value) {
      this.requestField("location_types", value);
      return this;
    }
    public APIRequestGet requestMediumGeoAreasField () {
      return this.requestMediumGeoAreasField(true);
    }
    public APIRequestGet requestMediumGeoAreasField (boolean value) {
      this.requestField("medium_geo_areas", value);
      return this;
    }
    public APIRequestGet requestMetroAreasField () {
      return this.requestMetroAreasField(true);
    }
    public APIRequestGet requestMetroAreasField (boolean value) {
      this.requestField("metro_areas", value);
      return this;
    }
    public APIRequestGet requestNeighborhoodsField () {
      return this.requestNeighborhoodsField(true);
    }
    public APIRequestGet requestNeighborhoodsField (boolean value) {
      this.requestField("neighborhoods", value);
      return this;
    }
    public APIRequestGet requestPlacesField () {
      return this.requestPlacesField(true);
    }
    public APIRequestGet requestPlacesField (boolean value) {
      this.requestField("places", value);
      return this;
    }
    public APIRequestGet requestPoliticalDistrictsField () {
      return this.requestPoliticalDistrictsField(true);
    }
    public APIRequestGet requestPoliticalDistrictsField (boolean value) {
      this.requestField("political_districts", value);
      return this;
    }
    public APIRequestGet requestRegionsField () {
      return this.requestRegionsField(true);
    }
    public APIRequestGet requestRegionsField (boolean value) {
      this.requestField("regions", value);
      return this;
    }
    public APIRequestGet requestSmallGeoAreasField () {
      return this.requestSmallGeoAreasField(true);
    }
    public APIRequestGet requestSmallGeoAreasField (boolean value) {
      this.requestField("small_geo_areas", value);
      return this;
    }
    public APIRequestGet requestSubcitiesField () {
      return this.requestSubcitiesField(true);
    }
    public APIRequestGet requestSubcitiesField (boolean value) {
      this.requestField("subcities", value);
      return this;
    }
    public APIRequestGet requestSubneighborhoodsField () {
      return this.requestSubneighborhoodsField(true);
    }
    public APIRequestGet requestSubneighborhoodsField (boolean value) {
      this.requestField("subneighborhoods", value);
      return this;
    }
    public APIRequestGet requestZipsField () {
      return this.requestZipsField(true);
    }
    public APIRequestGet requestZipsField (boolean value) {
      this.requestField("zips", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
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

  public TargetingGeoLocation copyFrom(TargetingGeoLocation instance) {
    this.mCities = instance.mCities;
    this.mCountries = instance.mCountries;
    this.mCountryGroups = instance.mCountryGroups;
    this.mCustomLocations = instance.mCustomLocations;
    this.mElectoralDistricts = instance.mElectoralDistricts;
    this.mGeoMarkets = instance.mGeoMarkets;
    this.mLargeGeoAreas = instance.mLargeGeoAreas;
    this.mLocationClusterIds = instance.mLocationClusterIds;
    this.mLocationSetIds = instance.mLocationSetIds;
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
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TargetingGeoLocation> getParser() {
    return new APIRequest.ResponseParser<TargetingGeoLocation>() {
      public APINodeList<TargetingGeoLocation> parseResponse(String response, APIContext context, APIRequest<TargetingGeoLocation> request) throws MalformedResponseException {
        return TargetingGeoLocation.parseResponse(response, context, request);
      }
    };
  }
}
