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
public class ProductEventStat extends APINode {
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("device_type")
  private EnumDeviceType mDeviceType = null;
  @SerializedName("event")
  private EnumEvent mEvent = null;
  @SerializedName("event_source")
  private ExternalEventSource mEventSource = null;
  @SerializedName("total_content_ids_matched_other_catalogs")
  private Long mTotalContentIdsMatchedOtherCatalogs = null;
  @SerializedName("total_matched_content_ids")
  private Long mTotalMatchedContentIds = null;
  @SerializedName("total_unmatched_content_ids")
  private Long mTotalUnmatchedContentIds = null;
  @SerializedName("unique_content_ids_matched_other_catalogs")
  private Long mUniqueContentIdsMatchedOtherCatalogs = null;
  @SerializedName("unique_matched_content_ids")
  private Long mUniqueMatchedContentIds = null;
  @SerializedName("unique_unmatched_content_ids")
  private Long mUniqueUnmatchedContentIds = null;
  protected static Gson gson = null;

  public ProductEventStat() {
  }

  public String getId() {
    return null;
  }
  public static ProductEventStat loadJSON(String json, APIContext context, String header) {
    ProductEventStat productEventStat = getGson().fromJson(json, ProductEventStat.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productEventStat.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productEventStat.context = context;
    productEventStat.rawValue = json;
    productEventStat.header = header;
    return productEventStat;
  }

  public static APINodeList<ProductEventStat> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductEventStat> productEventStats = new APINodeList<ProductEventStat>(request, json, header);
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
          productEventStats.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productEventStats;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productEventStats.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productEventStats.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productEventStats.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productEventStats.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productEventStats.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productEventStats.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productEventStats;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productEventStats.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productEventStats;
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
              productEventStats.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productEventStats;
          }

          // Sixth, check if it's pure JsonObject
          productEventStats.clear();
          productEventStats.add(loadJSON(json, context, header));
          return productEventStats;
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


  public String getFieldDateStart() {
    return mDateStart;
  }

