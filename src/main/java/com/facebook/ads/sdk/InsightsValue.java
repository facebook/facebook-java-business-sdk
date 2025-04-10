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
public class InsightsValue extends APINode {
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("earning_source")
  private String mEarningSource = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("engagement_source")
  private String mEngagementSource = null;
  @SerializedName("message_type")
  private String mMessageType = null;
  @SerializedName("messaging_channel")
  private String mMessagingChannel = null;
  @SerializedName("monetization_tool")
  private String mMonetizationTool = null;
  @SerializedName("recurring_notifications_entry_point")
  private String mRecurringNotificationsEntryPoint = null;
  @SerializedName("recurring_notifications_frequency")
  private String mRecurringNotificationsFrequency = null;
  @SerializedName("recurring_notifications_topic")
  private String mRecurringNotificationsTopic = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("value")
  private Object mValue = null;
  protected static Gson gson = null;

  public InsightsValue() {
  }

  public String getId() {
    return null;
  }
  public static InsightsValue loadJSON(String json, APIContext context, String header) {
    InsightsValue insightsValue = getGson().fromJson(json, InsightsValue.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(insightsValue.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    insightsValue.context = context;
    insightsValue.rawValue = json;
    insightsValue.header = header;
    return insightsValue;
  }

  public static APINodeList<InsightsValue> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InsightsValue> insightsValues = new APINodeList<InsightsValue>(request, json, header);
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
          insightsValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return insightsValues;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                insightsValues.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            insightsValues.setPaging(previous, next);
            if (context.hasAppSecret()) {
              insightsValues.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              insightsValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  insightsValues.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              insightsValues.add(loadJSON(obj.toString(), context, header));
            }
          }
          return insightsValues;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              insightsValues.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return insightsValues;
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
              insightsValues.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return insightsValues;
          }

          // Sixth, check if it's pure JsonObject
          insightsValues.clear();
          insightsValues.add(loadJSON(json, context, header));
          return insightsValues;
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


  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public InsightsValue setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public String getFieldEarningSource() {
    return mEarningSource;
  }

  public InsightsValue setFieldEarningSource(String value) {
    this.mEarningSource = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public InsightsValue setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public String getFieldEngagementSource() {
    return mEngagementSource;
  }

  public InsightsValue setFieldEngagementSource(String value) {
    this.mEngagementSource = value;
    return this;
  }

  public String getFieldMessageType() {
    return mMessageType;
  }

  public InsightsValue setFieldMessageType(String value) {
    this.mMessageType = value;
    return this;
  }

  public String getFieldMessagingChannel() {
    return mMessagingChannel;
  }

  public InsightsValue setFieldMessagingChannel(String value) {
    this.mMessagingChannel = value;
    return this;
  }

  public String getFieldMonetizationTool() {
    return mMonetizationTool;
  }

  public InsightsValue setFieldMonetizationTool(String value) {
    this.mMonetizationTool = value;
    return this;
  }

  public String getFieldRecurringNotificationsEntryPoint() {
    return mRecurringNotificationsEntryPoint;
  }

  public InsightsValue setFieldRecurringNotificationsEntryPoint(String value) {
    this.mRecurringNotificationsEntryPoint = value;
    return this;
  }

  public String getFieldRecurringNotificationsFrequency() {
    return mRecurringNotificationsFrequency;
  }

  public InsightsValue setFieldRecurringNotificationsFrequency(String value) {
    this.mRecurringNotificationsFrequency = value;
    return this;
  }

  public String getFieldRecurringNotificationsTopic() {
    return mRecurringNotificationsTopic;
  }

  public InsightsValue setFieldRecurringNotificationsTopic(String value) {
    this.mRecurringNotificationsTopic = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public InsightsValue setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public Object getFieldValue() {
    return mValue;
  }

  public InsightsValue setFieldValue(Object value) {
    this.mValue = value;
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

  public InsightsValue copyFrom(InsightsValue instance) {
    this.mCampaignId = instance.mCampaignId;
    this.mEarningSource = instance.mEarningSource;
    this.mEndTime = instance.mEndTime;
    this.mEngagementSource = instance.mEngagementSource;
    this.mMessageType = instance.mMessageType;
    this.mMessagingChannel = instance.mMessagingChannel;
    this.mMonetizationTool = instance.mMonetizationTool;
    this.mRecurringNotificationsEntryPoint = instance.mRecurringNotificationsEntryPoint;
    this.mRecurringNotificationsFrequency = instance.mRecurringNotificationsFrequency;
    this.mRecurringNotificationsTopic = instance.mRecurringNotificationsTopic;
    this.mStartTime = instance.mStartTime;
    this.mValue = instance.mValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InsightsValue> getParser() {
    return new APIRequest.ResponseParser<InsightsValue>() {
      public APINodeList<InsightsValue> parseResponse(String response, APIContext context, APIRequest<InsightsValue> request, String header) throws MalformedResponseException {
        return InsightsValue.parseResponse(response, context, request, header);
      }
    };
  }
}
