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
public class AnalyticsConfig extends APINode {
  @SerializedName("analytics_access_for_authorized_ad_account")
  private Boolean mAnalyticsAccessForAuthorizedAdAccount = null;
  @SerializedName("breakdowns_config")
  private List<Object> mBreakdownsConfig = null;
  @SerializedName("builtin_fields_config")
  private List<Object> mBuiltinFieldsConfig = null;
  @SerializedName("deprecated_events_config")
  private List<Object> mDeprecatedEventsConfig = null;
  @SerializedName("events_config")
  private List<Object> mEventsConfig = null;
  @SerializedName("ios_purchase_validation_secret")
  private String mIosPurchaseValidationSecret = null;
  @SerializedName("is_any_role_able_to_see_restricted_insights")
  private Boolean mIsAnyRoleAbleToSeeRestrictedInsights = null;
  @SerializedName("is_implicit_purchase_logging_on_android_supported")
  private Boolean mIsImplicitPurchaseLoggingOnAndroidSupported = null;
  @SerializedName("is_implicit_purchase_logging_on_ios_supported")
  private Boolean mIsImplicitPurchaseLoggingOnIosSupported = null;
  @SerializedName("is_track_ios_app_uninstall_supported")
  private Boolean mIsTrackIosAppUninstallSupported = null;
  @SerializedName("journey_backfill_status")
  private String mJourneyBackfillStatus = null;
  @SerializedName("journey_conversion_events")
  private List<String> mJourneyConversionEvents = null;
  @SerializedName("journey_enabled")
  private Boolean mJourneyEnabled = null;
  @SerializedName("journey_impacting_change_time")
  private String mJourneyImpactingChangeTime = null;
  @SerializedName("journey_timeout")
  private String mJourneyTimeout = null;
  @SerializedName("latest_sdk_versions")
  private Map<String, String> mLatestSdkVersions = null;
  @SerializedName("log_android_implicit_purchase_events")
  private Boolean mLogAndroidImplicitPurchaseEvents = null;
  @SerializedName("log_automatic_analytics_events")
  private Boolean mLogAutomaticAnalyticsEvents = null;
  @SerializedName("log_implicit_purchase_events")
  private Boolean mLogImplicitPurchaseEvents = null;
  @SerializedName("prev_journey_conversion_events")
  private List<String> mPrevJourneyConversionEvents = null;
  @SerializedName("query_approximation_accuracy_level")
  private String mQueryApproximationAccuracyLevel = null;
  @SerializedName("query_currency")
  private String mQueryCurrency = null;
  @SerializedName("query_timezone")
  private String mQueryTimezone = null;
  @SerializedName("recent_events_update_time")
  private String mRecentEventsUpdateTime = null;
  @SerializedName("session_timeout_interval")
  private Long mSessionTimeoutInterval = null;
  @SerializedName("track_ios_app_uninstall")
  private Boolean mTrackIosAppUninstall = null;
  protected static Gson gson = null;

  public AnalyticsConfig() {
  }

