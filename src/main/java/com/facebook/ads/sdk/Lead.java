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
public class Lead extends APINode {
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("custom_disclaimer_responses")
  private List<UserLeadGenDisclaimerResponse> mCustomDisclaimerResponses = null;
  @SerializedName("field_data")
  private List<UserLeadGenFieldData> mFieldData = null;
  @SerializedName("form_id")
  private String mFormId = null;
  @SerializedName("home_listing")
  private HomeListing mHomeListing = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_organic")
  private Boolean mIsOrganic = null;
  @SerializedName("partner_name")
  private String mPartnerName = null;
  @SerializedName("platform")
  private String mPlatform = null;
  @SerializedName("post")
  private Link mPost = null;
  @SerializedName("post_submission_check_result")
  private LeadGenPostSubmissionCheckResult mPostSubmissionCheckResult = null;
  @SerializedName("retailer_item_id")
  private String mRetailerItemId = null;
  @SerializedName("vehicle")
  private Vehicle mVehicle = null;
  protected static Gson gson = null;

  Lead() {
  }

  public Lead(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Lead(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Lead fetch() throws APIException{
    Lead newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Lead fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Lead> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Lead fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Lead> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Lead> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Lead>)(
      new APIRequest<Lead>(context, "", "/", "GET", Lead.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Lead>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Lead.getParser())
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
  public static Lead loadJSON(String json, APIContext context, String header) {
    Lead lead = getGson().fromJson(json, Lead.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(lead.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    lead.context = context;
    lead.rawValue = json;
    lead.header = header;
    return lead;
  }

  public static APINodeList<Lead> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Lead> leads = new APINodeList<Lead>(request, json, header);
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
          leads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leads.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leads.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leads.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leads;
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
              leads.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leads;
          }

          // Sixth, check if it's pure JsonObject
          leads.clear();
          leads.add(loadJSON(json, context, header));
          return leads;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdId() {
    return mAdId;
  }

  public String getFieldAdName() {
    return mAdName;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public String getFieldAdsetName() {
    return mAdsetName;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<UserLeadGenDisclaimerResponse> getFieldCustomDisclaimerResponses() {
    return mCustomDisclaimerResponses;
  }

  public List<UserLeadGenFieldData> getFieldFieldData() {
    return mFieldData;
  }

  public String getFieldFormId() {
    return mFormId;
  }

  public HomeListing getFieldHomeListing() {
    if (mHomeListing != null) {
      mHomeListing.context = getContext();
    }
    return mHomeListing;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsOrganic() {
    return mIsOrganic;
  }

  public String getFieldPartnerName() {
    return mPartnerName;
  }

  public String getFieldPlatform() {
    return mPlatform;
  }

  public Link getFieldPost() {
    if (mPost != null) {
      mPost.context = getContext();
    }
    return mPost;
  }

  public LeadGenPostSubmissionCheckResult getFieldPostSubmissionCheckResult() {
    return mPostSubmissionCheckResult;
  }

  public String getFieldRetailerItemId() {
    return mRetailerItemId;
  }

  public Vehicle getFieldVehicle() {
    if (mVehicle != null) {
      mVehicle.context = getContext();
    }
    return mVehicle;
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

  public static class APIRequestGet extends APIRequest<Lead> {

    Lead lastResponse = null;
    @Override
    public Lead getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "home_listing",
      "id",
      "is_organic",
      "partner_name",
      "platform",
      "post",
      "post_submission_check_result",
      "retailer_item_id",
      "vehicle",
    };

    @Override
    public Lead parseResponse(String response, String header) throws APIException {
      return Lead.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Lead execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Lead execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Lead> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Lead> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Lead>() {
           public Lead apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGet requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGet requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGet requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGet requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGet requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGet requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGet requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGet requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGet requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGet requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGet requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGet requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGet requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGet requestHomeListingField () {
      return this.requestHomeListingField(true);
    }
    public APIRequestGet requestHomeListingField (boolean value) {
      this.requestField("home_listing", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGet requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGet requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGet requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGet requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGet requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGet requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGet requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGet requestPostSubmissionCheckResultField () {
      return this.requestPostSubmissionCheckResultField(true);
    }
    public APIRequestGet requestPostSubmissionCheckResultField (boolean value) {
      this.requestField("post_submission_check_result", value);
      return this;
    }
    public APIRequestGet requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGet requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
    public APIRequestGet requestVehicleField () {
      return this.requestVehicleField(true);
    }
    public APIRequestGet requestVehicleField (boolean value) {
      this.requestField("vehicle", value);
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

  public Lead copyFrom(Lead instance) {
    this.mAdId = instance.mAdId;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCustomDisclaimerResponses = instance.mCustomDisclaimerResponses;
    this.mFieldData = instance.mFieldData;
    this.mFormId = instance.mFormId;
    this.mHomeListing = instance.mHomeListing;
    this.mId = instance.mId;
    this.mIsOrganic = instance.mIsOrganic;
    this.mPartnerName = instance.mPartnerName;
    this.mPlatform = instance.mPlatform;
    this.mPost = instance.mPost;
    this.mPostSubmissionCheckResult = instance.mPostSubmissionCheckResult;
    this.mRetailerItemId = instance.mRetailerItemId;
    this.mVehicle = instance.mVehicle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Lead> getParser() {
    return new APIRequest.ResponseParser<Lead>() {
      public APINodeList<Lead> parseResponse(String response, APIContext context, APIRequest<Lead> request, String header) throws MalformedResponseException {
        return Lead.parseResponse(response, context, request, header);
      }
    };
  }
}
