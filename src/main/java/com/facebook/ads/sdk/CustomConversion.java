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
public class CustomConversion extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("aggregation_rule")
  private String mAggregationRule = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("custom_event_type")
  private EnumCustomEventType mCustomEventType = null;
  @SerializedName("data_sources")
  private List<ExternalEventSource> mDataSources = null;
  @SerializedName("default_conversion_value")
  private Long mDefaultConversionValue = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("event_source_type")
  private String mEventSourceType = null;
  @SerializedName("first_fired_time")
  private String mFirstFiredTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_archived")
  private Boolean mIsArchived = null;
  @SerializedName("is_unavailable")
  private Boolean mIsUnavailable = null;
  @SerializedName("last_fired_time")
  private String mLastFiredTime = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("offline_conversion_data_set")
  private OfflineConversionDataSet mOfflineConversionDataSet = null;
  @SerializedName("pixel")
  private AdsPixel mPixel = null;
  @SerializedName("retention_days")
  private Long mRetentionDays = null;
  @SerializedName("rule")
  private String mRule = null;
  protected static Gson gson = null;

  CustomConversion() {
  }

  public CustomConversion(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CustomConversion(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CustomConversion fetch() throws APIException{
    CustomConversion newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CustomConversion fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CustomConversion> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CustomConversion fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CustomConversion> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CustomConversion> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CustomConversion>)(
      new APIRequest<CustomConversion>(context, "", "/", "GET", CustomConversion.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CustomConversion>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CustomConversion.getParser())
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
  public static CustomConversion loadJSON(String json, APIContext context, String header) {
    CustomConversion customConversion = getGson().fromJson(json, CustomConversion.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customConversion.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customConversion.context = context;
    customConversion.rawValue = json;
    customConversion.header = header;
    return customConversion;
  }

  public static APINodeList<CustomConversion> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CustomConversion> customConversions = new APINodeList<CustomConversion>(request, json, header);
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
          customConversions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return customConversions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customConversions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customConversions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customConversions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customConversions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  customConversions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              customConversions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return customConversions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customConversions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return customConversions;
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
              customConversions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customConversions;
          }

          // Sixth, check if it's pure JsonObject
          customConversions.clear();
          customConversions.add(loadJSON(json, context, header));
          return customConversions;
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

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStats getStats() {
    return new APIRequestGetStats(this.getPrefixedId().toString(), context);
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

  public String getFieldAggregationRule() {
    return mAggregationRule;
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

  public EnumCustomEventType getFieldCustomEventType() {
    return mCustomEventType;
  }

  public List<ExternalEventSource> getFieldDataSources() {
    return mDataSources;
  }

  public Long getFieldDefaultConversionValue() {
    return mDefaultConversionValue;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEventSourceType() {
    return mEventSourceType;
  }

  public String getFieldFirstFiredTime() {
    return mFirstFiredTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsArchived() {
    return mIsArchived;
  }

  public Boolean getFieldIsUnavailable() {
    return mIsUnavailable;
  }

  public String getFieldLastFiredTime() {
    return mLastFiredTime;
  }

  public String getFieldName() {
    return mName;
  }

  public OfflineConversionDataSet getFieldOfflineConversionDataSet() {
    if (mOfflineConversionDataSet != null) {
      mOfflineConversionDataSet.context = getContext();
    }
    return mOfflineConversionDataSet;
  }

  public AdsPixel getFieldPixel() {
    if (mPixel != null) {
      mPixel.context = getContext();
    }
    return mPixel;
  }

  public Long getFieldRetentionDays() {
    return mRetentionDays;
  }

  public String getFieldRule() {
    return mRule;
  }



  public static class APIRequestGetActivities extends APIRequest<CustomConversionActivities> {

    APINodeList<CustomConversionActivities> lastResponse = null;
    @Override
    public APINodeList<CustomConversionActivities> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "event_type",
      "start_time",
    };

    public static final String[] FIELDS = {
      "app_id",
      "data",
      "event_type",
      "timestamp",
    };

    @Override
    public APINodeList<CustomConversionActivities> parseResponse(String response, String header) throws APIException {
      return CustomConversionActivities.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CustomConversionActivities> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversionActivities> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversionActivities>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversionActivities>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CustomConversionActivities>>() {
           public APINodeList<CustomConversionActivities> apply(ResponseWrapper result) {
             try {
               return APIRequestGetActivities.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetActivities setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetActivities setEventType (CustomConversionActivities.EnumEventType eventType) {
      this.setParam("event_type", eventType);
      return this;
    }
    public APIRequestGetActivities setEventType (String eventType) {
      this.setParam("event_type", eventType);
      return this;
    }

    public APIRequestGetActivities setStartTime (String startTime) {
      this.setParam("start_time", startTime);
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

    public APIRequestGetActivities requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetActivities requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetActivities requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetActivities requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }
    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetActivities requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
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

  public static class APIRequestGetStats extends APIRequest<CustomConversionStatsResult> {

    APINodeList<CustomConversionStatsResult> lastResponse = null;
    @Override
    public APINodeList<CustomConversionStatsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation",
      "end_time",
      "start_time",
    };

    public static final String[] FIELDS = {
      "aggregation",
      "data",
      "timestamp",
    };

    @Override
    public APINodeList<CustomConversionStatsResult> parseResponse(String response, String header) throws APIException {
      return CustomConversionStatsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CustomConversionStatsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomConversionStatsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomConversionStatsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomConversionStatsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CustomConversionStatsResult>>() {
           public APINodeList<CustomConversionStatsResult> apply(ResponseWrapper result) {
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


    public APIRequestGetStats setAggregation (CustomConversionStatsResult.EnumAggregation aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }
    public APIRequestGetStats setAggregation (String aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }

    public APIRequestGetStats setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetStats setStartTime (String startTime) {
      this.setParam("start_time", startTime);
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

    public APIRequestGetStats requestAggregationField () {
      return this.requestAggregationField(true);
    }
    public APIRequestGetStats requestAggregationField (boolean value) {
      this.requestField("aggregation", value);
      return this;
    }
    public APIRequestGetStats requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetStats requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }
    public APIRequestGetStats requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStats requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
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

  public static class APIRequestGet extends APIRequest<CustomConversion> {

    CustomConversion lastResponse = null;
    @Override
    public CustomConversion getLastResponse() {
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
      "is_unavailable",
      "last_fired_time",
      "name",
      "offline_conversion_data_set",
      "pixel",
      "retention_days",
      "rule",
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAggregationRuleField () {
      return this.requestAggregationRuleField(true);
    }
    public APIRequestGet requestAggregationRuleField (boolean value) {
      this.requestField("aggregation_rule", value);
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
    public APIRequestGet requestCustomEventTypeField () {
      return this.requestCustomEventTypeField(true);
    }
    public APIRequestGet requestCustomEventTypeField (boolean value) {
      this.requestField("custom_event_type", value);
      return this;
    }
    public APIRequestGet requestDataSourcesField () {
      return this.requestDataSourcesField(true);
    }
    public APIRequestGet requestDataSourcesField (boolean value) {
      this.requestField("data_sources", value);
      return this;
    }
    public APIRequestGet requestDefaultConversionValueField () {
      return this.requestDefaultConversionValueField(true);
    }
    public APIRequestGet requestDefaultConversionValueField (boolean value) {
      this.requestField("default_conversion_value", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEventSourceTypeField () {
      return this.requestEventSourceTypeField(true);
    }
    public APIRequestGet requestEventSourceTypeField (boolean value) {
      this.requestField("event_source_type", value);
      return this;
    }
    public APIRequestGet requestFirstFiredTimeField () {
      return this.requestFirstFiredTimeField(true);
    }
    public APIRequestGet requestFirstFiredTimeField (boolean value) {
      this.requestField("first_fired_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsArchivedField () {
      return this.requestIsArchivedField(true);
    }
    public APIRequestGet requestIsArchivedField (boolean value) {
      this.requestField("is_archived", value);
      return this;
    }
    public APIRequestGet requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGet requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGet requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGet requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOfflineConversionDataSetField () {
      return this.requestOfflineConversionDataSetField(true);
    }
    public APIRequestGet requestOfflineConversionDataSetField (boolean value) {
      this.requestField("offline_conversion_data_set", value);
      return this;
    }
    public APIRequestGet requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGet requestPixelField (boolean value) {
      this.requestField("pixel", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<CustomConversion> {

    CustomConversion lastResponse = null;
    @Override
    public CustomConversion getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "default_conversion_value",
      "description",
      "name",
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


    public APIRequestUpdate setDefaultConversionValue (Double defaultConversionValue) {
      this.setParam("default_conversion_value", defaultConversionValue);
      return this;
    }
    public APIRequestUpdate setDefaultConversionValue (String defaultConversionValue) {
      this.setParam("default_conversion_value", defaultConversionValue);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
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

  public static enum EnumCustomEventType {
      @SerializedName("ADD_PAYMENT_INFO")
      VALUE_ADD_PAYMENT_INFO("ADD_PAYMENT_INFO"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("ADD_TO_WISHLIST")
      VALUE_ADD_TO_WISHLIST("ADD_TO_WISHLIST"),
      @SerializedName("COMPLETE_REGISTRATION")
      VALUE_COMPLETE_REGISTRATION("COMPLETE_REGISTRATION"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CONTENT_VIEW")
      VALUE_CONTENT_VIEW("CONTENT_VIEW"),
      @SerializedName("CUSTOMIZE_PRODUCT")
      VALUE_CUSTOMIZE_PRODUCT("CUSTOMIZE_PRODUCT"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("FIND_LOCATION")
      VALUE_FIND_LOCATION("FIND_LOCATION"),
      @SerializedName("INITIATED_CHECKOUT")
      VALUE_INITIATED_CHECKOUT("INITIATED_CHECKOUT"),
      @SerializedName("LEAD")
      VALUE_LEAD("LEAD"),
      @SerializedName("LISTING_INTERACTION")
      VALUE_LISTING_INTERACTION("LISTING_INTERACTION"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PURCHASE")
      VALUE_PURCHASE("PURCHASE"),
      @SerializedName("SCHEDULE")
      VALUE_SCHEDULE("SCHEDULE"),
      @SerializedName("SEARCH")
      VALUE_SEARCH("SEARCH"),
      @SerializedName("START_TRIAL")
      VALUE_START_TRIAL("START_TRIAL"),
      @SerializedName("SUBMIT_APPLICATION")
      VALUE_SUBMIT_APPLICATION("SUBMIT_APPLICATION"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      ;

      private String value;

      private EnumCustomEventType(String value) {
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

  public CustomConversion copyFrom(CustomConversion instance) {
    this.mAccountId = instance.mAccountId;
    this.mAggregationRule = instance.mAggregationRule;
    this.mBusiness = instance.mBusiness;
    this.mCreationTime = instance.mCreationTime;
    this.mCustomEventType = instance.mCustomEventType;
    this.mDataSources = instance.mDataSources;
    this.mDefaultConversionValue = instance.mDefaultConversionValue;
    this.mDescription = instance.mDescription;
    this.mEventSourceType = instance.mEventSourceType;
    this.mFirstFiredTime = instance.mFirstFiredTime;
    this.mId = instance.mId;
    this.mIsArchived = instance.mIsArchived;
    this.mIsUnavailable = instance.mIsUnavailable;
    this.mLastFiredTime = instance.mLastFiredTime;
    this.mName = instance.mName;
    this.mOfflineConversionDataSet = instance.mOfflineConversionDataSet;
    this.mPixel = instance.mPixel;
    this.mRetentionDays = instance.mRetentionDays;
    this.mRule = instance.mRule;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomConversion> getParser() {
    return new APIRequest.ResponseParser<CustomConversion>() {
      public APINodeList<CustomConversion> parseResponse(String response, APIContext context, APIRequest<CustomConversion> request, String header) throws MalformedResponseException {
        return CustomConversion.parseResponse(response, context, request, header);
      }
    };
  }
}
