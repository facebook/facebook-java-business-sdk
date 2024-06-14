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
public class HomeListing extends APINode {
  @SerializedName("ac_type")
  private String mAcType = null;
  @SerializedName("additional_fees_description")
  private String mAdditionalFeesDescription = null;
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("agent_company")
  private String mAgentCompany = null;
  @SerializedName("agent_email")
  private String mAgentEmail = null;
  @SerializedName("agent_fb_page_id")
  private Page mAgentFbPageId = null;
  @SerializedName("agent_name")
  private String mAgentName = null;
  @SerializedName("agent_phone")
  private String mAgentPhone = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("area_size")
  private Long mAreaSize = null;
  @SerializedName("area_unit")
  private String mAreaUnit = null;
  @SerializedName("availability")
  private String mAvailability = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("co_2_emission_rating_eu")
  private Object mCo2EmissionRatingEu = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("days_on_market")
  private Long mDaysOnMarket = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("energy_rating_eu")
  private Object mEnergyRatingEu = null;
  @SerializedName("furnish_type")
  private String mFurnishType = null;
  @SerializedName("group_id")
  private String mGroupId = null;
  @SerializedName("heating_type")
  private String mHeatingType = null;
  @SerializedName("home_listing_id")
  private String mHomeListingId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("laundry_type")
  private String mLaundryType = null;
  @SerializedName("listing_type")
  private String mListingType = null;
  @SerializedName("max_currency")
  private String mMaxCurrency = null;
  @SerializedName("max_price")
  private String mMaxPrice = null;
  @SerializedName("min_currency")
  private String mMinCurrency = null;
  @SerializedName("min_price")
  private String mMinPrice = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("num_baths")
  private Double mNumBaths = null;
  @SerializedName("num_beds")
  private Double mNumBeds = null;
  @SerializedName("num_rooms")
  private Double mNumRooms = null;
  @SerializedName("num_units")
  private Long mNumUnits = null;
  @SerializedName("parking_type")
  private String mParkingType = null;
  @SerializedName("partner_verification")
  private String mPartnerVerification = null;
  @SerializedName("pet_policy")
  private String mPetPolicy = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("property_type")
  private String mPropertyType = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("year_built")
  private Long mYearBuilt = null;
  protected static Gson gson = null;

  HomeListing() {
  }

