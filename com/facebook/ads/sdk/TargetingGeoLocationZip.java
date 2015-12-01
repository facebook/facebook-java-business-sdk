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


public class TargetingGeoLocationZip extends APINode {
  @SerializedName("key")
  private String mKey = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("primary_city_id")
  private Long mPrimaryCityId = null;
  @SerializedName("region_id")
  private Long mRegionId = null;
  @SerializedName("country")
  private String mCountry = null;
  protected static Gson gson = null;

  public TargetingGeoLocationZip() {
  }

  public String getId() {
    return null;
  }
  public static TargetingGeoLocationZip loadJSON(String json, APIContext context) {
    TargetingGeoLocationZip targetingGeoLocationZip = getGson().fromJson(json, TargetingGeoLocationZip.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingGeoLocationZip.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingGeoLocationZip.mContext = context;
    targetingGeoLocationZip.rawValue = json;
    return targetingGeoLocationZip;
  }

  public static APINodeList<TargetingGeoLocationZip> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<TargetingGeoLocationZip> targetingGeoLocationZips = new APINodeList<TargetingGeoLocationZip>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          targetingGeoLocationZips.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetingGeoLocationZips;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            targetingGeoLocationZips.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingGeoLocationZips.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            targetingGeoLocationZips.add(loadJSON(obj.toString(), context));
          }
          return targetingGeoLocationZips;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingGeoLocationZips.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetingGeoLocationZips;
        } else {
          // Fifth, check if it's pure JsonObject
          targetingGeoLocationZips.add(loadJSON(json, context));
          return targetingGeoLocationZips;
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


  public String getFieldKey() {
    return mKey;
  }

  public TargetingGeoLocationZip setFieldKey(String value) {
    this.mKey = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public TargetingGeoLocationZip setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldPrimaryCityId() {
    return mPrimaryCityId;
  }

  public TargetingGeoLocationZip setFieldPrimaryCityId(Long value) {
    this.mPrimaryCityId = value;
    return this;
  }

  public Long getFieldRegionId() {
    return mRegionId;
  }

  public TargetingGeoLocationZip setFieldRegionId(Long value) {
    this.mRegionId = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public TargetingGeoLocationZip setFieldCountry(String value) {
    this.mCountry = value;
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

  public TargetingGeoLocationZip copyFrom(TargetingGeoLocationZip instance) {
    this.mKey = instance.mKey;
    this.mName = instance.mName;
    this.mPrimaryCityId = instance.mPrimaryCityId;
    this.mRegionId = instance.mRegionId;
    this.mCountry = instance.mCountry;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}