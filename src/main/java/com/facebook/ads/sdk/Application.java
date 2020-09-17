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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
  @SerializedName("login_secret")
  private String mLoginSecret = null;
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

  public APIRequestGetAdNetworkAnalytics getAdNetworkAnalytics() {
    return new APIRequestGetAdNetworkAnalytics(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdNetworkAnalytic createAdNetworkAnalytic() {
    return new APIRequestCreateAdNetworkAnalytic(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkAnalyticsResults getAdNetworkAnalyticsResults() {
    return new APIRequestGetAdNetworkAnalyticsResults(this.getPrefixedId().toString(), context);
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

  public APIRequestGetAppEventTypes getAppEventTypes() {
    return new APIRequestGetAppEventTypes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAppIndexing createAppIndexing() {
    return new APIRequestCreateAppIndexing(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAppIndexingSession createAppIndexingSession() {
    return new APIRequestCreateAppIndexingSession(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAppInsights getAppInsights() {
    return new APIRequestGetAppInsights(this.getPrefixedId().toString(), context);
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

  public APIRequestDeleteBanned deleteBanned() {
    return new APIRequestDeleteBanned(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetButtonAutoDetectionDeviceSelection getButtonAutoDetectionDeviceSelection() {
    return new APIRequestGetButtonAutoDetectionDeviceSelection(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateButtonIndexing createButtonIndexing() {
    return new APIRequestCreateButtonIndexing(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCodelessEventMapping createCodelessEventMapping() {
    return new APIRequestCreateCodelessEventMapping(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDaChecks getDaChecks() {
    return new APIRequestGetDaChecks(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEvents getEvents() {
    return new APIRequestGetEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsPushSchedule getInsightsPushSchedule() {
    return new APIRequestGetInsightsPushSchedule(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInsightsPushSchedule createInsightsPushSchedule() {
    return new APIRequestCreateInsightsPushSchedule(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetIosDialogConfigs getIosDialogConfigs() {
    return new APIRequestGetIosDialogConfigs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeaderboardsCreate createLeaderboardsCreate() {
    return new APIRequestCreateLeaderboardsCreate(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeaderboardsDeleteEntry createLeaderboardsDeleteEntry() {
    return new APIRequestCreateLeaderboardsDeleteEntry(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeaderboardsReset createLeaderboardsReset() {
    return new APIRequestCreateLeaderboardsReset(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeaderboardsSetScore createLeaderboardsSetScore() {
    return new APIRequestCreateLeaderboardsSetScore(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveVideos getLiveVideos() {
    return new APIRequestGetLiveVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMmpAuditing createMmpAuditing() {
    return new APIRequestCreateMmpAuditing(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMobileSdkGk getMobileSdkGk() {
    return new APIRequestGetMobileSdkGk(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOccludesPopup createOccludesPopup() {
    return new APIRequestCreateOccludesPopup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOzoneRelease getOzoneRelease() {
    return new APIRequestGetOzoneRelease(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePageActivity createPageActivity() {
    return new APIRequestCreatePageActivity(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeletePaymentCurrencies deletePaymentCurrencies() {
    return new APIRequestDeletePaymentCurrencies(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateUserProperty createUserProperty() {
    return new APIRequestCreateUserProperty(this.getPrefixedId().toString(), context);
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

  public String getFieldLoginSecret() {
    return mLoginSecret;
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
         }
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
         }
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
         }
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
      "ud",
      "url_schemes",
      "user_id",
      "user_id_type",
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
         }
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
         }
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
         }
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
         }
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
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "is_instagram_enabled_in_fb_analytics",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
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
         }
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
    public APIRequestGetAgencies requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetAgencies requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
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
         }
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
         }
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
         }
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
         }
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
         }
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

  public static class APIRequestGetAppInsights extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregateBy",
      "breakdowns",
      "ecosystem",
      "event_name",
      "intervals_to_aggregate",
      "metric_key",
      "period",
      "since",
      "until",
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
               return APIRequestGetAppInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAppInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/app_insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAppInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAppInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAppInsights setAggregateby (EnumAggregateby aggregateby) {
      this.setParam("aggregateBy", aggregateby);
      return this;
    }
    public APIRequestGetAppInsights setAggregateby (String aggregateby) {
      this.setParam("aggregateBy", aggregateby);
      return this;
    }

    public APIRequestGetAppInsights setBreakdowns (List<String> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetAppInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetAppInsights setEcosystem (EnumEcosystem ecosystem) {
      this.setParam("ecosystem", ecosystem);
      return this;
    }
    public APIRequestGetAppInsights setEcosystem (String ecosystem) {
      this.setParam("ecosystem", ecosystem);
      return this;
    }

    public APIRequestGetAppInsights setEventName (String eventName) {
      this.setParam("event_name", eventName);
      return this;
    }

    public APIRequestGetAppInsights setIntervalsToAggregate (Long intervalsToAggregate) {
      this.setParam("intervals_to_aggregate", intervalsToAggregate);
      return this;
    }
    public APIRequestGetAppInsights setIntervalsToAggregate (String intervalsToAggregate) {
      this.setParam("intervals_to_aggregate", intervalsToAggregate);
      return this;
    }

    public APIRequestGetAppInsights setMetricKey (String metricKey) {
      this.setParam("metric_key", metricKey);
      return this;
    }

    public APIRequestGetAppInsights setPeriod (EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetAppInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetAppInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetAppInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetAppInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAppInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAppInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAppInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAppInsights requestField (String field, boolean value) {
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
      "link",
      "member_count",
      "member_request_count",
      "name",
      "owner",
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
         }
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
    public APIRequestGetAppInstalledGroups requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAppInstalledGroups requestOwnerField (boolean value) {
      this.requestField("owner", value);
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
         }
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
         }
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
         }
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
      "ad_account_creation_request",
      "ad_account_promotable_objects",
      "age",
      "agency_client_declaration",
      "amount_spent",
      "attribution_spec",
      "balance",
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
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
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
      "is_in_middle_of_local_entity_migration",
      "is_notifications_enabled",
      "is_personal",
      "is_prepay_account",
      "is_tax_id_required",
      "line_numbers",
      "media_agency",
      "min_campaign_group_spend_cap",
      "min_daily_budget",
      "name",
      "offsite_pixels_tos_accepted",
      "owner",
      "partner",
      "rf_spec",
      "show_checkout_experience",
      "spend_cap",
      "tax_id",
      "tax_id_status",
      "tax_id_type",
      "timezone_id",
      "timezone_name",
      "timezone_offset_hours_utc",
      "tos_accepted",
      "user_tasks",
      "user_tos_accepted",
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
         }
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
    public APIRequestGetAuthorizedAdAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
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
    public APIRequestGetAuthorizedAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
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
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
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
  }

  public static class APIRequestDeleteBanned extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uids",
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
               return APIRequestDeleteBanned.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteBanned(String nodeId, APIContext context) {
      super(context, nodeId, "/banned", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteBanned setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteBanned setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteBanned setUids (List<Long> uids) {
      this.setParam("uids", uids);
      return this;
    }
    public APIRequestDeleteBanned setUids (String uids) {
      this.setParam("uids", uids);
      return this;
    }

    public APIRequestDeleteBanned requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteBanned requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBanned requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteBanned requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBanned requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteBanned requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
         }
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

  public static class APIRequestCreateButtonIndexing extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_version",
      "device_id",
      "extinfo",
      "indexed_button_list",
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
               return APIRequestCreateButtonIndexing.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateButtonIndexing(String nodeId, APIContext context) {
      super(context, nodeId, "/button_indexing", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateButtonIndexing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateButtonIndexing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateButtonIndexing setAppVersion (String appVersion) {
      this.setParam("app_version", appVersion);
      return this;
    }

    public APIRequestCreateButtonIndexing setDeviceId (String deviceId) {
      this.setParam("device_id", deviceId);
      return this;
    }

    public APIRequestCreateButtonIndexing setExtinfo (String extinfo) {
      this.setParam("extinfo", extinfo);
      return this;
    }

    public APIRequestCreateButtonIndexing setIndexedButtonList (List<Map<String, String>> indexedButtonList) {
      this.setParam("indexed_button_list", indexedButtonList);
      return this;
    }
    public APIRequestCreateButtonIndexing setIndexedButtonList (String indexedButtonList) {
      this.setParam("indexed_button_list", indexedButtonList);
      return this;
    }

    public APIRequestCreateButtonIndexing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateButtonIndexing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateButtonIndexing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateButtonIndexing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateButtonIndexing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateButtonIndexing requestField (String field, boolean value) {
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
         }
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
         }
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

  public static class APIRequestGetEvents extends APIRequest<Event> {

    APINodeList<Event> lastResponse = null;
    @Override
    public APINodeList<Event> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_canceled",
      "type",
    };

    public static final String[] FIELDS = {
      "attending_count",
      "can_guests_invite",
      "category",
      "cover",
      "declined_count",
      "description",
      "discount_code_enabled",
      "end_time",
      "event_times",
      "guest_list_enabled",
      "id",
      "interested_count",
      "is_canceled",
      "is_draft",
      "is_online",
      "is_page_owned",
      "maybe_count",
      "name",
      "noreply_count",
      "online_event_format",
      "online_event_third_party_url",
      "owner",
      "parent_group",
      "place",
      "scheduled_publish_time",
      "start_time",
      "ticket_uri",
      "ticket_uri_start_sales_time",
      "ticketing_privacy_uri",
      "ticketing_terms_uri",
      "timezone",
      "type",
      "updated_time",
    };

    @Override
    public APINodeList<Event> parseResponse(String response, String header) throws APIException {
      return Event.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Event> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Event> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Event>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Event>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Event>>() {
           public APINodeList<Event> apply(ResponseWrapper result) {
             try {
               return APIRequestGetEvents.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEvents setIncludeCanceled (Boolean includeCanceled) {
      this.setParam("include_canceled", includeCanceled);
      return this;
    }
    public APIRequestGetEvents setIncludeCanceled (String includeCanceled) {
      this.setParam("include_canceled", includeCanceled);
      return this;
    }

    public APIRequestGetEvents setType (Event.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetEvents setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEvents requestAttendingCountField () {
      return this.requestAttendingCountField(true);
    }
    public APIRequestGetEvents requestAttendingCountField (boolean value) {
      this.requestField("attending_count", value);
      return this;
    }
    public APIRequestGetEvents requestCanGuestsInviteField () {
      return this.requestCanGuestsInviteField(true);
    }
    public APIRequestGetEvents requestCanGuestsInviteField (boolean value) {
      this.requestField("can_guests_invite", value);
      return this;
    }
    public APIRequestGetEvents requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetEvents requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetEvents requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetEvents requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetEvents requestDeclinedCountField () {
      return this.requestDeclinedCountField(true);
    }
    public APIRequestGetEvents requestDeclinedCountField (boolean value) {
      this.requestField("declined_count", value);
      return this;
    }
    public APIRequestGetEvents requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetEvents requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField () {
      return this.requestDiscountCodeEnabledField(true);
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField (boolean value) {
      this.requestField("discount_code_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetEvents requestEventTimesField () {
      return this.requestEventTimesField(true);
    }
    public APIRequestGetEvents requestEventTimesField (boolean value) {
      this.requestField("event_times", value);
      return this;
    }
    public APIRequestGetEvents requestGuestListEnabledField () {
      return this.requestGuestListEnabledField(true);
    }
    public APIRequestGetEvents requestGuestListEnabledField (boolean value) {
      this.requestField("guest_list_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetEvents requestInterestedCountField () {
      return this.requestInterestedCountField(true);
    }
    public APIRequestGetEvents requestInterestedCountField (boolean value) {
      this.requestField("interested_count", value);
      return this;
    }
    public APIRequestGetEvents requestIsCanceledField () {
      return this.requestIsCanceledField(true);
    }
    public APIRequestGetEvents requestIsCanceledField (boolean value) {
      this.requestField("is_canceled", value);
      return this;
    }
    public APIRequestGetEvents requestIsDraftField () {
      return this.requestIsDraftField(true);
    }
    public APIRequestGetEvents requestIsDraftField (boolean value) {
      this.requestField("is_draft", value);
      return this;
    }
    public APIRequestGetEvents requestIsOnlineField () {
      return this.requestIsOnlineField(true);
    }
    public APIRequestGetEvents requestIsOnlineField (boolean value) {
      this.requestField("is_online", value);
      return this;
    }
    public APIRequestGetEvents requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGetEvents requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGetEvents requestMaybeCountField () {
      return this.requestMaybeCountField(true);
    }
    public APIRequestGetEvents requestMaybeCountField (boolean value) {
      this.requestField("maybe_count", value);
      return this;
    }
    public APIRequestGetEvents requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetEvents requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetEvents requestNoreplyCountField () {
      return this.requestNoreplyCountField(true);
    }
    public APIRequestGetEvents requestNoreplyCountField (boolean value) {
      this.requestField("noreply_count", value);
      return this;
    }
    public APIRequestGetEvents requestOnlineEventFormatField () {
      return this.requestOnlineEventFormatField(true);
    }
    public APIRequestGetEvents requestOnlineEventFormatField (boolean value) {
      this.requestField("online_event_format", value);
      return this;
    }
    public APIRequestGetEvents requestOnlineEventThirdPartyUrlField () {
      return this.requestOnlineEventThirdPartyUrlField(true);
    }
    public APIRequestGetEvents requestOnlineEventThirdPartyUrlField (boolean value) {
      this.requestField("online_event_third_party_url", value);
      return this;
    }
    public APIRequestGetEvents requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetEvents requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetEvents requestParentGroupField () {
      return this.requestParentGroupField(true);
    }
    public APIRequestGetEvents requestParentGroupField (boolean value) {
      this.requestField("parent_group", value);
      return this;
    }
    public APIRequestGetEvents requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetEvents requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetEvents requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetEvents requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriField () {
      return this.requestTicketUriField(true);
    }
    public APIRequestGetEvents requestTicketUriField (boolean value) {
      this.requestField("ticket_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField () {
      return this.requestTicketUriStartSalesTimeField(true);
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField (boolean value) {
      this.requestField("ticket_uri_start_sales_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField () {
      return this.requestTicketingPrivacyUriField(true);
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField (boolean value) {
      this.requestField("ticketing_privacy_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingTermsUriField () {
      return this.requestTicketingTermsUriField(true);
    }
    public APIRequestGetEvents requestTicketingTermsUriField (boolean value) {
      this.requestField("ticketing_terms_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetEvents requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetEvents requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetEvents requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetEvents requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetEvents requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetInsightsPushSchedule extends APIRequest<APINode> {

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
               return APIRequestGetInsightsPushSchedule.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsightsPushSchedule(String nodeId, APIContext context) {
      super(context, nodeId, "/insights_push_schedule", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsPushSchedule setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsPushSchedule setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsPushSchedule requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsPushSchedule requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsPushSchedule requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsPushSchedule requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsPushSchedule requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsPushSchedule requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateInsightsPushSchedule extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account_ids",
      "breakdowns",
      "date_preset",
      "level",
      "metrics",
      "object_id",
      "owner_id",
      "schedule",
      "status",
      "time_increment",
      "time_start",
      "time_stop",
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
               return APIRequestCreateInsightsPushSchedule.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateInsightsPushSchedule(String nodeId, APIContext context) {
      super(context, nodeId, "/insights_push_schedule", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInsightsPushSchedule setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInsightsPushSchedule setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInsightsPushSchedule setAdAccountIds (JsonArray adAccountIds) {
      this.setParam("ad_account_ids", adAccountIds);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setAdAccountIds (String adAccountIds) {
      this.setParam("ad_account_ids", adAccountIds);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setBreakdowns (List<String> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setLevel (EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setMetrics (List<String> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setOwnerId (Long ownerId) {
      this.setParam("owner_id", ownerId);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setOwnerId (String ownerId) {
      this.setParam("owner_id", ownerId);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setSchedule (EnumSchedule schedule) {
      this.setParam("schedule", schedule);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setSchedule (String schedule) {
      this.setParam("schedule", schedule);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setTimeIncrement (Long timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }
    public APIRequestCreateInsightsPushSchedule setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule setTimeStop (String timeStop) {
      this.setParam("time_stop", timeStop);
      return this;
    }

    public APIRequestCreateInsightsPushSchedule requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInsightsPushSchedule requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInsightsPushSchedule requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInsightsPushSchedule requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInsightsPushSchedule requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInsightsPushSchedule requestField (String field, boolean value) {
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
         }
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

  public static class APIRequestCreateLeaderboardsCreate extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "context_id",
      "decimal_offset",
      "name",
      "score_type",
      "sort_order",
      "unit",
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
               return APIRequestCreateLeaderboardsCreate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeaderboardsCreate(String nodeId, APIContext context) {
      super(context, nodeId, "/leaderboards_create", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeaderboardsCreate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsCreate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeaderboardsCreate setContextId (String contextId) {
      this.setParam("context_id", contextId);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate setDecimalOffset (Long decimalOffset) {
      this.setParam("decimal_offset", decimalOffset);
      return this;
    }
    public APIRequestCreateLeaderboardsCreate setDecimalOffset (String decimalOffset) {
      this.setParam("decimal_offset", decimalOffset);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate setScoreType (Application.EnumScoreType scoreType) {
      this.setParam("score_type", scoreType);
      return this;
    }
    public APIRequestCreateLeaderboardsCreate setScoreType (String scoreType) {
      this.setParam("score_type", scoreType);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate setSortOrder (Application.EnumSortOrder sortOrder) {
      this.setParam("sort_order", sortOrder);
      return this;
    }
    public APIRequestCreateLeaderboardsCreate setSortOrder (String sortOrder) {
      this.setParam("sort_order", sortOrder);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate setUnit (String unit) {
      this.setParam("unit", unit);
      return this;
    }

    public APIRequestCreateLeaderboardsCreate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeaderboardsCreate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsCreate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeaderboardsCreate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsCreate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsCreate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeaderboardsDeleteEntry extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "player_id",
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
               return APIRequestCreateLeaderboardsDeleteEntry.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeaderboardsDeleteEntry(String nodeId, APIContext context) {
      super(context, nodeId, "/leaderboards_delete_entry", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeaderboardsDeleteEntry setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeaderboardsDeleteEntry setPlayerId (String playerId) {
      this.setParam("player_id", playerId);
      return this;
    }

    public APIRequestCreateLeaderboardsDeleteEntry requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeaderboardsDeleteEntry requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsDeleteEntry requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeaderboardsReset extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "reset_time",
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
               return APIRequestCreateLeaderboardsReset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeaderboardsReset(String nodeId, APIContext context) {
      super(context, nodeId, "/leaderboards_reset", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeaderboardsReset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsReset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeaderboardsReset setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeaderboardsReset setResetTime (String resetTime) {
      this.setParam("reset_time", resetTime);
      return this;
    }

    public APIRequestCreateLeaderboardsReset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeaderboardsReset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsReset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeaderboardsReset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsReset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsReset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeaderboardsSetScore extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "extra_data",
      "name",
      "player_id",
      "score",
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
               return APIRequestCreateLeaderboardsSetScore.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeaderboardsSetScore(String nodeId, APIContext context) {
      super(context, nodeId, "/leaderboards_set_score", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeaderboardsSetScore setExtraData (String extraData) {
      this.setParam("extra_data", extraData);
      return this;
    }

    public APIRequestCreateLeaderboardsSetScore setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeaderboardsSetScore setPlayerId (String playerId) {
      this.setParam("player_id", playerId);
      return this;
    }

    public APIRequestCreateLeaderboardsSetScore setScore (Long score) {
      this.setParam("score", score);
      return this;
    }
    public APIRequestCreateLeaderboardsSetScore setScore (String score) {
      this.setParam("score", score);
      return this;
    }

    public APIRequestCreateLeaderboardsSetScore requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeaderboardsSetScore requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeaderboardsSetScore requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLiveVideos extends APIRequest<LiveVideo> {

    APINodeList<LiveVideo> lastResponse = null;
    @Override
    public APINodeList<LiveVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "broadcast_status",
    };

    public static final String[] FIELDS = {
      "ad_break_config",
      "ad_break_failure_reason",
      "broadcast_start_time",
      "copyright",
      "creation_time",
      "dash_ingest_url",
      "dash_preview_url",
      "description",
      "embed_html",
      "from",
      "id",
      "ingest_streams",
      "is_manual_mode",
      "is_reference_only",
      "live_encoders",
      "live_views",
      "overlay_url",
      "permalink_url",
      "planned_start_time",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "targeting",
      "title",
      "total_views",
      "video",
    };

    @Override
    public APINodeList<LiveVideo> parseResponse(String response, String header) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<LiveVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LiveVideo> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<LiveVideo>>() {
           public APINodeList<LiveVideo> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLiveVideos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLiveVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/live_videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveVideos setBroadcastStatus (LiveVideo.EnumBroadcastStatus broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
      return this;
    }
    public APIRequestGetLiveVideos setBroadcastStatus (String broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
      return this;
    }

    public APIRequestGetLiveVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLiveVideos requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGetLiveVideos requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetLiveVideos requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLiveVideos requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGetLiveVideos requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetLiveVideos requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveVideos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIngestStreamsField () {
      return this.requestIngestStreamsField(true);
    }
    public APIRequestGetLiveVideos requestIngestStreamsField (boolean value) {
      this.requestField("ingest_streams", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGetLiveVideos requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveEncodersField () {
      return this.requestLiveEncodersField(true);
    }
    public APIRequestGetLiveVideos requestLiveEncodersField (boolean value) {
      this.requestField("live_encoders", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGetLiveVideos requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGetLiveVideos requestOverlayUrlField () {
      return this.requestOverlayUrlField(true);
    }
    public APIRequestGetLiveVideos requestOverlayUrlField (boolean value) {
      this.requestField("overlay_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGetLiveVideos requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetLiveVideos requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetLiveVideos requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetLiveVideos requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTotalViewsField () {
      return this.requestTotalViewsField(true);
    }
    public APIRequestGetLiveVideos requestTotalViewsField (boolean value) {
      this.requestField("total_views", value);
      return this;
    }
    public APIRequestGetLiveVideos requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetLiveVideos requestVideoField (boolean value) {
      this.requestField("video", value);
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
      "event",
      "event_reported_time",
      "fb_ad_id",
      "fb_click_time",
      "fb_view_time",
      "is_fb",
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
         }
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
         }
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
         }
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

  public static class APIRequestGetOzoneRelease extends APIRequest<APINode> {

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
               return APIRequestGetOzoneRelease.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOzoneRelease(String nodeId, APIContext context) {
      super(context, nodeId, "/ozone_release", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOzoneRelease setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOzoneRelease setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOzoneRelease requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOzoneRelease requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOzoneRelease requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOzoneRelease requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOzoneRelease requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOzoneRelease requestField (String field, boolean value) {
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
         }
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

  public static class APIRequestDeletePaymentCurrencies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "currency_url",
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
               return APIRequestDeletePaymentCurrencies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeletePaymentCurrencies(String nodeId, APIContext context) {
      super(context, nodeId, "/payment_currencies", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeletePaymentCurrencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeletePaymentCurrencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeletePaymentCurrencies setCurrencyUrl (String currencyUrl) {
      this.setParam("currency_url", currencyUrl);
      return this;
    }

    public APIRequestDeletePaymentCurrencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeletePaymentCurrencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePaymentCurrencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeletePaymentCurrencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePaymentCurrencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeletePaymentCurrencies requestField (String field, boolean value) {
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
         }
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
         }
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
         }
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
      "is_premium",
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
         }
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


    public APIRequestGetPurchases setIsPremium (Boolean isPremium) {
      this.setParam("is_premium", isPremium);
      return this;
    }
    public APIRequestGetPurchases setIsPremium (String isPremium) {
      this.setParam("is_premium", isPremium);
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
         }
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
         }
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
         }
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
         }
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
         }
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
         }
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
         }
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
         }
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

  public static class APIRequestCreateUserProperty extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "data",
      "limited_data_use",
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
               return APIRequestCreateUserProperty.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserProperty(String nodeId, APIContext context) {
      super(context, nodeId, "/user_properties", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserProperty setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserProperty setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserProperty setData (List<Object> data) {
      this.setParam("data", data);
      return this;
    }
    public APIRequestCreateUserProperty setData (String data) {
      this.setParam("data", data);
      return this;
    }

    public APIRequestCreateUserProperty setLimitedDataUse (Boolean limitedDataUse) {
      this.setParam("limited_data_use", limitedDataUse);
      return this;
    }
    public APIRequestCreateUserProperty setLimitedDataUse (String limitedDataUse) {
      this.setParam("limited_data_use", limitedDataUse);
      return this;
    }

    public APIRequestCreateUserProperty requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserProperty requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserProperty requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserProperty requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserProperty requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserProperty requestField (String field, boolean value) {
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
      "login_secret",
      "logo_url",
      "migrations",
      "mobile_profile_section_url",
      "mobile_web_url",
      "monthly_active_users",
      "monthly_active_users_rank",
      "name",
      "namespace",
      "object_store_urls",
      "page_tab_default_name",
      "page_tab_url",
      "photo_url",
      "privacy_policy_url",
      "profile_section_url",
      "property_id",
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
         }
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
    public APIRequestGet requestLoginSecretField () {
      return this.requestLoginSecretField(true);
    }
    public APIRequestGet requestLoginSecretField (boolean value) {
      this.requestField("login_secret", value);
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
      "an_platforms",
      "android_class_name",
      "android_key_hashes",
      "android_package_name",
      "android_sso",
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
      "ios_bundle_id",
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
         }
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


    public APIRequestUpdate setAnPlatforms (List<Application.EnumAnPlatforms> anPlatforms) {
      this.setParam("an_platforms", anPlatforms);
      return this;
    }
    public APIRequestUpdate setAnPlatforms (String anPlatforms) {
      this.setParam("an_platforms", anPlatforms);
      return this;
    }

    public APIRequestUpdate setAndroidClassName (String androidClassName) {
      this.setParam("android_class_name", androidClassName);
      return this;
    }

    public APIRequestUpdate setAndroidKeyHashes (List<String> androidKeyHashes) {
      this.setParam("android_key_hashes", androidKeyHashes);
      return this;
    }
    public APIRequestUpdate setAndroidKeyHashes (String androidKeyHashes) {
      this.setParam("android_key_hashes", androidKeyHashes);
      return this;
    }

    public APIRequestUpdate setAndroidPackageName (String androidPackageName) {
      this.setParam("android_package_name", androidPackageName);
      return this;
    }

    public APIRequestUpdate setAndroidSso (Boolean androidSso) {
      this.setParam("android_sso", androidSso);
      return this;
    }
    public APIRequestUpdate setAndroidSso (String androidSso) {
      this.setParam("android_sso", androidSso);
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

    public APIRequestUpdate setIosBundleId (List<String> iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }
    public APIRequestUpdate setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
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
      @SerializedName("SUPPLEMENTARY_IMAGES")
      VALUE_SUPPLEMENTARY_IMAGES("SUPPLEMENTARY_IMAGES"),
      @SerializedName("WEB")
      VALUE_WEB("WEB"),
      @SerializedName("WINDOWS")
      VALUE_WINDOWS("WINDOWS"),
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
      @SerializedName("INSTANT_ARTICLES")
      VALUE_INSTANT_ARTICLES("INSTANT_ARTICLES"),
      @SerializedName("IOS")
      VALUE_IOS("IOS"),
      @SerializedName("MOBILE_WEB")
      VALUE_MOBILE_WEB("MOBILE_WEB"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
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

  public static enum EnumScoreType {
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("NUMERIC")
      VALUE_NUMERIC("NUMERIC"),
      @SerializedName("TIME")
      VALUE_TIME("TIME"),
      ;

      private String value;

      private EnumScoreType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSortOrder {
      @SerializedName("HIGHER_IS_BETTER")
      VALUE_HIGHER_IS_BETTER("HIGHER_IS_BETTER"),
      @SerializedName("LOWER_IS_BETTER")
      VALUE_LOWER_IS_BETTER("LOWER_IS_BETTER"),
      ;

      private String value;

      private EnumSortOrder(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLoggingSource {
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

  public static enum EnumAggregateby {
      @SerializedName("AVERAGE_JOURNEY_LENGTH")
      VALUE_AVERAGE_JOURNEY_LENGTH("AVERAGE_JOURNEY_LENGTH"),
      @SerializedName("CONVERTED_JOURNEY_PERCENT")
      VALUE_CONVERTED_JOURNEY_PERCENT("CONVERTED_JOURNEY_PERCENT"),
      @SerializedName("COUNT")
      VALUE_COUNT("COUNT"),
      @SerializedName("COUNT_IDENTIFIED_USERS")
      VALUE_COUNT_IDENTIFIED_USERS("COUNT_IDENTIFIED_USERS"),
      @SerializedName("COUNT_PER_USER")
      VALUE_COUNT_PER_USER("COUNT_PER_USER"),
      @SerializedName("DAU")
      VALUE_DAU("DAU"),
      @SerializedName("EVENT_LATEST_FIRE_TIME")
      VALUE_EVENT_LATEST_FIRE_TIME("EVENT_LATEST_FIRE_TIME"),
      @SerializedName("EVENT_SOURCE_IDS")
      VALUE_EVENT_SOURCE_IDS("EVENT_SOURCE_IDS"),
      @SerializedName("JOURNEY_CHANNEL_INCLUSION")
      VALUE_JOURNEY_CHANNEL_INCLUSION("JOURNEY_CHANNEL_INCLUSION"),
      @SerializedName("JOURNEY_INCLUSION")
      VALUE_JOURNEY_INCLUSION("JOURNEY_INCLUSION"),
      @SerializedName("MAU")
      VALUE_MAU("MAU"),
      @SerializedName("MEDIAN_JOURNEY_LENGTH")
      VALUE_MEDIAN_JOURNEY_LENGTH("MEDIAN_JOURNEY_LENGTH"),
      @SerializedName("MEDIAN_VALUE")
      VALUE_MEDIAN_VALUE("MEDIAN_VALUE"),
      @SerializedName("MEDIAN_VALUE_PER_USER")
      VALUE_MEDIAN_VALUE_PER_USER("MEDIAN_VALUE_PER_USER"),
      @SerializedName("OVERLAP")
      VALUE_OVERLAP("OVERLAP"),
      @SerializedName("PERCENTILES_COUNT")
      VALUE_PERCENTILES_COUNT("PERCENTILES_COUNT"),
      @SerializedName("PERCENTILES_USD_VALUE")
      VALUE_PERCENTILES_USD_VALUE("PERCENTILES_USD_VALUE"),
      @SerializedName("PERCENTILES_VALUE")
      VALUE_PERCENTILES_VALUE("PERCENTILES_VALUE"),
      @SerializedName("SCORE")
      VALUE_SCORE("SCORE"),
      @SerializedName("SESSIONS_PER_JOURNEY")
      VALUE_SESSIONS_PER_JOURNEY("SESSIONS_PER_JOURNEY"),
      @SerializedName("SESSION_BOUNCE_RATE")
      VALUE_SESSION_BOUNCE_RATE("SESSION_BOUNCE_RATE"),
      @SerializedName("SUM")
      VALUE_SUM("SUM"),
      @SerializedName("SUM_IDENTIFIED_USERS")
      VALUE_SUM_IDENTIFIED_USERS("SUM_IDENTIFIED_USERS"),
      @SerializedName("SUM_PER_EVENT")
      VALUE_SUM_PER_EVENT("SUM_PER_EVENT"),
      @SerializedName("TOPK")
      VALUE_TOPK("TOPK"),
      @SerializedName("UNKNOWN_USERS")
      VALUE_UNKNOWN_USERS("UNKNOWN_USERS"),
      @SerializedName("USD_SUM")
      VALUE_USD_SUM("USD_SUM"),
      @SerializedName("USD_SUM_IDENTIFIED_USERS")
      VALUE_USD_SUM_IDENTIFIED_USERS("USD_SUM_IDENTIFIED_USERS"),
      @SerializedName("USD_SUM_PER_EVENT")
      VALUE_USD_SUM_PER_EVENT("USD_SUM_PER_EVENT"),
      @SerializedName("USD_SUM_PER_USER")
      VALUE_USD_SUM_PER_USER("USD_SUM_PER_USER"),
      @SerializedName("USD_VALUE_PER_USER")
      VALUE_USD_VALUE_PER_USER("USD_VALUE_PER_USER"),
      @SerializedName("USERS")
      VALUE_USERS("USERS"),
      @SerializedName("USER_PROPERTY_USER_COUNT")
      VALUE_USER_PROPERTY_USER_COUNT("USER_PROPERTY_USER_COUNT"),
      @SerializedName("VALUE_PER_USER")
      VALUE_VALUE_PER_USER("VALUE_PER_USER"),
      @SerializedName("WAU")
      VALUE_WAU("WAU"),
      ;

      private String value;

      private EnumAggregateby(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEcosystem {
      @SerializedName("GAME")
      VALUE_GAME("GAME"),
      @SerializedName("NON_GAME")
      VALUE_NON_GAME("NON_GAME"),
      ;

      private String value;

      private EnumEcosystem(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("daily")
      VALUE_DAILY("daily"),
      @SerializedName("days_28")
      VALUE_DAYS_28("days_28"),
      @SerializedName("days_60")
      VALUE_DAYS_60("days_60"),
      @SerializedName("days_90")
      VALUE_DAYS_90("days_90"),
      @SerializedName("hourly")
      VALUE_HOURLY("hourly"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("mins_15")
      VALUE_MINS_15("mins_15"),
      @SerializedName("monthly")
      VALUE_MONTHLY("monthly"),
      @SerializedName("range")
      VALUE_RANGE("range"),
      @SerializedName("weekly")
      VALUE_WEEKLY("weekly"),
      ;

      private String value;

      private EnumPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLevel {
      @SerializedName("ACCOUNT")
      VALUE_ACCOUNT("ACCOUNT"),
      @SerializedName("AD")
      VALUE_AD("AD"),
      @SerializedName("ADSET")
      VALUE_ADSET("ADSET"),
      @SerializedName("CAMPAIGN")
      VALUE_CAMPAIGN("CAMPAIGN"),
      ;

      private String value;

      private EnumLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSchedule {
      @SerializedName("DAILY")
      VALUE_DAILY("DAILY"),
      @SerializedName("FINE_15_MIN")
      VALUE_FINE_15_MIN("FINE_15_MIN"),
      @SerializedName("FINE_5_MIN")
      VALUE_FINE_5_MIN("FINE_5_MIN"),
      @SerializedName("MONTHLY")
      VALUE_MONTHLY("MONTHLY"),
      @SerializedName("WEEKLY")
      VALUE_WEEKLY("WEEKLY"),
      ;

      private String value;

      private EnumSchedule(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("ERROR")
      VALUE_ERROR("ERROR"),
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
    this.mLoginSecret = instance.mLoginSecret;
    this.mLogoUrl = instance.mLogoUrl;
    this.mMigrations = instance.mMigrations;
    this.mMobileProfileSectionUrl = instance.mMobileProfileSectionUrl;
    this.mMobileWebUrl = instance.mMobileWebUrl;
    this.mMonthlyActiveUsers = instance.mMonthlyActiveUsers;
    this.mMonthlyActiveUsersRank = instance.mMonthlyActiveUsersRank;
    this.mName = instance.mName;
    this.mNamespace = instance.mNamespace;
    this.mObjectStoreUrls = instance.mObjectStoreUrls;
    this.mPageTabDefaultName = instance.mPageTabDefaultName;
    this.mPageTabUrl = instance.mPageTabUrl;
    this.mPhotoUrl = instance.mPhotoUrl;
    this.mPrivacyPolicyUrl = instance.mPrivacyPolicyUrl;
    this.mProfileSectionUrl = instance.mProfileSectionUrl;
    this.mPropertyId = instance.mPropertyId;
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
