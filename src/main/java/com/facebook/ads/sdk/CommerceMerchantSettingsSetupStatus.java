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
public class CommerceMerchantSettingsSetupStatus extends APINode {
  @SerializedName("deals_setup")
  private String mDealsSetup = null;
  @SerializedName("marketplace_approval_status")
  private String mMarketplaceApprovalStatus = null;
  @SerializedName("marketplace_approval_status_details")
  private Object mMarketplaceApprovalStatusDetails = null;
  @SerializedName("payment_setup")
  private String mPaymentSetup = null;
  @SerializedName("review_status")
  private Object mReviewStatus = null;
  @SerializedName("shop_setup")
  private String mShopSetup = null;
  protected static Gson gson = null;

  public CommerceMerchantSettingsSetupStatus() {
  }

  public String getId() {
    return null;
  }
  public static CommerceMerchantSettingsSetupStatus loadJSON(String json, APIContext context, String header) {
    CommerceMerchantSettingsSetupStatus commerceMerchantSettingsSetupStatus = getGson().fromJson(json, CommerceMerchantSettingsSetupStatus.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(commerceMerchantSettingsSetupStatus.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    commerceMerchantSettingsSetupStatus.context = context;
    commerceMerchantSettingsSetupStatus.rawValue = json;
    commerceMerchantSettingsSetupStatus.header = header;
    return commerceMerchantSettingsSetupStatus;
  }

  public static APINodeList<CommerceMerchantSettingsSetupStatus> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CommerceMerchantSettingsSetupStatus> commerceMerchantSettingsSetupStatuss = new APINodeList<CommerceMerchantSettingsSetupStatus>(request, json, header);
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
          commerceMerchantSettingsSetupStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return commerceMerchantSettingsSetupStatuss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                commerceMerchantSettingsSetupStatuss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            commerceMerchantSettingsSetupStatuss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              commerceMerchantSettingsSetupStatuss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              commerceMerchantSettingsSetupStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  commerceMerchantSettingsSetupStatuss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              commerceMerchantSettingsSetupStatuss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return commerceMerchantSettingsSetupStatuss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              commerceMerchantSettingsSetupStatuss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return commerceMerchantSettingsSetupStatuss;
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
              commerceMerchantSettingsSetupStatuss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return commerceMerchantSettingsSetupStatuss;
          }

          // Sixth, check if it's pure JsonObject
          commerceMerchantSettingsSetupStatuss.clear();
          commerceMerchantSettingsSetupStatuss.add(loadJSON(json, context, header));
          return commerceMerchantSettingsSetupStatuss;
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


  public String getFieldDealsSetup() {
    return mDealsSetup;
  }

  public CommerceMerchantSettingsSetupStatus setFieldDealsSetup(String value) {
    this.mDealsSetup = value;
    return this;
  }

  public String getFieldMarketplaceApprovalStatus() {
    return mMarketplaceApprovalStatus;
  }

  public CommerceMerchantSettingsSetupStatus setFieldMarketplaceApprovalStatus(String value) {
    this.mMarketplaceApprovalStatus = value;
    return this;
  }

  public Object getFieldMarketplaceApprovalStatusDetails() {
    return mMarketplaceApprovalStatusDetails;
  }

  public CommerceMerchantSettingsSetupStatus setFieldMarketplaceApprovalStatusDetails(Object value) {
    this.mMarketplaceApprovalStatusDetails = value;
    return this;
  }

  public String getFieldPaymentSetup() {
    return mPaymentSetup;
  }

  public CommerceMerchantSettingsSetupStatus setFieldPaymentSetup(String value) {
    this.mPaymentSetup = value;
    return this;
  }

  public Object getFieldReviewStatus() {
    return mReviewStatus;
  }

  public CommerceMerchantSettingsSetupStatus setFieldReviewStatus(Object value) {
    this.mReviewStatus = value;
    return this;
  }

  public String getFieldShopSetup() {
    return mShopSetup;
  }

  public CommerceMerchantSettingsSetupStatus setFieldShopSetup(String value) {
    this.mShopSetup = value;
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

  public CommerceMerchantSettingsSetupStatus copyFrom(CommerceMerchantSettingsSetupStatus instance) {
    this.mDealsSetup = instance.mDealsSetup;
    this.mMarketplaceApprovalStatus = instance.mMarketplaceApprovalStatus;
    this.mMarketplaceApprovalStatusDetails = instance.mMarketplaceApprovalStatusDetails;
    this.mPaymentSetup = instance.mPaymentSetup;
    this.mReviewStatus = instance.mReviewStatus;
    this.mShopSetup = instance.mShopSetup;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CommerceMerchantSettingsSetupStatus> getParser() {
    return new APIRequest.ResponseParser<CommerceMerchantSettingsSetupStatus>() {
      public APINodeList<CommerceMerchantSettingsSetupStatus> parseResponse(String response, APIContext context, APIRequest<CommerceMerchantSettingsSetupStatus> request, String header) throws MalformedResponseException {
        return CommerceMerchantSettingsSetupStatus.parseResponse(response, context, request, header);
      }
    };
  }
}
