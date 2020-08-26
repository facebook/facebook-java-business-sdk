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
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("end_time")
  private Long mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<String> mImages = null;
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
  @SerializedName("trim")
  private String mTrim = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("vehicle_offer_id")
  private String mVehicleOfferId = null;
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

  public String getFieldEndDate() {
    return mEndDate;
  }

  public Long getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldImages() {
    return mImages;
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

  public String getFieldTrim() {
    return mTrim;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldVehicleOfferId() {
    return mVehicleOfferId;
  }

  public Long getFieldYear() {
    return mYear;
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
      "body_style",
      "cashback_currency",
      "cashback_price",
      "category_specific_fields",
      "currency",
      "dma_codes",
      "downpayment_currency",
      "downpayment_price",
      "downpayment_qualifier",
      "end_date",
      "end_time",
      "id",
      "images",
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
      "trim",
      "url",
      "vehicle_offer_id",
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
    public APIRequestGet requestVehicleOfferIdField () {
      return this.requestVehicleOfferIdField(true);
    }
    public APIRequestGet requestVehicleOfferIdField (boolean value) {
      this.requestField("vehicle_offer_id", value);
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

  public VehicleOffer copyFrom(VehicleOffer instance) {
    this.mAmountCurrency = instance.mAmountCurrency;
    this.mAmountPercentage = instance.mAmountPercentage;
    this.mAmountPrice = instance.mAmountPrice;
    this.mAmountQualifier = instance.mAmountQualifier;
    this.mApplinks = instance.mApplinks;
    this.mBodyStyle = instance.mBodyStyle;
    this.mCashbackCurrency = instance.mCashbackCurrency;
    this.mCashbackPrice = instance.mCashbackPrice;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCurrency = instance.mCurrency;
    this.mDmaCodes = instance.mDmaCodes;
    this.mDownpaymentCurrency = instance.mDownpaymentCurrency;
    this.mDownpaymentPrice = instance.mDownpaymentPrice;
    this.mDownpaymentQualifier = instance.mDownpaymentQualifier;
    this.mEndDate = instance.mEndDate;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
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
    this.mTrim = instance.mTrim;
    this.mUrl = instance.mUrl;
    this.mVehicleOfferId = instance.mVehicleOfferId;
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
