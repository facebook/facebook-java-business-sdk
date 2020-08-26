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
public class SystemUser extends APINode {
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("finance_permission")
  private String mFinancePermission = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ip_permission")
  private String mIpPermission = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  SystemUser() {
  }

  public SystemUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public SystemUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public SystemUser fetch() throws APIException{
    SystemUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static SystemUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<SystemUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static SystemUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<SystemUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<SystemUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<SystemUser>)(
      new APIRequest<SystemUser>(context, "", "/", "GET", SystemUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<SystemUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", SystemUser.getParser())
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
  public static SystemUser loadJSON(String json, APIContext context, String header) {
    SystemUser systemUser = getGson().fromJson(json, SystemUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(systemUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    systemUser.context = context;
    systemUser.rawValue = json;
    systemUser.header = header;
    return systemUser;
  }

  public static APINodeList<SystemUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<SystemUser> systemUsers = new APINodeList<SystemUser>(request, json, header);
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
          systemUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return systemUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                systemUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            systemUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              systemUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              systemUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  systemUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              systemUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return systemUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              systemUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return systemUsers;
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
              systemUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return systemUsers;
          }

          // Sixth, check if it's pure JsonObject
          systemUsers.clear();
          systemUsers.add(loadJSON(json, context, header));
          return systemUsers;
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

  public APIRequestGetAssignedAdAccounts getAssignedAdAccounts() {
    return new APIRequestGetAssignedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedBusinessAssetGroups getAssignedBusinessAssetGroups() {
    return new APIRequestGetAssignedBusinessAssetGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedPages getAssignedPages() {
    return new APIRequestGetAssignedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedProductCatalogs getAssignedProductCatalogs() {
    return new APIRequestGetAssignedProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldFinancePermission() {
    return mFinancePermission;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIpPermission() {
    return mIpPermission;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestGetAssignedAdAccounts extends APIRequest<AdAccount> {

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
               return APIRequestGetAssignedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetAssignedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetAssignedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAssignedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAssignedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetAssignedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetAssignedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetAssignedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetAssignedAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAssignedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetAssignedAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetAssignedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetAssignedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetAssignedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetAssignedAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetAssignedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetAssignedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetAssignedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetAssignedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAssignedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAssignedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAssignedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAssignedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAssignedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAssignedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetAssignedAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetAssignedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestGetAssignedBusinessAssetGroups extends APIRequest<BusinessAssetGroup> {

    APINodeList<BusinessAssetGroup> lastResponse = null;
    @Override
    public APINodeList<BusinessAssetGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "contained_asset_id",
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
               return APIRequestGetAssignedBusinessAssetGroups.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedBusinessAssetGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_business_asset_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedBusinessAssetGroups setContainedAssetId (String containedAssetId) {
      this.setParam("contained_asset_id", containedAssetId);
      return this;
    }

    public APIRequestGetAssignedBusinessAssetGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedBusinessAssetGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedBusinessAssetGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedBusinessAssetGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedBusinessAssetGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedBusinessAssetGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedBusinessAssetGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestGetAssignedPages extends APIRequest<Page> {

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
               return APIRequestGetAssignedPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetAssignedPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetAssignedPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetAssignedPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetAssignedPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetAssignedPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetAssignedPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetAssignedPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetAssignedPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetAssignedPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetAssignedPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetAssignedPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetAssignedPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetAssignedPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetAssignedPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetAssignedPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetAssignedPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetAssignedPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetAssignedPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetAssignedPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetAssignedPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetAssignedPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetAssignedPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetAssignedPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetAssignedPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetAssignedPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetAssignedPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetAssignedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetAssignedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetAssignedPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetAssignedPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAssignedPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetAssignedPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetAssignedPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetAssignedPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetAssignedPages requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAssignedPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetAssignedPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetAssignedPages requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetAssignedPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetAssignedPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetAssignedPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetAssignedPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetAssignedPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetAssignedPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetAssignedPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetAssignedPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetAssignedPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetAssignedPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetAssignedPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetAssignedPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetAssignedPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetAssignedPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetAssignedPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetAssignedPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetAssignedPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetAssignedPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetAssignedPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetAssignedPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetAssignedPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetAssignedPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetAssignedPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetAssignedPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetAssignedPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetAssignedPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetAssignedPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetAssignedPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetAssignedPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetAssignedPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetAssignedPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetAssignedPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetAssignedPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetAssignedPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetAssignedPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetAssignedPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetAssignedPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetAssignedPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetAssignedPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetAssignedPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetAssignedPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetAssignedPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetAssignedPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetAssignedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetAssignedPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetAssignedPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetAssignedPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetAssignedPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetAssignedPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetAssignedPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetAssignedPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetAssignedPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetAssignedPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetAssignedPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetAssignedPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetAssignedPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetAssignedPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetAssignedPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetAssignedPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetAssignedPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAssignedPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAssignedPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAssignedPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetAssignedPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetAssignedPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetAssignedPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetAssignedPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetAssignedPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetAssignedPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetAssignedPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetAssignedPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetAssignedPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetAssignedPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetAssignedPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetAssignedPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetAssignedPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetAssignedPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetAssignedPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetAssignedPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetAssignedPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetAssignedPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetAssignedPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAssignedPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetAssignedPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetAssignedPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetAssignedPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetAssignedPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetAssignedPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetAssignedPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetAssignedPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetAssignedPages requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetAssignedPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetAssignedPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetAssignedPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetAssignedPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetAssignedPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetAssignedPages requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetAssignedPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetAssignedPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetAssignedPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetAssignedPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetAssignedPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetAssignedPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetAssignedPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetAssignedPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetAssignedPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetAssignedPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetAssignedPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetAssignedPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetAssignedPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetAssignedPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetAssignedPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetAssignedPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetAssignedPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetAssignedPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetAssignedPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetAssignedPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetAssignedPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetAssignedPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetAssignedPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetAssignedPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetAssignedPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetAssignedPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetAssignedPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetAssignedPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetAssignedPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetAssignedPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetAssignedPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetAssignedPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetAssignedPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetAssignedPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetAssignedPages requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetAssignedPages requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetAssignedPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetAssignedPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetAssignedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetAssignedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetAssignedPages requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetAssignedPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetAssignedPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetAssignedPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetAssignedPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetAssignedPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetAssignedPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAssignedPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAssignedPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetAssignedPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetAssignedPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetAssignedPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetAssignedPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetAssignedPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetAssignedPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetAssignedPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetAssignedPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetAssignedPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGetAssignedProductCatalogs extends APIRequest<ProductCatalog> {

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
               return APIRequestGetAssignedProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestIsCatalogSegmentField () {
      return this.requestIsCatalogSegmentField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestIsCatalogSegmentField (boolean value) {
      this.requestField("is_catalog_segment", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<SystemUser> {

    SystemUser lastResponse = null;
    @Override
    public SystemUser getLastResponse() {
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
    public APIRequestGet requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGet requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGet requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static enum EnumRole {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("ADS_RIGHTS_REVIEWER")
      VALUE_ADS_RIGHTS_REVIEWER("ADS_RIGHTS_REVIEWER"),
      @SerializedName("DEVELOPER")
      VALUE_DEVELOPER("DEVELOPER"),
      @SerializedName("EMPLOYEE")
      VALUE_EMPLOYEE("EMPLOYEE"),
      @SerializedName("FINANCE_ANALYST")
      VALUE_FINANCE_ANALYST("FINANCE_ANALYST"),
      @SerializedName("FINANCE_EDITOR")
      VALUE_FINANCE_EDITOR("FINANCE_EDITOR"),
      @SerializedName("FINANCE_EDIT_TASK")
      VALUE_FINANCE_EDIT_TASK("FINANCE_EDIT_TASK"),
      @SerializedName("FINANCE_VIEW_TASK")
      VALUE_FINANCE_VIEW_TASK("FINANCE_VIEW_TASK"),
      @SerializedName("MODERATE_TASK")
      VALUE_MODERATE_TASK("MODERATE_TASK"),
      @SerializedName("OPERATE_TASK")
      VALUE_OPERATE_TASK("OPERATE_TASK"),
      @SerializedName("PARTNER_CENTER_ADMIN")
      VALUE_PARTNER_CENTER_ADMIN("PARTNER_CENTER_ADMIN"),
      @SerializedName("PARTNER_CENTER_ANALYST")
      VALUE_PARTNER_CENTER_ANALYST("PARTNER_CENTER_ANALYST"),
      @SerializedName("PARTNER_CENTER_EDUCATION")
      VALUE_PARTNER_CENTER_EDUCATION("PARTNER_CENTER_EDUCATION"),
      @SerializedName("PARTNER_CENTER_MARKETING")
      VALUE_PARTNER_CENTER_MARKETING("PARTNER_CENTER_MARKETING"),
      @SerializedName("PARTNER_CENTER_OPERATIONS")
      VALUE_PARTNER_CENTER_OPERATIONS("PARTNER_CENTER_OPERATIONS"),
      ;

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

  public SystemUser copyFrom(SystemUser instance) {
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mFinancePermission = instance.mFinancePermission;
    this.mId = instance.mId;
    this.mIpPermission = instance.mIpPermission;
    this.mName = instance.mName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<SystemUser> getParser() {
    return new APIRequest.ResponseParser<SystemUser>() {
      public APINodeList<SystemUser> parseResponse(String response, APIContext context, APIRequest<SystemUser> request, String header) throws MalformedResponseException {
        return SystemUser.parseResponse(response, context, request, header);
      }
    };
  }
}
