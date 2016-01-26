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


public class TargetingProductAudienceSpec extends APINode {
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("inclusions")
  private List<TargetingProductAudienceSubSpec> mInclusions = null;
  @SerializedName("exclusions")
  private List<TargetingProductAudienceSubSpec> mExclusions = null;
  protected static Gson gson = null;

  public TargetingProductAudienceSpec() {
  }

  public String getId() {
    return null;
  }
  public static TargetingProductAudienceSpec loadJSON(String json, APIContext context) {
    TargetingProductAudienceSpec targetingProductAudienceSpec = getGson().fromJson(json, TargetingProductAudienceSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingProductAudienceSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingProductAudienceSpec.mContext = context;
    targetingProductAudienceSpec.rawValue = json;
    return targetingProductAudienceSpec;
  }

  public static APINodeList<TargetingProductAudienceSpec> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<TargetingProductAudienceSpec> targetingProductAudienceSpecs = new APINodeList<TargetingProductAudienceSpec>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          targetingProductAudienceSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetingProductAudienceSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            targetingProductAudienceSpecs.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingProductAudienceSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            targetingProductAudienceSpecs.add(loadJSON(obj.toString(), context));
          }
          return targetingProductAudienceSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingProductAudienceSpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetingProductAudienceSpecs;
        } else {
          // Fifth, check if it's pure JsonObject
          targetingProductAudienceSpecs.add(loadJSON(json, context));
          return targetingProductAudienceSpecs;
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


  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public TargetingProductAudienceSpec setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }

  public List<TargetingProductAudienceSubSpec> getFieldInclusions() {
    return mInclusions;
  }

  public TargetingProductAudienceSpec setFieldInclusions(List<TargetingProductAudienceSubSpec> value) {
    this.mInclusions = value;
    return this;
  }

  public TargetingProductAudienceSpec setFieldInclusions(String value) {
    Type type = new TypeToken<List<TargetingProductAudienceSubSpec>>(){}.getType();
    this.mInclusions = TargetingProductAudienceSubSpec.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingProductAudienceSubSpec> getFieldExclusions() {
    return mExclusions;
  }

  public TargetingProductAudienceSpec setFieldExclusions(List<TargetingProductAudienceSubSpec> value) {
    this.mExclusions = value;
    return this;
  }

  public TargetingProductAudienceSpec setFieldExclusions(String value) {
    Type type = new TypeToken<List<TargetingProductAudienceSubSpec>>(){}.getType();
    this.mExclusions = TargetingProductAudienceSubSpec.getGson().fromJson(value, type);
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

  public TargetingProductAudienceSpec copyFrom(TargetingProductAudienceSpec instance) {
    this.mProductSetId = instance.mProductSetId;
    this.mInclusions = instance.mInclusions;
    this.mExclusions = instance.mExclusions;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TargetingProductAudienceSpec> getParser() {
    return new APIRequest.ResponseParser<TargetingProductAudienceSpec>() {
      public APINodeList<TargetingProductAudienceSpec> parseResponse(String response, APIContext context, APIRequest<TargetingProductAudienceSpec> request) {
        return TargetingProductAudienceSpec.parseResponse(response, context, request);
      }
    };
  }
}