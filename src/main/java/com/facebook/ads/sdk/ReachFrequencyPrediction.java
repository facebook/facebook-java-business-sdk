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
public class ReachFrequencyPrediction extends APINode {
  @SerializedName("account_id")
  private Long mAccountId = null;
  @SerializedName("campaign_group_id")
  private Long mCampaignGroupId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_time_start")
  private String mCampaignTimeStart = null;
  @SerializedName("campaign_time_stop")
  private String mCampaignTimeStop = null;
  @SerializedName("curve_budget_reach")
  private String mCurveBudgetReach = null;
  @SerializedName("daily_impression_curve")
  private List<Double> mDailyImpressionCurve = null;
  @SerializedName("destination_id")
  private String mDestinationId = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("external_budget")
  private Long mExternalBudget = null;
  @SerializedName("external_impression")
  private Long mExternalImpression = null;
  @SerializedName("external_maximum_budget")
  private Long mExternalMaximumBudget = null;
  @SerializedName("external_maximum_impression")
  private String mExternalMaximumImpression = null;
  @SerializedName("external_maximum_reach")
  private Long mExternalMaximumReach = null;
  @SerializedName("external_minimum_budget")
  private Long mExternalMinimumBudget = null;
  @SerializedName("external_minimum_impression")
  private Long mExternalMinimumImpression = null;
  @SerializedName("external_minimum_reach")
  private Long mExternalMinimumReach = null;
  @SerializedName("external_reach")
  private Long mExternalReach = null;
  @SerializedName("frequency_cap")
  private Long mFrequencyCap = null;
  @SerializedName("grp_dmas_audience_size")
  private Double mGrpDmasAudienceSize = null;
  @SerializedName("holdout_percentage")
  private Long mHoldoutPercentage = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instagram_destination_id")
  private String mInstagramDestinationId = null;
  @SerializedName("interval_frequency_cap")
  private Long mIntervalFrequencyCap = null;
  @SerializedName("interval_frequency_cap_reset_period")
  private Long mIntervalFrequencyCapResetPeriod = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("pause_periods")
  private String mPausePeriods = null;
  @SerializedName("placement_breakdown")
  private Object mPlacementBreakdown = null;
  @SerializedName("prediction_mode")
  private Long mPredictionMode = null;
  @SerializedName("prediction_progress")
  private Long mPredictionProgress = null;
  @SerializedName("reservation_status")
  private Long mReservationStatus = null;
  @SerializedName("status")
  private Long mStatus = null;
  @SerializedName("story_event_type")
  private Long mStoryEventType = null;
  @SerializedName("target_audience_size")
  private Long mTargetAudienceSize = null;
  @SerializedName("target_spec")
  private Targeting mTargetSpec = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  protected static Gson gson = null;

  ReachFrequencyPrediction() {
  }