  public String getId() {
    return null;
  }
  public static AnalyticsConfig loadJSON(String json, APIContext context, String header) {
    AnalyticsConfig analyticsConfig = getGson().fromJson(json, AnalyticsConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(analyticsConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    analyticsConfig.context = context;
    analyticsConfig.rawValue = json;
    analyticsConfig.header = header;
    return analyticsConfig;
  }

  public static APINodeList<AnalyticsConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AnalyticsConfig> analyticsConfigs = new APINodeList<AnalyticsConfig>(request, json, header);
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
          analyticsConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return analyticsConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                analyticsConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            analyticsConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              analyticsConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              analyticsConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  analyticsConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              analyticsConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return analyticsConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              analyticsConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return analyticsConfigs;
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
              analyticsConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return analyticsConfigs;
          }

          // Sixth, check if it's pure JsonObject
          analyticsConfigs.clear();
          analyticsConfigs.add(loadJSON(json, context, header));
          return analyticsConfigs;
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


  public Boolean getFieldAnalyticsAccessForAuthorizedAdAccount() {
    return mAnalyticsAccessForAuthorizedAdAccount;
  }

  public AnalyticsConfig setFieldAnalyticsAccessForAuthorizedAdAccount(Boolean value) {
    this.mAnalyticsAccessForAuthorizedAdAccount = value;
    return this;
  }

  public List<Object> getFieldBreakdownsConfig() {
    return mBreakdownsConfig;
  }

  public AnalyticsConfig setFieldBreakdownsConfig(List<Object> value) {
    this.mBreakdownsConfig = value;
    return this;
  }

  public List<Object> getFieldBuiltinFieldsConfig() {
    return mBuiltinFieldsConfig;
  }

  public AnalyticsConfig setFieldBuiltinFieldsConfig(List<Object> value) {
    this.mBuiltinFieldsConfig = value;
    return this;
  }

  public List<Object> getFieldDeprecatedEventsConfig() {
    return mDeprecatedEventsConfig;
  }

  public AnalyticsConfig setFieldDeprecatedEventsConfig(List<Object> value) {
    this.mDeprecatedEventsConfig = value;
    return this;
  }

  public List<Object> getFieldEventsConfig() {
    return mEventsConfig;
  }

  public AnalyticsConfig setFieldEventsConfig(List<Object> value) {
    this.mEventsConfig = value;
    return this;
  }

  public String getFieldIosPurchaseValidationSecret() {
    return mIosPurchaseValidationSecret;
  }

  public AnalyticsConfig setFieldIosPurchaseValidationSecret(String value) {
    this.mIosPurchaseValidationSecret = value;
    return this;
  }

  public Boolean getFieldIsAnyRoleAbleToSeeRestrictedInsights() {
    return mIsAnyRoleAbleToSeeRestrictedInsights;
  }

  public AnalyticsConfig setFieldIsAnyRoleAbleToSeeRestrictedInsights(Boolean value) {
    this.mIsAnyRoleAbleToSeeRestrictedInsights = value;
    return this;
  }

  public Boolean getFieldIsImplicitPurchaseLoggingOnAndroidSupported() {
    return mIsImplicitPurchaseLoggingOnAndroidSupported;
  }

  public AnalyticsConfig setFieldIsImplicitPurchaseLoggingOnAndroidSupported(Boolean value) {
    this.mIsImplicitPurchaseLoggingOnAndroidSupported = value;
    return this;
  }

  public Boolean getFieldIsImplicitPurchaseLoggingOnIosSupported() {
    return mIsImplicitPurchaseLoggingOnIosSupported;
  }

  public AnalyticsConfig setFieldIsImplicitPurchaseLoggingOnIosSupported(Boolean value) {
    this.mIsImplicitPurchaseLoggingOnIosSupported = value;
    return this;
  }

  public Boolean getFieldIsTrackIosAppUninstallSupported() {
    return mIsTrackIosAppUninstallSupported;
  }

  public AnalyticsConfig setFieldIsTrackIosAppUninstallSupported(Boolean value) {
    this.mIsTrackIosAppUninstallSupported = value;
    return this;
  }

  public String getFieldJourneyBackfillStatus() {
    return mJourneyBackfillStatus;
  }

  public AnalyticsConfig setFieldJourneyBackfillStatus(String value) {
    this.mJourneyBackfillStatus = value;
    return this;
  }

  public List<String> getFieldJourneyConversionEvents() {
    return mJourneyConversionEvents;
  }

  public AnalyticsConfig setFieldJourneyConversionEvents(List<String> value) {
    this.mJourneyConversionEvents = value;
    return this;
  }

  public Boolean getFieldJourneyEnabled() {
    return mJourneyEnabled;
  }

  public AnalyticsConfig setFieldJourneyEnabled(Boolean value) {
    this.mJourneyEnabled = value;
    return this;
  }

  public String getFieldJourneyImpactingChangeTime() {
    return mJourneyImpactingChangeTime;
  }

  public AnalyticsConfig setFieldJourneyImpactingChangeTime(String value) {
    this.mJourneyImpactingChangeTime = value;
    return this;
  }

  public String getFieldJourneyTimeout() {
    return mJourneyTimeout;
  }

  public AnalyticsConfig setFieldJourneyTimeout(String value) {
    this.mJourneyTimeout = value;
    return this;
  }

  public Map<String, String> getFieldLatestSdkVersions() {
    return mLatestSdkVersions;
  }

  public AnalyticsConfig setFieldLatestSdkVersions(Map<String, String> value) {
    this.mLatestSdkVersions = value;
    return this;
  }

  public Boolean getFieldLogAndroidImplicitPurchaseEvents() {
    return mLogAndroidImplicitPurchaseEvents;
  }

  public AnalyticsConfig setFieldLogAndroidImplicitPurchaseEvents(Boolean value) {
    this.mLogAndroidImplicitPurchaseEvents = value;
    return this;
  }

  public Boolean getFieldLogAutomaticAnalyticsEvents() {
    return mLogAutomaticAnalyticsEvents;
  }

  public AnalyticsConfig setFieldLogAutomaticAnalyticsEvents(Boolean value) {
    this.mLogAutomaticAnalyticsEvents = value;
    return this;
  }

  public Boolean getFieldLogImplicitPurchaseEvents() {
    return mLogImplicitPurchaseEvents;
  }

  public AnalyticsConfig setFieldLogImplicitPurchaseEvents(Boolean value) {
    this.mLogImplicitPurchaseEvents = value;
    return this;
  }

  public List<String> getFieldPrevJourneyConversionEvents() {
    return mPrevJourneyConversionEvents;
  }

  public AnalyticsConfig setFieldPrevJourneyConversionEvents(List<String> value) {
    this.mPrevJourneyConversionEvents = value;
    return this;
  }

  public String getFieldQueryApproximationAccuracyLevel() {
    return mQueryApproximationAccuracyLevel;
  }

  public AnalyticsConfig setFieldQueryApproximationAccuracyLevel(String value) {
    this.mQueryApproximationAccuracyLevel = value;
    return this;
  }

  public String getFieldQueryCurrency() {
    return mQueryCurrency;
  }

  public AnalyticsConfig setFieldQueryCurrency(String value) {
    this.mQueryCurrency = value;
    return this;
  }

  public String getFieldQueryTimezone() {
    return mQueryTimezone;
  }

  public AnalyticsConfig setFieldQueryTimezone(String value) {
    this.mQueryTimezone = value;
    return this;
  }

  public String getFieldRecentEventsUpdateTime() {
    return mRecentEventsUpdateTime;
  }

  public AnalyticsConfig setFieldRecentEventsUpdateTime(String value) {
    this.mRecentEventsUpdateTime = value;
    return this;
  }

  public Long getFieldSessionTimeoutInterval() {
    return mSessionTimeoutInterval;
  }

  public AnalyticsConfig setFieldSessionTimeoutInterval(Long value) {
    this.mSessionTimeoutInterval = value;
    return this;
  }

  public Boolean getFieldTrackIosAppUninstall() {
    return mTrackIosAppUninstall;
  }

  public AnalyticsConfig setFieldTrackIosAppUninstall(Boolean value) {
    this.mTrackIosAppUninstall = value;
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

  public AnalyticsConfig copyFrom(AnalyticsConfig instance) {
    this.mAnalyticsAccessForAuthorizedAdAccount = instance.mAnalyticsAccessForAuthorizedAdAccount;
    this.mBreakdownsConfig = instance.mBreakdownsConfig;
    this.mBuiltinFieldsConfig = instance.mBuiltinFieldsConfig;
    this.mDeprecatedEventsConfig = instance.mDeprecatedEventsConfig;
    this.mEventsConfig = instance.mEventsConfig;
    this.mIosPurchaseValidationSecret = instance.mIosPurchaseValidationSecret;
    this.mIsAnyRoleAbleToSeeRestrictedInsights = instance.mIsAnyRoleAbleToSeeRestrictedInsights;
    this.mIsImplicitPurchaseLoggingOnAndroidSupported = instance.mIsImplicitPurchaseLoggingOnAndroidSupported;
    this.mIsImplicitPurchaseLoggingOnIosSupported = instance.mIsImplicitPurchaseLoggingOnIosSupported;
    this.mIsTrackIosAppUninstallSupported = instance.mIsTrackIosAppUninstallSupported;
    this.mJourneyBackfillStatus = instance.mJourneyBackfillStatus;
    this.mJourneyConversionEvents = instance.mJourneyConversionEvents;
    this.mJourneyEnabled = instance.mJourneyEnabled;
    this.mJourneyImpactingChangeTime = instance.mJourneyImpactingChangeTime;
    this.mJourneyTimeout = instance.mJourneyTimeout;
    this.mLatestSdkVersions = instance.mLatestSdkVersions;
    this.mLogAndroidImplicitPurchaseEvents = instance.mLogAndroidImplicitPurchaseEvents;
    this.mLogAutomaticAnalyticsEvents = instance.mLogAutomaticAnalyticsEvents;
    this.mLogImplicitPurchaseEvents = instance.mLogImplicitPurchaseEvents;
    this.mPrevJourneyConversionEvents = instance.mPrevJourneyConversionEvents;
    this.mQueryApproximationAccuracyLevel = instance.mQueryApproximationAccuracyLevel;
    this.mQueryCurrency = instance.mQueryCurrency;
    this.mQueryTimezone = instance.mQueryTimezone;
    this.mRecentEventsUpdateTime = instance.mRecentEventsUpdateTime;
    this.mSessionTimeoutInterval = instance.mSessionTimeoutInterval;
    this.mTrackIosAppUninstall = instance.mTrackIosAppUninstall;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AnalyticsConfig> getParser() {
    return new APIRequest.ResponseParser<AnalyticsConfig>() {
      public APINodeList<AnalyticsConfig> parseResponse(String response, APIContext context, APIRequest<AnalyticsConfig> request, String header) throws MalformedResponseException {
        return AnalyticsConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
