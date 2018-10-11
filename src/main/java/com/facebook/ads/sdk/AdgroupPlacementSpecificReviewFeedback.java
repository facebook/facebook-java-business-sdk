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
public class AdgroupPlacementSpecificReviewFeedback extends APINode {
  @SerializedName("account_admin")
  private Map<String, String> mAccountAdmin = null;
  @SerializedName("ad")
  private Map<String, String> mAd = null;
  @SerializedName("b2c")
  private Map<String, String> mB2c = null;
  @SerializedName("bsg")
  private Map<String, String> mBsg = null;
  @SerializedName("city_community")
  private Map<String, String> mCityCommunity = null;
  @SerializedName("daily_deals")
  private Map<String, String> mDailyDeals = null;
  @SerializedName("daily_deals_legacy")
  private Map<String, String> mDailyDealsLegacy = null;
  @SerializedName("dpa")
  private Map<String, String> mDpa = null;
  @SerializedName("facebook")
  private Map<String, String> mFacebook = null;
  @SerializedName("instagram")
  private Map<String, String> mInstagram = null;
  @SerializedName("instagram_shop")
  private Map<String, String> mInstagramShop = null;
  @SerializedName("marketplace")
  private Map<String, String> mMarketplace = null;
  @SerializedName("marketplace_home_rentals")
  private Map<String, String> mMarketplaceHomeRentals = null;
  @SerializedName("marketplace_home_sales")
  private Map<String, String> mMarketplaceHomeSales = null;
  @SerializedName("marketplace_motors")
  private Map<String, String> mMarketplaceMotors = null;
  @SerializedName("max_review_placements")
  private Map<String, String> mMaxReviewPlacements = null;
  @SerializedName("page_admin")
  private Map<String, String> mPageAdmin = null;
  @SerializedName("product")
  private Map<String, String> mProduct = null;
  @SerializedName("product_service")
  private Map<String, String> mProductService = null;
  @SerializedName("profile")
  private Map<String, String> mProfile = null;
  @SerializedName("seller")
  private Map<String, String> mSeller = null;
  @SerializedName("shops")
  private Map<String, String> mShops = null;
  @SerializedName("whatsapp")
  private Map<String, String> mWhatsapp = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdgroupPlacementSpecificReviewFeedback() {
  }