  public ReachFrequencyPrediction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyPrediction(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public ReachFrequencyPrediction fetch() throws APIException{
    ReachFrequencyPrediction newInstance = fetchById(this.getPrefixedId().toString(), this.context);
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

  public static APINodeList<ReachFrequencyPrediction> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyPrediction>)(
      new APIRequest<ReachFrequencyPrediction>(context, "", "/", "GET", ReachFrequencyPrediction.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reachFrequencyPrediction.context = context;
    reachFrequencyPrediction.rawValue = json;
    return reachFrequencyPrediction;
  }

  public static APINodeList<ReachFrequencyPrediction> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReachFrequencyPrediction> reachFrequencyPredictions = new APINodeList<ReachFrequencyPrediction>(request, json);
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
          reachFrequencyPredictions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reachFrequencyPredictions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            reachFrequencyPredictions.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  reachFrequencyPredictions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyPredictions.add(loadJSON(obj.toString(), context));
            }
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
              reachFrequencyPredictions.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyPredictions;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyPredictions.clear();
          reachFrequencyPredictions.add(loadJSON(json, context));
          return reachFrequencyPredictions;
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


  public Long getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignTimeStart() {
    return mCampaignTimeStart;
  }

  public String getFieldCampaignTimeStop() {
    return mCampaignTimeStop;
  }

  public String getFieldCurveBudgetReach() {
    return mCurveBudgetReach;
  }

  public List<Double> getFieldDailyImpressionCurve() {
    return mDailyImpressionCurve;
  }

  public String getFieldDestinationId() {
    return mDestinationId;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public Long getFieldExternalBudget() {
    return mExternalBudget;
  }

  public Long getFieldExternalImpression() {
    return mExternalImpression;
  }

  public Long getFieldExternalMaximumBudget() {
    return mExternalMaximumBudget;
  }

  public String getFieldExternalMaximumImpression() {
    return mExternalMaximumImpression;
  }

  public Long getFieldExternalMaximumReach() {
    return mExternalMaximumReach;
  }

  public Long getFieldExternalMinimumBudget() {
    return mExternalMinimumBudget;
  }

  public Long getFieldExternalMinimumImpression() {
    return mExternalMinimumImpression;
  }

  public Long getFieldExternalMinimumReach() {
    return mExternalMinimumReach;
  }

  public Long getFieldExternalReach() {
    return mExternalReach;
  }

  public Long getFieldFrequencyCap() {
    return mFrequencyCap;
  }

  public Double getFieldGrpDmasAudienceSize() {
    return mGrpDmasAudienceSize;
  }

  public Long getFieldHoldoutPercentage() {
    return mHoldoutPercentage;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstagramDestinationId() {
    return mInstagramDestinationId;
  }

  public Long getFieldIntervalFrequencyCap() {
    return mIntervalFrequencyCap;
  }

  public Long getFieldIntervalFrequencyCapResetPeriod() {
    return mIntervalFrequencyCapResetPeriod;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPausePeriods() {
    return mPausePeriods;
  }

  public Object getFieldPlacementBreakdown() {
    return mPlacementBreakdown;
  }

  public Long getFieldPredictionMode() {
    return mPredictionMode;
  }

  public Long getFieldPredictionProgress() {
    return mPredictionProgress;
  }

  public Long getFieldReservationStatus() {
    return mReservationStatus;
  }

  public Long getFieldStatus() {
    return mStatus;
  }

  public Long getFieldStoryEventType() {
    return mStoryEventType;
  }

  public Long getFieldTargetAudienceSize() {
    return mTargetAudienceSize;
  }

  public Targeting getFieldTargetSpec() {
    return mTargetSpec;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
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
      "account_id",
      "campaign_group_id",
      "campaign_id",
      "campaign_time_start",
      "campaign_time_stop",
      "curve_budget_reach",
      "daily_impression_curve",
      "destination_id",
      "expiration_time",
      "external_budget",
      "external_impression",
      "external_maximum_budget",
      "external_maximum_impression",
      "external_maximum_reach",
      "external_minimum_budget",
      "external_minimum_impression",
      "external_minimum_reach",
      "external_reach",
      "frequency_cap",
      "grp_dmas_audience_size",
      "holdout_percentage",
      "id",
      "instagram_destination_id",
      "interval_frequency_cap",
      "interval_frequency_cap_reset_period",
      "name",
      "pause_periods",
      "placement_breakdown",
      "prediction_mode",
      "prediction_progress",
      "reservation_status",
      "status",
      "story_event_type",
      "target_audience_size",
      "target_spec",
      "time_created",
      "time_updated",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGet requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
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
    public APIRequestGet requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGet requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGet requestDailyImpressionCurveField () {
      return this.requestDailyImpressionCurveField(true);
    }
    public APIRequestGet requestDailyImpressionCurveField (boolean value) {
      this.requestField("daily_impression_curve", value);
      return this;
    }
    public APIRequestGet requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGet requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
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
    public APIRequestGet requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGet requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGet requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGet requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGet requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGet requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGet requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGet requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGet requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGet requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGet requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGet requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGet requestGrpDmasAudienceSizeField () {
      return this.requestGrpDmasAudienceSizeField(true);
    }
    public APIRequestGet requestGrpDmasAudienceSizeField (boolean value) {
      this.requestField("grp_dmas_audience_size", value);
      return this;
    }
    public APIRequestGet requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGet requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInstagramDestinationIdField () {
      return this.requestInstagramDestinationIdField(true);
    }
    public APIRequestGet requestInstagramDestinationIdField (boolean value) {
      this.requestField("instagram_destination_id", value);
      return this;
    }
    public APIRequestGet requestIntervalFrequencyCapField () {
      return this.requestIntervalFrequencyCapField(true);
    }
    public APIRequestGet requestIntervalFrequencyCapField (boolean value) {
      this.requestField("interval_frequency_cap", value);
      return this;
    }
    public APIRequestGet requestIntervalFrequencyCapResetPeriodField () {
      return this.requestIntervalFrequencyCapResetPeriodField(true);
    }
    public APIRequestGet requestIntervalFrequencyCapResetPeriodField (boolean value) {
      this.requestField("interval_frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPausePeriodsField () {
      return this.requestPausePeriodsField(true);
    }
    public APIRequestGet requestPausePeriodsField (boolean value) {
      this.requestField("pause_periods", value);
      return this;
    }
    public APIRequestGet requestPlacementBreakdownField () {
      return this.requestPlacementBreakdownField(true);
    }
    public APIRequestGet requestPlacementBreakdownField (boolean value) {
      this.requestField("placement_breakdown", value);
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
    public APIRequestGet requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGet requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGet requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGet requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGet requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGet requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGet requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("COMPLETED")
      VALUE_COMPLETED("COMPLETED"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
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

  public ReachFrequencyPrediction copyFrom(ReachFrequencyPrediction instance) {
    this.mAccountId = instance.mAccountId;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignTimeStart = instance.mCampaignTimeStart;
    this.mCampaignTimeStop = instance.mCampaignTimeStop;
    this.mCurveBudgetReach = instance.mCurveBudgetReach;
    this.mDailyImpressionCurve = instance.mDailyImpressionCurve;
    this.mDestinationId = instance.mDestinationId;
    this.mExpirationTime = instance.mExpirationTime;
    this.mExternalBudget = instance.mExternalBudget;
    this.mExternalImpression = instance.mExternalImpression;
    this.mExternalMaximumBudget = instance.mExternalMaximumBudget;
    this.mExternalMaximumImpression = instance.mExternalMaximumImpression;
    this.mExternalMaximumReach = instance.mExternalMaximumReach;
    this.mExternalMinimumBudget = instance.mExternalMinimumBudget;
    this.mExternalMinimumImpression = instance.mExternalMinimumImpression;
    this.mExternalMinimumReach = instance.mExternalMinimumReach;
    this.mExternalReach = instance.mExternalReach;
    this.mFrequencyCap = instance.mFrequencyCap;
    this.mGrpDmasAudienceSize = instance.mGrpDmasAudienceSize;
    this.mHoldoutPercentage = instance.mHoldoutPercentage;
    this.mId = instance.mId;
    this.mInstagramDestinationId = instance.mInstagramDestinationId;
    this.mIntervalFrequencyCap = instance.mIntervalFrequencyCap;
    this.mIntervalFrequencyCapResetPeriod = instance.mIntervalFrequencyCapResetPeriod;
    this.mName = instance.mName;
    this.mPausePeriods = instance.mPausePeriods;
    this.mPlacementBreakdown = instance.mPlacementBreakdown;
    this.mPredictionMode = instance.mPredictionMode;
    this.mPredictionProgress = instance.mPredictionProgress;
    this.mReservationStatus = instance.mReservationStatus;
    this.mStatus = instance.mStatus;
    this.mStoryEventType = instance.mStoryEventType;
    this.mTargetAudienceSize = instance.mTargetAudienceSize;
    this.mTargetSpec = instance.mTargetSpec;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyPrediction> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyPrediction>() {
      public APINodeList<ReachFrequencyPrediction> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyPrediction> request) throws MalformedResponseException {
        return ReachFrequencyPrediction.parseResponse(response, context, request);
      }
    };
  }
}
