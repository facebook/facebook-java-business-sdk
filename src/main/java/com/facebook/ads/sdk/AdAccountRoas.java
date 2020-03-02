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
public class AdAccountRoas extends APINode {
  @SerializedName("adgroup_id")
  private String mAdgroupId = null;
  @SerializedName("arpu_180d")
  private Double mArpu180d = null;
  @SerializedName("arpu_1d")
  private Double mArpu1d = null;
  @SerializedName("arpu_30d")
  private Double mArpu30d = null;
  @SerializedName("arpu_365d")
  private Double mArpu365d = null;
  @SerializedName("arpu_3d")
  private Double mArpu3d = null;
  @SerializedName("arpu_7d")
  private Double mArpu7d = null;
  @SerializedName("arpu_90d")
  private Double mArpu90d = null;
  @SerializedName("campaign_group_id")
  private String mCampaignGroupId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("installs")
  private Long mInstalls = null;
  @SerializedName("revenue")
  private Double mRevenue = null;
  @SerializedName("revenue_180d")
  private Double mRevenue180d = null;
  @SerializedName("revenue_1d")
  private Double mRevenue1d = null;
  @SerializedName("revenue_30d")
  private Double mRevenue30d = null;
  @SerializedName("revenue_365d")
  private Double mRevenue365d = null;
  @SerializedName("revenue_3d")
  private Double mRevenue3d = null;
  @SerializedName("revenue_7d")
  private Double mRevenue7d = null;
  @SerializedName("revenue_90d")
  private Double mRevenue90d = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("yield_180d")
  private Double mYield180d = null;
  @SerializedName("yield_1d")
  private Double mYield1d = null;
  @SerializedName("yield_30d")
  private Double mYield30d = null;
  @SerializedName("yield_365d")
  private Double mYield365d = null;
  @SerializedName("yield_3d")
  private Double mYield3d = null;
  @SerializedName("yield_7d")
  private Double mYield7d = null;
  @SerializedName("yield_90d")
  private Double mYield90d = null;
  protected static Gson gson = null;

  public AdAccountRoas() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountRoas loadJSON(String json, APIContext context, String header) {
    AdAccountRoas adAccountRoas = getGson().fromJson(json, AdAccountRoas.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountRoas.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountRoas.context = context;
    adAccountRoas.rawValue = json;
    adAccountRoas.header = header;
    return adAccountRoas;
  }

  public static APINodeList<AdAccountRoas> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountRoas> adAccountRoass = new APINodeList<AdAccountRoas>(request, json, header);
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
          adAccountRoass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountRoass;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountRoass.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountRoass.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountRoass.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountRoass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountRoass.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountRoass.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountRoass;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountRoass.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountRoass;
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
              adAccountRoass.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountRoass;
          }

          // Sixth, check if it's pure JsonObject
          adAccountRoass.clear();
          adAccountRoass.add(loadJSON(json, context, header));
          return adAccountRoass;
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


  public String getFieldAdgroupId() {
    return mAdgroupId;
  }

  public AdAccountRoas setFieldAdgroupId(String value) {
    this.mAdgroupId = value;
    return this;
  }

  public Double getFieldArpu180d() {
    return mArpu180d;
  }

  public AdAccountRoas setFieldArpu180d(Double value) {
    this.mArpu180d = value;
    return this;
  }

  public Double getFieldArpu1d() {
    return mArpu1d;
  }

  public AdAccountRoas setFieldArpu1d(Double value) {
    this.mArpu1d = value;
    return this;
  }

  public Double getFieldArpu30d() {
    return mArpu30d;
  }

  public AdAccountRoas setFieldArpu30d(Double value) {
    this.mArpu30d = value;
    return this;
  }

  public Double getFieldArpu365d() {
    return mArpu365d;
  }

  public AdAccountRoas setFieldArpu365d(Double value) {
    this.mArpu365d = value;
    return this;
  }

  public Double getFieldArpu3d() {
    return mArpu3d;
  }

  public AdAccountRoas setFieldArpu3d(Double value) {
    this.mArpu3d = value;
    return this;
  }

  public Double getFieldArpu7d() {
    return mArpu7d;
  }

  public AdAccountRoas setFieldArpu7d(Double value) {
    this.mArpu7d = value;
    return this;
  }

  public Double getFieldArpu90d() {
    return mArpu90d;
  }

  public AdAccountRoas setFieldArpu90d(Double value) {
    this.mArpu90d = value;
    return this;
  }

