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
public class Targeting extends APINode {
  @SerializedName("adgroup_id")
  private String mAdgroupId = null;
  @SerializedName("age_max")
  private Long mAgeMax = null;
  @SerializedName("age_min")
  private Long mAgeMin = null;
  @SerializedName("alternate_auto_targeting_option")
  private String mAlternateAutoTargetingOption = null;
  @SerializedName("app_install_state")
  private String mAppInstallState = null;
  @SerializedName("audience_network_positions")
  private List<String> mAudienceNetworkPositions = null;
  @SerializedName("behaviors")
  private List<IDName> mBehaviors = null;
  @SerializedName("cities")
  private List<IDName> mCities = null;
  @SerializedName("college_years")
  private List<Long> mCollegeYears = null;
  @SerializedName("connections")
  private List<IDName> mConnections = null;
  @SerializedName("contextual_targeting_categories")
  private List<IDName> mContextualTargetingCategories = null;
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("country")
  private List<String> mCountry = null;
  @SerializedName("country_groups")
  private List<String> mCountryGroups = null;
  @SerializedName("custom_audiences")
  private List<IDName> mCustomAudiences = null;
  @SerializedName("device_platforms")
  private List<EnumDevicePlatforms> mDevicePlatforms = null;
  @SerializedName("dynamic_audience_ids")
  private List<String> mDynamicAudienceIds = null;
  @SerializedName("education_majors")
  private List<IDName> mEducationMajors = null;
  @SerializedName("education_schools")
  private List<IDName> mEducationSchools = null;
  @SerializedName("education_statuses")
  private List<Long> mEducationStatuses = null;
  @SerializedName("effective_audience_network_positions")
  private List<String> mEffectiveAudienceNetworkPositions = null;
  @SerializedName("effective_device_platforms")
  private List<EnumEffectiveDevicePlatforms> mEffectiveDevicePlatforms = null;
  @SerializedName("effective_facebook_positions")
  private List<String> mEffectiveFacebookPositions = null;
  @SerializedName("effective_instagram_positions")
  private List<String> mEffectiveInstagramPositions = null;
  @SerializedName("effective_messenger_positions")
  private List<String> mEffectiveMessengerPositions = null;
  @SerializedName("effective_publisher_platforms")
  private List<String> mEffectivePublisherPlatforms = null;
  @SerializedName("engagement_specs")
  private List<TargetingDynamicRule> mEngagementSpecs = null;
  @SerializedName("ethnic_affinity")
  private List<IDName> mEthnicAffinity = null;
  @SerializedName("exclude_reached_since")
  private List<String> mExcludeReachedSince = null;
  @SerializedName("excluded_connections")
  private List<IDName> mExcludedConnections = null;
  @SerializedName("excluded_custom_audiences")
  private List<IDName> mExcludedCustomAudiences = null;
  @SerializedName("excluded_dynamic_audience_ids")
  private List<String> mExcludedDynamicAudienceIds = null;
  @SerializedName("excluded_engagement_specs")
  private List<TargetingDynamicRule> mExcludedEngagementSpecs = null;
  @SerializedName("excluded_geo_locations")
  private TargetingGeoLocation mExcludedGeoLocations = null;
  @SerializedName("excluded_mobile_device_model")
  private List<String> mExcludedMobileDeviceModel = null;
  @SerializedName("excluded_product_audience_specs")
  private List<TargetingProductAudienceSpec> mExcludedProductAudienceSpecs = null;
  @SerializedName("excluded_publisher_categories")
  private List<String> mExcludedPublisherCategories = null;
  @SerializedName("excluded_publisher_list_ids")
  private List<String> mExcludedPublisherListIds = null;
  @SerializedName("excluded_user_device")
  private List<String> mExcludedUserDevice = null;
  @SerializedName("exclusions")
  private FlexibleTargeting mExclusions = null;
  @SerializedName("facebook_positions")
  private List<String> mFacebookPositions = null;
  @SerializedName("family_statuses")
  private List<IDName> mFamilyStatuses = null;
  @SerializedName("fb_deal_id")
  private String mFbDealId = null;
  @SerializedName("flexible_spec")
  private List<FlexibleTargeting> mFlexibleSpec = null;
  @SerializedName("friends_of_connections")
  private List<IDName> mFriendsOfConnections = null;
  @SerializedName("genders")
  private List<Long> mGenders = null;
  @SerializedName("generation")
  private List<IDName> mGeneration = null;
  @SerializedName("geo_locations")
  private TargetingGeoLocation mGeoLocations = null;
  @SerializedName("home_ownership")
  private List<IDName> mHomeOwnership = null;
  @SerializedName("home_type")
  private List<IDName> mHomeType = null;
  @SerializedName("home_value")
  private List<IDName> mHomeValue = null;
  @SerializedName("household_composition")
  private List<IDName> mHouseholdComposition = null;
  @SerializedName("income")
  private List<IDName> mIncome = null;
  @SerializedName("industries")
  private List<IDName> mIndustries = null;
  @SerializedName("instagram_positions")
  private List<String> mInstagramPositions = null;
  @SerializedName("interested_in")
  private List<Long> mInterestedIn = null;
  @SerializedName("interests")
  private List<IDName> mInterests = null;
  @SerializedName("keywords")
  private List<String> mKeywords = null;
  @SerializedName("life_events")
  private List<IDName> mLifeEvents = null;
  @SerializedName("locales")
  private List<Long> mLocales = null;
  @SerializedName("messenger_positions")
  private List<String> mMessengerPositions = null;
  @SerializedName("moms")
  private List<IDName> mMoms = null;
  @SerializedName("net_worth")
  private List<IDName> mNetWorth = null;
  @SerializedName("office_type")
  private List<IDName> mOfficeType = null;
  @SerializedName("page_types")
  private List<String> mPageTypes = null;
  @SerializedName("place_page_set_ids")
  private List<String> mPlacePageSetIds = null;
  @SerializedName("political_views")
  private List<Long> mPoliticalViews = null;
  @SerializedName("politics")
  private List<IDName> mPolitics = null;
  @SerializedName("product_audience_specs")
  private List<TargetingProductAudienceSpec> mProductAudienceSpecs = null;
  @SerializedName("publisher_platforms")
  private List<String> mPublisherPlatforms = null;
  @SerializedName("publisher_visibility_categories")
  private List<String> mPublisherVisibilityCategories = null;
  @SerializedName("radius")
  private String mRadius = null;
  @SerializedName("regions")
  private List<IDName> mRegions = null;
  @SerializedName("relationship_statuses")
  private List<Long> mRelationshipStatuses = null;
  @SerializedName("rtb_flag")
  private Boolean mRtbFlag = null;
  @SerializedName("site_category")
  private List<String> mSiteCategory = null;
  @SerializedName("targeting_optimization")
  private String mTargetingOptimization = null;
  @SerializedName("user_adclusters")
  private List<IDName> mUserAdclusters = null;
  @SerializedName("user_device")
  private List<String> mUserDevice = null;
  @SerializedName("user_event")
  private List<Long> mUserEvent = null;
  @SerializedName("user_os")
  private List<String> mUserOs = null;
  @SerializedName("wireless_carrier")
  private List<String> mWirelessCarrier = null;
  @SerializedName("work_employers")
  private List<IDName> mWorkEmployers = null;
  @SerializedName("work_positions")
  private List<IDName> mWorkPositions = null;
  @SerializedName("zips")
  private List<String> mZips = null;
  protected static Gson gson = null;

