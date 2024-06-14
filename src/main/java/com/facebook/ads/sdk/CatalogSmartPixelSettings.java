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
public class CatalogSmartPixelSettings extends APINode {
  @SerializedName("allowed_domains")
  private List<String> mAllowedDomains = null;
  @SerializedName("available_property_filters")
  private List<String> mAvailablePropertyFilters = null;
  @SerializedName("catalog")
  private ProductCatalog mCatalog = null;
  @SerializedName("cbb_custom_override_filters")
  private List<Object> mCbbCustomOverrideFilters = null;
  @SerializedName("cbb_default_filter")
  private List<Map<String, List<String>>> mCbbDefaultFilter = null;
  @SerializedName("cbb_default_filter_crawl_params")
  private String mCbbDefaultFilterCrawlParams = null;
  @SerializedName("cbb_override_type_field_mapping")
  private List<Map<String, List<String>>> mCbbOverrideTypeFieldMapping = null;
  @SerializedName("defaults")
  private List<Map<String, String>> mDefaults = null;
  @SerializedName("filters")
  private List<Map<String, List<String>>> mFilters = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_cbb_enabled")
  private Boolean mIsCbbEnabled = null;
  @SerializedName("is_create_enabled")
  private Boolean mIsCreateEnabled = null;
  @SerializedName("is_delete_enabled")
  private Boolean mIsDeleteEnabled = null;
  @SerializedName("is_update_enabled")
  private Boolean mIsUpdateEnabled = null;
  @SerializedName("microdata_format_precedence")
  private List<String> mMicrodataFormatPrecedence = null;
  @SerializedName("pixel")
  private AdsPixel mPixel = null;
  @SerializedName("property_filter")
  private List<String> mPropertyFilter = null;
  @SerializedName("retention_time_sec")
  private Long mRetentionTimeSec = null;
  @SerializedName("trusted_domains")
  private List<String> mTrustedDomains = null;
  protected static Gson gson = null;

  CatalogSmartPixelSettings() {
  }

