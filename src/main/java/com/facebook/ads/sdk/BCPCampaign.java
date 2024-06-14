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
public class BCPCampaign extends APINode {
  @SerializedName("ads_permission_required")
  private Boolean mAdsPermissionRequired = null;
  @SerializedName("application_deadline")
  private String mApplicationDeadline = null;
  @SerializedName("campaign_goal")
  private String mCampaignGoal = null;
  @SerializedName("campaign_goal_other")
  private String mCampaignGoalOther = null;
  @SerializedName("content_delivery_deadline")
  private String mContentDeliveryDeadline = null;
  @SerializedName("content_delivery_start_date")
  private String mContentDeliveryStartDate = null;
  @SerializedName("content_requirements")
  private List<Map<String, Long>> mContentRequirements = null;
  @SerializedName("content_requirements_description")
  private String mContentRequirementsDescription = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("deal_negotiation_type")
  private String mDealNegotiationType = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("has_free_product")
  private Boolean mHasFreeProduct = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("payment_amount_for_ads")
  private Long mPaymentAmountForAds = null;
  @SerializedName("payment_amount_for_content")
  private Long mPaymentAmountForContent = null;
  @SerializedName("payment_description")
  private String mPaymentDescription = null;
  protected static Gson gson = null;

  BCPCampaign() {
  }

