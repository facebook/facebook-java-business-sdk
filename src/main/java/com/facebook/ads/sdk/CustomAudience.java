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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class CustomAudience extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("approximate_count")
  private Long mApproximateCount = null;
  @SerializedName("data_source")
  private CustomAudienceDataSource mDataSource = null;
  @SerializedName("delivery_status")
  private CustomAudienceStatus mDeliveryStatus = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("external_event_source")
  private AdsPixel mExternalEventSource = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_value_based")
  private Boolean mIsValueBased = null;
  @SerializedName("lookalike_audience_ids")
  private List<String> mLookalikeAudienceIds = null;
  @SerializedName("lookalike_spec")
  private LookalikeSpec mLookalikeSpec = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("operation_status")
  private CustomAudienceStatus mOperationStatus = null;
  @SerializedName("opt_out_link")
  private String mOptOutLink = null;
  @SerializedName("permission_for_actions")
  private CustomAudiencePermission mPermissionForActions = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("retention_days")
  private Long mRetentionDays = null;
  @SerializedName("rule")
  private String mRule = null;
  @SerializedName("rule_aggregation")
  private String mRuleAggregation = null;
  @SerializedName("subtype")
  private String mSubtype = null;
  @SerializedName("time_content_updated")
  private Long mTimeContentUpdated = null;
  @SerializedName("time_created")
  private Long mTimeCreated = null;
  @SerializedName("time_updated")
  private Long mTimeUpdated = null;
  protected static Gson gson = null;

  CustomAudience() {
  }

  public CustomAudience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CustomAudience(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public CustomAudience fetch() throws APIException{
    CustomAudience newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CustomAudience fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static CustomAudience fetchById(String id, APIContext context) throws APIException {
    CustomAudience customAudience =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return customAudience;
  }

  public static APINodeList<CustomAudience> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CustomAudience>)(
      new APIRequest<CustomAudience>(context, "", "/", "GET", CustomAudience.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CustomAudience loadJSON(String json, APIContext context) {
    CustomAudience customAudience = getGson().fromJson(json, CustomAudience.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudience.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customAudience.context = context;
    customAudience.rawValue = json;
    return customAudience;
  }

  public static APINodeList<CustomAudience> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CustomAudience> customAudiences = new APINodeList<CustomAudience>(request, json);
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
          customAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customAudiences;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            customAudiences.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  customAudiences.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudiences.add(loadJSON(obj.toString(), context));
            }
          }
          return customAudiences;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudiences.add(loadJSON(entry.getValue().toString(), context));
          }
          return customAudiences;
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
              customAudiences.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudiences;
          }

          // Sixth, check if it's pure JsonObject
          customAudiences.clear();
          customAudiences.add(loadJSON(json, context));
          return customAudiences;
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

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPrefills getPrefills() {
    return new APIRequestGetPrefills(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSessions getSessions() {
    return new APIRequestGetSessions(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUsers deleteUsers() {
    return new APIRequestDeleteUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUser createUser() {
    return new APIRequestCreateUser(this.getPrefixedId().toString(), context);
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldApproximateCount() {
    return mApproximateCount;
  }

  public CustomAudienceDataSource getFieldDataSource() {
    return mDataSource;
  }

  public CustomAudienceStatus getFieldDeliveryStatus() {
    return mDeliveryStatus;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdsPixel getFieldExternalEventSource() {
    if (mExternalEventSource != null) {
      mExternalEventSource.context = getContext();
    }
    return mExternalEventSource;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsValueBased() {
    return mIsValueBased;
  }

  public List<String> getFieldLookalikeAudienceIds() {
    return mLookalikeAudienceIds;
  }

  public LookalikeSpec getFieldLookalikeSpec() {
    return mLookalikeSpec;
  }

  public String getFieldName() {
    return mName;
  }

  public CustomAudienceStatus getFieldOperationStatus() {
    return mOperationStatus;
  }

  public String getFieldOptOutLink() {
    return mOptOutLink;
  }

  public CustomAudiencePermission getFieldPermissionForActions() {
    return mPermissionForActions;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public Long getFieldRetentionDays() {
    return mRetentionDays;
  }

  public String getFieldRule() {
    return mRule;
  }

  public String getFieldRuleAggregation() {
    return mRuleAggregation;
  }

  public String getFieldSubtype() {
    return mSubtype;
  }

  public Long getFieldTimeContentUpdated() {
    return mTimeContentUpdated;
  }

  public Long getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestDeleteAdAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccounts",
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


    public APIRequestDeleteAdAccounts setAdaccounts (List<String> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }
    public APIRequestDeleteAdAccounts setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
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

  public static class APIRequestGetAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "permissions",
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
      "failed_delivery_checks",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
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
      "salesforce_invoice_group_id",
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


    public APIRequestGetAdAccounts setPermissions (String permissions) {
      this.setParam("permissions", permissions);
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
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
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
    public APIRequestGetAdAccounts requestSalesforceInvoiceGroupIdField () {
      return this.requestSalesforceInvoiceGroupIdField(true);
    }
    public APIRequestGetAdAccounts requestSalesforceInvoiceGroupIdField (boolean value) {
      this.requestField("salesforce_invoice_group_id", value);
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
    public APIRequestGetAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
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
      "adaccounts",
      "permissions",
      "replace",
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


    public APIRequestCreateAdAccount setAdaccounts (List<String> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }
    public APIRequestCreateAdAccount setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestCreateAdAccount setPermissions (String permissions) {
      this.setParam("permissions", permissions);
      return this;
    }

    public APIRequestCreateAdAccount setReplace (Boolean replace) {
      this.setParam("replace", replace);
      return this;
    }
    public APIRequestCreateAdAccount setReplace (String replace) {
      this.setParam("replace", replace);
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

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "effective_status",
      "status",
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


    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setStatus (List<String> status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetAds setStatus (String status) {
      this.setParam("status", status);
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

  public static class APIRequestGetPrefills extends APIRequest<CustomAudiencePrefillState> {

    APINodeList<CustomAudiencePrefillState> lastResponse = null;
    @Override
    public APINodeList<CustomAudiencePrefillState> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "num_added",
      "status",
    };

    @Override
    public APINodeList<CustomAudiencePrefillState> parseResponse(String response) throws APIException {
      return CustomAudiencePrefillState.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudiencePrefillState> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudiencePrefillState> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPrefills(String nodeId, APIContext context) {
      super(context, nodeId, "/prefills", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPrefills setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPrefills setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPrefills requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPrefills requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPrefills requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPrefills requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPrefills requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPrefills requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPrefills requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPrefills requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPrefills requestNumAddedField () {
      return this.requestNumAddedField(true);
    }
    public APIRequestGetPrefills requestNumAddedField (boolean value) {
      this.requestField("num_added", value);
      return this;
    }
    public APIRequestGetPrefills requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPrefills requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetSessions extends APIRequest<CustomAudienceSession> {

    APINodeList<CustomAudienceSession> lastResponse = null;
    @Override
    public APINodeList<CustomAudienceSession> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "session_id",
    };

    public static final String[] FIELDS = {
      "end_time",
      "num_invalid_entries",
      "num_matched",
      "num_received",
      "progress",
      "session_id",
      "stage",
      "start_time",
    };

    @Override
    public APINodeList<CustomAudienceSession> parseResponse(String response) throws APIException {
      return CustomAudienceSession.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudienceSession> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceSession> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetSessions(String nodeId, APIContext context) {
      super(context, nodeId, "/sessions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSessions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSessions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSessions setSessionId (Long sessionId) {
      this.setParam("session_id", sessionId);
      return this;
    }
    public APIRequestGetSessions setSessionId (String sessionId) {
      this.setParam("session_id", sessionId);
      return this;
    }

    public APIRequestGetSessions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSessions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSessions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSessions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSessions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSessions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSessions requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetSessions requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetSessions requestNumInvalidEntriesField () {
      return this.requestNumInvalidEntriesField(true);
    }
    public APIRequestGetSessions requestNumInvalidEntriesField (boolean value) {
      this.requestField("num_invalid_entries", value);
      return this;
    }
    public APIRequestGetSessions requestNumMatchedField () {
      return this.requestNumMatchedField(true);
    }
    public APIRequestGetSessions requestNumMatchedField (boolean value) {
      this.requestField("num_matched", value);
      return this;
    }
    public APIRequestGetSessions requestNumReceivedField () {
      return this.requestNumReceivedField(true);
    }
    public APIRequestGetSessions requestNumReceivedField (boolean value) {
      this.requestField("num_received", value);
      return this;
    }
    public APIRequestGetSessions requestProgressField () {
      return this.requestProgressField(true);
    }
    public APIRequestGetSessions requestProgressField (boolean value) {
      this.requestField("progress", value);
      return this;
    }
    public APIRequestGetSessions requestSessionIdField () {
      return this.requestSessionIdField(true);
    }
    public APIRequestGetSessions requestSessionIdField (boolean value) {
      this.requestField("session_id", value);
      return this;
    }
    public APIRequestGetSessions requestStageField () {
      return this.requestStageField(true);
    }
    public APIRequestGetSessions requestStageField (boolean value) {
      this.requestField("stage", value);
      return this;
    }
    public APIRequestGetSessions requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetSessions requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
  }

  public static class APIRequestDeleteUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "namespace",
      "payload",
      "session",
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

    public APIRequestDeleteUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUsers setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestDeleteUsers setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestDeleteUsers setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestDeleteUsers setSession (Object session) {
      this.setParam("session", session);
      return this;
    }
    public APIRequestDeleteUsers setSession (String session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestDeleteUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUser extends APIRequest<User> {

    User lastResponse = null;
    @Override
    public User getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "namespace",
      "payload",
      "session",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public User parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this).head();
    }

    @Override
    public User execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public User execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateUser(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUser setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestCreateUser setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestCreateUser setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateUser setSession (Object session) {
      this.setParam("session", session);
      return this;
    }
    public APIRequestCreateUser setSession (String session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestCreateUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUser requestField (String field, boolean value) {
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

  public static class APIRequestGet extends APIRequest<CustomAudience> {

    CustomAudience lastResponse = null;
    @Override
    public CustomAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "approximate_count",
      "data_source",
      "delivery_status",
      "description",
      "external_event_source",
      "id",
      "is_value_based",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "permission_for_actions",
      "pixel_id",
      "retention_days",
      "rule",
      "rule_aggregation",
      "subtype",
      "time_content_updated",
      "time_created",
      "time_updated",
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
    public APIRequestGet requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGet requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGet requestDataSourceField () {
      return this.requestDataSourceField(true);
    }
    public APIRequestGet requestDataSourceField (boolean value) {
      this.requestField("data_source", value);
      return this;
    }
    public APIRequestGet requestDeliveryStatusField () {
      return this.requestDeliveryStatusField(true);
    }
    public APIRequestGet requestDeliveryStatusField (boolean value) {
      this.requestField("delivery_status", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGet requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsValueBasedField () {
      return this.requestIsValueBasedField(true);
    }
    public APIRequestGet requestIsValueBasedField (boolean value) {
      this.requestField("is_value_based", value);
      return this;
    }
    public APIRequestGet requestLookalikeAudienceIdsField () {
      return this.requestLookalikeAudienceIdsField(true);
    }
    public APIRequestGet requestLookalikeAudienceIdsField (boolean value) {
      this.requestField("lookalike_audience_ids", value);
      return this;
    }
    public APIRequestGet requestLookalikeSpecField () {
      return this.requestLookalikeSpecField(true);
    }
    public APIRequestGet requestLookalikeSpecField (boolean value) {
      this.requestField("lookalike_spec", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOperationStatusField () {
      return this.requestOperationStatusField(true);
    }
    public APIRequestGet requestOperationStatusField (boolean value) {
      this.requestField("operation_status", value);
      return this;
    }
    public APIRequestGet requestOptOutLinkField () {
      return this.requestOptOutLinkField(true);
    }
    public APIRequestGet requestOptOutLinkField (boolean value) {
      this.requestField("opt_out_link", value);
      return this;
    }
    public APIRequestGet requestPermissionForActionsField () {
      return this.requestPermissionForActionsField(true);
    }
    public APIRequestGet requestPermissionForActionsField (boolean value) {
      this.requestField("permission_for_actions", value);
      return this;
    }
    public APIRequestGet requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGet requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGet requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGet requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGet requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGet requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGet requestRuleAggregationField () {
      return this.requestRuleAggregationField(true);
    }
    public APIRequestGet requestRuleAggregationField (boolean value) {
      this.requestField("rule_aggregation", value);
      return this;
    }
    public APIRequestGet requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGet requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
      return this;
    }
    public APIRequestGet requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGet requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<CustomAudience> {

    CustomAudience lastResponse = null;
    @Override
    public CustomAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "claim_objective",
      "content_type",
      "description",
      "event_source_group",
      "lookalike_spec",
      "name",
      "opt_out_link",
      "product_set_id",
      "retention_days",
      "rule",
      "rule_aggregation",
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


    public APIRequestUpdate setClaimObjective (CustomAudience.EnumClaimObjective claimObjective) {
      this.setParam("claim_objective", claimObjective);
      return this;
    }
    public APIRequestUpdate setClaimObjective (String claimObjective) {
      this.setParam("claim_objective", claimObjective);
      return this;
    }

    public APIRequestUpdate setContentType (CustomAudience.EnumContentType contentType) {
      this.setParam("content_type", contentType);
      return this;
    }
    public APIRequestUpdate setContentType (String contentType) {
      this.setParam("content_type", contentType);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setEventSourceGroup (String eventSourceGroup) {
      this.setParam("event_source_group", eventSourceGroup);
      return this;
    }

    public APIRequestUpdate setLookalikeSpec (String lookalikeSpec) {
      this.setParam("lookalike_spec", lookalikeSpec);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setOptOutLink (String optOutLink) {
      this.setParam("opt_out_link", optOutLink);
      return this;
    }

    public APIRequestUpdate setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
      return this;
    }

    public APIRequestUpdate setRetentionDays (Long retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }
    public APIRequestUpdate setRetentionDays (String retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }

    public APIRequestUpdate setRule (String rule) {
      this.setParam("rule", rule);
      return this;
    }

    public APIRequestUpdate setRuleAggregation (String ruleAggregation) {
      this.setParam("rule_aggregation", ruleAggregation);
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

  public static enum EnumClaimObjective {
      @SerializedName("AUTO_OFFER")
      VALUE_AUTO_OFFER("AUTO_OFFER"),
      @SerializedName("HOME_LISTING")
      VALUE_HOME_LISTING("HOME_LISTING"),
      @SerializedName("PRODUCT")
      VALUE_PRODUCT("PRODUCT"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      NULL(null);

      private String value;

      private EnumClaimObjective(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumContentType {
      @SerializedName("AUTO_OFFER")
      VALUE_AUTO_OFFER("AUTO_OFFER"),
      @SerializedName("DESTINATION")
      VALUE_DESTINATION("DESTINATION"),
      @SerializedName("FLIGHT")
      VALUE_FLIGHT("FLIGHT"),
      @SerializedName("HOME_LISTING")
      VALUE_HOME_LISTING("HOME_LISTING"),
      @SerializedName("HOTEL")
      VALUE_HOTEL("HOTEL"),
      NULL(null);

      private String value;

      private EnumContentType(String value) {
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

  public static enum EnumFields {
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
      @SerializedName("external_event_source")
      VALUE_EXTERNAL_EVENT_SOURCE("external_event_source"),
      @SerializedName("is_value_based")
      VALUE_IS_VALUE_BASED("is_value_based"),
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
      @SerializedName("retention_days")
      VALUE_RETENTION_DAYS("retention_days"),
      @SerializedName("rule")
      VALUE_RULE("rule"),
      @SerializedName("rule_aggregation")
      VALUE_RULE_AGGREGATION("rule_aggregation"),
      @SerializedName("subtype")
      VALUE_SUBTYPE("subtype"),
      @SerializedName("time_content_updated")
      VALUE_TIME_CONTENT_UPDATED("time_content_updated"),
      @SerializedName("time_created")
      VALUE_TIME_CREATED("time_created"),
      @SerializedName("time_updated")
      VALUE_TIME_UPDATED("time_updated"),
      NULL(null);

      private String value;

      private EnumFields(String value) {
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

  public CustomAudience copyFrom(CustomAudience instance) {
    this.mAccountId = instance.mAccountId;
    this.mApproximateCount = instance.mApproximateCount;
    this.mDataSource = instance.mDataSource;
    this.mDeliveryStatus = instance.mDeliveryStatus;
    this.mDescription = instance.mDescription;
    this.mExternalEventSource = instance.mExternalEventSource;
    this.mId = instance.mId;
    this.mIsValueBased = instance.mIsValueBased;
    this.mLookalikeAudienceIds = instance.mLookalikeAudienceIds;
    this.mLookalikeSpec = instance.mLookalikeSpec;
    this.mName = instance.mName;
    this.mOperationStatus = instance.mOperationStatus;
    this.mOptOutLink = instance.mOptOutLink;
    this.mPermissionForActions = instance.mPermissionForActions;
    this.mPixelId = instance.mPixelId;
    this.mRetentionDays = instance.mRetentionDays;
    this.mRule = instance.mRule;
    this.mRuleAggregation = instance.mRuleAggregation;
    this.mSubtype = instance.mSubtype;
    this.mTimeContentUpdated = instance.mTimeContentUpdated;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudience> getParser() {
    return new APIRequest.ResponseParser<CustomAudience>() {
      public APINodeList<CustomAudience> parseResponse(String response, APIContext context, APIRequest<CustomAudience> request) throws MalformedResponseException {
        return CustomAudience.parseResponse(response, context, request);
      }
    };
  }
}
