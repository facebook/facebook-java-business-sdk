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
public class ProductItem extends APINode {
  @SerializedName("additional_image_cdn_urls")
  private List<List<Map<String, String>>> mAdditionalImageCdnUrls = null;
  @SerializedName("additional_image_urls")
  private List<String> mAdditionalImageUrls = null;
  @SerializedName("additional_variant_attributes")
  private List<Map<String, String>> mAdditionalVariantAttributes = null;
  @SerializedName("age_group")
  private EnumAgeGroup mAgeGroup = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("availability")
  private EnumAvailability mAvailability = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("capability_to_review_status")
  private List<Map<Object, Object>> mCapabilityToReviewStatus = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("color")
  private String mColor = null;
  @SerializedName("commerce_insights")
  private ProductItemCommerceInsights mCommerceInsights = null;
  @SerializedName("condition")
  private EnumCondition mCondition = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_data")
  private List<Map<String, String>> mCustomData = null;
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
  @SerializedName("custom_number_0")
  private String mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private String mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private String mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private String mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private String mCustomNumber4 = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("errors")
  private List<ProductItemError> mErrors = null;
  @SerializedName("expiration_date")
  private String mExpirationDate = null;
  @SerializedName("fb_product_category")
  private String mFbProductCategory = null;
  @SerializedName("gender")
  private EnumGender mGender = null;
  @SerializedName("gtin")
  private String mGtin = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_cdn_urls")
  private List<Map<String, String>> mImageCdnUrls = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("importer_address")
  private ProductItemImporterAddress mImporterAddress = null;
  @SerializedName("importer_name")
  private String mImporterName = null;
  @SerializedName("invalidation_errors")
  private List<ProductItemInvalidationError> mInvalidationErrors = null;
  @SerializedName("inventory")
  private Long mInventory = null;
  @SerializedName("manufacturer_info")
  private String mManufacturerInfo = null;
  @SerializedName("manufacturer_part_number")
  private String mManufacturerPartNumber = null;
  @SerializedName("marked_for_product_launch")
  private String mMarkedForProductLaunch = null;
  @SerializedName("material")
  private String mMaterial = null;
  @SerializedName("mobile_link")
  private String mMobileLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("ordering_index")
  private Long mOrderingIndex = null;
  @SerializedName("origin_country")
  private String mOriginCountry = null;
  @SerializedName("parent_product_id")
  private String mParentProductId = null;
  @SerializedName("pattern")
  private String mPattern = null;
  @SerializedName("post_conversion_signal_based_enforcement_appeal_eligibility")
  private Boolean mPostConversionSignalBasedEnforcementAppealEligibility = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("product_catalog")
  private ProductCatalog mProductCatalog = null;
  @SerializedName("product_feed")
  private ProductFeed mProductFeed = null;
  @SerializedName("product_group")
  private ProductGroup mProductGroup = null;
  @SerializedName("product_local_info")
  private ProductItemLocalInfo mProductLocalInfo = null;
  @SerializedName("product_type")
  private String mProductType = null;
  @SerializedName("quantity_to_sell_on_facebook")
  private Long mQuantityToSellOnFacebook = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("retailer_product_group_id")
  private String mRetailerProductGroupId = null;
  @SerializedName("review_rejection_reasons")
  private List<String> mReviewRejectionReasons = null;
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
  @SerializedName("short_description")
  private String mShortDescription = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("video_fetch_status")
  private EnumVideoFetchStatus mVideoFetchStatus = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("wa_compliance_category")
  private String mWaComplianceCategory = null;
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

