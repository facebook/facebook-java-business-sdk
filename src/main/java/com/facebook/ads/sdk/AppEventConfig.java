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
public class AppEventConfig extends APINode {
  @SerializedName("breakdowns_config")
  private List<Object> mBreakdownsConfig = null;
  @SerializedName("builtin_fields_config")
  private List<Object> mBuiltinFieldsConfig = null;
  @SerializedName("deprecated_events_config")
  private List<Object> mDeprecatedEventsConfig = null;
  @SerializedName("events_config")
  private List<Object> mEventsConfig = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ios_purchase_validation_secret")
  private String mIosPurchaseValidationSecret = null;
  @SerializedName("is_any_role_able_to_see_restricted_insights")
  private Boolean mIsAnyRoleAbleToSeeRestrictedInsights = null;
  @SerializedName("is_implicit_purchase_logging_on_android_supported")
  private Boolean mIsImplicitPurchaseLoggingOnAndroidSupported = null;
  @SerializedName("is_implicit_purchase_logging_on_ios_supported")
  private Boolean mIsImplicitPurchaseLoggingOnIosSupported = null;
  @SerializedName("is_track_android_app_uninstall_supported")
  private Boolean mIsTrackAndroidAppUninstallSupported = null;
  @SerializedName("is_track_ios_app_uninstall_supported")
  private Boolean mIsTrackIosAppUninstallSupported = null;
  @SerializedName("journey_backfill_status")
  private String mJourneyBackfillStatus = null;
  @SerializedName("journey_conversion_events")
  private List<String> mJourneyConversionEvents = null;
  @SerializedName("journey_enabled")
  private Boolean mJourneyEnabled = null;
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
  @SerializedName("track_android_app_uninstall")
  private Boolean mTrackAndroidAppUninstall = null;
  @SerializedName("track_ios_app_uninstall")
  private Boolean mTrackIosAppUninstall = null;
  protected static Gson gson = null;

  AppEventConfig() {
  }

