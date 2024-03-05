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
public class AdPromotedObject extends APINode {
  @SerializedName("application_id")
  private String mApplicationId = null;
  @SerializedName("conversion_goal_id")
  private String mConversionGoalId = null;
  @SerializedName("custom_conversion_id")
  private String mCustomConversionId = null;
  @SerializedName("custom_event_str")
  private String mCustomEventStr = null;
  @SerializedName("custom_event_type")
  private EnumCustomEventType mCustomEventType = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("fundraiser_campaign_id")
  private String mFundraiserCampaignId = null;
  @SerializedName("mcme_conversion_id")
  private String mMcmeConversionId = null;
  @SerializedName("object_store_url")
  private String mObjectStoreUrl = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("offline_conversion_data_set_id")
  private String mOfflineConversionDataSetId = null;
  @SerializedName("offsite_conversion_event_id")
  private String mOffsiteConversionEventId = null;
  @SerializedName("omnichannel_object")
  private Object mOmnichannelObject = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("pixel_aggregation_rule")
  private String mPixelAggregationRule = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("pixel_rule")
  private String mPixelRule = null;
  @SerializedName("place_page_set")
  private AdPlacePageSet mPlacePageSet = null;
  @SerializedName("place_page_set_id")
  private String mPlacePageSetId = null;
  @SerializedName("product_catalog_id")
  private String mProductCatalogId = null;
  @SerializedName("product_item_id")
  private String mProductItemId = null;
  @SerializedName("product_set")
  private ProductSet mProductSet = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("retention_days")
  private String mRetentionDays = null;
  @SerializedName("whatsapp_phone_number")
  private String mWhatsappPhoneNumber = null;
  protected static Gson gson = null;

  public AdPromotedObject() {
  }

