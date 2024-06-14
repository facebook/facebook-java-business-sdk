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
public class AdsTargetingInsights extends APINode {
  @SerializedName("audience_size")
  private Long mAudienceSize = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("conversion_cost")
  private Double mConversionCost = null;
  @SerializedName("conversions")
  private Long mConversions = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("revenue")
  private Double mRevenue = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  public AdsTargetingInsights() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsTargetingInsights loadJSON(String json, APIContext context, String header) {
    AdsTargetingInsights adsTargetingInsights = getGson().fromJson(json, AdsTargetingInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsTargetingInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsTargetingInsights.context = context;
    adsTargetingInsights.rawValue = json;
    adsTargetingInsights.header = header;
    return adsTargetingInsights;
  }

  public static APINodeList<AdsTargetingInsights> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsTargetingInsights> adsTargetingInsightss = new APINodeList<AdsTargetingInsights>(request, json, header);
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
          adsTargetingInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsTargetingInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsTargetingInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsTargetingInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsTargetingInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsTargetingInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsTargetingInsightss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsTargetingInsightss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsTargetingInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsTargetingInsightss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsTargetingInsightss;
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
              adsTargetingInsightss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsTargetingInsightss;
          }

          // Sixth, check if it's pure JsonObject
          adsTargetingInsightss.clear();
          adsTargetingInsightss.add(loadJSON(json, context, header));
          return adsTargetingInsightss;
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


  public Long getFieldAudienceSize() {
    return mAudienceSize;
  }

  public AdsTargetingInsights setFieldAudienceSize(Long value) {
    this.mAudienceSize = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public AdsTargetingInsights setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public Double getFieldConversionCost() {
    return mConversionCost;
  }

  public AdsTargetingInsights setFieldConversionCost(Double value) {
    this.mConversionCost = value;
    return this;
  }

  public Long getFieldConversions() {
    return mConversions;
  }

  public AdsTargetingInsights setFieldConversions(Long value) {
    this.mConversions = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdsTargetingInsights setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdsTargetingInsights setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public AdsTargetingInsights setFieldImpressions(String value) {
    this.mImpressions = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdsTargetingInsights setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Double getFieldRevenue() {
    return mRevenue;
  }

  public AdsTargetingInsights setFieldRevenue(Double value) {
    this.mRevenue = value;
    return this;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public AdsTargetingInsights setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public AdsTargetingInsights setFieldType(String value) {
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

  public AdsTargetingInsights copyFrom(AdsTargetingInsights instance) {
    this.mAudienceSize = instance.mAudienceSize;
    this.mClicks = instance.mClicks;
    this.mConversionCost = instance.mConversionCost;
    this.mConversions = instance.mConversions;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mImpressions = instance.mImpressions;
    this.mName = instance.mName;
    this.mRevenue = instance.mRevenue;
    this.mSpend = instance.mSpend;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsTargetingInsights> getParser() {
    return new APIRequest.ResponseParser<AdsTargetingInsights>() {
      public APINodeList<AdsTargetingInsights> parseResponse(String response, APIContext context, APIRequest<AdsTargetingInsights> request, String header) throws MalformedResponseException {
        return AdsTargetingInsights.parseResponse(response, context, request, header);
      }
    };
  }
}
