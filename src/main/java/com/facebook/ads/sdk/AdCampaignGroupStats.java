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
public class AdCampaignGroupStats extends APINode {
  @SerializedName("actions")
  private Map<String, Long> mActions = null;
  @SerializedName("campaign_group_id")
  private String mCampaignGroupId = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("inline_actions")
  private Map<String, Long> mInlineActions = null;
  @SerializedName("social_clicks")
  private Long mSocialClicks = null;
  @SerializedName("social_impressions")
  private Long mSocialImpressions = null;
  @SerializedName("social_spent")
  private Long mSocialSpent = null;
  @SerializedName("social_unique_clicks")
  private Long mSocialUniqueClicks = null;
  @SerializedName("social_unique_impressions")
  private Long mSocialUniqueImpressions = null;
  @SerializedName("spent")
  private Long mSpent = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  protected static Gson gson = null;

  public AdCampaignGroupStats() {
  }

  public String getId() {
    return null;
  }
  public static AdCampaignGroupStats loadJSON(String json, APIContext context, String header) {
    AdCampaignGroupStats adCampaignGroupStats = getGson().fromJson(json, AdCampaignGroupStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignGroupStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignGroupStats.context = context;
    adCampaignGroupStats.rawValue = json;
    adCampaignGroupStats.header = header;
    return adCampaignGroupStats;
  }

  public static APINodeList<AdCampaignGroupStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignGroupStats> adCampaignGroupStatss = new APINodeList<AdCampaignGroupStats>(request, json, header);
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
          adCampaignGroupStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignGroupStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignGroupStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignGroupStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignGroupStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignGroupStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignGroupStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignGroupStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignGroupStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignGroupStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignGroupStatss;
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
              adCampaignGroupStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignGroupStatss;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignGroupStatss.clear();
          adCampaignGroupStatss.add(loadJSON(json, context, header));
          return adCampaignGroupStatss;
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


  public Map<String, Long> getFieldActions() {
    return mActions;
  }

  public AdCampaignGroupStats setFieldActions(Map<String, Long> value) {
    this.mActions = value;
    return this;
  }

  public String getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public AdCampaignGroupStats setFieldCampaignGroupId(String value) {
    this.mCampaignGroupId = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public AdCampaignGroupStats setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public AdCampaignGroupStats setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public AdCampaignGroupStats setFieldImpressions(Long value) {
    this.mImpressions = value;
    return this;
  }

  public Map<String, Long> getFieldInlineActions() {
    return mInlineActions;
  }

  public AdCampaignGroupStats setFieldInlineActions(Map<String, Long> value) {
    this.mInlineActions = value;
    return this;
  }

  public Long getFieldSocialClicks() {
    return mSocialClicks;
  }

  public AdCampaignGroupStats setFieldSocialClicks(Long value) {
    this.mSocialClicks = value;
    return this;
  }

  public Long getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public AdCampaignGroupStats setFieldSocialImpressions(Long value) {
    this.mSocialImpressions = value;
    return this;
  }

  public Long getFieldSocialSpent() {
    return mSocialSpent;
  }

  public AdCampaignGroupStats setFieldSocialSpent(Long value) {
    this.mSocialSpent = value;
    return this;
  }

  public Long getFieldSocialUniqueClicks() {
    return mSocialUniqueClicks;
  }

  public AdCampaignGroupStats setFieldSocialUniqueClicks(Long value) {
    this.mSocialUniqueClicks = value;
    return this;
  }

  public Long getFieldSocialUniqueImpressions() {
    return mSocialUniqueImpressions;
  }

  public AdCampaignGroupStats setFieldSocialUniqueImpressions(Long value) {
    this.mSocialUniqueImpressions = value;
    return this;
  }

  public Long getFieldSpent() {
    return mSpent;
  }

  public AdCampaignGroupStats setFieldSpent(Long value) {
    this.mSpent = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdCampaignGroupStats setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdCampaignGroupStats setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
    return this;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdCampaignGroupStats setFieldUniqueImpressions(Long value) {
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

  public AdCampaignGroupStats copyFrom(AdCampaignGroupStats instance) {
    this.mActions = instance.mActions;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mClicks = instance.mClicks;
    this.mEndTime = instance.mEndTime;
    this.mImpressions = instance.mImpressions;
    this.mInlineActions = instance.mInlineActions;
    this.mSocialClicks = instance.mSocialClicks;
    this.mSocialImpressions = instance.mSocialImpressions;
    this.mSocialSpent = instance.mSocialSpent;
    this.mSocialUniqueClicks = instance.mSocialUniqueClicks;
    this.mSocialUniqueImpressions = instance.mSocialUniqueImpressions;
    this.mSpent = instance.mSpent;
    this.mStartTime = instance.mStartTime;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignGroupStats> getParser() {
    return new APIRequest.ResponseParser<AdCampaignGroupStats>() {
      public APINodeList<AdCampaignGroupStats> parseResponse(String response, APIContext context, APIRequest<AdCampaignGroupStats> request, String header) throws MalformedResponseException {
        return AdCampaignGroupStats.parseResponse(response, context, request, header);
      }
    };
  }
}
