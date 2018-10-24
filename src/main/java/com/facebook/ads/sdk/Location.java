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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  Location() {
  }

  public Location(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Location(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Location fetch() throws APIException{
    Location newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Location fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Location> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Location fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Location> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Location> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Location>)(
      new APIRequest<Location>(context, "", "/", "GET", Location.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Location>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Location.getParser())
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
  public static Location loadJSON(String json, APIContext context) {
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
      };
    }
    location.context = context;
    location.rawValue = json;
    return location;
  }

  public static APINodeList<Location> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Location> locations = new APINodeList<Location>(request, json);
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
          locations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              locations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  locations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              locations.add(loadJSON(obj.toString(), context));
            }
          }
          return locations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              locations.add(loadJSON(entry.getValue().toString(), context));
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
              locations.add(loadJSON(value.toString(), context));
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
          locations.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCity() {
    return mCity;
  }

  public Long getFieldCityId() {
    return mCityId;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCountryCode() {
    return mCountryCode;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public String getFieldLocatedIn() {
    return mLocatedIn;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public Long getFieldRegionId() {
    return mRegionId;
  }

  public String getFieldState() {
    return mState;
  }

  public String getFieldStreet() {
    return mStreet;
  }

  public String getFieldZip() {
    return mZip;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<Location> {

    Location lastResponse = null;
    @Override
    public Location getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "city",
      "city_id",
      "country",
      "country_code",
      "latitude",
      "located_in",
      "longitude",
      "name",
      "region",
      "region_id",
      "state",
      "street",
      "zip",
      "id",
    };

    @Override
    public Location parseResponse(String response) throws APIException {
      return Location.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Location execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Location execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Location> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Location> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Location>() {
           public Location apply(String result) {
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

    public APIRequestGet requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGet requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGet requestCityIdField () {
      return this.requestCityIdField(true);
    }
    public APIRequestGet requestCityIdField (boolean value) {
      this.requestField("city_id", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCountryCodeField () {
      return this.requestCountryCodeField(true);
    }
    public APIRequestGet requestCountryCodeField (boolean value) {
      this.requestField("country_code", value);
      return this;
    }
    public APIRequestGet requestLatitudeField () {
      return this.requestLatitudeField(true);
    }
    public APIRequestGet requestLatitudeField (boolean value) {
      this.requestField("latitude", value);
      return this;
    }
    public APIRequestGet requestLocatedInField () {
      return this.requestLocatedInField(true);
    }
    public APIRequestGet requestLocatedInField (boolean value) {
      this.requestField("located_in", value);
      return this;
    }
    public APIRequestGet requestLongitudeField () {
      return this.requestLongitudeField(true);
    }
    public APIRequestGet requestLongitudeField (boolean value) {
      this.requestField("longitude", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGet requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGet requestRegionIdField () {
      return this.requestRegionIdField(true);
    }
    public APIRequestGet requestRegionIdField (boolean value) {
      this.requestField("region_id", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGet requestStreetField () {
      return this.requestStreetField(true);
    }
    public APIRequestGet requestStreetField (boolean value) {
      this.requestField("street", value);
      return this;
    }
    public APIRequestGet requestZipField () {
      return this.requestZipField(true);
    }
    public APIRequestGet requestZipField (boolean value) {
      this.requestField("zip", value);
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
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Location> getParser() {
    return new APIRequest.ResponseParser<Location>() {
      public APINodeList<Location> parseResponse(String response, APIContext context, APIRequest<Location> request) throws MalformedResponseException {
        return Location.parseResponse(response, context, request);
      }
    };
  }
}
