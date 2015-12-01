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


public class Ad extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("adset")
  private AdSet mAdset = null;
  @SerializedName("campaign")
  private Campaign mCampaign = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("bid_amount")
  private Long mBidAmount = null;
  @SerializedName("bid_info")
  private Map<String, Long> mBidInfo = null;
  @SerializedName("bid_type")
  private EnumBidType mBidType = null;
  @SerializedName("configured_status")
  private EnumConfiguredStatus mConfiguredStatus = null;
  @SerializedName("conversion_specs")
  private List<ConversionActionQuery> mConversionSpecs = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creative")
  private AdCreative mCreative = null;
  @SerializedName("effective_status")
  private EnumEffectiveStatus mEffectiveStatus = null;
  @SerializedName("last_updated_by_app_id")
  private String mLastUpdatedByAppId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("tracking_specs")
  private List<ConversionActionQuery> mTrackingSpecs = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("ad_review_feedback")
  private AdgroupReviewFeedback mAdReviewFeedback = null;
  protected static Gson gson = null;

  Ad() {
  }

  public Ad(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Ad(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public Ad fetch() throws APIException{
    Ad newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static Ad fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static Ad fetchById(String id, APIContext context) throws APIException {
    Ad ad =
      new APIRequestGet(id, context)
      .requestAllFields()
      .call();
    return ad;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Ad loadJSON(String json, APIContext context) {
    Ad ad = getGson().fromJson(json, Ad.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(ad.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    ad.mContext = context;
    ad.rawValue = json;
    return ad;
  }

  public static APINodeList<Ad> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<Ad> ads = new APINodeList<Ad>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          ads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return ads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            ads.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              ads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            ads.add(loadJSON(obj.toString(), context));
          }
          return ads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              ads.add(loadJSON(entry.getValue().toString(), context));
          }
          return ads;
        } else {
          // Fifth, check if it's pure JsonObject
          ads.add(loadJSON(json, context));
          return ads;
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

  public APIRequestGetLeads getLeads() {
    return new APIRequestGetLeads(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetKeywordStats getKeywordStats() {
    return new APIRequestGetKeywordStats(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetReachEstimate getReachEstimate() {
    return new APIRequestGetReachEstimate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetTargetingSentenceLines getTargetingSentenceLines() {
    return new APIRequestGetTargetingSentenceLines(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdSet getFieldAdset() {
    return mAdset;
  }

  public Campaign getFieldCampaign() {
    return mCampaign;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public Long getFieldBidAmount() {
    return mBidAmount;
  }

  public Map<String, Long> getFieldBidInfo() {
    return mBidInfo;
  }

  public EnumBidType getFieldBidType() {
    return mBidType;
  }

  public EnumConfiguredStatus getFieldConfiguredStatus() {
    return mConfiguredStatus;
  }

  public List<ConversionActionQuery> getFieldConversionSpecs() {
    return mConversionSpecs;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public AdCreative getFieldCreative() {
    if (mCreative != null) {
      mCreative.mContext = getContext();
    }
    return mCreative;
  }

  public EnumEffectiveStatus getFieldEffectiveStatus() {
    return mEffectiveStatus;
  }

  public String getFieldLastUpdatedByAppId() {
    return mLastUpdatedByAppId;
  }

  public String getFieldName() {
    return mName;
  }

  public List<ConversionActionQuery> getFieldTrackingSpecs() {
    return mTrackingSpecs;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdgroupReviewFeedback getFieldAdReviewFeedback() {
    return mAdReviewFeedback;
  }



  public static class APIRequestGet extends APIRequest<Ad> {

    public static final String[] PARAMS = {
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
    public Ad call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public Ad call(Map<String, Object> extraParams) throws APIException {
      return Ad.parseResponse(callInternal(extraParams), getContext(), this).head();
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
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGet requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGet requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGet requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGet requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
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
    public APIRequestGet requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGet requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGet requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGet requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGet requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGet requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGet requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGet requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGet requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGet requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGet requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGet requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "adset_id",
      "campaign_group_id",
      "creative",
      "name",
      "status",
      "tracking_specs",
      "display_sequence",
      "execution_options",
      "adlabels",
      "bid_amount",
      "redownload",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
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


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestUpdate setAdsetId (Long adsetId) {
      this.setParam("adset_id", adsetId);
      return this;
    }

    public APIRequestUpdate setAdsetId (String adsetId) {
      this.setParam("adset_id", adsetId);
      return this;
    }

    public APIRequestUpdate setCampaignGroupId (Long campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestUpdate setCampaignGroupId (String campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestUpdate setCreative (AdCreative creative) {
      this.setParam("creative", creative);
      return this;
    }

    public APIRequestUpdate setCreative (String creative) {
      this.setParam("creative", creative);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

    public APIRequestUpdate setTrackingSpecs (Object trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestUpdate setTrackingSpecs (String trackingSpecs) {
      this.setParam("tracking_specs", trackingSpecs);
      return this;
    }

    public APIRequestUpdate setDisplaySequence (Long displaySequence) {
      this.setParam("display_sequence", displaySequence);
      return this;
    }

    public APIRequestUpdate setDisplaySequence (String displaySequence) {
      this.setParam("display_sequence", displaySequence);
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

    public APIRequestUpdate setBidAmount (Long bidAmount) {
      this.setParam("bid_amount", bidAmount);
      return this;
    }

    public APIRequestUpdate setBidAmount (String bidAmount) {
      this.setParam("bid_amount", bidAmount);
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

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
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

    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetLeads extends APIRequest<APINode> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetLeads(String nodeId, APIContext context) {
      super(context, nodeId, "/leads", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetLeads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetLeads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetLeads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetLeads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetLeads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

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
    public APINodeList<AdCreative> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> call(Map<String, Object> extraParams) throws APIException {
      return AdCreative.parseResponse(callInternal(extraParams), getContext(), this);
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

  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

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
    public APINodeList<AdsInsights> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> call(Map<String, Object> extraParams) throws APIException {
      return AdsInsights.parseResponse(callInternal(extraParams), getContext(), this);
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

    public APIRequestGetInsights setDatePreset (EnumDatePreset datePreset) {
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

    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetKeywordStats extends APIRequest<AdKeywordStats> {

    public static final String[] PARAMS = {
      "date",
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "impressions",
      "unique_impressions",
      "reach",
      "clicks",
      "unique_clicks",
      "total_actions",
      "total_unique_actions",
      "actions",
      "unique_actions",
      "spend",
      "ctr",
      "unique_ctr",
      "cpm",
      "cpp",
      "cpc",
      "cost_per_total_action",
      "cost_per_unique_click",
      "frequency",
    };

    @Override
    public APINodeList<AdKeywordStats> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdKeywordStats> call(Map<String, Object> extraParams) throws APIException {
      return AdKeywordStats.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetKeywordStats(String nodeId, APIContext context) {
      super(context, nodeId, "/keywordstats", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetKeywordStats setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetKeywordStats setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetKeywordStats setDate (String date) {
      this.setParam("date", date);
      return this;
    }


    public APIRequestGetKeywordStats requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetKeywordStats requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetKeywordStats requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetKeywordStats requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetKeywordStats requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetKeywordStats requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetKeywordStats requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetKeywordStats requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetKeywordStats requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetKeywordStats requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGetKeywordStats requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestUniqueImpressionsField () {
      return this.requestUniqueImpressionsField(true);
    }
    public APIRequestGetKeywordStats requestUniqueImpressionsField (boolean value) {
      this.requestField("unique_impressions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGetKeywordStats requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGetKeywordStats requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGetKeywordStats requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGetKeywordStats requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGetKeywordStats requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGetKeywordStats requestTotalActionsField () {
      return this.requestTotalActionsField(true);
    }
    public APIRequestGetKeywordStats requestTotalActionsField (boolean value) {
      this.requestField("total_actions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestTotalUniqueActionsField () {
      return this.requestTotalUniqueActionsField(true);
    }
    public APIRequestGetKeywordStats requestTotalUniqueActionsField (boolean value) {
      this.requestField("total_unique_actions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetKeywordStats requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGetKeywordStats requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGetKeywordStats requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGetKeywordStats requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGetKeywordStats requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGetKeywordStats requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGetKeywordStats requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGetKeywordStats requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGetKeywordStats requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGetKeywordStats requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCostPerTotalActionField () {
      return this.requestCostPerTotalActionField(true);
    }
    public APIRequestGetKeywordStats requestCostPerTotalActionField (boolean value) {
      this.requestField("cost_per_total_action", value);
      return this;
    }
    public APIRequestGetKeywordStats requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGetKeywordStats requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGetKeywordStats requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGetKeywordStats requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }

  }

  public static class APIRequestGetPreviews extends APIRequest<AdPreview> {

    public static final String[] PARAMS = {
      "ad_format",
      "post",
      "height",
      "width",
      "product_item_ids",
      "locale",
    };

    public static final String[] FIELDS = {
      "body",
    };

    @Override
    public APINodeList<AdPreview> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPreview> call(Map<String, Object> extraParams) throws APIException {
      return AdPreview.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetPreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/previews", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetPreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreviews setAdFormat (EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetPreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetPreviews setPost (Object post) {
      this.setParam("post", post);
      return this;
    }

    public APIRequestGetPreviews setPost (String post) {
      this.setParam("post", post);
      return this;
    }

    public APIRequestGetPreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPreviews setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPreviews setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPreviews setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }


    public APIRequestGetPreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPreviews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPreviews requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetPreviews requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }

  }

  public static class APIRequestGetReachEstimate extends APIRequest<ReachEstimate> {

    public static final String[] PARAMS = {
      "targeting_spec",
      "currency",
      "optimize_for",
      "daily_budget",
      "creative_action_spec",
      "concepts",
      "caller_id",
    };

    public static final String[] FIELDS = {
      "users",
      "bid_estimations",
      "estimate_ready",
      "unsupported",
    };

    @Override
    public APINodeList<ReachEstimate> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ReachEstimate> call(Map<String, Object> extraParams) throws APIException {
      return ReachEstimate.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetReachEstimate(String nodeId, APIContext context) {
      super(context, nodeId, "/reachestimate", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetReachEstimate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetReachEstimate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReachEstimate setTargetingSpec (String targetingSpec) {
      this.setParam("targeting_spec", targetingSpec);
      return this;
    }


    public APIRequestGetReachEstimate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }


    public APIRequestGetReachEstimate setOptimizeFor (EnumOptimizeFor optimizeFor) {
      this.setParam("optimize_for", optimizeFor);
      return this;
    }

    public APIRequestGetReachEstimate setOptimizeFor (String optimizeFor) {
      this.setParam("optimize_for", optimizeFor);
      return this;
    }

    public APIRequestGetReachEstimate setDailyBudget (Double dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestGetReachEstimate setDailyBudget (String dailyBudget) {
      this.setParam("daily_budget", dailyBudget);
      return this;
    }

    public APIRequestGetReachEstimate setCreativeActionSpec (String creativeActionSpec) {
      this.setParam("creative_action_spec", creativeActionSpec);
      return this;
    }


    public APIRequestGetReachEstimate setConcepts (String concepts) {
      this.setParam("concepts", concepts);
      return this;
    }


    public APIRequestGetReachEstimate setCallerId (String callerId) {
      this.setParam("caller_id", callerId);
      return this;
    }


    public APIRequestGetReachEstimate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReachEstimate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetReachEstimate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetReachEstimate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetReachEstimate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReachEstimate requestUsersField () {
      return this.requestUsersField(true);
    }
    public APIRequestGetReachEstimate requestUsersField (boolean value) {
      this.requestField("users", value);
      return this;
    }
    public APIRequestGetReachEstimate requestBidEstimationsField () {
      return this.requestBidEstimationsField(true);
    }
    public APIRequestGetReachEstimate requestBidEstimationsField (boolean value) {
      this.requestField("bid_estimations", value);
      return this;
    }
    public APIRequestGetReachEstimate requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGetReachEstimate requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
      return this;
    }
    public APIRequestGetReachEstimate requestUnsupportedField () {
      return this.requestUnsupportedField(true);
    }
    public APIRequestGetReachEstimate requestUnsupportedField (boolean value) {
      this.requestField("unsupported", value);
      return this;
    }

  }

  public static class APIRequestGetTargetingSentenceLines extends APIRequest<TargetingSentenceLine> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "params",
      "targetingsentencelines",
    };

    @Override
    public APINodeList<TargetingSentenceLine> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TargetingSentenceLine> call(Map<String, Object> extraParams) throws APIException {
      return TargetingSentenceLine.parseResponse(callInternal(extraParams), getContext(), this);
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

    public static final String[] PARAMS = {
      "id",
      "adlabels",
      "execution_options",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this);
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

    public APIRequestDeleteAdLabels setExecutionOptions (List<EnumDeleteAdLabelsExecutionOptions> executionOptions) {
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

    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
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
  public static enum EnumAdFormat {
    @SerializedName("RIGHT_COLUMN_STANDARD")
    VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
    @SerializedName("DESKTOP_FEED_STANDARD")
    VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_STANDARD")
    VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_BASIC")
    VALUE_MOBILE_FEED_BASIC("MOBILE_FEED_BASIC"),
    @SerializedName("MOBILE_INTERSTITIAL")
    VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
    @SerializedName("MOBILE_BANNER")
    VALUE_MOBILE_BANNER("MOBILE_BANNER"),
    @SerializedName("MOBILE_NATIVE")
    VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
    @SerializedName("INSTAGRAM_STANDARD")
    VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
    @SerializedName("LIVERAIL_VIDEO")
    VALUE_LIVERAIL_VIDEO("LIVERAIL_VIDEO"),
    NULL(null);

    private String value;

    private EnumAdFormat(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumOptimizeFor {
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

    private EnumOptimizeFor(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumDeleteAdLabelsExecutionOptions {
    @SerializedName("VALIDATE_ONLY")
    VALUE_VALIDATE_ONLY("VALIDATE_ONLY"),
    @SerializedName("INCLUDE_WARNINGS")
    VALUE_INCLUDE_WARNINGS("INCLUDE_WARNINGS"),
    NULL(null);

    private String value;

    private EnumDeleteAdLabelsExecutionOptions(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumBidType {
    @SerializedName("CPC")
    VALUE_CPC("CPC"),
    @SerializedName("CPM")
    VALUE_CPM("CPM"),
    @SerializedName("MULTI_PREMIUM")
    VALUE_MULTI_PREMIUM("MULTI_PREMIUM"),
    @SerializedName("ABSOLUTE_OCPM")
    VALUE_ABSOLUTE_OCPM("ABSOLUTE_OCPM"),
    @SerializedName("CPA")
    VALUE_CPA("CPA"),
    NULL(null);

    private String value;

    private EnumBidType(String value) {
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

  public Ad copyFrom(Ad instance) {
    this.mId = instance.mId;
    this.mAccountId = instance.mAccountId;
    this.mAdset = instance.mAdset;
    this.mCampaign = instance.mCampaign;
    this.mAdlabels = instance.mAdlabels;
    this.mAdsetId = instance.mAdsetId;
    this.mBidAmount = instance.mBidAmount;
    this.mBidInfo = instance.mBidInfo;
    this.mBidType = instance.mBidType;
    this.mConfiguredStatus = instance.mConfiguredStatus;
    this.mConversionSpecs = instance.mConversionSpecs;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreative = instance.mCreative;
    this.mEffectiveStatus = instance.mEffectiveStatus;
    this.mLastUpdatedByAppId = instance.mLastUpdatedByAppId;
    this.mName = instance.mName;
    this.mTrackingSpecs = instance.mTrackingSpecs;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mCampaignId = instance.mCampaignId;
    this.mAdReviewFeedback = instance.mAdReviewFeedback;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}