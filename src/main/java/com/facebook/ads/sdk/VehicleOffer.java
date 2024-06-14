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
public class VehicleOffer extends APINode {
  @SerializedName("amount_currency")
  private String mAmountCurrency = null;
  @SerializedName("amount_percentage")
  private Double mAmountPercentage = null;
  @SerializedName("amount_price")
  private String mAmountPrice = null;
  @SerializedName("amount_qualifier")
  private String mAmountQualifier = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("body_style")
  private String mBodyStyle = null;
  @SerializedName("cashback_currency")
  private String mCashbackCurrency = null;
  @SerializedName("cashback_price")
  private String mCashbackPrice = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("dma_codes")
  private List<String> mDmaCodes = null;
  @SerializedName("downpayment_currency")
  private String mDownpaymentCurrency = null;
  @SerializedName("downpayment_price")
  private String mDownpaymentPrice = null;
  @SerializedName("downpayment_qualifier")
  private String mDownpaymentQualifier = null;
  @SerializedName("drivetrain")
  private String mDrivetrain = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("end_time")
  private Long mEndTime = null;
  @SerializedName("exterior_color")
  private String mExteriorColor = null;
  @SerializedName("fuel_type")
  private String mFuelType = null;
  @SerializedName("generation")
  private String mGeneration = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("interior_color")
  private String mInteriorColor = null;
  @SerializedName("interior_upholstery")
  private String mInteriorUpholstery = null;
  @SerializedName("make")
  private String mMake = null;
  @SerializedName("model")
  private String mModel = null;
  @SerializedName("offer_description")
  private String mOfferDescription = null;
  @SerializedName("offer_disclaimer")
  private String mOfferDisclaimer = null;
  @SerializedName("offer_type")
  private String mOfferType = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("start_time")
  private Long mStartTime = null;
  @SerializedName("term_length")
  private Long mTermLength = null;
  @SerializedName("term_qualifier")
  private String mTermQualifier = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("transmission")
  private String mTransmission = null;
  @SerializedName("trim")
  private String mTrim = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("vehicle_offer_id")
  private String mVehicleOfferId = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("year")
  private Long mYear = null;
  protected static Gson gson = null;

  VehicleOffer() {
  }

