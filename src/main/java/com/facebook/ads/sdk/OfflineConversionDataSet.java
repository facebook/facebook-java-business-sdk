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
public class OfflineConversionDataSet extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("config")
  private String mConfig = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("duplicate_entries")
  private Long mDuplicateEntries = null;
  @SerializedName("enable_auto_assign_to_accounts")
  private Boolean mEnableAutoAssignToAccounts = null;
  @SerializedName("event_stats")
  private String mEventStats = null;
  @SerializedName("event_time_max")
  private Long mEventTimeMax = null;
  @SerializedName("event_time_min")
  private Long mEventTimeMin = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_mta_use")
  private Boolean mIsMtaUse = null;
  @SerializedName("is_restricted_use")
  private Boolean mIsRestrictedUse = null;
  @SerializedName("is_unavailable")
  private Boolean mIsUnavailable = null;
  @SerializedName("last_upload_app")
  private String mLastUploadApp = null;
  @SerializedName("last_upload_app_changed_time")
  private Long mLastUploadAppChangedTime = null;
  @SerializedName("match_rate_approx")
  private Long mMatchRateApprox = null;
  @SerializedName("matched_entries")
  private Long mMatchedEntries = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("usage")
  private Object mUsage = null;
  @SerializedName("valid_entries")
  private Long mValidEntries = null;
  protected static Gson gson = null;

  OfflineConversionDataSet() {
  }

  public OfflineConversionDataSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OfflineConversionDataSet(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OfflineConversionDataSet fetch() throws APIException{
    OfflineConversionDataSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OfflineConversionDataSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OfflineConversionDataSet> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OfflineConversionDataSet fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OfflineConversionDataSet> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OfflineConversionDataSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OfflineConversionDataSet>)(
      new APIRequest<OfflineConversionDataSet>(context, "", "/", "GET", OfflineConversionDataSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OfflineConversionDataSet>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OfflineConversionDataSet.getParser())
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
  public static OfflineConversionDataSet loadJSON(String json, APIContext context, String header) {
    OfflineConversionDataSet offlineConversionDataSet = getGson().fromJson(json, OfflineConversionDataSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(offlineConversionDataSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    offlineConversionDataSet.context = context;
    offlineConversionDataSet.rawValue = json;
    offlineConversionDataSet.header = header;
    return offlineConversionDataSet;
  }

  public static APINodeList<OfflineConversionDataSet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OfflineConversionDataSet> offlineConversionDataSets = new APINodeList<OfflineConversionDataSet>(request, json, header);
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
          offlineConversionDataSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return offlineConversionDataSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                offlineConversionDataSets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            offlineConversionDataSets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              offlineConversionDataSets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              offlineConversionDataSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  offlineConversionDataSets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              offlineConversionDataSets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return offlineConversionDataSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              offlineConversionDataSets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return offlineConversionDataSets;
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
              offlineConversionDataSets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return offlineConversionDataSets;
          }

          // Sixth, check if it's pure JsonObject
          offlineConversionDataSets.clear();
          offlineConversionDataSets.add(loadJSON(json, context, header));
          return offlineConversionDataSets;
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

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAgency createAgency() {
    return new APIRequestCreateAgency(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAudiences getAudiences() {
    return new APIRequestGetAudiences(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomConversions getCustomConversions() {
    return new APIRequestGetCustomConversions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateEvent createEvent() {
    return new APIRequestCreateEvent(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStats getStats() {
    return new APIRequestGetStats(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUploads getUploads() {
    return new APIRequestGetUploads(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpload createUpload() {
    return new APIRequestCreateUpload(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateValidate createValidate() {
    return new APIRequestCreateValidate(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldConfig() {
    return mConfig;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Long getFieldDuplicateEntries() {
    return mDuplicateEntries;
  }

  public Boolean getFieldEnableAutoAssignToAccounts() {
    return mEnableAutoAssignToAccounts;
  }

  public String getFieldEventStats() {
    return mEventStats;
  }

  public Long getFieldEventTimeMax() {
    return mEventTimeMax;
  }

  public Long getFieldEventTimeMin() {
    return mEventTimeMin;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsMtaUse() {
    return mIsMtaUse;
  }

  public Boolean getFieldIsRestrictedUse() {
    return mIsRestrictedUse;
  }

  public Boolean getFieldIsUnavailable() {
    return mIsUnavailable;
  }

  public String getFieldLastUploadApp() {
    return mLastUploadApp;
  }

  public Long getFieldLastUploadAppChangedTime() {
    return mLastUploadAppChangedTime;
  }

  public Long getFieldMatchRateApprox() {
    return mMatchRateApprox;
  }

  public Long getFieldMatchedEntries() {
    return mMatchedEntries;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldUsage() {
    return mUsage;
  }

  public Long getFieldValidEntries() {
    return mValidEntries;
  }



  public static class APIRequestGetAdAccounts extends APIRequest<AdAccount> {

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
               return APIRequestGetAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetAdAccounts setBusiness (String business) {
      this.setParam("business", business);
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
    public APIRequestGetAdAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetAdAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
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
    public APIRequestGetAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
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
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
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
  }

  public static class APIRequestCreateAdAccount extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "auto_track_for_ads",
      "business",
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
               return APIRequestCreateAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "POST", Arrays.asList(PARAMS));
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


    public APIRequestCreateAdAccount setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestCreateAdAccount setAutoTrackForAds (Boolean autoTrackForAds) {
      this.setParam("auto_track_for_ads", autoTrackForAds);
      return this;
    }
    public APIRequestCreateAdAccount setAutoTrackForAds (String autoTrackForAds) {
      this.setParam("auto_track_for_ads", autoTrackForAds);
      return this;
    }

    public APIRequestCreateAdAccount setBusiness (String business) {
      this.setParam("business", business);
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

  public static class APIRequestCreateAgency extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
      "other_relationship",
      "permitted_roles",
      "relationship_type",
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
               return APIRequestCreateAgency.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestCreateAgency setOtherRelationship (String otherRelationship) {
      this.setParam("other_relationship", otherRelationship);
      return this;
    }

    public APIRequestCreateAgency setPermittedRoles (List<OfflineConversionDataSet.EnumPermittedRoles> permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }
    public APIRequestCreateAgency setPermittedRoles (String permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreateAgency setRelationshipType (List<OfflineConversionDataSet.EnumRelationshipType> relationshipType) {
      this.setParam("relationship_type", relationshipType);
      return this;
    }
    public APIRequestCreateAgency setRelationshipType (String relationshipType) {
      this.setParam("relationship_type", relationshipType);
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

  public static class APIRequestGetAudiences extends APIRequest<CustomAudience> {

    APINodeList<CustomAudience> lastResponse = null;
    @Override
    public APINodeList<CustomAudience> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account",
    };

    public static final String[] FIELDS = {
      "account_id",
      "approximate_count",
      "customer_file_source",
      "data_source",
      "data_source_types",
      "datafile_custom_audience_uploading_status",
      "delivery_status",
      "description",
      "excluded_custom_audiences",
      "external_event_source",
      "household_audience",
      "id",
      "included_custom_audiences",
      "is_household",
      "is_snapshot",
      "is_value_based",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "permission_for_actions",
      "pixel_id",
      "regulated_audience_spec",
      "retention_days",
      "rev_share_policy_id",
      "rule",
      "rule_aggregation",
      "rule_v2",
      "seed_audience",
      "sharing_status",
      "subtype",
      "time_content_updated",
      "time_created",
      "time_updated",
    };

    @Override
    public APINodeList<CustomAudience> parseResponse(String response, String header) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CustomAudience> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudience> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CustomAudience>>() {
           public APINodeList<CustomAudience> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAudiences.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAudiences(String nodeId, APIContext context) {
      super(context, nodeId, "/audiences", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAudiences setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAudiences setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAudiences setAdAccount (String adAccount) {
      this.setParam("ad_account", adAccount);
      return this;
    }

    public APIRequestGetAudiences requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAudiences requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudiences requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAudiences requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudiences requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAudiences requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAudiences requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAudiences requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAudiences requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGetAudiences requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGetAudiences requestCustomerFileSourceField () {
      return this.requestCustomerFileSourceField(true);
    }
    public APIRequestGetAudiences requestCustomerFileSourceField (boolean value) {
      this.requestField("customer_file_source", value);
      return this;
    }
    public APIRequestGetAudiences requestDataSourceField () {
      return this.requestDataSourceField(true);
    }
    public APIRequestGetAudiences requestDataSourceField (boolean value) {
      this.requestField("data_source", value);
      return this;
    }
    public APIRequestGetAudiences requestDataSourceTypesField () {
      return this.requestDataSourceTypesField(true);
    }
    public APIRequestGetAudiences requestDataSourceTypesField (boolean value) {
      this.requestField("data_source_types", value);
      return this;
    }
    public APIRequestGetAudiences requestDatafileCustomAudienceUploadingStatusField () {
      return this.requestDatafileCustomAudienceUploadingStatusField(true);
    }
    public APIRequestGetAudiences requestDatafileCustomAudienceUploadingStatusField (boolean value) {
      this.requestField("datafile_custom_audience_uploading_status", value);
      return this;
    }
    public APIRequestGetAudiences requestDeliveryStatusField () {
      return this.requestDeliveryStatusField(true);
    }
    public APIRequestGetAudiences requestDeliveryStatusField (boolean value) {
      this.requestField("delivery_status", value);
      return this;
    }
    public APIRequestGetAudiences requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAudiences requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAudiences requestExcludedCustomAudiencesField () {
      return this.requestExcludedCustomAudiencesField(true);
    }
    public APIRequestGetAudiences requestExcludedCustomAudiencesField (boolean value) {
      this.requestField("excluded_custom_audiences", value);
      return this;
    }
    public APIRequestGetAudiences requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGetAudiences requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
      return this;
    }
    public APIRequestGetAudiences requestHouseholdAudienceField () {
      return this.requestHouseholdAudienceField(true);
    }
    public APIRequestGetAudiences requestHouseholdAudienceField (boolean value) {
      this.requestField("household_audience", value);
      return this;
    }
    public APIRequestGetAudiences requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAudiences requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAudiences requestIncludedCustomAudiencesField () {
      return this.requestIncludedCustomAudiencesField(true);
    }
    public APIRequestGetAudiences requestIncludedCustomAudiencesField (boolean value) {
      this.requestField("included_custom_audiences", value);
      return this;
    }
    public APIRequestGetAudiences requestIsHouseholdField () {
      return this.requestIsHouseholdField(true);
    }
    public APIRequestGetAudiences requestIsHouseholdField (boolean value) {
      this.requestField("is_household", value);
      return this;
    }
    public APIRequestGetAudiences requestIsSnapshotField () {
      return this.requestIsSnapshotField(true);
    }
    public APIRequestGetAudiences requestIsSnapshotField (boolean value) {
      this.requestField("is_snapshot", value);
      return this;
    }
    public APIRequestGetAudiences requestIsValueBasedField () {
      return this.requestIsValueBasedField(true);
    }
    public APIRequestGetAudiences requestIsValueBasedField (boolean value) {
      this.requestField("is_value_based", value);
      return this;
    }
    public APIRequestGetAudiences requestLookalikeAudienceIdsField () {
      return this.requestLookalikeAudienceIdsField(true);
    }
    public APIRequestGetAudiences requestLookalikeAudienceIdsField (boolean value) {
      this.requestField("lookalike_audience_ids", value);
      return this;
    }
    public APIRequestGetAudiences requestLookalikeSpecField () {
      return this.requestLookalikeSpecField(true);
    }
    public APIRequestGetAudiences requestLookalikeSpecField (boolean value) {
      this.requestField("lookalike_spec", value);
      return this;
    }
    public APIRequestGetAudiences requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAudiences requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAudiences requestOperationStatusField () {
      return this.requestOperationStatusField(true);
    }
    public APIRequestGetAudiences requestOperationStatusField (boolean value) {
      this.requestField("operation_status", value);
      return this;
    }
    public APIRequestGetAudiences requestOptOutLinkField () {
      return this.requestOptOutLinkField(true);
    }
    public APIRequestGetAudiences requestOptOutLinkField (boolean value) {
      this.requestField("opt_out_link", value);
      return this;
    }
    public APIRequestGetAudiences requestPermissionForActionsField () {
      return this.requestPermissionForActionsField(true);
    }
    public APIRequestGetAudiences requestPermissionForActionsField (boolean value) {
      this.requestField("permission_for_actions", value);
      return this;
    }
    public APIRequestGetAudiences requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGetAudiences requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGetAudiences requestRegulatedAudienceSpecField () {
      return this.requestRegulatedAudienceSpecField(true);
    }
    public APIRequestGetAudiences requestRegulatedAudienceSpecField (boolean value) {
      this.requestField("regulated_audience_spec", value);
      return this;
    }
    public APIRequestGetAudiences requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGetAudiences requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGetAudiences requestRevSharePolicyIdField () {
      return this.requestRevSharePolicyIdField(true);
    }
    public APIRequestGetAudiences requestRevSharePolicyIdField (boolean value) {
      this.requestField("rev_share_policy_id", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGetAudiences requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleAggregationField () {
      return this.requestRuleAggregationField(true);
    }
    public APIRequestGetAudiences requestRuleAggregationField (boolean value) {
      this.requestField("rule_aggregation", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleV2Field () {
      return this.requestRuleV2Field(true);
    }
    public APIRequestGetAudiences requestRuleV2Field (boolean value) {
      this.requestField("rule_v2", value);
      return this;
    }
    public APIRequestGetAudiences requestSeedAudienceField () {
      return this.requestSeedAudienceField(true);
    }
    public APIRequestGetAudiences requestSeedAudienceField (boolean value) {
      this.requestField("seed_audience", value);
      return this;
    }
    public APIRequestGetAudiences requestSharingStatusField () {
      return this.requestSharingStatusField(true);
    }
    public APIRequestGetAudiences requestSharingStatusField (boolean value) {
      this.requestField("sharing_status", value);
      return this;
    }
    public APIRequestGetAudiences requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGetAudiences requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGetAudiences requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetAudiences requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetAudiences requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
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
      "ad_account",
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
      "is_unavailable",
      "last_fired_time",
      "name",
      "offline_conversion_data_set",
      "pixel",
      "retention_days",
      "rule",
    };

    @Override
    public APINodeList<CustomConversion> parseResponse(String response, String header) throws APIException {
      return CustomConversion.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CustomConversion> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversion> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversion>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CustomConversion>>() {
           public APINodeList<CustomConversion> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCustomConversions.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetCustomConversions setAdAccount (String adAccount) {
      this.setParam("ad_account", adAccount);
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
    public APIRequestGetCustomConversions requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetCustomConversions requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
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

  public static class APIRequestCreateEvent extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "data",
      "namespace_id",
      "progress",
      "upload_id",
      "upload_source",
      "upload_tag",
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
               return APIRequestCreateEvent.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateEvent(String nodeId, APIContext context) {
      super(context, nodeId, "/events", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateEvent setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateEvent setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateEvent setData (List<String> data) {
      this.setParam("data", data);
      return this;
    }
    public APIRequestCreateEvent setData (String data) {
      this.setParam("data", data);
      return this;
    }

    public APIRequestCreateEvent setNamespaceId (String namespaceId) {
      this.setParam("namespace_id", namespaceId);
      return this;
    }

    public APIRequestCreateEvent setProgress (Object progress) {
      this.setParam("progress", progress);
      return this;
    }
    public APIRequestCreateEvent setProgress (String progress) {
      this.setParam("progress", progress);
      return this;
    }

    public APIRequestCreateEvent setUploadId (String uploadId) {
      this.setParam("upload_id", uploadId);
      return this;
    }

    public APIRequestCreateEvent setUploadSource (String uploadSource) {
      this.setParam("upload_source", uploadSource);
      return this;
    }

    public APIRequestCreateEvent setUploadTag (String uploadTag) {
      this.setParam("upload_tag", uploadTag);
      return this;
    }

    public APIRequestCreateEvent requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateEvent requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEvent requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateEvent requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEvent requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateEvent requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetStats extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggr_time",
      "end",
      "granularity",
      "skip_empty_values",
      "start",
      "user_timezone_id",
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
               return APIRequestGetStats.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetStats(String nodeId, APIContext context) {
      super(context, nodeId, "/stats", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStats setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStats setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStats setAggrTime (EnumAggrTime aggrTime) {
      this.setParam("aggr_time", aggrTime);
      return this;
    }
    public APIRequestGetStats setAggrTime (String aggrTime) {
      this.setParam("aggr_time", aggrTime);
      return this;
    }

    public APIRequestGetStats setEnd (Long end) {
      this.setParam("end", end);
      return this;
    }
    public APIRequestGetStats setEnd (String end) {
      this.setParam("end", end);
      return this;
    }

    public APIRequestGetStats setGranularity (EnumGranularity granularity) {
      this.setParam("granularity", granularity);
      return this;
    }
    public APIRequestGetStats setGranularity (String granularity) {
      this.setParam("granularity", granularity);
      return this;
    }

    public APIRequestGetStats setSkipEmptyValues (Boolean skipEmptyValues) {
      this.setParam("skip_empty_values", skipEmptyValues);
      return this;
    }
    public APIRequestGetStats setSkipEmptyValues (String skipEmptyValues) {
      this.setParam("skip_empty_values", skipEmptyValues);
      return this;
    }

    public APIRequestGetStats setStart (Long start) {
      this.setParam("start", start);
      return this;
    }
    public APIRequestGetStats setStart (String start) {
      this.setParam("start", start);
      return this;
    }

    public APIRequestGetStats setUserTimezoneId (Long userTimezoneId) {
      this.setParam("user_timezone_id", userTimezoneId);
      return this;
    }
    public APIRequestGetStats setUserTimezoneId (String userTimezoneId) {
      this.setParam("user_timezone_id", userTimezoneId);
      return this;
    }

    public APIRequestGetStats requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStats requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStats requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStats requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStats requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStats requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUploads extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "order",
      "sort_by",
      "start_time",
      "upload_tag",
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
               return APIRequestGetUploads.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUploads(String nodeId, APIContext context) {
      super(context, nodeId, "/uploads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUploads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUploads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUploads setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetUploads setOrder (EnumOrder order) {
      this.setParam("order", order);
      return this;
    }
    public APIRequestGetUploads setOrder (String order) {
      this.setParam("order", order);
      return this;
    }

    public APIRequestGetUploads setSortBy (EnumSortBy sortBy) {
      this.setParam("sort_by", sortBy);
      return this;
    }
    public APIRequestGetUploads setSortBy (String sortBy) {
      this.setParam("sort_by", sortBy);
      return this;
    }

    public APIRequestGetUploads setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestGetUploads setUploadTag (String uploadTag) {
      this.setParam("upload_tag", uploadTag);
      return this;
    }

    public APIRequestGetUploads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUploads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUploads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUploads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUploads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUploads requestField (String field, boolean value) {
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
      "upload_tag",
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


    public APIRequestCreateUpload setUploadTag (String uploadTag) {
      this.setParam("upload_tag", uploadTag);
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

  public static class APIRequestCreateValidate extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "data",
      "namespace_id",
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
               return APIRequestCreateValidate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateValidate(String nodeId, APIContext context) {
      super(context, nodeId, "/validate", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateValidate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateValidate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateValidate setData (List<String> data) {
      this.setParam("data", data);
      return this;
    }
    public APIRequestCreateValidate setData (String data) {
      this.setParam("data", data);
      return this;
    }

    public APIRequestCreateValidate setNamespaceId (String namespaceId) {
      this.setParam("namespace_id", namespaceId);
      return this;
    }

    public APIRequestCreateValidate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateValidate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateValidate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateValidate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateValidate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateValidate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDelete extends APIRequest<APINode> {

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
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGet requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGet requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGet requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGet requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGet requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGet requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGet requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGet requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGet requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGet requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGet requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGet requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGet requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGet requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGet requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGet requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGet requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGet requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGet requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGet requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGet requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGet requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGet requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGet requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGet requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGet requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "auto_assign_to_new_accounts_only",
      "description",
      "enable_auto_assign_to_accounts",
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


    public APIRequestUpdate setAutoAssignToNewAccountsOnly (Boolean autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }
    public APIRequestUpdate setAutoAssignToNewAccountsOnly (String autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setEnableAutoAssignToAccounts (Boolean enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }
    public APIRequestUpdate setEnableAutoAssignToAccounts (String enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("UPLOADER")
      VALUE_UPLOADER("UPLOADER"),
      ;

      private String value;

      private EnumPermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRelationshipType {
      @SerializedName("AD_MANAGER")
      VALUE_AD_MANAGER("AD_MANAGER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("AGGREGATOR")
      VALUE_AGGREGATOR("AGGREGATOR"),
      @SerializedName("AUDIENCE_MANAGER")
      VALUE_AUDIENCE_MANAGER("AUDIENCE_MANAGER"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      ;

      private String value;

      private EnumRelationshipType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAggrTime {
      @SerializedName("event_time")
      VALUE_EVENT_TIME("event_time"),
      @SerializedName("upload_time")
      VALUE_UPLOAD_TIME("upload_time"),
      ;

      private String value;

      private EnumAggrTime(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGranularity {
      @SerializedName("daily")
      VALUE_DAILY("daily"),
      @SerializedName("hourly")
      VALUE_HOURLY("hourly"),
      @SerializedName("six_hourly")
      VALUE_SIX_HOURLY("six_hourly"),
      ;

      private String value;

      private EnumGranularity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOrder {
      @SerializedName("ASCENDING")
      VALUE_ASCENDING("ASCENDING"),
      @SerializedName("DESCENDING")
      VALUE_DESCENDING("DESCENDING"),
      ;

      private String value;

      private EnumOrder(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSortBy {
      @SerializedName("API_CALLS")
      VALUE_API_CALLS("API_CALLS"),
      @SerializedName("CREATION_TIME")
      VALUE_CREATION_TIME("CREATION_TIME"),
      @SerializedName("EVENT_TIME_MAX")
      VALUE_EVENT_TIME_MAX("EVENT_TIME_MAX"),
      @SerializedName("EVENT_TIME_MIN")
      VALUE_EVENT_TIME_MIN("EVENT_TIME_MIN"),
      @SerializedName("FIRST_UPLOAD_TIME")
      VALUE_FIRST_UPLOAD_TIME("FIRST_UPLOAD_TIME"),
      @SerializedName("IS_EXCLUDED_FOR_LIFT")
      VALUE_IS_EXCLUDED_FOR_LIFT("IS_EXCLUDED_FOR_LIFT"),
      @SerializedName("LAST_UPLOAD_TIME")
      VALUE_LAST_UPLOAD_TIME("LAST_UPLOAD_TIME"),
      ;

      private String value;

      private EnumSortBy(String value) {
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

  public OfflineConversionDataSet copyFrom(OfflineConversionDataSet instance) {
    this.mBusiness = instance.mBusiness;
    this.mConfig = instance.mConfig;
    this.mCreationTime = instance.mCreationTime;
    this.mDescription = instance.mDescription;
    this.mDuplicateEntries = instance.mDuplicateEntries;
    this.mEnableAutoAssignToAccounts = instance.mEnableAutoAssignToAccounts;
    this.mEventStats = instance.mEventStats;
    this.mEventTimeMax = instance.mEventTimeMax;
    this.mEventTimeMin = instance.mEventTimeMin;
    this.mId = instance.mId;
    this.mIsMtaUse = instance.mIsMtaUse;
    this.mIsRestrictedUse = instance.mIsRestrictedUse;
    this.mIsUnavailable = instance.mIsUnavailable;
    this.mLastUploadApp = instance.mLastUploadApp;
    this.mLastUploadAppChangedTime = instance.mLastUploadAppChangedTime;
    this.mMatchRateApprox = instance.mMatchRateApprox;
    this.mMatchedEntries = instance.mMatchedEntries;
    this.mName = instance.mName;
    this.mUsage = instance.mUsage;
    this.mValidEntries = instance.mValidEntries;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OfflineConversionDataSet> getParser() {
    return new APIRequest.ResponseParser<OfflineConversionDataSet>() {
      public APINodeList<OfflineConversionDataSet> parseResponse(String response, APIContext context, APIRequest<OfflineConversionDataSet> request, String header) throws MalformedResponseException {
        return OfflineConversionDataSet.parseResponse(response, context, request, header);
      }
    };
  }
}
