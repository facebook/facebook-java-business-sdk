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
public class Flight extends APINode {
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("destination_airport")
  private String mDestinationAirport = null;
  @SerializedName("destination_city")
  private String mDestinationCity = null;
  @SerializedName("flight_id")
  private String mFlightId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("oneway_currency")
  private String mOnewayCurrency = null;
  @SerializedName("oneway_price")
  private String mOnewayPrice = null;
  @SerializedName("origin_airport")
  private String mOriginAirport = null;
  @SerializedName("origin_city")
  private String mOriginCity = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  Flight() {
  }

  public Flight(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Flight(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Flight fetch() throws APIException{
    Flight newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Flight fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Flight> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Flight fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Flight> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Flight> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Flight>)(
      new APIRequest<Flight>(context, "", "/", "GET", Flight.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Flight>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Flight.getParser())
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
  public static Flight loadJSON(String json, APIContext context, String header) {
    Flight flight = getGson().fromJson(json, Flight.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(flight.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    flight.context = context;
    flight.rawValue = json;
    flight.header = header;
    return flight;
  }

  public static APINodeList<Flight> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Flight> flights = new APINodeList<Flight>(request, json, header);
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
          flights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return flights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                flights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            flights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              flights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              flights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  flights.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              flights.add(loadJSON(obj.toString(), context, header));
            }
          }
          return flights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              flights.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return flights;
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
              flights.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return flights;
          }

          // Sixth, check if it's pure JsonObject
          flights.clear();
          flights.add(loadJSON(json, context, header));
          return flights;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDestinationAirport() {
    return mDestinationAirport;
  }

  public String getFieldDestinationCity() {
    return mDestinationCity;
  }

  public String getFieldFlightId() {
    return mFlightId;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldOnewayCurrency() {
    return mOnewayCurrency;
  }

  public String getFieldOnewayPrice() {
    return mOnewayPrice;
  }

  public String getFieldOriginAirport() {
    return mOriginAirport;
  }

  public String getFieldOriginCity() {
    return mOriginCity;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGet extends APIRequest<Flight> {

    Flight lastResponse = null;
    @Override
    public Flight getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applinks",
      "category_specific_fields",
      "currency",
      "description",
      "destination_airport",
      "destination_city",
      "flight_id",
      "id",
      "images",
      "oneway_currency",
      "oneway_price",
      "origin_airport",
      "origin_city",
      "price",
      "sanitized_images",
      "url",
    };

    @Override
    public Flight parseResponse(String response, String header) throws APIException {
      return Flight.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Flight execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Flight execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Flight> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Flight> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Flight>() {
           public Flight apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDestinationAirportField () {
      return this.requestDestinationAirportField(true);
    }
    public APIRequestGet requestDestinationAirportField (boolean value) {
      this.requestField("destination_airport", value);
      return this;
    }
    public APIRequestGet requestDestinationCityField () {
      return this.requestDestinationCityField(true);
    }
    public APIRequestGet requestDestinationCityField (boolean value) {
      this.requestField("destination_city", value);
      return this;
    }
    public APIRequestGet requestFlightIdField () {
      return this.requestFlightIdField(true);
    }
    public APIRequestGet requestFlightIdField (boolean value) {
      this.requestField("flight_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestOnewayCurrencyField () {
      return this.requestOnewayCurrencyField(true);
    }
    public APIRequestGet requestOnewayCurrencyField (boolean value) {
      this.requestField("oneway_currency", value);
      return this;
    }
    public APIRequestGet requestOnewayPriceField () {
      return this.requestOnewayPriceField(true);
    }
    public APIRequestGet requestOnewayPriceField (boolean value) {
      this.requestField("oneway_price", value);
      return this;
    }
    public APIRequestGet requestOriginAirportField () {
      return this.requestOriginAirportField(true);
    }
    public APIRequestGet requestOriginAirportField (boolean value) {
      this.requestField("origin_airport", value);
      return this;
    }
    public APIRequestGet requestOriginCityField () {
      return this.requestOriginCityField(true);
    }
    public APIRequestGet requestOriginCityField (boolean value) {
      this.requestField("origin_city", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Flight> {

    Flight lastResponse = null;
    @Override
    public Flight getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "currency",
      "description",
      "destination_airport",
      "images",
      "origin_airport",
      "price",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Flight parseResponse(String response, String header) throws APIException {
      return Flight.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Flight execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Flight execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Flight> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Flight> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Flight>() {
           public Flight apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setDestinationAirport (String destinationAirport) {
      this.setParam("destination_airport", destinationAirport);
      return this;
    }

    public APIRequestUpdate setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestUpdate setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestUpdate setOriginAirport (String originAirport) {
      this.setParam("origin_airport", originAirport);
      return this;
    }

    public APIRequestUpdate setPrice (Long price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestUpdate setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public Flight copyFrom(Flight instance) {
    this.mApplinks = instance.mApplinks;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mDestinationAirport = instance.mDestinationAirport;
    this.mDestinationCity = instance.mDestinationCity;
    this.mFlightId = instance.mFlightId;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mOnewayCurrency = instance.mOnewayCurrency;
    this.mOnewayPrice = instance.mOnewayPrice;
    this.mOriginAirport = instance.mOriginAirport;
    this.mOriginCity = instance.mOriginCity;
    this.mPrice = instance.mPrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Flight> getParser() {
    return new APIRequest.ResponseParser<Flight>() {
      public APINodeList<Flight> parseResponse(String response, APIContext context, APIRequest<Flight> request, String header) throws MalformedResponseException {
        return Flight.parseResponse(response, context, request, header);
      }
    };
  }
}
