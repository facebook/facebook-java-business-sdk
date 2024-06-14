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
public class AdStudyObjective extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_primary")
  private Boolean mIsPrimary = null;
  @SerializedName("last_updated_results")
  private String mLastUpdatedResults = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("results")
  private List<String> mResults = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  AdStudyObjective() {
  }

  public AdStudyObjective(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdStudyObjective(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdStudyObjective fetch() throws APIException{
    AdStudyObjective newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdStudyObjective fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdStudyObjective> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdStudyObjective fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdStudyObjective> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdStudyObjective> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdStudyObjective>)(
      new APIRequest<AdStudyObjective>(context, "", "/", "GET", AdStudyObjective.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdStudyObjective>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdStudyObjective.getParser())
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
  public static AdStudyObjective loadJSON(String json, APIContext context, String header) {
    AdStudyObjective adStudyObjective = getGson().fromJson(json, AdStudyObjective.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adStudyObjective.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adStudyObjective.context = context;
    adStudyObjective.rawValue = json;
    adStudyObjective.header = header;
    return adStudyObjective;
  }

  public static APINodeList<AdStudyObjective> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdStudyObjective> adStudyObjectives = new APINodeList<AdStudyObjective>(request, json, header);
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
          adStudyObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adStudyObjectives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adStudyObjectives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adStudyObjectives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adStudyObjectives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adStudyObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adStudyObjectives.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudyObjectives.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adStudyObjectives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudyObjectives.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adStudyObjectives;
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
              adStudyObjectives.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adStudyObjectives;
          }

          // Sixth, check if it's pure JsonObject
          adStudyObjectives.clear();
          adStudyObjectives.add(loadJSON(json, context, header));
          return adStudyObjectives;
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

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetApplications getApplications() {
    return new APIRequestGetApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandRequests getBrandRequests() {
    return new APIRequestGetBrandRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomConversions getCustomConversions() {
    return new APIRequestGetCustomConversions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfflineConversionDataSets getOfflineConversionDataSets() {
    return new APIRequestGetOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartnerPrivateStudies getPartnerPrivateStudies() {
    return new APIRequestGetPartnerPrivateStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartnerStudies getPartnerStudies() {
    return new APIRequestGetPartnerStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPrimary() {
    return mIsPrimary;
  }

  public String getFieldLastUpdatedResults() {
    return mLastUpdatedResults;
  }

  public String getFieldName() {
    return mName;
  }

  public List<String> getFieldResults() {
    return mResults;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestGetAdsPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "automatic_matching_fields",
      "can_proxy",
      "code",
      "config",
      "creation_time",
      "creator",
      "data_use_setting",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "enable_automatic_matching",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_party_cookie_status",
      "has_1p_pixel_event",
      "id",
      "is_consolidated_container",
      "is_created_by_business",
      "is_crm",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_fired_time",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "name",
      "owner_ad_account",
      "owner_business",
      "usage",
      "user_access_expire_time",
      "valid_entries",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response, String header) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdsPixels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdsPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/adspixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdsPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdsPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdsPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdsPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdsPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsPixels requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGetAdsPixels requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetAdsPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetAdsPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetAdsPixels requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetAdsPixels requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetAdsPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetAdsPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetAdsPixels requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetAdsPixels requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetAdsPixels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAdsPixels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAdsPixels requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetAdsPixels requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetAdsPixels requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetAdsPixels requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetAdsPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetAdsPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetAdsPixels requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetAdsPixels requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetAdsPixels requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetAdsPixels requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetAdsPixels requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetAdsPixels requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetAdsPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetAdsPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetAdsPixels requestHas1pPixelEventField () {
      return this.requestHas1pPixelEventField(true);
    }
    public APIRequestGetAdsPixels requestHas1pPixelEventField (boolean value) {
      this.requestField("has_1p_pixel_event", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetAdsPixels requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetAdsPixels requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetAdsPixels requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetAdsPixels requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetAdsPixels requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetAdsPixels requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetAdsPixels requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetAdsPixels requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetAdsPixels requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetAdsPixels requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetAdsPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdsPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAdsPixels requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetAdsPixels requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetAdsPixels requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAdsPixels requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetAdsPixels requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetApplications extends APIRequest<Application> {

    APINodeList<Application> lastResponse = null;
    @Override
    public APINodeList<Application> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "aam_rules",
      "an_ad_space_limit",
      "an_platforms",
      "android_key_hash",
      "android_sdk_error_categories",
      "app_domains",
      "app_events_config",
      "app_events_feature_bitmask",
      "app_events_session_timeout",
      "app_install_tracked",
      "app_name",
      "app_signals_binding_ios",
      "app_type",
      "auth_dialog_data_help_url",
      "auth_dialog_headline",
      "auth_dialog_perms_explanation",
      "auth_referral_default_activity_privacy",
      "auth_referral_enabled",
      "auth_referral_extended_perms",
      "auth_referral_friend_perms",
      "auth_referral_response_type",
      "auth_referral_user_perms",
      "auto_event_mapping_android",
      "auto_event_mapping_ios",
      "auto_event_setup_enabled",
      "auto_log_app_events_default",
      "auto_log_app_events_enabled",
      "business",
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "category",
      "client_config",
      "company",
      "configured_ios_sso",
      "contact_email",
      "created_time",
      "creator_uid",
      "daily_active_users",
      "daily_active_users_rank",
      "deauth_callback_url",
      "default_share_mode",
      "description",
      "financial_id",
      "gdpv4_chrome_custom_tabs_enabled",
      "gdpv4_enabled",
      "gdpv4_nux_content",
      "gdpv4_nux_enabled",
      "has_messenger_product",
      "hosting_url",
      "icon_url",
      "id",
      "ios_bundle_id",
      "ios_sdk_dialog_flows",
      "ios_sdk_error_categories",
      "ios_sfvc_attr",
      "ios_supports_native_proxy_auth_flow",
      "ios_supports_system_auth",
      "ipad_app_store_id",
      "iphone_app_store_id",
      "latest_sdk_version",
      "link",
      "logging_token",
      "logo_url",
      "migrations",
      "mobile_profile_section_url",
      "mobile_web_url",
      "monthly_active_users",
      "monthly_active_users_rank",
      "name",
      "namespace",
      "object_store_urls",
      "owner_business",
      "page_tab_default_name",
      "page_tab_url",
      "photo_url",
      "privacy_policy_url",
      "profile_section_url",
      "property_id",
      "protected_mode_rules",
      "real_time_mode_devices",
      "restrictions",
      "restrictive_data_filter_params",
      "restrictive_data_filter_rules",
      "sdk_update_message",
      "seamless_login",
      "secure_canvas_url",
      "secure_page_tab_url",
      "server_ip_whitelist",
      "smart_login_bookmark_icon_url",
      "smart_login_menu_icon_url",
      "social_discovery",
      "subcategory",
      "suggested_events_setting",
      "supported_platforms",
      "supports_apprequests_fast_app_switch",
      "supports_attribution",
      "supports_implicit_sdk_logging",
      "suppress_native_ios_gdp",
      "terms_of_service_url",
      "url_scheme_suffix",
      "user_support_email",
      "user_support_url",
      "website_url",
      "weekly_active_users",
    };

    @Override
    public APINodeList<Application> parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Application> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Application> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Application>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Application>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Application>>() {
           public APINodeList<Application> apply(ResponseWrapper result) {
             try {
               return APIRequestGetApplications.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/applications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetApplications requestAamRulesField () {
      return this.requestAamRulesField(true);
    }
    public APIRequestGetApplications requestAamRulesField (boolean value) {
      this.requestField("aam_rules", value);
      return this;
    }
    public APIRequestGetApplications requestAnAdSpaceLimitField () {
      return this.requestAnAdSpaceLimitField(true);
    }
    public APIRequestGetApplications requestAnAdSpaceLimitField (boolean value) {
      this.requestField("an_ad_space_limit", value);
      return this;
    }
    public APIRequestGetApplications requestAnPlatformsField () {
      return this.requestAnPlatformsField(true);
    }
    public APIRequestGetApplications requestAnPlatformsField (boolean value) {
      this.requestField("an_platforms", value);
      return this;
    }
    public APIRequestGetApplications requestAndroidKeyHashField () {
      return this.requestAndroidKeyHashField(true);
    }
    public APIRequestGetApplications requestAndroidKeyHashField (boolean value) {
      this.requestField("android_key_hash", value);
      return this;
    }
    public APIRequestGetApplications requestAndroidSdkErrorCategoriesField () {
      return this.requestAndroidSdkErrorCategoriesField(true);
    }
    public APIRequestGetApplications requestAndroidSdkErrorCategoriesField (boolean value) {
      this.requestField("android_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetApplications requestAppDomainsField () {
      return this.requestAppDomainsField(true);
    }
    public APIRequestGetApplications requestAppDomainsField (boolean value) {
      this.requestField("app_domains", value);
      return this;
    }
    public APIRequestGetApplications requestAppEventsConfigField () {
      return this.requestAppEventsConfigField(true);
    }
    public APIRequestGetApplications requestAppEventsConfigField (boolean value) {
      this.requestField("app_events_config", value);
      return this;
    }
    public APIRequestGetApplications requestAppEventsFeatureBitmaskField () {
      return this.requestAppEventsFeatureBitmaskField(true);
    }
    public APIRequestGetApplications requestAppEventsFeatureBitmaskField (boolean value) {
      this.requestField("app_events_feature_bitmask", value);
      return this;
    }
    public APIRequestGetApplications requestAppEventsSessionTimeoutField () {
      return this.requestAppEventsSessionTimeoutField(true);
    }
    public APIRequestGetApplications requestAppEventsSessionTimeoutField (boolean value) {
      this.requestField("app_events_session_timeout", value);
      return this;
    }
    public APIRequestGetApplications requestAppInstallTrackedField () {
      return this.requestAppInstallTrackedField(true);
    }
    public APIRequestGetApplications requestAppInstallTrackedField (boolean value) {
      this.requestField("app_install_tracked", value);
      return this;
    }
    public APIRequestGetApplications requestAppNameField () {
      return this.requestAppNameField(true);
    }
    public APIRequestGetApplications requestAppNameField (boolean value) {
      this.requestField("app_name", value);
      return this;
    }
    public APIRequestGetApplications requestAppSignalsBindingIosField () {
      return this.requestAppSignalsBindingIosField(true);
    }
    public APIRequestGetApplications requestAppSignalsBindingIosField (boolean value) {
      this.requestField("app_signals_binding_ios", value);
      return this;
    }
    public APIRequestGetApplications requestAppTypeField () {
      return this.requestAppTypeField(true);
    }
    public APIRequestGetApplications requestAppTypeField (boolean value) {
      this.requestField("app_type", value);
      return this;
    }
    public APIRequestGetApplications requestAuthDialogDataHelpUrlField () {
      return this.requestAuthDialogDataHelpUrlField(true);
    }
    public APIRequestGetApplications requestAuthDialogDataHelpUrlField (boolean value) {
      this.requestField("auth_dialog_data_help_url", value);
      return this;
    }
    public APIRequestGetApplications requestAuthDialogHeadlineField () {
      return this.requestAuthDialogHeadlineField(true);
    }
    public APIRequestGetApplications requestAuthDialogHeadlineField (boolean value) {
      this.requestField("auth_dialog_headline", value);
      return this;
    }
    public APIRequestGetApplications requestAuthDialogPermsExplanationField () {
      return this.requestAuthDialogPermsExplanationField(true);
    }
    public APIRequestGetApplications requestAuthDialogPermsExplanationField (boolean value) {
      this.requestField("auth_dialog_perms_explanation", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralDefaultActivityPrivacyField () {
      return this.requestAuthReferralDefaultActivityPrivacyField(true);
    }
    public APIRequestGetApplications requestAuthReferralDefaultActivityPrivacyField (boolean value) {
      this.requestField("auth_referral_default_activity_privacy", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralEnabledField () {
      return this.requestAuthReferralEnabledField(true);
    }
    public APIRequestGetApplications requestAuthReferralEnabledField (boolean value) {
      this.requestField("auth_referral_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralExtendedPermsField () {
      return this.requestAuthReferralExtendedPermsField(true);
    }
    public APIRequestGetApplications requestAuthReferralExtendedPermsField (boolean value) {
      this.requestField("auth_referral_extended_perms", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralFriendPermsField () {
      return this.requestAuthReferralFriendPermsField(true);
    }
    public APIRequestGetApplications requestAuthReferralFriendPermsField (boolean value) {
      this.requestField("auth_referral_friend_perms", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralResponseTypeField () {
      return this.requestAuthReferralResponseTypeField(true);
    }
    public APIRequestGetApplications requestAuthReferralResponseTypeField (boolean value) {
      this.requestField("auth_referral_response_type", value);
      return this;
    }
    public APIRequestGetApplications requestAuthReferralUserPermsField () {
      return this.requestAuthReferralUserPermsField(true);
    }
    public APIRequestGetApplications requestAuthReferralUserPermsField (boolean value) {
      this.requestField("auth_referral_user_perms", value);
      return this;
    }
    public APIRequestGetApplications requestAutoEventMappingAndroidField () {
      return this.requestAutoEventMappingAndroidField(true);
    }
    public APIRequestGetApplications requestAutoEventMappingAndroidField (boolean value) {
      this.requestField("auto_event_mapping_android", value);
      return this;
    }
    public APIRequestGetApplications requestAutoEventMappingIosField () {
      return this.requestAutoEventMappingIosField(true);
    }
    public APIRequestGetApplications requestAutoEventMappingIosField (boolean value) {
      this.requestField("auto_event_mapping_ios", value);
      return this;
    }
    public APIRequestGetApplications requestAutoEventSetupEnabledField () {
      return this.requestAutoEventSetupEnabledField(true);
    }
    public APIRequestGetApplications requestAutoEventSetupEnabledField (boolean value) {
      this.requestField("auto_event_setup_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestAutoLogAppEventsDefaultField () {
      return this.requestAutoLogAppEventsDefaultField(true);
    }
    public APIRequestGetApplications requestAutoLogAppEventsDefaultField (boolean value) {
      this.requestField("auto_log_app_events_default", value);
      return this;
    }
    public APIRequestGetApplications requestAutoLogAppEventsEnabledField () {
      return this.requestAutoLogAppEventsEnabledField(true);
    }
    public APIRequestGetApplications requestAutoLogAppEventsEnabledField (boolean value) {
      this.requestField("auto_log_app_events_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetApplications requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetApplications requestCanvasFluidHeightField () {
      return this.requestCanvasFluidHeightField(true);
    }
    public APIRequestGetApplications requestCanvasFluidHeightField (boolean value) {
      this.requestField("canvas_fluid_height", value);
      return this;
    }
    public APIRequestGetApplications requestCanvasFluidWidthField () {
      return this.requestCanvasFluidWidthField(true);
    }
    public APIRequestGetApplications requestCanvasFluidWidthField (boolean value) {
      this.requestField("canvas_fluid_width", value);
      return this;
    }
    public APIRequestGetApplications requestCanvasUrlField () {
      return this.requestCanvasUrlField(true);
    }
    public APIRequestGetApplications requestCanvasUrlField (boolean value) {
      this.requestField("canvas_url", value);
      return this;
    }
    public APIRequestGetApplications requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetApplications requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetApplications requestClientConfigField () {
      return this.requestClientConfigField(true);
    }
    public APIRequestGetApplications requestClientConfigField (boolean value) {
      this.requestField("client_config", value);
      return this;
    }
    public APIRequestGetApplications requestCompanyField () {
      return this.requestCompanyField(true);
    }
    public APIRequestGetApplications requestCompanyField (boolean value) {
      this.requestField("company", value);
      return this;
    }
    public APIRequestGetApplications requestConfiguredIosSsoField () {
      return this.requestConfiguredIosSsoField(true);
    }
    public APIRequestGetApplications requestConfiguredIosSsoField (boolean value) {
      this.requestField("configured_ios_sso", value);
      return this;
    }
    public APIRequestGetApplications requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetApplications requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetApplications requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetApplications requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetApplications requestCreatorUidField () {
      return this.requestCreatorUidField(true);
    }
    public APIRequestGetApplications requestCreatorUidField (boolean value) {
      this.requestField("creator_uid", value);
      return this;
    }
    public APIRequestGetApplications requestDailyActiveUsersField () {
      return this.requestDailyActiveUsersField(true);
    }
    public APIRequestGetApplications requestDailyActiveUsersField (boolean value) {
      this.requestField("daily_active_users", value);
      return this;
    }
    public APIRequestGetApplications requestDailyActiveUsersRankField () {
      return this.requestDailyActiveUsersRankField(true);
    }
    public APIRequestGetApplications requestDailyActiveUsersRankField (boolean value) {
      this.requestField("daily_active_users_rank", value);
      return this;
    }
    public APIRequestGetApplications requestDeauthCallbackUrlField () {
      return this.requestDeauthCallbackUrlField(true);
    }
    public APIRequestGetApplications requestDeauthCallbackUrlField (boolean value) {
      this.requestField("deauth_callback_url", value);
      return this;
    }
    public APIRequestGetApplications requestDefaultShareModeField () {
      return this.requestDefaultShareModeField(true);
    }
    public APIRequestGetApplications requestDefaultShareModeField (boolean value) {
      this.requestField("default_share_mode", value);
      return this;
    }
    public APIRequestGetApplications requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetApplications requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetApplications requestFinancialIdField () {
      return this.requestFinancialIdField(true);
    }
    public APIRequestGetApplications requestFinancialIdField (boolean value) {
      this.requestField("financial_id", value);
      return this;
    }
    public APIRequestGetApplications requestGdpv4ChromeCustomTabsEnabledField () {
      return this.requestGdpv4ChromeCustomTabsEnabledField(true);
    }
    public APIRequestGetApplications requestGdpv4ChromeCustomTabsEnabledField (boolean value) {
      this.requestField("gdpv4_chrome_custom_tabs_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestGdpv4EnabledField () {
      return this.requestGdpv4EnabledField(true);
    }
    public APIRequestGetApplications requestGdpv4EnabledField (boolean value) {
      this.requestField("gdpv4_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestGdpv4NuxContentField () {
      return this.requestGdpv4NuxContentField(true);
    }
    public APIRequestGetApplications requestGdpv4NuxContentField (boolean value) {
      this.requestField("gdpv4_nux_content", value);
      return this;
    }
    public APIRequestGetApplications requestGdpv4NuxEnabledField () {
      return this.requestGdpv4NuxEnabledField(true);
    }
    public APIRequestGetApplications requestGdpv4NuxEnabledField (boolean value) {
      this.requestField("gdpv4_nux_enabled", value);
      return this;
    }
    public APIRequestGetApplications requestHasMessengerProductField () {
      return this.requestHasMessengerProductField(true);
    }
    public APIRequestGetApplications requestHasMessengerProductField (boolean value) {
      this.requestField("has_messenger_product", value);
      return this;
    }
    public APIRequestGetApplications requestHostingUrlField () {
      return this.requestHostingUrlField(true);
    }
    public APIRequestGetApplications requestHostingUrlField (boolean value) {
      this.requestField("hosting_url", value);
      return this;
    }
    public APIRequestGetApplications requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetApplications requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetApplications requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetApplications requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetApplications requestIosBundleIdField () {
      return this.requestIosBundleIdField(true);
    }
    public APIRequestGetApplications requestIosBundleIdField (boolean value) {
      this.requestField("ios_bundle_id", value);
      return this;
    }
    public APIRequestGetApplications requestIosSdkDialogFlowsField () {
      return this.requestIosSdkDialogFlowsField(true);
    }
    public APIRequestGetApplications requestIosSdkDialogFlowsField (boolean value) {
      this.requestField("ios_sdk_dialog_flows", value);
      return this;
    }
    public APIRequestGetApplications requestIosSdkErrorCategoriesField () {
      return this.requestIosSdkErrorCategoriesField(true);
    }
    public APIRequestGetApplications requestIosSdkErrorCategoriesField (boolean value) {
      this.requestField("ios_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetApplications requestIosSfvcAttrField () {
      return this.requestIosSfvcAttrField(true);
    }
    public APIRequestGetApplications requestIosSfvcAttrField (boolean value) {
      this.requestField("ios_sfvc_attr", value);
      return this;
    }
    public APIRequestGetApplications requestIosSupportsNativeProxyAuthFlowField () {
      return this.requestIosSupportsNativeProxyAuthFlowField(true);
    }
    public APIRequestGetApplications requestIosSupportsNativeProxyAuthFlowField (boolean value) {
      this.requestField("ios_supports_native_proxy_auth_flow", value);
      return this;
    }
    public APIRequestGetApplications requestIosSupportsSystemAuthField () {
      return this.requestIosSupportsSystemAuthField(true);
    }
    public APIRequestGetApplications requestIosSupportsSystemAuthField (boolean value) {
      this.requestField("ios_supports_system_auth", value);
      return this;
    }
    public APIRequestGetApplications requestIpadAppStoreIdField () {
      return this.requestIpadAppStoreIdField(true);
    }
    public APIRequestGetApplications requestIpadAppStoreIdField (boolean value) {
      this.requestField("ipad_app_store_id", value);
      return this;
    }
    public APIRequestGetApplications requestIphoneAppStoreIdField () {
      return this.requestIphoneAppStoreIdField(true);
    }
    public APIRequestGetApplications requestIphoneAppStoreIdField (boolean value) {
      this.requestField("iphone_app_store_id", value);
      return this;
    }
    public APIRequestGetApplications requestLatestSdkVersionField () {
      return this.requestLatestSdkVersionField(true);
    }
    public APIRequestGetApplications requestLatestSdkVersionField (boolean value) {
      this.requestField("latest_sdk_version", value);
      return this;
    }
    public APIRequestGetApplications requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetApplications requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetApplications requestLoggingTokenField () {
      return this.requestLoggingTokenField(true);
    }
    public APIRequestGetApplications requestLoggingTokenField (boolean value) {
      this.requestField("logging_token", value);
      return this;
    }
    public APIRequestGetApplications requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGetApplications requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGetApplications requestMigrationsField () {
      return this.requestMigrationsField(true);
    }
    public APIRequestGetApplications requestMigrationsField (boolean value) {
      this.requestField("migrations", value);
      return this;
    }
    public APIRequestGetApplications requestMobileProfileSectionUrlField () {
      return this.requestMobileProfileSectionUrlField(true);
    }
    public APIRequestGetApplications requestMobileProfileSectionUrlField (boolean value) {
      this.requestField("mobile_profile_section_url", value);
      return this;
    }
    public APIRequestGetApplications requestMobileWebUrlField () {
      return this.requestMobileWebUrlField(true);
    }
    public APIRequestGetApplications requestMobileWebUrlField (boolean value) {
      this.requestField("mobile_web_url", value);
      return this;
    }
    public APIRequestGetApplications requestMonthlyActiveUsersField () {
      return this.requestMonthlyActiveUsersField(true);
    }
    public APIRequestGetApplications requestMonthlyActiveUsersField (boolean value) {
      this.requestField("monthly_active_users", value);
      return this;
    }
    public APIRequestGetApplications requestMonthlyActiveUsersRankField () {
      return this.requestMonthlyActiveUsersRankField(true);
    }
    public APIRequestGetApplications requestMonthlyActiveUsersRankField (boolean value) {
      this.requestField("monthly_active_users_rank", value);
      return this;
    }
    public APIRequestGetApplications requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetApplications requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetApplications requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGetApplications requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGetApplications requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGetApplications requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGetApplications requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetApplications requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetApplications requestPageTabDefaultNameField () {
      return this.requestPageTabDefaultNameField(true);
    }
    public APIRequestGetApplications requestPageTabDefaultNameField (boolean value) {
      this.requestField("page_tab_default_name", value);
      return this;
    }
    public APIRequestGetApplications requestPageTabUrlField () {
      return this.requestPageTabUrlField(true);
    }
    public APIRequestGetApplications requestPageTabUrlField (boolean value) {
      this.requestField("page_tab_url", value);
      return this;
    }
    public APIRequestGetApplications requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGetApplications requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
      return this;
    }
    public APIRequestGetApplications requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetApplications requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetApplications requestProfileSectionUrlField () {
      return this.requestProfileSectionUrlField(true);
    }
    public APIRequestGetApplications requestProfileSectionUrlField (boolean value) {
      this.requestField("profile_section_url", value);
      return this;
    }
    public APIRequestGetApplications requestPropertyIdField () {
      return this.requestPropertyIdField(true);
    }
    public APIRequestGetApplications requestPropertyIdField (boolean value) {
      this.requestField("property_id", value);
      return this;
    }
    public APIRequestGetApplications requestProtectedModeRulesField () {
      return this.requestProtectedModeRulesField(true);
    }
    public APIRequestGetApplications requestProtectedModeRulesField (boolean value) {
      this.requestField("protected_mode_rules", value);
      return this;
    }
    public APIRequestGetApplications requestRealTimeModeDevicesField () {
      return this.requestRealTimeModeDevicesField(true);
    }
    public APIRequestGetApplications requestRealTimeModeDevicesField (boolean value) {
      this.requestField("real_time_mode_devices", value);
      return this;
    }
    public APIRequestGetApplications requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGetApplications requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGetApplications requestRestrictiveDataFilterParamsField () {
      return this.requestRestrictiveDataFilterParamsField(true);
    }
    public APIRequestGetApplications requestRestrictiveDataFilterParamsField (boolean value) {
      this.requestField("restrictive_data_filter_params", value);
      return this;
    }
    public APIRequestGetApplications requestRestrictiveDataFilterRulesField () {
      return this.requestRestrictiveDataFilterRulesField(true);
    }
    public APIRequestGetApplications requestRestrictiveDataFilterRulesField (boolean value) {
      this.requestField("restrictive_data_filter_rules", value);
      return this;
    }
    public APIRequestGetApplications requestSdkUpdateMessageField () {
      return this.requestSdkUpdateMessageField(true);
    }
    public APIRequestGetApplications requestSdkUpdateMessageField (boolean value) {
      this.requestField("sdk_update_message", value);
      return this;
    }
    public APIRequestGetApplications requestSeamlessLoginField () {
      return this.requestSeamlessLoginField(true);
    }
    public APIRequestGetApplications requestSeamlessLoginField (boolean value) {
      this.requestField("seamless_login", value);
      return this;
    }
    public APIRequestGetApplications requestSecureCanvasUrlField () {
      return this.requestSecureCanvasUrlField(true);
    }
    public APIRequestGetApplications requestSecureCanvasUrlField (boolean value) {
      this.requestField("secure_canvas_url", value);
      return this;
    }
    public APIRequestGetApplications requestSecurePageTabUrlField () {
      return this.requestSecurePageTabUrlField(true);
    }
    public APIRequestGetApplications requestSecurePageTabUrlField (boolean value) {
      this.requestField("secure_page_tab_url", value);
      return this;
    }
    public APIRequestGetApplications requestServerIpWhitelistField () {
      return this.requestServerIpWhitelistField(true);
    }
    public APIRequestGetApplications requestServerIpWhitelistField (boolean value) {
      this.requestField("server_ip_whitelist", value);
      return this;
    }
    public APIRequestGetApplications requestSmartLoginBookmarkIconUrlField () {
      return this.requestSmartLoginBookmarkIconUrlField(true);
    }
    public APIRequestGetApplications requestSmartLoginBookmarkIconUrlField (boolean value) {
      this.requestField("smart_login_bookmark_icon_url", value);
      return this;
    }
    public APIRequestGetApplications requestSmartLoginMenuIconUrlField () {
      return this.requestSmartLoginMenuIconUrlField(true);
    }
    public APIRequestGetApplications requestSmartLoginMenuIconUrlField (boolean value) {
      this.requestField("smart_login_menu_icon_url", value);
      return this;
    }
    public APIRequestGetApplications requestSocialDiscoveryField () {
      return this.requestSocialDiscoveryField(true);
    }
    public APIRequestGetApplications requestSocialDiscoveryField (boolean value) {
      this.requestField("social_discovery", value);
      return this;
    }
    public APIRequestGetApplications requestSubcategoryField () {
      return this.requestSubcategoryField(true);
    }
    public APIRequestGetApplications requestSubcategoryField (boolean value) {
      this.requestField("subcategory", value);
      return this;
    }
    public APIRequestGetApplications requestSuggestedEventsSettingField () {
      return this.requestSuggestedEventsSettingField(true);
    }
    public APIRequestGetApplications requestSuggestedEventsSettingField (boolean value) {
      this.requestField("suggested_events_setting", value);
      return this;
    }
    public APIRequestGetApplications requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGetApplications requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGetApplications requestSupportsApprequestsFastAppSwitchField () {
      return this.requestSupportsApprequestsFastAppSwitchField(true);
    }
    public APIRequestGetApplications requestSupportsApprequestsFastAppSwitchField (boolean value) {
      this.requestField("supports_apprequests_fast_app_switch", value);
      return this;
    }
    public APIRequestGetApplications requestSupportsAttributionField () {
      return this.requestSupportsAttributionField(true);
    }
    public APIRequestGetApplications requestSupportsAttributionField (boolean value) {
      this.requestField("supports_attribution", value);
      return this;
    }
    public APIRequestGetApplications requestSupportsImplicitSdkLoggingField () {
      return this.requestSupportsImplicitSdkLoggingField(true);
    }
    public APIRequestGetApplications requestSupportsImplicitSdkLoggingField (boolean value) {
      this.requestField("supports_implicit_sdk_logging", value);
      return this;
    }
    public APIRequestGetApplications requestSuppressNativeIosGdpField () {
      return this.requestSuppressNativeIosGdpField(true);
    }
    public APIRequestGetApplications requestSuppressNativeIosGdpField (boolean value) {
      this.requestField("suppress_native_ios_gdp", value);
      return this;
    }
    public APIRequestGetApplications requestTermsOfServiceUrlField () {
      return this.requestTermsOfServiceUrlField(true);
    }
    public APIRequestGetApplications requestTermsOfServiceUrlField (boolean value) {
      this.requestField("terms_of_service_url", value);
      return this;
    }
    public APIRequestGetApplications requestUrlSchemeSuffixField () {
      return this.requestUrlSchemeSuffixField(true);
    }
    public APIRequestGetApplications requestUrlSchemeSuffixField (boolean value) {
      this.requestField("url_scheme_suffix", value);
      return this;
    }
    public APIRequestGetApplications requestUserSupportEmailField () {
      return this.requestUserSupportEmailField(true);
    }
    public APIRequestGetApplications requestUserSupportEmailField (boolean value) {
      this.requestField("user_support_email", value);
      return this;
    }
    public APIRequestGetApplications requestUserSupportUrlField () {
      return this.requestUserSupportUrlField(true);
    }
    public APIRequestGetApplications requestUserSupportUrlField (boolean value) {
      this.requestField("user_support_url", value);
      return this;
    }
    public APIRequestGetApplications requestWebsiteUrlField () {
      return this.requestWebsiteUrlField(true);
    }
    public APIRequestGetApplications requestWebsiteUrlField (boolean value) {
      this.requestField("website_url", value);
      return this;
    }
    public APIRequestGetApplications requestWeeklyActiveUsersField () {
      return this.requestWeeklyActiveUsersField(true);
    }
    public APIRequestGetApplications requestWeeklyActiveUsersField (boolean value) {
      this.requestField("weekly_active_users", value);
      return this;
    }
  }

  public static class APIRequestGetBrandRequests extends APIRequest<BrandRequest> {

    APINodeList<BrandRequest> lastResponse = null;
    @Override
    public APINodeList<BrandRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_countries",
      "additional_contacts",
      "approval_level",
      "cells",
      "countries",
      "deny_reason",
      "end_time",
      "estimated_reach",
      "id",
      "is_multicell",
      "locale",
      "max_age",
      "min_age",
      "questions",
      "region",
      "request_status",
      "review_date",
      "start_time",
      "status",
      "submit_date",
      "total_budget",
    };

    @Override
    public APINodeList<BrandRequest> parseResponse(String response, String header) throws APIException {
      return BrandRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BrandRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BrandRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BrandRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BrandRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BrandRequest>>() {
           public APINodeList<BrandRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/brand_requests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandRequests requestAdCountriesField () {
      return this.requestAdCountriesField(true);
    }
    public APIRequestGetBrandRequests requestAdCountriesField (boolean value) {
      this.requestField("ad_countries", value);
      return this;
    }
    public APIRequestGetBrandRequests requestAdditionalContactsField () {
      return this.requestAdditionalContactsField(true);
    }
    public APIRequestGetBrandRequests requestAdditionalContactsField (boolean value) {
      this.requestField("additional_contacts", value);
      return this;
    }
    public APIRequestGetBrandRequests requestApprovalLevelField () {
      return this.requestApprovalLevelField(true);
    }
    public APIRequestGetBrandRequests requestApprovalLevelField (boolean value) {
      this.requestField("approval_level", value);
      return this;
    }
    public APIRequestGetBrandRequests requestCellsField () {
      return this.requestCellsField(true);
    }
    public APIRequestGetBrandRequests requestCellsField (boolean value) {
      this.requestField("cells", value);
      return this;
    }
    public APIRequestGetBrandRequests requestCountriesField () {
      return this.requestCountriesField(true);
    }
    public APIRequestGetBrandRequests requestCountriesField (boolean value) {
      this.requestField("countries", value);
      return this;
    }
    public APIRequestGetBrandRequests requestDenyReasonField () {
      return this.requestDenyReasonField(true);
    }
    public APIRequestGetBrandRequests requestDenyReasonField (boolean value) {
      this.requestField("deny_reason", value);
      return this;
    }
    public APIRequestGetBrandRequests requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetBrandRequests requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetBrandRequests requestEstimatedReachField () {
      return this.requestEstimatedReachField(true);
    }
    public APIRequestGetBrandRequests requestEstimatedReachField (boolean value) {
      this.requestField("estimated_reach", value);
      return this;
    }
    public APIRequestGetBrandRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBrandRequests requestIsMulticellField () {
      return this.requestIsMulticellField(true);
    }
    public APIRequestGetBrandRequests requestIsMulticellField (boolean value) {
      this.requestField("is_multicell", value);
      return this;
    }
    public APIRequestGetBrandRequests requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetBrandRequests requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetBrandRequests requestMaxAgeField () {
      return this.requestMaxAgeField(true);
    }
    public APIRequestGetBrandRequests requestMaxAgeField (boolean value) {
      this.requestField("max_age", value);
      return this;
    }
    public APIRequestGetBrandRequests requestMinAgeField () {
      return this.requestMinAgeField(true);
    }
    public APIRequestGetBrandRequests requestMinAgeField (boolean value) {
      this.requestField("min_age", value);
      return this;
    }
    public APIRequestGetBrandRequests requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGetBrandRequests requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGetBrandRequests requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGetBrandRequests requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGetBrandRequests requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetBrandRequests requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGetBrandRequests requestReviewDateField () {
      return this.requestReviewDateField(true);
    }
    public APIRequestGetBrandRequests requestReviewDateField (boolean value) {
      this.requestField("review_date", value);
      return this;
    }
    public APIRequestGetBrandRequests requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetBrandRequests requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetBrandRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetBrandRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetBrandRequests requestSubmitDateField () {
      return this.requestSubmitDateField(true);
    }
    public APIRequestGetBrandRequests requestSubmitDateField (boolean value) {
      this.requestField("submit_date", value);
      return this;
    }
    public APIRequestGetBrandRequests requestTotalBudgetField () {
      return this.requestTotalBudgetField(true);
    }
    public APIRequestGetBrandRequests requestTotalBudgetField (boolean value) {
      this.requestField("total_budget", value);
      return this;
    }
  }

  public static class APIRequestGetCustomConversions extends APIRequest<CustomConversion> {

    APINodeList<CustomConversion> lastResponse = null;
    @Override
    public APINodeList<CustomConversion> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "aggregation_rule",
      "business",
      "creation_time",
      "custom_event_type",
      "data_sources",
      "default_conversion_value",
      "description",
      "event_source_type",
      "first_fired_time",
      "id",
      "is_archived",
      "is_unavailable",
      "last_fired_time",
      "name",
      "offline_conversion_data_set",
      "pixel",
      "retention_days",
      "rule",
    };

    @Override
    public APINodeList<CustomConversion> parseResponse(String response, String header) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CustomConversion> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversion> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CustomConversion>>() {
           public APINodeList<CustomConversion> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCustomConversions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCustomConversions(String nodeId, APIContext context) {
      super(context, nodeId, "/customconversions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCustomConversions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCustomConversions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomConversions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomConversions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomConversions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCustomConversions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomConversions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCustomConversions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCustomConversions requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCustomConversions requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCustomConversions requestAggregationRuleField () {
      return this.requestAggregationRuleField(true);
    }
    public APIRequestGetCustomConversions requestAggregationRuleField (boolean value) {
      this.requestField("aggregation_rule", value);
      return this;
    }
    public APIRequestGetCustomConversions requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetCustomConversions requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetCustomConversions requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetCustomConversions requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetCustomConversions requestCustomEventTypeField () {
      return this.requestCustomEventTypeField(true);
    }
    public APIRequestGetCustomConversions requestCustomEventTypeField (boolean value) {
      this.requestField("custom_event_type", value);
      return this;
    }
    public APIRequestGetCustomConversions requestDataSourcesField () {
      return this.requestDataSourcesField(true);
    }
    public APIRequestGetCustomConversions requestDataSourcesField (boolean value) {
      this.requestField("data_sources", value);
      return this;
    }
    public APIRequestGetCustomConversions requestDefaultConversionValueField () {
      return this.requestDefaultConversionValueField(true);
    }
    public APIRequestGetCustomConversions requestDefaultConversionValueField (boolean value) {
      this.requestField("default_conversion_value", value);
      return this;
    }
    public APIRequestGetCustomConversions requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetCustomConversions requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetCustomConversions requestEventSourceTypeField () {
      return this.requestEventSourceTypeField(true);
    }
    public APIRequestGetCustomConversions requestEventSourceTypeField (boolean value) {
      this.requestField("event_source_type", value);
      return this;
    }
    public APIRequestGetCustomConversions requestFirstFiredTimeField () {
      return this.requestFirstFiredTimeField(true);
    }
    public APIRequestGetCustomConversions requestFirstFiredTimeField (boolean value) {
      this.requestField("first_fired_time", value);
      return this;
    }
    public APIRequestGetCustomConversions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCustomConversions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCustomConversions requestIsArchivedField () {
      return this.requestIsArchivedField(true);
    }
    public APIRequestGetCustomConversions requestIsArchivedField (boolean value) {
      this.requestField("is_archived", value);
      return this;
    }
    public APIRequestGetCustomConversions requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetCustomConversions requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetCustomConversions requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetCustomConversions requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetCustomConversions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCustomConversions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCustomConversions requestOfflineConversionDataSetField () {
      return this.requestOfflineConversionDataSetField(true);
    }
    public APIRequestGetCustomConversions requestOfflineConversionDataSetField (boolean value) {
      this.requestField("offline_conversion_data_set", value);
      return this;
    }
    public APIRequestGetCustomConversions requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGetCustomConversions requestPixelField (boolean value) {
      this.requestField("pixel", value);
      return this;
    }
    public APIRequestGetCustomConversions requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGetCustomConversions requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGetCustomConversions requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGetCustomConversions requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
  }

  public static class APIRequestGetOfflineConversionDataSets extends APIRequest<OfflineConversionDataSet> {

    APINodeList<OfflineConversionDataSet> lastResponse = null;
    @Override
    public APINodeList<OfflineConversionDataSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "automatic_matching_fields",
      "business",
      "can_proxy",
      "config",
      "creation_time",
      "creator",
      "data_use_setting",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "enable_automatic_matching",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_party_cookie_status",
      "id",
      "is_consolidated_container",
      "is_created_by_business",
      "is_crm",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_fired_time",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "name",
      "owner_ad_account",
      "owner_business",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<OfflineConversionDataSet> parseResponse(String response, String header) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OfflineConversionDataSet>>() {
           public APINodeList<OfflineConversionDataSet> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOfflineConversionDataSets.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOfflineConversionDataSets(String nodeId, APIContext context) {
      super(context, nodeId, "/offline_conversion_data_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOfflineConversionDataSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOfflineConversionDataSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOfflineConversionDataSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOfflineConversionDataSets requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetPartnerPrivateStudies extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "collaborative_ads_managed_partner_business_info",
      "collaborative_ads_managed_partner_eligibility",
      "collaborative_ads_partner_premium_options",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "user_access_expire_time",
      "verification_status",
      "vertical",
      "vertical_id",
    };

    @Override
    public APINodeList<Business> parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Business>>() {
           public APINodeList<Business> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPartnerPrivateStudies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPartnerPrivateStudies(String nodeId, APIContext context) {
      super(context, nodeId, "/partner_private_studies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartnerPrivateStudies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartnerPrivateStudies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerPrivateStudies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerPrivateStudies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerPrivateStudies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartnerPrivateStudies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerPrivateStudies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartnerPrivateStudies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerPrivateStudies requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetPartnerPrivateStudies requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetPartnerPrivateStudies requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestGetPartnerStudies extends APIRequest<PartnerStudy> {

    APINodeList<PartnerStudy> lastResponse = null;
    @Override
    public APINodeList<PartnerStudy> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_info",
      "brand",
      "client_name",
      "emails",
      "id",
      "input_ids",
      "is_export",
      "lift_study",
      "location",
      "match_file_ds",
      "name",
      "partner_defined_id",
      "partner_household_graph_dataset_id",
      "status",
      "study_end_date",
      "study_start_date",
      "study_type",
      "submit_date",
    };

    @Override
    public APINodeList<PartnerStudy> parseResponse(String response, String header) throws APIException {
      return PartnerStudy.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<PartnerStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PartnerStudy> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PartnerStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PartnerStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<PartnerStudy>>() {
           public APINodeList<PartnerStudy> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPartnerStudies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPartnerStudies(String nodeId, APIContext context) {
      super(context, nodeId, "/partnerstudies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartnerStudies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartnerStudies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerStudies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerStudies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerStudies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartnerStudies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerStudies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartnerStudies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerStudies requestAdditionalInfoField () {
      return this.requestAdditionalInfoField(true);
    }
    public APIRequestGetPartnerStudies requestAdditionalInfoField (boolean value) {
      this.requestField("additional_info", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGetPartnerStudies requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestClientNameField () {
      return this.requestClientNameField(true);
    }
    public APIRequestGetPartnerStudies requestClientNameField (boolean value) {
      this.requestField("client_name", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetPartnerStudies requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerStudies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestInputIdsField () {
      return this.requestInputIdsField(true);
    }
    public APIRequestGetPartnerStudies requestInputIdsField (boolean value) {
      this.requestField("input_ids", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestIsExportField () {
      return this.requestIsExportField(true);
    }
    public APIRequestGetPartnerStudies requestIsExportField (boolean value) {
      this.requestField("is_export", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestLiftStudyField () {
      return this.requestLiftStudyField(true);
    }
    public APIRequestGetPartnerStudies requestLiftStudyField (boolean value) {
      this.requestField("lift_study", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetPartnerStudies requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestMatchFileDsField () {
      return this.requestMatchFileDsField(true);
    }
    public APIRequestGetPartnerStudies requestMatchFileDsField (boolean value) {
      this.requestField("match_file_ds", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartnerStudies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestPartnerDefinedIdField () {
      return this.requestPartnerDefinedIdField(true);
    }
    public APIRequestGetPartnerStudies requestPartnerDefinedIdField (boolean value) {
      this.requestField("partner_defined_id", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestPartnerHouseholdGraphDatasetIdField () {
      return this.requestPartnerHouseholdGraphDatasetIdField(true);
    }
    public APIRequestGetPartnerStudies requestPartnerHouseholdGraphDatasetIdField (boolean value) {
      this.requestField("partner_household_graph_dataset_id", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPartnerStudies requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestStudyEndDateField () {
      return this.requestStudyEndDateField(true);
    }
    public APIRequestGetPartnerStudies requestStudyEndDateField (boolean value) {
      this.requestField("study_end_date", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestStudyStartDateField () {
      return this.requestStudyStartDateField(true);
    }
    public APIRequestGetPartnerStudies requestStudyStartDateField (boolean value) {
      this.requestField("study_start_date", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestStudyTypeField () {
      return this.requestStudyTypeField(true);
    }
    public APIRequestGetPartnerStudies requestStudyTypeField (boolean value) {
      this.requestField("study_type", value);
      return this;
    }
    public APIRequestGetPartnerStudies requestSubmitDateField () {
      return this.requestSubmitDateField(true);
    }
    public APIRequestGetPartnerStudies requestSubmitDateField (boolean value) {
      this.requestField("submit_date", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<AdStudyObjective> {

    AdStudyObjective lastResponse = null;
    @Override
    public AdStudyObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdowns",
      "ds",
    };

    public static final String[] FIELDS = {
      "id",
      "is_primary",
      "last_updated_results",
      "name",
      "results",
      "type",
    };

    @Override
    public AdStudyObjective parseResponse(String response, String header) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudyObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyObjective execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudyObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudyObjective>() {
           public AdStudyObjective apply(ResponseWrapper result) {
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


    public APIRequestGet setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGet setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGet setDs (String ds) {
      this.setParam("ds", ds);
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsPrimaryField () {
      return this.requestIsPrimaryField(true);
    }
    public APIRequestGet requestIsPrimaryField (boolean value) {
      this.requestField("is_primary", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedResultsField () {
      return this.requestLastUpdatedResultsField(true);
    }
    public APIRequestGet requestLastUpdatedResultsField (boolean value) {
      this.requestField("last_updated_results", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGet requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdStudyObjective> {

    AdStudyObjective lastResponse = null;
    @Override
    public AdStudyObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adspixels",
      "applications",
      "customconversions",
      "is_primary",
      "name",
      "offline_conversion_data_sets",
      "offsite_datasets",
      "product_catalogs",
      "product_sets",
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudyObjective parseResponse(String response, String header) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudyObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyObjective execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudyObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudyObjective>() {
           public AdStudyObjective apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAdspixels (List<Object> adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }
    public APIRequestUpdate setAdspixels (String adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }

    public APIRequestUpdate setApplications (List<Object> applications) {
      this.setParam("applications", applications);
      return this;
    }
    public APIRequestUpdate setApplications (String applications) {
      this.setParam("applications", applications);
      return this;
    }

    public APIRequestUpdate setCustomconversions (List<Object> customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }
    public APIRequestUpdate setCustomconversions (String customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }

    public APIRequestUpdate setIsPrimary (Boolean isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }
    public APIRequestUpdate setIsPrimary (String isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setOfflineConversionDataSets (List<Object> offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }
    public APIRequestUpdate setOfflineConversionDataSets (String offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }

    public APIRequestUpdate setOffsiteDatasets (List<Object> offsiteDatasets) {
      this.setParam("offsite_datasets", offsiteDatasets);
      return this;
    }
    public APIRequestUpdate setOffsiteDatasets (String offsiteDatasets) {
      this.setParam("offsite_datasets", offsiteDatasets);
      return this;
    }

    public APIRequestUpdate setProductCatalogs (List<Object> productCatalogs) {
      this.setParam("product_catalogs", productCatalogs);
      return this;
    }
    public APIRequestUpdate setProductCatalogs (String productCatalogs) {
      this.setParam("product_catalogs", productCatalogs);
      return this;
    }

    public APIRequestUpdate setProductSets (List<Object> productSets) {
      this.setParam("product_sets", productSets);
      return this;
    }
    public APIRequestUpdate setProductSets (String productSets) {
      this.setParam("product_sets", productSets);
      return this;
    }

    public APIRequestUpdate setType (AdStudyObjective.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestUpdate setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumType {
      @SerializedName("BRAND")
      VALUE_BRAND("BRAND"),
      @SerializedName("BRANDLIFT")
      VALUE_BRANDLIFT("BRANDLIFT"),
      @SerializedName("CONVERSIONS")
      VALUE_CONVERSIONS("CONVERSIONS"),
      @SerializedName("FTL")
      VALUE_FTL("FTL"),
      @SerializedName("MAE")
      VALUE_MAE("MAE"),
      @SerializedName("MAI")
      VALUE_MAI("MAI"),
      @SerializedName("MPC_CONVERSION")
      VALUE_MPC_CONVERSION("MPC_CONVERSION"),
      @SerializedName("NONSALES")
      VALUE_NONSALES("NONSALES"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      @SerializedName("SALES")
      VALUE_SALES("SALES"),
      @SerializedName("TELCO")
      VALUE_TELCO("TELCO"),
      ;

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("cell_id")
      VALUE_CELL_ID("cell_id"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      ;

      private String value;

      private EnumBreakdowns(String value) {
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

  public AdStudyObjective copyFrom(AdStudyObjective instance) {
    this.mId = instance.mId;
    this.mIsPrimary = instance.mIsPrimary;
    this.mLastUpdatedResults = instance.mLastUpdatedResults;
    this.mName = instance.mName;
    this.mResults = instance.mResults;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdStudyObjective> getParser() {
    return new APIRequest.ResponseParser<AdStudyObjective>() {
      public APINodeList<AdStudyObjective> parseResponse(String response, APIContext context, APIRequest<AdStudyObjective> request, String header) throws MalformedResponseException {
        return AdStudyObjective.parseResponse(response, context, request, header);
      }
    };
  }
}
