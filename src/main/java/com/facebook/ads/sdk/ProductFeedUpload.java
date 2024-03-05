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
public class ProductFeedUpload extends APINode {
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("error_count")
  private Long mErrorCount = null;
  @SerializedName("error_report")
  private ProductFeedUploadErrorReport mErrorReport = null;
  @SerializedName("filename")
  private String mFilename = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("input_method")
  private EnumInputMethod mInputMethod = null;
  @SerializedName("num_deleted_items")
  private Long mNumDeletedItems = null;
  @SerializedName("num_detected_items")
  private Long mNumDetectedItems = null;
  @SerializedName("num_invalid_items")
  private Long mNumInvalidItems = null;
  @SerializedName("num_persisted_items")
  private Long mNumPersistedItems = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("warning_count")
  private Long mWarningCount = null;
  protected static Gson gson = null;

  ProductFeedUpload() {
  }

  public ProductFeedUpload(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeedUpload(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductFeedUpload fetch() throws APIException{
    ProductFeedUpload newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeedUpload fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductFeedUpload> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductFeedUpload fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductFeedUpload> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductFeedUpload> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductFeedUpload>)(
      new APIRequest<ProductFeedUpload>(context, "", "/", "GET", ProductFeedUpload.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductFeedUpload>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductFeedUpload.getParser())
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
  public static ProductFeedUpload loadJSON(String json, APIContext context, String header) {
    ProductFeedUpload productFeedUpload = getGson().fromJson(json, ProductFeedUpload.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUpload.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productFeedUpload.context = context;
    productFeedUpload.rawValue = json;
    productFeedUpload.header = header;
    return productFeedUpload;
  }

  public static APINodeList<ProductFeedUpload> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductFeedUpload> productFeedUploads = new APINodeList<ProductFeedUpload>(request, json, header);
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
          productFeedUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productFeedUploads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productFeedUploads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productFeedUploads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productFeedUploads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productFeedUploads.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productFeedUploads.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productFeedUploads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedUploads.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productFeedUploads;
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
              productFeedUploads.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productFeedUploads;
          }

          // Sixth, check if it's pure JsonObject
          productFeedUploads.clear();
          productFeedUploads.add(loadJSON(json, context, header));
          return productFeedUploads;
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

  public APIRequestCreateErrorReport createErrorReport() {
    return new APIRequestCreateErrorReport(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetErrors getErrors() {
    return new APIRequestGetErrors(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldEndTime() {
    return mEndTime;
  }

  public Long getFieldErrorCount() {
    return mErrorCount;
  }

  public ProductFeedUploadErrorReport getFieldErrorReport() {
    return mErrorReport;
  }

  public String getFieldFilename() {
    return mFilename;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumInputMethod getFieldInputMethod() {
    return mInputMethod;
  }

  public Long getFieldNumDeletedItems() {
    return mNumDeletedItems;
  }

  public Long getFieldNumDetectedItems() {
    return mNumDetectedItems;
  }

  public Long getFieldNumInvalidItems() {
    return mNumInvalidItems;
  }

  public Long getFieldNumPersistedItems() {
    return mNumPersistedItems;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public Long getFieldWarningCount() {
    return mWarningCount;
  }



  public static class APIRequestCreateErrorReport extends APIRequest<ProductFeedUpload> {

    ProductFeedUpload lastResponse = null;
    @Override
    public ProductFeedUpload getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductFeedUpload parseResponse(String response, String header) throws APIException {
      return ProductFeedUpload.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductFeedUpload execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUpload execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductFeedUpload> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductFeedUpload> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductFeedUpload>() {
           public ProductFeedUpload apply(ResponseWrapper result) {
             try {
               return APIRequestCreateErrorReport.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateErrorReport(String nodeId, APIContext context) {
      super(context, nodeId, "/error_report", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateErrorReport setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateErrorReport setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateErrorReport requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateErrorReport requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateErrorReport requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateErrorReport requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateErrorReport requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateErrorReport requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetErrors extends APIRequest<ProductFeedUploadError> {

    APINodeList<ProductFeedUploadError> lastResponse = null;
    @Override
    public APINodeList<ProductFeedUploadError> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "error_priority",
    };

    public static final String[] FIELDS = {
      "affected_surfaces",
      "description",
      "error_type",
      "id",
      "severity",
      "summary",
      "total_count",
    };

    @Override
    public APINodeList<ProductFeedUploadError> parseResponse(String response, String header) throws APIException {
      return ProductFeedUploadError.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductFeedUploadError> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUploadError> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductFeedUploadError>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductFeedUploadError>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductFeedUploadError>>() {
           public APINodeList<ProductFeedUploadError> apply(ResponseWrapper result) {
             try {
               return APIRequestGetErrors.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetErrors(String nodeId, APIContext context) {
      super(context, nodeId, "/errors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetErrors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetErrors setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetErrors setErrorPriority (ProductFeedUploadError.EnumErrorPriority errorPriority) {
      this.setParam("error_priority", errorPriority);
      return this;
    }
    public APIRequestGetErrors setErrorPriority (String errorPriority) {
      this.setParam("error_priority", errorPriority);
      return this;
    }

    public APIRequestGetErrors requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetErrors requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetErrors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetErrors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetErrors requestAffectedSurfacesField () {
      return this.requestAffectedSurfacesField(true);
    }
    public APIRequestGetErrors requestAffectedSurfacesField (boolean value) {
      this.requestField("affected_surfaces", value);
      return this;
    }
    public APIRequestGetErrors requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetErrors requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetErrors requestErrorTypeField () {
      return this.requestErrorTypeField(true);
    }
    public APIRequestGetErrors requestErrorTypeField (boolean value) {
      this.requestField("error_type", value);
      return this;
    }
    public APIRequestGetErrors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetErrors requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetErrors requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGetErrors requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGetErrors requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGetErrors requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGetErrors requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGetErrors requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<ProductFeedUpload> {

    ProductFeedUpload lastResponse = null;
    @Override
    public ProductFeedUpload getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "end_time",
      "error_count",
      "error_report",
      "filename",
      "id",
      "input_method",
      "num_deleted_items",
      "num_detected_items",
      "num_invalid_items",
      "num_persisted_items",
      "start_time",
      "url",
      "warning_count",
    };

    @Override
    public ProductFeedUpload parseResponse(String response, String header) throws APIException {
      return ProductFeedUpload.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductFeedUpload execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUpload execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductFeedUpload> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductFeedUpload> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductFeedUpload>() {
           public ProductFeedUpload apply(ResponseWrapper result) {
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

    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestErrorCountField () {
      return this.requestErrorCountField(true);
    }
    public APIRequestGet requestErrorCountField (boolean value) {
      this.requestField("error_count", value);
      return this;
    }
    public APIRequestGet requestErrorReportField () {
      return this.requestErrorReportField(true);
    }
    public APIRequestGet requestErrorReportField (boolean value) {
      this.requestField("error_report", value);
      return this;
    }
    public APIRequestGet requestFilenameField () {
      return this.requestFilenameField(true);
    }
    public APIRequestGet requestFilenameField (boolean value) {
      this.requestField("filename", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInputMethodField () {
      return this.requestInputMethodField(true);
    }
    public APIRequestGet requestInputMethodField (boolean value) {
      this.requestField("input_method", value);
      return this;
    }
    public APIRequestGet requestNumDeletedItemsField () {
      return this.requestNumDeletedItemsField(true);
    }
    public APIRequestGet requestNumDeletedItemsField (boolean value) {
      this.requestField("num_deleted_items", value);
      return this;
    }
    public APIRequestGet requestNumDetectedItemsField () {
      return this.requestNumDetectedItemsField(true);
    }
    public APIRequestGet requestNumDetectedItemsField (boolean value) {
      this.requestField("num_detected_items", value);
      return this;
    }
    public APIRequestGet requestNumInvalidItemsField () {
      return this.requestNumInvalidItemsField(true);
    }
    public APIRequestGet requestNumInvalidItemsField (boolean value) {
      this.requestField("num_invalid_items", value);
      return this;
    }
    public APIRequestGet requestNumPersistedItemsField () {
      return this.requestNumPersistedItemsField(true);
    }
    public APIRequestGet requestNumPersistedItemsField (boolean value) {
      this.requestField("num_persisted_items", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestWarningCountField () {
      return this.requestWarningCountField(true);
    }
    public APIRequestGet requestWarningCountField (boolean value) {
      this.requestField("warning_count", value);
      return this;
    }
  }

  public static enum EnumInputMethod {
      @SerializedName("Google Sheets Fetch")
      VALUE_GOOGLE_SHEETS_FETCH("Google Sheets Fetch"),
      @SerializedName("Manual Upload")
      VALUE_MANUAL_UPLOAD("Manual Upload"),
      @SerializedName("Reupload Last File")
      VALUE_REUPLOAD_LAST_FILE("Reupload Last File"),
      @SerializedName("Server Fetch")
      VALUE_SERVER_FETCH("Server Fetch"),
      @SerializedName("User initiated server fetch")
      VALUE_USER_INITIATED_SERVER_FETCH("User initiated server fetch"),
      ;

      private String value;

      private EnumInputMethod(String value) {
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

  public ProductFeedUpload copyFrom(ProductFeedUpload instance) {
    this.mEndTime = instance.mEndTime;
    this.mErrorCount = instance.mErrorCount;
    this.mErrorReport = instance.mErrorReport;
    this.mFilename = instance.mFilename;
    this.mId = instance.mId;
    this.mInputMethod = instance.mInputMethod;
    this.mNumDeletedItems = instance.mNumDeletedItems;
    this.mNumDetectedItems = instance.mNumDetectedItems;
    this.mNumInvalidItems = instance.mNumInvalidItems;
    this.mNumPersistedItems = instance.mNumPersistedItems;
    this.mStartTime = instance.mStartTime;
    this.mUrl = instance.mUrl;
    this.mWarningCount = instance.mWarningCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUpload> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUpload>() {
      public APINodeList<ProductFeedUpload> parseResponse(String response, APIContext context, APIRequest<ProductFeedUpload> request, String header) throws MalformedResponseException {
        return ProductFeedUpload.parseResponse(response, context, request, header);
      }
    };
  }
}
