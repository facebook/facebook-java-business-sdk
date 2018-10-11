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
public class Currency extends APINode {
  @SerializedName("currency_exchange")
  private Double mCurrencyExchange = null;
  @SerializedName("currency_exchange_inverse")
  private Double mCurrencyExchangeInverse = null;
  @SerializedName("currency_offset")
  private Long mCurrencyOffset = null;
  @SerializedName("usd_exchange")
  private Double mUsdExchange = null;
  @SerializedName("usd_exchange_inverse")
  private Double mUsdExchangeInverse = null;
  @SerializedName("user_currency")
  private String mUserCurrency = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  Currency() {
  }

  public Currency(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Currency(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Currency fetch() throws APIException{
    Currency newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Currency fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Currency> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Currency fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Currency> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Currency> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Currency>)(
      new APIRequest<Currency>(context, "", "/", "GET", Currency.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Currency>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Currency.getParser())
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
  public static Currency loadJSON(String json, APIContext context) {
    Currency currency = getGson().fromJson(json, Currency.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(currency.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    currency.context = context;
    currency.rawValue = json;
    return currency;
  }

  public static APINodeList<Currency> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Currency> currencys = new APINodeList<Currency>(request, json);
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
          currencys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return currencys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                currencys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            currencys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              currencys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              currencys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  currencys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              currencys.add(loadJSON(obj.toString(), context));
            }
          }
          return currencys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              currencys.add(loadJSON(entry.getValue().toString(), context));
          }
          return currencys;
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
              currencys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return currencys;
          }

          // Sixth, check if it's pure JsonObject
          currencys.clear();
          currencys.add(loadJSON(json, context));
          return currencys;
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


  public Double getFieldCurrencyExchange() {
    return mCurrencyExchange;
  }

  public Double getFieldCurrencyExchangeInverse() {
    return mCurrencyExchangeInverse;
  }

  public Long getFieldCurrencyOffset() {
    return mCurrencyOffset;
  }

  public Double getFieldUsdExchange() {
    return mUsdExchange;
  }

  public Double getFieldUsdExchangeInverse() {
    return mUsdExchangeInverse;
  }

  public String getFieldUserCurrency() {
    return mUserCurrency;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<Currency> {

    Currency lastResponse = null;
    @Override
    public Currency getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "currency_exchange",
      "currency_exchange_inverse",
      "currency_offset",
      "usd_exchange",
      "usd_exchange_inverse",
      "user_currency",
      "id",
    };

    @Override
    public Currency parseResponse(String response) throws APIException {
      return Currency.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Currency execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Currency execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Currency> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Currency> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Currency>() {
           public Currency apply(String result) {
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

    public APIRequestGet requestCurrencyExchangeField () {
      return this.requestCurrencyExchangeField(true);
    }
    public APIRequestGet requestCurrencyExchangeField (boolean value) {
      this.requestField("currency_exchange", value);
      return this;
    }
    public APIRequestGet requestCurrencyExchangeInverseField () {
      return this.requestCurrencyExchangeInverseField(true);
    }
    public APIRequestGet requestCurrencyExchangeInverseField (boolean value) {
      this.requestField("currency_exchange_inverse", value);
      return this;
    }
    public APIRequestGet requestCurrencyOffsetField () {
      return this.requestCurrencyOffsetField(true);
    }
    public APIRequestGet requestCurrencyOffsetField (boolean value) {
      this.requestField("currency_offset", value);
      return this;
    }
    public APIRequestGet requestUsdExchangeField () {
      return this.requestUsdExchangeField(true);
    }
    public APIRequestGet requestUsdExchangeField (boolean value) {
      this.requestField("usd_exchange", value);
      return this;
    }
    public APIRequestGet requestUsdExchangeInverseField () {
      return this.requestUsdExchangeInverseField(true);
    }
    public APIRequestGet requestUsdExchangeInverseField (boolean value) {
      this.requestField("usd_exchange_inverse", value);
      return this;
    }
    public APIRequestGet requestUserCurrencyField () {
      return this.requestUserCurrencyField(true);
    }
    public APIRequestGet requestUserCurrencyField (boolean value) {
      this.requestField("user_currency", value);
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

  public Currency copyFrom(Currency instance) {
    this.mCurrencyExchange = instance.mCurrencyExchange;
    this.mCurrencyExchangeInverse = instance.mCurrencyExchangeInverse;
    this.mCurrencyOffset = instance.mCurrencyOffset;
    this.mUsdExchange = instance.mUsdExchange;
    this.mUsdExchangeInverse = instance.mUsdExchangeInverse;
    this.mUserCurrency = instance.mUserCurrency;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Currency> getParser() {
    return new APIRequest.ResponseParser<Currency>() {
      public APINodeList<Currency> parseResponse(String response, APIContext context, APIRequest<Currency> request) throws MalformedResponseException {
        return Currency.parseResponse(response, context, request);
      }
    };
  }
}
