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
public class AdAccountPaymentDetails extends APINode {
  @SerializedName("amount")
  private CurrencyAmount mAmount = null;
  @SerializedName("create_date")
  private Long mCreateDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_action_status")
  private String mLastActionStatus = null;
  @SerializedName("metadata")
  private Object mMetadata = null;
  @SerializedName("payment_details_id")
  private String mPaymentDetailsId = null;
  protected static Gson gson = null;

  public AdAccountPaymentDetails() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountPaymentDetails loadJSON(String json, APIContext context, String header) {
    AdAccountPaymentDetails adAccountPaymentDetails = getGson().fromJson(json, AdAccountPaymentDetails.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountPaymentDetails.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountPaymentDetails.context = context;
    adAccountPaymentDetails.rawValue = json;
    adAccountPaymentDetails.header = header;
    return adAccountPaymentDetails;
  }

  public static APINodeList<AdAccountPaymentDetails> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountPaymentDetails> adAccountPaymentDetailss = new APINodeList<AdAccountPaymentDetails>(request, json, header);
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
          adAccountPaymentDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountPaymentDetailss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountPaymentDetailss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountPaymentDetailss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountPaymentDetailss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountPaymentDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountPaymentDetailss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountPaymentDetailss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountPaymentDetailss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountPaymentDetailss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountPaymentDetailss;
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
              adAccountPaymentDetailss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountPaymentDetailss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountPaymentDetailss.clear();
          adAccountPaymentDetailss.add(loadJSON(json, context, header));
          return adAccountPaymentDetailss;
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


  public CurrencyAmount getFieldAmount() {
    return mAmount;
  }

  public AdAccountPaymentDetails setFieldAmount(CurrencyAmount value) {
    this.mAmount = value;
    return this;
  }

  public AdAccountPaymentDetails setFieldAmount(String value) {
    Type type = new TypeToken<CurrencyAmount>(){}.getType();
    this.mAmount = CurrencyAmount.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldCreateDate() {
    return mCreateDate;
  }

  public AdAccountPaymentDetails setFieldCreateDate(Long value) {
    this.mCreateDate = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdAccountPaymentDetails setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldLastActionStatus() {
    return mLastActionStatus;
  }

  public AdAccountPaymentDetails setFieldLastActionStatus(String value) {
    this.mLastActionStatus = value;
    return this;
  }

  public Object getFieldMetadata() {
    return mMetadata;
  }

  public AdAccountPaymentDetails setFieldMetadata(Object value) {
    this.mMetadata = value;
    return this;
  }

  public String getFieldPaymentDetailsId() {
    return mPaymentDetailsId;
  }

  public AdAccountPaymentDetails setFieldPaymentDetailsId(String value) {
    this.mPaymentDetailsId = value;
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

  public AdAccountPaymentDetails copyFrom(AdAccountPaymentDetails instance) {
    this.mAmount = instance.mAmount;
    this.mCreateDate = instance.mCreateDate;
    this.mId = instance.mId;
    this.mLastActionStatus = instance.mLastActionStatus;
    this.mMetadata = instance.mMetadata;
    this.mPaymentDetailsId = instance.mPaymentDetailsId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountPaymentDetails> getParser() {
    return new APIRequest.ResponseParser<AdAccountPaymentDetails>() {
      public APINodeList<AdAccountPaymentDetails> parseResponse(String response, APIContext context, APIRequest<AdAccountPaymentDetails> request, String header) throws MalformedResponseException {
        return AdAccountPaymentDetails.parseResponse(response, context, request, header);
      }
    };
  }
}