  public AppEventConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AppEventConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AppEventConfig fetch() throws APIException{
    AppEventConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AppEventConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AppEventConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AppEventConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AppEventConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AppEventConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AppEventConfig>)(
      new APIRequest<AppEventConfig>(context, "", "/", "GET", AppEventConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AppEventConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AppEventConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AppEventConfig loadJSON(String json, APIContext context, String header) {
    AppEventConfig appEventConfig = getGson().fromJson(json, AppEventConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(appEventConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    appEventConfig.context = context;
    appEventConfig.rawValue = json;
    appEventConfig.header = header;
    return appEventConfig;
  }

  public static APINodeList<AppEventConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AppEventConfig> appEventConfigs = new APINodeList<AppEventConfig>(request, json, header);
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
          appEventConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return appEventConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                appEventConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            appEventConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              appEventConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              appEventConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  appEventConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              appEventConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return appEventConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              appEventConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return appEventConfigs;
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
              appEventConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return appEventConfigs;
          }

          // Sixth, check if it's pure JsonObject
          appEventConfigs.clear();
          appEventConfigs.add(loadJSON(json, context, header));
          return appEventConfigs;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<Object> getFieldBreakdownsConfig() {
    return mBreakdownsConfig;
  }

  public List<Object> getFieldBuiltinFieldsConfig() {
    return mBuiltinFieldsConfig;
  }

  public List<Object> getFieldDeprecatedEventsConfig() {
    return mDeprecatedEventsConfig;
  }

  public List<Object> getFieldEventsConfig() {
    return mEventsConfig;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIosPurchaseValidationSecret() {
    return mIosPurchaseValidationSecret;
  }

  public Boolean getFieldIsAnyRoleAbleToSeeRestrictedInsights() {
    return mIsAnyRoleAbleToSeeRestrictedInsights;
  }

  public Boolean getFieldIsImplicitPurchaseLoggingOnAndroidSupported() {
    return mIsImplicitPurchaseLoggingOnAndroidSupported;
  }

  public Boolean getFieldIsImplicitPurchaseLoggingOnIosSupported() {
    return mIsImplicitPurchaseLoggingOnIosSupported;
  }

  public Boolean getFieldIsTrackAndroidAppUninstallSupported() {
    return mIsTrackAndroidAppUninstallSupported;
  }

  public Boolean getFieldIsTrackIosAppUninstallSupported() {
    return mIsTrackIosAppUninstallSupported;
  }

  public String getFieldJourneyBackfillStatus() {
    return mJourneyBackfillStatus;
  }

  public List<String> getFieldJourneyConversionEvents() {
    return mJourneyConversionEvents;
  }

  public Boolean getFieldJourneyEnabled() {
    return mJourneyEnabled;
  }

  public String getFieldJourneyTimeout() {
    return mJourneyTimeout;
  }

  public Map<String, String> getFieldLatestSdkVersions() {
    return mLatestSdkVersions;
  }

  public Boolean getFieldLogAndroidImplicitPurchaseEvents() {
    return mLogAndroidImplicitPurchaseEvents;
  }

  public Boolean getFieldLogAutomaticAnalyticsEvents() {
    return mLogAutomaticAnalyticsEvents;
  }

  public Boolean getFieldLogImplicitPurchaseEvents() {
    return mLogImplicitPurchaseEvents;
  }

  public List<String> getFieldPrevJourneyConversionEvents() {
    return mPrevJourneyConversionEvents;
  }

  public String getFieldQueryApproximationAccuracyLevel() {
    return mQueryApproximationAccuracyLevel;
  }

  public String getFieldQueryCurrency() {
    return mQueryCurrency;
  }

  public String getFieldQueryTimezone() {
    return mQueryTimezone;
  }

  public String getFieldRecentEventsUpdateTime() {
    return mRecentEventsUpdateTime;
  }

  public Long getFieldSessionTimeoutInterval() {
    return mSessionTimeoutInterval;
  }

  public Boolean getFieldTrackAndroidAppUninstall() {
    return mTrackAndroidAppUninstall;
  }

  public Boolean getFieldTrackIosAppUninstall() {
    return mTrackIosAppUninstall;
  }



  public static class APIRequestGet extends APIRequest<AppEventConfig> {

    AppEventConfig lastResponse = null;
    @Override
    public AppEventConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "event_name",
    };

    public static final String[] FIELDS = {
      "breakdowns_config",
      "builtin_fields_config",
      "deprecated_events_config",
      "events_config",
      "id",
      "ios_purchase_validation_secret",
      "is_any_role_able_to_see_restricted_insights",
      "is_implicit_purchase_logging_on_android_supported",
      "is_implicit_purchase_logging_on_ios_supported",
      "is_track_android_app_uninstall_supported",
      "is_track_ios_app_uninstall_supported",
      "journey_backfill_status",
      "journey_conversion_events",
      "journey_enabled",
      "journey_timeout",
      "latest_sdk_versions",
      "log_android_implicit_purchase_events",
      "log_automatic_analytics_events",
      "log_implicit_purchase_events",
      "prev_journey_conversion_events",
      "query_approximation_accuracy_level",
      "query_currency",
      "query_timezone",
      "recent_events_update_time",
      "session_timeout_interval",
      "track_android_app_uninstall",
      "track_ios_app_uninstall",
    };

    @Override
    public AppEventConfig parseResponse(String response, String header) throws APIException {
      return AppEventConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AppEventConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AppEventConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AppEventConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AppEventConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AppEventConfig>() {
           public AppEventConfig apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet setEventName (String eventName) {
      this.setParam("event_name", eventName);
      return this;
    }

    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestBreakdownsConfigField () {
      return this.requestBreakdownsConfigField(true);
    }
    public APIRequestGet requestBreakdownsConfigField (boolean value) {
      this.requestField("breakdowns_config", value);
      return this;
    }
    public APIRequestGet requestBuiltinFieldsConfigField () {
      return this.requestBuiltinFieldsConfigField(true);
    }
    public APIRequestGet requestBuiltinFieldsConfigField (boolean value) {
      this.requestField("builtin_fields_config", value);
      return this;
    }
    public APIRequestGet requestDeprecatedEventsConfigField () {
      return this.requestDeprecatedEventsConfigField(true);
    }
    public APIRequestGet requestDeprecatedEventsConfigField (boolean value) {
      this.requestField("deprecated_events_config", value);
      return this;
    }
    public APIRequestGet requestEventsConfigField () {
      return this.requestEventsConfigField(true);
    }
    public APIRequestGet requestEventsConfigField (boolean value) {
      this.requestField("events_config", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIosPurchaseValidationSecretField () {
      return this.requestIosPurchaseValidationSecretField(true);
    }
    public APIRequestGet requestIosPurchaseValidationSecretField (boolean value) {
      this.requestField("ios_purchase_validation_secret", value);
      return this;
    }
    public APIRequestGet requestIsAnyRoleAbleToSeeRestrictedInsightsField () {
      return this.requestIsAnyRoleAbleToSeeRestrictedInsightsField(true);
    }
    public APIRequestGet requestIsAnyRoleAbleToSeeRestrictedInsightsField (boolean value) {
      this.requestField("is_any_role_able_to_see_restricted_insights", value);
      return this;
    }
    public APIRequestGet requestIsImplicitPurchaseLoggingOnAndroidSupportedField () {
      return this.requestIsImplicitPurchaseLoggingOnAndroidSupportedField(true);
    }
    public APIRequestGet requestIsImplicitPurchaseLoggingOnAndroidSupportedField (boolean value) {
      this.requestField("is_implicit_purchase_logging_on_android_supported", value);
      return this;
    }
    public APIRequestGet requestIsImplicitPurchaseLoggingOnIosSupportedField () {
      return this.requestIsImplicitPurchaseLoggingOnIosSupportedField(true);
    }
    public APIRequestGet requestIsImplicitPurchaseLoggingOnIosSupportedField (boolean value) {
      this.requestField("is_implicit_purchase_logging_on_ios_supported", value);
      return this;
    }
    public APIRequestGet requestIsTrackAndroidAppUninstallSupportedField () {
      return this.requestIsTrackAndroidAppUninstallSupportedField(true);
    }
    public APIRequestGet requestIsTrackAndroidAppUninstallSupportedField (boolean value) {
      this.requestField("is_track_android_app_uninstall_supported", value);
      return this;
    }
    public APIRequestGet requestIsTrackIosAppUninstallSupportedField () {
      return this.requestIsTrackIosAppUninstallSupportedField(true);
    }
    public APIRequestGet requestIsTrackIosAppUninstallSupportedField (boolean value) {
      this.requestField("is_track_ios_app_uninstall_supported", value);
      return this;
    }
    public APIRequestGet requestJourneyBackfillStatusField () {
      return this.requestJourneyBackfillStatusField(true);
    }
    public APIRequestGet requestJourneyBackfillStatusField (boolean value) {
      this.requestField("journey_backfill_status", value);
      return this;
    }
    public APIRequestGet requestJourneyConversionEventsField () {
      return this.requestJourneyConversionEventsField(true);
    }
    public APIRequestGet requestJourneyConversionEventsField (boolean value) {
      this.requestField("journey_conversion_events", value);
      return this;
    }
    public APIRequestGet requestJourneyEnabledField () {
      return this.requestJourneyEnabledField(true);
    }
    public APIRequestGet requestJourneyEnabledField (boolean value) {
      this.requestField("journey_enabled", value);
      return this;
    }
    public APIRequestGet requestJourneyTimeoutField () {
      return this.requestJourneyTimeoutField(true);
    }
    public APIRequestGet requestJourneyTimeoutField (boolean value) {
      this.requestField("journey_timeout", value);
      return this;
    }
    public APIRequestGet requestLatestSdkVersionsField () {
      return this.requestLatestSdkVersionsField(true);
    }
    public APIRequestGet requestLatestSdkVersionsField (boolean value) {
      this.requestField("latest_sdk_versions", value);
      return this;
    }
    public APIRequestGet requestLogAndroidImplicitPurchaseEventsField () {
      return this.requestLogAndroidImplicitPurchaseEventsField(true);
    }
    public APIRequestGet requestLogAndroidImplicitPurchaseEventsField (boolean value) {
      this.requestField("log_android_implicit_purchase_events", value);
      return this;
    }
    public APIRequestGet requestLogAutomaticAnalyticsEventsField () {
      return this.requestLogAutomaticAnalyticsEventsField(true);
    }
    public APIRequestGet requestLogAutomaticAnalyticsEventsField (boolean value) {
      this.requestField("log_automatic_analytics_events", value);
      return this;
    }
    public APIRequestGet requestLogImplicitPurchaseEventsField () {
      return this.requestLogImplicitPurchaseEventsField(true);
    }
    public APIRequestGet requestLogImplicitPurchaseEventsField (boolean value) {
      this.requestField("log_implicit_purchase_events", value);
      return this;
    }
    public APIRequestGet requestPrevJourneyConversionEventsField () {
      return this.requestPrevJourneyConversionEventsField(true);
    }
    public APIRequestGet requestPrevJourneyConversionEventsField (boolean value) {
      this.requestField("prev_journey_conversion_events", value);
      return this;
    }
    public APIRequestGet requestQueryApproximationAccuracyLevelField () {
      return this.requestQueryApproximationAccuracyLevelField(true);
    }
    public APIRequestGet requestQueryApproximationAccuracyLevelField (boolean value) {
      this.requestField("query_approximation_accuracy_level", value);
      return this;
    }
    public APIRequestGet requestQueryCurrencyField () {
      return this.requestQueryCurrencyField(true);
    }
    public APIRequestGet requestQueryCurrencyField (boolean value) {
      this.requestField("query_currency", value);
      return this;
    }
    public APIRequestGet requestQueryTimezoneField () {
      return this.requestQueryTimezoneField(true);
    }
    public APIRequestGet requestQueryTimezoneField (boolean value) {
      this.requestField("query_timezone", value);
      return this;
    }
    public APIRequestGet requestRecentEventsUpdateTimeField () {
      return this.requestRecentEventsUpdateTimeField(true);
    }
    public APIRequestGet requestRecentEventsUpdateTimeField (boolean value) {
      this.requestField("recent_events_update_time", value);
      return this;
    }
    public APIRequestGet requestSessionTimeoutIntervalField () {
      return this.requestSessionTimeoutIntervalField(true);
    }
    public APIRequestGet requestSessionTimeoutIntervalField (boolean value) {
      this.requestField("session_timeout_interval", value);
      return this;
    }
    public APIRequestGet requestTrackAndroidAppUninstallField () {
      return this.requestTrackAndroidAppUninstallField(true);
    }
    public APIRequestGet requestTrackAndroidAppUninstallField (boolean value) {
      this.requestField("track_android_app_uninstall", value);
      return this;
    }
    public APIRequestGet requestTrackIosAppUninstallField () {
      return this.requestTrackIosAppUninstallField(true);
    }
    public APIRequestGet requestTrackIosAppUninstallField (boolean value) {
      this.requestField("track_ios_app_uninstall", value);
      return this;
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

  public AppEventConfig copyFrom(AppEventConfig instance) {
    this.mBreakdownsConfig = instance.mBreakdownsConfig;
    this.mBuiltinFieldsConfig = instance.mBuiltinFieldsConfig;
    this.mDeprecatedEventsConfig = instance.mDeprecatedEventsConfig;
    this.mEventsConfig = instance.mEventsConfig;
    this.mId = instance.mId;
    this.mIosPurchaseValidationSecret = instance.mIosPurchaseValidationSecret;
    this.mIsAnyRoleAbleToSeeRestrictedInsights = instance.mIsAnyRoleAbleToSeeRestrictedInsights;
    this.mIsImplicitPurchaseLoggingOnAndroidSupported = instance.mIsImplicitPurchaseLoggingOnAndroidSupported;
    this.mIsImplicitPurchaseLoggingOnIosSupported = instance.mIsImplicitPurchaseLoggingOnIosSupported;
    this.mIsTrackAndroidAppUninstallSupported = instance.mIsTrackAndroidAppUninstallSupported;
    this.mIsTrackIosAppUninstallSupported = instance.mIsTrackIosAppUninstallSupported;
    this.mJourneyBackfillStatus = instance.mJourneyBackfillStatus;
    this.mJourneyConversionEvents = instance.mJourneyConversionEvents;
    this.mJourneyEnabled = instance.mJourneyEnabled;
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
    this.mTrackAndroidAppUninstall = instance.mTrackAndroidAppUninstall;
    this.mTrackIosAppUninstall = instance.mTrackIosAppUninstall;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AppEventConfig> getParser() {
    return new APIRequest.ResponseParser<AppEventConfig>() {
      public APINodeList<AppEventConfig> parseResponse(String response, APIContext context, APIRequest<AppEventConfig> request, String header) throws MalformedResponseException {
        return AppEventConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
