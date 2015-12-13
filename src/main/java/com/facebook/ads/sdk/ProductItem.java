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


public class ProductItem extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("additional_image_urls")
  private List<String> mAdditionalImageUrls = null;
  @SerializedName("applinks")
  private AppLinks mApplinks = null;
  @SerializedName("age_group")
  private EnumAgeGroup mAgeGroup = null;
  @SerializedName("availability")
  private EnumProductItemAvailability mAvailability = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("color")
  private String mColor = null;
  @SerializedName("commerce_insights")
  private ProductItemCommerceInsights mCommerceInsights = null;
  @SerializedName("condition")
  private EnumProductItemCondition mCondition = null;
  @SerializedName("custom_data")
  private List<Object> mCustomData = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("expiration_date")
  private String mExpirationDate = null;
  @SerializedName("gender")
  private EnumProductItemGender mGender = null;
  @SerializedName("gtin")
  private String mGtin = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("material")
  private String mMaterial = null;
  @SerializedName("manufacturer_part_number")
  private String mManufacturerPartNumber = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ordering_index")
  private Long mOrderingIndex = null;
  @SerializedName("pattern")
  private String mPattern = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_type")
  private String mProductType = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("retailer_product_group_id")
  private String mRetailerProductGroupId = null;
  @SerializedName("review_rejection_reasons")
  private List<EnumReviewRejectionReasons> mReviewRejectionReasons = null;
  @SerializedName("review_status")
  private EnumReviewStatus mReviewStatus = null;
  @SerializedName("sale_price")
  private String mSalePrice = null;
  @SerializedName("sale_price_start_date")
  private String mSalePriceStartDate = null;
  @SerializedName("sale_price_end_date")
  private String mSalePriceEndDate = null;
  @SerializedName("shipping_weight_value")
  private Double mShippingWeightValue = null;
  @SerializedName("shipping_weight_unit")
  private EnumShippingWeightUnit mShippingWeightUnit = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("visibility")
  private EnumProductItemVisibility mVisibility = null;
  @SerializedName("product_feed")
  private ProductFeed mProductFeed = null;
  protected static Gson gson = null;

  ProductItem() {
  }

  public ProductItem(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductItem(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ProductItem fetch() throws APIException{
    ProductItem newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductItem fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductItem fetchById(String id, APIContext context) throws APIException {
    ProductItem productItem =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productItem;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductItem loadJSON(String json, APIContext context) {
    ProductItem productItem = getGson().fromJson(json, ProductItem.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productItem.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productItem.mContext = context;
    productItem.rawValue = json;
    return productItem;
  }

  public static APINodeList<ProductItem> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductItem> productItems = new APINodeList<ProductItem>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productItems;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productItems.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            productItems.add(loadJSON(obj.toString(), context));
          }
          return productItems;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItems.add(loadJSON(entry.getValue().toString(), context));
          }
          return productItems;
        } else {
          // Fifth, check if it's pure JsonObject
          productItems.add(loadJSON(json, context));
          return productItems;
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

  public APIRequestGetProductSets getProductSets() {
    return new APIRequestGetProductSets(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldAdditionalImageUrls() {
    return mAdditionalImageUrls;
  }

  public AppLinks getFieldApplinks() {
    if (mApplinks != null) {
      mApplinks.mContext = getContext();
    }
    return mApplinks;
  }

  public EnumAgeGroup getFieldAgeGroup() {
    return mAgeGroup;
  }

  public EnumProductItemAvailability getFieldAvailability() {
    return mAvailability;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public String getFieldColor() {
    return mColor;
  }

  public ProductItemCommerceInsights getFieldCommerceInsights() {
    return mCommerceInsights;
  }

  public EnumProductItemCondition getFieldCondition() {
    return mCondition;
  }

  public List<Object> getFieldCustomData() {
    return mCustomData;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldExpirationDate() {
    return mExpirationDate;
  }

  public EnumProductItemGender getFieldGender() {
    return mGender;
  }

  public String getFieldGtin() {
    return mGtin;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public String getFieldMaterial() {
    return mMaterial;
  }

  public String getFieldManufacturerPartNumber() {
    return mManufacturerPartNumber;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldOrderingIndex() {
    return mOrderingIndex;
  }

  public String getFieldPattern() {
    return mPattern;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public String getFieldProductType() {
    return mProductType;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public String getFieldRetailerProductGroupId() {
    return mRetailerProductGroupId;
  }

  public List<EnumReviewRejectionReasons> getFieldReviewRejectionReasons() {
    return mReviewRejectionReasons;
  }

  public EnumReviewStatus getFieldReviewStatus() {
    return mReviewStatus;
  }

  public String getFieldSalePrice() {
    return mSalePrice;
  }

  public String getFieldSalePriceStartDate() {
    return mSalePriceStartDate;
  }

  public String getFieldSalePriceEndDate() {
    return mSalePriceEndDate;
  }

  public Double getFieldShippingWeightValue() {
    return mShippingWeightValue;
  }

  public EnumShippingWeightUnit getFieldShippingWeightUnit() {
    return mShippingWeightUnit;
  }

  public String getFieldSize() {
    return mSize;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public EnumProductItemVisibility getFieldVisibility() {
    return mVisibility;
  }

  public ProductFeed getFieldProductFeed() {
    if (mProductFeed != null) {
      mProductFeed.mContext = getContext();
    }
    return mProductFeed;
  }



  public static class APIRequestGet extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
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
    public ProductItem parseResponse(String response) throws APIException {
      return ProductItem.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductItem execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductItem execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
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
    public APIRequestGet requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGet requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestAgeGroupField () {
      return this.requestAgeGroupField(true);
    }
    public APIRequestGet requestAgeGroupField (boolean value) {
      this.requestField("age_group", value);
      return this;
    }
    public APIRequestGet requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGet requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestColorField () {
      return this.requestColorField(true);
    }
    public APIRequestGet requestColorField (boolean value) {
      this.requestField("color", value);
      return this;
    }
    public APIRequestGet requestCommerceInsightsField () {
      return this.requestCommerceInsightsField(true);
    }
    public APIRequestGet requestCommerceInsightsField (boolean value) {
      this.requestField("commerce_insights", value);
      return this;
    }
    public APIRequestGet requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGet requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGet requestCustomDataField () {
      return this.requestCustomDataField(true);
    }
    public APIRequestGet requestCustomDataField (boolean value) {
      this.requestField("custom_data", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGet requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGet requestGtinField () {
      return this.requestGtinField(true);
    }
    public APIRequestGet requestGtinField (boolean value) {
      this.requestField("gtin", value);
      return this;
    }
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGet requestMaterialField (boolean value) {
      this.requestField("material", value);
      return this;
    }
    public APIRequestGet requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGet requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOrderingIndexField () {
      return this.requestOrderingIndexField(true);
    }
    public APIRequestGet requestOrderingIndexField (boolean value) {
      this.requestField("ordering_index", value);
      return this;
    }
    public APIRequestGet requestPatternField () {
      return this.requestPatternField(true);
    }
    public APIRequestGet requestPatternField (boolean value) {
      this.requestField("pattern", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGet requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGet requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGet requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGet requestRetailerProductGroupIdField () {
      return this.requestRetailerProductGroupIdField(true);
    }
    public APIRequestGet requestRetailerProductGroupIdField (boolean value) {
      this.requestField("retailer_product_group_id", value);
      return this;
    }
    public APIRequestGet requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGet requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGet requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGet requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGet requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGet requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGet requestSalePriceStartDateField () {
      return this.requestSalePriceStartDateField(true);
    }
    public APIRequestGet requestSalePriceStartDateField (boolean value) {
      this.requestField("sale_price_start_date", value);
      return this;
    }
    public APIRequestGet requestSalePriceEndDateField () {
      return this.requestSalePriceEndDateField(true);
    }
    public APIRequestGet requestSalePriceEndDateField (boolean value) {
      this.requestField("sale_price_end_date", value);
      return this;
    }
    public APIRequestGet requestShippingWeightValueField () {
      return this.requestShippingWeightValueField(true);
    }
    public APIRequestGet requestShippingWeightValueField (boolean value) {
      this.requestField("shipping_weight_value", value);
      return this;
    }
    public APIRequestGet requestShippingWeightUnitField () {
      return this.requestShippingWeightUnitField(true);
    }
    public APIRequestGet requestShippingWeightUnitField (boolean value) {
      this.requestField("shipping_weight_unit", value);
      return this;
    }
    public APIRequestGet requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGet requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGet requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGet requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "availability",
      "category",
      "currency",
      "condition",
      "description",
      "image_url",
      "name",
      "price",
      "product_type",
      "url",
      "visibility",
      "additional_image_urls",
      "brand",
      "checkout_url",
      "color",
      "custom_data",
      "expiration_date",
      "gender",
      "gtin",
      "manufacturer_part_number",
      "ordering_index",
      "pattern",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "size",
      "start_date",
      "ios_url",
      "ios_app_store_id",
      "ios_app_name",
      "iphone_url",
      "iphone_app_store_id",
      "iphone_app_name",
      "ipad_url",
      "ipad_app_store_id",
      "ipad_app_name",
      "android_url",
      "android_package",
      "android_class",
      "android_app_name",
      "windows_phone_url",
      "windows_phone_app_id",
      "windows_phone_app_name",
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
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


    public APIRequestUpdate setAvailability (EnumUpdateAvailability availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestUpdate setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestUpdate setCategory (String category) {
      this.setParam("category", category);
      return this;
    }


    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }


    public APIRequestUpdate setCondition (EnumUpdateCondition condition) {
      this.setParam("condition", condition);
      return this;
    }

    public APIRequestUpdate setCondition (String condition) {
      this.setParam("condition", condition);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }


    public APIRequestUpdate setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setPrice (Long price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setProductType (String productType) {
      this.setParam("product_type", productType);
      return this;
    }


    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }


    public APIRequestUpdate setVisibility (EnumUpdateVisibility visibility) {
      this.setParam("visibility", visibility);
      return this;
    }

    public APIRequestUpdate setVisibility (String visibility) {
      this.setParam("visibility", visibility);
      return this;
    }

    public APIRequestUpdate setAdditionalImageUrls (List<String> additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }

    public APIRequestUpdate setAdditionalImageUrls (String additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }

    public APIRequestUpdate setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }


    public APIRequestUpdate setCheckoutUrl (String checkoutUrl) {
      this.setParam("checkout_url", checkoutUrl);
      return this;
    }


    public APIRequestUpdate setColor (String color) {
      this.setParam("color", color);
      return this;
    }


    public APIRequestUpdate setCustomData (Map<String, String> customData) {
      this.setParam("custom_data", customData);
      return this;
    }

    public APIRequestUpdate setCustomData (String customData) {
      this.setParam("custom_data", customData);
      return this;
    }

    public APIRequestUpdate setExpirationDate (String expirationDate) {
      this.setParam("expiration_date", expirationDate);
      return this;
    }


    public APIRequestUpdate setGender (EnumUpdateGender gender) {
      this.setParam("gender", gender);
      return this;
    }

    public APIRequestUpdate setGender (String gender) {
      this.setParam("gender", gender);
      return this;
    }

    public APIRequestUpdate setGtin (String gtin) {
      this.setParam("gtin", gtin);
      return this;
    }


    public APIRequestUpdate setManufacturerPartNumber (String manufacturerPartNumber) {
      this.setParam("manufacturer_part_number", manufacturerPartNumber);
      return this;
    }


    public APIRequestUpdate setOrderingIndex (Long orderingIndex) {
      this.setParam("ordering_index", orderingIndex);
      return this;
    }

    public APIRequestUpdate setOrderingIndex (String orderingIndex) {
      this.setParam("ordering_index", orderingIndex);
      return this;
    }

    public APIRequestUpdate setPattern (String pattern) {
      this.setParam("pattern", pattern);
      return this;
    }


    public APIRequestUpdate setSalePrice (Long salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }

    public APIRequestUpdate setSalePrice (String salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }

    public APIRequestUpdate setSalePriceEndDate (String salePriceEndDate) {
      this.setParam("sale_price_end_date", salePriceEndDate);
      return this;
    }


    public APIRequestUpdate setSalePriceStartDate (String salePriceStartDate) {
      this.setParam("sale_price_start_date", salePriceStartDate);
      return this;
    }


    public APIRequestUpdate setSize (String size) {
      this.setParam("size", size);
      return this;
    }


    public APIRequestUpdate setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }


    public APIRequestUpdate setIosUrl (String iosUrl) {
      this.setParam("ios_url", iosUrl);
      return this;
    }


    public APIRequestUpdate setIosAppStoreId (Long iosAppStoreId) {
      this.setParam("ios_app_store_id", iosAppStoreId);
      return this;
    }

    public APIRequestUpdate setIosAppStoreId (String iosAppStoreId) {
      this.setParam("ios_app_store_id", iosAppStoreId);
      return this;
    }

    public APIRequestUpdate setIosAppName (String iosAppName) {
      this.setParam("ios_app_name", iosAppName);
      return this;
    }


    public APIRequestUpdate setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }


    public APIRequestUpdate setIphoneAppStoreId (Long iphoneAppStoreId) {
      this.setParam("iphone_app_store_id", iphoneAppStoreId);
      return this;
    }

    public APIRequestUpdate setIphoneAppStoreId (String iphoneAppStoreId) {
      this.setParam("iphone_app_store_id", iphoneAppStoreId);
      return this;
    }

    public APIRequestUpdate setIphoneAppName (String iphoneAppName) {
      this.setParam("iphone_app_name", iphoneAppName);
      return this;
    }


    public APIRequestUpdate setIpadUrl (String ipadUrl) {
      this.setParam("ipad_url", ipadUrl);
      return this;
    }


    public APIRequestUpdate setIpadAppStoreId (Long ipadAppStoreId) {
      this.setParam("ipad_app_store_id", ipadAppStoreId);
      return this;
    }

    public APIRequestUpdate setIpadAppStoreId (String ipadAppStoreId) {
      this.setParam("ipad_app_store_id", ipadAppStoreId);
      return this;
    }

    public APIRequestUpdate setIpadAppName (String ipadAppName) {
      this.setParam("ipad_app_name", ipadAppName);
      return this;
    }


    public APIRequestUpdate setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
      return this;
    }


    public APIRequestUpdate setAndroidPackage (String androidPackage) {
      this.setParam("android_package", androidPackage);
      return this;
    }


    public APIRequestUpdate setAndroidClass (String androidClass) {
      this.setParam("android_class", androidClass);
      return this;
    }


    public APIRequestUpdate setAndroidAppName (String androidAppName) {
      this.setParam("android_app_name", androidAppName);
      return this;
    }


    public APIRequestUpdate setWindowsPhoneUrl (String windowsPhoneUrl) {
      this.setParam("windows_phone_url", windowsPhoneUrl);
      return this;
    }


    public APIRequestUpdate setWindowsPhoneAppId (Long windowsPhoneAppId) {
      this.setParam("windows_phone_app_id", windowsPhoneAppId);
      return this;
    }

    public APIRequestUpdate setWindowsPhoneAppId (String windowsPhoneAppId) {
      this.setParam("windows_phone_app_id", windowsPhoneAppId);
      return this;
    }

    public APIRequestUpdate setWindowsPhoneAppName (String windowsPhoneAppName) {
      this.setParam("windows_phone_app_name", windowsPhoneAppName);
      return this;
    }


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
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

  public static class APIRequestGetProductSets extends APIRequest<ProductSet> {

    APINodeList<ProductSet> lastResponse = null;
    @Override
    public APINodeList<ProductSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "filter",
      "product_count",
    };

    @Override
    public APINodeList<ProductSet> parseResponse(String response) throws APIException {
      return ProductSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
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

  public static enum EnumUpdateAvailability {
    @SerializedName("IN_STOCK")
    VALUE_IN_STOCK("IN_STOCK"),
    @SerializedName("OUT_OF_STOCK")
    VALUE_OUT_OF_STOCK("OUT_OF_STOCK"),
    @SerializedName("PREORDER")
    VALUE_PREORDER("PREORDER"),
    @SerializedName("AVAILABLE_FOR_ORDER")
    VALUE_AVAILABLE_FOR_ORDER("AVAILABLE_FOR_ORDER"),
    @SerializedName("DISCONTINUED")
    VALUE_DISCONTINUED("DISCONTINUED"),
    NULL(null);

    private String value;

    private EnumUpdateAvailability(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateCondition {
    @SerializedName("PC_NEW")
    VALUE_PC_NEW("PC_NEW"),
    @SerializedName("PC_REFURBISHED")
    VALUE_PC_REFURBISHED("PC_REFURBISHED"),
    @SerializedName("PC_USED")
    VALUE_PC_USED("PC_USED"),
    NULL(null);

    private String value;

    private EnumUpdateCondition(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateVisibility {
    @SerializedName("LEGACY_PUBLIC")
    VALUE_LEGACY_PUBLIC("LEGACY_PUBLIC"),
    @SerializedName("STAGING")
    VALUE_STAGING("STAGING"),
    @SerializedName("PUBLISHED")
    VALUE_PUBLISHED("PUBLISHED"),
    NULL(null);

    private String value;

    private EnumUpdateVisibility(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumUpdateGender {
    @SerializedName("FEMALE")
    VALUE_FEMALE("FEMALE"),
    @SerializedName("MALE")
    VALUE_MALE("MALE"),
    @SerializedName("UNISEX")
    VALUE_UNISEX("UNISEX"),
    NULL(null);

    private String value;

    private EnumUpdateGender(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumAgeGroup {
    @SerializedName("kids")
    VALUE_KIDS("kids"),
    @SerializedName("adult")
    VALUE_ADULT("adult"),
    @SerializedName("infant")
    VALUE_INFANT("infant"),
    @SerializedName("toddler")
    VALUE_TODDLER("toddler"),
    @SerializedName("newborn")
    VALUE_NEWBORN("newborn"),
    @SerializedName("")
    VALUE_(""),
    NULL(null);

    private String value;

    private EnumAgeGroup(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductItemAvailability {
    @SerializedName("in stock")
    VALUE_IN_STOCK("in stock"),
    @SerializedName("out of stock")
    VALUE_OUT_OF_STOCK("out of stock"),
    @SerializedName("preorder")
    VALUE_PREORDER("preorder"),
    @SerializedName("available for order")
    VALUE_AVAILABLE_FOR_ORDER("available for order"),
    @SerializedName("discontinued")
    VALUE_DISCONTINUED("discontinued"),
    NULL(null);

    private String value;

    private EnumProductItemAvailability(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductItemCondition {
    @SerializedName("new")
    VALUE_NEW("new"),
    @SerializedName("refurbished")
    VALUE_REFURBISHED("refurbished"),
    @SerializedName("used")
    VALUE_USED("used"),
    @SerializedName("")
    VALUE_(""),
    NULL(null);

    private String value;

    private EnumProductItemCondition(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductItemGender {
    @SerializedName("female")
    VALUE_FEMALE("female"),
    @SerializedName("male")
    VALUE_MALE("male"),
    @SerializedName("unisex")
    VALUE_UNISEX("unisex"),
    @SerializedName("")
    VALUE_(""),
    NULL(null);

    private String value;

    private EnumProductItemGender(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumReviewRejectionReasons {
    @SerializedName("UNKNOWN")
    VALUE_UNKNOWN("UNKNOWN"),
    @SerializedName("IRREGULAR_APP_INSTALL")
    VALUE_IRREGULAR_APP_INSTALL("IRREGULAR_APP_INSTALL"),
    @SerializedName("TEXT_OVERLAY")
    VALUE_TEXT_OVERLAY("TEXT_OVERLAY"),
    @SerializedName("ADULT_CONTENT")
    VALUE_ADULT_CONTENT("ADULT_CONTENT"),
    @SerializedName("ADULT_HEALTH")
    VALUE_ADULT_HEALTH("ADULT_HEALTH"),
    @SerializedName("ALCOHOL")
    VALUE_ALCOHOL("ALCOHOL"),
    @SerializedName("ANIMATED_IMAGE")
    VALUE_ANIMATED_IMAGE("ANIMATED_IMAGE"),
    @SerializedName("BEFORE_AND_AFTER")
    VALUE_BEFORE_AND_AFTER("BEFORE_AND_AFTER"),
    @SerializedName("CASUAL_DATING")
    VALUE_CASUAL_DATING("CASUAL_DATING"),
    @SerializedName("DATING")
    VALUE_DATING("DATING"),
    @SerializedName("FACEBOOK_REFERENCE")
    VALUE_FACEBOOK_REFERENCE("FACEBOOK_REFERENCE"),
    @SerializedName("FINANCIAL")
    VALUE_FINANCIAL("FINANCIAL"),
    @SerializedName("GAMBLING")
    VALUE_GAMBLING("GAMBLING"),
    @SerializedName("IDEALIZED_BODY")
    VALUE_IDEALIZED_BODY("IDEALIZED_BODY"),
    @SerializedName("LANGUAGE")
    VALUE_LANGUAGE("LANGUAGE"),
    @SerializedName("LANDING_PAGE_FAIL")
    VALUE_LANDING_PAGE_FAIL("LANDING_PAGE_FAIL"),
    @SerializedName("SEXUAL")
    VALUE_SEXUAL("SEXUAL"),
    @SerializedName("TEST")
    VALUE_TEST("TEST"),
    @SerializedName("TOBACCO_SALE")
    VALUE_TOBACCO_SALE("TOBACCO_SALE"),
    @SerializedName("TRAPPING")
    VALUE_TRAPPING("TRAPPING"),
    @SerializedName("UNSUBSTANTIATED_CLAIM")
    VALUE_UNSUBSTANTIATED_CLAIM("UNSUBSTANTIATED_CLAIM"),
    @SerializedName("OTHER")
    VALUE_OTHER("OTHER"),
    @SerializedName("WEAPON_SALE")
    VALUE_WEAPON_SALE("WEAPON_SALE"),
    @SerializedName("WORK_FROM_HOME")
    VALUE_WORK_FROM_HOME("WORK_FROM_HOME"),
    @SerializedName("CASH_ADVANCE")
    VALUE_CASH_ADVANCE("CASH_ADVANCE"),
    @SerializedName("SHOCK_AND_SCARE")
    VALUE_SHOCK_AND_SCARE("SHOCK_AND_SCARE"),
    @SerializedName("SPY_CAMERA")
    VALUE_SPY_CAMERA("SPY_CAMERA"),
    @SerializedName("BAD_HEALTH_PRODUCT")
    VALUE_BAD_HEALTH_PRODUCT("BAD_HEALTH_PRODUCT"),
    @SerializedName("GRAMMAR")
    VALUE_GRAMMAR("GRAMMAR"),
    @SerializedName("ILLEGAL")
    VALUE_ILLEGAL("ILLEGAL"),
    @SerializedName("MISUSE_OF_LIKE")
    VALUE_MISUSE_OF_LIKE("MISUSE_OF_LIKE"),
    @SerializedName("NON_EXISTENT_FUNCTIONALITY")
    VALUE_NON_EXISTENT_FUNCTIONALITY("NON_EXISTENT_FUNCTIONALITY"),
    @SerializedName("ONLINE_PHARMACY")
    VALUE_ONLINE_PHARMACY("ONLINE_PHARMACY"),
    @SerializedName("PENNY_AUCTION")
    VALUE_PENNY_AUCTION("PENNY_AUCTION"),
    @SerializedName("PORN")
    VALUE_PORN("PORN"),
    @SerializedName("COPYRIGHT")
    VALUE_COPYRIGHT("COPYRIGHT"),
    @SerializedName("TRADEMARK")
    VALUE_TRADEMARK("TRADEMARK"),
    @SerializedName("COUNTERFEIT")
    VALUE_COUNTERFEIT("COUNTERFEIT"),
    @SerializedName("SYSTEM_ISSUE")
    VALUE_SYSTEM_ISSUE("SYSTEM_ISSUE"),
    @SerializedName("Q_BLURRY_PIXELATED")
    VALUE_Q_BLURRY_PIXELATED("Q_BLURRY_PIXELATED"),
    @SerializedName("Q_BORDERLINE_SEXUAL")
    VALUE_Q_BORDERLINE_SEXUAL("Q_BORDERLINE_SEXUAL"),
    @SerializedName("Q_BORDER_BACKGROUND")
    VALUE_Q_BORDER_BACKGROUND("Q_BORDER_BACKGROUND"),
    @SerializedName("Q_GRAMMAR_CAPITALIZATION")
    VALUE_Q_GRAMMAR_CAPITALIZATION("Q_GRAMMAR_CAPITALIZATION"),
    @SerializedName("Q_IRRELEVANT_IMAGE_COPY")
    VALUE_Q_IRRELEVANT_IMAGE_COPY("Q_IRRELEVANT_IMAGE_COPY"),
    @SerializedName("Q_MISLEADING")
    VALUE_Q_MISLEADING("Q_MISLEADING"),
    @SerializedName("Q_MULTIPLE_IMAGES")
    VALUE_Q_MULTIPLE_IMAGES("Q_MULTIPLE_IMAGES"),
    @SerializedName("Q_HOT_BUTTON")
    VALUE_Q_HOT_BUTTON("Q_HOT_BUTTON"),
    @SerializedName("Q_ZOOM_IN_BODY_PARTS")
    VALUE_Q_ZOOM_IN_BODY_PARTS("Q_ZOOM_IN_BODY_PARTS"),
    @SerializedName("Q_ZOOM_IN_FOOD")
    VALUE_Q_ZOOM_IN_FOOD("Q_ZOOM_IN_FOOD"),
    @SerializedName("QUALITY_LOW")
    VALUE_QUALITY_LOW("QUALITY_LOW"),
    @SerializedName("LEAD_AD_FROM_AGGREGATOR")
    VALUE_LEAD_AD_FROM_AGGREGATOR("LEAD_AD_FROM_AGGREGATOR"),
    @SerializedName("UNSUITABLE_QUESTION")
    VALUE_UNSUITABLE_QUESTION("UNSUITABLE_QUESTION"),
    @SerializedName("FACEBOOK_WORD_MANIPULATED")
    VALUE_FACEBOOK_WORD_MANIPULATED("FACEBOOK_WORD_MANIPULATED"),
    @SerializedName("FACEBOOK_ICONS")
    VALUE_FACEBOOK_ICONS("FACEBOOK_ICONS"),
    @SerializedName("FACEBOOK_PAGE_LOOKALIKE")
    VALUE_FACEBOOK_PAGE_LOOKALIKE("FACEBOOK_PAGE_LOOKALIKE"),
    @SerializedName("FACEBOOK_LOGO_FOCUS")
    VALUE_FACEBOOK_LOGO_FOCUS("FACEBOOK_LOGO_FOCUS"),
    @SerializedName("FACEBOOK_LOGO_OVERLAP")
    VALUE_FACEBOOK_LOGO_OVERLAP("FACEBOOK_LOGO_OVERLAP"),
    @SerializedName("FACEBOOK_LOGO")
    VALUE_FACEBOOK_LOGO("FACEBOOK_LOGO"),
    @SerializedName("FACEBOOK_LOGO_THUMBS_UP")
    VALUE_FACEBOOK_LOGO_THUMBS_UP("FACEBOOK_LOGO_THUMBS_UP"),
    @SerializedName("FACEBOOK_SCREENSHOT_PROD")
    VALUE_FACEBOOK_SCREENSHOT_PROD("FACEBOOK_SCREENSHOT_PROD"),
    @SerializedName("FACEBOOK_WORDMARK")
    VALUE_FACEBOOK_WORDMARK("FACEBOOK_WORDMARK"),
    @SerializedName("FACEBOOK_ZUCKPIC")
    VALUE_FACEBOOK_ZUCKPIC("FACEBOOK_ZUCKPIC"),
    @SerializedName("HIGHLIGHTED_PAIN_POINTS")
    VALUE_HIGHLIGHTED_PAIN_POINTS("HIGHLIGHTED_PAIN_POINTS"),
    @SerializedName("PERFECT_BODY")
    VALUE_PERFECT_BODY("PERFECT_BODY"),
    @SerializedName("SCALES")
    VALUE_SCALES("SCALES"),
    @SerializedName("TAPE_MEASURE")
    VALUE_TAPE_MEASURE("TAPE_MEASURE"),
    @SerializedName("UNDESIRABLE_BODY")
    VALUE_UNDESIRABLE_BODY("UNDESIRABLE_BODY"),
    @SerializedName("ZOOM_BODY_PART")
    VALUE_ZOOM_BODY_PART("ZOOM_BODY_PART"),
    @SerializedName("HARRASSMENT")
    VALUE_HARRASSMENT("HARRASSMENT"),
    @SerializedName("USER_ATTRIBUTES_CALLOUT")
    VALUE_USER_ATTRIBUTES_CALLOUT("USER_ATTRIBUTES_CALLOUT"),
    @SerializedName("USER_FINANICAL_CALLOUT")
    VALUE_USER_FINANICAL_CALLOUT("USER_FINANICAL_CALLOUT"),
    @SerializedName("USER_HEALTH_ATTRIBUTES")
    VALUE_USER_HEALTH_ATTRIBUTES("USER_HEALTH_ATTRIBUTES"),
    @SerializedName("USER_WEIGHT_ATTRIBUTES")
    VALUE_USER_WEIGHT_ATTRIBUTES("USER_WEIGHT_ATTRIBUTES"),
    @SerializedName("PROFANITY")
    VALUE_PROFANITY("PROFANITY"),
    @SerializedName("FAKE_FORM_ELEMENTS")
    VALUE_FAKE_FORM_ELEMENTS("FAKE_FORM_ELEMENTS"),
    @SerializedName("FAKE_NOTIFICATIONS")
    VALUE_FAKE_NOTIFICATIONS("FAKE_NOTIFICATIONS"),
    @SerializedName("MOUSE_CURSOR")
    VALUE_MOUSE_CURSOR("MOUSE_CURSOR"),
    @SerializedName("PLAY_BUTTON")
    VALUE_PLAY_BUTTON("PLAY_BUTTON"),
    @SerializedName("QR_CODES")
    VALUE_QR_CODES("QR_CODES"),
    @SerializedName("EXCESSIVE_SKIN")
    VALUE_EXCESSIVE_SKIN("EXCESSIVE_SKIN"),
    @SerializedName("INDIRECT_NUDITY")
    VALUE_INDIRECT_NUDITY("INDIRECT_NUDITY"),
    @SerializedName("INDIRECT_SEXUAL_ACT")
    VALUE_INDIRECT_SEXUAL_ACT("INDIRECT_SEXUAL_ACT"),
    @SerializedName("SEXUAL_OTHER")
    VALUE_SEXUAL_OTHER("SEXUAL_OTHER"),
    @SerializedName("ZOOM_SEXUAL_IMAGE")
    VALUE_ZOOM_SEXUAL_IMAGE("ZOOM_SEXUAL_IMAGE"),
    NULL(null);

    private String value;

    private EnumReviewRejectionReasons(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumReviewStatus {
    @SerializedName("NO_REVIEW")
    VALUE_NO_REVIEW("NO_REVIEW"),
    @SerializedName("PENDING")
    VALUE_PENDING("PENDING"),
    @SerializedName("REJECTED")
    VALUE_REJECTED("REJECTED"),
    @SerializedName("APPROVED")
    VALUE_APPROVED("APPROVED"),
    NULL(null);

    private String value;

    private EnumReviewStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumShippingWeightUnit {
    @SerializedName("lb")
    VALUE_LB("lb"),
    @SerializedName("oz")
    VALUE_OZ("oz"),
    @SerializedName("g")
    VALUE_G("g"),
    @SerializedName("kg")
    VALUE_KG("kg"),
    @SerializedName("")
    VALUE_(""),
    NULL(null);

    private String value;

    private EnumShippingWeightUnit(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
  public static enum EnumProductItemVisibility {
    @SerializedName("LEGACY_PUBLIC")
    VALUE_LEGACY_PUBLIC("LEGACY_PUBLIC"),
    @SerializedName("STAGING")
    VALUE_STAGING("STAGING"),
    @SerializedName("PUBLISHED")
    VALUE_PUBLISHED("PUBLISHED"),
    NULL(null);

    private String value;

    private EnumProductItemVisibility(String value) {
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

  public ProductItem copyFrom(ProductItem instance) {
    this.mId = instance.mId;
    this.mAdditionalImageUrls = instance.mAdditionalImageUrls;
    this.mApplinks = instance.mApplinks;
    this.mAgeGroup = instance.mAgeGroup;
    this.mAvailability = instance.mAvailability;
    this.mBrand = instance.mBrand;
    this.mCategory = instance.mCategory;
    this.mColor = instance.mColor;
    this.mCommerceInsights = instance.mCommerceInsights;
    this.mCondition = instance.mCondition;
    this.mCustomData = instance.mCustomData;
    this.mDescription = instance.mDescription;
    this.mExpirationDate = instance.mExpirationDate;
    this.mGender = instance.mGender;
    this.mGtin = instance.mGtin;
    this.mImageUrl = instance.mImageUrl;
    this.mMaterial = instance.mMaterial;
    this.mManufacturerPartNumber = instance.mManufacturerPartNumber;
    this.mName = instance.mName;
    this.mOrderingIndex = instance.mOrderingIndex;
    this.mPattern = instance.mPattern;
    this.mPrice = instance.mPrice;
    this.mProductType = instance.mProductType;
    this.mRetailerId = instance.mRetailerId;
    this.mRetailerProductGroupId = instance.mRetailerProductGroupId;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mReviewStatus = instance.mReviewStatus;
    this.mSalePrice = instance.mSalePrice;
    this.mSalePriceStartDate = instance.mSalePriceStartDate;
    this.mSalePriceEndDate = instance.mSalePriceEndDate;
    this.mShippingWeightValue = instance.mShippingWeightValue;
    this.mShippingWeightUnit = instance.mShippingWeightUnit;
    this.mSize = instance.mSize;
    this.mStartDate = instance.mStartDate;
    this.mUrl = instance.mUrl;
    this.mVisibility = instance.mVisibility;
    this.mProductFeed = instance.mProductFeed;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}