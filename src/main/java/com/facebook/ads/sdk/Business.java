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


public class Business extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("primary_page")
  private Object mPrimaryPage = null;
  @SerializedName("payment_account_id")
  private String mPaymentAccountId = null;
  protected static Gson gson = null;

  Business() {
  }

  public Business(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Business(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public Business fetch() throws APIException{
    Business newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static Business fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static Business fetchById(String id, APIContext context) throws APIException {
    Business business =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return business;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Business loadJSON(String json, APIContext context) {
    Business business = getGson().fromJson(json, Business.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(business.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    business.mContext = context;
    business.rawValue = json;
    return business;
  }

  public static APINodeList<Business> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<Business> businesss = new APINodeList<Business>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            businesss.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            businesss.add(loadJSON(obj.toString(), context));
          }
          return businesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businesss.add(loadJSON(entry.getValue().toString(), context));
          }
          return businesss;
        } else {
          // Fifth, check if it's pure JsonObject
          businesss.add(loadJSON(json, context));
          return businesss;
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

  public APIRequestGetSystemUsers getSystemUsers() {
    return new APIRequestGetSystemUsers(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetProductCatalogs getProductCatalogs() {
    return new APIRequestGetProductCatalogs(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAssignedAdAccounts getAssignedAdAccounts() {
    return new APIRequestGetAssignedAdAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAssignedPages getAssignedPages() {
    return new APIRequestGetAssignedPages(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAssignedProductCatalogs getAssignedProductCatalogs() {
    return new APIRequestGetAssignedProductCatalogs(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetClientAdAccounts getClientAdAccounts() {
    return new APIRequestGetClientAdAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetClientAdAccountRequests getClientAdAccountRequests() {
    return new APIRequestGetClientAdAccountRequests(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetClientPages getClientPages() {
    return new APIRequestGetClientPages(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetClientPageRequests getClientPageRequests() {
    return new APIRequestGetClientPageRequests(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedAdAccounts getOwnedAdAccounts() {
    return new APIRequestGetOwnedAdAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedAdAccountRequests getOwnedAdAccountRequests() {
    return new APIRequestGetOwnedAdAccountRequests(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedPages getOwnedPages() {
    return new APIRequestGetOwnedPages(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedPageRequests getOwnedPageRequests() {
    return new APIRequestGetOwnedPageRequests(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedPixels getOwnedPixels() {
    return new APIRequestGetOwnedPixels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetOwnedInstagramAccounts getOwnedInstagramAccounts() {
    return new APIRequestGetOwnedInstagramAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetGrpPlans getGrpPlans() {
    return new APIRequestGetGrpPlans(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateProductCatalog createProductCatalog() {
    return new APIRequestCreateProductCatalog(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteApps deleteApps() {
    return new APIRequestDeleteApps(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateUserPermission createUserPermission() {
    return new APIRequestCreateUserPermission(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdAccounts createAdAccounts() {
    return new APIRequestCreateAdAccounts(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldPrimaryPage() {
    return mPrimaryPage;
  }

  public String getFieldPaymentAccountId() {
    return mPaymentAccountId;
  }



  public static class APIRequestGet extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "primary_page",
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
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
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGet requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }

  }

  public static class APIRequestGetSystemUsers extends APIRequest<APINode> {

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

    public APIRequestGetSystemUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/system_users", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetSystemUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetSystemUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSystemUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSystemUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSystemUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetSystemUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSystemUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "business",
      "feed_count",
      "name",
      "product_count",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
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

  public static class APIRequestGetAssignedAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
      "email",
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

    public APIRequestGetAssignedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAssignedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAssignedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedAdAccounts setUserId (Long userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedAdAccounts setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedAdAccounts setEmail (String email) {
      this.setParam("email", email);
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

    public APIRequestGetAssignedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAssignedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAssignedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAccountGroupsField () {
      return this.requestAccountGroupsField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAccountGroupsField (boolean value) {
      this.requestField("account_groups", value);
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
    public APIRequestGetAssignedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAssignedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
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
    public APIRequestGetAssignedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAssignedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
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
    public APIRequestGetAssignedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAssignedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAssignedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAssignedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
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
    public APIRequestGetAssignedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAssignedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAssignedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetAssignedAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestVerticalNameField () {
      return this.requestVerticalNameField(true);
    }
    public APIRequestGetAssignedAdAccounts requestVerticalNameField (boolean value) {
      this.requestField("vertical_name", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAssignedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
    public APIRequestGetAssignedAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAssignedAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGetAssignedAdAccounts requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
      return this;
    }
    public APIRequestGetAssignedAdAccounts requestAssetScoreField () {
      return this.requestAssetScoreField(true);
    }
    public APIRequestGetAssignedAdAccounts requestAssetScoreField (boolean value) {
      this.requestField("asset_score", value);
      return this;
    }

  }

  public static class APIRequestGetAssignedPages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
      "email",
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

    public APIRequestGetAssignedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_pages", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAssignedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAssignedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedPages setUserId (Long userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedPages setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedPages setEmail (String email) {
      this.setParam("email", email);
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

    public APIRequestGetAssignedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAssignedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAssignedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "user_id",
      "email",
    };

    public static final String[] FIELDS = {
      "id",
      "business",
      "feed_count",
      "name",
      "product_count",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAssignedProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAssignedProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAssignedProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedProductCatalogs setUserId (Long userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedProductCatalogs setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetAssignedProductCatalogs setEmail (String email) {
      this.setParam("email", email);
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

    public APIRequestGetAssignedProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAssignedProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAssignedProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetAssignedProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
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

  }

  public static class APIRequestGetClientAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
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

    public APIRequestGetClientAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetClientAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetClientAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetClientAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAccountGroupsField () {
      return this.requestAccountGroupsField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountGroupsField (boolean value) {
      this.requestField("account_groups", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetClientAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetClientAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetClientAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetClientAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetClientAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetClientAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestVerticalNameField () {
      return this.requestVerticalNameField(true);
    }
    public APIRequestGetClientAdAccounts requestVerticalNameField (boolean value) {
      this.requestField("vertical_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetClientAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAssetScoreField () {
      return this.requestAssetScoreField(true);
    }
    public APIRequestGetClientAdAccounts requestAssetScoreField (boolean value) {
      this.requestField("asset_score", value);
      return this;
    }

  }

  public static class APIRequestGetClientAdAccountRequests extends APIRequest<BusinessAdAccountRequest> {

    APINodeList<BusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "ad_account",
      "permitted_roles",
    };

    @Override
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetClientAdAccountRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_account_requests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetClientAdAccountRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetClientAdAccountRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientAdAccountRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientAdAccountRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientAdAccountRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetClientAdAccountRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientAdAccountRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientAdAccountRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientAdAccountRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientAdAccountRequests requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetClientAdAccountRequests requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetClientAdAccountRequests requestPermittedRolesField () {
      return this.requestPermittedRolesField(true);
    }
    public APIRequestGetClientAdAccountRequests requestPermittedRolesField (boolean value) {
      this.requestField("permitted_roles", value);
      return this;
    }

  }

  public static class APIRequestGetClientPages extends APIRequest<APINode> {

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

    public APIRequestGetClientPages(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pages", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetClientPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetClientPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetClientPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetClientPageRequests extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetClientPageRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/client_page_requests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetClientPageRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetClientPageRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPageRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPageRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientPageRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetClientPageRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetClientPageRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientPageRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPageRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPageRequests requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetClientPageRequests requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }

  }

  public static class APIRequestGetOwnedAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
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

    public APIRequestGetOwnedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAccountGroupsField () {
      return this.requestAccountGroupsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountGroupsField (boolean value) {
      this.requestField("account_groups", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestVerticalNameField () {
      return this.requestVerticalNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestVerticalNameField (boolean value) {
      this.requestField("vertical_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAssetScoreField () {
      return this.requestAssetScoreField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAssetScoreField (boolean value) {
      this.requestField("asset_score", value);
      return this;
    }

  }

  public static class APIRequestGetOwnedAdAccountRequests extends APIRequest<BusinessAdAccountRequest> {

    APINodeList<BusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "ad_account",
      "permitted_roles",
    };

    @Override
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetOwnedAdAccountRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_account_requests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedAdAccountRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedAdAccountRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedAdAccountRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedAdAccountRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedAdAccountRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedAdAccountRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedAdAccountRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedAdAccountRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedAdAccountRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccountRequests requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetOwnedAdAccountRequests requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetOwnedAdAccountRequests requestPermittedRolesField () {
      return this.requestPermittedRolesField(true);
    }
    public APIRequestGetOwnedAdAccountRequests requestPermittedRolesField (boolean value) {
      this.requestField("permitted_roles", value);
      return this;
    }

  }

  public static class APIRequestGetOwnedPages extends APIRequest<APINode> {

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

    public APIRequestGetOwnedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pages", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetOwnedPageRequests extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetOwnedPageRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_page_requests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedPageRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedPageRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPageRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPageRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPageRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedPageRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPageRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPageRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPageRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPageRequests requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetOwnedPageRequests requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }

  }

  public static class APIRequestGetOwnedPixels extends APIRequest<AdsPixel> {

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

    public APIRequestGetOwnedPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pixels", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOwnedPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetOwnedPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }

  }

  public static class APIRequestGetPicture extends APIRequest<ProfilePictureSource> {

    APINodeList<ProfilePictureSource> lastResponse = null;
    @Override
    public APINodeList<ProfilePictureSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "height",
      "width",
      "type",
      "redirect",
    };

    public static final String[] FIELDS = {
      "height",
      "is_silhouette",
      "url",
      "width",
      "left",
      "top",
      "right",
      "bottom",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetPicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPicture setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPicture setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPicture setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPicture setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }

    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
      return this;
    }

    public APIRequestGetPicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPicture requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPicture requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPicture requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGetPicture requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGetPicture requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPicture requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetPicture requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPicture requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
    public APIRequestGetPicture requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGetPicture requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGetPicture requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGetPicture requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGetPicture requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGetPicture requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGetPicture requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGetPicture requestBottomField (boolean value) {
      this.requestField("bottom", value);
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

    public APIRequestGetInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetOwnedInstagramAccounts extends APIRequest<APINode> {

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

    public APIRequestGetOwnedInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetOwnedInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetOwnedInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetOwnedInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetGrpPlans extends APIRequest<ReachFrequencyPrediction> {

    APINodeList<ReachFrequencyPrediction> lastResponse = null;
    @Override
    public APINodeList<ReachFrequencyPrediction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
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

    public APIRequestGetGrpPlans(String nodeId, APIContext context) {
      super(context, nodeId, "/grp_plans", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetGrpPlans setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetGrpPlans setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGrpPlans setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetGrpPlans setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetGrpPlans requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGrpPlans requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetGrpPlans requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetGrpPlans requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetGrpPlans requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetGrpPlans requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetGrpPlans requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetGrpPlans requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetGrpPlans requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGetGrpPlans requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGetGrpPlans requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGetGrpPlans requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetGrpPlans requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGetGrpPlans requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetGrpPlans requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }

  }

  public static class APIRequestCreateProductCatalog extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateProductCatalog(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateProductCatalog setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateProductCatalog setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductCatalog setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateProductCatalog setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateProductCatalog requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductCatalog requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductCatalog requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateProductCatalog requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductCatalog requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateAdAccount extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "name",
      "currency",
      "timezone_id",
      "end_advertiser",
      "funding_id",
      "media_agency",
      "partner",
      "invoice",
      "po_number",
      "io",
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

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccount", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccount setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateAdAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateAdAccount setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }


    public APIRequestCreateAdAccount setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateAdAccount setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateAdAccount setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }


    public APIRequestCreateAdAccount setFundingId (String fundingId) {
      this.setParam("funding_id", fundingId);
      return this;
    }


    public APIRequestCreateAdAccount setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }


    public APIRequestCreateAdAccount setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }


    public APIRequestCreateAdAccount setInvoice (Boolean invoice) {
      this.setParam("invoice", invoice);
      return this;
    }

    public APIRequestCreateAdAccount setInvoice (String invoice) {
      this.setParam("invoice", invoice);
      return this;
    }

    public APIRequestCreateAdAccount setPoNumber (String poNumber) {
      this.setParam("po_number", poNumber);
      return this;
    }


    public APIRequestCreateAdAccount setIo (Boolean io) {
      this.setParam("io", io);
      return this;
    }

    public APIRequestCreateAdAccount setIo (String io) {
      this.setParam("io", io);
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

    public APIRequestCreateAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteApps extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "app_id",
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

    public APIRequestDeleteApps(String nodeId, APIContext context) {
      super(context, nodeId, "/apps", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteApps setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteApps setAppId (Long appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestDeleteApps setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestDeleteApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateUserPermission extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "user",
      "email",
      "role",
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

    public APIRequestCreateUserPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateUserPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateUserPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserPermission setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateUserPermission setUser (Long user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission setEmail (String email) {
      this.setParam("email", email);
      return this;
    }


    public APIRequestCreateUserPermission setRole (EnumRole role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUserPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateUserPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUserPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateAdAccounts extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "adaccount_id",
      "access_type",
      "permitted_roles",
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

    public APIRequestCreateAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccounts setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateAdAccounts setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }


    public APIRequestCreateAdAccounts setAccessType (EnumAccessType accessType) {
      this.setParam("access_type", accessType);
      return this;
    }

    public APIRequestCreateAdAccounts setAccessType (String accessType) {
      this.setParam("access_type", accessType);
      return this;
    }

    public APIRequestCreateAdAccounts setPermittedRoles (List<EnumPermittedRoles> permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreateAdAccounts setPermittedRoles (String permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreateAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumType {
    @SerializedName("small")
    VALUE_SMALL("small"),
    @SerializedName("normal")
    VALUE_NORMAL("normal"),
    @SerializedName("album")
    VALUE_ALBUM("album"),
    @SerializedName("large")
    VALUE_LARGE("large"),
    @SerializedName("square")
    VALUE_SQUARE("square"),
    NULL(null);

    private String value;

    private EnumType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumStatus {
    @SerializedName("EXPIRED")
    VALUE_EXPIRED("EXPIRED"),
    @SerializedName("DRAFT")
    VALUE_DRAFT("DRAFT"),
    @SerializedName("PENDING")
    VALUE_PENDING("PENDING"),
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("COMPLETED")
    VALUE_COMPLETED("COMPLETED"),
    NULL(null);

    private String value;

    private EnumStatus(String value) {
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
    @SerializedName("EMPLOYEE")
    VALUE_EMPLOYEE("EMPLOYEE"),
    @SerializedName("SYSTEM_USER")
    VALUE_SYSTEM_USER("SYSTEM_USER"),
    @SerializedName("ADMIN_SYSTEM_USER")
    VALUE_ADMIN_SYSTEM_USER("ADMIN_SYSTEM_USER"),
    @SerializedName("INSTAGRAM_ADMIN")
    VALUE_INSTAGRAM_ADMIN("INSTAGRAM_ADMIN"),
    @SerializedName("INSTAGRAM_EMPLOYEE")
    VALUE_INSTAGRAM_EMPLOYEE("INSTAGRAM_EMPLOYEE"),
    @SerializedName("FB_EMPLOYEE_ACCOUNT_MANAGER")
    VALUE_FB_EMPLOYEE_ACCOUNT_MANAGER("FB_EMPLOYEE_ACCOUNT_MANAGER"),
    @SerializedName("FB_EMPLOYEE_SALES_REP")
    VALUE_FB_EMPLOYEE_SALES_REP("FB_EMPLOYEE_SALES_REP"),
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
  public static enum EnumAccessType {
    @SerializedName("OWNER")
    VALUE_OWNER("OWNER"),
    @SerializedName("AGENCY")
    VALUE_AGENCY("AGENCY"),
    NULL(null);

    private String value;

    private EnumAccessType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
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

  public Business copyFrom(Business instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPrimaryPage = instance.mPrimaryPage;
    this.mPaymentAccountId = instance.mPaymentAccountId;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}