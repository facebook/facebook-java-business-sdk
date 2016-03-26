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

import com.facebook.ads.sdk.insights.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.*;


public class AdAccount extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("account_groups")
  private List<AdAccountGroupResult> mAccountGroups = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_status")
  private Long mAccountStatus = null;
  @SerializedName("age")
  private Double mAge = null;
  @SerializedName("agency_client_declaration")
  private AgencyClientDeclaration mAgencyClientDeclaration = null;
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
  @SerializedName("failed_delivery_checks")
  private List<DeliveryCheck> mFailedDeliveryChecks = null;
  @SerializedName("funding_source")
  private String mFundingSource = null;
  @SerializedName("funding_source_details")
  private FundingSourceDetails mFundingSourceDetails = null;
  @SerializedName("has_migrated_permissions")
  private Boolean mHasMigratedPermissions = null;
  @SerializedName("io_number")
  private String mIoNumber = null;
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
  @SerializedName("owner")
  private String mOwner = null;
  @SerializedName("offsite_pixels_tos_accepted")
  private Boolean mOffsitePixelsTosAccepted = null;
  @SerializedName("partner")
  private String mPartner = null;
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
  @SerializedName("rf_spec")
  private ReachFrequencySpec mRfSpec = null;
  @SerializedName("tos_accepted")
  private Map<String, Long> mTosAccepted = null;
  @SerializedName("user_role")
  private String mUserRole = null;
  @SerializedName("vertical_name")
  private String mVerticalName = null;
  @SerializedName("amount_spent")
  private String mAmountSpent = null;
  @SerializedName("spend_cap")
  private String mSpendCap = null;
  @SerializedName("balance")
  private String mBalance = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("last_used_time")
  private String mLastUsedTime = null;
  @SerializedName("asset_score")
  private Double mAssetScore = null;
  protected static Gson gson = null;

  AdAccount() {
  }

  public AdAccount(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccount(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdAccount fetch() throws APIException{
    AdAccount newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    mId = mId.replaceAll("act_", "");
    return this;
  }

  public static AdAccount fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdAccount fetchById(String id, APIContext context) throws APIException {
    AdAccount adAccount =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adAccount;
  }

  public static APINodeList<AdAccount> fetchAll(int limit, APIContext context) throws APIException {
    return new APIRequestList(context).setParam("limit", limit).execute();
  }

  private String getPrefixedId() {
    return ("act_" + mId.toString());
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccount.mContext = context;
    adAccount.rawValue = json;
    adAccount.mId = adAccount.mId.replaceAll("act_", "");
    return adAccount;
  }

  public static APINodeList<AdAccount> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdAccount> adAccounts = new APINodeList<AdAccount>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adAccounts.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            adAccounts.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          adAccounts.add(loadJSON(json, context));
          return adAccounts;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdLabels getAdLabels() {
    return new APIRequestGetAdLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdCreativesByLabels getAdCreativesByLabels() {
    return new APIRequestGetAdCreativesByLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdImages getAdImages() {
    return new APIRequestGetAdImages(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdReportRuns getAdReportRuns() {
    return new APIRequestGetAdReportRuns(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdReportSchedules getAdReportSchedules() {
    return new APIRequestGetAdReportSchedules(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdsByLabels getAdsByLabels() {
    return new APIRequestGetAdsByLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdSetsByLabels getAdSetsByLabels() {
    return new APIRequestGetAdSetsByLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetCampaigns getCampaigns() {
    return new APIRequestGetCampaigns(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetCampaignsByLabels getCampaignsByLabels() {
    return new APIRequestGetCampaignsByLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingBrowse getTargetingBrowse() {
    return new APIRequestGetTargetingBrowse(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingSearch getTargetingSearch() {
    return new APIRequestGetTargetingSearch(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingSuggestions getTargetingSuggestions() {
    return new APIRequestGetTargetingSuggestions(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingValidation getTargetingValidation() {
    return new APIRequestGetTargetingValidation(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTransactions getTransactions() {
    return new APIRequestGetTransactions(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdPlacePageSets getAdPlacePageSets() {
    return new APIRequestGetAdPlacePageSets(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPartners getPartners() {
    return new APIRequestGetPartners(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPartnerCategories getPartnerCategories() {
    return new APIRequestGetPartnerCategories(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetGeneratePreviews getGeneratePreviews() {
    return new APIRequestGetGeneratePreviews(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetRateCard getRateCard() {
    return new APIRequestGetRateCard(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdVideos getAdVideos() {
    return new APIRequestGetAdVideos(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAsyncAdRequestSets getAsyncAdRequestSets() {
    return new APIRequestGetAsyncAdRequestSets(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetConnectionObjects getConnectionObjects() {
    return new APIRequestGetConnectionObjects(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetBroadTargetingCategories getBroadTargetingCategories() {
    return new APIRequestGetBroadTargetingCategories(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetCustomAudiences getCustomAudiences() {
    return new APIRequestGetCustomAudiences(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetCustomAudiencesTos getCustomAudiencesTos() {
    return new APIRequestGetCustomAudiencesTos(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetReachEstimate getReachEstimate() {
    return new APIRequestGetReachEstimate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetReachFrequencyPredictions getReachFrequencyPredictions() {
    return new APIRequestGetReachFrequencyPredictions(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetUsers getUsers() {
    return new APIRequestGetUsers(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOffsitePixels getOffsitePixels() {
    return new APIRequestGetOffsitePixels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetApplications getApplications() {
    return new APIRequestGetApplications(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdvertisableApplications getAdvertisableApplications() {
    return new APIRequestGetAdvertisableApplications(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetRoas getRoas() {
    return new APIRequestGetRoas(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetRoasCohorts getRoasCohorts() {
    return new APIRequestGetRoasCohorts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdCreative createAdCreative() {
    return new APIRequestCreateAdCreative(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAd createAd() {
    return new APIRequestCreateAd(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdImage createAdImage() {
    return new APIRequestCreateAdImage(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdSet createAdSet() {
    return new APIRequestCreateAdSet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateCampaign createCampaign() {
    return new APIRequestCreateCampaign(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdPlacePageSet createAdPlacePageSet() {
    return new APIRequestCreateAdPlacePageSet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdVideo createAdVideo() {
    return new APIRequestCreateAdVideo(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAsyncAdRequestSet createAsyncAdRequestSet() {
    return new APIRequestCreateAsyncAdRequestSet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateCustomAudience createCustomAudience() {
    return new APIRequestCreateCustomAudience(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateReachFrequencyPrediction createReachFrequencyPrediction() {
    return new APIRequestCreateReachFrequencyPrediction(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateOffsitePixel createOffsitePixel() {
    return new APIRequestCreateOffsitePixel(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdImages deleteAdImages() {
    return new APIRequestDeleteAdImages(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteCampaigns deleteCampaigns() {
    return new APIRequestDeleteCampaigns(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateCustomConversion createCustomConversion() {
    return new APIRequestCreateCustomConversion(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateOfflineConversion createOfflineConversion() {
    return new APIRequestCreateOfflineConversion(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateProductAudience createProductAudience() {
    return new APIRequestCreateProductAudience(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public List<AdAccountGroupResult> getFieldAccountGroups() {
    return mAccountGroups;
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

  public String getFieldIoNumber() {
    return mIoNumber;
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

  public String getFieldOwner() {
    return mOwner;
  }

  public Boolean getFieldOffsitePixelsTosAccepted() {
    return mOffsitePixelsTosAccepted;
  }

  public String getFieldPartner() {
    return mPartner;
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

  public ReachFrequencySpec getFieldRfSpec() {
    return mRfSpec;
  }

  public Map<String, Long> getFieldTosAccepted() {
    return mTosAccepted;
  }

  public String getFieldUserRole() {
    return mUserRole;
  }

  public String getFieldVerticalName() {
    return mVerticalName;
  }

  public String getFieldAmountSpent() {
    return mAmountSpent;
  }

  public String getFieldSpendCap() {
    return mSpendCap;
  }

  public String getFieldBalance() {
    return mBalance;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.mContext = getContext();
    }
    return mBusiness;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.mContext = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldLastUsedTime() {
    return mLastUsedTime;
  }

  public Double getFieldAssetScore() {
    return mAssetScore;
  }

  public static class APIRequestList extends APIRequest<AdAccount> {
      APINodeList<AdAccount> lastResponse = null;
      protected static final List<String> PARAMS = Collections.emptyList();

      @Override
      public APINodeList<AdAccount> getLastResponse() {
          return lastResponse;
      }

      public APIRequestList(APIContext context) {
          super(context, "", "/me/adaccounts", "GET", PARAMS);
      }

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
          lastResponse = parseResponse(callInternal(extraParams));
          return lastResponse;
      }

      public APIRequestList setParam(String param, Object value) {
          setParamInternal(param, value);
          return this;
      }

      public APIRequestList setParams(Map<String, Object> params) {
          setParamsInternal(params);
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
      "id",
      "account_groups",
      "account_id",
      "account_status",
      "age",
      "agency_client_declaration",
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
      "failed_delivery_checks",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "io_number",
      "is_notifications_enabled",
      "is_personal",
      "is_prepay_account",
      "is_tax_id_required",
      "line_numbers",
      "media_agency",
      "min_campaign_group_spend_cap",
      "min_daily_budget",
      "name",
      "owner",
      "offsite_pixels_tos_accepted",
      "partner",
      "tax_id",
      "tax_id_status",
      "tax_id_type",
      "timezone_id",
      "timezone_name",
      "timezone_offset_hours_utc",
      "rf_spec",
      "tos_accepted",
      "user_role",
      "vertical_name",
      "amount_spent",
      "spend_cap",
      "balance",
      "business",
      "owner_business",
      "last_used_time",
      "asset_score",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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
    public APIRequestGet requestAccountGroupsField () {
      return this.requestAccountGroupsField(true);
    }
    public APIRequestGet requestAccountGroupsField (boolean value) {
      this.requestField("account_groups", value);
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
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
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
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGet requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGet requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGet requestPartnerField (boolean value) {
      this.requestField("partner", value);
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
    public APIRequestGet requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGet requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
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
    public APIRequestGet requestVerticalNameField () {
      return this.requestVerticalNameField(true);
    }
    public APIRequestGet requestVerticalNameField (boolean value) {
      this.requestField("vertical_name", value);
      return this;
    }
    public APIRequestGet requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGet requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGet requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGet requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGet requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
      return this;
    }
    public APIRequestGet requestAssetScoreField () {
      return this.requestAssetScoreField(true);
    }
    public APIRequestGet requestAssetScoreField (boolean value) {
      this.requestField("asset_score", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "name",
      "spend_cap_action",
      "spend_cap",
      "agency_client_declaration",
      "business_info",
      "redownload",
      "currency",
      "timezone_id",
      "end_advertiser",
      "media_agency",
      "partner",
      "is_notifications_enabled",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setSpendCapAction (String spendCapAction) {
      this.setParam("spend_cap_action", spendCapAction);
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

    public APIRequestUpdate setAgencyClientDeclaration (Map<String, String> agencyClientDeclaration) {
      this.setParam("agency_client_declaration", agencyClientDeclaration);
      return this;
    }

    public APIRequestUpdate setAgencyClientDeclaration (String agencyClientDeclaration) {
      this.setParam("agency_client_declaration", agencyClientDeclaration);
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

    public APIRequestUpdate setRedownload (Boolean redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestUpdate setRedownload (String redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestUpdate setCurrency (EnumCurrency currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
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

    public APIRequestUpdate setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }


    public APIRequestUpdate setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }


    public APIRequestUpdate setPartner (String partner) {
      this.setParam("partner", partner);
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

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "after",
      "limit",
      "since",
      "category",
      "until",
      "uid",
      "business_id",
      "oid",
      "extra_oids",
      "add_children",
    };

    public static final String[] FIELDS = {
      "event_type",
      "translated_event_type",
      "actor_id",
      "actor_name",
      "application_id",
      "application_name",
      "object_id",
      "object_name",
      "event_time",
      "extra_data",
      "date_time_in_timezone",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setAfter (String after) {
      this.setParam("after", after);
      return this;
    }


    public APIRequestGetActivities setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetActivities setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetActivities setSince (String since) {
      this.setParam("since", since);
      return this;
    }


    public APIRequestGetActivities setCategory (EnumCategory category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setUntil (String until) {
      this.setParam("until", until);
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

    public APIRequestGetActivities setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }


    public APIRequestGetActivities setOid (String oid) {
      this.setParam("oid", oid);
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

    public APIRequestGetActivities setAddChildren (Boolean addChildren) {
      this.setParam("add_children", addChildren);
      return this;
    }

    public APIRequestGetActivities setAddChildren (String addChildren) {
      this.setParam("add_children", addChildren);
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

    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestTranslatedEventTypeField () {
      return this.requestTranslatedEventTypeField(true);
    }
    public APIRequestGetActivities requestTranslatedEventTypeField (boolean value) {
      this.requestField("translated_event_type", value);
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
    public APIRequestGetActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField () {
      return this.requestDateTimeInTimezoneField(true);
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField (boolean value) {
      this.requestField("date_time_in_timezone", value);
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
      "id",
      "account",
      "name",
      "created_time",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdLabels requestAccountField () {
      return this.requestAccountField(true);
    }
    public APIRequestGetAdLabels requestAccountField (boolean value) {
      this.requestField("account", value);
      return this;
    }
    public APIRequestGetAdLabels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdLabels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdLabels requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdLabels requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
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

  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "adlabels",
      "body",
      "call_to_action_type",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "product_set_id",
      "run_status",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
      "applink_treatment",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorImageHashField () {
      return this.requestActorImageHashField(true);
    }
    public APIRequestGetAdCreatives requestActorImageHashField (boolean value) {
      this.requestField("actor_image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorImageUrlField () {
      return this.requestActorImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestActorImageUrlField (boolean value) {
      this.requestField("actor_image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetAdCreatives requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
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
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
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
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestRunStatusField () {
      return this.requestRunStatusField(true);
    }
    public APIRequestGetAdCreatives requestRunStatusField (boolean value) {
      this.requestField("run_status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
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
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
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
      "id",
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "adlabels",
      "body",
      "call_to_action_type",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "product_set_id",
      "run_status",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
      "applink_treatment",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdCreativesByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreativesbylabels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdCreativesByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdCreativesByLabels setOperator (EnumAdCreativeOperator operator) {
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

    public APIRequestGetAdCreativesByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdCreativesByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdCreativesByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdCreativesByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreativesByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestActorImageHashField () {
      return this.requestActorImageHashField(true);
    }
    public APIRequestGetAdCreativesByLabels requestActorImageHashField (boolean value) {
      this.requestField("actor_image_hash", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestActorImageUrlField () {
      return this.requestActorImageUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestActorImageUrlField (boolean value) {
      this.requestField("actor_image_url", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetAdCreativesByLabels requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreativesByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreativesByLabels requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreativesByLabels requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
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
    public APIRequestGetAdCreativesByLabels requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
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
    public APIRequestGetAdCreativesByLabels requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreativesByLabels requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestRunStatusField () {
      return this.requestRunStatusField(true);
    }
    public APIRequestGetAdCreativesByLabels requestRunStatusField (boolean value) {
      this.requestField("run_status", value);
      return this;
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreativesByLabels requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
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
    public APIRequestGetAdCreativesByLabels requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreativesByLabels requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
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
      "effective_status",
      "date_preset",
      "include_deleted",
      "time_range",
      "updated_since",
      "ad_draft_id",
    };

    public static final String[] FIELDS = {
      "id",
      "account_id",
      "adset",
      "campaign",
      "adlabels",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "last_updated_by_app_id",
      "name",
      "tracking_specs",
      "updated_time",
      "campaign_id",
      "ad_review_feedback",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetAds setDatePreset (EnumAdDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setIncludeDeleted (Boolean includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAds setIncludeDeleted (String includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
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

    public APIRequestGetAds setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
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

    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
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
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
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
      "hashes",
      "minwidth",
      "minheight",
      "name",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "account_id",
      "created_time",
      "creatives",
      "hash",
      "height",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdImages(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdImages setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetAdImages setMinwidth (Long minwidth) {
      this.setParam("minwidth", minwidth);
      return this;
    }

    public APIRequestGetAdImages setMinwidth (String minwidth) {
      this.setParam("minwidth", minwidth);
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

    public APIRequestGetAdImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdImages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdImages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdImages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdImages requestNameField (boolean value) {
      this.requestField("name", value);
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

  public static class APIRequestGetAdReportRuns extends APIRequest<AdReportRun> {

    APINodeList<AdReportRun> lastResponse = null;
    @Override
    public APINodeList<AdReportRun> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "async_status",
      "async_percent_completion",
      "account_id",
      "schedule_id",
      "time_ref",
      "time_completed",
      "emails",
      "friendly_name",
      "is_bookmarked",
      "is_running",
      "date_start",
      "date_stop",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdReportRuns(String nodeId, APIContext context) {
      super(context, nodeId, "/adreportruns", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdReportRuns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdReportRuns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdReportRuns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdReportRuns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdReportRuns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdReportRuns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdReportRuns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGetAdReportRuns requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGetAdReportRuns requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdReportRuns requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGetAdReportRuns requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGetAdReportRuns requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
    public APIRequestGetAdReportRuns requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGetAdReportRuns requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdReportSchedules(String nodeId, APIContext context) {
      super(context, nodeId, "/adreportschedules", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdReportSchedules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdReportSchedules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdReportSchedules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdReportSchedules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdReportSchedules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "effective_status",
      "date_preset",
      "include_deleted",
      "is_completed",
      "time_range",
      "ad_draft_id",
    };

    public static final String[] FIELDS = {
      "adlabels",
      "adset_schedule",
      "id",
      "account_id",
      "bid_amount",
      "bid_info",
      "billing_event",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "is_autobid",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "product_ad_behavior",
      "promoted_object",
      "rf_prediction_id",
      "rtb_flag",
      "start_time",
      "targeting",
      "updated_time",
      "use_new_app_click",
      "pacing_type",
      "budget_remaining",
      "daily_budget",
      "lifetime_budget",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets setEffectiveStatus (List<EnumAdSetEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setDatePreset (EnumAdSetDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAdSets setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAdSets setIncludeDeleted (Boolean includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAdSets setIncludeDeleted (String includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
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

    public APIRequestGetAdSets setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetAdSets setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
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

    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetAdSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
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
    public APIRequestGetAdSets requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSets requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
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
    public APIRequestGetAdSets requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSets requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetAdSets requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSets requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
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
    public APIRequestGetAdSets requestProductAdBehaviorField () {
      return this.requestProductAdBehaviorField(true);
    }
    public APIRequestGetAdSets requestProductAdBehaviorField (boolean value) {
      this.requestField("product_ad_behavior", value);
      return this;
    }
    public APIRequestGetAdSets requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSets requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
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
    public APIRequestGetAdSets requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSets requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSets requestTargetingField (boolean value) {
      this.requestField("targeting", value);
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
    public APIRequestGetAdSets requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSets requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSets requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSets requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSets requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
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
      "id",
      "account_id",
      "adset",
      "campaign",
      "adlabels",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "last_updated_by_app_id",
      "name",
      "tracking_specs",
      "updated_time",
      "campaign_id",
      "ad_review_feedback",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adsbylabels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdsByLabels setOperator (EnumAdOperator operator) {
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

    public APIRequestGetAdsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAdsByLabels requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdsByLabels requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdsByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
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
    public APIRequestGetAdsByLabels requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdsByLabels requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdsByLabels requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAdsByLabels requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
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
      "adlabels",
      "adset_schedule",
      "id",
      "account_id",
      "bid_amount",
      "bid_info",
      "billing_event",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "is_autobid",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "product_ad_behavior",
      "promoted_object",
      "rf_prediction_id",
      "rtb_flag",
      "start_time",
      "targeting",
      "updated_time",
      "use_new_app_click",
      "pacing_type",
      "budget_remaining",
      "daily_budget",
      "lifetime_budget",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdSetsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adsetsbylabels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdSetsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdSetsByLabels setOperator (EnumAdSetOperator operator) {
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

    public APIRequestGetAdSetsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdSetsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdSetsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdSetsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetAdSetsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSetsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
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
    public APIRequestGetAdSetsByLabels requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSetsByLabels requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
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
    public APIRequestGetAdSetsByLabels requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetAdSetsByLabels requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetAdSetsByLabels requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSetsByLabels requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetAdSetsByLabels requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
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
    public APIRequestGetAdSetsByLabels requestProductAdBehaviorField () {
      return this.requestProductAdBehaviorField(true);
    }
    public APIRequestGetAdSetsByLabels requestProductAdBehaviorField (boolean value) {
      this.requestField("product_ad_behavior", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSetsByLabels requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
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
    public APIRequestGetAdSetsByLabels requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSetsByLabels requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSetsByLabels requestTargetingField (boolean value) {
      this.requestField("targeting", value);
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
    public APIRequestGetAdSetsByLabels requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSetsByLabels requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSetsByLabels requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSetsByLabels requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSetsByLabels requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSetsByLabels requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
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
      "effective_status",
      "date_preset",
      "is_completed",
      "time_range",
      "ad_draft_id",
    };

    public static final String[] FIELDS = {
      "id",
      "adlabels",
      "account_id",
      "buying_type",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "effective_status",
      "name",
      "objective",
      "start_time",
      "stop_time",
      "updated_time",
      "spend_cap",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaigns setEffectiveStatus (List<EnumCampaignEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCampaigns setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCampaigns setDatePreset (EnumCampaignDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCampaigns setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
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

    public APIRequestGetCampaigns setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetCampaigns setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
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

    public APIRequestGetCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaigns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaigns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaigns requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaigns requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaigns requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaigns requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaigns requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
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
    public APIRequestGetCampaigns requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaigns requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
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
    public APIRequestGetCampaigns requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaigns requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
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
    public APIRequestGetCampaigns requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaigns requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
      "id",
      "adlabels",
      "account_id",
      "buying_type",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "effective_status",
      "name",
      "objective",
      "start_time",
      "stop_time",
      "updated_time",
      "spend_cap",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCampaignsByLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/campaignsbylabels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetCampaignsByLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetCampaignsByLabels setOperator (EnumCampaignOperator operator) {
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

    public APIRequestGetCampaignsByLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetCampaignsByLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCampaignsByLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetCampaignsByLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaignsByLabels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaignsByLabels requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaignsByLabels requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaignsByLabels requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaignsByLabels requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
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
    public APIRequestGetCampaignsByLabels requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaignsByLabels requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
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
    public APIRequestGetCampaignsByLabels requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaignsByLabels requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
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
    public APIRequestGetCampaignsByLabels requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaignsByLabels requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }

  }

  public static class APIRequestGetTargetingBrowse extends APIRequest<AdAccountTargetingBrowse> {

    APINodeList<AdAccountTargetingBrowse> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingBrowse> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "info",
      "info_title",
      "img",
      "key",
      "link",
      "name",
      "type",
      "path",
      "parent",
      "description",
      "source",
      "audience_size",
    };

    @Override
    public APINodeList<AdAccountTargetingBrowse> parseResponse(String response) throws APIException {
      return AdAccountTargetingBrowse.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingBrowse> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingBrowse> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingBrowse(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingbrowse", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingBrowse setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingBrowse setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetTargetingBrowse requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingBrowse requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingBrowse requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTargetingBrowse requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingBrowse requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingBrowse requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestInfoField () {
      return this.requestInfoField(true);
    }
    public APIRequestGetTargetingBrowse requestInfoField (boolean value) {
      this.requestField("info", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestInfoTitleField () {
      return this.requestInfoTitleField(true);
    }
    public APIRequestGetTargetingBrowse requestInfoTitleField (boolean value) {
      this.requestField("info_title", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestImgField () {
      return this.requestImgField(true);
    }
    public APIRequestGetTargetingBrowse requestImgField (boolean value) {
      this.requestField("img", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGetTargetingBrowse requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetTargetingBrowse requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingBrowse requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingBrowse requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingBrowse requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGetTargetingBrowse requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingBrowse requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetTargetingBrowse requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetTargetingBrowse requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingBrowse requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }

  }

  public static class APIRequestGetTargetingSearch extends APIRequest<AdAccountTargetingSearch> {

    APINodeList<AdAccountTargetingSearch> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingSearch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "q",
      "types",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "type",
      "path",
      "description",
      "source",
      "partner",
      "audience_size",
      "country",
    };

    @Override
    public APINodeList<AdAccountTargetingSearch> parseResponse(String response) throws APIException {
      return AdAccountTargetingSearch.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingSearch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingSearch> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingSearch(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsearch", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingSearch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingSearch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSearch setQ (String q) {
      this.setParam("q", q);
      return this;
    }


    public APIRequestGetTargetingSearch setTypes (List<String> types) {
      this.setParam("types", types);
      return this;
    }

    public APIRequestGetTargetingSearch setTypes (String types) {
      this.setParam("types", types);
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

    public APIRequestGetTargetingSearch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingSearch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSearch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTargetingSearch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSearch requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSearch requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingSearch requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingSearch requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingSearch requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingSearch requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetTargetingSearch requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetTargetingSearch requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingSearch requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingSearch requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetTargetingSearch requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }

  }

  public static class APIRequestGetTargetingSuggestions extends APIRequest<AdAccountTargetingSuggestions> {

    APINodeList<AdAccountTargetingSuggestions> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingSuggestions> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "targeting_list",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "type",
      "path",
      "description",
      "source",
      "partner",
      "audience_size",
      "country",
    };

    @Override
    public APINodeList<AdAccountTargetingSuggestions> parseResponse(String response) throws APIException {
      return AdAccountTargetingSuggestions.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingSuggestions> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingSuggestions> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingSuggestions(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsuggestions", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingSuggestions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingSuggestions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSuggestions setTargetingList (List<String> targetingList) {
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

    public APIRequestGetTargetingSuggestions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingSuggestions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSuggestions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTargetingSuggestions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSuggestions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSuggestions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingSuggestions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingSuggestions requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingSuggestions requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingSuggestions requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetTargetingSuggestions requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetTargetingSuggestions requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingSuggestions requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
      return this;
    }
    public APIRequestGetTargetingSuggestions requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetTargetingSuggestions requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }

  }

  public static class APIRequestGetTargetingValidation extends APIRequest<AdAccountTargetingValidation> {

    APINodeList<AdAccountTargetingValidation> lastResponse = null;
    @Override
    public APINodeList<AdAccountTargetingValidation> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "targeting_list",
      "id_list",
      "name_list",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "type",
      "path",
      "description",
      "source",
      "partner",
      "audience_size",
      "valid",
    };

    @Override
    public APINodeList<AdAccountTargetingValidation> parseResponse(String response) throws APIException {
      return AdAccountTargetingValidation.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountTargetingValidation> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountTargetingValidation> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingValidation(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingvalidation", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingValidation setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingValidation setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingValidation setTargetingList (List<String> targetingList) {
      this.setParam("targeting_list", targetingList);
      return this;
    }

    public APIRequestGetTargetingValidation setTargetingList (String targetingList) {
      this.setParam("targeting_list", targetingList);
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

    public APIRequestGetTargetingValidation setNameList (List<String> nameList) {
      this.setParam("name_list", nameList);
      return this;
    }

    public APIRequestGetTargetingValidation setNameList (String nameList) {
      this.setParam("name_list", nameList);
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

    public APIRequestGetTargetingValidation requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingValidation requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingValidation requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTargetingValidation requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingValidation requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingValidation requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTargetingValidation requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTargetingValidation requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestPathField () {
      return this.requestPathField(true);
    }
    public APIRequestGetTargetingValidation requestPathField (boolean value) {
      this.requestField("path", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTargetingValidation requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetTargetingValidation requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetTargetingValidation requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetTargetingValidation requestAudienceSizeField () {
      return this.requestAudienceSizeField(true);
    }
    public APIRequestGetTargetingValidation requestAudienceSizeField (boolean value) {
      this.requestField("audience_size", value);
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

  public static class APIRequestGetTransactions extends APIRequest<Transaction> {

    APINodeList<Transaction> lastResponse = null;
    @Override
    public APINodeList<Transaction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "time_start",
      "time_stop",
    };

    public static final String[] FIELDS = {
      "id",
      "time",
      "account_id",
      "fatura_id",
      "charge_type",
      "status",
      "billing_start_time",
      "billing_end_time",
      "payment_option",
      "app_amount",
      "product_type",
      "provider_amount",
    };

    @Override
    public APINodeList<Transaction> parseResponse(String response) throws APIException {
      return Transaction.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Transaction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Transaction> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTransactions(String nodeId, APIContext context) {
      super(context, nodeId, "/transactions", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTransactions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTransactions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTransactions setTimeStart (Long timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestGetTransactions setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestGetTransactions setTimeStop (Long timeStop) {
      this.setParam("time_stop", timeStop);
      return this;
    }

    public APIRequestGetTransactions setTimeStop (String timeStop) {
      this.setParam("time_stop", timeStop);
      return this;
    }

    public APIRequestGetTransactions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTransactions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTransactions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTransactions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTransactions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTransactions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTransactions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTransactions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTransactions requestTimeField () {
      return this.requestTimeField(true);
    }
    public APIRequestGetTransactions requestTimeField (boolean value) {
      this.requestField("time", value);
      return this;
    }
    public APIRequestGetTransactions requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetTransactions requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetTransactions requestFaturaIdField () {
      return this.requestFaturaIdField(true);
    }
    public APIRequestGetTransactions requestFaturaIdField (boolean value) {
      this.requestField("fatura_id", value);
      return this;
    }
    public APIRequestGetTransactions requestChargeTypeField () {
      return this.requestChargeTypeField(true);
    }
    public APIRequestGetTransactions requestChargeTypeField (boolean value) {
      this.requestField("charge_type", value);
      return this;
    }
    public APIRequestGetTransactions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetTransactions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetTransactions requestBillingStartTimeField () {
      return this.requestBillingStartTimeField(true);
    }
    public APIRequestGetTransactions requestBillingStartTimeField (boolean value) {
      this.requestField("billing_start_time", value);
      return this;
    }
    public APIRequestGetTransactions requestBillingEndTimeField () {
      return this.requestBillingEndTimeField(true);
    }
    public APIRequestGetTransactions requestBillingEndTimeField (boolean value) {
      this.requestField("billing_end_time", value);
      return this;
    }
    public APIRequestGetTransactions requestPaymentOptionField () {
      return this.requestPaymentOptionField(true);
    }
    public APIRequestGetTransactions requestPaymentOptionField (boolean value) {
      this.requestField("payment_option", value);
      return this;
    }
    public APIRequestGetTransactions requestAppAmountField () {
      return this.requestAppAmountField(true);
    }
    public APIRequestGetTransactions requestAppAmountField (boolean value) {
      this.requestField("app_amount", value);
      return this;
    }
    public APIRequestGetTransactions requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGetTransactions requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGetTransactions requestProviderAmountField () {
      return this.requestProviderAmountField(true);
    }
    public APIRequestGetTransactions requestProviderAmountField (boolean value) {
      this.requestField("provider_amount", value);
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
      "id",
      "owner_business",
      "owner_ad_account",
      "name",
      "creation_time",
      "last_fired_time",
      "code",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdsPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/adspixels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdsPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdsPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdsPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdsPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdsPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetAdsPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdsPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetAdsPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetAdsPixels requestCodeField (boolean value) {
      this.requestField("code", value);
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
      "id",
      "name",
      "account_id",
      "parent_page",
      "pages_count",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdPlacePageSets(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_place_page_sets", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdPlacePageSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdPlacePageSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdPlacePageSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdPlacePageSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdPlacePageSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdPlacePageSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdPlacePageSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdPlacePageSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdPlacePageSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAdPlacePageSets requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetAdPlacePageSets requestPagesCountField () {
      return this.requestPagesCountField(true);
    }
    public APIRequestGetAdPlacePageSets requestPagesCountField (boolean value) {
      this.requestField("pages_count", value);
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPartners(String nodeId, APIContext context) {
      super(context, nodeId, "/partners", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPartners setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetPartners requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPartners requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPartners requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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

  public static class APIRequestGetPartnerCategories extends APIRequest<PartnerCategory> {

    APINodeList<PartnerCategory> lastResponse = null;
    @Override
    public APINodeList<PartnerCategory> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "targeting_type",
      "private_or_public",
      "hide_pc",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "country",
      "description",
      "details",
      "source",
      "parent_category",
      "targeting_type",
      "is_private",
      "approximate_count",
      "status",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPartnerCategories(String nodeId, APIContext context) {
      super(context, nodeId, "/partnercategories", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPartnerCategories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetPartnerCategories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartnerCategories setTargetingType (String targetingType) {
      this.setParam("targeting_type", targetingType);
      return this;
    }


    public APIRequestGetPartnerCategories setPrivateOrPublic (String privateOrPublic) {
      this.setParam("private_or_public", privateOrPublic);
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

    public APIRequestGetPartnerCategories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartnerCategories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPartnerCategories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPartnerCategories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPartnerCategories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetPartnerCategories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartnerCategories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartnerCategories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartnerCategories requestNameField (boolean value) {
      this.requestField("name", value);
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
    public APIRequestGetPartnerCategories requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPartnerCategories requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestParentCategoryField () {
      return this.requestParentCategoryField(true);
    }
    public APIRequestGetPartnerCategories requestParentCategoryField (boolean value) {
      this.requestField("parent_category", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestTargetingTypeField () {
      return this.requestTargetingTypeField(true);
    }
    public APIRequestGetPartnerCategories requestTargetingTypeField (boolean value) {
      this.requestField("targeting_type", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetPartnerCategories requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGetPartnerCategories requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGetPartnerCategories requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPartnerCategories requestStatusField (boolean value) {
      this.requestField("status", value);
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
      "post",
      "height",
      "width",
      "product_item_ids",
      "locale",
      "creative",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetGeneratePreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/generatepreviews", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetGeneratePreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetGeneratePreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGeneratePreviews setAdFormat (EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetGeneratePreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
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

    public APIRequestGetGeneratePreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetGeneratePreviews setHeight (String height) {
      this.setParam("height", height);
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

    public APIRequestGetGeneratePreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetGeneratePreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetGeneratePreviews setLocale (String locale) {
      this.setParam("locale", locale);
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

    public APIRequestGetGeneratePreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGeneratePreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetGeneratePreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetGeneratePreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetGeneratePreviews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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

  public static class APIRequestGetRateCard extends APIRequest<RateCard> {

    APINodeList<RateCard> lastResponse = null;
    @Override
    public APINodeList<RateCard> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "rate",
      "country",
      "currency",
    };

    @Override
    public APINodeList<RateCard> parseResponse(String response) throws APIException {
      return RateCard.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<RateCard> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<RateCard> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetRateCard(String nodeId, APIContext context) {
      super(context, nodeId, "/ratecard", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetRateCard setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetRateCard setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRateCard requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRateCard requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRateCard requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetRateCard requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRateCard requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetRateCard requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRateCard requestRateField () {
      return this.requestRateField(true);
    }
    public APIRequestGetRateCard requestRateField (boolean value) {
      this.requestField("rate", value);
      return this;
    }
    public APIRequestGetRateCard requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetRateCard requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetRateCard requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetRateCard requestCurrencyField (boolean value) {
      this.requestField("currency", value);
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/advideos", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetAdVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdVideos requestField (String field, boolean value) {
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
      "id",
      "owner_id",
      "name",
      "notification_mode",
      "notification_uri",
      "total_count",
      "initial_count",
      "in_progress_count",
      "success_count",
      "error_count",
      "canceled_count",
      "is_completed",
      "created_time",
      "updated_time",
      "notification_status",
      "notification_result",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAsyncAdRequestSets(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequestsets", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAsyncAdRequestSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAsyncAdRequestSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAsyncAdRequestSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAsyncAdRequestSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAsyncAdRequestSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAsyncAdRequestSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
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
    public APIRequestGetAsyncAdRequestSets requestNotificationUriField () {
      return this.requestNotificationUriField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationUriField (boolean value) {
      this.requestField("notification_uri", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestInitialCountField () {
      return this.requestInitialCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestInitialCountField (boolean value) {
      this.requestField("initial_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestInProgressCountField () {
      return this.requestInProgressCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestInProgressCountField (boolean value) {
      this.requestField("in_progress_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestSuccessCountField () {
      return this.requestSuccessCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestSuccessCountField (boolean value) {
      this.requestField("success_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestErrorCountField () {
      return this.requestErrorCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestErrorCountField (boolean value) {
      this.requestField("error_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestCanceledCountField () {
      return this.requestCanceledCountField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestCanceledCountField (boolean value) {
      this.requestField("canceled_count", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestIsCompletedField () {
      return this.requestIsCompletedField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestIsCompletedField (boolean value) {
      this.requestField("is_completed", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationStatusField () {
      return this.requestNotificationStatusField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationStatusField (boolean value) {
      this.requestField("notification_status", value);
      return this;
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationResultField () {
      return this.requestNotificationResultField(true);
    }
    public APIRequestGetAsyncAdRequestSets requestNotificationResultField (boolean value) {
      this.requestField("notification_result", value);
      return this;
    }

  }

  public static class APIRequestGetConnectionObjects extends APIRequest<ConnectionObject> {

    APINodeList<ConnectionObject> lastResponse = null;
    @Override
    public APINodeList<ConnectionObject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "extra_fbids",
      "extra_only",
      "limit",
      "offset",
      "business_id",
      "non_business_only",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "name_with_location_descriptor",
      "url",
      "type",
      "checkin_capable",
      "picture",
      "tabs",
      "is_game",
      "supported_platforms",
      "native_app_store_ids",
      "object_store_urls",
      "app_installs_tracked",
      "native_app_targeting_ids",
      "og_namespace",
      "og_actions",
      "og_objects",
      "website",
      "logo_url",
      "icon_url",
      "event_parent_page_id",
      "event_parent_page_name",
      "event_start_timestamp",
      "event_is_viewer_admin",
      "cpa_access",
    };

    @Override
    public APINodeList<ConnectionObject> parseResponse(String response) throws APIException {
      return ConnectionObject.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ConnectionObject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ConnectionObject> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetConnectionObjects(String nodeId, APIContext context) {
      super(context, nodeId, "/connectionobjects", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetConnectionObjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetConnectionObjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConnectionObjects setExtraFbids (List<String> extraFbids) {
      this.setParam("extra_fbids", extraFbids);
      return this;
    }

    public APIRequestGetConnectionObjects setExtraFbids (String extraFbids) {
      this.setParam("extra_fbids", extraFbids);
      return this;
    }

    public APIRequestGetConnectionObjects setExtraOnly (Boolean extraOnly) {
      this.setParam("extra_only", extraOnly);
      return this;
    }

    public APIRequestGetConnectionObjects setExtraOnly (String extraOnly) {
      this.setParam("extra_only", extraOnly);
      return this;
    }

    public APIRequestGetConnectionObjects setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetConnectionObjects setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetConnectionObjects setOffset (Long offset) {
      this.setParam("offset", offset);
      return this;
    }

    public APIRequestGetConnectionObjects setOffset (String offset) {
      this.setParam("offset", offset);
      return this;
    }

    public APIRequestGetConnectionObjects setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }


    public APIRequestGetConnectionObjects setNonBusinessOnly (Boolean nonBusinessOnly) {
      this.setParam("non_business_only", nonBusinessOnly);
      return this;
    }

    public APIRequestGetConnectionObjects setNonBusinessOnly (String nonBusinessOnly) {
      this.setParam("non_business_only", nonBusinessOnly);
      return this;
    }

    public APIRequestGetConnectionObjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConnectionObjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetConnectionObjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetConnectionObjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetConnectionObjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetConnectionObjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetConnectionObjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetConnectionObjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetConnectionObjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetConnectionObjects requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetConnectionObjects requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetConnectionObjects requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestCheckinCapableField () {
      return this.requestCheckinCapableField(true);
    }
    public APIRequestGetConnectionObjects requestCheckinCapableField (boolean value) {
      this.requestField("checkin_capable", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetConnectionObjects requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestTabsField () {
      return this.requestTabsField(true);
    }
    public APIRequestGetConnectionObjects requestTabsField (boolean value) {
      this.requestField("tabs", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestIsGameField () {
      return this.requestIsGameField(true);
    }
    public APIRequestGetConnectionObjects requestIsGameField (boolean value) {
      this.requestField("is_game", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestSupportedPlatformsField () {
      return this.requestSupportedPlatformsField(true);
    }
    public APIRequestGetConnectionObjects requestSupportedPlatformsField (boolean value) {
      this.requestField("supported_platforms", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestNativeAppStoreIdsField () {
      return this.requestNativeAppStoreIdsField(true);
    }
    public APIRequestGetConnectionObjects requestNativeAppStoreIdsField (boolean value) {
      this.requestField("native_app_store_ids", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestObjectStoreUrlsField () {
      return this.requestObjectStoreUrlsField(true);
    }
    public APIRequestGetConnectionObjects requestObjectStoreUrlsField (boolean value) {
      this.requestField("object_store_urls", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestAppInstallsTrackedField () {
      return this.requestAppInstallsTrackedField(true);
    }
    public APIRequestGetConnectionObjects requestAppInstallsTrackedField (boolean value) {
      this.requestField("app_installs_tracked", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestNativeAppTargetingIdsField () {
      return this.requestNativeAppTargetingIdsField(true);
    }
    public APIRequestGetConnectionObjects requestNativeAppTargetingIdsField (boolean value) {
      this.requestField("native_app_targeting_ids", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestOgNamespaceField () {
      return this.requestOgNamespaceField(true);
    }
    public APIRequestGetConnectionObjects requestOgNamespaceField (boolean value) {
      this.requestField("og_namespace", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestOgActionsField () {
      return this.requestOgActionsField(true);
    }
    public APIRequestGetConnectionObjects requestOgActionsField (boolean value) {
      this.requestField("og_actions", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestOgObjectsField () {
      return this.requestOgObjectsField(true);
    }
    public APIRequestGetConnectionObjects requestOgObjectsField (boolean value) {
      this.requestField("og_objects", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetConnectionObjects requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestLogoUrlField () {
      return this.requestLogoUrlField(true);
    }
    public APIRequestGetConnectionObjects requestLogoUrlField (boolean value) {
      this.requestField("logo_url", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetConnectionObjects requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestEventParentPageIdField () {
      return this.requestEventParentPageIdField(true);
    }
    public APIRequestGetConnectionObjects requestEventParentPageIdField (boolean value) {
      this.requestField("event_parent_page_id", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestEventParentPageNameField () {
      return this.requestEventParentPageNameField(true);
    }
    public APIRequestGetConnectionObjects requestEventParentPageNameField (boolean value) {
      this.requestField("event_parent_page_name", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestEventStartTimestampField () {
      return this.requestEventStartTimestampField(true);
    }
    public APIRequestGetConnectionObjects requestEventStartTimestampField (boolean value) {
      this.requestField("event_start_timestamp", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestEventIsViewerAdminField () {
      return this.requestEventIsViewerAdminField(true);
    }
    public APIRequestGetConnectionObjects requestEventIsViewerAdminField (boolean value) {
      this.requestField("event_is_viewer_admin", value);
      return this;
    }
    public APIRequestGetConnectionObjects requestCpaAccessField () {
      return this.requestCpaAccessField(true);
    }
    public APIRequestGetConnectionObjects requestCpaAccessField (boolean value) {
      this.requestField("cpa_access", value);
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
      "id",
      "name",
      "category_description",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetBroadTargetingCategories(String nodeId, APIContext context) {
      super(context, nodeId, "/broadtargetingcategories", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetBroadTargetingCategories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetBroadTargetingCategories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetBroadTargetingCategories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetBroadTargetingCategories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetBroadTargetingCategories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetBroadTargetingCategories requestCategoryDescriptionField () {
      return this.requestCategoryDescriptionField(true);
    }
    public APIRequestGetBroadTargetingCategories requestCategoryDescriptionField (boolean value) {
      this.requestField("category_description", value);
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

  public static class APIRequestGetCustomAudiences extends APIRequest<CustomAudience> {

    APINodeList<CustomAudience> lastResponse = null;
    @Override
    public APINodeList<CustomAudience> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "pixel_id",
      "fields",
      "filtering",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCustomAudiences(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiences", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetCustomAudiences setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetCustomAudiences setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomAudiences setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }


    public APIRequestGetCustomAudiences setFields (List<EnumCustomAudienceFields> fields) {
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

    public APIRequestGetCustomAudiences requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomAudiences requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCustomAudiences requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetCustomAudiences requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCustomAudiences requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetCustomAudiences requestField (String field, boolean value) {
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
      "id",
      "type",
      "content",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCustomAudiencesTos(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiencestos", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetCustomAudiencesTos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetCustomAudiencesTos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetCustomAudiencesTos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCustomAudiencesTos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetCustomAudiencesTos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetCustomAudiencesTos requestContentField () {
      return this.requestContentField(true);
    }
    public APIRequestGetCustomAudiencesTos requestContentField (boolean value) {
      this.requestField("content", value);
      return this;
    }

  }

  public abstract static class APIRequestGetInsightsBase<T extends APINode> extends APIRequest<T> {

    APINodeList<T> lastResponse = null;
    @Override
    public APINodeList<T> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "default_summary",
      "fields",
      "filtering",
      "summary",
      "sort",
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "level",
      "product_id_limit",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
    };

    public static final String[] FIELDS = {
    };
    
    public APIRequestGetInsightsBase(String nodeId, APIContext context, String method) {
      super(context, nodeId, "/insights", method, Arrays.asList(PARAMS));
    }

    public APIRequestGetInsightsBase setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetInsightsBase setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsBase setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsBase setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsBase setFields (List<InsightsFieldsEnum> fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsBase setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsBase setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsBase setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsBase setSummary (List<InsightsFieldsEnum> summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsBase setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsBase setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsBase setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsBase setActionAttributionWindows (List<InsightsActionAttributionWindowsEnum> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsBase setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsBase setActionBreakdowns (List<InsightsActionBreakdownsEnum> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setActionReportTime (InsightsActionReportTimeEnum actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsBase setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsBase setBreakdowns (List<InsightsBreakdownsEnum> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setDatePreset (InsightsDatePresetEnum datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsBase setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsBase setLevel (InsightsLevelEnum level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsBase setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsBase setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsBase setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsBase setSummaryActionBreakdowns (List<InsightsSummaryActionBreakdownsEnum> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }


    public APIRequestGetInsightsBase setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetInsightsBase setTimeRanges (List<String> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsBase setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsBase requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsBase requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsightsBase requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetInsightsBase requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsightsBase requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetInsightsBase requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }
  
  public static class APIRequestGetInsights extends APIRequestGetInsightsBase<AdsInsights> {
    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(nodeId, context, "GET");
    }

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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

  }


  public static class APIRequestGetInsightsAsync extends APIRequestGetInsightsBase<AdReportRun> {
    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(nodeId, context, "POST");
    }

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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

  }

  public static class APIRequestGetReachEstimate extends APIRequest<ReachEstimate> {

    APINodeList<ReachEstimate> lastResponse = null;
    @Override
    public APINodeList<ReachEstimate> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "targeting_spec",
      "currency",
      "optimize_for",
      "daily_budget",
      "creative_action_spec",
      "adgroup_ids",
      "concepts",
      "caller_id",
      "object_store_url",
    };

    public static final String[] FIELDS = {
      "users",
      "bid_estimations",
      "estimate_ready",
      "unsupported",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetReachEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/reachestimate", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetReachEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetReachEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetReachEstimate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }


    public APIRequestGetReachEstimate setOptimizeFor (EnumOptimizeFor optimizeFor) {
      this.setParam("optimize_for", optimizeFor);
      return this;
    }

    public APIRequestGetReachEstimate setOptimizeFor (String optimizeFor) {
      this.setParam("optimize_for", optimizeFor);
      return this;
    }

    public APIRequestGetReachEstimate setDailyBudget (Double dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestGetReachEstimate setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestGetReachEstimate setCreativeActionSpec (String creativeActionSpec) {
      this.setParam("creative_action_spec", creativeActionSpec);
      return this;
    }


    public APIRequestGetReachEstimate setAdgroupIds (List<String> adgroupIds) {
      this.setParam("adgroup_ids", adgroupIds);
      return this;
    }

    public APIRequestGetReachEstimate setAdgroupIds (String adgroupIds) {
      this.setParam("adgroup_ids", adgroupIds);
      return this;
    }

    public APIRequestGetReachEstimate setConcepts (String concepts) {
      this.setParam("concepts", concepts);
      return this;
    }


    public APIRequestGetReachEstimate setCallerId (String callerId) {
      this.setParam("caller_id", callerId);
      return this;
    }


    public APIRequestGetReachEstimate setObjectStoreUrl (String objectStoreUrl) {
      this.setParam("object_store_url", objectStoreUrl);
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

    public APIRequestGetReachEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetReachEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetReachEstimate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetReachEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReachEstimate requestUsersField () {
      return this.requestUsersField(true);
    }
    public APIRequestGetReachEstimate requestUsersField (boolean value) {
      this.requestField("users", value);
      return this;
    }
    public APIRequestGetReachEstimate requestBidEstimationsField () {
      return this.requestBidEstimationsField(true);
    }
    public APIRequestGetReachEstimate requestBidEstimationsField (boolean value) {
      this.requestField("bid_estimations", value);
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
      "id",
      "campaign_id",
      "account_id",
      "time_created",
      "frequency_cap",
      "expiration_time",
      "external_reach",
      "external_budget",
      "external_impression",
      "external_maximum_reach",
      "external_maximum_impression",
      "external_maximum_budget",
      "target_spec",
      "target_audience_size",
      "prediction_mode",
      "prediction_progress",
      "time_updated",
      "status",
      "campaign_time_start",
      "campaign_time_stop",
      "external_minimum_budget",
      "external_minimum_reach",
      "external_minimum_impression",
      "reservation_status",
      "story_event_type",
      "curve_budget_reach",
      "holdout_percentage",
      "campaign_group_id",
      "name",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetReachFrequencyPredictions(String nodeId, APIContext context) {
      super(context, nodeId, "/reachfrequencypredictions", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetReachFrequencyPredictions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetReachFrequencyPredictions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetReachFrequencyPredictions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetReachFrequencyPredictions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetReachFrequencyPredictions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReachFrequencyPredictions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
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
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
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
    public APIRequestGetReachFrequencyPredictions requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestStatusField (boolean value) {
      this.requestField("status", value);
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
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetReachFrequencyPredictions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetReachFrequencyPredictions requestNameField (boolean value) {
      this.requestField("name", value);
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
      "targeting_spec",
      "discard_ages",
      "discard_placements",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetTargetingSentenceLines requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSentenceLines requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

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
      "id",
      "name",
      "tag",
      "creator",
      "js_pixel",
      "last_firing_time",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetOffsitePixels(String nodeId, APIContext context) {
      super(context, nodeId, "/offsitepixels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOffsitePixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetOffsitePixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOffsitePixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOffsitePixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetOffsitePixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOffsitePixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOffsitePixels requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetOffsitePixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetOffsitePixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/applications", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetApplications requestField (String field, boolean value) {
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdvertisableApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/advertisable_applications", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdvertisableApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetAdvertisableApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdvertisableApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdvertisableApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdvertisableApplications requestField (String field, boolean value) {
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetInstagramAccounts requestField (String field, boolean value) {
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
      "time_increment",
      "time_range",
      "fields",
      "filtering",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetRoas(String nodeId, APIContext context) {
      super(context, nodeId, "/roas", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetRoas setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetRoas setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetRoas setFields (List<EnumAdAccountRoasFields> fields) {
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

    public APIRequestGetRoas requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoas requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRoas requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetRoas requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRoas requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetRoas requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetRoasCohorts extends APIRequest<AdAccountRoasCohorts> {

    APINodeList<AdAccountRoasCohorts> lastResponse = null;
    @Override
    public APINodeList<AdAccountRoasCohorts> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "time_range",
      "filtering",
      "collation_interval",
    };

    public static final String[] FIELDS = {
      "adgroup_id",
      "campaign_group_id",
      "campaign_id",
      "cohorts_data",
    };

    @Override
    public APINodeList<AdAccountRoasCohorts> parseResponse(String response) throws APIException {
      return AdAccountRoasCohorts.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountRoasCohorts> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountRoasCohorts> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetRoasCohorts(String nodeId, APIContext context) {
      super(context, nodeId, "/roas_cohorts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetRoasCohorts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetRoasCohorts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRoasCohorts setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetRoasCohorts setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetRoasCohorts setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetRoasCohorts setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetRoasCohorts setCollationInterval (EnumCollationInterval collationInterval) {
      this.setParam("collation_interval", collationInterval);
      return this;
    }

    public APIRequestGetRoasCohorts setCollationInterval (String collationInterval) {
      this.setParam("collation_interval", collationInterval);
      return this;
    }

    public APIRequestGetRoasCohorts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoasCohorts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRoasCohorts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetRoasCohorts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetRoasCohorts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetRoasCohorts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRoasCohorts requestAdgroupIdField () {
      return this.requestAdgroupIdField(true);
    }
    public APIRequestGetRoasCohorts requestAdgroupIdField (boolean value) {
      this.requestField("adgroup_id", value);
      return this;
    }
    public APIRequestGetRoasCohorts requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetRoasCohorts requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetRoasCohorts requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetRoasCohorts requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetRoasCohorts requestCohortsDataField () {
      return this.requestCohortsDataField(true);
    }
    public APIRequestGetRoasCohorts requestCohortsDataField (boolean value) {
      this.requestField("cohorts_data", value);
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
      "id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "action_spec",
      "adlabels",
      "applink_treatment",
      "body",
      "call_to_action",
      "dynamic_ad_voice",
      "follow_redirect",
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
      "object_instagram_id",
      "object_story_id",
      "object_type",
      "object_url",
      "place_page_set_id",
      "product_set_id",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
      "video_id",
      "object_story_spec",
      "id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdCreative(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdCreative setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdCreative setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdCreative setActorId (Long actorId) {
      this.setParam("actor_id", actorId);
      return this;
    }

    public APIRequestCreateAdCreative setActorId (String actorId) {
      this.setParam("actor_id", actorId);
      return this;
    }

    public APIRequestCreateAdCreative setActorImageHash (String actorImageHash) {
      this.setParam("actor_image_hash", actorImageHash);
      return this;
    }


    public APIRequestCreateAdCreative setActorImageUrl (String actorImageUrl) {
      this.setParam("actor_image_url", actorImageUrl);
      return this;
    }


    public APIRequestCreateAdCreative setActorName (String actorName) {
      this.setParam("actor_name", actorName);
      return this;
    }


    public APIRequestCreateAdCreative setActionSpec (List<Long> actionSpec) {
      this.setParam("action_spec", actionSpec);
      return this;
    }

    public APIRequestCreateAdCreative setActionSpec (String actionSpec) {
      this.setParam("action_spec", actionSpec);
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

    public APIRequestCreateAdCreative setApplinkTreatment (EnumApplinkTreatment applinkTreatment) {
      this.setParam("applink_treatment", applinkTreatment);
      return this;
    }

    public APIRequestCreateAdCreative setApplinkTreatment (String applinkTreatment) {
      this.setParam("applink_treatment", applinkTreatment);
      return this;
    }

    public APIRequestCreateAdCreative setBody (String body) {
      this.setParam("body", body);
      return this;
    }


    public APIRequestCreateAdCreative setCallToAction (Object callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }

    public APIRequestCreateAdCreative setCallToAction (String callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }

    public APIRequestCreateAdCreative setDynamicAdVoice (EnumDynamicAdVoice dynamicAdVoice) {
      this.setParam("dynamic_ad_voice", dynamicAdVoice);
      return this;
    }

    public APIRequestCreateAdCreative setDynamicAdVoice (String dynamicAdVoice) {
      this.setParam("dynamic_ad_voice", dynamicAdVoice);
      return this;
    }

    public APIRequestCreateAdCreative setFollowRedirect (Boolean followRedirect) {
      this.setParam("follow_redirect", followRedirect);
      return this;
    }

    public APIRequestCreateAdCreative setFollowRedirect (String followRedirect) {
      this.setParam("follow_redirect", followRedirect);
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

    public APIRequestCreateAdCreative setObjectInstagramId (Long objectInstagramId) {
      this.setParam("object_instagram_id", objectInstagramId);
      return this;
    }

    public APIRequestCreateAdCreative setObjectInstagramId (String objectInstagramId) {
      this.setParam("object_instagram_id", objectInstagramId);
      return this;
    }

    public APIRequestCreateAdCreative setObjectStoryId (String objectStoryId) {
      this.setParam("object_story_id", objectStoryId);
      return this;
    }


    public APIRequestCreateAdCreative setObjectType (String objectType) {
      this.setParam("object_type", objectType);
      return this;
    }


    public APIRequestCreateAdCreative setObjectUrl (String objectUrl) {
      this.setParam("object_url", objectUrl);
      return this;
    }


    public APIRequestCreateAdCreative setPlacePageSetId (String placePageSetId) {
      this.setParam("place_page_set_id", placePageSetId);
      return this;
    }


    public APIRequestCreateAdCreative setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
      return this;
    }


    public APIRequestCreateAdCreative setTemplateUrl (String templateUrl) {
      this.setParam("template_url", templateUrl);
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


    public APIRequestCreateAdCreative setVideoId (Long videoId) {
      this.setParam("video_id", videoId);
      return this;
    }

    public APIRequestCreateAdCreative setVideoId (String videoId) {
      this.setParam("video_id", videoId);
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

    public APIRequestCreateAdCreative setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateAdCreative requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdCreative requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdCreative requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdCreative requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "id",
      "adset_id",
      "campaign_group_id",
      "date_format",
      "creative",
      "name",
      "status",
      "tracking_specs",
      "display_sequence",
      "execution_options",
      "adlabels",
      "bid_amount",
      "redownload",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAd(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAd setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAd setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAd addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateAd setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateAd setCampaignGroupId (Long campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestCreateAd setCampaignGroupId (String campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestCreateAd setDateFormat (String dateFormat) {
      this.setParam("date_format", dateFormat);
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

    public APIRequestCreateAd setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateAd setStatus (EnumAdStatus status) {
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

    public APIRequestCreateAd setDisplaySequence (Long displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }

    public APIRequestCreateAd setDisplaySequence (String displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }

    public APIRequestCreateAd setExecutionOptions (List<EnumAdExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAd setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
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

    public APIRequestCreateAd setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAd setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAd setRedownload (Boolean redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestCreateAd setRedownload (String redownload) {
      this.setParam("redownload", redownload);
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

    public APIRequestCreateAd requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAd requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAd requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAd requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdImage(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdImage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdImage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAdImage addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
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

    public APIRequestCreateAdImage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdImage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdImage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdImage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "bid_amount",
      "billing_event",
      "campaign_id",
      "adset_schedule",
      "status",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "end_time",
      "execution_options",
      "frequency_control_specs",
      "is_autobid",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "product_ad_behavior",
      "promoted_object",
      "redownload",
      "rf_prediction_id",
      "rtb_flag",
      "start_time",
      "targeting",
      "time_start",
      "time_stop",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdSet(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestCreateAdSet setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAdSet setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestCreateAdSet setBillingEvent (EnumBillingEvent billingEvent) {
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


    public APIRequestCreateAdSet setAdsetSchedule (List<Object> adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestCreateAdSet setAdsetSchedule (String adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestCreateAdSet setStatus (EnumAdSetStatus status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateAdSet setStatus (String status) {
      this.setParam("status", status);
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

    public APIRequestCreateAdSet setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }


    public APIRequestCreateAdSet setExecutionOptions (List<EnumAdSetExecutionOptions> executionOptions) {
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

    public APIRequestCreateAdSet setIsAutobid (Boolean isAutobid) {
      this.setParam("is_autobid", isAutobid);
      return this;
    }

    public APIRequestCreateAdSet setIsAutobid (String isAutobid) {
      this.setParam("is_autobid", isAutobid);
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

    public APIRequestCreateAdSet setLifetimeFrequencyCap (Long lifetimeFrequencyCap) {
      this.setParam("lifetime_frequency_cap", lifetimeFrequencyCap);
      return this;
    }

    public APIRequestCreateAdSet setLifetimeFrequencyCap (String lifetimeFrequencyCap) {
      this.setParam("lifetime_frequency_cap", lifetimeFrequencyCap);
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

    public APIRequestCreateAdSet setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateAdSet setOptimizationGoal (EnumOptimizationGoal optimizationGoal) {
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

    public APIRequestCreateAdSet setProductAdBehavior (EnumProductAdBehavior productAdBehavior) {
      this.setParam("product_ad_behavior", productAdBehavior);
      return this;
    }

    public APIRequestCreateAdSet setProductAdBehavior (String productAdBehavior) {
      this.setParam("product_ad_behavior", productAdBehavior);
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

    public APIRequestCreateAdSet setRedownload (Boolean redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestCreateAdSet setRedownload (String redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestCreateAdSet setRfPredictionId (String rfPredictionId) {
      this.setParam("rf_prediction_id", rfPredictionId);
      return this;
    }


    public APIRequestCreateAdSet setRtbFlag (Boolean rtbFlag) {
      this.setParam("rtb_flag", rtbFlag);
      return this;
    }

    public APIRequestCreateAdSet setRtbFlag (String rtbFlag) {
      this.setParam("rtb_flag", rtbFlag);
      return this;
    }

    public APIRequestCreateAdSet setStartTime (String startTime) {
      this.setParam("start_time", startTime);
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

    public APIRequestCreateAdSet setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }


    public APIRequestCreateAdSet setTimeStop (String timeStop) {
      this.setParam("time_stop", timeStop);
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

    public APIRequestCreateAdSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "name",
      "objective",
      "status",
      "buying_type",
      "promoted_object",
      "spend_cap",
      "execution_options",
      "adlabels",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateCampaign(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateCampaign setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateCampaign setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCampaign setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateCampaign setObjective (EnumCampaignObjective objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateCampaign setObjective (String objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateCampaign setStatus (EnumCampaignStatus status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateCampaign setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateCampaign setBuyingType (String buyingType) {
      this.setParam("buying_type", buyingType);
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

    public APIRequestCreateCampaign setExecutionOptions (List<EnumCampaignExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateCampaign setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
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

    public APIRequestCreateCampaign requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCampaign requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCampaign requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateCampaign requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCampaign requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateCampaign requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdPlacePageSet(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_place_page_sets", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdPlacePageSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdPlacePageSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdPlacePageSet setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateAdPlacePageSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdPlacePageSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdPlacePageSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdPlacePageSet requestField (String field, boolean value) {
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
      "id",
      "title",
      "description",
      "unpublished_content_type",
      "file_url",
      "thumb",
      "upload_phase",
      "file_size",
      "start_offset",
      "video_file_chunk",
      "upload_session_id",
      "content_category",
      "embeddable",
      "slideshow_spec",
      "name",
      "chunk_session_id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/advideos", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateAdVideo addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateAdVideo setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateAdVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }


    public APIRequestCreateAdVideo setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateAdVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }


    public APIRequestCreateAdVideo setThumb (File thumb) {
      this.setParam("thumb", thumb);
      return this;
    }

    public APIRequestCreateAdVideo setThumb (String thumb) {
      this.setParam("thumb", thumb);
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

    public APIRequestCreateAdVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateAdVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
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

    public APIRequestCreateAdVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }


    public APIRequestCreateAdVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }


    public APIRequestCreateAdVideo setContentCategory (EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateAdVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateAdVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateAdVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateAdVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }


    public APIRequestCreateAdVideo setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateAdVideo setChunkSessionId (String chunkSessionId) {
      this.setParam("chunk_session_id", chunkSessionId);
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

    public APIRequestCreateAdVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "id",
      "ad_specs",
      "name",
      "notification_uri",
      "notification_mode",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAsyncAdRequestSet(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequestsets", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAsyncAdRequestSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAsyncAdRequestSet setId (String id) {
      this.setParam("id", id);
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


    public APIRequestCreateAsyncAdRequestSet setNotificationUri (String notificationUri) {
      this.setParam("notification_uri", notificationUri);
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

    public APIRequestCreateAsyncAdRequestSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAsyncAdRequestSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAsyncAdRequestSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAsyncAdRequestSet requestField (String field, boolean value) {
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
      "creation_params",
      "description",
      "id",
      "name",
      "opt_out_link",
      "subtype",
      "lookalike_spec",
      "retention_days",
      "rule",
      "prefill",
      "pixel_id",
      "inclusions",
      "exclusions",
      "origin_audience_id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateCustomAudience(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiences", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateCustomAudience setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateCustomAudience setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCustomAudience setCreationParams (Map<String, String> creationParams) {
      this.setParam("creation_params", creationParams);
      return this;
    }

    public APIRequestCreateCustomAudience setCreationParams (String creationParams) {
      this.setParam("creation_params", creationParams);
      return this;
    }

    public APIRequestCreateCustomAudience setDescription (String description) {
      this.setParam("description", description);
      return this;
    }


    public APIRequestCreateCustomAudience setId (String id) {
      this.setParam("id", id);
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


    public APIRequestCreateCustomAudience setSubtype (EnumCustomAudienceSubtype subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateCustomAudience setSubtype (String subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateCustomAudience setLookalikeSpec (String lookalikeSpec) {
      this.setParam("lookalike_spec", lookalikeSpec);
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


    public APIRequestCreateCustomAudience setPrefill (Boolean prefill) {
      this.setParam("prefill", prefill);
      return this;
    }

    public APIRequestCreateCustomAudience setPrefill (String prefill) {
      this.setParam("prefill", prefill);
      return this;
    }

    public APIRequestCreateCustomAudience setPixelId (Long pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }

    public APIRequestCreateCustomAudience setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }

    public APIRequestCreateCustomAudience setInclusions (List<Object> inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestCreateCustomAudience setInclusions (String inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestCreateCustomAudience setExclusions (List<Object> exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestCreateCustomAudience setExclusions (String exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestCreateCustomAudience setOriginAudienceId (String originAudienceId) {
      this.setParam("origin_audience_id", originAudienceId);
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

    public APIRequestCreateCustomAudience requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateCustomAudience requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCustomAudience requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateCustomAudience requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "target_spec",
      "start_time",
      "stop_time",
      "end_time",
      "reach",
      "frequency_cap",
      "budget",
      "prediction_mode",
      "destination_id",
      "destination_ids",
      "story_event_type",
      "objective",
      "rf_prediction_id_to_share",
      "num_curve_points",
      "interval_frequency_cap_reset_period",
      "campaign_group_id",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateReachFrequencyPrediction(String nodeId, APIContext context) {
      super(context, nodeId, "/reachfrequencypredictions", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateReachFrequencyPrediction setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestCreateReachFrequencyPrediction setEndTime (Long endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setEndTime (String endTime) {
      this.setParam("end_time", endTime);
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

    public APIRequestCreateReachFrequencyPrediction setFrequencyCap (Long frequencyCap) {
      this.setParam("frequency_cap", frequencyCap);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setFrequencyCap (String frequencyCap) {
      this.setParam("frequency_cap", frequencyCap);
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

    public APIRequestCreateReachFrequencyPrediction setPredictionMode (Long predictionMode) {
      this.setParam("prediction_mode", predictionMode);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setPredictionMode (String predictionMode) {
      this.setParam("prediction_mode", predictionMode);
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

    public APIRequestCreateReachFrequencyPrediction setStoryEventType (Long storyEventType) {
      this.setParam("story_event_type", storyEventType);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setStoryEventType (String storyEventType) {
      this.setParam("story_event_type", storyEventType);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setObjective (EnumReachFrequencyPredictionObjective objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setObjective (String objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setRfPredictionIdToShare (String rfPredictionIdToShare) {
      this.setParam("rf_prediction_id_to_share", rfPredictionIdToShare);
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

    public APIRequestCreateReachFrequencyPrediction setIntervalFrequencyCapResetPeriod (Long intervalFrequencyCapResetPeriod) {
      this.setParam("interval_frequency_cap_reset_period", intervalFrequencyCapResetPeriod);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setIntervalFrequencyCapResetPeriod (String intervalFrequencyCapResetPeriod) {
      this.setParam("interval_frequency_cap_reset_period", intervalFrequencyCapResetPeriod);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction setCampaignGroupId (String campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
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

    public APIRequestCreateReachFrequencyPrediction requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateReachFrequencyPrediction requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateReachFrequencyPrediction requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateOffsitePixel extends APIRequest<OffsitePixel> {

    OffsitePixel lastResponse = null;
    @Override
    public OffsitePixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "name",
      "tag",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OffsitePixel parseResponse(String response) throws APIException {
      return OffsitePixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OffsitePixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OffsitePixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateOffsitePixel(String nodeId, APIContext context) {
      super(context, nodeId, "/offsitepixels", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateOffsitePixel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateOffsitePixel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOffsitePixel setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateOffsitePixel setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateOffsitePixel setTag (EnumTag tag) {
      this.setParam("tag", tag);
      return this;
    }

    public APIRequestCreateOffsitePixel setTag (String tag) {
      this.setParam("tag", tag);
      return this;
    }

    public APIRequestCreateOffsitePixel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOffsitePixel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateOffsitePixel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateOffsitePixel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateOffsitePixel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateOffsitePixel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteAdImages extends APIRequest<AdImage> {

    APINodeList<AdImage> lastResponse = null;
    @Override
    public APINodeList<AdImage> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hash",
    };

    public static final String[] FIELDS = {
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteAdImages(String nodeId, APIContext context) {
      super(context, nodeId, "/adimages", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteAdImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestDeleteAdImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteAdImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestDeleteAdImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteCampaigns extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "delete_strategy",
      "object_count",
      "before_date",
    };

    public static final String[] FIELDS = {
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteCampaigns setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteCampaigns setDeleteStrategy (EnumDeleteStrategy deleteStrategy) {
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

    public APIRequestDeleteCampaigns setBeforeDate (String beforeDate) {
      this.setParam("before_date", beforeDate);
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

    public APIRequestDeleteCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestDeleteCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateCustomConversion extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "description",
      "pixel_id",
      "pixel_rule",
      "default_conversion_value",
      "id",
      "custom_event_type",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateCustomConversion(String nodeId, APIContext context) {
      super(context, nodeId, "/customconversions", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateCustomConversion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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


    public APIRequestCreateCustomConversion setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }


    public APIRequestCreateCustomConversion setPixelRule (String pixelRule) {
      this.setParam("pixel_rule", pixelRule);
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

    public APIRequestCreateCustomConversion setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateCustomConversion setCustomEventType (EnumCustomEventType customEventType) {
      this.setParam("custom_event_type", customEventType);
      return this;
    }

    public APIRequestCreateCustomConversion setCustomEventType (String customEventType) {
      this.setParam("custom_event_type", customEventType);
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

    public APIRequestCreateCustomConversion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateCustomConversion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCustomConversion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateCustomConversion requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateOfflineConversion extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "pixel_id",
      "event",
      "payload",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateOfflineConversion(String nodeId, APIContext context) {
      super(context, nodeId, "/offlineconversions", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateOfflineConversion setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateOfflineConversion setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOfflineConversion setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateOfflineConversion setPixelId (String pixelId) {
      this.setParam("pixel_id", pixelId);
      return this;
    }


    public APIRequestCreateOfflineConversion setEvent (String event) {
      this.setParam("event", event);
      return this;
    }


    public APIRequestCreateOfflineConversion setPayload (List<Object> payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateOfflineConversion setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateOfflineConversion requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOfflineConversion requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateOfflineConversion requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateOfflineConversion requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateOfflineConversion requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateOfflineConversion requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateProductAudience extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_params",
      "description",
      "id",
      "name",
      "opt_out_link",
      "subtype",
      "product_set_id",
      "inclusions",
      "exclusions",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateProductAudience(String nodeId, APIContext context) {
      super(context, nodeId, "/product_audiences", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateProductAudience setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateProductAudience setParams(Map<String, Object> params) {
      setParamsInternal(params);
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


    public APIRequestCreateProductAudience setId (String id) {
      this.setParam("id", id);
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


    public APIRequestCreateProductAudience setSubtype (EnumProductAudienceSubtype subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateProductAudience setSubtype (String subtype) {
      this.setParam("subtype", subtype);
      return this;
    }

    public APIRequestCreateProductAudience setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
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

    public APIRequestCreateProductAudience setExclusions (List<Object> exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestCreateProductAudience setExclusions (String exclusions) {
      this.setParam("exclusions", exclusions);
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

    public APIRequestCreateProductAudience requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateProductAudience requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductAudience requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateProductAudience requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumCurrency {
    @SerializedName("USD")
    VALUE_USD("USD"),
    @SerializedName("CAD")
    VALUE_CAD("CAD"),
    @SerializedName("EUR")
    VALUE_EUR("EUR"),
    @SerializedName("GBP")
    VALUE_GBP("GBP"),
    @SerializedName("AUD")
    VALUE_AUD("AUD"),
    @SerializedName("JPY")
    VALUE_JPY("JPY"),
    @SerializedName("TRY")
    VALUE_TRY("TRY"),
    @SerializedName("VEF")
    VALUE_VEF("VEF"),
    @SerializedName("COP")
    VALUE_COP("COP"),
    @SerializedName("NOK")
    VALUE_NOK("NOK"),
    @SerializedName("SEK")
    VALUE_SEK("SEK"),
    @SerializedName("DKK")
    VALUE_DKK("DKK"),
    @SerializedName("CLP")
    VALUE_CLP("CLP"),
    @SerializedName("HKD")
    VALUE_HKD("HKD"),
    @SerializedName("CHF")
    VALUE_CHF("CHF"),
    @SerializedName("NZD")
    VALUE_NZD("NZD"),
    @SerializedName("MXN")
    VALUE_MXN("MXN"),
    @SerializedName("ZAR")
    VALUE_ZAR("ZAR"),
    @SerializedName("ILS")
    VALUE_ILS("ILS"),
    @SerializedName("ARS")
    VALUE_ARS("ARS"),
    @SerializedName("BOB")
    VALUE_BOB("BOB"),
    @SerializedName("BRL")
    VALUE_BRL("BRL"),
    @SerializedName("CNY")
    VALUE_CNY("CNY"),
    @SerializedName("CRC")
    VALUE_CRC("CRC"),
    @SerializedName("CZK")
    VALUE_CZK("CZK"),
    @SerializedName("GTQ")
    VALUE_GTQ("GTQ"),
    @SerializedName("HNL")
    VALUE_HNL("HNL"),
    @SerializedName("HUF")
    VALUE_HUF("HUF"),
    @SerializedName("ISK")
    VALUE_ISK("ISK"),
    @SerializedName("INR")
    VALUE_INR("INR"),
    @SerializedName("MOP")
    VALUE_MOP("MOP"),
    @SerializedName("MYR")
    VALUE_MYR("MYR"),
    @SerializedName("NIO")
    VALUE_NIO("NIO"),
    @SerializedName("PYG")
    VALUE_PYG("PYG"),
    @SerializedName("PEN")
    VALUE_PEN("PEN"),
    @SerializedName("PLN")
    VALUE_PLN("PLN"),
    @SerializedName("PHP")
    VALUE_PHP("PHP"),
    @SerializedName("QAR")
    VALUE_QAR("QAR"),
    @SerializedName("RON")
    VALUE_RON("RON"),
    @SerializedName("RUB")
    VALUE_RUB("RUB"),
    @SerializedName("SAR")
    VALUE_SAR("SAR"),
    @SerializedName("SGD")
    VALUE_SGD("SGD"),
    @SerializedName("KRW")
    VALUE_KRW("KRW"),
    @SerializedName("TWD")
    VALUE_TWD("TWD"),
    @SerializedName("THB")
    VALUE_THB("THB"),
    @SerializedName("AED")
    VALUE_AED("AED"),
    @SerializedName("UYU")
    VALUE_UYU("UYU"),
    @SerializedName("VND")
    VALUE_VND("VND"),
    @SerializedName("IDR")
    VALUE_IDR("IDR"),
    NULL(null);

    private String value;

    private EnumCurrency(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCategory {
    @SerializedName("ACCOUNT")
    VALUE_ACCOUNT("ACCOUNT"),
    @SerializedName("AD")
    VALUE_AD("AD"),
    @SerializedName("AD_SET")
    VALUE_AD_SET("AD_SET"),
    @SerializedName("AUDIENCE")
    VALUE_AUDIENCE("AUDIENCE"),
    @SerializedName("BID")
    VALUE_BID("BID"),
    @SerializedName("BUDGET")
    VALUE_BUDGET("BUDGET"),
    @SerializedName("CAMPAIGN")
    VALUE_CAMPAIGN("CAMPAIGN"),
    @SerializedName("DATE")
    VALUE_DATE("DATE"),
    @SerializedName("STATUS")
    VALUE_STATUS("STATUS"),
    @SerializedName("TARGETING")
    VALUE_TARGETING("TARGETING"),
    NULL(null);

    private String value;

    private EnumCategory(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdCreativeOperator {
    @SerializedName("ALL")
    VALUE_ALL("ALL"),
    @SerializedName("ANY")
    VALUE_ANY("ANY"),
    NULL(null);

    private String value;

    private EnumAdCreativeOperator(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdDatePreset {
    @SerializedName("today")
    VALUE_TODAY("today"),
    @SerializedName("yesterday")
    VALUE_YESTERDAY("yesterday"),
    @SerializedName("last_3_days")
    VALUE_LAST_3_DAYS("last_3_days"),
    @SerializedName("this_week")
    VALUE_THIS_WEEK("this_week"),
    @SerializedName("last_week")
    VALUE_LAST_WEEK("last_week"),
    @SerializedName("last_7_days")
    VALUE_LAST_7_DAYS("last_7_days"),
    @SerializedName("last_14_days")
    VALUE_LAST_14_DAYS("last_14_days"),
    @SerializedName("last_28_days")
    VALUE_LAST_28_DAYS("last_28_days"),
    @SerializedName("last_30_days")
    VALUE_LAST_30_DAYS("last_30_days"),
    @SerializedName("last_90_days")
    VALUE_LAST_90_DAYS("last_90_days"),
    @SerializedName("this_month")
    VALUE_THIS_MONTH("this_month"),
    @SerializedName("last_month")
    VALUE_LAST_MONTH("last_month"),
    @SerializedName("this_quarter")
    VALUE_THIS_QUARTER("this_quarter"),
    @SerializedName("last_3_months")
    VALUE_LAST_3_MONTHS("last_3_months"),
    @SerializedName("lifetime")
    VALUE_LIFETIME("lifetime"),
    NULL(null);

    private String value;

    private EnumAdDatePreset(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetEffectiveStatus {
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
    @SerializedName("11")
    VALUE_11("11"),
    @SerializedName("12")
    VALUE_12("12"),
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    @SerializedName("PENDING_REVIEW")
    VALUE_PENDING_REVIEW("PENDING_REVIEW"),
    @SerializedName("DISAPPROVED")
    VALUE_DISAPPROVED("DISAPPROVED"),
    @SerializedName("PREAPPROVED")
    VALUE_PREAPPROVED("PREAPPROVED"),
    @SerializedName("PENDING_BILLING_INFO")
    VALUE_PENDING_BILLING_INFO("PENDING_BILLING_INFO"),
    @SerializedName("CAMPAIGN_PAUSED")
    VALUE_CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("ADSET_PAUSED")
    VALUE_ADSET_PAUSED("ADSET_PAUSED"),
    NULL(null);

    private String value;

    private EnumAdSetEffectiveStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetDatePreset {
    @SerializedName("today")
    VALUE_TODAY("today"),
    @SerializedName("yesterday")
    VALUE_YESTERDAY("yesterday"),
    @SerializedName("last_3_days")
    VALUE_LAST_3_DAYS("last_3_days"),
    @SerializedName("this_week")
    VALUE_THIS_WEEK("this_week"),
    @SerializedName("last_week")
    VALUE_LAST_WEEK("last_week"),
    @SerializedName("last_7_days")
    VALUE_LAST_7_DAYS("last_7_days"),
    @SerializedName("last_14_days")
    VALUE_LAST_14_DAYS("last_14_days"),
    @SerializedName("last_28_days")
    VALUE_LAST_28_DAYS("last_28_days"),
    @SerializedName("last_30_days")
    VALUE_LAST_30_DAYS("last_30_days"),
    @SerializedName("last_90_days")
    VALUE_LAST_90_DAYS("last_90_days"),
    @SerializedName("this_month")
    VALUE_THIS_MONTH("this_month"),
    @SerializedName("last_month")
    VALUE_LAST_MONTH("last_month"),
    @SerializedName("this_quarter")
    VALUE_THIS_QUARTER("this_quarter"),
    @SerializedName("last_3_months")
    VALUE_LAST_3_MONTHS("last_3_months"),
    @SerializedName("lifetime")
    VALUE_LIFETIME("lifetime"),
    NULL(null);

    private String value;

    private EnumAdSetDatePreset(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdOperator {
    @SerializedName("ALL")
    VALUE_ALL("ALL"),
    @SerializedName("ANY")
    VALUE_ANY("ANY"),
    NULL(null);

    private String value;

    private EnumAdOperator(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetOperator {
    @SerializedName("ALL")
    VALUE_ALL("ALL"),
    @SerializedName("ANY")
    VALUE_ANY("ANY"),
    NULL(null);

    private String value;

    private EnumAdSetOperator(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignEffectiveStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    @SerializedName("PENDING_REVIEW")
    VALUE_PENDING_REVIEW("PENDING_REVIEW"),
    @SerializedName("DISAPPROVED")
    VALUE_DISAPPROVED("DISAPPROVED"),
    @SerializedName("PREAPPROVED")
    VALUE_PREAPPROVED("PREAPPROVED"),
    @SerializedName("PENDING_BILLING_INFO")
    VALUE_PENDING_BILLING_INFO("PENDING_BILLING_INFO"),
    @SerializedName("CAMPAIGN_PAUSED")
    VALUE_CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("ADSET_PAUSED")
    VALUE_ADSET_PAUSED("ADSET_PAUSED"),
    NULL(null);

    private String value;

    private EnumCampaignEffectiveStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignDatePreset {
    @SerializedName("today")
    VALUE_TODAY("today"),
    @SerializedName("yesterday")
    VALUE_YESTERDAY("yesterday"),
    @SerializedName("last_3_days")
    VALUE_LAST_3_DAYS("last_3_days"),
    @SerializedName("this_week")
    VALUE_THIS_WEEK("this_week"),
    @SerializedName("last_week")
    VALUE_LAST_WEEK("last_week"),
    @SerializedName("last_7_days")
    VALUE_LAST_7_DAYS("last_7_days"),
    @SerializedName("last_14_days")
    VALUE_LAST_14_DAYS("last_14_days"),
    @SerializedName("last_28_days")
    VALUE_LAST_28_DAYS("last_28_days"),
    @SerializedName("last_30_days")
    VALUE_LAST_30_DAYS("last_30_days"),
    @SerializedName("last_90_days")
    VALUE_LAST_90_DAYS("last_90_days"),
    @SerializedName("this_month")
    VALUE_THIS_MONTH("this_month"),
    @SerializedName("last_month")
    VALUE_LAST_MONTH("last_month"),
    @SerializedName("this_quarter")
    VALUE_THIS_QUARTER("this_quarter"),
    @SerializedName("last_3_months")
    VALUE_LAST_3_MONTHS("last_3_months"),
    @SerializedName("lifetime")
    VALUE_LIFETIME("lifetime"),
    NULL(null);

    private String value;

    private EnumCampaignDatePreset(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignOperator {
    @SerializedName("ALL")
    VALUE_ALL("ALL"),
    @SerializedName("ANY")
    VALUE_ANY("ANY"),
    NULL(null);

    private String value;

    private EnumCampaignOperator(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdFormat {
    @SerializedName("RIGHT_COLUMN_STANDARD")
    VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
    @SerializedName("DESKTOP_FEED_STANDARD")
    VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_STANDARD")
    VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_BASIC")
    VALUE_MOBILE_FEED_BASIC("MOBILE_FEED_BASIC"),
    @SerializedName("MOBILE_INTERSTITIAL")
    VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
    @SerializedName("MOBILE_BANNER")
    VALUE_MOBILE_BANNER("MOBILE_BANNER"),
    @SerializedName("MOBILE_NATIVE")
    VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
    @SerializedName("INSTAGRAM_STANDARD")
    VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
    @SerializedName("LIVERAIL_VIDEO")
    VALUE_LIVERAIL_VIDEO("LIVERAIL_VIDEO"),
    NULL(null);

    private String value;

    private EnumAdFormat(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCustomAudienceFields {
    @SerializedName("id")
    VALUE_ID("id"),
    @SerializedName("account_id")
    VALUE_ACCOUNT_ID("account_id"),
    @SerializedName("approximate_count")
    VALUE_APPROXIMATE_COUNT("approximate_count"),
    @SerializedName("data_source")
    VALUE_DATA_SOURCE("data_source"),
    @SerializedName("delivery_status")
    VALUE_DELIVERY_STATUS("delivery_status"),
    @SerializedName("description")
    VALUE_DESCRIPTION("description"),
    @SerializedName("excluded_custom_audiences")
    VALUE_EXCLUDED_CUSTOM_AUDIENCES("excluded_custom_audiences"),
    @SerializedName("included_custom_audiences")
    VALUE_INCLUDED_CUSTOM_AUDIENCES("included_custom_audiences"),
    @SerializedName("external_event_source")
    VALUE_EXTERNAL_EVENT_SOURCE("external_event_source"),
    @SerializedName("lookalike_audience_ids")
    VALUE_LOOKALIKE_AUDIENCE_IDS("lookalike_audience_ids"),
    @SerializedName("lookalike_spec")
    VALUE_LOOKALIKE_SPEC("lookalike_spec"),
    @SerializedName("name")
    VALUE_NAME("name"),
    @SerializedName("operation_status")
    VALUE_OPERATION_STATUS("operation_status"),
    @SerializedName("opt_out_link")
    VALUE_OPT_OUT_LINK("opt_out_link"),
    @SerializedName("permission_for_actions")
    VALUE_PERMISSION_FOR_ACTIONS("permission_for_actions"),
    @SerializedName("pixel_id")
    VALUE_PIXEL_ID("pixel_id"),
    @SerializedName("rule")
    VALUE_RULE("rule"),
    @SerializedName("retention_days")
    VALUE_RETENTION_DAYS("retention_days"),
    @SerializedName("subtype")
    VALUE_SUBTYPE("subtype"),
    @SerializedName("time_created")
    VALUE_TIME_CREATED("time_created"),
    @SerializedName("time_updated")
    VALUE_TIME_UPDATED("time_updated"),
    @SerializedName("time_content_updated")
    VALUE_TIME_CONTENT_UPDATED("time_content_updated"),
    NULL(null);

    private String value;

    private EnumCustomAudienceFields(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumOptimizeFor {
    @SerializedName("NONE")
    VALUE_NONE("NONE"),
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("BRAND_AWARENESS")
    VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("ENGAGED_USERS")
    VALUE_ENGAGED_USERS("ENGAGED_USERS"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("OFFSITE_CONVERSIONS")
    VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
    @SerializedName("PAGE_ENGAGEMENT")
    VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("REACH")
    VALUE_REACH("REACH"),
    @SerializedName("SOCIAL_IMPRESSIONS")
    VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumOptimizeFor(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdAccountRoasFields {
    @SerializedName("date_start")
    VALUE_DATE_START("date_start"),
    @SerializedName("date_stop")
    VALUE_DATE_STOP("date_stop"),
    @SerializedName("revenue")
    VALUE_REVENUE("revenue"),
    @SerializedName("installs")
    VALUE_INSTALLS("installs"),
    @SerializedName("spend")
    VALUE_SPEND("spend"),
    @SerializedName("adgroup_id")
    VALUE_ADGROUP_ID("adgroup_id"),
    @SerializedName("campaign_id")
    VALUE_CAMPAIGN_ID("campaign_id"),
    @SerializedName("campaign_group_id")
    VALUE_CAMPAIGN_GROUP_ID("campaign_group_id"),
    @SerializedName("yield_1d")
    VALUE_YIELD_1D("yield_1d"),
    @SerializedName("yield_3d")
    VALUE_YIELD_3D("yield_3d"),
    @SerializedName("yield_7d")
    VALUE_YIELD_7D("yield_7d"),
    @SerializedName("yield_30d")
    VALUE_YIELD_30D("yield_30d"),
    @SerializedName("yield_90d")
    VALUE_YIELD_90D("yield_90d"),
    @SerializedName("yield_180d")
    VALUE_YIELD_180D("yield_180d"),
    @SerializedName("yield_365d")
    VALUE_YIELD_365D("yield_365d"),
    @SerializedName("arpu_1d")
    VALUE_ARPU_1D("arpu_1d"),
    @SerializedName("arpu_3d")
    VALUE_ARPU_3D("arpu_3d"),
    @SerializedName("arpu_7d")
    VALUE_ARPU_7D("arpu_7d"),
    @SerializedName("arpu_30d")
    VALUE_ARPU_30D("arpu_30d"),
    @SerializedName("arpu_90d")
    VALUE_ARPU_90D("arpu_90d"),
    @SerializedName("arpu_180d")
    VALUE_ARPU_180D("arpu_180d"),
    @SerializedName("arpu_365d")
    VALUE_ARPU_365D("arpu_365d"),
    @SerializedName("revenue_1d")
    VALUE_REVENUE_1D("revenue_1d"),
    @SerializedName("revenue_3d")
    VALUE_REVENUE_3D("revenue_3d"),
    @SerializedName("revenue_7d")
    VALUE_REVENUE_7D("revenue_7d"),
    @SerializedName("revenue_30d")
    VALUE_REVENUE_30D("revenue_30d"),
    @SerializedName("revenue_90d")
    VALUE_REVENUE_90D("revenue_90d"),
    @SerializedName("revenue_180d")
    VALUE_REVENUE_180D("revenue_180d"),
    @SerializedName("revenue_365d")
    VALUE_REVENUE_365D("revenue_365d"),
    NULL(null);

    private String value;

    private EnumAdAccountRoasFields(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCollationInterval {
    @SerializedName("DAY")
    VALUE_DAY("DAY"),
    NULL(null);

    private String value;

    private EnumCollationInterval(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumApplinkTreatment {
    @SerializedName("deeplink_with_web_fallback")
    VALUE_DEEPLINK_WITH_WEB_FALLBACK("deeplink_with_web_fallback"),
    @SerializedName("deeplink_with_appstore_fallback")
    VALUE_DEEPLINK_WITH_APPSTORE_FALLBACK("deeplink_with_appstore_fallback"),
    @SerializedName("web_only")
    VALUE_WEB_ONLY("web_only"),
    NULL(null);

    private String value;

    private EnumApplinkTreatment(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumDynamicAdVoice {
    @SerializedName("DYNAMIC")
    VALUE_DYNAMIC("DYNAMIC"),
    @SerializedName("STORY_OWNER")
    VALUE_STORY_OWNER("STORY_OWNER"),
    NULL(null);

    private String value;

    private EnumDynamicAdVoice(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    NULL(null);

    private String value;

    private EnumAdStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumAdExecutionOptions(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumBillingEvent {
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumBillingEvent(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    NULL(null);

    private String value;

    private EnumAdSetStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumAdSetExecutionOptions(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumOptimizationGoal {
    @SerializedName("NONE")
    VALUE_NONE("NONE"),
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("BRAND_AWARENESS")
    VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("ENGAGED_USERS")
    VALUE_ENGAGED_USERS("ENGAGED_USERS"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("OFFSITE_CONVERSIONS")
    VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
    @SerializedName("PAGE_ENGAGEMENT")
    VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("REACH")
    VALUE_REACH("REACH"),
    @SerializedName("SOCIAL_IMPRESSIONS")
    VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumOptimizationGoal(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductAdBehavior {
    @SerializedName("REQUIRE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_LAST_SEEN_PRODUCTS("REQUIRE_LAST_SEEN_PRODUCTS"),
    @SerializedName("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS"),
    @SerializedName("FALL_BACK_TO_FB_RECOMMENDATIONS")
    VALUE_FALL_BACK_TO_FB_RECOMMENDATIONS("FALL_BACK_TO_FB_RECOMMENDATIONS"),
    NULL(null);

    private String value;

    private EnumProductAdBehavior(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignObjective {
    @SerializedName("CANVAS_APP_ENGAGEMENT")
    VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
    @SerializedName("CANVAS_APP_INSTALLS")
    VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
    @SerializedName("CONVERSIONS")
    VALUE_CONVERSIONS("CONVERSIONS"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("LOCAL_AWARENESS")
    VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
    @SerializedName("MOBILE_APP_ENGAGEMENT")
    VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
    @SerializedName("MOBILE_APP_INSTALLS")
    VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("PRODUCT_CATALOG_SALES")
    VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumCampaignObjective(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    NULL(null);

    private String value;

    private EnumCampaignStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCampaignExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumCampaignExecutionOptions(String value) {
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
    NULL(null);

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
    NULL(null);

    private String value;

    private EnumUploadPhase(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumContentCategory {
    @SerializedName("BEAUTY_FASHION")
    VALUE_BEAUTY_FASHION("BEAUTY_FASHION"),
    @SerializedName("BUSINESS")
    VALUE_BUSINESS("BUSINESS"),
    @SerializedName("CARS_TRUCKS")
    VALUE_CARS_TRUCKS("CARS_TRUCKS"),
    @SerializedName("COMEDY")
    VALUE_COMEDY("COMEDY"),
    @SerializedName("CUTE_ANIMALS")
    VALUE_CUTE_ANIMALS("CUTE_ANIMALS"),
    @SerializedName("ENTERTAINMENT")
    VALUE_ENTERTAINMENT("ENTERTAINMENT"),
    @SerializedName("FAMILY")
    VALUE_FAMILY("FAMILY"),
    @SerializedName("FOOD_HEALTH")
    VALUE_FOOD_HEALTH("FOOD_HEALTH"),
    @SerializedName("HOME")
    VALUE_HOME("HOME"),
    @SerializedName("LIFESTYLE")
    VALUE_LIFESTYLE("LIFESTYLE"),
    @SerializedName("MUSIC")
    VALUE_MUSIC("MUSIC"),
    @SerializedName("NEWS")
    VALUE_NEWS("NEWS"),
    @SerializedName("POLITICS")
    VALUE_POLITICS("POLITICS"),
    @SerializedName("SCIENCE")
    VALUE_SCIENCE("SCIENCE"),
    @SerializedName("SPORTS")
    VALUE_SPORTS("SPORTS"),
    @SerializedName("TECHNOLOGY")
    VALUE_TECHNOLOGY("TECHNOLOGY"),
    @SerializedName("VIDEO_GAMING")
    VALUE_VIDEO_GAMING("VIDEO_GAMING"),
    @SerializedName("OTHER")
    VALUE_OTHER("OTHER"),
    NULL(null);

    private String value;

    private EnumContentCategory(String value) {
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
    NULL(null);

    private String value;

    private EnumNotificationMode(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCustomAudienceSubtype {
    @SerializedName("CUSTOM")
    VALUE_CUSTOM("CUSTOM"),
    @SerializedName("WEBSITE")
    VALUE_WEBSITE("WEBSITE"),
    @SerializedName("APP")
    VALUE_APP("APP"),
    @SerializedName("CLAIM")
    VALUE_CLAIM("CLAIM"),
    @SerializedName("PARTNER")
    VALUE_PARTNER("PARTNER"),
    @SerializedName("MANAGED")
    VALUE_MANAGED("MANAGED"),
    @SerializedName("COMBINATION")
    VALUE_COMBINATION("COMBINATION"),
    @SerializedName("VIDEO")
    VALUE_VIDEO("VIDEO"),
    @SerializedName("LOOKALIKE")
    VALUE_LOOKALIKE("LOOKALIKE"),
    @SerializedName("ENGAGEMENT")
    VALUE_ENGAGEMENT("ENGAGEMENT"),
    NULL(null);

    private String value;

    private EnumCustomAudienceSubtype(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumReachFrequencyPredictionObjective {
    @SerializedName("NONE")
    VALUE_NONE("NONE"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("CANVAS_APP_INSTALLS")
    VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("CANVAS_APP_ENGAGEMENT")
    VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("WEBSITE_CONVERSIONS")
    VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
    @SerializedName("MOBILE_APP_INSTALLS")
    VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
    @SerializedName("WEBSITE_CLICKS")
    VALUE_WEBSITE_CLICKS("WEBSITE_CLICKS"),
    @SerializedName("MOBILE_APP_ENGAGEMENT")
    VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    @SerializedName("LOCAL_AWARENESS")
    VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
    @SerializedName("PRODUCT_CATALOG_SALES")
    VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    NULL(null);

    private String value;

    private EnumReachFrequencyPredictionObjective(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumTag {
    @SerializedName("CHECKOUT")
    VALUE_CHECKOUT("CHECKOUT"),
    @SerializedName("REGISTRATION")
    VALUE_REGISTRATION("REGISTRATION"),
    @SerializedName("LEAD")
    VALUE_LEAD("LEAD"),
    @SerializedName("KEY_PAGE_VIEW")
    VALUE_KEY_PAGE_VIEW("KEY_PAGE_VIEW"),
    @SerializedName("ADD_TO_CART")
    VALUE_ADD_TO_CART("ADD_TO_CART"),
    @SerializedName("OTHER")
    VALUE_OTHER("OTHER"),
    NULL(null);

    private String value;

    private EnumTag(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumDeleteStrategy {
    @SerializedName("DELETE_ANY")
    VALUE_DELETE_ANY("DELETE_ANY"),
    @SerializedName("DELETE_OLDEST")
    VALUE_DELETE_OLDEST("DELETE_OLDEST"),
    @SerializedName("DELETE_ARCHIVED_BEFORE")
    VALUE_DELETE_ARCHIVED_BEFORE("DELETE_ARCHIVED_BEFORE"),
    NULL(null);

    private String value;

    private EnumDeleteStrategy(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCustomEventType {
    @SerializedName("ADD_PAYMENT_INFO")
    VALUE_ADD_PAYMENT_INFO("ADD_PAYMENT_INFO"),
    @SerializedName("ADD_TO_CART")
    VALUE_ADD_TO_CART("ADD_TO_CART"),
    @SerializedName("ADD_TO_WISHLIST")
    VALUE_ADD_TO_WISHLIST("ADD_TO_WISHLIST"),
    @SerializedName("COMPLETE_REGISTRATION")
    VALUE_COMPLETE_REGISTRATION("COMPLETE_REGISTRATION"),
    @SerializedName("CONTENT_VIEW")
    VALUE_CONTENT_VIEW("CONTENT_VIEW"),
    @SerializedName("INITIATED_CHECKOUT")
    VALUE_INITIATED_CHECKOUT("INITIATED_CHECKOUT"),
    @SerializedName("LEAD")
    VALUE_LEAD("LEAD"),
    @SerializedName("OTHER")
    VALUE_OTHER("OTHER"),
    @SerializedName("PURCHASE")
    VALUE_PURCHASE("PURCHASE"),
    @SerializedName("SEARCH")
    VALUE_SEARCH("SEARCH"),
    NULL(null);

    private String value;

    private EnumCustomEventType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductAudienceSubtype {
    @SerializedName("CUSTOM")
    VALUE_CUSTOM("CUSTOM"),
    @SerializedName("WEBSITE")
    VALUE_WEBSITE("WEBSITE"),
    @SerializedName("APP")
    VALUE_APP("APP"),
    @SerializedName("CLAIM")
    VALUE_CLAIM("CLAIM"),
    @SerializedName("PARTNER")
    VALUE_PARTNER("PARTNER"),
    @SerializedName("MANAGED")
    VALUE_MANAGED("MANAGED"),
    @SerializedName("COMBINATION")
    VALUE_COMBINATION("COMBINATION"),
    @SerializedName("VIDEO")
    VALUE_VIDEO("VIDEO"),
    @SerializedName("LOOKALIKE")
    VALUE_LOOKALIKE("LOOKALIKE"),
    @SerializedName("ENGAGEMENT")
    VALUE_ENGAGEMENT("ENGAGEMENT"),
    NULL(null);

    private String value;

    private EnumProductAudienceSubtype(String value) {
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

  public AdAccount copyFrom(AdAccount instance) {
    this.mId = instance.mId;
    this.mAccountGroups = instance.mAccountGroups;
    this.mAccountId = instance.mAccountId;
    this.mAccountStatus = instance.mAccountStatus;
    this.mAge = instance.mAge;
    this.mAgencyClientDeclaration = instance.mAgencyClientDeclaration;
    this.mBusinessCity = instance.mBusinessCity;
    this.mBusinessCountryCode = instance.mBusinessCountryCode;
    this.mBusinessName = instance.mBusinessName;
    this.mBusinessState = instance.mBusinessState;
    this.mBusinessStreet = instance.mBusinessStreet;
    this.mBusinessStreet2 = instance.mBusinessStreet2;
    this.mBusinessZip = instance.mBusinessZip;
    this.mCapabilities = instance.mCapabilities;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCurrency = instance.mCurrency;
    this.mDisableReason = instance.mDisableReason;
    this.mEndAdvertiser = instance.mEndAdvertiser;
    this.mEndAdvertiserName = instance.mEndAdvertiserName;
    this.mFailedDeliveryChecks = instance.mFailedDeliveryChecks;
    this.mFundingSource = instance.mFundingSource;
    this.mFundingSourceDetails = instance.mFundingSourceDetails;
    this.mHasMigratedPermissions = instance.mHasMigratedPermissions;
    this.mIoNumber = instance.mIoNumber;
    this.mIsNotificationsEnabled = instance.mIsNotificationsEnabled;
    this.mIsPersonal = instance.mIsPersonal;
    this.mIsPrepayAccount = instance.mIsPrepayAccount;
    this.mIsTaxIdRequired = instance.mIsTaxIdRequired;
    this.mLineNumbers = instance.mLineNumbers;
    this.mMediaAgency = instance.mMediaAgency;
    this.mMinCampaignGroupSpendCap = instance.mMinCampaignGroupSpendCap;
    this.mMinDailyBudget = instance.mMinDailyBudget;
    this.mName = instance.mName;
    this.mOwner = instance.mOwner;
    this.mOffsitePixelsTosAccepted = instance.mOffsitePixelsTosAccepted;
    this.mPartner = instance.mPartner;
    this.mTaxId = instance.mTaxId;
    this.mTaxIdStatus = instance.mTaxIdStatus;
    this.mTaxIdType = instance.mTaxIdType;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTimezoneName = instance.mTimezoneName;
    this.mTimezoneOffsetHoursUtc = instance.mTimezoneOffsetHoursUtc;
    this.mRfSpec = instance.mRfSpec;
    this.mTosAccepted = instance.mTosAccepted;
    this.mUserRole = instance.mUserRole;
    this.mVerticalName = instance.mVerticalName;
    this.mAmountSpent = instance.mAmountSpent;
    this.mSpendCap = instance.mSpendCap;
    this.mBalance = instance.mBalance;
    this.mBusiness = instance.mBusiness;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mLastUsedTime = instance.mLastUsedTime;
    this.mAssetScore = instance.mAssetScore;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccount> getParser() {
    return new APIRequest.ResponseParser<AdAccount>() {
      public APINodeList<AdAccount> parseResponse(String response, APIContext context, APIRequest<AdAccount> request) {
        return AdAccount.parseResponse(response, context, request);
      }
    };
  }
}