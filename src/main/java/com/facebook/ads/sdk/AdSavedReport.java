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
public class AdSavedReport extends APINode {
  @SerializedName("app_owner")
  private Application mAppOwner = null;
  @SerializedName("breakdowns")
  private List<String> mBreakdowns = null;
  @SerializedName("builtin_column_set")
  private String mBuiltinColumnSet = null;
  @SerializedName("creation_source")
  private String mCreationSource = null;
  @SerializedName("date_interval")
  private Object mDateInterval = null;
  @SerializedName("date_preset")
  private String mDatePreset = null;
  @SerializedName("format_version")
  private Long mFormatVersion = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("insights_section")
  private Object mInsightsSection = null;
  @SerializedName("is_shared_unread")
  private Boolean mIsSharedUnread = null;
  @SerializedName("level")
  private String mLevel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("normalized_filter")
  private JsonArray mNormalizedFilter = null;
  @SerializedName("sort")
  private List<Object> mSort = null;
  @SerializedName("user_attribution_windows")
  private List<String> mUserAttributionWindows = null;
  @SerializedName("user_columns")
  private List<String> mUserColumns = null;
  @SerializedName("user_filter")
  private JsonArray mUserFilter = null;
  @SerializedName("user_owner")
  private User mUserOwner = null;
  protected static Gson gson = null;

  AdSavedReport() {
  }

