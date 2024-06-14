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
public class NegativeKeywordList extends APINode {
  @SerializedName("applied_active_ad_campaign_groups")
  private List<Map<String, String>> mAppliedActiveAdCampaignGroups = null;
  @SerializedName("applied_inactive_ad_campaign_groups")
  private List<Map<String, String>> mAppliedInactiveAdCampaignGroups = null;
  @SerializedName("creator_id")
  private String mCreatorId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_fully_reviewed")
  private Boolean mIsFullyReviewed = null;
  @SerializedName("last_update_time")
  private String mLastUpdateTime = null;
  @SerializedName("last_update_user_id")
  private String mLastUpdateUserId = null;
  @SerializedName("list_name")
  private String mListName = null;
  @SerializedName("total_approved_keyword_count")
  private Long mTotalApprovedKeywordCount = null;
  @SerializedName("total_declined_keyword_count")
  private Long mTotalDeclinedKeywordCount = null;
  @SerializedName("total_negative_keyword_count")
  private Long mTotalNegativeKeywordCount = null;
  @SerializedName("total_validated_keyword_count")
  private Long mTotalValidatedKeywordCount = null;
  protected static Gson gson = null;

  NegativeKeywordList() {
  }

  public NegativeKeywordList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public NegativeKeywordList(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public NegativeKeywordList fetch() throws APIException{
    NegativeKeywordList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static NegativeKeywordList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<NegativeKeywordList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static NegativeKeywordList fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<NegativeKeywordList> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<NegativeKeywordList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<NegativeKeywordList>)(
      new APIRequest<NegativeKeywordList>(context, "", "/", "GET", NegativeKeywordList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<NegativeKeywordList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", NegativeKeywordList.getParser())
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
  public static NegativeKeywordList loadJSON(String json, APIContext context, String header) {
    NegativeKeywordList negativeKeywordList = getGson().fromJson(json, NegativeKeywordList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(negativeKeywordList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    negativeKeywordList.context = context;
    negativeKeywordList.rawValue = json;
    negativeKeywordList.header = header;
    return negativeKeywordList;
  }

  public static APINodeList<NegativeKeywordList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<NegativeKeywordList> negativeKeywordLists = new APINodeList<NegativeKeywordList>(request, json, header);
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
          negativeKeywordLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return negativeKeywordLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                negativeKeywordLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            negativeKeywordLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              negativeKeywordLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              negativeKeywordLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  negativeKeywordLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              negativeKeywordLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return negativeKeywordLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              negativeKeywordLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return negativeKeywordLists;
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
              negativeKeywordLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return negativeKeywordLists;
          }

          // Sixth, check if it's pure JsonObject
          negativeKeywordLists.clear();
          negativeKeywordLists.add(loadJSON(json, context, header));
          return negativeKeywordLists;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<Map<String, String>> getFieldAppliedActiveAdCampaignGroups() {
    return mAppliedActiveAdCampaignGroups;
  }

  public List<Map<String, String>> getFieldAppliedInactiveAdCampaignGroups() {
    return mAppliedInactiveAdCampaignGroups;
  }

  public String getFieldCreatorId() {
    return mCreatorId;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsFullyReviewed() {
    return mIsFullyReviewed;
  }

  public String getFieldLastUpdateTime() {
    return mLastUpdateTime;
  }

  public String getFieldLastUpdateUserId() {
    return mLastUpdateUserId;
  }

  public String getFieldListName() {
    return mListName;
  }

  public Long getFieldTotalApprovedKeywordCount() {
    return mTotalApprovedKeywordCount;
  }

  public Long getFieldTotalDeclinedKeywordCount() {
    return mTotalDeclinedKeywordCount;
  }

  public Long getFieldTotalNegativeKeywordCount() {
    return mTotalNegativeKeywordCount;
  }

  public Long getFieldTotalValidatedKeywordCount() {
    return mTotalValidatedKeywordCount;
  }



  public static class APIRequestGet extends APIRequest<NegativeKeywordList> {

    NegativeKeywordList lastResponse = null;
    @Override
    public NegativeKeywordList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applied_active_ad_campaign_groups",
      "applied_inactive_ad_campaign_groups",
      "creator_id",
      "id",
      "is_fully_reviewed",
      "last_update_time",
      "last_update_user_id",
      "list_name",
      "total_approved_keyword_count",
      "total_declined_keyword_count",
      "total_negative_keyword_count",
      "total_validated_keyword_count",
    };

    @Override
    public NegativeKeywordList parseResponse(String response, String header) throws APIException {
      return NegativeKeywordList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NegativeKeywordList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NegativeKeywordList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NegativeKeywordList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NegativeKeywordList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NegativeKeywordList>() {
           public NegativeKeywordList apply(ResponseWrapper result) {
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

    public APIRequestGet requestAppliedActiveAdCampaignGroupsField () {
      return this.requestAppliedActiveAdCampaignGroupsField(true);
    }
    public APIRequestGet requestAppliedActiveAdCampaignGroupsField (boolean value) {
      this.requestField("applied_active_ad_campaign_groups", value);
      return this;
    }
    public APIRequestGet requestAppliedInactiveAdCampaignGroupsField () {
      return this.requestAppliedInactiveAdCampaignGroupsField(true);
    }
    public APIRequestGet requestAppliedInactiveAdCampaignGroupsField (boolean value) {
      this.requestField("applied_inactive_ad_campaign_groups", value);
      return this;
    }
    public APIRequestGet requestCreatorIdField () {
      return this.requestCreatorIdField(true);
    }
    public APIRequestGet requestCreatorIdField (boolean value) {
      this.requestField("creator_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsFullyReviewedField () {
      return this.requestIsFullyReviewedField(true);
    }
    public APIRequestGet requestIsFullyReviewedField (boolean value) {
      this.requestField("is_fully_reviewed", value);
      return this;
    }
    public APIRequestGet requestLastUpdateTimeField () {
      return this.requestLastUpdateTimeField(true);
    }
    public APIRequestGet requestLastUpdateTimeField (boolean value) {
      this.requestField("last_update_time", value);
      return this;
    }
    public APIRequestGet requestLastUpdateUserIdField () {
      return this.requestLastUpdateUserIdField(true);
    }
    public APIRequestGet requestLastUpdateUserIdField (boolean value) {
      this.requestField("last_update_user_id", value);
      return this;
    }
    public APIRequestGet requestListNameField () {
      return this.requestListNameField(true);
    }
    public APIRequestGet requestListNameField (boolean value) {
      this.requestField("list_name", value);
      return this;
    }
    public APIRequestGet requestTotalApprovedKeywordCountField () {
      return this.requestTotalApprovedKeywordCountField(true);
    }
    public APIRequestGet requestTotalApprovedKeywordCountField (boolean value) {
      this.requestField("total_approved_keyword_count", value);
      return this;
    }
    public APIRequestGet requestTotalDeclinedKeywordCountField () {
      return this.requestTotalDeclinedKeywordCountField(true);
    }
    public APIRequestGet requestTotalDeclinedKeywordCountField (boolean value) {
      this.requestField("total_declined_keyword_count", value);
      return this;
    }
    public APIRequestGet requestTotalNegativeKeywordCountField () {
      return this.requestTotalNegativeKeywordCountField(true);
    }
    public APIRequestGet requestTotalNegativeKeywordCountField (boolean value) {
      this.requestField("total_negative_keyword_count", value);
      return this;
    }
    public APIRequestGet requestTotalValidatedKeywordCountField () {
      return this.requestTotalValidatedKeywordCountField(true);
    }
    public APIRequestGet requestTotalValidatedKeywordCountField (boolean value) {
      this.requestField("total_validated_keyword_count", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<NegativeKeywordList> {

    NegativeKeywordList lastResponse = null;
    @Override
    public NegativeKeywordList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_id",
      "list_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NegativeKeywordList parseResponse(String response, String header) throws APIException {
      return NegativeKeywordList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NegativeKeywordList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NegativeKeywordList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NegativeKeywordList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NegativeKeywordList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NegativeKeywordList>() {
           public NegativeKeywordList apply(ResponseWrapper result) {
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


    public APIRequestUpdate setBusinessId (Long businessId) {
      this.setParam("business_id", businessId);
      return this;
    }
    public APIRequestUpdate setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestUpdate setListName (String listName) {
      this.setParam("list_name", listName);
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

  public NegativeKeywordList copyFrom(NegativeKeywordList instance) {
    this.mAppliedActiveAdCampaignGroups = instance.mAppliedActiveAdCampaignGroups;
    this.mAppliedInactiveAdCampaignGroups = instance.mAppliedInactiveAdCampaignGroups;
    this.mCreatorId = instance.mCreatorId;
    this.mId = instance.mId;
    this.mIsFullyReviewed = instance.mIsFullyReviewed;
    this.mLastUpdateTime = instance.mLastUpdateTime;
    this.mLastUpdateUserId = instance.mLastUpdateUserId;
    this.mListName = instance.mListName;
    this.mTotalApprovedKeywordCount = instance.mTotalApprovedKeywordCount;
    this.mTotalDeclinedKeywordCount = instance.mTotalDeclinedKeywordCount;
    this.mTotalNegativeKeywordCount = instance.mTotalNegativeKeywordCount;
    this.mTotalValidatedKeywordCount = instance.mTotalValidatedKeywordCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<NegativeKeywordList> getParser() {
    return new APIRequest.ResponseParser<NegativeKeywordList>() {
      public APINodeList<NegativeKeywordList> parseResponse(String response, APIContext context, APIRequest<NegativeKeywordList> request, String header) throws MalformedResponseException {
        return NegativeKeywordList.parseResponse(response, context, request, header);
      }
    };
  }
}
