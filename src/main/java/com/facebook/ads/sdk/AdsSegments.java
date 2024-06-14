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
public class AdsSegments extends APINode {
  @SerializedName("daily_audience_size")
  private Long mDailyAudienceSize = null;
  @SerializedName("daily_impressions")
  private Long mDailyImpressions = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("path")
  private List<String> mPath = null;
  @SerializedName("popularity")
  private Double mPopularity = null;
  @SerializedName("projected_cpm")
  private Long mProjectedCpm = null;
  @SerializedName("projected_daily_revenue")
  private Long mProjectedDailyRevenue = null;
  protected static Gson gson = null;

  public AdsSegments() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsSegments loadJSON(String json, APIContext context, String header) {
    AdsSegments adsSegments = getGson().fromJson(json, AdsSegments.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsSegments.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsSegments.context = context;
    adsSegments.rawValue = json;
    adsSegments.header = header;
    return adsSegments;
  }

  public static APINodeList<AdsSegments> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsSegments> adsSegmentss = new APINodeList<AdsSegments>(request, json, header);
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
          adsSegmentss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsSegmentss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsSegmentss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsSegmentss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsSegmentss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsSegmentss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsSegmentss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsSegmentss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsSegmentss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsSegmentss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsSegmentss;
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
              adsSegmentss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsSegmentss;
          }

          // Sixth, check if it's pure JsonObject
          adsSegmentss.clear();
          adsSegmentss.add(loadJSON(json, context, header));
          return adsSegmentss;
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


  public Long getFieldDailyAudienceSize() {
    return mDailyAudienceSize;
  }

  public AdsSegments setFieldDailyAudienceSize(Long value) {
    this.mDailyAudienceSize = value;
    return this;
  }

  public Long getFieldDailyImpressions() {
    return mDailyImpressions;
  }

  public AdsSegments setFieldDailyImpressions(Long value) {
    this.mDailyImpressions = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdsSegments setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdsSegments setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdsSegments setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public List<String> getFieldPath() {
    return mPath;
  }

  public AdsSegments setFieldPath(List<String> value) {
    this.mPath = value;
    return this;
  }

  public Double getFieldPopularity() {
    return mPopularity;
  }

  public AdsSegments setFieldPopularity(Double value) {
    this.mPopularity = value;
    return this;
  }

  public Long getFieldProjectedCpm() {
    return mProjectedCpm;
  }

  public AdsSegments setFieldProjectedCpm(Long value) {
    this.mProjectedCpm = value;
    return this;
  }

  public Long getFieldProjectedDailyRevenue() {
    return mProjectedDailyRevenue;
  }

  public AdsSegments setFieldProjectedDailyRevenue(Long value) {
    this.mProjectedDailyRevenue = value;
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

  public AdsSegments copyFrom(AdsSegments instance) {
    this.mDailyAudienceSize = instance.mDailyAudienceSize;
    this.mDailyImpressions = instance.mDailyImpressions;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPath = instance.mPath;
    this.mPopularity = instance.mPopularity;
    this.mProjectedCpm = instance.mProjectedCpm;
    this.mProjectedDailyRevenue = instance.mProjectedDailyRevenue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsSegments> getParser() {
    return new APIRequest.ResponseParser<AdsSegments>() {
      public APINodeList<AdsSegments> parseResponse(String response, APIContext context, APIRequest<AdsSegments> request, String header) throws MalformedResponseException {
        return AdsSegments.parseResponse(response, context, request, header);
      }
    };
  }
}
