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
public class AdCreativePlaceData extends APINode {
  @SerializedName("address_string")
  private String mAddressString = null;
  @SerializedName("label")
  private String mLabel = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  public AdCreativePlaceData() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativePlaceData loadJSON(String json, APIContext context) {
    AdCreativePlaceData adCreativePlaceData = getGson().fromJson(json, AdCreativePlaceData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativePlaceData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativePlaceData.context = context;
    adCreativePlaceData.rawValue = json;
    return adCreativePlaceData;
  }

  public static APINodeList<AdCreativePlaceData> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativePlaceData> adCreativePlaceDatas = new APINodeList<AdCreativePlaceData>(request, json);
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
          adCreativePlaceDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativePlaceDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCreativePlaceDatas.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativePlaceDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativePlaceDatas.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativePlaceDatas.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativePlaceDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativePlaceDatas.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativePlaceDatas;
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
              adCreativePlaceDatas.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativePlaceDatas;
          }

          // Sixth, check if it's pure JsonObject
          adCreativePlaceDatas.clear();
          adCreativePlaceDatas.add(loadJSON(json, context));
          return adCreativePlaceDatas;
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


  public String getFieldAddressString() {
    return mAddressString;
  }

  public AdCreativePlaceData setFieldAddressString(String value) {
    this.mAddressString = value;
    return this;
  }

  public String getFieldLabel() {
    return mLabel;
  }

  public AdCreativePlaceData setFieldLabel(String value) {
    this.mLabel = value;
    return this;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public AdCreativePlaceData setFieldLatitude(Double value) {
    this.mLatitude = value;
    return this;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public AdCreativePlaceData setFieldLongitude(Double value) {
    this.mLongitude = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public AdCreativePlaceData setFieldType(String value) {
    this.mType = value;
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

  public AdCreativePlaceData copyFrom(AdCreativePlaceData instance) {
    this.mAddressString = instance.mAddressString;
    this.mLabel = instance.mLabel;
    this.mLatitude = instance.mLatitude;
    this.mLongitude = instance.mLongitude;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativePlaceData> getParser() {
    return new APIRequest.ResponseParser<AdCreativePlaceData>() {
      public APINodeList<AdCreativePlaceData> parseResponse(String response, APIContext context, APIRequest<AdCreativePlaceData> request) throws MalformedResponseException {
        return AdCreativePlaceData.parseResponse(response, context, request);
      }
    };
  }
}
