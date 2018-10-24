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
public class Business extends APINode {
  @SerializedName("block_offline_analytics")
  private Boolean mBlockOfflineAnalytics = null;
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
  @SerializedName("is_instagram_enabled_in_fb_analytics")
  private Boolean mIsInstagramEnabledInFbAnalytics = null;
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
  public static Business loadJSON(String json, APIContext context) {
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
      };
    }
    business.context = context;
    business.rawValue = json;
    return business;
  }

  public static APINodeList<Business> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Business> businesss = new APINodeList<Business>(request, json);
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
          businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businesss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businesss.add(loadJSON(obj.toString(), context));
            }
          }
          return businesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businesss.add(loadJSON(entry.getValue().toString(), context));
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
              businesss.add(loadJSON(value.toString(), context));
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
          businesss.add(loadJSON(json, context));
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

  public APIRequestGetAdStudies getAdStudies() {
    return new APIRequestGetAdStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdStudy createAdStudy() {
    return new APIRequestCreateAdStudy(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccountCreationRequests getAdAccountCreationRequests() {
    return new APIRequestGetAdAccountCreationRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccountCreationRequest createAdAccountCreationRequest() {
    return new APIRequestCreateAdAccountCreationRequest(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), context);
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

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdsPixel createAdsPixel() {
    return new APIRequestCreateAdsPixel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdvertisableApplications getAdvertisableApplications() {
    return new APIRequestGetAdvertisableApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencyPages getAgencyPages() {
    return new APIRequestGetAgencyPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteApps deleteApps() {
    return new APIRequestDeleteApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateApp createApp() {
    return new APIRequestCreateApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBlockListDraft createBlockListDraft() {
    return new APIRequestCreateBlockListDraft(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessActivities getBusinessActivities() {
    return new APIRequestGetBusinessActivities(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateBusinessProject createBusinessProject() {
    return new APIRequestCreateBusinessProject(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessSettingLogs getBusinessSettingLogs() {
    return new APIRequestGetBusinessSettingLogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCatalogSegmentProducerTos getCatalogSegmentProducerTos() {
    return new APIRequestGetCatalogSegmentProducerTos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCatalogSegmentProducerTo createCatalogSegmentProducerTo() {
    return new APIRequestCreateCatalogSegmentProducerTo(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClaimCustomConversion createClaimCustomConversion() {
    return new APIRequestCreateClaimCustomConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientAdAccounts getClientAdAccounts() {
    return new APIRequestGetClientAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientAdAccount createClientAdAccount() {
    return new APIRequestCreateClientAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientApps getClientApps() {
    return new APIRequestGetClientApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientApp createClientApp() {
    return new APIRequestCreateClientApp(this.getPrefixedId().toString(), context);
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

  public APIRequestDeleteClients deleteClients() {
    return new APIRequestDeleteClients(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomConversions getCustomConversions() {
    return new APIRequestGetCustomConversions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCustomConversion createCustomConversion() {
    return new APIRequestCreateCustomConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDealShowsPages getDealShowsPages() {
    return new APIRequestGetDealShowsPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDirectDeals getDirectDeals() {
    return new APIRequestGetDirectDeals(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEventSourceGroups getEventSourceGroups() {
    return new APIRequestGetEventSourceGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateEventSourceGroup createEventSourceGroup() {
    return new APIRequestCreateEventSourceGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExtendedCredits getExtendedCredits() {
    return new APIRequestGetExtendedCredits(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetGrpPlans getGrpPlans() {
    return new APIRequestGetGrpPlans(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInitiatedAudienceSharingRequests getInitiatedAudienceSharingRequests() {
    return new APIRequestGetInitiatedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInitiatedSharingAgreements getInitiatedSharingAgreements() {
    return new APIRequestGetInitiatedSharingAgreements(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteInstagramAccounts deleteInstagramAccounts() {
    return new APIRequestDeleteInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateManagedBusiness createManagedBusiness() {
    return new APIRequestCreateManagedBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMatchedSearchApplications getMatchedSearchApplications() {
    return new APIRequestGetMatchedSearchApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMeasurementReports getMeasurementReports() {
    return new APIRequestGetMeasurementReports(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMeasurementReport createMeasurementReport() {
    return new APIRequestCreateMeasurementReport(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfflineConversionDataSets getOfflineConversionDataSets() {
    return new APIRequestGetOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOfflineConversionDataSet createOfflineConversionDataSet() {
    return new APIRequestCreateOfflineConversionDataSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfFLineTermsOfService getOfFLineTermsOfService() {
    return new APIRequestGetOfFLineTermsOfService(this.getPrefixedId().toString(), context);
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

  public APIRequestGetOwnedCustomConversions getOwnedCustomConversions() {
    return new APIRequestGetOwnedCustomConversions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedDomains getOwnedDomains() {
    return new APIRequestGetOwnedDomains(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedDomain createOwnedDomain() {
    return new APIRequestCreateOwnedDomain(this.getPrefixedId().toString(), context);
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

  public APIRequestDeletePages deletePages() {
    return new APIRequestDeletePages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePage createPage() {
    return new APIRequestCreatePage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartnerIntegrations getPartnerIntegrations() {
    return new APIRequestGetPartnerIntegrations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePartnerIntegration createPartnerIntegration() {
    return new APIRequestCreatePartnerIntegration(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePartnerAdAccount createPartnerAdAccount() {
    return new APIRequestCreatePartnerAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartners getPartners() {
    return new APIRequestGetPartners(this.getPrefixedId().toString(), context);
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

  public APIRequestGetPendingOfflineConversionDataSets getPendingOfflineConversionDataSets() {
    return new APIRequestGetPendingOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedAdAccounts getPendingOwnedAdAccounts() {
    return new APIRequestGetPendingOwnedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedPages getPendingOwnedPages() {
    return new APIRequestGetPendingOwnedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingShareDPixels getPendingShareDPixels() {
    return new APIRequestGetPendingShareDPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingUsers getPendingUsers() {
    return new APIRequestGetPendingUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductCatalog createProductCatalog() {
    return new APIRequestCreateProductCatalog(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedAudiencePermissions getReceivedAudiencePermissions() {
    return new APIRequestGetReceivedAudiencePermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedAudienceSharingRequests getReceivedAudienceSharingRequests() {
    return new APIRequestGetReceivedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedSharingAgreements getReceivedSharingAgreements() {
    return new APIRequestGetReceivedSharingAgreements(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShareDAudiencePermissions getShareDAudiencePermissions() {
    return new APIRequestGetShareDAudiencePermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSpacoDataSetCollection createSpacoDataSetCollection() {
    return new APIRequestCreateSpacoDataSetCollection(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSystemUsers getSystemUsers() {
    return new APIRequestGetSystemUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSystemUser createSystemUser() {
    return new APIRequestCreateSystemUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserInvitations deleteUserInvitations() {
    return new APIRequestDeleteUserInvitations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUserInvitations getUserInvitations() {
    return new APIRequestGetUserInvitations(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserPermissions deleteUserPermissions() {
    return new APIRequestDeleteUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUserPermission createUserPermission() {
    return new APIRequestCreateUserPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVietnamAdAccountCreationRequest createVietnamAdAccountCreationRequest() {
    return new APIRequestCreateVietnamAdAccountCreationRequest(this.getPrefixedId().toString(), context);
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

  public Boolean getFieldIsInstagramEnabledInFbAnalytics() {
    return mIsInstagramEnabledInFbAnalytics;
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
      "scope",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateAccessToken.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateAccessToken setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateAccessToken setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateAccessToken setScope (Object scope) {
      this.setParam("scope", scope);
      return this;
    }
    public APIRequestCreateAccessToken setScope (String scope) {
      this.setParam("scope", scope);
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
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<AdStudy> parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudy> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdStudy>>() {
           public APINodeList<AdStudy> apply(String result) {
             try {
               return APIRequestGetAdStudies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "objectives",
      "end_time",
      "description",
      "name",
      "start_time",
      "viewers",
      "cooldown_start_time",
      "observation_end_time",
      "confidence_level",
      "client_business",
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestCreateAdStudy.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestCreateAdStudy setObjectives (List<Object> objectives) {
      this.setParam("objectives", objectives);
      return this;
    }
    public APIRequestCreateAdStudy setObjectives (String objectives) {
      this.setParam("objectives", objectives);
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

    public APIRequestCreateAdStudy setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAdStudy setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateAdStudy setViewers (List<Long> viewers) {
      this.setParam("viewers", viewers);
      return this;
    }
    public APIRequestCreateAdStudy setViewers (String viewers) {
      this.setParam("viewers", viewers);
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

    public APIRequestCreateAdStudy setObservationEndTime (Long observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }
    public APIRequestCreateAdStudy setObservationEndTime (String observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
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

    public APIRequestCreateAdStudy setClientBusiness (String clientBusiness) {
      this.setParam("client_business", clientBusiness);
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
      "name",
      "currency",
      "timezone_id",
      "end_advertiser",
      "funding_id",
      "media_agency",
      "partner",
      "invoice",
      "po_number",
      "io",
      "billing_address_id",
      "sold_to_address_id",
      "liable_address_id",
      "invoice_group_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccount parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccount>() {
           public AdAccount apply(String result) {
             try {
               return APIRequestCreateAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateAdAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdAccount setCurrency (String currency) {
      this.setParam("currency", currency);
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

    public APIRequestCreateAdAccount setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }

    public APIRequestCreateAdAccount setPartner (String partner) {
      this.setParam("partner", partner);
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

    public APIRequestCreateAdAccount setPoNumber (String poNumber) {
      this.setParam("po_number", poNumber);
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

    public APIRequestCreateAdAccount setBillingAddressId (Object billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setBillingAddressId (String billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setSoldToAddressId (Object soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setSoldToAddressId (String soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setLiableAddressId (Object liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setLiableAddressId (String liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setInvoiceGroupId (Object invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }
    public APIRequestCreateAdAccount setInvoiceGroupId (String invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
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

  public static class APIRequestGetAdAccountCreationRequests extends APIRequest<AdAccountCreationRequest> {

    APINodeList<AdAccountCreationRequest> lastResponse = null;
    @Override
    public APINodeList<AdAccountCreationRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "ad_accounts_currency",
      "ad_accounts_info",
      "additional_comment",
      "address_in_chinese",
      "address_in_english",
      "address_in_local_language",
      "advertiser_business",
      "appeal_reason",
      "business",
      "business_registration_id",
      "chinese_legal_entity_name",
      "contact",
      "creator",
      "credit_card_id",
      "disapproval_reasons",
      "english_legal_entity_name",
      "extended_credit_id",
      "id",
      "is_smb",
      "is_test",
      "is_under_authorization",
      "legal_entity_name_in_local_language",
      "official_website_url",
      "planning_agency_business",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_urls",
      "request_change_reasons",
      "status",
      "subvertical",
      "time_created",
      "vertical",
    };

    @Override
    public APINodeList<AdAccountCreationRequest> parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountCreationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountCreationRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountCreationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountCreationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountCreationRequest>>() {
           public APINodeList<AdAccountCreationRequest> apply(String result) {
             try {
               return APIRequestGetAdAccountCreationRequests.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdAccountCreationRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccountcreationrequests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAccountCreationRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccountCreationRequests setStatus (List<AdAccountCreationRequest.EnumStatus> status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetAdAccountCreationRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAccountCreationRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdAccountCreationRequests requestAdAccountsCurrencyField () {
      return this.requestAdAccountsCurrencyField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdAccountsCurrencyField (boolean value) {
      this.requestField("ad_accounts_currency", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAdAccountsInfoField () {
      return this.requestAdAccountsInfoField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdAccountsInfoField (boolean value) {
      this.requestField("ad_accounts_info", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAdditionalCommentField () {
      return this.requestAdditionalCommentField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdditionalCommentField (boolean value) {
      this.requestField("additional_comment", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInChineseField () {
      return this.requestAddressInChineseField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInChineseField (boolean value) {
      this.requestField("address_in_chinese", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInEnglishField () {
      return this.requestAddressInEnglishField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInEnglishField (boolean value) {
      this.requestField("address_in_english", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInLocalLanguageField () {
      return this.requestAddressInLocalLanguageField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInLocalLanguageField (boolean value) {
      this.requestField("address_in_local_language", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAdvertiserBusinessField () {
      return this.requestAdvertiserBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdvertiserBusinessField (boolean value) {
      this.requestField("advertiser_business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAppealReasonField () {
      return this.requestAppealReasonField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAppealReasonField (boolean value) {
      this.requestField("appeal_reason", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessRegistrationIdField () {
      return this.requestBusinessRegistrationIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessRegistrationIdField (boolean value) {
      this.requestField("business_registration_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestChineseLegalEntityNameField () {
      return this.requestChineseLegalEntityNameField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestChineseLegalEntityNameField (boolean value) {
      this.requestField("chinese_legal_entity_name", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestContactField () {
      return this.requestContactField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestContactField (boolean value) {
      this.requestField("contact", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestCreditCardIdField () {
      return this.requestCreditCardIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestCreditCardIdField (boolean value) {
      this.requestField("credit_card_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestDisapprovalReasonsField () {
      return this.requestDisapprovalReasonsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestDisapprovalReasonsField (boolean value) {
      this.requestField("disapproval_reasons", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestEnglishLegalEntityNameField () {
      return this.requestEnglishLegalEntityNameField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestEnglishLegalEntityNameField (boolean value) {
      this.requestField("english_legal_entity_name", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestExtendedCreditIdField () {
      return this.requestExtendedCreditIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestExtendedCreditIdField (boolean value) {
      this.requestField("extended_credit_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsSmbField () {
      return this.requestIsSmbField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsSmbField (boolean value) {
      this.requestField("is_smb", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsTestField () {
      return this.requestIsTestField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsTestField (boolean value) {
      this.requestField("is_test", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsUnderAuthorizationField () {
      return this.requestIsUnderAuthorizationField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsUnderAuthorizationField (boolean value) {
      this.requestField("is_under_authorization", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestLegalEntityNameInLocalLanguageField () {
      return this.requestLegalEntityNameInLocalLanguageField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestLegalEntityNameInLocalLanguageField (boolean value) {
      this.requestField("legal_entity_name_in_local_language", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestOfficialWebsiteUrlField () {
      return this.requestOfficialWebsiteUrlField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestOfficialWebsiteUrlField (boolean value) {
      this.requestField("official_website_url", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessField () {
      return this.requestPlanningAgencyBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessField (boolean value) {
      this.requestField("planning_agency_business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessIdField () {
      return this.requestPlanningAgencyBusinessIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessIdField (boolean value) {
      this.requestField("planning_agency_business_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableAppIdsField () {
      return this.requestPromotableAppIdsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableAppIdsField (boolean value) {
      this.requestField("promotable_app_ids", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotablePageIdsField () {
      return this.requestPromotablePageIdsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotablePageIdsField (boolean value) {
      this.requestField("promotable_page_ids", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableUrlsField () {
      return this.requestPromotableUrlsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableUrlsField (boolean value) {
      this.requestField("promotable_urls", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestRequestChangeReasonsField () {
      return this.requestRequestChangeReasonsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestRequestChangeReasonsField (boolean value) {
      this.requestField("request_change_reasons", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestSubverticalField () {
      return this.requestSubverticalField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestSubverticalField (boolean value) {
      this.requestField("subvertical", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateAdAccountCreationRequest extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "extended_credit_id",
      "ad_accounts_info",
      "business_registration",
      "planning_agency_business_id",
      "english_legal_entity_name",
      "legal_entity_name_in_local_language",
      "chinese_legal_entity_name",
      "address_in_chinese",
      "address_in_local_language",
      "address_in_english",
      "official_website_url",
      "business_registration_id",
      "vertical",
      "subvertical",
      "promotable_page_urls",
      "promotable_page_ids",
      "promotable_app_ids",
      "promotable_urls",
      "contact",
      "additional_comment",
      "is_smb",
      "is_test",
      "advertiser_business_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(String result) {
             try {
               return APIRequestCreateAdAccountCreationRequest.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdAccountCreationRequest(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccountcreationrequests", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccountCreationRequest setExtendedCreditId (Object extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setExtendedCreditId (String extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAdAccountsInfo (List<Object> adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setAdAccountsInfo (String adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setBusinessRegistration (File businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setBusinessRegistration (String businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPlanningAgencyBusinessId (String planningAgencyBusinessId) {
      this.setParam("planning_agency_business_id", planningAgencyBusinessId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setEnglishLegalEntityName (String englishLegalEntityName) {
      this.setParam("english_legal_entity_name", englishLegalEntityName);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setLegalEntityNameInLocalLanguage (String legalEntityNameInLocalLanguage) {
      this.setParam("legal_entity_name_in_local_language", legalEntityNameInLocalLanguage);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setChineseLegalEntityName (String chineseLegalEntityName) {
      this.setParam("chinese_legal_entity_name", chineseLegalEntityName);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAddressInChinese (String addressInChinese) {
      this.setParam("address_in_chinese", addressInChinese);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAddressInLocalLanguage (String addressInLocalLanguage) {
      this.setParam("address_in_local_language", addressInLocalLanguage);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAddressInEnglish (Object addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setAddressInEnglish (String addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setOfficialWebsiteUrl (Object officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setOfficialWebsiteUrl (String officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setBusinessRegistrationId (String businessRegistrationId) {
      this.setParam("business_registration_id", businessRegistrationId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setVertical (AdAccountCreationRequest.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setSubvertical (AdAccountCreationRequest.EnumSubvertical subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setSubvertical (String subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotablePageUrls (List<Object> promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotablePageUrls (String promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotablePageIds (List<String> promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotablePageIds (String promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotableAppIds (List<String> promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotableAppIds (String promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotableUrls (List<Object> promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotableUrls (String promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setContact (Object contact) {
      this.setParam("contact", contact);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setContact (String contact) {
      this.setParam("contact", contact);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAdditionalComment (String additionalComment) {
      this.setParam("additional_comment", additionalComment);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setIsSmb (Boolean isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setIsSmb (String isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setIsTest (Boolean isTest) {
      this.setParam("is_test", isTest);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setIsTest (String isTest) {
      this.setParam("is_test", isTest);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAdvertiserBusinessId (String advertiserBusinessId) {
      this.setParam("advertiser_business_id", advertiserBusinessId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccountCreationRequest requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestField (String field, boolean value) {
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "DELETE", Arrays.asList(PARAMS));
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
      "id",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String response) throws APIException {
      return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdNetworkAnalyticsSyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsSyncQueryResult> apply(String result) {
             try {
               return APIRequestGetAdNetworkAnalytics.this.parseResponse(result);
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

    public APIRequestGetAdNetworkAnalytics setSince (Object since) {
      this.setParam("since", since);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setUntil (Object until) {
      this.setParam("until", until);
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
    public APIRequestGetAdNetworkAnalytics requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestIdField (boolean value) {
      this.requestField("id", value);
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
      "metrics",
      "filters",
      "limit",
      "ordering_column",
      "ordering_type",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateAdNetworkAnalytic.this.parseResponse(result);
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

    public APIRequestCreateAdNetworkAnalytic setMetrics (List<AdNetworkAnalyticsSyncQueryResult.EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setMetrics (String metrics) {
      this.setParam("metrics", metrics);
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

    public APIRequestCreateAdNetworkAnalytic setSince (Object since) {
      this.setParam("since", since);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setUntil (Object until) {
      this.setParam("until", until);
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
      "id",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> parseResponse(String response) throws APIException {
      return AdNetworkAnalyticsAsyncQueryResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdNetworkAnalyticsAsyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsAsyncQueryResult> apply(String result) {
             try {
               return APIRequestGetAdNetworkAnalyticsResults.this.parseResponse(result);
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
    public APIRequestGetAdNetworkAnalyticsResults requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestIdField (boolean value) {
      this.requestField("id", value);
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
      "name_filter",
      "id_filter",
      "sort_by",
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetAdsPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetAdsPixels setNameFilter (String nameFilter) {
      this.setParam("name_filter", nameFilter);
      return this;
    }

    public APIRequestGetAdsPixels setIdFilter (String idFilter) {
      this.setParam("id_filter", idFilter);
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
    public APIRequestGetAdsPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetAdsPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
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
  }

  public static class APIRequestCreateAdsPixel extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateAdsPixel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetAdvertisableApplications extends APIRequest<BusinessAdvertisableApplicationsResult> {

    APINodeList<BusinessAdvertisableApplicationsResult> lastResponse = null;
    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
      "offset",
    };

    public static final String[] FIELDS = {
      "has_insight_permission",
      "id",
      "name",
      "photo_url",
    };

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> parseResponse(String response) throws APIException {
      return BusinessAdvertisableApplicationsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdvertisableApplicationsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdvertisableApplicationsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAdvertisableApplicationsResult>>() {
           public APINodeList<BusinessAdvertisableApplicationsResult> apply(String result) {
             try {
               return APIRequestGetAdvertisableApplications.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdvertisableApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/advertisable_applications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdvertisableApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdvertisableApplications setAdaccountId (Long adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }
    public APIRequestGetAdvertisableApplications setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestGetAdvertisableApplications setOffset (Long offset) {
      this.setParam("offset", offset);
      return this;
    }
    public APIRequestGetAdvertisableApplications setOffset (String offset) {
      this.setParam("offset", offset);
      return this;
    }

    public APIRequestGetAdvertisableApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdvertisableApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdvertisableApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdvertisableApplications requestHasInsightPermissionField () {
      return this.requestHasInsightPermissionField(true);
    }
    public APIRequestGetAdvertisableApplications requestHasInsightPermissionField (boolean value) {
      this.requestField("has_insight_permission", value);
      return this;
    }
    public APIRequestGetAdvertisableApplications requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdvertisableApplications requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdvertisableApplications requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdvertisableApplications requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdvertisableApplications requestPhotoUrlField () {
      return this.requestPhotoUrlField(true);
    }
    public APIRequestGetAdvertisableApplications requestPhotoUrlField (boolean value) {
      this.requestField("photo_url", value);
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetAgencyPages extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "agency_id",
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
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
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetAgencyPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAgencyPages(String nodeId, APIContext context) {
      super(context, nodeId, "/agency_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAgencyPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAgencyPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAgencyPages setAgencyId (String agencyId) {
      this.setParam("agency_id", agencyId);
      return this;
    }

    public APIRequestGetAgencyPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAgencyPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAgencyPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAgencyPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetAgencyPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetAgencyPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetAgencyPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetAgencyPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetAgencyPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetAgencyPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetAgencyPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetAgencyPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetAgencyPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetAgencyPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetAgencyPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetAgencyPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetAgencyPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetAgencyPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetAgencyPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetAgencyPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetAgencyPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAgencyPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetAgencyPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetAgencyPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetAgencyPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetAgencyPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetAgencyPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetAgencyPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetAgencyPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetAgencyPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetAgencyPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetAgencyPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetAgencyPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetAgencyPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetAgencyPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetAgencyPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetAgencyPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAgencyPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetAgencyPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetAgencyPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAgencyPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetAgencyPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetAgencyPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetAgencyPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetAgencyPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetAgencyPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetAgencyPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetAgencyPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetAgencyPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetAgencyPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetAgencyPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetAgencyPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetAgencyPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetAgencyPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetAgencyPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetAgencyPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetAgencyPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetAgencyPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetAgencyPages requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetAgencyPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetAgencyPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetAgencyPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetAgencyPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetAgencyPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetAgencyPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencyPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetAgencyPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetAgencyPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetAgencyPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetAgencyPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetAgencyPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetAgencyPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetAgencyPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetAgencyPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetAgencyPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetAgencyPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetAgencyPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetAgencyPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetAgencyPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetAgencyPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetAgencyPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetAgencyPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetAgencyPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAgencyPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAgencyPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetAgencyPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetAgencyPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetAgencyPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetAgencyPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetAgencyPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAgencyPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetAgencyPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetAgencyPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetAgencyPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetAgencyPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetAgencyPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetAgencyPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetAgencyPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetAgencyPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAgencyPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetAgencyPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetAgencyPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetAgencyPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetAgencyPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetAgencyPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetAgencyPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetAgencyPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetAgencyPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetAgencyPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetAgencyPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetAgencyPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetAgencyPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetAgencyPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetAgencyPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetAgencyPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetAgencyPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetAgencyPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetAgencyPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetAgencyPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetAgencyPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetAgencyPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetAgencyPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetAgencyPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetAgencyPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetAgencyPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetAgencyPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetAgencyPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetAgencyPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetAgencyPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetAgencyPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetAgencyPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetAgencyPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetAgencyPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetAgencyPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetAgencyPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetAgencyPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetAgencyPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetAgencyPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetAgencyPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetAgencyPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetAgencyPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetAgencyPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetAgencyPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetAgencyPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetAgencyPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAgencyPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetAgencyPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetAgencyPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetAgencyPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetAgencyPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetAgencyPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestDeleteApps extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteApps(String nodeId, APIContext context) {
      super(context, nodeId, "/apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteApps setAppId (Long appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestDeleteApps setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestDeleteApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateApp extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "access_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateApp(String nodeId, APIContext context) {
      super(context, nodeId, "/apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateApp setAccessType (Business.EnumAccessType accessType) {
      this.setParam("access_type", accessType);
      return this;
    }
    public APIRequestCreateApp setAccessType (String accessType) {
      this.setParam("access_type", accessType);
      return this;
    }

    public APIRequestCreateApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateBlockListDraft.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetBusinessActivities extends APIRequest<BusinessActivityLogEvent> {

    APINodeList<BusinessActivityLogEvent> lastResponse = null;
    @Override
    public APINodeList<BusinessActivityLogEvent> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "acted_upon_business_id",
      "acted_upon_business_name",
      "acted_upon_business_object_id",
      "acted_upon_business_object_name",
      "acted_upon_business_object_type",
      "acted_upon_user_id",
      "acted_upon_user_name",
      "acting_business_id",
      "acting_business_name",
      "acting_user_id",
      "acting_user_name",
      "event_time",
      "event_type",
      "extra_data",
      "target_business_id",
      "target_business_name",
      "target_business_object_id",
      "target_business_object_name",
      "target_business_object_type",
      "id",
    };

    @Override
    public APINodeList<BusinessActivityLogEvent> parseResponse(String response) throws APIException {
      return BusinessActivityLogEvent.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessActivityLogEvent> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessActivityLogEvent> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessActivityLogEvent>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessActivityLogEvent>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessActivityLogEvent>>() {
           public APINodeList<BusinessActivityLogEvent> apply(String result) {
             try {
               return APIRequestGetBusinessActivities.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/business_activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessActivities setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetBusinessActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessActivities requestActedUponBusinessIdField () {
      return this.requestActedUponBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessIdField (boolean value) {
      this.requestField("acted_upon_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessNameField () {
      return this.requestActedUponBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessNameField (boolean value) {
      this.requestField("acted_upon_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectIdField () {
      return this.requestActedUponBusinessObjectIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectIdField (boolean value) {
      this.requestField("acted_upon_business_object_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectNameField () {
      return this.requestActedUponBusinessObjectNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectNameField (boolean value) {
      this.requestField("acted_upon_business_object_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectTypeField () {
      return this.requestActedUponBusinessObjectTypeField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectTypeField (boolean value) {
      this.requestField("acted_upon_business_object_type", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponUserIdField () {
      return this.requestActedUponUserIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponUserIdField (boolean value) {
      this.requestField("acted_upon_user_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponUserNameField () {
      return this.requestActedUponUserNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponUserNameField (boolean value) {
      this.requestField("acted_upon_user_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingBusinessIdField () {
      return this.requestActingBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestActingBusinessIdField (boolean value) {
      this.requestField("acting_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingBusinessNameField () {
      return this.requestActingBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestActingBusinessNameField (boolean value) {
      this.requestField("acting_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingUserIdField () {
      return this.requestActingUserIdField(true);
    }
    public APIRequestGetBusinessActivities requestActingUserIdField (boolean value) {
      this.requestField("acting_user_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingUserNameField () {
      return this.requestActingUserNameField(true);
    }
    public APIRequestGetBusinessActivities requestActingUserNameField (boolean value) {
      this.requestField("acting_user_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetBusinessActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetBusinessActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetBusinessActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessIdField () {
      return this.requestTargetBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessIdField (boolean value) {
      this.requestField("target_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessNameField () {
      return this.requestTargetBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessNameField (boolean value) {
      this.requestField("target_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectIdField () {
      return this.requestTargetBusinessObjectIdField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectIdField (boolean value) {
      this.requestField("target_business_object_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectNameField () {
      return this.requestTargetBusinessObjectNameField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectNameField (boolean value) {
      this.requestField("target_business_object_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectTypeField () {
      return this.requestTargetBusinessObjectTypeField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectTypeField (boolean value) {
      this.requestField("target_business_object_type", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessActivities requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetBusinessInvoices extends APIRequest<OracleTransaction> {

    APINodeList<OracleTransaction> lastResponse = null;
    @Override
    public APINodeList<OracleTransaction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "start_date",
      "end_date",
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "amount",
      "amount_due",
      "billed_amount_details",
      "billing_period",
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
    public APINodeList<OracleTransaction> parseResponse(String response) throws APIException {
      return OracleTransaction.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OracleTransaction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OracleTransaction> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OracleTransaction>>() {
           public APINodeList<OracleTransaction> apply(String result) {
             try {
               return APIRequestGetBusinessInvoices.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetBusinessInvoices setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setEndDate (String endDate) {
      this.setParam("end_date", endDate);
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
    public APINodeList<BusinessUser> parseResponse(String response) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessUser>>() {
           public APINodeList<BusinessUser> apply(String result) {
             try {
               return APIRequestGetBusinessUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public BusinessUser parseResponse(String response) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessUser execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessUser>() {
           public BusinessUser apply(String result) {
             try {
               return APIRequestCreateBusinessUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APINodeList<BusinessProject> parseResponse(String response) throws APIException {
      return BusinessProject.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessProject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessProject> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessProject>>() {
           public APINodeList<BusinessProject> apply(String result) {
             try {
               return APIRequestGetBusinessProjects.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestCreateBusinessProject extends APIRequest<BusinessProject> {

    BusinessProject lastResponse = null;
    @Override
    public BusinessProject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessProject parseResponse(String response) throws APIException {
      return BusinessProject.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessProject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessProject execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessProject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessProject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessProject>() {
           public BusinessProject apply(String result) {
             try {
               return APIRequestCreateBusinessProject.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateBusinessProject(String nodeId, APIContext context) {
      super(context, nodeId, "/businessprojects", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBusinessProject setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBusinessProject setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBusinessProject setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateBusinessProject requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBusinessProject requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessProject requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBusinessProject requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessProject requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBusinessProject requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessSettingLogs extends APIRequest<BusinessSettingLogsData> {

    APINodeList<BusinessSettingLogsData> lastResponse = null;
    @Override
    public APINodeList<BusinessSettingLogsData> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actor",
      "event_object",
      "event_time",
      "event_type",
      "extra_data",
      "id",
    };

    @Override
    public APINodeList<BusinessSettingLogsData> parseResponse(String response) throws APIException {
      return BusinessSettingLogsData.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessSettingLogsData> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessSettingLogsData> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessSettingLogsData>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessSettingLogsData>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessSettingLogsData>>() {
           public APINodeList<BusinessSettingLogsData> apply(String result) {
             try {
               return APIRequestGetBusinessSettingLogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessSettingLogs(String nodeId, APIContext context) {
      super(context, nodeId, "/businesssettinglogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessSettingLogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessSettingLogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessSettingLogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessSettingLogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessSettingLogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessSettingLogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessSettingLogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessSettingLogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessSettingLogs requestActorField () {
      return this.requestActorField(true);
    }
    public APIRequestGetBusinessSettingLogs requestActorField (boolean value) {
      this.requestField("actor", value);
      return this;
    }
    public APIRequestGetBusinessSettingLogs requestEventObjectField () {
      return this.requestEventObjectField(true);
    }
    public APIRequestGetBusinessSettingLogs requestEventObjectField (boolean value) {
      this.requestField("event_object", value);
      return this;
    }
    public APIRequestGetBusinessSettingLogs requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetBusinessSettingLogs requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetBusinessSettingLogs requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetBusinessSettingLogs requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetBusinessSettingLogs requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetBusinessSettingLogs requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetBusinessSettingLogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessSettingLogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetCatalogSegmentProducerTos extends APIRequest<BusinessProductCatalogTOS> {

    APINodeList<BusinessProductCatalogTOS> lastResponse = null;
    @Override
    public APINodeList<BusinessProductCatalogTOS> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_segment_id",
    };

    public static final String[] FIELDS = {
      "accepted",
      "content",
      "id",
    };

    @Override
    public APINodeList<BusinessProductCatalogTOS> parseResponse(String response) throws APIException {
      return BusinessProductCatalogTOS.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessProductCatalogTOS> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessProductCatalogTOS> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessProductCatalogTOS>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessProductCatalogTOS>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessProductCatalogTOS>>() {
           public APINodeList<BusinessProductCatalogTOS> apply(String result) {
             try {
               return APIRequestGetCatalogSegmentProducerTos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCatalogSegmentProducerTos(String nodeId, APIContext context) {
      super(context, nodeId, "/catalog_segment_producer_tos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCatalogSegmentProducerTos setCatalogSegmentId (String catalogSegmentId) {
      this.setParam("catalog_segment_id", catalogSegmentId);
      return this;
    }

    public APIRequestGetCatalogSegmentProducerTos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCatalogSegmentProducerTos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCatalogSegmentProducerTos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCatalogSegmentProducerTos requestAcceptedField () {
      return this.requestAcceptedField(true);
    }
    public APIRequestGetCatalogSegmentProducerTos requestAcceptedField (boolean value) {
      this.requestField("accepted", value);
      return this;
    }
    public APIRequestGetCatalogSegmentProducerTos requestContentField () {
      return this.requestContentField(true);
    }
    public APIRequestGetCatalogSegmentProducerTos requestContentField (boolean value) {
      this.requestField("content", value);
      return this;
    }
    public APIRequestGetCatalogSegmentProducerTos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCatalogSegmentProducerTos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateCatalogSegmentProducerTo extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_segment_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateCatalogSegmentProducerTo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCatalogSegmentProducerTo(String nodeId, APIContext context) {
      super(context, nodeId, "/catalog_segment_producer_tos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCatalogSegmentProducerTo setCatalogSegmentId (String catalogSegmentId) {
      this.setParam("catalog_segment_id", catalogSegmentId);
      return this;
    }

    public APIRequestCreateCatalogSegmentProducerTo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCatalogSegmentProducerTo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCatalogSegmentProducerTo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public CustomConversion parseResponse(String response) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomConversion execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomConversion execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CustomConversion> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomConversion> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CustomConversion>() {
           public CustomConversion apply(String result) {
             try {
               return APIRequestCreateClaimCustomConversion.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "daily_spend_limit",
      "direct_deals_tos_accepted",
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
      "extended_credit_invoice_group",
      "failed_delivery_checks",
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
      "rate_limit_reset_time",
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
    public APINodeList<AdAccount> parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccount>>() {
           public APINodeList<AdAccount> apply(String result) {
             try {
               return APIRequestGetClientAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetClientAdAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetClientAdAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
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
    public APIRequestGetClientAdAccounts requestDailySpendLimitField () {
      return this.requestDailySpendLimitField(true);
    }
    public APIRequestGetClientAdAccounts requestDailySpendLimitField (boolean value) {
      this.requestField("daily_spend_limit", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDirectDealsTosAcceptedField () {
      return this.requestDirectDealsTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestDirectDealsTosAcceptedField (boolean value) {
      this.requestField("direct_deals_tos_accepted", value);
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
    public APIRequestGetClientAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetClientAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
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
    public APIRequestGetClientAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetClientAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
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
    public APIRequestGetClientAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetClientAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestCreateClientAdAccount extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
      "permitted_tasks",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateClientAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateClientAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClientAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClientAdAccount setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestCreateClientAdAccount setPermittedTasks (List<Business.EnumPermittedTasks> permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }
    public APIRequestCreateClientAdAccount setPermittedTasks (String permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }

    public APIRequestCreateClientAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClientAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClientAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "business",
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "category",
      "client_config",
      "company",
      "configured_ios_sso",
      "contact_email",
      "context",
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
      "is_viewer_admin",
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
    public APINodeList<Application> parseResponse(String response) throws APIException {
      return Application.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Application> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Application> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Application>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Application>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Application>>() {
           public APINodeList<Application> apply(String result) {
             try {
               return APIRequestGetClientApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetClientApps requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetClientApps requestContextField (boolean value) {
      this.requestField("context", value);
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
    public APIRequestGetClientApps requestIsViewerAdminField () {
      return this.requestIsViewerAdminField(true);
    }
    public APIRequestGetClientApps requestIsViewerAdminField (boolean value) {
      this.requestField("is_viewer_admin", value);
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
    public APIRequestGetClientApps requestLoginSecretField () {
      return this.requestLoginSecretField(true);
    }
    public APIRequestGetClientApps requestLoginSecretField (boolean value) {
      this.requestField("login_secret", value);
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateClientApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
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
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetClientPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetClientPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetClientPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
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
    public APIRequestGetClientPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetClientPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetClientPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetClientPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetClientPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetClientPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
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
    public APIRequestGetClientPages requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetClientPages requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
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
    public APIRequestGetClientPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetClientPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
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
    public APIRequestGetClientPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetClientPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetClientPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetClientPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
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
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
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
    public APIRequestGetClientPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetClientPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
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
    public APIRequestGetClientPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetClientPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetClientPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetClientPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateClientPage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetClientPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetClientPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetClientPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetClientPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetClientPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetClientPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
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
      "business",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "flight_catalog_settings",
      "id",
      "image_padding_landscape",
      "image_padding_square",
      "name",
      "product_count",
      "qualified_product_count",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(String result) {
             try {
               return APIRequestGetClientProductCatalogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGetClientProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
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
    public APIRequestGetClientProductCatalogs requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestImagePaddingLandscapeField () {
      return this.requestImagePaddingLandscapeField(true);
    }
    public APIRequestGetClientProductCatalogs requestImagePaddingLandscapeField (boolean value) {
      this.requestField("image_padding_landscape", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestImagePaddingSquareField () {
      return this.requestImagePaddingSquareField(true);
    }
    public APIRequestGetClientProductCatalogs requestImagePaddingSquareField (boolean value) {
      this.requestField("image_padding_square", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteClients.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "last_fired_time",
      "name",
      "offline_conversion_data_set",
      "pixel",
      "retention_days",
      "rule",
    };

    @Override
    public APINodeList<CustomConversion> parseResponse(String response) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomConversion> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversion> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CustomConversion>>() {
           public APINodeList<CustomConversion> apply(String result) {
             try {
               return APIRequestGetCustomConversions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestCreateCustomConversion extends APIRequest<CustomConversion> {

    CustomConversion lastResponse = null;
    @Override
    public CustomConversion getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "description",
      "event_source_id",
      "rule",
      "default_conversion_value",
      "custom_event_type",
      "advanced_rule",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomConversion parseResponse(String response) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomConversion execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomConversion execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CustomConversion> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomConversion> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CustomConversion>() {
           public CustomConversion apply(String result) {
             try {
               return APIRequestCreateCustomConversion.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateCustomConversion setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateCustomConversion setRule (String rule) {
      this.setParam("rule", rule);
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

    public APIRequestCreateCustomConversion setCustomEventType (CustomConversion.EnumCustomEventType customEventType) {
      this.setParam("custom_event_type", customEventType);
      return this;
    }
    public APIRequestCreateCustomConversion setCustomEventType (String customEventType) {
      this.setParam("custom_event_type", customEventType);
      return this;
    }

    public APIRequestCreateCustomConversion setAdvancedRule (String advancedRule) {
      this.setParam("advanced_rule", advancedRule);
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

  public static class APIRequestGetDealShowsPages extends APIRequest<Page> {

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
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
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
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetDealShowsPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDealShowsPages(String nodeId, APIContext context) {
      super(context, nodeId, "/deal_shows_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDealShowsPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDealShowsPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDealShowsPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDealShowsPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDealShowsPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDealShowsPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDealShowsPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDealShowsPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDealShowsPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetDealShowsPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetDealShowsPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetDealShowsPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetDealShowsPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetDealShowsPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetDealShowsPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetDealShowsPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetDealShowsPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetDealShowsPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetDealShowsPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetDealShowsPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetDealShowsPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetDealShowsPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetDealShowsPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetDealShowsPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetDealShowsPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetDealShowsPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetDealShowsPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetDealShowsPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetDealShowsPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetDealShowsPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetDealShowsPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetDealShowsPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetDealShowsPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetDealShowsPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetDealShowsPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetDealShowsPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetDealShowsPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetDealShowsPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetDealShowsPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetDealShowsPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetDealShowsPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDealShowsPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetDealShowsPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetDealShowsPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetDealShowsPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetDealShowsPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetDealShowsPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetDealShowsPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetDealShowsPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetDealShowsPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetDealShowsPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetDealShowsPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetDealShowsPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetDealShowsPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetDealShowsPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetDealShowsPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetDealShowsPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetDealShowsPages requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetDealShowsPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetDealShowsPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetDealShowsPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetDealShowsPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetDealShowsPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetDealShowsPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDealShowsPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetDealShowsPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetDealShowsPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetDealShowsPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetDealShowsPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetDealShowsPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetDealShowsPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetDealShowsPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetDealShowsPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetDealShowsPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetDealShowsPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetDealShowsPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetDealShowsPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetDealShowsPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetDealShowsPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetDealShowsPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetDealShowsPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetDealShowsPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetDealShowsPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetDealShowsPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetDealShowsPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetDealShowsPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetDealShowsPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetDealShowsPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetDealShowsPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetDealShowsPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetDealShowsPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetDealShowsPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDealShowsPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetDealShowsPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetDealShowsPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetDealShowsPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetDealShowsPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetDealShowsPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetDealShowsPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetDealShowsPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetDealShowsPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetDealShowsPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetDealShowsPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetDealShowsPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetDealShowsPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetDealShowsPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetDealShowsPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetDealShowsPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetDealShowsPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetDealShowsPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetDealShowsPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetDealShowsPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetDealShowsPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetDealShowsPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetDealShowsPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetDealShowsPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetDealShowsPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetDealShowsPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetDealShowsPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetDealShowsPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetDealShowsPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetDealShowsPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetDealShowsPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetDealShowsPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetDealShowsPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetDealShowsPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetDealShowsPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetDealShowsPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetDealShowsPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetDealShowsPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetDealShowsPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetDealShowsPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetDealShowsPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetDealShowsPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetDealShowsPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetDealShowsPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetDealShowsPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetDealShowsPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetDealShowsPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetDealShowsPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetDealShowsPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetDealShowsPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetDealShowsPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetDealShowsPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetDealShowsPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetDealShowsPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGetDirectDeals extends APIRequest<DirectDeal> {

    APINodeList<DirectDeal> lastResponse = null;
    @Override
    public APINodeList<DirectDeal> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "adbreaks_enabled",
      "adset",
      "advertiser",
      "advertiser_lead_email",
      "advertiser_page",
      "cpe_amount",
      "cpe_currency",
      "end_time",
      "id",
      "lifetime_budget_amount",
      "lifetime_budget_currency",
      "lifetime_impressions",
      "name",
      "pages",
      "placements",
      "priced_by",
      "publisher_name",
      "review_requirement",
      "sales_lead_email",
      "start_time",
      "status",
      "targeting",
      "third_party_ids",
      "third_party_integrated_deal",
    };

    @Override
    public APINodeList<DirectDeal> parseResponse(String response) throws APIException {
      return DirectDeal.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<DirectDeal> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DirectDeal> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DirectDeal>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DirectDeal>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<DirectDeal>>() {
           public APINodeList<DirectDeal> apply(String result) {
             try {
               return APIRequestGetDirectDeals.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDirectDeals(String nodeId, APIContext context) {
      super(context, nodeId, "/direct_deals", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDirectDeals setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDirectDeals setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDirectDeals setStatus (DirectDeal.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetDirectDeals setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetDirectDeals requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDirectDeals requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDirectDeals requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDirectDeals requestAdbreaksEnabledField () {
      return this.requestAdbreaksEnabledField(true);
    }
    public APIRequestGetDirectDeals requestAdbreaksEnabledField (boolean value) {
      this.requestField("adbreaks_enabled", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetDirectDeals requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserField () {
      return this.requestAdvertiserField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserField (boolean value) {
      this.requestField("advertiser", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserLeadEmailField () {
      return this.requestAdvertiserLeadEmailField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserLeadEmailField (boolean value) {
      this.requestField("advertiser_lead_email", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserPageField () {
      return this.requestAdvertiserPageField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserPageField (boolean value) {
      this.requestField("advertiser_page", value);
      return this;
    }
    public APIRequestGetDirectDeals requestCpeAmountField () {
      return this.requestCpeAmountField(true);
    }
    public APIRequestGetDirectDeals requestCpeAmountField (boolean value) {
      this.requestField("cpe_amount", value);
      return this;
    }
    public APIRequestGetDirectDeals requestCpeCurrencyField () {
      return this.requestCpeCurrencyField(true);
    }
    public APIRequestGetDirectDeals requestCpeCurrencyField (boolean value) {
      this.requestField("cpe_currency", value);
      return this;
    }
    public APIRequestGetDirectDeals requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetDirectDeals requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetDirectDeals requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDirectDeals requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetAmountField () {
      return this.requestLifetimeBudgetAmountField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetAmountField (boolean value) {
      this.requestField("lifetime_budget_amount", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetCurrencyField () {
      return this.requestLifetimeBudgetCurrencyField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetCurrencyField (boolean value) {
      this.requestField("lifetime_budget_currency", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeImpressionsField () {
      return this.requestLifetimeImpressionsField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeImpressionsField (boolean value) {
      this.requestField("lifetime_impressions", value);
      return this;
    }
    public APIRequestGetDirectDeals requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDirectDeals requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPagesField () {
      return this.requestPagesField(true);
    }
    public APIRequestGetDirectDeals requestPagesField (boolean value) {
      this.requestField("pages", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPlacementsField () {
      return this.requestPlacementsField(true);
    }
    public APIRequestGetDirectDeals requestPlacementsField (boolean value) {
      this.requestField("placements", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPricedByField () {
      return this.requestPricedByField(true);
    }
    public APIRequestGetDirectDeals requestPricedByField (boolean value) {
      this.requestField("priced_by", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPublisherNameField () {
      return this.requestPublisherNameField(true);
    }
    public APIRequestGetDirectDeals requestPublisherNameField (boolean value) {
      this.requestField("publisher_name", value);
      return this;
    }
    public APIRequestGetDirectDeals requestReviewRequirementField () {
      return this.requestReviewRequirementField(true);
    }
    public APIRequestGetDirectDeals requestReviewRequirementField (boolean value) {
      this.requestField("review_requirement", value);
      return this;
    }
    public APIRequestGetDirectDeals requestSalesLeadEmailField () {
      return this.requestSalesLeadEmailField(true);
    }
    public APIRequestGetDirectDeals requestSalesLeadEmailField (boolean value) {
      this.requestField("sales_lead_email", value);
      return this;
    }
    public APIRequestGetDirectDeals requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetDirectDeals requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetDirectDeals requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetDirectDeals requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetDirectDeals requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetDirectDeals requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetDirectDeals requestThirdPartyIdsField () {
      return this.requestThirdPartyIdsField(true);
    }
    public APIRequestGetDirectDeals requestThirdPartyIdsField (boolean value) {
      this.requestField("third_party_ids", value);
      return this;
    }
    public APIRequestGetDirectDeals requestThirdPartyIntegratedDealField () {
      return this.requestThirdPartyIntegratedDealField(true);
    }
    public APIRequestGetDirectDeals requestThirdPartyIntegratedDealField (boolean value) {
      this.requestField("third_party_integrated_deal", value);
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
    };

    @Override
    public APINodeList<EventSourceGroup> parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<EventSourceGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<EventSourceGroup> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<EventSourceGroup>>() {
           public APINodeList<EventSourceGroup> apply(String result) {
             try {
               return APIRequestGetEventSourceGroups.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public EventSourceGroup parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<EventSourceGroup> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventSourceGroup> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, EventSourceGroup>() {
           public EventSourceGroup apply(String result) {
             try {
               return APIRequestCreateEventSourceGroup.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetExtendedCredits extends APIRequest<ExtendedCredit> {

    APINodeList<ExtendedCredit> lastResponse = null;
    @Override
    public APINodeList<ExtendedCredit> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "allocated_amount",
      "balance",
      "credit_available",
      "credit_type",
      "id",
      "is_access_revoked",
      "is_automated_experience",
      "last_payment_time",
      "legal_entity_name",
      "liable_biz_name",
      "max_balance",
      "online_max_balance",
      "owner_business",
      "owner_business_name",
      "partition_from",
      "receiving_credit_allocation_config",
      "send_bill_to_biz_name",
    };

    @Override
    public APINodeList<ExtendedCredit> parseResponse(String response) throws APIException {
      return ExtendedCredit.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ExtendedCredit> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCredit> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ExtendedCredit>>() {
           public APINodeList<ExtendedCredit> apply(String result) {
             try {
               return APIRequestGetExtendedCredits.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetExtendedCredits requestLastPaymentTimeField () {
      return this.requestLastPaymentTimeField(true);
    }
    public APIRequestGetExtendedCredits requestLastPaymentTimeField (boolean value) {
      this.requestField("last_payment_time", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
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
    public APIRequestGetExtendedCredits requestSendBillToBizNameField () {
      return this.requestSendBillToBizNameField(true);
    }
    public APIRequestGetExtendedCredits requestSendBillToBizNameField (boolean value) {
      this.requestField("send_bill_to_biz_name", value);
      return this;
    }
  }

  public static class APIRequestGetGrpPlans extends APIRequest<ReachFrequencyPrediction> {

    APINodeList<ReachFrequencyPrediction> lastResponse = null;
    @Override
    public APINodeList<ReachFrequencyPrediction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "account_id",
      "activity_status",
      "ad_formats",
      "auction_entry_option_index",
      "business_id",
      "buying_type",
      "campaign_group_id",
      "campaign_id",
      "campaign_time_start",
      "campaign_time_stop",
      "currency",
      "curve_budget_reach",
      "curve_reach",
      "daily_grp_curve",
      "daily_impression_curve",
      "daily_impression_curve_map",
      "day_parting_schedule",
      "demo_breakdown",
      "destination_id",
      "end_time",
      "expiration_time",
      "external_budget",
      "external_impression",
      "external_maximum_budget",
      "external_maximum_impression",
      "external_maximum_reach",
      "external_minimum_budget",
      "external_minimum_impression",
      "external_minimum_reach",
      "external_reach",
      "external_values_breakdown",
      "feed_ratio_0000",
      "frequency_cap",
      "frequency_distribution",
      "frequency_distribution_map",
      "frequency_distribution_map_agg",
      "full_view_ratio_00",
      "grp_audience_size",
      "grp_avg_probability_map",
      "grp_country_audience_size",
      "grp_curve",
      "grp_dmas_audience_size",
      "grp_filtering_threshold_00",
      "grp_points",
      "grp_ratio",
      "grp_reach_ratio",
      "grp_status",
      "holdout_percentage",
      "id",
      "impression_curve",
      "instagram_destination_id",
      "instream_packages",
      "interval_frequency_cap",
      "interval_frequency_cap_reset_period",
      "is_bonus_media",
      "is_conversion_goal",
      "is_higher_average_frequency",
      "is_io",
      "is_reserved_buying",
      "is_trp",
      "name",
      "objective",
      "objective_name",
      "pause_periods",
      "placement_breakdown",
      "placement_breakdown_map",
      "plan_name",
      "plan_type",
      "prediction_mode",
      "prediction_progress",
      "reference_id",
      "reservation_status",
      "start_time",
      "status",
      "story_event_type",
      "target_audience_size",
      "target_cpm",
      "target_spec",
      "time_created",
      "time_updated",
      "timezone_id",
      "timezone_name",
      "topline_id",
      "tv_viewer_cluster_map",
      "video_view_benchmark_map",
      "video_view_length_constraint",
      "viewtag",
    };

    @Override
    public APINodeList<ReachFrequencyPrediction> parseResponse(String response) throws APIException {
      return ReachFrequencyPrediction.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ReachFrequencyPrediction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ReachFrequencyPrediction> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ReachFrequencyPrediction>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ReachFrequencyPrediction>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ReachFrequencyPrediction>>() {
           public APINodeList<ReachFrequencyPrediction> apply(String result) {
             try {
               return APIRequestGetGrpPlans.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetGrpPlans(String nodeId, APIContext context) {
      super(context, nodeId, "/grp_plans", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetGrpPlans setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetGrpPlans setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGrpPlans setStatus (ReachFrequencyPrediction.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetGrpPlans setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetGrpPlans requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGrpPlans requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetGrpPlans requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetGrpPlans requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetGrpPlans requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestActivityStatusField () {
      return this.requestActivityStatusField(true);
    }
    public APIRequestGetGrpPlans requestActivityStatusField (boolean value) {
      this.requestField("activity_status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestAdFormatsField () {
      return this.requestAdFormatsField(true);
    }
    public APIRequestGetGrpPlans requestAdFormatsField (boolean value) {
      this.requestField("ad_formats", value);
      return this;
    }
    public APIRequestGetGrpPlans requestAuctionEntryOptionIndexField () {
      return this.requestAuctionEntryOptionIndexField(true);
    }
    public APIRequestGetGrpPlans requestAuctionEntryOptionIndexField (boolean value) {
      this.requestField("auction_entry_option_index", value);
      return this;
    }
    public APIRequestGetGrpPlans requestBusinessIdField () {
      return this.requestBusinessIdField(true);
    }
    public APIRequestGetGrpPlans requestBusinessIdField (boolean value) {
      this.requestField("business_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetGrpPlans requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetGrpPlans requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCurveReachField () {
      return this.requestCurveReachField(true);
    }
    public APIRequestGetGrpPlans requestCurveReachField (boolean value) {
      this.requestField("curve_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDailyGrpCurveField () {
      return this.requestDailyGrpCurveField(true);
    }
    public APIRequestGetGrpPlans requestDailyGrpCurveField (boolean value) {
      this.requestField("daily_grp_curve", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveField () {
      return this.requestDailyImpressionCurveField(true);
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveField (boolean value) {
      this.requestField("daily_impression_curve", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveMapField () {
      return this.requestDailyImpressionCurveMapField(true);
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveMapField (boolean value) {
      this.requestField("daily_impression_curve_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDayPartingScheduleField () {
      return this.requestDayPartingScheduleField(true);
    }
    public APIRequestGetGrpPlans requestDayPartingScheduleField (boolean value) {
      this.requestField("day_parting_schedule", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDemoBreakdownField () {
      return this.requestDemoBreakdownField(true);
    }
    public APIRequestGetGrpPlans requestDemoBreakdownField (boolean value) {
      this.requestField("demo_breakdown", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGetGrpPlans requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetGrpPlans requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetGrpPlans requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalValuesBreakdownField () {
      return this.requestExternalValuesBreakdownField(true);
    }
    public APIRequestGetGrpPlans requestExternalValuesBreakdownField (boolean value) {
      this.requestField("external_values_breakdown", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFeedRatio0000Field () {
      return this.requestFeedRatio0000Field(true);
    }
    public APIRequestGetGrpPlans requestFeedRatio0000Field (boolean value) {
      this.requestField("feed_ratio_0000", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionField () {
      return this.requestFrequencyDistributionField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionField (boolean value) {
      this.requestField("frequency_distribution", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapField () {
      return this.requestFrequencyDistributionMapField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapField (boolean value) {
      this.requestField("frequency_distribution_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapAggField () {
      return this.requestFrequencyDistributionMapAggField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapAggField (boolean value) {
      this.requestField("frequency_distribution_map_agg", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFullViewRatio00Field () {
      return this.requestFullViewRatio00Field(true);
    }
    public APIRequestGetGrpPlans requestFullViewRatio00Field (boolean value) {
      this.requestField("full_view_ratio_00", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpAudienceSizeField () {
      return this.requestGrpAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestGrpAudienceSizeField (boolean value) {
      this.requestField("grp_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpAvgProbabilityMapField () {
      return this.requestGrpAvgProbabilityMapField(true);
    }
    public APIRequestGetGrpPlans requestGrpAvgProbabilityMapField (boolean value) {
      this.requestField("grp_avg_probability_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpCountryAudienceSizeField () {
      return this.requestGrpCountryAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestGrpCountryAudienceSizeField (boolean value) {
      this.requestField("grp_country_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpCurveField () {
      return this.requestGrpCurveField(true);
    }
    public APIRequestGetGrpPlans requestGrpCurveField (boolean value) {
      this.requestField("grp_curve", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpDmasAudienceSizeField () {
      return this.requestGrpDmasAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestGrpDmasAudienceSizeField (boolean value) {
      this.requestField("grp_dmas_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpFilteringThreshold00Field () {
      return this.requestGrpFilteringThreshold00Field(true);
    }
    public APIRequestGetGrpPlans requestGrpFilteringThreshold00Field (boolean value) {
      this.requestField("grp_filtering_threshold_00", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpPointsField () {
      return this.requestGrpPointsField(true);
    }
    public APIRequestGetGrpPlans requestGrpPointsField (boolean value) {
      this.requestField("grp_points", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpRatioField () {
      return this.requestGrpRatioField(true);
    }
    public APIRequestGetGrpPlans requestGrpRatioField (boolean value) {
      this.requestField("grp_ratio", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpReachRatioField () {
      return this.requestGrpReachRatioField(true);
    }
    public APIRequestGetGrpPlans requestGrpReachRatioField (boolean value) {
      this.requestField("grp_reach_ratio", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpStatusField () {
      return this.requestGrpStatusField(true);
    }
    public APIRequestGetGrpPlans requestGrpStatusField (boolean value) {
      this.requestField("grp_status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetGrpPlans requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestImpressionCurveField () {
      return this.requestImpressionCurveField(true);
    }
    public APIRequestGetGrpPlans requestImpressionCurveField (boolean value) {
      this.requestField("impression_curve", value);
      return this;
    }
    public APIRequestGetGrpPlans requestInstagramDestinationIdField () {
      return this.requestInstagramDestinationIdField(true);
    }
    public APIRequestGetGrpPlans requestInstagramDestinationIdField (boolean value) {
      this.requestField("instagram_destination_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestInstreamPackagesField () {
      return this.requestInstreamPackagesField(true);
    }
    public APIRequestGetGrpPlans requestInstreamPackagesField (boolean value) {
      this.requestField("instream_packages", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapField () {
      return this.requestIntervalFrequencyCapField(true);
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapField (boolean value) {
      this.requestField("interval_frequency_cap", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapResetPeriodField () {
      return this.requestIntervalFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapResetPeriodField (boolean value) {
      this.requestField("interval_frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsBonusMediaField () {
      return this.requestIsBonusMediaField(true);
    }
    public APIRequestGetGrpPlans requestIsBonusMediaField (boolean value) {
      this.requestField("is_bonus_media", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsConversionGoalField () {
      return this.requestIsConversionGoalField(true);
    }
    public APIRequestGetGrpPlans requestIsConversionGoalField (boolean value) {
      this.requestField("is_conversion_goal", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsHigherAverageFrequencyField () {
      return this.requestIsHigherAverageFrequencyField(true);
    }
    public APIRequestGetGrpPlans requestIsHigherAverageFrequencyField (boolean value) {
      this.requestField("is_higher_average_frequency", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsIoField () {
      return this.requestIsIoField(true);
    }
    public APIRequestGetGrpPlans requestIsIoField (boolean value) {
      this.requestField("is_io", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsReservedBuyingField () {
      return this.requestIsReservedBuyingField(true);
    }
    public APIRequestGetGrpPlans requestIsReservedBuyingField (boolean value) {
      this.requestField("is_reserved_buying", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsTrpField () {
      return this.requestIsTrpField(true);
    }
    public APIRequestGetGrpPlans requestIsTrpField (boolean value) {
      this.requestField("is_trp", value);
      return this;
    }
    public APIRequestGetGrpPlans requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetGrpPlans requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetGrpPlans requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetGrpPlans requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetGrpPlans requestObjectiveNameField () {
      return this.requestObjectiveNameField(true);
    }
    public APIRequestGetGrpPlans requestObjectiveNameField (boolean value) {
      this.requestField("objective_name", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPausePeriodsField () {
      return this.requestPausePeriodsField(true);
    }
    public APIRequestGetGrpPlans requestPausePeriodsField (boolean value) {
      this.requestField("pause_periods", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownField () {
      return this.requestPlacementBreakdownField(true);
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownField (boolean value) {
      this.requestField("placement_breakdown", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownMapField () {
      return this.requestPlacementBreakdownMapField(true);
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownMapField (boolean value) {
      this.requestField("placement_breakdown_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPlanNameField () {
      return this.requestPlanNameField(true);
    }
    public APIRequestGetGrpPlans requestPlanNameField (boolean value) {
      this.requestField("plan_name", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPlanTypeField () {
      return this.requestPlanTypeField(true);
    }
    public APIRequestGetGrpPlans requestPlanTypeField (boolean value) {
      this.requestField("plan_type", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGetGrpPlans requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGetGrpPlans requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGetGrpPlans requestReferenceIdField () {
      return this.requestReferenceIdField(true);
    }
    public APIRequestGetGrpPlans requestReferenceIdField (boolean value) {
      this.requestField("reference_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGetGrpPlans requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetGrpPlans requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetGrpPlans requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetCpmField () {
      return this.requestTargetCpmField(true);
    }
    public APIRequestGetGrpPlans requestTargetCpmField (boolean value) {
      this.requestField("target_cpm", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGetGrpPlans requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetGrpPlans requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetGrpPlans requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetGrpPlans requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGetGrpPlans requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTvViewerClusterMapField () {
      return this.requestTvViewerClusterMapField(true);
    }
    public APIRequestGetGrpPlans requestTvViewerClusterMapField (boolean value) {
      this.requestField("tv_viewer_cluster_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestVideoViewBenchmarkMapField () {
      return this.requestVideoViewBenchmarkMapField(true);
    }
    public APIRequestGetGrpPlans requestVideoViewBenchmarkMapField (boolean value) {
      this.requestField("video_view_benchmark_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestVideoViewLengthConstraintField () {
      return this.requestVideoViewLengthConstraintField(true);
    }
    public APIRequestGetGrpPlans requestVideoViewLengthConstraintField (boolean value) {
      this.requestField("video_view_length_constraint", value);
      return this;
    }
    public APIRequestGetGrpPlans requestViewtagField () {
      return this.requestViewtagField(true);
    }
    public APIRequestGetGrpPlans requestViewtagField (boolean value) {
      this.requestField("viewtag", value);
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
    public APINodeList<BusinessAssetSharingAgreement> parseResponse(String response) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAssetSharingAgreement>>() {
           public APINodeList<BusinessAssetSharingAgreement> apply(String result) {
             try {
               return APIRequestGetInitiatedAudienceSharingRequests.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetInitiatedSharingAgreements extends APIRequest<BusinessAgreement> {

    APINodeList<BusinessAgreement> lastResponse = null;
    @Override
    public APINodeList<BusinessAgreement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "receiving_business_id",
      "request_status",
    };

    public static final String[] FIELDS = {
      "id",
      "request_status",
    };

    @Override
    public APINodeList<BusinessAgreement> parseResponse(String response) throws APIException {
      return BusinessAgreement.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAgreement> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAgreement>>() {
           public APINodeList<BusinessAgreement> apply(String result) {
             try {
               return APIRequestGetInitiatedSharingAgreements.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInitiatedSharingAgreements(String nodeId, APIContext context) {
      super(context, nodeId, "/initiated_sharing_agreements", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInitiatedSharingAgreements setReceivingBusinessId (String receivingBusinessId) {
      this.setParam("receiving_business_id", receivingBusinessId);
      return this;
    }

    public APIRequestGetInitiatedSharingAgreements setRequestStatus (BusinessAgreement.EnumRequestStatus requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }
    public APIRequestGetInitiatedSharingAgreements setRequestStatus (String requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }

    public APIRequestGetInitiatedSharingAgreements requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInitiatedSharingAgreements requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInitiatedSharingAgreements requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInitiatedSharingAgreements requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInitiatedSharingAgreements requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInitiatedSharingAgreements requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetInitiatedSharingAgreements requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteInstagramAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestCreateManagedBusiness extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "vertical",
      "timezone_id",
      "survey_business_type",
      "survey_num_people",
      "survey_num_assets",
      "sales_rep_email",
      "existing_client_business_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateManagedBusiness.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateManagedBusiness(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_businesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateManagedBusiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateManagedBusiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateManagedBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateManagedBusiness setVertical (Business.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateManagedBusiness setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateManagedBusiness setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateManagedBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateManagedBusiness setSurveyBusinessType (Business.EnumSurveyBusinessType surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }
    public APIRequestCreateManagedBusiness setSurveyBusinessType (String surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }

    public APIRequestCreateManagedBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateManagedBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }

    public APIRequestCreateManagedBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateManagedBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }

    public APIRequestCreateManagedBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateManagedBusiness setExistingClientBusinessId (Object existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }
    public APIRequestCreateManagedBusiness setExistingClientBusinessId (String existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }

    public APIRequestCreateManagedBusiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateManagedBusiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateManagedBusiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateManagedBusiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateManagedBusiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateManagedBusiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMatchedSearchApplications extends APIRequest<BusinessMatchedSearchApplicationsEdgeData> {

    APINodeList<BusinessMatchedSearchApplicationsEdgeData> lastResponse = null;
    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_store",
      "app_store_country",
      "query_term",
      "allow_incomplete_app",
    };

    public static final String[] FIELDS = {
      "app_id",
      "icon_url",
      "name",
      "search_source_store",
      "store",
      "unique_id",
      "url",
      "id",
    };

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> parseResponse(String response) throws APIException {
      return BusinessMatchedSearchApplicationsEdgeData.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessMatchedSearchApplicationsEdgeData>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessMatchedSearchApplicationsEdgeData>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessMatchedSearchApplicationsEdgeData>>() {
           public APINodeList<BusinessMatchedSearchApplicationsEdgeData> apply(String result) {
             try {
               return APIRequestGetMatchedSearchApplications.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMatchedSearchApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/matched_search_applications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMatchedSearchApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMatchedSearchApplications setAppStore (BusinessMatchedSearchApplicationsEdgeData.EnumAppStore appStore) {
      this.setParam("app_store", appStore);
      return this;
    }
    public APIRequestGetMatchedSearchApplications setAppStore (String appStore) {
      this.setParam("app_store", appStore);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setAppStoreCountry (String appStoreCountry) {
      this.setParam("app_store_country", appStoreCountry);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setQueryTerm (String queryTerm) {
      this.setParam("query_term", queryTerm);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setAllowIncompleteApp (Boolean allowIncompleteApp) {
      this.setParam("allow_incomplete_app", allowIncompleteApp);
      return this;
    }
    public APIRequestGetMatchedSearchApplications setAllowIncompleteApp (String allowIncompleteApp) {
      this.setParam("allow_incomplete_app", allowIncompleteApp);
      return this;
    }

    public APIRequestGetMatchedSearchApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMatchedSearchApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMatchedSearchApplications requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetMatchedSearchApplications requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetMatchedSearchApplications requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMatchedSearchApplications requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestSearchSourceStoreField () {
      return this.requestSearchSourceStoreField(true);
    }
    public APIRequestGetMatchedSearchApplications requestSearchSourceStoreField (boolean value) {
      this.requestField("search_source_store", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestStoreField () {
      return this.requestStoreField(true);
    }
    public APIRequestGetMatchedSearchApplications requestStoreField (boolean value) {
      this.requestField("store", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestUniqueIdField () {
      return this.requestUniqueIdField(true);
    }
    public APIRequestGetMatchedSearchApplications requestUniqueIdField (boolean value) {
      this.requestField("unique_id", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetMatchedSearchApplications requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMatchedSearchApplications requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetMeasurementReports extends APIRequest<MeasurementReport> {

    APINodeList<MeasurementReport> lastResponse = null;
    @Override
    public APINodeList<MeasurementReport> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "report_type",
      "filters",
    };

    public static final String[] FIELDS = {
      "download_urls",
      "id",
      "metadata",
      "report_type",
      "status",
      "upload_urls",
    };

    @Override
    public APINodeList<MeasurementReport> parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<MeasurementReport> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<MeasurementReport> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<MeasurementReport>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<MeasurementReport>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<MeasurementReport>>() {
           public APINodeList<MeasurementReport> apply(String result) {
             try {
               return APIRequestGetMeasurementReports.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMeasurementReports(String nodeId, APIContext context) {
      super(context, nodeId, "/measurement_reports", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMeasurementReports setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMeasurementReports setReportType (MeasurementReport.EnumReportType reportType) {
      this.setParam("report_type", reportType);
      return this;
    }
    public APIRequestGetMeasurementReports setReportType (String reportType) {
      this.setParam("report_type", reportType);
      return this;
    }

    public APIRequestGetMeasurementReports setFilters (List<Object> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestGetMeasurementReports setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestGetMeasurementReports requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMeasurementReports requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMeasurementReports requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMeasurementReports requestDownloadUrlsField () {
      return this.requestDownloadUrlsField(true);
    }
    public APIRequestGetMeasurementReports requestDownloadUrlsField (boolean value) {
      this.requestField("download_urls", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMeasurementReports requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGetMeasurementReports requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestReportTypeField () {
      return this.requestReportTypeField(true);
    }
    public APIRequestGetMeasurementReports requestReportTypeField (boolean value) {
      this.requestField("report_type", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetMeasurementReports requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestUploadUrlsField () {
      return this.requestUploadUrlsField(true);
    }
    public APIRequestGetMeasurementReports requestUploadUrlsField (boolean value) {
      this.requestField("upload_urls", value);
      return this;
    }
  }

  public static class APIRequestCreateMeasurementReport extends APIRequest<MeasurementReport> {

    MeasurementReport lastResponse = null;
    @Override
    public MeasurementReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "report_type",
      "metadata",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MeasurementReport parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MeasurementReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementReport execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MeasurementReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MeasurementReport>() {
           public MeasurementReport apply(String result) {
             try {
               return APIRequestCreateMeasurementReport.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMeasurementReport(String nodeId, APIContext context) {
      super(context, nodeId, "/measurement_reports", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMeasurementReport setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMeasurementReport setReportType (MeasurementReport.EnumReportType reportType) {
      this.setParam("report_type", reportType);
      return this;
    }
    public APIRequestCreateMeasurementReport setReportType (String reportType) {
      this.setParam("report_type", reportType);
      return this;
    }

    public APIRequestCreateMeasurementReport setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestCreateMeasurementReport requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMeasurementReport requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMeasurementReport requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "attribute_stats",
      "business",
      "config",
      "creation_time",
      "data_origin",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "id",
      "is_mta_use",
      "is_restricted_use",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "matched_unique_users",
      "name",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<OfflineConversionDataSet> parseResponse(String response) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OfflineConversionDataSet>>() {
           public APINodeList<OfflineConversionDataSet> apply(String result) {
             try {
               return APIRequestGetOfflineConversionDataSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGetOfflineConversionDataSets requestAttributeStatsField () {
      return this.requestAttributeStatsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestAttributeStatsField (boolean value) {
      this.requestField("attribute_stats", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestBusinessField (boolean value) {
      this.requestField("business", value);
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
    public APIRequestGetOfflineConversionDataSets requestDataOriginField () {
      return this.requestDataOriginField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDataOriginField (boolean value) {
      this.requestField("data_origin", value);
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
    public APIRequestGetOfflineConversionDataSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetOfflineConversionDataSets requestMatchedUniqueUsersField () {
      return this.requestMatchedUniqueUsersField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestMatchedUniqueUsersField (boolean value) {
      this.requestField("matched_unique_users", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestNameField (boolean value) {
      this.requestField("name", value);
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

  public static class APIRequestCreateOfflineConversionDataSet extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "description",
      "data_origin",
      "enable_auto_assign_to_accounts",
      "is_mta_use",
      "auto_assign_to_new_accounts_only",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OfflineConversionDataSet parseResponse(String response) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OfflineConversionDataSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OfflineConversionDataSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OfflineConversionDataSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OfflineConversionDataSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OfflineConversionDataSet>() {
           public OfflineConversionDataSet apply(String result) {
             try {
               return APIRequestCreateOfflineConversionDataSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOfflineConversionDataSet(String nodeId, APIContext context) {
      super(context, nodeId, "/offline_conversion_data_sets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOfflineConversionDataSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setDataOrigin (OfflineConversionDataSet.EnumDataOrigin dataOrigin) {
      this.setParam("data_origin", dataOrigin);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setDataOrigin (String dataOrigin) {
      this.setParam("data_origin", dataOrigin);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setEnableAutoAssignToAccounts (Boolean enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setEnableAutoAssignToAccounts (String enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setIsMtaUse (Boolean isMtaUse) {
      this.setParam("is_mta_use", isMtaUse);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setIsMtaUse (String isMtaUse) {
      this.setParam("is_mta_use", isMtaUse);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (Boolean autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (String autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOfflineConversionDataSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOfFLineTermsOfService extends APIRequest<OfflineTermsOfService> {

    APINodeList<OfflineTermsOfService> lastResponse = null;
    @Override
    public APINodeList<OfflineTermsOfService> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "accept_time",
      "id",
      "signed_by_user",
    };

    @Override
    public APINodeList<OfflineTermsOfService> parseResponse(String response) throws APIException {
      return OfflineTermsOfService.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OfflineTermsOfService> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OfflineTermsOfService> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OfflineTermsOfService>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OfflineTermsOfService>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OfflineTermsOfService>>() {
           public APINodeList<OfflineTermsOfService> apply(String result) {
             try {
               return APIRequestGetOfFLineTermsOfService.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOfFLineTermsOfService(String nodeId, APIContext context) {
      super(context, nodeId, "/offline_terms_of_service", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOfFLineTermsOfService setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOfFLineTermsOfService setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOfFLineTermsOfService requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOfFLineTermsOfService requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfFLineTermsOfService requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOfFLineTermsOfService requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfFLineTermsOfService requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOfFLineTermsOfService requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOfFLineTermsOfService requestAcceptTimeField () {
      return this.requestAcceptTimeField(true);
    }
    public APIRequestGetOfFLineTermsOfService requestAcceptTimeField (boolean value) {
      this.requestField("accept_time", value);
      return this;
    }
    public APIRequestGetOfFLineTermsOfService requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOfFLineTermsOfService requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOfFLineTermsOfService requestSignedByUserField () {
      return this.requestSignedByUserField(true);
    }
    public APIRequestGetOfFLineTermsOfService requestSignedByUserField (boolean value) {
      this.requestField("signed_by_user", value);
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
      "daily_spend_limit",
      "direct_deals_tos_accepted",
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
      "extended_credit_invoice_group",
      "failed_delivery_checks",
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
      "rate_limit_reset_time",
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
    public APINodeList<AdAccount> parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccount>>() {
           public APINodeList<AdAccount> apply(String result) {
             try {
               return APIRequestGetOwnedAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetOwnedAdAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
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
    public APIRequestGetOwnedAdAccounts requestDailySpendLimitField () {
      return this.requestDailySpendLimitField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDailySpendLimitField (boolean value) {
      this.requestField("daily_spend_limit", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDirectDealsTosAcceptedField () {
      return this.requestDirectDealsTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDirectDealsTosAcceptedField (boolean value) {
      this.requestField("direct_deals_tos_accepted", value);
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
    public APIRequestGetOwnedAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
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
    public APIRequestGetOwnedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
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
    public APIRequestGetOwnedAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateOwnedAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "business",
      "canvas_fluid_height",
      "canvas_fluid_width",
      "canvas_url",
      "category",
      "client_config",
      "company",
      "configured_ios_sso",
      "contact_email",
      "context",
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
      "is_viewer_admin",
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
    public APINodeList<Application> parseResponse(String response) throws APIException {
      return Application.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Application> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Application> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Application>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Application>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Application>>() {
           public APINodeList<Application> apply(String result) {
             try {
               return APIRequestGetOwnedApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetOwnedApps requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetOwnedApps requestContextField (boolean value) {
      this.requestField("context", value);
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
    public APIRequestGetOwnedApps requestIsViewerAdminField () {
      return this.requestIsViewerAdminField(true);
    }
    public APIRequestGetOwnedApps requestIsViewerAdminField (boolean value) {
      this.requestField("is_viewer_admin", value);
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
    public APIRequestGetOwnedApps requestLoginSecretField () {
      return this.requestLoginSecretField(true);
    }
    public APIRequestGetOwnedApps requestLoginSecretField (boolean value) {
      this.requestField("login_secret", value);
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateOwnedApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteOwnedBusinesses.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestDeleteOwnedBusinesses setClientId (Object clientId) {
      this.setParam("client_id", clientId);
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
      "client_user_id",
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
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetOwnedBusinesses.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetOwnedBusinesses setClientUserId (Object clientUserId) {
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
    public APIRequestGetOwnedBusinesses requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetOwnedBusinesses requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
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
      "name",
      "vertical",
      "timezone_id",
      "survey_business_type",
      "survey_num_people",
      "survey_num_assets",
      "sales_rep_email",
      "shared_page_id",
      "page_permitted_roles",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateOwnedBusiness.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateOwnedBusiness setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateOwnedBusiness setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateOwnedBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
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

    public APIRequestCreateOwnedBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
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

    public APIRequestCreateOwnedBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSharedPageId (Object sharedPageId) {
      this.setParam("shared_page_id", sharedPageId);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSharedPageId (String sharedPageId) {
      this.setParam("shared_page_id", sharedPageId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setPagePermittedRoles (List<Business.EnumPagePermittedRoles> pagePermittedRoles) {
      this.setParam("page_permitted_roles", pagePermittedRoles);
      return this;
    }
    public APIRequestCreateOwnedBusiness setPagePermittedRoles (String pagePermittedRoles) {
      this.setParam("page_permitted_roles", pagePermittedRoles);
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

  public static class APIRequestGetOwnedCustomConversions extends APIRequest<CustomConversion> {

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
      "last_fired_time",
      "name",
      "offline_conversion_data_set",
      "pixel",
      "retention_days",
      "rule",
    };

    @Override
    public APINodeList<CustomConversion> parseResponse(String response) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomConversion> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversion> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CustomConversion>>() {
           public APINodeList<CustomConversion> apply(String result) {
             try {
               return APIRequestGetOwnedCustomConversions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedCustomConversions(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_custom_conversions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedCustomConversions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedCustomConversions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedCustomConversions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedCustomConversions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedCustomConversions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedCustomConversions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedCustomConversions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedCustomConversions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedCustomConversions requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetOwnedCustomConversions requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestAggregationRuleField () {
      return this.requestAggregationRuleField(true);
    }
    public APIRequestGetOwnedCustomConversions requestAggregationRuleField (boolean value) {
      this.requestField("aggregation_rule", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedCustomConversions requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOwnedCustomConversions requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestCustomEventTypeField () {
      return this.requestCustomEventTypeField(true);
    }
    public APIRequestGetOwnedCustomConversions requestCustomEventTypeField (boolean value) {
      this.requestField("custom_event_type", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestDataSourcesField () {
      return this.requestDataSourcesField(true);
    }
    public APIRequestGetOwnedCustomConversions requestDataSourcesField (boolean value) {
      this.requestField("data_sources", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestDefaultConversionValueField () {
      return this.requestDefaultConversionValueField(true);
    }
    public APIRequestGetOwnedCustomConversions requestDefaultConversionValueField (boolean value) {
      this.requestField("default_conversion_value", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOwnedCustomConversions requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestEventSourceTypeField () {
      return this.requestEventSourceTypeField(true);
    }
    public APIRequestGetOwnedCustomConversions requestEventSourceTypeField (boolean value) {
      this.requestField("event_source_type", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestFirstFiredTimeField () {
      return this.requestFirstFiredTimeField(true);
    }
    public APIRequestGetOwnedCustomConversions requestFirstFiredTimeField (boolean value) {
      this.requestField("first_fired_time", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedCustomConversions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestIsArchivedField () {
      return this.requestIsArchivedField(true);
    }
    public APIRequestGetOwnedCustomConversions requestIsArchivedField (boolean value) {
      this.requestField("is_archived", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOwnedCustomConversions requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedCustomConversions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestOfflineConversionDataSetField () {
      return this.requestOfflineConversionDataSetField(true);
    }
    public APIRequestGetOwnedCustomConversions requestOfflineConversionDataSetField (boolean value) {
      this.requestField("offline_conversion_data_set", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGetOwnedCustomConversions requestPixelField (boolean value) {
      this.requestField("pixel", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGetOwnedCustomConversions requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGetOwnedCustomConversions requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGetOwnedCustomConversions requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
  }

  public static class APIRequestGetOwnedDomains extends APIRequest<OwnedDomain> {

    APINodeList<OwnedDomain> lastResponse = null;
    @Override
    public APINodeList<OwnedDomain> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "domain_name",
      "id",
    };

    @Override
    public APINodeList<OwnedDomain> parseResponse(String response) throws APIException {
      return OwnedDomain.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OwnedDomain> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OwnedDomain> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OwnedDomain>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OwnedDomain>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OwnedDomain>>() {
           public APINodeList<OwnedDomain> apply(String result) {
             try {
               return APIRequestGetOwnedDomains.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedDomains(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_domains", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedDomains setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedDomains setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedDomains requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedDomains requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedDomains requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedDomains requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedDomains requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedDomains requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedDomains requestDomainNameField () {
      return this.requestDomainNameField(true);
    }
    public APIRequestGetOwnedDomains requestDomainNameField (boolean value) {
      this.requestField("domain_name", value);
      return this;
    }
    public APIRequestGetOwnedDomains requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedDomains requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedDomain extends APIRequest<OwnedDomain> {

    OwnedDomain lastResponse = null;
    @Override
    public OwnedDomain getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "domain_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OwnedDomain parseResponse(String response) throws APIException {
      return OwnedDomain.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OwnedDomain execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OwnedDomain execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OwnedDomain> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OwnedDomain> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OwnedDomain>() {
           public OwnedDomain apply(String result) {
             try {
               return APIRequestCreateOwnedDomain.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedDomain(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_domains", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedDomain setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedDomain setDomainName (String domainName) {
      this.setParam("domain_name", domainName);
      return this;
    }

    public APIRequestCreateOwnedDomain requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedDomain requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedDomain requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
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
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetOwnedPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetOwnedPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetOwnedPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
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
    public APIRequestGetOwnedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetOwnedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetOwnedPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetOwnedPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetOwnedPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
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
    public APIRequestGetOwnedPages requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetOwnedPages requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
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
    public APIRequestGetOwnedPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetOwnedPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
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
    public APIRequestGetOwnedPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
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
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
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
    public APIRequestGetOwnedPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetOwnedPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
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
    public APIRequestGetOwnedPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetOwnedPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
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
      "page_id",
      "ig_password",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateOwnedPage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateOwnedPage setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreateOwnedPage setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreateOwnedPage setIgPassword (String igPassword) {
      this.setParam("ig_password", igPassword);
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
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetOwnedPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetOwnedPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetOwnedPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
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
      "business",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "flight_catalog_settings",
      "id",
      "image_padding_landscape",
      "image_padding_square",
      "name",
      "product_count",
      "qualified_product_count",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(String result) {
             try {
               return APIRequestGetOwnedProductCatalogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGetOwnedProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
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
    public APIRequestGetOwnedProductCatalogs requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestImagePaddingLandscapeField () {
      return this.requestImagePaddingLandscapeField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestImagePaddingLandscapeField (boolean value) {
      this.requestField("image_padding_landscape", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestImagePaddingSquareField () {
      return this.requestImagePaddingSquareField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestImagePaddingSquareField (boolean value) {
      this.requestField("image_padding_square", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
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
      "name",
      "vertical",
      "flight_catalog_settings",
      "destination_catalog_settings",
      "da_display_settings",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateOwnedProductCatalog.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateOwnedProductCatalog setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (Map<String, String> flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (String flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
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

    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
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
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeletePages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestCreatePage extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_id",
      "access_type",
      "permitted_roles",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreatePage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePage(String nodeId, APIContext context) {
      super(context, nodeId, "/pages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePage setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreatePage setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreatePage setAccessType (Business.EnumAccessType accessType) {
      this.setParam("access_type", accessType);
      return this;
    }
    public APIRequestCreatePage setAccessType (String accessType) {
      this.setParam("access_type", accessType);
      return this;
    }

    public APIRequestCreatePage setPermittedRoles (List<Business.EnumPermittedRoles> permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }
    public APIRequestCreatePage setPermittedRoles (String permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreatePage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPartnerIntegrations extends APIRequest<PartnerIntegrationLinked> {

    APINodeList<PartnerIntegrationLinked> lastResponse = null;
    @Override
    public APINodeList<PartnerIntegrationLinked> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ads_pixel",
      "application",
      "completed_integration_types",
      "external_id",
      "has_oauth_token",
      "id",
      "name",
      "offline_conversion_data_set",
      "partner",
      "partner_profile",
      "product_catalog",
      "setup_status",
    };

    @Override
    public APINodeList<PartnerIntegrationLinked> parseResponse(String response) throws APIException {
      return PartnerIntegrationLinked.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PartnerIntegrationLinked> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PartnerIntegrationLinked> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PartnerIntegrationLinked>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PartnerIntegrationLinked>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PartnerIntegrationLinked>>() {
           public APINodeList<PartnerIntegrationLinked> apply(String result) {
             try {
               return APIRequestGetPartnerIntegrations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPartnerIntegrations(String nodeId, APIContext context) {
      super(context, nodeId, "/partner_integrations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartnerIntegrations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartnerIntegrations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerIntegrations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerIntegrations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerIntegrations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartnerIntegrations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerIntegrations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartnerIntegrations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerIntegrations requestAdsPixelField () {
      return this.requestAdsPixelField(true);
    }
    public APIRequestGetPartnerIntegrations requestAdsPixelField (boolean value) {
      this.requestField("ads_pixel", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPartnerIntegrations requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestCompletedIntegrationTypesField () {
      return this.requestCompletedIntegrationTypesField(true);
    }
    public APIRequestGetPartnerIntegrations requestCompletedIntegrationTypesField (boolean value) {
      this.requestField("completed_integration_types", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestExternalIdField () {
      return this.requestExternalIdField(true);
    }
    public APIRequestGetPartnerIntegrations requestExternalIdField (boolean value) {
      this.requestField("external_id", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestHasOauthTokenField () {
      return this.requestHasOauthTokenField(true);
    }
    public APIRequestGetPartnerIntegrations requestHasOauthTokenField (boolean value) {
      this.requestField("has_oauth_token", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerIntegrations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartnerIntegrations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestOfflineConversionDataSetField () {
      return this.requestOfflineConversionDataSetField(true);
    }
    public APIRequestGetPartnerIntegrations requestOfflineConversionDataSetField (boolean value) {
      this.requestField("offline_conversion_data_set", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetPartnerIntegrations requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestPartnerProfileField () {
      return this.requestPartnerProfileField(true);
    }
    public APIRequestGetPartnerIntegrations requestPartnerProfileField (boolean value) {
      this.requestField("partner_profile", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetPartnerIntegrations requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGetPartnerIntegrations requestSetupStatusField () {
      return this.requestSetupStatusField(true);
    }
    public APIRequestGetPartnerIntegrations requestSetupStatusField (boolean value) {
      this.requestField("setup_status", value);
      return this;
    }
  }

  public static class APIRequestCreatePartnerIntegration extends APIRequest<PartnerIntegrationLinked> {

    PartnerIntegrationLinked lastResponse = null;
    @Override
    public PartnerIntegrationLinked getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_id",
      "gtm_account_id",
      "gtm_container_id",
      "name",
      "partner",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PartnerIntegrationLinked parseResponse(String response) throws APIException {
      return PartnerIntegrationLinked.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PartnerIntegrationLinked execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerIntegrationLinked execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PartnerIntegrationLinked> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerIntegrationLinked> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PartnerIntegrationLinked>() {
           public PartnerIntegrationLinked apply(String result) {
             try {
               return APIRequestCreatePartnerIntegration.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePartnerIntegration(String nodeId, APIContext context) {
      super(context, nodeId, "/partner_integrations", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePartnerIntegration setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePartnerIntegration setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePartnerIntegration setExternalId (String externalId) {
      this.setParam("external_id", externalId);
      return this;
    }

    public APIRequestCreatePartnerIntegration setGtmAccountId (String gtmAccountId) {
      this.setParam("gtm_account_id", gtmAccountId);
      return this;
    }

    public APIRequestCreatePartnerIntegration setGtmContainerId (String gtmContainerId) {
      this.setParam("gtm_container_id", gtmContainerId);
      return this;
    }

    public APIRequestCreatePartnerIntegration setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePartnerIntegration setPartner (PartnerIntegrationLinked.EnumPartner partner) {
      this.setParam("partner", partner);
      return this;
    }
    public APIRequestCreatePartnerIntegration setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestCreatePartnerIntegration requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePartnerIntegration requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerIntegration requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePartnerIntegration requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerIntegration requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePartnerIntegration requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePartnerAdAccount extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "currency",
      "timezone_id",
      "end_advertiser",
      "funding_id",
      "media_agency",
      "partner",
      "invoice",
      "po_number",
      "io",
      "billing_address_id",
      "sold_to_address_id",
      "liable_address_id",
      "invoice_group_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreatePartnerAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePartnerAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/partneradaccount", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePartnerAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePartnerAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePartnerAdAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setEndAdvertiser (Object endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setFundingId (String fundingId) {
      this.setParam("funding_id", fundingId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setInvoice (Boolean invoice) {
      this.setParam("invoice", invoice);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setInvoice (String invoice) {
      this.setParam("invoice", invoice);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setPoNumber (String poNumber) {
      this.setParam("po_number", poNumber);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setIo (Boolean io) {
      this.setParam("io", io);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setIo (String io) {
      this.setParam("io", io);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setBillingAddressId (Object billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setBillingAddressId (String billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setSoldToAddressId (Object soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setSoldToAddressId (String soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setLiableAddressId (Object liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setLiableAddressId (String liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount setInvoiceGroupId (Object invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }
    public APIRequestCreatePartnerAdAccount setInvoiceGroupId (String invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }

    public APIRequestCreatePartnerAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePartnerAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePartnerAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePartnerAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePartnerAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPartners extends APIRequest<Business> {

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
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetPartners.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPartners(String nodeId, APIContext context) {
      super(context, nodeId, "/partners", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartners setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartners setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartners requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartners requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartners requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetPartners requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPartners requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPartners requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPartners requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetPartners requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetPartners requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartners requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartners requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPartners requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPartners requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetPartners requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
      return this;
    }
    public APIRequestGetPartners requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPartners requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPartners requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartners requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartners requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetPartners requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetPartners requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetPartners requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetPartners requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetPartners requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetPartners requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetPartners requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPartners requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPartners requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPartners requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetPartners requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetPartners requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetPartners requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetPartners requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetPartners requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
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
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAdAccountRequest>>() {
           public APINodeList<BusinessAdAccountRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APINodeList<BusinessApplicationRequest> parseResponse(String response) throws APIException {
      return BusinessApplicationRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessApplicationRequest>>() {
           public APINodeList<BusinessApplicationRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetPendingOfflineConversionDataSets extends APIRequest<OfflineConversionDataSet> {

    APINodeList<OfflineConversionDataSet> lastResponse = null;
    @Override
    public APINodeList<OfflineConversionDataSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribute_stats",
      "business",
      "config",
      "creation_time",
      "data_origin",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "id",
      "is_mta_use",
      "is_restricted_use",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "matched_unique_users",
      "name",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<OfflineConversionDataSet> parseResponse(String response) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OfflineConversionDataSet>>() {
           public APINodeList<OfflineConversionDataSet> apply(String result) {
             try {
               return APIRequestGetPendingOfflineConversionDataSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingOfflineConversionDataSets(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_offline_conversion_data_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingOfflineConversionDataSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingOfflineConversionDataSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingOfflineConversionDataSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingOfflineConversionDataSets requestAttributeStatsField () {
      return this.requestAttributeStatsField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestAttributeStatsField (boolean value) {
      this.requestField("attribute_stats", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDataOriginField () {
      return this.requestDataOriginField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDataOriginField (boolean value) {
      this.requestField("data_origin", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchedUniqueUsersField () {
      return this.requestMatchedUniqueUsersField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestMatchedUniqueUsersField (boolean value) {
      this.requestField("matched_unique_users", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetPendingOfflineConversionDataSets requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetPendingOfflineConversionDataSets requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetPendingOwnedAdAccounts extends APIRequest<LegacyBusinessAdAccountRequest> {

    APINodeList<LegacyBusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account",
      "id",
      "permitted_roles",
    };

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return LegacyBusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LegacyBusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LegacyBusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LegacyBusinessAdAccountRequest>>() {
           public APINodeList<LegacyBusinessAdAccountRequest> apply(String result) {
             try {
               return APIRequestGetPendingOwnedAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetPendingOwnedAdAccounts requestPermittedRolesField () {
      return this.requestPermittedRolesField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestPermittedRolesField (boolean value) {
      this.requestField("permitted_roles", value);
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
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(String result) {
             try {
               return APIRequestGetPendingOwnedPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetPendingShareDPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetPendingShareDPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingShareDPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_shared_pixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingShareDPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingShareDPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingShareDPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingShareDPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingShareDPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetPendingShareDPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetPendingShareDPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetPendingShareDPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetPendingShareDPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGetPendingShareDPixels requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetPendingShareDPixels requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingShareDPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetPendingShareDPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetPendingShareDPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPendingShareDPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetPendingShareDPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetPendingShareDPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetPendingShareDPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
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
    public APINodeList<BusinessRoleRequest> parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessRoleRequest>>() {
           public APINodeList<BusinessRoleRequest> apply(String result) {
             try {
               return APIRequestGetPendingUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "width",
      "type",
      "redirect",
    };

    public static final String[] FIELDS = {
      "bottom",
      "cache_key",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "uri",
      "url",
      "width",
      "id",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProfilePictureSource>>() {
           public APINodeList<ProfilePictureSource> apply(String result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGetPicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPicture setWidth (String width) {
      this.setParam("width", width);
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

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }
    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
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
    public APIRequestGetPicture requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGetPicture requestUriField (boolean value) {
      this.requestField("uri", value);
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
    public APIRequestGetPicture requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPicture requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateProductCatalog extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "vertical",
      "flight_catalog_settings",
      "destination_catalog_settings",
      "da_display_settings",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateProductCatalog.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductCatalog(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductCatalog setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductCatalog setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateProductCatalog setVertical (ProductCatalog.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateProductCatalog setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateProductCatalog setFlightCatalogSettings (Map<String, String> flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }
    public APIRequestCreateProductCatalog setFlightCatalogSettings (String flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }

    public APIRequestCreateProductCatalog setDestinationCatalogSettings (Map<String, String> destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }
    public APIRequestCreateProductCatalog setDestinationCatalogSettings (String destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }

    public APIRequestCreateProductCatalog setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestCreateProductCatalog setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }

    public APIRequestCreateProductCatalog requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductCatalog requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductCatalog requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetReceivedAudiencePermissions extends APIRequest<AudiencePermission> {

    APINodeList<AudiencePermission> lastResponse = null;
    @Override
    public APINodeList<AudiencePermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_id",
    };

    public static final String[] FIELDS = {
      "audience",
      "share_account_id",
      "share_account_name",
      "id",
    };

    @Override
    public APINodeList<AudiencePermission> parseResponse(String response) throws APIException {
      return AudiencePermission.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudiencePermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudiencePermission> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudiencePermission>>() {
           public APINodeList<AudiencePermission> apply(String result) {
             try {
               return APIRequestGetReceivedAudiencePermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReceivedAudiencePermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/received_audience_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReceivedAudiencePermissions setPartnerId (String partnerId) {
      this.setParam("partner_id", partnerId);
      return this;
    }

    public APIRequestGetReceivedAudiencePermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReceivedAudiencePermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReceivedAudiencePermissions requestAudienceField () {
      return this.requestAudienceField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestAudienceField (boolean value) {
      this.requestField("audience", value);
      return this;
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountIdField () {
      return this.requestShareAccountIdField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountIdField (boolean value) {
      this.requestField("share_account_id", value);
      return this;
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountNameField () {
      return this.requestShareAccountNameField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountNameField (boolean value) {
      this.requestField("share_account_name", value);
      return this;
    }
    public APIRequestGetReceivedAudiencePermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APINodeList<BusinessAssetSharingAgreement> parseResponse(String response) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAssetSharingAgreement> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAssetSharingAgreement>>() {
           public APINodeList<BusinessAssetSharingAgreement> apply(String result) {
             try {
               return APIRequestGetReceivedAudienceSharingRequests.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetReceivedSharingAgreements extends APIRequest<BusinessAgreement> {

    APINodeList<BusinessAgreement> lastResponse = null;
    @Override
    public APINodeList<BusinessAgreement> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "requesting_business_id",
      "request_status",
    };

    public static final String[] FIELDS = {
      "id",
      "request_status",
    };

    @Override
    public APINodeList<BusinessAgreement> parseResponse(String response) throws APIException {
      return BusinessAgreement.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAgreement> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAgreement>>() {
           public APINodeList<BusinessAgreement> apply(String result) {
             try {
               return APIRequestGetReceivedSharingAgreements.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReceivedSharingAgreements(String nodeId, APIContext context) {
      super(context, nodeId, "/received_sharing_agreements", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReceivedSharingAgreements setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReceivedSharingAgreements setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReceivedSharingAgreements setRequestingBusinessId (String requestingBusinessId) {
      this.setParam("requesting_business_id", requestingBusinessId);
      return this;
    }

    public APIRequestGetReceivedSharingAgreements setRequestStatus (BusinessAgreement.EnumRequestStatus requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }
    public APIRequestGetReceivedSharingAgreements setRequestStatus (String requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }

    public APIRequestGetReceivedSharingAgreements requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReceivedSharingAgreements requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedSharingAgreements requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReceivedSharingAgreements requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedSharingAgreements requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReceivedSharingAgreements requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReceivedSharingAgreements requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReceivedSharingAgreements requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReceivedSharingAgreements requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGetReceivedSharingAgreements requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
  }

  public static class APIRequestGetShareDAudiencePermissions extends APIRequest<AudiencePermission> {

    APINodeList<AudiencePermission> lastResponse = null;
    @Override
    public APINodeList<AudiencePermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_id",
    };

    public static final String[] FIELDS = {
      "audience",
      "share_account_id",
      "share_account_name",
      "id",
    };

    @Override
    public APINodeList<AudiencePermission> parseResponse(String response) throws APIException {
      return AudiencePermission.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudiencePermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudiencePermission> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudiencePermission>>() {
           public APINodeList<AudiencePermission> apply(String result) {
             try {
               return APIRequestGetShareDAudiencePermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetShareDAudiencePermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_audience_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShareDAudiencePermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShareDAudiencePermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShareDAudiencePermissions setPartnerId (String partnerId) {
      this.setParam("partner_id", partnerId);
      return this;
    }

    public APIRequestGetShareDAudiencePermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShareDAudiencePermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAudiencePermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShareDAudiencePermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAudiencePermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShareDAudiencePermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetShareDAudiencePermissions requestAudienceField () {
      return this.requestAudienceField(true);
    }
    public APIRequestGetShareDAudiencePermissions requestAudienceField (boolean value) {
      this.requestField("audience", value);
      return this;
    }
    public APIRequestGetShareDAudiencePermissions requestShareAccountIdField () {
      return this.requestShareAccountIdField(true);
    }
    public APIRequestGetShareDAudiencePermissions requestShareAccountIdField (boolean value) {
      this.requestField("share_account_id", value);
      return this;
    }
    public APIRequestGetShareDAudiencePermissions requestShareAccountNameField () {
      return this.requestShareAccountNameField(true);
    }
    public APIRequestGetShareDAudiencePermissions requestShareAccountNameField (boolean value) {
      this.requestField("share_account_name", value);
      return this;
    }
    public APIRequestGetShareDAudiencePermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetShareDAudiencePermissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateSpacoDataSetCollection extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "spaco_data_collections",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreateSpacoDataSetCollection.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSpacoDataSetCollection(String nodeId, APIContext context) {
      super(context, nodeId, "/spaco_dataset_collections", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSpacoDataSetCollection setSpacoDataCollections (List<Object> spacoDataCollections) {
      this.setParam("spaco_data_collections", spacoDataCollections);
      return this;
    }
    public APIRequestCreateSpacoDataSetCollection setSpacoDataCollections (String spacoDataCollections) {
      this.setParam("spaco_data_collections", spacoDataCollections);
      return this;
    }

    public APIRequestCreateSpacoDataSetCollection requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSpacoDataSetCollection requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSpacoDataSetCollection requestField (String field, boolean value) {
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
    public APINodeList<SystemUser> parseResponse(String response) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<SystemUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<SystemUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<SystemUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<SystemUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<SystemUser>>() {
           public APINodeList<SystemUser> apply(String result) {
             try {
               return APIRequestGetSystemUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "role",
      "name",
      "system_user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SystemUser parseResponse(String response) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SystemUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SystemUser execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SystemUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SystemUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SystemUser>() {
           public SystemUser apply(String result) {
             try {
               return APIRequestCreateSystemUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestCreateSystemUser setRole (SystemUser.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateSystemUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateSystemUser setName (String name) {
      this.setParam("name", name);
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

  public static class APIRequestDeleteUserInvitations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteUserInvitations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserInvitations(String nodeId, APIContext context) {
      super(context, nodeId, "/user_invitations", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserInvitations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserInvitations setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserInvitations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserInvitations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserInvitations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUserInvitations extends APIRequest<BusinessRoleRequest> {

    APINodeList<BusinessRoleRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessRoleRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
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
    public APINodeList<BusinessRoleRequest> parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessRoleRequest>>() {
           public APINodeList<BusinessRoleRequest> apply(String result) {
             try {
               return APIRequestGetUserInvitations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUserInvitations(String nodeId, APIContext context) {
      super(context, nodeId, "/user_invitations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUserInvitations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUserInvitations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUserInvitations setStatus (BusinessRoleRequest.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetUserInvitations setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetUserInvitations setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestGetUserInvitations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUserInvitations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUserInvitations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUserInvitations requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetUserInvitations requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetUserInvitations requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetUserInvitations requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetUserInvitations requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetUserInvitations requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetUserInvitations requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGetUserInvitations requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestFinanceRoleField () {
      return this.requestFinanceRoleField(true);
    }
    public APIRequestGetUserInvitations requestFinanceRoleField (boolean value) {
      this.requestField("finance_role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUserInvitations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUserInvitations requestInviteLinkField () {
      return this.requestInviteLinkField(true);
    }
    public APIRequestGetUserInvitations requestInviteLinkField (boolean value) {
      this.requestField("invite_link", value);
      return this;
    }
    public APIRequestGetUserInvitations requestIpRoleField () {
      return this.requestIpRoleField(true);
    }
    public APIRequestGetUserInvitations requestIpRoleField (boolean value) {
      this.requestField("ip_role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetUserInvitations requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetUserInvitations requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUserInvitations requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetUserInvitations requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetUserInvitations requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetUserInvitations requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetUserInvitations requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetUserInvitations requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestDeleteUserPermissions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserPermissions setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteUserPermissions setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteUserPermissions setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUserPermission extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
      "role",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateUserPermission.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserPermission setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateUserPermission setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateUserPermission setRole (Business.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateUserPermission setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVietnamAdAccountCreationRequest extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address_in_local_language",
      "ad_accounts_currency",
      "credit_card_id",
      "extended_credit_id",
      "legal_entity_name_in_local_language",
      "ad_accounts_info",
      "business_registration",
      "planning_agency_business_id",
      "english_legal_entity_name",
      "address_in_english",
      "official_website_url",
      "business_registration_id",
      "vertical",
      "subvertical",
      "promotable_page_urls",
      "promotable_page_ids",
      "promotable_app_ids",
      "promotable_urls",
      "contact",
      "additional_comment",
      "is_smb",
      "is_test",
      "advertiser_business_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(String result) {
             try {
               return APIRequestCreateVietnamAdAccountCreationRequest.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVietnamAdAccountCreationRequest(String nodeId, APIContext context) {
      super(context, nodeId, "/vietnamadaccountcreationrequests", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVietnamAdAccountCreationRequest setAddressInLocalLanguage (String addressInLocalLanguage) {
      this.setParam("address_in_local_language", addressInLocalLanguage);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setAdAccountsCurrency (String adAccountsCurrency) {
      this.setParam("ad_accounts_currency", adAccountsCurrency);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setCreditCardId (Object creditCardId) {
      this.setParam("credit_card_id", creditCardId);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setCreditCardId (String creditCardId) {
      this.setParam("credit_card_id", creditCardId);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setExtendedCreditId (Object extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setExtendedCreditId (String extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setLegalEntityNameInLocalLanguage (String legalEntityNameInLocalLanguage) {
      this.setParam("legal_entity_name_in_local_language", legalEntityNameInLocalLanguage);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setAdAccountsInfo (List<Object> adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setAdAccountsInfo (String adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setBusinessRegistration (File businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setBusinessRegistration (String businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setPlanningAgencyBusinessId (Object planningAgencyBusinessId) {
      this.setParam("planning_agency_business_id", planningAgencyBusinessId);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setPlanningAgencyBusinessId (String planningAgencyBusinessId) {
      this.setParam("planning_agency_business_id", planningAgencyBusinessId);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setEnglishLegalEntityName (String englishLegalEntityName) {
      this.setParam("english_legal_entity_name", englishLegalEntityName);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setAddressInEnglish (Object addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setAddressInEnglish (String addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setOfficialWebsiteUrl (Object officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setOfficialWebsiteUrl (String officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setBusinessRegistrationId (String businessRegistrationId) {
      this.setParam("business_registration_id", businessRegistrationId);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setVertical (AdAccountCreationRequest.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setSubvertical (AdAccountCreationRequest.EnumSubvertical subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setSubvertical (String subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setPromotablePageUrls (List<Object> promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setPromotablePageUrls (String promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setPromotablePageIds (List<Long> promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setPromotablePageIds (String promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setPromotableAppIds (List<Object> promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setPromotableAppIds (String promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setPromotableUrls (List<Object> promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setPromotableUrls (String promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setContact (Object contact) {
      this.setParam("contact", contact);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setContact (String contact) {
      this.setParam("contact", contact);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setAdditionalComment (String additionalComment) {
      this.setParam("additional_comment", additionalComment);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setIsSmb (Boolean isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setIsSmb (String isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setIsTest (Boolean isTest) {
      this.setParam("is_test", isTest);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setIsTest (String isTest) {
      this.setParam("is_test", isTest);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest setAdvertiserBusinessId (Object advertiserBusinessId) {
      this.setParam("advertiser_business_id", advertiserBusinessId);
      return this;
    }
    public APIRequestCreateVietnamAdAccountCreationRequest setAdvertiserBusinessId (String advertiserBusinessId) {
      this.setParam("advertiser_business_id", advertiserBusinessId);
      return this;
    }

    public APIRequestCreateVietnamAdAccountCreationRequest requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVietnamAdAccountCreationRequest requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVietnamAdAccountCreationRequest requestField (String field, boolean value) {
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
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
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
    public APIRequestGet requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGet requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
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
      "name",
      "vertical",
      "timezone_id",
      "primary_page",
      "two_factor_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

    public APIRequestUpdate setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestUpdate setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestUpdate setPrimaryPage (String primaryPage) {
      this.setParam("primary_page", primaryPage);
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
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("admin_required")
      VALUE_ADMIN_REQUIRED("admin_required"),
      @SerializedName("all_required")
      VALUE_ALL_REQUIRED("all_required"),
      NULL(null);

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
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("RESTAURANT")
      VALUE_RESTAURANT("RESTAURANT"),
      @SerializedName("HEALTH")
      VALUE_HEALTH("HEALTH"),
      @SerializedName("LUXURY")
      VALUE_LUXURY("LUXURY"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

      private String value;

      private EnumVertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAccessType {
      @SerializedName("OWNER")
      VALUE_OWNER("OWNER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      NULL(null);

      private String value;

      private EnumAccessType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedTasks {
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("ADVERTISE")
      VALUE_ADVERTISE("ADVERTISE"),
      @SerializedName("ANALYZE")
      VALUE_ANALYZE("ANALYZE"),
      NULL(null);

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
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("APP_DEVELOPER")
      VALUE_APP_DEVELOPER("APP_DEVELOPER"),
      @SerializedName("PUBLISHER")
      VALUE_PUBLISHER("PUBLISHER"),
      NULL(null);

      private String value;

      private EnumSurveyBusinessType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPagePermittedRoles {
      @SerializedName("MANAGER")
      VALUE_MANAGER("MANAGER"),
      @SerializedName("CONTENT_CREATOR")
      VALUE_CONTENT_CREATOR("CONTENT_CREATOR"),
      @SerializedName("MODERATOR")
      VALUE_MODERATOR("MODERATOR"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("INSIGHTS_ANALYST")
      VALUE_INSIGHTS_ANALYST("INSIGHTS_ANALYST"),
      NULL(null);

      private String value;

      private EnumPagePermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedRoles {
      @SerializedName("MANAGER")
      VALUE_MANAGER("MANAGER"),
      @SerializedName("CONTENT_CREATOR")
      VALUE_CONTENT_CREATOR("CONTENT_CREATOR"),
      @SerializedName("MODERATOR")
      VALUE_MODERATOR("MODERATOR"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("INSIGHTS_ANALYST")
      VALUE_INSIGHTS_ANALYST("INSIGHTS_ANALYST"),
      NULL(null);

      private String value;

      private EnumPermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRole {
      @SerializedName("FINANCE_EDITOR")
      VALUE_FINANCE_EDITOR("FINANCE_EDITOR"),
      @SerializedName("FINANCE_ANALYST")
      VALUE_FINANCE_ANALYST("FINANCE_ANALYST"),
      @SerializedName("ADS_RIGHTS_REVIEWER")
      VALUE_ADS_RIGHTS_REVIEWER("ADS_RIGHTS_REVIEWER"),
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("EMPLOYEE")
      VALUE_EMPLOYEE("EMPLOYEE"),
      @SerializedName("FB_EMPLOYEE_SALES_REP")
      VALUE_FB_EMPLOYEE_SALES_REP("FB_EMPLOYEE_SALES_REP"),
      NULL(null);

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

  public Business copyFrom(Business instance) {
    this.mBlockOfflineAnalytics = instance.mBlockOfflineAnalytics;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mExtendedUpdatedTime = instance.mExtendedUpdatedTime;
    this.mId = instance.mId;
    this.mIsHidden = instance.mIsHidden;
    this.mIsInstagramEnabledInFbAnalytics = instance.mIsInstagramEnabledInFbAnalytics;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPaymentAccountId = instance.mPaymentAccountId;
    this.mPrimaryPage = instance.mPrimaryPage;
    this.mProfilePictureUri = instance.mProfilePictureUri;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTwoFactorType = instance.mTwoFactorType;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVerificationStatus = instance.mVerificationStatus;
    this.mVertical = instance.mVertical;
    this.mVerticalId = instance.mVerticalId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Business> getParser() {
    return new APIRequest.ResponseParser<Business>() {
      public APINodeList<Business> parseResponse(String response, APIContext context, APIRequest<Business> request) throws MalformedResponseException {
        return Business.parseResponse(response, context, request);
      }
    };
  }
}
