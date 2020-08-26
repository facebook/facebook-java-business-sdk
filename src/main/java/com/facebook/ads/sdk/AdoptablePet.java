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
public class AdoptablePet extends APINode {
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("adoptable_pet_id")
  private String mAdoptablePetId = null;
  @SerializedName("adoption_application_form_url")
  private String mAdoptionApplicationFormUrl = null;
  @SerializedName("age_bucket")
  private String mAgeBucket = null;
  @SerializedName("animal_type")
  private String mAnimalType = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("breed")
  private String mBreed = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("shelter_name")
  private String mShelterName = null;
  @SerializedName("shelter_page_id")
  private Page mShelterPageId = null;
  @SerializedName("size")
  private String mSize = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  AdoptablePet() {
  }

  public AdoptablePet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdoptablePet(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdoptablePet fetch() throws APIException{
    AdoptablePet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdoptablePet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdoptablePet> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdoptablePet fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdoptablePet> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdoptablePet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdoptablePet>)(
      new APIRequest<AdoptablePet>(context, "", "/", "GET", AdoptablePet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdoptablePet>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdoptablePet.getParser())
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
  public static AdoptablePet loadJSON(String json, APIContext context, String header) {
    AdoptablePet adoptablePet = getGson().fromJson(json, AdoptablePet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adoptablePet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adoptablePet.context = context;
    adoptablePet.rawValue = json;
    adoptablePet.header = header;
    return adoptablePet;
  }

  public static APINodeList<AdoptablePet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdoptablePet> adoptablePets = new APINodeList<AdoptablePet>(request, json, header);
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
          adoptablePets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adoptablePets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adoptablePets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adoptablePets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adoptablePets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adoptablePets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adoptablePets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adoptablePets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adoptablePets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adoptablePets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adoptablePets;
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
              adoptablePets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adoptablePets;
          }

          // Sixth, check if it's pure JsonObject
          adoptablePets.clear();
          adoptablePets.add(loadJSON(json, context, header));
          return adoptablePets;
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

  public String getFieldAdoptablePetId() {
    return mAdoptablePetId;
  }

  public String getFieldAdoptionApplicationFormUrl() {
    return mAdoptionApplicationFormUrl;
  }

  public String getFieldAgeBucket() {
    return mAgeBucket;
  }

  public String getFieldAnimalType() {
    return mAnimalType;
  }

  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public String getFieldAvailability() {
    return mAvailability;
  }

  public String getFieldBreed() {
    return mBreed;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldGender() {
    return mGender;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldShelterName() {
    return mShelterName;
  }

  public Page getFieldShelterPageId() {
    if (mShelterPageId != null) {
      mShelterPageId.context = getContext();
    }
    return mShelterPageId;
  }

  public String getFieldSize() {
    return mSize;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGet extends APIRequest<AdoptablePet> {

    AdoptablePet lastResponse = null;
    @Override
    public AdoptablePet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address",
      "adoptable_pet_id",
      "adoption_application_form_url",
      "age_bucket",
      "animal_type",
      "applinks",
      "availability",
      "breed",
      "category_specific_fields",
      "currency",
      "description",
      "gender",
      "id",
      "images",
      "name",
      "price",
      "sanitized_images",
      "shelter_name",
      "shelter_page_id",
      "size",
      "url",
    };

    @Override
    public AdoptablePet parseResponse(String response, String header) throws APIException {
      return AdoptablePet.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdoptablePet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdoptablePet execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdoptablePet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdoptablePet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdoptablePet>() {
           public AdoptablePet apply(ResponseWrapper result) {
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

    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGet requestAdoptablePetIdField () {
      return this.requestAdoptablePetIdField(true);
    }
    public APIRequestGet requestAdoptablePetIdField (boolean value) {
      this.requestField("adoptable_pet_id", value);
      return this;
    }
    public APIRequestGet requestAdoptionApplicationFormUrlField () {
      return this.requestAdoptionApplicationFormUrlField(true);
    }
    public APIRequestGet requestAdoptionApplicationFormUrlField (boolean value) {
      this.requestField("adoption_application_form_url", value);
      return this;
    }
    public APIRequestGet requestAgeBucketField () {
      return this.requestAgeBucketField(true);
    }
    public APIRequestGet requestAgeBucketField (boolean value) {
      this.requestField("age_bucket", value);
      return this;
    }
    public APIRequestGet requestAnimalTypeField () {
      return this.requestAnimalTypeField(true);
    }
    public APIRequestGet requestAnimalTypeField (boolean value) {
      this.requestField("animal_type", value);
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
    public APIRequestGet requestBreedField () {
      return this.requestBreedField(true);
    }
    public APIRequestGet requestBreedField (boolean value) {
      this.requestField("breed", value);
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
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
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
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
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
    public APIRequestGet requestShelterNameField () {
      return this.requestShelterNameField(true);
    }
    public APIRequestGet requestShelterNameField (boolean value) {
      this.requestField("shelter_name", value);
      return this;
    }
    public APIRequestGet requestShelterPageIdField () {
      return this.requestShelterPageIdField(true);
    }
    public APIRequestGet requestShelterPageIdField (boolean value) {
      this.requestField("shelter_page_id", value);
      return this;
    }
    public APIRequestGet requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGet requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
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

  public AdoptablePet copyFrom(AdoptablePet instance) {
    this.mAddress = instance.mAddress;
    this.mAdoptablePetId = instance.mAdoptablePetId;
    this.mAdoptionApplicationFormUrl = instance.mAdoptionApplicationFormUrl;
    this.mAgeBucket = instance.mAgeBucket;
    this.mAnimalType = instance.mAnimalType;
    this.mApplinks = instance.mApplinks;
    this.mAvailability = instance.mAvailability;
    this.mBreed = instance.mBreed;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mGender = instance.mGender;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mName = instance.mName;
    this.mPrice = instance.mPrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mShelterName = instance.mShelterName;
    this.mShelterPageId = instance.mShelterPageId;
    this.mSize = instance.mSize;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdoptablePet> getParser() {
    return new APIRequest.ResponseParser<AdoptablePet>() {
      public APINodeList<AdoptablePet> parseResponse(String response, APIContext context, APIRequest<AdoptablePet> request, String header) throws MalformedResponseException {
        return AdoptablePet.parseResponse(response, context, request, header);
      }
    };
  }
}
