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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
  private AppLinks mApplinks = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("body_style")
  private String mBodyStyle = null;
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
  public static Vehicle loadJSON(String json, APIContext context) {
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
      };
    }
    vehicle.context = context;
    vehicle.rawValue = json;
    return vehicle;
  }

  public static APINodeList<Vehicle> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Vehicle> vehicles = new APINodeList<Vehicle>(request, json);
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
          vehicles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              vehicles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  vehicles.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              vehicles.add(loadJSON(obj.toString(), context));
            }
          }
          return vehicles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              vehicles.add(loadJSON(entry.getValue().toString(), context));
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
              vehicles.add(loadJSON(value.toString(), context));
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
          vehicles.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAddress() {
    return mAddress;
  }

  public AppLinks getFieldApplinks() {
    if (mApplinks != null) {
      mApplinks.context = getContext();
    }
    return mApplinks;
  }

  public String getFieldAvailability() {
    return mAvailability;
  }

  public String getFieldBodyStyle() {
    return mBodyStyle;
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

  public Long getFieldYear() {
    return mYear;
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
      "condition",
      "currency",
      "custom_label_0",
      "date_first_on_lot",
      "dealer_communication_channel",
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
      "url",
      "vehicle_id",
      "vehicle_registration_plate",
      "vehicle_specifications",
      "vehicle_type",
      "vin",
      "year",
    };

    @Override
    public Vehicle parseResponse(String response) throws APIException {
      return Vehicle.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Vehicle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Vehicle execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Vehicle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Vehicle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Vehicle>() {
           public Vehicle apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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
    public APIRequestGet requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGet requestYearField (boolean value) {
      this.requestField("year", value);
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

  public Vehicle copyFrom(Vehicle instance) {
    this.mAddress = instance.mAddress;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBodyStyle = instance.mBodyStyle;
    this.mCondition = instance.mCondition;
    this.mCurrency = instance.mCurrency;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mDateFirstOnLot = instance.mDateFirstOnLot;
    this.mDealerCommunicationChannel = instance.mDealerCommunicationChannel;
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
    this.mUrl = instance.mUrl;
    this.mVehicleId = instance.mVehicleId;
    this.mVehicleRegistrationPlate = instance.mVehicleRegistrationPlate;
    this.mVehicleSpecifications = instance.mVehicleSpecifications;
    this.mVehicleType = instance.mVehicleType;
    this.mVin = instance.mVin;
    this.mYear = instance.mYear;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Vehicle> getParser() {
    return new APIRequest.ResponseParser<Vehicle>() {
      public APINodeList<Vehicle> parseResponse(String response, APIContext context, APIRequest<Vehicle> request) throws MalformedResponseException {
        return Vehicle.parseResponse(response, context, request);
      }
    };
  }
}