  public AdSavedReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdSavedReport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdSavedReport fetch() throws APIException{
    AdSavedReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdSavedReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdSavedReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdSavedReport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdSavedReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdSavedReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdSavedReport>)(
      new APIRequest<AdSavedReport>(context, "", "/", "GET", AdSavedReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdSavedReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdSavedReport.getParser())
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
  public static AdSavedReport loadJSON(String json, APIContext context, String header) {
    AdSavedReport adSavedReport = getGson().fromJson(json, AdSavedReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adSavedReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adSavedReport.context = context;
    adSavedReport.rawValue = json;
    adSavedReport.header = header;
    return adSavedReport;
  }

  public static APINodeList<AdSavedReport> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdSavedReport> adSavedReports = new APINodeList<AdSavedReport>(request, json, header);
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
          adSavedReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adSavedReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adSavedReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adSavedReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adSavedReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adSavedReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adSavedReports.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adSavedReports.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adSavedReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adSavedReports.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adSavedReports;
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
              adSavedReports.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adSavedReports;
          }

          // Sixth, check if it's pure JsonObject
          adSavedReports.clear();
          adSavedReports.add(loadJSON(json, context, header));
          return adSavedReports;
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


  public Application getFieldAppOwner() {
    if (mAppOwner != null) {
      mAppOwner.context = getContext();
    }
    return mAppOwner;
  }

  public List<String> getFieldBreakdowns() {
    return mBreakdowns;
  }

  public String getFieldBuiltinColumnSet() {
    return mBuiltinColumnSet;
  }

  public String getFieldCreationSource() {
    return mCreationSource;
  }

  public Object getFieldDateInterval() {
    return mDateInterval;
  }

  public String getFieldDatePreset() {
    return mDatePreset;
  }

  public Long getFieldFormatVersion() {
    return mFormatVersion;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldInsightsSection() {
    return mInsightsSection;
  }

  public Boolean getFieldIsSharedUnread() {
    return mIsSharedUnread;
  }

  public String getFieldLevel() {
    return mLevel;
  }

  public String getFieldName() {
    return mName;
  }

  public JsonArray getFieldNormalizedFilter() {
    return mNormalizedFilter;
  }

  public List<Object> getFieldSort() {
    return mSort;
  }

  public List<String> getFieldUserAttributionWindows() {
    return mUserAttributionWindows;
  }

  public List<String> getFieldUserColumns() {
    return mUserColumns;
  }

  public JsonArray getFieldUserFilter() {
    return mUserFilter;
  }

  public User getFieldUserOwner() {
    if (mUserOwner != null) {
      mUserOwner.context = getContext();
    }
    return mUserOwner;
  }



  public static class APIRequestGet extends APIRequest<AdSavedReport> {

    AdSavedReport lastResponse = null;
    @Override
    public AdSavedReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "app_owner",
      "breakdowns",
      "builtin_column_set",
      "creation_source",
      "date_interval",
      "date_preset",
      "format_version",
      "id",
      "insights_section",
      "is_shared_unread",
      "level",
      "name",
      "normalized_filter",
      "sort",
      "user_attribution_windows",
      "user_columns",
      "user_filter",
      "user_owner",
    };

    @Override
    public AdSavedReport parseResponse(String response, String header) throws APIException {
      return AdSavedReport.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdSavedReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdSavedReport execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdSavedReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdSavedReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdSavedReport>() {
           public AdSavedReport apply(ResponseWrapper result) {
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

    public APIRequestGet requestAppOwnerField () {
      return this.requestAppOwnerField(true);
    }
    public APIRequestGet requestAppOwnerField (boolean value) {
      this.requestField("app_owner", value);
      return this;
    }
    public APIRequestGet requestBreakdownsField () {
      return this.requestBreakdownsField(true);
    }
    public APIRequestGet requestBreakdownsField (boolean value) {
      this.requestField("breakdowns", value);
      return this;
    }
    public APIRequestGet requestBuiltinColumnSetField () {
      return this.requestBuiltinColumnSetField(true);
    }
    public APIRequestGet requestBuiltinColumnSetField (boolean value) {
      this.requestField("builtin_column_set", value);
      return this;
    }
    public APIRequestGet requestCreationSourceField () {
      return this.requestCreationSourceField(true);
    }
    public APIRequestGet requestCreationSourceField (boolean value) {
      this.requestField("creation_source", value);
      return this;
    }
    public APIRequestGet requestDateIntervalField () {
      return this.requestDateIntervalField(true);
    }
    public APIRequestGet requestDateIntervalField (boolean value) {
      this.requestField("date_interval", value);
      return this;
    }
    public APIRequestGet requestDatePresetField () {
      return this.requestDatePresetField(true);
    }
    public APIRequestGet requestDatePresetField (boolean value) {
      this.requestField("date_preset", value);
      return this;
    }
    public APIRequestGet requestFormatVersionField () {
      return this.requestFormatVersionField(true);
    }
    public APIRequestGet requestFormatVersionField (boolean value) {
      this.requestField("format_version", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInsightsSectionField () {
      return this.requestInsightsSectionField(true);
    }
    public APIRequestGet requestInsightsSectionField (boolean value) {
      this.requestField("insights_section", value);
      return this;
    }
    public APIRequestGet requestIsSharedUnreadField () {
      return this.requestIsSharedUnreadField(true);
    }
    public APIRequestGet requestIsSharedUnreadField (boolean value) {
      this.requestField("is_shared_unread", value);
      return this;
    }
    public APIRequestGet requestLevelField () {
      return this.requestLevelField(true);
    }
    public APIRequestGet requestLevelField (boolean value) {
      this.requestField("level", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNormalizedFilterField () {
      return this.requestNormalizedFilterField(true);
    }
    public APIRequestGet requestNormalizedFilterField (boolean value) {
      this.requestField("normalized_filter", value);
      return this;
    }
    public APIRequestGet requestSortField () {
      return this.requestSortField(true);
    }
    public APIRequestGet requestSortField (boolean value) {
      this.requestField("sort", value);
      return this;
    }
    public APIRequestGet requestUserAttributionWindowsField () {
      return this.requestUserAttributionWindowsField(true);
    }
    public APIRequestGet requestUserAttributionWindowsField (boolean value) {
      this.requestField("user_attribution_windows", value);
      return this;
    }
    public APIRequestGet requestUserColumnsField () {
      return this.requestUserColumnsField(true);
    }
    public APIRequestGet requestUserColumnsField (boolean value) {
      this.requestField("user_columns", value);
      return this;
    }
    public APIRequestGet requestUserFilterField () {
      return this.requestUserFilterField(true);
    }
    public APIRequestGet requestUserFilterField (boolean value) {
      this.requestField("user_filter", value);
      return this;
    }
    public APIRequestGet requestUserOwnerField () {
      return this.requestUserOwnerField(true);
    }
    public APIRequestGet requestUserOwnerField (boolean value) {
      this.requestField("user_owner", value);
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

  public AdSavedReport copyFrom(AdSavedReport instance) {
    this.mAppOwner = instance.mAppOwner;
    this.mBreakdowns = instance.mBreakdowns;
    this.mBuiltinColumnSet = instance.mBuiltinColumnSet;
    this.mCreationSource = instance.mCreationSource;
    this.mDateInterval = instance.mDateInterval;
    this.mDatePreset = instance.mDatePreset;
    this.mFormatVersion = instance.mFormatVersion;
    this.mId = instance.mId;
    this.mInsightsSection = instance.mInsightsSection;
    this.mIsSharedUnread = instance.mIsSharedUnread;
    this.mLevel = instance.mLevel;
    this.mName = instance.mName;
    this.mNormalizedFilter = instance.mNormalizedFilter;
    this.mSort = instance.mSort;
    this.mUserAttributionWindows = instance.mUserAttributionWindows;
    this.mUserColumns = instance.mUserColumns;
    this.mUserFilter = instance.mUserFilter;
    this.mUserOwner = instance.mUserOwner;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdSavedReport> getParser() {
    return new APIRequest.ResponseParser<AdSavedReport>() {
      public APINodeList<AdSavedReport> parseResponse(String response, APIContext context, APIRequest<AdSavedReport> request, String header) throws MalformedResponseException {
        return AdSavedReport.parseResponse(response, context, request, header);
      }
    };
  }
}
