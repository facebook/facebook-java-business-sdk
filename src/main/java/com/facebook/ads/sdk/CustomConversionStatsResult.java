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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class CustomConversionStatsResult extends APINode {
  @SerializedName("aggregation")
  private EnumAggregation mAggregation = null;
  @SerializedName("data")
  private List<Object> mData = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  protected static Gson gson = null;

  public CustomConversionStatsResult() {
  }

  public String getId() {
    return null;
  }
  public static CustomConversionStatsResult loadJSON(String json, APIContext context) {
    CustomConversionStatsResult customConversionStatsResult = getGson().fromJson(json, CustomConversionStatsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customConversionStatsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customConversionStatsResult.context = context;
    customConversionStatsResult.rawValue = json;
    return customConversionStatsResult;
  }

  public static APINodeList<CustomConversionStatsResult> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CustomConversionStatsResult> customConversionStatsResults = new APINodeList<CustomConversionStatsResult>(request, json);
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
          customConversionStatsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customConversionStatsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            customConversionStatsResults.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customConversionStatsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  customConversionStatsResults.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              customConversionStatsResults.add(loadJSON(obj.toString(), context));
            }
          }
          return customConversionStatsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customConversionStatsResults.add(loadJSON(entry.getValue().toString(), context));
          }
          return customConversionStatsResults;
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
              customConversionStatsResults.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customConversionStatsResults;
          }

          // Sixth, check if it's pure JsonObject
          customConversionStatsResults.clear();
          customConversionStatsResults.add(loadJSON(json, context));
          return customConversionStatsResults;
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


  public EnumAggregation getFieldAggregation() {
    return mAggregation;
  }

  public CustomConversionStatsResult setFieldAggregation(EnumAggregation value) {
    this.mAggregation = value;
    return this;
  }

  public List<Object> getFieldData() {
    return mData;
  }

  public CustomConversionStatsResult setFieldData(List<Object> value) {
    this.mData = value;
    return this;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public CustomConversionStatsResult setFieldTimestamp(String value) {
    this.mTimestamp = value;
    return this;
  }



  public static enum EnumAggregation {
      @SerializedName("count")
      VALUE_COUNT("count"),
      @SerializedName("device_type")
      VALUE_DEVICE_TYPE("device_type"),
      @SerializedName("host")
      VALUE_HOST("host"),
      @SerializedName("pixel_fire")
      VALUE_PIXEL_FIRE("pixel_fire"),
      @SerializedName("unmatched_count")
      VALUE_UNMATCHED_COUNT("unmatched_count"),
      @SerializedName("unmatched_usd_amount")
      VALUE_UNMATCHED_USD_AMOUNT("unmatched_usd_amount"),
      @SerializedName("url")
      VALUE_URL("url"),
      @SerializedName("usd_amount")
      VALUE_USD_AMOUNT("usd_amount"),
      NULL(null);

      private String value;

      private EnumAggregation(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
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

  public CustomConversionStatsResult copyFrom(CustomConversionStatsResult instance) {
    this.mAggregation = instance.mAggregation;
    this.mData = instance.mData;
    this.mTimestamp = instance.mTimestamp;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomConversionStatsResult> getParser() {
    return new APIRequest.ResponseParser<CustomConversionStatsResult>() {
      public APINodeList<CustomConversionStatsResult> parseResponse(String response, APIContext context, APIRequest<CustomConversionStatsResult> request) throws MalformedResponseException {
        return CustomConversionStatsResult.parseResponse(response, context, request);
      }
    };
  }
}
