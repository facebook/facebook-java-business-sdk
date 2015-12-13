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


public class ReachFrequencyPrediction extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("frequency_cap")
  private Long mFrequencyCap = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("external_reach")
  private Long mExternalReach = null;
  @SerializedName("external_budget")
  private String mExternalBudget = null;
  @SerializedName("external_impression")
  private Long mExternalImpression = null;
  @SerializedName("external_maximum_reach")
  private Long mExternalMaximumReach = null;
  @SerializedName("external_maximum_impression")
  private Long mExternalMaximumImpression = null;
  @SerializedName("external_maximum_budget")
  private String mExternalMaximumBudget = null;
  @SerializedName("target_spec")
  private String mTargetSpec = null;
  @SerializedName("target_audience_size")
  private Long mTargetAudienceSize = null;
  @SerializedName("prediction_mode")
  private Long mPredictionMode = null;
  @SerializedName("prediction_progress")
  private Long mPredictionProgress = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  @SerializedName("status")
  private Long mStatus = null;
  @SerializedName("campaign_time_start")
  private String mCampaignTimeStart = null;
  @SerializedName("campaign_time_stop")
  private String mCampaignTimeStop = null;
  @SerializedName("external_minimum_budget")
  private String mExternalMinimumBudget = null;
  @SerializedName("external_minimum_reach")
  private Long mExternalMinimumReach = null;
  @SerializedName("external_minimum_impression")
  private Long mExternalMinimumImpression = null;
  @SerializedName("reservation_status")
  private Long mReservationStatus = null;
  @SerializedName("story_event_type")
  private Long mStoryEventType = null;
  @SerializedName("curve_budget_reach")
  private String mCurveBudgetReach = null;
  @SerializedName("holdout_percentage")
  private Long mHoldoutPercentage = null;
  @SerializedName("campaign_group_id")
  private Long mCampaignGroupId = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  ReachFrequencyPrediction() {
  }

  public ReachFrequencyPrediction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyPrediction(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ReachFrequencyPrediction fetch() throws APIException{
    ReachFrequencyPrediction newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyPrediction fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ReachFrequencyPrediction fetchById(String id, APIContext context) throws APIException {
    ReachFrequencyPrediction reachFrequencyPrediction =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return reachFrequencyPrediction;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ReachFrequencyPrediction loadJSON(String json, APIContext context) {
    ReachFrequencyPrediction reachFrequencyPrediction = getGson().fromJson(json, ReachFrequencyPrediction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyPrediction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reachFrequencyPrediction.mContext = context;
    reachFrequencyPrediction.rawValue = json;
    return reachFrequencyPrediction;
  }

  public static APINodeList<ReachFrequencyPrediction> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ReachFrequencyPrediction> reachFrequencyPredictions = new APINodeList<ReachFrequencyPrediction>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          reachFrequencyPredictions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reachFrequencyPredictions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            reachFrequencyPredictions.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyPredictions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            reachFrequencyPredictions.add(loadJSON(obj.toString(), context));
          }
          return reachFrequencyPredictions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyPredictions.add(loadJSON(entry.getValue().toString(), context));
          }
          return reachFrequencyPredictions;
        } else {
          // Fifth, check if it's pure JsonObject
          reachFrequencyPredictions.add(loadJSON(json, context));
          return reachFrequencyPredictions;
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


  public String getFieldId() {
    return mId;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldFrequencyCap() {
    return mFrequencyCap;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public Long getFieldExternalReach() {
    return mExternalReach;
  }

  public String getFieldExternalBudget() {
    return mExternalBudget;
  }

  public Long getFieldExternalImpression() {
    return mExternalImpression;
  }

  public Long getFieldExternalMaximumReach() {
    return mExternalMaximumReach;
  }

  public Long getFieldExternalMaximumImpression() {
    return mExternalMaximumImpression;
  }

  public String getFieldExternalMaximumBudget() {
    return mExternalMaximumBudget;
  }

  public String getFieldTargetSpec() {
    return mTargetSpec;
  }

  public Long getFieldTargetAudienceSize() {
    return mTargetAudienceSize;
  }

  public Long getFieldPredictionMode() {
    return mPredictionMode;
  }

  public Long getFieldPredictionProgress() {
    return mPredictionProgress;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }

  public Long getFieldStatus() {
    return mStatus;
  }

  public String getFieldCampaignTimeStart() {
    return mCampaignTimeStart;
  }

  public String getFieldCampaignTimeStop() {
    return mCampaignTimeStop;
  }

  public String getFieldExternalMinimumBudget() {
    return mExternalMinimumBudget;
  }

  public Long getFieldExternalMinimumReach() {
    return mExternalMinimumReach;
  }

  public Long getFieldExternalMinimumImpression() {
    return mExternalMinimumImpression;
  }

  public Long getFieldReservationStatus() {
    return mReservationStatus;
  }

  public Long getFieldStoryEventType() {
    return mStoryEventType;
  }

  public String getFieldCurveBudgetReach() {
    return mCurveBudgetReach;
  }

  public Long getFieldHoldoutPercentage() {
    return mHoldoutPercentage;
  }

  public Long getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyPrediction> {

    ReachFrequencyPrediction lastResponse = null;
    @Override
    public ReachFrequencyPrediction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public ReachFrequencyPrediction parseResponse(String response) throws APIException {
      return ReachFrequencyPrediction.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyPrediction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyPrediction execute(Map<String, Object> extraParams) throws APIException {
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
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGet requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGet requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGet requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGet requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGet requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGet requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGet requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGet requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGet requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGet requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGet requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGet requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGet requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGet requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGet requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGet requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGet requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGet requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGet requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGet requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGet requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGet requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGet requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGet requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGet requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGet requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGet requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGet requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGet requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGet requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGet requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGet requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
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

  public ReachFrequencyPrediction copyFrom(ReachFrequencyPrediction instance) {
    this.mId = instance.mId;
    this.mCampaignId = instance.mCampaignId;
    this.mAccountId = instance.mAccountId;
    this.mTimeCreated = instance.mTimeCreated;
    this.mFrequencyCap = instance.mFrequencyCap;
    this.mExpirationTime = instance.mExpirationTime;
    this.mExternalReach = instance.mExternalReach;
    this.mExternalBudget = instance.mExternalBudget;
    this.mExternalImpression = instance.mExternalImpression;
    this.mExternalMaximumReach = instance.mExternalMaximumReach;
    this.mExternalMaximumImpression = instance.mExternalMaximumImpression;
    this.mExternalMaximumBudget = instance.mExternalMaximumBudget;
    this.mTargetSpec = instance.mTargetSpec;
    this.mTargetAudienceSize = instance.mTargetAudienceSize;
    this.mPredictionMode = instance.mPredictionMode;
    this.mPredictionProgress = instance.mPredictionProgress;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.mStatus = instance.mStatus;
    this.mCampaignTimeStart = instance.mCampaignTimeStart;
    this.mCampaignTimeStop = instance.mCampaignTimeStop;
    this.mExternalMinimumBudget = instance.mExternalMinimumBudget;
    this.mExternalMinimumReach = instance.mExternalMinimumReach;
    this.mExternalMinimumImpression = instance.mExternalMinimumImpression;
    this.mReservationStatus = instance.mReservationStatus;
    this.mStoryEventType = instance.mStoryEventType;
    this.mCurveBudgetReach = instance.mCurveBudgetReach;
    this.mHoldoutPercentage = instance.mHoldoutPercentage;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mName = instance.mName;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}