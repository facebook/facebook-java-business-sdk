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
public class AdAccountTargetingInsights extends APINode {
  @SerializedName("audience_size")
  private Long mAudienceSize = null;
  @SerializedName("exploration_ratio")
  private Double mExplorationRatio = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("path")
  private List<String> mPath = null;
  @SerializedName("performance_rating")
  private Long mPerformanceRating = null;
  @SerializedName("recommendation_rating")
  private Long mRecommendationRating = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("type")
  private EnumType mType = null;
  protected static Gson gson = null;

  public AdAccountTargetingInsights() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountTargetingInsights loadJSON(String json, APIContext context) {
    AdAccountTargetingInsights adAccountTargetingInsights = getGson().fromJson(json, AdAccountTargetingInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountTargetingInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountTargetingInsights.context = context;
    adAccountTargetingInsights.rawValue = json;
    return adAccountTargetingInsights;
  }

  public static APINodeList<AdAccountTargetingInsights> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountTargetingInsights> adAccountTargetingInsightss = new APINodeList<AdAccountTargetingInsights>(request, json);
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
          adAccountTargetingInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountTargetingInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adAccountTargetingInsightss.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountTargetingInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountTargetingInsightss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountTargetingInsightss.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountTargetingInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountTargetingInsightss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountTargetingInsightss;
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
              adAccountTargetingInsightss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountTargetingInsightss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountTargetingInsightss.clear();
          adAccountTargetingInsightss.add(loadJSON(json, context));
          return adAccountTargetingInsightss;
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


  public Long getFieldAudienceSize() {
    return mAudienceSize;
  }

  public AdAccountTargetingInsights setFieldAudienceSize(Long value) {
    this.mAudienceSize = value;
    return this;
  }

  public Double getFieldExplorationRatio() {
    return mExplorationRatio;
  }

  public AdAccountTargetingInsights setFieldExplorationRatio(Double value) {
    this.mExplorationRatio = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdAccountTargetingInsights setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdAccountTargetingInsights setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public List<String> getFieldPath() {
    return mPath;
  }

  public AdAccountTargetingInsights setFieldPath(List<String> value) {
    this.mPath = value;
    return this;
  }

  public Long getFieldPerformanceRating() {
    return mPerformanceRating;
  }

  public AdAccountTargetingInsights setFieldPerformanceRating(Long value) {
    this.mPerformanceRating = value;
    return this;
  }

  public Long getFieldRecommendationRating() {
    return mRecommendationRating;
  }

  public AdAccountTargetingInsights setFieldRecommendationRating(Long value) {
    this.mRecommendationRating = value;
    return this;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public AdAccountTargetingInsights setFieldTags(List<String> value) {
    this.mTags = value;
    return this;
  }

  public EnumType getFieldType() {
    return mType;
  }

  public AdAccountTargetingInsights setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }



  public static enum EnumType {
      @SerializedName("adgroup_id")
      VALUE_ADGROUP_ID("adgroup_id"),
      @SerializedName("genders")
      VALUE_GENDERS("genders"),
      @SerializedName("age_min")
      VALUE_AGE_MIN("age_min"),
      @SerializedName("age_max")
      VALUE_AGE_MAX("age_max"),
      @SerializedName("country_groups")
      VALUE_COUNTRY_GROUPS("country_groups"),
      @SerializedName("countries")
      VALUE_COUNTRIES("countries"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("cities")
      VALUE_CITIES("cities"),
      @SerializedName("radius")
      VALUE_RADIUS("radius"),
      @SerializedName("regions")
      VALUE_REGIONS("regions"),
      @SerializedName("zips")
      VALUE_ZIPS("zips"),
      @SerializedName("interests")
      VALUE_INTERESTS("interests"),
      @SerializedName("keywords")
      VALUE_KEYWORDS("keywords"),
      @SerializedName("education_schools")
      VALUE_EDUCATION_SCHOOLS("education_schools"),
      @SerializedName("education_majors")
      VALUE_EDUCATION_MAJORS("education_majors"),
      @SerializedName("work_positions")
      VALUE_WORK_POSITIONS("work_positions"),
      @SerializedName("work_employers")
      VALUE_WORK_EMPLOYERS("work_employers"),
      @SerializedName("relationship_statuses")
      VALUE_RELATIONSHIP_STATUSES("relationship_statuses"),
      @SerializedName("interested_in")
      VALUE_INTERESTED_IN("interested_in"),
      @SerializedName("locales")
      VALUE_LOCALES("locales"),
      @SerializedName("user_adclusters")
      VALUE_USER_ADCLUSTERS("user_adclusters"),
      @SerializedName("excluded_user_adclusters")
      VALUE_EXCLUDED_USER_ADCLUSTERS("excluded_user_adclusters"),
      @SerializedName("conjunctive_user_adclusters")
      VALUE_CONJUNCTIVE_USER_ADCLUSTERS("conjunctive_user_adclusters"),
      @SerializedName("custom_audiences")
      VALUE_CUSTOM_AUDIENCES("custom_audiences"),
      @SerializedName("excluded_custom_audiences")
      VALUE_EXCLUDED_CUSTOM_AUDIENCES("excluded_custom_audiences"),
      @SerializedName("college_years")
      VALUE_COLLEGE_YEARS("college_years"),
      @SerializedName("education_statuses")
      VALUE_EDUCATION_STATUSES("education_statuses"),
      @SerializedName("connections")
      VALUE_CONNECTIONS("connections"),
      @SerializedName("excluded_connections")
      VALUE_EXCLUDED_CONNECTIONS("excluded_connections"),
      @SerializedName("friends_of_connections")
      VALUE_FRIENDS_OF_CONNECTIONS("friends_of_connections"),
      @SerializedName("user_event")
      VALUE_USER_EVENT("user_event"),
      @SerializedName("page_types")
      VALUE_PAGE_TYPES("page_types"),
      @SerializedName("platforms")
      VALUE_PLATFORMS("platforms"),
      @SerializedName("effective_platforms")
      VALUE_EFFECTIVE_PLATFORMS("effective_platforms"),
      @SerializedName("facebook_positions")
      VALUE_FACEBOOK_POSITIONS("facebook_positions"),
      @SerializedName("effective_facebook_positions")
      VALUE_EFFECTIVE_FACEBOOK_POSITIONS("effective_facebook_positions"),
      @SerializedName("device_platforms")
      VALUE_DEVICE_PLATFORMS("device_platforms"),
      @SerializedName("effective_device_platforms")
      VALUE_EFFECTIVE_DEVICE_PLATFORMS("effective_device_platforms"),
      @SerializedName("dynamic_audience_ids")
      VALUE_DYNAMIC_AUDIENCE_IDS("dynamic_audience_ids"),
      @SerializedName("excluded_dynamic_audience_ids")
      VALUE_EXCLUDED_DYNAMIC_AUDIENCE_IDS("excluded_dynamic_audience_ids"),
      @SerializedName("rtb_flag")
      VALUE_RTB_FLAG("rtb_flag"),
      @SerializedName("user_device")
      VALUE_USER_DEVICE("user_device"),
      @SerializedName("user_os")
      VALUE_USER_OS("user_os"),
      @SerializedName("wireless_carrier")
      VALUE_WIRELESS_CARRIER("wireless_carrier"),
      @SerializedName("site_category")
      VALUE_SITE_CATEGORY("site_category"),
      @SerializedName("geo_locations")
      VALUE_GEO_LOCATIONS("geo_locations"),
      @SerializedName("excluded_geo_locations")
      VALUE_EXCLUDED_GEO_LOCATIONS("excluded_geo_locations"),
      @SerializedName("timezones")
      VALUE_TIMEZONES("timezones"),
      @SerializedName("family_statuses")
      VALUE_FAMILY_STATUSES("family_statuses"),
      @SerializedName("industries")
      VALUE_INDUSTRIES("industries"),
      @SerializedName("life_events")
      VALUE_LIFE_EVENTS("life_events"),
      @SerializedName("political_views")
      VALUE_POLITICAL_VIEWS("political_views"),
      @SerializedName("politics")
      VALUE_POLITICS("politics"),
      @SerializedName("behaviors")
      VALUE_BEHAVIORS("behaviors"),
      @SerializedName("income")
      VALUE_INCOME("income"),
      @SerializedName("net_worth")
      VALUE_NET_WORTH("net_worth"),
      @SerializedName("home_type")
      VALUE_HOME_TYPE("home_type"),
      @SerializedName("home_ownership")
      VALUE_HOME_OWNERSHIP("home_ownership"),
      @SerializedName("home_value")
      VALUE_HOME_VALUE("home_value"),
      @SerializedName("ethnic_affinity")
      VALUE_ETHNIC_AFFINITY("ethnic_affinity"),
      @SerializedName("generation")
      VALUE_GENERATION("generation"),
      @SerializedName("household_composition")
      VALUE_HOUSEHOLD_COMPOSITION("household_composition"),
      @SerializedName("moms")
      VALUE_MOMS("moms"),
      @SerializedName("office_type")
      VALUE_OFFICE_TYPE("office_type"),
      @SerializedName("targeting_optimization")
      VALUE_TARGETING_OPTIMIZATION("targeting_optimization"),
      @SerializedName("engagement_specs")
      VALUE_ENGAGEMENT_SPECS("engagement_specs"),
      @SerializedName("excluded_engagement_specs")
      VALUE_EXCLUDED_ENGAGEMENT_SPECS("excluded_engagement_specs"),
      @SerializedName("product_audience_specs")
      VALUE_PRODUCT_AUDIENCE_SPECS("product_audience_specs"),
      @SerializedName("excluded_product_audience_specs")
      VALUE_EXCLUDED_PRODUCT_AUDIENCE_SPECS("excluded_product_audience_specs"),
      @SerializedName("exclusions")
      VALUE_EXCLUSIONS("exclusions"),
      @SerializedName("flexible_spec")
      VALUE_FLEXIBLE_SPEC("flexible_spec"),
      @SerializedName("exclude_reached_since")
      VALUE_EXCLUDE_REACHED_SINCE("exclude_reached_since"),
      @SerializedName("exclude_previous_days")
      VALUE_EXCLUDE_PREVIOUS_DAYS("exclude_previous_days"),
      @SerializedName("app_install_state")
      VALUE_APP_INSTALL_STATE("app_install_state"),
      @SerializedName("excluded_publisher_categories")
      VALUE_EXCLUDED_PUBLISHER_CATEGORIES("excluded_publisher_categories"),
      @SerializedName("excluded_publisher_list_ids")
      VALUE_EXCLUDED_PUBLISHER_LIST_IDS("excluded_publisher_list_ids"),
      @SerializedName("fb_deal_id")
      VALUE_FB_DEAL_ID("fb_deal_id"),
      @SerializedName("audience_network_positions")
      VALUE_AUDIENCE_NETWORK_POSITIONS("audience_network_positions"),
      @SerializedName("interest_defaults_source")
      VALUE_INTEREST_DEFAULTS_SOURCE("interest_defaults_source"),
      @SerializedName("excluded_mobile_device_model")
      VALUE_EXCLUDED_MOBILE_DEVICE_MODEL("excluded_mobile_device_model"),
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

  public static enum EnumMode {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("FREQUENTLY_USED")
      VALUE_FREQUENTLY_USED("FREQUENTLY_USED"),
      NULL(null);

      private String value;

      private EnumMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjective {
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("WEBSITE_CLICKS")
      VALUE_WEBSITE_CLICKS("WEBSITE_CLICKS"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      NULL(null);

      private String value;

      private EnumObjective(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRankMode {
      @SerializedName("MOST_EXPLORED")
      VALUE_MOST_EXPLORED("MOST_EXPLORED"),
      @SerializedName("LEAST_EXPLORED")
      VALUE_LEAST_EXPLORED("LEAST_EXPLORED"),
      @SerializedName("BEST_PERFORMING")
      VALUE_BEST_PERFORMING("BEST_PERFORMING"),
      @SerializedName("WORST_PERFORMING")
      VALUE_WORST_PERFORMING("WORST_PERFORMING"),
      @SerializedName("RECOMMEND_INCLUSION")
      VALUE_RECOMMEND_INCLUSION("RECOMMEND_INCLUSION"),
      @SerializedName("RECOMMEND_EXCLUSION")
      VALUE_RECOMMEND_EXCLUSION("RECOMMEND_EXCLUSION"),
      NULL(null);

      private String value;

      private EnumRankMode(String value) {
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

  public AdAccountTargetingInsights copyFrom(AdAccountTargetingInsights instance) {
    this.mAudienceSize = instance.mAudienceSize;
    this.mExplorationRatio = instance.mExplorationRatio;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPath = instance.mPath;
    this.mPerformanceRating = instance.mPerformanceRating;
    this.mRecommendationRating = instance.mRecommendationRating;
    this.mTags = instance.mTags;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountTargetingInsights> getParser() {
    return new APIRequest.ResponseParser<AdAccountTargetingInsights>() {
      public APINodeList<AdAccountTargetingInsights> parseResponse(String response, APIContext context, APIRequest<AdAccountTargetingInsights> request) throws MalformedResponseException {
        return AdAccountTargetingInsights.parseResponse(response, context, request);
      }
    };
  }
}