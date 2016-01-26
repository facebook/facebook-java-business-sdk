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


public class AdAccountTargetingValidation extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("type")
  private EnumType mType = null;
  @SerializedName("path")
  private List<String> mPath = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("partner")
  private String mPartner = null;
  @SerializedName("audience_size")
  private Long mAudienceSize = null;
  @SerializedName("valid")
  private Boolean mValid = null;
  protected static Gson gson = null;

  public AdAccountTargetingValidation() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountTargetingValidation loadJSON(String json, APIContext context) {
    AdAccountTargetingValidation adAccountTargetingValidation = getGson().fromJson(json, AdAccountTargetingValidation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountTargetingValidation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountTargetingValidation.mContext = context;
    adAccountTargetingValidation.rawValue = json;
    return adAccountTargetingValidation;
  }

  public static APINodeList<AdAccountTargetingValidation> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdAccountTargetingValidation> adAccountTargetingValidations = new APINodeList<AdAccountTargetingValidation>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adAccountTargetingValidations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountTargetingValidations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adAccountTargetingValidations.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountTargetingValidations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adAccountTargetingValidations.add(loadJSON(obj.toString(), context));
          }
          return adAccountTargetingValidations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountTargetingValidations.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountTargetingValidations;
        } else {
          // Fifth, check if it's pure JsonObject
          adAccountTargetingValidations.add(loadJSON(json, context));
          return adAccountTargetingValidations;
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


  public String getFieldId() {
    return mId;
  }

  public AdAccountTargetingValidation setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdAccountTargetingValidation setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public EnumType getFieldType() {
    return mType;
  }

  public AdAccountTargetingValidation setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }

  public List<String> getFieldPath() {
    return mPath;
  }

  public AdAccountTargetingValidation setFieldPath(List<String> value) {
    this.mPath = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdAccountTargetingValidation setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldSource() {
    return mSource;
  }

  public AdAccountTargetingValidation setFieldSource(String value) {
    this.mSource = value;
    return this;
  }

  public String getFieldPartner() {
    return mPartner;
  }

  public AdAccountTargetingValidation setFieldPartner(String value) {
    this.mPartner = value;
    return this;
  }

  public Long getFieldAudienceSize() {
    return mAudienceSize;
  }

  public AdAccountTargetingValidation setFieldAudienceSize(Long value) {
    this.mAudienceSize = value;
    return this;
  }

  public Boolean getFieldValid() {
    return mValid;
  }

  public AdAccountTargetingValidation setFieldValid(Boolean value) {
    this.mValid = value;
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
    @SerializedName("dynamic_audience_ids")
    VALUE_DYNAMIC_AUDIENCE_IDS("dynamic_audience_ids"),
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
    @SerializedName("interest_defaults_source")
    VALUE_INTEREST_DEFAULTS_SOURCE("interest_defaults_source"),
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

  public AdAccountTargetingValidation copyFrom(AdAccountTargetingValidation instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mType = instance.mType;
    this.mPath = instance.mPath;
    this.mDescription = instance.mDescription;
    this.mSource = instance.mSource;
    this.mPartner = instance.mPartner;
    this.mAudienceSize = instance.mAudienceSize;
    this.mValid = instance.mValid;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountTargetingValidation> getParser() {
    return new APIRequest.ResponseParser<AdAccountTargetingValidation>() {
      public APINodeList<AdAccountTargetingValidation> parseResponse(String response, APIContext context, APIRequest<AdAccountTargetingValidation> request) {
        return AdAccountTargetingValidation.parseResponse(response, context, request);
      }
    };
  }
}