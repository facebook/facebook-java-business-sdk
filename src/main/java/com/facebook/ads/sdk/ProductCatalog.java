/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class ProductCatalog extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("feed_count")
  private Long mFeedCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_count")
  private Long mProductCount = null;
  protected static Gson gson = null;

  ProductCatalog() {
  }

  public ProductCatalog(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductCatalog(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ProductCatalog fetch() throws APIException{
    ProductCatalog newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductCatalog fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductCatalog fetchById(String id, APIContext context) throws APIException {
    ProductCatalog productCatalog =
      new APIRequestGet(id, context)
      .requestAllFields()
      .call();
    return productCatalog;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductCatalog loadJSON(String json, APIContext context) {
    ProductCatalog productCatalog = getGson().fromJson(json, ProductCatalog.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalog.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productCatalog.mContext = context;
    productCatalog.rawValue = json;
    return productCatalog;
  }

  public static APINodeList<ProductCatalog> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductCatalog> productCatalogs = new APINodeList<ProductCatalog>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productCatalogs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productCatalogs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productCatalogs.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            productCatalogs.add(loadJSON(obj.toString(), context));
          }
          return productCatalogs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogs.add(loadJSON(entry.getValue().toString(), context));
          }
          return productCatalogs;
        } else {
          // Fifth, check if it's pure JsonObject
          productCatalogs.add(loadJSON(json, context));
          return productCatalogs;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetExternalEventSources getExternalEventSources() {
    return new APIRequestGetExternalEventSources(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetProductGroups getProductGroups() {
    return new APIRequestGetProductGroups(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetProductFeeds getProductFeeds() {
    return new APIRequestGetProductFeeds(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetProductSets getProductSets() {
    return new APIRequestGetProductSets(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateExternalEventSource createExternalEventSource() {
    return new APIRequestCreateExternalEventSource(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateProductGroup createProductGroup() {
    return new APIRequestCreateProductGroup(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateProductFeed createProductFeed() {
    return new APIRequestCreateProductFeed(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateProductSet createProductSet() {
    return new APIRequestCreateProductSet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteExternalEventSources deleteExternalEventSources() {
    return new APIRequestDeleteExternalEventSources(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.mContext = getContext();
    }
    return mBusiness;
  }

  public Long getFieldFeedCount() {
    return mFeedCount;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldProductCount() {
    return mProductCount;
  }



  public static class APIRequestGet extends APIRequest<ProductCatalog> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "business",
      "feed_count",
      "name",
      "product_count",
    };

    @Override
    public ProductCatalog call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog call(Map<String, Object> extraParams) throws APIException {
      return ProductCatalog.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

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
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGet requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGet requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete setId (String id) {
      this.setParam("id", id);
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

    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetAgencies extends APIRequest<Business> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "primary_page",
    };

    @Override
    public APINodeList<Business> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> call(Map<String, Object> extraParams) throws APIException {
      return Business.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetAgencies requestPaymentAccountIdField () {
      return this.requestPaymentAccountIdField(true);
    }
    public APIRequestGetAgencies requestPaymentAccountIdField (boolean value) {
      this.requestField("payment_account_id", value);
      return this;
    }

  }

  public static class APIRequestGetExternalEventSources extends APIRequest<ExternalEventSource> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "source_type",
    };

    @Override
    public APINodeList<ExternalEventSource> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExternalEventSource> call(Map<String, Object> extraParams) throws APIException {
      return ExternalEventSource.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetExternalEventSources(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetExternalEventSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetExternalEventSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExternalEventSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExternalEventSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetExternalEventSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetExternalEventSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetExternalEventSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExternalEventSources requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExternalEventSources requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExternalEventSources requestSourceTypeField () {
      return this.requestSourceTypeField(true);
    }
    public APIRequestGetExternalEventSources requestSourceTypeField (boolean value) {
      this.requestField("source_type", value);
      return this;
    }

  }

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    public static final String[] PARAMS = {
      "filter",
    };

    public static final String[] FIELDS = {
      "id",
      "additional_image_urls",
      "applinks",
      "age_group",
      "availability",
      "brand",
      "category",
      "color",
      "commerce_insights",
      "condition",
      "custom_data",
      "description",
      "expiration_date",
      "gender",
      "gtin",
      "image_url",
      "material",
      "manufacturer_part_number",
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_type",
      "retailer_id",
      "retailer_product_group_id",
      "review_rejection_reasons",
      "review_status",
      "sale_price",
      "sale_price_start_date",
      "sale_price_end_date",
      "shipping_weight_value",
      "shipping_weight_unit",
      "size",
      "start_date",
      "url",
      "visibility",
      "product_feed",
    };

    @Override
    public APINodeList<ProductItem> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductItem> call(Map<String, Object> extraParams) throws APIException {
      return ProductItem.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetProducts(String nodeId, APIContext context) {
      super(context, nodeId, "/products", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetProducts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetProducts setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestGetProducts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetProducts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProducts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProducts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProducts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGetProducts requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetProducts requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetProducts requestAgeGroupField () {
      return this.requestAgeGroupField(true);
    }
    public APIRequestGetProducts requestAgeGroupField (boolean value) {
      this.requestField("age_group", value);
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
    public APIRequestGetProducts requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetProducts requestCategoryField (boolean value) {
      this.requestField("category", value);
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
    public APIRequestGetProducts requestCustomDataField () {
      return this.requestCustomDataField(true);
    }
    public APIRequestGetProducts requestCustomDataField (boolean value) {
      this.requestField("custom_data", value);
      return this;
    }
    public APIRequestGetProducts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetProducts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetProducts requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGetProducts requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
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
    public APIRequestGetProducts requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetProducts requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetProducts requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGetProducts requestMaterialField (boolean value) {
      this.requestField("material", value);
      return this;
    }
    public APIRequestGetProducts requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGetProducts requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
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
    public APIRequestGetProducts requestPatternField () {
      return this.requestPatternField(true);
    }
    public APIRequestGetProducts requestPatternField (boolean value) {
      this.requestField("pattern", value);
      return this;
    }
    public APIRequestGetProducts requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetProducts requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetProducts requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGetProducts requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
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
    public APIRequestGetProducts requestSalePriceStartDateField () {
      return this.requestSalePriceStartDateField(true);
    }
    public APIRequestGetProducts requestSalePriceStartDateField (boolean value) {
      this.requestField("sale_price_start_date", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceEndDateField () {
      return this.requestSalePriceEndDateField(true);
    }
    public APIRequestGetProducts requestSalePriceEndDateField (boolean value) {
      this.requestField("sale_price_end_date", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightValueField () {
      return this.requestShippingWeightValueField(true);
    }
    public APIRequestGetProducts requestShippingWeightValueField (boolean value) {
      this.requestField("shipping_weight_value", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightUnitField () {
      return this.requestShippingWeightUnitField(true);
    }
    public APIRequestGetProducts requestShippingWeightUnitField (boolean value) {
      this.requestField("shipping_weight_unit", value);
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
    public APIRequestGetProducts requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetProducts requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetProducts requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetProducts requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGetProducts requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGetProducts requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
      return this;
    }

  }

  public static class APIRequestGetProductGroups extends APIRequest<ProductGroup> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "retailer_id",
      "variants",
    };

    @Override
    public APINodeList<ProductGroup> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductGroup> call(Map<String, Object> extraParams) throws APIException {
      return ProductGroup.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetProductGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/product_groups", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetProductGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetProductGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetProductGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductGroups requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetProductGroups requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetProductGroups requestVariantsField () {
      return this.requestVariantsField(true);
    }
    public APIRequestGetProductGroups requestVariantsField (boolean value) {
      this.requestField("variants", value);
      return this;
    }

  }

  public static class APIRequestGetProductFeeds extends APIRequest<ProductFeed> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "country",
      "created_time",
      "deletion_enabled",
      "delimiter",
      "encoding",
      "file_name",
      "latest_upload",
      "name",
      "product_count",
      "quoted_fields",
      "schedule",
    };

    @Override
    public APINodeList<ProductFeed> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeed> call(Map<String, Object> extraParams) throws APIException {
      return ProductFeed.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetProductFeeds(String nodeId, APIContext context) {
      super(context, nodeId, "/product_feeds", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetProductFeeds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetProductFeeds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductFeeds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductFeeds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductFeeds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetProductFeeds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductFeeds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductFeeds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductFeeds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductFeeds requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetProductFeeds requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetProductFeeds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetProductFeeds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetProductFeeds requestDeletionEnabledField () {
      return this.requestDeletionEnabledField(true);
    }
    public APIRequestGetProductFeeds requestDeletionEnabledField (boolean value) {
      this.requestField("deletion_enabled", value);
      return this;
    }
    public APIRequestGetProductFeeds requestDelimiterField () {
      return this.requestDelimiterField(true);
    }
    public APIRequestGetProductFeeds requestDelimiterField (boolean value) {
      this.requestField("delimiter", value);
      return this;
    }
    public APIRequestGetProductFeeds requestEncodingField () {
      return this.requestEncodingField(true);
    }
    public APIRequestGetProductFeeds requestEncodingField (boolean value) {
      this.requestField("encoding", value);
      return this;
    }
    public APIRequestGetProductFeeds requestFileNameField () {
      return this.requestFileNameField(true);
    }
    public APIRequestGetProductFeeds requestFileNameField (boolean value) {
      this.requestField("file_name", value);
      return this;
    }
    public APIRequestGetProductFeeds requestLatestUploadField () {
      return this.requestLatestUploadField(true);
    }
    public APIRequestGetProductFeeds requestLatestUploadField (boolean value) {
      this.requestField("latest_upload", value);
      return this;
    }
    public APIRequestGetProductFeeds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductFeeds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductFeeds requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductFeeds requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetProductFeeds requestQuotedFieldsField () {
      return this.requestQuotedFieldsField(true);
    }
    public APIRequestGetProductFeeds requestQuotedFieldsField (boolean value) {
      this.requestField("quoted_fields", value);
      return this;
    }
    public APIRequestGetProductFeeds requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetProductFeeds requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }

  }

  public static class APIRequestGetProductSets extends APIRequest<ProductSet> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "filter",
      "product_count",
    };

    @Override
    public APINodeList<ProductSet> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductSet> call(Map<String, Object> extraParams) throws APIException {
      return ProductSet.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetProductSets(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetProductSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetProductSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetProductSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetProductSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductSets requestFilterField () {
      return this.requestFilterField(true);
    }
    public APIRequestGetProductSets requestFilterField (boolean value) {
      this.requestField("filter", value);
      return this;
    }
    public APIRequestGetProductSets requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductSets requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }

  }

  public static class APIRequestCreateExternalEventSource extends APIRequest<ExternalEventSource> {

    public static final String[] PARAMS = {
      "id",
      "external_event_sources",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ExternalEventSource call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ExternalEventSource call(Map<String, Object> extraParams) throws APIException {
      return ExternalEventSource.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateExternalEventSource(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateExternalEventSource setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateExternalEventSource setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExternalEventSource setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateExternalEventSource setExternalEventSources (List<String> externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestCreateExternalEventSource setExternalEventSources (String externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestCreateExternalEventSource requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExternalEventSource requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateExternalEventSource requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateExternalEventSource requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateExternalEventSource requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateProductGroup extends APIRequest<ProductGroup> {

    public static final String[] PARAMS = {
      "id",
      "retailer_id",
      "variants",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductGroup call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductGroup call(Map<String, Object> extraParams) throws APIException {
      return ProductGroup.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateProductGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/product_groups", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateProductGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateProductGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductGroup setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateProductGroup setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
      return this;
    }


    public APIRequestCreateProductGroup setVariants (List<Object> variants) {
      this.setParam("variants", variants);
      return this;
    }

    public APIRequestCreateProductGroup setVariants (String variants) {
      this.setParam("variants", variants);
      return this;
    }

    public APIRequestCreateProductGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateProductGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateProductFeed extends APIRequest<ProductFeed> {

    public static final String[] PARAMS = {
      "id",
      "country",
      "deletion_enabled",
      "encoding",
      "delimiter",
      "default_currency",
      "file_name",
      "name",
      "schedule",
      "quoted_fields",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductFeed call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductFeed call(Map<String, Object> extraParams) throws APIException {
      return ProductFeed.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateProductFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/product_feeds", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateProductFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateProductFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductFeed setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateProductFeed setCountry (String country) {
      this.setParam("country", country);
      return this;
    }


    public APIRequestCreateProductFeed setDeletionEnabled (Boolean deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
      return this;
    }

    public APIRequestCreateProductFeed setDeletionEnabled (String deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
      return this;
    }

    public APIRequestCreateProductFeed setEncoding (EnumEncoding encoding) {
      this.setParam("encoding", encoding);
      return this;
    }

    public APIRequestCreateProductFeed setEncoding (String encoding) {
      this.setParam("encoding", encoding);
      return this;
    }

    public APIRequestCreateProductFeed setDelimiter (EnumDelimiter delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }

    public APIRequestCreateProductFeed setDelimiter (String delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }

    public APIRequestCreateProductFeed setDefaultCurrency (String defaultCurrency) {
      this.setParam("default_currency", defaultCurrency);
      return this;
    }


    public APIRequestCreateProductFeed setFileName (String fileName) {
      this.setParam("file_name", fileName);
      return this;
    }


    public APIRequestCreateProductFeed setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateProductFeed setSchedule (String schedule) {
      this.setParam("schedule", schedule);
      return this;
    }


    public APIRequestCreateProductFeed setQuotedFields (Boolean quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }

    public APIRequestCreateProductFeed setQuotedFields (String quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }

    public APIRequestCreateProductFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateProductFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateProductSet extends APIRequest<ProductSet> {

    public static final String[] PARAMS = {
      "filter",
      "id",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductSet call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductSet call(Map<String, Object> extraParams) throws APIException {
      return ProductSet.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateProductSet(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateProductSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateProductSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductSet setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }


    public APIRequestCreateProductSet setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateProductSet setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestCreateProductSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateProductSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateProductSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteExternalEventSources extends APIRequest<ExternalEventSource> {

    public static final String[] PARAMS = {
      "id",
      "external_event_sources",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<ExternalEventSource> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExternalEventSource> call(Map<String, Object> extraParams) throws APIException {
      return ExternalEventSource.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestDeleteExternalEventSources(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteExternalEventSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteExternalEventSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteExternalEventSources setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteExternalEventSources setExternalEventSources (List<String> externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestDeleteExternalEventSources setExternalEventSources (String externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestDeleteExternalEventSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteExternalEventSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteExternalEventSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteExternalEventSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteExternalEventSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumEncoding {
    @SerializedName("AUTODETECT")
    VALUE_AUTODETECT("AUTODETECT"),
    @SerializedName("LATIN1")
    VALUE_LATIN1("LATIN1"),
    @SerializedName("UTF8")
    VALUE_UTF8("UTF8"),
    @SerializedName("UTF16LE")
    VALUE_UTF16LE("UTF16LE"),
    @SerializedName("UTF16BE")
    VALUE_UTF16BE("UTF16BE"),
    @SerializedName("UTF32LE")
    VALUE_UTF32LE("UTF32LE"),
    @SerializedName("UTF32BE")
    VALUE_UTF32BE("UTF32BE"),
    NULL(null);

    private String value;

    private EnumEncoding(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumDelimiter {
    @SerializedName("AUTODETECT")
    VALUE_AUTODETECT("AUTODETECT"),
    @SerializedName("BAR")
    VALUE_BAR("BAR"),
    @SerializedName("COMMA")
    VALUE_COMMA("COMMA"),
    @SerializedName("TAB")
    VALUE_TAB("TAB"),
    @SerializedName("TILDE")
    VALUE_TILDE("TILDE"),
    NULL(null);

    private String value;

    private EnumDelimiter(String value) {
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

  public ProductCatalog copyFrom(ProductCatalog instance) {
    this.mId = instance.mId;
    this.mBusiness = instance.mBusiness;
    this.mFeedCount = instance.mFeedCount;
    this.mName = instance.mName;
    this.mProductCount = instance.mProductCount;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}