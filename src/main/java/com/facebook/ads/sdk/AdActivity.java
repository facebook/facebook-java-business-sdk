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
public class AdActivity extends APINode {
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("actor_name")
  private String mActorName = null;
  @SerializedName("application_id")
  private String mApplicationId = null;
  @SerializedName("application_name")
  private String mApplicationName = null;
  @SerializedName("date_time_in_timezone")
  private String mDateTimeInTimezone = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("event_type")
  private EnumEventType mEventType = null;
  @SerializedName("extra_data")
  private String mExtraData = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("object_name")
  private String mObjectName = null;
  @SerializedName("object_type")
  private String mObjectType = null;
  @SerializedName("translated_event_type")
  private String mTranslatedEventType = null;
  protected static Gson gson = null;

  public AdActivity() {
  }

  public String getId() {
    return null;
  }
  public static AdActivity loadJSON(String json, APIContext context, String header) {
    AdActivity adActivity = getGson().fromJson(json, AdActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adActivity.context = context;
    adActivity.rawValue = json;
    adActivity.header = header;
    return adActivity;
  }

  public static APINodeList<AdActivity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdActivity> adActivitys = new APINodeList<AdActivity>(request, json, header);
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
          adActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adActivitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adActivitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adActivitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adActivitys;
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
              adActivitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adActivitys;
          }

          // Sixth, check if it's pure JsonObject
          adActivitys.clear();
          adActivitys.add(loadJSON(json, context, header));
          return adActivitys;
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


  public String getFieldActorId() {
    return mActorId;
  }

  public AdActivity setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public String getFieldActorName() {
    return mActorName;
  }

  public AdActivity setFieldActorName(String value) {
    this.mActorName = value;
    return this;
  }

  public String getFieldApplicationId() {
    return mApplicationId;
  }

  public AdActivity setFieldApplicationId(String value) {
    this.mApplicationId = value;
    return this;
  }

  public String getFieldApplicationName() {
    return mApplicationName;
  }

  public AdActivity setFieldApplicationName(String value) {
    this.mApplicationName = value;
    return this;
  }

  public String getFieldDateTimeInTimezone() {
    return mDateTimeInTimezone;
  }

  public AdActivity setFieldDateTimeInTimezone(String value) {
    this.mDateTimeInTimezone = value;
    return this;
  }

  public String getFieldEventTime() {
    return mEventTime;
  }

  public AdActivity setFieldEventTime(String value) {
    this.mEventTime = value;
    return this;
  }

  public EnumEventType getFieldEventType() {
    return mEventType;
  }

  public AdActivity setFieldEventType(EnumEventType value) {
    this.mEventType = value;
    return this;
  }

  public String getFieldExtraData() {
    return mExtraData;
  }

