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
public class CPASLsbImageBank extends APINode {
  @SerializedName("ad_group_id")
  private String mAdGroupId = null;
  @SerializedName("catalog_segment_proxy_id")
  private String mCatalogSegmentProxyId = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  CPASLsbImageBank() {
  }

  public CPASLsbImageBank(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASLsbImageBank(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASLsbImageBank fetch() throws APIException{
    CPASLsbImageBank newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASLsbImageBank fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASLsbImageBank> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASLsbImageBank fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASLsbImageBank> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASLsbImageBank> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASLsbImageBank>)(
      new APIRequest<CPASLsbImageBank>(context, "", "/", "GET", CPASLsbImageBank.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASLsbImageBank>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASLsbImageBank.getParser())
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
  public static CPASLsbImageBank loadJSON(String json, APIContext context, String header) {
    CPASLsbImageBank cpasLsbImageBank = getGson().fromJson(json, CPASLsbImageBank.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasLsbImageBank.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasLsbImageBank.context = context;
    cpasLsbImageBank.rawValue = json;
    cpasLsbImageBank.header = header;
    return cpasLsbImageBank;
  }

  public static APINodeList<CPASLsbImageBank> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASLsbImageBank> cpasLsbImageBanks = new APINodeList<CPASLsbImageBank>(request, json, header);
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
          cpasLsbImageBanks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasLsbImageBanks;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasLsbImageBanks.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasLsbImageBanks.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasLsbImageBanks.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasLsbImageBanks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasLsbImageBanks.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasLsbImageBanks.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasLsbImageBanks;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasLsbImageBanks.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasLsbImageBanks;
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
              cpasLsbImageBanks.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasLsbImageBanks;
          }

          // Sixth, check if it's pure JsonObject
          cpasLsbImageBanks.clear();
          cpasLsbImageBanks.add(loadJSON(json, context, header));
          return cpasLsbImageBanks;
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

  public APIRequestGetBackupImages getBackupImages() {
    return new APIRequestGetBackupImages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdGroupId() {
    return mAdGroupId;
  }

  public String getFieldCatalogSegmentProxyId() {
    return mCatalogSegmentProxyId;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGetBackupImages extends APIRequest<ProductImage> {

    APINodeList<ProductImage> lastResponse = null;
    @Override
    public APINodeList<ProductImage> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "height",
      "id",
      "image_url",
      "width",
    };

    @Override
    public APINodeList<ProductImage> parseResponse(String response, String header) throws APIException {
      return ProductImage.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductImage> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductImage> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductImage>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductImage>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductImage>>() {
           public APINodeList<ProductImage> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBackupImages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBackupImages(String nodeId, APIContext context) {
      super(context, nodeId, "/backup_images", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBackupImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBackupImages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBackupImages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBackupImages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBackupImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBackupImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBackupImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBackupImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBackupImages requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetBackupImages requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetBackupImages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBackupImages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBackupImages requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetBackupImages requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetBackupImages requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetBackupImages requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<CPASLsbImageBank> {

    CPASLsbImageBank lastResponse = null;
    @Override
    public CPASLsbImageBank getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_group_id",
      "catalog_segment_proxy_id",
      "id",
    };

    @Override
    public CPASLsbImageBank parseResponse(String response, String header) throws APIException {
      return CPASLsbImageBank.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASLsbImageBank execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASLsbImageBank execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASLsbImageBank> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASLsbImageBank> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASLsbImageBank>() {
           public CPASLsbImageBank apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdGroupIdField () {
      return this.requestAdGroupIdField(true);
    }
    public APIRequestGet requestAdGroupIdField (boolean value) {
      this.requestField("ad_group_id", value);
      return this;
    }
    public APIRequestGet requestCatalogSegmentProxyIdField () {
      return this.requestCatalogSegmentProxyIdField(true);
    }
    public APIRequestGet requestCatalogSegmentProxyIdField (boolean value) {
      this.requestField("catalog_segment_proxy_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<CPASLsbImageBank> {

    CPASLsbImageBank lastResponse = null;
    @Override
    public CPASLsbImageBank getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "backup_image_urls",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CPASLsbImageBank parseResponse(String response, String header) throws APIException {
      return CPASLsbImageBank.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASLsbImageBank execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASLsbImageBank execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASLsbImageBank> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASLsbImageBank> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASLsbImageBank>() {
           public CPASLsbImageBank apply(ResponseWrapper result) {
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


    public APIRequestUpdate setBackupImageUrls (List<String> backupImageUrls) {
      this.setParam("backup_image_urls", backupImageUrls);
      return this;
    }
    public APIRequestUpdate setBackupImageUrls (String backupImageUrls) {
      this.setParam("backup_image_urls", backupImageUrls);
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

  public CPASLsbImageBank copyFrom(CPASLsbImageBank instance) {
    this.mAdGroupId = instance.mAdGroupId;
    this.mCatalogSegmentProxyId = instance.mCatalogSegmentProxyId;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASLsbImageBank> getParser() {
    return new APIRequest.ResponseParser<CPASLsbImageBank>() {
      public APINodeList<CPASLsbImageBank> parseResponse(String response, APIContext context, APIRequest<CPASLsbImageBank> request, String header) throws MalformedResponseException {
        return CPASLsbImageBank.parseResponse(response, context, request, header);
      }
    };
  }
}
