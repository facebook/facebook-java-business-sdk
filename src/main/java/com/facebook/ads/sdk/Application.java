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
      };
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

  public APIRequestGetBanned getBanned() {
    return new APIRequestGetBanned(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetButtonAutoDetectionDeviceSelection getButtonAutoDetectionDeviceSelection() {
    return new APIRequestGetButtonAutoDetectionDeviceSelection(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateButtonIndexing createButtonIndexing() {
    return new APIRequestCreateButtonIndexing(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCodelessEventBinding createCodelessEventBinding() {
    return new APIRequestCreateCodelessEventBinding(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCodelessEventMapping createCodelessEventMapping() {
    return new APIRequestCreateCodelessEventMapping(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomAudienceThirdPartyId getCustomAudienceThirdPartyId() {
    return new APIRequestGetCustomAudienceThirdPartyId(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDaChecks getDaChecks() {
    return new APIRequestGetDaChecks(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEvents getEvents() {
    return new APIRequestGetEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFullAppIndexingInfos getFullAppIndexingInfos() {
    return new APIRequestGetFullAppIndexingInfos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFullAppIndexingInfo createFullAppIndexingInfo() {
    return new APIRequestCreateFullAppIndexingInfo(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateMmpAuditing createMmpAuditing() {
    return new APIRequestCreateMmpAuditing(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMobileSdkGk getMobileSdkGk() {
    return new APIRequestGetMobileSdkGk(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMoodsForApplication getMoodsForApplication() {
    return new APIRequestGetMoodsForApplication(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateObject createObject() {
    return new APIRequestCreateObject(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOccludesPopup createOccludesPopup() {
    return new APIRequestCreateOccludesPopup(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOzoneRelease createOzoneRelease() {
    return new APIRequestCreateOzoneRelease(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateStagingResource createStagingResource() {
    return new APIRequestCreateStagingResource(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateSubscriptionsSample createSubscriptionsSample() {
    return new APIRequestCreateSubscriptionsSample(this.getPrefixedId().toString(), context);
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
      "consider_views",
      "custom_events",
      "custom_events_file",
      "device_token",
      "event",
      "extinfo",
      "include_dwell_data",
      "include_video_data",
      "install_referrer",
      "installer_package",
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

    public APIRequestCreateActivity setInstallerPackage (String installerPackage) {
      this.setParam("installer_package", installerPackage);
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
      "user_role",
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
    public APIRequestGetAuthorizedAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
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

  public static class APIRequestGetBanned extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_shared_login",
      "is_verified",
      "labels",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBanned.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBanned(String nodeId, APIContext context) {
      super(context, nodeId, "/banned", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBanned setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBanned setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBanned setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetBanned setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetBanned requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBanned requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBanned requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBanned requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBanned requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBanned requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBanned requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetBanned requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetBanned requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetBanned requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetBanned requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetBanned requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetBanned requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetBanned requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetBanned requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetBanned requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetBanned requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetBanned requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetBanned requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetBanned requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetBanned requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetBanned requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetBanned requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBanned requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBanned requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetBanned requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetBanned requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetBanned requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetBanned requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetBanned requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetBanned requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetBanned requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetBanned requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetBanned requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetBanned requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetBanned requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetBanned requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetBanned requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetBanned requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetBanned requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetBanned requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBanned requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBanned requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetBanned requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetBanned requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetBanned requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetBanned requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetBanned requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetBanned requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetBanned requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetBanned requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetBanned requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetBanned requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetBanned requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetBanned requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetBanned requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetBanned requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetBanned requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetBanned requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetBanned requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetBanned requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetBanned requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetBanned requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetBanned requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetBanned requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetBanned requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetBanned requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetBanned requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetBanned requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetBanned requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetBanned requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetBanned requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetBanned requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetBanned requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetBanned requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetBanned requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetBanned requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBanned requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBanned requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetBanned requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetBanned requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetBanned requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetBanned requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetBanned requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetBanned requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetBanned requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetBanned requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetBanned requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetBanned requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetBanned requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetBanned requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetBanned requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetBanned requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetBanned requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetBanned requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetBanned requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetBanned requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetBanned requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetBanned requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetBanned requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetBanned requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetBanned requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetBanned requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetBanned requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetBanned requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetBanned requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetBanned requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetBanned requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetBanned requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetBanned requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetBanned requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetBanned requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetBanned requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetBanned requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetBanned requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetBanned requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetBanned requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetBanned requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetBanned requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetBanned requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetBanned requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetBanned requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetBanned requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetBanned requestWorkField (boolean value) {
      this.requestField("work", value);
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

  public static class APIRequestCreateCodelessEventBinding extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bindings",
      "mutation_method",
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
               return APIRequestCreateCodelessEventBinding.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCodelessEventBinding(String nodeId, APIContext context) {
      super(context, nodeId, "/codeless_event_bindings", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCodelessEventBinding setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventBinding setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCodelessEventBinding setBindings (List<Map<String, String>> bindings) {
      this.setParam("bindings", bindings);
      return this;
    }
    public APIRequestCreateCodelessEventBinding setBindings (String bindings) {
      this.setParam("bindings", bindings);
      return this;
    }

    public APIRequestCreateCodelessEventBinding setMutationMethod (Application.EnumMutationMethod mutationMethod) {
      this.setParam("mutation_method", mutationMethod);
      return this;
    }
    public APIRequestCreateCodelessEventBinding setMutationMethod (String mutationMethod) {
      this.setParam("mutation_method", mutationMethod);
      return this;
    }

    public APIRequestCreateCodelessEventBinding setPlatform (Application.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestCreateCodelessEventBinding setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestCreateCodelessEventBinding requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCodelessEventBinding requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventBinding requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCodelessEventBinding requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventBinding requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCodelessEventBinding requestField (String field, boolean value) {
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

  public static class APIRequestGetCustomAudienceThirdPartyId extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "limit_event_usage",
      "udid",
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
               return APIRequestGetCustomAudienceThirdPartyId.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCustomAudienceThirdPartyId(String nodeId, APIContext context) {
      super(context, nodeId, "/custom_audience_third_party_id", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomAudienceThirdPartyId setLimitEventUsage (Boolean limitEventUsage) {
      this.setParam("limit_event_usage", limitEventUsage);
      return this;
    }
    public APIRequestGetCustomAudienceThirdPartyId setLimitEventUsage (String limitEventUsage) {
      this.setParam("limit_event_usage", limitEventUsage);
      return this;
    }

    public APIRequestGetCustomAudienceThirdPartyId setUdid (String udid) {
      this.setParam("udid", udid);
      return this;
    }

    public APIRequestGetCustomAudienceThirdPartyId requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomAudienceThirdPartyId requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCustomAudienceThirdPartyId requestField (String field, boolean value) {
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
      "is_page_owned",
      "maybe_count",
      "name",
      "noreply_count",
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

  public static class APIRequestGetFullAppIndexingInfos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_version",
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
               return APIRequestGetFullAppIndexingInfos.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetFullAppIndexingInfos(String nodeId, APIContext context) {
      super(context, nodeId, "/full_app_indexing_infos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFullAppIndexingInfos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFullAppIndexingInfos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFullAppIndexingInfos setAppVersion (String appVersion) {
      this.setParam("app_version", appVersion);
      return this;
    }

    public APIRequestGetFullAppIndexingInfos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFullAppIndexingInfos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFullAppIndexingInfos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFullAppIndexingInfos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFullAppIndexingInfos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFullAppIndexingInfos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateFullAppIndexingInfo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_version",
      "full_app_indexing_info_classes",
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
               return APIRequestCreateFullAppIndexingInfo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateFullAppIndexingInfo(String nodeId, APIContext context) {
      super(context, nodeId, "/full_app_indexing_infos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateFullAppIndexingInfo setAppVersion (String appVersion) {
      this.setParam("app_version", appVersion);
      return this;
    }

    public APIRequestCreateFullAppIndexingInfo setFullAppIndexingInfoClasses (List<Map<String, String>> fullAppIndexingInfoClasses) {
      this.setParam("full_app_indexing_info_classes", fullAppIndexingInfoClasses);
      return this;
    }
    public APIRequestCreateFullAppIndexingInfo setFullAppIndexingInfoClasses (String fullAppIndexingInfoClasses) {
      this.setParam("full_app_indexing_info_classes", fullAppIndexingInfoClasses);
      return this;
    }

    public APIRequestCreateFullAppIndexingInfo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateFullAppIndexingInfo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateFullAppIndexingInfo requestField (String field, boolean value) {
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

  public static class APIRequestGetMoodsForApplication extends APIRequest<APINode> {

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
               return APIRequestGetMoodsForApplication.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMoodsForApplication(String nodeId, APIContext context) {
      super(context, nodeId, "/moods_for_application", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMoodsForApplication setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMoodsForApplication setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMoodsForApplication requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMoodsForApplication requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMoodsForApplication requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMoodsForApplication requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMoodsForApplication requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMoodsForApplication requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateObject extends APIRequest<OpenGraphObject> {

    OpenGraphObject lastResponse = null;
    @Override
    public OpenGraphObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "object",
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OpenGraphObject parseResponse(String response, String header) throws APIException {
      return OpenGraphObject.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OpenGraphObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenGraphObject execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OpenGraphObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenGraphObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OpenGraphObject>() {
           public OpenGraphObject apply(ResponseWrapper result) {
             try {
               return APIRequestCreateObject.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateObject(String nodeId, APIContext context) {
      super(context, nodeId, "/objects", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateObject setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateObject setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateObject setObject (Object object) {
      this.setParam("object", object);
      return this;
    }
    public APIRequestCreateObject setObject (String object) {
      this.setParam("object", object);
      return this;
    }

    public APIRequestCreateObject setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateObject requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateObject requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObject requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateObject requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObject requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateObject requestField (String field, boolean value) {
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

  public static class APIRequestCreateOzoneRelease extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "auto_push_to_prod",
      "changelog",
      "channel_id",
      "release_name",
      "rollout_percentage",
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
               return APIRequestCreateOzoneRelease.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOzoneRelease(String nodeId, APIContext context) {
      super(context, nodeId, "/ozone_release", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOzoneRelease setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOzoneRelease setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOzoneRelease setAutoPushToProd (Boolean autoPushToProd) {
      this.setParam("auto_push_to_prod", autoPushToProd);
      return this;
    }
    public APIRequestCreateOzoneRelease setAutoPushToProd (String autoPushToProd) {
      this.setParam("auto_push_to_prod", autoPushToProd);
      return this;
    }

    public APIRequestCreateOzoneRelease setChangelog (String changelog) {
      this.setParam("changelog", changelog);
      return this;
    }

    public APIRequestCreateOzoneRelease setChannelId (Long channelId) {
      this.setParam("channel_id", channelId);
      return this;
    }
    public APIRequestCreateOzoneRelease setChannelId (String channelId) {
      this.setParam("channel_id", channelId);
      return this;
    }

    public APIRequestCreateOzoneRelease setReleaseName (String releaseName) {
      this.setParam("release_name", releaseName);
      return this;
    }

    public APIRequestCreateOzoneRelease setRolloutPercentage (Double rolloutPercentage) {
      this.setParam("rollout_percentage", rolloutPercentage);
      return this;
    }
    public APIRequestCreateOzoneRelease setRolloutPercentage (String rolloutPercentage) {
      this.setParam("rollout_percentage", rolloutPercentage);
      return this;
    }

    public APIRequestCreateOzoneRelease requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOzoneRelease requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOzoneRelease requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOzoneRelease requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOzoneRelease requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOzoneRelease requestField (String field, boolean value) {
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

  public static class APIRequestCreateStagingResource extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "file",
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
               return APIRequestCreateStagingResource.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateStagingResource(String nodeId, APIContext context) {
      super(context, nodeId, "/staging_resources", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateStagingResource setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateStagingResource setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateStagingResource addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateStagingResource setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateStagingResource requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateStagingResource requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateStagingResource requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateStagingResource requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateStagingResource requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateStagingResource requestField (String field, boolean value) {
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

  public static class APIRequestCreateSubscriptionsSample extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_fields",
      "field",
      "object",
      "object_id",
      "stress_run",
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
               return APIRequestCreateSubscriptionsSample.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSubscriptionsSample(String nodeId, APIContext context) {
      super(context, nodeId, "/subscriptions_sample", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscriptionsSample setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscriptionsSample setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscriptionsSample setCustomFields (String customFields) {
      this.setParam("custom_fields", customFields);
      return this;
    }

    public APIRequestCreateSubscriptionsSample setField (String field) {
      this.setParam("field", field);
      return this;
    }

    public APIRequestCreateSubscriptionsSample setObject (String object) {
      this.setParam("object", object);
      return this;
    }

    public APIRequestCreateSubscriptionsSample setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestCreateSubscriptionsSample setStressRun (Long stressRun) {
      this.setParam("stress_run", stressRun);
      return this;
    }
    public APIRequestCreateSubscriptionsSample setStressRun (String stressRun) {
      this.setParam("stress_run", stressRun);
      return this;
    }

    public APIRequestCreateSubscriptionsSample requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscriptionsSample requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscriptionsSample requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscriptionsSample requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscriptionsSample requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscriptionsSample requestField (String field, boolean value) {
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

    public APIRequestCreateUpload setFileName (String fileName) {
      this.setParam("file_name", fileName);
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
      "android_key_hash",
      "android_key_hashes",
      "android_package_name",
      "android_sso",
      "app_domains",
      "app_name",
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
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "category",
      "configured_ios_sso",
      "contact_email",
      "created_time",
      "creator_uid",
      "deauth_callback_url",
      "hosting_url",
      "ios_bundle_id",
      "ipad_app_store_id",
      "iphone_app_store_id",
      "migrations",
      "mobile_web_url",
      "namespace",
      "page_tab_default_name",
      "page_tab_url",
      "privacy_policy_url",
      "restrictions",
      "secure_canvas_url",
      "secure_page_tab_url",
      "server_ip_whitelist",
      "social_discovery",
      "subcategory",
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

    public APIRequestUpdate setAndroidKeyHash (List<String> androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }
    public APIRequestUpdate setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
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

    public APIRequestUpdate setAuthDialogDataHelpUrl (String authDialogDataHelpUrl) {
      this.setParam("auth_dialog_data_help_url", authDialogDataHelpUrl);
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

    public APIRequestUpdate setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestUpdate setConfiguredIosSso (Boolean configuredIosSso) {
      this.setParam("configured_ios_sso", configuredIosSso);
      return this;
    }
    public APIRequestUpdate setConfiguredIosSso (String configuredIosSso) {
      this.setParam("configured_ios_sso", configuredIosSso);
      return this;
    }

    public APIRequestUpdate setContactEmail (String contactEmail) {
      this.setParam("contact_email", contactEmail);
      return this;
    }

    public APIRequestUpdate setCreatedTime (Object createdTime) {
      this.setParam("created_time", createdTime);
      return this;
    }
    public APIRequestUpdate setCreatedTime (String createdTime) {
      this.setParam("created_time", createdTime);
      return this;
    }

    public APIRequestUpdate setCreatorUid (Long creatorUid) {
      this.setParam("creator_uid", creatorUid);
      return this;
    }
    public APIRequestUpdate setCreatorUid (String creatorUid) {
      this.setParam("creator_uid", creatorUid);
      return this;
    }

    public APIRequestUpdate setDeauthCallbackUrl (String deauthCallbackUrl) {
      this.setParam("deauth_callback_url", deauthCallbackUrl);
      return this;
    }

    public APIRequestUpdate setHostingUrl (String hostingUrl) {
      this.setParam("hosting_url", hostingUrl);
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

    public APIRequestUpdate setIpadAppStoreId (String ipadAppStoreId) {
      this.setParam("ipad_app_store_id", ipadAppStoreId);
      return this;
    }

    public APIRequestUpdate setIphoneAppStoreId (String iphoneAppStoreId) {
      this.setParam("iphone_app_store_id", iphoneAppStoreId);
      return this;
    }

    public APIRequestUpdate setMigrations (String migrations) {
      this.setParam("migrations", migrations);
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

    public APIRequestUpdate setPageTabUrl (String pageTabUrl) {
      this.setParam("page_tab_url", pageTabUrl);
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

    public APIRequestUpdate setSocialDiscovery (Boolean socialDiscovery) {
      this.setParam("social_discovery", socialDiscovery);
      return this;
    }
    public APIRequestUpdate setSocialDiscovery (String socialDiscovery) {
      this.setParam("social_discovery", socialDiscovery);
      return this;
    }

    public APIRequestUpdate setSubcategory (String subcategory) {
      this.setParam("subcategory", subcategory);
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
      @SerializedName("SUPPLEMENTARY_IMAGES")
      VALUE_SUPPLEMENTARY_IMAGES("SUPPLEMENTARY_IMAGES"),
      @SerializedName("WEB")
      VALUE_WEB("WEB"),
      @SerializedName("WINDOWS")
      VALUE_WINDOWS("WINDOWS"),
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
      NULL(null);

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
