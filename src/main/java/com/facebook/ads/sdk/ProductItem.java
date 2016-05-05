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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class ProductItem extends APINode {
  @SerializedName("additional_image_urls")
  private List<String> mAdditionalImageUrls = null;
  @SerializedName("age_group")
  private EnumAgeGroup mAgeGroup = null;
  @SerializedName("applinks")
  private AppLinks mApplinks = null;
  @SerializedName("availability")
  private EnumAvailability mAvailability = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("color")
  private String mColor = null;
  @SerializedName("commerce_insights")
  private ProductItemCommerceInsights mCommerceInsights = null;
  @SerializedName("condition")
  private EnumCondition mCondition = null;
  @SerializedName("custom_data")
  private List<Object> mCustomData = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("custom_label_1")
  private String mCustomLabel1 = null;
  @SerializedName("custom_label_2")
  private String mCustomLabel2 = null;
  @SerializedName("custom_label_3")
  private String mCustomLabel3 = null;
  @SerializedName("custom_label_4")
  private String mCustomLabel4 = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("expiration_date")
  private String mExpirationDate = null;
  @SerializedName("gender")
  private EnumGender mGender = null;
  @SerializedName("gtin")
  private String mGtin = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("manufacturer_part_number")
  private String mManufacturerPartNumber = null;
  @SerializedName("material")
  private String mMaterial = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ordering_index")
  private Long mOrderingIndex = null;
  @SerializedName("pattern")
  private String mPattern = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_feed")
  private ProductFeed mProductFeed = null;
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
  @SerializedName("sale_price_end_date")
  private String mSalePriceEndDate = null;
  @SerializedName("sale_price_start_date")
  private String mSalePriceStartDate = null;
  @SerializedName("shipping_weight_unit")
  private EnumShippingWeightUnit mShippingWeightUnit = null;
  @SerializedName("shipping_weight_value")
  private Double mShippingWeightValue = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  protected static Gson gson = null;

  ProductItem() {
  }

  public ProductItem(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductItem(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public ProductItem fetch() throws APIException{
    ProductItem newInstance = fetchById(this.getPrefixedId().toString(), this.context);
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

  public static APINodeList<ProductItem> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductItem>)(
      new APIRequest<ProductItem>(context, "", "/", "GET", ProductItem.getParser())
        .setParam("ids", String.join(",", ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productItem.context = context;
    productItem.rawValue = json;
    return productItem;
  }

  public static APINodeList<ProductItem> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductItem> productItems = new APINodeList<ProductItem>(request, json);
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
          productItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productItems;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            productItems.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  productItems.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItems.add(loadJSON(obj.toString(), context));
            }
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
              productItems.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productItems;
          }

          // Sixth, check if it's pure JsonObject
          productItems.clear();
          productItems.add(loadJSON(json, context));
          return productItems;
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

  public APIRequestGetProductSets getProductSets() {
    return new APIRequestGetProductSets(this.getPrefixedId().toString(), context);
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


  public List<String> getFieldAdditionalImageUrls() {
    return mAdditionalImageUrls;
  }

  public EnumAgeGroup getFieldAgeGroup() {
    return mAgeGroup;
  }

  public AppLinks getFieldApplinks() {
    if (mApplinks != null) {
      mApplinks.context = getContext();
    }
    return mApplinks;
  }

  public EnumAvailability getFieldAvailability() {
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

  public EnumCondition getFieldCondition() {
    return mCondition;
  }

  public List<Object> getFieldCustomData() {
    return mCustomData;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldExpirationDate() {
    return mExpirationDate;
  }

  public EnumGender getFieldGender() {
    return mGender;
  }

  public String getFieldGtin() {
    return mGtin;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public String getFieldManufacturerPartNumber() {
    return mManufacturerPartNumber;
  }

  public String getFieldMaterial() {
    return mMaterial;
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

  public ProductFeed getFieldProductFeed() {
    if (mProductFeed != null) {
      mProductFeed.context = getContext();
    }
    return mProductFeed;
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

  public String getFieldSalePriceEndDate() {
    return mSalePriceEndDate;
  }

  public String getFieldSalePriceStartDate() {
    return mSalePriceStartDate;
  }

  public EnumShippingWeightUnit getFieldShippingWeightUnit() {
    return mShippingWeightUnit;
  }

  public Double getFieldShippingWeightValue() {
    return mShippingWeightValue;
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

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
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
      "filter",
      "id",
      "name",
      "product_catalog",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetProductSets(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetProductSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductSets requestFilterField () {
      return this.requestFilterField(true);
    }
    public APIRequestGetProductSets requestFilterField (boolean value) {
      this.requestField("filter", value);
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
    public APIRequestGetProductSets requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetProductSets requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

  public static class APIRequestGet extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_image_urls",
      "age_group",
      "applinks",
      "availability",
      "brand",
      "category",
      "color",
      "commerce_insights",
      "condition",
      "custom_data",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "description",
      "expiration_date",
      "gender",
      "gtin",
      "id",
      "image_url",
      "manufacturer_part_number",
      "material",
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_feed",
      "product_type",
      "retailer_id",
      "retailer_product_group_id",
      "review_rejection_reasons",
      "review_status",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "shipping_weight_unit",
      "shipping_weight_value",
      "size",
      "start_date",
      "url",
      "visibility",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

    public APIRequestGet requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGet requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGet requestAgeGroupField () {
      return this.requestAgeGroupField(true);
    }
    public APIRequestGet requestAgeGroupField (boolean value) {
      this.requestField("age_group", value);
      return this;
    }
    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
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
    public APIRequestGet requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGet requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGet requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGet requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGet requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGet requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGet requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGet requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGet requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGet requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
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
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGet requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
      return this;
    }
    public APIRequestGet requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGet requestMaterialField (boolean value) {
      this.requestField("material", value);
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
    public APIRequestGet requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGet requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
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
    public APIRequestGet requestSalePriceEndDateField () {
      return this.requestSalePriceEndDateField(true);
    }
    public APIRequestGet requestSalePriceEndDateField (boolean value) {
      this.requestField("sale_price_end_date", value);
      return this;
    }
    public APIRequestGet requestSalePriceStartDateField () {
      return this.requestSalePriceStartDateField(true);
    }
    public APIRequestGet requestSalePriceStartDateField (boolean value) {
      this.requestField("sale_price_start_date", value);
      return this;
    }
    public APIRequestGet requestShippingWeightUnitField () {
      return this.requestShippingWeightUnitField(true);
    }
    public APIRequestGet requestShippingWeightUnitField (boolean value) {
      this.requestField("shipping_weight_unit", value);
      return this;
    }
    public APIRequestGet requestShippingWeightValueField () {
      return this.requestShippingWeightValueField(true);
    }
    public APIRequestGet requestShippingWeightValueField (boolean value) {
      this.requestField("shipping_weight_value", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "additional_image_urls",
      "android_app_name",
      "android_class",
      "android_package",
      "android_url",
      "availability",
      "brand",
      "category",
      "checkout_url",
      "color",
      "condition",
      "currency",
      "custom_data",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "description",
      "expiration_date",
      "gender",
      "gtin",
      "id",
      "image_url",
      "inventory",
      "ios_app_name",
      "ios_app_store_id",
      "ios_url",
      "ipad_app_name",
      "ipad_app_store_id",
      "ipad_url",
      "iphone_app_name",
      "iphone_app_store_id",
      "iphone_url",
      "manufacturer_part_number",
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_type",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "size",
      "start_date",
      "url",
      "visibility",
      "windows_phone_app_id",
      "windows_phone_app_name",
      "windows_phone_url",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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


    public APIRequestUpdate setAdditionalImageUrls (List<String> additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }
    public APIRequestUpdate setAdditionalImageUrls (String additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }

    public APIRequestUpdate setAndroidAppName (String androidAppName) {
      this.setParam("android_app_name", androidAppName);
      return this;
    }

    public APIRequestUpdate setAndroidClass (String androidClass) {
      this.setParam("android_class", androidClass);
      return this;
    }

    public APIRequestUpdate setAndroidPackage (String androidPackage) {
      this.setParam("android_package", androidPackage);
      return this;
    }

    public APIRequestUpdate setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
      return this;
    }

    public APIRequestUpdate setAvailability (ProductItem.EnumAvailability availability) {
      this.setParam("availability", availability);
      return this;
    }
    public APIRequestUpdate setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestUpdate setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestUpdate setCategory (String category) {
      this.setParam("category", category);
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

    public APIRequestUpdate setCondition (ProductItem.EnumCondition condition) {
      this.setParam("condition", condition);
      return this;
    }
    public APIRequestUpdate setCondition (String condition) {
      this.setParam("condition", condition);
      return this;
    }

    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
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

    public APIRequestUpdate setCustomLabel0 (String customLabel0) {
      this.setParam("custom_label_0", customLabel0);
      return this;
    }

    public APIRequestUpdate setCustomLabel1 (String customLabel1) {
      this.setParam("custom_label_1", customLabel1);
      return this;
    }

    public APIRequestUpdate setCustomLabel2 (String customLabel2) {
      this.setParam("custom_label_2", customLabel2);
      return this;
    }

    public APIRequestUpdate setCustomLabel3 (String customLabel3) {
      this.setParam("custom_label_3", customLabel3);
      return this;
    }

    public APIRequestUpdate setCustomLabel4 (String customLabel4) {
      this.setParam("custom_label_4", customLabel4);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setExpirationDate (String expirationDate) {
      this.setParam("expiration_date", expirationDate);
      return this;
    }

    public APIRequestUpdate setGender (ProductItem.EnumGender gender) {
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

    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }

    public APIRequestUpdate setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestUpdate setInventory (Long inventory) {
      this.setParam("inventory", inventory);
      return this;
    }
    public APIRequestUpdate setInventory (String inventory) {
      this.setParam("inventory", inventory);
      return this;
    }

    public APIRequestUpdate setIosAppName (String iosAppName) {
      this.setParam("ios_app_name", iosAppName);
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

    public APIRequestUpdate setIosUrl (String iosUrl) {
      this.setParam("ios_url", iosUrl);
      return this;
    }

    public APIRequestUpdate setIpadAppName (String ipadAppName) {
      this.setParam("ipad_app_name", ipadAppName);
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

    public APIRequestUpdate setIpadUrl (String ipadUrl) {
      this.setParam("ipad_url", ipadUrl);
      return this;
    }

    public APIRequestUpdate setIphoneAppName (String iphoneAppName) {
      this.setParam("iphone_app_name", iphoneAppName);
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

    public APIRequestUpdate setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }

    public APIRequestUpdate setManufacturerPartNumber (String manufacturerPartNumber) {
      this.setParam("manufacturer_part_number", manufacturerPartNumber);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestUpdate setVisibility (ProductItem.EnumVisibility visibility) {
      this.setParam("visibility", visibility);
      return this;
    }
    public APIRequestUpdate setVisibility (String visibility) {
      this.setParam("visibility", visibility);
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

    public APIRequestUpdate setWindowsPhoneUrl (String windowsPhoneUrl) {
      this.setParam("windows_phone_url", windowsPhoneUrl);
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

  public static enum EnumAvailability {
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

      private EnumAvailability(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCondition {
      @SerializedName("new")
      VALUE_NEW("new"),
      @SerializedName("refurbished")
      VALUE_REFURBISHED("refurbished"),
      @SerializedName("used")
      VALUE_USED("used"),
      NULL(null);

      private String value;

      private EnumCondition(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGender {
      @SerializedName("female")
      VALUE_FEMALE("female"),
      @SerializedName("male")
      VALUE_MALE("male"),
      @SerializedName("unisex")
      VALUE_UNISEX("unisex"),
      NULL(null);

      private String value;

      private EnumGender(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumReviewStatus {
      @SerializedName("pending")
      VALUE_PENDING("pending"),
      @SerializedName("rejected")
      VALUE_REJECTED("rejected"),
      @SerializedName("approved")
      VALUE_APPROVED("approved"),
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

  public static enum EnumVisibility {
      @SerializedName("staging")
      VALUE_STAGING("staging"),
      @SerializedName("published")
      VALUE_PUBLISHED("published"),
      NULL(null);

      private String value;

      private EnumVisibility(String value) {
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
      @SerializedName("FRAUD_ASSOCIATED")
      VALUE_FRAUD_ASSOCIATED("FRAUD_ASSOCIATED"),
      @SerializedName("MYSTERY_IMAGE")
      VALUE_MYSTERY_IMAGE("MYSTERY_IMAGE"),
      @SerializedName("APP_SCAM")
      VALUE_APP_SCAM("APP_SCAM"),
      @SerializedName("TEXT_PENALTY_HIGH")
      VALUE_TEXT_PENALTY_HIGH("TEXT_PENALTY_HIGH"),
      @SerializedName("TEXT_PENALTY_MEDIUM")
      VALUE_TEXT_PENALTY_MEDIUM("TEXT_PENALTY_MEDIUM"),
      @SerializedName("TEXT_PENALTY_LOW")
      VALUE_TEXT_PENALTY_LOW("TEXT_PENALTY_LOW"),
      @SerializedName("BAD_SUBSCRIPTION")
      VALUE_BAD_SUBSCRIPTION("BAD_SUBSCRIPTION"),
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
      @SerializedName("BREASTENLARGEMENT")
      VALUE_BREASTENLARGEMENT("BREASTENLARGEMENT"),
      @SerializedName("GENITALSURGERY")
      VALUE_GENITALSURGERY("GENITALSURGERY"),
      @SerializedName("LIBIDO")
      VALUE_LIBIDO("LIBIDO"),
      @SerializedName("NUDITY_NOTPORN")
      VALUE_NUDITY_NOTPORN("NUDITY_NOTPORN"),
      @SerializedName("PHEROMONE")
      VALUE_PHEROMONE("PHEROMONE"),
      @SerializedName("SCHEME_HOTGIRLPAGE")
      VALUE_SCHEME_HOTGIRLPAGE("SCHEME_HOTGIRLPAGE"),
      @SerializedName("SERVICES_SEDUCTION")
      VALUE_SERVICES_SEDUCTION("SERVICES_SEDUCTION"),
      @SerializedName("SEXPUBLICATIONS")
      VALUE_SEXPUBLICATIONS("SEXPUBLICATIONS"),
      @SerializedName("SEXTOYS")
      VALUE_SEXTOYS("SEXTOYS"),
      @SerializedName("SEXUALPLEASURE")
      VALUE_SEXUALPLEASURE("SEXUALPLEASURE"),
      @SerializedName("STRIPCLUBS")
      VALUE_STRIPCLUBS("STRIPCLUBS"),
      @SerializedName("MENTION_BOTOX")
      VALUE_MENTION_BOTOX("MENTION_BOTOX"),
      @SerializedName("MENTION_DIETPRODUCT")
      VALUE_MENTION_DIETPRODUCT("MENTION_DIETPRODUCT"),
      @SerializedName("MENTION_LASERS")
      VALUE_MENTION_LASERS("MENTION_LASERS"),
      @SerializedName("MENTION_SEXUALHEALTH")
      VALUE_MENTION_SEXUALHEALTH("MENTION_SEXUALHEALTH"),
      @SerializedName("MENTION_SUPPLEMENT")
      VALUE_MENTION_SUPPLEMENT("MENTION_SUPPLEMENT"),
      @SerializedName("MENTION_SURGERY")
      VALUE_MENTION_SURGERY("MENTION_SURGERY"),
      @SerializedName("MENTION_BRAND_ALCOHOL")
      VALUE_MENTION_BRAND_ALCOHOL("MENTION_BRAND_ALCOHOL"),
      @SerializedName("MENTION_CONSUMPTION_ALCOHOL")
      VALUE_MENTION_CONSUMPTION_ALCOHOL("MENTION_CONSUMPTION_ALCOHOL"),
      @SerializedName("MENTION_SALES_ALCOHOL")
      VALUE_MENTION_SALES_ALCOHOL("MENTION_SALES_ALCOHOL"),
      @SerializedName("SPONSORSHIP")
      VALUE_SPONSORSHIP("SPONSORSHIP"),
      @SerializedName("MENTION_SALES_BADHEALTHPRODUCT")
      VALUE_MENTION_SALES_BADHEALTHPRODUCT("MENTION_SALES_BADHEALTHPRODUCT"),
      @SerializedName("UNCLEAR_CANCELLATION_SUBSCRIPTION")
      VALUE_UNCLEAR_CANCELLATION_SUBSCRIPTION("UNCLEAR_CANCELLATION_SUBSCRIPTION"),
      @SerializedName("UNCLEAR_PRICING_SUBSCRIPTION")
      VALUE_UNCLEAR_PRICING_SUBSCRIPTION("UNCLEAR_PRICING_SUBSCRIPTION"),
      @SerializedName("BA_HAIRLOSS")
      VALUE_BA_HAIRLOSS("BA_HAIRLOSS"),
      @SerializedName("BA_MEDICAL")
      VALUE_BA_MEDICAL("BA_MEDICAL"),
      @SerializedName("BA_SKIN")
      VALUE_BA_SKIN("BA_SKIN"),
      @SerializedName("BA_TEETH")
      VALUE_BA_TEETH("BA_TEETH"),
      @SerializedName("BA_WEIGHTLOSS")
      VALUE_BA_WEIGHTLOSS("BA_WEIGHTLOSS"),
      @SerializedName("GIBBERISH")
      VALUE_GIBBERISH("GIBBERISH"),
      @SerializedName("RANDOMCHARACTERS")
      VALUE_RANDOMCHARACTERS("RANDOMCHARACTERS"),
      @SerializedName("DRUGS_ILLEGAL")
      VALUE_DRUGS_ILLEGAL("DRUGS_ILLEGAL"),
      @SerializedName("HUMAN_TRAFFICKING")
      VALUE_HUMAN_TRAFFICKING("HUMAN_TRAFFICKING"),
      @SerializedName("SERVICES_ESCORT")
      VALUE_SERVICES_ESCORT("SERVICES_ESCORT"),
      @SerializedName("IMAGE_ANIMALCRUELTY")
      VALUE_IMAGE_ANIMALCRUELTY("IMAGE_ANIMALCRUELTY"),
      @SerializedName("IMAGE_MEDICAL")
      VALUE_IMAGE_MEDICAL("IMAGE_MEDICAL"),
      @SerializedName("IMAGE_OFFENSIVEGESTURE")
      VALUE_IMAGE_OFFENSIVEGESTURE("IMAGE_OFFENSIVEGESTURE"),
      @SerializedName("IMAGE_VEHICLECOLLISION")
      VALUE_IMAGE_VEHICLECOLLISION("IMAGE_VEHICLECOLLISION"),
      @SerializedName("IMAGE_WEAPONATUSER")
      VALUE_IMAGE_WEAPONATUSER("IMAGE_WEAPONATUSER"),
      @SerializedName("MENTION_IMAGE_VIOLENCE_GORE")
      VALUE_MENTION_IMAGE_VIOLENCE_GORE("MENTION_IMAGE_VIOLENCE_GORE"),
      @SerializedName("MENTION_ACCESSORY_CONSUMPTION_TOBACCO")
      VALUE_MENTION_ACCESSORY_CONSUMPTION_TOBACCO("MENTION_ACCESSORY_CONSUMPTION_TOBACCO"),
      @SerializedName("MENTION_BRAND_TOBACCO")
      VALUE_MENTION_BRAND_TOBACCO("MENTION_BRAND_TOBACCO"),
      @SerializedName("FALSENOTIFICATION")
      VALUE_FALSENOTIFICATION("FALSENOTIFICATION"),
      @SerializedName("IMPOSSIBLECURES")
      VALUE_IMPOSSIBLECURES("IMPOSSIBLECURES"),
      @SerializedName("MENTION_NUMERIC_CLAIM")
      VALUE_MENTION_NUMERIC_CLAIM("MENTION_NUMERIC_CLAIM"),
      @SerializedName("MENTION_TRICKSTIPS")
      VALUE_MENTION_TRICKSTIPS("MENTION_TRICKSTIPS"),
      @SerializedName("SPECIFICINDIVIDUALCLAIM")
      VALUE_SPECIFICINDIVIDUALCLAIM("SPECIFICINDIVIDUALCLAIM"),
      @SerializedName("UNREALISTIC_EBOOKPROMISE")
      VALUE_UNREALISTIC_EBOOKPROMISE("UNREALISTIC_EBOOKPROMISE"),
      @SerializedName("VIDEOSEXUAL")
      VALUE_VIDEOSEXUAL("VIDEOSEXUAL"),
      @SerializedName("VIDEOSCHOCKANDSCARE")
      VALUE_VIDEOSCHOCKANDSCARE("VIDEOSCHOCKANDSCARE"),
      @SerializedName("VIDEOLANGUAGE")
      VALUE_VIDEOLANGUAGE("VIDEOLANGUAGE"),
      @SerializedName("NOT_DATING_PARTNER")
      VALUE_NOT_DATING_PARTNER("NOT_DATING_PARTNER"),
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
    this.mAdditionalImageUrls = instance.mAdditionalImageUrls;
    this.mAgeGroup = instance.mAgeGroup;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBrand = instance.mBrand;
    this.mCategory = instance.mCategory;
    this.mColor = instance.mColor;
    this.mCommerceInsights = instance.mCommerceInsights;
    this.mCondition = instance.mCondition;
    this.mCustomData = instance.mCustomData;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mCustomLabel1 = instance.mCustomLabel1;
    this.mCustomLabel2 = instance.mCustomLabel2;
    this.mCustomLabel3 = instance.mCustomLabel3;
    this.mCustomLabel4 = instance.mCustomLabel4;
    this.mDescription = instance.mDescription;
    this.mExpirationDate = instance.mExpirationDate;
    this.mGender = instance.mGender;
    this.mGtin = instance.mGtin;
    this.mId = instance.mId;
    this.mImageUrl = instance.mImageUrl;
    this.mManufacturerPartNumber = instance.mManufacturerPartNumber;
    this.mMaterial = instance.mMaterial;
    this.mName = instance.mName;
    this.mOrderingIndex = instance.mOrderingIndex;
    this.mPattern = instance.mPattern;
    this.mPrice = instance.mPrice;
    this.mProductFeed = instance.mProductFeed;
    this.mProductType = instance.mProductType;
    this.mRetailerId = instance.mRetailerId;
    this.mRetailerProductGroupId = instance.mRetailerProductGroupId;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mReviewStatus = instance.mReviewStatus;
    this.mSalePrice = instance.mSalePrice;
    this.mSalePriceEndDate = instance.mSalePriceEndDate;
    this.mSalePriceStartDate = instance.mSalePriceStartDate;
    this.mShippingWeightUnit = instance.mShippingWeightUnit;
    this.mShippingWeightValue = instance.mShippingWeightValue;
    this.mSize = instance.mSize;
    this.mStartDate = instance.mStartDate;
    this.mUrl = instance.mUrl;
    this.mVisibility = instance.mVisibility;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItem> getParser() {
    return new APIRequest.ResponseParser<ProductItem>() {
      public APINodeList<ProductItem> parseResponse(String response, APIContext context, APIRequest<ProductItem> request) throws MalformedResponseException {
        return ProductItem.parseResponse(response, context, request);
      }
    };
  }
}
