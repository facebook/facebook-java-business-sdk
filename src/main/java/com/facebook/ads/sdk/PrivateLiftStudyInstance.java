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
public class PrivateLiftStudyInstance extends APINode {
  @SerializedName("breakdown_key")
  private String mBreakdownKey = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("feature_list")
  private List<String> mFeatureList = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("issuer_certificate")
  private String mIssuerCertificate = null;
  @SerializedName("latest_status_update_time")
  private String mLatestStatusUpdateTime = null;
  @SerializedName("run_id")
  private String mRunId = null;
  @SerializedName("server_hostnames")
  private List<String> mServerHostnames = null;
  @SerializedName("server_ips")
  private List<String> mServerIps = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tier")
  private String mTier = null;
  protected static Gson gson = null;

  PrivateLiftStudyInstance() {
  }

  public PrivateLiftStudyInstance(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PrivateLiftStudyInstance(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PrivateLiftStudyInstance fetch() throws APIException{
    PrivateLiftStudyInstance newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PrivateLiftStudyInstance fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PrivateLiftStudyInstance> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PrivateLiftStudyInstance fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PrivateLiftStudyInstance> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PrivateLiftStudyInstance> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PrivateLiftStudyInstance>)(
      new APIRequest<PrivateLiftStudyInstance>(context, "", "/", "GET", PrivateLiftStudyInstance.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PrivateLiftStudyInstance>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PrivateLiftStudyInstance.getParser())
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
  public static PrivateLiftStudyInstance loadJSON(String json, APIContext context, String header) {
    PrivateLiftStudyInstance privateLiftStudyInstance = getGson().fromJson(json, PrivateLiftStudyInstance.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(privateLiftStudyInstance.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    privateLiftStudyInstance.context = context;
    privateLiftStudyInstance.rawValue = json;
    privateLiftStudyInstance.header = header;
    return privateLiftStudyInstance;
  }

  public static APINodeList<PrivateLiftStudyInstance> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PrivateLiftStudyInstance> privateLiftStudyInstances = new APINodeList<PrivateLiftStudyInstance>(request, json, header);
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
          privateLiftStudyInstances.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return privateLiftStudyInstances;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                privateLiftStudyInstances.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            privateLiftStudyInstances.setPaging(previous, next);
            if (context.hasAppSecret()) {
              privateLiftStudyInstances.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              privateLiftStudyInstances.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  privateLiftStudyInstances.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              privateLiftStudyInstances.add(loadJSON(obj.toString(), context, header));
            }
          }
          return privateLiftStudyInstances;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              privateLiftStudyInstances.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return privateLiftStudyInstances;
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
              privateLiftStudyInstances.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return privateLiftStudyInstances;
          }

          // Sixth, check if it's pure JsonObject
          privateLiftStudyInstances.clear();
          privateLiftStudyInstances.add(loadJSON(json, context, header));
          return privateLiftStudyInstances;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldBreakdownKey() {
    return mBreakdownKey;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<String> getFieldFeatureList() {
    return mFeatureList;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIssuerCertificate() {
    return mIssuerCertificate;
  }

  public String getFieldLatestStatusUpdateTime() {
    return mLatestStatusUpdateTime;
  }

  public String getFieldRunId() {
    return mRunId;
  }

  public List<String> getFieldServerHostnames() {
    return mServerHostnames;
  }

  public List<String> getFieldServerIps() {
    return mServerIps;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldTier() {
    return mTier;
  }



  public static class APIRequestGet extends APIRequest<PrivateLiftStudyInstance> {

    PrivateLiftStudyInstance lastResponse = null;
    @Override
    public PrivateLiftStudyInstance getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "breakdown_key",
      "created_time",
      "feature_list",
      "id",
      "issuer_certificate",
      "latest_status_update_time",
      "run_id",
      "server_hostnames",
      "server_ips",
      "status",
      "tier",
    };

    @Override
    public PrivateLiftStudyInstance parseResponse(String response, String header) throws APIException {
      return PrivateLiftStudyInstance.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PrivateLiftStudyInstance execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PrivateLiftStudyInstance execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PrivateLiftStudyInstance>() {
           public PrivateLiftStudyInstance apply(ResponseWrapper result) {
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

    public APIRequestGet requestBreakdownKeyField () {
      return this.requestBreakdownKeyField(true);
    }
    public APIRequestGet requestBreakdownKeyField (boolean value) {
      this.requestField("breakdown_key", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestFeatureListField () {
      return this.requestFeatureListField(true);
    }
    public APIRequestGet requestFeatureListField (boolean value) {
      this.requestField("feature_list", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIssuerCertificateField () {
      return this.requestIssuerCertificateField(true);
    }
    public APIRequestGet requestIssuerCertificateField (boolean value) {
      this.requestField("issuer_certificate", value);
      return this;
    }
    public APIRequestGet requestLatestStatusUpdateTimeField () {
      return this.requestLatestStatusUpdateTimeField(true);
    }
    public APIRequestGet requestLatestStatusUpdateTimeField (boolean value) {
      this.requestField("latest_status_update_time", value);
      return this;
    }
    public APIRequestGet requestRunIdField () {
      return this.requestRunIdField(true);
    }
    public APIRequestGet requestRunIdField (boolean value) {
      this.requestField("run_id", value);
      return this;
    }
    public APIRequestGet requestServerHostnamesField () {
      return this.requestServerHostnamesField(true);
    }
    public APIRequestGet requestServerHostnamesField (boolean value) {
      this.requestField("server_hostnames", value);
      return this;
    }
    public APIRequestGet requestServerIpsField () {
      return this.requestServerIpsField(true);
    }
    public APIRequestGet requestServerIpsField (boolean value) {
      this.requestField("server_ips", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTierField () {
      return this.requestTierField(true);
    }
    public APIRequestGet requestTierField (boolean value) {
      this.requestField("tier", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<PrivateLiftStudyInstance> {

    PrivateLiftStudyInstance lastResponse = null;
    @Override
    public PrivateLiftStudyInstance getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "operation",
      "run_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PrivateLiftStudyInstance parseResponse(String response, String header) throws APIException {
      return PrivateLiftStudyInstance.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PrivateLiftStudyInstance execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PrivateLiftStudyInstance execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PrivateLiftStudyInstance>() {
           public PrivateLiftStudyInstance apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestUpdate setOperation (PrivateLiftStudyInstance.EnumOperation operation) {
      this.setParam("operation", operation);
      return this;
    }
    public APIRequestUpdate setOperation (String operation) {
      this.setParam("operation", operation);
      return this;
    }

    public APIRequestUpdate setRunId (String runId) {
      this.setParam("run_id", runId);
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

  public static enum EnumOperation {
      @SerializedName("AGGREGATE")
      VALUE_AGGREGATE("AGGREGATE"),
      @SerializedName("CANCEL")
      VALUE_CANCEL("CANCEL"),
      @SerializedName("COMPUTE")
      VALUE_COMPUTE("COMPUTE"),
      @SerializedName("ID_MATCH")
      VALUE_ID_MATCH("ID_MATCH"),
      @SerializedName("NEXT")
      VALUE_NEXT("NEXT"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      ;

      private String value;

      private EnumOperation(String value) {
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

  public PrivateLiftStudyInstance copyFrom(PrivateLiftStudyInstance instance) {
    this.mBreakdownKey = instance.mBreakdownKey;
    this.mCreatedTime = instance.mCreatedTime;
    this.mFeatureList = instance.mFeatureList;
    this.mId = instance.mId;
    this.mIssuerCertificate = instance.mIssuerCertificate;
    this.mLatestStatusUpdateTime = instance.mLatestStatusUpdateTime;
    this.mRunId = instance.mRunId;
    this.mServerHostnames = instance.mServerHostnames;
    this.mServerIps = instance.mServerIps;
    this.mStatus = instance.mStatus;
    this.mTier = instance.mTier;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PrivateLiftStudyInstance> getParser() {
    return new APIRequest.ResponseParser<PrivateLiftStudyInstance>() {
      public APINodeList<PrivateLiftStudyInstance> parseResponse(String response, APIContext context, APIRequest<PrivateLiftStudyInstance> request, String header) throws MalformedResponseException {
        return PrivateLiftStudyInstance.parseResponse(response, context, request, header);
      }
    };
  }
}
