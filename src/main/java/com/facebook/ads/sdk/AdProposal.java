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
public class AdProposal extends APINode {
  @SerializedName("ad_proposal_type_name")
  private String mAdProposalTypeName = null;
  @SerializedName("adaccount")
  private AdAccount mAdaccount = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("delivery_interface")
  private String mDeliveryInterface = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("has_conflict")
  private Boolean mHasConflict = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("kpi_metric")
  private String mKpiMetric = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("proposal_dts_template")
  private String mProposalDtsTemplate = null;
  @SerializedName("proposal_template_name")
  private String mProposalTemplateName = null;
  @SerializedName("recommendation")
  private String mRecommendation = null;
  @SerializedName("review_time")
  private String mReviewTime = null;
  @SerializedName("reviewed_by")
  private User mReviewedBy = null;
  @SerializedName("send_time")
  private String mSendTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("use_testing")
  private Boolean mUseTesting = null;
  protected static Gson gson = null;

  AdProposal() {
  }

  public AdProposal(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdProposal(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdProposal fetch() throws APIException{
    AdProposal newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdProposal fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdProposal> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdProposal fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdProposal> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdProposal> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdProposal>)(
      new APIRequest<AdProposal>(context, "", "/", "GET", AdProposal.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdProposal>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdProposal.getParser())
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
  public static AdProposal loadJSON(String json, APIContext context, String header) {
    AdProposal adProposal = getGson().fromJson(json, AdProposal.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adProposal.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adProposal.context = context;
    adProposal.rawValue = json;
    adProposal.header = header;
    return adProposal;
  }

  public static APINodeList<AdProposal> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdProposal> adProposals = new APINodeList<AdProposal>(request, json, header);
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
          adProposals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adProposals;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adProposals.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adProposals.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adProposals.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adProposals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adProposals.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adProposals.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adProposals;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adProposals.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adProposals;
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
              adProposals.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adProposals;
          }

          // Sixth, check if it's pure JsonObject
          adProposals.clear();
          adProposals.add(loadJSON(json, context, header));
          return adProposals;
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


  public String getFieldAdProposalTypeName() {
    return mAdProposalTypeName;
  }

  public AdAccount getFieldAdaccount() {
    if (mAdaccount != null) {
      mAdaccount.context = getContext();
    }
    return mAdaccount;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldDeliveryInterface() {
    return mDeliveryInterface;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public Boolean getFieldHasConflict() {
    return mHasConflict;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldKpiMetric() {
    return mKpiMetric;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldProposalDtsTemplate() {
    return mProposalDtsTemplate;
  }

  public String getFieldProposalTemplateName() {
    return mProposalTemplateName;
  }

  public String getFieldRecommendation() {
    return mRecommendation;
  }

  public String getFieldReviewTime() {
    return mReviewTime;
  }

  public User getFieldReviewedBy() {
    if (mReviewedBy != null) {
      mReviewedBy.context = getContext();
    }
    return mReviewedBy;
  }

  public String getFieldSendTime() {
    return mSendTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Boolean getFieldUseTesting() {
    return mUseTesting;
  }



  public static class APIRequestGet extends APIRequest<AdProposal> {

    AdProposal lastResponse = null;
    @Override
    public AdProposal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_proposal_type_name",
      "adaccount",
      "creation_time",
      "creator",
      "delivery_interface",
      "expiration_time",
      "has_conflict",
      "id",
      "kpi_metric",
      "message",
      "name",
      "proposal_dts_template",
      "proposal_template_name",
      "recommendation",
      "review_time",
      "reviewed_by",
      "send_time",
      "status",
      "use_testing",
    };

    @Override
    public AdProposal parseResponse(String response, String header) throws APIException {
      return AdProposal.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdProposal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdProposal execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdProposal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdProposal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdProposal>() {
           public AdProposal apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdProposalTypeNameField () {
      return this.requestAdProposalTypeNameField(true);
    }
    public APIRequestGet requestAdProposalTypeNameField (boolean value) {
      this.requestField("ad_proposal_type_name", value);
      return this;
    }
    public APIRequestGet requestAdaccountField () {
      return this.requestAdaccountField(true);
    }
    public APIRequestGet requestAdaccountField (boolean value) {
      this.requestField("adaccount", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestDeliveryInterfaceField () {
      return this.requestDeliveryInterfaceField(true);
    }
    public APIRequestGet requestDeliveryInterfaceField (boolean value) {
      this.requestField("delivery_interface", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestHasConflictField () {
      return this.requestHasConflictField(true);
    }
    public APIRequestGet requestHasConflictField (boolean value) {
      this.requestField("has_conflict", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestKpiMetricField () {
      return this.requestKpiMetricField(true);
    }
    public APIRequestGet requestKpiMetricField (boolean value) {
      this.requestField("kpi_metric", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProposalDtsTemplateField () {
      return this.requestProposalDtsTemplateField(true);
    }
    public APIRequestGet requestProposalDtsTemplateField (boolean value) {
      this.requestField("proposal_dts_template", value);
      return this;
    }
    public APIRequestGet requestProposalTemplateNameField () {
      return this.requestProposalTemplateNameField(true);
    }
    public APIRequestGet requestProposalTemplateNameField (boolean value) {
      this.requestField("proposal_template_name", value);
      return this;
    }
    public APIRequestGet requestRecommendationField () {
      return this.requestRecommendationField(true);
    }
    public APIRequestGet requestRecommendationField (boolean value) {
      this.requestField("recommendation", value);
      return this;
    }
    public APIRequestGet requestReviewTimeField () {
      return this.requestReviewTimeField(true);
    }
    public APIRequestGet requestReviewTimeField (boolean value) {
      this.requestField("review_time", value);
      return this;
    }
    public APIRequestGet requestReviewedByField () {
      return this.requestReviewedByField(true);
    }
    public APIRequestGet requestReviewedByField (boolean value) {
      this.requestField("reviewed_by", value);
      return this;
    }
    public APIRequestGet requestSendTimeField () {
      return this.requestSendTimeField(true);
    }
    public APIRequestGet requestSendTimeField (boolean value) {
      this.requestField("send_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUseTestingField () {
      return this.requestUseTestingField(true);
    }
    public APIRequestGet requestUseTestingField (boolean value) {
      this.requestField("use_testing", value);
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

  public AdProposal copyFrom(AdProposal instance) {
    this.mAdProposalTypeName = instance.mAdProposalTypeName;
    this.mAdaccount = instance.mAdaccount;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mDeliveryInterface = instance.mDeliveryInterface;
    this.mExpirationTime = instance.mExpirationTime;
    this.mHasConflict = instance.mHasConflict;
    this.mId = instance.mId;
    this.mKpiMetric = instance.mKpiMetric;
    this.mMessage = instance.mMessage;
    this.mName = instance.mName;
    this.mProposalDtsTemplate = instance.mProposalDtsTemplate;
    this.mProposalTemplateName = instance.mProposalTemplateName;
    this.mRecommendation = instance.mRecommendation;
    this.mReviewTime = instance.mReviewTime;
    this.mReviewedBy = instance.mReviewedBy;
    this.mSendTime = instance.mSendTime;
    this.mStatus = instance.mStatus;
    this.mUseTesting = instance.mUseTesting;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdProposal> getParser() {
    return new APIRequest.ResponseParser<AdProposal>() {
      public APINodeList<AdProposal> parseResponse(String response, APIContext context, APIRequest<AdProposal> request, String header) throws MalformedResponseException {
        return AdProposal.parseResponse(response, context, request, header);
      }
    };
  }
}
