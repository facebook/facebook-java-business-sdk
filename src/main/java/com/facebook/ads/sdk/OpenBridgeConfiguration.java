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
  @SerializedName("browser_agent")
  private List<String> mBrowserAgent = null;
  @SerializedName("cloud_provider")
  private String mCloudProvider = null;
  @SerializedName("cloud_region")
  private String mCloudRegion = null;
  @SerializedName("destination_id")
  private String mDestinationId = null;
  @SerializedName("endpoint")
  private String mEndpoint = null;
  @SerializedName("fallback_domain")
  private String mFallbackDomain = null;
  @SerializedName("first_party_domain")
  private String mFirstPartyDomain = null;
  @SerializedName("host_business_id")
  private String mHostBusinessId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instance_id")
  private String mInstanceId = null;
  @SerializedName("instance_version")
  private String mInstanceVersion = null;
  @SerializedName("is_sgw_instance")
  private Boolean mIsSgwInstance = null;
  @SerializedName("is_sgw_pixel_from_meta_pixel")
  private Boolean mIsSgwPixelFromMetaPixel = null;
  @SerializedName("partner_name")
  private String mPartnerName = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("sgw_account_id")
  private String mSgwAccountId = null;
  @SerializedName("sgw_instance_url")
  private String mSgwInstanceUrl = null;
  @SerializedName("sgw_pixel_id")
  private String mSgwPixelId = null;
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

  public List<String> getFieldBrowserAgent() {
    return mBrowserAgent;
  }

  public String getFieldCloudProvider() {
    return mCloudProvider;
  }

  public String getFieldCloudRegion() {
    return mCloudRegion;
  }

  public String getFieldDestinationId() {
    return mDestinationId;
  }

  public String getFieldEndpoint() {
    return mEndpoint;
  }

  public String getFieldFallbackDomain() {
    return mFallbackDomain;
  }

  public String getFieldFirstPartyDomain() {
    return mFirstPartyDomain;
  }

  public String getFieldHostBusinessId() {
    return mHostBusinessId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstanceId() {
    return mInstanceId;
  }

  public String getFieldInstanceVersion() {
    return mInstanceVersion;
  }

  public Boolean getFieldIsSgwInstance() {
    return mIsSgwInstance;
  }

  public Boolean getFieldIsSgwPixelFromMetaPixel() {
    return mIsSgwPixelFromMetaPixel;
  }

  public String getFieldPartnerName() {
    return mPartnerName;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public String getFieldSgwAccountId() {
    return mSgwAccountId;
  }

  public String getFieldSgwInstanceUrl() {
    return mSgwInstanceUrl;
  }

  public String getFieldSgwPixelId() {
    return mSgwPixelId;
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
      "browser_agent",
      "cloud_provider",
      "cloud_region",
      "destination_id",
      "endpoint",
      "fallback_domain",
      "first_party_domain",
      "host_business_id",
      "id",
      "instance_id",
      "instance_version",
      "is_sgw_instance",
      "is_sgw_pixel_from_meta_pixel",
      "partner_name",
      "pixel_id",
      "sgw_account_id",
      "sgw_instance_url",
      "sgw_pixel_id",
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
    public APIRequestGet requestBrowserAgentField () {
      return this.requestBrowserAgentField(true);
    }
    public APIRequestGet requestBrowserAgentField (boolean value) {
      this.requestField("browser_agent", value);
      return this;
    }
    public APIRequestGet requestCloudProviderField () {
      return this.requestCloudProviderField(true);
    }
    public APIRequestGet requestCloudProviderField (boolean value) {
      this.requestField("cloud_provider", value);
      return this;
    }
    public APIRequestGet requestCloudRegionField () {
      return this.requestCloudRegionField(true);
    }
    public APIRequestGet requestCloudRegionField (boolean value) {
      this.requestField("cloud_region", value);
      return this;
    }
    public APIRequestGet requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGet requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
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
    public APIRequestGet requestFirstPartyDomainField () {
      return this.requestFirstPartyDomainField(true);
    }
    public APIRequestGet requestFirstPartyDomainField (boolean value) {
      this.requestField("first_party_domain", value);
      return this;
    }
    public APIRequestGet requestHostBusinessIdField () {
      return this.requestHostBusinessIdField(true);
    }
    public APIRequestGet requestHostBusinessIdField (boolean value) {
      this.requestField("host_business_id", value);
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
    public APIRequestGet requestInstanceVersionField () {
      return this.requestInstanceVersionField(true);
    }
    public APIRequestGet requestInstanceVersionField (boolean value) {
      this.requestField("instance_version", value);
      return this;
    }
    public APIRequestGet requestIsSgwInstanceField () {
      return this.requestIsSgwInstanceField(true);
    }
    public APIRequestGet requestIsSgwInstanceField (boolean value) {
      this.requestField("is_sgw_instance", value);
      return this;
    }
    public APIRequestGet requestIsSgwPixelFromMetaPixelField () {
      return this.requestIsSgwPixelFromMetaPixelField(true);
    }
    public APIRequestGet requestIsSgwPixelFromMetaPixelField (boolean value) {
      this.requestField("is_sgw_pixel_from_meta_pixel", value);
      return this;
    }
    public APIRequestGet requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGet requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGet requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGet requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGet requestSgwAccountIdField () {
      return this.requestSgwAccountIdField(true);
    }
    public APIRequestGet requestSgwAccountIdField (boolean value) {
      this.requestField("sgw_account_id", value);
      return this;
    }
    public APIRequestGet requestSgwInstanceUrlField () {
      return this.requestSgwInstanceUrlField(true);
    }
    public APIRequestGet requestSgwInstanceUrlField (boolean value) {
      this.requestField("sgw_instance_url", value);
      return this;
    }
    public APIRequestGet requestSgwPixelIdField () {
      return this.requestSgwPixelIdField(true);
    }
    public APIRequestGet requestSgwPixelIdField (boolean value) {
      this.requestField("sgw_pixel_id", value);
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
      "cloud_provider",
      "cloud_region",
      "destination_id",
      "endpoint",
      "fallback_domain",
      "first_party_domain",
      "host_business_id",
      "instance_id",
      "instance_version",
      "is_sgw_instance",
      "is_sgw_pixel_from_meta_pixel",
      "partner_name",
      "sgw_account_id",
      "sgw_instance_url",
      "sgw_pixel_id",
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

    public APIRequestUpdate setCloudProvider (String cloudProvider) {
      this.setParam("cloud_provider", cloudProvider);
      return this;
    }

    public APIRequestUpdate setCloudRegion (String cloudRegion) {
      this.setParam("cloud_region", cloudRegion);
      return this;
    }

    public APIRequestUpdate setDestinationId (String destinationId) {
      this.setParam("destination_id", destinationId);
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

    public APIRequestUpdate setFirstPartyDomain (String firstPartyDomain) {
      this.setParam("first_party_domain", firstPartyDomain);
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

    public APIRequestUpdate setInstanceId (String instanceId) {
      this.setParam("instance_id", instanceId);
      return this;
    }

    public APIRequestUpdate setInstanceVersion (String instanceVersion) {
      this.setParam("instance_version", instanceVersion);
      return this;
    }

    public APIRequestUpdate setIsSgwInstance (Boolean isSgwInstance) {
      this.setParam("is_sgw_instance", isSgwInstance);
      return this;
    }
    public APIRequestUpdate setIsSgwInstance (String isSgwInstance) {
      this.setParam("is_sgw_instance", isSgwInstance);
      return this;
    }

    public APIRequestUpdate setIsSgwPixelFromMetaPixel (Boolean isSgwPixelFromMetaPixel) {
      this.setParam("is_sgw_pixel_from_meta_pixel", isSgwPixelFromMetaPixel);
      return this;
    }
    public APIRequestUpdate setIsSgwPixelFromMetaPixel (String isSgwPixelFromMetaPixel) {
      this.setParam("is_sgw_pixel_from_meta_pixel", isSgwPixelFromMetaPixel);
      return this;
    }

    public APIRequestUpdate setPartnerName (String partnerName) {
      this.setParam("partner_name", partnerName);
      return this;
    }

    public APIRequestUpdate setSgwAccountId (String sgwAccountId) {
      this.setParam("sgw_account_id", sgwAccountId);
      return this;
    }

    public APIRequestUpdate setSgwInstanceUrl (String sgwInstanceUrl) {
      this.setParam("sgw_instance_url", sgwInstanceUrl);
      return this;
    }

    public APIRequestUpdate setSgwPixelId (Long sgwPixelId) {
      this.setParam("sgw_pixel_id", sgwPixelId);
      return this;
    }
    public APIRequestUpdate setSgwPixelId (String sgwPixelId) {
      this.setParam("sgw_pixel_id", sgwPixelId);
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
    this.mBrowserAgent = instance.mBrowserAgent;
    this.mCloudProvider = instance.mCloudProvider;
    this.mCloudRegion = instance.mCloudRegion;
    this.mDestinationId = instance.mDestinationId;
    this.mEndpoint = instance.mEndpoint;
    this.mFallbackDomain = instance.mFallbackDomain;
    this.mFirstPartyDomain = instance.mFirstPartyDomain;
    this.mHostBusinessId = instance.mHostBusinessId;
    this.mId = instance.mId;
    this.mInstanceId = instance.mInstanceId;
    this.mInstanceVersion = instance.mInstanceVersion;
    this.mIsSgwInstance = instance.mIsSgwInstance;
    this.mIsSgwPixelFromMetaPixel = instance.mIsSgwPixelFromMetaPixel;
    this.mPartnerName = instance.mPartnerName;
    this.mPixelId = instance.mPixelId;
    this.mSgwAccountId = instance.mSgwAccountId;
    this.mSgwInstanceUrl = instance.mSgwInstanceUrl;
    this.mSgwPixelId = instance.mSgwPixelId;
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
