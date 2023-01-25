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
public class AdAccountDeliveryEstimate extends APINode {
  @SerializedName("daily_outcomes_curve")
  private List<OutcomePredictionPoint> mDailyOutcomesCurve = null;
  @SerializedName("estimate_dau")
  private Long mEstimateDau = null;
  @SerializedName("estimate_mau_lower_bound")
  private Long mEstimateMauLowerBound = null;
  @SerializedName("estimate_mau_upper_bound")
  private Long mEstimateMauUpperBound = null;
  @SerializedName("estimate_ready")
  private Boolean mEstimateReady = null;
  @SerializedName("targeting_optimization_types")
  private Map<String, Long> mTargetingOptimizationTypes = null;
  protected static Gson gson = null;

  public AdAccountDeliveryEstimate() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountDeliveryEstimate loadJSON(String json, APIContext context, String header) {
    AdAccountDeliveryEstimate adAccountDeliveryEstimate = getGson().fromJson(json, AdAccountDeliveryEstimate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountDeliveryEstimate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountDeliveryEstimate.context = context;
    adAccountDeliveryEstimate.rawValue = json;
    adAccountDeliveryEstimate.header = header;
    return adAccountDeliveryEstimate;
  }

  public static APINodeList<AdAccountDeliveryEstimate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountDeliveryEstimate> adAccountDeliveryEstimates = new APINodeList<AdAccountDeliveryEstimate>(request, json, header);
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
          adAccountDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountDeliveryEstimates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountDeliveryEstimates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountDeliveryEstimates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountDeliveryEstimates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountDeliveryEstimates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountDeliveryEstimates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountDeliveryEstimates;
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
              adAccountDeliveryEstimates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountDeliveryEstimates;
          }

          // Sixth, check if it's pure JsonObject
          adAccountDeliveryEstimates.clear();
          adAccountDeliveryEstimates.add(loadJSON(json, context, header));
          return adAccountDeliveryEstimates;
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


  public List<OutcomePredictionPoint> getFieldDailyOutcomesCurve() {
    return mDailyOutcomesCurve;
  }

  public AdAccountDeliveryEstimate setFieldDailyOutcomesCurve(List<OutcomePredictionPoint> value) {
    this.mDailyOutcomesCurve = value;
    return this;
  }

  public AdAccountDeliveryEstimate setFieldDailyOutcomesCurve(String value) {
    Type type = new TypeToken<List<OutcomePredictionPoint>>(){}.getType();
    this.mDailyOutcomesCurve = OutcomePredictionPoint.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldEstimateDau() {
    return mEstimateDau;
  }

  public AdAccountDeliveryEstimate setFieldEstimateDau(Long value) {
    this.mEstimateDau = value;
    return this;
  }

  public Long getFieldEstimateMauLowerBound() {
    return mEstimateMauLowerBound;
  }

  public AdAccountDeliveryEstimate setFieldEstimateMauLowerBound(Long value) {
    this.mEstimateMauLowerBound = value;
    return this;
  }

  public Long getFieldEstimateMauUpperBound() {
    return mEstimateMauUpperBound;
  }

  public AdAccountDeliveryEstimate setFieldEstimateMauUpperBound(Long value) {
    this.mEstimateMauUpperBound = value;
    return this;
  }

  public Boolean getFieldEstimateReady() {
    return mEstimateReady;
  }

  public AdAccountDeliveryEstimate setFieldEstimateReady(Boolean value) {
    this.mEstimateReady = value;
    return this;
  }

  public Map<String, Long> getFieldTargetingOptimizationTypes() {
    return mTargetingOptimizationTypes;
  }

  public AdAccountDeliveryEstimate setFieldTargetingOptimizationTypes(Map<String, Long> value) {
    this.mTargetingOptimizationTypes = value;
    return this;
  }



  public static enum EnumOptimizationGoal {
      @SerializedName("AD_RECALL_LIFT")
      VALUE_AD_RECALL_LIFT("AD_RECALL_LIFT"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("APP_INSTALLS_AND_OFFSITE_CONVERSIONS")
      VALUE_APP_INSTALLS_AND_OFFSITE_CONVERSIONS("APP_INSTALLS_AND_OFFSITE_CONVERSIONS"),
      @SerializedName("CONVERSATIONS")
      VALUE_CONVERSATIONS("CONVERSATIONS"),
      @SerializedName("DERIVED_EVENTS")
      VALUE_DERIVED_EVENTS("DERIVED_EVENTS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("IN_APP_VALUE")
      VALUE_IN_APP_VALUE("IN_APP_VALUE"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("MESSAGING_APPOINTMENT_CONVERSION")
      VALUE_MESSAGING_APPOINTMENT_CONVERSION("MESSAGING_APPOINTMENT_CONVERSION"),
      @SerializedName("MESSAGING_PURCHASE_CONVERSION")
      VALUE_MESSAGING_PURCHASE_CONVERSION("MESSAGING_PURCHASE_CONVERSION"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("QUALITY_CALL")
      VALUE_QUALITY_CALL("QUALITY_CALL"),
      @SerializedName("QUALITY_LEAD")
      VALUE_QUALITY_LEAD("QUALITY_LEAD"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("VISIT_INSTAGRAM_PROFILE")
      VALUE_VISIT_INSTAGRAM_PROFILE("VISIT_INSTAGRAM_PROFILE"),
      ;

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

  public AdAccountDeliveryEstimate copyFrom(AdAccountDeliveryEstimate instance) {
    this.mDailyOutcomesCurve = instance.mDailyOutcomesCurve;
    this.mEstimateDau = instance.mEstimateDau;
    this.mEstimateMauLowerBound = instance.mEstimateMauLowerBound;
    this.mEstimateMauUpperBound = instance.mEstimateMauUpperBound;
    this.mEstimateReady = instance.mEstimateReady;
    this.mTargetingOptimizationTypes = instance.mTargetingOptimizationTypes;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountDeliveryEstimate> getParser() {
    return new APIRequest.ResponseParser<AdAccountDeliveryEstimate>() {
      public APINodeList<AdAccountDeliveryEstimate> parseResponse(String response, APIContext context, APIRequest<AdAccountDeliveryEstimate> request, String header) throws MalformedResponseException {
        return AdAccountDeliveryEstimate.parseResponse(response, context, request, header);
      }
    };
  }
}
