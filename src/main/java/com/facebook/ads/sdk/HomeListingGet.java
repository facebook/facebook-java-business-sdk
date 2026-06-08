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
public class HomeListingGet extends APINode {
  @SerializedName("ac_type")
  private EnumAcType mAcType = null;
  @SerializedName("additional_fees_description")
  private String mAdditionalFeesDescription = null;
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("agent_company")
  private String mAgentCompany = null;
  @SerializedName("agent_email")
  private String mAgentEmail = null;
  @SerializedName("agent_fb_page_id")
  private Object mAgentFbPageId = null;
  @SerializedName("agent_name")
  private String mAgentName = null;
  @SerializedName("agent_phone")
  private String mAgentPhone = null;
  @SerializedName("applinks")
  private Object mApplinks = null;
  @SerializedName("area_size")
  private Long mAreaSize = null;
  @SerializedName("area_unit")
  private EnumAreaUnit mAreaUnit = null;
  @SerializedName("availability")
  private EnumAvailability mAvailability = null;
  @SerializedName("capabilities")
  private List<EnumCapabilities> mCapabilities = null;
  @SerializedName("capabilities_disabled_by_user")
  private List<String> mCapabilitiesDisabledByUser = null;
  @SerializedName("capabilities_rendering_catalog_manager")
  private List<EnumCapabilitiesRenderingCatalogManager> mCapabilitiesRenderingCatalogManager = null;
  @SerializedName("capability_to_rejection_reason")
  private List<Object> mCapabilityToRejectionReason = null;
  @SerializedName("catalog_item_overrides")
  private Object mCatalogItemOverrides = null;
  @SerializedName("channels_to_integrity_status")
  private Object mChannelsToIntegrityStatus = null;
  @SerializedName("co_2_emission_rating_eu")
  private Object mCo2EmissionRatingEu = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("custom_label_1")
  private String mCustomLabel1 = null;
  @SerializedName("custom_label_2")
  private String mCustomLabel2 = null;
  @SerializedName("custom_label_3")
  private String mCustomLabel3 = null;
  @SerializedName("custom_label_4")
  private String mCustomLabel4 = null;
  @SerializedName("custom_number_0")
  private Long mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private Long mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private Long mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private Long mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private Long mCustomNumber4 = null;
  @SerializedName("days_on_market")
  private Long mDaysOnMarket = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("enabled_capability_to_review_status")
  private List<Object> mEnabledCapabilityToReviewStatus = null;
  @SerializedName("energy_rating_eu")
  private Object mEnergyRatingEu = null;
  @SerializedName("furnish_type")
  private EnumFurnishType mFurnishType = null;
  @SerializedName("group_id")
  private String mGroupId = null;
  @SerializedName("heating_type")
  private EnumHeatingType mHeatingType = null;
  @SerializedName("home_listing_id")
  private String mHomeListingId = null;
  @SerializedName("id")
  private Long mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("is_blackholed")
  private Boolean mIsBlackholed = null;
  @SerializedName("laundry_type")
  private EnumLaundryType mLaundryType = null;
  @SerializedName("listing_type")
  private EnumListingType mListingType = null;
  @SerializedName("max_currency")
  private String mMaxCurrency = null;
  @SerializedName("max_price")
  private String mMaxPrice = null;
  @SerializedName("min_currency")
  private String mMinCurrency = null;
  @SerializedName("min_price")
  private String mMinPrice = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("num_baths")
  private Double mNumBaths = null;
  @SerializedName("num_beds")
  private Double mNumBeds = null;
  @SerializedName("num_rooms")
  private Double mNumRooms = null;
  @SerializedName("num_units")
  private Long mNumUnits = null;
  @SerializedName("override_details")
  private Object mOverrideDetails = null;
  @SerializedName("parking_type")
  private EnumParkingType mParkingType = null;
  @SerializedName("partner_verification")
  private EnumPartnerVerification mPartnerVerification = null;
  @SerializedName("pet_policy")
  private String mPetPolicy = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_feed")
  private Object mProductFeed = null;
  @SerializedName("property_type")
  private EnumPropertyType mPropertyType = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("sanitized_previews")
  private List<String> mSanitizedPreviews = null;
  @SerializedName("securitydeposit_currency")
  private String mSecuritydepositCurrency = null;
  @SerializedName("securitydeposit_price")
  private String mSecuritydepositPrice = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("url_shimmed")
  private String mUrlShimmed = null;
  @SerializedName("validation_errors")
  private Object mValidationErrors = null;
  @SerializedName("videos_metadata")
  private Object mVideosMetadata = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("year_built")
  private Long mYearBuilt = null;
  protected static Gson gson = null;

