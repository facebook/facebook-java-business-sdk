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


public class Campaign extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("buying_type")
  private String mBuyingType = null;
  @SerializedName("can_use_spend_cap")
  private Boolean mCanUseSpendCap = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("effective_status")
  private EnumCampaignEffectiveStatus mEffectiveStatus = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("objective")
  private String mObjective = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("stop_time")
  private String mStopTime = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("spend_cap")
  private String mSpendCap = null;
  protected static Gson gson = null;

  Campaign() {
  }

  public Campaign(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Campaign(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public Campaign fetch() throws APIException{
    Campaign newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static Campaign fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static Campaign fetchById(String id, APIContext context) throws APIException {
    Campaign campaign =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return campaign;
  }

  private String getPrefixedId() {
    return mId.toString();
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    campaign.mContext = context;
    campaign.rawValue = json;
    return campaign;
  }

  public static APINodeList<Campaign> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<Campaign> campaigns = new APINodeList<Campaign>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            campaigns.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            campaigns.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          campaigns.add(loadJSON(json, context));
          return campaigns;
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

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldBuyingType() {
    return mBuyingType;
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

  public EnumCampaignEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldObjective() {
    return mObjective;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldStopTime() {
    return mStopTime;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldSpendCap() {
    return mSpendCap;
  }



  public static class APIRequestGet extends APIRequest<Campaign> {

    Campaign lastResponse = null;
    @Override
    public Campaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "adlabels",
      "account_id",
      "buying_type",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "effective_status",
      "name",
      "objective",
      "start_time",
      "stop_time",
      "updated_time",
      "spend_cap",
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGet requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
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
    public APIRequestGet requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGet requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
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
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGet requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGet requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
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
      "name",
      "objective",
      "status",
      "spend_cap",
      "execution_options",
      "adlabels",
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setObjective (EnumObjective objective) {
      this.setParam("objective", objective);
      return this;
    }

    public APIRequestUpdate setObjective (String objective) {
      this.setParam("objective", objective);
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

    public APIRequestUpdate setSpendCap (Long spendCap) {
      this.setParam("spend_cap", spendCap);
      return this;
    }

    public APIRequestUpdate setSpendCap (String spendCap) {
      this.setParam("spend_cap", spendCap);
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

    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
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

    public APIRequestGetAds setIncludeDeleted (Boolean includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
      return this;
    }

    public APIRequestGetAds setIncludeDeleted (String includeDeleted) {
      this.setParam("include_deleted", includeDeleted);
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
    public APINodeList<AdSet> parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets setEffectiveStatus (List<EnumAdSetEffectiveStatus> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAdSets setDatePreset (EnumAdSetDatePreset datePreset) {
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

    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetAdSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
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
    public APIRequestGetAdSets requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSets requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
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
    public APIRequestGetAdSets requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetAdSets requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
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
    public APIRequestGetAdSets requestProductAdBehaviorField () {
      return this.requestProductAdBehaviorField(true);
    }
    public APIRequestGetAdSets requestProductAdBehaviorField (boolean value) {
      this.requestField("product_ad_behavior", value);
      return this;
    }
    public APIRequestGetAdSets requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSets requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
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
    public APIRequestGetAdSets requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSets requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSets requestTargetingField (boolean value) {
      this.requestField("targeting", value);
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
    public APIRequestGetAdSets requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSets requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSets requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSets requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSets requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
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
      "level",
      "product_id_limit",
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
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetInsights setFields (List<EnumFields> fields) {
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

    public APIRequestGetInsights setSummary (List<EnumFields> summary) {
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

    public APIRequestGetInsights setActionAttributionWindows (List<EnumActionAttributionWindows> actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionAttributionWindows (String actionAttributionWindows) {
      this.setParam("action_attribution_windows", actionAttributionWindows);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (List<EnumActionBreakdowns> actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionBreakdowns (String actionBreakdowns) {
      this.setParam("action_breakdowns", actionBreakdowns);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (EnumActionReportTime actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setActionReportTime (String actionReportTime) {
      this.setParam("action_report_time", actionReportTime);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetInsights setDatePreset (EnumAdsInsightsDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setLevel (EnumLevel level) {
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

    public APIRequestGetInsights setSummaryActionBreakdowns (List<EnumSummaryActionBreakdowns> summaryActionBreakdowns) {
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


    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }


    public APIRequestGetInsights setTimeRanges (List<String> timeRanges) {
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

    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public static enum EnumObjective {
    @SerializedName("CANVAS_APP_ENGAGEMENT")
    VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
    @SerializedName("CANVAS_APP_INSTALLS")
    VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
    @SerializedName("CONVERSIONS")
    VALUE_CONVERSIONS("CONVERSIONS"),
    @SerializedName("EVENT_RESPONSES")
    VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
    @SerializedName("EXTERNAL")
    VALUE_EXTERNAL("EXTERNAL"),
    @SerializedName("LEAD_GENERATION")
    VALUE_LEAD_GENERATION("LEAD_GENERATION"),
    @SerializedName("LINK_CLICKS")
    VALUE_LINK_CLICKS("LINK_CLICKS"),
    @SerializedName("LOCAL_AWARENESS")
    VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
    @SerializedName("MOBILE_APP_ENGAGEMENT")
    VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
    @SerializedName("MOBILE_APP_INSTALLS")
    VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
    @SerializedName("OFFER_CLAIMS")
    VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
    @SerializedName("PAGE_LIKES")
    VALUE_PAGE_LIKES("PAGE_LIKES"),
    @SerializedName("POST_ENGAGEMENT")
    VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
    @SerializedName("PRODUCT_CATALOG_SALES")
    VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
    @SerializedName("VIDEO_VIEWS")
    VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
    NULL(null);

    private String value;

    private EnumObjective(String value) {
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
  public static enum EnumAdSetEffectiveStatus {
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

    private EnumAdSetEffectiveStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAdSetDatePreset {
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

    private EnumAdSetDatePreset(String value) {
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
  public static enum EnumCampaignEffectiveStatus {
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

    private EnumCampaignEffectiveStatus(String value) {
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
    this.mId = instance.mId;
    this.mAdlabels = instance.mAdlabels;
    this.mAccountId = instance.mAccountId;
    this.mBuyingType = instance.mBuyingType;
    this.mCanUseSpendCap = instance.mCanUseSpendCap;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mName = instance.mName;
    this.mObjective = instance.mObjective;
    this.mStartTime = instance.mStartTime;
    this.mStopTime = instance.mStopTime;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mSpendCap = instance.mSpendCap;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Campaign> getParser() {
    return new APIRequest.ResponseParser<Campaign>() {
      public APINodeList<Campaign> parseResponse(String response, APIContext context, APIRequest<Campaign> request) {
        return Campaign.parseResponse(response, context, request);
      }
    };
  }
}