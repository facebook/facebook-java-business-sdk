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
public class AdSet extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("adset_schedule")
  private List<DayPart> mAdsetSchedule = null;
  @SerializedName("attribution_spec")
  private List<Object> mAttributionSpec = null;
  @SerializedName("bid_amount")
  private Long mBidAmount = null;
  @SerializedName("bid_info")
  private Map<String, Long> mBidInfo = null;
  @SerializedName("billing_event")
  private EnumBillingEvent mBillingEvent = null;
  @SerializedName("budget_remaining")
  private String mBudgetRemaining = null;
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
  @SerializedName("daily_budget")
  private String mDailyBudget = null;
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
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_autobid")
  private Boolean mIsAutobid = null;
  @SerializedName("is_average_price_pacing")
  private Boolean mIsAveragePricePacing = null;
  @SerializedName("lifetime_budget")
  private String mLifetimeBudget = null;
  @SerializedName("lifetime_frequency_cap")
  private Long mLifetimeFrequencyCap = null;
  @SerializedName("lifetime_imps")
  private Long mLifetimeImps = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("optimization_goal")
  private EnumOptimizationGoal mOptimizationGoal = null;
  @SerializedName("pacing_type")
  private List<String> mPacingType = null;
  @SerializedName("promoted_object")
  private AdPromotedObject mPromotedObject = null;
  @SerializedName("recommendations")
  private List<AdRecommendation> mRecommendations = null;
  @SerializedName("recurring_budget_semantics")
  private Boolean mRecurringBudgetSemantics = null;
  @SerializedName("rf_prediction_id")
  private String mRfPredictionId = null;
  @SerializedName("rtb_flag")
  private Boolean mRtbFlag = null;
  @SerializedName("source_adset")
  private AdSet mSourceAdset = null;
  @SerializedName("source_adset_id")
  private String mSourceAdsetId = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("time_based_ad_rotation_id_blocks")
  private List<List<Long>> mTimeBasedAdRotationIdBlocks = null;
  @SerializedName("time_based_ad_rotation_intervals")
  private List<Long> mTimeBasedAdRotationIntervals = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("use_new_app_click")
  private Boolean mUseNewAppClick = null;
  protected static Gson gson = null;

  public AdSet() {
  }

  public AdSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdSet(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdSet fetch() throws APIException{
    AdSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
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

  public static APINodeList<AdSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdSet>)(
      new APIRequest<AdSet>(context, "", "/", "GET", AdSet.getParser())
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
  public static AdSet loadJSON(String json, APIContext context) {
    AdSet adSet = getGson().fromJson(json, AdSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adSet.context = context;
    adSet.rawValue = json;
    return adSet;
  }

  public static APINodeList<AdSet> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdSet> adSets = new APINodeList<AdSet>(request, json);
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
          adSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adSets.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adSets.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adSets.add(loadJSON(obj.toString(), context));
            }
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
              adSets.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adSets;
          }

          // Sixth, check if it's pure JsonObject
          adSets.clear();
          adSets.add(loadJSON(json, context));
          return adSets;
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

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAsyncAdRequests getAsyncAdRequests() {
    return new APIRequestGetAsyncAdRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCopies getCopies() {
    return new APIRequestGetCopies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDeliveryEstimate getDeliveryEstimate() {
    return new APIRequestGetDeliveryEstimate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdSet setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdSet setFieldAdlabels(List<AdLabel> value) {
    this.mAdlabels = value;
    return this;
  }

  public AdSet setFieldAdlabels(String value) {
    Type type = new TypeToken<List<AdLabel>>(){}.getType();
    this.mAdlabels = AdLabel.getGson().fromJson(value, type);
    return this;
  }
  public List<DayPart> getFieldAdsetSchedule() {
    return mAdsetSchedule;
  }

  public AdSet setFieldAdsetSchedule(List<DayPart> value) {
    this.mAdsetSchedule = value;
    return this;
  }

  public AdSet setFieldAdsetSchedule(String value) {
    Type type = new TypeToken<List<DayPart>>(){}.getType();
    this.mAdsetSchedule = DayPart.getGson().fromJson(value, type);
    return this;
  }
  public List<Object> getFieldAttributionSpec() {
    return mAttributionSpec;
  }

  public AdSet setFieldAttributionSpec(List<Object> value) {
    this.mAttributionSpec = value;
    return this;
  }

  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public AdSet setFieldBidAmount(Long value) {
    this.mBidAmount = value;
    return this;
  }

  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public AdSet setFieldBidInfo(Map<String, Long> value) {
    this.mBidInfo = value;
    return this;
  }

  public EnumBillingEvent getFieldBillingEvent() {
    return mBillingEvent;
  }

  public AdSet setFieldBillingEvent(EnumBillingEvent value) {
    this.mBillingEvent = value;
    return this;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
  }

  public AdSet setFieldBudgetRemaining(String value) {
    this.mBudgetRemaining = value;
    return this;
  }

  public Campaign getFieldCampaign() {
    if (mCampaign != null) {
      mCampaign.context = getContext();
    }
    return mCampaign;
  }

  public AdSet setFieldCampaign(Campaign value) {
    this.mCampaign = value;
    return this;
  }

  public AdSet setFieldCampaign(String value) {
    Type type = new TypeToken<Campaign>(){}.getType();
    this.mCampaign = Campaign.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdSet setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public AdSet setFieldConfiguredStatus(EnumConfiguredStatus value) {
    this.mConfiguredStatus = value;
    return this;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdSet setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public List<String> getFieldCreativeSequence() {
    return mCreativeSequence;
  }

  public AdSet setFieldCreativeSequence(List<String> value) {
    this.mCreativeSequence = value;
    return this;
  }

  public String getFieldDailyBudget() {
    return mDailyBudget;
  }

  public AdSet setFieldDailyBudget(String value) {
    this.mDailyBudget = value;
    return this;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public AdSet setFieldEffectiveStatus(EnumEffectiveStatus value) {
    this.mEffectiveStatus = value;
    return this;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public AdSet setFieldEndTime(String value) {
    this.mEndTime = value;
    return this;
  }

  public Long getFieldFrequencyCap() {
    return mFrequencyCap;
  }

  public AdSet setFieldFrequencyCap(Long value) {
    this.mFrequencyCap = value;
    return this;
  }

  public Long getFieldFrequencyCapResetPeriod() {
    return mFrequencyCapResetPeriod;
  }

  public AdSet setFieldFrequencyCapResetPeriod(Long value) {
    this.mFrequencyCapResetPeriod = value;
    return this;
  }

  public List<Object> getFieldFrequencyControlSpecs() {
    return mFrequencyControlSpecs;
  }

  public AdSet setFieldFrequencyControlSpecs(List<Object> value) {
    this.mFrequencyControlSpecs = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdSet setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsAutobid() {
    return mIsAutobid;
  }

  public AdSet setFieldIsAutobid(Boolean value) {
    this.mIsAutobid = value;
    return this;
  }

  public Boolean getFieldIsAveragePricePacing() {
    return mIsAveragePricePacing;
  }

  public AdSet setFieldIsAveragePricePacing(Boolean value) {
    this.mIsAveragePricePacing = value;
    return this;
  }

  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
  }

  public AdSet setFieldLifetimeBudget(String value) {
    this.mLifetimeBudget = value;
    return this;
  }

  public Long getFieldLifetimeFrequencyCap() {
    return mLifetimeFrequencyCap;
  }

  public AdSet setFieldLifetimeFrequencyCap(Long value) {
    this.mLifetimeFrequencyCap = value;
    return this;
  }

  public Long getFieldLifetimeImps() {
    return mLifetimeImps;
  }

  public AdSet setFieldLifetimeImps(Long value) {
    this.mLifetimeImps = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdSet setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public EnumOptimizationGoal getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public AdSet setFieldOptimizationGoal(EnumOptimizationGoal value) {
    this.mOptimizationGoal = value;
    return this;
  }

  public List<String> getFieldPacingType() {
    return mPacingType;
  }

  public AdSet setFieldPacingType(List<String> value) {
    this.mPacingType = value;
    return this;
  }

  public AdPromotedObject getFieldPromotedObject() {
    return mPromotedObject;
  }

  public AdSet setFieldPromotedObject(AdPromotedObject value) {
    this.mPromotedObject = value;
    return this;
  }

  public AdSet setFieldPromotedObject(String value) {
    Type type = new TypeToken<AdPromotedObject>(){}.getType();
    this.mPromotedObject = AdPromotedObject.getGson().fromJson(value, type);
    return this;
  }
  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
  }

  public AdSet setFieldRecommendations(List<AdRecommendation> value) {
    this.mRecommendations = value;
    return this;
  }

  public AdSet setFieldRecommendations(String value) {
    Type type = new TypeToken<List<AdRecommendation>>(){}.getType();
    this.mRecommendations = AdRecommendation.getGson().fromJson(value, type);
    return this;
  }
  public Boolean getFieldRecurringBudgetSemantics() {
    return mRecurringBudgetSemantics;
  }

  public AdSet setFieldRecurringBudgetSemantics(Boolean value) {
    this.mRecurringBudgetSemantics = value;
    return this;
  }

  public String getFieldRfPredictionId() {
    return mRfPredictionId;
  }

  public AdSet setFieldRfPredictionId(String value) {
    this.mRfPredictionId = value;
    return this;
  }

  public Boolean getFieldRtbFlag() {
    return mRtbFlag;
  }

  public AdSet setFieldRtbFlag(Boolean value) {
    this.mRtbFlag = value;
    return this;
  }

  public AdSet getFieldSourceAdset() {
    if (mSourceAdset != null) {
      mSourceAdset.context = getContext();
    }
    return mSourceAdset;
  }

  public AdSet setFieldSourceAdset(AdSet value) {
    this.mSourceAdset = value;
    return this;
  }

  public AdSet setFieldSourceAdset(String value) {
    Type type = new TypeToken<AdSet>(){}.getType();
    this.mSourceAdset = AdSet.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldSourceAdsetId() {
    return mSourceAdsetId;
  }

  public AdSet setFieldSourceAdsetId(String value) {
    this.mSourceAdsetId = value;
    return this;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public AdSet setFieldStartTime(String value) {
    this.mStartTime = value;
    return this;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public AdSet setFieldStatus(EnumStatus value) {
    this.mStatus = value;
    return this;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public AdSet setFieldTargeting(Targeting value) {
    this.mTargeting = value;
    return this;
  }

  public AdSet setFieldTargeting(String value) {
    Type type = new TypeToken<Targeting>(){}.getType();
    this.mTargeting = Targeting.getGson().fromJson(value, type);
    return this;
  }
  public List<List<Long>> getFieldTimeBasedAdRotationIdBlocks() {
    return mTimeBasedAdRotationIdBlocks;
  }

  public AdSet setFieldTimeBasedAdRotationIdBlocks(List<List<Long>> value) {
    this.mTimeBasedAdRotationIdBlocks = value;
    return this;
  }

  public List<Long> getFieldTimeBasedAdRotationIntervals() {
    return mTimeBasedAdRotationIntervals;
  }

  public AdSet setFieldTimeBasedAdRotationIntervals(List<Long> value) {
    this.mTimeBasedAdRotationIntervals = value;
    return this;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public AdSet setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public Boolean getFieldUseNewAppClick() {
    return mUseNewAppClick;
  }

  public AdSet setFieldUseNewAppClick(Boolean value) {
    this.mUseNewAppClick = value;
    return this;
  }



  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_id",
      "category",
      "since",
      "uid",
      "until",
    };

    public static final String[] FIELDS = {
      "actor_id",
      "actor_name",
      "application_id",
      "application_name",
      "date_time_in_timezone",
      "event_time",
      "event_type",
      "extra_data",
      "object_id",
      "object_name",
      "translated_event_type",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetActivities setCategory (AdActivity.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestGetActivities setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetActivities setSince (String since) {
      this.setParam("since", since);
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

    public APIRequestGetActivities setUntil (String until) {
      this.setParam("until", until);
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

    @Override
    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetActivities requestDateTimeInTimezoneField () {
      return this.requestDateTimeInTimezoneField(true);
    }
    public APIRequestGetActivities requestDateTimeInTimezoneField (boolean value) {
      this.requestField("date_time_in_timezone", value);
      return this;
    }
    public APIRequestGetActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
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
    public APIRequestGetActivities requestTranslatedEventTypeField () {
      return this.requestTranslatedEventTypeField(true);
    }
    public APIRequestGetActivities requestTranslatedEventTypeField (boolean value) {
      this.requestField("translated_event_type", value);
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
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "body",
      "call_to_action_type",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "instagram_story_id",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "platform_customizations",
      "product_set_id",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreatives requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
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
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetAdCreatives requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
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
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreatives requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
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
    public APIRequestGetAdCreatives requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreatives requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreatives requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestDeleteAdLabels setExecutionOptions (List<AdLabel.EnumExecutionOptions> executionOptions) {
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

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdLabel extends APIRequest<AdLabel> {

    AdLabel lastResponse = null;
    @Override
    public AdLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdLabel parseResponse(String response) throws APIException {
      return AdLabel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdLabel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdLabel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestCreateAdLabel setExecutionOptions (List<AdLabel.EnumExecutionOptions> executionOptions) {
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

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "ad_draft_id",
      "date_preset",
      "effective_status",
      "include_deleted",
      "time_range",
      "updated_since",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_review_feedback",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "id",
      "last_updated_by_app_id",
      "name",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "tracking_specs",
      "updated_time",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
      return this;
    }

    public APIRequestGetAds setDatePreset (Ad.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetAds setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
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

    public APIRequestGetAds setIncludeDeleted (Boolean includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }
    public APIRequestGetAds setIncludeDeleted (String includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAds setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
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

    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
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
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
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
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetAds requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAds requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetAds requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetAds requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetAds requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAds requestStatusField (boolean value) {
      this.requestField("status", value);
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
      "async_request_set",
      "created_time",
      "id",
      "input",
      "result",
      "scope_object_id",
      "status",
      "type",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAsyncAdRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/asyncadrequests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAsyncAdRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAsyncAdRequests setStatuses (List<AdAsyncRequest.EnumStatuses> statuses) {
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

    @Override
    public APIRequestGetAsyncAdRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAsyncAdRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAsyncAdRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetAsyncAdRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAsyncAdRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGetAsyncAdRequests requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGetAsyncAdRequests requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetAsyncAdRequests requestResultField (boolean value) {
      this.requestField("result", value);
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
    public APIRequestGetAsyncAdRequests requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAsyncAdRequests requestTypeField (boolean value) {
      this.requestField("type", value);
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

  public static class APIRequestGetCopies extends APIRequest<AdSet> {

    APINodeList<AdSet> lastResponse = null;
    @Override
    public APINodeList<AdSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "effective_status",
      "is_completed",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_info",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "id",
      "is_autobid",
      "is_average_price_pacing",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCopies(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCopies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCopies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCopies setDatePreset (AdSet.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCopies setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCopies setEffectiveStatus (List<AdSet.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetCopies setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCopies setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetCopies setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetCopies setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetCopies setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetCopies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCopies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCopies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCopies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCopies requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCopies requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCopies requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCopies requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCopies requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetCopies requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetCopies requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetCopies requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetCopies requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetCopies requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetCopies requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetCopies requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetCopies requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetCopies requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetCopies requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCopies requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetCopies requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetCopies requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetCopies requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCopies requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCopies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCopies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCopies requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetCopies requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetCopies requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetCopies requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetCopies requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCopies requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCopies requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetCopies requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetCopies requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetCopies requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetCopies requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetCopies requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetCopies requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetCopies requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetCopies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCopies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCopies requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetCopies requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGetCopies requestIsAveragePricePacingField () {
      return this.requestIsAveragePricePacingField(true);
    }
    public APIRequestGetCopies requestIsAveragePricePacingField (boolean value) {
      this.requestField("is_average_price_pacing", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCopies requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGetCopies requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetCopies requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetCopies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCopies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCopies requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetCopies requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetCopies requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetCopies requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetCopies requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetCopies requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetCopies requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCopies requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCopies requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetCopies requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetCopies requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetCopies requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetCopies requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGetCopies requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetCopies requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetCopies requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetCopies requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetCopies requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCopies requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCopies requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCopies requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCopies requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetCopies requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetCopies requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetCopies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCopies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetCopies requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetCopies requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestGetDeliveryEstimate extends APIRequest<AdCampaignDeliveryEstimate> {

    APINodeList<AdCampaignDeliveryEstimate> lastResponse = null;
    @Override
    public APINodeList<AdCampaignDeliveryEstimate> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "optimization_goal",
      "promoted_object",
      "targeting_spec",
    };

    public static final String[] FIELDS = {
      "bid_estimate",
      "daily_outcomes_curve",
      "estimate_dau",
      "estimate_mau",
      "estimate_ready",
    };

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> parseResponse(String response) throws APIException {
      return AdCampaignDeliveryEstimate.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCampaignDeliveryEstimate> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetDeliveryEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/delivery_estimate", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDeliveryEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDeliveryEstimate setOptimizationGoal (AdCampaignDeliveryEstimate.EnumOptimizationGoal optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }
    public APIRequestGetDeliveryEstimate setOptimizationGoal (String optimizationGoal) {
      this.setParam("optimization_goal", optimizationGoal);
      return this;
    }

    public APIRequestGetDeliveryEstimate setPromotedObject (Object promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }
    public APIRequestGetDeliveryEstimate setPromotedObject (String promotedObject) {
      this.setParam("promoted_object", promotedObject);
      return this;
    }

    public APIRequestGetDeliveryEstimate setTargetingSpec (Targeting targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }
    public APIRequestGetDeliveryEstimate setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDeliveryEstimate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDeliveryEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDeliveryEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDeliveryEstimate requestBidEstimateField () {
      return this.requestBidEstimateField(true);
    }
    public APIRequestGetDeliveryEstimate requestBidEstimateField (boolean value) {
      this.requestField("bid_estimate", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField () {
      return this.requestDailyOutcomesCurveField(true);
    }
    public APIRequestGetDeliveryEstimate requestDailyOutcomesCurveField (boolean value) {
      this.requestField("daily_outcomes_curve", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField () {
      return this.requestEstimateDauField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateDauField (boolean value) {
      this.requestField("estimate_dau", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauField () {
      return this.requestEstimateMauField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateMauField (boolean value) {
      this.requestField("estimate_mau", value);
      return this;
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGetDeliveryEstimate requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
      return this;
    }
  }

  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsights setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsights setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsights setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsights setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsights setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsights setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsights setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsights setFields (List<AdsInsights.EnumSummary> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsights setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsights setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsights setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsights setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsights setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsights setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsights setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsights setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsights setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsights setSummary (List<AdsInsights.EnumSummary> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsights setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsights setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsights setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsights setTimeRanges (List<Object> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsights setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsights setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsightsAsync extends APIRequest<AdReportRun> {

    APINodeList<AdReportRun> lastResponse = null;
    @Override
    public APINodeList<AdReportRun> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action_attribution_windows",
      "action_breakdowns",
      "action_report_time",
      "breakdowns",
      "date_preset",
      "default_summary",
      "export_columns",
      "export_format",
      "export_name",
      "fields",
      "filtering",
      "level",
      "product_id_limit",
      "sort",
      "summary",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInsightsAsync(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsAsync setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsAsync setActionAttributionWindows (List<AdsInsights.EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }
    public APIRequestGetInsightsAsync setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsightsAsync setActionBreakdowns (List<AdsInsights.EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setActionReportTime (AdsInsights.EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }
    public APIRequestGetInsightsAsync setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsightsAsync setBreakdowns (List<AdsInsights.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setDatePreset (AdsInsights.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsightsAsync setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsightsAsync setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsightsAsync setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }

    public APIRequestGetInsightsAsync setExportColumns (List<String> exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestGetInsightsAsync setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestGetInsightsAsync setExportFormat (String exportFormat) {
      this.setParam("export_format", exportFormat);
      return this;
    }

    public APIRequestGetInsightsAsync setExportName (String exportName) {
      this.setParam("export_name", exportName);
      return this;
    }

    public APIRequestGetInsightsAsync setFields (List<AdsInsights.EnumSummary> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestGetInsightsAsync setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestGetInsightsAsync setFiltering (List<Object> filtering) {
      this.setParam("filtering", filtering);
      return this;
    }
    public APIRequestGetInsightsAsync setFiltering (String filtering) {
      this.setParam("filtering", filtering);
      return this;
    }

    public APIRequestGetInsightsAsync setLevel (AdsInsights.EnumLevel level) {
      this.setParam("level", level);
      return this;
    }
    public APIRequestGetInsightsAsync setLevel (String level) {
      this.setParam("level", level);
      return this;
    }

    public APIRequestGetInsightsAsync setProductIdLimit (Long productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }
    public APIRequestGetInsightsAsync setProductIdLimit (String productIdLimit) {
      this.setParam("product_id_limit", productIdLimit);
      return this;
    }

    public APIRequestGetInsightsAsync setSort (List<String> sort) {
      this.setParam("sort", sort);
      return this;
    }
    public APIRequestGetInsightsAsync setSort (String sort) {
      this.setParam("sort", sort);
      return this;
    }

    public APIRequestGetInsightsAsync setSummary (List<AdsInsights.EnumSummary> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsightsAsync setSummary (String summary) {
      this.setParam("summary", summary);
      return this;
    }

    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (List<AdsInsights.EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }
    public APIRequestGetInsightsAsync setSummaryActionBreakdowns (String summaryActionBreakdowns) {
      this.setParam("summary_action_breakdowns", summaryActionBreakdowns);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRanges (List<Object> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsAsync requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsAsync requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsAsync requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetTargetingSentenceLines(String nodeId, APIContext context) {
      super(context, nodeId, "/targetingsentencelines", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTargetingSentenceLines setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTargetingSentenceLines requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

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
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_info",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "id",
      "is_autobid",
      "is_average_price_pacing",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
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
    public APIRequestGet requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGet requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
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
    public APIRequestGet requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGet requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
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
    public APIRequestGet requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGet requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
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
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGet requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGet requestIsAveragePricePacingField () {
      return this.requestIsAveragePricePacingField(true);
    }
    public APIRequestGet requestIsAveragePricePacingField (boolean value) {
      this.requestField("is_average_price_pacing", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGet requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
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
    public APIRequestGet requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGet requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGet requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGet requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGet requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGet requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGet requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGet requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
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
    public APIRequestGet requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGet requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGet requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGet requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGet requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGet requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGet requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<AdSet> {

    AdSet lastResponse = null;
    @Override
    public AdSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "billing_event",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "end_time",
      "execution_options",
      "is_autobid",
      "is_average_price_pacing",
      "lifetime_budget",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "redownload",
      "rf_prediction_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
    };

    public static final String[] FIELDS = {
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    public APIRequestUpdate setAdsetSchedule (List<Object> adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }
    public APIRequestUpdate setAdsetSchedule (String adsetSchedule) {
      this.setParam("adset_schedule", adsetSchedule);
      return this;
    }

    public APIRequestUpdate setAttributionSpec (List<Map<String, String>> attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
      return this;
    }
    public APIRequestUpdate setAttributionSpec (String attributionSpec) {
      this.setParam("attribution_spec", attributionSpec);
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

    public APIRequestUpdate setBillingEvent (AdSet.EnumBillingEvent billingEvent) {
      this.setParam("billing_event", billingEvent);
      return this;
    }
    public APIRequestUpdate setBillingEvent (String billingEvent) {
      this.setParam("billing_event", billingEvent);
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

    public APIRequestUpdate setExecutionOptions (List<AdSet.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestUpdate setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
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

    public APIRequestUpdate setIsAveragePricePacing (Boolean isAveragePricePacing) {
      this.setParam("is_average_price_pacing", isAveragePricePacing);
      return this;
    }
    public APIRequestUpdate setIsAveragePricePacing (String isAveragePricePacing) {
      this.setParam("is_average_price_pacing", isAveragePricePacing);
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

    public APIRequestUpdate setOptimizationGoal (AdSet.EnumOptimizationGoal optimizationGoal) {
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

    public APIRequestUpdate setStatus (AdSet.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
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

    public APIRequestUpdate setTimeBasedAdRotationIdBlocks (List<List<Long>> timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }
    public APIRequestUpdate setTimeBasedAdRotationIdBlocks (String timeBasedAdRotationIdBlocks) {
      this.setParam("time_based_ad_rotation_id_blocks", timeBasedAdRotationIdBlocks);
      return this;
    }

    public APIRequestUpdate setTimeBasedAdRotationIntervals (List<Long> timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
      return this;
    }
    public APIRequestUpdate setTimeBasedAdRotationIntervals (String timeBasedAdRotationIntervals) {
      this.setParam("time_based_ad_rotation_intervals", timeBasedAdRotationIntervals);
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

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumBillingEvent {
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
      @SerializedName("MRC_VIDEO_VIEWS")
      VALUE_MRC_VIDEO_VIEWS("MRC_VIDEO_VIEWS"),
      @SerializedName("COMPLETED_VIDEO_VIEWS")
      VALUE_COMPLETED_VIDEO_VIEWS("COMPLETED_VIDEO_VIEWS"),
      NULL(null);

      private String value;

      private EnumBillingEvent(String value) {
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

  public static enum EnumOptimizationGoal {
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
      @SerializedName("APP_DOWNLOADS")
      VALUE_APP_DOWNLOADS("APP_DOWNLOADS"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      NULL(null);

      private String value;

      private EnumOptimizationGoal(String value) {
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
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
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

  public static enum EnumDatePreset {
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      NULL(null);

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumExecutionOptions {
      @SerializedName("validate_only")
      VALUE_VALIDATE_ONLY("validate_only"),
      @SerializedName("include_recommendations")
      VALUE_INCLUDE_RECOMMENDATIONS("include_recommendations"),
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

  public static enum EnumOperator {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("ANY")
      VALUE_ANY("ANY"),
      NULL(null);

      private String value;

      private EnumOperator(String value) {
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
    this.mAccountId = instance.mAccountId;
    this.mAdlabels = instance.mAdlabels;
    this.mAdsetSchedule = instance.mAdsetSchedule;
    this.mAttributionSpec = instance.mAttributionSpec;
    this.mBidAmount = instance.mBidAmount;
    this.mBidInfo = instance.mBidInfo;
    this.mBillingEvent = instance.mBillingEvent;
    this.mBudgetRemaining = instance.mBudgetRemaining;
    this.mCampaign = instance.mCampaign;
    this.mCampaignId = instance.mCampaignId;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreativeSequence = instance.mCreativeSequence;
    this.mDailyBudget = instance.mDailyBudget;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mEndTime = instance.mEndTime;
    this.mFrequencyCap = instance.mFrequencyCap;
    this.mFrequencyCapResetPeriod = instance.mFrequencyCapResetPeriod;
    this.mFrequencyControlSpecs = instance.mFrequencyControlSpecs;
    this.mId = instance.mId;
    this.mIsAutobid = instance.mIsAutobid;
    this.mIsAveragePricePacing = instance.mIsAveragePricePacing;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mLifetimeFrequencyCap = instance.mLifetimeFrequencyCap;
    this.mLifetimeImps = instance.mLifetimeImps;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mPacingType = instance.mPacingType;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRecommendations = instance.mRecommendations;
    this.mRecurringBudgetSemantics = instance.mRecurringBudgetSemantics;
    this.mRfPredictionId = instance.mRfPredictionId;
    this.mRtbFlag = instance.mRtbFlag;
    this.mSourceAdset = instance.mSourceAdset;
    this.mSourceAdsetId = instance.mSourceAdsetId;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mTargeting = instance.mTargeting;
    this.mTimeBasedAdRotationIdBlocks = instance.mTimeBasedAdRotationIdBlocks;
    this.mTimeBasedAdRotationIntervals = instance.mTimeBasedAdRotationIntervals;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUseNewAppClick = instance.mUseNewAppClick;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdSet> getParser() {
    return new APIRequest.ResponseParser<AdSet>() {
      public APINodeList<AdSet> parseResponse(String response, APIContext context, APIRequest<AdSet> request) throws MalformedResponseException {
        return AdSet.parseResponse(response, context, request);
      }
    };
  }
}
