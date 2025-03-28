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
public class IGUser extends APINode {
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("business_discovery")
  private IGUser mBusinessDiscovery = null;
  @SerializedName("followers_count")
  private Long mFollowersCount = null;
  @SerializedName("follows_count")
  private Long mFollowsCount = null;
  @SerializedName("has_profile_pic")
  private Boolean mHasProfilePic = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private Long mIgId = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("legacy_instagram_user_id")
  private String mLegacyInstagramUserId = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mentioned_comment")
  private IGComment mMentionedComment = null;
  @SerializedName("mentioned_media")
  private IGMedia mMentionedMedia = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("profile_picture_url")
  private String mProfilePictureUrl = null;
  @SerializedName("shopping_product_tag_eligibility")
  private Boolean mShoppingProductTagEligibility = null;
  @SerializedName("shopping_review_status")
  private String mShoppingReviewStatus = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  IGUser() {
  }

  public IGUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUser fetch() throws APIException{
    IGUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUser>)(
      new APIRequest<IGUser>(context, "", "/", "GET", IGUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUser.getParser())
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
  public static IGUser loadJSON(String json, APIContext context, String header) {
    IGUser igUser = getGson().fromJson(json, IGUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUser.context = context;
    igUser.rawValue = json;
    igUser.header = header;
    return igUser;
  }

  public static APINodeList<IGUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUser> igUsers = new APINodeList<IGUser>(request, json, header);
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
          igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUsers;
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
              igUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUsers;
          }

          // Sixth, check if it's pure JsonObject
          igUsers.clear();
          igUsers.add(loadJSON(json, context, header));
          return igUsers;
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

  public APIRequestGetAvailableCatalogs getAvailableCatalogs() {
    return new APIRequestGetAvailableCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentAdPermissions getBrandedContentAdPermissions() {
    return new APIRequestGetBrandedContentAdPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBrandedContentAdPermission createBrandedContentAdPermission() {
    return new APIRequestCreateBrandedContentAdPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentAdvertisableMedias getBrandedContentAdvertisableMedias() {
    return new APIRequestGetBrandedContentAdvertisableMedias(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteBrandedContentTagApproval deleteBrandedContentTagApproval() {
    return new APIRequestDeleteBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBrandedContentTagApproval getBrandedContentTagApproval() {
    return new APIRequestGetBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBrandedContentTagApproval createBrandedContentTagApproval() {
    return new APIRequestCreateBrandedContentTagApproval(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCatalogProductSearch getCatalogProductSearch() {
    return new APIRequestGetCatalogProductSearch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConnectedThreadsUser getConnectedThreadsUser() {
    return new APIRequestGetConnectedThreadsUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetContentPublishingLimit getContentPublishingLimit() {
    return new APIRequestGetContentPublishingLimit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDataset getDataset() {
    return new APIRequestGetDataset(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateDataset createDataset() {
    return new APIRequestCreateDataset(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramBackedThreadsUser getInstagramBackedThreadsUser() {
    return new APIRequestGetInstagramBackedThreadsUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInstagramBackedThreadsUser createInstagramBackedThreadsUser() {
    return new APIRequestCreateInstagramBackedThreadsUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveMedia getLiveMedia() {
    return new APIRequestGetLiveMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMedia getMedia() {
    return new APIRequestGetMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMedia createMedia() {
    return new APIRequestCreateMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMediaPublish createMediaPublish() {
    return new APIRequestCreateMediaPublish(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMention createMention() {
    return new APIRequestCreateMention(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNotificationMessageTokens getNotificationMessageTokens() {
    return new APIRequestGetNotificationMessageTokens(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductAppeal getProductAppeal() {
    return new APIRequestGetProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductAppeal createProductAppeal() {
    return new APIRequestCreateProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRecentlySearchedHashtags getRecentlySearchedHashtags() {
    return new APIRequestGetRecentlySearchedHashtags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStories getStories() {
    return new APIRequestGetStories(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUpcomingEvents getUpcomingEvents() {
    return new APIRequestGetUpcomingEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpcomingEvent createUpcomingEvent() {
    return new APIRequestCreateUpcomingEvent(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBiography() {
    return mBiography;
  }

  public IGUser getFieldBusinessDiscovery() {
    if (mBusinessDiscovery != null) {
      mBusinessDiscovery.context = getContext();
    }
    return mBusinessDiscovery;
  }

  public Long getFieldFollowersCount() {
    return mFollowersCount;
  }

  public Long getFieldFollowsCount() {
    return mFollowsCount;
  }

  public Boolean getFieldHasProfilePic() {
    return mHasProfilePic;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIgId() {
    return mIgId;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public String getFieldLegacyInstagramUserId() {
    return mLegacyInstagramUserId;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public IGComment getFieldMentionedComment() {
    if (mMentionedComment != null) {
      mMentionedComment.context = getContext();
    }
    return mMentionedComment;
  }

  public IGMedia getFieldMentionedMedia() {
    if (mMentionedMedia != null) {
      mMentionedMedia.context = getContext();
    }
    return mMentionedMedia;
  }

  public String getFieldName() {
    return mName;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public Boolean getFieldShoppingProductTagEligibility() {
    return mShoppingProductTagEligibility;
  }

  public String getFieldShoppingReviewStatus() {
    return mShoppingReviewStatus;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldWebsite() {
    return mWebsite;
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
      "user_access_expire_time",
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
         },
         MoreExecutors.directExecutor()
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
    public APIRequestGetAgencies requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAgencies requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
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
      "expired_funding_source_details",
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
      "is_ba_skip_delayed_eligible",
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
               return APIRequestGetAuthorizedAdAccounts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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
    public APIRequestGetAuthorizedAdAccounts requestAllCapabilitiesField () {
      return this.requestAllCapabilitiesField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestAllCapabilitiesField (boolean value) {
      this.requestField("all_capabilities", value);
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
    public APIRequestGetAuthorizedAdAccounts requestBrandSafetyContentFilterLevelsField () {
      return this.requestBrandSafetyContentFilterLevelsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestBrandSafetyContentFilterLevelsField (boolean value) {
      this.requestField("brand_safety_content_filter_levels", value);
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
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaBeneficiaryField () {
      return this.requestDefaultDsaBeneficiaryField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaBeneficiaryField (boolean value) {
      this.requestField("default_dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaPayorField () {
      return this.requestDefaultDsaPayorField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestDefaultDsaPayorField (boolean value) {
      this.requestField("default_dsa_payor", value);
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
    public APIRequestGetAuthorizedAdAccounts requestExpiredFundingSourceDetailsField () {
      return this.requestExpiredFundingSourceDetailsField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestExpiredFundingSourceDetailsField (boolean value) {
      this.requestField("expired_funding_source_details", value);
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
    public APIRequestGetAuthorizedAdAccounts requestIsBaSkipDelayedEligibleField () {
      return this.requestIsBaSkipDelayedEligibleField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestIsBaSkipDelayedEligibleField (boolean value) {
      this.requestField("is_ba_skip_delayed_eligible", value);
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
    public APIRequestGetAuthorizedAdAccounts requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetAuthorizedAdAccounts requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
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

  public static class APIRequestCreateAuthorizedAdAccount extends APIRequest<IGUser> {

    IGUser lastResponse = null;
    @Override
    public IGUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGUser parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUser>() {
           public IGUser apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAuthorizedAdAccount.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

  public static class APIRequestGetAvailableCatalogs extends APIRequest<UserAvailableCatalogs> {

    APINodeList<UserAvailableCatalogs> lastResponse = null;
    @Override
    public APINodeList<UserAvailableCatalogs> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "catalog_id",
      "catalog_name",
      "product_count",
      "shop_name",
    };

    @Override
    public APINodeList<UserAvailableCatalogs> parseResponse(String response, String header) throws APIException {
      return UserAvailableCatalogs.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UserAvailableCatalogs> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UserAvailableCatalogs> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UserAvailableCatalogs>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UserAvailableCatalogs>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UserAvailableCatalogs>>() {
           public APINodeList<UserAvailableCatalogs> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAvailableCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAvailableCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/available_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAvailableCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAvailableCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAvailableCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAvailableCatalogs requestCatalogIdField () {
      return this.requestCatalogIdField(true);
    }
    public APIRequestGetAvailableCatalogs requestCatalogIdField (boolean value) {
      this.requestField("catalog_id", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestCatalogNameField () {
      return this.requestCatalogNameField(true);
    }
    public APIRequestGetAvailableCatalogs requestCatalogNameField (boolean value) {
      this.requestField("catalog_name", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetAvailableCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetAvailableCatalogs requestShopNameField () {
      return this.requestShopNameField(true);
    }
    public APIRequestGetAvailableCatalogs requestShopNameField (boolean value) {
      this.requestField("shop_name", value);
      return this;
    }
  }

  public static class APIRequestGetBrandedContentAdPermissions extends APIRequest<IGBCAdsPermission> {

    APINodeList<IGBCAdsPermission> lastResponse = null;
    @Override
    public APINodeList<IGBCAdsPermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "permission_type",
      "status",
    };

    @Override
    public APINodeList<IGBCAdsPermission> parseResponse(String response, String header) throws APIException {
      return IGBCAdsPermission.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGBCAdsPermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGBCAdsPermission> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGBCAdsPermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGBCAdsPermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGBCAdsPermission>>() {
           public APINodeList<IGBCAdsPermission> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentAdPermissions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentAdPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_ad_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentAdPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentAdPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentAdPermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdPermissions requestPermissionTypeField () {
      return this.requestPermissionTypeField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestPermissionTypeField (boolean value) {
      this.requestField("permission_type", value);
      return this;
    }
    public APIRequestGetBrandedContentAdPermissions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetBrandedContentAdPermissions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreateBrandedContentAdPermission extends APIRequest<IGBCAdsPermission> {

    IGBCAdsPermission lastResponse = null;
    @Override
    public IGBCAdsPermission getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creator_instagram_account",
      "creator_instagram_username",
      "revoke",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGBCAdsPermission parseResponse(String response, String header) throws APIException {
      return IGBCAdsPermission.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGBCAdsPermission execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGBCAdsPermission execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGBCAdsPermission> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGBCAdsPermission> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGBCAdsPermission>() {
           public IGBCAdsPermission apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBrandedContentAdPermission.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBrandedContentAdPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_ad_permissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBrandedContentAdPermission setCreatorInstagramAccount (String creatorInstagramAccount) {
      this.setParam("creator_instagram_account", creatorInstagramAccount);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission setCreatorInstagramUsername (String creatorInstagramUsername) {
      this.setParam("creator_instagram_username", creatorInstagramUsername);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission setRevoke (Boolean revoke) {
      this.setParam("revoke", revoke);
      return this;
    }
    public APIRequestCreateBrandedContentAdPermission setRevoke (String revoke) {
      this.setParam("revoke", revoke);
      return this;
    }

    public APIRequestCreateBrandedContentAdPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBrandedContentAdPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentAdPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBrandedContentAdvertisableMedias extends APIRequest<BrandedContentShadowIGMediaID> {

    APINodeList<BrandedContentShadowIGMediaID> lastResponse = null;
    @Override
    public APINodeList<BrandedContentShadowIGMediaID> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_code",
      "creator_username",
      "only_fetch_allowlisted",
      "only_fetch_recommended_content",
      "permalinks",
    };

    public static final String[] FIELDS = {
      "eligibility_errors",
      "has_permission_for_partnership_ad",
      "id",
      "owner_id",
      "permalink",
      "recommended_campaign_objectives",
    };

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGMediaID.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BrandedContentShadowIGMediaID> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BrandedContentShadowIGMediaID>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BrandedContentShadowIGMediaID>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BrandedContentShadowIGMediaID>>() {
           public APINodeList<BrandedContentShadowIGMediaID> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentAdvertisableMedias.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentAdvertisableMedias(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_advertisable_medias", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentAdvertisableMedias setAdCode (String adCode) {
      this.setParam("ad_code", adCode);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setCreatorUsername (String creatorUsername) {
      this.setParam("creator_username", creatorUsername);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchAllowlisted (Boolean onlyFetchAllowlisted) {
      this.setParam("only_fetch_allowlisted", onlyFetchAllowlisted);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchAllowlisted (String onlyFetchAllowlisted) {
      this.setParam("only_fetch_allowlisted", onlyFetchAllowlisted);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchRecommendedContent (Boolean onlyFetchRecommendedContent) {
      this.setParam("only_fetch_recommended_content", onlyFetchRecommendedContent);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias setOnlyFetchRecommendedContent (String onlyFetchRecommendedContent) {
      this.setParam("only_fetch_recommended_content", onlyFetchRecommendedContent);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias setPermalinks (List<String> permalinks) {
      this.setParam("permalinks", permalinks);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias setPermalinks (String permalinks) {
      this.setParam("permalinks", permalinks);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentAdvertisableMedias requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentAdvertisableMedias requestEligibilityErrorsField () {
      return this.requestEligibilityErrorsField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestEligibilityErrorsField (boolean value) {
      this.requestField("eligibility_errors", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestHasPermissionForPartnershipAdField () {
      return this.requestHasPermissionForPartnershipAdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestHasPermissionForPartnershipAdField (boolean value) {
      this.requestField("has_permission_for_partnership_ad", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestRecommendedCampaignObjectivesField () {
      return this.requestRecommendedCampaignObjectivesField(true);
    }
    public APIRequestGetBrandedContentAdvertisableMedias requestRecommendedCampaignObjectivesField (boolean value) {
      this.requestField("recommended_campaign_objectives", value);
      return this;
    }
  }

  public static class APIRequestDeleteBrandedContentTagApproval extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
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
               return APIRequestDeleteBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestDeleteBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestDeleteBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBrandedContentTagApproval extends APIRequest<BrandedContentShadowIGUserID> {

    APINodeList<BrandedContentShadowIGUserID> lastResponse = null;
    @Override
    public APINodeList<BrandedContentShadowIGUserID> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public APINodeList<BrandedContentShadowIGUserID> parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGUserID.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BrandedContentShadowIGUserID> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BrandedContentShadowIGUserID> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BrandedContentShadowIGUserID>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BrandedContentShadowIGUserID>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BrandedContentShadowIGUserID>>() {
           public APINodeList<BrandedContentShadowIGUserID> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestGetBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestGetBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBrandedContentTagApproval requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBrandedContentTagApproval requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateBrandedContentTagApproval extends APIRequest<BrandedContentShadowIGUserID> {

    BrandedContentShadowIGUserID lastResponse = null;
    @Override
    public BrandedContentShadowIGUserID getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BrandedContentShadowIGUserID parseResponse(String response, String header) throws APIException {
      return BrandedContentShadowIGUserID.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BrandedContentShadowIGUserID execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BrandedContentShadowIGUserID execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BrandedContentShadowIGUserID> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BrandedContentShadowIGUserID> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BrandedContentShadowIGUserID>() {
           public BrandedContentShadowIGUserID apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBrandedContentTagApproval.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBrandedContentTagApproval(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_tag_approval", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBrandedContentTagApproval setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestCreateBrandedContentTagApproval setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestCreateBrandedContentTagApproval requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBrandedContentTagApproval requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBrandedContentTagApproval requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCatalogProductSearch extends APIRequest<ShadowIGUserCatalogProductSearch> {

    APINodeList<ShadowIGUserCatalogProductSearch> lastResponse = null;
    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
      "q",
    };

    public static final String[] FIELDS = {
      "image_url",
      "is_checkout_flow",
      "merchant_id",
      "product_id",
      "product_name",
      "product_variants",
      "retailer_id",
      "review_status",
    };

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> parseResponse(String response, String header) throws APIException {
      return ShadowIGUserCatalogProductSearch.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGUserCatalogProductSearch> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGUserCatalogProductSearch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGUserCatalogProductSearch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGUserCatalogProductSearch>>() {
           public APINodeList<ShadowIGUserCatalogProductSearch> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCatalogProductSearch.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCatalogProductSearch(String nodeId, APIContext context) {
      super(context, nodeId, "/catalog_product_search", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCatalogProductSearch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCatalogProductSearch setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestGetCatalogProductSearch setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetCatalogProductSearch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCatalogProductSearch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCatalogProductSearch requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetCatalogProductSearch requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestIsCheckoutFlowField () {
      return this.requestIsCheckoutFlowField(true);
    }
    public APIRequestGetCatalogProductSearch requestIsCheckoutFlowField (boolean value) {
      this.requestField("is_checkout_flow", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductNameField () {
      return this.requestProductNameField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductNameField (boolean value) {
      this.requestField("product_name", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestProductVariantsField () {
      return this.requestProductVariantsField(true);
    }
    public APIRequestGetCatalogProductSearch requestProductVariantsField (boolean value) {
      this.requestField("product_variants", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetCatalogProductSearch requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetCatalogProductSearch requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetCatalogProductSearch requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
  }

  public static class APIRequestGetConnectedThreadsUser extends APIRequest<ThreadsUser> {

    APINodeList<ThreadsUser> lastResponse = null;
    @Override
    public APINodeList<ThreadsUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "threads_user_id",
      "threads_user_profile_pic",
    };

    @Override
    public APINodeList<ThreadsUser> parseResponse(String response, String header) throws APIException {
      return ThreadsUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ThreadsUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ThreadsUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ThreadsUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ThreadsUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ThreadsUser>>() {
           public APINodeList<ThreadsUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetConnectedThreadsUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetConnectedThreadsUser(String nodeId, APIContext context) {
      super(context, nodeId, "/connected_threads_user", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConnectedThreadsUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConnectedThreadsUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConnectedThreadsUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConnectedThreadsUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConnectedThreadsUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConnectedThreadsUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConnectedThreadsUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConnectedThreadsUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetConnectedThreadsUser requestThreadsUserIdField () {
      return this.requestThreadsUserIdField(true);
    }
    public APIRequestGetConnectedThreadsUser requestThreadsUserIdField (boolean value) {
      this.requestField("threads_user_id", value);
      return this;
    }
    public APIRequestGetConnectedThreadsUser requestThreadsUserProfilePicField () {
      return this.requestThreadsUserProfilePicField(true);
    }
    public APIRequestGetConnectedThreadsUser requestThreadsUserProfilePicField (boolean value) {
      this.requestField("threads_user_profile_pic", value);
      return this;
    }
  }

  public static class APIRequestGetContentPublishingLimit extends APIRequest<ContentPublishingLimitResponse> {

    APINodeList<ContentPublishingLimitResponse> lastResponse = null;
    @Override
    public APINodeList<ContentPublishingLimitResponse> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
    };

    public static final String[] FIELDS = {
      "config",
      "quota_usage",
    };

    @Override
    public APINodeList<ContentPublishingLimitResponse> parseResponse(String response, String header) throws APIException {
      return ContentPublishingLimitResponse.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ContentPublishingLimitResponse>>() {
           public APINodeList<ContentPublishingLimitResponse> apply(ResponseWrapper result) {
             try {
               return APIRequestGetContentPublishingLimit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetContentPublishingLimit(String nodeId, APIContext context) {
      super(context, nodeId, "/content_publishing_limit", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetContentPublishingLimit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetContentPublishingLimit setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetContentPublishingLimit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetContentPublishingLimit requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField () {
      return this.requestQuotaUsageField(true);
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField (boolean value) {
      this.requestField("quota_usage", value);
      return this;
    }
  }

  public static class APIRequestGetDataset extends APIRequest<Dataset> {

    APINodeList<Dataset> lastResponse = null;
    @Override
    public APINodeList<Dataset> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
    };

    @Override
    public APINodeList<Dataset> parseResponse(String response, String header) throws APIException {
      return Dataset.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Dataset> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Dataset> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Dataset>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Dataset>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Dataset>>() {
           public APINodeList<Dataset> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDataset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDataset(String nodeId, APIContext context) {
      super(context, nodeId, "/dataset", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDataset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDataset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDataset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDataset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDataset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDataset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDataset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDataset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDataset requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDataset requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDataset requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDataset requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateDataset extends APIRequest<Dataset> {

    Dataset lastResponse = null;
    @Override
    public Dataset getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "dataset_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Dataset parseResponse(String response, String header) throws APIException {
      return Dataset.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Dataset execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Dataset execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Dataset> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Dataset> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Dataset>() {
           public Dataset apply(ResponseWrapper result) {
             try {
               return APIRequestCreateDataset.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDataset(String nodeId, APIContext context) {
      super(context, nodeId, "/dataset", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDataset setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDataset setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDataset setDatasetName (String datasetName) {
      this.setParam("dataset_name", datasetName);
      return this;
    }

    public APIRequestCreateDataset requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDataset requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDataset requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDataset requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDataset requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDataset requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<InstagramInsightsResult> {

    APINodeList<InstagramInsightsResult> lastResponse = null;
    @Override
    public APINodeList<InstagramInsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "metric_type",
      "period",
      "since",
      "timeframe",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "name",
      "period",
      "title",
      "total_value",
      "values",
    };

    @Override
    public APINodeList<InstagramInsightsResult> parseResponse(String response, String header) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramInsightsResult>>() {
           public APINodeList<InstagramInsightsResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setBreakdown (List<InstagramInsightsResult.EnumBreakdown> breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInsights setMetric (List<InstagramInsightsResult.EnumMetric> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setMetricType (InstagramInsightsResult.EnumMetricType metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }
    public APIRequestGetInsights setMetricType (String metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }

    public APIRequestGetInsights setPeriod (List<InstagramInsightsResult.EnumPeriod> period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setTimeframe (InstagramInsightsResult.EnumTimeframe timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }
    public APIRequestGetInsights setTimeframe (String timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetInsights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetInsights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInsights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInsights requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGetInsights requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGetInsights requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetInsights requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetInsights requestTotalValueField () {
      return this.requestTotalValueField(true);
    }
    public APIRequestGetInsights requestTotalValueField (boolean value) {
      this.requestField("total_value", value);
      return this;
    }
    public APIRequestGetInsights requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetInsights requestValuesField (boolean value) {
      this.requestField("values", value);
      return this;
    }
  }

  public static class APIRequestGetInstagramBackedThreadsUser extends APIRequest<ThreadsUser> {

    APINodeList<ThreadsUser> lastResponse = null;
    @Override
    public APINodeList<ThreadsUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "threads_user_id",
      "threads_user_profile_pic",
    };

    @Override
    public APINodeList<ThreadsUser> parseResponse(String response, String header) throws APIException {
      return ThreadsUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ThreadsUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ThreadsUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ThreadsUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ThreadsUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ThreadsUser>>() {
           public APINodeList<ThreadsUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInstagramBackedThreadsUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetInstagramBackedThreadsUser(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_backed_threads_user", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstagramBackedThreadsUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstagramBackedThreadsUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstagramBackedThreadsUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstagramBackedThreadsUser requestThreadsUserIdField () {
      return this.requestThreadsUserIdField(true);
    }
    public APIRequestGetInstagramBackedThreadsUser requestThreadsUserIdField (boolean value) {
      this.requestField("threads_user_id", value);
      return this;
    }
    public APIRequestGetInstagramBackedThreadsUser requestThreadsUserProfilePicField () {
      return this.requestThreadsUserProfilePicField(true);
    }
    public APIRequestGetInstagramBackedThreadsUser requestThreadsUserProfilePicField (boolean value) {
      this.requestField("threads_user_profile_pic", value);
      return this;
    }
  }

  public static class APIRequestCreateInstagramBackedThreadsUser extends APIRequest<ThreadsUser> {

    ThreadsUser lastResponse = null;
    @Override
    public ThreadsUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ThreadsUser parseResponse(String response, String header) throws APIException {
      return ThreadsUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ThreadsUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ThreadsUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ThreadsUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ThreadsUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ThreadsUser>() {
           public ThreadsUser apply(ResponseWrapper result) {
             try {
               return APIRequestCreateInstagramBackedThreadsUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateInstagramBackedThreadsUser(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_backed_threads_user", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInstagramBackedThreadsUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInstagramBackedThreadsUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInstagramBackedThreadsUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLiveMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "legacy_instagram_media_id",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLiveMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLiveMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/live_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetLiveMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetLiveMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLiveMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetLiveMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetLiveMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetLiveMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetLiveMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetLiveMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetLiveMedia requestLegacyInstagramMediaIdField () {
      return this.requestLegacyInstagramMediaIdField(true);
    }
    public APIRequestGetLiveMedia requestLegacyInstagramMediaIdField (boolean value) {
      this.requestField("legacy_instagram_media_id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetLiveMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetLiveMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetLiveMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetLiveMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetLiveMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetLiveMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetLiveMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetLiveMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetLiveMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLiveMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "legacy_instagram_media_id",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMedia requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetMedia requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetMedia requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetMedia requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetMedia requestLegacyInstagramMediaIdField () {
      return this.requestLegacyInstagramMediaIdField(true);
    }
    public APIRequestGetMedia requestLegacyInstagramMediaIdField (boolean value) {
      this.requestField("legacy_instagram_media_id", value);
      return this;
    }
    public APIRequestGetMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateMedia extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "alt_text",
      "audio_name",
      "caption",
      "children",
      "collaborators",
      "cover_url",
      "image_url",
      "is_carousel_item",
      "location_id",
      "media_type",
      "product_tags",
      "share_to_feed",
      "thumb_offset",
      "upload_type",
      "user_tags",
      "video_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMedia setAltText (String altText) {
      this.setParam("alt_text", altText);
      return this;
    }

    public APIRequestCreateMedia setAudioName (String audioName) {
      this.setParam("audio_name", audioName);
      return this;
    }

    public APIRequestCreateMedia setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateMedia setChildren (List<String> children) {
      this.setParam("children", children);
      return this;
    }
    public APIRequestCreateMedia setChildren (String children) {
      this.setParam("children", children);
      return this;
    }

    public APIRequestCreateMedia setCollaborators (List<String> collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }
    public APIRequestCreateMedia setCollaborators (String collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }

    public APIRequestCreateMedia setCoverUrl (String coverUrl) {
      this.setParam("cover_url", coverUrl);
      return this;
    }

    public APIRequestCreateMedia setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateMedia setIsCarouselItem (Boolean isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }
    public APIRequestCreateMedia setIsCarouselItem (String isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }

    public APIRequestCreateMedia setLocationId (String locationId) {
      this.setParam("location_id", locationId);
      return this;
    }

    public APIRequestCreateMedia setMediaType (String mediaType) {
      this.setParam("media_type", mediaType);
      return this;
    }

    public APIRequestCreateMedia setProductTags (List<Map<String, String>> productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }
    public APIRequestCreateMedia setProductTags (String productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }

    public APIRequestCreateMedia setShareToFeed (Boolean shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }
    public APIRequestCreateMedia setShareToFeed (String shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }

    public APIRequestCreateMedia setThumbOffset (String thumbOffset) {
      this.setParam("thumb_offset", thumbOffset);
      return this;
    }

    public APIRequestCreateMedia setUploadType (String uploadType) {
      this.setParam("upload_type", uploadType);
      return this;
    }

    public APIRequestCreateMedia setUserTags (List<Map<String, String>> userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }
    public APIRequestCreateMedia setUserTags (String userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }

    public APIRequestCreateMedia setVideoUrl (String videoUrl) {
      this.setParam("video_url", videoUrl);
      return this;
    }

    public APIRequestCreateMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMediaPublish extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMediaPublish.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMediaPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/media_publish", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMediaPublish setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMediaPublish setCreationId (Long creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }
    public APIRequestCreateMediaPublish setCreationId (String creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }

    public APIRequestCreateMediaPublish requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMediaPublish requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMention extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_id",
      "media_id",
      "message",
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
               return APIRequestCreateMention.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMention(String nodeId, APIContext context) {
      super(context, nodeId, "/mentions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMention setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMention setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMention setCommentId (String commentId) {
      this.setParam("comment_id", commentId);
      return this;
    }

    public APIRequestCreateMention setMediaId (String mediaId) {
      this.setParam("media_id", mediaId);
      return this;
    }

    public APIRequestCreateMention setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMention requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMention requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetNotificationMessageTokens extends APIRequest<UserPageOneTimeOptInTokenSettings> {

    APINodeList<UserPageOneTimeOptInTokenSettings> lastResponse = null;
    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_timestamp",
      "next_eligible_time",
      "notification_messages_frequency",
      "notification_messages_reoptin",
      "notification_messages_timezone",
      "notification_messages_token",
      "recipient_id",
      "token_expiry_timestamp",
      "topic_title",
      "user_token_status",
      "id",
    };

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> parseResponse(String response, String header) throws APIException {
      return UserPageOneTimeOptInTokenSettings.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UserPageOneTimeOptInTokenSettings>>() {
           public APINodeList<UserPageOneTimeOptInTokenSettings> apply(ResponseWrapper result) {
             try {
               return APIRequestGetNotificationMessageTokens.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetNotificationMessageTokens(String nodeId, APIContext context) {
      super(context, nodeId, "/notification_message_tokens", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNotificationMessageTokens requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNotificationMessageTokens requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNotificationMessageTokens requestCreationTimestampField () {
      return this.requestCreationTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestCreationTimestampField (boolean value) {
      this.requestField("creation_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField () {
      return this.requestNextEligibleTimeField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField (boolean value) {
      this.requestField("next_eligible_time", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField () {
      return this.requestNotificationMessagesFrequencyField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField (boolean value) {
      this.requestField("notification_messages_frequency", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField () {
      return this.requestNotificationMessagesReoptinField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField (boolean value) {
      this.requestField("notification_messages_reoptin", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField () {
      return this.requestNotificationMessagesTimezoneField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField (boolean value) {
      this.requestField("notification_messages_timezone", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField () {
      return this.requestNotificationMessagesTokenField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField (boolean value) {
      this.requestField("notification_messages_token", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField () {
      return this.requestRecipientIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField (boolean value) {
      this.requestField("recipient_id", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField () {
      return this.requestTokenExpiryTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField (boolean value) {
      this.requestField("token_expiry_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField () {
      return this.requestTopicTitleField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField (boolean value) {
      this.requestField("topic_title", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField () {
      return this.requestUserTokenStatusField(true);
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField (boolean value) {
      this.requestField("user_token_status", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetProductAppeal extends APIRequest<IGShoppingProductAppeal> {

    APINodeList<IGShoppingProductAppeal> lastResponse = null;
    @Override
    public APINodeList<IGShoppingProductAppeal> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "product_id",
    };

    public static final String[] FIELDS = {
      "eligible_for_appeal",
      "product_appeal_status",
      "product_id",
      "rejection_reasons",
      "review_status",
    };

    @Override
    public APINodeList<IGShoppingProductAppeal> parseResponse(String response, String header) throws APIException {
      return IGShoppingProductAppeal.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGShoppingProductAppeal> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGShoppingProductAppeal> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGShoppingProductAppeal>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGShoppingProductAppeal>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGShoppingProductAppeal>>() {
           public APINodeList<IGShoppingProductAppeal> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestGetProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductAppeal requestEligibleForAppealField () {
      return this.requestEligibleForAppealField(true);
    }
    public APIRequestGetProductAppeal requestEligibleForAppealField (boolean value) {
      this.requestField("eligible_for_appeal", value);
      return this;
    }
    public APIRequestGetProductAppeal requestProductAppealStatusField () {
      return this.requestProductAppealStatusField(true);
    }
    public APIRequestGetProductAppeal requestProductAppealStatusField (boolean value) {
      this.requestField("product_appeal_status", value);
      return this;
    }
    public APIRequestGetProductAppeal requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetProductAppeal requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetProductAppeal requestRejectionReasonsField () {
      return this.requestRejectionReasonsField(true);
    }
    public APIRequestGetProductAppeal requestRejectionReasonsField (boolean value) {
      this.requestField("rejection_reasons", value);
      return this;
    }
    public APIRequestGetProductAppeal requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetProductAppeal requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
  }

  public static class APIRequestCreateProductAppeal extends APIRequest<IGShoppingProductAppeal> {

    IGShoppingProductAppeal lastResponse = null;
    @Override
    public IGShoppingProductAppeal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "appeal_reason",
      "product_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGShoppingProductAppeal parseResponse(String response, String header) throws APIException {
      return IGShoppingProductAppeal.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGShoppingProductAppeal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGShoppingProductAppeal execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGShoppingProductAppeal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGShoppingProductAppeal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGShoppingProductAppeal>() {
           public IGShoppingProductAppeal apply(ResponseWrapper result) {
             try {
               return APIRequestCreateProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductAppeal setAppealReason (String appealReason) {
      this.setParam("appeal_reason", appealReason);
      return this;
    }

    public APIRequestCreateProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestCreateProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRecentlySearchedHashtags extends APIRequest<ShadowIGHashtag> {

    APINodeList<ShadowIGHashtag> lastResponse = null;
    @Override
    public APINodeList<ShadowIGHashtag> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
    };

    @Override
    public APINodeList<ShadowIGHashtag> parseResponse(String response, String header) throws APIException {
      return ShadowIGHashtag.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ShadowIGHashtag> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGHashtag> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGHashtag>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGHashtag>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ShadowIGHashtag>>() {
           public APINodeList<ShadowIGHashtag> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRecentlySearchedHashtags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRecentlySearchedHashtags(String nodeId, APIContext context) {
      super(context, nodeId, "/recently_searched_hashtags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentlySearchedHashtags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentlySearchedHashtags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRecentlySearchedHashtags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRecentlySearchedHashtags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRecentlySearchedHashtags requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetRecentlySearchedHashtags requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestGetStories extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "legacy_instagram_media_id",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetStories.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetStories(String nodeId, APIContext context) {
      super(context, nodeId, "/stories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetStories requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetStories requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetStories requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetStories requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetStories requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetStories requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetStories requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetStories requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetStories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetStories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetStories requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetStories requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetStories requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetStories requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetStories requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetStories requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetStories requestLegacyInstagramMediaIdField () {
      return this.requestLegacyInstagramMediaIdField(true);
    }
    public APIRequestGetStories requestLegacyInstagramMediaIdField (boolean value) {
      this.requestField("legacy_instagram_media_id", value);
      return this;
    }
    public APIRequestGetStories requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetStories requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetStories requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetStories requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetStories requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetStories requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetStories requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetStories requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetStories requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetStories requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetStories requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetStories requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetStories requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetStories requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetStories requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStories requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetStories requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetStories requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTags extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "boost_eligibility_info",
      "caption",
      "comments_count",
      "copyright_check_information",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "legacy_instagram_media_id",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTags(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTags requestBoostEligibilityInfoField () {
      return this.requestBoostEligibilityInfoField(true);
    }
    public APIRequestGetTags requestBoostEligibilityInfoField (boolean value) {
      this.requestField("boost_eligibility_info", value);
      return this;
    }
    public APIRequestGetTags requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTags requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTags requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetTags requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetTags requestCopyrightCheckInformationField () {
      return this.requestCopyrightCheckInformationField(true);
    }
    public APIRequestGetTags requestCopyrightCheckInformationField (boolean value) {
      this.requestField("copyright_check_information", value);
      return this;
    }
    public APIRequestGetTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTags requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetTags requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetTags requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetTags requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetTags requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetTags requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetTags requestLegacyInstagramMediaIdField () {
      return this.requestLegacyInstagramMediaIdField(true);
    }
    public APIRequestGetTags requestLegacyInstagramMediaIdField (boolean value) {
      this.requestField("legacy_instagram_media_id", value);
      return this;
    }
    public APIRequestGetTags requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetTags requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetTags requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetTags requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetTags requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetTags requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetTags requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetTags requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetTags requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetTags requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetTags requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetTags requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetTags requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetTags requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetTags requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetTags requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTags requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetUpcomingEvents extends APIRequest<IGUpcomingEvent> {

    APINodeList<IGUpcomingEvent> lastResponse = null;
    @Override
    public APINodeList<IGUpcomingEvent> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "end_time",
      "id",
      "notification_subtypes",
      "notification_target_time",
      "start_time",
      "title",
    };

    @Override
    public APINodeList<IGUpcomingEvent> parseResponse(String response, String header) throws APIException {
      return IGUpcomingEvent.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGUpcomingEvent> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGUpcomingEvent> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGUpcomingEvent>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGUpcomingEvent>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGUpcomingEvent>>() {
           public APINodeList<IGUpcomingEvent> apply(ResponseWrapper result) {
             try {
               return APIRequestGetUpcomingEvents.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetUpcomingEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/upcoming_events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUpcomingEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUpcomingEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUpcomingEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUpcomingEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUpcomingEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUpcomingEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUpcomingEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestNotificationSubtypesField () {
      return this.requestNotificationSubtypesField(true);
    }
    public APIRequestGetUpcomingEvents requestNotificationSubtypesField (boolean value) {
      this.requestField("notification_subtypes", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestNotificationTargetTimeField () {
      return this.requestNotificationTargetTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestNotificationTargetTimeField (boolean value) {
      this.requestField("notification_target_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetUpcomingEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetUpcomingEvents requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetUpcomingEvents requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
  }

  public static class APIRequestCreateUpcomingEvent extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_time",
      "notification_subtypes",
      "start_time",
      "title",
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
               return APIRequestCreateUpcomingEvent.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateUpcomingEvent(String nodeId, APIContext context) {
      super(context, nodeId, "/upcoming_events", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUpcomingEvent setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUpcomingEvent setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUpcomingEvent setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateUpcomingEvent setNotificationSubtypes (List<EnumNotificationSubtypes> notificationSubtypes) {
      this.setParam("notification_subtypes", notificationSubtypes);
      return this;
    }
    public APIRequestCreateUpcomingEvent setNotificationSubtypes (String notificationSubtypes) {
      this.setParam("notification_subtypes", notificationSubtypes);
      return this;
    }

    public APIRequestCreateUpcomingEvent setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateUpcomingEvent setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateUpcomingEvent requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpcomingEvent requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpcomingEvent requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUpcomingEvent requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpcomingEvent requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUpcomingEvent requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<IGUser> {

    IGUser lastResponse = null;
    @Override
    public IGUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
    };

    public static final String[] FIELDS = {
      "biography",
      "business_discovery",
      "followers_count",
      "follows_count",
      "has_profile_pic",
      "id",
      "ig_id",
      "is_published",
      "legacy_instagram_user_id",
      "media_count",
      "mentioned_comment",
      "mentioned_media",
      "name",
      "owner_business",
      "profile_picture_url",
      "shopping_product_tag_eligibility",
      "shopping_review_status",
      "username",
      "website",
    };

    @Override
    public IGUser parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUser>() {
           public IGUser apply(ResponseWrapper result) {
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

    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGet requestBusinessDiscoveryField () {
      return this.requestBusinessDiscoveryField(true);
    }
    public APIRequestGet requestBusinessDiscoveryField (boolean value) {
      this.requestField("business_discovery", value);
      return this;
    }
    public APIRequestGet requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGet requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGet requestFollowsCountField () {
      return this.requestFollowsCountField(true);
    }
    public APIRequestGet requestFollowsCountField (boolean value) {
      this.requestField("follows_count", value);
      return this;
    }
    public APIRequestGet requestHasProfilePicField () {
      return this.requestHasProfilePicField(true);
    }
    public APIRequestGet requestHasProfilePicField (boolean value) {
      this.requestField("has_profile_pic", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGet requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestLegacyInstagramUserIdField () {
      return this.requestLegacyInstagramUserIdField(true);
    }
    public APIRequestGet requestLegacyInstagramUserIdField (boolean value) {
      this.requestField("legacy_instagram_user_id", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMentionedCommentField () {
      return this.requestMentionedCommentField(true);
    }
    public APIRequestGet requestMentionedCommentField (boolean value) {
      this.requestField("mentioned_comment", value);
      return this;
    }
    public APIRequestGet requestMentionedMediaField () {
      return this.requestMentionedMediaField(true);
    }
    public APIRequestGet requestMentionedMediaField (boolean value) {
      this.requestField("mentioned_media", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUrlField () {
      return this.requestProfilePictureUrlField(true);
    }
    public APIRequestGet requestProfilePictureUrlField (boolean value) {
      this.requestField("profile_picture_url", value);
      return this;
    }
    public APIRequestGet requestShoppingProductTagEligibilityField () {
      return this.requestShoppingProductTagEligibilityField(true);
    }
    public APIRequestGet requestShoppingProductTagEligibilityField (boolean value) {
      this.requestField("shopping_product_tag_eligibility", value);
      return this;
    }
    public APIRequestGet requestShoppingReviewStatusField () {
      return this.requestShoppingReviewStatusField(true);
    }
    public APIRequestGet requestShoppingReviewStatusField (boolean value) {
      this.requestField("shopping_review_status", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
  }

  public static enum EnumNotificationSubtypes {
      @SerializedName("AFTER_EVENT_1DAY")
      VALUE_AFTER_EVENT_1DAY("AFTER_EVENT_1DAY"),
      @SerializedName("AFTER_EVENT_2DAY")
      VALUE_AFTER_EVENT_2DAY("AFTER_EVENT_2DAY"),
      @SerializedName("AFTER_EVENT_3DAY")
      VALUE_AFTER_EVENT_3DAY("AFTER_EVENT_3DAY"),
      @SerializedName("AFTER_EVENT_4DAY")
      VALUE_AFTER_EVENT_4DAY("AFTER_EVENT_4DAY"),
      @SerializedName("AFTER_EVENT_5DAY")
      VALUE_AFTER_EVENT_5DAY("AFTER_EVENT_5DAY"),
      @SerializedName("AFTER_EVENT_6DAY")
      VALUE_AFTER_EVENT_6DAY("AFTER_EVENT_6DAY"),
      @SerializedName("AFTER_EVENT_7DAY")
      VALUE_AFTER_EVENT_7DAY("AFTER_EVENT_7DAY"),
      @SerializedName("BEFORE_EVENT_15MIN")
      VALUE_BEFORE_EVENT_15MIN("BEFORE_EVENT_15MIN"),
      @SerializedName("BEFORE_EVENT_1DAY")
      VALUE_BEFORE_EVENT_1DAY("BEFORE_EVENT_1DAY"),
      @SerializedName("BEFORE_EVENT_1HOUR")
      VALUE_BEFORE_EVENT_1HOUR("BEFORE_EVENT_1HOUR"),
      @SerializedName("BEFORE_EVENT_2DAY")
      VALUE_BEFORE_EVENT_2DAY("BEFORE_EVENT_2DAY"),
      @SerializedName("EVENT_START")
      VALUE_EVENT_START("EVENT_START"),
      @SerializedName("RESCHEDULED")
      VALUE_RESCHEDULED("RESCHEDULED"),
      ;

      private String value;

      private EnumNotificationSubtypes(String value) {
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

  public IGUser copyFrom(IGUser instance) {
    this.mBiography = instance.mBiography;
    this.mBusinessDiscovery = instance.mBusinessDiscovery;
    this.mFollowersCount = instance.mFollowersCount;
    this.mFollowsCount = instance.mFollowsCount;
    this.mHasProfilePic = instance.mHasProfilePic;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mIsPublished = instance.mIsPublished;
    this.mLegacyInstagramUserId = instance.mLegacyInstagramUserId;
    this.mMediaCount = instance.mMediaCount;
    this.mMentionedComment = instance.mMentionedComment;
    this.mMentionedMedia = instance.mMentionedMedia;
    this.mName = instance.mName;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mProfilePictureUrl = instance.mProfilePictureUrl;
    this.mShoppingProductTagEligibility = instance.mShoppingProductTagEligibility;
    this.mShoppingReviewStatus = instance.mShoppingReviewStatus;
    this.mUsername = instance.mUsername;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUser> getParser() {
    return new APIRequest.ResponseParser<IGUser>() {
      public APINodeList<IGUser> parseResponse(String response, APIContext context, APIRequest<IGUser> request, String header) throws MalformedResponseException {
        return IGUser.parseResponse(response, context, request, header);
      }
    };
  }
}
