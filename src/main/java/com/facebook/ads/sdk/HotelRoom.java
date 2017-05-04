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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class HotelRoom extends APINode {
  @SerializedName("applinks")
  private AppLinks mApplinks = null;
  @SerializedName("base_price")
  private String mBasePrice = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("margin_level")
  private String mMarginLevel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("room_id")
  private String mRoomId = null;
  @SerializedName("sale_price")
  private String mSalePrice = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  HotelRoom() {
  }

  public HotelRoom(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public HotelRoom(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public HotelRoom fetch() throws APIException{
    HotelRoom newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static HotelRoom fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static HotelRoom fetchById(String id, APIContext context) throws APIException {
    HotelRoom hotelRoom =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return hotelRoom;
  }

  public static APINodeList<HotelRoom> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<HotelRoom>)(
      new APIRequest<HotelRoom>(context, "", "/", "GET", HotelRoom.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static HotelRoom loadJSON(String json, APIContext context) {
    HotelRoom hotelRoom = getGson().fromJson(json, HotelRoom.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(hotelRoom.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    hotelRoom.context = context;
    hotelRoom.rawValue = json;
    return hotelRoom;
  }

  public static APINodeList<HotelRoom> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<HotelRoom> hotelRooms = new APINodeList<HotelRoom>(request, json);
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
          hotelRooms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return hotelRooms;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            hotelRooms.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              hotelRooms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  hotelRooms.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              hotelRooms.add(loadJSON(obj.toString(), context));
            }
          }
          return hotelRooms;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              hotelRooms.add(loadJSON(entry.getValue().toString(), context));
          }
          return hotelRooms;
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
              hotelRooms.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return hotelRooms;
          }

          // Sixth, check if it's pure JsonObject
          hotelRooms.clear();
          hotelRooms.add(loadJSON(json, context));
          return hotelRooms;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public AppLinks getFieldApplinks() {
    if (mApplinks != null) {
      mApplinks.context = getContext();
    }
    return mApplinks;
  }

  public String getFieldBasePrice() {
    return mBasePrice;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldMarginLevel() {
    return mMarginLevel;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldRoomId() {
    return mRoomId;
  }

  public String getFieldSalePrice() {
    return mSalePrice;
  }

  public String getFieldUrl() {
    return mUrl;
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

  public static class APIRequestGet extends APIRequest<HotelRoom> {

    HotelRoom lastResponse = null;
    @Override
    public HotelRoom getLastResponse() {
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
    public APIRequestGet requestBasePriceField () {
      return this.requestBasePriceField(true);
    }
    public APIRequestGet requestBasePriceField (boolean value) {
      this.requestField("base_price", value);
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
    public APIRequestGet requestRoomIdField () {
      return this.requestRoomIdField(true);
    }
    public APIRequestGet requestRoomIdField (boolean value) {
      this.requestField("room_id", value);
      return this;
    }
    public APIRequestGet requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGet requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
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

  public static class APIRequestUpdate extends APIRequest<HotelRoom> {

    HotelRoom lastResponse = null;
    @Override
    public HotelRoom getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "applinks",
      "base_price",
      "currency",
      "description",
      "images",
      "margin_level",
      "name",
      "pricing_variables",
      "sale_price",
      "url",
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


    public APIRequestUpdate setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestUpdate setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestUpdate setBasePrice (Double basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }
    public APIRequestUpdate setBasePrice (String basePrice) {
      this.setParam("base_price", basePrice);
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

    public APIRequestUpdate setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestUpdate setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestUpdate setMarginLevel (Long marginLevel) {
      this.setParam("margin_level", marginLevel);
      return this;
    }
    public APIRequestUpdate setMarginLevel (String marginLevel) {
      this.setParam("margin_level", marginLevel);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPricingVariables (List<Object> pricingVariables) {
      this.setParam("pricing_variables", pricingVariables);
      return this;
    }
    public APIRequestUpdate setPricingVariables (String pricingVariables) {
      this.setParam("pricing_variables", pricingVariables);
      return this;
    }

    public APIRequestUpdate setSalePrice (Double salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }
    public APIRequestUpdate setSalePrice (String salePrice) {
      this.setParam("sale_price", salePrice);
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

  public HotelRoom copyFrom(HotelRoom instance) {
    this.mApplinks = instance.mApplinks;
    this.mBasePrice = instance.mBasePrice;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mMarginLevel = instance.mMarginLevel;
    this.mName = instance.mName;
    this.mRoomId = instance.mRoomId;
    this.mSalePrice = instance.mSalePrice;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<HotelRoom> getParser() {
    return new APIRequest.ResponseParser<HotelRoom>() {
      public APINodeList<HotelRoom> parseResponse(String response, APIContext context, APIRequest<HotelRoom> request) throws MalformedResponseException {
        return HotelRoom.parseResponse(response, context, request);
      }
    };
  }
}
