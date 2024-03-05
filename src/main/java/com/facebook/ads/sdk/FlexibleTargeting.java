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
public class FlexibleTargeting extends APINode {
  @SerializedName("behaviors")
  private List<IDName> mBehaviors = null;
  @SerializedName("college_years")
  private List<Long> mCollegeYears = null;
  @SerializedName("connections")
  private List<IDName> mConnections = null;
  @SerializedName("custom_audiences")
  private List<IDName> mCustomAudiences = null;
  @SerializedName("education_majors")
  private List<IDName> mEducationMajors = null;
  @SerializedName("education_schools")
  private List<IDName> mEducationSchools = null;
  @SerializedName("education_statuses")
  private List<Long> mEducationStatuses = null;
  @SerializedName("ethnic_affinity")
  private List<IDName> mEthnicAffinity = null;
  @SerializedName("family_statuses")
  private List<IDName> mFamilyStatuses = null;
  @SerializedName("friends_of_connections")
  private List<IDName> mFriendsOfConnections = null;
  @SerializedName("generation")
  private List<IDName> mGeneration = null;
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
  @SerializedName("interested_in")
  private List<Long> mInterestedIn = null;
  @SerializedName("interests")
  private List<IDName> mInterests = null;
  @SerializedName("life_events")
  private List<IDName> mLifeEvents = null;
  @SerializedName("moms")
  private List<IDName> mMoms = null;
  @SerializedName("net_worth")
  private List<IDName> mNetWorth = null;
  @SerializedName("office_type")
  private List<IDName> mOfficeType = null;
  @SerializedName("politics")
  private List<IDName> mPolitics = null;
  @SerializedName("relationship_statuses")
  private List<Long> mRelationshipStatuses = null;
  @SerializedName("user_adclusters")
  private List<IDName> mUserAdclusters = null;
  @SerializedName("work_employers")
  private List<IDName> mWorkEmployers = null;
  @SerializedName("work_positions")
  private List<IDName> mWorkPositions = null;
  protected static Gson gson = null;

  public FlexibleTargeting() {
  }

