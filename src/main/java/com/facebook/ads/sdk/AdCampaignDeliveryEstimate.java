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
public class AdCampaignDeliveryEstimate extends APINode {
  @SerializedName("bid_estimate")
  private Object mBidEstimate = null;
  @SerializedName("daily_outcomes_curve")
  private List<OutcomePredictionPoint> mDailyOutcomesCurve = null;
  @SerializedName("estimate_dau")
  private Object mEstimateDau = null;
  @SerializedName("estimate_mau")
  private Object mEstimateMau = null;
  @SerializedName("estimate_ready")
  private Boolean mEstimateReady = null;
  protected static Gson gson = null;

  public AdCampaignDeliveryEstimate() {
  }

  public String getId() {
    return null;
  }
  public static AdCampaignDeliveryEstimate loadJSON(String json, APIContext context) {
    AdCampaignDeliveryEstimate adCampaignDeliveryEstimate = getGson().fromJson(json, AdCampaignDeliveryEstimate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignDeliveryEstimate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCampaignDeliveryEstimate.context = context;
    adCampaignDeliveryEstimate.rawValue = json;
    return adCampaignDeliveryEstimate;
  }

  public static APINodeList<AdCampaignDeliveryEstimate> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCampaignDeliveryEstimate> adCampaignDeliveryEstimates = new APINodeList<AdCampaignDeliveryEstimate>(request, json);
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
          adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCampaignDeliveryEstimates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCampaignDeliveryEstimates.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignDeliveryEstimates.add(loadJSON(obj.toString(), context));
            }
          }
          return adCampaignDeliveryEstimates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCampaignDeliveryEstimates;
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
              adCampaignDeliveryEstimates.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignDeliveryEstimates;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignDeliveryEstimates.clear();
          adCampaignDeliveryEstimates.add(loadJSON(json, context));
          return adCampaignDeliveryEstimates;
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


  public Object getFieldBidEstimate() {
    return mBidEstimate;
  }

  public AdCampaignDeliveryEstimate setFieldBidEstimate(Object value) {
    this.mBidEstimate = value;
    return this;
  }

  public List<OutcomePredictionPoint> getFieldDailyOutcomesCurve() {
    return mDailyOutcomesCurve;
  }

  public AdCampaignDeliveryEstimate setFieldDailyOutcomesCurve(List<OutcomePredictionPoint> value) {
    this.mDailyOutcomesCurve = value;
    return this;
  }

  public AdCampaignDeliveryEstimate setFieldDailyOutcomesCurve(String value) {
    Type type = new TypeToken<List<OutcomePredictionPoint>>(){}.getType();
    this.mDailyOutcomesCurve = OutcomePredictionPoint.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldEstimateDau() {
    return mEstimateDau;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateDau(Object value) {
    this.mEstimateDau = value;
    return this;
  }

  public Object getFieldEstimateMau() {
    return mEstimateMau;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateMau(Object value) {
    this.mEstimateMau = value;
    return this;
  }

  public Boolean getFieldEstimateReady() {
    return mEstimateReady;
  }

  public AdCampaignDeliveryEstimate setFieldEstimateReady(Boolean value) {
    this.mEstimateReady = value;
    return this;
  }



  public static enum EnumOptimizationGoal {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_ENGAGEMENT")
      VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("SOCIAL_IMPRESSIONS")
      VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("APP_DOWNLOADS")
      VALUE_APP_DOWNLOADS("APP_DOWNLOADS"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      NULL(null);

      private String value;

      private EnumOptimizationGoal(String value) {
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

  public AdCampaignDeliveryEstimate copyFrom(AdCampaignDeliveryEstimate instance) {
    this.mBidEstimate = instance.mBidEstimate;
    this.mDailyOutcomesCurve = instance.mDailyOutcomesCurve;
    this.mEstimateDau = instance.mEstimateDau;
    this.mEstimateMau = instance.mEstimateMau;
    this.mEstimateReady = instance.mEstimateReady;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignDeliveryEstimate> getParser() {
    return new APIRequest.ResponseParser<AdCampaignDeliveryEstimate>() {
      public APINodeList<AdCampaignDeliveryEstimate> parseResponse(String response, APIContext context, APIRequest<AdCampaignDeliveryEstimate> request) throws MalformedResponseException {
        return AdCampaignDeliveryEstimate.parseResponse(response, context, request);
      }
    };
  }
}
