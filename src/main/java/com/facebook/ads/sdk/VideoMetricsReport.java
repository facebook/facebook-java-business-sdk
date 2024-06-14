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
public class VideoMetricsReport extends APINode {
  @SerializedName("checksum")
  private String mChecksum = null;
  @SerializedName("chunks")
  private Long mChunks = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("index")
  private Long mIndex = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("platform")
  private String mPlatform = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("upload_date")
  private String mUploadDate = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  VideoMetricsReport() {
  }

  public VideoMetricsReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoMetricsReport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoMetricsReport fetch() throws APIException{
    VideoMetricsReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoMetricsReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoMetricsReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoMetricsReport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoMetricsReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoMetricsReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoMetricsReport>)(
      new APIRequest<VideoMetricsReport>(context, "", "/", "GET", VideoMetricsReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoMetricsReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoMetricsReport.getParser())
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
  public static VideoMetricsReport loadJSON(String json, APIContext context, String header) {
    VideoMetricsReport videoMetricsReport = getGson().fromJson(json, VideoMetricsReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoMetricsReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoMetricsReport.context = context;
    videoMetricsReport.rawValue = json;
    videoMetricsReport.header = header;
    return videoMetricsReport;
  }

  public static APINodeList<VideoMetricsReport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoMetricsReport> videoMetricsReports = new APINodeList<VideoMetricsReport>(request, json, header);
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
          videoMetricsReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoMetricsReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoMetricsReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoMetricsReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoMetricsReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoMetricsReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoMetricsReports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoMetricsReports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoMetricsReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoMetricsReports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoMetricsReports;
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
              videoMetricsReports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoMetricsReports;
          }

          // Sixth, check if it's pure JsonObject
          videoMetricsReports.clear();
          videoMetricsReports.add(loadJSON(json, context, header));
          return videoMetricsReports;
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


  public String getFieldChecksum() {
    return mChecksum;
  }

  public Long getFieldChunks() {
    return mChunks;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIndex() {
    return mIndex;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPlatform() {
    return mPlatform;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUploadDate() {
    return mUploadDate;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGet extends APIRequest<VideoMetricsReport> {

    VideoMetricsReport lastResponse = null;
    @Override
    public VideoMetricsReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "checksum",
      "chunks",
      "end_date",
      "id",
      "index",
      "name",
      "platform",
      "start_date",
      "type",
      "upload_date",
      "url",
    };

    @Override
    public VideoMetricsReport parseResponse(String response, String header) throws APIException {
      return VideoMetricsReport.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoMetricsReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoMetricsReport execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoMetricsReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoMetricsReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoMetricsReport>() {
           public VideoMetricsReport apply(ResponseWrapper result) {
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

    public APIRequestGet requestChecksumField () {
      return this.requestChecksumField(true);
    }
    public APIRequestGet requestChecksumField (boolean value) {
      this.requestField("checksum", value);
      return this;
    }
    public APIRequestGet requestChunksField () {
      return this.requestChunksField(true);
    }
    public APIRequestGet requestChunksField (boolean value) {
      this.requestField("chunks", value);
      return this;
    }
    public APIRequestGet requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGet requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIndexField () {
      return this.requestIndexField(true);
    }
    public APIRequestGet requestIndexField (boolean value) {
      this.requestField("index", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGet requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUploadDateField () {
      return this.requestUploadDateField(true);
    }
    public APIRequestGet requestUploadDateField (boolean value) {
      this.requestField("upload_date", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
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

  public VideoMetricsReport copyFrom(VideoMetricsReport instance) {
    this.mChecksum = instance.mChecksum;
    this.mChunks = instance.mChunks;
    this.mEndDate = instance.mEndDate;
    this.mId = instance.mId;
    this.mIndex = instance.mIndex;
    this.mName = instance.mName;
    this.mPlatform = instance.mPlatform;
    this.mStartDate = instance.mStartDate;
    this.mType = instance.mType;
    this.mUploadDate = instance.mUploadDate;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoMetricsReport> getParser() {
    return new APIRequest.ResponseParser<VideoMetricsReport>() {
      public APINodeList<VideoMetricsReport> parseResponse(String response, APIContext context, APIRequest<VideoMetricsReport> request, String header) throws MalformedResponseException {
        return VideoMetricsReport.parseResponse(response, context, request, header);
      }
    };
  }
}