  public static ListenableFuture<ProductItem> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductItem fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductItem> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductItem> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductItem>)(
      new APIRequest<ProductItem>(context, "", "/", "GET", ProductItem.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductItem>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductItem.getParser())
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
  public static ProductItem loadJSON(String json, APIContext context, String header) {
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
      }
    }
    productItem.context = context;
    productItem.rawValue = json;
    productItem.header = header;
    return productItem;
  }

  public static APINodeList<ProductItem> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductItem> productItems = new APINodeList<ProductItem>(request, json, header);
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
          productItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productItems;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productItems.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productItems.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productItems.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItems.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productItems.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItems.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productItems;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItems.add(loadJSON(entry.getValue().toString(), context, header));
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
              productItems.add(loadJSON(value.toString(), context, header));
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
          productItems.add(loadJSON(json, context, header));
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

  public APIRequestGetChannelsToIntegrityStatus getChannelsToIntegrityStatus() {
    return new APIRequestGetChannelsToIntegrityStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductSets getProductSets() {
    return new APIRequestGetProductSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideosMetadata getVideosMetadata() {
    return new APIRequestGetVideosMetadata(this.getPrefixedId().toString(), context);
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


  public List<List<Map<String, String>>> getFieldAdditionalImageCdnUrls() {
    return mAdditionalImageCdnUrls;
  }

  public List<String> getFieldAdditionalImageUrls() {
    return mAdditionalImageUrls;
  }

  public List<Map<String, String>> getFieldAdditionalVariantAttributes() {
    return mAdditionalVariantAttributes;
  }

  public EnumAgeGroup getFieldAgeGroup() {
    return mAgeGroup;
  }

  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public EnumAvailability getFieldAvailability() {
    return mAvailability;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public List<Map<Object, Object>> getFieldCapabilityToReviewStatus() {
    return mCapabilityToReviewStatus;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
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

  public String getFieldCurrency() {
    return mCurrency;
  }

  public List<Map<String, String>> getFieldCustomData() {
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

  public String getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public String getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public String getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public String getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public String getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public List<ProductItemError> getFieldErrors() {
    return mErrors;
  }

  public String getFieldExpirationDate() {
    return mExpirationDate;
  }

  public String getFieldFbProductCategory() {
    return mFbProductCategory;
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

  public List<Map<String, String>> getFieldImageCdnUrls() {
    return mImageCdnUrls;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public ProductItemImporterAddress getFieldImporterAddress() {
    return mImporterAddress;
  }

  public String getFieldImporterName() {
    return mImporterName;
  }

  public List<ProductItemInvalidationError> getFieldInvalidationErrors() {
    return mInvalidationErrors;
  }

  public Long getFieldInventory() {
    return mInventory;
  }

  public String getFieldManufacturerInfo() {
    return mManufacturerInfo;
  }

  public String getFieldManufacturerPartNumber() {
    return mManufacturerPartNumber;
  }

  public String getFieldMarkedForProductLaunch() {
    return mMarkedForProductLaunch;
  }

  public String getFieldMaterial() {
    return mMaterial;
  }

  public String getFieldMobileLink() {
    return mMobileLink;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldOrderingIndex() {
    return mOrderingIndex;
  }

  public String getFieldOriginCountry() {
    return mOriginCountry;
  }

  public String getFieldParentProductId() {
    return mParentProductId;
  }

  public String getFieldPattern() {
    return mPattern;
  }

  public Boolean getFieldPostConversionSignalBasedEnforcementAppealEligibility() {
    return mPostConversionSignalBasedEnforcementAppealEligibility;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public ProductCatalog getFieldProductCatalog() {
    if (mProductCatalog != null) {
      mProductCatalog.context = getContext();
    }
    return mProductCatalog;
  }

  public ProductFeed getFieldProductFeed() {
    if (mProductFeed != null) {
      mProductFeed.context = getContext();
    }
    return mProductFeed;
  }

  public ProductGroup getFieldProductGroup() {
    if (mProductGroup != null) {
      mProductGroup.context = getContext();
    }
    return mProductGroup;
  }

  public ProductItemLocalInfo getFieldProductLocalInfo() {
    if (mProductLocalInfo != null) {
      mProductLocalInfo.context = getContext();
    }
    return mProductLocalInfo;
  }

  public String getFieldProductType() {
    return mProductType;
  }

  public Long getFieldQuantityToSellOnFacebook() {
    return mQuantityToSellOnFacebook;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public String getFieldRetailerProductGroupId() {
    return mRetailerProductGroupId;
  }

  public List<String> getFieldReviewRejectionReasons() {
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

  public String getFieldShortDescription() {
    return mShortDescription;
  }

  public String getFieldSize() {
    return mSize;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public EnumVideoFetchStatus getFieldVideoFetchStatus() {
    return mVideoFetchStatus;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }

  public String getFieldWaComplianceCategory() {
    return mWaComplianceCategory;
  }



  public static class APIRequestGetChannelsToIntegrityStatus extends APIRequest<CatalogItemChannelsToIntegrityStatus> {

    APINodeList<CatalogItemChannelsToIntegrityStatus> lastResponse = null;
    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "channels",
      "rejection_information",
    };

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> parseResponse(String response, String header) throws APIException {
      return CatalogItemChannelsToIntegrityStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogItemChannelsToIntegrityStatus>>() {
           public APINodeList<CatalogItemChannelsToIntegrityStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGetChannelsToIntegrityStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetChannelsToIntegrityStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/channels_to_integrity_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChannelsToIntegrityStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChannelsToIntegrityStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChannelsToIntegrityStatus requestChannelsField () {
      return this.requestChannelsField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestChannelsField (boolean value) {
      this.requestField("channels", value);
      return this;
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField () {
      return this.requestRejectionInformationField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField (boolean value) {
      this.requestField("rejection_information", value);
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
    public APINodeList<ProductSet> parseResponse(String response, String header) throws APIException {
      return ProductSet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductSet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductSet>>() {
           public APINodeList<ProductSet> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductSets.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

    public APIRequestGetProductSets requestAutoCreationUrlField () {
      return this.requestAutoCreationUrlField(true);
    }
    public APIRequestGetProductSets requestAutoCreationUrlField (boolean value) {
      this.requestField("auto_creation_url", value);
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
    public APIRequestGetProductSets requestLatestMetadataField () {
      return this.requestLatestMetadataField(true);
    }
    public APIRequestGetProductSets requestLatestMetadataField (boolean value) {
      this.requestField("latest_metadata", value);
      return this;
    }
    public APIRequestGetProductSets requestLiveMetadataField () {
      return this.requestLiveMetadataField(true);
    }
    public APIRequestGetProductSets requestLiveMetadataField (boolean value) {
      this.requestField("live_metadata", value);
      return this;
    }
    public APIRequestGetProductSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductSets requestOrderingInfoField () {
      return this.requestOrderingInfoField(true);
    }
    public APIRequestGetProductSets requestOrderingInfoField (boolean value) {
      this.requestField("ordering_info", value);
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
    public APIRequestGetProductSets requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetProductSets requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
  }

  public static class APIRequestGetVideosMetadata extends APIRequest<DynamicVideoMetadata> {

    APINodeList<DynamicVideoMetadata> lastResponse = null;
    @Override
    public APINodeList<DynamicVideoMetadata> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "tags",
      "url",
      "video",
    };

    @Override
    public APINodeList<DynamicVideoMetadata> parseResponse(String response, String header) throws APIException {
      return DynamicVideoMetadata.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicVideoMetadata>>() {
           public APINodeList<DynamicVideoMetadata> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideosMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVideosMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/videos_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideosMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideosMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideosMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideosMetadata requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideosMetadata requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetVideosMetadata requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVideosMetadata requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetVideosMetadata requestVideoField (boolean value) {
      this.requestField("video", value);
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

  public static class APIRequestGet extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
      "image_height",
      "image_width",
      "override_country",
      "override_language",
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
    public ProductItem parseResponse(String response, String header) throws APIException {
      return ProductItem.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductItem execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductItem execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductItem> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductItem> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductItem>() {
           public ProductItem apply(ResponseWrapper result) {
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


    public APIRequestGet setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestGet setImageHeight (Long imageHeight) {
      this.setParam("image_height", imageHeight);
      return this;
    }
    public APIRequestGet setImageHeight (String imageHeight) {
      this.setParam("image_height", imageHeight);
      return this;
    }

    public APIRequestGet setImageWidth (Long imageWidth) {
      this.setParam("image_width", imageWidth);
      return this;
    }
    public APIRequestGet setImageWidth (String imageWidth) {
      this.setParam("image_width", imageWidth);
      return this;
    }

    public APIRequestGet setOverrideCountry (String overrideCountry) {
      this.setParam("override_country", overrideCountry);
      return this;
    }

    public APIRequestGet setOverrideLanguage (String overrideLanguage) {
      this.setParam("override_language", overrideLanguage);
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

    public APIRequestGet requestAdditionalImageCdnUrlsField () {
      return this.requestAdditionalImageCdnUrlsField(true);
    }
    public APIRequestGet requestAdditionalImageCdnUrlsField (boolean value) {
      this.requestField("additional_image_cdn_urls", value);
      return this;
    }
    public APIRequestGet requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGet requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGet requestAdditionalVariantAttributesField () {
      return this.requestAdditionalVariantAttributesField(true);
    }
    public APIRequestGet requestAdditionalVariantAttributesField (boolean value) {
      this.requestField("additional_variant_attributes", value);
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
    public APIRequestGet requestCapabilityToReviewStatusField () {
      return this.requestCapabilityToReviewStatusField(true);
    }
    public APIRequestGet requestCapabilityToReviewStatusField (boolean value) {
      this.requestField("capability_to_review_status", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
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
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
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
    public APIRequestGet requestCustomNumber0Field () {
      return this.requestCustomNumber0Field(true);
    }
    public APIRequestGet requestCustomNumber0Field (boolean value) {
      this.requestField("custom_number_0", value);
      return this;
    }
    public APIRequestGet requestCustomNumber1Field () {
      return this.requestCustomNumber1Field(true);
    }
    public APIRequestGet requestCustomNumber1Field (boolean value) {
      this.requestField("custom_number_1", value);
      return this;
    }
    public APIRequestGet requestCustomNumber2Field () {
      return this.requestCustomNumber2Field(true);
    }
    public APIRequestGet requestCustomNumber2Field (boolean value) {
      this.requestField("custom_number_2", value);
      return this;
    }
    public APIRequestGet requestCustomNumber3Field () {
      return this.requestCustomNumber3Field(true);
    }
    public APIRequestGet requestCustomNumber3Field (boolean value) {
      this.requestField("custom_number_3", value);
      return this;
    }
    public APIRequestGet requestCustomNumber4Field () {
      return this.requestCustomNumber4Field(true);
    }
    public APIRequestGet requestCustomNumber4Field (boolean value) {
      this.requestField("custom_number_4", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGet requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGet requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGet requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
      return this;
    }
    public APIRequestGet requestFbProductCategoryField () {
      return this.requestFbProductCategoryField(true);
    }
    public APIRequestGet requestFbProductCategoryField (boolean value) {
      this.requestField("fb_product_category", value);
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
    public APIRequestGet requestImageCdnUrlsField () {
      return this.requestImageCdnUrlsField(true);
    }
    public APIRequestGet requestImageCdnUrlsField (boolean value) {
      this.requestField("image_cdn_urls", value);
      return this;
    }
    public APIRequestGet requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGet requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestImporterAddressField () {
      return this.requestImporterAddressField(true);
    }
    public APIRequestGet requestImporterAddressField (boolean value) {
      this.requestField("importer_address", value);
      return this;
    }
    public APIRequestGet requestImporterNameField () {
      return this.requestImporterNameField(true);
    }
    public APIRequestGet requestImporterNameField (boolean value) {
      this.requestField("importer_name", value);
      return this;
    }
    public APIRequestGet requestInvalidationErrorsField () {
      return this.requestInvalidationErrorsField(true);
    }
    public APIRequestGet requestInvalidationErrorsField (boolean value) {
      this.requestField("invalidation_errors", value);
      return this;
    }
    public APIRequestGet requestInventoryField () {
      return this.requestInventoryField(true);
    }
    public APIRequestGet requestInventoryField (boolean value) {
      this.requestField("inventory", value);
      return this;
    }
    public APIRequestGet requestManufacturerInfoField () {
      return this.requestManufacturerInfoField(true);
    }
    public APIRequestGet requestManufacturerInfoField (boolean value) {
      this.requestField("manufacturer_info", value);
      return this;
    }
    public APIRequestGet requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGet requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
      return this;
    }
    public APIRequestGet requestMarkedForProductLaunchField () {
      return this.requestMarkedForProductLaunchField(true);
    }
    public APIRequestGet requestMarkedForProductLaunchField (boolean value) {
      this.requestField("marked_for_product_launch", value);
      return this;
    }
    public APIRequestGet requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGet requestMaterialField (boolean value) {
      this.requestField("material", value);
      return this;
    }
    public APIRequestGet requestMobileLinkField () {
      return this.requestMobileLinkField(true);
    }
    public APIRequestGet requestMobileLinkField (boolean value) {
      this.requestField("mobile_link", value);
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
    public APIRequestGet requestOriginCountryField () {
      return this.requestOriginCountryField(true);
    }
    public APIRequestGet requestOriginCountryField (boolean value) {
      this.requestField("origin_country", value);
      return this;
    }
    public APIRequestGet requestParentProductIdField () {
      return this.requestParentProductIdField(true);
    }
    public APIRequestGet requestParentProductIdField (boolean value) {
      this.requestField("parent_product_id", value);
      return this;
    }
    public APIRequestGet requestPatternField () {
      return this.requestPatternField(true);
    }
    public APIRequestGet requestPatternField (boolean value) {
      this.requestField("pattern", value);
      return this;
    }
    public APIRequestGet requestPostConversionSignalBasedEnforcementAppealEligibilityField () {
      return this.requestPostConversionSignalBasedEnforcementAppealEligibilityField(true);
    }
    public APIRequestGet requestPostConversionSignalBasedEnforcementAppealEligibilityField (boolean value) {
      this.requestField("post_conversion_signal_based_enforcement_appeal_eligibility", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGet requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGet requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGet requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
      return this;
    }
    public APIRequestGet requestProductGroupField () {
      return this.requestProductGroupField(true);
    }
    public APIRequestGet requestProductGroupField (boolean value) {
      this.requestField("product_group", value);
      return this;
    }
    public APIRequestGet requestProductLocalInfoField () {
      return this.requestProductLocalInfoField(true);
    }
    public APIRequestGet requestProductLocalInfoField (boolean value) {
      this.requestField("product_local_info", value);
      return this;
    }
    public APIRequestGet requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGet requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGet requestQuantityToSellOnFacebookField () {
      return this.requestQuantityToSellOnFacebookField(true);
    }
    public APIRequestGet requestQuantityToSellOnFacebookField (boolean value) {
      this.requestField("quantity_to_sell_on_facebook", value);
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
    public APIRequestGet requestShortDescriptionField () {
      return this.requestShortDescriptionField(true);
    }
    public APIRequestGet requestShortDescriptionField (boolean value) {
      this.requestField("short_description", value);
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
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVideoFetchStatusField () {
      return this.requestVideoFetchStatusField(true);
    }
    public APIRequestGet requestVideoFetchStatusField (boolean value) {
      this.requestField("video_fetch_status", value);
      return this;
    }
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGet requestWaComplianceCategoryField () {
      return this.requestWaComplianceCategoryField(true);
    }
    public APIRequestGet requestWaComplianceCategoryField (boolean value) {
      this.requestField("wa_compliance_category", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "additional_image_urls",
      "additional_uploaded_image_ids",
      "additional_variant_attributes",
      "android_app_name",
      "android_class",
      "android_package",
      "android_url",
      "availability",
      "brand",
      "category",
      "category_specific_fields",
      "checkout_url",
      "color",
      "commerce_tax_category",
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
      "expiration_date",
      "fb_product_category",
      "gender",
      "gtin",
      "image_url",
      "importer_address",
      "importer_name",
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
      "launch_date",
      "manufacturer_info",
      "manufacturer_part_number",
      "marked_for_product_launch",
      "material",
      "mobile_link",
      "name",
      "ordering_index",
      "origin_country",
      "pattern",
      "price",
      "product_type",
      "quantity_to_sell_on_facebook",
      "retailer_id",
      "return_policy_days",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "short_description",
      "size",
      "start_date",
      "url",
      "visibility",
      "wa_compliance_category",
      "windows_phone_app_id",
      "windows_phone_app_name",
      "windows_phone_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductItem parseResponse(String response, String header) throws APIException {
      return ProductItem.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductItem execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductItem execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductItem> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductItem> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductItem>() {
           public ProductItem apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAdditionalImageUrls (List<String> additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }
    public APIRequestUpdate setAdditionalImageUrls (String additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }

    public APIRequestUpdate setAdditionalUploadedImageIds (List<String> additionalUploadedImageIds) {
      this.setParam("additional_uploaded_image_ids", additionalUploadedImageIds);
      return this;
    }
    public APIRequestUpdate setAdditionalUploadedImageIds (String additionalUploadedImageIds) {
      this.setParam("additional_uploaded_image_ids", additionalUploadedImageIds);
      return this;
    }

    public APIRequestUpdate setAdditionalVariantAttributes (Map<String, String> additionalVariantAttributes) {
      this.setParam("additional_variant_attributes", additionalVariantAttributes);
      return this;
    }
    public APIRequestUpdate setAdditionalVariantAttributes (String additionalVariantAttributes) {
      this.setParam("additional_variant_attributes", additionalVariantAttributes);
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

    public APIRequestUpdate setCategorySpecificFields (Map<String, String> categorySpecificFields) {
      this.setParam("category_specific_fields", categorySpecificFields);
      return this;
    }
    public APIRequestUpdate setCategorySpecificFields (String categorySpecificFields) {
      this.setParam("category_specific_fields", categorySpecificFields);
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

    public APIRequestUpdate setCommerceTaxCategory (ProductItem.EnumCommerceTaxCategory commerceTaxCategory) {
      this.setParam("commerce_tax_category", commerceTaxCategory);
      return this;
    }
    public APIRequestUpdate setCommerceTaxCategory (String commerceTaxCategory) {
      this.setParam("commerce_tax_category", commerceTaxCategory);
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

    public APIRequestUpdate setCustomNumber0 (Long customNumber0) {
      this.setParam("custom_number_0", customNumber0);
      return this;
    }
    public APIRequestUpdate setCustomNumber0 (String customNumber0) {
      this.setParam("custom_number_0", customNumber0);
      return this;
    }

    public APIRequestUpdate setCustomNumber1 (Long customNumber1) {
      this.setParam("custom_number_1", customNumber1);
      return this;
    }
    public APIRequestUpdate setCustomNumber1 (String customNumber1) {
      this.setParam("custom_number_1", customNumber1);
      return this;
    }

    public APIRequestUpdate setCustomNumber2 (Long customNumber2) {
      this.setParam("custom_number_2", customNumber2);
      return this;
    }
    public APIRequestUpdate setCustomNumber2 (String customNumber2) {
      this.setParam("custom_number_2", customNumber2);
      return this;
    }

    public APIRequestUpdate setCustomNumber3 (Long customNumber3) {
      this.setParam("custom_number_3", customNumber3);
      return this;
    }
    public APIRequestUpdate setCustomNumber3 (String customNumber3) {
      this.setParam("custom_number_3", customNumber3);
      return this;
    }

    public APIRequestUpdate setCustomNumber4 (Long customNumber4) {
      this.setParam("custom_number_4", customNumber4);
      return this;
    }
    public APIRequestUpdate setCustomNumber4 (String customNumber4) {
      this.setParam("custom_number_4", customNumber4);
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

    public APIRequestUpdate setFbProductCategory (String fbProductCategory) {
      this.setParam("fb_product_category", fbProductCategory);
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

    public APIRequestUpdate setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestUpdate setImporterAddress (Map<String, String> importerAddress) {
      this.setParam("importer_address", importerAddress);
      return this;
    }
    public APIRequestUpdate setImporterAddress (String importerAddress) {
      this.setParam("importer_address", importerAddress);
      return this;
    }

    public APIRequestUpdate setImporterName (String importerName) {
      this.setParam("importer_name", importerName);
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

    public APIRequestUpdate setLaunchDate (String launchDate) {
      this.setParam("launch_date", launchDate);
      return this;
    }

    public APIRequestUpdate setManufacturerInfo (String manufacturerInfo) {
      this.setParam("manufacturer_info", manufacturerInfo);
      return this;
    }

    public APIRequestUpdate setManufacturerPartNumber (String manufacturerPartNumber) {
      this.setParam("manufacturer_part_number", manufacturerPartNumber);
      return this;
    }

    public APIRequestUpdate setMarkedForProductLaunch (ProductItem.EnumMarkedForProductLaunch markedForProductLaunch) {
      this.setParam("marked_for_product_launch", markedForProductLaunch);
      return this;
    }
    public APIRequestUpdate setMarkedForProductLaunch (String markedForProductLaunch) {
      this.setParam("marked_for_product_launch", markedForProductLaunch);
      return this;
    }

    public APIRequestUpdate setMaterial (String material) {
      this.setParam("material", material);
      return this;
    }

    public APIRequestUpdate setMobileLink (String mobileLink) {
      this.setParam("mobile_link", mobileLink);
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

    public APIRequestUpdate setOriginCountry (ProductItem.EnumOriginCountry originCountry) {
      this.setParam("origin_country", originCountry);
      return this;
    }
    public APIRequestUpdate setOriginCountry (String originCountry) {
      this.setParam("origin_country", originCountry);
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

    public APIRequestUpdate setQuantityToSellOnFacebook (Long quantityToSellOnFacebook) {
      this.setParam("quantity_to_sell_on_facebook", quantityToSellOnFacebook);
      return this;
    }
    public APIRequestUpdate setQuantityToSellOnFacebook (String quantityToSellOnFacebook) {
      this.setParam("quantity_to_sell_on_facebook", quantityToSellOnFacebook);
      return this;
    }

    public APIRequestUpdate setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
      return this;
    }

    public APIRequestUpdate setReturnPolicyDays (Long returnPolicyDays) {
      this.setParam("return_policy_days", returnPolicyDays);
      return this;
    }
    public APIRequestUpdate setReturnPolicyDays (String returnPolicyDays) {
      this.setParam("return_policy_days", returnPolicyDays);
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

    public APIRequestUpdate setShortDescription (String shortDescription) {
      this.setParam("short_description", shortDescription);
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

    public APIRequestUpdate setWaComplianceCategory (ProductItem.EnumWaComplianceCategory waComplianceCategory) {
      this.setParam("wa_compliance_category", waComplianceCategory);
      return this;
    }
    public APIRequestUpdate setWaComplianceCategory (String waComplianceCategory) {
      this.setParam("wa_compliance_category", waComplianceCategory);
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
      @SerializedName("adult")
      VALUE_ADULT("adult"),
      @SerializedName("all ages")
      VALUE_ALL_AGES("all ages"),
      @SerializedName("infant")
      VALUE_INFANT("infant"),
      @SerializedName("kids")
      VALUE_KIDS("kids"),
      @SerializedName("newborn")
      VALUE_NEWBORN("newborn"),
      @SerializedName("teen")
      VALUE_TEEN("teen"),
      @SerializedName("toddler")
      VALUE_TODDLER("toddler"),
      ;

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
      @SerializedName("available for order")
      VALUE_AVAILABLE_FOR_ORDER("available for order"),
      @SerializedName("discontinued")
      VALUE_DISCONTINUED("discontinued"),
      @SerializedName("in stock")
      VALUE_IN_STOCK("in stock"),
      @SerializedName("mark_as_sold")
      VALUE_MARK_AS_SOLD("mark_as_sold"),
      @SerializedName("out of stock")
      VALUE_OUT_OF_STOCK("out of stock"),
      @SerializedName("pending")
      VALUE_PENDING("pending"),
      @SerializedName("preorder")
      VALUE_PREORDER("preorder"),
      ;

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
      @SerializedName("cpo")
      VALUE_CPO("cpo"),
      @SerializedName("new")
      VALUE_NEW("new"),
      @SerializedName("open_box_new")
      VALUE_OPEN_BOX_NEW("open_box_new"),
      @SerializedName("refurbished")
      VALUE_REFURBISHED("refurbished"),
      @SerializedName("used")
      VALUE_USED("used"),
      @SerializedName("used_fair")
      VALUE_USED_FAIR("used_fair"),
      @SerializedName("used_good")
      VALUE_USED_GOOD("used_good"),
      @SerializedName("used_like_new")
      VALUE_USED_LIKE_NEW("used_like_new"),
      ;

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
      ;

      private String value;

      private EnumGender(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumImageFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumImageFetchStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumReviewStatus {
      @SerializedName("approved")
      VALUE_APPROVED("approved"),
      @SerializedName("outdated")
      VALUE_OUTDATED("outdated"),
      @SerializedName("pending")
      VALUE_PENDING("pending"),
      @SerializedName("rejected")
      VALUE_REJECTED("rejected"),
      ;

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
      @SerializedName("g")
      VALUE_G("g"),
      @SerializedName("kg")
      VALUE_KG("kg"),
      @SerializedName("lb")
      VALUE_LB("lb"),
      @SerializedName("oz")
      VALUE_OZ("oz"),
      ;

      private String value;

      private EnumShippingWeightUnit(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVideoFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumVideoFetchStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVisibility {
      @SerializedName("published")
      VALUE_PUBLISHED("published"),
      @SerializedName("staging")
      VALUE_STAGING("staging"),
      ;

      private String value;

      private EnumVisibility(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCommerceTaxCategory {
      @SerializedName("FB_ANIMAL")
      VALUE_FB_ANIMAL("FB_ANIMAL"),
      @SerializedName("FB_ANIMAL_SUPP")
      VALUE_FB_ANIMAL_SUPP("FB_ANIMAL_SUPP"),
      @SerializedName("FB_APRL")
      VALUE_FB_APRL("FB_APRL"),
      @SerializedName("FB_APRL_ACCESSORIES")
      VALUE_FB_APRL_ACCESSORIES("FB_APRL_ACCESSORIES"),
      @SerializedName("FB_APRL_ATHL_UNIF")
      VALUE_FB_APRL_ATHL_UNIF("FB_APRL_ATHL_UNIF"),
      @SerializedName("FB_APRL_CASES")
      VALUE_FB_APRL_CASES("FB_APRL_CASES"),
      @SerializedName("FB_APRL_CLOTHING")
      VALUE_FB_APRL_CLOTHING("FB_APRL_CLOTHING"),
      @SerializedName("FB_APRL_COSTUME")
      VALUE_FB_APRL_COSTUME("FB_APRL_COSTUME"),
      @SerializedName("FB_APRL_CSTM")
      VALUE_FB_APRL_CSTM("FB_APRL_CSTM"),
      @SerializedName("FB_APRL_FORMAL")
      VALUE_FB_APRL_FORMAL("FB_APRL_FORMAL"),
      @SerializedName("FB_APRL_HANDBAG")
      VALUE_FB_APRL_HANDBAG("FB_APRL_HANDBAG"),
      @SerializedName("FB_APRL_JEWELRY")
      VALUE_FB_APRL_JEWELRY("FB_APRL_JEWELRY"),
      @SerializedName("FB_APRL_SHOE")
      VALUE_FB_APRL_SHOE("FB_APRL_SHOE"),
      @SerializedName("FB_APRL_SHOE_ACC")
      VALUE_FB_APRL_SHOE_ACC("FB_APRL_SHOE_ACC"),
      @SerializedName("FB_APRL_SWIM")
      VALUE_FB_APRL_SWIM("FB_APRL_SWIM"),
      @SerializedName("FB_APRL_SWIM_CHIL")
      VALUE_FB_APRL_SWIM_CHIL("FB_APRL_SWIM_CHIL"),
      @SerializedName("FB_APRL_SWIM_CVR")
      VALUE_FB_APRL_SWIM_CVR("FB_APRL_SWIM_CVR"),
      @SerializedName("FB_ARTS")
      VALUE_FB_ARTS("FB_ARTS"),
      @SerializedName("FB_ARTS_HOBBY")
      VALUE_FB_ARTS_HOBBY("FB_ARTS_HOBBY"),
      @SerializedName("FB_ARTS_PARTY")
      VALUE_FB_ARTS_PARTY("FB_ARTS_PARTY"),
      @SerializedName("FB_ARTS_PARTY_GIFT_CARD")
      VALUE_FB_ARTS_PARTY_GIFT_CARD("FB_ARTS_PARTY_GIFT_CARD"),
      @SerializedName("FB_ARTS_TICKET")
      VALUE_FB_ARTS_TICKET("FB_ARTS_TICKET"),
      @SerializedName("FB_BABY")
      VALUE_FB_BABY("FB_BABY"),
      @SerializedName("FB_BABY_BATH")
      VALUE_FB_BABY_BATH("FB_BABY_BATH"),
      @SerializedName("FB_BABY_BLANKET")
      VALUE_FB_BABY_BLANKET("FB_BABY_BLANKET"),
      @SerializedName("FB_BABY_DIAPER")
      VALUE_FB_BABY_DIAPER("FB_BABY_DIAPER"),
      @SerializedName("FB_BABY_GIFT_SET")
      VALUE_FB_BABY_GIFT_SET("FB_BABY_GIFT_SET"),
      @SerializedName("FB_BABY_HEALTH")
      VALUE_FB_BABY_HEALTH("FB_BABY_HEALTH"),
      @SerializedName("FB_BABY_NURSING")
      VALUE_FB_BABY_NURSING("FB_BABY_NURSING"),
      @SerializedName("FB_BABY_POTTY_TRN")
      VALUE_FB_BABY_POTTY_TRN("FB_BABY_POTTY_TRN"),
      @SerializedName("FB_BABY_SAFE")
      VALUE_FB_BABY_SAFE("FB_BABY_SAFE"),
      @SerializedName("FB_BABY_TOYS")
      VALUE_FB_BABY_TOYS("FB_BABY_TOYS"),
      @SerializedName("FB_BABY_TRANSPORT")
      VALUE_FB_BABY_TRANSPORT("FB_BABY_TRANSPORT"),
      @SerializedName("FB_BABY_TRANSPORT_ACC")
      VALUE_FB_BABY_TRANSPORT_ACC("FB_BABY_TRANSPORT_ACC"),
      @SerializedName("FB_BAGS")
      VALUE_FB_BAGS("FB_BAGS"),
      @SerializedName("FB_BAGS_BKPK")
      VALUE_FB_BAGS_BKPK("FB_BAGS_BKPK"),
      @SerializedName("FB_BAGS_BOXES")
      VALUE_FB_BAGS_BOXES("FB_BAGS_BOXES"),
      @SerializedName("FB_BAGS_BRFCS")
      VALUE_FB_BAGS_BRFCS("FB_BAGS_BRFCS"),
      @SerializedName("FB_BAGS_CSMT_BAG")
      VALUE_FB_BAGS_CSMT_BAG("FB_BAGS_CSMT_BAG"),
      @SerializedName("FB_BAGS_DFFL")
      VALUE_FB_BAGS_DFFL("FB_BAGS_DFFL"),
      @SerializedName("FB_BAGS_DIPR")
      VALUE_FB_BAGS_DIPR("FB_BAGS_DIPR"),
      @SerializedName("FB_BAGS_FNNY")
      VALUE_FB_BAGS_FNNY("FB_BAGS_FNNY"),
      @SerializedName("FB_BAGS_GRMT")
      VALUE_FB_BAGS_GRMT("FB_BAGS_GRMT"),
      @SerializedName("FB_BAGS_LUGG")
      VALUE_FB_BAGS_LUGG("FB_BAGS_LUGG"),
      @SerializedName("FB_BAGS_LUG_ACC")
      VALUE_FB_BAGS_LUG_ACC("FB_BAGS_LUG_ACC"),
      @SerializedName("FB_BAGS_MSGR")
      VALUE_FB_BAGS_MSGR("FB_BAGS_MSGR"),
      @SerializedName("FB_BAGS_TOTE")
      VALUE_FB_BAGS_TOTE("FB_BAGS_TOTE"),
      @SerializedName("FB_BAGS_TRN_CAS")
      VALUE_FB_BAGS_TRN_CAS("FB_BAGS_TRN_CAS"),
      @SerializedName("FB_BLDG")
      VALUE_FB_BLDG("FB_BLDG"),
      @SerializedName("FB_BLDG_ACC")
      VALUE_FB_BLDG_ACC("FB_BLDG_ACC"),
      @SerializedName("FB_BLDG_CNSMB")
      VALUE_FB_BLDG_CNSMB("FB_BLDG_CNSMB"),
      @SerializedName("FB_BLDG_FENCE")
      VALUE_FB_BLDG_FENCE("FB_BLDG_FENCE"),
      @SerializedName("FB_BLDG_FUEL_TNK")
      VALUE_FB_BLDG_FUEL_TNK("FB_BLDG_FUEL_TNK"),
      @SerializedName("FB_BLDG_HT_VNT")
      VALUE_FB_BLDG_HT_VNT("FB_BLDG_HT_VNT"),
      @SerializedName("FB_BLDG_LOCK")
      VALUE_FB_BLDG_LOCK("FB_BLDG_LOCK"),
      @SerializedName("FB_BLDG_MATRL")
      VALUE_FB_BLDG_MATRL("FB_BLDG_MATRL"),
      @SerializedName("FB_BLDG_PLMB")
      VALUE_FB_BLDG_PLMB("FB_BLDG_PLMB"),
      @SerializedName("FB_BLDG_PUMP")
      VALUE_FB_BLDG_PUMP("FB_BLDG_PUMP"),
      @SerializedName("FB_BLDG_PWRS")
      VALUE_FB_BLDG_PWRS("FB_BLDG_PWRS"),
      @SerializedName("FB_BLDG_STR_TANK")
      VALUE_FB_BLDG_STR_TANK("FB_BLDG_STR_TANK"),
      @SerializedName("FB_BLDG_S_ENG")
      VALUE_FB_BLDG_S_ENG("FB_BLDG_S_ENG"),
      @SerializedName("FB_BLDG_TL_ACC")
      VALUE_FB_BLDG_TL_ACC("FB_BLDG_TL_ACC"),
      @SerializedName("FB_BLDG_TOOL")
      VALUE_FB_BLDG_TOOL("FB_BLDG_TOOL"),
      @SerializedName("FB_BUSIND")
      VALUE_FB_BUSIND("FB_BUSIND"),
      @SerializedName("FB_BUSIND_ADVERTISING")
      VALUE_FB_BUSIND_ADVERTISING("FB_BUSIND_ADVERTISING"),
      @SerializedName("FB_BUSIND_AGRICULTURE")
      VALUE_FB_BUSIND_AGRICULTURE("FB_BUSIND_AGRICULTURE"),
      @SerializedName("FB_BUSIND_AUTOMATION")
      VALUE_FB_BUSIND_AUTOMATION("FB_BUSIND_AUTOMATION"),
      @SerializedName("FB_BUSIND_HEAVY_MACH")
      VALUE_FB_BUSIND_HEAVY_MACH("FB_BUSIND_HEAVY_MACH"),
      @SerializedName("FB_BUSIND_LAB")
      VALUE_FB_BUSIND_LAB("FB_BUSIND_LAB"),
      @SerializedName("FB_BUSIND_MEDICAL")
      VALUE_FB_BUSIND_MEDICAL("FB_BUSIND_MEDICAL"),
      @SerializedName("FB_BUSIND_RETAIL")
      VALUE_FB_BUSIND_RETAIL("FB_BUSIND_RETAIL"),
      @SerializedName("FB_BUSIND_SANITARY_CT")
      VALUE_FB_BUSIND_SANITARY_CT("FB_BUSIND_SANITARY_CT"),
      @SerializedName("FB_BUSIND_SIGN")
      VALUE_FB_BUSIND_SIGN("FB_BUSIND_SIGN"),
      @SerializedName("FB_BUSIND_STORAGE")
      VALUE_FB_BUSIND_STORAGE("FB_BUSIND_STORAGE"),
      @SerializedName("FB_BUSIND_STORAGE_ACC")
      VALUE_FB_BUSIND_STORAGE_ACC("FB_BUSIND_STORAGE_ACC"),
      @SerializedName("FB_BUSIND_WORK_GEAR")
      VALUE_FB_BUSIND_WORK_GEAR("FB_BUSIND_WORK_GEAR"),
      @SerializedName("FB_CAMERA_ACC")
      VALUE_FB_CAMERA_ACC("FB_CAMERA_ACC"),
      @SerializedName("FB_CAMERA_CAMERA")
      VALUE_FB_CAMERA_CAMERA("FB_CAMERA_CAMERA"),
      @SerializedName("FB_CAMERA_OPTIC")
      VALUE_FB_CAMERA_OPTIC("FB_CAMERA_OPTIC"),
      @SerializedName("FB_CAMERA_OPTICS")
      VALUE_FB_CAMERA_OPTICS("FB_CAMERA_OPTICS"),
      @SerializedName("FB_CAMERA_PHOTO")
      VALUE_FB_CAMERA_PHOTO("FB_CAMERA_PHOTO"),
      @SerializedName("FB_ELEC")
      VALUE_FB_ELEC("FB_ELEC"),
      @SerializedName("FB_ELEC_ACC")
      VALUE_FB_ELEC_ACC("FB_ELEC_ACC"),
      @SerializedName("FB_ELEC_ARCDADE")
      VALUE_FB_ELEC_ARCDADE("FB_ELEC_ARCDADE"),
      @SerializedName("FB_ELEC_AUDIO")
      VALUE_FB_ELEC_AUDIO("FB_ELEC_AUDIO"),
      @SerializedName("FB_ELEC_CIRCUIT")
      VALUE_FB_ELEC_CIRCUIT("FB_ELEC_CIRCUIT"),
      @SerializedName("FB_ELEC_COMM")
      VALUE_FB_ELEC_COMM("FB_ELEC_COMM"),
      @SerializedName("FB_ELEC_COMPUTER")
      VALUE_FB_ELEC_COMPUTER("FB_ELEC_COMPUTER"),
      @SerializedName("FB_ELEC_GPS_ACC")
      VALUE_FB_ELEC_GPS_ACC("FB_ELEC_GPS_ACC"),
      @SerializedName("FB_ELEC_GPS_NAV")
      VALUE_FB_ELEC_GPS_NAV("FB_ELEC_GPS_NAV"),
      @SerializedName("FB_ELEC_GPS_TRK")
      VALUE_FB_ELEC_GPS_TRK("FB_ELEC_GPS_TRK"),
      @SerializedName("FB_ELEC_MARINE")
      VALUE_FB_ELEC_MARINE("FB_ELEC_MARINE"),
      @SerializedName("FB_ELEC_NETWORK")
      VALUE_FB_ELEC_NETWORK("FB_ELEC_NETWORK"),
      @SerializedName("FB_ELEC_PART")
      VALUE_FB_ELEC_PART("FB_ELEC_PART"),
      @SerializedName("FB_ELEC_PRINT")
      VALUE_FB_ELEC_PRINT("FB_ELEC_PRINT"),
      @SerializedName("FB_ELEC_RADAR")
      VALUE_FB_ELEC_RADAR("FB_ELEC_RADAR"),
      @SerializedName("FB_ELEC_SFTWR")
      VALUE_FB_ELEC_SFTWR("FB_ELEC_SFTWR"),
      @SerializedName("FB_ELEC_SPEED_RDR")
      VALUE_FB_ELEC_SPEED_RDR("FB_ELEC_SPEED_RDR"),
      @SerializedName("FB_ELEC_TELEVISION")
      VALUE_FB_ELEC_TELEVISION("FB_ELEC_TELEVISION"),
      @SerializedName("FB_ELEC_TOLL")
      VALUE_FB_ELEC_TOLL("FB_ELEC_TOLL"),
      @SerializedName("FB_ELEC_VIDEO")
      VALUE_FB_ELEC_VIDEO("FB_ELEC_VIDEO"),
      @SerializedName("FB_ELEC_VID_GM_ACC")
      VALUE_FB_ELEC_VID_GM_ACC("FB_ELEC_VID_GM_ACC"),
      @SerializedName("FB_ELEC_VID_GM_CNSL")
      VALUE_FB_ELEC_VID_GM_CNSL("FB_ELEC_VID_GM_CNSL"),
      @SerializedName("FB_FOOD")
      VALUE_FB_FOOD("FB_FOOD"),
      @SerializedName("FB_FURN")
      VALUE_FB_FURN("FB_FURN"),
      @SerializedName("FB_FURN_BABY")
      VALUE_FB_FURN_BABY("FB_FURN_BABY"),
      @SerializedName("FB_FURN_BENCH")
      VALUE_FB_FURN_BENCH("FB_FURN_BENCH"),
      @SerializedName("FB_FURN_CART")
      VALUE_FB_FURN_CART("FB_FURN_CART"),
      @SerializedName("FB_FURN_CHAIR")
      VALUE_FB_FURN_CHAIR("FB_FURN_CHAIR"),
      @SerializedName("FB_FURN_CHAIR_ACC")
      VALUE_FB_FURN_CHAIR_ACC("FB_FURN_CHAIR_ACC"),
      @SerializedName("FB_FURN_DIVIDE")
      VALUE_FB_FURN_DIVIDE("FB_FURN_DIVIDE"),
      @SerializedName("FB_FURN_DIVIDE_ACC")
      VALUE_FB_FURN_DIVIDE_ACC("FB_FURN_DIVIDE_ACC"),
      @SerializedName("FB_FURN_ENT_CTR")
      VALUE_FB_FURN_ENT_CTR("FB_FURN_ENT_CTR"),
      @SerializedName("FB_FURN_FUTN")
      VALUE_FB_FURN_FUTN("FB_FURN_FUTN"),
      @SerializedName("FB_FURN_FUTN_PAD")
      VALUE_FB_FURN_FUTN_PAD("FB_FURN_FUTN_PAD"),
      @SerializedName("FB_FURN_OFFICE")
      VALUE_FB_FURN_OFFICE("FB_FURN_OFFICE"),
      @SerializedName("FB_FURN_OFFICE_ACC")
      VALUE_FB_FURN_OFFICE_ACC("FB_FURN_OFFICE_ACC"),
      @SerializedName("FB_FURN_OTTO")
      VALUE_FB_FURN_OTTO("FB_FURN_OTTO"),
      @SerializedName("FB_FURN_OUTDOOR")
      VALUE_FB_FURN_OUTDOOR("FB_FURN_OUTDOOR"),
      @SerializedName("FB_FURN_OUTDOOR_ACC")
      VALUE_FB_FURN_OUTDOOR_ACC("FB_FURN_OUTDOOR_ACC"),
      @SerializedName("FB_FURN_SETS")
      VALUE_FB_FURN_SETS("FB_FURN_SETS"),
      @SerializedName("FB_FURN_SHELVE_ACC")
      VALUE_FB_FURN_SHELVE_ACC("FB_FURN_SHELVE_ACC"),
      @SerializedName("FB_FURN_SHLF")
      VALUE_FB_FURN_SHLF("FB_FURN_SHLF"),
      @SerializedName("FB_FURN_SOFA")
      VALUE_FB_FURN_SOFA("FB_FURN_SOFA"),
      @SerializedName("FB_FURN_SOFA_ACC")
      VALUE_FB_FURN_SOFA_ACC("FB_FURN_SOFA_ACC"),
      @SerializedName("FB_FURN_STORAGE")
      VALUE_FB_FURN_STORAGE("FB_FURN_STORAGE"),
      @SerializedName("FB_FURN_TABL")
      VALUE_FB_FURN_TABL("FB_FURN_TABL"),
      @SerializedName("FB_FURN_TABL_ACC")
      VALUE_FB_FURN_TABL_ACC("FB_FURN_TABL_ACC"),
      @SerializedName("FB_GENERIC_TAXABLE")
      VALUE_FB_GENERIC_TAXABLE("FB_GENERIC_TAXABLE"),
      @SerializedName("FB_HLTH")
      VALUE_FB_HLTH("FB_HLTH"),
      @SerializedName("FB_HLTH_HLTH")
      VALUE_FB_HLTH_HLTH("FB_HLTH_HLTH"),
      @SerializedName("FB_HLTH_JWL_CR")
      VALUE_FB_HLTH_JWL_CR("FB_HLTH_JWL_CR"),
      @SerializedName("FB_HLTH_LILP_BLM")
      VALUE_FB_HLTH_LILP_BLM("FB_HLTH_LILP_BLM"),
      @SerializedName("FB_HLTH_LTN_SPF")
      VALUE_FB_HLTH_LTN_SPF("FB_HLTH_LTN_SPF"),
      @SerializedName("FB_HLTH_PRSL_CR")
      VALUE_FB_HLTH_PRSL_CR("FB_HLTH_PRSL_CR"),
      @SerializedName("FB_HLTH_SKN_CR")
      VALUE_FB_HLTH_SKN_CR("FB_HLTH_SKN_CR"),
      @SerializedName("FB_HMGN")
      VALUE_FB_HMGN("FB_HMGN"),
      @SerializedName("FB_HMGN_BATH")
      VALUE_FB_HMGN_BATH("FB_HMGN_BATH"),
      @SerializedName("FB_HMGN_DCOR")
      VALUE_FB_HMGN_DCOR("FB_HMGN_DCOR"),
      @SerializedName("FB_HMGN_EMGY")
      VALUE_FB_HMGN_EMGY("FB_HMGN_EMGY"),
      @SerializedName("FB_HMGN_FPLC")
      VALUE_FB_HMGN_FPLC("FB_HMGN_FPLC"),
      @SerializedName("FB_HMGN_FPLC_ACC")
      VALUE_FB_HMGN_FPLC_ACC("FB_HMGN_FPLC_ACC"),
      @SerializedName("FB_HMGN_GS_SFT")
      VALUE_FB_HMGN_GS_SFT("FB_HMGN_GS_SFT"),
      @SerializedName("FB_HMGN_HS_ACC")
      VALUE_FB_HMGN_HS_ACC("FB_HMGN_HS_ACC"),
      @SerializedName("FB_HMGN_HS_APP")
      VALUE_FB_HMGN_HS_APP("FB_HMGN_HS_APP"),
      @SerializedName("FB_HMGN_HS_SPL")
      VALUE_FB_HMGN_HS_SPL("FB_HMGN_HS_SPL"),
      @SerializedName("FB_HMGN_KTCN")
      VALUE_FB_HMGN_KTCN("FB_HMGN_KTCN"),
      @SerializedName("FB_HMGN_LAWN")
      VALUE_FB_HMGN_LAWN("FB_HMGN_LAWN"),
      @SerializedName("FB_HMGN_LGHT")
      VALUE_FB_HMGN_LGHT("FB_HMGN_LGHT"),
      @SerializedName("FB_HMGN_LINN")
      VALUE_FB_HMGN_LINN("FB_HMGN_LINN"),
      @SerializedName("FB_HMGN_LT_ACC")
      VALUE_FB_HMGN_LT_ACC("FB_HMGN_LT_ACC"),
      @SerializedName("FB_HMGN_OTDR")
      VALUE_FB_HMGN_OTDR("FB_HMGN_OTDR"),
      @SerializedName("FB_HMGN_POOL")
      VALUE_FB_HMGN_POOL("FB_HMGN_POOL"),
      @SerializedName("FB_HMGN_SCTY")
      VALUE_FB_HMGN_SCTY("FB_HMGN_SCTY"),
      @SerializedName("FB_HMGN_SMK_ACC")
      VALUE_FB_HMGN_SMK_ACC("FB_HMGN_SMK_ACC"),
      @SerializedName("FB_HMGN_UMBR")
      VALUE_FB_HMGN_UMBR("FB_HMGN_UMBR"),
      @SerializedName("FB_HMGN_UMBR_ACC")
      VALUE_FB_HMGN_UMBR_ACC("FB_HMGN_UMBR_ACC"),
      @SerializedName("FB_MDIA")
      VALUE_FB_MDIA("FB_MDIA"),
      @SerializedName("FB_MDIA_BOOK")
      VALUE_FB_MDIA_BOOK("FB_MDIA_BOOK"),
      @SerializedName("FB_MDIA_DVDS")
      VALUE_FB_MDIA_DVDS("FB_MDIA_DVDS"),
      @SerializedName("FB_MDIA_MAG")
      VALUE_FB_MDIA_MAG("FB_MDIA_MAG"),
      @SerializedName("FB_MDIA_MANL")
      VALUE_FB_MDIA_MANL("FB_MDIA_MANL"),
      @SerializedName("FB_MDIA_MUSC")
      VALUE_FB_MDIA_MUSC("FB_MDIA_MUSC"),
      @SerializedName("FB_MDIA_PRJ_PLN")
      VALUE_FB_MDIA_PRJ_PLN("FB_MDIA_PRJ_PLN"),
      @SerializedName("FB_MDIA_SHT_MUS")
      VALUE_FB_MDIA_SHT_MUS("FB_MDIA_SHT_MUS"),
      @SerializedName("FB_OFFC")
      VALUE_FB_OFFC("FB_OFFC"),
      @SerializedName("FB_OFFC_BKAC")
      VALUE_FB_OFFC_BKAC("FB_OFFC_BKAC"),
      @SerializedName("FB_OFFC_CRTS")
      VALUE_FB_OFFC_CRTS("FB_OFFC_CRTS"),
      @SerializedName("FB_OFFC_DSKP")
      VALUE_FB_OFFC_DSKP("FB_OFFC_DSKP"),
      @SerializedName("FB_OFFC_EQIP")
      VALUE_FB_OFFC_EQIP("FB_OFFC_EQIP"),
      @SerializedName("FB_OFFC_FLNG")
      VALUE_FB_OFFC_FLNG("FB_OFFC_FLNG"),
      @SerializedName("FB_OFFC_GNRL")
      VALUE_FB_OFFC_GNRL("FB_OFFC_GNRL"),
      @SerializedName("FB_OFFC_INSTM")
      VALUE_FB_OFFC_INSTM("FB_OFFC_INSTM"),
      @SerializedName("FB_OFFC_LP_DSK")
      VALUE_FB_OFFC_LP_DSK("FB_OFFC_LP_DSK"),
      @SerializedName("FB_OFFC_MATS")
      VALUE_FB_OFFC_MATS("FB_OFFC_MATS"),
      @SerializedName("FB_OFFC_NM_PLT")
      VALUE_FB_OFFC_NM_PLT("FB_OFFC_NM_PLT"),
      @SerializedName("FB_OFFC_PPR_HNDL")
      VALUE_FB_OFFC_PPR_HNDL("FB_OFFC_PPR_HNDL"),
      @SerializedName("FB_OFFC_PRSNT_SPL")
      VALUE_FB_OFFC_PRSNT_SPL("FB_OFFC_PRSNT_SPL"),
      @SerializedName("FB_OFFC_SEALR")
      VALUE_FB_OFFC_SEALR("FB_OFFC_SEALR"),
      @SerializedName("FB_OFFC_SHIP_SPL")
      VALUE_FB_OFFC_SHIP_SPL("FB_OFFC_SHIP_SPL"),
      @SerializedName("FB_RLGN")
      VALUE_FB_RLGN("FB_RLGN"),
      @SerializedName("FB_RLGN_CMNY")
      VALUE_FB_RLGN_CMNY("FB_RLGN_CMNY"),
      @SerializedName("FB_RLGN_ITEM")
      VALUE_FB_RLGN_ITEM("FB_RLGN_ITEM"),
      @SerializedName("FB_RLGN_WEDD")
      VALUE_FB_RLGN_WEDD("FB_RLGN_WEDD"),
      @SerializedName("FB_SFTWR")
      VALUE_FB_SFTWR("FB_SFTWR"),
      @SerializedName("FB_SFWR_CMPTR")
      VALUE_FB_SFWR_CMPTR("FB_SFWR_CMPTR"),
      @SerializedName("FB_SFWR_DGTL_GD")
      VALUE_FB_SFWR_DGTL_GD("FB_SFWR_DGTL_GD"),
      @SerializedName("FB_SFWR_GAME")
      VALUE_FB_SFWR_GAME("FB_SFWR_GAME"),
      @SerializedName("FB_SHIPPING")
      VALUE_FB_SHIPPING("FB_SHIPPING"),
      @SerializedName("FB_SPOR")
      VALUE_FB_SPOR("FB_SPOR"),
      @SerializedName("FB_SPORT_ATHL")
      VALUE_FB_SPORT_ATHL("FB_SPORT_ATHL"),
      @SerializedName("FB_SPORT_ATHL_CLTH")
      VALUE_FB_SPORT_ATHL_CLTH("FB_SPORT_ATHL_CLTH"),
      @SerializedName("FB_SPORT_ATHL_SHOE")
      VALUE_FB_SPORT_ATHL_SHOE("FB_SPORT_ATHL_SHOE"),
      @SerializedName("FB_SPORT_ATHL_SPRT")
      VALUE_FB_SPORT_ATHL_SPRT("FB_SPORT_ATHL_SPRT"),
      @SerializedName("FB_SPORT_EXRCS")
      VALUE_FB_SPORT_EXRCS("FB_SPORT_EXRCS"),
      @SerializedName("FB_SPORT_INDR_GM")
      VALUE_FB_SPORT_INDR_GM("FB_SPORT_INDR_GM"),
      @SerializedName("FB_SPORT_OTDR_GM")
      VALUE_FB_SPORT_OTDR_GM("FB_SPORT_OTDR_GM"),
      @SerializedName("FB_TOYS")
      VALUE_FB_TOYS("FB_TOYS"),
      @SerializedName("FB_TOYS_EQIP")
      VALUE_FB_TOYS_EQIP("FB_TOYS_EQIP"),
      @SerializedName("FB_TOYS_GAME")
      VALUE_FB_TOYS_GAME("FB_TOYS_GAME"),
      @SerializedName("FB_TOYS_PZZL")
      VALUE_FB_TOYS_PZZL("FB_TOYS_PZZL"),
      @SerializedName("FB_TOYS_TMRS")
      VALUE_FB_TOYS_TMRS("FB_TOYS_TMRS"),
      @SerializedName("FB_TOYS_TOYS")
      VALUE_FB_TOYS_TOYS("FB_TOYS_TOYS"),
      @SerializedName("FB_VEHI")
      VALUE_FB_VEHI("FB_VEHI"),
      @SerializedName("FB_VEHI_PART")
      VALUE_FB_VEHI_PART("FB_VEHI_PART"),
      ;

      private String value;

      private EnumCommerceTaxCategory(String value) {
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

  public static enum EnumErrorType {
      @SerializedName("ADDRESS_BLOCKLISTED_IN_MARKET")
      VALUE_ADDRESS_BLOCKLISTED_IN_MARKET("ADDRESS_BLOCKLISTED_IN_MARKET"),
      @SerializedName("AGGREGATED_LOCALIZATION_ISSUES")
      VALUE_AGGREGATED_LOCALIZATION_ISSUES("AGGREGATED_LOCALIZATION_ISSUES"),
      @SerializedName("APP_HAS_NO_AEM_SETUP")
      VALUE_APP_HAS_NO_AEM_SETUP("APP_HAS_NO_AEM_SETUP"),
      @SerializedName("AR_DELETED_DUE_TO_UPDATE")
      VALUE_AR_DELETED_DUE_TO_UPDATE("AR_DELETED_DUE_TO_UPDATE"),
      @SerializedName("AR_POLICY_VIOLATED")
      VALUE_AR_POLICY_VIOLATED("AR_POLICY_VIOLATED"),
      @SerializedName("AVAILABLE")
      VALUE_AVAILABLE("AVAILABLE"),
      @SerializedName("BAD_QUALITY_IMAGE")
      VALUE_BAD_QUALITY_IMAGE("BAD_QUALITY_IMAGE"),
      @SerializedName("BIG_CATALOG_WITH_ALL_ITEMS_IN_STOCK")
      VALUE_BIG_CATALOG_WITH_ALL_ITEMS_IN_STOCK("BIG_CATALOG_WITH_ALL_ITEMS_IN_STOCK"),
      @SerializedName("BIZ_MSG_AI_AGENT_DISABLED_BY_USER")
      VALUE_BIZ_MSG_AI_AGENT_DISABLED_BY_USER("BIZ_MSG_AI_AGENT_DISABLED_BY_USER"),
      @SerializedName("CANNOT_EDIT_SUBSCRIPTION_PRODUCTS")
      VALUE_CANNOT_EDIT_SUBSCRIPTION_PRODUCTS("CANNOT_EDIT_SUBSCRIPTION_PRODUCTS"),
      @SerializedName("CATALOG_NOT_CONNECTED_TO_EVENT_SOURCE")
      VALUE_CATALOG_NOT_CONNECTED_TO_EVENT_SOURCE("CATALOG_NOT_CONNECTED_TO_EVENT_SOURCE"),
      @SerializedName("CHECKOUT_DISABLED_BY_USER")
      VALUE_CHECKOUT_DISABLED_BY_USER("CHECKOUT_DISABLED_BY_USER"),
      @SerializedName("COMMERCE_ACCOUNT_LEGAL_ADDRESS_INVALID")
      VALUE_COMMERCE_ACCOUNT_LEGAL_ADDRESS_INVALID("COMMERCE_ACCOUNT_LEGAL_ADDRESS_INVALID"),
      @SerializedName("COMMERCE_ACCOUNT_NOT_LEGALLY_COMPLIANT")
      VALUE_COMMERCE_ACCOUNT_NOT_LEGALLY_COMPLIANT("COMMERCE_ACCOUNT_NOT_LEGALLY_COMPLIANT"),
      @SerializedName("CRAWLED_AVAILABILITY_MISMATCH")
      VALUE_CRAWLED_AVAILABILITY_MISMATCH("CRAWLED_AVAILABILITY_MISMATCH"),
      @SerializedName("DA_DISABLED_BY_USER")
      VALUE_DA_DISABLED_BY_USER("DA_DISABLED_BY_USER"),
      @SerializedName("DA_POLICY_VIOLATION")
      VALUE_DA_POLICY_VIOLATION("DA_POLICY_VIOLATION"),
      @SerializedName("DELETED_ITEM")
      VALUE_DELETED_ITEM("DELETED_ITEM"),
      @SerializedName("DIGITAL_GOODS_NOT_AVAILABLE_FOR_CHECKOUT")
      VALUE_DIGITAL_GOODS_NOT_AVAILABLE_FOR_CHECKOUT("DIGITAL_GOODS_NOT_AVAILABLE_FOR_CHECKOUT"),
      @SerializedName("DUPLICATE_IMAGES")
      VALUE_DUPLICATE_IMAGES("DUPLICATE_IMAGES"),
      @SerializedName("DUPLICATE_TITLE_AND_DESCRIPTION")
      VALUE_DUPLICATE_TITLE_AND_DESCRIPTION("DUPLICATE_TITLE_AND_DESCRIPTION"),
      @SerializedName("EMPTY_AVAILABILITY")
      VALUE_EMPTY_AVAILABILITY("EMPTY_AVAILABILITY"),
      @SerializedName("EMPTY_CONDITION")
      VALUE_EMPTY_CONDITION("EMPTY_CONDITION"),
      @SerializedName("EMPTY_DESCRIPTION")
      VALUE_EMPTY_DESCRIPTION("EMPTY_DESCRIPTION"),
      @SerializedName("EMPTY_IMAGE_URL")
      VALUE_EMPTY_IMAGE_URL("EMPTY_IMAGE_URL"),
      @SerializedName("EMPTY_PRICE")
      VALUE_EMPTY_PRICE("EMPTY_PRICE"),
      @SerializedName("EMPTY_PRODUCT_URL")
      VALUE_EMPTY_PRODUCT_URL("EMPTY_PRODUCT_URL"),
      @SerializedName("EMPTY_SELLER_DESCRIPTION")
      VALUE_EMPTY_SELLER_DESCRIPTION("EMPTY_SELLER_DESCRIPTION"),
      @SerializedName("EMPTY_TITLE")
      VALUE_EMPTY_TITLE("EMPTY_TITLE"),
      @SerializedName("EXTERNAL_MERCHANT_ID_MISMATCH")
      VALUE_EXTERNAL_MERCHANT_ID_MISMATCH("EXTERNAL_MERCHANT_ID_MISMATCH"),
      @SerializedName("GENERIC_INVALID_FIELD")
      VALUE_GENERIC_INVALID_FIELD("GENERIC_INVALID_FIELD"),
      @SerializedName("GROUPS_DISABLED_BY_USER")
      VALUE_GROUPS_DISABLED_BY_USER("GROUPS_DISABLED_BY_USER"),
      @SerializedName("HIDDEN_UNTIL_PRODUCT_LAUNCH")
      VALUE_HIDDEN_UNTIL_PRODUCT_LAUNCH("HIDDEN_UNTIL_PRODUCT_LAUNCH"),
      @SerializedName("ILLEGAL_PRODUCT_CATEGORY")
      VALUE_ILLEGAL_PRODUCT_CATEGORY("ILLEGAL_PRODUCT_CATEGORY"),
      @SerializedName("IMAGE_FETCH_FAILED")
      VALUE_IMAGE_FETCH_FAILED("IMAGE_FETCH_FAILED"),
      @SerializedName("IMAGE_FETCH_FAILED_BAD_GATEWAY")
      VALUE_IMAGE_FETCH_FAILED_BAD_GATEWAY("IMAGE_FETCH_FAILED_BAD_GATEWAY"),
      @SerializedName("IMAGE_FETCH_FAILED_FILE_SIZE_EXCEEDED")
      VALUE_IMAGE_FETCH_FAILED_FILE_SIZE_EXCEEDED("IMAGE_FETCH_FAILED_FILE_SIZE_EXCEEDED"),
      @SerializedName("IMAGE_FETCH_FAILED_FORBIDDEN")
      VALUE_IMAGE_FETCH_FAILED_FORBIDDEN("IMAGE_FETCH_FAILED_FORBIDDEN"),
      @SerializedName("IMAGE_FETCH_FAILED_LINK_BROKEN")
      VALUE_IMAGE_FETCH_FAILED_LINK_BROKEN("IMAGE_FETCH_FAILED_LINK_BROKEN"),
      @SerializedName("IMAGE_FETCH_FAILED_TIMED_OUT")
      VALUE_IMAGE_FETCH_FAILED_TIMED_OUT("IMAGE_FETCH_FAILED_TIMED_OUT"),
      @SerializedName("IMAGE_RESOLUTION_LOW")
      VALUE_IMAGE_RESOLUTION_LOW("IMAGE_RESOLUTION_LOW"),
      @SerializedName("INACTIVE_SHOPIFY_PRODUCT")
      VALUE_INACTIVE_SHOPIFY_PRODUCT("INACTIVE_SHOPIFY_PRODUCT"),
      @SerializedName("INVALID_COMMERCE_TAX_CATEGORY")
      VALUE_INVALID_COMMERCE_TAX_CATEGORY("INVALID_COMMERCE_TAX_CATEGORY"),
      @SerializedName("INVALID_CONSOLIDATED_LOCALITY_INFORMATION")
      VALUE_INVALID_CONSOLIDATED_LOCALITY_INFORMATION("INVALID_CONSOLIDATED_LOCALITY_INFORMATION"),
      @SerializedName("INVALID_CONTENT_ID")
      VALUE_INVALID_CONTENT_ID("INVALID_CONTENT_ID"),
      @SerializedName("INVALID_DEALER_COMMUNICATION_PARAMETERS")
      VALUE_INVALID_DEALER_COMMUNICATION_PARAMETERS("INVALID_DEALER_COMMUNICATION_PARAMETERS"),
      @SerializedName("INVALID_DMA_CODES")
      VALUE_INVALID_DMA_CODES("INVALID_DMA_CODES"),
      @SerializedName("INVALID_FB_PAGE_ID")
      VALUE_INVALID_FB_PAGE_ID("INVALID_FB_PAGE_ID"),
      @SerializedName("INVALID_IMAGES")
      VALUE_INVALID_IMAGES("INVALID_IMAGES"),
      @SerializedName("INVALID_MONETIZER_RETURN_POLICY")
      VALUE_INVALID_MONETIZER_RETURN_POLICY("INVALID_MONETIZER_RETURN_POLICY"),
      @SerializedName("INVALID_OFFER_DISCLAIMER_URL")
      VALUE_INVALID_OFFER_DISCLAIMER_URL("INVALID_OFFER_DISCLAIMER_URL"),
      @SerializedName("INVALID_OFFER_END_DATE")
      VALUE_INVALID_OFFER_END_DATE("INVALID_OFFER_END_DATE"),
      @SerializedName("INVALID_PRE_ORDER_PARAMS")
      VALUE_INVALID_PRE_ORDER_PARAMS("INVALID_PRE_ORDER_PARAMS"),
      @SerializedName("INVALID_RANGE_FOR_AREA_SIZE")
      VALUE_INVALID_RANGE_FOR_AREA_SIZE("INVALID_RANGE_FOR_AREA_SIZE"),
      @SerializedName("INVALID_RANGE_FOR_BUILT_UP_AREA_SIZE")
      VALUE_INVALID_RANGE_FOR_BUILT_UP_AREA_SIZE("INVALID_RANGE_FOR_BUILT_UP_AREA_SIZE"),
      @SerializedName("INVALID_RANGE_FOR_NUM_OF_BATHS")
      VALUE_INVALID_RANGE_FOR_NUM_OF_BATHS("INVALID_RANGE_FOR_NUM_OF_BATHS"),
      @SerializedName("INVALID_RANGE_FOR_NUM_OF_BEDS")
      VALUE_INVALID_RANGE_FOR_NUM_OF_BEDS("INVALID_RANGE_FOR_NUM_OF_BEDS"),
      @SerializedName("INVALID_RANGE_FOR_NUM_OF_ROOMS")
      VALUE_INVALID_RANGE_FOR_NUM_OF_ROOMS("INVALID_RANGE_FOR_NUM_OF_ROOMS"),
      @SerializedName("INVALID_RANGE_FOR_PARKING_SPACES")
      VALUE_INVALID_RANGE_FOR_PARKING_SPACES("INVALID_RANGE_FOR_PARKING_SPACES"),
      @SerializedName("INVALID_SHELTER_PAGE_ID")
      VALUE_INVALID_SHELTER_PAGE_ID("INVALID_SHELTER_PAGE_ID"),
      @SerializedName("INVALID_SHIPPING_PROFILE_PARAMS")
      VALUE_INVALID_SHIPPING_PROFILE_PARAMS("INVALID_SHIPPING_PROFILE_PARAMS"),
      @SerializedName("INVALID_SUBSCRIPTION_DISABLE_PARAMS")
      VALUE_INVALID_SUBSCRIPTION_DISABLE_PARAMS("INVALID_SUBSCRIPTION_DISABLE_PARAMS"),
      @SerializedName("INVALID_SUBSCRIPTION_ENABLE_PARAMS")
      VALUE_INVALID_SUBSCRIPTION_ENABLE_PARAMS("INVALID_SUBSCRIPTION_ENABLE_PARAMS"),
      @SerializedName("INVALID_SUBSCRIPTION_PARAMS")
      VALUE_INVALID_SUBSCRIPTION_PARAMS("INVALID_SUBSCRIPTION_PARAMS"),
      @SerializedName("INVALID_VEHICLE_STATE")
      VALUE_INVALID_VEHICLE_STATE("INVALID_VEHICLE_STATE"),
      @SerializedName("INVALID_VIRTUAL_TOUR_URL_DOMAIN")
      VALUE_INVALID_VIRTUAL_TOUR_URL_DOMAIN("INVALID_VIRTUAL_TOUR_URL_DOMAIN"),
      @SerializedName("INVENTORY_ZERO_AVAILABILITY_IN_STOCK")
      VALUE_INVENTORY_ZERO_AVAILABILITY_IN_STOCK("INVENTORY_ZERO_AVAILABILITY_IN_STOCK"),
      @SerializedName("IN_ANOTHER_PRODUCT_LAUNCH")
      VALUE_IN_ANOTHER_PRODUCT_LAUNCH("IN_ANOTHER_PRODUCT_LAUNCH"),
      @SerializedName("ITEM_GROUP_NOT_SPECIFIED")
      VALUE_ITEM_GROUP_NOT_SPECIFIED("ITEM_GROUP_NOT_SPECIFIED"),
      @SerializedName("ITEM_NOT_SHIPPABLE_FOR_SCA_SHOP")
      VALUE_ITEM_NOT_SHIPPABLE_FOR_SCA_SHOP("ITEM_NOT_SHIPPABLE_FOR_SCA_SHOP"),
      @SerializedName("ITEM_OVERRIDE_EMPTY_AVAILABILITY")
      VALUE_ITEM_OVERRIDE_EMPTY_AVAILABILITY("ITEM_OVERRIDE_EMPTY_AVAILABILITY"),
      @SerializedName("ITEM_OVERRIDE_EMPTY_PRICE")
      VALUE_ITEM_OVERRIDE_EMPTY_PRICE("ITEM_OVERRIDE_EMPTY_PRICE"),
      @SerializedName("ITEM_OVERRIDE_NOT_VISIBLE")
      VALUE_ITEM_OVERRIDE_NOT_VISIBLE("ITEM_OVERRIDE_NOT_VISIBLE"),
      @SerializedName("ITEM_PRICE_NOT_POSITIVE")
      VALUE_ITEM_PRICE_NOT_POSITIVE("ITEM_PRICE_NOT_POSITIVE"),
      @SerializedName("ITEM_STALE_OUT_OF_STOCK")
      VALUE_ITEM_STALE_OUT_OF_STOCK("ITEM_STALE_OUT_OF_STOCK"),
      @SerializedName("MARKETPLACE_DISABLED_BY_USER")
      VALUE_MARKETPLACE_DISABLED_BY_USER("MARKETPLACE_DISABLED_BY_USER"),
      @SerializedName("MINI_SHOPS_DISABLED_BY_USER")
      VALUE_MINI_SHOPS_DISABLED_BY_USER("MINI_SHOPS_DISABLED_BY_USER"),
      @SerializedName("MISSING_CHECKOUT")
      VALUE_MISSING_CHECKOUT("MISSING_CHECKOUT"),
      @SerializedName("MISSING_CHECKOUT_CURRENCY")
      VALUE_MISSING_CHECKOUT_CURRENCY("MISSING_CHECKOUT_CURRENCY"),
      @SerializedName("MISSING_COLOR")
      VALUE_MISSING_COLOR("MISSING_COLOR"),
      @SerializedName("MISSING_COUNTRY_OVERRIDE_IN_SHIPPING_PROFILE")
      VALUE_MISSING_COUNTRY_OVERRIDE_IN_SHIPPING_PROFILE("MISSING_COUNTRY_OVERRIDE_IN_SHIPPING_PROFILE"),
      @SerializedName("MISSING_EVENT")
      VALUE_MISSING_EVENT("MISSING_EVENT"),
      @SerializedName("MISSING_INDIA_COMPLIANCE_FIELDS")
      VALUE_MISSING_INDIA_COMPLIANCE_FIELDS("MISSING_INDIA_COMPLIANCE_FIELDS"),
      @SerializedName("MISSING_SHIPPING_PROFILE")
      VALUE_MISSING_SHIPPING_PROFILE("MISSING_SHIPPING_PROFILE"),
      @SerializedName("MISSING_SIZE")
      VALUE_MISSING_SIZE("MISSING_SIZE"),
      @SerializedName("MISSING_TAX_CATEGORY")
      VALUE_MISSING_TAX_CATEGORY("MISSING_TAX_CATEGORY"),
      @SerializedName("NEGATIVE_COMMUNITY_FEEDBACK")
      VALUE_NEGATIVE_COMMUNITY_FEEDBACK("NEGATIVE_COMMUNITY_FEEDBACK"),
      @SerializedName("NEGATIVE_PRICE")
      VALUE_NEGATIVE_PRICE("NEGATIVE_PRICE"),
      @SerializedName("NOT_ENOUGH_IMAGES")
      VALUE_NOT_ENOUGH_IMAGES("NOT_ENOUGH_IMAGES"),
      @SerializedName("NOT_ENOUGH_UNIQUE_PRODUCTS")
      VALUE_NOT_ENOUGH_UNIQUE_PRODUCTS("NOT_ENOUGH_UNIQUE_PRODUCTS"),
      @SerializedName("NO_CONTENT_ID")
      VALUE_NO_CONTENT_ID("NO_CONTENT_ID"),
      @SerializedName("OVERLAY_DISCLAIMER_EXCEEDED_MAX_LENGTH")
      VALUE_OVERLAY_DISCLAIMER_EXCEEDED_MAX_LENGTH("OVERLAY_DISCLAIMER_EXCEEDED_MAX_LENGTH"),
      @SerializedName("PART_OF_PRODUCT_LAUNCH")
      VALUE_PART_OF_PRODUCT_LAUNCH("PART_OF_PRODUCT_LAUNCH"),
      @SerializedName("PASSING_MULTIPLE_CONTENT_IDS")
      VALUE_PASSING_MULTIPLE_CONTENT_IDS("PASSING_MULTIPLE_CONTENT_IDS"),
      @SerializedName("PRODUCT_DOMINANT_CURRENCY_MISMATCH")
      VALUE_PRODUCT_DOMINANT_CURRENCY_MISMATCH("PRODUCT_DOMINANT_CURRENCY_MISMATCH"),
      @SerializedName("PRODUCT_EXPIRED")
      VALUE_PRODUCT_EXPIRED("PRODUCT_EXPIRED"),
      @SerializedName("PRODUCT_ITEM_HIDDEN_FROM_ALL_SHOPS")
      VALUE_PRODUCT_ITEM_HIDDEN_FROM_ALL_SHOPS("PRODUCT_ITEM_HIDDEN_FROM_ALL_SHOPS"),
      @SerializedName("PRODUCT_ITEM_INVALID_PARTNER_TOKENS")
      VALUE_PRODUCT_ITEM_INVALID_PARTNER_TOKENS("PRODUCT_ITEM_INVALID_PARTNER_TOKENS"),
      @SerializedName("PRODUCT_ITEM_NOT_INCLUDED_IN_ANY_SHOP")
      VALUE_PRODUCT_ITEM_NOT_INCLUDED_IN_ANY_SHOP("PRODUCT_ITEM_NOT_INCLUDED_IN_ANY_SHOP"),
      @SerializedName("PRODUCT_ITEM_NOT_VISIBLE")
      VALUE_PRODUCT_ITEM_NOT_VISIBLE("PRODUCT_ITEM_NOT_VISIBLE"),
      @SerializedName("PRODUCT_NOT_APPROVED")
      VALUE_PRODUCT_NOT_APPROVED("PRODUCT_NOT_APPROVED"),
      @SerializedName("PRODUCT_NOT_DOMINANT_CURRENCY")
      VALUE_PRODUCT_NOT_DOMINANT_CURRENCY("PRODUCT_NOT_DOMINANT_CURRENCY"),
      @SerializedName("PRODUCT_OUT_OF_STOCK")
      VALUE_PRODUCT_OUT_OF_STOCK("PRODUCT_OUT_OF_STOCK"),
      @SerializedName("PRODUCT_URL_EQUALS_DOMAIN")
      VALUE_PRODUCT_URL_EQUALS_DOMAIN("PRODUCT_URL_EQUALS_DOMAIN"),
      @SerializedName("PROPERTY_PRICE_CURRENCY_NOT_SUPPORTED")
      VALUE_PROPERTY_PRICE_CURRENCY_NOT_SUPPORTED("PROPERTY_PRICE_CURRENCY_NOT_SUPPORTED"),
      @SerializedName("PROPERTY_PRICE_TOO_HIGH")
      VALUE_PROPERTY_PRICE_TOO_HIGH("PROPERTY_PRICE_TOO_HIGH"),
      @SerializedName("PROPERTY_PRICE_TOO_LOW")
      VALUE_PROPERTY_PRICE_TOO_LOW("PROPERTY_PRICE_TOO_LOW"),
      @SerializedName("PROPERTY_UNIT_PRICE_CURRENCY_MISMATCH_ITEM_PRICE_CURRENCY")
      VALUE_PROPERTY_UNIT_PRICE_CURRENCY_MISMATCH_ITEM_PRICE_CURRENCY("PROPERTY_UNIT_PRICE_CURRENCY_MISMATCH_ITEM_PRICE_CURRENCY"),
      @SerializedName("PROPERTY_VALUE_CONTAINS_HTML_TAGS")
      VALUE_PROPERTY_VALUE_CONTAINS_HTML_TAGS("PROPERTY_VALUE_CONTAINS_HTML_TAGS"),
      @SerializedName("PROPERTY_VALUE_DESCRIPTION_CONTAINS_OFF_PLATFORM_LINK")
      VALUE_PROPERTY_VALUE_DESCRIPTION_CONTAINS_OFF_PLATFORM_LINK("PROPERTY_VALUE_DESCRIPTION_CONTAINS_OFF_PLATFORM_LINK"),
      @SerializedName("PROPERTY_VALUE_FORMAT")
      VALUE_PROPERTY_VALUE_FORMAT("PROPERTY_VALUE_FORMAT"),
      @SerializedName("PROPERTY_VALUE_MISSING")
      VALUE_PROPERTY_VALUE_MISSING("PROPERTY_VALUE_MISSING"),
      @SerializedName("PROPERTY_VALUE_MISSING_WARNING")
      VALUE_PROPERTY_VALUE_MISSING_WARNING("PROPERTY_VALUE_MISSING_WARNING"),
      @SerializedName("PROPERTY_VALUE_NON_POSITIVE")
      VALUE_PROPERTY_VALUE_NON_POSITIVE("PROPERTY_VALUE_NON_POSITIVE"),
      @SerializedName("PROPERTY_VALUE_STRING_EXCEEDS_LENGTH")
      VALUE_PROPERTY_VALUE_STRING_EXCEEDS_LENGTH("PROPERTY_VALUE_STRING_EXCEEDS_LENGTH"),
      @SerializedName("PROPERTY_VALUE_STRING_TOO_SHORT")
      VALUE_PROPERTY_VALUE_STRING_TOO_SHORT("PROPERTY_VALUE_STRING_TOO_SHORT"),
      @SerializedName("PROPERTY_VALUE_UPPERCASE")
      VALUE_PROPERTY_VALUE_UPPERCASE("PROPERTY_VALUE_UPPERCASE"),
      @SerializedName("PROPERTY_VALUE_UPPERCASE_WARNING")
      VALUE_PROPERTY_VALUE_UPPERCASE_WARNING("PROPERTY_VALUE_UPPERCASE_WARNING"),
      @SerializedName("PURCHASE_RATE_BELOW_ADDTOCART")
      VALUE_PURCHASE_RATE_BELOW_ADDTOCART("PURCHASE_RATE_BELOW_ADDTOCART"),
      @SerializedName("PURCHASE_RATE_BELOW_VIEWCONTENT")
      VALUE_PURCHASE_RATE_BELOW_VIEWCONTENT("PURCHASE_RATE_BELOW_VIEWCONTENT"),
      @SerializedName("QUALITY_DUPLICATED_DESCRIPTION")
      VALUE_QUALITY_DUPLICATED_DESCRIPTION("QUALITY_DUPLICATED_DESCRIPTION"),
      @SerializedName("QUALITY_ITEM_LINK_BROKEN")
      VALUE_QUALITY_ITEM_LINK_BROKEN("QUALITY_ITEM_LINK_BROKEN"),
      @SerializedName("QUALITY_ITEM_LINK_REDIRECTING")
      VALUE_QUALITY_ITEM_LINK_REDIRECTING("QUALITY_ITEM_LINK_REDIRECTING"),
      @SerializedName("RETAILER_ID_NOT_PROVIDED")
      VALUE_RETAILER_ID_NOT_PROVIDED("RETAILER_ID_NOT_PROVIDED"),
      @SerializedName("SHOPIFY_INVALID_RETAILER_ID")
      VALUE_SHOPIFY_INVALID_RETAILER_ID("SHOPIFY_INVALID_RETAILER_ID"),
      @SerializedName("SHOPIFY_ITEM_MISSING_SHIPPING_PROFILE")
      VALUE_SHOPIFY_ITEM_MISSING_SHIPPING_PROFILE("SHOPIFY_ITEM_MISSING_SHIPPING_PROFILE"),
      @SerializedName("SHOPS_POLICY_VIOLATION")
      VALUE_SHOPS_POLICY_VIOLATION("SHOPS_POLICY_VIOLATION"),
      @SerializedName("SUBSCRIPTION_INFO_NOT_ENABLED_FOR_FEED")
      VALUE_SUBSCRIPTION_INFO_NOT_ENABLED_FOR_FEED("SUBSCRIPTION_INFO_NOT_ENABLED_FOR_FEED"),
      @SerializedName("TAX_CATEGORY_NOT_SUPPORTED_IN_UK")
      VALUE_TAX_CATEGORY_NOT_SUPPORTED_IN_UK("TAX_CATEGORY_NOT_SUPPORTED_IN_UK"),
      @SerializedName("UNIQUE_PRODUCT_IDENTIFIER_MISSING")
      VALUE_UNIQUE_PRODUCT_IDENTIFIER_MISSING("UNIQUE_PRODUCT_IDENTIFIER_MISSING"),
      @SerializedName("UNMATCHED_EVENTS")
      VALUE_UNMATCHED_EVENTS("UNMATCHED_EVENTS"),
      @SerializedName("UNSUPPORTED_PRODUCT_CATEGORY")
      VALUE_UNSUPPORTED_PRODUCT_CATEGORY("UNSUPPORTED_PRODUCT_CATEGORY"),
      @SerializedName("VARIANT_ATTRIBUTE_ISSUE")
      VALUE_VARIANT_ATTRIBUTE_ISSUE("VARIANT_ATTRIBUTE_ISSUE"),
      @SerializedName("VIDEO_FETCH_FAILED")
      VALUE_VIDEO_FETCH_FAILED("VIDEO_FETCH_FAILED"),
      @SerializedName("VIDEO_FETCH_FAILED_BAD_GATEWAY")
      VALUE_VIDEO_FETCH_FAILED_BAD_GATEWAY("VIDEO_FETCH_FAILED_BAD_GATEWAY"),
      @SerializedName("VIDEO_FETCH_FAILED_FILE_SIZE_EXCEEDED")
      VALUE_VIDEO_FETCH_FAILED_FILE_SIZE_EXCEEDED("VIDEO_FETCH_FAILED_FILE_SIZE_EXCEEDED"),
      @SerializedName("VIDEO_FETCH_FAILED_FORBIDDEN")
      VALUE_VIDEO_FETCH_FAILED_FORBIDDEN("VIDEO_FETCH_FAILED_FORBIDDEN"),
      @SerializedName("VIDEO_FETCH_FAILED_LINK_BROKEN")
      VALUE_VIDEO_FETCH_FAILED_LINK_BROKEN("VIDEO_FETCH_FAILED_LINK_BROKEN"),
      @SerializedName("VIDEO_FETCH_FAILED_TIMED_OUT")
      VALUE_VIDEO_FETCH_FAILED_TIMED_OUT("VIDEO_FETCH_FAILED_TIMED_OUT"),
      @SerializedName("VIDEO_NOT_DOWNLOADABLE")
      VALUE_VIDEO_NOT_DOWNLOADABLE("VIDEO_NOT_DOWNLOADABLE"),
      @SerializedName("WHATSAPP_DISABLED_BY_USER")
      VALUE_WHATSAPP_DISABLED_BY_USER("WHATSAPP_DISABLED_BY_USER"),
      @SerializedName("WHATSAPP_POLICY_VIOLATION")
      VALUE_WHATSAPP_POLICY_VIOLATION("WHATSAPP_POLICY_VIOLATION"),
      ;

      private String value;

      private EnumErrorType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMarkedForProductLaunch {
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      @SerializedName("marked")
      VALUE_MARKED("marked"),
      @SerializedName("not_marked")
      VALUE_NOT_MARKED("not_marked"),
      ;

      private String value;

      private EnumMarkedForProductLaunch(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginCountry {
      @SerializedName("AD")
      VALUE_AD("AD"),
      @SerializedName("AE")
      VALUE_AE("AE"),
      @SerializedName("AF")
      VALUE_AF("AF"),
      @SerializedName("AG")
      VALUE_AG("AG"),
      @SerializedName("AI")
      VALUE_AI("AI"),
      @SerializedName("AL")
      VALUE_AL("AL"),
      @SerializedName("AM")
      VALUE_AM("AM"),
      @SerializedName("AN")
      VALUE_AN("AN"),
      @SerializedName("AO")
      VALUE_AO("AO"),
      @SerializedName("AQ")
      VALUE_AQ("AQ"),
      @SerializedName("AR")
      VALUE_AR("AR"),
      @SerializedName("AS")
      VALUE_AS("AS"),
      @SerializedName("AT")
      VALUE_AT("AT"),
      @SerializedName("AU")
      VALUE_AU("AU"),
      @SerializedName("AW")
      VALUE_AW("AW"),
      @SerializedName("AX")
      VALUE_AX("AX"),
      @SerializedName("AZ")
      VALUE_AZ("AZ"),
      @SerializedName("BA")
      VALUE_BA("BA"),
      @SerializedName("BB")
      VALUE_BB("BB"),
      @SerializedName("BD")
      VALUE_BD("BD"),
      @SerializedName("BE")
      VALUE_BE("BE"),
      @SerializedName("BF")
      VALUE_BF("BF"),
      @SerializedName("BG")
      VALUE_BG("BG"),
      @SerializedName("BH")
      VALUE_BH("BH"),
      @SerializedName("BI")
      VALUE_BI("BI"),
      @SerializedName("BJ")
      VALUE_BJ("BJ"),
      @SerializedName("BL")
      VALUE_BL("BL"),
      @SerializedName("BM")
      VALUE_BM("BM"),
      @SerializedName("BN")
      VALUE_BN("BN"),
      @SerializedName("BO")
      VALUE_BO("BO"),
      @SerializedName("BQ")
      VALUE_BQ("BQ"),
      @SerializedName("BR")
      VALUE_BR("BR"),
      @SerializedName("BS")
      VALUE_BS("BS"),
      @SerializedName("BT")
      VALUE_BT("BT"),
      @SerializedName("BV")
      VALUE_BV("BV"),
      @SerializedName("BW")
      VALUE_BW("BW"),
      @SerializedName("BY")
      VALUE_BY("BY"),
      @SerializedName("BZ")
      VALUE_BZ("BZ"),
      @SerializedName("CA")
      VALUE_CA("CA"),
      @SerializedName("CC")
      VALUE_CC("CC"),
      @SerializedName("CD")
      VALUE_CD("CD"),
      @SerializedName("CF")
      VALUE_CF("CF"),
      @SerializedName("CG")
      VALUE_CG("CG"),
      @SerializedName("CH")
      VALUE_CH("CH"),
      @SerializedName("CI")
      VALUE_CI("CI"),
      @SerializedName("CK")
      VALUE_CK("CK"),
      @SerializedName("CL")
      VALUE_CL("CL"),
      @SerializedName("CM")
      VALUE_CM("CM"),
      @SerializedName("CN")
      VALUE_CN("CN"),
      @SerializedName("CO")
      VALUE_CO("CO"),
      @SerializedName("CR")
      VALUE_CR("CR"),
      @SerializedName("CU")
      VALUE_CU("CU"),
      @SerializedName("CV")
      VALUE_CV("CV"),
      @SerializedName("CW")
      VALUE_CW("CW"),
      @SerializedName("CX")
      VALUE_CX("CX"),
      @SerializedName("CY")
      VALUE_CY("CY"),
      @SerializedName("CZ")
      VALUE_CZ("CZ"),
      @SerializedName("DE")
      VALUE_DE("DE"),
      @SerializedName("DJ")
      VALUE_DJ("DJ"),
      @SerializedName("DK")
      VALUE_DK("DK"),
      @SerializedName("DM")
      VALUE_DM("DM"),
      @SerializedName("DO")
      VALUE_DO("DO"),
      @SerializedName("DZ")
      VALUE_DZ("DZ"),
      @SerializedName("EC")
      VALUE_EC("EC"),
      @SerializedName("EE")
      VALUE_EE("EE"),
      @SerializedName("EG")
      VALUE_EG("EG"),
      @SerializedName("EH")
      VALUE_EH("EH"),
      @SerializedName("ER")
      VALUE_ER("ER"),
      @SerializedName("ES")
      VALUE_ES("ES"),
      @SerializedName("ET")
      VALUE_ET("ET"),
      @SerializedName("FI")
      VALUE_FI("FI"),
      @SerializedName("FJ")
      VALUE_FJ("FJ"),
      @SerializedName("FK")
      VALUE_FK("FK"),
      @SerializedName("FM")
      VALUE_FM("FM"),
      @SerializedName("FO")
      VALUE_FO("FO"),
      @SerializedName("FR")
      VALUE_FR("FR"),
      @SerializedName("GA")
      VALUE_GA("GA"),
      @SerializedName("GB")
      VALUE_GB("GB"),
      @SerializedName("GD")
      VALUE_GD("GD"),
      @SerializedName("GE")
      VALUE_GE("GE"),
      @SerializedName("GF")
      VALUE_GF("GF"),
      @SerializedName("GG")
      VALUE_GG("GG"),
      @SerializedName("GH")
      VALUE_GH("GH"),
      @SerializedName("GI")
      VALUE_GI("GI"),
      @SerializedName("GL")
      VALUE_GL("GL"),
      @SerializedName("GM")
      VALUE_GM("GM"),
      @SerializedName("GN")
      VALUE_GN("GN"),
      @SerializedName("GP")
      VALUE_GP("GP"),
      @SerializedName("GQ")
      VALUE_GQ("GQ"),
      @SerializedName("GR")
      VALUE_GR("GR"),
      @SerializedName("GS")
      VALUE_GS("GS"),
      @SerializedName("GT")
      VALUE_GT("GT"),
      @SerializedName("GU")
      VALUE_GU("GU"),
      @SerializedName("GW")
      VALUE_GW("GW"),
      @SerializedName("GY")
      VALUE_GY("GY"),
      @SerializedName("HK")
      VALUE_HK("HK"),
      @SerializedName("HM")
      VALUE_HM("HM"),
      @SerializedName("HN")
      VALUE_HN("HN"),
      @SerializedName("HR")
      VALUE_HR("HR"),
      @SerializedName("HT")
      VALUE_HT("HT"),
      @SerializedName("HU")
      VALUE_HU("HU"),
      @SerializedName("ID")
      VALUE_ID("ID"),
      @SerializedName("IE")
      VALUE_IE("IE"),
      @SerializedName("IL")
      VALUE_IL("IL"),
      @SerializedName("IM")
      VALUE_IM("IM"),
      @SerializedName("IN")
      VALUE_IN("IN"),
      @SerializedName("IO")
      VALUE_IO("IO"),
      @SerializedName("IQ")
      VALUE_IQ("IQ"),
      @SerializedName("IR")
      VALUE_IR("IR"),
      @SerializedName("IS")
      VALUE_IS("IS"),
      @SerializedName("IT")
      VALUE_IT("IT"),
      @SerializedName("JE")
      VALUE_JE("JE"),
      @SerializedName("JM")
      VALUE_JM("JM"),
      @SerializedName("JO")
      VALUE_JO("JO"),
      @SerializedName("JP")
      VALUE_JP("JP"),
      @SerializedName("KE")
      VALUE_KE("KE"),
      @SerializedName("KG")
      VALUE_KG("KG"),
      @SerializedName("KH")
      VALUE_KH("KH"),
      @SerializedName("KI")
      VALUE_KI("KI"),
      @SerializedName("KM")
      VALUE_KM("KM"),
      @SerializedName("KN")
      VALUE_KN("KN"),
      @SerializedName("KP")
      VALUE_KP("KP"),
      @SerializedName("KR")
      VALUE_KR("KR"),
      @SerializedName("KW")
      VALUE_KW("KW"),
      @SerializedName("KY")
      VALUE_KY("KY"),
      @SerializedName("KZ")
      VALUE_KZ("KZ"),
      @SerializedName("LA")
      VALUE_LA("LA"),
      @SerializedName("LB")
      VALUE_LB("LB"),
      @SerializedName("LC")
      VALUE_LC("LC"),
      @SerializedName("LI")
      VALUE_LI("LI"),
      @SerializedName("LK")
      VALUE_LK("LK"),
      @SerializedName("LR")
      VALUE_LR("LR"),
      @SerializedName("LS")
      VALUE_LS("LS"),
      @SerializedName("LT")
      VALUE_LT("LT"),
      @SerializedName("LU")
      VALUE_LU("LU"),
      @SerializedName("LV")
      VALUE_LV("LV"),
      @SerializedName("LY")
      VALUE_LY("LY"),
      @SerializedName("MA")
      VALUE_MA("MA"),
      @SerializedName("MC")
      VALUE_MC("MC"),
      @SerializedName("MD")
      VALUE_MD("MD"),
      @SerializedName("ME")
      VALUE_ME("ME"),
      @SerializedName("MF")
      VALUE_MF("MF"),
      @SerializedName("MG")
      VALUE_MG("MG"),
      @SerializedName("MH")
      VALUE_MH("MH"),
      @SerializedName("MK")
      VALUE_MK("MK"),
      @SerializedName("ML")
      VALUE_ML("ML"),
      @SerializedName("MM")
      VALUE_MM("MM"),
      @SerializedName("MN")
      VALUE_MN("MN"),
      @SerializedName("MO")
      VALUE_MO("MO"),
      @SerializedName("MP")
      VALUE_MP("MP"),
      @SerializedName("MQ")
      VALUE_MQ("MQ"),
      @SerializedName("MR")
      VALUE_MR("MR"),
      @SerializedName("MS")
      VALUE_MS("MS"),
      @SerializedName("MT")
      VALUE_MT("MT"),
      @SerializedName("MU")
      VALUE_MU("MU"),
      @SerializedName("MV")
      VALUE_MV("MV"),
      @SerializedName("MW")
      VALUE_MW("MW"),
      @SerializedName("MX")
      VALUE_MX("MX"),
      @SerializedName("MY")
      VALUE_MY("MY"),
      @SerializedName("MZ")
      VALUE_MZ("MZ"),
      @SerializedName("NA")
      VALUE_NA("NA"),
      @SerializedName("NC")
      VALUE_NC("NC"),
      @SerializedName("NE")
      VALUE_NE("NE"),
      @SerializedName("NF")
      VALUE_NF("NF"),
      @SerializedName("NG")
      VALUE_NG("NG"),
      @SerializedName("NI")
      VALUE_NI("NI"),
      @SerializedName("NL")
      VALUE_NL("NL"),
      @SerializedName("NO")
      VALUE_NO("NO"),
      @SerializedName("NP")
      VALUE_NP("NP"),
      @SerializedName("NR")
      VALUE_NR("NR"),
      @SerializedName("NU")
      VALUE_NU("NU"),
      @SerializedName("NZ")
      VALUE_NZ("NZ"),
      @SerializedName("OM")
      VALUE_OM("OM"),
      @SerializedName("PA")
      VALUE_PA("PA"),
      @SerializedName("PE")
      VALUE_PE("PE"),
      @SerializedName("PF")
      VALUE_PF("PF"),
      @SerializedName("PG")
      VALUE_PG("PG"),
      @SerializedName("PH")
      VALUE_PH("PH"),
      @SerializedName("PK")
      VALUE_PK("PK"),
      @SerializedName("PL")
      VALUE_PL("PL"),
      @SerializedName("PM")
      VALUE_PM("PM"),
      @SerializedName("PN")
      VALUE_PN("PN"),
      @SerializedName("PR")
      VALUE_PR("PR"),
      @SerializedName("PS")
      VALUE_PS("PS"),
      @SerializedName("PT")
      VALUE_PT("PT"),
      @SerializedName("PW")
      VALUE_PW("PW"),
      @SerializedName("PY")
      VALUE_PY("PY"),
      @SerializedName("QA")
      VALUE_QA("QA"),
      @SerializedName("RE")
      VALUE_RE("RE"),
      @SerializedName("RO")
      VALUE_RO("RO"),
      @SerializedName("RS")
      VALUE_RS("RS"),
      @SerializedName("RU")
      VALUE_RU("RU"),
      @SerializedName("RW")
      VALUE_RW("RW"),
      @SerializedName("SA")
      VALUE_SA("SA"),
      @SerializedName("SB")
      VALUE_SB("SB"),
      @SerializedName("SC")
      VALUE_SC("SC"),
      @SerializedName("SD")
      VALUE_SD("SD"),
      @SerializedName("SE")
      VALUE_SE("SE"),
      @SerializedName("SG")
      VALUE_SG("SG"),
      @SerializedName("SH")
      VALUE_SH("SH"),
      @SerializedName("SI")
      VALUE_SI("SI"),
      @SerializedName("SJ")
      VALUE_SJ("SJ"),
      @SerializedName("SK")
      VALUE_SK("SK"),
      @SerializedName("SL")
      VALUE_SL("SL"),
      @SerializedName("SM")
      VALUE_SM("SM"),
      @SerializedName("SN")
      VALUE_SN("SN"),
      @SerializedName("SO")
      VALUE_SO("SO"),
      @SerializedName("SR")
      VALUE_SR("SR"),
      @SerializedName("SS")
      VALUE_SS("SS"),
      @SerializedName("ST")
      VALUE_ST("ST"),
      @SerializedName("SV")
      VALUE_SV("SV"),
      @SerializedName("SX")
      VALUE_SX("SX"),
      @SerializedName("SY")
      VALUE_SY("SY"),
      @SerializedName("SZ")
      VALUE_SZ("SZ"),
      @SerializedName("TC")
      VALUE_TC("TC"),
      @SerializedName("TD")
      VALUE_TD("TD"),
      @SerializedName("TF")
      VALUE_TF("TF"),
      @SerializedName("TG")
      VALUE_TG("TG"),
      @SerializedName("TH")
      VALUE_TH("TH"),
      @SerializedName("TJ")
      VALUE_TJ("TJ"),
      @SerializedName("TK")
      VALUE_TK("TK"),
      @SerializedName("TL")
      VALUE_TL("TL"),
      @SerializedName("TM")
      VALUE_TM("TM"),
      @SerializedName("TN")
      VALUE_TN("TN"),
      @SerializedName("TO")
      VALUE_TO("TO"),
      @SerializedName("TR")
      VALUE_TR("TR"),
      @SerializedName("TT")
      VALUE_TT("TT"),
      @SerializedName("TV")
      VALUE_TV("TV"),
      @SerializedName("TW")
      VALUE_TW("TW"),
      @SerializedName("TZ")
      VALUE_TZ("TZ"),
      @SerializedName("UA")
      VALUE_UA("UA"),
      @SerializedName("UG")
      VALUE_UG("UG"),
      @SerializedName("UM")
      VALUE_UM("UM"),
      @SerializedName("US")
      VALUE_US("US"),
      @SerializedName("UY")
      VALUE_UY("UY"),
      @SerializedName("UZ")
      VALUE_UZ("UZ"),
      @SerializedName("VA")
      VALUE_VA("VA"),
      @SerializedName("VC")
      VALUE_VC("VC"),
      @SerializedName("VE")
      VALUE_VE("VE"),
      @SerializedName("VG")
      VALUE_VG("VG"),
      @SerializedName("VI")
      VALUE_VI("VI"),
      @SerializedName("VN")
      VALUE_VN("VN"),
      @SerializedName("VU")
      VALUE_VU("VU"),
      @SerializedName("WF")
      VALUE_WF("WF"),
      @SerializedName("WS")
      VALUE_WS("WS"),
      @SerializedName("XK")
      VALUE_XK("XK"),
      @SerializedName("YE")
      VALUE_YE("YE"),
      @SerializedName("YT")
      VALUE_YT("YT"),
      @SerializedName("ZA")
      VALUE_ZA("ZA"),
      @SerializedName("ZM")
      VALUE_ZM("ZM"),
      @SerializedName("ZW")
      VALUE_ZW("ZW"),
      ;

      private String value;

      private EnumOriginCountry(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumWaComplianceCategory {
      @SerializedName("COUNTRY_ORIGIN_EXEMPT")
      VALUE_COUNTRY_ORIGIN_EXEMPT("COUNTRY_ORIGIN_EXEMPT"),
      @SerializedName("DEFAULT")
      VALUE_DEFAULT("DEFAULT"),
      ;

      private String value;

      private EnumWaComplianceCategory(String value) {
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
    this.mAdditionalImageCdnUrls = instance.mAdditionalImageCdnUrls;
    this.mAdditionalImageUrls = instance.mAdditionalImageUrls;
    this.mAdditionalVariantAttributes = instance.mAdditionalVariantAttributes;
    this.mAgeGroup = instance.mAgeGroup;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBrand = instance.mBrand;
    this.mCapabilityToReviewStatus = instance.mCapabilityToReviewStatus;
    this.mCategory = instance.mCategory;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mColor = instance.mColor;
    this.mCommerceInsights = instance.mCommerceInsights;
    this.mCondition = instance.mCondition;
    this.mCurrency = instance.mCurrency;
    this.mCustomData = instance.mCustomData;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mCustomLabel1 = instance.mCustomLabel1;
    this.mCustomLabel2 = instance.mCustomLabel2;
    this.mCustomLabel3 = instance.mCustomLabel3;
    this.mCustomLabel4 = instance.mCustomLabel4;
    this.mCustomNumber0 = instance.mCustomNumber0;
    this.mCustomNumber1 = instance.mCustomNumber1;
    this.mCustomNumber2 = instance.mCustomNumber2;
    this.mCustomNumber3 = instance.mCustomNumber3;
    this.mCustomNumber4 = instance.mCustomNumber4;
    this.mDescription = instance.mDescription;
    this.mErrors = instance.mErrors;
    this.mExpirationDate = instance.mExpirationDate;
    this.mFbProductCategory = instance.mFbProductCategory;
    this.mGender = instance.mGender;
    this.mGtin = instance.mGtin;
    this.mId = instance.mId;
    this.mImageCdnUrls = instance.mImageCdnUrls;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImageUrl = instance.mImageUrl;
    this.mImages = instance.mImages;
    this.mImporterAddress = instance.mImporterAddress;
    this.mImporterName = instance.mImporterName;
    this.mInvalidationErrors = instance.mInvalidationErrors;
    this.mInventory = instance.mInventory;
    this.mManufacturerInfo = instance.mManufacturerInfo;
    this.mManufacturerPartNumber = instance.mManufacturerPartNumber;
    this.mMarkedForProductLaunch = instance.mMarkedForProductLaunch;
    this.mMaterial = instance.mMaterial;
    this.mMobileLink = instance.mMobileLink;
    this.mName = instance.mName;
    this.mOrderingIndex = instance.mOrderingIndex;
    this.mOriginCountry = instance.mOriginCountry;
    this.mParentProductId = instance.mParentProductId;
    this.mPattern = instance.mPattern;
    this.mPostConversionSignalBasedEnforcementAppealEligibility = instance.mPostConversionSignalBasedEnforcementAppealEligibility;
    this.mPrice = instance.mPrice;
    this.mProductCatalog = instance.mProductCatalog;
    this.mProductFeed = instance.mProductFeed;
    this.mProductGroup = instance.mProductGroup;
    this.mProductLocalInfo = instance.mProductLocalInfo;
    this.mProductType = instance.mProductType;
    this.mQuantityToSellOnFacebook = instance.mQuantityToSellOnFacebook;
    this.mRetailerId = instance.mRetailerId;
    this.mRetailerProductGroupId = instance.mRetailerProductGroupId;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mReviewStatus = instance.mReviewStatus;
    this.mSalePrice = instance.mSalePrice;
    this.mSalePriceEndDate = instance.mSalePriceEndDate;
    this.mSalePriceStartDate = instance.mSalePriceStartDate;
    this.mShippingWeightUnit = instance.mShippingWeightUnit;
    this.mShippingWeightValue = instance.mShippingWeightValue;
    this.mShortDescription = instance.mShortDescription;
    this.mSize = instance.mSize;
    this.mStartDate = instance.mStartDate;
    this.mTags = instance.mTags;
    this.mUrl = instance.mUrl;
    this.mVideoFetchStatus = instance.mVideoFetchStatus;
    this.mVisibility = instance.mVisibility;
    this.mWaComplianceCategory = instance.mWaComplianceCategory;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItem> getParser() {
    return new APIRequest.ResponseParser<ProductItem>() {
      public APINodeList<ProductItem> parseResponse(String response, APIContext context, APIRequest<ProductItem> request, String header) throws MalformedResponseException {
        return ProductItem.parseResponse(response, context, request, header);
      }
    };
  }
}