  public AdActivity setFieldExtraData(String value) {
    this.mExtraData = value;
    return this;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public AdActivity setFieldObjectId(String value) {
    this.mObjectId = value;
    return this;
  }

  public String getFieldObjectName() {
    return mObjectName;
  }

  public AdActivity setFieldObjectName(String value) {
    this.mObjectName = value;
    return this;
  }

  public String getFieldObjectType() {
    return mObjectType;
  }

  public AdActivity setFieldObjectType(String value) {
    this.mObjectType = value;
    return this;
  }

  public String getFieldTranslatedEventType() {
    return mTranslatedEventType;
  }

  public AdActivity setFieldTranslatedEventType(String value) {
    this.mTranslatedEventType = value;
    return this;
  }



  public static enum EnumEventType {
      @SerializedName("account_spending_limit_reached")
      VALUE_ACCOUNT_SPENDING_LIMIT_REACHED("account_spending_limit_reached"),
      @SerializedName("ad_account_add_user_to_role")
      VALUE_AD_ACCOUNT_ADD_USER_TO_ROLE("ad_account_add_user_to_role"),
      @SerializedName("ad_account_billing_charge")
      VALUE_AD_ACCOUNT_BILLING_CHARGE("ad_account_billing_charge"),
      @SerializedName("ad_account_billing_charge_failed")
      VALUE_AD_ACCOUNT_BILLING_CHARGE_FAILED("ad_account_billing_charge_failed"),
      @SerializedName("ad_account_billing_chargeback")
      VALUE_AD_ACCOUNT_BILLING_CHARGEBACK("ad_account_billing_chargeback"),
      @SerializedName("ad_account_billing_chargeback_reversal")
      VALUE_AD_ACCOUNT_BILLING_CHARGEBACK_REVERSAL("ad_account_billing_chargeback_reversal"),
      @SerializedName("ad_account_billing_decline")
      VALUE_AD_ACCOUNT_BILLING_DECLINE("ad_account_billing_decline"),
      @SerializedName("ad_account_billing_refund")
      VALUE_AD_ACCOUNT_BILLING_REFUND("ad_account_billing_refund"),
      @SerializedName("ad_account_remove_spend_limit")
      VALUE_AD_ACCOUNT_REMOVE_SPEND_LIMIT("ad_account_remove_spend_limit"),
      @SerializedName("ad_account_remove_user_from_role")
      VALUE_AD_ACCOUNT_REMOVE_USER_FROM_ROLE("ad_account_remove_user_from_role"),
      @SerializedName("ad_account_reset_spend_limit")
      VALUE_AD_ACCOUNT_RESET_SPEND_LIMIT("ad_account_reset_spend_limit"),
      @SerializedName("ad_account_set_business_information")
      VALUE_AD_ACCOUNT_SET_BUSINESS_INFORMATION("ad_account_set_business_information"),
      @SerializedName("ad_account_update_spend_limit")
      VALUE_AD_ACCOUNT_UPDATE_SPEND_LIMIT("ad_account_update_spend_limit"),
      @SerializedName("ad_account_update_status")
      VALUE_AD_ACCOUNT_UPDATE_STATUS("ad_account_update_status"),
      @SerializedName("ad_review_approved")
      VALUE_AD_REVIEW_APPROVED("ad_review_approved"),
      @SerializedName("ad_review_declined")
      VALUE_AD_REVIEW_DECLINED("ad_review_declined"),
      @SerializedName("add_funding_source")
      VALUE_ADD_FUNDING_SOURCE("add_funding_source"),
      @SerializedName("add_images")
      VALUE_ADD_IMAGES("add_images"),
      @SerializedName("billing_event")
      VALUE_BILLING_EVENT("billing_event"),
      @SerializedName("campaign_ended")
      VALUE_CAMPAIGN_ENDED("campaign_ended"),
      @SerializedName("campaign_spending_limit_reached")
      VALUE_CAMPAIGN_SPENDING_LIMIT_REACHED("campaign_spending_limit_reached"),
      @SerializedName("conversion_event_updated")
      VALUE_CONVERSION_EVENT_UPDATED("conversion_event_updated"),
      @SerializedName("create_ad")
      VALUE_CREATE_AD("create_ad"),
      @SerializedName("create_ad_set")
      VALUE_CREATE_AD_SET("create_ad_set"),
      @SerializedName("create_audience")
      VALUE_CREATE_AUDIENCE("create_audience"),
      @SerializedName("create_campaign_group")
      VALUE_CREATE_CAMPAIGN_GROUP("create_campaign_group"),
      @SerializedName("create_campaign_legacy")
      VALUE_CREATE_CAMPAIGN_LEGACY("create_campaign_legacy"),
      @SerializedName("delete_audience")
      VALUE_DELETE_AUDIENCE("delete_audience"),
      @SerializedName("delete_images")
      VALUE_DELETE_IMAGES("delete_images"),
      @SerializedName("di_ad_set_learning_stage_exit")
      VALUE_DI_AD_SET_LEARNING_STAGE_EXIT("di_ad_set_learning_stage_exit"),
      @SerializedName("edit_and_update_ad_creative")
      VALUE_EDIT_AND_UPDATE_AD_CREATIVE("edit_and_update_ad_creative"),
      @SerializedName("edit_images")
      VALUE_EDIT_IMAGES("edit_images"),
      @SerializedName("first_delivery_event")
      VALUE_FIRST_DELIVERY_EVENT("first_delivery_event"),
      @SerializedName("funding_event_initiated")
      VALUE_FUNDING_EVENT_INITIATED("funding_event_initiated"),
      @SerializedName("funding_event_successful")
      VALUE_FUNDING_EVENT_SUCCESSFUL("funding_event_successful"),
      @SerializedName("lifetime_budget_spent")
      VALUE_LIFETIME_BUDGET_SPENT("lifetime_budget_spent"),
      @SerializedName("merge_campaigns")
      VALUE_MERGE_CAMPAIGNS("merge_campaigns"),
      @SerializedName("receive_audience")
      VALUE_RECEIVE_AUDIENCE("receive_audience"),
      @SerializedName("remove_funding_source")
      VALUE_REMOVE_FUNDING_SOURCE("remove_funding_source"),
      @SerializedName("remove_shared_audience")
      VALUE_REMOVE_SHARED_AUDIENCE("remove_shared_audience"),
      @SerializedName("share_audience")
      VALUE_SHARE_AUDIENCE("share_audience"),
      @SerializedName("unknown")
      VALUE_UNKNOWN("unknown"),
      @SerializedName("unshare_audience")
      VALUE_UNSHARE_AUDIENCE("unshare_audience"),
      @SerializedName("update_ad_bid_info")
      VALUE_UPDATE_AD_BID_INFO("update_ad_bid_info"),
      @SerializedName("update_ad_bid_type")
      VALUE_UPDATE_AD_BID_TYPE("update_ad_bid_type"),
      @SerializedName("update_ad_creative")
      VALUE_UPDATE_AD_CREATIVE("update_ad_creative"),
      @SerializedName("update_ad_friendly_name")
      VALUE_UPDATE_AD_FRIENDLY_NAME("update_ad_friendly_name"),
      @SerializedName("update_ad_labels")
      VALUE_UPDATE_AD_LABELS("update_ad_labels"),
      @SerializedName("update_ad_run_status")
      VALUE_UPDATE_AD_RUN_STATUS("update_ad_run_status"),
      @SerializedName("update_ad_run_status_to_be_set_after_review")
      VALUE_UPDATE_AD_RUN_STATUS_TO_BE_SET_AFTER_REVIEW("update_ad_run_status_to_be_set_after_review"),
      @SerializedName("update_ad_set_ad_keywords")
      VALUE_UPDATE_AD_SET_AD_KEYWORDS("update_ad_set_ad_keywords"),
      @SerializedName("update_ad_set_bid_adjustments")
      VALUE_UPDATE_AD_SET_BID_ADJUSTMENTS("update_ad_set_bid_adjustments"),
      @SerializedName("update_ad_set_bid_strategy")
      VALUE_UPDATE_AD_SET_BID_STRATEGY("update_ad_set_bid_strategy"),
      @SerializedName("update_ad_set_bidding")
      VALUE_UPDATE_AD_SET_BIDDING("update_ad_set_bidding"),
      @SerializedName("update_ad_set_budget")
      VALUE_UPDATE_AD_SET_BUDGET("update_ad_set_budget"),
      @SerializedName("update_ad_set_duration")
      VALUE_UPDATE_AD_SET_DURATION("update_ad_set_duration"),
      @SerializedName("update_ad_set_learning_stage_status")
      VALUE_UPDATE_AD_SET_LEARNING_STAGE_STATUS("update_ad_set_learning_stage_status"),
      @SerializedName("update_ad_set_min_spend_target")
      VALUE_UPDATE_AD_SET_MIN_SPEND_TARGET("update_ad_set_min_spend_target"),
      @SerializedName("update_ad_set_name")
      VALUE_UPDATE_AD_SET_NAME("update_ad_set_name"),
      @SerializedName("update_ad_set_optimization_goal")
      VALUE_UPDATE_AD_SET_OPTIMIZATION_GOAL("update_ad_set_optimization_goal"),
      @SerializedName("update_ad_set_run_status")
      VALUE_UPDATE_AD_SET_RUN_STATUS("update_ad_set_run_status"),
      @SerializedName("update_ad_set_spend_cap")
      VALUE_UPDATE_AD_SET_SPEND_CAP("update_ad_set_spend_cap"),
      @SerializedName("update_ad_set_target_spec")
      VALUE_UPDATE_AD_SET_TARGET_SPEC("update_ad_set_target_spec"),
      @SerializedName("update_ad_targets_spec")
      VALUE_UPDATE_AD_TARGETS_SPEC("update_ad_targets_spec"),
      @SerializedName("update_adgroup_stop_delivery")
      VALUE_UPDATE_ADGROUP_STOP_DELIVERY("update_adgroup_stop_delivery"),
      @SerializedName("update_audience")
      VALUE_UPDATE_AUDIENCE("update_audience"),
      @SerializedName("update_campaign_ad_scheduling")
      VALUE_UPDATE_CAMPAIGN_AD_SCHEDULING("update_campaign_ad_scheduling"),
      @SerializedName("update_campaign_budget")
      VALUE_UPDATE_CAMPAIGN_BUDGET("update_campaign_budget"),
      @SerializedName("update_campaign_budget_optimization_toggling_status")
      VALUE_UPDATE_CAMPAIGN_BUDGET_OPTIMIZATION_TOGGLING_STATUS("update_campaign_budget_optimization_toggling_status"),
      @SerializedName("update_campaign_budget_scheduling_state")
      VALUE_UPDATE_CAMPAIGN_BUDGET_SCHEDULING_STATE("update_campaign_budget_scheduling_state"),
      @SerializedName("update_campaign_conversion_goal")
      VALUE_UPDATE_CAMPAIGN_CONVERSION_GOAL("update_campaign_conversion_goal"),
      @SerializedName("update_campaign_delivery_type")
      VALUE_UPDATE_CAMPAIGN_DELIVERY_TYPE("update_campaign_delivery_type"),
      @SerializedName("update_campaign_group_ad_scheduling")
      VALUE_UPDATE_CAMPAIGN_GROUP_AD_SCHEDULING("update_campaign_group_ad_scheduling"),
      @SerializedName("update_campaign_group_budget_scheduling_state")
      VALUE_UPDATE_CAMPAIGN_GROUP_BUDGET_SCHEDULING_STATE("update_campaign_group_budget_scheduling_state"),
      @SerializedName("update_campaign_group_delivery_type")
      VALUE_UPDATE_CAMPAIGN_GROUP_DELIVERY_TYPE("update_campaign_group_delivery_type"),
      @SerializedName("update_campaign_group_high_demand_periods")
      VALUE_UPDATE_CAMPAIGN_GROUP_HIGH_DEMAND_PERIODS("update_campaign_group_high_demand_periods"),
      @SerializedName("update_campaign_group_spend_cap")
      VALUE_UPDATE_CAMPAIGN_GROUP_SPEND_CAP("update_campaign_group_spend_cap"),
      @SerializedName("update_campaign_high_demand_periods")
      VALUE_UPDATE_CAMPAIGN_HIGH_DEMAND_PERIODS("update_campaign_high_demand_periods"),
      @SerializedName("update_campaign_name")
      VALUE_UPDATE_CAMPAIGN_NAME("update_campaign_name"),
      @SerializedName("update_campaign_run_status")
      VALUE_UPDATE_CAMPAIGN_RUN_STATUS("update_campaign_run_status"),
      @SerializedName("update_campaign_schedule")
      VALUE_UPDATE_CAMPAIGN_SCHEDULE("update_campaign_schedule"),
      @SerializedName("update_campaign_value_adjustment_rule")
      VALUE_UPDATE_CAMPAIGN_VALUE_ADJUSTMENT_RULE("update_campaign_value_adjustment_rule"),
      @SerializedName("update_delivery_type_cross_level_shift")
      VALUE_UPDATE_DELIVERY_TYPE_CROSS_LEVEL_SHIFT("update_delivery_type_cross_level_shift"),
      ;

      private String value;

      private EnumEventType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCategory {
      @SerializedName("ACCOUNT")
      VALUE_ACCOUNT("ACCOUNT"),
      @SerializedName("AD")
      VALUE_AD("AD"),
      @SerializedName("AD_KEYWORDS")
      VALUE_AD_KEYWORDS("AD_KEYWORDS"),
      @SerializedName("AD_SET")
      VALUE_AD_SET("AD_SET"),
      @SerializedName("AUDIENCE")
      VALUE_AUDIENCE("AUDIENCE"),
      @SerializedName("BID")
      VALUE_BID("BID"),
      @SerializedName("BUDGET")
      VALUE_BUDGET("BUDGET"),
      @SerializedName("CAMPAIGN")
      VALUE_CAMPAIGN("CAMPAIGN"),
      @SerializedName("DATE")
      VALUE_DATE("DATE"),
      @SerializedName("STATUS")
      VALUE_STATUS("STATUS"),
      @SerializedName("TARGETING")
      VALUE_TARGETING("TARGETING"),
      ;

      private String value;

      private EnumCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDataSource {
      @SerializedName("CALYPSO")
      VALUE_CALYPSO("CALYPSO"),
      @SerializedName("TAO")
      VALUE_TAO("TAO"),
      @SerializedName("TAO_AD_ACCOUNT")
      VALUE_TAO_AD_ACCOUNT("TAO_AD_ACCOUNT"),
      @SerializedName("TAO_AD_STATUS")
      VALUE_TAO_AD_STATUS("TAO_AD_STATUS"),
      ;

      private String value;

      private EnumDataSource(String value) {
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

  public AdActivity copyFrom(AdActivity instance) {
    this.mActorId = instance.mActorId;
    this.mActorName = instance.mActorName;
    this.mApplicationId = instance.mApplicationId;
    this.mApplicationName = instance.mApplicationName;
    this.mDateTimeInTimezone = instance.mDateTimeInTimezone;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mExtraData = instance.mExtraData;
    this.mObjectId = instance.mObjectId;
    this.mObjectName = instance.mObjectName;
    this.mObjectType = instance.mObjectType;
    this.mTranslatedEventType = instance.mTranslatedEventType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdActivity> getParser() {
    return new APIRequest.ResponseParser<AdActivity>() {
      public APINodeList<AdActivity> parseResponse(String response, APIContext context, APIRequest<AdActivity> request, String header) throws MalformedResponseException {
        return AdActivity.parseResponse(response, context, request, header);
      }
    };
  }
}
