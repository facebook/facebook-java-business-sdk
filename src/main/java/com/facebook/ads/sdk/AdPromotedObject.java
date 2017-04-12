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
public class AdPromotedObject extends APINode {
  @SerializedName("application_id")
  private String mApplicationId = null;
  @SerializedName("custom_event_type")
  private EnumCustomEventType mCustomEventType = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("object_store_url")
  private String mObjectStoreUrl = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("place_page_set_id")
  private String mPlacePageSetId = null;
  @SerializedName("product_catalog_id")
  private String mProductCatalogId = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  protected static Gson gson = null;

  public AdPromotedObject() {
  }

  public String getId() {
    return null;
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
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adPromotedObjects.setPaging(before, after);
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


  public String getFieldApplicationId() {
    return mApplicationId;
  }

  public AdPromotedObject setFieldApplicationId(String value) {
    this.mApplicationId = value;
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

  public String getFieldPageId() {
    return mPageId;
  }

  public AdPromotedObject setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public AdPromotedObject setFieldPixelId(String value) {
    this.mPixelId = value;
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

  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public AdPromotedObject setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }



  public static enum EnumCustomEventType {
      @SerializedName("COMPLETE_REGISTRATION")
      VALUE_COMPLETE_REGISTRATION("COMPLETE_REGISTRATION"),
      @SerializedName("CONTENT_VIEW")
      VALUE_CONTENT_VIEW("CONTENT_VIEW"),
      @SerializedName("SEARCH")
      VALUE_SEARCH("SEARCH"),
      @SerializedName("RATE")
      VALUE_RATE("RATE"),
      @SerializedName("TUTORIAL_COMPLETION")
      VALUE_TUTORIAL_COMPLETION("TUTORIAL_COMPLETION"),
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
      @SerializedName("LEVEL_ACHIEVED")
      VALUE_LEVEL_ACHIEVED("LEVEL_ACHIEVED"),
      @SerializedName("ACHIEVEMENT_UNLOCKED")
      VALUE_ACHIEVEMENT_UNLOCKED("ACHIEVEMENT_UNLOCKED"),
      @SerializedName("SPENT_CREDITS")
      VALUE_SPENT_CREDITS("SPENT_CREDITS"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

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
    this.mCustomEventType = instance.mCustomEventType;
    this.mEventId = instance.mEventId;
    this.mObjectStoreUrl = instance.mObjectStoreUrl;
    this.mOfferId = instance.mOfferId;
    this.mPageId = instance.mPageId;
    this.mPixelId = instance.mPixelId;
    this.mPlacePageSetId = instance.mPlacePageSetId;
    this.mProductCatalogId = instance.mProductCatalogId;
    this.mProductSetId = instance.mProductSetId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
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
