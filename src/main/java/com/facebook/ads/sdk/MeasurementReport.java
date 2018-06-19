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
public class MeasurementReport extends APINode {
  @SerializedName("download_urls")
  private List<String> mDownloadUrls = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("metadata")
  private Map<String, String> mMetadata = null;
  @SerializedName("report_type")
  private String mReportType = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("upload_urls")
  private List<String> mUploadUrls = null;
  protected static Gson gson = null;

  MeasurementReport() {
  }

  public MeasurementReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MeasurementReport(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public MeasurementReport fetch() throws APIException{
    MeasurementReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MeasurementReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MeasurementReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MeasurementReport fetchById(String id, APIContext context) throws APIException {
    MeasurementReport measurementReport =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return measurementReport;
  }

  public static ListenableFuture<MeasurementReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<MeasurementReport> measurementReport =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return measurementReport;
  }

  public static APINodeList<MeasurementReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MeasurementReport>)(
      new APIRequest<MeasurementReport>(context, "", "/", "GET", MeasurementReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MeasurementReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<MeasurementReport>> measurementReport =
      new APIRequest(context, "", "/", "GET", MeasurementReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return measurementReport;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static MeasurementReport loadJSON(String json, APIContext context) {
    MeasurementReport measurementReport = getGson().fromJson(json, MeasurementReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(measurementReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    measurementReport.context = context;
    measurementReport.rawValue = json;
    return measurementReport;
  }

  public static APINodeList<MeasurementReport> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<MeasurementReport> measurementReports = new APINodeList<MeasurementReport>(request, json);
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
          measurementReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return measurementReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                measurementReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            measurementReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              measurementReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              measurementReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  measurementReports.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              measurementReports.add(loadJSON(obj.toString(), context));
            }
          }
          return measurementReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              measurementReports.add(loadJSON(entry.getValue().toString(), context));
          }
          return measurementReports;
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
              measurementReports.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return measurementReports;
          }

          // Sixth, check if it's pure JsonObject
          measurementReports.clear();
          measurementReports.add(loadJSON(json, context));
          return measurementReports;
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


  public List<String> getFieldDownloadUrls() {
    return mDownloadUrls;
  }

  public String getFieldId() {
    return mId;
  }

  public Map<String, String> getFieldMetadata() {
    return mMetadata;
  }

  public String getFieldReportType() {
    return mReportType;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldUploadUrls() {
    return mUploadUrls;
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
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
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

  public static class APIRequestGet extends APIRequest<MeasurementReport> {

    MeasurementReport lastResponse = null;
    @Override
    public MeasurementReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "download_urls",
      "id",
      "metadata",
      "report_type",
      "status",
      "upload_urls",
    };

    @Override
    public MeasurementReport parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MeasurementReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementReport execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MeasurementReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MeasurementReport>() {
           public MeasurementReport apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
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

    public APIRequestGet requestDownloadUrlsField () {
      return this.requestDownloadUrlsField(true);
    }
    public APIRequestGet requestDownloadUrlsField (boolean value) {
      this.requestField("download_urls", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGet requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGet requestReportTypeField () {
      return this.requestReportTypeField(true);
    }
    public APIRequestGet requestReportTypeField (boolean value) {
      this.requestField("report_type", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUploadUrlsField () {
      return this.requestUploadUrlsField(true);
    }
    public APIRequestGet requestUploadUrlsField (boolean value) {
      this.requestField("upload_urls", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<MeasurementReport> {

    MeasurementReport lastResponse = null;
    @Override
    public MeasurementReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_last_batch",
      "payload",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MeasurementReport parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MeasurementReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementReport execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MeasurementReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MeasurementReport>() {
           public MeasurementReport apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setIsLastBatch (Boolean isLastBatch) {
      this.setParam("is_last_batch", isLastBatch);
      return this;
    }
    public APIRequestUpdate setIsLastBatch (String isLastBatch) {
      this.setParam("is_last_batch", isLastBatch);
      return this;
    }

    public APIRequestUpdate setPayload (File payload) {
      this.setParam("payload", payload);
      return this;
    }
    public APIRequestUpdate setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
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

  public static enum EnumReportType {
      @SerializedName("multi_channel_report")
      VALUE_MULTI_CHANNEL_REPORT("multi_channel_report"),
      @SerializedName("video_metrics_report")
      VALUE_VIDEO_METRICS_REPORT("video_metrics_report"),
      @SerializedName("fruit_rollup_report")
      VALUE_FRUIT_ROLLUP_REPORT("fruit_rollup_report"),
      @SerializedName("third_party_mta_report")
      VALUE_THIRD_PARTY_MTA_REPORT("third_party_mta_report"),
      @SerializedName("partner_lift_study_report")
      VALUE_PARTNER_LIFT_STUDY_REPORT("partner_lift_study_report"),
      @SerializedName("mmm_report")
      VALUE_MMM_REPORT("mmm_report"),
      NULL(null);

      private String value;

      private EnumReportType(String value) {
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

  public MeasurementReport copyFrom(MeasurementReport instance) {
    this.mDownloadUrls = instance.mDownloadUrls;
    this.mId = instance.mId;
    this.mMetadata = instance.mMetadata;
    this.mReportType = instance.mReportType;
    this.mStatus = instance.mStatus;
    this.mUploadUrls = instance.mUploadUrls;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MeasurementReport> getParser() {
    return new APIRequest.ResponseParser<MeasurementReport>() {
      public APINodeList<MeasurementReport> parseResponse(String response, APIContext context, APIRequest<MeasurementReport> request) throws MalformedResponseException {
        return MeasurementReport.parseResponse(response, context, request);
      }
    };
  }
}
