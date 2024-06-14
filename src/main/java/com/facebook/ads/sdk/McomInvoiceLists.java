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
public class McomInvoiceLists extends APINode {
  @SerializedName("invoice_details")
  private List<McomInvoiceDetails> mInvoiceDetails = null;
  @SerializedName("invoice_ids")
  private List<String> mInvoiceIds = null;
  @SerializedName("page_id")
  private String mPageId = null;
  protected static Gson gson = null;

  public McomInvoiceLists() {
  }

  public String getId() {
    return null;
  }
  public static McomInvoiceLists loadJSON(String json, APIContext context, String header) {
    McomInvoiceLists mcomInvoiceLists = getGson().fromJson(json, McomInvoiceLists.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mcomInvoiceLists.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mcomInvoiceLists.context = context;
    mcomInvoiceLists.rawValue = json;
    mcomInvoiceLists.header = header;
    return mcomInvoiceLists;
  }

  public static APINodeList<McomInvoiceLists> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<McomInvoiceLists> mcomInvoiceListss = new APINodeList<McomInvoiceLists>(request, json, header);
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
          mcomInvoiceListss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mcomInvoiceListss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mcomInvoiceListss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mcomInvoiceListss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mcomInvoiceListss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mcomInvoiceListss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mcomInvoiceListss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mcomInvoiceListss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mcomInvoiceListss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mcomInvoiceListss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mcomInvoiceListss;
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
              mcomInvoiceListss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mcomInvoiceListss;
          }

          // Sixth, check if it's pure JsonObject
          mcomInvoiceListss.clear();
          mcomInvoiceListss.add(loadJSON(json, context, header));
          return mcomInvoiceListss;
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


  public List<McomInvoiceDetails> getFieldInvoiceDetails() {
    return mInvoiceDetails;
  }

  public McomInvoiceLists setFieldInvoiceDetails(List<McomInvoiceDetails> value) {
    this.mInvoiceDetails = value;
    return this;
  }

  public McomInvoiceLists setFieldInvoiceDetails(String value) {
    Type type = new TypeToken<List<McomInvoiceDetails>>(){}.getType();
    this.mInvoiceDetails = McomInvoiceDetails.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldInvoiceIds() {
    return mInvoiceIds;
  }

  public McomInvoiceLists setFieldInvoiceIds(List<String> value) {
    this.mInvoiceIds = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public McomInvoiceLists setFieldPageId(String value) {
    this.mPageId = value;
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

  public McomInvoiceLists copyFrom(McomInvoiceLists instance) {
    this.mInvoiceDetails = instance.mInvoiceDetails;
    this.mInvoiceIds = instance.mInvoiceIds;
    this.mPageId = instance.mPageId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<McomInvoiceLists> getParser() {
    return new APIRequest.ResponseParser<McomInvoiceLists>() {
      public APINodeList<McomInvoiceLists> parseResponse(String response, APIContext context, APIRequest<McomInvoiceLists> request, String header) throws MalformedResponseException {
        return McomInvoiceLists.parseResponse(response, context, request, header);
      }
    };
  }
}
