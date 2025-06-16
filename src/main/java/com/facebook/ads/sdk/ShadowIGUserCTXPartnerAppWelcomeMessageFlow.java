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
public class ShadowIGUserCTXPartnerAppWelcomeMessageFlow extends APINode {
  @SerializedName("compatible_platforms")
  private List<String> mCompatiblePlatforms = null;
  @SerializedName("eligible_platforms")
  private List<String> mEligiblePlatforms = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_ig_only_flow")
  private Boolean mIsIgOnlyFlow = null;
  @SerializedName("is_used_in_ad")
  private Boolean mIsUsedInAd = null;
  @SerializedName("last_update_time")
  private String mLastUpdateTime = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("welcome_message_flow")
  private String mWelcomeMessageFlow = null;
  protected static Gson gson = null;

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ShadowIGUserCTXPartnerAppWelcomeMessageFlow loadJSON(String json, APIContext context, String header) {
    ShadowIGUserCTXPartnerAppWelcomeMessageFlow shadowIGUserCTXPartnerAppWelcomeMessageFlow = getGson().fromJson(json, ShadowIGUserCTXPartnerAppWelcomeMessageFlow.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGUserCTXPartnerAppWelcomeMessageFlow.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shadowIGUserCTXPartnerAppWelcomeMessageFlow.context = context;
    shadowIGUserCTXPartnerAppWelcomeMessageFlow.rawValue = json;
    shadowIGUserCTXPartnerAppWelcomeMessageFlow.header = header;
    return shadowIGUserCTXPartnerAppWelcomeMessageFlow;
  }

  public static APINodeList<ShadowIGUserCTXPartnerAppWelcomeMessageFlow> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ShadowIGUserCTXPartnerAppWelcomeMessageFlow> shadowIGUserCTXPartnerAppWelcomeMessageFlows = new APINodeList<ShadowIGUserCTXPartnerAppWelcomeMessageFlow>(request, json, header);
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
          shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shadowIGUserCTXPartnerAppWelcomeMessageFlows;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGUserCTXPartnerAppWelcomeMessageFlows.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGUserCTXPartnerAppWelcomeMessageFlows.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGUserCTXPartnerAppWelcomeMessageFlows.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shadowIGUserCTXPartnerAppWelcomeMessageFlows;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shadowIGUserCTXPartnerAppWelcomeMessageFlows;
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
              shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGUserCTXPartnerAppWelcomeMessageFlows;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGUserCTXPartnerAppWelcomeMessageFlows.clear();
          shadowIGUserCTXPartnerAppWelcomeMessageFlows.add(loadJSON(json, context, header));
          return shadowIGUserCTXPartnerAppWelcomeMessageFlows;
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


  public List<String> getFieldCompatiblePlatforms() {
    return mCompatiblePlatforms;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldCompatiblePlatforms(List<String> value) {
    this.mCompatiblePlatforms = value;
    return this;
  }

  public List<String> getFieldEligiblePlatforms() {
    return mEligiblePlatforms;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldEligiblePlatforms(List<String> value) {
    this.mEligiblePlatforms = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsIgOnlyFlow() {
    return mIsIgOnlyFlow;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldIsIgOnlyFlow(Boolean value) {
    this.mIsIgOnlyFlow = value;
    return this;
  }

  public Boolean getFieldIsUsedInAd() {
    return mIsUsedInAd;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldIsUsedInAd(Boolean value) {
    this.mIsUsedInAd = value;
    return this;
  }

  public String getFieldLastUpdateTime() {
    return mLastUpdateTime;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldLastUpdateTime(String value) {
    this.mLastUpdateTime = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldWelcomeMessageFlow() {
    return mWelcomeMessageFlow;
  }

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow setFieldWelcomeMessageFlow(String value) {
    this.mWelcomeMessageFlow = value;
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

  public ShadowIGUserCTXPartnerAppWelcomeMessageFlow copyFrom(ShadowIGUserCTXPartnerAppWelcomeMessageFlow instance) {
    this.mCompatiblePlatforms = instance.mCompatiblePlatforms;
    this.mEligiblePlatforms = instance.mEligiblePlatforms;
    this.mId = instance.mId;
    this.mIsIgOnlyFlow = instance.mIsIgOnlyFlow;
    this.mIsUsedInAd = instance.mIsUsedInAd;
    this.mLastUpdateTime = instance.mLastUpdateTime;
    this.mName = instance.mName;
    this.mWelcomeMessageFlow = instance.mWelcomeMessageFlow;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGUserCTXPartnerAppWelcomeMessageFlow> getParser() {
    return new APIRequest.ResponseParser<ShadowIGUserCTXPartnerAppWelcomeMessageFlow>() {
      public APINodeList<ShadowIGUserCTXPartnerAppWelcomeMessageFlow> parseResponse(String response, APIContext context, APIRequest<ShadowIGUserCTXPartnerAppWelcomeMessageFlow> request, String header) throws MalformedResponseException {
        return ShadowIGUserCTXPartnerAppWelcomeMessageFlow.parseResponse(response, context, request, header);
      }
    };
  }
}
