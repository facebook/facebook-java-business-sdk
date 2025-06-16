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
public class IGUserExportForCAM extends APINode {
  @SerializedName("age_bucket")
  private String mAgeBucket = null;
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_account_verified")
  private Boolean mIsAccountVerified = null;
  @SerializedName("is_paid_partnership_messages_enabled")
  private Boolean mIsPaidPartnershipMessagesEnabled = null;
  @SerializedName("messaging_id")
  private String mMessagingId = null;
  @SerializedName("onboarded_status")
  private Boolean mOnboardedStatus = null;
  @SerializedName("portfolio_url")
  private String mPortfolioUrl = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  IGUserExportForCAM() {
  }

  public IGUserExportForCAM(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUserExportForCAM(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUserExportForCAM fetch() throws APIException{
    IGUserExportForCAM newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUserExportForCAM fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUserExportForCAM> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUserExportForCAM fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUserExportForCAM> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUserExportForCAM> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUserExportForCAM>)(
      new APIRequest<IGUserExportForCAM>(context, "", "/", "GET", IGUserExportForCAM.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUserExportForCAM>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUserExportForCAM.getParser())
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
  public static IGUserExportForCAM loadJSON(String json, APIContext context, String header) {
    IGUserExportForCAM igUserExportForCAM = getGson().fromJson(json, IGUserExportForCAM.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUserExportForCAM.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUserExportForCAM.context = context;
    igUserExportForCAM.rawValue = json;
    igUserExportForCAM.header = header;
    return igUserExportForCAM;
  }

  public static APINodeList<IGUserExportForCAM> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUserExportForCAM> igUserExportForCAMs = new APINodeList<IGUserExportForCAM>(request, json, header);
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
          igUserExportForCAMs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUserExportForCAMs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUserExportForCAMs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUserExportForCAMs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUserExportForCAMs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUserExportForCAMs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUserExportForCAMs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUserExportForCAMs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUserExportForCAMs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUserExportForCAMs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUserExportForCAMs;
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
              igUserExportForCAMs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUserExportForCAMs;
          }

          // Sixth, check if it's pure JsonObject
          igUserExportForCAMs.clear();
          igUserExportForCAMs.add(loadJSON(json, context, header));
          return igUserExportForCAMs;
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

  public APIRequestGetBrandedContentMedia getBrandedContentMedia() {
    return new APIRequestGetBrandedContentMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRecentMedia getRecentMedia() {
    return new APIRequestGetRecentMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAgeBucket() {
    return mAgeBucket;
  }

  public String getFieldBiography() {
    return mBiography;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldGender() {
    return mGender;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAccountVerified() {
    return mIsAccountVerified;
  }

  public Boolean getFieldIsPaidPartnershipMessagesEnabled() {
    return mIsPaidPartnershipMessagesEnabled;
  }

  public String getFieldMessagingId() {
    return mMessagingId;
  }

  public Boolean getFieldOnboardedStatus() {
    return mOnboardedStatus;
  }

  public String getFieldPortfolioUrl() {
    return mPortfolioUrl;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetBrandedContentMedia extends APIRequest<APINode> {

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
               return APIRequestGetBrandedContentMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBrandedContentMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/branded_content_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBrandedContentMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBrandedContentMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBrandedContentMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBrandedContentMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBrandedContentMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBrandedContentMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metrics",
      "period",
      "time_range",
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
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestGetInsights setBreakdown (EnumBreakdown breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInsights setMetrics (List<EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestGetInsights setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestGetInsights setPeriod (EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setTimeRange (EnumTimeRange timeRange) {
      this.setParam("time_range", timeRange);
      return this;
    }
    public APIRequestGetInsights setTimeRange (String timeRange) {
      this.setParam("time_range", timeRange);
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

  public static class APIRequestGetRecentMedia extends APIRequest<APINode> {

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
               return APIRequestGetRecentMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRecentMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/recent_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<IGUserExportForCAM> {

    IGUserExportForCAM lastResponse = null;
    @Override
    public IGUserExportForCAM getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "age_bucket",
      "biography",
      "country",
      "email",
      "gender",
      "id",
      "is_account_verified",
      "is_paid_partnership_messages_enabled",
      "messaging_id",
      "onboarded_status",
      "portfolio_url",
      "username",
    };

    @Override
    public IGUserExportForCAM parseResponse(String response, String header) throws APIException {
      return IGUserExportForCAM.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUserExportForCAM execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUserExportForCAM execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUserExportForCAM> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUserExportForCAM> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUserExportForCAM>() {
           public IGUserExportForCAM apply(ResponseWrapper result) {
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

    public APIRequestGet requestAgeBucketField () {
      return this.requestAgeBucketField(true);
    }
    public APIRequestGet requestAgeBucketField (boolean value) {
      this.requestField("age_bucket", value);
      return this;
    }
    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAccountVerifiedField () {
      return this.requestIsAccountVerifiedField(true);
    }
    public APIRequestGet requestIsAccountVerifiedField (boolean value) {
      this.requestField("is_account_verified", value);
      return this;
    }
    public APIRequestGet requestIsPaidPartnershipMessagesEnabledField () {
      return this.requestIsPaidPartnershipMessagesEnabledField(true);
    }
    public APIRequestGet requestIsPaidPartnershipMessagesEnabledField (boolean value) {
      this.requestField("is_paid_partnership_messages_enabled", value);
      return this;
    }
    public APIRequestGet requestMessagingIdField () {
      return this.requestMessagingIdField(true);
    }
    public APIRequestGet requestMessagingIdField (boolean value) {
      this.requestField("messaging_id", value);
      return this;
    }
    public APIRequestGet requestOnboardedStatusField () {
      return this.requestOnboardedStatusField(true);
    }
    public APIRequestGet requestOnboardedStatusField (boolean value) {
      this.requestField("onboarded_status", value);
      return this;
    }
    public APIRequestGet requestPortfolioUrlField () {
      return this.requestPortfolioUrlField(true);
    }
    public APIRequestGet requestPortfolioUrlField (boolean value) {
      this.requestField("portfolio_url", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static enum EnumBreakdown {
      @SerializedName("AGE")
      VALUE_AGE("AGE"),
      @SerializedName("FOLLOW_TYPE")
      VALUE_FOLLOW_TYPE("FOLLOW_TYPE"),
      @SerializedName("GENDER")
      VALUE_GENDER("GENDER"),
      @SerializedName("MEDIA_TYPE")
      VALUE_MEDIA_TYPE("MEDIA_TYPE"),
      @SerializedName("TOP_CITIES")
      VALUE_TOP_CITIES("TOP_CITIES"),
      @SerializedName("TOP_COUNTRIES")
      VALUE_TOP_COUNTRIES("TOP_COUNTRIES"),
      ;

      private String value;

      private EnumBreakdown(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetrics {
      @SerializedName("CREATOR_ENGAGED_ACCOUNTS")
      VALUE_CREATOR_ENGAGED_ACCOUNTS("CREATOR_ENGAGED_ACCOUNTS"),
      @SerializedName("CREATOR_REACH")
      VALUE_CREATOR_REACH("CREATOR_REACH"),
      @SerializedName("REELS_HOOK_RATE")
      VALUE_REELS_HOOK_RATE("REELS_HOOK_RATE"),
      @SerializedName("REELS_INTERACTION_RATE")
      VALUE_REELS_INTERACTION_RATE("REELS_INTERACTION_RATE"),
      @SerializedName("TOTAL_FOLLOWERS")
      VALUE_TOTAL_FOLLOWERS("TOTAL_FOLLOWERS"),
      ;

      private String value;

      private EnumMetrics(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("DAY")
      VALUE_DAY("DAY"),
      @SerializedName("OVERALL")
      VALUE_OVERALL("OVERALL"),
      ;

      private String value;

      private EnumPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimeRange {
      @SerializedName("LAST_14_DAYS")
      VALUE_LAST_14_DAYS("LAST_14_DAYS"),
      @SerializedName("LAST_90_DAYS")
      VALUE_LAST_90_DAYS("LAST_90_DAYS"),
      @SerializedName("LIFETIME")
      VALUE_LIFETIME("LIFETIME"),
      @SerializedName("THIS_MONTH")
      VALUE_THIS_MONTH("THIS_MONTH"),
      @SerializedName("THIS_WEEK")
      VALUE_THIS_WEEK("THIS_WEEK"),
      ;

      private String value;

      private EnumTimeRange(String value) {
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

  public IGUserExportForCAM copyFrom(IGUserExportForCAM instance) {
    this.mAgeBucket = instance.mAgeBucket;
    this.mBiography = instance.mBiography;
    this.mCountry = instance.mCountry;
    this.mEmail = instance.mEmail;
    this.mGender = instance.mGender;
    this.mId = instance.mId;
    this.mIsAccountVerified = instance.mIsAccountVerified;
    this.mIsPaidPartnershipMessagesEnabled = instance.mIsPaidPartnershipMessagesEnabled;
    this.mMessagingId = instance.mMessagingId;
    this.mOnboardedStatus = instance.mOnboardedStatus;
    this.mPortfolioUrl = instance.mPortfolioUrl;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUserExportForCAM> getParser() {
    return new APIRequest.ResponseParser<IGUserExportForCAM>() {
      public APINodeList<IGUserExportForCAM> parseResponse(String response, APIContext context, APIRequest<IGUserExportForCAM> request, String header) throws MalformedResponseException {
        return IGUserExportForCAM.parseResponse(response, context, request, header);
      }
    };
  }
}
