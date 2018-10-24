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
public class ProductCatalog extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("da_display_settings")
  private ProductCatalogImageSettings mDaDisplaySettings = null;
  @SerializedName("default_image_url")
  private String mDefaultImageUrl = null;
  @SerializedName("fallback_image_url")
  private List<String> mFallbackImageUrl = null;
  @SerializedName("feed_count")
  private Long mFeedCount = null;
  @SerializedName("flight_catalog_settings")
  private FlightCatalogSettings mFlightCatalogSettings = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_padding_landscape")
  private Boolean mImagePaddingLandscape = null;
  @SerializedName("image_padding_square")
  private Boolean mImagePaddingSquare = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_count")
  private Long mProductCount = null;
  @SerializedName("qualified_product_count")
  private Long mQualifiedProductCount = null;
  @SerializedName("vertical")
  private String mVertical = null;
  protected static Gson gson = null;

  ProductCatalog() {
  }

  public ProductCatalog(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductCatalog(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductCatalog fetch() throws APIException{
    ProductCatalog newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductCatalog fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductCatalog> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductCatalog fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductCatalog> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductCatalog> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductCatalog>)(
      new APIRequest<ProductCatalog>(context, "", "/", "GET", ProductCatalog.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductCatalog>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductCatalog.getParser())
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
  public static ProductCatalog loadJSON(String json, APIContext context) {
    ProductCatalog productCatalog = getGson().fromJson(json, ProductCatalog.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalog.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productCatalog.context = context;
    productCatalog.rawValue = json;
    return productCatalog;
  }

  public static APINodeList<ProductCatalog> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductCatalog> productCatalogs = new APINodeList<ProductCatalog>(request, json);
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
          productCatalogs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productCatalogs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  productCatalogs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogs.add(loadJSON(obj.toString(), context));
            }
          }
          return productCatalogs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogs.add(loadJSON(entry.getValue().toString(), context));
          }
          return productCatalogs;
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
              productCatalogs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogs;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogs.clear();
          productCatalogs.add(loadJSON(json, context));
          return productCatalogs;
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

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAgency createAgency() {
    return new APIRequestCreateAgency(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAutomotiveModels getAutomotiveModels() {
    return new APIRequestGetAutomotiveModels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBatch createBatch() {
    return new APIRequestCreateBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCheckBatchRequestStatus getCheckBatchRequestStatus() {
    return new APIRequestGetCheckBatchRequestStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDaEventSamples getDaEventSamples() {
    return new APIRequestGetDaEventSamples(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDestinations getDestinations() {
    return new APIRequestGetDestinations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEventStats getEventStats() {
    return new APIRequestGetEventStats(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteExternalEventSources deleteExternalEventSources() {
    return new APIRequestDeleteExternalEventSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExternalEventSources getExternalEventSources() {
    return new APIRequestGetExternalEventSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateExternalEventSource createExternalEventSource() {
    return new APIRequestCreateExternalEventSource(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFlights getFlights() {
    return new APIRequestGetFlights(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFlight createFlight() {
    return new APIRequestCreateFlight(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHomeListings getHomeListings() {
    return new APIRequestGetHomeListings(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateHomeListing createHomeListing() {
    return new APIRequestCreateHomeListing(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHotelRoomsBatch getHotelRoomsBatch() {
    return new APIRequestGetHotelRoomsBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateHotelRoomsBatch createHotelRoomsBatch() {
    return new APIRequestCreateHotelRoomsBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHotels getHotels() {
    return new APIRequestGetHotels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateHotel createHotel() {
    return new APIRequestCreateHotel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPricingVariablesBatch getPricingVariablesBatch() {
    return new APIRequestGetPricingVariablesBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePricingVariablesBatch createPricingVariablesBatch() {
    return new APIRequestCreatePricingVariablesBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductFeeds getProductFeeds() {
    return new APIRequestGetProductFeeds(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductFeed createProductFeed() {
    return new APIRequestCreateProductFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductGroups getProductGroups() {
    return new APIRequestGetProductGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductGroup createProductGroup() {
    return new APIRequestCreateProductGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductSets getProductSets() {
    return new APIRequestGetProductSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductSet createProductSet() {
    return new APIRequestCreateProductSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductSetsBatch getProductSetsBatch() {
    return new APIRequestGetProductSetsBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductSetsBatch createProductSetsBatch() {
    return new APIRequestCreateProductSetsBatch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProduct createProduct() {
    return new APIRequestCreateProduct(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserPermissions deleteUserPermissions() {
    return new APIRequestDeleteUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUserPermissions getUserPermissions() {
    return new APIRequestGetUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUserPermission createUserPermission() {
    return new APIRequestCreateUserPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVehicles getVehicles() {
    return new APIRequestGetVehicles(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public ProductCatalogImageSettings getFieldDaDisplaySettings() {
    if (mDaDisplaySettings != null) {
      mDaDisplaySettings.context = getContext();
    }
    return mDaDisplaySettings;
  }

  public String getFieldDefaultImageUrl() {
    return mDefaultImageUrl;
  }

  public List<String> getFieldFallbackImageUrl() {
    return mFallbackImageUrl;
  }

  public Long getFieldFeedCount() {
    return mFeedCount;
  }

  public FlightCatalogSettings getFieldFlightCatalogSettings() {
    if (mFlightCatalogSettings != null) {
      mFlightCatalogSettings.context = getContext();
    }
    return mFlightCatalogSettings;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldImagePaddingLandscape() {
    return mImagePaddingLandscape;
  }

  public Boolean getFieldImagePaddingSquare() {
    return mImagePaddingSquare;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldProductCount() {
    return mProductCount;
  }

  public Long getFieldQualifiedProductCount() {
    return mQualifiedProductCount;
  }

  public String getFieldVertical() {
    return mVertical;
  }



  public static class APIRequestDeleteAgencies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAgencies setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAgencies extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "is_instagram_enabled_in_fb_analytics",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "verification_status",
      "vertical",
      "vertical_id",
    };

    @Override
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAgencies requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetAgencies requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetAgencies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetAgencies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetAgencies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAgencies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAgencies requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetAgencies requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAgencies requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetAgencies requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetAgencies requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetAgencies requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
      return this;
    }
    public APIRequestGetAgencies requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAgencies requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetAgencies requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetAgencies requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetAgencies requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAgencies requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAgencies requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetAgencies requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetAgencies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetAgencies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetAgencies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAgencies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAgencies requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAgencies requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAgencies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAgencies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetAgencies requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetAgencies requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateAgency extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
      "permitted_roles",
      "permitted_tasks",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateAgency.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAgency(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAgency setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAgency setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAgency setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateAgency setPermittedRoles (List<ProductCatalog.EnumPermittedRoles> permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }
    public APIRequestCreateAgency setPermittedRoles (String permittedRoles) {
      this.setParam("permitted_roles", permittedRoles);
      return this;
    }

    public APIRequestCreateAgency setPermittedTasks (List<ProductCatalog.EnumPermittedTasks> permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }
    public APIRequestCreateAgency setPermittedTasks (String permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }

    public APIRequestCreateAgency requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAgency requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAgency requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAgency requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAgency requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAgency requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAutomotiveModels extends APIRequest<AutomotiveModel> {

    APINodeList<AutomotiveModel> lastResponse = null;
    @Override
    public APINodeList<AutomotiveModel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "applinks",
      "automotive_model_id",
      "availability",
      "body_style",
      "currency",
      "custom_label_0",
      "description",
      "drivetrain",
      "exterior_color",
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
    public APINodeList<AutomotiveModel> parseResponse(String response) throws APIException {
      return AutomotiveModel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AutomotiveModel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AutomotiveModel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AutomotiveModel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AutomotiveModel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AutomotiveModel>>() {
           public APINodeList<AutomotiveModel> apply(String result) {
             try {
               return APIRequestGetAutomotiveModels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAutomotiveModels(String nodeId, APIContext context) {
      super(context, nodeId, "/automotive_models", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAutomotiveModels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAutomotiveModels setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetAutomotiveModels setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetAutomotiveModels setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetAutomotiveModels setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetAutomotiveModels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAutomotiveModels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAutomotiveModels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAutomotiveModels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAutomotiveModels requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetAutomotiveModels requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestAutomotiveModelIdField () {
      return this.requestAutomotiveModelIdField(true);
    }
    public APIRequestGetAutomotiveModels requestAutomotiveModelIdField (boolean value) {
      this.requestField("automotive_model_id", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetAutomotiveModels requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGetAutomotiveModels requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAutomotiveModels requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetAutomotiveModels requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAutomotiveModels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGetAutomotiveModels requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGetAutomotiveModels requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGetAutomotiveModels requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestGenerationField () {
      return this.requestGenerationField(true);
    }
    public APIRequestGetAutomotiveModels requestGenerationField (boolean value) {
      this.requestField("generation", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAutomotiveModels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetAutomotiveModels requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGetAutomotiveModels requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestInteriorUpholsteryField () {
      return this.requestInteriorUpholsteryField(true);
    }
    public APIRequestGetAutomotiveModels requestInteriorUpholsteryField (boolean value) {
      this.requestField("interior_upholstery", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGetAutomotiveModels requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGetAutomotiveModels requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetAutomotiveModels requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetAutomotiveModels requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAutomotiveModels requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGetAutomotiveModels requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGetAutomotiveModels requestTrimField (boolean value) {
      this.requestField("trim", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetAutomotiveModels requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetAutomotiveModels requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGetAutomotiveModels requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
    }
  }

  public static class APIRequestCreateBatch extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "requests",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/batch", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBatch setRequests (List<Map<String, String>> requests) {
      this.setParam("requests", requests);
      return this;
    }
    public APIRequestCreateBatch setRequests (String requests) {
      this.setParam("requests", requests);
      return this;
    }

    public APIRequestCreateBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCheckBatchRequestStatus extends APIRequest<CheckBatchRequestStatus> {

    APINodeList<CheckBatchRequestStatus> lastResponse = null;
    @Override
    public APINodeList<CheckBatchRequestStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "handle",
    };

    public static final String[] FIELDS = {
      "errors",
      "errors_total_count",
      "handle",
      "status",
      "id",
    };

    @Override
    public APINodeList<CheckBatchRequestStatus> parseResponse(String response) throws APIException {
      return CheckBatchRequestStatus.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CheckBatchRequestStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CheckBatchRequestStatus> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CheckBatchRequestStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CheckBatchRequestStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CheckBatchRequestStatus>>() {
           public APINodeList<CheckBatchRequestStatus> apply(String result) {
             try {
               return APIRequestGetCheckBatchRequestStatus.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCheckBatchRequestStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/check_batch_request_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCheckBatchRequestStatus setHandle (String handle) {
      this.setParam("handle", handle);
      return this;
    }

    public APIRequestGetCheckBatchRequestStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCheckBatchRequestStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCheckBatchRequestStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCheckBatchRequestStatus requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGetCheckBatchRequestStatus requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGetCheckBatchRequestStatus requestErrorsTotalCountField () {
      return this.requestErrorsTotalCountField(true);
    }
    public APIRequestGetCheckBatchRequestStatus requestErrorsTotalCountField (boolean value) {
      this.requestField("errors_total_count", value);
      return this;
    }
    public APIRequestGetCheckBatchRequestStatus requestHandleField () {
      return this.requestHandleField(true);
    }
    public APIRequestGetCheckBatchRequestStatus requestHandleField (boolean value) {
      this.requestField("handle", value);
      return this;
    }
    public APIRequestGetCheckBatchRequestStatus requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCheckBatchRequestStatus requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCheckBatchRequestStatus requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCheckBatchRequestStatus requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetDaEventSamples extends APIRequest<ProductDaEventSamplesBatch> {

    APINodeList<ProductDaEventSamplesBatch> lastResponse = null;
    @Override
    public APINodeList<ProductDaEventSamplesBatch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "source_id",
      "event",
      "aggregation_type",
    };

    public static final String[] FIELDS = {
      "samples",
      "time_start",
      "time_stop",
      "id",
    };

    @Override
    public APINodeList<ProductDaEventSamplesBatch> parseResponse(String response) throws APIException {
      return ProductDaEventSamplesBatch.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductDaEventSamplesBatch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductDaEventSamplesBatch> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductDaEventSamplesBatch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductDaEventSamplesBatch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductDaEventSamplesBatch>>() {
           public APINodeList<ProductDaEventSamplesBatch> apply(String result) {
             try {
               return APIRequestGetDaEventSamples.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDaEventSamples(String nodeId, APIContext context) {
      super(context, nodeId, "/da_event_samples", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDaEventSamples setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDaEventSamples setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDaEventSamples setSourceId (String sourceId) {
      this.setParam("source_id", sourceId);
      return this;
    }

    public APIRequestGetDaEventSamples setEvent (ProductDaEventSamplesBatch.EnumEvent event) {
      this.setParam("event", event);
      return this;
    }
    public APIRequestGetDaEventSamples setEvent (String event) {
      this.setParam("event", event);
      return this;
    }

    public APIRequestGetDaEventSamples setAggregationType (ProductDaEventSamplesBatch.EnumAggregationType aggregationType) {
      this.setParam("aggregation_type", aggregationType);
      return this;
    }
    public APIRequestGetDaEventSamples setAggregationType (String aggregationType) {
      this.setParam("aggregation_type", aggregationType);
      return this;
    }

    public APIRequestGetDaEventSamples requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDaEventSamples requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaEventSamples requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDaEventSamples requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaEventSamples requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDaEventSamples requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDaEventSamples requestSamplesField () {
      return this.requestSamplesField(true);
    }
    public APIRequestGetDaEventSamples requestSamplesField (boolean value) {
      this.requestField("samples", value);
      return this;
    }
    public APIRequestGetDaEventSamples requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGetDaEventSamples requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
      return this;
    }
    public APIRequestGetDaEventSamples requestTimeStopField () {
      return this.requestTimeStopField(true);
    }
    public APIRequestGetDaEventSamples requestTimeStopField (boolean value) {
      this.requestField("time_stop", value);
      return this;
    }
    public APIRequestGetDaEventSamples requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDaEventSamples requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetDestinations extends APIRequest<Destination> {

    APINodeList<Destination> lastResponse = null;
    @Override
    public APINodeList<Destination> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "currency",
      "description",
      "destination_id",
      "id",
      "images",
      "name",
      "price",
      "price_change",
      "sanitized_images",
      "types",
      "url",
    };

    @Override
    public APINodeList<Destination> parseResponse(String response) throws APIException {
      return Destination.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Destination> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Destination> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Destination>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Destination>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Destination>>() {
           public APINodeList<Destination> apply(String result) {
             try {
               return APIRequestGetDestinations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDestinations(String nodeId, APIContext context) {
      super(context, nodeId, "/destinations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDestinations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDestinations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDestinations setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetDestinations setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetDestinations setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetDestinations setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetDestinations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDestinations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDestinations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDestinations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDestinations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDestinations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDestinations requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetDestinations requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetDestinations requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetDestinations requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetDestinations requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetDestinations requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetDestinations requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDestinations requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDestinations requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGetDestinations requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGetDestinations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDestinations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDestinations requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetDestinations requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetDestinations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDestinations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDestinations requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetDestinations requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetDestinations requestPriceChangeField () {
      return this.requestPriceChangeField(true);
    }
    public APIRequestGetDestinations requestPriceChangeField (boolean value) {
      this.requestField("price_change", value);
      return this;
    }
    public APIRequestGetDestinations requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetDestinations requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetDestinations requestTypesField () {
      return this.requestTypesField(true);
    }
    public APIRequestGetDestinations requestTypesField (boolean value) {
      this.requestField("types", value);
      return this;
    }
    public APIRequestGetDestinations requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetDestinations requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestGetEventStats extends APIRequest<ProductEventStat> {

    APINodeList<ProductEventStat> lastResponse = null;
    @Override
    public APINodeList<ProductEventStat> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdowns",
    };

    public static final String[] FIELDS = {
      "date_start",
      "date_stop",
      "device_type",
      "event",
      "event_source",
      "total_content_ids_matched_other_catalogs",
      "total_matched_content_ids",
      "total_unmatched_content_ids",
      "unique_content_ids_matched_other_catalogs",
      "unique_matched_content_ids",
      "unique_unmatched_content_ids",
      "id",
    };

    @Override
    public APINodeList<ProductEventStat> parseResponse(String response) throws APIException {
      return ProductEventStat.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductEventStat> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductEventStat> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductEventStat>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductEventStat>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductEventStat>>() {
           public APINodeList<ProductEventStat> apply(String result) {
             try {
               return APIRequestGetEventStats.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEventStats(String nodeId, APIContext context) {
      super(context, nodeId, "/event_stats", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEventStats setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEventStats setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEventStats setBreakdowns (List<ProductEventStat.EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetEventStats setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetEventStats requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEventStats requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventStats requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEventStats requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventStats requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEventStats requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEventStats requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGetEventStats requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGetEventStats requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGetEventStats requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGetEventStats requestDeviceTypeField () {
      return this.requestDeviceTypeField(true);
    }
    public APIRequestGetEventStats requestDeviceTypeField (boolean value) {
      this.requestField("device_type", value);
      return this;
    }
    public APIRequestGetEventStats requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetEventStats requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetEventStats requestEventSourceField () {
      return this.requestEventSourceField(true);
    }
    public APIRequestGetEventStats requestEventSourceField (boolean value) {
      this.requestField("event_source", value);
      return this;
    }
    public APIRequestGetEventStats requestTotalContentIdsMatchedOtherCatalogsField () {
      return this.requestTotalContentIdsMatchedOtherCatalogsField(true);
    }
    public APIRequestGetEventStats requestTotalContentIdsMatchedOtherCatalogsField (boolean value) {
      this.requestField("total_content_ids_matched_other_catalogs", value);
      return this;
    }
    public APIRequestGetEventStats requestTotalMatchedContentIdsField () {
      return this.requestTotalMatchedContentIdsField(true);
    }
    public APIRequestGetEventStats requestTotalMatchedContentIdsField (boolean value) {
      this.requestField("total_matched_content_ids", value);
      return this;
    }
    public APIRequestGetEventStats requestTotalUnmatchedContentIdsField () {
      return this.requestTotalUnmatchedContentIdsField(true);
    }
    public APIRequestGetEventStats requestTotalUnmatchedContentIdsField (boolean value) {
      this.requestField("total_unmatched_content_ids", value);
      return this;
    }
    public APIRequestGetEventStats requestUniqueContentIdsMatchedOtherCatalogsField () {
      return this.requestUniqueContentIdsMatchedOtherCatalogsField(true);
    }
    public APIRequestGetEventStats requestUniqueContentIdsMatchedOtherCatalogsField (boolean value) {
      this.requestField("unique_content_ids_matched_other_catalogs", value);
      return this;
    }
    public APIRequestGetEventStats requestUniqueMatchedContentIdsField () {
      return this.requestUniqueMatchedContentIdsField(true);
    }
    public APIRequestGetEventStats requestUniqueMatchedContentIdsField (boolean value) {
      this.requestField("unique_matched_content_ids", value);
      return this;
    }
    public APIRequestGetEventStats requestUniqueUnmatchedContentIdsField () {
      return this.requestUniqueUnmatchedContentIdsField(true);
    }
    public APIRequestGetEventStats requestUniqueUnmatchedContentIdsField (boolean value) {
      this.requestField("unique_unmatched_content_ids", value);
      return this;
    }
    public APIRequestGetEventStats requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEventStats requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestDeleteExternalEventSources extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_event_sources",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteExternalEventSources.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteExternalEventSources(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteExternalEventSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteExternalEventSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteExternalEventSources setExternalEventSources (List<String> externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }
    public APIRequestDeleteExternalEventSources setExternalEventSources (String externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestDeleteExternalEventSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteExternalEventSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteExternalEventSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteExternalEventSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteExternalEventSources requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteExternalEventSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetExternalEventSources extends APIRequest<ExternalEventSource> {

    APINodeList<ExternalEventSource> lastResponse = null;
    @Override
    public APINodeList<ExternalEventSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "source_type",
    };

    @Override
    public APINodeList<ExternalEventSource> parseResponse(String response) throws APIException {
      return ExternalEventSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ExternalEventSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExternalEventSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExternalEventSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExternalEventSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ExternalEventSource>>() {
           public APINodeList<ExternalEventSource> apply(String result) {
             try {
               return APIRequestGetExternalEventSources.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetExternalEventSources(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExternalEventSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExternalEventSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExternalEventSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExternalEventSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalEventSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExternalEventSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExternalEventSources requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExternalEventSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExternalEventSources requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExternalEventSources requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExternalEventSources requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetExternalEventSources requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetExternalEventSources requestSourceTypeField () {
      return this.requestSourceTypeField(true);
    }
    public APIRequestGetExternalEventSources requestSourceTypeField (boolean value) {
      this.requestField("source_type", value);
      return this;
    }
  }

  public static class APIRequestCreateExternalEventSource extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_event_sources",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateExternalEventSource.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateExternalEventSource(String nodeId, APIContext context) {
      super(context, nodeId, "/external_event_sources", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateExternalEventSource setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateExternalEventSource setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExternalEventSource setExternalEventSources (List<String> externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }
    public APIRequestCreateExternalEventSource setExternalEventSources (String externalEventSources) {
      this.setParam("external_event_sources", externalEventSources);
      return this;
    }

    public APIRequestCreateExternalEventSource requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExternalEventSource requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExternalEventSource requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateExternalEventSource requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExternalEventSource requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateExternalEventSource requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetFlights extends APIRequest<Flight> {

    APINodeList<Flight> lastResponse = null;
    @Override
    public APINodeList<Flight> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "applinks",
      "currency",
      "description",
      "destination_airport",
      "destination_city",
      "flight_id",
      "id",
      "images",
      "oneway_currency",
      "oneway_price",
      "origin_airport",
      "origin_city",
      "price",
      "sanitized_images",
      "url",
    };

    @Override
    public APINodeList<Flight> parseResponse(String response) throws APIException {
      return Flight.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Flight> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Flight> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Flight>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Flight>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Flight>>() {
           public APINodeList<Flight> apply(String result) {
             try {
               return APIRequestGetFlights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetFlights(String nodeId, APIContext context) {
      super(context, nodeId, "/flights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFlights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFlights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFlights setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetFlights setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetFlights setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetFlights setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetFlights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFlights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFlights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFlights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetFlights requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetFlights requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetFlights requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetFlights requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetFlights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetFlights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetFlights requestDestinationAirportField () {
      return this.requestDestinationAirportField(true);
    }
    public APIRequestGetFlights requestDestinationAirportField (boolean value) {
      this.requestField("destination_airport", value);
      return this;
    }
    public APIRequestGetFlights requestDestinationCityField () {
      return this.requestDestinationCityField(true);
    }
    public APIRequestGetFlights requestDestinationCityField (boolean value) {
      this.requestField("destination_city", value);
      return this;
    }
    public APIRequestGetFlights requestFlightIdField () {
      return this.requestFlightIdField(true);
    }
    public APIRequestGetFlights requestFlightIdField (boolean value) {
      this.requestField("flight_id", value);
      return this;
    }
    public APIRequestGetFlights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetFlights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetFlights requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetFlights requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetFlights requestOnewayCurrencyField () {
      return this.requestOnewayCurrencyField(true);
    }
    public APIRequestGetFlights requestOnewayCurrencyField (boolean value) {
      this.requestField("oneway_currency", value);
      return this;
    }
    public APIRequestGetFlights requestOnewayPriceField () {
      return this.requestOnewayPriceField(true);
    }
    public APIRequestGetFlights requestOnewayPriceField (boolean value) {
      this.requestField("oneway_price", value);
      return this;
    }
    public APIRequestGetFlights requestOriginAirportField () {
      return this.requestOriginAirportField(true);
    }
    public APIRequestGetFlights requestOriginAirportField (boolean value) {
      this.requestField("origin_airport", value);
      return this;
    }
    public APIRequestGetFlights requestOriginCityField () {
      return this.requestOriginCityField(true);
    }
    public APIRequestGetFlights requestOriginCityField (boolean value) {
      this.requestField("origin_city", value);
      return this;
    }
    public APIRequestGetFlights requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetFlights requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetFlights requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetFlights requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetFlights requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetFlights requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestCreateFlight extends APIRequest<Flight> {

    Flight lastResponse = null;
    @Override
    public Flight getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "images",
      "origin_airport",
      "destination_airport",
      "description",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Flight parseResponse(String response) throws APIException {
      return Flight.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Flight execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Flight execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Flight> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Flight> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Flight>() {
           public Flight apply(String result) {
             try {
               return APIRequestCreateFlight.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateFlight(String nodeId, APIContext context) {
      super(context, nodeId, "/flights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateFlight setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateFlight setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateFlight setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestCreateFlight setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestCreateFlight setOriginAirport (String originAirport) {
      this.setParam("origin_airport", originAirport);
      return this;
    }

    public APIRequestCreateFlight setDestinationAirport (String destinationAirport) {
      this.setParam("destination_airport", destinationAirport);
      return this;
    }

    public APIRequestCreateFlight setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateFlight setUrl (Object url) {
      this.setParam("url", url);
      return this;
    }
    public APIRequestCreateFlight setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateFlight requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateFlight requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFlight requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateFlight requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFlight requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateFlight requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetHomeListings extends APIRequest<HomeListing> {

    APINodeList<HomeListing> lastResponse = null;
    @Override
    public APINodeList<HomeListing> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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
      "url",
      "year_built",
    };

    @Override
    public APINodeList<HomeListing> parseResponse(String response) throws APIException {
      return HomeListing.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<HomeListing> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<HomeListing> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<HomeListing>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<HomeListing>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<HomeListing>>() {
           public APINodeList<HomeListing> apply(String result) {
             try {
               return APIRequestGetHomeListings.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetHomeListings(String nodeId, APIContext context) {
      super(context, nodeId, "/home_listings", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHomeListings setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHomeListings setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHomeListings setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetHomeListings setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetHomeListings setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetHomeListings setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetHomeListings requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHomeListings requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHomeListings requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHomeListings requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHomeListings requestAcTypeField () {
      return this.requestAcTypeField(true);
    }
    public APIRequestGetHomeListings requestAcTypeField (boolean value) {
      this.requestField("ac_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestAdditionalFeesDescriptionField () {
      return this.requestAdditionalFeesDescriptionField(true);
    }
    public APIRequestGetHomeListings requestAdditionalFeesDescriptionField (boolean value) {
      this.requestField("additional_fees_description", value);
      return this;
    }
    public APIRequestGetHomeListings requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetHomeListings requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentCompanyField () {
      return this.requestAgentCompanyField(true);
    }
    public APIRequestGetHomeListings requestAgentCompanyField (boolean value) {
      this.requestField("agent_company", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentEmailField () {
      return this.requestAgentEmailField(true);
    }
    public APIRequestGetHomeListings requestAgentEmailField (boolean value) {
      this.requestField("agent_email", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentFbPageIdField () {
      return this.requestAgentFbPageIdField(true);
    }
    public APIRequestGetHomeListings requestAgentFbPageIdField (boolean value) {
      this.requestField("agent_fb_page_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentNameField () {
      return this.requestAgentNameField(true);
    }
    public APIRequestGetHomeListings requestAgentNameField (boolean value) {
      this.requestField("agent_name", value);
      return this;
    }
    public APIRequestGetHomeListings requestAgentPhoneField () {
      return this.requestAgentPhoneField(true);
    }
    public APIRequestGetHomeListings requestAgentPhoneField (boolean value) {
      this.requestField("agent_phone", value);
      return this;
    }
    public APIRequestGetHomeListings requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetHomeListings requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetHomeListings requestAreaSizeField () {
      return this.requestAreaSizeField(true);
    }
    public APIRequestGetHomeListings requestAreaSizeField (boolean value) {
      this.requestField("area_size", value);
      return this;
    }
    public APIRequestGetHomeListings requestAreaUnitField () {
      return this.requestAreaUnitField(true);
    }
    public APIRequestGetHomeListings requestAreaUnitField (boolean value) {
      this.requestField("area_unit", value);
      return this;
    }
    public APIRequestGetHomeListings requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetHomeListings requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetHomeListings requestCo2EmissionRatingEuField () {
      return this.requestCo2EmissionRatingEuField(true);
    }
    public APIRequestGetHomeListings requestCo2EmissionRatingEuField (boolean value) {
      this.requestField("co_2_emission_rating_eu", value);
      return this;
    }
    public APIRequestGetHomeListings requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetHomeListings requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestDaysOnMarketField () {
      return this.requestDaysOnMarketField(true);
    }
    public APIRequestGetHomeListings requestDaysOnMarketField (boolean value) {
      this.requestField("days_on_market", value);
      return this;
    }
    public APIRequestGetHomeListings requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetHomeListings requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetHomeListings requestEnergyRatingEuField () {
      return this.requestEnergyRatingEuField(true);
    }
    public APIRequestGetHomeListings requestEnergyRatingEuField (boolean value) {
      this.requestField("energy_rating_eu", value);
      return this;
    }
    public APIRequestGetHomeListings requestFurnishTypeField () {
      return this.requestFurnishTypeField(true);
    }
    public APIRequestGetHomeListings requestFurnishTypeField (boolean value) {
      this.requestField("furnish_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestGroupIdField () {
      return this.requestGroupIdField(true);
    }
    public APIRequestGetHomeListings requestGroupIdField (boolean value) {
      this.requestField("group_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestHeatingTypeField () {
      return this.requestHeatingTypeField(true);
    }
    public APIRequestGetHomeListings requestHeatingTypeField (boolean value) {
      this.requestField("heating_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestHomeListingIdField () {
      return this.requestHomeListingIdField(true);
    }
    public APIRequestGetHomeListings requestHomeListingIdField (boolean value) {
      this.requestField("home_listing_id", value);
      return this;
    }
    public APIRequestGetHomeListings requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHomeListings requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetHomeListings requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetHomeListings requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetHomeListings requestLaundryTypeField () {
      return this.requestLaundryTypeField(true);
    }
    public APIRequestGetHomeListings requestLaundryTypeField (boolean value) {
      this.requestField("laundry_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestListingTypeField () {
      return this.requestListingTypeField(true);
    }
    public APIRequestGetHomeListings requestListingTypeField (boolean value) {
      this.requestField("listing_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestMaxCurrencyField () {
      return this.requestMaxCurrencyField(true);
    }
    public APIRequestGetHomeListings requestMaxCurrencyField (boolean value) {
      this.requestField("max_currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestMaxPriceField () {
      return this.requestMaxPriceField(true);
    }
    public APIRequestGetHomeListings requestMaxPriceField (boolean value) {
      this.requestField("max_price", value);
      return this;
    }
    public APIRequestGetHomeListings requestMinCurrencyField () {
      return this.requestMinCurrencyField(true);
    }
    public APIRequestGetHomeListings requestMinCurrencyField (boolean value) {
      this.requestField("min_currency", value);
      return this;
    }
    public APIRequestGetHomeListings requestMinPriceField () {
      return this.requestMinPriceField(true);
    }
    public APIRequestGetHomeListings requestMinPriceField (boolean value) {
      this.requestField("min_price", value);
      return this;
    }
    public APIRequestGetHomeListings requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetHomeListings requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumBathsField () {
      return this.requestNumBathsField(true);
    }
    public APIRequestGetHomeListings requestNumBathsField (boolean value) {
      this.requestField("num_baths", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumBedsField () {
      return this.requestNumBedsField(true);
    }
    public APIRequestGetHomeListings requestNumBedsField (boolean value) {
      this.requestField("num_beds", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumRoomsField () {
      return this.requestNumRoomsField(true);
    }
    public APIRequestGetHomeListings requestNumRoomsField (boolean value) {
      this.requestField("num_rooms", value);
      return this;
    }
    public APIRequestGetHomeListings requestNumUnitsField () {
      return this.requestNumUnitsField(true);
    }
    public APIRequestGetHomeListings requestNumUnitsField (boolean value) {
      this.requestField("num_units", value);
      return this;
    }
    public APIRequestGetHomeListings requestParkingTypeField () {
      return this.requestParkingTypeField(true);
    }
    public APIRequestGetHomeListings requestParkingTypeField (boolean value) {
      this.requestField("parking_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestPartnerVerificationField () {
      return this.requestPartnerVerificationField(true);
    }
    public APIRequestGetHomeListings requestPartnerVerificationField (boolean value) {
      this.requestField("partner_verification", value);
      return this;
    }
    public APIRequestGetHomeListings requestPetPolicyField () {
      return this.requestPetPolicyField(true);
    }
    public APIRequestGetHomeListings requestPetPolicyField (boolean value) {
      this.requestField("pet_policy", value);
      return this;
    }
    public APIRequestGetHomeListings requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetHomeListings requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetHomeListings requestPropertyTypeField () {
      return this.requestPropertyTypeField(true);
    }
    public APIRequestGetHomeListings requestPropertyTypeField (boolean value) {
      this.requestField("property_type", value);
      return this;
    }
    public APIRequestGetHomeListings requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetHomeListings requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetHomeListings requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetHomeListings requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetHomeListings requestYearBuiltField () {
      return this.requestYearBuiltField(true);
    }
    public APIRequestGetHomeListings requestYearBuiltField (boolean value) {
      this.requestField("year_built", value);
      return this;
    }
  }

  public static class APIRequestCreateHomeListing extends APIRequest<HomeListing> {

    HomeListing lastResponse = null;
    @Override
    public HomeListing getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "home_listing_id",
      "address",
      "availability",
      "images",
      "name",
      "currency",
      "price",
      "url",
      "year_built",
      "description",
      "listing_type",
      "num_baths",
      "num_beds",
      "num_units",
      "property_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public HomeListing parseResponse(String response) throws APIException {
      return HomeListing.parseResponse(response, getContext(), this).head();
    }

    @Override
    public HomeListing execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public HomeListing execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<HomeListing> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<HomeListing> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, HomeListing>() {
           public HomeListing apply(String result) {
             try {
               return APIRequestCreateHomeListing.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateHomeListing(String nodeId, APIContext context) {
      super(context, nodeId, "/home_listings", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateHomeListing setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateHomeListing setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateHomeListing setHomeListingId (String homeListingId) {
      this.setParam("home_listing_id", homeListingId);
      return this;
    }

    public APIRequestCreateHomeListing setAddress (Object address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestCreateHomeListing setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestCreateHomeListing setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestCreateHomeListing setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestCreateHomeListing setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestCreateHomeListing setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateHomeListing setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateHomeListing setPrice (Double price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestCreateHomeListing setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestCreateHomeListing setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateHomeListing setYearBuilt (Long yearBuilt) {
      this.setParam("year_built", yearBuilt);
      return this;
    }
    public APIRequestCreateHomeListing setYearBuilt (String yearBuilt) {
      this.setParam("year_built", yearBuilt);
      return this;
    }

    public APIRequestCreateHomeListing setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateHomeListing setListingType (String listingType) {
      this.setParam("listing_type", listingType);
      return this;
    }

    public APIRequestCreateHomeListing setNumBaths (Double numBaths) {
      this.setParam("num_baths", numBaths);
      return this;
    }
    public APIRequestCreateHomeListing setNumBaths (String numBaths) {
      this.setParam("num_baths", numBaths);
      return this;
    }

    public APIRequestCreateHomeListing setNumBeds (Double numBeds) {
      this.setParam("num_beds", numBeds);
      return this;
    }
    public APIRequestCreateHomeListing setNumBeds (String numBeds) {
      this.setParam("num_beds", numBeds);
      return this;
    }

    public APIRequestCreateHomeListing setNumUnits (Double numUnits) {
      this.setParam("num_units", numUnits);
      return this;
    }
    public APIRequestCreateHomeListing setNumUnits (String numUnits) {
      this.setParam("num_units", numUnits);
      return this;
    }

    public APIRequestCreateHomeListing setPropertyType (String propertyType) {
      this.setParam("property_type", propertyType);
      return this;
    }

    public APIRequestCreateHomeListing requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateHomeListing requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHomeListing requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateHomeListing requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHomeListing requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateHomeListing requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetHotelRoomsBatch extends APIRequest<ProductCatalogHotelRoomsBatch> {

    APINodeList<ProductCatalogHotelRoomsBatch> lastResponse = null;
    @Override
    public APINodeList<ProductCatalogHotelRoomsBatch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "handle",
    };

    public static final String[] FIELDS = {
      "errors",
      "errors_total_count",
      "handle",
      "status",
      "id",
    };

    @Override
    public APINodeList<ProductCatalogHotelRoomsBatch> parseResponse(String response) throws APIException {
      return ProductCatalogHotelRoomsBatch.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalogHotelRoomsBatch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalogHotelRoomsBatch> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalogHotelRoomsBatch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalogHotelRoomsBatch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalogHotelRoomsBatch>>() {
           public APINodeList<ProductCatalogHotelRoomsBatch> apply(String result) {
             try {
               return APIRequestGetHotelRoomsBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetHotelRoomsBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/hotel_rooms_batch", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHotelRoomsBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHotelRoomsBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHotelRoomsBatch setHandle (String handle) {
      this.setParam("handle", handle);
      return this;
    }

    public APIRequestGetHotelRoomsBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHotelRoomsBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotelRoomsBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHotelRoomsBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotelRoomsBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHotelRoomsBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHotelRoomsBatch requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGetHotelRoomsBatch requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGetHotelRoomsBatch requestErrorsTotalCountField () {
      return this.requestErrorsTotalCountField(true);
    }
    public APIRequestGetHotelRoomsBatch requestErrorsTotalCountField (boolean value) {
      this.requestField("errors_total_count", value);
      return this;
    }
    public APIRequestGetHotelRoomsBatch requestHandleField () {
      return this.requestHandleField(true);
    }
    public APIRequestGetHotelRoomsBatch requestHandleField (boolean value) {
      this.requestField("handle", value);
      return this;
    }
    public APIRequestGetHotelRoomsBatch requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetHotelRoomsBatch requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetHotelRoomsBatch requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHotelRoomsBatch requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateHotelRoomsBatch extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "password",
      "standard",
      "url",
      "username",
      "update_only",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateHotelRoomsBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateHotelRoomsBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/hotel_rooms_batch", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateHotelRoomsBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateHotelRoomsBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setPassword (String password) {
      this.setParam("password", password);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setStandard (ProductCatalog.EnumStandard standard) {
      this.setParam("standard", standard);
      return this;
    }
    public APIRequestCreateHotelRoomsBatch setStandard (String standard) {
      this.setParam("standard", standard);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setUsername (String username) {
      this.setParam("username", username);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setUpdateOnly (Boolean updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }
    public APIRequestCreateHotelRoomsBatch setUpdateOnly (String updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateHotelRoomsBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotelRoomsBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateHotelRoomsBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotelRoomsBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateHotelRoomsBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetHotels extends APIRequest<Hotel> {

    APINodeList<Hotel> lastResponse = null;
    @Override
    public APINodeList<Hotel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "brand",
      "currency",
      "description",
      "guest_ratings",
      "hotel_id",
      "id",
      "images",
      "lowest_base_price",
      "loyalty_program",
      "margin_level",
      "name",
      "phone",
      "sanitized_images",
      "star_rating",
      "url",
    };

    @Override
    public APINodeList<Hotel> parseResponse(String response) throws APIException {
      return Hotel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Hotel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Hotel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Hotel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Hotel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Hotel>>() {
           public APINodeList<Hotel> apply(String result) {
             try {
               return APIRequestGetHotels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetHotels(String nodeId, APIContext context) {
      super(context, nodeId, "/hotels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHotels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHotels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHotels setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetHotels setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetHotels setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetHotels setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetHotels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHotels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHotels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHotels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHotels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHotels requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetHotels requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetHotels requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetHotels requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetHotels requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGetHotels requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGetHotels requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetHotels requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetHotels requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetHotels requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetHotels requestGuestRatingsField () {
      return this.requestGuestRatingsField(true);
    }
    public APIRequestGetHotels requestGuestRatingsField (boolean value) {
      this.requestField("guest_ratings", value);
      return this;
    }
    public APIRequestGetHotels requestHotelIdField () {
      return this.requestHotelIdField(true);
    }
    public APIRequestGetHotels requestHotelIdField (boolean value) {
      this.requestField("hotel_id", value);
      return this;
    }
    public APIRequestGetHotels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHotels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetHotels requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetHotels requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetHotels requestLowestBasePriceField () {
      return this.requestLowestBasePriceField(true);
    }
    public APIRequestGetHotels requestLowestBasePriceField (boolean value) {
      this.requestField("lowest_base_price", value);
      return this;
    }
    public APIRequestGetHotels requestLoyaltyProgramField () {
      return this.requestLoyaltyProgramField(true);
    }
    public APIRequestGetHotels requestLoyaltyProgramField (boolean value) {
      this.requestField("loyalty_program", value);
      return this;
    }
    public APIRequestGetHotels requestMarginLevelField () {
      return this.requestMarginLevelField(true);
    }
    public APIRequestGetHotels requestMarginLevelField (boolean value) {
      this.requestField("margin_level", value);
      return this;
    }
    public APIRequestGetHotels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetHotels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetHotels requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetHotels requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetHotels requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetHotels requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetHotels requestStarRatingField () {
      return this.requestStarRatingField(true);
    }
    public APIRequestGetHotels requestStarRatingField (boolean value) {
      this.requestField("star_rating", value);
      return this;
    }
    public APIRequestGetHotels requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetHotels requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestCreateHotel extends APIRequest<Hotel> {

    Hotel lastResponse = null;
    @Override
    public Hotel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hotel_id",
      "address",
      "brand",
      "description",
      "name",
      "url",
      "images",
      "currency",
      "base_price",
      "applinks",
      "phone",
      "star_rating",
      "guest_ratings",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Hotel parseResponse(String response) throws APIException {
      return Hotel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Hotel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Hotel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Hotel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Hotel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Hotel>() {
           public Hotel apply(String result) {
             try {
               return APIRequestCreateHotel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateHotel(String nodeId, APIContext context) {
      super(context, nodeId, "/hotels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateHotel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateHotel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateHotel setHotelId (String hotelId) {
      this.setParam("hotel_id", hotelId);
      return this;
    }

    public APIRequestCreateHotel setAddress (Object address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestCreateHotel setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestCreateHotel setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestCreateHotel setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateHotel setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateHotel setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateHotel setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestCreateHotel setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestCreateHotel setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateHotel setBasePrice (Long basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }
    public APIRequestCreateHotel setBasePrice (String basePrice) {
      this.setParam("base_price", basePrice);
      return this;
    }

    public APIRequestCreateHotel setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestCreateHotel setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestCreateHotel setPhone (String phone) {
      this.setParam("phone", phone);
      return this;
    }

    public APIRequestCreateHotel setStarRating (Double starRating) {
      this.setParam("star_rating", starRating);
      return this;
    }
    public APIRequestCreateHotel setStarRating (String starRating) {
      this.setParam("star_rating", starRating);
      return this;
    }

    public APIRequestCreateHotel setGuestRatings (List<Object> guestRatings) {
      this.setParam("guest_ratings", guestRatings);
      return this;
    }
    public APIRequestCreateHotel setGuestRatings (String guestRatings) {
      this.setParam("guest_ratings", guestRatings);
      return this;
    }

    public APIRequestCreateHotel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateHotel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateHotel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHotel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateHotel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPricingVariablesBatch extends APIRequest<ProductCatalogPricingVariablesBatch> {

    APINodeList<ProductCatalogPricingVariablesBatch> lastResponse = null;
    @Override
    public APINodeList<ProductCatalogPricingVariablesBatch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "handle",
    };

    public static final String[] FIELDS = {
      "errors",
      "errors_total_count",
      "handle",
      "status",
      "id",
    };

    @Override
    public APINodeList<ProductCatalogPricingVariablesBatch> parseResponse(String response) throws APIException {
      return ProductCatalogPricingVariablesBatch.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalogPricingVariablesBatch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalogPricingVariablesBatch> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalogPricingVariablesBatch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalogPricingVariablesBatch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalogPricingVariablesBatch>>() {
           public APINodeList<ProductCatalogPricingVariablesBatch> apply(String result) {
             try {
               return APIRequestGetPricingVariablesBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPricingVariablesBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/pricing_variables_batch", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPricingVariablesBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPricingVariablesBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPricingVariablesBatch setHandle (String handle) {
      this.setParam("handle", handle);
      return this;
    }

    public APIRequestGetPricingVariablesBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPricingVariablesBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPricingVariablesBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPricingVariablesBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPricingVariablesBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPricingVariablesBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPricingVariablesBatch requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGetPricingVariablesBatch requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGetPricingVariablesBatch requestErrorsTotalCountField () {
      return this.requestErrorsTotalCountField(true);
    }
    public APIRequestGetPricingVariablesBatch requestErrorsTotalCountField (boolean value) {
      this.requestField("errors_total_count", value);
      return this;
    }
    public APIRequestGetPricingVariablesBatch requestHandleField () {
      return this.requestHandleField(true);
    }
    public APIRequestGetPricingVariablesBatch requestHandleField (boolean value) {
      this.requestField("handle", value);
      return this;
    }
    public APIRequestGetPricingVariablesBatch requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPricingVariablesBatch requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPricingVariablesBatch requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPricingVariablesBatch requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreatePricingVariablesBatch extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "password",
      "standard",
      "url",
      "username",
      "update_only",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreatePricingVariablesBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePricingVariablesBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/pricing_variables_batch", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePricingVariablesBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePricingVariablesBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setPassword (String password) {
      this.setParam("password", password);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setStandard (ProductCatalog.EnumStandard standard) {
      this.setParam("standard", standard);
      return this;
    }
    public APIRequestCreatePricingVariablesBatch setStandard (String standard) {
      this.setParam("standard", standard);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setUsername (String username) {
      this.setParam("username", username);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setUpdateOnly (Boolean updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }
    public APIRequestCreatePricingVariablesBatch setUpdateOnly (String updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePricingVariablesBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePricingVariablesBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePricingVariablesBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePricingVariablesBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePricingVariablesBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductFeeds extends APIRequest<ProductFeed> {

    APINodeList<ProductFeed> lastResponse = null;
    @Override
    public APINodeList<ProductFeed> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "country",
      "created_time",
      "default_currency",
      "deletion_enabled",
      "delimiter",
      "encoding",
      "file_name",
      "id",
      "latest_upload",
      "name",
      "override_type",
      "product_count",
      "qualified_product_count",
      "quoted_fields",
      "quoted_fields_mode",
      "schedule",
      "update_schedule",
    };

    @Override
    public APINodeList<ProductFeed> parseResponse(String response) throws APIException {
      return ProductFeed.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductFeed> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeed> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductFeed>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductFeed>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductFeed>>() {
           public APINodeList<ProductFeed> apply(String result) {
             try {
               return APIRequestGetProductFeeds.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProductFeeds(String nodeId, APIContext context) {
      super(context, nodeId, "/product_feeds", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductFeeds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductFeeds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductFeeds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductFeeds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductFeeds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductFeeds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductFeeds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductFeeds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductFeeds requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetProductFeeds requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetProductFeeds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetProductFeeds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetProductFeeds requestDefaultCurrencyField () {
      return this.requestDefaultCurrencyField(true);
    }
    public APIRequestGetProductFeeds requestDefaultCurrencyField (boolean value) {
      this.requestField("default_currency", value);
      return this;
    }
    public APIRequestGetProductFeeds requestDeletionEnabledField () {
      return this.requestDeletionEnabledField(true);
    }
    public APIRequestGetProductFeeds requestDeletionEnabledField (boolean value) {
      this.requestField("deletion_enabled", value);
      return this;
    }
    public APIRequestGetProductFeeds requestDelimiterField () {
      return this.requestDelimiterField(true);
    }
    public APIRequestGetProductFeeds requestDelimiterField (boolean value) {
      this.requestField("delimiter", value);
      return this;
    }
    public APIRequestGetProductFeeds requestEncodingField () {
      return this.requestEncodingField(true);
    }
    public APIRequestGetProductFeeds requestEncodingField (boolean value) {
      this.requestField("encoding", value);
      return this;
    }
    public APIRequestGetProductFeeds requestFileNameField () {
      return this.requestFileNameField(true);
    }
    public APIRequestGetProductFeeds requestFileNameField (boolean value) {
      this.requestField("file_name", value);
      return this;
    }
    public APIRequestGetProductFeeds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductFeeds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductFeeds requestLatestUploadField () {
      return this.requestLatestUploadField(true);
    }
    public APIRequestGetProductFeeds requestLatestUploadField (boolean value) {
      this.requestField("latest_upload", value);
      return this;
    }
    public APIRequestGetProductFeeds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductFeeds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductFeeds requestOverrideTypeField () {
      return this.requestOverrideTypeField(true);
    }
    public APIRequestGetProductFeeds requestOverrideTypeField (boolean value) {
      this.requestField("override_type", value);
      return this;
    }
    public APIRequestGetProductFeeds requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductFeeds requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetProductFeeds requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetProductFeeds requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
      return this;
    }
    public APIRequestGetProductFeeds requestQuotedFieldsField () {
      return this.requestQuotedFieldsField(true);
    }
    public APIRequestGetProductFeeds requestQuotedFieldsField (boolean value) {
      this.requestField("quoted_fields", value);
      return this;
    }
    public APIRequestGetProductFeeds requestQuotedFieldsModeField () {
      return this.requestQuotedFieldsModeField(true);
    }
    public APIRequestGetProductFeeds requestQuotedFieldsModeField (boolean value) {
      this.requestField("quoted_fields_mode", value);
      return this;
    }
    public APIRequestGetProductFeeds requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetProductFeeds requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetProductFeeds requestUpdateScheduleField () {
      return this.requestUpdateScheduleField(true);
    }
    public APIRequestGetProductFeeds requestUpdateScheduleField (boolean value) {
      this.requestField("update_schedule", value);
      return this;
    }
  }

  public static class APIRequestCreateProductFeed extends APIRequest<ProductFeed> {

    ProductFeed lastResponse = null;
    @Override
    public ProductFeed getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "default_currency",
      "delimiter",
      "encoding",
      "name",
      "quoted_fields_mode",
      "schedule",
      "update_schedule",
      "country",
      "deletion_enabled",
      "feed_type",
      "file_name",
      "quoted_fields",
      "rules",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductFeed parseResponse(String response) throws APIException {
      return ProductFeed.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductFeed execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeed execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductFeed> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductFeed> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductFeed>() {
           public ProductFeed apply(String result) {
             try {
               return APIRequestCreateProductFeed.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/product_feeds", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductFeed setDefaultCurrency (String defaultCurrency) {
      this.setParam("default_currency", defaultCurrency);
      return this;
    }

    public APIRequestCreateProductFeed setDelimiter (ProductFeed.EnumDelimiter delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }
    public APIRequestCreateProductFeed setDelimiter (String delimiter) {
      this.setParam("delimiter", delimiter);
      return this;
    }

    public APIRequestCreateProductFeed setEncoding (ProductFeed.EnumEncoding encoding) {
      this.setParam("encoding", encoding);
      return this;
    }
    public APIRequestCreateProductFeed setEncoding (String encoding) {
      this.setParam("encoding", encoding);
      return this;
    }

    public APIRequestCreateProductFeed setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateProductFeed setQuotedFieldsMode (ProductFeed.EnumQuotedFieldsMode quotedFieldsMode) {
      this.setParam("quoted_fields_mode", quotedFieldsMode);
      return this;
    }
    public APIRequestCreateProductFeed setQuotedFieldsMode (String quotedFieldsMode) {
      this.setParam("quoted_fields_mode", quotedFieldsMode);
      return this;
    }

    public APIRequestCreateProductFeed setSchedule (String schedule) {
      this.setParam("schedule", schedule);
      return this;
    }

    public APIRequestCreateProductFeed setUpdateSchedule (String updateSchedule) {
      this.setParam("update_schedule", updateSchedule);
      return this;
    }

    public APIRequestCreateProductFeed setCountry (String country) {
      this.setParam("country", country);
      return this;
    }

    public APIRequestCreateProductFeed setDeletionEnabled (Boolean deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
      return this;
    }
    public APIRequestCreateProductFeed setDeletionEnabled (String deletionEnabled) {
      this.setParam("deletion_enabled", deletionEnabled);
      return this;
    }

    public APIRequestCreateProductFeed setFeedType (ProductFeed.EnumFeedType feedType) {
      this.setParam("feed_type", feedType);
      return this;
    }
    public APIRequestCreateProductFeed setFeedType (String feedType) {
      this.setParam("feed_type", feedType);
      return this;
    }

    public APIRequestCreateProductFeed setFileName (String fileName) {
      this.setParam("file_name", fileName);
      return this;
    }

    public APIRequestCreateProductFeed setQuotedFields (Boolean quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }
    public APIRequestCreateProductFeed setQuotedFields (String quotedFields) {
      this.setParam("quoted_fields", quotedFields);
      return this;
    }

    public APIRequestCreateProductFeed setRules (List<String> rules) {
      this.setParam("rules", rules);
      return this;
    }
    public APIRequestCreateProductFeed setRules (String rules) {
      this.setParam("rules", rules);
      return this;
    }

    public APIRequestCreateProductFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductGroups extends APIRequest<ProductGroup> {

    APINodeList<ProductGroup> lastResponse = null;
    @Override
    public APINodeList<ProductGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "product_catalog",
      "retailer_id",
      "variants",
    };

    @Override
    public APINodeList<ProductGroup> parseResponse(String response) throws APIException {
      return ProductGroup.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductGroup> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductGroup>>() {
           public APINodeList<ProductGroup> apply(String result) {
             try {
               return APIRequestGetProductGroups.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProductGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/product_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductGroups requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetProductGroups requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGetProductGroups requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetProductGroups requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetProductGroups requestVariantsField () {
      return this.requestVariantsField(true);
    }
    public APIRequestGetProductGroups requestVariantsField (boolean value) {
      this.requestField("variants", value);
      return this;
    }
  }

  public static class APIRequestCreateProductGroup extends APIRequest<ProductGroup> {

    ProductGroup lastResponse = null;
    @Override
    public ProductGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "retailer_id",
      "variants",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductGroup parseResponse(String response) throws APIException {
      return ProductGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductGroup> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductGroup> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductGroup>() {
           public ProductGroup apply(String result) {
             try {
               return APIRequestCreateProductGroup.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/product_groups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductGroup setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
      return this;
    }

    public APIRequestCreateProductGroup setVariants (List<Object> variants) {
      this.setParam("variants", variants);
      return this;
    }
    public APIRequestCreateProductGroup setVariants (String variants) {
      this.setParam("variants", variants);
      return this;
    }

    public APIRequestCreateProductGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "parent_id",
      "ancestor_id",
      "has_children",
      "retailer_id",
    };

    public static final String[] FIELDS = {
      "auto_creation_url",
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

    public ListenableFuture<APINodeList<ProductSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductSet>>() {
           public APINodeList<ProductSet> apply(String result) {
             try {
               return APIRequestGetProductSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetProductSets setParentId (String parentId) {
      this.setParam("parent_id", parentId);
      return this;
    }

    public APIRequestGetProductSets setAncestorId (String ancestorId) {
      this.setParam("ancestor_id", ancestorId);
      return this;
    }

    public APIRequestGetProductSets setHasChildren (Boolean hasChildren) {
      this.setParam("has_children", hasChildren);
      return this;
    }
    public APIRequestGetProductSets setHasChildren (String hasChildren) {
      this.setParam("has_children", hasChildren);
      return this;
    }

    public APIRequestGetProductSets setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
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

  public static class APIRequestCreateProductSet extends APIRequest<ProductSet> {

    ProductSet lastResponse = null;
    @Override
    public ProductSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductSet parseResponse(String response) throws APIException {
      return ProductSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductSet>() {
           public ProductSet apply(String result) {
             try {
               return APIRequestCreateProductSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductSet(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductSet setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestCreateProductSet setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestCreateProductSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateProductSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductSetsBatch extends APIRequest<ProductCatalogProductSetsBatch> {

    APINodeList<ProductCatalogProductSetsBatch> lastResponse = null;
    @Override
    public APINodeList<ProductCatalogProductSetsBatch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "handle",
    };

    public static final String[] FIELDS = {
      "errors",
      "errors_total_count",
      "handle",
      "status",
      "id",
    };

    @Override
    public APINodeList<ProductCatalogProductSetsBatch> parseResponse(String response) throws APIException {
      return ProductCatalogProductSetsBatch.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalogProductSetsBatch> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalogProductSetsBatch> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalogProductSetsBatch>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalogProductSetsBatch>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalogProductSetsBatch>>() {
           public APINodeList<ProductCatalogProductSetsBatch> apply(String result) {
             try {
               return APIRequestGetProductSetsBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProductSetsBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets_batch", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductSetsBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductSetsBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductSetsBatch setHandle (String handle) {
      this.setParam("handle", handle);
      return this;
    }

    public APIRequestGetProductSetsBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductSetsBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductSetsBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductSetsBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductSetsBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductSetsBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductSetsBatch requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGetProductSetsBatch requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGetProductSetsBatch requestErrorsTotalCountField () {
      return this.requestErrorsTotalCountField(true);
    }
    public APIRequestGetProductSetsBatch requestErrorsTotalCountField (boolean value) {
      this.requestField("errors_total_count", value);
      return this;
    }
    public APIRequestGetProductSetsBatch requestHandleField () {
      return this.requestHandleField(true);
    }
    public APIRequestGetProductSetsBatch requestHandleField (boolean value) {
      this.requestField("handle", value);
      return this;
    }
    public APIRequestGetProductSetsBatch requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetProductSetsBatch requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetProductSetsBatch requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductSetsBatch requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateProductSetsBatch extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "password",
      "standard",
      "url",
      "username",
      "update_only",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateProductSetsBatch.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductSetsBatch(String nodeId, APIContext context) {
      super(context, nodeId, "/product_sets_batch", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductSetsBatch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductSetsBatch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateProductSetsBatch addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateProductSetsBatch setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateProductSetsBatch setPassword (String password) {
      this.setParam("password", password);
      return this;
    }

    public APIRequestCreateProductSetsBatch setStandard (ProductCatalog.EnumStandard standard) {
      this.setParam("standard", standard);
      return this;
    }
    public APIRequestCreateProductSetsBatch setStandard (String standard) {
      this.setParam("standard", standard);
      return this;
    }

    public APIRequestCreateProductSetsBatch setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateProductSetsBatch setUsername (String username) {
      this.setParam("username", username);
      return this;
    }

    public APIRequestCreateProductSetsBatch setUpdateOnly (Boolean updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }
    public APIRequestCreateProductSetsBatch setUpdateOnly (String updateOnly) {
      this.setParam("update_only", updateOnly);
      return this;
    }

    public APIRequestCreateProductSetsBatch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductSetsBatch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductSetsBatch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductSetsBatch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductSetsBatch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductSetsBatch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    APINodeList<ProductItem> lastResponse = null;
    @Override
    public APINodeList<ProductItem> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "return_only_approved_products",
      "filter",
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
      "description",
      "expiration_date",
      "gender",
      "gtin",
      "id",
      "image_cdn_urls",
      "image_url",
      "inventory",
      "manufacturer_part_number",
      "material",
      "mobile_link",
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_catalog",
      "product_feed",
      "product_group",
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
      "short_description",
      "size",
      "start_date",
      "url",
      "visibility",
    };

    @Override
    public APINodeList<ProductItem> parseResponse(String response) throws APIException {
      return ProductItem.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductItem> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductItem> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductItem>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductItem>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductItem>>() {
           public APINodeList<ProductItem> apply(String result) {
             try {
               return APIRequestGetProducts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProducts(String nodeId, APIContext context) {
      super(context, nodeId, "/products", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProducts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProducts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProducts setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetProducts setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetProducts setReturnOnlyApprovedProducts (Boolean returnOnlyApprovedProducts) {
      this.setParam("return_only_approved_products", returnOnlyApprovedProducts);
      return this;
    }
    public APIRequestGetProducts setReturnOnlyApprovedProducts (String returnOnlyApprovedProducts) {
      this.setParam("return_only_approved_products", returnOnlyApprovedProducts);
      return this;
    }

    public APIRequestGetProducts setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetProducts setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetProducts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProducts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProducts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProducts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProducts requestAdditionalImageCdnUrlsField () {
      return this.requestAdditionalImageCdnUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageCdnUrlsField (boolean value) {
      this.requestField("additional_image_cdn_urls", value);
      return this;
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
      return this;
    }
    public APIRequestGetProducts requestAdditionalVariantAttributesField () {
      return this.requestAdditionalVariantAttributesField(true);
    }
    public APIRequestGetProducts requestAdditionalVariantAttributesField (boolean value) {
      this.requestField("additional_variant_attributes", value);
      return this;
    }
    public APIRequestGetProducts requestAgeGroupField () {
      return this.requestAgeGroupField(true);
    }
    public APIRequestGetProducts requestAgeGroupField (boolean value) {
      this.requestField("age_group", value);
      return this;
    }
    public APIRequestGetProducts requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetProducts requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetProducts requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetProducts requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetProducts requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGetProducts requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGetProducts requestCapabilityToReviewStatusField () {
      return this.requestCapabilityToReviewStatusField(true);
    }
    public APIRequestGetProducts requestCapabilityToReviewStatusField (boolean value) {
      this.requestField("capability_to_review_status", value);
      return this;
    }
    public APIRequestGetProducts requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetProducts requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetProducts requestColorField () {
      return this.requestColorField(true);
    }
    public APIRequestGetProducts requestColorField (boolean value) {
      this.requestField("color", value);
      return this;
    }
    public APIRequestGetProducts requestCommerceInsightsField () {
      return this.requestCommerceInsightsField(true);
    }
    public APIRequestGetProducts requestCommerceInsightsField (boolean value) {
      this.requestField("commerce_insights", value);
      return this;
    }
    public APIRequestGetProducts requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGetProducts requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGetProducts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetProducts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetProducts requestCustomDataField () {
      return this.requestCustomDataField(true);
    }
    public APIRequestGetProducts requestCustomDataField (boolean value) {
      this.requestField("custom_data", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetProducts requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGetProducts requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGetProducts requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGetProducts requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGetProducts requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGetProducts requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
      return this;
    }
    public APIRequestGetProducts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetProducts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetProducts requestExpirationDateField () {
      return this.requestExpirationDateField(true);
    }
    public APIRequestGetProducts requestExpirationDateField (boolean value) {
      this.requestField("expiration_date", value);
      return this;
    }
    public APIRequestGetProducts requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetProducts requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetProducts requestGtinField () {
      return this.requestGtinField(true);
    }
    public APIRequestGetProducts requestGtinField (boolean value) {
      this.requestField("gtin", value);
      return this;
    }
    public APIRequestGetProducts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProducts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProducts requestImageCdnUrlsField () {
      return this.requestImageCdnUrlsField(true);
    }
    public APIRequestGetProducts requestImageCdnUrlsField (boolean value) {
      this.requestField("image_cdn_urls", value);
      return this;
    }
    public APIRequestGetProducts requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetProducts requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetProducts requestInventoryField () {
      return this.requestInventoryField(true);
    }
    public APIRequestGetProducts requestInventoryField (boolean value) {
      this.requestField("inventory", value);
      return this;
    }
    public APIRequestGetProducts requestManufacturerPartNumberField () {
      return this.requestManufacturerPartNumberField(true);
    }
    public APIRequestGetProducts requestManufacturerPartNumberField (boolean value) {
      this.requestField("manufacturer_part_number", value);
      return this;
    }
    public APIRequestGetProducts requestMaterialField () {
      return this.requestMaterialField(true);
    }
    public APIRequestGetProducts requestMaterialField (boolean value) {
      this.requestField("material", value);
      return this;
    }
    public APIRequestGetProducts requestMobileLinkField () {
      return this.requestMobileLinkField(true);
    }
    public APIRequestGetProducts requestMobileLinkField (boolean value) {
      this.requestField("mobile_link", value);
      return this;
    }
    public APIRequestGetProducts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProducts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProducts requestOrderingIndexField () {
      return this.requestOrderingIndexField(true);
    }
    public APIRequestGetProducts requestOrderingIndexField (boolean value) {
      this.requestField("ordering_index", value);
      return this;
    }
    public APIRequestGetProducts requestPatternField () {
      return this.requestPatternField(true);
    }
    public APIRequestGetProducts requestPatternField (boolean value) {
      this.requestField("pattern", value);
      return this;
    }
    public APIRequestGetProducts requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetProducts requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetProducts requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetProducts requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGetProducts requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGetProducts requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
      return this;
    }
    public APIRequestGetProducts requestProductGroupField () {
      return this.requestProductGroupField(true);
    }
    public APIRequestGetProducts requestProductGroupField (boolean value) {
      this.requestField("product_group", value);
      return this;
    }
    public APIRequestGetProducts requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGetProducts requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGetProducts requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetProducts requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetProducts requestRetailerProductGroupIdField () {
      return this.requestRetailerProductGroupIdField(true);
    }
    public APIRequestGetProducts requestRetailerProductGroupIdField (boolean value) {
      this.requestField("retailer_product_group_id", value);
      return this;
    }
    public APIRequestGetProducts requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGetProducts requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGetProducts requestReviewStatusField () {
      return this.requestReviewStatusField(true);
    }
    public APIRequestGetProducts requestReviewStatusField (boolean value) {
      this.requestField("review_status", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetProducts requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceEndDateField () {
      return this.requestSalePriceEndDateField(true);
    }
    public APIRequestGetProducts requestSalePriceEndDateField (boolean value) {
      this.requestField("sale_price_end_date", value);
      return this;
    }
    public APIRequestGetProducts requestSalePriceStartDateField () {
      return this.requestSalePriceStartDateField(true);
    }
    public APIRequestGetProducts requestSalePriceStartDateField (boolean value) {
      this.requestField("sale_price_start_date", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightUnitField () {
      return this.requestShippingWeightUnitField(true);
    }
    public APIRequestGetProducts requestShippingWeightUnitField (boolean value) {
      this.requestField("shipping_weight_unit", value);
      return this;
    }
    public APIRequestGetProducts requestShippingWeightValueField () {
      return this.requestShippingWeightValueField(true);
    }
    public APIRequestGetProducts requestShippingWeightValueField (boolean value) {
      this.requestField("shipping_weight_value", value);
      return this;
    }
    public APIRequestGetProducts requestShortDescriptionField () {
      return this.requestShortDescriptionField(true);
    }
    public APIRequestGetProducts requestShortDescriptionField (boolean value) {
      this.requestField("short_description", value);
      return this;
    }
    public APIRequestGetProducts requestSizeField () {
      return this.requestSizeField(true);
    }
    public APIRequestGetProducts requestSizeField (boolean value) {
      this.requestField("size", value);
      return this;
    }
    public APIRequestGetProducts requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGetProducts requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGetProducts requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetProducts requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetProducts requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGetProducts requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
  }

  public static class APIRequestCreateProduct extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "retailer_id",
      "retailer_product_group_id",
      "availability",
      "currency",
      "condition",
      "description",
      "image_url",
      "name",
      "price",
      "product_type",
      "visibility",
      "additional_image_urls",
      "additional_variant_attributes",
      "brand",
      "category",
      "checkout_url",
      "color",
      "custom_data",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "expiration_date",
      "gender",
      "gtin",
      "inventory",
      "manufacturer_part_number",
      "mobile_link",
      "material",
      "offer_price_amount",
      "offer_price_end_date",
      "offer_price_start_date",
      "ordering_index",
      "pattern",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "short_description",
      "size",
      "start_date",
      "url",
      "ios_url",
      "ios_app_store_id",
      "ios_app_name",
      "iphone_url",
      "iphone_app_store_id",
      "iphone_app_name",
      "ipad_url",
      "ipad_app_store_id",
      "ipad_app_name",
      "android_url",
      "android_package",
      "android_class",
      "android_app_name",
      "windows_phone_url",
      "windows_phone_app_id",
      "windows_phone_app_name",
    };

    public static final String[] FIELDS = {
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

    public ListenableFuture<ProductItem> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductItem> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductItem>() {
           public ProductItem apply(String result) {
             try {
               return APIRequestCreateProduct.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProduct(String nodeId, APIContext context) {
      super(context, nodeId, "/products", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProduct setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProduct setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProduct setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
      return this;
    }

    public APIRequestCreateProduct setRetailerProductGroupId (String retailerProductGroupId) {
      this.setParam("retailer_product_group_id", retailerProductGroupId);
      return this;
    }

    public APIRequestCreateProduct setAvailability (ProductItem.EnumAvailability availability) {
      this.setParam("availability", availability);
      return this;
    }
    public APIRequestCreateProduct setAvailability (String availability) {
      this.setParam("availability", availability);
      return this;
    }

    public APIRequestCreateProduct setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateProduct setCondition (ProductItem.EnumCondition condition) {
      this.setParam("condition", condition);
      return this;
    }
    public APIRequestCreateProduct setCondition (String condition) {
      this.setParam("condition", condition);
      return this;
    }

    public APIRequestCreateProduct setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateProduct setImageUrl (Object imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }
    public APIRequestCreateProduct setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateProduct setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateProduct setPrice (Long price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestCreateProduct setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestCreateProduct setProductType (String productType) {
      this.setParam("product_type", productType);
      return this;
    }

    public APIRequestCreateProduct setVisibility (ProductItem.EnumVisibility visibility) {
      this.setParam("visibility", visibility);
      return this;
    }
    public APIRequestCreateProduct setVisibility (String visibility) {
      this.setParam("visibility", visibility);
      return this;
    }

    public APIRequestCreateProduct setAdditionalImageUrls (List<String> additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }
    public APIRequestCreateProduct setAdditionalImageUrls (String additionalImageUrls) {
      this.setParam("additional_image_urls", additionalImageUrls);
      return this;
    }

    public APIRequestCreateProduct setAdditionalVariantAttributes (Object additionalVariantAttributes) {
      this.setParam("additional_variant_attributes", additionalVariantAttributes);
      return this;
    }
    public APIRequestCreateProduct setAdditionalVariantAttributes (String additionalVariantAttributes) {
      this.setParam("additional_variant_attributes", additionalVariantAttributes);
      return this;
    }

    public APIRequestCreateProduct setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestCreateProduct setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestCreateProduct setCheckoutUrl (String checkoutUrl) {
      this.setParam("checkout_url", checkoutUrl);
      return this;
    }

    public APIRequestCreateProduct setColor (String color) {
      this.setParam("color", color);
      return this;
    }

    public APIRequestCreateProduct setCustomData (Map<String, String> customData) {
      this.setParam("custom_data", customData);
      return this;
    }
    public APIRequestCreateProduct setCustomData (String customData) {
      this.setParam("custom_data", customData);
      return this;
    }

    public APIRequestCreateProduct setCustomLabel0 (String customLabel0) {
      this.setParam("custom_label_0", customLabel0);
      return this;
    }

    public APIRequestCreateProduct setCustomLabel1 (String customLabel1) {
      this.setParam("custom_label_1", customLabel1);
      return this;
    }

    public APIRequestCreateProduct setCustomLabel2 (String customLabel2) {
      this.setParam("custom_label_2", customLabel2);
      return this;
    }

    public APIRequestCreateProduct setCustomLabel3 (String customLabel3) {
      this.setParam("custom_label_3", customLabel3);
      return this;
    }

    public APIRequestCreateProduct setCustomLabel4 (String customLabel4) {
      this.setParam("custom_label_4", customLabel4);
      return this;
    }

    public APIRequestCreateProduct setExpirationDate (String expirationDate) {
      this.setParam("expiration_date", expirationDate);
      return this;
    }

    public APIRequestCreateProduct setGender (ProductItem.EnumGender gender) {
      this.setParam("gender", gender);
      return this;
    }
    public APIRequestCreateProduct setGender (String gender) {
      this.setParam("gender", gender);
      return this;
    }

    public APIRequestCreateProduct setGtin (String gtin) {
      this.setParam("gtin", gtin);
      return this;
    }

    public APIRequestCreateProduct setInventory (Long inventory) {
      this.setParam("inventory", inventory);
      return this;
    }
    public APIRequestCreateProduct setInventory (String inventory) {
      this.setParam("inventory", inventory);
      return this;
    }

    public APIRequestCreateProduct setManufacturerPartNumber (String manufacturerPartNumber) {
      this.setParam("manufacturer_part_number", manufacturerPartNumber);
      return this;
    }

    public APIRequestCreateProduct setMobileLink (Object mobileLink) {
      this.setParam("mobile_link", mobileLink);
      return this;
    }
    public APIRequestCreateProduct setMobileLink (String mobileLink) {
      this.setParam("mobile_link", mobileLink);
      return this;
    }

    public APIRequestCreateProduct setMaterial (String material) {
      this.setParam("material", material);
      return this;
    }

    public APIRequestCreateProduct setOfferPriceAmount (Long offerPriceAmount) {
      this.setParam("offer_price_amount", offerPriceAmount);
      return this;
    }
    public APIRequestCreateProduct setOfferPriceAmount (String offerPriceAmount) {
      this.setParam("offer_price_amount", offerPriceAmount);
      return this;
    }

    public APIRequestCreateProduct setOfferPriceEndDate (Object offerPriceEndDate) {
      this.setParam("offer_price_end_date", offerPriceEndDate);
      return this;
    }
    public APIRequestCreateProduct setOfferPriceEndDate (String offerPriceEndDate) {
      this.setParam("offer_price_end_date", offerPriceEndDate);
      return this;
    }

    public APIRequestCreateProduct setOfferPriceStartDate (Object offerPriceStartDate) {
      this.setParam("offer_price_start_date", offerPriceStartDate);
      return this;
    }
    public APIRequestCreateProduct setOfferPriceStartDate (String offerPriceStartDate) {
      this.setParam("offer_price_start_date", offerPriceStartDate);
      return this;
    }

    public APIRequestCreateProduct setOrderingIndex (Long orderingIndex) {
      this.setParam("ordering_index", orderingIndex);
      return this;
    }
    public APIRequestCreateProduct setOrderingIndex (String orderingIndex) {
      this.setParam("ordering_index", orderingIndex);
      return this;
    }

    public APIRequestCreateProduct setPattern (String pattern) {
      this.setParam("pattern", pattern);
      return this;
    }

    public APIRequestCreateProduct setSalePrice (Long salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }
    public APIRequestCreateProduct setSalePrice (String salePrice) {
      this.setParam("sale_price", salePrice);
      return this;
    }

    public APIRequestCreateProduct setSalePriceEndDate (String salePriceEndDate) {
      this.setParam("sale_price_end_date", salePriceEndDate);
      return this;
    }

    public APIRequestCreateProduct setSalePriceStartDate (String salePriceStartDate) {
      this.setParam("sale_price_start_date", salePriceStartDate);
      return this;
    }

    public APIRequestCreateProduct setShortDescription (String shortDescription) {
      this.setParam("short_description", shortDescription);
      return this;
    }

    public APIRequestCreateProduct setSize (String size) {
      this.setParam("size", size);
      return this;
    }

    public APIRequestCreateProduct setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestCreateProduct setUrl (Object url) {
      this.setParam("url", url);
      return this;
    }
    public APIRequestCreateProduct setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateProduct setIosUrl (String iosUrl) {
      this.setParam("ios_url", iosUrl);
      return this;
    }

    public APIRequestCreateProduct setIosAppStoreId (Long iosAppStoreId) {
      this.setParam("ios_app_store_id", iosAppStoreId);
      return this;
    }
    public APIRequestCreateProduct setIosAppStoreId (String iosAppStoreId) {
      this.setParam("ios_app_store_id", iosAppStoreId);
      return this;
    }

    public APIRequestCreateProduct setIosAppName (String iosAppName) {
      this.setParam("ios_app_name", iosAppName);
      return this;
    }

    public APIRequestCreateProduct setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }

    public APIRequestCreateProduct setIphoneAppStoreId (Long iphoneAppStoreId) {
      this.setParam("iphone_app_store_id", iphoneAppStoreId);
      return this;
    }
    public APIRequestCreateProduct setIphoneAppStoreId (String iphoneAppStoreId) {
      this.setParam("iphone_app_store_id", iphoneAppStoreId);
      return this;
    }

    public APIRequestCreateProduct setIphoneAppName (String iphoneAppName) {
      this.setParam("iphone_app_name", iphoneAppName);
      return this;
    }

    public APIRequestCreateProduct setIpadUrl (String ipadUrl) {
      this.setParam("ipad_url", ipadUrl);
      return this;
    }

    public APIRequestCreateProduct setIpadAppStoreId (Long ipadAppStoreId) {
      this.setParam("ipad_app_store_id", ipadAppStoreId);
      return this;
    }
    public APIRequestCreateProduct setIpadAppStoreId (String ipadAppStoreId) {
      this.setParam("ipad_app_store_id", ipadAppStoreId);
      return this;
    }

    public APIRequestCreateProduct setIpadAppName (String ipadAppName) {
      this.setParam("ipad_app_name", ipadAppName);
      return this;
    }

    public APIRequestCreateProduct setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
      return this;
    }

    public APIRequestCreateProduct setAndroidPackage (String androidPackage) {
      this.setParam("android_package", androidPackage);
      return this;
    }

    public APIRequestCreateProduct setAndroidClass (String androidClass) {
      this.setParam("android_class", androidClass);
      return this;
    }

    public APIRequestCreateProduct setAndroidAppName (String androidAppName) {
      this.setParam("android_app_name", androidAppName);
      return this;
    }

    public APIRequestCreateProduct setWindowsPhoneUrl (String windowsPhoneUrl) {
      this.setParam("windows_phone_url", windowsPhoneUrl);
      return this;
    }

    public APIRequestCreateProduct setWindowsPhoneAppId (String windowsPhoneAppId) {
      this.setParam("windows_phone_app_id", windowsPhoneAppId);
      return this;
    }

    public APIRequestCreateProduct setWindowsPhoneAppName (String windowsPhoneAppName) {
      this.setParam("windows_phone_app_name", windowsPhoneAppName);
      return this;
    }

    public APIRequestCreateProduct requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProduct requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProduct requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProduct requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProduct requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProduct requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteUserPermissions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserPermissions setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteUserPermissions setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteUserPermissions setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserPermissions setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUserPermissions extends APIRequest<ProductCatalogUserPermissions> {

    APINodeList<ProductCatalogUserPermissions> lastResponse = null;
    @Override
    public APINodeList<ProductCatalogUserPermissions> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
      "user",
    };

    public static final String[] FIELDS = {
      "business",
      "business_persona",
      "created_by",
      "created_time",
      "email",
      "role",
      "status",
      "updated_by",
      "updated_time",
      "user",
      "id",
    };

    @Override
    public APINodeList<ProductCatalogUserPermissions> parseResponse(String response) throws APIException {
      return ProductCatalogUserPermissions.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalogUserPermissions> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalogUserPermissions> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalogUserPermissions>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalogUserPermissions>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalogUserPermissions>>() {
           public APINodeList<ProductCatalogUserPermissions> apply(String result) {
             try {
               return APIRequestGetUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUserPermissions setBusiness (Object business) {
      this.setParam("business", business);
      return this;
    }
    public APIRequestGetUserPermissions setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetUserPermissions setUser (Object user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetUserPermissions setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUserPermissions requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetUserPermissions requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetUserPermissions requestBusinessPersonaField () {
      return this.requestBusinessPersonaField(true);
    }
    public APIRequestGetUserPermissions requestBusinessPersonaField (boolean value) {
      this.requestField("business_persona", value);
      return this;
    }
    public APIRequestGetUserPermissions requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetUserPermissions requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetUserPermissions requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetUserPermissions requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetUserPermissions requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetUserPermissions requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetUserPermissions requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUserPermissions requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUserPermissions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetUserPermissions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetUserPermissions requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetUserPermissions requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGetUserPermissions requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGetUserPermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUserPermissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateUserPermission extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
      "role",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateUserPermission.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserPermission setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateUserPermission setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateUserPermission setRole (ProductCatalog.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateUserPermission setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateUserPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVehicles extends APIRequest<Vehicle> {

    APINodeList<Vehicle> lastResponse = null;
    @Override
    public APINodeList<Vehicle> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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
    public APINodeList<Vehicle> parseResponse(String response) throws APIException {
      return Vehicle.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Vehicle> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Vehicle> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Vehicle>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Vehicle>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Vehicle>>() {
           public APINodeList<Vehicle> apply(String result) {
             try {
               return APIRequestGetVehicles.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVehicles(String nodeId, APIContext context) {
      super(context, nodeId, "/vehicles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVehicles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVehicles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVehicles setBulkPagination (Boolean bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }
    public APIRequestGetVehicles setBulkPagination (String bulkPagination) {
      this.setParam("bulk_pagination", bulkPagination);
      return this;
    }

    public APIRequestGetVehicles setFilter (Object filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetVehicles setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetVehicles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVehicles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVehicles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVehicles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVehicles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVehicles requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetVehicles requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetVehicles requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGetVehicles requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGetVehicles requestAvailabilityField () {
      return this.requestAvailabilityField(true);
    }
    public APIRequestGetVehicles requestAvailabilityField (boolean value) {
      this.requestField("availability", value);
      return this;
    }
    public APIRequestGetVehicles requestBodyStyleField () {
      return this.requestBodyStyleField(true);
    }
    public APIRequestGetVehicles requestBodyStyleField (boolean value) {
      this.requestField("body_style", value);
      return this;
    }
    public APIRequestGetVehicles requestConditionField () {
      return this.requestConditionField(true);
    }
    public APIRequestGetVehicles requestConditionField (boolean value) {
      this.requestField("condition", value);
      return this;
    }
    public APIRequestGetVehicles requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetVehicles requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetVehicles requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGetVehicles requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGetVehicles requestDateFirstOnLotField () {
      return this.requestDateFirstOnLotField(true);
    }
    public APIRequestGetVehicles requestDateFirstOnLotField (boolean value) {
      this.requestField("date_first_on_lot", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerCommunicationChannelField () {
      return this.requestDealerCommunicationChannelField(true);
    }
    public APIRequestGetVehicles requestDealerCommunicationChannelField (boolean value) {
      this.requestField("dealer_communication_channel", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerIdField () {
      return this.requestDealerIdField(true);
    }
    public APIRequestGetVehicles requestDealerIdField (boolean value) {
      this.requestField("dealer_id", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerNameField () {
      return this.requestDealerNameField(true);
    }
    public APIRequestGetVehicles requestDealerNameField (boolean value) {
      this.requestField("dealer_name", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerPhoneField () {
      return this.requestDealerPhoneField(true);
    }
    public APIRequestGetVehicles requestDealerPhoneField (boolean value) {
      this.requestField("dealer_phone", value);
      return this;
    }
    public APIRequestGetVehicles requestDealerPrivacyPolicyUrlField () {
      return this.requestDealerPrivacyPolicyUrlField(true);
    }
    public APIRequestGetVehicles requestDealerPrivacyPolicyUrlField (boolean value) {
      this.requestField("dealer_privacy_policy_url", value);
      return this;
    }
    public APIRequestGetVehicles requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetVehicles requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetVehicles requestDrivetrainField () {
      return this.requestDrivetrainField(true);
    }
    public APIRequestGetVehicles requestDrivetrainField (boolean value) {
      this.requestField("drivetrain", value);
      return this;
    }
    public APIRequestGetVehicles requestExteriorColorField () {
      return this.requestExteriorColorField(true);
    }
    public APIRequestGetVehicles requestExteriorColorField (boolean value) {
      this.requestField("exterior_color", value);
      return this;
    }
    public APIRequestGetVehicles requestFbPageIdField () {
      return this.requestFbPageIdField(true);
    }
    public APIRequestGetVehicles requestFbPageIdField (boolean value) {
      this.requestField("fb_page_id", value);
      return this;
    }
    public APIRequestGetVehicles requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetVehicles requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetVehicles requestFuelTypeField () {
      return this.requestFuelTypeField(true);
    }
    public APIRequestGetVehicles requestFuelTypeField (boolean value) {
      this.requestField("fuel_type", value);
      return this;
    }
    public APIRequestGetVehicles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVehicles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVehicles requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetVehicles requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetVehicles requestInteriorColorField () {
      return this.requestInteriorColorField(true);
    }
    public APIRequestGetVehicles requestInteriorColorField (boolean value) {
      this.requestField("interior_color", value);
      return this;
    }
    public APIRequestGetVehicles requestLegalDisclosureImpressumUrlField () {
      return this.requestLegalDisclosureImpressumUrlField(true);
    }
    public APIRequestGetVehicles requestLegalDisclosureImpressumUrlField (boolean value) {
      this.requestField("legal_disclosure_impressum_url", value);
      return this;
    }
    public APIRequestGetVehicles requestMakeField () {
      return this.requestMakeField(true);
    }
    public APIRequestGetVehicles requestMakeField (boolean value) {
      this.requestField("make", value);
      return this;
    }
    public APIRequestGetVehicles requestMileageField () {
      return this.requestMileageField(true);
    }
    public APIRequestGetVehicles requestMileageField (boolean value) {
      this.requestField("mileage", value);
      return this;
    }
    public APIRequestGetVehicles requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGetVehicles requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGetVehicles requestPreviousCurrencyField () {
      return this.requestPreviousCurrencyField(true);
    }
    public APIRequestGetVehicles requestPreviousCurrencyField (boolean value) {
      this.requestField("previous_currency", value);
      return this;
    }
    public APIRequestGetVehicles requestPreviousPriceField () {
      return this.requestPreviousPriceField(true);
    }
    public APIRequestGetVehicles requestPreviousPriceField (boolean value) {
      this.requestField("previous_price", value);
      return this;
    }
    public APIRequestGetVehicles requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGetVehicles requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGetVehicles requestSaleCurrencyField () {
      return this.requestSaleCurrencyField(true);
    }
    public APIRequestGetVehicles requestSaleCurrencyField (boolean value) {
      this.requestField("sale_currency", value);
      return this;
    }
    public APIRequestGetVehicles requestSalePriceField () {
      return this.requestSalePriceField(true);
    }
    public APIRequestGetVehicles requestSalePriceField (boolean value) {
      this.requestField("sale_price", value);
      return this;
    }
    public APIRequestGetVehicles requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGetVehicles requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGetVehicles requestStateOfVehicleField () {
      return this.requestStateOfVehicleField(true);
    }
    public APIRequestGetVehicles requestStateOfVehicleField (boolean value) {
      this.requestField("state_of_vehicle", value);
      return this;
    }
    public APIRequestGetVehicles requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetVehicles requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetVehicles requestTransmissionField () {
      return this.requestTransmissionField(true);
    }
    public APIRequestGetVehicles requestTransmissionField (boolean value) {
      this.requestField("transmission", value);
      return this;
    }
    public APIRequestGetVehicles requestTrimField () {
      return this.requestTrimField(true);
    }
    public APIRequestGetVehicles requestTrimField (boolean value) {
      this.requestField("trim", value);
      return this;
    }
    public APIRequestGetVehicles requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVehicles requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleIdField () {
      return this.requestVehicleIdField(true);
    }
    public APIRequestGetVehicles requestVehicleIdField (boolean value) {
      this.requestField("vehicle_id", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleRegistrationPlateField () {
      return this.requestVehicleRegistrationPlateField(true);
    }
    public APIRequestGetVehicles requestVehicleRegistrationPlateField (boolean value) {
      this.requestField("vehicle_registration_plate", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleSpecificationsField () {
      return this.requestVehicleSpecificationsField(true);
    }
    public APIRequestGetVehicles requestVehicleSpecificationsField (boolean value) {
      this.requestField("vehicle_specifications", value);
      return this;
    }
    public APIRequestGetVehicles requestVehicleTypeField () {
      return this.requestVehicleTypeField(true);
    }
    public APIRequestGetVehicles requestVehicleTypeField (boolean value) {
      this.requestField("vehicle_type", value);
      return this;
    }
    public APIRequestGetVehicles requestVinField () {
      return this.requestVinField(true);
    }
    public APIRequestGetVehicles requestVinField (boolean value) {
      this.requestField("vin", value);
      return this;
    }
    public APIRequestGetVehicles requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGetVehicles requestYearField (boolean value) {
      this.requestField("year", value);
      return this;
    }
  }

  public static class APIRequestCreateVideo extends APIRequest<AdVideo> {

    AdVideo lastResponse = null;
    @Override
    public AdVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "title",
      "source",
      "unpublished_content_type",
      "time_since_original_post",
      "file_url",
      "composer_session_id",
      "waterfall_id",
      "og_action_type_id",
      "og_object_id",
      "og_phrase",
      "og_icon_id",
      "og_suggestion_mechanism",
      "manual_privacy",
      "is_explicit_share",
      "thumb",
      "spherical",
      "original_projection_type",
      "initial_heading",
      "initial_pitch",
      "fov",
      "original_fov",
      "fisheye_video_cropped",
      "front_z_rotation",
      "guide_enabled",
      "guide",
      "audio_story_wave_animation_handle",
      "adaptive_type",
      "animated_effect_id",
      "asked_fun_fact_prompt_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_source_surface",
      "composer_type",
      "formatting",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "is_group_linking_post",
      "has_nickname",
      "holiday_card",
      "instant_game_entry_point_data",
      "is_boost_intended",
      "location_source_id",
      "description",
      "offer_like_post_id",
      "publish_event_id",
      "react_mode_metadata",
      "sales_promo_id",
      "text_format_metadata",
      "throwback_camera_roll_media",
      "video_start_time_ms",
      "application_id",
      "upload_phase",
      "file_size",
      "start_offset",
      "end_offset",
      "video_file_chunk",
      "fbuploader_video_file_chunk",
      "upload_session_id",
      "is_voice_clip",
      "attribution_app_id",
      "content_category",
      "embeddable",
      "slideshow_spec",
      "upload_setting_properties",
      "transcode_setting_properties",
      "container_type",
      "referenced_sticker_id",
      "replace_video_id",
      "swap_mode",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdVideo parseResponse(String response) throws APIException {
      return AdVideo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdVideo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdVideo>() {
           public AdVideo apply(String result) {
             try {
               return APIRequestCreateVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (AdVideo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateVideo setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateVideo setWaterfallId (String waterfallId) {
      this.setParam("waterfall_id", waterfallId);
      return this;
    }

    public APIRequestCreateVideo setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateVideo setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateVideo setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateVideo setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateVideo setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreateVideo setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreateVideo setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreateVideo setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateVideo setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }

    public APIRequestCreateVideo setThumb (File thumb) {
      this.setParam("thumb", thumb);
      return this;
    }
    public APIRequestCreateVideo setThumb (String thumb) {
      this.setParam("thumb", thumb);
      return this;
    }

    public APIRequestCreateVideo setSpherical (Boolean spherical) {
      this.setParam("spherical", spherical);
      return this;
    }
    public APIRequestCreateVideo setSpherical (String spherical) {
      this.setParam("spherical", spherical);
      return this;
    }

    public APIRequestCreateVideo setOriginalProjectionType (AdVideo.EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setInitialHeading (Long initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }
    public APIRequestCreateVideo setInitialHeading (String initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }

    public APIRequestCreateVideo setInitialPitch (Long initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }
    public APIRequestCreateVideo setInitialPitch (String initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
      return this;
    }

    public APIRequestCreateVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateVideo setGuideEnabled (Boolean guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }
    public APIRequestCreateVideo setGuideEnabled (String guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }

    public APIRequestCreateVideo setGuide (List<List<Long>> guide) {
      this.setParam("guide", guide);
      return this;
    }
    public APIRequestCreateVideo setGuide (String guide) {
      this.setParam("guide", guide);
      return this;
    }

    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setAdaptiveType (String adaptiveType) {
      this.setParam("adaptive_type", adaptiveType);
      return this;
    }

    public APIRequestCreateVideo setAnimatedEffectId (Long animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }
    public APIRequestCreateVideo setAnimatedEffectId (String animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }

    public APIRequestCreateVideo setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateVideo setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPicker (String composerEntryPicker) {
      this.setParam("composer_entry_picker", composerEntryPicker);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryPoint (String composerEntryPoint) {
      this.setParam("composer_entry_point", composerEntryPoint);
      return this;
    }

    public APIRequestCreateVideo setComposerEntryTime (Long composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }
    public APIRequestCreateVideo setComposerEntryTime (String composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }

    public APIRequestCreateVideo setComposerSessionEventsLog (String composerSessionEventsLog) {
      this.setParam("composer_session_events_log", composerSessionEventsLog);
      return this;
    }

    public APIRequestCreateVideo setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateVideo setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
      return this;
    }

    public APIRequestCreateVideo setFormatting (AdVideo.EnumFormatting formatting) {
      this.setParam("formatting", formatting);
      return this;
    }
    public APIRequestCreateVideo setFormatting (String formatting) {
      this.setParam("formatting", formatting);
      return this;
    }

    public APIRequestCreateVideo setFunFactPromptId (String funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }

    public APIRequestCreateVideo setFunFactToasteeId (Long funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }
    public APIRequestCreateVideo setFunFactToasteeId (String funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }

    public APIRequestCreateVideo setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateVideo setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }

    public APIRequestCreateVideo setHasNickname (Boolean hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }
    public APIRequestCreateVideo setHasNickname (String hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }

    public APIRequestCreateVideo setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
      return this;
    }

    public APIRequestCreateVideo setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
      return this;
    }

    public APIRequestCreateVideo setIsBoostIntended (Boolean isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }
    public APIRequestCreateVideo setIsBoostIntended (String isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }

    public APIRequestCreateVideo setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideo setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateVideo setPublishEventId (Long publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }
    public APIRequestCreateVideo setPublishEventId (String publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }

    public APIRequestCreateVideo setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateVideo setSalesPromoId (Long salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }
    public APIRequestCreateVideo setSalesPromoId (String salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }

    public APIRequestCreateVideo setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateVideo setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
      return this;
    }

    public APIRequestCreateVideo setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateVideo setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateVideo setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (AdVideo.EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setFbuploaderVideoFileChunk (String fbuploaderVideoFileChunk) {
      this.setParam("fbuploader_video_file_chunk", fbuploaderVideoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateVideo setIsVoiceClip (Boolean isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }
    public APIRequestCreateVideo setIsVoiceClip (String isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }

    public APIRequestCreateVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (AdVideo.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestCreateVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateVideo setUploadSettingProperties (String uploadSettingProperties) {
      this.setParam("upload_setting_properties", uploadSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setTranscodeSettingProperties (String transcodeSettingProperties) {
      this.setParam("transcode_setting_properties", transcodeSettingProperties);
      return this;
    }

    public APIRequestCreateVideo setContainerType (AdVideo.EnumContainerType containerType) {
      this.setParam("container_type", containerType);
      return this;
    }
    public APIRequestCreateVideo setContainerType (String containerType) {
      this.setParam("container_type", containerType);
      return this;
    }

    public APIRequestCreateVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateVideo setReplaceVideoId (String replaceVideoId) {
      this.setParam("replace_video_id", replaceVideoId);
      return this;
    }

    public APIRequestCreateVideo setSwapMode (AdVideo.EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

  public static class APIRequestGet extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "flight_catalog_settings",
      "id",
      "image_padding_landscape",
      "image_padding_square",
      "name",
      "product_count",
      "qualified_product_count",
      "vertical",
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGet requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGet requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGet requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGet requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGet requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGet requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGet requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGet requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGet requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImagePaddingLandscapeField () {
      return this.requestImagePaddingLandscapeField(true);
    }
    public APIRequestGet requestImagePaddingLandscapeField (boolean value) {
      this.requestField("image_padding_landscape", value);
      return this;
    }
    public APIRequestGet requestImagePaddingSquareField () {
      return this.requestImagePaddingSquareField(true);
    }
    public APIRequestGet requestImagePaddingSquareField (boolean value) {
      this.requestField("image_padding_square", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGet requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGet requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGet requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "default_image_url",
      "fallback_image_url",
      "flight_catalog_settings",
      "destination_catalog_settings",
      "da_display_settings",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setDefaultImageUrl (String defaultImageUrl) {
      this.setParam("default_image_url", defaultImageUrl);
      return this;
    }

    public APIRequestUpdate setFallbackImageUrl (String fallbackImageUrl) {
      this.setParam("fallback_image_url", fallbackImageUrl);
      return this;
    }

    public APIRequestUpdate setFlightCatalogSettings (Map<String, String> flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }
    public APIRequestUpdate setFlightCatalogSettings (String flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }

    public APIRequestUpdate setDestinationCatalogSettings (Map<String, String> destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }
    public APIRequestUpdate setDestinationCatalogSettings (String destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }

    public APIRequestUpdate setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestUpdate setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
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

  public static enum EnumVertical {
      @SerializedName("commerce")
      VALUE_COMMERCE("commerce"),
      @SerializedName("destinations")
      VALUE_DESTINATIONS("destinations"),
      @SerializedName("flights")
      VALUE_FLIGHTS("flights"),
      @SerializedName("home_listings")
      VALUE_HOME_LISTINGS("home_listings"),
      @SerializedName("hotels")
      VALUE_HOTELS("hotels"),
      @SerializedName("vehicles")
      VALUE_VEHICLES("vehicles"),
      NULL(null);

      private String value;

      private EnumVertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedRoles {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumPermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedTasks {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumPermittedTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStandard {
      @SerializedName("google")
      VALUE_GOOGLE("google"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumStandard(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRole {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumRole(String value) {
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

  public ProductCatalog copyFrom(ProductCatalog instance) {
    this.mBusiness = instance.mBusiness;
    this.mDaDisplaySettings = instance.mDaDisplaySettings;
    this.mDefaultImageUrl = instance.mDefaultImageUrl;
    this.mFallbackImageUrl = instance.mFallbackImageUrl;
    this.mFeedCount = instance.mFeedCount;
    this.mFlightCatalogSettings = instance.mFlightCatalogSettings;
    this.mId = instance.mId;
    this.mImagePaddingLandscape = instance.mImagePaddingLandscape;
    this.mImagePaddingSquare = instance.mImagePaddingSquare;
    this.mName = instance.mName;
    this.mProductCount = instance.mProductCount;
    this.mQualifiedProductCount = instance.mQualifiedProductCount;
    this.mVertical = instance.mVertical;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalog> getParser() {
    return new APIRequest.ResponseParser<ProductCatalog>() {
      public APINodeList<ProductCatalog> parseResponse(String response, APIContext context, APIRequest<ProductCatalog> request) throws MalformedResponseException {
        return ProductCatalog.parseResponse(response, context, request);
      }
    };
  }
}
