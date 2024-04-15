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
public class LocalServiceBusiness extends APINode {
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("availability")
  private EnumAvailability mAvailability = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("condition")
  private EnumCondition mCondition = null;
  @SerializedName("cuisine_type")
  private String mCuisineType = null;
  @SerializedName("currency")
  private String mCurrency = null;
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
  private Long mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private Long mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private Long mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private Long mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private Long mCustomNumber4 = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("expiration_date")
  private String mExpirationDate = null;
  @SerializedName("gtin")
  private String mGtin = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("local_info")
  private ProductItemLocalInfo mLocalInfo = null;
  @SerializedName("local_service_business_id")
  private String mLocalServiceBusinessId = null;
  @SerializedName("main_local_info")
  private ProductItemLocalInfo mMainLocalInfo = null;
  @SerializedName("phone")
  private String mPhone = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("price_range")
  private String mPriceRange = null;
  @SerializedName("retailer_category")
  private String mRetailerCategory = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("vendor_id")
  private String mVendorId = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  protected static Gson gson = null;

  LocalServiceBusiness() {
  }

  public LocalServiceBusiness(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LocalServiceBusiness(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LocalServiceBusiness fetch() throws APIException{
    LocalServiceBusiness newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LocalServiceBusiness fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LocalServiceBusiness> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LocalServiceBusiness fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LocalServiceBusiness> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LocalServiceBusiness> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LocalServiceBusiness>)(
      new APIRequest<LocalServiceBusiness>(context, "", "/", "GET", LocalServiceBusiness.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LocalServiceBusiness>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LocalServiceBusiness.getParser())
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
  public static LocalServiceBusiness loadJSON(String json, APIContext context, String header) {
    LocalServiceBusiness localServiceBusiness = getGson().fromJson(json, LocalServiceBusiness.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(localServiceBusiness.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    localServiceBusiness.context = context;
    localServiceBusiness.rawValue = json;
    localServiceBusiness.header = header;
    return localServiceBusiness;
  }

  public static APINodeList<LocalServiceBusiness> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LocalServiceBusiness> localServiceBusinesss = new APINodeList<LocalServiceBusiness>(request, json, header);
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
          localServiceBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return localServiceBusinesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                localServiceBusinesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            localServiceBusinesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              localServiceBusinesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              localServiceBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  localServiceBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              localServiceBusinesss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return localServiceBusinesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              localServiceBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return localServiceBusinesss;
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
              localServiceBusinesss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return localServiceBusinesss;
          }

          // Sixth, check if it's pure JsonObject
          localServiceBusinesss.clear();
          localServiceBusinesss.add(loadJSON(json, context, header));
          return localServiceBusinesss;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAddress() {
    return mAddress;
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

  public String getFieldCategory() {
    return mCategory;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public EnumCondition getFieldCondition() {
    return mCondition;
  }

  public String getFieldCuisineType() {
    return mCuisineType;
  }

  public String getFieldCurrency() {
    return mCurrency;
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

  public Long getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public Long getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public Long getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public Long getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public Long getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldExpirationDate() {
    return mExpirationDate;
  }

  public String getFieldGtin() {
    return mGtin;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public ProductItemLocalInfo getFieldLocalInfo() {
    if (mLocalInfo != null) {
      mLocalInfo.context = getContext();
    }
    return mLocalInfo;
  }

  public String getFieldLocalServiceBusinessId() {
    return mLocalServiceBusinessId;
  }

  public ProductItemLocalInfo getFieldMainLocalInfo() {
    if (mMainLocalInfo != null) {
      mMainLocalInfo.context = getContext();
    }
    return mMainLocalInfo;
  }

  public String getFieldPhone() {
    return mPhone;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public String getFieldPriceRange() {
    return mPriceRange;
  }

  public String getFieldRetailerCategory() {
    return mRetailerCategory;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldSize() {
    return mSize;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldVendorId() {
    return mVendorId;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
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

  public static class APIRequestGet extends APIRequest<LocalServiceBusiness> {

    LocalServiceBusiness lastResponse = null;
    @Override
    public LocalServiceBusiness getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "availability",
      "brand",
      "category",
      "category_specific_fields",
      "condition",
      "cuisine_type",
      "currency",
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
      "gtin",
      "id",
      "image_fetch_status",
      "images",
      "local_info",
      "local_service_business_id",
      "main_local_info",
      "phone",
      "price",
      "price_range",
      "retailer_category",
      "sanitized_images",
      "size",
      "tags",
      "title",
      "unit_price",
      "url",
      "vendor_id",
      "visibility",
    };

    @Override
    public LocalServiceBusiness parseResponse(String response, String header) throws APIException {
      return LocalServiceBusiness.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LocalServiceBusiness execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LocalServiceBusiness execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LocalServiceBusiness> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LocalServiceBusiness> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LocalServiceBusiness>() {
           public LocalServiceBusiness apply(ResponseWrapper result) {
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

    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
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
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGet requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGet requestCuisineTypeField () {
      return this.requestCuisineTypeField(true);
    }
    public APIRequestGet requestCuisineTypeField (boolean value) {
      this.requestField("cuisine_type", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
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
    public APIRequestGet requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGet requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
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
    public APIRequestGet requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGet requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestLocalInfoField () {
      return this.requestLocalInfoField(true);
    }
    public APIRequestGet requestLocalInfoField (boolean value) {
      this.requestField("local_info", value);
      return this;
    }
    public APIRequestGet requestLocalServiceBusinessIdField () {
      return this.requestLocalServiceBusinessIdField(true);
    }
    public APIRequestGet requestLocalServiceBusinessIdField (boolean value) {
      this.requestField("local_service_business_id", value);
      return this;
    }
    public APIRequestGet requestMainLocalInfoField () {
      return this.requestMainLocalInfoField(true);
    }
    public APIRequestGet requestMainLocalInfoField (boolean value) {
      this.requestField("main_local_info", value);
      return this;
    }
    public APIRequestGet requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGet requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGet requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGet requestRetailerCategoryField () {
      return this.requestRetailerCategoryField(true);
    }
    public APIRequestGet requestRetailerCategoryField (boolean value) {
      this.requestField("retailer_category", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGet requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGet requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVendorIdField () {
      return this.requestVendorIdField(true);
    }
    public APIRequestGet requestVendorIdField (boolean value) {
      this.requestField("vendor_id", value);
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

  public static enum EnumAvailability {
      @SerializedName("AVAILABLE_FOR_ORDER")
      VALUE_AVAILABLE_FOR_ORDER("AVAILABLE_FOR_ORDER"),
      @SerializedName("DISCONTINUED")
      VALUE_DISCONTINUED("DISCONTINUED"),
      @SerializedName("IN_STOCK")
      VALUE_IN_STOCK("IN_STOCK"),
      @SerializedName("MARK_AS_SOLD")
      VALUE_MARK_AS_SOLD("MARK_AS_SOLD"),
      @SerializedName("OUT_OF_STOCK")
      VALUE_OUT_OF_STOCK("OUT_OF_STOCK"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("PREORDER")
      VALUE_PREORDER("PREORDER"),
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
      @SerializedName("PC_CPO")
      VALUE_PC_CPO("PC_CPO"),
      @SerializedName("PC_NEW")
      VALUE_PC_NEW("PC_NEW"),
      @SerializedName("PC_OPEN_BOX_NEW")
      VALUE_PC_OPEN_BOX_NEW("PC_OPEN_BOX_NEW"),
      @SerializedName("PC_REFURBISHED")
      VALUE_PC_REFURBISHED("PC_REFURBISHED"),
      @SerializedName("PC_USED")
      VALUE_PC_USED("PC_USED"),
      @SerializedName("PC_USED_FAIR")
      VALUE_PC_USED_FAIR("PC_USED_FAIR"),
      @SerializedName("PC_USED_GOOD")
      VALUE_PC_USED_GOOD("PC_USED_GOOD"),
      @SerializedName("PC_USED_LIKE_NEW")
      VALUE_PC_USED_LIKE_NEW("PC_USED_LIKE_NEW"),
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

  public static enum EnumVisibility {
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      @SerializedName("STAGING")
      VALUE_STAGING("STAGING"),
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

  public LocalServiceBusiness copyFrom(LocalServiceBusiness instance) {
    this.mAddress = instance.mAddress;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBrand = instance.mBrand;
    this.mCategory = instance.mCategory;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCondition = instance.mCondition;
    this.mCuisineType = instance.mCuisineType;
    this.mCurrency = instance.mCurrency;
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
    this.mExpirationDate = instance.mExpirationDate;
    this.mGtin = instance.mGtin;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mLocalInfo = instance.mLocalInfo;
    this.mLocalServiceBusinessId = instance.mLocalServiceBusinessId;
    this.mMainLocalInfo = instance.mMainLocalInfo;
    this.mPhone = instance.mPhone;
    this.mPrice = instance.mPrice;
    this.mPriceRange = instance.mPriceRange;
    this.mRetailerCategory = instance.mRetailerCategory;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mSize = instance.mSize;
    this.mTags = instance.mTags;
    this.mTitle = instance.mTitle;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVendorId = instance.mVendorId;
    this.mVisibility = instance.mVisibility;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LocalServiceBusiness> getParser() {
    return new APIRequest.ResponseParser<LocalServiceBusiness>() {
      public APINodeList<LocalServiceBusiness> parseResponse(String response, APIContext context, APIRequest<LocalServiceBusiness> request, String header) throws MalformedResponseException {
        return LocalServiceBusiness.parseResponse(response, context, request, header);
      }
    };
  }
}