  public BCPCampaign(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BCPCampaign(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BCPCampaign fetch() throws APIException{
    BCPCampaign newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BCPCampaign fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BCPCampaign> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BCPCampaign fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BCPCampaign> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BCPCampaign> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BCPCampaign>)(
      new APIRequest<BCPCampaign>(context, "", "/", "GET", BCPCampaign.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BCPCampaign>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BCPCampaign.getParser())
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
  public static BCPCampaign loadJSON(String json, APIContext context, String header) {
    BCPCampaign bcpCampaign = getGson().fromJson(json, BCPCampaign.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(bcpCampaign.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    bcpCampaign.context = context;
    bcpCampaign.rawValue = json;
    bcpCampaign.header = header;
    return bcpCampaign;
  }

  public static APINodeList<BCPCampaign> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BCPCampaign> bcpCampaigns = new APINodeList<BCPCampaign>(request, json, header);
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
          bcpCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return bcpCampaigns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                bcpCampaigns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            bcpCampaigns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              bcpCampaigns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              bcpCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  bcpCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              bcpCampaigns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return bcpCampaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              bcpCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return bcpCampaigns;
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
              bcpCampaigns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return bcpCampaigns;
          }

          // Sixth, check if it's pure JsonObject
          bcpCampaigns.clear();
          bcpCampaigns.add(loadJSON(json, context, header));
          return bcpCampaigns;
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


  public Boolean getFieldAdsPermissionRequired() {
    return mAdsPermissionRequired;
  }

  public String getFieldApplicationDeadline() {
    return mApplicationDeadline;
  }

  public String getFieldCampaignGoal() {
    return mCampaignGoal;
  }

  public String getFieldCampaignGoalOther() {
    return mCampaignGoalOther;
  }

  public String getFieldContentDeliveryDeadline() {
    return mContentDeliveryDeadline;
  }

  public String getFieldContentDeliveryStartDate() {
    return mContentDeliveryStartDate;
  }

  public List<Map<String, Long>> getFieldContentRequirements() {
    return mContentRequirements;
  }

  public String getFieldContentRequirementsDescription() {
    return mContentRequirementsDescription;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDealNegotiationType() {
    return mDealNegotiationType;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Boolean getFieldHasFreeProduct() {
    return mHasFreeProduct;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldPaymentAmountForAds() {
    return mPaymentAmountForAds;
  }

  public Long getFieldPaymentAmountForContent() {
    return mPaymentAmountForContent;
  }

  public String getFieldPaymentDescription() {
    return mPaymentDescription;
  }



  public static class APIRequestGet extends APIRequest<BCPCampaign> {

    BCPCampaign lastResponse = null;
    @Override
    public BCPCampaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ads_permission_required",
      "application_deadline",
      "campaign_goal",
      "campaign_goal_other",
      "content_delivery_deadline",
      "content_delivery_start_date",
      "content_requirements",
      "content_requirements_description",
      "currency",
      "deal_negotiation_type",
      "description",
      "has_free_product",
      "id",
      "name",
      "payment_amount_for_ads",
      "payment_amount_for_content",
      "payment_description",
    };

    @Override
    public BCPCampaign parseResponse(String response, String header) throws APIException {
      return BCPCampaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BCPCampaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BCPCampaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BCPCampaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BCPCampaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BCPCampaign>() {
           public BCPCampaign apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdsPermissionRequiredField () {
      return this.requestAdsPermissionRequiredField(true);
    }
    public APIRequestGet requestAdsPermissionRequiredField (boolean value) {
      this.requestField("ads_permission_required", value);
      return this;
    }
    public APIRequestGet requestApplicationDeadlineField () {
      return this.requestApplicationDeadlineField(true);
    }
    public APIRequestGet requestApplicationDeadlineField (boolean value) {
      this.requestField("application_deadline", value);
      return this;
    }
    public APIRequestGet requestCampaignGoalField () {
      return this.requestCampaignGoalField(true);
    }
    public APIRequestGet requestCampaignGoalField (boolean value) {
      this.requestField("campaign_goal", value);
      return this;
    }
    public APIRequestGet requestCampaignGoalOtherField () {
      return this.requestCampaignGoalOtherField(true);
    }
    public APIRequestGet requestCampaignGoalOtherField (boolean value) {
      this.requestField("campaign_goal_other", value);
      return this;
    }
    public APIRequestGet requestContentDeliveryDeadlineField () {
      return this.requestContentDeliveryDeadlineField(true);
    }
    public APIRequestGet requestContentDeliveryDeadlineField (boolean value) {
      this.requestField("content_delivery_deadline", value);
      return this;
    }
    public APIRequestGet requestContentDeliveryStartDateField () {
      return this.requestContentDeliveryStartDateField(true);
    }
    public APIRequestGet requestContentDeliveryStartDateField (boolean value) {
      this.requestField("content_delivery_start_date", value);
      return this;
    }
    public APIRequestGet requestContentRequirementsField () {
      return this.requestContentRequirementsField(true);
    }
    public APIRequestGet requestContentRequirementsField (boolean value) {
      this.requestField("content_requirements", value);
      return this;
    }
    public APIRequestGet requestContentRequirementsDescriptionField () {
      return this.requestContentRequirementsDescriptionField(true);
    }
    public APIRequestGet requestContentRequirementsDescriptionField (boolean value) {
      this.requestField("content_requirements_description", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDealNegotiationTypeField () {
      return this.requestDealNegotiationTypeField(true);
    }
    public APIRequestGet requestDealNegotiationTypeField (boolean value) {
      this.requestField("deal_negotiation_type", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestHasFreeProductField () {
      return this.requestHasFreeProductField(true);
    }
    public APIRequestGet requestHasFreeProductField (boolean value) {
      this.requestField("has_free_product", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPaymentAmountForAdsField () {
      return this.requestPaymentAmountForAdsField(true);
    }
    public APIRequestGet requestPaymentAmountForAdsField (boolean value) {
      this.requestField("payment_amount_for_ads", value);
      return this;
    }
    public APIRequestGet requestPaymentAmountForContentField () {
      return this.requestPaymentAmountForContentField(true);
    }
    public APIRequestGet requestPaymentAmountForContentField (boolean value) {
      this.requestField("payment_amount_for_content", value);
      return this;
    }
    public APIRequestGet requestPaymentDescriptionField () {
      return this.requestPaymentDescriptionField(true);
    }
    public APIRequestGet requestPaymentDescriptionField (boolean value) {
      this.requestField("payment_description", value);
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

  public BCPCampaign copyFrom(BCPCampaign instance) {
    this.mAdsPermissionRequired = instance.mAdsPermissionRequired;
    this.mApplicationDeadline = instance.mApplicationDeadline;
    this.mCampaignGoal = instance.mCampaignGoal;
    this.mCampaignGoalOther = instance.mCampaignGoalOther;
    this.mContentDeliveryDeadline = instance.mContentDeliveryDeadline;
    this.mContentDeliveryStartDate = instance.mContentDeliveryStartDate;
    this.mContentRequirements = instance.mContentRequirements;
    this.mContentRequirementsDescription = instance.mContentRequirementsDescription;
    this.mCurrency = instance.mCurrency;
    this.mDealNegotiationType = instance.mDealNegotiationType;
    this.mDescription = instance.mDescription;
    this.mHasFreeProduct = instance.mHasFreeProduct;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPaymentAmountForAds = instance.mPaymentAmountForAds;
    this.mPaymentAmountForContent = instance.mPaymentAmountForContent;
    this.mPaymentDescription = instance.mPaymentDescription;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BCPCampaign> getParser() {
    return new APIRequest.ResponseParser<BCPCampaign>() {
      public APINodeList<BCPCampaign> parseResponse(String response, APIContext context, APIRequest<BCPCampaign> request, String header) throws MalformedResponseException {
        return BCPCampaign.parseResponse(response, context, request, header);
      }
    };
  }
}
