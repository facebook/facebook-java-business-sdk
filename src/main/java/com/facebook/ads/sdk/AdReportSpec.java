/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
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
public class AdReportSpec extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("actions_group_by")
  private List<String> mActionsGroupBy = null;
  @SerializedName("creation_source")
  private String mCreationSource = null;
  @SerializedName("data_columns")
  private List<String> mDataColumns = null;
  @SerializedName("date_preset")
  private String mDatePreset = null;
  @SerializedName("export_columns")
  private List<String> mExportColumns = null;
  @SerializedName("filters")
  private List<Object> mFilters = null;
  @SerializedName("format_version")
  private Long mFormatVersion = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("insights_section")
  private Object mInsightsSection = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("report_schedule")
  private Object mReportSchedule = null;
  @SerializedName("report_schedule_id")
  private String mReportScheduleId = null;
  @SerializedName("sort_by")
  private String mSortBy = null;
  @SerializedName("sort_dir")
  private String mSortDir = null;
  @SerializedName("time_increment")
  private String mTimeIncrement = null;
  @SerializedName("time_interval")
  private Object mTimeInterval = null;
  @SerializedName("time_ranges")
  private List<Object> mTimeRanges = null;
  protected static Gson gson = null;

  AdReportSpec() {
  }

  public AdReportSpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdReportSpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdReportSpec fetch() throws APIException{
    AdReportSpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdReportSpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdReportSpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdReportSpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdReportSpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdReportSpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdReportSpec>)(
      new APIRequest<AdReportSpec>(context, "", "/", "GET", AdReportSpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdReportSpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdReportSpec.getParser())
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
  public static AdReportSpec loadJSON(String json, APIContext context, String header) {
    AdReportSpec adReportSpec = getGson().fromJson(json, AdReportSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adReportSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adReportSpec.context = context;
    adReportSpec.rawValue = json;
    adReportSpec.header = header;
    return adReportSpec;
  }

  public static APINodeList<AdReportSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdReportSpec> adReportSpecs = new APINodeList<AdReportSpec>(request, json, header);
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
          adReportSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adReportSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adReportSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adReportSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adReportSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adReportSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adReportSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adReportSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adReportSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adReportSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adReportSpecs;
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
              adReportSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adReportSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adReportSpecs.clear();
          adReportSpecs.add(loadJSON(json, context, header));
          return adReportSpecs;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public List<String> getFieldActionsGroupBy() {
    return mActionsGroupBy;
  }

  public String getFieldCreationSource() {
    return mCreationSource;
  }

  public List<String> getFieldDataColumns() {
    return mDataColumns;
  }

  public String getFieldDatePreset() {
    return mDatePreset;
  }

  public List<String> getFieldExportColumns() {
    return mExportColumns;
  }

  public List<Object> getFieldFilters() {
    return mFilters;
  }

  public Long getFieldFormatVersion() {
    return mFormatVersion;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldInsightsSection() {
    return mInsightsSection;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldReportSchedule() {
    return mReportSchedule;
  }

  public String getFieldReportScheduleId() {
    return mReportScheduleId;
  }

  public String getFieldSortBy() {
    return mSortBy;
  }

  public String getFieldSortDir() {
    return mSortDir;
  }

  public String getFieldTimeIncrement() {
    return mTimeIncrement;
  }

  public Object getFieldTimeInterval() {
    return mTimeInterval;
  }

  public List<Object> getFieldTimeRanges() {
    return mTimeRanges;
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
         }
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

  public static class APIRequestGet extends APIRequest<AdReportSpec> {

    AdReportSpec lastResponse = null;
    @Override
    public AdReportSpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actions_group_by",
      "creation_source",
      "data_columns",
      "date_preset",
      "export_columns",
      "filters",
      "format_version",
      "id",
      "insights_section",
      "name",
      "report_schedule",
      "report_schedule_id",
      "sort_by",
      "sort_dir",
      "time_increment",
      "time_interval",
      "time_ranges",
    };

    @Override
    public AdReportSpec parseResponse(String response, String header) throws APIException {
      return AdReportSpec.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportSpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportSpec execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportSpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportSpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportSpec>() {
           public AdReportSpec apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestActionsGroupByField () {
      return this.requestActionsGroupByField(true);
    }
    public APIRequestGet requestActionsGroupByField (boolean value) {
      this.requestField("actions_group_by", value);
      return this;
    }
    public APIRequestGet requestCreationSourceField () {
      return this.requestCreationSourceField(true);
    }
    public APIRequestGet requestCreationSourceField (boolean value) {
      this.requestField("creation_source", value);
      return this;
    }
    public APIRequestGet requestDataColumnsField () {
      return this.requestDataColumnsField(true);
    }
    public APIRequestGet requestDataColumnsField (boolean value) {
      this.requestField("data_columns", value);
      return this;
    }
    public APIRequestGet requestDatePresetField () {
      return this.requestDatePresetField(true);
    }
    public APIRequestGet requestDatePresetField (boolean value) {
      this.requestField("date_preset", value);
      return this;
    }
    public APIRequestGet requestExportColumnsField () {
      return this.requestExportColumnsField(true);
    }
    public APIRequestGet requestExportColumnsField (boolean value) {
      this.requestField("export_columns", value);
      return this;
    }
    public APIRequestGet requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGet requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGet requestFormatVersionField () {
      return this.requestFormatVersionField(true);
    }
    public APIRequestGet requestFormatVersionField (boolean value) {
      this.requestField("format_version", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInsightsSectionField () {
      return this.requestInsightsSectionField(true);
    }
    public APIRequestGet requestInsightsSectionField (boolean value) {
      this.requestField("insights_section", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestReportScheduleField () {
      return this.requestReportScheduleField(true);
    }
    public APIRequestGet requestReportScheduleField (boolean value) {
      this.requestField("report_schedule", value);
      return this;
    }
    public APIRequestGet requestReportScheduleIdField () {
      return this.requestReportScheduleIdField(true);
    }
    public APIRequestGet requestReportScheduleIdField (boolean value) {
      this.requestField("report_schedule_id", value);
      return this;
    }
    public APIRequestGet requestSortByField () {
      return this.requestSortByField(true);
    }
    public APIRequestGet requestSortByField (boolean value) {
      this.requestField("sort_by", value);
      return this;
    }
    public APIRequestGet requestSortDirField () {
      return this.requestSortDirField(true);
    }
    public APIRequestGet requestSortDirField (boolean value) {
      this.requestField("sort_dir", value);
      return this;
    }
    public APIRequestGet requestTimeIncrementField () {
      return this.requestTimeIncrementField(true);
    }
    public APIRequestGet requestTimeIncrementField (boolean value) {
      this.requestField("time_increment", value);
      return this;
    }
    public APIRequestGet requestTimeIntervalField () {
      return this.requestTimeIntervalField(true);
    }
    public APIRequestGet requestTimeIntervalField (boolean value) {
      this.requestField("time_interval", value);
      return this;
    }
    public APIRequestGet requestTimeRangesField () {
      return this.requestTimeRangesField(true);
    }
    public APIRequestGet requestTimeRangesField (boolean value) {
      this.requestField("time_ranges", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdReportSpec> {

    AdReportSpec lastResponse = null;
    @Override
    public AdReportSpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "actions_group_by",
      "business_id",
      "bypass_async",
      "creation_source",
      "data_columns",
      "date_preset",
      "export_columns",
      "filters",
      "format",
      "format_version",
      "insights_section",
      "limit",
      "name",
      "report_run_id",
      "report_schedule_id",
      "sort_by",
      "sort_dir",
      "time_increment",
      "time_interval",
      "time_ranges",
      "user_report",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportSpec parseResponse(String response, String header) throws APIException {
      return AdReportSpec.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportSpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportSpec execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportSpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportSpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportSpec>() {
           public AdReportSpec apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setActionsGroupBy (List<AdReportSpec.EnumActionsGroupBy> actionsGroupBy) {
      this.setParam("actions_group_by", actionsGroupBy);
      return this;
    }
    public APIRequestUpdate setActionsGroupBy (String actionsGroupBy) {
      this.setParam("actions_group_by", actionsGroupBy);
      return this;
    }

    public APIRequestUpdate setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestUpdate setBypassAsync (Boolean bypassAsync) {
      this.setParam("bypass_async", bypassAsync);
      return this;
    }
    public APIRequestUpdate setBypassAsync (String bypassAsync) {
      this.setParam("bypass_async", bypassAsync);
      return this;
    }

    public APIRequestUpdate setCreationSource (AdReportSpec.EnumCreationSource creationSource) {
      this.setParam("creation_source", creationSource);
      return this;
    }
    public APIRequestUpdate setCreationSource (String creationSource) {
      this.setParam("creation_source", creationSource);
      return this;
    }

    public APIRequestUpdate setDataColumns (List<String> dataColumns) {
      this.setParam("data_columns", dataColumns);
      return this;
    }
    public APIRequestUpdate setDataColumns (String dataColumns) {
      this.setParam("data_columns", dataColumns);
      return this;
    }

    public APIRequestUpdate setDatePreset (AdReportSpec.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestUpdate setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestUpdate setExportColumns (Object exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }
    public APIRequestUpdate setExportColumns (String exportColumns) {
      this.setParam("export_columns", exportColumns);
      return this;
    }

    public APIRequestUpdate setFilters (List<Object> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestUpdate setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestUpdate setFormat (AdReportSpec.EnumFormat format) {
      this.setParam("format", format);
      return this;
    }
    public APIRequestUpdate setFormat (String format) {
      this.setParam("format", format);
      return this;
    }

    public APIRequestUpdate setFormatVersion (Long formatVersion) {
      this.setParam("format_version", formatVersion);
      return this;
    }
    public APIRequestUpdate setFormatVersion (String formatVersion) {
      this.setParam("format_version", formatVersion);
      return this;
    }

    public APIRequestUpdate setInsightsSection (Object insightsSection) {
      this.setParam("insights_section", insightsSection);
      return this;
    }
    public APIRequestUpdate setInsightsSection (String insightsSection) {
      this.setParam("insights_section", insightsSection);
      return this;
    }

    public APIRequestUpdate setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestUpdate setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setReportRunId (String reportRunId) {
      this.setParam("report_run_id", reportRunId);
      return this;
    }

    public APIRequestUpdate setReportScheduleId (String reportScheduleId) {
      this.setParam("report_schedule_id", reportScheduleId);
      return this;
    }

    public APIRequestUpdate setSortBy (String sortBy) {
      this.setParam("sort_by", sortBy);
      return this;
    }

    public APIRequestUpdate setSortDir (String sortDir) {
      this.setParam("sort_dir", sortDir);
      return this;
    }

    public APIRequestUpdate setTimeIncrement (String timeIncrement) {
      this.setParam("time_increment", timeIncrement);
      return this;
    }

    public APIRequestUpdate setTimeInterval (Object timeInterval) {
      this.setParam("time_interval", timeInterval);
      return this;
    }
    public APIRequestUpdate setTimeInterval (String timeInterval) {
      this.setParam("time_interval", timeInterval);
      return this;
    }

    public APIRequestUpdate setTimeRanges (JsonArray timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }
    public APIRequestUpdate setTimeRanges (String timeRanges) {
      this.setParam("time_ranges", timeRanges);
      return this;
    }

    public APIRequestUpdate setUserReport (Boolean userReport) {
      this.setParam("user_report", userReport);
      return this;
    }
    public APIRequestUpdate setUserReport (String userReport) {
      this.setParam("user_report", userReport);
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

  public static enum EnumActionsGroupBy {
      @SerializedName("action_brand")
      VALUE_ACTION_BRAND("action_brand"),
      @SerializedName("action_canvas_component_id")
      VALUE_ACTION_CANVAS_COMPONENT_ID("action_canvas_component_id"),
      @SerializedName("action_canvas_component_name")
      VALUE_ACTION_CANVAS_COMPONENT_NAME("action_canvas_component_name"),
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_category")
      VALUE_ACTION_CATEGORY("action_category"),
      @SerializedName("action_converted_brand_tag_id")
      VALUE_ACTION_CONVERTED_BRAND_TAG_ID("action_converted_brand_tag_id"),
      @SerializedName("action_converted_category_tag_id")
      VALUE_ACTION_CONVERTED_CATEGORY_TAG_ID("action_converted_category_tag_id"),
      @SerializedName("action_converted_product_id")
      VALUE_ACTION_CONVERTED_PRODUCT_ID("action_converted_product_id"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_event_channel")
      VALUE_ACTION_EVENT_CHANNEL("action_event_channel"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      @SerializedName("interactive_component_sticker_id")
      VALUE_INTERACTIVE_COMPONENT_STICKER_ID("interactive_component_sticker_id"),
      @SerializedName("interactive_component_sticker_response")
      VALUE_INTERACTIVE_COMPONENT_STICKER_RESPONSE("interactive_component_sticker_response"),
      ;

      private String value;

      private EnumActionsGroupBy(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCreationSource {
      @SerializedName("adsExcelAddin")
      VALUE_ADSEXCELADDIN("adsExcelAddin"),
      @SerializedName("adsManagerReporting")
      VALUE_ADSMANAGERREPORTING("adsManagerReporting"),
      @SerializedName("newAdsManager")
      VALUE_NEWADSMANAGER("newAdsManager"),
      ;

      private String value;

      private EnumCreationSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDatePreset {
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      ;

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFormat {
      @SerializedName("CSV")
      VALUE_CSV("CSV"),
      @SerializedName("JSON")
      VALUE_JSON("JSON"),
      @SerializedName("XLS")
      VALUE_XLS("XLS"),
      @SerializedName("XLSX")
      VALUE_XLSX("XLSX"),
      ;

      private String value;

      private EnumFormat(String value) {
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

  public AdReportSpec copyFrom(AdReportSpec instance) {
    this.mAccountId = instance.mAccountId;
    this.mActionsGroupBy = instance.mActionsGroupBy;
    this.mCreationSource = instance.mCreationSource;
    this.mDataColumns = instance.mDataColumns;
    this.mDatePreset = instance.mDatePreset;
    this.mExportColumns = instance.mExportColumns;
    this.mFilters = instance.mFilters;
    this.mFormatVersion = instance.mFormatVersion;
    this.mId = instance.mId;
    this.mInsightsSection = instance.mInsightsSection;
    this.mName = instance.mName;
    this.mReportSchedule = instance.mReportSchedule;
    this.mReportScheduleId = instance.mReportScheduleId;
    this.mSortBy = instance.mSortBy;
    this.mSortDir = instance.mSortDir;
    this.mTimeIncrement = instance.mTimeIncrement;
    this.mTimeInterval = instance.mTimeInterval;
    this.mTimeRanges = instance.mTimeRanges;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdReportSpec> getParser() {
    return new APIRequest.ResponseParser<AdReportSpec>() {
      public APINodeList<AdReportSpec> parseResponse(String response, APIContext context, APIRequest<AdReportSpec> request, String header) throws MalformedResponseException {
        return AdReportSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
