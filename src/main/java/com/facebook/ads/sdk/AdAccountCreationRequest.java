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
public class AdAccountCreationRequest extends APINode {
  @SerializedName("ad_accounts_currency")
  private String mAdAccountsCurrency = null;
  @SerializedName("ad_accounts_info")
  private List<Object> mAdAccountsInfo = null;
  @SerializedName("additional_comment")
  private String mAdditionalComment = null;
  @SerializedName("address_in_chinese")
  private String mAddressInChinese = null;
  @SerializedName("address_in_english")
  private Object mAddressInEnglish = null;
  @SerializedName("address_in_local_language")
  private String mAddressInLocalLanguage = null;
  @SerializedName("advertiser_business")
  private Business mAdvertiserBusiness = null;
  @SerializedName("appeal_reason")
  private Object mAppealReason = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_registration_id")
  private String mBusinessRegistrationId = null;
  @SerializedName("chinese_legal_entity_name")
  private String mChineseLegalEntityName = null;
  @SerializedName("contact")
  private Object mContact = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("credit_card_id")
  private String mCreditCardId = null;
  @SerializedName("disapproval_reasons")
  private List<Object> mDisapprovalReasons = null;
  @SerializedName("english_legal_entity_name")
  private String mEnglishLegalEntityName = null;
  @SerializedName("extended_credit_id")
  private String mExtendedCreditId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_smb")
  private Boolean mIsSmb = null;
  @SerializedName("is_test")
  private Boolean mIsTest = null;
  @SerializedName("legal_entity_name_in_local_language")
  private String mLegalEntityNameInLocalLanguage = null;
  @SerializedName("oe_request_id")
  private String mOeRequestId = null;
  @SerializedName("official_website_url")
  private String mOfficialWebsiteUrl = null;
  @SerializedName("planning_agency_business")
  private Business mPlanningAgencyBusiness = null;
  @SerializedName("planning_agency_business_id")
  private String mPlanningAgencyBusinessId = null;
  @SerializedName("promotable_app_ids")
  private List<String> mPromotableAppIds = null;
  @SerializedName("promotable_page_ids")
  private List<String> mPromotablePageIds = null;
  @SerializedName("promotable_urls")
  private List<String> mPromotableUrls = null;
  @SerializedName("request_change_reasons")
  private List<Object> mRequestChangeReasons = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subvertical")
  private String mSubvertical = null;
  @SerializedName("subvertical_v2")
  private String mSubverticalV2 = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("vertical")
  private String mVertical = null;
  @SerializedName("vertical_v2")
  private String mVerticalV2 = null;
  protected static Gson gson = null;

  AdAccountCreationRequest() {
  }

