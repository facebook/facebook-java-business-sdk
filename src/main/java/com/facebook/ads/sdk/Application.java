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
public class Application extends APINode {
  @SerializedName("aam_rules")
  private String mAamRules = null;
  @SerializedName("an_ad_space_limit")
  private Long mAnAdSpaceLimit = null;
  @SerializedName("an_platforms")
  private List<String> mAnPlatforms = null;
  @SerializedName("android_key_hash")
  private List<String> mAndroidKeyHash = null;
  @SerializedName("android_sdk_error_categories")
  private List<Object> mAndroidSdkErrorCategories = null;
  @SerializedName("app_domains")
  private List<String> mAppDomains = null;
  @SerializedName("app_events_config")
  private Object mAppEventsConfig = null;
  @SerializedName("app_events_feature_bitmask")
  private Long mAppEventsFeatureBitmask = null;
  @SerializedName("app_events_session_timeout")
  private Long mAppEventsSessionTimeout = null;
  @SerializedName("app_install_tracked")
  private Boolean mAppInstallTracked = null;
  @SerializedName("app_name")
  private String mAppName = null;
  @SerializedName("app_signals_binding_ios")
  private List<Object> mAppSignalsBindingIos = null;
  @SerializedName("app_type")
  private Long mAppType = null;
  @SerializedName("auth_dialog_data_help_url")
  private String mAuthDialogDataHelpUrl = null;
  @SerializedName("auth_dialog_headline")
  private String mAuthDialogHeadline = null;
  @SerializedName("auth_dialog_perms_explanation")
  private String mAuthDialogPermsExplanation = null;
  @SerializedName("auth_referral_default_activity_privacy")
  private String mAuthReferralDefaultActivityPrivacy = null;
  @SerializedName("auth_referral_enabled")
  private Long mAuthReferralEnabled = null;
  @SerializedName("auth_referral_extended_perms")
  private List<String> mAuthReferralExtendedPerms = null;
  @SerializedName("auth_referral_friend_perms")
  private List<String> mAuthReferralFriendPerms = null;
  @SerializedName("auth_referral_response_type")
  private String mAuthReferralResponseType = null;
  @SerializedName("auth_referral_user_perms")
  private List<String> mAuthReferralUserPerms = null;
  @SerializedName("auto_event_mapping_android")
  private List<Object> mAutoEventMappingAndroid = null;
  @SerializedName("auto_event_mapping_ios")
  private List<Object> mAutoEventMappingIos = null;
  @SerializedName("auto_event_setup_enabled")
  private Boolean mAutoEventSetupEnabled = null;
  @SerializedName("auto_log_app_events_default")
  private Boolean mAutoLogAppEventsDefault = null;
  @SerializedName("auto_log_app_events_enabled")
  private Boolean mAutoLogAppEventsEnabled = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("canvas_fluid_height")
  private Boolean mCanvasFluidHeight = null;
  @SerializedName("canvas_fluid_width")
  private Long mCanvasFluidWidth = null;
  @SerializedName("canvas_url")
  private String mCanvasUrl = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("client_config")
  private Map<String, String> mClientConfig = null;
  @SerializedName("company")
  private String mCompany = null;
  @SerializedName("configured_ios_sso")
  private Boolean mConfiguredIosSso = null;
  @SerializedName("contact_email")
  private String mContactEmail = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creator_uid")
  private String mCreatorUid = null;
  @SerializedName("daily_active_users")
  private String mDailyActiveUsers = null;
  @SerializedName("daily_active_users_rank")
  private Long mDailyActiveUsersRank = null;
  @SerializedName("deauth_callback_url")
  private String mDeauthCallbackUrl = null;
  @SerializedName("default_share_mode")
  private String mDefaultShareMode = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("financial_id")
  private String mFinancialId = null;
  @SerializedName("gdpv4_chrome_custom_tabs_enabled")
  private Boolean mGdpv4ChromeCustomTabsEnabled = null;
  @SerializedName("gdpv4_enabled")
  private Boolean mGdpv4Enabled = null;
  @SerializedName("gdpv4_nux_content")
  private String mGdpv4NuxContent = null;
  @SerializedName("gdpv4_nux_enabled")
  private Boolean mGdpv4NuxEnabled = null;
  @SerializedName("has_messenger_product")
  private Boolean mHasMessengerProduct = null;
  @SerializedName("hosting_url")
  private String mHostingUrl = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ios_bundle_id")
  private List<String> mIosBundleId = null;
  @SerializedName("ios_sdk_dialog_flows")
  private Object mIosSdkDialogFlows = null;
  @SerializedName("ios_sdk_error_categories")
  private List<Object> mIosSdkErrorCategories = null;
  @SerializedName("ios_sfvc_attr")
  private Boolean mIosSfvcAttr = null;
  @SerializedName("ios_supports_native_proxy_auth_flow")
  private Boolean mIosSupportsNativeProxyAuthFlow = null;
  @SerializedName("ios_supports_system_auth")
  private Boolean mIosSupportsSystemAuth = null;
  @SerializedName("ipad_app_store_id")
  private String mIpadAppStoreId = null;
  @SerializedName("iphone_app_store_id")
  private String mIphoneAppStoreId = null;
  @SerializedName("latest_sdk_version")
  private Object mLatestSdkVersion = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("logging_token")
  private String mLoggingToken = null;
  @SerializedName("logo_url")
  private String mLogoUrl = null;
  @SerializedName("migrations")
  private Map<String, Boolean> mMigrations = null;
  @SerializedName("mobile_profile_section_url")
  private String mMobileProfileSectionUrl = null;
  @SerializedName("mobile_web_url")
  private String mMobileWebUrl = null;
  @SerializedName("monthly_active_users")
  private String mMonthlyActiveUsers = null;
  @SerializedName("monthly_active_users_rank")
  private Long mMonthlyActiveUsersRank = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("namespace")
  private String mNamespace = null;
  @SerializedName("object_store_urls")
  private Object mObjectStoreUrls = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("page_tab_default_name")
  private String mPageTabDefaultName = null;
  @SerializedName("page_tab_url")
  private String mPageTabUrl = null;
  @SerializedName("photo_url")
  private String mPhotoUrl = null;
  @SerializedName("privacy_policy_url")
  private String mPrivacyPolicyUrl = null;
  @SerializedName("profile_section_url")
  private String mProfileSectionUrl = null;
  @SerializedName("property_id")
  private String mPropertyId = null;
  @SerializedName("protected_mode_rules")
  private Object mProtectedModeRules = null;
  @SerializedName("real_time_mode_devices")
  private List<String> mRealTimeModeDevices = null;
  @SerializedName("restrictions")
  private Object mRestrictions = null;
  @SerializedName("restrictive_data_filter_params")
  private String mRestrictiveDataFilterParams = null;
  @SerializedName("restrictive_data_filter_rules")
  private String mRestrictiveDataFilterRules = null;
  @SerializedName("sdk_update_message")
  private String mSdkUpdateMessage = null;
  @SerializedName("seamless_login")
  private Long mSeamlessLogin = null;
  @SerializedName("secure_canvas_url")
  private String mSecureCanvasUrl = null;
  @SerializedName("secure_page_tab_url")
  private String mSecurePageTabUrl = null;
  @SerializedName("server_ip_whitelist")
  private String mServerIpWhitelist = null;
  @SerializedName("smart_login_bookmark_icon_url")
  private String mSmartLoginBookmarkIconUrl = null;
  @SerializedName("smart_login_menu_icon_url")
  private String mSmartLoginMenuIconUrl = null;
  @SerializedName("social_discovery")
  private Long mSocialDiscovery = null;
  @SerializedName("subcategory")
  private String mSubcategory = null;
  @SerializedName("suggested_events_setting")
  private String mSuggestedEventsSetting = null;
  @SerializedName("supported_platforms")
  private List<EnumSupportedPlatforms> mSupportedPlatforms = null;
  @SerializedName("supports_apprequests_fast_app_switch")
  private Object mSupportsApprequestsFastAppSwitch = null;
  @SerializedName("supports_attribution")
  private Boolean mSupportsAttribution = null;
  @SerializedName("supports_implicit_sdk_logging")
  private Boolean mSupportsImplicitSdkLogging = null;
  @SerializedName("suppress_native_ios_gdp")
  private Boolean mSuppressNativeIosGdp = null;
  @SerializedName("terms_of_service_url")
  private String mTermsOfServiceUrl = null;
  @SerializedName("url_scheme_suffix")
  private String mUrlSchemeSuffix = null;
  @SerializedName("user_support_email")
  private String mUserSupportEmail = null;
  @SerializedName("user_support_url")
  private String mUserSupportUrl = null;
  @SerializedName("website_url")
  private String mWebsiteUrl = null;
  @SerializedName("weekly_active_users")
  private String mWeeklyActiveUsers = null;
  protected static Gson gson = null;

  Application() {
  }

