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
public class CPASAdvertiserPartnershipRecommendation extends APINode {
  @SerializedName("advertiser_business_id")
  private String mAdvertiserBusinessId = null;
  @SerializedName("brand_business_id")
  private String mBrandBusinessId = null;
  @SerializedName("brands")
  private List<String> mBrands = null;
  @SerializedName("countries")
  private List<String> mCountries = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("merchant_business_id")
  private String mMerchantBusinessId = null;
  @SerializedName("merchant_categories")
  private List<String> mMerchantCategories = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("status_reason")
  private String mStatusReason = null;
  protected static Gson gson = null;

  CPASAdvertiserPartnershipRecommendation() {
  }

  public CPASAdvertiserPartnershipRecommendation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASAdvertiserPartnershipRecommendation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASAdvertiserPartnershipRecommendation fetch() throws APIException{
    CPASAdvertiserPartnershipRecommendation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASAdvertiserPartnershipRecommendation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASAdvertiserPartnershipRecommendation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASAdvertiserPartnershipRecommendation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASAdvertiserPartnershipRecommendation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASAdvertiserPartnershipRecommendation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASAdvertiserPartnershipRecommendation>)(
      new APIRequest<CPASAdvertiserPartnershipRecommendation>(context, "", "/", "GET", CPASAdvertiserPartnershipRecommendation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASAdvertiserPartnershipRecommendation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASAdvertiserPartnershipRecommendation.getParser())
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
  public static CPASAdvertiserPartnershipRecommendation loadJSON(String json, APIContext context, String header) {
    CPASAdvertiserPartnershipRecommendation cpasAdvertiserPartnershipRecommendation = getGson().fromJson(json, CPASAdvertiserPartnershipRecommendation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasAdvertiserPartnershipRecommendation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasAdvertiserPartnershipRecommendation.context = context;
    cpasAdvertiserPartnershipRecommendation.rawValue = json;
    cpasAdvertiserPartnershipRecommendation.header = header;
    return cpasAdvertiserPartnershipRecommendation;
  }

  public static APINodeList<CPASAdvertiserPartnershipRecommendation> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASAdvertiserPartnershipRecommendation> cpasAdvertiserPartnershipRecommendations = new APINodeList<CPASAdvertiserPartnershipRecommendation>(request, json, header);
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
          cpasAdvertiserPartnershipRecommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasAdvertiserPartnershipRecommendations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasAdvertiserPartnershipRecommendations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasAdvertiserPartnershipRecommendations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasAdvertiserPartnershipRecommendations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasAdvertiserPartnershipRecommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasAdvertiserPartnershipRecommendations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasAdvertiserPartnershipRecommendations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasAdvertiserPartnershipRecommendations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasAdvertiserPartnershipRecommendations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasAdvertiserPartnershipRecommendations;
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
              cpasAdvertiserPartnershipRecommendations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasAdvertiserPartnershipRecommendations;
          }

          // Sixth, check if it's pure JsonObject
          cpasAdvertiserPartnershipRecommendations.clear();
          cpasAdvertiserPartnershipRecommendations.add(loadJSON(json, context, header));
          return cpasAdvertiserPartnershipRecommendations;
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


  public String getFieldAdvertiserBusinessId() {
    return mAdvertiserBusinessId;
  }

  public String getFieldBrandBusinessId() {
    return mBrandBusinessId;
  }

  public List<String> getFieldBrands() {
    return mBrands;
  }

  public List<String> getFieldCountries() {
    return mCountries;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMerchantBusinessId() {
    return mMerchantBusinessId;
  }

  public List<String> getFieldMerchantCategories() {
    return mMerchantCategories;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStatusReason() {
    return mStatusReason;
  }



  public static class APIRequestGet extends APIRequest<CPASAdvertiserPartnershipRecommendation> {

    CPASAdvertiserPartnershipRecommendation lastResponse = null;
    @Override
    public CPASAdvertiserPartnershipRecommendation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "advertiser_business_id",
      "brand_business_id",
      "brands",
      "countries",
      "id",
      "merchant_business_id",
      "merchant_categories",
      "status",
      "status_reason",
    };

    @Override
    public CPASAdvertiserPartnershipRecommendation parseResponse(String response, String header) throws APIException {
      return CPASAdvertiserPartnershipRecommendation.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASAdvertiserPartnershipRecommendation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASAdvertiserPartnershipRecommendation execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASAdvertiserPartnershipRecommendation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASAdvertiserPartnershipRecommendation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASAdvertiserPartnershipRecommendation>() {
           public CPASAdvertiserPartnershipRecommendation apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdvertiserBusinessIdField () {
      return this.requestAdvertiserBusinessIdField(true);
    }
    public APIRequestGet requestAdvertiserBusinessIdField (boolean value) {
      this.requestField("advertiser_business_id", value);
      return this;
    }
    public APIRequestGet requestBrandBusinessIdField () {
      return this.requestBrandBusinessIdField(true);
    }
    public APIRequestGet requestBrandBusinessIdField (boolean value) {
      this.requestField("brand_business_id", value);
      return this;
    }
    public APIRequestGet requestBrandsField () {
      return this.requestBrandsField(true);
    }
    public APIRequestGet requestBrandsField (boolean value) {
      this.requestField("brands", value);
      return this;
    }
    public APIRequestGet requestCountriesField () {
      return this.requestCountriesField(true);
    }
    public APIRequestGet requestCountriesField (boolean value) {
      this.requestField("countries", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMerchantBusinessIdField () {
      return this.requestMerchantBusinessIdField(true);
    }
    public APIRequestGet requestMerchantBusinessIdField (boolean value) {
      this.requestField("merchant_business_id", value);
      return this;
    }
    public APIRequestGet requestMerchantCategoriesField () {
      return this.requestMerchantCategoriesField(true);
    }
    public APIRequestGet requestMerchantCategoriesField (boolean value) {
      this.requestField("merchant_categories", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStatusReasonField () {
      return this.requestStatusReasonField(true);
    }
    public APIRequestGet requestStatusReasonField (boolean value) {
      this.requestField("status_reason", value);
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

  public CPASAdvertiserPartnershipRecommendation copyFrom(CPASAdvertiserPartnershipRecommendation instance) {
    this.mAdvertiserBusinessId = instance.mAdvertiserBusinessId;
    this.mBrandBusinessId = instance.mBrandBusinessId;
    this.mBrands = instance.mBrands;
    this.mCountries = instance.mCountries;
    this.mId = instance.mId;
    this.mMerchantBusinessId = instance.mMerchantBusinessId;
    this.mMerchantCategories = instance.mMerchantCategories;
    this.mStatus = instance.mStatus;
    this.mStatusReason = instance.mStatusReason;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASAdvertiserPartnershipRecommendation> getParser() {
    return new APIRequest.ResponseParser<CPASAdvertiserPartnershipRecommendation>() {
      public APINodeList<CPASAdvertiserPartnershipRecommendation> parseResponse(String response, APIContext context, APIRequest<CPASAdvertiserPartnershipRecommendation> request, String header) throws MalformedResponseException {
        return CPASAdvertiserPartnershipRecommendation.parseResponse(response, context, request, header);
      }
    };
  }
}