  public HomeListing(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public HomeListing(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public HomeListing fetch() throws APIException{
    HomeListing newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static HomeListing fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<HomeListing> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static HomeListing fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<HomeListing> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<HomeListing> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<HomeListing>)(
      new APIRequest<HomeListing>(context, "", "/", "GET", HomeListing.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<HomeListing>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", HomeListing.getParser())
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
  public static HomeListing loadJSON(String json, APIContext context, String header) {
    HomeListing homeListing = getGson().fromJson(json, HomeListing.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(homeListing.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    homeListing.context = context;
    homeListing.rawValue = json;
    homeListing.header = header;
    return homeListing;
  }

  public static APINodeList<HomeListing> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<HomeListing> homeListings = new APINodeList<HomeListing>(request, json, header);
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
          homeListings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return homeListings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                homeListings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            homeListings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              homeListings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              homeListings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  homeListings.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              homeListings.add(loadJSON(obj.toString(), context, header));
            }
          }
          return homeListings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              homeListings.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return homeListings;
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
              homeListings.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return homeListings;
          }

          // Sixth, check if it's pure JsonObject
          homeListings.clear();
          homeListings.add(loadJSON(json, context, header));
          return homeListings;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAcType() {
    return mAcType;
  }

  public String getFieldAdditionalFeesDescription() {
    return mAdditionalFeesDescription;
  }

  public Object getFieldAddress() {
    return mAddress;
  }

  public String getFieldAgentCompany() {
    return mAgentCompany;
  }

  public String getFieldAgentEmail() {
    return mAgentEmail;
  }

  public Page getFieldAgentFbPageId() {
    if (mAgentFbPageId != null) {
      mAgentFbPageId.context = getContext();
    }
    return mAgentFbPageId;
  }

  public String getFieldAgentName() {
    return mAgentName;
  }

  public String getFieldAgentPhone() {
    return mAgentPhone;
  }

  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public Long getFieldAreaSize() {
    return mAreaSize;
  }

  public String getFieldAreaUnit() {
    return mAreaUnit;
  }

  public String getFieldAvailability() {
    return mAvailability;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public Object getFieldCo2EmissionRatingEu() {
    return mCo2EmissionRatingEu;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public Long getFieldDaysOnMarket() {
    return mDaysOnMarket;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Object getFieldEnergyRatingEu() {
    return mEnergyRatingEu;
  }

  public String getFieldFurnishType() {
    return mFurnishType;
  }

  public String getFieldGroupId() {
    return mGroupId;
  }

  public String getFieldHeatingType() {
    return mHeatingType;
  }

  public String getFieldHomeListingId() {
    return mHomeListingId;
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

  public String getFieldLaundryType() {
    return mLaundryType;
  }

  public String getFieldListingType() {
    return mListingType;
  }

  public String getFieldMaxCurrency() {
    return mMaxCurrency;
  }

  public String getFieldMaxPrice() {
    return mMaxPrice;
  }

  public String getFieldMinCurrency() {
    return mMinCurrency;
  }

  public String getFieldMinPrice() {
    return mMinPrice;
  }

  public String getFieldName() {
    return mName;
  }

  public Double getFieldNumBaths() {
    return mNumBaths;
  }

  public Double getFieldNumBeds() {
    return mNumBeds;
  }

  public Double getFieldNumRooms() {
    return mNumRooms;
  }

  public Long getFieldNumUnits() {
    return mNumUnits;
  }

  public String getFieldParkingType() {
    return mParkingType;
  }

  public String getFieldPartnerVerification() {
    return mPartnerVerification;
  }

  public String getFieldPetPolicy() {
    return mPetPolicy;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public String getFieldPropertyType() {
    return mPropertyType;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }

  public Long getFieldYearBuilt() {
    return mYearBuilt;
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

  public static class APIRequestGet extends APIRequest<HomeListing> {

    HomeListing lastResponse = null;
    @Override
    public HomeListing getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ac_type",
      "additional_fees_description",
      "address",
      "agent_company",
      "agent_email",
      "agent_fb_page_id",
      "agent_name",
      "agent_phone",
      "applinks",
      "area_size",
      "area_unit",
      "availability",
      "category_specific_fields",
      "co_2_emission_rating_eu",
      "currency",
      "days_on_market",
      "description",
      "energy_rating_eu",
      "furnish_type",
      "group_id",
      "heating_type",
      "home_listing_id",
      "id",
      "image_fetch_status",
      "images",
      "laundry_type",
      "listing_type",
      "max_currency",
      "max_price",
      "min_currency",
      "min_price",
      "name",
      "num_baths",
      "num_beds",
      "num_rooms",
      "num_units",
      "parking_type",
      "partner_verification",
      "pet_policy",
      "price",
      "property_type",
      "sanitized_images",
      "unit_price",
      "url",
      "visibility",
      "year_built",
    };

    @Override
    public HomeListing parseResponse(String response, String header) throws APIException {
      return HomeListing.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HomeListing execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HomeListing execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HomeListing> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HomeListing> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HomeListing>() {
           public HomeListing apply(ResponseWrapper result) {
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

    public APIRequestGet requestAcTypeField () {
      return this.requestAcTypeField(true);
    }
    public APIRequestGet requestAcTypeField (boolean value) {
      this.requestField("ac_type", value);
      return this;
    }
    public APIRequestGet requestAdditionalFeesDescriptionField () {
      return this.requestAdditionalFeesDescriptionField(true);
    }
    public APIRequestGet requestAdditionalFeesDescriptionField (boolean value) {
      this.requestField("additional_fees_description", value);
      return this;
    }
    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGet requestAgentCompanyField () {
      return this.requestAgentCompanyField(true);
    }
    public APIRequestGet requestAgentCompanyField (boolean value) {
      this.requestField("agent_company", value);
      return this;
    }
    public APIRequestGet requestAgentEmailField () {
      return this.requestAgentEmailField(true);
    }
    public APIRequestGet requestAgentEmailField (boolean value) {
      this.requestField("agent_email", value);
      return this;
    }
    public APIRequestGet requestAgentFbPageIdField () {
      return this.requestAgentFbPageIdField(true);
    }
    public APIRequestGet requestAgentFbPageIdField (boolean value) {
      this.requestField("agent_fb_page_id", value);
      return this;
    }
    public APIRequestGet requestAgentNameField () {
      return this.requestAgentNameField(true);
    }
    public APIRequestGet requestAgentNameField (boolean value) {
      this.requestField("agent_name", value);
      return this;
    }
    public APIRequestGet requestAgentPhoneField () {
      return this.requestAgentPhoneField(true);
    }
    public APIRequestGet requestAgentPhoneField (boolean value) {
      this.requestField("agent_phone", value);
      return this;
    }
    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestAreaSizeField () {
      return this.requestAreaSizeField(true);
    }
    public APIRequestGet requestAreaSizeField (boolean value) {
      this.requestField("area_size", value);
      return this;
    }
    public APIRequestGet requestAreaUnitField () {
      return this.requestAreaUnitField(true);
    }
    public APIRequestGet requestAreaUnitField (boolean value) {
      this.requestField("area_unit", value);
      return this;
    }
    public APIRequestGet requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGet requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestCo2EmissionRatingEuField () {
      return this.requestCo2EmissionRatingEuField(true);
    }
    public APIRequestGet requestCo2EmissionRatingEuField (boolean value) {
      this.requestField("co_2_emission_rating_eu", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDaysOnMarketField () {
      return this.requestDaysOnMarketField(true);
    }
    public APIRequestGet requestDaysOnMarketField (boolean value) {
      this.requestField("days_on_market", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEnergyRatingEuField () {
      return this.requestEnergyRatingEuField(true);
    }
    public APIRequestGet requestEnergyRatingEuField (boolean value) {
      this.requestField("energy_rating_eu", value);
      return this;
    }
    public APIRequestGet requestFurnishTypeField () {
      return this.requestFurnishTypeField(true);
    }
    public APIRequestGet requestFurnishTypeField (boolean value) {
      this.requestField("furnish_type", value);
      return this;
    }
    public APIRequestGet requestGroupIdField () {
      return this.requestGroupIdField(true);
    }
    public APIRequestGet requestGroupIdField (boolean value) {
      this.requestField("group_id", value);
      return this;
    }
    public APIRequestGet requestHeatingTypeField () {
      return this.requestHeatingTypeField(true);
    }
    public APIRequestGet requestHeatingTypeField (boolean value) {
      this.requestField("heating_type", value);
      return this;
    }
    public APIRequestGet requestHomeListingIdField () {
      return this.requestHomeListingIdField(true);
    }
    public APIRequestGet requestHomeListingIdField (boolean value) {
      this.requestField("home_listing_id", value);
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
    public APIRequestGet requestLaundryTypeField () {
      return this.requestLaundryTypeField(true);
    }
    public APIRequestGet requestLaundryTypeField (boolean value) {
      this.requestField("laundry_type", value);
      return this;
    }
    public APIRequestGet requestListingTypeField () {
      return this.requestListingTypeField(true);
    }
    public APIRequestGet requestListingTypeField (boolean value) {
      this.requestField("listing_type", value);
      return this;
    }
    public APIRequestGet requestMaxCurrencyField () {
      return this.requestMaxCurrencyField(true);
    }
    public APIRequestGet requestMaxCurrencyField (boolean value) {
      this.requestField("max_currency", value);
      return this;
    }
    public APIRequestGet requestMaxPriceField () {
      return this.requestMaxPriceField(true);
    }
    public APIRequestGet requestMaxPriceField (boolean value) {
      this.requestField("max_price", value);
      return this;
    }
    public APIRequestGet requestMinCurrencyField () {
      return this.requestMinCurrencyField(true);
    }
    public APIRequestGet requestMinCurrencyField (boolean value) {
      this.requestField("min_currency", value);
      return this;
    }
    public APIRequestGet requestMinPriceField () {
      return this.requestMinPriceField(true);
    }
    public APIRequestGet requestMinPriceField (boolean value) {
      this.requestField("min_price", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNumBathsField () {
      return this.requestNumBathsField(true);
    }
    public APIRequestGet requestNumBathsField (boolean value) {
      this.requestField("num_baths", value);
      return this;
    }
    public APIRequestGet requestNumBedsField () {
      return this.requestNumBedsField(true);
    }
    public APIRequestGet requestNumBedsField (boolean value) {
      this.requestField("num_beds", value);
      return this;
    }
    public APIRequestGet requestNumRoomsField () {
      return this.requestNumRoomsField(true);
    }
    public APIRequestGet requestNumRoomsField (boolean value) {
      this.requestField("num_rooms", value);
      return this;
    }
    public APIRequestGet requestNumUnitsField () {
      return this.requestNumUnitsField(true);
    }
    public APIRequestGet requestNumUnitsField (boolean value) {
      this.requestField("num_units", value);
      return this;
    }
    public APIRequestGet requestParkingTypeField () {
      return this.requestParkingTypeField(true);
    }
    public APIRequestGet requestParkingTypeField (boolean value) {
      this.requestField("parking_type", value);
      return this;
    }
    public APIRequestGet requestPartnerVerificationField () {
      return this.requestPartnerVerificationField(true);
    }
    public APIRequestGet requestPartnerVerificationField (boolean value) {
      this.requestField("partner_verification", value);
      return this;
    }
    public APIRequestGet requestPetPolicyField () {
      return this.requestPetPolicyField(true);
    }
    public APIRequestGet requestPetPolicyField (boolean value) {
      this.requestField("pet_policy", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestPropertyTypeField () {
      return this.requestPropertyTypeField(true);
    }
    public APIRequestGet requestPropertyTypeField (boolean value) {
      this.requestField("property_type", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
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
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGet requestYearBuiltField () {
      return this.requestYearBuiltField(true);
    }
    public APIRequestGet requestYearBuiltField (boolean value) {
      this.requestField("year_built", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<HomeListing> {

    HomeListing lastResponse = null;
    @Override
    public HomeListing getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address",
      "availability",
      "currency",
      "description",
      "images",
      "listing_type",
      "name",
      "num_baths",
      "num_beds",
      "num_units",
      "price",
      "property_type",
      "url",
      "year_built",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HomeListing parseResponse(String response, String header) throws APIException {
      return HomeListing.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public HomeListing execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HomeListing execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<HomeListing> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HomeListing> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, HomeListing>() {
           public HomeListing apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAddress (Object address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestUpdate setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestUpdate setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestUpdate setListingType (String listingType) {
      this.setParam("listing_type", listingType);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setNumBaths (Double numBaths) {
      this.setParam("num_baths", numBaths);
      return this;
    }
    public APIRequestUpdate setNumBaths (String numBaths) {
      this.setParam("num_baths", numBaths);
      return this;
    }

    public APIRequestUpdate setNumBeds (Double numBeds) {
      this.setParam("num_beds", numBeds);
      return this;
    }
    public APIRequestUpdate setNumBeds (String numBeds) {
      this.setParam("num_beds", numBeds);
      return this;
    }

    public APIRequestUpdate setNumUnits (Double numUnits) {
      this.setParam("num_units", numUnits);
      return this;
    }
    public APIRequestUpdate setNumUnits (String numUnits) {
      this.setParam("num_units", numUnits);
      return this;
    }

    public APIRequestUpdate setPrice (Double price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestUpdate setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setPropertyType (String propertyType) {
      this.setParam("property_type", propertyType);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestUpdate setYearBuilt (Long yearBuilt) {
      this.setParam("year_built", yearBuilt);
      return this;
    }
    public APIRequestUpdate setYearBuilt (String yearBuilt) {
      this.setParam("year_built", yearBuilt);
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

  public HomeListing copyFrom(HomeListing instance) {
    this.mAcType = instance.mAcType;
    this.mAdditionalFeesDescription = instance.mAdditionalFeesDescription;
    this.mAddress = instance.mAddress;
    this.mAgentCompany = instance.mAgentCompany;
    this.mAgentEmail = instance.mAgentEmail;
    this.mAgentFbPageId = instance.mAgentFbPageId;
    this.mAgentName = instance.mAgentName;
    this.mAgentPhone = instance.mAgentPhone;
    this.mApplinks = instance.mApplinks;
    this.mAreaSize = instance.mAreaSize;
    this.mAreaUnit = instance.mAreaUnit;
    this.mAvailability = instance.mAvailability;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCo2EmissionRatingEu = instance.mCo2EmissionRatingEu;
    this.mCurrency = instance.mCurrency;
    this.mDaysOnMarket = instance.mDaysOnMarket;
    this.mDescription = instance.mDescription;
    this.mEnergyRatingEu = instance.mEnergyRatingEu;
    this.mFurnishType = instance.mFurnishType;
    this.mGroupId = instance.mGroupId;
    this.mHeatingType = instance.mHeatingType;
    this.mHomeListingId = instance.mHomeListingId;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mLaundryType = instance.mLaundryType;
    this.mListingType = instance.mListingType;
    this.mMaxCurrency = instance.mMaxCurrency;
    this.mMaxPrice = instance.mMaxPrice;
    this.mMinCurrency = instance.mMinCurrency;
    this.mMinPrice = instance.mMinPrice;
    this.mName = instance.mName;
    this.mNumBaths = instance.mNumBaths;
    this.mNumBeds = instance.mNumBeds;
    this.mNumRooms = instance.mNumRooms;
    this.mNumUnits = instance.mNumUnits;
    this.mParkingType = instance.mParkingType;
    this.mPartnerVerification = instance.mPartnerVerification;
    this.mPetPolicy = instance.mPetPolicy;
    this.mPrice = instance.mPrice;
    this.mPropertyType = instance.mPropertyType;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVisibility = instance.mVisibility;
    this.mYearBuilt = instance.mYearBuilt;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<HomeListing> getParser() {
    return new APIRequest.ResponseParser<HomeListing>() {
      public APINodeList<HomeListing> parseResponse(String response, APIContext context, APIRequest<HomeListing> request, String header) throws MalformedResponseException {
        return HomeListing.parseResponse(response, context, request, header);
      }
    };
  }
}
