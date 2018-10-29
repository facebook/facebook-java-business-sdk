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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public FlexibleTargeting() {
  }

  public FlexibleTargeting(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FlexibleTargeting(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FlexibleTargeting fetch() throws APIException{
    FlexibleTargeting newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FlexibleTargeting fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FlexibleTargeting> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FlexibleTargeting fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FlexibleTargeting> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FlexibleTargeting> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FlexibleTargeting>)(
      new APIRequest<FlexibleTargeting>(context, "", "/", "GET", FlexibleTargeting.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FlexibleTargeting>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FlexibleTargeting.getParser())
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
  public static FlexibleTargeting loadJSON(String json, APIContext context) {
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
      };
    }
    flexibleTargeting.context = context;
    flexibleTargeting.rawValue = json;
    return flexibleTargeting;
  }

  public static APINodeList<FlexibleTargeting> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<FlexibleTargeting> flexibleTargetings = new APINodeList<FlexibleTargeting>(request, json);
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
          flexibleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              flexibleTargetings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  flexibleTargetings.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              flexibleTargetings.add(loadJSON(obj.toString(), context));
            }
          }
          return flexibleTargetings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              flexibleTargetings.add(loadJSON(entry.getValue().toString(), context));
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
              flexibleTargetings.add(loadJSON(value.toString(), context));
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
          flexibleTargetings.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<IDName> getFieldBehaviors() {
    return mBehaviors;
  }

  public List<Long> getFieldCollegeYears() {
    return mCollegeYears;
  }

  public List<IDName> getFieldConnections() {
    return mConnections;
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

  public List<IDName> getFieldEducationSchools() {
    return mEducationSchools;
  }

  public List<Long> getFieldEducationStatuses() {
    return mEducationStatuses;
  }

  public List<IDName> getFieldEthnicAffinity() {
    return mEthnicAffinity;
  }

  public List<IDName> getFieldFamilyStatuses() {
    return mFamilyStatuses;
  }

  public List<IDName> getFieldFriendsOfConnections() {
    return mFriendsOfConnections;
  }

  public List<IDName> getFieldGeneration() {
    return mGeneration;
  }

  public List<IDName> getFieldHomeOwnership() {
    return mHomeOwnership;
  }

  public List<IDName> getFieldHomeType() {
    return mHomeType;
  }

  public List<IDName> getFieldHomeValue() {
    return mHomeValue;
  }

  public List<IDName> getFieldHouseholdComposition() {
    return mHouseholdComposition;
  }

  public List<IDName> getFieldIncome() {
    return mIncome;
  }

  public List<IDName> getFieldIndustries() {
    return mIndustries;
  }

  public List<Long> getFieldInterestedIn() {
    return mInterestedIn;
  }

  public List<IDName> getFieldInterests() {
    return mInterests;
  }

  public List<IDName> getFieldLifeEvents() {
    return mLifeEvents;
  }

  public List<IDName> getFieldMoms() {
    return mMoms;
  }

  public List<IDName> getFieldNetWorth() {
    return mNetWorth;
  }

  public List<IDName> getFieldOfficeType() {
    return mOfficeType;
  }

  public List<IDName> getFieldPolitics() {
    return mPolitics;
  }

  public List<Long> getFieldRelationshipStatuses() {
    return mRelationshipStatuses;
  }

  public List<IDName> getFieldUserAdclusters() {
    return mUserAdclusters;
  }

  public List<IDName> getFieldWorkEmployers() {
    return mWorkEmployers;
  }

  public List<IDName> getFieldWorkPositions() {
    return mWorkPositions;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<FlexibleTargeting> {

    FlexibleTargeting lastResponse = null;
    @Override
    public FlexibleTargeting getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "behaviors",
      "college_years",
      "connections",
      "custom_audiences",
      "education_majors",
      "education_schools",
      "education_statuses",
      "ethnic_affinity",
      "family_statuses",
      "friends_of_connections",
      "generation",
      "home_ownership",
      "home_type",
      "home_value",
      "household_composition",
      "income",
      "industries",
      "interested_in",
      "interests",
      "life_events",
      "moms",
      "net_worth",
      "office_type",
      "politics",
      "relationship_statuses",
      "user_adclusters",
      "work_employers",
      "work_positions",
      "id",
    };

    @Override
    public FlexibleTargeting parseResponse(String response) throws APIException {
      return FlexibleTargeting.parseResponse(response, getContext(), this).head();
    }

    @Override
    public FlexibleTargeting execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FlexibleTargeting execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<FlexibleTargeting> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FlexibleTargeting> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, FlexibleTargeting>() {
           public FlexibleTargeting apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
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

    public APIRequestGet requestBehaviorsField () {
      return this.requestBehaviorsField(true);
    }
    public APIRequestGet requestBehaviorsField (boolean value) {
      this.requestField("behaviors", value);
      return this;
    }
    public APIRequestGet requestCollegeYearsField () {
      return this.requestCollegeYearsField(true);
    }
    public APIRequestGet requestCollegeYearsField (boolean value) {
      this.requestField("college_years", value);
      return this;
    }
    public APIRequestGet requestConnectionsField () {
      return this.requestConnectionsField(true);
    }
    public APIRequestGet requestConnectionsField (boolean value) {
      this.requestField("connections", value);
      return this;
    }
    public APIRequestGet requestCustomAudiencesField () {
      return this.requestCustomAudiencesField(true);
    }
    public APIRequestGet requestCustomAudiencesField (boolean value) {
      this.requestField("custom_audiences", value);
      return this;
    }
    public APIRequestGet requestEducationMajorsField () {
      return this.requestEducationMajorsField(true);
    }
    public APIRequestGet requestEducationMajorsField (boolean value) {
      this.requestField("education_majors", value);
      return this;
    }
    public APIRequestGet requestEducationSchoolsField () {
      return this.requestEducationSchoolsField(true);
    }
    public APIRequestGet requestEducationSchoolsField (boolean value) {
      this.requestField("education_schools", value);
      return this;
    }
    public APIRequestGet requestEducationStatusesField () {
      return this.requestEducationStatusesField(true);
    }
    public APIRequestGet requestEducationStatusesField (boolean value) {
      this.requestField("education_statuses", value);
      return this;
    }
    public APIRequestGet requestEthnicAffinityField () {
      return this.requestEthnicAffinityField(true);
    }
    public APIRequestGet requestEthnicAffinityField (boolean value) {
      this.requestField("ethnic_affinity", value);
      return this;
    }
    public APIRequestGet requestFamilyStatusesField () {
      return this.requestFamilyStatusesField(true);
    }
    public APIRequestGet requestFamilyStatusesField (boolean value) {
      this.requestField("family_statuses", value);
      return this;
    }
    public APIRequestGet requestFriendsOfConnectionsField () {
      return this.requestFriendsOfConnectionsField(true);
    }
    public APIRequestGet requestFriendsOfConnectionsField (boolean value) {
      this.requestField("friends_of_connections", value);
      return this;
    }
    public APIRequestGet requestGenerationField () {
      return this.requestGenerationField(true);
    }
    public APIRequestGet requestGenerationField (boolean value) {
      this.requestField("generation", value);
      return this;
    }
    public APIRequestGet requestHomeOwnershipField () {
      return this.requestHomeOwnershipField(true);
    }
    public APIRequestGet requestHomeOwnershipField (boolean value) {
      this.requestField("home_ownership", value);
      return this;
    }
    public APIRequestGet requestHomeTypeField () {
      return this.requestHomeTypeField(true);
    }
    public APIRequestGet requestHomeTypeField (boolean value) {
      this.requestField("home_type", value);
      return this;
    }
    public APIRequestGet requestHomeValueField () {
      return this.requestHomeValueField(true);
    }
    public APIRequestGet requestHomeValueField (boolean value) {
      this.requestField("home_value", value);
      return this;
    }
    public APIRequestGet requestHouseholdCompositionField () {
      return this.requestHouseholdCompositionField(true);
    }
    public APIRequestGet requestHouseholdCompositionField (boolean value) {
      this.requestField("household_composition", value);
      return this;
    }
    public APIRequestGet requestIncomeField () {
      return this.requestIncomeField(true);
    }
    public APIRequestGet requestIncomeField (boolean value) {
      this.requestField("income", value);
      return this;
    }
    public APIRequestGet requestIndustriesField () {
      return this.requestIndustriesField(true);
    }
    public APIRequestGet requestIndustriesField (boolean value) {
      this.requestField("industries", value);
      return this;
    }
    public APIRequestGet requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGet requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGet requestInterestsField () {
      return this.requestInterestsField(true);
    }
    public APIRequestGet requestInterestsField (boolean value) {
      this.requestField("interests", value);
      return this;
    }
    public APIRequestGet requestLifeEventsField () {
      return this.requestLifeEventsField(true);
    }
    public APIRequestGet requestLifeEventsField (boolean value) {
      this.requestField("life_events", value);
      return this;
    }
    public APIRequestGet requestMomsField () {
      return this.requestMomsField(true);
    }
    public APIRequestGet requestMomsField (boolean value) {
      this.requestField("moms", value);
      return this;
    }
    public APIRequestGet requestNetWorthField () {
      return this.requestNetWorthField(true);
    }
    public APIRequestGet requestNetWorthField (boolean value) {
      this.requestField("net_worth", value);
      return this;
    }
    public APIRequestGet requestOfficeTypeField () {
      return this.requestOfficeTypeField(true);
    }
    public APIRequestGet requestOfficeTypeField (boolean value) {
      this.requestField("office_type", value);
      return this;
    }
    public APIRequestGet requestPoliticsField () {
      return this.requestPoliticsField(true);
    }
    public APIRequestGet requestPoliticsField (boolean value) {
      this.requestField("politics", value);
      return this;
    }
    public APIRequestGet requestRelationshipStatusesField () {
      return this.requestRelationshipStatusesField(true);
    }
    public APIRequestGet requestRelationshipStatusesField (boolean value) {
      this.requestField("relationship_statuses", value);
      return this;
    }
    public APIRequestGet requestUserAdclustersField () {
      return this.requestUserAdclustersField(true);
    }
    public APIRequestGet requestUserAdclustersField (boolean value) {
      this.requestField("user_adclusters", value);
      return this;
    }
    public APIRequestGet requestWorkEmployersField () {
      return this.requestWorkEmployersField(true);
    }
    public APIRequestGet requestWorkEmployersField (boolean value) {
      this.requestField("work_employers", value);
      return this;
    }
    public APIRequestGet requestWorkPositionsField () {
      return this.requestWorkPositionsField(true);
    }
    public APIRequestGet requestWorkPositionsField (boolean value) {
      this.requestField("work_positions", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FlexibleTargeting> getParser() {
    return new APIRequest.ResponseParser<FlexibleTargeting>() {
      public APINodeList<FlexibleTargeting> parseResponse(String response, APIContext context, APIRequest<FlexibleTargeting> request) throws MalformedResponseException {
        return FlexibleTargeting.parseResponse(response, context, request);
      }
    };
  }
}
