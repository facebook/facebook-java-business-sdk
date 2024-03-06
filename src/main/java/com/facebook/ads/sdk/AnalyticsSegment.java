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
public class AnalyticsSegment extends APINode {
  @SerializedName("custom_audience_ineligiblity_reasons")
  private List<String> mCustomAudienceIneligiblityReasons = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("estimated_custom_audience_size")
  private Long mEstimatedCustomAudienceSize = null;
  @SerializedName("event_info_rules")
  private List<Object> mEventInfoRules = null;
  @SerializedName("event_rules")
  private List<Object> mEventRules = null;
  @SerializedName("filter_set")
  private String mFilterSet = null;
  @SerializedName("has_demographic_rules")
  private Boolean mHasDemographicRules = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_all_user")
  private Boolean mIsAllUser = null;
  @SerializedName("is_eligible_for_push_campaign")
  private Boolean mIsEligibleForPushCampaign = null;
  @SerializedName("is_internal")
  private Boolean mIsInternal = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("percentile_rules")
  private List<Object> mPercentileRules = null;
  @SerializedName("time_last_seen")
  private Long mTimeLastSeen = null;
  @SerializedName("time_last_updated")
  private Long mTimeLastUpdated = null;
  @SerializedName("user_property_rules")
  private List<Object> mUserPropertyRules = null;
  @SerializedName("web_param_rules")
  private List<Object> mWebParamRules = null;
  protected static Gson gson = null;

  AnalyticsSegment() {
  }

  public AnalyticsSegment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AnalyticsSegment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AnalyticsSegment fetch() throws APIException{
    AnalyticsSegment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AnalyticsSegment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AnalyticsSegment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AnalyticsSegment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AnalyticsSegment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AnalyticsSegment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AnalyticsSegment>)(
      new APIRequest<AnalyticsSegment>(context, "", "/", "GET", AnalyticsSegment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AnalyticsSegment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AnalyticsSegment.getParser())
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
  public static AnalyticsSegment loadJSON(String json, APIContext context, String header) {
    AnalyticsSegment analyticsSegment = getGson().fromJson(json, AnalyticsSegment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(analyticsSegment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    analyticsSegment.context = context;
    analyticsSegment.rawValue = json;
    analyticsSegment.header = header;
    return analyticsSegment;
  }

  public static APINodeList<AnalyticsSegment> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AnalyticsSegment> analyticsSegments = new APINodeList<AnalyticsSegment>(request, json, header);
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
          analyticsSegments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return analyticsSegments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                analyticsSegments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            analyticsSegments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              analyticsSegments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              analyticsSegments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  analyticsSegments.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              analyticsSegments.add(loadJSON(obj.toString(), context, header));
            }
          }
          return analyticsSegments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              analyticsSegments.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return analyticsSegments;
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
              analyticsSegments.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return analyticsSegments;
          }

          // Sixth, check if it's pure JsonObject
          analyticsSegments.clear();
          analyticsSegments.add(loadJSON(json, context, header));
          return analyticsSegments;
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


