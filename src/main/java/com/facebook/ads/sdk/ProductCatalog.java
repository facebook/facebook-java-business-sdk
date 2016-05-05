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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class ProductCatalog extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("feed_count")
  private Long mFeedCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_count")
  private Long mProductCount = null;
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

  public static ProductCatalog fetchById(String id, APIContext context) throws APIException {
    ProductCatalog productCatalog =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productCatalog;
  }

  public static APINodeList<ProductCatalog> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductCatalog>)(
      new APIRequest<ProductCatalog>(context, "", "/", "GET", ProductCatalog.getParser())
        .setParam("ids", String.join(",", ids))
        .requestFields(fields)
        .execute()
    );
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
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            productCatalogs.setPaging(before, after);
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

  public APIRequestDeleteExternalEventSources deleteExternalEventSources() {
    return new APIRequestDeleteExternalEventSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExternalEventSources getExternalEventSources() {
    return new APIRequestGetExternalEventSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateExternalEventSource createExternalEventSource() {
    return new APIRequestCreateExternalEventSource(this.getPrefixedId().toString(), context);
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

  public APIRequestGetProducts getProducts() {
    return new APIRequestGetProducts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProduct createProduct() {
    return new APIRequestCreateProduct(this.getPrefixedId().toString(), context);
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

  public Long getFieldFeedCount() {
    return mFeedCount;
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



  public static class APIRequestGetAgencies extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "primary_page",
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

    public APIRequestGetAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencies requestIdField (boolean value) {
      this.requestField("id", value);
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
  }

  public static class APIRequestDeleteExternalEventSources extends APIRequest<ExternalEventSource> {

    APINodeList<ExternalEventSource> lastResponse = null;
    @Override
    public APINodeList<ExternalEventSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "external_event_sources",
      "id",
    };

    public static final String[] FIELDS = {
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

    public APIRequestDeleteExternalEventSources setId (String id) {
      this.setParam("id", id);
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
      "id",
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

    public APIRequestCreateExternalEventSource setId (String id) {
      this.setParam("id", id);
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
      "quoted_fields_mode",
      "schedule",
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
      "file_name",
      "id",
      "name",
      "quoted_fields_mode",
      "schedule",
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

    public APIRequestCreateProductFeed setFileName (String fileName) {
      this.setParam("file_name", fileName);
      return this;
    }

    public APIRequestCreateProductFeed setId (String id) {
      this.setParam("id", id);
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
      "id",
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


    public APIRequestCreateProductGroup setId (String id) {
      this.setParam("id", id);
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
    };

    public static final String[] FIELDS = {
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
      "id",
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

    public APIRequestCreateProductSet setId (String id) {
      this.setParam("id", id);
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

  public static class APIRequestGetProducts extends APIRequest<ProductItem> {

    APINodeList<ProductItem> lastResponse = null;
    @Override
    public APINodeList<ProductItem> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter",
    };

    public static final String[] FIELDS = {
      "additional_image_urls",
      "age_group",
      "applinks",
      "availability",
      "brand",
      "category",
      "color",
      "commerce_insights",
      "condition",
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
      "image_url",
      "manufacturer_part_number",
      "material",
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_feed",
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

    public APIRequestGetProducts requestAdditionalImageUrlsField () {
      return this.requestAdditionalImageUrlsField(true);
    }
    public APIRequestGetProducts requestAdditionalImageUrlsField (boolean value) {
      this.requestField("additional_image_urls", value);
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
    public APIRequestGetProducts requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetProducts requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
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
    public APIRequestGetProducts requestProductFeedField () {
      return this.requestProductFeedField(true);
    }
    public APIRequestGetProducts requestProductFeedField (boolean value) {
      this.requestField("product_feed", value);
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
      "id",
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
      "name",
      "ordering_index",
      "pattern",
      "price",
      "product_type",
      "retailer_id",
      "retailer_product_group_id",
      "sale_price",
      "sale_price_end_date",
      "sale_price_start_date",
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

    public APIRequestCreateProduct setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateProduct setName (String name) {
      this.setParam("name", name);
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

    public APIRequestCreateProduct setSize (String size) {
      this.setParam("size", size);
      return this;
    }

    public APIRequestCreateProduct setStartDate (String startDate) {
      this.setParam("start_date", startDate);
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

    public APIRequestCreateProduct setWindowsPhoneAppId (Long windowsPhoneAppId) {
      this.setParam("windows_phone_app_id", windowsPhoneAppId);
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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
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


    public APIRequestDelete setId (String id) {
      this.setParam("id", id);
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
      "feed_count",
      "id",
      "name",
      "product_count",
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
    public APIRequestGet requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGet requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "name",
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


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
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
    this.mFeedCount = instance.mFeedCount;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mProductCount = instance.mProductCount;
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
