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
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_autobid")
  private Boolean mIsAutobid = null;
  @SerializedName("is_average_price_pacing")
  private Boolean mIsAveragePricePacing = null;
  @SerializedName("kpi_custom_conversion_id")
  private String mKpiCustomConversionId = null;
  @SerializedName("kpi_type")
  private String mKpiType = null;
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
  @SerializedName("promoted_object")
  private AdPromotedObject mPromotedObject = null;
  @SerializedName("recommendations")
  private List<AdRecommendation> mRecommendations = null;
  @SerializedName("source_campaign")
  private Campaign mSourceCampaign = null;
  @SerializedName("source_campaign_id")
  private String mSourceCampaignId = null;
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
  public static Campaign loadJSON(String json, APIContext context) {
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
      };
    }
    campaign.context = context;
    campaign.rawValue = json;
    return campaign;
  }

  public static APINodeList<Campaign> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Campaign> campaigns = new APINodeList<Campaign>(request, json);
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
          campaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              campaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  campaigns.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              campaigns.add(loadJSON(obj.toString(), context));
            }
          }
          return campaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              campaigns.add(loadJSON(entry.getValue().toString(), context));
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
              campaigns.add(loadJSON(value.toString(), context));
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
          campaigns.add(loadJSON(json, context));
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

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), context);
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

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAutobid() {
    return mIsAutobid;
  }

  public Boolean getFieldIsAveragePricePacing() {
    return mIsAveragePricePacing;
  }

  public String getFieldKpiCustomConversionId() {
    return mKpiCustomConversionId;
  }

  public String getFieldKpiType() {
    return mKpiType;
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

  public AdPromotedObject getFieldPromotedObject() {
    if (mPromotedObject != null) {
      mPromotedObject.context = getContext();
    }
    return mPromotedObject;
  }

  public List<AdRecommendation> getFieldRecommendations() {
    return mRecommendations;
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
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<AdStudy> parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdStudy> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudy> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudy>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudy>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdStudy>>() {
           public APINodeList<AdStudy> apply(String result) {
             try {
               return APIRequestGetAdStudies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAdLabels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

    public APIRequestDeleteAdLabels setExecutionOptions (List<Campaign.EnumExecutionOptions> executionOptions) {
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
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
             try {
               return APIRequestCreateAdLabel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "effective_status",
      "date_preset",
      "include_deleted",
      "time_range",
      "updated_since",
      "ad_draft_id",
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
      "demolink_hash",
      "display_sequence",
      "effective_status",
      "engagement_audience",
      "failed_delivery_checks",
      "id",
      "issues_info",
      "last_updated_by_app_id",
      "name",
      "objective_source",
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

    public ListenableFuture<APINodeList<Ad>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Ad>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Ad>>() {
           public APINodeList<Ad> apply(String result) {
             try {
               return APIRequestGetAds.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
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
    public APIRequestGetAds requestObjectiveSourceField () {
      return this.requestObjectiveSourceField(true);
    }
    public APIRequestGetAds requestObjectiveSourceField (boolean value) {
      this.requestField("objective_source", value);
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
      "effective_status",
      "date_preset",
      "is_completed",
      "time_range",
      "ad_draft_id",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_keywords",
      "adasset_feed",
      "adlabels",
      "adset_schedule",
      "asset_feed_id",
      "attribution_spec",
      "best_creative",
      "bid_adjustments",
      "bid_amount",
      "bid_info",
      "bid_strategy",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "daily_min_spend_target",
      "daily_spend_cap",
      "destination_type",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "full_funnel_exploration_mode",
      "id",
      "instagram_actor_id",
      "is_autobid",
      "is_average_price_pacing",
      "is_dynamic_creative",
      "is_dynamic_creative_optimization",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "lifetime_min_spend_target",
      "lifetime_spend_cap",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "review_feedback",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "tracking_specs",
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

    public ListenableFuture<APINodeList<AdSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdSet>>() {
           public APINodeList<AdSet> apply(String result) {
             try {
               return APIRequestGetAdSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetAdSets setEffectiveStatus (List<AdSet.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetAdSets setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
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

    public APIRequestGetAdSets setIsCompleted (Boolean isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }
    public APIRequestGetAdSets setIsCompleted (String isCompleted) {
      this.setParam("is_completed", isCompleted);
      return this;
    }

    public APIRequestGetAdSets setTimeRange (Object timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetAdSets setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }

    public APIRequestGetAdSets setAdDraftId (String adDraftId) {
      this.setParam("ad_draft_id", adDraftId);
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
    public APIRequestGetAdSets requestAdKeywordsField () {
      return this.requestAdKeywordsField(true);
    }
    public APIRequestGetAdSets requestAdKeywordsField (boolean value) {
      this.requestField("ad_keywords", value);
      return this;
    }
    public APIRequestGetAdSets requestAdassetFeedField () {
      return this.requestAdassetFeedField(true);
    }
    public APIRequestGetAdSets requestAdassetFeedField (boolean value) {
      this.requestField("adasset_feed", value);
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
    public APIRequestGetAdSets requestBestCreativeField () {
      return this.requestBestCreativeField(true);
    }
    public APIRequestGetAdSets requestBestCreativeField (boolean value) {
      this.requestField("best_creative", value);
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
    public APIRequestGetAdSets requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
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
    public APIRequestGetAdSets requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetAdSets requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGetAdSets requestIsAveragePricePacingField () {
      return this.requestIsAveragePricePacingField(true);
    }
    public APIRequestGetAdSets requestIsAveragePricePacingField (boolean value) {
      this.requestField("is_average_price_pacing", value);
      return this;
    }
    public APIRequestGetAdSets requestIsDynamicCreativeField () {
      return this.requestIsDynamicCreativeField(true);
    }
    public APIRequestGetAdSets requestIsDynamicCreativeField (boolean value) {
      this.requestField("is_dynamic_creative", value);
      return this;
    }
    public APIRequestGetAdSets requestIsDynamicCreativeOptimizationField () {
      return this.requestIsDynamicCreativeOptimizationField(true);
    }
    public APIRequestGetAdSets requestIsDynamicCreativeOptimizationField (boolean value) {
      this.requestField("is_dynamic_creative_optimization", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
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
    public APIRequestGetAdSets requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGetAdSets requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
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
    public APIRequestGetAdSets requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAdSets requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
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

  public static class APIRequestGetCopies extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "effective_status",
      "date_preset",
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
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "id",
      "is_autobid",
      "is_average_price_pacing",
      "kpi_custom_conversion_id",
      "kpi_type",
      "last_budget_toggling_time",
      "lifetime_budget",
      "name",
      "objective",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "topline_id",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Campaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Campaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Campaign>>() {
           public APINodeList<Campaign> apply(String result) {
             try {
               return APIRequestGetCopies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetCopies setEffectiveStatus (List<Campaign.EnumEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }
    public APIRequestGetCopies setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetCopies setDatePreset (EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetCopies setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
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
    public APIRequestGetCopies requestKpiCustomConversionIdField () {
      return this.requestKpiCustomConversionIdField(true);
    }
    public APIRequestGetCopies requestKpiCustomConversionIdField (boolean value) {
      this.requestField("kpi_custom_conversion_id", value);
      return this;
    }
    public APIRequestGetCopies requestKpiTypeField () {
      return this.requestKpiTypeField(true);
    }
    public APIRequestGetCopies requestKpiTypeField (boolean value) {
      this.requestField("kpi_type", value);
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
      "rename_options",
      "status_option",
      "start_time",
      "end_time",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
             try {
               return APIRequestCreateCopy.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestCreateCopy setRenameOptions (Object renameOptions) {
      this.setParam("rename_options", renameOptions);
      return this;
    }
    public APIRequestCreateCopy setRenameOptions (String renameOptions) {
      this.setParam("rename_options", renameOptions);
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

    public APIRequestCreateCopy setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateCopy setEndTime (String endTime) {
      this.setParam("end_time", endTime);
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
      "export_columns",
      "export_format",
      "export_name",
      "level",
      "product_id_limit",
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

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsInsights>>() {
           public APINodeList<AdsInsights> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetInsights setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsights setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
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

    public APIRequestGetInsights setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsights setSummary (String summary) {
      this.setParam("summary", summary);
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

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
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
      "export_columns",
      "export_format",
      "export_name",
      "level",
      "product_id_limit",
      "summary_action_breakdowns",
      "time_increment",
      "time_range",
      "time_ranges",
      "use_account_attribution_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportRun parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdReportRun>() {
           public AdReportRun apply(String result) {
             try {
               return APIRequestGetInsightsAsync.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetInsightsAsync setDefaultSummary (Boolean defaultSummary) {
      this.setParam("default_summary", defaultSummary);
      return this;
    }
    public APIRequestGetInsightsAsync setDefaultSummary (String defaultSummary) {
      this.setParam("default_summary", defaultSummary);
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

    public APIRequestGetInsightsAsync setSummary (List<String> summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGetInsightsAsync setSummary (String summary) {
      this.setParam("summary", summary);
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

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "id",
      "is_autobid",
      "is_average_price_pacing",
      "kpi_custom_conversion_id",
      "kpi_type",
      "last_budget_toggling_time",
      "lifetime_budget",
      "name",
      "objective",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "topline_id",
      "updated_time",
    };

    @Override
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
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

    public APIRequestGet setTimeRange (Object timeRange) {
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
    public APIRequestGet requestKpiCustomConversionIdField () {
      return this.requestKpiCustomConversionIdField(true);
    }
    public APIRequestGet requestKpiCustomConversionIdField (boolean value) {
      this.requestField("kpi_custom_conversion_id", value);
      return this;
    }
    public APIRequestGet requestKpiTypeField () {
      return this.requestKpiTypeField(true);
    }
    public APIRequestGet requestKpiTypeField (boolean value) {
      this.requestField("kpi_type", value);
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
      "name",
      "objective",
      "status",
      "bid_strategy",
      "budget_rebalance_flag",
      "daily_budget",
      "lifetime_budget",
      "pacing_type",
      "promoted_object",
      "spend_cap",
      "execution_options",
      "upstream_events",
      "adlabels",
      "iterative_split_test_configs",
      "kpi_custom_conversion_id",
      "kpi_type",
      "is_autobid",
      "is_average_price_pacing",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Campaign parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Campaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Campaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Campaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Campaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Campaign>() {
           public Campaign apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestUpdate setStatus (Campaign.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
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

    public APIRequestUpdate setLifetimeBudget (Long lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
      return this;
    }
    public APIRequestUpdate setLifetimeBudget (String lifetimeBudget) {
      this.setParam("lifetime_budget", lifetimeBudget);
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

    public APIRequestUpdate setSpendCap (Long spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }
    public APIRequestUpdate setSpendCap (String spendCap) {
      this.setParam("spend_cap", spendCap);
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

    public APIRequestUpdate setUpstreamEvents (Map<String, String> upstreamEvents) {
      this.setParam("upstream_events", upstreamEvents);
      return this;
    }
    public APIRequestUpdate setUpstreamEvents (String upstreamEvents) {
      this.setParam("upstream_events", upstreamEvents);
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

    public APIRequestUpdate setIterativeSplitTestConfigs (List<Object> iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
      return this;
    }
    public APIRequestUpdate setIterativeSplitTestConfigs (String iterativeSplitTestConfigs) {
      this.setParam("iterative_split_test_configs", iterativeSplitTestConfigs);
      return this;
    }

    public APIRequestUpdate setKpiCustomConversionId (String kpiCustomConversionId) {
      this.setParam("kpi_custom_conversion_id", kpiCustomConversionId);
      return this;
    }

    public APIRequestUpdate setKpiType (Object kpiType) {
      this.setParam("kpi_type", kpiType);
      return this;
    }
    public APIRequestUpdate setKpiType (String kpiType) {
      this.setParam("kpi_type", kpiType);
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
      @SerializedName("LOWEST_COST_WITHOUT_CAP")
      VALUE_LOWEST_COST_WITHOUT_CAP("LOWEST_COST_WITHOUT_CAP"),
      @SerializedName("LOWEST_COST_WITH_BID_CAP")
      VALUE_LOWEST_COST_WITH_BID_CAP("LOWEST_COST_WITH_BID_CAP"),
      @SerializedName("TARGET_COST")
      VALUE_TARGET_COST("TARGET_COST"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumObjective(String value) {
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
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumOperator(String value) {
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
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("INHERITED_FROM_SOURCE")
      VALUE_INHERITED_FROM_SOURCE("INHERITED_FROM_SOURCE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
    this.mCanCreateBrandLiftStudy = instance.mCanCreateBrandLiftStudy;
    this.mCanUseSpendCap = instance.mCanUseSpendCap;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDailyBudget = instance.mDailyBudget;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mId = instance.mId;
    this.mIsAutobid = instance.mIsAutobid;
    this.mIsAveragePricePacing = instance.mIsAveragePricePacing;
    this.mKpiCustomConversionId = instance.mKpiCustomConversionId;
    this.mKpiType = instance.mKpiType;
    this.mLastBudgetTogglingTime = instance.mLastBudgetTogglingTime;
    this.mLifetimeBudget = instance.mLifetimeBudget;
    this.mName = instance.mName;
    this.mObjective = instance.mObjective;
    this.mPacingType = instance.mPacingType;
    this.mPromotedObject = instance.mPromotedObject;
    this.mRecommendations = instance.mRecommendations;
    this.mSourceCampaign = instance.mSourceCampaign;
    this.mSourceCampaignId = instance.mSourceCampaignId;
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
      public APINodeList<Campaign> parseResponse(String response, APIContext context, APIRequest<Campaign> request) throws MalformedResponseException {
        return Campaign.parseResponse(response, context, request);
      }
    };
  }
}
