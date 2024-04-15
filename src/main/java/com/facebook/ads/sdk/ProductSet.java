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
public class ProductSet extends APINode {
  @SerializedName("auto_creation_url")
  private String mAutoCreationUrl = null;
  @SerializedName("filter")
  private String mFilter = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("latest_metadata")
  private ProductSetMetadata mLatestMetadata = null;
  @SerializedName("live_metadata")
  private ProductSetMetadata mLiveMetadata = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ordering_info")
  private List<Long> mOrderingInfo = null;
  @SerializedName("product_catalog")
  private ProductCatalog mProductCatalog = null;
  @SerializedName("product_count")
  private Long mProductCount = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  protected static Gson gson = null;

  ProductSet() {
  }

  public ProductSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductSet(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductSet fetch() throws APIException{
    ProductSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductSet> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductSet fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductSet> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductSet>)(
      new APIRequest<ProductSet>(context, "", "/", "GET", ProductSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductSet>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductSet.getParser())
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
  public static ProductSet loadJSON(String json, APIContext context, String header) {
    ProductSet productSet = getGson().fromJson(json, ProductSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productSet.context = context;
    productSet.rawValue = json;
    productSet.header = header;
    return productSet;
  }

  public static APINodeList<ProductSet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductSet> productSets = new APINodeList<ProductSet>(request, json, header);
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
          productSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productSets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productSets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productSets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productSets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productSets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productSets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productSets;
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
              productSets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productSets;
          }

          // Sixth, check if it's pure JsonObject
          productSets.clear();
          productSets.add(loadJSON(json, context, header));
          return productSets;
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

  public APIRequestGetAutomotiveModels getAutomotiveModels() {
    return new APIRequestGetAutomotiveModels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDestinations getDestinations() {
    return new APIRequestGetDestinations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFlights getFlights() {
    return new APIRequestGetFlights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHomeListings getHomeListings() {
    return new APIRequestGetHomeListings(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHotels getHotels() {
    return new APIRequestGetHotels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMediaTitles getMediaTitles() {
    return new APIRequestGetMediaTitles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVehicleOffers getVehicleOffers() {
    return new APIRequestGetVehicleOffers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVehicles getVehicles() {
    return new APIRequestGetVehicles(this.getPrefixedId().toString(), context);
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


  public String getFieldAutoCreationUrl() {
    return mAutoCreationUrl;
  }

  public String getFieldFilter() {
    return mFilter;
  }

  public String getFieldId() {
    return mId;
  }

  public ProductSetMetadata getFieldLatestMetadata() {
    return mLatestMetadata;
  }

  public ProductSetMetadata getFieldLiveMetadata() {
    return mLiveMetadata;
  }

  public String getFieldName() {
    return mName;
  }

  public List<Long> getFieldOrderingInfo() {
    return mOrderingInfo;
  }

  public ProductCatalog getFieldProductCatalog() {
    if (mProductCatalog != null) {
      mProductCatalog.context = getContext();
    }
    return mProductCatalog;
  }

  public Long getFieldProductCount() {
    return mProductCount;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }



  public static class APIRequestGetAutomotiveModels extends APIRequest<AutomotiveModel> {

    APINodeList<AutomotiveModel> lastResponse = null;
    @Override
    public APINodeList<AutomotiveModel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "applinks",
      "automotive_model_id",
      "availability",
      "body_style",
      "category_specific_fields",
      "currency",
      "custom_label_0",
      "description",
      "drivetrain",
      "exterior_color",
      "finance_description",
      "finance_type",
      "fuel_type",
      "generation",
      "id",
      "image_fetch_status",
      "images",
      "interior_color",
      "interior_upholstery",
      "make",
      "model",
      "price",
      "sanitized_images",
      "title",
      "transmission",
      "trim",
      "unit_price",
      "url",
      "visibility",
      "year",
    };

    @Override
    public APINodeList<AutomotiveModel> parseResponse(String response, String header) throws APIException {
      return AutomotiveModel.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AutomotiveModel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AutomotiveModel> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AutomotiveModel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AutomotiveModel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AutomotiveModel>>() {
           public APINodeList<AutomotiveModel> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAutomotiveModels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAutomotiveModels(String nodeId, APIContext context) {
      super(context, nodeId, "/automotive_models", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAutomotiveModels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAutomotiveModels setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetAutomotiveModels setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetAutomotiveModels setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetAutomotiveModels setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetAutomotiveModels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAutomotiveModels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAutomotiveModels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAutomotiveModels requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetAutomotiveModels requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestAutomotiveModelIdField () {
      return this.requestAutomotiveModelIdField(true);
    }
    public APIRequestGetAutomotiveModels requestAutomotiveModelIdField (boolean value) {
      this.requestField("automotive_model_id", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetAutomotiveModels requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGetAutomotiveModels requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetAutomotiveModels requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAutomotiveModels requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetAutomotiveModels requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAutomotiveModels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGetAutomotiveModels requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGetAutomotiveModels requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestFinanceDescriptionField () {
      return this.requestFinanceDescriptionField(true);
    }
    public APIRequestGetAutomotiveModels requestFinanceDescriptionField (boolean value) {
      this.requestField("finance_description", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestFinanceTypeField () {
      return this.requestFinanceTypeField(true);
    }
    public APIRequestGetAutomotiveModels requestFinanceTypeField (boolean value) {
      this.requestField("finance_type", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGetAutomotiveModels requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestGenerationField () {
      return this.requestGenerationField(true);
    }
    public APIRequestGetAutomotiveModels requestGenerationField (boolean value) {
      this.requestField("generation", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAutomotiveModels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetAutomotiveModels requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetAutomotiveModels requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGetAutomotiveModels requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestInteriorUpholsteryField () {
      return this.requestInteriorUpholsteryField(true);
    }
    public APIRequestGetAutomotiveModels requestInteriorUpholsteryField (boolean value) {
      this.requestField("interior_upholstery", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGetAutomotiveModels requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGetAutomotiveModels requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetAutomotiveModels requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetAutomotiveModels requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAutomotiveModels requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGetAutomotiveModels requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGetAutomotiveModels requestTrimField (boolean value) {
      this.requestField("trim", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetAutomotiveModels requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetAutomotiveModels requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetAutomotiveModels requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGetAutomotiveModels requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
    }
  }

  public static class APIRequestGetDestinations extends APIRequest<Destination> {

    APINodeList<Destination> lastResponse = null;
    @Override
    public APINodeList<Destination> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "category_specific_fields",
      "currency",
      "description",
      "destination_id",
      "id",
      "image_fetch_status",
      "images",
      "name",
      "price",
      "price_change",
      "sanitized_images",
      "tags",
      "types",
      "unit_price",
      "url",
      "visibility",
    };

    @Override
    public APINodeList<Destination> parseResponse(String response, String header) throws APIException {
      return Destination.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Destination> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Destination> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Destination>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Destination>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Destination>>() {
           public APINodeList<Destination> apply(ResponseWrapper result) {
             try {
               return APIRequestGetDestinations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDestinations(String nodeId, APIContext context) {
      super(context, nodeId, "/destinations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDestinations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDestinations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDestinations setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetDestinations setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetDestinations setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetDestinations setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetDestinations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDestinations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDestinations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDestinations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDestinations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDestinations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDestinations requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetDestinations requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetDestinations requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetDestinations requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetDestinations requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetDestinations requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetDestinations requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetDestinations requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetDestinations requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDestinations requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDestinations requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGetDestinations requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGetDestinations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDestinations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDestinations requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetDestinations requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetDestinations requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetDestinations requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetDestinations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDestinations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDestinations requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetDestinations requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetDestinations requestPriceChangeField () {
      return this.requestPriceChangeField(true);
    }
    public APIRequestGetDestinations requestPriceChangeField (boolean value) {
      this.requestField("price_change", value);
      return this;
    }
    public APIRequestGetDestinations requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetDestinations requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetDestinations requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetDestinations requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetDestinations requestTypesField () {
      return this.requestTypesField(true);
    }
    public APIRequestGetDestinations requestTypesField (boolean value) {
      this.requestField("types", value);
      return this;
    }
    public APIRequestGetDestinations requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetDestinations requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetDestinations requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetDestinations requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetDestinations requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetDestinations requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
  }

  public static class APIRequestGetFlights extends APIRequest<Flight> {

    APINodeList<Flight> lastResponse = null;
    @Override
    public APINodeList<Flight> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "applinks",
      "category_specific_fields",
      "currency",
      "description",
      "destination_airport",
      "destination_city",
      "flight_id",
      "id",
      "image_fetch_status",
      "images",
      "oneway_currency",
      "oneway_price",
      "origin_airport",
      "origin_city",
      "price",
      "sanitized_images",
      "tags",
      "unit_price",
      "url",
      "visibility",
    };

    @Override
    public APINodeList<Flight> parseResponse(String response, String header) throws APIException {
      return Flight.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Flight> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Flight> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Flight>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Flight>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Flight>>() {
           public APINodeList<Flight> apply(ResponseWrapper result) {
             try {
               return APIRequestGetFlights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetFlights(String nodeId, APIContext context) {
      super(context, nodeId, "/flights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFlights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFlights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFlights setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetFlights setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetFlights setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetFlights setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetFlights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFlights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFlights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFlights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetFlights requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetFlights requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetFlights requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetFlights requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetFlights requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetFlights requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetFlights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetFlights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetFlights requestDestinationAirportField () {
      return this.requestDestinationAirportField(true);
    }
    public APIRequestGetFlights requestDestinationAirportField (boolean value) {
      this.requestField("destination_airport", value);
      return this;
    }
    public APIRequestGetFlights requestDestinationCityField () {
      return this.requestDestinationCityField(true);
    }
    public APIRequestGetFlights requestDestinationCityField (boolean value) {
      this.requestField("destination_city", value);
      return this;
    }
    public APIRequestGetFlights requestFlightIdField () {
      return this.requestFlightIdField(true);
    }
    public APIRequestGetFlights requestFlightIdField (boolean value) {
      this.requestField("flight_id", value);
      return this;
    }
    public APIRequestGetFlights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetFlights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetFlights requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetFlights requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetFlights requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetFlights requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetFlights requestOnewayCurrencyField () {
      return this.requestOnewayCurrencyField(true);
    }
    public APIRequestGetFlights requestOnewayCurrencyField (boolean value) {
      this.requestField("oneway_currency", value);
      return this;
    }
    public APIRequestGetFlights requestOnewayPriceField () {
      return this.requestOnewayPriceField(true);
    }
    public APIRequestGetFlights requestOnewayPriceField (boolean value) {
      this.requestField("oneway_price", value);
      return this;
    }
    public APIRequestGetFlights requestOriginAirportField () {
      return this.requestOriginAirportField(true);
    }
    public APIRequestGetFlights requestOriginAirportField (boolean value) {
      this.requestField("origin_airport", value);
      return this;
    }
    public APIRequestGetFlights requestOriginCityField () {
      return this.requestOriginCityField(true);
    }
    public APIRequestGetFlights requestOriginCityField (boolean value) {
      this.requestField("origin_city", value);
      return this;
    }
    public APIRequestGetFlights requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetFlights requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetFlights requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetFlights requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetFlights requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetFlights requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetFlights requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetFlights requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetFlights requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetFlights requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetFlights requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetFlights requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
  }

  public static class APIRequestGetHomeListings extends APIRequest<HomeListing> {

    APINodeList<HomeListing> lastResponse = null;
    @Override
    public APINodeList<HomeListing> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "ac_type",
      "additional_fees_description",
      "address",
      "agent_company",
      "agent_email",
      "agent_fb_page_id",
      "agent_name",
      "agent_phone",
      "applinks",
      "area_size",
      "area_unit",
      "availability",
      "category_specific_fields",
      "co_2_emission_rating_eu",
      "currency",
      "days_on_market",
      "description",
      "energy_rating_eu",
      "furnish_type",
      "group_id",
      "heating_type",
      "home_listing_id",
      "id",
      "image_fetch_status",
      "images",
      "laundry_type",
      "listing_type",
      "max_currency",
      "max_price",
      "min_currency",
      "min_price",
      "name",
      "num_baths",
      "num_beds",
      "num_rooms",
      "num_units",
      "parking_type",
      "partner_verification",
      "pet_policy",
      "price",
      "property_type",
      "sanitized_images",
      "unit_price",
      "url",
      "visibility",
      "year_built",
    };

    @Override
    public APINodeList<HomeListing> parseResponse(String response, String header) throws APIException {
      return HomeListing.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<HomeListing> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<HomeListing> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<HomeListing>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<HomeListing>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<HomeListing>>() {
           public APINodeList<HomeListing> apply(ResponseWrapper result) {
             try {
               return APIRequestGetHomeListings.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetHomeListings(String nodeId, APIContext context) {
      super(context, nodeId, "/home_listings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHomeListings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHomeListings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHomeListings setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetHomeListings setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetHomeListings setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetHomeListings setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetHomeListings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHomeListings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHomeListings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHomeListings requestAcTypeField () {
      return this.requestAcTypeField(true);
    }
    public APIRequestGetHomeListings requestAcTypeField (boolean value) {
      this.requestField("ac_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestAdditionalFeesDescriptionField () {
      return this.requestAdditionalFeesDescriptionField(true);
    }
    public APIRequestGetHomeListings requestAdditionalFeesDescriptionField (boolean value) {
      this.requestField("additional_fees_description", value);
      return this;
    }
    public APIRequestGetHomeListings requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetHomeListings requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentCompanyField () {
      return this.requestAgentCompanyField(true);
    }
    public APIRequestGetHomeListings requestAgentCompanyField (boolean value) {
      this.requestField("agent_company", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentEmailField () {
      return this.requestAgentEmailField(true);
    }
    public APIRequestGetHomeListings requestAgentEmailField (boolean value) {
      this.requestField("agent_email", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentFbPageIdField () {
      return this.requestAgentFbPageIdField(true);
    }
    public APIRequestGetHomeListings requestAgentFbPageIdField (boolean value) {
      this.requestField("agent_fb_page_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentNameField () {
      return this.requestAgentNameField(true);
    }
    public APIRequestGetHomeListings requestAgentNameField (boolean value) {
      this.requestField("agent_name", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentPhoneField () {
      return this.requestAgentPhoneField(true);
    }
    public APIRequestGetHomeListings requestAgentPhoneField (boolean value) {
      this.requestField("agent_phone", value);
      return this;
    }
    public APIRequestGetHomeListings requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetHomeListings requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetHomeListings requestAreaSizeField () {
      return this.requestAreaSizeField(true);
    }
    public APIRequestGetHomeListings requestAreaSizeField (boolean value) {
      this.requestField("area_size", value);
      return this;
    }
    public APIRequestGetHomeListings requestAreaUnitField () {
      return this.requestAreaUnitField(true);
    }
    public APIRequestGetHomeListings requestAreaUnitField (boolean value) {
      this.requestField("area_unit", value);
      return this;
    }
    public APIRequestGetHomeListings requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetHomeListings requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetHomeListings requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetHomeListings requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetHomeListings requestCo2EmissionRatingEuField () {
      return this.requestCo2EmissionRatingEuField(true);
    }
    public APIRequestGetHomeListings requestCo2EmissionRatingEuField (boolean value) {
      this.requestField("co_2_emission_rating_eu", value);
      return this;
    }
    public APIRequestGetHomeListings requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetHomeListings requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestDaysOnMarketField () {
      return this.requestDaysOnMarketField(true);
    }
    public APIRequestGetHomeListings requestDaysOnMarketField (boolean value) {
      this.requestField("days_on_market", value);
      return this;
    }
    public APIRequestGetHomeListings requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetHomeListings requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetHomeListings requestEnergyRatingEuField () {
      return this.requestEnergyRatingEuField(true);
    }
    public APIRequestGetHomeListings requestEnergyRatingEuField (boolean value) {
      this.requestField("energy_rating_eu", value);
      return this;
    }
    public APIRequestGetHomeListings requestFurnishTypeField () {
      return this.requestFurnishTypeField(true);
    }
    public APIRequestGetHomeListings requestFurnishTypeField (boolean value) {
      this.requestField("furnish_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestGroupIdField () {
      return this.requestGroupIdField(true);
    }
    public APIRequestGetHomeListings requestGroupIdField (boolean value) {
      this.requestField("group_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestHeatingTypeField () {
      return this.requestHeatingTypeField(true);
    }
    public APIRequestGetHomeListings requestHeatingTypeField (boolean value) {
      this.requestField("heating_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestHomeListingIdField () {
      return this.requestHomeListingIdField(true);
    }
    public APIRequestGetHomeListings requestHomeListingIdField (boolean value) {
      this.requestField("home_listing_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHomeListings requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetHomeListings requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetHomeListings requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetHomeListings requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetHomeListings requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetHomeListings requestLaundryTypeField () {
      return this.requestLaundryTypeField(true);
    }
    public APIRequestGetHomeListings requestLaundryTypeField (boolean value) {
      this.requestField("laundry_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestListingTypeField () {
      return this.requestListingTypeField(true);
    }
    public APIRequestGetHomeListings requestListingTypeField (boolean value) {
      this.requestField("listing_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestMaxCurrencyField () {
      return this.requestMaxCurrencyField(true);
    }
    public APIRequestGetHomeListings requestMaxCurrencyField (boolean value) {
      this.requestField("max_currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestMaxPriceField () {
      return this.requestMaxPriceField(true);
    }
    public APIRequestGetHomeListings requestMaxPriceField (boolean value) {
      this.requestField("max_price", value);
      return this;
    }
    public APIRequestGetHomeListings requestMinCurrencyField () {
      return this.requestMinCurrencyField(true);
    }
    public APIRequestGetHomeListings requestMinCurrencyField (boolean value) {
      this.requestField("min_currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestMinPriceField () {
      return this.requestMinPriceField(true);
    }
    public APIRequestGetHomeListings requestMinPriceField (boolean value) {
      this.requestField("min_price", value);
      return this;
    }
    public APIRequestGetHomeListings requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetHomeListings requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumBathsField () {
      return this.requestNumBathsField(true);
    }
    public APIRequestGetHomeListings requestNumBathsField (boolean value) {
      this.requestField("num_baths", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumBedsField () {
      return this.requestNumBedsField(true);
    }
    public APIRequestGetHomeListings requestNumBedsField (boolean value) {
      this.requestField("num_beds", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumRoomsField () {
      return this.requestNumRoomsField(true);
    }
    public APIRequestGetHomeListings requestNumRoomsField (boolean value) {
      this.requestField("num_rooms", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumUnitsField () {
      return this.requestNumUnitsField(true);
    }
    public APIRequestGetHomeListings requestNumUnitsField (boolean value) {
      this.requestField("num_units", value);
      return this;
    }
    public APIRequestGetHomeListings requestParkingTypeField () {
      return this.requestParkingTypeField(true);
    }
    public APIRequestGetHomeListings requestParkingTypeField (boolean value) {
      this.requestField("parking_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestPartnerVerificationField () {
      return this.requestPartnerVerificationField(true);
    }
    public APIRequestGetHomeListings requestPartnerVerificationField (boolean value) {
      this.requestField("partner_verification", value);
      return this;
    }
    public APIRequestGetHomeListings requestPetPolicyField () {
      return this.requestPetPolicyField(true);
    }
    public APIRequestGetHomeListings requestPetPolicyField (boolean value) {
      this.requestField("pet_policy", value);
      return this;
    }
    public APIRequestGetHomeListings requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetHomeListings requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetHomeListings requestPropertyTypeField () {
      return this.requestPropertyTypeField(true);
    }
    public APIRequestGetHomeListings requestPropertyTypeField (boolean value) {
      this.requestField("property_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetHomeListings requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetHomeListings requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetHomeListings requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetHomeListings requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetHomeListings requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetHomeListings requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetHomeListings requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetHomeListings requestYearBuiltField () {
      return this.requestYearBuiltField(true);
    }
    public APIRequestGetHomeListings requestYearBuiltField (boolean value) {
      this.requestField("year_built", value);
      return this;
    }
  }

  public static class APIRequestGetHotels extends APIRequest<Hotel> {

    APINodeList<Hotel> lastResponse = null;
    @Override
    public APINodeList<Hotel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "brand",
      "category",
      "category_specific_fields",
      "currency",
      "description",
      "guest_ratings",
      "hotel_id",
      "id",
      "image_fetch_status",
      "images",
      "lowest_base_price",
      "loyalty_program",
      "margin_level",
      "name",
      "phone",
      "sale_price",
      "sanitized_images",
      "star_rating",
      "tags",
      "unit_price",
      "url",
      "visibility",
    };

    @Override
    public APINodeList<Hotel> parseResponse(String response, String header) throws APIException {
      return Hotel.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Hotel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Hotel> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Hotel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Hotel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Hotel>>() {
           public APINodeList<Hotel> apply(ResponseWrapper result) {
             try {
               return APIRequestGetHotels.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetHotels(String nodeId, APIContext context) {
      super(context, nodeId, "/hotels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHotels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHotels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHotels setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetHotels setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetHotels setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetHotels setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetHotels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHotels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHotels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHotels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHotels requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetHotels requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetHotels requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetHotels requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetHotels requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGetHotels requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGetHotels requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetHotels requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetHotels requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetHotels requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetHotels requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetHotels requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetHotels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetHotels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetHotels requestGuestRatingsField () {
      return this.requestGuestRatingsField(true);
    }
    public APIRequestGetHotels requestGuestRatingsField (boolean value) {
      this.requestField("guest_ratings", value);
      return this;
    }
    public APIRequestGetHotels requestHotelIdField () {
      return this.requestHotelIdField(true);
    }
    public APIRequestGetHotels requestHotelIdField (boolean value) {
      this.requestField("hotel_id", value);
      return this;
    }
    public APIRequestGetHotels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHotels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetHotels requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetHotels requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetHotels requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetHotels requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetHotels requestLowestBasePriceField () {
      return this.requestLowestBasePriceField(true);
    }
    public APIRequestGetHotels requestLowestBasePriceField (boolean value) {
      this.requestField("lowest_base_price", value);
      return this;
    }
    public APIRequestGetHotels requestLoyaltyProgramField () {
      return this.requestLoyaltyProgramField(true);
    }
    public APIRequestGetHotels requestLoyaltyProgramField (boolean value) {
      this.requestField("loyalty_program", value);
      return this;
    }
    public APIRequestGetHotels requestMarginLevelField () {
      return this.requestMarginLevelField(true);
    }
    public APIRequestGetHotels requestMarginLevelField (boolean value) {
      this.requestField("margin_level", value);
      return this;
    }
    public APIRequestGetHotels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetHotels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetHotels requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetHotels requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetHotels requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetHotels requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetHotels requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetHotels requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetHotels requestStarRatingField () {
      return this.requestStarRatingField(true);
    }
    public APIRequestGetHotels requestStarRatingField (boolean value) {
      this.requestField("star_rating", value);
      return this;
    }
    public APIRequestGetHotels requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetHotels requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetHotels requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetHotels requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetHotels requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetHotels requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetHotels requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetHotels requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
  }

  public static class APIRequestGetMediaTitles extends APIRequest<MediaTitle> {

    APINodeList<MediaTitle> lastResponse = null;
    @Override
    public APINodeList<MediaTitle> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "applinks",
      "category_specific_fields",
      "content_category",
      "currency",
      "description",
      "fb_page_alias",
      "fb_page_id",
      "genres",
      "id",
      "image_fetch_status",
      "images",
      "kg_fb_id",
      "media_title_id",
      "price",
      "sanitized_images",
      "title",
      "title_display_name",
      "unit_price",
      "url",
      "visibility",
      "wiki_data_item",
    };

    @Override
    public APINodeList<MediaTitle> parseResponse(String response, String header) throws APIException {
      return MediaTitle.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<MediaTitle> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<MediaTitle> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<MediaTitle>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<MediaTitle>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<MediaTitle>>() {
           public APINodeList<MediaTitle> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMediaTitles.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMediaTitles(String nodeId, APIContext context) {
      super(context, nodeId, "/media_titles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMediaTitles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMediaTitles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMediaTitles setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetMediaTitles setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetMediaTitles setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetMediaTitles setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetMediaTitles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMediaTitles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMediaTitles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMediaTitles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMediaTitles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMediaTitles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMediaTitles requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetMediaTitles requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetMediaTitles requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetMediaTitles requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetMediaTitles requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGetMediaTitles requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGetMediaTitles requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetMediaTitles requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetMediaTitles requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetMediaTitles requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetMediaTitles requestFbPageAliasField () {
      return this.requestFbPageAliasField(true);
    }
    public APIRequestGetMediaTitles requestFbPageAliasField (boolean value) {
      this.requestField("fb_page_alias", value);
      return this;
    }
    public APIRequestGetMediaTitles requestFbPageIdField () {
      return this.requestFbPageIdField(true);
    }
    public APIRequestGetMediaTitles requestFbPageIdField (boolean value) {
      this.requestField("fb_page_id", value);
      return this;
    }
    public APIRequestGetMediaTitles requestGenresField () {
      return this.requestGenresField(true);
    }
    public APIRequestGetMediaTitles requestGenresField (boolean value) {
      this.requestField("genres", value);
      return this;
    }
    public APIRequestGetMediaTitles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMediaTitles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMediaTitles requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetMediaTitles requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetMediaTitles requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetMediaTitles requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetMediaTitles requestKgFbIdField () {
      return this.requestKgFbIdField(true);
    }
    public APIRequestGetMediaTitles requestKgFbIdField (boolean value) {
      this.requestField("kg_fb_id", value);
      return this;
    }
    public APIRequestGetMediaTitles requestMediaTitleIdField () {
      return this.requestMediaTitleIdField(true);
    }
    public APIRequestGetMediaTitles requestMediaTitleIdField (boolean value) {
      this.requestField("media_title_id", value);
      return this;
    }
    public APIRequestGetMediaTitles requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetMediaTitles requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetMediaTitles requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetMediaTitles requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetMediaTitles requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetMediaTitles requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetMediaTitles requestTitleDisplayNameField () {
      return this.requestTitleDisplayNameField(true);
    }
    public APIRequestGetMediaTitles requestTitleDisplayNameField (boolean value) {
      this.requestField("title_display_name", value);
      return this;
    }
    public APIRequestGetMediaTitles requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetMediaTitles requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetMediaTitles requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetMediaTitles requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetMediaTitles requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetMediaTitles requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetMediaTitles requestWikiDataItemField () {
      return this.requestWikiDataItemField(true);
    }
    public APIRequestGetMediaTitles requestWikiDataItemField (boolean value) {
      this.requestField("wiki_data_item", value);
      return this;
    }
  }

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    APINodeList<ProductItem> lastResponse = null;
    @Override
    public APINodeList<ProductItem> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "error_priority",
      "error_type",
      "filter",
    };

    public static final String[] FIELDS = {
      "additional_image_cdn_urls",
      "additional_image_urls",
      "additional_variant_attributes",
      "age_group",
      "applinks",
      "availability",
      "brand",
      "capability_to_review_status",
      "category",
      "category_specific_fields",
      "color",
      "commerce_insights",
      "condition",
      "currency",
      "custom_data",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "custom_number_0",
      "custom_number_1",
      "custom_number_2",
      "custom_number_3",
      "custom_number_4",
      "description",
      "errors",
      "expiration_date",
      "fb_product_category",
      "gender",
      "gtin",
      "id",
      "image_cdn_urls",
      "image_fetch_status",
      "image_url",
      "images",
      "importer_address",
      "importer_name",
      "invalidation_errors",
      "inventory",
      "manufacturer_info",
      "manufacturer_part_number",
      "marked_for_product_launch",
      "material",
      "mobile_link",
      "name",
      "ordering_index",
      "origin_country",
      "parent_product_id",
      "pattern",
      "post_conversion_signal_based_enforcement_appeal_eligibility",
      "price",
      "product_catalog",
      "product_feed",
      "product_group",
      "product_local_info",
      "product_type",
      "quantity_to_sell_on_facebook",
      "retailer_id",
      "retailer_product_group_id",
      "review_rejection_reasons",
      "review_status",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "shipping_weight_unit",
      "shipping_weight_value",
      "short_description",
      "size",
      "start_date",
      "tags",
      "url",
      "video_fetch_status",
      "visibility",
      "wa_compliance_category",
    };

    @Override
    public APINodeList<ProductItem> parseResponse(String response, String header) throws APIException {
      return ProductItem.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductItem> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductItem> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductItem>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductItem>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductItem>>() {
           public APINodeList<ProductItem> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProducts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProducts(String nodeId, APIContext context) {
      super(context, nodeId, "/products", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProducts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProducts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProducts setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetProducts setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetProducts setErrorPriority (ProductItem.EnumErrorPriority errorPriority) {
      this.setParam("error_priority", errorPriority);
      return this;
    }
    public APIRequestGetProducts setErrorPriority (String errorPriority) {
      this.setParam("error_priority", errorPriority);
      return this;
    }

    public APIRequestGetProducts setErrorType (ProductItem.EnumErrorType errorType) {
      this.setParam("error_type", errorType);
      return this;
    }
    public APIRequestGetProducts setErrorType (String errorType) {
      this.setParam("error_type", errorType);
      return this;
    }

    public APIRequestGetProducts setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetProducts setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetProducts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProducts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProducts requestAdditionalImageCdnUrlsField () {
      return this.requestAdditionalImageCdnUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageCdnUrlsField (boolean value) {
      this.requestField("additional_image_cdn_urls", value);
      return this;
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGetProducts requestAdditionalVariantAttributesField () {
      return this.requestAdditionalVariantAttributesField(true);
    }
    public APIRequestGetProducts requestAdditionalVariantAttributesField (boolean value) {
      this.requestField("additional_variant_attributes", value);
      return this;
    }
    public APIRequestGetProducts requestAgeGroupField () {
      return this.requestAgeGroupField(true);
    }
    public APIRequestGetProducts requestAgeGroupField (boolean value) {
      this.requestField("age_group", value);
      return this;
    }
    public APIRequestGetProducts requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetProducts requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetProducts requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetProducts requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetProducts requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGetProducts requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGetProducts requestCapabilityToReviewStatusField () {
      return this.requestCapabilityToReviewStatusField(true);
    }
    public APIRequestGetProducts requestCapabilityToReviewStatusField (boolean value) {
      this.requestField("capability_to_review_status", value);
      return this;
    }
    public APIRequestGetProducts requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetProducts requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetProducts requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetProducts requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetProducts requestColorField () {
      return this.requestColorField(true);
    }
    public APIRequestGetProducts requestColorField (boolean value) {
      this.requestField("color", value);
      return this;
    }
    public APIRequestGetProducts requestCommerceInsightsField () {
      return this.requestCommerceInsightsField(true);
    }
    public APIRequestGetProducts requestCommerceInsightsField (boolean value) {
      this.requestField("commerce_insights", value);
      return this;
    }
    public APIRequestGetProducts requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGetProducts requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGetProducts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetProducts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetProducts requestCustomDataField () {
      return this.requestCustomDataField(true);
    }
    public APIRequestGetProducts requestCustomDataField (boolean value) {
      this.requestField("custom_data", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetProducts requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGetProducts requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGetProducts requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGetProducts requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGetProducts requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
      return this;
    }
    public APIRequestGetProducts requestCustomNumber0Field () {
      return this.requestCustomNumber0Field(true);
    }
    public APIRequestGetProducts requestCustomNumber0Field (boolean value) {
      this.requestField("custom_number_0", value);
      return this;
    }
    public APIRequestGetProducts requestCustomNumber1Field () {
      return this.requestCustomNumber1Field(true);
    }
    public APIRequestGetProducts requestCustomNumber1Field (boolean value) {
      this.requestField("custom_number_1", value);
      return this;
    }
    public APIRequestGetProducts requestCustomNumber2Field () {
      return this.requestCustomNumber2Field(true);
    }
    public APIRequestGetProducts requestCustomNumber2Field (boolean value) {
      this.requestField("custom_number_2", value);
      return this;
    }
    public APIRequestGetProducts requestCustomNumber3Field () {
      return this.requestCustomNumber3Field(true);
    }
    public APIRequestGetProducts requestCustomNumber3Field (boolean value) {
      this.requestField("custom_number_3", value);
      return this;
    }
    public APIRequestGetProducts requestCustomNumber4Field () {
      return this.requestCustomNumber4Field(true);
    }
    public APIRequestGetProducts requestCustomNumber4Field (boolean value) {
      this.requestField("custom_number_4", value);
      return this;
    }
    public APIRequestGetProducts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetProducts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetProducts requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGetProducts requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGetProducts requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGetProducts requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
      return this;
    }
    public APIRequestGetProducts requestFbProductCategoryField () {
      return this.requestFbProductCategoryField(true);
    }
    public APIRequestGetProducts requestFbProductCategoryField (boolean value) {
      this.requestField("fb_product_category", value);
      return this;
    }
    public APIRequestGetProducts requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetProducts requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetProducts requestGtinField () {
      return this.requestGtinField(true);
    }
    public APIRequestGetProducts requestGtinField (boolean value) {
      this.requestField("gtin", value);
      return this;
    }
    public APIRequestGetProducts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProducts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProducts requestImageCdnUrlsField () {
      return this.requestImageCdnUrlsField(true);
    }
    public APIRequestGetProducts requestImageCdnUrlsField (boolean value) {
      this.requestField("image_cdn_urls", value);
      return this;
    }
    public APIRequestGetProducts requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetProducts requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetProducts requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetProducts requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetProducts requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetProducts requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetProducts requestImporterAddressField () {
      return this.requestImporterAddressField(true);
    }
    public APIRequestGetProducts requestImporterAddressField (boolean value) {
      this.requestField("importer_address", value);
      return this;
    }
    public APIRequestGetProducts requestImporterNameField () {
      return this.requestImporterNameField(true);
    }
    public APIRequestGetProducts requestImporterNameField (boolean value) {
      this.requestField("importer_name", value);
      return this;
    }
    public APIRequestGetProducts requestInvalidationErrorsField () {
      return this.requestInvalidationErrorsField(true);
    }
    public APIRequestGetProducts requestInvalidationErrorsField (boolean value) {
      this.requestField("invalidation_errors", value);
      return this;
    }
    public APIRequestGetProducts requestInventoryField () {
      return this.requestInventoryField(true);
    }
    public APIRequestGetProducts requestInventoryField (boolean value) {
      this.requestField("inventory", value);
      return this;
    }
    public APIRequestGetProducts requestManufacturerInfoField () {
      return this.requestManufacturerInfoField(true);
    }
    public APIRequestGetProducts requestManufacturerInfoField (boolean value) {
      this.requestField("manufacturer_info", value);
      return this;
    }
    public APIRequestGetProducts requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGetProducts requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
      return this;
    }
    public APIRequestGetProducts requestMarkedForProductLaunchField () {
      return this.requestMarkedForProductLaunchField(true);
    }
    public APIRequestGetProducts requestMarkedForProductLaunchField (boolean value) {
      this.requestField("marked_for_product_launch", value);
      return this;
    }
    public APIRequestGetProducts requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGetProducts requestMaterialField (boolean value) {
      this.requestField("material", value);
      return this;
    }
    public APIRequestGetProducts requestMobileLinkField () {
      return this.requestMobileLinkField(true);
    }
    public APIRequestGetProducts requestMobileLinkField (boolean value) {
      this.requestField("mobile_link", value);
      return this;
    }
    public APIRequestGetProducts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProducts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProducts requestOrderingIndexField () {
      return this.requestOrderingIndexField(true);
    }
    public APIRequestGetProducts requestOrderingIndexField (boolean value) {
      this.requestField("ordering_index", value);
      return this;
    }
    public APIRequestGetProducts requestOriginCountryField () {
      return this.requestOriginCountryField(true);
    }
    public APIRequestGetProducts requestOriginCountryField (boolean value) {
      this.requestField("origin_country", value);
      return this;
    }
    public APIRequestGetProducts requestParentProductIdField () {
      return this.requestParentProductIdField(true);
    }
    public APIRequestGetProducts requestParentProductIdField (boolean value) {
      this.requestField("parent_product_id", value);
      return this;
    }
    public APIRequestGetProducts requestPatternField () {
      return this.requestPatternField(true);
    }
    public APIRequestGetProducts requestPatternField (boolean value) {
      this.requestField("pattern", value);
      return this;
    }
    public APIRequestGetProducts requestPostConversionSignalBasedEnforcementAppealEligibilityField () {
      return this.requestPostConversionSignalBasedEnforcementAppealEligibilityField(true);
    }
    public APIRequestGetProducts requestPostConversionSignalBasedEnforcementAppealEligibilityField (boolean value) {
      this.requestField("post_conversion_signal_based_enforcement_appeal_eligibility", value);
      return this;
    }
    public APIRequestGetProducts requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetProducts requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetProducts requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetProducts requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGetProducts requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGetProducts requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
      return this;
    }
    public APIRequestGetProducts requestProductGroupField () {
      return this.requestProductGroupField(true);
    }
    public APIRequestGetProducts requestProductGroupField (boolean value) {
      this.requestField("product_group", value);
      return this;
    }
    public APIRequestGetProducts requestProductLocalInfoField () {
      return this.requestProductLocalInfoField(true);
    }
    public APIRequestGetProducts requestProductLocalInfoField (boolean value) {
      this.requestField("product_local_info", value);
      return this;
    }
    public APIRequestGetProducts requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGetProducts requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGetProducts requestQuantityToSellOnFacebookField () {
      return this.requestQuantityToSellOnFacebookField(true);
    }
    public APIRequestGetProducts requestQuantityToSellOnFacebookField (boolean value) {
      this.requestField("quantity_to_sell_on_facebook", value);
      return this;
    }
    public APIRequestGetProducts requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetProducts requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetProducts requestRetailerProductGroupIdField () {
      return this.requestRetailerProductGroupIdField(true);
    }
    public APIRequestGetProducts requestRetailerProductGroupIdField (boolean value) {
      this.requestField("retailer_product_group_id", value);
      return this;
    }
    public APIRequestGetProducts requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGetProducts requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGetProducts requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetProducts requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetProducts requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceEndDateField () {
      return this.requestSalePriceEndDateField(true);
    }
    public APIRequestGetProducts requestSalePriceEndDateField (boolean value) {
      this.requestField("sale_price_end_date", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceStartDateField () {
      return this.requestSalePriceStartDateField(true);
    }
    public APIRequestGetProducts requestSalePriceStartDateField (boolean value) {
      this.requestField("sale_price_start_date", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightUnitField () {
      return this.requestShippingWeightUnitField(true);
    }
    public APIRequestGetProducts requestShippingWeightUnitField (boolean value) {
      this.requestField("shipping_weight_unit", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightValueField () {
      return this.requestShippingWeightValueField(true);
    }
    public APIRequestGetProducts requestShippingWeightValueField (boolean value) {
      this.requestField("shipping_weight_value", value);
      return this;
    }
    public APIRequestGetProducts requestShortDescriptionField () {
      return this.requestShortDescriptionField(true);
    }
    public APIRequestGetProducts requestShortDescriptionField (boolean value) {
      this.requestField("short_description", value);
      return this;
    }
    public APIRequestGetProducts requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGetProducts requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGetProducts requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGetProducts requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGetProducts requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetProducts requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetProducts requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetProducts requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetProducts requestVideoFetchStatusField () {
      return this.requestVideoFetchStatusField(true);
    }
    public APIRequestGetProducts requestVideoFetchStatusField (boolean value) {
      this.requestField("video_fetch_status", value);
      return this;
    }
    public APIRequestGetProducts requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetProducts requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetProducts requestWaComplianceCategoryField () {
      return this.requestWaComplianceCategoryField(true);
    }
    public APIRequestGetProducts requestWaComplianceCategoryField (boolean value) {
      this.requestField("wa_compliance_category", value);
      return this;
    }
  }

  public static class APIRequestGetVehicleOffers extends APIRequest<VehicleOffer> {

    APINodeList<VehicleOffer> lastResponse = null;
    @Override
    public APINodeList<VehicleOffer> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "amount_currency",
      "amount_percentage",
      "amount_price",
      "amount_qualifier",
      "applinks",
      "availability",
      "body_style",
      "cashback_currency",
      "cashback_price",
      "category_specific_fields",
      "currency",
      "dma_codes",
      "downpayment_currency",
      "downpayment_price",
      "downpayment_qualifier",
      "drivetrain",
      "end_date",
      "end_time",
      "exterior_color",
      "fuel_type",
      "generation",
      "id",
      "image_fetch_status",
      "images",
      "interior_color",
      "interior_upholstery",
      "make",
      "model",
      "offer_description",
      "offer_disclaimer",
      "offer_type",
      "price",
      "sanitized_images",
      "start_date",
      "start_time",
      "term_length",
      "term_qualifier",
      "title",
      "transmission",
      "trim",
      "unit_price",
      "url",
      "vehicle_offer_id",
      "visibility",
      "year",
    };

    @Override
    public APINodeList<VehicleOffer> parseResponse(String response, String header) throws APIException {
      return VehicleOffer.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<VehicleOffer> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VehicleOffer> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VehicleOffer>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VehicleOffer>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<VehicleOffer>>() {
           public APINodeList<VehicleOffer> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVehicleOffers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVehicleOffers(String nodeId, APIContext context) {
      super(context, nodeId, "/vehicle_offers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVehicleOffers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVehicleOffers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVehicleOffers setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetVehicleOffers setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetVehicleOffers setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetVehicleOffers setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetVehicleOffers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVehicleOffers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicleOffers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVehicleOffers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicleOffers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVehicleOffers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVehicleOffers requestAmountCurrencyField () {
      return this.requestAmountCurrencyField(true);
    }
    public APIRequestGetVehicleOffers requestAmountCurrencyField (boolean value) {
      this.requestField("amount_currency", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestAmountPercentageField () {
      return this.requestAmountPercentageField(true);
    }
    public APIRequestGetVehicleOffers requestAmountPercentageField (boolean value) {
      this.requestField("amount_percentage", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestAmountPriceField () {
      return this.requestAmountPriceField(true);
    }
    public APIRequestGetVehicleOffers requestAmountPriceField (boolean value) {
      this.requestField("amount_price", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestAmountQualifierField () {
      return this.requestAmountQualifierField(true);
    }
    public APIRequestGetVehicleOffers requestAmountQualifierField (boolean value) {
      this.requestField("amount_qualifier", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetVehicleOffers requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetVehicleOffers requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGetVehicleOffers requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestCashbackCurrencyField () {
      return this.requestCashbackCurrencyField(true);
    }
    public APIRequestGetVehicleOffers requestCashbackCurrencyField (boolean value) {
      this.requestField("cashback_currency", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestCashbackPriceField () {
      return this.requestCashbackPriceField(true);
    }
    public APIRequestGetVehicleOffers requestCashbackPriceField (boolean value) {
      this.requestField("cashback_price", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetVehicleOffers requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetVehicleOffers requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestDmaCodesField () {
      return this.requestDmaCodesField(true);
    }
    public APIRequestGetVehicleOffers requestDmaCodesField (boolean value) {
      this.requestField("dma_codes", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestDownpaymentCurrencyField () {
      return this.requestDownpaymentCurrencyField(true);
    }
    public APIRequestGetVehicleOffers requestDownpaymentCurrencyField (boolean value) {
      this.requestField("downpayment_currency", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestDownpaymentPriceField () {
      return this.requestDownpaymentPriceField(true);
    }
    public APIRequestGetVehicleOffers requestDownpaymentPriceField (boolean value) {
      this.requestField("downpayment_price", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestDownpaymentQualifierField () {
      return this.requestDownpaymentQualifierField(true);
    }
    public APIRequestGetVehicleOffers requestDownpaymentQualifierField (boolean value) {
      this.requestField("downpayment_qualifier", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGetVehicleOffers requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGetVehicleOffers requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetVehicleOffers requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGetVehicleOffers requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGetVehicleOffers requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestGenerationField () {
      return this.requestGenerationField(true);
    }
    public APIRequestGetVehicleOffers requestGenerationField (boolean value) {
      this.requestField("generation", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVehicleOffers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetVehicleOffers requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetVehicleOffers requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGetVehicleOffers requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestInteriorUpholsteryField () {
      return this.requestInteriorUpholsteryField(true);
    }
    public APIRequestGetVehicleOffers requestInteriorUpholsteryField (boolean value) {
      this.requestField("interior_upholstery", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGetVehicleOffers requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGetVehicleOffers requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestOfferDescriptionField () {
      return this.requestOfferDescriptionField(true);
    }
    public APIRequestGetVehicleOffers requestOfferDescriptionField (boolean value) {
      this.requestField("offer_description", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestOfferDisclaimerField () {
      return this.requestOfferDisclaimerField(true);
    }
    public APIRequestGetVehicleOffers requestOfferDisclaimerField (boolean value) {
      this.requestField("offer_disclaimer", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestOfferTypeField () {
      return this.requestOfferTypeField(true);
    }
    public APIRequestGetVehicleOffers requestOfferTypeField (boolean value) {
      this.requestField("offer_type", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetVehicleOffers requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetVehicleOffers requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGetVehicleOffers requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetVehicleOffers requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestTermLengthField () {
      return this.requestTermLengthField(true);
    }
    public APIRequestGetVehicleOffers requestTermLengthField (boolean value) {
      this.requestField("term_length", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestTermQualifierField () {
      return this.requestTermQualifierField(true);
    }
    public APIRequestGetVehicleOffers requestTermQualifierField (boolean value) {
      this.requestField("term_qualifier", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetVehicleOffers requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGetVehicleOffers requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGetVehicleOffers requestTrimField (boolean value) {
      this.requestField("trim", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetVehicleOffers requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVehicleOffers requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestVehicleOfferIdField () {
      return this.requestVehicleOfferIdField(true);
    }
    public APIRequestGetVehicleOffers requestVehicleOfferIdField (boolean value) {
      this.requestField("vehicle_offer_id", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetVehicleOffers requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetVehicleOffers requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGetVehicleOffers requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
    }
  }

  public static class APIRequestGetVehicles extends APIRequest<Vehicle> {

    APINodeList<Vehicle> lastResponse = null;
    @Override
    public APINodeList<Vehicle> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "availability",
      "body_style",
      "category_specific_fields",
      "condition",
      "currency",
      "custom_label_0",
      "date_first_on_lot",
      "dealer_communication_channel",
      "dealer_email",
      "dealer_id",
      "dealer_name",
      "dealer_phone",
      "dealer_privacy_policy_url",
      "description",
      "drivetrain",
      "exterior_color",
      "fb_page_id",
      "features",
      "fuel_type",
      "id",
      "image_fetch_status",
      "images",
      "interior_color",
      "legal_disclosure_impressum_url",
      "make",
      "mileage",
      "model",
      "previous_currency",
      "previous_price",
      "price",
      "sale_currency",
      "sale_price",
      "sanitized_images",
      "state_of_vehicle",
      "title",
      "transmission",
      "trim",
      "unit_price",
      "url",
      "vehicle_id",
      "vehicle_registration_plate",
      "vehicle_specifications",
      "vehicle_type",
      "vin",
      "visibility",
      "year",
    };

    @Override
    public APINodeList<Vehicle> parseResponse(String response, String header) throws APIException {
      return Vehicle.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Vehicle> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Vehicle> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Vehicle>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Vehicle>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Vehicle>>() {
           public APINodeList<Vehicle> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVehicles.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVehicles(String nodeId, APIContext context) {
      super(context, nodeId, "/vehicles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVehicles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVehicles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVehicles setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetVehicles setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetVehicles setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetVehicles setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetVehicles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVehicles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVehicles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVehicles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVehicles requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetVehicles requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetVehicles requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetVehicles requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetVehicles requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetVehicles requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetVehicles requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGetVehicles requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGetVehicles requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGetVehicles requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGetVehicles requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGetVehicles requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGetVehicles requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetVehicles requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetVehicles requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetVehicles requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetVehicles requestDateFirstOnLotField () {
      return this.requestDateFirstOnLotField(true);
    }
    public APIRequestGetVehicles requestDateFirstOnLotField (boolean value) {
      this.requestField("date_first_on_lot", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerCommunicationChannelField () {
      return this.requestDealerCommunicationChannelField(true);
    }
    public APIRequestGetVehicles requestDealerCommunicationChannelField (boolean value) {
      this.requestField("dealer_communication_channel", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerEmailField () {
      return this.requestDealerEmailField(true);
    }
    public APIRequestGetVehicles requestDealerEmailField (boolean value) {
      this.requestField("dealer_email", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerIdField () {
      return this.requestDealerIdField(true);
    }
    public APIRequestGetVehicles requestDealerIdField (boolean value) {
      this.requestField("dealer_id", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerNameField () {
      return this.requestDealerNameField(true);
    }
    public APIRequestGetVehicles requestDealerNameField (boolean value) {
      this.requestField("dealer_name", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerPhoneField () {
      return this.requestDealerPhoneField(true);
    }
    public APIRequestGetVehicles requestDealerPhoneField (boolean value) {
      this.requestField("dealer_phone", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerPrivacyPolicyUrlField () {
      return this.requestDealerPrivacyPolicyUrlField(true);
    }
    public APIRequestGetVehicles requestDealerPrivacyPolicyUrlField (boolean value) {
      this.requestField("dealer_privacy_policy_url", value);
      return this;
    }
    public APIRequestGetVehicles requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetVehicles requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetVehicles requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGetVehicles requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGetVehicles requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGetVehicles requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGetVehicles requestFbPageIdField () {
      return this.requestFbPageIdField(true);
    }
    public APIRequestGetVehicles requestFbPageIdField (boolean value) {
      this.requestField("fb_page_id", value);
      return this;
    }
    public APIRequestGetVehicles requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetVehicles requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetVehicles requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGetVehicles requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGetVehicles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVehicles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVehicles requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGetVehicles requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGetVehicles requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetVehicles requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetVehicles requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGetVehicles requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGetVehicles requestLegalDisclosureImpressumUrlField () {
      return this.requestLegalDisclosureImpressumUrlField(true);
    }
    public APIRequestGetVehicles requestLegalDisclosureImpressumUrlField (boolean value) {
      this.requestField("legal_disclosure_impressum_url", value);
      return this;
    }
    public APIRequestGetVehicles requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGetVehicles requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGetVehicles requestMileageField () {
      return this.requestMileageField(true);
    }
    public APIRequestGetVehicles requestMileageField (boolean value) {
      this.requestField("mileage", value);
      return this;
    }
    public APIRequestGetVehicles requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGetVehicles requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGetVehicles requestPreviousCurrencyField () {
      return this.requestPreviousCurrencyField(true);
    }
    public APIRequestGetVehicles requestPreviousCurrencyField (boolean value) {
      this.requestField("previous_currency", value);
      return this;
    }
    public APIRequestGetVehicles requestPreviousPriceField () {
      return this.requestPreviousPriceField(true);
    }
    public APIRequestGetVehicles requestPreviousPriceField (boolean value) {
      this.requestField("previous_price", value);
      return this;
    }
    public APIRequestGetVehicles requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetVehicles requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetVehicles requestSaleCurrencyField () {
      return this.requestSaleCurrencyField(true);
    }
    public APIRequestGetVehicles requestSaleCurrencyField (boolean value) {
      this.requestField("sale_currency", value);
      return this;
    }
    public APIRequestGetVehicles requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetVehicles requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetVehicles requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetVehicles requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetVehicles requestStateOfVehicleField () {
      return this.requestStateOfVehicleField(true);
    }
    public APIRequestGetVehicles requestStateOfVehicleField (boolean value) {
      this.requestField("state_of_vehicle", value);
      return this;
    }
    public APIRequestGetVehicles requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetVehicles requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetVehicles requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGetVehicles requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGetVehicles requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGetVehicles requestTrimField (boolean value) {
      this.requestField("trim", value);
      return this;
    }
    public APIRequestGetVehicles requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGetVehicles requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGetVehicles requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVehicles requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleIdField () {
      return this.requestVehicleIdField(true);
    }
    public APIRequestGetVehicles requestVehicleIdField (boolean value) {
      this.requestField("vehicle_id", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleRegistrationPlateField () {
      return this.requestVehicleRegistrationPlateField(true);
    }
    public APIRequestGetVehicles requestVehicleRegistrationPlateField (boolean value) {
      this.requestField("vehicle_registration_plate", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleSpecificationsField () {
      return this.requestVehicleSpecificationsField(true);
    }
    public APIRequestGetVehicles requestVehicleSpecificationsField (boolean value) {
      this.requestField("vehicle_specifications", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleTypeField () {
      return this.requestVehicleTypeField(true);
    }
    public APIRequestGetVehicles requestVehicleTypeField (boolean value) {
      this.requestField("vehicle_type", value);
      return this;
    }
    public APIRequestGetVehicles requestVinField () {
      return this.requestVinField(true);
    }
    public APIRequestGetVehicles requestVinField (boolean value) {
      this.requestField("vin", value);
      return this;
    }
    public APIRequestGetVehicles requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetVehicles requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetVehicles requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGetVehicles requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_live_product_set_deletion",
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


    public APIRequestDelete setAllowLiveProductSetDeletion (Boolean allowLiveProductSetDeletion) {
      this.setParam("allow_live_product_set_deletion", allowLiveProductSetDeletion);
      return this;
    }
    public APIRequestDelete setAllowLiveProductSetDeletion (String allowLiveProductSetDeletion) {
      this.setParam("allow_live_product_set_deletion", allowLiveProductSetDeletion);
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

  public static class APIRequestGet extends APIRequest<ProductSet> {

    ProductSet lastResponse = null;
    @Override
    public ProductSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "auto_creation_url",
      "filter",
      "id",
      "latest_metadata",
      "live_metadata",
      "name",
      "ordering_info",
      "product_catalog",
      "product_count",
      "retailer_id",
    };

    @Override
    public ProductSet parseResponse(String response, String header) throws APIException {
      return ProductSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductSet>() {
           public ProductSet apply(ResponseWrapper result) {
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

    public APIRequestGet requestAutoCreationUrlField () {
      return this.requestAutoCreationUrlField(true);
    }
    public APIRequestGet requestAutoCreationUrlField (boolean value) {
      this.requestField("auto_creation_url", value);
      return this;
    }
    public APIRequestGet requestFilterField () {
      return this.requestFilterField(true);
    }
    public APIRequestGet requestFilterField (boolean value) {
      this.requestField("filter", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLatestMetadataField () {
      return this.requestLatestMetadataField(true);
    }
    public APIRequestGet requestLatestMetadataField (boolean value) {
      this.requestField("latest_metadata", value);
      return this;
    }
    public APIRequestGet requestLiveMetadataField () {
      return this.requestLiveMetadataField(true);
    }
    public APIRequestGet requestLiveMetadataField (boolean value) {
      this.requestField("live_metadata", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOrderingInfoField () {
      return this.requestOrderingInfoField(true);
    }
    public APIRequestGet requestOrderingInfoField (boolean value) {
      this.requestField("ordering_info", value);
      return this;
    }
    public APIRequestGet requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGet requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGet requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGet requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGet requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGet requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ProductSet> {

    ProductSet lastResponse = null;
    @Override
    public ProductSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter",
      "metadata",
      "name",
      "ordering_info",
      "publish_to_shops",
      "retailer_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductSet parseResponse(String response, String header) throws APIException {
      return ProductSet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductSet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductSet>() {
           public ProductSet apply(ResponseWrapper result) {
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


    public APIRequestUpdate setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestUpdate setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestUpdate setMetadata (Map<String, String> metadata) {
      this.setParam("metadata", metadata);
      return this;
    }
    public APIRequestUpdate setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setOrderingInfo (List<Long> orderingInfo) {
      this.setParam("ordering_info", orderingInfo);
      return this;
    }
    public APIRequestUpdate setOrderingInfo (String orderingInfo) {
      this.setParam("ordering_info", orderingInfo);
      return this;
    }

    public APIRequestUpdate setPublishToShops (List<Map<String, String>> publishToShops) {
      this.setParam("publish_to_shops", publishToShops);
      return this;
    }
    public APIRequestUpdate setPublishToShops (String publishToShops) {
      this.setParam("publish_to_shops", publishToShops);
      return this;
    }

    public APIRequestUpdate setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
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

  public ProductSet copyFrom(ProductSet instance) {
    this.mAutoCreationUrl = instance.mAutoCreationUrl;
    this.mFilter = instance.mFilter;
    this.mId = instance.mId;
    this.mLatestMetadata = instance.mLatestMetadata;
    this.mLiveMetadata = instance.mLiveMetadata;
    this.mName = instance.mName;
    this.mOrderingInfo = instance.mOrderingInfo;
    this.mProductCatalog = instance.mProductCatalog;
    this.mProductCount = instance.mProductCount;
    this.mRetailerId = instance.mRetailerId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductSet> getParser() {
    return new APIRequest.ResponseParser<ProductSet>() {
      public APINodeList<ProductSet> parseResponse(String response, APIContext context, APIRequest<ProductSet> request, String header) throws MalformedResponseException {
        return ProductSet.parseResponse(response, context, request, header);
      }
    };
  }
}
