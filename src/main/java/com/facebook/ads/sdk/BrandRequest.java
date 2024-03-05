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
public class BrandRequest extends APINode {
  @SerializedName("ad_countries")
  private List<String> mAdCountries = null;
  @SerializedName("additional_contacts")
  private List<String> mAdditionalContacts = null;
  @SerializedName("approval_level")
  private Long mApprovalLevel = null;
  @SerializedName("cells")
  private List<Object> mCells = null;
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("deny_reason")
  private String mDenyReason = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("estimated_reach")
  private Long mEstimatedReach = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_multicell")
  private Boolean mIsMulticell = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("max_age")
  private Long mMaxAge = null;
  @SerializedName("min_age")
  private Long mMinAge = null;
  @SerializedName("questions")
  private List<Object> mQuestions = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("request_status")
  private String mRequestStatus = null;
  @SerializedName("review_date")
  private String mReviewDate = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("submit_date")
  private String mSubmitDate = null;
  @SerializedName("total_budget")
  private Long mTotalBudget = null;
  protected static Gson gson = null;

  BrandRequest() {
  }

  public BrandRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BrandRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BrandRequest fetch() throws APIException{
    BrandRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BrandRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BrandRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BrandRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BrandRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BrandRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BrandRequest>)(
      new APIRequest<BrandRequest>(context, "", "/", "GET", BrandRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BrandRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BrandRequest.getParser())
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
  public static BrandRequest loadJSON(String json, APIContext context, String header) {
    BrandRequest brandRequest = getGson().fromJson(json, BrandRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(brandRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    brandRequest.context = context;
    brandRequest.rawValue = json;
    brandRequest.header = header;
    return brandRequest;
  }

  public static APINodeList<BrandRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BrandRequest> brandRequests = new APINodeList<BrandRequest>(request, json, header);
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
          brandRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return brandRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                brandRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            brandRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              brandRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              brandRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  brandRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              brandRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return brandRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              brandRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return brandRequests;
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
              brandRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return brandRequests;
          }

          // Sixth, check if it's pure JsonObject
          brandRequests.clear();
          brandRequests.add(loadJSON(json, context, header));
          return brandRequests;
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


  public List<String> getFieldAdCountries() {
    return mAdCountries;
  }

  public List<String> getFieldAdditionalContacts() {
    return mAdditionalContacts;
  }

  public Long getFieldApprovalLevel() {
    return mApprovalLevel;
  }

  public List<Object> getFieldCells() {
    return mCells;
  }

  public List<String> getFieldCountries() {
    return mCountries;
  }

  public String getFieldDenyReason() {
    return mDenyReason;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public Long getFieldEstimatedReach() {
    return mEstimatedReach;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsMulticell() {
    return mIsMulticell;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public Long getFieldMaxAge() {
    return mMaxAge;
  }

  public Long getFieldMinAge() {
    return mMinAge;
  }

  public List<Object> getFieldQuestions() {
    return mQuestions;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public String getFieldRequestStatus() {
    return mRequestStatus;
  }

  public String getFieldReviewDate() {
    return mReviewDate;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldSubmitDate() {
    return mSubmitDate;
  }

  public Long getFieldTotalBudget() {
    return mTotalBudget;
  }



  public static class APIRequestGet extends APIRequest<BrandRequest> {

    BrandRequest lastResponse = null;
    @Override
    public BrandRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_countries",
      "additional_contacts",
      "approval_level",
      "cells",
      "countries",
      "deny_reason",
      "end_time",
      "estimated_reach",
      "id",
      "is_multicell",
      "locale",
      "max_age",
      "min_age",
      "questions",
      "region",
      "request_status",
      "review_date",
      "start_time",
      "status",
      "submit_date",
      "total_budget",
    };

    @Override
    public BrandRequest parseResponse(String response, String header) throws APIException {
      return BrandRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BrandRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BrandRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BrandRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BrandRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BrandRequest>() {
           public BrandRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdCountriesField () {
      return this.requestAdCountriesField(true);
    }
    public APIRequestGet requestAdCountriesField (boolean value) {
      this.requestField("ad_countries", value);
      return this;
    }
    public APIRequestGet requestAdditionalContactsField () {
      return this.requestAdditionalContactsField(true);
    }
    public APIRequestGet requestAdditionalContactsField (boolean value) {
      this.requestField("additional_contacts", value);
      return this;
    }
    public APIRequestGet requestApprovalLevelField () {
      return this.requestApprovalLevelField(true);
    }
    public APIRequestGet requestApprovalLevelField (boolean value) {
      this.requestField("approval_level", value);
      return this;
    }
    public APIRequestGet requestCellsField () {
      return this.requestCellsField(true);
    }
    public APIRequestGet requestCellsField (boolean value) {
      this.requestField("cells", value);
      return this;
    }
    public APIRequestGet requestCountriesField () {
      return this.requestCountriesField(true);
    }
    public APIRequestGet requestCountriesField (boolean value) {
      this.requestField("countries", value);
      return this;
    }
    public APIRequestGet requestDenyReasonField () {
      return this.requestDenyReasonField(true);
    }
    public APIRequestGet requestDenyReasonField (boolean value) {
      this.requestField("deny_reason", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestEstimatedReachField () {
      return this.requestEstimatedReachField(true);
    }
    public APIRequestGet requestEstimatedReachField (boolean value) {
      this.requestField("estimated_reach", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsMulticellField () {
      return this.requestIsMulticellField(true);
    }
    public APIRequestGet requestIsMulticellField (boolean value) {
      this.requestField("is_multicell", value);
      return this;
    }
    public APIRequestGet requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGet requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGet requestMaxAgeField () {
      return this.requestMaxAgeField(true);
    }
    public APIRequestGet requestMaxAgeField (boolean value) {
      this.requestField("max_age", value);
      return this;
    }
    public APIRequestGet requestMinAgeField () {
      return this.requestMinAgeField(true);
    }
    public APIRequestGet requestMinAgeField (boolean value) {
      this.requestField("min_age", value);
      return this;
    }
    public APIRequestGet requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGet requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGet requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGet requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGet requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGet requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGet requestReviewDateField () {
      return this.requestReviewDateField(true);
    }
    public APIRequestGet requestReviewDateField (boolean value) {
      this.requestField("review_date", value);
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
    public APIRequestGet requestSubmitDateField () {
      return this.requestSubmitDateField(true);
    }
    public APIRequestGet requestSubmitDateField (boolean value) {
      this.requestField("submit_date", value);
      return this;
    }
    public APIRequestGet requestTotalBudgetField () {
      return this.requestTotalBudgetField(true);
    }
    public APIRequestGet requestTotalBudgetField (boolean value) {
      this.requestField("total_budget", value);
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

  public BrandRequest copyFrom(BrandRequest instance) {
    this.mAdCountries = instance.mAdCountries;
    this.mAdditionalContacts = instance.mAdditionalContacts;
    this.mApprovalLevel = instance.mApprovalLevel;
    this.mCells = instance.mCells;
    this.mCountries = instance.mCountries;
    this.mDenyReason = instance.mDenyReason;
    this.mEndTime = instance.mEndTime;
    this.mEstimatedReach = instance.mEstimatedReach;
    this.mId = instance.mId;
    this.mIsMulticell = instance.mIsMulticell;
    this.mLocale = instance.mLocale;
    this.mMaxAge = instance.mMaxAge;
    this.mMinAge = instance.mMinAge;
    this.mQuestions = instance.mQuestions;
    this.mRegion = instance.mRegion;
    this.mRequestStatus = instance.mRequestStatus;
    this.mReviewDate = instance.mReviewDate;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mSubmitDate = instance.mSubmitDate;
    this.mTotalBudget = instance.mTotalBudget;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BrandRequest> getParser() {
    return new APIRequest.ResponseParser<BrandRequest>() {
      public APINodeList<BrandRequest> parseResponse(String response, APIContext context, APIRequest<BrandRequest> request, String header) throws MalformedResponseException {
        return BrandRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