  public HomeListingGet() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static HomeListingGet loadJSON(String json, APIContext context, String header) {
    HomeListingGet homeListingGet = getGson().fromJson(json, HomeListingGet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(homeListingGet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    homeListingGet.context = context;
    homeListingGet.rawValue = json;
    homeListingGet.header = header;
    return homeListingGet;
  }

  public static APINodeList<HomeListingGet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<HomeListingGet> homeListingGets = new APINodeList<HomeListingGet>(request, json, header);
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
          homeListingGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return homeListingGets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                homeListingGets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            homeListingGets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              homeListingGets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              homeListingGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  homeListingGets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              homeListingGets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return homeListingGets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              homeListingGets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return homeListingGets;
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
              homeListingGets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return homeListingGets;
          }

          // Sixth, check if it's pure JsonObject
          homeListingGets.clear();
          homeListingGets.add(loadJSON(json, context, header));
          return homeListingGets;
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


  public EnumAcType getFieldAcType() {
    return mAcType;
  }

  public HomeListingGet setFieldAcType(EnumAcType value) {
    this.mAcType = value;
    return this;
  }

  public String getFieldAdditionalFeesDescription() {
    return mAdditionalFeesDescription;
  }

  public HomeListingGet setFieldAdditionalFeesDescription(String value) {
    this.mAdditionalFeesDescription = value;
    return this;
  }

  public Object getFieldAddress() {
    return mAddress;
  }

  public HomeListingGet setFieldAddress(Object value) {
    this.mAddress = value;
    return this;
  }

  public String getFieldAgentCompany() {
    return mAgentCompany;
  }

  public HomeListingGet setFieldAgentCompany(String value) {
    this.mAgentCompany = value;
    return this;
  }

  public String getFieldAgentEmail() {
    return mAgentEmail;
  }

  public HomeListingGet setFieldAgentEmail(String value) {
    this.mAgentEmail = value;
    return this;
  }

  public Object getFieldAgentFbPageId() {
    return mAgentFbPageId;
  }

  public HomeListingGet setFieldAgentFbPageId(Object value) {
    this.mAgentFbPageId = value;
    return this;
  }

  public String getFieldAgentName() {
    return mAgentName;
  }

  public HomeListingGet setFieldAgentName(String value) {
    this.mAgentName = value;
    return this;
  }

  public String getFieldAgentPhone() {
    return mAgentPhone;
  }

  public HomeListingGet setFieldAgentPhone(String value) {
    this.mAgentPhone = value;
    return this;
  }

  public Object getFieldApplinks() {
    return mApplinks;
  }

  public HomeListingGet setFieldApplinks(Object value) {
    this.mApplinks = value;
    return this;
  }

  public Long getFieldAreaSize() {
    return mAreaSize;
  }

  public HomeListingGet setFieldAreaSize(Long value) {
    this.mAreaSize = value;
    return this;
  }

  public EnumAreaUnit getFieldAreaUnit() {
    return mAreaUnit;
  }

  public HomeListingGet setFieldAreaUnit(EnumAreaUnit value) {
    this.mAreaUnit = value;
    return this;
  }

  public EnumAvailability getFieldAvailability() {
    return mAvailability;
  }

  public HomeListingGet setFieldAvailability(EnumAvailability value) {
    this.mAvailability = value;
    return this;
  }

  public List<EnumCapabilities> getFieldCapabilities() {
    return mCapabilities;
  }

  public HomeListingGet setFieldCapabilities(List<EnumCapabilities> value) {
    this.mCapabilities = value;
    return this;
  }

  public List<String> getFieldCapabilitiesDisabledByUser() {
    return mCapabilitiesDisabledByUser;
  }

  public HomeListingGet setFieldCapabilitiesDisabledByUser(List<String> value) {
    this.mCapabilitiesDisabledByUser = value;
    return this;
  }

  public List<EnumCapabilitiesRenderingCatalogManager> getFieldCapabilitiesRenderingCatalogManager() {
    return mCapabilitiesRenderingCatalogManager;
  }

  public HomeListingGet setFieldCapabilitiesRenderingCatalogManager(List<EnumCapabilitiesRenderingCatalogManager> value) {
    this.mCapabilitiesRenderingCatalogManager = value;
    return this;
  }

  public List<Object> getFieldCapabilityToRejectionReason() {
    return mCapabilityToRejectionReason;
  }

  public HomeListingGet setFieldCapabilityToRejectionReason(List<Object> value) {
    this.mCapabilityToRejectionReason = value;
    return this;
  }

  public Object getFieldCatalogItemOverrides() {
    return mCatalogItemOverrides;
  }

  public HomeListingGet setFieldCatalogItemOverrides(Object value) {
    this.mCatalogItemOverrides = value;
    return this;
  }

  public Object getFieldChannelsToIntegrityStatus() {
    return mChannelsToIntegrityStatus;
  }

  public HomeListingGet setFieldChannelsToIntegrityStatus(Object value) {
    this.mChannelsToIntegrityStatus = value;
    return this;
  }

  public Object getFieldCo2EmissionRatingEu() {
    return mCo2EmissionRatingEu;
  }

  public HomeListingGet setFieldCo2EmissionRatingEu(Object value) {
    this.mCo2EmissionRatingEu = value;
    return this;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public HomeListingGet setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public HomeListingGet setFieldCustomLabel0(String value) {
    this.mCustomLabel0 = value;
    return this;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public HomeListingGet setFieldCustomLabel1(String value) {
    this.mCustomLabel1 = value;
    return this;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public HomeListingGet setFieldCustomLabel2(String value) {
    this.mCustomLabel2 = value;
    return this;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public HomeListingGet setFieldCustomLabel3(String value) {
    this.mCustomLabel3 = value;
    return this;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public HomeListingGet setFieldCustomLabel4(String value) {
    this.mCustomLabel4 = value;
    return this;
  }

  public Long getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public HomeListingGet setFieldCustomNumber0(Long value) {
    this.mCustomNumber0 = value;
    return this;
  }

  public Long getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public HomeListingGet setFieldCustomNumber1(Long value) {
    this.mCustomNumber1 = value;
    return this;
  }

  public Long getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public HomeListingGet setFieldCustomNumber2(Long value) {
    this.mCustomNumber2 = value;
    return this;
  }

  public Long getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public HomeListingGet setFieldCustomNumber3(Long value) {
    this.mCustomNumber3 = value;
    return this;
  }

  public Long getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public HomeListingGet setFieldCustomNumber4(Long value) {
    this.mCustomNumber4 = value;
    return this;
  }

  public Long getFieldDaysOnMarket() {
    return mDaysOnMarket;
  }

  public HomeListingGet setFieldDaysOnMarket(Long value) {
    this.mDaysOnMarket = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public HomeListingGet setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public List<Object> getFieldEnabledCapabilityToReviewStatus() {
    return mEnabledCapabilityToReviewStatus;
  }

  public HomeListingGet setFieldEnabledCapabilityToReviewStatus(List<Object> value) {
    this.mEnabledCapabilityToReviewStatus = value;
    return this;
  }

  public Object getFieldEnergyRatingEu() {
    return mEnergyRatingEu;
  }

  public HomeListingGet setFieldEnergyRatingEu(Object value) {
    this.mEnergyRatingEu = value;
    return this;
  }

  public EnumFurnishType getFieldFurnishType() {
    return mFurnishType;
  }

  public HomeListingGet setFieldFurnishType(EnumFurnishType value) {
    this.mFurnishType = value;
    return this;
  }

  public String getFieldGroupId() {
    return mGroupId;
  }

  public HomeListingGet setFieldGroupId(String value) {
    this.mGroupId = value;
    return this;
  }

  public EnumHeatingType getFieldHeatingType() {
    return mHeatingType;
  }

  public HomeListingGet setFieldHeatingType(EnumHeatingType value) {
    this.mHeatingType = value;
    return this;
  }

  public String getFieldHomeListingId() {
    return mHomeListingId;
  }

  public HomeListingGet setFieldHomeListingId(String value) {
    this.mHomeListingId = value;
    return this;
  }

  public Long getFieldId() {
    return mId;
  }

  public HomeListingGet setFieldId(Long value) {
    this.mId = value;
    return this;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public HomeListingGet setFieldImageFetchStatus(EnumImageFetchStatus value) {
    this.mImageFetchStatus = value;
    return this;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public HomeListingGet setFieldImages(List<String> value) {
    this.mImages = value;
    return this;
  }

  public Boolean getFieldIsBlackholed() {
    return mIsBlackholed;
  }

  public HomeListingGet setFieldIsBlackholed(Boolean value) {
    this.mIsBlackholed = value;
    return this;
  }

  public EnumLaundryType getFieldLaundryType() {
    return mLaundryType;
  }

  public HomeListingGet setFieldLaundryType(EnumLaundryType value) {
    this.mLaundryType = value;
    return this;
  }

  public EnumListingType getFieldListingType() {
    return mListingType;
  }

  public HomeListingGet setFieldListingType(EnumListingType value) {
    this.mListingType = value;
    return this;
  }

  public String getFieldMaxCurrency() {
    return mMaxCurrency;
  }

  public HomeListingGet setFieldMaxCurrency(String value) {
    this.mMaxCurrency = value;
    return this;
  }

  public String getFieldMaxPrice() {
    return mMaxPrice;
  }

  public HomeListingGet setFieldMaxPrice(String value) {
    this.mMaxPrice = value;
    return this;
  }

  public String getFieldMinCurrency() {
    return mMinCurrency;
  }

  public HomeListingGet setFieldMinCurrency(String value) {
    this.mMinCurrency = value;
    return this;
  }

  public String getFieldMinPrice() {
    return mMinPrice;
  }

  public HomeListingGet setFieldMinPrice(String value) {
    this.mMinPrice = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public HomeListingGet setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Double getFieldNumBaths() {
    return mNumBaths;
  }

  public HomeListingGet setFieldNumBaths(Double value) {
    this.mNumBaths = value;
    return this;
  }

  public Double getFieldNumBeds() {
    return mNumBeds;
  }

  public HomeListingGet setFieldNumBeds(Double value) {
    this.mNumBeds = value;
    return this;
  }

  public Double getFieldNumRooms() {
    return mNumRooms;
  }

  public HomeListingGet setFieldNumRooms(Double value) {
    this.mNumRooms = value;
    return this;
  }

  public Long getFieldNumUnits() {
    return mNumUnits;
  }

  public HomeListingGet setFieldNumUnits(Long value) {
    this.mNumUnits = value;
    return this;
  }

  public Object getFieldOverrideDetails() {
    return mOverrideDetails;
  }

  public HomeListingGet setFieldOverrideDetails(Object value) {
    this.mOverrideDetails = value;
    return this;
  }

  public EnumParkingType getFieldParkingType() {
    return mParkingType;
  }

  public HomeListingGet setFieldParkingType(EnumParkingType value) {
    this.mParkingType = value;
    return this;
  }

  public EnumPartnerVerification getFieldPartnerVerification() {
    return mPartnerVerification;
  }

  public HomeListingGet setFieldPartnerVerification(EnumPartnerVerification value) {
    this.mPartnerVerification = value;
    return this;
  }

  public String getFieldPetPolicy() {
    return mPetPolicy;
  }

  public HomeListingGet setFieldPetPolicy(String value) {
    this.mPetPolicy = value;
    return this;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public HomeListingGet setFieldPrice(String value) {
    this.mPrice = value;
    return this;
  }

  public Object getFieldProductFeed() {
    return mProductFeed;
  }

  public HomeListingGet setFieldProductFeed(Object value) {
    this.mProductFeed = value;
    return this;
  }

  public EnumPropertyType getFieldPropertyType() {
    return mPropertyType;
  }

  public HomeListingGet setFieldPropertyType(EnumPropertyType value) {
    this.mPropertyType = value;
    return this;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public HomeListingGet setFieldSanitizedImages(List<String> value) {
    this.mSanitizedImages = value;
    return this;
  }

  public List<String> getFieldSanitizedPreviews() {
    return mSanitizedPreviews;
  }

  public HomeListingGet setFieldSanitizedPreviews(List<String> value) {
    this.mSanitizedPreviews = value;
    return this;
  }

  public String getFieldSecuritydepositCurrency() {
    return mSecuritydepositCurrency;
  }

  public HomeListingGet setFieldSecuritydepositCurrency(String value) {
    this.mSecuritydepositCurrency = value;
    return this;
  }

  public String getFieldSecuritydepositPrice() {
    return mSecuritydepositPrice;
  }

  public HomeListingGet setFieldSecuritydepositPrice(String value) {
    this.mSecuritydepositPrice = value;
    return this;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public HomeListingGet setFieldTags(List<String> value) {
    this.mTags = value;
    return this;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public HomeListingGet setFieldUnitPrice(Object value) {
    this.mUnitPrice = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public HomeListingGet setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldUrlShimmed() {
    return mUrlShimmed;
  }

  public HomeListingGet setFieldUrlShimmed(String value) {
    this.mUrlShimmed = value;
    return this;
  }

  public Object getFieldValidationErrors() {
    return mValidationErrors;
  }

  public HomeListingGet setFieldValidationErrors(Object value) {
    this.mValidationErrors = value;
    return this;
  }

  public Object getFieldVideosMetadata() {
    return mVideosMetadata;
  }

  public HomeListingGet setFieldVideosMetadata(Object value) {
    this.mVideosMetadata = value;
    return this;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }

  public HomeListingGet setFieldVisibility(EnumVisibility value) {
    this.mVisibility = value;
    return this;
  }

  public Long getFieldYearBuilt() {
    return mYearBuilt;
  }

  public HomeListingGet setFieldYearBuilt(Long value) {
    this.mYearBuilt = value;
    return this;
  }



  public static enum EnumAcType {
      @SerializedName("CENTRAL")
      VALUE_CENTRAL("CENTRAL"),
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      ;

      private String value;

      private EnumAcType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAreaUnit {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("SQFT")
      VALUE_SQFT("SQFT"),
      @SerializedName("SQM")
      VALUE_SQM("SQM"),
      ;

      private String value;

      private EnumAreaUnit(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAvailability {
      @SerializedName("AVAILABLE_SOON")
      VALUE_AVAILABLE_SOON("AVAILABLE_SOON"),
      @SerializedName("FOR_RENT")
      VALUE_FOR_RENT("FOR_RENT"),
      @SerializedName("FOR_SALE")
      VALUE_FOR_SALE("FOR_SALE"),
      @SerializedName("OFF_MARKET")
      VALUE_OFF_MARKET("OFF_MARKET"),
      @SerializedName("RECENTLY_SOLD")
      VALUE_RECENTLY_SOLD("RECENTLY_SOLD"),
      @SerializedName("SALE_PENDING")
      VALUE_SALE_PENDING("SALE_PENDING"),
      ;

      private String value;

      private EnumAvailability(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCapabilities {
      @SerializedName("B2C_MARKETPLACE")
      VALUE_B2C_MARKETPLACE("B2C_MARKETPLACE"),
      @SerializedName("BIZ_MSG_AI_AGENT")
      VALUE_BIZ_MSG_AI_AGENT("BIZ_MSG_AI_AGENT"),
      @SerializedName("BUSINESS_INBOX_IN_MESSENGER")
      VALUE_BUSINESS_INBOX_IN_MESSENGER("BUSINESS_INBOX_IN_MESSENGER"),
      @SerializedName("BUY_ON_FACEBOOK")
      VALUE_BUY_ON_FACEBOOK("BUY_ON_FACEBOOK"),
      @SerializedName("C2C_MARKETPLACE")
      VALUE_C2C_MARKETPLACE("C2C_MARKETPLACE"),
      @SerializedName("CPAS_PARENT_CATALOG")
      VALUE_CPAS_PARENT_CATALOG("CPAS_PARENT_CATALOG"),
      @SerializedName("DA")
      VALUE_DA("DA"),
      @SerializedName("DAILY_DEALS")
      VALUE_DAILY_DEALS("DAILY_DEALS"),
      @SerializedName("DAILY_DEALS_LEGACY")
      VALUE_DAILY_DEALS_LEGACY("DAILY_DEALS_LEGACY"),
      @SerializedName("EVENT")
      VALUE_EVENT("EVENT"),
      @SerializedName("EVENT_DEPRECATED")
      VALUE_EVENT_DEPRECATED("EVENT_DEPRECATED"),
      @SerializedName("GROUPS")
      VALUE_GROUPS("GROUPS"),
      @SerializedName("IG_ONSITE_SHOPPING")
      VALUE_IG_ONSITE_SHOPPING("IG_ONSITE_SHOPPING"),
      @SerializedName("IG_PRODUCT_TAGGING")
      VALUE_IG_PRODUCT_TAGGING("IG_PRODUCT_TAGGING"),
      @SerializedName("LDP")
      VALUE_LDP("LDP"),
      @SerializedName("MARKETPLACE")
      VALUE_MARKETPLACE("MARKETPLACE"),
      @SerializedName("MARKETPLACE_ADS_DEPRECATED")
      VALUE_MARKETPLACE_ADS_DEPRECATED("MARKETPLACE_ADS_DEPRECATED"),
      @SerializedName("MARKETPLACE_HOME_RENTALS")
      VALUE_MARKETPLACE_HOME_RENTALS("MARKETPLACE_HOME_RENTALS"),
      @SerializedName("MARKETPLACE_HOME_SALES")
      VALUE_MARKETPLACE_HOME_SALES("MARKETPLACE_HOME_SALES"),
      @SerializedName("MARKETPLACE_MOTORS")
      VALUE_MARKETPLACE_MOTORS("MARKETPLACE_MOTORS"),
      @SerializedName("MARKETPLACE_SHOPS")
      VALUE_MARKETPLACE_SHOPS("MARKETPLACE_SHOPS"),
      @SerializedName("MINI_SHOPS")
      VALUE_MINI_SHOPS("MINI_SHOPS"),
      @SerializedName("NEIGHBORHOODS")
      VALUE_NEIGHBORHOODS("NEIGHBORHOODS"),
      @SerializedName("OFFLINE_CONVERSIONS")
      VALUE_OFFLINE_CONVERSIONS("OFFLINE_CONVERSIONS"),
      @SerializedName("PROFILE")
      VALUE_PROFILE("PROFILE"),
      @SerializedName("SERVICE")
      VALUE_SERVICE("SERVICE"),
      @SerializedName("SHOPS")
      VALUE_SHOPS("SHOPS"),
      @SerializedName("TEST_CAPABILITY")
      VALUE_TEST_CAPABILITY("TEST_CAPABILITY"),
      @SerializedName("UNIVERSAL_CHECKOUT")
      VALUE_UNIVERSAL_CHECKOUT("UNIVERSAL_CHECKOUT"),
      @SerializedName("US_MARKETPLACE")
      VALUE_US_MARKETPLACE("US_MARKETPLACE"),
      @SerializedName("WHATSAPP")
      VALUE_WHATSAPP("WHATSAPP"),
      @SerializedName("WHATSAPP_MARKETING_MESSAGE")
      VALUE_WHATSAPP_MARKETING_MESSAGE("WHATSAPP_MARKETING_MESSAGE"),
      ;

      private String value;

      private EnumCapabilities(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCapabilitiesRenderingCatalogManager {
      @SerializedName("B2C_MARKETPLACE")
      VALUE_B2C_MARKETPLACE("B2C_MARKETPLACE"),
      @SerializedName("BIZ_MSG_AI_AGENT")
      VALUE_BIZ_MSG_AI_AGENT("BIZ_MSG_AI_AGENT"),
      @SerializedName("BUSINESS_INBOX_IN_MESSENGER")
      VALUE_BUSINESS_INBOX_IN_MESSENGER("BUSINESS_INBOX_IN_MESSENGER"),
      @SerializedName("BUY_ON_FACEBOOK")
      VALUE_BUY_ON_FACEBOOK("BUY_ON_FACEBOOK"),
      @SerializedName("C2C_MARKETPLACE")
      VALUE_C2C_MARKETPLACE("C2C_MARKETPLACE"),
      @SerializedName("CPAS_PARENT_CATALOG")
      VALUE_CPAS_PARENT_CATALOG("CPAS_PARENT_CATALOG"),
      @SerializedName("DA")
      VALUE_DA("DA"),
      @SerializedName("DAILY_DEALS")
      VALUE_DAILY_DEALS("DAILY_DEALS"),
      @SerializedName("DAILY_DEALS_LEGACY")
      VALUE_DAILY_DEALS_LEGACY("DAILY_DEALS_LEGACY"),
      @SerializedName("EVENT")
      VALUE_EVENT("EVENT"),
      @SerializedName("EVENT_DEPRECATED")
      VALUE_EVENT_DEPRECATED("EVENT_DEPRECATED"),
      @SerializedName("GROUPS")
      VALUE_GROUPS("GROUPS"),
      @SerializedName("IG_ONSITE_SHOPPING")
      VALUE_IG_ONSITE_SHOPPING("IG_ONSITE_SHOPPING"),
      @SerializedName("IG_PRODUCT_TAGGING")
      VALUE_IG_PRODUCT_TAGGING("IG_PRODUCT_TAGGING"),
      @SerializedName("LDP")
      VALUE_LDP("LDP"),
      @SerializedName("MARKETPLACE")
      VALUE_MARKETPLACE("MARKETPLACE"),
      @SerializedName("MARKETPLACE_ADS_DEPRECATED")
      VALUE_MARKETPLACE_ADS_DEPRECATED("MARKETPLACE_ADS_DEPRECATED"),
      @SerializedName("MARKETPLACE_HOME_RENTALS")
      VALUE_MARKETPLACE_HOME_RENTALS("MARKETPLACE_HOME_RENTALS"),
      @SerializedName("MARKETPLACE_HOME_SALES")
      VALUE_MARKETPLACE_HOME_SALES("MARKETPLACE_HOME_SALES"),
      @SerializedName("MARKETPLACE_MOTORS")
      VALUE_MARKETPLACE_MOTORS("MARKETPLACE_MOTORS"),
      @SerializedName("MARKETPLACE_SHOPS")
      VALUE_MARKETPLACE_SHOPS("MARKETPLACE_SHOPS"),
      @SerializedName("MINI_SHOPS")
      VALUE_MINI_SHOPS("MINI_SHOPS"),
      @SerializedName("NEIGHBORHOODS")
      VALUE_NEIGHBORHOODS("NEIGHBORHOODS"),
      @SerializedName("OFFLINE_CONVERSIONS")
      VALUE_OFFLINE_CONVERSIONS("OFFLINE_CONVERSIONS"),
      @SerializedName("PROFILE")
      VALUE_PROFILE("PROFILE"),
      @SerializedName("SERVICE")
      VALUE_SERVICE("SERVICE"),
      @SerializedName("SHOPS")
      VALUE_SHOPS("SHOPS"),
      @SerializedName("TEST_CAPABILITY")
      VALUE_TEST_CAPABILITY("TEST_CAPABILITY"),
      @SerializedName("UNIVERSAL_CHECKOUT")
      VALUE_UNIVERSAL_CHECKOUT("UNIVERSAL_CHECKOUT"),
      @SerializedName("US_MARKETPLACE")
      VALUE_US_MARKETPLACE("US_MARKETPLACE"),
      @SerializedName("WHATSAPP")
      VALUE_WHATSAPP("WHATSAPP"),
      @SerializedName("WHATSAPP_MARKETING_MESSAGE")
      VALUE_WHATSAPP_MARKETING_MESSAGE("WHATSAPP_MARKETING_MESSAGE"),
      ;

      private String value;

      private EnumCapabilitiesRenderingCatalogManager(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFurnishType {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("FURNISHED")
      VALUE_FURNISHED("FURNISHED"),
      @SerializedName("SEMIFURNISHED")
      VALUE_SEMIFURNISHED("SEMIFURNISHED"),
      @SerializedName("UNFURNISHED")
      VALUE_UNFURNISHED("UNFURNISHED"),
      ;

      private String value;

      private EnumFurnishType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumHeatingType {
      @SerializedName("CENTRAL")
      VALUE_CENTRAL("CENTRAL"),
      @SerializedName("ELECTRIC")
      VALUE_ELECTRIC("ELECTRIC"),
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("GAS")
      VALUE_GAS("GAS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("RADIATOR")
      VALUE_RADIATOR("RADIATOR"),
      ;

      private String value;

      private EnumHeatingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumImageFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumImageFetchStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLaundryType {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("IN_BUILDING")
      VALUE_IN_BUILDING("IN_BUILDING"),
      @SerializedName("IN_UNIT")
      VALUE_IN_UNIT("IN_UNIT"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      ;

      private String value;

      private EnumLaundryType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumListingType {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("FORECLOSED")
      VALUE_FORECLOSED("FORECLOSED"),
      @SerializedName("FOR_RENT_BY_AGENT")
      VALUE_FOR_RENT_BY_AGENT("FOR_RENT_BY_AGENT"),
      @SerializedName("FOR_RENT_BY_OWNER")
      VALUE_FOR_RENT_BY_OWNER("FOR_RENT_BY_OWNER"),
      @SerializedName("FOR_SALE_BY_AGENT")
      VALUE_FOR_SALE_BY_AGENT("FOR_SALE_BY_AGENT"),
      @SerializedName("FOR_SALE_BY_OWNER")
      VALUE_FOR_SALE_BY_OWNER("FOR_SALE_BY_OWNER"),
      @SerializedName("NEW_CONSTRUCTION")
      VALUE_NEW_CONSTRUCTION("NEW_CONSTRUCTION"),
      @SerializedName("NEW_LISTING")
      VALUE_NEW_LISTING("NEW_LISTING"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      ;

      private String value;

      private EnumListingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumParkingType {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("GARAGE")
      VALUE_GARAGE("GARAGE"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFF_STREET")
      VALUE_OFF_STREET("OFF_STREET"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("STREET")
      VALUE_STREET("STREET"),
      ;

      private String value;

      private EnumParkingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPartnerVerification {
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("VERIFIED")
      VALUE_VERIFIED("VERIFIED"),
      ;

      private String value;

      private EnumPartnerVerification(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPropertyType {
      @SerializedName("APARTMENT")
      VALUE_APARTMENT("APARTMENT"),
      @SerializedName("APARTMENT_ROOM")
      VALUE_APARTMENT_ROOM("APARTMENT_ROOM"),
      @SerializedName("BUILDER_FLOOR")
      VALUE_BUILDER_FLOOR("BUILDER_FLOOR"),
      @SerializedName("BUNGALOW")
      VALUE_BUNGALOW("BUNGALOW"),
      @SerializedName("CONDO")
      VALUE_CONDO("CONDO"),
      @SerializedName("CONDO_ROOM")
      VALUE_CONDO_ROOM("CONDO_ROOM"),
      @SerializedName("EMPTY_VALUE")
      VALUE_EMPTY_VALUE("EMPTY_VALUE"),
      @SerializedName("HOUSE")
      VALUE_HOUSE("HOUSE"),
      @SerializedName("HOUSE_IN_CONDOMINIUM")
      VALUE_HOUSE_IN_CONDOMINIUM("HOUSE_IN_CONDOMINIUM"),
      @SerializedName("HOUSE_IN_VILLA")
      VALUE_HOUSE_IN_VILLA("HOUSE_IN_VILLA"),
      @SerializedName("HOUSE_ROOM")
      VALUE_HOUSE_ROOM("HOUSE_ROOM"),
      @SerializedName("LAND")
      VALUE_LAND("LAND"),
      @SerializedName("LOFT")
      VALUE_LOFT("LOFT"),
      @SerializedName("MANUFACTURED")
      VALUE_MANUFACTURED("MANUFACTURED"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("OTHER_ROOM")
      VALUE_OTHER_ROOM("OTHER_ROOM"),
      @SerializedName("PENTHOUSE")
      VALUE_PENTHOUSE("PENTHOUSE"),
      @SerializedName("SINGLE_FAMILY_HOME")
      VALUE_SINGLE_FAMILY_HOME("SINGLE_FAMILY_HOME"),
      @SerializedName("STUDIO")
      VALUE_STUDIO("STUDIO"),
      @SerializedName("TOWNHOUSE")
      VALUE_TOWNHOUSE("TOWNHOUSE"),
      @SerializedName("TOWNHOUSE_ROOM")
      VALUE_TOWNHOUSE_ROOM("TOWNHOUSE_ROOM"),
      ;

      private String value;

      private EnumPropertyType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVisibility {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("HIDDEN")
      VALUE_HIDDEN("HIDDEN"),
      @SerializedName("LEGACY_PUBLIC")
      VALUE_LEGACY_PUBLIC("LEGACY_PUBLIC"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      @SerializedName("STAGING")
      VALUE_STAGING("STAGING"),
      @SerializedName("VISIBLE_ONLY_WITH_OVERRIDES")
      VALUE_VISIBLE_ONLY_WITH_OVERRIDES("VISIBLE_ONLY_WITH_OVERRIDES"),
      @SerializedName("WHITELIST_ONLY")
      VALUE_WHITELIST_ONLY("WHITELIST_ONLY"),
      ;

      private String value;

      private EnumVisibility(String value) {
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

  public HomeListingGet copyFrom(HomeListingGet instance) {
    this.mAcType = instance.mAcType;
    this.mAdditionalFeesDescription = instance.mAdditionalFeesDescription;
    this.mAddress = instance.mAddress;
    this.mAgentCompany = instance.mAgentCompany;
    this.mAgentEmail = instance.mAgentEmail;
    this.mAgentFbPageId = instance.mAgentFbPageId;
    this.mAgentName = instance.mAgentName;
    this.mAgentPhone = instance.mAgentPhone;
    this.mApplinks = instance.mApplinks;
    this.mAreaSize = instance.mAreaSize;
    this.mAreaUnit = instance.mAreaUnit;
    this.mAvailability = instance.mAvailability;
    this.mCapabilities = instance.mCapabilities;
    this.mCapabilitiesDisabledByUser = instance.mCapabilitiesDisabledByUser;
    this.mCapabilitiesRenderingCatalogManager = instance.mCapabilitiesRenderingCatalogManager;
    this.mCapabilityToRejectionReason = instance.mCapabilityToRejectionReason;
    this.mCatalogItemOverrides = instance.mCatalogItemOverrides;
    this.mChannelsToIntegrityStatus = instance.mChannelsToIntegrityStatus;
    this.mCo2EmissionRatingEu = instance.mCo2EmissionRatingEu;
    this.mCurrency = instance.mCurrency;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mCustomLabel1 = instance.mCustomLabel1;
    this.mCustomLabel2 = instance.mCustomLabel2;
    this.mCustomLabel3 = instance.mCustomLabel3;
    this.mCustomLabel4 = instance.mCustomLabel4;
    this.mCustomNumber0 = instance.mCustomNumber0;
    this.mCustomNumber1 = instance.mCustomNumber1;
    this.mCustomNumber2 = instance.mCustomNumber2;
    this.mCustomNumber3 = instance.mCustomNumber3;
    this.mCustomNumber4 = instance.mCustomNumber4;
    this.mDaysOnMarket = instance.mDaysOnMarket;
    this.mDescription = instance.mDescription;
    this.mEnabledCapabilityToReviewStatus = instance.mEnabledCapabilityToReviewStatus;
    this.mEnergyRatingEu = instance.mEnergyRatingEu;
    this.mFurnishType = instance.mFurnishType;
    this.mGroupId = instance.mGroupId;
    this.mHeatingType = instance.mHeatingType;
    this.mHomeListingId = instance.mHomeListingId;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mIsBlackholed = instance.mIsBlackholed;
    this.mLaundryType = instance.mLaundryType;
    this.mListingType = instance.mListingType;
    this.mMaxCurrency = instance.mMaxCurrency;
    this.mMaxPrice = instance.mMaxPrice;
    this.mMinCurrency = instance.mMinCurrency;
    this.mMinPrice = instance.mMinPrice;
    this.mName = instance.mName;
    this.mNumBaths = instance.mNumBaths;
    this.mNumBeds = instance.mNumBeds;
    this.mNumRooms = instance.mNumRooms;
    this.mNumUnits = instance.mNumUnits;
    this.mOverrideDetails = instance.mOverrideDetails;
    this.mParkingType = instance.mParkingType;
    this.mPartnerVerification = instance.mPartnerVerification;
    this.mPetPolicy = instance.mPetPolicy;
    this.mPrice = instance.mPrice;
    this.mProductFeed = instance.mProductFeed;
    this.mPropertyType = instance.mPropertyType;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mSanitizedPreviews = instance.mSanitizedPreviews;
    this.mSecuritydepositCurrency = instance.mSecuritydepositCurrency;
    this.mSecuritydepositPrice = instance.mSecuritydepositPrice;
    this.mTags = instance.mTags;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mUrlShimmed = instance.mUrlShimmed;
    this.mValidationErrors = instance.mValidationErrors;
    this.mVideosMetadata = instance.mVideosMetadata;
    this.mVisibility = instance.mVisibility;
    this.mYearBuilt = instance.mYearBuilt;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<HomeListingGet> getParser() {
    return new APIRequest.ResponseParser<HomeListingGet>() {
      public APINodeList<HomeListingGet> parseResponse(String response, APIContext context, APIRequest<HomeListingGet> request, String header) throws MalformedResponseException {
        return HomeListingGet.parseResponse(response, context, request, header);
      }
    };
  }
}