  public Targeting() {
  }

  public String getId() {
    return null;
  }
  public static Targeting loadJSON(String json, APIContext context) {
    Targeting targeting = getGson().fromJson(json, Targeting.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(targeting.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    targeting.context = context;
    targeting.rawValue = json;
    return targeting;
  }

  public static APINodeList<Targeting> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Targeting> targetings = new APINodeList<Targeting>(request, json);
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
          targetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return targetings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            targetings.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              targetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  targetings.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              targetings.add(loadJSON(obj.toString(), context));
            }
          }
          return targetings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              targetings.add(loadJSON(entry.getValue().toString(), context));
          }
          return targetings;
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
              targetings.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return targetings;
          }

          // Sixth, check if it's pure JsonObject
          targetings.clear();
          targetings.add(loadJSON(json, context));
          return targetings;
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


  public String getFieldAdgroupId() {
    return mAdgroupId;
  }

  public Targeting setFieldAdgroupId(String value) {
    this.mAdgroupId = value;
    return this;
  }

  public Long getFieldAgeMax() {
    return mAgeMax;
  }

  public Targeting setFieldAgeMax(Long value) {
    this.mAgeMax = value;
    return this;
  }

  public Long getFieldAgeMin() {
    return mAgeMin;
  }

  public Targeting setFieldAgeMin(Long value) {
    this.mAgeMin = value;
    return this;
  }

  public String getFieldAlternateAutoTargetingOption() {
    return mAlternateAutoTargetingOption;
  }

  public Targeting setFieldAlternateAutoTargetingOption(String value) {
    this.mAlternateAutoTargetingOption = value;
    return this;
  }

  public String getFieldAppInstallState() {
    return mAppInstallState;
  }

  public Targeting setFieldAppInstallState(String value) {
    this.mAppInstallState = value;
    return this;
  }

  public List<String> getFieldAudienceNetworkPositions() {
    return mAudienceNetworkPositions;
  }

  public Targeting setFieldAudienceNetworkPositions(List<String> value) {
    this.mAudienceNetworkPositions = value;
    return this;
  }

  public List<IDName> getFieldBehaviors() {
    return mBehaviors;
  }

  public Targeting setFieldBehaviors(List<IDName> value) {
    this.mBehaviors = value;
    return this;
  }

  public Targeting setFieldBehaviors(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mBehaviors = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldCities() {
    return mCities;
  }

  public Targeting setFieldCities(List<IDName> value) {
    this.mCities = value;
    return this;
  }

  public Targeting setFieldCities(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mCities = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldCollegeYears() {
    return mCollegeYears;
  }

  public Targeting setFieldCollegeYears(List<Long> value) {
    this.mCollegeYears = value;
    return this;
  }

  public List<IDName> getFieldConnections() {
    return mConnections;
  }

  public Targeting setFieldConnections(List<IDName> value) {
    this.mConnections = value;
    return this;
  }

  public Targeting setFieldConnections(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mConnections = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldContextualTargetingCategories() {
    return mContextualTargetingCategories;
  }

  public Targeting setFieldContextualTargetingCategories(List<IDName> value) {
    this.mContextualTargetingCategories = value;
    return this;
  }

  public Targeting setFieldContextualTargetingCategories(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mContextualTargetingCategories = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldCountries() {
    return mCountries;
  }

  public Targeting setFieldCountries(List<String> value) {
    this.mCountries = value;
    return this;
  }

  public List<String> getFieldCountry() {
    return mCountry;
  }

  public Targeting setFieldCountry(List<String> value) {
    this.mCountry = value;
    return this;
  }

  public List<String> getFieldCountryGroups() {
    return mCountryGroups;
  }

  public Targeting setFieldCountryGroups(List<String> value) {
    this.mCountryGroups = value;
    return this;
  }

  public List<IDName> getFieldCustomAudiences() {
    return mCustomAudiences;
  }

  public Targeting setFieldCustomAudiences(List<IDName> value) {
    this.mCustomAudiences = value;
    return this;
  }

  public Targeting setFieldCustomAudiences(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mCustomAudiences = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<EnumDevicePlatforms> getFieldDevicePlatforms() {
    return mDevicePlatforms;
  }

  public Targeting setFieldDevicePlatforms(List<EnumDevicePlatforms> value) {
    this.mDevicePlatforms = value;
    return this;
  }

  public List<String> getFieldDynamicAudienceIds() {
    return mDynamicAudienceIds;
  }

  public Targeting setFieldDynamicAudienceIds(List<String> value) {
    this.mDynamicAudienceIds = value;
    return this;
  }

  public List<IDName> getFieldEducationMajors() {
    return mEducationMajors;
  }

  public Targeting setFieldEducationMajors(List<IDName> value) {
    this.mEducationMajors = value;
    return this;
  }

  public Targeting setFieldEducationMajors(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEducationMajors = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldEducationSchools() {
    return mEducationSchools;
  }

  public Targeting setFieldEducationSchools(List<IDName> value) {
    this.mEducationSchools = value;
    return this;
  }

  public Targeting setFieldEducationSchools(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEducationSchools = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldEducationStatuses() {
    return mEducationStatuses;
  }

  public Targeting setFieldEducationStatuses(List<Long> value) {
    this.mEducationStatuses = value;
    return this;
  }

  public List<String> getFieldEffectiveAudienceNetworkPositions() {
    return mEffectiveAudienceNetworkPositions;
  }

  public Targeting setFieldEffectiveAudienceNetworkPositions(List<String> value) {
    this.mEffectiveAudienceNetworkPositions = value;
    return this;
  }

  public List<EnumEffectiveDevicePlatforms> getFieldEffectiveDevicePlatforms() {
    return mEffectiveDevicePlatforms;
  }

  public Targeting setFieldEffectiveDevicePlatforms(List<EnumEffectiveDevicePlatforms> value) {
    this.mEffectiveDevicePlatforms = value;
    return this;
  }

  public List<String> getFieldEffectiveFacebookPositions() {
    return mEffectiveFacebookPositions;
  }

  public Targeting setFieldEffectiveFacebookPositions(List<String> value) {
    this.mEffectiveFacebookPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveInstagramPositions() {
    return mEffectiveInstagramPositions;
  }

  public Targeting setFieldEffectiveInstagramPositions(List<String> value) {
    this.mEffectiveInstagramPositions = value;
    return this;
  }

  public List<String> getFieldEffectiveMessengerPositions() {
    return mEffectiveMessengerPositions;
  }

  public Targeting setFieldEffectiveMessengerPositions(List<String> value) {
    this.mEffectiveMessengerPositions = value;
    return this;
  }

  public List<String> getFieldEffectivePublisherPlatforms() {
    return mEffectivePublisherPlatforms;
  }

  public Targeting setFieldEffectivePublisherPlatforms(List<String> value) {
    this.mEffectivePublisherPlatforms = value;
    return this;
  }

  public List<TargetingDynamicRule> getFieldEngagementSpecs() {
    return mEngagementSpecs;
  }

  public Targeting setFieldEngagementSpecs(List<TargetingDynamicRule> value) {
    this.mEngagementSpecs = value;
    return this;
  }

  public Targeting setFieldEngagementSpecs(String value) {
    Type type = new TypeToken<List<TargetingDynamicRule>>(){}.getType();
    this.mEngagementSpecs = TargetingDynamicRule.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldEthnicAffinity() {
    return mEthnicAffinity;
  }

  public Targeting setFieldEthnicAffinity(List<IDName> value) {
    this.mEthnicAffinity = value;
    return this;
  }

  public Targeting setFieldEthnicAffinity(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEthnicAffinity = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldExcludeReachedSince() {
    return mExcludeReachedSince;
  }

  public Targeting setFieldExcludeReachedSince(List<String> value) {
    this.mExcludeReachedSince = value;
    return this;
  }

  public List<IDName> getFieldExcludedConnections() {
    return mExcludedConnections;
  }

  public Targeting setFieldExcludedConnections(List<IDName> value) {
    this.mExcludedConnections = value;
    return this;
  }

  public Targeting setFieldExcludedConnections(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mExcludedConnections = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldExcludedCustomAudiences() {
    return mExcludedCustomAudiences;
  }

  public Targeting setFieldExcludedCustomAudiences(List<IDName> value) {
    this.mExcludedCustomAudiences = value;
    return this;
  }

  public Targeting setFieldExcludedCustomAudiences(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mExcludedCustomAudiences = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldExcludedDynamicAudienceIds() {
    return mExcludedDynamicAudienceIds;
  }

  public Targeting setFieldExcludedDynamicAudienceIds(List<String> value) {
    this.mExcludedDynamicAudienceIds = value;
    return this;
  }

  public List<TargetingDynamicRule> getFieldExcludedEngagementSpecs() {
    return mExcludedEngagementSpecs;
  }

  public Targeting setFieldExcludedEngagementSpecs(List<TargetingDynamicRule> value) {
    this.mExcludedEngagementSpecs = value;
    return this;
  }

  public Targeting setFieldExcludedEngagementSpecs(String value) {
    Type type = new TypeToken<List<TargetingDynamicRule>>(){}.getType();
    this.mExcludedEngagementSpecs = TargetingDynamicRule.getGson().fromJson(value, type);
    return this;
  }
  public TargetingGeoLocation getFieldExcludedGeoLocations() {
    return mExcludedGeoLocations;
  }

  public Targeting setFieldExcludedGeoLocations(TargetingGeoLocation value) {
    this.mExcludedGeoLocations = value;
    return this;
  }

  public Targeting setFieldExcludedGeoLocations(String value) {
    Type type = new TypeToken<TargetingGeoLocation>(){}.getType();
    this.mExcludedGeoLocations = TargetingGeoLocation.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldExcludedMobileDeviceModel() {
    return mExcludedMobileDeviceModel;
  }

  public Targeting setFieldExcludedMobileDeviceModel(List<String> value) {
    this.mExcludedMobileDeviceModel = value;
    return this;
  }

  public List<TargetingProductAudienceSpec> getFieldExcludedProductAudienceSpecs() {
    return mExcludedProductAudienceSpecs;
  }

  public Targeting setFieldExcludedProductAudienceSpecs(List<TargetingProductAudienceSpec> value) {
    this.mExcludedProductAudienceSpecs = value;
    return this;
  }

  public Targeting setFieldExcludedProductAudienceSpecs(String value) {
    Type type = new TypeToken<List<TargetingProductAudienceSpec>>(){}.getType();
    this.mExcludedProductAudienceSpecs = TargetingProductAudienceSpec.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldExcludedPublisherCategories() {
    return mExcludedPublisherCategories;
  }

  public Targeting setFieldExcludedPublisherCategories(List<String> value) {
    this.mExcludedPublisherCategories = value;
    return this;
  }

  public List<String> getFieldExcludedPublisherListIds() {
    return mExcludedPublisherListIds;
  }

  public Targeting setFieldExcludedPublisherListIds(List<String> value) {
    this.mExcludedPublisherListIds = value;
    return this;
  }

  public List<String> getFieldExcludedUserDevice() {
    return mExcludedUserDevice;
  }

  public Targeting setFieldExcludedUserDevice(List<String> value) {
    this.mExcludedUserDevice = value;
    return this;
  }

  public FlexibleTargeting getFieldExclusions() {
    return mExclusions;
  }

  public Targeting setFieldExclusions(FlexibleTargeting value) {
    this.mExclusions = value;
    return this;
  }

  public Targeting setFieldExclusions(String value) {
    Type type = new TypeToken<FlexibleTargeting>(){}.getType();
    this.mExclusions = FlexibleTargeting.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldFacebookPositions() {
    return mFacebookPositions;
  }

  public Targeting setFieldFacebookPositions(List<String> value) {
    this.mFacebookPositions = value;
    return this;
  }

  public List<IDName> getFieldFamilyStatuses() {
    return mFamilyStatuses;
  }

  public Targeting setFieldFamilyStatuses(List<IDName> value) {
    this.mFamilyStatuses = value;
    return this;
  }

  public Targeting setFieldFamilyStatuses(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mFamilyStatuses = IDName.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldFbDealId() {
    return mFbDealId;
  }

  public Targeting setFieldFbDealId(String value) {
    this.mFbDealId = value;
    return this;
  }

  public List<FlexibleTargeting> getFieldFlexibleSpec() {
    return mFlexibleSpec;
  }

  public Targeting setFieldFlexibleSpec(List<FlexibleTargeting> value) {
    this.mFlexibleSpec = value;
    return this;
  }

  public Targeting setFieldFlexibleSpec(String value) {
    Type type = new TypeToken<List<FlexibleTargeting>>(){}.getType();
    this.mFlexibleSpec = FlexibleTargeting.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldFriendsOfConnections() {
    return mFriendsOfConnections;
  }

  public Targeting setFieldFriendsOfConnections(List<IDName> value) {
    this.mFriendsOfConnections = value;
    return this;
  }

  public Targeting setFieldFriendsOfConnections(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mFriendsOfConnections = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldGenders() {
    return mGenders;
  }

  public Targeting setFieldGenders(List<Long> value) {
    this.mGenders = value;
    return this;
  }

  public List<IDName> getFieldGeneration() {
    return mGeneration;
  }

  public Targeting setFieldGeneration(List<IDName> value) {
    this.mGeneration = value;
    return this;
  }

  public Targeting setFieldGeneration(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mGeneration = IDName.getGson().fromJson(value, type);
    return this;
  }
  public TargetingGeoLocation getFieldGeoLocations() {
    return mGeoLocations;
  }

  public Targeting setFieldGeoLocations(TargetingGeoLocation value) {
    this.mGeoLocations = value;
    return this;
  }

  public Targeting setFieldGeoLocations(String value) {
    Type type = new TypeToken<TargetingGeoLocation>(){}.getType();
    this.mGeoLocations = TargetingGeoLocation.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeOwnership() {
    return mHomeOwnership;
  }

  public Targeting setFieldHomeOwnership(List<IDName> value) {
    this.mHomeOwnership = value;
    return this;
  }

  public Targeting setFieldHomeOwnership(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeOwnership = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeType() {
    return mHomeType;
  }

  public Targeting setFieldHomeType(List<IDName> value) {
    this.mHomeType = value;
    return this;
  }

  public Targeting setFieldHomeType(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeType = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeValue() {
    return mHomeValue;
  }

  public Targeting setFieldHomeValue(List<IDName> value) {
    this.mHomeValue = value;
    return this;
  }

  public Targeting setFieldHomeValue(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeValue = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHouseholdComposition() {
    return mHouseholdComposition;
  }

  public Targeting setFieldHouseholdComposition(List<IDName> value) {
    this.mHouseholdComposition = value;
    return this;
  }

  public Targeting setFieldHouseholdComposition(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHouseholdComposition = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldIncome() {
    return mIncome;
  }

  public Targeting setFieldIncome(List<IDName> value) {
    this.mIncome = value;
    return this;
  }

  public Targeting setFieldIncome(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mIncome = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldIndustries() {
    return mIndustries;
  }

  public Targeting setFieldIndustries(List<IDName> value) {
    this.mIndustries = value;
    return this;
  }

  public Targeting setFieldIndustries(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mIndustries = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldInstagramPositions() {
    return mInstagramPositions;
  }

  public Targeting setFieldInstagramPositions(List<String> value) {
    this.mInstagramPositions = value;
    return this;
  }

  public List<Long> getFieldInterestedIn() {
    return mInterestedIn;
  }

  public Targeting setFieldInterestedIn(List<Long> value) {
    this.mInterestedIn = value;
    return this;
  }

  public List<IDName> getFieldInterests() {
    return mInterests;
  }

  public Targeting setFieldInterests(List<IDName> value) {
    this.mInterests = value;
    return this;
  }

  public Targeting setFieldInterests(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mInterests = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldKeywords() {
    return mKeywords;
  }

  public Targeting setFieldKeywords(List<String> value) {
    this.mKeywords = value;
    return this;
  }

  public List<IDName> getFieldLifeEvents() {
    return mLifeEvents;
  }

  public Targeting setFieldLifeEvents(List<IDName> value) {
    this.mLifeEvents = value;
    return this;
  }

  public Targeting setFieldLifeEvents(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mLifeEvents = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldLocales() {
    return mLocales;
  }

  public Targeting setFieldLocales(List<Long> value) {
    this.mLocales = value;
    return this;
  }

  public List<String> getFieldMessengerPositions() {
    return mMessengerPositions;
  }

  public Targeting setFieldMessengerPositions(List<String> value) {
    this.mMessengerPositions = value;
    return this;
  }

  public List<IDName> getFieldMoms() {
    return mMoms;
  }

  public Targeting setFieldMoms(List<IDName> value) {
    this.mMoms = value;
    return this;
  }

  public Targeting setFieldMoms(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mMoms = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldNetWorth() {
    return mNetWorth;
  }

  public Targeting setFieldNetWorth(List<IDName> value) {
    this.mNetWorth = value;
    return this;
  }

  public Targeting setFieldNetWorth(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mNetWorth = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldOfficeType() {
    return mOfficeType;
  }

  public Targeting setFieldOfficeType(List<IDName> value) {
    this.mOfficeType = value;
    return this;
  }

  public Targeting setFieldOfficeType(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mOfficeType = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldPageTypes() {
    return mPageTypes;
  }

  public Targeting setFieldPageTypes(List<String> value) {
    this.mPageTypes = value;
    return this;
  }

  public List<String> getFieldPlacePageSetIds() {
    return mPlacePageSetIds;
  }

  public Targeting setFieldPlacePageSetIds(List<String> value) {
    this.mPlacePageSetIds = value;
    return this;
  }

  public List<Long> getFieldPoliticalViews() {
    return mPoliticalViews;
  }

  public Targeting setFieldPoliticalViews(List<Long> value) {
    this.mPoliticalViews = value;
    return this;
  }

  public List<IDName> getFieldPolitics() {
    return mPolitics;
  }

  public Targeting setFieldPolitics(List<IDName> value) {
    this.mPolitics = value;
    return this;
  }

  public Targeting setFieldPolitics(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mPolitics = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<TargetingProductAudienceSpec> getFieldProductAudienceSpecs() {
    return mProductAudienceSpecs;
  }

  public Targeting setFieldProductAudienceSpecs(List<TargetingProductAudienceSpec> value) {
    this.mProductAudienceSpecs = value;
    return this;
  }

  public Targeting setFieldProductAudienceSpecs(String value) {
    Type type = new TypeToken<List<TargetingProductAudienceSpec>>(){}.getType();
    this.mProductAudienceSpecs = TargetingProductAudienceSpec.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldPublisherPlatforms() {
    return mPublisherPlatforms;
  }

  public Targeting setFieldPublisherPlatforms(List<String> value) {
    this.mPublisherPlatforms = value;
    return this;
  }

  public List<String> getFieldPublisherVisibilityCategories() {
    return mPublisherVisibilityCategories;
  }

  public Targeting setFieldPublisherVisibilityCategories(List<String> value) {
    this.mPublisherVisibilityCategories = value;
    return this;
  }

  public String getFieldRadius() {
    return mRadius;
  }

  public Targeting setFieldRadius(String value) {
    this.mRadius = value;
    return this;
  }

  public List<IDName> getFieldRegions() {
    return mRegions;
  }

  public Targeting setFieldRegions(List<IDName> value) {
    this.mRegions = value;
    return this;
  }

  public Targeting setFieldRegions(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mRegions = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldRelationshipStatuses() {
    return mRelationshipStatuses;
  }

  public Targeting setFieldRelationshipStatuses(List<Long> value) {
    this.mRelationshipStatuses = value;
    return this;
  }

  public Boolean getFieldRtbFlag() {
    return mRtbFlag;
  }

  public Targeting setFieldRtbFlag(Boolean value) {
    this.mRtbFlag = value;
    return this;
  }

  public List<String> getFieldSiteCategory() {
    return mSiteCategory;
  }

  public Targeting setFieldSiteCategory(List<String> value) {
    this.mSiteCategory = value;
    return this;
  }

  public String getFieldTargetingOptimization() {
    return mTargetingOptimization;
  }

  public Targeting setFieldTargetingOptimization(String value) {
    this.mTargetingOptimization = value;
    return this;
  }

  public List<IDName> getFieldUserAdclusters() {
    return mUserAdclusters;
  }

  public Targeting setFieldUserAdclusters(List<IDName> value) {
    this.mUserAdclusters = value;
    return this;
  }

  public Targeting setFieldUserAdclusters(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mUserAdclusters = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldUserDevice() {
    return mUserDevice;
  }

  public Targeting setFieldUserDevice(List<String> value) {
    this.mUserDevice = value;
    return this;
  }

  public List<Long> getFieldUserEvent() {
    return mUserEvent;
  }

  public Targeting setFieldUserEvent(List<Long> value) {
    this.mUserEvent = value;
    return this;
  }

  public List<String> getFieldUserOs() {
    return mUserOs;
  }

  public Targeting setFieldUserOs(List<String> value) {
    this.mUserOs = value;
    return this;
  }

  public List<String> getFieldWirelessCarrier() {
    return mWirelessCarrier;
  }

  public Targeting setFieldWirelessCarrier(List<String> value) {
    this.mWirelessCarrier = value;
    return this;
  }

  public List<IDName> getFieldWorkEmployers() {
    return mWorkEmployers;
  }

  public Targeting setFieldWorkEmployers(List<IDName> value) {
    this.mWorkEmployers = value;
    return this;
  }

  public Targeting setFieldWorkEmployers(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mWorkEmployers = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldWorkPositions() {
    return mWorkPositions;
  }

  public Targeting setFieldWorkPositions(List<IDName> value) {
    this.mWorkPositions = value;
    return this;
  }

  public Targeting setFieldWorkPositions(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mWorkPositions = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldZips() {
    return mZips;
  }

  public Targeting setFieldZips(List<String> value) {
    this.mZips = value;
    return this;
  }



  public static enum EnumDevicePlatforms {
      @SerializedName("mobile")
      VALUE_MOBILE("mobile"),
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("connected_tv")
      VALUE_CONNECTED_TV("connected_tv"),
      NULL(null);

      private String value;

      private EnumDevicePlatforms(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEffectiveDevicePlatforms {
      @SerializedName("mobile")
      VALUE_MOBILE("mobile"),
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("connected_tv")
      VALUE_CONNECTED_TV("connected_tv"),
      NULL(null);

      private String value;

      private EnumEffectiveDevicePlatforms(String value) {
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

  public Targeting copyFrom(Targeting instance) {
    this.mAdgroupId = instance.mAdgroupId;
    this.mAgeMax = instance.mAgeMax;
    this.mAgeMin = instance.mAgeMin;
    this.mAlternateAutoTargetingOption = instance.mAlternateAutoTargetingOption;
    this.mAppInstallState = instance.mAppInstallState;
    this.mAudienceNetworkPositions = instance.mAudienceNetworkPositions;
    this.mBehaviors = instance.mBehaviors;
    this.mCities = instance.mCities;
    this.mCollegeYears = instance.mCollegeYears;
    this.mConnections = instance.mConnections;
    this.mContextualTargetingCategories = instance.mContextualTargetingCategories;
    this.mCountries = instance.mCountries;
    this.mCountry = instance.mCountry;
    this.mCountryGroups = instance.mCountryGroups;
    this.mCustomAudiences = instance.mCustomAudiences;
    this.mDevicePlatforms = instance.mDevicePlatforms;
    this.mDynamicAudienceIds = instance.mDynamicAudienceIds;
    this.mEducationMajors = instance.mEducationMajors;
    this.mEducationSchools = instance.mEducationSchools;
    this.mEducationStatuses = instance.mEducationStatuses;
    this.mEffectiveAudienceNetworkPositions = instance.mEffectiveAudienceNetworkPositions;
    this.mEffectiveDevicePlatforms = instance.mEffectiveDevicePlatforms;
    this.mEffectiveFacebookPositions = instance.mEffectiveFacebookPositions;
    this.mEffectiveInstagramPositions = instance.mEffectiveInstagramPositions;
    this.mEffectiveMessengerPositions = instance.mEffectiveMessengerPositions;
    this.mEffectivePublisherPlatforms = instance.mEffectivePublisherPlatforms;
    this.mEngagementSpecs = instance.mEngagementSpecs;
    this.mEthnicAffinity = instance.mEthnicAffinity;
    this.mExcludeReachedSince = instance.mExcludeReachedSince;
    this.mExcludedConnections = instance.mExcludedConnections;
    this.mExcludedCustomAudiences = instance.mExcludedCustomAudiences;
    this.mExcludedDynamicAudienceIds = instance.mExcludedDynamicAudienceIds;
    this.mExcludedEngagementSpecs = instance.mExcludedEngagementSpecs;
    this.mExcludedGeoLocations = instance.mExcludedGeoLocations;
    this.mExcludedMobileDeviceModel = instance.mExcludedMobileDeviceModel;
    this.mExcludedProductAudienceSpecs = instance.mExcludedProductAudienceSpecs;
    this.mExcludedPublisherCategories = instance.mExcludedPublisherCategories;
    this.mExcludedPublisherListIds = instance.mExcludedPublisherListIds;
    this.mExcludedUserDevice = instance.mExcludedUserDevice;
    this.mExclusions = instance.mExclusions;
    this.mFacebookPositions = instance.mFacebookPositions;
    this.mFamilyStatuses = instance.mFamilyStatuses;
    this.mFbDealId = instance.mFbDealId;
    this.mFlexibleSpec = instance.mFlexibleSpec;
    this.mFriendsOfConnections = instance.mFriendsOfConnections;
    this.mGenders = instance.mGenders;
    this.mGeneration = instance.mGeneration;
    this.mGeoLocations = instance.mGeoLocations;
    this.mHomeOwnership = instance.mHomeOwnership;
    this.mHomeType = instance.mHomeType;
    this.mHomeValue = instance.mHomeValue;
    this.mHouseholdComposition = instance.mHouseholdComposition;
    this.mIncome = instance.mIncome;
    this.mIndustries = instance.mIndustries;
    this.mInstagramPositions = instance.mInstagramPositions;
    this.mInterestedIn = instance.mInterestedIn;
    this.mInterests = instance.mInterests;
    this.mKeywords = instance.mKeywords;
    this.mLifeEvents = instance.mLifeEvents;
    this.mLocales = instance.mLocales;
    this.mMessengerPositions = instance.mMessengerPositions;
    this.mMoms = instance.mMoms;
    this.mNetWorth = instance.mNetWorth;
    this.mOfficeType = instance.mOfficeType;
    this.mPageTypes = instance.mPageTypes;
    this.mPlacePageSetIds = instance.mPlacePageSetIds;
    this.mPoliticalViews = instance.mPoliticalViews;
    this.mPolitics = instance.mPolitics;
    this.mProductAudienceSpecs = instance.mProductAudienceSpecs;
    this.mPublisherPlatforms = instance.mPublisherPlatforms;
    this.mPublisherVisibilityCategories = instance.mPublisherVisibilityCategories;
    this.mRadius = instance.mRadius;
    this.mRegions = instance.mRegions;
    this.mRelationshipStatuses = instance.mRelationshipStatuses;
    this.mRtbFlag = instance.mRtbFlag;
    this.mSiteCategory = instance.mSiteCategory;
    this.mTargetingOptimization = instance.mTargetingOptimization;
    this.mUserAdclusters = instance.mUserAdclusters;
    this.mUserDevice = instance.mUserDevice;
    this.mUserEvent = instance.mUserEvent;
    this.mUserOs = instance.mUserOs;
    this.mWirelessCarrier = instance.mWirelessCarrier;
    this.mWorkEmployers = instance.mWorkEmployers;
    this.mWorkPositions = instance.mWorkPositions;
    this.mZips = instance.mZips;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Targeting> getParser() {
    return new APIRequest.ResponseParser<Targeting>() {
      public APINodeList<Targeting> parseResponse(String response, APIContext context, APIRequest<Targeting> request) throws MalformedResponseException {
        return Targeting.parseResponse(response, context, request);
      }
    };
  }
}
