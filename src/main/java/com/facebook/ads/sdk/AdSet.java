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

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdSet extends APINode {
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("adset_schedule")
  private List<DayPart> mAdsetSchedule = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("bid_amount")
  private Long mBidAmount = null;
  @SerializedName("bid_info")
  private Map<String, Long> mBidInfo = null;
  @SerializedName("billing_event")
  private EnumAdSetBillingEvent mBillingEvent = null;
  @SerializedName("campaign")
  private Campaign mCampaign = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative_sequence")
  private List<String> mCreativeSequence = null;
  @SerializedName("effective_status")
  private EnumEffectiveStatus mEffectiveStatus = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("frequency_cap")
  private Long mFrequencyCap = null;
  @SerializedName("frequency_cap_reset_period")
  private Long mFrequencyCapResetPeriod = null;
  @SerializedName("frequency_control_specs")
  private List<Object> mFrequencyControlSpecs = null;
  @SerializedName("is_autobid")
  private Boolean mIsAutobid = null;
  @SerializedName("lifetime_frequency_cap")
  private Long mLifetimeFrequencyCap = null;
  @SerializedName("lifetime_imps")
  private Long mLifetimeImps = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("optimization_goal")
  private EnumAdSetOptimizationGoal mOptimizationGoal = null;
  @SerializedName("product_ad_behavior")
  private EnumAdSetProductAdBehavior mProductAdBehavior = null;
  @SerializedName("promoted_object")
  private AdPromotedObject mPromotedObject = null;
  @SerializedName("rf_prediction_id")
  private String mRfPredictionId = null;
  @SerializedName("rtb_flag")
  private Boolean mRtbFlag = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("use_new_app_click")
  private Boolean mUseNewAppClick = null;
  @SerializedName("pacing_type")
  private List<String> mPacingType = null;
  @SerializedName("budget_remaining")
  private String mBudgetRemaining = null;
  @SerializedName("daily_budget")
  private String mDailyBudget = null;
  @SerializedName("lifetime_budget")
  private String mLifetimeBudget = null;
  protected static Gson gson = null;

  AdSet() {
  }

  public AdSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdSet(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdSet fetch() throws APIException{
    AdSet newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdSet fetchById(String id, APIContext context) throws APIException {
    AdSet adSet =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adSet;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdSet loadJSON(String json, APIContext context) {
    AdSet adSet = getGson().fromJson(json, AdSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adSet.mContext = context;
    adSet.rawValue = json;
    return adSet;
  }

  public static APINodeList<AdSet> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdSet> adSets = new APINodeList<AdSet>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adSets.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adSets.add(loadJSON(obj.toString(), context));
          }
          return adSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adSets.add(loadJSON(entry.getValue().toString(), context));
          }
          return adSets;
        } else {
          // Fifth, check if it's pure JsonObject
          adSets.add(loadJSON(json, context));
          return adSets;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAsyncAdRequests getAsyncAdRequests() {
    return new APIRequestGetAsyncAdRequests(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), mContext);
  }


  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), mContext);
  }


  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public List<DayPart> getFieldAdsetSchedule() {
    return mAdsetSchedule;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public EnumAdSetBillingEvent getFieldBillingEvent() {
    return mBillingEvent;
  }

  public Campaign getFieldCampaign() {
    return mCampaign;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<String> getFieldCreativeSequence() {
    return mCreativeSequence;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public Long getFieldFrequencyCap() {
    return mFrequencyCap;
  }

  public Long getFieldFrequencyCapResetPeriod() {
    return mFrequencyCapResetPeriod;
  }

  public List<Object> getFieldFrequencyControlSpecs() {
    return mFrequencyControlSpecs;
  }

  public Boolean getFieldIsAutobid() {
    return mIsAutobid;
  }

  public Long getFieldLifetimeFrequencyCap() {
    return mLifetimeFrequencyCap;
  }

  public Long getFieldLifetimeImps() {
    return mLifetimeImps;
  }

  public String getFieldName() {
    return mName;
  }

  public EnumAdSetOptimizationGoal getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public EnumAdSetProductAdBehavior getFieldProductAdBehavior() {
    return mProductAdBehavior;
  }

  public AdPromotedObject getFieldPromotedObject() {
    return mPromotedObject;
  }

  public String getFieldRfPredictionId() {
    return mRfPredictionId;
  }

  public Boolean getFieldRtbFlag() {
    return mRtbFlag;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public Boolean getFieldUseNewAppClick() {
    return mUseNewAppClick;
  }

  public List<String> getFieldPacingType() {
    return mPacingType;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
  }

  public String getFieldDailyBudget() {
    return mDailyBudget;
  }

  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
  }



  public static class APIRequestGet extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adlabels",
      "adset_schedule",
      "id",
      "account_id",
      "bid_amount",
      "bid_info",
      "billing_event",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "is_autobid",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "product_ad_behavior",
      "promoted_object",
      "rf_prediction_id",
      "rtb_flag",
      "start_time",
      "targeting",
      "updated_time",
      "use_new_app_click",
      "pacing_type",
      "budget_remaining",
      "daily_budget",
      "lifetime_budget",
    };

    @Override
    public AdSet parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSet execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGet requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGet requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGet requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGet requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGet requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGet requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGet requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGet requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGet requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGet requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGet requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGet requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGet requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGet requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGet requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGet requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGet requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGet requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGet requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGet requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGet requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
      return this;
    }
    public APIRequestGet requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGet requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGet requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGet requestProductAdBehaviorField () {
      return this.requestProductAdBehaviorField(true);
    }
    public APIRequestGet requestProductAdBehaviorField (boolean value) {
      this.requestField("product_ad_behavior", value);
      return this;
    }
    public APIRequestGet requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGet requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGet requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGet requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGet requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGet requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGet requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
    public APIRequestGet requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGet requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGet requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGet requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGet requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGet requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGet requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "bid_amount",
      "billing_event",
      "adset_schedule",
      "status",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "end_time",
      "execution_options",
      "frequency_control_specs",
      "is_autobid",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "product_ad_behavior",
      "promoted_object",
      "redownload",
      "rf_prediction_id",
      "start_time",
      "targeting",
      "time_start",
      "time_stop",
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }


    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestUpdate setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestUpdate setBillingEvent (EnumUpdateBillingEvent billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }

    public APIRequestUpdate setBillingEvent (String billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }

    public APIRequestUpdate setAdsetSchedule (List<Object> adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestUpdate setAdsetSchedule (String adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestUpdate setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setCreativeSequence (List<String> creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }

    public APIRequestUpdate setCreativeSequence (String creativeSequence) {
      this.setParam("creative_sequence", creativeSequence);
      return this;
    }

    public APIRequestUpdate setDailyBudget (Long dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestUpdate setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestUpdate setDailyImps (Long dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }

    public APIRequestUpdate setDailyImps (String dailyImps) {
      this.setParam("daily_imps", dailyImps);
      return this;
    }

    public APIRequestUpdate setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }


    public APIRequestUpdate setExecutionOptions (List<EnumUpdateExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestUpdate setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestUpdate setFrequencyControlSpecs (List<Object> frequencyControlSpecs) {
      this.setParam("frequency_control_specs", frequencyControlSpecs);
      return this;
    }

    public APIRequestUpdate setFrequencyControlSpecs (String frequencyControlSpecs) {
      this.setParam("frequency_control_specs", frequencyControlSpecs);
      return this;
    }

    public APIRequestUpdate setIsAutobid (Boolean isAutobid) {
      this.setParam("is_autobid", isAutobid);
      return this;
    }

    public APIRequestUpdate setIsAutobid (String isAutobid) {
      this.setParam("is_autobid", isAutobid);
      return this;
    }

    public APIRequestUpdate setLifetimeBudget (Long lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }

    public APIRequestUpdate setLifetimeBudget (String lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }

    public APIRequestUpdate setLifetimeFrequencyCap (Long lifetimeFrequencyCap) {
      this.setParam("lifetime_frequency_cap", lifetimeFrequencyCap);
      return this;
    }

    public APIRequestUpdate setLifetimeFrequencyCap (String lifetimeFrequencyCap) {
      this.setParam("lifetime_frequency_cap", lifetimeFrequencyCap);
      return this;
    }

    public APIRequestUpdate setLifetimeImps (Long lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }

    public APIRequestUpdate setLifetimeImps (String lifetimeImps) {
      this.setParam("lifetime_imps", lifetimeImps);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setOptimizationGoal (EnumUpdateOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestUpdate setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestUpdate setPacingType (List<String> pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }

    public APIRequestUpdate setPacingType (String pacingType) {
      this.setParam("pacing_type", pacingType);
      return this;
    }

    public APIRequestUpdate setProductAdBehavior (EnumUpdateProductAdBehavior productAdBehavior) {
      this.setParam("product_ad_behavior", productAdBehavior);
      return this;
    }

    public APIRequestUpdate setProductAdBehavior (String productAdBehavior) {
      this.setParam("product_ad_behavior", productAdBehavior);
      return this;
    }

    public APIRequestUpdate setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestUpdate setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestUpdate setRedownload (Boolean redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestUpdate setRedownload (String redownload) {
      this.setParam("redownload", redownload);
      return this;
    }

    public APIRequestUpdate setRfPredictionId (String rfPredictionId) {
      this.setParam("rf_prediction_id", rfPredictionId);
      return this;
    }


    public APIRequestUpdate setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }


    public APIRequestUpdate setTargeting (Targeting targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestUpdate setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestUpdate setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }


    public APIRequestUpdate setTimeStop (String timeStop) {
      this.setParam("time_stop", timeStop);
      return this;
    }


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }


    public APIRequestDelete setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "after",
      "limit",
      "since",
      "category",
      "until",
      "uid",
      "business_id",
    };

    public static final String[] FIELDS = {
      "event_type",
      "translated_event_type",
      "actor_id",
      "actor_name",
      "application_id",
      "application_name",
      "object_id",
      "object_name",
      "event_time",
      "extra_data",
      "date_time_in_timezone",
    };

    @Override
    public APINodeList<AdActivity> parseResponse(String response) throws APIException {
      return AdActivity.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdActivity> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdActivity> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setAfter (String after) {
      this.setParam("after", after);
      return this;
    }


    public APIRequestGetActivities setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetActivities setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGetActivities setSince (String since) {
      this.setParam("since", since);
      return this;
    }


    public APIRequestGetActivities setCategory (EnumCategory category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setUntil (String until) {
      this.setParam("until", until);
      return this;
    }


    public APIRequestGetActivities setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetActivities setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetActivities setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }


    public APIRequestGetActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestTranslatedEventTypeField () {
      return this.requestTranslatedEventTypeField(true);
    }
    public APIRequestGetActivities requestTranslatedEventTypeField (boolean value) {
      this.requestField("translated_event_type", value);
      return this;
    }
    public APIRequestGetActivities requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetActivities requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetActivities requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetActivities requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationIdField () {
      return this.requestApplicationIdField(true);
    }
    public APIRequestGetActivities requestApplicationIdField (boolean value) {
      this.requestField("application_id", value);
      return this;
    }
    public APIRequestGetActivities requestApplicationNameField () {
      return this.requestApplicationNameField(true);
    }
    public APIRequestGetActivities requestApplicationNameField (boolean value) {
      this.requestField("application_name", value);
      return this;
    }
    public APIRequestGetActivities requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetActivities requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetActivities requestObjectNameField () {
      return this.requestObjectNameField(true);
    }
    public APIRequestGetActivities requestObjectNameField (boolean value) {
      this.requestField("object_name", value);
      return this;
    }
    public APIRequestGetActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField () {
      return this.requestDateTimeInTimezoneField(true);
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField (boolean value) {
      this.requestField("date_time_in_timezone", value);
      return this;
    }

  }

  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "adlabels",
      "body",
      "call_to_action_type",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "product_set_id",
      "run_status",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
      "applink_treatment",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdCreatives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreatives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreatives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorImageHashField () {
      return this.requestActorImageHashField(true);
    }
    public APIRequestGetAdCreatives requestActorImageHashField (boolean value) {
      this.requestField("actor_image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorImageUrlField () {
      return this.requestActorImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestActorImageUrlField (boolean value) {
      this.requestField("actor_image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGetAdCreatives requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreatives requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreatives requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreatives requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreatives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreatives requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestRunStatusField () {
      return this.requestRunStatusField(true);
    }
    public APIRequestGetAdCreatives requestRunStatusField (boolean value) {
      this.requestField("run_status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreatives requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreatives requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }

  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_deleted",
      "effective_status",
      "date_preset",
      "time_range",
      "updated_since",
      "ad_draft_id",
    };

    public static final String[] FIELDS = {
      "id",
      "account_id",
      "adset",
      "campaign",
      "adlabels",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "last_updated_by_app_id",
      "name",
      "tracking_specs",
      "updated_time",
      "campaign_id",
      "ad_review_feedback",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds setIncludeDeleted (Boolean includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAds setIncludeDeleted (String includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setDatePreset (EnumAdDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAds setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetAds setUpdatedSince (Long updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }

    public APIRequestGetAds setUpdatedSince (String updatedSince) {
      this.setParam("updated_since", updatedSince);
      return this;
    }

    public APIRequestGetAds setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
      return this;
    }


    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAds requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAds requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAds requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAds requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAds requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAds requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAds requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAds requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAds requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAds requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAds requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAds requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAds requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAds requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAds requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAds requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAds requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }

  }

  public static class APIRequestGetAsyncAdRequests extends APIRequest<AdAsyncRequest> {

    APINodeList<AdAsyncRequest> lastResponse = null;
    @Override
    public APINodeList<AdAsyncRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "statuses",
    };

    public static final String[] FIELDS = {
      "id",
      "scope_object_id",
      "status",
      "result",
      "input",
      "async_request_set",
      "created_time",
      "updated_time",
    };

    @Override
    public APINodeList<AdAsyncRequest> parseResponse(String response) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAsyncRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAsyncRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAsyncAdRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequests", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAsyncAdRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAsyncAdRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAsyncAdRequests setStatuses (List<EnumStatuses> statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetAsyncAdRequests setStatuses (String statuses) {
      this.setParam("statuses", statuses);
      return this;
    }

    public APIRequestGetAsyncAdRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAsyncAdRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAsyncAdRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAsyncAdRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAsyncAdRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAsyncAdRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAsyncAdRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAsyncAdRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestScopeObjectIdField () {
      return this.requestScopeObjectIdField(true);
    }
    public APIRequestGetAsyncAdRequests requestScopeObjectIdField (boolean value) {
      this.requestField("scope_object_id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAsyncAdRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetAsyncAdRequests requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGetAsyncAdRequests requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGetAsyncAdRequests requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequests requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }

  }

  public abstract static class APIRequestGetInsightsBase<T extends APINode> extends APIRequest<T> {

    APINodeList<T> lastResponse = null;
    @Override
    public APINodeList<T> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "default_summary",
      "fields",
      "filtering",
      "summary",
      "sort",
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "level",
      "product_id_limit",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
    };

    public static final String[] FIELDS = {
    };

    public APIRequestGetInsightsBase(String nodeId, APIContext context, String method) {
      super(context, nodeId, "/insights", method, Arrays.asList(PARAMS));
    }

    public APIRequestGetInsightsBase setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetInsightsBase setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsBase setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsBase setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsBase setFields (List<EnumFields> fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsBase setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsBase setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsBase setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsBase setSummary (List<EnumFields> summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsBase setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsBase setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsBase setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsBase setActionAttributionWindows (List<EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsBase setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsBase setActionBreakdowns (List<EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setActionReportTime (EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsBase setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsBase setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setDatePreset (EnumAdsInsightsDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsBase setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsBase setLevel (EnumLevel level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsBase setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsBase setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsBase setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsBase setSummaryActionBreakdowns (List<EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsBase setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }


    public APIRequestGetInsightsBase setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetInsightsBase setTimeRanges (List<String> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsBase setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsBase requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsBase requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsightsBase requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetInsightsBase requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsightsBase requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetInsightsBase requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }
  
  public static class APIRequestGetInsights extends APIRequestGetInsightsBase<AdsInsights> {
    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(nodeId, context, "GET");
    }

    @Override
    public APINodeList<AdsInsights> parseResponse(String response) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }
  }

  public static class APIRequestGetInsightsAsync extends APIRequestGetInsightsBase<AdReportRun> {
    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(nodeId, context, "POST");
    }

    @Override
    public APINodeList<AdReportRun> parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdReportRun> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdReportRun> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }
  }

  public static class APIRequestGetTargetingSentenceLines extends APIRequest<TargetingSentenceLine> {

    APINodeList<TargetingSentenceLine> lastResponse = null;
    @Override
    public APINodeList<TargetingSentenceLine> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "params",
      "targetingsentencelines",
    };

    @Override
    public APINodeList<TargetingSentenceLine> parseResponse(String response) throws APIException {
      return TargetingSentenceLine.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TargetingSentenceLine> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTargetingSentenceLines requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTargetingSentenceLines requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTargetingSentenceLines requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTargetingSentenceLines requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestParamsField () {
      return this.requestParamsField(true);
    }
    public APIRequestGetTargetingSentenceLines requestParamsField (boolean value) {
      this.requestField("params", value);
      return this;
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField () {
      return this.requestTargetingsentencelinesField(true);
    }
    public APIRequestGetTargetingSentenceLines requestTargetingsentencelinesField (boolean value) {
      this.requestField("targetingsentencelines", value);
      return this;
    }

  }

  public static class APIRequestDeleteAdLabels extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdLabels setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteAdLabels setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDeleteAdLabels setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDeleteAdLabels setExecutionOptions (List<EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestDeleteAdLabels setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestDeleteAdLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateAdLabel extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateAdLabel setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdLabel setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdLabel setExecutionOptions (List<EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAdLabel setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestCreateAdLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumUpdateBillingEvent {
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumUpdateBillingEvent(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
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
  public static enum EnumUpdateExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumUpdateExecutionOptions(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateOptimizationGoal {
    @SerializedName("NONE")
    VALUE_NONE("NONE"),
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("BRAND_AWARENESS")
    VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("ENGAGED_USERS")
    VALUE_ENGAGED_USERS("ENGAGED_USERS"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("OFFSITE_CONVERSIONS")
    VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
    @SerializedName("PAGE_ENGAGEMENT")
    VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("REACH")
    VALUE_REACH("REACH"),
    @SerializedName("SOCIAL_IMPRESSIONS")
    VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumUpdateOptimizationGoal(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateProductAdBehavior {
    @SerializedName("REQUIRE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_LAST_SEEN_PRODUCTS("REQUIRE_LAST_SEEN_PRODUCTS"),
    @SerializedName("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS"),
    @SerializedName("FALL_BACK_TO_FB_RECOMMENDATIONS")
    VALUE_FALL_BACK_TO_FB_RECOMMENDATIONS("FALL_BACK_TO_FB_RECOMMENDATIONS"),
    NULL(null);

    private String value;

    private EnumUpdateProductAdBehavior(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumCategory {
    @SerializedName("ACCOUNT")
    VALUE_ACCOUNT("ACCOUNT"),
    @SerializedName("AD")
    VALUE_AD("AD"),
    @SerializedName("AD_SET")
    VALUE_AD_SET("AD_SET"),
    @SerializedName("AUDIENCE")
    VALUE_AUDIENCE("AUDIENCE"),
    @SerializedName("BID")
    VALUE_BID("BID"),
    @SerializedName("BUDGET")
    VALUE_BUDGET("BUDGET"),
    @SerializedName("CAMPAIGN")
    VALUE_CAMPAIGN("CAMPAIGN"),
    @SerializedName("DATE")
    VALUE_DATE("DATE"),
    @SerializedName("STATUS")
    VALUE_STATUS("STATUS"),
    @SerializedName("TARGETING")
    VALUE_TARGETING("TARGETING"),
    NULL(null);

    private String value;

    private EnumCategory(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdDatePreset {
    @SerializedName("today")
    VALUE_TODAY("today"),
    @SerializedName("yesterday")
    VALUE_YESTERDAY("yesterday"),
    @SerializedName("last_3_days")
    VALUE_LAST_3_DAYS("last_3_days"),
    @SerializedName("this_week")
    VALUE_THIS_WEEK("this_week"),
    @SerializedName("last_week")
    VALUE_LAST_WEEK("last_week"),
    @SerializedName("last_7_days")
    VALUE_LAST_7_DAYS("last_7_days"),
    @SerializedName("last_14_days")
    VALUE_LAST_14_DAYS("last_14_days"),
    @SerializedName("last_28_days")
    VALUE_LAST_28_DAYS("last_28_days"),
    @SerializedName("last_30_days")
    VALUE_LAST_30_DAYS("last_30_days"),
    @SerializedName("last_90_days")
    VALUE_LAST_90_DAYS("last_90_days"),
    @SerializedName("this_month")
    VALUE_THIS_MONTH("this_month"),
    @SerializedName("last_month")
    VALUE_LAST_MONTH("last_month"),
    @SerializedName("this_quarter")
    VALUE_THIS_QUARTER("this_quarter"),
    @SerializedName("last_3_months")
    VALUE_LAST_3_MONTHS("last_3_months"),
    @SerializedName("lifetime")
    VALUE_LIFETIME("lifetime"),
    NULL(null);

    private String value;

    private EnumAdDatePreset(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumStatuses {
    @SerializedName("INITIAL")
    VALUE_INITIAL("INITIAL"),
    @SerializedName("IN_PROGRESS")
    VALUE_IN_PROGRESS("IN_PROGRESS"),
    @SerializedName("SUCCESS")
    VALUE_SUCCESS("SUCCESS"),
    @SerializedName("ERROR")
    VALUE_ERROR("ERROR"),
    @SerializedName("CANCELED")
    VALUE_CANCELED("CANCELED"),
    @SerializedName("PENDING_DEPENDENCY")
    VALUE_PENDING_DEPENDENCY("PENDING_DEPENDENCY"),
    @SerializedName("CANCELED_DEPENDENCY")
    VALUE_CANCELED_DEPENDENCY("CANCELED_DEPENDENCY"),
    @SerializedName("ERROR_DEPENDENCY")
    VALUE_ERROR_DEPENDENCY("ERROR_DEPENDENCY"),
    @SerializedName("ERROR_CONFLICTS")
    VALUE_ERROR_CONFLICTS("ERROR_CONFLICTS"),
    NULL(null);

    private String value;

    private EnumStatuses(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumFields {
    @SerializedName("frequency_value")
    VALUE_FREQUENCY_VALUE("frequency_value"),
    @SerializedName("age")
    VALUE_AGE("age"),
    @SerializedName("country")
    VALUE_COUNTRY("country"),
    @SerializedName("gender")
    VALUE_GENDER("gender"),
    @SerializedName("impression_device")
    VALUE_IMPRESSION_DEVICE("impression_device"),
    @SerializedName("place_page_id")
    VALUE_PLACE_PAGE_ID("place_page_id"),
    @SerializedName("placement")
    VALUE_PLACEMENT("placement"),
    @SerializedName("product_id")
    VALUE_PRODUCT_ID("product_id"),
    @SerializedName("region")
    VALUE_REGION("region"),
    @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
    @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
    @SerializedName("account_id")
    VALUE_ACCOUNT_ID("account_id"),
    @SerializedName("account_name")
    VALUE_ACCOUNT_NAME("account_name"),
    @SerializedName("action_values")
    VALUE_ACTION_VALUES("action_values"),
    @SerializedName("actions")
    VALUE_ACTIONS("actions"),
    @SerializedName("unique_actions")
    VALUE_UNIQUE_ACTIONS("unique_actions"),
    @SerializedName("app_store_clicks")
    VALUE_APP_STORE_CLICKS("app_store_clicks"),
    @SerializedName("buying_type")
    VALUE_BUYING_TYPE("buying_type"),
    @SerializedName("call_to_action_clicks")
    VALUE_CALL_TO_ACTION_CLICKS("call_to_action_clicks"),
    @SerializedName("card_views")
    VALUE_CARD_VIEWS("card_views"),
    @SerializedName("unique_clicks")
    VALUE_UNIQUE_CLICKS("unique_clicks"),
    @SerializedName("cost_per_action_type")
    VALUE_COST_PER_ACTION_TYPE("cost_per_action_type"),
    @SerializedName("cost_per_unique_action_type")
    VALUE_COST_PER_UNIQUE_ACTION_TYPE("cost_per_unique_action_type"),
    @SerializedName("cost_per_inline_post_engagement")
    VALUE_COST_PER_INLINE_POST_ENGAGEMENT("cost_per_inline_post_engagement"),
    @SerializedName("cost_per_inline_link_click")
    VALUE_COST_PER_INLINE_LINK_CLICK("cost_per_inline_link_click"),
    @SerializedName("cost_per_total_action")
    VALUE_COST_PER_TOTAL_ACTION("cost_per_total_action"),
    @SerializedName("cost_per_10_sec_video_view")
    VALUE_COST_PER_10_SEC_VIDEO_VIEW("cost_per_10_sec_video_view"),
    @SerializedName("cost_per_unique_click")
    VALUE_COST_PER_UNIQUE_CLICK("cost_per_unique_click"),
    @SerializedName("cpm")
    VALUE_CPM("cpm"),
    @SerializedName("cpp")
    VALUE_CPP("cpp"),
    @SerializedName("ctr")
    VALUE_CTR("ctr"),
    @SerializedName("unique_ctr")
    VALUE_UNIQUE_CTR("unique_ctr"),
    @SerializedName("unique_link_clicks_ctr")
    VALUE_UNIQUE_LINK_CLICKS_CTR("unique_link_clicks_ctr"),
    @SerializedName("date_start")
    VALUE_DATE_START("date_start"),
    @SerializedName("date_stop")
    VALUE_DATE_STOP("date_stop"),
    @SerializedName("deeplink_clicks")
    VALUE_DEEPLINK_CLICKS("deeplink_clicks"),
    @SerializedName("frequency")
    VALUE_FREQUENCY("frequency"),
    @SerializedName("impressions")
    VALUE_IMPRESSIONS("impressions"),
    @SerializedName("unique_impressions")
    VALUE_UNIQUE_IMPRESSIONS("unique_impressions"),
    @SerializedName("inline_link_clicks")
    VALUE_INLINE_LINK_CLICKS("inline_link_clicks"),
    @SerializedName("inline_post_engagement")
    VALUE_INLINE_POST_ENGAGEMENT("inline_post_engagement"),
    @SerializedName("newsfeed_avg_position")
    VALUE_NEWSFEED_AVG_POSITION("newsfeed_avg_position"),
    @SerializedName("newsfeed_clicks")
    VALUE_NEWSFEED_CLICKS("newsfeed_clicks"),
    @SerializedName("newsfeed_impressions")
    VALUE_NEWSFEED_IMPRESSIONS("newsfeed_impressions"),
    @SerializedName("reach")
    VALUE_REACH("reach"),
    @SerializedName("relevance_score")
    VALUE_RELEVANCE_SCORE("relevance_score"),
    @SerializedName("social_clicks")
    VALUE_SOCIAL_CLICKS("social_clicks"),
    @SerializedName("unique_social_clicks")
    VALUE_UNIQUE_SOCIAL_CLICKS("unique_social_clicks"),
    @SerializedName("social_impressions")
    VALUE_SOCIAL_IMPRESSIONS("social_impressions"),
    @SerializedName("unique_social_impressions")
    VALUE_UNIQUE_SOCIAL_IMPRESSIONS("unique_social_impressions"),
    @SerializedName("social_reach")
    VALUE_SOCIAL_REACH("social_reach"),
    @SerializedName("social_spend")
    VALUE_SOCIAL_SPEND("social_spend"),
    @SerializedName("spend")
    VALUE_SPEND("spend"),
    @SerializedName("total_action_value")
    VALUE_TOTAL_ACTION_VALUE("total_action_value"),
    @SerializedName("total_actions")
    VALUE_TOTAL_ACTIONS("total_actions"),
    @SerializedName("total_unique_actions")
    VALUE_TOTAL_UNIQUE_ACTIONS("total_unique_actions"),
    @SerializedName("video_avg_pct_watched_actions")
    VALUE_VIDEO_AVG_PCT_WATCHED_ACTIONS("video_avg_pct_watched_actions"),
    @SerializedName("video_avg_sec_watched_actions")
    VALUE_VIDEO_AVG_SEC_WATCHED_ACTIONS("video_avg_sec_watched_actions"),
    @SerializedName("video_complete_watched_actions")
    VALUE_VIDEO_COMPLETE_WATCHED_ACTIONS("video_complete_watched_actions"),
    @SerializedName("video_p25_watched_actions")
    VALUE_VIDEO_P25_WATCHED_ACTIONS("video_p25_watched_actions"),
    @SerializedName("video_p50_watched_actions")
    VALUE_VIDEO_P50_WATCHED_ACTIONS("video_p50_watched_actions"),
    @SerializedName("video_p75_watched_actions")
    VALUE_VIDEO_P75_WATCHED_ACTIONS("video_p75_watched_actions"),
    @SerializedName("video_p95_watched_actions")
    VALUE_VIDEO_P95_WATCHED_ACTIONS("video_p95_watched_actions"),
    @SerializedName("video_p100_watched_actions")
    VALUE_VIDEO_P100_WATCHED_ACTIONS("video_p100_watched_actions"),
    @SerializedName("video_10_sec_watched_actions")
    VALUE_VIDEO_10_SEC_WATCHED_ACTIONS("video_10_sec_watched_actions"),
    @SerializedName("video_15_sec_watched_actions")
    VALUE_VIDEO_15_SEC_WATCHED_ACTIONS("video_15_sec_watched_actions"),
    @SerializedName("video_30_sec_watched_actions")
    VALUE_VIDEO_30_SEC_WATCHED_ACTIONS("video_30_sec_watched_actions"),
    @SerializedName("website_clicks")
    VALUE_WEBSITE_CLICKS("website_clicks"),
    @SerializedName("website_ctr")
    VALUE_WEBSITE_CTR("website_ctr"),
    @SerializedName("ad_id")
    VALUE_AD_ID("ad_id"),
    @SerializedName("ad_name")
    VALUE_AD_NAME("ad_name"),
    @SerializedName("adset_id")
    VALUE_ADSET_ID("adset_id"),
    @SerializedName("adset_name")
    VALUE_ADSET_NAME("adset_name"),
    @SerializedName("campaign_id")
    VALUE_CAMPAIGN_ID("campaign_id"),
    @SerializedName("campaign_name")
    VALUE_CAMPAIGN_NAME("campaign_name"),
    NULL(null);

    private String value;

    private EnumFields(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumActionAttributionWindows {
    @SerializedName("1d_view")
    VALUE_1D_VIEW("1d_view"),
    @SerializedName("7d_view")
    VALUE_7D_VIEW("7d_view"),
    @SerializedName("28d_view")
    VALUE_28D_VIEW("28d_view"),
    @SerializedName("1d_click")
    VALUE_1D_CLICK("1d_click"),
    @SerializedName("7d_click")
    VALUE_7D_CLICK("7d_click"),
    @SerializedName("28d_click")
    VALUE_28D_CLICK("28d_click"),
    @SerializedName("default")
    VALUE_DEFAULT("default"),
    NULL(null);

    private String value;

    private EnumActionAttributionWindows(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumActionBreakdowns {
    @SerializedName("action_carousel_card_id")
    VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
    @SerializedName("action_carousel_card_name")
    VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
    @SerializedName("action_destination")
    VALUE_ACTION_DESTINATION("action_destination"),
    @SerializedName("action_device")
    VALUE_ACTION_DEVICE("action_device"),
    @SerializedName("action_target_id")
    VALUE_ACTION_TARGET_ID("action_target_id"),
    @SerializedName("action_type")
    VALUE_ACTION_TYPE("action_type"),
    @SerializedName("action_video_type")
    VALUE_ACTION_VIDEO_TYPE("action_video_type"),
    NULL(null);

    private String value;

    private EnumActionBreakdowns(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumActionReportTime {
    @SerializedName("impression")
    VALUE_IMPRESSION("impression"),
    @SerializedName("conversion")
    VALUE_CONVERSION("conversion"),
    NULL(null);

    private String value;

    private EnumActionReportTime(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumBreakdowns {
    @SerializedName("age")
    VALUE_AGE("age"),
    @SerializedName("country")
    VALUE_COUNTRY("country"),
    @SerializedName("gender")
    VALUE_GENDER("gender"),
    @SerializedName("frequency_value")
    VALUE_FREQUENCY_VALUE("frequency_value"),
    @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
    @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
    VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
    @SerializedName("impression_device")
    VALUE_IMPRESSION_DEVICE("impression_device"),
    @SerializedName("place_page_id")
    VALUE_PLACE_PAGE_ID("place_page_id"),
    @SerializedName("placement")
    VALUE_PLACEMENT("placement"),
    @SerializedName("placement_merge_rhc")
    VALUE_PLACEMENT_MERGE_RHC("placement_merge_rhc"),
    @SerializedName("product_id")
    VALUE_PRODUCT_ID("product_id"),
    @SerializedName("region")
    VALUE_REGION("region"),
    NULL(null);

    private String value;

    private EnumBreakdowns(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdsInsightsDatePreset {
    @SerializedName("today")
    VALUE_TODAY("today"),
    @SerializedName("yesterday")
    VALUE_YESTERDAY("yesterday"),
    @SerializedName("last_3_days")
    VALUE_LAST_3_DAYS("last_3_days"),
    @SerializedName("this_week")
    VALUE_THIS_WEEK("this_week"),
    @SerializedName("last_week")
    VALUE_LAST_WEEK("last_week"),
    @SerializedName("last_7_days")
    VALUE_LAST_7_DAYS("last_7_days"),
    @SerializedName("last_14_days")
    VALUE_LAST_14_DAYS("last_14_days"),
    @SerializedName("last_28_days")
    VALUE_LAST_28_DAYS("last_28_days"),
    @SerializedName("last_30_days")
    VALUE_LAST_30_DAYS("last_30_days"),
    @SerializedName("last_90_days")
    VALUE_LAST_90_DAYS("last_90_days"),
    @SerializedName("this_month")
    VALUE_THIS_MONTH("this_month"),
    @SerializedName("last_month")
    VALUE_LAST_MONTH("last_month"),
    @SerializedName("this_quarter")
    VALUE_THIS_QUARTER("this_quarter"),
    @SerializedName("last_3_months")
    VALUE_LAST_3_MONTHS("last_3_months"),
    @SerializedName("lifetime")
    VALUE_LIFETIME("lifetime"),
    NULL(null);

    private String value;

    private EnumAdsInsightsDatePreset(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumLevel {
    @SerializedName("ad")
    VALUE_AD("ad"),
    @SerializedName("adset")
    VALUE_ADSET("adset"),
    @SerializedName("campaign")
    VALUE_CAMPAIGN("campaign"),
    NULL(null);

    private String value;

    private EnumLevel(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumSummaryActionBreakdowns {
    @SerializedName("action_carousel_card_id")
    VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
    @SerializedName("action_carousel_card_name")
    VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
    @SerializedName("action_destination")
    VALUE_ACTION_DESTINATION("action_destination"),
    @SerializedName("action_device")
    VALUE_ACTION_DEVICE("action_device"),
    @SerializedName("action_target_id")
    VALUE_ACTION_TARGET_ID("action_target_id"),
    @SerializedName("action_type")
    VALUE_ACTION_TYPE("action_type"),
    @SerializedName("action_video_type")
    VALUE_ACTION_VIDEO_TYPE("action_video_type"),
    NULL(null);

    private String value;

    private EnumSummaryActionBreakdowns(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumExecutionOptions(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetBillingEvent {
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumAdSetBillingEvent(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumConfiguredStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    NULL(null);

    private String value;

    private EnumConfiguredStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumEffectiveStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("PAUSED")
    VALUE_PAUSED("PAUSED"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    @SerializedName("PENDING_REVIEW")
    VALUE_PENDING_REVIEW("PENDING_REVIEW"),
    @SerializedName("DISAPPROVED")
    VALUE_DISAPPROVED("DISAPPROVED"),
    @SerializedName("PREAPPROVED")
    VALUE_PREAPPROVED("PREAPPROVED"),
    @SerializedName("PENDING_BILLING_INFO")
    VALUE_PENDING_BILLING_INFO("PENDING_BILLING_INFO"),
    @SerializedName("CAMPAIGN_PAUSED")
    VALUE_CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"),
    @SerializedName("ARCHIVED")
    VALUE_ARCHIVED("ARCHIVED"),
    @SerializedName("ADSET_PAUSED")
    VALUE_ADSET_PAUSED("ADSET_PAUSED"),
    NULL(null);

    private String value;

    private EnumEffectiveStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetOptimizationGoal {
    @SerializedName("NONE")
    VALUE_NONE("NONE"),
    @SerializedName("APP_INSTALLS")
    VALUE_APP_INSTALLS("APP_INSTALLS"),
    @SerializedName("BRAND_AWARENESS")
    VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
    @SerializedName("CLICKS")
    VALUE_CLICKS("CLICKS"),
    @SerializedName("ENGAGED_USERS")
    VALUE_ENGAGED_USERS("ENGAGED_USERS"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("IMPRESSIONS")
    VALUE_IMPRESSIONS("IMPRESSIONS"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("OFFSITE_CONVERSIONS")
    VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
    @SerializedName("PAGE_ENGAGEMENT")
    VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("REACH")
    VALUE_REACH("REACH"),
    @SerializedName("SOCIAL_IMPRESSIONS")
    VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumAdSetOptimizationGoal(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetProductAdBehavior {
    @SerializedName("REQUIRE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_LAST_SEEN_PRODUCTS("REQUIRE_LAST_SEEN_PRODUCTS"),
    @SerializedName("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS")
    VALUE_REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS("REQUIRE_AVAILABLE_LAST_SEEN_PRODUCTS"),
    @SerializedName("FALL_BACK_TO_FB_RECOMMENDATIONS")
    VALUE_FALL_BACK_TO_FB_RECOMMENDATIONS("FALL_BACK_TO_FB_RECOMMENDATIONS"),
    NULL(null);

    private String value;

    private EnumAdSetProductAdBehavior(String value) {
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

  public AdSet copyFrom(AdSet instance) {
    this.mAdlabels = instance.mAdlabels;
    this.mAdsetSchedule = instance.mAdsetSchedule;
    this.mId = instance.mId;
    this.mAccountId = instance.mAccountId;
    this.mBidAmount = instance.mBidAmount;
    this.mBidInfo = instance.mBidInfo;
    this.mBillingEvent = instance.mBillingEvent;
    this.mCampaign = instance.mCampaign;
    this.mCampaignId = instance.mCampaignId;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeSequence = instance.mCreativeSequence;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mEndTime = instance.mEndTime;
    this.mFrequencyCap = instance.mFrequencyCap;
    this.mFrequencyCapResetPeriod = instance.mFrequencyCapResetPeriod;
    this.mFrequencyControlSpecs = instance.mFrequencyControlSpecs;
    this.mIsAutobid = instance.mIsAutobid;
    this.mLifetimeFrequencyCap = instance.mLifetimeFrequencyCap;
    this.mLifetimeImps = instance.mLifetimeImps;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mProductAdBehavior = instance.mProductAdBehavior;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRfPredictionId = instance.mRfPredictionId;
    this.mRtbFlag = instance.mRtbFlag;
    this.mStartTime = instance.mStartTime;
    this.mTargeting = instance.mTargeting;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUseNewAppClick = instance.mUseNewAppClick;
    this.mPacingType = instance.mPacingType;
    this.mBudgetRemaining = instance.mBudgetRemaining;
    this.mDailyBudget = instance.mDailyBudget;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdSet> getParser() {
    return new APIRequest.ResponseParser<AdSet>() {
      public APINodeList<AdSet> parseResponse(String response, APIContext context, APIRequest<AdSet> request) {
        return AdSet.parseResponse(response, context, request);
      }
    };
  }
}