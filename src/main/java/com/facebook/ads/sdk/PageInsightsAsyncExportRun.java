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
public class PageInsightsAsyncExportRun extends APINode {
  @SerializedName("data_level")
  private String mDataLevel = null;
  @SerializedName("filters")
  private List<Object> mFilters = null;
  @SerializedName("format")
  private String mFormat = null;
  @SerializedName("gen_report_date")
  private Long mGenReportDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("report_end_date")
  private Long mReportEndDate = null;
  @SerializedName("report_start_date")
  private Long mReportStartDate = null;
  @SerializedName("sorters")
  private List<Object> mSorters = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  PageInsightsAsyncExportRun() {
  }

  public PageInsightsAsyncExportRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageInsightsAsyncExportRun(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PageInsightsAsyncExportRun fetch() throws APIException{
    PageInsightsAsyncExportRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageInsightsAsyncExportRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageInsightsAsyncExportRun> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageInsightsAsyncExportRun fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageInsightsAsyncExportRun> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PageInsightsAsyncExportRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageInsightsAsyncExportRun>)(
      new APIRequest<PageInsightsAsyncExportRun>(context, "", "/", "GET", PageInsightsAsyncExportRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageInsightsAsyncExportRun>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PageInsightsAsyncExportRun.getParser())
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
  public static PageInsightsAsyncExportRun loadJSON(String json, APIContext context, String header) {
    PageInsightsAsyncExportRun pageInsightsAsyncExportRun = getGson().fromJson(json, PageInsightsAsyncExportRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageInsightsAsyncExportRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageInsightsAsyncExportRun.context = context;
    pageInsightsAsyncExportRun.rawValue = json;
    pageInsightsAsyncExportRun.header = header;
    return pageInsightsAsyncExportRun;
  }

  public static APINodeList<PageInsightsAsyncExportRun> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageInsightsAsyncExportRun> pageInsightsAsyncExportRuns = new APINodeList<PageInsightsAsyncExportRun>(request, json, header);
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
          pageInsightsAsyncExportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageInsightsAsyncExportRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageInsightsAsyncExportRuns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageInsightsAsyncExportRuns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageInsightsAsyncExportRuns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageInsightsAsyncExportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageInsightsAsyncExportRuns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageInsightsAsyncExportRuns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageInsightsAsyncExportRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageInsightsAsyncExportRuns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageInsightsAsyncExportRuns;
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
              pageInsightsAsyncExportRuns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageInsightsAsyncExportRuns;
          }

          // Sixth, check if it's pure JsonObject
          pageInsightsAsyncExportRuns.clear();
          pageInsightsAsyncExportRuns.add(loadJSON(json, context, header));
          return pageInsightsAsyncExportRuns;
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


  public String getFieldDataLevel() {
    return mDataLevel;
  }

  public List<Object> getFieldFilters() {
    return mFilters;
  }

  public String getFieldFormat() {
    return mFormat;
  }

  public Long getFieldGenReportDate() {
    return mGenReportDate;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldReportEndDate() {
    return mReportEndDate;
  }

  public Long getFieldReportStartDate() {
    return mReportStartDate;
  }

  public List<Object> getFieldSorters() {
    return mSorters;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGet extends APIRequest<PageInsightsAsyncExportRun> {

    PageInsightsAsyncExportRun lastResponse = null;
    @Override
    public PageInsightsAsyncExportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "data_level",
      "filters",
      "format",
      "gen_report_date",
      "id",
      "report_end_date",
      "report_start_date",
      "sorters",
      "status",
    };

    @Override
    public PageInsightsAsyncExportRun parseResponse(String response, String header) throws APIException {
      return PageInsightsAsyncExportRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageInsightsAsyncExportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageInsightsAsyncExportRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageInsightsAsyncExportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageInsightsAsyncExportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageInsightsAsyncExportRun>() {
           public PageInsightsAsyncExportRun apply(ResponseWrapper result) {
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

    public APIRequestGet requestDataLevelField () {
      return this.requestDataLevelField(true);
    }
    public APIRequestGet requestDataLevelField (boolean value) {
      this.requestField("data_level", value);
      return this;
    }
    public APIRequestGet requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGet requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGet requestFormatField () {
      return this.requestFormatField(true);
    }
    public APIRequestGet requestFormatField (boolean value) {
      this.requestField("format", value);
      return this;
    }
    public APIRequestGet requestGenReportDateField () {
      return this.requestGenReportDateField(true);
    }
    public APIRequestGet requestGenReportDateField (boolean value) {
      this.requestField("gen_report_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestReportEndDateField () {
      return this.requestReportEndDateField(true);
    }
    public APIRequestGet requestReportEndDateField (boolean value) {
      this.requestField("report_end_date", value);
      return this;
    }
    public APIRequestGet requestReportStartDateField () {
      return this.requestReportStartDateField(true);
    }
    public APIRequestGet requestReportStartDateField (boolean value) {
      this.requestField("report_start_date", value);
      return this;
    }
    public APIRequestGet requestSortersField () {
      return this.requestSortersField(true);
    }
    public APIRequestGet requestSortersField (boolean value) {
      this.requestField("sorters", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
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

  public PageInsightsAsyncExportRun copyFrom(PageInsightsAsyncExportRun instance) {
    this.mDataLevel = instance.mDataLevel;
    this.mFilters = instance.mFilters;
    this.mFormat = instance.mFormat;
    this.mGenReportDate = instance.mGenReportDate;
    this.mId = instance.mId;
    this.mReportEndDate = instance.mReportEndDate;
    this.mReportStartDate = instance.mReportStartDate;
    this.mSorters = instance.mSorters;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageInsightsAsyncExportRun> getParser() {
    return new APIRequest.ResponseParser<PageInsightsAsyncExportRun>() {
      public APINodeList<PageInsightsAsyncExportRun> parseResponse(String response, APIContext context, APIRequest<PageInsightsAsyncExportRun> request, String header) throws MalformedResponseException {
        return PageInsightsAsyncExportRun.parseResponse(response, context, request, header);
      }
    };
  }
}
