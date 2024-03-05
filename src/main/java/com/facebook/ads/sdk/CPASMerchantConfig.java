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
public class CPASMerchantConfig extends APINode {
  @SerializedName("accepted_tos")
  private Boolean mAcceptedTos = null;
  @SerializedName("beta_features")
  private List<String> mBetaFeatures = null;
  @SerializedName("business_outcomes_status")
  private List<Map<String, String>> mBusinessOutcomesStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_test_merchant")
  private Boolean mIsTestMerchant = null;
  @SerializedName("outcomes_compliance_status")
  private List<Map<String, Object>> mOutcomesComplianceStatus = null;
  @SerializedName("qualified_to_onboard")
  private Boolean mQualifiedToOnboard = null;
  protected static Gson gson = null;

  CPASMerchantConfig() {
  }

  public CPASMerchantConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASMerchantConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASMerchantConfig fetch() throws APIException{
    CPASMerchantConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASMerchantConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASMerchantConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASMerchantConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASMerchantConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASMerchantConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASMerchantConfig>)(
      new APIRequest<CPASMerchantConfig>(context, "", "/", "GET", CPASMerchantConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASMerchantConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASMerchantConfig.getParser())
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
  public static CPASMerchantConfig loadJSON(String json, APIContext context, String header) {
    CPASMerchantConfig cpasMerchantConfig = getGson().fromJson(json, CPASMerchantConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasMerchantConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasMerchantConfig.context = context;
    cpasMerchantConfig.rawValue = json;
    cpasMerchantConfig.header = header;
    return cpasMerchantConfig;
  }

  public static APINodeList<CPASMerchantConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASMerchantConfig> cpasMerchantConfigs = new APINodeList<CPASMerchantConfig>(request, json, header);
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
          cpasMerchantConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasMerchantConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasMerchantConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasMerchantConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasMerchantConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasMerchantConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasMerchantConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasMerchantConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasMerchantConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasMerchantConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasMerchantConfigs;
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
              cpasMerchantConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasMerchantConfigs;
          }

          // Sixth, check if it's pure JsonObject
          cpasMerchantConfigs.clear();
          cpasMerchantConfigs.add(loadJSON(json, context, header));
          return cpasMerchantConfigs;
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


  public Boolean getFieldAcceptedTos() {
    return mAcceptedTos;
  }

  public List<String> getFieldBetaFeatures() {
    return mBetaFeatures;
  }

  public List<Map<String, String>> getFieldBusinessOutcomesStatus() {
    return mBusinessOutcomesStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsTestMerchant() {
    return mIsTestMerchant;
  }

  public List<Map<String, Object>> getFieldOutcomesComplianceStatus() {
    return mOutcomesComplianceStatus;
  }

  public Boolean getFieldQualifiedToOnboard() {
    return mQualifiedToOnboard;
  }



  public static class APIRequestGet extends APIRequest<CPASMerchantConfig> {

    CPASMerchantConfig lastResponse = null;
    @Override
    public CPASMerchantConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "accepted_tos",
      "beta_features",
      "business_outcomes_status",
      "id",
      "is_test_merchant",
      "outcomes_compliance_status",
      "qualified_to_onboard",
    };

    @Override
    public CPASMerchantConfig parseResponse(String response, String header) throws APIException {
      return CPASMerchantConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASMerchantConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASMerchantConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASMerchantConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASMerchantConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASMerchantConfig>() {
           public CPASMerchantConfig apply(ResponseWrapper result) {
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

    public APIRequestGet requestAcceptedTosField () {
      return this.requestAcceptedTosField(true);
    }
    public APIRequestGet requestAcceptedTosField (boolean value) {
      this.requestField("accepted_tos", value);
      return this;
    }
    public APIRequestGet requestBetaFeaturesField () {
      return this.requestBetaFeaturesField(true);
    }
    public APIRequestGet requestBetaFeaturesField (boolean value) {
      this.requestField("beta_features", value);
      return this;
    }
    public APIRequestGet requestBusinessOutcomesStatusField () {
      return this.requestBusinessOutcomesStatusField(true);
    }
    public APIRequestGet requestBusinessOutcomesStatusField (boolean value) {
      this.requestField("business_outcomes_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsTestMerchantField () {
      return this.requestIsTestMerchantField(true);
    }
    public APIRequestGet requestIsTestMerchantField (boolean value) {
      this.requestField("is_test_merchant", value);
      return this;
    }
    public APIRequestGet requestOutcomesComplianceStatusField () {
      return this.requestOutcomesComplianceStatusField(true);
    }
    public APIRequestGet requestOutcomesComplianceStatusField (boolean value) {
      this.requestField("outcomes_compliance_status", value);
      return this;
    }
    public APIRequestGet requestQualifiedToOnboardField () {
      return this.requestQualifiedToOnboardField(true);
    }
    public APIRequestGet requestQualifiedToOnboardField (boolean value) {
      this.requestField("qualified_to_onboard", value);
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

  public CPASMerchantConfig copyFrom(CPASMerchantConfig instance) {
    this.mAcceptedTos = instance.mAcceptedTos;
    this.mBetaFeatures = instance.mBetaFeatures;
    this.mBusinessOutcomesStatus = instance.mBusinessOutcomesStatus;
    this.mId = instance.mId;
    this.mIsTestMerchant = instance.mIsTestMerchant;
    this.mOutcomesComplianceStatus = instance.mOutcomesComplianceStatus;
    this.mQualifiedToOnboard = instance.mQualifiedToOnboard;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASMerchantConfig> getParser() {
    return new APIRequest.ResponseParser<CPASMerchantConfig>() {
      public APINodeList<CPASMerchantConfig> parseResponse(String response, APIContext context, APIRequest<CPASMerchantConfig> request, String header) throws MalformedResponseException {
        return CPASMerchantConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
