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
public class FBImageCopyrightMatch extends APINode {
  @SerializedName("added_to_dashboard_time")
  private String mAddedToDashboardTime = null;
  @SerializedName("applied_actions")
  private List<Map<String, Object>> mAppliedActions = null;
  @SerializedName("audit_log")
  private List<Object> mAuditLog = null;
  @SerializedName("available_ui_actions")
  private List<String> mAvailableUiActions = null;
  @SerializedName("expiration_days")
  private Long mExpirationDays = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_business_page_match")
  private Boolean mIsBusinessPageMatch = null;
  @SerializedName("last_modified_time")
  private String mLastModifiedTime = null;
  @SerializedName("match_data")
  private List<Object> mMatchData = null;
  @SerializedName("match_status")
  private String mMatchStatus = null;
  @SerializedName("ownership_countries")
  private VideoCopyrightGeoGate mOwnershipCountries = null;
  @SerializedName("reference_owner")
  private Profile mReferenceOwner = null;
  @SerializedName("time_to_appeal")
  private Long mTimeToAppeal = null;
  protected static Gson gson = null;

  FBImageCopyrightMatch() {
  }

  public FBImageCopyrightMatch(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FBImageCopyrightMatch(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FBImageCopyrightMatch fetch() throws APIException{
    FBImageCopyrightMatch newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FBImageCopyrightMatch fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FBImageCopyrightMatch> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FBImageCopyrightMatch fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FBImageCopyrightMatch> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FBImageCopyrightMatch> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FBImageCopyrightMatch>)(
      new APIRequest<FBImageCopyrightMatch>(context, "", "/", "GET", FBImageCopyrightMatch.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FBImageCopyrightMatch>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FBImageCopyrightMatch.getParser())
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
  public static FBImageCopyrightMatch loadJSON(String json, APIContext context, String header) {
    FBImageCopyrightMatch fbImageCopyrightMatch = getGson().fromJson(json, FBImageCopyrightMatch.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(fbImageCopyrightMatch.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    fbImageCopyrightMatch.context = context;
    fbImageCopyrightMatch.rawValue = json;
    fbImageCopyrightMatch.header = header;
    return fbImageCopyrightMatch;
  }

  public static APINodeList<FBImageCopyrightMatch> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FBImageCopyrightMatch> fbImageCopyrightMatchs = new APINodeList<FBImageCopyrightMatch>(request, json, header);
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
          fbImageCopyrightMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return fbImageCopyrightMatchs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                fbImageCopyrightMatchs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            fbImageCopyrightMatchs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              fbImageCopyrightMatchs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              fbImageCopyrightMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  fbImageCopyrightMatchs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              fbImageCopyrightMatchs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return fbImageCopyrightMatchs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              fbImageCopyrightMatchs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return fbImageCopyrightMatchs;
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
              fbImageCopyrightMatchs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return fbImageCopyrightMatchs;
          }

          // Sixth, check if it's pure JsonObject
          fbImageCopyrightMatchs.clear();
          fbImageCopyrightMatchs.add(loadJSON(json, context, header));
          return fbImageCopyrightMatchs;
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


  public String getFieldAddedToDashboardTime() {
    return mAddedToDashboardTime;
  }

  public List<Map<String, Object>> getFieldAppliedActions() {
    return mAppliedActions;
  }

  public List<Object> getFieldAuditLog() {
    return mAuditLog;
  }

  public List<String> getFieldAvailableUiActions() {
    return mAvailableUiActions;
  }

  public Long getFieldExpirationDays() {
    return mExpirationDays;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsBusinessPageMatch() {
    return mIsBusinessPageMatch;
  }

  public String getFieldLastModifiedTime() {
    return mLastModifiedTime;
  }

  public List<Object> getFieldMatchData() {
    return mMatchData;
  }

  public String getFieldMatchStatus() {
    return mMatchStatus;
  }

  public VideoCopyrightGeoGate getFieldOwnershipCountries() {
    return mOwnershipCountries;
  }

  public Profile getFieldReferenceOwner() {
    if (mReferenceOwner != null) {
      mReferenceOwner.context = getContext();
    }
    return mReferenceOwner;
  }

  public Long getFieldTimeToAppeal() {
    return mTimeToAppeal;
  }



  public static class APIRequestGet extends APIRequest<FBImageCopyrightMatch> {

    FBImageCopyrightMatch lastResponse = null;
    @Override
    public FBImageCopyrightMatch getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "added_to_dashboard_time",
      "applied_actions",
      "audit_log",
      "available_ui_actions",
      "expiration_days",
      "id",
      "is_business_page_match",
      "last_modified_time",
      "match_data",
      "match_status",
      "ownership_countries",
      "reference_owner",
      "time_to_appeal",
    };

    @Override
    public FBImageCopyrightMatch parseResponse(String response, String header) throws APIException {
      return FBImageCopyrightMatch.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FBImageCopyrightMatch execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FBImageCopyrightMatch execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FBImageCopyrightMatch> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FBImageCopyrightMatch> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FBImageCopyrightMatch>() {
           public FBImageCopyrightMatch apply(ResponseWrapper result) {
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

    public APIRequestGet requestAddedToDashboardTimeField () {
      return this.requestAddedToDashboardTimeField(true);
    }
    public APIRequestGet requestAddedToDashboardTimeField (boolean value) {
      this.requestField("added_to_dashboard_time", value);
      return this;
    }
    public APIRequestGet requestAppliedActionsField () {
      return this.requestAppliedActionsField(true);
    }
    public APIRequestGet requestAppliedActionsField (boolean value) {
      this.requestField("applied_actions", value);
      return this;
    }
    public APIRequestGet requestAuditLogField () {
      return this.requestAuditLogField(true);
    }
    public APIRequestGet requestAuditLogField (boolean value) {
      this.requestField("audit_log", value);
      return this;
    }
    public APIRequestGet requestAvailableUiActionsField () {
      return this.requestAvailableUiActionsField(true);
    }
    public APIRequestGet requestAvailableUiActionsField (boolean value) {
      this.requestField("available_ui_actions", value);
      return this;
    }
    public APIRequestGet requestExpirationDaysField () {
      return this.requestExpirationDaysField(true);
    }
    public APIRequestGet requestExpirationDaysField (boolean value) {
      this.requestField("expiration_days", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsBusinessPageMatchField () {
      return this.requestIsBusinessPageMatchField(true);
    }
    public APIRequestGet requestIsBusinessPageMatchField (boolean value) {
      this.requestField("is_business_page_match", value);
      return this;
    }
    public APIRequestGet requestLastModifiedTimeField () {
      return this.requestLastModifiedTimeField(true);
    }
    public APIRequestGet requestLastModifiedTimeField (boolean value) {
      this.requestField("last_modified_time", value);
      return this;
    }
    public APIRequestGet requestMatchDataField () {
      return this.requestMatchDataField(true);
    }
    public APIRequestGet requestMatchDataField (boolean value) {
      this.requestField("match_data", value);
      return this;
    }
    public APIRequestGet requestMatchStatusField () {
      return this.requestMatchStatusField(true);
    }
    public APIRequestGet requestMatchStatusField (boolean value) {
      this.requestField("match_status", value);
      return this;
    }
    public APIRequestGet requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGet requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGet requestReferenceOwnerField () {
      return this.requestReferenceOwnerField(true);
    }
    public APIRequestGet requestReferenceOwnerField (boolean value) {
      this.requestField("reference_owner", value);
      return this;
    }
    public APIRequestGet requestTimeToAppealField () {
      return this.requestTimeToAppealField(true);
    }
    public APIRequestGet requestTimeToAppealField (boolean value) {
      this.requestField("time_to_appeal", value);
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

  public FBImageCopyrightMatch copyFrom(FBImageCopyrightMatch instance) {
    this.mAddedToDashboardTime = instance.mAddedToDashboardTime;
    this.mAppliedActions = instance.mAppliedActions;
    this.mAuditLog = instance.mAuditLog;
    this.mAvailableUiActions = instance.mAvailableUiActions;
    this.mExpirationDays = instance.mExpirationDays;
    this.mId = instance.mId;
    this.mIsBusinessPageMatch = instance.mIsBusinessPageMatch;
    this.mLastModifiedTime = instance.mLastModifiedTime;
    this.mMatchData = instance.mMatchData;
    this.mMatchStatus = instance.mMatchStatus;
    this.mOwnershipCountries = instance.mOwnershipCountries;
    this.mReferenceOwner = instance.mReferenceOwner;
    this.mTimeToAppeal = instance.mTimeToAppeal;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FBImageCopyrightMatch> getParser() {
    return new APIRequest.ResponseParser<FBImageCopyrightMatch>() {
      public APINodeList<FBImageCopyrightMatch> parseResponse(String response, APIContext context, APIRequest<FBImageCopyrightMatch> request, String header) throws MalformedResponseException {
        return FBImageCopyrightMatch.parseResponse(response, context, request, header);
      }
    };
  }
}