  public String getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public AdAccountRoas setFieldCampaignGroupId(String value) {
    this.mCampaignGroupId = value;
    return this;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdAccountRoas setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public AdAccountRoas setFieldDateStart(String value) {
    this.mDateStart = value;
    return this;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public AdAccountRoas setFieldDateStop(String value) {
    this.mDateStop = value;
    return this;
  }

  public Long getFieldInstalls() {
    return mInstalls;
  }

  public AdAccountRoas setFieldInstalls(Long value) {
    this.mInstalls = value;
    return this;
  }

  public Double getFieldRevenue() {
    return mRevenue;
  }

  public AdAccountRoas setFieldRevenue(Double value) {
    this.mRevenue = value;
    return this;
  }

  public Double getFieldRevenue180d() {
    return mRevenue180d;
  }

  public AdAccountRoas setFieldRevenue180d(Double value) {
    this.mRevenue180d = value;
    return this;
  }

  public Double getFieldRevenue1d() {
    return mRevenue1d;
  }

  public AdAccountRoas setFieldRevenue1d(Double value) {
    this.mRevenue1d = value;
    return this;
  }

  public Double getFieldRevenue30d() {
    return mRevenue30d;
  }

  public AdAccountRoas setFieldRevenue30d(Double value) {
    this.mRevenue30d = value;
    return this;
  }

  public Double getFieldRevenue365d() {
    return mRevenue365d;
  }

  public AdAccountRoas setFieldRevenue365d(Double value) {
    this.mRevenue365d = value;
    return this;
  }

  public Double getFieldRevenue3d() {
    return mRevenue3d;
  }

  public AdAccountRoas setFieldRevenue3d(Double value) {
    this.mRevenue3d = value;
    return this;
  }

  public Double getFieldRevenue7d() {
    return mRevenue7d;
  }

  public AdAccountRoas setFieldRevenue7d(Double value) {
    this.mRevenue7d = value;
    return this;
  }

  public Double getFieldRevenue90d() {
    return mRevenue90d;
  }

  public AdAccountRoas setFieldRevenue90d(Double value) {
    this.mRevenue90d = value;
    return this;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public AdAccountRoas setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public Double getFieldYield180d() {
    return mYield180d;
  }

  public AdAccountRoas setFieldYield180d(Double value) {
    this.mYield180d = value;
    return this;
  }

  public Double getFieldYield1d() {
    return mYield1d;
  }

  public AdAccountRoas setFieldYield1d(Double value) {
    this.mYield1d = value;
    return this;
  }

  public Double getFieldYield30d() {
    return mYield30d;
  }

  public AdAccountRoas setFieldYield30d(Double value) {
    this.mYield30d = value;
    return this;
  }

  public Double getFieldYield365d() {
    return mYield365d;
  }

  public AdAccountRoas setFieldYield365d(Double value) {
    this.mYield365d = value;
    return this;
  }

  public Double getFieldYield3d() {
    return mYield3d;
  }

  public AdAccountRoas setFieldYield3d(Double value) {
    this.mYield3d = value;
    return this;
  }

  public Double getFieldYield7d() {
    return mYield7d;
  }

  public AdAccountRoas setFieldYield7d(Double value) {
    this.mYield7d = value;
    return this;
  }

  public Double getFieldYield90d() {
    return mYield90d;
  }

  public AdAccountRoas setFieldYield90d(Double value) {
    this.mYield90d = value;
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

  public AdAccountRoas copyFrom(AdAccountRoas instance) {
    this.mAdgroupId = instance.mAdgroupId;
    this.mArpu180d = instance.mArpu180d;
    this.mArpu1d = instance.mArpu1d;
    this.mArpu30d = instance.mArpu30d;
    this.mArpu365d = instance.mArpu365d;
    this.mArpu3d = instance.mArpu3d;
    this.mArpu7d = instance.mArpu7d;
    this.mArpu90d = instance.mArpu90d;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mCampaignId = instance.mCampaignId;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mInstalls = instance.mInstalls;
    this.mRevenue = instance.mRevenue;
    this.mRevenue180d = instance.mRevenue180d;
    this.mRevenue1d = instance.mRevenue1d;
    this.mRevenue30d = instance.mRevenue30d;
    this.mRevenue365d = instance.mRevenue365d;
    this.mRevenue3d = instance.mRevenue3d;
    this.mRevenue7d = instance.mRevenue7d;
    this.mRevenue90d = instance.mRevenue90d;
    this.mSpend = instance.mSpend;
    this.mYield180d = instance.mYield180d;
    this.mYield1d = instance.mYield1d;
    this.mYield30d = instance.mYield30d;
    this.mYield365d = instance.mYield365d;
    this.mYield3d = instance.mYield3d;
    this.mYield7d = instance.mYield7d;
    this.mYield90d = instance.mYield90d;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountRoas> getParser() {
    return new APIRequest.ResponseParser<AdAccountRoas>() {
      public APINodeList<AdAccountRoas> parseResponse(String response, APIContext context, APIRequest<AdAccountRoas> request, String header) throws MalformedResponseException {
        return AdAccountRoas.parseResponse(response, context, request, header);
      }
    };
  }
}
