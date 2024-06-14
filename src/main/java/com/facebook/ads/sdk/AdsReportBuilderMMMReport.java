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
public class AdsReportBuilderMMMReport extends APINode {
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("export_format")
  private String mExportFormat = null;
  @SerializedName("export_name")
  private String mExportName = null;
  @SerializedName("export_type")
  private String mExportType = null;
  @SerializedName("has_seen")
  private Boolean mHasSeen = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("mmm_status")
  private String mMmmStatus = null;
  @SerializedName("time_start")
  private String mTimeStart = null;
  protected static Gson gson = null;

  AdsReportBuilderMMMReport() {
  }

  public AdsReportBuilderMMMReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsReportBuilderMMMReport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsReportBuilderMMMReport fetch() throws APIException{
    AdsReportBuilderMMMReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsReportBuilderMMMReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsReportBuilderMMMReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsReportBuilderMMMReport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsReportBuilderMMMReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsReportBuilderMMMReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsReportBuilderMMMReport>)(
      new APIRequest<AdsReportBuilderMMMReport>(context, "", "/", "GET", AdsReportBuilderMMMReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsReportBuilderMMMReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsReportBuilderMMMReport.getParser())
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
  public static AdsReportBuilderMMMReport loadJSON(String json, APIContext context, String header) {
    AdsReportBuilderMMMReport adsReportBuilderMMMReport = getGson().fromJson(json, AdsReportBuilderMMMReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsReportBuilderMMMReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsReportBuilderMMMReport.context = context;
    adsReportBuilderMMMReport.rawValue = json;
    adsReportBuilderMMMReport.header = header;
    return adsReportBuilderMMMReport;
  }

  public static APINodeList<AdsReportBuilderMMMReport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsReportBuilderMMMReport> adsReportBuilderMMMReports = new APINodeList<AdsReportBuilderMMMReport>(request, json, header);
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
          adsReportBuilderMMMReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsReportBuilderMMMReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsReportBuilderMMMReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsReportBuilderMMMReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsReportBuilderMMMReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsReportBuilderMMMReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsReportBuilderMMMReports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsReportBuilderMMMReports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsReportBuilderMMMReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsReportBuilderMMMReports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsReportBuilderMMMReports;
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
              adsReportBuilderMMMReports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsReportBuilderMMMReports;
          }

          // Sixth, check if it's pure JsonObject
          adsReportBuilderMMMReports.clear();
          adsReportBuilderMMMReports.add(loadJSON(json, context, header));
          return adsReportBuilderMMMReports;
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


  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public String getFieldExportFormat() {
    return mExportFormat;
  }

  public String getFieldExportName() {
    return mExportName;
  }

  public String getFieldExportType() {
    return mExportType;
  }

  public Boolean getFieldHasSeen() {
    return mHasSeen;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMmmStatus() {
    return mMmmStatus;
  }

  public String getFieldTimeStart() {
    return mTimeStart;
  }



  public static class APIRequestGet extends APIRequest<AdsReportBuilderMMMReport> {

    AdsReportBuilderMMMReport lastResponse = null;
    @Override
    public AdsReportBuilderMMMReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "async_status",
      "export_format",
      "export_name",
      "export_type",
      "has_seen",
      "id",
      "mmm_status",
      "time_start",
    };

    @Override
    public AdsReportBuilderMMMReport parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderMMMReport.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsReportBuilderMMMReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsReportBuilderMMMReport execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsReportBuilderMMMReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsReportBuilderMMMReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsReportBuilderMMMReport>() {
           public AdsReportBuilderMMMReport apply(ResponseWrapper result) {
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

    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGet requestExportFormatField () {
      return this.requestExportFormatField(true);
    }
    public APIRequestGet requestExportFormatField (boolean value) {
      this.requestField("export_format", value);
      return this;
    }
    public APIRequestGet requestExportNameField () {
      return this.requestExportNameField(true);
    }
    public APIRequestGet requestExportNameField (boolean value) {
      this.requestField("export_name", value);
      return this;
    }
    public APIRequestGet requestExportTypeField () {
      return this.requestExportTypeField(true);
    }
    public APIRequestGet requestExportTypeField (boolean value) {
      this.requestField("export_type", value);
      return this;
    }
    public APIRequestGet requestHasSeenField () {
      return this.requestHasSeenField(true);
    }
    public APIRequestGet requestHasSeenField (boolean value) {
      this.requestField("has_seen", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMmmStatusField () {
      return this.requestMmmStatusField(true);
    }
    public APIRequestGet requestMmmStatusField (boolean value) {
      this.requestField("mmm_status", value);
      return this;
    }
    public APIRequestGet requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGet requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
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

  public AdsReportBuilderMMMReport copyFrom(AdsReportBuilderMMMReport instance) {
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mExportFormat = instance.mExportFormat;
    this.mExportName = instance.mExportName;
    this.mExportType = instance.mExportType;
    this.mHasSeen = instance.mHasSeen;
    this.mId = instance.mId;
    this.mMmmStatus = instance.mMmmStatus;
    this.mTimeStart = instance.mTimeStart;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsReportBuilderMMMReport> getParser() {
    return new APIRequest.ResponseParser<AdsReportBuilderMMMReport>() {
      public APINodeList<AdsReportBuilderMMMReport> parseResponse(String response, APIContext context, APIRequest<AdsReportBuilderMMMReport> request, String header) throws MalformedResponseException {
        return AdsReportBuilderMMMReport.parseResponse(response, context, request, header);
      }
    };
  }
}
