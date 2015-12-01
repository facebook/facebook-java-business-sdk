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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdsImageCrops extends APINode {
  @SerializedName("191x100")
  private List<JsonArray> m191x100 = null;
  @SerializedName("100x72")
  private List<JsonArray> m100x72 = null;
  @SerializedName("400x150")
  private List<JsonArray> m400x150 = null;
  @SerializedName("600x360")
  private List<JsonArray> m600x360 = null;
  @SerializedName("100x100")
  private List<JsonArray> m100x100 = null;
  protected static Gson gson = null;

  public AdsImageCrops() {
  }

  public String getId() {
    return null;
  }
  public static AdsImageCrops loadJSON(String json, APIContext context) {
    AdsImageCrops adsImageCrops = getGson().fromJson(json, AdsImageCrops.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsImageCrops.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsImageCrops.mContext = context;
    adsImageCrops.rawValue = json;
    return adsImageCrops;
  }

  public static APINodeList<AdsImageCrops> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdsImageCrops> adsImageCropss = new APINodeList<AdsImageCrops>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsImageCropss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adsImageCropss.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adsImageCropss.add(loadJSON(obj.toString(), context));
          }
          return adsImageCropss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsImageCropss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsImageCropss;
        } else {
          // Fifth, check if it's pure JsonObject
          adsImageCropss.add(loadJSON(json, context));
          return adsImageCropss;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public List<JsonArray> getField191x100() {
    return m191x100;
  }

  public AdsImageCrops setField191x100(List<JsonArray> value) {
    this.m191x100 = value;
    return this;
  }

  public List<JsonArray> getField100x72() {
    return m100x72;
  }

  public AdsImageCrops setField100x72(List<JsonArray> value) {
    this.m100x72 = value;
    return this;
  }

  public List<JsonArray> getField400x150() {
    return m400x150;
  }

  public AdsImageCrops setField400x150(List<JsonArray> value) {
    this.m400x150 = value;
    return this;
  }

  public List<JsonArray> getField600x360() {
    return m600x360;
  }

  public AdsImageCrops setField600x360(List<JsonArray> value) {
    this.m600x360 = value;
    return this;
  }

  public List<JsonArray> getField100x100() {
    return m100x100;
  }

  public AdsImageCrops setField100x100(List<JsonArray> value) {
    this.m100x100 = value;
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
    this.m191x100 = instance.m191x100;
    this.m100x72 = instance.m100x72;
    this.m400x150 = instance.m400x150;
    this.m600x360 = instance.m600x360;
    this.m100x100 = instance.m100x100;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}