  public AdgroupPlacementSpecificReviewFeedback(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdgroupPlacementSpecificReviewFeedback(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdgroupPlacementSpecificReviewFeedback fetch() throws APIException{
    AdgroupPlacementSpecificReviewFeedback newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdgroupPlacementSpecificReviewFeedback fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdgroupPlacementSpecificReviewFeedback> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdgroupPlacementSpecificReviewFeedback fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdgroupPlacementSpecificReviewFeedback> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdgroupPlacementSpecificReviewFeedback> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdgroupPlacementSpecificReviewFeedback>)(
      new APIRequest<AdgroupPlacementSpecificReviewFeedback>(context, "", "/", "GET", AdgroupPlacementSpecificReviewFeedback.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdgroupPlacementSpecificReviewFeedback>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdgroupPlacementSpecificReviewFeedback.getParser())
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
  public static AdgroupPlacementSpecificReviewFeedback loadJSON(String json, APIContext context) {
    AdgroupPlacementSpecificReviewFeedback adgroupPlacementSpecificReviewFeedback = getGson().fromJson(json, AdgroupPlacementSpecificReviewFeedback.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adgroupPlacementSpecificReviewFeedback.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adgroupPlacementSpecificReviewFeedback.context = context;
    adgroupPlacementSpecificReviewFeedback.rawValue = json;
    return adgroupPlacementSpecificReviewFeedback;
  }

  public static APINodeList<AdgroupPlacementSpecificReviewFeedback> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdgroupPlacementSpecificReviewFeedback> adgroupPlacementSpecificReviewFeedbacks = new APINodeList<AdgroupPlacementSpecificReviewFeedback>(request, json);
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
          adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adgroupPlacementSpecificReviewFeedbacks;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adgroupPlacementSpecificReviewFeedbacks.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adgroupPlacementSpecificReviewFeedbacks.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adgroupPlacementSpecificReviewFeedbacks.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(obj.toString(), context));
            }
          }
          return adgroupPlacementSpecificReviewFeedbacks;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(entry.getValue().toString(), context));
          }
          return adgroupPlacementSpecificReviewFeedbacks;
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
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adgroupPlacementSpecificReviewFeedbacks;
          }

          // Sixth, check if it's pure JsonObject
          adgroupPlacementSpecificReviewFeedbacks.clear();
          adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(json, context));
          return adgroupPlacementSpecificReviewFeedbacks;
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


  public Map<String, String> getFieldAccountAdmin() {
    return mAccountAdmin;
  }

  public Map<String, String> getFieldAd() {
    return mAd;
  }

  public Map<String, String> getFieldB2c() {
    return mB2c;
  }

  public Map<String, String> getFieldBsg() {
    return mBsg;
  }

  public Map<String, String> getFieldCityCommunity() {
    return mCityCommunity;
  }

  public Map<String, String> getFieldDailyDeals() {
    return mDailyDeals;
  }

  public Map<String, String> getFieldDailyDealsLegacy() {
    return mDailyDealsLegacy;
  }

  public Map<String, String> getFieldDpa() {
    return mDpa;
  }

  public Map<String, String> getFieldFacebook() {
    return mFacebook;
  }

  public Map<String, String> getFieldInstagram() {
    return mInstagram;
  }

  public Map<String, String> getFieldInstagramShop() {
    return mInstagramShop;
  }

  public Map<String, String> getFieldMarketplace() {
    return mMarketplace;
  }

  public Map<String, String> getFieldMarketplaceHomeRentals() {
    return mMarketplaceHomeRentals;
  }

  public Map<String, String> getFieldMarketplaceHomeSales() {
    return mMarketplaceHomeSales;
  }

  public Map<String, String> getFieldMarketplaceMotors() {
    return mMarketplaceMotors;
  }

  public Map<String, String> getFieldMaxReviewPlacements() {
    return mMaxReviewPlacements;
  }

  public Map<String, String> getFieldPageAdmin() {
    return mPageAdmin;
  }

  public Map<String, String> getFieldProduct() {
    return mProduct;
  }

  public Map<String, String> getFieldProductService() {
    return mProductService;
  }

  public Map<String, String> getFieldProfile() {
    return mProfile;
  }

  public Map<String, String> getFieldSeller() {
    return mSeller;
  }

  public Map<String, String> getFieldShops() {
    return mShops;
  }

  public Map<String, String> getFieldWhatsapp() {
    return mWhatsapp;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdgroupPlacementSpecificReviewFeedback> {

    AdgroupPlacementSpecificReviewFeedback lastResponse = null;
    @Override
    public AdgroupPlacementSpecificReviewFeedback getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_admin",
      "ad",
      "b2c",
      "bsg",
      "city_community",
      "daily_deals",
      "daily_deals_legacy",
      "dpa",
      "facebook",
      "instagram",
      "instagram_shop",
      "marketplace",
      "marketplace_home_rentals",
      "marketplace_home_sales",
      "marketplace_motors",
      "max_review_placements",
      "page_admin",
      "product",
      "product_service",
      "profile",
      "seller",
      "shops",
      "whatsapp",
      "id",
    };

    @Override
    public AdgroupPlacementSpecificReviewFeedback parseResponse(String response) throws APIException {
      return AdgroupPlacementSpecificReviewFeedback.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdgroupPlacementSpecificReviewFeedback execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdgroupPlacementSpecificReviewFeedback execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdgroupPlacementSpecificReviewFeedback> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdgroupPlacementSpecificReviewFeedback> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdgroupPlacementSpecificReviewFeedback>() {
           public AdgroupPlacementSpecificReviewFeedback apply(String result) {
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

    public APIRequestGet requestAccountAdminField () {
      return this.requestAccountAdminField(true);
    }
    public APIRequestGet requestAccountAdminField (boolean value) {
      this.requestField("account_admin", value);
      return this;
    }
    public APIRequestGet requestAdField () {
      return this.requestAdField(true);
    }
    public APIRequestGet requestAdField (boolean value) {
      this.requestField("ad", value);
      return this;
    }
    public APIRequestGet requestB2cField () {
      return this.requestB2cField(true);
    }
    public APIRequestGet requestB2cField (boolean value) {
      this.requestField("b2c", value);
      return this;
    }
    public APIRequestGet requestBsgField () {
      return this.requestBsgField(true);
    }
    public APIRequestGet requestBsgField (boolean value) {
      this.requestField("bsg", value);
      return this;
    }
    public APIRequestGet requestCityCommunityField () {
      return this.requestCityCommunityField(true);
    }
    public APIRequestGet requestCityCommunityField (boolean value) {
      this.requestField("city_community", value);
      return this;
    }
    public APIRequestGet requestDailyDealsField () {
      return this.requestDailyDealsField(true);
    }
    public APIRequestGet requestDailyDealsField (boolean value) {
      this.requestField("daily_deals", value);
      return this;
    }
    public APIRequestGet requestDailyDealsLegacyField () {
      return this.requestDailyDealsLegacyField(true);
    }
    public APIRequestGet requestDailyDealsLegacyField (boolean value) {
      this.requestField("daily_deals_legacy", value);
      return this;
    }
    public APIRequestGet requestDpaField () {
      return this.requestDpaField(true);
    }
    public APIRequestGet requestDpaField (boolean value) {
      this.requestField("dpa", value);
      return this;
    }
    public APIRequestGet requestFacebookField () {
      return this.requestFacebookField(true);
    }
    public APIRequestGet requestFacebookField (boolean value) {
      this.requestField("facebook", value);
      return this;
    }
    public APIRequestGet requestInstagramField () {
      return this.requestInstagramField(true);
    }
    public APIRequestGet requestInstagramField (boolean value) {
      this.requestField("instagram", value);
      return this;
    }
    public APIRequestGet requestInstagramShopField () {
      return this.requestInstagramShopField(true);
    }
    public APIRequestGet requestInstagramShopField (boolean value) {
      this.requestField("instagram_shop", value);
      return this;
    }
    public APIRequestGet requestMarketplaceField () {
      return this.requestMarketplaceField(true);
    }
    public APIRequestGet requestMarketplaceField (boolean value) {
      this.requestField("marketplace", value);
      return this;
    }
    public APIRequestGet requestMarketplaceHomeRentalsField () {
      return this.requestMarketplaceHomeRentalsField(true);
    }
    public APIRequestGet requestMarketplaceHomeRentalsField (boolean value) {
      this.requestField("marketplace_home_rentals", value);
      return this;
    }
    public APIRequestGet requestMarketplaceHomeSalesField () {
      return this.requestMarketplaceHomeSalesField(true);
    }
    public APIRequestGet requestMarketplaceHomeSalesField (boolean value) {
      this.requestField("marketplace_home_sales", value);
      return this;
    }
    public APIRequestGet requestMarketplaceMotorsField () {
      return this.requestMarketplaceMotorsField(true);
    }
    public APIRequestGet requestMarketplaceMotorsField (boolean value) {
      this.requestField("marketplace_motors", value);
      return this;
    }
    public APIRequestGet requestMaxReviewPlacementsField () {
      return this.requestMaxReviewPlacementsField(true);
    }
    public APIRequestGet requestMaxReviewPlacementsField (boolean value) {
      this.requestField("max_review_placements", value);
      return this;
    }
    public APIRequestGet requestPageAdminField () {
      return this.requestPageAdminField(true);
    }
    public APIRequestGet requestPageAdminField (boolean value) {
      this.requestField("page_admin", value);
      return this;
    }
    public APIRequestGet requestProductField () {
      return this.requestProductField(true);
    }
    public APIRequestGet requestProductField (boolean value) {
      this.requestField("product", value);
      return this;
    }
    public APIRequestGet requestProductServiceField () {
      return this.requestProductServiceField(true);
    }
    public APIRequestGet requestProductServiceField (boolean value) {
      this.requestField("product_service", value);
      return this;
    }
    public APIRequestGet requestProfileField () {
      return this.requestProfileField(true);
    }
    public APIRequestGet requestProfileField (boolean value) {
      this.requestField("profile", value);
      return this;
    }
    public APIRequestGet requestSellerField () {
      return this.requestSellerField(true);
    }
    public APIRequestGet requestSellerField (boolean value) {
      this.requestField("seller", value);
      return this;
    }
    public APIRequestGet requestShopsField () {
      return this.requestShopsField(true);
    }
    public APIRequestGet requestShopsField (boolean value) {
      this.requestField("shops", value);
      return this;
    }
    public APIRequestGet requestWhatsappField () {
      return this.requestWhatsappField(true);
    }
    public APIRequestGet requestWhatsappField (boolean value) {
      this.requestField("whatsapp", value);
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

  public AdgroupPlacementSpecificReviewFeedback copyFrom(AdgroupPlacementSpecificReviewFeedback instance) {
    this.mAccountAdmin = instance.mAccountAdmin;
    this.mAd = instance.mAd;
    this.mB2c = instance.mB2c;
    this.mBsg = instance.mBsg;
    this.mCityCommunity = instance.mCityCommunity;
    this.mDailyDeals = instance.mDailyDeals;
    this.mDailyDealsLegacy = instance.mDailyDealsLegacy;
    this.mDpa = instance.mDpa;
    this.mFacebook = instance.mFacebook;
    this.mInstagram = instance.mInstagram;
    this.mInstagramShop = instance.mInstagramShop;
    this.mMarketplace = instance.mMarketplace;
    this.mMarketplaceHomeRentals = instance.mMarketplaceHomeRentals;
    this.mMarketplaceHomeSales = instance.mMarketplaceHomeSales;
    this.mMarketplaceMotors = instance.mMarketplaceMotors;
    this.mMaxReviewPlacements = instance.mMaxReviewPlacements;
    this.mPageAdmin = instance.mPageAdmin;
    this.mProduct = instance.mProduct;
    this.mProductService = instance.mProductService;
    this.mProfile = instance.mProfile;
    this.mSeller = instance.mSeller;
    this.mShops = instance.mShops;
    this.mWhatsapp = instance.mWhatsapp;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdgroupPlacementSpecificReviewFeedback> getParser() {
    return new APIRequest.ResponseParser<AdgroupPlacementSpecificReviewFeedback>() {
      public APINodeList<AdgroupPlacementSpecificReviewFeedback> parseResponse(String response, APIContext context, APIRequest<AdgroupPlacementSpecificReviewFeedback> request) throws MalformedResponseException {
        return AdgroupPlacementSpecificReviewFeedback.parseResponse(response, context, request);
      }
    };
  }
}