  public Application(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Application(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Application fetch() throws APIException{
    Application newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Application fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Application> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Application fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Application> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Application> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Application>)(
      new APIRequest<Application>(context, "", "/", "GET", Application.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Application>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Application.getParser())
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
  public static Application loadJSON(String json, APIContext context, String header) {
    Application application = getGson().fromJson(json, Application.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(application.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    application.context = context;
    application.rawValue = json;
    application.header = header;
    return application;
  }

  public static APINodeList<Application> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Application> applications = new APINodeList<Application>(request, json, header);
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
          applications.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return applications;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                applications.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            applications.setPaging(previous, next);
            if (context.hasAppSecret()) {
              applications.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              applications.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  applications.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              applications.add(loadJSON(obj.toString(), context, header));
            }
          }
          return applications;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              applications.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return applications;
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
              applications.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return applications;
          }

          // Sixth, check if it's pure JsonObject
          applications.clear();
          applications.add(loadJSON(json, context, header));
          return applications;
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

  public APIRequestDeleteAccounts deleteAccounts() {
    return new APIRequestDeleteAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAccounts getAccounts() {
    return new APIRequestGetAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAccount createAccount() {
    return new APIRequestCreateAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateActivity createActivity() {
    return new APIRequestCreateActivity(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdPlacementGroups getAdPlacementGroups() {
    return new APIRequestGetAdPlacementGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkPlacements getAdNetworkPlacements() {
    return new APIRequestGetAdNetworkPlacements(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkAnalytics getAdNetworkAnalytics() {
    return new APIRequestGetAdNetworkAnalytics(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdNetworkAnalytic createAdNetworkAnalytic() {
    return new APIRequestCreateAdNetworkAnalytic(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkAnalyticsResults getAdNetworkAnalyticsResults() {
    return new APIRequestGetAdNetworkAnalyticsResults(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAemAttribution getAemAttribution() {
    return new APIRequestGetAemAttribution(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAemConversionConfigs getAemConversionConfigs() {
    return new APIRequestGetAemConversionConfigs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAemConversionFilter getAemConversionFilter() {
    return new APIRequestGetAemConversionFilter(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAemConversion createAemConversion() {
    return new APIRequestCreateAemConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAemSkanReadiness createAemSkanReadiness() {
    return new APIRequestCreateAemSkanReadiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAggregateRevenue createAggregateRevenue() {
    return new APIRequestCreateAggregateRevenue(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAndroidDialogConfigs getAndroidDialogConfigs() {
    return new APIRequestGetAndroidDialogConfigs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAppCapiSettings getAppCapiSettings() {
    return new APIRequestGetAppCapiSettings(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAppEventTypes getAppEventTypes() {
    return new APIRequestGetAppEventTypes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAppIndexing createAppIndexing() {
    return new APIRequestCreateAppIndexing(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAppIndexingSession createAppIndexingSession() {
    return new APIRequestCreateAppIndexingSession(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAppInstalledGroups getAppInstalledGroups() {
    return new APIRequestGetAppInstalledGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAppPushDeviceToken createAppPushDeviceToken() {
    return new APIRequestCreateAppPushDeviceToken(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAppAssets getAppAssets() {
    return new APIRequestGetAppAssets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAsset createAsset() {
    return new APIRequestCreateAsset(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAuthorizedAdAccounts getAuthorizedAdAccounts() {
    return new APIRequestGetAuthorizedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetButtonAutoDetectionDeviceSelection getButtonAutoDetectionDeviceSelection() {
    return new APIRequestGetButtonAutoDetectionDeviceSelection(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCloudbridgeSettings getCloudbridgeSettings() {
    return new APIRequestGetCloudbridgeSettings(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCodelessEventMapping createCodelessEventMapping() {
    return new APIRequestCreateCodelessEventMapping(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDaChecks getDaChecks() {
    return new APIRequestGetDaChecks(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateDomainReport createDomainReport() {
    return new APIRequestCreateDomainReport(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetIapPurchases getIapPurchases() {
    return new APIRequestGetIapPurchases(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetIosDialogConfigs getIosDialogConfigs() {
    return new APIRequestGetIosDialogConfigs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLinkedDataset getLinkedDataset() {
    return new APIRequestGetLinkedDataset(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMmpAuditing createMmpAuditing() {
    return new APIRequestCreateMmpAuditing(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMobileSdkGk getMobileSdkGk() {
    return new APIRequestGetMobileSdkGk(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMonetizedDigitalStoreObjects getMonetizedDigitalStoreObjects() {
    return new APIRequestGetMonetizedDigitalStoreObjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMonetizedDigitalStoreObject createMonetizedDigitalStoreObject() {
    return new APIRequestCreateMonetizedDigitalStoreObject(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetObjectTypes getObjectTypes() {
    return new APIRequestGetObjectTypes(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetObjects getObjects() {
    return new APIRequestGetObjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOccludesPopup createOccludesPopup() {
    return new APIRequestCreateOccludesPopup(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePageActivity createPageActivity() {
    return new APIRequestCreatePageActivity(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePaymentCurrency createPaymentCurrency() {
    return new APIRequestCreatePaymentCurrency(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPermissions getPermissions() {
    return new APIRequestGetPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPurchases getPurchases() {
    return new APIRequestGetPurchases(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRoles getRoles() {
    return new APIRequestGetRoles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetServerDomainInfos getServerDomainInfos() {
    return new APIRequestGetServerDomainInfos(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSubscribedDomains getSubscribedDomains() {
    return new APIRequestGetSubscribedDomains(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedDomain createSubscribedDomain() {
    return new APIRequestCreateSubscribedDomain(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSubscribedDomainsPhishing getSubscribedDomainsPhishing() {
    return new APIRequestGetSubscribedDomainsPhishing(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedDomainsPhishing createSubscribedDomainsPhishing() {
    return new APIRequestCreateSubscribedDomainsPhishing(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteSubscriptions deleteSubscriptions() {
    return new APIRequestDeleteSubscriptions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscription createSubscription() {
    return new APIRequestCreateSubscription(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpload createUpload() {
    return new APIRequestCreateUpload(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateWhatsAppBusinessSolution createWhatsAppBusinessSolution() {
    return new APIRequestCreateWhatsAppBusinessSolution(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetWhatsAppBusinessSolutions getWhatsAppBusinessSolutions() {
    return new APIRequestGetWhatsAppBusinessSolutions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAamRules() {
    return mAamRules;
  }

  public Long getFieldAnAdSpaceLimit() {
    return mAnAdSpaceLimit;
  }

  public List<String> getFieldAnPlatforms() {
    return mAnPlatforms;
  }

  public List<String> getFieldAndroidKeyHash() {
    return mAndroidKeyHash;
  }

  public List<Object> getFieldAndroidSdkErrorCategories() {
    return mAndroidSdkErrorCategories;
  }

  public List<String> getFieldAppDomains() {
    return mAppDomains;
  }

  public Object getFieldAppEventsConfig() {
    return mAppEventsConfig;
  }

  public Long getFieldAppEventsFeatureBitmask() {
    return mAppEventsFeatureBitmask;
  }

  public Long getFieldAppEventsSessionTimeout() {
    return mAppEventsSessionTimeout;
  }

  public Boolean getFieldAppInstallTracked() {
    return mAppInstallTracked;
  }

  public String getFieldAppName() {
    return mAppName;
  }

  public List<Object> getFieldAppSignalsBindingIos() {
    return mAppSignalsBindingIos;
  }

  public Long getFieldAppType() {
    return mAppType;
  }

  public String getFieldAuthDialogDataHelpUrl() {
    return mAuthDialogDataHelpUrl;
  }

  public String getFieldAuthDialogHeadline() {
    return mAuthDialogHeadline;
  }

  public String getFieldAuthDialogPermsExplanation() {
    return mAuthDialogPermsExplanation;
  }

  public String getFieldAuthReferralDefaultActivityPrivacy() {
    return mAuthReferralDefaultActivityPrivacy;
  }

  public Long getFieldAuthReferralEnabled() {
    return mAuthReferralEnabled;
  }

  public List<String> getFieldAuthReferralExtendedPerms() {
    return mAuthReferralExtendedPerms;
  }

  public List<String> getFieldAuthReferralFriendPerms() {
    return mAuthReferralFriendPerms;
  }

  public String getFieldAuthReferralResponseType() {
    return mAuthReferralResponseType;
  }

  public List<String> getFieldAuthReferralUserPerms() {
    return mAuthReferralUserPerms;
  }

  public List<Object> getFieldAutoEventMappingAndroid() {
    return mAutoEventMappingAndroid;
  }

  public List<Object> getFieldAutoEventMappingIos() {
    return mAutoEventMappingIos;
  }

  public Boolean getFieldAutoEventSetupEnabled() {
    return mAutoEventSetupEnabled;
  }

  public Boolean getFieldAutoLogAppEventsDefault() {
    return mAutoLogAppEventsDefault;
  }

  public Boolean getFieldAutoLogAppEventsEnabled() {
    return mAutoLogAppEventsEnabled;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public Boolean getFieldCanvasFluidHeight() {
    return mCanvasFluidHeight;
  }

  public Long getFieldCanvasFluidWidth() {
    return mCanvasFluidWidth;
  }

  public String getFieldCanvasUrl() {
    return mCanvasUrl;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public Map<String, String> getFieldClientConfig() {
    return mClientConfig;
  }

  public String getFieldCompany() {
    return mCompany;
  }

  public Boolean getFieldConfiguredIosSso() {
    return mConfiguredIosSso;
  }

  public String getFieldContactEmail() {
    return mContactEmail;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldCreatorUid() {
    return mCreatorUid;
  }

  public String getFieldDailyActiveUsers() {
    return mDailyActiveUsers;
  }

  public Long getFieldDailyActiveUsersRank() {
    return mDailyActiveUsersRank;
  }

  public String getFieldDeauthCallbackUrl() {
    return mDeauthCallbackUrl;
  }

  public String getFieldDefaultShareMode() {
    return mDefaultShareMode;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldFinancialId() {
    return mFinancialId;
  }

  public Boolean getFieldGdpv4ChromeCustomTabsEnabled() {
    return mGdpv4ChromeCustomTabsEnabled;
  }

  public Boolean getFieldGdpv4Enabled() {
    return mGdpv4Enabled;
  }

  public String getFieldGdpv4NuxContent() {
    return mGdpv4NuxContent;
  }

  public Boolean getFieldGdpv4NuxEnabled() {
    return mGdpv4NuxEnabled;
  }

  public Boolean getFieldHasMessengerProduct() {
    return mHasMessengerProduct;
  }

  public String getFieldHostingUrl() {
    return mHostingUrl;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldIosBundleId() {
    return mIosBundleId;
  }

  public Object getFieldIosSdkDialogFlows() {
    return mIosSdkDialogFlows;
  }

  public List<Object> getFieldIosSdkErrorCategories() {
    return mIosSdkErrorCategories;
  }

  public Boolean getFieldIosSfvcAttr() {
    return mIosSfvcAttr;
  }

  public Boolean getFieldIosSupportsNativeProxyAuthFlow() {
    return mIosSupportsNativeProxyAuthFlow;
  }

  public Boolean getFieldIosSupportsSystemAuth() {
    return mIosSupportsSystemAuth;
  }

  public String getFieldIpadAppStoreId() {
    return mIpadAppStoreId;
  }

  public String getFieldIphoneAppStoreId() {
    return mIphoneAppStoreId;
  }

  public Object getFieldLatestSdkVersion() {
    return mLatestSdkVersion;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldLoggingToken() {
    return mLoggingToken;
  }

  public String getFieldLogoUrl() {
    return mLogoUrl;
  }

  public Map<String, Boolean> getFieldMigrations() {
    return mMigrations;
  }

  public String getFieldMobileProfileSectionUrl() {
    return mMobileProfileSectionUrl;
  }

  public String getFieldMobileWebUrl() {
    return mMobileWebUrl;
  }

  public String getFieldMonthlyActiveUsers() {
    return mMonthlyActiveUsers;
  }

  public Long getFieldMonthlyActiveUsersRank() {
    return mMonthlyActiveUsersRank;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldNamespace() {
    return mNamespace;
  }

  public Object getFieldObjectStoreUrls() {
    return mObjectStoreUrls;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldPageTabDefaultName() {
    return mPageTabDefaultName;
  }

  public String getFieldPageTabUrl() {
    return mPageTabUrl;
  }

  public String getFieldPhotoUrl() {
    return mPhotoUrl;
  }

  public String getFieldPrivacyPolicyUrl() {
    return mPrivacyPolicyUrl;
  }

  public String getFieldProfileSectionUrl() {
    return mProfileSectionUrl;
  }

  public String getFieldPropertyId() {
    return mPropertyId;
  }

  public Object getFieldProtectedModeRules() {
    return mProtectedModeRules;
  }

  public List<String> getFieldRealTimeModeDevices() {
    return mRealTimeModeDevices;
  }

  public Object getFieldRestrictions() {
    return mRestrictions;
  }

  public String getFieldRestrictiveDataFilterParams() {
    return mRestrictiveDataFilterParams;
  }

  public String getFieldRestrictiveDataFilterRules() {
    return mRestrictiveDataFilterRules;
  }

  public String getFieldSdkUpdateMessage() {
    return mSdkUpdateMessage;
  }

  public Long getFieldSeamlessLogin() {
    return mSeamlessLogin;
  }

  public String getFieldSecureCanvasUrl() {
    return mSecureCanvasUrl;
  }

  public String getFieldSecurePageTabUrl() {
    return mSecurePageTabUrl;
  }

  public String getFieldServerIpWhitelist() {
    return mServerIpWhitelist;
  }

  public String getFieldSmartLoginBookmarkIconUrl() {
    return mSmartLoginBookmarkIconUrl;
  }

  public String getFieldSmartLoginMenuIconUrl() {
    return mSmartLoginMenuIconUrl;
  }

  public Long getFieldSocialDiscovery() {
    return mSocialDiscovery;
  }

  public String getFieldSubcategory() {
    return mSubcategory;
  }

  public String getFieldSuggestedEventsSetting() {
    return mSuggestedEventsSetting;
  }

  public List<EnumSupportedPlatforms> getFieldSupportedPlatforms() {
    return mSupportedPlatforms;
  }

  public Object getFieldSupportsApprequestsFastAppSwitch() {
    return mSupportsApprequestsFastAppSwitch;
  }

  public Boolean getFieldSupportsAttribution() {
    return mSupportsAttribution;
  }

  public Boolean getFieldSupportsImplicitSdkLogging() {
    return mSupportsImplicitSdkLogging;
  }

  public Boolean getFieldSuppressNativeIosGdp() {
    return mSuppressNativeIosGdp;
  }

  public String getFieldTermsOfServiceUrl() {
    return mTermsOfServiceUrl;
  }

  public String getFieldUrlSchemeSuffix() {
    return mUrlSchemeSuffix;
  }

  public String getFieldUserSupportEmail() {
    return mUserSupportEmail;
  }

  public String getFieldUserSupportUrl() {
    return mUserSupportUrl;
  }

  public String getFieldWebsiteUrl() {
    return mWebsiteUrl;
  }

  public String getFieldWeeklyActiveUsers() {
    return mWeeklyActiveUsers;
  }



  public static class APIRequestDeleteAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestDeleteAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/accounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAccounts setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestDeleteAccounts setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestDeleteAccounts setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestDeleteAccounts setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestDeleteAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAccounts setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetAccounts setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAccount extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "installed",
      "minor",
      "name",
      "owner_access_token",
      "permissions",
      "type",
      "uid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAccount setInstalled (Boolean installed) {
      this.setParam("installed", installed);
      return this;
    }
    public APIRequestCreateAccount setInstalled (String installed) {
      this.setParam("installed", installed);
      return this;
    }

    public APIRequestCreateAccount setMinor (Boolean minor) {
      this.setParam("minor", minor);
      return this;
    }
    public APIRequestCreateAccount setMinor (String minor) {
      this.setParam("minor", minor);
      return this;
    }

    public APIRequestCreateAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAccount setOwnerAccessToken (String ownerAccessToken) {
      this.setParam("owner_access_token", ownerAccessToken);
      return this;
    }

    public APIRequestCreateAccount setPermissions (List<Permission> permissions) {
      this.setParam("permissions", permissions);
      return this;
    }
    public APIRequestCreateAccount setPermissions (String permissions) {
      this.setParam("permissions", permissions);
      return this;
    }

    public APIRequestCreateAccount setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateAccount setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateAccount setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreateAccount setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreateAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateActivity extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_id",
      "advertiser_tracking_enabled",
      "anon_id",
      "app_user_id",
      "application_tracking_enabled",
      "attribution",
      "auto_publish",
      "bundle_id",
      "bundle_short_version",
      "bundle_version",
      "campaign_ids",
      "click_id",
      "consider_views",
      "custom_events",
      "custom_events_file",
      "data_processing_options",
      "data_processing_options_country",
      "data_processing_options_state",
      "device_token",
      "event",
      "extinfo",
      "include_dwell_data",
      "include_video_data",
      "install_referrer",
      "install_timestamp",
      "installer_package",
      "limited_data_use",
      "migration_bundle",
      "page_id",
      "page_scoped_user_id",
      "receipt_data",
      "sdk_version",
      "ud",
      "url_schemes",
      "user_id",
      "user_id_type",
      "vendor_id",
      "windows_attribution_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateActivity.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateActivity(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateActivity setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateActivity setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateActivity setAdvertiserId (String advertiserId) {
      this.setParam("advertiser_id", advertiserId);
      return this;
    }

    public APIRequestCreateActivity setAdvertiserTrackingEnabled (Boolean advertiserTrackingEnabled) {
      this.setParam("advertiser_tracking_enabled", advertiserTrackingEnabled);
      return this;
    }
    public APIRequestCreateActivity setAdvertiserTrackingEnabled (String advertiserTrackingEnabled) {
      this.setParam("advertiser_tracking_enabled", advertiserTrackingEnabled);
      return this;
    }

    public APIRequestCreateActivity setAnonId (String anonId) {
      this.setParam("anon_id", anonId);
      return this;
    }

    public APIRequestCreateActivity setAppUserId (String appUserId) {
      this.setParam("app_user_id", appUserId);
      return this;
    }

    public APIRequestCreateActivity setApplicationTrackingEnabled (Boolean applicationTrackingEnabled) {
      this.setParam("application_tracking_enabled", applicationTrackingEnabled);
      return this;
    }
    public APIRequestCreateActivity setApplicationTrackingEnabled (String applicationTrackingEnabled) {
      this.setParam("application_tracking_enabled", applicationTrackingEnabled);
      return this;
    }

    public APIRequestCreateActivity setAttribution (String attribution) {
      this.setParam("attribution", attribution);
      return this;
    }

    public APIRequestCreateActivity setAutoPublish (Boolean autoPublish) {
      this.setParam("auto_publish", autoPublish);
      return this;
    }
    public APIRequestCreateActivity setAutoPublish (String autoPublish) {
      this.setParam("auto_publish", autoPublish);
      return this;
    }

    public APIRequestCreateActivity setBundleId (String bundleId) {
      this.setParam("bundle_id", bundleId);
      return this;
    }

    public APIRequestCreateActivity setBundleShortVersion (String bundleShortVersion) {
      this.setParam("bundle_short_version", bundleShortVersion);
      return this;
    }

    public APIRequestCreateActivity setBundleVersion (String bundleVersion) {
      this.setParam("bundle_version", bundleVersion);
      return this;
    }

    public APIRequestCreateActivity setCampaignIds (String campaignIds) {
      this.setParam("campaign_ids", campaignIds);
      return this;
    }

    public APIRequestCreateActivity setClickId (String clickId) {
      this.setParam("click_id", clickId);
      return this;
    }

    public APIRequestCreateActivity setConsiderViews (Boolean considerViews) {
      this.setParam("consider_views", considerViews);
      return this;
    }
    public APIRequestCreateActivity setConsiderViews (String considerViews) {
      this.setParam("consider_views", considerViews);
      return this;
    }

    public APIRequestCreateActivity setCustomEvents (List<Object> customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }
    public APIRequestCreateActivity setCustomEvents (String customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }

    public APIRequestCreateActivity setCustomEventsFile (File customEventsFile) {
      this.setParam("custom_events_file", customEventsFile);
      return this;
    }
    public APIRequestCreateActivity setCustomEventsFile (String customEventsFile) {
      this.setParam("custom_events_file", customEventsFile);
      return this;
    }

    public APIRequestCreateActivity setDataProcessingOptions (List<String> dataProcessingOptions) {
      this.setParam("data_processing_options", dataProcessingOptions);
      return this;
    }
    public APIRequestCreateActivity setDataProcessingOptions (String dataProcessingOptions) {
      this.setParam("data_processing_options", dataProcessingOptions);
      return this;
    }

    public APIRequestCreateActivity setDataProcessingOptionsCountry (Long dataProcessingOptionsCountry) {
      this.setParam("data_processing_options_country", dataProcessingOptionsCountry);
      return this;
    }
    public APIRequestCreateActivity setDataProcessingOptionsCountry (String dataProcessingOptionsCountry) {
      this.setParam("data_processing_options_country", dataProcessingOptionsCountry);
      return this;
    }

    public APIRequestCreateActivity setDataProcessingOptionsState (Long dataProcessingOptionsState) {
      this.setParam("data_processing_options_state", dataProcessingOptionsState);
      return this;
    }
    public APIRequestCreateActivity setDataProcessingOptionsState (String dataProcessingOptionsState) {
      this.setParam("data_processing_options_state", dataProcessingOptionsState);
      return this;
    }

    public APIRequestCreateActivity setDeviceToken (String deviceToken) {
      this.setParam("device_token", deviceToken);
      return this;
    }

    public APIRequestCreateActivity setEvent (EnumEvent event) {
      this.setParam("event", event);
      return this;
    }
    public APIRequestCreateActivity setEvent (String event) {
      this.setParam("event", event);
      return this;
    }

    public APIRequestCreateActivity setExtinfo (Object extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }
    public APIRequestCreateActivity setExtinfo (String extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }

    public APIRequestCreateActivity setIncludeDwellData (Boolean includeDwellData) {
      this.setParam("include_dwell_data", includeDwellData);
      return this;
    }
    public APIRequestCreateActivity setIncludeDwellData (String includeDwellData) {
      this.setParam("include_dwell_data", includeDwellData);
      return this;
    }

    public APIRequestCreateActivity setIncludeVideoData (Boolean includeVideoData) {
      this.setParam("include_video_data", includeVideoData);
      return this;
    }
    public APIRequestCreateActivity setIncludeVideoData (String includeVideoData) {
      this.setParam("include_video_data", includeVideoData);
      return this;
    }

    public APIRequestCreateActivity setInstallReferrer (String installReferrer) {
      this.setParam("install_referrer", installReferrer);
      return this;
    }

    public APIRequestCreateActivity setInstallTimestamp (Long installTimestamp) {
      this.setParam("install_timestamp", installTimestamp);
      return this;
    }
    public APIRequestCreateActivity setInstallTimestamp (String installTimestamp) {
      this.setParam("install_timestamp", installTimestamp);
      return this;
    }

    public APIRequestCreateActivity setInstallerPackage (String installerPackage) {
      this.setParam("installer_package", installerPackage);
      return this;
    }

    public APIRequestCreateActivity setLimitedDataUse (Boolean limitedDataUse) {
      this.setParam("limited_data_use", limitedDataUse);
      return this;
    }
    public APIRequestCreateActivity setLimitedDataUse (String limitedDataUse) {
      this.setParam("limited_data_use", limitedDataUse);
      return this;
    }

    public APIRequestCreateActivity setMigrationBundle (String migrationBundle) {
      this.setParam("migration_bundle", migrationBundle);
      return this;
    }

    public APIRequestCreateActivity setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreateActivity setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreateActivity setPageScopedUserId (Long pageScopedUserId) {
      this.setParam("page_scoped_user_id", pageScopedUserId);
      return this;
    }
    public APIRequestCreateActivity setPageScopedUserId (String pageScopedUserId) {
      this.setParam("page_scoped_user_id", pageScopedUserId);
      return this;
    }

    public APIRequestCreateActivity setReceiptData (String receiptData) {
      this.setParam("receipt_data", receiptData);
      return this;
    }

    public APIRequestCreateActivity setSdkVersion (String sdkVersion) {
      this.setParam("sdk_version", sdkVersion);
      return this;
    }

    public APIRequestCreateActivity setUd (Map<String, String> ud) {
      this.setParam("ud", ud);
      return this;
    }
    public APIRequestCreateActivity setUd (String ud) {
      this.setParam("ud", ud);
      return this;
    }

    public APIRequestCreateActivity setUrlSchemes (List<String> urlSchemes) {
      this.setParam("url_schemes", urlSchemes);
      return this;
    }
    public APIRequestCreateActivity setUrlSchemes (String urlSchemes) {
      this.setParam("url_schemes", urlSchemes);
      return this;
    }

    public APIRequestCreateActivity setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestCreateActivity setUserIdType (EnumUserIdType userIdType) {
      this.setParam("user_id_type", userIdType);
      return this;
    }
    public APIRequestCreateActivity setUserIdType (String userIdType) {
      this.setParam("user_id_type", userIdType);
      return this;
    }

    public APIRequestCreateActivity setVendorId (String vendorId) {
      this.setParam("vendor_id", vendorId);
      return this;
    }

    public APIRequestCreateActivity setWindowsAttributionId (String windowsAttributionId) {
      this.setParam("windows_attribution_id", windowsAttributionId);
      return this;
    }

    public APIRequestCreateActivity requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateActivity requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateActivity requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateActivity requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateActivity requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateActivity requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdPlacementGroups extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdPlacementGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdPlacementGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_placement_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdPlacementGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdPlacementGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdPlacementGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdPlacementGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlacementGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdPlacementGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlacementGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdPlacementGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdNetworkPlacements extends APIRequest<AdPlacement> {

    APINodeList<AdPlacement> lastResponse = null;
    @Override
    public APINodeList<AdPlacement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "request_id",
    };

    public static final String[] FIELDS = {
      "bundle_id",
      "display_format",
      "external_placement_id",
      "google_display_format",
      "id",
      "name",
      "placement_group",
      "platform",
      "status",
    };

    @Override
    public APINodeList<AdPlacement> parseResponse(String response, String header) throws APIException {
      return AdPlacement.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdPlacement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPlacement> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdPlacement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdPlacement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdPlacement>>() {
           public APINodeList<AdPlacement> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdNetworkPlacements.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdNetworkPlacements(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetwork_placements", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdNetworkPlacements setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkPlacements setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdNetworkPlacements setRequestId (String requestId) {
      this.setParam("request_id", requestId);
      return this;
    }

    public APIRequestGetAdNetworkPlacements requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdNetworkPlacements requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkPlacements requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdNetworkPlacements requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkPlacements requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkPlacements requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdNetworkPlacements requestBundleIdField () {
      return this.requestBundleIdField(true);
    }
    public APIRequestGetAdNetworkPlacements requestBundleIdField (boolean value) {
      this.requestField("bundle_id", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestDisplayFormatField () {
      return this.requestDisplayFormatField(true);
    }
    public APIRequestGetAdNetworkPlacements requestDisplayFormatField (boolean value) {
      this.requestField("display_format", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestExternalPlacementIdField () {
      return this.requestExternalPlacementIdField(true);
    }
    public APIRequestGetAdNetworkPlacements requestExternalPlacementIdField (boolean value) {
      this.requestField("external_placement_id", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestGoogleDisplayFormatField () {
      return this.requestGoogleDisplayFormatField(true);
    }
    public APIRequestGetAdNetworkPlacements requestGoogleDisplayFormatField (boolean value) {
      this.requestField("google_display_format", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdNetworkPlacements requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdNetworkPlacements requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestPlacementGroupField () {
      return this.requestPlacementGroupField(true);
    }
    public APIRequestGetAdNetworkPlacements requestPlacementGroupField (boolean value) {
      this.requestField("placement_group", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetAdNetworkPlacements requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetAdNetworkPlacements requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdNetworkPlacements requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetAdNetworkAnalytics extends APIRequest<AdNetworkAnalyticsSyncQueryResult> {

    APINodeList<AdNetworkAnalyticsSyncQueryResult> lastResponse = null;
    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_period",
      "breakdowns",
      "filters",
      "limit",
      "metrics",
      "ordering_column",
      "ordering_type",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "omitted_results",
      "query_id",
      "results",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String response, String header) throws APIException {
      return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdNetworkAnalyticsSyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsSyncQueryResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdNetworkAnalytics.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdNetworkAnalytics(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdNetworkAnalytics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdNetworkAnalytics setAggregationPeriod (AdNetworkAnalyticsSyncQueryResult.EnumAggregationPeriod aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setAggregationPeriod (String aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setBreakdowns (List<AdNetworkAnalyticsSyncQueryResult.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setFilters (List<Map<String, String>> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setMetrics (List<AdNetworkAnalyticsSyncQueryResult.EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setOrderingColumn (AdNetworkAnalyticsSyncQueryResult.EnumOrderingColumn orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setOrderingColumn (String orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setOrderingType (AdNetworkAnalyticsSyncQueryResult.EnumOrderingType orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setOrderingType (String orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdNetworkAnalytics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics requestOmittedResultsField () {
      return this.requestOmittedResultsField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestOmittedResultsField (boolean value) {
      this.requestField("omitted_results", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics requestQueryIdField () {
      return this.requestQueryIdField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestQueryIdField (boolean value) {
      this.requestField("query_id", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
  }

  public static class APIRequestCreateAdNetworkAnalytic extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_period",
      "breakdowns",
      "filters",
      "limit",
      "metrics",
      "ordering_column",
      "ordering_type",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdNetworkAnalytic.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdNetworkAnalytic(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdNetworkAnalytic setAggregationPeriod (AdNetworkAnalyticsSyncQueryResult.EnumAggregationPeriod aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setAggregationPeriod (String aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setBreakdowns (List<AdNetworkAnalyticsSyncQueryResult.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setFilters (List<Object> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setMetrics (List<AdNetworkAnalyticsSyncQueryResult.EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setOrderingColumn (AdNetworkAnalyticsSyncQueryResult.EnumOrderingColumn orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setOrderingColumn (String orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setOrderingType (AdNetworkAnalyticsSyncQueryResult.EnumOrderingType orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setOrderingType (String orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdNetworkAnalytic requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdNetworkAnalyticsResults extends APIRequest<AdNetworkAnalyticsAsyncQueryResult> {

    APINodeList<AdNetworkAnalyticsAsyncQueryResult> lastResponse = null;
    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "query_ids",
    };

    public static final String[] FIELDS = {
      "data",
      "error",
      "omitted_results",
      "query_id",
      "results",
      "status",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> parseResponse(String response, String header) throws APIException {
      return AdNetworkAnalyticsAsyncQueryResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdNetworkAnalyticsAsyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsAsyncQueryResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdNetworkAnalyticsResults.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdNetworkAnalyticsResults(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics_results", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdNetworkAnalyticsResults setQueryIds (List<String> queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults setQueryIds (String queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }

    public APIRequestGetAdNetworkAnalyticsResults requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdNetworkAnalyticsResults requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdNetworkAnalyticsResults requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestErrorField () {
      return this.requestErrorField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestErrorField (boolean value) {
      this.requestField("error", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestOmittedResultsField () {
      return this.requestOmittedResultsField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestOmittedResultsField (boolean value) {
      this.requestField("omitted_results", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestQueryIdField () {
      return this.requestQueryIdField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestQueryIdField (boolean value) {
      this.requestField("query_id", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetAemAttribution extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_ids",
      "fb_content_data",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAemAttribution.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAemAttribution(String nodeId, APIContext context) {
      super(context, nodeId, "/aem_attribution", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAemAttribution setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAemAttribution setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAemAttribution setAdvertiserIds (List<String> advertiserIds) {
      this.setParam("advertiser_ids", advertiserIds);
      return this;
    }
    public APIRequestGetAemAttribution setAdvertiserIds (String advertiserIds) {
      this.setParam("advertiser_ids", advertiserIds);
      return this;
    }

    public APIRequestGetAemAttribution setFbContentData (String fbContentData) {
      this.setParam("fb_content_data", fbContentData);
      return this;
    }

    public APIRequestGetAemAttribution requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAemAttribution requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemAttribution requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAemAttribution requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemAttribution requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAemAttribution requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAemConversionConfigs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAemConversionConfigs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAemConversionConfigs(String nodeId, APIContext context) {
      super(context, nodeId, "/aem_conversion_configs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAemConversionConfigs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAemConversionConfigs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAemConversionConfigs setAdvertiserIds (List<String> advertiserIds) {
      this.setParam("advertiser_ids", advertiserIds);
      return this;
    }
    public APIRequestGetAemConversionConfigs setAdvertiserIds (String advertiserIds) {
      this.setParam("advertiser_ids", advertiserIds);
      return this;
    }

    public APIRequestGetAemConversionConfigs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAemConversionConfigs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemConversionConfigs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAemConversionConfigs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemConversionConfigs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAemConversionConfigs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAemConversionFilter extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
      "fb_content_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAemConversionFilter.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAemConversionFilter(String nodeId, APIContext context) {
      super(context, nodeId, "/aem_conversion_filter", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAemConversionFilter setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAemConversionFilter setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAemConversionFilter setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestGetAemConversionFilter setFbContentIds (String fbContentIds) {
      this.setParam("fb_content_ids", fbContentIds);
      return this;
    }

    public APIRequestGetAemConversionFilter requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAemConversionFilter requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemConversionFilter requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAemConversionFilter requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAemConversionFilter requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAemConversionFilter requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAemConversion extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aem_conversions",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAemConversion.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAemConversion(String nodeId, APIContext context) {
      super(context, nodeId, "/aem_conversions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAemConversion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAemConversion setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAemConversion setAemConversions (List<Map<String, String>> aemConversions) {
      this.setParam("aem_conversions", aemConversions);
      return this;
    }
    public APIRequestCreateAemConversion setAemConversions (String aemConversions) {
      this.setParam("aem_conversions", aemConversions);
      return this;
    }

    public APIRequestCreateAemConversion requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAemConversion requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAemConversion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAemConversion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAemConversion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAemConversion requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAemSkanReadiness extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "is_aem_ready",
      "is_app_aem_install_ready",
      "is_app_aem_ready",
      "is_skan_ready",
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAemSkanReadiness.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAemSkanReadiness(String nodeId, APIContext context) {
      super(context, nodeId, "/aem_skan_readiness", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAemSkanReadiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAemSkanReadiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAemSkanReadiness setAppId (Long appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateAemSkanReadiness setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateAemSkanReadiness setIsAemReady (Boolean isAemReady) {
      this.setParam("is_aem_ready", isAemReady);
      return this;
    }
    public APIRequestCreateAemSkanReadiness setIsAemReady (String isAemReady) {
      this.setParam("is_aem_ready", isAemReady);
      return this;
    }

    public APIRequestCreateAemSkanReadiness setIsAppAemInstallReady (Boolean isAppAemInstallReady) {
      this.setParam("is_app_aem_install_ready", isAppAemInstallReady);
      return this;
    }
    public APIRequestCreateAemSkanReadiness setIsAppAemInstallReady (String isAppAemInstallReady) {
      this.setParam("is_app_aem_install_ready", isAppAemInstallReady);
      return this;
    }

    public APIRequestCreateAemSkanReadiness setIsAppAemReady (Boolean isAppAemReady) {
      this.setParam("is_app_aem_ready", isAppAemReady);
      return this;
    }
    public APIRequestCreateAemSkanReadiness setIsAppAemReady (String isAppAemReady) {
      this.setParam("is_app_aem_ready", isAppAemReady);
      return this;
    }

    public APIRequestCreateAemSkanReadiness setIsSkanReady (Boolean isSkanReady) {
      this.setParam("is_skan_ready", isSkanReady);
      return this;
    }
    public APIRequestCreateAemSkanReadiness setIsSkanReady (String isSkanReady) {
      this.setParam("is_skan_ready", isSkanReady);
      return this;
    }

    public APIRequestCreateAemSkanReadiness setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateAemSkanReadiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAemSkanReadiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAemSkanReadiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAemSkanReadiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAemSkanReadiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAemSkanReadiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAgencies extends APIRequest<Business> {

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
               return APIRequestGetAgencies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAgencies requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetAgencies requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetAgencies requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGetAgencies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAgencies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAgencies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAgencies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAgencies requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetAgencies requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAgencies requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetAgencies requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetAgencies requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAgencies requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetAgencies requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetAgencies requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetAgencies requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAgencies requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAgencies requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetAgencies requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetAgencies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetAgencies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetAgencies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAgencies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAgencies requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAgencies requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetAgencies requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAgencies requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAgencies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAgencies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetAgencies requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetAgencies requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateAggregateRevenue extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ecpms",
      "query_ids",
      "request_id",
      "sync_api",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAggregateRevenue.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAggregateRevenue(String nodeId, APIContext context) {
      super(context, nodeId, "/aggregate_revenue", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAggregateRevenue setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAggregateRevenue setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAggregateRevenue setEcpms (List<String> ecpms) {
      this.setParam("ecpms", ecpms);
      return this;
    }
    public APIRequestCreateAggregateRevenue setEcpms (String ecpms) {
      this.setParam("ecpms", ecpms);
      return this;
    }

    public APIRequestCreateAggregateRevenue setQueryIds (List<String> queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }
    public APIRequestCreateAggregateRevenue setQueryIds (String queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }

    public APIRequestCreateAggregateRevenue setRequestId (String requestId) {
      this.setParam("request_id", requestId);
      return this;
    }

    public APIRequestCreateAggregateRevenue setSyncApi (Boolean syncApi) {
      this.setParam("sync_api", syncApi);
      return this;
    }
    public APIRequestCreateAggregateRevenue setSyncApi (String syncApi) {
      this.setParam("sync_api", syncApi);
      return this;
    }

    public APIRequestCreateAggregateRevenue requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAggregateRevenue requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAggregateRevenue requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAggregateRevenue requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAggregateRevenue requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAggregateRevenue requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAndroidDialogConfigs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAndroidDialogConfigs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAndroidDialogConfigs(String nodeId, APIContext context) {
      super(context, nodeId, "/android_dialog_configs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAndroidDialogConfigs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAndroidDialogConfigs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAndroidDialogConfigs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAndroidDialogConfigs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAndroidDialogConfigs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAndroidDialogConfigs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAndroidDialogConfigs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAndroidDialogConfigs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAppCapiSettings extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAppCapiSettings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAppCapiSettings(String nodeId, APIContext context) {
      super(context, nodeId, "/app_capi_settings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAppCapiSettings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAppCapiSettings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAppCapiSettings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAppCapiSettings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppCapiSettings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAppCapiSettings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppCapiSettings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAppCapiSettings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAppEventTypes extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAppEventTypes.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAppEventTypes(String nodeId, APIContext context) {
      super(context, nodeId, "/app_event_types", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAppEventTypes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAppEventTypes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAppEventTypes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAppEventTypes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppEventTypes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAppEventTypes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppEventTypes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAppEventTypes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAppIndexing extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_version",
      "device_session_id",
      "extra_info",
      "platform",
      "request_type",
      "tree",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAppIndexing.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAppIndexing(String nodeId, APIContext context) {
      super(context, nodeId, "/app_indexing", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAppIndexing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAppIndexing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAppIndexing setAppVersion (String appVersion) {
      this.setParam("app_version", appVersion);
      return this;
    }

    public APIRequestCreateAppIndexing setDeviceSessionId (String deviceSessionId) {
      this.setParam("device_session_id", deviceSessionId);
      return this;
    }

    public APIRequestCreateAppIndexing setExtraInfo (String extraInfo) {
      this.setParam("extra_info", extraInfo);
      return this;
    }

    public APIRequestCreateAppIndexing setPlatform (Application.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestCreateAppIndexing setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestCreateAppIndexing setRequestType (Application.EnumRequestType requestType) {
      this.setParam("request_type", requestType);
      return this;
    }
    public APIRequestCreateAppIndexing setRequestType (String requestType) {
      this.setParam("request_type", requestType);
      return this;
    }

    public APIRequestCreateAppIndexing setTree (Map<String, String> tree) {
      this.setParam("tree", tree);
      return this;
    }
    public APIRequestCreateAppIndexing setTree (String tree) {
      this.setParam("tree", tree);
      return this;
    }

    public APIRequestCreateAppIndexing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAppIndexing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppIndexing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAppIndexing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppIndexing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAppIndexing requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAppIndexingSession extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "device_session_id",
      "extinfo",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAppIndexingSession.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAppIndexingSession(String nodeId, APIContext context) {
      super(context, nodeId, "/app_indexing_session", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAppIndexingSession setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAppIndexingSession setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAppIndexingSession setDeviceSessionId (String deviceSessionId) {
      this.setParam("device_session_id", deviceSessionId);
      return this;
    }

    public APIRequestCreateAppIndexingSession setExtinfo (String extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }

    public APIRequestCreateAppIndexingSession requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAppIndexingSession requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppIndexingSession requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAppIndexingSession requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppIndexingSession requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAppIndexingSession requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAppInstalledGroups extends APIRequest<Group> {

    APINodeList<Group> lastResponse = null;
    @Override
    public APINodeList<Group> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "group_id",
    };

    public static final String[] FIELDS = {
      "archived",
      "cover",
      "created_time",
      "description",
      "email",
      "icon",
      "id",
      "install",
      "link",
      "member_count",
      "member_request_count",
      "name",
      "parent",
      "permissions",
      "privacy",
      "purpose",
      "subdomain",
      "updated_time",
      "venue",
    };

    @Override
    public APINodeList<Group> parseResponse(String response, String header) throws APIException {
      return Group.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Group> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Group> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Group>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Group>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Group>>() {
           public APINodeList<Group> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAppInstalledGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAppInstalledGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/app_installed_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAppInstalledGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAppInstalledGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAppInstalledGroups setGroupId (String groupId) {
      this.setParam("group_id", groupId);
      return this;
    }

    public APIRequestGetAppInstalledGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAppInstalledGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppInstalledGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAppInstalledGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppInstalledGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAppInstalledGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAppInstalledGroups requestArchivedField () {
      return this.requestArchivedField(true);
    }
    public APIRequestGetAppInstalledGroups requestArchivedField (boolean value) {
      this.requestField("archived", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAppInstalledGroups requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAppInstalledGroups requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAppInstalledGroups requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetAppInstalledGroups requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetAppInstalledGroups requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAppInstalledGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestInstallField () {
      return this.requestInstallField(true);
    }
    public APIRequestGetAppInstalledGroups requestInstallField (boolean value) {
      this.requestField("install", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAppInstalledGroups requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestMemberCountField () {
      return this.requestMemberCountField(true);
    }
    public APIRequestGetAppInstalledGroups requestMemberCountField (boolean value) {
      this.requestField("member_count", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestMemberRequestCountField () {
      return this.requestMemberRequestCountField(true);
    }
    public APIRequestGetAppInstalledGroups requestMemberRequestCountField (boolean value) {
      this.requestField("member_request_count", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAppInstalledGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGetAppInstalledGroups requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGetAppInstalledGroups requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetAppInstalledGroups requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestPurposeField () {
      return this.requestPurposeField(true);
    }
    public APIRequestGetAppInstalledGroups requestPurposeField (boolean value) {
      this.requestField("purpose", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestSubdomainField () {
      return this.requestSubdomainField(true);
    }
    public APIRequestGetAppInstalledGroups requestSubdomainField (boolean value) {
      this.requestField("subdomain", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAppInstalledGroups requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAppInstalledGroups requestVenueField () {
      return this.requestVenueField(true);
    }
    public APIRequestGetAppInstalledGroups requestVenueField (boolean value) {
      this.requestField("venue", value);
      return this;
    }
  }

  public static class APIRequestCreateAppPushDeviceToken extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "device_id",
      "device_token",
      "platform",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAppPushDeviceToken.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAppPushDeviceToken(String nodeId, APIContext context) {
      super(context, nodeId, "/app_push_device_token", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAppPushDeviceToken setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAppPushDeviceToken setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAppPushDeviceToken setDeviceId (String deviceId) {
      this.setParam("device_id", deviceId);
      return this;
    }

    public APIRequestCreateAppPushDeviceToken setDeviceToken (String deviceToken) {
      this.setParam("device_token", deviceToken);
      return this;
    }

    public APIRequestCreateAppPushDeviceToken setPlatform (Application.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestCreateAppPushDeviceToken setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestCreateAppPushDeviceToken requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAppPushDeviceToken requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppPushDeviceToken requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAppPushDeviceToken requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppPushDeviceToken requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAppPushDeviceToken requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAppAssets extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAppAssets.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAppAssets(String nodeId, APIContext context) {
      super(context, nodeId, "/appassets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAppAssets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAppAssets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAppAssets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAppAssets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppAssets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAppAssets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppAssets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAppAssets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAsset extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "asset",
      "comment",
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAsset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAsset(String nodeId, APIContext context) {
      super(context, nodeId, "/assets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAsset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAsset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAsset setAsset (File asset) {
      this.setParam("asset", asset);
      return this;
    }
    public APIRequestCreateAsset setAsset (String asset) {
      this.setParam("asset", asset);
      return this;
    }

    public APIRequestCreateAsset setComment (String comment) {
      this.setParam("comment", comment);
      return this;
    }

    public APIRequestCreateAsset setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateAsset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAsset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAsset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAsset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAuthorizedAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_status",
      "ad_account_promotable_objects",
      "age",
      "agency_client_declaration",
      "all_capabilities",
      "amount_spent",
      "attribution_spec",
      "balance",
      "brand_safety_content_filter_levels",
      "business",
      "business_city",
      "business_country_code",
      "business_name",
      "business_state",
      "business_street",
      "business_street2",
      "business_zip",
      "capabilities",
      "created_time",
      "currency",
      "custom_audience_info",
      "default_dsa_beneficiary",
      "default_dsa_payor",
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
      "existing_customers",
      "extended_credit_invoice_group",
      "failed_delivery_checks",
      "fb_entity",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "has_page_authorized_adaccount",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
      "is_direct_deals_enabled",
      "is_in_3ds_authorization_enabled_market",
      "is_notifications_enabled",
      "is_personal",
      "is_prepay_account",
      "is_tax_id_required",
      "liable_address",
      "line_numbers",
      "media_agency",
      "min_campaign_group_spend_cap",
      "min_daily_budget",
      "name",
      "offsite_pixels_tos_accepted",
      "owner",
      "owner_business",
      "partner",
      "rf_spec",
      "send_bill_to_address",
      "show_checkout_experience",
      "sold_to_address",
      "spend_cap",
      "tax_id",
      "tax_id_status",
      "tax_id_type",
      "timezone_id",
      "timezone_name",
      "timezone_offset_hours_utc",
      "tos_accepted",
      "user_access_expire_time",
      "user_tasks",
      "user_tos_accepted",
      "viewable_business",
    };

    @Override
    public APINodeList<AdAccount> parseResponse(String response, String header) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdAccount>>() {
           public APINodeList<AdAccount> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAuthorizedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAuthorizedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/authorized_adaccounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAuthorizedAdAccounts setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetAuthorizedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAuthorizedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAuthorizedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAllCapabilitiesField () {
      return this.requestAllCapabilitiesField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAllCapabilitiesField (boolean value) {
      this.requestField("all_capabilities", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBrandSafetyContentFilterLevelsField () {
      return this.requestBrandSafetyContentFilterLevelsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBrandSafetyContentFilterLevelsField (boolean value) {
      this.requestField("brand_safety_content_filter_levels", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCustomAudienceInfoField () {
      return this.requestCustomAudienceInfoField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCustomAudienceInfoField (boolean value) {
      this.requestField("custom_audience_info", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaBeneficiaryField () {
      return this.requestDefaultDsaBeneficiaryField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaBeneficiaryField (boolean value) {
      this.requestField("default_dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaPayorField () {
      return this.requestDefaultDsaPayorField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaPayorField (boolean value) {
      this.requestField("default_dsa_payor", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestExistingCustomersField () {
      return this.requestExistingCustomersField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestExistingCustomersField (boolean value) {
      this.requestField("existing_customers", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestViewableBusinessField () {
      return this.requestViewableBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestViewableBusinessField (boolean value) {
      this.requestField("viewable_business", value);
      return this;
    }
  }

  public static class APIRequestGetButtonAutoDetectionDeviceSelection extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "device_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetButtonAutoDetectionDeviceSelection.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetButtonAutoDetectionDeviceSelection(String nodeId, APIContext context) {
      super(context, nodeId, "/button_auto_detection_device_selection", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetButtonAutoDetectionDeviceSelection setDeviceId (String deviceId) {
      this.setParam("device_id", deviceId);
      return this;
    }

    public APIRequestGetButtonAutoDetectionDeviceSelection requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetButtonAutoDetectionDeviceSelection requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetButtonAutoDetectionDeviceSelection requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCloudbridgeSettings extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCloudbridgeSettings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCloudbridgeSettings(String nodeId, APIContext context) {
      super(context, nodeId, "/cloudbridge_settings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCloudbridgeSettings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCloudbridgeSettings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCloudbridgeSettings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCloudbridgeSettings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCloudbridgeSettings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCloudbridgeSettings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCloudbridgeSettings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCloudbridgeSettings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateCodelessEventMapping extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "mappings",
      "mutation_method",
      "platform",
      "post_method",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCodelessEventMapping.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCodelessEventMapping(String nodeId, APIContext context) {
      super(context, nodeId, "/codeless_event_mappings", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCodelessEventMapping setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventMapping setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCodelessEventMapping setMappings (List<Map<String, String>> mappings) {
      this.setParam("mappings", mappings);
      return this;
    }
    public APIRequestCreateCodelessEventMapping setMappings (String mappings) {
      this.setParam("mappings", mappings);
      return this;
    }

    public APIRequestCreateCodelessEventMapping setMutationMethod (Application.EnumMutationMethod mutationMethod) {
      this.setParam("mutation_method", mutationMethod);
      return this;
    }
    public APIRequestCreateCodelessEventMapping setMutationMethod (String mutationMethod) {
      this.setParam("mutation_method", mutationMethod);
      return this;
    }

    public APIRequestCreateCodelessEventMapping setPlatform (Application.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestCreateCodelessEventMapping setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestCreateCodelessEventMapping setPostMethod (Application.EnumPostMethod postMethod) {
      this.setParam("post_method", postMethod);
      return this;
    }
    public APIRequestCreateCodelessEventMapping setPostMethod (String postMethod) {
      this.setParam("post_method", postMethod);
      return this;
    }

    public APIRequestCreateCodelessEventMapping requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCodelessEventMapping requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventMapping requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCodelessEventMapping requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventMapping requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventMapping requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDaChecks extends APIRequest<DACheck> {

    APINodeList<DACheck> lastResponse = null;
    @Override
    public APINodeList<DACheck> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "checks",
      "connection_method",
    };

    public static final String[] FIELDS = {
      "action_uri",
      "description",
      "key",
      "result",
      "title",
      "user_message",
    };

    @Override
    public APINodeList<DACheck> parseResponse(String response, String header) throws APIException {
      return DACheck.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DACheck> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DACheck> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DACheck>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DACheck>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DACheck>>() {
           public APINodeList<DACheck> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDaChecks.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDaChecks(String nodeId, APIContext context) {
      super(context, nodeId, "/da_checks", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDaChecks setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDaChecks setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDaChecks setChecks (List<String> checks) {
      this.setParam("checks", checks);
      return this;
    }
    public APIRequestGetDaChecks setChecks (String checks) {
      this.setParam("checks", checks);
      return this;
    }

    public APIRequestGetDaChecks setConnectionMethod (DACheck.EnumConnectionMethod connectionMethod) {
      this.setParam("connection_method", connectionMethod);
      return this;
    }
    public APIRequestGetDaChecks setConnectionMethod (String connectionMethod) {
      this.setParam("connection_method", connectionMethod);
      return this;
    }

    public APIRequestGetDaChecks requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDaChecks requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDaChecks requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDaChecks requestActionUriField () {
      return this.requestActionUriField(true);
    }
    public APIRequestGetDaChecks requestActionUriField (boolean value) {
      this.requestField("action_uri", value);
      return this;
    }
    public APIRequestGetDaChecks requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDaChecks requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDaChecks requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGetDaChecks requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGetDaChecks requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetDaChecks requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGetDaChecks requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetDaChecks requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetDaChecks requestUserMessageField () {
      return this.requestUserMessageField(true);
    }
    public APIRequestGetDaChecks requestUserMessageField (boolean value) {
      this.requestField("user_message", value);
      return this;
    }
  }

  public static class APIRequestCreateDomainReport extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking_domains",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateDomainReport.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDomainReport(String nodeId, APIContext context) {
      super(context, nodeId, "/domain_reports", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDomainReport setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDomainReport setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDomainReport setTrackingDomains (List<String> trackingDomains) {
      this.setParam("tracking_domains", trackingDomains);
      return this;
    }
    public APIRequestCreateDomainReport setTrackingDomains (String trackingDomains) {
      this.setParam("tracking_domains", trackingDomains);
      return this;
    }

    public APIRequestCreateDomainReport requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDomainReport requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDomainReport requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDomainReport requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDomainReport requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDomainReport requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetIapPurchases extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "order_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetIapPurchases.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetIapPurchases(String nodeId, APIContext context) {
      super(context, nodeId, "/iap_purchases", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetIapPurchases setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetIapPurchases setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetIapPurchases setOrderId (String orderId) {
      this.setParam("order_id", orderId);
      return this;
    }

    public APIRequestGetIapPurchases requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetIapPurchases requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetIapPurchases requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetIapPurchases requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetIapPurchases requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetIapPurchases requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetIosDialogConfigs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetIosDialogConfigs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetIosDialogConfigs(String nodeId, APIContext context) {
      super(context, nodeId, "/ios_dialog_configs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetIosDialogConfigs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetIosDialogConfigs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetIosDialogConfigs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetIosDialogConfigs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetIosDialogConfigs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetIosDialogConfigs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetIosDialogConfigs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetIosDialogConfigs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLinkedDataset extends APIRequest<AdsDataset> {

    APINodeList<AdsDataset> lastResponse = null;
    @Override
    public APINodeList<AdsDataset> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "collection_rate",
      "config",
      "creation_time",
      "creator",
      "dataset_id",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "enable_automatic_events",
      "enable_automatic_matching",
      "enable_real_time_event_log",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_party_cookie_status",
      "has_bapi_domains",
      "has_catalog_microdata_activity",
      "has_ofa_redacted_keys",
      "has_sent_pii",
      "id",
      "is_consolidated_container",
      "is_created_by_business",
      "is_crm",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_eligible_for_value_optimization",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_fired_time",
      "last_upload_app",
      "last_upload_app_changed_time",
      "last_upload_time",
      "late_upload_reminder_eligibility",
      "match_rate_approx",
      "matched_entries",
      "name",
      "no_ads_tracked_for_weekly_uploaded_events_reminder_eligibility",
      "num_active_ad_set_tracked",
      "num_recent_offline_conversions_uploaded",
      "num_uploads",
      "owner_ad_account",
      "owner_business",
      "percentage_of_late_uploads_in_external_suboptimal_window",
      "permissions",
      "server_last_fired_time",
      "show_automatic_events",
      "upload_rate",
      "upload_reminder_eligibility",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<AdsDataset> parseResponse(String response, String header) throws APIException {
      return AdsDataset.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsDataset> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsDataset> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsDataset>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsDataset>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsDataset>>() {
           public APINodeList<AdsDataset> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLinkedDataset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLinkedDataset(String nodeId, APIContext context) {
      super(context, nodeId, "/linked_dataset", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLinkedDataset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLinkedDataset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLinkedDataset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLinkedDataset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedDataset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLinkedDataset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedDataset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLinkedDataset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLinkedDataset requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetLinkedDataset requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestCollectionRateField () {
      return this.requestCollectionRateField(true);
    }
    public APIRequestGetLinkedDataset requestCollectionRateField (boolean value) {
      this.requestField("collection_rate", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetLinkedDataset requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetLinkedDataset requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetLinkedDataset requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestDatasetIdField () {
      return this.requestDatasetIdField(true);
    }
    public APIRequestGetLinkedDataset requestDatasetIdField (boolean value) {
      this.requestField("dataset_id", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLinkedDataset requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetLinkedDataset requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetLinkedDataset requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEnableAutomaticEventsField () {
      return this.requestEnableAutomaticEventsField(true);
    }
    public APIRequestGetLinkedDataset requestEnableAutomaticEventsField (boolean value) {
      this.requestField("enable_automatic_events", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetLinkedDataset requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEnableRealTimeEventLogField () {
      return this.requestEnableRealTimeEventLogField(true);
    }
    public APIRequestGetLinkedDataset requestEnableRealTimeEventLogField (boolean value) {
      this.requestField("enable_real_time_event_log", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetLinkedDataset requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetLinkedDataset requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetLinkedDataset requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetLinkedDataset requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestHasBapiDomainsField () {
      return this.requestHasBapiDomainsField(true);
    }
    public APIRequestGetLinkedDataset requestHasBapiDomainsField (boolean value) {
      this.requestField("has_bapi_domains", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestHasCatalogMicrodataActivityField () {
      return this.requestHasCatalogMicrodataActivityField(true);
    }
    public APIRequestGetLinkedDataset requestHasCatalogMicrodataActivityField (boolean value) {
      this.requestField("has_catalog_microdata_activity", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestHasOfaRedactedKeysField () {
      return this.requestHasOfaRedactedKeysField(true);
    }
    public APIRequestGetLinkedDataset requestHasOfaRedactedKeysField (boolean value) {
      this.requestField("has_ofa_redacted_keys", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestHasSentPiiField () {
      return this.requestHasSentPiiField(true);
    }
    public APIRequestGetLinkedDataset requestHasSentPiiField (boolean value) {
      this.requestField("has_sent_pii", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLinkedDataset requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetLinkedDataset requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetLinkedDataset requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetLinkedDataset requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGetLinkedDataset requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGetLinkedDataset requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsEligibleForValueOptimizationField () {
      return this.requestIsEligibleForValueOptimizationField(true);
    }
    public APIRequestGetLinkedDataset requestIsEligibleForValueOptimizationField (boolean value) {
      this.requestField("is_eligible_for_value_optimization", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetLinkedDataset requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetLinkedDataset requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetLinkedDataset requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetLinkedDataset requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetLinkedDataset requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetLinkedDataset requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestLastUploadTimeField () {
      return this.requestLastUploadTimeField(true);
    }
    public APIRequestGetLinkedDataset requestLastUploadTimeField (boolean value) {
      this.requestField("last_upload_time", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestLateUploadReminderEligibilityField () {
      return this.requestLateUploadReminderEligibilityField(true);
    }
    public APIRequestGetLinkedDataset requestLateUploadReminderEligibilityField (boolean value) {
      this.requestField("late_upload_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetLinkedDataset requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetLinkedDataset requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLinkedDataset requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField () {
      return this.requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField(true);
    }
    public APIRequestGetLinkedDataset requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField (boolean value) {
      this.requestField("no_ads_tracked_for_weekly_uploaded_events_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestNumActiveAdSetTrackedField () {
      return this.requestNumActiveAdSetTrackedField(true);
    }
    public APIRequestGetLinkedDataset requestNumActiveAdSetTrackedField (boolean value) {
      this.requestField("num_active_ad_set_tracked", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestNumRecentOfflineConversionsUploadedField () {
      return this.requestNumRecentOfflineConversionsUploadedField(true);
    }
    public APIRequestGetLinkedDataset requestNumRecentOfflineConversionsUploadedField (boolean value) {
      this.requestField("num_recent_offline_conversions_uploaded", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestNumUploadsField () {
      return this.requestNumUploadsField(true);
    }
    public APIRequestGetLinkedDataset requestNumUploadsField (boolean value) {
      this.requestField("num_uploads", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetLinkedDataset requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetLinkedDataset requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestPercentageOfLateUploadsInExternalSuboptimalWindowField () {
      return this.requestPercentageOfLateUploadsInExternalSuboptimalWindowField(true);
    }
    public APIRequestGetLinkedDataset requestPercentageOfLateUploadsInExternalSuboptimalWindowField (boolean value) {
      this.requestField("percentage_of_late_uploads_in_external_suboptimal_window", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGetLinkedDataset requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestServerLastFiredTimeField () {
      return this.requestServerLastFiredTimeField(true);
    }
    public APIRequestGetLinkedDataset requestServerLastFiredTimeField (boolean value) {
      this.requestField("server_last_fired_time", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestShowAutomaticEventsField () {
      return this.requestShowAutomaticEventsField(true);
    }
    public APIRequestGetLinkedDataset requestShowAutomaticEventsField (boolean value) {
      this.requestField("show_automatic_events", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestUploadRateField () {
      return this.requestUploadRateField(true);
    }
    public APIRequestGetLinkedDataset requestUploadRateField (boolean value) {
      this.requestField("upload_rate", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestUploadReminderEligibilityField () {
      return this.requestUploadReminderEligibilityField(true);
    }
    public APIRequestGetLinkedDataset requestUploadReminderEligibilityField (boolean value) {
      this.requestField("upload_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetLinkedDataset requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetLinkedDataset requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetLinkedDataset requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestCreateMmpAuditing extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_id",
      "attribution",
      "attribution_model",
      "auditing_token",
      "click_attr_window",
      "custom_events",
      "decline_reason",
      "engagement_type",
      "event",
      "event_reported_time",
      "fb_ad_id",
      "fb_click_time",
      "fb_view_time",
      "is_fb",
      "used_install_referrer",
      "view_attr_window",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMmpAuditing.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMmpAuditing(String nodeId, APIContext context) {
      super(context, nodeId, "/mmp_auditing", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMmpAuditing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMmpAuditing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMmpAuditing setAdvertiserId (String advertiserId) {
      this.setParam("advertiser_id", advertiserId);
      return this;
    }

    public APIRequestCreateMmpAuditing setAttribution (String attribution) {
      this.setParam("attribution", attribution);
      return this;
    }

    public APIRequestCreateMmpAuditing setAttributionModel (String attributionModel) {
      this.setParam("attribution_model", attributionModel);
      return this;
    }

    public APIRequestCreateMmpAuditing setAuditingToken (String auditingToken) {
      this.setParam("auditing_token", auditingToken);
      return this;
    }

    public APIRequestCreateMmpAuditing setClickAttrWindow (Long clickAttrWindow) {
      this.setParam("click_attr_window", clickAttrWindow);
      return this;
    }
    public APIRequestCreateMmpAuditing setClickAttrWindow (String clickAttrWindow) {
      this.setParam("click_attr_window", clickAttrWindow);
      return this;
    }

    public APIRequestCreateMmpAuditing setCustomEvents (List<Object> customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }
    public APIRequestCreateMmpAuditing setCustomEvents (String customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }

    public APIRequestCreateMmpAuditing setDeclineReason (String declineReason) {
      this.setParam("decline_reason", declineReason);
      return this;
    }

    public APIRequestCreateMmpAuditing setEngagementType (String engagementType) {
      this.setParam("engagement_type", engagementType);
      return this;
    }

    public APIRequestCreateMmpAuditing setEvent (String event) {
      this.setParam("event", event);
      return this;
    }

    public APIRequestCreateMmpAuditing setEventReportedTime (Long eventReportedTime) {
      this.setParam("event_reported_time", eventReportedTime);
      return this;
    }
    public APIRequestCreateMmpAuditing setEventReportedTime (String eventReportedTime) {
      this.setParam("event_reported_time", eventReportedTime);
      return this;
    }

    public APIRequestCreateMmpAuditing setFbAdId (Long fbAdId) {
      this.setParam("fb_ad_id", fbAdId);
      return this;
    }
    public APIRequestCreateMmpAuditing setFbAdId (String fbAdId) {
      this.setParam("fb_ad_id", fbAdId);
      return this;
    }

    public APIRequestCreateMmpAuditing setFbClickTime (Long fbClickTime) {
      this.setParam("fb_click_time", fbClickTime);
      return this;
    }
    public APIRequestCreateMmpAuditing setFbClickTime (String fbClickTime) {
      this.setParam("fb_click_time", fbClickTime);
      return this;
    }

    public APIRequestCreateMmpAuditing setFbViewTime (Long fbViewTime) {
      this.setParam("fb_view_time", fbViewTime);
      return this;
    }
    public APIRequestCreateMmpAuditing setFbViewTime (String fbViewTime) {
      this.setParam("fb_view_time", fbViewTime);
      return this;
    }

    public APIRequestCreateMmpAuditing setIsFb (Boolean isFb) {
      this.setParam("is_fb", isFb);
      return this;
    }
    public APIRequestCreateMmpAuditing setIsFb (String isFb) {
      this.setParam("is_fb", isFb);
      return this;
    }

    public APIRequestCreateMmpAuditing setUsedInstallReferrer (Boolean usedInstallReferrer) {
      this.setParam("used_install_referrer", usedInstallReferrer);
      return this;
    }
    public APIRequestCreateMmpAuditing setUsedInstallReferrer (String usedInstallReferrer) {
      this.setParam("used_install_referrer", usedInstallReferrer);
      return this;
    }

    public APIRequestCreateMmpAuditing setViewAttrWindow (Long viewAttrWindow) {
      this.setParam("view_attr_window", viewAttrWindow);
      return this;
    }
    public APIRequestCreateMmpAuditing setViewAttrWindow (String viewAttrWindow) {
      this.setParam("view_attr_window", viewAttrWindow);
      return this;
    }

    public APIRequestCreateMmpAuditing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMmpAuditing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMmpAuditing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMmpAuditing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMmpAuditing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMmpAuditing requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMobileSdkGk extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "device_id",
      "extinfo",
      "os_version",
      "platform",
      "sdk_version",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMobileSdkGk.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMobileSdkGk(String nodeId, APIContext context) {
      super(context, nodeId, "/mobile_sdk_gk", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMobileSdkGk setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMobileSdkGk setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMobileSdkGk setDeviceId (String deviceId) {
      this.setParam("device_id", deviceId);
      return this;
    }

    public APIRequestGetMobileSdkGk setExtinfo (Object extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }
    public APIRequestGetMobileSdkGk setExtinfo (String extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }

    public APIRequestGetMobileSdkGk setOsVersion (String osVersion) {
      this.setParam("os_version", osVersion);
      return this;
    }

    public APIRequestGetMobileSdkGk setPlatform (EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestGetMobileSdkGk setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestGetMobileSdkGk setSdkVersion (String sdkVersion) {
      this.setParam("sdk_version", sdkVersion);
      return this;
    }

    public APIRequestGetMobileSdkGk requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMobileSdkGk requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMobileSdkGk requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMobileSdkGk requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMobileSdkGk requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMobileSdkGk requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMonetizedDigitalStoreObjects extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMonetizedDigitalStoreObjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMonetizedDigitalStoreObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/monetized_digital_store_objects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMonetizedDigitalStoreObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMonetizedDigitalStoreObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMonetizedDigitalStoreObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMonetizedDigitalStoreObject extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "content_id",
      "store",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMonetizedDigitalStoreObject.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMonetizedDigitalStoreObject(String nodeId, APIContext context) {
      super(context, nodeId, "/monetized_digital_store_objects", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMonetizedDigitalStoreObject setContentId (String contentId) {
      this.setParam("content_id", contentId);
      return this;
    }

    public APIRequestCreateMonetizedDigitalStoreObject setStore (String store) {
      this.setParam("store", store);
      return this;
    }

    public APIRequestCreateMonetizedDigitalStoreObject requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMonetizedDigitalStoreObject requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMonetizedDigitalStoreObject requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetObjectTypes extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetObjectTypes.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetObjectTypes(String nodeId, APIContext context) {
      super(context, nodeId, "/object_types", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetObjectTypes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetObjectTypes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetObjectTypes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetObjectTypes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjectTypes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetObjectTypes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjectTypes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetObjectTypes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetObjects extends APIRequest<NullNode> {

    APINodeList<NullNode> lastResponse = null;
    @Override
    public APINodeList<NullNode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<NullNode> parseResponse(String response, String header) throws APIException {
      return NullNode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NullNode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NullNode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NullNode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NullNode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NullNode>>() {
           public APINodeList<NullNode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetObjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/objects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateOccludesPopup extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "flash",
      "unity",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOccludesPopup.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOccludesPopup(String nodeId, APIContext context) {
      super(context, nodeId, "/occludespopups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOccludesPopup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOccludesPopup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOccludesPopup setFlash (Boolean flash) {
      this.setParam("flash", flash);
      return this;
    }
    public APIRequestCreateOccludesPopup setFlash (String flash) {
      this.setParam("flash", flash);
      return this;
    }

    public APIRequestCreateOccludesPopup setUnity (Boolean unity) {
      this.setParam("unity", unity);
      return this;
    }
    public APIRequestCreateOccludesPopup setUnity (String unity) {
      this.setParam("unity", unity);
      return this;
    }

    public APIRequestCreateOccludesPopup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOccludesPopup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOccludesPopup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOccludesPopup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOccludesPopup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOccludesPopup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePageActivity extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_tracking_enabled",
      "application_tracking_enabled",
      "custom_events",
      "logging_source",
      "logging_target",
      "page_id",
      "page_scoped_user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePageActivity.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePageActivity(String nodeId, APIContext context) {
      super(context, nodeId, "/page_activities", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePageActivity setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePageActivity setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePageActivity setAdvertiserTrackingEnabled (Boolean advertiserTrackingEnabled) {
      this.setParam("advertiser_tracking_enabled", advertiserTrackingEnabled);
      return this;
    }
    public APIRequestCreatePageActivity setAdvertiserTrackingEnabled (String advertiserTrackingEnabled) {
      this.setParam("advertiser_tracking_enabled", advertiserTrackingEnabled);
      return this;
    }

    public APIRequestCreatePageActivity setApplicationTrackingEnabled (Boolean applicationTrackingEnabled) {
      this.setParam("application_tracking_enabled", applicationTrackingEnabled);
      return this;
    }
    public APIRequestCreatePageActivity setApplicationTrackingEnabled (String applicationTrackingEnabled) {
      this.setParam("application_tracking_enabled", applicationTrackingEnabled);
      return this;
    }

    public APIRequestCreatePageActivity setCustomEvents (List<Object> customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }
    public APIRequestCreatePageActivity setCustomEvents (String customEvents) {
      this.setParam("custom_events", customEvents);
      return this;
    }

    public APIRequestCreatePageActivity setLoggingSource (Application.EnumLoggingSource loggingSource) {
      this.setParam("logging_source", loggingSource);
      return this;
    }
    public APIRequestCreatePageActivity setLoggingSource (String loggingSource) {
      this.setParam("logging_source", loggingSource);
      return this;
    }

    public APIRequestCreatePageActivity setLoggingTarget (Application.EnumLoggingTarget loggingTarget) {
      this.setParam("logging_target", loggingTarget);
      return this;
    }
    public APIRequestCreatePageActivity setLoggingTarget (String loggingTarget) {
      this.setParam("logging_target", loggingTarget);
      return this;
    }

    public APIRequestCreatePageActivity setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreatePageActivity setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreatePageActivity setPageScopedUserId (Long pageScopedUserId) {
      this.setParam("page_scoped_user_id", pageScopedUserId);
      return this;
    }
    public APIRequestCreatePageActivity setPageScopedUserId (String pageScopedUserId) {
      this.setParam("page_scoped_user_id", pageScopedUserId);
      return this;
    }

    public APIRequestCreatePageActivity requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePageActivity requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePageActivity requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePageActivity requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePageActivity requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePageActivity requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePaymentCurrency extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "currency_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePaymentCurrency.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePaymentCurrency(String nodeId, APIContext context) {
      super(context, nodeId, "/payment_currencies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePaymentCurrency setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePaymentCurrency setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePaymentCurrency setCurrencyUrl (String currencyUrl) {
      this.setParam("currency_url", currencyUrl);
      return this;
    }

    public APIRequestCreatePaymentCurrency requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePaymentCurrency requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePaymentCurrency requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePaymentCurrency requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePaymentCurrency requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePaymentCurrency requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPermissions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "android_key_hash",
      "ios_bundle_id",
      "permission",
      "proxied_app_id",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPermissions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPermissions setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestGetPermissions setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestGetPermissions setPermission (List<Permission> permission) {
      this.setParam("permission", permission);
      return this;
    }
    public APIRequestGetPermissions setPermission (String permission) {
      this.setParam("permission", permission);
      return this;
    }

    public APIRequestGetPermissions setProxiedAppId (Long proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }
    public APIRequestGetPermissions setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestGetPermissions setStatus (List<EnumStatus> status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetPermissions setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProducts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "product_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProducts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProducts(String nodeId, APIContext context) {
      super(context, nodeId, "/products", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProducts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProducts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProducts setProductIds (List<String> productIds) {
      this.setParam("product_ids", productIds);
      return this;
    }
    public APIRequestGetProducts setProductIds (String productIds) {
      this.setParam("product_ids", productIds);
      return this;
    }

    public APIRequestGetProducts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProducts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPurchases extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPurchases.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPurchases(String nodeId, APIContext context) {
      super(context, nodeId, "/purchases", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPurchases setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPurchases setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPurchases requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPurchases requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPurchases requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPurchases requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPurchases requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPurchases requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRoles extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRoles.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRoles(String nodeId, APIContext context) {
      super(context, nodeId, "/roles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRoles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRoles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRoles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetServerDomainInfos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetServerDomainInfos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetServerDomainInfos(String nodeId, APIContext context) {
      super(context, nodeId, "/server_domain_infos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetServerDomainInfos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetServerDomainInfos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetServerDomainInfos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetServerDomainInfos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetServerDomainInfos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetServerDomainInfos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetServerDomainInfos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetServerDomainInfos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSubscribedDomains extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSubscribedDomains.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSubscribedDomains(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_domains", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSubscribedDomains setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomains setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSubscribedDomains requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSubscribedDomains requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomains requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSubscribedDomains requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomains requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomains requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscribedDomain extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "subscribe",
      "unsubscribe",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSubscribedDomain.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSubscribedDomain(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_domains", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscribedDomain setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomain setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscribedDomain setSubscribe (List<String> subscribe) {
      this.setParam("subscribe", subscribe);
      return this;
    }
    public APIRequestCreateSubscribedDomain setSubscribe (String subscribe) {
      this.setParam("subscribe", subscribe);
      return this;
    }

    public APIRequestCreateSubscribedDomain setUnsubscribe (List<String> unsubscribe) {
      this.setParam("unsubscribe", unsubscribe);
      return this;
    }
    public APIRequestCreateSubscribedDomain setUnsubscribe (String unsubscribe) {
      this.setParam("unsubscribe", unsubscribe);
      return this;
    }

    public APIRequestCreateSubscribedDomain requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscribedDomain requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomain requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscribedDomain requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomain requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomain requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSubscribedDomainsPhishing extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSubscribedDomainsPhishing.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSubscribedDomainsPhishing(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_domains_phishing", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSubscribedDomainsPhishing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSubscribedDomainsPhishing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSubscribedDomainsPhishing requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscribedDomainsPhishing extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "subscribe",
      "unsubscribe",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSubscribedDomainsPhishing.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSubscribedDomainsPhishing(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_domains_phishing", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscribedDomainsPhishing setSubscribe (List<String> subscribe) {
      this.setParam("subscribe", subscribe);
      return this;
    }
    public APIRequestCreateSubscribedDomainsPhishing setSubscribe (String subscribe) {
      this.setParam("subscribe", subscribe);
      return this;
    }

    public APIRequestCreateSubscribedDomainsPhishing setUnsubscribe (List<String> unsubscribe) {
      this.setParam("unsubscribe", unsubscribe);
      return this;
    }
    public APIRequestCreateSubscribedDomainsPhishing setUnsubscribe (String unsubscribe) {
      this.setParam("unsubscribe", unsubscribe);
      return this;
    }

    public APIRequestCreateSubscribedDomainsPhishing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscribedDomainsPhishing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedDomainsPhishing requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteSubscriptions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "fields",
      "object",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestDeleteSubscriptions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteSubscriptions(String nodeId, APIContext context) {
      super(context, nodeId, "/subscriptions", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteSubscriptions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteSubscriptions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteSubscriptions setFields (List<String> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestDeleteSubscriptions setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestDeleteSubscriptions setObject (String object) {
      this.setParam("object", object);
      return this;
    }

    public APIRequestDeleteSubscriptions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteSubscriptions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscriptions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteSubscriptions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscriptions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteSubscriptions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscription extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "callback_url",
      "fields",
      "include_values",
      "object",
      "verify_token",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSubscription.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSubscription(String nodeId, APIContext context) {
      super(context, nodeId, "/subscriptions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscription setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscription setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscription setCallbackUrl (String callbackUrl) {
      this.setParam("callback_url", callbackUrl);
      return this;
    }

    public APIRequestCreateSubscription setFields (List<String> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestCreateSubscription setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestCreateSubscription setIncludeValues (Boolean includeValues) {
      this.setParam("include_values", includeValues);
      return this;
    }
    public APIRequestCreateSubscription setIncludeValues (String includeValues) {
      this.setParam("include_values", includeValues);
      return this;
    }

    public APIRequestCreateSubscription setObject (String object) {
      this.setParam("object", object);
      return this;
    }

    public APIRequestCreateSubscription setVerifyToken (String verifyToken) {
      this.setParam("verify_token", verifyToken);
      return this;
    }

    public APIRequestCreateSubscription requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscription requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscription requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscription requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscription requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscription requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUpload extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "file_length",
      "file_name",
      "file_type",
      "session_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateUpload.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateUpload(String nodeId, APIContext context) {
      super(context, nodeId, "/uploads", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUpload setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUpload setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUpload setFileLength (Long fileLength) {
      this.setParam("file_length", fileLength);
      return this;
    }
    public APIRequestCreateUpload setFileLength (String fileLength) {
      this.setParam("file_length", fileLength);
      return this;
    }

    public APIRequestCreateUpload setFileName (Object fileName) {
      this.setParam("file_name", fileName);
      return this;
    }
    public APIRequestCreateUpload setFileName (String fileName) {
      this.setParam("file_name", fileName);
      return this;
    }

    public APIRequestCreateUpload setFileType (Object fileType) {
      this.setParam("file_type", fileType);
      return this;
    }
    public APIRequestCreateUpload setFileType (String fileType) {
      this.setParam("file_type", fileType);
      return this;
    }

    public APIRequestCreateUpload setSessionType (EnumSessionType sessionType) {
      this.setParam("session_type", sessionType);
      return this;
    }
    public APIRequestCreateUpload setSessionType (String sessionType) {
      this.setParam("session_type", sessionType);
      return this;
    }

    public APIRequestCreateUpload requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpload requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpload requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUpload requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpload requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUpload requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateWhatsAppBusinessSolution extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "owner_permissions",
      "partner_app_id",
      "partner_permissions",
      "solution_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
             try {
               return APIRequestCreateWhatsAppBusinessSolution.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateWhatsAppBusinessSolution(String nodeId, APIContext context) {
      super(context, nodeId, "/whatsapp_business_solution", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateWhatsAppBusinessSolution setOwnerPermissions (List<Application.EnumOwnerPermissions> ownerPermissions) {
      this.setParam("owner_permissions", ownerPermissions);
      return this;
    }
    public APIRequestCreateWhatsAppBusinessSolution setOwnerPermissions (String ownerPermissions) {
      this.setParam("owner_permissions", ownerPermissions);
      return this;
    }

    public APIRequestCreateWhatsAppBusinessSolution setPartnerAppId (String partnerAppId) {
      this.setParam("partner_app_id", partnerAppId);
      return this;
    }

    public APIRequestCreateWhatsAppBusinessSolution setPartnerPermissions (List<Application.EnumPartnerPermissions> partnerPermissions) {
      this.setParam("partner_permissions", partnerPermissions);
      return this;
    }
    public APIRequestCreateWhatsAppBusinessSolution setPartnerPermissions (String partnerPermissions) {
      this.setParam("partner_permissions", partnerPermissions);
      return this;
    }

    public APIRequestCreateWhatsAppBusinessSolution setSolutionName (String solutionName) {
      this.setParam("solution_name", solutionName);
      return this;
    }

    public APIRequestCreateWhatsAppBusinessSolution requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateWhatsAppBusinessSolution requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateWhatsAppBusinessSolution requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetWhatsAppBusinessSolutions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "role",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetWhatsAppBusinessSolutions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetWhatsAppBusinessSolutions(String nodeId, APIContext context) {
      super(context, nodeId, "/whatsapp_business_solutions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetWhatsAppBusinessSolutions setRole (EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestGetWhatsAppBusinessSolutions setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestGetWhatsAppBusinessSolutions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetWhatsAppBusinessSolutions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetWhatsAppBusinessSolutions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "advertiser_id",
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
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
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


    public APIRequestGet setAdvertiserId (String advertiserId) {
      this.setParam("advertiser_id", advertiserId);
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

    public APIRequestGet requestAamRulesField () {
      return this.requestAamRulesField(true);
    }
    public APIRequestGet requestAamRulesField (boolean value) {
      this.requestField("aam_rules", value);
      return this;
    }
    public APIRequestGet requestAnAdSpaceLimitField () {
      return this.requestAnAdSpaceLimitField(true);
    }
    public APIRequestGet requestAnAdSpaceLimitField (boolean value) {
      this.requestField("an_ad_space_limit", value);
      return this;
    }
    public APIRequestGet requestAnPlatformsField () {
      return this.requestAnPlatformsField(true);
    }
    public APIRequestGet requestAnPlatformsField (boolean value) {
      this.requestField("an_platforms", value);
      return this;
    }
    public APIRequestGet requestAndroidKeyHashField () {
      return this.requestAndroidKeyHashField(true);
    }
    public APIRequestGet requestAndroidKeyHashField (boolean value) {
      this.requestField("android_key_hash", value);
      return this;
    }
    public APIRequestGet requestAndroidSdkErrorCategoriesField () {
      return this.requestAndroidSdkErrorCategoriesField(true);
    }
    public APIRequestGet requestAndroidSdkErrorCategoriesField (boolean value) {
      this.requestField("android_sdk_error_categories", value);
      return this;
    }
    public APIRequestGet requestAppDomainsField () {
      return this.requestAppDomainsField(true);
    }
    public APIRequestGet requestAppDomainsField (boolean value) {
      this.requestField("app_domains", value);
      return this;
    }
    public APIRequestGet requestAppEventsConfigField () {
      return this.requestAppEventsConfigField(true);
    }
    public APIRequestGet requestAppEventsConfigField (boolean value) {
      this.requestField("app_events_config", value);
      return this;
    }
    public APIRequestGet requestAppEventsFeatureBitmaskField () {
      return this.requestAppEventsFeatureBitmaskField(true);
    }
    public APIRequestGet requestAppEventsFeatureBitmaskField (boolean value) {
      this.requestField("app_events_feature_bitmask", value);
      return this;
    }
    public APIRequestGet requestAppEventsSessionTimeoutField () {
      return this.requestAppEventsSessionTimeoutField(true);
    }
    public APIRequestGet requestAppEventsSessionTimeoutField (boolean value) {
      this.requestField("app_events_session_timeout", value);
      return this;
    }
    public APIRequestGet requestAppInstallTrackedField () {
      return this.requestAppInstallTrackedField(true);
    }
    public APIRequestGet requestAppInstallTrackedField (boolean value) {
      this.requestField("app_install_tracked", value);
      return this;
    }
    public APIRequestGet requestAppNameField () {
      return this.requestAppNameField(true);
    }
    public APIRequestGet requestAppNameField (boolean value) {
      this.requestField("app_name", value);
      return this;
    }
    public APIRequestGet requestAppSignalsBindingIosField () {
      return this.requestAppSignalsBindingIosField(true);
    }
    public APIRequestGet requestAppSignalsBindingIosField (boolean value) {
      this.requestField("app_signals_binding_ios", value);
      return this;
    }
    public APIRequestGet requestAppTypeField () {
      return this.requestAppTypeField(true);
    }
    public APIRequestGet requestAppTypeField (boolean value) {
      this.requestField("app_type", value);
      return this;
    }
    public APIRequestGet requestAuthDialogDataHelpUrlField () {
      return this.requestAuthDialogDataHelpUrlField(true);
    }
    public APIRequestGet requestAuthDialogDataHelpUrlField (boolean value) {
      this.requestField("auth_dialog_data_help_url", value);
      return this;
    }
    public APIRequestGet requestAuthDialogHeadlineField () {
      return this.requestAuthDialogHeadlineField(true);
    }
    public APIRequestGet requestAuthDialogHeadlineField (boolean value) {
      this.requestField("auth_dialog_headline", value);
      return this;
    }
    public APIRequestGet requestAuthDialogPermsExplanationField () {
      return this.requestAuthDialogPermsExplanationField(true);
    }
    public APIRequestGet requestAuthDialogPermsExplanationField (boolean value) {
      this.requestField("auth_dialog_perms_explanation", value);
      return this;
    }
    public APIRequestGet requestAuthReferralDefaultActivityPrivacyField () {
      return this.requestAuthReferralDefaultActivityPrivacyField(true);
    }
    public APIRequestGet requestAuthReferralDefaultActivityPrivacyField (boolean value) {
      this.requestField("auth_referral_default_activity_privacy", value);
      return this;
    }
    public APIRequestGet requestAuthReferralEnabledField () {
      return this.requestAuthReferralEnabledField(true);
    }
    public APIRequestGet requestAuthReferralEnabledField (boolean value) {
      this.requestField("auth_referral_enabled", value);
      return this;
    }
    public APIRequestGet requestAuthReferralExtendedPermsField () {
      return this.requestAuthReferralExtendedPermsField(true);
    }
    public APIRequestGet requestAuthReferralExtendedPermsField (boolean value) {
      this.requestField("auth_referral_extended_perms", value);
      return this;
    }
    public APIRequestGet requestAuthReferralFriendPermsField () {
      return this.requestAuthReferralFriendPermsField(true);
    }
    public APIRequestGet requestAuthReferralFriendPermsField (boolean value) {
      this.requestField("auth_referral_friend_perms", value);
      return this;
    }
    public APIRequestGet requestAuthReferralResponseTypeField () {
      return this.requestAuthReferralResponseTypeField(true);
    }
    public APIRequestGet requestAuthReferralResponseTypeField (boolean value) {
      this.requestField("auth_referral_response_type", value);
      return this;
    }
    public APIRequestGet requestAuthReferralUserPermsField () {
      return this.requestAuthReferralUserPermsField(true);
    }
    public APIRequestGet requestAuthReferralUserPermsField (boolean value) {
      this.requestField("auth_referral_user_perms", value);
      return this;
    }
    public APIRequestGet requestAutoEventMappingAndroidField () {
      return this.requestAutoEventMappingAndroidField(true);
    }
    public APIRequestGet requestAutoEventMappingAndroidField (boolean value) {
      this.requestField("auto_event_mapping_android", value);
      return this;
    }
    public APIRequestGet requestAutoEventMappingIosField () {
      return this.requestAutoEventMappingIosField(true);
    }
    public APIRequestGet requestAutoEventMappingIosField (boolean value) {
      this.requestField("auto_event_mapping_ios", value);
      return this;
    }
    public APIRequestGet requestAutoEventSetupEnabledField () {
      return this.requestAutoEventSetupEnabledField(true);
    }
    public APIRequestGet requestAutoEventSetupEnabledField (boolean value) {
      this.requestField("auto_event_setup_enabled", value);
      return this;
    }
    public APIRequestGet requestAutoLogAppEventsDefaultField () {
      return this.requestAutoLogAppEventsDefaultField(true);
    }
    public APIRequestGet requestAutoLogAppEventsDefaultField (boolean value) {
      this.requestField("auto_log_app_events_default", value);
      return this;
    }
    public APIRequestGet requestAutoLogAppEventsEnabledField () {
      return this.requestAutoLogAppEventsEnabledField(true);
    }
    public APIRequestGet requestAutoLogAppEventsEnabledField (boolean value) {
      this.requestField("auto_log_app_events_enabled", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCanvasFluidHeightField () {
      return this.requestCanvasFluidHeightField(true);
    }
    public APIRequestGet requestCanvasFluidHeightField (boolean value) {
      this.requestField("canvas_fluid_height", value);
      return this;
    }
    public APIRequestGet requestCanvasFluidWidthField () {
      return this.requestCanvasFluidWidthField(true);
    }
    public APIRequestGet requestCanvasFluidWidthField (boolean value) {
      this.requestField("canvas_fluid_width", value);
      return this;
    }
    public APIRequestGet requestCanvasUrlField () {
      return this.requestCanvasUrlField(true);
    }
    public APIRequestGet requestCanvasUrlField (boolean value) {
      this.requestField("canvas_url", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestClientConfigField () {
      return this.requestClientConfigField(true);
    }
    public APIRequestGet requestClientConfigField (boolean value) {
      this.requestField("client_config", value);
      return this;
    }
    public APIRequestGet requestCompanyField () {
      return this.requestCompanyField(true);
    }
    public APIRequestGet requestCompanyField (boolean value) {
      this.requestField("company", value);
      return this;
    }
    public APIRequestGet requestConfiguredIosSsoField () {
      return this.requestConfiguredIosSsoField(true);
    }
    public APIRequestGet requestConfiguredIosSsoField (boolean value) {
      this.requestField("configured_ios_sso", value);
      return this;
    }
    public APIRequestGet requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGet requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreatorUidField () {
      return this.requestCreatorUidField(true);
    }
    public APIRequestGet requestCreatorUidField (boolean value) {
      this.requestField("creator_uid", value);
      return this;
    }
    public APIRequestGet requestDailyActiveUsersField () {
      return this.requestDailyActiveUsersField(true);
    }
    public APIRequestGet requestDailyActiveUsersField (boolean value) {
      this.requestField("daily_active_users", value);
      return this;
    }
    public APIRequestGet requestDailyActiveUsersRankField () {
      return this.requestDailyActiveUsersRankField(true);
    }
    public APIRequestGet requestDailyActiveUsersRankField (boolean value) {
      this.requestField("daily_active_users_rank", value);
      return this;
    }
    public APIRequestGet requestDeauthCallbackUrlField () {
      return this.requestDeauthCallbackUrlField(true);
    }
    public APIRequestGet requestDeauthCallbackUrlField (boolean value) {
      this.requestField("deauth_callback_url", value);
      return this;
    }
    public APIRequestGet requestDefaultShareModeField () {
      return this.requestDefaultShareModeField(true);
    }
    public APIRequestGet requestDefaultShareModeField (boolean value) {
      this.requestField("default_share_mode", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFinancialIdField () {
      return this.requestFinancialIdField(true);
    }
    public APIRequestGet requestFinancialIdField (boolean value) {
      this.requestField("financial_id", value);
      return this;
    }
    public APIRequestGet requestGdpv4ChromeCustomTabsEnabledField () {
      return this.requestGdpv4ChromeCustomTabsEnabledField(true);
    }
    public APIRequestGet requestGdpv4ChromeCustomTabsEnabledField (boolean value) {
      this.requestField("gdpv4_chrome_custom_tabs_enabled", value);
      return this;
    }
    public APIRequestGet requestGdpv4EnabledField () {
      return this.requestGdpv4EnabledField(true);
    }
    public APIRequestGet requestGdpv4EnabledField (boolean value) {
      this.requestField("gdpv4_enabled", value);
      return this;
    }
    public APIRequestGet requestGdpv4NuxContentField () {
      return this.requestGdpv4NuxContentField(true);
    }
    public APIRequestGet requestGdpv4NuxContentField (boolean value) {
      this.requestField("gdpv4_nux_content", value);
      return this;
    }
    public APIRequestGet requestGdpv4NuxEnabledField () {
      return this.requestGdpv4NuxEnabledField(true);
    }
    public APIRequestGet requestGdpv4NuxEnabledField (boolean value) {
      this.requestField("gdpv4_nux_enabled", value);
      return this;
    }
    public APIRequestGet requestHasMessengerProductField () {
      return this.requestHasMessengerProductField(true);
    }
    public APIRequestGet requestHasMessengerProductField (boolean value) {
      this.requestField("has_messenger_product", value);
      return this;
    }
    public APIRequestGet requestHostingUrlField () {
      return this.requestHostingUrlField(true);
    }
    public APIRequestGet requestHostingUrlField (boolean value) {
      this.requestField("hosting_url", value);
      return this;
    }
    public APIRequestGet requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGet requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIosBundleIdField () {
      return this.requestIosBundleIdField(true);
    }
    public APIRequestGet requestIosBundleIdField (boolean value) {
      this.requestField("ios_bundle_id", value);
      return this;
    }
    public APIRequestGet requestIosSdkDialogFlowsField () {
      return this.requestIosSdkDialogFlowsField(true);
    }
    public APIRequestGet requestIosSdkDialogFlowsField (boolean value) {
      this.requestField("ios_sdk_dialog_flows", value);
      return this;
    }
    public APIRequestGet requestIosSdkErrorCategoriesField () {
      return this.requestIosSdkErrorCategoriesField(true);
    }
    public APIRequestGet requestIosSdkErrorCategoriesField (boolean value) {
      this.requestField("ios_sdk_error_categories", value);
      return this;
    }
    public APIRequestGet requestIosSfvcAttrField () {
      return this.requestIosSfvcAttrField(true);
    }
    public APIRequestGet requestIosSfvcAttrField (boolean value) {
      this.requestField("ios_sfvc_attr", value);
      return this;
    }
    public APIRequestGet requestIosSupportsNativeProxyAuthFlowField () {
      return this.requestIosSupportsNativeProxyAuthFlowField(true);
    }
    public APIRequestGet requestIosSupportsNativeProxyAuthFlowField (boolean value) {
      this.requestField("ios_supports_native_proxy_auth_flow", value);
      return this;
    }
    public APIRequestGet requestIosSupportsSystemAuthField () {
      return this.requestIosSupportsSystemAuthField(true);
    }
    public APIRequestGet requestIosSupportsSystemAuthField (boolean value) {
      this.requestField("ios_supports_system_auth", value);
      return this;
    }
    public APIRequestGet requestIpadAppStoreIdField () {
      return this.requestIpadAppStoreIdField(true);
    }
    public APIRequestGet requestIpadAppStoreIdField (boolean value) {
      this.requestField("ipad_app_store_id", value);
      return this;
    }
    public APIRequestGet requestIphoneAppStoreIdField () {
      return this.requestIphoneAppStoreIdField(true);
    }
    public APIRequestGet requestIphoneAppStoreIdField (boolean value) {
      this.requestField("iphone_app_store_id", value);
      return this;
    }
    public APIRequestGet requestLatestSdkVersionField () {
      return this.requestLatestSdkVersionField(true);
    }
    public APIRequestGet requestLatestSdkVersionField (boolean value) {
      this.requestField("latest_sdk_version", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestLoggingTokenField () {
      return this.requestLoggingTokenField(true);
    }
    public APIRequestGet requestLoggingTokenField (boolean value) {
      this.requestField("logging_token", value);
      return this;
    }
    public APIRequestGet requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGet requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGet requestMigrationsField () {
      return this.requestMigrationsField(true);
    }
    public APIRequestGet requestMigrationsField (boolean value) {
      this.requestField("migrations", value);
      return this;
    }
    public APIRequestGet requestMobileProfileSectionUrlField () {
      return this.requestMobileProfileSectionUrlField(true);
    }
    public APIRequestGet requestMobileProfileSectionUrlField (boolean value) {
      this.requestField("mobile_profile_section_url", value);
      return this;
    }
    public APIRequestGet requestMobileWebUrlField () {
      return this.requestMobileWebUrlField(true);
    }
    public APIRequestGet requestMobileWebUrlField (boolean value) {
      this.requestField("mobile_web_url", value);
      return this;
    }
    public APIRequestGet requestMonthlyActiveUsersField () {
      return this.requestMonthlyActiveUsersField(true);
    }
    public APIRequestGet requestMonthlyActiveUsersField (boolean value) {
      this.requestField("monthly_active_users", value);
      return this;
    }
    public APIRequestGet requestMonthlyActiveUsersRankField () {
      return this.requestMonthlyActiveUsersRankField(true);
    }
    public APIRequestGet requestMonthlyActiveUsersRankField (boolean value) {
      this.requestField("monthly_active_users_rank", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGet requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGet requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGet requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestPageTabDefaultNameField () {
      return this.requestPageTabDefaultNameField(true);
    }
    public APIRequestGet requestPageTabDefaultNameField (boolean value) {
      this.requestField("page_tab_default_name", value);
      return this;
    }
    public APIRequestGet requestPageTabUrlField () {
      return this.requestPageTabUrlField(true);
    }
    public APIRequestGet requestPageTabUrlField (boolean value) {
      this.requestField("page_tab_url", value);
      return this;
    }
    public APIRequestGet requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGet requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
      return this;
    }
    public APIRequestGet requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGet requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGet requestProfileSectionUrlField () {
      return this.requestProfileSectionUrlField(true);
    }
    public APIRequestGet requestProfileSectionUrlField (boolean value) {
      this.requestField("profile_section_url", value);
      return this;
    }
    public APIRequestGet requestPropertyIdField () {
      return this.requestPropertyIdField(true);
    }
    public APIRequestGet requestPropertyIdField (boolean value) {
      this.requestField("property_id", value);
      return this;
    }
    public APIRequestGet requestProtectedModeRulesField () {
      return this.requestProtectedModeRulesField(true);
    }
    public APIRequestGet requestProtectedModeRulesField (boolean value) {
      this.requestField("protected_mode_rules", value);
      return this;
    }
    public APIRequestGet requestRealTimeModeDevicesField () {
      return this.requestRealTimeModeDevicesField(true);
    }
    public APIRequestGet requestRealTimeModeDevicesField (boolean value) {
      this.requestField("real_time_mode_devices", value);
      return this;
    }
    public APIRequestGet requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGet requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGet requestRestrictiveDataFilterParamsField () {
      return this.requestRestrictiveDataFilterParamsField(true);
    }
    public APIRequestGet requestRestrictiveDataFilterParamsField (boolean value) {
      this.requestField("restrictive_data_filter_params", value);
      return this;
    }
    public APIRequestGet requestRestrictiveDataFilterRulesField () {
      return this.requestRestrictiveDataFilterRulesField(true);
    }
    public APIRequestGet requestRestrictiveDataFilterRulesField (boolean value) {
      this.requestField("restrictive_data_filter_rules", value);
      return this;
    }
    public APIRequestGet requestSdkUpdateMessageField () {
      return this.requestSdkUpdateMessageField(true);
    }
    public APIRequestGet requestSdkUpdateMessageField (boolean value) {
      this.requestField("sdk_update_message", value);
      return this;
    }
    public APIRequestGet requestSeamlessLoginField () {
      return this.requestSeamlessLoginField(true);
    }
    public APIRequestGet requestSeamlessLoginField (boolean value) {
      this.requestField("seamless_login", value);
      return this;
    }
    public APIRequestGet requestSecureCanvasUrlField () {
      return this.requestSecureCanvasUrlField(true);
    }
    public APIRequestGet requestSecureCanvasUrlField (boolean value) {
      this.requestField("secure_canvas_url", value);
      return this;
    }
    public APIRequestGet requestSecurePageTabUrlField () {
      return this.requestSecurePageTabUrlField(true);
    }
    public APIRequestGet requestSecurePageTabUrlField (boolean value) {
      this.requestField("secure_page_tab_url", value);
      return this;
    }
    public APIRequestGet requestServerIpWhitelistField () {
      return this.requestServerIpWhitelistField(true);
    }
    public APIRequestGet requestServerIpWhitelistField (boolean value) {
      this.requestField("server_ip_whitelist", value);
      return this;
    }
    public APIRequestGet requestSmartLoginBookmarkIconUrlField () {
      return this.requestSmartLoginBookmarkIconUrlField(true);
    }
    public APIRequestGet requestSmartLoginBookmarkIconUrlField (boolean value) {
      this.requestField("smart_login_bookmark_icon_url", value);
      return this;
    }
    public APIRequestGet requestSmartLoginMenuIconUrlField () {
      return this.requestSmartLoginMenuIconUrlField(true);
    }
    public APIRequestGet requestSmartLoginMenuIconUrlField (boolean value) {
      this.requestField("smart_login_menu_icon_url", value);
      return this;
    }
    public APIRequestGet requestSocialDiscoveryField () {
      return this.requestSocialDiscoveryField(true);
    }
    public APIRequestGet requestSocialDiscoveryField (boolean value) {
      this.requestField("social_discovery", value);
      return this;
    }
    public APIRequestGet requestSubcategoryField () {
      return this.requestSubcategoryField(true);
    }
    public APIRequestGet requestSubcategoryField (boolean value) {
      this.requestField("subcategory", value);
      return this;
    }
    public APIRequestGet requestSuggestedEventsSettingField () {
      return this.requestSuggestedEventsSettingField(true);
    }
    public APIRequestGet requestSuggestedEventsSettingField (boolean value) {
      this.requestField("suggested_events_setting", value);
      return this;
    }
    public APIRequestGet requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGet requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGet requestSupportsApprequestsFastAppSwitchField () {
      return this.requestSupportsApprequestsFastAppSwitchField(true);
    }
    public APIRequestGet requestSupportsApprequestsFastAppSwitchField (boolean value) {
      this.requestField("supports_apprequests_fast_app_switch", value);
      return this;
    }
    public APIRequestGet requestSupportsAttributionField () {
      return this.requestSupportsAttributionField(true);
    }
    public APIRequestGet requestSupportsAttributionField (boolean value) {
      this.requestField("supports_attribution", value);
      return this;
    }
    public APIRequestGet requestSupportsImplicitSdkLoggingField () {
      return this.requestSupportsImplicitSdkLoggingField(true);
    }
    public APIRequestGet requestSupportsImplicitSdkLoggingField (boolean value) {
      this.requestField("supports_implicit_sdk_logging", value);
      return this;
    }
    public APIRequestGet requestSuppressNativeIosGdpField () {
      return this.requestSuppressNativeIosGdpField(true);
    }
    public APIRequestGet requestSuppressNativeIosGdpField (boolean value) {
      this.requestField("suppress_native_ios_gdp", value);
      return this;
    }
    public APIRequestGet requestTermsOfServiceUrlField () {
      return this.requestTermsOfServiceUrlField(true);
    }
    public APIRequestGet requestTermsOfServiceUrlField (boolean value) {
      this.requestField("terms_of_service_url", value);
      return this;
    }
    public APIRequestGet requestUrlSchemeSuffixField () {
      return this.requestUrlSchemeSuffixField(true);
    }
    public APIRequestGet requestUrlSchemeSuffixField (boolean value) {
      this.requestField("url_scheme_suffix", value);
      return this;
    }
    public APIRequestGet requestUserSupportEmailField () {
      return this.requestUserSupportEmailField(true);
    }
    public APIRequestGet requestUserSupportEmailField (boolean value) {
      this.requestField("user_support_email", value);
      return this;
    }
    public APIRequestGet requestUserSupportUrlField () {
      return this.requestUserSupportUrlField(true);
    }
    public APIRequestGet requestUserSupportUrlField (boolean value) {
      this.requestField("user_support_url", value);
      return this;
    }
    public APIRequestGet requestWebsiteUrlField () {
      return this.requestWebsiteUrlField(true);
    }
    public APIRequestGet requestWebsiteUrlField (boolean value) {
      this.requestField("website_url", value);
      return this;
    }
    public APIRequestGet requestWeeklyActiveUsersField () {
      return this.requestWeeklyActiveUsersField(true);
    }
    public APIRequestGet requestWeeklyActiveUsersField (boolean value) {
      this.requestField("weekly_active_users", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_cycle_app_secret",
      "an_platforms",
      "app_domains",
      "app_name",
      "app_type",
      "auth_dialog_headline",
      "auth_dialog_perms_explanation",
      "auth_referral_default_activity_privacy",
      "auth_referral_enabled",
      "auth_referral_extended_perms",
      "auth_referral_friend_perms",
      "auth_referral_response_type",
      "auth_referral_user_perms",
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "contact_email",
      "deauth_callback_url",
      "mobile_web_url",
      "namespace",
      "page_tab_default_name",
      "privacy_policy_url",
      "restrictions",
      "secure_canvas_url",
      "secure_page_tab_url",
      "server_ip_whitelist",
      "terms_of_service_url",
      "url_scheme_suffix",
      "user_support_email",
      "user_support_url",
      "website_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Application parseResponse(String response, String header) throws APIException {
      return Application.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Application execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Application execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Application> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Application> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Application>() {
           public Application apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAllowCycleAppSecret (Boolean allowCycleAppSecret) {
      this.setParam("allow_cycle_app_secret", allowCycleAppSecret);
      return this;
    }
    public APIRequestUpdate setAllowCycleAppSecret (String allowCycleAppSecret) {
      this.setParam("allow_cycle_app_secret", allowCycleAppSecret);
      return this;
    }

    public APIRequestUpdate setAnPlatforms (List<Application.EnumAnPlatforms> anPlatforms) {
      this.setParam("an_platforms", anPlatforms);
      return this;
    }
    public APIRequestUpdate setAnPlatforms (String anPlatforms) {
      this.setParam("an_platforms", anPlatforms);
      return this;
    }

    public APIRequestUpdate setAppDomains (List<String> appDomains) {
      this.setParam("app_domains", appDomains);
      return this;
    }
    public APIRequestUpdate setAppDomains (String appDomains) {
      this.setParam("app_domains", appDomains);
      return this;
    }

    public APIRequestUpdate setAppName (String appName) {
      this.setParam("app_name", appName);
      return this;
    }

    public APIRequestUpdate setAppType (Boolean appType) {
      this.setParam("app_type", appType);
      return this;
    }
    public APIRequestUpdate setAppType (String appType) {
      this.setParam("app_type", appType);
      return this;
    }

    public APIRequestUpdate setAuthDialogHeadline (String authDialogHeadline) {
      this.setParam("auth_dialog_headline", authDialogHeadline);
      return this;
    }

    public APIRequestUpdate setAuthDialogPermsExplanation (String authDialogPermsExplanation) {
      this.setParam("auth_dialog_perms_explanation", authDialogPermsExplanation);
      return this;
    }

    public APIRequestUpdate setAuthReferralDefaultActivityPrivacy (String authReferralDefaultActivityPrivacy) {
      this.setParam("auth_referral_default_activity_privacy", authReferralDefaultActivityPrivacy);
      return this;
    }

    public APIRequestUpdate setAuthReferralEnabled (Boolean authReferralEnabled) {
      this.setParam("auth_referral_enabled", authReferralEnabled);
      return this;
    }
    public APIRequestUpdate setAuthReferralEnabled (String authReferralEnabled) {
      this.setParam("auth_referral_enabled", authReferralEnabled);
      return this;
    }

    public APIRequestUpdate setAuthReferralExtendedPerms (List<String> authReferralExtendedPerms) {
      this.setParam("auth_referral_extended_perms", authReferralExtendedPerms);
      return this;
    }
    public APIRequestUpdate setAuthReferralExtendedPerms (String authReferralExtendedPerms) {
      this.setParam("auth_referral_extended_perms", authReferralExtendedPerms);
      return this;
    }

    public APIRequestUpdate setAuthReferralFriendPerms (List<String> authReferralFriendPerms) {
      this.setParam("auth_referral_friend_perms", authReferralFriendPerms);
      return this;
    }
    public APIRequestUpdate setAuthReferralFriendPerms (String authReferralFriendPerms) {
      this.setParam("auth_referral_friend_perms", authReferralFriendPerms);
      return this;
    }

    public APIRequestUpdate setAuthReferralResponseType (String authReferralResponseType) {
      this.setParam("auth_referral_response_type", authReferralResponseType);
      return this;
    }

    public APIRequestUpdate setAuthReferralUserPerms (List<String> authReferralUserPerms) {
      this.setParam("auth_referral_user_perms", authReferralUserPerms);
      return this;
    }
    public APIRequestUpdate setAuthReferralUserPerms (String authReferralUserPerms) {
      this.setParam("auth_referral_user_perms", authReferralUserPerms);
      return this;
    }

    public APIRequestUpdate setCanvasFluidHeight (Boolean canvasFluidHeight) {
      this.setParam("canvas_fluid_height", canvasFluidHeight);
      return this;
    }
    public APIRequestUpdate setCanvasFluidHeight (String canvasFluidHeight) {
      this.setParam("canvas_fluid_height", canvasFluidHeight);
      return this;
    }

    public APIRequestUpdate setCanvasFluidWidth (Boolean canvasFluidWidth) {
      this.setParam("canvas_fluid_width", canvasFluidWidth);
      return this;
    }
    public APIRequestUpdate setCanvasFluidWidth (String canvasFluidWidth) {
      this.setParam("canvas_fluid_width", canvasFluidWidth);
      return this;
    }

    public APIRequestUpdate setCanvasUrl (String canvasUrl) {
      this.setParam("canvas_url", canvasUrl);
      return this;
    }

    public APIRequestUpdate setContactEmail (String contactEmail) {
      this.setParam("contact_email", contactEmail);
      return this;
    }

    public APIRequestUpdate setDeauthCallbackUrl (String deauthCallbackUrl) {
      this.setParam("deauth_callback_url", deauthCallbackUrl);
      return this;
    }

    public APIRequestUpdate setMobileWebUrl (String mobileWebUrl) {
      this.setParam("mobile_web_url", mobileWebUrl);
      return this;
    }

    public APIRequestUpdate setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestUpdate setPageTabDefaultName (String pageTabDefaultName) {
      this.setParam("page_tab_default_name", pageTabDefaultName);
      return this;
    }

    public APIRequestUpdate setPrivacyPolicyUrl (String privacyPolicyUrl) {
      this.setParam("privacy_policy_url", privacyPolicyUrl);
      return this;
    }

    public APIRequestUpdate setRestrictions (String restrictions) {
      this.setParam("restrictions", restrictions);
      return this;
    }

    public APIRequestUpdate setSecureCanvasUrl (String secureCanvasUrl) {
      this.setParam("secure_canvas_url", secureCanvasUrl);
      return this;
    }

    public APIRequestUpdate setSecurePageTabUrl (String securePageTabUrl) {
      this.setParam("secure_page_tab_url", securePageTabUrl);
      return this;
    }

    public APIRequestUpdate setServerIpWhitelist (List<String> serverIpWhitelist) {
      this.setParam("server_ip_whitelist", serverIpWhitelist);
      return this;
    }
    public APIRequestUpdate setServerIpWhitelist (String serverIpWhitelist) {
      this.setParam("server_ip_whitelist", serverIpWhitelist);
      return this;
    }

    public APIRequestUpdate setTermsOfServiceUrl (String termsOfServiceUrl) {
      this.setParam("terms_of_service_url", termsOfServiceUrl);
      return this;
    }

    public APIRequestUpdate setUrlSchemeSuffix (String urlSchemeSuffix) {
      this.setParam("url_scheme_suffix", urlSchemeSuffix);
      return this;
    }

    public APIRequestUpdate setUserSupportEmail (String userSupportEmail) {
      this.setParam("user_support_email", userSupportEmail);
      return this;
    }

    public APIRequestUpdate setUserSupportUrl (String userSupportUrl) {
      this.setParam("user_support_url", userSupportUrl);
      return this;
    }

    public APIRequestUpdate setWebsiteUrl (String websiteUrl) {
      this.setParam("website_url", websiteUrl);
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

  public static enum EnumSupportedPlatforms {
      @SerializedName("AMAZON")
      VALUE_AMAZON("AMAZON"),
      @SerializedName("ANDROID")
      VALUE_ANDROID("ANDROID"),
      @SerializedName("CANVAS")
      VALUE_CANVAS("CANVAS"),
      @SerializedName("GAMEROOM")
      VALUE_GAMEROOM("GAMEROOM"),
      @SerializedName("INSTANT_GAME")
      VALUE_INSTANT_GAME("INSTANT_GAME"),
      @SerializedName("IPAD")
      VALUE_IPAD("IPAD"),
      @SerializedName("IPHONE")
      VALUE_IPHONE("IPHONE"),
      @SerializedName("MOBILE_WEB")
      VALUE_MOBILE_WEB("MOBILE_WEB"),
      @SerializedName("OCULUS")
      VALUE_OCULUS("OCULUS"),
      @SerializedName("SAMSUNG")
      VALUE_SAMSUNG("SAMSUNG"),
      @SerializedName("SUPPLEMENTARY_IMAGES")
      VALUE_SUPPLEMENTARY_IMAGES("SUPPLEMENTARY_IMAGES"),
      @SerializedName("WEB")
      VALUE_WEB("WEB"),
      @SerializedName("WINDOWS")
      VALUE_WINDOWS("WINDOWS"),
      @SerializedName("XIAOMI")
      VALUE_XIAOMI("XIAOMI"),
      ;

      private String value;

      private EnumSupportedPlatforms(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAnPlatforms {
      @SerializedName("ANDROID")
      VALUE_ANDROID("ANDROID"),
      @SerializedName("DESKTOP")
      VALUE_DESKTOP("DESKTOP"),
      @SerializedName("GALAXY")
      VALUE_GALAXY("GALAXY"),
      @SerializedName("INSTANT_ARTICLES")
      VALUE_INSTANT_ARTICLES("INSTANT_ARTICLES"),
      @SerializedName("IOS")
      VALUE_IOS("IOS"),
      @SerializedName("MOBILE_WEB")
      VALUE_MOBILE_WEB("MOBILE_WEB"),
      @SerializedName("OCULUS")
      VALUE_OCULUS("OCULUS"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("XIAOMI")
      VALUE_XIAOMI("XIAOMI"),
      ;

      private String value;

      private EnumAnPlatforms(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPlatform {
      @SerializedName("ANDROID")
      VALUE_ANDROID("ANDROID"),
      @SerializedName("IOS")
      VALUE_IOS("IOS"),
      ;

      private String value;

      private EnumPlatform(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRequestType {
      @SerializedName("APP_INDEXING")
      VALUE_APP_INDEXING("APP_INDEXING"),
      @SerializedName("BUTTON_SAMPLING")
      VALUE_BUTTON_SAMPLING("BUTTON_SAMPLING"),
      @SerializedName("PLUGIN")
      VALUE_PLUGIN("PLUGIN"),
      ;

      private String value;

      private EnumRequestType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMutationMethod {
      @SerializedName("ADD")
      VALUE_ADD("ADD"),
      @SerializedName("DELETE")
      VALUE_DELETE("DELETE"),
      @SerializedName("REPLACE")
      VALUE_REPLACE("REPLACE"),
      ;

      private String value;

      private EnumMutationMethod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPostMethod {
      @SerializedName("CODELESS")
      VALUE_CODELESS("CODELESS"),
      @SerializedName("EYMT")
      VALUE_EYMT("EYMT"),
      ;

      private String value;

      private EnumPostMethod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLoggingSource {
      @SerializedName("DETECTION")
      VALUE_DETECTION("DETECTION"),
      @SerializedName("MESSENGER_BOT")
      VALUE_MESSENGER_BOT("MESSENGER_BOT"),
      ;

      private String value;

      private EnumLoggingSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLoggingTarget {
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("APP_AND_PAGE")
      VALUE_APP_AND_PAGE("APP_AND_PAGE"),
      @SerializedName("PAGE")
      VALUE_PAGE("PAGE"),
      ;

      private String value;

      private EnumLoggingTarget(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOwnerPermissions {
      @SerializedName("DEVELOP")
      VALUE_DEVELOP("DEVELOP"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_EXTENSIONS")
      VALUE_MANAGE_EXTENSIONS("MANAGE_EXTENSIONS"),
      @SerializedName("MANAGE_PHONE")
      VALUE_MANAGE_PHONE("MANAGE_PHONE"),
      @SerializedName("MANAGE_PHONE_ASSETS")
      VALUE_MANAGE_PHONE_ASSETS("MANAGE_PHONE_ASSETS"),
      @SerializedName("MANAGE_TEMPLATES")
      VALUE_MANAGE_TEMPLATES("MANAGE_TEMPLATES"),
      @SerializedName("MESSAGING")
      VALUE_MESSAGING("MESSAGING"),
      @SerializedName("VIEW_COST")
      VALUE_VIEW_COST("VIEW_COST"),
      @SerializedName("VIEW_PHONE_ASSETS")
      VALUE_VIEW_PHONE_ASSETS("VIEW_PHONE_ASSETS"),
      @SerializedName("VIEW_TEMPLATES")
      VALUE_VIEW_TEMPLATES("VIEW_TEMPLATES"),
      ;

      private String value;

      private EnumOwnerPermissions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPartnerPermissions {
      @SerializedName("DEVELOP")
      VALUE_DEVELOP("DEVELOP"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_EXTENSIONS")
      VALUE_MANAGE_EXTENSIONS("MANAGE_EXTENSIONS"),
      @SerializedName("MANAGE_PHONE")
      VALUE_MANAGE_PHONE("MANAGE_PHONE"),
      @SerializedName("MANAGE_PHONE_ASSETS")
      VALUE_MANAGE_PHONE_ASSETS("MANAGE_PHONE_ASSETS"),
      @SerializedName("MANAGE_TEMPLATES")
      VALUE_MANAGE_TEMPLATES("MANAGE_TEMPLATES"),
      @SerializedName("MESSAGING")
      VALUE_MESSAGING("MESSAGING"),
      @SerializedName("VIEW_COST")
      VALUE_VIEW_COST("VIEW_COST"),
      @SerializedName("VIEW_PHONE_ASSETS")
      VALUE_VIEW_PHONE_ASSETS("VIEW_PHONE_ASSETS"),
      @SerializedName("VIEW_TEMPLATES")
      VALUE_VIEW_TEMPLATES("VIEW_TEMPLATES"),
      ;

      private String value;

      private EnumPartnerPermissions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("test-users")
      VALUE_TEST_USERS("test-users"),
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

  public static enum EnumEvent {
      @SerializedName("CUSTOM_APP_EVENTS")
      VALUE_CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS"),
      @SerializedName("DEFERRED_APP_LINK")
      VALUE_DEFERRED_APP_LINK("DEFERRED_APP_LINK"),
      @SerializedName("MOBILE_APP_INSTALL")
      VALUE_MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
      ;

      private String value;

      private EnumEvent(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUserIdType {
      @SerializedName("INSTANT_GAMES_PLAYER_ID")
      VALUE_INSTANT_GAMES_PLAYER_ID("INSTANT_GAMES_PLAYER_ID"),
      ;

      private String value;

      private EnumUserIdType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("live")
      VALUE_LIVE("live"),
      @SerializedName("unapproved")
      VALUE_UNAPPROVED("unapproved"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSessionType {
      @SerializedName("attachment")
      VALUE_ATTACHMENT("attachment"),
      ;

      private String value;

      private EnumSessionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRole {
      @SerializedName("OWNER")
      VALUE_OWNER("OWNER"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      ;

      private String value;

      private EnumRole(String value) {
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

  public Application copyFrom(Application instance) {
    this.mAamRules = instance.mAamRules;
    this.mAnAdSpaceLimit = instance.mAnAdSpaceLimit;
    this.mAnPlatforms = instance.mAnPlatforms;
    this.mAndroidKeyHash = instance.mAndroidKeyHash;
    this.mAndroidSdkErrorCategories = instance.mAndroidSdkErrorCategories;
    this.mAppDomains = instance.mAppDomains;
    this.mAppEventsConfig = instance.mAppEventsConfig;
    this.mAppEventsFeatureBitmask = instance.mAppEventsFeatureBitmask;
    this.mAppEventsSessionTimeout = instance.mAppEventsSessionTimeout;
    this.mAppInstallTracked = instance.mAppInstallTracked;
    this.mAppName = instance.mAppName;
    this.mAppSignalsBindingIos = instance.mAppSignalsBindingIos;
    this.mAppType = instance.mAppType;
    this.mAuthDialogDataHelpUrl = instance.mAuthDialogDataHelpUrl;
    this.mAuthDialogHeadline = instance.mAuthDialogHeadline;
    this.mAuthDialogPermsExplanation = instance.mAuthDialogPermsExplanation;
    this.mAuthReferralDefaultActivityPrivacy = instance.mAuthReferralDefaultActivityPrivacy;
    this.mAuthReferralEnabled = instance.mAuthReferralEnabled;
    this.mAuthReferralExtendedPerms = instance.mAuthReferralExtendedPerms;
    this.mAuthReferralFriendPerms = instance.mAuthReferralFriendPerms;
    this.mAuthReferralResponseType = instance.mAuthReferralResponseType;
    this.mAuthReferralUserPerms = instance.mAuthReferralUserPerms;
    this.mAutoEventMappingAndroid = instance.mAutoEventMappingAndroid;
    this.mAutoEventMappingIos = instance.mAutoEventMappingIos;
    this.mAutoEventSetupEnabled = instance.mAutoEventSetupEnabled;
    this.mAutoLogAppEventsDefault = instance.mAutoLogAppEventsDefault;
    this.mAutoLogAppEventsEnabled = instance.mAutoLogAppEventsEnabled;
    this.mBusiness = instance.mBusiness;
    this.mCanvasFluidHeight = instance.mCanvasFluidHeight;
    this.mCanvasFluidWidth = instance.mCanvasFluidWidth;
    this.mCanvasUrl = instance.mCanvasUrl;
    this.mCategory = instance.mCategory;
    this.mClientConfig = instance.mClientConfig;
    this.mCompany = instance.mCompany;
    this.mConfiguredIosSso = instance.mConfiguredIosSso;
    this.mContactEmail = instance.mContactEmail;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreatorUid = instance.mCreatorUid;
    this.mDailyActiveUsers = instance.mDailyActiveUsers;
    this.mDailyActiveUsersRank = instance.mDailyActiveUsersRank;
    this.mDeauthCallbackUrl = instance.mDeauthCallbackUrl;
    this.mDefaultShareMode = instance.mDefaultShareMode;
    this.mDescription = instance.mDescription;
    this.mFinancialId = instance.mFinancialId;
    this.mGdpv4ChromeCustomTabsEnabled = instance.mGdpv4ChromeCustomTabsEnabled;
    this.mGdpv4Enabled = instance.mGdpv4Enabled;
    this.mGdpv4NuxContent = instance.mGdpv4NuxContent;
    this.mGdpv4NuxEnabled = instance.mGdpv4NuxEnabled;
    this.mHasMessengerProduct = instance.mHasMessengerProduct;
    this.mHostingUrl = instance.mHostingUrl;
    this.mIconUrl = instance.mIconUrl;
    this.mId = instance.mId;
    this.mIosBundleId = instance.mIosBundleId;
    this.mIosSdkDialogFlows = instance.mIosSdkDialogFlows;
    this.mIosSdkErrorCategories = instance.mIosSdkErrorCategories;
    this.mIosSfvcAttr = instance.mIosSfvcAttr;
    this.mIosSupportsNativeProxyAuthFlow = instance.mIosSupportsNativeProxyAuthFlow;
    this.mIosSupportsSystemAuth = instance.mIosSupportsSystemAuth;
    this.mIpadAppStoreId = instance.mIpadAppStoreId;
    this.mIphoneAppStoreId = instance.mIphoneAppStoreId;
    this.mLatestSdkVersion = instance.mLatestSdkVersion;
    this.mLink = instance.mLink;
    this.mLoggingToken = instance.mLoggingToken;
    this.mLogoUrl = instance.mLogoUrl;
    this.mMigrations = instance.mMigrations;
    this.mMobileProfileSectionUrl = instance.mMobileProfileSectionUrl;
    this.mMobileWebUrl = instance.mMobileWebUrl;
    this.mMonthlyActiveUsers = instance.mMonthlyActiveUsers;
    this.mMonthlyActiveUsersRank = instance.mMonthlyActiveUsersRank;
    this.mName = instance.mName;
    this.mNamespace = instance.mNamespace;
    this.mObjectStoreUrls = instance.mObjectStoreUrls;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mPageTabDefaultName = instance.mPageTabDefaultName;
    this.mPageTabUrl = instance.mPageTabUrl;
    this.mPhotoUrl = instance.mPhotoUrl;
    this.mPrivacyPolicyUrl = instance.mPrivacyPolicyUrl;
    this.mProfileSectionUrl = instance.mProfileSectionUrl;
    this.mPropertyId = instance.mPropertyId;
    this.mProtectedModeRules = instance.mProtectedModeRules;
    this.mRealTimeModeDevices = instance.mRealTimeModeDevices;
    this.mRestrictions = instance.mRestrictions;
    this.mRestrictiveDataFilterParams = instance.mRestrictiveDataFilterParams;
    this.mRestrictiveDataFilterRules = instance.mRestrictiveDataFilterRules;
    this.mSdkUpdateMessage = instance.mSdkUpdateMessage;
    this.mSeamlessLogin = instance.mSeamlessLogin;
    this.mSecureCanvasUrl = instance.mSecureCanvasUrl;
    this.mSecurePageTabUrl = instance.mSecurePageTabUrl;
    this.mServerIpWhitelist = instance.mServerIpWhitelist;
    this.mSmartLoginBookmarkIconUrl = instance.mSmartLoginBookmarkIconUrl;
    this.mSmartLoginMenuIconUrl = instance.mSmartLoginMenuIconUrl;
    this.mSocialDiscovery = instance.mSocialDiscovery;
    this.mSubcategory = instance.mSubcategory;
    this.mSuggestedEventsSetting = instance.mSuggestedEventsSetting;
    this.mSupportedPlatforms = instance.mSupportedPlatforms;
    this.mSupportsApprequestsFastAppSwitch = instance.mSupportsApprequestsFastAppSwitch;
    this.mSupportsAttribution = instance.mSupportsAttribution;
    this.mSupportsImplicitSdkLogging = instance.mSupportsImplicitSdkLogging;
    this.mSuppressNativeIosGdp = instance.mSuppressNativeIosGdp;
    this.mTermsOfServiceUrl = instance.mTermsOfServiceUrl;
    this.mUrlSchemeSuffix = instance.mUrlSchemeSuffix;
    this.mUserSupportEmail = instance.mUserSupportEmail;
    this.mUserSupportUrl = instance.mUserSupportUrl;
    this.mWebsiteUrl = instance.mWebsiteUrl;
    this.mWeeklyActiveUsers = instance.mWeeklyActiveUsers;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Application> getParser() {
    return new APIRequest.ResponseParser<Application>() {
      public APINodeList<Application> parseResponse(String response, APIContext context, APIRequest<Application> request, String header) throws MalformedResponseException {
        return Application.parseResponse(response, context, request, header);
      }
    };
  }
}
