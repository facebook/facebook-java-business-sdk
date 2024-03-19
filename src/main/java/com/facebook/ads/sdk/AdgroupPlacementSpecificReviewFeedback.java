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
public class AdgroupPlacementSpecificReviewFeedback extends APINode {
  @SerializedName("account_admin")
  private Map<String, String> mAccountAdmin = null;
  @SerializedName("ad")
  private Map<String, String> mAd = null;
  @SerializedName("ads_conversion_experiences")
  private Map<String, String> mAdsConversionExperiences = null;
  @SerializedName("b2c")
  private Map<String, String> mB2c = null;
  @SerializedName("b2c_commerce_unified")
  private Map<String, String> mB2cCommerceUnified = null;
  @SerializedName("bsg")
  private Map<String, String> mBsg = null;
  @SerializedName("city_community")
  private Map<String, String> mCityCommunity = null;
  @SerializedName("commerce")
  private Map<String, String> mCommerce = null;
  @SerializedName("compromise")
  private Map<String, String> mCompromise = null;
  @SerializedName("daily_deals")
  private Map<String, String> mDailyDeals = null;
  @SerializedName("daily_deals_legacy")
  private Map<String, String> mDailyDealsLegacy = null;
  @SerializedName("dpa")
  private Map<String, String> mDpa = null;
  @SerializedName("dri_copyright")
  private Map<String, String> mDriCopyright = null;
  @SerializedName("dri_counterfeit")
  private Map<String, String> mDriCounterfeit = null;
  @SerializedName("facebook")
  private Map<String, String> mFacebook = null;
  @SerializedName("facebook_pages_live_shopping")
  private Map<String, String> mFacebookPagesLiveShopping = null;
  @SerializedName("independent_work")
  private Map<String, String> mIndependentWork = null;
  @SerializedName("instagram")
  private Map<String, String> mInstagram = null;
  @SerializedName("instagram_shop")
  private Map<String, String> mInstagramShop = null;
  @SerializedName("job_search")
  private Map<String, String> mJobSearch = null;
  @SerializedName("lead_gen_honeypot")
  private Map<String, String> mLeadGenHoneypot = null;
  @SerializedName("marketplace")
  private Map<String, String> mMarketplace = null;
  @SerializedName("marketplace_home_rentals")
  private Map<String, String> mMarketplaceHomeRentals = null;
  @SerializedName("marketplace_home_sales")
  private Map<String, String> mMarketplaceHomeSales = null;
  @SerializedName("marketplace_motors")
  private Map<String, String> mMarketplaceMotors = null;
  @SerializedName("marketplace_shops")
  private Map<String, String> mMarketplaceShops = null;
  @SerializedName("max_review_placements")
  private Map<String, String> mMaxReviewPlacements = null;
  @SerializedName("neighborhoods")
  private Map<String, String> mNeighborhoods = null;
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
  @SerializedName("traffic_quality")
  private Map<String, String> mTrafficQuality = null;
  @SerializedName("unified_commerce_content")
  private Map<String, String> mUnifiedCommerceContent = null;
  @SerializedName("whatsapp")
  private Map<String, String> mWhatsapp = null;
  protected static Gson gson = null;

  public AdgroupPlacementSpecificReviewFeedback() {
  }

