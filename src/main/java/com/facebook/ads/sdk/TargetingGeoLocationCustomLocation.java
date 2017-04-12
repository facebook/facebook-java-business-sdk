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
public class TargetingGeoLocationCustomLocation extends APINode {
  @SerializedName("address_string")
  private String mAddressString = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("country_group")
  private String mCountryGroup = null;
  @SerializedName("custom_type")
  private String mCustomType = null;
  @SerializedName("distance_unit")
  private String mDistanceUnit = null;
  @SerializedName("key")
  private String mKey = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("max_population")
  private Long mMaxPopulation = null;
  @SerializedName("min_population")
  private Long mMinPopulation = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("primary_city_id")
  private Long mPrimaryCityId = null;
  @SerializedName("radius")
  private Double mRadius = null;
  @SerializedName("region_id")
  private Long mRegionId = null;
  protected static Gson gson = null;

  public TargetingGeoLocationCustomLocation() {
  }

  public String getId() {
    return null;
  }
  public static TargetingGeoLocationCustomLocation loadJSON(String json, APIContext context) {
    TargetingGeoLocationCustomLocation targetingGeoLocationCustomLocation = getGson().fromJson(json, TargetingGeoLocationCustomLocation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targetingGeoLocationCustomLocation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targetingGeoLocationCustomLocation.context = context;
    targetingGeoLocationCustomLocation.rawValue = json;
    return targetingGeoLocationCustomLocation;
  }

  public static APINodeList<TargetingGeoLocationCustomLocation> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<TargetingGeoLocationCustomLocation> targetingGeoLocationCustomLocations = new APINodeList<TargetingGeoLocationCustomLocation>(request, json);
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
          targetingGeoLocationCustomLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetingGeoLocationCustomLocations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            targetingGeoLocationCustomLocations.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetingGeoLocationCustomLocations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  targetingGeoLocationCustomLocations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              targetingGeoLocationCustomLocations.add(loadJSON(obj.toString(), context));
            }
          }
          return targetingGeoLocationCustomLocations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetingGeoLocationCustomLocations.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetingGeoLocationCustomLocations;
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
              targetingGeoLocationCustomLocations.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return targetingGeoLocationCustomLocations;
          }

          // Sixth, check if it's pure JsonObject
          targetingGeoLocationCustomLocations.clear();
          targetingGeoLocationCustomLocations.add(loadJSON(json, context));
          return targetingGeoLocationCustomLocations;
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

  public TargetingGeoLocationCustomLocation setFieldAddressString(String value) {
    this.mAddressString = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public TargetingGeoLocationCustomLocation setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldCountryGroup() {
    return mCountryGroup;
  }

  public TargetingGeoLocationCustomLocation setFieldCountryGroup(String value) {
    this.mCountryGroup = value;
    return this;
  }

  public String getFieldCustomType() {
    return mCustomType;
  }

  public TargetingGeoLocationCustomLocation setFieldCustomType(String value) {
    this.mCustomType = value;
    return this;
  }

  public String getFieldDistanceUnit() {
    return mDistanceUnit;
  }

  public TargetingGeoLocationCustomLocation setFieldDistanceUnit(String value) {
    this.mDistanceUnit = value;
    return this;
  }

  public String getFieldKey() {
    return mKey;
  }

  public TargetingGeoLocationCustomLocation setFieldKey(String value) {
    this.mKey = value;
    return this;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public TargetingGeoLocationCustomLocation setFieldLatitude(Double value) {
    this.mLatitude = value;
    return this;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public TargetingGeoLocationCustomLocation setFieldLongitude(Double value) {
    this.mLongitude = value;
    return this;
  }

  public Long getFieldMaxPopulation() {
    return mMaxPopulation;
  }

  public TargetingGeoLocationCustomLocation setFieldMaxPopulation(Long value) {
    this.mMaxPopulation = value;
    return this;
  }

  public Long getFieldMinPopulation() {
    return mMinPopulation;
  }

  public TargetingGeoLocationCustomLocation setFieldMinPopulation(Long value) {
    this.mMinPopulation = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public TargetingGeoLocationCustomLocation setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldPrimaryCityId() {
    return mPrimaryCityId;
  }

  public TargetingGeoLocationCustomLocation setFieldPrimaryCityId(Long value) {
    this.mPrimaryCityId = value;
    return this;
  }

  public Double getFieldRadius() {
    return mRadius;
  }

  public TargetingGeoLocationCustomLocation setFieldRadius(Double value) {
    this.mRadius = value;
    return this;
  }

  public Long getFieldRegionId() {
    return mRegionId;
  }

  public TargetingGeoLocationCustomLocation setFieldRegionId(Long value) {
    this.mRegionId = value;
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

  public TargetingGeoLocationCustomLocation copyFrom(TargetingGeoLocationCustomLocation instance) {
    this.mAddressString = instance.mAddressString;
    this.mCountry = instance.mCountry;
    this.mCountryGroup = instance.mCountryGroup;
    this.mCustomType = instance.mCustomType;
    this.mDistanceUnit = instance.mDistanceUnit;
    this.mKey = instance.mKey;
    this.mLatitude = instance.mLatitude;
    this.mLongitude = instance.mLongitude;
    this.mMaxPopulation = instance.mMaxPopulation;
    this.mMinPopulation = instance.mMinPopulation;
    this.mName = instance.mName;
    this.mPrimaryCityId = instance.mPrimaryCityId;
    this.mRadius = instance.mRadius;
    this.mRegionId = instance.mRegionId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TargetingGeoLocationCustomLocation> getParser() {
    return new APIRequest.ResponseParser<TargetingGeoLocationCustomLocation>() {
      public APINodeList<TargetingGeoLocationCustomLocation> parseResponse(String response, APIContext context, APIRequest<TargetingGeoLocationCustomLocation> request) throws MalformedResponseException {
        return TargetingGeoLocationCustomLocation.parseResponse(response, context, request);
      }
    };
  }
}
