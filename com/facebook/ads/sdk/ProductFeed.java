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


public class ProductFeed extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("deletion_enabled")
  private Boolean mDeletionEnabled = null;
  @SerializedName("delimiter")
  private EnumProductFeedDelimiter mDelimiter = null;
  @SerializedName("encoding")
  private EnumProductFeedEncoding mEncoding = null;
  @SerializedName("file_name")
  private String mFileName = null;
  @SerializedName("latest_upload")
  private ProductFeedUpload mLatestUpload = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_count")
  private Long mProductCount = null;
  @SerializedName("quoted_fields")
  private Boolean mQuotedFields = null;
  @SerializedName("schedule")
  private ProductFeedSchedule mSchedule = null;
  protected static Gson gson = null;

  ProductFeed() {
  }

  public ProductFeed(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeed(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ProductFeed fetch() throws APIException{
    ProductFeed newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeed fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductFeed fetchById(String id, APIContext context) throws APIException {
    ProductFeed productFeed =
      new APIRequestGet(id, context)
      .requestAllFields()
      .call();
    return productFeed;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductFeed loadJSON(String json, APIContext context) {
    ProductFeed productFeed = getGson().fromJson(json, ProductFeed.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeed.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeed.mContext = context;
    productFeed.rawValue = json;
    return productFeed;
  }

  public static APINodeList<ProductFeed> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductFeed> productFeeds = new APINodeList<ProductFeed>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productFeeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productFeeds;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productFeeds.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            productFeeds.add(loadJSON(obj.toString(), context));
          }
          return productFeeds;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeeds.add(loadJSON(entry.getValue().toString(), context));
          }
          return productFeeds;
        } else {
          // Fifth, check if it's pure JsonObject
          productFeeds.add(loadJSON(json, context));
          return productFeeds;
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

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetUploads getUploads() {
    return new APIRequestGetUploads(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateUpload createUpload() {
    return new APIRequestCreateUpload(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Boolean getFieldDeletionEnabled() {
    return mDeletionEnabled;
  }

  public EnumProductFeedDelimiter getFieldDelimiter() {
    return mDelimiter;
  }

  public EnumProductFeedEncoding getFieldEncoding() {
    return mEncoding;
  }

  public String getFieldFileName() {
    return mFileName;
  }

  public ProductFeedUpload getFieldLatestUpload() {
    if (mLatestUpload != null) {
      mLatestUpload.mContext = getContext();
    }
    return mLatestUpload;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldProductCount() {
    return mProductCount;
  }

  public Boolean getFieldQuotedFields() {
    return mQuotedFields;
  }

  public ProductFeedSchedule getFieldSchedule() {
    return mSchedule;
  }



  public static class APIRequestGet extends APIRequest<ProductFeed> {

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
    public ProductFeed call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductFeed call(Map<String, Object> extraParams) throws APIException {
      return ProductFeed.parseResponse(callInternal(extraParams), getContext(), this).head();
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
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDeletionEnabledField () {
      return this.requestDeletionEnabledField(true);
    }
    public APIRequestGet requestDeletionEnabledField (boolean value) {
      this.requestField("deletion_enabled", value);
      return this;
    }
    public APIRequestGet requestDelimiterField () {
      return this.requestDelimiterField(true);
    }
    public APIRequestGet requestDelimiterField (boolean value) {
      this.requestField("delimiter", value);
      return this;
    }
    public APIRequestGet requestEncodingField () {
      return this.requestEncodingField(true);
    }
    public APIRequestGet requestEncodingField (boolean value) {
      this.requestField("encoding", value);
      return this;
    }
    public APIRequestGet requestFileNameField () {
      return this.requestFileNameField(true);
    }
    public APIRequestGet requestFileNameField (boolean value) {
      this.requestField("file_name", value);
      return this;
    }
    public APIRequestGet requestLatestUploadField () {
      return this.requestLatestUploadField(true);
    }
    public APIRequestGet requestLatestUploadField (boolean value) {
      this.requestField("latest_upload", value);
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
    public APIRequestGet requestQuotedFieldsField () {
      return this.requestQuotedFieldsField(true);
    }
    public APIRequestGet requestQuotedFieldsField (boolean value) {
      this.requestField("quoted_fields", value);
      return this;
    }
    public APIRequestGet requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGet requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "name",
      "encoding",
      "delimiter",
      "schedule",
      "quoted_fields",
      "deletion_enabled",
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


    public APIRequestUpdate setEncoding (EnumUpdateEncoding encoding) {
      this.setParam("encoding", encoding);
      return this;
    }

    public APIRequestUpdate setEncoding (String encoding) {
      this.setParam("encoding", encoding);
      return this;
    }

    public APIRequestUpdate setDelimiter (EnumUpdateDelimiter delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }

    public APIRequestUpdate setDelimiter (String delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }

    public APIRequestUpdate setSchedule (String schedule) {
      this.setParam("schedule", schedule);
      return this;
    }


    public APIRequestUpdate setQuotedFields (Boolean quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }

    public APIRequestUpdate setQuotedFields (String quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }

    public APIRequestUpdate setDeletionEnabled (Boolean deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
      return this;
    }

    public APIRequestUpdate setDeletionEnabled (String deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
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

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    public static final String[] PARAMS = {
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

  public static class APIRequestGetUploads extends APIRequest<ProductFeedUpload> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "end_time",
      "input_method",
      "start_time",
      "url",
    };

    @Override
    public APINodeList<ProductFeedUpload> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUpload> call(Map<String, Object> extraParams) throws APIException {
      return ProductFeedUpload.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetUploads(String nodeId, APIContext context) {
      super(context, nodeId, "/uploads", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetUploads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetUploads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUploads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUploads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetUploads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetUploads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetUploads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUploads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUploads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUploads requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetUploads requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetUploads requestInputMethodField () {
      return this.requestInputMethodField(true);
    }
    public APIRequestGetUploads requestInputMethodField (boolean value) {
      this.requestField("input_method", value);
      return this;
    }
    public APIRequestGetUploads requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetUploads requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetUploads requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetUploads requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }

  }

  public static class APIRequestCreateUpload extends APIRequest<ProductFeedUpload> {

    public static final String[] PARAMS = {
      "id",
      "password",
      "url",
      "username",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductFeedUpload call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUpload call(Map<String, Object> extraParams) throws APIException {
      return ProductFeedUpload.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateUpload(String nodeId, APIContext context) {
      super(context, nodeId, "/uploads", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateUpload setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateUpload setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateUpload setUploadFile (File file) {
      this.setParam("file", file);
      return this;
    }

    public APIRequestCreateUpload setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateUpload setPassword (String password) {
      this.setParam("password", password);
      return this;
    }


    public APIRequestCreateUpload setUrl (String url) {
      this.setParam("url", url);
      return this;
    }


    public APIRequestCreateUpload setUsername (String username) {
      this.setParam("username", username);
      return this;
    }


    public APIRequestCreateUpload requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpload requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUpload requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateUpload requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUpload requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumUpdateEncoding {
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

    private EnumUpdateEncoding(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateDelimiter {
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

    private EnumUpdateDelimiter(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductFeedDelimiter {
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

    private EnumProductFeedDelimiter(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductFeedEncoding {
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

    private EnumProductFeedEncoding(String value) {
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

  public ProductFeed copyFrom(ProductFeed instance) {
    this.mId = instance.mId;
    this.mCountry = instance.mCountry;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDeletionEnabled = instance.mDeletionEnabled;
    this.mDelimiter = instance.mDelimiter;
    this.mEncoding = instance.mEncoding;
    this.mFileName = instance.mFileName;
    this.mLatestUpload = instance.mLatestUpload;
    this.mName = instance.mName;
    this.mProductCount = instance.mProductCount;
    this.mQuotedFields = instance.mQuotedFields;
    this.mSchedule = instance.mSchedule;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}