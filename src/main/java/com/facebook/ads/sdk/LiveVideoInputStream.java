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
public class LiveVideoInputStream extends APINode {
  @SerializedName("dash_ingest_url")
  private String mDashIngestUrl = null;
  @SerializedName("dash_preview_url")
  private String mDashPreviewUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_master")
  private Boolean mIsMaster = null;
  @SerializedName("secure_stream_url")
  private String mSecureStreamUrl = null;
  @SerializedName("stream_health")
  private Object mStreamHealth = null;
  @SerializedName("stream_id")
  private String mStreamId = null;
  @SerializedName("stream_url")
  private String mStreamUrl = null;
  protected static Gson gson = null;

  LiveVideoInputStream() {
  }

  public LiveVideoInputStream(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveVideoInputStream(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveVideoInputStream fetch() throws APIException{
    LiveVideoInputStream newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveVideoInputStream fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveVideoInputStream> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveVideoInputStream fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveVideoInputStream> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveVideoInputStream> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveVideoInputStream>)(
      new APIRequest<LiveVideoInputStream>(context, "", "/", "GET", LiveVideoInputStream.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveVideoInputStream>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveVideoInputStream.getParser())
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
  public static LiveVideoInputStream loadJSON(String json, APIContext context, String header) {
    LiveVideoInputStream liveVideoInputStream = getGson().fromJson(json, LiveVideoInputStream.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveVideoInputStream.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    liveVideoInputStream.context = context;
    liveVideoInputStream.rawValue = json;
    liveVideoInputStream.header = header;
    return liveVideoInputStream;
  }

  public static APINodeList<LiveVideoInputStream> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveVideoInputStream> liveVideoInputStreams = new APINodeList<LiveVideoInputStream>(request, json, header);
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
          liveVideoInputStreams.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveVideoInputStreams;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveVideoInputStreams.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveVideoInputStreams.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveVideoInputStreams.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveVideoInputStreams.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  liveVideoInputStreams.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveVideoInputStreams.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveVideoInputStreams;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveVideoInputStreams.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveVideoInputStreams;
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
              liveVideoInputStreams.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveVideoInputStreams;
          }

          // Sixth, check if it's pure JsonObject
          liveVideoInputStreams.clear();
          liveVideoInputStreams.add(loadJSON(json, context, header));
          return liveVideoInputStreams;
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


  public String getFieldDashIngestUrl() {
    return mDashIngestUrl;
  }

  public String getFieldDashPreviewUrl() {
    return mDashPreviewUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsMaster() {
    return mIsMaster;
  }

  public String getFieldSecureStreamUrl() {
    return mSecureStreamUrl;
  }

  public Object getFieldStreamHealth() {
    return mStreamHealth;
  }

  public String getFieldStreamId() {
    return mStreamId;
  }

  public String getFieldStreamUrl() {
    return mStreamUrl;
  }



  public static class APIRequestGet extends APIRequest<LiveVideoInputStream> {

    LiveVideoInputStream lastResponse = null;
    @Override
    public LiveVideoInputStream getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "target_token",
    };

    public static final String[] FIELDS = {
      "dash_ingest_url",
      "dash_preview_url",
      "id",
      "is_master",
      "secure_stream_url",
      "stream_health",
      "stream_id",
      "stream_url",
    };

    @Override
    public LiveVideoInputStream parseResponse(String response, String header) throws APIException {
      return LiveVideoInputStream.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveVideoInputStream execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideoInputStream execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveVideoInputStream> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideoInputStream> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveVideoInputStream>() {
           public LiveVideoInputStream apply(ResponseWrapper result) {
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


    public APIRequestGet setTargetToken (String targetToken) {
      this.setParam("target_token", targetToken);
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

    public APIRequestGet requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGet requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGet requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGet requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsMasterField () {
      return this.requestIsMasterField(true);
    }
    public APIRequestGet requestIsMasterField (boolean value) {
      this.requestField("is_master", value);
      return this;
    }
    public APIRequestGet requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGet requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGet requestStreamHealthField () {
      return this.requestStreamHealthField(true);
    }
    public APIRequestGet requestStreamHealthField (boolean value) {
      this.requestField("stream_health", value);
      return this;
    }
    public APIRequestGet requestStreamIdField () {
      return this.requestStreamIdField(true);
    }
    public APIRequestGet requestStreamIdField (boolean value) {
      this.requestField("stream_id", value);
      return this;
    }
    public APIRequestGet requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGet requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
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

  public LiveVideoInputStream copyFrom(LiveVideoInputStream instance) {
    this.mDashIngestUrl = instance.mDashIngestUrl;
    this.mDashPreviewUrl = instance.mDashPreviewUrl;
    this.mId = instance.mId;
    this.mIsMaster = instance.mIsMaster;
    this.mSecureStreamUrl = instance.mSecureStreamUrl;
    this.mStreamHealth = instance.mStreamHealth;
    this.mStreamId = instance.mStreamId;
    this.mStreamUrl = instance.mStreamUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveVideoInputStream> getParser() {
    return new APIRequest.ResponseParser<LiveVideoInputStream>() {
      public APINodeList<LiveVideoInputStream> parseResponse(String response, APIContext context, APIRequest<LiveVideoInputStream> request, String header) throws MalformedResponseException {
        return LiveVideoInputStream.parseResponse(response, context, request, header);
      }
    };
  }
}
