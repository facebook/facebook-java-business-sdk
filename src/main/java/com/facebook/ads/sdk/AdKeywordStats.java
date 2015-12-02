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


public class AdKeywordStats extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("total_actions")
  private Long mTotalActions = null;
  @SerializedName("total_unique_actions")
  private Long mTotalUniqueActions = null;
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("ctr")
  private Double mCtr = null;
  @SerializedName("unique_ctr")
  private Double mUniqueCtr = null;
  @SerializedName("cpm")
  private Double mCpm = null;
  @SerializedName("cpp")
  private Double mCpp = null;
  @SerializedName("cpc")
  private Double mCpc = null;
  @SerializedName("cost_per_total_action")
  private Double mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_click")
  private Double mCostPerUniqueClick = null;
  @SerializedName("frequency")
  private Double mFrequency = null;
  protected static Gson gson = null;

  public AdKeywordStats() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdKeywordStats loadJSON(String json, APIContext context) {
    AdKeywordStats adKeywordStats = getGson().fromJson(json, AdKeywordStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adKeywordStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adKeywordStats.mContext = context;
    adKeywordStats.rawValue = json;
    return adKeywordStats;
  }

  public static APINodeList<AdKeywordStats> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdKeywordStats> adKeywordStatss = new APINodeList<AdKeywordStats>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adKeywordStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adKeywordStatss.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adKeywordStatss.add(loadJSON(obj.toString(), context));
          }
          return adKeywordStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adKeywordStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adKeywordStatss;
        } else {
          // Fifth, check if it's pure JsonObject
          adKeywordStatss.add(loadJSON(json, context));
          return adKeywordStatss;
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


  public String getFieldId() {
    return mId;
  }

  public AdKeywordStats setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdKeywordStats setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public AdKeywordStats setFieldImpressions(Long value) {
    this.mImpressions = value;
    return this;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdKeywordStats setFieldUniqueImpressions(Long value) {
    this.mUniqueImpressions = value;
    return this;
  }

  public Long getFieldReach() {
    return mReach;
  }

  public AdKeywordStats setFieldReach(Long value) {
    this.mReach = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public AdKeywordStats setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdKeywordStats setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
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
  public Double getFieldSpend() {
    return mSpend;
  }

  public AdKeywordStats setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public Double getFieldCtr() {
    return mCtr;
  }

  public AdKeywordStats setFieldCtr(Double value) {
    this.mCtr = value;
    return this;
  }

  public Double getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public AdKeywordStats setFieldUniqueCtr(Double value) {
    this.mUniqueCtr = value;
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

  public Double getFieldCpc() {
    return mCpc;
  }

  public AdKeywordStats setFieldCpc(Double value) {
    this.mCpc = value;
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

  public Double getFieldFrequency() {
    return mFrequency;
  }

  public AdKeywordStats setFieldFrequency(Double value) {
    this.mFrequency = value;
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
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mImpressions = instance.mImpressions;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.mReach = instance.mReach;
    this.mClicks = instance.mClicks;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mActions = instance.mActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mSpend = instance.mSpend;
    this.mCtr = instance.mCtr;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCpc = instance.mCpc;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mFrequency = instance.mFrequency;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}