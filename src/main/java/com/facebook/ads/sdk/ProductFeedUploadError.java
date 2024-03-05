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
public class ProductFeedUploadError extends APINode {
  @SerializedName("affected_surfaces")
  private List<EnumAffectedSurfaces> mAffectedSurfaces = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("error_type")
  private String mErrorType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("severity")
  private EnumSeverity mSeverity = null;
  @SerializedName("summary")
  private String mSummary = null;
  @SerializedName("total_count")
  private Long mTotalCount = null;
  protected static Gson gson = null;

  ProductFeedUploadError() {
  }

  public ProductFeedUploadError(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeedUploadError(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductFeedUploadError fetch() throws APIException{
    ProductFeedUploadError newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeedUploadError fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductFeedUploadError> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductFeedUploadError fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductFeedUploadError> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductFeedUploadError> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductFeedUploadError>)(
      new APIRequest<ProductFeedUploadError>(context, "", "/", "GET", ProductFeedUploadError.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductFeedUploadError>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductFeedUploadError.getParser())
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
  public static ProductFeedUploadError loadJSON(String json, APIContext context, String header) {
    ProductFeedUploadError productFeedUploadError = getGson().fromJson(json, ProductFeedUploadError.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUploadError.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productFeedUploadError.context = context;
    productFeedUploadError.rawValue = json;
    productFeedUploadError.header = header;
    return productFeedUploadError;
  }

  public static APINodeList<ProductFeedUploadError> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductFeedUploadError> productFeedUploadErrors = new APINodeList<ProductFeedUploadError>(request, json, header);
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
          productFeedUploadErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productFeedUploadErrors;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productFeedUploadErrors.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productFeedUploadErrors.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productFeedUploadErrors.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedUploadErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productFeedUploadErrors.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productFeedUploadErrors.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productFeedUploadErrors;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedUploadErrors.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productFeedUploadErrors;
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
              productFeedUploadErrors.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productFeedUploadErrors;
          }

          // Sixth, check if it's pure JsonObject
          productFeedUploadErrors.clear();
          productFeedUploadErrors.add(loadJSON(json, context, header));
          return productFeedUploadErrors;
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

  public APIRequestGetSamples getSamples() {
    return new APIRequestGetSamples(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSuggestedRules getSuggestedRules() {
    return new APIRequestGetSuggestedRules(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<EnumAffectedSurfaces> getFieldAffectedSurfaces() {
    return mAffectedSurfaces;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldErrorType() {
    return mErrorType;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumSeverity getFieldSeverity() {
    return mSeverity;
  }

  public String getFieldSummary() {
    return mSummary;
  }

  public Long getFieldTotalCount() {
    return mTotalCount;
  }



  public static class APIRequestGetSamples extends APIRequest<ProductFeedUploadErrorSample> {

    APINodeList<ProductFeedUploadErrorSample> lastResponse = null;
    @Override
    public APINodeList<ProductFeedUploadErrorSample> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "retailer_id",
      "row_number",
    };

    @Override
    public APINodeList<ProductFeedUploadErrorSample> parseResponse(String response, String header) throws APIException {
      return ProductFeedUploadErrorSample.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductFeedUploadErrorSample> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUploadErrorSample> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductFeedUploadErrorSample>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductFeedUploadErrorSample>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductFeedUploadErrorSample>>() {
           public APINodeList<ProductFeedUploadErrorSample> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSamples.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSamples(String nodeId, APIContext context) {
      super(context, nodeId, "/samples", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSamples setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSamples setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSamples requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSamples requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSamples requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSamples requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSamples requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSamples requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSamples requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSamples requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSamples requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetSamples requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetSamples requestRowNumberField () {
      return this.requestRowNumberField(true);
    }
    public APIRequestGetSamples requestRowNumberField (boolean value) {
      this.requestField("row_number", value);
      return this;
    }
  }

  public static class APIRequestGetSuggestedRules extends APIRequest<ProductFeedRuleSuggestion> {

    APINodeList<ProductFeedRuleSuggestion> lastResponse = null;
    @Override
    public APINodeList<ProductFeedRuleSuggestion> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribute",
      "params",
      "type",
    };

    @Override
    public APINodeList<ProductFeedRuleSuggestion> parseResponse(String response, String header) throws APIException {
      return ProductFeedRuleSuggestion.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductFeedRuleSuggestion> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedRuleSuggestion> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductFeedRuleSuggestion>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductFeedRuleSuggestion>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductFeedRuleSuggestion>>() {
           public APINodeList<ProductFeedRuleSuggestion> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSuggestedRules.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSuggestedRules(String nodeId, APIContext context) {
      super(context, nodeId, "/suggested_rules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSuggestedRules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSuggestedRules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSuggestedRules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSuggestedRules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSuggestedRules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSuggestedRules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSuggestedRules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSuggestedRules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSuggestedRules requestAttributeField () {
      return this.requestAttributeField(true);
    }
    public APIRequestGetSuggestedRules requestAttributeField (boolean value) {
      this.requestField("attribute", value);
      return this;
    }
    public APIRequestGetSuggestedRules requestParamsField () {
      return this.requestParamsField(true);
    }
    public APIRequestGetSuggestedRules requestParamsField (boolean value) {
      this.requestField("params", value);
      return this;
    }
    public APIRequestGetSuggestedRules requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetSuggestedRules requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<ProductFeedUploadError> {

    ProductFeedUploadError lastResponse = null;
    @Override
    public ProductFeedUploadError getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "affected_surfaces",
      "description",
      "error_type",
      "id",
      "severity",
      "summary",
      "total_count",
    };

    @Override
    public ProductFeedUploadError parseResponse(String response, String header) throws APIException {
      return ProductFeedUploadError.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductFeedUploadError execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUploadError execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductFeedUploadError> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductFeedUploadError> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductFeedUploadError>() {
           public ProductFeedUploadError apply(ResponseWrapper result) {
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

    public APIRequestGet requestAffectedSurfacesField () {
      return this.requestAffectedSurfacesField(true);
    }
    public APIRequestGet requestAffectedSurfacesField (boolean value) {
      this.requestField("affected_surfaces", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestErrorTypeField () {
      return this.requestErrorTypeField(true);
    }
    public APIRequestGet requestErrorTypeField (boolean value) {
      this.requestField("error_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGet requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGet requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGet requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGet requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGet requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
  }

  public static enum EnumAffectedSurfaces {
      @SerializedName("Dynamic Ads")
      VALUE_DYNAMIC_ADS("Dynamic Ads"),
      @SerializedName("Marketplace")
      VALUE_MARKETPLACE("Marketplace"),
      @SerializedName("US Marketplace")
      VALUE_US_MARKETPLACE("US Marketplace"),
      ;

      private String value;

      private EnumAffectedSurfaces(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSeverity {
      @SerializedName("fatal")
      VALUE_FATAL("fatal"),
      @SerializedName("warning")
      VALUE_WARNING("warning"),
      ;

      private String value;

      private EnumSeverity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumErrorPriority {
      @SerializedName("HIGH")
      VALUE_HIGH("HIGH"),
      @SerializedName("LOW")
      VALUE_LOW("LOW"),
      @SerializedName("MEDIUM")
      VALUE_MEDIUM("MEDIUM"),
      ;

      private String value;

      private EnumErrorPriority(String value) {
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

  public ProductFeedUploadError copyFrom(ProductFeedUploadError instance) {
    this.mAffectedSurfaces = instance.mAffectedSurfaces;
    this.mDescription = instance.mDescription;
    this.mErrorType = instance.mErrorType;
    this.mId = instance.mId;
    this.mSeverity = instance.mSeverity;
    this.mSummary = instance.mSummary;
    this.mTotalCount = instance.mTotalCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUploadError> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUploadError>() {
      public APINodeList<ProductFeedUploadError> parseResponse(String response, APIContext context, APIRequest<ProductFeedUploadError> request, String header) throws MalformedResponseException {
        return ProductFeedUploadError.parseResponse(response, context, request, header);
      }
    };
  }
}