  public String getId() {
    return null;
  }
  public static AdgroupPlacementSpecificReviewFeedback loadJSON(String json, APIContext context, String header) {
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
      }
    }
    adgroupPlacementSpecificReviewFeedback.context = context;
    adgroupPlacementSpecificReviewFeedback.rawValue = json;
    adgroupPlacementSpecificReviewFeedback.header = header;
    return adgroupPlacementSpecificReviewFeedback;
  }

  public static APINodeList<AdgroupPlacementSpecificReviewFeedback> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdgroupPlacementSpecificReviewFeedback> adgroupPlacementSpecificReviewFeedbacks = new APINodeList<AdgroupPlacementSpecificReviewFeedback>(request, json, header);
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
          adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adgroupPlacementSpecificReviewFeedbacks;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(entry.getValue().toString(), context, header));
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
              adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(value.toString(), context, header));
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
          adgroupPlacementSpecificReviewFeedbacks.add(loadJSON(json, context, header));
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


  public Map<String, String> getFieldAccountAdmin() {
    return mAccountAdmin;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldAccountAdmin(Map<String, String> value) {
    this.mAccountAdmin = value;
    return this;
  }

  public Map<String, String> getFieldAd() {
    return mAd;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldAd(Map<String, String> value) {
    this.mAd = value;
    return this;
  }

  public Map<String, String> getFieldAdsConversionExperiences() {
    return mAdsConversionExperiences;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldAdsConversionExperiences(Map<String, String> value) {
    this.mAdsConversionExperiences = value;
    return this;
  }

  public Map<String, String> getFieldB2c() {
    return mB2c;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldB2c(Map<String, String> value) {
    this.mB2c = value;
    return this;
  }

  public Map<String, String> getFieldB2cCommerceUnified() {
    return mB2cCommerceUnified;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldB2cCommerceUnified(Map<String, String> value) {
    this.mB2cCommerceUnified = value;
    return this;
  }

  public Map<String, String> getFieldBsg() {
    return mBsg;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldBsg(Map<String, String> value) {
    this.mBsg = value;
    return this;
  }

  public Map<String, String> getFieldCityCommunity() {
    return mCityCommunity;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldCityCommunity(Map<String, String> value) {
    this.mCityCommunity = value;
    return this;
  }

  public Map<String, String> getFieldCommerce() {
    return mCommerce;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldCommerce(Map<String, String> value) {
    this.mCommerce = value;
    return this;
  }

  public Map<String, String> getFieldCompromise() {
    return mCompromise;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldCompromise(Map<String, String> value) {
    this.mCompromise = value;
    return this;
  }

  public Map<String, String> getFieldDailyDeals() {
    return mDailyDeals;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDailyDeals(Map<String, String> value) {
    this.mDailyDeals = value;
    return this;
  }

  public Map<String, String> getFieldDailyDealsLegacy() {
    return mDailyDealsLegacy;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDailyDealsLegacy(Map<String, String> value) {
    this.mDailyDealsLegacy = value;
    return this;
  }

  public Map<String, String> getFieldDpa() {
    return mDpa;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDpa(Map<String, String> value) {
    this.mDpa = value;
    return this;
  }

  public Map<String, String> getFieldDriCopyright() {
    return mDriCopyright;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDriCopyright(Map<String, String> value) {
    this.mDriCopyright = value;
    return this;
  }

  public Map<String, String> getFieldDriCounterfeit() {
    return mDriCounterfeit;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDriCounterfeit(Map<String, String> value) {
    this.mDriCounterfeit = value;
    return this;
  }

  public Map<String, String> getFieldFacebook() {
    return mFacebook;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldFacebook(Map<String, String> value) {
    this.mFacebook = value;
    return this;
  }

  public Map<String, String> getFieldFacebookPagesLiveShopping() {
    return mFacebookPagesLiveShopping;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldFacebookPagesLiveShopping(Map<String, String> value) {
    this.mFacebookPagesLiveShopping = value;
    return this;
  }

  public Map<String, String> getFieldIndependentWork() {
    return mIndependentWork;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldIndependentWork(Map<String, String> value) {
    this.mIndependentWork = value;
    return this;
  }

  public Map<String, String> getFieldInstagram() {
    return mInstagram;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldInstagram(Map<String, String> value) {
    this.mInstagram = value;
    return this;
  }

  public Map<String, String> getFieldInstagramShop() {
    return mInstagramShop;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldInstagramShop(Map<String, String> value) {
    this.mInstagramShop = value;
    return this;
  }

  public Map<String, String> getFieldJobSearch() {
    return mJobSearch;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldJobSearch(Map<String, String> value) {
    this.mJobSearch = value;
    return this;
  }

  public Map<String, String> getFieldLeadGenHoneypot() {
    return mLeadGenHoneypot;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldLeadGenHoneypot(Map<String, String> value) {
    this.mLeadGenHoneypot = value;
    return this;
  }

  public Map<String, String> getFieldMarketplace() {
    return mMarketplace;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplace(Map<String, String> value) {
    this.mMarketplace = value;
    return this;
  }

  public Map<String, String> getFieldMarketplaceHomeRentals() {
    return mMarketplaceHomeRentals;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplaceHomeRentals(Map<String, String> value) {
    this.mMarketplaceHomeRentals = value;
    return this;
  }

  public Map<String, String> getFieldMarketplaceHomeSales() {
    return mMarketplaceHomeSales;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplaceHomeSales(Map<String, String> value) {
    this.mMarketplaceHomeSales = value;
    return this;
  }

  public Map<String, String> getFieldMarketplaceMotors() {
    return mMarketplaceMotors;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplaceMotors(Map<String, String> value) {
    this.mMarketplaceMotors = value;
    return this;
  }

  public Map<String, String> getFieldMarketplaceShops() {
    return mMarketplaceShops;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplaceShops(Map<String, String> value) {
    this.mMarketplaceShops = value;
    return this;
  }

  public Map<String, String> getFieldMaxReviewPlacements() {
    return mMaxReviewPlacements;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMaxReviewPlacements(Map<String, String> value) {
    this.mMaxReviewPlacements = value;
    return this;
  }

  public Map<String, String> getFieldNeighborhoods() {
    return mNeighborhoods;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldNeighborhoods(Map<String, String> value) {
    this.mNeighborhoods = value;
    return this;
  }

  public Map<String, String> getFieldPageAdmin() {
    return mPageAdmin;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldPageAdmin(Map<String, String> value) {
    this.mPageAdmin = value;
    return this;
  }

  public Map<String, String> getFieldProduct() {
    return mProduct;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldProduct(Map<String, String> value) {
    this.mProduct = value;
    return this;
  }

  public Map<String, String> getFieldProductService() {
    return mProductService;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldProductService(Map<String, String> value) {
    this.mProductService = value;
    return this;
  }

  public Map<String, String> getFieldProfile() {
    return mProfile;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldProfile(Map<String, String> value) {
    this.mProfile = value;
    return this;
  }

  public Map<String, String> getFieldSeller() {
    return mSeller;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldSeller(Map<String, String> value) {
    this.mSeller = value;
    return this;
  }

  public Map<String, String> getFieldShops() {
    return mShops;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldShops(Map<String, String> value) {
    this.mShops = value;
    return this;
  }

  public Map<String, String> getFieldTrafficQuality() {
    return mTrafficQuality;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldTrafficQuality(Map<String, String> value) {
    this.mTrafficQuality = value;
    return this;
  }

  public Map<String, String> getFieldUnifiedCommerceContent() {
    return mUnifiedCommerceContent;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldUnifiedCommerceContent(Map<String, String> value) {
    this.mUnifiedCommerceContent = value;
    return this;
  }

  public Map<String, String> getFieldWhatsapp() {
    return mWhatsapp;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldWhatsapp(Map<String, String> value) {
    this.mWhatsapp = value;
    return this;
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
    this.mAdsConversionExperiences = instance.mAdsConversionExperiences;
    this.mB2c = instance.mB2c;
    this.mB2cCommerceUnified = instance.mB2cCommerceUnified;
    this.mBsg = instance.mBsg;
    this.mCityCommunity = instance.mCityCommunity;
    this.mCommerce = instance.mCommerce;
    this.mCompromise = instance.mCompromise;
    this.mDailyDeals = instance.mDailyDeals;
    this.mDailyDealsLegacy = instance.mDailyDealsLegacy;
    this.mDpa = instance.mDpa;
    this.mDriCopyright = instance.mDriCopyright;
    this.mDriCounterfeit = instance.mDriCounterfeit;
    this.mFacebook = instance.mFacebook;
    this.mFacebookPagesLiveShopping = instance.mFacebookPagesLiveShopping;
    this.mIndependentWork = instance.mIndependentWork;
    this.mInstagram = instance.mInstagram;
    this.mInstagramShop = instance.mInstagramShop;
    this.mJobSearch = instance.mJobSearch;
    this.mLeadGenHoneypot = instance.mLeadGenHoneypot;
    this.mMarketplace = instance.mMarketplace;
    this.mMarketplaceHomeRentals = instance.mMarketplaceHomeRentals;
    this.mMarketplaceHomeSales = instance.mMarketplaceHomeSales;
    this.mMarketplaceMotors = instance.mMarketplaceMotors;
    this.mMarketplaceShops = instance.mMarketplaceShops;
    this.mMaxReviewPlacements = instance.mMaxReviewPlacements;
    this.mNeighborhoods = instance.mNeighborhoods;
    this.mPageAdmin = instance.mPageAdmin;
    this.mProduct = instance.mProduct;
    this.mProductService = instance.mProductService;
    this.mProfile = instance.mProfile;
    this.mSeller = instance.mSeller;
    this.mShops = instance.mShops;
    this.mTrafficQuality = instance.mTrafficQuality;
    this.mUnifiedCommerceContent = instance.mUnifiedCommerceContent;
    this.mWhatsapp = instance.mWhatsapp;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdgroupPlacementSpecificReviewFeedback> getParser() {
    return new APIRequest.ResponseParser<AdgroupPlacementSpecificReviewFeedback>() {
      public APINodeList<AdgroupPlacementSpecificReviewFeedback> parseResponse(String response, APIContext context, APIRequest<AdgroupPlacementSpecificReviewFeedback> request, String header) throws MalformedResponseException {
        return AdgroupPlacementSpecificReviewFeedback.parseResponse(response, context, request, header);
      }
    };
  }
}
