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
public class AdSavedLocation extends APINode {
  @SerializedName("cities")
  private List<TargetingGeoLocationCity> mCities = null;
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("country_groups")
  private List<String> mCountryGroups = null;
  @SerializedName("custom_locations")
  private List<TargetingGeoLocationCustomLocation> mCustomLocations = null;
  @SerializedName("geo_markets")
  private List<TargetingGeoLocationMarket> mGeoMarkets = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("location_sentences")
  private List<String> mLocationSentences = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("regions")
  private List<TargetingGeoLocationRegion> mRegions = null;
  @SerializedName("zips")
  private List<TargetingGeoLocationZip> mZips = null;
  protected static Gson gson = null;

  AdSavedLocation() {
  }

  public AdSavedLocation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdSavedLocation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdSavedLocation fetch() throws APIException{
    AdSavedLocation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdSavedLocation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdSavedLocation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdSavedLocation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdSavedLocation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdSavedLocation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdSavedLocation>)(
      new APIRequest<AdSavedLocation>(context, "", "/", "GET", AdSavedLocation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdSavedLocation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdSavedLocation.getParser())
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
  public static AdSavedLocation loadJSON(String json, APIContext context, String header) {
    AdSavedLocation adSavedLocation = getGson().fromJson(json, AdSavedLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adSavedLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adSavedLocation.context = context;
    adSavedLocation.rawValue = json;
    adSavedLocation.header = header;
    return adSavedLocation;
  }

  public static APINodeList<AdSavedLocation> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdSavedLocation> adSavedLocations = new APINodeList<AdSavedLocation>(request, json, header);
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
          adSavedLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adSavedLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adSavedLocations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adSavedLocations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adSavedLocations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adSavedLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adSavedLocations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adSavedLocations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adSavedLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adSavedLocations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adSavedLocations;
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
              adSavedLocations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adSavedLocations;
          }

          // Sixth, check if it's pure JsonObject
          adSavedLocations.clear();
          adSavedLocations.add(loadJSON(json, context, header));
          return adSavedLocations;
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

  public List<TargetingGeoLocationMarket> getFieldGeoMarkets() {
    return mGeoMarkets;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldLocationSentences() {
    return mLocationSentences;
  }

  public String getFieldName() {
    return mName;
  }

  public List<TargetingGeoLocationRegion> getFieldRegions() {
    return mRegions;
  }

  public List<TargetingGeoLocationZip> getFieldZips() {
    return mZips;
  }



  public static class APIRequestGet extends APIRequest<AdSavedLocation> {

    AdSavedLocation lastResponse = null;
    @Override
    public AdSavedLocation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "cities",
      "countries",
      "country_groups",
      "custom_locations",
      "geo_markets",
      "id",
      "location_sentences",
      "name",
      "regions",
      "zips",
    };

    @Override
    public AdSavedLocation parseResponse(String response, String header) throws APIException {
      return AdSavedLocation.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSavedLocation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSavedLocation execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSavedLocation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSavedLocation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSavedLocation>() {
           public AdSavedLocation apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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
    public APIRequestGet requestGeoMarketsField () {
      return this.requestGeoMarketsField(true);
    }
    public APIRequestGet requestGeoMarketsField (boolean value) {
      this.requestField("geo_markets", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLocationSentencesField () {
      return this.requestLocationSentencesField(true);
    }
    public APIRequestGet requestLocationSentencesField (boolean value) {
      this.requestField("location_sentences", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestRegionsField () {
      return this.requestRegionsField(true);
    }
    public APIRequestGet requestRegionsField (boolean value) {
      this.requestField("regions", value);
      return this;
    }
    public APIRequestGet requestZipsField () {
      return this.requestZipsField(true);
    }
    public APIRequestGet requestZipsField (boolean value) {
      this.requestField("zips", value);
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

  public AdSavedLocation copyFrom(AdSavedLocation instance) {
    this.mCities = instance.mCities;
    this.mCountries = instance.mCountries;
    this.mCountryGroups = instance.mCountryGroups;
    this.mCustomLocations = instance.mCustomLocations;
    this.mGeoMarkets = instance.mGeoMarkets;
    this.mId = instance.mId;
    this.mLocationSentences = instance.mLocationSentences;
    this.mName = instance.mName;
    this.mRegions = instance.mRegions;
    this.mZips = instance.mZips;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdSavedLocation> getParser() {
    return new APIRequest.ResponseParser<AdSavedLocation>() {
      public APINodeList<AdSavedLocation> parseResponse(String response, APIContext context, APIRequest<AdSavedLocation> request, String header) throws MalformedResponseException {
        return AdSavedLocation.parseResponse(response, context, request, header);
      }
    };
  }
}