  public VehicleOffer(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VehicleOffer(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VehicleOffer fetch() throws APIException{
    VehicleOffer newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VehicleOffer fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VehicleOffer> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VehicleOffer fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VehicleOffer> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VehicleOffer> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VehicleOffer>)(
      new APIRequest<VehicleOffer>(context, "", "/", "GET", VehicleOffer.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VehicleOffer>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VehicleOffer.getParser())
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
  public static VehicleOffer loadJSON(String json, APIContext context, String header) {
    VehicleOffer vehicleOffer = getGson().fromJson(json, VehicleOffer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(vehicleOffer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    vehicleOffer.context = context;
    vehicleOffer.rawValue = json;
    vehicleOffer.header = header;
    return vehicleOffer;
  }

  public static APINodeList<VehicleOffer> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VehicleOffer> vehicleOffers = new APINodeList<VehicleOffer>(request, json, header);
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
          vehicleOffers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return vehicleOffers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                vehicleOffers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            vehicleOffers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              vehicleOffers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              vehicleOffers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  vehicleOffers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              vehicleOffers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return vehicleOffers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              vehicleOffers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return vehicleOffers;
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
              vehicleOffers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return vehicleOffers;
          }

          // Sixth, check if it's pure JsonObject
          vehicleOffers.clear();
          vehicleOffers.add(loadJSON(json, context, header));
          return vehicleOffers;
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

  public APIRequestGetAugmentedRealitiesMetadata getAugmentedRealitiesMetadata() {
    return new APIRequestGetAugmentedRealitiesMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetChannelsToIntegrityStatus getChannelsToIntegrityStatus() {
    return new APIRequestGetChannelsToIntegrityStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideosMetadata getVideosMetadata() {
    return new APIRequestGetVideosMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAmountCurrency() {
    return mAmountCurrency;
  }

  public Double getFieldAmountPercentage() {
    return mAmountPercentage;
  }

  public String getFieldAmountPrice() {
    return mAmountPrice;
  }

  public String getFieldAmountQualifier() {
    return mAmountQualifier;
  }

  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public String getFieldAvailability() {
    return mAvailability;
  }

  public String getFieldBodyStyle() {
    return mBodyStyle;
  }

  public String getFieldCashbackCurrency() {
    return mCashbackCurrency;
  }

  public String getFieldCashbackPrice() {
    return mCashbackPrice;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public List<String> getFieldDmaCodes() {
    return mDmaCodes;
  }

  public String getFieldDownpaymentCurrency() {
    return mDownpaymentCurrency;
  }

  public String getFieldDownpaymentPrice() {
    return mDownpaymentPrice;
  }

  public String getFieldDownpaymentQualifier() {
    return mDownpaymentQualifier;
  }

  public String getFieldDrivetrain() {
    return mDrivetrain;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public Long getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldExteriorColor() {
    return mExteriorColor;
  }

  public String getFieldFuelType() {
    return mFuelType;
  }

  public String getFieldGeneration() {
    return mGeneration;
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

  public String getFieldInteriorColor() {
    return mInteriorColor;
  }

  public String getFieldInteriorUpholstery() {
    return mInteriorUpholstery;
  }

  public String getFieldMake() {
    return mMake;
  }

  public String getFieldModel() {
    return mModel;
  }

  public String getFieldOfferDescription() {
    return mOfferDescription;
  }

  public String getFieldOfferDisclaimer() {
    return mOfferDisclaimer;
  }

  public String getFieldOfferType() {
    return mOfferType;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public Long getFieldStartTime() {
    return mStartTime;
  }

  public Long getFieldTermLength() {
    return mTermLength;
  }

  public String getFieldTermQualifier() {
    return mTermQualifier;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTransmission() {
    return mTransmission;
  }

  public String getFieldTrim() {
    return mTrim;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldVehicleOfferId() {
    return mVehicleOfferId;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }

  public Long getFieldYear() {
    return mYear;
  }



  public static class APIRequestGetAugmentedRealitiesMetadata extends APIRequest<DynamicARMetadata> {

    APINodeList<DynamicARMetadata> lastResponse = null;
    @Override
    public APINodeList<DynamicARMetadata> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "anchor_point",
      "container_effect_enum",
      "effect_icon_url",
      "effect_id",
      "id",
      "platforms",
      "scale_factor",
      "shadow_texture_url",
      "source_url",
      "state",
      "tags",
      "variant_picker_url",
    };

    @Override
    public APINodeList<DynamicARMetadata> parseResponse(String response, String header) throws APIException {
      return DynamicARMetadata.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicARMetadata> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicARMetadata> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicARMetadata>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicARMetadata>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicARMetadata>>() {
           public APINodeList<DynamicARMetadata> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAugmentedRealitiesMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAugmentedRealitiesMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/augmented_realities_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAugmentedRealitiesMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAugmentedRealitiesMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAugmentedRealitiesMetadata requestAnchorPointField () {
      return this.requestAnchorPointField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestAnchorPointField (boolean value) {
      this.requestField("anchor_point", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestContainerEffectEnumField () {
      return this.requestContainerEffectEnumField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestContainerEffectEnumField (boolean value) {
      this.requestField("container_effect_enum", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIconUrlField () {
      return this.requestEffectIconUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIconUrlField (boolean value) {
      this.requestField("effect_icon_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIdField () {
      return this.requestEffectIdField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIdField (boolean value) {
      this.requestField("effect_id", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestPlatformsField () {
      return this.requestPlatformsField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestPlatformsField (boolean value) {
      this.requestField("platforms", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestScaleFactorField () {
      return this.requestScaleFactorField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestScaleFactorField (boolean value) {
      this.requestField("scale_factor", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestShadowTextureUrlField () {
      return this.requestShadowTextureUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestShadowTextureUrlField (boolean value) {
      this.requestField("shadow_texture_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestSourceUrlField () {
      return this.requestSourceUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestSourceUrlField (boolean value) {
      this.requestField("source_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestVariantPickerUrlField () {
      return this.requestVariantPickerUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestVariantPickerUrlField (boolean value) {
      this.requestField("variant_picker_url", value);
      return this;
    }
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

  public static class APIRequestGet extends APIRequest<VehicleOffer> {

    VehicleOffer lastResponse = null;
    @Override
    public VehicleOffer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public VehicleOffer parseResponse(String response, String header) throws APIException {
      return VehicleOffer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VehicleOffer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VehicleOffer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VehicleOffer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VehicleOffer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VehicleOffer>() {
           public VehicleOffer apply(ResponseWrapper result) {
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

    public APIRequestGet requestAmountCurrencyField () {
      return this.requestAmountCurrencyField(true);
    }
    public APIRequestGet requestAmountCurrencyField (boolean value) {
      this.requestField("amount_currency", value);
      return this;
    }
    public APIRequestGet requestAmountPercentageField () {
      return this.requestAmountPercentageField(true);
    }
    public APIRequestGet requestAmountPercentageField (boolean value) {
      this.requestField("amount_percentage", value);
      return this;
    }
    public APIRequestGet requestAmountPriceField () {
      return this.requestAmountPriceField(true);
    }
    public APIRequestGet requestAmountPriceField (boolean value) {
      this.requestField("amount_price", value);
      return this;
    }
    public APIRequestGet requestAmountQualifierField () {
      return this.requestAmountQualifierField(true);
    }
    public APIRequestGet requestAmountQualifierField (boolean value) {
      this.requestField("amount_qualifier", value);
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
    public APIRequestGet requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGet requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGet requestCashbackCurrencyField () {
      return this.requestCashbackCurrencyField(true);
    }
    public APIRequestGet requestCashbackCurrencyField (boolean value) {
      this.requestField("cashback_currency", value);
      return this;
    }
    public APIRequestGet requestCashbackPriceField () {
      return this.requestCashbackPriceField(true);
    }
    public APIRequestGet requestCashbackPriceField (boolean value) {
      this.requestField("cashback_price", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDmaCodesField () {
      return this.requestDmaCodesField(true);
    }
    public APIRequestGet requestDmaCodesField (boolean value) {
      this.requestField("dma_codes", value);
      return this;
    }
    public APIRequestGet requestDownpaymentCurrencyField () {
      return this.requestDownpaymentCurrencyField(true);
    }
    public APIRequestGet requestDownpaymentCurrencyField (boolean value) {
      this.requestField("downpayment_currency", value);
      return this;
    }
    public APIRequestGet requestDownpaymentPriceField () {
      return this.requestDownpaymentPriceField(true);
    }
    public APIRequestGet requestDownpaymentPriceField (boolean value) {
      this.requestField("downpayment_price", value);
      return this;
    }
    public APIRequestGet requestDownpaymentQualifierField () {
      return this.requestDownpaymentQualifierField(true);
    }
    public APIRequestGet requestDownpaymentQualifierField (boolean value) {
      this.requestField("downpayment_qualifier", value);
      return this;
    }
    public APIRequestGet requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGet requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGet requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGet requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGet requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGet requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGet requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGet requestGenerationField () {
      return this.requestGenerationField(true);
    }
    public APIRequestGet requestGenerationField (boolean value) {
      this.requestField("generation", value);
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
    public APIRequestGet requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGet requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGet requestInteriorUpholsteryField () {
      return this.requestInteriorUpholsteryField(true);
    }
    public APIRequestGet requestInteriorUpholsteryField (boolean value) {
      this.requestField("interior_upholstery", value);
      return this;
    }
    public APIRequestGet requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGet requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGet requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGet requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGet requestOfferDescriptionField () {
      return this.requestOfferDescriptionField(true);
    }
    public APIRequestGet requestOfferDescriptionField (boolean value) {
      this.requestField("offer_description", value);
      return this;
    }
    public APIRequestGet requestOfferDisclaimerField () {
      return this.requestOfferDisclaimerField(true);
    }
    public APIRequestGet requestOfferDisclaimerField (boolean value) {
      this.requestField("offer_disclaimer", value);
      return this;
    }
    public APIRequestGet requestOfferTypeField () {
      return this.requestOfferTypeField(true);
    }
    public APIRequestGet requestOfferTypeField (boolean value) {
      this.requestField("offer_type", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTermLengthField () {
      return this.requestTermLengthField(true);
    }
    public APIRequestGet requestTermLengthField (boolean value) {
      this.requestField("term_length", value);
      return this;
    }
    public APIRequestGet requestTermQualifierField () {
      return this.requestTermQualifierField(true);
    }
    public APIRequestGet requestTermQualifierField (boolean value) {
      this.requestField("term_qualifier", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGet requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGet requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGet requestTrimField (boolean value) {
      this.requestField("trim", value);
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
    public APIRequestGet requestVehicleOfferIdField () {
      return this.requestVehicleOfferIdField(true);
    }
    public APIRequestGet requestVehicleOfferIdField (boolean value) {
      this.requestField("vehicle_offer_id", value);
      return this;
    }
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGet requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGet requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
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

  public VehicleOffer copyFrom(VehicleOffer instance) {
    this.mAmountCurrency = instance.mAmountCurrency;
    this.mAmountPercentage = instance.mAmountPercentage;
    this.mAmountPrice = instance.mAmountPrice;
    this.mAmountQualifier = instance.mAmountQualifier;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBodyStyle = instance.mBodyStyle;
    this.mCashbackCurrency = instance.mCashbackCurrency;
    this.mCashbackPrice = instance.mCashbackPrice;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCurrency = instance.mCurrency;
    this.mDmaCodes = instance.mDmaCodes;
    this.mDownpaymentCurrency = instance.mDownpaymentCurrency;
    this.mDownpaymentPrice = instance.mDownpaymentPrice;
    this.mDownpaymentQualifier = instance.mDownpaymentQualifier;
    this.mDrivetrain = instance.mDrivetrain;
    this.mEndDate = instance.mEndDate;
    this.mEndTime = instance.mEndTime;
    this.mExteriorColor = instance.mExteriorColor;
    this.mFuelType = instance.mFuelType;
    this.mGeneration = instance.mGeneration;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mInteriorColor = instance.mInteriorColor;
    this.mInteriorUpholstery = instance.mInteriorUpholstery;
    this.mMake = instance.mMake;
    this.mModel = instance.mModel;
    this.mOfferDescription = instance.mOfferDescription;
    this.mOfferDisclaimer = instance.mOfferDisclaimer;
    this.mOfferType = instance.mOfferType;
    this.mPrice = instance.mPrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mStartDate = instance.mStartDate;
    this.mStartTime = instance.mStartTime;
    this.mTermLength = instance.mTermLength;
    this.mTermQualifier = instance.mTermQualifier;
    this.mTitle = instance.mTitle;
    this.mTransmission = instance.mTransmission;
    this.mTrim = instance.mTrim;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVehicleOfferId = instance.mVehicleOfferId;
    this.mVisibility = instance.mVisibility;
    this.mYear = instance.mYear;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VehicleOffer> getParser() {
    return new APIRequest.ResponseParser<VehicleOffer>() {
      public APINodeList<VehicleOffer> parseResponse(String response, APIContext context, APIRequest<VehicleOffer> request, String header) throws MalformedResponseException {
        return VehicleOffer.parseResponse(response, context, request, header);
      }
    };
  }
}
