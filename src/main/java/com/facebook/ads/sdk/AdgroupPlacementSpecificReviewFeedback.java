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
  @SerializedName("page_admin")
  private Map<String, String> mPageAdmin = null;
  @SerializedName("product")
  private Map<String, String> mProduct = null;
  @SerializedName("product_service")
  private Map<String, String> mProductService = null;
  @SerializedName("seller")
  private Map<String, String> mSeller = null;
  protected static Gson gson = null;

  public AdgroupPlacementSpecificReviewFeedback() {
  }

  public String getId() {
    return null;
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

  public Map<String, String> getFieldB2c() {
    return mB2c;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldB2c(Map<String, String> value) {
    this.mB2c = value;
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

  public Map<String, String> getFieldDpa() {
    return mDpa;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldDpa(Map<String, String> value) {
    this.mDpa = value;
    return this;
  }

  public Map<String, String> getFieldFacebook() {
    return mFacebook;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldFacebook(Map<String, String> value) {
    this.mFacebook = value;
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

  public Map<String, String> getFieldMarketplace() {
    return mMarketplace;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldMarketplace(Map<String, String> value) {
    this.mMarketplace = value;
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

  public Map<String, String> getFieldSeller() {
    return mSeller;
  }

  public AdgroupPlacementSpecificReviewFeedback setFieldSeller(Map<String, String> value) {
    this.mSeller = value;
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
    this.mB2c = instance.mB2c;
    this.mBsg = instance.mBsg;
    this.mCityCommunity = instance.mCityCommunity;
    this.mDpa = instance.mDpa;
    this.mFacebook = instance.mFacebook;
    this.mInstagram = instance.mInstagram;
    this.mInstagramShop = instance.mInstagramShop;
    this.mMarketplace = instance.mMarketplace;
    this.mPageAdmin = instance.mPageAdmin;
    this.mProduct = instance.mProduct;
    this.mProductService = instance.mProductService;
    this.mSeller = instance.mSeller;
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
