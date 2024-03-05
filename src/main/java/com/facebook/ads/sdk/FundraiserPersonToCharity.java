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
public class FundraiserPersonToCharity extends APINode {
  @SerializedName("amount_raised")
  private Long mAmountRaised = null;
  @SerializedName("charity_id")
  private String mCharityId = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("donations_count")
  private Long mDonationsCount = null;
  @SerializedName("donors_count")
  private Long mDonorsCount = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("external_amount_raised")
  private Long mExternalAmountRaised = null;
  @SerializedName("external_donations_count")
  private Long mExternalDonationsCount = null;
  @SerializedName("external_donors_count")
  private Long mExternalDonorsCount = null;
  @SerializedName("external_event_name")
  private String mExternalEventName = null;
  @SerializedName("external_event_start_time")
  private String mExternalEventStartTime = null;
  @SerializedName("external_event_uri")
  private String mExternalEventUri = null;
  @SerializedName("external_fundraiser_uri")
  private String mExternalFundraiserUri = null;
  @SerializedName("external_id")
  private String mExternalId = null;
  @SerializedName("goal_amount")
  private Long mGoalAmount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("internal_amount_raised")
  private Long mInternalAmountRaised = null;
  @SerializedName("internal_donations_count")
  private Long mInternalDonationsCount = null;
  @SerializedName("internal_donors_count")
  private Long mInternalDonorsCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("uri")
  private String mUri = null;
  protected static Gson gson = null;

  FundraiserPersonToCharity() {
  }

