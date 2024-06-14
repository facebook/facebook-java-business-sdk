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
public class Business extends APINode {
  @SerializedName("block_offline_analytics")
  private Boolean mBlockOfflineAnalytics = null;
  @SerializedName("collaborative_ads_managed_partner_business_info")
  private ManagedPartnerBusiness mCollaborativeAdsManagedPartnerBusinessInfo = null;
  @SerializedName("collaborative_ads_managed_partner_eligibility")
  private BusinessManagedPartnerEligibility mCollaborativeAdsManagedPartnerEligibility = null;
  @SerializedName("collaborative_ads_partner_premium_options")
  private BusinessPartnerPremiumOptions mCollaborativeAdsPartnerPremiumOptions = null;
  @SerializedName("created_by")
  private Object mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("extended_updated_time")
  private String mExtendedUpdatedTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_hidden")
  private Boolean mIsHidden = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("payment_account_id")
  private String mPaymentAccountId = null;
  @SerializedName("primary_page")
  private Page mPrimaryPage = null;
  @SerializedName("profile_picture_uri")
  private String mProfilePictureUri = null;
  @SerializedName("timezone_id")
  private Long mTimezoneId = null;
  @SerializedName("two_factor_type")
  private String mTwoFactorType = null;
  @SerializedName("updated_by")
  private Object mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("user_access_expire_time")
  private String mUserAccessExpireTime = null;
  @SerializedName("verification_status")
  private String mVerificationStatus = null;
  @SerializedName("vertical")
  private String mVertical = null;
  @SerializedName("vertical_id")
  private Long mVerticalId = null;
  protected static Gson gson = null;

  Business() {
  }

