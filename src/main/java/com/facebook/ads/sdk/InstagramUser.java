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
public class InstagramUser extends APINode {
  @SerializedName("follow_count")
  private Long mFollowCount = null;
  @SerializedName("followed_by_count")
  private Long mFollowedByCount = null;
  @SerializedName("has_profile_picture")
  private Boolean mHasProfilePicture = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_private")
  private Boolean mIsPrivate = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mini_shop_storefront")
  private Shop mMiniShopStorefront = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("profile_pic")
  private String mProfilePic = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  InstagramUser() {
  }

  public InstagramUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstagramUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstagramUser fetch() throws APIException{
    InstagramUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstagramUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstagramUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstagramUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstagramUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstagramUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstagramUser>)(
      new APIRequest<InstagramUser>(context, "", "/", "GET", InstagramUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstagramUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstagramUser.getParser())
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
  public static InstagramUser loadJSON(String json, APIContext context, String header) {
    InstagramUser instagramUser = getGson().fromJson(json, InstagramUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramUser.context = context;
    instagramUser.rawValue = json;
    instagramUser.header = header;
    return instagramUser;
  }

  public static APINodeList<InstagramUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramUser> instagramUsers = new APINodeList<InstagramUser>(request, json, header);
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
          instagramUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramUsers;
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
              instagramUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramUsers;
          }

          // Sixth, check if it's pure JsonObject
          instagramUsers.clear();
          instagramUsers.add(loadJSON(json, context, header));
          return instagramUsers;
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

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAuthorizedAdAccounts getAuthorizedAdAccounts() {
    return new APIRequestGetAuthorizedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAuthorizedAdAccount createAuthorizedAdAccount() {
    return new APIRequestCreateAuthorizedAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldFollowCount() {
    return mFollowCount;
  }

  public Long getFieldFollowedByCount() {
    return mFollowedByCount;
  }

  public Boolean getFieldHasProfilePicture() {
    return mHasProfilePicture;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPrivate() {
    return mIsPrivate;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public Shop getFieldMiniShopStorefront() {
    if (mMiniShopStorefront != null) {
      mMiniShopStorefront.context = getContext();
    }
    return mMiniShopStorefront;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldProfilePic() {
    return mProfilePic;
  }

  public String getFieldUsername() {
    return mUsername;
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
      "collaborative_ads_managed_partner_business_info",
      "collaborative_ads_managed_partner_eligibility",
      "collaborative_ads_partner_premium_options",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
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
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetAgencies requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetAgencies requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
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

  public static class APIRequestGetAuthorizedAdAccounts extends APIRequest<AdAccount> {

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
      "custom_audience_info",
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
               return APIRequestGetAuthorizedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAuthorizedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/authorized_adaccounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAuthorizedAdAccounts setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetAuthorizedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAuthorizedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAuthorizedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAuthorizedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestCustomAudienceInfoField () {
      return this.requestCustomAudienceInfoField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestCustomAudienceInfoField (boolean value) {
      this.requestField("custom_audience_info", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestExistingCustomersField () {
      return this.requestExistingCustomersField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestExistingCustomersField (boolean value) {
      this.requestField("existing_customers", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFbEntityField () {
      return this.requestFbEntityField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFbEntityField (boolean value) {
      this.requestField("fb_entity", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestLiableAddressField () {
      return this.requestLiableAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestLiableAddressField (boolean value) {
      this.requestField("liable_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSendBillToAddressField () {
      return this.requestSendBillToAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSendBillToAddressField (boolean value) {
      this.requestField("send_bill_to_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSoldToAddressField () {
      return this.requestSoldToAddressField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSoldToAddressField (boolean value) {
      this.requestField("sold_to_address", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTasksField () {
      return this.requestUserTasksField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTasksField (boolean value) {
      this.requestField("user_tasks", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestViewableBusinessField () {
      return this.requestViewableBusinessField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestViewableBusinessField (boolean value) {
      this.requestField("viewable_business", value);
      return this;
    }
  }

  public static class APIRequestCreateAuthorizedAdAccount extends APIRequest<InstagramUser> {

    InstagramUser lastResponse = null;
    @Override
    public InstagramUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public InstagramUser parseResponse(String response, String header) throws APIException {
      return InstagramUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramUser>() {
           public InstagramUser apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAuthorizedAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAuthorizedAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/authorized_adaccounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAuthorizedAdAccount setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestCreateAuthorizedAdAccount setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateAuthorizedAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAuthorizedAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAuthorizedAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<InstagramUser> {

    InstagramUser lastResponse = null;
    @Override
    public InstagramUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
    };

    public static final String[] FIELDS = {
      "follow_count",
      "followed_by_count",
      "has_profile_picture",
      "id",
      "is_private",
      "is_published",
      "media_count",
      "mini_shop_storefront",
      "owner_business",
      "profile_pic",
      "username",
    };

    @Override
    public InstagramUser parseResponse(String response, String header) throws APIException {
      return InstagramUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public InstagramUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<InstagramUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, InstagramUser>() {
           public InstagramUser apply(ResponseWrapper result) {
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


    public APIRequestGet setAdgroupId (String adgroupId) {
      this.setParam("adgroup_id", adgroupId);
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

    public APIRequestGet requestFollowCountField () {
      return this.requestFollowCountField(true);
    }
    public APIRequestGet requestFollowCountField (boolean value) {
      this.requestField("follow_count", value);
      return this;
    }
    public APIRequestGet requestFollowedByCountField () {
      return this.requestFollowedByCountField(true);
    }
    public APIRequestGet requestFollowedByCountField (boolean value) {
      this.requestField("followed_by_count", value);
      return this;
    }
    public APIRequestGet requestHasProfilePictureField () {
      return this.requestHasProfilePictureField(true);
    }
    public APIRequestGet requestHasProfilePictureField (boolean value) {
      this.requestField("has_profile_picture", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGet requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGet requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGet requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
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

  public InstagramUser copyFrom(InstagramUser instance) {
    this.mFollowCount = instance.mFollowCount;
    this.mFollowedByCount = instance.mFollowedByCount;
    this.mHasProfilePicture = instance.mHasProfilePicture;
    this.mId = instance.mId;
    this.mIsPrivate = instance.mIsPrivate;
    this.mIsPublished = instance.mIsPublished;
    this.mMediaCount = instance.mMediaCount;
    this.mMiniShopStorefront = instance.mMiniShopStorefront;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mProfilePic = instance.mProfilePic;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramUser> getParser() {
    return new APIRequest.ResponseParser<InstagramUser>() {
      public APINodeList<InstagramUser> parseResponse(String response, APIContext context, APIRequest<InstagramUser> request, String header) throws MalformedResponseException {
        return InstagramUser.parseResponse(response, context, request, header);
      }
    };
  }
}
