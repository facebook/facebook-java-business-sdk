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
public class ChinaBusinessOnboardingVettingRequest extends APINode {
  @SerializedName("ad_account_creation_request_status")
  private String mAdAccountCreationRequestStatus = null;
  @SerializedName("ad_account_limit")
  private Long mAdAccountLimit = null;
  @SerializedName("ad_account_number")
  private String mAdAccountNumber = null;
  @SerializedName("ad_accounts_info")
  private List<Object> mAdAccountsInfo = null;
  @SerializedName("business_manager_id")
  private String mBusinessManagerId = null;
  @SerializedName("business_registration")
  private String mBusinessRegistration = null;
  @SerializedName("business_registration_id")
  private String mBusinessRegistrationId = null;
  @SerializedName("chinese_address")
  private String mChineseAddress = null;
  @SerializedName("chinese_legal_entity_name")
  private String mChineseLegalEntityName = null;
  @SerializedName("city")
  private String mCity = null;
  @SerializedName("contact")
  private String mContact = null;
  @SerializedName("coupon_code")
  private String mCouponCode = null;
  @SerializedName("disapprove_reason")
  private String mDisapproveReason = null;
  @SerializedName("english_business_name")
  private String mEnglishBusinessName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("official_website_url")
  private String mOfficialWebsiteUrl = null;
  @SerializedName("org_ad_account_count")
  private Long mOrgAdAccountCount = null;
  @SerializedName("payment_type")
  private String mPaymentType = null;
  @SerializedName("planning_agency_id")
  private String mPlanningAgencyId = null;
  @SerializedName("planning_agency_name")
  private String mPlanningAgencyName = null;
  @SerializedName("promotable_app_ids")
  private List<String> mPromotableAppIds = null;
  @SerializedName("promotable_page_ids")
  private List<String> mPromotablePageIds = null;
  @SerializedName("promotable_pages")
  private List<Object> mPromotablePages = null;
  @SerializedName("promotable_urls")
  private List<String> mPromotableUrls = null;
  @SerializedName("request_changes_reason")
  private String mRequestChangesReason = null;
  @SerializedName("reviewed_user")
  private String mReviewedUser = null;
  @SerializedName("spend_limit")
  private Long mSpendLimit = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subvertical")
  private String mSubvertical = null;
  @SerializedName("subvertical_v2")
  private String mSubverticalV2 = null;
  @SerializedName("supporting_document")
  private String mSupportingDocument = null;
  @SerializedName("time_changes_requested")
  private String mTimeChangesRequested = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  @SerializedName("time_zone")
  private String mTimeZone = null;
  @SerializedName("used_reseller_link")
  private Boolean mUsedResellerLink = null;
  @SerializedName("user_id")
  private String mUserId = null;
  @SerializedName("user_name")
  private String mUserName = null;
  @SerializedName("vertical")
  private String mVertical = null;
  @SerializedName("vertical_v2")
  private String mVerticalV2 = null;
  @SerializedName("viewed_by_reseller")
  private Boolean mViewedByReseller = null;
  @SerializedName("zip_code")
  private String mZipCode = null;
  protected static Gson gson = null;

  ChinaBusinessOnboardingVettingRequest() {
  }

  public ChinaBusinessOnboardingVettingRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ChinaBusinessOnboardingVettingRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ChinaBusinessOnboardingVettingRequest fetch() throws APIException{
    ChinaBusinessOnboardingVettingRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ChinaBusinessOnboardingVettingRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ChinaBusinessOnboardingVettingRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ChinaBusinessOnboardingVettingRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ChinaBusinessOnboardingVettingRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ChinaBusinessOnboardingVettingRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ChinaBusinessOnboardingVettingRequest>)(
      new APIRequest<ChinaBusinessOnboardingVettingRequest>(context, "", "/", "GET", ChinaBusinessOnboardingVettingRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ChinaBusinessOnboardingVettingRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ChinaBusinessOnboardingVettingRequest.getParser())
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
  public static ChinaBusinessOnboardingVettingRequest loadJSON(String json, APIContext context, String header) {
    ChinaBusinessOnboardingVettingRequest chinaBusinessOnboardingVettingRequest = getGson().fromJson(json, ChinaBusinessOnboardingVettingRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(chinaBusinessOnboardingVettingRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    chinaBusinessOnboardingVettingRequest.context = context;
    chinaBusinessOnboardingVettingRequest.rawValue = json;
    chinaBusinessOnboardingVettingRequest.header = header;
    return chinaBusinessOnboardingVettingRequest;
  }

  public static APINodeList<ChinaBusinessOnboardingVettingRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ChinaBusinessOnboardingVettingRequest> chinaBusinessOnboardingVettingRequests = new APINodeList<ChinaBusinessOnboardingVettingRequest>(request, json, header);
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
          chinaBusinessOnboardingVettingRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return chinaBusinessOnboardingVettingRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                chinaBusinessOnboardingVettingRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            chinaBusinessOnboardingVettingRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              chinaBusinessOnboardingVettingRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              chinaBusinessOnboardingVettingRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  chinaBusinessOnboardingVettingRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              chinaBusinessOnboardingVettingRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return chinaBusinessOnboardingVettingRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              chinaBusinessOnboardingVettingRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return chinaBusinessOnboardingVettingRequests;
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
              chinaBusinessOnboardingVettingRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return chinaBusinessOnboardingVettingRequests;
          }

          // Sixth, check if it's pure JsonObject
          chinaBusinessOnboardingVettingRequests.clear();
          chinaBusinessOnboardingVettingRequests.add(loadJSON(json, context, header));
          return chinaBusinessOnboardingVettingRequests;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdAccountCreationRequestStatus() {
    return mAdAccountCreationRequestStatus;
  }

  public Long getFieldAdAccountLimit() {
    return mAdAccountLimit;
  }

  public String getFieldAdAccountNumber() {
    return mAdAccountNumber;
  }

  public List<Object> getFieldAdAccountsInfo() {
    return mAdAccountsInfo;
  }

  public String getFieldBusinessManagerId() {
    return mBusinessManagerId;
  }

  public String getFieldBusinessRegistration() {
    return mBusinessRegistration;
  }

  public String getFieldBusinessRegistrationId() {
    return mBusinessRegistrationId;
  }

  public String getFieldChineseAddress() {
    return mChineseAddress;
  }

  public String getFieldChineseLegalEntityName() {
    return mChineseLegalEntityName;
  }

  public String getFieldCity() {
    return mCity;
  }

  public String getFieldContact() {
    return mContact;
  }

  public String getFieldCouponCode() {
    return mCouponCode;
  }

  public String getFieldDisapproveReason() {
    return mDisapproveReason;
  }

  public String getFieldEnglishBusinessName() {
    return mEnglishBusinessName;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldOfficialWebsiteUrl() {
    return mOfficialWebsiteUrl;
  }

  public Long getFieldOrgAdAccountCount() {
    return mOrgAdAccountCount;
  }

  public String getFieldPaymentType() {
    return mPaymentType;
  }

  public String getFieldPlanningAgencyId() {
    return mPlanningAgencyId;
  }

  public String getFieldPlanningAgencyName() {
    return mPlanningAgencyName;
  }

  public List<String> getFieldPromotableAppIds() {
    return mPromotableAppIds;
  }

  public List<String> getFieldPromotablePageIds() {
    return mPromotablePageIds;
  }

  public List<Object> getFieldPromotablePages() {
    return mPromotablePages;
  }

  public List<String> getFieldPromotableUrls() {
    return mPromotableUrls;
  }

  public String getFieldRequestChangesReason() {
    return mRequestChangesReason;
  }

  public String getFieldReviewedUser() {
    return mReviewedUser;
  }

  public Long getFieldSpendLimit() {
    return mSpendLimit;
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

  public String getFieldSupportingDocument() {
    return mSupportingDocument;
  }

  public String getFieldTimeChangesRequested() {
    return mTimeChangesRequested;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }

  public String getFieldTimeZone() {
    return mTimeZone;
  }

  public Boolean getFieldUsedResellerLink() {
    return mUsedResellerLink;
  }

  public String getFieldUserId() {
    return mUserId;
  }

  public String getFieldUserName() {
    return mUserName;
  }

  public String getFieldVertical() {
    return mVertical;
  }

  public String getFieldVerticalV2() {
    return mVerticalV2;
  }

  public Boolean getFieldViewedByReseller() {
    return mViewedByReseller;
  }

  public String getFieldZipCode() {
    return mZipCode;
  }



  public static class APIRequestGet extends APIRequest<ChinaBusinessOnboardingVettingRequest> {

    ChinaBusinessOnboardingVettingRequest lastResponse = null;
    @Override
    public ChinaBusinessOnboardingVettingRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_creation_request_status",
      "ad_account_limit",
      "ad_account_number",
      "ad_accounts_info",
      "business_manager_id",
      "business_registration",
      "business_registration_id",
      "chinese_address",
      "chinese_legal_entity_name",
      "city",
      "contact",
      "coupon_code",
      "disapprove_reason",
      "english_business_name",
      "id",
      "official_website_url",
      "org_ad_account_count",
      "payment_type",
      "planning_agency_id",
      "planning_agency_name",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_pages",
      "promotable_urls",
      "request_changes_reason",
      "reviewed_user",
      "spend_limit",
      "status",
      "subvertical",
      "subvertical_v2",
      "supporting_document",
      "time_changes_requested",
      "time_created",
      "time_updated",
      "time_zone",
      "used_reseller_link",
      "user_id",
      "user_name",
      "vertical",
      "vertical_v2",
      "viewed_by_reseller",
      "zip_code",
    };

    @Override
    public ChinaBusinessOnboardingVettingRequest parseResponse(String response, String header) throws APIException {
      return ChinaBusinessOnboardingVettingRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ChinaBusinessOnboardingVettingRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ChinaBusinessOnboardingVettingRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ChinaBusinessOnboardingVettingRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ChinaBusinessOnboardingVettingRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ChinaBusinessOnboardingVettingRequest>() {
           public ChinaBusinessOnboardingVettingRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountCreationRequestStatusField () {
      return this.requestAdAccountCreationRequestStatusField(true);
    }
    public APIRequestGet requestAdAccountCreationRequestStatusField (boolean value) {
      this.requestField("ad_account_creation_request_status", value);
      return this;
    }
    public APIRequestGet requestAdAccountLimitField () {
      return this.requestAdAccountLimitField(true);
    }
    public APIRequestGet requestAdAccountLimitField (boolean value) {
      this.requestField("ad_account_limit", value);
      return this;
    }
    public APIRequestGet requestAdAccountNumberField () {
      return this.requestAdAccountNumberField(true);
    }
    public APIRequestGet requestAdAccountNumberField (boolean value) {
      this.requestField("ad_account_number", value);
      return this;
    }
    public APIRequestGet requestAdAccountsInfoField () {
      return this.requestAdAccountsInfoField(true);
    }
    public APIRequestGet requestAdAccountsInfoField (boolean value) {
      this.requestField("ad_accounts_info", value);
      return this;
    }
    public APIRequestGet requestBusinessManagerIdField () {
      return this.requestBusinessManagerIdField(true);
    }
    public APIRequestGet requestBusinessManagerIdField (boolean value) {
      this.requestField("business_manager_id", value);
      return this;
    }
    public APIRequestGet requestBusinessRegistrationField () {
      return this.requestBusinessRegistrationField(true);
    }
    public APIRequestGet requestBusinessRegistrationField (boolean value) {
      this.requestField("business_registration", value);
      return this;
    }
    public APIRequestGet requestBusinessRegistrationIdField () {
      return this.requestBusinessRegistrationIdField(true);
    }
    public APIRequestGet requestBusinessRegistrationIdField (boolean value) {
      this.requestField("business_registration_id", value);
      return this;
    }
    public APIRequestGet requestChineseAddressField () {
      return this.requestChineseAddressField(true);
    }
    public APIRequestGet requestChineseAddressField (boolean value) {
      this.requestField("chinese_address", value);
      return this;
    }
    public APIRequestGet requestChineseLegalEntityNameField () {
      return this.requestChineseLegalEntityNameField(true);
    }
    public APIRequestGet requestChineseLegalEntityNameField (boolean value) {
      this.requestField("chinese_legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGet requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGet requestContactField () {
      return this.requestContactField(true);
    }
    public APIRequestGet requestContactField (boolean value) {
      this.requestField("contact", value);
      return this;
    }
    public APIRequestGet requestCouponCodeField () {
      return this.requestCouponCodeField(true);
    }
    public APIRequestGet requestCouponCodeField (boolean value) {
      this.requestField("coupon_code", value);
      return this;
    }
    public APIRequestGet requestDisapproveReasonField () {
      return this.requestDisapproveReasonField(true);
    }
    public APIRequestGet requestDisapproveReasonField (boolean value) {
      this.requestField("disapprove_reason", value);
      return this;
    }
    public APIRequestGet requestEnglishBusinessNameField () {
      return this.requestEnglishBusinessNameField(true);
    }
    public APIRequestGet requestEnglishBusinessNameField (boolean value) {
      this.requestField("english_business_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOfficialWebsiteUrlField () {
      return this.requestOfficialWebsiteUrlField(true);
    }
    public APIRequestGet requestOfficialWebsiteUrlField (boolean value) {
      this.requestField("official_website_url", value);
      return this;
    }
    public APIRequestGet requestOrgAdAccountCountField () {
      return this.requestOrgAdAccountCountField(true);
    }
    public APIRequestGet requestOrgAdAccountCountField (boolean value) {
      this.requestField("org_ad_account_count", value);
      return this;
    }
    public APIRequestGet requestPaymentTypeField () {
      return this.requestPaymentTypeField(true);
    }
    public APIRequestGet requestPaymentTypeField (boolean value) {
      this.requestField("payment_type", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyIdField () {
      return this.requestPlanningAgencyIdField(true);
    }
    public APIRequestGet requestPlanningAgencyIdField (boolean value) {
      this.requestField("planning_agency_id", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyNameField () {
      return this.requestPlanningAgencyNameField(true);
    }
    public APIRequestGet requestPlanningAgencyNameField (boolean value) {
      this.requestField("planning_agency_name", value);
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
    public APIRequestGet requestPromotablePagesField () {
      return this.requestPromotablePagesField(true);
    }
    public APIRequestGet requestPromotablePagesField (boolean value) {
      this.requestField("promotable_pages", value);
      return this;
    }
    public APIRequestGet requestPromotableUrlsField () {
      return this.requestPromotableUrlsField(true);
    }
    public APIRequestGet requestPromotableUrlsField (boolean value) {
      this.requestField("promotable_urls", value);
      return this;
    }
    public APIRequestGet requestRequestChangesReasonField () {
      return this.requestRequestChangesReasonField(true);
    }
    public APIRequestGet requestRequestChangesReasonField (boolean value) {
      this.requestField("request_changes_reason", value);
      return this;
    }
    public APIRequestGet requestReviewedUserField () {
      return this.requestReviewedUserField(true);
    }
    public APIRequestGet requestReviewedUserField (boolean value) {
      this.requestField("reviewed_user", value);
      return this;
    }
    public APIRequestGet requestSpendLimitField () {
      return this.requestSpendLimitField(true);
    }
    public APIRequestGet requestSpendLimitField (boolean value) {
      this.requestField("spend_limit", value);
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
    public APIRequestGet requestSupportingDocumentField () {
      return this.requestSupportingDocumentField(true);
    }
    public APIRequestGet requestSupportingDocumentField (boolean value) {
      this.requestField("supporting_document", value);
      return this;
    }
    public APIRequestGet requestTimeChangesRequestedField () {
      return this.requestTimeChangesRequestedField(true);
    }
    public APIRequestGet requestTimeChangesRequestedField (boolean value) {
      this.requestField("time_changes_requested", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGet requestTimeZoneField () {
      return this.requestTimeZoneField(true);
    }
    public APIRequestGet requestTimeZoneField (boolean value) {
      this.requestField("time_zone", value);
      return this;
    }
    public APIRequestGet requestUsedResellerLinkField () {
      return this.requestUsedResellerLinkField(true);
    }
    public APIRequestGet requestUsedResellerLinkField (boolean value) {
      this.requestField("used_reseller_link", value);
      return this;
    }
    public APIRequestGet requestUserIdField () {
      return this.requestUserIdField(true);
    }
    public APIRequestGet requestUserIdField (boolean value) {
      this.requestField("user_id", value);
      return this;
    }
    public APIRequestGet requestUserNameField () {
      return this.requestUserNameField(true);
    }
    public APIRequestGet requestUserNameField (boolean value) {
      this.requestField("user_name", value);
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
    public APIRequestGet requestViewedByResellerField () {
      return this.requestViewedByResellerField(true);
    }
    public APIRequestGet requestViewedByResellerField (boolean value) {
      this.requestField("viewed_by_reseller", value);
      return this;
    }
    public APIRequestGet requestZipCodeField () {
      return this.requestZipCodeField(true);
    }
    public APIRequestGet requestZipCodeField (boolean value) {
      this.requestField("zip_code", value);
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

  public ChinaBusinessOnboardingVettingRequest copyFrom(ChinaBusinessOnboardingVettingRequest instance) {
    this.mAdAccountCreationRequestStatus = instance.mAdAccountCreationRequestStatus;
    this.mAdAccountLimit = instance.mAdAccountLimit;
    this.mAdAccountNumber = instance.mAdAccountNumber;
    this.mAdAccountsInfo = instance.mAdAccountsInfo;
    this.mBusinessManagerId = instance.mBusinessManagerId;
    this.mBusinessRegistration = instance.mBusinessRegistration;
    this.mBusinessRegistrationId = instance.mBusinessRegistrationId;
    this.mChineseAddress = instance.mChineseAddress;
    this.mChineseLegalEntityName = instance.mChineseLegalEntityName;
    this.mCity = instance.mCity;
    this.mContact = instance.mContact;
    this.mCouponCode = instance.mCouponCode;
    this.mDisapproveReason = instance.mDisapproveReason;
    this.mEnglishBusinessName = instance.mEnglishBusinessName;
    this.mId = instance.mId;
    this.mOfficialWebsiteUrl = instance.mOfficialWebsiteUrl;
    this.mOrgAdAccountCount = instance.mOrgAdAccountCount;
    this.mPaymentType = instance.mPaymentType;
    this.mPlanningAgencyId = instance.mPlanningAgencyId;
    this.mPlanningAgencyName = instance.mPlanningAgencyName;
    this.mPromotableAppIds = instance.mPromotableAppIds;
    this.mPromotablePageIds = instance.mPromotablePageIds;
    this.mPromotablePages = instance.mPromotablePages;
    this.mPromotableUrls = instance.mPromotableUrls;
    this.mRequestChangesReason = instance.mRequestChangesReason;
    this.mReviewedUser = instance.mReviewedUser;
    this.mSpendLimit = instance.mSpendLimit;
    this.mStatus = instance.mStatus;
    this.mSubvertical = instance.mSubvertical;
    this.mSubverticalV2 = instance.mSubverticalV2;
    this.mSupportingDocument = instance.mSupportingDocument;
    this.mTimeChangesRequested = instance.mTimeChangesRequested;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.mTimeZone = instance.mTimeZone;
    this.mUsedResellerLink = instance.mUsedResellerLink;
    this.mUserId = instance.mUserId;
    this.mUserName = instance.mUserName;
    this.mVertical = instance.mVertical;
    this.mVerticalV2 = instance.mVerticalV2;
    this.mViewedByReseller = instance.mViewedByReseller;
    this.mZipCode = instance.mZipCode;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ChinaBusinessOnboardingVettingRequest> getParser() {
    return new APIRequest.ResponseParser<ChinaBusinessOnboardingVettingRequest>() {
      public APINodeList<ChinaBusinessOnboardingVettingRequest> parseResponse(String response, APIContext context, APIRequest<ChinaBusinessOnboardingVettingRequest> request, String header) throws MalformedResponseException {
        return ChinaBusinessOnboardingVettingRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
