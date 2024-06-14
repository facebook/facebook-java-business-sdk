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
public class Campaign extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("bid_strategy")
  private EnumBidStrategy mBidStrategy = null;
  @SerializedName("boosted_object_id")
  private String mBoostedObjectId = null;
  @SerializedName("brand_lift_studies")
  private List<AdStudy> mBrandLiftStudies = null;
  @SerializedName("budget_rebalance_flag")
  private Boolean mBudgetRebalanceFlag = null;
  @SerializedName("budget_remaining")
  private String mBudgetRemaining = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("campaign_group_active_time")
  private String mCampaignGroupActiveTime = null;
  @SerializedName("can_create_brand_lift_study")
  private Boolean mCanCreateBrandLiftStudy = null;
  @SerializedName("can_use_spend_cap")
  private Boolean mCanUseSpendCap = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("daily_budget")
  private String mDailyBudget = null;
  @SerializedName("effective_status")
  private EnumEffectiveStatus mEffectiveStatus = null;
  @SerializedName("has_secondary_skadnetwork_reporting")
  private Boolean mHasSecondarySkadnetworkReporting = null;
  @SerializedName(value="id", alternate={"copied_campaign_id"})
  private String mId = null;
  @SerializedName("is_budget_schedule_enabled")
  private Boolean mIsBudgetScheduleEnabled = null;
  @SerializedName("is_skadnetwork_attribution")
  private Boolean mIsSkadnetworkAttribution = null;
  @SerializedName("issues_info")
  private List<AdCampaignIssuesInfo> mIssuesInfo = null;
  @SerializedName("last_budget_toggling_time")
  private String mLastBudgetTogglingTime = null;
  @SerializedName("lifetime_budget")
  private String mLifetimeBudget = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("pacing_type")
  private List<String> mPacingType = null;
  @SerializedName("primary_attribution")
  private String mPrimaryAttribution = null;
  @SerializedName("promoted_object")
  private AdPromotedObject mPromotedObject = null;
  @SerializedName("recommendations")
  private List<AdRecommendation> mRecommendations = null;
  @SerializedName("smart_promotion_type")
  private String mSmartPromotionType = null;
  @SerializedName("source_campaign")
  private Campaign mSourceCampaign = null;
  @SerializedName("source_campaign_id")
  private String mSourceCampaignId = null;
  @SerializedName("special_ad_categories")
  private List<String> mSpecialAdCategories = null;
  @SerializedName("special_ad_category")
  private String mSpecialAdCategory = null;
  @SerializedName("special_ad_category_country")
  private List<String> mSpecialAdCategoryCountry = null;
  @SerializedName("spend_cap")
  private String mSpendCap = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("stop_time")
  private String mStopTime = null;
  @SerializedName("topline_id")
  private String mToplineId = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  Campaign() {
  }

  public Campaign(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Campaign(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Campaign fetch() throws APIException{
    Campaign newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Campaign fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Campaign> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Campaign fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Campaign> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Campaign> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Campaign>)(
      new APIRequest<Campaign>(context, "", "/", "GET", Campaign.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Campaign>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Campaign.getParser())
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
  public static Campaign loadJSON(String json, APIContext context, String header) {
    Campaign campaign = getGson().fromJson(json, Campaign.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(campaign.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    campaign.context = context;
    campaign.rawValue = json;
    campaign.header = header;
    return campaign;
  }

  public static APINodeList<Campaign> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Campaign> campaigns = new APINodeList<Campaign>(request, json, header);
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
          campaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return campaigns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                campaigns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            campaigns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              campaigns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              campaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  campaigns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              campaigns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return campaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              campaigns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return campaigns;
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
              campaigns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return campaigns;
          }

          // Sixth, check if it's pure JsonObject
          campaigns.clear();
          campaigns.add(loadJSON(json, context, header));
          return campaigns;
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

  public APIRequestGetAdStudies getAdStudies() {
    return new APIRequestGetAdStudies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdRulesGoverned getAdRulesGoverned() {
    return new APIRequestGetAdRulesGoverned(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBudgetSchedule createBudgetSchedule() {
    return new APIRequestCreateBudgetSchedule(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCopies getCopies() {
    return new APIRequestGetCopies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCopy createCopy() {
    return new APIRequestCreateCopy(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsAsync getInsightsAsync() {
    return new APIRequestGetInsightsAsync(this.getPrefixedId().toString(), context);
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

  public EnumBidStrategy getFieldBidStrategy() {
    return mBidStrategy;
  }

  public String getFieldBoostedObjectId() {
    return mBoostedObjectId;
  }

  public List<AdStudy> getFieldBrandLiftStudies() {
    return mBrandLiftStudies;
  }

  public Boolean getFieldBudgetRebalanceFlag() {
    return mBudgetRebalanceFlag;
  }

  public String getFieldBudgetRemaining() {
    return mBudgetRemaining;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
  }

  public String getFieldCampaignGroupActiveTime() {
    return mCampaignGroupActiveTime;
  }

  public Boolean getFieldCanCreateBrandLiftStudy() {
    return mCanCreateBrandLiftStudy;
  }

  public Boolean getFieldCanUseSpendCap() {
    return mCanUseSpendCap;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDailyBudget() {
    return mDailyBudget;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public Boolean getFieldHasSecondarySkadnetworkReporting() {
    return mHasSecondarySkadnetworkReporting;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsBudgetScheduleEnabled() {
    return mIsBudgetScheduleEnabled;
  }

  public Boolean getFieldIsSkadnetworkAttribution() {
    return mIsSkadnetworkAttribution;
  }

  public List<AdCampaignIssuesInfo> getFieldIssuesInfo() {
    return mIssuesInfo;
  }

  public String getFieldLastBudgetTogglingTime() {
    return mLastBudgetTogglingTime;
  }

  public String getFieldLifetimeBudget() {
    return mLifetimeBudget;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public List<String> getFieldPacingType() {
    return mPacingType;
  }

  public String getFieldPrimaryAttribution() {
    return mPrimaryAttribution;
  }

  public AdPromotedObject getFieldPromotedObject() {
    return mPromotedObject;
  }

  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
  }

  public String getFieldSmartPromotionType() {
    return mSmartPromotionType;
  }

  public Campaign getFieldSourceCampaign() {
    if (mSourceCampaign != null) {
      mSourceCampaign.context = getContext();
    }
    return mSourceCampaign;
  }

  public String getFieldSourceCampaignId() {
    return mSourceCampaignId;
  }

  public List<String> getFieldSpecialAdCategories() {
    return mSpecialAdCategories;
  }

  public String getFieldSpecialAdCategory() {
    return mSpecialAdCategory;
  }

  public List<String> getFieldSpecialAdCategoryCountry() {
    return mSpecialAdCategoryCountry;
  }

  public String getFieldSpendCap() {
    return mSpendCap;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public String getFieldStopTime() {
    return mStopTime;
  }

  public String getFieldToplineId() {
    return mToplineId;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetAdStudies extends APIRequest<AdStudy> {

    APINodeList<AdStudy> lastResponse = null;
    @Override
    public APINodeList<AdStudy> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "canceled_time",
      "client_business",
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "measurement_contact",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "sales_contact",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<AdStudy> parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudy> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdStudy>>() {
           public APINodeList<AdStudy> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdStudies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdStudies(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_studies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdStudies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdStudies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdStudies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdStudies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdStudies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdStudies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdStudies requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdStudies requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCanceledTimeField () {
      return this.requestCanceledTimeField(true);
    }
    public APIRequestGetAdStudies requestCanceledTimeField (boolean value) {
      this.requestField("canceled_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestClientBusinessField () {
      return this.requestClientBusinessField(true);
    }
    public APIRequestGetAdStudies requestClientBusinessField (boolean value) {
      this.requestField("client_business", value);
      return this;
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField () {
      return this.requestCooldownStartTimeField(true);
    }
    public APIRequestGetAdStudies requestCooldownStartTimeField (boolean value) {
      this.requestField("cooldown_start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdStudies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdStudies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAdStudies requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAdStudies requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdStudies requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdStudies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdStudies requestMeasurementContactField () {
      return this.requestMeasurementContactField(true);
    }
    public APIRequestGetAdStudies requestMeasurementContactField (boolean value) {
      this.requestField("measurement_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdStudies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdStudies requestObservationEndTimeField () {
      return this.requestObservationEndTimeField(true);
    }
    public APIRequestGetAdStudies requestObservationEndTimeField (boolean value) {
      this.requestField("observation_end_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField () {
      return this.requestResultsFirstAvailableDateField(true);
    }
    public APIRequestGetAdStudies requestResultsFirstAvailableDateField (boolean value) {
      this.requestField("results_first_available_date", value);
      return this;
    }
    public APIRequestGetAdStudies requestSalesContactField () {
      return this.requestSalesContactField(true);
    }
    public APIRequestGetAdStudies requestSalesContactField (boolean value) {
      this.requestField("sales_contact", value);
      return this;
    }
    public APIRequestGetAdStudies requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdStudies requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdStudies requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetAdStudies requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetAdStudies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetAdStudies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdStudies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateAdLabel extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Campaign>() {
           public Campaign apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAdLabel.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

    public APIRequestCreateAdLabel setExecutionOptions (List<Campaign.EnumExecutionOptions> executionOptions) {
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

  public static class APIRequestGetAdRulesGoverned extends APIRequest<AdRule> {

    APINodeList<AdRule> lastResponse = null;
    @Override
    public APINodeList<AdRule> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "pass_evaluation",
    };

    public static final String[] FIELDS = {
      "account_id",
      "created_by",
      "created_time",
      "evaluation_spec",
      "execution_spec",
      "id",
      "name",
      "schedule_spec",
      "status",
      "updated_time",
    };

    @Override
    public APINodeList<AdRule> parseResponse(String response, String header) throws APIException {
      return AdRule.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdRule> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdRule> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdRule>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdRule>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdRule>>() {
           public APINodeList<AdRule> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdRulesGoverned.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdRulesGoverned(String nodeId, APIContext context) {
      super(context, nodeId, "/adrules_governed", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdRulesGoverned setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdRulesGoverned setPassEvaluation (Boolean passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }
    public APIRequestGetAdRulesGoverned setPassEvaluation (String passEvaluation) {
      this.setParam("pass_evaluation", passEvaluation);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdRulesGoverned requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdRulesGoverned requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdRulesGoverned requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdRulesGoverned requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField () {
      return this.requestEvaluationSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestEvaluationSpecField (boolean value) {
      this.requestField("evaluation_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField () {
      return this.requestExecutionSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestExecutionSpecField (boolean value) {
      this.requestField("execution_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdRulesGoverned requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdRulesGoverned requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField () {
      return this.requestScheduleSpecField(true);
    }
    public APIRequestGetAdRulesGoverned requestScheduleSpecField (boolean value) {
      this.requestField("schedule_spec", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdRulesGoverned requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdRulesGoverned requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
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
      "date_preset",
      "effective_status",
      "time_range",
      "updated_since",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_active_time",
      "ad_review_feedback",
      "ad_schedule_end_time",
      "ad_schedule_start_time",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_domain",
      "conversion_specs",
      "created_time",
      "creative",
      "creative_asset_groups_spec",
      "demolink_hash",
      "display_sequence",
      "effective_status",
      "engagement_audience",
      "failed_delivery_checks",
      "id",
      "issues_info",
      "last_updated_by_app_id",
      "name",
      "preview_shareable_link",
      "priority",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "targeting",
      "tracking_and_conversion_with_defaults",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response, String header) throws APIException {
      return Ad.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAds.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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
    public APIRequestGetAds requestAdActiveTimeField () {
      return this.requestAdActiveTimeField(true);
    }
    public APIRequestGetAds requestAdActiveTimeField (boolean value) {
      this.requestField("ad_active_time", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdScheduleEndTimeField () {
      return this.requestAdScheduleEndTimeField(true);
    }
    public APIRequestGetAds requestAdScheduleEndTimeField (boolean value) {
      this.requestField("ad_schedule_end_time", value);
      return this;
    }
    public APIRequestGetAds requestAdScheduleStartTimeField () {
      return this.requestAdScheduleStartTimeField(true);
    }
    public APIRequestGetAds requestAdScheduleStartTimeField (boolean value) {
      this.requestField("ad_schedule_start_time", value);
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
    public APIRequestGetAds requestConversionDomainField () {
      return this.requestConversionDomainField(true);
    }
    public APIRequestGetAds requestConversionDomainField (boolean value) {
      this.requestField("conversion_domain", value);
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
    public APIRequestGetAds requestCreativeAssetGroupsSpecField () {
      return this.requestCreativeAssetGroupsSpecField(true);
    }
    public APIRequestGetAds requestCreativeAssetGroupsSpecField (boolean value) {
      this.requestField("creative_asset_groups_spec", value);
      return this;
    }
    public APIRequestGetAds requestDemolinkHashField () {
      return this.requestDemolinkHashField(true);
    }
    public APIRequestGetAds requestDemolinkHashField (boolean value) {
      this.requestField("demolink_hash", value);
      return this;
    }
    public APIRequestGetAds requestDisplaySequenceField () {
      return this.requestDisplaySequenceField(true);
    }
    public APIRequestGetAds requestDisplaySequenceField (boolean value) {
      this.requestField("display_sequence", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestEngagementAudienceField () {
      return this.requestEngagementAudienceField(true);
    }
    public APIRequestGetAds requestEngagementAudienceField (boolean value) {
      this.requestField("engagement_audience", value);
      return this;
    }
    public APIRequestGetAds requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAds requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetAds requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
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
    public APIRequestGetAds requestPreviewShareableLinkField () {
      return this.requestPreviewShareableLinkField(true);
    }
    public APIRequestGetAds requestPreviewShareableLinkField (boolean value) {
      this.requestField("preview_shareable_link", value);
      return this;
    }
    public APIRequestGetAds requestPriorityField () {
      return this.requestPriorityField(true);
    }
    public APIRequestGetAds requestPriorityField (boolean value) {
      this.requestField("priority", value);
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
    public APIRequestGetAds requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAds requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAds requestTrackingAndConversionWithDefaultsField () {
      return this.requestTrackingAndConversionWithDefaultsField(true);
    }
    public APIRequestGetAds requestTrackingAndConversionWithDefaultsField (boolean value) {
      this.requestField("tracking_and_conversion_with_defaults", value);
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

  public static class APIRequestGetAdSets extends APIRequest<AdSet> {

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
      "asset_feed_id",
      "attribution_spec",
      "bid_adjustments",
      "bid_amount",
      "bid_constraints",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_active_time",
      "campaign_attribution",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "dsa_beneficiary",
      "dsa_payor",
      "effective_status",
      "end_time",
      "existing_customer_budget_percentage",
      "frequency_control_specs",
      "full_funnel_exploration_mode",
      "id",
      "instagram_actor_id",
      "is_budget_schedule_enabled",
      "is_dynamic_creative",
      "issues_info",
      "learning_stage_info",
      "lifetime_budget",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "multi_optimization_goal_weight",
      "name",
      "optimization_goal",
      "optimization_sub_event",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "regional_regulated_categories",
      "regional_regulation_identities",
      "review_feedback",
      "rf_prediction_id",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "targeting_optimization_types",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response, String header) throws APIException {
      return AdSet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdSet>>() {
           public APINodeList<AdSet> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdSets.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets setDatePreset (AdSet.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetAdSets setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetAdSets setEffectiveStatus (List<AdSet.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAdSets setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetAdSets setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetAdSets setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetAdSets setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetAdSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdSets requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdSets requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdSets requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetAdSets requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetAdSets requestAssetFeedIdField () {
      return this.requestAssetFeedIdField(true);
    }
    public APIRequestGetAdSets requestAssetFeedIdField (boolean value) {
      this.requestField("asset_feed_id", value);
      return this;
    }
    public APIRequestGetAdSets requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdSets requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdSets requestBidAdjustmentsField () {
      return this.requestBidAdjustmentsField(true);
    }
    public APIRequestGetAdSets requestBidAdjustmentsField (boolean value) {
      this.requestField("bid_adjustments", value);
      return this;
    }
    public APIRequestGetAdSets requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAdSets requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAdSets requestBidConstraintsField () {
      return this.requestBidConstraintsField(true);
    }
    public APIRequestGetAdSets requestBidConstraintsField (boolean value) {
      this.requestField("bid_constraints", value);
      return this;
    }
    public APIRequestGetAdSets requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAdSets requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAdSets requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetAdSets requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetAdSets requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSets requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetAdSets requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSets requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdSets requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignActiveTimeField () {
      return this.requestCampaignActiveTimeField(true);
    }
    public APIRequestGetAdSets requestCampaignActiveTimeField (boolean value) {
      this.requestField("campaign_active_time", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignAttributionField () {
      return this.requestCampaignAttributionField(true);
    }
    public APIRequestGetAdSets requestCampaignAttributionField (boolean value) {
      this.requestField("campaign_attribution", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdSets requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdSets requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAdSets requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAdSets requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdSets requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdSets requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetAdSets requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSets requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyMinSpendTargetField () {
      return this.requestDailyMinSpendTargetField(true);
    }
    public APIRequestGetAdSets requestDailyMinSpendTargetField (boolean value) {
      this.requestField("daily_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSets requestDailySpendCapField () {
      return this.requestDailySpendCapField(true);
    }
    public APIRequestGetAdSets requestDailySpendCapField (boolean value) {
      this.requestField("daily_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestDestinationTypeField () {
      return this.requestDestinationTypeField(true);
    }
    public APIRequestGetAdSets requestDestinationTypeField (boolean value) {
      this.requestField("destination_type", value);
      return this;
    }
    public APIRequestGetAdSets requestDsaBeneficiaryField () {
      return this.requestDsaBeneficiaryField(true);
    }
    public APIRequestGetAdSets requestDsaBeneficiaryField (boolean value) {
      this.requestField("dsa_beneficiary", value);
      return this;
    }
    public APIRequestGetAdSets requestDsaPayorField () {
      return this.requestDsaPayorField(true);
    }
    public APIRequestGetAdSets requestDsaPayorField (boolean value) {
      this.requestField("dsa_payor", value);
      return this;
    }
    public APIRequestGetAdSets requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAdSets requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAdSets requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdSets requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdSets requestExistingCustomerBudgetPercentageField () {
      return this.requestExistingCustomerBudgetPercentageField(true);
    }
    public APIRequestGetAdSets requestExistingCustomerBudgetPercentageField (boolean value) {
      this.requestField("existing_customer_budget_percentage", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSets requestFullFunnelExplorationModeField () {
      return this.requestFullFunnelExplorationModeField(true);
    }
    public APIRequestGetAdSets requestFullFunnelExplorationModeField (boolean value) {
      this.requestField("full_funnel_exploration_mode", value);
      return this;
    }
    public APIRequestGetAdSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSets requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdSets requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdSets requestIsBudgetScheduleEnabledField () {
      return this.requestIsBudgetScheduleEnabledField(true);
    }
    public APIRequestGetAdSets requestIsBudgetScheduleEnabledField (boolean value) {
      this.requestField("is_budget_schedule_enabled", value);
      return this;
    }
    public APIRequestGetAdSets requestIsDynamicCreativeField () {
      return this.requestIsDynamicCreativeField(true);
    }
    public APIRequestGetAdSets requestIsDynamicCreativeField (boolean value) {
      this.requestField("is_dynamic_creative", value);
      return this;
    }
    public APIRequestGetAdSets requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetAdSets requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGetAdSets requestLearningStageInfoField () {
      return this.requestLearningStageInfoField(true);
    }
    public APIRequestGetAdSets requestLearningStageInfoField (boolean value) {
      this.requestField("learning_stage_info", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSets requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeMinSpendTargetField () {
      return this.requestLifetimeMinSpendTargetField(true);
    }
    public APIRequestGetAdSets requestLifetimeMinSpendTargetField (boolean value) {
      this.requestField("lifetime_min_spend_target", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeSpendCapField () {
      return this.requestLifetimeSpendCapField(true);
    }
    public APIRequestGetAdSets requestLifetimeSpendCapField (boolean value) {
      this.requestField("lifetime_spend_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestMultiOptimizationGoalWeightField () {
      return this.requestMultiOptimizationGoalWeightField(true);
    }
    public APIRequestGetAdSets requestMultiOptimizationGoalWeightField (boolean value) {
      this.requestField("multi_optimization_goal_weight", value);
      return this;
    }
    public APIRequestGetAdSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdSets requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetAdSets requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetAdSets requestOptimizationSubEventField () {
      return this.requestOptimizationSubEventField(true);
    }
    public APIRequestGetAdSets requestOptimizationSubEventField (boolean value) {
      this.requestField("optimization_sub_event", value);
      return this;
    }
    public APIRequestGetAdSets requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSets requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSets requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSets requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetAdSets requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAdSets requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetAdSets requestRegionalRegulatedCategoriesField () {
      return this.requestRegionalRegulatedCategoriesField(true);
    }
    public APIRequestGetAdSets requestRegionalRegulatedCategoriesField (boolean value) {
      this.requestField("regional_regulated_categories", value);
      return this;
    }
    public APIRequestGetAdSets requestRegionalRegulationIdentitiesField () {
      return this.requestRegionalRegulationIdentitiesField(true);
    }
    public APIRequestGetAdSets requestRegionalRegulationIdentitiesField (boolean value) {
      this.requestField("regional_regulation_identities", value);
      return this;
    }
    public APIRequestGetAdSets requestReviewFeedbackField () {
      return this.requestReviewFeedbackField(true);
    }
    public APIRequestGetAdSets requestReviewFeedbackField (boolean value) {
      this.requestField("review_feedback", value);
      return this;
    }
    public APIRequestGetAdSets requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetAdSets requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetAdSets requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSets requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSets requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdSets requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSets requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingOptimizationTypesField () {
      return this.requestTargetingOptimizationTypesField(true);
    }
    public APIRequestGetAdSets requestTargetingOptimizationTypesField (boolean value) {
      this.requestField("targeting_optimization_types", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetAdSets requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdSets requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAdSets requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetAdSets requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestCreateBudgetSchedule extends APIRequest<HighDemandPeriod> {

    HighDemandPeriod lastResponse = null;
    @Override
    public HighDemandPeriod getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "budget_value",
      "budget_value_type",
      "time_end",
      "time_start",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HighDemandPeriod parseResponse(String response, String header) throws APIException {
      return HighDemandPeriod.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HighDemandPeriod execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HighDemandPeriod execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HighDemandPeriod> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HighDemandPeriod> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HighDemandPeriod>() {
           public HighDemandPeriod apply(ResponseWrapper result) {
             try {
               return APIRequestCreateBudgetSchedule.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateBudgetSchedule(String nodeId, APIContext context) {
      super(context, nodeId, "/budget_schedules", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBudgetSchedule setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBudgetSchedule setBudgetValue (Long budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }
    public APIRequestCreateBudgetSchedule setBudgetValue (String budgetValue) {
      this.setParam("budget_value", budgetValue);
      return this;
    }

    public APIRequestCreateBudgetSchedule setBudgetValueType (HighDemandPeriod.EnumBudgetValueType budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }
    public APIRequestCreateBudgetSchedule setBudgetValueType (String budgetValueType) {
      this.setParam("budget_value_type", budgetValueType);
      return this;
    }

    public APIRequestCreateBudgetSchedule setTimeEnd (Long timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }
    public APIRequestCreateBudgetSchedule setTimeEnd (String timeEnd) {
      this.setParam("time_end", timeEnd);
      return this;
    }

    public APIRequestCreateBudgetSchedule setTimeStart (Long timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }
    public APIRequestCreateBudgetSchedule setTimeStart (String timeStart) {
      this.setParam("time_start", timeStart);
      return this;
    }

    public APIRequestCreateBudgetSchedule requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBudgetSchedule requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBudgetSchedule requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBudgetSchedule requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCopies extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
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
      "bid_strategy",
      "boosted_object_id",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "budget_remaining",
      "buying_type",
      "campaign_group_active_time",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "has_secondary_skadnetwork_reporting",
      "id",
      "is_budget_schedule_enabled",
      "is_skadnetwork_attribution",
      "issues_info",
      "last_budget_toggling_time",
      "lifetime_budget",
      "name",
      "objective",
      "pacing_type",
      "primary_attribution",
      "promoted_object",
      "recommendations",
      "smart_promotion_type",
      "source_campaign",
      "source_campaign_id",
      "special_ad_categories",
      "special_ad_category",
      "special_ad_category_country",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "topline_id",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Campaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Campaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Campaign>>() {
           public APINodeList<Campaign> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCopies.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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


    public APIRequestGetCopies setDatePreset (Campaign.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCopies setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetCopies setEffectiveStatus (List<Campaign.EnumEffectiveStatus> effectiveStatus) {
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

    public APIRequestGetCopies setTimeRange (Map<String, String> timeRange) {
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
    public APIRequestGetCopies requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetCopies requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetCopies requestBoostedObjectIdField () {
      return this.requestBoostedObjectIdField(true);
    }
    public APIRequestGetCopies requestBoostedObjectIdField (boolean value) {
      this.requestField("boosted_object_id", value);
      return this;
    }
    public APIRequestGetCopies requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGetCopies requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGetCopies requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGetCopies requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGetCopies requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCopies requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCopies requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCopies requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetCopies requestCampaignGroupActiveTimeField () {
      return this.requestCampaignGroupActiveTimeField(true);
    }
    public APIRequestGetCopies requestCampaignGroupActiveTimeField (boolean value) {
      this.requestField("campaign_group_active_time", value);
      return this;
    }
    public APIRequestGetCopies requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGetCopies requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGetCopies requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGetCopies requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
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
    public APIRequestGetCopies requestHasSecondarySkadnetworkReportingField () {
      return this.requestHasSecondarySkadnetworkReportingField(true);
    }
    public APIRequestGetCopies requestHasSecondarySkadnetworkReportingField (boolean value) {
      this.requestField("has_secondary_skadnetwork_reporting", value);
      return this;
    }
    public APIRequestGetCopies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCopies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCopies requestIsBudgetScheduleEnabledField () {
      return this.requestIsBudgetScheduleEnabledField(true);
    }
    public APIRequestGetCopies requestIsBudgetScheduleEnabledField (boolean value) {
      this.requestField("is_budget_schedule_enabled", value);
      return this;
    }
    public APIRequestGetCopies requestIsSkadnetworkAttributionField () {
      return this.requestIsSkadnetworkAttributionField(true);
    }
    public APIRequestGetCopies requestIsSkadnetworkAttributionField (boolean value) {
      this.requestField("is_skadnetwork_attribution", value);
      return this;
    }
    public APIRequestGetCopies requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGetCopies requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGetCopies requestLastBudgetTogglingTimeField () {
      return this.requestLastBudgetTogglingTimeField(true);
    }
    public APIRequestGetCopies requestLastBudgetTogglingTimeField (boolean value) {
      this.requestField("last_budget_toggling_time", value);
      return this;
    }
    public APIRequestGetCopies requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCopies requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCopies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCopies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCopies requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetCopies requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetCopies requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetCopies requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetCopies requestPrimaryAttributionField () {
      return this.requestPrimaryAttributionField(true);
    }
    public APIRequestGetCopies requestPrimaryAttributionField (boolean value) {
      this.requestField("primary_attribution", value);
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
    public APIRequestGetCopies requestSmartPromotionTypeField () {
      return this.requestSmartPromotionTypeField(true);
    }
    public APIRequestGetCopies requestSmartPromotionTypeField (boolean value) {
      this.requestField("smart_promotion_type", value);
      return this;
    }
    public APIRequestGetCopies requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGetCopies requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGetCopies requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGetCopies requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGetCopies requestSpecialAdCategoriesField () {
      return this.requestSpecialAdCategoriesField(true);
    }
    public APIRequestGetCopies requestSpecialAdCategoriesField (boolean value) {
      this.requestField("special_ad_categories", value);
      return this;
    }
    public APIRequestGetCopies requestSpecialAdCategoryField () {
      return this.requestSpecialAdCategoryField(true);
    }
    public APIRequestGetCopies requestSpecialAdCategoryField (boolean value) {
      this.requestField("special_ad_category", value);
      return this;
    }
    public APIRequestGetCopies requestSpecialAdCategoryCountryField () {
      return this.requestSpecialAdCategoryCountryField(true);
    }
    public APIRequestGetCopies requestSpecialAdCategoryCountryField (boolean value) {
      this.requestField("special_ad_category_country", value);
      return this;
    }
    public APIRequestGetCopies requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCopies requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
    public APIRequestGetCopies requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGetCopies requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGetCopies requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGetCopies requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGetCopies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCopies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestCreateCopy extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "deep_copy",
      "end_time",
      "rename_options",
      "start_time",
      "status_option",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Campaign>() {
           public Campaign apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCopy.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateCopy(String nodeId, APIContext context) {
      super(context, nodeId, "/copies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCopy setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCopy setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCopy setDeepCopy (Boolean deepCopy) {
      this.setParam("deep_copy", deepCopy);
      return this;
    }
    public APIRequestCreateCopy setDeepCopy (String deepCopy) {
      this.setParam("deep_copy", deepCopy);
      return this;
    }

    public APIRequestCreateCopy setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateCopy setRenameOptions (Object renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }
    public APIRequestCreateCopy setRenameOptions (String renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }

    public APIRequestCreateCopy setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateCopy setStatusOption (Campaign.EnumStatusOption statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }
    public APIRequestCreateCopy setStatusOption (String statusOption) {
      this.setParam("status_option", statusOption);
      return this;
    }

    public APIRequestCreateCopy requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCopy requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCopy requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCopy requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response, String header) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsInsights>>() {
           public APINodeList<AdsInsights> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

    public APIRequestGetInsights setFields (List<String> fields) {
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

    public APIRequestGetInsights setSummary (List<String> summary) {
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

    public APIRequestGetInsights setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsights setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsights setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
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

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
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
      "use_unified_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportRun parseResponse(String response, String header) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportRun>() {
           public AdReportRun apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsightsAsync.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

    public APIRequestGetInsightsAsync setFields (List<String> fields) {
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

    public APIRequestGetInsightsAsync setSummary (List<String> summary) {
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

    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (Boolean useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseAccountAttributionSetting (String useAccountAttributionSetting) {
      this.setParam("use_account_attribution_setting", useAccountAttributionSetting);
      return this;
    }

    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (Boolean useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
      return this;
    }
    public APIRequestGetInsightsAsync setUseUnifiedAttributionSetting (String useUnifiedAttributionSetting) {
      this.setParam("use_unified_attribution_setting", useUnifiedAttributionSetting);
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
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

  public static class APIRequestGet extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "am_call_tags",
      "date_preset",
      "from_adtable",
      "time_range",
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "bid_strategy",
      "boosted_object_id",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "budget_remaining",
      "buying_type",
      "campaign_group_active_time",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "has_secondary_skadnetwork_reporting",
      "id",
      "is_budget_schedule_enabled",
      "is_skadnetwork_attribution",
      "issues_info",
      "last_budget_toggling_time",
      "lifetime_budget",
      "name",
      "objective",
      "pacing_type",
      "primary_attribution",
      "promoted_object",
      "recommendations",
      "smart_promotion_type",
      "source_campaign",
      "source_campaign_id",
      "special_ad_categories",
      "special_ad_category",
      "special_ad_category_country",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "topline_id",
      "updated_time",
    };

    @Override
    public Campaign parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Campaign>() {
           public Campaign apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestGet setAmCallTags (Map<String, String> amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }
    public APIRequestGet setAmCallTags (String amCallTags) {
      this.setParam("am_call_tags", amCallTags);
      return this;
    }

    public APIRequestGet setDatePreset (EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGet setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGet setFromAdtable (Boolean fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }
    public APIRequestGet setFromAdtable (String fromAdtable) {
      this.setParam("from_adtable", fromAdtable);
      return this;
    }

    public APIRequestGet setTimeRange (Map<String, String> timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGet setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
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
    public APIRequestGet requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGet requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGet requestBoostedObjectIdField () {
      return this.requestBoostedObjectIdField(true);
    }
    public APIRequestGet requestBoostedObjectIdField (boolean value) {
      this.requestField("boosted_object_id", value);
      return this;
    }
    public APIRequestGet requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGet requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGet requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGet requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGet requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGet requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGet requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGet requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupActiveTimeField () {
      return this.requestCampaignGroupActiveTimeField(true);
    }
    public APIRequestGet requestCampaignGroupActiveTimeField (boolean value) {
      this.requestField("campaign_group_active_time", value);
      return this;
    }
    public APIRequestGet requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGet requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGet requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGet requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
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
    public APIRequestGet requestHasSecondarySkadnetworkReportingField () {
      return this.requestHasSecondarySkadnetworkReportingField(true);
    }
    public APIRequestGet requestHasSecondarySkadnetworkReportingField (boolean value) {
      this.requestField("has_secondary_skadnetwork_reporting", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsBudgetScheduleEnabledField () {
      return this.requestIsBudgetScheduleEnabledField(true);
    }
    public APIRequestGet requestIsBudgetScheduleEnabledField (boolean value) {
      this.requestField("is_budget_schedule_enabled", value);
      return this;
    }
    public APIRequestGet requestIsSkadnetworkAttributionField () {
      return this.requestIsSkadnetworkAttributionField(true);
    }
    public APIRequestGet requestIsSkadnetworkAttributionField (boolean value) {
      this.requestField("is_skadnetwork_attribution", value);
      return this;
    }
    public APIRequestGet requestIssuesInfoField () {
      return this.requestIssuesInfoField(true);
    }
    public APIRequestGet requestIssuesInfoField (boolean value) {
      this.requestField("issues_info", value);
      return this;
    }
    public APIRequestGet requestLastBudgetTogglingTimeField () {
      return this.requestLastBudgetTogglingTimeField(true);
    }
    public APIRequestGet requestLastBudgetTogglingTimeField (boolean value) {
      this.requestField("last_budget_toggling_time", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGet requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGet requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGet requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGet requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGet requestPrimaryAttributionField () {
      return this.requestPrimaryAttributionField(true);
    }
    public APIRequestGet requestPrimaryAttributionField (boolean value) {
      this.requestField("primary_attribution", value);
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
    public APIRequestGet requestSmartPromotionTypeField () {
      return this.requestSmartPromotionTypeField(true);
    }
    public APIRequestGet requestSmartPromotionTypeField (boolean value) {
      this.requestField("smart_promotion_type", value);
      return this;
    }
    public APIRequestGet requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGet requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGet requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGet requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGet requestSpecialAdCategoriesField () {
      return this.requestSpecialAdCategoriesField(true);
    }
    public APIRequestGet requestSpecialAdCategoriesField (boolean value) {
      this.requestField("special_ad_categories", value);
      return this;
    }
    public APIRequestGet requestSpecialAdCategoryField () {
      return this.requestSpecialAdCategoryField(true);
    }
    public APIRequestGet requestSpecialAdCategoryField (boolean value) {
      this.requestField("special_ad_category", value);
      return this;
    }
    public APIRequestGet requestSpecialAdCategoryCountryField () {
      return this.requestSpecialAdCategoryCountryField(true);
    }
    public APIRequestGet requestSpecialAdCategoryCountryField (boolean value) {
      this.requestField("special_ad_category_country", value);
      return this;
    }
    public APIRequestGet requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGet requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
    public APIRequestGet requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGet requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGet requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGet requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
      "adset_bid_amounts",
      "adset_budgets",
      "bid_strategy",
      "budget_rebalance_flag",
      "daily_budget",
      "execution_options",
      "is_skadnetwork_attribution",
      "iterative_split_test_configs",
      "lifetime_budget",
      "name",
      "objective",
      "pacing_type",
      "promoted_object",
      "smart_promotion_type",
      "special_ad_categories",
      "special_ad_category",
      "special_ad_category_country",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Campaign>() {
           public Campaign apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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


    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setAdsetBidAmounts (Map<String, String> adsetBidAmounts) {
      this.setParam("adset_bid_amounts", adsetBidAmounts);
      return this;
    }
    public APIRequestUpdate setAdsetBidAmounts (String adsetBidAmounts) {
      this.setParam("adset_bid_amounts", adsetBidAmounts);
      return this;
    }

    public APIRequestUpdate setAdsetBudgets (List<Map<String, String>> adsetBudgets) {
      this.setParam("adset_budgets", adsetBudgets);
      return this;
    }
    public APIRequestUpdate setAdsetBudgets (String adsetBudgets) {
      this.setParam("adset_budgets", adsetBudgets);
      return this;
    }

    public APIRequestUpdate setBidStrategy (Campaign.EnumBidStrategy bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }
    public APIRequestUpdate setBidStrategy (String bidStrategy) {
      this.setParam("bid_strategy", bidStrategy);
      return this;
    }

    public APIRequestUpdate setBudgetRebalanceFlag (Boolean budgetRebalanceFlag) {
      this.setParam("budget_rebalance_flag", budgetRebalanceFlag);
      return this;
    }
    public APIRequestUpdate setBudgetRebalanceFlag (String budgetRebalanceFlag) {
      this.setParam("budget_rebalance_flag", budgetRebalanceFlag);
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

    public APIRequestUpdate setExecutionOptions (List<Campaign.EnumExecutionOptions> executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }
    public APIRequestUpdate setExecutionOptions (String executionOptions) {
      this.setParam("execution_options", executionOptions);
      return this;
    }

    public APIRequestUpdate setIsSkadnetworkAttribution (Boolean isSkadnetworkAttribution) {
      this.setParam("is_skadnetwork_attribution", isSkadnetworkAttribution);
      return this;
    }
    public APIRequestUpdate setIsSkadnetworkAttribution (String isSkadnetworkAttribution) {
      this.setParam("is_skadnetwork_attribution", isSkadnetworkAttribution);
      return this;
    }

    public APIRequestUpdate setIterativeSplitTestConfigs (List<Object> iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
      return this;
    }
    public APIRequestUpdate setIterativeSplitTestConfigs (String iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
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

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setObjective (Campaign.EnumObjective objective) {
      this.setParam("objective", objective);
      return this;
    }
    public APIRequestUpdate setObjective (String objective) {
      this.setParam("objective", objective);
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

    public APIRequestUpdate setSmartPromotionType (Campaign.EnumSmartPromotionType smartPromotionType) {
      this.setParam("smart_promotion_type", smartPromotionType);
      return this;
    }
    public APIRequestUpdate setSmartPromotionType (String smartPromotionType) {
      this.setParam("smart_promotion_type", smartPromotionType);
      return this;
    }

    public APIRequestUpdate setSpecialAdCategories (List<Campaign.EnumSpecialAdCategories> specialAdCategories) {
      this.setParam("special_ad_categories", specialAdCategories);
      return this;
    }
    public APIRequestUpdate setSpecialAdCategories (String specialAdCategories) {
      this.setParam("special_ad_categories", specialAdCategories);
      return this;
    }

    public APIRequestUpdate setSpecialAdCategory (Campaign.EnumSpecialAdCategory specialAdCategory) {
      this.setParam("special_ad_category", specialAdCategory);
      return this;
    }
    public APIRequestUpdate setSpecialAdCategory (String specialAdCategory) {
      this.setParam("special_ad_category", specialAdCategory);
      return this;
    }

    public APIRequestUpdate setSpecialAdCategoryCountry (List<Campaign.EnumSpecialAdCategoryCountry> specialAdCategoryCountry) {
      this.setParam("special_ad_category_country", specialAdCategoryCountry);
      return this;
    }
    public APIRequestUpdate setSpecialAdCategoryCountry (String specialAdCategoryCountry) {
      this.setParam("special_ad_category_country", specialAdCategoryCountry);
      return this;
    }

    public APIRequestUpdate setSpendCap (Long spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }
    public APIRequestUpdate setSpendCap (String spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }

    public APIRequestUpdate setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestUpdate setStatus (Campaign.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setStopTime (String stopTime) {
      this.setParam("stop_time", stopTime);
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

  public static enum EnumBidStrategy {
      @SerializedName("COST_CAP")
      VALUE_COST_CAP("COST_CAP"),
      @SerializedName("LOWEST_COST_WITHOUT_CAP")
      VALUE_LOWEST_COST_WITHOUT_CAP("LOWEST_COST_WITHOUT_CAP"),
      @SerializedName("LOWEST_COST_WITH_BID_CAP")
      VALUE_LOWEST_COST_WITH_BID_CAP("LOWEST_COST_WITH_BID_CAP"),
      @SerializedName("LOWEST_COST_WITH_MIN_ROAS")
      VALUE_LOWEST_COST_WITH_MIN_ROAS("LOWEST_COST_WITH_MIN_ROAS"),
      ;

      private String value;

      private EnumBidStrategy(String value) {
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
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

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
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("IN_PROCESS")
      VALUE_IN_PROCESS("IN_PROCESS"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("WITH_ISSUES")
      VALUE_WITH_ISSUES("WITH_ISSUES"),
      ;

      private String value;

      private EnumEffectiveStatus(String value) {
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
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

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
      @SerializedName("data_maximum")
      VALUE_DATA_MAXIMUM("data_maximum"),
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("maximum")
      VALUE_MAXIMUM("maximum"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      ;

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
      @SerializedName("include_recommendations")
      VALUE_INCLUDE_RECOMMENDATIONS("include_recommendations"),
      @SerializedName("validate_only")
      VALUE_VALIDATE_ONLY("validate_only"),
      ;

      private String value;

      private EnumExecutionOptions(String value) {
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

  public static enum EnumSmartPromotionType {
      @SerializedName("GUIDED_CREATION")
      VALUE_GUIDED_CREATION("GUIDED_CREATION"),
      @SerializedName("SMART_APP_PROMOTION")
      VALUE_SMART_APP_PROMOTION("SMART_APP_PROMOTION"),
      ;

      private String value;

      private EnumSmartPromotionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSpecialAdCategories {
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

      private EnumSpecialAdCategories(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSpecialAdCategoryCountry {
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

      private EnumSpecialAdCategoryCountry(String value) {
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
      ;

      private String value;

      private EnumOperator(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSpecialAdCategory {
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

      private EnumSpecialAdCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatusOption {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("INHERITED_FROM_SOURCE")
      VALUE_INHERITED_FROM_SOURCE("INHERITED_FROM_SOURCE"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      ;

      private String value;

      private EnumStatusOption(String value) {
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

  public Campaign copyFrom(Campaign instance) {
    this.mAccountId = instance.mAccountId;
    this.mAdlabels = instance.mAdlabels;
    this.mBidStrategy = instance.mBidStrategy;
    this.mBoostedObjectId = instance.mBoostedObjectId;
    this.mBrandLiftStudies = instance.mBrandLiftStudies;
    this.mBudgetRebalanceFlag = instance.mBudgetRebalanceFlag;
    this.mBudgetRemaining = instance.mBudgetRemaining;
    this.mBuyingType = instance.mBuyingType;
    this.mCampaignGroupActiveTime = instance.mCampaignGroupActiveTime;
    this.mCanCreateBrandLiftStudy = instance.mCanCreateBrandLiftStudy;
    this.mCanUseSpendCap = instance.mCanUseSpendCap;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDailyBudget = instance.mDailyBudget;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mHasSecondarySkadnetworkReporting = instance.mHasSecondarySkadnetworkReporting;
    this.mId = instance.mId;
    this.mIsBudgetScheduleEnabled = instance.mIsBudgetScheduleEnabled;
    this.mIsSkadnetworkAttribution = instance.mIsSkadnetworkAttribution;
    this.mIssuesInfo = instance.mIssuesInfo;
    this.mLastBudgetTogglingTime = instance.mLastBudgetTogglingTime;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mName = instance.mName;
    this.mObjective = instance.mObjective;
    this.mPacingType = instance.mPacingType;
    this.mPrimaryAttribution = instance.mPrimaryAttribution;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRecommendations = instance.mRecommendations;
    this.mSmartPromotionType = instance.mSmartPromotionType;
    this.mSourceCampaign = instance.mSourceCampaign;
    this.mSourceCampaignId = instance.mSourceCampaignId;
    this.mSpecialAdCategories = instance.mSpecialAdCategories;
    this.mSpecialAdCategory = instance.mSpecialAdCategory;
    this.mSpecialAdCategoryCountry = instance.mSpecialAdCategoryCountry;
    this.mSpendCap = instance.mSpendCap;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mStopTime = instance.mStopTime;
    this.mToplineId = instance.mToplineId;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Campaign> getParser() {
    return new APIRequest.ResponseParser<Campaign>() {
      public APINodeList<Campaign> parseResponse(String response, APIContext context, APIRequest<Campaign> request, String header) throws MalformedResponseException {
        return Campaign.parseResponse(response, context, request, header);
      }
    };
  }
}
