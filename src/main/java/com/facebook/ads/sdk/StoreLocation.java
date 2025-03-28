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
public class StoreLocation extends APINode {
  @SerializedName("full_address")
  private String mFullAddress = null;
  @SerializedName("hours")
  private Object mHours = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("phone_number")
  private String mPhoneNumber = null;
  @SerializedName("pickup_options")
  private List<String> mPickupOptions = null;
  @SerializedName("price_range")
  private String mPriceRange = null;
  @SerializedName("store_code")
  private String mStoreCode = null;
  @SerializedName("zip_code")
  private String mZipCode = null;
  protected static Gson gson = null;

  StoreLocation() {
  }

  public StoreLocation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public StoreLocation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public StoreLocation fetch() throws APIException{
    StoreLocation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static StoreLocation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<StoreLocation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static StoreLocation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<StoreLocation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<StoreLocation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<StoreLocation>)(
      new APIRequest<StoreLocation>(context, "", "/", "GET", StoreLocation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<StoreLocation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", StoreLocation.getParser())
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
  public static StoreLocation loadJSON(String json, APIContext context, String header) {
    StoreLocation storeLocation = getGson().fromJson(json, StoreLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(storeLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    storeLocation.context = context;
    storeLocation.rawValue = json;
    storeLocation.header = header;
    return storeLocation;
  }

  public static APINodeList<StoreLocation> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<StoreLocation> storeLocations = new APINodeList<StoreLocation>(request, json, header);
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
          storeLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return storeLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                storeLocations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            storeLocations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              storeLocations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              storeLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  storeLocations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              storeLocations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return storeLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              storeLocations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return storeLocations;
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
              storeLocations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return storeLocations;
          }

          // Sixth, check if it's pure JsonObject
          storeLocations.clear();
          storeLocations.add(loadJSON(json, context, header));
          return storeLocations;
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


  public String getFieldFullAddress() {
    return mFullAddress;
  }

  public Object getFieldHours() {
    return mHours;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPhoneNumber() {
    return mPhoneNumber;
  }

  public List<String> getFieldPickupOptions() {
    return mPickupOptions;
  }

  public String getFieldPriceRange() {
    return mPriceRange;
  }

  public String getFieldStoreCode() {
    return mStoreCode;
  }

  public String getFieldZipCode() {
    return mZipCode;
  }



  public static class APIRequestGet extends APIRequest<StoreLocation> {

    StoreLocation lastResponse = null;
    @Override
    public StoreLocation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "full_address",
      "hours",
      "id",
      "phone_number",
      "pickup_options",
      "price_range",
      "store_code",
      "zip_code",
    };

    @Override
    public StoreLocation parseResponse(String response, String header) throws APIException {
      return StoreLocation.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public StoreLocation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public StoreLocation execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<StoreLocation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<StoreLocation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, StoreLocation>() {
           public StoreLocation apply(ResponseWrapper result) {
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

    public APIRequestGet requestFullAddressField () {
      return this.requestFullAddressField(true);
    }
    public APIRequestGet requestFullAddressField (boolean value) {
      this.requestField("full_address", value);
      return this;
    }
    public APIRequestGet requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGet requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGet requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGet requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGet requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGet requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGet requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGet requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGet requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGet requestZipCodeField () {
      return this.requestZipCodeField(true);
    }
    public APIRequestGet requestZipCodeField (boolean value) {
      this.requestField("zip_code", value);
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

  public StoreLocation copyFrom(StoreLocation instance) {
    this.mFullAddress = instance.mFullAddress;
    this.mHours = instance.mHours;
    this.mId = instance.mId;
    this.mPhoneNumber = instance.mPhoneNumber;
    this.mPickupOptions = instance.mPickupOptions;
    this.mPriceRange = instance.mPriceRange;
    this.mStoreCode = instance.mStoreCode;
    this.mZipCode = instance.mZipCode;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<StoreLocation> getParser() {
    return new APIRequest.ResponseParser<StoreLocation>() {
      public APINodeList<StoreLocation> parseResponse(String response, APIContext context, APIRequest<StoreLocation> request, String header) throws MalformedResponseException {
        return StoreLocation.parseResponse(response, context, request, header);
      }
    };
  }
}
