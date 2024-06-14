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
public class Vehicle extends APINode {
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("body_style")
  private String mBodyStyle = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("condition")
  private String mCondition = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("date_first_on_lot")
  private String mDateFirstOnLot = null;
  @SerializedName("dealer_communication_channel")
  private String mDealerCommunicationChannel = null;
  @SerializedName("dealer_email")
  private String mDealerEmail = null;
  @SerializedName("dealer_id")
  private String mDealerId = null;
  @SerializedName("dealer_name")
  private String mDealerName = null;
  @SerializedName("dealer_phone")
  private String mDealerPhone = null;
  @SerializedName("dealer_privacy_policy_url")
  private String mDealerPrivacyPolicyUrl = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("drivetrain")
  private String mDrivetrain = null;
  @SerializedName("exterior_color")
  private String mExteriorColor = null;
  @SerializedName("fb_page_id")
  private Page mFbPageId = null;
  @SerializedName("features")
  private List<Object> mFeatures = null;
  @SerializedName("fuel_type")
  private String mFuelType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("interior_color")
  private String mInteriorColor = null;
  @SerializedName("legal_disclosure_impressum_url")
  private String mLegalDisclosureImpressumUrl = null;
  @SerializedName("make")
  private String mMake = null;
  @SerializedName("mileage")
  private Object mMileage = null;
  @SerializedName("model")
  private String mModel = null;
  @SerializedName("previous_currency")
  private String mPreviousCurrency = null;
  @SerializedName("previous_price")
  private String mPreviousPrice = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sale_currency")
  private String mSaleCurrency = null;
  @SerializedName("sale_price")
  private String mSalePrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("state_of_vehicle")
  private String mStateOfVehicle = null;
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
  @SerializedName("vehicle_id")
  private String mVehicleId = null;
  @SerializedName("vehicle_registration_plate")
  private String mVehicleRegistrationPlate = null;
  @SerializedName("vehicle_specifications")
  private List<Object> mVehicleSpecifications = null;
  @SerializedName("vehicle_type")
  private String mVehicleType = null;
  @SerializedName("vin")
  private String mVin = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("year")
  private Long mYear = null;
  protected static Gson gson = null;

  Vehicle() {
  }

