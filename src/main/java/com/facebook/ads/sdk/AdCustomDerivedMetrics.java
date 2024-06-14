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
public class AdCustomDerivedMetrics extends APINode {
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private Profile mCreator = null;
  @SerializedName("custom_derived_metric_type")
  private String mCustomDerivedMetricType = null;
  @SerializedName("deletion_time")
  private String mDeletionTime = null;
  @SerializedName("deletor")
  private Profile mDeletor = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("format_type")
  private String mFormatType = null;
  @SerializedName("formula")
  private String mFormula = null;
  @SerializedName("has_attribution_windows")
  private Boolean mHasAttributionWindows = null;
  @SerializedName("has_inline_attribution_window")
  private Boolean mHasInlineAttributionWindow = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("permission")
  private String mPermission = null;
  @SerializedName("saved_report_id")
  private String mSavedReportId = null;
  @SerializedName("scope")
  private String mScope = null;
  protected static Gson gson = null;

  AdCustomDerivedMetrics() {
  }

  public AdCustomDerivedMetrics(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCustomDerivedMetrics(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCustomDerivedMetrics fetch() throws APIException{
    AdCustomDerivedMetrics newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCustomDerivedMetrics fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCustomDerivedMetrics> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCustomDerivedMetrics fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCustomDerivedMetrics> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCustomDerivedMetrics> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCustomDerivedMetrics>)(
      new APIRequest<AdCustomDerivedMetrics>(context, "", "/", "GET", AdCustomDerivedMetrics.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCustomDerivedMetrics>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCustomDerivedMetrics.getParser())
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
  public static AdCustomDerivedMetrics loadJSON(String json, APIContext context, String header) {
    AdCustomDerivedMetrics adCustomDerivedMetrics = getGson().fromJson(json, AdCustomDerivedMetrics.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCustomDerivedMetrics.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCustomDerivedMetrics.context = context;
    adCustomDerivedMetrics.rawValue = json;
    adCustomDerivedMetrics.header = header;
    return adCustomDerivedMetrics;
  }

  public static APINodeList<AdCustomDerivedMetrics> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCustomDerivedMetrics> adCustomDerivedMetricss = new APINodeList<AdCustomDerivedMetrics>(request, json, header);
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
          adCustomDerivedMetricss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCustomDerivedMetricss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCustomDerivedMetricss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCustomDerivedMetricss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCustomDerivedMetricss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCustomDerivedMetricss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCustomDerivedMetricss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCustomDerivedMetricss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCustomDerivedMetricss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCustomDerivedMetricss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCustomDerivedMetricss;
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
              adCustomDerivedMetricss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCustomDerivedMetricss;
          }

          // Sixth, check if it's pure JsonObject
          adCustomDerivedMetricss.clear();
          adCustomDerivedMetricss.add(loadJSON(json, context, header));
          return adCustomDerivedMetricss;
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public Profile getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldCustomDerivedMetricType() {
    return mCustomDerivedMetricType;
  }

  public String getFieldDeletionTime() {
    return mDeletionTime;
  }

  public Profile getFieldDeletor() {
    if (mDeletor != null) {
      mDeletor.context = getContext();
    }
    return mDeletor;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldFormatType() {
    return mFormatType;
  }

  public String getFieldFormula() {
    return mFormula;
  }

  public Boolean getFieldHasAttributionWindows() {
    return mHasAttributionWindows;
  }

  public Boolean getFieldHasInlineAttributionWindow() {
    return mHasInlineAttributionWindow;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPermission() {
    return mPermission;
  }

  public String getFieldSavedReportId() {
    return mSavedReportId;
  }

  public String getFieldScope() {
    return mScope;
  }



  public static class APIRequestGet extends APIRequest<AdCustomDerivedMetrics> {

    AdCustomDerivedMetrics lastResponse = null;
    @Override
    public AdCustomDerivedMetrics getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_id",
      "business",
      "creation_time",
      "creator",
      "custom_derived_metric_type",
      "deletion_time",
      "deletor",
      "description",
      "format_type",
      "formula",
      "has_attribution_windows",
      "has_inline_attribution_window",
      "id",
      "name",
      "permission",
      "saved_report_id",
      "scope",
    };

    @Override
    public AdCustomDerivedMetrics parseResponse(String response, String header) throws APIException {
      return AdCustomDerivedMetrics.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCustomDerivedMetrics execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCustomDerivedMetrics execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCustomDerivedMetrics> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCustomDerivedMetrics> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCustomDerivedMetrics>() {
           public AdCustomDerivedMetrics apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestCustomDerivedMetricTypeField () {
      return this.requestCustomDerivedMetricTypeField(true);
    }
    public APIRequestGet requestCustomDerivedMetricTypeField (boolean value) {
      this.requestField("custom_derived_metric_type", value);
      return this;
    }
    public APIRequestGet requestDeletionTimeField () {
      return this.requestDeletionTimeField(true);
    }
    public APIRequestGet requestDeletionTimeField (boolean value) {
      this.requestField("deletion_time", value);
      return this;
    }
    public APIRequestGet requestDeletorField () {
      return this.requestDeletorField(true);
    }
    public APIRequestGet requestDeletorField (boolean value) {
      this.requestField("deletor", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFormatTypeField () {
      return this.requestFormatTypeField(true);
    }
    public APIRequestGet requestFormatTypeField (boolean value) {
      this.requestField("format_type", value);
      return this;
    }
    public APIRequestGet requestFormulaField () {
      return this.requestFormulaField(true);
    }
    public APIRequestGet requestFormulaField (boolean value) {
      this.requestField("formula", value);
      return this;
    }
    public APIRequestGet requestHasAttributionWindowsField () {
      return this.requestHasAttributionWindowsField(true);
    }
    public APIRequestGet requestHasAttributionWindowsField (boolean value) {
      this.requestField("has_attribution_windows", value);
      return this;
    }
    public APIRequestGet requestHasInlineAttributionWindowField () {
      return this.requestHasInlineAttributionWindowField(true);
    }
    public APIRequestGet requestHasInlineAttributionWindowField (boolean value) {
      this.requestField("has_inline_attribution_window", value);
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
    public APIRequestGet requestPermissionField () {
      return this.requestPermissionField(true);
    }
    public APIRequestGet requestPermissionField (boolean value) {
      this.requestField("permission", value);
      return this;
    }
    public APIRequestGet requestSavedReportIdField () {
      return this.requestSavedReportIdField(true);
    }
    public APIRequestGet requestSavedReportIdField (boolean value) {
      this.requestField("saved_report_id", value);
      return this;
    }
    public APIRequestGet requestScopeField () {
      return this.requestScopeField(true);
    }
    public APIRequestGet requestScopeField (boolean value) {
      this.requestField("scope", value);
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

  public AdCustomDerivedMetrics copyFrom(AdCustomDerivedMetrics instance) {
    this.mAdAccountId = instance.mAdAccountId;
    this.mBusiness = instance.mBusiness;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mCustomDerivedMetricType = instance.mCustomDerivedMetricType;
    this.mDeletionTime = instance.mDeletionTime;
    this.mDeletor = instance.mDeletor;
    this.mDescription = instance.mDescription;
    this.mFormatType = instance.mFormatType;
    this.mFormula = instance.mFormula;
    this.mHasAttributionWindows = instance.mHasAttributionWindows;
    this.mHasInlineAttributionWindow = instance.mHasInlineAttributionWindow;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPermission = instance.mPermission;
    this.mSavedReportId = instance.mSavedReportId;
    this.mScope = instance.mScope;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCustomDerivedMetrics> getParser() {
    return new APIRequest.ResponseParser<AdCustomDerivedMetrics>() {
      public APINodeList<AdCustomDerivedMetrics> parseResponse(String response, APIContext context, APIRequest<AdCustomDerivedMetrics> request, String header) throws MalformedResponseException {
        return AdCustomDerivedMetrics.parseResponse(response, context, request, header);
      }
    };
  }
}