  public Business(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Business(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Business fetch() throws APIException{
    Business newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Business fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Business> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Business fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Business> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Business> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Business>)(
      new APIRequest<Business>(context, "", "/", "GET", Business.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Business>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Business.getParser())
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
  public static Business loadJSON(String json, APIContext context, String header) {
    Business business = getGson().fromJson(json, Business.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(business.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    business.context = context;
    business.rawValue = json;
    business.header = header;
    return business;
  }

  public static APINodeList<Business> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Business> businesss = new APINodeList<Business>(request, json, header);
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
          businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businesss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businesss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businesss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businesss;
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
              businesss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businesss;
          }

          // Sixth, check if it's pure JsonObject
          businesss.clear();
          businesss.add(loadJSON(json, context, header));
          return businesss;
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

  public APIRequestCreateAccessToken createAccessToken() {
    return new APIRequestCreateAccessToken(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdStudies getAdStudies() {
    return new APIRequestGetAdStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdStudy createAdStudy() {
    return new APIRequestCreateAdStudy(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAddPhoneNumber createAddPhoneNumber() {
    return new APIRequestCreateAddPhoneNumber(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdNetworkApplication createAdNetworkApplication() {
    return new APIRequestCreateAdNetworkApplication(this.getPrefixedId().toString(), context);
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

  public APIRequestGetAdsReportingMmmReports getAdsReportingMmmReports() {
    return new APIRequestGetAdsReportingMmmReports(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdsReportingMmmSchedulers getAdsReportingMmmSchedulers() {
    return new APIRequestGetAdsReportingMmmSchedulers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdsPixel createAdsPixel() {
    return new APIRequestCreateAdsPixel(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAnPlacements getAnPlacements() {
    return new APIRequestGetAnPlacements(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBlockListDraft createBlockListDraft() {
    return new APIRequestCreateBlockListDraft(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessAssetGroups getBusinessAssetGroups() {
    return new APIRequestGetBusinessAssetGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessInvoices getBusinessInvoices() {
    return new APIRequestGetBusinessInvoices(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessUsers getBusinessUsers() {
    return new APIRequestGetBusinessUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBusinessUser createBusinessUser() {
    return new APIRequestCreateBusinessUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessProjects getBusinessProjects() {
    return new APIRequestGetBusinessProjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClaimCustomConversion createClaimCustomConversion() {
    return new APIRequestCreateClaimCustomConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientAdAccounts getClientAdAccounts() {
    return new APIRequestGetClientAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientApps getClientApps() {
    return new APIRequestGetClientApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientApp createClientApp() {
    return new APIRequestCreateClientApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientOffsiteSignalContainerBusinessObjects getClientOffsiteSignalContainerBusinessObjects() {
    return new APIRequestGetClientOffsiteSignalContainerBusinessObjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientPages getClientPages() {
    return new APIRequestGetClientPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientPage createClientPage() {
    return new APIRequestCreateClientPage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientPixels getClientPixels() {
    return new APIRequestGetClientPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientProductCatalogs getClientProductCatalogs() {
    return new APIRequestGetClientProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientWhatsAppBusinessAccounts getClientWhatsAppBusinessAccounts() {
    return new APIRequestGetClientWhatsAppBusinessAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteClients deleteClients() {
    return new APIRequestDeleteClients(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClients getClients() {
    return new APIRequestGetClients(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCollaborativeAdsCollaborationRequests getCollaborativeAdsCollaborationRequests() {
    return new APIRequestGetCollaborativeAdsCollaborationRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCollaborativeAdsCollaborationRequest createCollaborativeAdsCollaborationRequest() {
    return new APIRequestCreateCollaborativeAdsCollaborationRequest(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCollaborativeAdsSuggestedPartners getCollaborativeAdsSuggestedPartners() {
    return new APIRequestGetCollaborativeAdsSuggestedPartners(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCommerceMerchantSettings getCommerceMerchantSettings() {
    return new APIRequestGetCommerceMerchantSettings(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCpasBusinessSetupConfig getCpasBusinessSetupConfig() {
    return new APIRequestGetCpasBusinessSetupConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCpasBusinessSetupConfig createCpasBusinessSetupConfig() {
    return new APIRequestCreateCpasBusinessSetupConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCpasMerchantConfig getCpasMerchantConfig() {
    return new APIRequestGetCpasMerchantConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCreativeFolder createCreativeFolder() {
    return new APIRequestCreateCreativeFolder(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCreditCards getCreditCards() {
    return new APIRequestGetCreditCards(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCustomConversion createCustomConversion() {
    return new APIRequestCreateCustomConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateDraftNegativeKeywordList createDraftNegativeKeywordList() {
    return new APIRequestCreateDraftNegativeKeywordList(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEventSourceGroups getEventSourceGroups() {
    return new APIRequestGetEventSourceGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateEventSourceGroup createEventSourceGroup() {
    return new APIRequestCreateEventSourceGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExtendedCreditApplications getExtendedCreditApplications() {
    return new APIRequestGetExtendedCreditApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExtendedCredits getExtendedCredits() {
    return new APIRequestGetExtendedCredits(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateImage createImage() {
    return new APIRequestCreateImage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInitiatedAudienceSharingRequests getInitiatedAudienceSharingRequests() {
    return new APIRequestGetInitiatedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteInstagramAccounts deleteInstagramAccounts() {
    return new APIRequestDeleteInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramBusinessAccounts getInstagramBusinessAccounts() {
    return new APIRequestGetInstagramBusinessAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMAnAgeDBusinesses deleteMAnAgeDBusinesses() {
    return new APIRequestDeleteMAnAgeDBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMAnAgeDBusiness createMAnAgeDBusiness() {
    return new APIRequestCreateMAnAgeDBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMAnAgeDPartnerBusinessSetup createMAnAgeDPartnerBusinessSetup() {
    return new APIRequestCreateMAnAgeDPartnerBusinessSetup(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMAnAgeDPartnerBusinesses deleteMAnAgeDPartnerBusinesses() {
    return new APIRequestDeleteMAnAgeDPartnerBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMAnAgeDPartnerBusiness createMAnAgeDPartnerBusiness() {
    return new APIRequestCreateMAnAgeDPartnerBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNegativeKeywordLists getNegativeKeywordLists() {
    return new APIRequestGetNegativeKeywordLists(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOpenBridgeConfigurations getOpenBridgeConfigurations() {
    return new APIRequestGetOpenBridgeConfigurations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOpenBridgeConfiguration createOpenBridgeConfiguration() {
    return new APIRequestCreateOpenBridgeConfiguration(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedAdAccounts getOwnedAdAccounts() {
    return new APIRequestGetOwnedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedAdAccount createOwnedAdAccount() {
    return new APIRequestCreateOwnedAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedApps getOwnedApps() {
    return new APIRequestGetOwnedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedApp createOwnedApp() {
    return new APIRequestCreateOwnedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteOwnedBusinesses deleteOwnedBusinesses() {
    return new APIRequestDeleteOwnedBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedBusinesses getOwnedBusinesses() {
    return new APIRequestGetOwnedBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedBusiness createOwnedBusiness() {
    return new APIRequestCreateOwnedBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedInstagramAccounts getOwnedInstagramAccounts() {
    return new APIRequestGetOwnedInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects getOwnedOffsiteSignalContainerBusinessObjects() {
    return new APIRequestGetOwnedOffsiteSignalContainerBusinessObjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedPages getOwnedPages() {
    return new APIRequestGetOwnedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedPage createOwnedPage() {
    return new APIRequestCreateOwnedPage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedPixels getOwnedPixels() {
    return new APIRequestGetOwnedPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedProductCatalogs getOwnedProductCatalogs() {
    return new APIRequestGetOwnedProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedProductCatalog createOwnedProductCatalog() {
    return new APIRequestCreateOwnedProductCatalog(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedWhatsAppBusinessAccounts getOwnedWhatsAppBusinessAccounts() {
    return new APIRequestGetOwnedWhatsAppBusinessAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeletePages deletePages() {
    return new APIRequestDeletePages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartnerAccountLinking getPartnerAccountLinking() {
    return new APIRequestGetPartnerAccountLinking(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePartnerPremiumOption createPartnerPremiumOption() {
    return new APIRequestCreatePartnerPremiumOption(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientAdAccounts getPendingClientAdAccounts() {
    return new APIRequestGetPendingClientAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientApps getPendingClientApps() {
    return new APIRequestGetPendingClientApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientPages getPendingClientPages() {
    return new APIRequestGetPendingClientPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedAdAccounts getPendingOwnedAdAccounts() {
    return new APIRequestGetPendingOwnedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedPages getPendingOwnedPages() {
    return new APIRequestGetPendingOwnedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects getPendingShareDOffsiteSignalContainerBusinessObjects() {
    return new APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingUsers getPendingUsers() {
    return new APIRequestGetPendingUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePixelTo createPixelTo() {
    return new APIRequestCreatePixelTo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPreVerifiedNumbers getPreVerifiedNumbers() {
    return new APIRequestGetPreVerifiedNumbers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedAudienceSharingRequests getReceivedAudienceSharingRequests() {
    return new APIRequestGetReceivedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetResellerGuidances getResellerGuidances() {
    return new APIRequestGetResellerGuidances(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions getSelfCertifiedWhatsappBusinessSubmissions() {
    return new APIRequestGetSelfCertifiedWhatsappBusinessSubmissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSetupMAnAgeDPartnerAdAccount createSetupMAnAgeDPartnerAdAccount() {
    return new APIRequestCreateSetupMAnAgeDPartnerAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteSharePreVerifiedNumbers deleteSharePreVerifiedNumbers() {
    return new APIRequestDeleteSharePreVerifiedNumbers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSharePreVerifiedNumber createSharePreVerifiedNumber() {
    return new APIRequestCreateSharePreVerifiedNumber(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSystemUserAccessToken createSystemUserAccessToken() {
    return new APIRequestCreateSystemUserAccessToken(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSystemUsers getSystemUsers() {
    return new APIRequestGetSystemUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSystemUser createSystemUser() {
    return new APIRequestCreateSystemUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetThirdPartyMeasurementReportDataset getThirdPartyMeasurementReportDataset() {
    return new APIRequestGetThirdPartyMeasurementReportDataset(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldBlockOfflineAnalytics() {
    return mBlockOfflineAnalytics;
  }

  public ManagedPartnerBusiness getFieldCollaborativeAdsManagedPartnerBusinessInfo() {
    return mCollaborativeAdsManagedPartnerBusinessInfo;
  }

  public BusinessManagedPartnerEligibility getFieldCollaborativeAdsManagedPartnerEligibility() {
    return mCollaborativeAdsManagedPartnerEligibility;
  }

  public BusinessPartnerPremiumOptions getFieldCollaborativeAdsPartnerPremiumOptions() {
    return mCollaborativeAdsPartnerPremiumOptions;
  }

  public Object getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldExtendedUpdatedTime() {
    return mExtendedUpdatedTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsHidden() {
    return mIsHidden;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPaymentAccountId() {
    return mPaymentAccountId;
  }

  public Page getFieldPrimaryPage() {
    if (mPrimaryPage != null) {
      mPrimaryPage.context = getContext();
    }
    return mPrimaryPage;
  }

  public String getFieldProfilePictureUri() {
    return mProfilePictureUri;
  }

  public Long getFieldTimezoneId() {
    return mTimezoneId;
  }

  public String getFieldTwoFactorType() {
    return mTwoFactorType;
  }

  public Object getFieldUpdatedBy() {
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldUserAccessExpireTime() {
    return mUserAccessExpireTime;
  }

  public String getFieldVerificationStatus() {
    return mVerificationStatus;
  }

  public String getFieldVertical() {
    return mVertical;
  }

  public Long getFieldVerticalId() {
    return mVerticalId;
  }



  public static class APIRequestCreateAccessToken extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "fbe_external_business_id",
      "scope",
      "system_user_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAccessToken.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAccessToken(String nodeId, APIContext context) {
      super(context, nodeId, "/access_token", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAccessToken setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAccessToken setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAccessToken setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateAccessToken setFbeExternalBusinessId (String fbeExternalBusinessId) {
      this.setParam("fbe_external_business_id", fbeExternalBusinessId);
      return this;
    }

    public APIRequestCreateAccessToken setScope (List<Permission> scope) {
      this.setParam("scope", scope);
      return this;
    }
    public APIRequestCreateAccessToken setScope (String scope) {
      this.setParam("scope", scope);
      return this;
    }

    public APIRequestCreateAccessToken setSystemUserName (String systemUserName) {
      this.setParam("system_user_name", systemUserName);
      return this;
    }

    public APIRequestCreateAccessToken requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAccessToken requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAccessToken requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteAdAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
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
               return APIRequestDeleteAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_accounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdAccounts setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestDeleteAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdStudies extends APIRequest<AdStudy> {

    APINodeList<AdStudy> lastResponse = null;
    @Override
    public APINodeList<AdStudy> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "canceled_time",
      "client_business",
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "measurement_contact",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "sales_contact",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<AdStudy> parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudy> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdStudy>>() {
           public APINodeList<AdStudy> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdStudies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdStudies(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_studies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdStudies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdStudies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdStudies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdStudies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdStudies requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdStudies requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCanceledTimeField () {
      return this.requestCanceledTimeField(true);
    }
    public APIRequestGetAdStudies requestCanceledTimeField (boolean value) {
      this.requestField("canceled_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestClientBusinessField () {
      return this.requestClientBusinessField(true);
    }
    public APIRequestGetAdStudies requestClientBusinessField (boolean value) {
      this.requestField("client_business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField () {
      return this.requestCooldownStartTimeField(true);
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField (boolean value) {
      this.requestField("cooldown_start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdStudies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdStudies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAdStudies requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAdStudies requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdStudies requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdStudies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdStudies requestMeasurementContactField () {
      return this.requestMeasurementContactField(true);
    }
    public APIRequestGetAdStudies requestMeasurementContactField (boolean value) {
      this.requestField("measurement_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdStudies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdStudies requestObservationEndTimeField () {
      return this.requestObservationEndTimeField(true);
    }
    public APIRequestGetAdStudies requestObservationEndTimeField (boolean value) {
      this.requestField("observation_end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField () {
      return this.requestResultsFirstAvailableDateField(true);
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField (boolean value) {
      this.requestField("results_first_available_date", value);
      return this;
    }
    public APIRequestGetAdStudies requestSalesContactField () {
      return this.requestSalesContactField(true);
    }
    public APIRequestGetAdStudies requestSalesContactField (boolean value) {
      this.requestField("sales_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdStudies requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAdStudies requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetAdStudies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdStudies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateAdStudy extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cells",
      "client_business",
      "confidence_level",
      "cooldown_start_time",
      "description",
      "end_time",
      "name",
      "objectives",
      "observation_end_time",
      "start_time",
      "type",
      "viewers",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudy>() {
           public AdStudy apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdStudy.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdStudy(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_studies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdStudy setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdStudy setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdStudy setCells (List<Object> cells) {
      this.setParam("cells", cells);
      return this;
    }
    public APIRequestCreateAdStudy setCells (String cells) {
      this.setParam("cells", cells);
      return this;
    }

    public APIRequestCreateAdStudy setClientBusiness (String clientBusiness) {
      this.setParam("client_business", clientBusiness);
      return this;
    }

    public APIRequestCreateAdStudy setConfidenceLevel (Double confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }
    public APIRequestCreateAdStudy setConfidenceLevel (String confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }

    public APIRequestCreateAdStudy setCooldownStartTime (Long cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }
    public APIRequestCreateAdStudy setCooldownStartTime (String cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }

    public APIRequestCreateAdStudy setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAdStudy setEndTime (Long endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestCreateAdStudy setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateAdStudy setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdStudy setObjectives (List<Object> objectives) {
      this.setParam("objectives", objectives);
      return this;
    }
    public APIRequestCreateAdStudy setObjectives (String objectives) {
      this.setParam("objectives", objectives);
      return this;
    }

    public APIRequestCreateAdStudy setObservationEndTime (Long observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }
    public APIRequestCreateAdStudy setObservationEndTime (String observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }

    public APIRequestCreateAdStudy setStartTime (Long startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestCreateAdStudy setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateAdStudy setType (AdStudy.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateAdStudy setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateAdStudy setViewers (List<Long> viewers) {
      this.setParam("viewers", viewers);
      return this;
    }
    public APIRequestCreateAdStudy setViewers (String viewers) {
      this.setParam("viewers", viewers);
      return this;
    }

    public APIRequestCreateAdStudy requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdStudy requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdStudy requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdAccount extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account_created_from_bm_flag",
      "currency",
      "end_advertiser",
      "funding_id",
      "invoice",
      "invoice_group_id",
      "invoicing_emails",
      "io",
      "media_agency",
      "name",
      "partner",
      "po_number",
      "timezone_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccount parseResponse(String response, String header) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAccount>() {
           public AdAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccount", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccount setAdAccountCreatedFromBmFlag (Boolean adAccountCreatedFromBmFlag) {
      this.setParam("ad_account_created_from_bm_flag", adAccountCreatedFromBmFlag);
      return this;
    }
    public APIRequestCreateAdAccount setAdAccountCreatedFromBmFlag (String adAccountCreatedFromBmFlag) {
      this.setParam("ad_account_created_from_bm_flag", adAccountCreatedFromBmFlag);
      return this;
    }

    public APIRequestCreateAdAccount setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateAdAccount setEndAdvertiser (Object endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }
    public APIRequestCreateAdAccount setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }

    public APIRequestCreateAdAccount setFundingId (String fundingId) {
      this.setParam("funding_id", fundingId);
      return this;
    }

    public APIRequestCreateAdAccount setInvoice (Boolean invoice) {
      this.setParam("invoice", invoice);
      return this;
    }
    public APIRequestCreateAdAccount setInvoice (String invoice) {
      this.setParam("invoice", invoice);
      return this;
    }

    public APIRequestCreateAdAccount setInvoiceGroupId (String invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }

    public APIRequestCreateAdAccount setInvoicingEmails (List<String> invoicingEmails) {
      this.setParam("invoicing_emails", invoicingEmails);
      return this;
    }
    public APIRequestCreateAdAccount setInvoicingEmails (String invoicingEmails) {
      this.setParam("invoicing_emails", invoicingEmails);
      return this;
    }

    public APIRequestCreateAdAccount setIo (Boolean io) {
      this.setParam("io", io);
      return this;
    }
    public APIRequestCreateAdAccount setIo (String io) {
      this.setParam("io", io);
      return this;
    }

    public APIRequestCreateAdAccount setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }

    public APIRequestCreateAdAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdAccount setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestCreateAdAccount setPoNumber (String poNumber) {
      this.setParam("po_number", poNumber);
      return this;
    }

    public APIRequestCreateAdAccount setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateAdAccount setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAddPhoneNumber extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "phone_number",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAddPhoneNumber.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAddPhoneNumber(String nodeId, APIContext context) {
      super(context, nodeId, "/add_phone_numbers", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAddPhoneNumber setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAddPhoneNumber setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAddPhoneNumber setPhoneNumber (String phoneNumber) {
      this.setParam("phone_number", phoneNumber);
      return this;
    }

    public APIRequestCreateAddPhoneNumber requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAddPhoneNumber requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAddPhoneNumber requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAddPhoneNumber requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAddPhoneNumber requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAddPhoneNumber requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdNetworkApplication extends APIRequest<Application> {

    Application lastResponse = null;
    @Override
    public Application getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
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
               return APIRequestCreateAdNetworkApplication.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdNetworkApplication(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetwork_applications", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdNetworkApplication setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkApplication setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdNetworkApplication setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdNetworkApplication requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdNetworkApplication requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkApplication requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdNetworkApplication requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkApplication requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkApplication requestField (String field, boolean value) {
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

  public static class APIRequestCreateAdNetworkAnalytic extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
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
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
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

  public static class APIRequestGetAdsReportingMmmReports extends APIRequest<AdsReportBuilderMMMReport> {

    APINodeList<AdsReportBuilderMMMReport> lastResponse = null;
    @Override
    public APINodeList<AdsReportBuilderMMMReport> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filtering",
    };

    public static final String[] FIELDS = {
      "async_status",
      "export_format",
      "export_name",
      "export_type",
      "has_seen",
      "id",
      "mmm_status",
      "time_start",
    };

    @Override
    public APINodeList<AdsReportBuilderMMMReport> parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderMMMReport.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsReportBuilderMMMReport> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsReportBuilderMMMReport> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsReportBuilderMMMReport>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsReportBuilderMMMReport>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsReportBuilderMMMReport>>() {
           public APINodeList<AdsReportBuilderMMMReport> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdsReportingMmmReports.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdsReportingMmmReports(String nodeId, APIContext context) {
      super(context, nodeId, "/ads_reporting_mmm_reports", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdsReportingMmmReports setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmReports setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdsReportingMmmReports setFiltering (List<Map<String, String>> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetAdsReportingMmmReports requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdsReportingMmmReports requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmReports requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdsReportingMmmReports requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmReports requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmReports requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsReportingMmmReports requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestExportFormatField () {
      return this.requestExportFormatField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestExportFormatField (boolean value) {
      this.requestField("export_format", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestExportNameField () {
      return this.requestExportNameField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestExportNameField (boolean value) {
      this.requestField("export_name", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestExportTypeField () {
      return this.requestExportTypeField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestExportTypeField (boolean value) {
      this.requestField("export_type", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestHasSeenField () {
      return this.requestHasSeenField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestHasSeenField (boolean value) {
      this.requestField("has_seen", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestMmmStatusField () {
      return this.requestMmmStatusField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestMmmStatusField (boolean value) {
      this.requestField("mmm_status", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmReports requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGetAdsReportingMmmReports requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
      return this;
    }
  }

  public static class APIRequestGetAdsReportingMmmSchedulers extends APIRequest<AdsReportBuilderMMMReportScheduler> {

    APINodeList<AdsReportBuilderMMMReportScheduler> lastResponse = null;
    @Override
    public APINodeList<AdsReportBuilderMMMReportScheduler> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "filtering",
      "id",
      "report_name",
      "schedule_frequency",
    };

    @Override
    public APINodeList<AdsReportBuilderMMMReportScheduler> parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderMMMReportScheduler.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsReportBuilderMMMReportScheduler> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsReportBuilderMMMReportScheduler> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsReportBuilderMMMReportScheduler>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsReportBuilderMMMReportScheduler>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsReportBuilderMMMReportScheduler>>() {
           public APINodeList<AdsReportBuilderMMMReportScheduler> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdsReportingMmmSchedulers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdsReportingMmmSchedulers(String nodeId, APIContext context) {
      super(context, nodeId, "/ads_reporting_mmm_schedulers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdsReportingMmmSchedulers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdsReportingMmmSchedulers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdsReportingMmmSchedulers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsReportingMmmSchedulers requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGetAdsReportingMmmSchedulers requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmSchedulers requestFilteringField () {
      return this.requestFilteringField(true);
    }
    public APIRequestGetAdsReportingMmmSchedulers requestFilteringField (boolean value) {
      this.requestField("filtering", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmSchedulers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsReportingMmmSchedulers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmSchedulers requestReportNameField () {
      return this.requestReportNameField(true);
    }
    public APIRequestGetAdsReportingMmmSchedulers requestReportNameField (boolean value) {
      this.requestField("report_name", value);
      return this;
    }
    public APIRequestGetAdsReportingMmmSchedulers requestScheduleFrequencyField () {
      return this.requestScheduleFrequencyField(true);
    }
    public APIRequestGetAdsReportingMmmSchedulers requestScheduleFrequencyField (boolean value) {
      this.requestField("schedule_frequency", value);
      return this;
    }
  }

  public static class APIRequestGetAdsPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id_filter",
      "name_filter",
      "sort_by",
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


    public APIRequestGetAdsPixels setIdFilter (String idFilter) {
      this.setParam("id_filter", idFilter);
      return this;
    }

    public APIRequestGetAdsPixels setNameFilter (String nameFilter) {
      this.setParam("name_filter", nameFilter);
      return this;
    }

    public APIRequestGetAdsPixels setSortBy (AdsPixel.EnumSortBy sortBy) {
      this.setParam("sort_by", sortBy);
      return this;
    }
    public APIRequestGetAdsPixels setSortBy (String sortBy) {
      this.setParam("sort_by", sortBy);
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

  public static class APIRequestCreateAdsPixel extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_crm",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response, String header) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsPixel>() {
           public AdsPixel apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdsPixel.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAdsPixel(String nodeId, APIContext context) {
      super(context, nodeId, "/adspixels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdsPixel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdsPixel setIsCrm (Boolean isCrm) {
      this.setParam("is_crm", isCrm);
      return this;
    }
    public APIRequestCreateAdsPixel setIsCrm (String isCrm) {
      this.setParam("is_crm", isCrm);
      return this;
    }

    public APIRequestCreateAdsPixel setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdsPixel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdsPixel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdsPixel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteAgencies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
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
               return APIRequestDeleteAgencies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAgencies setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field, boolean value) {
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

  public static class APIRequestGetAnPlacements extends APIRequest<AdPlacement> {

    APINodeList<AdPlacement> lastResponse = null;
    @Override
    public APINodeList<AdPlacement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetAnPlacements.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAnPlacements(String nodeId, APIContext context) {
      super(context, nodeId, "/an_placements", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAnPlacements setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAnPlacements setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAnPlacements requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAnPlacements requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAnPlacements requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAnPlacements requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAnPlacements requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAnPlacements requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAnPlacements requestBundleIdField () {
      return this.requestBundleIdField(true);
    }
    public APIRequestGetAnPlacements requestBundleIdField (boolean value) {
      this.requestField("bundle_id", value);
      return this;
    }
    public APIRequestGetAnPlacements requestDisplayFormatField () {
      return this.requestDisplayFormatField(true);
    }
    public APIRequestGetAnPlacements requestDisplayFormatField (boolean value) {
      this.requestField("display_format", value);
      return this;
    }
    public APIRequestGetAnPlacements requestExternalPlacementIdField () {
      return this.requestExternalPlacementIdField(true);
    }
    public APIRequestGetAnPlacements requestExternalPlacementIdField (boolean value) {
      this.requestField("external_placement_id", value);
      return this;
    }
    public APIRequestGetAnPlacements requestGoogleDisplayFormatField () {
      return this.requestGoogleDisplayFormatField(true);
    }
    public APIRequestGetAnPlacements requestGoogleDisplayFormatField (boolean value) {
      this.requestField("google_display_format", value);
      return this;
    }
    public APIRequestGetAnPlacements requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAnPlacements requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAnPlacements requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAnPlacements requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAnPlacements requestPlacementGroupField () {
      return this.requestPlacementGroupField(true);
    }
    public APIRequestGetAnPlacements requestPlacementGroupField (boolean value) {
      this.requestField("placement_group", value);
      return this;
    }
    public APIRequestGetAnPlacements requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetAnPlacements requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetAnPlacements requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAnPlacements requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreateBlockListDraft extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "publisher_urls_file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBlockListDraft.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBlockListDraft(String nodeId, APIContext context) {
      super(context, nodeId, "/block_list_drafts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBlockListDraft setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBlockListDraft setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBlockListDraft setPublisherUrlsFile (File publisherUrlsFile) {
      this.setParam("publisher_urls_file", publisherUrlsFile);
      return this;
    }
    public APIRequestCreateBlockListDraft setPublisherUrlsFile (String publisherUrlsFile) {
      this.setParam("publisher_urls_file", publisherUrlsFile);
      return this;
    }

    public APIRequestCreateBlockListDraft requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBlockListDraft requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBlockListDraft requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBlockListDraft requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBlockListDraft requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBlockListDraft requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessAssetGroups extends APIRequest<BusinessAssetGroup> {

    APINodeList<BusinessAssetGroup> lastResponse = null;
    @Override
    public APINodeList<BusinessAssetGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "owner_business",
    };

    @Override
    public APINodeList<BusinessAssetGroup> parseResponse(String response, String header) throws APIException {
      return BusinessAssetGroup.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAssetGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAssetGroup> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAssetGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAssetGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAssetGroup>>() {
           public APINodeList<BusinessAssetGroup> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessAssetGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBusinessAssetGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/business_asset_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessAssetGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessAssetGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessAssetGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessAssetGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessAssetGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessAssetGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessAssetGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessAssetGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessAssetGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessAssetGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessAssetGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessAssetGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBusinessAssetGroups requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetBusinessAssetGroups requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestGetBusinessInvoices extends APIRequest<OmegaCustomerTrx> {

    APINodeList<OmegaCustomerTrx> lastResponse = null;
    @Override
    public APINodeList<OmegaCustomerTrx> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_date",
      "invoice_id",
      "issue_end_date",
      "issue_start_date",
      "root_id",
      "start_date",
      "type",
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "advertiser_name",
      "amount",
      "amount_due",
      "billed_amount_details",
      "billing_period",
      "cdn_download_uri",
      "currency",
      "download_uri",
      "due_date",
      "entity",
      "id",
      "invoice_date",
      "invoice_id",
      "invoice_type",
      "liability_type",
      "payment_status",
      "payment_term",
      "type",
    };

    @Override
    public APINodeList<OmegaCustomerTrx> parseResponse(String response, String header) throws APIException {
      return OmegaCustomerTrx.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OmegaCustomerTrx> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OmegaCustomerTrx> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OmegaCustomerTrx>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OmegaCustomerTrx>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OmegaCustomerTrx>>() {
           public APINodeList<OmegaCustomerTrx> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessInvoices.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBusinessInvoices(String nodeId, APIContext context) {
      super(context, nodeId, "/business_invoices", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessInvoices setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessInvoices setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setInvoiceId (String invoiceId) {
      this.setParam("invoice_id", invoiceId);
      return this;
    }

    public APIRequestGetBusinessInvoices setIssueEndDate (String issueEndDate) {
      this.setParam("issue_end_date", issueEndDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setIssueStartDate (String issueStartDate) {
      this.setParam("issue_start_date", issueStartDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setRootId (Long rootId) {
      this.setParam("root_id", rootId);
      return this;
    }
    public APIRequestGetBusinessInvoices setRootId (String rootId) {
      this.setParam("root_id", rootId);
      return this;
    }

    public APIRequestGetBusinessInvoices setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setType (OmegaCustomerTrx.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetBusinessInvoices setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetBusinessInvoices requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessInvoices requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessInvoices requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessInvoices requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGetBusinessInvoices requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestAdvertiserNameField () {
      return this.requestAdvertiserNameField(true);
    }
    public APIRequestGetBusinessInvoices requestAdvertiserNameField (boolean value) {
      this.requestField("advertiser_name", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestAmountField () {
      return this.requestAmountField(true);
    }
    public APIRequestGetBusinessInvoices requestAmountField (boolean value) {
      this.requestField("amount", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestAmountDueField () {
      return this.requestAmountDueField(true);
    }
    public APIRequestGetBusinessInvoices requestAmountDueField (boolean value) {
      this.requestField("amount_due", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestBilledAmountDetailsField () {
      return this.requestBilledAmountDetailsField(true);
    }
    public APIRequestGetBusinessInvoices requestBilledAmountDetailsField (boolean value) {
      this.requestField("billed_amount_details", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestBillingPeriodField () {
      return this.requestBillingPeriodField(true);
    }
    public APIRequestGetBusinessInvoices requestBillingPeriodField (boolean value) {
      this.requestField("billing_period", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestCdnDownloadUriField () {
      return this.requestCdnDownloadUriField(true);
    }
    public APIRequestGetBusinessInvoices requestCdnDownloadUriField (boolean value) {
      this.requestField("cdn_download_uri", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBusinessInvoices requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestDownloadUriField () {
      return this.requestDownloadUriField(true);
    }
    public APIRequestGetBusinessInvoices requestDownloadUriField (boolean value) {
      this.requestField("download_uri", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestDueDateField () {
      return this.requestDueDateField(true);
    }
    public APIRequestGetBusinessInvoices requestDueDateField (boolean value) {
      this.requestField("due_date", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestEntityField () {
      return this.requestEntityField(true);
    }
    public APIRequestGetBusinessInvoices requestEntityField (boolean value) {
      this.requestField("entity", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessInvoices requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceDateField () {
      return this.requestInvoiceDateField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceDateField (boolean value) {
      this.requestField("invoice_date", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceIdField () {
      return this.requestInvoiceIdField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceIdField (boolean value) {
      this.requestField("invoice_id", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceTypeField () {
      return this.requestInvoiceTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceTypeField (boolean value) {
      this.requestField("invoice_type", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestLiabilityTypeField () {
      return this.requestLiabilityTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestLiabilityTypeField (boolean value) {
      this.requestField("liability_type", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestPaymentStatusField () {
      return this.requestPaymentStatusField(true);
    }
    public APIRequestGetBusinessInvoices requestPaymentStatusField (boolean value) {
      this.requestField("payment_status", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestPaymentTermField () {
      return this.requestPaymentTermField(true);
    }
    public APIRequestGetBusinessInvoices requestPaymentTermField (boolean value) {
      this.requestField("payment_term", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestGetBusinessUsers extends APIRequest<BusinessUser> {

    APINodeList<BusinessUser> lastResponse = null;
    @Override
    public APINodeList<BusinessUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "business_role_request",
      "email",
      "finance_permission",
      "first_name",
      "id",
      "ip_permission",
      "last_name",
      "marked_for_removal",
      "name",
      "pending_email",
      "role",
      "title",
      "two_fac_status",
    };

    @Override
    public APINodeList<BusinessUser> parseResponse(String response, String header) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessUser>>() {
           public APINodeList<BusinessUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBusinessUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/business_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestBusinessRoleRequestField () {
      return this.requestBusinessRoleRequestField(true);
    }
    public APIRequestGetBusinessUsers requestBusinessRoleRequestField (boolean value) {
      this.requestField("business_role_request", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetBusinessUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGetBusinessUsers requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetBusinessUsers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGetBusinessUsers requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetBusinessUsers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestMarkedForRemovalField () {
      return this.requestMarkedForRemovalField(true);
    }
    public APIRequestGetBusinessUsers requestMarkedForRemovalField (boolean value) {
      this.requestField("marked_for_removal", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestPendingEmailField () {
      return this.requestPendingEmailField(true);
    }
    public APIRequestGetBusinessUsers requestPendingEmailField (boolean value) {
      this.requestField("pending_email", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetBusinessUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetBusinessUsers requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestTwoFacStatusField () {
      return this.requestTwoFacStatusField(true);
    }
    public APIRequestGetBusinessUsers requestTwoFacStatusField (boolean value) {
      this.requestField("two_fac_status", value);
      return this;
    }
  }

  public static class APIRequestCreateBusinessUser extends APIRequest<BusinessUser> {

    BusinessUser lastResponse = null;
    @Override
    public BusinessUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
      "role",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessUser parseResponse(String response, String header) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessUser>() {
           public BusinessUser apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBusinessUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBusinessUser(String nodeId, APIContext context) {
      super(context, nodeId, "/business_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBusinessUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBusinessUser setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateBusinessUser setRole (BusinessUser.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateBusinessUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateBusinessUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBusinessUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBusinessUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessProjects extends APIRequest<BusinessProject> {

    APINodeList<BusinessProject> lastResponse = null;
    @Override
    public APINodeList<BusinessProject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "created_time",
      "creator",
      "id",
      "name",
    };

    @Override
    public APINodeList<BusinessProject> parseResponse(String response, String header) throws APIException {
      return BusinessProject.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessProject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessProject> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessProject>>() {
           public APINodeList<BusinessProject> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessProjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBusinessProjects(String nodeId, APIContext context) {
      super(context, nodeId, "/businessprojects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessProjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessProjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessProjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessProjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessProjects requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessProjects requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetBusinessProjects requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetBusinessProjects requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessProjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessProjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateClaimCustomConversion extends APIRequest<CustomConversion> {

    CustomConversion lastResponse = null;
    @Override
    public CustomConversion getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_conversion_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomConversion parseResponse(String response, String header) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CustomConversion execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomConversion execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CustomConversion> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomConversion> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CustomConversion>() {
           public CustomConversion apply(ResponseWrapper result) {
             try {
               return APIRequestCreateClaimCustomConversion.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateClaimCustomConversion(String nodeId, APIContext context) {
      super(context, nodeId, "/claim_custom_conversions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClaimCustomConversion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClaimCustomConversion setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClaimCustomConversion setCustomConversionId (String customConversionId) {
      this.setParam("custom_conversion_id", customConversionId);
      return this;
    }

    public APIRequestCreateClaimCustomConversion requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClaimCustomConversion requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClaimCustomConversion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClaimCustomConversion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClaimCustomConversion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClaimCustomConversion requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClientAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "search_query",
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
               return APIRequestGetClientAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientAdAccounts setSearchQuery (String searchQuery) {
      this.setParam("search_query", searchQuery);
      return this;
    }

    public APIRequestGetClientAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetClientAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetClientAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAllCapabilitiesField () {
      return this.requestAllCapabilitiesField(true);
    }
    public APIRequestGetClientAdAccounts requestAllCapabilitiesField (boolean value) {
      this.requestField("all_capabilities", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetClientAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBrandSafetyContentFilterLevelsField () {
      return this.requestBrandSafetyContentFilterLevelsField(true);
    }
    public APIRequestGetClientAdAccounts requestBrandSafetyContentFilterLevelsField (boolean value) {
      this.requestField("brand_safety_content_filter_levels", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetClientAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCustomAudienceInfoField () {
      return this.requestCustomAudienceInfoField(true);
    }
    public APIRequestGetClientAdAccounts requestCustomAudienceInfoField (boolean value) {
      this.requestField("custom_audience_info", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDefaultDsaBeneficiaryField () {
      return this.requestDefaultDsaBeneficiaryField(true);
    }
    public APIRequestGetClientAdAccounts requestDefaultDsaBeneficiaryField (boolean value) {
      this.requestField("default_dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDefaultDsaPayorField () {
      return this.requestDefaultDsaPayorField(true);
    }
    public APIRequestGetClientAdAccounts requestDefaultDsaPayorField (boolean value) {
      this.requestField("default_dsa_payor", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestExistingCustomersField () {
      return this.requestExistingCustomersField(true);
    }
    public APIRequestGetClientAdAccounts requestExistingCustomersField (boolean value) {
      this.requestField("existing_customers", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetClientAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetClientAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetClientAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetClientAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetClientAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetClientAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetClientAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetClientAdAccounts requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetClientAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetClientAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetClientAdAccounts requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetClientAdAccounts requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetClientAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestViewableBusinessField () {
      return this.requestViewableBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestViewableBusinessField (boolean value) {
      this.requestField("viewable_business", value);
      return this;
    }
  }

  public static class APIRequestGetClientApps extends APIRequest<Application> {

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
               return APIRequestGetClientApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientApps(String nodeId, APIContext context) {
      super(context, nodeId, "/client_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientApps requestAamRulesField () {
      return this.requestAamRulesField(true);
    }
    public APIRequestGetClientApps requestAamRulesField (boolean value) {
      this.requestField("aam_rules", value);
      return this;
    }
    public APIRequestGetClientApps requestAnAdSpaceLimitField () {
      return this.requestAnAdSpaceLimitField(true);
    }
    public APIRequestGetClientApps requestAnAdSpaceLimitField (boolean value) {
      this.requestField("an_ad_space_limit", value);
      return this;
    }
    public APIRequestGetClientApps requestAnPlatformsField () {
      return this.requestAnPlatformsField(true);
    }
    public APIRequestGetClientApps requestAnPlatformsField (boolean value) {
      this.requestField("an_platforms", value);
      return this;
    }
    public APIRequestGetClientApps requestAndroidKeyHashField () {
      return this.requestAndroidKeyHashField(true);
    }
    public APIRequestGetClientApps requestAndroidKeyHashField (boolean value) {
      this.requestField("android_key_hash", value);
      return this;
    }
    public APIRequestGetClientApps requestAndroidSdkErrorCategoriesField () {
      return this.requestAndroidSdkErrorCategoriesField(true);
    }
    public APIRequestGetClientApps requestAndroidSdkErrorCategoriesField (boolean value) {
      this.requestField("android_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetClientApps requestAppDomainsField () {
      return this.requestAppDomainsField(true);
    }
    public APIRequestGetClientApps requestAppDomainsField (boolean value) {
      this.requestField("app_domains", value);
      return this;
    }
    public APIRequestGetClientApps requestAppEventsConfigField () {
      return this.requestAppEventsConfigField(true);
    }
    public APIRequestGetClientApps requestAppEventsConfigField (boolean value) {
      this.requestField("app_events_config", value);
      return this;
    }
    public APIRequestGetClientApps requestAppEventsFeatureBitmaskField () {
      return this.requestAppEventsFeatureBitmaskField(true);
    }
    public APIRequestGetClientApps requestAppEventsFeatureBitmaskField (boolean value) {
      this.requestField("app_events_feature_bitmask", value);
      return this;
    }
    public APIRequestGetClientApps requestAppEventsSessionTimeoutField () {
      return this.requestAppEventsSessionTimeoutField(true);
    }
    public APIRequestGetClientApps requestAppEventsSessionTimeoutField (boolean value) {
      this.requestField("app_events_session_timeout", value);
      return this;
    }
    public APIRequestGetClientApps requestAppInstallTrackedField () {
      return this.requestAppInstallTrackedField(true);
    }
    public APIRequestGetClientApps requestAppInstallTrackedField (boolean value) {
      this.requestField("app_install_tracked", value);
      return this;
    }
    public APIRequestGetClientApps requestAppNameField () {
      return this.requestAppNameField(true);
    }
    public APIRequestGetClientApps requestAppNameField (boolean value) {
      this.requestField("app_name", value);
      return this;
    }
    public APIRequestGetClientApps requestAppSignalsBindingIosField () {
      return this.requestAppSignalsBindingIosField(true);
    }
    public APIRequestGetClientApps requestAppSignalsBindingIosField (boolean value) {
      this.requestField("app_signals_binding_ios", value);
      return this;
    }
    public APIRequestGetClientApps requestAppTypeField () {
      return this.requestAppTypeField(true);
    }
    public APIRequestGetClientApps requestAppTypeField (boolean value) {
      this.requestField("app_type", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthDialogDataHelpUrlField () {
      return this.requestAuthDialogDataHelpUrlField(true);
    }
    public APIRequestGetClientApps requestAuthDialogDataHelpUrlField (boolean value) {
      this.requestField("auth_dialog_data_help_url", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthDialogHeadlineField () {
      return this.requestAuthDialogHeadlineField(true);
    }
    public APIRequestGetClientApps requestAuthDialogHeadlineField (boolean value) {
      this.requestField("auth_dialog_headline", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthDialogPermsExplanationField () {
      return this.requestAuthDialogPermsExplanationField(true);
    }
    public APIRequestGetClientApps requestAuthDialogPermsExplanationField (boolean value) {
      this.requestField("auth_dialog_perms_explanation", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralDefaultActivityPrivacyField () {
      return this.requestAuthReferralDefaultActivityPrivacyField(true);
    }
    public APIRequestGetClientApps requestAuthReferralDefaultActivityPrivacyField (boolean value) {
      this.requestField("auth_referral_default_activity_privacy", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralEnabledField () {
      return this.requestAuthReferralEnabledField(true);
    }
    public APIRequestGetClientApps requestAuthReferralEnabledField (boolean value) {
      this.requestField("auth_referral_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralExtendedPermsField () {
      return this.requestAuthReferralExtendedPermsField(true);
    }
    public APIRequestGetClientApps requestAuthReferralExtendedPermsField (boolean value) {
      this.requestField("auth_referral_extended_perms", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralFriendPermsField () {
      return this.requestAuthReferralFriendPermsField(true);
    }
    public APIRequestGetClientApps requestAuthReferralFriendPermsField (boolean value) {
      this.requestField("auth_referral_friend_perms", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralResponseTypeField () {
      return this.requestAuthReferralResponseTypeField(true);
    }
    public APIRequestGetClientApps requestAuthReferralResponseTypeField (boolean value) {
      this.requestField("auth_referral_response_type", value);
      return this;
    }
    public APIRequestGetClientApps requestAuthReferralUserPermsField () {
      return this.requestAuthReferralUserPermsField(true);
    }
    public APIRequestGetClientApps requestAuthReferralUserPermsField (boolean value) {
      this.requestField("auth_referral_user_perms", value);
      return this;
    }
    public APIRequestGetClientApps requestAutoEventMappingAndroidField () {
      return this.requestAutoEventMappingAndroidField(true);
    }
    public APIRequestGetClientApps requestAutoEventMappingAndroidField (boolean value) {
      this.requestField("auto_event_mapping_android", value);
      return this;
    }
    public APIRequestGetClientApps requestAutoEventMappingIosField () {
      return this.requestAutoEventMappingIosField(true);
    }
    public APIRequestGetClientApps requestAutoEventMappingIosField (boolean value) {
      this.requestField("auto_event_mapping_ios", value);
      return this;
    }
    public APIRequestGetClientApps requestAutoEventSetupEnabledField () {
      return this.requestAutoEventSetupEnabledField(true);
    }
    public APIRequestGetClientApps requestAutoEventSetupEnabledField (boolean value) {
      this.requestField("auto_event_setup_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestAutoLogAppEventsDefaultField () {
      return this.requestAutoLogAppEventsDefaultField(true);
    }
    public APIRequestGetClientApps requestAutoLogAppEventsDefaultField (boolean value) {
      this.requestField("auto_log_app_events_default", value);
      return this;
    }
    public APIRequestGetClientApps requestAutoLogAppEventsEnabledField () {
      return this.requestAutoLogAppEventsEnabledField(true);
    }
    public APIRequestGetClientApps requestAutoLogAppEventsEnabledField (boolean value) {
      this.requestField("auto_log_app_events_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientApps requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientApps requestCanvasFluidHeightField () {
      return this.requestCanvasFluidHeightField(true);
    }
    public APIRequestGetClientApps requestCanvasFluidHeightField (boolean value) {
      this.requestField("canvas_fluid_height", value);
      return this;
    }
    public APIRequestGetClientApps requestCanvasFluidWidthField () {
      return this.requestCanvasFluidWidthField(true);
    }
    public APIRequestGetClientApps requestCanvasFluidWidthField (boolean value) {
      this.requestField("canvas_fluid_width", value);
      return this;
    }
    public APIRequestGetClientApps requestCanvasUrlField () {
      return this.requestCanvasUrlField(true);
    }
    public APIRequestGetClientApps requestCanvasUrlField (boolean value) {
      this.requestField("canvas_url", value);
      return this;
    }
    public APIRequestGetClientApps requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetClientApps requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetClientApps requestClientConfigField () {
      return this.requestClientConfigField(true);
    }
    public APIRequestGetClientApps requestClientConfigField (boolean value) {
      this.requestField("client_config", value);
      return this;
    }
    public APIRequestGetClientApps requestCompanyField () {
      return this.requestCompanyField(true);
    }
    public APIRequestGetClientApps requestCompanyField (boolean value) {
      this.requestField("company", value);
      return this;
    }
    public APIRequestGetClientApps requestConfiguredIosSsoField () {
      return this.requestConfiguredIosSsoField(true);
    }
    public APIRequestGetClientApps requestConfiguredIosSsoField (boolean value) {
      this.requestField("configured_ios_sso", value);
      return this;
    }
    public APIRequestGetClientApps requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetClientApps requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetClientApps requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetClientApps requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetClientApps requestCreatorUidField () {
      return this.requestCreatorUidField(true);
    }
    public APIRequestGetClientApps requestCreatorUidField (boolean value) {
      this.requestField("creator_uid", value);
      return this;
    }
    public APIRequestGetClientApps requestDailyActiveUsersField () {
      return this.requestDailyActiveUsersField(true);
    }
    public APIRequestGetClientApps requestDailyActiveUsersField (boolean value) {
      this.requestField("daily_active_users", value);
      return this;
    }
    public APIRequestGetClientApps requestDailyActiveUsersRankField () {
      return this.requestDailyActiveUsersRankField(true);
    }
    public APIRequestGetClientApps requestDailyActiveUsersRankField (boolean value) {
      this.requestField("daily_active_users_rank", value);
      return this;
    }
    public APIRequestGetClientApps requestDeauthCallbackUrlField () {
      return this.requestDeauthCallbackUrlField(true);
    }
    public APIRequestGetClientApps requestDeauthCallbackUrlField (boolean value) {
      this.requestField("deauth_callback_url", value);
      return this;
    }
    public APIRequestGetClientApps requestDefaultShareModeField () {
      return this.requestDefaultShareModeField(true);
    }
    public APIRequestGetClientApps requestDefaultShareModeField (boolean value) {
      this.requestField("default_share_mode", value);
      return this;
    }
    public APIRequestGetClientApps requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetClientApps requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetClientApps requestFinancialIdField () {
      return this.requestFinancialIdField(true);
    }
    public APIRequestGetClientApps requestFinancialIdField (boolean value) {
      this.requestField("financial_id", value);
      return this;
    }
    public APIRequestGetClientApps requestGdpv4ChromeCustomTabsEnabledField () {
      return this.requestGdpv4ChromeCustomTabsEnabledField(true);
    }
    public APIRequestGetClientApps requestGdpv4ChromeCustomTabsEnabledField (boolean value) {
      this.requestField("gdpv4_chrome_custom_tabs_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestGdpv4EnabledField () {
      return this.requestGdpv4EnabledField(true);
    }
    public APIRequestGetClientApps requestGdpv4EnabledField (boolean value) {
      this.requestField("gdpv4_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestGdpv4NuxContentField () {
      return this.requestGdpv4NuxContentField(true);
    }
    public APIRequestGetClientApps requestGdpv4NuxContentField (boolean value) {
      this.requestField("gdpv4_nux_content", value);
      return this;
    }
    public APIRequestGetClientApps requestGdpv4NuxEnabledField () {
      return this.requestGdpv4NuxEnabledField(true);
    }
    public APIRequestGetClientApps requestGdpv4NuxEnabledField (boolean value) {
      this.requestField("gdpv4_nux_enabled", value);
      return this;
    }
    public APIRequestGetClientApps requestHasMessengerProductField () {
      return this.requestHasMessengerProductField(true);
    }
    public APIRequestGetClientApps requestHasMessengerProductField (boolean value) {
      this.requestField("has_messenger_product", value);
      return this;
    }
    public APIRequestGetClientApps requestHostingUrlField () {
      return this.requestHostingUrlField(true);
    }
    public APIRequestGetClientApps requestHostingUrlField (boolean value) {
      this.requestField("hosting_url", value);
      return this;
    }
    public APIRequestGetClientApps requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetClientApps requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetClientApps requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientApps requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientApps requestIosBundleIdField () {
      return this.requestIosBundleIdField(true);
    }
    public APIRequestGetClientApps requestIosBundleIdField (boolean value) {
      this.requestField("ios_bundle_id", value);
      return this;
    }
    public APIRequestGetClientApps requestIosSdkDialogFlowsField () {
      return this.requestIosSdkDialogFlowsField(true);
    }
    public APIRequestGetClientApps requestIosSdkDialogFlowsField (boolean value) {
      this.requestField("ios_sdk_dialog_flows", value);
      return this;
    }
    public APIRequestGetClientApps requestIosSdkErrorCategoriesField () {
      return this.requestIosSdkErrorCategoriesField(true);
    }
    public APIRequestGetClientApps requestIosSdkErrorCategoriesField (boolean value) {
      this.requestField("ios_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetClientApps requestIosSfvcAttrField () {
      return this.requestIosSfvcAttrField(true);
    }
    public APIRequestGetClientApps requestIosSfvcAttrField (boolean value) {
      this.requestField("ios_sfvc_attr", value);
      return this;
    }
    public APIRequestGetClientApps requestIosSupportsNativeProxyAuthFlowField () {
      return this.requestIosSupportsNativeProxyAuthFlowField(true);
    }
    public APIRequestGetClientApps requestIosSupportsNativeProxyAuthFlowField (boolean value) {
      this.requestField("ios_supports_native_proxy_auth_flow", value);
      return this;
    }
    public APIRequestGetClientApps requestIosSupportsSystemAuthField () {
      return this.requestIosSupportsSystemAuthField(true);
    }
    public APIRequestGetClientApps requestIosSupportsSystemAuthField (boolean value) {
      this.requestField("ios_supports_system_auth", value);
      return this;
    }
    public APIRequestGetClientApps requestIpadAppStoreIdField () {
      return this.requestIpadAppStoreIdField(true);
    }
    public APIRequestGetClientApps requestIpadAppStoreIdField (boolean value) {
      this.requestField("ipad_app_store_id", value);
      return this;
    }
    public APIRequestGetClientApps requestIphoneAppStoreIdField () {
      return this.requestIphoneAppStoreIdField(true);
    }
    public APIRequestGetClientApps requestIphoneAppStoreIdField (boolean value) {
      this.requestField("iphone_app_store_id", value);
      return this;
    }
    public APIRequestGetClientApps requestLatestSdkVersionField () {
      return this.requestLatestSdkVersionField(true);
    }
    public APIRequestGetClientApps requestLatestSdkVersionField (boolean value) {
      this.requestField("latest_sdk_version", value);
      return this;
    }
    public APIRequestGetClientApps requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetClientApps requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetClientApps requestLoggingTokenField () {
      return this.requestLoggingTokenField(true);
    }
    public APIRequestGetClientApps requestLoggingTokenField (boolean value) {
      this.requestField("logging_token", value);
      return this;
    }
    public APIRequestGetClientApps requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGetClientApps requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGetClientApps requestMigrationsField () {
      return this.requestMigrationsField(true);
    }
    public APIRequestGetClientApps requestMigrationsField (boolean value) {
      this.requestField("migrations", value);
      return this;
    }
    public APIRequestGetClientApps requestMobileProfileSectionUrlField () {
      return this.requestMobileProfileSectionUrlField(true);
    }
    public APIRequestGetClientApps requestMobileProfileSectionUrlField (boolean value) {
      this.requestField("mobile_profile_section_url", value);
      return this;
    }
    public APIRequestGetClientApps requestMobileWebUrlField () {
      return this.requestMobileWebUrlField(true);
    }
    public APIRequestGetClientApps requestMobileWebUrlField (boolean value) {
      this.requestField("mobile_web_url", value);
      return this;
    }
    public APIRequestGetClientApps requestMonthlyActiveUsersField () {
      return this.requestMonthlyActiveUsersField(true);
    }
    public APIRequestGetClientApps requestMonthlyActiveUsersField (boolean value) {
      this.requestField("monthly_active_users", value);
      return this;
    }
    public APIRequestGetClientApps requestMonthlyActiveUsersRankField () {
      return this.requestMonthlyActiveUsersRankField(true);
    }
    public APIRequestGetClientApps requestMonthlyActiveUsersRankField (boolean value) {
      this.requestField("monthly_active_users_rank", value);
      return this;
    }
    public APIRequestGetClientApps requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientApps requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientApps requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGetClientApps requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGetClientApps requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGetClientApps requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGetClientApps requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientApps requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientApps requestPageTabDefaultNameField () {
      return this.requestPageTabDefaultNameField(true);
    }
    public APIRequestGetClientApps requestPageTabDefaultNameField (boolean value) {
      this.requestField("page_tab_default_name", value);
      return this;
    }
    public APIRequestGetClientApps requestPageTabUrlField () {
      return this.requestPageTabUrlField(true);
    }
    public APIRequestGetClientApps requestPageTabUrlField (boolean value) {
      this.requestField("page_tab_url", value);
      return this;
    }
    public APIRequestGetClientApps requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGetClientApps requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
      return this;
    }
    public APIRequestGetClientApps requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetClientApps requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetClientApps requestProfileSectionUrlField () {
      return this.requestProfileSectionUrlField(true);
    }
    public APIRequestGetClientApps requestProfileSectionUrlField (boolean value) {
      this.requestField("profile_section_url", value);
      return this;
    }
    public APIRequestGetClientApps requestPropertyIdField () {
      return this.requestPropertyIdField(true);
    }
    public APIRequestGetClientApps requestPropertyIdField (boolean value) {
      this.requestField("property_id", value);
      return this;
    }
    public APIRequestGetClientApps requestProtectedModeRulesField () {
      return this.requestProtectedModeRulesField(true);
    }
    public APIRequestGetClientApps requestProtectedModeRulesField (boolean value) {
      this.requestField("protected_mode_rules", value);
      return this;
    }
    public APIRequestGetClientApps requestRealTimeModeDevicesField () {
      return this.requestRealTimeModeDevicesField(true);
    }
    public APIRequestGetClientApps requestRealTimeModeDevicesField (boolean value) {
      this.requestField("real_time_mode_devices", value);
      return this;
    }
    public APIRequestGetClientApps requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGetClientApps requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGetClientApps requestRestrictiveDataFilterParamsField () {
      return this.requestRestrictiveDataFilterParamsField(true);
    }
    public APIRequestGetClientApps requestRestrictiveDataFilterParamsField (boolean value) {
      this.requestField("restrictive_data_filter_params", value);
      return this;
    }
    public APIRequestGetClientApps requestRestrictiveDataFilterRulesField () {
      return this.requestRestrictiveDataFilterRulesField(true);
    }
    public APIRequestGetClientApps requestRestrictiveDataFilterRulesField (boolean value) {
      this.requestField("restrictive_data_filter_rules", value);
      return this;
    }
    public APIRequestGetClientApps requestSdkUpdateMessageField () {
      return this.requestSdkUpdateMessageField(true);
    }
    public APIRequestGetClientApps requestSdkUpdateMessageField (boolean value) {
      this.requestField("sdk_update_message", value);
      return this;
    }
    public APIRequestGetClientApps requestSeamlessLoginField () {
      return this.requestSeamlessLoginField(true);
    }
    public APIRequestGetClientApps requestSeamlessLoginField (boolean value) {
      this.requestField("seamless_login", value);
      return this;
    }
    public APIRequestGetClientApps requestSecureCanvasUrlField () {
      return this.requestSecureCanvasUrlField(true);
    }
    public APIRequestGetClientApps requestSecureCanvasUrlField (boolean value) {
      this.requestField("secure_canvas_url", value);
      return this;
    }
    public APIRequestGetClientApps requestSecurePageTabUrlField () {
      return this.requestSecurePageTabUrlField(true);
    }
    public APIRequestGetClientApps requestSecurePageTabUrlField (boolean value) {
      this.requestField("secure_page_tab_url", value);
      return this;
    }
    public APIRequestGetClientApps requestServerIpWhitelistField () {
      return this.requestServerIpWhitelistField(true);
    }
    public APIRequestGetClientApps requestServerIpWhitelistField (boolean value) {
      this.requestField("server_ip_whitelist", value);
      return this;
    }
    public APIRequestGetClientApps requestSmartLoginBookmarkIconUrlField () {
      return this.requestSmartLoginBookmarkIconUrlField(true);
    }
    public APIRequestGetClientApps requestSmartLoginBookmarkIconUrlField (boolean value) {
      this.requestField("smart_login_bookmark_icon_url", value);
      return this;
    }
    public APIRequestGetClientApps requestSmartLoginMenuIconUrlField () {
      return this.requestSmartLoginMenuIconUrlField(true);
    }
    public APIRequestGetClientApps requestSmartLoginMenuIconUrlField (boolean value) {
      this.requestField("smart_login_menu_icon_url", value);
      return this;
    }
    public APIRequestGetClientApps requestSocialDiscoveryField () {
      return this.requestSocialDiscoveryField(true);
    }
    public APIRequestGetClientApps requestSocialDiscoveryField (boolean value) {
      this.requestField("social_discovery", value);
      return this;
    }
    public APIRequestGetClientApps requestSubcategoryField () {
      return this.requestSubcategoryField(true);
    }
    public APIRequestGetClientApps requestSubcategoryField (boolean value) {
      this.requestField("subcategory", value);
      return this;
    }
    public APIRequestGetClientApps requestSuggestedEventsSettingField () {
      return this.requestSuggestedEventsSettingField(true);
    }
    public APIRequestGetClientApps requestSuggestedEventsSettingField (boolean value) {
      this.requestField("suggested_events_setting", value);
      return this;
    }
    public APIRequestGetClientApps requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGetClientApps requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGetClientApps requestSupportsApprequestsFastAppSwitchField () {
      return this.requestSupportsApprequestsFastAppSwitchField(true);
    }
    public APIRequestGetClientApps requestSupportsApprequestsFastAppSwitchField (boolean value) {
      this.requestField("supports_apprequests_fast_app_switch", value);
      return this;
    }
    public APIRequestGetClientApps requestSupportsAttributionField () {
      return this.requestSupportsAttributionField(true);
    }
    public APIRequestGetClientApps requestSupportsAttributionField (boolean value) {
      this.requestField("supports_attribution", value);
      return this;
    }
    public APIRequestGetClientApps requestSupportsImplicitSdkLoggingField () {
      return this.requestSupportsImplicitSdkLoggingField(true);
    }
    public APIRequestGetClientApps requestSupportsImplicitSdkLoggingField (boolean value) {
      this.requestField("supports_implicit_sdk_logging", value);
      return this;
    }
    public APIRequestGetClientApps requestSuppressNativeIosGdpField () {
      return this.requestSuppressNativeIosGdpField(true);
    }
    public APIRequestGetClientApps requestSuppressNativeIosGdpField (boolean value) {
      this.requestField("suppress_native_ios_gdp", value);
      return this;
    }
    public APIRequestGetClientApps requestTermsOfServiceUrlField () {
      return this.requestTermsOfServiceUrlField(true);
    }
    public APIRequestGetClientApps requestTermsOfServiceUrlField (boolean value) {
      this.requestField("terms_of_service_url", value);
      return this;
    }
    public APIRequestGetClientApps requestUrlSchemeSuffixField () {
      return this.requestUrlSchemeSuffixField(true);
    }
    public APIRequestGetClientApps requestUrlSchemeSuffixField (boolean value) {
      this.requestField("url_scheme_suffix", value);
      return this;
    }
    public APIRequestGetClientApps requestUserSupportEmailField () {
      return this.requestUserSupportEmailField(true);
    }
    public APIRequestGetClientApps requestUserSupportEmailField (boolean value) {
      this.requestField("user_support_email", value);
      return this;
    }
    public APIRequestGetClientApps requestUserSupportUrlField () {
      return this.requestUserSupportUrlField(true);
    }
    public APIRequestGetClientApps requestUserSupportUrlField (boolean value) {
      this.requestField("user_support_url", value);
      return this;
    }
    public APIRequestGetClientApps requestWebsiteUrlField () {
      return this.requestWebsiteUrlField(true);
    }
    public APIRequestGetClientApps requestWebsiteUrlField (boolean value) {
      this.requestField("website_url", value);
      return this;
    }
    public APIRequestGetClientApps requestWeeklyActiveUsersField () {
      return this.requestWeeklyActiveUsersField(true);
    }
    public APIRequestGetClientApps requestWeeklyActiveUsersField (boolean value) {
      this.requestField("weekly_active_users", value);
      return this;
    }
  }

  public static class APIRequestCreateClientApp extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateClientApp.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateClientApp(String nodeId, APIContext context) {
      super(context, nodeId, "/client_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClientApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClientApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClientApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateClientApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateClientApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClientApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClientApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClientOffsiteSignalContainerBusinessObjects extends APIRequest<OffsiteSignalContainerBusinessObject> {

    APINodeList<OffsiteSignalContainerBusinessObject> lastResponse = null;
    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_unavailable",
      "name",
      "primary_container_id",
    };

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> parseResponse(String response, String header) throws APIException {
      return OffsiteSignalContainerBusinessObject.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OffsiteSignalContainerBusinessObject>>() {
           public APINodeList<OffsiteSignalContainerBusinessObject> apply(ResponseWrapper result) {
             try {
               return APIRequestGetClientOffsiteSignalContainerBusinessObjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientOffsiteSignalContainerBusinessObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/client_offsite_signal_container_business_objects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField () {
      return this.requestPrimaryContainerIdField(true);
    }
    public APIRequestGetClientOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField (boolean value) {
      this.requestField("primary_container_id", value);
      return this;
    }
  }

  public static class APIRequestGetClientPages extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "artists_we_like",
      "attire",
      "available_promo_offer_ids",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "breaking_news_usage",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "connected_page_backed_instagram_account",
      "contact_address",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "does_viewer_have_page_permission_link_ig",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "followers_count",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_root_id",
      "has_added_app",
      "has_lead_access",
      "has_transitioned_to_new_page_experience",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "is_always_open",
      "is_calling_eligible",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messaging_feature_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mini_shop_storefront",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "owner_business",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_donate_button_in_live_video",
      "talking_about_count",
      "temporary_status",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "user_access_expire_time",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetClientPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientPages(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetClientPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetClientPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetClientPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetClientPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetClientPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetClientPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetClientPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetClientPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetClientPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetClientPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetClientPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetClientPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetClientPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetClientPages requestAvailablePromoOfferIdsField () {
      return this.requestAvailablePromoOfferIdsField(true);
    }
    public APIRequestGetClientPages requestAvailablePromoOfferIdsField (boolean value) {
      this.requestField("available_promo_offer_ids", value);
      return this;
    }
    public APIRequestGetClientPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetClientPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetClientPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetClientPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetClientPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetClientPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetClientPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetClientPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetClientPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetClientPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetClientPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetClientPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetClientPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetClientPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetClientPages requestBreakingNewsUsageField () {
      return this.requestBreakingNewsUsageField(true);
    }
    public APIRequestGetClientPages requestBreakingNewsUsageField (boolean value) {
      this.requestField("breaking_news_usage", value);
      return this;
    }
    public APIRequestGetClientPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetClientPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetClientPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetClientPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetClientPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetClientPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetClientPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetClientPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetClientPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetClientPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetClientPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetClientPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetClientPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetClientPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetClientPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetClientPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetClientPages requestConnectedPageBackedInstagramAccountField () {
      return this.requestConnectedPageBackedInstagramAccountField(true);
    }
    public APIRequestGetClientPages requestConnectedPageBackedInstagramAccountField (boolean value) {
      this.requestField("connected_page_backed_instagram_account", value);
      return this;
    }
    public APIRequestGetClientPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetClientPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetClientPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetClientPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetClientPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetClientPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetClientPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetClientPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetClientPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetClientPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetClientPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetClientPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetClientPages requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetClientPages requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetClientPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetClientPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetClientPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetClientPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetClientPages requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetClientPages requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetClientPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetClientPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetClientPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetClientPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetClientPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetClientPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetClientPages requestDoesViewerHavePagePermissionLinkIgField () {
      return this.requestDoesViewerHavePagePermissionLinkIgField(true);
    }
    public APIRequestGetClientPages requestDoesViewerHavePagePermissionLinkIgField (boolean value) {
      this.requestField("does_viewer_have_page_permission_link_ig", value);
      return this;
    }
    public APIRequestGetClientPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetClientPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetClientPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetClientPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetClientPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetClientPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetClientPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetClientPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetClientPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetClientPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetClientPages requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGetClientPages requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGetClientPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetClientPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetClientPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetClientPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetClientPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetClientPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetClientPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetClientPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetClientPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetClientPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetClientPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetClientPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetClientPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetClientPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetClientPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetClientPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetClientPages requestHasLeadAccessField () {
      return this.requestHasLeadAccessField(true);
    }
    public APIRequestGetClientPages requestHasLeadAccessField (boolean value) {
      this.requestField("has_lead_access", value);
      return this;
    }
    public APIRequestGetClientPages requestHasTransitionedToNewPageExperienceField () {
      return this.requestHasTransitionedToNewPageExperienceField(true);
    }
    public APIRequestGetClientPages requestHasTransitionedToNewPageExperienceField (boolean value) {
      this.requestField("has_transitioned_to_new_page_experience", value);
      return this;
    }
    public APIRequestGetClientPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetClientPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetClientPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetClientPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetClientPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetClientPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetClientPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetClientPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetClientPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetClientPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetClientPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetClientPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetClientPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetClientPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetClientPages requestIsCallingEligibleField () {
      return this.requestIsCallingEligibleField(true);
    }
    public APIRequestGetClientPages requestIsCallingEligibleField (boolean value) {
      this.requestField("is_calling_eligible", value);
      return this;
    }
    public APIRequestGetClientPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetClientPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetClientPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetClientPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetClientPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetClientPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetClientPages requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField () {
      return this.requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField(true);
    }
    public APIRequestGetClientPages requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField (boolean value) {
      this.requestField("is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web", value);
      return this;
    }
    public APIRequestGetClientPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetClientPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetClientPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetClientPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetClientPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetClientPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetClientPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetClientPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetClientPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetClientPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetClientPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetClientPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetClientPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetClientPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetClientPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetClientPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetClientPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetClientPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetClientPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetClientPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetClientPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetClientPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetClientPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetClientPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetClientPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetClientPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetClientPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetClientPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetClientPages requestMessagingFeatureStatusField () {
      return this.requestMessagingFeatureStatusField(true);
    }
    public APIRequestGetClientPages requestMessagingFeatureStatusField (boolean value) {
      this.requestField("messaging_feature_status", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetClientPages requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetClientPages requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetClientPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetClientPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetClientPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetClientPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetClientPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetClientPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetClientPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetClientPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetClientPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetClientPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetClientPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetClientPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetClientPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetClientPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetClientPages requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientPages requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetClientPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetClientPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetClientPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetClientPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetClientPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetClientPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetClientPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetClientPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetClientPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetClientPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetClientPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetClientPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetClientPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetClientPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetClientPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetClientPages requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetClientPages requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetClientPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetClientPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetClientPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetClientPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetClientPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetClientPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetClientPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetClientPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetClientPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetClientPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetClientPages requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetClientPages requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetClientPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetClientPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetClientPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetClientPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetClientPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetClientPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetClientPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetClientPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetClientPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetClientPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetClientPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetClientPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetClientPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetClientPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetClientPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetClientPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetClientPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetClientPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetClientPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetClientPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetClientPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetClientPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetClientPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetClientPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetClientPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetClientPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetClientPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetClientPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetClientPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetClientPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetClientPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetClientPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetClientPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetClientPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetClientPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetClientPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetClientPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetClientPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetClientPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetClientPages requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetClientPages requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetClientPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetClientPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetClientPages requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetClientPages requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetClientPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetClientPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetClientPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetClientPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetClientPages requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetClientPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetClientPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetClientPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetClientPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetClientPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetClientPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetClientPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetClientPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetClientPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetClientPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetClientPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetClientPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetClientPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetClientPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestCreateClientPage extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_id",
      "permitted_tasks",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateClientPage.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateClientPage(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClientPage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClientPage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClientPage setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreateClientPage setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreateClientPage setPermittedTasks (List<Business.EnumPermittedTasks> permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }
    public APIRequestCreateClientPage setPermittedTasks (String permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }

    public APIRequestCreateClientPage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClientPage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientPage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClientPage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientPage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClientPage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClientPixels extends APIRequest<AdsPixel> {

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
               return APIRequestGetClientPixels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientPixels requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGetClientPixels requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGetClientPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetClientPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetClientPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetClientPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetClientPixels requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetClientPixels requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetClientPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetClientPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetClientPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetClientPixels requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetClientPixels requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetClientPixels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetClientPixels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetClientPixels requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetClientPixels requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetClientPixels requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetClientPixels requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetClientPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetClientPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetClientPixels requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetClientPixels requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetClientPixels requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetClientPixels requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetClientPixels requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetClientPixels requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetClientPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetClientPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetClientPixels requestHas1pPixelEventField () {
      return this.requestHas1pPixelEventField(true);
    }
    public APIRequestGetClientPixels requestHas1pPixelEventField (boolean value) {
      this.requestField("has_1p_pixel_event", value);
      return this;
    }
    public APIRequestGetClientPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetClientPixels requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetClientPixels requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetClientPixels requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetClientPixels requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetClientPixels requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetClientPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetClientPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetClientPixels requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetClientPixels requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetClientPixels requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetClientPixels requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetClientPixels requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetClientPixels requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetClientPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetClientPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetClientPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientPixels requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetClientPixels requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetClientPixels requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetClientPixels requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetClientPixels requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetClientProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_to_collaborative_ads_share_settings",
      "agency_collaborative_ads_share_settings",
      "business",
      "catalog_store",
      "commerce_merchant_settings",
      "creator_user",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "is_local_catalog",
      "name",
      "owner_business",
      "product_count",
      "store_catalog_settings",
      "user_access_expire_time",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(ResponseWrapper result) {
             try {
               return APIRequestGetClientProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/client_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField () {
      return this.requestAdAccountToCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("ad_account_to_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestAgencyCollaborativeAdsShareSettingsField () {
      return this.requestAgencyCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestAgencyCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("agency_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestCatalogStoreField () {
      return this.requestCatalogStoreField(true);
    }
    public APIRequestGetClientProductCatalogs requestCatalogStoreField (boolean value) {
      this.requestField("catalog_store", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestCreatorUserField () {
      return this.requestCreatorUserField(true);
    }
    public APIRequestGetClientProductCatalogs requestCreatorUserField (boolean value) {
      this.requestField("creator_user", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetClientProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetClientProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestIsCatalogSegmentField () {
      return this.requestIsCatalogSegmentField(true);
    }
    public APIRequestGetClientProductCatalogs requestIsCatalogSegmentField (boolean value) {
      this.requestField("is_catalog_segment", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestIsLocalCatalogField () {
      return this.requestIsLocalCatalogField(true);
    }
    public APIRequestGetClientProductCatalogs requestIsLocalCatalogField (boolean value) {
      this.requestField("is_local_catalog", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientProductCatalogs requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetClientProductCatalogs requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetClientProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestGetClientWhatsAppBusinessAccounts extends APIRequest<WhatsAppBusinessAccount> {

    APINodeList<WhatsAppBusinessAccount> lastResponse = null;
    @Override
    public APINodeList<WhatsAppBusinessAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_review_status",
      "analytics",
      "auth_international_rate_eligibility",
      "business_verification_status",
      "country",
      "creation_time",
      "currency",
      "health_status",
      "id",
      "is_enabled_for_insights",
      "linked_commerce_account",
      "message_template_namespace",
      "name",
      "on_behalf_of_business_info",
      "owner_business",
      "owner_business_info",
      "ownership_type",
      "primary_business_location",
      "primary_funding_id",
      "purchase_order_number",
      "status",
      "timezone_id",
    };

    @Override
    public APINodeList<WhatsAppBusinessAccount> parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<WhatsAppBusinessAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<WhatsAppBusinessAccount> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<WhatsAppBusinessAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<WhatsAppBusinessAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<WhatsAppBusinessAccount>>() {
           public APINodeList<WhatsAppBusinessAccount> apply(ResponseWrapper result) {
             try {
               return APIRequestGetClientWhatsAppBusinessAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClientWhatsAppBusinessAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/client_whatsapp_business_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientWhatsAppBusinessAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientWhatsAppBusinessAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientWhatsAppBusinessAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientWhatsAppBusinessAccounts requestAccountReviewStatusField () {
      return this.requestAccountReviewStatusField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAccountReviewStatusField (boolean value) {
      this.requestField("account_review_status", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAnalyticsField () {
      return this.requestAnalyticsField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAnalyticsField (boolean value) {
      this.requestField("analytics", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAuthInternationalRateEligibilityField () {
      return this.requestAuthInternationalRateEligibilityField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAuthInternationalRateEligibilityField (boolean value) {
      this.requestField("auth_international_rate_eligibility", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestBusinessVerificationStatusField () {
      return this.requestBusinessVerificationStatusField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestBusinessVerificationStatusField (boolean value) {
      this.requestField("business_verification_status", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestHealthStatusField () {
      return this.requestHealthStatusField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestHealthStatusField (boolean value) {
      this.requestField("health_status", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIsEnabledForInsightsField () {
      return this.requestIsEnabledForInsightsField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIsEnabledForInsightsField (boolean value) {
      this.requestField("is_enabled_for_insights", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestLinkedCommerceAccountField () {
      return this.requestLinkedCommerceAccountField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestLinkedCommerceAccountField (boolean value) {
      this.requestField("linked_commerce_account", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestMessageTemplateNamespaceField () {
      return this.requestMessageTemplateNamespaceField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestMessageTemplateNamespaceField (boolean value) {
      this.requestField("message_template_namespace", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOnBehalfOfBusinessInfoField () {
      return this.requestOnBehalfOfBusinessInfoField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOnBehalfOfBusinessInfoField (boolean value) {
      this.requestField("on_behalf_of_business_info", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnerBusinessInfoField () {
      return this.requestOwnerBusinessInfoField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnerBusinessInfoField (boolean value) {
      this.requestField("owner_business_info", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnershipTypeField () {
      return this.requestOwnershipTypeField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestOwnershipTypeField (boolean value) {
      this.requestField("ownership_type", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPrimaryBusinessLocationField () {
      return this.requestPrimaryBusinessLocationField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPrimaryBusinessLocationField (boolean value) {
      this.requestField("primary_business_location", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPrimaryFundingIdField () {
      return this.requestPrimaryFundingIdField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPrimaryFundingIdField (boolean value) {
      this.requestField("primary_funding_id", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPurchaseOrderNumberField () {
      return this.requestPurchaseOrderNumberField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestPurchaseOrderNumberField (boolean value) {
      this.requestField("purchase_order_number", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
  }

  public static class APIRequestDeleteClients extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
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
               return APIRequestDeleteClients.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteClients(String nodeId, APIContext context) {
      super(context, nodeId, "/clients", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteClients setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteClients setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteClients setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteClients requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteClients requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClients requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteClients requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClients requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteClients requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClients extends APIRequest<Business> {

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
               return APIRequestGetClients.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetClients(String nodeId, APIContext context) {
      super(context, nodeId, "/clients", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClients setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClients setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClients requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClients requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClients requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClients requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClients requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClients requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClients requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetClients requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetClients requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetClients requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetClients requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetClients requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetClients requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetClients requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGetClients requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetClients requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetClients requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetClients requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetClients requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetClients requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetClients requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClients requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClients requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetClients requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetClients requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetClients requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetClients requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClients requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClients requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetClients requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetClients requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetClients requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetClients requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetClients requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetClients requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetClients requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetClients requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetClients requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetClients requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetClients requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetClients requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetClients requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetClients requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetClients requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetClients requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetClients requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetClients requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetClients requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestGetCollaborativeAdsCollaborationRequests extends APIRequest<CPASCollaborationRequest> {

    APINodeList<CPASCollaborationRequest> lastResponse = null;
    @Override
    public APINodeList<CPASCollaborationRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "brands",
      "contact_email",
      "contact_first_name",
      "contact_last_name",
      "id",
      "phone_number",
      "receiver_business",
      "requester_agency_or_brand",
      "sender_client_business",
      "status",
    };

    @Override
    public APINodeList<CPASCollaborationRequest> parseResponse(String response, String header) throws APIException {
      return CPASCollaborationRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CPASCollaborationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CPASCollaborationRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CPASCollaborationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CPASCollaborationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CPASCollaborationRequest>>() {
           public APINodeList<CPASCollaborationRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCollaborativeAdsCollaborationRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCollaborativeAdsCollaborationRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/collaborative_ads_collaboration_requests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCollaborativeAdsCollaborationRequests setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetCollaborativeAdsCollaborationRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCollaborativeAdsCollaborationRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsCollaborationRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCollaborativeAdsCollaborationRequests requestBrandsField () {
      return this.requestBrandsField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestBrandsField (boolean value) {
      this.requestField("brands", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactFirstNameField () {
      return this.requestContactFirstNameField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactFirstNameField (boolean value) {
      this.requestField("contact_first_name", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactLastNameField () {
      return this.requestContactLastNameField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestContactLastNameField (boolean value) {
      this.requestField("contact_last_name", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestReceiverBusinessField () {
      return this.requestReceiverBusinessField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestReceiverBusinessField (boolean value) {
      this.requestField("receiver_business", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestRequesterAgencyOrBrandField () {
      return this.requestRequesterAgencyOrBrandField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestRequesterAgencyOrBrandField (boolean value) {
      this.requestField("requester_agency_or_brand", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestSenderClientBusinessField () {
      return this.requestSenderClientBusinessField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestSenderClientBusinessField (boolean value) {
      this.requestField("sender_client_business", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCollaborativeAdsCollaborationRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreateCollaborativeAdsCollaborationRequest extends APIRequest<CPASCollaborationRequest> {

    CPASCollaborationRequest lastResponse = null;
    @Override
    public CPASCollaborationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "brands",
      "contact_email",
      "contact_first_name",
      "contact_last_name",
      "phone_number",
      "receiver_business",
      "requester_agency_or_brand",
      "sender_client_business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CPASCollaborationRequest parseResponse(String response, String header) throws APIException {
      return CPASCollaborationRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASCollaborationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASCollaborationRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASCollaborationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASCollaborationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASCollaborationRequest>() {
           public CPASCollaborationRequest apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCollaborativeAdsCollaborationRequest.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCollaborativeAdsCollaborationRequest(String nodeId, APIContext context) {
      super(context, nodeId, "/collaborative_ads_collaboration_requests", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCollaborativeAdsCollaborationRequest setBrands (List<String> brands) {
      this.setParam("brands", brands);
      return this;
    }
    public APIRequestCreateCollaborativeAdsCollaborationRequest setBrands (String brands) {
      this.setParam("brands", brands);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setContactEmail (String contactEmail) {
      this.setParam("contact_email", contactEmail);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setContactFirstName (String contactFirstName) {
      this.setParam("contact_first_name", contactFirstName);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setContactLastName (String contactLastName) {
      this.setParam("contact_last_name", contactLastName);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setPhoneNumber (String phoneNumber) {
      this.setParam("phone_number", phoneNumber);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setReceiverBusiness (String receiverBusiness) {
      this.setParam("receiver_business", receiverBusiness);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setRequesterAgencyOrBrand (CPASCollaborationRequest.EnumRequesterAgencyOrBrand requesterAgencyOrBrand) {
      this.setParam("requester_agency_or_brand", requesterAgencyOrBrand);
      return this;
    }
    public APIRequestCreateCollaborativeAdsCollaborationRequest setRequesterAgencyOrBrand (String requesterAgencyOrBrand) {
      this.setParam("requester_agency_or_brand", requesterAgencyOrBrand);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest setSenderClientBusiness (String senderClientBusiness) {
      this.setParam("sender_client_business", senderClientBusiness);
      return this;
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCollaborativeAdsCollaborationRequest requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCollaborativeAdsCollaborationRequest requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCollaborativeAdsSuggestedPartners extends APIRequest<CPASAdvertiserPartnershipRecommendation> {

    APINodeList<CPASAdvertiserPartnershipRecommendation> lastResponse = null;
    @Override
    public APINodeList<CPASAdvertiserPartnershipRecommendation> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "advertiser_business_id",
      "brand_business_id",
      "brands",
      "countries",
      "id",
      "merchant_business_id",
      "merchant_categories",
      "status",
      "status_reason",
    };

    @Override
    public APINodeList<CPASAdvertiserPartnershipRecommendation> parseResponse(String response, String header) throws APIException {
      return CPASAdvertiserPartnershipRecommendation.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CPASAdvertiserPartnershipRecommendation> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CPASAdvertiserPartnershipRecommendation> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CPASAdvertiserPartnershipRecommendation>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CPASAdvertiserPartnershipRecommendation>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CPASAdvertiserPartnershipRecommendation>>() {
           public APINodeList<CPASAdvertiserPartnershipRecommendation> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCollaborativeAdsSuggestedPartners.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCollaborativeAdsSuggestedPartners(String nodeId, APIContext context) {
      super(context, nodeId, "/collaborative_ads_suggested_partners", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCollaborativeAdsSuggestedPartners requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCollaborativeAdsSuggestedPartners requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCollaborativeAdsSuggestedPartners requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCollaborativeAdsSuggestedPartners requestAdvertiserBusinessIdField () {
      return this.requestAdvertiserBusinessIdField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestAdvertiserBusinessIdField (boolean value) {
      this.requestField("advertiser_business_id", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestBrandBusinessIdField () {
      return this.requestBrandBusinessIdField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestBrandBusinessIdField (boolean value) {
      this.requestField("brand_business_id", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestBrandsField () {
      return this.requestBrandsField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestBrandsField (boolean value) {
      this.requestField("brands", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestCountriesField () {
      return this.requestCountriesField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestCountriesField (boolean value) {
      this.requestField("countries", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestMerchantBusinessIdField () {
      return this.requestMerchantBusinessIdField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestMerchantBusinessIdField (boolean value) {
      this.requestField("merchant_business_id", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestMerchantCategoriesField () {
      return this.requestMerchantCategoriesField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestMerchantCategoriesField (boolean value) {
      this.requestField("merchant_categories", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestStatusReasonField () {
      return this.requestStatusReasonField(true);
    }
    public APIRequestGetCollaborativeAdsSuggestedPartners requestStatusReasonField (boolean value) {
      this.requestField("status_reason", value);
      return this;
    }
  }

  public static class APIRequestGetCommerceMerchantSettings extends APIRequest<CommerceMerchantSettings> {

    APINodeList<CommerceMerchantSettings> lastResponse = null;
    @Override
    public APINodeList<CommerceMerchantSettings> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "checkout_message",
      "contact_email",
      "cta",
      "display_name",
      "facebook_channel",
      "id",
      "instagram_channel",
      "merchant_page",
      "merchant_status",
      "onsite_commerce_merchant",
      "payment_provider",
      "review_rejection_messages",
      "review_rejection_reasons",
      "terms",
    };

    @Override
    public APINodeList<CommerceMerchantSettings> parseResponse(String response, String header) throws APIException {
      return CommerceMerchantSettings.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CommerceMerchantSettings> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CommerceMerchantSettings> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CommerceMerchantSettings>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CommerceMerchantSettings>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CommerceMerchantSettings>>() {
           public APINodeList<CommerceMerchantSettings> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCommerceMerchantSettings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCommerceMerchantSettings(String nodeId, APIContext context) {
      super(context, nodeId, "/commerce_merchant_settings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCommerceMerchantSettings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCommerceMerchantSettings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCommerceMerchantSettings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCommerceMerchantSettings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceMerchantSettings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCommerceMerchantSettings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCommerceMerchantSettings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCommerceMerchantSettings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCommerceMerchantSettings requestCheckoutMessageField () {
      return this.requestCheckoutMessageField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestCheckoutMessageField (boolean value) {
      this.requestField("checkout_message", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestCtaField () {
      return this.requestCtaField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestCtaField (boolean value) {
      this.requestField("cta", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestDisplayNameField () {
      return this.requestDisplayNameField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestDisplayNameField (boolean value) {
      this.requestField("display_name", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestFacebookChannelField () {
      return this.requestFacebookChannelField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestFacebookChannelField (boolean value) {
      this.requestField("facebook_channel", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestInstagramChannelField () {
      return this.requestInstagramChannelField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestInstagramChannelField (boolean value) {
      this.requestField("instagram_channel", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestMerchantPageField () {
      return this.requestMerchantPageField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestMerchantPageField (boolean value) {
      this.requestField("merchant_page", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestMerchantStatusField () {
      return this.requestMerchantStatusField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestMerchantStatusField (boolean value) {
      this.requestField("merchant_status", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestOnsiteCommerceMerchantField () {
      return this.requestOnsiteCommerceMerchantField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestOnsiteCommerceMerchantField (boolean value) {
      this.requestField("onsite_commerce_merchant", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestPaymentProviderField () {
      return this.requestPaymentProviderField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestPaymentProviderField (boolean value) {
      this.requestField("payment_provider", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestReviewRejectionMessagesField () {
      return this.requestReviewRejectionMessagesField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestReviewRejectionMessagesField (boolean value) {
      this.requestField("review_rejection_messages", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
  }

  public static class APIRequestGetCpasBusinessSetupConfig extends APIRequest<CPASBusinessSetupConfig> {

    APINodeList<CPASBusinessSetupConfig> lastResponse = null;
    @Override
    public APINodeList<CPASBusinessSetupConfig> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "accepted_collab_ads_tos",
      "business",
      "business_capabilities_status",
      "capabilities_compliance_status",
      "id",
    };

    @Override
    public APINodeList<CPASBusinessSetupConfig> parseResponse(String response, String header) throws APIException {
      return CPASBusinessSetupConfig.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CPASBusinessSetupConfig> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CPASBusinessSetupConfig> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CPASBusinessSetupConfig>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CPASBusinessSetupConfig>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CPASBusinessSetupConfig>>() {
           public APINodeList<CPASBusinessSetupConfig> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCpasBusinessSetupConfig.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCpasBusinessSetupConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/cpas_business_setup_config", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCpasBusinessSetupConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCpasBusinessSetupConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCpasBusinessSetupConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCpasBusinessSetupConfig requestAcceptedCollabAdsTosField () {
      return this.requestAcceptedCollabAdsTosField(true);
    }
    public APIRequestGetCpasBusinessSetupConfig requestAcceptedCollabAdsTosField (boolean value) {
      this.requestField("accepted_collab_ads_tos", value);
      return this;
    }
    public APIRequestGetCpasBusinessSetupConfig requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetCpasBusinessSetupConfig requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetCpasBusinessSetupConfig requestBusinessCapabilitiesStatusField () {
      return this.requestBusinessCapabilitiesStatusField(true);
    }
    public APIRequestGetCpasBusinessSetupConfig requestBusinessCapabilitiesStatusField (boolean value) {
      this.requestField("business_capabilities_status", value);
      return this;
    }
    public APIRequestGetCpasBusinessSetupConfig requestCapabilitiesComplianceStatusField () {
      return this.requestCapabilitiesComplianceStatusField(true);
    }
    public APIRequestGetCpasBusinessSetupConfig requestCapabilitiesComplianceStatusField (boolean value) {
      this.requestField("capabilities_compliance_status", value);
      return this;
    }
    public APIRequestGetCpasBusinessSetupConfig requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCpasBusinessSetupConfig requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateCpasBusinessSetupConfig extends APIRequest<CPASBusinessSetupConfig> {

    CPASBusinessSetupConfig lastResponse = null;
    @Override
    public CPASBusinessSetupConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "accepted_collab_ads_tos",
      "ad_accounts",
      "business_capabilities_status",
      "capabilities_compliance_status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CPASBusinessSetupConfig parseResponse(String response, String header) throws APIException {
      return CPASBusinessSetupConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASBusinessSetupConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASBusinessSetupConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASBusinessSetupConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASBusinessSetupConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASBusinessSetupConfig>() {
           public CPASBusinessSetupConfig apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCpasBusinessSetupConfig.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCpasBusinessSetupConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/cpas_business_setup_config", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCpasBusinessSetupConfig setAcceptedCollabAdsTos (Boolean acceptedCollabAdsTos) {
      this.setParam("accepted_collab_ads_tos", acceptedCollabAdsTos);
      return this;
    }
    public APIRequestCreateCpasBusinessSetupConfig setAcceptedCollabAdsTos (String acceptedCollabAdsTos) {
      this.setParam("accepted_collab_ads_tos", acceptedCollabAdsTos);
      return this;
    }

    public APIRequestCreateCpasBusinessSetupConfig setAdAccounts (List<String> adAccounts) {
      this.setParam("ad_accounts", adAccounts);
      return this;
    }
    public APIRequestCreateCpasBusinessSetupConfig setAdAccounts (String adAccounts) {
      this.setParam("ad_accounts", adAccounts);
      return this;
    }

    public APIRequestCreateCpasBusinessSetupConfig setBusinessCapabilitiesStatus (Map<String, String> businessCapabilitiesStatus) {
      this.setParam("business_capabilities_status", businessCapabilitiesStatus);
      return this;
    }
    public APIRequestCreateCpasBusinessSetupConfig setBusinessCapabilitiesStatus (String businessCapabilitiesStatus) {
      this.setParam("business_capabilities_status", businessCapabilitiesStatus);
      return this;
    }

    public APIRequestCreateCpasBusinessSetupConfig setCapabilitiesComplianceStatus (Map<String, String> capabilitiesComplianceStatus) {
      this.setParam("capabilities_compliance_status", capabilitiesComplianceStatus);
      return this;
    }
    public APIRequestCreateCpasBusinessSetupConfig setCapabilitiesComplianceStatus (String capabilitiesComplianceStatus) {
      this.setParam("capabilities_compliance_status", capabilitiesComplianceStatus);
      return this;
    }

    public APIRequestCreateCpasBusinessSetupConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCpasBusinessSetupConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCpasBusinessSetupConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCpasMerchantConfig extends APIRequest<CPASMerchantConfig> {

    APINodeList<CPASMerchantConfig> lastResponse = null;
    @Override
    public APINodeList<CPASMerchantConfig> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "accepted_tos",
      "beta_features",
      "business_outcomes_status",
      "id",
      "is_test_merchant",
      "outcomes_compliance_status",
      "qualified_to_onboard",
    };

    @Override
    public APINodeList<CPASMerchantConfig> parseResponse(String response, String header) throws APIException {
      return CPASMerchantConfig.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CPASMerchantConfig> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CPASMerchantConfig> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CPASMerchantConfig>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CPASMerchantConfig>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CPASMerchantConfig>>() {
           public APINodeList<CPASMerchantConfig> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCpasMerchantConfig.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCpasMerchantConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/cpas_merchant_config", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCpasMerchantConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCpasMerchantConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCpasMerchantConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCpasMerchantConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCpasMerchantConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCpasMerchantConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCpasMerchantConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCpasMerchantConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCpasMerchantConfig requestAcceptedTosField () {
      return this.requestAcceptedTosField(true);
    }
    public APIRequestGetCpasMerchantConfig requestAcceptedTosField (boolean value) {
      this.requestField("accepted_tos", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestBetaFeaturesField () {
      return this.requestBetaFeaturesField(true);
    }
    public APIRequestGetCpasMerchantConfig requestBetaFeaturesField (boolean value) {
      this.requestField("beta_features", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestBusinessOutcomesStatusField () {
      return this.requestBusinessOutcomesStatusField(true);
    }
    public APIRequestGetCpasMerchantConfig requestBusinessOutcomesStatusField (boolean value) {
      this.requestField("business_outcomes_status", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCpasMerchantConfig requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestIsTestMerchantField () {
      return this.requestIsTestMerchantField(true);
    }
    public APIRequestGetCpasMerchantConfig requestIsTestMerchantField (boolean value) {
      this.requestField("is_test_merchant", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestOutcomesComplianceStatusField () {
      return this.requestOutcomesComplianceStatusField(true);
    }
    public APIRequestGetCpasMerchantConfig requestOutcomesComplianceStatusField (boolean value) {
      this.requestField("outcomes_compliance_status", value);
      return this;
    }
    public APIRequestGetCpasMerchantConfig requestQualifiedToOnboardField () {
      return this.requestQualifiedToOnboardField(true);
    }
    public APIRequestGetCpasMerchantConfig requestQualifiedToOnboardField (boolean value) {
      this.requestField("qualified_to_onboard", value);
      return this;
    }
  }

  public static class APIRequestCreateCreativeFolder extends APIRequest<BusinessCreativeFolder> {

    BusinessCreativeFolder lastResponse = null;
    @Override
    public BusinessCreativeFolder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "description",
      "name",
      "parent_folder_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessCreativeFolder parseResponse(String response, String header) throws APIException {
      return BusinessCreativeFolder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessCreativeFolder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessCreativeFolder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessCreativeFolder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessCreativeFolder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessCreativeFolder>() {
           public BusinessCreativeFolder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCreativeFolder.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCreativeFolder(String nodeId, APIContext context) {
      super(context, nodeId, "/creative_folders", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCreativeFolder setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCreativeFolder setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCreativeFolder setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateCreativeFolder setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCreativeFolder setParentFolderId (String parentFolderId) {
      this.setParam("parent_folder_id", parentFolderId);
      return this;
    }

    public APIRequestCreateCreativeFolder requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCreativeFolder requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreativeFolder requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCreativeFolder requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreativeFolder requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCreativeFolder requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCreditCards extends APIRequest<CreditCard> {

    APINodeList<CreditCard> lastResponse = null;
    @Override
    public APINodeList<CreditCard> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "billing_address",
      "card_cobadging",
      "card_holder_name",
      "card_type",
      "credential_id",
      "default_receiving_method_products",
      "expiry_month",
      "expiry_year",
      "id",
      "is_cvv_tricky_bin",
      "is_enabled",
      "is_last_used",
      "is_network_tokenized_in_india",
      "is_soft_disabled",
      "is_user_verified",
      "is_zip_verified",
      "last4",
      "readable_card_type",
      "time_created",
      "time_created_ts",
      "type",
    };

    @Override
    public APINodeList<CreditCard> parseResponse(String response, String header) throws APIException {
      return CreditCard.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CreditCard> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CreditCard> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CreditCard>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CreditCard>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CreditCard>>() {
           public APINodeList<CreditCard> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCreditCards.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCreditCards(String nodeId, APIContext context) {
      super(context, nodeId, "/creditcards", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCreditCards setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCreditCards setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCreditCards requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCreditCards requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreditCards requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCreditCards requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreditCards requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCreditCards requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCreditCards requestBillingAddressField () {
      return this.requestBillingAddressField(true);
    }
    public APIRequestGetCreditCards requestBillingAddressField (boolean value) {
      this.requestField("billing_address", value);
      return this;
    }
    public APIRequestGetCreditCards requestCardCobadgingField () {
      return this.requestCardCobadgingField(true);
    }
    public APIRequestGetCreditCards requestCardCobadgingField (boolean value) {
      this.requestField("card_cobadging", value);
      return this;
    }
    public APIRequestGetCreditCards requestCardHolderNameField () {
      return this.requestCardHolderNameField(true);
    }
    public APIRequestGetCreditCards requestCardHolderNameField (boolean value) {
      this.requestField("card_holder_name", value);
      return this;
    }
    public APIRequestGetCreditCards requestCardTypeField () {
      return this.requestCardTypeField(true);
    }
    public APIRequestGetCreditCards requestCardTypeField (boolean value) {
      this.requestField("card_type", value);
      return this;
    }
    public APIRequestGetCreditCards requestCredentialIdField () {
      return this.requestCredentialIdField(true);
    }
    public APIRequestGetCreditCards requestCredentialIdField (boolean value) {
      this.requestField("credential_id", value);
      return this;
    }
    public APIRequestGetCreditCards requestDefaultReceivingMethodProductsField () {
      return this.requestDefaultReceivingMethodProductsField(true);
    }
    public APIRequestGetCreditCards requestDefaultReceivingMethodProductsField (boolean value) {
      this.requestField("default_receiving_method_products", value);
      return this;
    }
    public APIRequestGetCreditCards requestExpiryMonthField () {
      return this.requestExpiryMonthField(true);
    }
    public APIRequestGetCreditCards requestExpiryMonthField (boolean value) {
      this.requestField("expiry_month", value);
      return this;
    }
    public APIRequestGetCreditCards requestExpiryYearField () {
      return this.requestExpiryYearField(true);
    }
    public APIRequestGetCreditCards requestExpiryYearField (boolean value) {
      this.requestField("expiry_year", value);
      return this;
    }
    public APIRequestGetCreditCards requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCreditCards requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsCvvTrickyBinField () {
      return this.requestIsCvvTrickyBinField(true);
    }
    public APIRequestGetCreditCards requestIsCvvTrickyBinField (boolean value) {
      this.requestField("is_cvv_tricky_bin", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsEnabledField () {
      return this.requestIsEnabledField(true);
    }
    public APIRequestGetCreditCards requestIsEnabledField (boolean value) {
      this.requestField("is_enabled", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsLastUsedField () {
      return this.requestIsLastUsedField(true);
    }
    public APIRequestGetCreditCards requestIsLastUsedField (boolean value) {
      this.requestField("is_last_used", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsNetworkTokenizedInIndiaField () {
      return this.requestIsNetworkTokenizedInIndiaField(true);
    }
    public APIRequestGetCreditCards requestIsNetworkTokenizedInIndiaField (boolean value) {
      this.requestField("is_network_tokenized_in_india", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsSoftDisabledField () {
      return this.requestIsSoftDisabledField(true);
    }
    public APIRequestGetCreditCards requestIsSoftDisabledField (boolean value) {
      this.requestField("is_soft_disabled", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsUserVerifiedField () {
      return this.requestIsUserVerifiedField(true);
    }
    public APIRequestGetCreditCards requestIsUserVerifiedField (boolean value) {
      this.requestField("is_user_verified", value);
      return this;
    }
    public APIRequestGetCreditCards requestIsZipVerifiedField () {
      return this.requestIsZipVerifiedField(true);
    }
    public APIRequestGetCreditCards requestIsZipVerifiedField (boolean value) {
      this.requestField("is_zip_verified", value);
      return this;
    }
    public APIRequestGetCreditCards requestLast4Field () {
      return this.requestLast4Field(true);
    }
    public APIRequestGetCreditCards requestLast4Field (boolean value) {
      this.requestField("last4", value);
      return this;
    }
    public APIRequestGetCreditCards requestReadableCardTypeField () {
      return this.requestReadableCardTypeField(true);
    }
    public APIRequestGetCreditCards requestReadableCardTypeField (boolean value) {
      this.requestField("readable_card_type", value);
      return this;
    }
    public APIRequestGetCreditCards requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetCreditCards requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetCreditCards requestTimeCreatedTsField () {
      return this.requestTimeCreatedTsField(true);
    }
    public APIRequestGetCreditCards requestTimeCreatedTsField (boolean value) {
      this.requestField("time_created_ts", value);
      return this;
    }
    public APIRequestGetCreditCards requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetCreditCards requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestCreateCustomConversion extends APIRequest<CustomConversion> {

    CustomConversion lastResponse = null;
    @Override
    public CustomConversion getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_source_type",
      "advanced_rule",
      "custom_event_type",
      "default_conversion_value",
      "description",
      "event_source_id",
      "name",
      "rule",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomConversion parseResponse(String response, String header) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CustomConversion execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomConversion execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CustomConversion> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomConversion> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CustomConversion>() {
           public CustomConversion apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCustomConversion.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCustomConversion(String nodeId, APIContext context) {
      super(context, nodeId, "/customconversions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCustomConversion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCustomConversion setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCustomConversion setActionSourceType (CustomConversion.EnumActionSourceType actionSourceType) {
      this.setParam("action_source_type", actionSourceType);
      return this;
    }
    public APIRequestCreateCustomConversion setActionSourceType (String actionSourceType) {
      this.setParam("action_source_type", actionSourceType);
      return this;
    }

    public APIRequestCreateCustomConversion setAdvancedRule (String advancedRule) {
      this.setParam("advanced_rule", advancedRule);
      return this;
    }

    public APIRequestCreateCustomConversion setCustomEventType (CustomConversion.EnumCustomEventType customEventType) {
      this.setParam("custom_event_type", customEventType);
      return this;
    }
    public APIRequestCreateCustomConversion setCustomEventType (String customEventType) {
      this.setParam("custom_event_type", customEventType);
      return this;
    }

    public APIRequestCreateCustomConversion setDefaultConversionValue (Double defaultConversionValue) {
      this.setParam("default_conversion_value", defaultConversionValue);
      return this;
    }
    public APIRequestCreateCustomConversion setDefaultConversionValue (String defaultConversionValue) {
      this.setParam("default_conversion_value", defaultConversionValue);
      return this;
    }

    public APIRequestCreateCustomConversion setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateCustomConversion setEventSourceId (String eventSourceId) {
      this.setParam("event_source_id", eventSourceId);
      return this;
    }

    public APIRequestCreateCustomConversion setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCustomConversion setRule (String rule) {
      this.setParam("rule", rule);
      return this;
    }

    public APIRequestCreateCustomConversion requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCustomConversion requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomConversion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCustomConversion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomConversion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCustomConversion requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateDraftNegativeKeywordList extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "negative_keyword_list_file",
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
               return APIRequestCreateDraftNegativeKeywordList.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDraftNegativeKeywordList(String nodeId, APIContext context) {
      super(context, nodeId, "/draft_negative_keyword_lists", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDraftNegativeKeywordList setNegativeKeywordListFile (File negativeKeywordListFile) {
      this.setParam("negative_keyword_list_file", negativeKeywordListFile);
      return this;
    }
    public APIRequestCreateDraftNegativeKeywordList setNegativeKeywordListFile (String negativeKeywordListFile) {
      this.setParam("negative_keyword_list_file", negativeKeywordListFile);
      return this;
    }

    public APIRequestCreateDraftNegativeKeywordList requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDraftNegativeKeywordList requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDraftNegativeKeywordList requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetEventSourceGroups extends APIRequest<EventSourceGroup> {

    APINodeList<EventSourceGroup> lastResponse = null;
    @Override
    public APINodeList<EventSourceGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "event_sources",
      "id",
      "name",
      "owner_business",
    };

    @Override
    public APINodeList<EventSourceGroup> parseResponse(String response, String header) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<EventSourceGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<EventSourceGroup> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<EventSourceGroup>>() {
           public APINodeList<EventSourceGroup> apply(ResponseWrapper result) {
             try {
               return APIRequestGetEventSourceGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetEventSourceGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/event_source_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEventSourceGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEventSourceGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEventSourceGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEventSourceGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEventSourceGroups requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetEventSourceGroups requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestEventSourcesField () {
      return this.requestEventSourcesField(true);
    }
    public APIRequestGetEventSourceGroups requestEventSourcesField (boolean value) {
      this.requestField("event_sources", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEventSourceGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetEventSourceGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetEventSourceGroups requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestCreateEventSourceGroup extends APIRequest<EventSourceGroup> {

    EventSourceGroup lastResponse = null;
    @Override
    public EventSourceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "event_sources",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public EventSourceGroup parseResponse(String response, String header) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<EventSourceGroup> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventSourceGroup> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, EventSourceGroup>() {
           public EventSourceGroup apply(ResponseWrapper result) {
             try {
               return APIRequestCreateEventSourceGroup.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateEventSourceGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/event_source_groups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateEventSourceGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateEventSourceGroup setEventSources (List<String> eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }
    public APIRequestCreateEventSourceGroup setEventSources (String eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }

    public APIRequestCreateEventSourceGroup setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateEventSourceGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateEventSourceGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateEventSourceGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetExtendedCreditApplications extends APIRequest<ExtendedCreditApplication> {

    APINodeList<ExtendedCreditApplication> lastResponse = null;
    @Override
    public APINodeList<ExtendedCreditApplication> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "only_show_pending",
    };

    public static final String[] FIELDS = {
      "billing_country",
      "city",
      "cnpj",
      "country",
      "display_currency",
      "duns_number",
      "id",
      "invoice_email_address",
      "is_umi",
      "legal_entity_name",
      "original_online_limit",
      "phone_number",
      "postal_code",
      "product_types",
      "proposed_credit_limit",
      "registration_number",
      "run_id",
      "state",
      "status",
      "street1",
      "street2",
      "submitter",
      "tax_exempt_status",
      "tax_id",
      "terms",
    };

    @Override
    public APINodeList<ExtendedCreditApplication> parseResponse(String response, String header) throws APIException {
      return ExtendedCreditApplication.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ExtendedCreditApplication> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCreditApplication> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCreditApplication>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCreditApplication>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ExtendedCreditApplication>>() {
           public APINodeList<ExtendedCreditApplication> apply(ResponseWrapper result) {
             try {
               return APIRequestGetExtendedCreditApplications.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetExtendedCreditApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/extendedcreditapplications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExtendedCreditApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExtendedCreditApplications setOnlyShowPending (Boolean onlyShowPending) {
      this.setParam("only_show_pending", onlyShowPending);
      return this;
    }
    public APIRequestGetExtendedCreditApplications setOnlyShowPending (String onlyShowPending) {
      this.setParam("only_show_pending", onlyShowPending);
      return this;
    }

    public APIRequestGetExtendedCreditApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExtendedCreditApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExtendedCreditApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExtendedCreditApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExtendedCreditApplications requestBillingCountryField () {
      return this.requestBillingCountryField(true);
    }
    public APIRequestGetExtendedCreditApplications requestBillingCountryField (boolean value) {
      this.requestField("billing_country", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGetExtendedCreditApplications requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestCnpjField () {
      return this.requestCnpjField(true);
    }
    public APIRequestGetExtendedCreditApplications requestCnpjField (boolean value) {
      this.requestField("cnpj", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetExtendedCreditApplications requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestDisplayCurrencyField () {
      return this.requestDisplayCurrencyField(true);
    }
    public APIRequestGetExtendedCreditApplications requestDisplayCurrencyField (boolean value) {
      this.requestField("display_currency", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestDunsNumberField () {
      return this.requestDunsNumberField(true);
    }
    public APIRequestGetExtendedCreditApplications requestDunsNumberField (boolean value) {
      this.requestField("duns_number", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExtendedCreditApplications requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestInvoiceEmailAddressField () {
      return this.requestInvoiceEmailAddressField(true);
    }
    public APIRequestGetExtendedCreditApplications requestInvoiceEmailAddressField (boolean value) {
      this.requestField("invoice_email_address", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestIsUmiField () {
      return this.requestIsUmiField(true);
    }
    public APIRequestGetExtendedCreditApplications requestIsUmiField (boolean value) {
      this.requestField("is_umi", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGetExtendedCreditApplications requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestOriginalOnlineLimitField () {
      return this.requestOriginalOnlineLimitField(true);
    }
    public APIRequestGetExtendedCreditApplications requestOriginalOnlineLimitField (boolean value) {
      this.requestField("original_online_limit", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGetExtendedCreditApplications requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestPostalCodeField () {
      return this.requestPostalCodeField(true);
    }
    public APIRequestGetExtendedCreditApplications requestPostalCodeField (boolean value) {
      this.requestField("postal_code", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestProductTypesField () {
      return this.requestProductTypesField(true);
    }
    public APIRequestGetExtendedCreditApplications requestProductTypesField (boolean value) {
      this.requestField("product_types", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestProposedCreditLimitField () {
      return this.requestProposedCreditLimitField(true);
    }
    public APIRequestGetExtendedCreditApplications requestProposedCreditLimitField (boolean value) {
      this.requestField("proposed_credit_limit", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestRegistrationNumberField () {
      return this.requestRegistrationNumberField(true);
    }
    public APIRequestGetExtendedCreditApplications requestRegistrationNumberField (boolean value) {
      this.requestField("registration_number", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestRunIdField () {
      return this.requestRunIdField(true);
    }
    public APIRequestGetExtendedCreditApplications requestRunIdField (boolean value) {
      this.requestField("run_id", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGetExtendedCreditApplications requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetExtendedCreditApplications requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestStreet1Field () {
      return this.requestStreet1Field(true);
    }
    public APIRequestGetExtendedCreditApplications requestStreet1Field (boolean value) {
      this.requestField("street1", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestStreet2Field () {
      return this.requestStreet2Field(true);
    }
    public APIRequestGetExtendedCreditApplications requestStreet2Field (boolean value) {
      this.requestField("street2", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestSubmitterField () {
      return this.requestSubmitterField(true);
    }
    public APIRequestGetExtendedCreditApplications requestSubmitterField (boolean value) {
      this.requestField("submitter", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestTaxExemptStatusField () {
      return this.requestTaxExemptStatusField(true);
    }
    public APIRequestGetExtendedCreditApplications requestTaxExemptStatusField (boolean value) {
      this.requestField("tax_exempt_status", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetExtendedCreditApplications requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetExtendedCreditApplications requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGetExtendedCreditApplications requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
  }

  public static class APIRequestGetExtendedCredits extends APIRequest<ExtendedCredit> {

    APINodeList<ExtendedCredit> lastResponse = null;
    @Override
    public APINodeList<ExtendedCredit> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "order_by_is_owned_credential",
    };

    public static final String[] FIELDS = {
      "allocated_amount",
      "balance",
      "credit_available",
      "credit_type",
      "id",
      "is_access_revoked",
      "is_automated_experience",
      "legal_entity_name",
      "liable_address",
      "liable_biz_name",
      "max_balance",
      "online_max_balance",
      "owner_business",
      "owner_business_name",
      "partition_from",
      "receiving_credit_allocation_config",
      "send_bill_to_address",
      "send_bill_to_biz_name",
      "sold_to_address",
    };

    @Override
    public APINodeList<ExtendedCredit> parseResponse(String response, String header) throws APIException {
      return ExtendedCredit.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ExtendedCredit> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCredit> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ExtendedCredit>>() {
           public APINodeList<ExtendedCredit> apply(ResponseWrapper result) {
             try {
               return APIRequestGetExtendedCredits.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetExtendedCredits(String nodeId, APIContext context) {
      super(context, nodeId, "/extendedcredits", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExtendedCredits setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExtendedCredits setOrderByIsOwnedCredential (Boolean orderByIsOwnedCredential) {
      this.setParam("order_by_is_owned_credential", orderByIsOwnedCredential);
      return this;
    }
    public APIRequestGetExtendedCredits setOrderByIsOwnedCredential (String orderByIsOwnedCredential) {
      this.setParam("order_by_is_owned_credential", orderByIsOwnedCredential);
      return this;
    }

    public APIRequestGetExtendedCredits requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExtendedCredits requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExtendedCredits requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExtendedCredits requestAllocatedAmountField () {
      return this.requestAllocatedAmountField(true);
    }
    public APIRequestGetExtendedCredits requestAllocatedAmountField (boolean value) {
      this.requestField("allocated_amount", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestCreditAvailableField () {
      return this.requestCreditAvailableField(true);
    }
    public APIRequestGetExtendedCredits requestCreditAvailableField (boolean value) {
      this.requestField("credit_available", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestCreditTypeField () {
      return this.requestCreditTypeField(true);
    }
    public APIRequestGetExtendedCredits requestCreditTypeField (boolean value) {
      this.requestField("credit_type", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExtendedCredits requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestIsAccessRevokedField () {
      return this.requestIsAccessRevokedField(true);
    }
    public APIRequestGetExtendedCredits requestIsAccessRevokedField (boolean value) {
      this.requestField("is_access_revoked", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestIsAutomatedExperienceField () {
      return this.requestIsAutomatedExperienceField(true);
    }
    public APIRequestGetExtendedCredits requestIsAutomatedExperienceField (boolean value) {
      this.requestField("is_automated_experience", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetExtendedCredits requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLiableBizNameField () {
      return this.requestLiableBizNameField(true);
    }
    public APIRequestGetExtendedCredits requestLiableBizNameField (boolean value) {
      this.requestField("liable_biz_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestMaxBalanceField () {
      return this.requestMaxBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestMaxBalanceField (boolean value) {
      this.requestField("max_balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOnlineMaxBalanceField () {
      return this.requestOnlineMaxBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestOnlineMaxBalanceField (boolean value) {
      this.requestField("online_max_balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessNameField () {
      return this.requestOwnerBusinessNameField(true);
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessNameField (boolean value) {
      this.requestField("owner_business_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestPartitionFromField () {
      return this.requestPartitionFromField(true);
    }
    public APIRequestGetExtendedCredits requestPartitionFromField (boolean value) {
      this.requestField("partition_from", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestReceivingCreditAllocationConfigField () {
      return this.requestReceivingCreditAllocationConfigField(true);
    }
    public APIRequestGetExtendedCredits requestReceivingCreditAllocationConfigField (boolean value) {
      this.requestField("receiving_credit_allocation_config", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetExtendedCredits requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestSendBillToBizNameField () {
      return this.requestSendBillToBizNameField(true);
    }
    public APIRequestGetExtendedCredits requestSendBillToBizNameField (boolean value) {
      this.requestField("send_bill_to_biz_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetExtendedCredits requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
  }

  public static class APIRequestCreateImage extends APIRequest<BusinessImage> {

    BusinessImage lastResponse = null;
    @Override
    public BusinessImage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_placements_validation_only",
      "creative_folder_id",
      "name",
      "validation_ad_placements",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessImage parseResponse(String response, String header) throws APIException {
      return BusinessImage.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessImage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessImage execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessImage> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessImage> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessImage>() {
           public BusinessImage apply(ResponseWrapper result) {
             try {
               return APIRequestCreateImage.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateImage(String nodeId, APIContext context) {
      super(context, nodeId, "/images", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateImage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateImage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateImage addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateImage setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateImage setAdPlacementsValidationOnly (Boolean adPlacementsValidationOnly) {
      this.setParam("ad_placements_validation_only", adPlacementsValidationOnly);
      return this;
    }
    public APIRequestCreateImage setAdPlacementsValidationOnly (String adPlacementsValidationOnly) {
      this.setParam("ad_placements_validation_only", adPlacementsValidationOnly);
      return this;
    }

    public APIRequestCreateImage setCreativeFolderId (String creativeFolderId) {
      this.setParam("creative_folder_id", creativeFolderId);
      return this;
    }

    public APIRequestCreateImage setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateImage setValidationAdPlacements (List<BusinessImage.EnumValidationAdPlacements> validationAdPlacements) {
      this.setParam("validation_ad_placements", validationAdPlacements);
      return this;
    }
    public APIRequestCreateImage setValidationAdPlacements (String validationAdPlacements) {
      this.setParam("validation_ad_placements", validationAdPlacements);
      return this;
    }

    public APIRequestCreateImage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateImage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateImage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateImage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateImage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateImage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInitiatedAudienceSharingRequests extends APIRequest<BusinessAssetSharingAgreement> {

    APINodeList<BusinessAssetSharingAgreement> lastResponse = null;
    @Override
    public APINodeList<BusinessAssetSharingAgreement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "recipient_id",
      "request_status",
    };

    public static final String[] FIELDS = {
      "id",
      "initiator",
      "recipient",
      "relationship_type",
      "request_status",
      "request_type",
    };

    @Override
    public APINodeList<BusinessAssetSharingAgreement> parseResponse(String response, String header) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAssetSharingAgreement>>() {
           public APINodeList<BusinessAssetSharingAgreement> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInitiatedAudienceSharingRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInitiatedAudienceSharingRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/initiated_audience_sharing_requests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInitiatedAudienceSharingRequests setRecipientId (String recipientId) {
      this.setParam("recipient_id", recipientId);
      return this;
    }

    public APIRequestGetInitiatedAudienceSharingRequests setRequestStatus (BusinessAssetSharingAgreement.EnumRequestStatus requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests setRequestStatus (String requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }

    public APIRequestGetInitiatedAudienceSharingRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInitiatedAudienceSharingRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInitiatedAudienceSharingRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInitiatedAudienceSharingRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestInitiatorField () {
      return this.requestInitiatorField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestInitiatorField (boolean value) {
      this.requestField("initiator", value);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRelationshipTypeField () {
      return this.requestRelationshipTypeField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRelationshipTypeField (boolean value) {
      this.requestField("relationship_type", value);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRequestTypeField () {
      return this.requestRequestTypeField(true);
    }
    public APIRequestGetInitiatedAudienceSharingRequests requestRequestTypeField (boolean value) {
      this.requestField("request_type", value);
      return this;
    }
  }

  public static class APIRequestDeleteInstagramAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "instagram_account",
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
               return APIRequestDeleteInstagramAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_accounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteInstagramAccounts setInstagramAccount (String instagramAccount) {
      this.setParam("instagram_account", instagramAccount);
      return this;
    }

    public APIRequestDeleteInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInstagramAccounts extends APIRequest<InstagramUser> {

    APINodeList<InstagramUser> lastResponse = null;
    @Override
    public APINodeList<InstagramUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "follow_count",
      "followed_by_count",
      "has_profile_picture",
      "id",
      "is_private",
      "is_published",
      "media_count",
      "mini_shop_storefront",
      "owner_business",
      "profile_pic",
      "username",
    };

    @Override
    public APINodeList<InstagramUser> parseResponse(String response, String header) throws APIException {
      return InstagramUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramUser>>() {
           public APINodeList<InstagramUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInstagramAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstagramAccounts requestFollowCountField () {
      return this.requestFollowCountField(true);
    }
    public APIRequestGetInstagramAccounts requestFollowCountField (boolean value) {
      this.requestField("follow_count", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestFollowedByCountField () {
      return this.requestFollowedByCountField(true);
    }
    public APIRequestGetInstagramAccounts requestFollowedByCountField (boolean value) {
      this.requestField("followed_by_count", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestHasProfilePictureField () {
      return this.requestHasProfilePictureField(true);
    }
    public APIRequestGetInstagramAccounts requestHasProfilePictureField (boolean value) {
      this.requestField("has_profile_picture", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInstagramAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetInstagramAccounts requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetInstagramAccounts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGetInstagramAccounts requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetInstagramAccounts requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetInstagramAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetInstagramAccounts requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetInstagramAccounts requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetInstagramAccounts requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetInstagramBusinessAccounts extends APIRequest<IGUser> {

    APINodeList<IGUser> lastResponse = null;
    @Override
    public APINodeList<IGUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "biography",
      "business_discovery",
      "followers_count",
      "follows_count",
      "id",
      "ig_id",
      "media_count",
      "mentioned_comment",
      "mentioned_media",
      "name",
      "owner_business",
      "profile_picture_url",
      "shopping_product_tag_eligibility",
      "shopping_review_status",
      "username",
      "website",
    };

    @Override
    public APINodeList<IGUser> parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGUser>>() {
           public APINodeList<IGUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInstagramBusinessAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInstagramBusinessAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_business_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstagramBusinessAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstagramBusinessAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstagramBusinessAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstagramBusinessAccounts requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestBusinessDiscoveryField () {
      return this.requestBusinessDiscoveryField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestBusinessDiscoveryField (boolean value) {
      this.requestField("business_discovery", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestFollowsCountField () {
      return this.requestFollowsCountField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestFollowsCountField (boolean value) {
      this.requestField("follows_count", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestMentionedCommentField () {
      return this.requestMentionedCommentField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestMentionedCommentField (boolean value) {
      this.requestField("mentioned_comment", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestMentionedMediaField () {
      return this.requestMentionedMediaField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestMentionedMediaField (boolean value) {
      this.requestField("mentioned_media", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestProfilePictureUrlField () {
      return this.requestProfilePictureUrlField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestProfilePictureUrlField (boolean value) {
      this.requestField("profile_picture_url", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestShoppingProductTagEligibilityField () {
      return this.requestShoppingProductTagEligibilityField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestShoppingProductTagEligibilityField (boolean value) {
      this.requestField("shopping_product_tag_eligibility", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestShoppingReviewStatusField () {
      return this.requestShoppingReviewStatusField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestShoppingReviewStatusField (boolean value) {
      this.requestField("shopping_review_status", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetInstagramBusinessAccounts requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetInstagramBusinessAccounts requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
  }

  public static class APIRequestDeleteMAnAgeDBusinesses extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "existing_client_business_id",
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
               return APIRequestDeleteMAnAgeDBusinesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteMAnAgeDBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_businesses", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMAnAgeDBusinesses setExistingClientBusinessId (String existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }

    public APIRequestDeleteMAnAgeDBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMAnAgeDBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMAnAgeDBusiness extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_business_external_id",
      "existing_client_business_id",
      "name",
      "sales_rep_email",
      "survey_business_type",
      "survey_num_assets",
      "survey_num_people",
      "timezone_id",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMAnAgeDBusiness.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMAnAgeDBusiness(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_businesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMAnAgeDBusiness setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setExistingClientBusinessId (String existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setSurveyBusinessType (Business.EnumSurveyBusinessType surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }
    public APIRequestCreateMAnAgeDBusiness setSurveyBusinessType (String surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateMAnAgeDBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateMAnAgeDBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setTimezoneId (Business.EnumTimezoneId timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateMAnAgeDBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness setVertical (Business.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateMAnAgeDBusiness setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateMAnAgeDBusiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMAnAgeDBusiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDBusiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMAnAgeDPartnerBusinessSetup extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "active_ad_account_id",
      "active_page_id",
      "partner_facebook_page_url",
      "partner_registration_countries",
      "seller_email_address",
      "seller_external_website_url",
      "template",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMAnAgeDPartnerBusinessSetup.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMAnAgeDPartnerBusinessSetup(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_partner_business_setup", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMAnAgeDPartnerBusinessSetup setActiveAdAccountId (String activeAdAccountId) {
      this.setParam("active_ad_account_id", activeAdAccountId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setActivePageId (Long activePageId) {
      this.setParam("active_page_id", activePageId);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusinessSetup setActivePageId (String activePageId) {
      this.setParam("active_page_id", activePageId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setPartnerFacebookPageUrl (String partnerFacebookPageUrl) {
      this.setParam("partner_facebook_page_url", partnerFacebookPageUrl);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setPartnerRegistrationCountries (List<String> partnerRegistrationCountries) {
      this.setParam("partner_registration_countries", partnerRegistrationCountries);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusinessSetup setPartnerRegistrationCountries (String partnerRegistrationCountries) {
      this.setParam("partner_registration_countries", partnerRegistrationCountries);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setSellerEmailAddress (String sellerEmailAddress) {
      this.setParam("seller_email_address", sellerEmailAddress);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setSellerExternalWebsiteUrl (String sellerExternalWebsiteUrl) {
      this.setParam("seller_external_website_url", sellerExternalWebsiteUrl);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup setTemplate (List<Map<String, String>> template) {
      this.setParam("template", template);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusinessSetup setTemplate (String template) {
      this.setParam("template", template);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusinessSetup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteMAnAgeDPartnerBusinesses extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_business_external_id",
      "child_business_id",
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
               return APIRequestDeleteMAnAgeDPartnerBusinesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteMAnAgeDPartnerBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_partner_businesses", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMAnAgeDPartnerBusinesses setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestDeleteMAnAgeDPartnerBusinesses setChildBusinessId (String childBusinessId) {
      this.setParam("child_business_id", childBusinessId);
      return this;
    }

    public APIRequestDeleteMAnAgeDPartnerBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMAnAgeDPartnerBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMAnAgeDPartnerBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMAnAgeDPartnerBusiness extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account_currency",
      "catalog_id",
      "child_business_external_id",
      "credit_limit",
      "line_of_credit_id",
      "name",
      "no_ad_account",
      "page_name",
      "page_profile_image_url",
      "partition_type",
      "partner_facebook_page_url",
      "partner_registration_countries",
      "sales_rep_email",
      "seller_external_website_url",
      "seller_targeting_countries",
      "skip_partner_page_creation",
      "survey_business_type",
      "survey_num_assets",
      "survey_num_people",
      "timezone_id",
      "vertical",
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
               return APIRequestCreateMAnAgeDPartnerBusiness.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMAnAgeDPartnerBusiness(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_partner_businesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMAnAgeDPartnerBusiness setAdAccountCurrency (String adAccountCurrency) {
      this.setParam("ad_account_currency", adAccountCurrency);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setCreditLimit (Long creditLimit) {
      this.setParam("credit_limit", creditLimit);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setCreditLimit (String creditLimit) {
      this.setParam("credit_limit", creditLimit);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setLineOfCreditId (String lineOfCreditId) {
      this.setParam("line_of_credit_id", lineOfCreditId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setNoAdAccount (Boolean noAdAccount) {
      this.setParam("no_ad_account", noAdAccount);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setNoAdAccount (String noAdAccount) {
      this.setParam("no_ad_account", noAdAccount);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setPageName (String pageName) {
      this.setParam("page_name", pageName);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setPageProfileImageUrl (String pageProfileImageUrl) {
      this.setParam("page_profile_image_url", pageProfileImageUrl);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setPartitionType (EnumPartitionType partitionType) {
      this.setParam("partition_type", partitionType);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setPartitionType (String partitionType) {
      this.setParam("partition_type", partitionType);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setPartnerFacebookPageUrl (String partnerFacebookPageUrl) {
      this.setParam("partner_facebook_page_url", partnerFacebookPageUrl);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setPartnerRegistrationCountries (List<String> partnerRegistrationCountries) {
      this.setParam("partner_registration_countries", partnerRegistrationCountries);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setPartnerRegistrationCountries (String partnerRegistrationCountries) {
      this.setParam("partner_registration_countries", partnerRegistrationCountries);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSellerExternalWebsiteUrl (String sellerExternalWebsiteUrl) {
      this.setParam("seller_external_website_url", sellerExternalWebsiteUrl);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSellerTargetingCountries (List<String> sellerTargetingCountries) {
      this.setParam("seller_targeting_countries", sellerTargetingCountries);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setSellerTargetingCountries (String sellerTargetingCountries) {
      this.setParam("seller_targeting_countries", sellerTargetingCountries);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSkipPartnerPageCreation (Boolean skipPartnerPageCreation) {
      this.setParam("skip_partner_page_creation", skipPartnerPageCreation);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setSkipPartnerPageCreation (String skipPartnerPageCreation) {
      this.setParam("skip_partner_page_creation", skipPartnerPageCreation);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyBusinessType (EnumSurveyBusinessType surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyBusinessType (String surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setTimezoneId (EnumTimezoneId timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness setVertical (EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateMAnAgeDPartnerBusiness setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateMAnAgeDPartnerBusiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMAnAgeDPartnerBusiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMAnAgeDPartnerBusiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetNegativeKeywordLists extends APIRequest<NegativeKeywordList> {

    APINodeList<NegativeKeywordList> lastResponse = null;
    @Override
    public APINodeList<NegativeKeywordList> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applied_active_ad_campaign_groups",
      "applied_inactive_ad_campaign_groups",
      "creator_id",
      "id",
      "is_fully_reviewed",
      "last_update_time",
      "last_update_user_id",
      "list_name",
      "total_approved_keyword_count",
      "total_declined_keyword_count",
      "total_negative_keyword_count",
      "total_validated_keyword_count",
    };

    @Override
    public APINodeList<NegativeKeywordList> parseResponse(String response, String header) throws APIException {
      return NegativeKeywordList.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NegativeKeywordList> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NegativeKeywordList> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NegativeKeywordList>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NegativeKeywordList>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NegativeKeywordList>>() {
           public APINodeList<NegativeKeywordList> apply(ResponseWrapper result) {
             try {
               return APIRequestGetNegativeKeywordLists.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetNegativeKeywordLists(String nodeId, APIContext context) {
      super(context, nodeId, "/negative_keyword_lists", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNegativeKeywordLists setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNegativeKeywordLists setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNegativeKeywordLists requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNegativeKeywordLists requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNegativeKeywordLists requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNegativeKeywordLists requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNegativeKeywordLists requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNegativeKeywordLists requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNegativeKeywordLists requestAppliedActiveAdCampaignGroupsField () {
      return this.requestAppliedActiveAdCampaignGroupsField(true);
    }
    public APIRequestGetNegativeKeywordLists requestAppliedActiveAdCampaignGroupsField (boolean value) {
      this.requestField("applied_active_ad_campaign_groups", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestAppliedInactiveAdCampaignGroupsField () {
      return this.requestAppliedInactiveAdCampaignGroupsField(true);
    }
    public APIRequestGetNegativeKeywordLists requestAppliedInactiveAdCampaignGroupsField (boolean value) {
      this.requestField("applied_inactive_ad_campaign_groups", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestCreatorIdField () {
      return this.requestCreatorIdField(true);
    }
    public APIRequestGetNegativeKeywordLists requestCreatorIdField (boolean value) {
      this.requestField("creator_id", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNegativeKeywordLists requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestIsFullyReviewedField () {
      return this.requestIsFullyReviewedField(true);
    }
    public APIRequestGetNegativeKeywordLists requestIsFullyReviewedField (boolean value) {
      this.requestField("is_fully_reviewed", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestLastUpdateTimeField () {
      return this.requestLastUpdateTimeField(true);
    }
    public APIRequestGetNegativeKeywordLists requestLastUpdateTimeField (boolean value) {
      this.requestField("last_update_time", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestLastUpdateUserIdField () {
      return this.requestLastUpdateUserIdField(true);
    }
    public APIRequestGetNegativeKeywordLists requestLastUpdateUserIdField (boolean value) {
      this.requestField("last_update_user_id", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestListNameField () {
      return this.requestListNameField(true);
    }
    public APIRequestGetNegativeKeywordLists requestListNameField (boolean value) {
      this.requestField("list_name", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestTotalApprovedKeywordCountField () {
      return this.requestTotalApprovedKeywordCountField(true);
    }
    public APIRequestGetNegativeKeywordLists requestTotalApprovedKeywordCountField (boolean value) {
      this.requestField("total_approved_keyword_count", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestTotalDeclinedKeywordCountField () {
      return this.requestTotalDeclinedKeywordCountField(true);
    }
    public APIRequestGetNegativeKeywordLists requestTotalDeclinedKeywordCountField (boolean value) {
      this.requestField("total_declined_keyword_count", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestTotalNegativeKeywordCountField () {
      return this.requestTotalNegativeKeywordCountField(true);
    }
    public APIRequestGetNegativeKeywordLists requestTotalNegativeKeywordCountField (boolean value) {
      this.requestField("total_negative_keyword_count", value);
      return this;
    }
    public APIRequestGetNegativeKeywordLists requestTotalValidatedKeywordCountField () {
      return this.requestTotalValidatedKeywordCountField(true);
    }
    public APIRequestGetNegativeKeywordLists requestTotalValidatedKeywordCountField (boolean value) {
      this.requestField("total_validated_keyword_count", value);
      return this;
    }
  }

  public static class APIRequestGetOpenBridgeConfigurations extends APIRequest<OpenBridgeConfiguration> {

    APINodeList<OpenBridgeConfiguration> lastResponse = null;
    @Override
    public APINodeList<OpenBridgeConfiguration> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "active",
      "endpoint",
      "fallback_domain",
      "fallback_domain_enabled",
      "host_business_id",
      "host_external_id",
      "id",
      "instance_id",
      "pixel_id",
    };

    @Override
    public APINodeList<OpenBridgeConfiguration> parseResponse(String response, String header) throws APIException {
      return OpenBridgeConfiguration.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OpenBridgeConfiguration> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OpenBridgeConfiguration> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OpenBridgeConfiguration>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OpenBridgeConfiguration>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OpenBridgeConfiguration>>() {
           public APINodeList<OpenBridgeConfiguration> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOpenBridgeConfigurations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOpenBridgeConfigurations(String nodeId, APIContext context) {
      super(context, nodeId, "/openbridge_configurations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOpenBridgeConfigurations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOpenBridgeConfigurations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOpenBridgeConfigurations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOpenBridgeConfigurations requestActiveField () {
      return this.requestActiveField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestActiveField (boolean value) {
      this.requestField("active", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestEndpointField () {
      return this.requestEndpointField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestEndpointField (boolean value) {
      this.requestField("endpoint", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestFallbackDomainField () {
      return this.requestFallbackDomainField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestFallbackDomainField (boolean value) {
      this.requestField("fallback_domain", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestFallbackDomainEnabledField () {
      return this.requestFallbackDomainEnabledField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestFallbackDomainEnabledField (boolean value) {
      this.requestField("fallback_domain_enabled", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestHostBusinessIdField () {
      return this.requestHostBusinessIdField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestHostBusinessIdField (boolean value) {
      this.requestField("host_business_id", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestHostExternalIdField () {
      return this.requestHostExternalIdField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestHostExternalIdField (boolean value) {
      this.requestField("host_external_id", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestInstanceIdField () {
      return this.requestInstanceIdField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestInstanceIdField (boolean value) {
      this.requestField("instance_id", value);
      return this;
    }
    public APIRequestGetOpenBridgeConfigurations requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGetOpenBridgeConfigurations requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
  }

  public static class APIRequestCreateOpenBridgeConfiguration extends APIRequest<OpenBridgeConfiguration> {

    OpenBridgeConfiguration lastResponse = null;
    @Override
    public OpenBridgeConfiguration getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "active",
      "endpoint",
      "fallback_domain",
      "fallback_domain_enabled",
      "host_business_id",
      "host_external_id",
      "instance_id",
      "pixel_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OpenBridgeConfiguration parseResponse(String response, String header) throws APIException {
      return OpenBridgeConfiguration.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OpenBridgeConfiguration execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenBridgeConfiguration execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OpenBridgeConfiguration> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenBridgeConfiguration> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OpenBridgeConfiguration>() {
           public OpenBridgeConfiguration apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOpenBridgeConfiguration.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOpenBridgeConfiguration(String nodeId, APIContext context) {
      super(context, nodeId, "/openbridge_configurations", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOpenBridgeConfiguration setActive (Boolean active) {
      this.setParam("active", active);
      return this;
    }
    public APIRequestCreateOpenBridgeConfiguration setActive (String active) {
      this.setParam("active", active);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setEndpoint (String endpoint) {
      this.setParam("endpoint", endpoint);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setFallbackDomain (String fallbackDomain) {
      this.setParam("fallback_domain", fallbackDomain);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setFallbackDomainEnabled (Boolean fallbackDomainEnabled) {
      this.setParam("fallback_domain_enabled", fallbackDomainEnabled);
      return this;
    }
    public APIRequestCreateOpenBridgeConfiguration setFallbackDomainEnabled (String fallbackDomainEnabled) {
      this.setParam("fallback_domain_enabled", fallbackDomainEnabled);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setHostBusinessId (Long hostBusinessId) {
      this.setParam("host_business_id", hostBusinessId);
      return this;
    }
    public APIRequestCreateOpenBridgeConfiguration setHostBusinessId (String hostBusinessId) {
      this.setParam("host_business_id", hostBusinessId);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setHostExternalId (String hostExternalId) {
      this.setParam("host_external_id", hostExternalId);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setInstanceId (String instanceId) {
      this.setParam("instance_id", instanceId);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration setPixelId (Long pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }
    public APIRequestCreateOpenBridgeConfiguration setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }

    public APIRequestCreateOpenBridgeConfiguration requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOpenBridgeConfiguration requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOpenBridgeConfiguration requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "search_query",
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
               return APIRequestGetOwnedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedAdAccounts setSearchQuery (String searchQuery) {
      this.setParam("search_query", searchQuery);
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAllCapabilitiesField () {
      return this.requestAllCapabilitiesField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAllCapabilitiesField (boolean value) {
      this.requestField("all_capabilities", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBrandSafetyContentFilterLevelsField () {
      return this.requestBrandSafetyContentFilterLevelsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBrandSafetyContentFilterLevelsField (boolean value) {
      this.requestField("brand_safety_content_filter_levels", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCustomAudienceInfoField () {
      return this.requestCustomAudienceInfoField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCustomAudienceInfoField (boolean value) {
      this.requestField("custom_audience_info", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDefaultDsaBeneficiaryField () {
      return this.requestDefaultDsaBeneficiaryField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDefaultDsaBeneficiaryField (boolean value) {
      this.requestField("default_dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDefaultDsaPayorField () {
      return this.requestDefaultDsaPayorField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDefaultDsaPayorField (boolean value) {
      this.requestField("default_dsa_payor", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestExistingCustomersField () {
      return this.requestExistingCustomersField(true);
    }
    public APIRequestGetOwnedAdAccounts requestExistingCustomersField (boolean value) {
      this.requestField("existing_customers", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetOwnedAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetOwnedAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetOwnedAdAccounts requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetOwnedAdAccounts requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetOwnedAdAccounts requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestViewableBusinessField () {
      return this.requestViewableBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestViewableBusinessField (boolean value) {
      this.requestField("viewable_business", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedAdAccount extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwnedAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwnedAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedAdAccount setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestCreateOwnedAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedApps extends APIRequest<Application> {

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
               return APIRequestGetOwnedApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedApps requestAamRulesField () {
      return this.requestAamRulesField(true);
    }
    public APIRequestGetOwnedApps requestAamRulesField (boolean value) {
      this.requestField("aam_rules", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAnAdSpaceLimitField () {
      return this.requestAnAdSpaceLimitField(true);
    }
    public APIRequestGetOwnedApps requestAnAdSpaceLimitField (boolean value) {
      this.requestField("an_ad_space_limit", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAnPlatformsField () {
      return this.requestAnPlatformsField(true);
    }
    public APIRequestGetOwnedApps requestAnPlatformsField (boolean value) {
      this.requestField("an_platforms", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAndroidKeyHashField () {
      return this.requestAndroidKeyHashField(true);
    }
    public APIRequestGetOwnedApps requestAndroidKeyHashField (boolean value) {
      this.requestField("android_key_hash", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAndroidSdkErrorCategoriesField () {
      return this.requestAndroidSdkErrorCategoriesField(true);
    }
    public APIRequestGetOwnedApps requestAndroidSdkErrorCategoriesField (boolean value) {
      this.requestField("android_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppDomainsField () {
      return this.requestAppDomainsField(true);
    }
    public APIRequestGetOwnedApps requestAppDomainsField (boolean value) {
      this.requestField("app_domains", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppEventsConfigField () {
      return this.requestAppEventsConfigField(true);
    }
    public APIRequestGetOwnedApps requestAppEventsConfigField (boolean value) {
      this.requestField("app_events_config", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppEventsFeatureBitmaskField () {
      return this.requestAppEventsFeatureBitmaskField(true);
    }
    public APIRequestGetOwnedApps requestAppEventsFeatureBitmaskField (boolean value) {
      this.requestField("app_events_feature_bitmask", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppEventsSessionTimeoutField () {
      return this.requestAppEventsSessionTimeoutField(true);
    }
    public APIRequestGetOwnedApps requestAppEventsSessionTimeoutField (boolean value) {
      this.requestField("app_events_session_timeout", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppInstallTrackedField () {
      return this.requestAppInstallTrackedField(true);
    }
    public APIRequestGetOwnedApps requestAppInstallTrackedField (boolean value) {
      this.requestField("app_install_tracked", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppNameField () {
      return this.requestAppNameField(true);
    }
    public APIRequestGetOwnedApps requestAppNameField (boolean value) {
      this.requestField("app_name", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppSignalsBindingIosField () {
      return this.requestAppSignalsBindingIosField(true);
    }
    public APIRequestGetOwnedApps requestAppSignalsBindingIosField (boolean value) {
      this.requestField("app_signals_binding_ios", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAppTypeField () {
      return this.requestAppTypeField(true);
    }
    public APIRequestGetOwnedApps requestAppTypeField (boolean value) {
      this.requestField("app_type", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthDialogDataHelpUrlField () {
      return this.requestAuthDialogDataHelpUrlField(true);
    }
    public APIRequestGetOwnedApps requestAuthDialogDataHelpUrlField (boolean value) {
      this.requestField("auth_dialog_data_help_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthDialogHeadlineField () {
      return this.requestAuthDialogHeadlineField(true);
    }
    public APIRequestGetOwnedApps requestAuthDialogHeadlineField (boolean value) {
      this.requestField("auth_dialog_headline", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthDialogPermsExplanationField () {
      return this.requestAuthDialogPermsExplanationField(true);
    }
    public APIRequestGetOwnedApps requestAuthDialogPermsExplanationField (boolean value) {
      this.requestField("auth_dialog_perms_explanation", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralDefaultActivityPrivacyField () {
      return this.requestAuthReferralDefaultActivityPrivacyField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralDefaultActivityPrivacyField (boolean value) {
      this.requestField("auth_referral_default_activity_privacy", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralEnabledField () {
      return this.requestAuthReferralEnabledField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralEnabledField (boolean value) {
      this.requestField("auth_referral_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralExtendedPermsField () {
      return this.requestAuthReferralExtendedPermsField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralExtendedPermsField (boolean value) {
      this.requestField("auth_referral_extended_perms", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralFriendPermsField () {
      return this.requestAuthReferralFriendPermsField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralFriendPermsField (boolean value) {
      this.requestField("auth_referral_friend_perms", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralResponseTypeField () {
      return this.requestAuthReferralResponseTypeField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralResponseTypeField (boolean value) {
      this.requestField("auth_referral_response_type", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAuthReferralUserPermsField () {
      return this.requestAuthReferralUserPermsField(true);
    }
    public APIRequestGetOwnedApps requestAuthReferralUserPermsField (boolean value) {
      this.requestField("auth_referral_user_perms", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAutoEventMappingAndroidField () {
      return this.requestAutoEventMappingAndroidField(true);
    }
    public APIRequestGetOwnedApps requestAutoEventMappingAndroidField (boolean value) {
      this.requestField("auto_event_mapping_android", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAutoEventMappingIosField () {
      return this.requestAutoEventMappingIosField(true);
    }
    public APIRequestGetOwnedApps requestAutoEventMappingIosField (boolean value) {
      this.requestField("auto_event_mapping_ios", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAutoEventSetupEnabledField () {
      return this.requestAutoEventSetupEnabledField(true);
    }
    public APIRequestGetOwnedApps requestAutoEventSetupEnabledField (boolean value) {
      this.requestField("auto_event_setup_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAutoLogAppEventsDefaultField () {
      return this.requestAutoLogAppEventsDefaultField(true);
    }
    public APIRequestGetOwnedApps requestAutoLogAppEventsDefaultField (boolean value) {
      this.requestField("auto_log_app_events_default", value);
      return this;
    }
    public APIRequestGetOwnedApps requestAutoLogAppEventsEnabledField () {
      return this.requestAutoLogAppEventsEnabledField(true);
    }
    public APIRequestGetOwnedApps requestAutoLogAppEventsEnabledField (boolean value) {
      this.requestField("auto_log_app_events_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedApps requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCanvasFluidHeightField () {
      return this.requestCanvasFluidHeightField(true);
    }
    public APIRequestGetOwnedApps requestCanvasFluidHeightField (boolean value) {
      this.requestField("canvas_fluid_height", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCanvasFluidWidthField () {
      return this.requestCanvasFluidWidthField(true);
    }
    public APIRequestGetOwnedApps requestCanvasFluidWidthField (boolean value) {
      this.requestField("canvas_fluid_width", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCanvasUrlField () {
      return this.requestCanvasUrlField(true);
    }
    public APIRequestGetOwnedApps requestCanvasUrlField (boolean value) {
      this.requestField("canvas_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetOwnedApps requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetOwnedApps requestClientConfigField () {
      return this.requestClientConfigField(true);
    }
    public APIRequestGetOwnedApps requestClientConfigField (boolean value) {
      this.requestField("client_config", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCompanyField () {
      return this.requestCompanyField(true);
    }
    public APIRequestGetOwnedApps requestCompanyField (boolean value) {
      this.requestField("company", value);
      return this;
    }
    public APIRequestGetOwnedApps requestConfiguredIosSsoField () {
      return this.requestConfiguredIosSsoField(true);
    }
    public APIRequestGetOwnedApps requestConfiguredIosSsoField (boolean value) {
      this.requestField("configured_ios_sso", value);
      return this;
    }
    public APIRequestGetOwnedApps requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGetOwnedApps requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedApps requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedApps requestCreatorUidField () {
      return this.requestCreatorUidField(true);
    }
    public APIRequestGetOwnedApps requestCreatorUidField (boolean value) {
      this.requestField("creator_uid", value);
      return this;
    }
    public APIRequestGetOwnedApps requestDailyActiveUsersField () {
      return this.requestDailyActiveUsersField(true);
    }
    public APIRequestGetOwnedApps requestDailyActiveUsersField (boolean value) {
      this.requestField("daily_active_users", value);
      return this;
    }
    public APIRequestGetOwnedApps requestDailyActiveUsersRankField () {
      return this.requestDailyActiveUsersRankField(true);
    }
    public APIRequestGetOwnedApps requestDailyActiveUsersRankField (boolean value) {
      this.requestField("daily_active_users_rank", value);
      return this;
    }
    public APIRequestGetOwnedApps requestDeauthCallbackUrlField () {
      return this.requestDeauthCallbackUrlField(true);
    }
    public APIRequestGetOwnedApps requestDeauthCallbackUrlField (boolean value) {
      this.requestField("deauth_callback_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestDefaultShareModeField () {
      return this.requestDefaultShareModeField(true);
    }
    public APIRequestGetOwnedApps requestDefaultShareModeField (boolean value) {
      this.requestField("default_share_mode", value);
      return this;
    }
    public APIRequestGetOwnedApps requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOwnedApps requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOwnedApps requestFinancialIdField () {
      return this.requestFinancialIdField(true);
    }
    public APIRequestGetOwnedApps requestFinancialIdField (boolean value) {
      this.requestField("financial_id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestGdpv4ChromeCustomTabsEnabledField () {
      return this.requestGdpv4ChromeCustomTabsEnabledField(true);
    }
    public APIRequestGetOwnedApps requestGdpv4ChromeCustomTabsEnabledField (boolean value) {
      this.requestField("gdpv4_chrome_custom_tabs_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestGdpv4EnabledField () {
      return this.requestGdpv4EnabledField(true);
    }
    public APIRequestGetOwnedApps requestGdpv4EnabledField (boolean value) {
      this.requestField("gdpv4_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestGdpv4NuxContentField () {
      return this.requestGdpv4NuxContentField(true);
    }
    public APIRequestGetOwnedApps requestGdpv4NuxContentField (boolean value) {
      this.requestField("gdpv4_nux_content", value);
      return this;
    }
    public APIRequestGetOwnedApps requestGdpv4NuxEnabledField () {
      return this.requestGdpv4NuxEnabledField(true);
    }
    public APIRequestGetOwnedApps requestGdpv4NuxEnabledField (boolean value) {
      this.requestField("gdpv4_nux_enabled", value);
      return this;
    }
    public APIRequestGetOwnedApps requestHasMessengerProductField () {
      return this.requestHasMessengerProductField(true);
    }
    public APIRequestGetOwnedApps requestHasMessengerProductField (boolean value) {
      this.requestField("has_messenger_product", value);
      return this;
    }
    public APIRequestGetOwnedApps requestHostingUrlField () {
      return this.requestHostingUrlField(true);
    }
    public APIRequestGetOwnedApps requestHostingUrlField (boolean value) {
      this.requestField("hosting_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetOwnedApps requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedApps requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosBundleIdField () {
      return this.requestIosBundleIdField(true);
    }
    public APIRequestGetOwnedApps requestIosBundleIdField (boolean value) {
      this.requestField("ios_bundle_id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosSdkDialogFlowsField () {
      return this.requestIosSdkDialogFlowsField(true);
    }
    public APIRequestGetOwnedApps requestIosSdkDialogFlowsField (boolean value) {
      this.requestField("ios_sdk_dialog_flows", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosSdkErrorCategoriesField () {
      return this.requestIosSdkErrorCategoriesField(true);
    }
    public APIRequestGetOwnedApps requestIosSdkErrorCategoriesField (boolean value) {
      this.requestField("ios_sdk_error_categories", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosSfvcAttrField () {
      return this.requestIosSfvcAttrField(true);
    }
    public APIRequestGetOwnedApps requestIosSfvcAttrField (boolean value) {
      this.requestField("ios_sfvc_attr", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosSupportsNativeProxyAuthFlowField () {
      return this.requestIosSupportsNativeProxyAuthFlowField(true);
    }
    public APIRequestGetOwnedApps requestIosSupportsNativeProxyAuthFlowField (boolean value) {
      this.requestField("ios_supports_native_proxy_auth_flow", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIosSupportsSystemAuthField () {
      return this.requestIosSupportsSystemAuthField(true);
    }
    public APIRequestGetOwnedApps requestIosSupportsSystemAuthField (boolean value) {
      this.requestField("ios_supports_system_auth", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIpadAppStoreIdField () {
      return this.requestIpadAppStoreIdField(true);
    }
    public APIRequestGetOwnedApps requestIpadAppStoreIdField (boolean value) {
      this.requestField("ipad_app_store_id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestIphoneAppStoreIdField () {
      return this.requestIphoneAppStoreIdField(true);
    }
    public APIRequestGetOwnedApps requestIphoneAppStoreIdField (boolean value) {
      this.requestField("iphone_app_store_id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestLatestSdkVersionField () {
      return this.requestLatestSdkVersionField(true);
    }
    public APIRequestGetOwnedApps requestLatestSdkVersionField (boolean value) {
      this.requestField("latest_sdk_version", value);
      return this;
    }
    public APIRequestGetOwnedApps requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOwnedApps requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOwnedApps requestLoggingTokenField () {
      return this.requestLoggingTokenField(true);
    }
    public APIRequestGetOwnedApps requestLoggingTokenField (boolean value) {
      this.requestField("logging_token", value);
      return this;
    }
    public APIRequestGetOwnedApps requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGetOwnedApps requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestMigrationsField () {
      return this.requestMigrationsField(true);
    }
    public APIRequestGetOwnedApps requestMigrationsField (boolean value) {
      this.requestField("migrations", value);
      return this;
    }
    public APIRequestGetOwnedApps requestMobileProfileSectionUrlField () {
      return this.requestMobileProfileSectionUrlField(true);
    }
    public APIRequestGetOwnedApps requestMobileProfileSectionUrlField (boolean value) {
      this.requestField("mobile_profile_section_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestMobileWebUrlField () {
      return this.requestMobileWebUrlField(true);
    }
    public APIRequestGetOwnedApps requestMobileWebUrlField (boolean value) {
      this.requestField("mobile_web_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestMonthlyActiveUsersField () {
      return this.requestMonthlyActiveUsersField(true);
    }
    public APIRequestGetOwnedApps requestMonthlyActiveUsersField (boolean value) {
      this.requestField("monthly_active_users", value);
      return this;
    }
    public APIRequestGetOwnedApps requestMonthlyActiveUsersRankField () {
      return this.requestMonthlyActiveUsersRankField(true);
    }
    public APIRequestGetOwnedApps requestMonthlyActiveUsersRankField (boolean value) {
      this.requestField("monthly_active_users_rank", value);
      return this;
    }
    public APIRequestGetOwnedApps requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedApps requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedApps requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGetOwnedApps requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGetOwnedApps requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGetOwnedApps requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGetOwnedApps requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedApps requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedApps requestPageTabDefaultNameField () {
      return this.requestPageTabDefaultNameField(true);
    }
    public APIRequestGetOwnedApps requestPageTabDefaultNameField (boolean value) {
      this.requestField("page_tab_default_name", value);
      return this;
    }
    public APIRequestGetOwnedApps requestPageTabUrlField () {
      return this.requestPageTabUrlField(true);
    }
    public APIRequestGetOwnedApps requestPageTabUrlField (boolean value) {
      this.requestField("page_tab_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGetOwnedApps requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetOwnedApps requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestProfileSectionUrlField () {
      return this.requestProfileSectionUrlField(true);
    }
    public APIRequestGetOwnedApps requestProfileSectionUrlField (boolean value) {
      this.requestField("profile_section_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestPropertyIdField () {
      return this.requestPropertyIdField(true);
    }
    public APIRequestGetOwnedApps requestPropertyIdField (boolean value) {
      this.requestField("property_id", value);
      return this;
    }
    public APIRequestGetOwnedApps requestProtectedModeRulesField () {
      return this.requestProtectedModeRulesField(true);
    }
    public APIRequestGetOwnedApps requestProtectedModeRulesField (boolean value) {
      this.requestField("protected_mode_rules", value);
      return this;
    }
    public APIRequestGetOwnedApps requestRealTimeModeDevicesField () {
      return this.requestRealTimeModeDevicesField(true);
    }
    public APIRequestGetOwnedApps requestRealTimeModeDevicesField (boolean value) {
      this.requestField("real_time_mode_devices", value);
      return this;
    }
    public APIRequestGetOwnedApps requestRestrictionsField () {
      return this.requestRestrictionsField(true);
    }
    public APIRequestGetOwnedApps requestRestrictionsField (boolean value) {
      this.requestField("restrictions", value);
      return this;
    }
    public APIRequestGetOwnedApps requestRestrictiveDataFilterParamsField () {
      return this.requestRestrictiveDataFilterParamsField(true);
    }
    public APIRequestGetOwnedApps requestRestrictiveDataFilterParamsField (boolean value) {
      this.requestField("restrictive_data_filter_params", value);
      return this;
    }
    public APIRequestGetOwnedApps requestRestrictiveDataFilterRulesField () {
      return this.requestRestrictiveDataFilterRulesField(true);
    }
    public APIRequestGetOwnedApps requestRestrictiveDataFilterRulesField (boolean value) {
      this.requestField("restrictive_data_filter_rules", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSdkUpdateMessageField () {
      return this.requestSdkUpdateMessageField(true);
    }
    public APIRequestGetOwnedApps requestSdkUpdateMessageField (boolean value) {
      this.requestField("sdk_update_message", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSeamlessLoginField () {
      return this.requestSeamlessLoginField(true);
    }
    public APIRequestGetOwnedApps requestSeamlessLoginField (boolean value) {
      this.requestField("seamless_login", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSecureCanvasUrlField () {
      return this.requestSecureCanvasUrlField(true);
    }
    public APIRequestGetOwnedApps requestSecureCanvasUrlField (boolean value) {
      this.requestField("secure_canvas_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSecurePageTabUrlField () {
      return this.requestSecurePageTabUrlField(true);
    }
    public APIRequestGetOwnedApps requestSecurePageTabUrlField (boolean value) {
      this.requestField("secure_page_tab_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestServerIpWhitelistField () {
      return this.requestServerIpWhitelistField(true);
    }
    public APIRequestGetOwnedApps requestServerIpWhitelistField (boolean value) {
      this.requestField("server_ip_whitelist", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSmartLoginBookmarkIconUrlField () {
      return this.requestSmartLoginBookmarkIconUrlField(true);
    }
    public APIRequestGetOwnedApps requestSmartLoginBookmarkIconUrlField (boolean value) {
      this.requestField("smart_login_bookmark_icon_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSmartLoginMenuIconUrlField () {
      return this.requestSmartLoginMenuIconUrlField(true);
    }
    public APIRequestGetOwnedApps requestSmartLoginMenuIconUrlField (boolean value) {
      this.requestField("smart_login_menu_icon_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSocialDiscoveryField () {
      return this.requestSocialDiscoveryField(true);
    }
    public APIRequestGetOwnedApps requestSocialDiscoveryField (boolean value) {
      this.requestField("social_discovery", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSubcategoryField () {
      return this.requestSubcategoryField(true);
    }
    public APIRequestGetOwnedApps requestSubcategoryField (boolean value) {
      this.requestField("subcategory", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSuggestedEventsSettingField () {
      return this.requestSuggestedEventsSettingField(true);
    }
    public APIRequestGetOwnedApps requestSuggestedEventsSettingField (boolean value) {
      this.requestField("suggested_events_setting", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGetOwnedApps requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSupportsApprequestsFastAppSwitchField () {
      return this.requestSupportsApprequestsFastAppSwitchField(true);
    }
    public APIRequestGetOwnedApps requestSupportsApprequestsFastAppSwitchField (boolean value) {
      this.requestField("supports_apprequests_fast_app_switch", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSupportsAttributionField () {
      return this.requestSupportsAttributionField(true);
    }
    public APIRequestGetOwnedApps requestSupportsAttributionField (boolean value) {
      this.requestField("supports_attribution", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSupportsImplicitSdkLoggingField () {
      return this.requestSupportsImplicitSdkLoggingField(true);
    }
    public APIRequestGetOwnedApps requestSupportsImplicitSdkLoggingField (boolean value) {
      this.requestField("supports_implicit_sdk_logging", value);
      return this;
    }
    public APIRequestGetOwnedApps requestSuppressNativeIosGdpField () {
      return this.requestSuppressNativeIosGdpField(true);
    }
    public APIRequestGetOwnedApps requestSuppressNativeIosGdpField (boolean value) {
      this.requestField("suppress_native_ios_gdp", value);
      return this;
    }
    public APIRequestGetOwnedApps requestTermsOfServiceUrlField () {
      return this.requestTermsOfServiceUrlField(true);
    }
    public APIRequestGetOwnedApps requestTermsOfServiceUrlField (boolean value) {
      this.requestField("terms_of_service_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestUrlSchemeSuffixField () {
      return this.requestUrlSchemeSuffixField(true);
    }
    public APIRequestGetOwnedApps requestUrlSchemeSuffixField (boolean value) {
      this.requestField("url_scheme_suffix", value);
      return this;
    }
    public APIRequestGetOwnedApps requestUserSupportEmailField () {
      return this.requestUserSupportEmailField(true);
    }
    public APIRequestGetOwnedApps requestUserSupportEmailField (boolean value) {
      this.requestField("user_support_email", value);
      return this;
    }
    public APIRequestGetOwnedApps requestUserSupportUrlField () {
      return this.requestUserSupportUrlField(true);
    }
    public APIRequestGetOwnedApps requestUserSupportUrlField (boolean value) {
      this.requestField("user_support_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestWebsiteUrlField () {
      return this.requestWebsiteUrlField(true);
    }
    public APIRequestGetOwnedApps requestWebsiteUrlField (boolean value) {
      this.requestField("website_url", value);
      return this;
    }
    public APIRequestGetOwnedApps requestWeeklyActiveUsersField () {
      return this.requestWeeklyActiveUsersField(true);
    }
    public APIRequestGetOwnedApps requestWeeklyActiveUsersField (boolean value) {
      this.requestField("weekly_active_users", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedApp extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwnedApp.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwnedApp(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateOwnedApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateOwnedApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteOwnedBusinesses extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "client_id",
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
               return APIRequestDeleteOwnedBusinesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteOwnedBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteOwnedBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteOwnedBusinesses setClientId (String clientId) {
      this.setParam("client_id", clientId);
      return this;
    }

    public APIRequestDeleteOwnedBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteOwnedBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedBusinesses extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_business_external_id",
      "client_user_id",
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
               return APIRequestGetOwnedBusinesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedBusinesses setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestGetOwnedBusinesses setClientUserId (Long clientUserId) {
      this.setParam("client_user_id", clientUserId);
      return this;
    }
    public APIRequestGetOwnedBusinesses setClientUserId (String clientUserId) {
      this.setParam("client_user_id", clientUserId);
      return this;
    }

    public APIRequestGetOwnedBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedBusinesses requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetOwnedBusinesses requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetOwnedBusinesses requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetOwnedBusinesses requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedBusinesses requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetOwnedBusinesses requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOwnedBusinesses requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedBusinesses requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetOwnedBusinesses requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetOwnedBusinesses requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedBusinesses requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetOwnedBusinesses requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetOwnedBusinesses requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetOwnedBusinesses requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetOwnedBusinesses requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetOwnedBusinesses requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedBusiness extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "child_business_external_id",
      "name",
      "page_permitted_tasks",
      "sales_rep_email",
      "shared_page_id",
      "should_generate_name",
      "survey_business_type",
      "survey_num_assets",
      "survey_num_people",
      "timezone_id",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwnedBusiness.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwnedBusiness(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedBusiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedBusiness setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOwnedBusiness setPagePermittedTasks (List<Business.EnumPagePermittedTasks> pagePermittedTasks) {
      this.setParam("page_permitted_tasks", pagePermittedTasks);
      return this;
    }
    public APIRequestCreateOwnedBusiness setPagePermittedTasks (String pagePermittedTasks) {
      this.setParam("page_permitted_tasks", pagePermittedTasks);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSharedPageId (String sharedPageId) {
      this.setParam("shared_page_id", sharedPageId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setShouldGenerateName (Boolean shouldGenerateName) {
      this.setParam("should_generate_name", shouldGenerateName);
      return this;
    }
    public APIRequestCreateOwnedBusiness setShouldGenerateName (String shouldGenerateName) {
      this.setParam("should_generate_name", shouldGenerateName);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyBusinessType (Business.EnumSurveyBusinessType surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyBusinessType (String surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }

    public APIRequestCreateOwnedBusiness setTimezoneId (Business.EnumTimezoneId timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateOwnedBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setVertical (Business.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateOwnedBusiness setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateOwnedBusiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedBusiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedBusiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedInstagramAccounts extends APIRequest<InstagramUser> {

    APINodeList<InstagramUser> lastResponse = null;
    @Override
    public APINodeList<InstagramUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "follow_count",
      "followed_by_count",
      "has_profile_picture",
      "id",
      "is_private",
      "is_published",
      "media_count",
      "mini_shop_storefront",
      "owner_business",
      "profile_pic",
      "username",
    };

    @Override
    public APINodeList<InstagramUser> parseResponse(String response, String header) throws APIException {
      return InstagramUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramUser>>() {
           public APINodeList<InstagramUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwnedInstagramAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedInstagramAccounts requestFollowCountField () {
      return this.requestFollowCountField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestFollowCountField (boolean value) {
      this.requestField("follow_count", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestFollowedByCountField () {
      return this.requestFollowedByCountField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestFollowedByCountField (boolean value) {
      this.requestField("followed_by_count", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestHasProfilePictureField () {
      return this.requestHasProfilePictureField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestHasProfilePictureField (boolean value) {
      this.requestField("has_profile_picture", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetOwnedInstagramAccounts requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetOwnedInstagramAccounts requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetOwnedOffsiteSignalContainerBusinessObjects extends APIRequest<OffsiteSignalContainerBusinessObject> {

    APINodeList<OffsiteSignalContainerBusinessObject> lastResponse = null;
    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_unavailable",
      "name",
      "primary_container_id",
    };

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> parseResponse(String response, String header) throws APIException {
      return OffsiteSignalContainerBusinessObject.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OffsiteSignalContainerBusinessObject>>() {
           public APINodeList<OffsiteSignalContainerBusinessObject> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwnedOffsiteSignalContainerBusinessObjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_offsite_signal_container_business_objects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField () {
      return this.requestPrimaryContainerIdField(true);
    }
    public APIRequestGetOwnedOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField (boolean value) {
      this.requestField("primary_container_id", value);
      return this;
    }
  }

  public static class APIRequestGetOwnedPages extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "artists_we_like",
      "attire",
      "available_promo_offer_ids",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "breaking_news_usage",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "connected_page_backed_instagram_account",
      "contact_address",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "does_viewer_have_page_permission_link_ig",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "followers_count",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_root_id",
      "has_added_app",
      "has_lead_access",
      "has_transitioned_to_new_page_experience",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "is_always_open",
      "is_calling_eligible",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messaging_feature_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mini_shop_storefront",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "owner_business",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_donate_button_in_live_video",
      "talking_about_count",
      "temporary_status",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "user_access_expire_time",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwnedPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetOwnedPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetOwnedPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetOwnedPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetOwnedPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetOwnedPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetOwnedPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetOwnedPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAvailablePromoOfferIdsField () {
      return this.requestAvailablePromoOfferIdsField(true);
    }
    public APIRequestGetOwnedPages requestAvailablePromoOfferIdsField (boolean value) {
      this.requestField("available_promo_offer_ids", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetOwnedPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetOwnedPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetOwnedPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetOwnedPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetOwnedPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetOwnedPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetOwnedPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBreakingNewsUsageField () {
      return this.requestBreakingNewsUsageField(true);
    }
    public APIRequestGetOwnedPages requestBreakingNewsUsageField (boolean value) {
      this.requestField("breaking_news_usage", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetOwnedPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetOwnedPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetOwnedPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetOwnedPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetOwnedPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetOwnedPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetOwnedPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetOwnedPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetOwnedPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetOwnedPages requestConnectedPageBackedInstagramAccountField () {
      return this.requestConnectedPageBackedInstagramAccountField(true);
    }
    public APIRequestGetOwnedPages requestConnectedPageBackedInstagramAccountField (boolean value) {
      this.requestField("connected_page_backed_instagram_account", value);
      return this;
    }
    public APIRequestGetOwnedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetOwnedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetOwnedPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetOwnedPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetOwnedPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetOwnedPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetOwnedPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetOwnedPages requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOwnedPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetOwnedPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetOwnedPages requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetOwnedPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetOwnedPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetOwnedPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDoesViewerHavePagePermissionLinkIgField () {
      return this.requestDoesViewerHavePagePermissionLinkIgField(true);
    }
    public APIRequestGetOwnedPages requestDoesViewerHavePagePermissionLinkIgField (boolean value) {
      this.requestField("does_viewer_have_page_permission_link_ig", value);
      return this;
    }
    public APIRequestGetOwnedPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetOwnedPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetOwnedPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetOwnedPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetOwnedPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetOwnedPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetOwnedPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGetOwnedPages requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetOwnedPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetOwnedPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetOwnedPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetOwnedPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetOwnedPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetOwnedPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetOwnedPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetOwnedPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasLeadAccessField () {
      return this.requestHasLeadAccessField(true);
    }
    public APIRequestGetOwnedPages requestHasLeadAccessField (boolean value) {
      this.requestField("has_lead_access", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasTransitionedToNewPageExperienceField () {
      return this.requestHasTransitionedToNewPageExperienceField(true);
    }
    public APIRequestGetOwnedPages requestHasTransitionedToNewPageExperienceField (boolean value) {
      this.requestField("has_transitioned_to_new_page_experience", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetOwnedPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetOwnedPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetOwnedPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetOwnedPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetOwnedPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetOwnedPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetOwnedPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetOwnedPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetOwnedPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsCallingEligibleField () {
      return this.requestIsCallingEligibleField(true);
    }
    public APIRequestGetOwnedPages requestIsCallingEligibleField (boolean value) {
      this.requestField("is_calling_eligible", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetOwnedPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetOwnedPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetOwnedPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField () {
      return this.requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField(true);
    }
    public APIRequestGetOwnedPages requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField (boolean value) {
      this.requestField("is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetOwnedPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetOwnedPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetOwnedPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetOwnedPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetOwnedPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetOwnedPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetOwnedPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetOwnedPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetOwnedPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOwnedPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetOwnedPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetOwnedPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetOwnedPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetOwnedPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessagingFeatureStatusField () {
      return this.requestMessagingFeatureStatusField(true);
    }
    public APIRequestGetOwnedPages requestMessagingFeatureStatusField (boolean value) {
      this.requestField("messaging_feature_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetOwnedPages requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetOwnedPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetOwnedPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetOwnedPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetOwnedPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetOwnedPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetOwnedPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetOwnedPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetOwnedPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetOwnedPages requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedPages requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetOwnedPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetOwnedPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetOwnedPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetOwnedPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetOwnedPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetOwnedPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetOwnedPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetOwnedPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetOwnedPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetOwnedPages requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetOwnedPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetOwnedPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetOwnedPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetOwnedPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetOwnedPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetOwnedPages requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetOwnedPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetOwnedPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetOwnedPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetOwnedPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetOwnedPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetOwnedPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetOwnedPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetOwnedPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetOwnedPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetOwnedPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetOwnedPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetOwnedPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetOwnedPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetOwnedPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetOwnedPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetOwnedPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetOwnedPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetOwnedPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetOwnedPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetOwnedPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetOwnedPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetOwnedPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetOwnedPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetOwnedPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetOwnedPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetOwnedPages requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetOwnedPages requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetOwnedPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetOwnedPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetOwnedPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetOwnedPages requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetOwnedPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetOwnedPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetOwnedPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetOwnedPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetOwnedPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetOwnedPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetOwnedPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetOwnedPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedPage extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "code",
      "entry_point",
      "page_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwnedPage.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwnedPage(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedPage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedPage setCode (String code) {
      this.setParam("code", code);
      return this;
    }

    public APIRequestCreateOwnedPage setEntryPoint (String entryPoint) {
      this.setParam("entry_point", entryPoint);
      return this;
    }

    public APIRequestCreateOwnedPage setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreateOwnedPage setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreateOwnedPage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedPage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedPage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedPixels extends APIRequest<AdsPixel> {

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
               return APIRequestGetOwnedPixels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPixels requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGetOwnedPixels requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetOwnedPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetOwnedPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetOwnedPixels requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOwnedPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetOwnedPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetOwnedPixels requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOwnedPixels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetOwnedPixels requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetOwnedPixels requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetOwnedPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetOwnedPixels requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetOwnedPixels requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetOwnedPixels requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetOwnedPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestHas1pPixelEventField () {
      return this.requestHas1pPixelEventField(true);
    }
    public APIRequestGetOwnedPixels requestHas1pPixelEventField (boolean value) {
      this.requestField("has_1p_pixel_event", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetOwnedPixels requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetOwnedPixels requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetOwnedPixels requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetOwnedPixels requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetOwnedPixels requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetOwnedPixels requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetOwnedPixels requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetOwnedPixels requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetOwnedPixels requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetOwnedPixels requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetOwnedPixels requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetOwnedPixels requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetOwnedProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_to_collaborative_ads_share_settings",
      "agency_collaborative_ads_share_settings",
      "business",
      "catalog_store",
      "commerce_merchant_settings",
      "creator_user",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "is_local_catalog",
      "name",
      "owner_business",
      "product_count",
      "store_catalog_settings",
      "user_access_expire_time",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwnedProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField () {
      return this.requestAdAccountToCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("ad_account_to_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestAgencyCollaborativeAdsShareSettingsField () {
      return this.requestAgencyCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestAgencyCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("agency_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestCatalogStoreField () {
      return this.requestCatalogStoreField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestCatalogStoreField (boolean value) {
      this.requestField("catalog_store", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestCreatorUserField () {
      return this.requestCreatorUserField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestCreatorUserField (boolean value) {
      this.requestField("creator_user", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestIsCatalogSegmentField () {
      return this.requestIsCatalogSegmentField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestIsCatalogSegmentField (boolean value) {
      this.requestField("is_catalog_segment", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestIsLocalCatalogField () {
      return this.requestIsLocalCatalogField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestIsLocalCatalogField (boolean value) {
      this.requestField("is_local_catalog", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedProductCatalog extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "additional_vertical_option",
      "catalog_segment_filter",
      "catalog_segment_product_set_id",
      "da_display_settings",
      "destination_catalog_settings",
      "flight_catalog_settings",
      "name",
      "parent_catalog_id",
      "partner_integration",
      "store_catalog_settings",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductCatalog>() {
           public ProductCatalog apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOwnedProductCatalog.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateOwnedProductCatalog(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_product_catalogs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedProductCatalog setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedProductCatalog setAdditionalVerticalOption (ProductCatalog.EnumAdditionalVerticalOption additionalVerticalOption) {
      this.setParam("additional_vertical_option", additionalVerticalOption);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setAdditionalVerticalOption (String additionalVerticalOption) {
      this.setParam("additional_vertical_option", additionalVerticalOption);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setCatalogSegmentFilter (Object catalogSegmentFilter) {
      this.setParam("catalog_segment_filter", catalogSegmentFilter);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setCatalogSegmentFilter (String catalogSegmentFilter) {
      this.setParam("catalog_segment_filter", catalogSegmentFilter);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setCatalogSegmentProductSetId (String catalogSegmentProductSetId) {
      this.setParam("catalog_segment_product_set_id", catalogSegmentProductSetId);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setDestinationCatalogSettings (Map<String, String> destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setDestinationCatalogSettings (String destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (Map<String, String> flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (String flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setParentCatalogId (String parentCatalogId) {
      this.setParam("parent_catalog_id", parentCatalogId);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setPartnerIntegration (Map<String, String> partnerIntegration) {
      this.setParam("partner_integration", partnerIntegration);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setPartnerIntegration (String partnerIntegration) {
      this.setParam("partner_integration", partnerIntegration);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setStoreCatalogSettings (Map<String, String> storeCatalogSettings) {
      this.setParam("store_catalog_settings", storeCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setStoreCatalogSettings (String storeCatalogSettings) {
      this.setParam("store_catalog_settings", storeCatalogSettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setVertical (ProductCatalog.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedProductCatalog requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedWhatsAppBusinessAccounts extends APIRequest<WhatsAppBusinessAccount> {

    APINodeList<WhatsAppBusinessAccount> lastResponse = null;
    @Override
    public APINodeList<WhatsAppBusinessAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_review_status",
      "analytics",
      "auth_international_rate_eligibility",
      "business_verification_status",
      "country",
      "creation_time",
      "currency",
      "health_status",
      "id",
      "is_enabled_for_insights",
      "linked_commerce_account",
      "message_template_namespace",
      "name",
      "on_behalf_of_business_info",
      "owner_business",
      "owner_business_info",
      "ownership_type",
      "primary_business_location",
      "primary_funding_id",
      "purchase_order_number",
      "status",
      "timezone_id",
    };

    @Override
    public APINodeList<WhatsAppBusinessAccount> parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<WhatsAppBusinessAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<WhatsAppBusinessAccount> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<WhatsAppBusinessAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<WhatsAppBusinessAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<WhatsAppBusinessAccount>>() {
           public APINodeList<WhatsAppBusinessAccount> apply(ResponseWrapper result) {
             try {
               return APIRequestGetOwnedWhatsAppBusinessAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetOwnedWhatsAppBusinessAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_whatsapp_business_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAccountReviewStatusField () {
      return this.requestAccountReviewStatusField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAccountReviewStatusField (boolean value) {
      this.requestField("account_review_status", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAnalyticsField () {
      return this.requestAnalyticsField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAnalyticsField (boolean value) {
      this.requestField("analytics", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAuthInternationalRateEligibilityField () {
      return this.requestAuthInternationalRateEligibilityField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestAuthInternationalRateEligibilityField (boolean value) {
      this.requestField("auth_international_rate_eligibility", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestBusinessVerificationStatusField () {
      return this.requestBusinessVerificationStatusField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestBusinessVerificationStatusField (boolean value) {
      this.requestField("business_verification_status", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestHealthStatusField () {
      return this.requestHealthStatusField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestHealthStatusField (boolean value) {
      this.requestField("health_status", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestIsEnabledForInsightsField () {
      return this.requestIsEnabledForInsightsField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestIsEnabledForInsightsField (boolean value) {
      this.requestField("is_enabled_for_insights", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestLinkedCommerceAccountField () {
      return this.requestLinkedCommerceAccountField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestLinkedCommerceAccountField (boolean value) {
      this.requestField("linked_commerce_account", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestMessageTemplateNamespaceField () {
      return this.requestMessageTemplateNamespaceField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestMessageTemplateNamespaceField (boolean value) {
      this.requestField("message_template_namespace", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOnBehalfOfBusinessInfoField () {
      return this.requestOnBehalfOfBusinessInfoField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOnBehalfOfBusinessInfoField (boolean value) {
      this.requestField("on_behalf_of_business_info", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnerBusinessInfoField () {
      return this.requestOwnerBusinessInfoField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnerBusinessInfoField (boolean value) {
      this.requestField("owner_business_info", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnershipTypeField () {
      return this.requestOwnershipTypeField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestOwnershipTypeField (boolean value) {
      this.requestField("ownership_type", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPrimaryBusinessLocationField () {
      return this.requestPrimaryBusinessLocationField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPrimaryBusinessLocationField (boolean value) {
      this.requestField("primary_business_location", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPrimaryFundingIdField () {
      return this.requestPrimaryFundingIdField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPrimaryFundingIdField (boolean value) {
      this.requestField("primary_funding_id", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPurchaseOrderNumberField () {
      return this.requestPurchaseOrderNumberField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestPurchaseOrderNumberField (boolean value) {
      this.requestField("purchase_order_number", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedWhatsAppBusinessAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
  }

  public static class APIRequestDeletePages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_id",
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
               return APIRequestDeletePages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeletePages(String nodeId, APIContext context) {
      super(context, nodeId, "/pages", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeletePages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeletePages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeletePages setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestDeletePages setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestDeletePages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeletePages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeletePages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeletePages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPartnerAccountLinking extends APIRequest<PartnerAccountLinking> {

    APINodeList<PartnerAccountLinking> lastResponse = null;
    @Override
    public APINodeList<PartnerAccountLinking> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adaccount",
      "app",
      "business",
      "externalidentifier",
      "externalidentifieruri",
      "id",
      "partnername",
      "pixel",
    };

    @Override
    public APINodeList<PartnerAccountLinking> parseResponse(String response, String header) throws APIException {
      return PartnerAccountLinking.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<PartnerAccountLinking> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PartnerAccountLinking> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PartnerAccountLinking>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PartnerAccountLinking>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<PartnerAccountLinking>>() {
           public APINodeList<PartnerAccountLinking> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPartnerAccountLinking.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPartnerAccountLinking(String nodeId, APIContext context) {
      super(context, nodeId, "/partner_account_linking", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartnerAccountLinking setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartnerAccountLinking setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerAccountLinking requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerAccountLinking requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerAccountLinking requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartnerAccountLinking requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerAccountLinking requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartnerAccountLinking requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerAccountLinking requestAdaccountField () {
      return this.requestAdaccountField(true);
    }
    public APIRequestGetPartnerAccountLinking requestAdaccountField (boolean value) {
      this.requestField("adaccount", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestAppField () {
      return this.requestAppField(true);
    }
    public APIRequestGetPartnerAccountLinking requestAppField (boolean value) {
      this.requestField("app", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetPartnerAccountLinking requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestExternalidentifierField () {
      return this.requestExternalidentifierField(true);
    }
    public APIRequestGetPartnerAccountLinking requestExternalidentifierField (boolean value) {
      this.requestField("externalidentifier", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestExternalidentifieruriField () {
      return this.requestExternalidentifieruriField(true);
    }
    public APIRequestGetPartnerAccountLinking requestExternalidentifieruriField (boolean value) {
      this.requestField("externalidentifieruri", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerAccountLinking requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestPartnernameField () {
      return this.requestPartnernameField(true);
    }
    public APIRequestGetPartnerAccountLinking requestPartnernameField (boolean value) {
      this.requestField("partnername", value);
      return this;
    }
    public APIRequestGetPartnerAccountLinking requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGetPartnerAccountLinking requestPixelField (boolean value) {
      this.requestField("pixel", value);
      return this;
    }
  }

  public static class APIRequestCreatePartnerPremiumOption extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_segment_id",
      "enable_basket_insight",
      "enable_extended_audience_retargeting",
      "partner_business_id",
      "retailer_custom_audience_config",
      "vendor_id",
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
               return APIRequestCreatePartnerPremiumOption.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePartnerPremiumOption(String nodeId, APIContext context) {
      super(context, nodeId, "/partner_premium_options", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePartnerPremiumOption setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePartnerPremiumOption setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePartnerPremiumOption setCatalogSegmentId (String catalogSegmentId) {
      this.setParam("catalog_segment_id", catalogSegmentId);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption setEnableBasketInsight (Boolean enableBasketInsight) {
      this.setParam("enable_basket_insight", enableBasketInsight);
      return this;
    }
    public APIRequestCreatePartnerPremiumOption setEnableBasketInsight (String enableBasketInsight) {
      this.setParam("enable_basket_insight", enableBasketInsight);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption setEnableExtendedAudienceRetargeting (Boolean enableExtendedAudienceRetargeting) {
      this.setParam("enable_extended_audience_retargeting", enableExtendedAudienceRetargeting);
      return this;
    }
    public APIRequestCreatePartnerPremiumOption setEnableExtendedAudienceRetargeting (String enableExtendedAudienceRetargeting) {
      this.setParam("enable_extended_audience_retargeting", enableExtendedAudienceRetargeting);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption setPartnerBusinessId (String partnerBusinessId) {
      this.setParam("partner_business_id", partnerBusinessId);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption setRetailerCustomAudienceConfig (Map<String, String> retailerCustomAudienceConfig) {
      this.setParam("retailer_custom_audience_config", retailerCustomAudienceConfig);
      return this;
    }
    public APIRequestCreatePartnerPremiumOption setRetailerCustomAudienceConfig (String retailerCustomAudienceConfig) {
      this.setParam("retailer_custom_audience_config", retailerCustomAudienceConfig);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption setVendorId (String vendorId) {
      this.setParam("vendor_id", vendorId);
      return this;
    }

    public APIRequestCreatePartnerPremiumOption requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePartnerPremiumOption requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerPremiumOption requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePartnerPremiumOption requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerPremiumOption requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePartnerPremiumOption requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPendingClientAdAccounts extends APIRequest<BusinessAdAccountRequest> {

    APINodeList<BusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account",
      "id",
    };

    @Override
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response, String header) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAdAccountRequest>>() {
           public APINodeList<BusinessAdAccountRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingClientAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingClientAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientAdAccounts requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetPendingClientAdAccounts requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetPendingClientAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingClientApps extends APIRequest<BusinessApplicationRequest> {

    APINodeList<BusinessApplicationRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessApplicationRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "application",
      "id",
    };

    @Override
    public APINodeList<BusinessApplicationRequest> parseResponse(String response, String header) throws APIException {
      return BusinessApplicationRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessApplicationRequest>>() {
           public APINodeList<BusinessApplicationRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingClientApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingClientApps(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientApps requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPendingClientApps requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPendingClientApps requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientApps requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingClientPages extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response, String header) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingClientPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingClientPages(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingClientPages requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetPendingClientPages requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
  }

  public static class APIRequestGetPendingOwnedAdAccounts extends APIRequest<BusinessAdAccountRequest> {

    APINodeList<BusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account",
      "id",
    };

    @Override
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response, String header) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAdAccountRequest>>() {
           public APINodeList<BusinessAdAccountRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingOwnedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingOwnedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_owned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingOwnedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingOwnedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingOwnedAdAccounts requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetPendingOwnedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingOwnedPages extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response, String header) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingOwnedPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingOwnedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_owned_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingOwnedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingOwnedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingOwnedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingOwnedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingOwnedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingOwnedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingOwnedPages requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetPendingOwnedPages requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
  }

  public static class APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects extends APIRequest<OffsiteSignalContainerBusinessObject> {

    APINodeList<OffsiteSignalContainerBusinessObject> lastResponse = null;
    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_unavailable",
      "name",
      "primary_container_id",
    };

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> parseResponse(String response, String header) throws APIException {
      return OffsiteSignalContainerBusinessObject.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OffsiteSignalContainerBusinessObject> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OffsiteSignalContainerBusinessObject>>() {
           public APINodeList<OffsiteSignalContainerBusinessObject> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_shared_offsite_signal_container_business_objects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField () {
      return this.requestPrimaryContainerIdField(true);
    }
    public APIRequestGetPendingShareDOffsiteSignalContainerBusinessObjects requestPrimaryContainerIdField (boolean value) {
      this.requestField("primary_container_id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingUsers extends APIRequest<BusinessRoleRequest> {

    APINodeList<BusinessRoleRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessRoleRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "email",
      "expiration_time",
      "expiry_time",
      "finance_role",
      "id",
      "invite_link",
      "ip_role",
      "owner",
      "role",
      "status",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<BusinessRoleRequest> parseResponse(String response, String header) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessRoleRequest>>() {
           public APINodeList<BusinessRoleRequest> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPendingUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPendingUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingUsers setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestGetPendingUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingUsers requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPendingUsers requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPendingUsers requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPendingUsers requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetPendingUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetPendingUsers requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetPendingUsers requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGetPendingUsers requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestFinanceRoleField () {
      return this.requestFinanceRoleField(true);
    }
    public APIRequestGetPendingUsers requestFinanceRoleField (boolean value) {
      this.requestField("finance_role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingUsers requestInviteLinkField () {
      return this.requestInviteLinkField(true);
    }
    public APIRequestGetPendingUsers requestInviteLinkField (boolean value) {
      this.requestField("invite_link", value);
      return this;
    }
    public APIRequestGetPendingUsers requestIpRoleField () {
      return this.requestIpRoleField(true);
    }
    public APIRequestGetPendingUsers requestIpRoleField (boolean value) {
      this.requestField("ip_role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetPendingUsers requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetPendingUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetPendingUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPendingUsers requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPendingUsers requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPendingUsers requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPendingUsers requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPendingUsers requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetPicture extends APIRequest<ProfilePictureSource> {

    APINodeList<ProfilePictureSource> lastResponse = null;
    @Override
    public APINodeList<ProfilePictureSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "height",
      "redirect",
      "type",
      "width",
    };

    public static final String[] FIELDS = {
      "bottom",
      "cache_key",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "url",
      "width",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response, String header) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProfilePictureSource>>() {
           public APINodeList<ProfilePictureSource> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPicture setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetPicture setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }
    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
      return this;
    }

    public APIRequestGetPicture setType (ProfilePictureSource.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetPicture setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPicture setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPicture requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGetPicture requestBottomField (boolean value) {
      this.requestField("bottom", value);
      return this;
    }
    public APIRequestGetPicture requestCacheKeyField () {
      return this.requestCacheKeyField(true);
    }
    public APIRequestGetPicture requestCacheKeyField (boolean value) {
      this.requestField("cache_key", value);
      return this;
    }
    public APIRequestGetPicture requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPicture requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPicture requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGetPicture requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGetPicture requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGetPicture requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGetPicture requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGetPicture requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGetPicture requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGetPicture requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGetPicture requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPicture requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetPicture requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPicture requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreatePixelTo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestCreatePixelTo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePixelTo(String nodeId, APIContext context) {
      super(context, nodeId, "/pixel_tos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePixelTo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePixelTo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePixelTo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePixelTo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePixelTo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePixelTo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePixelTo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePixelTo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPreVerifiedNumbers extends APIRequest<WhatsAppBusinessPreVerifiedPhoneNumber> {

    APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> lastResponse = null;
    @Override
    public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "code_verification_status",
      "phone_number",
    };

    public static final String[] FIELDS = {
      "code_verification_status",
      "code_verification_time",
      "id",
      "owner_business",
      "phone_number",
      "verification_expiry_time",
    };

    @Override
    public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessPreVerifiedPhoneNumber.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>>() {
           public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPreVerifiedNumbers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPreVerifiedNumbers(String nodeId, APIContext context) {
      super(context, nodeId, "/preverified_numbers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPreVerifiedNumbers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPreVerifiedNumbers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreVerifiedNumbers setCodeVerificationStatus (WhatsAppBusinessPreVerifiedPhoneNumber.EnumCodeVerificationStatus codeVerificationStatus) {
      this.setParam("code_verification_status", codeVerificationStatus);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers setCodeVerificationStatus (String codeVerificationStatus) {
      this.setParam("code_verification_status", codeVerificationStatus);
      return this;
    }

    public APIRequestGetPreVerifiedNumbers setPhoneNumber (String phoneNumber) {
      this.setParam("phone_number", phoneNumber);
      return this;
    }

    public APIRequestGetPreVerifiedNumbers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPreVerifiedNumbers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreVerifiedNumbers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPreVerifiedNumbers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreVerifiedNumbers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPreVerifiedNumbers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPreVerifiedNumbers requestCodeVerificationStatusField () {
      return this.requestCodeVerificationStatusField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestCodeVerificationStatusField (boolean value) {
      this.requestField("code_verification_status", value);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers requestCodeVerificationTimeField () {
      return this.requestCodeVerificationTimeField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestCodeVerificationTimeField (boolean value) {
      this.requestField("code_verification_time", value);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGetPreVerifiedNumbers requestVerificationExpiryTimeField () {
      return this.requestVerificationExpiryTimeField(true);
    }
    public APIRequestGetPreVerifiedNumbers requestVerificationExpiryTimeField (boolean value) {
      this.requestField("verification_expiry_time", value);
      return this;
    }
  }

  public static class APIRequestGetReceivedAudienceSharingRequests extends APIRequest<BusinessAssetSharingAgreement> {

    APINodeList<BusinessAssetSharingAgreement> lastResponse = null;
    @Override
    public APINodeList<BusinessAssetSharingAgreement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "initiator_id",
      "request_status",
    };

    public static final String[] FIELDS = {
      "id",
      "initiator",
      "recipient",
      "relationship_type",
      "request_status",
      "request_type",
    };

    @Override
    public APINodeList<BusinessAssetSharingAgreement> parseResponse(String response, String header) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAssetSharingAgreement>>() {
           public APINodeList<BusinessAssetSharingAgreement> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReceivedAudienceSharingRequests.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetReceivedAudienceSharingRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/received_audience_sharing_requests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReceivedAudienceSharingRequests setInitiatorId (String initiatorId) {
      this.setParam("initiator_id", initiatorId);
      return this;
    }

    public APIRequestGetReceivedAudienceSharingRequests setRequestStatus (BusinessAssetSharingAgreement.EnumRequestStatus requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests setRequestStatus (String requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }

    public APIRequestGetReceivedAudienceSharingRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReceivedAudienceSharingRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudienceSharingRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReceivedAudienceSharingRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests requestInitiatorField () {
      return this.requestInitiatorField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestInitiatorField (boolean value) {
      this.requestField("initiator", value);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRelationshipTypeField () {
      return this.requestRelationshipTypeField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRelationshipTypeField (boolean value) {
      this.requestField("relationship_type", value);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRequestTypeField () {
      return this.requestRequestTypeField(true);
    }
    public APIRequestGetReceivedAudienceSharingRequests requestRequestTypeField (boolean value) {
      this.requestField("request_type", value);
      return this;
    }
  }

  public static class APIRequestGetResellerGuidances extends APIRequest<ResellerGuidance> {

    APINodeList<ResellerGuidance> lastResponse = null;
    @Override
    public APINodeList<ResellerGuidance> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_first_spend_date",
      "ad_account_id",
      "adopted_guidance_l7d",
      "advertiser_name",
      "attributed_to_reseller_l7d",
      "available_guidance",
      "benchmark_report_link",
      "guidance_adoption_rate_l7d",
      "no_adsets_gte_benchmark",
      "no_adsets_lt_benchmark",
      "nurtured_by_reseller_l7d",
      "planning_agency_name",
      "recommendation_time",
      "reporting_ds",
      "reseller",
      "revenue_l30d",
      "ultimate_advertiser_name",
    };

    @Override
    public APINodeList<ResellerGuidance> parseResponse(String response, String header) throws APIException {
      return ResellerGuidance.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ResellerGuidance> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ResellerGuidance> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ResellerGuidance>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ResellerGuidance>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ResellerGuidance>>() {
           public APINodeList<ResellerGuidance> apply(ResponseWrapper result) {
             try {
               return APIRequestGetResellerGuidances.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetResellerGuidances(String nodeId, APIContext context) {
      super(context, nodeId, "/reseller_guidances", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetResellerGuidances setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetResellerGuidances setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetResellerGuidances requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetResellerGuidances requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetResellerGuidances requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetResellerGuidances requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetResellerGuidances requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetResellerGuidances requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetResellerGuidances requestAdAccountFirstSpendDateField () {
      return this.requestAdAccountFirstSpendDateField(true);
    }
    public APIRequestGetResellerGuidances requestAdAccountFirstSpendDateField (boolean value) {
      this.requestField("ad_account_first_spend_date", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGetResellerGuidances requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestAdoptedGuidanceL7dField () {
      return this.requestAdoptedGuidanceL7dField(true);
    }
    public APIRequestGetResellerGuidances requestAdoptedGuidanceL7dField (boolean value) {
      this.requestField("adopted_guidance_l7d", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestAdvertiserNameField () {
      return this.requestAdvertiserNameField(true);
    }
    public APIRequestGetResellerGuidances requestAdvertiserNameField (boolean value) {
      this.requestField("advertiser_name", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestAttributedToResellerL7dField () {
      return this.requestAttributedToResellerL7dField(true);
    }
    public APIRequestGetResellerGuidances requestAttributedToResellerL7dField (boolean value) {
      this.requestField("attributed_to_reseller_l7d", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestAvailableGuidanceField () {
      return this.requestAvailableGuidanceField(true);
    }
    public APIRequestGetResellerGuidances requestAvailableGuidanceField (boolean value) {
      this.requestField("available_guidance", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestBenchmarkReportLinkField () {
      return this.requestBenchmarkReportLinkField(true);
    }
    public APIRequestGetResellerGuidances requestBenchmarkReportLinkField (boolean value) {
      this.requestField("benchmark_report_link", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestGuidanceAdoptionRateL7dField () {
      return this.requestGuidanceAdoptionRateL7dField(true);
    }
    public APIRequestGetResellerGuidances requestGuidanceAdoptionRateL7dField (boolean value) {
      this.requestField("guidance_adoption_rate_l7d", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestNoAdsetsGteBenchmarkField () {
      return this.requestNoAdsetsGteBenchmarkField(true);
    }
    public APIRequestGetResellerGuidances requestNoAdsetsGteBenchmarkField (boolean value) {
      this.requestField("no_adsets_gte_benchmark", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestNoAdsetsLtBenchmarkField () {
      return this.requestNoAdsetsLtBenchmarkField(true);
    }
    public APIRequestGetResellerGuidances requestNoAdsetsLtBenchmarkField (boolean value) {
      this.requestField("no_adsets_lt_benchmark", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestNurturedByResellerL7dField () {
      return this.requestNurturedByResellerL7dField(true);
    }
    public APIRequestGetResellerGuidances requestNurturedByResellerL7dField (boolean value) {
      this.requestField("nurtured_by_reseller_l7d", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestPlanningAgencyNameField () {
      return this.requestPlanningAgencyNameField(true);
    }
    public APIRequestGetResellerGuidances requestPlanningAgencyNameField (boolean value) {
      this.requestField("planning_agency_name", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestRecommendationTimeField () {
      return this.requestRecommendationTimeField(true);
    }
    public APIRequestGetResellerGuidances requestRecommendationTimeField (boolean value) {
      this.requestField("recommendation_time", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestReportingDsField () {
      return this.requestReportingDsField(true);
    }
    public APIRequestGetResellerGuidances requestReportingDsField (boolean value) {
      this.requestField("reporting_ds", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestResellerField () {
      return this.requestResellerField(true);
    }
    public APIRequestGetResellerGuidances requestResellerField (boolean value) {
      this.requestField("reseller", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestRevenueL30dField () {
      return this.requestRevenueL30dField(true);
    }
    public APIRequestGetResellerGuidances requestRevenueL30dField (boolean value) {
      this.requestField("revenue_l30d", value);
      return this;
    }
    public APIRequestGetResellerGuidances requestUltimateAdvertiserNameField () {
      return this.requestUltimateAdvertiserNameField(true);
    }
    public APIRequestGetResellerGuidances requestUltimateAdvertiserNameField (boolean value) {
      this.requestField("ultimate_advertiser_name", value);
      return this;
    }
  }

  public static class APIRequestGetSelfCertifiedWhatsappBusinessSubmissions extends APIRequest<WhatsAppBusinessPartnerClientVerificationSubmission> {

    APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> lastResponse = null;
    @Override
    public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_business_id",
    };

    public static final String[] FIELDS = {
      "client_business_id",
      "id",
      "rejection_reasons",
      "submitted_info",
      "submitted_time",
      "update_time",
      "verification_status",
    };

    @Override
    public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessPartnerClientVerificationSubmission.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission>>() {
           public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSelfCertifiedWhatsappBusinessSubmissions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions(String nodeId, APIContext context) {
      super(context, nodeId, "/self_certified_whatsapp_business_submissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions setEndBusinessId (String endBusinessId) {
      this.setParam("end_business_id", endBusinessId);
      return this;
    }

    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestClientBusinessIdField () {
      return this.requestClientBusinessIdField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestClientBusinessIdField (boolean value) {
      this.requestField("client_business_id", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestRejectionReasonsField () {
      return this.requestRejectionReasonsField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestRejectionReasonsField (boolean value) {
      this.requestField("rejection_reasons", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestSubmittedInfoField () {
      return this.requestSubmittedInfoField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestSubmittedInfoField (boolean value) {
      this.requestField("submitted_info", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestSubmittedTimeField () {
      return this.requestSubmittedTimeField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestSubmittedTimeField (boolean value) {
      this.requestField("submitted_time", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetSelfCertifiedWhatsappBusinessSubmissions requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
  }

  public static class APIRequestCreateSetupMAnAgeDPartnerAdAccount extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "credit_line_id",
      "marketplace_business_id",
      "subvertical_v2",
      "vendor_id",
      "vertical_v2",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSetupMAnAgeDPartnerAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/setup_managed_partner_adaccounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setCreditLineId (String creditLineId) {
      this.setParam("credit_line_id", creditLineId);
      return this;
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setMarketplaceBusinessId (String marketplaceBusinessId) {
      this.setParam("marketplace_business_id", marketplaceBusinessId);
      return this;
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setSubverticalV2 (Business.EnumSubverticalV2 subverticalV2) {
      this.setParam("subvertical_v2", subverticalV2);
      return this;
    }
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setSubverticalV2 (String subverticalV2) {
      this.setParam("subvertical_v2", subverticalV2);
      return this;
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setVendorId (String vendorId) {
      this.setParam("vendor_id", vendorId);
      return this;
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setVerticalV2 (Business.EnumVerticalV2 verticalV2) {
      this.setParam("vertical_v2", verticalV2);
      return this;
    }
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount setVerticalV2 (String verticalV2) {
      this.setParam("vertical_v2", verticalV2);
      return this;
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSetupMAnAgeDPartnerAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteSharePreVerifiedNumbers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_business_id",
      "preverified_id",
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
               return APIRequestDeleteSharePreVerifiedNumbers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteSharePreVerifiedNumbers(String nodeId, APIContext context) {
      super(context, nodeId, "/share_preverified_numbers", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteSharePreVerifiedNumbers setPartnerBusinessId (String partnerBusinessId) {
      this.setParam("partner_business_id", partnerBusinessId);
      return this;
    }

    public APIRequestDeleteSharePreVerifiedNumbers setPreverifiedId (String preverifiedId) {
      this.setParam("preverified_id", preverifiedId);
      return this;
    }

    public APIRequestDeleteSharePreVerifiedNumbers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteSharePreVerifiedNumbers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteSharePreVerifiedNumbers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSharePreVerifiedNumber extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_business_id",
      "preverified_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSharePreVerifiedNumber.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSharePreVerifiedNumber(String nodeId, APIContext context) {
      super(context, nodeId, "/share_preverified_numbers", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSharePreVerifiedNumber setPartnerBusinessId (String partnerBusinessId) {
      this.setParam("partner_business_id", partnerBusinessId);
      return this;
    }

    public APIRequestCreateSharePreVerifiedNumber setPreverifiedId (String preverifiedId) {
      this.setParam("preverified_id", preverifiedId);
      return this;
    }

    public APIRequestCreateSharePreVerifiedNumber requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSharePreVerifiedNumber requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSharePreVerifiedNumber requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSystemUserAccessToken extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "asset",
      "fetch_only",
      "scope",
      "set_token_expires_in_60_days",
      "system_user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSystemUserAccessToken.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSystemUserAccessToken(String nodeId, APIContext context) {
      super(context, nodeId, "/system_user_access_tokens", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSystemUserAccessToken setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSystemUserAccessToken setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSystemUserAccessToken setAsset (List<Long> asset) {
      this.setParam("asset", asset);
      return this;
    }
    public APIRequestCreateSystemUserAccessToken setAsset (String asset) {
      this.setParam("asset", asset);
      return this;
    }

    public APIRequestCreateSystemUserAccessToken setFetchOnly (Boolean fetchOnly) {
      this.setParam("fetch_only", fetchOnly);
      return this;
    }
    public APIRequestCreateSystemUserAccessToken setFetchOnly (String fetchOnly) {
      this.setParam("fetch_only", fetchOnly);
      return this;
    }

    public APIRequestCreateSystemUserAccessToken setScope (List<Permission> scope) {
      this.setParam("scope", scope);
      return this;
    }
    public APIRequestCreateSystemUserAccessToken setScope (String scope) {
      this.setParam("scope", scope);
      return this;
    }

    public APIRequestCreateSystemUserAccessToken setSetTokenExpiresIn60Days (Boolean setTokenExpiresIn60Days) {
      this.setParam("set_token_expires_in_60_days", setTokenExpiresIn60Days);
      return this;
    }
    public APIRequestCreateSystemUserAccessToken setSetTokenExpiresIn60Days (String setTokenExpiresIn60Days) {
      this.setParam("set_token_expires_in_60_days", setTokenExpiresIn60Days);
      return this;
    }

    public APIRequestCreateSystemUserAccessToken setSystemUserId (Long systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }
    public APIRequestCreateSystemUserAccessToken setSystemUserId (String systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }

    public APIRequestCreateSystemUserAccessToken requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSystemUserAccessToken requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUserAccessToken requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSystemUserAccessToken requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUserAccessToken requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSystemUserAccessToken requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSystemUsers extends APIRequest<SystemUser> {

    APINodeList<SystemUser> lastResponse = null;
    @Override
    public APINodeList<SystemUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "finance_permission",
      "id",
      "ip_permission",
      "name",
    };

    @Override
    public APINodeList<SystemUser> parseResponse(String response, String header) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<SystemUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<SystemUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<SystemUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<SystemUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<SystemUser>>() {
           public APINodeList<SystemUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSystemUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSystemUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/system_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSystemUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSystemUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSystemUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSystemUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSystemUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSystemUsers requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetSystemUsers requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetSystemUsers requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetSystemUsers requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetSystemUsers requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGetSystemUsers requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGetSystemUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSystemUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSystemUsers requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGetSystemUsers requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGetSystemUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSystemUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateSystemUser extends APIRequest<SystemUser> {

    SystemUser lastResponse = null;
    @Override
    public SystemUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "role",
      "system_user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SystemUser parseResponse(String response, String header) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public SystemUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SystemUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<SystemUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SystemUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, SystemUser>() {
           public SystemUser apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSystemUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSystemUser(String nodeId, APIContext context) {
      super(context, nodeId, "/system_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSystemUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSystemUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSystemUser setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateSystemUser setRole (SystemUser.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateSystemUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateSystemUser setSystemUserId (Long systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }
    public APIRequestCreateSystemUser setSystemUserId (String systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }

    public APIRequestCreateSystemUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSystemUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSystemUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetThirdPartyMeasurementReportDataset extends APIRequest<ThirdPartyMeasurementReportDataset> {

    APINodeList<ThirdPartyMeasurementReportDataset> lastResponse = null;
    @Override
    public APINodeList<ThirdPartyMeasurementReportDataset> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "category",
      "id",
      "partner",
      "product",
      "schema",
    };

    @Override
    public APINodeList<ThirdPartyMeasurementReportDataset> parseResponse(String response, String header) throws APIException {
      return ThirdPartyMeasurementReportDataset.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ThirdPartyMeasurementReportDataset> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ThirdPartyMeasurementReportDataset> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ThirdPartyMeasurementReportDataset>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ThirdPartyMeasurementReportDataset>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ThirdPartyMeasurementReportDataset>>() {
           public APINodeList<ThirdPartyMeasurementReportDataset> apply(ResponseWrapper result) {
             try {
               return APIRequestGetThirdPartyMeasurementReportDataset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetThirdPartyMeasurementReportDataset(String nodeId, APIContext context) {
      super(context, nodeId, "/third_party_measurement_report_dataset", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetThirdPartyMeasurementReportDataset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetThirdPartyMeasurementReportDataset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetThirdPartyMeasurementReportDataset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetThirdPartyMeasurementReportDataset requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestProductField () {
      return this.requestProductField(true);
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestProductField (boolean value) {
      this.requestField("product", value);
      return this;
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestSchemaField () {
      return this.requestSchemaField(true);
    }
    public APIRequestGetThirdPartyMeasurementReportDataset requestSchemaField (boolean value) {
      this.requestField("schema", value);
      return this;
    }
  }

  public static class APIRequestCreateVideo extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_placements_validation_only",
      "animated_effect_id",
      "application_id",
      "asked_fun_fact_prompt_id",
      "audio_story_wave_animation_handle",
      "chunk_session_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_session_id",
      "composer_source_surface",
      "composer_type",
      "container_type",
      "content_category",
      "creative_folder_id",
      "creative_tools",
      "description",
      "embeddable",
      "end_offset",
      "fbuploader_video_file_chunk",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "formatting",
      "fov",
      "front_z_rotation",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "guide",
      "guide_enabled",
      "holiday_card",
      "initial_heading",
      "initial_pitch",
      "instant_game_entry_point_data",
      "is_boost_intended",
      "is_group_linking_post",
      "is_voice_clip",
      "location_source_id",
      "offer_like_post_id",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_suggestion_mechanism",
      "original_fov",
      "original_projection_type",
      "publish_event_id",
      "referenced_sticker_id",
      "replace_video_id",
      "slideshow_spec",
      "source",
      "source_instagram_media_id",
      "spherical",
      "start_offset",
      "swap_mode",
      "text_format_metadata",
      "throwback_camera_roll_media",
      "thumb",
      "time_since_original_post",
      "title",
      "transcode_setting_properties",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "upload_setting_properties",
      "validation_ad_placements",
      "video_file_chunk",
      "video_id_original",
      "video_start_time_ms",
      "waterfall_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response, String header) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdVideo>() {
           public AdVideo apply(ResponseWrapper result) {
             try {
               return APIRequestCreateVideo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setAdPlacementsValidationOnly (Boolean adPlacementsValidationOnly) {
      this.setParam("ad_placements_validation_only", adPlacementsValidationOnly);
      return this;
    }
    public APIRequestCreateVideo setAdPlacementsValidationOnly (String adPlacementsValidationOnly) {
      this.setParam("ad_placements_validation_only", adPlacementsValidationOnly);
      return this;
    }

    public APIRequestCreateVideo setAnimatedEffectId (Long animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }
    public APIRequestCreateVideo setAnimatedEffectId (String animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }

    public APIRequestCreateVideo setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateVideo setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setChunkSessionId (String chunkSessionId) {
      this.setParam("chunk_session_id", chunkSessionId);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPicker (String composerEntryPicker) {
      this.setParam("composer_entry_picker", composerEntryPicker);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPoint (String composerEntryPoint) {
      this.setParam("composer_entry_point", composerEntryPoint);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryTime (Long composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }
    public APIRequestCreateVideo setComposerEntryTime (String composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionEventsLog (String composerSessionEventsLog) {
      this.setParam("composer_session_events_log", composerSessionEventsLog);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateVideo setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateVideo setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
      return this;
    }

    public APIRequestCreateVideo setContainerType (AdVideo.EnumContainerType containerType) {
      this.setParam("container_type", containerType);
      return this;
    }
    public APIRequestCreateVideo setContainerType (String containerType) {
      this.setParam("container_type", containerType);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (AdVideo.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideo setCreativeFolderId (String creativeFolderId) {
      this.setParam("creative_folder_id", creativeFolderId);
      return this;
    }

    public APIRequestCreateVideo setCreativeTools (String creativeTools) {
      this.setParam("creative_tools", creativeTools);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestCreateVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateVideo setFbuploaderVideoFileChunk (String fbuploaderVideoFileChunk) {
      this.setParam("fbuploader_video_file_chunk", fbuploaderVideoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateVideo setFormatting (AdVideo.EnumFormatting formatting) {
      this.setParam("formatting", formatting);
      return this;
    }
    public APIRequestCreateVideo setFormatting (String formatting) {
      this.setParam("formatting", formatting);
      return this;
    }

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
      return this;
    }

    public APIRequestCreateVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateVideo setFunFactPromptId (Long funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setFunFactPromptId (String funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setFunFactToasteeId (Long funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }
    public APIRequestCreateVideo setFunFactToasteeId (String funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }

    public APIRequestCreateVideo setGuide (List<List<Long>> guide) {
      this.setParam("guide", guide);
      return this;
    }
    public APIRequestCreateVideo setGuide (String guide) {
      this.setParam("guide", guide);
      return this;
    }

    public APIRequestCreateVideo setGuideEnabled (Boolean guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }
    public APIRequestCreateVideo setGuideEnabled (String guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }

    public APIRequestCreateVideo setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
      return this;
    }

    public APIRequestCreateVideo setInitialHeading (Long initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }
    public APIRequestCreateVideo setInitialHeading (String initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }

    public APIRequestCreateVideo setInitialPitch (Long initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }
    public APIRequestCreateVideo setInitialPitch (String initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }

    public APIRequestCreateVideo setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
      return this;
    }

    public APIRequestCreateVideo setIsBoostIntended (Boolean isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }
    public APIRequestCreateVideo setIsBoostIntended (String isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }

    public APIRequestCreateVideo setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateVideo setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }

    public APIRequestCreateVideo setIsVoiceClip (Boolean isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }
    public APIRequestCreateVideo setIsVoiceClip (String isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }

    public APIRequestCreateVideo setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateVideo setOfferLikePostId (Long offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }
    public APIRequestCreateVideo setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateVideo setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateVideo setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateVideo setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateVideo setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateVideo setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreateVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateVideo setOriginalProjectionType (AdVideo.EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setPublishEventId (Long publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }
    public APIRequestCreateVideo setPublishEventId (String publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }

    public APIRequestCreateVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateVideo setReplaceVideoId (String replaceVideoId) {
      this.setParam("replace_video_id", replaceVideoId);
      return this;
    }

    public APIRequestCreateVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateVideo setSourceInstagramMediaId (String sourceInstagramMediaId) {
      this.setParam("source_instagram_media_id", sourceInstagramMediaId);
      return this;
    }

    public APIRequestCreateVideo setSpherical (Boolean spherical) {
      this.setParam("spherical", spherical);
      return this;
    }
    public APIRequestCreateVideo setSpherical (String spherical) {
      this.setParam("spherical", spherical);
      return this;
    }

    public APIRequestCreateVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateVideo setSwapMode (AdVideo.EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }

    public APIRequestCreateVideo setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateVideo setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
      return this;
    }

    public APIRequestCreateVideo setThumb (File thumb) {
      this.setParam("thumb", thumb);
      return this;
    }
    public APIRequestCreateVideo setThumb (String thumb) {
      this.setParam("thumb", thumb);
      return this;
    }

    public APIRequestCreateVideo setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateVideo setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setTranscodeSettingProperties (String transcodeSettingProperties) {
      this.setParam("transcode_setting_properties", transcodeSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (AdVideo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (AdVideo.EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateVideo setUploadSettingProperties (String uploadSettingProperties) {
      this.setParam("upload_setting_properties", uploadSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setValidationAdPlacements (List<AdVideo.EnumValidationAdPlacements> validationAdPlacements) {
      this.setParam("validation_ad_placements", validationAdPlacements);
      return this;
    }
    public APIRequestCreateVideo setValidationAdPlacements (String validationAdPlacements) {
      this.setParam("validation_ad_placements", validationAdPlacements);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setVideoIdOriginal (String videoIdOriginal) {
      this.setParam("video_id_original", videoIdOriginal);
      return this;
    }

    public APIRequestCreateVideo setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateVideo setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateVideo setWaterfallId (String waterfallId) {
      this.setParam("waterfall_id", waterfallId);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
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
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
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

    public APIRequestGet requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGet requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGet requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGet requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGet requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGet requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGet requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGet requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGet requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGet requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGet requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGet requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGet requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGet requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGet requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGet requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGet requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGet requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGet requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGet requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGet requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "entry_point",
      "name",
      "primary_page",
      "timezone_id",
      "two_factor_type",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Business>() {
           public Business apply(ResponseWrapper result) {
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


    public APIRequestUpdate setEntryPoint (String entryPoint) {
      this.setParam("entry_point", entryPoint);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPrimaryPage (String primaryPage) {
      this.setParam("primary_page", primaryPage);
      return this;
    }

    public APIRequestUpdate setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestUpdate setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestUpdate setTwoFactorType (Business.EnumTwoFactorType twoFactorType) {
      this.setParam("two_factor_type", twoFactorType);
      return this;
    }
    public APIRequestUpdate setTwoFactorType (String twoFactorType) {
      this.setParam("two_factor_type", twoFactorType);
      return this;
    }

    public APIRequestUpdate setVertical (Business.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestUpdate setVertical (String vertical) {
      this.setParam("vertical", vertical);
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

  public static enum EnumTwoFactorType {
      @SerializedName("admin_required")
      VALUE_ADMIN_REQUIRED("admin_required"),
      @SerializedName("all_required")
      VALUE_ALL_REQUIRED("all_required"),
      @SerializedName("none")
      VALUE_NONE("none"),
      ;

      private String value;

      private EnumTwoFactorType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVertical {
      @SerializedName("ADVERTISING")
      VALUE_ADVERTISING("ADVERTISING"),
      @SerializedName("AUTOMOTIVE")
      VALUE_AUTOMOTIVE("AUTOMOTIVE"),
      @SerializedName("CONSUMER_PACKAGED_GOODS")
      VALUE_CONSUMER_PACKAGED_GOODS("CONSUMER_PACKAGED_GOODS"),
      @SerializedName("ECOMMERCE")
      VALUE_ECOMMERCE("ECOMMERCE"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ENERGY_AND_UTILITIES")
      VALUE_ENERGY_AND_UTILITIES("ENERGY_AND_UTILITIES"),
      @SerializedName("ENTERTAINMENT_AND_MEDIA")
      VALUE_ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
      @SerializedName("FINANCIAL_SERVICES")
      VALUE_FINANCIAL_SERVICES("FINANCIAL_SERVICES"),
      @SerializedName("GAMING")
      VALUE_GAMING("GAMING"),
      @SerializedName("GOVERNMENT_AND_POLITICS")
      VALUE_GOVERNMENT_AND_POLITICS("GOVERNMENT_AND_POLITICS"),
      @SerializedName("HEALTH")
      VALUE_HEALTH("HEALTH"),
      @SerializedName("LUXURY")
      VALUE_LUXURY("LUXURY"),
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("NOT_SET")
      VALUE_NOT_SET("NOT_SET"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("RESTAURANT")
      VALUE_RESTAURANT("RESTAURANT"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      ;

      private String value;

      private EnumVertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedTasks {
      @SerializedName("ADVERTISE")
      VALUE_ADVERTISE("ADVERTISE"),
      @SerializedName("ANALYZE")
      VALUE_ANALYZE("ANALYZE"),
      @SerializedName("CASHIER_ROLE")
      VALUE_CASHIER_ROLE("CASHIER_ROLE"),
      @SerializedName("CREATE_CONTENT")
      VALUE_CREATE_CONTENT("CREATE_CONTENT"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_JOBS")
      VALUE_MANAGE_JOBS("MANAGE_JOBS"),
      @SerializedName("MANAGE_LEADS")
      VALUE_MANAGE_LEADS("MANAGE_LEADS"),
      @SerializedName("MESSAGING")
      VALUE_MESSAGING("MESSAGING"),
      @SerializedName("MODERATE")
      VALUE_MODERATE("MODERATE"),
      @SerializedName("MODERATE_COMMUNITY")
      VALUE_MODERATE_COMMUNITY("MODERATE_COMMUNITY"),
      @SerializedName("PAGES_MESSAGING")
      VALUE_PAGES_MESSAGING("PAGES_MESSAGING"),
      @SerializedName("PAGES_MESSAGING_SUBSCRIPTIONS")
      VALUE_PAGES_MESSAGING_SUBSCRIPTIONS("PAGES_MESSAGING_SUBSCRIPTIONS"),
      @SerializedName("PROFILE_PLUS_ADVERTISE")
      VALUE_PROFILE_PLUS_ADVERTISE("PROFILE_PLUS_ADVERTISE"),
      @SerializedName("PROFILE_PLUS_ANALYZE")
      VALUE_PROFILE_PLUS_ANALYZE("PROFILE_PLUS_ANALYZE"),
      @SerializedName("PROFILE_PLUS_CREATE_CONTENT")
      VALUE_PROFILE_PLUS_CREATE_CONTENT("PROFILE_PLUS_CREATE_CONTENT"),
      @SerializedName("PROFILE_PLUS_FACEBOOK_ACCESS")
      VALUE_PROFILE_PLUS_FACEBOOK_ACCESS("PROFILE_PLUS_FACEBOOK_ACCESS"),
      @SerializedName("PROFILE_PLUS_FULL_CONTROL")
      VALUE_PROFILE_PLUS_FULL_CONTROL("PROFILE_PLUS_FULL_CONTROL"),
      @SerializedName("PROFILE_PLUS_MANAGE")
      VALUE_PROFILE_PLUS_MANAGE("PROFILE_PLUS_MANAGE"),
      @SerializedName("PROFILE_PLUS_MANAGE_LEADS")
      VALUE_PROFILE_PLUS_MANAGE_LEADS("PROFILE_PLUS_MANAGE_LEADS"),
      @SerializedName("PROFILE_PLUS_MESSAGING")
      VALUE_PROFILE_PLUS_MESSAGING("PROFILE_PLUS_MESSAGING"),
      @SerializedName("PROFILE_PLUS_MODERATE")
      VALUE_PROFILE_PLUS_MODERATE("PROFILE_PLUS_MODERATE"),
      @SerializedName("PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY")
      VALUE_PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY("PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY"),
      @SerializedName("PROFILE_PLUS_REVENUE")
      VALUE_PROFILE_PLUS_REVENUE("PROFILE_PLUS_REVENUE"),
      @SerializedName("READ_PAGE_MAILBOXES")
      VALUE_READ_PAGE_MAILBOXES("READ_PAGE_MAILBOXES"),
      @SerializedName("VIEW_MONETIZATION_INSIGHTS")
      VALUE_VIEW_MONETIZATION_INSIGHTS("VIEW_MONETIZATION_INSIGHTS"),
      ;

      private String value;

      private EnumPermittedTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSurveyBusinessType {
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("APP_DEVELOPER")
      VALUE_APP_DEVELOPER("APP_DEVELOPER"),
      @SerializedName("PUBLISHER")
      VALUE_PUBLISHER("PUBLISHER"),
      ;

      private String value;

      private EnumSurveyBusinessType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimezoneId {
      @SerializedName("0")
      VALUE_0("0"),
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      @SerializedName("3")
      VALUE_3("3"),
      @SerializedName("4")
      VALUE_4("4"),
      @SerializedName("5")
      VALUE_5("5"),
      @SerializedName("6")
      VALUE_6("6"),
      @SerializedName("7")
      VALUE_7("7"),
      @SerializedName("8")
      VALUE_8("8"),
      @SerializedName("9")
      VALUE_9("9"),
      @SerializedName("10")
      VALUE_10("10"),
      @SerializedName("11")
      VALUE_11("11"),
      @SerializedName("12")
      VALUE_12("12"),
      @SerializedName("13")
      VALUE_13("13"),
      @SerializedName("14")
      VALUE_14("14"),
      @SerializedName("15")
      VALUE_15("15"),
      @SerializedName("16")
      VALUE_16("16"),
      @SerializedName("17")
      VALUE_17("17"),
      @SerializedName("18")
      VALUE_18("18"),
      @SerializedName("19")
      VALUE_19("19"),
      @SerializedName("20")
      VALUE_20("20"),
      @SerializedName("21")
      VALUE_21("21"),
      @SerializedName("22")
      VALUE_22("22"),
      @SerializedName("23")
      VALUE_23("23"),
      @SerializedName("24")
      VALUE_24("24"),
      @SerializedName("25")
      VALUE_25("25"),
      @SerializedName("26")
      VALUE_26("26"),
      @SerializedName("27")
      VALUE_27("27"),
      @SerializedName("28")
      VALUE_28("28"),
      @SerializedName("29")
      VALUE_29("29"),
      @SerializedName("30")
      VALUE_30("30"),
      @SerializedName("31")
      VALUE_31("31"),
      @SerializedName("32")
      VALUE_32("32"),
      @SerializedName("33")
      VALUE_33("33"),
      @SerializedName("34")
      VALUE_34("34"),
      @SerializedName("35")
      VALUE_35("35"),
      @SerializedName("36")
      VALUE_36("36"),
      @SerializedName("37")
      VALUE_37("37"),
      @SerializedName("38")
      VALUE_38("38"),
      @SerializedName("39")
      VALUE_39("39"),
      @SerializedName("40")
      VALUE_40("40"),
      @SerializedName("41")
      VALUE_41("41"),
      @SerializedName("42")
      VALUE_42("42"),
      @SerializedName("43")
      VALUE_43("43"),
      @SerializedName("44")
      VALUE_44("44"),
      @SerializedName("45")
      VALUE_45("45"),
      @SerializedName("46")
      VALUE_46("46"),
      @SerializedName("47")
      VALUE_47("47"),
      @SerializedName("48")
      VALUE_48("48"),
      @SerializedName("49")
      VALUE_49("49"),
      @SerializedName("50")
      VALUE_50("50"),
      @SerializedName("51")
      VALUE_51("51"),
      @SerializedName("52")
      VALUE_52("52"),
      @SerializedName("53")
      VALUE_53("53"),
      @SerializedName("54")
      VALUE_54("54"),
      @SerializedName("55")
      VALUE_55("55"),
      @SerializedName("56")
      VALUE_56("56"),
      @SerializedName("57")
      VALUE_57("57"),
      @SerializedName("58")
      VALUE_58("58"),
      @SerializedName("59")
      VALUE_59("59"),
      @SerializedName("60")
      VALUE_60("60"),
      @SerializedName("61")
      VALUE_61("61"),
      @SerializedName("62")
      VALUE_62("62"),
      @SerializedName("63")
      VALUE_63("63"),
      @SerializedName("64")
      VALUE_64("64"),
      @SerializedName("65")
      VALUE_65("65"),
      @SerializedName("66")
      VALUE_66("66"),
      @SerializedName("67")
      VALUE_67("67"),
      @SerializedName("68")
      VALUE_68("68"),
      @SerializedName("69")
      VALUE_69("69"),
      @SerializedName("70")
      VALUE_70("70"),
      @SerializedName("71")
      VALUE_71("71"),
      @SerializedName("72")
      VALUE_72("72"),
      @SerializedName("73")
      VALUE_73("73"),
      @SerializedName("74")
      VALUE_74("74"),
      @SerializedName("75")
      VALUE_75("75"),
      @SerializedName("76")
      VALUE_76("76"),
      @SerializedName("77")
      VALUE_77("77"),
      @SerializedName("78")
      VALUE_78("78"),
      @SerializedName("79")
      VALUE_79("79"),
      @SerializedName("80")
      VALUE_80("80"),
      @SerializedName("81")
      VALUE_81("81"),
      @SerializedName("82")
      VALUE_82("82"),
      @SerializedName("83")
      VALUE_83("83"),
      @SerializedName("84")
      VALUE_84("84"),
      @SerializedName("85")
      VALUE_85("85"),
      @SerializedName("86")
      VALUE_86("86"),
      @SerializedName("87")
      VALUE_87("87"),
      @SerializedName("88")
      VALUE_88("88"),
      @SerializedName("89")
      VALUE_89("89"),
      @SerializedName("90")
      VALUE_90("90"),
      @SerializedName("91")
      VALUE_91("91"),
      @SerializedName("92")
      VALUE_92("92"),
      @SerializedName("93")
      VALUE_93("93"),
      @SerializedName("94")
      VALUE_94("94"),
      @SerializedName("95")
      VALUE_95("95"),
      @SerializedName("96")
      VALUE_96("96"),
      @SerializedName("97")
      VALUE_97("97"),
      @SerializedName("98")
      VALUE_98("98"),
      @SerializedName("99")
      VALUE_99("99"),
      @SerializedName("100")
      VALUE_100("100"),
      @SerializedName("101")
      VALUE_101("101"),
      @SerializedName("102")
      VALUE_102("102"),
      @SerializedName("103")
      VALUE_103("103"),
      @SerializedName("104")
      VALUE_104("104"),
      @SerializedName("105")
      VALUE_105("105"),
      @SerializedName("106")
      VALUE_106("106"),
      @SerializedName("107")
      VALUE_107("107"),
      @SerializedName("108")
      VALUE_108("108"),
      @SerializedName("109")
      VALUE_109("109"),
      @SerializedName("110")
      VALUE_110("110"),
      @SerializedName("111")
      VALUE_111("111"),
      @SerializedName("112")
      VALUE_112("112"),
      @SerializedName("113")
      VALUE_113("113"),
      @SerializedName("114")
      VALUE_114("114"),
      @SerializedName("115")
      VALUE_115("115"),
      @SerializedName("116")
      VALUE_116("116"),
      @SerializedName("117")
      VALUE_117("117"),
      @SerializedName("118")
      VALUE_118("118"),
      @SerializedName("119")
      VALUE_119("119"),
      @SerializedName("120")
      VALUE_120("120"),
      @SerializedName("121")
      VALUE_121("121"),
      @SerializedName("122")
      VALUE_122("122"),
      @SerializedName("123")
      VALUE_123("123"),
      @SerializedName("124")
      VALUE_124("124"),
      @SerializedName("125")
      VALUE_125("125"),
      @SerializedName("126")
      VALUE_126("126"),
      @SerializedName("127")
      VALUE_127("127"),
      @SerializedName("128")
      VALUE_128("128"),
      @SerializedName("129")
      VALUE_129("129"),
      @SerializedName("130")
      VALUE_130("130"),
      @SerializedName("131")
      VALUE_131("131"),
      @SerializedName("132")
      VALUE_132("132"),
      @SerializedName("133")
      VALUE_133("133"),
      @SerializedName("134")
      VALUE_134("134"),
      @SerializedName("135")
      VALUE_135("135"),
      @SerializedName("136")
      VALUE_136("136"),
      @SerializedName("137")
      VALUE_137("137"),
      @SerializedName("138")
      VALUE_138("138"),
      @SerializedName("139")
      VALUE_139("139"),
      @SerializedName("140")
      VALUE_140("140"),
      @SerializedName("141")
      VALUE_141("141"),
      @SerializedName("142")
      VALUE_142("142"),
      @SerializedName("143")
      VALUE_143("143"),
      @SerializedName("144")
      VALUE_144("144"),
      @SerializedName("145")
      VALUE_145("145"),
      @SerializedName("146")
      VALUE_146("146"),
      @SerializedName("147")
      VALUE_147("147"),
      @SerializedName("148")
      VALUE_148("148"),
      @SerializedName("149")
      VALUE_149("149"),
      @SerializedName("150")
      VALUE_150("150"),
      @SerializedName("151")
      VALUE_151("151"),
      @SerializedName("152")
      VALUE_152("152"),
      @SerializedName("153")
      VALUE_153("153"),
      @SerializedName("154")
      VALUE_154("154"),
      @SerializedName("155")
      VALUE_155("155"),
      @SerializedName("156")
      VALUE_156("156"),
      @SerializedName("157")
      VALUE_157("157"),
      @SerializedName("158")
      VALUE_158("158"),
      @SerializedName("159")
      VALUE_159("159"),
      @SerializedName("160")
      VALUE_160("160"),
      @SerializedName("161")
      VALUE_161("161"),
      @SerializedName("162")
      VALUE_162("162"),
      @SerializedName("163")
      VALUE_163("163"),
      @SerializedName("164")
      VALUE_164("164"),
      @SerializedName("165")
      VALUE_165("165"),
      @SerializedName("166")
      VALUE_166("166"),
      @SerializedName("167")
      VALUE_167("167"),
      @SerializedName("168")
      VALUE_168("168"),
      @SerializedName("169")
      VALUE_169("169"),
      @SerializedName("170")
      VALUE_170("170"),
      @SerializedName("171")
      VALUE_171("171"),
      @SerializedName("172")
      VALUE_172("172"),
      @SerializedName("173")
      VALUE_173("173"),
      @SerializedName("174")
      VALUE_174("174"),
      @SerializedName("175")
      VALUE_175("175"),
      @SerializedName("176")
      VALUE_176("176"),
      @SerializedName("177")
      VALUE_177("177"),
      @SerializedName("178")
      VALUE_178("178"),
      @SerializedName("179")
      VALUE_179("179"),
      @SerializedName("180")
      VALUE_180("180"),
      @SerializedName("181")
      VALUE_181("181"),
      @SerializedName("182")
      VALUE_182("182"),
      @SerializedName("183")
      VALUE_183("183"),
      @SerializedName("184")
      VALUE_184("184"),
      @SerializedName("185")
      VALUE_185("185"),
      @SerializedName("186")
      VALUE_186("186"),
      @SerializedName("187")
      VALUE_187("187"),
      @SerializedName("188")
      VALUE_188("188"),
      @SerializedName("189")
      VALUE_189("189"),
      @SerializedName("190")
      VALUE_190("190"),
      @SerializedName("191")
      VALUE_191("191"),
      @SerializedName("192")
      VALUE_192("192"),
      @SerializedName("193")
      VALUE_193("193"),
      @SerializedName("194")
      VALUE_194("194"),
      @SerializedName("195")
      VALUE_195("195"),
      @SerializedName("196")
      VALUE_196("196"),
      @SerializedName("197")
      VALUE_197("197"),
      @SerializedName("198")
      VALUE_198("198"),
      @SerializedName("199")
      VALUE_199("199"),
      @SerializedName("200")
      VALUE_200("200"),
      @SerializedName("201")
      VALUE_201("201"),
      @SerializedName("202")
      VALUE_202("202"),
      @SerializedName("203")
      VALUE_203("203"),
      @SerializedName("204")
      VALUE_204("204"),
      @SerializedName("205")
      VALUE_205("205"),
      @SerializedName("206")
      VALUE_206("206"),
      @SerializedName("207")
      VALUE_207("207"),
      @SerializedName("208")
      VALUE_208("208"),
      @SerializedName("209")
      VALUE_209("209"),
      @SerializedName("210")
      VALUE_210("210"),
      @SerializedName("211")
      VALUE_211("211"),
      @SerializedName("212")
      VALUE_212("212"),
      @SerializedName("213")
      VALUE_213("213"),
      @SerializedName("214")
      VALUE_214("214"),
      @SerializedName("215")
      VALUE_215("215"),
      @SerializedName("216")
      VALUE_216("216"),
      @SerializedName("217")
      VALUE_217("217"),
      @SerializedName("218")
      VALUE_218("218"),
      @SerializedName("219")
      VALUE_219("219"),
      @SerializedName("220")
      VALUE_220("220"),
      @SerializedName("221")
      VALUE_221("221"),
      @SerializedName("222")
      VALUE_222("222"),
      @SerializedName("223")
      VALUE_223("223"),
      @SerializedName("224")
      VALUE_224("224"),
      @SerializedName("225")
      VALUE_225("225"),
      @SerializedName("226")
      VALUE_226("226"),
      @SerializedName("227")
      VALUE_227("227"),
      @SerializedName("228")
      VALUE_228("228"),
      @SerializedName("229")
      VALUE_229("229"),
      @SerializedName("230")
      VALUE_230("230"),
      @SerializedName("231")
      VALUE_231("231"),
      @SerializedName("232")
      VALUE_232("232"),
      @SerializedName("233")
      VALUE_233("233"),
      @SerializedName("234")
      VALUE_234("234"),
      @SerializedName("235")
      VALUE_235("235"),
      @SerializedName("236")
      VALUE_236("236"),
      @SerializedName("237")
      VALUE_237("237"),
      @SerializedName("238")
      VALUE_238("238"),
      @SerializedName("239")
      VALUE_239("239"),
      @SerializedName("240")
      VALUE_240("240"),
      @SerializedName("241")
      VALUE_241("241"),
      @SerializedName("242")
      VALUE_242("242"),
      @SerializedName("243")
      VALUE_243("243"),
      @SerializedName("244")
      VALUE_244("244"),
      @SerializedName("245")
      VALUE_245("245"),
      @SerializedName("246")
      VALUE_246("246"),
      @SerializedName("247")
      VALUE_247("247"),
      @SerializedName("248")
      VALUE_248("248"),
      @SerializedName("249")
      VALUE_249("249"),
      @SerializedName("250")
      VALUE_250("250"),
      @SerializedName("251")
      VALUE_251("251"),
      @SerializedName("252")
      VALUE_252("252"),
      @SerializedName("253")
      VALUE_253("253"),
      @SerializedName("254")
      VALUE_254("254"),
      @SerializedName("255")
      VALUE_255("255"),
      @SerializedName("256")
      VALUE_256("256"),
      @SerializedName("257")
      VALUE_257("257"),
      @SerializedName("258")
      VALUE_258("258"),
      @SerializedName("259")
      VALUE_259("259"),
      @SerializedName("260")
      VALUE_260("260"),
      @SerializedName("261")
      VALUE_261("261"),
      @SerializedName("262")
      VALUE_262("262"),
      @SerializedName("263")
      VALUE_263("263"),
      @SerializedName("264")
      VALUE_264("264"),
      @SerializedName("265")
      VALUE_265("265"),
      @SerializedName("266")
      VALUE_266("266"),
      @SerializedName("267")
      VALUE_267("267"),
      @SerializedName("268")
      VALUE_268("268"),
      @SerializedName("269")
      VALUE_269("269"),
      @SerializedName("270")
      VALUE_270("270"),
      @SerializedName("271")
      VALUE_271("271"),
      @SerializedName("272")
      VALUE_272("272"),
      @SerializedName("273")
      VALUE_273("273"),
      @SerializedName("274")
      VALUE_274("274"),
      @SerializedName("275")
      VALUE_275("275"),
      @SerializedName("276")
      VALUE_276("276"),
      @SerializedName("277")
      VALUE_277("277"),
      @SerializedName("278")
      VALUE_278("278"),
      @SerializedName("279")
      VALUE_279("279"),
      @SerializedName("280")
      VALUE_280("280"),
      @SerializedName("281")
      VALUE_281("281"),
      @SerializedName("282")
      VALUE_282("282"),
      @SerializedName("283")
      VALUE_283("283"),
      @SerializedName("284")
      VALUE_284("284"),
      @SerializedName("285")
      VALUE_285("285"),
      @SerializedName("286")
      VALUE_286("286"),
      @SerializedName("287")
      VALUE_287("287"),
      @SerializedName("288")
      VALUE_288("288"),
      @SerializedName("289")
      VALUE_289("289"),
      @SerializedName("290")
      VALUE_290("290"),
      @SerializedName("291")
      VALUE_291("291"),
      @SerializedName("292")
      VALUE_292("292"),
      @SerializedName("293")
      VALUE_293("293"),
      @SerializedName("294")
      VALUE_294("294"),
      @SerializedName("295")
      VALUE_295("295"),
      @SerializedName("296")
      VALUE_296("296"),
      @SerializedName("297")
      VALUE_297("297"),
      @SerializedName("298")
      VALUE_298("298"),
      @SerializedName("299")
      VALUE_299("299"),
      @SerializedName("300")
      VALUE_300("300"),
      @SerializedName("301")
      VALUE_301("301"),
      @SerializedName("302")
      VALUE_302("302"),
      @SerializedName("303")
      VALUE_303("303"),
      @SerializedName("304")
      VALUE_304("304"),
      @SerializedName("305")
      VALUE_305("305"),
      @SerializedName("306")
      VALUE_306("306"),
      @SerializedName("307")
      VALUE_307("307"),
      @SerializedName("308")
      VALUE_308("308"),
      @SerializedName("309")
      VALUE_309("309"),
      @SerializedName("310")
      VALUE_310("310"),
      @SerializedName("311")
      VALUE_311("311"),
      @SerializedName("312")
      VALUE_312("312"),
      @SerializedName("313")
      VALUE_313("313"),
      @SerializedName("314")
      VALUE_314("314"),
      @SerializedName("315")
      VALUE_315("315"),
      @SerializedName("316")
      VALUE_316("316"),
      @SerializedName("317")
      VALUE_317("317"),
      @SerializedName("318")
      VALUE_318("318"),
      @SerializedName("319")
      VALUE_319("319"),
      @SerializedName("320")
      VALUE_320("320"),
      @SerializedName("321")
      VALUE_321("321"),
      @SerializedName("322")
      VALUE_322("322"),
      @SerializedName("323")
      VALUE_323("323"),
      @SerializedName("324")
      VALUE_324("324"),
      @SerializedName("325")
      VALUE_325("325"),
      @SerializedName("326")
      VALUE_326("326"),
      @SerializedName("327")
      VALUE_327("327"),
      @SerializedName("328")
      VALUE_328("328"),
      @SerializedName("329")
      VALUE_329("329"),
      @SerializedName("330")
      VALUE_330("330"),
      @SerializedName("331")
      VALUE_331("331"),
      @SerializedName("332")
      VALUE_332("332"),
      @SerializedName("333")
      VALUE_333("333"),
      @SerializedName("334")
      VALUE_334("334"),
      @SerializedName("335")
      VALUE_335("335"),
      @SerializedName("336")
      VALUE_336("336"),
      @SerializedName("337")
      VALUE_337("337"),
      @SerializedName("338")
      VALUE_338("338"),
      @SerializedName("339")
      VALUE_339("339"),
      @SerializedName("340")
      VALUE_340("340"),
      @SerializedName("341")
      VALUE_341("341"),
      @SerializedName("342")
      VALUE_342("342"),
      @SerializedName("343")
      VALUE_343("343"),
      @SerializedName("344")
      VALUE_344("344"),
      @SerializedName("345")
      VALUE_345("345"),
      @SerializedName("346")
      VALUE_346("346"),
      @SerializedName("347")
      VALUE_347("347"),
      @SerializedName("348")
      VALUE_348("348"),
      @SerializedName("349")
      VALUE_349("349"),
      @SerializedName("350")
      VALUE_350("350"),
      @SerializedName("351")
      VALUE_351("351"),
      @SerializedName("352")
      VALUE_352("352"),
      @SerializedName("353")
      VALUE_353("353"),
      @SerializedName("354")
      VALUE_354("354"),
      @SerializedName("355")
      VALUE_355("355"),
      @SerializedName("356")
      VALUE_356("356"),
      @SerializedName("357")
      VALUE_357("357"),
      @SerializedName("358")
      VALUE_358("358"),
      @SerializedName("359")
      VALUE_359("359"),
      @SerializedName("360")
      VALUE_360("360"),
      @SerializedName("361")
      VALUE_361("361"),
      @SerializedName("362")
      VALUE_362("362"),
      @SerializedName("363")
      VALUE_363("363"),
      @SerializedName("364")
      VALUE_364("364"),
      @SerializedName("365")
      VALUE_365("365"),
      @SerializedName("366")
      VALUE_366("366"),
      @SerializedName("367")
      VALUE_367("367"),
      @SerializedName("368")
      VALUE_368("368"),
      @SerializedName("369")
      VALUE_369("369"),
      @SerializedName("370")
      VALUE_370("370"),
      @SerializedName("371")
      VALUE_371("371"),
      @SerializedName("372")
      VALUE_372("372"),
      @SerializedName("373")
      VALUE_373("373"),
      @SerializedName("374")
      VALUE_374("374"),
      @SerializedName("375")
      VALUE_375("375"),
      @SerializedName("376")
      VALUE_376("376"),
      @SerializedName("377")
      VALUE_377("377"),
      @SerializedName("378")
      VALUE_378("378"),
      @SerializedName("379")
      VALUE_379("379"),
      @SerializedName("380")
      VALUE_380("380"),
      @SerializedName("381")
      VALUE_381("381"),
      @SerializedName("382")
      VALUE_382("382"),
      @SerializedName("383")
      VALUE_383("383"),
      @SerializedName("384")
      VALUE_384("384"),
      @SerializedName("385")
      VALUE_385("385"),
      @SerializedName("386")
      VALUE_386("386"),
      @SerializedName("387")
      VALUE_387("387"),
      @SerializedName("388")
      VALUE_388("388"),
      @SerializedName("389")
      VALUE_389("389"),
      @SerializedName("390")
      VALUE_390("390"),
      @SerializedName("391")
      VALUE_391("391"),
      @SerializedName("392")
      VALUE_392("392"),
      @SerializedName("393")
      VALUE_393("393"),
      @SerializedName("394")
      VALUE_394("394"),
      @SerializedName("395")
      VALUE_395("395"),
      @SerializedName("396")
      VALUE_396("396"),
      @SerializedName("397")
      VALUE_397("397"),
      @SerializedName("398")
      VALUE_398("398"),
      @SerializedName("399")
      VALUE_399("399"),
      @SerializedName("400")
      VALUE_400("400"),
      @SerializedName("401")
      VALUE_401("401"),
      @SerializedName("402")
      VALUE_402("402"),
      @SerializedName("403")
      VALUE_403("403"),
      @SerializedName("404")
      VALUE_404("404"),
      @SerializedName("405")
      VALUE_405("405"),
      @SerializedName("406")
      VALUE_406("406"),
      @SerializedName("407")
      VALUE_407("407"),
      @SerializedName("408")
      VALUE_408("408"),
      @SerializedName("409")
      VALUE_409("409"),
      @SerializedName("410")
      VALUE_410("410"),
      @SerializedName("411")
      VALUE_411("411"),
      @SerializedName("412")
      VALUE_412("412"),
      @SerializedName("413")
      VALUE_413("413"),
      @SerializedName("414")
      VALUE_414("414"),
      @SerializedName("415")
      VALUE_415("415"),
      @SerializedName("416")
      VALUE_416("416"),
      @SerializedName("417")
      VALUE_417("417"),
      @SerializedName("418")
      VALUE_418("418"),
      @SerializedName("419")
      VALUE_419("419"),
      @SerializedName("420")
      VALUE_420("420"),
      @SerializedName("421")
      VALUE_421("421"),
      @SerializedName("422")
      VALUE_422("422"),
      @SerializedName("423")
      VALUE_423("423"),
      @SerializedName("424")
      VALUE_424("424"),
      @SerializedName("425")
      VALUE_425("425"),
      @SerializedName("426")
      VALUE_426("426"),
      @SerializedName("427")
      VALUE_427("427"),
      @SerializedName("428")
      VALUE_428("428"),
      @SerializedName("429")
      VALUE_429("429"),
      @SerializedName("430")
      VALUE_430("430"),
      @SerializedName("431")
      VALUE_431("431"),
      @SerializedName("432")
      VALUE_432("432"),
      @SerializedName("433")
      VALUE_433("433"),
      @SerializedName("434")
      VALUE_434("434"),
      @SerializedName("435")
      VALUE_435("435"),
      @SerializedName("436")
      VALUE_436("436"),
      @SerializedName("437")
      VALUE_437("437"),
      @SerializedName("438")
      VALUE_438("438"),
      @SerializedName("439")
      VALUE_439("439"),
      @SerializedName("440")
      VALUE_440("440"),
      @SerializedName("441")
      VALUE_441("441"),
      @SerializedName("442")
      VALUE_442("442"),
      @SerializedName("443")
      VALUE_443("443"),
      @SerializedName("444")
      VALUE_444("444"),
      @SerializedName("445")
      VALUE_445("445"),
      @SerializedName("446")
      VALUE_446("446"),
      @SerializedName("447")
      VALUE_447("447"),
      @SerializedName("448")
      VALUE_448("448"),
      @SerializedName("449")
      VALUE_449("449"),
      @SerializedName("450")
      VALUE_450("450"),
      @SerializedName("451")
      VALUE_451("451"),
      @SerializedName("452")
      VALUE_452("452"),
      @SerializedName("453")
      VALUE_453("453"),
      @SerializedName("454")
      VALUE_454("454"),
      @SerializedName("455")
      VALUE_455("455"),
      @SerializedName("456")
      VALUE_456("456"),
      @SerializedName("457")
      VALUE_457("457"),
      @SerializedName("458")
      VALUE_458("458"),
      @SerializedName("459")
      VALUE_459("459"),
      @SerializedName("460")
      VALUE_460("460"),
      @SerializedName("461")
      VALUE_461("461"),
      @SerializedName("462")
      VALUE_462("462"),
      @SerializedName("463")
      VALUE_463("463"),
      @SerializedName("464")
      VALUE_464("464"),
      @SerializedName("465")
      VALUE_465("465"),
      @SerializedName("466")
      VALUE_466("466"),
      @SerializedName("467")
      VALUE_467("467"),
      @SerializedName("468")
      VALUE_468("468"),
      @SerializedName("469")
      VALUE_469("469"),
      @SerializedName("470")
      VALUE_470("470"),
      @SerializedName("471")
      VALUE_471("471"),
      @SerializedName("472")
      VALUE_472("472"),
      @SerializedName("473")
      VALUE_473("473"),
      @SerializedName("474")
      VALUE_474("474"),
      @SerializedName("475")
      VALUE_475("475"),
      @SerializedName("476")
      VALUE_476("476"),
      @SerializedName("477")
      VALUE_477("477"),
      @SerializedName("478")
      VALUE_478("478"),
      @SerializedName("479")
      VALUE_479("479"),
      @SerializedName("480")
      VALUE_480("480"),
      ;

      private String value;

      private EnumTimezoneId(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPagePermittedTasks {
      @SerializedName("ADVERTISE")
      VALUE_ADVERTISE("ADVERTISE"),
      @SerializedName("ANALYZE")
      VALUE_ANALYZE("ANALYZE"),
      @SerializedName("CASHIER_ROLE")
      VALUE_CASHIER_ROLE("CASHIER_ROLE"),
      @SerializedName("CREATE_CONTENT")
      VALUE_CREATE_CONTENT("CREATE_CONTENT"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_JOBS")
      VALUE_MANAGE_JOBS("MANAGE_JOBS"),
      @SerializedName("MANAGE_LEADS")
      VALUE_MANAGE_LEADS("MANAGE_LEADS"),
      @SerializedName("MESSAGING")
      VALUE_MESSAGING("MESSAGING"),
      @SerializedName("MODERATE")
      VALUE_MODERATE("MODERATE"),
      @SerializedName("MODERATE_COMMUNITY")
      VALUE_MODERATE_COMMUNITY("MODERATE_COMMUNITY"),
      @SerializedName("PAGES_MESSAGING")
      VALUE_PAGES_MESSAGING("PAGES_MESSAGING"),
      @SerializedName("PAGES_MESSAGING_SUBSCRIPTIONS")
      VALUE_PAGES_MESSAGING_SUBSCRIPTIONS("PAGES_MESSAGING_SUBSCRIPTIONS"),
      @SerializedName("PROFILE_PLUS_ADVERTISE")
      VALUE_PROFILE_PLUS_ADVERTISE("PROFILE_PLUS_ADVERTISE"),
      @SerializedName("PROFILE_PLUS_ANALYZE")
      VALUE_PROFILE_PLUS_ANALYZE("PROFILE_PLUS_ANALYZE"),
      @SerializedName("PROFILE_PLUS_CREATE_CONTENT")
      VALUE_PROFILE_PLUS_CREATE_CONTENT("PROFILE_PLUS_CREATE_CONTENT"),
      @SerializedName("PROFILE_PLUS_FACEBOOK_ACCESS")
      VALUE_PROFILE_PLUS_FACEBOOK_ACCESS("PROFILE_PLUS_FACEBOOK_ACCESS"),
      @SerializedName("PROFILE_PLUS_FULL_CONTROL")
      VALUE_PROFILE_PLUS_FULL_CONTROL("PROFILE_PLUS_FULL_CONTROL"),
      @SerializedName("PROFILE_PLUS_MANAGE")
      VALUE_PROFILE_PLUS_MANAGE("PROFILE_PLUS_MANAGE"),
      @SerializedName("PROFILE_PLUS_MANAGE_LEADS")
      VALUE_PROFILE_PLUS_MANAGE_LEADS("PROFILE_PLUS_MANAGE_LEADS"),
      @SerializedName("PROFILE_PLUS_MESSAGING")
      VALUE_PROFILE_PLUS_MESSAGING("PROFILE_PLUS_MESSAGING"),
      @SerializedName("PROFILE_PLUS_MODERATE")
      VALUE_PROFILE_PLUS_MODERATE("PROFILE_PLUS_MODERATE"),
      @SerializedName("PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY")
      VALUE_PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY("PROFILE_PLUS_MODERATE_DELEGATE_COMMUNITY"),
      @SerializedName("PROFILE_PLUS_REVENUE")
      VALUE_PROFILE_PLUS_REVENUE("PROFILE_PLUS_REVENUE"),
      @SerializedName("READ_PAGE_MAILBOXES")
      VALUE_READ_PAGE_MAILBOXES("READ_PAGE_MAILBOXES"),
      @SerializedName("VIEW_MONETIZATION_INSIGHTS")
      VALUE_VIEW_MONETIZATION_INSIGHTS("VIEW_MONETIZATION_INSIGHTS"),
      ;

      private String value;

      private EnumPagePermittedTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSubverticalV2 {
      @SerializedName("ACCOUNTING_AND_TAX")
      VALUE_ACCOUNTING_AND_TAX("ACCOUNTING_AND_TAX"),
      @SerializedName("ACTIVITIES_AND_LEISURE")
      VALUE_ACTIVITIES_AND_LEISURE("ACTIVITIES_AND_LEISURE"),
      @SerializedName("AIR")
      VALUE_AIR("AIR"),
      @SerializedName("APPAREL_AND_ACCESSORIES")
      VALUE_APPAREL_AND_ACCESSORIES("APPAREL_AND_ACCESSORIES"),
      @SerializedName("ARTS_AND_HERITAGE_AND_EDUCATION")
      VALUE_ARTS_AND_HERITAGE_AND_EDUCATION("ARTS_AND_HERITAGE_AND_EDUCATION"),
      @SerializedName("AR_OR_VR_GAMING")
      VALUE_AR_OR_VR_GAMING("AR_OR_VR_GAMING"),
      @SerializedName("AUDIO_STREAMING")
      VALUE_AUDIO_STREAMING("AUDIO_STREAMING"),
      @SerializedName("AUTO")
      VALUE_AUTO("AUTO"),
      @SerializedName("AUTO_INSURANCE")
      VALUE_AUTO_INSURANCE("AUTO_INSURANCE"),
      @SerializedName("AUTO_RENTAL")
      VALUE_AUTO_RENTAL("AUTO_RENTAL"),
      @SerializedName("BABY")
      VALUE_BABY("BABY"),
      @SerializedName("BALLOT_INITIATIVE_OR_REFERENDUM")
      VALUE_BALLOT_INITIATIVE_OR_REFERENDUM("BALLOT_INITIATIVE_OR_REFERENDUM"),
      @SerializedName("BEAUTY")
      VALUE_BEAUTY("BEAUTY"),
      @SerializedName("BEAUTY_AND_FASHION")
      VALUE_BEAUTY_AND_FASHION("BEAUTY_AND_FASHION"),
      @SerializedName("BEER_AND_WINE_AND_LIQUOR_AND_MALT_BEVERAGES")
      VALUE_BEER_AND_WINE_AND_LIQUOR_AND_MALT_BEVERAGES("BEER_AND_WINE_AND_LIQUOR_AND_MALT_BEVERAGES"),
      @SerializedName("BOOKSTORES")
      VALUE_BOOKSTORES("BOOKSTORES"),
      @SerializedName("BROADCAST_TELEVISION")
      VALUE_BROADCAST_TELEVISION("BROADCAST_TELEVISION"),
      @SerializedName("BUSINESS_CONSULTANTS")
      VALUE_BUSINESS_CONSULTANTS("BUSINESS_CONSULTANTS"),
      @SerializedName("BUYING_AGENCY")
      VALUE_BUYING_AGENCY("BUYING_AGENCY"),
      @SerializedName("CABLE_AND_SATELLITE")
      VALUE_CABLE_AND_SATELLITE("CABLE_AND_SATELLITE"),
      @SerializedName("CABLE_TELEVISION")
      VALUE_CABLE_TELEVISION("CABLE_TELEVISION"),
      @SerializedName("CALL_CENTER_AND_MESSAGING_SERVICES")
      VALUE_CALL_CENTER_AND_MESSAGING_SERVICES("CALL_CENTER_AND_MESSAGING_SERVICES"),
      @SerializedName("CANDIDATE_OR_POLITICIAN")
      VALUE_CANDIDATE_OR_POLITICIAN("CANDIDATE_OR_POLITICIAN"),
      @SerializedName("CAREER")
      VALUE_CAREER("CAREER"),
      @SerializedName("CAREER_AND_TECH")
      VALUE_CAREER_AND_TECH("CAREER_AND_TECH"),
      @SerializedName("CASUAL_DINING")
      VALUE_CASUAL_DINING("CASUAL_DINING"),
      @SerializedName("CHRONIC_CONDITIONS_AND_MEDICAL_CAUSES")
      VALUE_CHRONIC_CONDITIONS_AND_MEDICAL_CAUSES("CHRONIC_CONDITIONS_AND_MEDICAL_CAUSES"),
      @SerializedName("CIVIC_INFLUENCERS")
      VALUE_CIVIC_INFLUENCERS("CIVIC_INFLUENCERS"),
      @SerializedName("CLINICAL_TRIALS")
      VALUE_CLINICAL_TRIALS("CLINICAL_TRIALS"),
      @SerializedName("COFFEE")
      VALUE_COFFEE("COFFEE"),
      @SerializedName("COMPUTER_AND_SOFTWARE_AND_HARDWARE")
      VALUE_COMPUTER_AND_SOFTWARE_AND_HARDWARE("COMPUTER_AND_SOFTWARE_AND_HARDWARE"),
      @SerializedName("CONSOLE_AND_CROSS_PLATFORM_GAMING")
      VALUE_CONSOLE_AND_CROSS_PLATFORM_GAMING("CONSOLE_AND_CROSS_PLATFORM_GAMING"),
      @SerializedName("CONSULTING")
      VALUE_CONSULTING("CONSULTING"),
      @SerializedName("CONSUMER_ELECTRONICS")
      VALUE_CONSUMER_ELECTRONICS("CONSUMER_ELECTRONICS"),
      @SerializedName("COUNSELING_AND_PSYCHOTHERAPY")
      VALUE_COUNSELING_AND_PSYCHOTHERAPY("COUNSELING_AND_PSYCHOTHERAPY"),
      @SerializedName("CREATIVE_AGENCY")
      VALUE_CREATIVE_AGENCY("CREATIVE_AGENCY"),
      @SerializedName("CREDIT_AND_FINANCING_AND_MORTAGES")
      VALUE_CREDIT_AND_FINANCING_AND_MORTAGES("CREDIT_AND_FINANCING_AND_MORTAGES"),
      @SerializedName("CRUISES_AND_MARINE")
      VALUE_CRUISES_AND_MARINE("CRUISES_AND_MARINE"),
      @SerializedName("CULTURE_AND_LIFESTYLE")
      VALUE_CULTURE_AND_LIFESTYLE("CULTURE_AND_LIFESTYLE"),
      @SerializedName("DATA_ANALYTICS_AND_DATA_MANAGEMENT")
      VALUE_DATA_ANALYTICS_AND_DATA_MANAGEMENT("DATA_ANALYTICS_AND_DATA_MANAGEMENT"),
      @SerializedName("DATING_AND_TECHNOLOGY_APPS")
      VALUE_DATING_AND_TECHNOLOGY_APPS("DATING_AND_TECHNOLOGY_APPS"),
      @SerializedName("DEPARTMENT_STORE")
      VALUE_DEPARTMENT_STORE("DEPARTMENT_STORE"),
      @SerializedName("DESKTOP_SOFTWARE")
      VALUE_DESKTOP_SOFTWARE("DESKTOP_SOFTWARE"),
      @SerializedName("DIETING_AND_FITNESS_PROGRAMS")
      VALUE_DIETING_AND_FITNESS_PROGRAMS("DIETING_AND_FITNESS_PROGRAMS"),
      @SerializedName("DIGITAL_NATIVE_EDUCATION_OR_TRAINING")
      VALUE_DIGITAL_NATIVE_EDUCATION_OR_TRAINING("DIGITAL_NATIVE_EDUCATION_OR_TRAINING"),
      @SerializedName("DRINKING_PLACES")
      VALUE_DRINKING_PLACES("DRINKING_PLACES"),
      @SerializedName("EDUCATION_RESOURCES")
      VALUE_EDUCATION_RESOURCES("EDUCATION_RESOURCES"),
      @SerializedName("ED_TECH")
      VALUE_ED_TECH("ED_TECH"),
      @SerializedName("ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES")
      VALUE_ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES("ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES"),
      @SerializedName("ELECTION_COMMISSION")
      VALUE_ELECTION_COMMISSION("ELECTION_COMMISSION"),
      @SerializedName("ELECTRONICS_AND_APPLIANCES")
      VALUE_ELECTRONICS_AND_APPLIANCES("ELECTRONICS_AND_APPLIANCES"),
      @SerializedName("ENGINEERING_AND_DESIGN")
      VALUE_ENGINEERING_AND_DESIGN("ENGINEERING_AND_DESIGN"),
      @SerializedName("ENVIRONMENT_AND_ANIMAL_WELFARE")
      VALUE_ENVIRONMENT_AND_ANIMAL_WELFARE("ENVIRONMENT_AND_ANIMAL_WELFARE"),
      @SerializedName("ESPORTS")
      VALUE_ESPORTS("ESPORTS"),
      @SerializedName("EVENTS")
      VALUE_EVENTS("EVENTS"),
      @SerializedName("FARMING_AND_RANCHING")
      VALUE_FARMING_AND_RANCHING("FARMING_AND_RANCHING"),
      @SerializedName("FILE_STORAGE_AND_CLOUD_AND_DATA_SERVICES")
      VALUE_FILE_STORAGE_AND_CLOUD_AND_DATA_SERVICES("FILE_STORAGE_AND_CLOUD_AND_DATA_SERVICES"),
      @SerializedName("FINANCE")
      VALUE_FINANCE("FINANCE"),
      @SerializedName("FIN_TECH")
      VALUE_FIN_TECH("FIN_TECH"),
      @SerializedName("FISHING_AND_HUNTING_AND_FORESTRY_AND_LOGGING")
      VALUE_FISHING_AND_HUNTING_AND_FORESTRY_AND_LOGGING("FISHING_AND_HUNTING_AND_FORESTRY_AND_LOGGING"),
      @SerializedName("FITNESS")
      VALUE_FITNESS("FITNESS"),
      @SerializedName("FOOD")
      VALUE_FOOD("FOOD"),
      @SerializedName("FOOTWEAR")
      VALUE_FOOTWEAR("FOOTWEAR"),
      @SerializedName("FOR_PROFIT_COLLEGES_AND_UNIVERSITIES")
      VALUE_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES("FOR_PROFIT_COLLEGES_AND_UNIVERSITIES"),
      @SerializedName("FULL_SERVICE_AGENCY")
      VALUE_FULL_SERVICE_AGENCY("FULL_SERVICE_AGENCY"),
      @SerializedName("GOVERNMENT_CONTROLLED_ENTITY")
      VALUE_GOVERNMENT_CONTROLLED_ENTITY("GOVERNMENT_CONTROLLED_ENTITY"),
      @SerializedName("GOVERNMENT_DEPARTMENT_OR_AGENCY")
      VALUE_GOVERNMENT_DEPARTMENT_OR_AGENCY("GOVERNMENT_DEPARTMENT_OR_AGENCY"),
      @SerializedName("GOVERNMENT_OFFICIAL")
      VALUE_GOVERNMENT_OFFICIAL("GOVERNMENT_OFFICIAL"),
      @SerializedName("GOVERNMENT_OWNED_MEDIA")
      VALUE_GOVERNMENT_OWNED_MEDIA("GOVERNMENT_OWNED_MEDIA"),
      @SerializedName("GROCERY_AND_DRUG_AND_CONVENIENCE")
      VALUE_GROCERY_AND_DRUG_AND_CONVENIENCE("GROCERY_AND_DRUG_AND_CONVENIENCE"),
      @SerializedName("HEAD_OF_STATE")
      VALUE_HEAD_OF_STATE("HEAD_OF_STATE"),
      @SerializedName("HEALTH_INSURANCE")
      VALUE_HEALTH_INSURANCE("HEALTH_INSURANCE"),
      @SerializedName("HEALTH_SYSTEMS_AND_PRACTITIONERS")
      VALUE_HEALTH_SYSTEMS_AND_PRACTITIONERS("HEALTH_SYSTEMS_AND_PRACTITIONERS"),
      @SerializedName("HEALTH_TECH")
      VALUE_HEALTH_TECH("HEALTH_TECH"),
      @SerializedName("HOME_AND_FURNITURE_AND_OFFICE")
      VALUE_HOME_AND_FURNITURE_AND_OFFICE("HOME_AND_FURNITURE_AND_OFFICE"),
      @SerializedName("HOME_IMPROVEMENT")
      VALUE_HOME_IMPROVEMENT("HOME_IMPROVEMENT"),
      @SerializedName("HOME_INSURANCE")
      VALUE_HOME_INSURANCE("HOME_INSURANCE"),
      @SerializedName("HOME_TECH")
      VALUE_HOME_TECH("HOME_TECH"),
      @SerializedName("HOTEL_AND_ACCOMODATION")
      VALUE_HOTEL_AND_ACCOMODATION("HOTEL_AND_ACCOMODATION"),
      @SerializedName("HOUSEHOLD_GOODS_DURABLE")
      VALUE_HOUSEHOLD_GOODS_DURABLE("HOUSEHOLD_GOODS_DURABLE"),
      @SerializedName("HOUSEHOLD_GOODS_NON_DURABLE")
      VALUE_HOUSEHOLD_GOODS_NON_DURABLE("HOUSEHOLD_GOODS_NON_DURABLE"),
      @SerializedName("HR_AND_FINANCIAL_MANAGEMENT")
      VALUE_HR_AND_FINANCIAL_MANAGEMENT("HR_AND_FINANCIAL_MANAGEMENT"),
      @SerializedName("HUMANITARIAN_OR_DISASTER_RELIEF")
      VALUE_HUMANITARIAN_OR_DISASTER_RELIEF("HUMANITARIAN_OR_DISASTER_RELIEF"),
      @SerializedName("INDEPENDENT_EXPENDITURE_GROUP")
      VALUE_INDEPENDENT_EXPENDITURE_GROUP("INDEPENDENT_EXPENDITURE_GROUP"),
      @SerializedName("INSURANCE_TECH")
      VALUE_INSURANCE_TECH("INSURANCE_TECH"),
      @SerializedName("INTERNATIONAL_ORGANIZATON")
      VALUE_INTERNATIONAL_ORGANIZATON("INTERNATIONAL_ORGANIZATON"),
      @SerializedName("INVESTMENT_BANK_AND_BROKERAGE")
      VALUE_INVESTMENT_BANK_AND_BROKERAGE("INVESTMENT_BANK_AND_BROKERAGE"),
      @SerializedName("ISSUE_ADVOCACY")
      VALUE_ISSUE_ADVOCACY("ISSUE_ADVOCACY"),
      @SerializedName("LEGAL")
      VALUE_LEGAL("LEGAL"),
      @SerializedName("LIFE_INSURANCE")
      VALUE_LIFE_INSURANCE("LIFE_INSURANCE"),
      @SerializedName("LOGISTICS_AND_TRANSPORTATION_AND_FLEET_MANAGEMENT")
      VALUE_LOGISTICS_AND_TRANSPORTATION_AND_FLEET_MANAGEMENT("LOGISTICS_AND_TRANSPORTATION_AND_FLEET_MANAGEMENT"),
      @SerializedName("MANUFACTURING")
      VALUE_MANUFACTURING("MANUFACTURING"),
      @SerializedName("MEDICAL_DEVICES_AND_SUPPLIES_AND_EQUIPMENT")
      VALUE_MEDICAL_DEVICES_AND_SUPPLIES_AND_EQUIPMENT("MEDICAL_DEVICES_AND_SUPPLIES_AND_EQUIPMENT"),
      @SerializedName("MEDSPA_AND_ELECTIVE_SURGERIES_AND_ALTERNATIVE_MEDICINE")
      VALUE_MEDSPA_AND_ELECTIVE_SURGERIES_AND_ALTERNATIVE_MEDICINE("MEDSPA_AND_ELECTIVE_SURGERIES_AND_ALTERNATIVE_MEDICINE"),
      @SerializedName("MINING_AND_QUARRYING")
      VALUE_MINING_AND_QUARRYING("MINING_AND_QUARRYING"),
      @SerializedName("MOBILE_GAMING")
      VALUE_MOBILE_GAMING("MOBILE_GAMING"),
      @SerializedName("MOVIES")
      VALUE_MOVIES("MOVIES"),
      @SerializedName("MUSEUMS_AND_PARKS_AND_LIBRARIES")
      VALUE_MUSEUMS_AND_PARKS_AND_LIBRARIES("MUSEUMS_AND_PARKS_AND_LIBRARIES"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NETWORK_SECURITY_PRODUCTS")
      VALUE_NETWORK_SECURITY_PRODUCTS("NETWORK_SECURITY_PRODUCTS"),
      @SerializedName("NEWS_AND_CURRENT_EVENTS")
      VALUE_NEWS_AND_CURRENT_EVENTS("NEWS_AND_CURRENT_EVENTS"),
      @SerializedName("NON_PRESCRIPTION")
      VALUE_NON_PRESCRIPTION("NON_PRESCRIPTION"),
      @SerializedName("NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES")
      VALUE_NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES("NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES"),
      @SerializedName("OFFICE")
      VALUE_OFFICE("OFFICE"),
      @SerializedName("OFFICE_OR_BUSINESS_SUPPLIES")
      VALUE_OFFICE_OR_BUSINESS_SUPPLIES("OFFICE_OR_BUSINESS_SUPPLIES"),
      @SerializedName("OIL_AND_GAS_AND_CONSUMABLE_FUEL")
      VALUE_OIL_AND_GAS_AND_CONSUMABLE_FUEL("OIL_AND_GAS_AND_CONSUMABLE_FUEL"),
      @SerializedName("ONLINE_ONLY_PUBLICATIONS")
      VALUE_ONLINE_ONLY_PUBLICATIONS("ONLINE_ONLY_PUBLICATIONS"),
      @SerializedName("PACKAGE_OR_FREIGHT_DELIVERY")
      VALUE_PACKAGE_OR_FREIGHT_DELIVERY("PACKAGE_OR_FREIGHT_DELIVERY"),
      @SerializedName("PARTY_INDEPENDENT_EXPENDITURE_GROUP_US")
      VALUE_PARTY_INDEPENDENT_EXPENDITURE_GROUP_US("PARTY_INDEPENDENT_EXPENDITURE_GROUP_US"),
      @SerializedName("PAYMENT_PROCESSING_AND_GATEWAY_SOLUTIONS")
      VALUE_PAYMENT_PROCESSING_AND_GATEWAY_SOLUTIONS("PAYMENT_PROCESSING_AND_GATEWAY_SOLUTIONS"),
      @SerializedName("PC_GAMING")
      VALUE_PC_GAMING("PC_GAMING"),
      @SerializedName("PEOPLE")
      VALUE_PEOPLE("PEOPLE"),
      @SerializedName("PERSONAL_CARE")
      VALUE_PERSONAL_CARE("PERSONAL_CARE"),
      @SerializedName("PET")
      VALUE_PET("PET"),
      @SerializedName("PHOTOGRAPHY_AND_FILMING_SERVICES")
      VALUE_PHOTOGRAPHY_AND_FILMING_SERVICES("PHOTOGRAPHY_AND_FILMING_SERVICES"),
      @SerializedName("PIZZA")
      VALUE_PIZZA("PIZZA"),
      @SerializedName("PLANNING_AGENCY")
      VALUE_PLANNING_AGENCY("PLANNING_AGENCY"),
      @SerializedName("POLITICAL_PARTY_OR_COMMITTEE")
      VALUE_POLITICAL_PARTY_OR_COMMITTEE("POLITICAL_PARTY_OR_COMMITTEE"),
      @SerializedName("PRESCRIPTION")
      VALUE_PRESCRIPTION("PRESCRIPTION"),
      @SerializedName("PROFESSIONAL_ASSOCIATIONS")
      VALUE_PROFESSIONAL_ASSOCIATIONS("PROFESSIONAL_ASSOCIATIONS"),
      @SerializedName("PROPERTY_AND_CASUALTY")
      VALUE_PROPERTY_AND_CASUALTY("PROPERTY_AND_CASUALTY"),
      @SerializedName("QUICK_SERVICE")
      VALUE_QUICK_SERVICE("QUICK_SERVICE"),
      @SerializedName("RADIO")
      VALUE_RADIO("RADIO"),
      @SerializedName("RAILROADS")
      VALUE_RAILROADS("RAILROADS"),
      @SerializedName("REAL_ESTATE")
      VALUE_REAL_ESTATE("REAL_ESTATE"),
      @SerializedName("REAL_MONEY_GAMING")
      VALUE_REAL_MONEY_GAMING("REAL_MONEY_GAMING"),
      @SerializedName("RECREATIONAL")
      VALUE_RECREATIONAL("RECREATIONAL"),
      @SerializedName("RELIGIOUS")
      VALUE_RELIGIOUS("RELIGIOUS"),
      @SerializedName("RESELLER")
      VALUE_RESELLER("RESELLER"),
      @SerializedName("RESIDENTIAL_AND_LONG_TERM_CARE_FACILITIES_AND_OUTPATIENT_CARE_CENTERS")
      VALUE_RESIDENTIAL_AND_LONG_TERM_CARE_FACILITIES_AND_OUTPATIENT_CARE_CENTERS("RESIDENTIAL_AND_LONG_TERM_CARE_FACILITIES_AND_OUTPATIENT_CARE_CENTERS"),
      @SerializedName("RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK")
      VALUE_RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK("RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK"),
      @SerializedName("RIDE_SHARING_OR_TAXI_SERVICES")
      VALUE_RIDE_SHARING_OR_TAXI_SERVICES("RIDE_SHARING_OR_TAXI_SERVICES"),
      @SerializedName("SAFETY_SERVICES")
      VALUE_SAFETY_SERVICES("SAFETY_SERVICES"),
      @SerializedName("SCHOLARLY")
      VALUE_SCHOLARLY("SCHOLARLY"),
      @SerializedName("SCHOOL_AND_EARLY_CHILDREN_EDCATION")
      VALUE_SCHOOL_AND_EARLY_CHILDREN_EDCATION("SCHOOL_AND_EARLY_CHILDREN_EDCATION"),
      @SerializedName("SOCIAL_MEDIA")
      VALUE_SOCIAL_MEDIA("SOCIAL_MEDIA"),
      @SerializedName("SOFTWARE_AS_A_SERVICE")
      VALUE_SOFTWARE_AS_A_SERVICE("SOFTWARE_AS_A_SERVICE"),
      @SerializedName("SPORTING")
      VALUE_SPORTING("SPORTING"),
      @SerializedName("SPORTING_AND_OUTDOOR")
      VALUE_SPORTING_AND_OUTDOOR("SPORTING_AND_OUTDOOR"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("SUPERSTORES")
      VALUE_SUPERSTORES("SUPERSTORES"),
      @SerializedName("T1_AUTOMOTIVE_MANUFACTURER")
      VALUE_T1_AUTOMOTIVE_MANUFACTURER("T1_AUTOMOTIVE_MANUFACTURER"),
      @SerializedName("T1_MOTORCYCLE")
      VALUE_T1_MOTORCYCLE("T1_MOTORCYCLE"),
      @SerializedName("T2_DEALER_ASSOCIATIONS")
      VALUE_T2_DEALER_ASSOCIATIONS("T2_DEALER_ASSOCIATIONS"),
      @SerializedName("T3_AUTO_AGENCY")
      VALUE_T3_AUTO_AGENCY("T3_AUTO_AGENCY"),
      @SerializedName("T3_AUTO_RESELLERS")
      VALUE_T3_AUTO_RESELLERS("T3_AUTO_RESELLERS"),
      @SerializedName("T3_DEALER_GROUPS")
      VALUE_T3_DEALER_GROUPS("T3_DEALER_GROUPS"),
      @SerializedName("T3_FRANCHISE_DEALER")
      VALUE_T3_FRANCHISE_DEALER("T3_FRANCHISE_DEALER"),
      @SerializedName("T3_INDEPENDENT_DEALER")
      VALUE_T3_INDEPENDENT_DEALER("T3_INDEPENDENT_DEALER"),
      @SerializedName("T3_PARTS_AND_SERVICES")
      VALUE_T3_PARTS_AND_SERVICES("T3_PARTS_AND_SERVICES"),
      @SerializedName("T3_PORTALS")
      VALUE_T3_PORTALS("T3_PORTALS"),
      @SerializedName("TELECOMMUNICATIONS_EQUIPMENT_AND_ACCESSORIES")
      VALUE_TELECOMMUNICATIONS_EQUIPMENT_AND_ACCESSORIES("TELECOMMUNICATIONS_EQUIPMENT_AND_ACCESSORIES"),
      @SerializedName("TELEPHONE_SERVICE_PROVIDERS_AND_CARRIERS")
      VALUE_TELEPHONE_SERVICE_PROVIDERS_AND_CARRIERS("TELEPHONE_SERVICE_PROVIDERS_AND_CARRIERS"),
      @SerializedName("TICKETING")
      VALUE_TICKETING("TICKETING"),
      @SerializedName("TOBACCO")
      VALUE_TOBACCO("TOBACCO"),
      @SerializedName("TOURISM_AND_TRAVEL_SERVICES")
      VALUE_TOURISM_AND_TRAVEL_SERVICES("TOURISM_AND_TRAVEL_SERVICES"),
      @SerializedName("TOURISM_BOARD")
      VALUE_TOURISM_BOARD("TOURISM_BOARD"),
      @SerializedName("TOY_AND_HOBBY")
      VALUE_TOY_AND_HOBBY("TOY_AND_HOBBY"),
      @SerializedName("TRADE_SCHOOL")
      VALUE_TRADE_SCHOOL("TRADE_SCHOOL"),
      @SerializedName("TRAVEL_AGENCIES_AND_GUIDES_AND_OTAS")
      VALUE_TRAVEL_AGENCIES_AND_GUIDES_AND_OTAS("TRAVEL_AGENCIES_AND_GUIDES_AND_OTAS"),
      @SerializedName("UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES")
      VALUE_UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES("UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES"),
      @SerializedName("VETERINARY_CLINICS_AND_SERVICES")
      VALUE_VETERINARY_CLINICS_AND_SERVICES("VETERINARY_CLINICS_AND_SERVICES"),
      @SerializedName("VIDEO_STREAMING")
      VALUE_VIDEO_STREAMING("VIDEO_STREAMING"),
      @SerializedName("VIRTUAL_SERVICES")
      VALUE_VIRTUAL_SERVICES("VIRTUAL_SERVICES"),
      @SerializedName("VITAMINS_OR_WELLNESS")
      VALUE_VITAMINS_OR_WELLNESS("VITAMINS_OR_WELLNESS"),
      @SerializedName("WAREHOUSING_AND_STORAGE")
      VALUE_WAREHOUSING_AND_STORAGE("WAREHOUSING_AND_STORAGE"),
      @SerializedName("WATER_AND_SOFT_DRINK_AND_BAVERAGE")
      VALUE_WATER_AND_SOFT_DRINK_AND_BAVERAGE("WATER_AND_SOFT_DRINK_AND_BAVERAGE"),
      @SerializedName("WEBSITE_DESIGNERS_OR_GRAPHIC_DESIGNERS")
      VALUE_WEBSITE_DESIGNERS_OR_GRAPHIC_DESIGNERS("WEBSITE_DESIGNERS_OR_GRAPHIC_DESIGNERS"),
      @SerializedName("WHOLESALE")
      VALUE_WHOLESALE("WHOLESALE"),
      @SerializedName("WIRELESS_SERVICES")
      VALUE_WIRELESS_SERVICES("WIRELESS_SERVICES"),
      ;

      private String value;

      private EnumSubverticalV2(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVerticalV2 {
      @SerializedName("ADVERTISING_AND_MARKETING")
      VALUE_ADVERTISING_AND_MARKETING("ADVERTISING_AND_MARKETING"),
      @SerializedName("AGRICULTURE")
      VALUE_AGRICULTURE("AGRICULTURE"),
      @SerializedName("AUTOMOTIVE")
      VALUE_AUTOMOTIVE("AUTOMOTIVE"),
      @SerializedName("BANKING_AND_CREDIT_CARDS")
      VALUE_BANKING_AND_CREDIT_CARDS("BANKING_AND_CREDIT_CARDS"),
      @SerializedName("BUSINESS_TO_BUSINESS")
      VALUE_BUSINESS_TO_BUSINESS("BUSINESS_TO_BUSINESS"),
      @SerializedName("CONSUMER_PACKAGED_GOODS")
      VALUE_CONSUMER_PACKAGED_GOODS("CONSUMER_PACKAGED_GOODS"),
      @SerializedName("ECOMMERCE")
      VALUE_ECOMMERCE("ECOMMERCE"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ENERGY_AND_NATURAL_RESOURCES_AND_UTILITIES")
      VALUE_ENERGY_AND_NATURAL_RESOURCES_AND_UTILITIES("ENERGY_AND_NATURAL_RESOURCES_AND_UTILITIES"),
      @SerializedName("ENTERTAINMENT_AND_MEDIA")
      VALUE_ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
      @SerializedName("GAMING")
      VALUE_GAMING("GAMING"),
      @SerializedName("GOVERNMENT")
      VALUE_GOVERNMENT("GOVERNMENT"),
      @SerializedName("HEALTHCARE_AND_PHARMACEUTICALS_AND_BIOTECH")
      VALUE_HEALTHCARE_AND_PHARMACEUTICALS_AND_BIOTECH("HEALTHCARE_AND_PHARMACEUTICALS_AND_BIOTECH"),
      @SerializedName("INSURANCE")
      VALUE_INSURANCE("INSURANCE"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("POLITICS")
      VALUE_POLITICS("POLITICS"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("PUBLISHING")
      VALUE_PUBLISHING("PUBLISHING"),
      @SerializedName("RESTAURANTS")
      VALUE_RESTAURANTS("RESTAURANTS"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      ;

      private String value;

      private EnumVerticalV2(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionSource {
      @SerializedName("PHYSICAL_STORE")
      VALUE_PHYSICAL_STORE("PHYSICAL_STORE"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      ;

      private String value;

      private EnumActionSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPartitionType {
      @SerializedName("AUTH")
      VALUE_AUTH("AUTH"),
      @SerializedName("FIXED")
      VALUE_FIXED("FIXED"),
      @SerializedName("FIXED_WITHOUT_PARTITION")
      VALUE_FIXED_WITHOUT_PARTITION("FIXED_WITHOUT_PARTITION"),
      ;

      private String value;

      private EnumPartitionType(String value) {
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

  public Business copyFrom(Business instance) {
    this.mBlockOfflineAnalytics = instance.mBlockOfflineAnalytics;
    this.mCollaborativeAdsManagedPartnerBusinessInfo = instance.mCollaborativeAdsManagedPartnerBusinessInfo;
    this.mCollaborativeAdsManagedPartnerEligibility = instance.mCollaborativeAdsManagedPartnerEligibility;
    this.mCollaborativeAdsPartnerPremiumOptions = instance.mCollaborativeAdsPartnerPremiumOptions;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mExtendedUpdatedTime = instance.mExtendedUpdatedTime;
    this.mId = instance.mId;
    this.mIsHidden = instance.mIsHidden;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPaymentAccountId = instance.mPaymentAccountId;
    this.mPrimaryPage = instance.mPrimaryPage;
    this.mProfilePictureUri = instance.mProfilePictureUri;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTwoFactorType = instance.mTwoFactorType;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUserAccessExpireTime = instance.mUserAccessExpireTime;
    this.mVerificationStatus = instance.mVerificationStatus;
    this.mVertical = instance.mVertical;
    this.mVerticalId = instance.mVerticalId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Business> getParser() {
    return new APIRequest.ResponseParser<Business>() {
      public APINodeList<Business> parseResponse(String response, APIContext context, APIRequest<Business> request, String header) throws MalformedResponseException {
        return Business.parseResponse(response, context, request, header);
      }
    };
  }
}
