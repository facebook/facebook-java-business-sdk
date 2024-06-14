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
public class BrandSafetyDownloadable extends APINode {
  @SerializedName("account_context_id")
  private String mAccountContextId = null;
  @SerializedName("async_job_percent_complete")
  private Long mAsyncJobPercentComplete = null;
  @SerializedName("async_job_status")
  private String mAsyncJobStatus = null;
  @SerializedName("file_name")
  private String mFileName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("request_surface")
  private String mRequestSurface = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  BrandSafetyDownloadable() {
  }

  public BrandSafetyDownloadable(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BrandSafetyDownloadable(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BrandSafetyDownloadable fetch() throws APIException{
    BrandSafetyDownloadable newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BrandSafetyDownloadable fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BrandSafetyDownloadable> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BrandSafetyDownloadable fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BrandSafetyDownloadable> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BrandSafetyDownloadable> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BrandSafetyDownloadable>)(
      new APIRequest<BrandSafetyDownloadable>(context, "", "/", "GET", BrandSafetyDownloadable.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BrandSafetyDownloadable>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BrandSafetyDownloadable.getParser())
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
  public static BrandSafetyDownloadable loadJSON(String json, APIContext context, String header) {
    BrandSafetyDownloadable brandSafetyDownloadable = getGson().fromJson(json, BrandSafetyDownloadable.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(brandSafetyDownloadable.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    brandSafetyDownloadable.context = context;
    brandSafetyDownloadable.rawValue = json;
    brandSafetyDownloadable.header = header;
    return brandSafetyDownloadable;
  }

  public static APINodeList<BrandSafetyDownloadable> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BrandSafetyDownloadable> brandSafetyDownloadables = new APINodeList<BrandSafetyDownloadable>(request, json, header);
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
          brandSafetyDownloadables.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return brandSafetyDownloadables;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                brandSafetyDownloadables.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            brandSafetyDownloadables.setPaging(previous, next);
            if (context.hasAppSecret()) {
              brandSafetyDownloadables.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              brandSafetyDownloadables.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  brandSafetyDownloadables.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              brandSafetyDownloadables.add(loadJSON(obj.toString(), context, header));
            }
          }
          return brandSafetyDownloadables;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              brandSafetyDownloadables.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return brandSafetyDownloadables;
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
              brandSafetyDownloadables.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return brandSafetyDownloadables;
          }

          // Sixth, check if it's pure JsonObject
          brandSafetyDownloadables.clear();
          brandSafetyDownloadables.add(loadJSON(json, context, header));
          return brandSafetyDownloadables;
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


  public String getFieldAccountContextId() {
    return mAccountContextId;
  }

  public Long getFieldAsyncJobPercentComplete() {
    return mAsyncJobPercentComplete;
  }

  public String getFieldAsyncJobStatus() {
    return mAsyncJobStatus;
  }

  public String getFieldFileName() {
    return mFileName;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldRequestSurface() {
    return mRequestSurface;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGet extends APIRequest<BrandSafetyDownloadable> {

    BrandSafetyDownloadable lastResponse = null;
    @Override
    public BrandSafetyDownloadable getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_context_id",
      "async_job_percent_complete",
      "async_job_status",
      "file_name",
      "id",
      "request_surface",
      "url",
    };

    @Override
    public BrandSafetyDownloadable parseResponse(String response, String header) throws APIException {
      return BrandSafetyDownloadable.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BrandSafetyDownloadable execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BrandSafetyDownloadable execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BrandSafetyDownloadable> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BrandSafetyDownloadable> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BrandSafetyDownloadable>() {
           public BrandSafetyDownloadable apply(ResponseWrapper result) {
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

    public APIRequestGet requestAccountContextIdField () {
      return this.requestAccountContextIdField(true);
    }
    public APIRequestGet requestAccountContextIdField (boolean value) {
      this.requestField("account_context_id", value);
      return this;
    }
    public APIRequestGet requestAsyncJobPercentCompleteField () {
      return this.requestAsyncJobPercentCompleteField(true);
    }
    public APIRequestGet requestAsyncJobPercentCompleteField (boolean value) {
      this.requestField("async_job_percent_complete", value);
      return this;
    }
    public APIRequestGet requestAsyncJobStatusField () {
      return this.requestAsyncJobStatusField(true);
    }
    public APIRequestGet requestAsyncJobStatusField (boolean value) {
      this.requestField("async_job_status", value);
      return this;
    }
    public APIRequestGet requestFileNameField () {
      return this.requestFileNameField(true);
    }
    public APIRequestGet requestFileNameField (boolean value) {
      this.requestField("file_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestRequestSurfaceField () {
      return this.requestRequestSurfaceField(true);
    }
    public APIRequestGet requestRequestSurfaceField (boolean value) {
      this.requestField("request_surface", value);
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

  public BrandSafetyDownloadable copyFrom(BrandSafetyDownloadable instance) {
    this.mAccountContextId = instance.mAccountContextId;
    this.mAsyncJobPercentComplete = instance.mAsyncJobPercentComplete;
    this.mAsyncJobStatus = instance.mAsyncJobStatus;
    this.mFileName = instance.mFileName;
    this.mId = instance.mId;
    this.mRequestSurface = instance.mRequestSurface;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BrandSafetyDownloadable> getParser() {
    return new APIRequest.ResponseParser<BrandSafetyDownloadable>() {
      public APINodeList<BrandSafetyDownloadable> parseResponse(String response, APIContext context, APIRequest<BrandSafetyDownloadable> request, String header) throws MalformedResponseException {
        return BrandSafetyDownloadable.parseResponse(response, context, request, header);
      }
    };
  }
}
