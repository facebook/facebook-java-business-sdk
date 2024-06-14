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
public class AdAccountSubsidyAmountDetails extends APINode {
  @SerializedName("entered_amount")
  private CurrencyAmount mEnteredAmount = null;
  @SerializedName("fee_amount")
  private CurrencyAmount mFeeAmount = null;
  @SerializedName("total_amount")
  private CurrencyAmount mTotalAmount = null;
  protected static Gson gson = null;

  public AdAccountSubsidyAmountDetails() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountSubsidyAmountDetails loadJSON(String json, APIContext context, String header) {
    AdAccountSubsidyAmountDetails adAccountSubsidyAmountDetails = getGson().fromJson(json, AdAccountSubsidyAmountDetails.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountSubsidyAmountDetails.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountSubsidyAmountDetails.context = context;
    adAccountSubsidyAmountDetails.rawValue = json;
    adAccountSubsidyAmountDetails.header = header;
    return adAccountSubsidyAmountDetails;
  }

  public static APINodeList<AdAccountSubsidyAmountDetails> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountSubsidyAmountDetails> adAccountSubsidyAmountDetailss = new APINodeList<AdAccountSubsidyAmountDetails>(request, json, header);
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
          adAccountSubsidyAmountDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountSubsidyAmountDetailss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountSubsidyAmountDetailss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountSubsidyAmountDetailss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountSubsidyAmountDetailss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountSubsidyAmountDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountSubsidyAmountDetailss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountSubsidyAmountDetailss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountSubsidyAmountDetailss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountSubsidyAmountDetailss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountSubsidyAmountDetailss;
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
              adAccountSubsidyAmountDetailss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountSubsidyAmountDetailss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountSubsidyAmountDetailss.clear();
          adAccountSubsidyAmountDetailss.add(loadJSON(json, context, header));
          return adAccountSubsidyAmountDetailss;
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


  public CurrencyAmount getFieldEnteredAmount() {
    return mEnteredAmount;
  }

  public AdAccountSubsidyAmountDetails setFieldEnteredAmount(CurrencyAmount value) {
    this.mEnteredAmount = value;
    return this;
  }

  public AdAccountSubsidyAmountDetails setFieldEnteredAmount(String value) {
    Type type = new TypeToken<CurrencyAmount>(){}.getType();
    this.mEnteredAmount = CurrencyAmount.getGson().fromJson(value, type);
    return this;
  }
  public CurrencyAmount getFieldFeeAmount() {
    return mFeeAmount;
  }

  public AdAccountSubsidyAmountDetails setFieldFeeAmount(CurrencyAmount value) {
    this.mFeeAmount = value;
    return this;
  }

  public AdAccountSubsidyAmountDetails setFieldFeeAmount(String value) {
    Type type = new TypeToken<CurrencyAmount>(){}.getType();
    this.mFeeAmount = CurrencyAmount.getGson().fromJson(value, type);
    return this;
  }
  public CurrencyAmount getFieldTotalAmount() {
    return mTotalAmount;
  }

  public AdAccountSubsidyAmountDetails setFieldTotalAmount(CurrencyAmount value) {
    this.mTotalAmount = value;
    return this;
  }

  public AdAccountSubsidyAmountDetails setFieldTotalAmount(String value) {
    Type type = new TypeToken<CurrencyAmount>(){}.getType();
    this.mTotalAmount = CurrencyAmount.getGson().fromJson(value, type);
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

  public AdAccountSubsidyAmountDetails copyFrom(AdAccountSubsidyAmountDetails instance) {
    this.mEnteredAmount = instance.mEnteredAmount;
    this.mFeeAmount = instance.mFeeAmount;
    this.mTotalAmount = instance.mTotalAmount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountSubsidyAmountDetails> getParser() {
    return new APIRequest.ResponseParser<AdAccountSubsidyAmountDetails>() {
      public APINodeList<AdAccountSubsidyAmountDetails> parseResponse(String response, APIContext context, APIRequest<AdAccountSubsidyAmountDetails> request, String header) throws MalformedResponseException {
        return AdAccountSubsidyAmountDetails.parseResponse(response, context, request, header);
      }
    };
  }
}
