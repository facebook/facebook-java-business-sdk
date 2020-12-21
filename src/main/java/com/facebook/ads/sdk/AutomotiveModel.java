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
public class AutomotiveModel extends APINode {
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("automotive_model_id")
  private String mAutomotiveModelId = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("body_style")
  private String mBodyStyle = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("drivetrain")
  private String mDrivetrain = null;
  @SerializedName("exterior_color")
  private String mExteriorColor = null;
  @SerializedName("finance_description")
  private String mFinanceDescription = null;
  @SerializedName("finance_type")
  private String mFinanceType = null;
  @SerializedName("fuel_type")
  private String mFuelType = null;
  @SerializedName("generation")
  private String mGeneration = null;
  @SerializedName("id")
  private String mId = null;
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
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("transmission")
  private String mTransmission = null;
  @SerializedName("trim")
  private String mTrim = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("year")
  private Long mYear = null;
  protected static Gson gson = null;

  AutomotiveModel() {
  }

  public AutomotiveModel(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AutomotiveModel(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AutomotiveModel fetch() throws APIException{
    AutomotiveModel newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AutomotiveModel fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AutomotiveModel> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AutomotiveModel fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AutomotiveModel> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AutomotiveModel> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AutomotiveModel>)(
      new APIRequest<AutomotiveModel>(context, "", "/", "GET", AutomotiveModel.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AutomotiveModel>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AutomotiveModel.getParser())
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
  public static AutomotiveModel loadJSON(String json, APIContext context, String header) {
    AutomotiveModel automotiveModel = getGson().fromJson(json, AutomotiveModel.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(automotiveModel.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    automotiveModel.context = context;
    automotiveModel.rawValue = json;
    automotiveModel.header = header;
    return automotiveModel;
  }

  public static APINodeList<AutomotiveModel> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AutomotiveModel> automotiveModels = new APINodeList<AutomotiveModel>(request, json, header);
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
          automotiveModels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return automotiveModels;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                automotiveModels.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            automotiveModels.setPaging(previous, next);
            if (context.hasAppSecret()) {
              automotiveModels.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              automotiveModels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  automotiveModels.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              automotiveModels.add(loadJSON(obj.toString(), context, header));
            }
          }
          return automotiveModels;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              automotiveModels.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return automotiveModels;
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
              automotiveModels.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return automotiveModels;
          }

          // Sixth, check if it's pure JsonObject
          automotiveModels.clear();
          automotiveModels.add(loadJSON(json, context, header));
          return automotiveModels;
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


  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public String getFieldAutomotiveModelId() {
    return mAutomotiveModelId;
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

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
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

  public String getFieldFinanceDescription() {
    return mFinanceDescription;
  }

  public String getFieldFinanceType() {
    return mFinanceType;
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

  public String getFieldPrice() {
    return mPrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
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

  public Long getFieldYear() {
    return mYear;
  }



  public static class APIRequestGet extends APIRequest<AutomotiveModel> {

    AutomotiveModel lastResponse = null;
    @Override
    public AutomotiveModel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applinks",
      "automotive_model_id",
      "availability",
      "body_style",
      "category_specific_fields",
      "currency",
      "custom_label_0",
      "description",
      "drivetrain",
      "exterior_color",
      "finance_description",
      "finance_type",
      "fuel_type",
      "generation",
      "id",
      "images",
      "interior_color",
      "interior_upholstery",
      "make",
      "model",
      "price",
      "sanitized_images",
      "title",
      "transmission",
      "trim",
      "url",
      "year",
    };

    @Override
    public AutomotiveModel parseResponse(String response, String header) throws APIException {
      return AutomotiveModel.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AutomotiveModel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AutomotiveModel execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AutomotiveModel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AutomotiveModel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AutomotiveModel>() {
           public AutomotiveModel apply(ResponseWrapper result) {
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

    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestAutomotiveModelIdField () {
      return this.requestAutomotiveModelIdField(true);
    }
    public APIRequestGet requestAutomotiveModelIdField (boolean value) {
      this.requestField("automotive_model_id", value);
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
    public APIRequestGet requestFinanceDescriptionField () {
      return this.requestFinanceDescriptionField(true);
    }
    public APIRequestGet requestFinanceDescriptionField (boolean value) {
      this.requestField("finance_description", value);
      return this;
    }
    public APIRequestGet requestFinanceTypeField () {
      return this.requestFinanceTypeField(true);
    }
    public APIRequestGet requestFinanceTypeField (boolean value) {
      this.requestField("finance_type", value);
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

  public AutomotiveModel copyFrom(AutomotiveModel instance) {
    this.mApplinks = instance.mApplinks;
    this.mAutomotiveModelId = instance.mAutomotiveModelId;
    this.mAvailability = instance.mAvailability;
    this.mBodyStyle = instance.mBodyStyle;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCurrency = instance.mCurrency;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mDescription = instance.mDescription;
    this.mDrivetrain = instance.mDrivetrain;
    this.mExteriorColor = instance.mExteriorColor;
    this.mFinanceDescription = instance.mFinanceDescription;
    this.mFinanceType = instance.mFinanceType;
    this.mFuelType = instance.mFuelType;
    this.mGeneration = instance.mGeneration;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mInteriorColor = instance.mInteriorColor;
    this.mInteriorUpholstery = instance.mInteriorUpholstery;
    this.mMake = instance.mMake;
    this.mModel = instance.mModel;
    this.mPrice = instance.mPrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mTitle = instance.mTitle;
    this.mTransmission = instance.mTransmission;
    this.mTrim = instance.mTrim;
    this.mUrl = instance.mUrl;
    this.mYear = instance.mYear;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AutomotiveModel> getParser() {
    return new APIRequest.ResponseParser<AutomotiveModel>() {
      public APINodeList<AutomotiveModel> parseResponse(String response, APIContext context, APIRequest<AutomotiveModel> request, String header) throws MalformedResponseException {
        return AutomotiveModel.parseResponse(response, context, request, header);
      }
    };
  }
}