  public AdAccountCreationRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountCreationRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountCreationRequest fetch() throws APIException{
    AdAccountCreationRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountCreationRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountCreationRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountCreationRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountCreationRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountCreationRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountCreationRequest>)(
      new APIRequest<AdAccountCreationRequest>(context, "", "/", "GET", AdAccountCreationRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountCreationRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountCreationRequest.getParser())
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
  public static AdAccountCreationRequest loadJSON(String json, APIContext context, String header) {
    AdAccountCreationRequest adAccountCreationRequest = getGson().fromJson(json, AdAccountCreationRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountCreationRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountCreationRequest.context = context;
    adAccountCreationRequest.rawValue = json;
    adAccountCreationRequest.header = header;
    return adAccountCreationRequest;
  }

  public static APINodeList<AdAccountCreationRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountCreationRequest> adAccountCreationRequests = new APINodeList<AdAccountCreationRequest>(request, json, header);
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
          adAccountCreationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountCreationRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountCreationRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountCreationRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountCreationRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountCreationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountCreationRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountCreationRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountCreationRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountCreationRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountCreationRequests;
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
              adAccountCreationRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountCreationRequests;
          }

          // Sixth, check if it's pure JsonObject
          adAccountCreationRequests.clear();
          adAccountCreationRequests.add(loadJSON(json, context, header));
          return adAccountCreationRequests;
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

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdAccountsCurrency() {
    return mAdAccountsCurrency;
  }

  public List<Object> getFieldAdAccountsInfo() {
    return mAdAccountsInfo;
  }

  public String getFieldAdditionalComment() {
    return mAdditionalComment;
  }

  public String getFieldAddressInChinese() {
    return mAddressInChinese;
  }

  public Object getFieldAddressInEnglish() {
    return mAddressInEnglish;
  }

  public String getFieldAddressInLocalLanguage() {
    return mAddressInLocalLanguage;
  }

  public Business getFieldAdvertiserBusiness() {
    if (mAdvertiserBusiness != null) {
      mAdvertiserBusiness.context = getContext();
    }
    return mAdvertiserBusiness;
  }

  public Object getFieldAppealReason() {
    return mAppealReason;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldBusinessRegistrationId() {
    return mBusinessRegistrationId;
  }

  public String getFieldChineseLegalEntityName() {
    return mChineseLegalEntityName;
  }

  public Object getFieldContact() {
    return mContact;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldCreditCardId() {
    return mCreditCardId;
  }

  public List<Object> getFieldDisapprovalReasons() {
    return mDisapprovalReasons;
  }

  public String getFieldEnglishLegalEntityName() {
    return mEnglishLegalEntityName;
  }

  public String getFieldExtendedCreditId() {
    return mExtendedCreditId;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsSmb() {
    return mIsSmb;
  }

  public Boolean getFieldIsTest() {
    return mIsTest;
  }

  public String getFieldLegalEntityNameInLocalLanguage() {
    return mLegalEntityNameInLocalLanguage;
  }

  public String getFieldOeRequestId() {
    return mOeRequestId;
  }

  public String getFieldOfficialWebsiteUrl() {
    return mOfficialWebsiteUrl;
  }

  public Business getFieldPlanningAgencyBusiness() {
    if (mPlanningAgencyBusiness != null) {
      mPlanningAgencyBusiness.context = getContext();
    }
    return mPlanningAgencyBusiness;
  }

  public String getFieldPlanningAgencyBusinessId() {
    return mPlanningAgencyBusinessId;
  }

  public List<String> getFieldPromotableAppIds() {
    return mPromotableAppIds;
  }

  public List<String> getFieldPromotablePageIds() {
    return mPromotablePageIds;
  }

  public List<String> getFieldPromotableUrls() {
    return mPromotableUrls;
  }

  public List<Object> getFieldRequestChangeReasons() {
    return mRequestChangeReasons;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldSubvertical() {
    return mSubvertical;
  }

  public String getFieldSubverticalV2() {
    return mSubverticalV2;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldVertical() {
    return mVertical;
  }

  public String getFieldVerticalV2() {
    return mVerticalV2;
  }



  public static class APIRequestGetAdAccounts extends APIRequest<AdAccount> {

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
               return APIRequestGetAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAllCapabilitiesField () {
      return this.requestAllCapabilitiesField(true);
    }
    public APIRequestGetAdAccounts requestAllCapabilitiesField (boolean value) {
      this.requestField("all_capabilities", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBrandSafetyContentFilterLevelsField () {
      return this.requestBrandSafetyContentFilterLevelsField(true);
    }
    public APIRequestGetAdAccounts requestBrandSafetyContentFilterLevelsField (boolean value) {
      this.requestField("brand_safety_content_filter_levels", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCustomAudienceInfoField () {
      return this.requestCustomAudienceInfoField(true);
    }
    public APIRequestGetAdAccounts requestCustomAudienceInfoField (boolean value) {
      this.requestField("custom_audience_info", value);
      return this;
    }
    public APIRequestGetAdAccounts requestDefaultDsaBeneficiaryField () {
      return this.requestDefaultDsaBeneficiaryField(true);
    }
    public APIRequestGetAdAccounts requestDefaultDsaBeneficiaryField (boolean value) {
      this.requestField("default_dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetAdAccounts requestDefaultDsaPayorField () {
      return this.requestDefaultDsaPayorField(true);
    }
    public APIRequestGetAdAccounts requestDefaultDsaPayorField (boolean value) {
      this.requestField("default_dsa_payor", value);
      return this;
    }
    public APIRequestGetAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestExistingCustomersField () {
      return this.requestExistingCustomersField(true);
    }
    public APIRequestGetAdAccounts requestExistingCustomersField (boolean value) {
      this.requestField("existing_customers", value);
      return this;
    }
    public APIRequestGetAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetAdAccounts requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetAdAccounts requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAdAccounts requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetAdAccounts requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetAdAccounts requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetAdAccounts requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
    public APIRequestGetAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAdAccounts requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAdAccounts requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
    public APIRequestGetAdAccounts requestViewableBusinessField () {
      return this.requestViewableBusinessField(true);
    }
    public APIRequestGetAdAccounts requestViewableBusinessField (boolean value) {
      this.requestField("viewable_business", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
      "legal_entity_name_in_local_language",
      "oe_request_id",
      "official_website_url",
      "planning_agency_business",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_urls",
      "request_change_reasons",
      "status",
      "subvertical",
      "subvertical_v2",
      "time_created",
      "vertical",
      "vertical_v2",
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response, String header) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountsCurrencyField () {
      return this.requestAdAccountsCurrencyField(true);
    }
    public APIRequestGet requestAdAccountsCurrencyField (boolean value) {
      this.requestField("ad_accounts_currency", value);
      return this;
    }
    public APIRequestGet requestAdAccountsInfoField () {
      return this.requestAdAccountsInfoField(true);
    }
    public APIRequestGet requestAdAccountsInfoField (boolean value) {
      this.requestField("ad_accounts_info", value);
      return this;
    }
    public APIRequestGet requestAdditionalCommentField () {
      return this.requestAdditionalCommentField(true);
    }
    public APIRequestGet requestAdditionalCommentField (boolean value) {
      this.requestField("additional_comment", value);
      return this;
    }
    public APIRequestGet requestAddressInChineseField () {
      return this.requestAddressInChineseField(true);
    }
    public APIRequestGet requestAddressInChineseField (boolean value) {
      this.requestField("address_in_chinese", value);
      return this;
    }
    public APIRequestGet requestAddressInEnglishField () {
      return this.requestAddressInEnglishField(true);
    }
    public APIRequestGet requestAddressInEnglishField (boolean value) {
      this.requestField("address_in_english", value);
      return this;
    }
    public APIRequestGet requestAddressInLocalLanguageField () {
      return this.requestAddressInLocalLanguageField(true);
    }
    public APIRequestGet requestAddressInLocalLanguageField (boolean value) {
      this.requestField("address_in_local_language", value);
      return this;
    }
    public APIRequestGet requestAdvertiserBusinessField () {
      return this.requestAdvertiserBusinessField(true);
    }
    public APIRequestGet requestAdvertiserBusinessField (boolean value) {
      this.requestField("advertiser_business", value);
      return this;
    }
    public APIRequestGet requestAppealReasonField () {
      return this.requestAppealReasonField(true);
    }
    public APIRequestGet requestAppealReasonField (boolean value) {
      this.requestField("appeal_reason", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestBusinessRegistrationIdField () {
      return this.requestBusinessRegistrationIdField(true);
    }
    public APIRequestGet requestBusinessRegistrationIdField (boolean value) {
      this.requestField("business_registration_id", value);
      return this;
    }
    public APIRequestGet requestChineseLegalEntityNameField () {
      return this.requestChineseLegalEntityNameField(true);
    }
    public APIRequestGet requestChineseLegalEntityNameField (boolean value) {
      this.requestField("chinese_legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestContactField () {
      return this.requestContactField(true);
    }
    public APIRequestGet requestContactField (boolean value) {
      this.requestField("contact", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestCreditCardIdField () {
      return this.requestCreditCardIdField(true);
    }
    public APIRequestGet requestCreditCardIdField (boolean value) {
      this.requestField("credit_card_id", value);
      return this;
    }
    public APIRequestGet requestDisapprovalReasonsField () {
      return this.requestDisapprovalReasonsField(true);
    }
    public APIRequestGet requestDisapprovalReasonsField (boolean value) {
      this.requestField("disapproval_reasons", value);
      return this;
    }
    public APIRequestGet requestEnglishLegalEntityNameField () {
      return this.requestEnglishLegalEntityNameField(true);
    }
    public APIRequestGet requestEnglishLegalEntityNameField (boolean value) {
      this.requestField("english_legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestExtendedCreditIdField () {
      return this.requestExtendedCreditIdField(true);
    }
    public APIRequestGet requestExtendedCreditIdField (boolean value) {
      this.requestField("extended_credit_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsSmbField () {
      return this.requestIsSmbField(true);
    }
    public APIRequestGet requestIsSmbField (boolean value) {
      this.requestField("is_smb", value);
      return this;
    }
    public APIRequestGet requestIsTestField () {
      return this.requestIsTestField(true);
    }
    public APIRequestGet requestIsTestField (boolean value) {
      this.requestField("is_test", value);
      return this;
    }
    public APIRequestGet requestLegalEntityNameInLocalLanguageField () {
      return this.requestLegalEntityNameInLocalLanguageField(true);
    }
    public APIRequestGet requestLegalEntityNameInLocalLanguageField (boolean value) {
      this.requestField("legal_entity_name_in_local_language", value);
      return this;
    }
    public APIRequestGet requestOeRequestIdField () {
      return this.requestOeRequestIdField(true);
    }
    public APIRequestGet requestOeRequestIdField (boolean value) {
      this.requestField("oe_request_id", value);
      return this;
    }
    public APIRequestGet requestOfficialWebsiteUrlField () {
      return this.requestOfficialWebsiteUrlField(true);
    }
    public APIRequestGet requestOfficialWebsiteUrlField (boolean value) {
      this.requestField("official_website_url", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyBusinessField () {
      return this.requestPlanningAgencyBusinessField(true);
    }
    public APIRequestGet requestPlanningAgencyBusinessField (boolean value) {
      this.requestField("planning_agency_business", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyBusinessIdField () {
      return this.requestPlanningAgencyBusinessIdField(true);
    }
    public APIRequestGet requestPlanningAgencyBusinessIdField (boolean value) {
      this.requestField("planning_agency_business_id", value);
      return this;
    }
    public APIRequestGet requestPromotableAppIdsField () {
      return this.requestPromotableAppIdsField(true);
    }
    public APIRequestGet requestPromotableAppIdsField (boolean value) {
      this.requestField("promotable_app_ids", value);
      return this;
    }
    public APIRequestGet requestPromotablePageIdsField () {
      return this.requestPromotablePageIdsField(true);
    }
    public APIRequestGet requestPromotablePageIdsField (boolean value) {
      this.requestField("promotable_page_ids", value);
      return this;
    }
    public APIRequestGet requestPromotableUrlsField () {
      return this.requestPromotableUrlsField(true);
    }
    public APIRequestGet requestPromotableUrlsField (boolean value) {
      this.requestField("promotable_urls", value);
      return this;
    }
    public APIRequestGet requestRequestChangeReasonsField () {
      return this.requestRequestChangeReasonsField(true);
    }
    public APIRequestGet requestRequestChangeReasonsField (boolean value) {
      this.requestField("request_change_reasons", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestSubverticalField () {
      return this.requestSubverticalField(true);
    }
    public APIRequestGet requestSubverticalField (boolean value) {
      this.requestField("subvertical", value);
      return this;
    }
    public APIRequestGet requestSubverticalV2Field () {
      return this.requestSubverticalV2Field(true);
    }
    public APIRequestGet requestSubverticalV2Field (boolean value) {
      this.requestField("subvertical_v2", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGet requestVerticalV2Field () {
      return this.requestVerticalV2Field(true);
    }
    public APIRequestGet requestVerticalV2Field (boolean value) {
      this.requestField("vertical_v2", value);
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

  public AdAccountCreationRequest copyFrom(AdAccountCreationRequest instance) {
    this.mAdAccountsCurrency = instance.mAdAccountsCurrency;
    this.mAdAccountsInfo = instance.mAdAccountsInfo;
    this.mAdditionalComment = instance.mAdditionalComment;
    this.mAddressInChinese = instance.mAddressInChinese;
    this.mAddressInEnglish = instance.mAddressInEnglish;
    this.mAddressInLocalLanguage = instance.mAddressInLocalLanguage;
    this.mAdvertiserBusiness = instance.mAdvertiserBusiness;
    this.mAppealReason = instance.mAppealReason;
    this.mBusiness = instance.mBusiness;
    this.mBusinessRegistrationId = instance.mBusinessRegistrationId;
    this.mChineseLegalEntityName = instance.mChineseLegalEntityName;
    this.mContact = instance.mContact;
    this.mCreator = instance.mCreator;
    this.mCreditCardId = instance.mCreditCardId;
    this.mDisapprovalReasons = instance.mDisapprovalReasons;
    this.mEnglishLegalEntityName = instance.mEnglishLegalEntityName;
    this.mExtendedCreditId = instance.mExtendedCreditId;
    this.mId = instance.mId;
    this.mIsSmb = instance.mIsSmb;
    this.mIsTest = instance.mIsTest;
    this.mLegalEntityNameInLocalLanguage = instance.mLegalEntityNameInLocalLanguage;
    this.mOeRequestId = instance.mOeRequestId;
    this.mOfficialWebsiteUrl = instance.mOfficialWebsiteUrl;
    this.mPlanningAgencyBusiness = instance.mPlanningAgencyBusiness;
    this.mPlanningAgencyBusinessId = instance.mPlanningAgencyBusinessId;
    this.mPromotableAppIds = instance.mPromotableAppIds;
    this.mPromotablePageIds = instance.mPromotablePageIds;
    this.mPromotableUrls = instance.mPromotableUrls;
    this.mRequestChangeReasons = instance.mRequestChangeReasons;
    this.mStatus = instance.mStatus;
    this.mSubvertical = instance.mSubvertical;
    this.mSubverticalV2 = instance.mSubverticalV2;
    this.mTimeCreated = instance.mTimeCreated;
    this.mVertical = instance.mVertical;
    this.mVerticalV2 = instance.mVerticalV2;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountCreationRequest> getParser() {
    return new APIRequest.ResponseParser<AdAccountCreationRequest>() {
      public APINodeList<AdAccountCreationRequest> parseResponse(String response, APIContext context, APIRequest<AdAccountCreationRequest> request, String header) throws MalformedResponseException {
        return AdAccountCreationRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