  public String getId() {
    return null;
  }
  public static AdPromotedObject loadJSON(String json, APIContext context, String header) {
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
      }
    }
    adPromotedObject.context = context;
    adPromotedObject.rawValue = json;
    adPromotedObject.header = header;
    return adPromotedObject;
  }

  public static APINodeList<AdPromotedObject> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdPromotedObject> adPromotedObjects = new APINodeList<AdPromotedObject>(request, json, header);
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
          adPromotedObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              adPromotedObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adPromotedObjects.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adPromotedObjects.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adPromotedObjects;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adPromotedObjects.add(loadJSON(entry.getValue().toString(), context, header));
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
              adPromotedObjects.add(loadJSON(value.toString(), context, header));
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
          adPromotedObjects.add(loadJSON(json, context, header));
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


  public String getFieldApplicationId() {
    return mApplicationId;
  }

  public AdPromotedObject setFieldApplicationId(String value) {
    this.mApplicationId = value;
    return this;
  }

  public String getFieldConversionGoalId() {
    return mConversionGoalId;
  }

  public AdPromotedObject setFieldConversionGoalId(String value) {
    this.mConversionGoalId = value;
    return this;
  }

  public String getFieldCustomConversionId() {
    return mCustomConversionId;
  }

  public AdPromotedObject setFieldCustomConversionId(String value) {
    this.mCustomConversionId = value;
    return this;
  }

  public String getFieldCustomEventStr() {
    return mCustomEventStr;
  }

  public AdPromotedObject setFieldCustomEventStr(String value) {
    this.mCustomEventStr = value;
    return this;
  }

  public EnumCustomEventType getFieldCustomEventType() {
    return mCustomEventType;
  }

  public AdPromotedObject setFieldCustomEventType(EnumCustomEventType value) {
    this.mCustomEventType = value;
    return this;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public AdPromotedObject setFieldEventId(String value) {
    this.mEventId = value;
    return this;
  }

  public String getFieldFundraiserCampaignId() {
    return mFundraiserCampaignId;
  }

  public AdPromotedObject setFieldFundraiserCampaignId(String value) {
    this.mFundraiserCampaignId = value;
    return this;
  }

  public String getFieldMcmeConversionId() {
    return mMcmeConversionId;
  }

  public AdPromotedObject setFieldMcmeConversionId(String value) {
    this.mMcmeConversionId = value;
    return this;
  }

  public String getFieldObjectStoreUrl() {
    return mObjectStoreUrl;
  }

  public AdPromotedObject setFieldObjectStoreUrl(String value) {
    this.mObjectStoreUrl = value;
    return this;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public AdPromotedObject setFieldOfferId(String value) {
    this.mOfferId = value;
    return this;
  }

  public String getFieldOfflineConversionDataSetId() {
    return mOfflineConversionDataSetId;
  }

  public AdPromotedObject setFieldOfflineConversionDataSetId(String value) {
    this.mOfflineConversionDataSetId = value;
    return this;
  }

  public String getFieldOffsiteConversionEventId() {
    return mOffsiteConversionEventId;
  }

  public AdPromotedObject setFieldOffsiteConversionEventId(String value) {
    this.mOffsiteConversionEventId = value;
    return this;
  }

  public Object getFieldOmnichannelObject() {
    return mOmnichannelObject;
  }

  public AdPromotedObject setFieldOmnichannelObject(Object value) {
    this.mOmnichannelObject = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public AdPromotedObject setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public String getFieldPixelAggregationRule() {
    return mPixelAggregationRule;
  }

  public AdPromotedObject setFieldPixelAggregationRule(String value) {
    this.mPixelAggregationRule = value;
    return this;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public AdPromotedObject setFieldPixelId(String value) {
    this.mPixelId = value;
    return this;
  }

  public String getFieldPixelRule() {
    return mPixelRule;
  }

  public AdPromotedObject setFieldPixelRule(String value) {
    this.mPixelRule = value;
    return this;
  }

  public AdPlacePageSet getFieldPlacePageSet() {
    if (mPlacePageSet != null) {
      mPlacePageSet.context = getContext();
    }
    return mPlacePageSet;
  }

  public AdPromotedObject setFieldPlacePageSet(AdPlacePageSet value) {
    this.mPlacePageSet = value;
    return this;
  }

  public AdPromotedObject setFieldPlacePageSet(String value) {
    Type type = new TypeToken<AdPlacePageSet>(){}.getType();
    this.mPlacePageSet = AdPlacePageSet.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPlacePageSetId() {
    return mPlacePageSetId;
  }

  public AdPromotedObject setFieldPlacePageSetId(String value) {
    this.mPlacePageSetId = value;
    return this;
  }

  public String getFieldProductCatalogId() {
    return mProductCatalogId;
  }

  public AdPromotedObject setFieldProductCatalogId(String value) {
    this.mProductCatalogId = value;
    return this;
  }

  public String getFieldProductItemId() {
    return mProductItemId;
  }

  public AdPromotedObject setFieldProductItemId(String value) {
    this.mProductItemId = value;
    return this;
  }

  public ProductSet getFieldProductSet() {
    if (mProductSet != null) {
      mProductSet.context = getContext();
    }
    return mProductSet;
  }

  public AdPromotedObject setFieldProductSet(ProductSet value) {
    this.mProductSet = value;
    return this;
  }

  public AdPromotedObject setFieldProductSet(String value) {
    Type type = new TypeToken<ProductSet>(){}.getType();
    this.mProductSet = ProductSet.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public AdPromotedObject setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }

  public String getFieldRetentionDays() {
    return mRetentionDays;
  }

  public AdPromotedObject setFieldRetentionDays(String value) {
    this.mRetentionDays = value;
    return this;
  }

  public String getFieldWhatsappPhoneNumber() {
    return mWhatsappPhoneNumber;
  }

  public AdPromotedObject setFieldWhatsappPhoneNumber(String value) {
    this.mWhatsappPhoneNumber = value;
    return this;
  }



  public static enum EnumCustomEventType {
      @SerializedName("ACHIEVEMENT_UNLOCKED")
      VALUE_ACHIEVEMENT_UNLOCKED("ACHIEVEMENT_UNLOCKED"),
      @SerializedName("ADD_PAYMENT_INFO")
      VALUE_ADD_PAYMENT_INFO("ADD_PAYMENT_INFO"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("ADD_TO_WISHLIST")
      VALUE_ADD_TO_WISHLIST("ADD_TO_WISHLIST"),
      @SerializedName("AD_IMPRESSION")
      VALUE_AD_IMPRESSION("AD_IMPRESSION"),
      @SerializedName("COMPLETE_REGISTRATION")
      VALUE_COMPLETE_REGISTRATION("COMPLETE_REGISTRATION"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CONTENT_VIEW")
      VALUE_CONTENT_VIEW("CONTENT_VIEW"),
      @SerializedName("CUSTOMIZE_PRODUCT")
      VALUE_CUSTOMIZE_PRODUCT("CUSTOMIZE_PRODUCT"),
      @SerializedName("D2_RETENTION")
      VALUE_D2_RETENTION("D2_RETENTION"),
      @SerializedName("D7_RETENTION")
      VALUE_D7_RETENTION("D7_RETENTION"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("FIND_LOCATION")
      VALUE_FIND_LOCATION("FIND_LOCATION"),
      @SerializedName("INITIATED_CHECKOUT")
      VALUE_INITIATED_CHECKOUT("INITIATED_CHECKOUT"),
      @SerializedName("LEAD")
      VALUE_LEAD("LEAD"),
      @SerializedName("LEVEL_ACHIEVED")
      VALUE_LEVEL_ACHIEVED("LEVEL_ACHIEVED"),
      @SerializedName("LISTING_INTERACTION")
      VALUE_LISTING_INTERACTION("LISTING_INTERACTION"),
      @SerializedName("MESSAGING_CONVERSATION_STARTED_7D")
      VALUE_MESSAGING_CONVERSATION_STARTED_7D("MESSAGING_CONVERSATION_STARTED_7D"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PURCHASE")
      VALUE_PURCHASE("PURCHASE"),
      @SerializedName("RATE")
      VALUE_RATE("RATE"),
      @SerializedName("SCHEDULE")
      VALUE_SCHEDULE("SCHEDULE"),
      @SerializedName("SEARCH")
      VALUE_SEARCH("SEARCH"),
      @SerializedName("SERVICE_BOOKING_REQUEST")
      VALUE_SERVICE_BOOKING_REQUEST("SERVICE_BOOKING_REQUEST"),
      @SerializedName("SPENT_CREDITS")
      VALUE_SPENT_CREDITS("SPENT_CREDITS"),
      @SerializedName("START_TRIAL")
      VALUE_START_TRIAL("START_TRIAL"),
      @SerializedName("SUBMIT_APPLICATION")
      VALUE_SUBMIT_APPLICATION("SUBMIT_APPLICATION"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("TUTORIAL_COMPLETION")
      VALUE_TUTORIAL_COMPLETION("TUTORIAL_COMPLETION"),
      ;

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
    this.mConversionGoalId = instance.mConversionGoalId;
    this.mCustomConversionId = instance.mCustomConversionId;
    this.mCustomEventStr = instance.mCustomEventStr;
    this.mCustomEventType = instance.mCustomEventType;
    this.mEventId = instance.mEventId;
    this.mFundraiserCampaignId = instance.mFundraiserCampaignId;
    this.mMcmeConversionId = instance.mMcmeConversionId;
    this.mObjectStoreUrl = instance.mObjectStoreUrl;
    this.mOfferId = instance.mOfferId;
    this.mOfflineConversionDataSetId = instance.mOfflineConversionDataSetId;
    this.mOffsiteConversionEventId = instance.mOffsiteConversionEventId;
    this.mOmnichannelObject = instance.mOmnichannelObject;
    this.mPageId = instance.mPageId;
    this.mPixelAggregationRule = instance.mPixelAggregationRule;
    this.mPixelId = instance.mPixelId;
    this.mPixelRule = instance.mPixelRule;
    this.mPlacePageSet = instance.mPlacePageSet;
    this.mPlacePageSetId = instance.mPlacePageSetId;
    this.mProductCatalogId = instance.mProductCatalogId;
    this.mProductItemId = instance.mProductItemId;
    this.mProductSet = instance.mProductSet;
    this.mProductSetId = instance.mProductSetId;
    this.mRetentionDays = instance.mRetentionDays;
    this.mWhatsappPhoneNumber = instance.mWhatsappPhoneNumber;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdPromotedObject> getParser() {
    return new APIRequest.ResponseParser<AdPromotedObject>() {
      public APINodeList<AdPromotedObject> parseResponse(String response, APIContext context, APIRequest<AdPromotedObject> request, String header) throws MalformedResponseException {
        return AdPromotedObject.parseResponse(response, context, request, header);
      }
    };
  }
}
