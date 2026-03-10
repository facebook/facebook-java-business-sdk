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
public class AdCampaignGroupGet extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("advantage_state_info")
  private Object mAdvantageStateInfo = null;
  @SerializedName("bid_strategy")
  private String mBidStrategy = null;
  @SerializedName("budget_remaining")
  private String mBudgetRemaining = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("configured_status")
  private String mConfiguredStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("daily_budget")
  private String mDailyBudget = null;
  @SerializedName("effective_status")
  private String mEffectiveStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("lifetime_budget")
  private String mLifetimeBudget = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("promoted_object")
  private Object mPromotedObject = null;
  @SerializedName("special_ad_categories")
  private List<EnumSpecialAdCategories> mSpecialAdCategories = null;
  @SerializedName("spend_cap")
  private String mSpendCap = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("stop_time")
  private String mStopTime = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  public AdCampaignGroupGet() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdCampaignGroupGet loadJSON(String json, APIContext context, String header) {
    AdCampaignGroupGet adCampaignGroupGet = getGson().fromJson(json, AdCampaignGroupGet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignGroupGet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignGroupGet.context = context;
    adCampaignGroupGet.rawValue = json;
    adCampaignGroupGet.header = header;
    return adCampaignGroupGet;
  }

  public static APINodeList<AdCampaignGroupGet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignGroupGet> adCampaignGroupGets = new APINodeList<AdCampaignGroupGet>(request, json, header);
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
          adCampaignGroupGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignGroupGets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignGroupGets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignGroupGets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignGroupGets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignGroupGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignGroupGets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignGroupGets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignGroupGets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignGroupGets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignGroupGets;
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
              adCampaignGroupGets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignGroupGets;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignGroupGets.clear();
          adCampaignGroupGets.add(loadJSON(json, context, header));
          return adCampaignGroupGets;
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

  public AdCampaignGroupGet setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public Object getFieldAdvantageStateInfo() {
    return mAdvantageStateInfo;
  }

  public AdCampaignGroupGet setFieldAdvantageStateInfo(Object value) {
    this.mAdvantageStateInfo = value;
    return this;
  }

  public String getFieldBidStrategy() {
    return mBidStrategy;
  }

  public AdCampaignGroupGet setFieldBidStrategy(String value) {
    this.mBidStrategy = value;
    return this;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
  }

  public AdCampaignGroupGet setFieldBudgetRemaining(String value) {
    this.mBudgetRemaining = value;
    return this;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public AdCampaignGroupGet setFieldBuyingType(String value) {
    this.mBuyingType = value;
    return this;
  }

  public String getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public AdCampaignGroupGet setFieldConfiguredStatus(String value) {
    this.mConfiguredStatus = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdCampaignGroupGet setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldDailyBudget() {
    return mDailyBudget;
  }

  public AdCampaignGroupGet setFieldDailyBudget(String value) {
    this.mDailyBudget = value;
    return this;
  }

  public String getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public AdCampaignGroupGet setFieldEffectiveStatus(String value) {
    this.mEffectiveStatus = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdCampaignGroupGet setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
  }

  public AdCampaignGroupGet setFieldLifetimeBudget(String value) {
    this.mLifetimeBudget = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdCampaignGroupGet setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public AdCampaignGroupGet setFieldObjective(String value) {
    this.mObjective = value;
    return this;
  }

  public Object getFieldPromotedObject() {
    return mPromotedObject;
  }

  public AdCampaignGroupGet setFieldPromotedObject(Object value) {
    this.mPromotedObject = value;
    return this;
  }

  public List<EnumSpecialAdCategories> getFieldSpecialAdCategories() {
    return mSpecialAdCategories;
  }

  public AdCampaignGroupGet setFieldSpecialAdCategories(List<EnumSpecialAdCategories> value) {
    this.mSpecialAdCategories = value;
    return this;
  }

  public String getFieldSpendCap() {
    return mSpendCap;
  }

  public AdCampaignGroupGet setFieldSpendCap(String value) {
    this.mSpendCap = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdCampaignGroupGet setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public AdCampaignGroupGet setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldStopTime() {
    return mStopTime;
  }

  public AdCampaignGroupGet setFieldStopTime(String value) {
    this.mStopTime = value;
    return this;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public AdCampaignGroupGet setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }



  public static enum EnumSpecialAdCategories {
      @SerializedName("CREDIT")
      VALUE_CREDIT("CREDIT"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ELECTIONS_POLITICS")
      VALUE_ELECTIONS_POLITICS("ELECTIONS_POLITICS"),
      @SerializedName("EMPLOYMENT")
      VALUE_EMPLOYMENT("EMPLOYMENT"),
      @SerializedName("FINANCIAL_PRODUCTS_SERVICES")
      VALUE_FINANCIAL_PRODUCTS_SERVICES("FINANCIAL_PRODUCTS_SERVICES"),
      @SerializedName("HOUSING")
      VALUE_HOUSING("HOUSING"),
      @SerializedName("ISSUES_ELECTIONS_POLITICS")
      VALUE_ISSUES_ELECTIONS_POLITICS("ISSUES_ELECTIONS_POLITICS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("ONLINE_GAMBLING_AND_GAMING")
      VALUE_ONLINE_GAMBLING_AND_GAMING("ONLINE_GAMBLING_AND_GAMING"),
      @SerializedName("SOCIAL_ISSUES")
      VALUE_SOCIAL_ISSUES("SOCIAL_ISSUES"),
      ;

      private String value;

      private EnumSpecialAdCategories(String value) {
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

  public AdCampaignGroupGet copyFrom(AdCampaignGroupGet instance) {
    this.mAccountId = instance.mAccountId;
    this.mAdvantageStateInfo = instance.mAdvantageStateInfo;
    this.mBidStrategy = instance.mBidStrategy;
    this.mBudgetRemaining = instance.mBudgetRemaining;
    this.mBuyingType = instance.mBuyingType;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDailyBudget = instance.mDailyBudget;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mId = instance.mId;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mName = instance.mName;
    this.mObjective = instance.mObjective;
    this.mPromotedObject = instance.mPromotedObject;
    this.mSpecialAdCategories = instance.mSpecialAdCategories;
    this.mSpendCap = instance.mSpendCap;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mStopTime = instance.mStopTime;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignGroupGet> getParser() {
    return new APIRequest.ResponseParser<AdCampaignGroupGet>() {
      public APINodeList<AdCampaignGroupGet> parseResponse(String response, APIContext context, APIRequest<AdCampaignGroupGet> request, String header) throws MalformedResponseException {
        return AdCampaignGroupGet.parseResponse(response, context, request, header);
      }
    };
  }
}
