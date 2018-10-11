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
public class UserPaymentMethodsInfo extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("available_card_types")
  private List<String> mAvailableCardTypes = null;
  @SerializedName("available_payment_methods")
  private List<String> mAvailablePaymentMethods = null;
  @SerializedName("available_payment_methods_details")
  private List<Object> mAvailablePaymentMethodsDetails = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("existing_payment_methods")
  private List<Object> mExistingPaymentMethods = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  UserPaymentMethodsInfo() {
  }

  public UserPaymentMethodsInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UserPaymentMethodsInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public UserPaymentMethodsInfo fetch() throws APIException{
    UserPaymentMethodsInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UserPaymentMethodsInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UserPaymentMethodsInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UserPaymentMethodsInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<UserPaymentMethodsInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<UserPaymentMethodsInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UserPaymentMethodsInfo>)(
      new APIRequest<UserPaymentMethodsInfo>(context, "", "/", "GET", UserPaymentMethodsInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UserPaymentMethodsInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", UserPaymentMethodsInfo.getParser())
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
  public static UserPaymentMethodsInfo loadJSON(String json, APIContext context) {
    UserPaymentMethodsInfo userPaymentMethodsInfo = getGson().fromJson(json, UserPaymentMethodsInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(userPaymentMethodsInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    userPaymentMethodsInfo.context = context;
    userPaymentMethodsInfo.rawValue = json;
    return userPaymentMethodsInfo;
  }

  public static APINodeList<UserPaymentMethodsInfo> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<UserPaymentMethodsInfo> userPaymentMethodsInfos = new APINodeList<UserPaymentMethodsInfo>(request, json);
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
          userPaymentMethodsInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return userPaymentMethodsInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                userPaymentMethodsInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            userPaymentMethodsInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              userPaymentMethodsInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              userPaymentMethodsInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  userPaymentMethodsInfos.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              userPaymentMethodsInfos.add(loadJSON(obj.toString(), context));
            }
          }
          return userPaymentMethodsInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              userPaymentMethodsInfos.add(loadJSON(entry.getValue().toString(), context));
          }
          return userPaymentMethodsInfos;
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
              userPaymentMethodsInfos.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return userPaymentMethodsInfos;
          }

          // Sixth, check if it's pure JsonObject
          userPaymentMethodsInfos.clear();
          userPaymentMethodsInfos.add(loadJSON(json, context));
          return userPaymentMethodsInfos;
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

  public List<String> getFieldAvailableCardTypes() {
    return mAvailableCardTypes;
  }

  public List<String> getFieldAvailablePaymentMethods() {
    return mAvailablePaymentMethods;
  }

  public List<Object> getFieldAvailablePaymentMethodsDetails() {
    return mAvailablePaymentMethodsDetails;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public List<Object> getFieldExistingPaymentMethods() {
    return mExistingPaymentMethods;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<UserPaymentMethodsInfo> {

    UserPaymentMethodsInfo lastResponse = null;
    @Override
    public UserPaymentMethodsInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "country_code",
      "extra_data",
      "nmor_order_type",
      "payment_type",
    };

    public static final String[] FIELDS = {
      "account_id",
      "available_card_types",
      "available_payment_methods",
      "available_payment_methods_details",
      "country",
      "currency",
      "existing_payment_methods",
      "id",
    };

    @Override
    public UserPaymentMethodsInfo parseResponse(String response) throws APIException {
      return UserPaymentMethodsInfo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public UserPaymentMethodsInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UserPaymentMethodsInfo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<UserPaymentMethodsInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UserPaymentMethodsInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, UserPaymentMethodsInfo>() {
           public UserPaymentMethodsInfo apply(String result) {
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


    public APIRequestGet setAccountId (Long accountId) {
      this.setParam("account_id", accountId);
      return this;
    }
    public APIRequestGet setAccountId (String accountId) {
      this.setParam("account_id", accountId);
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

    public APIRequestGet setNmorOrderType (EnumNmorOrderType nmorOrderType) {
      this.setParam("nmor_order_type", nmorOrderType);
      return this;
    }
    public APIRequestGet setNmorOrderType (String nmorOrderType) {
      this.setParam("nmor_order_type", nmorOrderType);
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
    public APIRequestGet requestAvailableCardTypesField () {
      return this.requestAvailableCardTypesField(true);
    }
    public APIRequestGet requestAvailableCardTypesField (boolean value) {
      this.requestField("available_card_types", value);
      return this;
    }
    public APIRequestGet requestAvailablePaymentMethodsField () {
      return this.requestAvailablePaymentMethodsField(true);
    }
    public APIRequestGet requestAvailablePaymentMethodsField (boolean value) {
      this.requestField("available_payment_methods", value);
      return this;
    }
    public APIRequestGet requestAvailablePaymentMethodsDetailsField () {
      return this.requestAvailablePaymentMethodsDetailsField(true);
    }
    public APIRequestGet requestAvailablePaymentMethodsDetailsField (boolean value) {
      this.requestField("available_payment_methods_details", value);
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
    public APIRequestGet requestExistingPaymentMethodsField () {
      return this.requestExistingPaymentMethodsField(true);
    }
    public APIRequestGet requestExistingPaymentMethodsField (boolean value) {
      this.requestField("existing_payment_methods", value);
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

  public static enum EnumNmorOrderType {
      @SerializedName("unknown")
      VALUE_UNKNOWN("unknown"),
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("pages_commerce")
      VALUE_PAGES_COMMERCE("pages_commerce"),
      @SerializedName("nmor_pages_commerce")
      VALUE_NMOR_PAGES_COMMERCE("nmor_pages_commerce"),
      @SerializedName("component_flow")
      VALUE_COMPONENT_FLOW("component_flow"),
      @SerializedName("business_platform_commerce")
      VALUE_BUSINESS_PLATFORM_COMMERCE("business_platform_commerce"),
      @SerializedName("synchronous_component_flow")
      VALUE_SYNCHRONOUS_COMPONENT_FLOW("synchronous_component_flow"),
      @SerializedName("event_ticketing")
      VALUE_EVENT_TICKETING("event_ticketing"),
      @SerializedName("platform_self_serve")
      VALUE_PLATFORM_SELF_SERVE("platform_self_serve"),
      @SerializedName("messenger_platform")
      VALUE_MESSENGER_PLATFORM("messenger_platform"),
      @SerializedName("messenger_omnim")
      VALUE_MESSENGER_OMNIM("messenger_omnim"),
      @SerializedName("billing_engine")
      VALUE_BILLING_ENGINE("billing_engine"),
      @SerializedName("tip_jar")
      VALUE_TIP_JAR("tip_jar"),
      @SerializedName("instant_experiences")
      VALUE_INSTANT_EXPERIENCES("instant_experiences"),
      @SerializedName("checkout_experiences")
      VALUE_CHECKOUT_EXPERIENCES("checkout_experiences"),
      @SerializedName("buy_on_facebook")
      VALUE_BUY_ON_FACEBOOK("buy_on_facebook"),
      @SerializedName("payment_app")
      VALUE_PAYMENT_APP("payment_app"),
      @SerializedName("donation_p4p")
      VALUE_DONATION_P4P("donation_p4p"),
      @SerializedName("whatsapp_p2p")
      VALUE_WHATSAPP_P2P("whatsapp_p2p"),
      @SerializedName("p2p")
      VALUE_P2P("p2p"),
      @SerializedName("mobile_top_up")
      VALUE_MOBILE_TOP_UP("mobile_top_up"),
      @SerializedName("shipping_label")
      VALUE_SHIPPING_LABEL("shipping_label"),
      @SerializedName("marketplace_dropoff")
      VALUE_MARKETPLACE_DROPOFF("marketplace_dropoff"),
      @SerializedName("pages_solution")
      VALUE_PAGES_SOLUTION("pages_solution"),
      @SerializedName("blackbaud_rwr_donation")
      VALUE_BLACKBAUD_RWR_DONATION("blackbaud_rwr_donation"),
      @SerializedName("instagram_p2b")
      VALUE_INSTAGRAM_P2B("instagram_p2b"),
      @SerializedName("marketplace_shipping")
      VALUE_MARKETPLACE_SHIPPING("marketplace_shipping"),
      @SerializedName("facebook_incentive_seller")
      VALUE_FACEBOOK_INCENTIVE_SELLER("facebook_incentive_seller"),
      @SerializedName("facebook_incentive_buyer")
      VALUE_FACEBOOK_INCENTIVE_BUYER("facebook_incentive_buyer"),
      @SerializedName("dummy")
      VALUE_DUMMY("dummy"),
      @SerializedName("ppgf_donation")
      VALUE_PPGF_DONATION("ppgf_donation"),
      @SerializedName("advertiser_subscription")
      VALUE_ADVERTISER_SUBSCRIPTION("advertiser_subscription"),
      @SerializedName("whatsapp_p2m")
      VALUE_WHATSAPP_P2M("whatsapp_p2m"),
      @SerializedName("movie_ticketing")
      VALUE_MOVIE_TICKETING("movie_ticketing"),
      NULL(null);

      private String value;

      private EnumNmorOrderType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPaymentType {
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("ads_invoice")
      VALUE_ADS_INVOICE("ads_invoice"),
      @SerializedName("donations")
      VALUE_DONATIONS("donations"),
      @SerializedName("donations_matching_confirmation")
      VALUE_DONATIONS_MATCHING_CONFIRMATION("donations_matching_confirmation"),
      @SerializedName("donations_matching_pledge")
      VALUE_DONATIONS_MATCHING_PLEDGE("donations_matching_pledge"),
      @SerializedName("facebook_shop")
      VALUE_FACEBOOK_SHOP("facebook_shop"),
      @SerializedName("fan_funding")
      VALUE_FAN_FUNDING("fan_funding"),
      @SerializedName("group_subscription")
      VALUE_GROUP_SUBSCRIPTION("group_subscription"),
      @SerializedName("game_tipping_token")
      VALUE_GAME_TIPPING_TOKEN("game_tipping_token"),
      @SerializedName("instant_games")
      VALUE_INSTANT_GAMES("instant_games"),
      @SerializedName("oculus_cv1")
      VALUE_OCULUS_CV1("oculus_cv1"),
      @SerializedName("oculus_launch_v1")
      VALUE_OCULUS_LAUNCH_V1("oculus_launch_v1"),
      @SerializedName("oculus_launch_v2")
      VALUE_OCULUS_LAUNCH_V2("oculus_launch_v2"),
      @SerializedName("ozone")
      VALUE_OZONE("ozone"),
      @SerializedName("open_graph_product")
      VALUE_OPEN_GRAPH_PRODUCT("open_graph_product"),
      @SerializedName("messenger_commerce")
      VALUE_MESSENGER_COMMERCE("messenger_commerce"),
      @SerializedName("p2p_transfer")
      VALUE_P2P_TRANSFER("p2p_transfer"),
      @SerializedName("dummy_first_party")
      VALUE_DUMMY_FIRST_PARTY("dummy_first_party"),
      @SerializedName("dummy_third_party")
      VALUE_DUMMY_THIRD_PARTY("dummy_third_party"),
      @SerializedName("gifts")
      VALUE_GIFTS("gifts"),
      @SerializedName("bill")
      VALUE_BILL("bill"),
      @SerializedName("airmail")
      VALUE_AIRMAIL("airmail"),
      @SerializedName("event_ticketing")
      VALUE_EVENT_TICKETING("event_ticketing"),
      @SerializedName("payment_lite")
      VALUE_PAYMENT_LITE("payment_lite"),
      @SerializedName("messenger_api_fee")
      VALUE_MESSENGER_API_FEE("messenger_api_fee"),
      @SerializedName("workplace")
      VALUE_WORKPLACE("workplace"),
      @SerializedName("nmor_pages_commerce")
      VALUE_NMOR_PAGES_COMMERCE("nmor_pages_commerce"),
      @SerializedName("stored_balance")
      VALUE_STORED_BALANCE("stored_balance"),
      @SerializedName("third_party_bundle")
      VALUE_THIRD_PARTY_BUNDLE("third_party_bundle"),
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

  public UserPaymentMethodsInfo copyFrom(UserPaymentMethodsInfo instance) {
    this.mAccountId = instance.mAccountId;
    this.mAvailableCardTypes = instance.mAvailableCardTypes;
    this.mAvailablePaymentMethods = instance.mAvailablePaymentMethods;
    this.mAvailablePaymentMethodsDetails = instance.mAvailablePaymentMethodsDetails;
    this.mCountry = instance.mCountry;
    this.mCurrency = instance.mCurrency;
    this.mExistingPaymentMethods = instance.mExistingPaymentMethods;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UserPaymentMethodsInfo> getParser() {
    return new APIRequest.ResponseParser<UserPaymentMethodsInfo>() {
      public APINodeList<UserPaymentMethodsInfo> parseResponse(String response, APIContext context, APIRequest<UserPaymentMethodsInfo> request) throws MalformedResponseException {
        return UserPaymentMethodsInfo.parseResponse(response, context, request);
      }
    };
  }
}
