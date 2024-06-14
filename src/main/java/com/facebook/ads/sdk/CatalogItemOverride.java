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
public class CatalogItemOverride extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("local_info")
  private ProductItemLocalInfo mLocalInfo = null;
  @SerializedName("override_type")
  private String mOverrideType = null;
  @SerializedName("override_value")
  private String mOverrideValue = null;
  protected static Gson gson = null;

  CatalogItemOverride() {
  }

  public CatalogItemOverride(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CatalogItemOverride(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CatalogItemOverride fetch() throws APIException{
    CatalogItemOverride newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CatalogItemOverride fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CatalogItemOverride> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CatalogItemOverride fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CatalogItemOverride> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CatalogItemOverride> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CatalogItemOverride>)(
      new APIRequest<CatalogItemOverride>(context, "", "/", "GET", CatalogItemOverride.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CatalogItemOverride>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CatalogItemOverride.getParser())
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
  public static CatalogItemOverride loadJSON(String json, APIContext context, String header) {
    CatalogItemOverride catalogItemOverride = getGson().fromJson(json, CatalogItemOverride.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogItemOverride.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogItemOverride.context = context;
    catalogItemOverride.rawValue = json;
    catalogItemOverride.header = header;
    return catalogItemOverride;
  }

  public static APINodeList<CatalogItemOverride> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogItemOverride> catalogItemOverrides = new APINodeList<CatalogItemOverride>(request, json, header);
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
          catalogItemOverrides.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogItemOverrides;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogItemOverrides.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogItemOverrides.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogItemOverrides.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogItemOverrides.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogItemOverrides.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogItemOverrides.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogItemOverrides;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogItemOverrides.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogItemOverrides;
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
              catalogItemOverrides.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogItemOverrides;
          }

          // Sixth, check if it's pure JsonObject
          catalogItemOverrides.clear();
          catalogItemOverrides.add(loadJSON(json, context, header));
          return catalogItemOverrides;
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


  public String getFieldId() {
    return mId;
  }

  public ProductItemLocalInfo getFieldLocalInfo() {
    if (mLocalInfo != null) {
      mLocalInfo.context = getContext();
    }
    return mLocalInfo;
  }

  public String getFieldOverrideType() {
    return mOverrideType;
  }

  public String getFieldOverrideValue() {
    return mOverrideValue;
  }



  public static class APIRequestGet extends APIRequest<CatalogItemOverride> {

    CatalogItemOverride lastResponse = null;
    @Override
    public CatalogItemOverride getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "local_info",
      "override_type",
      "override_value",
    };

    @Override
    public CatalogItemOverride parseResponse(String response, String header) throws APIException {
      return CatalogItemOverride.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CatalogItemOverride execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CatalogItemOverride execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CatalogItemOverride> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CatalogItemOverride> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CatalogItemOverride>() {
           public CatalogItemOverride apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLocalInfoField () {
      return this.requestLocalInfoField(true);
    }
    public APIRequestGet requestLocalInfoField (boolean value) {
      this.requestField("local_info", value);
      return this;
    }
    public APIRequestGet requestOverrideTypeField () {
      return this.requestOverrideTypeField(true);
    }
    public APIRequestGet requestOverrideTypeField (boolean value) {
      this.requestField("override_type", value);
      return this;
    }
    public APIRequestGet requestOverrideValueField () {
      return this.requestOverrideValueField(true);
    }
    public APIRequestGet requestOverrideValueField (boolean value) {
      this.requestField("override_value", value);
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

  public CatalogItemOverride copyFrom(CatalogItemOverride instance) {
    this.mId = instance.mId;
    this.mLocalInfo = instance.mLocalInfo;
    this.mOverrideType = instance.mOverrideType;
    this.mOverrideValue = instance.mOverrideValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogItemOverride> getParser() {
    return new APIRequest.ResponseParser<CatalogItemOverride>() {
      public APINodeList<CatalogItemOverride> parseResponse(String response, APIContext context, APIRequest<CatalogItemOverride> request, String header) throws MalformedResponseException {
        return CatalogItemOverride.parseResponse(response, context, request, header);
      }
    };
  }
}