  public CatalogSmartPixelSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CatalogSmartPixelSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CatalogSmartPixelSettings fetch() throws APIException{
    CatalogSmartPixelSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CatalogSmartPixelSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CatalogSmartPixelSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CatalogSmartPixelSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CatalogSmartPixelSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CatalogSmartPixelSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CatalogSmartPixelSettings>)(
      new APIRequest<CatalogSmartPixelSettings>(context, "", "/", "GET", CatalogSmartPixelSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CatalogSmartPixelSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CatalogSmartPixelSettings.getParser())
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
  public static CatalogSmartPixelSettings loadJSON(String json, APIContext context, String header) {
    CatalogSmartPixelSettings catalogSmartPixelSettings = getGson().fromJson(json, CatalogSmartPixelSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogSmartPixelSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogSmartPixelSettings.context = context;
    catalogSmartPixelSettings.rawValue = json;
    catalogSmartPixelSettings.header = header;
    return catalogSmartPixelSettings;
  }

  public static APINodeList<CatalogSmartPixelSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogSmartPixelSettings> catalogSmartPixelSettingss = new APINodeList<CatalogSmartPixelSettings>(request, json, header);
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
          catalogSmartPixelSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogSmartPixelSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogSmartPixelSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogSmartPixelSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogSmartPixelSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogSmartPixelSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogSmartPixelSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogSmartPixelSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogSmartPixelSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogSmartPixelSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogSmartPixelSettingss;
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
              catalogSmartPixelSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogSmartPixelSettingss;
          }

          // Sixth, check if it's pure JsonObject
          catalogSmartPixelSettingss.clear();
          catalogSmartPixelSettingss.add(loadJSON(json, context, header));
          return catalogSmartPixelSettingss;
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


  public List<String> getFieldAllowedDomains() {
    return mAllowedDomains;
  }

  public List<String> getFieldAvailablePropertyFilters() {
    return mAvailablePropertyFilters;
  }

  public ProductCatalog getFieldCatalog() {
    if (mCatalog != null) {
      mCatalog.context = getContext();
    }
    return mCatalog;
  }

  public List<Object> getFieldCbbCustomOverrideFilters() {
    return mCbbCustomOverrideFilters;
  }

  public List<Map<String, List<String>>> getFieldCbbDefaultFilter() {
    return mCbbDefaultFilter;
  }

  public String getFieldCbbDefaultFilterCrawlParams() {
    return mCbbDefaultFilterCrawlParams;
  }

  public List<Map<String, List<String>>> getFieldCbbOverrideTypeFieldMapping() {
    return mCbbOverrideTypeFieldMapping;
  }

  public List<Map<String, String>> getFieldDefaults() {
    return mDefaults;
  }

  public List<Map<String, List<String>>> getFieldFilters() {
    return mFilters;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsCbbEnabled() {
    return mIsCbbEnabled;
  }

  public Boolean getFieldIsCreateEnabled() {
    return mIsCreateEnabled;
  }

  public Boolean getFieldIsDeleteEnabled() {
    return mIsDeleteEnabled;
  }

  public Boolean getFieldIsUpdateEnabled() {
    return mIsUpdateEnabled;
  }

  public List<String> getFieldMicrodataFormatPrecedence() {
    return mMicrodataFormatPrecedence;
  }

  public AdsPixel getFieldPixel() {
    if (mPixel != null) {
      mPixel.context = getContext();
    }
    return mPixel;
  }

  public List<String> getFieldPropertyFilter() {
    return mPropertyFilter;
  }

  public Long getFieldRetentionTimeSec() {
    return mRetentionTimeSec;
  }

  public List<String> getFieldTrustedDomains() {
    return mTrustedDomains;
  }



  public static class APIRequestGet extends APIRequest<CatalogSmartPixelSettings> {

    CatalogSmartPixelSettings lastResponse = null;
    @Override
    public CatalogSmartPixelSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "allowed_domains",
      "available_property_filters",
      "catalog",
      "cbb_custom_override_filters",
      "cbb_default_filter",
      "cbb_default_filter_crawl_params",
      "cbb_override_type_field_mapping",
      "defaults",
      "filters",
      "id",
      "is_cbb_enabled",
      "is_create_enabled",
      "is_delete_enabled",
      "is_update_enabled",
      "microdata_format_precedence",
      "pixel",
      "property_filter",
      "retention_time_sec",
      "trusted_domains",
    };

    @Override
    public CatalogSmartPixelSettings parseResponse(String response, String header) throws APIException {
      return CatalogSmartPixelSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CatalogSmartPixelSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CatalogSmartPixelSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CatalogSmartPixelSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CatalogSmartPixelSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CatalogSmartPixelSettings>() {
           public CatalogSmartPixelSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestAllowedDomainsField () {
      return this.requestAllowedDomainsField(true);
    }
    public APIRequestGet requestAllowedDomainsField (boolean value) {
      this.requestField("allowed_domains", value);
      return this;
    }
    public APIRequestGet requestAvailablePropertyFiltersField () {
      return this.requestAvailablePropertyFiltersField(true);
    }
    public APIRequestGet requestAvailablePropertyFiltersField (boolean value) {
      this.requestField("available_property_filters", value);
      return this;
    }
    public APIRequestGet requestCatalogField () {
      return this.requestCatalogField(true);
    }
    public APIRequestGet requestCatalogField (boolean value) {
      this.requestField("catalog", value);
      return this;
    }
    public APIRequestGet requestCbbCustomOverrideFiltersField () {
      return this.requestCbbCustomOverrideFiltersField(true);
    }
    public APIRequestGet requestCbbCustomOverrideFiltersField (boolean value) {
      this.requestField("cbb_custom_override_filters", value);
      return this;
    }
    public APIRequestGet requestCbbDefaultFilterField () {
      return this.requestCbbDefaultFilterField(true);
    }
    public APIRequestGet requestCbbDefaultFilterField (boolean value) {
      this.requestField("cbb_default_filter", value);
      return this;
    }
    public APIRequestGet requestCbbDefaultFilterCrawlParamsField () {
      return this.requestCbbDefaultFilterCrawlParamsField(true);
    }
    public APIRequestGet requestCbbDefaultFilterCrawlParamsField (boolean value) {
      this.requestField("cbb_default_filter_crawl_params", value);
      return this;
    }
    public APIRequestGet requestCbbOverrideTypeFieldMappingField () {
      return this.requestCbbOverrideTypeFieldMappingField(true);
    }
    public APIRequestGet requestCbbOverrideTypeFieldMappingField (boolean value) {
      this.requestField("cbb_override_type_field_mapping", value);
      return this;
    }
    public APIRequestGet requestDefaultsField () {
      return this.requestDefaultsField(true);
    }
    public APIRequestGet requestDefaultsField (boolean value) {
      this.requestField("defaults", value);
      return this;
    }
    public APIRequestGet requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGet requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsCbbEnabledField () {
      return this.requestIsCbbEnabledField(true);
    }
    public APIRequestGet requestIsCbbEnabledField (boolean value) {
      this.requestField("is_cbb_enabled", value);
      return this;
    }
    public APIRequestGet requestIsCreateEnabledField () {
      return this.requestIsCreateEnabledField(true);
    }
    public APIRequestGet requestIsCreateEnabledField (boolean value) {
      this.requestField("is_create_enabled", value);
      return this;
    }
    public APIRequestGet requestIsDeleteEnabledField () {
      return this.requestIsDeleteEnabledField(true);
    }
    public APIRequestGet requestIsDeleteEnabledField (boolean value) {
      this.requestField("is_delete_enabled", value);
      return this;
    }
    public APIRequestGet requestIsUpdateEnabledField () {
      return this.requestIsUpdateEnabledField(true);
    }
    public APIRequestGet requestIsUpdateEnabledField (boolean value) {
      this.requestField("is_update_enabled", value);
      return this;
    }
    public APIRequestGet requestMicrodataFormatPrecedenceField () {
      return this.requestMicrodataFormatPrecedenceField(true);
    }
    public APIRequestGet requestMicrodataFormatPrecedenceField (boolean value) {
      this.requestField("microdata_format_precedence", value);
      return this;
    }
    public APIRequestGet requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGet requestPixelField (boolean value) {
      this.requestField("pixel", value);
      return this;
    }
    public APIRequestGet requestPropertyFilterField () {
      return this.requestPropertyFilterField(true);
    }
    public APIRequestGet requestPropertyFilterField (boolean value) {
      this.requestField("property_filter", value);
      return this;
    }
    public APIRequestGet requestRetentionTimeSecField () {
      return this.requestRetentionTimeSecField(true);
    }
    public APIRequestGet requestRetentionTimeSecField (boolean value) {
      this.requestField("retention_time_sec", value);
      return this;
    }
    public APIRequestGet requestTrustedDomainsField () {
      return this.requestTrustedDomainsField(true);
    }
    public APIRequestGet requestTrustedDomainsField (boolean value) {
      this.requestField("trusted_domains", value);
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

  public CatalogSmartPixelSettings copyFrom(CatalogSmartPixelSettings instance) {
    this.mAllowedDomains = instance.mAllowedDomains;
    this.mAvailablePropertyFilters = instance.mAvailablePropertyFilters;
    this.mCatalog = instance.mCatalog;
    this.mCbbCustomOverrideFilters = instance.mCbbCustomOverrideFilters;
    this.mCbbDefaultFilter = instance.mCbbDefaultFilter;
    this.mCbbDefaultFilterCrawlParams = instance.mCbbDefaultFilterCrawlParams;
    this.mCbbOverrideTypeFieldMapping = instance.mCbbOverrideTypeFieldMapping;
    this.mDefaults = instance.mDefaults;
    this.mFilters = instance.mFilters;
    this.mId = instance.mId;
    this.mIsCbbEnabled = instance.mIsCbbEnabled;
    this.mIsCreateEnabled = instance.mIsCreateEnabled;
    this.mIsDeleteEnabled = instance.mIsDeleteEnabled;
    this.mIsUpdateEnabled = instance.mIsUpdateEnabled;
    this.mMicrodataFormatPrecedence = instance.mMicrodataFormatPrecedence;
    this.mPixel = instance.mPixel;
    this.mPropertyFilter = instance.mPropertyFilter;
    this.mRetentionTimeSec = instance.mRetentionTimeSec;
    this.mTrustedDomains = instance.mTrustedDomains;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogSmartPixelSettings> getParser() {
    return new APIRequest.ResponseParser<CatalogSmartPixelSettings>() {
      public APINodeList<CatalogSmartPixelSettings> parseResponse(String response, APIContext context, APIRequest<CatalogSmartPixelSettings> request, String header) throws MalformedResponseException {
        return CatalogSmartPixelSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
