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
public class AdAccountTargetingUnified extends APINode {
  @SerializedName("audience_size_lower_bound")
  private Long mAudienceSizeLowerBound = null;
  @SerializedName("audience_size_upper_bound")
  private Long mAudienceSizeUpperBound = null;
  @SerializedName("conversion_lift")
  private Double mConversionLift = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("img")
  private String mImg = null;
  @SerializedName("info")
  private String mInfo = null;
  @SerializedName("info_title")
  private String mInfoTitle = null;
  @SerializedName("is_recommendation")
  private Boolean mIsRecommendation = null;
  @SerializedName("key")
  private String mKey = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("parent")
  private String mParent = null;
  @SerializedName("partner")
  private String mPartner = null;
  @SerializedName("path")
  private List<String> mPath = null;
  @SerializedName("performance_rating")
  private Long mPerformanceRating = null;
  @SerializedName("raw_name")
  private String mRawName = null;
  @SerializedName("recommendation_model")
  private String mRecommendationModel = null;
  @SerializedName("search_interest_id")
  private String mSearchInterestId = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("valid")
  private Boolean mValid = null;
  protected static Gson gson = null;

  public AdAccountTargetingUnified() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountTargetingUnified loadJSON(String json, APIContext context, String header) {
    AdAccountTargetingUnified adAccountTargetingUnified = getGson().fromJson(json, AdAccountTargetingUnified.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountTargetingUnified.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountTargetingUnified.context = context;
    adAccountTargetingUnified.rawValue = json;
    adAccountTargetingUnified.header = header;
    return adAccountTargetingUnified;
  }

  public static APINodeList<AdAccountTargetingUnified> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountTargetingUnified> adAccountTargetingUnifieds = new APINodeList<AdAccountTargetingUnified>(request, json, header);
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
          adAccountTargetingUnifieds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountTargetingUnifieds;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountTargetingUnifieds.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountTargetingUnifieds.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountTargetingUnifieds.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountTargetingUnifieds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountTargetingUnifieds.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountTargetingUnifieds.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountTargetingUnifieds;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountTargetingUnifieds.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountTargetingUnifieds;
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
              adAccountTargetingUnifieds.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountTargetingUnifieds;
          }

          // Sixth, check if it's pure JsonObject
          adAccountTargetingUnifieds.clear();
          adAccountTargetingUnifieds.add(loadJSON(json, context, header));
          return adAccountTargetingUnifieds;
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


  public Long getFieldAudienceSizeLowerBound() {
    return mAudienceSizeLowerBound;
  }

  public AdAccountTargetingUnified setFieldAudienceSizeLowerBound(Long value) {
    this.mAudienceSizeLowerBound = value;
    return this;
  }

  public Long getFieldAudienceSizeUpperBound() {
    return mAudienceSizeUpperBound;
  }

  public AdAccountTargetingUnified setFieldAudienceSizeUpperBound(Long value) {
    this.mAudienceSizeUpperBound = value;
    return this;
  }

  public Double getFieldConversionLift() {
    return mConversionLift;
  }