  public String getId() {
    return null;
  }
  public static FlexibleTargeting loadJSON(String json, APIContext context, String header) {
    FlexibleTargeting flexibleTargeting = getGson().fromJson(json, FlexibleTargeting.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(flexibleTargeting.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    flexibleTargeting.context = context;
    flexibleTargeting.rawValue = json;
    flexibleTargeting.header = header;
    return flexibleTargeting;
  }

  public static APINodeList<FlexibleTargeting> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FlexibleTargeting> flexibleTargetings = new APINodeList<FlexibleTargeting>(request, json, header);
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
          flexibleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return flexibleTargetings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                flexibleTargetings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            flexibleTargetings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              flexibleTargetings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              flexibleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  flexibleTargetings.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              flexibleTargetings.add(loadJSON(obj.toString(), context, header));
            }
          }
          return flexibleTargetings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              flexibleTargetings.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return flexibleTargetings;
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
              flexibleTargetings.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return flexibleTargetings;
          }

          // Sixth, check if it's pure JsonObject
          flexibleTargetings.clear();
          flexibleTargetings.add(loadJSON(json, context, header));
          return flexibleTargetings;
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


  public List<IDName> getFieldBehaviors() {
    return mBehaviors;
  }

  public FlexibleTargeting setFieldBehaviors(List<IDName> value) {
    this.mBehaviors = value;
    return this;
  }

  public FlexibleTargeting setFieldBehaviors(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mBehaviors = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldCollegeYears() {
    return mCollegeYears;
  }

  public FlexibleTargeting setFieldCollegeYears(List<Long> value) {
    this.mCollegeYears = value;
    return this;
  }

  public List<IDName> getFieldConnections() {
    return mConnections;
  }

  public FlexibleTargeting setFieldConnections(List<IDName> value) {
    this.mConnections = value;
    return this;
  }

  public FlexibleTargeting setFieldConnections(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mConnections = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldCustomAudiences() {
    return mCustomAudiences;
  }

  public FlexibleTargeting setFieldCustomAudiences(List<IDName> value) {
    this.mCustomAudiences = value;
    return this;
  }

  public FlexibleTargeting setFieldCustomAudiences(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mCustomAudiences = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldEducationMajors() {
    return mEducationMajors;
  }

  public FlexibleTargeting setFieldEducationMajors(List<IDName> value) {
    this.mEducationMajors = value;
    return this;
  }

  public FlexibleTargeting setFieldEducationMajors(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEducationMajors = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldEducationSchools() {
    return mEducationSchools;
  }

  public FlexibleTargeting setFieldEducationSchools(List<IDName> value) {
    this.mEducationSchools = value;
    return this;
  }

  public FlexibleTargeting setFieldEducationSchools(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEducationSchools = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldEducationStatuses() {
    return mEducationStatuses;
  }

  public FlexibleTargeting setFieldEducationStatuses(List<Long> value) {
    this.mEducationStatuses = value;
    return this;
  }

  public List<IDName> getFieldEthnicAffinity() {
    return mEthnicAffinity;
  }

  public FlexibleTargeting setFieldEthnicAffinity(List<IDName> value) {
    this.mEthnicAffinity = value;
    return this;
  }

  public FlexibleTargeting setFieldEthnicAffinity(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mEthnicAffinity = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldFamilyStatuses() {
    return mFamilyStatuses;
  }

  public FlexibleTargeting setFieldFamilyStatuses(List<IDName> value) {
    this.mFamilyStatuses = value;
    return this;
  }

  public FlexibleTargeting setFieldFamilyStatuses(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mFamilyStatuses = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldFriendsOfConnections() {
    return mFriendsOfConnections;
  }

  public FlexibleTargeting setFieldFriendsOfConnections(List<IDName> value) {
    this.mFriendsOfConnections = value;
    return this;
  }

  public FlexibleTargeting setFieldFriendsOfConnections(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mFriendsOfConnections = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldGeneration() {
    return mGeneration;
  }

  public FlexibleTargeting setFieldGeneration(List<IDName> value) {
    this.mGeneration = value;
    return this;
  }

  public FlexibleTargeting setFieldGeneration(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mGeneration = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeOwnership() {
    return mHomeOwnership;
  }

  public FlexibleTargeting setFieldHomeOwnership(List<IDName> value) {
    this.mHomeOwnership = value;
    return this;
  }

  public FlexibleTargeting setFieldHomeOwnership(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeOwnership = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeType() {
    return mHomeType;
  }

  public FlexibleTargeting setFieldHomeType(List<IDName> value) {
    this.mHomeType = value;
    return this;
  }

  public FlexibleTargeting setFieldHomeType(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeType = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHomeValue() {
    return mHomeValue;
  }

  public FlexibleTargeting setFieldHomeValue(List<IDName> value) {
    this.mHomeValue = value;
    return this;
  }

  public FlexibleTargeting setFieldHomeValue(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHomeValue = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldHouseholdComposition() {
    return mHouseholdComposition;
  }

  public FlexibleTargeting setFieldHouseholdComposition(List<IDName> value) {
    this.mHouseholdComposition = value;
    return this;
  }

  public FlexibleTargeting setFieldHouseholdComposition(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mHouseholdComposition = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldIncome() {
    return mIncome;
  }

  public FlexibleTargeting setFieldIncome(List<IDName> value) {
    this.mIncome = value;
    return this;
  }

  public FlexibleTargeting setFieldIncome(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mIncome = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldIndustries() {
    return mIndustries;
  }

  public FlexibleTargeting setFieldIndustries(List<IDName> value) {
    this.mIndustries = value;
    return this;
  }

  public FlexibleTargeting setFieldIndustries(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mIndustries = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldInterestedIn() {
    return mInterestedIn;
  }

  public FlexibleTargeting setFieldInterestedIn(List<Long> value) {
    this.mInterestedIn = value;
    return this;
  }

  public List<IDName> getFieldInterests() {
    return mInterests;
  }

  public FlexibleTargeting setFieldInterests(List<IDName> value) {
    this.mInterests = value;
    return this;
  }

  public FlexibleTargeting setFieldInterests(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mInterests = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldLifeEvents() {
    return mLifeEvents;
  }

  public FlexibleTargeting setFieldLifeEvents(List<IDName> value) {
    this.mLifeEvents = value;
    return this;
  }

  public FlexibleTargeting setFieldLifeEvents(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mLifeEvents = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldMoms() {
    return mMoms;
  }

  public FlexibleTargeting setFieldMoms(List<IDName> value) {
    this.mMoms = value;
    return this;
  }

  public FlexibleTargeting setFieldMoms(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mMoms = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldNetWorth() {
    return mNetWorth;
  }

  public FlexibleTargeting setFieldNetWorth(List<IDName> value) {
    this.mNetWorth = value;
    return this;
  }

  public FlexibleTargeting setFieldNetWorth(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mNetWorth = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldOfficeType() {
    return mOfficeType;
  }

  public FlexibleTargeting setFieldOfficeType(List<IDName> value) {
    this.mOfficeType = value;
    return this;
  }

  public FlexibleTargeting setFieldOfficeType(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mOfficeType = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldPolitics() {
    return mPolitics;
  }

  public FlexibleTargeting setFieldPolitics(List<IDName> value) {
    this.mPolitics = value;
    return this;
  }

  public FlexibleTargeting setFieldPolitics(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mPolitics = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<Long> getFieldRelationshipStatuses() {
    return mRelationshipStatuses;
  }

  public FlexibleTargeting setFieldRelationshipStatuses(List<Long> value) {
    this.mRelationshipStatuses = value;
    return this;
  }

  public List<IDName> getFieldUserAdclusters() {
    return mUserAdclusters;
  }

  public FlexibleTargeting setFieldUserAdclusters(List<IDName> value) {
    this.mUserAdclusters = value;
    return this;
  }

  public FlexibleTargeting setFieldUserAdclusters(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mUserAdclusters = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldWorkEmployers() {
    return mWorkEmployers;
  }

  public FlexibleTargeting setFieldWorkEmployers(List<IDName> value) {
    this.mWorkEmployers = value;
    return this;
  }

  public FlexibleTargeting setFieldWorkEmployers(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mWorkEmployers = IDName.getGson().fromJson(value, type);
    return this;
  }
  public List<IDName> getFieldWorkPositions() {
    return mWorkPositions;
  }

  public FlexibleTargeting setFieldWorkPositions(List<IDName> value) {
    this.mWorkPositions = value;
    return this;
  }

  public FlexibleTargeting setFieldWorkPositions(String value) {
    Type type = new TypeToken<List<IDName>>(){}.getType();
    this.mWorkPositions = IDName.getGson().fromJson(value, type);
    return this;
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

  public FlexibleTargeting copyFrom(FlexibleTargeting instance) {
    this.mBehaviors = instance.mBehaviors;
    this.mCollegeYears = instance.mCollegeYears;
    this.mConnections = instance.mConnections;
    this.mCustomAudiences = instance.mCustomAudiences;
    this.mEducationMajors = instance.mEducationMajors;
    this.mEducationSchools = instance.mEducationSchools;
    this.mEducationStatuses = instance.mEducationStatuses;
    this.mEthnicAffinity = instance.mEthnicAffinity;
    this.mFamilyStatuses = instance.mFamilyStatuses;
    this.mFriendsOfConnections = instance.mFriendsOfConnections;
    this.mGeneration = instance.mGeneration;
    this.mHomeOwnership = instance.mHomeOwnership;
    this.mHomeType = instance.mHomeType;
    this.mHomeValue = instance.mHomeValue;
    this.mHouseholdComposition = instance.mHouseholdComposition;
    this.mIncome = instance.mIncome;
    this.mIndustries = instance.mIndustries;
    this.mInterestedIn = instance.mInterestedIn;
    this.mInterests = instance.mInterests;
    this.mLifeEvents = instance.mLifeEvents;
    this.mMoms = instance.mMoms;
    this.mNetWorth = instance.mNetWorth;
    this.mOfficeType = instance.mOfficeType;
    this.mPolitics = instance.mPolitics;
    this.mRelationshipStatuses = instance.mRelationshipStatuses;
    this.mUserAdclusters = instance.mUserAdclusters;
    this.mWorkEmployers = instance.mWorkEmployers;
    this.mWorkPositions = instance.mWorkPositions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FlexibleTargeting> getParser() {
    return new APIRequest.ResponseParser<FlexibleTargeting>() {
      public APINodeList<FlexibleTargeting> parseResponse(String response, APIContext context, APIRequest<FlexibleTargeting> request, String header) throws MalformedResponseException {
        return FlexibleTargeting.parseResponse(response, context, request, header);
      }
    };
  }
}
