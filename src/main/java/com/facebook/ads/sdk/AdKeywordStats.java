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
public class AdKeywordStats extends APINode {
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("cost_per_total_action")
  private Double mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_click")
  private Double mCostPerUniqueClick = null;
  @SerializedName("cpc")
  private Double mCpc = null;
  @SerializedName("cpm")
  private Double mCpm = null;
  @SerializedName("cpp")
  private Double mCpp = null;
  @SerializedName("ctr")
  private Double mCtr = null;
  @SerializedName("frequency")
  private Double mFrequency = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("total_actions")
  private Long mTotalActions = null;
  @SerializedName("total_unique_actions")
  private Long mTotalUniqueActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_ctr")
  private Double mUniqueCtr = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  protected static Gson gson = null;

  public AdKeywordStats() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdKeywordStats loadJSON(String json, APIContext context, String header) {
    AdKeywordStats adKeywordStats = getGson().fromJson(json, AdKeywordStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adKeywordStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adKeywordStats.context = context;
    adKeywordStats.rawValue = json;
    adKeywordStats.header = header;
    return adKeywordStats;
  }

  public static APINodeList<AdKeywordStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdKeywordStats> adKeywordStatss = new APINodeList<AdKeywordStats>(request, json, header);
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
          adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adKeywordStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adKeywordStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adKeywordStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adKeywordStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adKeywordStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adKeywordStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adKeywordStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adKeywordStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adKeywordStatss;
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
              adKeywordStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adKeywordStatss;
          }

          // Sixth, check if it's pure JsonObject
          adKeywordStatss.clear();
          adKeywordStatss.add(loadJSON(json, context, header));
          return adKeywordStatss;
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


  public List<AdsActionStats> getFieldActions() {
    return mActions;
  }

  public AdKeywordStats setFieldActions(List<AdsActionStats> value) {
    this.mActions = value;
    return this;
  }

  public AdKeywordStats setFieldActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldClicks() {
    return mClicks;
  }

  public AdKeywordStats setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public Double getFieldCostPerTotalAction() {
    return mCostPerTotalAction;
  }

  public AdKeywordStats setFieldCostPerTotalAction(Double value) {
    this.mCostPerTotalAction = value;
    return this;
  }

  public Double getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public AdKeywordStats setFieldCostPerUniqueClick(Double value) {
    this.mCostPerUniqueClick = value;
    return this;
  }

  public Double getFieldCpc() {
    return mCpc;
  }

  public AdKeywordStats setFieldCpc(Double value) {
    this.mCpc = value;
    return this;
  }

  public Double getFieldCpm() {
    return mCpm;
  }

  public AdKeywordStats setFieldCpm(Double value) {
    this.mCpm = value;
    return this;
  }

  public Double getFieldCpp() {
    return mCpp;
  }

  public AdKeywordStats setFieldCpp(Double value) {
    this.mCpp = value;
    return this;
  }

  public Double getFieldCtr() {
    return mCtr;
  }

  public AdKeywordStats setFieldCtr(Double value) {
    this.mCtr = value;
    return this;
  }

  public Double getFieldFrequency() {
    return mFrequency;
  }

  public AdKeywordStats setFieldFrequency(Double value) {
    this.mFrequency = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdKeywordStats setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public AdKeywordStats setFieldImpressions(Long value) {
    this.mImpressions = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdKeywordStats setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldReach() {
    return mReach;
  }

  public AdKeywordStats setFieldReach(Long value) {
    this.mReach = value;
    return this;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public AdKeywordStats setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public Long getFieldTotalActions() {
    return mTotalActions;
  }

  public AdKeywordStats setFieldTotalActions(Long value) {
    this.mTotalActions = value;
    return this;
  }

  public Long getFieldTotalUniqueActions() {
    return mTotalUniqueActions;
  }

  public AdKeywordStats setFieldTotalUniqueActions(Long value) {
    this.mTotalUniqueActions = value;
    return this;
  }

  public List<AdsActionStats> getFieldUniqueActions() {
    return mUniqueActions;
  }

  public AdKeywordStats setFieldUniqueActions(List<AdsActionStats> value) {
    this.mUniqueActions = value;
    return this;
  }

  public AdKeywordStats setFieldUniqueActions(String value) {
    Type type = new TypeToken<List<AdsActionStats>>(){}.getType();
    this.mUniqueActions = AdsActionStats.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdKeywordStats setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
    return this;
  }

  public Double getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public AdKeywordStats setFieldUniqueCtr(Double value) {
    this.mUniqueCtr = value;
    return this;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdKeywordStats setFieldUniqueImpressions(Long value) {
    this.mUniqueImpressions = value;
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

  public AdKeywordStats copyFrom(AdKeywordStats instance) {
    this.mActions = instance.mActions;
    this.mClicks = instance.mClicks;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCtr = instance.mCtr;
    this.mFrequency = instance.mFrequency;
    this.mId = instance.mId;
    this.mImpressions = instance.mImpressions;
    this.mName = instance.mName;
    this.mReach = instance.mReach;
    this.mSpend = instance.mSpend;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdKeywordStats> getParser() {
    return new APIRequest.ResponseParser<AdKeywordStats>() {
      public APINodeList<AdKeywordStats> parseResponse(String response, APIContext context, APIRequest<AdKeywordStats> request, String header) throws MalformedResponseException {
        return AdKeywordStats.parseResponse(response, context, request, header);
      }
    };
  }
}
