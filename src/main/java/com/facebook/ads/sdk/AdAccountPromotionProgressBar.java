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
public class AdAccountPromotionProgressBar extends APINode {
  @SerializedName("adaccount_permission")
  private Boolean mAdaccountPermission = null;
  @SerializedName("coupon_currency")
  private String mCouponCurrency = null;
  @SerializedName("coupon_value")
  private Long mCouponValue = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("progress_completed")
  private Boolean mProgressCompleted = null;
  @SerializedName("promotion_type")
  private String mPromotionType = null;
  @SerializedName("spend_requirement_in_cent")
  private Long mSpendRequirementInCent = null;
  @SerializedName("spend_since_enrollment")
  private Long mSpendSinceEnrollment = null;
  protected static Gson gson = null;

  public AdAccountPromotionProgressBar() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountPromotionProgressBar loadJSON(String json, APIContext context, String header) {
    AdAccountPromotionProgressBar adAccountPromotionProgressBar = getGson().fromJson(json, AdAccountPromotionProgressBar.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(adAccountPromotionProgressBar.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountPromotionProgressBar.context = context;
    adAccountPromotionProgressBar.rawValue = json;
    adAccountPromotionProgressBar.header = header;
    return adAccountPromotionProgressBar;
  }

  public static APINodeList<AdAccountPromotionProgressBar> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountPromotionProgressBar> adAccountPromotionProgressBars = new APINodeList<AdAccountPromotionProgressBar>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adAccountPromotionProgressBars.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountPromotionProgressBars;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountPromotionProgressBars.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountPromotionProgressBars.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountPromotionProgressBars.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountPromotionProgressBars.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountPromotionProgressBars.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountPromotionProgressBars.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountPromotionProgressBars;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountPromotionProgressBars.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountPromotionProgressBars;
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
              adAccountPromotionProgressBars.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountPromotionProgressBars;
          }

          // Sixth, check if it's pure JsonObject
          adAccountPromotionProgressBars.clear();
          adAccountPromotionProgressBars.add(loadJSON(json, context, header));
          return adAccountPromotionProgressBars;
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


  public Boolean getFieldAdaccountPermission() {
    return mAdaccountPermission;
  }

  public AdAccountPromotionProgressBar setFieldAdaccountPermission(Boolean value) {
    this.mAdaccountPermission = value;
    return this;
  }

  public String getFieldCouponCurrency() {
    return mCouponCurrency;
  }

  public AdAccountPromotionProgressBar setFieldCouponCurrency(String value) {
    this.mCouponCurrency = value;
    return this;
  }

  public Long getFieldCouponValue() {
    return mCouponValue;
  }

  public AdAccountPromotionProgressBar setFieldCouponValue(Long value) {
    this.mCouponValue = value;
    return this;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public AdAccountPromotionProgressBar setFieldExpirationTime(String value) {
    this.mExpirationTime = value;
    return this;
  }

  public Boolean getFieldProgressCompleted() {
    return mProgressCompleted;
  }

  public AdAccountPromotionProgressBar setFieldProgressCompleted(Boolean value) {
    this.mProgressCompleted = value;
    return this;
  }

  public String getFieldPromotionType() {
    return mPromotionType;
  }

  public AdAccountPromotionProgressBar setFieldPromotionType(String value) {
    this.mPromotionType = value;
    return this;
  }

  public Long getFieldSpendRequirementInCent() {
    return mSpendRequirementInCent;
  }

  public AdAccountPromotionProgressBar setFieldSpendRequirementInCent(Long value) {
    this.mSpendRequirementInCent = value;
    return this;
  }

  public Long getFieldSpendSinceEnrollment() {
    return mSpendSinceEnrollment;
  }

  public AdAccountPromotionProgressBar setFieldSpendSinceEnrollment(Long value) {
    this.mSpendSinceEnrollment = value;
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

  public AdAccountPromotionProgressBar copyFrom(AdAccountPromotionProgressBar instance) {
    this.mAdaccountPermission = instance.mAdaccountPermission;
    this.mCouponCurrency = instance.mCouponCurrency;
    this.mCouponValue = instance.mCouponValue;
    this.mExpirationTime = instance.mExpirationTime;
    this.mProgressCompleted = instance.mProgressCompleted;
    this.mPromotionType = instance.mPromotionType;
    this.mSpendRequirementInCent = instance.mSpendRequirementInCent;
    this.mSpendSinceEnrollment = instance.mSpendSinceEnrollment;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountPromotionProgressBar> getParser() {
    return new APIRequest.ResponseParser<AdAccountPromotionProgressBar>() {
      public APINodeList<AdAccountPromotionProgressBar> parseResponse(String response, APIContext context, APIRequest<AdAccountPromotionProgressBar> request, String header) throws MalformedResponseException {
        return AdAccountPromotionProgressBar.parseResponse(response, context, request, header);
      }
    };
  }
}