  public FundraiserPersonToCharity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FundraiserPersonToCharity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FundraiserPersonToCharity fetch() throws APIException{
    FundraiserPersonToCharity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FundraiserPersonToCharity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FundraiserPersonToCharity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FundraiserPersonToCharity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FundraiserPersonToCharity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FundraiserPersonToCharity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FundraiserPersonToCharity>)(
      new APIRequest<FundraiserPersonToCharity>(context, "", "/", "GET", FundraiserPersonToCharity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FundraiserPersonToCharity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FundraiserPersonToCharity.getParser())
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
  public static FundraiserPersonToCharity loadJSON(String json, APIContext context, String header) {
    FundraiserPersonToCharity fundraiserPersonToCharity = getGson().fromJson(json, FundraiserPersonToCharity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(fundraiserPersonToCharity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    fundraiserPersonToCharity.context = context;
    fundraiserPersonToCharity.rawValue = json;
    fundraiserPersonToCharity.header = header;
    return fundraiserPersonToCharity;
  }

  public static APINodeList<FundraiserPersonToCharity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FundraiserPersonToCharity> fundraiserPersonToCharitys = new APINodeList<FundraiserPersonToCharity>(request, json, header);
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
          fundraiserPersonToCharitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return fundraiserPersonToCharitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                fundraiserPersonToCharitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            fundraiserPersonToCharitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              fundraiserPersonToCharitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              fundraiserPersonToCharitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  fundraiserPersonToCharitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              fundraiserPersonToCharitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return fundraiserPersonToCharitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              fundraiserPersonToCharitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return fundraiserPersonToCharitys;
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
              fundraiserPersonToCharitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return fundraiserPersonToCharitys;
          }

          // Sixth, check if it's pure JsonObject
          fundraiserPersonToCharitys.clear();
          fundraiserPersonToCharitys.add(loadJSON(json, context, header));
          return fundraiserPersonToCharitys;
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

  public APIRequestGetDonations getDonations() {
    return new APIRequestGetDonations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateEndFundraiser createEndFundraiser() {
    return new APIRequestCreateEndFundraiser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExternalDonations getExternalDonations() {
    return new APIRequestGetExternalDonations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateExternalDonation createExternalDonation() {
    return new APIRequestCreateExternalDonation(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Long getFieldAmountRaised() {
    return mAmountRaised;
  }

  public String getFieldCharityId() {
    return mCharityId;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Long getFieldDonationsCount() {
    return mDonationsCount;
  }

  public Long getFieldDonorsCount() {
    return mDonorsCount;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public Long getFieldExternalAmountRaised() {
    return mExternalAmountRaised;
  }

  public Long getFieldExternalDonationsCount() {
    return mExternalDonationsCount;
  }

  public Long getFieldExternalDonorsCount() {
    return mExternalDonorsCount;
  }

  public String getFieldExternalEventName() {
    return mExternalEventName;
  }

  public String getFieldExternalEventStartTime() {
    return mExternalEventStartTime;
  }

  public String getFieldExternalEventUri() {
    return mExternalEventUri;
  }

  public String getFieldExternalFundraiserUri() {
    return mExternalFundraiserUri;
  }

  public String getFieldExternalId() {
    return mExternalId;
  }

  public Long getFieldGoalAmount() {
    return mGoalAmount;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldInternalAmountRaised() {
    return mInternalAmountRaised;
  }

  public Long getFieldInternalDonationsCount() {
    return mInternalDonationsCount;
  }

  public Long getFieldInternalDonorsCount() {
    return mInternalDonorsCount;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldUri() {
    return mUri;
  }



  public static class APIRequestGetDonations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDonations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDonations(String nodeId, APIContext context) {
      super(context, nodeId, "/donations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDonations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDonations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDonations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDonations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDonations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDonations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDonations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDonations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateEndFundraiser extends APIRequest<APINode> {

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
               return APIRequestCreateEndFundraiser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateEndFundraiser(String nodeId, APIContext context) {
      super(context, nodeId, "/end_fundraiser", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateEndFundraiser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateEndFundraiser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateEndFundraiser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateEndFundraiser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEndFundraiser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateEndFundraiser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEndFundraiser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateEndFundraiser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetExternalDonations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetExternalDonations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetExternalDonations(String nodeId, APIContext context) {
      super(context, nodeId, "/external_donations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExternalDonations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExternalDonations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExternalDonations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExternalDonations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalDonations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExternalDonations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalDonations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExternalDonations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateExternalDonation extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "amount_received",
      "currency",
      "donation_id_hash",
      "donation_time",
      "donor_id_hash",
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
               return APIRequestCreateExternalDonation.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateExternalDonation(String nodeId, APIContext context) {
      super(context, nodeId, "/external_donations", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateExternalDonation setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateExternalDonation setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExternalDonation setAmountReceived (Long amountReceived) {
      this.setParam("amount_received", amountReceived);
      return this;
    }
    public APIRequestCreateExternalDonation setAmountReceived (String amountReceived) {
      this.setParam("amount_received", amountReceived);
      return this;
    }

    public APIRequestCreateExternalDonation setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateExternalDonation setDonationIdHash (String donationIdHash) {
      this.setParam("donation_id_hash", donationIdHash);
      return this;
    }

    public APIRequestCreateExternalDonation setDonationTime (Long donationTime) {
      this.setParam("donation_time", donationTime);
      return this;
    }
    public APIRequestCreateExternalDonation setDonationTime (String donationTime) {
      this.setParam("donation_time", donationTime);
      return this;
    }

    public APIRequestCreateExternalDonation setDonorIdHash (String donorIdHash) {
      this.setParam("donor_id_hash", donorIdHash);
      return this;
    }

    public APIRequestCreateExternalDonation requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExternalDonation requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExternalDonation requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateExternalDonation requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExternalDonation requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateExternalDonation requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<FundraiserPersonToCharity> {

    FundraiserPersonToCharity lastResponse = null;
    @Override
    public FundraiserPersonToCharity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "amount_raised",
      "charity_id",
      "currency",
      "description",
      "donations_count",
      "donors_count",
      "end_time",
      "external_amount_raised",
      "external_donations_count",
      "external_donors_count",
      "external_event_name",
      "external_event_start_time",
      "external_event_uri",
      "external_fundraiser_uri",
      "external_id",
      "goal_amount",
      "id",
      "internal_amount_raised",
      "internal_donations_count",
      "internal_donors_count",
      "name",
      "uri",
    };

    @Override
    public FundraiserPersonToCharity parseResponse(String response, String header) throws APIException {
      return FundraiserPersonToCharity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FundraiserPersonToCharity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FundraiserPersonToCharity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FundraiserPersonToCharity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FundraiserPersonToCharity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FundraiserPersonToCharity>() {
           public FundraiserPersonToCharity apply(ResponseWrapper result) {
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

    public APIRequestGet requestAmountRaisedField () {
      return this.requestAmountRaisedField(true);
    }
    public APIRequestGet requestAmountRaisedField (boolean value) {
      this.requestField("amount_raised", value);
      return this;
    }
    public APIRequestGet requestCharityIdField () {
      return this.requestCharityIdField(true);
    }
    public APIRequestGet requestCharityIdField (boolean value) {
      this.requestField("charity_id", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDonationsCountField () {
      return this.requestDonationsCountField(true);
    }
    public APIRequestGet requestDonationsCountField (boolean value) {
      this.requestField("donations_count", value);
      return this;
    }
    public APIRequestGet requestDonorsCountField () {
      return this.requestDonorsCountField(true);
    }
    public APIRequestGet requestDonorsCountField (boolean value) {
      this.requestField("donors_count", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestExternalAmountRaisedField () {
      return this.requestExternalAmountRaisedField(true);
    }
    public APIRequestGet requestExternalAmountRaisedField (boolean value) {
      this.requestField("external_amount_raised", value);
      return this;
    }
    public APIRequestGet requestExternalDonationsCountField () {
      return this.requestExternalDonationsCountField(true);
    }
    public APIRequestGet requestExternalDonationsCountField (boolean value) {
      this.requestField("external_donations_count", value);
      return this;
    }
    public APIRequestGet requestExternalDonorsCountField () {
      return this.requestExternalDonorsCountField(true);
    }
    public APIRequestGet requestExternalDonorsCountField (boolean value) {
      this.requestField("external_donors_count", value);
      return this;
    }
    public APIRequestGet requestExternalEventNameField () {
      return this.requestExternalEventNameField(true);
    }
    public APIRequestGet requestExternalEventNameField (boolean value) {
      this.requestField("external_event_name", value);
      return this;
    }
    public APIRequestGet requestExternalEventStartTimeField () {
      return this.requestExternalEventStartTimeField(true);
    }
    public APIRequestGet requestExternalEventStartTimeField (boolean value) {
      this.requestField("external_event_start_time", value);
      return this;
    }
    public APIRequestGet requestExternalEventUriField () {
      return this.requestExternalEventUriField(true);
    }
    public APIRequestGet requestExternalEventUriField (boolean value) {
      this.requestField("external_event_uri", value);
      return this;
    }
    public APIRequestGet requestExternalFundraiserUriField () {
      return this.requestExternalFundraiserUriField(true);
    }
    public APIRequestGet requestExternalFundraiserUriField (boolean value) {
      this.requestField("external_fundraiser_uri", value);
      return this;
    }
    public APIRequestGet requestExternalIdField () {
      return this.requestExternalIdField(true);
    }
    public APIRequestGet requestExternalIdField (boolean value) {
      this.requestField("external_id", value);
      return this;
    }
    public APIRequestGet requestGoalAmountField () {
      return this.requestGoalAmountField(true);
    }
    public APIRequestGet requestGoalAmountField (boolean value) {
      this.requestField("goal_amount", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInternalAmountRaisedField () {
      return this.requestInternalAmountRaisedField(true);
    }
    public APIRequestGet requestInternalAmountRaisedField (boolean value) {
      this.requestField("internal_amount_raised", value);
      return this;
    }
    public APIRequestGet requestInternalDonationsCountField () {
      return this.requestInternalDonationsCountField(true);
    }
    public APIRequestGet requestInternalDonationsCountField (boolean value) {
      this.requestField("internal_donations_count", value);
      return this;
    }
    public APIRequestGet requestInternalDonorsCountField () {
      return this.requestInternalDonorsCountField(true);
    }
    public APIRequestGet requestInternalDonorsCountField (boolean value) {
      this.requestField("internal_donors_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGet requestUriField (boolean value) {
      this.requestField("uri", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<FundraiserPersonToCharity> {

    FundraiserPersonToCharity lastResponse = null;
    @Override
    public FundraiserPersonToCharity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "description",
      "end_time",
      "external_event_name",
      "external_event_start_time",
      "external_event_uri",
      "external_fundraiser_uri",
      "external_id",
      "goal_amount",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public FundraiserPersonToCharity parseResponse(String response, String header) throws APIException {
      return FundraiserPersonToCharity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FundraiserPersonToCharity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FundraiserPersonToCharity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FundraiserPersonToCharity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FundraiserPersonToCharity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FundraiserPersonToCharity>() {
           public FundraiserPersonToCharity apply(ResponseWrapper result) {
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


    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestUpdate setExternalEventName (String externalEventName) {
      this.setParam("external_event_name", externalEventName);
      return this;
    }

    public APIRequestUpdate setExternalEventStartTime (String externalEventStartTime) {
      this.setParam("external_event_start_time", externalEventStartTime);
      return this;
    }

    public APIRequestUpdate setExternalEventUri (String externalEventUri) {
      this.setParam("external_event_uri", externalEventUri);
      return this;
    }

    public APIRequestUpdate setExternalFundraiserUri (String externalFundraiserUri) {
      this.setParam("external_fundraiser_uri", externalFundraiserUri);
      return this;
    }

    public APIRequestUpdate setExternalId (String externalId) {
      this.setParam("external_id", externalId);
      return this;
    }

    public APIRequestUpdate setGoalAmount (Long goalAmount) {
      this.setParam("goal_amount", goalAmount);
      return this;
    }
    public APIRequestUpdate setGoalAmount (String goalAmount) {
      this.setParam("goal_amount", goalAmount);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumFundraiserType {
      @SerializedName("person_for_charity")
      VALUE_PERSON_FOR_CHARITY("person_for_charity"),
      ;

      private String value;

      private EnumFundraiserType(String value) {
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

  public FundraiserPersonToCharity copyFrom(FundraiserPersonToCharity instance) {
    this.mAmountRaised = instance.mAmountRaised;
    this.mCharityId = instance.mCharityId;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mDonationsCount = instance.mDonationsCount;
    this.mDonorsCount = instance.mDonorsCount;
    this.mEndTime = instance.mEndTime;
    this.mExternalAmountRaised = instance.mExternalAmountRaised;
    this.mExternalDonationsCount = instance.mExternalDonationsCount;
    this.mExternalDonorsCount = instance.mExternalDonorsCount;
    this.mExternalEventName = instance.mExternalEventName;
    this.mExternalEventStartTime = instance.mExternalEventStartTime;
    this.mExternalEventUri = instance.mExternalEventUri;
    this.mExternalFundraiserUri = instance.mExternalFundraiserUri;
    this.mExternalId = instance.mExternalId;
    this.mGoalAmount = instance.mGoalAmount;
    this.mId = instance.mId;
    this.mInternalAmountRaised = instance.mInternalAmountRaised;
    this.mInternalDonationsCount = instance.mInternalDonationsCount;
    this.mInternalDonorsCount = instance.mInternalDonorsCount;
    this.mName = instance.mName;
    this.mUri = instance.mUri;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FundraiserPersonToCharity> getParser() {
    return new APIRequest.ResponseParser<FundraiserPersonToCharity>() {
      public APINodeList<FundraiserPersonToCharity> parseResponse(String response, APIContext context, APIRequest<FundraiserPersonToCharity> request, String header) throws MalformedResponseException {
        return FundraiserPersonToCharity.parseResponse(response, context, request, header);
      }
    };
  }
}