  public List<String> getFieldCustomAudienceIneligiblityReasons() {
    return mCustomAudienceIneligiblityReasons;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Long getFieldEstimatedCustomAudienceSize() {
    return mEstimatedCustomAudienceSize;
  }

  public List<Object> getFieldEventInfoRules() {
    return mEventInfoRules;
  }

  public List<Object> getFieldEventRules() {
    return mEventRules;
  }

  public String getFieldFilterSet() {
    return mFilterSet;
  }

  public Boolean getFieldHasDemographicRules() {
    return mHasDemographicRules;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAllUser() {
    return mIsAllUser;
  }

  public Boolean getFieldIsEligibleForPushCampaign() {
    return mIsEligibleForPushCampaign;
  }

  public Boolean getFieldIsInternal() {
    return mIsInternal;
  }

  public String getFieldName() {
    return mName;
  }

  public List<Object> getFieldPercentileRules() {
    return mPercentileRules;
  }

  public Long getFieldTimeLastSeen() {
    return mTimeLastSeen;
  }

  public Long getFieldTimeLastUpdated() {
    return mTimeLastUpdated;
  }

  public List<Object> getFieldUserPropertyRules() {
    return mUserPropertyRules;
  }

  public List<Object> getFieldWebParamRules() {
    return mWebParamRules;
  }



  public static class APIRequestGet extends APIRequest<AnalyticsSegment> {

    AnalyticsSegment lastResponse = null;
    @Override
    public AnalyticsSegment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "async_task_id",
      "end_date",
      "start_date",
    };

    public static final String[] FIELDS = {
      "custom_audience_ineligiblity_reasons",
      "description",
      "estimated_custom_audience_size",
      "event_info_rules",
      "event_rules",
      "filter_set",
      "has_demographic_rules",
      "id",
      "is_all_user",
      "is_eligible_for_push_campaign",
      "is_internal",
      "name",
      "percentile_rules",
      "time_last_seen",
      "time_last_updated",
      "user_property_rules",
      "web_param_rules",
    };

    @Override
    public AnalyticsSegment parseResponse(String response, String header) throws APIException {
      return AnalyticsSegment.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AnalyticsSegment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AnalyticsSegment execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AnalyticsSegment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AnalyticsSegment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AnalyticsSegment>() {
           public AnalyticsSegment apply(ResponseWrapper result) {
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


    public APIRequestGet setAsyncTaskId (String asyncTaskId) {
      this.setParam("async_task_id", asyncTaskId);
      return this;
    }

    public APIRequestGet setEndDate (Long endDate) {
      this.setParam("end_date", endDate);
      return this;
    }
    public APIRequestGet setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGet setStartDate (Long startDate) {
      this.setParam("start_date", startDate);
      return this;
    }
    public APIRequestGet setStartDate (String startDate) {
      this.setParam("start_date", startDate);
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

    public APIRequestGet requestCustomAudienceIneligiblityReasonsField () {
      return this.requestCustomAudienceIneligiblityReasonsField(true);
    }
    public APIRequestGet requestCustomAudienceIneligiblityReasonsField (boolean value) {
      this.requestField("custom_audience_ineligiblity_reasons", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEstimatedCustomAudienceSizeField () {
      return this.requestEstimatedCustomAudienceSizeField(true);
    }
    public APIRequestGet requestEstimatedCustomAudienceSizeField (boolean value) {
      this.requestField("estimated_custom_audience_size", value);
      return this;
    }
    public APIRequestGet requestEventInfoRulesField () {
      return this.requestEventInfoRulesField(true);
    }
    public APIRequestGet requestEventInfoRulesField (boolean value) {
      this.requestField("event_info_rules", value);
      return this;
    }
    public APIRequestGet requestEventRulesField () {
      return this.requestEventRulesField(true);
    }
    public APIRequestGet requestEventRulesField (boolean value) {
      this.requestField("event_rules", value);
      return this;
    }
    public APIRequestGet requestFilterSetField () {
      return this.requestFilterSetField(true);
    }
    public APIRequestGet requestFilterSetField (boolean value) {
      this.requestField("filter_set", value);
      return this;
    }
    public APIRequestGet requestHasDemographicRulesField () {
      return this.requestHasDemographicRulesField(true);
    }
    public APIRequestGet requestHasDemographicRulesField (boolean value) {
      this.requestField("has_demographic_rules", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAllUserField () {
      return this.requestIsAllUserField(true);
    }
    public APIRequestGet requestIsAllUserField (boolean value) {
      this.requestField("is_all_user", value);
      return this;
    }
    public APIRequestGet requestIsEligibleForPushCampaignField () {
      return this.requestIsEligibleForPushCampaignField(true);
    }
    public APIRequestGet requestIsEligibleForPushCampaignField (boolean value) {
      this.requestField("is_eligible_for_push_campaign", value);
      return this;
    }
    public APIRequestGet requestIsInternalField () {
      return this.requestIsInternalField(true);
    }
    public APIRequestGet requestIsInternalField (boolean value) {
      this.requestField("is_internal", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPercentileRulesField () {
      return this.requestPercentileRulesField(true);
    }
    public APIRequestGet requestPercentileRulesField (boolean value) {
      this.requestField("percentile_rules", value);
      return this;
    }
    public APIRequestGet requestTimeLastSeenField () {
      return this.requestTimeLastSeenField(true);
    }
    public APIRequestGet requestTimeLastSeenField (boolean value) {
      this.requestField("time_last_seen", value);
      return this;
    }
    public APIRequestGet requestTimeLastUpdatedField () {
      return this.requestTimeLastUpdatedField(true);
    }
    public APIRequestGet requestTimeLastUpdatedField (boolean value) {
      this.requestField("time_last_updated", value);
      return this;
    }
    public APIRequestGet requestUserPropertyRulesField () {
      return this.requestUserPropertyRulesField(true);
    }
    public APIRequestGet requestUserPropertyRulesField (boolean value) {
      this.requestField("user_property_rules", value);
      return this;
    }
    public APIRequestGet requestWebParamRulesField () {
      return this.requestWebParamRulesField(true);
    }
    public APIRequestGet requestWebParamRulesField (boolean value) {
      this.requestField("web_param_rules", value);
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

  public AnalyticsSegment copyFrom(AnalyticsSegment instance) {
    this.mCustomAudienceIneligiblityReasons = instance.mCustomAudienceIneligiblityReasons;
    this.mDescription = instance.mDescription;
    this.mEstimatedCustomAudienceSize = instance.mEstimatedCustomAudienceSize;
    this.mEventInfoRules = instance.mEventInfoRules;
    this.mEventRules = instance.mEventRules;
    this.mFilterSet = instance.mFilterSet;
    this.mHasDemographicRules = instance.mHasDemographicRules;
    this.mId = instance.mId;
    this.mIsAllUser = instance.mIsAllUser;
    this.mIsEligibleForPushCampaign = instance.mIsEligibleForPushCampaign;
    this.mIsInternal = instance.mIsInternal;
    this.mName = instance.mName;
    this.mPercentileRules = instance.mPercentileRules;
    this.mTimeLastSeen = instance.mTimeLastSeen;
    this.mTimeLastUpdated = instance.mTimeLastUpdated;
    this.mUserPropertyRules = instance.mUserPropertyRules;
    this.mWebParamRules = instance.mWebParamRules;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AnalyticsSegment> getParser() {
    return new APIRequest.ResponseParser<AnalyticsSegment>() {
      public APINodeList<AnalyticsSegment> parseResponse(String response, APIContext context, APIRequest<AnalyticsSegment> request, String header) throws MalformedResponseException {
        return AnalyticsSegment.parseResponse(response, context, request, header);
      }
    };
  }
}
