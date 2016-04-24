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
  @SerializedName("rf_prediction_id")
  private String mRfPredictionId = null;
  @SerializedName("rtb_flag")
  private Boolean mRtbFlag = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("use_new_app_click")
  private Boolean mUseNewAppClick = null;
  protected static Gson gson = null;

  AdSet() {
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
        .setParam("ids", String.join(",", ids))
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

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public List<DayPart> getFieldAdsetSchedule() {
    return mAdsetSchedule;
  }

  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public EnumBillingEvent getFieldBillingEvent() {
    return mBillingEvent;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
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

  public String getFieldDailyBudget() {
    return mDailyBudget;
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

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAutobid() {
    return mIsAutobid;
  }

  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
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

  public EnumOptimizationGoal getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public List<String> getFieldPacingType() {
    return mPacingType;
  }

  public AdPromotedObject getFieldPromotedObject() {
    return mPromotedObject;
  }

  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
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

  public EnumStatus getFieldStatus() {
    return mStatus;
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



  public static class APIRequestGetActivities extends APIRequest<AdActivity> {

    APINodeList<AdActivity> lastResponse = null;
    @Override
    public APINodeList<AdActivity> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "after",
      "business_id",
      "category",
      "limit",
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


    public APIRequestGetActivities setAfter (String after) {
      this.setParam("after", after);
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
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "adlabels",
      "applink_treatment",
      "body",
      "call_to_action_type",
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
      "run_status",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
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
      "id",
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

    public APIRequestDeleteAdLabels setId (String id) {
      this.setParam("id", id);
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

  public static class APIRequestCreateAdLabel extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
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

    public APIRequestCreateAdLabel setId (String id) {
      this.setParam("id", id);
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

    public APIRequestGetAds setTimeRange (Map<String, String> timeRange) {
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
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAsyncAdRequests requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
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

    public APIRequestGetInsights setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsights setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsights setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
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

    public APIRequestGetInsightsAsync setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetInsightsAsync setTimeRanges (List<Map<String, String>> timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestGetInsightsAsync setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
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
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "rf_prediction_id",
      "rtb_flag",
      "start_time",
      "status",
      "targeting",
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

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "bid_amount",
      "billing_event",
      "creative_sequence",
      "daily_budget",
      "daily_imps",
      "end_time",
      "execution_options",
      "id",
      "is_autobid",
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

    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
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

      private EnumDatePreset(String value) {
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
      @SerializedName("SYNCHRONOUS_AD_REVIEW")
      VALUE_SYNCHRONOUS_AD_REVIEW("SYNCHRONOUS_AD_REVIEW"),
      @SerializedName("INCLUDE_RECOMMENDATIONS")
      VALUE_INCLUDE_RECOMMENDATIONS("INCLUDE_RECOMMENDATIONS"),
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
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mLifetimeFrequencyCap = instance.mLifetimeFrequencyCap;
    this.mLifetimeImps = instance.mLifetimeImps;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mPacingType = instance.mPacingType;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRecommendations = instance.mRecommendations;
    this.mRfPredictionId = instance.mRfPredictionId;
    this.mRtbFlag = instance.mRtbFlag;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mTargeting = instance.mTargeting;
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