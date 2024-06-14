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
public class ProductItemSubscriptionInfo extends APINode {
  @SerializedName("is_subscribable")
  private Boolean mIsSubscribable = null;
  @SerializedName("subscription_billing_period")
  private Long mSubscriptionBillingPeriod = null;
  @SerializedName("subscription_billing_type")
  private String mSubscriptionBillingType = null;
  protected static Gson gson = null;

  public ProductItemSubscriptionInfo() {
  }

  public String getId() {
    return null;
  }
  public static ProductItemSubscriptionInfo loadJSON(String json, APIContext context, String header) {
    ProductItemSubscriptionInfo productItemSubscriptionInfo = getGson().fromJson(json, ProductItemSubscriptionInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productItemSubscriptionInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productItemSubscriptionInfo.context = context;
    productItemSubscriptionInfo.rawValue = json;
    productItemSubscriptionInfo.header = header;
    return productItemSubscriptionInfo;
  }

  public static APINodeList<ProductItemSubscriptionInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductItemSubscriptionInfo> productItemSubscriptionInfos = new APINodeList<ProductItemSubscriptionInfo>(request, json, header);
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
          productItemSubscriptionInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productItemSubscriptionInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productItemSubscriptionInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productItemSubscriptionInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productItemSubscriptionInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItemSubscriptionInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productItemSubscriptionInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItemSubscriptionInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productItemSubscriptionInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItemSubscriptionInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productItemSubscriptionInfos;
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
              productItemSubscriptionInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productItemSubscriptionInfos;
          }

          // Sixth, check if it's pure JsonObject
          productItemSubscriptionInfos.clear();
          productItemSubscriptionInfos.add(loadJSON(json, context, header));
          return productItemSubscriptionInfos;
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


  public Boolean getFieldIsSubscribable() {
    return mIsSubscribable;
  }

  public ProductItemSubscriptionInfo setFieldIsSubscribable(Boolean value) {
    this.mIsSubscribable = value;
    return this;
  }

  public Long getFieldSubscriptionBillingPeriod() {
    return mSubscriptionBillingPeriod;
  }

  public ProductItemSubscriptionInfo setFieldSubscriptionBillingPeriod(Long value) {
    this.mSubscriptionBillingPeriod = value;
    return this;
  }

  public String getFieldSubscriptionBillingType() {
    return mSubscriptionBillingType;
  }

  public ProductItemSubscriptionInfo setFieldSubscriptionBillingType(String value) {
    this.mSubscriptionBillingType = value;
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

  public ProductItemSubscriptionInfo copyFrom(ProductItemSubscriptionInfo instance) {
    this.mIsSubscribable = instance.mIsSubscribable;
    this.mSubscriptionBillingPeriod = instance.mSubscriptionBillingPeriod;
    this.mSubscriptionBillingType = instance.mSubscriptionBillingType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItemSubscriptionInfo> getParser() {
    return new APIRequest.ResponseParser<ProductItemSubscriptionInfo>() {
      public APINodeList<ProductItemSubscriptionInfo> parseResponse(String response, APIContext context, APIRequest<ProductItemSubscriptionInfo> request, String header) throws MalformedResponseException {
        return ProductItemSubscriptionInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