  public ProductEventStat setFieldDateStart(String value) {
    this.mDateStart = value;
    return this;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public ProductEventStat setFieldDateStop(String value) {
    this.mDateStop = value;
    return this;
  }

  public EnumDeviceType getFieldDeviceType() {
    return mDeviceType;
  }

  public ProductEventStat setFieldDeviceType(EnumDeviceType value) {
    this.mDeviceType = value;
    return this;
  }

  public EnumEvent getFieldEvent() {
    return mEvent;
  }

  public ProductEventStat setFieldEvent(EnumEvent value) {
    this.mEvent = value;
    return this;
  }

  public ExternalEventSource getFieldEventSource() {
    return mEventSource;
  }

  public ProductEventStat setFieldEventSource(ExternalEventSource value) {
    this.mEventSource = value;
    return this;
  }

  public ProductEventStat setFieldEventSource(String value) {
    Type type = new TypeToken<ExternalEventSource>(){}.getType();
    this.mEventSource = ExternalEventSource.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldTotalContentIdsMatchedOtherCatalogs() {
    return mTotalContentIdsMatchedOtherCatalogs;
  }

  public ProductEventStat setFieldTotalContentIdsMatchedOtherCatalogs(Long value) {
    this.mTotalContentIdsMatchedOtherCatalogs = value;
    return this;
  }

  public Long getFieldTotalMatchedContentIds() {
    return mTotalMatchedContentIds;
  }

  public ProductEventStat setFieldTotalMatchedContentIds(Long value) {
    this.mTotalMatchedContentIds = value;
    return this;
  }

  public Long getFieldTotalUnmatchedContentIds() {
    return mTotalUnmatchedContentIds;
  }

  public ProductEventStat setFieldTotalUnmatchedContentIds(Long value) {
    this.mTotalUnmatchedContentIds = value;
    return this;
  }

  public Long getFieldUniqueContentIdsMatchedOtherCatalogs() {
    return mUniqueContentIdsMatchedOtherCatalogs;
  }

  public ProductEventStat setFieldUniqueContentIdsMatchedOtherCatalogs(Long value) {
    this.mUniqueContentIdsMatchedOtherCatalogs = value;
    return this;
  }

  public Long getFieldUniqueMatchedContentIds() {
    return mUniqueMatchedContentIds;
  }

  public ProductEventStat setFieldUniqueMatchedContentIds(Long value) {
    this.mUniqueMatchedContentIds = value;
    return this;
  }

  public Long getFieldUniqueUnmatchedContentIds() {
    return mUniqueUnmatchedContentIds;
  }

  public ProductEventStat setFieldUniqueUnmatchedContentIds(Long value) {
    this.mUniqueUnmatchedContentIds = value;
    return this;
  }



  public static enum EnumDeviceType {
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("mobile_android_phone")
      VALUE_MOBILE_ANDROID_PHONE("mobile_android_phone"),
      @SerializedName("mobile_android_tablet")
      VALUE_MOBILE_ANDROID_TABLET("mobile_android_tablet"),
      @SerializedName("mobile_ipad")
      VALUE_MOBILE_IPAD("mobile_ipad"),
      @SerializedName("mobile_iphone")
      VALUE_MOBILE_IPHONE("mobile_iphone"),
      @SerializedName("mobile_ipod")
      VALUE_MOBILE_IPOD("mobile_ipod"),
      @SerializedName("mobile_phone")
      VALUE_MOBILE_PHONE("mobile_phone"),
      @SerializedName("mobile_tablet")
      VALUE_MOBILE_TABLET("mobile_tablet"),
      @SerializedName("mobile_windows_phone")
      VALUE_MOBILE_WINDOWS_PHONE("mobile_windows_phone"),
      @SerializedName("unknown")
      VALUE_UNKNOWN("unknown"),
      ;

      private String value;

      private EnumDeviceType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEvent {
      @SerializedName("AddToCart")
      VALUE_ADDTOCART("AddToCart"),
      @SerializedName("AddToWishlist")
      VALUE_ADDTOWISHLIST("AddToWishlist"),
      @SerializedName("InitiateCheckout")
      VALUE_INITIATECHECKOUT("InitiateCheckout"),
      @SerializedName("Lead")
      VALUE_LEAD("Lead"),
      @SerializedName("Purchase")
      VALUE_PURCHASE("Purchase"),
      @SerializedName("Search")
      VALUE_SEARCH("Search"),
      @SerializedName("Subscribe")
      VALUE_SUBSCRIBE("Subscribe"),
      @SerializedName("ViewContent")
      VALUE_VIEWCONTENT("ViewContent"),
      ;

      private String value;

      private EnumEvent(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("DEVICE_TYPE")
      VALUE_DEVICE_TYPE("DEVICE_TYPE"),
      ;

      private String value;

      private EnumBreakdowns(String value) {
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

  public ProductEventStat copyFrom(ProductEventStat instance) {
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDeviceType = instance.mDeviceType;
    this.mEvent = instance.mEvent;
    this.mEventSource = instance.mEventSource;
    this.mTotalContentIdsMatchedOtherCatalogs = instance.mTotalContentIdsMatchedOtherCatalogs;
    this.mTotalMatchedContentIds = instance.mTotalMatchedContentIds;
    this.mTotalUnmatchedContentIds = instance.mTotalUnmatchedContentIds;
    this.mUniqueContentIdsMatchedOtherCatalogs = instance.mUniqueContentIdsMatchedOtherCatalogs;
    this.mUniqueMatchedContentIds = instance.mUniqueMatchedContentIds;
    this.mUniqueUnmatchedContentIds = instance.mUniqueUnmatchedContentIds;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductEventStat> getParser() {
    return new APIRequest.ResponseParser<ProductEventStat>() {
      public APINodeList<ProductEventStat> parseResponse(String response, APIContext context, APIRequest<ProductEventStat> request, String header) throws MalformedResponseException {
        return ProductEventStat.parseResponse(response, context, request, header);
      }
    };
  }
}
