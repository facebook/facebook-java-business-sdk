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
public class AdsImageCrops extends APINode {
  @SerializedName("100x100")
  private List<JsonArray> m100x100 = null;
  @SerializedName("100x72")
  private List<JsonArray> m100x72 = null;
  @SerializedName("191x100")
  private List<JsonArray> m191x100 = null;
  @SerializedName("400x150")
  private List<JsonArray> m400x150 = null;
  @SerializedName("400x500")
  private List<JsonArray> m400x500 = null;
  @SerializedName("600x360")
  private List<JsonArray> m600x360 = null;
  @SerializedName("90x160")
  private List<JsonArray> m90x160 = null;
  protected static Gson gson = null;

  public AdsImageCrops() {
  }

  public String getId() {
    return null;
  }
  public static AdsImageCrops loadJSON(String json, APIContext context, String header) {
    AdsImageCrops adsImageCrops = getGson().fromJson(json, AdsImageCrops.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsImageCrops.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsImageCrops.context = context;
    adsImageCrops.rawValue = json;
    adsImageCrops.header = header;
    return adsImageCrops;
  }

  public static APINodeList<AdsImageCrops> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsImageCrops> adsImageCropss = new APINodeList<AdsImageCrops>(request, json, header);
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
          adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsImageCropss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsImageCropss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsImageCropss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsImageCropss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsImageCropss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsImageCropss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsImageCropss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsImageCropss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsImageCropss;
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
              adsImageCropss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsImageCropss;
          }

          // Sixth, check if it's pure JsonObject
          adsImageCropss.clear();
          adsImageCropss.add(loadJSON(json, context, header));
          return adsImageCropss;
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


  public List<JsonArray> getField100x100() {
    return m100x100;
  }

  public AdsImageCrops setField100x100(List<JsonArray> value) {
    this.m100x100 = value;
    return this;
  }

  public List<JsonArray> getField100x72() {
    return m100x72;
  }

  public AdsImageCrops setField100x72(List<JsonArray> value) {
    this.m100x72 = value;
    return this;
  }

  public List<JsonArray> getField191x100() {
    return m191x100;
  }

  public AdsImageCrops setField191x100(List<JsonArray> value) {
    this.m191x100 = value;
    return this;
  }

  public List<JsonArray> getField400x150() {
    return m400x150;
  }

  public AdsImageCrops setField400x150(List<JsonArray> value) {
    this.m400x150 = value;
    return this;
  }

  public List<JsonArray> getField400x500() {
    return m400x500;
  }

  public AdsImageCrops setField400x500(List<JsonArray> value) {
    this.m400x500 = value;
    return this;
  }

  public List<JsonArray> getField600x360() {
    return m600x360;
  }

  public AdsImageCrops setField600x360(List<JsonArray> value) {
    this.m600x360 = value;
    return this;
  }

  public List<JsonArray> getField90x160() {
    return m90x160;
  }

  public AdsImageCrops setField90x160(List<JsonArray> value) {
    this.m90x160 = value;
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

  public AdsImageCrops copyFrom(AdsImageCrops instance) {
    this.m100x100 = instance.m100x100;
    this.m100x72 = instance.m100x72;
    this.m191x100 = instance.m191x100;
    this.m400x150 = instance.m400x150;
    this.m400x500 = instance.m400x500;
    this.m600x360 = instance.m600x360;
    this.m90x160 = instance.m90x160;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsImageCrops> getParser() {
    return new APIRequest.ResponseParser<AdsImageCrops>() {
      public APINodeList<AdsImageCrops> parseResponse(String response, APIContext context, APIRequest<AdsImageCrops> request, String header) throws MalformedResponseException {
        return AdsImageCrops.parseResponse(response, context, request, header);
      }
    };
  }
}
