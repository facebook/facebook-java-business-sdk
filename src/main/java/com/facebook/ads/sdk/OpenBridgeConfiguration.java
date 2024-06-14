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
public class OpenBridgeConfiguration extends APINode {
  @SerializedName("active")
  private Boolean mActive = null;
  @SerializedName("endpoint")
  private String mEndpoint = null;
  @SerializedName("fallback_domain")
  private String mFallbackDomain = null;
  @SerializedName("fallback_domain_enabled")
  private Boolean mFallbackDomainEnabled = null;
  @SerializedName("host_business_id")
  private String mHostBusinessId = null;
  @SerializedName("host_external_id")
  private String mHostExternalId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instance_id")
  private String mInstanceId = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  protected static Gson gson = null;

  OpenBridgeConfiguration() {
  }

  public OpenBridgeConfiguration(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OpenBridgeConfiguration(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OpenBridgeConfiguration fetch() throws APIException{
    OpenBridgeConfiguration newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OpenBridgeConfiguration fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OpenBridgeConfiguration> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OpenBridgeConfiguration fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OpenBridgeConfiguration> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OpenBridgeConfiguration> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OpenBridgeConfiguration>)(
      new APIRequest<OpenBridgeConfiguration>(context, "", "/", "GET", OpenBridgeConfiguration.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OpenBridgeConfiguration>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OpenBridgeConfiguration.getParser())
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
  public static OpenBridgeConfiguration loadJSON(String json, APIContext context, String header) {
    OpenBridgeConfiguration openBridgeConfiguration = getGson().fromJson(json, OpenBridgeConfiguration.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(openBridgeConfiguration.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    openBridgeConfiguration.context = context;
    openBridgeConfiguration.rawValue = json;
    openBridgeConfiguration.header = header;
    return openBridgeConfiguration;
  }

  public static APINodeList<OpenBridgeConfiguration> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OpenBridgeConfiguration> openBridgeConfigurations = new APINodeList<OpenBridgeConfiguration>(request, json, header);
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
          openBridgeConfigurations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return openBridgeConfigurations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                openBridgeConfigurations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            openBridgeConfigurations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              openBridgeConfigurations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              openBridgeConfigurations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  openBridgeConfigurations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              openBridgeConfigurations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return openBridgeConfigurations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              openBridgeConfigurations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return openBridgeConfigurations;
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
              openBridgeConfigurations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return openBridgeConfigurations;
          }

          // Sixth, check if it's pure JsonObject
          openBridgeConfigurations.clear();
          openBridgeConfigurations.add(loadJSON(json, context, header));
          return openBridgeConfigurations;
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


  public Boolean getFieldActive() {
    return mActive;
  }

  public String getFieldEndpoint() {
    return mEndpoint;
  }

  public String getFieldFallbackDomain() {
    return mFallbackDomain;
  }

  public Boolean getFieldFallbackDomainEnabled() {
    return mFallbackDomainEnabled;
  }

  public String getFieldHostBusinessId() {
    return mHostBusinessId;
  }

  public String getFieldHostExternalId() {
    return mHostExternalId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstanceId() {
    return mInstanceId;
  }

  public String getFieldPixelId() {
    return mPixelId;
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
         },
         MoreExecutors.directExecutor()
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

  public static class APIRequestGet extends APIRequest<OpenBridgeConfiguration> {

    OpenBridgeConfiguration lastResponse = null;
    @Override
    public OpenBridgeConfiguration getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "active",
      "endpoint",
      "fallback_domain",
      "fallback_domain_enabled",
      "host_business_id",
      "host_external_id",
      "id",
      "instance_id",
      "pixel_id",
    };

    @Override
    public OpenBridgeConfiguration parseResponse(String response, String header) throws APIException {
      return OpenBridgeConfiguration.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OpenBridgeConfiguration execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenBridgeConfiguration execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OpenBridgeConfiguration> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenBridgeConfiguration> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OpenBridgeConfiguration>() {
           public OpenBridgeConfiguration apply(ResponseWrapper result) {
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

    public APIRequestGet requestActiveField () {
      return this.requestActiveField(true);
    }
    public APIRequestGet requestActiveField (boolean value) {
      this.requestField("active", value);
      return this;
    }
    public APIRequestGet requestEndpointField () {
      return this.requestEndpointField(true);
    }
    public APIRequestGet requestEndpointField (boolean value) {
      this.requestField("endpoint", value);
      return this;
    }
    public APIRequestGet requestFallbackDomainField () {
      return this.requestFallbackDomainField(true);
    }
    public APIRequestGet requestFallbackDomainField (boolean value) {
      this.requestField("fallback_domain", value);
      return this;
    }
    public APIRequestGet requestFallbackDomainEnabledField () {
      return this.requestFallbackDomainEnabledField(true);
    }
    public APIRequestGet requestFallbackDomainEnabledField (boolean value) {
      this.requestField("fallback_domain_enabled", value);
      return this;
    }
    public APIRequestGet requestHostBusinessIdField () {
      return this.requestHostBusinessIdField(true);
    }
    public APIRequestGet requestHostBusinessIdField (boolean value) {
      this.requestField("host_business_id", value);
      return this;
    }
    public APIRequestGet requestHostExternalIdField () {
      return this.requestHostExternalIdField(true);
    }
    public APIRequestGet requestHostExternalIdField (boolean value) {
      this.requestField("host_external_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInstanceIdField () {
      return this.requestInstanceIdField(true);
    }
    public APIRequestGet requestInstanceIdField (boolean value) {
      this.requestField("instance_id", value);
      return this;
    }
    public APIRequestGet requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGet requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<OpenBridgeConfiguration> {

    OpenBridgeConfiguration lastResponse = null;
    @Override
    public OpenBridgeConfiguration getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "active",
      "endpoint",
      "fallback_domain",
      "fallback_domain_enabled",
      "host_business_id",
      "host_external_id",
      "instance_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OpenBridgeConfiguration parseResponse(String response, String header) throws APIException {
      return OpenBridgeConfiguration.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OpenBridgeConfiguration execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenBridgeConfiguration execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OpenBridgeConfiguration> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenBridgeConfiguration> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OpenBridgeConfiguration>() {
           public OpenBridgeConfiguration apply(ResponseWrapper result) {
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


    public APIRequestUpdate setActive (Boolean active) {
      this.setParam("active", active);
      return this;
    }
    public APIRequestUpdate setActive (String active) {
      this.setParam("active", active);
      return this;
    }

    public APIRequestUpdate setEndpoint (String endpoint) {
      this.setParam("endpoint", endpoint);
      return this;
    }

    public APIRequestUpdate setFallbackDomain (String fallbackDomain) {
      this.setParam("fallback_domain", fallbackDomain);
      return this;
    }

    public APIRequestUpdate setFallbackDomainEnabled (Boolean fallbackDomainEnabled) {
      this.setParam("fallback_domain_enabled", fallbackDomainEnabled);
      return this;
    }
    public APIRequestUpdate setFallbackDomainEnabled (String fallbackDomainEnabled) {
      this.setParam("fallback_domain_enabled", fallbackDomainEnabled);
      return this;
    }

    public APIRequestUpdate setHostBusinessId (Long hostBusinessId) {
      this.setParam("host_business_id", hostBusinessId);
      return this;
    }
    public APIRequestUpdate setHostBusinessId (String hostBusinessId) {
      this.setParam("host_business_id", hostBusinessId);
      return this;
    }

    public APIRequestUpdate setHostExternalId (String hostExternalId) {
      this.setParam("host_external_id", hostExternalId);
      return this;
    }

    public APIRequestUpdate setInstanceId (String instanceId) {
      this.setParam("instance_id", instanceId);
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

  public OpenBridgeConfiguration copyFrom(OpenBridgeConfiguration instance) {
    this.mActive = instance.mActive;
    this.mEndpoint = instance.mEndpoint;
    this.mFallbackDomain = instance.mFallbackDomain;
    this.mFallbackDomainEnabled = instance.mFallbackDomainEnabled;
    this.mHostBusinessId = instance.mHostBusinessId;
    this.mHostExternalId = instance.mHostExternalId;
    this.mId = instance.mId;
    this.mInstanceId = instance.mInstanceId;
    this.mPixelId = instance.mPixelId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OpenBridgeConfiguration> getParser() {
    return new APIRequest.ResponseParser<OpenBridgeConfiguration>() {
      public APINodeList<OpenBridgeConfiguration> parseResponse(String response, APIContext context, APIRequest<OpenBridgeConfiguration> request, String header) throws MalformedResponseException {
        return OpenBridgeConfiguration.parseResponse(response, context, request, header);
      }
    };
  }
}
