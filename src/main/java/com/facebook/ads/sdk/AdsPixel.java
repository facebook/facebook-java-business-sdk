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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdsPixel extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("owner_ad_account")
  private AdAccount mOwnerAdAccount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("last_fired_time")
  private String mLastFiredTime = null;
  @SerializedName("code")
  private String mCode = null;
  protected static Gson gson = null;

  AdsPixel() {
  }

  public AdsPixel(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsPixel(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdsPixel fetch() throws APIException{
    AdsPixel newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsPixel fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdsPixel fetchById(String id, APIContext context) throws APIException {
    AdsPixel adsPixel =
      new APIRequestGet(id, context)
      .requestAllFields()
      .call();
    return adsPixel;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsPixel loadJSON(String json, APIContext context) {
    AdsPixel adsPixel = getGson().fromJson(json, AdsPixel.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPixel.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsPixel.mContext = context;
    adsPixel.rawValue = json;
    return adsPixel;
  }

  public static APINodeList<AdsPixel> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdsPixel> adsPixels = new APINodeList<AdsPixel>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsPixels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsPixels;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adsPixels.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adsPixels.add(loadJSON(obj.toString(), context));
          }
          return adsPixels;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixels.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsPixels;
        } else {
          // Fifth, check if it's pure JsonObject
          adsPixels.add(loadJSON(json, context));
          return adsPixels;
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

  public APIRequestGetStats getStats() {
    return new APIRequestGetStats(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAudiences getAudiences() {
    return new APIRequestGetAudiences(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetSharedAccounts getSharedAccounts() {
    return new APIRequestGetSharedAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetSharedAgencies getSharedAgencies() {
    return new APIRequestGetSharedAgencies(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.mContext = getContext();
    }
    return mOwnerBusiness;
  }

  public AdAccount getFieldOwnerAdAccount() {
    if (mOwnerAdAccount != null) {
      mOwnerAdAccount.mContext = getContext();
    }
    return mOwnerAdAccount;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldLastFiredTime() {
    return mLastFiredTime;
  }

  public String getFieldCode() {
    return mCode;
  }



  public static class APIRequestGet extends APIRequest<AdsPixel> {

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
    public AdsPixel call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel call(Map<String, Object> extraParams) throws APIException {
      return AdsPixel.parseResponse(callInternal(extraParams), getContext(), this).head();
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
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGet requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGet requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGet requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGet requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
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

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetStats extends APIRequest<AdsPixelStatsResult> {

    public static final String[] PARAMS = {
      "start_time",
      "end_time",
      "aggregation",
      "event",
    };

    public static final String[] FIELDS = {
      "aggregation",
      "timestamp",
      "data",
    };

    @Override
    public APINodeList<AdsPixelStatsResult> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixelStatsResult> call(Map<String, Object> extraParams) throws APIException {
      return AdsPixelStatsResult.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetStats(String nodeId, APIContext context) {
      super(context, nodeId, "/stats", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetStats setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetStats setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStats setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }


    public APIRequestGetStats setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }


    public APIRequestGetStats setAggregation (EnumAggregation aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }

    public APIRequestGetStats setAggregation (String aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }

    public APIRequestGetStats setEvent (String event) {
      this.setParam("event", event);
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

    public APIRequestGetStats requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetStats requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

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
    public APIRequestGetStats requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStats requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetStats requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetStats requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }

  }

  public static class APIRequestGetAudiences extends APIRequest<CustomAudience> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "account_id",
      "approximate_count",
      "data_source",
      "delivery_status",
      "description",
      "excluded_custom_audiences",
      "included_custom_audiences",
      "external_event_source",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "permission_for_actions",
      "pixel_id",
      "rule",
      "retention_days",
      "subtype",
      "time_created",
      "time_updated",
      "time_content_updated",
    };

    @Override
    public APINodeList<CustomAudience> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudience> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudience.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetAudiences(String nodeId, APIContext context) {
      super(context, nodeId, "/audiences", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAudiences setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAudiences setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetAudiences requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAudiences requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAudiences requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAudiences requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAudiences requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetAudiences requestDataSourceField () {
      return this.requestDataSourceField(true);
    }
    public APIRequestGetAudiences requestDataSourceField (boolean value) {
      this.requestField("data_source", value);
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
    public APIRequestGetAudiences requestIncludedCustomAudiencesField () {
      return this.requestIncludedCustomAudiencesField(true);
    }
    public APIRequestGetAudiences requestIncludedCustomAudiencesField (boolean value) {
      this.requestField("included_custom_audiences", value);
      return this;
    }
    public APIRequestGetAudiences requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGetAudiences requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
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
    public APIRequestGetAudiences requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGetAudiences requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGetAudiences requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGetAudiences requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGetAudiences requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGetAudiences requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
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
    public APIRequestGetAudiences requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGetAudiences requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
      return this;
    }

  }

  public static class APIRequestGetSharedAccounts extends APIRequest<AdAccount> {

    public static final String[] PARAMS = {
      "business",
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
    public APINodeList<AdAccount> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> call(Map<String, Object> extraParams) throws APIException {
      return AdAccount.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetSharedAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetSharedAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetSharedAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSharedAccounts setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }


    public APIRequestGetSharedAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSharedAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSharedAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetSharedAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSharedAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSharedAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSharedAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAccountGroupsField () {
      return this.requestAccountGroupsField(true);
    }
    public APIRequestGetSharedAccounts requestAccountGroupsField (boolean value) {
      this.requestField("account_groups", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetSharedAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetSharedAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetSharedAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetSharedAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetSharedAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetSharedAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetSharedAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetSharedAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetSharedAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetSharedAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetSharedAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetSharedAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetSharedAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetSharedAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetSharedAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetSharedAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetSharedAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetSharedAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetSharedAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetSharedAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetSharedAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetSharedAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetSharedAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetSharedAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSharedAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetSharedAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetSharedAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetSharedAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetSharedAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetSharedAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetSharedAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetSharedAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetSharedAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetSharedAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetSharedAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetSharedAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetSharedAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestVerticalNameField () {
      return this.requestVerticalNameField(true);
    }
    public APIRequestGetSharedAccounts requestVerticalNameField (boolean value) {
      this.requestField("vertical_name", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetSharedAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetSharedAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetSharedAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetSharedAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetSharedAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGetSharedAccounts requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
      return this;
    }
    public APIRequestGetSharedAccounts requestAssetScoreField () {
      return this.requestAssetScoreField(true);
    }
    public APIRequestGetSharedAccounts requestAssetScoreField (boolean value) {
      this.requestField("asset_score", value);
      return this;
    }

  }

  public static class APIRequestGetSharedAgencies extends APIRequest<Business> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "primary_page",
    };

    @Override
    public APINodeList<Business> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> call(Map<String, Object> extraParams) throws APIException {
      return Business.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetSharedAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_agencies", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetSharedAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetSharedAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSharedAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSharedAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSharedAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetSharedAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSharedAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSharedAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSharedAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSharedAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSharedAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSharedAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetSharedAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetSharedAgencies requestPaymentAccountIdField () {
      return this.requestPaymentAccountIdField(true);
    }
    public APIRequestGetSharedAgencies requestPaymentAccountIdField (boolean value) {
      this.requestField("payment_account_id", value);
      return this;
    }

  }

  public static enum EnumAggregation {
    @SerializedName("browser_type")
    VALUE_BROWSER_TYPE("browser_type"),
    @SerializedName("custom_data_field")
    VALUE_CUSTOM_DATA_FIELD("custom_data_field"),
    @SerializedName("device_os")
    VALUE_DEVICE_OS("device_os"),
    @SerializedName("device_type")
    VALUE_DEVICE_TYPE("device_type"),
    @SerializedName("event")
    VALUE_EVENT("event"),
    @SerializedName("pixel_fire")
    VALUE_PIXEL_FIRE("pixel_fire"),
    @SerializedName("host")
    VALUE_HOST("host"),
    @SerializedName("user_match")
    VALUE_USER_MATCH("user_match"),
    @SerializedName("url")
    VALUE_URL("url"),
    NULL(null);

    private String value;

    private EnumAggregation(String value) {
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

  public AdsPixel copyFrom(AdsPixel instance) {
    this.mId = instance.mId;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mOwnerAdAccount = instance.mOwnerAdAccount;
    this.mName = instance.mName;
    this.mCreationTime = instance.mCreationTime;
    this.mLastFiredTime = instance.mLastFiredTime;
    this.mCode = instance.mCode;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}