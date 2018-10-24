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
public class AdPromotedObject extends APINode {
  @SerializedName("application_id")
  private String mApplicationId = null;
  @SerializedName("custom_conversion_id")
  private String mCustomConversionId = null;
  @SerializedName("custom_event_type")
  private EnumCustomEventType mCustomEventType = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("fundraiser_campaign_id")
  private String mFundraiserCampaignId = null;
  @SerializedName("object_store_url")
  private String mObjectStoreUrl = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("offline_conversion_data_set_id")
  private String mOfflineConversionDataSetId = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("pixel_aggregation_rule")
  private String mPixelAggregationRule = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("pixel_rule")
  private String mPixelRule = null;
  @SerializedName("place_page_set_id")
  private String mPlacePageSetId = null;
  @SerializedName("product_catalog_id")
  private String mProductCatalogId = null;
  @SerializedName("product_item_id")
  private String mProductItemId = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("retention_days")
  private String mRetentionDays = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdPromotedObject() {
  }

  public AdPromotedObject(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdPromotedObject(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdPromotedObject fetch() throws APIException{
    AdPromotedObject newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdPromotedObject fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdPromotedObject> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdPromotedObject fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdPromotedObject> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdPromotedObject> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdPromotedObject>)(
      new APIRequest<AdPromotedObject>(context, "", "/", "GET", AdPromotedObject.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdPromotedObject>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdPromotedObject.getParser())
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
  public static AdPromotedObject loadJSON(String json, APIContext context) {
    AdPromotedObject adPromotedObject = getGson().fromJson(json, AdPromotedObject.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adPromotedObject.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adPromotedObject.context = context;
    adPromotedObject.rawValue = json;
    return adPromotedObject;
  }

  public static APINodeList<AdPromotedObject> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdPromotedObject> adPromotedObjects = new APINodeList<AdPromotedObject>(request, json);
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
          adPromotedObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adPromotedObjects;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adPromotedObjects.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adPromotedObjects.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adPromotedObjects.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adPromotedObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adPromotedObjects.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adPromotedObjects.add(loadJSON(obj.toString(), context));
            }
          }
          return adPromotedObjects;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adPromotedObjects.add(loadJSON(entry.getValue().toString(), context));
          }
          return adPromotedObjects;
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
              adPromotedObjects.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adPromotedObjects;
          }

          // Sixth, check if it's pure JsonObject
          adPromotedObjects.clear();
          adPromotedObjects.add(loadJSON(json, context));
          return adPromotedObjects;
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


  public String getFieldApplicationId() {
    return mApplicationId;
  }

  public String getFieldCustomConversionId() {
    return mCustomConversionId;
  }

