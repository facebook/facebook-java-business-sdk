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
public class TargetingGeoLocationCustomLocation extends APINode {
  @SerializedName("address_string")
  private String mAddressString = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("country_group")
  private String mCountryGroup = null;
  @SerializedName("custom_type")
  private String mCustomType = null;
  @SerializedName("distance_unit")
  private String mDistanceUnit = null;
  @SerializedName("key")
  private String mKey = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("max_population")
  private Long mMaxPopulation = null;
  @SerializedName("min_population")
  private Long mMinPopulation = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("primary_city_id")
  private Long mPrimaryCityId = null;
  @SerializedName("radius")
  private Double mRadius = null;
  @SerializedName("region_id")
  private Long mRegionId = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  TargetingGeoLocationCustomLocation() {
  }

  public TargetingGeoLocationCustomLocation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public TargetingGeoLocationCustomLocation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public TargetingGeoLocationCustomLocation fetch() throws APIException{
    TargetingGeoLocationCustomLocation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static TargetingGeoLocationCustomLocation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<TargetingGeoLocationCustomLocation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static TargetingGeoLocationCustomLocation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<TargetingGeoLocationCustomLocation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<TargetingGeoLocationCustomLocation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<TargetingGeoLocationCustomLocation>)(
      new APIRequest<TargetingGeoLocationCustomLocation>(context, "", "/", "GET", TargetingGeoLocationCustomLocation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<TargetingGeoLocationCustomLocation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", TargetingGeoLocationCustomLocation.getParser())
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
  public static TargetingGeoLocationCustomLocation loadJSON(String json, APIContext context) {
    TargetingGeoLocationCustomLocation targetingGeoLocationCustomLocation = getGson().fromJson(json, TargetingGeoLocationCustomLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingGeoLocationCustomLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingGeoLocationCustomLocation.context = context;
    targetingGeoLocationCustomLocation.rawValue = json;
    return targetingGeoLocationCustomLocation;
  }

  public static APINodeList<TargetingGeoLocationCustomLocation> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<TargetingGeoLocationCustomLocation> targetingGeoLocationCustomLocations = new APINodeList<TargetingGeoLocationCustomLocation>(request, json);
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
          targetingGeoLocationCustomLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetingGeoLocationCustomLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                targetingGeoLocationCustomLocations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            targetingGeoLocationCustomLocations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              targetingGeoLocationCustomLocations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingGeoLocationCustomLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  targetingGeoLocationCustomLocations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              targetingGeoLocationCustomLocations.add(loadJSON(obj.toString(), context));
            }
          }
          return targetingGeoLocationCustomLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingGeoLocationCustomLocations.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetingGeoLocationCustomLocations;
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
              targetingGeoLocationCustomLocations.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return targetingGeoLocationCustomLocations;
          }

          // Sixth, check if it's pure JsonObject
          targetingGeoLocationCustomLocations.clear();
          targetingGeoLocationCustomLocations.add(loadJSON(json, context));
          return targetingGeoLocationCustomLocations;
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


