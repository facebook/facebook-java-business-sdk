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
public class MessageDeliveryEstimate extends APINode {
  @SerializedName("estimate_cost")
  private Double mEstimateCost = null;
  @SerializedName("estimate_cost_lower_bound")
  private Double mEstimateCostLowerBound = null;
  @SerializedName("estimate_cost_upper_bound")
  private Double mEstimateCostUpperBound = null;
  @SerializedName("estimate_coverage_lower_bound")
  private Long mEstimateCoverageLowerBound = null;
  @SerializedName("estimate_coverage_upper_bound")
  private Long mEstimateCoverageUpperBound = null;
  @SerializedName("estimate_delivery")
  private Long mEstimateDelivery = null;
  @SerializedName("estimate_delivery_lower_bound")
  private Long mEstimateDeliveryLowerBound = null;
  @SerializedName("estimate_delivery_upper_bound")
  private Long mEstimateDeliveryUpperBound = null;
  @SerializedName("estimate_status")
  private String mEstimateStatus = null;
  protected static Gson gson = null;

  public MessageDeliveryEstimate() {
  }

  public String getId() {
    return null;
  }
  public static MessageDeliveryEstimate loadJSON(String json, APIContext context, String header) {
    MessageDeliveryEstimate messageDeliveryEstimate = getGson().fromJson(json, MessageDeliveryEstimate.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(messageDeliveryEstimate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    messageDeliveryEstimate.context = context;
    messageDeliveryEstimate.rawValue = json;
    messageDeliveryEstimate.header = header;
    return messageDeliveryEstimate;
  }

  public static APINodeList<MessageDeliveryEstimate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MessageDeliveryEstimate> messageDeliveryEstimates = new APINodeList<MessageDeliveryEstimate>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          messageDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return messageDeliveryEstimates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messageDeliveryEstimates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messageDeliveryEstimates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messageDeliveryEstimates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messageDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  messageDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              messageDeliveryEstimates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return messageDeliveryEstimates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messageDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return messageDeliveryEstimates;
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
              messageDeliveryEstimates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messageDeliveryEstimates;
          }

          // Sixth, check if it's pure JsonObject
          messageDeliveryEstimates.clear();
          messageDeliveryEstimates.add(loadJSON(json, context, header));
          return messageDeliveryEstimates;
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


  public Double getFieldEstimateCost() {
    return mEstimateCost;
  }

  public MessageDeliveryEstimate setFieldEstimateCost(Double value) {
    this.mEstimateCost = value;
    return this;
  }

  public Double getFieldEstimateCostLowerBound() {
    return mEstimateCostLowerBound;
  }

  public MessageDeliveryEstimate setFieldEstimateCostLowerBound(Double value) {
    this.mEstimateCostLowerBound = value;
    return this;
  }

  public Double getFieldEstimateCostUpperBound() {
    return mEstimateCostUpperBound;
  }

  public MessageDeliveryEstimate setFieldEstimateCostUpperBound(Double value) {
    this.mEstimateCostUpperBound = value;
    return this;
  }

  public Long getFieldEstimateCoverageLowerBound() {
    return mEstimateCoverageLowerBound;
  }

  public MessageDeliveryEstimate setFieldEstimateCoverageLowerBound(Long value) {
    this.mEstimateCoverageLowerBound = value;
    return this;
  }

  public Long getFieldEstimateCoverageUpperBound() {
    return mEstimateCoverageUpperBound;
  }

  public MessageDeliveryEstimate setFieldEstimateCoverageUpperBound(Long value) {
    this.mEstimateCoverageUpperBound = value;
    return this;
  }

  public Long getFieldEstimateDelivery() {
    return mEstimateDelivery;
  }

  public MessageDeliveryEstimate setFieldEstimateDelivery(Long value) {
    this.mEstimateDelivery = value;
    return this;
  }

  public Long getFieldEstimateDeliveryLowerBound() {
    return mEstimateDeliveryLowerBound;
  }

  public MessageDeliveryEstimate setFieldEstimateDeliveryLowerBound(Long value) {
    this.mEstimateDeliveryLowerBound = value;
    return this;
  }

  public Long getFieldEstimateDeliveryUpperBound() {
    return mEstimateDeliveryUpperBound;
  }

  public MessageDeliveryEstimate setFieldEstimateDeliveryUpperBound(Long value) {
    this.mEstimateDeliveryUpperBound = value;
    return this;
  }

  public String getFieldEstimateStatus() {
    return mEstimateStatus;
  }

  public MessageDeliveryEstimate setFieldEstimateStatus(String value) {
    this.mEstimateStatus = value;
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
      @SerializedName("MEANINGFUL_CALL_ATTEMPT")
      VALUE_MEANINGFUL_CALL_ATTEMPT("MEANINGFUL_CALL_ATTEMPT"),
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
      @SerializedName("PROFILE_VISIT")
      VALUE_PROFILE_VISIT("PROFILE_VISIT"),
      @SerializedName("QUALITY_CALL")
      VALUE_QUALITY_CALL("QUALITY_CALL"),
      @SerializedName("QUALITY_LEAD")
      VALUE_QUALITY_LEAD("QUALITY_LEAD"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("REMINDERS_SET")
      VALUE_REMINDERS_SET("REMINDERS_SET"),
      @SerializedName("SUBSCRIBERS")
      VALUE_SUBSCRIBERS("SUBSCRIBERS"),
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

  public static enum EnumPacingType {
      @SerializedName("DAY_PARTING")
      VALUE_DAY_PARTING("DAY_PARTING"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("NO_PACING")
      VALUE_NO_PACING("NO_PACING"),
      @SerializedName("PROBABILISTIC_PACING")
      VALUE_PROBABILISTIC_PACING("PROBABILISTIC_PACING"),
      @SerializedName("PROBABILISTIC_PACING_V2")
      VALUE_PROBABILISTIC_PACING_V2("PROBABILISTIC_PACING_V2"),
      @SerializedName("STANDARD")
      VALUE_STANDARD("STANDARD"),
      ;

      private String value;

      private EnumPacingType(String value) {
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

  public MessageDeliveryEstimate copyFrom(MessageDeliveryEstimate instance) {
    this.mEstimateCost = instance.mEstimateCost;
    this.mEstimateCostLowerBound = instance.mEstimateCostLowerBound;
    this.mEstimateCostUpperBound = instance.mEstimateCostUpperBound;
    this.mEstimateCoverageLowerBound = instance.mEstimateCoverageLowerBound;
    this.mEstimateCoverageUpperBound = instance.mEstimateCoverageUpperBound;
    this.mEstimateDelivery = instance.mEstimateDelivery;
    this.mEstimateDeliveryLowerBound = instance.mEstimateDeliveryLowerBound;
    this.mEstimateDeliveryUpperBound = instance.mEstimateDeliveryUpperBound;
    this.mEstimateStatus = instance.mEstimateStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessageDeliveryEstimate> getParser() {
    return new APIRequest.ResponseParser<MessageDeliveryEstimate>() {
      public APINodeList<MessageDeliveryEstimate> parseResponse(String response, APIContext context, APIRequest<MessageDeliveryEstimate> request, String header) throws MalformedResponseException {
        return MessageDeliveryEstimate.parseResponse(response, context, request, header);
      }
    };
  }
}
