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
public class AdsValueAdjustmentRuleCollection extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_default_setting")
  private Boolean mIsDefaultSetting = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_type")
  private String mProductType = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  AdsValueAdjustmentRuleCollection() {
  }

  public AdsValueAdjustmentRuleCollection(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsValueAdjustmentRuleCollection(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsValueAdjustmentRuleCollection fetch() throws APIException{
    AdsValueAdjustmentRuleCollection newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsValueAdjustmentRuleCollection fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsValueAdjustmentRuleCollection> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsValueAdjustmentRuleCollection fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsValueAdjustmentRuleCollection> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsValueAdjustmentRuleCollection> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsValueAdjustmentRuleCollection>)(
      new APIRequest<AdsValueAdjustmentRuleCollection>(context, "", "/", "GET", AdsValueAdjustmentRuleCollection.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsValueAdjustmentRuleCollection>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsValueAdjustmentRuleCollection.getParser())
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
  public static AdsValueAdjustmentRuleCollection loadJSON(String json, APIContext context, String header) {
    AdsValueAdjustmentRuleCollection adsValueAdjustmentRuleCollection = getGson().fromJson(json, AdsValueAdjustmentRuleCollection.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsValueAdjustmentRuleCollection.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsValueAdjustmentRuleCollection.context = context;
    adsValueAdjustmentRuleCollection.rawValue = json;
    adsValueAdjustmentRuleCollection.header = header;
    return adsValueAdjustmentRuleCollection;
  }

  public static APINodeList<AdsValueAdjustmentRuleCollection> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsValueAdjustmentRuleCollection> adsValueAdjustmentRuleCollections = new APINodeList<AdsValueAdjustmentRuleCollection>(request, json, header);
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
          adsValueAdjustmentRuleCollections.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsValueAdjustmentRuleCollections;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsValueAdjustmentRuleCollections.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsValueAdjustmentRuleCollections.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsValueAdjustmentRuleCollections.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsValueAdjustmentRuleCollections.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsValueAdjustmentRuleCollections.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsValueAdjustmentRuleCollections.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsValueAdjustmentRuleCollections;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsValueAdjustmentRuleCollections.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsValueAdjustmentRuleCollections;
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
              adsValueAdjustmentRuleCollections.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsValueAdjustmentRuleCollections;
          }

          // Sixth, check if it's pure JsonObject
          adsValueAdjustmentRuleCollections.clear();
          adsValueAdjustmentRuleCollections.add(loadJSON(json, context, header));
          return adsValueAdjustmentRuleCollections;
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

  public APIRequestCreateDeleteRuleSet createDeleteRuleSet() {
    return new APIRequestCreateDeleteRuleSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRules getRules() {
    return new APIRequestGetRules(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsDefaultSetting() {
    return mIsDefaultSetting;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldProductType() {
    return mProductType;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestCreateDeleteRuleSet extends APIRequest<AdsValueAdjustmentRuleCollection> {

    AdsValueAdjustmentRuleCollection lastResponse = null;
    @Override
    public AdsValueAdjustmentRuleCollection getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsValueAdjustmentRuleCollection parseResponse(String response, String header) throws APIException {
      return AdsValueAdjustmentRuleCollection.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsValueAdjustmentRuleCollection>() {
           public AdsValueAdjustmentRuleCollection apply(ResponseWrapper result) {
             try {
               return APIRequestCreateDeleteRuleSet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateDeleteRuleSet(String nodeId, APIContext context) {
      super(context, nodeId, "/delete_rule_set", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateDeleteRuleSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateDeleteRuleSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateDeleteRuleSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateDeleteRuleSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDeleteRuleSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateDeleteRuleSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateDeleteRuleSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateDeleteRuleSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRules extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRules.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetRules(String nodeId, APIContext context) {
      super(context, nodeId, "/rules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdsValueAdjustmentRuleCollection> {

    AdsValueAdjustmentRuleCollection lastResponse = null;
    @Override
    public AdsValueAdjustmentRuleCollection getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "is_default_setting",
      "name",
      "product_type",
      "status",
    };

    @Override
    public AdsValueAdjustmentRuleCollection parseResponse(String response, String header) throws APIException {
      return AdsValueAdjustmentRuleCollection.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsValueAdjustmentRuleCollection>() {
           public AdsValueAdjustmentRuleCollection apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsDefaultSettingField () {
      return this.requestIsDefaultSettingField(true);
    }
    public APIRequestGet requestIsDefaultSettingField (boolean value) {
      this.requestField("is_default_setting", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGet requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdsValueAdjustmentRuleCollection> {

    AdsValueAdjustmentRuleCollection lastResponse = null;
    @Override
    public AdsValueAdjustmentRuleCollection getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_default_setting",
      "name",
      "rules",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsValueAdjustmentRuleCollection parseResponse(String response, String header) throws APIException {
      return AdsValueAdjustmentRuleCollection.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsValueAdjustmentRuleCollection execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsValueAdjustmentRuleCollection> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsValueAdjustmentRuleCollection>() {
           public AdsValueAdjustmentRuleCollection apply(ResponseWrapper result) {
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


    public APIRequestUpdate setIsDefaultSetting (Boolean isDefaultSetting) {
      this.setParam("is_default_setting", isDefaultSetting);
      return this;
    }
    public APIRequestUpdate setIsDefaultSetting (String isDefaultSetting) {
      this.setParam("is_default_setting", isDefaultSetting);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setRules (List<Map<String, String>> rules) {
      this.setParam("rules", rules);
      return this;
    }
    public APIRequestUpdate setRules (String rules) {
      this.setParam("rules", rules);
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

  public static enum EnumProductType {
      @SerializedName("AUDIENCE")
      VALUE_AUDIENCE("AUDIENCE"),
      @SerializedName("LEADGEN_ADS")
      VALUE_LEADGEN_ADS("LEADGEN_ADS"),
      @SerializedName("OMNI_CHANNEL")
      VALUE_OMNI_CHANNEL("OMNI_CHANNEL"),
      ;

      private String value;

      private EnumProductType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public AdsValueAdjustmentRuleCollection copyFrom(AdsValueAdjustmentRuleCollection instance) {
    this.mId = instance.mId;
    this.mIsDefaultSetting = instance.mIsDefaultSetting;
    this.mName = instance.mName;
    this.mProductType = instance.mProductType;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsValueAdjustmentRuleCollection> getParser() {
    return new APIRequest.ResponseParser<AdsValueAdjustmentRuleCollection>() {
      public APINodeList<AdsValueAdjustmentRuleCollection> parseResponse(String response, APIContext context, APIRequest<AdsValueAdjustmentRuleCollection> request, String header) throws MalformedResponseException {
        return AdsValueAdjustmentRuleCollection.parseResponse(response, context, request, header);
      }
    };
  }
}
