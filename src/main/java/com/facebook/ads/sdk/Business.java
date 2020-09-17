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

  public APIRequestGetAdStudies getAdStudies() {
    return new APIRequestGetAdStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdStudy createAdStudy() {
    return new APIRequestCreateAdStudy(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
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

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAggregateRevenue createAggregateRevenue() {
    return new APIRequestCreateAggregateRevenue(this.getPrefixedId().toString(), context);
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

  public APIRequestGetBusinessUnits getBusinessUnits() {
    return new APIRequestGetBusinessUnits(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBusinessUnit createBusinessUnit() {
    return new APIRequestCreateBusinessUnit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessUsers getBusinessUsers() {
    return new APIRequestGetBusinessUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBusinessUser createBusinessUser() {
    return new APIRequestCreateBusinessUser(this.getPrefixedId().toString(), context);
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

  public APIRequestGetContentDeliveryReport getContentDeliveryReport() {
    return new APIRequestGetContentDeliveryReport(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCreateAndApplyPublisherBlockList createCreateAndApplyPublisherBlockList() {
    return new APIRequestCreateCreateAndApplyPublisherBlockList(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCustomConversion createCustomConversion() {
    return new APIRequestCreateCustomConversion(this.getPrefixedId().toString(), context);
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

  public APIRequestGetInitiatedAudienceSharingRequests getInitiatedAudienceSharingRequests() {
    return new APIRequestGetInitiatedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInitiatedSharingAgreements getInitiatedSharingAgreements() {
    return new APIRequestGetInitiatedSharingAgreements(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteInstagramAccounts deleteInstagramAccounts() {
    return new APIRequestDeleteInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteManagedBusinesses deleteManagedBusinesses() {
    return new APIRequestDeleteManagedBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateManagedBusiness createManagedBusiness() {
    return new APIRequestCreateManagedBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMoveAsset createMoveAsset() {
    return new APIRequestCreateMoveAsset(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfflineConversionDataSets getOfflineConversionDataSets() {
    return new APIRequestGetOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOfflineConversionDataSet createOfflineConversionDataSet() {
    return new APIRequestCreateOfflineConversionDataSet(this.getPrefixedId().toString(), context);
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

  public APIRequestGetPendingUsers getPendingUsers() {
    return new APIRequestGetPendingUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePixelTo createPixelTo() {
    return new APIRequestCreatePixelTo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedAudienceSharingRequests getReceivedAudienceSharingRequests() {
    return new APIRequestGetReceivedAudienceSharingRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedSharingAgreements getReceivedSharingAgreements() {
    return new APIRequestGetReceivedSharingAgreements(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateUploadEvent createUploadEvent() {
    return new APIRequestCreateUploadEvent(this.getPrefixedId().toString(), context);
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
      "creation_time",
      "creator",
      "data_use_setting",
      "enable_automatic_matching",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "is_unavailable",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
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
    public APIRequestGetAdsPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetAdsPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
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
         }
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
         }
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
  }

  public static class APIRequestGetBusinessInvoices extends APIRequest<OracleTransaction> {

    APINodeList<OracleTransaction> lastResponse = null;
    @Override
    public APINodeList<OracleTransaction> getLastResponse() {
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
    public APINodeList<OracleTransaction> parseResponse(String response, String header) throws APIException {
      return OracleTransaction.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<OracleTransaction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OracleTransaction> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<OracleTransaction>>() {
           public APINodeList<OracleTransaction> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessInvoices.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetBusinessInvoices setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setInvoiceId (Long invoiceId) {
      this.setParam("invoice_id", invoiceId);
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

    public APIRequestGetBusinessInvoices setType (OracleTransaction.EnumType type) {
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

  public static class APIRequestGetBusinessUnits extends APIRequest<BusinessUnit> {

    APINodeList<BusinessUnit> lastResponse = null;
    @Override
    public APINodeList<BusinessUnit> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "creation_time",
      "currency",
      "excluded_sources",
      "id",
      "is_enabled_for_measurement",
      "name",
      "time_zone",
      "visits_available_date",
    };

    @Override
    public APINodeList<BusinessUnit> parseResponse(String response, String header) throws APIException {
      return BusinessUnit.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessUnit> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessUnit> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessUnit>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessUnit>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessUnit>>() {
           public APINodeList<BusinessUnit> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessUnits.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessUnits(String nodeId, APIContext context) {
      super(context, nodeId, "/business_units", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessUnits setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessUnits setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessUnits requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessUnits requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUnits requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessUnits requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUnits requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessUnits requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessUnits requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessUnits requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetBusinessUnits requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBusinessUnits requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestExcludedSourcesField () {
      return this.requestExcludedSourcesField(true);
    }
    public APIRequestGetBusinessUnits requestExcludedSourcesField (boolean value) {
      this.requestField("excluded_sources", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessUnits requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestIsEnabledForMeasurementField () {
      return this.requestIsEnabledForMeasurementField(true);
    }
    public APIRequestGetBusinessUnits requestIsEnabledForMeasurementField (boolean value) {
      this.requestField("is_enabled_for_measurement", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessUnits requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestTimeZoneField () {
      return this.requestTimeZoneField(true);
    }
    public APIRequestGetBusinessUnits requestTimeZoneField (boolean value) {
      this.requestField("time_zone", value);
      return this;
    }
    public APIRequestGetBusinessUnits requestVisitsAvailableDateField () {
      return this.requestVisitsAvailableDateField(true);
    }
    public APIRequestGetBusinessUnits requestVisitsAvailableDateField (boolean value) {
      this.requestField("visits_available_date", value);
      return this;
    }
  }

  public static class APIRequestCreateBusinessUnit extends APIRequest<BusinessUnit> {

    BusinessUnit lastResponse = null;
    @Override
    public BusinessUnit getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_units",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessUnit parseResponse(String response, String header) throws APIException {
      return BusinessUnit.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessUnit execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessUnit execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessUnit> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessUnit> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessUnit>() {
           public BusinessUnit apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBusinessUnit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateBusinessUnit(String nodeId, APIContext context) {
      super(context, nodeId, "/business_units", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBusinessUnit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUnit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBusinessUnit setBusinessUnits (List<Object> businessUnits) {
      this.setParam("business_units", businessUnits);
      return this;
    }
    public APIRequestCreateBusinessUnit setBusinessUnits (String businessUnits) {
      this.setParam("business_units", businessUnits);
      return this;
    }

    public APIRequestCreateBusinessUnit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBusinessUnit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUnit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBusinessUnit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUnit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUnit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
               return APIRequestGetClientAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
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
               return APIRequestCreateClientAdAccount.this.parseResponse(result.getBody(), result.getHeader());
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
      "supports_instant_articles",
      "talking_about_count",
      "temporary_status",
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
      "automatic_matching_fields",
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "enable_automatic_matching",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "is_unavailable",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
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
    public APIRequestGetClientPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetClientPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
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
      "commerce_merchant_settings",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "name",
      "product_count",
      "store_catalog_settings",
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
    public APIRequestGetClientProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
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
    public APIRequestGetClientProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
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
      "analytics",
      "currency",
      "id",
      "message_template_namespace",
      "name",
      "on_behalf_of_business_info",
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
         }
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

    public APIRequestGetClientWhatsAppBusinessAccounts requestAnalyticsField () {
      return this.requestAnalyticsField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestAnalyticsField (boolean value) {
      this.requestField("analytics", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientWhatsAppBusinessAccounts requestIdField (boolean value) {
      this.requestField("id", value);
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
               return APIRequestGetClients.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGetClients requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetClients requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
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
         }
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
         }
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
         }
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
      "braintree_merchant_id",
      "checkout_message",
      "contact_email",
      "cta",
      "disable_checkout_urls",
      "display_name",
      "facebook_channel",
      "has_discount_code",
      "id",
      "instagram_channel",
      "merchant_alert_email",
      "merchant_page",
      "merchant_status",
      "onsite_commerce_merchant",
      "payment_provider",
      "privacy_url_by_locale",
      "review_rejection_messages",
      "review_rejection_reasons",
      "review_status",
      "supported_card_types",
      "terms",
      "terms_url_by_locale",
      "whatsapp_channel",
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
         }
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

    public APIRequestGetCommerceMerchantSettings requestBraintreeMerchantIdField () {
      return this.requestBraintreeMerchantIdField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestBraintreeMerchantIdField (boolean value) {
      this.requestField("braintree_merchant_id", value);
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
    public APIRequestGetCommerceMerchantSettings requestDisableCheckoutUrlsField () {
      return this.requestDisableCheckoutUrlsField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestDisableCheckoutUrlsField (boolean value) {
      this.requestField("disable_checkout_urls", value);
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
    public APIRequestGetCommerceMerchantSettings requestHasDiscountCodeField () {
      return this.requestHasDiscountCodeField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestHasDiscountCodeField (boolean value) {
      this.requestField("has_discount_code", value);
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
    public APIRequestGetCommerceMerchantSettings requestMerchantAlertEmailField () {
      return this.requestMerchantAlertEmailField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestMerchantAlertEmailField (boolean value) {
      this.requestField("merchant_alert_email", value);
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
    public APIRequestGetCommerceMerchantSettings requestPrivacyUrlByLocaleField () {
      return this.requestPrivacyUrlByLocaleField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestPrivacyUrlByLocaleField (boolean value) {
      this.requestField("privacy_url_by_locale", value);
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
    public APIRequestGetCommerceMerchantSettings requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestSupportedCardTypesField () {
      return this.requestSupportedCardTypesField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestSupportedCardTypesField (boolean value) {
      this.requestField("supported_card_types", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestTermsUrlByLocaleField () {
      return this.requestTermsUrlByLocaleField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestTermsUrlByLocaleField (boolean value) {
      this.requestField("terms_url_by_locale", value);
      return this;
    }
    public APIRequestGetCommerceMerchantSettings requestWhatsappChannelField () {
      return this.requestWhatsappChannelField(true);
    }
    public APIRequestGetCommerceMerchantSettings requestWhatsappChannelField (boolean value) {
      this.requestField("whatsapp_channel", value);
      return this;
    }
  }

  public static class APIRequestGetContentDeliveryReport extends APIRequest<ContentDeliveryReport> {

    APINodeList<ContentDeliveryReport> lastResponse = null;
    @Override
    public APINodeList<ContentDeliveryReport> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_date",
      "page_id",
      "platform",
      "position",
      "start_date",
      "summary",
    };

    public static final String[] FIELDS = {
      "content_name",
      "content_url",
      "creator_name",
      "creator_url",
      "estimated_impressions",
    };

    @Override
    public APINodeList<ContentDeliveryReport> parseResponse(String response, String header) throws APIException {
      return ContentDeliveryReport.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ContentDeliveryReport> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ContentDeliveryReport> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ContentDeliveryReport>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ContentDeliveryReport>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ContentDeliveryReport>>() {
           public APINodeList<ContentDeliveryReport> apply(ResponseWrapper result) {
             try {
               return APIRequestGetContentDeliveryReport.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetContentDeliveryReport(String nodeId, APIContext context) {
      super(context, nodeId, "/content_delivery_report", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetContentDeliveryReport setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetContentDeliveryReport setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetContentDeliveryReport setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetContentDeliveryReport setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestGetContentDeliveryReport setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestGetContentDeliveryReport setPlatform (ContentDeliveryReport.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestGetContentDeliveryReport setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestGetContentDeliveryReport setPosition (ContentDeliveryReport.EnumPosition position) {
      this.setParam("position", position);
      return this;
    }
    public APIRequestGetContentDeliveryReport setPosition (String position) {
      this.setParam("position", position);
      return this;
    }

    public APIRequestGetContentDeliveryReport setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetContentDeliveryReport setSummary (Boolean summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetContentDeliveryReport setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetContentDeliveryReport requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetContentDeliveryReport requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentDeliveryReport requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetContentDeliveryReport requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentDeliveryReport requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetContentDeliveryReport requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetContentDeliveryReport requestContentNameField () {
      return this.requestContentNameField(true);
    }
    public APIRequestGetContentDeliveryReport requestContentNameField (boolean value) {
      this.requestField("content_name", value);
      return this;
    }
    public APIRequestGetContentDeliveryReport requestContentUrlField () {
      return this.requestContentUrlField(true);
    }
    public APIRequestGetContentDeliveryReport requestContentUrlField (boolean value) {
      this.requestField("content_url", value);
      return this;
    }
    public APIRequestGetContentDeliveryReport requestCreatorNameField () {
      return this.requestCreatorNameField(true);
    }
    public APIRequestGetContentDeliveryReport requestCreatorNameField (boolean value) {
      this.requestField("creator_name", value);
      return this;
    }
    public APIRequestGetContentDeliveryReport requestCreatorUrlField () {
      return this.requestCreatorUrlField(true);
    }
    public APIRequestGetContentDeliveryReport requestCreatorUrlField (boolean value) {
      this.requestField("creator_url", value);
      return this;
    }
    public APIRequestGetContentDeliveryReport requestEstimatedImpressionsField () {
      return this.requestEstimatedImpressionsField(true);
    }
    public APIRequestGetContentDeliveryReport requestEstimatedImpressionsField (boolean value) {
      this.requestField("estimated_impressions", value);
      return this;
    }
  }

  public static class APIRequestCreateCreateAndApplyPublisherBlockList extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_auto_blocking_on",
      "name",
      "publisher_urls",
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
               return APIRequestCreateCreateAndApplyPublisherBlockList.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCreateAndApplyPublisherBlockList(String nodeId, APIContext context) {
      super(context, nodeId, "/create_and_apply_publisher_block_list", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCreateAndApplyPublisherBlockList setIsAutoBlockingOn (Boolean isAutoBlockingOn) {
      this.setParam("is_auto_blocking_on", isAutoBlockingOn);
      return this;
    }
    public APIRequestCreateCreateAndApplyPublisherBlockList setIsAutoBlockingOn (String isAutoBlockingOn) {
      this.setParam("is_auto_blocking_on", isAutoBlockingOn);
      return this;
    }

    public APIRequestCreateCreateAndApplyPublisherBlockList setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCreateAndApplyPublisherBlockList setPublisherUrls (List<String> publisherUrls) {
      this.setParam("publisher_urls", publisherUrls);
      return this;
    }
    public APIRequestCreateCreateAndApplyPublisherBlockList setPublisherUrls (String publisherUrls) {
      this.setParam("publisher_urls", publisherUrls);
      return this;
    }

    public APIRequestCreateCreateAndApplyPublisherBlockList requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCreateAndApplyPublisherBlockList requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCreateAndApplyPublisherBlockList requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APINodeList<BusinessAgreement> parseResponse(String response, String header) throws APIException {
      return BusinessAgreement.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAgreement> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAgreement>>() {
           public APINodeList<BusinessAgreement> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInitiatedSharingAgreements.this.parseResponse(result.getBody(), result.getHeader());
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
         }
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

  public static class APIRequestDeleteManagedBusinesses extends APIRequest<APINode> {

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
               return APIRequestDeleteManagedBusinesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteManagedBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/managed_businesses", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteManagedBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteManagedBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteManagedBusinesses setExistingClientBusinessId (String existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }

    public APIRequestDeleteManagedBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteManagedBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteManagedBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteManagedBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteManagedBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteManagedBusinesses requestField (String field, boolean value) {
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
               return APIRequestCreateManagedBusiness.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestCreateManagedBusiness setChildBusinessExternalId (String childBusinessExternalId) {
      this.setParam("child_business_external_id", childBusinessExternalId);
      return this;
    }

    public APIRequestCreateManagedBusiness setExistingClientBusinessId (String existingClientBusinessId) {
      this.setParam("existing_client_business_id", existingClientBusinessId);
      return this;
    }

    public APIRequestCreateManagedBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateManagedBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
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

    public APIRequestCreateManagedBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateManagedBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
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

    public APIRequestCreateManagedBusiness setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateManagedBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
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

  public static class APIRequestCreateMoveAsset extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "asset_id",
      "client_id",
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
               return APIRequestCreateMoveAsset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMoveAsset(String nodeId, APIContext context) {
      super(context, nodeId, "/move_asset", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMoveAsset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMoveAsset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMoveAsset setAssetId (String assetId) {
      this.setParam("asset_id", assetId);
      return this;
    }

    public APIRequestCreateMoveAsset setClientId (String clientId) {
      this.setParam("client_id", clientId);
      return this;
    }

    public APIRequestCreateMoveAsset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMoveAsset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMoveAsset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMoveAsset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMoveAsset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMoveAsset requestField (String field, boolean value) {
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
      "business",
      "config",
      "creation_time",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "id",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_upload_app",
      "last_upload_app_changed_time",
      "match_rate_approx",
      "matched_entries",
      "name",
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
    public APIRequestGetOfflineConversionDataSets requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
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
      "auto_assign_to_new_accounts_only",
      "description",
      "enable_auto_assign_to_accounts",
      "is_mta_use",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OfflineConversionDataSet parseResponse(String response, String header) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OfflineConversionDataSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OfflineConversionDataSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OfflineConversionDataSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OfflineConversionDataSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OfflineConversionDataSet>() {
           public OfflineConversionDataSet apply(ResponseWrapper result) {
             try {
               return APIRequestCreateOfflineConversionDataSet.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (Boolean autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (String autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateOfflineConversionDataSet setName (String name) {
      this.setParam("name", name);
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
               return APIRequestGetOwnedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
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
               return APIRequestGetOwnedBusinesses.this.parseResponse(result.getBody(), result.getHeader());
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
      "child_business_external_id",
      "name",
      "page_permitted_tasks",
      "sales_rep_email",
      "shared_page_id",
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

    public APIRequestCreateOwnedBusiness setTimezoneId (Long timezoneId) {
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
         }
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
      "supports_instant_articles",
      "talking_about_count",
      "temporary_status",
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


    public APIRequestCreateOwnedPage setCode (String code) {
      this.setParam("code", code);
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
      "creation_time",
      "creator",
      "data_use_setting",
      "enable_automatic_matching",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "is_unavailable",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
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
    public APIRequestGetOwnedPixels requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetOwnedPixels requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
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
      "commerce_merchant_settings",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "name",
      "product_count",
      "store_catalog_settings",
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
    public APIRequestGetOwnedProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
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
    public APIRequestGetOwnedProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
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
      "catalog_segment_filter",
      "catalog_segment_product_set_id",
      "commerce_merchant_settings",
      "da_display_settings",
      "destination_catalog_settings",
      "flight_catalog_settings",
      "name",
      "onsite_commerce_merchant",
      "parent_catalog_id",
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

    public APIRequestCreateOwnedProductCatalog setCommerceMerchantSettings (Object commerceMerchantSettings) {
      this.setParam("commerce_merchant_settings", commerceMerchantSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setCommerceMerchantSettings (String commerceMerchantSettings) {
      this.setParam("commerce_merchant_settings", commerceMerchantSettings);
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

    public APIRequestCreateOwnedProductCatalog setOnsiteCommerceMerchant (Object onsiteCommerceMerchant) {
      this.setParam("onsite_commerce_merchant", onsiteCommerceMerchant);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setOnsiteCommerceMerchant (String onsiteCommerceMerchant) {
      this.setParam("onsite_commerce_merchant", onsiteCommerceMerchant);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setParentCatalogId (String parentCatalogId) {
      this.setParam("parent_catalog_id", parentCatalogId);
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
      "breaking_change",
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


    public APIRequestGetPicture setBreakingChange (ProfilePictureSource.EnumBreakingChange breakingChange) {
      this.setParam("breaking_change", breakingChange);
      return this;
    }
    public APIRequestGetPicture setBreakingChange (String breakingChange) {
      this.setParam("breaking_change", breakingChange);
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
         }
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
      "request_status",
      "requesting_business_id",
    };

    public static final String[] FIELDS = {
      "id",
      "request_status",
    };

    @Override
    public APINodeList<BusinessAgreement> parseResponse(String response, String header) throws APIException {
      return BusinessAgreement.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessAgreement> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAgreement> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAgreement>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessAgreement>>() {
           public APINodeList<BusinessAgreement> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReceivedSharingAgreements.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetReceivedSharingAgreements setRequestStatus (BusinessAgreement.EnumRequestStatus requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }
    public APIRequestGetReceivedSharingAgreements setRequestStatus (String requestStatus) {
      this.setParam("request_status", requestStatus);
      return this;
    }

    public APIRequestGetReceivedSharingAgreements setRequestingBusinessId (String requestingBusinessId) {
      this.setParam("requesting_business_id", requestingBusinessId);
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
         }
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

  public static class APIRequestCreateUploadEvent extends APIRequest<MeasurementUploadEvent> {

    MeasurementUploadEvent lastResponse = null;
    @Override
    public MeasurementUploadEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_level",
      "conversion_end_date",
      "conversion_start_date",
      "event_status",
      "lookback_window",
      "match_universe",
      "timezone",
      "upload_tag",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MeasurementUploadEvent parseResponse(String response, String header) throws APIException {
      return MeasurementUploadEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MeasurementUploadEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementUploadEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MeasurementUploadEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementUploadEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MeasurementUploadEvent>() {
           public MeasurementUploadEvent apply(ResponseWrapper result) {
             try {
               return APIRequestCreateUploadEvent.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUploadEvent(String nodeId, APIContext context) {
      super(context, nodeId, "/upload_event", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUploadEvent setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUploadEvent setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUploadEvent setAggregationLevel (MeasurementUploadEvent.EnumAggregationLevel aggregationLevel) {
      this.setParam("aggregation_level", aggregationLevel);
      return this;
    }
    public APIRequestCreateUploadEvent setAggregationLevel (String aggregationLevel) {
      this.setParam("aggregation_level", aggregationLevel);
      return this;
    }

    public APIRequestCreateUploadEvent setConversionEndDate (String conversionEndDate) {
      this.setParam("conversion_end_date", conversionEndDate);
      return this;
    }

    public APIRequestCreateUploadEvent setConversionStartDate (String conversionStartDate) {
      this.setParam("conversion_start_date", conversionStartDate);
      return this;
    }

    public APIRequestCreateUploadEvent setEventStatus (MeasurementUploadEvent.EnumEventStatus eventStatus) {
      this.setParam("event_status", eventStatus);
      return this;
    }
    public APIRequestCreateUploadEvent setEventStatus (String eventStatus) {
      this.setParam("event_status", eventStatus);
      return this;
    }

    public APIRequestCreateUploadEvent setLookbackWindow (MeasurementUploadEvent.EnumLookbackWindow lookbackWindow) {
      this.setParam("lookback_window", lookbackWindow);
      return this;
    }
    public APIRequestCreateUploadEvent setLookbackWindow (String lookbackWindow) {
      this.setParam("lookback_window", lookbackWindow);
      return this;
    }

    public APIRequestCreateUploadEvent setMatchUniverse (MeasurementUploadEvent.EnumMatchUniverse matchUniverse) {
      this.setParam("match_universe", matchUniverse);
      return this;
    }
    public APIRequestCreateUploadEvent setMatchUniverse (String matchUniverse) {
      this.setParam("match_universe", matchUniverse);
      return this;
    }

    public APIRequestCreateUploadEvent setTimezone (MeasurementUploadEvent.EnumTimezone timezone) {
      this.setParam("timezone", timezone);
      return this;
    }
    public APIRequestCreateUploadEvent setTimezone (String timezone) {
      this.setParam("timezone", timezone);
      return this;
    }

    public APIRequestCreateUploadEvent setUploadTag (String uploadTag) {
      this.setParam("upload_tag", uploadTag);
      return this;
    }

    public APIRequestCreateUploadEvent requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUploadEvent requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUploadEvent requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUploadEvent requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUploadEvent requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUploadEvent requestField (String field, boolean value) {
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
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
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
      @SerializedName("PROFILE_PLUS_LIVE_STREAM_MODERATION")
      VALUE_PROFILE_PLUS_LIVE_STREAM_MODERATION("PROFILE_PLUS_LIVE_STREAM_MODERATION"),
      @SerializedName("PROFILE_PLUS_MANAGE")
      VALUE_PROFILE_PLUS_MANAGE("PROFILE_PLUS_MANAGE"),
      @SerializedName("PROFILE_PLUS_MESSAGING")
      VALUE_PROFILE_PLUS_MESSAGING("PROFILE_PLUS_MESSAGING"),
      @SerializedName("PROFILE_PLUS_MODERATE")
      VALUE_PROFILE_PLUS_MODERATE("PROFILE_PLUS_MODERATE"),
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
      public APINodeList<Business> parseResponse(String response, APIContext context, APIRequest<Business> request, String header) throws MalformedResponseException {
        return Business.parseResponse(response, context, request, header);
      }
    };
  }
}