  public String getFieldAddressString() {
    return mAddressString;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCountryGroup() {
    return mCountryGroup;
  }

  public String getFieldCustomType() {
    return mCustomType;
  }

  public String getFieldDistanceUnit() {
    return mDistanceUnit;
  }

  public String getFieldKey() {
    return mKey;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public Long getFieldMaxPopulation() {
    return mMaxPopulation;
  }

  public Long getFieldMinPopulation() {
    return mMinPopulation;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldPrimaryCityId() {
    return mPrimaryCityId;
  }

  public Double getFieldRadius() {
    return mRadius;
  }

  public Long getFieldRegionId() {
    return mRegionId;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<TargetingGeoLocationCustomLocation> {

    TargetingGeoLocationCustomLocation lastResponse = null;
    @Override
    public TargetingGeoLocationCustomLocation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address_string",
      "country",
      "country_group",
      "custom_type",
      "distance_unit",
      "key",
      "latitude",
      "longitude",
      "max_population",
      "min_population",
      "name",
      "primary_city_id",
      "radius",
      "region_id",
      "id",
    };

    @Override
    public TargetingGeoLocationCustomLocation parseResponse(String response) throws APIException {
      return TargetingGeoLocationCustomLocation.parseResponse(response, getContext(), this).head();
    }

    @Override
    public TargetingGeoLocationCustomLocation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public TargetingGeoLocationCustomLocation execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<TargetingGeoLocationCustomLocation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<TargetingGeoLocationCustomLocation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, TargetingGeoLocationCustomLocation>() {
           public TargetingGeoLocationCustomLocation apply(String result) {
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

    public APIRequestGet requestAddressStringField () {
      return this.requestAddressStringField(true);
    }
    public APIRequestGet requestAddressStringField (boolean value) {
      this.requestField("address_string", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCountryGroupField () {
      return this.requestCountryGroupField(true);
    }
    public APIRequestGet requestCountryGroupField (boolean value) {
      this.requestField("country_group", value);
      return this;
    }
    public APIRequestGet requestCustomTypeField () {
      return this.requestCustomTypeField(true);
    }
    public APIRequestGet requestCustomTypeField (boolean value) {
      this.requestField("custom_type", value);
      return this;
    }
    public APIRequestGet requestDistanceUnitField () {
      return this.requestDistanceUnitField(true);
    }
    public APIRequestGet requestDistanceUnitField (boolean value) {
      this.requestField("distance_unit", value);
      return this;
    }
    public APIRequestGet requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGet requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGet requestLatitudeField () {
      return this.requestLatitudeField(true);
    }
    public APIRequestGet requestLatitudeField (boolean value) {
      this.requestField("latitude", value);
      return this;
    }
    public APIRequestGet requestLongitudeField () {
      return this.requestLongitudeField(true);
    }
    public APIRequestGet requestLongitudeField (boolean value) {
      this.requestField("longitude", value);
      return this;
    }
    public APIRequestGet requestMaxPopulationField () {
      return this.requestMaxPopulationField(true);
    }
    public APIRequestGet requestMaxPopulationField (boolean value) {
      this.requestField("max_population", value);
      return this;
    }
    public APIRequestGet requestMinPopulationField () {
      return this.requestMinPopulationField(true);
    }
    public APIRequestGet requestMinPopulationField (boolean value) {
      this.requestField("min_population", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPrimaryCityIdField () {
      return this.requestPrimaryCityIdField(true);
    }
    public APIRequestGet requestPrimaryCityIdField (boolean value) {
      this.requestField("primary_city_id", value);
      return this;
    }
    public APIRequestGet requestRadiusField () {
      return this.requestRadiusField(true);
    }
    public APIRequestGet requestRadiusField (boolean value) {
      this.requestField("radius", value);
      return this;
    }
    public APIRequestGet requestRegionIdField () {
      return this.requestRegionIdField(true);
    }
    public APIRequestGet requestRegionIdField (boolean value) {
      this.requestField("region_id", value);
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

  public TargetingGeoLocationCustomLocation copyFrom(TargetingGeoLocationCustomLocation instance) {
    this.mAddressString = instance.mAddressString;
    this.mCountry = instance.mCountry;
    this.mCountryGroup = instance.mCountryGroup;
    this.mCustomType = instance.mCustomType;
    this.mDistanceUnit = instance.mDistanceUnit;
    this.mKey = instance.mKey;
    this.mLatitude = instance.mLatitude;
    this.mLongitude = instance.mLongitude;
    this.mMaxPopulation = instance.mMaxPopulation;
    this.mMinPopulation = instance.mMinPopulation;
    this.mName = instance.mName;
    this.mPrimaryCityId = instance.mPrimaryCityId;
    this.mRadius = instance.mRadius;
    this.mRegionId = instance.mRegionId;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TargetingGeoLocationCustomLocation> getParser() {
    return new APIRequest.ResponseParser<TargetingGeoLocationCustomLocation>() {
      public APINodeList<TargetingGeoLocationCustomLocation> parseResponse(String response, APIContext context, APIRequest<TargetingGeoLocationCustomLocation> request) throws MalformedResponseException {
        return TargetingGeoLocationCustomLocation.parseResponse(response, context, request);
      }
    };
  }
}
