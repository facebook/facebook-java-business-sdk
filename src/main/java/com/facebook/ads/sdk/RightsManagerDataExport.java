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
public class RightsManagerDataExport extends APINode {
  @SerializedName("download_uri")
  private String mDownloadUri = null;
  @SerializedName("export_scope")
  private String mExportScope = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("record_type")
  private String mRecordType = null;
  @SerializedName("time_range_end")
  private String mTimeRangeEnd = null;
  @SerializedName("time_range_start")
  private String mTimeRangeStart = null;
  protected static Gson gson = null;

  RightsManagerDataExport() {
  }

  public RightsManagerDataExport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public RightsManagerDataExport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public RightsManagerDataExport fetch() throws APIException{
    RightsManagerDataExport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static RightsManagerDataExport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<RightsManagerDataExport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static RightsManagerDataExport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<RightsManagerDataExport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<RightsManagerDataExport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<RightsManagerDataExport>)(
      new APIRequest<RightsManagerDataExport>(context, "", "/", "GET", RightsManagerDataExport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<RightsManagerDataExport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", RightsManagerDataExport.getParser())
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
  public static RightsManagerDataExport loadJSON(String json, APIContext context, String header) {
    RightsManagerDataExport rightsManagerDataExport = getGson().fromJson(json, RightsManagerDataExport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(rightsManagerDataExport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    rightsManagerDataExport.context = context;
    rightsManagerDataExport.rawValue = json;
    rightsManagerDataExport.header = header;
    return rightsManagerDataExport;
  }

  public static APINodeList<RightsManagerDataExport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<RightsManagerDataExport> rightsManagerDataExports = new APINodeList<RightsManagerDataExport>(request, json, header);
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
          rightsManagerDataExports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return rightsManagerDataExports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                rightsManagerDataExports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            rightsManagerDataExports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              rightsManagerDataExports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              rightsManagerDataExports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  rightsManagerDataExports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              rightsManagerDataExports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return rightsManagerDataExports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              rightsManagerDataExports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return rightsManagerDataExports;
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
              rightsManagerDataExports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return rightsManagerDataExports;
          }

          // Sixth, check if it's pure JsonObject
          rightsManagerDataExports.clear();
          rightsManagerDataExports.add(loadJSON(json, context, header));
          return rightsManagerDataExports;
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


  public String getFieldDownloadUri() {
    return mDownloadUri;
  }

  public String getFieldExportScope() {
    return mExportScope;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldRecordType() {
    return mRecordType;
  }

  public String getFieldTimeRangeEnd() {
    return mTimeRangeEnd;
  }

  public String getFieldTimeRangeStart() {
    return mTimeRangeStart;
  }



  public static class APIRequestGet extends APIRequest<RightsManagerDataExport> {

    RightsManagerDataExport lastResponse = null;
    @Override
    public RightsManagerDataExport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "download_uri",
      "export_scope",
      "id",
      "name",
      "record_type",
      "time_range_end",
      "time_range_start",
    };

    @Override
    public RightsManagerDataExport parseResponse(String response, String header) throws APIException {
      return RightsManagerDataExport.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public RightsManagerDataExport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public RightsManagerDataExport execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<RightsManagerDataExport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<RightsManagerDataExport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, RightsManagerDataExport>() {
           public RightsManagerDataExport apply(ResponseWrapper result) {
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

    public APIRequestGet requestDownloadUriField () {
      return this.requestDownloadUriField(true);
    }
    public APIRequestGet requestDownloadUriField (boolean value) {
      this.requestField("download_uri", value);
      return this;
    }
    public APIRequestGet requestExportScopeField () {
      return this.requestExportScopeField(true);
    }
    public APIRequestGet requestExportScopeField (boolean value) {
      this.requestField("export_scope", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestRecordTypeField () {
      return this.requestRecordTypeField(true);
    }
    public APIRequestGet requestRecordTypeField (boolean value) {
      this.requestField("record_type", value);
      return this;
    }
    public APIRequestGet requestTimeRangeEndField () {
      return this.requestTimeRangeEndField(true);
    }
    public APIRequestGet requestTimeRangeEndField (boolean value) {
      this.requestField("time_range_end", value);
      return this;
    }
    public APIRequestGet requestTimeRangeStartField () {
      return this.requestTimeRangeStartField(true);
    }
    public APIRequestGet requestTimeRangeStartField (boolean value) {
      this.requestField("time_range_start", value);
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

  public RightsManagerDataExport copyFrom(RightsManagerDataExport instance) {
    this.mDownloadUri = instance.mDownloadUri;
    this.mExportScope = instance.mExportScope;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mRecordType = instance.mRecordType;
    this.mTimeRangeEnd = instance.mTimeRangeEnd;
    this.mTimeRangeStart = instance.mTimeRangeStart;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<RightsManagerDataExport> getParser() {
    return new APIRequest.ResponseParser<RightsManagerDataExport>() {
      public APINodeList<RightsManagerDataExport> parseResponse(String response, APIContext context, APIRequest<RightsManagerDataExport> request, String header) throws MalformedResponseException {
        return RightsManagerDataExport.parseResponse(response, context, request, header);
      }
    };
  }
}
