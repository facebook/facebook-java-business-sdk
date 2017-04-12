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
  @SerializedName("translated_event_type")
  private String mTranslatedEventType = null;
  protected static Gson gson = null;

  public AdActivity() {
  }

  public String getId() {
    return null;
  }
  public static AdActivity loadJSON(String json, APIContext context) {
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
      };
    }
    adActivity.context = context;
    adActivity.rawValue = json;
    return adActivity;
  }

  public static APINodeList<AdActivity> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdActivity> adActivitys = new APINodeList<AdActivity>(request, json);
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
          adActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adActivitys.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adActivitys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adActivitys.add(loadJSON(obj.toString(), context));
            }
          }
          return adActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adActivitys.add(loadJSON(entry.getValue().toString(), context));
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
              adActivitys.add(loadJSON(value.toString(), context));
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
          adActivitys.add(loadJSON(json, context));
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

  public String getFieldTranslatedEventType() {
    return mTranslatedEventType;
  }

  public AdActivity setFieldTranslatedEventType(String value) {
    this.mTranslatedEventType = value;
    return this;
  }



  public static enum EnumEventType {
      @SerializedName("ad_account_update_spend_limit")
      VALUE_AD_ACCOUNT_UPDATE_SPEND_LIMIT("ad_account_update_spend_limit"),
      @SerializedName("ad_account_reset_spend_limit")
      VALUE_AD_ACCOUNT_RESET_SPEND_LIMIT("ad_account_reset_spend_limit"),
      @SerializedName("ad_account_remove_spend_limit")
      VALUE_AD_ACCOUNT_REMOVE_SPEND_LIMIT("ad_account_remove_spend_limit"),
      @SerializedName("ad_account_set_business_information")
      VALUE_AD_ACCOUNT_SET_BUSINESS_INFORMATION("ad_account_set_business_information"),
      @SerializedName("ad_account_update_status")
      VALUE_AD_ACCOUNT_UPDATE_STATUS("ad_account_update_status"),
      @SerializedName("ad_account_add_user_to_role")
      VALUE_AD_ACCOUNT_ADD_USER_TO_ROLE("ad_account_add_user_to_role"),
      @SerializedName("ad_account_remove_user_from_role")
      VALUE_AD_ACCOUNT_REMOVE_USER_FROM_ROLE("ad_account_remove_user_from_role"),
      @SerializedName("add_images")
      VALUE_ADD_IMAGES("add_images"),
      @SerializedName("edit_images")
      VALUE_EDIT_IMAGES("edit_images"),
      @SerializedName("delete_images")
      VALUE_DELETE_IMAGES("delete_images"),
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
      @SerializedName("billing_event")
      VALUE_BILLING_EVENT("billing_event"),
      @SerializedName("add_funding_source")
      VALUE_ADD_FUNDING_SOURCE("add_funding_source"),
      @SerializedName("remove_funding_source")
      VALUE_REMOVE_FUNDING_SOURCE("remove_funding_source"),
      @SerializedName("create_campaign_group")
      VALUE_CREATE_CAMPAIGN_GROUP("create_campaign_group"),
      @SerializedName("update_campaign_name")
      VALUE_UPDATE_CAMPAIGN_NAME("update_campaign_name"),
      @SerializedName("update_campaign_run_status")
      VALUE_UPDATE_CAMPAIGN_RUN_STATUS("update_campaign_run_status"),
      @SerializedName("update_campaign_group_spend_cap")
      VALUE_UPDATE_CAMPAIGN_GROUP_SPEND_CAP("update_campaign_group_spend_cap"),
      @SerializedName("create_campaign")
      VALUE_CREATE_CAMPAIGN("create_campaign"),
      @SerializedName("create_campaign_legacy")
      VALUE_CREATE_CAMPAIGN_LEGACY("create_campaign_legacy"),
      @SerializedName("update_campaign_budget")
      VALUE_UPDATE_CAMPAIGN_BUDGET("update_campaign_budget"),
      @SerializedName("update_campaign_duration")
      VALUE_UPDATE_CAMPAIGN_DURATION("update_campaign_duration"),
      @SerializedName("create_ad_set")
      VALUE_CREATE_AD_SET("create_ad_set"),
      @SerializedName("update_ad_set_bidding")
      VALUE_UPDATE_AD_SET_BIDDING("update_ad_set_bidding"),
      @SerializedName("update_ad_set_budget")
      VALUE_UPDATE_AD_SET_BUDGET("update_ad_set_budget"),
      @SerializedName("update_ad_set_duration")
      VALUE_UPDATE_AD_SET_DURATION("update_ad_set_duration"),
      @SerializedName("update_ad_set_run_status")
      VALUE_UPDATE_AD_SET_RUN_STATUS("update_ad_set_run_status"),
      @SerializedName("update_ad_set_name")
      VALUE_UPDATE_AD_SET_NAME("update_ad_set_name"),
      @SerializedName("create_ad")
      VALUE_CREATE_AD("create_ad"),
      @SerializedName("update_ad_creative")
      VALUE_UPDATE_AD_CREATIVE("update_ad_creative"),
      @SerializedName("edit_and_update_ad_creative")
      VALUE_EDIT_AND_UPDATE_AD_CREATIVE("edit_and_update_ad_creative"),
      @SerializedName("update_ad_bid_info")
      VALUE_UPDATE_AD_BID_INFO("update_ad_bid_info"),
      @SerializedName("update_ad_bid_type")
      VALUE_UPDATE_AD_BID_TYPE("update_ad_bid_type"),
      @SerializedName("update_ad_run_status")
      VALUE_UPDATE_AD_RUN_STATUS("update_ad_run_status"),
      @SerializedName("update_ad_friendly_name")
      VALUE_UPDATE_AD_FRIENDLY_NAME("update_ad_friendly_name"),
      @SerializedName("update_ad_targets_spec")
      VALUE_UPDATE_AD_TARGETS_SPEC("update_ad_targets_spec"),
      @SerializedName("update_adgroup_stop_delivery")
      VALUE_UPDATE_ADGROUP_STOP_DELIVERY("update_adgroup_stop_delivery"),
      @SerializedName("update_ad_set_target_spec")
      VALUE_UPDATE_AD_SET_TARGET_SPEC("update_ad_set_target_spec"),
      @SerializedName("ad_review_approved")
      VALUE_AD_REVIEW_APPROVED("ad_review_approved"),
      @SerializedName("ad_review_declined")
      VALUE_AD_REVIEW_DECLINED("ad_review_declined"),
      @SerializedName("first_delivery_event")
      VALUE_FIRST_DELIVERY_EVENT("first_delivery_event"),
      @SerializedName("create_audience")
      VALUE_CREATE_AUDIENCE("create_audience"),
      @SerializedName("update_audience")
      VALUE_UPDATE_AUDIENCE("update_audience"),
      @SerializedName("delete_audience")
      VALUE_DELETE_AUDIENCE("delete_audience"),
      @SerializedName("share_audience")
      VALUE_SHARE_AUDIENCE("share_audience"),
      @SerializedName("receive_audience")
      VALUE_RECEIVE_AUDIENCE("receive_audience"),
      @SerializedName("unshare_audience")
      VALUE_UNSHARE_AUDIENCE("unshare_audience"),
      @SerializedName("remove_shared_audience")
      VALUE_REMOVE_SHARED_AUDIENCE("remove_shared_audience"),
      @SerializedName("unknown")
      VALUE_UNKNOWN("unknown"),
      @SerializedName("account_spending_limit_reached")
      VALUE_ACCOUNT_SPENDING_LIMIT_REACHED("account_spending_limit_reached"),
      @SerializedName("campaign_spending_limit_reached")
      VALUE_CAMPAIGN_SPENDING_LIMIT_REACHED("campaign_spending_limit_reached"),
      @SerializedName("lifetime_budget_spent")
      VALUE_LIFETIME_BUDGET_SPENT("lifetime_budget_spent"),
      @SerializedName("funding_event_initiated")
      VALUE_FUNDING_EVENT_INITIATED("funding_event_initiated"),
      @SerializedName("funding_event_successful")
      VALUE_FUNDING_EVENT_SUCCESSFUL("funding_event_successful"),
      @SerializedName("update_ad_labels")
      VALUE_UPDATE_AD_LABELS("update_ad_labels"),
      NULL(null);

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
      NULL(null);

      private String value;

      private EnumCategory(String value) {
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
    this.mTranslatedEventType = instance.mTranslatedEventType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdActivity> getParser() {
    return new APIRequest.ResponseParser<AdActivity>() {
      public APINodeList<AdActivity> parseResponse(String response, APIContext context, APIRequest<AdActivity> request) throws MalformedResponseException {
        return AdActivity.parseResponse(response, context, request);
      }
    };
  }
}
