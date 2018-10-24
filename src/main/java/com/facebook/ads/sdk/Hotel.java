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
public class Hotel extends APINode {
  @SerializedName("address")
  private String mAddress = null;
  @SerializedName("applinks")
  private AppLinks mApplinks = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("guest_ratings")
  private String mGuestRatings = null;
  @SerializedName("hotel_id")
  private String mHotelId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("lowest_base_price")
  private String mLowestBasePrice = null;
  @SerializedName("loyalty_program")
  private String mLoyaltyProgram = null;
  @SerializedName("margin_level")
  private Long mMarginLevel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("phone")
  private String mPhone = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("star_rating")
  private Double mStarRating = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  Hotel() {
  }

  public Hotel(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Hotel(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Hotel fetch() throws APIException{
    Hotel newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Hotel fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Hotel> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Hotel fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Hotel> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Hotel> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Hotel>)(
      new APIRequest<Hotel>(context, "", "/", "GET", Hotel.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Hotel>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Hotel.getParser())
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
  public static Hotel loadJSON(String json, APIContext context) {
    Hotel hotel = getGson().fromJson(json, Hotel.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(hotel.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    hotel.context = context;
    hotel.rawValue = json;
    return hotel;
  }

  public static APINodeList<Hotel> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Hotel> hotels = new APINodeList<Hotel>(request, json);
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
          hotels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return hotels;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                hotels.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            hotels.setPaging(previous, next);
            if (context.hasAppSecret()) {
              hotels.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              hotels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  hotels.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              hotels.add(loadJSON(obj.toString(), context));
            }
          }
          return hotels;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              hotels.add(loadJSON(entry.getValue().toString(), context));
          }
          return hotels;
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
              hotels.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return hotels;
          }

          // Sixth, check if it's pure JsonObject
          hotels.clear();
          hotels.add(loadJSON(json, context));
          return hotels;
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

  public APIRequestGetHotelRooms getHotelRooms() {
    return new APIRequestGetHotelRooms(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateHotelRoom createHotelRoom() {
    return new APIRequestCreateHotelRoom(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAddress() {
    return mAddress;
  }

  public AppLinks getFieldApplinks() {
    if (mApplinks != null) {
      mApplinks.context = getContext();
    }
    return mApplinks;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldGuestRatings() {
    return mGuestRatings;
  }

  public String getFieldHotelId() {
    return mHotelId;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldLowestBasePrice() {
    return mLowestBasePrice;
  }

  public String getFieldLoyaltyProgram() {
    return mLoyaltyProgram;
  }

  public Long getFieldMarginLevel() {
    return mMarginLevel;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPhone() {
    return mPhone;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public Double getFieldStarRating() {
    return mStarRating;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGetHotelRooms extends APIRequest<HotelRoom> {

    APINodeList<HotelRoom> lastResponse = null;
    @Override
    public APINodeList<HotelRoom> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applinks",
      "base_price",
      "currency",
      "description",
      "id",
      "images",
      "margin_level",
      "name",
      "room_id",
      "sale_price",
      "url",
    };

    @Override
    public APINodeList<HotelRoom> parseResponse(String response) throws APIException {
      return HotelRoom.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<HotelRoom> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<HotelRoom> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<HotelRoom>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<HotelRoom>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<HotelRoom>>() {
           public APINodeList<HotelRoom> apply(String result) {
             try {
               return APIRequestGetHotelRooms.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetHotelRooms(String nodeId, APIContext context) {
      super(context, nodeId, "/hotel_rooms", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHotelRooms setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHotelRooms setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHotelRooms requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHotelRooms requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotelRooms requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHotelRooms requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotelRooms requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHotelRooms requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHotelRooms requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetHotelRooms requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetHotelRooms requestBasePriceField () {
      return this.requestBasePriceField(true);
    }
    public APIRequestGetHotelRooms requestBasePriceField (boolean value) {
      this.requestField("base_price", value);
      return this;
    }
    public APIRequestGetHotelRooms requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetHotelRooms requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetHotelRooms requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetHotelRooms requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetHotelRooms requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHotelRooms requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetHotelRooms requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetHotelRooms requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetHotelRooms requestMarginLevelField () {
      return this.requestMarginLevelField(true);
    }
    public APIRequestGetHotelRooms requestMarginLevelField (boolean value) {
      this.requestField("margin_level", value);
      return this;
    }
    public APIRequestGetHotelRooms requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetHotelRooms requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetHotelRooms requestRoomIdField () {
      return this.requestRoomIdField(true);
    }
    public APIRequestGetHotelRooms requestRoomIdField (boolean value) {
      this.requestField("room_id", value);
      return this;
    }
    public APIRequestGetHotelRooms requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetHotelRooms requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetHotelRooms requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetHotelRooms requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestCreateHotelRoom extends APIRequest<HotelRoom> {

    HotelRoom lastResponse = null;
    @Override
    public HotelRoom getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "room_id",
      "description",
      "name",
      "url",
      "currency",
      "base_price",
      "applinks",
      "images",
      "margin_level",
      "pricing_variables",
      "sale_price",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HotelRoom parseResponse(String response) throws APIException {
      return HotelRoom.parseResponse(response, getContext(), this).head();
    }

    @Override
    public HotelRoom execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HotelRoom execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<HotelRoom> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HotelRoom> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, HotelRoom>() {
           public HotelRoom apply(String result) {
             try {
               return APIRequestCreateHotelRoom.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateHotelRoom(String nodeId, APIContext context) {
      super(context, nodeId, "/hotel_rooms", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateHotelRoom setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateHotelRoom setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateHotelRoom setRoomId (String roomId) {
      this.setParam("room_id", roomId);
      return this;
    }

    public APIRequestCreateHotelRoom setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateHotelRoom setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateHotelRoom setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateHotelRoom setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateHotelRoom setBasePrice (Double basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }
    public APIRequestCreateHotelRoom setBasePrice (String basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }

    public APIRequestCreateHotelRoom setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestCreateHotelRoom setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestCreateHotelRoom setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestCreateHotelRoom setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestCreateHotelRoom setMarginLevel (Long marginLevel) {
      this.setParam("margin_level", marginLevel);
      return this;
    }
    public APIRequestCreateHotelRoom setMarginLevel (String marginLevel) {
      this.setParam("margin_level", marginLevel);
      return this;
    }

    public APIRequestCreateHotelRoom setPricingVariables (List<Object> pricingVariables) {
      this.setParam("pricing_variables", pricingVariables);
      return this;
    }
    public APIRequestCreateHotelRoom setPricingVariables (String pricingVariables) {
      this.setParam("pricing_variables", pricingVariables);
      return this;
    }

    public APIRequestCreateHotelRoom setSalePrice (Double salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }
    public APIRequestCreateHotelRoom setSalePrice (String salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }

    public APIRequestCreateHotelRoom requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateHotelRoom requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotelRoom requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateHotelRoom requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotelRoom requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateHotelRoom requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Hotel> {

    Hotel lastResponse = null;
    @Override
    public Hotel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "brand",
      "currency",
      "description",
      "guest_ratings",
      "hotel_id",
      "id",
      "images",
      "lowest_base_price",
      "loyalty_program",
      "margin_level",
      "name",
      "phone",
      "sanitized_images",
      "star_rating",
      "url",
    };

    @Override
    public Hotel parseResponse(String response) throws APIException {
      return Hotel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Hotel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Hotel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Hotel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Hotel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Hotel>() {
           public Hotel apply(String result) {
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

    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
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
    public APIRequestGet requestGuestRatingsField () {
      return this.requestGuestRatingsField(true);
    }
    public APIRequestGet requestGuestRatingsField (boolean value) {
      this.requestField("guest_ratings", value);
      return this;
    }
    public APIRequestGet requestHotelIdField () {
      return this.requestHotelIdField(true);
    }
    public APIRequestGet requestHotelIdField (boolean value) {
      this.requestField("hotel_id", value);
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
    public APIRequestGet requestLowestBasePriceField () {
      return this.requestLowestBasePriceField(true);
    }
    public APIRequestGet requestLowestBasePriceField (boolean value) {
      this.requestField("lowest_base_price", value);
      return this;
    }
    public APIRequestGet requestLoyaltyProgramField () {
      return this.requestLoyaltyProgramField(true);
    }
    public APIRequestGet requestLoyaltyProgramField (boolean value) {
      this.requestField("loyalty_program", value);
      return this;
    }
    public APIRequestGet requestMarginLevelField () {
      return this.requestMarginLevelField(true);
    }
    public APIRequestGet requestMarginLevelField (boolean value) {
      this.requestField("margin_level", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGet requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestStarRatingField () {
      return this.requestStarRatingField(true);
    }
    public APIRequestGet requestStarRatingField (boolean value) {
      this.requestField("star_rating", value);
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

  public static class APIRequestUpdate extends APIRequest<Hotel> {

    Hotel lastResponse = null;
    @Override
    public Hotel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address",
      "brand",
      "description",
      "name",
      "url",
      "images",
      "currency",
      "base_price",
      "applinks",
      "phone",
      "star_rating",
      "guest_ratings",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Hotel parseResponse(String response) throws APIException {
      return Hotel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Hotel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Hotel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Hotel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Hotel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Hotel>() {
           public Hotel apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setAddress (Object address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestUpdate setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestUpdate setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
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

    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setBasePrice (Long basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }
    public APIRequestUpdate setBasePrice (String basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }

    public APIRequestUpdate setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestUpdate setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestUpdate setPhone (String phone) {
      this.setParam("phone", phone);
      return this;
    }

    public APIRequestUpdate setStarRating (Double starRating) {
      this.setParam("star_rating", starRating);
      return this;
    }
    public APIRequestUpdate setStarRating (String starRating) {
      this.setParam("star_rating", starRating);
      return this;
    }

    public APIRequestUpdate setGuestRatings (List<Object> guestRatings) {
      this.setParam("guest_ratings", guestRatings);
      return this;
    }
    public APIRequestUpdate setGuestRatings (String guestRatings) {
      this.setParam("guest_ratings", guestRatings);
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

  public Hotel copyFrom(Hotel instance) {
    this.mAddress = instance.mAddress;
    this.mApplinks = instance.mApplinks;
    this.mBrand = instance.mBrand;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mGuestRatings = instance.mGuestRatings;
    this.mHotelId = instance.mHotelId;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mLowestBasePrice = instance.mLowestBasePrice;
    this.mLoyaltyProgram = instance.mLoyaltyProgram;
    this.mMarginLevel = instance.mMarginLevel;
    this.mName = instance.mName;
    this.mPhone = instance.mPhone;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mStarRating = instance.mStarRating;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Hotel> getParser() {
    return new APIRequest.ResponseParser<Hotel>() {
      public APINodeList<Hotel> parseResponse(String response, APIContext context, APIRequest<Hotel> request) throws MalformedResponseException {
        return Hotel.parseResponse(response, context, request);
      }
    };
  }
}
