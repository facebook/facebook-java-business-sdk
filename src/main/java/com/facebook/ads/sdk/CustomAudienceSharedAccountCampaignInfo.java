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
public class CustomAudienceSharedAccountCampaignInfo extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("adset_excluding_count")
  private Long mAdsetExcludingCount = null;
  @SerializedName("adset_including_count")
  private Long mAdsetIncludingCount = null;
  @SerializedName("campaign_delivery_status")
  private String mCampaignDeliveryStatus = null;
  @SerializedName("campaign_objective")
  private String mCampaignObjective = null;
  @SerializedName("campaign_pages")
  private List<Object> mCampaignPages = null;
  @SerializedName("campaign_schedule")
  private String mCampaignSchedule = null;
  protected static Gson gson = null;

  public CustomAudienceSharedAccountCampaignInfo() {
  }

  public String getId() {
    return null;
  }
  public static CustomAudienceSharedAccountCampaignInfo loadJSON(String json, APIContext context, String header) {
    CustomAudienceSharedAccountCampaignInfo customAudienceSharedAccountCampaignInfo = getGson().fromJson(json, CustomAudienceSharedAccountCampaignInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudienceSharedAccountCampaignInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    customAudienceSharedAccountCampaignInfo.context = context;
    customAudienceSharedAccountCampaignInfo.rawValue = json;
    customAudienceSharedAccountCampaignInfo.header = header;
    return customAudienceSharedAccountCampaignInfo;
  }

  public static APINodeList<CustomAudienceSharedAccountCampaignInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CustomAudienceSharedAccountCampaignInfo> customAudienceSharedAccountCampaignInfos = new APINodeList<CustomAudienceSharedAccountCampaignInfo>(request, json, header);
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
          customAudienceSharedAccountCampaignInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return customAudienceSharedAccountCampaignInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customAudienceSharedAccountCampaignInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customAudienceSharedAccountCampaignInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customAudienceSharedAccountCampaignInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  customAudienceSharedAccountCampaignInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return customAudienceSharedAccountCampaignInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return customAudienceSharedAccountCampaignInfos;
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
              customAudienceSharedAccountCampaignInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudienceSharedAccountCampaignInfos;
          }

          // Sixth, check if it's pure JsonObject
          customAudienceSharedAccountCampaignInfos.clear();
          customAudienceSharedAccountCampaignInfos.add(loadJSON(json, context, header));
          return customAudienceSharedAccountCampaignInfos;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldAccountName(String value) {
    this.mAccountName = value;
    return this;
  }

  public Long getFieldAdsetExcludingCount() {
    return mAdsetExcludingCount;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldAdsetExcludingCount(Long value) {
    this.mAdsetExcludingCount = value;
    return this;
  }

  public Long getFieldAdsetIncludingCount() {
    return mAdsetIncludingCount;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldAdsetIncludingCount(Long value) {
    this.mAdsetIncludingCount = value;
    return this;
  }

  public String getFieldCampaignDeliveryStatus() {
    return mCampaignDeliveryStatus;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldCampaignDeliveryStatus(String value) {
    this.mCampaignDeliveryStatus = value;
    return this;
  }

  public String getFieldCampaignObjective() {
    return mCampaignObjective;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldCampaignObjective(String value) {
    this.mCampaignObjective = value;
    return this;
  }

  public List<Object> getFieldCampaignPages() {
    return mCampaignPages;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldCampaignPages(List<Object> value) {
    this.mCampaignPages = value;
    return this;
  }

  public String getFieldCampaignSchedule() {
    return mCampaignSchedule;
  }

  public CustomAudienceSharedAccountCampaignInfo setFieldCampaignSchedule(String value) {
    this.mCampaignSchedule = value;
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

  public CustomAudienceSharedAccountCampaignInfo copyFrom(CustomAudienceSharedAccountCampaignInfo instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mAdsetExcludingCount = instance.mAdsetExcludingCount;
    this.mAdsetIncludingCount = instance.mAdsetIncludingCount;
    this.mCampaignDeliveryStatus = instance.mCampaignDeliveryStatus;
    this.mCampaignObjective = instance.mCampaignObjective;
    this.mCampaignPages = instance.mCampaignPages;
    this.mCampaignSchedule = instance.mCampaignSchedule;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudienceSharedAccountCampaignInfo> getParser() {
    return new APIRequest.ResponseParser<CustomAudienceSharedAccountCampaignInfo>() {
      public APINodeList<CustomAudienceSharedAccountCampaignInfo> parseResponse(String response, APIContext context, APIRequest<CustomAudienceSharedAccountCampaignInfo> request, String header) throws MalformedResponseException {
        return CustomAudienceSharedAccountCampaignInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
