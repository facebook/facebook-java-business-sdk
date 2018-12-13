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
public class FoodDrinkOrder extends APINode {
  @SerializedName("admin_note")
  private String mAdminNote = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("customer_name")
  private String mCustomerName = null;
  @SerializedName("customer_phone_number")
  private String mCustomerPhoneNumber = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("note")
  private String mNote = null;
  @SerializedName("order_details")
  private List<Object> mOrderDetails = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  protected static Gson gson = null;

  FoodDrinkOrder() {
  }

  public FoodDrinkOrder(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FoodDrinkOrder(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FoodDrinkOrder fetch() throws APIException{
    FoodDrinkOrder newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FoodDrinkOrder fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FoodDrinkOrder> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FoodDrinkOrder fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FoodDrinkOrder> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FoodDrinkOrder> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FoodDrinkOrder>)(
      new APIRequest<FoodDrinkOrder>(context, "", "/", "GET", FoodDrinkOrder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FoodDrinkOrder>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FoodDrinkOrder.getParser())
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
  public static FoodDrinkOrder loadJSON(String json, APIContext context, String header) {
    FoodDrinkOrder foodDrinkOrder = getGson().fromJson(json, FoodDrinkOrder.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(foodDrinkOrder.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    foodDrinkOrder.context = context;
    foodDrinkOrder.rawValue = json;
    foodDrinkOrder.header = header;
    return foodDrinkOrder;
  }

  public static APINodeList<FoodDrinkOrder> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FoodDrinkOrder> foodDrinkOrders = new APINodeList<FoodDrinkOrder>(request, json, header);
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
          foodDrinkOrders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return foodDrinkOrders;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                foodDrinkOrders.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            foodDrinkOrders.setPaging(previous, next);
            if (context.hasAppSecret()) {
              foodDrinkOrders.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              foodDrinkOrders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  foodDrinkOrders.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              foodDrinkOrders.add(loadJSON(obj.toString(), context, header));
            }
          }
          return foodDrinkOrders;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              foodDrinkOrders.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return foodDrinkOrders;
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
              foodDrinkOrders.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return foodDrinkOrders;
          }

          // Sixth, check if it's pure JsonObject
          foodDrinkOrders.clear();
          foodDrinkOrders.add(loadJSON(json, context, header));
          return foodDrinkOrders;
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


  public String getFieldAdminNote() {
    return mAdminNote;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCustomerName() {
    return mCustomerName;
  }

  public String getFieldCustomerPhoneNumber() {
    return mCustomerPhoneNumber;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldNote() {
    return mNote;
  }

  public List<Object> getFieldOrderDetails() {
    return mOrderDetails;
  }

  public String getFieldState() {
    return mState;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }



  public static class APIRequestGet extends APIRequest<FoodDrinkOrder> {

    FoodDrinkOrder lastResponse = null;
    @Override
    public FoodDrinkOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "admin_note",
      "creation_time",
      "customer_name",
      "customer_phone_number",
      "id",
      "note",
      "order_details",
      "state",
      "update_time",
    };

    @Override
    public FoodDrinkOrder parseResponse(String response, String header) throws APIException {
      return FoodDrinkOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FoodDrinkOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FoodDrinkOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FoodDrinkOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FoodDrinkOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FoodDrinkOrder>() {
           public FoodDrinkOrder apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdminNoteField () {
      return this.requestAdminNoteField(true);
    }
    public APIRequestGet requestAdminNoteField (boolean value) {
      this.requestField("admin_note", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCustomerNameField () {
      return this.requestCustomerNameField(true);
    }
    public APIRequestGet requestCustomerNameField (boolean value) {
      this.requestField("customer_name", value);
      return this;
    }
    public APIRequestGet requestCustomerPhoneNumberField () {
      return this.requestCustomerPhoneNumberField(true);
    }
    public APIRequestGet requestCustomerPhoneNumberField (boolean value) {
      this.requestField("customer_phone_number", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNoteField () {
      return this.requestNoteField(true);
    }
    public APIRequestGet requestNoteField (boolean value) {
      this.requestField("note", value);
      return this;
    }
    public APIRequestGet requestOrderDetailsField () {
      return this.requestOrderDetailsField(true);
    }
    public APIRequestGet requestOrderDetailsField (boolean value) {
      this.requestField("order_details", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<FoodDrinkOrder> {

    FoodDrinkOrder lastResponse = null;
    @Override
    public FoodDrinkOrder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "state",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public FoodDrinkOrder parseResponse(String response, String header) throws APIException {
      return FoodDrinkOrder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FoodDrinkOrder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FoodDrinkOrder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FoodDrinkOrder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FoodDrinkOrder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FoodDrinkOrder>() {
           public FoodDrinkOrder apply(ResponseWrapper result) {
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


    public APIRequestUpdate setState (FoodDrinkOrder.EnumState state) {
      this.setParam("state", state);
      return this;
    }
    public APIRequestUpdate setState (String state) {
      this.setParam("state", state);
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

  public static enum EnumState {
      @SerializedName("CANCELLED")
      VALUE_CANCELLED("CANCELLED"),
      @SerializedName("CONFIRMED")
      VALUE_CONFIRMED("CONFIRMED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("ON_DELIVERY")
      VALUE_ON_DELIVERY("ON_DELIVERY"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("READY_FOR_PICKUP")
      VALUE_READY_FOR_PICKUP("READY_FOR_PICKUP"),
      @SerializedName("SERVING")
      VALUE_SERVING("SERVING"),
      NULL(null);

      private String value;

      private EnumState(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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

  public FoodDrinkOrder copyFrom(FoodDrinkOrder instance) {
    this.mAdminNote = instance.mAdminNote;
    this.mCreationTime = instance.mCreationTime;
    this.mCustomerName = instance.mCustomerName;
    this.mCustomerPhoneNumber = instance.mCustomerPhoneNumber;
    this.mId = instance.mId;
    this.mNote = instance.mNote;
    this.mOrderDetails = instance.mOrderDetails;
    this.mState = instance.mState;
    this.mUpdateTime = instance.mUpdateTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FoodDrinkOrder> getParser() {
    return new APIRequest.ResponseParser<FoodDrinkOrder>() {
      public APINodeList<FoodDrinkOrder> parseResponse(String response, APIContext context, APIRequest<FoodDrinkOrder> request, String header) throws MalformedResponseException {
        return FoodDrinkOrder.parseResponse(response, context, request, header);
      }
    };
  }
}
