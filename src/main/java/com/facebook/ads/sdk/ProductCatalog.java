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
  private Object mFlightCatalogSettings = null;
  @SerializedName("id")
  private String mId = null;
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
    ProductCatalog productCatalog =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productCatalog;
  }

  public static ListenableFuture<ProductCatalog> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<ProductCatalog> productCatalog =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return productCatalog;
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
    ListenableFuture<APINodeList<ProductCatalog>> productCatalog =
      new APIRequest(context, "", "/", "GET", ProductCatalog.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return productCatalog;
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

  public APIRequestGetAgencies getAgencies() {
    return new APIRequestGetAgencies(this.getPrefixedId().toString(), context);
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

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProduct createProduct() {
    return new APIRequestCreateProduct(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetQualityIssues getQualityIssues() {
    return new APIRequestGetQualityIssues(this.getPrefixedId().toString(), context);
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

  public Object getFieldFlightCatalogSettings() {
    return mFlightCatalogSettings;
  }

  public String getFieldId() {
    return mId;
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
      "id",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "vertical",
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
    public APIRequestGetAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencies requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetAgencies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAgencies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateBatch extends APIRequest<ProductItem> {

    ProductItem lastResponse = null;
    @Override
    public ProductItem getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "requests",
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
  }

  public static class APIRequestGetDaEventSamples extends APIRequest<ProductDaEventSamplesBatch> {

    APINodeList<ProductDaEventSamplesBatch> lastResponse = null;
    @Override
    public APINodeList<ProductDaEventSamplesBatch> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_type",
      "event",
      "source_id",
    };

    public static final String[] FIELDS = {
      "samples",
      "time_start",
      "time_stop",
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


    public APIRequestGetDaEventSamples setAggregationType (ProductDaEventSamplesBatch.EnumAggregationType aggregationType) {
      this.setParam("aggregation_type", aggregationType);
      return this;
    }
    public APIRequestGetDaEventSamples setAggregationType (String aggregationType) {
      this.setParam("aggregation_type", aggregationType);
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

    public APIRequestGetDaEventSamples setSourceId (String sourceId) {
      this.setParam("source_id", sourceId);
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
  }

  public static class APIRequestGetDestinations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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

  public static class APIRequestCreateExternalEventSource extends APIRequest<ExternalEventSource> {

    ExternalEventSource lastResponse = null;
    @Override
    public ExternalEventSource getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_event_sources",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ExternalEventSource parseResponse(String response) throws APIException {
      return ExternalEventSource.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ExternalEventSource execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ExternalEventSource execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ExternalEventSource> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ExternalEventSource> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ExternalEventSource>() {
           public ExternalEventSource apply(String result) {
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

  public static class APIRequestGetFlights extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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

  }

  public static class APIRequestGetHomeListings extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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

  }

  public static class APIRequestCreateHomeListing extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address",
      "availability",
      "currency",
      "description",
      "home_listing_id",
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

    public APIRequestCreateHomeListing setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateHomeListing setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateHomeListing setHomeListingId (String homeListingId) {
      this.setParam("home_listing_id", homeListingId);
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

    public APIRequestCreateHomeListing setListingType (String listingType) {
      this.setParam("listing_type", listingType);
      return this;
    }

    public APIRequestCreateHomeListing setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateHomeListing setPrice (Double price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestCreateHomeListing setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestCreateHomeListing setPropertyType (String propertyType) {
      this.setParam("property_type", propertyType);
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
  }

  public static class APIRequestCreateHotelRoomsBatch extends APIRequest<ProductCatalogHotelRoomsBatch> {

    ProductCatalogHotelRoomsBatch lastResponse = null;
    @Override
    public ProductCatalogHotelRoomsBatch getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "password",
      "standard",
      "update_only",
      "url",
      "username",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalogHotelRoomsBatch parseResponse(String response) throws APIException {
      return ProductCatalogHotelRoomsBatch.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalogHotelRoomsBatch execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalogHotelRoomsBatch execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalogHotelRoomsBatch> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalogHotelRoomsBatch> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalogHotelRoomsBatch>() {
           public ProductCatalogHotelRoomsBatch apply(String result) {
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

    public APIRequestCreateHotelRoomsBatch setStandard (ProductCatalogHotelRoomsBatch.EnumStandard standard) {
      this.setParam("standard", standard);
      return this;
    }
    public APIRequestCreateHotelRoomsBatch setStandard (String standard) {
      this.setParam("standard", standard);
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

    public APIRequestCreateHotelRoomsBatch setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateHotelRoomsBatch setUsername (String username) {
      this.setParam("username", username);
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

  public static class APIRequestGetHotels extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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

  }

  public static class APIRequestCreateHotel extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "address",
      "applinks",
      "brand",
      "description",
      "guest_ratings",
      "hotel_id",
      "images",
      "name",
      "phone",
      "star_rating",
      "url",
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


    public APIRequestCreateHotel setAddress (Object address) {
      this.setParam("address", address);
      return this;
    }
    public APIRequestCreateHotel setAddress (String address) {
      this.setParam("address", address);
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

    public APIRequestCreateHotel setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestCreateHotel setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateHotel setHotelId (String hotelId) {
      this.setParam("hotel_id", hotelId);
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

    public APIRequestCreateHotel setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateHotel setUrl (String url) {
      this.setParam("url", url);
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
  }

  public static class APIRequestCreatePricingVariablesBatch extends APIRequest<ProductCatalogPricingVariablesBatch> {

    ProductCatalogPricingVariablesBatch lastResponse = null;
    @Override
    public ProductCatalogPricingVariablesBatch getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "password",
      "standard",
      "update_only",
      "url",
      "username",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalogPricingVariablesBatch parseResponse(String response) throws APIException {
      return ProductCatalogPricingVariablesBatch.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalogPricingVariablesBatch execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalogPricingVariablesBatch execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalogPricingVariablesBatch> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalogPricingVariablesBatch> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalogPricingVariablesBatch>() {
           public ProductCatalogPricingVariablesBatch apply(String result) {
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

    public APIRequestCreatePricingVariablesBatch setStandard (ProductCatalogPricingVariablesBatch.EnumStandard standard) {
      this.setParam("standard", standard);
      return this;
    }
    public APIRequestCreatePricingVariablesBatch setStandard (String standard) {
      this.setParam("standard", standard);
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

    public APIRequestCreatePricingVariablesBatch setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePricingVariablesBatch setUsername (String username) {
      this.setParam("username", username);
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
      "product_count",
      "qualified_product_count",
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
      "country",
      "default_currency",
      "deletion_enabled",
      "delimiter",
      "encoding",
      "feed_type",
      "file_name",
      "name",
      "quoted_fields_mode",
      "rules",
      "schedule",
      "update_schedule",
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


    public APIRequestCreateProductFeed setCountry (String country) {
      this.setParam("country", country);
      return this;
    }

    public APIRequestCreateProductFeed setDefaultCurrency (String defaultCurrency) {
      this.setParam("default_currency", defaultCurrency);
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

    public APIRequestCreateProductFeed setRules (List<String> rules) {
      this.setParam("rules", rules);
      return this;
    }
    public APIRequestCreateProductFeed setRules (String rules) {
      this.setParam("rules", rules);
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
      "ancestor_id",
      "has_children",
      "parent_id",
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

    public APIRequestGetProductSets setParentId (String parentId) {
      this.setParam("parent_id", parentId);
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
  }

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    APINodeList<ProductItem> lastResponse = null;
    @Override
    public APINodeList<ProductItem> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
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
      "additional_image_urls",
      "additional_variant_attributes",
      "android_app_name",
      "android_class",
      "android_package",
      "android_url",
      "availability",
      "brand",
      "category",
      "checkout_url",
      "color",
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
      "image_url",
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
      "manufacturer_part_number",
      "material",
      "mobile_link",
      "name",
      "offer_price_amount",
      "offer_price_end_date",
      "offer_price_start_date",
      "ordering_index",
      "pattern",
      "price",
      "product_type",
      "retailer_id",
      "retailer_product_group_id",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
      "short_description",
      "size",
      "start_date",
      "url",
      "visibility",
      "windows_phone_app_id",
      "windows_phone_app_name",
      "windows_phone_url",
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

    public APIRequestCreateProduct setAndroidAppName (String androidAppName) {
      this.setParam("android_app_name", androidAppName);
      return this;
    }

    public APIRequestCreateProduct setAndroidClass (String androidClass) {
      this.setParam("android_class", androidClass);
      return this;
    }

    public APIRequestCreateProduct setAndroidPackage (String androidPackage) {
      this.setParam("android_package", androidPackage);
      return this;
    }

    public APIRequestCreateProduct setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
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

    public APIRequestCreateProduct setCondition (ProductItem.EnumCondition condition) {
      this.setParam("condition", condition);
      return this;
    }
    public APIRequestCreateProduct setCondition (String condition) {
      this.setParam("condition", condition);
      return this;
    }

    public APIRequestCreateProduct setCurrency (String currency) {
      this.setParam("currency", currency);
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

    public APIRequestCreateProduct setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateProduct setImageUrl (Object imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }
    public APIRequestCreateProduct setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
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

    public APIRequestCreateProduct setIosAppName (String iosAppName) {
      this.setParam("ios_app_name", iosAppName);
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

    public APIRequestCreateProduct setIosUrl (String iosUrl) {
      this.setParam("ios_url", iosUrl);
      return this;
    }

    public APIRequestCreateProduct setIpadAppName (String ipadAppName) {
      this.setParam("ipad_app_name", ipadAppName);
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

    public APIRequestCreateProduct setIpadUrl (String ipadUrl) {
      this.setParam("ipad_url", ipadUrl);
      return this;
    }

    public APIRequestCreateProduct setIphoneAppName (String iphoneAppName) {
      this.setParam("iphone_app_name", iphoneAppName);
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

    public APIRequestCreateProduct setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }

    public APIRequestCreateProduct setManufacturerPartNumber (String manufacturerPartNumber) {
      this.setParam("manufacturer_part_number", manufacturerPartNumber);
      return this;
    }

    public APIRequestCreateProduct setMaterial (String material) {
      this.setParam("material", material);
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

    public APIRequestCreateProduct setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateProduct setRetailerId (String retailerId) {
      this.setParam("retailer_id", retailerId);
      return this;
    }

    public APIRequestCreateProduct setRetailerProductGroupId (String retailerProductGroupId) {
      this.setParam("retailer_product_group_id", retailerProductGroupId);
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

    public APIRequestCreateProduct setVisibility (ProductItem.EnumVisibility visibility) {
      this.setParam("visibility", visibility);
      return this;
    }
    public APIRequestCreateProduct setVisibility (String visibility) {
      this.setParam("visibility", visibility);
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

    public APIRequestCreateProduct setWindowsPhoneUrl (String windowsPhoneUrl) {
      this.setParam("windows_phone_url", windowsPhoneUrl);
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

  public static class APIRequestGetQualityIssues extends APIRequest<ProductsQualityIssue> {

    APINodeList<ProductsQualityIssue> lastResponse = null;
    @Override
    public APINodeList<ProductsQualityIssue> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "count",
      "description",
      "issue_type",
      "property_names",
      "samples",
      "summary",
    };

    @Override
    public APINodeList<ProductsQualityIssue> parseResponse(String response) throws APIException {
      return ProductsQualityIssue.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductsQualityIssue> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductsQualityIssue> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductsQualityIssue>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductsQualityIssue>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductsQualityIssue>>() {
           public APINodeList<ProductsQualityIssue> apply(String result) {
             try {
               return APIRequestGetQualityIssues.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetQualityIssues(String nodeId, APIContext context) {
      super(context, nodeId, "/quality_issues", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetQualityIssues setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetQualityIssues setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetQualityIssues requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetQualityIssues requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetQualityIssues requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetQualityIssues requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetQualityIssues requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetQualityIssues requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetQualityIssues requestCountField () {
      return this.requestCountField(true);
    }
    public APIRequestGetQualityIssues requestCountField (boolean value) {
      this.requestField("count", value);
      return this;
    }
    public APIRequestGetQualityIssues requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetQualityIssues requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetQualityIssues requestIssueTypeField () {
      return this.requestIssueTypeField(true);
    }
    public APIRequestGetQualityIssues requestIssueTypeField (boolean value) {
      this.requestField("issue_type", value);
      return this;
    }
    public APIRequestGetQualityIssues requestPropertyNamesField () {
      return this.requestPropertyNamesField(true);
    }
    public APIRequestGetQualityIssues requestPropertyNamesField (boolean value) {
      this.requestField("property_names", value);
      return this;
    }
    public APIRequestGetQualityIssues requestSamplesField () {
      return this.requestSamplesField(true);
    }
    public APIRequestGetQualityIssues requestSamplesField (boolean value) {
      this.requestField("samples", value);
      return this;
    }
    public APIRequestGetQualityIssues requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGetQualityIssues requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
  }

  public static class APIRequestGetVehicles extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bulk_pagination",
      "filter",
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

  }

  public static class APIRequestCreateVideo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "audio_story_wave_animation_handle",
      "content_category",
      "description",
      "embeddable",
      "end_offset",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "fov",
      "front_z_rotation",
      "guide",
      "guide_enabled",
      "initial_heading",
      "initial_pitch",
      "original_fov",
      "original_projection_type",
      "react_mode_metadata",
      "referenced_sticker_id",
      "replace_video_id",
      "slideshow_spec",
      "source",
      "spherical",
      "start_offset",
      "swap_mode",
      "thumb",
      "title",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "video_file_chunk",
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


    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
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

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
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

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
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

    public APIRequestCreateVideo setGuide (List<List<Long>> guide) {
      this.setParam("guide", guide);
      return this;
    }
    public APIRequestCreateVideo setGuide (String guide) {
      this.setParam("guide", guide);
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

    public APIRequestCreateVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateVideo setOriginalProjectionType (EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
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

    public APIRequestCreateVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
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

    public APIRequestCreateVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateVideo setSwapMode (EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
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

    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
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
      "da_display_settings",
      "default_image_url",
      "destination_catalog_settings",
      "fallback_image_url",
      "flight_catalog_settings",
      "name",
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


    public APIRequestUpdate setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestUpdate setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }

    public APIRequestUpdate setDefaultImageUrl (String defaultImageUrl) {
      this.setParam("default_image_url", defaultImageUrl);
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

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumContentCategory {
      @SerializedName("BEAUTY_FASHION")
      VALUE_BEAUTY_FASHION("BEAUTY_FASHION"),
      @SerializedName("BUSINESS")
      VALUE_BUSINESS("BUSINESS"),
      @SerializedName("CARS_TRUCKS")
      VALUE_CARS_TRUCKS("CARS_TRUCKS"),
      @SerializedName("COMEDY")
      VALUE_COMEDY("COMEDY"),
      @SerializedName("CUTE_ANIMALS")
      VALUE_CUTE_ANIMALS("CUTE_ANIMALS"),
      @SerializedName("ENTERTAINMENT")
      VALUE_ENTERTAINMENT("ENTERTAINMENT"),
      @SerializedName("FAMILY")
      VALUE_FAMILY("FAMILY"),
      @SerializedName("FOOD_HEALTH")
      VALUE_FOOD_HEALTH("FOOD_HEALTH"),
      @SerializedName("HOME")
      VALUE_HOME("HOME"),
      @SerializedName("LIFESTYLE")
      VALUE_LIFESTYLE("LIFESTYLE"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NEWS")
      VALUE_NEWS("NEWS"),
      @SerializedName("POLITICS")
      VALUE_POLITICS("POLITICS"),
      @SerializedName("SCIENCE")
      VALUE_SCIENCE("SCIENCE"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("VIDEO_GAMING")
      VALUE_VIDEO_GAMING("VIDEO_GAMING"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumContentCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginalProjectionType {
      @SerializedName("equirectangular")
      VALUE_EQUIRECTANGULAR("equirectangular"),
      @SerializedName("cubemap")
      VALUE_CUBEMAP("cubemap"),
      @SerializedName("equiangular_cubemap")
      VALUE_EQUIANGULAR_CUBEMAP("equiangular_cubemap"),
<<<<<<< HEAD
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);
=======
      @SerializedName("half_equirectangular")
      VALUE_HALF_EQUIRECTANGULAR("half_equirectangular"),
      NULL(null);
>>>>>>> upstream/master

      private String value;

      private EnumOriginalProjectionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSwapMode {
      @SerializedName("replace")
      VALUE_REPLACE("replace"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumSwapMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUnpublishedContentType {
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
<<<<<<< HEAD
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);
=======
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      NULL(null);
>>>>>>> upstream/master

      private String value;

      private EnumUnpublishedContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUploadPhase {
      @SerializedName("start")
      VALUE_START("start"),
      @SerializedName("transfer")
      VALUE_TRANSFER("transfer"),
      @SerializedName("finish")
      VALUE_FINISH("finish"),
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumUploadPhase(String value) {
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
