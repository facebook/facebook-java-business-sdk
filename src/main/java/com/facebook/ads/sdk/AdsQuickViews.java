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
public class AdsQuickViews extends APINode {
  @SerializedName("attribution_windows")
  private List<String> mAttributionWindows = null;
  @SerializedName("breakdowns")
  private List<String> mBreakdowns = null;
  @SerializedName("column_fields")
  private List<String> mColumnFields = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner")
  private Profile mOwner = null;
  @SerializedName("permission")
  private String mPermission = null;
  @SerializedName("quick_view_type")
  private String mQuickViewType = null;
  @SerializedName("sort")
  private List<Object> mSort = null;
  @SerializedName("time_stamp_last_used_by_owner")
  private String mTimeStampLastUsedByOwner = null;
  protected static Gson gson = null;

  AdsQuickViews() {
  }

  public AdsQuickViews(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsQuickViews(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsQuickViews fetch() throws APIException{
    AdsQuickViews newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsQuickViews fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsQuickViews> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsQuickViews fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsQuickViews> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsQuickViews> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsQuickViews>)(
      new APIRequest<AdsQuickViews>(context, "", "/", "GET", AdsQuickViews.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsQuickViews>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsQuickViews.getParser())
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
  public static AdsQuickViews loadJSON(String json, APIContext context, String header) {
    AdsQuickViews adsQuickViews = getGson().fromJson(json, AdsQuickViews.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsQuickViews.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsQuickViews.context = context;
    adsQuickViews.rawValue = json;
    adsQuickViews.header = header;
    return adsQuickViews;
  }

  public static APINodeList<AdsQuickViews> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsQuickViews> adsQuickViewss = new APINodeList<AdsQuickViews>(request, json, header);
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
          adsQuickViewss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsQuickViewss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsQuickViewss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsQuickViewss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsQuickViewss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsQuickViewss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsQuickViewss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsQuickViewss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsQuickViewss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsQuickViewss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsQuickViewss;
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
              adsQuickViewss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsQuickViewss;
          }

          // Sixth, check if it's pure JsonObject
          adsQuickViewss.clear();
          adsQuickViewss.add(loadJSON(json, context, header));
          return adsQuickViewss;
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


  public List<String> getFieldAttributionWindows() {
    return mAttributionWindows;
  }

  public List<String> getFieldBreakdowns() {
    return mBreakdowns;
  }

  public List<String> getFieldColumnFields() {
    return mColumnFields;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public Profile getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldPermission() {
    return mPermission;
  }

  public String getFieldQuickViewType() {
    return mQuickViewType;
  }

  public List<Object> getFieldSort() {
    return mSort;
  }

  public String getFieldTimeStampLastUsedByOwner() {
    return mTimeStampLastUsedByOwner;
  }



  public static class APIRequestGet extends APIRequest<AdsQuickViews> {

    AdsQuickViews lastResponse = null;
    @Override
    public AdsQuickViews getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribution_windows",
      "breakdowns",
      "column_fields",
      "description",
      "id",
      "name",
      "owner",
      "permission",
      "quick_view_type",
      "sort",
      "time_stamp_last_used_by_owner",
    };

    @Override
    public AdsQuickViews parseResponse(String response, String header) throws APIException {
      return AdsQuickViews.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsQuickViews execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsQuickViews execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsQuickViews> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsQuickViews> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsQuickViews>() {
           public AdsQuickViews apply(ResponseWrapper result) {
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

    public APIRequestGet requestAttributionWindowsField () {
      return this.requestAttributionWindowsField(true);
    }
    public APIRequestGet requestAttributionWindowsField (boolean value) {
      this.requestField("attribution_windows", value);
      return this;
    }
    public APIRequestGet requestBreakdownsField () {
      return this.requestBreakdownsField(true);
    }
    public APIRequestGet requestBreakdownsField (boolean value) {
      this.requestField("breakdowns", value);
      return this;
    }
    public APIRequestGet requestColumnFieldsField () {
      return this.requestColumnFieldsField(true);
    }
    public APIRequestGet requestColumnFieldsField (boolean value) {
      this.requestField("column_fields", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
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
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPermissionField () {
      return this.requestPermissionField(true);
    }
    public APIRequestGet requestPermissionField (boolean value) {
      this.requestField("permission", value);
      return this;
    }
    public APIRequestGet requestQuickViewTypeField () {
      return this.requestQuickViewTypeField(true);
    }
    public APIRequestGet requestQuickViewTypeField (boolean value) {
      this.requestField("quick_view_type", value);
      return this;
    }
    public APIRequestGet requestSortField () {
      return this.requestSortField(true);
    }
    public APIRequestGet requestSortField (boolean value) {
      this.requestField("sort", value);
      return this;
    }
    public APIRequestGet requestTimeStampLastUsedByOwnerField () {
      return this.requestTimeStampLastUsedByOwnerField(true);
    }
    public APIRequestGet requestTimeStampLastUsedByOwnerField (boolean value) {
      this.requestField("time_stamp_last_used_by_owner", value);
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

  public AdsQuickViews copyFrom(AdsQuickViews instance) {
    this.mAttributionWindows = instance.mAttributionWindows;
    this.mBreakdowns = instance.mBreakdowns;
    this.mColumnFields = instance.mColumnFields;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mOwner = instance.mOwner;
    this.mPermission = instance.mPermission;
    this.mQuickViewType = instance.mQuickViewType;
    this.mSort = instance.mSort;
    this.mTimeStampLastUsedByOwner = instance.mTimeStampLastUsedByOwner;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsQuickViews> getParser() {
    return new APIRequest.ResponseParser<AdsQuickViews>() {
      public APINodeList<AdsQuickViews> parseResponse(String response, APIContext context, APIRequest<AdsQuickViews> request, String header) throws MalformedResponseException {
        return AdsQuickViews.parseResponse(response, context, request, header);
      }
    };
  }
}
