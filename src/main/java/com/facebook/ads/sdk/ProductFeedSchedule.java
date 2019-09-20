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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
public class ProductFeedSchedule extends APINode {
  @SerializedName("day_of_month")
  private Long mDayOfMonth = null;
  @SerializedName("day_of_week")
  private EnumDayOfWeek mDayOfWeek = null;
  @SerializedName("hour")
  private Long mHour = null;
  @SerializedName("interval")
  private EnumInterval mInterval = null;
  @SerializedName("interval_count")
  private Long mIntervalCount = null;
  @SerializedName("minute")
  private Long mMinute = null;
  @SerializedName("timezone")
  private String mTimezone = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  public ProductFeedSchedule() {
  }

  public String getId() {
    return null;
  }
  public static ProductFeedSchedule loadJSON(String json, APIContext context, String header) {
    ProductFeedSchedule productFeedSchedule = getGson().fromJson(json, ProductFeedSchedule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedSchedule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedSchedule.context = context;
    productFeedSchedule.rawValue = json;
    productFeedSchedule.header = header;
    return productFeedSchedule;
  }

  public static APINodeList<ProductFeedSchedule> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductFeedSchedule> productFeedSchedules = new APINodeList<ProductFeedSchedule>(request, json, header);
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
          productFeedSchedules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productFeedSchedules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productFeedSchedules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productFeedSchedules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productFeedSchedules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedSchedules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productFeedSchedules.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productFeedSchedules.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productFeedSchedules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedSchedules.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productFeedSchedules;
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
              productFeedSchedules.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productFeedSchedules;
          }

          // Sixth, check if it's pure JsonObject
          productFeedSchedules.clear();
          productFeedSchedules.add(loadJSON(json, context, header));
          return productFeedSchedules;
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


  public Long getFieldDayOfMonth() {
    return mDayOfMonth;
  }

  public ProductFeedSchedule setFieldDayOfMonth(Long value) {
    this.mDayOfMonth = value;
    return this;
  }

  public EnumDayOfWeek getFieldDayOfWeek() {
    return mDayOfWeek;
  }

  public ProductFeedSchedule setFieldDayOfWeek(EnumDayOfWeek value) {
    this.mDayOfWeek = value;
    return this;
  }

  public Long getFieldHour() {
    return mHour;
  }

  public ProductFeedSchedule setFieldHour(Long value) {
    this.mHour = value;
    return this;
  }

  public EnumInterval getFieldInterval() {
    return mInterval;
  }

  public ProductFeedSchedule setFieldInterval(EnumInterval value) {
    this.mInterval = value;
    return this;
  }

  public Long getFieldIntervalCount() {
    return mIntervalCount;
  }

  public ProductFeedSchedule setFieldIntervalCount(Long value) {
    this.mIntervalCount = value;
    return this;
  }

  public Long getFieldMinute() {
    return mMinute;
  }

  public ProductFeedSchedule setFieldMinute(Long value) {
    this.mMinute = value;
    return this;
  }

  public String getFieldTimezone() {
    return mTimezone;
  }

  public ProductFeedSchedule setFieldTimezone(String value) {
    this.mTimezone = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public ProductFeedSchedule setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public ProductFeedSchedule setFieldUsername(String value) {
    this.mUsername = value;
    return this;
  }



  public static enum EnumDayOfWeek {
      @SerializedName("FRIDAY")
      VALUE_FRIDAY("FRIDAY"),
      @SerializedName("MONDAY")
      VALUE_MONDAY("MONDAY"),
      @SerializedName("SATURDAY")
      VALUE_SATURDAY("SATURDAY"),
      @SerializedName("SUNDAY")
      VALUE_SUNDAY("SUNDAY"),
      @SerializedName("THURSDAY")
      VALUE_THURSDAY("THURSDAY"),
      @SerializedName("TUESDAY")
      VALUE_TUESDAY("TUESDAY"),
      @SerializedName("WEDNESDAY")
      VALUE_WEDNESDAY("WEDNESDAY"),
      ;

      private String value;

      private EnumDayOfWeek(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumInterval {
      @SerializedName("DAILY")
      VALUE_DAILY("DAILY"),
      @SerializedName("HOURLY")
      VALUE_HOURLY("HOURLY"),
      @SerializedName("MONTHLY")
      VALUE_MONTHLY("MONTHLY"),
      @SerializedName("WEEKLY")
      VALUE_WEEKLY("WEEKLY"),
      ;

      private String value;

      private EnumInterval(String value) {
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

  public ProductFeedSchedule copyFrom(ProductFeedSchedule instance) {
    this.mDayOfMonth = instance.mDayOfMonth;
    this.mDayOfWeek = instance.mDayOfWeek;
    this.mHour = instance.mHour;
    this.mInterval = instance.mInterval;
    this.mIntervalCount = instance.mIntervalCount;
    this.mMinute = instance.mMinute;
    this.mTimezone = instance.mTimezone;
    this.mUrl = instance.mUrl;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedSchedule> getParser() {
    return new APIRequest.ResponseParser<ProductFeedSchedule>() {
      public APINodeList<ProductFeedSchedule> parseResponse(String response, APIContext context, APIRequest<ProductFeedSchedule> request, String header) throws MalformedResponseException {
        return ProductFeedSchedule.parseResponse(response, context, request, header);
      }
    };
  }
}
