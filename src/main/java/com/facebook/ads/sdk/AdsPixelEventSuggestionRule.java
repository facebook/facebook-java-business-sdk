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
public class AdsPixelEventSuggestionRule extends APINode {
  @SerializedName("7d_volume")
  private Long m7dVolume = null;
  @SerializedName("dismissed")
  private Boolean mDismissed = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("rank")
  private Long mRank = null;
  @SerializedName("rule")
  private String mRule = null;
  @SerializedName("sample_urls")
  private List<String> mSampleUrls = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  protected static Gson gson = null;

  public AdsPixelEventSuggestionRule() {
  }

  public String getId() {
    return null;
  }
  public static AdsPixelEventSuggestionRule loadJSON(String json, APIContext context, String header) {
    AdsPixelEventSuggestionRule adsPixelEventSuggestionRule = getGson().fromJson(json, AdsPixelEventSuggestionRule.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(adsPixelEventSuggestionRule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsPixelEventSuggestionRule.context = context;
    adsPixelEventSuggestionRule.rawValue = json;
    adsPixelEventSuggestionRule.header = header;
    return adsPixelEventSuggestionRule;
  }

  public static APINodeList<AdsPixelEventSuggestionRule> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsPixelEventSuggestionRule> adsPixelEventSuggestionRules = new APINodeList<AdsPixelEventSuggestionRule>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsPixelEventSuggestionRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsPixelEventSuggestionRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPixelEventSuggestionRules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPixelEventSuggestionRules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPixelEventSuggestionRules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixelEventSuggestionRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsPixelEventSuggestionRules.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPixelEventSuggestionRules.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsPixelEventSuggestionRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixelEventSuggestionRules.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsPixelEventSuggestionRules;
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
              adsPixelEventSuggestionRules.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPixelEventSuggestionRules;
          }

          // Sixth, check if it's pure JsonObject
          adsPixelEventSuggestionRules.clear();
          adsPixelEventSuggestionRules.add(loadJSON(json, context, header));
          return adsPixelEventSuggestionRules;
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


  public Long getField7dVolume() {
    return m7dVolume;
  }

  public AdsPixelEventSuggestionRule setField7dVolume(Long value) {
    this.m7dVolume = value;
    return this;
  }

  public Boolean getFieldDismissed() {
    return mDismissed;
  }

  public AdsPixelEventSuggestionRule setFieldDismissed(Boolean value) {
    this.mDismissed = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public AdsPixelEventSuggestionRule setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public AdsPixelEventSuggestionRule setFieldEventType(String value) {
    this.mEventType = value;
    return this;
  }

  public Long getFieldRank() {
    return mRank;
  }

  public AdsPixelEventSuggestionRule setFieldRank(Long value) {
    this.mRank = value;
    return this;
  }

  public String getFieldRule() {
    return mRule;
  }

  public AdsPixelEventSuggestionRule setFieldRule(String value) {
    this.mRule = value;
    return this;
  }

  public List<String> getFieldSampleUrls() {
    return mSampleUrls;
  }

  public AdsPixelEventSuggestionRule setFieldSampleUrls(List<String> value) {
    this.mSampleUrls = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdsPixelEventSuggestionRule setFieldStartTime(String value) {
    this.mStartTime = value;
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

  public AdsPixelEventSuggestionRule copyFrom(AdsPixelEventSuggestionRule instance) {
    this.m7dVolume = instance.m7dVolume;
    this.mDismissed = instance.mDismissed;
    this.mEndTime = instance.mEndTime;
    this.mEventType = instance.mEventType;
    this.mRank = instance.mRank;
    this.mRule = instance.mRule;
    this.mSampleUrls = instance.mSampleUrls;
    this.mStartTime = instance.mStartTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPixelEventSuggestionRule> getParser() {
    return new APIRequest.ResponseParser<AdsPixelEventSuggestionRule>() {
      public APINodeList<AdsPixelEventSuggestionRule> parseResponse(String response, APIContext context, APIRequest<AdsPixelEventSuggestionRule> request, String header) throws MalformedResponseException {
        return AdsPixelEventSuggestionRule.parseResponse(response, context, request, header);
      }
    };
  }
}
