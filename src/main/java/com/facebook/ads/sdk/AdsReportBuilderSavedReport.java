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
public class AdsReportBuilderSavedReport extends APINode {
  @SerializedName("action_report_time")
  private String mActionReportTime = null;
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("attribution_windows")
  private List<String> mAttributionWindows = null;
  @SerializedName("comparison_date_interval")
  private Object mComparisonDateInterval = null;
  @SerializedName("creation_source")
  private String mCreationSource = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("date_interval")
  private Object mDateInterval = null;
  @SerializedName("date_preset")
  private String mDatePreset = null;
  @SerializedName("default_attribution_windows")
  private List<String> mDefaultAttributionWindows = null;
  @SerializedName("dimension_groups")
  private List<List<String>> mDimensionGroups = null;
  @SerializedName("dimensions")
  private List<String> mDimensions = null;
  @SerializedName("filtering")
  private JsonArray mFiltering = null;
  @SerializedName("formatting")
  private List<Map<String, List<Object>>> mFormatting = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_access_by")
  private Profile mLastAccessBy = null;
  @SerializedName("last_access_time")
  private String mLastAccessTime = null;
  @SerializedName("last_report_snapshot_id")
  private String mLastReportSnapshotId = null;
  @SerializedName("last_report_snapshot_time")
  private String mLastReportSnapshotTime = null;
  @SerializedName("last_shared_report_expiration")
  private String mLastSharedReportExpiration = null;
  @SerializedName("limit")
  private Long mLimit = null;
  @SerializedName("locked_dimensions")
  private Long mLockedDimensions = null;
  @SerializedName("metrics")
  private List<String> mMetrics = null;
  @SerializedName("report_name")
  private String mReportName = null;
  @SerializedName("report_snapshot_async_percent_completion")
  private Long mReportSnapshotAsyncPercentCompletion = null;
  @SerializedName("report_snapshot_async_status")
  private String mReportSnapshotAsyncStatus = null;
  @SerializedName("schedule_frequency")
  private String mScheduleFrequency = null;
  @SerializedName("scope")
  private String mScope = null;
  @SerializedName("show_deprecate_aw_banner")
  private Boolean mShowDeprecateAwBanner = null;
  @SerializedName("sorting")
  private List<Object> mSorting = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subscribers")
  private List<String> mSubscribers = null;
  @SerializedName("update_by")
  private Profile mUpdateBy = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("user")
  private Profile mUser = null;
  @SerializedName("user_dimensions")
  private List<String> mUserDimensions = null;
  @SerializedName("user_metrics")
  private List<String> mUserMetrics = null;
  @SerializedName("view_type")
  private String mViewType = null;
  protected static Gson gson = null;

  AdsReportBuilderSavedReport() {
  }

  public AdsReportBuilderSavedReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsReportBuilderSavedReport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsReportBuilderSavedReport fetch() throws APIException{
    AdsReportBuilderSavedReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsReportBuilderSavedReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsReportBuilderSavedReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsReportBuilderSavedReport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsReportBuilderSavedReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsReportBuilderSavedReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsReportBuilderSavedReport>)(
      new APIRequest<AdsReportBuilderSavedReport>(context, "", "/", "GET", AdsReportBuilderSavedReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsReportBuilderSavedReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsReportBuilderSavedReport.getParser())
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
  public static AdsReportBuilderSavedReport loadJSON(String json, APIContext context, String header) {
    AdsReportBuilderSavedReport adsReportBuilderSavedReport = getGson().fromJson(json, AdsReportBuilderSavedReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsReportBuilderSavedReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsReportBuilderSavedReport.context = context;
    adsReportBuilderSavedReport.rawValue = json;
    adsReportBuilderSavedReport.header = header;
    return adsReportBuilderSavedReport;
  }

  public static APINodeList<AdsReportBuilderSavedReport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsReportBuilderSavedReport> adsReportBuilderSavedReports = new APINodeList<AdsReportBuilderSavedReport>(request, json, header);
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
          adsReportBuilderSavedReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsReportBuilderSavedReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsReportBuilderSavedReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsReportBuilderSavedReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsReportBuilderSavedReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsReportBuilderSavedReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsReportBuilderSavedReports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsReportBuilderSavedReports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsReportBuilderSavedReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsReportBuilderSavedReports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsReportBuilderSavedReports;
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
              adsReportBuilderSavedReports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsReportBuilderSavedReports;
          }

          // Sixth, check if it's pure JsonObject
          adsReportBuilderSavedReports.clear();
          adsReportBuilderSavedReports.add(loadJSON(json, context, header));
          return adsReportBuilderSavedReports;
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


  public String getFieldActionReportTime() {
    return mActionReportTime;
  }

  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public List<String> getFieldAttributionWindows() {
    return mAttributionWindows;
  }

  public Object getFieldComparisonDateInterval() {
    return mComparisonDateInterval;
  }

  public String getFieldCreationSource() {
    return mCreationSource;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public Object getFieldDateInterval() {
    return mDateInterval;
  }

  public String getFieldDatePreset() {
    return mDatePreset;
  }

  public List<String> getFieldDefaultAttributionWindows() {
    return mDefaultAttributionWindows;
  }

  public List<List<String>> getFieldDimensionGroups() {
    return mDimensionGroups;
  }

  public List<String> getFieldDimensions() {
    return mDimensions;
  }

  public JsonArray getFieldFiltering() {
    return mFiltering;
  }

  public List<Map<String, List<Object>>> getFieldFormatting() {
    return mFormatting;
  }

  public String getFieldId() {
    return mId;
  }

  public Profile getFieldLastAccessBy() {
    if (mLastAccessBy != null) {
      mLastAccessBy.context = getContext();
    }
    return mLastAccessBy;
  }

  public String getFieldLastAccessTime() {
    return mLastAccessTime;
  }

  public String getFieldLastReportSnapshotId() {
    return mLastReportSnapshotId;
  }

  public String getFieldLastReportSnapshotTime() {
    return mLastReportSnapshotTime;
  }

  public String getFieldLastSharedReportExpiration() {
    return mLastSharedReportExpiration;
  }

  public Long getFieldLimit() {
    return mLimit;
  }

  public Long getFieldLockedDimensions() {
    return mLockedDimensions;
  }

  public List<String> getFieldMetrics() {
    return mMetrics;
  }

  public String getFieldReportName() {
    return mReportName;
  }

  public Long getFieldReportSnapshotAsyncPercentCompletion() {
    return mReportSnapshotAsyncPercentCompletion;
  }

  public String getFieldReportSnapshotAsyncStatus() {
    return mReportSnapshotAsyncStatus;
  }

  public String getFieldScheduleFrequency() {
    return mScheduleFrequency;
  }

  public String getFieldScope() {
    return mScope;
  }

  public Boolean getFieldShowDeprecateAwBanner() {
    return mShowDeprecateAwBanner;
  }

  public List<Object> getFieldSorting() {
    return mSorting;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldSubscribers() {
    return mSubscribers;
  }

  public Profile getFieldUpdateBy() {
    if (mUpdateBy != null) {
      mUpdateBy.context = getContext();
    }
    return mUpdateBy;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public Profile getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public List<String> getFieldUserDimensions() {
    return mUserDimensions;
  }

  public List<String> getFieldUserMetrics() {
    return mUserMetrics;
  }

  public String getFieldViewType() {
    return mViewType;
  }



  public static class APIRequestGet extends APIRequest<AdsReportBuilderSavedReport> {

    AdsReportBuilderSavedReport lastResponse = null;
    @Override
    public AdsReportBuilderSavedReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "action_report_time",
      "ad_account_id",
      "attribution_windows",
      "comparison_date_interval",
      "creation_source",
      "creation_time",
      "currency",
      "date_interval",
      "date_preset",
      "default_attribution_windows",
      "dimension_groups",
      "dimensions",
      "filtering",
      "formatting",
      "id",
      "last_access_by",
      "last_access_time",
      "last_report_snapshot_id",
      "last_report_snapshot_time",
      "last_shared_report_expiration",
      "limit",
      "locked_dimensions",
      "metrics",
      "report_name",
      "report_snapshot_async_percent_completion",
      "report_snapshot_async_status",
      "schedule_frequency",
      "scope",
      "show_deprecate_aw_banner",
      "sorting",
      "start_date",
      "status",
      "subscribers",
      "update_by",
      "update_time",
      "user",
      "user_dimensions",
      "user_metrics",
      "view_type",
    };

    @Override
    public AdsReportBuilderSavedReport parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderSavedReport.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsReportBuilderSavedReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsReportBuilderSavedReport execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsReportBuilderSavedReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsReportBuilderSavedReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsReportBuilderSavedReport>() {
           public AdsReportBuilderSavedReport apply(ResponseWrapper result) {
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

    public APIRequestGet requestActionReportTimeField () {
      return this.requestActionReportTimeField(true);
    }
    public APIRequestGet requestActionReportTimeField (boolean value) {
      this.requestField("action_report_time", value);
      return this;
    }
    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestAttributionWindowsField () {
      return this.requestAttributionWindowsField(true);
    }
    public APIRequestGet requestAttributionWindowsField (boolean value) {
      this.requestField("attribution_windows", value);
      return this;
    }
    public APIRequestGet requestComparisonDateIntervalField () {
      return this.requestComparisonDateIntervalField(true);
    }
    public APIRequestGet requestComparisonDateIntervalField (boolean value) {
      this.requestField("comparison_date_interval", value);
      return this;
    }
    public APIRequestGet requestCreationSourceField () {
      return this.requestCreationSourceField(true);
    }
    public APIRequestGet requestCreationSourceField (boolean value) {
      this.requestField("creation_source", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDateIntervalField () {
      return this.requestDateIntervalField(true);
    }
    public APIRequestGet requestDateIntervalField (boolean value) {
      this.requestField("date_interval", value);
      return this;
    }
    public APIRequestGet requestDatePresetField () {
      return this.requestDatePresetField(true);
    }
    public APIRequestGet requestDatePresetField (boolean value) {
      this.requestField("date_preset", value);
      return this;
    }
    public APIRequestGet requestDefaultAttributionWindowsField () {
      return this.requestDefaultAttributionWindowsField(true);
    }
    public APIRequestGet requestDefaultAttributionWindowsField (boolean value) {
      this.requestField("default_attribution_windows", value);
      return this;
    }
    public APIRequestGet requestDimensionGroupsField () {
      return this.requestDimensionGroupsField(true);
    }
    public APIRequestGet requestDimensionGroupsField (boolean value) {
      this.requestField("dimension_groups", value);
      return this;
    }
    public APIRequestGet requestDimensionsField () {
      return this.requestDimensionsField(true);
    }
    public APIRequestGet requestDimensionsField (boolean value) {
      this.requestField("dimensions", value);
      return this;
    }
    public APIRequestGet requestFilteringField () {
      return this.requestFilteringField(true);
    }
    public APIRequestGet requestFilteringField (boolean value) {
      this.requestField("filtering", value);
      return this;
    }
    public APIRequestGet requestFormattingField () {
      return this.requestFormattingField(true);
    }
    public APIRequestGet requestFormattingField (boolean value) {
      this.requestField("formatting", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastAccessByField () {
      return this.requestLastAccessByField(true);
    }
    public APIRequestGet requestLastAccessByField (boolean value) {
      this.requestField("last_access_by", value);
      return this;
    }
    public APIRequestGet requestLastAccessTimeField () {
      return this.requestLastAccessTimeField(true);
    }
    public APIRequestGet requestLastAccessTimeField (boolean value) {
      this.requestField("last_access_time", value);
      return this;
    }
    public APIRequestGet requestLastReportSnapshotIdField () {
      return this.requestLastReportSnapshotIdField(true);
    }
    public APIRequestGet requestLastReportSnapshotIdField (boolean value) {
      this.requestField("last_report_snapshot_id", value);
      return this;
    }
    public APIRequestGet requestLastReportSnapshotTimeField () {
      return this.requestLastReportSnapshotTimeField(true);
    }
    public APIRequestGet requestLastReportSnapshotTimeField (boolean value) {
      this.requestField("last_report_snapshot_time", value);
      return this;
    }
    public APIRequestGet requestLastSharedReportExpirationField () {
      return this.requestLastSharedReportExpirationField(true);
    }
    public APIRequestGet requestLastSharedReportExpirationField (boolean value) {
      this.requestField("last_shared_report_expiration", value);
      return this;
    }
    public APIRequestGet requestLimitField () {
      return this.requestLimitField(true);
    }
    public APIRequestGet requestLimitField (boolean value) {
      this.requestField("limit", value);
      return this;
    }
    public APIRequestGet requestLockedDimensionsField () {
      return this.requestLockedDimensionsField(true);
    }
    public APIRequestGet requestLockedDimensionsField (boolean value) {
      this.requestField("locked_dimensions", value);
      return this;
    }
    public APIRequestGet requestMetricsField () {
      return this.requestMetricsField(true);
    }
    public APIRequestGet requestMetricsField (boolean value) {
      this.requestField("metrics", value);
      return this;
    }
    public APIRequestGet requestReportNameField () {
      return this.requestReportNameField(true);
    }
    public APIRequestGet requestReportNameField (boolean value) {
      this.requestField("report_name", value);
      return this;
    }
    public APIRequestGet requestReportSnapshotAsyncPercentCompletionField () {
      return this.requestReportSnapshotAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestReportSnapshotAsyncPercentCompletionField (boolean value) {
      this.requestField("report_snapshot_async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestReportSnapshotAsyncStatusField () {
      return this.requestReportSnapshotAsyncStatusField(true);
    }
    public APIRequestGet requestReportSnapshotAsyncStatusField (boolean value) {
      this.requestField("report_snapshot_async_status", value);
      return this;
    }
    public APIRequestGet requestScheduleFrequencyField () {
      return this.requestScheduleFrequencyField(true);
    }
    public APIRequestGet requestScheduleFrequencyField (boolean value) {
      this.requestField("schedule_frequency", value);
      return this;
    }
    public APIRequestGet requestScopeField () {
      return this.requestScopeField(true);
    }
    public APIRequestGet requestScopeField (boolean value) {
      this.requestField("scope", value);
      return this;
    }
    public APIRequestGet requestShowDeprecateAwBannerField () {
      return this.requestShowDeprecateAwBannerField(true);
    }
    public APIRequestGet requestShowDeprecateAwBannerField (boolean value) {
      this.requestField("show_deprecate_aw_banner", value);
      return this;
    }
    public APIRequestGet requestSortingField () {
      return this.requestSortingField(true);
    }
    public APIRequestGet requestSortingField (boolean value) {
      this.requestField("sorting", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestSubscribersField () {
      return this.requestSubscribersField(true);
    }
    public APIRequestGet requestSubscribersField (boolean value) {
      this.requestField("subscribers", value);
      return this;
    }
    public APIRequestGet requestUpdateByField () {
      return this.requestUpdateByField(true);
    }
    public APIRequestGet requestUpdateByField (boolean value) {
      this.requestField("update_by", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGet requestUserDimensionsField () {
      return this.requestUserDimensionsField(true);
    }
    public APIRequestGet requestUserDimensionsField (boolean value) {
      this.requestField("user_dimensions", value);
      return this;
    }
    public APIRequestGet requestUserMetricsField () {
      return this.requestUserMetricsField(true);
    }
    public APIRequestGet requestUserMetricsField (boolean value) {
      this.requestField("user_metrics", value);
      return this;
    }
    public APIRequestGet requestViewTypeField () {
      return this.requestViewTypeField(true);
    }
    public APIRequestGet requestViewTypeField (boolean value) {
      this.requestField("view_type", value);
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

  public AdsReportBuilderSavedReport copyFrom(AdsReportBuilderSavedReport instance) {
    this.mActionReportTime = instance.mActionReportTime;
    this.mAdAccountId = instance.mAdAccountId;
    this.mAttributionWindows = instance.mAttributionWindows;
    this.mComparisonDateInterval = instance.mComparisonDateInterval;
    this.mCreationSource = instance.mCreationSource;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrency = instance.mCurrency;
    this.mDateInterval = instance.mDateInterval;
    this.mDatePreset = instance.mDatePreset;
    this.mDefaultAttributionWindows = instance.mDefaultAttributionWindows;
    this.mDimensionGroups = instance.mDimensionGroups;
    this.mDimensions = instance.mDimensions;
    this.mFiltering = instance.mFiltering;
    this.mFormatting = instance.mFormatting;
    this.mId = instance.mId;
    this.mLastAccessBy = instance.mLastAccessBy;
    this.mLastAccessTime = instance.mLastAccessTime;
    this.mLastReportSnapshotId = instance.mLastReportSnapshotId;
    this.mLastReportSnapshotTime = instance.mLastReportSnapshotTime;
    this.mLastSharedReportExpiration = instance.mLastSharedReportExpiration;
    this.mLimit = instance.mLimit;
    this.mLockedDimensions = instance.mLockedDimensions;
    this.mMetrics = instance.mMetrics;
    this.mReportName = instance.mReportName;
    this.mReportSnapshotAsyncPercentCompletion = instance.mReportSnapshotAsyncPercentCompletion;
    this.mReportSnapshotAsyncStatus = instance.mReportSnapshotAsyncStatus;
    this.mScheduleFrequency = instance.mScheduleFrequency;
    this.mScope = instance.mScope;
    this.mShowDeprecateAwBanner = instance.mShowDeprecateAwBanner;
    this.mSorting = instance.mSorting;
    this.mStartDate = instance.mStartDate;
    this.mStatus = instance.mStatus;
    this.mSubscribers = instance.mSubscribers;
    this.mUpdateBy = instance.mUpdateBy;
    this.mUpdateTime = instance.mUpdateTime;
    this.mUser = instance.mUser;
    this.mUserDimensions = instance.mUserDimensions;
    this.mUserMetrics = instance.mUserMetrics;
    this.mViewType = instance.mViewType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsReportBuilderSavedReport> getParser() {
    return new APIRequest.ResponseParser<AdsReportBuilderSavedReport>() {
      public APINodeList<AdsReportBuilderSavedReport> parseResponse(String response, APIContext context, APIRequest<AdsReportBuilderSavedReport> request, String header) throws MalformedResponseException {
        return AdsReportBuilderSavedReport.parseResponse(response, context, request, header);
      }
    };
  }
}