  public Vehicle(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Vehicle(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Vehicle fetch() throws APIException{
    Vehicle newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Vehicle fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Vehicle> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Vehicle fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Vehicle> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Vehicle> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Vehicle>)(
      new APIRequest<Vehicle>(context, "", "/", "GET", Vehicle.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Vehicle>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Vehicle.getParser())
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
  public static Vehicle loadJSON(String json, APIContext context, String header) {
    Vehicle vehicle = getGson().fromJson(json, Vehicle.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(vehicle.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    vehicle.context = context;
    vehicle.rawValue = json;
    vehicle.header = header;
    return vehicle;
  }

  public static APINodeList<Vehicle> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Vehicle> vehicles = new APINodeList<Vehicle>(request, json, header);
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
          vehicles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return vehicles;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                vehicles.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            vehicles.setPaging(previous, next);
            if (context.hasAppSecret()) {
              vehicles.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              vehicles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  vehicles.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              vehicles.add(loadJSON(obj.toString(), context, header));
            }
          }
          return vehicles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              vehicles.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return vehicles;
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
              vehicles.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return vehicles;
          }

          // Sixth, check if it's pure JsonObject
          vehicles.clear();
          vehicles.add(loadJSON(json, context, header));
          return vehicles;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAddress() {
    return mAddress;
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

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCondition() {
    return mCondition;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public String getFieldDateFirstOnLot() {
    return mDateFirstOnLot;
  }

  public String getFieldDealerCommunicationChannel() {
    return mDealerCommunicationChannel;
  }

  public String getFieldDealerEmail() {
    return mDealerEmail;
  }

  public String getFieldDealerId() {
    return mDealerId;
  }

  public String getFieldDealerName() {
    return mDealerName;
  }

  public String getFieldDealerPhone() {
    return mDealerPhone;
  }

  public String getFieldDealerPrivacyPolicyUrl() {
    return mDealerPrivacyPolicyUrl;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDrivetrain() {
    return mDrivetrain;
  }

  public String getFieldExteriorColor() {
    return mExteriorColor;
  }

  public Page getFieldFbPageId() {
    if (mFbPageId != null) {
      mFbPageId.context = getContext();
    }
    return mFbPageId;
  }

  public List<Object> getFieldFeatures() {
    return mFeatures;
  }

  public String getFieldFuelType() {
    return mFuelType;
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

  public String getFieldLegalDisclosureImpressumUrl() {
    return mLegalDisclosureImpressumUrl;
  }

  public String getFieldMake() {
    return mMake;
  }

  public Object getFieldMileage() {
    return mMileage;
  }

  public String getFieldModel() {
    return mModel;
  }

  public String getFieldPreviousCurrency() {
    return mPreviousCurrency;
  }

  public String getFieldPreviousPrice() {
    return mPreviousPrice;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public String getFieldSaleCurrency() {
    return mSaleCurrency;
  }

  public String getFieldSalePrice() {
    return mSalePrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldStateOfVehicle() {
    return mStateOfVehicle;
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

  public String getFieldVehicleId() {
    return mVehicleId;
  }

  public String getFieldVehicleRegistrationPlate() {
    return mVehicleRegistrationPlate;
  }

  public List<Object> getFieldVehicleSpecifications() {
    return mVehicleSpecifications;
  }

  public String getFieldVehicleType() {
    return mVehicleType;
  }

  public String getFieldVin() {
    return mVin;
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

  public static class APIRequestGet extends APIRequest<Vehicle> {

    Vehicle lastResponse = null;
    @Override
    public Vehicle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public Vehicle parseResponse(String response, String header) throws APIException {
      return Vehicle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Vehicle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Vehicle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Vehicle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Vehicle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Vehicle>() {
           public Vehicle apply(ResponseWrapper result) {
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
    public APIRequestGet requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGet requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
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
    public APIRequestGet requestDateFirstOnLotField () {
      return this.requestDateFirstOnLotField(true);
    }
    public APIRequestGet requestDateFirstOnLotField (boolean value) {
      this.requestField("date_first_on_lot", value);
      return this;
    }
    public APIRequestGet requestDealerCommunicationChannelField () {
      return this.requestDealerCommunicationChannelField(true);
    }
    public APIRequestGet requestDealerCommunicationChannelField (boolean value) {
      this.requestField("dealer_communication_channel", value);
      return this;
    }
    public APIRequestGet requestDealerEmailField () {
      return this.requestDealerEmailField(true);
    }
    public APIRequestGet requestDealerEmailField (boolean value) {
      this.requestField("dealer_email", value);
      return this;
    }
    public APIRequestGet requestDealerIdField () {
      return this.requestDealerIdField(true);
    }
    public APIRequestGet requestDealerIdField (boolean value) {
      this.requestField("dealer_id", value);
      return this;
    }
    public APIRequestGet requestDealerNameField () {
      return this.requestDealerNameField(true);
    }
    public APIRequestGet requestDealerNameField (boolean value) {
      this.requestField("dealer_name", value);
      return this;
    }
    public APIRequestGet requestDealerPhoneField () {
      return this.requestDealerPhoneField(true);
    }
    public APIRequestGet requestDealerPhoneField (boolean value) {
      this.requestField("dealer_phone", value);
      return this;
    }
    public APIRequestGet requestDealerPrivacyPolicyUrlField () {
      return this.requestDealerPrivacyPolicyUrlField(true);
    }
    public APIRequestGet requestDealerPrivacyPolicyUrlField (boolean value) {
      this.requestField("dealer_privacy_policy_url", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGet requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGet requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGet requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGet requestFbPageIdField () {
      return this.requestFbPageIdField(true);
    }
    public APIRequestGet requestFbPageIdField (boolean value) {
      this.requestField("fb_page_id", value);
      return this;
    }
    public APIRequestGet requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGet requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGet requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGet requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
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
    public APIRequestGet requestLegalDisclosureImpressumUrlField () {
      return this.requestLegalDisclosureImpressumUrlField(true);
    }
    public APIRequestGet requestLegalDisclosureImpressumUrlField (boolean value) {
      this.requestField("legal_disclosure_impressum_url", value);
      return this;
    }
    public APIRequestGet requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGet requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGet requestMileageField () {
      return this.requestMileageField(true);
    }
    public APIRequestGet requestMileageField (boolean value) {
      this.requestField("mileage", value);
      return this;
    }
    public APIRequestGet requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGet requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGet requestPreviousCurrencyField () {
      return this.requestPreviousCurrencyField(true);
    }
    public APIRequestGet requestPreviousCurrencyField (boolean value) {
      this.requestField("previous_currency", value);
      return this;
    }
    public APIRequestGet requestPreviousPriceField () {
      return this.requestPreviousPriceField(true);
    }
    public APIRequestGet requestPreviousPriceField (boolean value) {
      this.requestField("previous_price", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestSaleCurrencyField () {
      return this.requestSaleCurrencyField(true);
    }
    public APIRequestGet requestSaleCurrencyField (boolean value) {
      this.requestField("sale_currency", value);
      return this;
    }
    public APIRequestGet requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGet requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestStateOfVehicleField () {
      return this.requestStateOfVehicleField(true);
    }
    public APIRequestGet requestStateOfVehicleField (boolean value) {
      this.requestField("state_of_vehicle", value);
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
    public APIRequestGet requestVehicleIdField () {
      return this.requestVehicleIdField(true);
    }
    public APIRequestGet requestVehicleIdField (boolean value) {
      this.requestField("vehicle_id", value);
      return this;
    }
    public APIRequestGet requestVehicleRegistrationPlateField () {
      return this.requestVehicleRegistrationPlateField(true);
    }
    public APIRequestGet requestVehicleRegistrationPlateField (boolean value) {
      this.requestField("vehicle_registration_plate", value);
      return this;
    }
    public APIRequestGet requestVehicleSpecificationsField () {
      return this.requestVehicleSpecificationsField(true);
    }
    public APIRequestGet requestVehicleSpecificationsField (boolean value) {
      this.requestField("vehicle_specifications", value);
      return this;
    }
    public APIRequestGet requestVehicleTypeField () {
      return this.requestVehicleTypeField(true);
    }
    public APIRequestGet requestVehicleTypeField (boolean value) {
      this.requestField("vehicle_type", value);
      return this;
    }
    public APIRequestGet requestVinField () {
      return this.requestVinField(true);
    }
    public APIRequestGet requestVinField (boolean value) {
      this.requestField("vin", value);
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

  public static class APIRequestUpdate extends APIRequest<Vehicle> {

    Vehicle lastResponse = null;
    @Override
    public Vehicle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address",
      "applinks",
      "availability",
      "body_style",
      "condition",
      "currency",
      "date_first_on_lot",
      "dealer_id",
      "dealer_name",
      "dealer_phone",
      "description",
      "drivetrain",
      "exterior_color",
      "fb_page_id",
      "fuel_type",
      "images",
      "interior_color",
      "make",
      "mileage",
      "model",
      "price",
      "state_of_vehicle",
      "title",
      "transmission",
      "trim",
      "url",
      "vehicle_type",
      "vin",
      "year",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Vehicle parseResponse(String response, String header) throws APIException {
      return Vehicle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Vehicle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Vehicle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Vehicle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Vehicle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Vehicle>() {
           public Vehicle apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAddress (Map<String, String> address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestUpdate setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestUpdate setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestUpdate setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestUpdate setAvailability (Vehicle.EnumAvailability availability) {
      this.setParam("availability", availability);
      return this;
    }
    public APIRequestUpdate setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestUpdate setBodyStyle (Vehicle.EnumBodyStyle bodyStyle) {
      this.setParam("body_style", bodyStyle);
      return this;
    }
    public APIRequestUpdate setBodyStyle (String bodyStyle) {
      this.setParam("body_style", bodyStyle);
      return this;
    }

    public APIRequestUpdate setCondition (Vehicle.EnumCondition condition) {
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

    public APIRequestUpdate setDateFirstOnLot (String dateFirstOnLot) {
      this.setParam("date_first_on_lot", dateFirstOnLot);
      return this;
    }

    public APIRequestUpdate setDealerId (String dealerId) {
      this.setParam("dealer_id", dealerId);
      return this;
    }

    public APIRequestUpdate setDealerName (String dealerName) {
      this.setParam("dealer_name", dealerName);
      return this;
    }

    public APIRequestUpdate setDealerPhone (String dealerPhone) {
      this.setParam("dealer_phone", dealerPhone);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setDrivetrain (Vehicle.EnumDrivetrain drivetrain) {
      this.setParam("drivetrain", drivetrain);
      return this;
    }
    public APIRequestUpdate setDrivetrain (String drivetrain) {
      this.setParam("drivetrain", drivetrain);
      return this;
    }

    public APIRequestUpdate setExteriorColor (String exteriorColor) {
      this.setParam("exterior_color", exteriorColor);
      return this;
    }

    public APIRequestUpdate setFbPageId (String fbPageId) {
      this.setParam("fb_page_id", fbPageId);
      return this;
    }

    public APIRequestUpdate setFuelType (Vehicle.EnumFuelType fuelType) {
      this.setParam("fuel_type", fuelType);
      return this;
    }
    public APIRequestUpdate setFuelType (String fuelType) {
      this.setParam("fuel_type", fuelType);
      return this;
    }

    public APIRequestUpdate setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestUpdate setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestUpdate setInteriorColor (String interiorColor) {
      this.setParam("interior_color", interiorColor);
      return this;
    }

    public APIRequestUpdate setMake (String make) {
      this.setParam("make", make);
      return this;
    }

    public APIRequestUpdate setMileage (Map<String, String> mileage) {
      this.setParam("mileage", mileage);
      return this;
    }
    public APIRequestUpdate setMileage (String mileage) {
      this.setParam("mileage", mileage);
      return this;
    }

    public APIRequestUpdate setModel (String model) {
      this.setParam("model", model);
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

    public APIRequestUpdate setStateOfVehicle (Vehicle.EnumStateOfVehicle stateOfVehicle) {
      this.setParam("state_of_vehicle", stateOfVehicle);
      return this;
    }
    public APIRequestUpdate setStateOfVehicle (String stateOfVehicle) {
      this.setParam("state_of_vehicle", stateOfVehicle);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestUpdate setTransmission (Vehicle.EnumTransmission transmission) {
      this.setParam("transmission", transmission);
      return this;
    }
    public APIRequestUpdate setTransmission (String transmission) {
      this.setParam("transmission", transmission);
      return this;
    }

    public APIRequestUpdate setTrim (String trim) {
      this.setParam("trim", trim);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestUpdate setVehicleType (Vehicle.EnumVehicleType vehicleType) {
      this.setParam("vehicle_type", vehicleType);
      return this;
    }
    public APIRequestUpdate setVehicleType (String vehicleType) {
      this.setParam("vehicle_type", vehicleType);
      return this;
    }

    public APIRequestUpdate setVin (String vin) {
      this.setParam("vin", vin);
      return this;
    }

    public APIRequestUpdate setYear (Long year) {
      this.setParam("year", year);
      return this;
    }
    public APIRequestUpdate setYear (String year) {
      this.setParam("year", year);
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

  public static enum EnumAvailability {
      @SerializedName("AVAILABLE")
      VALUE_AVAILABLE("AVAILABLE"),
      @SerializedName("NOT_AVAILABLE")
      VALUE_NOT_AVAILABLE("NOT_AVAILABLE"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
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

  public static enum EnumBodyStyle {
      @SerializedName("CONVERTIBLE")
      VALUE_CONVERTIBLE("CONVERTIBLE"),
      @SerializedName("COUPE")
      VALUE_COUPE("COUPE"),
      @SerializedName("CROSSOVER")
      VALUE_CROSSOVER("CROSSOVER"),
      @SerializedName("ESTATE")
      VALUE_ESTATE("ESTATE"),
      @SerializedName("GRANDTOURER")
      VALUE_GRANDTOURER("GRANDTOURER"),
      @SerializedName("HATCHBACK")
      VALUE_HATCHBACK("HATCHBACK"),
      @SerializedName("MINIBUS")
      VALUE_MINIBUS("MINIBUS"),
      @SerializedName("MINIVAN")
      VALUE_MINIVAN("MINIVAN"),
      @SerializedName("MPV")
      VALUE_MPV("MPV"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PICKUP")
      VALUE_PICKUP("PICKUP"),
      @SerializedName("ROADSTER")
      VALUE_ROADSTER("ROADSTER"),
      @SerializedName("SALOON")
      VALUE_SALOON("SALOON"),
      @SerializedName("SEDAN")
      VALUE_SEDAN("SEDAN"),
      @SerializedName("SMALL_CAR")
      VALUE_SMALL_CAR("SMALL_CAR"),
      @SerializedName("SPORTSCAR")
      VALUE_SPORTSCAR("SPORTSCAR"),
      @SerializedName("SUPERCAR")
      VALUE_SUPERCAR("SUPERCAR"),
      @SerializedName("SUPERMINI")
      VALUE_SUPERMINI("SUPERMINI"),
      @SerializedName("SUV")
      VALUE_SUV("SUV"),
      @SerializedName("TRUCK")
      VALUE_TRUCK("TRUCK"),
      @SerializedName("VAN")
      VALUE_VAN("VAN"),
      @SerializedName("WAGON")
      VALUE_WAGON("WAGON"),
      ;

      private String value;

      private EnumBodyStyle(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCondition {
      @SerializedName("EXCELLENT")
      VALUE_EXCELLENT("EXCELLENT"),
      @SerializedName("FAIR")
      VALUE_FAIR("FAIR"),
      @SerializedName("GOOD")
      VALUE_GOOD("GOOD"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("POOR")
      VALUE_POOR("POOR"),
      @SerializedName("VERY_GOOD")
      VALUE_VERY_GOOD("VERY_GOOD"),
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

  public static enum EnumDrivetrain {
      @SerializedName("AWD")
      VALUE_AWD("AWD"),
      @SerializedName("FOUR_WD")
      VALUE_FOUR_WD("FOUR_WD"),
      @SerializedName("FWD")
      VALUE_FWD("FWD"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("RWD")
      VALUE_RWD("RWD"),
      @SerializedName("TWO_WD")
      VALUE_TWO_WD("TWO_WD"),
      ;

      private String value;

      private EnumDrivetrain(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFuelType {
      @SerializedName("DIESEL")
      VALUE_DIESEL("DIESEL"),
      @SerializedName("ELECTRIC")
      VALUE_ELECTRIC("ELECTRIC"),
      @SerializedName("FLEX")
      VALUE_FLEX("FLEX"),
      @SerializedName("GASOLINE")
      VALUE_GASOLINE("GASOLINE"),
      @SerializedName("HYBRID")
      VALUE_HYBRID("HYBRID"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PETROL")
      VALUE_PETROL("PETROL"),
      @SerializedName("PLUGIN_HYBRID")
      VALUE_PLUGIN_HYBRID("PLUGIN_HYBRID"),
      ;

      private String value;

      private EnumFuelType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStateOfVehicle {
      @SerializedName("CPO")
      VALUE_CPO("CPO"),
      @SerializedName("NEW")
      VALUE_NEW("NEW"),
      @SerializedName("USED")
      VALUE_USED("USED"),
      ;

      private String value;

      private EnumStateOfVehicle(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTransmission {
      @SerializedName("AUTOMATIC")
      VALUE_AUTOMATIC("AUTOMATIC"),
      @SerializedName("MANUAL")
      VALUE_MANUAL("MANUAL"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      ;

      private String value;

      private EnumTransmission(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVehicleType {
      @SerializedName("BOAT")
      VALUE_BOAT("BOAT"),
      @SerializedName("CAR_TRUCK")
      VALUE_CAR_TRUCK("CAR_TRUCK"),
      @SerializedName("COMMERCIAL")
      VALUE_COMMERCIAL("COMMERCIAL"),
      @SerializedName("MOTORCYCLE")
      VALUE_MOTORCYCLE("MOTORCYCLE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("POWERSPORT")
      VALUE_POWERSPORT("POWERSPORT"),
      @SerializedName("RV_CAMPER")
      VALUE_RV_CAMPER("RV_CAMPER"),
      @SerializedName("TRAILER")
      VALUE_TRAILER("TRAILER"),
      ;

      private String value;

      private EnumVehicleType(String value) {
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

  public Vehicle copyFrom(Vehicle instance) {
    this.mAddress = instance.mAddress;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBodyStyle = instance.mBodyStyle;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCondition = instance.mCondition;
    this.mCurrency = instance.mCurrency;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mDateFirstOnLot = instance.mDateFirstOnLot;
    this.mDealerCommunicationChannel = instance.mDealerCommunicationChannel;
    this.mDealerEmail = instance.mDealerEmail;
    this.mDealerId = instance.mDealerId;
    this.mDealerName = instance.mDealerName;
    this.mDealerPhone = instance.mDealerPhone;
    this.mDealerPrivacyPolicyUrl = instance.mDealerPrivacyPolicyUrl;
    this.mDescription = instance.mDescription;
    this.mDrivetrain = instance.mDrivetrain;
    this.mExteriorColor = instance.mExteriorColor;
    this.mFbPageId = instance.mFbPageId;
    this.mFeatures = instance.mFeatures;
    this.mFuelType = instance.mFuelType;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mInteriorColor = instance.mInteriorColor;
    this.mLegalDisclosureImpressumUrl = instance.mLegalDisclosureImpressumUrl;
    this.mMake = instance.mMake;
    this.mMileage = instance.mMileage;
    this.mModel = instance.mModel;
    this.mPreviousCurrency = instance.mPreviousCurrency;
    this.mPreviousPrice = instance.mPreviousPrice;
    this.mPrice = instance.mPrice;
    this.mSaleCurrency = instance.mSaleCurrency;
    this.mSalePrice = instance.mSalePrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mStateOfVehicle = instance.mStateOfVehicle;
    this.mTitle = instance.mTitle;
    this.mTransmission = instance.mTransmission;
    this.mTrim = instance.mTrim;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVehicleId = instance.mVehicleId;
    this.mVehicleRegistrationPlate = instance.mVehicleRegistrationPlate;
    this.mVehicleSpecifications = instance.mVehicleSpecifications;
    this.mVehicleType = instance.mVehicleType;
    this.mVin = instance.mVin;
    this.mVisibility = instance.mVisibility;
    this.mYear = instance.mYear;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Vehicle> getParser() {
    return new APIRequest.ResponseParser<Vehicle>() {
      public APINodeList<Vehicle> parseResponse(String response, APIContext context, APIRequest<Vehicle> request, String header) throws MalformedResponseException {
        return Vehicle.parseResponse(response, context, request, header);
      }
    };
  }
}