  public EnumCustomEventType getFieldCustomEventType() {
    return mCustomEventType;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public String getFieldFundraiserCampaignId() {
    return mFundraiserCampaignId;
  }

  public String getFieldObjectStoreUrl() {
    return mObjectStoreUrl;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public String getFieldOfflineConversionDataSetId() {
    return mOfflineConversionDataSetId;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public String getFieldPixelAggregationRule() {
    return mPixelAggregationRule;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public String getFieldPixelRule() {
    return mPixelRule;
  }

  public String getFieldPlacePageSetId() {
    return mPlacePageSetId;
  }

  public String getFieldProductCatalogId() {
    return mProductCatalogId;
  }

  public String getFieldProductItemId() {
    return mProductItemId;
  }

  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public String getFieldRetentionDays() {
    return mRetentionDays;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdPromotedObject> {

    AdPromotedObject lastResponse = null;
    @Override
    public AdPromotedObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "application_id",
      "custom_conversion_id",
      "custom_event_type",
      "event_id",
      "fundraiser_campaign_id",
      "object_store_url",
      "offer_id",
      "offline_conversion_data_set_id",
      "page_id",
      "pixel_aggregation_rule",
      "pixel_id",
      "pixel_rule",
      "place_page_set_id",
      "product_catalog_id",
      "product_item_id",
      "product_set_id",
      "retention_days",
      "id",
    };

    @Override
    public AdPromotedObject parseResponse(String response) throws APIException {
      return AdPromotedObject.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdPromotedObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdPromotedObject execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdPromotedObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdPromotedObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdPromotedObject>() {
           public AdPromotedObject apply(String result) {
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

    public APIRequestGet requestApplicationIdField () {
      return this.requestApplicationIdField(true);
    }
    public APIRequestGet requestApplicationIdField (boolean value) {
      this.requestField("application_id", value);
      return this;
    }
    public APIRequestGet requestCustomConversionIdField () {
      return this.requestCustomConversionIdField(true);
    }
    public APIRequestGet requestCustomConversionIdField (boolean value) {
      this.requestField("custom_conversion_id", value);
      return this;
    }
    public APIRequestGet requestCustomEventTypeField () {
      return this.requestCustomEventTypeField(true);
    }
    public APIRequestGet requestCustomEventTypeField (boolean value) {
      this.requestField("custom_event_type", value);
      return this;
    }
    public APIRequestGet requestEventIdField () {
      return this.requestEventIdField(true);
    }
    public APIRequestGet requestEventIdField (boolean value) {
      this.requestField("event_id", value);
      return this;
    }
    public APIRequestGet requestFundraiserCampaignIdField () {
      return this.requestFundraiserCampaignIdField(true);
    }
    public APIRequestGet requestFundraiserCampaignIdField (boolean value) {
      this.requestField("fundraiser_campaign_id", value);
      return this;
    }
    public APIRequestGet requestObjectStoreUrlField () {
      return this.requestObjectStoreUrlField(true);
    }
    public APIRequestGet requestObjectStoreUrlField (boolean value) {
      this.requestField("object_store_url", value);
      return this;
    }
    public APIRequestGet requestOfferIdField () {
      return this.requestOfferIdField(true);
    }
    public APIRequestGet requestOfferIdField (boolean value) {
      this.requestField("offer_id", value);
      return this;
    }
    public APIRequestGet requestOfflineConversionDataSetIdField () {
      return this.requestOfflineConversionDataSetIdField(true);
    }
    public APIRequestGet requestOfflineConversionDataSetIdField (boolean value) {
      this.requestField("offline_conversion_data_set_id", value);
      return this;
    }
    public APIRequestGet requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGet requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGet requestPixelAggregationRuleField () {
      return this.requestPixelAggregationRuleField(true);
    }
    public APIRequestGet requestPixelAggregationRuleField (boolean value) {
      this.requestField("pixel_aggregation_rule", value);
      return this;
    }
    public APIRequestGet requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGet requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGet requestPixelRuleField () {
      return this.requestPixelRuleField(true);
    }
    public APIRequestGet requestPixelRuleField (boolean value) {
      this.requestField("pixel_rule", value);
      return this;
    }
    public APIRequestGet requestPlacePageSetIdField () {
      return this.requestPlacePageSetIdField(true);
    }
    public APIRequestGet requestPlacePageSetIdField (boolean value) {
      this.requestField("place_page_set_id", value);
      return this;
    }
    public APIRequestGet requestProductCatalogIdField () {
      return this.requestProductCatalogIdField(true);
    }
    public APIRequestGet requestProductCatalogIdField (boolean value) {
      this.requestField("product_catalog_id", value);
      return this;
    }
    public APIRequestGet requestProductItemIdField () {
      return this.requestProductItemIdField(true);
    }
    public APIRequestGet requestProductItemIdField (boolean value) {
      this.requestField("product_item_id", value);
      return this;
    }
    public APIRequestGet requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGet requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGet requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGet requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
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



  public static enum EnumCustomEventType {
      @SerializedName("RATE")
      VALUE_RATE("RATE"),
      @SerializedName("TUTORIAL_COMPLETION")
      VALUE_TUTORIAL_COMPLETION("TUTORIAL_COMPLETION"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CUSTOMIZE_PRODUCT")
      VALUE_CUSTOMIZE_PRODUCT("CUSTOMIZE_PRODUCT"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("FIND_LOCATION")
      VALUE_FIND_LOCATION("FIND_LOCATION"),
      @SerializedName("SCHEDULE")
      VALUE_SCHEDULE("SCHEDULE"),
      @SerializedName("START_TRIAL")
      VALUE_START_TRIAL("START_TRIAL"),
      @SerializedName("SUBMIT_APPLICATION")
      VALUE_SUBMIT_APPLICATION("SUBMIT_APPLICATION"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("ADD_TO_WISHLIST")
      VALUE_ADD_TO_WISHLIST("ADD_TO_WISHLIST"),
      @SerializedName("INITIATED_CHECKOUT")
      VALUE_INITIATED_CHECKOUT("INITIATED_CHECKOUT"),
      @SerializedName("ADD_PAYMENT_INFO")
      VALUE_ADD_PAYMENT_INFO("ADD_PAYMENT_INFO"),
      @SerializedName("PURCHASE")
      VALUE_PURCHASE("PURCHASE"),
      @SerializedName("LEAD")
      VALUE_LEAD("LEAD"),
      @SerializedName("COMPLETE_REGISTRATION")
      VALUE_COMPLETE_REGISTRATION("COMPLETE_REGISTRATION"),
      @SerializedName("CONTENT_VIEW")
      VALUE_CONTENT_VIEW("CONTENT_VIEW"),
      @SerializedName("SEARCH")
      VALUE_SEARCH("SEARCH"),
      @SerializedName("SERVICE_BOOKING_REQUEST")
      VALUE_SERVICE_BOOKING_REQUEST("SERVICE_BOOKING_REQUEST"),
      @SerializedName("MESSAGING_CONVERSATION_STARTED_7D")
      VALUE_MESSAGING_CONVERSATION_STARTED_7D("MESSAGING_CONVERSATION_STARTED_7D"),
      @SerializedName("LEVEL_ACHIEVED")
      VALUE_LEVEL_ACHIEVED("LEVEL_ACHIEVED"),
      @SerializedName("ACHIEVEMENT_UNLOCKED")
      VALUE_ACHIEVEMENT_UNLOCKED("ACHIEVEMENT_UNLOCKED"),
      @SerializedName("SPENT_CREDITS")
      VALUE_SPENT_CREDITS("SPENT_CREDITS"),
      @SerializedName("D2_RETENTION")
      VALUE_D2_RETENTION("D2_RETENTION"),
      @SerializedName("D7_RETENTION")
      VALUE_D7_RETENTION("D7_RETENTION"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumCustomEventType(String value) {
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

  public AdPromotedObject copyFrom(AdPromotedObject instance) {
    this.mApplicationId = instance.mApplicationId;
    this.mCustomConversionId = instance.mCustomConversionId;
    this.mCustomEventType = instance.mCustomEventType;
    this.mEventId = instance.mEventId;
    this.mFundraiserCampaignId = instance.mFundraiserCampaignId;
    this.mObjectStoreUrl = instance.mObjectStoreUrl;
    this.mOfferId = instance.mOfferId;
    this.mOfflineConversionDataSetId = instance.mOfflineConversionDataSetId;
    this.mPageId = instance.mPageId;
    this.mPixelAggregationRule = instance.mPixelAggregationRule;
    this.mPixelId = instance.mPixelId;
    this.mPixelRule = instance.mPixelRule;
    this.mPlacePageSetId = instance.mPlacePageSetId;
    this.mProductCatalogId = instance.mProductCatalogId;
    this.mProductItemId = instance.mProductItemId;
    this.mProductSetId = instance.mProductSetId;
    this.mRetentionDays = instance.mRetentionDays;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    this.mPixelRule = instance.mPixelRule;
    return this;
  }

  public static APIRequest.ResponseParser<AdPromotedObject> getParser() {
    return new APIRequest.ResponseParser<AdPromotedObject>() {
      public APINodeList<AdPromotedObject> parseResponse(String response, APIContext context, APIRequest<AdPromotedObject> request) throws MalformedResponseException {
        return AdPromotedObject.parseResponse(response, context, request);
      }
    };
  }
}