  public AdAccountTargetingUnified setFieldConversionLift(Double value) {
    this.mConversionLift = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdAccountTargetingUnified setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdAccountTargetingUnified setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldImg() {
    return mImg;
  }

  public AdAccountTargetingUnified setFieldImg(String value) {
    this.mImg = value;
    return this;
  }

  public String getFieldInfo() {
    return mInfo;
  }

  public AdAccountTargetingUnified setFieldInfo(String value) {
    this.mInfo = value;
    return this;
  }

  public String getFieldInfoTitle() {
    return mInfoTitle;
  }

  public AdAccountTargetingUnified setFieldInfoTitle(String value) {
    this.mInfoTitle = value;
    return this;
  }

  public Boolean getFieldIsRecommendation() {
    return mIsRecommendation;
  }

  public AdAccountTargetingUnified setFieldIsRecommendation(Boolean value) {
    this.mIsRecommendation = value;
    return this;
  }

  public String getFieldKey() {
    return mKey;
  }

  public AdAccountTargetingUnified setFieldKey(String value) {
    this.mKey = value;
    return this;
  }

  public String getFieldLink() {
    return mLink;
  }

  public AdAccountTargetingUnified setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdAccountTargetingUnified setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldParent() {
    return mParent;
  }

  public AdAccountTargetingUnified setFieldParent(String value) {
    this.mParent = value;
    return this;
  }

  public String getFieldPartner() {
    return mPartner;
  }

  public AdAccountTargetingUnified setFieldPartner(String value) {
    this.mPartner = value;
    return this;
  }

  public List<String> getFieldPath() {
    return mPath;
  }

  public AdAccountTargetingUnified setFieldPath(List<String> value) {
    this.mPath = value;
    return this;
  }

  public Long getFieldPerformanceRating() {
    return mPerformanceRating;
  }

  public AdAccountTargetingUnified setFieldPerformanceRating(Long value) {
    this.mPerformanceRating = value;
    return this;
  }

  public String getFieldRawName() {
    return mRawName;
  }

  public AdAccountTargetingUnified setFieldRawName(String value) {
    this.mRawName = value;
    return this;
  }

  public String getFieldRecommendationModel() {
    return mRecommendationModel;
  }

  public AdAccountTargetingUnified setFieldRecommendationModel(String value) {
    this.mRecommendationModel = value;
    return this;
  }

  public String getFieldSearchInterestId() {
    return mSearchInterestId;
  }

  public AdAccountTargetingUnified setFieldSearchInterestId(String value) {
    this.mSearchInterestId = value;
    return this;
  }

  public String getFieldSource() {
    return mSource;
  }

  public AdAccountTargetingUnified setFieldSource(String value) {
    this.mSource = value;
    return this;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public AdAccountTargetingUnified setFieldSpend(Double value) {
    this.mSpend = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public AdAccountTargetingUnified setFieldType(String value) {
    this.mType = value;
    return this;
  }

  public Boolean getFieldValid() {
    return mValid;
  }

  public AdAccountTargetingUnified setFieldValid(Boolean value) {
    this.mValid = value;
    return this;
  }



  public static enum EnumLimitType {
      @SerializedName("behaviors")
      VALUE_BEHAVIORS("behaviors"),
      @SerializedName("college_years")
      VALUE_COLLEGE_YEARS("college_years"),
      @SerializedName("education_majors")
      VALUE_EDUCATION_MAJORS("education_majors"),
      @SerializedName("education_schools")
      VALUE_EDUCATION_SCHOOLS("education_schools"),
      @SerializedName("education_statuses")
      VALUE_EDUCATION_STATUSES("education_statuses"),
      @SerializedName("ethnic_affinity")
      VALUE_ETHNIC_AFFINITY("ethnic_affinity"),
      @SerializedName("family_statuses")
      VALUE_FAMILY_STATUSES("family_statuses"),
      @SerializedName("generation")
      VALUE_GENERATION("generation"),
      @SerializedName("home_ownership")
      VALUE_HOME_OWNERSHIP("home_ownership"),
      @SerializedName("home_type")
      VALUE_HOME_TYPE("home_type"),
      @SerializedName("home_value")
      VALUE_HOME_VALUE("home_value"),
      @SerializedName("household_composition")
      VALUE_HOUSEHOLD_COMPOSITION("household_composition"),
      @SerializedName("income")
      VALUE_INCOME("income"),
      @SerializedName("industries")
      VALUE_INDUSTRIES("industries"),
      @SerializedName("interested_in")
      VALUE_INTERESTED_IN("interested_in"),
      @SerializedName("interests")
      VALUE_INTERESTS("interests"),
      @SerializedName("life_events")
      VALUE_LIFE_EVENTS("life_events"),
      @SerializedName("location_categories")
      VALUE_LOCATION_CATEGORIES("location_categories"),
      @SerializedName("moms")
      VALUE_MOMS("moms"),
      @SerializedName("net_worth")
      VALUE_NET_WORTH("net_worth"),
      @SerializedName("office_type")
      VALUE_OFFICE_TYPE("office_type"),
      @SerializedName("politics")
      VALUE_POLITICS("politics"),
      @SerializedName("relationship_statuses")
      VALUE_RELATIONSHIP_STATUSES("relationship_statuses"),
      @SerializedName("user_adclusters")
      VALUE_USER_ADCLUSTERS("user_adclusters"),
      @SerializedName("work_employers")
      VALUE_WORK_EMPLOYERS("work_employers"),
      @SerializedName("work_positions")
      VALUE_WORK_POSITIONS("work_positions"),
      ;

      private String value;

      private EnumLimitType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRegulatedCategories {
      @SerializedName("CREDIT")
      VALUE_CREDIT("CREDIT"),
      @SerializedName("EMPLOYMENT")
      VALUE_EMPLOYMENT("EMPLOYMENT"),
      @SerializedName("HOUSING")
      VALUE_HOUSING("HOUSING"),
      @SerializedName("ISSUES_ELECTIONS_POLITICS")
      VALUE_ISSUES_ELECTIONS_POLITICS("ISSUES_ELECTIONS_POLITICS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("ONLINE_GAMBLING_AND_GAMING")
      VALUE_ONLINE_GAMBLING_AND_GAMING("ONLINE_GAMBLING_AND_GAMING"),
      ;

      private String value;

      private EnumRegulatedCategories(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRegulatedCountries {
      @SerializedName("AD")
      VALUE_AD("AD"),
      @SerializedName("AE")
      VALUE_AE("AE"),
      @SerializedName("AF")
      VALUE_AF("AF"),
      @SerializedName("AG")
      VALUE_AG("AG"),
      @SerializedName("AI")
      VALUE_AI("AI"),
      @SerializedName("AL")
      VALUE_AL("AL"),
      @SerializedName("AM")
      VALUE_AM("AM"),
      @SerializedName("AN")
      VALUE_AN("AN"),
      @SerializedName("AO")
      VALUE_AO("AO"),
      @SerializedName("AQ")
      VALUE_AQ("AQ"),
      @SerializedName("AR")
      VALUE_AR("AR"),
      @SerializedName("AS")
      VALUE_AS("AS"),
      @SerializedName("AT")
      VALUE_AT("AT"),
      @SerializedName("AU")
      VALUE_AU("AU"),
      @SerializedName("AW")
      VALUE_AW("AW"),
      @SerializedName("AX")
      VALUE_AX("AX"),
      @SerializedName("AZ")
      VALUE_AZ("AZ"),
      @SerializedName("BA")
      VALUE_BA("BA"),
      @SerializedName("BB")
      VALUE_BB("BB"),
      @SerializedName("BD")
      VALUE_BD("BD"),
      @SerializedName("BE")
      VALUE_BE("BE"),
      @SerializedName("BF")
      VALUE_BF("BF"),
      @SerializedName("BG")
      VALUE_BG("BG"),
      @SerializedName("BH")
      VALUE_BH("BH"),
      @SerializedName("BI")
      VALUE_BI("BI"),
      @SerializedName("BJ")
      VALUE_BJ("BJ"),
      @SerializedName("BL")
      VALUE_BL("BL"),
      @SerializedName("BM")
      VALUE_BM("BM"),
      @SerializedName("BN")
      VALUE_BN("BN"),
      @SerializedName("BO")
      VALUE_BO("BO"),
      @SerializedName("BQ")
      VALUE_BQ("BQ"),
      @SerializedName("BR")
      VALUE_BR("BR"),
      @SerializedName("BS")
      VALUE_BS("BS"),
      @SerializedName("BT")
      VALUE_BT("BT"),
      @SerializedName("BV")
      VALUE_BV("BV"),
      @SerializedName("BW")
      VALUE_BW("BW"),
      @SerializedName("BY")
      VALUE_BY("BY"),
      @SerializedName("BZ")
      VALUE_BZ("BZ"),
      @SerializedName("CA")
      VALUE_CA("CA"),
      @SerializedName("CC")
      VALUE_CC("CC"),
      @SerializedName("CD")
      VALUE_CD("CD"),
      @SerializedName("CF")
      VALUE_CF("CF"),
      @SerializedName("CG")
      VALUE_CG("CG"),
      @SerializedName("CH")
      VALUE_CH("CH"),
      @SerializedName("CI")
      VALUE_CI("CI"),
      @SerializedName("CK")
      VALUE_CK("CK"),
      @SerializedName("CL")
      VALUE_CL("CL"),
      @SerializedName("CM")
      VALUE_CM("CM"),
      @SerializedName("CN")
      VALUE_CN("CN"),
      @SerializedName("CO")
      VALUE_CO("CO"),
      @SerializedName("CR")
      VALUE_CR("CR"),
      @SerializedName("CU")
      VALUE_CU("CU"),
      @SerializedName("CV")
      VALUE_CV("CV"),
      @SerializedName("CW")
      VALUE_CW("CW"),
      @SerializedName("CX")
      VALUE_CX("CX"),
      @SerializedName("CY")
      VALUE_CY("CY"),
      @SerializedName("CZ")
      VALUE_CZ("CZ"),
      @SerializedName("DE")
      VALUE_DE("DE"),
      @SerializedName("DJ")
      VALUE_DJ("DJ"),
      @SerializedName("DK")
      VALUE_DK("DK"),
      @SerializedName("DM")
      VALUE_DM("DM"),
      @SerializedName("DO")
      VALUE_DO("DO"),
      @SerializedName("DZ")
      VALUE_DZ("DZ"),
      @SerializedName("EC")
      VALUE_EC("EC"),
      @SerializedName("EE")
      VALUE_EE("EE"),
      @SerializedName("EG")
      VALUE_EG("EG"),
      @SerializedName("EH")
      VALUE_EH("EH"),
      @SerializedName("ER")
      VALUE_ER("ER"),
      @SerializedName("ES")
      VALUE_ES("ES"),
      @SerializedName("ET")
      VALUE_ET("ET"),
      @SerializedName("FI")
      VALUE_FI("FI"),
      @SerializedName("FJ")
      VALUE_FJ("FJ"),
      @SerializedName("FK")
      VALUE_FK("FK"),
      @SerializedName("FM")
      VALUE_FM("FM"),
      @SerializedName("FO")
      VALUE_FO("FO"),
      @SerializedName("FR")
      VALUE_FR("FR"),
      @SerializedName("GA")
      VALUE_GA("GA"),
      @SerializedName("GB")
      VALUE_GB("GB"),
      @SerializedName("GD")
      VALUE_GD("GD"),
      @SerializedName("GE")
      VALUE_GE("GE"),
      @SerializedName("GF")
      VALUE_GF("GF"),
      @SerializedName("GG")
      VALUE_GG("GG"),
      @SerializedName("GH")
      VALUE_GH("GH"),
      @SerializedName("GI")
      VALUE_GI("GI"),
      @SerializedName("GL")
      VALUE_GL("GL"),
      @SerializedName("GM")
      VALUE_GM("GM"),
      @SerializedName("GN")
      VALUE_GN("GN"),
      @SerializedName("GP")
      VALUE_GP("GP"),
      @SerializedName("GQ")
      VALUE_GQ("GQ"),
      @SerializedName("GR")
      VALUE_GR("GR"),
      @SerializedName("GS")
      VALUE_GS("GS"),
      @SerializedName("GT")
      VALUE_GT("GT"),
      @SerializedName("GU")
      VALUE_GU("GU"),
      @SerializedName("GW")
      VALUE_GW("GW"),
      @SerializedName("GY")
      VALUE_GY("GY"),
      @SerializedName("HK")
      VALUE_HK("HK"),
      @SerializedName("HM")
      VALUE_HM("HM"),
      @SerializedName("HN")
      VALUE_HN("HN"),
      @SerializedName("HR")
      VALUE_HR("HR"),
      @SerializedName("HT")
      VALUE_HT("HT"),
      @SerializedName("HU")
      VALUE_HU("HU"),
      @SerializedName("ID")
      VALUE_ID("ID"),
      @SerializedName("IE")
      VALUE_IE("IE"),
      @SerializedName("IL")
      VALUE_IL("IL"),
      @SerializedName("IM")
      VALUE_IM("IM"),
      @SerializedName("IN")
      VALUE_IN("IN"),
      @SerializedName("IO")
      VALUE_IO("IO"),
      @SerializedName("IQ")
      VALUE_IQ("IQ"),
      @SerializedName("IR")
      VALUE_IR("IR"),
      @SerializedName("IS")
      VALUE_IS("IS"),
      @SerializedName("IT")
      VALUE_IT("IT"),
      @SerializedName("JE")
      VALUE_JE("JE"),
      @SerializedName("JM")
      VALUE_JM("JM"),
      @SerializedName("JO")
      VALUE_JO("JO"),
      @SerializedName("JP")
      VALUE_JP("JP"),
      @SerializedName("KE")
      VALUE_KE("KE"),
      @SerializedName("KG")
      VALUE_KG("KG"),
      @SerializedName("KH")
      VALUE_KH("KH"),
      @SerializedName("KI")
      VALUE_KI("KI"),
      @SerializedName("KM")
      VALUE_KM("KM"),
      @SerializedName("KN")
      VALUE_KN("KN"),
      @SerializedName("KP")
      VALUE_KP("KP"),
      @SerializedName("KR")
      VALUE_KR("KR"),
      @SerializedName("KW")
      VALUE_KW("KW"),
      @SerializedName("KY")
      VALUE_KY("KY"),
      @SerializedName("KZ")
      VALUE_KZ("KZ"),
      @SerializedName("LA")
      VALUE_LA("LA"),
      @SerializedName("LB")
      VALUE_LB("LB"),
      @SerializedName("LC")
      VALUE_LC("LC"),
      @SerializedName("LI")
      VALUE_LI("LI"),
      @SerializedName("LK")
      VALUE_LK("LK"),
      @SerializedName("LR")
      VALUE_LR("LR"),
      @SerializedName("LS")
      VALUE_LS("LS"),
      @SerializedName("LT")
      VALUE_LT("LT"),
      @SerializedName("LU")
      VALUE_LU("LU"),
      @SerializedName("LV")
      VALUE_LV("LV"),
      @SerializedName("LY")
      VALUE_LY("LY"),
      @SerializedName("MA")
      VALUE_MA("MA"),
      @SerializedName("MC")
      VALUE_MC("MC"),
      @SerializedName("MD")
      VALUE_MD("MD"),
      @SerializedName("ME")
      VALUE_ME("ME"),
      @SerializedName("MF")
      VALUE_MF("MF"),
      @SerializedName("MG")
      VALUE_MG("MG"),
      @SerializedName("MH")
      VALUE_MH("MH"),
      @SerializedName("MK")
      VALUE_MK("MK"),
      @SerializedName("ML")
      VALUE_ML("ML"),
      @SerializedName("MM")
      VALUE_MM("MM"),
      @SerializedName("MN")
      VALUE_MN("MN"),
      @SerializedName("MO")
      VALUE_MO("MO"),
      @SerializedName("MP")
      VALUE_MP("MP"),
      @SerializedName("MQ")
      VALUE_MQ("MQ"),
      @SerializedName("MR")
      VALUE_MR("MR"),
      @SerializedName("MS")
      VALUE_MS("MS"),
      @SerializedName("MT")
      VALUE_MT("MT"),
      @SerializedName("MU")
      VALUE_MU("MU"),
      @SerializedName("MV")
      VALUE_MV("MV"),
      @SerializedName("MW")
      VALUE_MW("MW"),
      @SerializedName("MX")
      VALUE_MX("MX"),
      @SerializedName("MY")
      VALUE_MY("MY"),
      @SerializedName("MZ")
      VALUE_MZ("MZ"),
      @SerializedName("NA")
      VALUE_NA("NA"),
      @SerializedName("NC")
      VALUE_NC("NC"),
      @SerializedName("NE")
      VALUE_NE("NE"),
      @SerializedName("NF")
      VALUE_NF("NF"),
      @SerializedName("NG")
      VALUE_NG("NG"),
      @SerializedName("NI")
      VALUE_NI("NI"),
      @SerializedName("NL")
      VALUE_NL("NL"),
      @SerializedName("NO")
      VALUE_NO("NO"),
      @SerializedName("NP")
      VALUE_NP("NP"),
      @SerializedName("NR")
      VALUE_NR("NR"),
      @SerializedName("NU")
      VALUE_NU("NU"),
      @SerializedName("NZ")
      VALUE_NZ("NZ"),
      @SerializedName("OM")
      VALUE_OM("OM"),
      @SerializedName("PA")
      VALUE_PA("PA"),
      @SerializedName("PE")
      VALUE_PE("PE"),
      @SerializedName("PF")
      VALUE_PF("PF"),
      @SerializedName("PG")
      VALUE_PG("PG"),
      @SerializedName("PH")
      VALUE_PH("PH"),
      @SerializedName("PK")
      VALUE_PK("PK"),
      @SerializedName("PL")
      VALUE_PL("PL"),
      @SerializedName("PM")
      VALUE_PM("PM"),
      @SerializedName("PN")
      VALUE_PN("PN"),
      @SerializedName("PR")
      VALUE_PR("PR"),
      @SerializedName("PS")
      VALUE_PS("PS"),
      @SerializedName("PT")
      VALUE_PT("PT"),
      @SerializedName("PW")
      VALUE_PW("PW"),
      @SerializedName("PY")
      VALUE_PY("PY"),
      @SerializedName("QA")
      VALUE_QA("QA"),
      @SerializedName("RE")
      VALUE_RE("RE"),
      @SerializedName("RO")
      VALUE_RO("RO"),
      @SerializedName("RS")
      VALUE_RS("RS"),
      @SerializedName("RU")
      VALUE_RU("RU"),
      @SerializedName("RW")
      VALUE_RW("RW"),
      @SerializedName("SA")
      VALUE_SA("SA"),
      @SerializedName("SB")
      VALUE_SB("SB"),
      @SerializedName("SC")
      VALUE_SC("SC"),
      @SerializedName("SD")
      VALUE_SD("SD"),
      @SerializedName("SE")
      VALUE_SE("SE"),
      @SerializedName("SG")
      VALUE_SG("SG"),
      @SerializedName("SH")
      VALUE_SH("SH"),
      @SerializedName("SI")
      VALUE_SI("SI"),
      @SerializedName("SJ")
      VALUE_SJ("SJ"),
      @SerializedName("SK")
      VALUE_SK("SK"),
      @SerializedName("SL")
      VALUE_SL("SL"),
      @SerializedName("SM")
      VALUE_SM("SM"),
      @SerializedName("SN")
      VALUE_SN("SN"),
      @SerializedName("SO")
      VALUE_SO("SO"),
      @SerializedName("SR")
      VALUE_SR("SR"),
      @SerializedName("SS")
      VALUE_SS("SS"),
      @SerializedName("ST")
      VALUE_ST("ST"),
      @SerializedName("SV")
      VALUE_SV("SV"),
      @SerializedName("SX")
      VALUE_SX("SX"),
      @SerializedName("SY")
      VALUE_SY("SY"),
      @SerializedName("SZ")
      VALUE_SZ("SZ"),
      @SerializedName("TC")
      VALUE_TC("TC"),
      @SerializedName("TD")
      VALUE_TD("TD"),
      @SerializedName("TF")
      VALUE_TF("TF"),
      @SerializedName("TG")
      VALUE_TG("TG"),
      @SerializedName("TH")
      VALUE_TH("TH"),
      @SerializedName("TJ")
      VALUE_TJ("TJ"),
      @SerializedName("TK")
      VALUE_TK("TK"),
      @SerializedName("TL")
      VALUE_TL("TL"),
      @SerializedName("TM")
      VALUE_TM("TM"),
      @SerializedName("TN")
      VALUE_TN("TN"),
      @SerializedName("TO")
      VALUE_TO("TO"),
      @SerializedName("TR")
      VALUE_TR("TR"),
      @SerializedName("TT")
      VALUE_TT("TT"),
      @SerializedName("TV")
      VALUE_TV("TV"),
      @SerializedName("TW")
      VALUE_TW("TW"),
      @SerializedName("TZ")
      VALUE_TZ("TZ"),
      @SerializedName("UA")
      VALUE_UA("UA"),
      @SerializedName("UG")
      VALUE_UG("UG"),
      @SerializedName("UM")
      VALUE_UM("UM"),
      @SerializedName("US")
      VALUE_US("US"),
      @SerializedName("UY")
      VALUE_UY("UY"),
      @SerializedName("UZ")
      VALUE_UZ("UZ"),
      @SerializedName("VA")
      VALUE_VA("VA"),
      @SerializedName("VC")
      VALUE_VC("VC"),
      @SerializedName("VE")
      VALUE_VE("VE"),
      @SerializedName("VG")
      VALUE_VG("VG"),
      @SerializedName("VI")
      VALUE_VI("VI"),
      @SerializedName("VN")
      VALUE_VN("VN"),
      @SerializedName("VU")
      VALUE_VU("VU"),
      @SerializedName("WF")
      VALUE_WF("WF"),
      @SerializedName("WS")
      VALUE_WS("WS"),
      @SerializedName("XK")
      VALUE_XK("XK"),
      @SerializedName("YE")
      VALUE_YE("YE"),
      @SerializedName("YT")
      VALUE_YT("YT"),
      @SerializedName("ZA")
      VALUE_ZA("ZA"),
      @SerializedName("ZM")
      VALUE_ZM("ZM"),
      @SerializedName("ZW")
      VALUE_ZW("ZW"),
      ;

      private String value;

      private EnumRegulatedCountries(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumWhitelistedTypes {
      @SerializedName("adgroup_id")
      VALUE_ADGROUP_ID("adgroup_id"),
      @SerializedName("age_max")
      VALUE_AGE_MAX("age_max"),
      @SerializedName("age_min")
      VALUE_AGE_MIN("age_min"),
      @SerializedName("age_range")
      VALUE_AGE_RANGE("age_range"),
      @SerializedName("alternate_auto_targeting_option")
      VALUE_ALTERNATE_AUTO_TARGETING_OPTION("alternate_auto_targeting_option"),
      @SerializedName("app_install_state")
      VALUE_APP_INSTALL_STATE("app_install_state"),
      @SerializedName("audience_network_positions")
      VALUE_AUDIENCE_NETWORK_POSITIONS("audience_network_positions"),
      @SerializedName("behaviors")
      VALUE_BEHAVIORS("behaviors"),
      @SerializedName("brand_safety_content_filter_levels")
      VALUE_BRAND_SAFETY_CONTENT_FILTER_LEVELS("brand_safety_content_filter_levels"),
      @SerializedName("brand_safety_content_severity_levels")
      VALUE_BRAND_SAFETY_CONTENT_SEVERITY_LEVELS("brand_safety_content_severity_levels"),
      @SerializedName("cafe_ca_contraction_targeting_signal")
      VALUE_CAFE_CA_CONTRACTION_TARGETING_SIGNAL("cafe_ca_contraction_targeting_signal"),
      @SerializedName("cafe_ca_expansion_targeting_signal")
      VALUE_CAFE_CA_EXPANSION_TARGETING_SIGNAL("cafe_ca_expansion_targeting_signal"),
      @SerializedName("catalog_based_targeting")
      VALUE_CATALOG_BASED_TARGETING("catalog_based_targeting"),
      @SerializedName("cities")
      VALUE_CITIES("cities"),
      @SerializedName("city_keys")
      VALUE_CITY_KEYS("city_keys"),
      @SerializedName("college_years")
      VALUE_COLLEGE_YEARS("college_years"),
      @SerializedName("conjunctive_user_adclusters")
      VALUE_CONJUNCTIVE_USER_ADCLUSTERS("conjunctive_user_adclusters"),
      @SerializedName("connections")
      VALUE_CONNECTIONS("connections"),
      @SerializedName("contextual_targeting_categories")
      VALUE_CONTEXTUAL_TARGETING_CATEGORIES("contextual_targeting_categories"),
      @SerializedName("countries")
      VALUE_COUNTRIES("countries"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("country_groups")
      VALUE_COUNTRY_GROUPS("country_groups"),
      @SerializedName("custom_audiences")
      VALUE_CUSTOM_AUDIENCES("custom_audiences"),
      @SerializedName("device_platforms")
      VALUE_DEVICE_PLATFORMS("device_platforms"),
      @SerializedName("direct_install_devices")
      VALUE_DIRECT_INSTALL_DEVICES("direct_install_devices"),
      @SerializedName("dynamic_audience_ids")
      VALUE_DYNAMIC_AUDIENCE_IDS("dynamic_audience_ids"),
      @SerializedName("education_majors")
      VALUE_EDUCATION_MAJORS("education_majors"),
      @SerializedName("education_schools")
      VALUE_EDUCATION_SCHOOLS("education_schools"),
      @SerializedName("education_statuses")
      VALUE_EDUCATION_STATUSES("education_statuses"),
      @SerializedName("effective_audience_network_positions")
      VALUE_EFFECTIVE_AUDIENCE_NETWORK_POSITIONS("effective_audience_network_positions"),
      @SerializedName("effective_device_platforms")
      VALUE_EFFECTIVE_DEVICE_PLATFORMS("effective_device_platforms"),
      @SerializedName("effective_facebook_positions")
      VALUE_EFFECTIVE_FACEBOOK_POSITIONS("effective_facebook_positions"),
      @SerializedName("effective_instagram_positions")
      VALUE_EFFECTIVE_INSTAGRAM_POSITIONS("effective_instagram_positions"),
      @SerializedName("effective_messenger_positions")
      VALUE_EFFECTIVE_MESSENGER_POSITIONS("effective_messenger_positions"),
      @SerializedName("effective_oculus_positions")
      VALUE_EFFECTIVE_OCULUS_POSITIONS("effective_oculus_positions"),
      @SerializedName("effective_publisher_platforms")
      VALUE_EFFECTIVE_PUBLISHER_PLATFORMS("effective_publisher_platforms"),
      @SerializedName("effective_whatsapp_positions")
      VALUE_EFFECTIVE_WHATSAPP_POSITIONS("effective_whatsapp_positions"),
      @SerializedName("engagement_specs")
      VALUE_ENGAGEMENT_SPECS("engagement_specs"),
      @SerializedName("ethnic_affinity")
      VALUE_ETHNIC_AFFINITY("ethnic_affinity"),
      @SerializedName("exclude_previous_days")
      VALUE_EXCLUDE_PREVIOUS_DAYS("exclude_previous_days"),
      @SerializedName("exclude_reached_since")
      VALUE_EXCLUDE_REACHED_SINCE("exclude_reached_since"),
      @SerializedName("excluded_brand_safety_content_types")
      VALUE_EXCLUDED_BRAND_SAFETY_CONTENT_TYPES("excluded_brand_safety_content_types"),
      @SerializedName("excluded_connections")
      VALUE_EXCLUDED_CONNECTIONS("excluded_connections"),
      @SerializedName("excluded_custom_audiences")
      VALUE_EXCLUDED_CUSTOM_AUDIENCES("excluded_custom_audiences"),
      @SerializedName("excluded_dynamic_audience_ids")
      VALUE_EXCLUDED_DYNAMIC_AUDIENCE_IDS("excluded_dynamic_audience_ids"),
      @SerializedName("excluded_engagement_specs")
      VALUE_EXCLUDED_ENGAGEMENT_SPECS("excluded_engagement_specs"),
      @SerializedName("excluded_geo_locations")
      VALUE_EXCLUDED_GEO_LOCATIONS("excluded_geo_locations"),
      @SerializedName("excluded_mobile_device_model")
      VALUE_EXCLUDED_MOBILE_DEVICE_MODEL("excluded_mobile_device_model"),
      @SerializedName("excluded_product_audience_specs")
      VALUE_EXCLUDED_PRODUCT_AUDIENCE_SPECS("excluded_product_audience_specs"),
      @SerializedName("excluded_publisher_categories")
      VALUE_EXCLUDED_PUBLISHER_CATEGORIES("excluded_publisher_categories"),
      @SerializedName("excluded_publisher_list_ids")
      VALUE_EXCLUDED_PUBLISHER_LIST_IDS("excluded_publisher_list_ids"),
      @SerializedName("excluded_user_adclusters")
      VALUE_EXCLUDED_USER_ADCLUSTERS("excluded_user_adclusters"),
      @SerializedName("excluded_user_device")
      VALUE_EXCLUDED_USER_DEVICE("excluded_user_device"),
      @SerializedName("exclusions")
      VALUE_EXCLUSIONS("exclusions"),
      @SerializedName("expanded_implicit_custom_audiences")
      VALUE_EXPANDED_IMPLICIT_CUSTOM_AUDIENCES("expanded_implicit_custom_audiences"),
      @SerializedName("facebook_positions")
      VALUE_FACEBOOK_POSITIONS("facebook_positions"),
      @SerializedName("family_statuses")
      VALUE_FAMILY_STATUSES("family_statuses"),
      @SerializedName("fb_deal_id")
      VALUE_FB_DEAL_ID("fb_deal_id"),
      @SerializedName("flexible_spec")
      VALUE_FLEXIBLE_SPEC("flexible_spec"),
      @SerializedName("follow_profiles")
      VALUE_FOLLOW_PROFILES("follow_profiles"),
      @SerializedName("follow_profiles_negative")
      VALUE_FOLLOW_PROFILES_NEGATIVE("follow_profiles_negative"),
      @SerializedName("format")
      VALUE_FORMAT("format"),
      @SerializedName("friends_of_connections")
      VALUE_FRIENDS_OF_CONNECTIONS("friends_of_connections"),
      @SerializedName("gatekeepers")
      VALUE_GATEKEEPERS("gatekeepers"),
      @SerializedName("genders")
      VALUE_GENDERS("genders"),
      @SerializedName("generation")
      VALUE_GENERATION("generation"),
      @SerializedName("geo_locations")
      VALUE_GEO_LOCATIONS("geo_locations"),
      @SerializedName("home_ownership")
      VALUE_HOME_OWNERSHIP("home_ownership"),
      @SerializedName("home_type")
      VALUE_HOME_TYPE("home_type"),
      @SerializedName("home_value")
      VALUE_HOME_VALUE("home_value"),
      @SerializedName("household_composition")
      VALUE_HOUSEHOLD_COMPOSITION("household_composition"),
      @SerializedName("id")
      VALUE_ID("id"),
      @SerializedName("income")
      VALUE_INCOME("income"),
      @SerializedName("industries")
      VALUE_INDUSTRIES("industries"),
      @SerializedName("instagram_hashtags")
      VALUE_INSTAGRAM_HASHTAGS("instagram_hashtags"),
      @SerializedName("instagram_positions")
      VALUE_INSTAGRAM_POSITIONS("instagram_positions"),
      @SerializedName("instream_video_skippable_excluded")
      VALUE_INSTREAM_VIDEO_SKIPPABLE_EXCLUDED("instream_video_skippable_excluded"),
      @SerializedName("instream_video_sponsorship_placements")
      VALUE_INSTREAM_VIDEO_SPONSORSHIP_PLACEMENTS("instream_video_sponsorship_placements"),
      @SerializedName("interest_defaults_source")
      VALUE_INTEREST_DEFAULTS_SOURCE("interest_defaults_source"),
      @SerializedName("interested_in")
      VALUE_INTERESTED_IN("interested_in"),
      @SerializedName("interests")
      VALUE_INTERESTS("interests"),
      @SerializedName("is_instagram_destination_ad")
      VALUE_IS_INSTAGRAM_DESTINATION_AD("is_instagram_destination_ad"),
      @SerializedName("is_whatsapp_destination_ad")
      VALUE_IS_WHATSAPP_DESTINATION_AD("is_whatsapp_destination_ad"),
      @SerializedName("keywords")
      VALUE_KEYWORDS("keywords"),
      @SerializedName("life_events")
      VALUE_LIFE_EVENTS("life_events"),
      @SerializedName("locales")
      VALUE_LOCALES("locales"),
      @SerializedName("location_categories")
      VALUE_LOCATION_CATEGORIES("location_categories"),
      @SerializedName("location_cluster_ids")
      VALUE_LOCATION_CLUSTER_IDS("location_cluster_ids"),
      @SerializedName("location_expansion")
      VALUE_LOCATION_EXPANSION("location_expansion"),
      @SerializedName("marketing_message_channels")
      VALUE_MARKETING_MESSAGE_CHANNELS("marketing_message_channels"),
      @SerializedName("marketing_message_targeting")
      VALUE_MARKETING_MESSAGE_TARGETING("marketing_message_targeting"),
      @SerializedName("marketplace_product_categories")
      VALUE_MARKETPLACE_PRODUCT_CATEGORIES("marketplace_product_categories"),
      @SerializedName("messenger_positions")
      VALUE_MESSENGER_POSITIONS("messenger_positions"),
      @SerializedName("mobile_device_model")
      VALUE_MOBILE_DEVICE_MODEL("mobile_device_model"),
      @SerializedName("moms")
      VALUE_MOMS("moms"),
      @SerializedName("net_worth")
      VALUE_NET_WORTH("net_worth"),
      @SerializedName("oculus_positions")
      VALUE_OCULUS_POSITIONS("oculus_positions"),
      @SerializedName("office_type")
      VALUE_OFFICE_TYPE("office_type"),
      @SerializedName("page_types")
      VALUE_PAGE_TYPES("page_types"),
      @SerializedName("place_page_set_ids")
      VALUE_PLACE_PAGE_SET_IDS("place_page_set_ids"),
      @SerializedName("political_views")
      VALUE_POLITICAL_VIEWS("political_views"),
      @SerializedName("politics")
      VALUE_POLITICS("politics"),
      @SerializedName("product_audience_specs")
      VALUE_PRODUCT_AUDIENCE_SPECS("product_audience_specs"),
      @SerializedName("prospecting_audience")
      VALUE_PROSPECTING_AUDIENCE("prospecting_audience"),
      @SerializedName("publisher_platforms")
      VALUE_PUBLISHER_PLATFORMS("publisher_platforms"),
      @SerializedName("radius")
      VALUE_RADIUS("radius"),
      @SerializedName("region_keys")
      VALUE_REGION_KEYS("region_keys"),
      @SerializedName("regions")
      VALUE_REGIONS("regions"),
      @SerializedName("relationship_statuses")
      VALUE_RELATIONSHIP_STATUSES("relationship_statuses"),
      @SerializedName("rtb_flag")
      VALUE_RTB_FLAG("rtb_flag"),
      @SerializedName("site_category")
      VALUE_SITE_CATEGORY("site_category"),
      @SerializedName("tafe_ca_mitigation_strategy")
      VALUE_TAFE_CA_MITIGATION_STRATEGY("tafe_ca_mitigation_strategy"),
      @SerializedName("targeting_automation")
      VALUE_TARGETING_AUTOMATION("targeting_automation"),
      @SerializedName("targeting_optimization")
      VALUE_TARGETING_OPTIMIZATION("targeting_optimization"),
      @SerializedName("targeting_relaxation_types")
      VALUE_TARGETING_RELAXATION_TYPES("targeting_relaxation_types"),
      @SerializedName("timezones")
      VALUE_TIMEZONES("timezones"),
      @SerializedName("topic")
      VALUE_TOPIC("topic"),
      @SerializedName("trending")
      VALUE_TRENDING("trending"),
      @SerializedName("user_adclusters")
      VALUE_USER_ADCLUSTERS("user_adclusters"),
      @SerializedName("user_device")
      VALUE_USER_DEVICE("user_device"),
      @SerializedName("user_event")
      VALUE_USER_EVENT("user_event"),
      @SerializedName("user_os")
      VALUE_USER_OS("user_os"),
      @SerializedName("user_page_threads")
      VALUE_USER_PAGE_THREADS("user_page_threads"),
      @SerializedName("user_page_threads_excluded")
      VALUE_USER_PAGE_THREADS_EXCLUDED("user_page_threads_excluded"),
      @SerializedName("whatsapp_positions")
      VALUE_WHATSAPP_POSITIONS("whatsapp_positions"),
      @SerializedName("wireless_carrier")
      VALUE_WIRELESS_CARRIER("wireless_carrier"),
      @SerializedName("work_employers")
      VALUE_WORK_EMPLOYERS("work_employers"),
      @SerializedName("work_positions")
      VALUE_WORK_POSITIONS("work_positions"),
      @SerializedName("zips")
      VALUE_ZIPS("zips"),
      ;

      private String value;

      private EnumWhitelistedTypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAppStore {
      @SerializedName("amazon_app_store")
      VALUE_AMAZON_APP_STORE("amazon_app_store"),
      @SerializedName("apk_mirror")
      VALUE_APK_MIRROR("apk_mirror"),
      @SerializedName("apk_monk")
      VALUE_APK_MONK("apk_monk"),
      @SerializedName("apk_pure")
      VALUE_APK_PURE("apk_pure"),
      @SerializedName("aptoide_a1_store")
      VALUE_APTOIDE_A1_STORE("aptoide_a1_store"),
      @SerializedName("bemobi_mobile_store")
      VALUE_BEMOBI_MOBILE_STORE("bemobi_mobile_store"),
      @SerializedName("digital_turbine_store")
      VALUE_DIGITAL_TURBINE_STORE("digital_turbine_store"),
      @SerializedName("does_not_exist")
      VALUE_DOES_NOT_EXIST("does_not_exist"),
      @SerializedName("fb_android_store")
      VALUE_FB_ANDROID_STORE("fb_android_store"),
      @SerializedName("fb_canvas")
      VALUE_FB_CANVAS("fb_canvas"),
      @SerializedName("fb_gameroom")
      VALUE_FB_GAMEROOM("fb_gameroom"),
      @SerializedName("galaxy_store")
      VALUE_GALAXY_STORE("galaxy_store"),
      @SerializedName("google_play")
      VALUE_GOOGLE_PLAY("google_play"),
      @SerializedName("instant_game")
      VALUE_INSTANT_GAME("instant_game"),
      @SerializedName("itunes")
      VALUE_ITUNES("itunes"),
      @SerializedName("itunes_ipad")
      VALUE_ITUNES_IPAD("itunes_ipad"),
      @SerializedName("neon_android_store")
      VALUE_NEON_ANDROID_STORE("neon_android_store"),
      @SerializedName("none")
      VALUE_NONE("none"),
      @SerializedName("oculus_app_store")
      VALUE_OCULUS_APP_STORE("oculus_app_store"),
      @SerializedName("oppo")
      VALUE_OPPO("oppo"),
      @SerializedName("roku_channel_store")
      VALUE_ROKU_CHANNEL_STORE("roku_channel_store"),
      @SerializedName("uptodown")
      VALUE_UPTODOWN("uptodown"),
      @SerializedName("vivo")
      VALUE_VIVO("vivo"),
      @SerializedName("windows_10_store")
      VALUE_WINDOWS_10_STORE("windows_10_store"),
      @SerializedName("windows_store")
      VALUE_WINDOWS_STORE("windows_store"),
      @SerializedName("xiaomi")
      VALUE_XIAOMI("xiaomi"),
      ;

      private String value;

      private EnumAppStore(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjective {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CONVERSIONS")
      VALUE_CONVERSIONS("CONVERSIONS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OUTCOME_APP_PROMOTION")
      VALUE_OUTCOME_APP_PROMOTION("OUTCOME_APP_PROMOTION"),
      @SerializedName("OUTCOME_AWARENESS")
      VALUE_OUTCOME_AWARENESS("OUTCOME_AWARENESS"),
      @SerializedName("OUTCOME_ENGAGEMENT")
      VALUE_OUTCOME_ENGAGEMENT("OUTCOME_ENGAGEMENT"),
      @SerializedName("OUTCOME_LEADS")
      VALUE_OUTCOME_LEADS("OUTCOME_LEADS"),
      @SerializedName("OUTCOME_SALES")
      VALUE_OUTCOME_SALES("OUTCOME_SALES"),
      @SerializedName("OUTCOME_TRAFFIC")
      VALUE_OUTCOME_TRAFFIC("OUTCOME_TRAFFIC"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("STORE_VISITS")
      VALUE_STORE_VISITS("STORE_VISITS"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      ;

      private String value;

      private EnumObjective(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMode {
      @SerializedName("best_performing")
      VALUE_BEST_PERFORMING("best_performing"),
      @SerializedName("recently_used")
      VALUE_RECENTLY_USED("recently_used"),
      @SerializedName("related")
      VALUE_RELATED("related"),
      @SerializedName("suggestions")
      VALUE_SUGGESTIONS("suggestions"),
      ;

      private String value;

      private EnumMode(String value) {
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

  public AdAccountTargetingUnified copyFrom(AdAccountTargetingUnified instance) {
    this.mAudienceSizeLowerBound = instance.mAudienceSizeLowerBound;
    this.mAudienceSizeUpperBound = instance.mAudienceSizeUpperBound;
    this.mConversionLift = instance.mConversionLift;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mImg = instance.mImg;
    this.mInfo = instance.mInfo;
    this.mInfoTitle = instance.mInfoTitle;
    this.mIsRecommendation = instance.mIsRecommendation;
    this.mKey = instance.mKey;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mParent = instance.mParent;
    this.mPartner = instance.mPartner;
    this.mPath = instance.mPath;
    this.mPerformanceRating = instance.mPerformanceRating;
    this.mRawName = instance.mRawName;
    this.mRecommendationModel = instance.mRecommendationModel;
    this.mSearchInterestId = instance.mSearchInterestId;
    this.mSource = instance.mSource;
    this.mSpend = instance.mSpend;
    this.mType = instance.mType;
    this.mValid = instance.mValid;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountTargetingUnified> getParser() {
    return new APIRequest.ResponseParser<AdAccountTargetingUnified>() {
      public APINodeList<AdAccountTargetingUnified> parseResponse(String response, APIContext context, APIRequest<AdAccountTargetingUnified> request, String header) throws MalformedResponseException {
        return AdAccountTargetingUnified.parseResponse(response, context, request, header);
      }
    };
  }
}
