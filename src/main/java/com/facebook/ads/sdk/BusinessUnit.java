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
public class BusinessUnit extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("excluded_sources")
  private Object mExcludedSources = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_enabled_for_measurement")
  private Boolean mIsEnabledForMeasurement = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("time_zone")
  private String mTimeZone = null;
  @SerializedName("visits_available_date")
  private Long mVisitsAvailableDate = null;
  protected static Gson gson = null;

  BusinessUnit() {
  }

  public BusinessUnit(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessUnit(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessUnit fetch() throws APIException{
    BusinessUnit newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessUnit fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessUnit> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessUnit fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessUnit> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessUnit> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessUnit>)(
      new APIRequest<BusinessUnit>(context, "", "/", "GET", BusinessUnit.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessUnit>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessUnit.getParser())
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
  public static BusinessUnit loadJSON(String json, APIContext context, String header) {
    BusinessUnit businessUnit = getGson().fromJson(json, BusinessUnit.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessUnit.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessUnit.context = context;
    businessUnit.rawValue = json;
    businessUnit.header = header;
    return businessUnit;
  }

  public static APINodeList<BusinessUnit> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessUnit> businessUnits = new APINodeList<BusinessUnit>(request, json, header);
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
          businessUnits.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessUnits;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessUnits.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessUnits.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessUnits.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessUnits.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessUnits.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessUnits.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessUnits;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessUnits.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessUnits;
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
              businessUnits.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessUnits;
          }

          // Sixth, check if it's pure JsonObject
          businessUnits.clear();
          businessUnits.add(loadJSON(json, context, header));
          return businessUnits;
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

  public APIRequestGetAdPlatforms getAdPlatforms() {
    return new APIRequestGetAdPlatforms(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAtlasSalesAccesses getAtlasSalesAccesses() {
    return new APIRequestGetAtlasSalesAccesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAtlasSalesAccess createAtlasSalesAccess() {
    return new APIRequestCreateAtlasSalesAccess(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCampaigns getCampaigns() {
    return new APIRequestGetCampaigns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversionEvents getConversionEvents() {
    return new APIRequestGetConversionEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversionPaths getConversionPaths() {
    return new APIRequestGetConversionPaths(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCustomBreakdowns getCustomBreakdowns() {
    return new APIRequestGetCustomBreakdowns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDiagnostics getDiagnostics() {
    return new APIRequestGetDiagnostics(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExternalImportFile getExternalImportFile() {
    return new APIRequestGetExternalImportFile(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReports getReports() {
    return new APIRequestGetReports(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSources getSources() {
    return new APIRequestGetSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUsers getUsers() {
    return new APIRequestGetUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public Object getFieldExcludedSources() {
    return mExcludedSources;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsEnabledForMeasurement() {
    return mIsEnabledForMeasurement;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldTimeZone() {
    return mTimeZone;
  }

  public Long getFieldVisitsAvailableDate() {
    return mVisitsAvailableDate;
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
      super(context, nodeId, "/ad_accounts", "GET", Arrays.asList(PARAMS));
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

  public static class APIRequestGetAdPlatforms extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
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
               return APIRequestGetAdPlatforms.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdPlatforms(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_platforms", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdPlatforms setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdPlatforms setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdPlatforms setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetAdPlatforms setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetAdPlatforms setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetAdPlatforms setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetAdPlatforms requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdPlatforms requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlatforms requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdPlatforms requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdPlatforms requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdPlatforms requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAtlasSalesAccesses extends APIRequest<APINode> {

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
               return APIRequestGetAtlasSalesAccesses.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAtlasSalesAccesses(String nodeId, APIContext context) {
      super(context, nodeId, "/atlas_sales_accesses", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAtlasSalesAccesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAtlasSalesAccesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAtlasSalesAccesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAtlasSalesAccesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAtlasSalesAccesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAtlasSalesAccesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAtlasSalesAccesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAtlasSalesAccesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAtlasSalesAccess extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "access_request_id",
      "status",
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
               return APIRequestCreateAtlasSalesAccess.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAtlasSalesAccess(String nodeId, APIContext context) {
      super(context, nodeId, "/atlas_sales_accesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAtlasSalesAccess setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAtlasSalesAccess setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAtlasSalesAccess setAccessRequestId (String accessRequestId) {
      this.setParam("access_request_id", accessRequestId);
      return this;
    }

    public APIRequestCreateAtlasSalesAccess setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateAtlasSalesAccess requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAtlasSalesAccess requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAtlasSalesAccess requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAtlasSalesAccess requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAtlasSalesAccess requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAtlasSalesAccess requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCampaigns extends APIRequest<AtlasCampaign> {

    APINodeList<AtlasCampaign> lastResponse = null;
    @Override
    public APINodeList<AtlasCampaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
    };

    public static final String[] FIELDS = {
      "ad_platform",
      "alias",
      "cost_per_1k_impressions",
      "cost_per_click",
      "cost_per_visit",
      "created_by",
      "created_date",
      "data_driven_convs",
      "data_driven_convs_per_1k_impress",
      "data_driven_convs_per_click",
      "data_driven_convs_per_visit",
      "data_driven_cpa",
      "data_driven_nullable_convs",
      "data_driven_revenue",
      "data_driven_roas",
      "even_credit_convs",
      "even_credit_convs_per_1k_impress",
      "even_credit_convs_per_click",
      "even_credit_convs_per_visit",
      "even_credit_cpa",
      "even_credit_revenue",
      "even_credit_roas",
      "first_click_convs",
      "first_click_convs_per_1k_impress",
      "first_click_convs_per_click",
      "first_click_convs_per_visit",
      "first_click_cpa",
      "first_click_revenue",
      "first_click_roas",
      "first_touch_convs",
      "first_touch_convs_per_1k_impress",
      "first_touch_convs_per_click",
      "first_touch_convs_per_visit",
      "first_touch_cpa",
      "first_touch_revenue",
      "first_touch_roas",
      "id",
      "is_archived",
      "last_click_convs",
      "last_click_convs_per_1k_impress",
      "last_click_convs_per_click",
      "last_click_convs_per_visit",
      "last_click_cpa",
      "last_click_revenue",
      "last_click_roas",
      "last_click_with_extrapolation_convs",
      "last_click_with_extrapolation_convs_per_100_clicks",
      "last_click_with_extrapolation_convs_per_1k_impress",
      "last_click_with_extrapolation_convs_per_click",
      "last_click_with_extrapolation_convs_per_visit",
      "last_click_with_extrapolation_cpa",
      "last_click_with_extrapolation_revenue",
      "last_click_with_extrapolation_roas",
      "last_click_with_extrapolation_unattributed",
      "last_modified_by",
      "last_modified_date",
      "last_touch_convs",
      "last_touch_convs_per_1k_impress",
      "last_touch_convs_per_click",
      "last_touch_convs_per_visit",
      "last_touch_cpa",
      "last_touch_revenue",
      "last_touch_roas",
      "name",
      "net_media_cost",
      "positional_30fl_convs",
      "positional_30fl_convs_per_1k_impress",
      "positional_30fl_convs_per_click",
      "positional_30fl_convs_per_visit",
      "positional_30fl_cpa",
      "positional_30fl_revenue",
      "positional_30fl_roas",
      "positional_40fl_convs",
      "positional_40fl_convs_per_1k_impress",
      "positional_40fl_convs_per_click",
      "positional_40fl_convs_per_visit",
      "positional_40fl_cpa",
      "positional_40fl_revenue",
      "positional_40fl_roas",
      "report_click_through_rate",
      "report_clicks",
      "report_impressions",
      "report_visits",
      "time_decay_1day_convs",
      "time_decay_1day_convs_per_1k_impress",
      "time_decay_1day_convs_per_click",
      "time_decay_1day_convs_per_visit",
      "time_decay_1day_cpa",
      "time_decay_1day_revenue",
      "time_decay_1day_roas",
      "time_decay_7day_convs",
      "time_decay_7day_convs_per_1k_impress",
      "time_decay_7day_convs_per_click",
      "time_decay_7day_convs_per_visit",
      "time_decay_7day_cpa",
      "time_decay_7day_revenue",
      "time_decay_7day_roas",
      "type",
    };

    @Override
    public APINodeList<AtlasCampaign> parseResponse(String response, String header) throws APIException {
      return AtlasCampaign.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AtlasCampaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AtlasCampaign> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AtlasCampaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AtlasCampaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AtlasCampaign>>() {
           public APINodeList<AtlasCampaign> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCampaigns.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetCampaigns setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetCampaigns setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetCampaigns setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetCampaigns setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
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

    public APIRequestGetCampaigns requestAdPlatformField () {
      return this.requestAdPlatformField(true);
    }
    public APIRequestGetCampaigns requestAdPlatformField (boolean value) {
      this.requestField("ad_platform", value);
      return this;
    }
    public APIRequestGetCampaigns requestAliasField () {
      return this.requestAliasField(true);
    }
    public APIRequestGetCampaigns requestAliasField (boolean value) {
      this.requestField("alias", value);
      return this;
    }
    public APIRequestGetCampaigns requestCostPer1kImpressionsField () {
      return this.requestCostPer1kImpressionsField(true);
    }
    public APIRequestGetCampaigns requestCostPer1kImpressionsField (boolean value) {
      this.requestField("cost_per_1k_impressions", value);
      return this;
    }
    public APIRequestGetCampaigns requestCostPerClickField () {
      return this.requestCostPerClickField(true);
    }
    public APIRequestGetCampaigns requestCostPerClickField (boolean value) {
      this.requestField("cost_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestCostPerVisitField () {
      return this.requestCostPerVisitField(true);
    }
    public APIRequestGetCampaigns requestCostPerVisitField (boolean value) {
      this.requestField("cost_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetCampaigns requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetCampaigns requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGetCampaigns requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenConvsField () {
      return this.requestDataDrivenConvsField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenConvsField (boolean value) {
      this.requestField("data_driven_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPer1kImpressField () {
      return this.requestDataDrivenConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPer1kImpressField (boolean value) {
      this.requestField("data_driven_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPerClickField () {
      return this.requestDataDrivenConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPerClickField (boolean value) {
      this.requestField("data_driven_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPerVisitField () {
      return this.requestDataDrivenConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenConvsPerVisitField (boolean value) {
      this.requestField("data_driven_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenCpaField () {
      return this.requestDataDrivenCpaField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenCpaField (boolean value) {
      this.requestField("data_driven_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenNullableConvsField () {
      return this.requestDataDrivenNullableConvsField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenNullableConvsField (boolean value) {
      this.requestField("data_driven_nullable_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenRevenueField () {
      return this.requestDataDrivenRevenueField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenRevenueField (boolean value) {
      this.requestField("data_driven_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestDataDrivenRoasField () {
      return this.requestDataDrivenRoasField(true);
    }
    public APIRequestGetCampaigns requestDataDrivenRoasField (boolean value) {
      this.requestField("data_driven_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditConvsField () {
      return this.requestEvenCreditConvsField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditConvsField (boolean value) {
      this.requestField("even_credit_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPer1kImpressField () {
      return this.requestEvenCreditConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPer1kImpressField (boolean value) {
      this.requestField("even_credit_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPerClickField () {
      return this.requestEvenCreditConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPerClickField (boolean value) {
      this.requestField("even_credit_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPerVisitField () {
      return this.requestEvenCreditConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditConvsPerVisitField (boolean value) {
      this.requestField("even_credit_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditCpaField () {
      return this.requestEvenCreditCpaField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditCpaField (boolean value) {
      this.requestField("even_credit_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditRevenueField () {
      return this.requestEvenCreditRevenueField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditRevenueField (boolean value) {
      this.requestField("even_credit_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestEvenCreditRoasField () {
      return this.requestEvenCreditRoasField(true);
    }
    public APIRequestGetCampaigns requestEvenCreditRoasField (boolean value) {
      this.requestField("even_credit_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickConvsField () {
      return this.requestFirstClickConvsField(true);
    }
    public APIRequestGetCampaigns requestFirstClickConvsField (boolean value) {
      this.requestField("first_click_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickConvsPer1kImpressField () {
      return this.requestFirstClickConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestFirstClickConvsPer1kImpressField (boolean value) {
      this.requestField("first_click_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickConvsPerClickField () {
      return this.requestFirstClickConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestFirstClickConvsPerClickField (boolean value) {
      this.requestField("first_click_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickConvsPerVisitField () {
      return this.requestFirstClickConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestFirstClickConvsPerVisitField (boolean value) {
      this.requestField("first_click_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickCpaField () {
      return this.requestFirstClickCpaField(true);
    }
    public APIRequestGetCampaigns requestFirstClickCpaField (boolean value) {
      this.requestField("first_click_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickRevenueField () {
      return this.requestFirstClickRevenueField(true);
    }
    public APIRequestGetCampaigns requestFirstClickRevenueField (boolean value) {
      this.requestField("first_click_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstClickRoasField () {
      return this.requestFirstClickRoasField(true);
    }
    public APIRequestGetCampaigns requestFirstClickRoasField (boolean value) {
      this.requestField("first_click_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchConvsField () {
      return this.requestFirstTouchConvsField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchConvsField (boolean value) {
      this.requestField("first_touch_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPer1kImpressField () {
      return this.requestFirstTouchConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPer1kImpressField (boolean value) {
      this.requestField("first_touch_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPerClickField () {
      return this.requestFirstTouchConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPerClickField (boolean value) {
      this.requestField("first_touch_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPerVisitField () {
      return this.requestFirstTouchConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchConvsPerVisitField (boolean value) {
      this.requestField("first_touch_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchCpaField () {
      return this.requestFirstTouchCpaField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchCpaField (boolean value) {
      this.requestField("first_touch_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchRevenueField () {
      return this.requestFirstTouchRevenueField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchRevenueField (boolean value) {
      this.requestField("first_touch_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestFirstTouchRoasField () {
      return this.requestFirstTouchRoasField(true);
    }
    public APIRequestGetCampaigns requestFirstTouchRoasField (boolean value) {
      this.requestField("first_touch_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaigns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaigns requestIsArchivedField () {
      return this.requestIsArchivedField(true);
    }
    public APIRequestGetCampaigns requestIsArchivedField (boolean value) {
      this.requestField("is_archived", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickConvsField () {
      return this.requestLastClickConvsField(true);
    }
    public APIRequestGetCampaigns requestLastClickConvsField (boolean value) {
      this.requestField("last_click_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickConvsPer1kImpressField () {
      return this.requestLastClickConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestLastClickConvsPer1kImpressField (boolean value) {
      this.requestField("last_click_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickConvsPerClickField () {
      return this.requestLastClickConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestLastClickConvsPerClickField (boolean value) {
      this.requestField("last_click_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickConvsPerVisitField () {
      return this.requestLastClickConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestLastClickConvsPerVisitField (boolean value) {
      this.requestField("last_click_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickCpaField () {
      return this.requestLastClickCpaField(true);
    }
    public APIRequestGetCampaigns requestLastClickCpaField (boolean value) {
      this.requestField("last_click_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickRevenueField () {
      return this.requestLastClickRevenueField(true);
    }
    public APIRequestGetCampaigns requestLastClickRevenueField (boolean value) {
      this.requestField("last_click_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickRoasField () {
      return this.requestLastClickRoasField(true);
    }
    public APIRequestGetCampaigns requestLastClickRoasField (boolean value) {
      this.requestField("last_click_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsField () {
      return this.requestLastClickWithExtrapolationConvsField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPer100ClicksField () {
      return this.requestLastClickWithExtrapolationConvsPer100ClicksField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPer100ClicksField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_100_clicks", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPer1kImpressField () {
      return this.requestLastClickWithExtrapolationConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPer1kImpressField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPerClickField () {
      return this.requestLastClickWithExtrapolationConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPerClickField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPerVisitField () {
      return this.requestLastClickWithExtrapolationConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationConvsPerVisitField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationCpaField () {
      return this.requestLastClickWithExtrapolationCpaField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationCpaField (boolean value) {
      this.requestField("last_click_with_extrapolation_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationRevenueField () {
      return this.requestLastClickWithExtrapolationRevenueField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationRevenueField (boolean value) {
      this.requestField("last_click_with_extrapolation_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationRoasField () {
      return this.requestLastClickWithExtrapolationRoasField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationRoasField (boolean value) {
      this.requestField("last_click_with_extrapolation_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationUnattributedField () {
      return this.requestLastClickWithExtrapolationUnattributedField(true);
    }
    public APIRequestGetCampaigns requestLastClickWithExtrapolationUnattributedField (boolean value) {
      this.requestField("last_click_with_extrapolation_unattributed", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastModifiedByField () {
      return this.requestLastModifiedByField(true);
    }
    public APIRequestGetCampaigns requestLastModifiedByField (boolean value) {
      this.requestField("last_modified_by", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastModifiedDateField () {
      return this.requestLastModifiedDateField(true);
    }
    public APIRequestGetCampaigns requestLastModifiedDateField (boolean value) {
      this.requestField("last_modified_date", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchConvsField () {
      return this.requestLastTouchConvsField(true);
    }
    public APIRequestGetCampaigns requestLastTouchConvsField (boolean value) {
      this.requestField("last_touch_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchConvsPer1kImpressField () {
      return this.requestLastTouchConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestLastTouchConvsPer1kImpressField (boolean value) {
      this.requestField("last_touch_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchConvsPerClickField () {
      return this.requestLastTouchConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestLastTouchConvsPerClickField (boolean value) {
      this.requestField("last_touch_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchConvsPerVisitField () {
      return this.requestLastTouchConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestLastTouchConvsPerVisitField (boolean value) {
      this.requestField("last_touch_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchCpaField () {
      return this.requestLastTouchCpaField(true);
    }
    public APIRequestGetCampaigns requestLastTouchCpaField (boolean value) {
      this.requestField("last_touch_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchRevenueField () {
      return this.requestLastTouchRevenueField(true);
    }
    public APIRequestGetCampaigns requestLastTouchRevenueField (boolean value) {
      this.requestField("last_touch_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestLastTouchRoasField () {
      return this.requestLastTouchRoasField(true);
    }
    public APIRequestGetCampaigns requestLastTouchRoasField (boolean value) {
      this.requestField("last_touch_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCampaigns requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCampaigns requestNetMediaCostField () {
      return this.requestNetMediaCostField(true);
    }
    public APIRequestGetCampaigns requestNetMediaCostField (boolean value) {
      this.requestField("net_media_cost", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flConvsField () {
      return this.requestPositional30flConvsField(true);
    }
    public APIRequestGetCampaigns requestPositional30flConvsField (boolean value) {
      this.requestField("positional_30fl_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flConvsPer1kImpressField () {
      return this.requestPositional30flConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestPositional30flConvsPer1kImpressField (boolean value) {
      this.requestField("positional_30fl_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flConvsPerClickField () {
      return this.requestPositional30flConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestPositional30flConvsPerClickField (boolean value) {
      this.requestField("positional_30fl_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flConvsPerVisitField () {
      return this.requestPositional30flConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestPositional30flConvsPerVisitField (boolean value) {
      this.requestField("positional_30fl_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flCpaField () {
      return this.requestPositional30flCpaField(true);
    }
    public APIRequestGetCampaigns requestPositional30flCpaField (boolean value) {
      this.requestField("positional_30fl_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flRevenueField () {
      return this.requestPositional30flRevenueField(true);
    }
    public APIRequestGetCampaigns requestPositional30flRevenueField (boolean value) {
      this.requestField("positional_30fl_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional30flRoasField () {
      return this.requestPositional30flRoasField(true);
    }
    public APIRequestGetCampaigns requestPositional30flRoasField (boolean value) {
      this.requestField("positional_30fl_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flConvsField () {
      return this.requestPositional40flConvsField(true);
    }
    public APIRequestGetCampaigns requestPositional40flConvsField (boolean value) {
      this.requestField("positional_40fl_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flConvsPer1kImpressField () {
      return this.requestPositional40flConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestPositional40flConvsPer1kImpressField (boolean value) {
      this.requestField("positional_40fl_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flConvsPerClickField () {
      return this.requestPositional40flConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestPositional40flConvsPerClickField (boolean value) {
      this.requestField("positional_40fl_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flConvsPerVisitField () {
      return this.requestPositional40flConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestPositional40flConvsPerVisitField (boolean value) {
      this.requestField("positional_40fl_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flCpaField () {
      return this.requestPositional40flCpaField(true);
    }
    public APIRequestGetCampaigns requestPositional40flCpaField (boolean value) {
      this.requestField("positional_40fl_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flRevenueField () {
      return this.requestPositional40flRevenueField(true);
    }
    public APIRequestGetCampaigns requestPositional40flRevenueField (boolean value) {
      this.requestField("positional_40fl_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestPositional40flRoasField () {
      return this.requestPositional40flRoasField(true);
    }
    public APIRequestGetCampaigns requestPositional40flRoasField (boolean value) {
      this.requestField("positional_40fl_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestReportClickThroughRateField () {
      return this.requestReportClickThroughRateField(true);
    }
    public APIRequestGetCampaigns requestReportClickThroughRateField (boolean value) {
      this.requestField("report_click_through_rate", value);
      return this;
    }
    public APIRequestGetCampaigns requestReportClicksField () {
      return this.requestReportClicksField(true);
    }
    public APIRequestGetCampaigns requestReportClicksField (boolean value) {
      this.requestField("report_clicks", value);
      return this;
    }
    public APIRequestGetCampaigns requestReportImpressionsField () {
      return this.requestReportImpressionsField(true);
    }
    public APIRequestGetCampaigns requestReportImpressionsField (boolean value) {
      this.requestField("report_impressions", value);
      return this;
    }
    public APIRequestGetCampaigns requestReportVisitsField () {
      return this.requestReportVisitsField(true);
    }
    public APIRequestGetCampaigns requestReportVisitsField (boolean value) {
      this.requestField("report_visits", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsField () {
      return this.requestTimeDecay1dayConvsField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsField (boolean value) {
      this.requestField("time_decay_1day_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPer1kImpressField () {
      return this.requestTimeDecay1dayConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPer1kImpressField (boolean value) {
      this.requestField("time_decay_1day_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPerClickField () {
      return this.requestTimeDecay1dayConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPerClickField (boolean value) {
      this.requestField("time_decay_1day_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPerVisitField () {
      return this.requestTimeDecay1dayConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayConvsPerVisitField (boolean value) {
      this.requestField("time_decay_1day_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayCpaField () {
      return this.requestTimeDecay1dayCpaField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayCpaField (boolean value) {
      this.requestField("time_decay_1day_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayRevenueField () {
      return this.requestTimeDecay1dayRevenueField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayRevenueField (boolean value) {
      this.requestField("time_decay_1day_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay1dayRoasField () {
      return this.requestTimeDecay1dayRoasField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay1dayRoasField (boolean value) {
      this.requestField("time_decay_1day_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsField () {
      return this.requestTimeDecay7dayConvsField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsField (boolean value) {
      this.requestField("time_decay_7day_convs", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPer1kImpressField () {
      return this.requestTimeDecay7dayConvsPer1kImpressField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPer1kImpressField (boolean value) {
      this.requestField("time_decay_7day_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPerClickField () {
      return this.requestTimeDecay7dayConvsPerClickField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPerClickField (boolean value) {
      this.requestField("time_decay_7day_convs_per_click", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPerVisitField () {
      return this.requestTimeDecay7dayConvsPerVisitField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayConvsPerVisitField (boolean value) {
      this.requestField("time_decay_7day_convs_per_visit", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayCpaField () {
      return this.requestTimeDecay7dayCpaField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayCpaField (boolean value) {
      this.requestField("time_decay_7day_cpa", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayRevenueField () {
      return this.requestTimeDecay7dayRevenueField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayRevenueField (boolean value) {
      this.requestField("time_decay_7day_revenue", value);
      return this;
    }
    public APIRequestGetCampaigns requestTimeDecay7dayRoasField () {
      return this.requestTimeDecay7dayRoasField(true);
    }
    public APIRequestGetCampaigns requestTimeDecay7dayRoasField (boolean value) {
      this.requestField("time_decay_7day_roas", value);
      return this;
    }
    public APIRequestGetCampaigns requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetCampaigns requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestGetConversionEvents extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
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
               return APIRequestGetConversionEvents.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetConversionEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/conversion_events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConversionEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConversionEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConversionEvents setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetConversionEvents setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetConversionEvents setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetConversionEvents setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetConversionEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConversionEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversionEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConversionEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversionEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConversionEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetConversionPaths extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "click_lookback_window",
      "date_range",
      "fb_conversion_event_id",
      "limit",
      "metric_context",
      "time_period",
      "view_lookback_window",
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
               return APIRequestGetConversionPaths.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetConversionPaths(String nodeId, APIContext context) {
      super(context, nodeId, "/conversion_paths", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConversionPaths setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConversionPaths setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConversionPaths setClickLookbackWindow (Long clickLookbackWindow) {
      this.setParam("click_lookback_window", clickLookbackWindow);
      return this;
    }
    public APIRequestGetConversionPaths setClickLookbackWindow (String clickLookbackWindow) {
      this.setParam("click_lookback_window", clickLookbackWindow);
      return this;
    }

    public APIRequestGetConversionPaths setDateRange (Map<String, String> dateRange) {
      this.setParam("date_range", dateRange);
      return this;
    }
    public APIRequestGetConversionPaths setDateRange (String dateRange) {
      this.setParam("date_range", dateRange);
      return this;
    }

    public APIRequestGetConversionPaths setFbConversionEventId (Long fbConversionEventId) {
      this.setParam("fb_conversion_event_id", fbConversionEventId);
      return this;
    }
    public APIRequestGetConversionPaths setFbConversionEventId (String fbConversionEventId) {
      this.setParam("fb_conversion_event_id", fbConversionEventId);
      return this;
    }

    public APIRequestGetConversionPaths setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestGetConversionPaths setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetConversionPaths setMetricContext (Map<String, String> metricContext) {
      this.setParam("metric_context", metricContext);
      return this;
    }
    public APIRequestGetConversionPaths setMetricContext (String metricContext) {
      this.setParam("metric_context", metricContext);
      return this;
    }

    public APIRequestGetConversionPaths setTimePeriod (EnumTimePeriod timePeriod) {
      this.setParam("time_period", timePeriod);
      return this;
    }
    public APIRequestGetConversionPaths setTimePeriod (String timePeriod) {
      this.setParam("time_period", timePeriod);
      return this;
    }

    public APIRequestGetConversionPaths setViewLookbackWindow (Long viewLookbackWindow) {
      this.setParam("view_lookback_window", viewLookbackWindow);
      return this;
    }
    public APIRequestGetConversionPaths setViewLookbackWindow (String viewLookbackWindow) {
      this.setParam("view_lookback_window", viewLookbackWindow);
      return this;
    }

    public APIRequestGetConversionPaths requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConversionPaths requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversionPaths requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConversionPaths requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversionPaths requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConversionPaths requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCustomBreakdowns extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "order_by",
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
               return APIRequestGetCustomBreakdowns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCustomBreakdowns(String nodeId, APIContext context) {
      super(context, nodeId, "/custom_breakdowns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCustomBreakdowns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCustomBreakdowns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCustomBreakdowns setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetCustomBreakdowns setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetCustomBreakdowns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCustomBreakdowns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomBreakdowns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCustomBreakdowns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCustomBreakdowns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCustomBreakdowns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDiagnostics extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "order_by",
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
               return APIRequestGetDiagnostics.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDiagnostics(String nodeId, APIContext context) {
      super(context, nodeId, "/diagnostics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDiagnostics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDiagnostics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDiagnostics setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetDiagnostics setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetDiagnostics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDiagnostics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDiagnostics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDiagnostics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDiagnostics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDiagnostics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetExternalImportFile extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "order_by",
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
               return APIRequestGetExternalImportFile.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetExternalImportFile(String nodeId, APIContext context) {
      super(context, nodeId, "/external_import_file", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExternalImportFile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExternalImportFile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExternalImportFile setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetExternalImportFile setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetExternalImportFile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExternalImportFile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalImportFile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExternalImportFile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalImportFile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExternalImportFile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetReports extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
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
               return APIRequestGetReports.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReports(String nodeId, APIContext context) {
      super(context, nodeId, "/reports", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReports setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReports setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReports setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetReports setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetReports setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetReports setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetReports requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReports requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReports requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReports requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReports requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReports requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSources extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
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
               return APIRequestGetSources.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSources(String nodeId, APIContext context) {
      super(context, nodeId, "/sources", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSources setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetSources setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetSources setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetSources setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSources requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUsers extends APIRequest<BusinessUser> {

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
               return APIRequestGetUsers.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGetUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetUsers requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGetUsers requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGetUsers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetUsers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUsers requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGetUsers requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGetUsers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetUsers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetUsers requestMarkedForRemovalField () {
      return this.requestMarkedForRemovalField(true);
    }
    public APIRequestGetUsers requestMarkedForRemovalField (boolean value) {
      this.requestField("marked_for_removal", value);
      return this;
    }
    public APIRequestGetUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetUsers requestPendingEmailField () {
      return this.requestPendingEmailField(true);
    }
    public APIRequestGetUsers requestPendingEmailField (boolean value) {
      this.requestField("pending_email", value);
      return this;
    }
    public APIRequestGetUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUsers requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetUsers requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetUsers requestTwoFacStatusField () {
      return this.requestTwoFacStatusField(true);
    }
    public APIRequestGetUsers requestTwoFacStatusField (boolean value) {
      this.requestField("two_fac_status", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<BusinessUnit> {

    BusinessUnit lastResponse = null;
    @Override
    public BusinessUnit getLastResponse() {
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
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestExcludedSourcesField () {
      return this.requestExcludedSourcesField(true);
    }
    public APIRequestGet requestExcludedSourcesField (boolean value) {
      this.requestField("excluded_sources", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsEnabledForMeasurementField () {
      return this.requestIsEnabledForMeasurementField(true);
    }
    public APIRequestGet requestIsEnabledForMeasurementField (boolean value) {
      this.requestField("is_enabled_for_measurement", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestTimeZoneField () {
      return this.requestTimeZoneField(true);
    }
    public APIRequestGet requestTimeZoneField (boolean value) {
      this.requestField("time_zone", value);
      return this;
    }
    public APIRequestGet requestVisitsAvailableDateField () {
      return this.requestVisitsAvailableDateField(true);
    }
    public APIRequestGet requestVisitsAvailableDateField (boolean value) {
      this.requestField("visits_available_date", value);
      return this;
    }
  }

  public static enum EnumTimePeriod {
      @SerializedName("all_available")
      VALUE_ALL_AVAILABLE("all_available"),
      @SerializedName("all_dates")
      VALUE_ALL_DATES("all_dates"),
      @SerializedName("custom")
      VALUE_CUSTOM("custom"),
      @SerializedName("date_range")
      VALUE_DATE_RANGE("date_range"),
      @SerializedName("fifteen_days")
      VALUE_FIFTEEN_DAYS("fifteen_days"),
      @SerializedName("last_fourteen_days")
      VALUE_LAST_FOURTEEN_DAYS("last_fourteen_days"),
      @SerializedName("last_hundred_fourty_four_hours")
      VALUE_LAST_HUNDRED_FOURTY_FOUR_HOURS("last_hundred_fourty_four_hours"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_ninety_days")
      VALUE_LAST_NINETY_DAYS("last_ninety_days"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_seven_days")
      VALUE_LAST_SEVEN_DAYS("last_seven_days"),
      @SerializedName("last_sixty_days")
      VALUE_LAST_SIXTY_DAYS("last_sixty_days"),
      @SerializedName("last_thirty_days")
      VALUE_LAST_THIRTY_DAYS("last_thirty_days"),
      @SerializedName("last_twenty_four_hours")
      VALUE_LAST_TWENTY_FOUR_HOURS("last_twenty_four_hours"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("month_to_date")
      VALUE_MONTH_TO_DATE("month_to_date"),
      @SerializedName("quarter_to_date")
      VALUE_QUARTER_TO_DATE("quarter_to_date"),
      @SerializedName("seven_days")
      VALUE_SEVEN_DAYS("seven_days"),
      @SerializedName("thirty_days")
      VALUE_THIRTY_DAYS("thirty_days"),
      @SerializedName("this_month_whole_days")
      VALUE_THIS_MONTH_WHOLE_DAYS("this_month_whole_days"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("week_to_date")
      VALUE_WEEK_TO_DATE("week_to_date"),
      @SerializedName("year_to_date")
      VALUE_YEAR_TO_DATE("year_to_date"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      ;

      private String value;

      private EnumTimePeriod(String value) {
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

  public BusinessUnit copyFrom(BusinessUnit instance) {
    this.mBusiness = instance.mBusiness;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrency = instance.mCurrency;
    this.mExcludedSources = instance.mExcludedSources;
    this.mId = instance.mId;
    this.mIsEnabledForMeasurement = instance.mIsEnabledForMeasurement;
    this.mName = instance.mName;
    this.mTimeZone = instance.mTimeZone;
    this.mVisitsAvailableDate = instance.mVisitsAvailableDate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessUnit> getParser() {
    return new APIRequest.ResponseParser<BusinessUnit>() {
      public APINodeList<BusinessUnit> parseResponse(String response, APIContext context, APIRequest<BusinessUnit> request, String header) throws MalformedResponseException {
        return BusinessUnit.parseResponse(response, context, request, header);
      }
    };
  }
}
