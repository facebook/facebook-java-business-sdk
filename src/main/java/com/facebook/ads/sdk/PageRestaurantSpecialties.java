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
public class PageRestaurantSpecialties extends APINode {
  @SerializedName("breakfast")
  private Long mBreakfast = null;
  @SerializedName("coffee")
  private Long mCoffee = null;
  @SerializedName("dinner")
  private Long mDinner = null;
  @SerializedName("drinks")
  private Long mDrinks = null;
  @SerializedName("lunch")
  private Long mLunch = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  PageRestaurantSpecialties() {
  }

  public PageRestaurantSpecialties(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageRestaurantSpecialties(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PageRestaurantSpecialties fetch() throws APIException{
    PageRestaurantSpecialties newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageRestaurantSpecialties fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageRestaurantSpecialties> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageRestaurantSpecialties fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageRestaurantSpecialties> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PageRestaurantSpecialties> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageRestaurantSpecialties>)(
      new APIRequest<PageRestaurantSpecialties>(context, "", "/", "GET", PageRestaurantSpecialties.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageRestaurantSpecialties>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PageRestaurantSpecialties.getParser())
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
  public static PageRestaurantSpecialties loadJSON(String json, APIContext context) {
    PageRestaurantSpecialties pageRestaurantSpecialties = getGson().fromJson(json, PageRestaurantSpecialties.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageRestaurantSpecialties.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    pageRestaurantSpecialties.context = context;
    pageRestaurantSpecialties.rawValue = json;
    return pageRestaurantSpecialties;
  }

  public static APINodeList<PageRestaurantSpecialties> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PageRestaurantSpecialties> pageRestaurantSpecialtiess = new APINodeList<PageRestaurantSpecialties>(request, json);
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
          pageRestaurantSpecialtiess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pageRestaurantSpecialtiess;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageRestaurantSpecialtiess.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageRestaurantSpecialtiess.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageRestaurantSpecialtiess.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageRestaurantSpecialtiess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pageRestaurantSpecialtiess.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageRestaurantSpecialtiess.add(loadJSON(obj.toString(), context));
            }
          }
          return pageRestaurantSpecialtiess;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageRestaurantSpecialtiess.add(loadJSON(entry.getValue().toString(), context));
          }
          return pageRestaurantSpecialtiess;
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
              pageRestaurantSpecialtiess.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageRestaurantSpecialtiess;
          }

          // Sixth, check if it's pure JsonObject
          pageRestaurantSpecialtiess.clear();
          pageRestaurantSpecialtiess.add(loadJSON(json, context));
          return pageRestaurantSpecialtiess;
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


  public Long getFieldBreakfast() {
    return mBreakfast;
  }

  public Long getFieldCoffee() {
    return mCoffee;
  }

  public Long getFieldDinner() {
    return mDinner;
  }

  public Long getFieldDrinks() {
    return mDrinks;
  }

  public Long getFieldLunch() {
    return mLunch;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<PageRestaurantSpecialties> {

    PageRestaurantSpecialties lastResponse = null;
    @Override
    public PageRestaurantSpecialties getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "breakfast",
      "coffee",
      "dinner",
      "drinks",
      "lunch",
      "id",
    };

    @Override
    public PageRestaurantSpecialties parseResponse(String response) throws APIException {
      return PageRestaurantSpecialties.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageRestaurantSpecialties execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageRestaurantSpecialties execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageRestaurantSpecialties> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageRestaurantSpecialties> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageRestaurantSpecialties>() {
           public PageRestaurantSpecialties apply(String result) {
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

    public APIRequestGet requestBreakfastField () {
      return this.requestBreakfastField(true);
    }
    public APIRequestGet requestBreakfastField (boolean value) {
      this.requestField("breakfast", value);
      return this;
    }
    public APIRequestGet requestCoffeeField () {
      return this.requestCoffeeField(true);
    }
    public APIRequestGet requestCoffeeField (boolean value) {
      this.requestField("coffee", value);
      return this;
    }
    public APIRequestGet requestDinnerField () {
      return this.requestDinnerField(true);
    }
    public APIRequestGet requestDinnerField (boolean value) {
      this.requestField("dinner", value);
      return this;
    }
    public APIRequestGet requestDrinksField () {
      return this.requestDrinksField(true);
    }
    public APIRequestGet requestDrinksField (boolean value) {
      this.requestField("drinks", value);
      return this;
    }
    public APIRequestGet requestLunchField () {
      return this.requestLunchField(true);
    }
    public APIRequestGet requestLunchField (boolean value) {
      this.requestField("lunch", value);
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

  public PageRestaurantSpecialties copyFrom(PageRestaurantSpecialties instance) {
    this.mBreakfast = instance.mBreakfast;
    this.mCoffee = instance.mCoffee;
    this.mDinner = instance.mDinner;
    this.mDrinks = instance.mDrinks;
    this.mLunch = instance.mLunch;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageRestaurantSpecialties> getParser() {
    return new APIRequest.ResponseParser<PageRestaurantSpecialties>() {
      public APINodeList<PageRestaurantSpecialties> parseResponse(String response, APIContext context, APIRequest<PageRestaurantSpecialties> request) throws MalformedResponseException {
        return PageRestaurantSpecialties.parseResponse(response, context, request);
      }
    };
  }
}
