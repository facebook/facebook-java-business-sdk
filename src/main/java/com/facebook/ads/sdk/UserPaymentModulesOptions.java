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
public class UserPaymentModulesOptions extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("available_payment_options")
  private List<Object> mAvailablePaymentOptions = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  UserPaymentModulesOptions() {
  }

  public UserPaymentModulesOptions(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UserPaymentModulesOptions(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public UserPaymentModulesOptions fetch() throws APIException{
    UserPaymentModulesOptions newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UserPaymentModulesOptions fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UserPaymentModulesOptions> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UserPaymentModulesOptions fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<UserPaymentModulesOptions> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<UserPaymentModulesOptions> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UserPaymentModulesOptions>)(
      new APIRequest<UserPaymentModulesOptions>(context, "", "/", "GET", UserPaymentModulesOptions.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UserPaymentModulesOptions>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", UserPaymentModulesOptions.getParser())
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
  public static UserPaymentModulesOptions loadJSON(String json, APIContext context) {
    UserPaymentModulesOptions userPaymentModulesOptions = getGson().fromJson(json, UserPaymentModulesOptions.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(userPaymentModulesOptions.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    userPaymentModulesOptions.context = context;
    userPaymentModulesOptions.rawValue = json;
    return userPaymentModulesOptions;
  }

  public static APINodeList<UserPaymentModulesOptions> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<UserPaymentModulesOptions> userPaymentModulesOptionss = new APINodeList<UserPaymentModulesOptions>(request, json);
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
          userPaymentModulesOptionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return userPaymentModulesOptionss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                userPaymentModulesOptionss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            userPaymentModulesOptionss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              userPaymentModulesOptionss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              userPaymentModulesOptionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  userPaymentModulesOptionss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              userPaymentModulesOptionss.add(loadJSON(obj.toString(), context));
            }
          }
          return userPaymentModulesOptionss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              userPaymentModulesOptionss.add(loadJSON(entry.getValue().toString(), context));
          }
          return userPaymentModulesOptionss;
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
              userPaymentModulesOptionss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return userPaymentModulesOptionss;
          }

          // Sixth, check if it's pure JsonObject
          userPaymentModulesOptionss.clear();
          userPaymentModulesOptionss.add(loadJSON(json, context));
          return userPaymentModulesOptionss;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public List<Object> getFieldAvailablePaymentOptions() {
    return mAvailablePaymentOptions;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<UserPaymentModulesOptions> {

    UserPaymentModulesOptions lastResponse = null;
    @Override
    public UserPaymentModulesOptions getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "country_code",
      "extra_data",
      "order_id",
      "payment_type",
      "receiver_id",
      "session_id",
    };

    public static final String[] FIELDS = {
      "account_id",
      "available_payment_options",
      "country",
      "currency",
      "id",
    };

    @Override
    public UserPaymentModulesOptions parseResponse(String response) throws APIException {
      return UserPaymentModulesOptions.parseResponse(response, getContext(), this).head();
    }

    @Override
    public UserPaymentModulesOptions execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UserPaymentModulesOptions execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<UserPaymentModulesOptions> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UserPaymentModulesOptions> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, UserPaymentModulesOptions>() {
           public UserPaymentModulesOptions apply(String result) {
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


    public APIRequestGet setCountryCode (String countryCode) {
      this.setParam("country_code", countryCode);
      return this;
    }

    public APIRequestGet setExtraData (String extraData) {
      this.setParam("extra_data", extraData);
      return this;
    }

    public APIRequestGet setOrderId (String orderId) {
      this.setParam("order_id", orderId);
      return this;
    }

    public APIRequestGet setPaymentType (EnumPaymentType paymentType) {
      this.setParam("payment_type", paymentType);
      return this;
    }
    public APIRequestGet setPaymentType (String paymentType) {
      this.setParam("payment_type", paymentType);
      return this;
    }

    public APIRequestGet setReceiverId (Object receiverId) {
      this.setParam("receiver_id", receiverId);
      return this;
    }
    public APIRequestGet setReceiverId (String receiverId) {
      this.setParam("receiver_id", receiverId);
      return this;
    }

    public APIRequestGet setSessionId (String sessionId) {
      this.setParam("session_id", sessionId);
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAvailablePaymentOptionsField () {
      return this.requestAvailablePaymentOptionsField(true);
    }
    public APIRequestGet requestAvailablePaymentOptionsField (boolean value) {
      this.requestField("available_payment_options", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
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

  public static enum EnumPaymentType {
      @SerializedName("PAYMENT_SETTINGS")
      VALUE_PAYMENT_SETTINGS("PAYMENT_SETTINGS"),
      @SerializedName("IG_PAYMENT_SETTINGS")
      VALUE_IG_PAYMENT_SETTINGS("IG_PAYMENT_SETTINGS"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("MP_PAYMENT_SETTINGS")
      VALUE_MP_PAYMENT_SETTINGS("MP_PAYMENT_SETTINGS"),
      @SerializedName("IAP_INSTANT_GAME")
      VALUE_IAP_INSTANT_GAME("IAP_INSTANT_GAME"),
      @SerializedName("IAP_FAN_FUNDING")
      VALUE_IAP_FAN_FUNDING("IAP_FAN_FUNDING"),
      @SerializedName("IAP_GROUP_SUBSCRIPTION")
      VALUE_IAP_GROUP_SUBSCRIPTION("IAP_GROUP_SUBSCRIPTION"),
      @SerializedName("MOR_NONE")
      VALUE_MOR_NONE("MOR_NONE"),
      @SerializedName("MOR_ADS_CONSENT")
      VALUE_MOR_ADS_CONSENT("MOR_ADS_CONSENT"),
      @SerializedName("MOR_ADS_INVOICE")
      VALUE_MOR_ADS_INVOICE("MOR_ADS_INVOICE"),
      @SerializedName("MOR_DONATIONS")
      VALUE_MOR_DONATIONS("MOR_DONATIONS"),
      @SerializedName("MOR_DONATIONS_MATCHING_CONFIRMATION")
      VALUE_MOR_DONATIONS_MATCHING_CONFIRMATION("MOR_DONATIONS_MATCHING_CONFIRMATION"),
      @SerializedName("MOR_DONATIONS_MATCHING_PLEDGE")
      VALUE_MOR_DONATIONS_MATCHING_PLEDGE("MOR_DONATIONS_MATCHING_PLEDGE"),
      @SerializedName("MOR_OCULUS_CV1")
      VALUE_MOR_OCULUS_CV1("MOR_OCULUS_CV1"),
      @SerializedName("MOR_OCULUS_LAUNCH_V1")
      VALUE_MOR_OCULUS_LAUNCH_V1("MOR_OCULUS_LAUNCH_V1"),
      @SerializedName("MOR_OCULUS_LAUNCH_V2")
      VALUE_MOR_OCULUS_LAUNCH_V2("MOR_OCULUS_LAUNCH_V2"),
      @SerializedName("MOR_OZONE")
      VALUE_MOR_OZONE("MOR_OZONE"),
      @SerializedName("MOR_OPEN_GRAPH_PRODUCT")
      VALUE_MOR_OPEN_GRAPH_PRODUCT("MOR_OPEN_GRAPH_PRODUCT"),
      @SerializedName("MOR_MESSENGER_COMMERCE")
      VALUE_MOR_MESSENGER_COMMERCE("MOR_MESSENGER_COMMERCE"),
      @SerializedName("MOR_P2P_TRANSFER")
      VALUE_MOR_P2P_TRANSFER("MOR_P2P_TRANSFER"),
      @SerializedName("MOR_DUMMY_FIRST_PARTY")
      VALUE_MOR_DUMMY_FIRST_PARTY("MOR_DUMMY_FIRST_PARTY"),
      @SerializedName("MOR_DUMMY_THIRD_PARTY")
      VALUE_MOR_DUMMY_THIRD_PARTY("MOR_DUMMY_THIRD_PARTY"),
      @SerializedName("MOR_GIFTS")
      VALUE_MOR_GIFTS("MOR_GIFTS"),
      @SerializedName("MOR_BILL")
      VALUE_MOR_BILL("MOR_BILL"),
      @SerializedName("MOR_AIRMAIL")
      VALUE_MOR_AIRMAIL("MOR_AIRMAIL"),
      @SerializedName("MOR_EVENT_TICKETING")
      VALUE_MOR_EVENT_TICKETING("MOR_EVENT_TICKETING"),
      @SerializedName("MOR_PAYMENT_LITE")
      VALUE_MOR_PAYMENT_LITE("MOR_PAYMENT_LITE"),
      @SerializedName("MOR_MESSENGER_API_FEE")
      VALUE_MOR_MESSENGER_API_FEE("MOR_MESSENGER_API_FEE"),
      @SerializedName("MOR_WORKPLACE_USAGE")
      VALUE_MOR_WORKPLACE_USAGE("MOR_WORKPLACE_USAGE"),
      @SerializedName("MOR_FACEBOOK_SHOP")
      VALUE_MOR_FACEBOOK_SHOP("MOR_FACEBOOK_SHOP"),
      @SerializedName("MOR_FAN_FUNDING")
      VALUE_MOR_FAN_FUNDING("MOR_FAN_FUNDING"),
      @SerializedName("MOR_GAME_TIPPING_TOKEN")
      VALUE_MOR_GAME_TIPPING_TOKEN("MOR_GAME_TIPPING_TOKEN"),
      @SerializedName("MOR_INSTANT_GAMES")
      VALUE_MOR_INSTANT_GAMES("MOR_INSTANT_GAMES"),
      @SerializedName("MOR_BLUEBIRD")
      VALUE_MOR_BLUEBIRD("MOR_BLUEBIRD"),
      @SerializedName("MOR_GROUP_SUBSCRIPTION")
      VALUE_MOR_GROUP_SUBSCRIPTION("MOR_GROUP_SUBSCRIPTION"),
      @SerializedName("NMOR_UNKNOWN")
      VALUE_NMOR_UNKNOWN("NMOR_UNKNOWN"),
      @SerializedName("NMOR_NONE")
      VALUE_NMOR_NONE("NMOR_NONE"),
      @SerializedName("NMOR_PAGES_COMMERCE")
      VALUE_NMOR_PAGES_COMMERCE("NMOR_PAGES_COMMERCE"),
      @SerializedName("NMOR_COMPONENT_FLOW")
      VALUE_NMOR_COMPONENT_FLOW("NMOR_COMPONENT_FLOW"),
      @SerializedName("NMOR_BUSINESS_PLATFORM_COMMERCE")
      VALUE_NMOR_BUSINESS_PLATFORM_COMMERCE("NMOR_BUSINESS_PLATFORM_COMMERCE"),
      @SerializedName("NMOR_SYNCHRONOUS_COMPONENT_FLOW")
      VALUE_NMOR_SYNCHRONOUS_COMPONENT_FLOW("NMOR_SYNCHRONOUS_COMPONENT_FLOW"),
      @SerializedName("NMOR_EVENT_TICKETING")
      VALUE_NMOR_EVENT_TICKETING("NMOR_EVENT_TICKETING"),
      @SerializedName("NMOR_PLATFORM_SELF_SERVE")
      VALUE_NMOR_PLATFORM_SELF_SERVE("NMOR_PLATFORM_SELF_SERVE"),
      @SerializedName("NMOR_MESSENGER_PLATFORM")
      VALUE_NMOR_MESSENGER_PLATFORM("NMOR_MESSENGER_PLATFORM"),
      @SerializedName("NMOR_MESSENGER_OMNIM")
      VALUE_NMOR_MESSENGER_OMNIM("NMOR_MESSENGER_OMNIM"),
      @SerializedName("NMOR_BILLING_ENGINE")
      VALUE_NMOR_BILLING_ENGINE("NMOR_BILLING_ENGINE"),
      @SerializedName("NMOR_TIP_JAR")
      VALUE_NMOR_TIP_JAR("NMOR_TIP_JAR"),
      @SerializedName("NMOR_INSTANT_EXPERIENCES")
      VALUE_NMOR_INSTANT_EXPERIENCES("NMOR_INSTANT_EXPERIENCES"),
      @SerializedName("NMOR_CHECKOUT_EXPERIENCES")
      VALUE_NMOR_CHECKOUT_EXPERIENCES("NMOR_CHECKOUT_EXPERIENCES"),
      @SerializedName("NMOR_BUY_ON_FACEBOOK")
      VALUE_NMOR_BUY_ON_FACEBOOK("NMOR_BUY_ON_FACEBOOK"),
      @SerializedName("NMOR_PAYMENT_APP")
      VALUE_NMOR_PAYMENT_APP("NMOR_PAYMENT_APP"),
      @SerializedName("NMOR_DONATION_P4P")
      VALUE_NMOR_DONATION_P4P("NMOR_DONATION_P4P"),
      @SerializedName("NMOR_WHATSAPP_P2P")
      VALUE_NMOR_WHATSAPP_P2P("NMOR_WHATSAPP_P2P"),
      @SerializedName("NMOR_P2P")
      VALUE_NMOR_P2P("NMOR_P2P"),
      @SerializedName("NMOR_MOBILE_TOP_UP")
      VALUE_NMOR_MOBILE_TOP_UP("NMOR_MOBILE_TOP_UP"),
      @SerializedName("NMOR_MFS")
      VALUE_NMOR_MFS("NMOR_MFS"),
      @SerializedName("NMOR_SHIPPING_LABEL")
      VALUE_NMOR_SHIPPING_LABEL("NMOR_SHIPPING_LABEL"),
      @SerializedName("NMOR_MARKETPLACE_DROPOFF")
      VALUE_NMOR_MARKETPLACE_DROPOFF("NMOR_MARKETPLACE_DROPOFF"),
      @SerializedName("NMOR_PAGES_SOLUTION")
      VALUE_NMOR_PAGES_SOLUTION("NMOR_PAGES_SOLUTION"),
      @SerializedName("NMOR_BLACKBAUD_RWR_DONATION")
      VALUE_NMOR_BLACKBAUD_RWR_DONATION("NMOR_BLACKBAUD_RWR_DONATION"),
      @SerializedName("NMOR_MARKETPLACE_SHIPPING")
      VALUE_NMOR_MARKETPLACE_SHIPPING("NMOR_MARKETPLACE_SHIPPING"),
      @SerializedName("NMOR_DUMMY")
      VALUE_NMOR_DUMMY("NMOR_DUMMY"),
      @SerializedName("NMOR_PPGF_DONATION")
      VALUE_NMOR_PPGF_DONATION("NMOR_PPGF_DONATION"),
      @SerializedName("NMOR_ADVERTISER_SUBSCRIPTION")
      VALUE_NMOR_ADVERTISER_SUBSCRIPTION("NMOR_ADVERTISER_SUBSCRIPTION"),
      @SerializedName("NMOR_WHATSAPP_P2M")
      VALUE_NMOR_WHATSAPP_P2M("NMOR_WHATSAPP_P2M"),
      @SerializedName("NMOR_MOVIE_TICKETING")
      VALUE_NMOR_MOVIE_TICKETING("NMOR_MOVIE_TICKETING"),
      @SerializedName("IG_NMOR_P2B")
      VALUE_IG_NMOR_P2B("IG_NMOR_P2B"),
      @SerializedName("NMOR_INSTAGRAM_P2B")
      VALUE_NMOR_INSTAGRAM_P2B("NMOR_INSTAGRAM_P2B"),
      NULL(null);

      private String value;

      private EnumPaymentType(String value) {
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

  public UserPaymentModulesOptions copyFrom(UserPaymentModulesOptions instance) {
    this.mAccountId = instance.mAccountId;
    this.mAvailablePaymentOptions = instance.mAvailablePaymentOptions;
    this.mCountry = instance.mCountry;
    this.mCurrency = instance.mCurrency;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UserPaymentModulesOptions> getParser() {
    return new APIRequest.ResponseParser<UserPaymentModulesOptions>() {
      public APINodeList<UserPaymentModulesOptions> parseResponse(String response, APIContext context, APIRequest<UserPaymentModulesOptions> request) throws MalformedResponseException {
        return UserPaymentModulesOptions.parseResponse(response, context, request);
      }
    };
  }
}
