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
public class AdAccount extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_status")
  private Long mAccountStatus = null;
  @SerializedName("age")
  private Double mAge = null;
  @SerializedName("agency_client_declaration")
  private AgencyClientDeclaration mAgencyClientDeclaration = null;
  @SerializedName("amount_spent")
  private String mAmountSpent = null;
  @SerializedName("attribution_spec")
  private List<AttributionSpec> mAttributionSpec = null;
  @SerializedName("balance")
  private String mBalance = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_city")
  private String mBusinessCity = null;
  @SerializedName("business_country_code")
  private String mBusinessCountryCode = null;
  @SerializedName("business_name")
  private String mBusinessName = null;
  @SerializedName("business_state")
  private String mBusinessState = null;
  @SerializedName("business_street")
  private String mBusinessStreet = null;
  @SerializedName("business_street2")
  private String mBusinessStreet2 = null;
  @SerializedName("business_zip")
  private String mBusinessZip = null;
  @SerializedName("can_create_brand_lift_study")
  private Boolean mCanCreateBrandLiftStudy = null;
  @SerializedName("capabilities")
  private List<String> mCapabilities = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("disable_reason")
  private Long mDisableReason = null;
  @SerializedName("end_advertiser")
  private String mEndAdvertiser = null;
  @SerializedName("end_advertiser_name")
  private String mEndAdvertiserName = null;
  @SerializedName("extended_credit_invoice_group")
  private ExtendedCreditInvoiceGroup mExtendedCreditInvoiceGroup = null;
  @SerializedName("failed_delivery_checks")
  private List<DeliveryCheck> mFailedDeliveryChecks = null;
  @SerializedName("funding_source")
  private String mFundingSource = null;
  @SerializedName("funding_source_details")
  private FundingSourceDetails mFundingSourceDetails = null;
  @SerializedName("has_migrated_permissions")
  private Boolean mHasMigratedPermissions = null;
  @SerializedName("has_page_authorized_adaccount")
  private Boolean mHasPageAuthorizedAdaccount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("io_number")
  private String mIoNumber = null;
  @SerializedName("is_attribution_spec_system_default")
  private Boolean mIsAttributionSpecSystemDefault = null;
  @SerializedName("is_direct_deals_enabled")
  private Boolean mIsDirectDealsEnabled = null;
  @SerializedName("is_in_middle_of_local_entity_migration")
  private Boolean mIsInMiddleOfLocalEntityMigration = null;
  @SerializedName("is_notifications_enabled")
  private Boolean mIsNotificationsEnabled = null;
  @SerializedName("is_personal")
  private Long mIsPersonal = null;
  @SerializedName("is_prepay_account")
  private Boolean mIsPrepayAccount = null;
  @SerializedName("is_tax_id_required")
  private Boolean mIsTaxIdRequired = null;
  @SerializedName("line_numbers")
  private List<Long> mLineNumbers = null;
  @SerializedName("media_agency")
  private String mMediaAgency = null;
  @SerializedName("min_campaign_group_spend_cap")
  private String mMinCampaignGroupSpendCap = null;
  @SerializedName("min_daily_budget")
  private Long mMinDailyBudget = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("offsite_pixels_tos_accepted")
  private Boolean mOffsitePixelsTosAccepted = null;
  @SerializedName("owner")
  private String mOwner = null;
  @SerializedName("partner")
  private String mPartner = null;
  @SerializedName("rf_spec")
  private ReachFrequencySpec mRfSpec = null;
  @SerializedName("show_checkout_experience")
  private Boolean mShowCheckoutExperience = null;
  @SerializedName("spend_cap")
  private String mSpendCap = null;
  @SerializedName("tax_id")
  private String mTaxId = null;
  @SerializedName("tax_id_status")
  private Long mTaxIdStatus = null;
  @SerializedName("tax_id_type")
  private String mTaxIdType = null;
  @SerializedName("timezone_id")
  private Long mTimezoneId = null;
  @SerializedName("timezone_name")
  private String mTimezoneName = null;
  @SerializedName("timezone_offset_hours_utc")
  private Double mTimezoneOffsetHoursUtc = null;
  @SerializedName("tos_accepted")
  private Map<String, Long> mTosAccepted = null;
  @SerializedName("user_role")
  private String mUserRole = null;
  @SerializedName("user_tos_accepted")
  private Map<String, Long> mUserTosAccepted = null;
  protected static Gson gson = null;

  AdAccount() {
  }

  public AdAccount(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccount(String id, APIContext context) {
    this.mId = id.replaceAll("act_", "");
    this.context = context;
  }

  public AdAccount fetch() throws APIException{
    AdAccount newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    mId = mId.replaceAll("act_", "");
    return this;
  }

  public static AdAccount fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccount> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccount fetchById(String id, APIContext context) throws APIException {
    AdAccount adAccount =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adAccount;
  }

  public static ListenableFuture<AdAccount> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<AdAccount> adAccount =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return adAccount;
  }

  public static APINodeList<AdAccount> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccount>)(
      new APIRequest<AdAccount>(context, "", "/", "GET", AdAccount.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccount>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<AdAccount>> adAccount =
      new APIRequest(context, "", "/", "GET", AdAccount.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return adAccount;
  }

  private String getPrefixedId() {
    return "act_" + getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccount loadJSON(String json, APIContext context) {
    AdAccount adAccount = getGson().fromJson(json, AdAccount.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccount.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccount.context = context;
    adAccount.rawValue = json;
    JsonParser parser = new JsonParser();
    JsonObject o = parser.parse(json).getAsJsonObject();
    if (o.has("account_id")) {
      String accountId = o.get("account_id").getAsString();
      if (accountId != null) {
        adAccount.mId = accountId;
      }
    }
    if (adAccount.mId != null) {
      adAccount.mId = adAccount.mId.replaceAll("act_", "");
    }
    return adAccount;
  }

  public static APINodeList<AdAccount> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccount> adAccounts = new APINodeList<AdAccount>(request, json);
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
          adAccounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccounts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccounts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccounts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccounts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccounts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccounts.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccounts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccounts.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccounts;
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
              adAccounts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccounts;
          }

          // Sixth, check if it's pure JsonObject
          adAccounts.clear();
          adAccounts.add(loadJSON(json, context));
          return adAccounts;
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

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdPlacePageSets getAdPlacePageSets() {
    return new APIRequestGetAdPlacePageSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdPlacePageSet createAdPlacePageSet() {
    return new APIRequestCreateAdPlacePageSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAssetFeeds getAdAssetFeeds() {
    return new APIRequestGetAdAssetFeeds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdCreative createAdCreative() {
    return new APIRequestCreateAdCreative(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdCreativesByLabels getAdCreativesByLabels() {
    return new APIRequestGetAdCreativesByLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdImages deleteAdImages() {
    return new APIRequestDeleteAdImages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdImages getAdImages() {
    return new APIRequestGetAdImages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdImage createAdImage() {
    return new APIRequestCreateAdImage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdLabels getAdLabels() {
    return new APIRequestGetAdLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLanguageAsset createAdLanguageAsset() {
    return new APIRequestCreateAdLanguageAsset(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdReportRuns getAdReportRuns() {
    return new APIRequestGetAdReportRuns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdReportSchedules getAdReportSchedules() {
    return new APIRequestGetAdReportSchedules(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdRulesHistory getAdRulesHistory() {
    return new APIRequestGetAdRulesHistory(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdRulesLibrary createAdRulesLibrary() {
    return new APIRequestCreateAdRulesLibrary(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAd createAd() {
    return new APIRequestCreateAd(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdsByLabels getAdsByLabels() {
    return new APIRequestGetAdsByLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdSet createAdSet() {
    return new APIRequestCreateAdSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdSetsByLabels getAdSetsByLabels() {
    return new APIRequestGetAdSetsByLabels(this.getPrefixedId().toString(), context);
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

  public APIRequestGetAdVideos getAdVideos() {
    return new APIRequestGetAdVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdVideo createAdVideo() {
    return new APIRequestCreateAdVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAgency createAgency() {
    return new APIRequestCreateAgency(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetApplications getApplications() {
    return new APIRequestGetApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAssignedUsers deleteAssignedUsers() {
    return new APIRequestDeleteAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedUsers getAssignedUsers() {
    return new APIRequestGetAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAssignedUser createAssignedUser() {
    return new APIRequestCreateAssignedUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAsyncBatchRequest createAsyncBatchRequest() {
    return new APIRequestCreateAsyncBatchRequest(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAsyncAdRequestSets getAsyncAdRequestSets() {
    return new APIRequestGetAsyncAdRequestSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAsyncAdRequestSet createAsyncAdRequestSet() {
    return new APIRequestCreateAsyncAdRequestSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAudienceReplace createAudienceReplace() {
    return new APIRequestCreateAudienceReplace(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBroadTargetingCategories getBroadTargetingCategories() {
    return new APIRequestGetBroadTargetingCategories(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteCampaigns deleteCampaigns() {
    return new APIRequestDeleteCampaigns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCampaigns getCampaigns() {
    return new APIRequestGetCampaigns(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCampaign createCampaign() {
    return new APIRequestCreateCampaign(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCampaignsByLabels getCampaignsByLabels() {
    return new APIRequestGetCampaignsByLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomAudiences getCustomAudiences() {
    return new APIRequestGetCustomAudiences(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCustomAudience createCustomAudience() {
    return new APIRequestCreateCustomAudience(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomAudiencesTos getCustomAudiencesTos() {
    return new APIRequestGetCustomAudiencesTos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCustomConversion createCustomConversion() {
    return new APIRequestCreateCustomConversion(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDeliveryEstimate getDeliveryEstimate() {
    return new APIRequestGetDeliveryEstimate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetGeneratePreviews getGeneratePreviews() {
    return new APIRequestGetGeneratePreviews(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLeadGenForms getLeadGenForms() {
    return new APIRequestGetLeadGenForms(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMinimumBudgets getMinimumBudgets() {
    return new APIRequestGetMinimumBudgets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfflineConversionDataSets getOfflineConversionDataSets() {
    return new APIRequestGetOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOffsitePixels getOffsitePixels() {
    return new APIRequestGetOffsitePixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartnerCategories getPartnerCategories() {
    return new APIRequestGetPartnerCategories(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartners getPartners() {
    return new APIRequestGetPartners(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeletePendingUsers deletePendingUsers() {
    return new APIRequestDeletePendingUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePendingUser createPendingUser() {
    return new APIRequestCreatePendingUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductAudience createProductAudience() {
    return new APIRequestCreateProductAudience(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPublisherBlockLists getPublisherBlockLists() {
    return new APIRequestGetPublisherBlockLists(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePublisherBlockList createPublisherBlockList() {
    return new APIRequestCreatePublisherBlockList(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReachEstimate getReachEstimate() {
    return new APIRequestGetReachEstimate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReachFrequencyPredictions getReachFrequencyPredictions() {
    return new APIRequestGetReachFrequencyPredictions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateReachFrequencyPrediction createReachFrequencyPrediction() {
    return new APIRequestCreateReachFrequencyPrediction(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRoas getRoas() {
    return new APIRequestGetRoas(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSponsoredMessageAd createSponsoredMessageAd() {
    return new APIRequestCreateSponsoredMessageAd(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingBrowse getTargetingBrowse() {
    return new APIRequestGetTargetingBrowse(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSearch getTargetingSearch() {
    return new APIRequestGetTargetingSearch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSuggestions getTargetingSuggestions() {
    return new APIRequestGetTargetingSuggestions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingValidation getTargetingValidation() {
    return new APIRequestGetTargetingValidation(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteTracking deleteTracking() {
    return new APIRequestDeleteTracking(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateTracking createTracking() {
    return new APIRequestCreateTracking(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserMatch deleteUserMatch() {
    return new APIRequestDeleteUserMatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUserMatch createUserMatch() {
    return new APIRequestCreateUserMatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUsers getUsers() {
    return new APIRequestGetUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldAccountStatus() {
    return mAccountStatus;
  }

  public Double getFieldAge() {
    return mAge;
  }

  public AgencyClientDeclaration getFieldAgencyClientDeclaration() {
    return mAgencyClientDeclaration;
  }

  public String getFieldAmountSpent() {
    return mAmountSpent;
  }

  public List<AttributionSpec> getFieldAttributionSpec() {
    return mAttributionSpec;
  }

  public String getFieldBalance() {
    return mBalance;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldBusinessCity() {
    return mBusinessCity;
  }

  public String getFieldBusinessCountryCode() {
    return mBusinessCountryCode;
  }

  public String getFieldBusinessName() {
    return mBusinessName;
  }

  public String getFieldBusinessState() {
    return mBusinessState;
  }

  public String getFieldBusinessStreet() {
    return mBusinessStreet;
  }

  public String getFieldBusinessStreet2() {
    return mBusinessStreet2;
  }

  public String getFieldBusinessZip() {
    return mBusinessZip;
  }

  public Boolean getFieldCanCreateBrandLiftStudy() {
    return mCanCreateBrandLiftStudy;
  }

  public List<String> getFieldCapabilities() {
    return mCapabilities;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public Long getFieldDisableReason() {
    return mDisableReason;
  }

  public String getFieldEndAdvertiser() {
    return mEndAdvertiser;
  }

  public String getFieldEndAdvertiserName() {
    return mEndAdvertiserName;
  }

  public ExtendedCreditInvoiceGroup getFieldExtendedCreditInvoiceGroup() {
    if (mExtendedCreditInvoiceGroup != null) {
      mExtendedCreditInvoiceGroup.context = getContext();
    }
    return mExtendedCreditInvoiceGroup;
  }

  public List<DeliveryCheck> getFieldFailedDeliveryChecks() {
    return mFailedDeliveryChecks;
  }

  public String getFieldFundingSource() {
    return mFundingSource;
  }

  public FundingSourceDetails getFieldFundingSourceDetails() {
    return mFundingSourceDetails;
  }

  public Boolean getFieldHasMigratedPermissions() {
    return mHasMigratedPermissions;
  }

  public Boolean getFieldHasPageAuthorizedAdaccount() {
    return mHasPageAuthorizedAdaccount;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIoNumber() {
    return mIoNumber;
  }

  public Boolean getFieldIsAttributionSpecSystemDefault() {
    return mIsAttributionSpecSystemDefault;
  }

  public Boolean getFieldIsDirectDealsEnabled() {
    return mIsDirectDealsEnabled;
  }

  public Boolean getFieldIsInMiddleOfLocalEntityMigration() {
    return mIsInMiddleOfLocalEntityMigration;
  }

  public Boolean getFieldIsNotificationsEnabled() {
    return mIsNotificationsEnabled;
  }

  public Long getFieldIsPersonal() {
    return mIsPersonal;
  }

  public Boolean getFieldIsPrepayAccount() {
    return mIsPrepayAccount;
  }

  public Boolean getFieldIsTaxIdRequired() {
    return mIsTaxIdRequired;
  }

  public List<Long> getFieldLineNumbers() {
    return mLineNumbers;
  }

  public String getFieldMediaAgency() {
    return mMediaAgency;
  }

  public String getFieldMinCampaignGroupSpendCap() {
    return mMinCampaignGroupSpendCap;
  }

  public Long getFieldMinDailyBudget() {
    return mMinDailyBudget;
  }

  public String getFieldName() {
    return mName;
  }

  public Boolean getFieldOffsitePixelsTosAccepted() {
    return mOffsitePixelsTosAccepted;
  }

  public String getFieldOwner() {
    return mOwner;
  }

  public String getFieldPartner() {
    return mPartner;
  }

  public ReachFrequencySpec getFieldRfSpec() {
    return mRfSpec;
  }

  public Boolean getFieldShowCheckoutExperience() {
    return mShowCheckoutExperience;
  }

  public String getFieldSpendCap() {
    return mSpendCap;
  }

  public String getFieldTaxId() {
    return mTaxId;
  }

  public Long getFieldTaxIdStatus() {
    return mTaxIdStatus;
  }

  public String getFieldTaxIdType() {
    return mTaxIdType;
  }

  public Long getFieldTimezoneId() {
    return mTimezoneId;
  }

  public String getFieldTimezoneName() {
    return mTimezoneName;
  }

  public Double getFieldTimezoneOffsetHoursUtc() {
    return mTimezoneOffsetHoursUtc;
  }

  public Map<String, Long> getFieldTosAccepted() {
    return mTosAccepted;
  }

  public String getFieldUserRole() {
    return mUserRole;
  }

  public Map<String, Long> getFieldUserTosAccepted() {
    return mUserTosAccepted;
  }



  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "add_children",
      "business_id",
      "category",
      "extra_oids",
      "oid",
      "since",
      "uid",
      "until",
    };

    public static final String[] FIELDS = {
      "actor_id",
      "actor_name",
      "application_id",
      "application_name",
      "date_time_in_timezone",
      "event_time",
      "event_type",
      "extra_data",
      "object_id",
      "object_name",
      "translated_event_type",
    };

    @Override
    public APINodeList<AdActivity> parseResponse(String response) throws APIException {
      return AdActivity.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdActivity> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdActivity> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdActivity>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdActivity>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdActivity>>() {
           public APINodeList<AdActivity> apply(String result) {
             try {
               return APIRequestGetActivities.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setAddChildren (Boolean addChildren) {
      this.setParam("add_children", addChildren);
      return this;
    }
    public APIRequestGetActivities setAddChildren (String addChildren) {
      this.setParam("add_children", addChildren);
      return this;
    }

    public APIRequestGetActivities setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetActivities setCategory (AdActivity.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestGetActivities setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setExtraOids (List<String> extraOids) {
      this.setParam("extra_oids", extraOids);
      return this;
    }
    public APIRequestGetActivities setExtraOids (String extraOids) {
      this.setParam("extra_oids", extraOids);
      return this;
    }

    public APIRequestGetActivities setOid (String oid) {
      this.setParam("oid", oid);
      return this;
    }

    public APIRequestGetActivities setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetActivities setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetActivities setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetActivities setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetActivities requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetActivities requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetActivities requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetActivities requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationIdField () {
      return this.requestApplicationIdField(true);
    }
    public APIRequestGetActivities requestApplicationIdField (boolean value) {
      this.requestField("application_id", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationNameField () {
      return this.requestApplicationNameField(true);
    }
    public APIRequestGetActivities requestApplicationNameField (boolean value) {
      this.requestField("application_name", value);
      return this;
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField () {
      return this.requestDateTimeInTimezoneField(true);
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField (boolean value) {
      this.requestField("date_time_in_timezone", value);
      return this;
    }
    public APIRequestGetActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetActivities requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetActivities requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetActivities requestObjectNameField () {
      return this.requestObjectNameField(true);
    }
    public APIRequestGetActivities requestObjectNameField (boolean value) {
      this.requestField("object_name", value);
      return this;
    }
    public APIRequestGetActivities requestTranslatedEventTypeField () {
      return this.requestTranslatedEventTypeField(true);
    }
    public APIRequestGetActivities requestTranslatedEventTypeField (boolean value) {
      this.requestField("translated_event_type", value);
      return this;
    }
  }

  public static class APIRequestGetAdPlacePageSets extends APIRequest<AdPlacePageSet> {

    APINodeList<AdPlacePageSet> lastResponse = null;
    @Override
    public APINodeList<AdPlacePageSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "id",
      "location_types",
      "name",
      "pages_count",
      "parent_page",
    };

    @Override
    public APINodeList<AdPlacePageSet> parseResponse(String response) throws APIException {
      return AdPlacePageSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdPlacePageSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPlacePageSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdPlacePageSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdPlacePageSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdPlacePageSet>>() {
           public APINodeList<AdPlacePageSet> apply(String result) {
             try {
               return APIRequestGetAdPlacePageSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdPlacePageSets(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_place_page_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdPlacePageSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdPlacePageSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdPlacePageSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdPlacePageSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlacePageSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdPlacePageSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlacePageSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdPlacePageSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdPlacePageSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdPlacePageSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdPlacePageSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestLocationTypesField () {
      return this.requestLocationTypesField(true);
    }
    public APIRequestGetAdPlacePageSets requestLocationTypesField (boolean value) {
      this.requestField("location_types", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdPlacePageSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestPagesCountField () {
      return this.requestPagesCountField(true);
    }
    public APIRequestGetAdPlacePageSets requestPagesCountField (boolean value) {
      this.requestField("pages_count", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAdPlacePageSets requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
  }

  public static class APIRequestCreateAdPlacePageSet extends APIRequest<AdPlacePageSet> {

    AdPlacePageSet lastResponse = null;
    @Override
    public AdPlacePageSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "location_types",
      "name",
      "parent_page",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdPlacePageSet parseResponse(String response) throws APIException {
      return AdPlacePageSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdPlacePageSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdPlacePageSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdPlacePageSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdPlacePageSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdPlacePageSet>() {
           public AdPlacePageSet apply(String result) {
             try {
               return APIRequestCreateAdPlacePageSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdPlacePageSet(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_place_page_sets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdPlacePageSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdPlacePageSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdPlacePageSet setLocationTypes (List<AdPlacePageSet.EnumLocationTypes> locationTypes) {
      this.setParam("location_types", locationTypes);
      return this;
    }
    public APIRequestCreateAdPlacePageSet setLocationTypes (String locationTypes) {
      this.setParam("location_types", locationTypes);
      return this;
    }

    public APIRequestCreateAdPlacePageSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdPlacePageSet setParentPage (String parentPage) {
      this.setParam("parent_page", parentPage);
      return this;
    }

    public APIRequestCreateAdPlacePageSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdPlacePageSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdPlacePageSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdPlacePageSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdPlacePageSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdPlacePageSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdAssetFeeds extends APIRequest<APINode> {

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
               return APIRequestGetAdAssetFeeds.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdAssetFeeds(String nodeId, APIContext context) {
      super(context, nodeId, "/adasset_feeds", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAssetFeeds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAssetFeeds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAssetFeeds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAssetFeeds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAssetFeeds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAssetFeeds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAssetFeeds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdAssetFeeds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "asset_feed_spec",
      "body",
      "branded_content_sponsor_page_id",
      "call_to_action_type",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "instagram_story_id",
      "link_og_id",
      "link_url",
      "messenger_sponsored_message",
      "name",
      "object_id",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "platform_customizations",
      "product_set_id",
      "recommender_settings",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreative>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreative>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdCreative>>() {
           public APINodeList<AdCreative> apply(String result) {
             try {
               return APIRequestGetAdCreatives.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreatives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreatives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreatives requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGetAdCreatives requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGetAdCreatives requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreatives requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreatives requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreatives requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestMessengerSponsoredMessageField () {
      return this.requestMessengerSponsoredMessageField(true);
    }
    public APIRequestGetAdCreatives requestMessengerSponsoredMessageField (boolean value) {
      this.requestField("messenger_sponsored_message", value);
      return this;
    }
    public APIRequestGetAdCreatives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreatives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreatives requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGetAdCreatives requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGetAdCreatives requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreatives requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreatives requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreatives requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreatives requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreatives requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestCreateAdCreative extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "applink_treatment",
      "authorization_category",
      "body",
      "branded_content_sponsor_page_id",
      "dynamic_ad_voice",
      "image_crops",
      "image_file",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "platform_customizations",
      "product_set_id",
      "recommender_settings",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdCreative parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreative> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreative> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreative>() {
           public AdCreative apply(String result) {
             try {
               return APIRequestCreateAdCreative.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdCreative(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdCreative setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdCreative setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdCreative setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAdCreative setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdCreative setApplinkTreatment (AdCreative.EnumApplinkTreatment applinkTreatment) {
      this.setParam("applink_treatment", applinkTreatment);
      return this;
    }
    public APIRequestCreateAdCreative setApplinkTreatment (String applinkTreatment) {
      this.setParam("applink_treatment", applinkTreatment);
      return this;
    }

    public APIRequestCreateAdCreative setAuthorizationCategory (AdCreative.EnumAuthorizationCategory authorizationCategory) {
      this.setParam("authorization_category", authorizationCategory);
      return this;
    }
    public APIRequestCreateAdCreative setAuthorizationCategory (String authorizationCategory) {
      this.setParam("authorization_category", authorizationCategory);
      return this;
    }

    public APIRequestCreateAdCreative setBody (String body) {
      this.setParam("body", body);
      return this;
    }

    public APIRequestCreateAdCreative setBrandedContentSponsorPageId (String brandedContentSponsorPageId) {
      this.setParam("branded_content_sponsor_page_id", brandedContentSponsorPageId);
      return this;
    }

    public APIRequestCreateAdCreative setDynamicAdVoice (AdCreative.EnumDynamicAdVoice dynamicAdVoice) {
      this.setParam("dynamic_ad_voice", dynamicAdVoice);
      return this;
    }
    public APIRequestCreateAdCreative setDynamicAdVoice (String dynamicAdVoice) {
      this.setParam("dynamic_ad_voice", dynamicAdVoice);
      return this;
    }

    public APIRequestCreateAdCreative setImageCrops (Map<String, String> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreateAdCreative setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }

    public APIRequestCreateAdCreative setImageFile (String imageFile) {
      this.setParam("image_file", imageFile);
      return this;
    }

    public APIRequestCreateAdCreative setImageHash (String imageHash) {
      this.setParam("image_hash", imageHash);
      return this;
    }

    public APIRequestCreateAdCreative setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateAdCreative setInstagramActorId (String instagramActorId) {
      this.setParam("instagram_actor_id", instagramActorId);
      return this;
    }

    public APIRequestCreateAdCreative setInstagramPermalinkUrl (String instagramPermalinkUrl) {
      this.setParam("instagram_permalink_url", instagramPermalinkUrl);
      return this;
    }

    public APIRequestCreateAdCreative setLinkOgId (String linkOgId) {
      this.setParam("link_og_id", linkOgId);
      return this;
    }

    public APIRequestCreateAdCreative setLinkUrl (String linkUrl) {
      this.setParam("link_url", linkUrl);
      return this;
    }

    public APIRequestCreateAdCreative setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdCreative setObjectId (Long objectId) {
      this.setParam("object_id", objectId);
      return this;
    }
    public APIRequestCreateAdCreative setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestCreateAdCreative setObjectStoryId (String objectStoryId) {
      this.setParam("object_story_id", objectStoryId);
      return this;
    }

    public APIRequestCreateAdCreative setObjectStorySpec (AdCreativeObjectStorySpec objectStorySpec) {
      this.setParam("object_story_spec", objectStorySpec);
      return this;
    }
    public APIRequestCreateAdCreative setObjectStorySpec (String objectStorySpec) {
      this.setParam("object_story_spec", objectStorySpec);
      return this;
    }

    public APIRequestCreateAdCreative setObjectType (String objectType) {
      this.setParam("object_type", objectType);
      return this;
    }

    public APIRequestCreateAdCreative setPlatformCustomizations (Object platformCustomizations) {
      this.setParam("platform_customizations", platformCustomizations);
      return this;
    }
    public APIRequestCreateAdCreative setPlatformCustomizations (String platformCustomizations) {
      this.setParam("platform_customizations", platformCustomizations);
      return this;
    }

    public APIRequestCreateAdCreative setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
      return this;
    }

    public APIRequestCreateAdCreative setRecommenderSettings (Map<String, String> recommenderSettings) {
      this.setParam("recommender_settings", recommenderSettings);
      return this;
    }
    public APIRequestCreateAdCreative setRecommenderSettings (String recommenderSettings) {
      this.setParam("recommender_settings", recommenderSettings);
      return this;
    }

    public APIRequestCreateAdCreative setTemplateUrl (String templateUrl) {
      this.setParam("template_url", templateUrl);
      return this;
    }

    public APIRequestCreateAdCreative setTemplateUrlSpec (Object templateUrlSpec) {
      this.setParam("template_url_spec", templateUrlSpec);
      return this;
    }
    public APIRequestCreateAdCreative setTemplateUrlSpec (String templateUrlSpec) {
      this.setParam("template_url_spec", templateUrlSpec);
      return this;
    }

    public APIRequestCreateAdCreative setThumbnailUrl (String thumbnailUrl) {
      this.setParam("thumbnail_url", thumbnailUrl);
      return this;
    }

    public APIRequestCreateAdCreative setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateAdCreative setUrlTags (String urlTags) {
      this.setParam("url_tags", urlTags);
      return this;
    }

    public APIRequestCreateAdCreative setUsePageActorOverride (Boolean usePageActorOverride) {
      this.setParam("use_page_actor_override", usePageActorOverride);
      return this;
    }
    public APIRequestCreateAdCreative setUsePageActorOverride (String usePageActorOverride) {
      this.setParam("use_page_actor_override", usePageActorOverride);
      return this;
    }

    public APIRequestCreateAdCreative requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdCreative requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdCreative requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdCreative requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdCreative requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdCreative requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdCreativesByLabels extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_label_ids",
      "operator",
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "asset_feed_spec",
      "body",
      "branded_content_sponsor_page_id",
      "call_to_action_type",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "instagram_story_id",
      "link_og_id",
      "link_url",
      "messenger_sponsored_message",
      "name",
      "object_id",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "platform_customizations",
      "product_set_id",
      "recommender_settings",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreative>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreative>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdCreative>>() {
           public APINodeList<AdCreative> apply(String result) {
             try {
               return APIRequestGetAdCreativesByLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdCreativesByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreativesbylabels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreativesByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdCreativesByLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreativesByLabels setAdLabelIds (List<String> adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }
    public APIRequestGetAdCreativesByLabels setAdLabelIds (String adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }

    public APIRequestGetAdCreativesByLabels setOperator (AdCreative.EnumOperator operator) {
      this.setParam("operator", operator);
      return this;
    }
    public APIRequestGetAdCreativesByLabels setOperator (String operator) {
      this.setParam("operator", operator);
      return this;
    }

    public APIRequestGetAdCreativesByLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreativesByLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreativesByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreativesByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreativesByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreativesByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreativesByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreativesByLabels requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGetAdCreativesByLabels requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreativesByLabels requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreativesByLabels requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreativesByLabels requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestMessengerSponsoredMessageField () {
      return this.requestMessengerSponsoredMessageField(true);
    }
    public APIRequestGetAdCreativesByLabels requestMessengerSponsoredMessageField (boolean value) {
      this.requestField("messenger_sponsored_message", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreativesByLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreativesByLabels requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreativesByLabels requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreativesByLabels requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestDeleteAdImages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hash",
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
               return APIRequestDeleteAdImages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAdImages(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdImages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdImages setHash (String hash) {
      this.setParam("hash", hash);
      return this;
    }

    public APIRequestDeleteAdImages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdImages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdImages extends APIRequest<AdImage> {

    APINodeList<AdImage> lastResponse = null;
    @Override
    public APINodeList<AdImage> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "biz_tag_id",
      "business_id",
      "hashes",
      "minheight",
      "minwidth",
      "name",
    };

    public static final String[] FIELDS = {
      "account_id",
      "created_time",
      "creatives",
      "hash",
      "height",
      "id",
      "is_associated_creatives_in_adgroups",
      "name",
      "original_height",
      "original_width",
      "permalink_url",
      "status",
      "updated_time",
      "url",
      "url_128",
      "width",
    };

    @Override
    public APINodeList<AdImage> parseResponse(String response) throws APIException {
      return AdImage.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdImage> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdImage> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdImage>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdImage>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdImage>>() {
           public APINodeList<AdImage> apply(String result) {
             try {
               return APIRequestGetAdImages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdImages(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdImages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdImages setBizTagId (Long bizTagId) {
      this.setParam("biz_tag_id", bizTagId);
      return this;
    }
    public APIRequestGetAdImages setBizTagId (String bizTagId) {
      this.setParam("biz_tag_id", bizTagId);
      return this;
    }

    public APIRequestGetAdImages setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetAdImages setHashes (List<String> hashes) {
      this.setParam("hashes", hashes);
      return this;
    }
    public APIRequestGetAdImages setHashes (String hashes) {
      this.setParam("hashes", hashes);
      return this;
    }

    public APIRequestGetAdImages setMinheight (Long minheight) {
      this.setParam("minheight", minheight);
      return this;
    }
    public APIRequestGetAdImages setMinheight (String minheight) {
      this.setParam("minheight", minheight);
      return this;
    }

    public APIRequestGetAdImages setMinwidth (Long minwidth) {
      this.setParam("minwidth", minwidth);
      return this;
    }
    public APIRequestGetAdImages setMinwidth (String minwidth) {
      this.setParam("minwidth", minwidth);
      return this;
    }

    public APIRequestGetAdImages setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestGetAdImages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdImages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdImages requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdImages requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdImages requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdImages requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdImages requestCreativesField () {
      return this.requestCreativesField(true);
    }
    public APIRequestGetAdImages requestCreativesField (boolean value) {
      this.requestField("creatives", value);
      return this;
    }
    public APIRequestGetAdImages requestHashField () {
      return this.requestHashField(true);
    }
    public APIRequestGetAdImages requestHashField (boolean value) {
      this.requestField("hash", value);
      return this;
    }
    public APIRequestGetAdImages requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetAdImages requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetAdImages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdImages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdImages requestIsAssociatedCreativesInAdgroupsField () {
      return this.requestIsAssociatedCreativesInAdgroupsField(true);
    }
    public APIRequestGetAdImages requestIsAssociatedCreativesInAdgroupsField (boolean value) {
      this.requestField("is_associated_creatives_in_adgroups", value);
      return this;
    }
    public APIRequestGetAdImages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdImages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdImages requestOriginalHeightField () {
      return this.requestOriginalHeightField(true);
    }
    public APIRequestGetAdImages requestOriginalHeightField (boolean value) {
      this.requestField("original_height", value);
      return this;
    }
    public APIRequestGetAdImages requestOriginalWidthField () {
      return this.requestOriginalWidthField(true);
    }
    public APIRequestGetAdImages requestOriginalWidthField (boolean value) {
      this.requestField("original_width", value);
      return this;
    }
    public APIRequestGetAdImages requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetAdImages requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetAdImages requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdImages requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdImages requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdImages requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAdImages requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetAdImages requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetAdImages requestUrl128Field () {
      return this.requestUrl128Field(true);
    }
    public APIRequestGetAdImages requestUrl128Field (boolean value) {
      this.requestField("url_128", value);
      return this;
    }
    public APIRequestGetAdImages requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetAdImages requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateAdImage extends APIRequest<AdImage> {

    AdImage lastResponse = null;
    @Override
    public AdImage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "copy_from",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdImage parseResponse(String response) throws APIException {
      return AdImage.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdImage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdImage execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdImage> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdImage> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdImage>() {
           public AdImage apply(String result) {
             try {
               return APIRequestCreateAdImage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdImage(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdImage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdImage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAdImage addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateAdImage setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateAdImage setCopyFrom (Object copyFrom) {
      this.setParam("copy_from", copyFrom);
      return this;
    }
    public APIRequestCreateAdImage setCopyFrom (String copyFrom) {
      this.setParam("copy_from", copyFrom);
      return this;
    }

    public APIRequestCreateAdImage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdImage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdImage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdImage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdImage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdImage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdLabels extends APIRequest<AdLabel> {

    APINodeList<AdLabel> lastResponse = null;
    @Override
    public APINodeList<AdLabel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account",
      "created_time",
      "id",
      "name",
      "updated_time",
    };

    @Override
    public APINodeList<AdLabel> parseResponse(String response) throws APIException {
      return AdLabel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdLabel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdLabel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdLabel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdLabel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdLabel>>() {
           public APINodeList<AdLabel> apply(String result) {
             try {
               return APIRequestGetAdLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdLabels requestAccountField () {
      return this.requestAccountField(true);
    }
    public APIRequestGetAdLabels requestAccountField (boolean value) {
      this.requestField("account", value);
      return this;
    }
    public APIRequestGetAdLabels requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdLabels requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdLabels requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdLabels requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateAdLabel extends APIRequest<AdLabel> {

    AdLabel lastResponse = null;
    @Override
    public AdLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdLabel parseResponse(String response) throws APIException {
      return AdLabel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdLabel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdLabel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdLabel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdLabel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdLabel>() {
           public AdLabel apply(String result) {
             try {
               return APIRequestCreateAdLabel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdLanguageAsset extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bodies",
      "call_to_action_type",
      "default_language",
      "descriptions",
      "image",
      "link_urls",
      "titles",
      "video",
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
               return APIRequestCreateAdLanguageAsset.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdLanguageAsset(String nodeId, APIContext context) {
      super(context, nodeId, "/adlanguage_assets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLanguageAsset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLanguageAsset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLanguageAsset setBodies (List<Object> bodies) {
      this.setParam("bodies", bodies);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setBodies (String bodies) {
      this.setParam("bodies", bodies);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setCallToActionType (EnumCallToActionType callToActionType) {
      this.setParam("call_to_action_type", callToActionType);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setCallToActionType (String callToActionType) {
      this.setParam("call_to_action_type", callToActionType);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setDefaultLanguage (String defaultLanguage) {
      this.setParam("default_language", defaultLanguage);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setDescriptions (List<Object> descriptions) {
      this.setParam("descriptions", descriptions);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setDescriptions (String descriptions) {
      this.setParam("descriptions", descriptions);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setImage (Object image) {
      this.setParam("image", image);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setImage (String image) {
      this.setParam("image", image);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setLinkUrls (List<Object> linkUrls) {
      this.setParam("link_urls", linkUrls);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setLinkUrls (String linkUrls) {
      this.setParam("link_urls", linkUrls);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setTitles (List<Object> titles) {
      this.setParam("titles", titles);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setTitles (String titles) {
      this.setParam("titles", titles);
      return this;
    }

    public APIRequestCreateAdLanguageAsset setVideo (Object video) {
      this.setParam("video", video);
      return this;
    }
    public APIRequestCreateAdLanguageAsset setVideo (String video) {
      this.setParam("video", video);
      return this;
    }

    public APIRequestCreateAdLanguageAsset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLanguageAsset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLanguageAsset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLanguageAsset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLanguageAsset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLanguageAsset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdReportRuns extends APIRequest<AdReportRun> {

    APINodeList<AdReportRun> lastResponse = null;
    @Override
    public APINodeList<AdReportRun> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "async_percent_completion",
      "async_status",
      "date_start",
      "date_stop",
      "emails",
      "friendly_name",
      "id",
      "is_bookmarked",
      "is_running",
      "schedule_id",
      "time_completed",
      "time_ref",
    };

    @Override
    public APINodeList<AdReportRun> parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdReportRun> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdReportRun> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdReportRun>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdReportRun>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdReportRun>>() {
           public APINodeList<AdReportRun> apply(String result) {
             try {
               return APIRequestGetAdReportRuns.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdReportRuns(String nodeId, APIContext context) {
      super(context, nodeId, "/adreportruns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdReportRuns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdReportRuns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdReportRuns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdReportRuns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdReportRuns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdReportRuns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdReportRuns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdReportRuns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdReportRuns requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdReportRuns requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGetAdReportRuns requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGetAdReportRuns requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGetAdReportRuns requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGetAdReportRuns requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetAdReportRuns requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestFriendlyNameField () {
      return this.requestFriendlyNameField(true);
    }
    public APIRequestGetAdReportRuns requestFriendlyNameField (boolean value) {
      this.requestField("friendly_name", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdReportRuns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestIsBookmarkedField () {
      return this.requestIsBookmarkedField(true);
    }
    public APIRequestGetAdReportRuns requestIsBookmarkedField (boolean value) {
      this.requestField("is_bookmarked", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestIsRunningField () {
      return this.requestIsRunningField(true);
    }
    public APIRequestGetAdReportRuns requestIsRunningField (boolean value) {
      this.requestField("is_running", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGetAdReportRuns requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGetAdReportRuns requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGetAdReportRuns requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
  }

  public static class APIRequestGetAdReportSchedules extends APIRequest<APINode> {

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
               return APIRequestGetAdReportSchedules.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdReportSchedules(String nodeId, APIContext context) {
      super(context, nodeId, "/adreportschedules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdReportSchedules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdReportSchedules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdReportSchedules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdReportSchedules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdReportSchedules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdReportSchedules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdReportSchedules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdReportSchedules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdRulesHistory extends APIRequest<AdAccountAdRulesHistory> {

    APINodeList<AdAccountAdRulesHistory> lastResponse = null;
    @Override
    public APINodeList<AdAccountAdRulesHistory> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action",
      "hide_no_changes",
      "object_id",
    };

    public static final String[] FIELDS = {
      "evaluation_spec",
      "exception_code",
      "exception_message",
      "execution_spec",
      "is_manual",
      "results",
      "rule_id",
      "schedule_spec",
      "timestamp",
    };

    @Override
    public APINodeList<AdAccountAdRulesHistory> parseResponse(String response) throws APIException {
      return AdAccountAdRulesHistory.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountAdRulesHistory> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountAdRulesHistory> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountAdRulesHistory>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountAdRulesHistory>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountAdRulesHistory>>() {
           public APINodeList<AdAccountAdRulesHistory> apply(String result) {
             try {
               return APIRequestGetAdRulesHistory.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdRulesHistory(String nodeId, APIContext context) {
      super(context, nodeId, "/adrules_history", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdRulesHistory setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdRulesHistory setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdRulesHistory setAction (AdAccountAdRulesHistory.EnumAction action) {
      this.setParam("action", action);
      return this;
    }
    public APIRequestGetAdRulesHistory setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestGetAdRulesHistory setHideNoChanges (Boolean hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }
    public APIRequestGetAdRulesHistory setHideNoChanges (String hideNoChanges) {
      this.setParam("hide_no_changes", hideNoChanges);
      return this;
    }

    public APIRequestGetAdRulesHistory setObjectId (String objectId) {
      this.setParam("object_id", objectId);
      return this;
    }

    public APIRequestGetAdRulesHistory requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdRulesHistory requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesHistory requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdRulesHistory requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesHistory requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdRulesHistory requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdRulesHistory requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGetAdRulesHistory requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestExceptionCodeField () {
      return this.requestExceptionCodeField(true);
    }
    public APIRequestGetAdRulesHistory requestExceptionCodeField (boolean value) {
      this.requestField("exception_code", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestExceptionMessageField () {
      return this.requestExceptionMessageField(true);
    }
    public APIRequestGetAdRulesHistory requestExceptionMessageField (boolean value) {
      this.requestField("exception_message", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGetAdRulesHistory requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestIsManualField () {
      return this.requestIsManualField(true);
    }
    public APIRequestGetAdRulesHistory requestIsManualField (boolean value) {
      this.requestField("is_manual", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetAdRulesHistory requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestRuleIdField () {
      return this.requestRuleIdField(true);
    }
    public APIRequestGetAdRulesHistory requestRuleIdField (boolean value) {
      this.requestField("rule_id", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGetAdRulesHistory requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGetAdRulesHistory requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetAdRulesHistory requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
  }

  public static class APIRequestCreateAdRulesLibrary extends APIRequest<AdRule> {

    AdRule lastResponse = null;
    @Override
    public AdRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "evaluation_spec",
      "execution_spec",
      "name",
      "schedule_spec",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdRule parseResponse(String response) throws APIException {
      return AdRule.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRule execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdRule>() {
           public AdRule apply(String result) {
             try {
               return APIRequestCreateAdRulesLibrary.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdRulesLibrary(String nodeId, APIContext context) {
      super(context, nodeId, "/adrules_library", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdRulesLibrary setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdRulesLibrary setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdRulesLibrary setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestCreateAdRulesLibrary setEvaluationSpec (Object evaluationSpec) {
      this.setParam("evaluation_spec", evaluationSpec);
      return this;
    }
    public APIRequestCreateAdRulesLibrary setEvaluationSpec (String evaluationSpec) {
      this.setParam("evaluation_spec", evaluationSpec);
      return this;
    }

    public APIRequestCreateAdRulesLibrary setExecutionSpec (Object executionSpec) {
      this.setParam("execution_spec", executionSpec);
      return this;
    }
    public APIRequestCreateAdRulesLibrary setExecutionSpec (String executionSpec) {
      this.setParam("execution_spec", executionSpec);
      return this;
    }

    public APIRequestCreateAdRulesLibrary setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdRulesLibrary setScheduleSpec (Object scheduleSpec) {
      this.setParam("schedule_spec", scheduleSpec);
      return this;
    }
    public APIRequestCreateAdRulesLibrary setScheduleSpec (String scheduleSpec) {
      this.setParam("schedule_spec", scheduleSpec);
      return this;
    }

    public APIRequestCreateAdRulesLibrary setStatus (AdRule.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateAdRulesLibrary setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateAdRulesLibrary requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdRulesLibrary requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdRulesLibrary requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdRulesLibrary requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdRulesLibrary requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdRulesLibrary requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_draft_id",
      "date_preset",
      "effective_status",
      "time_range",
      "updated_since",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_review_feedback",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "id",
      "last_updated_by_app_id",
      "name",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(String result) {
             try {
               return APIRequestGetAds.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
      return this;
    }

    public APIRequestGetAds setDatePreset (Ad.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetAds setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetAds setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetAds setUpdatedSince (Long updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }
    public APIRequestGetAds setUpdatedSince (String updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }

    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAds requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAds requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAds requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAds requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAds requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAds requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAds requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAds requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAds requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAds requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAds requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAds requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAds requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAds requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetAds requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetAds requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetAds requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAds requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAds requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAds requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAds requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAds requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateAd extends APIRequest<Ad> {

    Ad lastResponse = null;
    @Override
    public Ad getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "adset_id",
      "adset_spec",
      "bid_amount",
      "creative",
      "date_format",
      "display_sequence",
      "execution_options",
      "name",
      "status",
      "tracking_specs",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Ad parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Ad execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Ad execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Ad> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Ad> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Ad>() {
           public Ad apply(String result) {
             try {
               return APIRequestCreateAd.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAd(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAd setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAd setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAd addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateAd setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateAd setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAd setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAd setAdsetId (Long adsetId) {
      this.setParam("adset_id", adsetId);
      return this;
    }
    public APIRequestCreateAd setAdsetId (String adsetId) {
      this.setParam("adset_id", adsetId);
      return this;
    }

    public APIRequestCreateAd setAdsetSpec (AdSet adsetSpec) {
      this.setParam("adset_spec", adsetSpec);
      return this;
    }
    public APIRequestCreateAd setAdsetSpec (String adsetSpec) {
      this.setParam("adset_spec", adsetSpec);
      return this;
    }

    public APIRequestCreateAd setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestCreateAd setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAd setCreative (AdCreative creative) {
      this.setParam("creative", creative);
      return this;
    }
    public APIRequestCreateAd setCreative (String creative) {
      this.setParam("creative", creative);
      return this;
    }

    public APIRequestCreateAd setDateFormat (String dateFormat) {
      this.setParam("date_format", dateFormat);
      return this;
    }

    public APIRequestCreateAd setDisplaySequence (Long displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }
    public APIRequestCreateAd setDisplaySequence (String displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }

    public APIRequestCreateAd setExecutionOptions (List<Ad.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestCreateAd setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAd setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAd setStatus (Ad.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateAd setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateAd setTrackingSpecs (Object trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }
    public APIRequestCreateAd setTrackingSpecs (String trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestCreateAd requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAd requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAd requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAd requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAd requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAd requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdsByLabels extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_label_ids",
      "operator",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_review_feedback",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "id",
      "last_updated_by_app_id",
      "name",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(String result) {
             try {
               return APIRequestGetAdsByLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adsbylabels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdsByLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdsByLabels setAdLabelIds (List<String> adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }
    public APIRequestGetAdsByLabels setAdLabelIds (String adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }

    public APIRequestGetAdsByLabels setOperator (Ad.EnumOperator operator) {
      this.setParam("operator", operator);
      return this;
    }
    public APIRequestGetAdsByLabels setOperator (String operator) {
      this.setParam("operator", operator);
      return this;
    }

    public APIRequestGetAdsByLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdsByLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAdsByLabels requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdsByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAdsByLabels requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAdsByLabels requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAdsByLabels requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAdsByLabels requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAdsByLabels requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdsByLabels requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdsByLabels requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAdsByLabels requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAdsByLabels requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdsByLabels requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAdsByLabels requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAdsByLabels requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAdsByLabels requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdsByLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAdsByLabels requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetAdsByLabels requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetAdsByLabels requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdsByLabels requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAdsByLabels requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdsByLabels requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetAdSets extends APIRequest<AdSet> {

    APINodeList<AdSet> lastResponse = null;
    @Override
    public APINodeList<AdSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_draft_id",
      "date_preset",
      "effective_status",
      "is_completed",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "effective_status",
      "end_time",
      "frequency_control_specs",
      "id",
      "instagram_actor_id",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdSet>>() {
           public APINodeList<AdSet> apply(String result) {
             try {
               return APIRequestGetAdSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
      return this;
    }

    public APIRequestGetAdSets setDatePreset (AdSet.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetAdSets setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAdSets setEffectiveStatus (List<AdSet.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAdSets setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetAdSets setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetAdSets setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetAdSets setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetAdSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdSets requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdSets requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdSets requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetAdSets requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetAdSets requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdSets requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdSets requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAdSets requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAdSets requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAdSets requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAdSets requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetAdSets requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetAdSets requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSets requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetAdSets requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSets requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdSets requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdSets requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdSets requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAdSets requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAdSets requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdSets requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdSets requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetAdSets requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSets requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyMinSpendTargetField () {
      return this.requestDailyMinSpendTargetField(true);
    }
    public APIRequestGetAdSets requestDailyMinSpendTargetField (boolean value) {
      this.requestField("daily_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSets requestDailySpendCapField () {
      return this.requestDailySpendCapField(true);
    }
    public APIRequestGetAdSets requestDailySpendCapField (boolean value) {
      this.requestField("daily_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestDestinationTypeField () {
      return this.requestDestinationTypeField(true);
    }
    public APIRequestGetAdSets requestDestinationTypeField (boolean value) {
      this.requestField("destination_type", value);
      return this;
    }
    public APIRequestGetAdSets requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAdSets requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAdSets requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdSets requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSets requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdSets requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSets requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeMinSpendTargetField () {
      return this.requestLifetimeMinSpendTargetField(true);
    }
    public APIRequestGetAdSets requestLifetimeMinSpendTargetField (boolean value) {
      this.requestField("lifetime_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeSpendCapField () {
      return this.requestLifetimeSpendCapField(true);
    }
    public APIRequestGetAdSets requestLifetimeSpendCapField (boolean value) {
      this.requestField("lifetime_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdSets requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetAdSets requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetAdSets requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSets requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSets requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSets requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetAdSets requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAdSets requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetAdSets requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetAdSets requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetAdSets requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGetAdSets requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetAdSets requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSets requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSets requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdSets requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSets requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetAdSets requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdSets requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAdSets requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetAdSets requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestCreateAdSet extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_strategy",
      "billing_event",
      "campaign_id",
      "campaign_spec",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "end_time",
      "execution_options",
      "frequency_control_specs",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "rf_prediction_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdSet parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdSet>() {
           public AdSet apply(String result) {
             try {
               return APIRequestCreateAdSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdSet(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdSet setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAdSet setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdSet setAdsetSchedule (List<Object> adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }
    public APIRequestCreateAdSet setAdsetSchedule (String adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestCreateAdSet setAttributionSpec (List<Map<String, String>> attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }
    public APIRequestCreateAdSet setAttributionSpec (String attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }

    public APIRequestCreateAdSet setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestCreateAdSet setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAdSet setBidStrategy (AdSet.EnumBidStrategy bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }
    public APIRequestCreateAdSet setBidStrategy (String bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }

    public APIRequestCreateAdSet setBillingEvent (AdSet.EnumBillingEvent billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }
    public APIRequestCreateAdSet setBillingEvent (String billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }

    public APIRequestCreateAdSet setCampaignId (String campaignId) {
      this.setParam("campaign_id", campaignId);
      return this;
    }

    public APIRequestCreateAdSet setCampaignSpec (Object campaignSpec) {
      this.setParam("campaign_spec", campaignSpec);
      return this;
    }
    public APIRequestCreateAdSet setCampaignSpec (String campaignSpec) {
      this.setParam("campaign_spec", campaignSpec);
      return this;
    }

    public APIRequestCreateAdSet setCreativeSequence (List<String> creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }
    public APIRequestCreateAdSet setCreativeSequence (String creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }

    public APIRequestCreateAdSet setDailyBudget (Long dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }
    public APIRequestCreateAdSet setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestCreateAdSet setDailyImps (Long dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }
    public APIRequestCreateAdSet setDailyImps (String dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }

    public APIRequestCreateAdSet setDailyMinSpendTarget (Long dailyMinSpendTarget) {
      this.setParam("daily_min_spend_target", dailyMinSpendTarget);
      return this;
    }
    public APIRequestCreateAdSet setDailyMinSpendTarget (String dailyMinSpendTarget) {
      this.setParam("daily_min_spend_target", dailyMinSpendTarget);
      return this;
    }

    public APIRequestCreateAdSet setDailySpendCap (Long dailySpendCap) {
      this.setParam("daily_spend_cap", dailySpendCap);
      return this;
    }
    public APIRequestCreateAdSet setDailySpendCap (String dailySpendCap) {
      this.setParam("daily_spend_cap", dailySpendCap);
      return this;
    }

    public APIRequestCreateAdSet setDestinationType (AdSet.EnumDestinationType destinationType) {
      this.setParam("destination_type", destinationType);
      return this;
    }
    public APIRequestCreateAdSet setDestinationType (String destinationType) {
      this.setParam("destination_type", destinationType);
      return this;
    }

    public APIRequestCreateAdSet setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateAdSet setExecutionOptions (List<AdSet.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestCreateAdSet setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAdSet setFrequencyControlSpecs (List<Object> frequencyControlSpecs) {
      this.setParam("frequency_control_specs", frequencyControlSpecs);
      return this;
    }
    public APIRequestCreateAdSet setFrequencyControlSpecs (String frequencyControlSpecs) {
      this.setParam("frequency_control_specs", frequencyControlSpecs);
      return this;
    }

    public APIRequestCreateAdSet setLifetimeBudget (Long lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }
    public APIRequestCreateAdSet setLifetimeBudget (String lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }

    public APIRequestCreateAdSet setLifetimeImps (Long lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }
    public APIRequestCreateAdSet setLifetimeImps (String lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }

    public APIRequestCreateAdSet setLifetimeMinSpendTarget (Long lifetimeMinSpendTarget) {
      this.setParam("lifetime_min_spend_target", lifetimeMinSpendTarget);
      return this;
    }
    public APIRequestCreateAdSet setLifetimeMinSpendTarget (String lifetimeMinSpendTarget) {
      this.setParam("lifetime_min_spend_target", lifetimeMinSpendTarget);
      return this;
    }

    public APIRequestCreateAdSet setLifetimeSpendCap (Long lifetimeSpendCap) {
      this.setParam("lifetime_spend_cap", lifetimeSpendCap);
      return this;
    }
    public APIRequestCreateAdSet setLifetimeSpendCap (String lifetimeSpendCap) {
      this.setParam("lifetime_spend_cap", lifetimeSpendCap);
      return this;
    }

    public APIRequestCreateAdSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdSet setOptimizationGoal (AdSet.EnumOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }
    public APIRequestCreateAdSet setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestCreateAdSet setPacingType (List<String> pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }
    public APIRequestCreateAdSet setPacingType (String pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }

    public APIRequestCreateAdSet setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestCreateAdSet setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestCreateAdSet setRfPredictionId (String rfPredictionId) {
      this.setParam("rf_prediction_id", rfPredictionId);
      return this;
    }

    public APIRequestCreateAdSet setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateAdSet setStatus (AdSet.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateAdSet setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateAdSet setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateAdSet setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreateAdSet setTimeBasedAdRotationIdBlocks (List<List<Long>> timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }
    public APIRequestCreateAdSet setTimeBasedAdRotationIdBlocks (String timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }

    public APIRequestCreateAdSet setTimeBasedAdRotationIntervals (List<Long> timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
      return this;
    }
    public APIRequestCreateAdSet setTimeBasedAdRotationIntervals (String timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
      return this;
    }

    public APIRequestCreateAdSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdSetsByLabels extends APIRequest<AdSet> {

    APINodeList<AdSet> lastResponse = null;
    @Override
    public APINodeList<AdSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_label_ids",
      "operator",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "effective_status",
      "end_time",
      "frequency_control_specs",
      "id",
      "instagram_actor_id",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdSet>>() {
           public APINodeList<AdSet> apply(String result) {
             try {
               return APIRequestGetAdSetsByLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdSetsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adsetsbylabels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdSetsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdSetsByLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSetsByLabels setAdLabelIds (List<String> adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }
    public APIRequestGetAdSetsByLabels setAdLabelIds (String adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }

    public APIRequestGetAdSetsByLabels setOperator (AdSet.EnumOperator operator) {
      this.setParam("operator", operator);
      return this;
    }
    public APIRequestGetAdSetsByLabels setOperator (String operator) {
      this.setParam("operator", operator);
      return this;
    }

    public APIRequestGetAdSetsByLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdSetsByLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSetsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdSetsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSetsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdSetsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdSetsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdSetsByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetAdSetsByLabels requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdSetsByLabels requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAdSetsByLabels requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAdSetsByLabels requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetAdSetsByLabels requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSetsByLabels requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSetsByLabels requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdSetsByLabels requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAdSetsByLabels requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdSetsByLabels requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetAdSetsByLabels requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSetsByLabels requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestDailyMinSpendTargetField () {
      return this.requestDailyMinSpendTargetField(true);
    }
    public APIRequestGetAdSetsByLabels requestDailyMinSpendTargetField (boolean value) {
      this.requestField("daily_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestDailySpendCapField () {
      return this.requestDailySpendCapField(true);
    }
    public APIRequestGetAdSetsByLabels requestDailySpendCapField (boolean value) {
      this.requestField("daily_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestDestinationTypeField () {
      return this.requestDestinationTypeField(true);
    }
    public APIRequestGetAdSetsByLabels requestDestinationTypeField (boolean value) {
      this.requestField("destination_type", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAdSetsByLabels requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdSetsByLabels requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSetsByLabels requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeMinSpendTargetField () {
      return this.requestLifetimeMinSpendTargetField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeMinSpendTargetField (boolean value) {
      this.requestField("lifetime_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeSpendCapField () {
      return this.requestLifetimeSpendCapField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeSpendCapField (boolean value) {
      this.requestField("lifetime_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdSetsByLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetAdSetsByLabels requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSetsByLabels requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSetsByLabels requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAdSetsByLabels requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetAdSetsByLabels requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGetAdSetsByLabels requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetAdSetsByLabels requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSetsByLabels requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdSetsByLabels requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSetsByLabels requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetAdSetsByLabels requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetAdSetsByLabels requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdSetsByLabels requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetAdSetsByLabels requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
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
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
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

  public static class APIRequestGetAdvertisableApplications extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "business_id",
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


    public APIRequestGetAdvertisableApplications setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestGetAdvertisableApplications setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
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

  }

  public static class APIRequestGetAdVideos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "max_aspect_ratio",
      "maxheight",
      "maxlength",
      "maxwidth",
      "min_aspect_ratio",
      "minheight",
      "minlength",
      "minwidth",
      "title",
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
               return APIRequestGetAdVideos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/advideos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdVideos setMaxAspectRatio (Double maxAspectRatio) {
      this.setParam("max_aspect_ratio", maxAspectRatio);
      return this;
    }
    public APIRequestGetAdVideos setMaxAspectRatio (String maxAspectRatio) {
      this.setParam("max_aspect_ratio", maxAspectRatio);
      return this;
    }

    public APIRequestGetAdVideos setMaxheight (Long maxheight) {
      this.setParam("maxheight", maxheight);
      return this;
    }
    public APIRequestGetAdVideos setMaxheight (String maxheight) {
      this.setParam("maxheight", maxheight);
      return this;
    }

    public APIRequestGetAdVideos setMaxlength (Long maxlength) {
      this.setParam("maxlength", maxlength);
      return this;
    }
    public APIRequestGetAdVideos setMaxlength (String maxlength) {
      this.setParam("maxlength", maxlength);
      return this;
    }

    public APIRequestGetAdVideos setMaxwidth (Long maxwidth) {
      this.setParam("maxwidth", maxwidth);
      return this;
    }
    public APIRequestGetAdVideos setMaxwidth (String maxwidth) {
      this.setParam("maxwidth", maxwidth);
      return this;
    }

    public APIRequestGetAdVideos setMinAspectRatio (Double minAspectRatio) {
      this.setParam("min_aspect_ratio", minAspectRatio);
      return this;
    }
    public APIRequestGetAdVideos setMinAspectRatio (String minAspectRatio) {
      this.setParam("min_aspect_ratio", minAspectRatio);
      return this;
    }

    public APIRequestGetAdVideos setMinheight (Long minheight) {
      this.setParam("minheight", minheight);
      return this;
    }
    public APIRequestGetAdVideos setMinheight (String minheight) {
      this.setParam("minheight", minheight);
      return this;
    }

    public APIRequestGetAdVideos setMinlength (Long minlength) {
      this.setParam("minlength", minlength);
      return this;
    }
    public APIRequestGetAdVideos setMinlength (String minlength) {
      this.setParam("minlength", minlength);
      return this;
    }

    public APIRequestGetAdVideos setMinwidth (Long minwidth) {
      this.setParam("minwidth", minwidth);
      return this;
    }
    public APIRequestGetAdVideos setMinwidth (String minwidth) {
      this.setParam("minwidth", minwidth);
      return this;
    }

    public APIRequestGetAdVideos setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestGetAdVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdVideo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "audio_story_wave_animation_handle",
      "composer_session_id",
      "description",
      "end_offset",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "front_z_rotation",
      "is_explicit_share",
      "manual_privacy",
      "name",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_suggestion_mechanism",
      "original_fov",
      "original_projection_type",
      "react_mode_metadata",
      "referenced_sticker_id",
      "slideshow_spec",
      "start_offset",
      "time_since_original_post",
      "title",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "video_file_chunk",
      "file",
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
               return APIRequestCreateAdVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/advideos", "POST", Arrays.asList(PARAMS));
      this.setUseVideoEndpoint(true);
    }

    @Override
    public APIRequestCreateAdVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAdVideo addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateAdVideo setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateAdVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateAdVideo setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateAdVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAdVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateAdVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateAdVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateAdVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateAdVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateAdVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateAdVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateAdVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateAdVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateAdVideo setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateAdVideo setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }

    public APIRequestCreateAdVideo setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreateAdVideo setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreateAdVideo setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdVideo setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateAdVideo setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateAdVideo setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateAdVideo setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateAdVideo setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreateAdVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateAdVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateAdVideo setOriginalProjectionType (EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateAdVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateAdVideo setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateAdVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateAdVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateAdVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateAdVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateAdVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateAdVideo setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateAdVideo setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateAdVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateAdVideo setUnpublishedContentType (EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateAdVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateAdVideo setUploadPhase (EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateAdVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateAdVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateAdVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }
    public APIRequestCreateAdVideo setVideoFileChunk (File videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateAdVideo setVideoFileChunk (byte[] videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateAdVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdVideo requestField (String field, boolean value) {
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

  public static class APIRequestCreateAgency extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
      "permitted_roles",
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
               return APIRequestCreateAgency.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAgency(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAgency setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAgency setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAgency setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateAgency setPermittedRoles (List<AdAccount.EnumPermittedRoles> permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }
    public APIRequestCreateAgency setPermittedRoles (String permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreateAgency requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAgency requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAgency requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAgency requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAgency requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAgency requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetApplications extends APIRequest<APINode> {

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
               return APIRequestGetApplications.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  }

  public static class APIRequestDeleteAssignedUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
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
               return APIRequestDeleteAssignedUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAssignedUsers setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteAssignedUsers setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAssignedUsers extends APIRequest<AssignedUser> {

    APINodeList<AssignedUser> lastResponse = null;
    @Override
    public APINodeList<AssignedUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "name",
      "user_type",
    };

    @Override
    public APINodeList<AssignedUser> parseResponse(String response) throws APIException {
      return AssignedUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AssignedUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AssignedUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AssignedUser>>() {
           public APINodeList<AssignedUser> apply(String result) {
             try {
               return APIRequestGetAssignedUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedUsers setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestUserTypeField () {
      return this.requestUserTypeField(true);
    }
    public APIRequestGetAssignedUsers requestUserTypeField (boolean value) {
      this.requestField("user_type", value);
      return this;
    }
  }

  public static class APIRequestCreateAssignedUser extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "role",
      "user",
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
               return APIRequestCreateAssignedUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAssignedUser(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAssignedUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAssignedUser setRole (AdAccount.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateAssignedUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateAssignedUser setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateAssignedUser setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateAssignedUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAssignedUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAsyncBatchRequest extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adbatch",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
             try {
               return APIRequestCreateAsyncBatchRequest.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAsyncBatchRequest(String nodeId, APIContext context) {
      super(context, nodeId, "/async_batch_requests", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAsyncBatchRequest setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAsyncBatchRequest setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAsyncBatchRequest setAdbatch (List<Object> adbatch) {
      this.setParam("adbatch", adbatch);
      return this;
    }
    public APIRequestCreateAsyncBatchRequest setAdbatch (String adbatch) {
      this.setParam("adbatch", adbatch);
      return this;
    }

    public APIRequestCreateAsyncBatchRequest setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAsyncBatchRequest requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAsyncBatchRequest requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsyncBatchRequest requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAsyncBatchRequest requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsyncBatchRequest requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAsyncBatchRequest requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAsyncAdRequestSets extends APIRequest<AdAsyncRequestSet> {

    APINodeList<AdAsyncRequestSet> lastResponse = null;
    @Override
    public APINodeList<AdAsyncRequestSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_completed",
    };

    public static final String[] FIELDS = {
      "canceled_count",
      "created_time",
      "error_count",
      "id",
      "in_progress_count",
      "initial_count",
      "is_completed",
      "name",
      "notification_mode",
      "notification_result",
      "notification_status",
      "notification_uri",
      "owner_id",
      "success_count",
      "total_count",
      "updated_time",
    };

    @Override
    public APINodeList<AdAsyncRequestSet> parseResponse(String response) throws APIException {
      return AdAsyncRequestSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAsyncRequestSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAsyncRequestSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAsyncRequestSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAsyncRequestSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAsyncRequestSet>>() {
           public APINodeList<AdAsyncRequestSet> apply(String result) {
             try {
               return APIRequestGetAsyncAdRequestSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAsyncAdRequestSets(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequestsets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAsyncAdRequestSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequestSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAsyncAdRequestSets setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetAsyncAdRequestSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAsyncAdRequestSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequestSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAsyncAdRequestSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequestSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequestSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAsyncAdRequestSets requestCanceledCountField () {
      return this.requestCanceledCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestCanceledCountField (boolean value) {
      this.requestField("canceled_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestErrorCountField () {
      return this.requestErrorCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestErrorCountField (boolean value) {
      this.requestField("error_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestInProgressCountField () {
      return this.requestInProgressCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestInProgressCountField (boolean value) {
      this.requestField("in_progress_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestInitialCountField () {
      return this.requestInitialCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestInitialCountField (boolean value) {
      this.requestField("initial_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestIsCompletedField () {
      return this.requestIsCompletedField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestIsCompletedField (boolean value) {
      this.requestField("is_completed", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationModeField () {
      return this.requestNotificationModeField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationModeField (boolean value) {
      this.requestField("notification_mode", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationResultField () {
      return this.requestNotificationResultField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationResultField (boolean value) {
      this.requestField("notification_result", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationStatusField () {
      return this.requestNotificationStatusField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationStatusField (boolean value) {
      this.requestField("notification_status", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationUriField () {
      return this.requestNotificationUriField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationUriField (boolean value) {
      this.requestField("notification_uri", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestSuccessCountField () {
      return this.requestSuccessCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestSuccessCountField (boolean value) {
      this.requestField("success_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateAsyncAdRequestSet extends APIRequest<AdAsyncRequestSet> {

    AdAsyncRequestSet lastResponse = null;
    @Override
    public AdAsyncRequestSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_specs",
      "name",
      "notification_mode",
      "notification_uri",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAsyncRequestSet parseResponse(String response) throws APIException {
      return AdAsyncRequestSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAsyncRequestSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequestSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAsyncRequestSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAsyncRequestSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAsyncRequestSet>() {
           public AdAsyncRequestSet apply(String result) {
             try {
               return APIRequestCreateAsyncAdRequestSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAsyncAdRequestSet(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequestsets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAsyncAdRequestSet setAdSpecs (List<Map<String, String>> adSpecs) {
      this.setParam("ad_specs", adSpecs);
      return this;
    }
    public APIRequestCreateAsyncAdRequestSet setAdSpecs (String adSpecs) {
      this.setParam("ad_specs", adSpecs);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet setNotificationMode (EnumNotificationMode notificationMode) {
      this.setParam("notification_mode", notificationMode);
      return this;
    }
    public APIRequestCreateAsyncAdRequestSet setNotificationMode (String notificationMode) {
      this.setParam("notification_mode", notificationMode);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet setNotificationUri (String notificationUri) {
      this.setParam("notification_uri", notificationUri);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAsyncAdRequestSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAsyncAdRequestSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAudienceReplace extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "payload",
      "session",
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
               return APIRequestCreateAudienceReplace.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAudienceReplace(String nodeId, APIContext context) {
      super(context, nodeId, "/audiencereplace", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAudienceReplace setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAudienceReplace setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAudienceReplace setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestCreateAudienceReplace setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateAudienceReplace setSession (Object session) {
      this.setParam("session", session);
      return this;
    }
    public APIRequestCreateAudienceReplace setSession (String session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestCreateAudienceReplace requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAudienceReplace requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAudienceReplace requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAudienceReplace requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAudienceReplace requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAudienceReplace requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBroadTargetingCategories extends APIRequest<BroadTargetingCategories> {

    APINodeList<BroadTargetingCategories> lastResponse = null;
    @Override
    public APINodeList<BroadTargetingCategories> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_categories_only",
    };

    public static final String[] FIELDS = {
      "category_description",
      "id",
      "name",
      "parent_category",
      "path",
      "size",
      "source",
      "type",
      "type_name",
      "untranslated_name",
      "untranslated_parent_name",
    };

    @Override
    public APINodeList<BroadTargetingCategories> parseResponse(String response) throws APIException {
      return BroadTargetingCategories.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BroadTargetingCategories> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BroadTargetingCategories> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BroadTargetingCategories>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BroadTargetingCategories>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BroadTargetingCategories>>() {
           public APINodeList<BroadTargetingCategories> apply(String result) {
             try {
               return APIRequestGetBroadTargetingCategories.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBroadTargetingCategories(String nodeId, APIContext context) {
      super(context, nodeId, "/broadtargetingcategories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBroadTargetingCategories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBroadTargetingCategories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBroadTargetingCategories setCustomCategoriesOnly (Boolean customCategoriesOnly) {
      this.setParam("custom_categories_only", customCategoriesOnly);
      return this;
    }
    public APIRequestGetBroadTargetingCategories setCustomCategoriesOnly (String customCategoriesOnly) {
      this.setParam("custom_categories_only", customCategoriesOnly);
      return this;
    }

    public APIRequestGetBroadTargetingCategories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBroadTargetingCategories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBroadTargetingCategories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBroadTargetingCategories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBroadTargetingCategories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBroadTargetingCategories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBroadTargetingCategories requestCategoryDescriptionField () {
      return this.requestCategoryDescriptionField(true);
    }
    public APIRequestGetBroadTargetingCategories requestCategoryDescriptionField (boolean value) {
      this.requestField("category_description", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBroadTargetingCategories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBroadTargetingCategories requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestParentCategoryField () {
      return this.requestParentCategoryField(true);
    }
    public APIRequestGetBroadTargetingCategories requestParentCategoryField (boolean value) {
      this.requestField("parent_category", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetBroadTargetingCategories requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGetBroadTargetingCategories requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetBroadTargetingCategories requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetBroadTargetingCategories requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestTypeNameField () {
      return this.requestTypeNameField(true);
    }
    public APIRequestGetBroadTargetingCategories requestTypeNameField (boolean value) {
      this.requestField("type_name", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestUntranslatedNameField () {
      return this.requestUntranslatedNameField(true);
    }
    public APIRequestGetBroadTargetingCategories requestUntranslatedNameField (boolean value) {
      this.requestField("untranslated_name", value);
      return this;
    }
    public APIRequestGetBroadTargetingCategories requestUntranslatedParentNameField () {
      return this.requestUntranslatedParentNameField(true);
    }
    public APIRequestGetBroadTargetingCategories requestUntranslatedParentNameField (boolean value) {
      this.requestField("untranslated_parent_name", value);
      return this;
    }
  }

  public static class APIRequestDeleteCampaigns extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "before_date",
      "delete_strategy",
      "object_count",
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
               return APIRequestDeleteCampaigns.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteCampaigns setBeforeDate (String beforeDate) {
      this.setParam("before_date", beforeDate);
      return this;
    }

    public APIRequestDeleteCampaigns setDeleteStrategy (Campaign.EnumDeleteStrategy deleteStrategy) {
      this.setParam("delete_strategy", deleteStrategy);
      return this;
    }
    public APIRequestDeleteCampaigns setDeleteStrategy (String deleteStrategy) {
      this.setParam("delete_strategy", deleteStrategy);
      return this;
    }

    public APIRequestDeleteCampaigns setObjectCount (Long objectCount) {
      this.setParam("object_count", objectCount);
      return this;
    }
    public APIRequestDeleteCampaigns setObjectCount (String objectCount) {
      this.setParam("object_count", objectCount);
      return this;
    }

    public APIRequestDeleteCampaigns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteCampaigns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCampaigns extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "effective_status",
      "is_completed",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "bid_strategy",
      "boosted_object_id",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "budget_remaining",
      "buying_type",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "id",
      "lifetime_budget",
      "name",
      "objective",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Campaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Campaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Campaign>>() {
           public APINodeList<Campaign> apply(String result) {
             try {
               return APIRequestGetCampaigns.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaigns setDatePreset (Campaign.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCampaigns setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCampaigns setEffectiveStatus (List<Campaign.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetCampaigns setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCampaigns setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetCampaigns setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetCampaigns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCampaigns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaigns requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaigns requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaigns requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaigns requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetCampaigns requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetCampaigns requestBoostedObjectIdField () {
      return this.requestBoostedObjectIdField(true);
    }
    public APIRequestGetCampaigns requestBoostedObjectIdField (boolean value) {
      this.requestField("boosted_object_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGetCampaigns requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGetCampaigns requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGetCampaigns requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGetCampaigns requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCampaigns requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCampaigns requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaigns requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetCampaigns requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGetCampaigns requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGetCampaigns requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGetCampaigns requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
      return this;
    }
    public APIRequestGetCampaigns requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCampaigns requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCampaigns requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCampaigns requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetCampaigns requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetCampaigns requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaigns requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCampaigns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaigns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaigns requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCampaigns requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCampaigns requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCampaigns requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCampaigns requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetCampaigns requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetCampaigns requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCampaigns requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCampaigns requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGetCampaigns requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGetCampaigns requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGetCampaigns requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaigns requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetCampaigns requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaigns requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCampaigns requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCampaigns requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGetCampaigns requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCampaigns requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateCampaign extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "bid_strategy",
      "budget_rebalance_flag",
      "buying_type",
      "daily_budget",
      "execution_options",
      "iterative_split_test_configs",
      "lifetime_budget",
      "name",
      "objective",
      "promoted_object",
      "spend_cap",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
             try {
               return APIRequestCreateCampaign.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCampaign(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCampaign setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCampaign setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCampaign setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateCampaign setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateCampaign setBidStrategy (Campaign.EnumBidStrategy bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }
    public APIRequestCreateCampaign setBidStrategy (String bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }

    public APIRequestCreateCampaign setBudgetRebalanceFlag (Boolean budgetRebalanceFlag) {
      this.setParam("budget_rebalance_flag", budgetRebalanceFlag);
      return this;
    }
    public APIRequestCreateCampaign setBudgetRebalanceFlag (String budgetRebalanceFlag) {
      this.setParam("budget_rebalance_flag", budgetRebalanceFlag);
      return this;
    }

    public APIRequestCreateCampaign setBuyingType (String buyingType) {
      this.setParam("buying_type", buyingType);
      return this;
    }

    public APIRequestCreateCampaign setDailyBudget (Long dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }
    public APIRequestCreateCampaign setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestCreateCampaign setExecutionOptions (List<Campaign.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestCreateCampaign setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateCampaign setIterativeSplitTestConfigs (List<Object> iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
      return this;
    }
    public APIRequestCreateCampaign setIterativeSplitTestConfigs (String iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
      return this;
    }

    public APIRequestCreateCampaign setLifetimeBudget (Long lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }
    public APIRequestCreateCampaign setLifetimeBudget (String lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }

    public APIRequestCreateCampaign setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCampaign setObjective (Campaign.EnumObjective objective) {
      this.setParam("objective", objective);
      return this;
    }
    public APIRequestCreateCampaign setObjective (String objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateCampaign setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestCreateCampaign setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestCreateCampaign setSpendCap (Long spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }
    public APIRequestCreateCampaign setSpendCap (String spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }

    public APIRequestCreateCampaign setStatus (Campaign.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateCampaign setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateCampaign requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCampaign requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCampaign requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCampaign requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCampaign requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCampaign requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCampaignsByLabels extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_label_ids",
      "operator",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "bid_strategy",
      "boosted_object_id",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "budget_remaining",
      "buying_type",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "id",
      "lifetime_budget",
      "name",
      "objective",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Campaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Campaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Campaign>>() {
           public APINodeList<Campaign> apply(String result) {
             try {
               return APIRequestGetCampaignsByLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCampaignsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/campaignsbylabels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCampaignsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCampaignsByLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaignsByLabels setAdLabelIds (List<String> adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }
    public APIRequestGetCampaignsByLabels setAdLabelIds (String adLabelIds) {
      this.setParam("ad_label_ids", adLabelIds);
      return this;
    }

    public APIRequestGetCampaignsByLabels setOperator (Campaign.EnumOperator operator) {
      this.setParam("operator", operator);
      return this;
    }
    public APIRequestGetCampaignsByLabels setOperator (String operator) {
      this.setParam("operator", operator);
      return this;
    }

    public APIRequestGetCampaignsByLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCampaignsByLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaignsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCampaignsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaignsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCampaignsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaignsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaignsByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetCampaignsByLabels requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBoostedObjectIdField () {
      return this.requestBoostedObjectIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestBoostedObjectIdField (boolean value) {
      this.requestField("boosted_object_id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGetCampaignsByLabels requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGetCampaignsByLabels requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCampaignsByLabels requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaignsByLabels requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGetCampaignsByLabels requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGetCampaignsByLabels requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCampaignsByLabels requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCampaignsByLabels requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetCampaignsByLabels requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaignsByLabels requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCampaignsByLabels requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCampaignsByLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetCampaignsByLabels requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCampaignsByLabels requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGetCampaignsByLabels requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaignsByLabels requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaignsByLabels requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCampaignsByLabels requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGetCampaignsByLabels requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCampaignsByLabels requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetCustomAudiences extends APIRequest<CustomAudience> {

    APINodeList<CustomAudience> lastResponse = null;
    @Override
    public APINodeList<CustomAudience> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_id",
      "fields",
      "filtering",
      "pixel_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<CustomAudience> parseResponse(String response) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudience> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudience> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CustomAudience>>() {
           public APINodeList<CustomAudience> apply(String result) {
             try {
               return APIRequestGetCustomAudiences.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCustomAudiences(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiences", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCustomAudiences setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCustomAudiences setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomAudiences setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetCustomAudiences setFields (List<CustomAudience.EnumFields> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetCustomAudiences setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetCustomAudiences setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetCustomAudiences setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetCustomAudiences setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }

    public APIRequestGetCustomAudiences requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomAudiences requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudiences requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCustomAudiences requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudiences requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCustomAudiences requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateCustomAudience extends APIRequest<CustomAudience> {

    CustomAudience lastResponse = null;
    @Override
    public CustomAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allowed_domains",
      "claim_objective",
      "content_type",
      "customer_file_source",
      "dataset_id",
      "description",
      "event_source_group",
      "event_sources",
      "is_value_based",
      "list_of_accounts",
      "lookalike_spec",
      "name",
      "opt_out_link",
      "origin_audience_id",
      "pixel_id",
      "prefill",
      "product_set_id",
      "retention_days",
      "rule",
      "rule_aggregation",
      "subtype",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomAudience parseResponse(String response) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomAudience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomAudience execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CustomAudience> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomAudience> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CustomAudience>() {
           public CustomAudience apply(String result) {
             try {
               return APIRequestCreateCustomAudience.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCustomAudience(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiences", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCustomAudience setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCustomAudience setAllowedDomains (List<String> allowedDomains) {
      this.setParam("allowed_domains", allowedDomains);
      return this;
    }
    public APIRequestCreateCustomAudience setAllowedDomains (String allowedDomains) {
      this.setParam("allowed_domains", allowedDomains);
      return this;
    }

    public APIRequestCreateCustomAudience setClaimObjective (CustomAudience.EnumClaimObjective claimObjective) {
      this.setParam("claim_objective", claimObjective);
      return this;
    }
    public APIRequestCreateCustomAudience setClaimObjective (String claimObjective) {
      this.setParam("claim_objective", claimObjective);
      return this;
    }

    public APIRequestCreateCustomAudience setContentType (CustomAudience.EnumContentType contentType) {
      this.setParam("content_type", contentType);
      return this;
    }
    public APIRequestCreateCustomAudience setContentType (String contentType) {
      this.setParam("content_type", contentType);
      return this;
    }

    public APIRequestCreateCustomAudience setCustomerFileSource (CustomAudience.EnumCustomerFileSource customerFileSource) {
      this.setParam("customer_file_source", customerFileSource);
      return this;
    }
    public APIRequestCreateCustomAudience setCustomerFileSource (String customerFileSource) {
      this.setParam("customer_file_source", customerFileSource);
      return this;
    }

    public APIRequestCreateCustomAudience setDatasetId (String datasetId) {
      this.setParam("dataset_id", datasetId);
      return this;
    }

    public APIRequestCreateCustomAudience setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateCustomAudience setEventSourceGroup (String eventSourceGroup) {
      this.setParam("event_source_group", eventSourceGroup);
      return this;
    }

    public APIRequestCreateCustomAudience setEventSources (List<Map<String, String>> eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }
    public APIRequestCreateCustomAudience setEventSources (String eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }

    public APIRequestCreateCustomAudience setIsValueBased (Boolean isValueBased) {
      this.setParam("is_value_based", isValueBased);
      return this;
    }
    public APIRequestCreateCustomAudience setIsValueBased (String isValueBased) {
      this.setParam("is_value_based", isValueBased);
      return this;
    }

    public APIRequestCreateCustomAudience setListOfAccounts (List<Long> listOfAccounts) {
      this.setParam("list_of_accounts", listOfAccounts);
      return this;
    }
    public APIRequestCreateCustomAudience setListOfAccounts (String listOfAccounts) {
      this.setParam("list_of_accounts", listOfAccounts);
      return this;
    }

    public APIRequestCreateCustomAudience setLookalikeSpec (String lookalikeSpec) {
      this.setParam("lookalike_spec", lookalikeSpec);
      return this;
    }

    public APIRequestCreateCustomAudience setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCustomAudience setOptOutLink (String optOutLink) {
      this.setParam("opt_out_link", optOutLink);
      return this;
    }

    public APIRequestCreateCustomAudience setOriginAudienceId (String originAudienceId) {
      this.setParam("origin_audience_id", originAudienceId);
      return this;
    }

    public APIRequestCreateCustomAudience setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }

    public APIRequestCreateCustomAudience setPrefill (Boolean prefill) {
      this.setParam("prefill", prefill);
      return this;
    }
    public APIRequestCreateCustomAudience setPrefill (String prefill) {
      this.setParam("prefill", prefill);
      return this;
    }

    public APIRequestCreateCustomAudience setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
      return this;
    }

    public APIRequestCreateCustomAudience setRetentionDays (Long retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }
    public APIRequestCreateCustomAudience setRetentionDays (String retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }

    public APIRequestCreateCustomAudience setRule (String rule) {
      this.setParam("rule", rule);
      return this;
    }

    public APIRequestCreateCustomAudience setRuleAggregation (String ruleAggregation) {
      this.setParam("rule_aggregation", ruleAggregation);
      return this;
    }

    public APIRequestCreateCustomAudience setSubtype (CustomAudience.EnumSubtype subtype) {
      this.setParam("subtype", subtype);
      return this;
    }
    public APIRequestCreateCustomAudience setSubtype (String subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateCustomAudience requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCustomAudience requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCustomAudience requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCustomAudiencesTos extends APIRequest<CustomAudiencesTOS> {

    APINodeList<CustomAudiencesTOS> lastResponse = null;
    @Override
    public APINodeList<CustomAudiencesTOS> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "content",
      "id",
      "type",
    };

    @Override
    public APINodeList<CustomAudiencesTOS> parseResponse(String response) throws APIException {
      return CustomAudiencesTOS.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudiencesTOS> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudiencesTOS> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomAudiencesTOS>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomAudiencesTOS>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CustomAudiencesTOS>>() {
           public APINodeList<CustomAudiencesTOS> apply(String result) {
             try {
               return APIRequestGetCustomAudiencesTos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCustomAudiencesTos(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiencestos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCustomAudiencesTos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCustomAudiencesTos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomAudiencesTos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomAudiencesTos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudiencesTos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCustomAudiencesTos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomAudiencesTos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCustomAudiencesTos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCustomAudiencesTos requestContentField () {
      return this.requestContentField(true);
    }
    public APIRequestGetCustomAudiencesTos requestContentField (boolean value) {
      this.requestField("content", value);
      return this;
    }
    public APIRequestGetCustomAudiencesTos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCustomAudiencesTos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCustomAudiencesTos requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetCustomAudiencesTos requestTypeField (boolean value) {
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

  public static class APIRequestGetDeliveryEstimate extends APIRequest<AdAccountDeliveryEstimate> {

    APINodeList<AdAccountDeliveryEstimate> lastResponse = null;
    @Override
    public APINodeList<AdAccountDeliveryEstimate> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "optimization_goal",
      "promoted_object",
      "targeting_spec",
    };

    public static final String[] FIELDS = {
      "daily_outcomes_curve",
      "estimate_dau",
      "estimate_mau",
      "estimate_ready",
    };

    @Override
    public APINodeList<AdAccountDeliveryEstimate> parseResponse(String response) throws APIException {
      return AdAccountDeliveryEstimate.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountDeliveryEstimate> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountDeliveryEstimate> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountDeliveryEstimate>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountDeliveryEstimate>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountDeliveryEstimate>>() {
           public APINodeList<AdAccountDeliveryEstimate> apply(String result) {
             try {
               return APIRequestGetDeliveryEstimate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDeliveryEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/delivery_estimate", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDeliveryEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDeliveryEstimate setOptimizationGoal (AdAccountDeliveryEstimate.EnumOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }
    public APIRequestGetDeliveryEstimate setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestGetDeliveryEstimate setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestGetDeliveryEstimate setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestGetDeliveryEstimate setTargetingSpec (Targeting targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }
    public APIRequestGetDeliveryEstimate setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDeliveryEstimate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField () {
      return this.requestDailyOutcomesCurveField(true);
    }
    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField (boolean value) {
      this.requestField("daily_outcomes_curve", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField () {
      return this.requestEstimateDauField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField (boolean value) {
      this.requestField("estimate_dau", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauField () {
      return this.requestEstimateMauField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauField (boolean value) {
      this.requestField("estimate_mau", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
      return this;
    }
  }

  public static class APIRequestGetGeneratePreviews extends APIRequest<AdPreview> {

    APINodeList<AdPreview> lastResponse = null;
    @Override
    public APINodeList<AdPreview> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_format",
      "creative",
      "dynamic_creative_spec",
      "end_date",
      "height",
      "place_page_id",
      "post",
      "product_item_ids",
      "start_date",
      "width",
    };

    public static final String[] FIELDS = {
      "body",
    };

    @Override
    public APINodeList<AdPreview> parseResponse(String response) throws APIException {
      return AdPreview.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdPreview> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPreview> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdPreview>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdPreview>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdPreview>>() {
           public APINodeList<AdPreview> apply(String result) {
             try {
               return APIRequestGetGeneratePreviews.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetGeneratePreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/generatepreviews", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetGeneratePreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetGeneratePreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGeneratePreviews setAdFormat (AdPreview.EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }
    public APIRequestGetGeneratePreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetGeneratePreviews setCreative (AdCreative creative) {
      this.setParam("creative", creative);
      return this;
    }
    public APIRequestGetGeneratePreviews setCreative (String creative) {
      this.setParam("creative", creative);
      return this;
    }

    public APIRequestGetGeneratePreviews setDynamicCreativeSpec (Object dynamicCreativeSpec) {
      this.setParam("dynamic_creative_spec", dynamicCreativeSpec);
      return this;
    }
    public APIRequestGetGeneratePreviews setDynamicCreativeSpec (String dynamicCreativeSpec) {
      this.setParam("dynamic_creative_spec", dynamicCreativeSpec);
      return this;
    }

    public APIRequestGetGeneratePreviews setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetGeneratePreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetGeneratePreviews setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetGeneratePreviews setPlacePageId (Long placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }
    public APIRequestGetGeneratePreviews setPlacePageId (String placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }

    public APIRequestGetGeneratePreviews setPost (Object post) {
      this.setParam("post", post);
      return this;
    }
    public APIRequestGetGeneratePreviews setPost (String post) {
      this.setParam("post", post);
      return this;
    }

    public APIRequestGetGeneratePreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }
    public APIRequestGetGeneratePreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetGeneratePreviews setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetGeneratePreviews setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetGeneratePreviews setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetGeneratePreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGeneratePreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGeneratePreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetGeneratePreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGeneratePreviews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetGeneratePreviews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetGeneratePreviews requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetGeneratePreviews requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
  }

  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsInsights>>() {
           public APINodeList<AdsInsights> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsights setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsights setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsights setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsights setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsights setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsights setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsights setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsights setFields (List<AdsInsights.EnumSummary> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsights setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsights setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsights setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsights setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsights setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsights setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsights setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsights setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsights setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsights setSummary (List<AdsInsights.EnumSummary> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsights setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsights setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsights setTimeRanges (List<Object> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsights setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsights setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsightsAsync extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportRun parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdReportRun>() {
           public AdReportRun apply(String result) {
             try {
               return APIRequestGetInsightsAsync.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsAsync setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsAsync setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsightsAsync setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsAsync setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsightsAsync setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsAsync setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsightsAsync setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsAsync setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsightsAsync setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsAsync setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsightsAsync setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsightsAsync setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsightsAsync setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsightsAsync setFields (List<AdsInsights.EnumSummary> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsightsAsync setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsAsync setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsightsAsync setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsAsync setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsightsAsync setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsAsync setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsightsAsync setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsAsync setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsightsAsync setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsAsync setSummary (List<AdsInsights.EnumSummary> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsightsAsync setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRanges (List<Object> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsAsync requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInstagramAccounts extends APIRequest<APINode> {

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
               return APIRequestGetInstagramAccounts.this.parseResponse(result);
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

  }

  public static class APIRequestGetLeadGenForms extends APIRequest<LeadgenForm> {

    APINodeList<LeadgenForm> lastResponse = null;
    @Override
    public APINodeList<LeadgenForm> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "query",
    };

    public static final String[] FIELDS = {
      "allow_organic_lead",
      "block_display_for_non_targeted_viewer",
      "context_card",
      "created_time",
      "creator",
      "creator_id",
      "cusomized_tcpa_content",
      "expired_leads_count",
      "extra_details",
      "follow_up_action_text",
      "follow_up_action_url",
      "id",
      "is_optimized_for_quality",
      "leadgen_export_csv_url",
      "leads_count",
      "legal_content",
      "locale",
      "messenger_welcome_message",
      "name",
      "organic_leads_count",
      "page",
      "page_id",
      "privacy_policy_url",
      "qualifiers",
      "question_page_custom_headline",
      "questions",
      "status",
      "tcpa_compliance",
      "thank_you_page",
    };

    @Override
    public APINodeList<LeadgenForm> parseResponse(String response) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LeadgenForm> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LeadgenForm> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LeadgenForm>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LeadgenForm>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LeadgenForm>>() {
           public APINodeList<LeadgenForm> apply(String result) {
             try {
               return APIRequestGetLeadGenForms.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLeadGenForms(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_forms", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLeadGenForms setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeadGenForms setQuery (String query) {
      this.setParam("query", query);
      return this;
    }

    public APIRequestGetLeadGenForms requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeadGenForms requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLeadGenForms requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLeadGenForms requestAllowOrganicLeadField () {
      return this.requestAllowOrganicLeadField(true);
    }
    public APIRequestGetLeadGenForms requestAllowOrganicLeadField (boolean value) {
      this.requestField("allow_organic_lead", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestBlockDisplayForNonTargetedViewerField () {
      return this.requestBlockDisplayForNonTargetedViewerField(true);
    }
    public APIRequestGetLeadGenForms requestBlockDisplayForNonTargetedViewerField (boolean value) {
      this.requestField("block_display_for_non_targeted_viewer", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestContextCardField () {
      return this.requestContextCardField(true);
    }
    public APIRequestGetLeadGenForms requestContextCardField (boolean value) {
      this.requestField("context_card", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetLeadGenForms requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetLeadGenForms requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatorIdField () {
      return this.requestCreatorIdField(true);
    }
    public APIRequestGetLeadGenForms requestCreatorIdField (boolean value) {
      this.requestField("creator_id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCusomizedTcpaContentField () {
      return this.requestCusomizedTcpaContentField(true);
    }
    public APIRequestGetLeadGenForms requestCusomizedTcpaContentField (boolean value) {
      this.requestField("cusomized_tcpa_content", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestExpiredLeadsCountField () {
      return this.requestExpiredLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestExpiredLeadsCountField (boolean value) {
      this.requestField("expired_leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestExtraDetailsField () {
      return this.requestExtraDetailsField(true);
    }
    public APIRequestGetLeadGenForms requestExtraDetailsField (boolean value) {
      this.requestField("extra_details", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestFollowUpActionTextField () {
      return this.requestFollowUpActionTextField(true);
    }
    public APIRequestGetLeadGenForms requestFollowUpActionTextField (boolean value) {
      this.requestField("follow_up_action_text", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestFollowUpActionUrlField () {
      return this.requestFollowUpActionUrlField(true);
    }
    public APIRequestGetLeadGenForms requestFollowUpActionUrlField (boolean value) {
      this.requestField("follow_up_action_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLeadGenForms requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestIsOptimizedForQualityField () {
      return this.requestIsOptimizedForQualityField(true);
    }
    public APIRequestGetLeadGenForms requestIsOptimizedForQualityField (boolean value) {
      this.requestField("is_optimized_for_quality", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLeadgenExportCsvUrlField () {
      return this.requestLeadgenExportCsvUrlField(true);
    }
    public APIRequestGetLeadGenForms requestLeadgenExportCsvUrlField (boolean value) {
      this.requestField("leadgen_export_csv_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLeadsCountField () {
      return this.requestLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestLeadsCountField (boolean value) {
      this.requestField("leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLegalContentField () {
      return this.requestLegalContentField(true);
    }
    public APIRequestGetLeadGenForms requestLegalContentField (boolean value) {
      this.requestField("legal_content", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetLeadGenForms requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestMessengerWelcomeMessageField () {
      return this.requestMessengerWelcomeMessageField(true);
    }
    public APIRequestGetLeadGenForms requestMessengerWelcomeMessageField (boolean value) {
      this.requestField("messenger_welcome_message", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLeadGenForms requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestOrganicLeadsCountField () {
      return this.requestOrganicLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestOrganicLeadsCountField (boolean value) {
      this.requestField("organic_leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetLeadGenForms requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGetLeadGenForms requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetLeadGenForms requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestQualifiersField () {
      return this.requestQualifiersField(true);
    }
    public APIRequestGetLeadGenForms requestQualifiersField (boolean value) {
      this.requestField("qualifiers", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestQuestionPageCustomHeadlineField () {
      return this.requestQuestionPageCustomHeadlineField(true);
    }
    public APIRequestGetLeadGenForms requestQuestionPageCustomHeadlineField (boolean value) {
      this.requestField("question_page_custom_headline", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGetLeadGenForms requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetLeadGenForms requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestTcpaComplianceField () {
      return this.requestTcpaComplianceField(true);
    }
    public APIRequestGetLeadGenForms requestTcpaComplianceField (boolean value) {
      this.requestField("tcpa_compliance", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestThankYouPageField () {
      return this.requestThankYouPageField(true);
    }
    public APIRequestGetLeadGenForms requestThankYouPageField (boolean value) {
      this.requestField("thank_you_page", value);
      return this;
    }
  }

  public static class APIRequestGetMinimumBudgets extends APIRequest<MinimumBudget> {

    APINodeList<MinimumBudget> lastResponse = null;
    @Override
    public APINodeList<MinimumBudget> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bid_amount",
    };

    public static final String[] FIELDS = {
      "currency",
      "min_daily_budget_high_freq",
      "min_daily_budget_imp",
      "min_daily_budget_low_freq",
      "min_daily_budget_video_views",
    };

    @Override
    public APINodeList<MinimumBudget> parseResponse(String response) throws APIException {
      return MinimumBudget.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<MinimumBudget> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<MinimumBudget> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<MinimumBudget>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<MinimumBudget>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<MinimumBudget>>() {
           public APINodeList<MinimumBudget> apply(String result) {
             try {
               return APIRequestGetMinimumBudgets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMinimumBudgets(String nodeId, APIContext context) {
      super(context, nodeId, "/minimum_budgets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMinimumBudgets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMinimumBudgets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMinimumBudgets setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestGetMinimumBudgets setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestGetMinimumBudgets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMinimumBudgets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMinimumBudgets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMinimumBudgets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMinimumBudgets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMinimumBudgets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMinimumBudgets requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetMinimumBudgets requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetHighFreqField () {
      return this.requestMinDailyBudgetHighFreqField(true);
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetHighFreqField (boolean value) {
      this.requestField("min_daily_budget_high_freq", value);
      return this;
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetImpField () {
      return this.requestMinDailyBudgetImpField(true);
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetImpField (boolean value) {
      this.requestField("min_daily_budget_imp", value);
      return this;
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetLowFreqField () {
      return this.requestMinDailyBudgetLowFreqField(true);
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetLowFreqField (boolean value) {
      this.requestField("min_daily_budget_low_freq", value);
      return this;
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetVideoViewsField () {
      return this.requestMinDailyBudgetVideoViewsField(true);
    }
    public APIRequestGetMinimumBudgets requestMinDailyBudgetVideoViewsField (boolean value) {
      this.requestField("min_daily_budget_video_views", value);
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
      "data_origin",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "id",
      "is_restricted_use",
      "last_upload_app",
      "match_rate_approx",
      "matched_entries",
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

  public static class APIRequestGetOffsitePixels extends APIRequest<OffsitePixel> {

    APINodeList<OffsitePixel> lastResponse = null;
    @Override
    public APINodeList<OffsitePixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creator",
      "id",
      "js_pixel",
      "last_firing_time",
      "name",
      "tag",
    };

    @Override
    public APINodeList<OffsitePixel> parseResponse(String response) throws APIException {
      return OffsitePixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OffsitePixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OffsitePixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OffsitePixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OffsitePixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OffsitePixel>>() {
           public APINodeList<OffsitePixel> apply(String result) {
             try {
               return APIRequestGetOffsitePixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOffsitePixels(String nodeId, APIContext context) {
      super(context, nodeId, "/offsitepixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOffsitePixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOffsitePixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOffsitePixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOffsitePixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOffsitePixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOffsitePixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOffsitePixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOffsitePixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOffsitePixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetOffsitePixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetOffsitePixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOffsitePixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOffsitePixels requestJsPixelField () {
      return this.requestJsPixelField(true);
    }
    public APIRequestGetOffsitePixels requestJsPixelField (boolean value) {
      this.requestField("js_pixel", value);
      return this;
    }
    public APIRequestGetOffsitePixels requestLastFiringTimeField () {
      return this.requestLastFiringTimeField(true);
    }
    public APIRequestGetOffsitePixels requestLastFiringTimeField (boolean value) {
      this.requestField("last_firing_time", value);
      return this;
    }
    public APIRequestGetOffsitePixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOffsitePixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOffsitePixels requestTagField () {
      return this.requestTagField(true);
    }
    public APIRequestGetOffsitePixels requestTagField (boolean value) {
      this.requestField("tag", value);
      return this;
    }
  }

  public static class APIRequestGetPartnerCategories extends APIRequest<PartnerCategory> {

    APINodeList<PartnerCategory> lastResponse = null;
    @Override
    public APINodeList<PartnerCategory> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hide_pc",
      "is_exclusion",
      "private_or_public",
      "targeting_type",
    };

    public static final String[] FIELDS = {
      "approximate_count",
      "country",
      "description",
      "details",
      "id",
      "is_private",
      "name",
      "parent_category",
      "source",
      "status",
      "targeting_type",
    };

    @Override
    public APINodeList<PartnerCategory> parseResponse(String response) throws APIException {
      return PartnerCategory.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PartnerCategory> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PartnerCategory> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PartnerCategory>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PartnerCategory>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PartnerCategory>>() {
           public APINodeList<PartnerCategory> apply(String result) {
             try {
               return APIRequestGetPartnerCategories.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPartnerCategories(String nodeId, APIContext context) {
      super(context, nodeId, "/partnercategories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartnerCategories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartnerCategories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerCategories setHidePc (Boolean hidePc) {
      this.setParam("hide_pc", hidePc);
      return this;
    }
    public APIRequestGetPartnerCategories setHidePc (String hidePc) {
      this.setParam("hide_pc", hidePc);
      return this;
    }

    public APIRequestGetPartnerCategories setIsExclusion (Boolean isExclusion) {
      this.setParam("is_exclusion", isExclusion);
      return this;
    }
    public APIRequestGetPartnerCategories setIsExclusion (String isExclusion) {
      this.setParam("is_exclusion", isExclusion);
      return this;
    }

    public APIRequestGetPartnerCategories setPrivateOrPublic (PartnerCategory.EnumPrivateOrPublic privateOrPublic) {
      this.setParam("private_or_public", privateOrPublic);
      return this;
    }
    public APIRequestGetPartnerCategories setPrivateOrPublic (String privateOrPublic) {
      this.setParam("private_or_public", privateOrPublic);
      return this;
    }

    public APIRequestGetPartnerCategories setTargetingType (String targetingType) {
      this.setParam("targeting_type", targetingType);
      return this;
    }

    public APIRequestGetPartnerCategories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerCategories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerCategories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartnerCategories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartnerCategories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartnerCategories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerCategories requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGetPartnerCategories requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetPartnerCategories requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPartnerCategories requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestDetailsField () {
      return this.requestDetailsField(true);
    }
    public APIRequestGetPartnerCategories requestDetailsField (boolean value) {
      this.requestField("details", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerCategories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetPartnerCategories requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartnerCategories requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestParentCategoryField () {
      return this.requestParentCategoryField(true);
    }
    public APIRequestGetPartnerCategories requestParentCategoryField (boolean value) {
      this.requestField("parent_category", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPartnerCategories requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPartnerCategories requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestTargetingTypeField () {
      return this.requestTargetingTypeField(true);
    }
    public APIRequestGetPartnerCategories requestTargetingTypeField (boolean value) {
      this.requestField("targeting_type", value);
      return this;
    }
  }

  public static class APIRequestGetPartners extends APIRequest<AdsDataPartner> {

    APINodeList<AdsDataPartner> lastResponse = null;
    @Override
    public APINodeList<AdsDataPartner> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "rev_share_policies",
    };

    @Override
    public APINodeList<AdsDataPartner> parseResponse(String response) throws APIException {
      return AdsDataPartner.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsDataPartner> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsDataPartner> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsDataPartner>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsDataPartner>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsDataPartner>>() {
           public APINodeList<AdsDataPartner> apply(String result) {
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

    public APIRequestGetPartners requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartners requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartners requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartners requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartners requestRevSharePoliciesField () {
      return this.requestRevSharePoliciesField(true);
    }
    public APIRequestGetPartners requestRevSharePoliciesField (boolean value) {
      this.requestField("rev_share_policies", value);
      return this;
    }
  }

  public static class APIRequestDeletePendingUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "request_id",
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
               return APIRequestDeletePendingUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeletePendingUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeletePendingUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeletePendingUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeletePendingUsers setRequestId (Long requestId) {
      this.setParam("request_id", requestId);
      return this;
    }
    public APIRequestDeletePendingUsers setRequestId (String requestId) {
      this.setParam("request_id", requestId);
      return this;
    }

    public APIRequestDeletePendingUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeletePendingUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePendingUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeletePendingUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePendingUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeletePendingUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePendingUser extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "request_id",
      "role",
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
               return APIRequestCreatePendingUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePendingUser(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePendingUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePendingUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePendingUser setRequestId (Long requestId) {
      this.setParam("request_id", requestId);
      return this;
    }
    public APIRequestCreatePendingUser setRequestId (String requestId) {
      this.setParam("request_id", requestId);
      return this;
    }

    public APIRequestCreatePendingUser setRole (AdAccount.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreatePendingUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreatePendingUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePendingUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePendingUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePendingUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePendingUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePendingUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateProductAudience extends APIRequest<CustomAudience> {

    CustomAudience lastResponse = null;
    @Override
    public CustomAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "associated_audience_id",
      "creation_params",
      "description",
      "event_sources",
      "exclusions",
      "inclusions",
      "name",
      "opt_out_link",
      "parent_audience_id",
      "product_set_id",
      "subtype",
      "tags",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomAudience parseResponse(String response) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomAudience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomAudience execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CustomAudience> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomAudience> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CustomAudience>() {
           public CustomAudience apply(String result) {
             try {
               return APIRequestCreateProductAudience.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductAudience(String nodeId, APIContext context) {
      super(context, nodeId, "/product_audiences", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductAudience setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductAudience setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductAudience setAssociatedAudienceId (Long associatedAudienceId) {
      this.setParam("associated_audience_id", associatedAudienceId);
      return this;
    }
    public APIRequestCreateProductAudience setAssociatedAudienceId (String associatedAudienceId) {
      this.setParam("associated_audience_id", associatedAudienceId);
      return this;
    }

    public APIRequestCreateProductAudience setCreationParams (Map<String, String> creationParams) {
      this.setParam("creation_params", creationParams);
      return this;
    }
    public APIRequestCreateProductAudience setCreationParams (String creationParams) {
      this.setParam("creation_params", creationParams);
      return this;
    }

    public APIRequestCreateProductAudience setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateProductAudience setEventSources (List<Map<String, String>> eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }
    public APIRequestCreateProductAudience setEventSources (String eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }

    public APIRequestCreateProductAudience setExclusions (List<Object> exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }
    public APIRequestCreateProductAudience setExclusions (String exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestCreateProductAudience setInclusions (List<Object> inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }
    public APIRequestCreateProductAudience setInclusions (String inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestCreateProductAudience setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateProductAudience setOptOutLink (String optOutLink) {
      this.setParam("opt_out_link", optOutLink);
      return this;
    }

    public APIRequestCreateProductAudience setParentAudienceId (Long parentAudienceId) {
      this.setParam("parent_audience_id", parentAudienceId);
      return this;
    }
    public APIRequestCreateProductAudience setParentAudienceId (String parentAudienceId) {
      this.setParam("parent_audience_id", parentAudienceId);
      return this;
    }

    public APIRequestCreateProductAudience setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
      return this;
    }

    public APIRequestCreateProductAudience setSubtype (AdAccount.EnumSubtype subtype) {
      this.setParam("subtype", subtype);
      return this;
    }
    public APIRequestCreateProductAudience setSubtype (String subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateProductAudience setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateProductAudience setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateProductAudience requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductAudience requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAudience requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductAudience requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAudience requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductAudience requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPublisherBlockLists extends APIRequest<APINode> {

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
               return APIRequestGetPublisherBlockLists.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPublisherBlockLists(String nodeId, APIContext context) {
      super(context, nodeId, "/publisher_block_lists", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPublisherBlockLists setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPublisherBlockLists setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPublisherBlockLists requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPublisherBlockLists requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPublisherBlockLists requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPublisherBlockLists requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPublisherBlockLists requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPublisherBlockLists requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePublisherBlockList extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
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
               return APIRequestCreatePublisherBlockList.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePublisherBlockList(String nodeId, APIContext context) {
      super(context, nodeId, "/publisher_block_lists", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePublisherBlockList setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePublisherBlockList setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePublisherBlockList setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePublisherBlockList requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePublisherBlockList requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePublisherBlockList requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePublisherBlockList requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePublisherBlockList requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePublisherBlockList requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetReachEstimate extends APIRequest<ReachEstimate> {

    APINodeList<ReachEstimate> lastResponse = null;
    @Override
    public APINodeList<ReachEstimate> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "object_store_url",
      "targeting_spec",
    };

    public static final String[] FIELDS = {
      "estimate_ready",
      "unsupported",
      "users",
    };

    @Override
    public APINodeList<ReachEstimate> parseResponse(String response) throws APIException {
      return ReachEstimate.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ReachEstimate> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ReachEstimate> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ReachEstimate>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ReachEstimate>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ReachEstimate>>() {
           public APINodeList<ReachEstimate> apply(String result) {
             try {
               return APIRequestGetReachEstimate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReachEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/reachestimate", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReachEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReachEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReachEstimate setObjectStoreUrl (String objectStoreUrl) {
      this.setParam("object_store_url", objectStoreUrl);
      return this;
    }

    public APIRequestGetReachEstimate setTargetingSpec (Targeting targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }
    public APIRequestGetReachEstimate setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }

    public APIRequestGetReachEstimate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReachEstimate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReachEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReachEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReachEstimate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReachEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReachEstimate requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGetReachEstimate requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
      return this;
    }
    public APIRequestGetReachEstimate requestUnsupportedField () {
      return this.requestUnsupportedField(true);
    }
    public APIRequestGetReachEstimate requestUnsupportedField (boolean value) {
      this.requestField("unsupported", value);
      return this;
    }
    public APIRequestGetReachEstimate requestUsersField () {
      return this.requestUsersField(true);
    }
    public APIRequestGetReachEstimate requestUsersField (boolean value) {
      this.requestField("users", value);
      return this;
    }
  }

  public static class APIRequestGetReachFrequencyPredictions extends APIRequest<ReachFrequencyPrediction> {

    APINodeList<ReachFrequencyPrediction> lastResponse = null;
    @Override
    public APINodeList<ReachFrequencyPrediction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "campaign_group_id",
      "campaign_id",
      "campaign_time_start",
      "campaign_time_stop",
      "curve_budget_reach",
      "daily_impression_curve",
      "destination_id",
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
      "frequency_cap",
      "frequency_distribution",
      "frequency_distribution_map",
      "frequency_distribution_map_agg",
      "grp_dmas_audience_size",
      "holdout_percentage",
      "id",
      "instagram_destination_id",
      "interval_frequency_cap",
      "interval_frequency_cap_reset_period",
      "name",
      "pause_periods",
      "placement_breakdown",
      "prediction_mode",
      "prediction_progress",
      "reservation_status",
      "status",
      "story_event_type",
      "target_audience_size",
      "target_spec",
      "time_created",
      "time_updated",
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
               return APIRequestGetReachFrequencyPredictions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReachFrequencyPredictions(String nodeId, APIContext context) {
      super(context, nodeId, "/reachfrequencypredictions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReachFrequencyPredictions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReachFrequencyPredictions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReachFrequencyPredictions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReachFrequencyPredictions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReachFrequencyPredictions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReachFrequencyPredictions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReachFrequencyPredictions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReachFrequencyPredictions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReachFrequencyPredictions requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestDailyImpressionCurveField () {
      return this.requestDailyImpressionCurveField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestDailyImpressionCurveField (boolean value) {
      this.requestField("daily_impression_curve", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionField () {
      return this.requestFrequencyDistributionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionField (boolean value) {
      this.requestField("frequency_distribution", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionMapField () {
      return this.requestFrequencyDistributionMapField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionMapField (boolean value) {
      this.requestField("frequency_distribution_map", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionMapAggField () {
      return this.requestFrequencyDistributionMapAggField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyDistributionMapAggField (boolean value) {
      this.requestField("frequency_distribution_map_agg", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestGrpDmasAudienceSizeField () {
      return this.requestGrpDmasAudienceSizeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestGrpDmasAudienceSizeField (boolean value) {
      this.requestField("grp_dmas_audience_size", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestInstagramDestinationIdField () {
      return this.requestInstagramDestinationIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestInstagramDestinationIdField (boolean value) {
      this.requestField("instagram_destination_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestIntervalFrequencyCapField () {
      return this.requestIntervalFrequencyCapField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestIntervalFrequencyCapField (boolean value) {
      this.requestField("interval_frequency_cap", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestIntervalFrequencyCapResetPeriodField () {
      return this.requestIntervalFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestIntervalFrequencyCapResetPeriodField (boolean value) {
      this.requestField("interval_frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestPausePeriodsField () {
      return this.requestPausePeriodsField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestPausePeriodsField (boolean value) {
      this.requestField("pause_periods", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestPlacementBreakdownField () {
      return this.requestPlacementBreakdownField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestPlacementBreakdownField (boolean value) {
      this.requestField("placement_breakdown", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static class APIRequestCreateReachFrequencyPrediction extends APIRequest<ReachFrequencyPrediction> {

    ReachFrequencyPrediction lastResponse = null;
    @Override
    public ReachFrequencyPrediction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "budget",
      "campaign_group_id",
      "day_parting_schedule",
      "destination_id",
      "destination_ids",
      "end_time",
      "frequency_cap",
      "instream_packages",
      "interval_frequency_cap_reset_period",
      "num_curve_points",
      "objective",
      "prediction_mode",
      "reach",
      "rf_prediction_id_to_share",
      "start_time",
      "stop_time",
      "story_event_type",
      "target_spec",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ReachFrequencyPrediction parseResponse(String response) throws APIException {
      return ReachFrequencyPrediction.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyPrediction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyPrediction execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyPrediction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyPrediction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ReachFrequencyPrediction>() {
           public ReachFrequencyPrediction apply(String result) {
             try {
               return APIRequestCreateReachFrequencyPrediction.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateReachFrequencyPrediction(String nodeId, APIContext context) {
      super(context, nodeId, "/reachfrequencypredictions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateReachFrequencyPrediction setBudget (Long budget) {
      this.setParam("budget", budget);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setBudget (String budget) {
      this.setParam("budget", budget);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setCampaignGroupId (String campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setDayPartingSchedule (List<Object> dayPartingSchedule) {
      this.setParam("day_parting_schedule", dayPartingSchedule);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setDayPartingSchedule (String dayPartingSchedule) {
      this.setParam("day_parting_schedule", dayPartingSchedule);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setDestinationId (Long destinationId) {
      this.setParam("destination_id", destinationId);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setDestinationId (String destinationId) {
      this.setParam("destination_id", destinationId);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setDestinationIds (List<String> destinationIds) {
      this.setParam("destination_ids", destinationIds);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setDestinationIds (String destinationIds) {
      this.setParam("destination_ids", destinationIds);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setEndTime (Long endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setFrequencyCap (Long frequencyCap) {
      this.setParam("frequency_cap", frequencyCap);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setFrequencyCap (String frequencyCap) {
      this.setParam("frequency_cap", frequencyCap);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setInstreamPackages (List<ReachFrequencyPrediction.EnumInstreamPackages> instreamPackages) {
      this.setParam("instream_packages", instreamPackages);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setInstreamPackages (String instreamPackages) {
      this.setParam("instream_packages", instreamPackages);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setIntervalFrequencyCapResetPeriod (Long intervalFrequencyCapResetPeriod) {
      this.setParam("interval_frequency_cap_reset_period", intervalFrequencyCapResetPeriod);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setIntervalFrequencyCapResetPeriod (String intervalFrequencyCapResetPeriod) {
      this.setParam("interval_frequency_cap_reset_period", intervalFrequencyCapResetPeriod);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setNumCurvePoints (Long numCurvePoints) {
      this.setParam("num_curve_points", numCurvePoints);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setNumCurvePoints (String numCurvePoints) {
      this.setParam("num_curve_points", numCurvePoints);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setObjective (String objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setPredictionMode (Long predictionMode) {
      this.setParam("prediction_mode", predictionMode);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setPredictionMode (String predictionMode) {
      this.setParam("prediction_mode", predictionMode);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setReach (Long reach) {
      this.setParam("reach", reach);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setReach (String reach) {
      this.setParam("reach", reach);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setRfPredictionIdToShare (String rfPredictionIdToShare) {
      this.setParam("rf_prediction_id_to_share", rfPredictionIdToShare);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setStartTime (Long startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setStopTime (Long stopTime) {
      this.setParam("stop_time", stopTime);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setStopTime (String stopTime) {
      this.setParam("stop_time", stopTime);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setStoryEventType (Long storyEventType) {
      this.setParam("story_event_type", storyEventType);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setStoryEventType (String storyEventType) {
      this.setParam("story_event_type", storyEventType);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setTargetSpec (Targeting targetSpec) {
      this.setParam("target_spec", targetSpec);
      return this;
    }
    public APIRequestCreateReachFrequencyPrediction setTargetSpec (String targetSpec) {
      this.setParam("target_spec", targetSpec);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateReachFrequencyPrediction requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateReachFrequencyPrediction requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRoas extends APIRequest<AdAccountRoas> {

    APINodeList<AdAccountRoas> lastResponse = null;
    @Override
    public APINodeList<AdAccountRoas> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "fields",
      "filtering",
      "time_increment",
      "time_range",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdAccountRoas> parseResponse(String response) throws APIException {
      return AdAccountRoas.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountRoas> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountRoas> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountRoas>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountRoas>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountRoas>>() {
           public APINodeList<AdAccountRoas> apply(String result) {
             try {
               return APIRequestGetRoas.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetRoas(String nodeId, APIContext context) {
      super(context, nodeId, "/roas", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRoas setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRoas setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRoas setFields (List<AdAccountRoas.EnumFields> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetRoas setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetRoas setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetRoas setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetRoas setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetRoas setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetRoas setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetRoas requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoas requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoas requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRoas requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoas requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRoas requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSponsoredMessageAd extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bid_amount",
      "daily_budget",
      "message_creative_id",
      "targeting",
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
               return APIRequestCreateSponsoredMessageAd.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSponsoredMessageAd(String nodeId, APIContext context) {
      super(context, nodeId, "/sponsored_message_ads", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSponsoredMessageAd setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSponsoredMessageAd setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSponsoredMessageAd setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }
    public APIRequestCreateSponsoredMessageAd setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateSponsoredMessageAd setDailyBudget (Long dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }
    public APIRequestCreateSponsoredMessageAd setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestCreateSponsoredMessageAd setMessageCreativeId (String messageCreativeId) {
      this.setParam("message_creative_id", messageCreativeId);
      return this;
    }

    public APIRequestCreateSponsoredMessageAd setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateSponsoredMessageAd setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreateSponsoredMessageAd requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSponsoredMessageAd requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSponsoredMessageAd requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSponsoredMessageAd requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSponsoredMessageAd requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSponsoredMessageAd requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTargetingBrowse extends APIRequest<AdAccountTargetingUnified> {

    APINodeList<AdAccountTargetingUnified> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingUnified> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_nodes",
      "limit_type",
    };

    public static final String[] FIELDS = {
      "audience_size",
      "description",
      "id",
      "is_recommendation",
      "name",
      "path",
      "recommendation_model",
      "search_interest_id",
      "type",
      "valid",
    };

    @Override
    public APINodeList<AdAccountTargetingUnified> parseResponse(String response) throws APIException {
      return AdAccountTargetingUnified.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountTargetingUnified>>() {
           public APINodeList<AdAccountTargetingUnified> apply(String result) {
             try {
               return APIRequestGetTargetingBrowse.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTargetingBrowse(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingbrowse", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingBrowse setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingBrowse setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingBrowse setIncludeNodes (Boolean includeNodes) {
      this.setParam("include_nodes", includeNodes);
      return this;
    }
    public APIRequestGetTargetingBrowse setIncludeNodes (String includeNodes) {
      this.setParam("include_nodes", includeNodes);
      return this;
    }

    public APIRequestGetTargetingBrowse setLimitType (AdAccountTargetingUnified.EnumLimitType limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }
    public APIRequestGetTargetingBrowse setLimitType (String limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }

    public APIRequestGetTargetingBrowse requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingBrowse requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingBrowse requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingBrowse requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingBrowse requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingBrowse requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingBrowse requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingBrowse requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingBrowse requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingBrowse requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestIsRecommendationField () {
      return this.requestIsRecommendationField(true);
    }
    public APIRequestGetTargetingBrowse requestIsRecommendationField (boolean value) {
      this.requestField("is_recommendation", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingBrowse requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingBrowse requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestRecommendationModelField () {
      return this.requestRecommendationModelField(true);
    }
    public APIRequestGetTargetingBrowse requestRecommendationModelField (boolean value) {
      this.requestField("recommendation_model", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestSearchInterestIdField () {
      return this.requestSearchInterestIdField(true);
    }
    public APIRequestGetTargetingBrowse requestSearchInterestIdField (boolean value) {
      this.requestField("search_interest_id", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingBrowse requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestValidField () {
      return this.requestValidField(true);
    }
    public APIRequestGetTargetingBrowse requestValidField (boolean value) {
      this.requestField("valid", value);
      return this;
    }
  }

  public static class APIRequestGetTargetingSearch extends APIRequest<AdAccountTargetingUnified> {

    APINodeList<AdAccountTargetingUnified> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingUnified> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "limit_type",
      "q",
    };

    public static final String[] FIELDS = {
      "audience_size",
      "description",
      "id",
      "is_recommendation",
      "name",
      "path",
      "recommendation_model",
      "search_interest_id",
      "type",
      "valid",
    };

    @Override
    public APINodeList<AdAccountTargetingUnified> parseResponse(String response) throws APIException {
      return AdAccountTargetingUnified.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountTargetingUnified>>() {
           public APINodeList<AdAccountTargetingUnified> apply(String result) {
             try {
               return APIRequestGetTargetingSearch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTargetingSearch(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsearch", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSearch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingSearch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSearch setLimitType (AdAccountTargetingUnified.EnumLimitType limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }
    public APIRequestGetTargetingSearch setLimitType (String limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }

    public APIRequestGetTargetingSearch setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetTargetingSearch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSearch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSearch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSearch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSearch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingSearch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSearch requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingSearch requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingSearch requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSearch requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestIsRecommendationField () {
      return this.requestIsRecommendationField(true);
    }
    public APIRequestGetTargetingSearch requestIsRecommendationField (boolean value) {
      this.requestField("is_recommendation", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingSearch requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingSearch requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestRecommendationModelField () {
      return this.requestRecommendationModelField(true);
    }
    public APIRequestGetTargetingSearch requestRecommendationModelField (boolean value) {
      this.requestField("recommendation_model", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestSearchInterestIdField () {
      return this.requestSearchInterestIdField(true);
    }
    public APIRequestGetTargetingSearch requestSearchInterestIdField (boolean value) {
      this.requestField("search_interest_id", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingSearch requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestValidField () {
      return this.requestValidField(true);
    }
    public APIRequestGetTargetingSearch requestValidField (boolean value) {
      this.requestField("valid", value);
      return this;
    }
  }

  public static class APIRequestGetTargetingSentenceLines extends APIRequest<TargetingSentenceLine> {

    APINodeList<TargetingSentenceLine> lastResponse = null;
    @Override
    public APINodeList<TargetingSentenceLine> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "discard_ages",
      "discard_placements",
      "targeting_spec",
    };

    public static final String[] FIELDS = {
      "id",
      "params",
      "targetingsentencelines",
    };

    @Override
    public APINodeList<TargetingSentenceLine> parseResponse(String response) throws APIException {
      return TargetingSentenceLine.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<TargetingSentenceLine>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<TargetingSentenceLine>>() {
           public APINodeList<TargetingSentenceLine> apply(String result) {
             try {
               return APIRequestGetTargetingSentenceLines.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSentenceLines setDiscardAges (Boolean discardAges) {
      this.setParam("discard_ages", discardAges);
      return this;
    }
    public APIRequestGetTargetingSentenceLines setDiscardAges (String discardAges) {
      this.setParam("discard_ages", discardAges);
      return this;
    }

    public APIRequestGetTargetingSentenceLines setDiscardPlacements (Boolean discardPlacements) {
      this.setParam("discard_placements", discardPlacements);
      return this;
    }
    public APIRequestGetTargetingSentenceLines setDiscardPlacements (String discardPlacements) {
      this.setParam("discard_placements", discardPlacements);
      return this;
    }

    public APIRequestGetTargetingSentenceLines setTargetingSpec (Targeting targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }
    public APIRequestGetTargetingSentenceLines setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSentenceLines requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSentenceLines requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestParamsField () {
      return this.requestParamsField(true);
    }
    public APIRequestGetTargetingSentenceLines requestParamsField (boolean value) {
      this.requestField("params", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField () {
      return this.requestTargetingsentencelinesField(true);
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField (boolean value) {
      this.requestField("targetingsentencelines", value);
      return this;
    }
  }

  public static class APIRequestGetTargetingSuggestions extends APIRequest<AdAccountTargetingUnified> {

    APINodeList<AdAccountTargetingUnified> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingUnified> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "limit_type",
      "targeting_list",
    };

    public static final String[] FIELDS = {
      "audience_size",
      "description",
      "id",
      "is_recommendation",
      "name",
      "path",
      "recommendation_model",
      "search_interest_id",
      "type",
      "valid",
    };

    @Override
    public APINodeList<AdAccountTargetingUnified> parseResponse(String response) throws APIException {
      return AdAccountTargetingUnified.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountTargetingUnified>>() {
           public APINodeList<AdAccountTargetingUnified> apply(String result) {
             try {
               return APIRequestGetTargetingSuggestions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTargetingSuggestions(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsuggestions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSuggestions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingSuggestions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSuggestions setLimitType (AdAccountTargetingUnified.EnumLimitType limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }
    public APIRequestGetTargetingSuggestions setLimitType (String limitType) {
      this.setParam("limit_type", limitType);
      return this;
    }

    public APIRequestGetTargetingSuggestions setTargetingList (List<Object> targetingList) {
      this.setParam("targeting_list", targetingList);
      return this;
    }
    public APIRequestGetTargetingSuggestions setTargetingList (String targetingList) {
      this.setParam("targeting_list", targetingList);
      return this;
    }

    public APIRequestGetTargetingSuggestions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSuggestions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSuggestions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSuggestions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSuggestions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingSuggestions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSuggestions requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingSuggestions requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingSuggestions requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSuggestions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestIsRecommendationField () {
      return this.requestIsRecommendationField(true);
    }
    public APIRequestGetTargetingSuggestions requestIsRecommendationField (boolean value) {
      this.requestField("is_recommendation", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingSuggestions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingSuggestions requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestRecommendationModelField () {
      return this.requestRecommendationModelField(true);
    }
    public APIRequestGetTargetingSuggestions requestRecommendationModelField (boolean value) {
      this.requestField("recommendation_model", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestSearchInterestIdField () {
      return this.requestSearchInterestIdField(true);
    }
    public APIRequestGetTargetingSuggestions requestSearchInterestIdField (boolean value) {
      this.requestField("search_interest_id", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingSuggestions requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestValidField () {
      return this.requestValidField(true);
    }
    public APIRequestGetTargetingSuggestions requestValidField (boolean value) {
      this.requestField("valid", value);
      return this;
    }
  }

  public static class APIRequestGetTargetingValidation extends APIRequest<AdAccountTargetingUnified> {

    APINodeList<AdAccountTargetingUnified> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingUnified> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id_list",
      "is_exclusion",
      "name_list",
      "targeting_list",
    };

    public static final String[] FIELDS = {
      "audience_size",
      "description",
      "id",
      "is_recommendation",
      "name",
      "path",
      "recommendation_model",
      "search_interest_id",
      "type",
      "valid",
    };

    @Override
    public APINodeList<AdAccountTargetingUnified> parseResponse(String response) throws APIException {
      return AdAccountTargetingUnified.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingUnified> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountTargetingUnified>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountTargetingUnified>>() {
           public APINodeList<AdAccountTargetingUnified> apply(String result) {
             try {
               return APIRequestGetTargetingValidation.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTargetingValidation(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingvalidation", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingValidation setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTargetingValidation setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingValidation setIdList (List<Long> idList) {
      this.setParam("id_list", idList);
      return this;
    }
    public APIRequestGetTargetingValidation setIdList (String idList) {
      this.setParam("id_list", idList);
      return this;
    }

    public APIRequestGetTargetingValidation setIsExclusion (Boolean isExclusion) {
      this.setParam("is_exclusion", isExclusion);
      return this;
    }
    public APIRequestGetTargetingValidation setIsExclusion (String isExclusion) {
      this.setParam("is_exclusion", isExclusion);
      return this;
    }

    public APIRequestGetTargetingValidation setNameList (List<String> nameList) {
      this.setParam("name_list", nameList);
      return this;
    }
    public APIRequestGetTargetingValidation setNameList (String nameList) {
      this.setParam("name_list", nameList);
      return this;
    }

    public APIRequestGetTargetingValidation setTargetingList (List<Object> targetingList) {
      this.setParam("targeting_list", targetingList);
      return this;
    }
    public APIRequestGetTargetingValidation setTargetingList (String targetingList) {
      this.setParam("targeting_list", targetingList);
      return this;
    }

    public APIRequestGetTargetingValidation requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingValidation requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingValidation requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingValidation requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingValidation requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTargetingValidation requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingValidation requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingValidation requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingValidation requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingValidation requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestIsRecommendationField () {
      return this.requestIsRecommendationField(true);
    }
    public APIRequestGetTargetingValidation requestIsRecommendationField (boolean value) {
      this.requestField("is_recommendation", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingValidation requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingValidation requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestRecommendationModelField () {
      return this.requestRecommendationModelField(true);
    }
    public APIRequestGetTargetingValidation requestRecommendationModelField (boolean value) {
      this.requestField("recommendation_model", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestSearchInterestIdField () {
      return this.requestSearchInterestIdField(true);
    }
    public APIRequestGetTargetingValidation requestSearchInterestIdField (boolean value) {
      this.requestField("search_interest_id", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingValidation requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestValidField () {
      return this.requestValidField(true);
    }
    public APIRequestGetTargetingValidation requestValidField (boolean value) {
      this.requestField("valid", value);
      return this;
    }
  }

  public static class APIRequestDeleteTracking extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking_specs",
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
               return APIRequestDeleteTracking.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteTracking(String nodeId, APIContext context) {
      super(context, nodeId, "/tracking", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteTracking setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteTracking setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteTracking setTrackingSpecs (Object trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }
    public APIRequestDeleteTracking setTrackingSpecs (String trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestDeleteTracking requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteTracking requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteTracking requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteTracking requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteTracking requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteTracking requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateTracking extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tracking_specs",
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
               return APIRequestCreateTracking.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateTracking(String nodeId, APIContext context) {
      super(context, nodeId, "/tracking", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTracking setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTracking setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTracking setTrackingSpecs (Object trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }
    public APIRequestCreateTracking setTrackingSpecs (String trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestCreateTracking requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTracking requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTracking requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTracking requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTracking requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTracking requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteUserMatch extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bidirectional",
      "namespace",
      "payload",
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
               return APIRequestDeleteUserMatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserMatch(String nodeId, APIContext context) {
      super(context, nodeId, "/user_match", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserMatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserMatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserMatch setBidirectional (Boolean bidirectional) {
      this.setParam("bidirectional", bidirectional);
      return this;
    }
    public APIRequestDeleteUserMatch setBidirectional (String bidirectional) {
      this.setParam("bidirectional", bidirectional);
      return this;
    }

    public APIRequestDeleteUserMatch setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestDeleteUserMatch setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestDeleteUserMatch setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestDeleteUserMatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserMatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserMatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserMatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserMatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserMatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUserMatch extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action",
      "bidirectional",
      "namespace",
      "payload",
      "retention",
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
               return APIRequestCreateUserMatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserMatch(String nodeId, APIContext context) {
      super(context, nodeId, "/user_match", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserMatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserMatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserMatch setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestCreateUserMatch setBidirectional (Boolean bidirectional) {
      this.setParam("bidirectional", bidirectional);
      return this;
    }
    public APIRequestCreateUserMatch setBidirectional (String bidirectional) {
      this.setParam("bidirectional", bidirectional);
      return this;
    }

    public APIRequestCreateUserMatch setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestCreateUserMatch setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestCreateUserMatch setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateUserMatch setRetention (String retention) {
      this.setParam("retention", retention);
      return this;
    }

    public APIRequestCreateUserMatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserMatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserMatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserMatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserMatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserMatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUsers extends APIRequest<AdAccountUser> {

    APINodeList<AdAccountUser> lastResponse = null;
    @Override
    public APINodeList<AdAccountUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "permissions",
      "role",
      "roles",
    };

    @Override
    public APINodeList<AdAccountUser> parseResponse(String response) throws APIException {
      return AdAccountUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountUser>>() {
           public APINodeList<AdAccountUser> apply(String result) {
             try {
               return APIRequestGetUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetUsers requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGetUsers requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGetUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUsers requestRolesField () {
      return this.requestRolesField(true);
    }
    public APIRequestGetUsers requestRolesField (boolean value) {
      this.requestField("roles", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_status",
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
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "has_page_authorized_adaccount",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
      "is_direct_deals_enabled",
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGet requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGet requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGet requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGet requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGet requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGet requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGet requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGet requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGet requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGet requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGet requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGet requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGet requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGet requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGet requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGet requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGet requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGet requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGet requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGet requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGet requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGet requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGet requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGet requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGet requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGet requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGet requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGet requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGet requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGet requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGet requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGet requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGet requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGet requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGet requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGet requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGet requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGet requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGet requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGet requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGet requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGet requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGet requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGet requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGet requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGet requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGet requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGet requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGet requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
      return this;
    }
    public APIRequestGet requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGet requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGet requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGet requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGet requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGet requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGet requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGet requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGet requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGet requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGet requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGet requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGet requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGet requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGet requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGet requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGet requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGet requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGet requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGet requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGet requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGet requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGet requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGet requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGet requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGet requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGet requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGet requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGet requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGet requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGet requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGet requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGet requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGet requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGet requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGet requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGet requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGet requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGet requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGet requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGet requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGet requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "agency_client_declaration",
      "attribution_spec",
      "business_info",
      "end_advertiser",
      "is_notifications_enabled",
      "media_agency",
      "name",
      "partner",
      "spend_cap",
      "spend_cap_action",
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


    public APIRequestUpdate setAgencyClientDeclaration (Map<String, String> agencyClientDeclaration) {
      this.setParam("agency_client_declaration", agencyClientDeclaration);
      return this;
    }
    public APIRequestUpdate setAgencyClientDeclaration (String agencyClientDeclaration) {
      this.setParam("agency_client_declaration", agencyClientDeclaration);
      return this;
    }

    public APIRequestUpdate setAttributionSpec (List<Object> attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }
    public APIRequestUpdate setAttributionSpec (String attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }

    public APIRequestUpdate setBusinessInfo (Map<String, String> businessInfo) {
      this.setParam("business_info", businessInfo);
      return this;
    }
    public APIRequestUpdate setBusinessInfo (String businessInfo) {
      this.setParam("business_info", businessInfo);
      return this;
    }

    public APIRequestUpdate setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }

    public APIRequestUpdate setIsNotificationsEnabled (Boolean isNotificationsEnabled) {
      this.setParam("is_notifications_enabled", isNotificationsEnabled);
      return this;
    }
    public APIRequestUpdate setIsNotificationsEnabled (String isNotificationsEnabled) {
      this.setParam("is_notifications_enabled", isNotificationsEnabled);
      return this;
    }

    public APIRequestUpdate setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestUpdate setSpendCap (Double spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }
    public APIRequestUpdate setSpendCap (String spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }

    public APIRequestUpdate setSpendCapAction (String spendCapAction) {
      this.setParam("spend_cap_action", spendCapAction);
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

  public static enum EnumPermittedRoles {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("GENERAL_USER")
      VALUE_GENERAL_USER("GENERAL_USER"),
      @SerializedName("REPORTS_ONLY")
      VALUE_REPORTS_ONLY("REPORTS_ONLY"),
      @SerializedName("INSTAGRAM_ADVERTISER")
      VALUE_INSTAGRAM_ADVERTISER("INSTAGRAM_ADVERTISER"),
      @SerializedName("INSTAGRAM_MANAGER")
      VALUE_INSTAGRAM_MANAGER("INSTAGRAM_MANAGER"),
      @SerializedName("CREATIVE")
      VALUE_CREATIVE("CREATIVE"),
      @SerializedName("FB_EMPLOYEE_DSO_ADVERTISER")
      VALUE_FB_EMPLOYEE_DSO_ADVERTISER("FB_EMPLOYEE_DSO_ADVERTISER"),
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
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("GENERAL_USER")
      VALUE_GENERAL_USER("GENERAL_USER"),
      @SerializedName("REPORTS_ONLY")
      VALUE_REPORTS_ONLY("REPORTS_ONLY"),
      @SerializedName("INSTAGRAM_ADVERTISER")
      VALUE_INSTAGRAM_ADVERTISER("INSTAGRAM_ADVERTISER"),
      @SerializedName("INSTAGRAM_MANAGER")
      VALUE_INSTAGRAM_MANAGER("INSTAGRAM_MANAGER"),
      @SerializedName("CREATIVE")
      VALUE_CREATIVE("CREATIVE"),
      @SerializedName("FB_EMPLOYEE_DSO_ADVERTISER")
      VALUE_FB_EMPLOYEE_DSO_ADVERTISER("FB_EMPLOYEE_DSO_ADVERTISER"),
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

  public static enum EnumSubtype {
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("OFFLINE_CONVERSION")
      VALUE_OFFLINE_CONVERSION("OFFLINE_CONVERSION"),
      @SerializedName("CLAIM")
      VALUE_CLAIM("CLAIM"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      @SerializedName("MANAGED")
      VALUE_MANAGED("MANAGED"),
      @SerializedName("VIDEO")
      VALUE_VIDEO("VIDEO"),
      @SerializedName("LOOKALIKE")
      VALUE_LOOKALIKE("LOOKALIKE"),
      @SerializedName("ENGAGEMENT")
      VALUE_ENGAGEMENT("ENGAGEMENT"),
      @SerializedName("DATA_SET")
      VALUE_DATA_SET("DATA_SET"),
      @SerializedName("BAG_OF_ACCOUNTS")
      VALUE_BAG_OF_ACCOUNTS("BAG_OF_ACCOUNTS"),
      @SerializedName("STUDY_RULE_AUDIENCE")
      VALUE_STUDY_RULE_AUDIENCE("STUDY_RULE_AUDIENCE"),
      @SerializedName("FOX")
      VALUE_FOX("FOX"),
      NULL(null);

      private String value;

      private EnumSubtype(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCallToActionType {
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("MOMENTS")
      VALUE_MOMENTS("MOMENTS"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      NULL(null);

      private String value;

      private EnumCallToActionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginalProjectionType {
      @SerializedName("equirectangular")
      VALUE_EQUIRECTANGULAR("equirectangular"),
      @SerializedName("cubemap")
      VALUE_CUBEMAP("cubemap"),
      @SerializedName("equiangular_cubemap")
      VALUE_EQUIANGULAR_CUBEMAP("equiangular_cubemap"),
<<<<<<< HEAD
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);
=======
      @SerializedName("half_equirectangular")
      VALUE_HALF_EQUIRECTANGULAR("half_equirectangular"),
      NULL(null);
>>>>>>> upstream/master

      private String value;

      private EnumOriginalProjectionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUnpublishedContentType {
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
<<<<<<< HEAD
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);
=======
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      NULL(null);
>>>>>>> upstream/master

      private String value;

      private EnumUnpublishedContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUploadPhase {
      @SerializedName("start")
      VALUE_START("start"),
      @SerializedName("transfer")
      VALUE_TRANSFER("transfer"),
      @SerializedName("finish")
      VALUE_FINISH("finish"),
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumUploadPhase(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumNotificationMode {
      @SerializedName("OFF")
      VALUE_OFF("OFF"),
      @SerializedName("ON_COMPLETE")
      VALUE_ON_COMPLETE("ON_COMPLETE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumNotificationMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

<<<<<<< HEAD
  public static enum EnumSubtype {
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("OFFLINE_CONVERSION")
      VALUE_OFFLINE_CONVERSION("OFFLINE_CONVERSION"),
      @SerializedName("CLAIM")
      VALUE_CLAIM("CLAIM"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      @SerializedName("MANAGED")
      VALUE_MANAGED("MANAGED"),
      @SerializedName("VIDEO")
      VALUE_VIDEO("VIDEO"),
      @SerializedName("LOOKALIKE")
      VALUE_LOOKALIKE("LOOKALIKE"),
      @SerializedName("ENGAGEMENT")
      VALUE_ENGAGEMENT("ENGAGEMENT"),
      @SerializedName("DATA_SET")
      VALUE_DATA_SET("DATA_SET"),
      @SerializedName("BAG_OF_ACCOUNTS")
      VALUE_BAG_OF_ACCOUNTS("BAG_OF_ACCOUNTS"),
      @SerializedName("STUDY_RULE_AUDIENCE")
      VALUE_STUDY_RULE_AUDIENCE("STUDY_RULE_AUDIENCE"),
      @SerializedName("FOX")
      VALUE_FOX("FOX"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumSubtype(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

=======
>>>>>>> upstream/master

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

  public AdAccount copyFrom(AdAccount instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountStatus = instance.mAccountStatus;
    this.mAge = instance.mAge;
    this.mAgencyClientDeclaration = instance.mAgencyClientDeclaration;
    this.mAmountSpent = instance.mAmountSpent;
    this.mAttributionSpec = instance.mAttributionSpec;
    this.mBalance = instance.mBalance;
    this.mBusiness = instance.mBusiness;
    this.mBusinessCity = instance.mBusinessCity;
    this.mBusinessCountryCode = instance.mBusinessCountryCode;
    this.mBusinessName = instance.mBusinessName;
    this.mBusinessState = instance.mBusinessState;
    this.mBusinessStreet = instance.mBusinessStreet;
    this.mBusinessStreet2 = instance.mBusinessStreet2;
    this.mBusinessZip = instance.mBusinessZip;
    this.mCanCreateBrandLiftStudy = instance.mCanCreateBrandLiftStudy;
    this.mCapabilities = instance.mCapabilities;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCurrency = instance.mCurrency;
    this.mDisableReason = instance.mDisableReason;
    this.mEndAdvertiser = instance.mEndAdvertiser;
    this.mEndAdvertiserName = instance.mEndAdvertiserName;
    this.mExtendedCreditInvoiceGroup = instance.mExtendedCreditInvoiceGroup;
    this.mFailedDeliveryChecks = instance.mFailedDeliveryChecks;
    this.mFundingSource = instance.mFundingSource;
    this.mFundingSourceDetails = instance.mFundingSourceDetails;
    this.mHasMigratedPermissions = instance.mHasMigratedPermissions;
    this.mHasPageAuthorizedAdaccount = instance.mHasPageAuthorizedAdaccount;
    this.mId = instance.mId;
    this.mIoNumber = instance.mIoNumber;
    this.mIsAttributionSpecSystemDefault = instance.mIsAttributionSpecSystemDefault;
    this.mIsDirectDealsEnabled = instance.mIsDirectDealsEnabled;
    this.mIsInMiddleOfLocalEntityMigration = instance.mIsInMiddleOfLocalEntityMigration;
    this.mIsNotificationsEnabled = instance.mIsNotificationsEnabled;
    this.mIsPersonal = instance.mIsPersonal;
    this.mIsPrepayAccount = instance.mIsPrepayAccount;
    this.mIsTaxIdRequired = instance.mIsTaxIdRequired;
    this.mLineNumbers = instance.mLineNumbers;
    this.mMediaAgency = instance.mMediaAgency;
    this.mMinCampaignGroupSpendCap = instance.mMinCampaignGroupSpendCap;
    this.mMinDailyBudget = instance.mMinDailyBudget;
    this.mName = instance.mName;
    this.mOffsitePixelsTosAccepted = instance.mOffsitePixelsTosAccepted;
    this.mOwner = instance.mOwner;
    this.mPartner = instance.mPartner;
    this.mRfSpec = instance.mRfSpec;
    this.mShowCheckoutExperience = instance.mShowCheckoutExperience;
    this.mSpendCap = instance.mSpendCap;
    this.mTaxId = instance.mTaxId;
    this.mTaxIdStatus = instance.mTaxIdStatus;
    this.mTaxIdType = instance.mTaxIdType;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTimezoneName = instance.mTimezoneName;
    this.mTimezoneOffsetHoursUtc = instance.mTimezoneOffsetHoursUtc;
    this.mTosAccepted = instance.mTosAccepted;
    this.mUserRole = instance.mUserRole;
    this.mUserTosAccepted = instance.mUserTosAccepted;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccount> getParser() {
    return new APIRequest.ResponseParser<AdAccount>() {
      public APINodeList<AdAccount> parseResponse(String response, APIContext context, APIRequest<AdAccount> request) throws MalformedResponseException {
        return AdAccount.parseResponse(response, context, request);
      }
    };
  }
}
